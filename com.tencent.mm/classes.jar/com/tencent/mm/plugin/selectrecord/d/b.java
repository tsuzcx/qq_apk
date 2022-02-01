package com.tencent.mm.plugin.selectrecord.d;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ao.f;
import com.tencent.mm.bs.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.messenger.PluginMessenger;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  extends com.tencent.mm.plugin.messenger.d.b
  implements a
{
  private static g.a ibn;
  private static final Map<Long, a> nyV;
  private static final Map<String, Pair<Long, String>> yCp;
  private long dAY;
  private ProgressDialog fMu = null;
  private boolean isLoading = false;
  private WeakReference<Context> lVh;
  private String talker;
  private String yCn;
  private String yCo;
  
  static
  {
    AppMethodBeat.i(207414);
    yCp = new ConcurrentHashMap();
    nyV = new ConcurrentHashMap();
    ibn = new b.1();
    AppMethodBeat.o(207414);
  }
  
  public b(b.b paramb)
  {
    super(paramb);
  }
  
  private static void a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(207407);
    ad.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "gotoRecordDetailUI msgId:%s msgSvrId:%s sendUserName:%s talker:%s xml:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), bt.bI(paramString1, ""), bt.bI(paramString2, ""), bt.aRp(paramString3) });
    paramString3 = k.b.yr(paramString3);
    if (paramString3 == null)
    {
      ad.e("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "gotoRecordDetailUI content is null???");
      AppMethodBeat.o(207407);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("message_id", paramLong1);
    localIntent.putExtra("record_xml", paramString3.hAs);
    localIntent.putExtra("record_show_share", false);
    localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
    localIntent.putExtra("preUsername", paramString1);
    localIntent.putExtra("preChatName", paramString2);
    localIntent.putExtra("preChatTYPE", 2);
    d.b(aj.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
    AppMethodBeat.o(207407);
  }
  
  public static void a(long paramLong, Map<String, String> paramMap, String paramString, a parama)
  {
    AppMethodBeat.i(207409);
    if (parama != null) {
      nyV.put(Long.valueOf(paramLong), parama);
    }
    parama = bt.bI((String)paramMap.get(paramString + ".fileid"), "");
    String str1 = bt.bI((String)paramMap.get(paramString + ".aeskey"), "");
    String str2 = bt.bI((String)paramMap.get(paramString + ".filelength"), "");
    bt.bI((String)paramMap.get(paramString + ".msgcount"), "");
    paramMap = PluginMessenger.getAccSelectRecordPath() + "downloadcache/";
    if (!com.tencent.mm.vfs.i.fv(paramMap)) {
      com.tencent.mm.vfs.i.aYg(paramMap);
    }
    paramMap = paramMap + paramLong;
    if (com.tencent.mm.vfs.i.fv(paramMap)) {
      com.tencent.mm.vfs.i.deleteFile(paramMap);
    }
    paramString = com.tencent.mm.b.g.getMessageDigest((bt.HI() + ", " + paramLong).getBytes());
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fJj = ibn;
    localg.dNR = false;
    localg.field_mediaId = paramString;
    localg.field_fullpath = paramMap;
    localg.field_totalLen = Integer.parseInt(str2);
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    localg.field_fileId = parama;
    localg.field_aesKey = str1;
    localg.field_priority = com.tencent.mm.i.a.fIw;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    yCp.put(paramString, new Pair(Long.valueOf(paramLong), paramMap));
    boolean bool = f.aGI().b(localg, -1);
    ad.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "add download cdn task : %b, msgId : %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong) });
    if (!bool) {
      ad.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "triggerErrorCallback errCode:%s errMsg:%s", new Object[] { Integer.valueOf(0), bt.bI("add to cdn failed", "") });
    }
    AppMethodBeat.o(207409);
  }
  
  public static String zg(long paramLong)
  {
    AppMethodBeat.i(207410);
    String str = PluginMessenger.getAccSelectRecordPath() + paramLong;
    AppMethodBeat.o(207410);
    return str;
  }
  
  public final void B(long paramLong, String paramString)
  {
    AppMethodBeat.i(207408);
    ad.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "onClickHistory msgId:%s", new Object[] { Long.valueOf(paramLong) });
    if (this.isLoading)
    {
      if (this.fMu != null) {
        this.fMu.dismiss();
      }
      a(paramLong, this.dAY, this.yCn, this.talker, paramString);
    }
    AppMethodBeat.o(207408);
  }
  
  public final CharSequence b(final Map<String, String> paramMap, final String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(207406);
    if (paramMap == null)
    {
      AppMethodBeat.o(207406);
      return null;
    }
    if (paramBundle != null) {}
    for (final String str1 = paramBundle.getString("conv_talker_username");; str1 = "")
    {
      String str2 = bt.nullAsNil((String)paramMap.get(paramString + ".title"));
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a()
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(207403);
          paramAnonymousView = b.q(paramMap, "link_history");
          long l = paramBundle.getLong("msg_id");
          bu localbu = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(l);
          if (localbu.fsl()) {
            h.a((Context)paramWeakReference.get(), aj.getContext().getString(2131767119), "", aj.getContext().getString(2131766205), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(207402);
                ad.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "click i know");
                AppMethodBeat.o(207402);
              }
            });
          }
          for (;;)
          {
            b.a(paramBundle, localbu);
            ((e)com.tencent.mm.kernel.g.ab(e.class)).a("link_history", paramMap, paramBundle);
            AppMethodBeat.o(207403);
            return;
            b.a(b.this, l, paramMap, paramBundle, paramAnonymousView, paramWeakReference);
          }
        }
      }, 0, str2.length(), 33);
      AppMethodBeat.o(207406);
      return localSpannableString;
    }
  }
  
  public final String dmf()
  {
    return "link_history";
  }
  
  public final void release()
  {
    AppMethodBeat.i(207405);
    super.release();
    AppMethodBeat.o(207405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.d.b
 * JD-Core Version:    0.7.0.1
 */