package com.tencent.mm.plugin.mv.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.music.model.b;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.ui.uic.d;
import com.tencent.mm.plugin.mv.ui.uic.e;
import com.tencent.mm.plugin.mv.ui.uic.g;
import com.tencent.mm.plugin.mv.ui.uic.h;
import com.tencent.mm.plugin.mv.ui.uic.i;
import com.tencent.mm.plugin.mv.ui.uic.r;
import com.tencent.mm.plugin.mv.ui.uic.t;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/MusicMvMainUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "musicCheckErrorListener", "Lcom/tencent/mm/sdk/event/IListener;", "musicPlayEventListener", "com/tencent/mm/plugin/mv/ui/MusicMvMainUI$musicPlayEventListener$1", "Lcom/tencent/mm/plugin/mv/ui/MusicMvMainUI$musicPlayEventListener$1;", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "processPlayError", "errMsg", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvMainUI
  extends BaseMusicMvUI
{
  private final IListener<?> Akp;
  private final MusicMvMainUI.musicPlayEventListener.1 LZK;
  final String TAG;
  
  public MusicMvMainUI()
  {
    AppMethodBeat.i(286451);
    this.TAG = "MicroMsg.Mv.MusicMvMainUI";
    this.LZK = new MusicMvMainUI.musicPlayEventListener.1(this, com.tencent.mm.app.f.hfK);
    this.Akp = ((IListener)new MusicMvMainUI.musicCheckErrorListener.1(this, com.tencent.mm.app.f.hfK));
    AppMethodBeat.o(286451);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return b.f.LVC;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(286466);
    Set localSet = super.importUIComponents();
    if (localSet == null)
    {
      AppMethodBeat.o(286466);
      return null;
    }
    localSet = ar.b(localSet, (Iterable)ar.setOf(new Class[] { e.class, r.class, t.class, g.class, com.tencent.mm.plugin.mv.ui.uic.c.class, i.class, com.tencent.mm.plugin.mv.ui.uic.a.class, com.tencent.mm.plugin.mv.ui.uic.f.class, h.class, d.class }));
    AppMethodBeat.o(286466);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(286476);
    super.onCreate(paramBundle);
    if (!j.isInit())
    {
      finish();
      Log.e(this.TAG, "MusicPlayerManager is not init!");
      AppMethodBeat.o(286476);
      return;
    }
    com.tencent.mm.plugin.music.f.a.setScene(com.tencent.mm.plugin.music.f.a.LOt);
    b.aK(getIntent().getExtras());
    if (getIntent().getStringExtra("key_mv_thumb_path") == null) {
      b.aOT(getIntent().getStringExtra("key_mv_album_cover_url"));
    }
    hideTitleView();
    paramBundle = getWindow().getDecorView();
    s.s(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    setActionbarColor(getContext().getResources().getColor(b.b.transparent));
    hideActionbarLine();
    AppMethodBeat.o(286476);
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(286492);
    setBounceEnabled(false);
    super.onCreateBeforeSetContentView();
    AppMethodBeat.o(286492);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(286484);
    super.onDestroy();
    com.tencent.mm.plugin.music.f.a.setScene(com.tencent.mm.plugin.music.f.a.LOs);
    AppMethodBeat.o(286484);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(286500);
    super.onNewIntent(paramIntent);
    Log.i(this.TAG, "onNewIntent");
    AppMethodBeat.o(286500);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(286509);
    super.onPause();
    com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.gnQ();
    this.LZK.dead();
    this.Akp.dead();
    AppMethodBeat.o(286509);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(286503);
    super.onResume();
    com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.onResume();
    this.LZK.alive();
    this.Akp.alive();
    AppMethodBeat.o(286503);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvMainUI
 * JD-Core Version:    0.7.0.1
 */