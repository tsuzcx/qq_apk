package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.an.b;
import com.tencent.mm.an.f;
import com.tencent.mm.i.a;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.ckt;
import com.tencent.mm.protocal.protobuf.ckv;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class an
  implements i
{
  private CopyOnWriteArraySet<f.b> IZg;
  private CopyOnWriteArraySet<f.a> IZh;
  private g.a iZc;
  
  public an()
  {
    AppMethodBeat.i(78990);
    this.IZh = new CopyOnWriteArraySet();
    this.IZg = new CopyOnWriteArraySet();
    this.iZc = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
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
          Log.i("MicroMsg.WebviewFileChooserCdnService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), localObject1, localObject2 });
          localObject1 = com.tencent.mm.plugin.webview.modeltools.g.gdv();
          if (!Util.isNullOrNil(paramAnonymousString)) {
            break label122;
          }
          Log.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByMediaID error, media id is null or nil");
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
          Log.e("MicroMsg.WebviewFileChooserCdnService", "get item by media id failed, media is : %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(78989);
          return 0;
          localObject1 = paramAnonymousc.toString();
          break;
          label112:
          localObject2 = paramAnonymousd.toString();
          break label22;
          label122:
          localObject2 = ((ao)localObject1).IZl.values().iterator();
          label137:
          if (!((Iterator)localObject2).hasNext()) {
            break label73;
          }
          localObject1 = (WebViewJSSDKFileItem)((Iterator)localObject2).next();
          if (!Util.nullAsNil(((WebViewJSSDKFileItem)localObject1).mediaId).equals(paramAnonymousString)) {
            break label72;
          }
        }
        label177:
        if (paramAnonymousInt == -21005)
        {
          Log.i("MicroMsg.WebviewFileChooserCdnService", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(78989);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.e("MicroMsg.WebviewFileChooserCdnService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          an.a(an.this, false, paramAnonymousInt, ((WebViewJSSDKFileItem)localObject1).dJX, ((WebViewJSSDKFileItem)localObject1).mediaId, null, null);
          AppMethodBeat.o(78989);
          return 0;
        }
        long l;
        if (paramAnonymousc != null)
        {
          Log.i("MicroMsg.WebviewFileChooserCdnService", "progressInfo : %s", new Object[] { paramAnonymousc.toString() });
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
          Log.d("MicroMsg.WebviewFileChooserCdnService", "progressInfo, percent = %d, finishLen = %d, totalLen = %d", new Object[] { Long.valueOf(l), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          an.this.b(((WebViewJSSDKFileItem)localObject1).laU, ((WebViewJSSDKFileItem)localObject1).mediaType, (int)l, ((WebViewJSSDKFileItem)localObject1).dJX, ((WebViewJSSDKFileItem)localObject1).mediaId);
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
              Log.e("MicroMsg.WebviewFileChooserCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
              an.a(an.this, false, paramAnonymousd.field_retCode, ((WebViewJSSDKFileItem)localObject1).dJX, ((WebViewJSSDKFileItem)localObject1).mediaId, null, null);
            }
            for (;;)
            {
              AppMethodBeat.o(78989);
              return 0;
              label490:
              Log.i("MicroMsg.WebviewFileChooserCdnService", "cdn trans suceess, media id : %s, item.mediaId : %s, item.localId: %s", new Object[] { paramAnonymousString, ((WebViewJSSDKFileItem)localObject1).mediaId, ((WebViewJSSDKFileItem)localObject1).dJX });
              if (localObject1 != null)
              {
                ((WebViewJSSDKFileItem)localObject1).d(paramAnonymousd);
                if ((((WebViewJSSDKFileItem)localObject1).laU) && (((WebViewJSSDKFileItem)localObject1).laW))
                {
                  paramAnonymousString = an.this;
                  if (localObject1 == null)
                  {
                    Log.e("MicroMsg.WebviewFileChooserCdnService", "uploadCdnInfo failed, item is null");
                  }
                  else
                  {
                    paramAnonymousc = new ckt();
                    paramAnonymousc.KRe = ((WebViewJSSDKFileItem)localObject1).UtF.field_aesKey;
                    paramAnonymousc.Lia = ((WebViewJSSDKFileItem)localObject1).UtF.field_fileLength;
                    paramAnonymousc.Mqu = ((WebViewJSSDKFileItem)localObject1).UtF.field_fileId;
                    paramAnonymousc.type = ((WebViewJSSDKFileItem)localObject1).getFileType();
                    Log.d("MicroMsg.WebviewFileChooserCdnService", "appId:%s, localId:%s, aes_key:%s， file_size:%d, fileId:%s", new Object[] { ((WebViewJSSDKFileItem)localObject1).appId, ((WebViewJSSDKFileItem)localObject1).dJX, paramAnonymousc.KRe, Integer.valueOf(paramAnonymousc.Lia), paramAnonymousc.Mqu });
                    paramAnonymousc.Mqv = ((WebViewJSSDKFileItem)localObject1).hdY();
                    com.tencent.mm.kernel.g.azz().a(1034, paramAnonymousString);
                    paramAnonymousString = new ae(((WebViewJSSDKFileItem)localObject1).appId, ((WebViewJSSDKFileItem)localObject1).dJX, paramAnonymousc);
                    com.tencent.mm.kernel.g.azz().a(paramAnonymousString, 0);
                  }
                }
                else
                {
                  an.a(an.this, true, 0, ((WebViewJSSDKFileItem)localObject1).dJX, ((WebViewJSSDKFileItem)localObject1).laS, ((WebViewJSSDKFileItem)localObject1).UtF.field_fileUrl, paramAnonymousd.field_thumbUrl);
                }
              }
            }
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(78987);
        Log.i("MicroMsg.WebviewFileChooserCdnService", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(78987);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(78988);
        Log.i("MicroMsg.WebviewFileChooserCdnService", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(78988);
        return null;
      }
    };
    AppMethodBeat.o(78990);
  }
  
  public static boolean WG(String paramString)
  {
    AppMethodBeat.i(79000);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(paramString);
    if (localWebViewJSSDKFileItem == null)
    {
      Log.e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString });
      AppMethodBeat.o(79000);
      return false;
    }
    boolean bool = f.baQ().Ob(localWebViewJSSDKFileItem.mediaId);
    AppMethodBeat.o(79000);
    return bool;
  }
  
  public static boolean aYI(String paramString)
  {
    AppMethodBeat.i(79001);
    Log.i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", new Object[] { paramString });
    boolean bool = f.baQ().Oc(paramString);
    AppMethodBeat.o(79001);
    return bool;
  }
  
  private void b(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      AppMethodBeat.i(78995);
      Log.d("MicroMsg.WebviewFileChooserCdnService", "notifyRequstCallback, localId : %s", new Object[] { paramString1 });
      if ((this.IZg != null) && (this.IZg.size() > 0))
      {
        Iterator localIterator = this.IZg.iterator();
        while (localIterator.hasNext()) {
          ((f.b)localIterator.next()).a(paramBoolean, paramInt, paramString1, paramString2, paramString3, paramString4);
        }
      }
      AppMethodBeat.o(78995);
    }
    finally {}
  }
  
  private void lZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79002);
    com.tencent.mm.kernel.g.azz().a(1035, this);
    paramString1 = new l(paramString1, paramString2);
    com.tencent.mm.kernel.g.azz().a(paramString1, 0);
    AppMethodBeat.o(79002);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(78992);
    if ((this.IZh != null) && (parama != null) && (!this.IZh.contains(parama))) {
      this.IZh.add(parama);
    }
    AppMethodBeat.o(78992);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(78991);
    if ((this.IZg != null) && (paramb != null) && (!this.IZg.contains(paramb))) {
      this.IZg.add(paramb);
    }
    AppMethodBeat.o(78991);
  }
  
  public final boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, f.b paramb)
  {
    AppMethodBeat.i(78998);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(paramString2);
    if (localWebViewJSSDKFileItem == null)
    {
      Log.e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString2 });
      AppMethodBeat.o(78998);
      return false;
    }
    localWebViewJSSDKFileItem.appId = paramString1;
    if (paramb != null) {
      this.IZg.add(paramb);
    }
    if ((paramInt2 == 202) || (paramInt2 == 214) || (paramInt2 == 215)) {
      localWebViewJSSDKFileItem.laW = false;
    }
    localWebViewJSSDKFileItem.laU = true;
    paramString1 = new com.tencent.mm.i.g();
    paramString1.taskName = "task_WebViewJSSDKCdnService_2";
    paramString1.gqy = this.iZc;
    paramString1.ehd = true;
    paramString1.field_mediaId = localWebViewJSSDKFileItem.mediaId;
    paramString1.field_fullpath = localWebViewJSSDKFileItem.laR;
    paramString1.field_fileType = paramInt1;
    paramString1.field_talker = "weixin";
    paramString1.field_priority = a.gpM;
    if ((paramInt1 == a.gpS) || (paramInt2 == 214)) {}
    for (paramString1.field_needStorage = true;; paramString1.field_needStorage = false)
    {
      paramString1.field_isStreamMedia = false;
      paramString1.field_appType = paramInt2;
      paramString1.field_bzScene = paramInt3;
      paramString1.field_force_aeskeycdn = true;
      paramString1.field_trysafecdn = false;
      paramString1.field_thumbpath = localWebViewJSSDKFileItem.lPx;
      if (paramInt2 == 214) {
        paramString1.snsVersion = 1;
      }
      boolean bool = f.baQ().f(paramString1);
      Log.i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramString1.field_force_aeskeycdn), Boolean.valueOf(paramString1.field_trysafecdn), paramString2 });
      AppMethodBeat.o(78998);
      return bool;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, f.b paramb)
  {
    AppMethodBeat.i(78997);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYP(paramString2);
    if (localWebViewJSSDKFileItem != null)
    {
      localWebViewJSSDKFileItem.appId = paramString1;
      Log.i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", new Object[] { paramString1, paramString2, localWebViewJSSDKFileItem.dJX });
      paramb.a(true, 0, localWebViewJSSDKFileItem.dJX, localWebViewJSSDKFileItem.laS, null, null);
      AppMethodBeat.o(78997);
      return true;
    }
    lZ(paramString1, paramString2);
    this.IZg.add(paramb);
    AppMethodBeat.o(78997);
    return true;
  }
  
  public final void b(f.a parama)
  {
    AppMethodBeat.i(78994);
    if ((this.IZh != null) && (parama != null)) {
      this.IZh.remove(parama);
    }
    AppMethodBeat.o(78994);
  }
  
  public final void b(f.b paramb)
  {
    AppMethodBeat.i(78993);
    if ((this.IZg != null) && (paramb != null)) {
      this.IZg.remove(paramb);
    }
    AppMethodBeat.o(78993);
  }
  
  final void b(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(78996);
      Log.i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
      if ((this.IZh != null) && (this.IZh.size() > 0))
      {
        Iterator localIterator = this.IZh.iterator();
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(79003);
    Log.i("MicroMsg.WebviewFileChooserCdnService", "onSceneEnd, errType = %d, errCode = %d, funcType = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramq.getType()) });
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79003);
      return;
      com.tencent.mm.kernel.g.azz().b(1034, this);
      Object localObject1 = (ae)paramq;
      paramString = ((ckz)((ae)localObject1).rr.iLL.iLR).Mqw;
      paramq = ((ae)localObject1).appId;
      localObject1 = ((ae)localObject1).dJX;
      Object localObject2 = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO((String)localObject1);
      if (localObject2 == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.WebviewFileChooserCdnService", "get server server id : %s from server for appid : %s, localId = %s, item == null ? %b", new Object[] { paramString, paramq, localObject1, Boolean.valueOf(bool) });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label274;
        }
        if ((Util.isNullOrNil(paramq)) || (Util.isNullOrNil(paramString)) || (localObject2 == null)) {
          break;
        }
        ((WebViewJSSDKFileItem)localObject2).laS = paramString;
        b(true, ((WebViewJSSDKFileItem)localObject2).mediaType, 100, ((WebViewJSSDKFileItem)localObject2).dJX, ((WebViewJSSDKFileItem)localObject2).laS);
        b(true, 0, ((WebViewJSSDKFileItem)localObject2).dJX, ((WebViewJSSDKFileItem)localObject2).laS, ((WebViewJSSDKFileItem)localObject2).UtF.field_fileUrl, null);
        AppMethodBeat.o(79003);
        return;
      }
      label274:
      Log.e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
      if (localObject2 != null)
      {
        b(false, 0, ((WebViewJSSDKFileItem)localObject2).dJX, ((WebViewJSSDKFileItem)localObject2).mediaId, null, null);
        AppMethodBeat.o(79003);
        return;
        com.tencent.mm.kernel.g.azz().b(1035, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (l)paramq;
          paramq = paramString.appId;
          localObject1 = paramString.laS;
          localObject2 = ((ckv)paramString.rr.iLL.iLR).Mqx;
          if (localObject2 == null)
          {
            bool = true;
            Log.i("MicroMsg.WebviewFileChooserCdnService", "appid = %s, serverId = %s, cdninfo == null ? %b", new Object[] { paramq, localObject1, Boolean.valueOf(bool) });
            if ((!Util.isNullOrNil(paramq)) && (!Util.isNullOrNil((String)localObject1)) && (localObject2 != null))
            {
              paramString = ((ckt)localObject2).type;
              Log.i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", new Object[] { paramString });
              if (!Util.isNullOrNil(paramString))
              {
                if (!paramString.toLowerCase().equals("voice")) {
                  break label712;
                }
                paramString = WebViewJSSDKFileItem.bxf(ay.aZb(paramq));
                label476:
                paramString.laU = false;
                paramString.appId = paramq;
                paramString.laS = ((String)localObject1);
                if (paramString.UtF == null) {
                  paramString.UtF = new WebViewJSSDKFileItem.a();
                }
                if (localObject2 != null) {
                  break label777;
                }
                Log.e("MicroMsg.WebViewJSSDKFileItem", "jsapidcdn info is null");
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.webview.modeltools.g.gdv().a(paramString);
            paramq = new com.tencent.mm.i.g();
            paramq.taskName = "task_WebViewJSSDKCdnService_1";
            paramq.gqy = this.iZc;
            paramq.ehd = false;
            paramq.field_mediaId = paramString.mediaId;
            paramq.field_fullpath = paramString.laR;
            paramq.field_totalLen = paramString.UtF.field_fileLength;
            paramq.field_fileType = a.MediaType_FILE;
            paramq.field_fileId = paramString.UtF.field_fileId;
            paramq.field_aesKey = paramString.UtF.field_aesKey;
            paramq.field_priority = a.gpM;
            paramq.field_needStorage = false;
            paramq.field_isStreamMedia = false;
            bool = f.baQ().b(paramq, -1);
            Log.i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", new Object[] { Boolean.valueOf(bool), paramString.laS });
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
              paramString = WebViewJSSDKFileItem.bxg(ay.aYW(Util.nowMilliSecond()));
              break label476;
            }
            paramString = WebViewJSSDKFileItem.bxe(ay.aYW(Util.nowMilliSecond()));
            break label476;
            label777:
            paramString.UtF.field_aesKey = ((ckt)localObject2).KRe;
            paramString.UtF.field_fileId = ((ckt)localObject2).Mqu;
            paramString.UtF.field_fileLength = ((ckt)localObject2).Lia;
          }
        }
        Log.e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
        b(false, 0, null, null, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.an
 * JD-Core Version:    0.7.0.1
 */