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
  private static int RZu = -1;
  private LinkedList<b> RZA;
  private HashMap<String, Integer> RZB;
  private long RZC;
  private boolean RZD;
  private boolean RZE;
  private ITPDownloadProxy RZp;
  private boolean RZq;
  private int RZr;
  private a RZs;
  private ITPPlayListener RZt;
  private ArrayList<TPDownloadParamData> RZv;
  private String RZw;
  private int RZx;
  private TPVideoInfo RZy;
  private ITPPlayerProxyListener RZz;
  private long cwj;
  private Context mContext;
  private String mOriginUrl;
  private int mServiceType;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(189169);
    this.RZq = false;
    this.RZr = 3;
    this.mServiceType = RZu;
    this.RZx = -1;
    this.RZz = null;
    this.RZD = false;
    this.RZE = false;
    this.mContext = paramContext;
    com.tencent.thumbplayer.utils.e.a(this);
    TPNetworkChangeMonitor.hop().a(this);
    this.RZs = new a((byte)0);
    this.RZt = new d("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.RZB = new HashMap();
    this.RZv = new ArrayList();
    AppMethodBeat.o(189169);
  }
  
  private boolean DW(boolean paramBoolean)
  {
    AppMethodBeat.i(189199);
    if (!com.tencent.thumbplayer.d.a.hnj())
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "config set don't use p2p proxy!");
      AppMethodBeat.o(189199);
      return true;
    }
    if (paramBoolean) {
      this.RZr = 3;
    }
    hny();
    if (!this.RZq)
    {
      AppMethodBeat.o(189199);
      return true;
    }
    AppMethodBeat.o(189199);
    return false;
  }
  
  private int a(List<ITPMediaTrackClip> paramList, String paramString, ArrayList<TPDownloadParamData> paramArrayList)
  {
    AppMethodBeat.i(189187);
    if (com.tencent.thumbplayer.utils.b.isEmpty(paramList))
    {
      com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "clipList is empty, return");
      AppMethodBeat.o(189187);
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
      if ((!(localObject2 instanceof com.tencent.thumbplayer.c.e)) || (!com.tencent.thumbplayer.utils.b.bnL(((com.tencent.thumbplayer.c.e)localObject2).getFilePath()))) {
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
        AppMethodBeat.o(189187);
        return -1;
      }
      i = this.RZp.startClipPlay(paramString, ((HashMap)localObject1).size(), this.RZs);
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
            Object localObject3 = e(paramArrayList, paramString.RZJ);
            if (localObject3 == null)
            {
              com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "fatal err, paramData is null.");
              AppMethodBeat.o(189187);
              return -1;
            }
            com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "multi trackClipIndex:" + paramString.RZJ + ", download seq:" + paramString.RZI + ", clip.url:" + ((com.tencent.thumbplayer.c.e)localObject1).getUrl() + ", clip.getFilePath:" + ((com.tencent.thumbplayer.c.e)localObject1).getFilePath() + ", paramData.savePath:" + ((TPDownloadParamData)localObject3).getSavePath() + ", paramData.DownloadFileID:" + ((TPDownloadParamData)localObject3).getDownloadFileID());
            localObject2 = ((TPDownloadParamData)localObject3).getDownloadFileID();
            localObject3 = a(((com.tencent.thumbplayer.c.e)localObject1).getFilePath(), (TPDownloadParamData)localObject3);
            if (this.RZp.setClipInfo(i, paramString.RZI, (String)localObject2, (TPDownloadParam)localObject3)) {
              ((com.tencent.thumbplayer.c.e)localObject1).RYW = this.RZp.getClipPlayUrl(i, paramString.RZI, 1);
            }
          }
        }
      }
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start clip play failed, cause : playId < 0");
      AppMethodBeat.o(189187);
      return i;
    }
  }
  
  private com.tencent.thumbplayer.a.a.e a(long paramLong, String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    String str = null;
    AppMethodBeat.i(189178);
    com.tencent.thumbplayer.a.a.e locale = new com.tencent.thumbplayer.a.a.e(paramString);
    if (!com.tencent.thumbplayer.utils.b.bnL(paramString))
    {
      AppMethodBeat.o(189178);
      return locale;
    }
    if (DW(false))
    {
      AppMethodBeat.o(189178);
      return locale;
    }
    if (this.RZA == null) {
      this.RZA = new LinkedList();
    }
    if (paramTPDownloadParamData != null) {}
    for (Object localObject = a(paramString, paramTPDownloadParamData);; localObject = null)
    {
      if (paramTPDownloadParamData != null) {}
      try
      {
        str = paramTPDownloadParamData.getDownloadFileID();
        i = this.RZp.startPlay(str, (TPDownloadParam)localObject, this.RZs);
        if (i <= 0) {
          break;
        }
        localObject = this.RZp.getPlayUrl(i, 1);
        paramTPDownloadParamData = (TPDownloadParamData)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramTPDownloadParamData = paramString;
        }
        locale.RWt = paramTPDownloadParamData;
        paramTPDownloadParamData = this.RZp.getPlayUrl(this.RZx, 0);
        if (!TextUtils.isEmpty(paramTPDownloadParamData)) {
          break label281;
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          int i;
          com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", paramString, "p2p proxy switch def failed");
          continue;
          paramString = paramTPDownloadParamData;
        }
      }
      locale.RWs = paramString;
      this.RZA.offer(new b(paramLong, i));
      com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
      AppMethodBeat.o(189178);
      return locale;
    }
    com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def failed, cause : playId < 0");
    AppMethodBeat.o(189178);
    return locale;
  }
  
  private static TPDownloadParam a(String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(258479);
    paramString = i.b(paramString, paramTPDownloadParamData);
    AppMethodBeat.o(258479);
    return paramString;
  }
  
  private void arp(int paramInt)
  {
    AppMethodBeat.i(189183);
    if (DW(false))
    {
      AppMethodBeat.o(189183);
      return;
    }
    try
    {
      this.RZp.pauseDownload(paramInt);
      AppMethodBeat.o(189183);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pause download failed, taskId:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(189183);
    }
  }
  
  private void arq(int paramInt)
  {
    AppMethodBeat.i(189185);
    if (DW(false))
    {
      AppMethodBeat.o(189185);
      return;
    }
    try
    {
      this.RZp.resumeDownload(this.RZx);
      AppMethodBeat.o(189185);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy resume download failed, taskId:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(189185);
    }
  }
  
  private void arr(int paramInt)
  {
    AppMethodBeat.i(189190);
    if (DW(false))
    {
      AppMethodBeat.o(189190);
      return;
    }
    try
    {
      this.RZp.stopPlay(paramInt);
      AppMethodBeat.o(189190);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy stop play failed, taskID:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(189190);
    }
  }
  
  private void ars(int paramInt)
  {
    AppMethodBeat.i(189191);
    if (DW(false))
    {
      AppMethodBeat.o(189191);
      return;
    }
    try
    {
      this.RZp.pushEvent(paramInt);
      AppMethodBeat.o(189191);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pushEvent failed, event:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(189191);
    }
  }
  
  private static List<ITPMediaTrackClip> c(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(189186);
    if ((paramITPMediaAsset instanceof com.tencent.thumbplayer.c.b))
    {
      paramITPMediaAsset = ((com.tencent.thumbplayer.c.b)paramITPMediaAsset).getAllAVTracks();
      if (!com.tencent.thumbplayer.utils.b.isEmpty(paramITPMediaAsset))
      {
        paramITPMediaAsset = (ITPMediaTrack)paramITPMediaAsset.get(0);
        if ((paramITPMediaAsset != null) && (!com.tencent.thumbplayer.utils.b.isEmpty(paramITPMediaAsset.getAllTrackClips())))
        {
          paramITPMediaAsset = paramITPMediaAsset.getAllTrackClips();
          AppMethodBeat.o(189186);
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
        AppMethodBeat.o(189186);
        return paramITPMediaAsset;
      }
    }
    else if ((paramITPMediaAsset instanceof ITPMediaTrackClip))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add((ITPMediaTrackClip)paramITPMediaAsset);
      AppMethodBeat.o(189186);
      return localArrayList;
    }
    AppMethodBeat.o(189186);
    return null;
  }
  
  private static TPDownloadParamData e(ArrayList<TPDownloadParamData> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(189201);
    if ((com.tencent.thumbplayer.utils.b.isEmpty(paramArrayList)) || (paramInt >= paramArrayList.size()))
    {
      AppMethodBeat.o(189201);
      return null;
    }
    paramArrayList = (TPDownloadParamData)paramArrayList.get(paramInt);
    AppMethodBeat.o(189201);
    return paramArrayList;
  }
  
  private void hny()
  {
    AppMethodBeat.i(189170);
    if (this.RZq)
    {
      AppMethodBeat.o(189170);
      return;
    }
    if (this.RZr > 0)
    {
      try
      {
        if (this.mServiceType == RZu) {
          this.mServiceType = com.tencent.thumbplayer.d.a.hns();
        }
        b localb = g.a.hnA().aru(this.mServiceType);
        if ((localb == null) || (localb.hnx() == null)) {
          break label272;
        }
        this.RZp = localb.hnx();
        this.RZp.setUserData("qq_is_vip", Boolean.valueOf(com.tencent.thumbplayer.d.a.hnr()));
        if (!TextUtils.isEmpty(com.tencent.thumbplayer.d.a.hnn())) {
          this.RZp.setUserData("user_uin", com.tencent.thumbplayer.d.a.hnn());
        }
        if (!TextUtils.isEmpty(com.tencent.thumbplayer.d.a.getAppVersionName(this.mContext))) {
          this.RZp.setUserData("app_version_name", com.tencent.thumbplayer.d.a.getAppVersionName(this.mContext));
        }
        if (com.tencent.thumbplayer.d.a.li(this.mContext) != -1L) {
          this.RZp.setUserData("app_version_code", String.valueOf(com.tencent.thumbplayer.d.a.li(this.mContext)));
        }
        this.RZp.setUserData("carrier_pesudo_code", com.tencent.thumbplayer.d.a.hno());
        this.RZp.setUserData("carrier_pesudo_state", Integer.valueOf(com.tencent.thumbplayer.d.a.hnp()));
        this.RZp.setUserData("external_network_ip", com.tencent.thumbplayer.d.a.hnq());
        this.RZq = true;
        AppMethodBeat.o(189170);
        return;
      }
      catch (Exception localException)
      {
        this.RZr -= 1;
        com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException);
      }
    }
    else
    {
      AppMethodBeat.o(189170);
      return;
    }
    label272:
    this.RZr -= 1;
    com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p so load failed");
    AppMethodBeat.o(189170);
  }
  
  private void hnz()
  {
    AppMethodBeat.i(189202);
    this.RZp.setUserData("dl_param_play_start_time", Long.valueOf(this.cwj));
    this.RZp.setUserData("dl_param_play_end_time", Long.valueOf(this.RZC));
    AppMethodBeat.o(189202);
  }
  
  private boolean nN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189173);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    paramString1 = new HashMap();
    paramString1.put("dl_param_data_transfer_mode", Integer.valueOf(1));
    paramString1 = new TPDownloadParam(localArrayList, 3, paramString1);
    boolean bool = this.RZp.setClipInfo(this.RZx, 2, paramString2, paramString1);
    AppMethodBeat.o(189173);
    return bool;
  }
  
  public final void DV(boolean paramBoolean)
  {
    this.RZE = paramBoolean;
  }
  
  public final void OE(long paramLong)
  {
    AppMethodBeat.i(189179);
    if (DW(false))
    {
      AppMethodBeat.o(189179);
      return;
    }
    try
    {
      if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZA))
      {
        for (b localb = (b)this.RZA.peek(); (localb != null) && (localb.RZG != paramLong); localb = (b)this.RZA.peek())
        {
          com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy definitionID:" + localb.RZG + ", taskID:" + localb.RZH);
          arr(localb.RZH);
          this.RZA.removeFirst();
        }
        if (localb != null)
        {
          com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy task id:" + localb.RZH);
          arr(this.RZx);
          this.RZx = localb.RZH;
          this.RZA.remove(localb);
        }
      }
      AppMethodBeat.o(189179);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException, "playerSwitchDefComplete exception");
      AppMethodBeat.o(189179);
    }
  }
  
  public final com.tencent.thumbplayer.a.a.e a(long paramLong, String paramString, TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(189176);
    if (paramTPVideoInfo == null)
    {
      paramString = new com.tencent.thumbplayer.a.a.e(paramString);
      AppMethodBeat.o(189176);
      return paramString;
    }
    TPDownloadParamData localTPDownloadParamData = null;
    if (paramTPVideoInfo.getDownloadPraramList() != null) {
      localTPDownloadParamData = (TPDownloadParamData)paramTPVideoInfo.getDownloadPraramList().get(0);
    }
    paramString = a(paramLong, paramString, localTPDownloadParamData);
    AppMethodBeat.o(189176);
    return paramString;
  }
  
  public final ITPMediaAsset a(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(189177);
    if ((DW(false)) || (paramITPMediaAsset == null))
    {
      AppMethodBeat.o(189177);
      return paramITPMediaAsset;
    }
    if (this.RZA == null) {
      this.RZA = new LinkedList();
    }
    if (paramTPVideoInfo == null)
    {
      AppMethodBeat.o(189177);
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
      ((com.tencent.thumbplayer.c.g)paramITPMediaAsset).setDrmPlayUrl(paramTPVideoInfo.RWt);
      AppMethodBeat.o(189177);
      return paramITPMediaAsset;
      List localList = c(paramITPMediaAsset);
      if ((!com.tencent.thumbplayer.utils.b.isEmpty(localList)) && (paramTPVideoInfo != null))
      {
        int i = a(localList, paramTPVideoInfo.getProxyFileID(), paramTPVideoInfo.getDownloadPraramList());
        if (i > 0)
        {
          this.RZA.offer(new b(paramLong, i));
          com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
          AppMethodBeat.o(189177);
          return paramITPMediaAsset;
        }
        com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch clip def failed, cause : playId < 0");
      }
      AppMethodBeat.o(189177);
      return paramITPMediaAsset;
    }
  }
  
  public final String a(int paramInt, String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    i = 0;
    AppMethodBeat.i(189196);
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is empty");
      AppMethodBeat.o(189196);
      return paramString;
    }
    if (!com.tencent.thumbplayer.utils.b.bnL(paramString))
    {
      com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is locol url, not need use proxy");
      AppMethodBeat.o(189196);
      return paramString;
    }
    if (DW(false))
    {
      com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz download proxy init failed");
      AppMethodBeat.o(189196);
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
        paramInt = this.RZp.startPlay(com.tencent.thumbplayer.utils.b.aSu(paramString), paramTPDownloadParamData, this.RZs);
        if (paramInt <= 0) {
          continue;
        }
        str = paramString;
        paramString = this.RZp.getPlayUrl(paramInt, 1);
        str = paramString;
        this.RZB.put(paramString, Integer.valueOf(paramInt));
      }
      catch (Throwable paramString)
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
      AppMethodBeat.o(189196);
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
    this.RZt = paramITPPlayListener;
  }
  
  public final void aro(int paramInt)
  {
    AppMethodBeat.i(189197);
    com.tencent.thumbplayer.utils.g.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState: ".concat(String.valueOf(paramInt)));
    if (DW(false))
    {
      AppMethodBeat.o(189197);
      return;
    }
    try
    {
      this.RZp.setPlayState(this.RZx, paramInt);
      if (((paramInt == 5) || (paramInt == 0)) && (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZA)))
      {
        Iterator localIterator = this.RZA.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb != null)
          {
            com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState definitionID:" + localb.RZG + ", taskID:" + localb.RZH + ", state:" + paramInt);
            this.RZp.setPlayState(localb.RZH, paramInt);
          }
        }
      }
      AppMethodBeat.o(189197);
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      AppMethodBeat.o(189197);
      return;
    }
  }
  
  public final ITPMediaAsset b(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(189181);
    if (DW(true))
    {
      AppMethodBeat.o(189181);
      return paramITPMediaAsset;
    }
    hnz();
    if ((paramITPMediaAsset instanceof com.tencent.thumbplayer.c.g))
    {
      localObject = bqC(((com.tencent.thumbplayer.c.g)paramITPMediaAsset).getDrmPlayUrl());
      ((com.tencent.thumbplayer.c.g)paramITPMediaAsset).setDrmPlayUrl(((com.tencent.thumbplayer.a.a.e)localObject).RWt);
      AppMethodBeat.o(189181);
      return paramITPMediaAsset;
    }
    Object localObject = c(paramITPMediaAsset);
    if (!com.tencent.thumbplayer.utils.b.isEmpty((Collection)localObject)) {
      this.RZx = a((List)localObject, this.RZw, this.RZv);
    }
    AppMethodBeat.o(189181);
    return paramITPMediaAsset;
  }
  
  public final com.tencent.thumbplayer.a.a.e bqC(String paramString)
  {
    AppMethodBeat.i(189172);
    com.tencent.thumbplayer.a.a.e locale = new com.tencent.thumbplayer.a.a.e(paramString);
    if (!com.tencent.thumbplayer.utils.b.bnL(paramString))
    {
      AppMethodBeat.o(189172);
      return locale;
    }
    if (DW(true))
    {
      AppMethodBeat.o(189172);
      return locale;
    }
    hnz();
    this.mOriginUrl = paramString;
    Object localObject2 = e(this.RZv, 0);
    Object localObject1;
    if ((this.RZE) && (localObject2 != null) && (((TPDownloadParamData)localObject2).getDlType() == 1))
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
        this.RZx = this.RZp.startPlay(this.RZw, (TPDownloadParam)localObject1, this.RZs);
        if (this.RZx <= 0) {
          continue;
        }
        localObject2 = this.RZp.getPlayUrl(this.RZx, 0);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = paramString;
        }
        com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "startDownloadPlay, playId:" + this.RZx);
        locale.RWt = ((String)localObject1);
        localObject1 = this.RZp.getPlayUrl(this.RZx, 1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
      }
      catch (Throwable paramString)
      {
        Object localObject3;
        com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", paramString, "p2p proxy start play failed");
        continue;
        paramString = (String)localObject1;
        continue;
      }
      locale.RWs = paramString;
      AppMethodBeat.o(189172);
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
    AppMethodBeat.i(189204);
    com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "onEvent eventId: " + paramInt1 + ", arg1: " + paramInt2 + ", arg2: " + paramInt3 + ", object" + paramObject);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(189204);
      return;
      ars(13);
      AppMethodBeat.o(189204);
      return;
      ars(14);
    }
  }
  
  public final void hnt()
  {
    AppMethodBeat.i(189175);
    if (this.RZD)
    {
      arr(this.RZx);
      bqC(this.mOriginUrl);
    }
    this.RZD = false;
    AppMethodBeat.o(189175);
  }
  
  public final boolean hnu()
  {
    AppMethodBeat.i(189180);
    if (DW(false))
    {
      AppMethodBeat.o(189180);
      return false;
    }
    if ((this.RZA != null) && (this.RZA.size() > 0))
    {
      AppMethodBeat.o(189180);
      return true;
    }
    AppMethodBeat.o(189180);
    return false;
  }
  
  public final String hnv()
  {
    AppMethodBeat.i(189194);
    if (DW(false))
    {
      AppMethodBeat.o(189194);
      return null;
    }
    try
    {
      String str = this.RZp.getPlayErrorCodeStr(this.RZx);
      AppMethodBeat.o(189194);
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      AppMethodBeat.o(189194);
    }
    return null;
  }
  
  public final ITPPlayerProxyListener hnw()
  {
    return this.RZz;
  }
  
  public final boolean isEnable()
  {
    AppMethodBeat.i(189193);
    if (!DW(false))
    {
      AppMethodBeat.o(189193);
      return true;
    }
    AppMethodBeat.o(189193);
    return false;
  }
  
  public final void my(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189203);
    com.tencent.thumbplayer.utils.g.d("TPThumbPlayer[TPPlayManagerImpl.java]", "onNetworkStatusChanged oldNetStatus: " + paramInt1 + ", netStatus: " + paramInt2);
    if (paramInt2 == 1)
    {
      ars(1);
      ars(10);
      AppMethodBeat.o(189203);
      return;
    }
    if (paramInt2 == 2)
    {
      ars(2);
      ars(9);
      AppMethodBeat.o(189203);
      return;
    }
    if (paramInt2 == 3)
    {
      ars(2);
      ars(10);
    }
    AppMethodBeat.o(189203);
  }
  
  public final void nM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189174);
    if ((!com.tencent.thumbplayer.utils.b.bnL(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramString1 = new Exception("illegal argument.");
      AppMethodBeat.o(189174);
      throw paramString1;
    }
    if (!this.RZD)
    {
      if (!nN(paramString1, paramString2))
      {
        paramString1 = new Exception("setClipInfo err.");
        AppMethodBeat.o(189174);
        throw paramString1;
      }
    }
    else
    {
      arr(this.RZx);
      bqC(this.mOriginUrl);
      if (!nN(paramString1, paramString2))
      {
        paramString1 = new Exception("setClipInfo err.");
        AppMethodBeat.o(189174);
        throw paramString1;
      }
    }
    this.RZD = true;
    AppMethodBeat.o(189174);
  }
  
  public final void pauseDownload()
  {
    AppMethodBeat.i(189182);
    arp(this.RZx);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZA))
    {
      localIterator = this.RZA.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          arp(localb.RZH);
        }
      }
    }
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZB))
    {
      localIterator = this.RZB.values().iterator();
      while (localIterator.hasNext()) {
        arp(((Integer)localIterator.next()).intValue());
      }
    }
    AppMethodBeat.o(189182);
  }
  
  public final void pushEvent(int paramInt)
  {
    AppMethodBeat.i(189192);
    if (DW(false))
    {
      AppMethodBeat.o(189192);
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
        AppMethodBeat.o(189192);
        throw localIllegalArgumentException1;
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localIllegalArgumentException2);
        AppMethodBeat.o(189192);
        return;
      }
    case 3: 
      paramInt = 3;
    }
    for (;;)
    {
      ars(paramInt);
      AppMethodBeat.o(189192);
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
  
  public final void release()
  {
    AppMethodBeat.i(189189);
    stopDownload();
    TPNetworkChangeMonitor.hop().b(this);
    com.tencent.thumbplayer.utils.e.b(this);
    this.RZz = null;
    this.RZt = new d("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.RZs = null;
    this.RZp = null;
    AppMethodBeat.o(189189);
  }
  
  public final void resumeDownload()
  {
    AppMethodBeat.i(189184);
    arq(this.RZx);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZA))
    {
      localIterator = this.RZA.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          arq(localb.RZH);
        }
      }
    }
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZB))
    {
      localIterator = this.RZB.values().iterator();
      while (localIterator.hasNext()) {
        arq(((Integer)localIterator.next()).intValue());
      }
    }
    AppMethodBeat.o(189184);
  }
  
  public final void setIsActive(boolean paramBoolean)
  {
    AppMethodBeat.i(189171);
    com.tencent.thumbplayer.utils.g.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setIsActive: ".concat(String.valueOf(paramBoolean)));
    if (DW(false))
    {
      AppMethodBeat.o(189171);
      return;
    }
    try
    {
      ITPDownloadProxy localITPDownloadProxy = this.RZp;
      int j = this.RZx;
      if (paramBoolean) {}
      for (int i = 101;; i = 100)
      {
        localITPDownloadProxy.setPlayState(j, i);
        AppMethodBeat.o(189171);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      AppMethodBeat.o(189171);
    }
  }
  
  public final void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(189195);
    if (DW(false))
    {
      AppMethodBeat.o(189195);
      return;
    }
    if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 100))
    {
      this.cwj = paramTPOptionalParam.getParamLong().value;
      AppMethodBeat.o(189195);
      return;
    }
    if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 500))
    {
      this.RZC = paramTPOptionalParam.getParamLong().value;
      if (this.RZx > 0) {
        this.RZp.setUserData("dl_param_play_end_time", Long.valueOf(this.RZC));
      }
    }
    AppMethodBeat.o(189195);
  }
  
  public final void setProxyServiceType(int paramInt)
  {
    this.mServiceType = paramInt;
  }
  
  public final void setTPPlayerProxyListener(ITPPlayerProxyListener paramITPPlayerProxyListener)
  {
    this.RZz = paramITPPlayerProxyListener;
  }
  
  public final void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(189198);
    if (paramTPVideoInfo == null)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, param is null ");
      AppMethodBeat.o(189198);
      return;
    }
    if ((this.RZy != null) && (!DW(false)))
    {
      this.RZy = paramTPVideoInfo;
      if ((paramTPVideoInfo != null) && (paramTPVideoInfo.getDownloadPraramList() != null)) {
        break label121;
      }
      com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "video or downloadParamList is null, return");
    }
    for (;;)
    {
      this.RZy = paramTPVideoInfo;
      com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, enter");
      this.RZw = paramTPVideoInfo.getProxyFileID();
      if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZv)) {
        this.RZv.clear();
      }
      this.RZv.addAll(paramTPVideoInfo.getDownloadPraramList());
      AppMethodBeat.o(189198);
      return;
      label121:
      if (this.RZx <= 0)
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
          if (!this.RZp.setClipInfo(this.RZx, localTPDownloadParamData.getClipNo(), localTPDownloadParamData.getDownloadFileID(), localTPDownloadParam)) {
            com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "setClipInfo failed, playID:" + this.RZx + ", clipNo:" + localTPDownloadParamData.getClipNo() + ", downloadFileID:" + localTPDownloadParamData.getDownloadFileID());
          }
          i += 1;
        }
      }
    }
  }
  
  public final void stopDownload()
  {
    AppMethodBeat.i(189188);
    if (this.RZx < 0)
    {
      com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload failed, coz playId:" + this.RZx + ", less than zero. maybe download proxy didn't started");
      AppMethodBeat.o(189188);
      return;
    }
    com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload, playId:" + this.RZx);
    arr(this.RZx);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZA))
    {
      localIterator = this.RZA.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          arr(localb.RZH);
        }
      }
      this.RZA.clear();
    }
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZB))
    {
      localIterator = this.RZB.values().iterator();
      while (localIterator.hasNext()) {
        arr(((Integer)localIterator.next()).intValue());
      }
      this.RZB.clear();
    }
    this.RZx = -1;
    com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "reset");
    this.RZw = "";
    this.mOriginUrl = "";
    this.RZy = null;
    this.cwj = 0L;
    this.RZC = 0L;
    this.RZD = false;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZv)) {
      this.RZv.clear();
    }
    AppMethodBeat.o(189188);
  }
  
  final class a
    implements ITPPlayListener
  {
    private a() {}
    
    public final long getAdvRemainTime()
    {
      AppMethodBeat.i(189160);
      long l = c.a(c.this).getAdvRemainTime();
      AppMethodBeat.o(189160);
      return l;
    }
    
    public final String getContentType(int paramInt, String paramString)
    {
      AppMethodBeat.i(189168);
      paramString = c.a(c.this).getContentType(paramInt, paramString);
      AppMethodBeat.o(189168);
      return paramString;
    }
    
    public final int getCurrentPlayClipNo()
    {
      AppMethodBeat.i(189159);
      int i = c.a(c.this).getCurrentPlayClipNo();
      AppMethodBeat.o(189159);
      return i;
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(189158);
      long l = c.a(c.this).getCurrentPosition();
      AppMethodBeat.o(189158);
      return l;
    }
    
    public final String getDataFilePath(int paramInt, String paramString)
    {
      AppMethodBeat.i(189167);
      paramString = c.a(c.this).getDataFilePath(paramInt, paramString);
      AppMethodBeat.o(189167);
      return paramString;
    }
    
    public final long getDataTotalSize(int paramInt, String paramString)
    {
      AppMethodBeat.i(189166);
      long l = c.a(c.this).getDataTotalSize(paramInt, paramString);
      AppMethodBeat.o(189166);
      return l;
    }
    
    public final Object getPlayInfo(long paramLong)
    {
      AppMethodBeat.i(189161);
      Object localObject = c.a(c.this).getPlayInfo(paramLong);
      AppMethodBeat.o(189161);
      return localObject;
    }
    
    public final Object getPlayInfo(String paramString)
    {
      AppMethodBeat.i(189162);
      paramString = c.a(c.this).getPlayInfo(paramString);
      AppMethodBeat.o(189162);
      return paramString;
    }
    
    public final long getPlayerBufferLength()
    {
      AppMethodBeat.i(189157);
      long l = c.a(c.this).getPlayerBufferLength();
      AppMethodBeat.o(189157);
      return l;
    }
    
    public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
    {
      AppMethodBeat.i(189155);
      c.a(c.this).onDownloadCdnUrlExpired(paramMap);
      AppMethodBeat.o(189155);
    }
    
    public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(189152);
      c.a(c.this).onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(189152);
    }
    
    public final void onDownloadCdnUrlUpdate(String paramString)
    {
      AppMethodBeat.i(189151);
      c.a(c.this).onDownloadCdnUrlUpdate(paramString);
      AppMethodBeat.o(189151);
    }
    
    public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(189150);
      c.a(c.this).onDownloadError(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(189150);
    }
    
    public final void onDownloadFinish()
    {
      AppMethodBeat.i(189149);
      c.a(c.this).onDownloadFinish();
      AppMethodBeat.o(189149);
    }
    
    public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
    {
      AppMethodBeat.i(189148);
      c.a(c.this).onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2, paramString);
      AppMethodBeat.o(189148);
    }
    
    public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
    {
      AppMethodBeat.i(189154);
      c.a(c.this).onDownloadProtocolUpdate(paramString1, paramString2);
      AppMethodBeat.o(189154);
    }
    
    public final void onDownloadStatusUpdate(int paramInt)
    {
      AppMethodBeat.i(189153);
      c.a(c.this).onDownloadStatusUpdate(paramInt);
      AppMethodBeat.o(189153);
    }
    
    public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      AppMethodBeat.i(189156);
      paramObject1 = c.a(c.this).onPlayCallback(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
      AppMethodBeat.o(189156);
      return paramObject1;
    }
    
    public final int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(189164);
      paramInt = c.a(c.this).onReadData(paramInt, paramString, paramLong1, paramLong2);
      AppMethodBeat.o(189164);
      return paramInt;
    }
    
    public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(189163);
      paramInt = c.a(c.this).onStartReadData(paramInt, paramString, paramLong1, paramLong2);
      AppMethodBeat.o(189163);
      return paramInt;
    }
    
    public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(189165);
      paramInt1 = c.a(c.this).onStopReadData(paramInt1, paramString, paramInt2);
      AppMethodBeat.o(189165);
      return paramInt1;
    }
  }
  
  static final class b
  {
    long RZG;
    int RZH;
    
    b(long paramLong, int paramInt)
    {
      this.RZG = paramLong;
      this.RZH = paramInt;
    }
  }
  
  static final class c
  {
    int RZI;
    int RZJ;
    
    c(int paramInt1, int paramInt2)
    {
      this.RZI = paramInt1;
      this.RZJ = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.e.c
 * JD-Core Version:    0.7.0.1
 */