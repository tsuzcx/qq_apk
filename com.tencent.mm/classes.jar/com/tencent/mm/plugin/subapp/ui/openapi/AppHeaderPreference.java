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
import com.tencent.mm.ui.tools.v;
import junit.framework.Assert;

public class AppHeaderPreference
  extends Preference
{
  private a Mgs;
  private boolean fZd = false;
  private ImageView jiu;
  private TextView jmj;
  private boolean mRv = false;
  private TextView mZA;
  private TextView nmi;
  
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
      this.Mgs = parama;
      this.fZd = paramBoolean;
      AppMethodBeat.o(29134);
      return;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29133);
    this.jiu = ((ImageView)paramView.findViewById(R.h.contact_info_avatar_iv));
    this.jmj = ((TextView)paramView.findViewById(R.h.contact_info_status_tv));
    this.mZA = ((TextView)paramView.findViewById(R.h.contact_info_nickname_tv));
    this.nmi = ((TextView)paramView.findViewById(R.h.contact_info_helper_hing_tv));
    this.mRv = true;
    if ((!this.mRv) || (this.Mgs == null)) {
      Log.w("MicroMsg.HeaderPreference", "initView : bindView = " + this.mRv);
    }
    for (;;)
    {
      super.onBindView(paramView);
      AppMethodBeat.o(29133);
      return;
      Object localObject = this.Mgs.ghR();
      if ((this.jiu != null) && (localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        this.jiu.setImageBitmap((Bitmap)localObject);
      }
      localObject = this.Mgs.ghQ();
      if ((this.mZA != null) && (localObject != null) && (((String)localObject).length() > 0)) {
        this.mZA.setText((CharSequence)localObject);
      }
      localObject = this.Mgs.getHint();
      if (localObject != null)
      {
        this.nmi.setText((CharSequence)localObject);
        this.nmi.setVisibility(0);
      }
      for (;;)
      {
        boolean bool = this.fZd;
        if (this.jmj == null) {
          break;
        }
        localObject = this.Mgs.zL(bool);
        if (!bool) {
          break label319;
        }
        if ((localObject == null) || (((String)localObject).length() <= 0)) {
          break label307;
        }
        this.jmj.setTextColor(v.lC(this.mContext));
        this.jmj.setText((CharSequence)localObject);
        this.jmj.setCompoundDrawablesWithIntrinsicBounds(R.g.status_enable, 0, 0, 0);
        break;
        this.nmi.setVisibility(8);
      }
      label307:
      this.jmj.setVisibility(8);
      continue;
      label319:
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        this.jmj.setTextColor(v.lD(this.mContext));
        this.jmj.setText((CharSequence)localObject);
        this.jmj.setCompoundDrawablesWithIntrinsicBounds(R.g.status_disable, 0, 0, 0);
      }
      else
      {
        this.jmj.setVisibility(8);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract String getHint();
    
    public abstract String ghQ();
    
    public abstract Bitmap ghR();
    
    public abstract String zL(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference
 * JD-Core Version:    0.7.0.1
 */