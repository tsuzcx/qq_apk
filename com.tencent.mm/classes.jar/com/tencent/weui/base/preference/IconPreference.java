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
  private int JMO;
  private int JMP;
  private int JMQ;
  private ImageView JMR;
  private ViewGroup JMS;
  private TextView JMT;
  RelativeLayout.LayoutParams JMW;
  private int JMX;
  private int JMY;
  private int JMZ;
  private int JNa;
  private int JNb;
  private int JNc;
  private View JNd;
  private View JNe;
  private TextView JNf;
  private TextView JNg;
  private ImageView JNh;
  private boolean JNj;
  private boolean JNk;
  private int JNl;
  private boolean JNm;
  private int JOt;
  protected int JnV;
  private Bitmap JrG;
  private Context context;
  private String desc;
  private Drawable drawable;
  private TextView gXb;
  private int height;
  protected ImageView vQs;
  private String xit;
  private String xiu;
  private int yUu;
  private int yUv;
  private ImageView zTB;
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159990);
    this.JnV = -1;
    this.vQs = null;
    this.xit = "";
    this.yUu = -1;
    this.yUv = 8;
    this.JMO = 8;
    this.JMX = 8;
    this.desc = "";
    this.xiu = "";
    this.JMY = -1;
    this.JMZ = 8;
    this.JNa = -1;
    this.JrG = null;
    this.JNb = 8;
    this.JMP = 8;
    this.JMQ = 8;
    this.JNc = 8;
    this.JOt = 0;
    this.JMR = null;
    this.JMS = null;
    this.JNd = null;
    this.JNe = null;
    this.zTB = null;
    this.height = -1;
    this.JNj = false;
    this.JNk = false;
    this.JNl = -1;
    this.JNm = false;
    this.context = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(159990);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(159992);
    super.onBindView(paramView);
    this.JNh = ((ImageView)paramView.findViewById(2131300943));
    Object localObject;
    if (this.JNh != null)
    {
      if (this.drawable != null)
      {
        this.JNh.setImageDrawable(this.drawable);
        this.JNh.setVisibility(0);
      }
    }
    else
    {
      localObject = (LinearLayout)paramView.findViewById(2131302326);
      ((LinearLayout)localObject).setMinimumHeight(paramView.getResources().getDimensionPixelSize(2131165567));
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      this.JNg = ((TextView)paramView.findViewById(2131305745));
      if (this.JNg != null)
      {
        if (!this.JNk) {
          break label714;
        }
        this.JNg.setCompoundDrawablesWithIntrinsicBounds(2131234447, 0, 0, 0);
        this.JNg.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
        label154:
        this.JNg.setVisibility(this.yUv);
        this.JNg.setText(this.xit);
        if (this.yUu != -1) {
          this.JNg.setBackgroundDrawable(this.context.getResources().getDrawable(this.yUu));
        }
      }
      this.JNf = ((TextView)paramView.findViewById(2131305747));
      if (this.JNf != null)
      {
        this.JNf.setVisibility(this.JMZ);
        this.JNf.setText(this.xiu);
        if (this.JMY != -1) {
          this.JNf.setBackgroundDrawable(this.context.getResources().getDrawable(this.JMY));
        }
        if (this.JNa != -1) {
          this.JNf.setTextColor(this.JNa);
        }
        if (!this.JNj) {
          break label728;
        }
        this.JNf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131234447, 0);
        this.JNf.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
      }
      label334:
      this.JMR = ((ImageView)paramView.findViewById(2131305740));
      this.JMR.setVisibility(this.JMO);
      if (this.JNl != -1) {
        this.JMR.setImageResource(this.JNl);
      }
      this.vQs = ((ImageView)paramView.findViewById(2131300959));
      this.JMS = ((ViewGroup)paramView.findViewById(2131304191));
      this.JNe = paramView.findViewById(2131304181);
      this.JNe.setVisibility(this.JNc);
      this.JNd = paramView.findViewById(2131304190);
      this.JNd.setVisibility(this.JMQ);
      this.zTB = ((ImageView)paramView.findViewById(2131304172));
      this.zTB.setVisibility(this.JOt);
      if (this.JrG == null) {
        break label742;
      }
      this.vQs.setImageBitmap(this.JrG);
      label487:
      this.vQs.setVisibility(this.JNb);
      this.JMS.setVisibility(this.JMP);
      if (this.JMW != null) {
        this.vQs.setLayoutParams(this.JMW);
      }
      this.JMT = ((TextView)paramView.findViewById(16908310));
      this.gXb = ((TextView)paramView.findViewById(2131298996));
      if (this.gXb != null)
      {
        this.gXb.setVisibility(this.JMX);
        this.gXb.setText(this.desc);
        if (!this.JNm) {
          break label764;
        }
        this.gXb.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label608:
      if (this.JMT != null)
      {
        if (!this.JNm) {
          break label786;
        }
        this.JMT.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label641:
      if (this.JNm) {
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
        localObject = this.JNh;
        Drawable localDrawable = getIcon();
        this.drawable = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.JNh.setVisibility(0);
        break;
      }
      this.JNh.setVisibility(8);
      break;
      label714:
      this.JNg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label154;
      label728:
      this.JNf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label334;
      label742:
      if (this.JnV == -1) {
        break label487;
      }
      this.vQs.setImageResource(this.JnV);
      break label487;
      label764:
      this.gXb.setTextColor(this.context.getResources().getColor(2131100490));
      break label608;
      this.JMT.setTextColor(this.context.getResources().getColor(2131100711));
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