package com.tencent.thumbplayer.a;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.k;
import com.tencent.thumbplayer.b.n;
import com.tencent.thumbplayer.utils.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  private Map<String, d> LWh;
  Map<String, a> LWi;
  ArrayList<c> LWj;
  private Map<Integer, com.tencent.thumbplayer.b.f> LWk;
  public f LWl;
  public b LWm;
  public boolean LWn;
  public float LWo;
  public float LWp;
  public Map<Integer, n> LWq;
  ArrayList<n> LWr;
  k LWs;
  public Surface mSurface;
  int trackId;
  
  public c()
  {
    AppMethodBeat.i(191541);
    this.trackId = -1;
    this.LWh = new HashMap(0);
    this.LWi = new HashMap(0);
    this.LWl = new f();
    this.LWk = new HashMap(0);
    this.LWq = new HashMap(0);
    this.LWr = new ArrayList();
    this.LWj = new ArrayList();
    AppMethodBeat.o(191541);
  }
  
  public final void a(int paramInt, long paramLong, n paramn)
  {
    AppMethodBeat.i(191549);
    this.LWq.put(Integer.valueOf(paramn.trackType), paramn);
    if ((paramInt < 0) || (paramInt >= this.LWr.size()))
    {
      d.w("TPPlaybackParams", "track Index:" + paramInt + " is invalid, trackInfoList size:" + this.LWr.size());
      AppMethodBeat.o(191549);
      return;
    }
    c localc = new c();
    localc.trackIndex = paramInt;
    localc.LWx = paramLong;
    Iterator localIterator = this.LWr.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.trackType == paramn.trackType) {
        if (((TextUtils.isEmpty(localn.name)) && (TextUtils.isEmpty(paramn.name))) || (localn.name.equals(paramn.name)))
        {
          localn.isSelected = true;
          localc.LWy = localn;
        }
        else
        {
          localn.isSelected = false;
        }
      }
    }
    this.LWj.add(localc);
    AppMethodBeat.o(191549);
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(191550);
    this.LWq.remove(Integer.valueOf(paramn.trackType));
    if ((paramInt < 0) || (paramInt >= this.LWr.size()))
    {
      d.w("TPPlaybackParams", "track Index:" + paramInt + " is invalid, trackInfoList size:" + this.LWr.size());
      AppMethodBeat.o(191550);
      return;
    }
    Iterator localIterator = this.LWr.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (n)localIterator.next();
      if ((((n)localObject).trackType == paramn.trackType) && (((TextUtils.isEmpty(((n)localObject).name)) && (TextUtils.isEmpty(paramn.name))) || (((n)localObject).name.equals(paramn.name)))) {
        ((n)localObject).isSelected = false;
      }
    }
    localIterator = this.LWj.iterator();
    while (localIterator.hasNext())
    {
      localObject = (c)localIterator.next();
      if ((((c)localObject).LWy != null) && (((c)localObject).LWy.equals(paramn)))
      {
        this.LWj.remove(localObject);
        AppMethodBeat.o(191550);
        return;
      }
    }
    AppMethodBeat.o(191550);
  }
  
  public final void a(com.tencent.thumbplayer.b.f paramf)
  {
    AppMethodBeat.i(191543);
    if (paramf != null) {
      this.LWk.put(Integer.valueOf(paramf.key), paramf);
    }
    AppMethodBeat.o(191543);
  }
  
  public final com.tencent.thumbplayer.b.f agV(int paramInt)
  {
    AppMethodBeat.i(191556);
    com.tencent.thumbplayer.b.f localf = (com.tencent.thumbplayer.b.f)this.LWk.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(191556);
    return localf;
  }
  
  public final void b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(191548);
    f localf = this.LWl;
    localf.mUrl = null;
    localf.mType = 1;
    localf.mHttpHeaders.clear();
    localf.LWV = paramParcelFileDescriptor;
    AppMethodBeat.o(191548);
  }
  
  public final void bk(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(191551);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(191551);
      return;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      AppMethodBeat.o(191551);
      return;
    }
    d locald = new d();
    locald.url = paramString1;
    locald.mimeType = paramString2;
    locald.name = paramString3;
    this.LWh.put(paramString1, locald);
    this.trackId += 1;
    paramString1 = new n();
    paramString1.trackType = 3;
    paramString1.name = paramString3;
    paramString1.isSelected = false;
    paramString1.isExclusive = true;
    paramString1.isInternal = false;
    this.LWr.add(paramString1);
    AppMethodBeat.o(191551);
  }
  
  public final void c(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191545);
    if (this.LWm == null) {
      this.LWm = new b();
    }
    this.LWm.LWu = paramBoolean;
    this.LWm.LWv = paramLong1;
    this.LWm.LWw = paramLong2;
    AppMethodBeat.o(191545);
  }
  
  public final boolean fWc()
  {
    AppMethodBeat.i(191552);
    if (this.LWl != null)
    {
      f localf = this.LWl;
      if ((!TextUtils.isEmpty(localf.mUrl)) || (localf.LWV != null) || (localf.LWW != null)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(191552);
        return true;
      }
    }
    AppMethodBeat.o(191552);
    return false;
  }
  
  public final List<d> fWd()
  {
    AppMethodBeat.i(191553);
    ArrayList localArrayList = new ArrayList(this.LWh.size());
    Iterator localIterator = this.LWh.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(191553);
    return localArrayList;
  }
  
  public final List<a> fWe()
  {
    AppMethodBeat.i(191554);
    ArrayList localArrayList = new ArrayList(this.LWi.size());
    Iterator localIterator = this.LWi.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(191554);
    return localArrayList;
  }
  
  public final List<com.tencent.thumbplayer.b.f> fWf()
  {
    AppMethodBeat.i(191555);
    ArrayList localArrayList = new ArrayList(this.LWk.size());
    Iterator localIterator = this.LWk.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(191555);
    return localArrayList;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(191542);
    this.LWh.clear();
    this.LWi.clear();
    this.LWn = false;
    this.LWo = 1.0F;
    this.LWp = 1.0F;
    this.LWq.clear();
    this.mSurface = null;
    this.LWk.clear();
    this.LWl = new f();
    this.LWm = null;
    this.LWs = null;
    this.trackId = -1;
    this.LWr.clear();
    this.LWj.clear();
    AppMethodBeat.o(191542);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(191546);
    this.LWl.setUrl(paramString);
    AppMethodBeat.o(191546);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(191547);
    this.LWl.setUrl(paramString);
    paramString = this.LWl;
    paramString.mHttpHeaders.clear();
    Map localMap = paramString.mHttpHeaders;
    paramString = paramMap;
    if (paramMap == null) {
      paramString = new HashMap(0);
    }
    localMap.putAll(paramString);
    AppMethodBeat.o(191547);
  }
  
  public final void zv(boolean paramBoolean)
  {
    AppMethodBeat.i(191544);
    if (this.LWm == null) {
      this.LWm = new b();
    }
    this.LWm.LWu = paramBoolean;
    this.LWm.LWv = 0L;
    this.LWm.LWw = -1L;
    AppMethodBeat.o(191544);
  }
  
  public static final class a
  {
    public List<com.tencent.thumbplayer.b.f> LWt;
    public String name;
    public String url;
  }
  
  public static final class b
  {
    public boolean LWu;
    public long LWv;
    public long LWw;
  }
  
  public static final class c
  {
    public long LWx;
    public n LWy;
    public int trackIndex;
  }
  
  public static final class d
  {
    public String mimeType;
    public String name;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.a.c
 * JD-Core Version:    0.7.0.1
 */