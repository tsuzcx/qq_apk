package com.tencent.mm.plugin.mv.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.b;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.ui.uic.e;
import com.tencent.mm.plugin.mv.ui.uic.f;
import com.tencent.mm.plugin.mv.ui.uic.g;
import com.tencent.mm.plugin.mv.ui.uic.h;
import com.tencent.mm.plugin.mv.ui.uic.i;
import com.tencent.mm.plugin.mv.ui.uic.j;
import com.tencent.mm.plugin.mv.ui.uic.u;
import com.tencent.mm.plugin.mv.ui.uic.w;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/MusicMvMainUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "musicCheckErrorListener", "Lcom/tencent/mm/sdk/event/IListener;", "musicPlayEventListener", "com/tencent/mm/plugin/mv/ui/MusicMvMainUI$musicPlayEventListener$1", "Lcom/tencent/mm/plugin/mv/ui/MusicMvMainUI$musicPlayEventListener$1;", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "processPlayError", "errMsg", "plugin-mv_release"})
public final class MusicMvMainUI
  extends BaseMusicMvUI
{
  private final MusicMvMainUI.b Gee;
  final String TAG;
  private HashMap _$_findViewCache;
  private final IListener<?> wNM;
  
  public MusicMvMainUI()
  {
    AppMethodBeat.i(233105);
    this.TAG = "MicroMsg.Mv.MusicMvMainUI";
    this.Gee = new MusicMvMainUI.b(this);
    this.wNM = ((IListener)new MusicMvMainUI.a(this));
    AppMethodBeat.o(233105);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(233112);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(233112);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(233110);
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
    AppMethodBeat.o(233110);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.f.FZF;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(233097);
    Set localSet = super.importUIComponents();
    if (localSet != null)
    {
      localSet = ak.b(localSet, (Iterable)ak.setOf(new Class[] { g.class, u.class, w.class, i.class, e.class, com.tencent.mm.plugin.mv.ui.uic.k.class, com.tencent.mm.plugin.mv.ui.uic.a.class, h.class, j.class, f.class }));
      AppMethodBeat.o(233097);
      return localSet;
    }
    AppMethodBeat.o(233097);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233098);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.plugin.music.e.k.isInit())
    {
      finish();
      Log.e(this.TAG, "MusicPlayerManager is not init!");
      AppMethodBeat.o(233098);
      return;
    }
    paramBundle = getIntent();
    p.j(paramBundle, "intent");
    b.am(paramBundle.getExtras());
    hideTitleView();
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(b.b.transparent));
    hideActionbarLine();
    AppMethodBeat.o(233098);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(233100);
    super.onNewIntent(paramIntent);
    Log.i(this.TAG, "onNewIntent");
    AppMethodBeat.o(233100);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(233104);
    super.onPause();
    c localc = c.FRf;
    c.feJ();
    this.Gee.dead();
    this.wNM.dead();
    AppMethodBeat.o(233104);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(233103);
    super.onResume();
    c localc = c.FRf;
    c.onResume();
    this.Gee.alive();
    this.wNM.alive();
    AppMethodBeat.o(233103);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvMainUI
 * JD-Core Version:    0.7.0.1
 */