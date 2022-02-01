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
  private static int MxH = -1;
  private ITPDownloadProxy MxC;
  private boolean MxD;
  private int MxE;
  private a MxF;
  private ITPPlayListener MxG;
  private ArrayList<com.tencent.thumbplayer.b.b.b> MxI;
  private String MxJ;
  private int MxK;
  private p MxL;
  private com.tencent.thumbplayer.b.b.a MxM;
  private LinkedList<b> MxN;
  private HashMap<String, Integer> MxO;
  private long MxP;
  private boolean MxQ;
  private long ckm;
  private Context mContext;
  private String mOriginUrl;
  private int mServiceType;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(194591);
    this.MxD = false;
    this.MxE = 3;
    this.mServiceType = MxH;
    this.MxK = -1;
    this.MxM = null;
    this.MxQ = false;
    this.mContext = paramContext;
    b.a.gcf().a(this);
    TPNetworkChangeMonitor.gcg().a(this);
    this.MxF = new a((byte)0);
    this.MxG = new d("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.MxO = new HashMap();
    AppMethodBeat.o(194591);
  }
  
  private int a(List<com.tencent.thumbplayer.b.a.e> paramList, String paramString, ArrayList<com.tencent.thumbplayer.b.b.b> paramArrayList)
  {
    AppMethodBeat.i(194608);
    if (com.tencent.thumbplayer.utils.a.isEmpty(paramList))
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayManagerImpl.java]", "clipList is empty, return");
      AppMethodBeat.o(194608);
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
      if ((!(localObject2 instanceof com.tencent.thumbplayer.d.e)) || (!com.tencent.thumbplayer.utils.a.aYG(((com.tencent.thumbplayer.d.e)localObject2).Mxm))) {
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
        AppMethodBeat.o(194608);
        return -1;
      }
      if ((paramArrayList.size() > 0) && (((com.tencent.thumbplayer.b.b.b)paramArrayList.get(0)).MwK) && (!TPDownloadProxyFactory.isReadyForDownload()))
      {
        paramList = a("", e(paramArrayList, 0));
        i = this.MxC.startPlay(paramString, paramList, this.MxF);
        if (i > 0)
        {
          paramList = ((HashMap)localObject1).entrySet().iterator();
          while (paramList.hasNext())
          {
            paramArrayList = (Map.Entry)paramList.next();
            paramString = (com.tencent.thumbplayer.b.a.e)paramArrayList.getKey();
            paramArrayList = (c)paramArrayList.getValue();
            if ((paramString instanceof com.tencent.thumbplayer.d.e)) {
              ((com.tencent.thumbplayer.d.e)paramString).Mxm = this.MxC.getClipPlayUrl(i, paramArrayList.MxV + 1);
            }
          }
          AppMethodBeat.o(194608);
          return i;
        }
      }
      i = this.MxC.startClipPlay(paramString, ((HashMap)localObject1).size(), this.MxF);
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
            Object localObject3 = e(paramArrayList, paramString.MxV);
            if (localObject3 == null)
            {
              com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "fatal err, paramData is null.");
              AppMethodBeat.o(194608);
              return -1;
            }
            com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "multi trackClipIndex:" + paramString.MxV + ", download seq:" + paramString.MxU + ", clip.url:" + ((com.tencent.thumbplayer.d.e)localObject1).getUrl() + ", clip.getFilePath:" + ((com.tencent.thumbplayer.d.e)localObject1).Mxm + ", paramData.savePath:" + ((com.tencent.thumbplayer.b.b.b)localObject3).savePath + ", paramData.DownloadFileID:" + ((com.tencent.thumbplayer.b.b.b)localObject3).Mwm);
            localObject2 = ((com.tencent.thumbplayer.b.b.b)localObject3).Mwm;
            localObject3 = a(((com.tencent.thumbplayer.d.e)localObject1).Mxm, (com.tencent.thumbplayer.b.b.b)localObject3);
            if (this.MxC.setClipInfo(i, paramString.MxU, (String)localObject2, (TPDownloadParam)localObject3)) {
              ((com.tencent.thumbplayer.d.e)localObject1).Mxm = this.MxC.getClipPlayUrl(i, paramString.MxU);
            }
          }
        }
      }
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start clip play failed, cause : playId < 0");
      AppMethodBeat.o(194608);
      return i;
    }
  }
  
  private static TPDownloadParam a(String paramString, com.tencent.thumbplayer.b.b.b paramb)
  {
    AppMethodBeat.i(224170);
    paramString = h.b(paramString, paramb);
    AppMethodBeat.o(224170);
    return paramString;
  }
  
  private String a(long paramLong, String paramString, com.tencent.thumbplayer.b.b.b paramb)
  {
    String str2 = null;
    AppMethodBeat.i(194599);
    if (!com.tencent.thumbplayer.utils.a.aYG(paramString))
    {
      AppMethodBeat.o(194599);
      return paramString;
    }
    if (zL(false))
    {
      AppMethodBeat.o(194599);
      return paramString;
    }
    if (this.MxN == null) {
      this.MxN = new LinkedList();
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
        str2 = paramb.Mwm;
        str1 = paramString;
        int i = this.MxC.startPlay(str2, localTPDownloadParam, this.MxF);
        if (i > 0)
        {
          str1 = paramString;
          paramString = this.MxC.getPlayUrl(i);
          str1 = paramString;
          this.MxN.offer(new b(paramLong, i));
          str1 = paramString;
          com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
          AppMethodBeat.o(194599);
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
    AppMethodBeat.o(194599);
    return paramString;
  }
  
  private void ahV(int paramInt)
  {
    AppMethodBeat.i(194604);
    if (zL(false))
    {
      AppMethodBeat.o(194604);
      return;
    }
    try
    {
      this.MxC.pauseDownload(paramInt);
      AppMethodBeat.o(194604);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pause download failed, taskId:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(194604);
    }
  }
  
  private void ahW(int paramInt)
  {
    AppMethodBeat.i(194606);
    if (zL(false))
    {
      AppMethodBeat.o(194606);
      return;
    }
    try
    {
      this.MxC.resumeDownload(this.MxK);
      AppMethodBeat.o(194606);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy resume download failed, taskId:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(194606);
    }
  }
  
  private void ahX(int paramInt)
  {
    AppMethodBeat.i(194611);
    if (zL(false))
    {
      AppMethodBeat.o(194611);
      return;
    }
    try
    {
      this.MxC.stopPlay(paramInt);
      AppMethodBeat.o(194611);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy stop play failed, taskID:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(194611);
    }
  }
  
  private void ahY(int paramInt)
  {
    AppMethodBeat.i(194612);
    if (zL(false))
    {
      AppMethodBeat.o(194612);
      return;
    }
    try
    {
      this.MxC.pushEvent(paramInt);
      AppMethodBeat.o(194612);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pushEvent failed, event:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(194612);
    }
  }
  
  private static List<com.tencent.thumbplayer.b.a.e> d(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(194607);
    if ((parama instanceof com.tencent.thumbplayer.d.b))
    {
      parama = ((com.tencent.thumbplayer.d.b)parama).Mxe;
      if (!com.tencent.thumbplayer.utils.a.isEmpty(parama))
      {
        parama = (com.tencent.thumbplayer.b.a.d)parama.get(0);
        if ((parama != null) && (!com.tencent.thumbplayer.utils.a.isEmpty(parama.gbd())))
        {
          parama = parama.gbd();
          AppMethodBeat.o(194607);
          return parama;
        }
      }
    }
    else if ((parama instanceof com.tencent.thumbplayer.b.a.d))
    {
      parama = (com.tencent.thumbplayer.b.a.d)parama;
      if (!com.tencent.thumbplayer.utils.a.isEmpty(parama.gbd()))
      {
        parama = parama.gbd();
        AppMethodBeat.o(194607);
        return parama;
      }
    }
    else if ((parama instanceof com.tencent.thumbplayer.b.a.e))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add((com.tencent.thumbplayer.b.a.e)parama);
      AppMethodBeat.o(194607);
      return localArrayList;
    }
    AppMethodBeat.o(194607);
    return null;
  }
  
  private static com.tencent.thumbplayer.b.b.b e(ArrayList<com.tencent.thumbplayer.b.b.b> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(194621);
    if ((com.tencent.thumbplayer.utils.a.isEmpty(paramArrayList)) || (paramInt >= paramArrayList.size()))
    {
      AppMethodBeat.o(194621);
      return null;
    }
    paramArrayList = (com.tencent.thumbplayer.b.b.b)paramArrayList.get(paramInt);
    AppMethodBeat.o(194621);
    return paramArrayList;
  }
  
  private void gbB()
  {
    AppMethodBeat.i(194592);
    if (this.MxD)
    {
      AppMethodBeat.o(194592);
      return;
    }
    if (this.MxE > 0)
    {
      try
      {
        if (this.mServiceType == MxH) {
          this.mServiceType = com.tencent.thumbplayer.e.a.gbu();
        }
        b localb = f.a.gbD().aia(this.mServiceType);
        if ((localb == null) || (localb.gbA() == null)) {
          break label257;
        }
        this.MxC = localb.gbA();
        this.MxC.setUserData("qq_is_vip", Boolean.valueOf(com.tencent.thumbplayer.e.a.gbt()));
        if (!TextUtils.isEmpty(com.tencent.thumbplayer.e.a.gbq())) {
          this.MxC.setUserData("user_uin", com.tencent.thumbplayer.e.a.gbq());
        }
        if (!TextUtils.isEmpty(com.tencent.thumbplayer.e.a.getAppVersionName(this.mContext))) {
          this.MxC.setUserData("app_version_name", com.tencent.thumbplayer.e.a.getAppVersionName(this.mContext));
        }
        if (com.tencent.thumbplayer.e.a.lo(this.mContext) != -1L) {
          this.MxC.setUserData("app_version_code", String.valueOf(com.tencent.thumbplayer.e.a.lo(this.mContext)));
        }
        this.MxC.setUserData("carrier_pesudo_code", com.tencent.thumbplayer.e.a.gbr());
        this.MxC.setUserData("carrier_pesudo_state", Integer.valueOf(com.tencent.thumbplayer.e.a.gbs()));
        this.MxD = true;
        AppMethodBeat.o(194592);
        return;
      }
      catch (Exception localException)
      {
        this.MxE -= 1;
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException);
      }
    }
    else
    {
      AppMethodBeat.o(194592);
      return;
    }
    label257:
    this.MxE -= 1;
    com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p so load failed");
    AppMethodBeat.o(194592);
  }
  
  private void gbC()
  {
    AppMethodBeat.i(194622);
    this.MxC.setUserData("dl_param_play_start_time", Long.valueOf(this.ckm));
    this.MxC.setUserData("dl_param_play_end_time", Long.valueOf(this.MxP));
    AppMethodBeat.o(194622);
  }
  
  private boolean mX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194594);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    paramString1 = new HashMap();
    paramString1.put("dl_param_data_transfer_mode", Integer.valueOf(1));
    paramString1 = new TPDownloadParam(localArrayList, 3, paramString1);
    boolean bool = this.MxC.setClipInfo(this.MxK, 2, paramString2, paramString1);
    AppMethodBeat.o(194594);
    return bool;
  }
  
  private boolean zL(boolean paramBoolean)
  {
    AppMethodBeat.i(194619);
    if (!com.tencent.thumbplayer.e.a.gbm())
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "config set don't use p2p proxy!");
      AppMethodBeat.o(194619);
      return true;
    }
    if (paramBoolean) {
      this.MxE = 3;
    }
    gbB();
    if (!this.MxD)
    {
      AppMethodBeat.o(194619);
      return true;
    }
    AppMethodBeat.o(194619);
    return false;
  }
  
  public final void FC(long paramLong)
  {
    AppMethodBeat.i(194600);
    if (zL(false))
    {
      AppMethodBeat.o(194600);
      return;
    }
    try
    {
      if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MxN))
      {
        for (b localb = (b)this.MxN.peek(); (localb != null) && (localb.MxS != paramLong); localb = (b)this.MxN.peek())
        {
          com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy definitionID:" + localb.MxS + ", taskID:" + localb.MxT);
          ahX(localb.MxT);
          this.MxN.removeFirst();
        }
        if (localb != null)
        {
          com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy task id:" + localb.MxT);
          ahX(this.MxK);
          this.MxK = localb.MxT;
          this.MxN.remove(localb);
        }
      }
      AppMethodBeat.o(194600);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException, "playerSwitchDefComplete exception");
      AppMethodBeat.o(194600);
    }
  }
  
  public final com.tencent.thumbplayer.b.a.a a(com.tencent.thumbplayer.b.a.a parama, long paramLong, p paramp)
  {
    AppMethodBeat.i(194598);
    if ((zL(false)) || (parama == null))
    {
      AppMethodBeat.o(194598);
      return parama;
    }
    if (this.MxN == null) {
      this.MxN = new LinkedList();
    }
    if (paramp == null)
    {
      AppMethodBeat.o(194598);
      return parama;
    }
    if ((parama instanceof com.tencent.thumbplayer.b.a.c)) {
      if (paramp.Mwi == null) {
        break label240;
      }
    }
    label240:
    for (paramp = (com.tencent.thumbplayer.b.b.b)paramp.Mwi.get(0);; paramp = null)
    {
      paramp = a(paramLong, ((com.tencent.thumbplayer.b.a.c)parama).gbb(), paramp);
      ((com.tencent.thumbplayer.b.a.c)parama).bbn(paramp);
      AppMethodBeat.o(194598);
      return parama;
      List localList = d(parama);
      if ((!com.tencent.thumbplayer.utils.a.isEmpty(localList)) && (paramp != null))
      {
        int i = a(localList, paramp.Mwh, paramp.Mwi);
        if (i > 0)
        {
          this.MxN.offer(new b(paramLong, i));
          com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
          AppMethodBeat.o(194598);
          return parama;
        }
        com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch clip def failed, cause : playId < 0");
      }
      AppMethodBeat.o(194598);
      return parama;
    }
  }
  
  public final String a(int paramInt, String paramString, com.tencent.thumbplayer.b.b.b paramb)
  {
    i = 0;
    AppMethodBeat.i(194616);
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is empty");
      AppMethodBeat.o(194616);
      return paramString;
    }
    if (!com.tencent.thumbplayer.utils.a.aYG(paramString))
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is locol url, not need use proxy");
      AppMethodBeat.o(194616);
      return paramString;
    }
    if (zL(false))
    {
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz download proxy init failed");
      AppMethodBeat.o(194616);
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
        paramInt = this.MxC.startPlay(com.tencent.thumbplayer.utils.a.aDz(paramString), paramb, this.MxF);
        if (paramInt <= 0) {
          continue;
        }
        str = paramString;
        paramString = this.MxC.getPlayUrl(paramInt);
        str = paramString;
        this.MxO.put(paramString, Integer.valueOf(paramInt));
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
      AppMethodBeat.o(194616);
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
    AppMethodBeat.i(194597);
    if (paramp == null)
    {
      AppMethodBeat.o(194597);
      return paramString;
    }
    com.tencent.thumbplayer.b.b.b localb = null;
    if (paramp.Mwi != null) {
      localb = (com.tencent.thumbplayer.b.b.b)paramp.Mwi.get(0);
    }
    paramString = a(paramLong, paramString, localb);
    AppMethodBeat.o(194597);
    return paramString;
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(194618);
    if (paramp == null)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, param is null ");
      AppMethodBeat.o(194618);
      return;
    }
    if ((this.MxL != null) && (!zL(false)))
    {
      this.MxL = paramp;
      if ((paramp != null) && (paramp.Mwi != null)) {
        break label117;
      }
      com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayManagerImpl.java]", "video or downloadParamList is null, return");
    }
    for (;;)
    {
      this.MxL = paramp;
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, enter");
      this.MxJ = paramp.Mwh;
      if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MxI)) {
        this.MxI.clear();
      }
      this.MxI = paramp.Mwi;
      AppMethodBeat.o(194618);
      return;
      label117:
      if (this.MxK <= 0)
      {
        com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy not start, return");
      }
      else
      {
        ArrayList localArrayList = paramp.Mwi;
        int i = 0;
        while (i < localArrayList.size())
        {
          com.tencent.thumbplayer.b.b.b localb = (com.tencent.thumbplayer.b.b.b)localArrayList.get(i);
          TPDownloadParam localTPDownloadParam = h.b(localb.url, localb);
          if (!this.MxC.setClipInfo(this.MxK, localb.MwA, localb.Mwm, localTPDownloadParam)) {
            com.tencent.thumbplayer.utils.d.w("TPThumbPlayer[TPPlayManagerImpl.java]", "setClipInfo failed, playID:" + this.MxK + ", clipNo:" + localb.MwA + ", downloadFileID:" + localb.Mwm);
          }
          i += 1;
        }
      }
    }
  }
  
  public final void a(ITPPlayListener paramITPPlayListener)
  {
    this.MxG = paramITPPlayListener;
  }
  
  public final void ahU(int paramInt)
  {
    AppMethodBeat.i(194617);
    com.tencent.thumbplayer.utils.d.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState: ".concat(String.valueOf(paramInt)));
    if (zL(false))
    {
      AppMethodBeat.o(194617);
      return;
    }
    try
    {
      this.MxC.setPlayState(this.MxK, paramInt);
      AppMethodBeat.o(194617);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      AppMethodBeat.o(194617);
    }
  }
  
  public final void b(com.tencent.thumbplayer.b.f paramf)
  {
    AppMethodBeat.i(194615);
    if (zL(false))
    {
      AppMethodBeat.o(194615);
      return;
    }
    if ((paramf != null) && (paramf.key == 100))
    {
      this.ckm = paramf.MvJ.value;
      AppMethodBeat.o(194615);
      return;
    }
    if ((paramf != null) && (paramf.key == 500))
    {
      this.MxP = paramf.MvJ.value;
      if (this.MxK > 0) {
        this.MxC.setUserData("dl_param_play_end_time", Long.valueOf(this.MxP));
      }
    }
    AppMethodBeat.o(194615);
  }
  
  public final String bbp(String paramString)
  {
    AppMethodBeat.i(194593);
    if (!com.tencent.thumbplayer.utils.a.aYG(paramString))
    {
      AppMethodBeat.o(194593);
      return paramString;
    }
    if (zL(true))
    {
      AppMethodBeat.o(194593);
      return paramString;
    }
    gbC();
    this.mOriginUrl = paramString;
    com.tencent.thumbplayer.b.b.b localb = e(this.MxI, 0);
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
      str = localb.Mwm;
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
    this.MxK = this.MxC.startPlay(this.MxJ, (TPDownloadParam)localObject2, this.MxF);
    localObject1 = paramString;
    if (this.MxK > 0)
    {
      localObject1 = paramString;
      localObject2 = this.MxC.getPlayUrl(this.MxK);
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
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "startDownloadPlay, playId:" + this.MxK);
    for (;;)
    {
      AppMethodBeat.o(194593);
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
  
  public final com.tencent.thumbplayer.b.a.a c(com.tencent.thumbplayer.b.a.a parama)
  {
    AppMethodBeat.i(194602);
    if (zL(true))
    {
      AppMethodBeat.o(194602);
      return parama;
    }
    gbC();
    if ((parama instanceof g))
    {
      localObject = bbp(((g)parama).mPlayUrl);
      ((g)parama).mPlayUrl = ((String)localObject);
      AppMethodBeat.o(194602);
      return parama;
    }
    Object localObject = d(parama);
    if (!com.tencent.thumbplayer.utils.a.isEmpty((Collection)localObject)) {
      this.MxK = a((List)localObject, this.MxJ, this.MxI);
    }
    AppMethodBeat.o(194602);
    return parama;
  }
  
  public final void gaT()
  {
    AppMethodBeat.i(194605);
    ahW(this.MxK);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MxN))
    {
      localIterator = this.MxN.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          ahW(localb.MxT);
        }
      }
    }
    if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MxO))
    {
      localIterator = this.MxO.values().iterator();
      while (localIterator.hasNext()) {
        ahW(((Integer)localIterator.next()).intValue());
      }
    }
    AppMethodBeat.o(194605);
  }
  
  public final void gbw()
  {
    AppMethodBeat.i(194596);
    if (this.MxQ)
    {
      ahX(this.MxK);
      bbp(this.mOriginUrl);
    }
    this.MxQ = false;
    AppMethodBeat.o(194596);
  }
  
  public final boolean gbx()
  {
    AppMethodBeat.i(194601);
    if (zL(false))
    {
      AppMethodBeat.o(194601);
      return false;
    }
    if ((this.MxN != null) && (this.MxN.size() > 0))
    {
      AppMethodBeat.o(194601);
      return true;
    }
    AppMethodBeat.o(194601);
    return false;
  }
  
  public final String gby()
  {
    AppMethodBeat.i(194614);
    if (zL(false))
    {
      AppMethodBeat.o(194614);
      return null;
    }
    try
    {
      String str = this.MxC.getPlayErrorCodeStr(this.MxK);
      AppMethodBeat.o(194614);
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.thumbplayer.utils.d.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      AppMethodBeat.o(194614);
    }
    return null;
  }
  
  public final com.tencent.thumbplayer.b.b.a gbz()
  {
    return this.MxM;
  }
  
  public final boolean isEnable()
  {
    AppMethodBeat.i(194613);
    if (!zL(false))
    {
      AppMethodBeat.o(194613);
      return true;
    }
    AppMethodBeat.o(194613);
    return false;
  }
  
  public final void la(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194623);
    com.tencent.thumbplayer.utils.d.d("TPThumbPlayer[TPPlayManagerImpl.java]", "onNetworkStatusChanged oldNetStatus: " + paramInt1 + ", netStatus: " + paramInt2);
    if (paramInt2 == 1)
    {
      ahY(1);
      ahY(10);
      AppMethodBeat.o(194623);
      return;
    }
    if (paramInt2 == 2)
    {
      ahY(2);
      ahY(9);
      AppMethodBeat.o(194623);
      return;
    }
    if (paramInt2 == 3)
    {
      ahY(2);
      ahY(10);
    }
    AppMethodBeat.o(194623);
  }
  
  public final void mW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194595);
    if ((!com.tencent.thumbplayer.utils.a.aYG(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramString1 = new Exception("illegal argument.");
      AppMethodBeat.o(194595);
      throw paramString1;
    }
    if (!this.MxQ)
    {
      if (!mX(paramString1, paramString2))
      {
        paramString1 = new Exception("setClipInfo err.");
        AppMethodBeat.o(194595);
        throw paramString1;
      }
    }
    else
    {
      ahX(this.MxK);
      bbp(this.mOriginUrl);
      if (!mX(paramString1, paramString2))
      {
        paramString1 = new Exception("setClipInfo err.");
        AppMethodBeat.o(194595);
        throw paramString1;
      }
    }
    this.MxQ = true;
    AppMethodBeat.o(194595);
  }
  
  public final void pauseDownload()
  {
    AppMethodBeat.i(194603);
    ahV(this.MxK);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MxN))
    {
      localIterator = this.MxN.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          ahV(localb.MxT);
        }
      }
    }
    if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MxO))
    {
      localIterator = this.MxO.values().iterator();
      while (localIterator.hasNext()) {
        ahV(((Integer)localIterator.next()).intValue());
      }
    }
    AppMethodBeat.o(194603);
  }
  
  public final void release()
  {
    AppMethodBeat.i(194610);
    stopDownload();
    TPNetworkChangeMonitor.gcg().b(this);
    b.a.gcf().b(this);
    this.MxM = null;
    this.MxG = new d("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.MxF = null;
    this.MxC = null;
    AppMethodBeat.o(194610);
  }
  
  public final void stopDownload()
  {
    AppMethodBeat.i(194609);
    if (this.MxK < 0)
    {
      com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload failed, coz playId:" + this.MxK + ", less than zero. maybe download proxy didn't started");
      AppMethodBeat.o(194609);
      return;
    }
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload, playId:" + this.MxK);
    ahX(this.MxK);
    Iterator localIterator;
    if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MxN))
    {
      localIterator = this.MxN.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          ahX(localb.MxT);
        }
      }
      this.MxN.clear();
    }
    if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MxO))
    {
      localIterator = this.MxO.values().iterator();
      while (localIterator.hasNext()) {
        ahX(((Integer)localIterator.next()).intValue());
      }
      this.MxO.clear();
    }
    this.MxK = -1;
    com.tencent.thumbplayer.utils.d.i("TPThumbPlayer[TPPlayManagerImpl.java]", "reset");
    this.MxJ = "";
    this.mOriginUrl = "";
    this.MxL = null;
    this.ckm = 0L;
    this.MxP = 0L;
    if (!com.tencent.thumbplayer.utils.a.isEmpty(this.MxI)) {
      this.MxI.clear();
    }
    AppMethodBeat.o(194609);
  }
  
  final class a
    implements ITPPlayListener
  {
    private a() {}
    
    public final long getAdvRemainTime()
    {
      AppMethodBeat.i(194582);
      long l = c.a(c.this).getAdvRemainTime();
      AppMethodBeat.o(194582);
      return l;
    }
    
    public final String getContentType(long paramLong, String paramString)
    {
      AppMethodBeat.i(194590);
      paramString = c.a(c.this).getContentType(paramLong, paramString);
      AppMethodBeat.o(194590);
      return paramString;
    }
    
    public final int getCurrentPlayClipNo()
    {
      AppMethodBeat.i(194581);
      int i = c.a(c.this).getCurrentPlayClipNo();
      AppMethodBeat.o(194581);
      return i;
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(194580);
      long l = c.a(c.this).getCurrentPosition();
      AppMethodBeat.o(194580);
      return l;
    }
    
    public final String getDataFilePath(long paramLong, String paramString)
    {
      AppMethodBeat.i(194589);
      paramString = c.a(c.this).getDataFilePath(paramLong, paramString);
      AppMethodBeat.o(194589);
      return paramString;
    }
    
    public final long getDataTotalSize(long paramLong, String paramString)
    {
      AppMethodBeat.i(194588);
      paramLong = c.a(c.this).getDataTotalSize(paramLong, paramString);
      AppMethodBeat.o(194588);
      return paramLong;
    }
    
    public final Object getPlayInfo(long paramLong)
    {
      AppMethodBeat.i(194583);
      Object localObject = c.a(c.this).getPlayInfo(paramLong);
      AppMethodBeat.o(194583);
      return localObject;
    }
    
    public final Object getPlayInfo(String paramString)
    {
      AppMethodBeat.i(194584);
      paramString = c.a(c.this).getPlayInfo(paramString);
      AppMethodBeat.o(194584);
      return paramString;
    }
    
    public final long getPlayerBufferLength()
    {
      AppMethodBeat.i(194579);
      long l = c.a(c.this).getPlayerBufferLength();
      AppMethodBeat.o(194579);
      return l;
    }
    
    public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
    {
      AppMethodBeat.i(194577);
      c.a(c.this).onDownloadCdnUrlExpired(paramMap);
      AppMethodBeat.o(194577);
    }
    
    public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(194574);
      c.a(c.this).onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(194574);
    }
    
    public final void onDownloadCdnUrlUpdate(String paramString)
    {
      AppMethodBeat.i(194573);
      c.a(c.this).onDownloadCdnUrlUpdate(paramString);
      AppMethodBeat.o(194573);
    }
    
    public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(194572);
      c.a(c.this).onDownloadError(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(194572);
    }
    
    public final void onDownloadFinish()
    {
      AppMethodBeat.i(194571);
      c.a(c.this).onDownloadFinish();
      AppMethodBeat.o(194571);
    }
    
    public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(194570);
      c.a(c.this).onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
      AppMethodBeat.o(194570);
    }
    
    public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
    {
      AppMethodBeat.i(194576);
      c.a(c.this).onDownloadProtocolUpdate(paramString1, paramString2);
      AppMethodBeat.o(194576);
    }
    
    public final void onDownloadStatusUpdate(int paramInt)
    {
      AppMethodBeat.i(194575);
      c.a(c.this).onDownloadStatusUpdate(paramInt);
      AppMethodBeat.o(194575);
    }
    
    public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      AppMethodBeat.i(194578);
      paramObject1 = c.a(c.this).onPlayCallback(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
      AppMethodBeat.o(194578);
      return paramObject1;
    }
    
    public final int onReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194586);
      int i = c.a(c.this).onReadData(paramLong1, paramString, paramLong2, paramLong3);
      AppMethodBeat.o(194586);
      return i;
    }
    
    public final int onStartReadData(long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(194585);
      int i = c.a(c.this).onStartReadData(paramLong1, paramString, paramLong2, paramLong3);
      AppMethodBeat.o(194585);
      return i;
    }
    
    public final int onStopReadData(long paramLong, String paramString)
    {
      AppMethodBeat.i(194587);
      int i = c.a(c.this).onStopReadData(paramLong, paramString);
      AppMethodBeat.o(194587);
      return i;
    }
  }
  
  static final class b
  {
    long MxS;
    int MxT;
    
    b(long paramLong, int paramInt)
    {
      this.MxS = paramLong;
      this.MxT = paramInt;
    }
  }
  
  static final class c
  {
    int MxU;
    int MxV;
    
    c(int paramInt1, int paramInt2)
    {
      this.MxU = paramInt1;
      this.MxV = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.f.c
 * JD-Core Version:    0.7.0.1
 */