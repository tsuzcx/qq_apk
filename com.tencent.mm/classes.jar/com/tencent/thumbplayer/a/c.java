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
  public boolean RVA;
  public float RVB;
  String RVC;
  public float RVD;
  public Map<Integer, TPTrackInfo> RVE;
  ArrayList<TPTrackInfo> RVF;
  TPProgramInfo RVG;
  public Object RVt;
  Map<String, d> RVu;
  Map<String, a> RVv;
  ArrayList<c> RVw;
  private Map<Integer, TPOptionalParam> RVx;
  public f RVy;
  public b RVz;
  int trackId;
  
  public c()
  {
    AppMethodBeat.i(188603);
    this.trackId = -1;
    this.RVu = new HashMap(0);
    this.RVv = new HashMap(0);
    this.RVy = new f();
    this.RVx = new HashMap(0);
    this.RVE = new HashMap(0);
    this.RVF = new ArrayList();
    this.RVw = new ArrayList();
    AppMethodBeat.o(188603);
  }
  
  public final void a(int paramInt, long paramLong, TPTrackInfo paramTPTrackInfo)
  {
    AppMethodBeat.i(188613);
    this.RVE.put(Integer.valueOf(paramTPTrackInfo.getTrackType()), paramTPTrackInfo);
    if ((paramInt < 0) || (paramInt >= this.RVF.size()))
    {
      g.w("TPPlaybackParams", "track Index:" + paramInt + " is invalid, trackInfoList size:" + this.RVF.size());
      AppMethodBeat.o(188613);
      return;
    }
    c localc = new c();
    localc.trackIndex = paramInt;
    localc.RVK = paramLong;
    Iterator localIterator = this.RVF.iterator();
    while (localIterator.hasNext())
    {
      TPTrackInfo localTPTrackInfo = (TPTrackInfo)localIterator.next();
      if (localTPTrackInfo.trackType == paramTPTrackInfo.trackType) {
        if (((TextUtils.isEmpty(localTPTrackInfo.name)) && (TextUtils.isEmpty(paramTPTrackInfo.name))) || (localTPTrackInfo.name.equals(paramTPTrackInfo.name)))
        {
          localTPTrackInfo.isSelected = true;
          localc.RVL = localTPTrackInfo;
        }
        else
        {
          localTPTrackInfo.isSelected = false;
        }
      }
    }
    this.RVw.add(localc);
    AppMethodBeat.o(188613);
  }
  
  public final void a(int paramInt, TPTrackInfo paramTPTrackInfo)
  {
    AppMethodBeat.i(188614);
    this.RVE.remove(Integer.valueOf(paramTPTrackInfo.getTrackType()));
    if ((paramInt < 0) || (paramInt >= this.RVF.size()))
    {
      g.w("TPPlaybackParams", "track Index:" + paramInt + " is invalid, trackInfoList size:" + this.RVF.size());
      AppMethodBeat.o(188614);
      return;
    }
    Iterator localIterator = this.RVF.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (TPTrackInfo)localIterator.next();
      if ((((TPTrackInfo)localObject).trackType == paramTPTrackInfo.trackType) && (((TextUtils.isEmpty(((TPTrackInfo)localObject).name)) && (TextUtils.isEmpty(paramTPTrackInfo.name))) || (((TPTrackInfo)localObject).name.equals(paramTPTrackInfo.name)))) {
        ((TPTrackInfo)localObject).isSelected = false;
      }
    }
    localIterator = this.RVw.iterator();
    while (localIterator.hasNext())
    {
      localObject = (c)localIterator.next();
      if ((((c)localObject).RVL != null) && (((c)localObject).RVL.equals(paramTPTrackInfo)))
      {
        this.RVw.remove(localObject);
        AppMethodBeat.o(188614);
        return;
      }
    }
    AppMethodBeat.o(188614);
  }
  
  public final void a(e parame, Map<String, String> paramMap)
  {
    AppMethodBeat.i(188610);
    f localf = this.RVy;
    localf.mUrl = null;
    localf.mType = 3;
    localf.RWn = null;
    localf.RWq = parame;
    this.RVy.cn(paramMap);
    AppMethodBeat.o(188610);
  }
  
  public final void a(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(188605);
    if (paramTPOptionalParam != null) {
      this.RVx.put(Integer.valueOf(paramTPOptionalParam.getKey()), paramTPOptionalParam);
    }
    AppMethodBeat.o(188605);
  }
  
  public final TPOptionalParam aqR(int paramInt)
  {
    AppMethodBeat.i(188619);
    TPOptionalParam localTPOptionalParam = (TPOptionalParam)this.RVx.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(188619);
    return localTPOptionalParam;
  }
  
  public final boolean hmL()
  {
    AppMethodBeat.i(188615);
    if (this.RVy != null)
    {
      f localf = this.RVy;
      if ((!TextUtils.isEmpty(localf.mUrl)) || (localf.RWn != null) || (localf.RWp != null) || (localf.RWq != null)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(188615);
        return true;
      }
    }
    AppMethodBeat.o(188615);
    return false;
  }
  
  public final List<d> hmM()
  {
    AppMethodBeat.i(188616);
    ArrayList localArrayList = new ArrayList(this.RVu.size());
    Iterator localIterator = this.RVu.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(188616);
    return localArrayList;
  }
  
  public final List<a> hmN()
  {
    AppMethodBeat.i(188617);
    ArrayList localArrayList = new ArrayList(this.RVv.size());
    Iterator localIterator = this.RVv.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(188617);
    return localArrayList;
  }
  
  public final List<TPOptionalParam> hmO()
  {
    AppMethodBeat.i(188618);
    ArrayList localArrayList = new ArrayList(this.RVx.size());
    Iterator localIterator = this.RVx.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(188618);
    return localArrayList;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(188604);
    this.RVu.clear();
    this.RVv.clear();
    this.RVA = false;
    this.RVB = 1.0F;
    this.RVC = "";
    this.RVD = 1.0F;
    this.RVE.clear();
    this.RVt = null;
    this.RVx.clear();
    this.RVy = new f();
    this.RVz = null;
    this.RVG = null;
    this.trackId = -1;
    this.RVF.clear();
    this.RVw.clear();
    AppMethodBeat.o(188604);
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(188611);
    f localf = this.RVy;
    localf.mUrl = null;
    localf.mType = 1;
    localf.RWo.clear();
    localf.RWn = paramParcelFileDescriptor;
    AppMethodBeat.o(188611);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(188612);
    f localf = this.RVy;
    localf.mUrl = null;
    localf.mType = 2;
    localf.RWo.clear();
    localf.RWn = null;
    localf.RWp = paramITPMediaAsset;
    AppMethodBeat.o(188612);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(188608);
    this.RVy.setUrl(paramString);
    AppMethodBeat.o(188608);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(188609);
    this.RVy.setUrl(paramString);
    this.RVy.cn(paramMap);
    AppMethodBeat.o(188609);
  }
  
  public final void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(188606);
    if (this.RVz == null) {
      this.RVz = new b();
    }
    this.RVz.RVI = paramBoolean;
    this.RVz.startPositionMs = 0L;
    this.RVz.RVJ = -1L;
    AppMethodBeat.o(188606);
  }
  
  public final void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188607);
    if (this.RVz == null) {
      this.RVz = new b();
    }
    this.RVz.RVI = paramBoolean;
    this.RVz.startPositionMs = paramLong1;
    this.RVz.RVJ = paramLong2;
    AppMethodBeat.o(188607);
  }
  
  public static final class a
  {
    public List<TPOptionalParam> RVH;
    public String name;
    public String url;
  }
  
  public static final class b
  {
    public boolean RVI;
    public long RVJ;
    public long startPositionMs;
  }
  
  public static final class c
  {
    public long RVK;
    public TPTrackInfo RVL;
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