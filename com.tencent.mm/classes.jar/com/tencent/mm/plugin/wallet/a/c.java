package com.tencent.mm.plugin.wallet.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/accessibility/PreferenceAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends MMBaseAccessibilityConfig
{
  private static final String TAG;
  public static final a UZa;
  
  static
  {
    AppMethodBeat.i(315540);
    UZa = new a((byte)0);
    TAG = "PreferenceAccessibilityConfig";
    AppMethodBeat.o(315540);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(315537);
    AppMethodBeat.o(315537);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(315544);
    focusFirst(a.f.title_ll, a.g.mm_preference);
    AppMethodBeat.o(315544);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/accessibility/PreferenceAccessibilityConfig$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.c
 * JD-Core Version:    0.7.0.1
 */