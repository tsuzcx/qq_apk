package com.tencent.thumbplayer.a;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.k;
import com.tencent.thumbplayer.b.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  private Map<String, d> Kcl;
  Map<String, a> Kcm;
  ArrayList<c> Kcn;
  private Map<Integer, com.tencent.thumbplayer.b.f> Kco;
  public f Kcp;
  public b Kcq;
  public boolean Kcr;
  public float Kcs;
  public float Kct;
  public Map<Integer, n> Kcu;
  ArrayList<n> Kcv;
  k Kcw;
  public Surface mSurface;
  int trackId;
  
  public c()
  {
    AppMethodBeat.i(187520);
    this.trackId = -1;
    this.Kcl = new HashMap(0);
    this.Kcm = new HashMap(0);
    this.Kcp = new f();
    this.Kco = new HashMap(0);
    this.Kcu = new HashMap(0);
    this.Kcv = new ArrayList();
    this.Kcn = new ArrayList();
    AppMethodBeat.o(187520);
  }
  
  public final void a(int paramInt, long paramLong, n paramn)
  {
    AppMethodBeat.i(187528);
    this.Kcu.put(Integer.valueOf(paramn.trackType), paramn);
    if ((paramInt < 0) || (paramInt >= this.Kcv.size()))
    {
      com.tencent.thumbplayer.utils.f.w("TPPlaybackParams", "track Index:" + paramInt + " is invalid, trackInfoList size:" + this.Kcv.size());
      AppMethodBeat.o(187528);
      return;
    }
    c localc = new c();
    localc.trackIndex = paramInt;
    localc.KcB = paramLong;
    Iterator localIterator = this.Kcv.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.trackType == paramn.trackType) {
        if (((TextUtils.isEmpty(localn.name)) && (TextUtils.isEmpty(paramn.name))) || (localn.name.equals(paramn.name)))
        {
          localn.isSelected = true;
          localc.KcC = localn;
        }
        else
        {
          localn.isSelected = false;
        }
      }
    }
    this.Kcn.add(localc);
    AppMethodBeat.o(187528);
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(187529);
    this.Kcu.remove(Integer.valueOf(paramn.trackType));
    if ((paramInt < 0) || (paramInt >= this.Kcv.size()))
    {
      com.tencent.thumbplayer.utils.f.w("TPPlaybackParams", "track Index:" + paramInt + " is invalid, trackInfoList size:" + this.Kcv.size());
      AppMethodBeat.o(187529);
      return;
    }
    Iterator localIterator = this.Kcv.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (n)localIterator.next();
      if ((((n)localObject).trackType == paramn.trackType) && (((TextUtils.isEmpty(((n)localObject).name)) && (TextUtils.isEmpty(paramn.name))) || (((n)localObject).name.equals(paramn.name)))) {
        ((n)localObject).isSelected = false;
      }
    }
    localIterator = this.Kcn.iterator();
    while (localIterator.hasNext())
    {
      localObject = (c)localIterator.next();
      if ((((c)localObject).KcC != null) && (((c)localObject).KcC.equals(paramn)))
      {
        this.Kcn.remove(localObject);
        AppMethodBeat.o(187529);
        return;
      }
    }
    AppMethodBeat.o(187529);
  }
  
  public final void a(com.tencent.thumbplayer.b.f paramf)
  {
    AppMethodBeat.i(187522);
    if (paramf != null) {
      this.Kco.put(Integer.valueOf(paramf.key), paramf);
    }
    AppMethodBeat.o(187522);
  }
  
  public final com.tencent.thumbplayer.b.f aev(int paramInt)
  {
    AppMethodBeat.i(187535);
    com.tencent.thumbplayer.b.f localf = (com.tencent.thumbplayer.b.f)this.Kco.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(187535);
    return localf;
  }
  
  public final void b(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(187527);
    f localf = this.Kcp;
    localf.mUrl = null;
    localf.mType = 1;
    localf.mHttpHeaders.clear();
    localf.KcZ = paramParcelFileDescriptor;
    AppMethodBeat.o(187527);
  }
  
  public final void bb(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(187530);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(187530);
      return;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      AppMethodBeat.o(187530);
      return;
    }
    d locald = new d();
    locald.url = paramString1;
    locald.mimeType = paramString2;
    locald.name = paramString3;
    this.Kcl.put(paramString1, locald);
    this.trackId += 1;
    paramString1 = new n();
    paramString1.trackType = 3;
    paramString1.name = paramString3;
    paramString1.isSelected = false;
    paramString1.isExclusive = true;
    paramString1.isInternal = false;
    this.Kcv.add(paramString1);
    AppMethodBeat.o(187530);
  }
  
  public final void c(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(187524);
    if (this.Kcq == null) {
      this.Kcq = new b();
    }
    this.Kcq.Kcy = paramBoolean;
    this.Kcq.Kcz = paramLong1;
    this.Kcq.KcA = paramLong2;
    AppMethodBeat.o(187524);
  }
  
  public final boolean fEK()
  {
    AppMethodBeat.i(187531);
    if (this.Kcp != null)
    {
      f localf = this.Kcp;
      if ((!TextUtils.isEmpty(localf.mUrl)) || (localf.KcZ != null) || (localf.Kda != null)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(187531);
        return true;
      }
    }
    AppMethodBeat.o(187531);
    return false;
  }
  
  public final List<d> fEL()
  {
    AppMethodBeat.i(187532);
    ArrayList localArrayList = new ArrayList(this.Kcl.size());
    Iterator localIterator = this.Kcl.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(187532);
    return localArrayList;
  }
  
  public final List<a> fEM()
  {
    AppMethodBeat.i(187533);
    ArrayList localArrayList = new ArrayList(this.Kcm.size());
    Iterator localIterator = this.Kcm.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(187533);
    return localArrayList;
  }
  
  public final List<com.tencent.thumbplayer.b.f> fEN()
  {
    AppMethodBeat.i(187534);
    ArrayList localArrayList = new ArrayList(this.Kco.size());
    Iterator localIterator = this.Kco.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(187534);
    return localArrayList;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(187521);
    this.Kcl.clear();
    this.Kcm.clear();
    this.Kcr = false;
    this.Kcs = 1.0F;
    this.Kct = 1.0F;
    this.Kcu.clear();
    this.mSurface = null;
    this.Kco.clear();
    this.Kcp = new f();
    this.Kcq = null;
    this.Kcw = null;
    this.trackId = -1;
    this.Kcv.clear();
    this.Kcn.clear();
    AppMethodBeat.o(187521);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(187525);
    this.Kcp.setUrl(paramString);
    AppMethodBeat.o(187525);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(187526);
    this.Kcp.setUrl(paramString);
    paramString = this.Kcp;
    paramString.mHttpHeaders.clear();
    Map localMap = paramString.mHttpHeaders;
    paramString = paramMap;
    if (paramMap == null) {
      paramString = new HashMap(0);
    }
    localMap.putAll(paramString);
    AppMethodBeat.o(187526);
  }
  
  public final void yI(boolean paramBoolean)
  {
    AppMethodBeat.i(187523);
    if (this.Kcq == null) {
      this.Kcq = new b();
    }
    this.Kcq.Kcy = paramBoolean;
    this.Kcq.Kcz = 0L;
    this.Kcq.KcA = -1L;
    AppMethodBeat.o(187523);
  }
  
  public static final class a
  {
    public List<com.tencent.thumbplayer.b.f> Kcx;
    public String name;
    public String url;
  }
  
  public static final class b
  {
    public long KcA;
    public boolean Kcy;
    public long Kcz;
  }
  
  public static final class c
  {
    public long KcB;
    public n KcC;
    public int trackIndex;
  }
  
  public static final class d
  {
    public String mimeType;
    public String name;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.a.c
 * JD-Core Version:    0.7.0.1
 */