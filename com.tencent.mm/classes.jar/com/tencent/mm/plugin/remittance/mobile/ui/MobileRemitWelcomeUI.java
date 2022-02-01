package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.ui.k;
import java.util.HashSet;

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
    findViewById(a.f.mobile_remit_welcome_finish_bt).setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(288875);
        Log.i("MicroMsg.mobileRemit.MobileRemitWelcomeUI", "goto MobileRemitNumberInputUI");
        MobileRemitWelcomeUI.a(MobileRemitWelcomeUI.this);
        AppMethodBeat.o(288875);
      }
    });
    aw.a(((TextView)findViewById(a.f.mobile_remit_welcome_title_tv)).getPaint(), 0.8F);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(288917);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(MobileRemitWelcomeUI.a.class);
    AppMethodBeat.o(288917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitWelcomeUI
 * JD-Core Version:    0.7.0.1
 */