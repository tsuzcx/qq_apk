package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.t;
import junit.framework.Assert;

public class HelperHeaderPreference
  extends Preference
{
  private ai contact;
  private TextView fBE;
  private ImageView fxQ;
  private boolean iFX = false;
  private TextView iNX;
  private TextView jae;
  private a vLp;
  
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
    if ((!this.iFX) || (this.contact == null))
    {
      ac.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.iFX + "contact = " + this.contact);
      AppMethodBeat.o(27254);
      return;
    }
    zV(this.contact.field_username);
    if (this.iNX != null) {
      this.iNX.setText(this.contact.aaR());
    }
    if (this.vLp != null)
    {
      this.vLp.a(this);
      CharSequence localCharSequence = this.vLp.getHint();
      if (localCharSequence != null)
      {
        this.jae.setText(localCharSequence);
        this.jae.setVisibility(0);
        AppMethodBeat.o(27254);
        return;
      }
      this.jae.setVisibility(8);
    }
    AppMethodBeat.o(27254);
  }
  
  private void zV(String paramString)
  {
    AppMethodBeat.i(27252);
    ac.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = ".concat(String.valueOf(paramString)));
    if ((this.fxQ != null) && (this.contact.field_username.equals(paramString))) {
      a.b.c(this.fxQ, paramString);
    }
    AppMethodBeat.o(27252);
  }
  
  public final void a(ai paramai, a parama)
  {
    AppMethodBeat.i(27255);
    if (paramai != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.contact = paramai;
      this.vLp = parama;
      initView();
      AppMethodBeat.o(27255);
      return;
    }
  }
  
  public final void oU(boolean paramBoolean)
  {
    AppMethodBeat.i(27253);
    if (this.vLp == null)
    {
      AppMethodBeat.o(27253);
      return;
    }
    if (paramBoolean)
    {
      this.fBE.setTextColor(t.kq(this.mContext));
      this.fBE.setText(2131763360);
      this.fBE.setCompoundDrawablesWithIntrinsicBounds(2131234178, 0, 0, 0);
      AppMethodBeat.o(27253);
      return;
    }
    this.fBE.setTextColor(t.kr(this.mContext));
    this.fBE.setText(2131763368);
    this.fBE.setCompoundDrawablesWithIntrinsicBounds(2131234177, 0, 0, 0);
    AppMethodBeat.o(27253);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27251);
    this.fxQ = ((ImageView)paramView.findViewById(2131298597));
    this.fBE = ((TextView)paramView.findViewById(2131298647));
    this.iNX = ((TextView)paramView.findViewById(2131298631));
    this.jae = ((TextView)paramView.findViewById(2131298617));
    this.iFX = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.HelperHeaderPreference
 * JD-Core Version:    0.7.0.1
 */