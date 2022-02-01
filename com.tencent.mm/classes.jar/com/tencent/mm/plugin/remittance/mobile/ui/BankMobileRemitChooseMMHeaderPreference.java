package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.av.r.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Map;

public class BankMobileRemitChooseMMHeaderPreference
  extends Preference
{
  private String dEM;
  private int mdM;
  private String title;
  private Map<String, r.a> ylg;
  
  public BankMobileRemitChooseMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67662);
    this.ylg = new HashMap();
    AppMethodBeat.o(67662);
  }
  
  public BankMobileRemitChooseMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(67661);
    this.ylg = new HashMap();
    AppMethodBeat.o(67661);
  }
  
  public final void gk()
  {
    this.mdM = 2131689519;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(67663);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131297104);
    paramView = (TextView)paramView.findViewById(2131297105);
    if (bu.isNullOrNil(this.dEM)) {
      if (!bu.jB(this.mdM, 0)) {
        ((ImageView)localObject).setImageResource(this.mdM);
      }
    }
    for (;;)
    {
      if (!bu.isNullOrNil(this.title)) {
        paramView.setText(this.title);
      }
      AppMethodBeat.o(67663);
      return;
      q.aIW();
      Bitmap localBitmap = d.wA(this.dEM);
      if (localBitmap != null)
      {
        ((ImageView)localObject).setImageBitmap(localBitmap);
      }
      else if (!bu.isNullOrNil(this.dEM))
      {
        localObject = new r.a()
        {
          public final void a(String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            AppMethodBeat.i(67660);
            ae.i("MicroMsg.mobileRemit.BankMobileRemitChooseMMHeaderPreference", "icon url: %s", new Object[] { paramAnonymousString1 });
            this.ylh.setImageBitmap(paramAnonymousBitmap);
            AppMethodBeat.o(67660);
          }
        };
        this.ylg.put(this.dEM, localObject);
        q.aJa().a(this.dEM, (r.a)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.BankMobileRemitChooseMMHeaderPreference
 * JD-Core Version:    0.7.0.1
 */