package com.tencent.mm.plugin.mv.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.model.b;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.mv.ui.uic.KeyboardProviderUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvChattingUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvCommentUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvDataUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvDebugUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvInfoUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvLyricUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvShareUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvSongInfoUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@a(32)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/MusicMvMainUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "plugin-mv_release"})
public final class MusicMvMainUI
  extends BaseMusicMvUI
{
  private final String TAG = "MicroMsg.Mv.MusicMvMainUI";
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(256864);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(256864);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256863);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(256863);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131495790;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(256858);
    Set localSet = super.importUIComponents();
    if (localSet != null)
    {
      localSet = ak.b(localSet, (Iterable)ak.setOf(new Class[] { MusicMvDataUIC.class, MusicMvShareUIC.class, MusicMvSongInfoUIC.class, MusicMvInfoUIC.class, MusicMvChattingUIC.class, MusicMvMainUIC.class, KeyboardProviderUIC.class, MusicMvDebugUIC.class, MusicMvLyricUIC.class, MusicMvCommentUIC.class }));
      AppMethodBeat.o(256858);
      return localSet;
    }
    AppMethodBeat.o(256858);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256859);
    super.onCreate(paramBundle);
    if (!k.isInit())
    {
      finish();
      Log.e(this.TAG, "MusicPlayerManager is not init!");
      AppMethodBeat.o(256859);
      return;
    }
    paramBundle = getIntent();
    p.g(paramBundle, "intent");
    b.as(paramBundle.getExtras());
    hideTitleView();
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    paramBundle = getContext();
    p.g(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(2131101287));
    hideActionbarLine();
    AppMethodBeat.o(256859);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(256860);
    super.onNewIntent(paramIntent);
    Log.i(this.TAG, "onNewIntent");
    AppMethodBeat.o(256860);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(256862);
    super.onPause();
    c localc = c.Akc;
    c.gFa();
    AppMethodBeat.o(256862);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(256861);
    super.onResume();
    c localc = c.Akc;
    c.onResume();
    AppMethodBeat.o(256861);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvMainUI
 * JD-Core Version:    0.7.0.1
 */