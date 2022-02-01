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
import com.tencent.thumbplayer.utils.b.a;
import com.tencent.thumbplayer.utils.b.b;
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
  implements a, TPNetworkChangeMonitor.b, b.b
{
  private static int MaM = -1;
  private ITPDownloadProxy MaH;
  private boolean MaI;
  private int MaJ;
  private a MaK;
  private ITPPlayListener MaL;
  private ArrayList<com.tencent.thumbplayer.b.b.b> MaN;
  private String MaO;
  private int MaP;
  private p MaQ;
  private com.tencent.thumbplayer.b.b.a MaR;
  private LinkedList<b> MaS;
  private HashMap<String, Integer> MaT;
  private long MaU;
  private boolean MaV;
  private long ckk;
  private Context mContext;
  private String mOriginUrl;
  private int mServiceType;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(191913);
    this.MaI = false;
    this.MaJ = 3;
    this.mServiceType = MaM;
    this.MaP = -1;
    this.MaR = null;
    this.MaV = false;
    this.mContext = paramContext;
    b.a.fXG().a(this);
    TPNetworkChangeMonitor.fXH().a(this);
    this.MaK = new a((byte)0);
    this.MaL = new d("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.MaT = new HashMap();
    AppMethodBeat.o(191913);
  }
  
  private int a(List<com.tencent.thumbplayer.b.a.e> paramList, String paramString, ArrayList<com.tencent.thumbplayer.b.b.b> paramArrayList)
  {
    AppMethodBeat.i(191930);
    if (com.tencent.thumbplayer.utils.a.isEmpty(paramList))
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayManagerImpl.java]", "clipList is empty, return");
      AppMethodBeat.o(191930);
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
      if ((!(localObject2 instanceof com.tencent.thumbplayer.d.e)) || (!com.tencent.thumbplayer.utils.a.aXf(((com.tencent.thumbplayer.d.e)localObject2).Mar))) {
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
      if (com.tencent.thumbplayer.utils.a.isEmpty((Map)localObject1))
      {
        com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "all urls is local file url, return");
        AppMethodBeat.o(191930);
        return -1;
      }
      if ((paramArrayList.size() > 0) && (((com.tencent.thumbplayer.b.b.b)paramArrayList.get(0)).LZP) && (!TPDownloadProxyFactory.isReadyForDownload()))
      {
        paramList = a("", e(paramArrayList, 0));
        i = this.MaH.startPlay(paramString, paramList, this.MaK);
        if (i > 0)
        {
          paramList = ((HashMap)localObject1).entrySet().iterator();
          while (paramList.hasNext())
          {
            paramArrayList = (Map.Entry)paramList.next();
            paramString = (com.tencent.thumbplayer.b.a.e)paramArrayList.getKey();
            paramArrayList = (c)paramArrayList.getValue();
            if ((paramString instanceof com.tencent.thumbplayer.d.e)) {
              ((com.tencent.thumbplayer.d.e)paramString).Mar = this.MaH.getClipPlayUrl(i, paramArrayList.Mba + 1);
            }
          }
          AppMethodBeat.o(191930);
          return i;
        }
      }
      i = this.MaH.startClipPlay(paramString, ((HashMap)localObject1).size(), this.MaK);
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
            Object localObject3 = e(paramArrayList, paramString.Mba);
            if (localObject3 == null)
            {
              com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "fatal err, paramData is null.");
              AppMethodBeat.o(191930);
              return -1;
            }
            com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "multi trackClipIndex:" + paramString.Mba + ", download seq:" + paramString.MaZ + ", clip.url:" + ((com.tencent.thumbplayer.d.e)localObject1).getUrl() + ", clip.getFilePath:" + ((com.tencent.thumbplayer.d.e)localObject1).Mar + ", paramData.savePath:" + ((com.tencent.thumbplayer.b.b.b)localObject3).savePath + ", paramData.DownloadFileID:" + ((com.tencent.thumbplayer.b.b.b)localObject3).LZr);
            localObject2 = ((com.tencent.thumbplayer.b.b.b)localObject3).LZr;
            localObject3 = a(((com.tencent.thumbplayer.d.e)localObject1).Mar, (com.tencent.thumbplayer.b.b.b)localObject3);
            if (this.MaH.setClipInfo(i, paramString.MaZ, (String)localObject2, (TPDownloadParam)localObject3)) {
              ((com.tencent.thumbplayer.d.e)localObject1).Mar = this.MaH.getClipPlayUrl(i, paramString.MaZ);
            }
          }
        }
      }
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start clip play failed, cause : playId < 0");
      AppMethodBeat.o(191930);
      return i;
    }
  }
  
  private static TPDownloadParam a(String paramString, com.tencent.thumbplayer.b.b.b paramb)
  {
    AppMethodBeat.i(221339);
    paramString = h.b(paramString, paramb);
    AppMethodBeat.o(221339);
    return paramString;
  }
  
  private String a(long paramLong, String paramString, com.tencent.thumbplayer.b.b.b paramb)
  {
    String str2 = null;
    AppMethodBeat.i(191921);
    if (!com.tencent.thumbplayer.utils.a.aXf(paramString))
    {
      AppMethodBeat.o(191921);
      return paramString;
    }
    if (zx(false))
    {
      AppMethodBeat.o(191921);
      return paramString;
    }
    if (this.MaS == null) {
      this.MaS = new LinkedList();
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
        str2 = paramb.LZr;
        str1 = paramString;
        int i = this.MaH.startPlay(str2, localTPDownloadParam, this.MaK);
        if (i > 0)
        {
          str1 = paramString;
          paramString = this.MaH.getPlayUrl(i);
          str1 = paramString;
          this.MaS.offer(new b(paramLong, i));
          str1 = paramString;
          com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
          AppMethodBeat.o(191921);
          return paramString;
          localTPDownloadParam = null;
        }
        else
        {
          str1 = paramString;
          com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def failed, cause : playId < 0");
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", paramString, "p2p proxy switch def failed");
          paramString = str1;
        }
      }
    }
    AppMethodBeat.o(191921);
    return paramString;
  }
  
  private void ahm(int paramInt)
  {
    AppMethodBeat.i(191926);
    if (zx(false))
    {
      AppMethodBeat.o(191926);
      return;
    }
    try
    {
      this.MaH.pauseDownload(paramInt);
      AppMethodBeat.o(191926);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pause download failed, taskId:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(191926);
    }
  }
  
  private void ahn(int paramInt)
  {
    AppMethodBeat.i(191928);
    if (zx(false))
    {
      AppMethodBeat.o(191928);
      return;
    }
    try
    {
      this.MaH.resumeDownload(this.MaP);
      AppMethodBeat.o(191928);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy resume download failed, taskId:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(191928);
    }
  }
  
  private void aho(int paramInt)
  {
    AppMethodBeat.i(191933);
    if (zx(false))
    {
      AppMethodBeat.o(191933);
      return;
    }
    try
    {
      this.MaH.stopPlay(paramInt);
      AppMethodBeat.o(191933);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy stop play failed, taskID:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(191933);
    }
  }
  
  private void ahp(int paramInt)
  {
    AppMethodBeat.i(191934);
    if (zx(false))
    {
      AppMethodBeat.o(191934);
      return;
    }
    try
    {
      this.MaH.pushEvent(paramInt);
      AppMethodBeat.o(191934);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pushEvent failed, event:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(191934);
    }
  }
  
  private static List<com.tencent.thumbplayer.b.a.e> d(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(191929);
    if ((parama instanceof com.tencent.thumbplayer.d.b))
    {
      parama = ((com.tencent.thumbplayer.d.b)parama).Maj;
      if (!com.tencent.thumbplayer.utils.a.isEmpty(parama))
      {
        parama = (com.tencent.thumbplayer.b.a.d)parama.get(0);
        if ((parama != null) && (!com.tencent.thumbplayer.utils.a.isEmpty(parama.fWE())))
        {
          parama = parama.fWE();
          AppMethodBeat.o(191929);
          return parama;
        }
      }
    }
    else if ((parama instanceof com.tencent.thumbplayer.b.a.d))
    {
      parama = (com.tencent.thumbplayer.b.a.d)parama;
      if (!com.tencent.thumbplayer.utils.a.isEmpty(parama.fWE()))
      {
        parama = parama.fWE();
        AppMethodBeat.o(191929);
        return parama;
      }
    }
    else if ((parama instanceof com.tencent.thumbplayer.b.a.e))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add((com.tencent.thumbplayer.b.a.e)parama);
      AppMethodBeat.o(191929);
      return localArrayList;
    }
    AppMethodBeat.o(191929);
    return null;
  }
  
  private static com.tencent.thumbplayer.b.b.b e(ArrayList<com.tencent.thumbplayer.b.b.b> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(191943);
    if ((com.tencent.thumbplayer.utils.a.isEmpty(paramArrayList)) || (paramInt >= paramArrayList.size()))
    {
      AppMethodBeat.o(191943);
      return null;
    }
    paramArrayList = (com.tencent.thumbplayer.b.b.b)paramArrayList.get(paramInt);
    AppMethodBeat.o(191943);
    return paramArrayList;
  }
  
  private void fXc()
  {
    AppMethodBeat.i(191914);
    if (this.MaI)
    {
      AppMethodBeat.o(191914);
      return;
    }
    if (this.MaJ > 0)
    {
      try
      {
        if (this.mServiceType == MaM) {
          this.mServiceType = com.tencent.thumbplayer.e.a.fWV();
        }
        b localb = f.a.fXe().ahr(this.mServiceType);
        if ((localb == null) || (localb.fXb() == null)) {
          break label257;
        }
        this.MaH = localb.fXb();
        this.MaH.setUserData("qq_is_vip", Boolean.valueOf(com.tencent.thumbplayer.e.a.fWU()));
        if (!TextUtils.isEmpty(com.tencent.thumbplayer.e.a.fWR())) {
          this.MaH.setUserData("user_uin", com.tencent.thumbplayer.e.a.fWR());
        }
        if (!TextUtils.isEmpty(com.tencent.thumbplayer.e.a.getAppVersionName(this.mContext))) {
          this.MaH.setUserData("app_version_name", com.tencent.thumbplayer.e.a.getAppVersionName(this.mContext));
        }
        if (com.tencent.thumbplayer.e.a.li(this.mContext) != -1L) {
          this.MaH.setUserData("app_version_code", String.valueOf(com.tencent.thumbplayer.e.a.li(this.mContext)));
        }
        this.MaH.setUserData("carrier_pesudo_code", com.tencent.thumbplayer.e.a.fWS());
        this.MaH.setUserData("carrier_pesudo_state", Integer.valueOf(com.tencent.thumbplayer.e.a.fWT()));
        this.MaI = true;
        AppMethodBeat.o(191914);
        return;
      }
      catch (Exception localException)
      {
        this.MaJ -= 1;
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException);
      }
    }
    else
    {
      AppMethodBeat.o(191914);
      return;
    }
    label257:
    this.MaJ -= 1;
    com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p so load failed");
    AppMethodBeat.o(191914);
  }
  
  private void fXd()
  {
    AppMethodBeat.i(191944);
    this.MaH.setUserData("dl_param_play_start_time", Long.valueOf(this.ckk));
    this.MaH.setUserData("dl_param_play_end_time", Long.valueOf(this.MaU));
    AppMethodBeat.o(191944);
  }
  
  private boolean mR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(191916);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    paramString1 = new HashMap();
    paramString1.put("dl_param_data_transfer_mode", Integer.valueOf(1));
    paramString1 = new TPDownloadParam(localArrayList, 3, paramString1);
    boolean bool = this.MaH.setClipInfo(this.MaP, 2, paramString2, paramString1);
    AppMethodBeat.o(191916);
    return bool;
  }
  
  private boolean zx(boolean paramBoolean)
  {
    AppMethodBeat.i(191941);
    if (!com.tencent.thumbplayer.e.a.fWN())
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "config set don't use p2p proxy!");
      AppMethodBeat.o(191941);
      return true;
    }
    if (paramBoolean) {
      this.MaJ = 3;
    }
    fXc();
    if (!this.MaI)
    {
      AppMethodBeat.o(191941);
      return true;
    }
    AppMethodBeat.o(191941);
    return false;
  }
  
  public final void Fa(long paramLong)
  {
    AppMethodBeat.i(191922);
    if (zx(false))
    {
      AppMethodBeat.o(191922);
      return;
    }
    try
    {
      if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MaS))
      {
        for (b localb = (b)this.MaS.peek(); (localb != null) && (localb.MaX != paramLong); localb = (b)this.MaS.peek())
        {
          com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy definitionID:" + localb.MaX + ", taskID:" + localb.MaY);
          aho(localb.MaY);
          this.MaS.removeFirst();
        }
        if (localb != null)
        {
          com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy task id:" + localb.MaY);
          aho(this.MaP);
          this.MaP = localb.MaY;
          this.MaS.remove(localb);
        }
      }
      AppMethodBeat.o(191922);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException, "playerSwitchDefComplete exception");
      AppMethodBeat.o(191922);
    }
  }
  
  public final com.tencent.thumbplayer.b.a.a a(com.tencent.thumbplayer.b.a.a parama, long paramLong, p paramp)
  {
    AppMethodBeat.i(191920);
    if ((zx(false)) || (parama == null))
    {
      AppMethodBeat.o(191920);
      return parama;
    }
    if (this.MaS == null) {
      this.MaS = new LinkedList();
    }
    if (paramp == null)
    {
      AppMethodBeat.o(191920);
      return parama;
    }
    if ((parama instanceof com.tencent.thumbplayer.b.a.c)) {
      if (paramp.LZn == null) {
        break label240;
      }
    }
    label240:
    for (paramp = (com.tencent.thumbplayer.b.b.b)paramp.LZn.get(0);; paramp = null)
    {
      paramp = a(paramLong, ((com.tencent.thumbplayer.b.a.c)parama).fWC(), paramp);
      ((com.tencent.thumbplayer.b.a.c)parama).aZK(paramp);
      AppMethodBeat.o(191920);
      return parama;
      List localList = d(parama);
      if ((!com.tencent.thumbplayer.utils.a.isEmpty(localList)) && (paramp != null))
      {
        int i = a(localList, paramp.LZm, paramp.LZn);
        if (i > 0)
        {
          this.MaS.offer(new b(paramLong, i));
          com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
          AppMethodBeat.o(191920);
          return parama;
        }
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch clip def failed, cause : playId < 0");
      }
      AppMethodBeat.o(191920);
      return parama;
    }
  }
  
  public final String a(int paramInt, String paramString, com.tencent.thumbplayer.b.b.b paramb)
  {
    i = 0;
    AppMethodBeat.i(191938);
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is empty");
      AppMethodBeat.o(191938);
      return paramString;
    }
    if (!com.tencent.thumbplayer.utils.a.aXf(paramString))
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is locol url, not need use proxy");
      AppMethodBeat.o(191938);
      return paramString;
    }
    if (zx(false))
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz download proxy init failed");
      AppMethodBeat.o(191938);
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
        paramInt = this.MaH.startPlay(com.tencent.thumbplayer.utils.a.aCg(paramString), paramb, this.MaK);
        if (paramInt <= 0) {
          continue;
        }
        str = paramString;
        paramString = this.MaH.getPlayUrl(paramInt);
        str = paramString;
        this.MaT.put(paramString, Integer.valueOf(paramInt));
      }
      catch (Throwable paramString)
      {
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed:".concat(String.valueOf(paramString)));
        paramString = str;
        continue;
        if (paramInt != 2) {
          continue;
        }
        i = 3;
        continue;
        str = paramString;
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId < 0");
        continue;
      }
      AppMethodBeat.o(191938);
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
    AppMethodBeat.i(191919);
    if (paramp == null)
    {
      AppMethodBeat.o(191919);
      return paramString;
    }
    com.tencent.thumbplayer.b.b.b localb = null;
    if (paramp.LZn != null) {
      localb = (com.tencent.thumbplayer.b.b.b)paramp.LZn.get(0);
    }
    paramString = a(paramLong, paramString, localb);
    AppMethodBeat.o(191919);
    return paramString;
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(191940);
    if (paramp == null)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, param is null ");
      AppMethodBeat.o(191940);
      return;
    }
    if ((this.MaQ != null) && (!zx(false)))
    {
      this.MaQ = paramp;
      if ((paramp != null) && (paramp.LZn != null)) {
        break label117;
      }
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayManagerImpl.java]", "video or downloadParamList is null, return");
    }
    for (;;)
    {
      this.MaQ = paramp;
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, enter");
      this.MaO = paramp.LZm;
      if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MaN)) {
        this.MaN.clear();
      }
      this.MaN = paramp.LZn;
      AppMethodBeat.o(191940);
      return;
      label117:
      if (this.MaP <= 0)
      {
        com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy not start, return");
      }
      else
      {
        ArrayList localArrayList = paramp.LZn;
        int i = 0;
        while (i < localArrayList.size())
        {
          com.tencent.thumbplayer.b.b.b localb = (com.tencent.thumbplayer.b.b.b)localArrayList.get(i);
          TPDownloadParam localTPDownloadParam = h.b(localb.url, localb);
          if (!this.MaH.setClipInfo(this.MaP, localb.LZF, localb.LZr, localTPDownloadParam)) {
            com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayManagerImpl.java]", "setClipInfo failed, playID:" + this.MaP + ", clipNo:" + localb.LZF + ", downloadFileID:" + localb.LZr);
          }
          i += 1;
        }
      }
    }
  }
  
  public final void a(ITPPlayListener paramITPPlayListener)
  {
    this.MaL = paramITPPlayListener;
  }
  
  public final String aZM(String paramString)
  {
    AppMethodBeat.i(191915);
    if (!com.tencent.thumbplayer.utils.a.aXf(paramString))
    {
      AppMethodBeat.o(191915);
      return paramString;
    }
    if (zx(true))
    {
      AppMethodBeat.o(191915);
      return paramString;
    }
    fXd();
    this.mOriginUrl = paramString;
    com.tencent.thumbplayer.b.b.b localb = e(this.MaN, 0);
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
      str = localb.LZr;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", paramString, "p2p proxy start play failed");
        paramString = (String)localObject1;
        continue;
        String str = "null";
      }
    }
    localObject1 = paramString;
    com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", str);
    localObject1 = paramString;
    this.MaP = this.MaH.startPlay(this.MaO, (TPDownloadParam)localObject2, this.MaK);
    localObject1 = paramString;
    if (this.MaP > 0)
    {
      localObject1 = paramString;
      localObject2 = this.MaH.getPlayUrl(this.MaP);
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
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "startDownloadPlay, playId:" + this.MaP);
    for (;;)
    {
      AppMethodBeat.o(191915);
      return paramString;
      localObject2 = null;
      break;
      label257:
      str = "null";
      break label107;
      localObject1 = paramString;
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId < 0");
    }
  }
  
  public final void ahl(int paramInt)
  {
    AppMethodBeat.i(191939);
    com.tencent.thumbplayer.utils.d.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState: ".concat(String.valueOf(paramInt)));
    if (zx(false))
    {
      AppMethodBeat.o(191939);
      return;
    }
    try
    {
      this.MaH.setPlayState(this.MaP, paramInt);
      AppMethodBeat.o(191939);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      AppMethodBeat.o(191939);
    }
  }
  
  public final void b(com.tencent.thumbplayer.b.f paramf)
  {
    AppMethodBeat.i(191937);
    if (zx(false))
    {
      AppMethodBeat.o(191937);
      return;
    }
    if ((paramf != null) && (paramf.key == 100))
    {
      this.ckk = paramf.LYO.value;
      AppMethodBeat.o(191937);
      return;
    }
    if ((paramf != null) && (paramf.key == 500))
    {
      this.MaU = paramf.LYO.value;
      if (this.MaP > 0) {
        this.MaH.setUserData("dl_param_play_end_time", Long.valueOf(this.MaU));
      }
    }
    AppMethodBeat.o(191937);
  }
  
  public final com.tencent.thumbplayer.b.a.a c(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(191924);
    if (zx(true))
    {
      AppMethodBeat.o(191924);
      return parama;
    }
    fXd();
    if ((parama instanceof g))
    {
      localObject = aZM(((g)parama).mPlayUrl);
      ((g)parama).mPlayUrl = ((String)localObject);
      AppMethodBeat.o(191924);
      return parama;
    }
    Object localObject = d(parama);
    if (!com.tencent.thumbplayer.utils.a.isEmpty((Collection)localObject)) {
      this.MaP = a((List)localObject, this.MaO, this.MaN);
    }
    AppMethodBeat.o(191924);
    return parama;
  }
  
  public final void fWX()
  {
    AppMethodBeat.i(191918);
    if (this.MaV)
    {
      aho(this.MaP);
      aZM(this.mOriginUrl);
    }
    this.MaV = false;
    AppMethodBeat.o(191918);
  }
  
  public final boolean fWY()
  {
    AppMethodBeat.i(191923);
    if (zx(false))
    {
      AppMethodBeat.o(191923);
      return false;
    }
    if ((this.MaS != null) && (this.MaS.size() > 0))
    {
      AppMethodBeat.o(191923);
      return true;
    }
    AppMethodBeat.o(191923);
    return false;
  }
  
  public final String fWZ()
  {
    AppMethodBeat.i(191936);
    if (zx(false))
    {
      AppMethodBeat.o(191936);
      return null;
    }
    try
    {
      String str = this.MaH.getPlayErrorCodeStr(this.MaP);
      AppMethodBeat.o(191936);
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      AppMethodBeat.o(191936);
    }
    return null;
  }
  
  public final void fWu()
  {
    AppMethodBeat.i(191927);
    ahn(this.MaP);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MaS))
    {
      localIterator = this.MaS.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          ahn(localb.MaY);
        }
      }
    }
    if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MaT))
    {
      localIterator = this.MaT.values().iterator();
      while (localIterator.hasNext()) {
        ahn(((Integer)localIterator.next()).intValue());
      }
    }
    AppMethodBeat.o(191927);
  }
  
  public final com.tencent.thumbplayer.b.b.a fXa()
  {
    return this.MaR;
  }
  
  public final boolean isEnable()
  {
    AppMethodBeat.i(191935);
    if (!zx(false))
    {
      AppMethodBeat.o(191935);
      return true;
    }
    AppMethodBeat.o(191935);
    return false;
  }
  
  public final void kT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191945);
    com.tencent.thumbplayer.utils.d.d("TPThumbPlayer[TPPlayManagerImpl.java]", "onNetworkStatusChanged oldNetStatus: " + paramInt1 + ", netStatus: " + paramInt2);
    if (paramInt2 == 1)
    {
      ahp(1);
      ahp(10);
      AppMethodBeat.o(191945);
      return;
    }
    if (paramInt2 == 2)
    {
      ahp(2);
      ahp(9);
      AppMethodBeat.o(191945);
      return;
    }
    if (paramInt2 == 3)
    {
      ahp(2);
      ahp(10);
    }
    AppMethodBeat.o(191945);
  }
  
  public final void mQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(191917);
    if ((!com.tencent.thumbplayer.utils.a.aXf(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramString1 = new Exception("illegal argument.");
      AppMethodBeat.o(191917);
      throw paramString1;
    }
    if (!this.MaV)
    {
      if (!mR(paramString1, paramString2))
      {
        paramString1 = new Exception("setClipInfo err.");
        AppMethodBeat.o(191917);
        throw paramString1;
      }
    }
    else
    {
      aho(this.MaP);
      aZM(this.mOriginUrl);
      if (!mR(paramString1, paramString2))
      {
        paramString1 = new Exception("setClipInfo err.");
        AppMethodBeat.o(191917);
        throw paramString1;
      }
    }
    this.MaV = true;
    AppMethodBeat.o(191917);
  }
  
  public final void pauseDownload()
  {
    AppMethodBeat.i(191925);
    ahm(this.MaP);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MaS))
    {
      localIterator = this.MaS.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          ahm(localb.MaY);
        }
      }
    }
    if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MaT))
    {
      localIterator = this.MaT.values().iterator();
      while (localIterator.hasNext()) {
        ahm(((Integer)localIterator.next()).intValue());
      }
    }
    AppMethodBeat.o(191925);
  }
  
  public final void release()
  {
    AppMethodBeat.i(191932);
    stopDownload();
    TPNetworkChangeMonitor.fXH().b(this);
    b.a.fXG().b(this);
    this.MaR = null;
    this.MaL = new d("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.MaK = null;
    this.MaH = null;
    AppMethodBeat.o(191932);
  }
  
  public final void stopDownload()
  {
    AppMethodBeat.i(191931);
    if (this.MaP < 0)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload failed, coz playId:" + this.MaP + ", less than zero. maybe download proxy didn't started");
      AppMethodBeat.o(191931);
      return;
    }
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload, playId:" + this.MaP);
    aho(this.MaP);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MaS))
    {
      localIterator = this.MaS.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          aho(localb.MaY);
        }
      }
      this.MaS.clear();
    }
    if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MaT))
    {
      localIterator = this.MaT.values().iterator();
      while (localIterator.hasNext()) {
        aho(((Integer)localIterator.next()).intValue());
      }
      this.MaT.clear();
    }
    this.MaP = -1;
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "reset");
    this.MaO = "";
    this.mOriginUrl = "";
    this.MaQ = null;
    this.ckk = 0L;
    this.MaU = 0L;
    if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MaN)) {
      this.MaN.clear();
    }
    AppMethodBeat.o(191931);
  }
  
  final class a
    implements ITPPlayListener
  {
    private a() {}
    
    public final long getAdvRemainTime()
    {
      AppMethodBeat.i(191904);
      long l = c.a(c.this).getAdvRemainTime();
      AppMethodBeat.o(191904);
      return l;
    }
    
    public final String getContentType(long paramLong, String paramString)
    {
      AppMethodBeat.i(191912);
      paramString = c.a(c.this).getContentType(paramLong, paramString);
      AppMethodBeat.o(191912);
      return paramString;
    }
    
    public final int getCurrentPlayClipNo()
    {
      AppMethodBeat.i(191903);
      int i = c.a(c.this).getCurrentPlayClipNo();
      AppMethodBeat.o(191903);
      return i;
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(191902);
      long l = c.a(c.this).getCurrentPosition();
      AppMethodBeat.o(191902);
      return l;
    }
    
    public final String getDataFilePath(long paramLong, String paramString)
    {
      AppMethodBeat.i(191911);
      paramString = c.a(c.this).getDataFilePath(paramLong, paramString);
      AppMethodBeat.o(191911);
      return paramString;
    }
    
    public final long getDataTotalSize(long paramLong, String paramString)
    {
      AppMethodBeat.i(191910);
      paramLong = c.a(c.this).getDataTotalSize(paramLong, paramString);
      AppMethodBeat.o(191910);
      return paramLong;
    }
    
    public final Object getPlayInfo(long paramLong)
    {
      AppMethodBeat.i(191905);
      Object localObject = c.a(c.this).getPlayInfo(paramLong);
      AppMethodBeat.o(191905);
      return localObject;
    }
    
    public final Object getPlayInfo(String paramString)
    {
      AppMethodBeat.i(191906);
      paramString = c.a(c.this).getPlayInfo(paramString);
      AppMethodBeat.o(191906);
      return paramString;
    }
    
    public final long getPlayerBufferLength()
    {
      AppMethodBeat.i(191901);
      long l = c.a(c.this).getPlayerBufferLength();
      AppMethodBeat.o(191901);
      return l;
    }
    
    public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
    {
      AppMethodBeat.i(191899);
      c.a(c.this).onDownloadCdnUrlExpired(paramMap);
      AppMethodBeat.o(191899);
    }
    
    public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(191896);
      c.a(c.this).onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(191896);
    }
    
    public final void onDownloadCdnUrlUpdate(String paramString)
    {
      AppMethodBeat.i(191895);
      c.a(c.this).onDownloadCdnUrlUpdate(paramString);
      AppMethodBeat.o(191895);
    }
    
    public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(191894);
      c.a(c.this).onDownloadError(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(191894);
    }
    
    public final void onDownloadFinish()
    {
      AppMethodBeat.i(191893);
      c.a(c.this).onDownloadFinish();
      AppMethodBeat.o(191893);
    }
    
    public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191892);
      c.a(c.this).onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
      AppMethodBeat.o(191892);
    }
    
    public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191898);
      c.a(c.this).onDownloadProtocolUpdate(paramString1, paramString2);
      AppMethodBeat.o(191898);
    }
    
    public final void onDownloadStatusUpdate(int paramInt)
    {
      AppMethodBeat.i(191897);
      c.a(c.this).onDownloadStatusUpdate(paramInt);
      AppMethodBeat.o(191897);
    }
    
    public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      AppMethodBeat.i(191900);
      paramObject1 = c.a(c.this).onPlayCallback(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
      AppMethodBeat.o(191900);
      return paramObject1;
    }
    
    public final int onReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(191908);
      int i = c.a(c.this).onReadData(paramLong1, paramString, paramLong2, paramLong3);
      AppMethodBeat.o(191908);
      return i;
    }
    
    public final int onStartReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(191907);
      int i = c.a(c.this).onStartReadData(paramLong1, paramString, paramLong2, paramLong3);
      AppMethodBeat.o(191907);
      return i;
    }
    
    public final int onStopReadData(long paramLong, String paramString)
    {
      AppMethodBeat.i(191909);
      int i = c.a(c.this).onStopReadData(paramLong, paramString);
      AppMethodBeat.o(191909);
      return i;
    }
  }
  
  static final class b
  {
    long MaX;
    int MaY;
    
    b(long paramLong, int paramInt)
    {
      this.MaX = paramLong;
      this.MaY = paramInt;
    }
  }
  
  static final class c
  {
    int MaZ;
    int Mba;
    
    c(int paramInt1, int paramInt2)
    {
      this.MaZ = paramInt1;
      this.Mba = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.f.c
 * JD-Core Version:    0.7.0.1
 */