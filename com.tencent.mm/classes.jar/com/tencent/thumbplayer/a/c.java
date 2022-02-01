package com.tencent.thumbplayer.a;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
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
  public Object ahDg;
  Map<String, d> ahDh;
  Map<String, a> ahDi;
  ArrayList<c> ahDj;
  private Map<Integer, TPOptionalParam> ahDk;
  public f ahDl;
  public b ahDm;
  public boolean ahDn;
  public float ahDo;
  String ahDp;
  public float ahDq;
  public Map<Integer, TPTrackInfo> ahDr;
  ArrayList<TPTrackInfo> ahDs;
  TPProgramInfo ahDt;
  public int lSR;
  int trackId;
  
  public c()
  {
    AppMethodBeat.i(228467);
    this.lSR = 0;
    this.trackId = -1;
    this.ahDh = new HashMap(0);
    this.ahDi = new HashMap(0);
    this.ahDl = new f();
    this.ahDk = new HashMap(0);
    this.ahDr = new HashMap(0);
    this.ahDs = new ArrayList();
    this.ahDj = new ArrayList();
    AppMethodBeat.o(228467);
  }
  
  public final void a(int paramInt, long paramLong, TPTrackInfo paramTPTrackInfo)
  {
    AppMethodBeat.i(228602);
    this.ahDr.put(Integer.valueOf(paramTPTrackInfo.getTrackType()), paramTPTrackInfo);
    if ((paramInt < 0) || (paramInt >= this.ahDs.size()))
    {
      g.w("TPPlaybackParams", "track Index:" + paramInt + " is invalid, trackInfoList size:" + this.ahDs.size());
      AppMethodBeat.o(228602);
      return;
    }
    c localc = new c();
    localc.trackIndex = paramInt;
    localc.ahDx = paramLong;
    Iterator localIterator = this.ahDs.iterator();
    while (localIterator.hasNext())
    {
      TPTrackInfo localTPTrackInfo = (TPTrackInfo)localIterator.next();
      if (localTPTrackInfo.trackType == paramTPTrackInfo.trackType) {
        if (((TextUtils.isEmpty(localTPTrackInfo.name)) && (TextUtils.isEmpty(paramTPTrackInfo.name))) || (localTPTrackInfo.name.equals(paramTPTrackInfo.name)))
        {
          localTPTrackInfo.isSelected = true;
          localc.ahDy = localTPTrackInfo;
        }
        else
        {
          localTPTrackInfo.isSelected = false;
        }
      }
    }
    this.ahDj.add(localc);
    AppMethodBeat.o(228602);
  }
  
  public final void a(int paramInt, TPTrackInfo paramTPTrackInfo)
  {
    AppMethodBeat.i(228615);
    this.ahDr.remove(Integer.valueOf(paramTPTrackInfo.getTrackType()));
    if ((paramInt < 0) || (paramInt >= this.ahDs.size()))
    {
      g.w("TPPlaybackParams", "track Index:" + paramInt + " is invalid, trackInfoList size:" + this.ahDs.size());
      AppMethodBeat.o(228615);
      return;
    }
    Iterator localIterator = this.ahDs.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (TPTrackInfo)localIterator.next();
      if ((((TPTrackInfo)localObject).trackType == paramTPTrackInfo.trackType) && (((TextUtils.isEmpty(((TPTrackInfo)localObject).name)) && (TextUtils.isEmpty(paramTPTrackInfo.name))) || (((TPTrackInfo)localObject).name.equals(paramTPTrackInfo.name)))) {
        ((TPTrackInfo)localObject).isSelected = false;
      }
    }
    localIterator = this.ahDj.iterator();
    while (localIterator.hasNext())
    {
      localObject = (c)localIterator.next();
      if ((((c)localObject).ahDy != null) && (((c)localObject).ahDy.equals(paramTPTrackInfo)))
      {
        this.ahDj.remove(localObject);
        AppMethodBeat.o(228615);
        return;
      }
    }
    AppMethodBeat.o(228615);
  }
  
  public final void a(e parame, Map<String, String> paramMap)
  {
    AppMethodBeat.i(228553);
    f localf = this.ahDl;
    localf.mUrl = null;
    localf.mType = 3;
    localf.ahEa = null;
    localf.JgJ = null;
    localf.ahEc = parame;
    this.ahDl.dm(paramMap);
    AppMethodBeat.o(228553);
  }
  
  public final void a(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(228498);
    if (paramTPOptionalParam != null) {
      this.ahDk.put(Integer.valueOf(paramTPOptionalParam.getKey()), paramTPOptionalParam);
    }
    AppMethodBeat.o(228498);
  }
  
  public final TPOptionalParam aHq(int paramInt)
  {
    AppMethodBeat.i(228655);
    TPOptionalParam localTPOptionalParam = (TPOptionalParam)this.ahDk.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(228655);
    return localTPOptionalParam;
  }
  
  public final boolean jZH()
  {
    AppMethodBeat.i(228621);
    if (this.ahDl != null)
    {
      f localf = this.ahDl;
      if ((!TextUtils.isEmpty(localf.mUrl)) || (localf.ahEa != null) || (localf.JgJ != null) || (localf.ahEb != null) || (localf.ahEc != null)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(228621);
        return true;
      }
    }
    AppMethodBeat.o(228621);
    return false;
  }
  
  public final List<d> jZI()
  {
    AppMethodBeat.i(228631);
    ArrayList localArrayList = new ArrayList(this.ahDh.size());
    Iterator localIterator = this.ahDh.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(228631);
    return localArrayList;
  }
  
  public final List<a> jZJ()
  {
    AppMethodBeat.i(228644);
    ArrayList localArrayList = new ArrayList(this.ahDi.size());
    Iterator localIterator = this.ahDi.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(228644);
    return localArrayList;
  }
  
  public final List<TPOptionalParam> jZK()
  {
    AppMethodBeat.i(228649);
    ArrayList localArrayList = new ArrayList(this.ahDk.size());
    Iterator localIterator = this.ahDk.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(228649);
    return localArrayList;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(228481);
    this.ahDh.clear();
    this.ahDi.clear();
    this.ahDn = false;
    this.ahDo = 1.0F;
    this.ahDp = "";
    this.ahDq = 1.0F;
    this.ahDr.clear();
    this.ahDg = null;
    this.lSR = 0;
    this.ahDk.clear();
    this.ahDl = new f();
    this.ahDm = null;
    this.ahDt = null;
    this.trackId = -1;
    this.ahDs.clear();
    this.ahDj.clear();
    AppMethodBeat.o(228481);
  }
  
  public final void setDataSource(AssetFileDescriptor paramAssetFileDescriptor)
  {
    AppMethodBeat.i(228567);
    f localf = this.ahDl;
    localf.mUrl = null;
    localf.mType = 4;
    localf.mHttpHeaders.clear();
    localf.ahEa = null;
    localf.JgJ = paramAssetFileDescriptor;
    AppMethodBeat.o(228567);
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(228575);
    f localf = this.ahDl;
    localf.mUrl = null;
    localf.mType = 1;
    localf.mHttpHeaders.clear();
    localf.ahEa = paramParcelFileDescriptor;
    localf.JgJ = null;
    AppMethodBeat.o(228575);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(228587);
    f localf = this.ahDl;
    localf.mUrl = null;
    localf.mType = 2;
    localf.mHttpHeaders.clear();
    localf.ahEa = null;
    localf.JgJ = null;
    localf.ahEb = paramITPMediaAsset;
    AppMethodBeat.o(228587);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(228528);
    this.ahDl.setUrl(paramString);
    AppMethodBeat.o(228528);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(228540);
    this.ahDl.setUrl(paramString);
    this.ahDl.dm(paramMap);
    AppMethodBeat.o(228540);
  }
  
  public final void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(228508);
    if (this.ahDm == null) {
      this.ahDm = new b();
    }
    this.ahDm.ahDv = paramBoolean;
    this.ahDm.startPositionMs = 0L;
    this.ahDm.ahDw = -1L;
    AppMethodBeat.o(228508);
  }
  
  public final void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228516);
    if (this.ahDm == null) {
      this.ahDm = new b();
    }
    this.ahDm.ahDv = paramBoolean;
    this.ahDm.startPositionMs = paramLong1;
    this.ahDm.ahDw = paramLong2;
    AppMethodBeat.o(228516);
  }
  
  public final void v(Surface paramSurface)
  {
    this.ahDg = paramSurface;
    this.lSR = this.lSR;
  }
  
  public static final class a
  {
    public List<TPOptionalParam> ahDu;
    public String name;
    public String url;
  }
  
  public static final class b
  {
    public boolean ahDv;
    public long ahDw;
    public long startPositionMs;
  }
  
  public static final class c
  {
    public long ahDx;
    public TPTrackInfo ahDy;
    public int trackIndex;
  }
  
  public static final class d
  {
    public String mimeType;
    public String name;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.c
 * JD-Core Version:    0.7.0.1
 */