package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.i.a;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bbl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class al
  implements com.tencent.mm.ai.f
{
  private g.a fFy;
  public CopyOnWriteArraySet<d.b> uWf;
  private CopyOnWriteArraySet<d.a> uWg;
  
  public al()
  {
    AppMethodBeat.i(6700);
    this.uWg = new CopyOnWriteArraySet();
    this.uWf = new CopyOnWriteArraySet();
    this.fFy = new al.1(this);
    AppMethodBeat.o(6700);
  }
  
  public static boolean ahd(String paramString)
  {
    AppMethodBeat.i(6711);
    ab.i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", new Object[] { paramString });
    boolean bool = com.tencent.mm.al.f.afO().sJ(paramString);
    AppMethodBeat.o(6711);
    return bool;
  }
  
  private void c(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      AppMethodBeat.i(153135);
      ab.d("MicroMsg.WebviewFileChooserCdnService", "notifyRequstCallback, localId : %s", new Object[] { paramString1 });
      if ((this.uWf != null) && (this.uWf.size() > 0))
      {
        Iterator localIterator = this.uWf.iterator();
        while (localIterator.hasNext()) {
          ((d.b)localIterator.next()).b(paramBoolean, paramInt, paramString1, paramString2, paramString3, paramString4);
        }
      }
      AppMethodBeat.o(153135);
    }
    finally {}
  }
  
  private void hq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(153136);
    com.tencent.mm.kernel.g.Rc().a(1035, this);
    paramString1 = new k(paramString1, paramString2);
    com.tencent.mm.kernel.g.Rc().a(paramString1, 0);
    AppMethodBeat.o(153136);
  }
  
  public static boolean zE(String paramString)
  {
    AppMethodBeat.i(6710);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.dcE().ahh(paramString);
    if (localWebViewJSSDKFileItem == null)
    {
      ab.e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString });
      AppMethodBeat.o(6710);
      return false;
    }
    boolean bool = com.tencent.mm.al.f.afO().sI(localWebViewJSSDKFileItem.cBO);
    AppMethodBeat.o(6710);
    return bool;
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(6701);
    if ((this.uWg != null) && (parama != null) && (!this.uWg.contains(parama))) {
      this.uWg.add(parama);
    }
    AppMethodBeat.o(6701);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(6702);
    if ((this.uWf != null) && (paramb != null)) {
      this.uWf.remove(paramb);
    }
    AppMethodBeat.o(6702);
  }
  
  public final boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, d.b paramb)
  {
    AppMethodBeat.i(6708);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.dcE().ahh(paramString2);
    if (localWebViewJSSDKFileItem == null)
    {
      ab.e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString2 });
      AppMethodBeat.o(6708);
      return false;
    }
    localWebViewJSSDKFileItem.appId = paramString1;
    if (paramb != null) {
      this.uWf.add(paramb);
    }
    if ((paramInt2 == 202) || (paramInt2 == 214) || (paramInt2 == 215)) {
      localWebViewJSSDKFileItem.hgo = false;
    }
    localWebViewJSSDKFileItem.hgm = true;
    paramString1 = new com.tencent.mm.i.g();
    paramString1.edp = this.fFy;
    paramString1.cMU = true;
    paramString1.field_mediaId = localWebViewJSSDKFileItem.cBO;
    paramString1.field_fullpath = localWebViewJSSDKFileItem.hgj;
    paramString1.field_fileType = paramInt1;
    paramString1.field_talker = "weixin";
    paramString1.field_priority = a.ecF;
    if (paramInt1 == a.ecK) {}
    for (paramString1.field_needStorage = true;; paramString1.field_needStorage = false)
    {
      paramString1.field_isStreamMedia = false;
      paramString1.field_appType = paramInt2;
      paramString1.field_bzScene = paramInt3;
      paramString1.field_force_aeskeycdn = true;
      paramString1.field_trysafecdn = false;
      paramString1.field_thumbpath = localWebViewJSSDKFileItem.hII;
      boolean bool = com.tencent.mm.al.f.afO().e(paramString1);
      ab.i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramString1.field_force_aeskeycdn), Boolean.valueOf(paramString1.field_trysafecdn), paramString2 });
      AppMethodBeat.o(6708);
      return bool;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, d.b paramb)
  {
    AppMethodBeat.i(6706);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.dcE().ahi(paramString2);
    if (localWebViewJSSDKFileItem != null)
    {
      localWebViewJSSDKFileItem.appId = paramString1;
      ab.i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", new Object[] { paramString1, paramString2, localWebViewJSSDKFileItem.ctV });
      paramb.b(true, 0, localWebViewJSSDKFileItem.ctV, localWebViewJSSDKFileItem.hgk, null, null);
      AppMethodBeat.o(6706);
      return true;
    }
    hq(paramString1, paramString2);
    this.uWf.add(paramb);
    AppMethodBeat.o(6706);
    return true;
  }
  
  public final void b(d.a parama)
  {
    AppMethodBeat.i(6703);
    if ((this.uWg != null) && (parama != null)) {
      this.uWg.remove(parama);
    }
    AppMethodBeat.o(6703);
  }
  
  final void b(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(6705);
      ab.i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
      if ((this.uWg != null) && (this.uWg.size() > 0))
      {
        Iterator localIterator = this.uWg.iterator();
        while (localIterator.hasNext()) {
          ((d.a)localIterator.next()).a(paramBoolean, paramInt1, paramInt2, paramString1, paramString2);
        }
      }
      AppMethodBeat.o(6705);
    }
    finally {}
  }
  
  public final boolean b(String paramString1, String paramString2, d.b paramb)
  {
    AppMethodBeat.i(6709);
    boolean bool = a(paramString1, paramString2, a.MediaType_FILE, 0, 0, paramb);
    AppMethodBeat.o(6709);
    return bool;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(6712);
    ab.i("MicroMsg.WebviewFileChooserCdnService", "onSceneEnd, errType = %d, errCode = %d, funcType = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.getType()) });
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(6712);
      return;
      com.tencent.mm.kernel.g.Rc().b(1034, this);
      Object localObject1 = (af)paramm;
      paramString = ((bbl)((af)localObject1).rr.fsW.fta).xqG;
      paramm = ((af)localObject1).appId;
      localObject1 = ((af)localObject1).ctV;
      Object localObject2 = com.tencent.mm.plugin.webview.modeltools.g.dcE().ahh((String)localObject1);
      if (localObject2 == null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.i("MicroMsg.WebviewFileChooserCdnService", "get server server id : %s from server for appid : %s, localId = %s, item == null ? %b", new Object[] { paramString, paramm, localObject1, Boolean.valueOf(bool) });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label274;
        }
        if ((bo.isNullOrNil(paramm)) || (bo.isNullOrNil(paramString)) || (localObject2 == null)) {
          break;
        }
        ((WebViewJSSDKFileItem)localObject2).hgk = paramString;
        b(true, ((WebViewJSSDKFileItem)localObject2).cth, 100, ((WebViewJSSDKFileItem)localObject2).ctV, ((WebViewJSSDKFileItem)localObject2).hgk);
        c(true, 0, ((WebViewJSSDKFileItem)localObject2).ctV, ((WebViewJSSDKFileItem)localObject2).hgk, ((WebViewJSSDKFileItem)localObject2).uWl.field_fileUrl, null);
        AppMethodBeat.o(6712);
        return;
      }
      label274:
      ab.e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
      if (localObject2 != null)
      {
        c(false, 0, ((WebViewJSSDKFileItem)localObject2).ctV, ((WebViewJSSDKFileItem)localObject2).cBO, null, null);
        AppMethodBeat.o(6712);
        return;
        com.tencent.mm.kernel.g.Rc().b(1035, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (k)paramm;
          paramm = paramString.appId;
          localObject1 = paramString.hgk;
          localObject2 = ((bbh)paramString.rr.fsW.fta).xqH;
          if (localObject2 == null)
          {
            bool = true;
            ab.i("MicroMsg.WebviewFileChooserCdnService", "appid = %s, serverId = %s, cdninfo == null ? %b", new Object[] { paramm, localObject1, Boolean.valueOf(bool) });
            if ((!bo.isNullOrNil(paramm)) && (!bo.isNullOrNil((String)localObject1)) && (localObject2 != null))
            {
              paramString = ((bbf)localObject2).type;
              ab.i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", new Object[] { paramString });
              if (!bo.isNullOrNil(paramString))
              {
                if (!paramString.toLowerCase().equals("voice")) {
                  break label704;
                }
                paramString = WebViewJSSDKFileItem.ahg(ar.ahr(paramm));
                label476:
                paramString.hgm = false;
                paramString.appId = paramm;
                paramString.hgk = ((String)localObject1);
                if (paramString.uWl == null) {
                  paramString.uWl = new WebViewJSSDKFileItem.a();
                }
                if (localObject2 != null) {
                  break label769;
                }
                ab.e("MicroMsg.WebViewJSSDKFileItem", "jsapidcdn info is null");
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.webview.modeltools.g.dcE().a(paramString);
            paramm = new com.tencent.mm.i.g();
            paramm.edp = this.fFy;
            paramm.cMU = false;
            paramm.field_mediaId = paramString.cBO;
            paramm.field_fullpath = paramString.hgj;
            paramm.field_totalLen = paramString.uWl.field_fileLength;
            paramm.field_fileType = a.MediaType_FILE;
            paramm.field_fileId = paramString.uWl.field_fileId;
            paramm.field_aesKey = paramString.uWl.field_aesKey;
            paramm.field_priority = a.ecF;
            paramm.field_needStorage = false;
            paramm.field_isStreamMedia = false;
            bool = com.tencent.mm.al.f.afO().b(paramm, -1);
            ab.i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", new Object[] { Boolean.valueOf(bool), paramString.hgk });
            if (!bool) {
              c(false, 0, null, null, null, null);
            }
            AppMethodBeat.o(6712);
            return;
            bool = false;
            break;
            label704:
            if (paramString.toLowerCase().equals("video"))
            {
              paramString = WebViewJSSDKFileItem.ahu(ar.ahk(bo.aoy()));
              break label476;
            }
            paramString = WebViewJSSDKFileItem.ahf(ar.ahk(bo.aoy()));
            break label476;
            label769:
            paramString.uWl.field_aesKey = ((bbf)localObject2).xbD;
            paramString.uWl.field_fileId = ((bbf)localObject2).xqE;
            paramString.uWl.field_fileLength = ((bbf)localObject2).wJh;
          }
        }
        ab.e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
        c(false, 0, null, null, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.al
 * JD-Core Version:    0.7.0.1
 */