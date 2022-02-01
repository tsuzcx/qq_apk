package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.t;
import junit.framework.Assert;

public class AppHeaderPreference
  extends Preference
{
  private a BBE;
  private boolean dMW = false;
  private ImageView fTj;
  private TextView fWX;
  private boolean jbZ = false;
  private TextView jjZ;
  private TextView jwg;
  
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
      this.BBE = parama;
      this.dMW = paramBoolean;
      AppMethodBeat.o(29134);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29133);
    this.fTj = ((ImageView)paramView.findViewById(2131298597));
    this.fWX = ((TextView)paramView.findViewById(2131298647));
    this.jjZ = ((TextView)paramView.findViewById(2131298631));
    this.jwg = ((TextView)paramView.findViewById(2131298617));
    this.jbZ = true;
    if ((!this.jbZ) || (this.BBE == null)) {
      ae.w("MicroMsg.HeaderPreference", "initView : bindView = " + this.jbZ);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(29133);
      return;
      Object localObject = this.BBE.eqS();
      if ((this.fTj != null) && (localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        this.fTj.setImageBitmap((Bitmap)localObject);
      }
      localObject = this.BBE.eqR();
      if ((this.jjZ != null) && (localObject != null) && (((String)localObject).length() > 0)) {
        this.jjZ.setText((CharSequence)localObject);
      }
      localObject = this.BBE.getHint();
      if (localObject != null)
      {
        this.jwg.setText((CharSequence)localObject);
        this.jwg.setVisibility(0);
      }
      for (;;)
      {
        boolean bool = this.dMW;
        if (this.fWX == null) {
          break;
        }
        localObject = this.BBE.sL(bool);
        if (!bool) {
          break label314;
        }
        if ((localObject == null) || (((String)localObject).length() <= 0)) {
          break label302;
        }
        this.fWX.setTextColor(t.kJ(this.mContext));
        this.fWX.setText((CharSequence)localObject);
        this.fWX.setCompoundDrawablesWithIntrinsicBounds(2131234178, 0, 0, 0);
        break;
        this.jwg.setVisibility(8);
      }
      label302:
      this.fWX.setVisibility(8);
      continue;
      label314:
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        this.fWX.setTextColor(t.kK(this.mContext));
        this.fWX.setText((CharSequence)localObject);
        this.fWX.setCompoundDrawablesWithIntrinsicBounds(2131234177, 0, 0, 0);
      }
      else
      {
        this.fWX.setVisibility(8);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract String eqR();
    
    public abstract Bitmap eqS();
    
    public abstract String getHint();
    
    public abstract String sL(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference
 * JD-Core Version:    0.7.0.1
 */