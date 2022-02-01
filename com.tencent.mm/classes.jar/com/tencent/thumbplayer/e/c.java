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
  private static int ZCe = -1;
  private ITPDownloadProxy ZBZ;
  private boolean ZCa;
  private int ZCb;
  private a ZCc;
  private ITPPlayListener ZCd;
  private ArrayList<TPDownloadParamData> ZCf;
  private String ZCg;
  private int ZCh;
  private TPVideoInfo ZCi;
  private ITPPlayerProxyListener ZCj;
  private LinkedList<b> ZCk;
  private HashMap<String, Integer> ZCl;
  private long ZCm;
  private boolean ZCn;
  private boolean ZCo;
  private long cuE;
  private Context mContext;
  private String mOriginUrl;
  private int mServiceType;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(220302);
    this.ZCa = false;
    this.ZCb = 3;
    this.mServiceType = ZCe;
    this.ZCh = -1;
    this.ZCj = null;
    this.ZCn = false;
    this.ZCo = false;
    this.mContext = paramContext;
    com.tencent.thumbplayer.utils.e.a(this);
    TPNetworkChangeMonitor.irQ().a(this);
    this.ZCc = new a((byte)0);
    this.ZCd = new d("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.ZCl = new HashMap();
    this.ZCf = new ArrayList();
    AppMethodBeat.o(220302);
  }
  
  private boolean Ix(boolean paramBoolean)
  {
    AppMethodBeat.i(220448);
    if (!com.tencent.thumbplayer.d.a.iqK())
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "config set don't use p2p proxy!");
      AppMethodBeat.o(220448);
      return true;
    }
    if (paramBoolean) {
      this.ZCb = 3;
    }
    iqZ();
    if (!this.ZCa)
    {
      AppMethodBeat.o(220448);
      return true;
    }
    AppMethodBeat.o(220448);
    return false;
  }
  
  private int a(List<ITPMediaTrackClip> paramList, String paramString, ArrayList<TPDownloadParamData> paramArrayList)
  {
    AppMethodBeat.i(220397);
    if (com.tencent.thumbplayer.utils.b.isEmpty(paramList))
    {
      com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "clipList is empty, return");
      AppMethodBeat.o(220397);
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
      if ((!(localObject2 instanceof com.tencent.thumbplayer.c.e)) || (!com.tencent.thumbplayer.utils.b.bAx(((com.tencent.thumbplayer.c.e)localObject2).getFilePath()))) {
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
        AppMethodBeat.o(220397);
        return -1;
      }
      i = this.ZBZ.startClipPlay(paramString, ((HashMap)localObject1).size(), this.ZCc);
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
            Object localObject3 = i(paramArrayList, paramString.ZCt);
            if (localObject3 == null)
            {
              com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "fatal err, paramData is null.");
              AppMethodBeat.o(220397);
              return -1;
            }
            com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "multi trackClipIndex:" + paramString.ZCt + ", download seq:" + paramString.ZCs + ", clip.url:" + ((com.tencent.thumbplayer.c.e)localObject1).getUrl() + ", clip.getFilePath:" + ((com.tencent.thumbplayer.c.e)localObject1).getFilePath() + ", paramData.savePath:" + ((TPDownloadParamData)localObject3).getSavePath() + ", paramData.DownloadFileID:" + ((TPDownloadParamData)localObject3).getDownloadFileID());
            localObject2 = ((TPDownloadParamData)localObject3).getDownloadFileID();
            localObject3 = a(((com.tencent.thumbplayer.c.e)localObject1).getFilePath(), (TPDownloadParamData)localObject3);
            if (this.ZBZ.setClipInfo(i, paramString.ZCs, (String)localObject2, (TPDownloadParam)localObject3)) {
              ((com.tencent.thumbplayer.c.e)localObject1).ZBG = this.ZBZ.getClipPlayUrl(i, paramString.ZCs, 1);
            }
          }
        }
      }
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start clip play failed, cause : playId < 0");
      AppMethodBeat.o(220397);
      return i;
    }
  }
  
  private com.tencent.thumbplayer.a.a.e a(long paramLong, String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    String str = null;
    AppMethodBeat.i(220346);
    com.tencent.thumbplayer.a.a.e locale = new com.tencent.thumbplayer.a.a.e(paramString);
    if (!com.tencent.thumbplayer.utils.b.bAx(paramString))
    {
      AppMethodBeat.o(220346);
      return locale;
    }
    if (Ix(false))
    {
      AppMethodBeat.o(220346);
      return locale;
    }
    if (this.ZCk == null) {
      this.ZCk = new LinkedList();
    }
    if (paramTPDownloadParamData != null) {}
    for (Object localObject = a(paramString, paramTPDownloadParamData);; localObject = null)
    {
      if (paramTPDownloadParamData != null) {}
      try
      {
        str = paramTPDownloadParamData.getDownloadFileID();
        i = this.ZBZ.startPlay(str, (TPDownloadParam)localObject, this.ZCc);
        if (i <= 0) {
          break;
        }
        localObject = this.ZBZ.getPlayUrl(i, 1);
        paramTPDownloadParamData = (TPDownloadParamData)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramTPDownloadParamData = paramString;
        }
        locale.Zzd = paramTPDownloadParamData;
        paramTPDownloadParamData = this.ZBZ.getPlayUrl(this.ZCh, 0);
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
      locale.Zzc = paramString;
      this.ZCk.offer(new b(paramLong, i));
      com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
      AppMethodBeat.o(220346);
      return locale;
    }
    com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def failed, cause : playId < 0");
    AppMethodBeat.o(220346);
    return locale;
  }
  
  private static TPDownloadParam a(String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(292924);
    paramString = i.b(paramString, paramTPDownloadParamData);
    AppMethodBeat.o(292924);
    return paramString;
  }
  
  private void aBc(int paramInt)
  {
    AppMethodBeat.i(220374);
    if (Ix(false))
    {
      AppMethodBeat.o(220374);
      return;
    }
    try
    {
      this.ZBZ.pauseDownload(paramInt);
      AppMethodBeat.o(220374);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pause download failed, taskId:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(220374);
    }
  }
  
  private void aBd(int paramInt)
  {
    AppMethodBeat.i(220385);
    if (Ix(false))
    {
      AppMethodBeat.o(220385);
      return;
    }
    try
    {
      this.ZBZ.resumeDownload(this.ZCh);
      AppMethodBeat.o(220385);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy resume download failed, taskId:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(220385);
    }
  }
  
  private void aBe(int paramInt)
  {
    AppMethodBeat.i(220404);
    if (Ix(false))
    {
      AppMethodBeat.o(220404);
      return;
    }
    try
    {
      this.ZBZ.stopPlay(paramInt);
      AppMethodBeat.o(220404);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy stop play failed, taskID:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(220404);
    }
  }
  
  private void aBf(int paramInt)
  {
    AppMethodBeat.i(220406);
    if (Ix(false))
    {
      AppMethodBeat.o(220406);
      return;
    }
    try
    {
      this.ZBZ.pushEvent(paramInt);
      AppMethodBeat.o(220406);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pushEvent failed, event:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(220406);
    }
  }
  
  private static List<ITPMediaTrackClip> c(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(220392);
    if ((paramITPMediaAsset instanceof com.tencent.thumbplayer.c.b))
    {
      paramITPMediaAsset = ((com.tencent.thumbplayer.c.b)paramITPMediaAsset).getAllAVTracks();
      if (!com.tencent.thumbplayer.utils.b.isEmpty(paramITPMediaAsset))
      {
        paramITPMediaAsset = (ITPMediaTrack)paramITPMediaAsset.get(0);
        if ((paramITPMediaAsset != null) && (!com.tencent.thumbplayer.utils.b.isEmpty(paramITPMediaAsset.getAllTrackClips())))
        {
          paramITPMediaAsset = paramITPMediaAsset.getAllTrackClips();
          AppMethodBeat.o(220392);
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
        AppMethodBeat.o(220392);
        return paramITPMediaAsset;
      }
    }
    else if ((paramITPMediaAsset instanceof ITPMediaTrackClip))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add((ITPMediaTrackClip)paramITPMediaAsset);
      AppMethodBeat.o(220392);
      return localArrayList;
    }
    AppMethodBeat.o(220392);
    return null;
  }
  
  private static TPDownloadParamData i(ArrayList<TPDownloadParamData> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(220456);
    if ((com.tencent.thumbplayer.utils.b.isEmpty(paramArrayList)) || (paramInt >= paramArrayList.size()))
    {
      AppMethodBeat.o(220456);
      return null;
    }
    paramArrayList = (TPDownloadParamData)paramArrayList.get(paramInt);
    AppMethodBeat.o(220456);
    return paramArrayList;
  }
  
  private void iqZ()
  {
    AppMethodBeat.i(220308);
    if (this.ZCa)
    {
      AppMethodBeat.o(220308);
      return;
    }
    if (this.ZCb > 0)
    {
      try
      {
        if (this.mServiceType == ZCe) {
          this.mServiceType = com.tencent.thumbplayer.d.a.iqT();
        }
        b localb = g.a.irb().aBh(this.mServiceType);
        if ((localb == null) || (localb.iqY() == null)) {
          break label272;
        }
        this.ZBZ = localb.iqY();
        this.ZBZ.setUserData("qq_is_vip", Boolean.valueOf(com.tencent.thumbplayer.d.a.iqS()));
        if (!TextUtils.isEmpty(com.tencent.thumbplayer.d.a.iqO())) {
          this.ZBZ.setUserData("user_uin", com.tencent.thumbplayer.d.a.iqO());
        }
        if (!TextUtils.isEmpty(com.tencent.thumbplayer.d.a.getAppVersionName(this.mContext))) {
          this.ZBZ.setUserData("app_version_name", com.tencent.thumbplayer.d.a.getAppVersionName(this.mContext));
        }
        if (com.tencent.thumbplayer.d.a.mg(this.mContext) != -1L) {
          this.ZBZ.setUserData("app_version_code", String.valueOf(com.tencent.thumbplayer.d.a.mg(this.mContext)));
        }
        this.ZBZ.setUserData("carrier_pesudo_code", com.tencent.thumbplayer.d.a.iqP());
        this.ZBZ.setUserData("carrier_pesudo_state", Integer.valueOf(com.tencent.thumbplayer.d.a.iqQ()));
        this.ZBZ.setUserData("external_network_ip", com.tencent.thumbplayer.d.a.iqR());
        this.ZCa = true;
        AppMethodBeat.o(220308);
        return;
      }
      catch (Exception localException)
      {
        this.ZCb -= 1;
        com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException);
      }
    }
    else
    {
      AppMethodBeat.o(220308);
      return;
    }
    label272:
    this.ZCb -= 1;
    com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p so load failed");
    AppMethodBeat.o(220308);
  }
  
  private void ira()
  {
    AppMethodBeat.i(220457);
    this.ZBZ.setUserData("dl_param_play_start_time", Long.valueOf(this.cuE));
    this.ZBZ.setUserData("dl_param_play_end_time", Long.valueOf(this.ZCm));
    AppMethodBeat.o(220457);
  }
  
  private boolean oJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220319);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    paramString1 = new HashMap();
    paramString1.put("dl_param_data_transfer_mode", Integer.valueOf(1));
    paramString1 = new TPDownloadParam(localArrayList, 3, paramString1);
    boolean bool = this.ZBZ.setClipInfo(this.ZCh, 2, paramString2, paramString1);
    AppMethodBeat.o(220319);
    return bool;
  }
  
  public final void Iw(boolean paramBoolean)
  {
    this.ZCo = paramBoolean;
  }
  
  public final void WU(long paramLong)
  {
    AppMethodBeat.i(220357);
    if (Ix(false))
    {
      AppMethodBeat.o(220357);
      return;
    }
    try
    {
      if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ZCk))
      {
        for (b localb = (b)this.ZCk.peek(); (localb != null) && (localb.ZCq != paramLong); localb = (b)this.ZCk.peek())
        {
          com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy definitionID:" + localb.ZCq + ", taskID:" + localb.ZCr);
          aBe(localb.ZCr);
          this.ZCk.removeFirst();
        }
        if (localb != null)
        {
          com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy task id:" + localb.ZCr);
          aBe(this.ZCh);
          this.ZCh = localb.ZCr;
          this.ZCk.remove(localb);
        }
      }
      AppMethodBeat.o(220357);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException, "playerSwitchDefComplete exception");
      AppMethodBeat.o(220357);
    }
  }
  
  public final com.tencent.thumbplayer.a.a.e a(long paramLong, String paramString, TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(220329);
    if (paramTPVideoInfo == null)
    {
      paramString = new com.tencent.thumbplayer.a.a.e(paramString);
      AppMethodBeat.o(220329);
      return paramString;
    }
    TPDownloadParamData localTPDownloadParamData = null;
    if (paramTPVideoInfo.getDownloadPraramList() != null) {
      localTPDownloadParamData = (TPDownloadParamData)paramTPVideoInfo.getDownloadPraramList().get(0);
    }
    paramString = a(paramLong, paramString, localTPDownloadParamData);
    AppMethodBeat.o(220329);
    return paramString;
  }
  
  public final ITPMediaAsset a(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(220337);
    if ((Ix(false)) || (paramITPMediaAsset == null))
    {
      AppMethodBeat.o(220337);
      return paramITPMediaAsset;
    }
    if (this.ZCk == null) {
      this.ZCk = new LinkedList();
    }
    if (paramTPVideoInfo == null)
    {
      AppMethodBeat.o(220337);
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
      ((com.tencent.thumbplayer.c.g)paramITPMediaAsset).setDrmPlayUrl(paramTPVideoInfo.Zzd);
      AppMethodBeat.o(220337);
      return paramITPMediaAsset;
      List localList = c(paramITPMediaAsset);
      if ((!com.tencent.thumbplayer.utils.b.isEmpty(localList)) && (paramTPVideoInfo != null))
      {
        int i = a(localList, paramTPVideoInfo.getProxyFileID(), paramTPVideoInfo.getDownloadPraramList());
        if (i > 0)
        {
          this.ZCk.offer(new b(paramLong, i));
          com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
          AppMethodBeat.o(220337);
          return paramITPMediaAsset;
        }
        com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch clip def failed, cause : playId < 0");
      }
      AppMethodBeat.o(220337);
      return paramITPMediaAsset;
    }
  }
  
  public final String a(int paramInt, String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    i = 0;
    AppMethodBeat.i(220420);
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is empty");
      AppMethodBeat.o(220420);
      return paramString;
    }
    if (!com.tencent.thumbplayer.utils.b.bAx(paramString))
    {
      com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is locol url, not need use proxy");
      AppMethodBeat.o(220420);
      return paramString;
    }
    if (Ix(false))
    {
      com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz download proxy init failed");
      AppMethodBeat.o(220420);
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
        paramInt = this.ZBZ.startPlay(com.tencent.thumbplayer.utils.b.bdy(paramString), paramTPDownloadParamData, this.ZCc);
        if (paramInt <= 0) {
          continue;
        }
        str = paramString;
        paramString = this.ZBZ.getPlayUrl(paramInt, 1);
        str = paramString;
        this.ZCl.put(paramString, Integer.valueOf(paramInt));
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
      AppMethodBeat.o(220420);
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
    this.ZCd = paramITPPlayListener;
  }
  
  public final void aBb(int paramInt)
  {
    AppMethodBeat.i(220424);
    com.tencent.thumbplayer.utils.g.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState: ".concat(String.valueOf(paramInt)));
    if (Ix(false))
    {
      AppMethodBeat.o(220424);
      return;
    }
    try
    {
      this.ZBZ.setPlayState(this.ZCh, paramInt);
      if (((paramInt == 5) || (paramInt == 0)) && (!com.tencent.thumbplayer.utils.b.isEmpty(this.ZCk)))
      {
        Iterator localIterator = this.ZCk.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb != null)
          {
            com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState definitionID:" + localb.ZCq + ", taskID:" + localb.ZCr + ", state:" + paramInt);
            this.ZBZ.setPlayState(localb.ZCr, paramInt);
          }
        }
      }
      AppMethodBeat.o(220424);
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      AppMethodBeat.o(220424);
      return;
    }
  }
  
  public final ITPMediaAsset b(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(220367);
    if (Ix(true))
    {
      AppMethodBeat.o(220367);
      return paramITPMediaAsset;
    }
    ira();
    if ((paramITPMediaAsset instanceof com.tencent.thumbplayer.c.g))
    {
      localObject = bDw(((com.tencent.thumbplayer.c.g)paramITPMediaAsset).getDrmPlayUrl());
      ((com.tencent.thumbplayer.c.g)paramITPMediaAsset).setDrmPlayUrl(((com.tencent.thumbplayer.a.a.e)localObject).Zzd);
      AppMethodBeat.o(220367);
      return paramITPMediaAsset;
    }
    Object localObject = c(paramITPMediaAsset);
    if (!com.tencent.thumbplayer.utils.b.isEmpty((Collection)localObject)) {
      this.ZCh = a((List)localObject, this.ZCg, this.ZCf);
    }
    AppMethodBeat.o(220367);
    return paramITPMediaAsset;
  }
  
  public final com.tencent.thumbplayer.a.a.e bDw(String paramString)
  {
    AppMethodBeat.i(220318);
    com.tencent.thumbplayer.a.a.e locale = new com.tencent.thumbplayer.a.a.e(paramString);
    if (!com.tencent.thumbplayer.utils.b.bAx(paramString))
    {
      AppMethodBeat.o(220318);
      return locale;
    }
    if (Ix(true))
    {
      AppMethodBeat.o(220318);
      return locale;
    }
    ira();
    this.mOriginUrl = paramString;
    Object localObject2 = i(this.ZCf, 0);
    Object localObject1;
    if ((this.ZCo) && (localObject2 != null) && (((TPDownloadParamData)localObject2).getDlType() == 1))
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
        this.ZCh = this.ZBZ.startPlay(this.ZCg, (TPDownloadParam)localObject1, this.ZCc);
        if (this.ZCh <= 0) {
          continue;
        }
        localObject2 = this.ZBZ.getPlayUrl(this.ZCh, 0);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = paramString;
        }
        com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "startDownloadPlay, playId:" + this.ZCh);
        locale.Zzd = ((String)localObject1);
        localObject1 = this.ZBZ.getPlayUrl(this.ZCh, 1);
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
      locale.Zzc = paramString;
      AppMethodBeat.o(220318);
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
    AppMethodBeat.i(220465);
    com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "onEvent eventId: " + paramInt1 + ", arg1: " + paramInt2 + ", arg2: " + paramInt3 + ", object" + paramObject);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220465);
      return;
      aBf(13);
      AppMethodBeat.o(220465);
      return;
      aBf(14);
    }
  }
  
  public final void iqU()
  {
    AppMethodBeat.i(220326);
    if (this.ZCn)
    {
      aBe(this.ZCh);
      bDw(this.mOriginUrl);
    }
    this.ZCn = false;
    AppMethodBeat.o(220326);
  }
  
  public final boolean iqV()
  {
    AppMethodBeat.i(220361);
    if (Ix(false))
    {
      AppMethodBeat.o(220361);
      return false;
    }
    if ((this.ZCk != null) && (this.ZCk.size() > 0))
    {
      AppMethodBeat.o(220361);
      return true;
    }
    AppMethodBeat.o(220361);
    return false;
  }
  
  public final String iqW()
  {
    AppMethodBeat.i(220412);
    if (Ix(false))
    {
      AppMethodBeat.o(220412);
      return null;
    }
    try
    {
      String str = this.ZBZ.getPlayErrorCodeStr(this.ZCh);
      AppMethodBeat.o(220412);
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      AppMethodBeat.o(220412);
    }
    return null;
  }
  
  public final ITPPlayerProxyListener iqX()
  {
    return this.ZCj;
  }
  
  public final boolean isEnable()
  {
    AppMethodBeat.i(220409);
    if (!Ix(false))
    {
      AppMethodBeat.o(220409);
      return true;
    }
    AppMethodBeat.o(220409);
    return false;
  }
  
  public final void nP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220462);
    com.tencent.thumbplayer.utils.g.d("TPThumbPlayer[TPPlayManagerImpl.java]", "onNetworkStatusChanged oldNetStatus: " + paramInt1 + ", netStatus: " + paramInt2);
    if (paramInt2 == 1)
    {
      aBf(1);
      aBf(10);
      AppMethodBeat.o(220462);
      return;
    }
    if (paramInt2 == 2)
    {
      aBf(2);
      aBf(9);
      AppMethodBeat.o(220462);
      return;
    }
    if (paramInt2 == 3)
    {
      aBf(2);
      aBf(10);
    }
    AppMethodBeat.o(220462);
  }
  
  public final void oI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220324);
    if ((!com.tencent.thumbplayer.utils.b.bAx(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramString1 = new Exception("illegal argument.");
      AppMethodBeat.o(220324);
      throw paramString1;
    }
    if (!this.ZCn)
    {
      if (!oJ(paramString1, paramString2))
      {
        paramString1 = new Exception("setClipInfo err.");
        AppMethodBeat.o(220324);
        throw paramString1;
      }
    }
    else
    {
      aBe(this.ZCh);
      bDw(this.mOriginUrl);
      if (!oJ(paramString1, paramString2))
      {
        paramString1 = new Exception("setClipInfo err.");
        AppMethodBeat.o(220324);
        throw paramString1;
      }
    }
    this.ZCn = true;
    AppMethodBeat.o(220324);
  }
  
  public final void pauseDownload()
  {
    AppMethodBeat.i(220373);
    aBc(this.ZCh);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ZCk))
    {
      localIterator = this.ZCk.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          aBc(localb.ZCr);
        }
      }
    }
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ZCl))
    {
      localIterator = this.ZCl.values().iterator();
      while (localIterator.hasNext()) {
        aBc(((Integer)localIterator.next()).intValue());
      }
    }
    AppMethodBeat.o(220373);
  }
  
  public final void pushEvent(int paramInt)
  {
    AppMethodBeat.i(220408);
    if (Ix(false))
    {
      AppMethodBeat.o(220408);
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
        AppMethodBeat.o(220408);
        throw localIllegalArgumentException1;
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localIllegalArgumentException2);
        AppMethodBeat.o(220408);
        return;
      }
    case 3: 
      paramInt = 3;
    }
    for (;;)
    {
      aBf(paramInt);
      AppMethodBeat.o(220408);
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
    AppMethodBeat.i(220402);
    stopDownload();
    TPNetworkChangeMonitor.irQ().b(this);
    com.tencent.thumbplayer.utils.e.b(this);
    this.ZCj = null;
    this.ZCd = new d("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.ZCc = null;
    this.ZBZ = null;
    AppMethodBeat.o(220402);
  }
  
  public final void resumeDownload()
  {
    AppMethodBeat.i(220381);
    aBd(this.ZCh);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ZCk))
    {
      localIterator = this.ZCk.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          aBd(localb.ZCr);
        }
      }
    }
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ZCl))
    {
      localIterator = this.ZCl.values().iterator();
      while (localIterator.hasNext()) {
        aBd(((Integer)localIterator.next()).intValue());
      }
    }
    AppMethodBeat.o(220381);
  }
  
  public final void setIsActive(boolean paramBoolean)
  {
    AppMethodBeat.i(220310);
    com.tencent.thumbplayer.utils.g.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setIsActive: ".concat(String.valueOf(paramBoolean)));
    if (Ix(false))
    {
      AppMethodBeat.o(220310);
      return;
    }
    try
    {
      ITPDownloadProxy localITPDownloadProxy = this.ZBZ;
      int j = this.ZCh;
      if (paramBoolean) {}
      for (int i = 101;; i = 100)
      {
        localITPDownloadProxy.setPlayState(j, i);
        AppMethodBeat.o(220310);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      AppMethodBeat.o(220310);
    }
  }
  
  public final void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(220415);
    if (Ix(false))
    {
      AppMethodBeat.o(220415);
      return;
    }
    if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 100))
    {
      this.cuE = paramTPOptionalParam.getParamLong().value;
      AppMethodBeat.o(220415);
      return;
    }
    if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 500))
    {
      this.ZCm = paramTPOptionalParam.getParamLong().value;
      if (this.ZCh > 0) {
        this.ZBZ.setUserData("dl_param_play_end_time", Long.valueOf(this.ZCm));
      }
    }
    AppMethodBeat.o(220415);
  }
  
  public final void setProxyServiceType(int paramInt)
  {
    this.mServiceType = paramInt;
  }
  
  public final void setTPPlayerProxyListener(ITPPlayerProxyListener paramITPPlayerProxyListener)
  {
    this.ZCj = paramITPPlayerProxyListener;
  }
  
  public final void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(220439);
    if (paramTPVideoInfo == null)
    {
      com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, param is null ");
      AppMethodBeat.o(220439);
      return;
    }
    if ((this.ZCi != null) && (!Ix(false)))
    {
      this.ZCi = paramTPVideoInfo;
      if ((paramTPVideoInfo != null) && (paramTPVideoInfo.getDownloadPraramList() != null)) {
        break label121;
      }
      com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "video or downloadParamList is null, return");
    }
    for (;;)
    {
      this.ZCi = paramTPVideoInfo;
      com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, enter");
      this.ZCg = paramTPVideoInfo.getProxyFileID();
      if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ZCf)) {
        this.ZCf.clear();
      }
      this.ZCf.addAll(paramTPVideoInfo.getDownloadPraramList());
      AppMethodBeat.o(220439);
      return;
      label121:
      if (this.ZCh <= 0)
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
          if (!this.ZBZ.setClipInfo(this.ZCh, localTPDownloadParamData.getClipNo(), localTPDownloadParamData.getDownloadFileID(), localTPDownloadParam)) {
            com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "setClipInfo failed, playID:" + this.ZCh + ", clipNo:" + localTPDownloadParamData.getClipNo() + ", downloadFileID:" + localTPDownloadParamData.getDownloadFileID());
          }
          i += 1;
        }
      }
    }
  }
  
  public final void stopDownload()
  {
    AppMethodBeat.i(220401);
    if (this.ZCh < 0)
    {
      com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload failed, coz playId:" + this.ZCh + ", less than zero. maybe download proxy didn't started");
      AppMethodBeat.o(220401);
      return;
    }
    com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload, playId:" + this.ZCh);
    aBe(this.ZCh);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ZCk))
    {
      localIterator = this.ZCk.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          aBe(localb.ZCr);
        }
      }
      this.ZCk.clear();
    }
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ZCl))
    {
      localIterator = this.ZCl.values().iterator();
      while (localIterator.hasNext()) {
        aBe(((Integer)localIterator.next()).intValue());
      }
      this.ZCl.clear();
    }
    this.ZCh = -1;
    com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "reset");
    this.ZCg = "";
    this.mOriginUrl = "";
    this.ZCi = null;
    this.cuE = 0L;
    this.ZCm = 0L;
    this.ZCn = false;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.ZCf)) {
      this.ZCf.clear();
    }
    AppMethodBeat.o(220401);
  }
  
  final class a
    implements ITPPlayListener
  {
    private a() {}
    
    public final long getAdvRemainTime()
    {
      AppMethodBeat.i(220279);
      long l = c.a(c.this).getAdvRemainTime();
      AppMethodBeat.o(220279);
      return l;
    }
    
    public final String getContentType(int paramInt, String paramString)
    {
      AppMethodBeat.i(220291);
      paramString = c.a(c.this).getContentType(paramInt, paramString);
      AppMethodBeat.o(220291);
      return paramString;
    }
    
    public final int getCurrentPlayClipNo()
    {
      AppMethodBeat.i(220278);
      int i = c.a(c.this).getCurrentPlayClipNo();
      AppMethodBeat.o(220278);
      return i;
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(220277);
      long l = c.a(c.this).getCurrentPosition();
      AppMethodBeat.o(220277);
      return l;
    }
    
    public final String getDataFilePath(int paramInt, String paramString)
    {
      AppMethodBeat.i(220289);
      paramString = c.a(c.this).getDataFilePath(paramInt, paramString);
      AppMethodBeat.o(220289);
      return paramString;
    }
    
    public final long getDataTotalSize(int paramInt, String paramString)
    {
      AppMethodBeat.i(220287);
      long l = c.a(c.this).getDataTotalSize(paramInt, paramString);
      AppMethodBeat.o(220287);
      return l;
    }
    
    public final Object getPlayInfo(long paramLong)
    {
      AppMethodBeat.i(220281);
      Object localObject = c.a(c.this).getPlayInfo(paramLong);
      AppMethodBeat.o(220281);
      return localObject;
    }
    
    public final Object getPlayInfo(String paramString)
    {
      AppMethodBeat.i(220283);
      paramString = c.a(c.this).getPlayInfo(paramString);
      AppMethodBeat.o(220283);
      return paramString;
    }
    
    public final long getPlayerBufferLength()
    {
      AppMethodBeat.i(220276);
      long l = c.a(c.this).getPlayerBufferLength();
      AppMethodBeat.o(220276);
      return l;
    }
    
    public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
    {
      AppMethodBeat.i(220273);
      c.a(c.this).onDownloadCdnUrlExpired(paramMap);
      AppMethodBeat.o(220273);
    }
    
    public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(220269);
      c.a(c.this).onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(220269);
    }
    
    public final void onDownloadCdnUrlUpdate(String paramString)
    {
      AppMethodBeat.i(220268);
      c.a(c.this).onDownloadCdnUrlUpdate(paramString);
      AppMethodBeat.o(220268);
    }
    
    public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(220267);
      c.a(c.this).onDownloadError(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(220267);
    }
    
    public final void onDownloadFinish()
    {
      AppMethodBeat.i(220266);
      c.a(c.this).onDownloadFinish();
      AppMethodBeat.o(220266);
    }
    
    public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
    {
      AppMethodBeat.i(220265);
      c.a(c.this).onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2, paramString);
      AppMethodBeat.o(220265);
    }
    
    public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
    {
      AppMethodBeat.i(220271);
      c.a(c.this).onDownloadProtocolUpdate(paramString1, paramString2);
      AppMethodBeat.o(220271);
    }
    
    public final void onDownloadStatusUpdate(int paramInt)
    {
      AppMethodBeat.i(220270);
      c.a(c.this).onDownloadStatusUpdate(paramInt);
      AppMethodBeat.o(220270);
    }
    
    public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      AppMethodBeat.i(220274);
      paramObject1 = c.a(c.this).onPlayCallback(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
      AppMethodBeat.o(220274);
      return paramObject1;
    }
    
    public final int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(220285);
      paramInt = c.a(c.this).onReadData(paramInt, paramString, paramLong1, paramLong2);
      AppMethodBeat.o(220285);
      return paramInt;
    }
    
    public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(220284);
      paramInt = c.a(c.this).onStartReadData(paramInt, paramString, paramLong1, paramLong2);
      AppMethodBeat.o(220284);
      return paramInt;
    }
    
    public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(220286);
      paramInt1 = c.a(c.this).onStopReadData(paramInt1, paramString, paramInt2);
      AppMethodBeat.o(220286);
      return paramInt1;
    }
  }
  
  static final class b
  {
    long ZCq;
    int ZCr;
    
    b(long paramLong, int paramInt)
    {
      this.ZCq = paramLong;
      this.ZCr = paramInt;
    }
  }
  
  static final class c
  {
    int ZCs;
    int ZCt;
    
    c(int paramInt1, int paramInt2)
    {
      this.ZCs = paramInt1;
      this.ZCt = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.e.c
 * JD-Core Version:    0.7.0.1
 */