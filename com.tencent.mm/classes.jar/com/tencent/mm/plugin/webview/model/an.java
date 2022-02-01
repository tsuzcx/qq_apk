package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.a;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.bxb;
import com.tencent.mm.protocal.protobuf.bxd;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class an
  implements com.tencent.mm.ak.f
{
  private CopyOnWriteArraySet<f.b> Emg;
  private CopyOnWriteArraySet<f.a> Emh;
  private g.a ieg;
  
  public an()
  {
    AppMethodBeat.i(78990);
    this.Emh = new CopyOnWriteArraySet();
    this.Emg = new CopyOnWriteArraySet();
    this.ieg = new g.a()
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
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebviewFileChooserCdnService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), localObject1, localObject2 });
          localObject1 = com.tencent.mm.plugin.webview.modeltools.g.eUG();
          if (!bu.isNullOrNil(paramAnonymousString)) {
            break label122;
          }
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByMediaID error, media id is null or nil");
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
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebviewFileChooserCdnService", "get item by media id failed, media is : %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(78989);
          return 0;
          localObject1 = paramAnonymousc.toString();
          break;
          label112:
          localObject2 = paramAnonymousd.toString();
          break label22;
          label122:
          localObject2 = ((ao)localObject1).Eml.values().iterator();
          label137:
          if (!((Iterator)localObject2).hasNext()) {
            break label73;
          }
          localObject1 = (WebViewJSSDKFileItem)((Iterator)localObject2).next();
          if (!bu.nullAsNil(((WebViewJSSDKFileItem)localObject1).mediaId).equals(paramAnonymousString)) {
            break label72;
          }
        }
        label177:
        if (paramAnonymousInt == -21005)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebviewFileChooserCdnService", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(78989);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebviewFileChooserCdnService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          an.a(an.this, false, paramAnonymousInt, ((WebViewJSSDKFileItem)localObject1).dsN, ((WebViewJSSDKFileItem)localObject1).mediaId, null, null);
          AppMethodBeat.o(78989);
          return 0;
        }
        long l;
        if (paramAnonymousc != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebviewFileChooserCdnService", "progressInfo : %s", new Object[] { paramAnonymousc.toString() });
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
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WebviewFileChooserCdnService", "progressInfo, percent = %d, finishLen = %d, totalLen = %d", new Object[] { Long.valueOf(l), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          an.this.b(((WebViewJSSDKFileItem)localObject1).jXW, ((WebViewJSSDKFileItem)localObject1).mediaType, (int)l, ((WebViewJSSDKFileItem)localObject1).dsN, ((WebViewJSSDKFileItem)localObject1).mediaId);
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
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebviewFileChooserCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
              an.a(an.this, false, paramAnonymousd.field_retCode, ((WebViewJSSDKFileItem)localObject1).dsN, ((WebViewJSSDKFileItem)localObject1).mediaId, null, null);
            }
            for (;;)
            {
              AppMethodBeat.o(78989);
              return 0;
              label490:
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebviewFileChooserCdnService", "cdn trans suceess, media id : %s, item.mediaId : %s, item.localId: %s", new Object[] { paramAnonymousString, ((WebViewJSSDKFileItem)localObject1).mediaId, ((WebViewJSSDKFileItem)localObject1).dsN });
              if (localObject1 != null)
              {
                ((WebViewJSSDKFileItem)localObject1).d(paramAnonymousd);
                if ((((WebViewJSSDKFileItem)localObject1).jXW) && (((WebViewJSSDKFileItem)localObject1).jXY))
                {
                  paramAnonymousString = an.this;
                  if (localObject1 == null)
                  {
                    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebviewFileChooserCdnService", "uploadCdnInfo failed, item is null");
                  }
                  else
                  {
                    paramAnonymousc = new bxb();
                    paramAnonymousc.FXr = ((WebViewJSSDKFileItem)localObject1).Jin.field_aesKey;
                    paramAnonymousc.Gnw = ((WebViewJSSDKFileItem)localObject1).Jin.field_fileLength;
                    paramAnonymousc.Hkg = ((WebViewJSSDKFileItem)localObject1).Jin.field_fileId;
                    paramAnonymousc.type = ((WebViewJSSDKFileItem)localObject1).fwN();
                    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WebviewFileChooserCdnService", "appId:%s, localId:%s, aes_key:%s， file_size:%d, fileId:%s", new Object[] { ((WebViewJSSDKFileItem)localObject1).appId, ((WebViewJSSDKFileItem)localObject1).dsN, paramAnonymousc.FXr, Integer.valueOf(paramAnonymousc.Gnw), paramAnonymousc.Hkg });
                    paramAnonymousc.Hkh = ((WebViewJSSDKFileItem)localObject1).eUf();
                    com.tencent.mm.kernel.g.ajj().a(1034, paramAnonymousString);
                    paramAnonymousString = new ae(((WebViewJSSDKFileItem)localObject1).appId, ((WebViewJSSDKFileItem)localObject1).dsN, paramAnonymousc);
                    com.tencent.mm.kernel.g.ajj().a(paramAnonymousString, 0);
                  }
                }
                else
                {
                  an.a(an.this, true, 0, ((WebViewJSSDKFileItem)localObject1).dsN, ((WebViewJSSDKFileItem)localObject1).jXU, ((WebViewJSSDKFileItem)localObject1).Jin.field_fileUrl, paramAnonymousd.field_thumbUrl);
                }
              }
            }
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(78987);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebviewFileChooserCdnService", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(78987);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(78988);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebviewFileChooserCdnService", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(78988);
        return null;
      }
    };
    AppMethodBeat.o(78990);
  }
  
  public static boolean Ny(String paramString)
  {
    AppMethodBeat.i(79000);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.eUG().aIN(paramString);
    if (localWebViewJSSDKFileItem == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString });
      AppMethodBeat.o(79000);
      return false;
    }
    boolean bool = com.tencent.mm.an.f.aGZ().Fr(localWebViewJSSDKFileItem.mediaId);
    AppMethodBeat.o(79000);
    return bool;
  }
  
  public static boolean aIH(String paramString)
  {
    AppMethodBeat.i(79001);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", new Object[] { paramString });
    boolean bool = com.tencent.mm.an.f.aGZ().Fs(paramString);
    AppMethodBeat.o(79001);
    return bool;
  }
  
  private void b(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      AppMethodBeat.i(78995);
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WebviewFileChooserCdnService", "notifyRequstCallback, localId : %s", new Object[] { paramString1 });
      if ((this.Emg != null) && (this.Emg.size() > 0))
      {
        Iterator localIterator = this.Emg.iterator();
        while (localIterator.hasNext()) {
          ((f.b)localIterator.next()).a(paramBoolean, paramInt, paramString1, paramString2, paramString3, paramString4);
        }
      }
      AppMethodBeat.o(78995);
    }
    finally {}
  }
  
  private void la(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79002);
    com.tencent.mm.kernel.g.ajj().a(1035, this);
    paramString1 = new l(paramString1, paramString2);
    com.tencent.mm.kernel.g.ajj().a(paramString1, 0);
    AppMethodBeat.o(79002);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(78992);
    if ((this.Emh != null) && (parama != null) && (!this.Emh.contains(parama))) {
      this.Emh.add(parama);
    }
    AppMethodBeat.o(78992);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(78991);
    if ((this.Emg != null) && (paramb != null) && (!this.Emg.contains(paramb))) {
      this.Emg.add(paramb);
    }
    AppMethodBeat.o(78991);
  }
  
  public final boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, f.b paramb)
  {
    AppMethodBeat.i(78998);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.eUG().aIN(paramString2);
    if (localWebViewJSSDKFileItem == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString2 });
      AppMethodBeat.o(78998);
      return false;
    }
    localWebViewJSSDKFileItem.appId = paramString1;
    if (paramb != null) {
      this.Emg.add(paramb);
    }
    if ((paramInt2 == 202) || (paramInt2 == 214) || (paramInt2 == 215)) {
      localWebViewJSSDKFileItem.jXY = false;
    }
    localWebViewJSSDKFileItem.jXW = true;
    paramString1 = new com.tencent.mm.i.g();
    paramString1.fLl = "task_WebViewJSSDKCdnService_2";
    paramString1.fLm = this.ieg;
    paramString1.dPh = true;
    paramString1.field_mediaId = localWebViewJSSDKFileItem.mediaId;
    paramString1.field_fullpath = localWebViewJSSDKFileItem.jXT;
    paramString1.field_fileType = paramInt1;
    paramString1.field_talker = "weixin";
    paramString1.field_priority = a.fKA;
    if ((paramInt1 == a.fKG) || (paramInt2 == 214)) {}
    for (paramString1.field_needStorage = true;; paramString1.field_needStorage = false)
    {
      paramString1.field_isStreamMedia = false;
      paramString1.field_appType = paramInt2;
      paramString1.field_bzScene = paramInt3;
      paramString1.field_force_aeskeycdn = true;
      paramString1.field_trysafecdn = false;
      paramString1.field_thumbpath = localWebViewJSSDKFileItem.kKQ;
      if (paramInt2 == 214) {
        paramString1.snsVersion = 1;
      }
      boolean bool = com.tencent.mm.an.f.aGZ().f(paramString1);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramString1.field_force_aeskeycdn), Boolean.valueOf(paramString1.field_trysafecdn), paramString2 });
      AppMethodBeat.o(78998);
      return bool;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, f.b paramb)
  {
    AppMethodBeat.i(78997);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.eUG().aIO(paramString2);
    if (localWebViewJSSDKFileItem != null)
    {
      localWebViewJSSDKFileItem.appId = paramString1;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", new Object[] { paramString1, paramString2, localWebViewJSSDKFileItem.dsN });
      paramb.a(true, 0, localWebViewJSSDKFileItem.dsN, localWebViewJSSDKFileItem.jXU, null, null);
      AppMethodBeat.o(78997);
      return true;
    }
    la(paramString1, paramString2);
    this.Emg.add(paramb);
    AppMethodBeat.o(78997);
    return true;
  }
  
  public final void b(f.a parama)
  {
    AppMethodBeat.i(78994);
    if ((this.Emh != null) && (parama != null)) {
      this.Emh.remove(parama);
    }
    AppMethodBeat.o(78994);
  }
  
  public final void b(f.b paramb)
  {
    AppMethodBeat.i(78993);
    if ((this.Emg != null) && (paramb != null)) {
      this.Emg.remove(paramb);
    }
    AppMethodBeat.o(78993);
  }
  
  final void b(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(78996);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
      if ((this.Emh != null) && (this.Emh.size() > 0))
      {
        Iterator localIterator = this.Emh.iterator();
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebviewFileChooserCdnService", "onSceneEnd, errType = %d, errCode = %d, funcType = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.getType()) });
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79003);
      return;
      com.tencent.mm.kernel.g.ajj().b(1034, this);
      Object localObject1 = (ae)paramn;
      paramString = ((bxh)((ae)localObject1).rr.hQE.hQJ).Hki;
      paramn = ((ae)localObject1).appId;
      localObject1 = ((ae)localObject1).dsN;
      Object localObject2 = com.tencent.mm.plugin.webview.modeltools.g.eUG().aIN((String)localObject1);
      if (localObject2 == null) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebviewFileChooserCdnService", "get server server id : %s from server for appid : %s, localId = %s, item == null ? %b", new Object[] { paramString, paramn, localObject1, Boolean.valueOf(bool) });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label274;
        }
        if ((bu.isNullOrNil(paramn)) || (bu.isNullOrNil(paramString)) || (localObject2 == null)) {
          break;
        }
        ((WebViewJSSDKFileItem)localObject2).jXU = paramString;
        b(true, ((WebViewJSSDKFileItem)localObject2).mediaType, 100, ((WebViewJSSDKFileItem)localObject2).dsN, ((WebViewJSSDKFileItem)localObject2).jXU);
        b(true, 0, ((WebViewJSSDKFileItem)localObject2).dsN, ((WebViewJSSDKFileItem)localObject2).jXU, ((WebViewJSSDKFileItem)localObject2).Jin.field_fileUrl, null);
        AppMethodBeat.o(79003);
        return;
      }
      label274:
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
      if (localObject2 != null)
      {
        b(false, 0, ((WebViewJSSDKFileItem)localObject2).dsN, ((WebViewJSSDKFileItem)localObject2).mediaId, null, null);
        AppMethodBeat.o(79003);
        return;
        com.tencent.mm.kernel.g.ajj().b(1035, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (l)paramn;
          paramn = paramString.appId;
          localObject1 = paramString.jXU;
          localObject2 = ((bxd)paramString.rr.hQE.hQJ).Hkj;
          if (localObject2 == null)
          {
            bool = true;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebviewFileChooserCdnService", "appid = %s, serverId = %s, cdninfo == null ? %b", new Object[] { paramn, localObject1, Boolean.valueOf(bool) });
            if ((!bu.isNullOrNil(paramn)) && (!bu.isNullOrNil((String)localObject1)) && (localObject2 != null))
            {
              paramString = ((bxb)localObject2).type;
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", new Object[] { paramString });
              if (!bu.isNullOrNil(paramString))
              {
                if (!paramString.toLowerCase().equals("voice")) {
                  break label712;
                }
                paramString = WebViewJSSDKFileItem.bfG(ax.aIW(paramn));
                label476:
                paramString.jXW = false;
                paramString.appId = paramn;
                paramString.jXU = ((String)localObject1);
                if (paramString.Jin == null) {
                  paramString.Jin = new WebViewJSSDKFileItem.a();
                }
                if (localObject2 != null) {
                  break label777;
                }
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebViewJSSDKFileItem", "jsapidcdn info is null");
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.webview.modeltools.g.eUG().a(paramString);
            paramn = new com.tencent.mm.i.g();
            paramn.fLl = "task_WebViewJSSDKCdnService_1";
            paramn.fLm = this.ieg;
            paramn.dPh = false;
            paramn.field_mediaId = paramString.mediaId;
            paramn.field_fullpath = paramString.jXT;
            paramn.field_totalLen = paramString.Jin.field_fileLength;
            paramn.field_fileType = a.MediaType_FILE;
            paramn.field_fileId = paramString.Jin.field_fileId;
            paramn.field_aesKey = paramString.Jin.field_aesKey;
            paramn.field_priority = a.fKA;
            paramn.field_needStorage = false;
            paramn.field_isStreamMedia = false;
            bool = com.tencent.mm.an.f.aGZ().b(paramn, -1);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", new Object[] { Boolean.valueOf(bool), paramString.jXU });
            if (!bool) {
              b(false, 0, null, null, null, null);
            }
            AppMethodBeat.o(79003);
            return;
            bool = false;
            break;
            label712:
            if (paramString.toLowerCase().equals("video"))
            {
              paramString = WebViewJSSDKFileItem.bfH(ax.aIR(bu.fpO()));
              break label476;
            }
            paramString = WebViewJSSDKFileItem.aWg(ax.aIR(bu.fpO()));
            break label476;
            label777:
            paramString.Jin.field_aesKey = ((bxb)localObject2).FXr;
            paramString.Jin.field_fileId = ((bxb)localObject2).Hkg;
            paramString.Jin.field_fileLength = ((bxb)localObject2).Gnw;
          }
        }
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
        b(false, 0, null, null, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.an
 * JD-Core Version:    0.7.0.1
 */