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
  private TextView HEA;
  private TextView HEB;
  private ImageView HEC;
  private boolean HEE;
  private boolean HEF;
  private int HEG;
  private boolean HEH;
  private int HEj;
  private int HEk;
  private int HEl;
  private ImageView HEm;
  private ViewGroup HEn;
  private TextView HEo;
  RelativeLayout.LayoutParams HEr;
  private int HEs;
  private int HEt;
  private int HEu;
  private int HEv;
  private int HEw;
  private int HEx;
  private View HEy;
  private View HEz;
  private int HFN;
  protected int HfX;
  private Bitmap Hjr;
  private Context context;
  private String desc;
  private Drawable drawable;
  private TextView gAI;
  private int height;
  protected ImageView uBH;
  private String vLt;
  private String vLu;
  private int xpM;
  private int xpN;
  private ImageView ylK;
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159990);
    this.HfX = -1;
    this.uBH = null;
    this.vLt = "";
    this.xpM = -1;
    this.xpN = 8;
    this.HEj = 8;
    this.HEs = 8;
    this.desc = "";
    this.vLu = "";
    this.HEt = -1;
    this.HEu = 8;
    this.HEv = -1;
    this.Hjr = null;
    this.HEw = 8;
    this.HEk = 8;
    this.HEl = 8;
    this.HEx = 8;
    this.HFN = 0;
    this.HEm = null;
    this.HEn = null;
    this.HEy = null;
    this.HEz = null;
    this.ylK = null;
    this.height = -1;
    this.HEE = false;
    this.HEF = false;
    this.HEG = -1;
    this.HEH = false;
    this.context = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(159990);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(159992);
    super.onBindView(paramView);
    this.HEC = ((ImageView)paramView.findViewById(2131300943));
    Object localObject;
    if (this.HEC != null)
    {
      if (this.drawable != null)
      {
        this.HEC.setImageDrawable(this.drawable);
        this.HEC.setVisibility(0);
      }
    }
    else
    {
      localObject = (LinearLayout)paramView.findViewById(2131302326);
      ((LinearLayout)localObject).setMinimumHeight(paramView.getResources().getDimensionPixelSize(2131165567));
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      this.HEB = ((TextView)paramView.findViewById(2131305745));
      if (this.HEB != null)
      {
        if (!this.HEF) {
          break label714;
        }
        this.HEB.setCompoundDrawablesWithIntrinsicBounds(2131234447, 0, 0, 0);
        this.HEB.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
        label154:
        this.HEB.setVisibility(this.xpN);
        this.HEB.setText(this.vLt);
        if (this.xpM != -1) {
          this.HEB.setBackgroundDrawable(this.context.getResources().getDrawable(this.xpM));
        }
      }
      this.HEA = ((TextView)paramView.findViewById(2131305747));
      if (this.HEA != null)
      {
        this.HEA.setVisibility(this.HEu);
        this.HEA.setText(this.vLu);
        if (this.HEt != -1) {
          this.HEA.setBackgroundDrawable(this.context.getResources().getDrawable(this.HEt));
        }
        if (this.HEv != -1) {
          this.HEA.setTextColor(this.HEv);
        }
        if (!this.HEE) {
          break label728;
        }
        this.HEA.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131234447, 0);
        this.HEA.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
      }
      label334:
      this.HEm = ((ImageView)paramView.findViewById(2131305740));
      this.HEm.setVisibility(this.HEj);
      if (this.HEG != -1) {
        this.HEm.setImageResource(this.HEG);
      }
      this.uBH = ((ImageView)paramView.findViewById(2131300959));
      this.HEn = ((ViewGroup)paramView.findViewById(2131304191));
      this.HEz = paramView.findViewById(2131304181);
      this.HEz.setVisibility(this.HEx);
      this.HEy = paramView.findViewById(2131304190);
      this.HEy.setVisibility(this.HEl);
      this.ylK = ((ImageView)paramView.findViewById(2131304172));
      this.ylK.setVisibility(this.HFN);
      if (this.Hjr == null) {
        break label742;
      }
      this.uBH.setImageBitmap(this.Hjr);
      label487:
      this.uBH.setVisibility(this.HEw);
      this.HEn.setVisibility(this.HEk);
      if (this.HEr != null) {
        this.uBH.setLayoutParams(this.HEr);
      }
      this.HEo = ((TextView)paramView.findViewById(16908310));
      this.gAI = ((TextView)paramView.findViewById(2131298996));
      if (this.gAI != null)
      {
        this.gAI.setVisibility(this.HEs);
        this.gAI.setText(this.desc);
        if (!this.HEH) {
          break label764;
        }
        this.gAI.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label608:
      if (this.HEo != null)
      {
        if (!this.HEH) {
          break label786;
        }
        this.HEo.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label641:
      if (this.HEH) {
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
        localObject = this.HEC;
        Drawable localDrawable = getIcon();
        this.drawable = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.HEC.setVisibility(0);
        break;
      }
      this.HEC.setVisibility(8);
      break;
      label714:
      this.HEB.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label154;
      label728:
      this.HEA.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label334;
      label742:
      if (this.HfX == -1) {
        break label487;
      }
      this.uBH.setImageResource(this.HfX);
      break label487;
      label764:
      this.gAI.setTextColor(this.context.getResources().getColor(2131100490));
      break label608;
      this.HEo.setTextColor(this.context.getResources().getColor(2131100711));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.weui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */