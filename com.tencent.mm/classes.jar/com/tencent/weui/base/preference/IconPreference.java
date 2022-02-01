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
  protected int ITn;
  private Bitmap IWY;
  private int JrZ;
  private int Jsa;
  private int Jsb;
  private ImageView Jsc;
  private ViewGroup Jsd;
  private TextView Jse;
  RelativeLayout.LayoutParams Jsh;
  private int Jsi;
  private int Jsj;
  private int Jsk;
  private int Jsl;
  private int Jsm;
  private int Jsn;
  private View Jso;
  private View Jsp;
  private TextView Jsq;
  private TextView Jsr;
  private ImageView Jss;
  private boolean Jsu;
  private boolean Jsv;
  private int Jsw;
  private boolean Jsx;
  private int JtE;
  private Context context;
  private String desc;
  private Drawable drawable;
  private TextView gUs;
  private int height;
  protected ImageView vEo;
  private String wSC;
  private String wSD;
  private int yEp;
  private int yEq;
  private ImageView zCz;
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159990);
    this.ITn = -1;
    this.vEo = null;
    this.wSC = "";
    this.yEp = -1;
    this.yEq = 8;
    this.JrZ = 8;
    this.Jsi = 8;
    this.desc = "";
    this.wSD = "";
    this.Jsj = -1;
    this.Jsk = 8;
    this.Jsl = -1;
    this.IWY = null;
    this.Jsm = 8;
    this.Jsa = 8;
    this.Jsb = 8;
    this.Jsn = 8;
    this.JtE = 0;
    this.Jsc = null;
    this.Jsd = null;
    this.Jso = null;
    this.Jsp = null;
    this.zCz = null;
    this.height = -1;
    this.Jsu = false;
    this.Jsv = false;
    this.Jsw = -1;
    this.Jsx = false;
    this.context = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(159990);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(159992);
    super.onBindView(paramView);
    this.Jss = ((ImageView)paramView.findViewById(2131300943));
    Object localObject;
    if (this.Jss != null)
    {
      if (this.drawable != null)
      {
        this.Jss.setImageDrawable(this.drawable);
        this.Jss.setVisibility(0);
      }
    }
    else
    {
      localObject = (LinearLayout)paramView.findViewById(2131302326);
      ((LinearLayout)localObject).setMinimumHeight(paramView.getResources().getDimensionPixelSize(2131165567));
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      this.Jsr = ((TextView)paramView.findViewById(2131305745));
      if (this.Jsr != null)
      {
        if (!this.Jsv) {
          break label714;
        }
        this.Jsr.setCompoundDrawablesWithIntrinsicBounds(2131234447, 0, 0, 0);
        this.Jsr.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
        label154:
        this.Jsr.setVisibility(this.yEq);
        this.Jsr.setText(this.wSC);
        if (this.yEp != -1) {
          this.Jsr.setBackgroundDrawable(this.context.getResources().getDrawable(this.yEp));
        }
      }
      this.Jsq = ((TextView)paramView.findViewById(2131305747));
      if (this.Jsq != null)
      {
        this.Jsq.setVisibility(this.Jsk);
        this.Jsq.setText(this.wSD);
        if (this.Jsj != -1) {
          this.Jsq.setBackgroundDrawable(this.context.getResources().getDrawable(this.Jsj));
        }
        if (this.Jsl != -1) {
          this.Jsq.setTextColor(this.Jsl);
        }
        if (!this.Jsu) {
          break label728;
        }
        this.Jsq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131234447, 0);
        this.Jsq.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
      }
      label334:
      this.Jsc = ((ImageView)paramView.findViewById(2131305740));
      this.Jsc.setVisibility(this.JrZ);
      if (this.Jsw != -1) {
        this.Jsc.setImageResource(this.Jsw);
      }
      this.vEo = ((ImageView)paramView.findViewById(2131300959));
      this.Jsd = ((ViewGroup)paramView.findViewById(2131304191));
      this.Jsp = paramView.findViewById(2131304181);
      this.Jsp.setVisibility(this.Jsn);
      this.Jso = paramView.findViewById(2131304190);
      this.Jso.setVisibility(this.Jsb);
      this.zCz = ((ImageView)paramView.findViewById(2131304172));
      this.zCz.setVisibility(this.JtE);
      if (this.IWY == null) {
        break label742;
      }
      this.vEo.setImageBitmap(this.IWY);
      label487:
      this.vEo.setVisibility(this.Jsm);
      this.Jsd.setVisibility(this.Jsa);
      if (this.Jsh != null) {
        this.vEo.setLayoutParams(this.Jsh);
      }
      this.Jse = ((TextView)paramView.findViewById(16908310));
      this.gUs = ((TextView)paramView.findViewById(2131298996));
      if (this.gUs != null)
      {
        this.gUs.setVisibility(this.Jsi);
        this.gUs.setText(this.desc);
        if (!this.Jsx) {
          break label764;
        }
        this.gUs.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label608:
      if (this.Jse != null)
      {
        if (!this.Jsx) {
          break label786;
        }
        this.Jse.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label641:
      if (this.Jsx) {
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
        localObject = this.Jss;
        Drawable localDrawable = getIcon();
        this.drawable = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.Jss.setVisibility(0);
        break;
      }
      this.Jss.setVisibility(8);
      break;
      label714:
      this.Jsr.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label154;
      label728:
      this.Jsq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label334;
      label742:
      if (this.ITn == -1) {
        break label487;
      }
      this.vEo.setImageResource(this.ITn);
      break label487;
      label764:
      this.gUs.setTextColor(this.context.getResources().getColor(2131100490));
      break label608;
      this.Jse.setTextColor(this.context.getResources().getColor(2131100711));
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