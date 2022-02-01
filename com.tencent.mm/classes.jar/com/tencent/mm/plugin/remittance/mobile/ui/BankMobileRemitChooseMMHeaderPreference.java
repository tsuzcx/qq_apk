package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.o;
import com.tencent.mm.aw.p;
import com.tencent.mm.aw.p.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Map;

public class BankMobileRemitChooseMMHeaderPreference
  extends Preference
{
  private String dub;
  private int kYl;
  private String title;
  private Map<String, p.a> vxB;
  
  public BankMobileRemitChooseMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67662);
    this.vxB = new HashMap();
    AppMethodBeat.o(67662);
  }
  
  public BankMobileRemitChooseMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(67661);
    this.vxB = new HashMap();
    AppMethodBeat.o(67661);
  }
  
  public final void fK()
  {
    this.kYl = 2131689519;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(67663);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131297104);
    paramView = (TextView)paramView.findViewById(2131297105);
    if (bt.isNullOrNil(this.dub)) {
      if (!bt.iY(this.kYl, 0)) {
        ((ImageView)localObject).setImageResource(this.kYl);
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(this.title)) {
        paramView.setText(this.title);
      }
      AppMethodBeat.o(67663);
      return;
      o.ayE();
      Bitmap localBitmap = c.pT(this.dub);
      if (localBitmap != null)
      {
        ((ImageView)localObject).setImageBitmap(localBitmap);
      }
      else if (!bt.isNullOrNil(this.dub))
      {
        localObject = new p.a()
        {
          public final void a(String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            AppMethodBeat.i(67660);
            ad.i("MicroMsg.mobileRemit.BankMobileRemitChooseMMHeaderPreference", "icon url: %s", new Object[] { paramAnonymousString1 });
            this.vxC.setImageBitmap(paramAnonymousBitmap);
            AppMethodBeat.o(67660);
          }
        };
        this.vxB.put(this.dub, localObject);
        o.ayI().a(this.dub, (p.a)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.BankMobileRemitChooseMMHeaderPreference
 * JD-Core Version:    0.7.0.1
 */