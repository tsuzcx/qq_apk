package com.tencent.mm.plugin.mv.jump;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.findersdk.a.cq;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;>;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/jump/MusicPlayerJumper;", "", "()V", "doJump", "", "context", "Landroid/content/Context;", "textStatusID", "", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a LWp;
  
  static
  {
    AppMethodBeat.i(286041);
    LWp = new b.a((byte)0);
    AppMethodBeat.o(286041);
  }
  
  public static boolean d(Context paramContext, String paramString, List<TextStatusJumpInfo> paramList)
  {
    AppMethodBeat.i(286035);
    s.u(paramContext, "context");
    boolean bool1;
    boolean bool2;
    Object localObject1;
    label209:
    int i;
    if (paramList != null)
    {
      Iterator localIterator = ((Iterable)paramList).iterator();
      bool1 = false;
      bool2 = bool1;
      if (!localIterator.hasNext()) {
        break label783;
      }
      paramList = (TextStatusJumpInfo)localIterator.next();
      if (!s.p(paramList.jumpType, "1")) {
        break label791;
      }
      if (com.tencent.mm.n.a.dm(paramContext))
      {
        AppMethodBeat.o(286035);
        return true;
      }
      localObject1 = XmlParser.parseXml(paramList.busiBuf, "MusicVideoStatusOpenParams", null);
      if (localObject1 == null) {
        break label804;
      }
      try
      {
        localboo = new boo();
        c.a(localboo, s.X(".", "MusicVideoStatusOpenParams"), (Map)localObject1);
        localObject2 = cq.J(s.X(".", "MusicVideoStatusOpenParams"), (Map)localObject1);
        Log.i("MusicPlayerJumper", "alvinluo jumpToMv ext: %s, %s, identification: %s, %s, xml: %s", new Object[] { localboo.extraInfo, ((dtj)localObject2).extraInfo, localboo.identification, ((dtj)localObject2).identification, paramList.busiBuf });
        paramList = (CharSequence)((dtj)localObject2).YqP;
        if (paramList == null) {
          break label794;
        }
        if (paramList.length() != 0) {
          break label810;
        }
      }
      catch (Exception paramList)
      {
        boo localboo;
        Object localObject2;
        label226:
        label254:
        String str1;
        label278:
        Intent localIntent;
        label359:
        label375:
        String str2;
        Log.e("MusicPlayerJumper", s.X("process TextStatusJumpInfo fail:", paramList.getLocalizedMessage()));
        break label804;
      }
      if (i == 0)
      {
        paramList = ((dtj)localObject2).YqP;
        if (paramList != null) {
          break label815;
        }
        paramList = "";
        localObject1 = (CharSequence)((dtj)localObject2).extraInfo;
        if (localObject1 == null) {
          break label799;
        }
        if (((CharSequence)localObject1).length() != 0) {
          break label821;
        }
        break label799;
        if (i != 0) {
          break label718;
        }
        str1 = ((dtj)localObject2).extraInfo;
        localObject1 = str1;
        if (str1 == null) {
          localObject1 = "";
        }
        localboo.extraInfo = ((String)localObject1);
        com.tencent.mm.aw.a.bLi();
        localObject1 = ac.FLX;
        str1 = localboo.mLQ;
        localObject1 = str1;
        if (str1 == null) {
          localObject1 = String.valueOf(System.currentTimeMillis());
        }
        s.s(localObject1, "finderMVSongInfo.songId …ntTimeMillis().toString()");
        ac.a(localboo, (String)localObject1, 14, paramList);
        localIntent = new Intent();
        localObject1 = ((dtj)localObject2).YqN;
        if (localObject1 != null) {
          break label826;
        }
        localObject1 = "";
        str1 = ((dtj)localObject2).YqO;
        if (str1 != null) {
          break label829;
        }
        str1 = "";
        str2 = ((dtj)localObject2).YqQ;
        if (str2 != null) {
          break label832;
        }
        str2 = "";
      }
    }
    label783:
    label791:
    label794:
    label799:
    label804:
    label807:
    label810:
    label815:
    label818:
    label821:
    label826:
    label829:
    label832:
    for (;;)
    {
      localObject2 = ((dtj)localObject2).oOZ;
      localIntent.putExtra("key_mv_feed_id", (String)localObject1);
      localIntent.putExtra("key_mv_nonce_id", str1);
      localIntent.putExtra("key_mv_cover_url", paramList);
      localIntent.putExtra("key_mv_poster", str2);
      localIntent.putExtra("key_mv_song_name", localboo.songName);
      localIntent.putExtra("key_mv_song_lyric", localboo.Mcq);
      localIntent.putExtra("key_mv_singer_name", localboo.rDl);
      localIntent.putExtra("key_mv_album_name", localboo.albumName);
      localIntent.putExtra("key_mv_music_genre", localboo.ZTA);
      localIntent.putExtra("key_mv_issue_date", String.valueOf(localboo.ZWU));
      localIntent.putExtra("key_mv_album_cover_url", localboo.ZWS);
      localIntent.putExtra("key_mv_identification", localboo.identification);
      localIntent.putExtra("key_mv_extra_info", localboo.extraInfo);
      localIntent.putExtra("key_mv_music_duration", localboo.duration);
      paramList = localboo.ZWW;
      if (paramList == null) {
        paramList = "";
      }
      for (;;)
      {
        localIntent.putExtra("key_mv_music_operation_url", paramList);
        localIntent.putExtra("key_need_update_music_ball_url", true);
        paramList = (List<TextStatusJumpInfo>)localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          paramList = localboo.oOZ;
        }
        localIntent.putExtra("key_mv_song_mid", paramList);
        paramList = new dtk();
        localObject1 = com.tencent.mm.plugin.comm.a.xeG;
        paramList.zIO = com.tencent.mm.plugin.comm.a.dsT();
        paramList.aaYQ = paramString;
        paramList.scene = 6;
        localIntent.putExtra("key_mv_report_data", paramList.toByteArray());
        localIntent.setFlags(268435456);
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "mv", ".ui.MusicMvMainUI", localIntent);
        break label804;
        paramList = localboo.ZWS;
        if (paramList != null) {
          break label818;
        }
        paramList = "";
        break;
        label718:
        str1 = localboo.extraInfo;
        localObject1 = str1;
        if (str1 != null) {
          break label278;
        }
        localObject1 = "";
        break label278;
        localObject1 = paramList.ZWX;
        paramList = (List<TextStatusJumpInfo>)localObject1;
        if (localObject1 == null) {
          paramList = "";
        }
      }
      bool2 = false;
      AppMethodBeat.o(286035);
      return bool2;
      break label807;
      i = 1;
      break label209;
      i = 1;
      break label254;
      bool1 = true;
      break;
      i = 0;
      break label209;
      break label226;
      break label226;
      i = 0;
      break label254;
      break label359;
      break label375;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.jump.b
 * JD-Core Version:    0.7.0.1
 */