package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.t;
import junit.framework.Assert;

public class AppHeaderPreference
  extends Preference
{
  private boolean dzv = false;
  private TextView fBE;
  private ImageView fxQ;
  private boolean iFX = false;
  private TextView iNX;
  private TextView jae;
  private a zSA;
  
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
      this.zSA = parama;
      this.dzv = paramBoolean;
      AppMethodBeat.o(29134);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29133);
    this.fxQ = ((ImageView)paramView.findViewById(2131298597));
    this.fBE = ((TextView)paramView.findViewById(2131298647));
    this.iNX = ((TextView)paramView.findViewById(2131298631));
    this.jae = ((TextView)paramView.findViewById(2131298617));
    this.iFX = true;
    if ((!this.iFX) || (this.zSA == null)) {
      ac.w("MicroMsg.HeaderPreference", "initView : bindView = " + this.iFX);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(29133);
      return;
      Object localObject = this.zSA.eaT();
      if ((this.fxQ != null) && (localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        this.fxQ.setImageBitmap((Bitmap)localObject);
      }
      localObject = this.zSA.eaS();
      if ((this.iNX != null) && (localObject != null) && (((String)localObject).length() > 0)) {
        this.iNX.setText((CharSequence)localObject);
      }
      localObject = this.zSA.getHint();
      if (localObject != null)
      {
        this.jae.setText((CharSequence)localObject);
        this.jae.setVisibility(0);
      }
      for (;;)
      {
        boolean bool = this.dzv;
        if (this.fBE == null) {
          break;
        }
        localObject = this.zSA.rY(bool);
        if (!bool) {
          break label314;
        }
        if ((localObject == null) || (((String)localObject).length() <= 0)) {
          break label302;
        }
        this.fBE.setTextColor(t.kq(this.mContext));
        this.fBE.setText((CharSequence)localObject);
        this.fBE.setCompoundDrawablesWithIntrinsicBounds(2131234178, 0, 0, 0);
        break;
        this.jae.setVisibility(8);
      }
      label302:
      this.fBE.setVisibility(8);
      continue;
      label314:
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        this.fBE.setTextColor(t.kr(this.mContext));
        this.fBE.setText((CharSequence)localObject);
        this.fBE.setCompoundDrawablesWithIntrinsicBounds(2131234177, 0, 0, 0);
      }
      else
      {
        this.fBE.setVisibility(8);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract String eaS();
    
    public abstract Bitmap eaT();
    
    public abstract String getHint();
    
    public abstract String rY(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference
 * JD-Core Version:    0.7.0.1
 */