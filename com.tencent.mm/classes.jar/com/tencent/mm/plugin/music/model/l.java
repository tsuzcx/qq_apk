package com.tencent.mm.plugin.music.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/model/MusicUIUtil;", "", "()V", "CANCEL_JUMP", "", "FROM_ACTION_BAR_RIGHT", "FROM_ACTION_FORWARD", "FROM_ACTION_SET_STATUS", "FROM_SONG_DIALOG", "JUMP_ERROR_WITH_NO_WRAPPER", "JUMP_TO_APP", "JUMP_TO_APPBRAND", "JUMP_TO_BIZ", "JUMP_TO_CALLBACK", "JUMP_TO_SHAKE_QQ_MUSIC", "JUMP_TO_WEB", "TAG", "", "doJumpToApp", "context", "Landroid/content/Context;", "wrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "callback", "Lcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;", "formatFinderNumber", "number", "getBgAndLyricColor", "", "bitmap", "Landroid/graphics/Bitmap;", "getCurrentMusic", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "activity", "Landroid/app/Activity;", "isChinesePeople", "", "isoCode", "jumpToSongWebUrl", "", "jumpToWebUrl", "url", "launchQQMusic", "setWindowStyle", "isShowStatusBar", "isShowNavigationBar", "updatePlayIcon", "isChecked", "playBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "playBtnColor", "plugin-music_release"})
public final class l
{
  public static final l FRM;
  
  static
  {
    AppMethodBeat.i(259501);
    FRM = new l();
    AppMethodBeat.o(259501);
  }
  
  public static void a(Context paramContext, f paramf)
  {
    AppMethodBeat.i(259492);
    if (paramf.lVB == null) {}
    for (paramf = paramf.lVz;; paramf = paramf.lVB)
    {
      p.j(paramf, "url");
      bv(paramContext, paramf);
      AppMethodBeat.o(259492);
      return;
    }
  }
  
  public static a aA(Activity paramActivity)
  {
    AppMethodBeat.i(259500);
    p.k(paramActivity, "activity");
    Object localObject = b.bm(e.class);
    p.j(localObject, "MusicCoreService.service…PrivateLogic::class.java)");
    a locala = ((e)localObject).fei();
    if (locala == null)
    {
      localObject = "";
      if (paramActivity.getIntent().hasExtra("db_music_id"))
      {
        localObject = paramActivity.getIntent().getStringExtra("db_music_id");
        p.j(localObject, "activity.intent.getStrin…MusicPlayerUI.KDBMusicId)");
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    for (paramActivity = ((e)b.bm(e.class)).aSa((String)localObject);; paramActivity = locala)
    {
      AppMethodBeat.o(259500);
      return paramActivity;
    }
  }
  
  public static void aw(Activity paramActivity)
  {
    AppMethodBeat.i(259498);
    p.k(paramActivity, "activity");
    Object localObject = paramActivity.getWindow();
    p.j(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    p.j(localObject, "activity.window.decorView");
    ((View)localObject).setSystemUiVisibility(5894);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.getWindow().addFlags(-2147483648);
      localObject = paramActivity.getWindow();
      p.j(localObject, "activity.window");
      ((Window)localObject).setStatusBarColor(0);
      localObject = paramActivity.getWindow();
      p.j(localObject, "activity.window");
      ((Window)localObject).setNavigationBarColor(0);
    }
    paramActivity.getWindow().setFormat(-3);
    AppMethodBeat.o(259498);
  }
  
  public static void bv(Context paramContext, String paramString)
  {
    AppMethodBeat.i(259494);
    Log.i("MusicUIUtil", "launch H5 url:%s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(259494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.l
 * JD-Core Version:    0.7.0.1
 */