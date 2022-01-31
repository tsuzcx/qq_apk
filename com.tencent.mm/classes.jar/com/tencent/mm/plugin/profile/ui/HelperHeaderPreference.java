package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.s;
import junit.framework.Assert;

public class HelperHeaderPreference
  extends Preference
{
  private ad contact;
  private ImageView ehv;
  private TextView gMv;
  private TextView gpr;
  private boolean gsM = false;
  private TextView pAN;
  private a pAO;
  
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
    AppMethodBeat.i(23641);
    if ((!this.gsM) || (this.contact == null))
    {
      ab.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.gsM + "contact = " + this.contact);
      AppMethodBeat.o(23641);
      return;
    }
    qU(this.contact.field_username);
    if (this.pAN != null) {
      this.pAN.setText(this.contact.Oe());
    }
    if (this.pAO != null)
    {
      this.pAO.a(this);
      CharSequence localCharSequence = this.pAO.getHint();
      if (localCharSequence != null)
      {
        this.gMv.setText(localCharSequence);
        this.gMv.setVisibility(0);
        AppMethodBeat.o(23641);
        return;
      }
      this.gMv.setVisibility(8);
    }
    AppMethodBeat.o(23641);
  }
  
  private void qU(String paramString)
  {
    AppMethodBeat.i(23639);
    ab.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = ".concat(String.valueOf(paramString)));
    if ((this.ehv != null) && (this.contact.field_username.equals(paramString))) {
      a.b.c(this.ehv, paramString);
    }
    AppMethodBeat.o(23639);
  }
  
  public final void a(ad paramad, a parama)
  {
    AppMethodBeat.i(23642);
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.contact = paramad;
      this.pAO = parama;
      initView();
      AppMethodBeat.o(23642);
      return;
    }
  }
  
  public final void kf(boolean paramBoolean)
  {
    AppMethodBeat.i(23640);
    if (this.pAO == null)
    {
      AppMethodBeat.o(23640);
      return;
    }
    if (paramBoolean)
    {
      this.gpr.setTextColor(s.iD(this.mContext));
      this.gpr.setText(2131303378);
      this.gpr.setCompoundDrawablesWithIntrinsicBounds(2130840454, 0, 0, 0);
      AppMethodBeat.o(23640);
      return;
    }
    this.gpr.setTextColor(s.iE(this.mContext));
    this.gpr.setText(2131303386);
    this.gpr.setCompoundDrawablesWithIntrinsicBounds(2130840453, 0, 0, 0);
    AppMethodBeat.o(23640);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23638);
    this.ehv = ((ImageView)paramView.findViewById(2131821497));
    this.gpr = ((TextView)paramView.findViewById(2131823105));
    this.pAN = ((TextView)paramView.findViewById(2131821498));
    this.gMv = ((TextView)paramView.findViewById(2131821499));
    this.gsM = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(23638);
  }
  
  public static abstract interface a
  {
    public abstract void a(HelperHeaderPreference paramHelperHeaderPreference);
    
    public abstract CharSequence getHint();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.HelperHeaderPreference
 * JD-Core Version:    0.7.0.1
 */