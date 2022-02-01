package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.c;
import com.tencent.mm.av.o;
import com.tencent.mm.av.p;
import com.tencent.mm.av.p.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Map;

public class BankMobileRemitChooseMMHeaderPreference
  extends Preference
{
  private String drM;
  private int lzV;
  private String title;
  private Map<String, p.a> wHG;
  
  public BankMobileRemitChooseMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67662);
    this.wHG = new HashMap();
    AppMethodBeat.o(67662);
  }
  
  public BankMobileRemitChooseMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(67661);
    this.wHG = new HashMap();
    AppMethodBeat.o(67661);
  }
  
  public final void fS()
  {
    this.lzV = 2131689519;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(67663);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131297104);
    paramView = (TextView)paramView.findViewById(2131297105);
    if (bs.isNullOrNil(this.drM)) {
      if (!bs.jl(this.lzV, 0)) {
        ((ImageView)localObject).setImageResource(this.lzV);
      }
    }
    for (;;)
    {
      if (!bs.isNullOrNil(this.title)) {
        paramView.setText(this.title);
      }
      AppMethodBeat.o(67663);
      return;
      o.aFw();
      Bitmap localBitmap = c.te(this.drM);
      if (localBitmap != null)
      {
        ((ImageView)localObject).setImageBitmap(localBitmap);
      }
      else if (!bs.isNullOrNil(this.drM))
      {
        localObject = new p.a()
        {
          public final void a(String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            AppMethodBeat.i(67660);
            ac.i("MicroMsg.mobileRemit.BankMobileRemitChooseMMHeaderPreference", "icon url: %s", new Object[] { paramAnonymousString1 });
            this.wHH.setImageBitmap(paramAnonymousBitmap);
            AppMethodBeat.o(67660);
          }
        };
        this.wHG.put(this.drM, localObject);
        o.aFA().a(this.drM, (p.a)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.BankMobileRemitChooseMMHeaderPreference
 * JD-Core Version:    0.7.0.1
 */