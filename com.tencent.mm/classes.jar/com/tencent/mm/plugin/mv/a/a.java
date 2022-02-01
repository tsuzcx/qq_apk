package com.tencent.mm.plugin.mv.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.finder.storage.aa;
import com.tencent.mm.plugin.findersdk.a.am;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;>;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/jump/MusicPlayerJumper;", "", "()V", "doJump", "", "context", "Landroid/content/Context;", "textStatusID", "", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "Companion", "plugin-mv_release"})
public final class a
{
  public static final a.a Gag;
  
  static
  {
    AppMethodBeat.i(231763);
    Gag = new a.a((byte)0);
    AppMethodBeat.o(231763);
  }
  
  public static boolean d(Context paramContext, String paramString, List<TextStatusJumpInfo> paramList)
  {
    AppMethodBeat.i(231760);
    p.k(paramContext, "context");
    boolean bool1;
    boolean bool2;
    Object localObject1;
    if (paramList != null)
    {
      Iterator localIterator = ((Iterable)paramList).iterator();
      bool1 = false;
      bool2 = bool1;
      if (!localIterator.hasNext()) {
        break label645;
      }
      paramList = (TextStatusJumpInfo)localIterator.next();
      if (!p.h(paramList.jumpType, "1")) {
        break label662;
      }
      if (com.tencent.mm.q.a.cy(paramContext))
      {
        AppMethodBeat.o(231760);
        return true;
      }
      localObject1 = XmlParser.parseXml(paramList.busiBuf, "MusicVideoStatusOpenParams", null);
      if (localObject1 == null) {
        break label670;
      }
    }
    for (;;)
    {
      try
      {
        localbds = new bds();
        b.a(localbds, ".".concat(String.valueOf("MusicVideoStatusOpenParams")), (Map)localObject1);
        localObject2 = am.C(".".concat(String.valueOf("MusicVideoStatusOpenParams")), (Map)localObject1);
        Log.i("MusicPlayerJumper", "alvinluo jumpToMv ext: %s, %s, identification: %s, %s, xml: %s", new Object[] { localbds.extraInfo, ((dbr)localObject2).extraInfo, localbds.identification, ((dbr)localObject2).identification, paramList.busiBuf });
        paramList = (CharSequence)((dbr)localObject2).Ruw;
        if (paramList == null) {
          break label665;
        }
        if (paramList.length() != 0) {
          break label676;
        }
      }
      catch (Exception paramList)
      {
        bds localbds;
        Object localObject2;
        String str1;
        Intent localIntent;
        String str2;
        Log.e("MusicPlayerJumper", "process TextStatusJumpInfo fail:" + paramList.getLocalizedMessage());
        break label670;
      }
      if (i == 0)
      {
        localObject1 = ((dbr)localObject2).Ruw;
        paramList = (List<TextStatusJumpInfo>)localObject1;
        if (localObject1 != null) {
          break label659;
        }
        paramList = "";
        com.tencent.mm.bb.a.bnv();
        localObject1 = aa.Amg;
        str1 = localbds.kkU;
        localObject1 = str1;
        if (str1 == null) {
          localObject1 = String.valueOf(System.currentTimeMillis());
        }
        aa.a(localbds, (String)localObject1, 14, paramList);
        localIntent = new Intent();
        localObject1 = ((dbr)localObject2).Ruu;
        if (localObject1 != null) {
          break label656;
        }
        localObject1 = "";
        str1 = ((dbr)localObject2).Ruv;
        if (str1 == null)
        {
          str1 = "";
          str2 = ((dbr)localObject2).Rux;
          localObject2 = str2;
          if (str2 == null) {
            localObject2 = "";
          }
          localIntent.putExtra("key_mv_feed_id", (String)localObject1);
          localIntent.putExtra("key_mv_nonce_id", str1);
          localIntent.putExtra("key_mv_cover_url", paramList);
          localIntent.putExtra("key_mv_poster", (String)localObject2);
          localIntent.putExtra("key_mv_song_name", localbds.HLH);
          localIntent.putExtra("key_mv_song_lyric", localbds.SOL);
          localIntent.putExtra("key_mv_singer_name", localbds.ozs);
          localIntent.putExtra("key_mv_album_name", localbds.albumName);
          localIntent.putExtra("key_mv_music_genre", localbds.SMY);
          localIntent.putExtra("key_mv_issue_date", String.valueOf(localbds.SOO));
          localIntent.putExtra("key_mv_album_cover_url", localbds.SOM);
          localIntent.putExtra("key_mv_identification", localbds.identification);
          localIntent.putExtra("key_mv_extra_info", localbds.extraInfo);
          localIntent.putExtra("key_mv_music_duration", localbds.duration);
          localIntent.putExtra("key_need_update_music_ball_url", true);
          paramList = new dbs();
          localObject1 = com.tencent.mm.plugin.comm.a.ubo;
          paramList.wmL = com.tencent.mm.plugin.comm.a.cPn();
          paramList.TJa = paramString;
          paramList.scene = 6;
          localIntent.putExtra("key_mv_report_data", paramList.toByteArray());
          localIntent.setFlags(268435456);
          c.b(MMApplicationContext.getContext(), "mv", ".ui.MusicMvMainUI", localIntent);
          break label670;
        }
      }
      else
      {
        localObject1 = localbds.SOM;
        paramList = (List<TextStatusJumpInfo>)localObject1;
        if (localObject1 != null) {
          break label659;
        }
        paramList = "";
        continue;
        bool2 = false;
        label645:
        AppMethodBeat.o(231760);
        return bool2;
      }
      continue;
      label656:
      continue;
      label659:
      continue;
      label662:
      break label673;
      label665:
      int i = 1;
      continue;
      label670:
      bool1 = true;
      label673:
      break;
      label676:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a
 * JD-Core Version:    0.7.0.1
 */