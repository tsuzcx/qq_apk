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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aq.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.messenger.PluginMessenger;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.b.d;
import com.tencent.mm.plugin.messenger.e.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  extends com.tencent.mm.plugin.messenger.e.b
  implements a
{
  private static final Map<String, Pair<Long, String>> JcO;
  private static g.a lPx;
  private static final Map<Long, a> rRk;
  private String JcM;
  private String JcN;
  private long fNu;
  private ProgressDialog iXX = null;
  private boolean isLoading = false;
  private WeakReference<Context> qHe;
  private String talker;
  
  static
  {
    AppMethodBeat.i(255234);
    JcO = new ConcurrentHashMap();
    rRk = new ConcurrentHashMap();
    lPx = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(255278);
        Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn callback, id: %s, ret: %s, sceneResult: %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousd });
        if (paramAnonymousd != null) {
          try
          {
            if (paramAnonymousd.field_retCode == 0)
            {
              paramAnonymousString = (Pair)b.JcO.get(paramAnonymousString);
              if (paramAnonymousString == null) {
                Log.e("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn callback, pair is null??");
              }
              for (;;)
              {
                AppMethodBeat.o(255278);
                return 0;
                paramAnonymousc = new String(u.aY((String)paramAnonymousString.second, 0, -1));
                paramAnonymousd = b.Qc(((Long)paramAnonymousString.first).longValue());
                if (u.agG(paramAnonymousd)) {
                  u.deleteFile(paramAnonymousd);
                }
                long l = u.on((String)paramAnonymousString.second, paramAnonymousd);
                paramAnonymousBoolean = u.deleteFile((String)paramAnonymousString.second);
                Log.d("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn callback, msgId:%s filePath:%s xml:%s result:%s delResult:%s", new Object[] { paramAnonymousString.first, paramAnonymousString.second, Util.secPrint(paramAnonymousc), Long.valueOf(l), Boolean.valueOf(paramAnonymousBoolean) });
                paramAnonymousd = (a)b.avo().get(paramAnonymousString.first);
                if (paramAnonymousd != null) {
                  paramAnonymousd.Q(((Long)paramAnonymousString.first).longValue(), paramAnonymousc);
                }
              }
              AppMethodBeat.o(255278);
            }
          }
          catch (Exception paramAnonymousString)
          {
            Log.e("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "callback %s %s", new Object[] { paramAnonymousString.getClass().getSimpleName(), paramAnonymousString.getMessage() });
          }
        }
        for (;;)
        {
          return 0;
          if (paramAnonymousc != null) {
            Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn process: %f", new Object[] { Double.valueOf(paramAnonymousc.field_finishedLength / paramAnonymousc.field_toltalLength) });
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(255276);
        Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(255276);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(255277);
        Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(255277);
        return null;
      }
    };
    AppMethodBeat.o(255234);
  }
  
  public b(b.b paramb)
  {
    super(paramb);
  }
  
  public static String Qc(long paramLong)
  {
    AppMethodBeat.i(255229);
    String str = PluginMessenger.getAccSelectRecordPath() + paramLong;
    AppMethodBeat.o(255229);
    return str;
  }
  
  private static void a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(255225);
    Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "gotoRecordDetailUI msgId:%s msgSvrId:%s sendUserName:%s talker:%s xml:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Util.nullAs(paramString1, ""), Util.nullAs(paramString2, ""), Util.secPrint(paramString3) });
    paramString3 = k.b.OQ(paramString3);
    if (paramString3 == null)
    {
      Log.e("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "gotoRecordDetailUI content is null???");
      AppMethodBeat.o(255225);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("message_id", paramLong1);
    localIntent.putExtra("record_xml", paramString3.lmA);
    localIntent.putExtra("record_show_share", false);
    localIntent.putExtra("from_scene", 2);
    localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
    localIntent.putExtra("preUsername", paramString1);
    localIntent.putExtra("preChatName", paramString2);
    localIntent.putExtra("preChatTYPE", 2);
    com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
    AppMethodBeat.o(255225);
  }
  
  public static void a(long paramLong, Map<String, String> paramMap, String paramString, a parama)
  {
    AppMethodBeat.i(255228);
    if (parama != null) {
      rRk.put(Long.valueOf(paramLong), parama);
    }
    parama = Util.nullAs((String)paramMap.get(paramString + ".fileid"), "");
    String str1 = Util.nullAs((String)paramMap.get(paramString + ".aeskey"), "");
    String str2 = Util.nullAs((String)paramMap.get(paramString + ".filelength"), "");
    Util.nullAs((String)paramMap.get(paramString + ".msgcount"), "");
    paramMap = PluginMessenger.getAccSelectRecordPath() + "downloadcache/";
    if (!u.agG(paramMap)) {
      u.bBD(paramMap);
    }
    paramMap = paramMap + paramLong;
    if (u.agG(paramMap)) {
      u.deleteFile(paramMap);
    }
    paramString = com.tencent.mm.b.g.getMessageDigest((Util.currentTicks() + ", " + paramLong).getBytes());
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.iUG = lPx;
    localg.gbt = false;
    localg.field_mediaId = paramString;
    localg.field_fullpath = paramMap;
    localg.field_totalLen = Integer.parseInt(str2);
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    localg.field_fileId = parama;
    localg.field_aesKey = str1;
    localg.field_priority = com.tencent.mm.i.a.iTU;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    JcO.put(paramString, new Pair(Long.valueOf(paramLong), paramMap));
    boolean bool = f.bkg().b(localg, -1);
    Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "add download cdn task : %b, msgId : %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong) });
    if (!bool) {
      Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "triggerErrorCallback errCode:%s errMsg:%s", new Object[] { Integer.valueOf(0), Util.nullAs("add to cdn failed", "") });
    }
    AppMethodBeat.o(255228);
  }
  
  public final void Q(long paramLong, String paramString)
  {
    AppMethodBeat.i(255227);
    Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "onClickHistory msgId:%s", new Object[] { Long.valueOf(paramLong) });
    if (this.isLoading)
    {
      if (this.iXX != null) {
        this.iXX.dismiss();
      }
      a(paramLong, this.fNu, this.JcM, this.talker, paramString);
    }
    AppMethodBeat.o(255227);
  }
  
  public final CharSequence b(final Map<String, String> paramMap, final String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(255224);
    if (paramMap == null)
    {
      AppMethodBeat.o(255224);
      return null;
    }
    if (paramBundle != null) {}
    for (final String str1 = paramBundle.getString("conv_talker_username");; str1 = "")
    {
      String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a(paramMap, paramBundle)
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(255200);
          paramAnonymousView = b.r(paramMap, "link_history");
          long l = paramBundle.getLong("msg_id");
          ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(l);
          if (localca.hAg()) {
            com.tencent.mm.ui.base.h.a((Context)paramWeakReference.get(), MMApplicationContext.getContext().getString(b.d.record_msg_revoked), "", MMApplicationContext.getContext().getString(b.d.welcome_i_know), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(255249);
                Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "click i know");
                AppMethodBeat.o(255249);
              }
            });
          }
          for (;;)
          {
            b.a(paramBundle, localca);
            ((e)com.tencent.mm.kernel.h.ae(e.class)).a("link_history", paramMap, paramBundle);
            AppMethodBeat.o(255200);
            return;
            b.a(b.this, l, paramMap, paramBundle, paramAnonymousView, paramWeakReference);
          }
        }
      }, 0, str2.length(), 33);
      AppMethodBeat.o(255224);
      return localSpannableString;
    }
  }
  
  public final String eSz()
  {
    return "link_history";
  }
  
  public final void release()
  {
    AppMethodBeat.i(255223);
    super.release();
    AppMethodBeat.o(255223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.e.b
 * JD-Core Version:    0.7.0.1
 */