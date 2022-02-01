package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.u;
import junit.framework.Assert;

public class HelperHeaderPreference
  extends Preference
{
  private a Bgj;
  private as contact;
  private TextView gCd;
  private ImageView gyr;
  private boolean kac = false;
  private TextView kib;
  private TextView kuu;
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Mg(String paramString)
  {
    AppMethodBeat.i(27252);
    Log.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = ".concat(String.valueOf(paramString)));
    if ((this.gyr != null) && (this.contact.field_username.equals(paramString))) {
      a.b.c(this.gyr, paramString);
    }
    AppMethodBeat.o(27252);
  }
  
  private void initView()
  {
    AppMethodBeat.i(27254);
    if ((!this.kac) || (this.contact == null))
    {
      Log.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.kac + "contact = " + this.contact);
      AppMethodBeat.o(27254);
      return;
    }
    Mg(this.contact.field_username);
    if (this.kib != null) {
      this.kib.setText(this.contact.arI());
    }
    if (this.Bgj != null)
    {
      this.Bgj.a(this);
      CharSequence localCharSequence = this.Bgj.getHint();
      if (localCharSequence != null)
      {
        this.kuu.setText(localCharSequence);
        this.kuu.setVisibility(0);
        AppMethodBeat.o(27254);
        return;
      }
      this.kuu.setVisibility(8);
    }
    AppMethodBeat.o(27254);
  }
  
  public final void a(as paramas, a parama)
  {
    AppMethodBeat.i(27255);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.contact = paramas;
      this.Bgj = parama;
      initView();
      AppMethodBeat.o(27255);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27251);
    this.gyr = ((ImageView)paramView.findViewById(2131299034));
    this.gCd = ((TextView)paramView.findViewById(2131299084));
    this.kib = ((TextView)paramView.findViewById(2131299068));
    this.kuu = ((TextView)paramView.findViewById(2131299054));
    this.kac = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(27251);
  }
  
  public final void sK(boolean paramBoolean)
  {
    AppMethodBeat.i(27253);
    if (this.Bgj == null)
    {
      AppMethodBeat.o(27253);
      return;
    }
    if (paramBoolean)
    {
      this.gCd.setTextColor(u.kF(this.mContext));
      this.gCd.setText(2131765542);
      this.gCd.setCompoundDrawablesWithIntrinsicBounds(2131235049, 0, 0, 0);
      AppMethodBeat.o(27253);
      return;
    }
    this.gCd.setTextColor(u.kG(this.mContext));
    this.gCd.setText(2131765550);
    this.gCd.setCompoundDrawablesWithIntrinsicBounds(2131235048, 0, 0, 0);
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