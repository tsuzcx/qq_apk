package com.tencent.thumbplayer.f;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.f.b;
import com.tencent.thumbplayer.b.p;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.d.g;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor.b;
import com.tencent.thumbplayer.utils.d.a;
import com.tencent.thumbplayer.utils.d.b;
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
  implements a, TPNetworkChangeMonitor.b, d.b
{
  private static int Khw = -1;
  private p KhA;
  private com.tencent.thumbplayer.b.b.a KhB;
  private LinkedList<b> KhC;
  private HashMap<String, Integer> KhD;
  private long KhE;
  private boolean KhF;
  private ITPDownloadProxy Khr;
  private boolean Khs;
  private int Kht;
  private a Khu;
  private ITPPlayListener Khv;
  private ArrayList<com.tencent.thumbplayer.b.b.b> Khx;
  private String Khy;
  private int Khz;
  private long bZS;
  private Context mContext;
  private String mOriginUrl;
  private int mServiceType;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(187892);
    this.Khs = false;
    this.Kht = 3;
    this.mServiceType = Khw;
    this.Khz = -1;
    this.KhB = null;
    this.KhF = false;
    this.mContext = paramContext;
    d.a.fGu().a(this);
    TPNetworkChangeMonitor.fGv().a(this);
    this.Khu = new a((byte)0);
    this.Khv = new d("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.KhD = new HashMap();
    AppMethodBeat.o(187892);
  }
  
  private int a(List<com.tencent.thumbplayer.b.a.e> paramList, String paramString, ArrayList<com.tencent.thumbplayer.b.b.b> paramArrayList)
  {
    AppMethodBeat.i(187909);
    if (com.tencent.thumbplayer.utils.b.isEmpty(paramList))
    {
      com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayManagerImpl.java]", "clipList is empty, return");
      AppMethodBeat.o(187909);
      return -1;
    }
    int k = paramList.size();
    Object localObject1 = new HashMap();
    int i = 1;
    int j = 0;
    Object localObject2;
    if (j < k)
    {
      localObject2 = (com.tencent.thumbplayer.b.a.e)paramList.get(j);
      if ((!(localObject2 instanceof com.tencent.thumbplayer.d.e)) || (!com.tencent.thumbplayer.utils.b.aRh(((com.tencent.thumbplayer.d.e)localObject2).Khb))) {
        break label594;
      }
      ((HashMap)localObject1).put(localObject2, new c(i, j));
      i += 1;
    }
    label594:
    for (;;)
    {
      j += 1;
      break;
      if (com.tencent.thumbplayer.utils.b.isEmpty((Map)localObject1))
      {
        com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayManagerImpl.java]", "all urls is local file url, return");
        AppMethodBeat.o(187909);
        return -1;
      }
      if ((paramArrayList.size() > 0) && (((com.tencent.thumbplayer.b.b.b)paramArrayList.get(0)).KfV) && (!TPDownloadProxyFactory.isReadyForDownload()))
      {
        paramList = a("", e(paramArrayList, 0));
        i = this.Khr.startPlay(paramString, paramList, this.Khu);
        if (i > 0)
        {
          paramList = ((HashMap)localObject1).entrySet().iterator();
          while (paramList.hasNext())
          {
            paramArrayList = (Map.Entry)paramList.next();
            paramString = (com.tencent.thumbplayer.b.a.e)paramArrayList.getKey();
            paramArrayList = (c)paramArrayList.getValue();
            if ((paramString instanceof com.tencent.thumbplayer.d.e)) {
              ((com.tencent.thumbplayer.d.e)paramString).Khb = this.Khr.getClipPlayUrl(i, paramArrayList.KhK + 1);
            }
          }
          AppMethodBeat.o(187909);
          return i;
        }
      }
      i = this.Khr.startClipPlay(paramString, ((HashMap)localObject1).size(), this.Khu);
      if (i > 0)
      {
        paramList = ((HashMap)localObject1).entrySet().iterator();
        while (paramList.hasNext())
        {
          paramString = (Map.Entry)paramList.next();
          localObject1 = (com.tencent.thumbplayer.b.a.e)paramString.getKey();
          paramString = (c)paramString.getValue();
          if ((localObject1 instanceof com.tencent.thumbplayer.d.e))
          {
            localObject1 = (com.tencent.thumbplayer.d.e)localObject1;
            Object localObject3 = e(paramArrayList, paramString.KhK);
            if (localObject3 == null)
            {
              com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", "fatal err, paramData is null.");
              AppMethodBeat.o(187909);
              return -1;
            }
            com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", "multi trackClipIndex:" + paramString.KhK + ", download seq:" + paramString.KhJ + ", clip.url:" + ((com.tencent.thumbplayer.d.e)localObject1).getUrl() + ", clip.getFilePath:" + ((com.tencent.thumbplayer.d.e)localObject1).Khb + ", paramData.savePath:" + ((com.tencent.thumbplayer.b.b.b)localObject3).savePath + ", paramData.DownloadFileID:" + ((com.tencent.thumbplayer.b.b.b)localObject3).Kfx);
            localObject2 = ((com.tencent.thumbplayer.b.b.b)localObject3).Kfx;
            localObject3 = a(((com.tencent.thumbplayer.d.e)localObject1).Khb, (com.tencent.thumbplayer.b.b.b)localObject3);
            if (this.Khr.setClipInfo(i, paramString.KhJ, (String)localObject2, (TPDownloadParam)localObject3)) {
              ((com.tencent.thumbplayer.d.e)localObject1).Khb = this.Khr.getClipPlayUrl(i, paramString.KhJ);
            }
          }
        }
      }
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start clip play failed, cause : playId < 0");
      AppMethodBeat.o(187909);
      return i;
    }
  }
  
  private static TPDownloadParam a(String paramString, com.tencent.thumbplayer.b.b.b paramb)
  {
    AppMethodBeat.i(210021);
    paramString = h.b(paramString, paramb);
    AppMethodBeat.o(210021);
    return paramString;
  }
  
  private String a(long paramLong, String paramString, com.tencent.thumbplayer.b.b.b paramb)
  {
    String str2 = null;
    AppMethodBeat.i(187900);
    if (!com.tencent.thumbplayer.utils.b.aRh(paramString))
    {
      AppMethodBeat.o(187900);
      return paramString;
    }
    if (yK(false))
    {
      AppMethodBeat.o(187900);
      return paramString;
    }
    if (this.KhC == null) {
      this.KhC = new LinkedList();
    }
    TPDownloadParam localTPDownloadParam;
    if (paramb != null) {
      localTPDownloadParam = a(paramString, paramb);
    }
    for (;;)
    {
      String str1;
      if (paramb != null) {
        str1 = paramString;
      }
      try
      {
        str2 = paramb.Kfx;
        str1 = paramString;
        int i = this.Khr.startPlay(str2, localTPDownloadParam, this.Khu);
        if (i > 0)
        {
          str1 = paramString;
          paramString = this.Khr.getPlayUrl(i);
          str1 = paramString;
          this.KhC.offer(new b(paramLong, i));
          str1 = paramString;
          com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
          AppMethodBeat.o(187900);
          return paramString;
          localTPDownloadParam = null;
        }
        else
        {
          str1 = paramString;
          com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def failed, cause : playId < 0");
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", paramString, "p2p proxy switch def failed");
          paramString = str1;
        }
      }
    }
    AppMethodBeat.o(187900);
    return paramString;
  }
  
  private void aeM(int paramInt)
  {
    AppMethodBeat.i(187905);
    if (yK(false))
    {
      AppMethodBeat.o(187905);
      return;
    }
    try
    {
      this.Khr.pauseDownload(paramInt);
      AppMethodBeat.o(187905);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pause download failed, taskId:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(187905);
    }
  }
  
  private void aeN(int paramInt)
  {
    AppMethodBeat.i(187907);
    if (yK(false))
    {
      AppMethodBeat.o(187907);
      return;
    }
    try
    {
      this.Khr.resumeDownload(this.Khz);
      AppMethodBeat.o(187907);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy resume download failed, taskId:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(187907);
    }
  }
  
  private void aeO(int paramInt)
  {
    AppMethodBeat.i(187912);
    if (yK(false))
    {
      AppMethodBeat.o(187912);
      return;
    }
    try
    {
      this.Khr.stopPlay(paramInt);
      AppMethodBeat.o(187912);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy stop play failed, taskID:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(187912);
    }
  }
  
  private void aeP(int paramInt)
  {
    AppMethodBeat.i(187913);
    if (yK(false))
    {
      AppMethodBeat.o(187913);
      return;
    }
    try
    {
      this.Khr.pushEvent(paramInt);
      AppMethodBeat.o(187913);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pushEvent failed, event:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(187913);
    }
  }
  
  private static List<com.tencent.thumbplayer.b.a.e> d(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(187908);
    if ((parama instanceof com.tencent.thumbplayer.d.b))
    {
      parama = ((com.tencent.thumbplayer.d.b)parama).KgT;
      if (!com.tencent.thumbplayer.utils.b.isEmpty(parama))
      {
        parama = (com.tencent.thumbplayer.b.a.d)parama.get(0);
        if ((parama != null) && (!com.tencent.thumbplayer.utils.b.isEmpty(parama.fFn())))
        {
          parama = parama.fFn();
          AppMethodBeat.o(187908);
          return parama;
        }
      }
    }
    else if ((parama instanceof com.tencent.thumbplayer.b.a.d))
    {
      parama = (com.tencent.thumbplayer.b.a.d)parama;
      if (!com.tencent.thumbplayer.utils.b.isEmpty(parama.fFn()))
      {
        parama = parama.fFn();
        AppMethodBeat.o(187908);
        return parama;
      }
    }
    else if ((parama instanceof com.tencent.thumbplayer.b.a.e))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add((com.tencent.thumbplayer.b.a.e)parama);
      AppMethodBeat.o(187908);
      return localArrayList;
    }
    AppMethodBeat.o(187908);
    return null;
  }
  
  private static com.tencent.thumbplayer.b.b.b e(ArrayList<com.tencent.thumbplayer.b.b.b> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(187922);
    if ((com.tencent.thumbplayer.utils.b.isEmpty(paramArrayList)) || (paramInt >= paramArrayList.size()))
    {
      AppMethodBeat.o(187922);
      return null;
    }
    paramArrayList = (com.tencent.thumbplayer.b.b.b)paramArrayList.get(paramInt);
    AppMethodBeat.o(187922);
    return paramArrayList;
  }
  
  private void fFN()
  {
    AppMethodBeat.i(187893);
    if (this.Khs)
    {
      AppMethodBeat.o(187893);
      return;
    }
    if (this.Kht > 0)
    {
      try
      {
        if (this.mServiceType == Khw) {
          this.mServiceType = com.tencent.thumbplayer.e.a.fFG();
        }
        b localb = f.a.fFP().aeR(this.mServiceType);
        if ((localb == null) || (localb.fFM() == null)) {
          break label257;
        }
        this.Khr = localb.fFM();
        this.Khr.setUserData("qq_is_vip", Boolean.valueOf(com.tencent.thumbplayer.e.a.fFF()));
        if (!TextUtils.isEmpty(com.tencent.thumbplayer.e.a.fFC())) {
          this.Khr.setUserData("user_uin", com.tencent.thumbplayer.e.a.fFC());
        }
        if (!TextUtils.isEmpty(com.tencent.thumbplayer.e.a.getAppVersionName(this.mContext))) {
          this.Khr.setUserData("app_version_name", com.tencent.thumbplayer.e.a.getAppVersionName(this.mContext));
        }
        if (com.tencent.thumbplayer.e.a.kV(this.mContext) != -1L) {
          this.Khr.setUserData("app_version_code", String.valueOf(com.tencent.thumbplayer.e.a.kV(this.mContext)));
        }
        this.Khr.setUserData("carrier_pesudo_code", com.tencent.thumbplayer.e.a.fFD());
        this.Khr.setUserData("carrier_pesudo_state", Integer.valueOf(com.tencent.thumbplayer.e.a.fFE()));
        this.Khs = true;
        AppMethodBeat.o(187893);
        return;
      }
      catch (Exception localException)
      {
        this.Kht -= 1;
        com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException);
      }
    }
    else
    {
      AppMethodBeat.o(187893);
      return;
    }
    label257:
    this.Kht -= 1;
    com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p so load failed");
    AppMethodBeat.o(187893);
  }
  
  private void fFO()
  {
    AppMethodBeat.i(187923);
    this.Khr.setUserData("dl_param_play_start_time", Long.valueOf(this.bZS));
    this.Khr.setUserData("dl_param_play_end_time", Long.valueOf(this.KhE));
    AppMethodBeat.o(187923);
  }
  
  private boolean mt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187895);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    paramString1 = new HashMap();
    paramString1.put("dl_param_data_transfer_mode", Integer.valueOf(1));
    paramString1 = new TPDownloadParam(localArrayList, 3, paramString1);
    boolean bool = this.Khr.setClipInfo(this.Khz, 2, paramString2, paramString1);
    AppMethodBeat.o(187895);
    return bool;
  }
  
  private boolean yK(boolean paramBoolean)
  {
    AppMethodBeat.i(187920);
    if (!com.tencent.thumbplayer.e.a.fFy())
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", "config set don't use p2p proxy!");
      AppMethodBeat.o(187920);
      return true;
    }
    if (paramBoolean) {
      this.Kht = 3;
    }
    fFN();
    if (!this.Khs)
    {
      AppMethodBeat.o(187920);
      return true;
    }
    AppMethodBeat.o(187920);
    return false;
  }
  
  public final void BY(long paramLong)
  {
    AppMethodBeat.i(187901);
    if (yK(false))
    {
      AppMethodBeat.o(187901);
      return;
    }
    try
    {
      if (!com.tencent.thumbplayer.utils.b.isEmpty(this.KhC))
      {
        for (b localb = (b)this.KhC.peek(); (localb != null) && (localb.KhH != paramLong); localb = (b)this.KhC.peek())
        {
          com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy definitionID:" + localb.KhH + ", taskID:" + localb.KhI);
          aeO(localb.KhI);
          this.KhC.removeFirst();
        }
        if (localb != null)
        {
          com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy task id:" + localb.KhI);
          aeO(this.Khz);
          this.Khz = localb.KhI;
          this.KhC.remove(localb);
        }
      }
      AppMethodBeat.o(187901);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException, "playerSwitchDefComplete exception");
      AppMethodBeat.o(187901);
    }
  }
  
  public final com.tencent.thumbplayer.b.a.a a(com.tencent.thumbplayer.b.a.a parama, long paramLong, p paramp)
  {
    AppMethodBeat.i(187899);
    if ((yK(false)) || (parama == null))
    {
      AppMethodBeat.o(187899);
      return parama;
    }
    if (this.KhC == null) {
      this.KhC = new LinkedList();
    }
    if (paramp == null)
    {
      AppMethodBeat.o(187899);
      return parama;
    }
    if ((parama instanceof com.tencent.thumbplayer.b.a.c)) {
      if (paramp.Kft == null) {
        break label240;
      }
    }
    label240:
    for (paramp = (com.tencent.thumbplayer.b.b.b)paramp.Kft.get(0);; paramp = null)
    {
      paramp = a(paramLong, ((com.tencent.thumbplayer.b.a.c)parama).fFl(), paramp);
      ((com.tencent.thumbplayer.b.a.c)parama).aTK(paramp);
      AppMethodBeat.o(187899);
      return parama;
      List localList = d(parama);
      if ((!com.tencent.thumbplayer.utils.b.isEmpty(localList)) && (paramp != null))
      {
        int i = a(localList, paramp.Kfs, paramp.Kft);
        if (i > 0)
        {
          this.KhC.offer(new b(paramLong, i));
          com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
          AppMethodBeat.o(187899);
          return parama;
        }
        com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch clip def failed, cause : playId < 0");
      }
      AppMethodBeat.o(187899);
      return parama;
    }
  }
  
  public final String a(int paramInt, String paramString, com.tencent.thumbplayer.b.b.b paramb)
  {
    i = 0;
    AppMethodBeat.i(187917);
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is empty");
      AppMethodBeat.o(187917);
      return paramString;
    }
    if (!com.tencent.thumbplayer.utils.b.aRh(paramString))
    {
      com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is locol url, not need use proxy");
      AppMethodBeat.o(187917);
      return paramString;
    }
    if (yK(false))
    {
      com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz download proxy init failed");
      AppMethodBeat.o(187917);
      return paramString;
    }
    if (paramb != null) {
      str = paramString;
    }
    for (;;)
    {
      try
      {
        paramb = h.b(paramString, paramb);
        str = paramString;
        paramInt = this.Khr.startPlay(com.tencent.thumbplayer.utils.b.axc(paramString), paramb, this.Khu);
        if (paramInt <= 0) {
          continue;
        }
        str = paramString;
        paramString = this.Khr.getPlayUrl(paramInt);
        str = paramString;
        this.KhD.put(paramString, Integer.valueOf(paramInt));
      }
      catch (Throwable paramString)
      {
        com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed:".concat(String.valueOf(paramString)));
        paramString = str;
        continue;
        if (paramInt != 2) {
          continue;
        }
        i = 3;
        continue;
        str = paramString;
        com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId < 0");
        continue;
      }
      AppMethodBeat.o(187917);
      return paramString;
      str = paramString;
      paramb = new ArrayList();
      str = paramString;
      paramb.add(paramString);
      if (paramInt != 3) {
        continue;
      }
      i = 10;
      str = paramString;
      paramb = new TPDownloadParam(paramb, i, null);
    }
  }
  
  public final String a(long paramLong, String paramString, p paramp)
  {
    AppMethodBeat.i(187898);
    if (paramp == null)
    {
      AppMethodBeat.o(187898);
      return paramString;
    }
    com.tencent.thumbplayer.b.b.b localb = null;
    if (paramp.Kft != null) {
      localb = (com.tencent.thumbplayer.b.b.b)paramp.Kft.get(0);
    }
    paramString = a(paramLong, paramString, localb);
    AppMethodBeat.o(187898);
    return paramString;
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(187919);
    if (paramp == null)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, param is null ");
      AppMethodBeat.o(187919);
      return;
    }
    if ((this.KhA != null) && (!yK(false)))
    {
      this.KhA = paramp;
      if ((paramp != null) && (paramp.Kft != null)) {
        break label117;
      }
      com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayManagerImpl.java]", "video or downloadParamList is null, return");
    }
    for (;;)
    {
      this.KhA = paramp;
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, enter");
      this.Khy = paramp.Kfs;
      if (!com.tencent.thumbplayer.utils.b.isEmpty(this.Khx)) {
        this.Khx.clear();
      }
      this.Khx = paramp.Kft;
      AppMethodBeat.o(187919);
      return;
      label117:
      if (this.Khz <= 0)
      {
        com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy not start, return");
      }
      else
      {
        ArrayList localArrayList = paramp.Kft;
        int i = 0;
        while (i < localArrayList.size())
        {
          com.tencent.thumbplayer.b.b.b localb = (com.tencent.thumbplayer.b.b.b)localArrayList.get(i);
          TPDownloadParam localTPDownloadParam = h.b(localb.url, localb);
          if (!this.Khr.setClipInfo(this.Khz, localb.KfL, localb.Kfx, localTPDownloadParam)) {
            com.tencent.thumbplayer.utils.f.w("TPThumbPlayer[TPPlayManagerImpl.java]", "setClipInfo failed, playID:" + this.Khz + ", clipNo:" + localb.KfL + ", downloadFileID:" + localb.Kfx);
          }
          i += 1;
        }
      }
    }
  }
  
  public final void a(ITPPlayListener paramITPPlayListener)
  {
    this.Khv = paramITPPlayListener;
  }
  
  public final String aTM(String paramString)
  {
    AppMethodBeat.i(187894);
    if (!com.tencent.thumbplayer.utils.b.aRh(paramString))
    {
      AppMethodBeat.o(187894);
      return paramString;
    }
    if (yK(true))
    {
      AppMethodBeat.o(187894);
      return paramString;
    }
    fFO();
    this.mOriginUrl = paramString;
    com.tencent.thumbplayer.b.b.b localb = e(this.Khx, 0);
    if (localb != null)
    {
      localObject2 = h.b(paramString, localb);
      localObject1 = paramString;
    }
    try
    {
      localStringBuilder = new StringBuilder("single url:").append(paramString).append(", paramData.savePath:");
      if (localb == null) {
        break label257;
      }
      localObject1 = paramString;
      str = localb.savePath;
      label107:
      localObject1 = paramString;
      localStringBuilder = localStringBuilder.append(str).append(", paramData.DownloadFileID:");
      if (localb == null) {
        break label306;
      }
      localObject1 = paramString;
      str = localb.Kfx;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", paramString, "p2p proxy start play failed");
        paramString = (String)localObject1;
        continue;
        String str = "null";
      }
    }
    localObject1 = paramString;
    com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", str);
    localObject1 = paramString;
    this.Khz = this.Khr.startPlay(this.Khy, (TPDownloadParam)localObject2, this.Khu);
    localObject1 = paramString;
    if (this.Khz > 0)
    {
      localObject1 = paramString;
      localObject2 = this.Khr.getPlayUrl(this.Khz);
    }
    try
    {
      boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
      if (!bool) {
        break label300;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        localObject1 = localObject2;
        continue;
        paramString = (String)localObject2;
      }
    }
    localObject1 = paramString;
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayManagerImpl.java]", "startDownloadPlay, playId:" + this.Khz);
    for (;;)
    {
      AppMethodBeat.o(187894);
      return paramString;
      localObject2 = null;
      break;
      label257:
      str = "null";
      break label107;
      localObject1 = paramString;
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId < 0");
    }
  }
  
  public final void aeL(int paramInt)
  {
    AppMethodBeat.i(187918);
    com.tencent.thumbplayer.utils.f.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState: ".concat(String.valueOf(paramInt)));
    if (yK(false))
    {
      AppMethodBeat.o(187918);
      return;
    }
    try
    {
      this.Khr.setPlayState(this.Khz, paramInt);
      AppMethodBeat.o(187918);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      AppMethodBeat.o(187918);
    }
  }
  
  public final void b(com.tencent.thumbplayer.b.f paramf)
  {
    AppMethodBeat.i(187916);
    if (yK(false))
    {
      AppMethodBeat.o(187916);
      return;
    }
    if ((paramf != null) && (paramf.key == 100))
    {
      this.bZS = paramf.KeS.value;
      AppMethodBeat.o(187916);
      return;
    }
    if ((paramf != null) && (paramf.key == 500))
    {
      this.KhE = paramf.KeS.value;
      if (this.Khz > 0) {
        this.Khr.setUserData("dl_param_play_end_time", Long.valueOf(this.KhE));
      }
    }
    AppMethodBeat.o(187916);
  }
  
  public final com.tencent.thumbplayer.b.a.a c(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(187903);
    if (yK(true))
    {
      AppMethodBeat.o(187903);
      return parama;
    }
    fFO();
    if ((parama instanceof g))
    {
      localObject = aTM(((g)parama).mPlayUrl);
      ((g)parama).mPlayUrl = ((String)localObject);
      AppMethodBeat.o(187903);
      return parama;
    }
    Object localObject = d(parama);
    if (!com.tencent.thumbplayer.utils.b.isEmpty((Collection)localObject)) {
      this.Khz = a((List)localObject, this.Khy, this.Khx);
    }
    AppMethodBeat.o(187903);
    return parama;
  }
  
  public final void fFI()
  {
    AppMethodBeat.i(187897);
    if (this.KhF)
    {
      aeO(this.Khz);
      aTM(this.mOriginUrl);
    }
    this.KhF = false;
    AppMethodBeat.o(187897);
  }
  
  public final boolean fFJ()
  {
    AppMethodBeat.i(187902);
    if (yK(false))
    {
      AppMethodBeat.o(187902);
      return false;
    }
    if ((this.KhC != null) && (this.KhC.size() > 0))
    {
      AppMethodBeat.o(187902);
      return true;
    }
    AppMethodBeat.o(187902);
    return false;
  }
  
  public final String fFK()
  {
    AppMethodBeat.i(187915);
    if (yK(false))
    {
      AppMethodBeat.o(187915);
      return null;
    }
    try
    {
      String str = this.Khr.getPlayErrorCodeStr(this.Khz);
      AppMethodBeat.o(187915);
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.f.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      AppMethodBeat.o(187915);
    }
    return null;
  }
  
  public final com.tencent.thumbplayer.b.b.a fFL()
  {
    return this.KhB;
  }
  
  public final void fFd()
  {
    AppMethodBeat.i(187906);
    aeN(this.Khz);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.KhC))
    {
      localIterator = this.KhC.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          aeN(localb.KhI);
        }
      }
    }
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.KhD))
    {
      localIterator = this.KhD.values().iterator();
      while (localIterator.hasNext()) {
        aeN(((Integer)localIterator.next()).intValue());
      }
    }
    AppMethodBeat.o(187906);
  }
  
  public final boolean isEnable()
  {
    AppMethodBeat.i(187914);
    if (!yK(false))
    {
      AppMethodBeat.o(187914);
      return true;
    }
    AppMethodBeat.o(187914);
    return false;
  }
  
  public final void kE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187924);
    com.tencent.thumbplayer.utils.f.d("TPThumbPlayer[TPPlayManagerImpl.java]", "onNetworkStatusChanged oldNetStatus: " + paramInt1 + ", netStatus: " + paramInt2);
    if (paramInt2 == 1)
    {
      aeP(1);
      aeP(10);
      AppMethodBeat.o(187924);
      return;
    }
    if (paramInt2 == 2)
    {
      aeP(2);
      aeP(9);
      AppMethodBeat.o(187924);
      return;
    }
    if (paramInt2 == 3)
    {
      aeP(2);
      aeP(10);
    }
    AppMethodBeat.o(187924);
  }
  
  public final void ms(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187896);
    if ((!com.tencent.thumbplayer.utils.b.aRh(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramString1 = new Exception("illegal argument.");
      AppMethodBeat.o(187896);
      throw paramString1;
    }
    if (!this.KhF)
    {
      if (!mt(paramString1, paramString2))
      {
        paramString1 = new Exception("setClipInfo err.");
        AppMethodBeat.o(187896);
        throw paramString1;
      }
    }
    else
    {
      aeO(this.Khz);
      aTM(this.mOriginUrl);
      if (!mt(paramString1, paramString2))
      {
        paramString1 = new Exception("setClipInfo err.");
        AppMethodBeat.o(187896);
        throw paramString1;
      }
    }
    this.KhF = true;
    AppMethodBeat.o(187896);
  }
  
  public final void pauseDownload()
  {
    AppMethodBeat.i(187904);
    aeM(this.Khz);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.KhC))
    {
      localIterator = this.KhC.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          aeM(localb.KhI);
        }
      }
    }
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.KhD))
    {
      localIterator = this.KhD.values().iterator();
      while (localIterator.hasNext()) {
        aeM(((Integer)localIterator.next()).intValue());
      }
    }
    AppMethodBeat.o(187904);
  }
  
  public final void release()
  {
    AppMethodBeat.i(187911);
    stopDownload();
    TPNetworkChangeMonitor.fGv().b(this);
    d.a.fGu().b(this);
    this.KhB = null;
    this.Khv = new d("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.Khu = null;
    this.Khr = null;
    AppMethodBeat.o(187911);
  }
  
  public final void stopDownload()
  {
    AppMethodBeat.i(187910);
    if (this.Khz < 0)
    {
      com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload failed, coz playId:" + this.Khz + ", less than zero. maybe download proxy didn't started");
      AppMethodBeat.o(187910);
      return;
    }
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload, playId:" + this.Khz);
    aeO(this.Khz);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.KhC))
    {
      localIterator = this.KhC.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          aeO(localb.KhI);
        }
      }
      this.KhC.clear();
    }
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.KhD))
    {
      localIterator = this.KhD.values().iterator();
      while (localIterator.hasNext()) {
        aeO(((Integer)localIterator.next()).intValue());
      }
      this.KhD.clear();
    }
    this.Khz = -1;
    com.tencent.thumbplayer.utils.f.i("TPThumbPlayer[TPPlayManagerImpl.java]", "reset");
    this.Khy = "";
    this.mOriginUrl = "";
    this.KhA = null;
    this.bZS = 0L;
    this.KhE = 0L;
    if (!com.tencent.thumbplayer.utils.b.isEmpty(this.Khx)) {
      this.Khx.clear();
    }
    AppMethodBeat.o(187910);
  }
  
  final class a
    implements ITPPlayListener
  {
    private a() {}
    
    public final long getAdvRemainTime()
    {
      AppMethodBeat.i(187883);
      long l = c.a(c.this).getAdvRemainTime();
      AppMethodBeat.o(187883);
      return l;
    }
    
    public final String getContentType(long paramLong, String paramString)
    {
      AppMethodBeat.i(187891);
      paramString = c.a(c.this).getContentType(paramLong, paramString);
      AppMethodBeat.o(187891);
      return paramString;
    }
    
    public final int getCurrentPlayClipNo()
    {
      AppMethodBeat.i(187882);
      int i = c.a(c.this).getCurrentPlayClipNo();
      AppMethodBeat.o(187882);
      return i;
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(187881);
      long l = c.a(c.this).getCurrentPosition();
      AppMethodBeat.o(187881);
      return l;
    }
    
    public final String getDataFilePath(long paramLong, String paramString)
    {
      AppMethodBeat.i(187890);
      paramString = c.a(c.this).getDataFilePath(paramLong, paramString);
      AppMethodBeat.o(187890);
      return paramString;
    }
    
    public final long getDataTotalSize(long paramLong, String paramString)
    {
      AppMethodBeat.i(187889);
      paramLong = c.a(c.this).getDataTotalSize(paramLong, paramString);
      AppMethodBeat.o(187889);
      return paramLong;
    }
    
    public final Object getPlayInfo(long paramLong)
    {
      AppMethodBeat.i(187884);
      Object localObject = c.a(c.this).getPlayInfo(paramLong);
      AppMethodBeat.o(187884);
      return localObject;
    }
    
    public final Object getPlayInfo(String paramString)
    {
      AppMethodBeat.i(187885);
      paramString = c.a(c.this).getPlayInfo(paramString);
      AppMethodBeat.o(187885);
      return paramString;
    }
    
    public final long getPlayerBufferLength()
    {
      AppMethodBeat.i(187880);
      long l = c.a(c.this).getPlayerBufferLength();
      AppMethodBeat.o(187880);
      return l;
    }
    
    public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
    {
      AppMethodBeat.i(187878);
      c.a(c.this).onDownloadCdnUrlExpired(paramMap);
      AppMethodBeat.o(187878);
    }
    
    public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(187875);
      c.a(c.this).onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(187875);
    }
    
    public final void onDownloadCdnUrlUpdate(String paramString)
    {
      AppMethodBeat.i(187874);
      c.a(c.this).onDownloadCdnUrlUpdate(paramString);
      AppMethodBeat.o(187874);
    }
    
    public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(187873);
      c.a(c.this).onDownloadError(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(187873);
    }
    
    public final void onDownloadFinish()
    {
      AppMethodBeat.i(187872);
      c.a(c.this).onDownloadFinish();
      AppMethodBeat.o(187872);
    }
    
    public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(187871);
      c.a(c.this).onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
      AppMethodBeat.o(187871);
    }
    
    public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
    {
      AppMethodBeat.i(187877);
      c.a(c.this).onDownloadProtocolUpdate(paramString1, paramString2);
      AppMethodBeat.o(187877);
    }
    
    public final void onDownloadStatusUpdate(int paramInt)
    {
      AppMethodBeat.i(187876);
      c.a(c.this).onDownloadStatusUpdate(paramInt);
      AppMethodBeat.o(187876);
    }
    
    public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      AppMethodBeat.i(187879);
      paramObject1 = c.a(c.this).onPlayCallback(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
      AppMethodBeat.o(187879);
      return paramObject1;
    }
    
    public final int onReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(187887);
      int i = c.a(c.this).onReadData(paramLong1, paramString, paramLong2, paramLong3);
      AppMethodBeat.o(187887);
      return i;
    }
    
    public final int onStartReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(187886);
      int i = c.a(c.this).onStartReadData(paramLong1, paramString, paramLong2, paramLong3);
      AppMethodBeat.o(187886);
      return i;
    }
    
    public final int onStopReadData(long paramLong, String paramString)
    {
      AppMethodBeat.i(187888);
      int i = c.a(c.this).onStopReadData(paramLong, paramString);
      AppMethodBeat.o(187888);
      return i;
    }
  }
  
  static final class b
  {
    long KhH;
    int KhI;
    
    b(long paramLong, int paramInt)
    {
      this.KhH = paramLong;
      this.KhI = paramInt;
    }
  }
  
  static final class c
  {
    int KhJ;
    int KhK;
    
    c(int paramInt1, int paramInt2)
    {
      this.KhJ = paramInt1;
      this.KhK = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.f.c
 * JD-Core Version:    0.7.0.1
 */