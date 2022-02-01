package com.tencent.mm.plugin.selectrecord.e;

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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.an.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.messenger.PluginMessenger;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  extends com.tencent.mm.plugin.messenger.d.b
  implements a
{
  private static g.a ieg;
  private static final Map<Long, a> nEq;
  private static final Map<String, Pair<Long, String>> ySs;
  private long dCd;
  private ProgressDialog fOC = null;
  private boolean isLoading = false;
  private WeakReference<Context> lZK;
  private String talker;
  private String ySq;
  private String ySr;
  
  static
  {
    AppMethodBeat.i(194021);
    ySs = new ConcurrentHashMap();
    nEq = new ConcurrentHashMap();
    ieg = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(194008);
        ae.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn callback, id: %s, ret: %s, sceneResult: %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousd });
        if (paramAnonymousd != null) {
          try
          {
            if (paramAnonymousd.field_retCode == 0)
            {
              paramAnonymousString = (Pair)b.ySs.get(paramAnonymousString);
              if (paramAnonymousString == null) {
                ae.e("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn callback, pair is null??");
              }
              for (;;)
              {
                AppMethodBeat.o(194008);
                return 0;
                paramAnonymousc = new String(o.bb((String)paramAnonymousString.second, 0, -1));
                paramAnonymousd = b.zE(((Long)paramAnonymousString.first).longValue());
                if (o.fB(paramAnonymousd)) {
                  o.deleteFile(paramAnonymousd);
                }
                long l = o.mF((String)paramAnonymousString.second, paramAnonymousd);
                paramAnonymousBoolean = o.deleteFile((String)paramAnonymousString.second);
                ae.d("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn callback, msgId:%s filePath:%s xml:%s result:%s delResult:%s", new Object[] { paramAnonymousString.first, paramAnonymousString.second, bu.aSM(paramAnonymousc), Long.valueOf(l), Boolean.valueOf(paramAnonymousBoolean) });
                paramAnonymousd = (a)b.abc().get(paramAnonymousString.first);
                if (paramAnonymousd != null) {
                  paramAnonymousd.C(((Long)paramAnonymousString.first).longValue(), paramAnonymousc);
                }
              }
              AppMethodBeat.o(194008);
            }
          }
          catch (Exception paramAnonymousString)
          {
            ae.e("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "callback %s %s", new Object[] { paramAnonymousString.getClass().getSimpleName(), paramAnonymousString.getMessage() });
          }
        }
        for (;;)
        {
          return 0;
          if (paramAnonymousc != null) {
            ae.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn process: %f", new Object[] { Double.valueOf(paramAnonymousc.field_finishedLength / paramAnonymousc.field_toltalLength) });
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(194006);
        ae.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(194006);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(194007);
        ae.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(194007);
        return null;
      }
    };
    AppMethodBeat.o(194021);
  }
  
  public b(b.b paramb)
  {
    super(paramb);
  }
  
  private static void a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194014);
    ae.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "gotoRecordDetailUI msgId:%s msgSvrId:%s sendUserName:%s talker:%s xml:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), bu.bI(paramString1, ""), bu.bI(paramString2, ""), bu.aSM(paramString3) });
    paramString3 = k.b.zb(paramString3);
    if (paramString3 == null)
    {
      ae.e("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "gotoRecordDetailUI content is null???");
      AppMethodBeat.o(194014);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("message_id", paramLong1);
    localIntent.putExtra("record_xml", paramString3.hDg);
    localIntent.putExtra("record_show_share", false);
    localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
    localIntent.putExtra("preUsername", paramString1);
    localIntent.putExtra("preChatName", paramString2);
    localIntent.putExtra("preChatTYPE", 2);
    com.tencent.mm.br.d.b(ak.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
    AppMethodBeat.o(194014);
  }
  
  public static void a(long paramLong, Map<String, String> paramMap, String paramString, a parama)
  {
    AppMethodBeat.i(194016);
    if (parama != null) {
      nEq.put(Long.valueOf(paramLong), parama);
    }
    parama = bu.bI((String)paramMap.get(paramString + ".fileid"), "");
    String str1 = bu.bI((String)paramMap.get(paramString + ".aeskey"), "");
    String str2 = bu.bI((String)paramMap.get(paramString + ".filelength"), "");
    bu.bI((String)paramMap.get(paramString + ".msgcount"), "");
    paramMap = PluginMessenger.getAccSelectRecordPath() + "downloadcache/";
    if (!o.fB(paramMap)) {
      o.aZI(paramMap);
    }
    paramMap = paramMap + paramLong;
    if (o.fB(paramMap)) {
      o.deleteFile(paramMap);
    }
    paramString = com.tencent.mm.b.g.getMessageDigest((bu.HQ() + ", " + paramLong).getBytes());
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.fLm = ieg;
    localg.dPh = false;
    localg.field_mediaId = paramString;
    localg.field_fullpath = paramMap;
    localg.field_totalLen = Integer.parseInt(str2);
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    localg.field_fileId = parama;
    localg.field_aesKey = str1;
    localg.field_priority = com.tencent.mm.i.a.fKA;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    ySs.put(paramString, new Pair(Long.valueOf(paramLong), paramMap));
    boolean bool = f.aGZ().b(localg, -1);
    ae.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "add download cdn task : %b, msgId : %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong) });
    if (!bool) {
      ae.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "triggerErrorCallback errCode:%s errMsg:%s", new Object[] { Integer.valueOf(0), bu.bI("add to cdn failed", "") });
    }
    AppMethodBeat.o(194016);
  }
  
  public static String zE(long paramLong)
  {
    AppMethodBeat.i(194017);
    String str = PluginMessenger.getAccSelectRecordPath() + paramLong;
    AppMethodBeat.o(194017);
    return str;
  }
  
  public final void C(long paramLong, String paramString)
  {
    AppMethodBeat.i(194015);
    ae.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "onClickHistory msgId:%s", new Object[] { Long.valueOf(paramLong) });
    if (this.isLoading)
    {
      if (this.fOC != null) {
        this.fOC.dismiss();
      }
      a(paramLong, this.dCd, this.ySq, this.talker, paramString);
    }
    AppMethodBeat.o(194015);
  }
  
  public final CharSequence b(final Map<String, String> paramMap, final String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(194013);
    if (paramMap == null)
    {
      AppMethodBeat.o(194013);
      return null;
    }
    if (paramBundle != null) {}
    for (final String str1 = paramBundle.getString("conv_talker_username");; str1 = "")
    {
      String str2 = bu.nullAsNil((String)paramMap.get(paramString + ".title"));
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a()
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(194010);
          paramAnonymousView = b.q(paramMap, "link_history");
          long l = paramBundle.getLong("msg_id");
          bv localbv = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(l);
          if (localbv.fwm()) {
            h.a((Context)paramWeakReference.get(), ak.getContext().getString(2131767119), "", ak.getContext().getString(2131766205), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(194009);
                ae.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "click i know");
                AppMethodBeat.o(194009);
              }
            });
          }
          for (;;)
          {
            b.a(paramBundle, localbv);
            ((e)com.tencent.mm.kernel.g.ab(e.class)).a("link_history", paramMap, paramBundle);
            AppMethodBeat.o(194010);
            return;
            b.a(b.this, l, paramMap, paramBundle, paramAnonymousView, paramWeakReference);
          }
        }
      }, 0, str2.length(), 33);
      AppMethodBeat.o(194013);
      return localSpannableString;
    }
  }
  
  public final String dpe()
  {
    return "link_history";
  }
  
  public final void release()
  {
    AppMethodBeat.i(194012);
    super.release();
    AppMethodBeat.o(194012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.e.b
 * JD-Core Version:    0.7.0.1
 */