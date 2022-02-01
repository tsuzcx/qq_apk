package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Activity;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet_core/utils/VerifyPwdAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "firstFocus", "", "getFirstFocus", "()Z", "setFirstFocus", "(Z)V", "focusSubTitle", "", "initConfig", "onUserVisibleFocused", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends MMBaseAccessibilityConfig
{
  private boolean VYi;
  
  public i(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(301412);
    AppMethodBeat.o(301412);
  }
  
  public final void imc()
  {
    AppMethodBeat.i(301420);
    ((TextView)getContext().findViewById(a.f.wallet_pwd_content)).sendAccessibilityEvent(128);
    AppMethodBeat.o(301420);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(301415);
    root(a.g.wallet_check_pwd).view(a.f.input_et).expand(12, 12, 12, 12);
    AppMethodBeat.o(301415);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(301424);
    super.onUserVisibleFocused();
    if (!this.VYi)
    {
      this.VYi = true;
      imc();
    }
    AppMethodBeat.o(301424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.i
 * JD-Core Version:    0.7.0.1
 */