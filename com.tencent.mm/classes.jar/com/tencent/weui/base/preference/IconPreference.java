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
  private String Bgn;
  private String Bgo;
  private int CZk;
  private int CZl;
  private ImageView EbJ;
  private Bitmap OBX;
  private int OXO;
  private int OXP;
  private int OXQ;
  private ImageView OXR;
  private ViewGroup OXS;
  private TextView OXT;
  RelativeLayout.LayoutParams OXW;
  private int OXX;
  private int OXY;
  private int OXZ;
  private int OYa;
  private int OYb;
  private int OYc;
  private View OYd;
  private View OYe;
  private TextView OYf;
  private TextView OYg;
  private ImageView OYh;
  private boolean OYk;
  private boolean OYl;
  private int OYm;
  private boolean OYn;
  private int OZz;
  protected int OxP;
  private Context context;
  private String desc;
  private Drawable drawable;
  private TextView hPW;
  private int height;
  protected ImageView zkw;
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159990);
    this.OxP = -1;
    this.zkw = null;
    this.Bgn = "";
    this.CZk = -1;
    this.CZl = 8;
    this.OXO = 8;
    this.OXX = 8;
    this.desc = "";
    this.Bgo = "";
    this.OXY = -1;
    this.OXZ = 8;
    this.OYa = -1;
    this.OBX = null;
    this.OYb = 8;
    this.OXP = 8;
    this.OXQ = 8;
    this.OYc = 8;
    this.OZz = 0;
    this.OXR = null;
    this.OXS = null;
    this.OYd = null;
    this.OYe = null;
    this.EbJ = null;
    this.height = -1;
    this.OYk = false;
    this.OYl = false;
    this.OYm = -1;
    this.OYn = false;
    this.context = paramContext;
    setLayoutResource(2131495538);
    AppMethodBeat.o(159990);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(159992);
    super.onBindView(paramView);
    this.OYh = ((ImageView)paramView.findViewById(2131302573));
    Object localObject;
    if (this.OYh != null)
    {
      if (this.drawable != null)
      {
        this.OYh.setImageDrawable(this.drawable);
        this.OYh.setVisibility(0);
      }
    }
    else
    {
      localObject = (LinearLayout)paramView.findViewById(2131304721);
      ((LinearLayout)localObject).setMinimumHeight(paramView.getResources().getDimensionPixelSize(2131165585));
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      this.OYg = ((TextView)paramView.findViewById(2131309014));
      if (this.OYg != null)
      {
        if (!this.OYl) {
          break label714;
        }
        this.OYg.setCompoundDrawablesWithIntrinsicBounds(2131235385, 0, 0, 0);
        this.OYg.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165586));
        label154:
        this.OYg.setVisibility(this.CZl);
        this.OYg.setText(this.Bgn);
        if (this.CZk != -1) {
          this.OYg.setBackgroundDrawable(this.context.getResources().getDrawable(this.CZk));
        }
      }
      this.OYf = ((TextView)paramView.findViewById(2131309016));
      if (this.OYf != null)
      {
        this.OYf.setVisibility(this.OXZ);
        this.OYf.setText(this.Bgo);
        if (this.OXY != -1) {
          this.OYf.setBackgroundDrawable(this.context.getResources().getDrawable(this.OXY));
        }
        if (this.OYa != -1) {
          this.OYf.setTextColor(this.OYa);
        }
        if (!this.OYk) {
          break label728;
        }
        this.OYf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131235385, 0);
        this.OYf.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165586));
      }
      label334:
      this.OXR = ((ImageView)paramView.findViewById(2131309007));
      this.OXR.setVisibility(this.OXO);
      if (this.OYm != -1) {
        this.OXR.setImageResource(this.OYm);
      }
      this.zkw = ((ImageView)paramView.findViewById(2131302595));
      this.OXS = ((ViewGroup)paramView.findViewById(2131307104));
      this.OYe = paramView.findViewById(2131307090);
      this.OYe.setVisibility(this.OYc);
      this.OYd = paramView.findViewById(2131307102);
      this.OYd.setVisibility(this.OXQ);
      this.EbJ = ((ImageView)paramView.findViewById(2131307076));
      this.EbJ.setVisibility(this.OZz);
      if (this.OBX == null) {
        break label742;
      }
      this.zkw.setImageBitmap(this.OBX);
      label487:
      this.zkw.setVisibility(this.OYb);
      this.OXS.setVisibility(this.OXP);
      if (this.OXW != null) {
        this.zkw.setLayoutParams(this.OXW);
      }
      this.OXT = ((TextView)paramView.findViewById(16908310));
      this.hPW = ((TextView)paramView.findViewById(2131299495));
      if (this.hPW != null)
      {
        this.hPW.setVisibility(this.OXX);
        this.hPW.setText(this.desc);
        if (!this.OYn) {
          break label764;
        }
        this.hPW.setTextColor(this.context.getResources().getColor(2131100283));
      }
      label608:
      if (this.OXT != null)
      {
        if (!this.OYn) {
          break label786;
        }
        this.OXT.setTextColor(this.context.getResources().getColor(2131100283));
      }
      label641:
      if (this.OYn) {
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
        localObject = this.OYh;
        Drawable localDrawable = getIcon();
        this.drawable = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.OYh.setVisibility(0);
        break;
      }
      this.OYh.setVisibility(8);
      break;
      label714:
      this.OYg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label154;
      label728:
      this.OYf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label334;
      label742:
      if (this.OxP == -1) {
        break label487;
      }
      this.zkw.setImageResource(this.OxP);
      break label487;
      label764:
      this.hPW.setTextColor(this.context.getResources().getColor(2131100594));
      break label608;
      this.OXT.setTextColor(this.context.getResources().getColor(2131100904));
      break label641;
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(159991);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    View.inflate(getContext(), 2131495947, localViewGroup);
    AppMethodBeat.o(159991);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.weui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */