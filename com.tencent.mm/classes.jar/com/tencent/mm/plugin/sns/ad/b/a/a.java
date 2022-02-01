package com.tencent.mm.plugin.sns.ad.b.a;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.plugin.sns.ad.f.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static String[] a(Collection<String> paramCollection, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(218988);
    if (c.isEmpty(paramCollection))
    {
      AppMethodBeat.o(218988);
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
          paramCollection = an.n(str, new String[] { "traceid=" + paramString1 + "&aid=" + paramString2 });
        }
      }
      if (TextUtils.isEmpty(paramString3)) {
        ae.i("SnsAd.H5PrefetchHelper", "processNativeLandingH5PrefetchUrl, use orig_UxInfo:".concat(String.valueOf(paramString4)));
      }
      for (str = paramString4;; str = paramString3)
      {
        paramCollection = ayS(r.jo(paramCollection, str));
        if (TextUtils.isEmpty(paramCollection)) {
          break;
        }
        localLinkedList.add(paramCollection);
        break;
        ae.i("SnsAd.H5PrefetchHelper", "processNativeLandingH5PrefetchUrl, use updated_UxInfo:".concat(String.valueOf(paramString3)));
      }
    }
    paramCollection = (String[])localLinkedList.toArray(new String[0]);
    AppMethodBeat.o(218988);
    return paramCollection;
  }
  
  public static String ayS(String paramString)
  {
    AppMethodBeat.i(218985);
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(218985);
        return "";
      }
      paramString = Uri.parse(paramString);
      if ((paramString != null) && ("1".equals(paramString.getQueryParameter("canPrefetch"))))
      {
        paramString = paramString.buildUpon().appendQueryParameter("prefetch", "1").build().toString();
        AppMethodBeat.o(218985);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(218985);
      return "";
    }
    AppMethodBeat.o(218985);
    return "";
  }
  
  public static String ayT(String paramString)
  {
    AppMethodBeat.i(218986);
    String str = ayS(paramString);
    if (!TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(218986);
      return str;
    }
    ae.d("SnsAd.H5PrefetchHelper", "the usePrefetch return value is ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(218986);
    return paramString;
  }
  
  public static void fN(List<String> paramList)
  {
    AppMethodBeat.i(218987);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      d.a locala = new d.a();
      locala.url = str;
      locala.obQ = 181;
      localArrayList.add(locala);
    }
    paramList = (d)g.ab(d.class);
    if (paramList != null)
    {
      paramList.cf(localArrayList);
      ae.d("SnsAd.H5PrefetchHelper", "the h5 prefetch is done");
    }
    AppMethodBeat.o(218987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.b.a.a
 * JD-Core Version:    0.7.0.1
 */