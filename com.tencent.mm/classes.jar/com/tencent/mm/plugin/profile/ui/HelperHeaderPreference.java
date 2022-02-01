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
import com.tencent.mm.f.c.ax;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.v;
import junit.framework.Assert;

@Deprecated
public class HelperHeaderPreference
  extends Preference
{
  private a GZS;
  private as contact;
  private ImageView jiu;
  private TextView jmj;
  private boolean mRv = false;
  private TextView mZA;
  private TextView nmi;
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HelperHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void TB(String paramString)
  {
    AppMethodBeat.i(27252);
    Log.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = ".concat(String.valueOf(paramString)));
    if ((this.jiu != null) && (this.contact.field_username.equals(paramString))) {
      a.b.c(this.jiu, paramString);
    }
    AppMethodBeat.o(27252);
  }
  
  private void initView()
  {
    AppMethodBeat.i(27254);
    if ((!this.mRv) || (this.contact == null))
    {
      Log.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.mRv + "contact = " + this.contact);
      AppMethodBeat.o(27254);
      return;
    }
    TB(this.contact.field_username);
    if (this.mZA != null) {
      this.mZA.setText(this.contact.ayr());
    }
    if (this.GZS != null)
    {
      this.GZS.a(this);
      CharSequence localCharSequence = this.GZS.getHint();
      if (localCharSequence != null)
      {
        this.nmi.setText(localCharSequence);
        this.nmi.setVisibility(0);
        AppMethodBeat.o(27254);
        return;
      }
      this.nmi.setVisibility(8);
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
      this.GZS = parama;
      initView();
      AppMethodBeat.o(27255);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27251);
    this.jiu = ((ImageView)paramView.findViewById(R.h.contact_info_avatar_iv));
    this.jmj = ((TextView)paramView.findViewById(R.h.contact_info_status_tv));
    this.mZA = ((TextView)paramView.findViewById(R.h.contact_info_nickname_tv));
    this.nmi = ((TextView)paramView.findViewById(R.h.contact_info_helper_hing_tv));
    this.mRv = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(27251);
  }
  
  public final void wb(boolean paramBoolean)
  {
    AppMethodBeat.i(27253);
    if (this.GZS == null)
    {
      AppMethodBeat.o(27253);
      return;
    }
    if (paramBoolean)
    {
      this.jmj.setTextColor(v.lC(this.mContext));
      this.jmj.setText(R.l.settings_plugins_installed);
      this.jmj.setCompoundDrawablesWithIntrinsicBounds(R.g.status_enable, 0, 0, 0);
      AppMethodBeat.o(27253);
      return;
    }
    this.jmj.setTextColor(v.lD(this.mContext));
    this.jmj.setText(R.l.settings_plugins_uninstalled);
    this.jmj.setCompoundDrawablesWithIntrinsicBounds(R.g.status_disable, 0, 0, 0);
    AppMethodBeat.o(27253);
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