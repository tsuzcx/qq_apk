package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.u;
import junit.framework.Assert;

public class AppHeaderPreference
  extends Preference
{
  private a FMq;
  private boolean eeO = false;
  private TextView gCd;
  private ImageView gyr;
  private boolean kac = false;
  private TextView kib;
  private TextView kuu;
  
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
      this.FMq = parama;
      this.eeO = paramBoolean;
      AppMethodBeat.o(29134);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29133);
    this.gyr = ((ImageView)paramView.findViewById(2131299034));
    this.gCd = ((TextView)paramView.findViewById(2131299084));
    this.kib = ((TextView)paramView.findViewById(2131299068));
    this.kuu = ((TextView)paramView.findViewById(2131299054));
    this.kac = true;
    if ((!this.kac) || (this.FMq == null)) {
      Log.w("MicroMsg.HeaderPreference", "initView : bindView = " + this.kac);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(29133);
      return;
      Object localObject = this.FMq.ftr();
      if ((this.gyr != null) && (localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        this.gyr.setImageBitmap((Bitmap)localObject);
      }
      localObject = this.FMq.ftq();
      if ((this.kib != null) && (localObject != null) && (((String)localObject).length() > 0)) {
        this.kib.setText((CharSequence)localObject);
      }
      localObject = this.FMq.getHint();
      if (localObject != null)
      {
        this.kuu.setText((CharSequence)localObject);
        this.kuu.setVisibility(0);
      }
      for (;;)
      {
        boolean bool = this.eeO;
        if (this.gCd == null) {
          break;
        }
        localObject = this.FMq.wf(bool);
        if (!bool) {
          break label314;
        }
        if ((localObject == null) || (((String)localObject).length() <= 0)) {
          break label302;
        }
        this.gCd.setTextColor(u.kF(this.mContext));
        this.gCd.setText((CharSequence)localObject);
        this.gCd.setCompoundDrawablesWithIntrinsicBounds(2131235049, 0, 0, 0);
        break;
        this.kuu.setVisibility(8);
      }
      label302:
      this.gCd.setVisibility(8);
      continue;
      label314:
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        this.gCd.setTextColor(u.kG(this.mContext));
        this.gCd.setText((CharSequence)localObject);
        this.gCd.setCompoundDrawablesWithIntrinsicBounds(2131235048, 0, 0, 0);
      }
      else
      {
        this.gCd.setVisibility(8);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract String ftq();
    
    public abstract Bitmap ftr();
    
    public abstract String getHint();
    
    public abstract String wf(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference
 * JD-Core Version:    0.7.0.1
 */