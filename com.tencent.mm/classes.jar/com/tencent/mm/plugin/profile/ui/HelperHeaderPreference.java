package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.t;
import junit.framework.Assert;

public class HelperHeaderPreference
  extends Preference
{
  private an contact;
  private ImageView fTj;
  private TextView fWX;
  private boolean jbZ = false;
  private TextView jjZ;
  private TextView jwg;
  private a xip;
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Dw(String paramString)
  {
    AppMethodBeat.i(27252);
    ae.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = ".concat(String.valueOf(paramString)));
    if ((this.fTj != null) && (this.contact.field_username.equals(paramString))) {
      a.b.c(this.fTj, paramString);
    }
    AppMethodBeat.o(27252);
  }
  
  private void initView()
  {
    AppMethodBeat.i(27254);
    if ((!this.jbZ) || (this.contact == null))
    {
      ae.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.jbZ + "contact = " + this.contact);
      AppMethodBeat.o(27254);
      return;
    }
    Dw(this.contact.field_username);
    if (this.jjZ != null) {
      this.jjZ.setText(this.contact.adF());
    }
    if (this.xip != null)
    {
      this.xip.a(this);
      CharSequence localCharSequence = this.xip.getHint();
      if (localCharSequence != null)
      {
        this.jwg.setText(localCharSequence);
        this.jwg.setVisibility(0);
        AppMethodBeat.o(27254);
        return;
      }
      this.jwg.setVisibility(8);
    }
    AppMethodBeat.o(27254);
  }
  
  public final void a(an paraman, a parama)
  {
    AppMethodBeat.i(27255);
    if (paraman != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.contact = paraman;
      this.xip = parama;
      initView();
      AppMethodBeat.o(27255);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27251);
    this.fTj = ((ImageView)paramView.findViewById(2131298597));
    this.fWX = ((TextView)paramView.findViewById(2131298647));
    this.jjZ = ((TextView)paramView.findViewById(2131298631));
    this.jwg = ((TextView)paramView.findViewById(2131298617));
    this.jbZ = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(27251);
  }
  
  public final void pB(boolean paramBoolean)
  {
    AppMethodBeat.i(27253);
    if (this.xip == null)
    {
      AppMethodBeat.o(27253);
      return;
    }
    if (paramBoolean)
    {
      this.fWX.setTextColor(t.kJ(this.mContext));
      this.fWX.setText(2131763360);
      this.fWX.setCompoundDrawablesWithIntrinsicBounds(2131234178, 0, 0, 0);
      AppMethodBeat.o(27253);
      return;
    }
    this.fWX.setTextColor(t.kK(this.mContext));
    this.fWX.setText(2131763368);
    this.fWX.setCompoundDrawablesWithIntrinsicBounds(2131234177, 0, 0, 0);
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