package com.tencent.mm.plugin.remittance.mobile.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import org.xwalk.core.Log;

public class MobileRemitWelcomeUI
  extends MobileRemitBaseUI
{
  public int getLayoutId()
  {
    return a.g.mobile_remit_welcome_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67756);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.c.white));
    setBackGroundColorResource(a.c.white);
    setBackBtn(null);
    ((ImageView)findViewById(a.f.mobile_remit_welcome_icon_iv)).getDrawable().setColorFilter(getResources().getColor(a.c.Brand), PorterDuff.Mode.SRC_ATOP);
    findViewById(a.f.mobile_remit_welcome_finish_bt).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67754);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitWelcomeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.mobileRemit.MobileRemitWelcomeUI", "goto MobileRemitNumberInputUI");
        h.aHG().aHp().set(ar.a.VxD, Boolean.FALSE);
        c.b(MobileRemitWelcomeUI.this.getContext(), "remittance", ".mobile.ui.MobileRemitNumberInputUI", MobileRemitWelcomeUI.this.getIntent());
        MobileRemitWelcomeUI.this.finish();
        a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitWelcomeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67754);
      }
    });
    ar.a(((TextView)findViewById(a.f.mobile_remit_welcome_title_tv)).getPaint(), 0.8F);
    AppMethodBeat.o(67756);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67755);
    super.onCreate(paramBundle);
    initView();
    overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
    AppMethodBeat.o(67755);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitWelcomeUI
 * JD-Core Version:    0.7.0.1
 */