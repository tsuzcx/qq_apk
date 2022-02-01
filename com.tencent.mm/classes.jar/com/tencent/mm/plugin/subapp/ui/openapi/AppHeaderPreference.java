package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.u;
import junit.framework.Assert;

public class AppHeaderPreference
  extends Preference
{
  private a SHP;
  private boolean hAJ = false;
  private ImageView lKK;
  private TextView lPf;
  private boolean pOc = false;
  private TextView pWj;
  private TextView qjr;
  
  public AppHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AppHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(29134);
    if (parama != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.SHP = parama;
      this.hAJ = paramBoolean;
      AppMethodBeat.o(29134);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29133);
    this.lKK = ((ImageView)paramView.findViewById(R.h.contact_info_avatar_iv));
    this.lPf = ((TextView)paramView.findViewById(R.h.contact_info_status_tv));
    this.pWj = ((TextView)paramView.findViewById(R.h.contact_info_nickname_tv));
    this.qjr = ((TextView)paramView.findViewById(R.h.contact_info_helper_hing_tv));
    this.pOc = true;
    if ((!this.pOc) || (this.SHP == null)) {
      Log.w("MicroMsg.HeaderPreference", "initView : bindView = " + this.pOc);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(29133);
      return;
      Object localObject = this.SHP.fwJ();
      if ((this.lKK != null) && (localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        this.lKK.setImageBitmap((Bitmap)localObject);
      }
      localObject = this.SHP.hBs();
      if ((this.pWj != null) && (localObject != null) && (((String)localObject).length() > 0)) {
        this.pWj.setText((CharSequence)localObject);
      }
      localObject = this.SHP.getHint();
      if (localObject != null)
      {
        this.qjr.setText((CharSequence)localObject);
        this.qjr.setVisibility(0);
      }
      for (;;)
      {
        boolean bool = this.hAJ;
        if (this.lPf == null) {
          break;
        }
        localObject = this.SHP.Fc(bool);
        if (!bool) {
          break label319;
        }
        if ((localObject == null) || (((String)localObject).length() <= 0)) {
          break label307;
        }
        this.lPf.setTextColor(u.nF(this.mContext));
        this.lPf.setText((CharSequence)localObject);
        this.lPf.setCompoundDrawablesWithIntrinsicBounds(R.g.status_enable, 0, 0, 0);
        break;
        this.qjr.setVisibility(8);
      }
      label307:
      this.lPf.setVisibility(8);
      continue;
      label319:
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        this.lPf.setTextColor(u.nG(this.mContext));
        this.lPf.setText((CharSequence)localObject);
        this.lPf.setCompoundDrawablesWithIntrinsicBounds(R.g.status_disable, 0, 0, 0);
      }
      else
      {
        this.lPf.setVisibility(8);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract String Fc(boolean paramBoolean);
    
    public abstract Bitmap fwJ();
    
    public abstract String getHint();
    
    public abstract String hBs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference
 * JD-Core Version:    0.7.0.1
 */