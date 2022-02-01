package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.t;
import junit.framework.Assert;

public class HelperHeaderPreference
  extends Preference
{
  private am contact;
  private ImageView fRd;
  private TextView fUR;
  private boolean iZg = false;
  private TextView jhg;
  private TextView jtn;
  private a wSy;
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void CU(String paramString)
  {
    AppMethodBeat.i(27252);
    ad.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = ".concat(String.valueOf(paramString)));
    if ((this.fRd != null) && (this.contact.field_username.equals(paramString))) {
      a.b.c(this.fRd, paramString);
    }
    AppMethodBeat.o(27252);
  }
  
  private void initView()
  {
    AppMethodBeat.i(27254);
    if ((!this.iZg) || (this.contact == null))
    {
      ad.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.iZg + "contact = " + this.contact);
      AppMethodBeat.o(27254);
      return;
    }
    CU(this.contact.field_username);
    if (this.jhg != null) {
      this.jhg.setText(this.contact.adu());
    }
    if (this.wSy != null)
    {
      this.wSy.a(this);
      CharSequence localCharSequence = this.wSy.getHint();
      if (localCharSequence != null)
      {
        this.jtn.setText(localCharSequence);
        this.jtn.setVisibility(0);
        AppMethodBeat.o(27254);
        return;
      }
      this.jtn.setVisibility(8);
    }
    AppMethodBeat.o(27254);
  }
  
  public final void a(am paramam, a parama)
  {
    AppMethodBeat.i(27255);
    if (paramam != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.contact = paramam;
      this.wSy = parama;
      initView();
      AppMethodBeat.o(27255);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27251);
    this.fRd = ((ImageView)paramView.findViewById(2131298597));
    this.fUR = ((TextView)paramView.findViewById(2131298647));
    this.jhg = ((TextView)paramView.findViewById(2131298631));
    this.jtn = ((TextView)paramView.findViewById(2131298617));
    this.iZg = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(27251);
  }
  
  public final void pt(boolean paramBoolean)
  {
    AppMethodBeat.i(27253);
    if (this.wSy == null)
    {
      AppMethodBeat.o(27253);
      return;
    }
    if (paramBoolean)
    {
      this.fUR.setTextColor(t.kC(this.mContext));
      this.fUR.setText(2131763360);
      this.fUR.setCompoundDrawablesWithIntrinsicBounds(2131234178, 0, 0, 0);
      AppMethodBeat.o(27253);
      return;
    }
    this.fUR.setTextColor(t.kD(this.mContext));
    this.fUR.setText(2131763368);
    this.fUR.setCompoundDrawablesWithIntrinsicBounds(2131234177, 0, 0, 0);
    AppMethodBeat.o(27253);
  }
  
  public static abstract interface a
  {
    public abstract void a(HelperHeaderPreference paramHelperHeaderPreference);
    
    public abstract CharSequence getHint();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.HelperHeaderPreference
 * JD-Core Version:    0.7.0.1
 */