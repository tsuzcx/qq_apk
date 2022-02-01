package com.tencent.mm.plugin.websearch.webview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ov;
import com.tencent.mm.autogen.a.ov.b;
import com.tencent.mm.autogen.mmdata.rpt.uh;
import com.tencent.mm.aw.f;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.websearch.ui.a.a;
import com.tencent.mm.plugin.websearch.ui.a.c;
import com.tencent.mm.plugin.websearch.ui.a.f;
import com.tencent.mm.plugin.websearch.ui.a.g;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchUtils$Companion;", "", "()V", "TAG", "", "VIBRATION_INTENSITY_DEFAULT", "", "VIBRATION_INTENSITY_ERROR", "VIBRATION_INTENSITY_HIGH", "VIBRATION_INTENSITY_LOW", "VIBRATION_INTENSITY_MEDIUM", "doReportClick25208", "", "action", "", "type", "scene", "isTheSameId", "", "id", "playSearchMusic", "paramsObj", "Lorg/json/JSONObject;", "openMv", "toastCommentDialog", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchUtils$Companion$IDismissDialogClickCallBack;", "isOnTopStoryJsapi", "toastInitDialog", "tip", "vibrateShort", "params", "IDismissDialogClickCallBack", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q$a
{
  public static void a(Context paramContext, a parama, String paramString)
  {
    AppMethodBeat.i(315225);
    s.u(paramContext, "context");
    s.u(parama, "callback");
    n localn = new n(paramContext);
    localn.dpM.setImageDrawable(bb.m(paramContext, a.f.icons_outlined_news, paramContext.getResources().getColor(a.a.Yellow)));
    localn.dpM.setVisibility(0);
    localn.adRl.setImageDrawable(paramContext.getDrawable(a.c.top_tip_mode));
    localn.adRl.setVisibility(0);
    ah.a locala = new ah.a();
    localn.bAa(paramString).g(new q.a..ExternalSyntheticLambda0(localn, parama));
    localn.h(new q.a..ExternalSyntheticLambda2(locala, localn, parama));
    localn.bAb(paramContext.getResources().getString(a.g.app_agree));
    localn.agfT = new q.a..ExternalSyntheticLambda4(localn, locala, parama);
    localn.dDn();
    Log.i(q.access$getTAG$cp(), "show education pop window");
    AppMethodBeat.o(315225);
  }
  
  public static void a(Context paramContext, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(315229);
    s.u(paramContext, "context");
    s.u(parama, "callback");
    if (paramBoolean) {}
    for (int i = a.g.top_story_video_click_haokan_education_comment;; i = a.g.top_story_video_click_haokan_education_comment_topstory)
    {
      String str = paramContext.getString(i);
      s.s(str, "context.getString(if (is…ucation_comment_topstory)");
      n localn = new n(paramContext);
      localn.dpM.setImageDrawable(bb.m(paramContext, a.f.icons_outlined_news, paramContext.getResources().getColor(a.a.Yellow)));
      localn.dpM.setVisibility(0);
      ah.a locala = new ah.a();
      localn.bAa(str).g(new q.a..ExternalSyntheticLambda1(localn, parama));
      localn.h(new q.a..ExternalSyntheticLambda3(locala, localn, parama));
      localn.bAb(paramContext.getResources().getString(a.g.app_agree));
      localn.agfT = new q.a..ExternalSyntheticLambda5(localn, locala, parama);
      localn.dDn();
      Log.i(q.access$getTAG$cp(), "show education pop window");
      AppMethodBeat.o(315229);
      return;
    }
  }
  
  private static final void a(n paramn, a parama, View paramView)
  {
    AppMethodBeat.i(315246);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramn);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/webview/WebSearchUtils$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramn, "$tipsDialog");
    s.u(parama, "$callback");
    paramn.adRn = true;
    paramn.cyW();
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("tophitory_show_init_dialog", true).commit();
    parama.hNq();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/websearch/webview/WebSearchUtils$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(315246);
  }
  
  private static final void a(n paramn, ah.a parama, a parama1)
  {
    AppMethodBeat.i(315255);
    s.u(paramn, "$tipsDialog");
    s.u(parama, "$clickCancelToDismiss");
    s.u(parama1, "$callback");
    if ((!paramn.adRn) && (!parama.aiwY))
    {
      MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("tophitory_show_init_dialog", false).commit();
      parama1.hNr();
    }
    AppMethodBeat.o(315255);
  }
  
  private static final void a(ah.a parama, n paramn, a parama1, View paramView)
  {
    AppMethodBeat.i(315251);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramn);
    localb.cH(parama1);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/webview/WebSearchUtils$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$clickCancelToDismiss");
    s.u(paramn, "$tipsDialog");
    s.u(parama1, "$callback");
    parama.aiwY = true;
    paramn.cyW();
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("tophitory_show_init_dialog", false).commit();
    parama1.hNr();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/websearch/webview/WebSearchUtils$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(315251);
  }
  
  private static boolean aUY(String paramString)
  {
    AppMethodBeat.i(315220);
    Object localObject = new ov();
    ((ov)localObject).hRE.action = -2;
    ((ov)localObject).publish();
    localObject = ((ov)localObject).hRF.hRG;
    if ((localObject != null) && (com.tencent.mm.aw.a.e((f)localObject)) && (s.p(paramString, ((f)localObject).oOv)) && (com.tencent.mm.aw.a.bLk()))
    {
      AppMethodBeat.o(315220);
      return true;
    }
    AppMethodBeat.o(315220);
    return false;
  }
  
  private static final void b(n paramn, a parama, View paramView)
  {
    AppMethodBeat.i(315262);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramn);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/webview/WebSearchUtils$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramn, "$tipsDialog");
    s.u(parama, "$callback");
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("tophitory_show_comment_dialog", true).commit();
    paramn.adRn = true;
    paramn.cyW();
    parama.hNq();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/websearch/webview/WebSearchUtils$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(315262);
  }
  
  private static final void b(n paramn, ah.a parama, a parama1)
  {
    AppMethodBeat.i(315274);
    s.u(paramn, "$tipsDialog");
    s.u(parama, "$clickCancelToDismiss");
    s.u(parama1, "$callback");
    if ((!paramn.adRn) && (!parama.aiwY))
    {
      MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("tophitory_show_comment_dialog", false).commit();
      parama1.hNr();
    }
    AppMethodBeat.o(315274);
  }
  
  private static final void b(ah.a parama, n paramn, a parama1, View paramView)
  {
    AppMethodBeat.i(315268);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramn);
    localb.cH(parama1);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/webview/WebSearchUtils$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$clickCancelToDismiss");
    s.u(paramn, "$tipsDialog");
    s.u(parama1, "$callback");
    parama.aiwY = true;
    paramn.cyW();
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("tophitory_show_comment_dialog", false).commit();
    parama1.hNr();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/websearch/webview/WebSearchUtils$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(315268);
  }
  
  public static boolean biO(String paramString)
  {
    long l = 50L;
    AppMethodBeat.i(315197);
    Log.i(q.access$getTAG$cp(), s.X("vibrateShort , type = ", paramString));
    try
    {
      paramString = new JSONObject(paramString);
      localObject = MMApplicationContext.getContext().getSystemService("vibrator");
      if (localObject == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
        AppMethodBeat.o(315197);
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(q.access$getTAG$cp(), (Throwable)paramString, "vibrateShort", new Object[0]);
      AppMethodBeat.o(315197);
      return false;
    }
    Object localObject = (Vibrator)localObject;
    paramString = paramString.get("style");
    int i = q.iqV();
    if (s.p(paramString, "light")) {
      i = q.iqW();
    }
    while (q.iqZ() == i)
    {
      ((Vibrator)localObject).vibrate(50L);
      AppMethodBeat.o(315197);
      return true;
      if (s.p(paramString, "medium")) {
        i = q.iqX();
      } else if (s.p(paramString, "heavy")) {
        i = q.iqY();
      }
    }
    if (q.iqV() == i)
    {
      ((Vibrator)localObject).vibrate(50L);
      AppMethodBeat.o(315197);
      return true;
    }
    if ((Build.VERSION.SDK_INT >= 26) && (((Vibrator)localObject).hasAmplitudeControl())) {
      if (i == q.iqW())
      {
        i = 128;
        l = 15L;
      }
    }
    for (;;)
    {
      if (-1 == i) {
        ((Vibrator)localObject).vibrate(l);
      }
      for (;;)
      {
        AppMethodBeat.o(315197);
        return true;
        if (i == q.iqX())
        {
          i = 192;
          break;
        }
        if (i != q.iqY()) {
          break label312;
        }
        i = 255;
        l = 85L;
        break;
        ((Vibrator)localObject).vibrate(VibrationEffect.createOneShot(l, i));
        continue;
        ((Vibrator)localObject).vibrate(50L);
      }
      label312:
      i = -1;
    }
  }
  
  public static void d(JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(315212);
    s.u(paramJSONObject, "paramsObj");
    Log.i(q.access$getTAG$cp(), "playSearchMusic " + paramJSONObject + " openMv:" + paramBoolean);
    String str1 = paramJSONObject.optString("musicId", "");
    Object localObject1 = paramJSONObject.optString("songName", "");
    String str2 = paramJSONObject.optString("singerName", "");
    Object localObject2 = paramJSONObject.optString("musicWebUrl", "");
    String str3 = paramJSONObject.optString("albumUrl", "");
    String str14 = paramJSONObject.optString("musicDataUrl", "");
    String str15 = paramJSONObject.optString("musicAppId", "");
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
    String str12 = paramJSONObject.optString("mvMakerFinderNickname", "");
    String str13 = paramJSONObject.optString("musicOperationUrl", "");
    String str16 = paramJSONObject.optString("mid", "");
    paramJSONObject = paramJSONObject.optString("sceneNote", "");
    if (paramBoolean)
    {
      if (!((cn)com.tencent.mm.kernel.h.az(cn.class)).canEnterMvAndShowToast())
      {
        AppMethodBeat.o(315212);
        return;
      }
      s.s(str1, "musicId");
      if (!aUY(str1))
      {
        dtj localdtj = new dtj();
        localdtj.YqN = str9;
        localdtj.YqO = str10;
        localdtj.YqP = str11;
        localdtj.YqQ = str12;
        localdtj.songName = ((String)localObject1);
        localdtj.singerName = str2;
        localdtj.RfH = str3;
        localdtj.albumName = str5;
        localdtj.issueDate = l1;
        localdtj.LNC = ((int)l2);
        localdtj.identification = str7;
        localdtj.extraInfo = str8;
        localdtj.songLyric = str4;
        localdtj.musicGenre = str6;
        localdtj.extraInfo = str8;
        com.tencent.mm.aw.a.c(com.tencent.mm.aw.i.a(9, str3, (String)localObject1, str2, (String)localObject2, "", str14, str1, "", "", str5, str15, com.tencent.mm.aw.h.a(str1, localdtj)));
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("key_mv_song_name", (String)localObject1);
      ((Intent)localObject2).putExtra("key_mv_song_lyric", str4);
      ((Intent)localObject2).putExtra("key_mv_album_cover_url", str3);
      ((Intent)localObject2).putExtra("key_mv_feed_id", str9);
      ((Intent)localObject2).putExtra("key_mv_nonce_id", str10);
      ((Intent)localObject2).putExtra("key_mv_cover_url", str11);
      ((Intent)localObject2).putExtra("key_mv_poster", str12);
      ((Intent)localObject2).putExtra("key_mv_singer_name", str2);
      ((Intent)localObject2).putExtra("key_mv_album_name", str5);
      ((Intent)localObject2).putExtra("key_mv_music_genre", str6);
      ((Intent)localObject2).putExtra("key_mv_issue_date", String.valueOf(l1));
      ((Intent)localObject2).putExtra("key_mv_identification", str7);
      ((Intent)localObject2).putExtra("key_mv_extra_info", str8);
      ((Intent)localObject2).putExtra("key_mv_music_duration", (int)l2);
      ((Intent)localObject2).putExtra("key_mv_music_operation_url", str13);
      ((Intent)localObject2).putExtra("key_mv_song_mid", str16);
      ((Intent)localObject2).putExtra("key_mv_scene_note", paramJSONObject);
      paramJSONObject = new dtk();
      localObject1 = com.tencent.mm.plugin.comm.a.xeG;
      paramJSONObject.zIO = com.tencent.mm.plugin.comm.a.dsT();
      paramJSONObject.scene = 18;
      paramJSONObject.aaYQ = str1;
      ((Intent)localObject2).putExtra("key_mv_report_data", paramJSONObject.toByteArray());
      ((Intent)localObject2).setFlags(268435456);
      c.b(MMApplicationContext.getContext(), "mv", ".ui.MusicMvMainUI", (Intent)localObject2);
      AppMethodBeat.o(315212);
      return;
    }
    s.s(str1, "musicId");
    if (!aUY(str1))
    {
      paramJSONObject = new dtj();
      paramJSONObject.YqN = str9;
      paramJSONObject.YqO = str10;
      paramJSONObject.YqP = str11;
      paramJSONObject.YqQ = str12;
      paramJSONObject.songName = ((String)localObject1);
      paramJSONObject.singerName = str2;
      paramJSONObject.RfH = str3;
      paramJSONObject.albumName = str5;
      paramJSONObject.issueDate = l1;
      paramJSONObject.LNC = ((int)l2);
      paramJSONObject.identification = str7;
      paramJSONObject.extraInfo = str8;
      paramJSONObject.songLyric = str4;
      paramJSONObject.musicGenre = str6;
      paramJSONObject.extraInfo = str8;
      paramJSONObject.musicOperationUrl = str13;
      com.tencent.mm.aw.a.c(com.tencent.mm.aw.i.a(9, str3, (String)localObject1, str2, (String)localObject2, "", str14, str1, "", "", str5, str15, com.tencent.mm.aw.h.a(str1, paramJSONObject)));
      AppMethodBeat.o(315212);
      return;
    }
    com.tencent.mm.aw.a.bLg();
    AppMethodBeat.o(315212);
  }
  
  public static void t(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(315237);
    com.tencent.threadpool.h.ahAA.bm(new q.a..ExternalSyntheticLambda6(paramLong1, paramLong2, paramLong3));
    AppMethodBeat.o(315237);
  }
  
  private static final void u(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(315282);
    uh localuh = new uh();
    localuh.ila = paramLong1;
    localuh.ixD = paramLong2;
    localuh.iuA = paramLong3;
    localuh.bMH();
    Log.i(q.access$getTAG$cp(), "25208 ,action = " + localuh.ila + ",actionInfo = " + localuh.ixD + ",actionInfo = " + localuh.iuA);
    AppMethodBeat.o(315282);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchUtils$Companion$IDismissDialogClickCallBack;", "", "dismiss", "", "boolean", "", "onPosition", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void hNq();
    
    public abstract void hNr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.q.a
 * JD-Core Version:    0.7.0.1
 */