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
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.d;
import com.tencent.mm.cr.a.e;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;

public class IconPreference
  extends Preference
{
  protected ImageView EPM;
  private String GRG;
  private int GRH;
  private int GRI;
  private TextView GRL;
  private String GZW;
  private ImageView Kpe;
  protected int VQS;
  private Bitmap VVp;
  private int WqY;
  private int WqZ;
  private int Wra;
  private ImageView Wrb;
  private ViewGroup Wrc;
  private TextView Wrd;
  RelativeLayout.LayoutParams Wrg;
  private int Wrh;
  private int Wri;
  private int Wrj;
  private int Wrk;
  private int Wrl;
  private int Wrm;
  private View Wrn;
  private View Wro;
  private TextView Wrp;
  private ImageView Wrq;
  private boolean Wrt;
  private boolean Wru;
  private int Wrv;
  private boolean Wrw;
  private int WsI;
  private Context context;
  private String desc;
  private Drawable drawable;
  private int height;
  private TextView kEs;
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159990);
    this.VQS = -1;
    this.EPM = null;
    this.GRG = "";
    this.GRH = -1;
    this.GRI = 8;
    this.WqY = 8;
    this.Wrh = 8;
    this.desc = "";
    this.GZW = "";
    this.Wri = -1;
    this.Wrj = 8;
    this.Wrk = -1;
    this.VVp = null;
    this.Wrl = 8;
    this.WqZ = 8;
    this.Wra = 8;
    this.Wrm = 8;
    this.WsI = 0;
    this.Wrb = null;
    this.Wrc = null;
    this.Wrn = null;
    this.Wro = null;
    this.Kpe = null;
    this.height = -1;
    this.Wrt = false;
    this.Wru = false;
    this.Wrv = -1;
    this.Wrw = false;
    this.context = paramContext;
    setLayoutResource(a.g.mm_preference);
    AppMethodBeat.o(159990);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(159992);
    super.onBindView(paramView);
    this.Wrq = ((ImageView)paramView.findViewById(a.f.image_iv));
    Object localObject;
    if (this.Wrq != null)
    {
      if (this.drawable != null)
      {
        this.Wrq.setImageDrawable(this.drawable);
        this.Wrq.setVisibility(0);
      }
    }
    else
    {
      localObject = (LinearLayout)paramView.findViewById(a.f.mm_preference_ll_id);
      ((LinearLayout)localObject).setMinimumHeight(paramView.getResources().getDimensionPixelSize(a.d.SmallListHeight));
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      this.GRL = ((TextView)paramView.findViewById(a.f.text_tv_one));
      if (this.GRL != null)
      {
        if (!this.Wru) {
          break label733;
        }
        this.GRL.setCompoundDrawablesWithIntrinsicBounds(a.e.unread_dot_shape, 0, 0, 0);
        this.GRL.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.d.SmallPadding));
        label160:
        this.GRL.setVisibility(this.GRI);
        this.GRL.setText(this.GRG);
        if (this.GRH != -1) {
          this.GRL.setBackgroundDrawable(this.context.getResources().getDrawable(this.GRH));
        }
      }
      this.Wrp = ((TextView)paramView.findViewById(a.f.text_tv_two));
      if (this.Wrp != null)
      {
        this.Wrp.setVisibility(this.Wrj);
        this.Wrp.setText(this.GZW);
        if (this.Wri != -1) {
          this.Wrp.setBackgroundDrawable(this.context.getResources().getDrawable(this.Wri));
        }
        if (this.Wrk != -1) {
          this.Wrp.setTextColor(this.Wrk);
        }
        if (!this.Wrt) {
          break label747;
        }
        this.Wrp.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.unread_dot_shape, 0);
        this.Wrp.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.d.SmallPadding));
      }
      label343:
      this.Wrb = ((ImageView)paramView.findViewById(a.f.text_prospect));
      this.Wrb.setVisibility(this.WqY);
      if (this.Wrv != -1) {
        this.Wrb.setImageResource(this.Wrv);
      }
      this.EPM = ((ImageView)paramView.findViewById(a.f.image_right_iv));
      this.Wrc = ((ViewGroup)paramView.findViewById(a.f.right_rl));
      this.Wro = paramView.findViewById(a.f.right_center_prospect);
      this.Wro.setVisibility(this.Wrm);
      this.Wrn = paramView.findViewById(a.f.right_prospect);
      this.Wrn.setVisibility(this.Wra);
      this.Kpe = ((ImageView)paramView.findViewById(a.f.right_arrow));
      this.Kpe.setVisibility(this.WsI);
      if (this.VVp == null) {
        break label761;
      }
      this.EPM.setImageBitmap(this.VVp);
      label502:
      this.EPM.setVisibility(this.Wrl);
      this.Wrc.setVisibility(this.WqZ);
      if (this.Wrg != null) {
        this.EPM.setLayoutParams(this.Wrg);
      }
      this.Wrd = ((TextView)paramView.findViewById(16908310));
      this.kEs = ((TextView)paramView.findViewById(a.f.desc));
      if (this.kEs != null)
      {
        this.kEs.setVisibility(this.Wrh);
        this.kEs.setText(this.desc);
        if (!this.Wrw) {
          break label783;
        }
        this.kEs.setTextColor(this.context.getResources().getColor(a.c.disable_text_color));
      }
      label626:
      if (this.Wrd != null)
      {
        if (!this.Wrw) {
          break label806;
        }
        this.Wrd.setTextColor(this.context.getResources().getColor(a.c.disable_text_color));
      }
      label660:
      if (this.Wrw) {
        break label829;
      }
    }
    label783:
    label806:
    label829:
    for (boolean bool = true;; bool = false)
    {
      paramView.setEnabled(bool);
      AppMethodBeat.o(159992);
      return;
      if (getIcon() != null)
      {
        localObject = this.Wrq;
        Drawable localDrawable = getIcon();
        this.drawable = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.Wrq.setVisibility(0);
        break;
      }
      this.Wrq.setVisibility(8);
      break;
      label733:
      this.GRL.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label160;
      label747:
      this.Wrp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label343;
      label761:
      if (this.VQS == -1) {
        break label502;
      }
      this.EPM.setImageResource(this.VQS);
      break label502;
      this.kEs.setTextColor(this.context.getResources().getColor(a.c.hint_text_color));
      break label626;
      this.Wrd.setTextColor(this.context.getResources().getColor(a.c.normal_text_color));
      break label660;
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(159991);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.f.content);
    localViewGroup.removeAllViews();
    View.inflate(getContext(), a.g.preference_content_icon, localViewGroup);
    AppMethodBeat.o(159991);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.weui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */