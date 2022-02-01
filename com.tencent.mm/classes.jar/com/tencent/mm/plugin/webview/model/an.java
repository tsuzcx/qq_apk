package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.g.a;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.protocal.protobuf.dko;
import com.tencent.mm.protocal.protobuf.dkq;
import com.tencent.mm.protocal.protobuf.dku;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class an
  implements com.tencent.mm.am.h
{
  private CopyOnWriteArraySet<f.b> WMf;
  private CopyOnWriteArraySet<f.a> WMg;
  private g.a osH;
  
  public an()
  {
    AppMethodBeat.i(78990);
    this.WMg = new CopyOnWriteArraySet();
    this.WMf = new CopyOnWriteArraySet();
    this.osH = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
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
          localObject1 = com.tencent.mm.plugin.webview.modeltools.g.ivZ();
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
          localObject2 = ((ao)localObject1).WMk.values().iterator();
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
          an.a(an.this, false, paramAnonymousInt, ((WebViewJSSDKFileItem)localObject1).hHB, ((WebViewJSSDKFileItem)localObject1).mediaId, null, null);
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
          an.a(an.this, ((WebViewJSSDKFileItem)localObject1).qUN, ((WebViewJSSDKFileItem)localObject1).mediaType, (int)l, ((WebViewJSSDKFileItem)localObject1).hHB, ((WebViewJSSDKFileItem)localObject1).mediaId);
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
              an.a(an.this, false, paramAnonymousd.field_retCode, ((WebViewJSSDKFileItem)localObject1).hHB, ((WebViewJSSDKFileItem)localObject1).mediaId, null, null);
            }
            for (;;)
            {
              AppMethodBeat.o(78989);
              return 0;
              label490:
              Log.i("MicroMsg.WebviewFileChooserCdnService", "cdn trans suceess, media id : %s, item.mediaId : %s, item.localId: %s", new Object[] { paramAnonymousString, ((WebViewJSSDKFileItem)localObject1).mediaId, ((WebViewJSSDKFileItem)localObject1).hHB });
              if (localObject1 != null)
              {
                ((WebViewJSSDKFileItem)localObject1).d(paramAnonymousd);
                if ((((WebViewJSSDKFileItem)localObject1).qUN) && (((WebViewJSSDKFileItem)localObject1).qUP)) {
                  an.a(an.this, (WebViewJSSDKFileItem)localObject1);
                } else {
                  an.a(an.this, true, 0, ((WebViewJSSDKFileItem)localObject1).hHB, ((WebViewJSSDKFileItem)localObject1).qUL, ((WebViewJSSDKFileItem)localObject1).akjx.field_fileUrl, paramAnonymousd.field_thumbUrl);
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
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(78988);
        Log.i("MicroMsg.WebviewFileChooserCdnService", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(78988);
        return null;
      }
    };
    AppMethodBeat.o(78990);
  }
  
  public static boolean WU(String paramString)
  {
    AppMethodBeat.i(79000);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.ivZ().bks(paramString);
    if (localWebViewJSSDKFileItem == null)
    {
      Log.e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString });
      AppMethodBeat.o(79000);
      return false;
    }
    boolean bool = k.bHW().Ny(localWebViewJSSDKFileItem.mediaId);
    AppMethodBeat.o(79000);
    return bool;
  }
  
  private void b(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(78996);
      Log.i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
      if ((this.WMg != null) && (this.WMg.size() > 0))
      {
        Iterator localIterator = this.WMg.iterator();
        while (localIterator.hasNext()) {
          ((f.a)localIterator.next()).a(paramBoolean, paramInt1, paramInt2, paramString1, paramString2);
        }
      }
      AppMethodBeat.o(78996);
    }
    finally {}
  }
  
  private void b(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      AppMethodBeat.i(78995);
      Log.d("MicroMsg.WebviewFileChooserCdnService", "notifyRequstCallback, localId : %s", new Object[] { paramString1 });
      if ((this.WMf != null) && (this.WMf.size() > 0))
      {
        Iterator localIterator = this.WMf.iterator();
        while (localIterator.hasNext()) {
          ((f.b)localIterator.next()).a(paramBoolean, paramInt, paramString1, paramString2, paramString3, paramString4);
        }
      }
      AppMethodBeat.o(78995);
    }
    finally {}
  }
  
  public static boolean bkn(String paramString)
  {
    AppMethodBeat.i(79001);
    Log.i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", new Object[] { paramString });
    boolean bool = k.bHW().Nz(paramString);
    AppMethodBeat.o(79001);
    return bool;
  }
  
  private void op(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79002);
    com.tencent.mm.kernel.h.aZW().a(1035, this);
    paramString1 = new l(paramString1, paramString2);
    com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
    AppMethodBeat.o(79002);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(78992);
    if ((this.WMg != null) && (parama != null) && (!this.WMg.contains(parama))) {
      this.WMg.add(parama);
    }
    AppMethodBeat.o(78992);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(78991);
    if ((this.WMf != null) && (paramb != null) && (!this.WMf.contains(paramb))) {
      this.WMf.add(paramb);
    }
    AppMethodBeat.o(78991);
  }
  
  public final boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, f.b paramb)
  {
    AppMethodBeat.i(78998);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.ivZ().bks(paramString2);
    if (localWebViewJSSDKFileItem == null)
    {
      Log.e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString2 });
      AppMethodBeat.o(78998);
      return false;
    }
    localWebViewJSSDKFileItem.appId = paramString1;
    if (paramb != null) {
      this.WMf.add(paramb);
    }
    if ((paramInt2 == 202) || (paramInt2 == 214) || (paramInt2 == 215)) {
      localWebViewJSSDKFileItem.qUP = false;
    }
    localWebViewJSSDKFileItem.qUN = true;
    paramString1 = new com.tencent.mm.g.g();
    paramString1.taskName = "task_WebViewJSSDKCdnService_2";
    paramString1.lwL = this.osH;
    paramString1.ihD = true;
    paramString1.field_mediaId = localWebViewJSSDKFileItem.mediaId;
    paramString1.field_fullpath = localWebViewJSSDKFileItem.qUK;
    paramString1.field_fileType = paramInt1;
    paramString1.field_talker = "weixin";
    paramString1.field_priority = a.lvZ;
    if ((paramInt1 == a.lwf) || (paramInt2 == 214)) {}
    for (paramString1.field_needStorage = true;; paramString1.field_needStorage = false)
    {
      paramString1.field_isStreamMedia = false;
      paramString1.field_appType = paramInt2;
      paramString1.field_bzScene = paramInt3;
      paramString1.field_force_aeskeycdn = true;
      paramString1.field_trysafecdn = false;
      paramString1.field_thumbpath = localWebViewJSSDKFileItem.rPM;
      if (paramInt2 == 214) {
        paramString1.snsVersion = 1;
      }
      boolean bool = k.bHW().g(paramString1);
      Log.i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramString1.field_force_aeskeycdn), Boolean.valueOf(paramString1.field_trysafecdn), paramString2 });
      AppMethodBeat.o(78998);
      return bool;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, f.b paramb)
  {
    AppMethodBeat.i(78997);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.ivZ().bkt(paramString2);
    if (localWebViewJSSDKFileItem != null)
    {
      localWebViewJSSDKFileItem.appId = paramString1;
      Log.i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", new Object[] { paramString1, paramString2, localWebViewJSSDKFileItem.hHB });
      paramb.a(true, 0, localWebViewJSSDKFileItem.hHB, localWebViewJSSDKFileItem.qUL, null, null);
      AppMethodBeat.o(78997);
      return true;
    }
    op(paramString1, paramString2);
    this.WMf.add(paramb);
    AppMethodBeat.o(78997);
    return true;
  }
  
  public final void b(f.a parama)
  {
    AppMethodBeat.i(78994);
    if ((this.WMg != null) && (parama != null)) {
      this.WMg.remove(parama);
    }
    AppMethodBeat.o(78994);
  }
  
  public final void b(f.b paramb)
  {
    AppMethodBeat.i(78993);
    if ((this.WMf != null) && (paramb != null)) {
      this.WMf.remove(paramb);
    }
    AppMethodBeat.o(78993);
  }
  
  public final boolean b(String paramString1, String paramString2, f.b paramb)
  {
    AppMethodBeat.i(78999);
    boolean bool = a(paramString1, paramString2, a.MediaType_FILE, 0, 0, paramb);
    AppMethodBeat.o(78999);
    return bool;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(79003);
    Log.i("MicroMsg.WebviewFileChooserCdnService", "onSceneEnd, errType = %d, errCode = %d, funcType = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramp.getType()) });
    switch (paramp.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79003);
      return;
      com.tencent.mm.kernel.h.aZW().b(1034, this);
      Object localObject1 = (ae)paramp;
      paramString = ((dku)c.c.b(((ae)localObject1).rr.otC)).aaQN;
      paramp = ((ae)localObject1).appId;
      localObject1 = ((ae)localObject1).hHB;
      Object localObject2 = com.tencent.mm.plugin.webview.modeltools.g.ivZ().bks((String)localObject1);
      if (localObject2 == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.WebviewFileChooserCdnService", "get server server id : %s from server for appid : %s, localId = %s, item == null ? %b", new Object[] { paramString, paramp, localObject1, Boolean.valueOf(bool) });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label274;
        }
        if ((Util.isNullOrNil(paramp)) || (Util.isNullOrNil(paramString)) || (localObject2 == null)) {
          break;
        }
        ((WebViewJSSDKFileItem)localObject2).qUL = paramString;
        b(true, ((WebViewJSSDKFileItem)localObject2).mediaType, 100, ((WebViewJSSDKFileItem)localObject2).hHB, ((WebViewJSSDKFileItem)localObject2).qUL);
        b(true, 0, ((WebViewJSSDKFileItem)localObject2).hHB, ((WebViewJSSDKFileItem)localObject2).qUL, ((WebViewJSSDKFileItem)localObject2).akjx.field_fileUrl, null);
        AppMethodBeat.o(79003);
        return;
      }
      label274:
      Log.e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
      if (localObject2 != null)
      {
        b(false, 0, ((WebViewJSSDKFileItem)localObject2).hHB, ((WebViewJSSDKFileItem)localObject2).mediaId, null, null);
        AppMethodBeat.o(79003);
        return;
        com.tencent.mm.kernel.h.aZW().b(1035, this);
        paramString = (l)paramp;
        paramp = paramString.qUL;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject1 = paramString.appId;
          localObject2 = ((dkq)c.c.b(paramString.rr.otC)).aaQO;
          if (localObject2 == null)
          {
            bool = true;
            Log.i("MicroMsg.WebviewFileChooserCdnService", "appid = %s, serverId = %s, cdninfo == null ? %b", new Object[] { localObject1, paramp, Boolean.valueOf(bool) });
            if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(paramp)) && (localObject2 != null))
            {
              paramString = ((dko)localObject2).type;
              Log.i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", new Object[] { paramString });
              if (!Util.isNullOrNil(paramString))
              {
                if (!paramString.toLowerCase().equals("voice")) {
                  break label712;
                }
                paramString = WebViewJSSDKFileItem.bLC(az.bkE((String)localObject1));
                label476:
                paramString.qUN = false;
                paramString.appId = ((String)localObject1);
                paramString.qUL = paramp;
                if (paramString.akjx == null) {
                  paramString.akjx = new WebViewJSSDKFileItem.a();
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
            com.tencent.mm.plugin.webview.modeltools.g.ivZ().a(paramString);
            paramp = new com.tencent.mm.g.g();
            paramp.taskName = "task_WebViewJSSDKCdnService_1";
            paramp.lwL = this.osH;
            paramp.ihD = false;
            paramp.field_mediaId = paramString.mediaId;
            paramp.field_fullpath = paramString.qUK;
            paramp.field_totalLen = paramString.akjx.field_fileLength;
            paramp.field_fileType = a.MediaType_FILE;
            paramp.field_fileId = paramString.akjx.field_fileId;
            paramp.field_aesKey = paramString.akjx.field_aesKey;
            paramp.field_priority = a.lvZ;
            paramp.field_needStorage = false;
            paramp.field_isStreamMedia = false;
            bool = k.bHW().b(paramp, -1);
            Log.i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", new Object[] { Boolean.valueOf(bool), paramString.qUL });
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
              paramString = WebViewJSSDKFileItem.bLD(az.getFilePath(Util.nowMilliSecond()));
              break label476;
            }
            paramString = WebViewJSSDKFileItem.bLB(az.getFilePath(Util.nowMilliSecond()));
            break label476;
            label777:
            paramString.akjx.field_aesKey = ((dko)localObject2).YPz;
            paramString.akjx.field_fileId = ((dko)localObject2).aaQL;
            paramString.akjx.field_fileLength = ((dko)localObject2).Zhu;
          }
        }
        Log.e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
        b(false, 0, null, paramp, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.an
 * JD-Core Version:    0.7.0.1
 */