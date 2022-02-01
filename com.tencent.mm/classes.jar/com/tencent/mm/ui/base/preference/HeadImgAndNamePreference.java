package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.f.a.a;

public final class HeadImgAndNamePreference
  extends Preference
{
  private View JrR;
  private LinearLayout JrS;
  private String JrT;
  private boolean JrU;
  private boolean JrV;
  private a JrW;
  private ImageView fUN;
  private int height;
  private TextView iCV;
  private ImageView oHo;
  private View.OnClickListener waa;
  
  public HeadImgAndNamePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgAndNamePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164162);
    this.height = -1;
    this.JrV = false;
    this.JrW = null;
    setLayoutResource(2131494804);
    AppMethodBeat.o(164162);
  }
  
  public final void a(a parama)
  {
    this.JrW = parama;
  }
  
  public final void aVC(String paramString)
  {
    AppMethodBeat.i(164164);
    this.JrT = null;
    if (this.oHo != null) {
      if (this.JrW != null) {
        this.JrW.b(paramString, this.oHo);
      }
    }
    while (paramString == null)
    {
      this.JrV = false;
      AppMethodBeat.o(164164);
      return;
      if (this.JrU)
      {
        a.d(this.oHo, paramString);
      }
      else
      {
        a.c(this.oHo, paramString);
        continue;
        this.JrT = paramString;
      }
    }
    this.JrV = true;
    AppMethodBeat.o(164164);
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
    AppMethodBeat.i(164165);
    super.onBindView(paramView);
    if (this.oHo == null) {
      this.oHo = ((ImageView)paramView.findViewById(2131300940));
    }
    if (this.iCV == null) {
      this.iCV = ((TextView)paramView.findViewById(2131302878));
    }
    if (this.JrR == null) {
      this.JrR = paramView.findViewById(2131302161);
    }
    if (this.waa != null) {
      this.JrR.setOnClickListener(this.waa);
    }
    if (this.JrT != null)
    {
      if (this.JrW != null)
      {
        this.JrW.b(this.JrT, this.oHo);
        this.JrT = null;
      }
    }
    else
    {
      if (this.JrV) {
        break label212;
      }
      this.JrR.setVisibility(8);
      this.iCV.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(2131302326);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      AppMethodBeat.o(164165);
      return;
      if (this.JrU)
      {
        a.d(this.oHo, this.JrT);
        break;
      }
      a.c(this.oHo, this.JrT);
      break;
      label212:
      this.iCV.setVisibility(8);
      this.JrR.setVisibility(0);
      if (this.JrU) {
        this.JrR.setBackground(this.mContext.getDrawable(2131233939));
      } else {
        this.JrR.setBackground(this.mContext.getDrawable(2131233937));
      }
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(164163);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494823, localViewGroup);
    this.oHo = ((ImageView)paramViewGroup.findViewById(2131300940));
    this.JrR = paramViewGroup.findViewById(2131302162);
    this.JrS = ((LinearLayout)paramViewGroup.findViewById(2131299005));
    this.fUN = ((ImageView)paramViewGroup.findViewById(2131300874));
    this.iCV = ((TextView)paramViewGroup.findViewById(2131298996));
    AppMethodBeat.o(164163);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void b(String paramString, ImageView paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.HeadImgAndNamePreference
 * JD-Core Version:    0.7.0.1
 */