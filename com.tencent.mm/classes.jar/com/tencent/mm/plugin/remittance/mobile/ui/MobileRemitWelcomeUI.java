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
import com.tencent.mm.ak.n;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.al;
import org.xwalk.core.Log;

public class MobileRemitWelcomeUI
  extends MobileRemitBaseUI
{
  public int getLayoutId()
  {
    return 2131494934;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67756);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    setBackGroundColorResource(2131101179);
    setBackBtn(null);
    ((ImageView)findViewById(2131302411)).getDrawable().setColorFilter(getResources().getColor(2131099699), PorterDuff.Mode.SRC_ATOP);
    findViewById(2131302409).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67754);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitWelcomeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        Log.i("MicroMsg.mobileRemit.MobileRemitWelcomeUI", "goto MobileRemitNumberInputUI");
        g.ajR().ajA().set(am.a.JaH, Boolean.FALSE);
        d.b(MobileRemitWelcomeUI.this.getContext(), "remittance", ".mobile.ui.MobileRemitNumberInputUI", MobileRemitWelcomeUI.this.getIntent());
        MobileRemitWelcomeUI.this.finish();
        a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitWelcomeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(67754);
      }
    });
    al.a(((TextView)findViewById(2131302415)).getPaint(), 0.8F);
    AppMethodBeat.o(67756);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67755);
    super.onCreate(paramBundle);
    initView();
    overridePendingTransition(2130772144, 2130772141);
    AppMethodBeat.o(67755);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
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