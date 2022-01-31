package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.p;

public class AppHeaderPreference
  extends Preference
{
  boolean cce = false;
  private ImageView dpY;
  private TextView eXu;
  private boolean faU = false;
  private TextView fuT;
  private TextView mYa;
  AppHeaderPreference.a pwX;
  
  public AppHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AppHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(View paramView)
  {
    this.dpY = ((ImageView)paramView.findViewById(R.h.contact_info_avatar_iv));
    this.eXu = ((TextView)paramView.findViewById(R.h.contact_info_status_tv));
    this.mYa = ((TextView)paramView.findViewById(R.h.contact_info_nickname_tv));
    this.fuT = ((TextView)paramView.findViewById(R.h.contact_info_helper_hing_tv));
    this.faU = true;
    if ((!this.faU) || (this.pwX == null)) {
      y.w("MicroMsg.HeaderPreference", "initView : bindView = " + this.faU);
    }
    for (;;)
    {
      super.onBindView(paramView);
      return;
      Object localObject = this.pwX.bMb();
      if ((this.dpY != null) && (localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        this.dpY.setImageBitmap((Bitmap)localObject);
      }
      localObject = this.pwX.bMa();
      if ((this.mYa != null) && (localObject != null) && (((String)localObject).length() > 0)) {
        this.mYa.setText((CharSequence)localObject);
      }
      localObject = this.pwX.getHint();
      if (localObject != null)
      {
        this.fuT.setText((CharSequence)localObject);
        this.fuT.setVisibility(0);
      }
      for (;;)
      {
        boolean bool = this.cce;
        if (this.eXu == null) {
          break;
        }
        localObject = this.pwX.jE(bool);
        if (!bool) {
          break label307;
        }
        if ((localObject == null) || (((String)localObject).length() <= 0)) {
          break label295;
        }
        this.eXu.setTextColor(p.hf(this.mContext));
        this.eXu.setText((CharSequence)localObject);
        this.eXu.setCompoundDrawablesWithIntrinsicBounds(R.g.status_enable, 0, 0, 0);
        break;
        this.fuT.setVisibility(8);
      }
      label295:
      this.eXu.setVisibility(8);
      continue;
      label307:
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        this.eXu.setTextColor(p.hg(this.mContext));
        this.eXu.setText((CharSequence)localObject);
        this.eXu.setCompoundDrawablesWithIntrinsicBounds(R.g.status_disable, 0, 0, 0);
      }
      else
      {
        this.eXu.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference
 * JD-Core Version:    0.7.0.1
 */