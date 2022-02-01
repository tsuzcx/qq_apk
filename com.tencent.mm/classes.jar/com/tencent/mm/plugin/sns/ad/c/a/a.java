package com.tencent.mm.plugin.sns.ad.c.a;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.api.h.a;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
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
    AppMethodBeat.i(309929);
    if (d.isEmpty(paramCollection))
    {
      AppMethodBeat.o(309929);
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
          paramCollection = ar.n(str, new String[] { "traceid=" + paramString1 + "&aid=" + paramString2 });
        }
      }
      if (TextUtils.isEmpty(paramString3)) {
        Log.i("SnsAd.H5PrefetchHelper", "processNativeLandingH5PrefetchUrl, use orig_UxInfo:".concat(String.valueOf(paramString4)));
      }
      for (str = paramString4;; str = paramString3)
      {
        paramCollection = aWi(t.lY(paramCollection, str));
        if (TextUtils.isEmpty(paramCollection)) {
          break;
        }
        localLinkedList.add(paramCollection);
        break;
        Log.i("SnsAd.H5PrefetchHelper", "processNativeLandingH5PrefetchUrl, use updated_UxInfo:".concat(String.valueOf(paramString3)));
      }
    }
    paramCollection = (String[])localLinkedList.toArray(new String[0]);
    AppMethodBeat.o(309929);
    return paramCollection;
  }
  
  public static String aWi(String paramString)
  {
    AppMethodBeat.i(309910);
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(309910);
        return "";
      }
      paramString = Uri.parse(paramString);
      if ((paramString != null) && ("1".equals(paramString.getQueryParameter("canPrefetch")))) {
        paramString = paramString.buildUpon().appendQueryParameter("prefetch", "1").build().toString();
      }
    }
    finally
    {
      AppMethodBeat.o(309910);
      return "";
    }
    AppMethodBeat.o(309910);
    return "";
  }
  
  public static String aWj(String paramString)
  {
    AppMethodBeat.i(309913);
    String str = aWi(paramString);
    if (!TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(309913);
      return str;
    }
    Log.d("SnsAd.H5PrefetchHelper", "the usePrefetch return value is ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(309913);
    return paramString;
  }
  
  public static void kt(List<String> paramList)
  {
    AppMethodBeat.i(309919);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      h.a locala = new h.a();
      locala.url = str;
      locala.vAZ = 181;
      localArrayList.add(locala);
    }
    com.tencent.mm.plugin.report.service.h.OAn.p(1612L, 44L, localArrayList.size());
    paramList = (com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class);
    if (paramList != null)
    {
      paramList.ei(localArrayList);
      Log.d("SnsAd.H5PrefetchHelper", "the h5 prefetch is done");
    }
    AppMethodBeat.o(309919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.a.a
 * JD-Core Version:    0.7.0.1
 */