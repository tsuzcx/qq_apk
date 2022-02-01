package com.tencent.thumbplayer.e;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor.b;
import com.tencent.thumbplayer.utils.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements a, TPNetworkChangeMonitor.b, e.a
{
  private static int ahHh = -1;
  private ITPDownloadProxy ahHc;
  private boolean ahHd;
  private int ahHe;
  private a ahHf;
  private ITPPlayListener ahHg;
  private ArrayList<TPDownloadParamData> ahHi;
  private String ahHj;
  private int ahHk;
  private TPVideoInfo ahHl;
  private ITPPlayerProxyListener ahHm;
  private LinkedList<b> ahHn;
  private HashMap<String, Integer> ahHo;
  private long ahHp;
  private boolean ahHq;
  private boolean ahHr;
  private long emw;
  private Context mContext;
  private String mOriginUrl;
  private int mServiceType;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(226998);
    this.ahHd = false;
    this.ahHe = 3;
    this.mServiceType = ahHh;
    this.ahHk = -1;
    this.ahHm = null;
    this.ahHq = false;
    this.ahHr = false;
    this.mContext = paramContext;
    com.tencent.thumbplayer.utils.e.a(this);
    TPNetworkChangeMonitor.kbq().a(this);
    this.ahHf = new a((byte)0);
    this.ahHg = new d("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.ahHo = new HashMap();
    this.ahHi = new ArrayList();
    AppMethodBeat.o(226998);
  }
  
  private boolean Oz(boolean paramBoolean)
  {
    AppMethodBeat.i(227119);
    if (!com.tencent.thumbplayer.d.a.kag())
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "config set don't use p2p proxy!");
      AppMethodBeat.o(227119);
      return true;
    }
    if (paramBoolean) {
      this.ahHe = 3;
    }
    kav();
    if (!this.ahHd)
    {
      AppMethodBeat.o(227119);
      return true;
    }
    AppMethodBeat.o(227119);
    return false;
  }
  
  private int a(List<ITPMediaTrackClip> paramList, String paramString, ArrayList<TPDownloadParamData> paramArrayList)
  {
    AppMethodBeat.i(227076);
    if (com.tencent.thumbplayer.utils.b.isEmpty(paramList))
    {
      com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "clipList is empty, return");
      AppMethodBeat.o(227076);
      return -1;
    }
    int k = paramList.size();
    Object localObject1 = new HashMap();
    int j = 0;
    int i = 1;
    Object localObject2;
    if (j < k)
    {
      localObject2 = (ITPMediaTrackClip)paramList.get(j);
      if ((!(localObject2 instanceof com.tencent.thumbplayer.c.e)) || (!com.tencent.thumbplayer.utils.b.bCj(((com.tencent.thumbplayer.c.e)localObject2).getFilePath()))) {
        break label441;
      }
      ((HashMap)localObject1).put(localObject2, new c(i, j));
      i += 1;
    }
    label441:
    for (;;)
    {
      j += 1;
      break;
      if (com.tencent.thumbplayer.utils.b.isEmpty((Map)localObject1))
      {
        com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "all urls is local file url, return");
        AppMethodBeat.o(227076);
        return -1;
      }
      i = this.ahHc.startClipPlay(paramString, ((HashMap)localObject1).size(), this.ahHf);
      if (i > 0)
      {
        paramList = ((HashMap)localObject1).entrySet().iterator();
        while (paramList.hasNext())
        {
          paramString = (Map.Entry)paramList.next();
          localObject1 = (ITPMediaTrackClip)paramString.getKey();
          paramString = (c)paramString.getValue();
          if ((localObject1 instanceof com.tencent.thumbplayer.c.e))
          {
            localObject1 = (com.tencent.thumbplayer.c.e)localObject1;
            Object localObject3 = n(paramArrayList, paramString.ahHw);
            if (localObject3 == null)
            {
              com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "fatal err, paramData is null.");
              AppMethodBeat.o(227076);
              return -1;
            }
            com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "multi trackClipIndex:" + paramString.ahHw + ", download seq:" + paramString.ahHv + ", clip.url:" + ((com.tencent.thumbplayer.c.e)localObject1).getUrl() + ", clip.getFilePath:" + ((com.tencent.thumbplayer.c.e)localObject1).getFilePath() + ", paramData.savePath:" + ((TPDownloadParamData)localObject3).getSavePath() + ", paramData.DownloadFileID:" + ((TPDownloadParamData)localObject3).getDownloadFileID());
            localObject2 = ((TPDownloadParamData)localObject3).getDownloadFileID();
            localObject3 = a(((com.tencent.thumbplayer.c.e)localObject1).getFilePath(), (TPDownloadParamData)localObject3);
            if (this.ahHc.setClipInfo(i, paramString.ahHv, (String)localObject2, (TPDownloadParam)localObject3)) {
              ((com.tencent.thumbplayer.c.e)localObject1).ahGJ = this.ahHc.getClipPlayUrl(i, paramString.ahHv, 1);
            }
          }
        }
      }
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start clip play failed, cause : playId < 0");
      AppMethodBeat.o(227076);
      return i;
    }
  }
  
  private com.tencent.thumbplayer.a.a.e a(long paramLong, String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    String str = null;
    AppMethodBeat.i(227029);
    com.tencent.thumbplayer.a.a.e locale = new com.tencent.thumbplayer.a.a.e(paramString);
    if (!com.tencent.thumbplayer.utils.b.bCj(paramString))
    {
      AppMethodBeat.o(227029);
      return locale;
    }
    if (Oz(false))
    {
      AppMethodBeat.o(227029);
      return locale;
    }
    if (this.ahHn == null) {
      this.ahHn = new LinkedList();
    }
    if (paramTPDownloadParamData != null) {}
    for (Object localObject = a(paramString, paramTPDownloadParamData);; localObject = null)
    {
      if (paramTPDownloadParamData != null) {}
      try
      {
        str = paramTPDownloadParamData.getDownloadFileID();
        i = this.ahHc.startPlay(str, (TPDownloadParam)localObject, this.ahHf);
        if (i <= 0) {
          break;
        }
        localObject = this.ahHc.getPlayUrl(i, 1);
        paramTPDownloadParamData = (TPDownloadParamData)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramTPDownloadParamData = paramString;
        }
        locale.ahEf = paramTPDownloadParamData;
        paramTPDownloadParamData = this.ahHc.getPlayUrl(this.ahHk, 0);
        if (!TextUtils.isEmpty(paramTPDownloadParamData)) {
          break label281;
        }
      }
      finally
      {
        for (;;)
        {
          int i;
          com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", paramString, "p2p proxy switch def failed");
          continue;
          paramString = paramTPDownloadParamData;
        }
      }
      locale.ahEe = paramString;
      this.ahHn.offer(new b(paramLong, i));
      com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
      AppMethodBeat.o(227029);
      return locale;
    }
    com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def failed, cause : playId < 0");
    AppMethodBeat.o(227029);
    return locale;
  }
  
  private static TPDownloadParam a(String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(369542);
    paramString = i.b(paramString, paramTPDownloadParamData);
    AppMethodBeat.o(369542);
    return paramString;
  }
  
  private void aHP(int paramInt)
  {
    AppMethodBeat.i(227036);
    if (Oz(false))
    {
      AppMethodBeat.o(227036);
      return;
    }
    try
    {
      this.ahHc.pauseDownload(paramInt);
      AppMethodBeat.o(227036);
      return;
    }
    finally
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pause download failed, taskId:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(227036);
    }
  }
  
  private void aHQ(int paramInt)
  {
    AppMethodBeat.i(227043);
    if (Oz(false))
    {
      AppMethodBeat.o(227043);
      return;
    }
    try
    {
      this.ahHc.resumeDownload(this.ahHk);
      AppMethodBeat.o(227043);
      return;
    }
    finally
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy resume download failed, taskId:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(227043);
    }
  }
  
  private void aHR(int paramInt)
  {
    AppMethodBeat.i(227090);
    if (Oz(false))
    {
      AppMethodBeat.o(227090);
      return;
    }
    try
    {
      this.ahHc.stopPlay(paramInt);
      AppMethodBeat.o(227090);
      return;
    }
    finally
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy stop play failed, taskID:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(227090);
    }
  }
  
  private void aHS(int paramInt)
  {
    AppMethodBeat.i(227102);
    if (Oz(false))
    {
      AppMethodBeat.o(227102);
      return;
    }
    try
    {
      this.ahHc.pushEvent(paramInt);
      AppMethodBeat.o(227102);
      return;
    }
    finally
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pushEvent failed, event:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(227102);
    }
  }
  
  private static List<ITPMediaTrackClip> c(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(227055);
    if ((paramITPMediaAsset instanceof com.tencent.thumbplayer.c.b))
    {
      paramITPMediaAsset = ((com.tencent.thumbplayer.c.b)paramITPMediaAsset).getAllAVTracks();
      if (!com.tencent.thumbplayer.utils.b.isEmpty(paramITPMediaAsset))
      {
        paramITPMediaAsset = (ITPMediaTrack)paramITPMediaAsset.get(0);
        if ((paramITPMediaAsset != null) && (!com.tencent.thumbplayer.utils.b.isEmpty(paramITPMediaAsset.getAllTrackClips())))
        {
          paramITPMediaAsset = paramITPMediaAsset.getAllTrackClips();
          AppMethodBeat.o(227055);
          return paramITPMediaAsset;
        }
      }
    }
    else if ((paramITPMediaAsset instanceof ITPMediaTrack))
    {
      paramITPMediaAsset = (ITPMediaTrack)paramITPMediaAsset;
      if (!com.tencent.thumbplayer.utils.b.isEmpty(paramITPMediaAsset.getAllTrackClips()))
      {
        paramITPMediaAsset = paramITPMediaAsset.getAllTrackClips();
        AppMethodBeat.o(227055);
        return paramITPMediaAsset;
      }
    }
    else if ((paramITPMediaAsset instanceof ITPMediaTrackClip))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add((ITPMediaTrackClip)paramITPMediaAsset);
      AppMethodBeat.o(227055);
      return localArrayList;
    }
    AppMethodBeat.o(227055);
    return null;
  }
  
  private void kav()
  {
    AppMethodBeat.i(227007);
    if (this.ahHd)
    {
      AppMethodBeat.o(227007);
      return;
    }
    if (this.ahHe > 0)
    {
      try
      {
        if (this.mServiceType == ahHh) {
          this.mServiceType = com.tencent.thumbplayer.d.a.kap();
        }
        b localb = g.a.kax().aHU(this.mServiceType);
        if ((localb == null) || (localb.kau() == null)) {
          break label272;
        }
        this.ahHc = localb.kau();
        this.ahHc.setUserData("qq_is_vip", Boolean.valueOf(com.tencent.thumbplayer.d.a.kao()));
        if (!TextUtils.isEmpty(com.tencent.thumbplayer.d.a.kak())) {
          this.ahHc.setUserData("user_uin", com.tencent.thumbplayer.d.a.kak());
        }
        if (!TextUtils.isEmpty(com.tencent.thumbplayer.d.a.getAppVersionName(this.mContext))) {
          this.ahHc.setUserData("app_version_name", com.tencent.thumbplayer.d.a.getAppVersionName(this.mContext));
        }
        if (com.tencent.thumbplayer.d.a.ot(this.mContext) != -1L) {
          this.ahHc.setUserData("app_version_code", String.valueOf(com.tencent.thumbplayer.d.a.ot(this.mContext)));
        }
        this.ahHc.setUserData("carrier_pesudo_code", com.tencent.thumbplayer.d.a.kal());
        this.ahHc.setUserData("carrier_pesudo_state", Integer.valueOf(com.tencent.thumbplayer.d.a.kam()));
        this.ahHc.setUserData("external_network_ip", com.tencent.thumbplayer.d.a.kan());
        this.ahHd = true;
        AppMethodBeat.o(227007);
        return;
      }
      catch (Exception localException)
      {
        this.ahHe -= 1;
        com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException);
      }
    }
    else
    {
      AppMethodBeat.o(227007);
      return;
    }
    label272:
    this.ahHe -= 1;
    com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p so load failed");
    AppMethodBeat.o(227007);
  }
  
  private void kaw()
  {
    AppMethodBeat.i(227154);
    this.ahHc.setUserData("dl_param_play_start_time", Long.valueOf(this.emw));
    this.ahHc.setUserData("dl_param_play_end_time", Long.valueOf(this.ahHp));
    AppMethodBeat.o(227154);
  }
  
  private static TPDownloadParamData n(ArrayList<TPDownloadParamData> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(227142);
    if ((com.tencent.thumbplayer.utils.b.isEmpty(paramArrayList)) || (paramInt >= paramArrayList.size()))
    {
      AppMethodBeat.o(227142);
      return null;
    }
    paramArrayList = (TPDownloadParamData)paramArrayList.get(paramInt);
    AppMethodBeat.o(227142);
    return paramArrayList;
  }
  
  private boolean qH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(227015);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    paramString1 = new HashMap();
    paramString1.put("dl_param_data_transfer_mode", Integer.valueOf(1));
    paramString1 = new TPDownloadParam(localArrayList, 3, paramString1);
    boolean bool = this.ahHc.setClipInfo(this.ahHk, 2, paramString2, paramString1);
    AppMethodBeat.o(227015);
    return bool;
  }
  
  public final void Bh(long paramLong)
  {
    AppMethodBeat.i(227268);
    if (Oz(false))
    {
      AppMethodBeat.o(227268);
      return;
    }
    try
    {
      if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ahHn))
      {
        for (b localb = (b)this.ahHn.peek(); (localb != null) && (localb.ahHt != paramLong); localb = (b)this.ahHn.peek())
        {
          com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy definitionID:" + localb.ahHt + ", taskID:" + localb.ahHu);
          aHR(localb.ahHu);
          this.ahHn.removeFirst();
        }
        if (localb != null)
        {
          com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy task id:" + localb.ahHu);
          aHR(this.ahHk);
          this.ahHk = localb.ahHu;
          this.ahHn.remove(localb);
        }
      }
      AppMethodBeat.o(227268);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException, "playerSwitchDefComplete exception");
      AppMethodBeat.o(227268);
    }
  }
  
  public final void Oy(boolean paramBoolean)
  {
    this.ahHr = paramBoolean;
  }
  
  public final com.tencent.thumbplayer.a.a.e a(long paramLong, String paramString, TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(227243);
    if (paramTPVideoInfo == null)
    {
      paramString = new com.tencent.thumbplayer.a.a.e(paramString);
      AppMethodBeat.o(227243);
      return paramString;
    }
    TPDownloadParamData localTPDownloadParamData = null;
    if (paramTPVideoInfo.getDownloadPraramList() != null) {
      localTPDownloadParamData = (TPDownloadParamData)paramTPVideoInfo.getDownloadPraramList().get(0);
    }
    paramString = a(paramLong, paramString, localTPDownloadParamData);
    AppMethodBeat.o(227243);
    return paramString;
  }
  
  public final ITPMediaAsset a(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(227258);
    if ((Oz(false)) || (paramITPMediaAsset == null))
    {
      AppMethodBeat.o(227258);
      return paramITPMediaAsset;
    }
    if (this.ahHn == null) {
      this.ahHn = new LinkedList();
    }
    if (paramTPVideoInfo == null)
    {
      AppMethodBeat.o(227258);
      return paramITPMediaAsset;
    }
    if ((paramITPMediaAsset instanceof ITPMediaDRMAsset)) {
      if (paramTPVideoInfo.getDownloadPraramList() == null) {
        break label241;
      }
    }
    label241:
    for (paramTPVideoInfo = (TPDownloadParamData)paramTPVideoInfo.getDownloadPraramList().get(0);; paramTPVideoInfo = null)
    {
      paramTPVideoInfo = a(paramLong, ((ITPMediaDRMAsset)paramITPMediaAsset).getDrmPlayUrl(), paramTPVideoInfo);
      ((com.tencent.thumbplayer.c.g)paramITPMediaAsset).setDrmPlayUrl(paramTPVideoInfo.ahEf);
      AppMethodBeat.o(227258);
      return paramITPMediaAsset;
      List localList = c(paramITPMediaAsset);
      if ((!com.tencent.thumbplayer.utils.b.isEmpty(localList)) && (paramTPVideoInfo != null))
      {
        int i = a(localList, paramTPVideoInfo.getProxyFileID(), paramTPVideoInfo.getDownloadPraramList());
        if (i > 0)
        {
          this.ahHn.offer(new b(paramLong, i));
          com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
          AppMethodBeat.o(227258);
          return paramITPMediaAsset;
        }
        com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch clip def failed, cause : playId < 0");
      }
      AppMethodBeat.o(227258);
      return paramITPMediaAsset;
    }
  }
  
  public final String a(int paramInt, String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    i = 0;
    AppMethodBeat.i(227435);
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is empty");
      AppMethodBeat.o(227435);
      return paramString;
    }
    if (!com.tencent.thumbplayer.utils.b.bCj(paramString))
    {
      com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is locol url, not need use proxy");
      AppMethodBeat.o(227435);
      return paramString;
    }
    if (Oz(false))
    {
      com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz download proxy init failed");
      AppMethodBeat.o(227435);
      return paramString;
    }
    if (paramTPDownloadParamData != null) {
      str = paramString;
    }
    for (;;)
    {
      try
      {
        paramTPDownloadParamData = i.b(paramString, paramTPDownloadParamData);
        str = paramString;
        paramInt = this.ahHc.startPlay(com.tencent.thumbplayer.utils.b.aZS(paramString), paramTPDownloadParamData, this.ahHf);
        if (paramInt <= 0) {
          continue;
        }
        str = paramString;
        paramString = this.ahHc.getPlayUrl(paramInt, 1);
        str = paramString;
        this.ahHo.put(paramString, Integer.valueOf(paramInt));
      }
      finally
      {
        com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed:".concat(String.valueOf(paramString)));
        paramString = str;
        continue;
        if (paramInt != 2) {
          continue;
        }
        i = 3;
        continue;
        str = paramString;
        com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId < 0");
        continue;
      }
      AppMethodBeat.o(227435);
      return paramString;
      str = paramString;
      paramTPDownloadParamData = new ArrayList();
      str = paramString;
      paramTPDownloadParamData.add(paramString);
      if (paramInt != 3) {
        continue;
      }
      i = 10;
      str = paramString;
      paramTPDownloadParamData = new TPDownloadParam(paramTPDownloadParamData, i, null);
    }
  }
  
  public final void a(ITPPlayListener paramITPPlayListener)
  {
    this.ahHg = paramITPPlayListener;
  }
  
  public final void aHO(int paramInt)
  {
    AppMethodBeat.i(227452);
    com.tencent.thumbplayer.utils.g.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState: ".concat(String.valueOf(paramInt)));
    if (Oz(false))
    {
      AppMethodBeat.o(227452);
      return;
    }
    try
    {
      this.ahHc.setPlayState(this.ahHk, paramInt);
      if (((paramInt == 5) || (paramInt == 0)) && (!com.tencent.thumbplayer.utils.b.isEmpty(this.ahHn)))
      {
        Iterator localIterator = this.ahHn.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb != null)
          {
            com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState definitionID:" + localb.ahHt + ", taskID:" + localb.ahHu + ", state:" + paramInt);
            this.ahHc.setPlayState(localb.ahHu, paramInt);
          }
        }
      }
      AppMethodBeat.o(227452);
    }
    finally
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      AppMethodBeat.o(227452);
      return;
    }
  }
  
  public final ITPMediaAsset b(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(227295);
    if (Oz(true))
    {
      AppMethodBeat.o(227295);
      return paramITPMediaAsset;
    }
    kaw();
    if ((paramITPMediaAsset instanceof com.tencent.thumbplayer.c.g))
    {
      localObject = bGd(((com.tencent.thumbplayer.c.g)paramITPMediaAsset).getDrmPlayUrl());
      ((com.tencent.thumbplayer.c.g)paramITPMediaAsset).setDrmPlayUrl(((com.tencent.thumbplayer.a.a.e)localObject).ahEf);
      AppMethodBeat.o(227295);
      return paramITPMediaAsset;
    }
    Object localObject = c(paramITPMediaAsset);
    if (!com.tencent.thumbplayer.utils.b.isEmpty((Collection)localObject)) {
      this.ahHk = a((List)localObject, this.ahHj, this.ahHi);
    }
    AppMethodBeat.o(227295);
    return paramITPMediaAsset;
  }
  
  public final com.tencent.thumbplayer.a.a.e bGd(String paramString)
  {
    AppMethodBeat.i(227215);
    com.tencent.thumbplayer.a.a.e locale = new com.tencent.thumbplayer.a.a.e(paramString);
    if (!com.tencent.thumbplayer.utils.b.bCj(paramString))
    {
      AppMethodBeat.o(227215);
      return locale;
    }
    if (Oz(true))
    {
      AppMethodBeat.o(227215);
      return locale;
    }
    kaw();
    this.mOriginUrl = paramString;
    Object localObject2 = n(this.ahHi, 0);
    Object localObject1;
    if ((this.ahHr) && (localObject2 != null) && (((TPDownloadParamData)localObject2).getDlType() == 1))
    {
      localObject2 = new TPDownloadParamData(11);
      if (localObject2 != null) {
        localObject1 = i.b(paramString, (TPDownloadParamData)localObject2);
      }
    }
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder("single url:").append(paramString).append(", paramData.savePath:");
        if (localObject2 == null) {
          continue;
        }
        localObject3 = ((TPDownloadParamData)localObject2).getSavePath();
        localObject3 = localStringBuilder.append((String)localObject3).append(", paramData.DownloadFileID:");
        if (localObject2 == null) {
          break label344;
        }
        localObject2 = ((TPDownloadParamData)localObject2).getDownloadFileID();
        com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", (String)localObject2);
        this.ahHk = this.ahHc.startPlay(this.ahHj, (TPDownloadParam)localObject1, this.ahHf);
        if (this.ahHk <= 0) {
          continue;
        }
        localObject2 = this.ahHc.getPlayUrl(this.ahHk, 0);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = paramString;
        }
        com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "startDownloadPlay, playId:" + this.ahHk);
        locale.ahEf = ((String)localObject1);
        localObject1 = this.ahHc.getPlayUrl(this.ahHk, 1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
      }
      finally
      {
        Object localObject3;
        com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", paramString, "p2p proxy start play failed");
        continue;
        paramString = (String)localObject1;
        continue;
      }
      locale.ahEe = paramString;
      AppMethodBeat.o(227215);
      return locale;
      localObject1 = null;
      continue;
      localObject3 = "null";
      continue;
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId < 0");
      continue;
      break;
      label344:
      localObject2 = "null";
    }
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(227520);
    com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "onEvent eventId: " + paramInt1 + ", arg1: " + paramInt2 + ", arg2: " + paramInt3 + ", object" + paramObject);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(227520);
      return;
      aHS(13);
      AppMethodBeat.o(227520);
      return;
      aHS(14);
    }
  }
  
  public final boolean isEnable()
  {
    AppMethodBeat.i(227376);
    if (!Oz(false))
    {
      AppMethodBeat.o(227376);
      return true;
    }
    AppMethodBeat.o(227376);
    return false;
  }
  
  public final void kaq()
  {
    AppMethodBeat.i(227231);
    if (this.ahHq)
    {
      aHR(this.ahHk);
      bGd(this.mOriginUrl);
    }
    this.ahHq = false;
    AppMethodBeat.o(227231);
  }
  
  public final boolean kar()
  {
    AppMethodBeat.i(227282);
    if (Oz(false))
    {
      AppMethodBeat.o(227282);
      return false;
    }
    if ((this.ahHn != null) && (this.ahHn.size() > 0))
    {
      AppMethodBeat.o(227282);
      return true;
    }
    AppMethodBeat.o(227282);
    return false;
  }
  
  public final String kas()
  {
    AppMethodBeat.i(227387);
    if (Oz(false))
    {
      AppMethodBeat.o(227387);
      return null;
    }
    try
    {
      String str = this.ahHc.getPlayErrorCodeStr(this.ahHk);
      AppMethodBeat.o(227387);
      return str;
    }
    finally
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      AppMethodBeat.o(227387);
    }
    return null;
  }
  
  public final ITPPlayerProxyListener kat()
  {
    return this.ahHm;
  }
  
  public final void pM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227504);
    com.tencent.thumbplayer.utils.g.d("TPThumbPlayer[TPPlayManagerImpl.java]", "onNetworkStatusChanged oldNetStatus: " + paramInt1 + ", netStatus: " + paramInt2);
    if (paramInt2 == 1)
    {
      aHS(1);
      aHS(10);
      AppMethodBeat.o(227504);
      return;
    }
    if (paramInt2 == 2)
    {
      aHS(2);
      aHS(9);
      AppMethodBeat.o(227504);
      return;
    }
    if (paramInt2 == 3)
    {
      aHS(2);
      aHS(10);
    }
    AppMethodBeat.o(227504);
  }
  
  public final void pauseDownload()
  {
    AppMethodBeat.i(227307);
    aHP(this.ahHk);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ahHn))
    {
      localIterator = this.ahHn.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          aHP(localb.ahHu);
        }
      }
    }
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ahHo))
    {
      localIterator = this.ahHo.values().iterator();
      while (localIterator.hasNext()) {
        aHP(((Integer)localIterator.next()).intValue());
      }
    }
    AppMethodBeat.o(227307);
  }
  
  public final void pushEvent(int paramInt)
  {
    AppMethodBeat.i(227363);
    if (Oz(false))
    {
      AppMethodBeat.o(227363);
      return;
    }
    switch (paramInt)
    {
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      try
      {
        IllegalArgumentException localIllegalArgumentException1 = new IllegalArgumentException("event is invalid : ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(227363);
        throw localIllegalArgumentException1;
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localIllegalArgumentException2);
        AppMethodBeat.o(227363);
        return;
      }
    case 3: 
      paramInt = 3;
    }
    for (;;)
    {
      aHS(paramInt);
      AppMethodBeat.o(227363);
      return;
      paramInt = 4;
      continue;
      paramInt = 5;
      continue;
      paramInt = 6;
      continue;
      paramInt = 13;
      continue;
      paramInt = 14;
      continue;
      paramInt = 15;
      continue;
      paramInt = 16;
      continue;
      paramInt = 17;
      continue;
      paramInt = 18;
      continue;
      paramInt = 19;
      continue;
      paramInt = 20;
      continue;
      paramInt = 21;
    }
  }
  
  public final void qG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(227224);
    if ((!com.tencent.thumbplayer.utils.b.bCj(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramString1 = new Exception("illegal argument.");
      AppMethodBeat.o(227224);
      throw paramString1;
    }
    if (!this.ahHq)
    {
      if (!qH(paramString1, paramString2))
      {
        paramString1 = new Exception("setClipInfo err.");
        AppMethodBeat.o(227224);
        throw paramString1;
      }
    }
    else
    {
      aHR(this.ahHk);
      bGd(this.mOriginUrl);
      if (!qH(paramString1, paramString2))
      {
        paramString1 = new Exception("setClipInfo err.");
        AppMethodBeat.o(227224);
        throw paramString1;
      }
    }
    this.ahHq = true;
    AppMethodBeat.o(227224);
  }
  
  public final void release()
  {
    AppMethodBeat.i(227343);
    stopDownload();
    TPNetworkChangeMonitor.kbq().b(this);
    com.tencent.thumbplayer.utils.e.b(this);
    this.ahHm = null;
    this.ahHg = new d("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.ahHf = null;
    this.ahHc = null;
    AppMethodBeat.o(227343);
  }
  
  public final void resumeDownload()
  {
    AppMethodBeat.i(227317);
    aHQ(this.ahHk);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ahHn))
    {
      localIterator = this.ahHn.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          aHQ(localb.ahHu);
        }
      }
    }
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ahHo))
    {
      localIterator = this.ahHo.values().iterator();
      while (localIterator.hasNext()) {
        aHQ(((Integer)localIterator.next()).intValue());
      }
    }
    AppMethodBeat.o(227317);
  }
  
  public final void setIsActive(boolean paramBoolean)
  {
    AppMethodBeat.i(227198);
    com.tencent.thumbplayer.utils.g.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setIsActive: ".concat(String.valueOf(paramBoolean)));
    if (Oz(false))
    {
      AppMethodBeat.o(227198);
      return;
    }
    try
    {
      ITPDownloadProxy localITPDownloadProxy = this.ahHc;
      int j = this.ahHk;
      if (paramBoolean) {}
      for (int i = 101;; i = 100)
      {
        localITPDownloadProxy.setPlayState(j, i);
        AppMethodBeat.o(227198);
        return;
      }
      return;
    }
    finally
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      AppMethodBeat.o(227198);
    }
  }
  
  public final void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(227416);
    if (Oz(false))
    {
      AppMethodBeat.o(227416);
      return;
    }
    if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 100))
    {
      this.emw = paramTPOptionalParam.getParamLong().value;
      AppMethodBeat.o(227416);
      return;
    }
    if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 500))
    {
      this.ahHp = paramTPOptionalParam.getParamLong().value;
      if (this.ahHk > 0) {
        this.ahHc.setUserData("dl_param_play_end_time", Long.valueOf(this.ahHp));
      }
    }
    AppMethodBeat.o(227416);
  }
  
  public final void setProxyServiceType(int paramInt)
  {
    this.mServiceType = paramInt;
  }
  
  public final void setTPPlayerProxyListener(ITPPlayerProxyListener paramITPPlayerProxyListener)
  {
    this.ahHm = paramITPPlayerProxyListener;
  }
  
  public final void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(227468);
    if (paramTPVideoInfo == null)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, param is null ");
      AppMethodBeat.o(227468);
      return;
    }
    if ((this.ahHl != null) && (!Oz(false)))
    {
      this.ahHl = paramTPVideoInfo;
      if ((paramTPVideoInfo != null) && (paramTPVideoInfo.getDownloadPraramList() != null)) {
        break label121;
      }
      com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "video or downloadParamList is null, return");
    }
    for (;;)
    {
      this.ahHl = paramTPVideoInfo;
      com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, enter");
      this.ahHj = paramTPVideoInfo.getProxyFileID();
      if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ahHi)) {
        this.ahHi.clear();
      }
      this.ahHi.addAll(paramTPVideoInfo.getDownloadPraramList());
      AppMethodBeat.o(227468);
      return;
      label121:
      if (this.ahHk <= 0)
      {
        com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy not start, return");
      }
      else
      {
        ArrayList localArrayList = paramTPVideoInfo.getDownloadPraramList();
        int i = 0;
        while (i < localArrayList.size())
        {
          TPDownloadParamData localTPDownloadParamData = (TPDownloadParamData)localArrayList.get(i);
          TPDownloadParam localTPDownloadParam = i.b(localTPDownloadParamData.getUrl(), localTPDownloadParamData);
          if (!this.ahHc.setClipInfo(this.ahHk, localTPDownloadParamData.getClipNo(), localTPDownloadParamData.getDownloadFileID(), localTPDownloadParam)) {
            com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "setClipInfo failed, playID:" + this.ahHk + ", clipNo:" + localTPDownloadParamData.getClipNo() + ", downloadFileID:" + localTPDownloadParamData.getDownloadFileID());
          }
          i += 1;
        }
      }
    }
  }
  
  public final void stopDownload()
  {
    AppMethodBeat.i(227331);
    if (this.ahHk < 0)
    {
      com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload failed, coz playId:" + this.ahHk + ", less than zero. maybe download proxy didn't started");
      AppMethodBeat.o(227331);
      return;
    }
    com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload, playId:" + this.ahHk);
    aHR(this.ahHk);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ahHn))
    {
      localIterator = this.ahHn.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          aHR(localb.ahHu);
        }
      }
      this.ahHn.clear();
    }
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ahHo))
    {
      localIterator = this.ahHo.values().iterator();
      while (localIterator.hasNext()) {
        aHR(((Integer)localIterator.next()).intValue());
      }
      this.ahHo.clear();
    }
    this.ahHk = -1;
    com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "reset");
    this.ahHj = "";
    this.mOriginUrl = "";
    this.ahHl = null;
    this.emw = 0L;
    this.ahHp = 0L;
    this.ahHq = false;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ahHi)) {
      this.ahHi.clear();
    }
    AppMethodBeat.o(227331);
  }
  
  final class a
    implements ITPPlayListener
  {
    private a() {}
    
    public final long getAdvRemainTime()
    {
      AppMethodBeat.i(227131);
      long l = c.a(c.this).getAdvRemainTime();
      AppMethodBeat.o(227131);
      return l;
    }
    
    public final String getContentType(int paramInt, String paramString)
    {
      AppMethodBeat.i(227183);
      paramString = c.a(c.this).getContentType(paramInt, paramString);
      AppMethodBeat.o(227183);
      return paramString;
    }
    
    public final int getCurrentPlayClipNo()
    {
      AppMethodBeat.i(227124);
      int i = c.a(c.this).getCurrentPlayClipNo();
      AppMethodBeat.o(227124);
      return i;
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(227118);
      long l = c.a(c.this).getCurrentPosition();
      AppMethodBeat.o(227118);
      return l;
    }
    
    public final String getDataFilePath(int paramInt, String paramString)
    {
      AppMethodBeat.i(227176);
      paramString = c.a(c.this).getDataFilePath(paramInt, paramString);
      AppMethodBeat.o(227176);
      return paramString;
    }
    
    public final long getDataTotalSize(int paramInt, String paramString)
    {
      AppMethodBeat.i(227169);
      long l = c.a(c.this).getDataTotalSize(paramInt, paramString);
      AppMethodBeat.o(227169);
      return l;
    }
    
    public final Object getPlayInfo(long paramLong)
    {
      AppMethodBeat.i(227137);
      Object localObject = c.a(c.this).getPlayInfo(paramLong);
      AppMethodBeat.o(227137);
      return localObject;
    }
    
    public final Object getPlayInfo(String paramString)
    {
      AppMethodBeat.i(227144);
      paramString = c.a(c.this).getPlayInfo(paramString);
      AppMethodBeat.o(227144);
      return paramString;
    }
    
    public final long getPlayerBufferLength()
    {
      AppMethodBeat.i(227108);
      long l = c.a(c.this).getPlayerBufferLength();
      AppMethodBeat.o(227108);
      return l;
    }
    
    public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
    {
      AppMethodBeat.i(227094);
      c.a(c.this).onDownloadCdnUrlExpired(paramMap);
      AppMethodBeat.o(227094);
    }
    
    public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(227071);
      c.a(c.this).onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(227071);
    }
    
    public final void onDownloadCdnUrlUpdate(String paramString)
    {
      AppMethodBeat.i(227061);
      c.a(c.this).onDownloadCdnUrlUpdate(paramString);
      AppMethodBeat.o(227061);
    }
    
    public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(227054);
      c.a(c.this).onDownloadError(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(227054);
    }
    
    public final void onDownloadFinish()
    {
      AppMethodBeat.i(227048);
      c.a(c.this).onDownloadFinish();
      AppMethodBeat.o(227048);
    }
    
    public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
    {
      AppMethodBeat.i(227042);
      c.a(c.this).onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2, paramString);
      AppMethodBeat.o(227042);
    }
    
    public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
    {
      AppMethodBeat.i(227085);
      c.a(c.this).onDownloadProtocolUpdate(paramString1, paramString2);
      AppMethodBeat.o(227085);
    }
    
    public final void onDownloadStatusUpdate(int paramInt)
    {
      AppMethodBeat.i(227077);
      c.a(c.this).onDownloadStatusUpdate(paramInt);
      AppMethodBeat.o(227077);
    }
    
    public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      AppMethodBeat.i(227101);
      paramObject1 = c.a(c.this).onPlayCallback(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
      AppMethodBeat.o(227101);
      return paramObject1;
    }
    
    public final int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(227156);
      paramInt = c.a(c.this).onReadData(paramInt, paramString, paramLong1, paramLong2);
      AppMethodBeat.o(227156);
      return paramInt;
    }
    
    public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(227150);
      paramInt = c.a(c.this).onStartReadData(paramInt, paramString, paramLong1, paramLong2);
      AppMethodBeat.o(227150);
      return paramInt;
    }
    
    public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(227163);
      paramInt1 = c.a(c.this).onStopReadData(paramInt1, paramString, paramInt2);
      AppMethodBeat.o(227163);
      return paramInt1;
    }
  }
  
  static final class b
  {
    long ahHt;
    int ahHu;
    
    b(long paramLong, int paramInt)
    {
      this.ahHt = paramLong;
      this.ahHu = paramInt;
    }
  }
  
  static final class c
  {
    int ahHv;
    int ahHw;
    
    c(int paramInt1, int paramInt2)
    {
      this.ahHv = paramInt1;
      this.ahHw = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.e.c
 * JD-Core Version:    0.7.0.1
 */