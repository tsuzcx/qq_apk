package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.t;
import junit.framework.Assert;

public class AppHeaderPreference
  extends Preference
{
  private boolean dBH = false;
  private ImageView fuj;
  private TextView fxX;
  private TextView iAd;
  private boolean ifO = false;
  private TextView inR;
  private a yFm;
  
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
      this.yFm = parama;
      this.dBH = paramBoolean;
      AppMethodBeat.o(29134);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29133);
    this.fuj = ((ImageView)paramView.findViewById(2131298597));
    this.fxX = ((TextView)paramView.findViewById(2131298647));
    this.inR = ((TextView)paramView.findViewById(2131298631));
    this.iAd = ((TextView)paramView.findViewById(2131298617));
    this.ifO = true;
    if ((!this.ifO) || (this.yFm == null)) {
      ad.w("MicroMsg.HeaderPreference", "initView : bindView = " + this.ifO);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(29133);
      return;
      Object localObject = this.yFm.dMt();
      if ((this.fuj != null) && (localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        this.fuj.setImageBitmap((Bitmap)localObject);
      }
      localObject = this.yFm.dMs();
      if ((this.inR != null) && (localObject != null) && (((String)localObject).length() > 0)) {
        this.inR.setText((CharSequence)localObject);
      }
      localObject = this.yFm.getHint();
      if (localObject != null)
      {
        this.iAd.setText((CharSequence)localObject);
        this.iAd.setVisibility(0);
      }
      for (;;)
      {
        boolean bool = this.dBH;
        if (this.fxX == null) {
          break;
        }
        localObject = this.yFm.ra(bool);
        if (!bool) {
          break label314;
        }
        if ((localObject == null) || (((String)localObject).length() <= 0)) {
          break label302;
        }
        this.fxX.setTextColor(t.kf(this.mContext));
        this.fxX.setText((CharSequence)localObject);
        this.fxX.setCompoundDrawablesWithIntrinsicBounds(2131234178, 0, 0, 0);
        break;
        this.iAd.setVisibility(8);
      }
      label302:
      this.fxX.setVisibility(8);
      continue;
      label314:
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        this.fxX.setTextColor(t.kg(this.mContext));
        this.fxX.setText((CharSequence)localObject);
        this.fxX.setCompoundDrawablesWithIntrinsicBounds(2131234177, 0, 0, 0);
      }
      else
      {
        this.fxX.setVisibility(8);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract String dMs();
    
    public abstract Bitmap dMt();
    
    public abstract String getHint();
    
    public abstract String ra(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference
 * JD-Core Version:    0.7.0.1
 */