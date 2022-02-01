package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.t;
import junit.framework.Assert;

public class HelperHeaderPreference
  extends Preference
{
  private af contact;
  private ImageView fuj;
  private TextView fxX;
  private TextView iAd;
  private boolean ifO = false;
  private TextView inR;
  private a uCw;
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void initView()
  {
    AppMethodBeat.i(27254);
    if ((!this.ifO) || (this.contact == null))
    {
      ad.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.ifO + "contact = " + this.contact);
      AppMethodBeat.o(27254);
      return;
    }
    vP(this.contact.field_username);
    if (this.inR != null) {
      this.inR.setText(this.contact.ZW());
    }
    if (this.uCw != null)
    {
      this.uCw.a(this);
      CharSequence localCharSequence = this.uCw.getHint();
      if (localCharSequence != null)
      {
        this.iAd.setText(localCharSequence);
        this.iAd.setVisibility(0);
        AppMethodBeat.o(27254);
        return;
      }
      this.iAd.setVisibility(8);
    }
    AppMethodBeat.o(27254);
  }
  
  private void vP(String paramString)
  {
    AppMethodBeat.i(27252);
    ad.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = ".concat(String.valueOf(paramString)));
    if ((this.fuj != null) && (this.contact.field_username.equals(paramString))) {
      a.b.c(this.fuj, paramString);
    }
    AppMethodBeat.o(27252);
  }
  
  public final void a(af paramaf, a parama)
  {
    AppMethodBeat.i(27255);
    if (paramaf != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.contact = paramaf;
      this.uCw = parama;
      initView();
      AppMethodBeat.o(27255);
      return;
    }
  }
  
  public final void oa(boolean paramBoolean)
  {
    AppMethodBeat.i(27253);
    if (this.uCw == null)
    {
      AppMethodBeat.o(27253);
      return;
    }
    if (paramBoolean)
    {
      this.fxX.setTextColor(t.kf(this.mContext));
      this.fxX.setText(2131763360);
      this.fxX.setCompoundDrawablesWithIntrinsicBounds(2131234178, 0, 0, 0);
      AppMethodBeat.o(27253);
      return;
    }
    this.fxX.setTextColor(t.kg(this.mContext));
    this.fxX.setText(2131763368);
    this.fxX.setCompoundDrawablesWithIntrinsicBounds(2131234177, 0, 0, 0);
    AppMethodBeat.o(27253);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27251);
    this.fuj = ((ImageView)paramView.findViewById(2131298597));
    this.fxX = ((TextView)paramView.findViewById(2131298647));
    this.inR = ((TextView)paramView.findViewById(2131298631));
    this.iAd = ((TextView)paramView.findViewById(2131298617));
    this.ifO = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(27251);
  }
  
  public static abstract interface a
  {
    public abstract void a(HelperHeaderPreference paramHelperHeaderPreference);
    
    public abstract CharSequence getHint();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.HelperHeaderPreference
 * JD-Core Version:    0.7.0.1
 */