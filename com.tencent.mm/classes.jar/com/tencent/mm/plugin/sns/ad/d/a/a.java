package com.tencent.mm.plugin.sns.ad.d.a;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.brandservice.a.e.a;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
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
    AppMethodBeat.i(201878);
    if (c.isEmpty(paramCollection))
    {
      AppMethodBeat.o(201878);
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
          paramCollection = ap.n(str, new String[] { "traceid=" + paramString1 + "&aid=" + paramString2 });
        }
      }
      if (TextUtils.isEmpty(paramString3)) {
        Log.i("SnsAd.H5PrefetchHelper", "processNativeLandingH5PrefetchUrl, use orig_UxInfo:".concat(String.valueOf(paramString4)));
      }
      for (str = paramString4;; str = paramString3)
      {
        paramCollection = aNC(r.kb(paramCollection, str));
        if (TextUtils.isEmpty(paramCollection)) {
          break;
        }
        localLinkedList.add(paramCollection);
        break;
        Log.i("SnsAd.H5PrefetchHelper", "processNativeLandingH5PrefetchUrl, use updated_UxInfo:".concat(String.valueOf(paramString3)));
      }
    }
    paramCollection = (String[])localLinkedList.toArray(new String[0]);
    AppMethodBeat.o(201878);
    return paramCollection;
  }
  
  public static String aNC(String paramString)
  {
    AppMethodBeat.i(201875);
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(201875);
        return "";
      }
      paramString = Uri.parse(paramString);
      if ((paramString != null) && ("1".equals(paramString.getQueryParameter("canPrefetch"))))
      {
        paramString = paramString.buildUpon().appendQueryParameter("prefetch", "1").build().toString();
        AppMethodBeat.o(201875);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(201875);
      return "";
    }
    AppMethodBeat.o(201875);
    return "";
  }
  
  public static String aND(String paramString)
  {
    AppMethodBeat.i(201876);
    String str = aNC(paramString);
    if (!TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(201876);
      return str;
    }
    Log.d("SnsAd.H5PrefetchHelper", "the usePrefetch return value is ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(201876);
    return paramString;
  }
  
  public static void gL(List<String> paramList)
  {
    AppMethodBeat.i(201877);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      e.a locala = new e.a();
      locala.url = str;
      locala.pmM = 181;
      localArrayList.add(locala);
    }
    paramList = (e)g.af(e.class);
    if (paramList != null)
    {
      paramList.cu(localArrayList);
      Log.d("SnsAd.H5PrefetchHelper", "the h5 prefetch is done");
    }
    AppMethodBeat.o(201877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.a.a
 * JD-Core Version:    0.7.0.1
 */