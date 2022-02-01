package com.tencent.weui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IconPreference
  extends Preference
{
  protected int FGP;
  private Bitmap FKj;
  RelativeLayout.LayoutParams GeC;
  private int GeD;
  private int GeE;
  private int GeF;
  private int GeG;
  private int GeH;
  private int GeI;
  private View GeJ;
  private View GeK;
  private TextView GeL;
  private TextView GeM;
  private ImageView GeN;
  private boolean GeP;
  private boolean GeQ;
  private int GeR;
  private boolean GeS;
  private int Geu;
  private int Gev;
  private int Gew;
  private ImageView Gex;
  private ViewGroup Gey;
  private TextView Gez;
  private int GfY;
  private Context context;
  private String desc;
  private Drawable drawable;
  private int height;
  private TextView lEA;
  protected ImageView tto;
  private String uCA;
  private String uCB;
  private ImageView wYW;
  private int wey;
  private int wez;
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159990);
    this.FGP = -1;
    this.tto = null;
    this.uCA = "";
    this.wey = -1;
    this.wez = 8;
    this.Geu = 8;
    this.GeD = 8;
    this.desc = "";
    this.uCB = "";
    this.GeE = -1;
    this.GeF = 8;
    this.GeG = -1;
    this.FKj = null;
    this.GeH = 8;
    this.Gev = 8;
    this.Gew = 8;
    this.GeI = 8;
    this.GfY = 0;
    this.Gex = null;
    this.Gey = null;
    this.GeJ = null;
    this.GeK = null;
    this.wYW = null;
    this.height = -1;
    this.GeP = false;
    this.GeQ = false;
    this.GeR = -1;
    this.GeS = false;
    this.context = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(159990);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(159992);
    super.onBindView(paramView);
    this.GeN = ((ImageView)paramView.findViewById(2131300943));
    Object localObject;
    if (this.GeN != null)
    {
      if (this.drawable != null)
      {
        this.GeN.setImageDrawable(this.drawable);
        this.GeN.setVisibility(0);
      }
    }
    else
    {
      localObject = (LinearLayout)paramView.findViewById(2131302326);
      ((LinearLayout)localObject).setMinimumHeight(paramView.getResources().getDimensionPixelSize(2131165567));
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      this.GeM = ((TextView)paramView.findViewById(2131305745));
      if (this.GeM != null)
      {
        if (!this.GeQ) {
          break label714;
        }
        this.GeM.setCompoundDrawablesWithIntrinsicBounds(2131234447, 0, 0, 0);
        this.GeM.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
        label154:
        this.GeM.setVisibility(this.wez);
        this.GeM.setText(this.uCA);
        if (this.wey != -1) {
          this.GeM.setBackgroundDrawable(this.context.getResources().getDrawable(this.wey));
        }
      }
      this.GeL = ((TextView)paramView.findViewById(2131305747));
      if (this.GeL != null)
      {
        this.GeL.setVisibility(this.GeF);
        this.GeL.setText(this.uCB);
        if (this.GeE != -1) {
          this.GeL.setBackgroundDrawable(this.context.getResources().getDrawable(this.GeE));
        }
        if (this.GeG != -1) {
          this.GeL.setTextColor(this.GeG);
        }
        if (!this.GeP) {
          break label728;
        }
        this.GeL.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131234447, 0);
        this.GeL.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
      }
      label334:
      this.Gex = ((ImageView)paramView.findViewById(2131305740));
      this.Gex.setVisibility(this.Geu);
      if (this.GeR != -1) {
        this.Gex.setImageResource(this.GeR);
      }
      this.tto = ((ImageView)paramView.findViewById(2131300959));
      this.Gey = ((ViewGroup)paramView.findViewById(2131304191));
      this.GeK = paramView.findViewById(2131304181);
      this.GeK.setVisibility(this.GeI);
      this.GeJ = paramView.findViewById(2131304190);
      this.GeJ.setVisibility(this.Gew);
      this.wYW = ((ImageView)paramView.findViewById(2131304172));
      this.wYW.setVisibility(this.GfY);
      if (this.FKj == null) {
        break label742;
      }
      this.tto.setImageBitmap(this.FKj);
      label487:
      this.tto.setVisibility(this.GeH);
      this.Gey.setVisibility(this.Gev);
      if (this.GeC != null) {
        this.tto.setLayoutParams(this.GeC);
      }
      this.Gez = ((TextView)paramView.findViewById(16908310));
      this.lEA = ((TextView)paramView.findViewById(2131298996));
      if (this.lEA != null)
      {
        this.lEA.setVisibility(this.GeD);
        this.lEA.setText(this.desc);
        if (!this.GeS) {
          break label764;
        }
        this.lEA.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label608:
      if (this.Gez != null)
      {
        if (!this.GeS) {
          break label786;
        }
        this.Gez.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label641:
      if (this.GeS) {
        break label809;
      }
    }
    label786:
    label809:
    for (boolean bool = true;; bool = false)
    {
      paramView.setEnabled(bool);
      AppMethodBeat.o(159992);
      return;
      if (getIcon() != null)
      {
        localObject = this.GeN;
        Drawable localDrawable = getIcon();
        this.drawable = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.GeN.setVisibility(0);
        break;
      }
      this.GeN.setVisibility(8);
      break;
      label714:
      this.GeM.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label154;
      label728:
      this.GeL.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label334;
      label742:
      if (this.FGP == -1) {
        break label487;
      }
      this.tto.setImageResource(this.FGP);
      break label487;
      label764:
      this.lEA.setTextColor(this.context.getResources().getColor(2131100490));
      break label608;
      this.Gez.setTextColor(this.context.getResources().getColor(2131100711));
      break label641;
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(159991);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(getContext(), 2131495105, localViewGroup);
    AppMethodBeat.o(159991);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.weui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */