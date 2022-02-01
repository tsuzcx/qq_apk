package com.tencent.mm.plugin.walletlock.gesture.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.walletlock.a.d;
import com.tencent.mm.plugin.walletlock.a.e;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/walletlock/gesture/model/FingerprintWalletLockUIAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "lastText", "", "getLastText", "()Ljava/lang/String;", "setLastText", "(Ljava/lang/String;)V", "initConfig", "", "Companion", "plugin-wallet-lock_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  private static final String TAG;
  public static final a Wgk;
  private String mph;
  
  static
  {
    AppMethodBeat.i(266856);
    Wgk = new a((byte)0);
    TAG = "FingerprintWalletLockUIAccessibilityConfig";
    AppMethodBeat.o(266856);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(266855);
    this.mph = "";
    AppMethodBeat.o(266855);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(266858);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.e.Wey);
    localConfigHelper.focusFirst(a.d.Wes);
    localConfigHelper.view(a.d.Wes).talkOn((b)b.Wgl);
    AppMethodBeat.o(266858);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/walletlock/gesture/model/FingerprintWalletLockUIAccessibilityConfig$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-wallet-lock_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, Boolean>
  {
    public static final b Wgl;
    
    static
    {
      AppMethodBeat.i(266852);
      Wgl = new b();
      AppMethodBeat.o(266852);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.a.a
 * JD-Core Version:    0.7.0.1
 */