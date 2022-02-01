package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.ao.f;
import com.tencent.mm.i.a;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.protocal.protobuf.bng;
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class am
  implements com.tencent.mm.al.g
{
  private CopyOnWriteArraySet<f.b> AYr;
  private CopyOnWriteArraySet<f.a> AYs;
  private g.a hhW;
  
  public am()
  {
    AppMethodBeat.i(78990);
    this.AYs = new CopyOnWriteArraySet();
    this.AYr = new CopyOnWriteArraySet();
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(78989);
        Object localObject1;
        Object localObject2;
        if (paramAnonymousc == null)
        {
          localObject1 = "null";
          if (paramAnonymousd != null) {
            break label112;
          }
          localObject2 = "null";
          label22:
          ad.i("MicroMsg.WebviewFileChooserCdnService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), localObject1, localObject2 });
          localObject1 = com.tencent.mm.plugin.webview.modeltools.g.emF();
          if (!bt.isNullOrNil(paramAnonymousString)) {
            break label122;
          }
          ad.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByMediaID error, media id is null or nil");
          label72:
          break label137;
          label73:
          localObject1 = null;
        }
        for (;;)
        {
          if (localObject1 != null) {
            break label177;
          }
          ad.e("MicroMsg.WebviewFileChooserCdnService", "get item by media id failed, media is : %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(78989);
          return 0;
          localObject1 = paramAnonymousc.toString();
          break;
          label112:
          localObject2 = paramAnonymousd.toString();
          break label22;
          label122:
          localObject2 = ((an)localObject1).AYw.values().iterator();
          label137:
          if (!((Iterator)localObject2).hasNext()) {
            break label73;
          }
          localObject1 = (WebViewJSSDKFileItem)((Iterator)localObject2).next();
          if (!bt.nullAsNil(((WebViewJSSDKFileItem)localObject1).mediaId).equals(paramAnonymousString)) {
            break label72;
          }
        }
        label177:
        if (paramAnonymousInt == -21005)
        {
          ad.i("MicroMsg.WebviewFileChooserCdnService", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(78989);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ad.e("MicroMsg.WebviewFileChooserCdnService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          am.a(am.this, false, paramAnonymousInt, ((WebViewJSSDKFileItem)localObject1).diQ, ((WebViewJSSDKFileItem)localObject1).mediaId, null, null);
          AppMethodBeat.o(78989);
          return 0;
        }
        long l;
        if (paramAnonymousc != null)
        {
          ad.i("MicroMsg.WebviewFileChooserCdnService", "progressInfo : %s", new Object[] { paramAnonymousc.toString() });
          l = 0L;
          if (paramAnonymousc.field_toltalLength > 0L) {
            l = (int)(paramAnonymousc.field_finishedLength * 100L / paramAnonymousc.field_toltalLength);
          }
          if (l < 0L) {
            l = 0L;
          }
        }
        for (;;)
        {
          ad.d("MicroMsg.WebviewFileChooserCdnService", "progressInfo, percent = %d, finishLen = %d, totalLen = %d", new Object[] { Long.valueOf(l), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          am.this.b(((WebViewJSSDKFileItem)localObject1).jax, ((WebViewJSSDKFileItem)localObject1).mediaType, (int)l, ((WebViewJSSDKFileItem)localObject1).diQ, ((WebViewJSSDKFileItem)localObject1).mediaId);
          AppMethodBeat.o(78989);
          return 0;
          if (l > 100L)
          {
            l = 100L;
            continue;
            if (paramAnonymousd != null)
            {
              if (paramAnonymousd.field_retCode == 0) {
                break label490;
              }
              ad.e("MicroMsg.WebviewFileChooserCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
              am.a(am.this, false, paramAnonymousd.field_retCode, ((WebViewJSSDKFileItem)localObject1).diQ, ((WebViewJSSDKFileItem)localObject1).mediaId, null, null);
            }
            for (;;)
            {
              AppMethodBeat.o(78989);
              return 0;
              label490:
              ad.i("MicroMsg.WebviewFileChooserCdnService", "cdn trans suceess, media id : %s, item.mediaId : %s, item.localId: %s", new Object[] { paramAnonymousString, ((WebViewJSSDKFileItem)localObject1).mediaId, ((WebViewJSSDKFileItem)localObject1).diQ });
              if (localObject1 != null)
              {
                ((WebViewJSSDKFileItem)localObject1).e(paramAnonymousd);
                if ((((WebViewJSSDKFileItem)localObject1).jax) && (((WebViewJSSDKFileItem)localObject1).jaz))
                {
                  paramAnonymousString = am.this;
                  if (localObject1 == null)
                  {
                    ad.e("MicroMsg.WebviewFileChooserCdnService", "uploadCdnInfo failed, item is null");
                  }
                  else
                  {
                    paramAnonymousc = new bne();
                    paramAnonymousc.CGX = ((WebViewJSSDKFileItem)localObject1).Lwc.field_aesKey;
                    paramAnonymousc.CVe = ((WebViewJSSDKFileItem)localObject1).Lwc.field_fileLength;
                    paramAnonymousc.DKO = ((WebViewJSSDKFileItem)localObject1).Lwc.field_fileId;
                    paramAnonymousc.type = ((WebViewJSSDKFileItem)localObject1).fZy();
                    ad.d("MicroMsg.WebviewFileChooserCdnService", "appId:%s, localId:%s, aes_key:%s， file_size:%d, fileId:%s", new Object[] { ((WebViewJSSDKFileItem)localObject1).appId, ((WebViewJSSDKFileItem)localObject1).diQ, paramAnonymousc.CGX, Integer.valueOf(paramAnonymousc.CVe), paramAnonymousc.DKO });
                    paramAnonymousc.DKP = ((WebViewJSSDKFileItem)localObject1).fZx();
                    com.tencent.mm.kernel.g.aeS().a(1034, paramAnonymousString);
                    paramAnonymousString = new ae(((WebViewJSSDKFileItem)localObject1).appId, ((WebViewJSSDKFileItem)localObject1).diQ, paramAnonymousc);
                    com.tencent.mm.kernel.g.aeS().a(paramAnonymousString, 0);
                  }
                }
                else
                {
                  am.a(am.this, true, 0, ((WebViewJSSDKFileItem)localObject1).diQ, ((WebViewJSSDKFileItem)localObject1).jav, ((WebViewJSSDKFileItem)localObject1).Lwc.field_fileUrl, paramAnonymousd.field_thumbUrl);
                }
              }
            }
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(78987);
        ad.i("MicroMsg.WebviewFileChooserCdnService", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(78987);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(78988);
        ad.i("MicroMsg.WebviewFileChooserCdnService", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(78988);
        return null;
      }
    };
    AppMethodBeat.o(78990);
  }
  
  public static boolean Fu(String paramString)
  {
    AppMethodBeat.i(79000);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.emF().awC(paramString);
    if (localWebViewJSSDKFileItem == null)
    {
      ad.e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString });
      AppMethodBeat.o(79000);
      return false;
    }
    boolean bool = f.awL().xK(localWebViewJSSDKFileItem.mediaId);
    AppMethodBeat.o(79000);
    return bool;
  }
  
  public static boolean aww(String paramString)
  {
    AppMethodBeat.i(79001);
    ad.i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", new Object[] { paramString });
    boolean bool = f.awL().xL(paramString);
    AppMethodBeat.o(79001);
    return bool;
  }
  
  private void b(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      AppMethodBeat.i(78995);
      ad.d("MicroMsg.WebviewFileChooserCdnService", "notifyRequstCallback, localId : %s", new Object[] { paramString1 });
      if ((this.AYr != null) && (this.AYr.size() > 0))
      {
        Iterator localIterator = this.AYr.iterator();
        while (localIterator.hasNext()) {
          ((f.b)localIterator.next()).a(paramBoolean, paramInt, paramString1, paramString2, paramString3, paramString4);
        }
      }
      AppMethodBeat.o(78995);
    }
    finally {}
  }
  
  private void jZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79002);
    com.tencent.mm.kernel.g.aeS().a(1035, this);
    paramString1 = new l(paramString1, paramString2);
    com.tencent.mm.kernel.g.aeS().a(paramString1, 0);
    AppMethodBeat.o(79002);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(78992);
    if ((this.AYs != null) && (parama != null) && (!this.AYs.contains(parama))) {
      this.AYs.add(parama);
    }
    AppMethodBeat.o(78992);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(78991);
    if ((this.AYr != null) && (paramb != null) && (!this.AYr.contains(paramb))) {
      this.AYr.add(paramb);
    }
    AppMethodBeat.o(78991);
  }
  
  public final boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, f.b paramb)
  {
    AppMethodBeat.i(78998);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.emF().awC(paramString2);
    if (localWebViewJSSDKFileItem == null)
    {
      ad.e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString2 });
      AppMethodBeat.o(78998);
      return false;
    }
    localWebViewJSSDKFileItem.appId = paramString1;
    if (paramb != null) {
      this.AYr.add(paramb);
    }
    if ((paramInt2 == 202) || (paramInt2 == 214) || (paramInt2 == 215)) {
      localWebViewJSSDKFileItem.jaz = false;
    }
    localWebViewJSSDKFileItem.jax = true;
    paramString1 = new com.tencent.mm.i.g();
    paramString1.fnH = this.hhW;
    paramString1.dDS = true;
    paramString1.field_mediaId = localWebViewJSSDKFileItem.mediaId;
    paramString1.field_fullpath = localWebViewJSSDKFileItem.jau;
    paramString1.field_fileType = paramInt1;
    paramString1.field_talker = "weixin";
    paramString1.field_priority = a.fmV;
    if ((paramInt1 == a.fnb) || (paramInt2 == 214)) {}
    for (paramString1.field_needStorage = true;; paramString1.field_needStorage = false)
    {
      paramString1.field_isStreamMedia = false;
      paramString1.field_appType = paramInt2;
      paramString1.field_bzScene = paramInt3;
      paramString1.field_force_aeskeycdn = true;
      paramString1.field_trysafecdn = false;
      paramString1.field_thumbpath = localWebViewJSSDKFileItem.jMa;
      if (paramInt2 == 214) {
        paramString1.snsVersion = 1;
      }
      boolean bool = f.awL().e(paramString1);
      ad.i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramString1.field_force_aeskeycdn), Boolean.valueOf(paramString1.field_trysafecdn), paramString2 });
      AppMethodBeat.o(78998);
      return bool;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, f.b paramb)
  {
    AppMethodBeat.i(78997);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.emF().awD(paramString2);
    if (localWebViewJSSDKFileItem != null)
    {
      localWebViewJSSDKFileItem.appId = paramString1;
      ad.i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", new Object[] { paramString1, paramString2, localWebViewJSSDKFileItem.diQ });
      paramb.a(true, 0, localWebViewJSSDKFileItem.diQ, localWebViewJSSDKFileItem.jav, null, null);
      AppMethodBeat.o(78997);
      return true;
    }
    jZ(paramString1, paramString2);
    this.AYr.add(paramb);
    AppMethodBeat.o(78997);
    return true;
  }
  
  public final void b(f.a parama)
  {
    AppMethodBeat.i(78994);
    if ((this.AYs != null) && (parama != null)) {
      this.AYs.remove(parama);
    }
    AppMethodBeat.o(78994);
  }
  
  public final void b(f.b paramb)
  {
    AppMethodBeat.i(78993);
    if ((this.AYr != null) && (paramb != null)) {
      this.AYr.remove(paramb);
    }
    AppMethodBeat.o(78993);
  }
  
  final void b(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(78996);
      ad.i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
      if ((this.AYs != null) && (this.AYs.size() > 0))
      {
        Iterator localIterator = this.AYs.iterator();
        while (localIterator.hasNext()) {
          ((f.a)localIterator.next()).a(paramBoolean, paramInt1, paramInt2, paramString1, paramString2);
        }
      }
      AppMethodBeat.o(78996);
    }
    finally {}
  }
  
  public final boolean b(String paramString1, String paramString2, f.b paramb)
  {
    AppMethodBeat.i(78999);
    boolean bool = a(paramString1, paramString2, a.MediaType_FILE, 0, 0, paramb);
    AppMethodBeat.o(78999);
    return bool;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(79003);
    ad.i("MicroMsg.WebviewFileChooserCdnService", "onSceneEnd, errType = %d, errCode = %d, funcType = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.getType()) });
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79003);
      return;
      com.tencent.mm.kernel.g.aeS().b(1034, this);
      Object localObject1 = (ae)paramn;
      paramString = ((bnk)((ae)localObject1).rr.gUT.gUX).DKQ;
      paramn = ((ae)localObject1).appId;
      localObject1 = ((ae)localObject1).diQ;
      Object localObject2 = com.tencent.mm.plugin.webview.modeltools.g.emF().awC((String)localObject1);
      if (localObject2 == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.WebviewFileChooserCdnService", "get server server id : %s from server for appid : %s, localId = %s, item == null ? %b", new Object[] { paramString, paramn, localObject1, Boolean.valueOf(bool) });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label274;
        }
        if ((bt.isNullOrNil(paramn)) || (bt.isNullOrNil(paramString)) || (localObject2 == null)) {
          break;
        }
        ((WebViewJSSDKFileItem)localObject2).jav = paramString;
        b(true, ((WebViewJSSDKFileItem)localObject2).mediaType, 100, ((WebViewJSSDKFileItem)localObject2).diQ, ((WebViewJSSDKFileItem)localObject2).jav);
        b(true, 0, ((WebViewJSSDKFileItem)localObject2).diQ, ((WebViewJSSDKFileItem)localObject2).jav, ((WebViewJSSDKFileItem)localObject2).Lwc.field_fileUrl, null);
        AppMethodBeat.o(79003);
        return;
      }
      label274:
      ad.e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
      if (localObject2 != null)
      {
        b(false, 0, ((WebViewJSSDKFileItem)localObject2).diQ, ((WebViewJSSDKFileItem)localObject2).mediaId, null, null);
        AppMethodBeat.o(79003);
        return;
        com.tencent.mm.kernel.g.aeS().b(1035, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (l)paramn;
          paramn = paramString.appId;
          localObject1 = paramString.jav;
          localObject2 = ((bng)paramString.rr.gUT.gUX).DKR;
          if (localObject2 == null)
          {
            bool = true;
            ad.i("MicroMsg.WebviewFileChooserCdnService", "appid = %s, serverId = %s, cdninfo == null ? %b", new Object[] { paramn, localObject1, Boolean.valueOf(bool) });
            if ((!bt.isNullOrNil(paramn)) && (!bt.isNullOrNil((String)localObject1)) && (localObject2 != null))
            {
              paramString = ((bne)localObject2).type;
              ad.i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", new Object[] { paramString });
              if (!bt.isNullOrNil(paramString))
              {
                if (!paramString.toLowerCase().equals("voice")) {
                  break label704;
                }
                paramString = WebViewJSSDKFileItem.aVY(aw.awL(paramn));
                label476:
                paramString.jax = false;
                paramString.appId = paramn;
                paramString.jav = ((String)localObject1);
                if (paramString.Lwc == null) {
                  paramString.Lwc = new WebViewJSSDKFileItem.a();
                }
                if (localObject2 != null) {
                  break label769;
                }
                ad.e("MicroMsg.WebViewJSSDKFileItem", "jsapidcdn info is null");
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.webview.modeltools.g.emF().a(paramString);
            paramn = new com.tencent.mm.i.g();
            paramn.fnH = this.hhW;
            paramn.dDS = false;
            paramn.field_mediaId = paramString.mediaId;
            paramn.field_fullpath = paramString.jau;
            paramn.field_totalLen = paramString.Lwc.field_fileLength;
            paramn.field_fileType = a.MediaType_FILE;
            paramn.field_fileId = paramString.Lwc.field_fileId;
            paramn.field_aesKey = paramString.Lwc.field_aesKey;
            paramn.field_priority = a.fmV;
            paramn.field_needStorage = false;
            paramn.field_isStreamMedia = false;
            bool = f.awL().b(paramn, -1);
            ad.i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", new Object[] { Boolean.valueOf(bool), paramString.jav });
            if (!bool) {
              b(false, 0, null, null, null, null);
            }
            AppMethodBeat.o(79003);
            return;
            bool = false;
            break;
            label704:
            if (paramString.toLowerCase().equals("video"))
            {
              paramString = WebViewJSSDKFileItem.aVZ(aw.awF(bt.eGO()));
              break label476;
            }
            paramString = WebViewJSSDKFileItem.aVX(aw.awF(bt.eGO()));
            break label476;
            label769:
            paramString.Lwc.field_aesKey = ((bne)localObject2).CGX;
            paramString.Lwc.field_fileId = ((bne)localObject2).DKO;
            paramString.Lwc.field_fileLength = ((bne)localObject2).CVe;
          }
        }
        ad.e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
        b(false, 0, null, null, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.am
 * JD-Core Version:    0.7.0.1
 */