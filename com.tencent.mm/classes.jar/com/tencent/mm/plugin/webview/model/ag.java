package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.j.a;
import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.protocal.c.auv;
import com.tencent.mm.protocal.c.aux;
import com.tencent.mm.protocal.c.avb;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ag
  implements com.tencent.mm.ah.f
{
  private f.a epa = new f.a()
  {
    public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
    {
      Object localObject1;
      Object localObject2;
      if (paramAnonymousc == null)
      {
        localObject1 = "null";
        if (paramAnonymousd != null) {
          break label102;
        }
        localObject2 = "null";
        label17:
        y.i("MicroMsg.WebviewFileChooserCdnService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), localObject1, localObject2 });
        localObject1 = g.ccL();
        if (!bk.bl(paramAnonymousString)) {
          break label112;
        }
        y.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByMediaID error, media id is null or nil");
        label67:
        break label127;
        label68:
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 != null) {
          break label167;
        }
        y.e("MicroMsg.WebviewFileChooserCdnService", "get item by media id failed, media is : %s", new Object[] { paramAnonymousString });
        return 0;
        localObject1 = paramAnonymousc.toString();
        break;
        label102:
        localObject2 = paramAnonymousd.toString();
        break label17;
        label112:
        localObject2 = ((ah)localObject1).rfX.values().iterator();
        label127:
        if (!((Iterator)localObject2).hasNext()) {
          break label68;
        }
        localObject1 = (WebViewJSSDKFileItem)((Iterator)localObject2).next();
        if (!bk.pm(((WebViewJSSDKFileItem)localObject1).bUi).equals(paramAnonymousString)) {
          break label67;
        }
      }
      label167:
      if (paramAnonymousInt == -21005)
      {
        y.i("MicroMsg.WebviewFileChooserCdnService", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
        return 0;
      }
      if (paramAnonymousInt != 0)
      {
        y.e("MicroMsg.WebviewFileChooserCdnService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        ag.a(ag.this, false, ((WebViewJSSDKFileItem)localObject1).bMB, ((WebViewJSSDKFileItem)localObject1).bUi, null);
        return 0;
      }
      if (paramAnonymousc != null)
      {
        y.i("MicroMsg.WebviewFileChooserCdnService", "progressInfo : %s", new Object[] { paramAnonymousc.toString() });
        paramAnonymousInt = 0;
        if (paramAnonymousc.field_toltalLength > 0) {
          paramAnonymousInt = paramAnonymousc.field_finishedLength * 100 / paramAnonymousc.field_toltalLength;
        }
        int i;
        if (paramAnonymousInt < 0) {
          i = 0;
        }
        for (;;)
        {
          ag.this.b(((WebViewJSSDKFileItem)localObject1).fNc, ((WebViewJSSDKFileItem)localObject1).bLN, i, ((WebViewJSSDKFileItem)localObject1).bMB, ((WebViewJSSDKFileItem)localObject1).bUi);
          return 0;
          i = paramAnonymousInt;
          if (paramAnonymousInt > 100) {
            i = 100;
          }
        }
      }
      if (paramAnonymousd != null)
      {
        if (paramAnonymousd.field_retCode == 0) {
          break label401;
        }
        y.e("MicroMsg.WebviewFileChooserCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
        ag.a(ag.this, false, ((WebViewJSSDKFileItem)localObject1).bMB, ((WebViewJSSDKFileItem)localObject1).bUi, null);
      }
      for (;;)
      {
        return 0;
        label401:
        y.i("MicroMsg.WebviewFileChooserCdnService", "cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
        if (localObject1 != null)
        {
          ((WebViewJSSDKFileItem)localObject1).c(paramAnonymousd);
          if ((((WebViewJSSDKFileItem)localObject1).fNc) && (((WebViewJSSDKFileItem)localObject1).fNe))
          {
            paramAnonymousString = ag.this;
            if (localObject1 == null)
            {
              y.e("MicroMsg.WebviewFileChooserCdnService", "uploadCdnInfo failed, item is null");
            }
            else
            {
              paramAnonymousc = new auv();
              paramAnonymousc.tdF = ((WebViewJSSDKFileItem)localObject1).rfV.field_aesKey;
              paramAnonymousc.sLt = ((WebViewJSSDKFileItem)localObject1).rfV.field_fileLength;
              paramAnonymousc.tqE = ((WebViewJSSDKFileItem)localObject1).rfV.field_fileId;
              paramAnonymousc.type = ((WebViewJSSDKFileItem)localObject1).cbV();
              y.d("MicroMsg.WebviewFileChooserCdnService", "appId:%s, localId:%s, aes_key:%s， file_size:%d, fileId:%s", new Object[] { ((WebViewJSSDKFileItem)localObject1).appId, ((WebViewJSSDKFileItem)localObject1).bMB, paramAnonymousc.tdF, Integer.valueOf(paramAnonymousc.sLt), paramAnonymousc.tqE });
              paramAnonymousc.tqF = ((WebViewJSSDKFileItem)localObject1).cbU();
              au.Dk().a(1034, paramAnonymousString);
              paramAnonymousString = new aa(((WebViewJSSDKFileItem)localObject1).appId, ((WebViewJSSDKFileItem)localObject1).bMB, paramAnonymousc);
              au.Dk().a(paramAnonymousString, 0);
            }
          }
          else
          {
            ag.a(ag.this, true, ((WebViewJSSDKFileItem)localObject1).bMB, ((WebViewJSSDKFileItem)localObject1).fNa, ((WebViewJSSDKFileItem)localObject1).rfV.field_fileUrl);
          }
        }
      }
    }
    
    public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
    {
      y.i("MicroMsg.WebviewFileChooserCdnService", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
    }
    
    public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
    {
      y.i("MicroMsg.WebviewFileChooserCdnService", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
      return null;
    }
  };
  private CopyOnWriteArraySet<d.b> rfS = new CopyOnWriteArraySet();
  private CopyOnWriteArraySet<d.a> rfT = new CopyOnWriteArraySet();
  
  public static boolean Sh(String paramString)
  {
    y.i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", new Object[] { paramString });
    return com.tencent.mm.ak.f.Nd().lM(paramString);
  }
  
  private void a(WebViewJSSDKFileItem paramWebViewJSSDKFileItem)
  {
    com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
    localf.dlP = this.epa;
    localf.ceg = false;
    localf.field_mediaId = paramWebViewJSSDKFileItem.bUi;
    localf.field_fullpath = paramWebViewJSSDKFileItem.fMZ;
    localf.field_totalLen = paramWebViewJSSDKFileItem.rfV.field_fileLength;
    localf.field_fileType = a.MediaType_FILE;
    localf.field_fileId = paramWebViewJSSDKFileItem.rfV.field_fileId;
    localf.field_aesKey = paramWebViewJSSDKFileItem.rfV.field_aesKey;
    localf.field_priority = a.dlk;
    localf.field_needStorage = false;
    localf.field_isStreamMedia = false;
    boolean bool = com.tencent.mm.ak.f.Nd().b(localf, -1);
    y.i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", new Object[] { Boolean.valueOf(bool), paramWebViewJSSDKFileItem.fNa });
    if (!bool) {
      c(false, null, null, null);
    }
  }
  
  private void c(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if ((this.rfS != null) && (this.rfS.size() > 0))
    {
      Iterator localIterator = this.rfS.iterator();
      while (localIterator.hasNext()) {
        ((d.b)localIterator.next()).b(paramBoolean, paramString1, paramString2, paramString3);
      }
    }
  }
  
  public static boolean rO(String paramString)
  {
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.ccL().Sl(paramString);
    if (localWebViewJSSDKFileItem == null)
    {
      y.e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString });
      return false;
    }
    return com.tencent.mm.ak.f.Nd().lL(localWebViewJSSDKFileItem.bUi);
  }
  
  public final void a(d.a parama)
  {
    if ((this.rfT != null) && (parama != null) && (!this.rfT.contains(parama))) {
      this.rfT.add(parama);
    }
  }
  
  public final void a(d.b paramb)
  {
    if ((this.rfS != null) && (paramb != null)) {
      this.rfS.remove(paramb);
    }
  }
  
  public final boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, d.b paramb)
  {
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.ccL().Sl(paramString2);
    if (localWebViewJSSDKFileItem == null)
    {
      y.e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString2 });
      return false;
    }
    localWebViewJSSDKFileItem.appId = paramString1;
    if (paramb != null) {
      this.rfS.add(paramb);
    }
    if (paramInt2 == 202) {
      localWebViewJSSDKFileItem.fNe = false;
    }
    localWebViewJSSDKFileItem.fNc = true;
    paramString1 = new com.tencent.mm.j.f();
    paramString1.dlP = this.epa;
    paramString1.ceg = true;
    paramString1.field_mediaId = localWebViewJSSDKFileItem.bUi;
    paramString1.field_fullpath = localWebViewJSSDKFileItem.fMZ;
    paramString1.field_fileType = paramInt1;
    paramString1.field_talker = "weixin";
    paramString1.field_priority = a.dlk;
    if (paramInt1 == a.dlp) {}
    for (paramString1.field_needStorage = true;; paramString1.field_needStorage = false)
    {
      paramString1.field_isStreamMedia = false;
      paramString1.field_appType = paramInt2;
      paramString1.field_bzScene = paramInt3;
      paramString1.field_force_aeskeycdn = true;
      paramString1.field_trysafecdn = false;
      boolean bool = com.tencent.mm.ak.f.Nd().c(paramString1);
      y.i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramString1.field_force_aeskeycdn), Boolean.valueOf(paramString1.field_trysafecdn), paramString2 });
      return bool;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, d.b paramb)
  {
    Object localObject = g.ccL();
    if (bk.bl(paramString2))
    {
      y.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByServerId error, media id is null or nil");
      break label95;
      label19:
      localObject = null;
    }
    for (;;)
    {
      if (localObject == null) {
        break label135;
      }
      ((WebViewJSSDKFileItem)localObject).appId = paramString1;
      y.i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", new Object[] { paramString1, paramString2, ((WebViewJSSDKFileItem)localObject).bMB });
      paramb.b(true, ((WebViewJSSDKFileItem)localObject).bMB, ((WebViewJSSDKFileItem)localObject).fNa, null);
      return true;
      Iterator localIterator = ((ah)localObject).rfX.values().iterator();
      label95:
      if (!localIterator.hasNext()) {
        break label19;
      }
      localObject = (WebViewJSSDKFileItem)localIterator.next();
      if (!bk.pm(((WebViewJSSDKFileItem)localObject).fNa).equals(paramString2)) {
        break;
      }
    }
    label135:
    au.Dk().a(1035, this);
    paramString1 = new i(paramString1, paramString2);
    au.Dk().a(paramString1, 0);
    this.rfS.add(paramb);
    return true;
  }
  
  public final void b(d.a parama)
  {
    if ((this.rfT != null) && (parama != null)) {
      this.rfT.remove(parama);
    }
  }
  
  final void b(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    y.i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
    if ((this.rfT != null) && (this.rfT.size() > 0))
    {
      Iterator localIterator = this.rfT.iterator();
      while (localIterator.hasNext()) {
        ((d.a)localIterator.next()).a(paramBoolean, paramInt1, paramInt2, paramString1, paramString2);
      }
    }
  }
  
  public final boolean b(String paramString1, String paramString2, d.b paramb)
  {
    return a(paramString1, paramString2, a.MediaType_FILE, 0, 0, paramb);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.WebviewFileChooserCdnService", "onSceneEnd, errType = %d, errCode = %d, funcType = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.getType()) });
    switch (paramm.getType())
    {
    }
    Object localObject1;
    Object localObject2;
    boolean bool;
    label252:
    do
    {
      do
      {
        do
        {
          return;
          au.Dk().b(1034, this);
          localObject1 = (aa)paramm;
          paramString = ((avb)((aa)localObject1).dmK.ecF.ecN).tqG;
          paramm = ((aa)localObject1).appId;
          localObject1 = ((aa)localObject1).bMB;
          localObject2 = g.ccL().Sl((String)localObject1);
          if (localObject2 == null) {}
          for (bool = true;; bool = false)
          {
            y.i("MicroMsg.WebviewFileChooserCdnService", "get server server id : %s from server for appid : %s, localId = %s, item == null ? %b", new Object[] { paramString, paramm, localObject1, Boolean.valueOf(bool) });
            if ((paramInt1 != 0) || (paramInt2 != 0)) {
              break label252;
            }
            if ((bk.bl(paramm)) || (bk.bl(paramString)) || (localObject2 == null)) {
              break;
            }
            ((WebViewJSSDKFileItem)localObject2).fNa = paramString;
            b(true, ((WebViewJSSDKFileItem)localObject2).bLN, 100, ((WebViewJSSDKFileItem)localObject2).bMB, ((WebViewJSSDKFileItem)localObject2).fNa);
            c(true, ((WebViewJSSDKFileItem)localObject2).bMB, ((WebViewJSSDKFileItem)localObject2).fNa, ((WebViewJSSDKFileItem)localObject2).rfV.field_fileUrl);
            return;
          }
          y.e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
        } while (localObject2 == null);
        c(false, ((WebViewJSSDKFileItem)localObject2).bMB, ((WebViewJSSDKFileItem)localObject2).bUi, null);
        return;
        au.Dk().b(1035, this);
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label618;
        }
        paramString = (i)paramm;
        paramm = paramString.appId;
        localObject1 = paramString.fNa;
        localObject2 = ((aux)paramString.dmK.ecF.ecN).tqH;
        if (localObject2 != null) {
          break;
        }
        bool = true;
        y.i("MicroMsg.WebviewFileChooserCdnService", "appid = %s, serverId = %s, cdninfo == null ? %b", new Object[] { paramm, localObject1, Boolean.valueOf(bool) });
      } while ((bk.bl(paramm)) || (bk.bl((String)localObject1)) || (localObject2 == null));
      paramString = ((auv)localObject2).type;
      y.i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", new Object[] { paramString });
    } while (bk.bl(paramString));
    if (paramString.toLowerCase().equals("voice"))
    {
      paramString = WebViewJSSDKFileItem.Sj(am.Ss(paramm));
      label446:
      paramString.fNc = false;
      paramString.appId = paramm;
      paramString.fNa = ((String)localObject1);
      if (paramString.rfV == null) {
        paramString.rfV = new WebViewJSSDKFileItem.a();
      }
      if (localObject2 != null) {
        break label579;
      }
      y.e("MicroMsg.WebViewJSSDKFileItem", "jsapidcdn info is null");
    }
    for (;;)
    {
      g.ccL().b(paramString);
      a(paramString);
      return;
      bool = false;
      break;
      if (paramString.toLowerCase().equals("video"))
      {
        paramString = WebViewJSSDKFileItem.Sk(am.Sm(bk.UY()));
        break label446;
      }
      paramString = WebViewJSSDKFileItem.Si(am.Sm(bk.UY()));
      break label446;
      label579:
      paramString.rfV.field_aesKey = ((auv)localObject2).tdF;
      paramString.rfV.field_fileId = ((auv)localObject2).tqE;
      paramString.rfV.field_fileLength = ((auv)localObject2).sLt;
    }
    label618:
    y.e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
    c(false, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ag
 * JD-Core Version:    0.7.0.1
 */