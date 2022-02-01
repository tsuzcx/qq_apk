package com.tencent.thumbplayer.a;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.e;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.utils.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public Object Zyd;
  Map<String, d> Zye;
  Map<String, a> Zyf;
  ArrayList<c> Zyg;
  private Map<Integer, TPOptionalParam> Zyh;
  public f Zyi;
  public b Zyj;
  public boolean Zyk;
  public float Zyl;
  String Zym;
  public float Zyn;
  public Map<Integer, TPTrackInfo> Zyo;
  ArrayList<TPTrackInfo> Zyp;
  TPProgramInfo Zyq;
  int trackId;
  
  public c()
  {
    AppMethodBeat.i(218632);
    this.trackId = -1;
    this.Zye = new HashMap(0);
    this.Zyf = new HashMap(0);
    this.Zyi = new f();
    this.Zyh = new HashMap(0);
    this.Zyo = new HashMap(0);
    this.Zyp = new ArrayList();
    this.Zyg = new ArrayList();
    AppMethodBeat.o(218632);
  }
  
  public final void a(int paramInt, long paramLong, TPTrackInfo paramTPTrackInfo)
  {
    AppMethodBeat.i(218655);
    this.Zyo.put(Integer.valueOf(paramTPTrackInfo.getTrackType()), paramTPTrackInfo);
    if ((paramInt < 0) || (paramInt >= this.Zyp.size()))
    {
      g.w("TPPlaybackParams", "track Index:" + paramInt + " is invalid, trackInfoList size:" + this.Zyp.size());
      AppMethodBeat.o(218655);
      return;
    }
    c localc = new c();
    localc.trackIndex = paramInt;
    localc.Zyu = paramLong;
    Iterator localIterator = this.Zyp.iterator();
    while (localIterator.hasNext())
    {
      TPTrackInfo localTPTrackInfo = (TPTrackInfo)localIterator.next();
      if (localTPTrackInfo.trackType == paramTPTrackInfo.trackType) {
        if (((TextUtils.isEmpty(localTPTrackInfo.name)) && (TextUtils.isEmpty(paramTPTrackInfo.name))) || (localTPTrackInfo.name.equals(paramTPTrackInfo.name)))
        {
          localTPTrackInfo.isSelected = true;
          localc.Zyv = localTPTrackInfo;
        }
        else
        {
          localTPTrackInfo.isSelected = false;
        }
      }
    }
    this.Zyg.add(localc);
    AppMethodBeat.o(218655);
  }
  
  public final void a(int paramInt, TPTrackInfo paramTPTrackInfo)
  {
    AppMethodBeat.i(218660);
    this.Zyo.remove(Integer.valueOf(paramTPTrackInfo.getTrackType()));
    if ((paramInt < 0) || (paramInt >= this.Zyp.size()))
    {
      g.w("TPPlaybackParams", "track Index:" + paramInt + " is invalid, trackInfoList size:" + this.Zyp.size());
      AppMethodBeat.o(218660);
      return;
    }
    Iterator localIterator = this.Zyp.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (TPTrackInfo)localIterator.next();
      if ((((TPTrackInfo)localObject).trackType == paramTPTrackInfo.trackType) && (((TextUtils.isEmpty(((TPTrackInfo)localObject).name)) && (TextUtils.isEmpty(paramTPTrackInfo.name))) || (((TPTrackInfo)localObject).name.equals(paramTPTrackInfo.name)))) {
        ((TPTrackInfo)localObject).isSelected = false;
      }
    }
    localIterator = this.Zyg.iterator();
    while (localIterator.hasNext())
    {
      localObject = (c)localIterator.next();
      if ((((c)localObject).Zyv != null) && (((c)localObject).Zyv.equals(paramTPTrackInfo)))
      {
        this.Zyg.remove(localObject);
        AppMethodBeat.o(218660);
        return;
      }
    }
    AppMethodBeat.o(218660);
  }
  
  public final void a(e parame, Map<String, String> paramMap)
  {
    AppMethodBeat.i(218648);
    f localf = this.Zyi;
    localf.mUrl = null;
    localf.mType = 3;
    localf.ZyX = null;
    localf.Zza = parame;
    this.Zyi.ct(paramMap);
    AppMethodBeat.o(218648);
  }
  
  public final void a(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(218636);
    if (paramTPOptionalParam != null) {
      this.Zyh.put(Integer.valueOf(paramTPOptionalParam.getKey()), paramTPOptionalParam);
    }
    AppMethodBeat.o(218636);
  }
  
  public final TPOptionalParam aAE(int paramInt)
  {
    AppMethodBeat.i(218667);
    TPOptionalParam localTPOptionalParam = (TPOptionalParam)this.Zyh.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(218667);
    return localTPOptionalParam;
  }
  
  public final boolean iqm()
  {
    AppMethodBeat.i(218661);
    if (this.Zyi != null)
    {
      f localf = this.Zyi;
      if ((!TextUtils.isEmpty(localf.mUrl)) || (localf.ZyX != null) || (localf.ZyZ != null) || (localf.Zza != null)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(218661);
        return true;
      }
    }
    AppMethodBeat.o(218661);
    return false;
  }
  
  public final List<d> iqn()
  {
    AppMethodBeat.i(218663);
    ArrayList localArrayList = new ArrayList(this.Zye.size());
    Iterator localIterator = this.Zye.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(218663);
    return localArrayList;
  }
  
  public final List<a> iqo()
  {
    AppMethodBeat.i(218664);
    ArrayList localArrayList = new ArrayList(this.Zyf.size());
    Iterator localIterator = this.Zyf.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(218664);
    return localArrayList;
  }
  
  public final List<TPOptionalParam> iqp()
  {
    AppMethodBeat.i(218665);
    ArrayList localArrayList = new ArrayList(this.Zyh.size());
    Iterator localIterator = this.Zyh.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(218665);
    return localArrayList;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(218634);
    this.Zye.clear();
    this.Zyf.clear();
    this.Zyk = false;
    this.Zyl = 1.0F;
    this.Zym = "";
    this.Zyn = 1.0F;
    this.Zyo.clear();
    this.Zyd = null;
    this.Zyh.clear();
    this.Zyi = new f();
    this.Zyj = null;
    this.Zyq = null;
    this.trackId = -1;
    this.Zyp.clear();
    this.Zyg.clear();
    AppMethodBeat.o(218634);
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(218650);
    f localf = this.Zyi;
    localf.mUrl = null;
    localf.mType = 1;
    localf.ZyY.clear();
    localf.ZyX = paramParcelFileDescriptor;
    AppMethodBeat.o(218650);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(218652);
    f localf = this.Zyi;
    localf.mUrl = null;
    localf.mType = 2;
    localf.ZyY.clear();
    localf.ZyX = null;
    localf.ZyZ = paramITPMediaAsset;
    AppMethodBeat.o(218652);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(218643);
    this.Zyi.setUrl(paramString);
    AppMethodBeat.o(218643);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(218645);
    this.Zyi.setUrl(paramString);
    this.Zyi.ct(paramMap);
    AppMethodBeat.o(218645);
  }
  
  public final void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(218639);
    if (this.Zyj == null) {
      this.Zyj = new b();
    }
    this.Zyj.Zys = paramBoolean;
    this.Zyj.startPositionMs = 0L;
    this.Zyj.Zyt = -1L;
    AppMethodBeat.o(218639);
  }
  
  public final void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(218641);
    if (this.Zyj == null) {
      this.Zyj = new b();
    }
    this.Zyj.Zys = paramBoolean;
    this.Zyj.startPositionMs = paramLong1;
    this.Zyj.Zyt = paramLong2;
    AppMethodBeat.o(218641);
  }
  
  public static final class a
  {
    public List<TPOptionalParam> Zyr;
    public String name;
    public String url;
  }
  
  public static final class b
  {
    public boolean Zys;
    public long Zyt;
    public long startPositionMs;
  }
  
  public static final class c
  {
    public long Zyu;
    public TPTrackInfo Zyv;
    public int trackIndex;
  }
  
  public static final class d
  {
    public String mimeType;
    public String name;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.c
 * JD-Core Version:    0.7.0.1
 */