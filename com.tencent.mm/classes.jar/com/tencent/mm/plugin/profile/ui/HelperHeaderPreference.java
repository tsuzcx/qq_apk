package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.p;
import junit.framework.Assert;

public class HelperHeaderPreference
  extends Preference
{
  private ad dnp;
  private ImageView dpY;
  private TextView eXu;
  private boolean faU = false;
  private TextView fuT;
  private TextView mYa;
  private HelperHeaderPreference.a mYb;
  
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
    if ((!this.faU) || (this.dnp == null)) {
      y.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.faU + "contact = " + this.dnp);
    }
    do
    {
      return;
      localObject = this.dnp.field_username;
      y.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = " + (String)localObject);
      if ((this.dpY != null) && (this.dnp.field_username.equals(localObject))) {
        a.b.a(this.dpY, (String)localObject);
      }
      if (this.mYa != null) {
        this.mYa.setText(this.dnp.Bp());
      }
    } while (this.mYb == null);
    this.mYb.a(this);
    Object localObject = this.mYb.getHint();
    if (localObject != null)
    {
      this.fuT.setText((CharSequence)localObject);
      this.fuT.setVisibility(0);
      return;
    }
    this.fuT.setVisibility(8);
  }
  
  public final void a(ad paramad, HelperHeaderPreference.a parama)
  {
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.dnp = paramad;
      this.mYb = parama;
      initView();
      return;
    }
  }
  
  public final void ig(boolean paramBoolean)
  {
    if (this.mYb == null) {
      return;
    }
    if (paramBoolean)
    {
      this.eXu.setTextColor(p.hf(this.mContext));
      this.eXu.setText(R.l.settings_plugins_installed);
      this.eXu.setCompoundDrawablesWithIntrinsicBounds(R.g.status_enable, 0, 0, 0);
      return;
    }
    this.eXu.setTextColor(p.hg(this.mContext));
    this.eXu.setText(R.l.settings_plugins_uninstalled);
    this.eXu.setCompoundDrawablesWithIntrinsicBounds(R.g.status_disable, 0, 0, 0);
  }
  
  public final void onBindView(View paramView)
  {
    this.dpY = ((ImageView)paramView.findViewById(R.h.contact_info_avatar_iv));
    this.eXu = ((TextView)paramView.findViewById(R.h.contact_info_status_tv));
    this.mYa = ((TextView)paramView.findViewById(R.h.contact_info_nickname_tv));
    this.fuT = ((TextView)paramView.findViewById(R.h.contact_info_helper_hing_tv));
    this.faU = true;
    initView();
    super.onBindView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.HelperHeaderPreference
 * JD-Core Version:    0.7.0.1
 */