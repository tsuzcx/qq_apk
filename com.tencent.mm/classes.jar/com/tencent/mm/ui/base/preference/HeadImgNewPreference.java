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
  private View EXu;
  private String JrT;
  private boolean JrU;
  private boolean JrV;
  private TextView JrX;
  private a JrY;
  private int height;
  private ImageView ka;
  public View.OnClickListener waa;
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164166);
    this.height = -1;
    this.JrV = false;
    this.JrY = null;
    setLayoutResource(2131494804);
    AppMethodBeat.o(164166);
  }
  
  public final void a(a parama)
  {
    this.JrY = parama;
  }
  
  public final void aVC(String paramString)
  {
    AppMethodBeat.i(164168);
    this.JrT = null;
    if (this.ka != null) {
      if (this.JrY != null) {
        this.JrY.b(paramString, this.ka);
      }
    }
    while (paramString == null)
    {
      this.JrV = false;
      AppMethodBeat.o(164168);
      return;
      if (this.JrU)
      {
        a.d(this.ka, paramString);
      }
      else
      {
        a.c(this.ka, paramString);
        continue;
        this.JrT = paramString;
      }
    }
    this.JrV = true;
    AppMethodBeat.o(164168);
  }
  
  public final void d(View.OnClickListener paramOnClickListener)
  {
    this.waa = paramOnClickListener;
  }
  
  public final void fzz()
  {
    this.JrU = true;
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(164169);
    super.onBindView(paramView);
    if (this.ka == null) {
      this.ka = ((ImageView)paramView.findViewById(2131300940));
    }
    if (this.JrX == null) {
      this.JrX = ((TextView)paramView.findViewById(2131302878));
    }
    if (this.EXu == null) {
      this.EXu = paramView.findViewById(2131302161);
    }
    if (this.waa != null) {
      this.EXu.setOnClickListener(this.waa);
    }
    if (this.JrT != null)
    {
      if (this.JrY != null)
      {
        this.JrY.b(this.JrT, this.ka);
        this.JrT = null;
      }
    }
    else
    {
      if (this.JrV) {
        break label212;
      }
      this.EXu.setVisibility(8);
      this.JrX.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(2131302326);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      AppMethodBeat.o(164169);
      return;
      if (this.JrU)
      {
        a.d(this.ka, this.JrT);
        break;
      }
      a.c(this.ka, this.JrT);
      break;
      label212:
      this.JrX.setVisibility(8);
      this.EXu.setVisibility(0);
      if (this.JrU) {
        this.EXu.setBackground(this.mContext.getDrawable(2131233939));
      } else {
        this.EXu.setBackground(this.mContext.getDrawable(2131233937));
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
    this.ka = ((ImageView)paramViewGroup.findViewById(2131300940));
    this.JrX = ((TextView)paramViewGroup.findViewById(2131302878));
    this.EXu = paramViewGroup.findViewById(2131302161);
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