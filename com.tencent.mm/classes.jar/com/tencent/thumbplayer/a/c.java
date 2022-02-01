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
  private Map<String, d> Mtc;
  Map<String, a> Mtd;
  ArrayList<c> Mte;
  private Map<Integer, com.tencent.thumbplayer.b.f> Mtf;
  public f Mtg;
  public b Mth;
  public boolean Mti;
  public float Mtj;
  public float Mtk;
  public Map<Integer, n> Mtl;
  ArrayList<n> Mtm;
  k Mtn;
  public Surface mSurface;
  int trackId;
  
  public c()
  {
    AppMethodBeat.i(194219);
    this.trackId = -1;
    this.Mtc = new HashMap(0);
    this.Mtd = new HashMap(0);
    this.Mtg = new f();
    this.Mtf = new HashMap(0);
    this.Mtl = new HashMap(0);
    this.Mtm = new ArrayList();
    this.Mte = new ArrayList();
    AppMethodBeat.o(194219);
  }
  
  public final void a(int paramInt, long paramLong, n paramn)
  {
    AppMethodBeat.i(194227);
    this.Mtl.put(Integer.valueOf(paramn.trackType), paramn);
    if ((paramInt < 0) || (paramInt >= this.Mtm.size()))
    {
      d.w("TPPlaybackParams", "track Index:" + paramInt + " is invalid, trackInfoList size:" + this.Mtm.size());
      AppMethodBeat.o(194227);
      return;
    }
    c localc = new c();
    localc.trackIndex = paramInt;
    localc.Mts = paramLong;
    Iterator localIterator = this.Mtm.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.trackType == paramn.trackType) {
        if (((TextUtils.isEmpty(localn.name)) && (TextUtils.isEmpty(paramn.name))) || (localn.name.equals(paramn.name)))
        {
          localn.isSelected = true;
          localc.Mtt = localn;
        }
        else
        {
          localn.isSelected = false;
        }
      }
    }
    this.Mte.add(localc);
    AppMethodBeat.o(194227);
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(194228);
    this.Mtl.remove(Integer.valueOf(paramn.trackType));
    if ((paramInt < 0) || (paramInt >= this.Mtm.size()))
    {
      d.w("TPPlaybackParams", "track Index:" + paramInt + " is invalid, trackInfoList size:" + this.Mtm.size());
      AppMethodBeat.o(194228);
      return;
    }
    Iterator localIterator = this.Mtm.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (n)localIterator.next();
      if ((((n)localObject).trackType == paramn.trackType) && (((TextUtils.isEmpty(((n)localObject).name)) && (TextUtils.isEmpty(paramn.name))) || (((n)localObject).name.equals(paramn.name)))) {
        ((n)localObject).isSelected = false;
      }
    }
    localIterator = this.Mte.iterator();
    while (localIterator.hasNext())
    {
      localObject = (c)localIterator.next();
      if ((((c)localObject).Mtt != null) && (((c)localObject).Mtt.equals(paramn)))
      {
        this.Mte.remove(localObject);
        AppMethodBeat.o(194228);
        return;
      }
    }
    AppMethodBeat.o(194228);
  }
  
  public final void a(com.tencent.thumbplayer.b.f paramf)
  {
    AppMethodBeat.i(194221);
    if (paramf != null) {
      this.Mtf.put(Integer.valueOf(paramf.key), paramf);
    }
    AppMethodBeat.o(194221);
  }
  
  public final com.tencent.thumbplayer.b.f ahE(int paramInt)
  {
    AppMethodBeat.i(194234);
    com.tencent.thumbplayer.b.f localf = (com.tencent.thumbplayer.b.f)this.Mtf.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(194234);
    return localf;
  }
  
  public final void b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(194226);
    f localf = this.Mtg;
    localf.mUrl = null;
    localf.mType = 1;
    localf.mHttpHeaders.clear();
    localf.MtQ = paramParcelFileDescriptor;
    AppMethodBeat.o(194226);
  }
  
  public final void bl(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194229);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(194229);
      return;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      AppMethodBeat.o(194229);
      return;
    }
    d locald = new d();
    locald.url = paramString1;
    locald.mimeType = paramString2;
    locald.name = paramString3;
    this.Mtc.put(paramString1, locald);
    this.trackId += 1;
    paramString1 = new n();
    paramString1.trackType = 3;
    paramString1.name = paramString3;
    paramString1.isSelected = false;
    paramString1.isExclusive = true;
    paramString1.isInternal = false;
    this.Mtm.add(paramString1);
    AppMethodBeat.o(194229);
  }
  
  public final void c(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194223);
    if (this.Mth == null) {
      this.Mth = new b();
    }
    this.Mth.Mtp = paramBoolean;
    this.Mth.Mtq = paramLong1;
    this.Mth.Mtr = paramLong2;
    AppMethodBeat.o(194223);
  }
  
  public final boolean gaB()
  {
    AppMethodBeat.i(194230);
    if (this.Mtg != null)
    {
      f localf = this.Mtg;
      if ((!TextUtils.isEmpty(localf.mUrl)) || (localf.MtQ != null) || (localf.MtR != null)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(194230);
        return true;
      }
    }
    AppMethodBeat.o(194230);
    return false;
  }
  
  public final List<d> gaC()
  {
    AppMethodBeat.i(194231);
    ArrayList localArrayList = new ArrayList(this.Mtc.size());
    Iterator localIterator = this.Mtc.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(194231);
    return localArrayList;
  }
  
  public final List<a> gaD()
  {
    AppMethodBeat.i(194232);
    ArrayList localArrayList = new ArrayList(this.Mtd.size());
    Iterator localIterator = this.Mtd.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(194232);
    return localArrayList;
  }
  
  public final List<com.tencent.thumbplayer.b.f> gaE()
  {
    AppMethodBeat.i(194233);
    ArrayList localArrayList = new ArrayList(this.Mtf.size());
    Iterator localIterator = this.Mtf.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(194233);
    return localArrayList;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(194220);
    this.Mtc.clear();
    this.Mtd.clear();
    this.Mti = false;
    this.Mtj = 1.0F;
    this.Mtk = 1.0F;
    this.Mtl.clear();
    this.mSurface = null;
    this.Mtf.clear();
    this.Mtg = new f();
    this.Mth = null;
    this.Mtn = null;
    this.trackId = -1;
    this.Mtm.clear();
    this.Mte.clear();
    AppMethodBeat.o(194220);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(194224);
    this.Mtg.setUrl(paramString);
    AppMethodBeat.o(194224);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(194225);
    this.Mtg.setUrl(paramString);
    paramString = this.Mtg;
    paramString.mHttpHeaders.clear();
    Map localMap = paramString.mHttpHeaders;
    paramString = paramMap;
    if (paramMap == null) {
      paramString = new HashMap(0);
    }
    localMap.putAll(paramString);
    AppMethodBeat.o(194225);
  }
  
  public final void zJ(boolean paramBoolean)
  {
    AppMethodBeat.i(194222);
    if (this.Mth == null) {
      this.Mth = new b();
    }
    this.Mth.Mtp = paramBoolean;
    this.Mth.Mtq = 0L;
    this.Mth.Mtr = -1L;
    AppMethodBeat.o(194222);
  }
  
  public static final class a
  {
    public List<com.tencent.thumbplayer.b.f> Mto;
    public String name;
    public String url;
  }
  
  public static final class b
  {
    public boolean Mtp;
    public long Mtq;
    public long Mtr;
  }
  
  public static final class c
  {
    public long Mts;
    public n Mtt;
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