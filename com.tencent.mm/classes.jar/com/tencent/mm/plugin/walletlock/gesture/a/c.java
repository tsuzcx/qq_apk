package com.tencent.mm.plugin.walletlock.gesture.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.walletlock.a.d;
import com.tencent.mm.plugin.walletlock.a.e;
import com.tencent.mm.plugin.walletlock.a.g;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/walletlock/gesture/model/GestureGuardLogicUIAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "lastText", "", "getLastText", "()Ljava/lang/String;", "setLastText", "(Ljava/lang/String;)V", "initConfig", "", "Companion", "plugin-wallet-lock_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends MMBaseAccessibilityConfig
{
  private static final String TAG;
  public static final a Wgo;
  String mph;
  
  static
  {
    AppMethodBeat.i(266859);
    Wgo = new a((byte)0);
    TAG = "GestureGuardLogicUIAccessibilityConfig";
    AppMethodBeat.o(266859);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(266857);
    this.mph = "";
    AppMethodBeat.o(266857);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(266860);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.e.Wez);
    localConfigHelper.focusFirst(a.d.goF);
    localConfigHelper.view(a.d.Wet).disable();
    localConfigHelper.view(a.d.Weu).desc(a.g.WfA);
    localConfigHelper.view(a.d.goF).talkOn((b)new b(this));
    AppMethodBeat.o(266860);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/walletlock/gesture/model/GestureGuardLogicUIAccessibilityConfig$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-wallet-lock_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, Boolean>
  {
    b(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.c
 * JD-Core Version:    0.7.0.1
 */