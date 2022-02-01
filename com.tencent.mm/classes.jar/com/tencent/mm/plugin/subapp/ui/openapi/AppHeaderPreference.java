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
  private a Bkf;
  private boolean dLH = false;
  private ImageView fRd;
  private TextView fUR;
  private boolean iZg = false;
  private TextView jhg;
  private TextView jtn;
  
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
      this.Bkf = parama;
      this.dLH = paramBoolean;
      AppMethodBeat.o(29134);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29133);
    this.fRd = ((ImageView)paramView.findViewById(2131298597));
    this.fUR = ((TextView)paramView.findViewById(2131298647));
    this.jhg = ((TextView)paramView.findViewById(2131298631));
    this.jtn = ((TextView)paramView.findViewById(2131298617));
    this.iZg = true;
    if ((!this.iZg) || (this.Bkf == null)) {
      ad.w("MicroMsg.HeaderPreference", "initView : bindView = " + this.iZg);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(29133);
      return;
      Object localObject = this.Bkf.enk();
      if ((this.fRd != null) && (localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        this.fRd.setImageBitmap((Bitmap)localObject);
      }
      localObject = this.Bkf.enj();
      if ((this.jhg != null) && (localObject != null) && (((String)localObject).length() > 0)) {
        this.jhg.setText((CharSequence)localObject);
      }
      localObject = this.Bkf.getHint();
      if (localObject != null)
      {
        this.jtn.setText((CharSequence)localObject);
        this.jtn.setVisibility(0);
      }
      for (;;)
      {
        boolean bool = this.dLH;
        if (this.fUR == null) {
          break;
        }
        localObject = this.Bkf.sE(bool);
        if (!bool) {
          break label314;
        }
        if ((localObject == null) || (((String)localObject).length() <= 0)) {
          break label302;
        }
        this.fUR.setTextColor(t.kC(this.mContext));
        this.fUR.setText((CharSequence)localObject);
        this.fUR.setCompoundDrawablesWithIntrinsicBounds(2131234178, 0, 0, 0);
        break;
        this.jtn.setVisibility(8);
      }
      label302:
      this.fUR.setVisibility(8);
      continue;
      label314:
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        this.fUR.setTextColor(t.kD(this.mContext));
        this.fUR.setText((CharSequence)localObject);
        this.fUR.setCompoundDrawablesWithIntrinsicBounds(2131234177, 0, 0, 0);
      }
      else
      {
        this.fUR.setVisibility(8);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract String enj();
    
    public abstract Bitmap enk();
    
    public abstract String getHint();
    
    public abstract String sE(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference
 * JD-Core Version:    0.7.0.1
 */