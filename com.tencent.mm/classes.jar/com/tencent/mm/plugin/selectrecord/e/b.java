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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.an.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.messenger.PluginMessenger;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  extends com.tencent.mm.plugin.messenger.d.b
  implements a
{
  private static final Map<String, Pair<Long, String>> CXi;
  private static g.a iZc;
  private static final Map<Long, a> oPn;
  private String CXg;
  private String CXh;
  private long dTS;
  private ProgressDialog gtM = null;
  private boolean isLoading = false;
  private WeakReference<Context> nhy;
  private String talker;
  
  static
  {
    AppMethodBeat.i(187943);
    CXi = new ConcurrentHashMap();
    oPn = new ConcurrentHashMap();
    iZc = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(187930);
        Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn callback, id: %s, ret: %s, sceneResult: %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousd });
        if (paramAnonymousd != null) {
          try
          {
            if (paramAnonymousd.field_retCode == 0)
            {
              paramAnonymousString = (Pair)b.CXi.get(paramAnonymousString);
              if (paramAnonymousString == null) {
                Log.e("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn callback, pair is null??");
              }
              for (;;)
              {
                AppMethodBeat.o(187930);
                return 0;
                paramAnonymousc = new String(s.aW((String)paramAnonymousString.second, 0, -1));
                paramAnonymousd = b.II(((Long)paramAnonymousString.first).longValue());
                if (s.YS(paramAnonymousd)) {
                  s.deleteFile(paramAnonymousd);
                }
                long l = s.nw((String)paramAnonymousString.second, paramAnonymousd);
                paramAnonymousBoolean = s.deleteFile((String)paramAnonymousString.second);
                Log.d("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn callback, msgId:%s filePath:%s xml:%s result:%s delResult:%s", new Object[] { paramAnonymousString.first, paramAnonymousString.second, Util.secPrint(paramAnonymousc), Long.valueOf(l), Boolean.valueOf(paramAnonymousBoolean) });
                paramAnonymousd = (a)b.apb().get(paramAnonymousString.first);
                if (paramAnonymousd != null) {
                  paramAnonymousd.I(((Long)paramAnonymousString.first).longValue(), paramAnonymousc);
                }
              }
              AppMethodBeat.o(187930);
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
        AppMethodBeat.i(187928);
        Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(187928);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(187929);
        Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(187929);
        return null;
      }
    };
    AppMethodBeat.o(187943);
  }
  
  public b(b.b paramb)
  {
    super(paramb);
  }
  
  public static String II(long paramLong)
  {
    AppMethodBeat.i(187939);
    String str = PluginMessenger.getAccSelectRecordPath() + paramLong;
    AppMethodBeat.o(187939);
    return str;
  }
  
  private static void a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(187936);
    Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "gotoRecordDetailUI msgId:%s msgSvrId:%s sendUserName:%s talker:%s xml:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Util.nullAs(paramString1, ""), Util.nullAs(paramString2, ""), Util.secPrint(paramString3) });
    paramString3 = k.b.HD(paramString3);
    if (paramString3 == null)
    {
      Log.e("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "gotoRecordDetailUI content is null???");
      AppMethodBeat.o(187936);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("message_id", paramLong1);
    localIntent.putExtra("record_xml", paramString3.ixl);
    localIntent.putExtra("record_show_share", false);
    localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
    localIntent.putExtra("preUsername", paramString1);
    localIntent.putExtra("preChatName", paramString2);
    localIntent.putExtra("preChatTYPE", 2);
    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
    AppMethodBeat.o(187936);
  }
  
  public static void a(long paramLong, Map<String, String> paramMap, String paramString, a parama)
  {
    AppMethodBeat.i(187938);
    if (parama != null) {
      oPn.put(Long.valueOf(paramLong), parama);
    }
    parama = Util.nullAs((String)paramMap.get(paramString + ".fileid"), "");
    String str1 = Util.nullAs((String)paramMap.get(paramString + ".aeskey"), "");
    String str2 = Util.nullAs((String)paramMap.get(paramString + ".filelength"), "");
    Util.nullAs((String)paramMap.get(paramString + ".msgcount"), "");
    paramMap = PluginMessenger.getAccSelectRecordPath() + "downloadcache/";
    if (!s.YS(paramMap)) {
      s.boN(paramMap);
    }
    paramMap = paramMap + paramLong;
    if (s.YS(paramMap)) {
      s.deleteFile(paramMap);
    }
    paramString = com.tencent.mm.b.g.getMessageDigest((Util.currentTicks() + ", " + paramLong).getBytes());
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.gqy = iZc;
    localg.ehd = false;
    localg.field_mediaId = paramString;
    localg.field_fullpath = paramMap;
    localg.field_totalLen = Integer.parseInt(str2);
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    localg.field_fileId = parama;
    localg.field_aesKey = str1;
    localg.field_priority = com.tencent.mm.i.a.gpM;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    CXi.put(paramString, new Pair(Long.valueOf(paramLong), paramMap));
    boolean bool = f.baQ().b(localg, -1);
    Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "add download cdn task : %b, msgId : %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong) });
    if (!bool) {
      Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "triggerErrorCallback errCode:%s errMsg:%s", new Object[] { Integer.valueOf(0), Util.nullAs("add to cdn failed", "") });
    }
    AppMethodBeat.o(187938);
  }
  
  public final void I(long paramLong, String paramString)
  {
    AppMethodBeat.i(187937);
    Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "onClickHistory msgId:%s", new Object[] { Long.valueOf(paramLong) });
    if (this.isLoading)
    {
      if (this.gtM != null) {
        this.gtM.dismiss();
      }
      a(paramLong, this.dTS, this.CXg, this.talker, paramString);
    }
    AppMethodBeat.o(187937);
  }
  
  public final CharSequence b(final Map<String, String> paramMap, final String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(187935);
    if (paramMap == null)
    {
      AppMethodBeat.o(187935);
      return null;
    }
    if (paramBundle != null) {}
    for (final String str1 = paramBundle.getString("conv_talker_username");; str1 = "")
    {
      String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a()
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(187932);
          paramAnonymousView = b.r(paramMap, "link_history");
          long l = paramBundle.getLong("msg_id");
          ca localca = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(l);
          if (localca.gDS()) {
            h.a((Context)paramWeakReference.get(), MMApplicationContext.getContext().getString(2131764289), "", MMApplicationContext.getContext().getString(2131768713), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(187931);
                Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "click i know");
                AppMethodBeat.o(187931);
              }
            });
          }
          for (;;)
          {
            b.a(paramBundle, localca);
            ((e)com.tencent.mm.kernel.g.af(e.class)).a("link_history", paramMap, paramBundle);
            AppMethodBeat.o(187932);
            return;
            b.a(b.this, l, paramMap, paramBundle, paramAnonymousView, paramWeakReference);
          }
        }
      }, 0, str2.length(), 33);
      AppMethodBeat.o(187935);
      return localSpannableString;
    }
  }
  
  public final String eiT()
  {
    return "link_history";
  }
  
  public final void release()
  {
    AppMethodBeat.i(187934);
    super.release();
    AppMethodBeat.o(187934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.e.b
 * JD-Core Version:    0.7.0.1
 */