package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.f.a.a;

public final class HeadImgNewPreference
  extends Preference
{
  private View Caa;
  private String Geo;
  private boolean Gep;
  private boolean Geq;
  private TextView Ges;
  private a Get;
  private int height;
  private ImageView hg;
  public View.OnClickListener tOp;
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164166);
    this.height = -1;
    this.Geq = false;
    this.Get = null;
    setLayoutResource(2131494804);
    AppMethodBeat.o(164166);
  }
  
  public final void a(a parama)
  {
    this.Get = parama;
  }
  
  public final void aKj(String paramString)
  {
    AppMethodBeat.i(164168);
    this.Geo = null;
    if (this.hg != null) {
      if (this.Get != null) {
        this.Get.b(paramString, this.hg);
      }
    }
    while (paramString == null)
    {
      this.Geq = false;
      AppMethodBeat.o(164168);
      return;
      if (this.Gep)
      {
        a.d(this.hg, paramString);
      }
      else
      {
        a.c(this.hg, paramString);
        continue;
        this.Geo = paramString;
      }
    }
    this.Geq = true;
    AppMethodBeat.o(164168);
  }
  
  public final void eTy()
  {
    this.Gep = true;
  }
  
  public final void f(View.OnClickListener paramOnClickListener)
  {
    this.tOp = paramOnClickListener;
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(164169);
    super.onBindView(paramView);
    if (this.hg == null) {
      this.hg = ((ImageView)paramView.findViewById(2131300940));
    }
    if (this.Ges == null) {
      this.Ges = ((TextView)paramView.findViewById(2131302878));
    }
    if (this.Caa == null) {
      this.Caa = paramView.findViewById(2131302161);
    }
    if (this.tOp != null) {
      this.Caa.setOnClickListener(this.tOp);
    }
    if (this.Geo != null)
    {
      if (this.Get != null)
      {
        this.Get.b(this.Geo, this.hg);
        this.Geo = null;
      }
    }
    else
    {
      if (this.Geq) {
        break label212;
      }
      this.Caa.setVisibility(8);
      this.Ges.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(2131302326);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      AppMethodBeat.o(164169);
      return;
      if (this.Gep)
      {
        a.d(this.hg, this.Geo);
        break;
      }
      a.c(this.hg, this.Geo);
      break;
      label212:
      this.Ges.setVisibility(8);
      this.Caa.setVisibility(0);
      if (this.Gep) {
        this.Caa.setBackground(this.mContext.getDrawable(2131233939));
      } else {
        this.Caa.setBackground(this.mContext.getDrawable(2131233937));
      }
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(164167);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494822, localViewGroup);
    this.hg = ((ImageView)paramViewGroup.findViewById(2131300940));
    this.Ges = ((TextView)paramViewGroup.findViewById(2131302878));
    this.Caa = paramViewGroup.findViewById(2131302161);
    AppMethodBeat.o(164167);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString, ImageView paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.HeadImgNewPreference
 * JD-Core Version:    0.7.0.1
 */