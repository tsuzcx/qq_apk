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
  private Context context;
  private String desc;
  private Drawable drawable;
  private int height;
  private TextView hsI;
  protected ImageView oyN;
  private String pAS;
  private String pAT;
  private int qGe;
  private int qGf;
  private ImageView ruQ;
  protected int yUb;
  private Bitmap yXe;
  private int zqL;
  private int zqM;
  private int zqN;
  private ImageView zqO;
  private ViewGroup zqP;
  private TextView zqQ;
  RelativeLayout.LayoutParams zqS;
  private int zqT;
  private int zqU;
  private int zqV;
  private int zqW;
  private int zqX;
  private int zqY;
  private View zqZ;
  private View zra;
  private TextView zrb;
  private TextView zrc;
  private ImageView zrd;
  private boolean zre;
  private boolean zrf;
  private int zrg;
  private boolean zrh;
  private int zsn;
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113253);
    this.yUb = -1;
    this.oyN = null;
    this.pAS = "";
    this.qGe = -1;
    this.qGf = 8;
    this.zqL = 8;
    this.zqT = 8;
    this.desc = "";
    this.pAT = "";
    this.zqU = -1;
    this.zqV = 8;
    this.zqW = -1;
    this.yXe = null;
    this.zqX = 8;
    this.zqM = 8;
    this.zqN = 8;
    this.zqY = 8;
    this.zsn = 0;
    this.zqO = null;
    this.zqP = null;
    this.zqZ = null;
    this.zra = null;
    this.ruQ = null;
    this.height = -1;
    this.zre = false;
    this.zrf = false;
    this.zrg = -1;
    this.zrh = false;
    this.context = paramContext;
    setLayoutResource(2130970179);
    AppMethodBeat.o(113253);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(113255);
    super.onBindView(paramView);
    this.zrd = ((ImageView)paramView.findViewById(2131822243));
    Object localObject;
    if (this.zrd != null)
    {
      if (this.drawable != null)
      {
        this.zrd.setImageDrawable(this.drawable);
        this.zrd.setVisibility(0);
      }
    }
    else
    {
      localObject = (LinearLayout)paramView.findViewById(2131822408);
      ((LinearLayout)localObject).setMinimumHeight(paramView.getResources().getDimensionPixelSize(2131427853));
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      this.zrc = ((TextView)paramView.findViewById(2131822409));
      if (this.zrc != null)
      {
        if (!this.zrf) {
          break label714;
        }
        this.zrc.setCompoundDrawablesWithIntrinsicBounds(2130840641, 0, 0, 0);
        this.zrc.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131427854));
        label154:
        this.zrc.setVisibility(this.qGf);
        this.zrc.setText(this.pAS);
        if (this.qGe != -1) {
          this.zrc.setBackgroundDrawable(this.context.getResources().getDrawable(this.qGe));
        }
      }
      this.zrb = ((TextView)paramView.findViewById(2131822411));
      if (this.zrb != null)
      {
        this.zrb.setVisibility(this.zqV);
        this.zrb.setText(this.pAT);
        if (this.zqU != -1) {
          this.zrb.setBackgroundDrawable(this.context.getResources().getDrawable(this.zqU));
        }
        if (this.zqW != -1) {
          this.zrb.setTextColor(this.zqW);
        }
        if (!this.zre) {
          break label728;
        }
        this.zrb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130840641, 0);
        this.zrb.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131427854));
      }
      label334:
      this.zqO = ((ImageView)paramView.findViewById(2131822410));
      this.zqO.setVisibility(this.zqL);
      if (this.zrg != -1) {
        this.zqO.setImageResource(this.zrg);
      }
      this.oyN = ((ImageView)paramView.findViewById(2131822413));
      this.zqP = ((ViewGroup)paramView.findViewById(2131822412));
      this.zra = paramView.findViewById(2131822415);
      this.zra.setVisibility(this.zqY);
      this.zqZ = paramView.findViewById(2131822414);
      this.zqZ.setVisibility(this.zqN);
      this.ruQ = ((ImageView)paramView.findViewById(2131821555));
      this.ruQ.setVisibility(this.zsn);
      if (this.yXe == null) {
        break label742;
      }
      this.oyN.setImageBitmap(this.yXe);
      label487:
      this.oyN.setVisibility(this.zqX);
      this.zqP.setVisibility(this.zqM);
      if (this.zqS != null) {
        this.oyN.setLayoutParams(this.zqS);
      }
      this.zqQ = ((TextView)paramView.findViewById(16908310));
      this.hsI = ((TextView)paramView.findViewById(2131821115));
      if (this.hsI != null)
      {
        this.hsI.setVisibility(this.zqT);
        this.hsI.setText(this.desc);
        if (!this.zrh) {
          break label764;
        }
        this.hsI.setTextColor(this.context.getResources().getColor(2131689963));
      }
      label608:
      if (this.zqQ != null)
      {
        if (!this.zrh) {
          break label786;
        }
        this.zqQ.setTextColor(this.context.getResources().getColor(2131689963));
      }
      label641:
      if (this.zrh) {
        break label809;
      }
    }
    label786:
    label809:
    for (boolean bool = true;; bool = false)
    {
      paramView.setEnabled(bool);
      AppMethodBeat.o(113255);
      return;
      if (getIcon() != null)
      {
        localObject = this.zrd;
        Drawable localDrawable = getIcon();
        this.drawable = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.zrd.setVisibility(0);
        break;
      }
      this.zrd.setVisibility(8);
      break;
      label714:
      this.zrc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label154;
      label728:
      this.zrb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label334;
      label742:
      if (this.yUb == -1) {
        break label487;
      }
      this.oyN.setImageResource(this.yUb);
      break label487;
      label764:
      this.hsI.setTextColor(this.context.getResources().getColor(2131690168));
      break label608;
      this.zqQ.setTextColor(this.context.getResources().getColor(2131690322));
      break label641;
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113254);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    View.inflate(getContext(), 2130970432, localViewGroup);
    AppMethodBeat.o(113254);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.weui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */