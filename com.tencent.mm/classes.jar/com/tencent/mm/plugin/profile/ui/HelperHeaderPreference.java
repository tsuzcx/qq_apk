package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.u;
import junit.framework.Assert;

@Deprecated
public class HelperHeaderPreference
  extends Preference
{
  private a MXX;
  private au contact;
  private ImageView lKK;
  private TextView lPf;
  private boolean pOc = false;
  private TextView pWj;
  private TextView qjr;
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void LB(String paramString)
  {
    AppMethodBeat.i(27252);
    Log.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = ".concat(String.valueOf(paramString)));
    if ((this.lKK != null) && (this.contact.field_username.equals(paramString))) {
      a.b.g(this.lKK, paramString);
    }
    AppMethodBeat.o(27252);
  }
  
  private void initView()
  {
    AppMethodBeat.i(27254);
    if ((!this.pOc) || (this.contact == null))
    {
      Log.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.pOc + "contact = " + this.contact);
      AppMethodBeat.o(27254);
      return;
    }
    LB(this.contact.field_username);
    if (this.pWj != null) {
      this.pWj.setText(this.contact.aSU());
    }
    if (this.MXX != null)
    {
      this.MXX.a(this);
      CharSequence localCharSequence = this.MXX.getHint();
      if (localCharSequence != null)
      {
        this.qjr.setText(localCharSequence);
        this.qjr.setVisibility(0);
        AppMethodBeat.o(27254);
        return;
      }
      this.qjr.setVisibility(8);
    }
    AppMethodBeat.o(27254);
  }
  
  public final void Ay(boolean paramBoolean)
  {
    AppMethodBeat.i(27253);
    if (this.MXX == null)
    {
      AppMethodBeat.o(27253);
      return;
    }
    if (paramBoolean)
    {
      this.lPf.setTextColor(u.nF(this.mContext));
      this.lPf.setText(R.l.settings_plugins_installed);
      this.lPf.setCompoundDrawablesWithIntrinsicBounds(R.g.status_enable, 0, 0, 0);
      AppMethodBeat.o(27253);
      return;
    }
    this.lPf.setTextColor(u.nG(this.mContext));
    this.lPf.setText(R.l.settings_plugins_uninstalled);
    this.lPf.setCompoundDrawablesWithIntrinsicBounds(R.g.status_disable, 0, 0, 0);
    AppMethodBeat.o(27253);
  }
  
  public final void a(au paramau, a parama)
  {
    AppMethodBeat.i(27255);
    if (paramau != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.contact = paramau;
      this.MXX = parama;
      initView();
      AppMethodBeat.o(27255);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27251);
    this.lKK = ((ImageView)paramView.findViewById(R.h.contact_info_avatar_iv));
    this.lPf = ((TextView)paramView.findViewById(R.h.contact_info_status_tv));
    this.pWj = ((TextView)paramView.findViewById(R.h.contact_info_nickname_tv));
    this.qjr = ((TextView)paramView.findViewById(R.h.contact_info_helper_hing_tv));
    this.pOc = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.HelperHeaderPreference
 * JD-Core Version:    0.7.0.1
 */