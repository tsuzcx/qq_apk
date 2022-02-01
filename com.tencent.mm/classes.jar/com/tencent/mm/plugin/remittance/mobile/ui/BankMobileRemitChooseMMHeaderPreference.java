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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Map;

public class BankMobileRemitChooseMMHeaderPreference
  extends Preference
{
  private Map<String, r.a> Cmg;
  private String icon;
  private int noe;
  private String title;
  
  public BankMobileRemitChooseMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67662);
    this.Cmg = new HashMap();
    AppMethodBeat.o(67662);
  }
  
  public BankMobileRemitChooseMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(67661);
    this.Cmg = new HashMap();
    AppMethodBeat.o(67661);
  }
  
  public final void gr()
  {
    this.noe = 2131689522;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(67663);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131297247);
    paramView = (TextView)paramView.findViewById(2131297248);
    if (Util.isNullOrNil(this.icon)) {
      if (!Util.isEqual(this.noe, 0)) {
        ((ImageView)localObject).setImageResource(this.noe);
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(this.title)) {
        paramView.setText(this.title);
      }
      AppMethodBeat.o(67663);
      return;
      q.bcQ();
      Bitmap localBitmap = d.EP(this.icon);
      if (localBitmap != null)
      {
        ((ImageView)localObject).setImageBitmap(localBitmap);
      }
      else if (!Util.isNullOrNil(this.icon))
      {
        localObject = new r.a()
        {
          public final void a(String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            AppMethodBeat.i(67660);
            Log.i("MicroMsg.mobileRemit.BankMobileRemitChooseMMHeaderPreference", "icon url: %s", new Object[] { paramAnonymousString1 });
            this.Cmh.setImageBitmap(paramAnonymousBitmap);
            AppMethodBeat.o(67660);
          }
        };
        this.Cmg.put(this.icon, localObject);
        q.bcU().a(this.icon, (r.a)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.BankMobileRemitChooseMMHeaderPreference
 * JD-Core Version:    0.7.0.1
 */