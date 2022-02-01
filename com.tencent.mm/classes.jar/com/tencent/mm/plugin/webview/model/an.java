package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.aq.b;
import com.tencent.mm.i.a;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.ctm;
import com.tencent.mm.protocal.protobuf.cto;
import com.tencent.mm.protocal.protobuf.cts;
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
  private CopyOnWriteArraySet<f.b> PVy;
  private CopyOnWriteArraySet<f.a> PVz;
  private g.a lPx;
  
  public an()
  {
    AppMethodBeat.i(78990);
    this.PVz = new CopyOnWriteArraySet();
    this.PVy = new CopyOnWriteArraySet();
    this.lPx = new g.a()
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
          localObject1 = com.tencent.mm.plugin.webview.modeltools.f.gWt();
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
          localObject2 = ((ao)localObject1).PVD.values().iterator();
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
          an.a(an.this, false, paramAnonymousInt, ((WebViewJSSDKFileItem)localObject1).fCM, ((WebViewJSSDKFileItem)localObject1).mediaId, null, null);
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
          an.a(an.this, ((WebViewJSSDKFileItem)localObject1).nVd, ((WebViewJSSDKFileItem)localObject1).mediaType, (int)l, ((WebViewJSSDKFileItem)localObject1).fCM, ((WebViewJSSDKFileItem)localObject1).mediaId);
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
              an.a(an.this, false, paramAnonymousd.field_retCode, ((WebViewJSSDKFileItem)localObject1).fCM, ((WebViewJSSDKFileItem)localObject1).mediaId, null, null);
            }
            for (;;)
            {
              AppMethodBeat.o(78989);
              return 0;
              label490:
              Log.i("MicroMsg.WebviewFileChooserCdnService", "cdn trans suceess, media id : %s, item.mediaId : %s, item.localId: %s", new Object[] { paramAnonymousString, ((WebViewJSSDKFileItem)localObject1).mediaId, ((WebViewJSSDKFileItem)localObject1).fCM });
              if (localObject1 != null)
              {
                ((WebViewJSSDKFileItem)localObject1).d(paramAnonymousd);
                if ((((WebViewJSSDKFileItem)localObject1).nVd) && (((WebViewJSSDKFileItem)localObject1).nVf)) {
                  an.a(an.this, (WebViewJSSDKFileItem)localObject1);
                } else {
                  an.a(an.this, true, 0, ((WebViewJSSDKFileItem)localObject1).fCM, ((WebViewJSSDKFileItem)localObject1).nVb, ((WebViewJSSDKFileItem)localObject1).SuJ.field_fileUrl, paramAnonymousd.field_thumbUrl);
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
  
  public static boolean aer(String paramString)
  {
    AppMethodBeat.i(79000);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.f.gWt().bkI(paramString);
    if (localWebViewJSSDKFileItem == null)
    {
      Log.e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString });
      AppMethodBeat.o(79000);
      return false;
    }
    boolean bool = com.tencent.mm.aq.f.bkg().Vy(localWebViewJSSDKFileItem.mediaId);
    AppMethodBeat.o(79000);
    return bool;
  }
  
  private void b(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(78996);
      Log.i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
      if ((this.PVz != null) && (this.PVz.size() > 0))
      {
        Iterator localIterator = this.PVz.iterator();
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
      if ((this.PVy != null) && (this.PVy.size() > 0))
      {
        Iterator localIterator = this.PVy.iterator();
        while (localIterator.hasNext()) {
          ((f.b)localIterator.next()).a(paramBoolean, paramInt, paramString1, paramString2, paramString3, paramString4);
        }
      }
      AppMethodBeat.o(78995);
    }
    finally {}
  }
  
  public static boolean bkC(String paramString)
  {
    AppMethodBeat.i(79001);
    Log.i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", new Object[] { paramString });
    boolean bool = com.tencent.mm.aq.f.bkg().Vz(paramString);
    AppMethodBeat.o(79001);
    return bool;
  }
  
  private void mz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79002);
    h.aGY().a(1035, this);
    paramString1 = new l(paramString1, paramString2);
    h.aGY().a(paramString1, 0);
    AppMethodBeat.o(79002);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(78992);
    if ((this.PVz != null) && (parama != null) && (!this.PVz.contains(parama))) {
      this.PVz.add(parama);
    }
    AppMethodBeat.o(78992);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(78991);
    if ((this.PVy != null) && (paramb != null) && (!this.PVy.contains(paramb))) {
      this.PVy.add(paramb);
    }
    AppMethodBeat.o(78991);
  }
  
  public final boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, f.b paramb)
  {
    AppMethodBeat.i(78998);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.f.gWt().bkI(paramString2);
    if (localWebViewJSSDKFileItem == null)
    {
      Log.e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString2 });
      AppMethodBeat.o(78998);
      return false;
    }
    localWebViewJSSDKFileItem.appId = paramString1;
    if (paramb != null) {
      this.PVy.add(paramb);
    }
    if ((paramInt2 == 202) || (paramInt2 == 214) || (paramInt2 == 215)) {
      localWebViewJSSDKFileItem.nVf = false;
    }
    localWebViewJSSDKFileItem.nVd = true;
    paramString1 = new g();
    paramString1.taskName = "task_WebViewJSSDKCdnService_2";
    paramString1.iUG = this.lPx;
    paramString1.gbt = true;
    paramString1.field_mediaId = localWebViewJSSDKFileItem.mediaId;
    paramString1.field_fullpath = localWebViewJSSDKFileItem.nVa;
    paramString1.field_fileType = paramInt1;
    paramString1.field_talker = "weixin";
    paramString1.field_priority = a.iTU;
    if ((paramInt1 == a.iUa) || (paramInt2 == 214)) {}
    for (paramString1.field_needStorage = true;; paramString1.field_needStorage = false)
    {
      paramString1.field_isStreamMedia = false;
      paramString1.field_appType = paramInt2;
      paramString1.field_bzScene = paramInt3;
      paramString1.field_force_aeskeycdn = true;
      paramString1.field_trysafecdn = false;
      paramString1.field_thumbpath = localWebViewJSSDKFileItem.oLR;
      if (paramInt2 == 214) {
        paramString1.snsVersion = 1;
      }
      boolean bool = com.tencent.mm.aq.f.bkg().f(paramString1);
      Log.i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramString1.field_force_aeskeycdn), Boolean.valueOf(paramString1.field_trysafecdn), paramString2 });
      AppMethodBeat.o(78998);
      return bool;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, f.b paramb)
  {
    AppMethodBeat.i(78997);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.f.gWt().bkJ(paramString2);
    if (localWebViewJSSDKFileItem != null)
    {
      localWebViewJSSDKFileItem.appId = paramString1;
      Log.i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", new Object[] { paramString1, paramString2, localWebViewJSSDKFileItem.fCM });
      paramb.a(true, 0, localWebViewJSSDKFileItem.fCM, localWebViewJSSDKFileItem.nVb, null, null);
      AppMethodBeat.o(78997);
      return true;
    }
    mz(paramString1, paramString2);
    this.PVy.add(paramb);
    AppMethodBeat.o(78997);
    return true;
  }
  
  public final void b(f.a parama)
  {
    AppMethodBeat.i(78994);
    if ((this.PVz != null) && (parama != null)) {
      this.PVz.remove(parama);
    }
    AppMethodBeat.o(78994);
  }
  
  public final void b(f.b paramb)
  {
    AppMethodBeat.i(78993);
    if ((this.PVy != null) && (paramb != null)) {
      this.PVy.remove(paramb);
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
      h.aGY().b(1034, this);
      Object localObject1 = (ae)paramq;
      paramString = ((cts)d.c.b(((ae)localObject1).rr.lBS)).TBz;
      paramq = ((ae)localObject1).appId;
      localObject1 = ((ae)localObject1).fCM;
      Object localObject2 = com.tencent.mm.plugin.webview.modeltools.f.gWt().bkI((String)localObject1);
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
        ((WebViewJSSDKFileItem)localObject2).nVb = paramString;
        b(true, ((WebViewJSSDKFileItem)localObject2).mediaType, 100, ((WebViewJSSDKFileItem)localObject2).fCM, ((WebViewJSSDKFileItem)localObject2).nVb);
        b(true, 0, ((WebViewJSSDKFileItem)localObject2).fCM, ((WebViewJSSDKFileItem)localObject2).nVb, ((WebViewJSSDKFileItem)localObject2).SuJ.field_fileUrl, null);
        AppMethodBeat.o(79003);
        return;
      }
      label274:
      Log.e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
      if (localObject2 != null)
      {
        b(false, 0, ((WebViewJSSDKFileItem)localObject2).fCM, ((WebViewJSSDKFileItem)localObject2).mediaId, null, null);
        AppMethodBeat.o(79003);
        return;
        h.aGY().b(1035, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (l)paramq;
          paramq = paramString.appId;
          localObject1 = paramString.nVb;
          localObject2 = ((cto)d.c.b(paramString.rr.lBS)).TBA;
          if (localObject2 == null)
          {
            bool = true;
            Log.i("MicroMsg.WebviewFileChooserCdnService", "appid = %s, serverId = %s, cdninfo == null ? %b", new Object[] { paramq, localObject1, Boolean.valueOf(bool) });
            if ((!Util.isNullOrNil(paramq)) && (!Util.isNullOrNil((String)localObject1)) && (localObject2 != null))
            {
              paramString = ((ctm)localObject2).type;
              Log.i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", new Object[] { paramString });
              if (!Util.isNullOrNil(paramString))
              {
                if (!paramString.toLowerCase().equals("voice")) {
                  break label712;
                }
                paramString = WebViewJSSDKFileItem.bII(az.bkV(paramq));
                label476:
                paramString.nVd = false;
                paramString.appId = paramq;
                paramString.nVb = ((String)localObject1);
                if (paramString.SuJ == null) {
                  paramString.SuJ = new WebViewJSSDKFileItem.a();
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
            com.tencent.mm.plugin.webview.modeltools.f.gWt().a(paramString);
            paramq = new g();
            paramq.taskName = "task_WebViewJSSDKCdnService_1";
            paramq.iUG = this.lPx;
            paramq.gbt = false;
            paramq.field_mediaId = paramString.mediaId;
            paramq.field_fullpath = paramString.nVa;
            paramq.field_totalLen = paramString.SuJ.field_fileLength;
            paramq.field_fileType = a.MediaType_FILE;
            paramq.field_fileId = paramString.SuJ.field_fileId;
            paramq.field_aesKey = paramString.SuJ.field_aesKey;
            paramq.field_priority = a.iTU;
            paramq.field_needStorage = false;
            paramq.field_isStreamMedia = false;
            bool = com.tencent.mm.aq.f.bkg().b(paramq, -1);
            Log.i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", new Object[] { Boolean.valueOf(bool), paramString.nVb });
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
              paramString = WebViewJSSDKFileItem.bIJ(az.getFilePath(Util.nowMilliSecond()));
              break label476;
            }
            paramString = WebViewJSSDKFileItem.bIH(az.getFilePath(Util.nowMilliSecond()));
            break label476;
            label777:
            paramString.SuJ.field_aesKey = ((ctm)localObject2).RRZ;
            paramString.SuJ.field_fileId = ((ctm)localObject2).TBx;
            paramString.SuJ.field_fileLength = ((ctm)localObject2).Sjq;
          }
        }
        Log.e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
        b(false, 0, null, null, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.an
 * JD-Core Version:    0.7.0.1
 */