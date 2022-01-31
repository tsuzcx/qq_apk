package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.c;
import com.tencent.mm.at.o;
import com.tencent.mm.at.p;
import com.tencent.mm.at.p.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Map;

public class WalletBalancePrivacyMMHeaderPreference
  extends Preference
{
  String cDz;
  private int tYn;
  Map<String, p.a> tYo;
  String title;
  
  public WalletBalancePrivacyMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(46209);
    this.tYo = new HashMap();
    AppMethodBeat.o(46209);
  }
  
  public WalletBalancePrivacyMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(46208);
    this.tYo = new HashMap();
    AppMethodBeat.o(46208);
  }
  
  public final void es()
  {
    this.tYn = 2131230766;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(46210);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131828961);
    paramView = (TextView)paramView.findViewById(2131828962);
    if (bo.isNullOrNil(this.cDz)) {
      if (!bo.hl(this.tYn, 0)) {
        ((ImageView)localObject).setImageResource(this.tYn);
      }
    }
    for (;;)
    {
      if (!bo.isNullOrNil(this.title)) {
        paramView.setText(this.title);
      }
      AppMethodBeat.o(46210);
      return;
      o.ahB();
      Bitmap localBitmap = c.lK(this.cDz);
      if (localBitmap != null)
      {
        ((ImageView)localObject).setImageBitmap(localBitmap);
      }
      else if (!bo.isNullOrNil(this.cDz))
      {
        localObject = new WalletBalancePrivacyMMHeaderPreference.1(this, (ImageView)localObject);
        this.tYo.put(this.cDz, localObject);
        o.ahF().a(this.cDz, (p.a)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyMMHeaderPreference
 * JD-Core Version:    0.7.0.1
 */