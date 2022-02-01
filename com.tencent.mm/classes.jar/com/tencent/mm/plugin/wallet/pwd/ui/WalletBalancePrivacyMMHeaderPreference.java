package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.d;
import com.tencent.mm.aw.q;
import com.tencent.mm.aw.r;
import com.tencent.mm.aw.r.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Map;

public class WalletBalancePrivacyMMHeaderPreference
  extends Preference
{
  String dDH;
  private int lZt;
  String title;
  Map<String, r.a> xVn;
  
  public WalletBalancePrivacyMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(69588);
    this.xVn = new HashMap();
    AppMethodBeat.o(69588);
  }
  
  public WalletBalancePrivacyMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69587);
    this.xVn = new HashMap();
    AppMethodBeat.o(69587);
  }
  
  public final void gk()
  {
    this.lZt = 2131689519;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69589);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131297104);
    paramView = (TextView)paramView.findViewById(2131297105);
    if (bt.isNullOrNil(this.dDH)) {
      if (!bt.jx(this.lZt, 0)) {
        ((ImageView)localObject).setImageResource(this.lZt);
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(this.title)) {
        paramView.setText(this.title);
      }
      AppMethodBeat.o(69589);
      return;
      q.aIE();
      Bitmap localBitmap = d.vT(this.dDH);
      if (localBitmap != null)
      {
        ((ImageView)localObject).setImageBitmap(localBitmap);
      }
      else if (!bt.isNullOrNil(this.dDH))
      {
        localObject = new r.a()
        {
          public final void a(String paramAnonymousString1, Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            AppMethodBeat.i(69586);
            ad.i("MicroMsg.WalletBalancePrivacyMMHeaderPreference", "alvinluo icon url: %s", new Object[] { paramAnonymousString1 });
            this.xVo.setImageBitmap(paramAnonymousBitmap);
            AppMethodBeat.o(69586);
          }
        };
        this.xVn.put(this.dDH, localObject);
        q.aII().a(this.dDH, (r.a)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyMMHeaderPreference
 * JD-Core Version:    0.7.0.1
 */