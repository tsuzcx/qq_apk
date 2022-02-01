package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.i.a;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.bru;
import com.tencent.mm.protocal.protobuf.brw;
import com.tencent.mm.protocal.protobuf.bsa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class am
  implements com.tencent.mm.ak.g
{
  private CopyOnWriteArraySet<f.b> CqE;
  private CopyOnWriteArraySet<f.a> CqF;
  private g.a hIz;
  
  public am()
  {
    AppMethodBeat.i(78990);
    this.CqF = new CopyOnWriteArraySet();
    this.CqE = new CopyOnWriteArraySet();
    this.hIz = new g.a()
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
          ac.i("MicroMsg.WebviewFileChooserCdnService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), localObject1, localObject2 });
          localObject1 = com.tencent.mm.plugin.webview.modeltools.g.eCa();
          if (!bs.isNullOrNil(paramAnonymousString)) {
            break label122;
          }
          ac.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByMediaID error, media id is null or nil");
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
          ac.e("MicroMsg.WebviewFileChooserCdnService", "get item by media id failed, media is : %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(78989);
          return 0;
          localObject1 = paramAnonymousc.toString();
          break;
          label112:
          localObject2 = paramAnonymousd.toString();
          break label22;
          label122:
          localObject2 = ((an)localObject1).CqJ.values().iterator();
          label137:
          if (!((Iterator)localObject2).hasNext()) {
            break label73;
          }
          localObject1 = (WebViewJSSDKFileItem)((Iterator)localObject2).next();
          if (!bs.nullAsNil(((WebViewJSSDKFileItem)localObject1).mediaId).equals(paramAnonymousString)) {
            break label72;
          }
        }
        label177:
        if (paramAnonymousInt == -21005)
        {
          ac.i("MicroMsg.WebviewFileChooserCdnService", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(78989);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ac.e("MicroMsg.WebviewFileChooserCdnService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          am.a(am.this, false, paramAnonymousInt, ((WebViewJSSDKFileItem)localObject1).dgl, ((WebViewJSSDKFileItem)localObject1).mediaId, null, null);
          AppMethodBeat.o(78989);
          return 0;
        }
        long l;
        if (paramAnonymousc != null)
        {
          ac.i("MicroMsg.WebviewFileChooserCdnService", "progressInfo : %s", new Object[] { paramAnonymousc.toString() });
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
          ac.d("MicroMsg.WebviewFileChooserCdnService", "progressInfo, percent = %d, finishLen = %d, totalLen = %d", new Object[] { Long.valueOf(l), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          am.this.b(((WebViewJSSDKFileItem)localObject1).jAK, ((WebViewJSSDKFileItem)localObject1).mediaType, (int)l, ((WebViewJSSDKFileItem)localObject1).dgl, ((WebViewJSSDKFileItem)localObject1).mediaId);
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
              ac.e("MicroMsg.WebviewFileChooserCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
              am.a(am.this, false, paramAnonymousd.field_retCode, ((WebViewJSSDKFileItem)localObject1).dgl, ((WebViewJSSDKFileItem)localObject1).mediaId, null, null);
            }
            for (;;)
            {
              AppMethodBeat.o(78989);
              return 0;
              label490:
              ac.i("MicroMsg.WebviewFileChooserCdnService", "cdn trans suceess, media id : %s, item.mediaId : %s, item.localId: %s", new Object[] { paramAnonymousString, ((WebViewJSSDKFileItem)localObject1).mediaId, ((WebViewJSSDKFileItem)localObject1).dgl });
              if (localObject1 != null)
              {
                ((WebViewJSSDKFileItem)localObject1).d(paramAnonymousd);
                if ((((WebViewJSSDKFileItem)localObject1).jAK) && (((WebViewJSSDKFileItem)localObject1).jAM))
                {
                  paramAnonymousString = am.this;
                  if (localObject1 == null)
                  {
                    ac.e("MicroMsg.WebviewFileChooserCdnService", "uploadCdnInfo failed, item is null");
                  }
                  else
                  {
                    paramAnonymousc = new bru();
                    paramAnonymousc.DZy = ((WebViewJSSDKFileItem)localObject1).GZW.field_aesKey;
                    paramAnonymousc.EnO = ((WebViewJSSDKFileItem)localObject1).GZW.field_fileLength;
                    paramAnonymousc.Fhd = ((WebViewJSSDKFileItem)localObject1).GZW.field_fileId;
                    paramAnonymousc.type = ((WebViewJSSDKFileItem)localObject1).fda();
                    ac.d("MicroMsg.WebviewFileChooserCdnService", "appId:%s, localId:%s, aes_key:%s， file_size:%d, fileId:%s", new Object[] { ((WebViewJSSDKFileItem)localObject1).appId, ((WebViewJSSDKFileItem)localObject1).dgl, paramAnonymousc.DZy, Integer.valueOf(paramAnonymousc.EnO), paramAnonymousc.Fhd });
                    paramAnonymousc.Fhe = ((WebViewJSSDKFileItem)localObject1).fcH();
                    com.tencent.mm.kernel.g.agi().a(1034, paramAnonymousString);
                    paramAnonymousString = new ae(((WebViewJSSDKFileItem)localObject1).appId, ((WebViewJSSDKFileItem)localObject1).dgl, paramAnonymousc);
                    com.tencent.mm.kernel.g.agi().a(paramAnonymousString, 0);
                  }
                }
                else
                {
                  am.a(am.this, true, 0, ((WebViewJSSDKFileItem)localObject1).dgl, ((WebViewJSSDKFileItem)localObject1).jAI, ((WebViewJSSDKFileItem)localObject1).GZW.field_fileUrl, paramAnonymousd.field_thumbUrl);
                }
              }
            }
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(78987);
        ac.i("MicroMsg.WebviewFileChooserCdnService", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(78987);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(78988);
        ac.i("MicroMsg.WebviewFileChooserCdnService", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(78988);
        return null;
      }
    };
    AppMethodBeat.o(78990);
  }
  
  public static boolean Jy(String paramString)
  {
    AppMethodBeat.i(79000);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.eCa().aBU(paramString);
    if (localWebViewJSSDKFileItem == null)
    {
      ac.e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString });
      AppMethodBeat.o(79000);
      return false;
    }
    boolean bool = f.aDD().BQ(localWebViewJSSDKFileItem.mediaId);
    AppMethodBeat.o(79000);
    return bool;
  }
  
  public static boolean aBO(String paramString)
  {
    AppMethodBeat.i(79001);
    ac.i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", new Object[] { paramString });
    boolean bool = f.aDD().BR(paramString);
    AppMethodBeat.o(79001);
    return bool;
  }
  
  private void b(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      AppMethodBeat.i(78995);
      ac.d("MicroMsg.WebviewFileChooserCdnService", "notifyRequstCallback, localId : %s", new Object[] { paramString1 });
      if ((this.CqE != null) && (this.CqE.size() > 0))
      {
        Iterator localIterator = this.CqE.iterator();
        while (localIterator.hasNext()) {
          ((f.b)localIterator.next()).a(paramBoolean, paramInt, paramString1, paramString2, paramString3, paramString4);
        }
      }
      AppMethodBeat.o(78995);
    }
    finally {}
  }
  
  private void kv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79002);
    com.tencent.mm.kernel.g.agi().a(1035, this);
    paramString1 = new l(paramString1, paramString2);
    com.tencent.mm.kernel.g.agi().a(paramString1, 0);
    AppMethodBeat.o(79002);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(78992);
    if ((this.CqF != null) && (parama != null) && (!this.CqF.contains(parama))) {
      this.CqF.add(parama);
    }
    AppMethodBeat.o(78992);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(78991);
    if ((this.CqE != null) && (paramb != null) && (!this.CqE.contains(paramb))) {
      this.CqE.add(paramb);
    }
    AppMethodBeat.o(78991);
  }
  
  public final boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, f.b paramb)
  {
    AppMethodBeat.i(78998);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.eCa().aBU(paramString2);
    if (localWebViewJSSDKFileItem == null)
    {
      ac.e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString2 });
      AppMethodBeat.o(78998);
      return false;
    }
    localWebViewJSSDKFileItem.appId = paramString1;
    if (paramb != null) {
      this.CqE.add(paramb);
    }
    if ((paramInt2 == 202) || (paramInt2 == 214) || (paramInt2 == 215)) {
      localWebViewJSSDKFileItem.jAM = false;
    }
    localWebViewJSSDKFileItem.jAK = true;
    paramString1 = new com.tencent.mm.i.g();
    paramString1.frb = this.hIz;
    paramString1.dBE = true;
    paramString1.field_mediaId = localWebViewJSSDKFileItem.mediaId;
    paramString1.field_fullpath = localWebViewJSSDKFileItem.jAH;
    paramString1.field_fileType = paramInt1;
    paramString1.field_talker = "weixin";
    paramString1.field_priority = a.fqp;
    if ((paramInt1 == a.fqv) || (paramInt2 == 214)) {}
    for (paramString1.field_needStorage = true;; paramString1.field_needStorage = false)
    {
      paramString1.field_isStreamMedia = false;
      paramString1.field_appType = paramInt2;
      paramString1.field_bzScene = paramInt3;
      paramString1.field_force_aeskeycdn = true;
      paramString1.field_trysafecdn = false;
      paramString1.field_thumbpath = localWebViewJSSDKFileItem.kmB;
      if (paramInt2 == 214) {
        paramString1.snsVersion = 1;
      }
      boolean bool = f.aDD().f(paramString1);
      ac.i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramString1.field_force_aeskeycdn), Boolean.valueOf(paramString1.field_trysafecdn), paramString2 });
      AppMethodBeat.o(78998);
      return bool;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, f.b paramb)
  {
    AppMethodBeat.i(78997);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.eCa().aBV(paramString2);
    if (localWebViewJSSDKFileItem != null)
    {
      localWebViewJSSDKFileItem.appId = paramString1;
      ac.i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", new Object[] { paramString1, paramString2, localWebViewJSSDKFileItem.dgl });
      paramb.a(true, 0, localWebViewJSSDKFileItem.dgl, localWebViewJSSDKFileItem.jAI, null, null);
      AppMethodBeat.o(78997);
      return true;
    }
    kv(paramString1, paramString2);
    this.CqE.add(paramb);
    AppMethodBeat.o(78997);
    return true;
  }
  
  public final void b(f.a parama)
  {
    AppMethodBeat.i(78994);
    if ((this.CqF != null) && (parama != null)) {
      this.CqF.remove(parama);
    }
    AppMethodBeat.o(78994);
  }
  
  public final void b(f.b paramb)
  {
    AppMethodBeat.i(78993);
    if ((this.CqE != null) && (paramb != null)) {
      this.CqE.remove(paramb);
    }
    AppMethodBeat.o(78993);
  }
  
  final void b(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(78996);
      ac.i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
      if ((this.CqF != null) && (this.CqF.size() > 0))
      {
        Iterator localIterator = this.CqF.iterator();
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
    ac.i("MicroMsg.WebviewFileChooserCdnService", "onSceneEnd, errType = %d, errCode = %d, funcType = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.getType()) });
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79003);
      return;
      com.tencent.mm.kernel.g.agi().b(1034, this);
      Object localObject1 = (ae)paramn;
      paramString = ((bsa)((ae)localObject1).rr.hvs.hvw).Fhf;
      paramn = ((ae)localObject1).appId;
      localObject1 = ((ae)localObject1).dgl;
      Object localObject2 = com.tencent.mm.plugin.webview.modeltools.g.eCa().aBU((String)localObject1);
      if (localObject2 == null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.i("MicroMsg.WebviewFileChooserCdnService", "get server server id : %s from server for appid : %s, localId = %s, item == null ? %b", new Object[] { paramString, paramn, localObject1, Boolean.valueOf(bool) });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label274;
        }
        if ((bs.isNullOrNil(paramn)) || (bs.isNullOrNil(paramString)) || (localObject2 == null)) {
          break;
        }
        ((WebViewJSSDKFileItem)localObject2).jAI = paramString;
        b(true, ((WebViewJSSDKFileItem)localObject2).mediaType, 100, ((WebViewJSSDKFileItem)localObject2).dgl, ((WebViewJSSDKFileItem)localObject2).jAI);
        b(true, 0, ((WebViewJSSDKFileItem)localObject2).dgl, ((WebViewJSSDKFileItem)localObject2).jAI, ((WebViewJSSDKFileItem)localObject2).GZW.field_fileUrl, null);
        AppMethodBeat.o(79003);
        return;
      }
      label274:
      ac.e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
      if (localObject2 != null)
      {
        b(false, 0, ((WebViewJSSDKFileItem)localObject2).dgl, ((WebViewJSSDKFileItem)localObject2).mediaId, null, null);
        AppMethodBeat.o(79003);
        return;
        com.tencent.mm.kernel.g.agi().b(1035, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (l)paramn;
          paramn = paramString.appId;
          localObject1 = paramString.jAI;
          localObject2 = ((brw)paramString.rr.hvs.hvw).Fhg;
          if (localObject2 == null)
          {
            bool = true;
            ac.i("MicroMsg.WebviewFileChooserCdnService", "appid = %s, serverId = %s, cdninfo == null ? %b", new Object[] { paramn, localObject1, Boolean.valueOf(bool) });
            if ((!bs.isNullOrNil(paramn)) && (!bs.isNullOrNil((String)localObject1)) && (localObject2 != null))
            {
              paramString = ((bru)localObject2).type;
              ac.i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", new Object[] { paramString });
              if (!bs.isNullOrNil(paramString))
              {
                if (!paramString.toLowerCase().equals("voice")) {
                  break label704;
                }
                paramString = WebViewJSSDKFileItem.aHG(aw.aCd(paramn));
                label476:
                paramString.jAK = false;
                paramString.appId = paramn;
                paramString.jAI = ((String)localObject1);
                if (paramString.GZW == null) {
                  paramString.GZW = new WebViewJSSDKFileItem.a();
                }
                if (localObject2 != null) {
                  break label769;
                }
                ac.e("MicroMsg.WebViewJSSDKFileItem", "jsapidcdn info is null");
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.webview.modeltools.g.eCa().a(paramString);
            paramn = new com.tencent.mm.i.g();
            paramn.frb = this.hIz;
            paramn.dBE = false;
            paramn.field_mediaId = paramString.mediaId;
            paramn.field_fullpath = paramString.jAH;
            paramn.field_totalLen = paramString.GZW.field_fileLength;
            paramn.field_fileType = a.MediaType_FILE;
            paramn.field_fileId = paramString.GZW.field_fileId;
            paramn.field_aesKey = paramString.GZW.field_aesKey;
            paramn.field_priority = a.fqp;
            paramn.field_needStorage = false;
            paramn.field_isStreamMedia = false;
            bool = f.aDD().b(paramn, -1);
            ac.i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", new Object[] { Boolean.valueOf(bool), paramString.jAI });
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
              paramString = WebViewJSSDKFileItem.aOK(aw.aBX(bs.eWj()));
              break label476;
            }
            paramString = WebViewJSSDKFileItem.aCp(aw.aBX(bs.eWj()));
            break label476;
            label769:
            paramString.GZW.field_aesKey = ((bru)localObject2).DZy;
            paramString.GZW.field_fileId = ((bru)localObject2).Fhd;
            paramString.GZW.field_fileLength = ((bru)localObject2).EnO;
          }
        }
        ac.e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
        b(false, 0, null, null, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.am
 * JD-Core Version:    0.7.0.1
 */