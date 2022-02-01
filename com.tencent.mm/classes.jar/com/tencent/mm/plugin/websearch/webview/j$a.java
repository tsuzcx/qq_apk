package com.tencent.mm.plugin.websearch.webview;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.bb.h;
import com.tencent.mm.bb.i;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.nn;
import com.tencent.mm.f.a.nn.b;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchUtils$Companion;", "", "()V", "TAG", "", "VIBRATION_INTENSITY_DEFAULT", "", "VIBRATION_INTENSITY_ERROR", "VIBRATION_INTENSITY_HIGH", "VIBRATION_INTENSITY_LOW", "VIBRATION_INTENSITY_MEDIUM", "isTheSameId", "", "id", "playSearchMusic", "", "paramsObj", "Lorg/json/JSONObject;", "openMv", "vibrateShort", "params", "ui-websearch_release"})
public final class j$a
{
  private static boolean aXq(String paramString)
  {
    AppMethodBeat.i(198546);
    Object localObject = new nn();
    ((nn)localObject).fLT.action = -2;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = ((nn)localObject).fLU.fLV;
    if ((localObject != null) && (com.tencent.mm.bb.a.e((f)localObject)) && (p.h(paramString, ((f)localObject).lVt)) && (com.tencent.mm.bb.a.bnx()))
    {
      AppMethodBeat.o(198546);
      return true;
    }
    AppMethodBeat.o(198546);
    return false;
  }
  
  public static boolean bjd(String paramString)
  {
    long l = 50L;
    AppMethodBeat.i(198528);
    Log.i(j.access$getTAG$cp(), "vibrateShort , type = ".concat(String.valueOf(paramString)));
    try
    {
      paramString = new JSONObject(paramString);
      localObject = MMApplicationContext.getContext().getSystemService("vibrator");
      if (localObject == null)
      {
        paramString = new t("null cannot be cast to non-null type android.os.Vibrator");
        AppMethodBeat.o(198528);
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(j.access$getTAG$cp(), (Throwable)paramString, "vibrateShort", new Object[0]);
      AppMethodBeat.o(198528);
      return false;
    }
    Object localObject = (Vibrator)localObject;
    paramString = paramString.get("style");
    int i = j.gRE();
    if (p.h(paramString, "light")) {
      i = j.gRF();
    }
    while (j.gRI() == i)
    {
      ((Vibrator)localObject).vibrate(50L);
      AppMethodBeat.o(198528);
      return true;
      if (p.h(paramString, "medium")) {
        i = j.gRG();
      } else if (p.h(paramString, "heavy")) {
        i = j.gRH();
      }
    }
    if (j.gRE() == i)
    {
      ((Vibrator)localObject).vibrate(50L);
      AppMethodBeat.o(198528);
      return true;
    }
    if ((Build.VERSION.SDK_INT >= 26) && (((Vibrator)localObject).hasAmplitudeControl())) {
      if (i == j.gRF())
      {
        i = 128;
        l = 15L;
      }
    }
    for (;;)
    {
      if (-1 != i) {
        ((Vibrator)localObject).vibrate(VibrationEffect.createOneShot(l, i));
      }
      for (;;)
      {
        AppMethodBeat.o(198528);
        return true;
        if (i == j.gRG())
        {
          i = 192;
          break;
        }
        if (i != j.gRH()) {
          break label292;
        }
        i = 255;
        l = 85L;
        break;
        ((Vibrator)localObject).vibrate(50L);
      }
      label292:
      l = 0L;
      i = -1;
    }
  }
  
  public static void d(JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(198544);
    p.k(paramJSONObject, "paramsObj");
    Log.i(j.access$getTAG$cp(), "playSearchMusic " + paramJSONObject + " openMv:" + paramBoolean);
    String str1 = paramJSONObject.optString("musicId", "");
    Object localObject1 = paramJSONObject.optString("songName", "");
    String str2 = paramJSONObject.optString("singerName", "");
    Object localObject2 = paramJSONObject.optString("musicWebUrl", "");
    String str3 = paramJSONObject.optString("albumUrl", "");
    String str12 = paramJSONObject.optString("musicDataUrl", "");
    String str13 = paramJSONObject.optString("musicAppId", "");
    String str4 = paramJSONObject.optString("songLyric", "");
    String str5 = paramJSONObject.optString("albumName", "");
    String str6 = paramJSONObject.optString("genre", "");
    String str7 = paramJSONObject.optString("identification", "");
    long l1 = paramJSONObject.optLong("issueDate", 0L);
    long l2 = paramJSONObject.optLong("duration", 0L);
    String str8 = paramJSONObject.optString("extraInfo", "");
    paramJSONObject.optInt("copyright", 0);
    String str9 = paramJSONObject.optString("mvObjectId", "");
    String str10 = paramJSONObject.optString("mvNonceId", "");
    String str11 = paramJSONObject.optString("mvCoverUrl", "");
    paramJSONObject = paramJSONObject.optString("mvMakerFinderNickname", "");
    dbr localdbr;
    if (paramBoolean)
    {
      p.j(str1, "musicId");
      if (!aXq(str1))
      {
        localdbr = new dbr();
        localdbr.Ruu = str9;
        localdbr.Ruv = str10;
        localdbr.Ruw = str11;
        localdbr.Rux = paramJSONObject;
        localdbr.HLH = ((String)localObject1);
        localdbr.singerName = str2;
        localdbr.KGh = str3;
        localdbr.albumName = str5;
        localdbr.issueDate = l1;
        localdbr.FSG = ((int)l2);
        localdbr.identification = str7;
        localdbr.extraInfo = str8;
        localdbr.songLyric = str4;
        localdbr.musicGenre = str6;
        localdbr.extraInfo = str8;
        com.tencent.mm.bb.a.c(i.a(9, str3, (String)localObject1, str2, (String)localObject2, "", str12, str1, "", "", str5, str13, h.a(str1, localdbr)));
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("key_mv_song_name", (String)localObject1);
      ((Intent)localObject2).putExtra("key_mv_song_lyric", str4);
      ((Intent)localObject2).putExtra("key_mv_album_cover_url", str3);
      ((Intent)localObject2).putExtra("key_mv_feed_id", str9);
      ((Intent)localObject2).putExtra("key_mv_nonce_id", str10);
      ((Intent)localObject2).putExtra("key_mv_cover_url", str11);
      ((Intent)localObject2).putExtra("key_mv_poster", paramJSONObject);
      ((Intent)localObject2).putExtra("key_mv_singer_name", str2);
      ((Intent)localObject2).putExtra("key_mv_album_name", str5);
      ((Intent)localObject2).putExtra("key_mv_music_genre", str6);
      ((Intent)localObject2).putExtra("key_mv_issue_date", String.valueOf(l1));
      ((Intent)localObject2).putExtra("key_mv_identification", str7);
      ((Intent)localObject2).putExtra("key_mv_extra_info", str8);
      ((Intent)localObject2).putExtra("key_mv_music_duration", (int)l2);
      paramJSONObject = new dbs();
      localObject1 = com.tencent.mm.plugin.comm.a.ubo;
      paramJSONObject.wmL = com.tencent.mm.plugin.comm.a.cPn();
      paramJSONObject.scene = 18;
      paramJSONObject.TJa = str1;
      ((Intent)localObject2).putExtra("key_mv_report_data", paramJSONObject.toByteArray());
      ((Intent)localObject2).setFlags(268435456);
      c.b(MMApplicationContext.getContext(), "mv", ".ui.MusicMvMainUI", (Intent)localObject2);
      AppMethodBeat.o(198544);
      return;
    }
    p.j(str1, "musicId");
    if (!aXq(str1))
    {
      localdbr = new dbr();
      localdbr.Ruu = str9;
      localdbr.Ruv = str10;
      localdbr.Ruw = str11;
      localdbr.Rux = paramJSONObject;
      localdbr.HLH = ((String)localObject1);
      localdbr.singerName = str2;
      localdbr.KGh = str3;
      localdbr.albumName = str5;
      localdbr.issueDate = l1;
      localdbr.FSG = ((int)l2);
      localdbr.identification = str7;
      localdbr.extraInfo = str8;
      localdbr.songLyric = str4;
      localdbr.musicGenre = str6;
      localdbr.extraInfo = str8;
      com.tencent.mm.bb.a.c(i.a(9, str3, (String)localObject1, str2, (String)localObject2, "", str12, str1, "", "", str5, str13, h.a(str1, localdbr)));
      AppMethodBeat.o(198544);
      return;
    }
    com.tencent.mm.bb.a.bnt();
    AppMethodBeat.o(198544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.j.a
 * JD-Core Version:    0.7.0.1
 */