package com.tencent.mm.plugin.selectrecord.e;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.messenger.PluginMessenger;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.b.e;
import com.tencent.mm.plugin.messenger.f.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.selectrecord.b.c.a;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  extends com.tencent.mm.plugin.messenger.f.b
  implements a
{
  private static final Map<String, czy> PmL;
  private static g.a osH;
  private static final Map<Long, a> vcA;
  private String PmJ;
  private String PmK;
  private long hTh;
  private boolean isLoading = false;
  private ProgressDialog lzP = null;
  private WeakReference<Context> tLO;
  private String talker;
  
  static
  {
    AppMethodBeat.i(266767);
    PmL = new ConcurrentHashMap();
    vcA = new ConcurrentHashMap();
    osH = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(266703);
        Log.i("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "cdn callback, id: %s, ret: %s, sceneResult: %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousd });
        if (paramAnonymousd != null) {
          try
          {
            if (paramAnonymousd.field_retCode == 0)
            {
              paramAnonymousString = (czy)b.aYC().get(paramAnonymousString);
              if (paramAnonymousString == null) {
                Log.e("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "cdn callback, info is null??");
              }
              for (;;)
              {
                AppMethodBeat.o(266703);
                return 0;
                paramAnonymousString.state = 1;
                paramAnonymousd = y.bi(paramAnonymousString.filePath, 0, -1);
                if (!paramAnonymousString.aaFs) {
                  break;
                }
                paramAnonymousc = new ze();
                paramAnonymousc.parseFrom(paramAnonymousd);
                paramAnonymousd = com.tencent.mm.plugin.selectrecord.b.c.PmA;
                c.a.a(paramAnonymousc, paramAnonymousString);
                Log.i("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "cdn callback， msg size:%s", new Object[] { Integer.valueOf(paramAnonymousc.PmC.size()) });
              }
              AppMethodBeat.o(266703);
            }
          }
          catch (Exception paramAnonymousString)
          {
            Log.e("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "callback %s %s", new Object[] { paramAnonymousString.getClass().getSimpleName(), paramAnonymousString.getMessage() });
          }
        }
        for (;;)
        {
          return 0;
          paramAnonymousc = new String(paramAnonymousd);
          paramAnonymousd = b.ui(paramAnonymousString.msgId);
          if (y.ZC(paramAnonymousd)) {
            y.deleteFile(paramAnonymousd);
          }
          long l = y.O(paramAnonymousString.filePath, paramAnonymousd, false);
          paramAnonymousBoolean = y.deleteFile(paramAnonymousString.filePath);
          Log.i("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "cdn callback, msgId:%s filePath:%s xml:%s result:%s delResult:%s", new Object[] { Long.valueOf(paramAnonymousString.msgId), paramAnonymousString.filePath, Util.secPrint(paramAnonymousc), Long.valueOf(l), Boolean.valueOf(paramAnonymousBoolean) });
          paramAnonymousd = (a)b.aCw().get(Long.valueOf(paramAnonymousString.msgId));
          if (paramAnonymousd == null) {
            break;
          }
          paramAnonymousd.af(paramAnonymousString.msgId, paramAnonymousc);
          break;
          if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode != 0))
          {
            paramAnonymousString = (czy)b.aYC().get(paramAnonymousString);
            if (paramAnonymousString != null) {
              paramAnonymousString.state = 2;
            }
          }
          if (paramAnonymousc != null) {
            Log.i("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "cdn process: %f", new Object[] { Double.valueOf(paramAnonymousc.field_finishedLength / paramAnonymousc.field_toltalLength) });
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(266681);
        Log.i("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(266681);
      }
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(266686);
        Log.i("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(266686);
        return null;
      }
    };
    AppMethodBeat.o(266767);
  }
  
  public b(b.b paramb)
  {
    super(paramb);
  }
  
  private static void a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(266687);
    Log.i("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "gotoRecordDetailUI msgId:%s msgSvrId:%s sendUserName:%s talker:%s xml:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Util.nullAs(paramString1, ""), Util.nullAs(paramString2, ""), Util.secPrint(paramString3) });
    paramString3 = k.b.Hf(paramString3);
    if (paramString3 == null)
    {
      Log.e("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "gotoRecordDetailUI content is null???");
      AppMethodBeat.o(266687);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("message_id", paramLong1);
    localIntent.putExtra("record_xml", paramString3.nRF);
    localIntent.putExtra("record_show_share", false);
    localIntent.putExtra("from_scene", 2);
    localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
    localIntent.putExtra("preUsername", paramString1);
    localIntent.putExtra("preChatName", paramString2);
    localIntent.putExtra("preChatTYPE", 2);
    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
    AppMethodBeat.o(266687);
  }
  
  public static boolean a(cc paramcc, Map<String, String> paramMap, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(266713);
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "parseNewLinkHistory() called with: msgInfo = [" + paramcc + "], values = [" + paramMap + "], head = [" + paramString1 + "], templateType = [" + paramString2 + "], callback = [" + parama + "] stack:[" + Util.getStack() + "]");
    }
    long l = paramcc.field_msgId;
    if (parama != null) {
      vcA.put(Long.valueOf(l), parama);
    }
    boolean bool1;
    String str1;
    if (Util.isEqual(paramString2, "tmpl_type_profilewithrevoke"))
    {
      bool1 = false;
      paramString2 = Util.nullAs((String)paramMap.get(paramString1 + ".fileid"), "");
      parama = Util.nullAs((String)paramMap.get(paramString1 + ".aeskey"), "");
      str1 = Util.nullAs((String)paramMap.get(paramString1 + ".filelength"), "");
      Util.nullAs((String)paramMap.get(paramString1 + ".msgcount"), "");
      if (!Util.isNullOrNil(paramString2)) {
        break label948;
      }
      bool1 = false;
      paramString2 = Util.nullAs((String)paramMap.get(paramString1 + ".fileid"), "");
      parama = Util.nullAs((String)paramMap.get(paramString1 + ".aeskey"), "");
      str1 = Util.nullAs((String)paramMap.get(paramString1 + ".filelength"), "");
      Util.nullAs((String)paramMap.get(paramString1 + ".msgcount"), "");
    }
    label948:
    for (;;)
    {
      paramMap = Util.nullAs((String)paramMap.get(paramString1 + ".historyid"), "");
      paramString1 = PluginMessenger.getAccSelectRecordPath() + "downloadcache/";
      if (!y.ZC(paramString1)) {
        y.bDX(paramString1);
      }
      paramString1 = paramString1 + l;
      if (y.ZC(paramString1)) {
        y.deleteFile(paramString1);
      }
      String str2 = com.tencent.mm.b.g.getMessageDigest((Util.currentTicks() + ", " + l).getBytes());
      com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
      localg.lwL = osH;
      localg.ihD = false;
      localg.field_mediaId = str2;
      localg.field_fullpath = paramString1;
      localg.field_totalLen = Integer.parseInt(str1);
      localg.field_fileType = com.tencent.mm.g.a.MediaType_FILE;
      localg.field_fileId = paramString2;
      localg.field_aesKey = parama;
      localg.field_priority = com.tencent.mm.g.a.lvZ;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      paramString2 = new czy();
      paramString2.msgId = l;
      paramString2.filePath = paramString1;
      paramString2.aaFs = bool1;
      paramString2.lxm = paramcc.getCreateTime();
      paramString2.talker = paramcc.field_talker;
      paramString2.aaFt = paramMap;
      PmL.put(str2, paramString2);
      boolean bool2 = com.tencent.mm.modelcdntran.k.bHW().b(localg, -1);
      Log.i("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "add download cdn task : %b, msgId : %s, newWay:%s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(l), Boolean.valueOf(bool1) });
      if (!bool2) {
        Log.i("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "triggerErrorCallback errCode:%s errMsg:%s", new Object[] { Integer.valueOf(0), Util.nullAs("add to cdn failed", "") });
      }
      AppMethodBeat.o(266713);
      return bool1;
      bool1 = true;
      paramString2 = Util.nullAs((String)paramMap.get(paramString1 + ".newformatfileid"), "");
      parama = Util.nullAs((String)paramMap.get(paramString1 + ".newformataeskey"), "");
      str1 = Util.nullAs((String)paramMap.get(paramString1 + ".newfromatfilelength"), "");
      Util.nullAs((String)paramMap.get(paramString1 + ".newformatmsgcount"), "");
      break;
    }
  }
  
  public static boolean aVx(String paramString)
  {
    AppMethodBeat.i(266693);
    Iterator localIterator = PmL.entrySet().iterator();
    while (localIterator.hasNext())
    {
      czy localczy = (czy)((Map.Entry)localIterator.next()).getValue();
      if (TextUtils.equals(localczy.aaFt, paramString))
      {
        if ((localczy.aaFs) && (localczy.state != 2))
        {
          AppMethodBeat.o(266693);
          return true;
        }
        AppMethodBeat.o(266693);
        return false;
      }
    }
    AppMethodBeat.o(266693);
    return false;
  }
  
  public static String ui(long paramLong)
  {
    AppMethodBeat.i(266719);
    String str = PluginMessenger.getAccSelectRecordPath() + paramLong;
    AppMethodBeat.o(266719);
    return str;
  }
  
  public final void af(long paramLong, String paramString)
  {
    AppMethodBeat.i(266787);
    Log.i("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "onClickHistory msgId:%s", new Object[] { Long.valueOf(paramLong) });
    if (this.isLoading)
    {
      if (this.lzP != null) {
        this.lzP.dismiss();
      }
      a(paramLong, this.hTh, this.PmJ, this.talker, paramString);
    }
    AppMethodBeat.o(266787);
  }
  
  public final CharSequence b(final Map<String, String> paramMap, final String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(266783);
    if (paramMap == null)
    {
      AppMethodBeat.o(266783);
      return null;
    }
    if (paramBundle != null) {}
    String str2;
    for (final String str1 = paramBundle.getString("conv_talker_username");; str1 = "")
    {
      str2 = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
      localObject = paramBundle.getString("template_type");
      if (Log.getLogLevel() <= 1) {
        Log.d("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "handleImp title:%s, contentTemplateType:%s stack:%s", new Object[] { str2, localObject, Util.getStack() });
      }
      if (!Util.isEqual((String)localObject, "tmpl_type_profile")) {
        break label246;
      }
      long l = paramBundle.getLong("msg_id");
      localObject = ((n)h.ax(n.class)).gaZ().sl(l);
      if ((localObject == null) || ((!((cc)localObject).jcl()) && (!aVx(((fi)localObject).field_historyId)))) {
        break label246;
      }
      Log.d("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "return title directly");
      paramMap = Util.nullAsNil((String)paramMap.get(paramString + ".newformattitle"));
      if (TextUtils.isEmpty(paramMap)) {
        break;
      }
      AppMethodBeat.o(266783);
      return paramMap;
    }
    AppMethodBeat.o(266783);
    return str2;
    label246:
    Object localObject = new SpannableString(str2);
    ((SpannableString)localObject).setSpan(new com.tencent.mm.plugin.messenger.a.a(paramMap)
    {
      public final void onClickImp(View paramAnonymousView)
      {
        AppMethodBeat.i(266682);
        paramAnonymousView = b.t(paramMap, "link_history");
        long l = paramBundle.getLong("msg_id");
        cc localcc = ((n)h.ax(n.class)).gaZ().sl(l);
        if (localcc.jck()) {
          com.tencent.mm.ui.base.k.a((Context)paramWeakReference.get(), MMApplicationContext.getContext().getString(b.e.record_msg_revoked), "", MMApplicationContext.getContext().getString(b.e.welcome_i_know), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(266673);
              Log.i("MicroMsg.selectRecord.SysMsgTemplateLinkHandlerHistory", "click i know");
              AppMethodBeat.o(266673);
            }
          });
        }
        for (;;)
        {
          b.a(paramBundle, localcc);
          ((e)h.ax(e.class)).a("link_history", paramMap, paramBundle);
          AppMethodBeat.o(266682);
          return;
          b.a(b.this, localcc, paramMap, paramBundle, paramAnonymousView, paramWeakReference);
        }
      }
    }, 0, str2.length(), 33);
    AppMethodBeat.o(266783);
    return localObject;
  }
  
  public final String gbt()
  {
    return "link_history";
  }
  
  public final void release()
  {
    AppMethodBeat.i(266776);
    super.release();
    AppMethodBeat.o(266776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.e.b
 * JD-Core Version:    0.7.0.1
 */