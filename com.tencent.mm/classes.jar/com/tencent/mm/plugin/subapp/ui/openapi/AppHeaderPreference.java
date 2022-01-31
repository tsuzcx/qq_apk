package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.s;
import junit.framework.Assert;

public class AppHeaderPreference
  extends Preference
{
  private boolean cKK = false;
  private ImageView ehv;
  private TextView gMv;
  private TextView gpr;
  private boolean gsM = false;
  private TextView pAN;
  private AppHeaderPreference.a sYM;
  
  public AppHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AppHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(AppHeaderPreference.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(25440);
    if (parama != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.sYM = parama;
      this.cKK = paramBoolean;
      AppMethodBeat.o(25440);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(25439);
    this.ehv = ((ImageView)paramView.findViewById(2131821497));
    this.gpr = ((TextView)paramView.findViewById(2131823105));
    this.pAN = ((TextView)paramView.findViewById(2131821498));
    this.gMv = ((TextView)paramView.findViewById(2131821499));
    this.gsM = true;
    if ((!this.gsM) || (this.sYM == null)) {
      ab.w("MicroMsg.HeaderPreference", "initView : bindView = " + this.gsM);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(25439);
      return;
      Object localObject = this.sYM.cGZ();
      if ((this.ehv != null) && (localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        this.ehv.setImageBitmap((Bitmap)localObject);
      }
      localObject = this.sYM.cGY();
      if ((this.pAN != null) && (localObject != null) && (((String)localObject).length() > 0)) {
        this.pAN.setText((CharSequence)localObject);
      }
      localObject = this.sYM.getHint();
      if (localObject != null)
      {
        this.gMv.setText((CharSequence)localObject);
        this.gMv.setVisibility(0);
      }
      for (;;)
      {
        boolean bool = this.cKK;
        if (this.gpr == null) {
          break;
        }
        localObject = this.sYM.mw(bool);
        if (!bool) {
          break label314;
        }
        if ((localObject == null) || (((String)localObject).length() <= 0)) {
          break label302;
        }
        this.gpr.setTextColor(s.iD(this.mContext));
        this.gpr.setText((CharSequence)localObject);
        this.gpr.setCompoundDrawablesWithIntrinsicBounds(2130840454, 0, 0, 0);
        break;
        this.gMv.setVisibility(8);
      }
      label302:
      this.gpr.setVisibility(8);
      continue;
      label314:
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        this.gpr.setTextColor(s.iE(this.mContext));
        this.gpr.setText((CharSequence)localObject);
        this.gpr.setCompoundDrawablesWithIntrinsicBounds(2130840453, 0, 0, 0);
      }
      else
      {
        this.gpr.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference
 * JD-Core Version:    0.7.0.1
 */