package com.tencent.mm.plugin.sns.ad.c.a;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.a.f;
import com.tencent.mm.plugin.brandservice.a.f.a;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static String[] a(Collection<String> paramCollection, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(204024);
    if (d.isEmpty(paramCollection))
    {
      AppMethodBeat.o(204024);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramCollection.iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramCollection = str;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramCollection = str;
        if (!TextUtils.isEmpty(paramString2)) {
          paramCollection = ao.m(str, new String[] { "traceid=" + paramString1 + "&aid=" + paramString2 });
        }
      }
      if (TextUtils.isEmpty(paramString3)) {
        Log.i("SnsAd.H5PrefetchHelper", "processNativeLandingH5PrefetchUrl, use orig_UxInfo:".concat(String.valueOf(paramString4)));
      }
      for (str = paramString4;; str = paramString3)
      {
        paramCollection = aYn(t.kw(paramCollection, str));
        if (TextUtils.isEmpty(paramCollection)) {
          break;
        }
        localLinkedList.add(paramCollection);
        break;
        Log.i("SnsAd.H5PrefetchHelper", "processNativeLandingH5PrefetchUrl, use updated_UxInfo:".concat(String.valueOf(paramString3)));
      }
    }
    paramCollection = (String[])localLinkedList.toArray(new String[0]);
    AppMethodBeat.o(204024);
    return paramCollection;
  }
  
  public static String aYn(String paramString)
  {
    AppMethodBeat.i(204021);
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(204021);
        return "";
      }
      paramString = Uri.parse(paramString);
      if ((paramString != null) && ("1".equals(paramString.getQueryParameter("canPrefetch"))))
      {
        paramString = paramString.buildUpon().appendQueryParameter("prefetch", "1").build().toString();
        AppMethodBeat.o(204021);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(204021);
      return "";
    }
    AppMethodBeat.o(204021);
    return "";
  }
  
  public static String aYo(String paramString)
  {
    AppMethodBeat.i(204022);
    String str = aYn(paramString);
    if (!TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(204022);
      return str;
    }
    Log.d("SnsAd.H5PrefetchHelper", "the usePrefetch return value is ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(204022);
    return paramString;
  }
  
  public static void hr(List<String> paramList)
  {
    AppMethodBeat.i(204023);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      f.a locala = new f.a();
      locala.url = str;
      locala.svv = 181;
      localArrayList.add(locala);
    }
    com.tencent.mm.plugin.report.service.h.IzE.p(1612L, 44L, localArrayList.size());
    paramList = (f)com.tencent.mm.kernel.h.ae(f.class);
    if (paramList != null)
    {
      paramList.cq(localArrayList);
      Log.d("SnsAd.H5PrefetchHelper", "the h5 prefetch is done");
    }
    AppMethodBeat.o(204023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.a.a
 * JD-Core Version:    0.7.0.1
 */