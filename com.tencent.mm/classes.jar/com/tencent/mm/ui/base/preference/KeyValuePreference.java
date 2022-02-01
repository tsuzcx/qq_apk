package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KeyValuePreference
  extends Preference
{
  private int IaM;
  public String JaR;
  public boolean JsK;
  private boolean JsL;
  private boolean JsM;
  private boolean JsN;
  private int JsO;
  public int JsP;
  protected ImageView JsQ;
  public Drawable JsR;
  private List<View> JsS;
  public int JsT;
  int JsU;
  private View contentView;
  public float pxm;
  protected TextView titleTv;
  protected TextView wSo;
  
  public KeyValuePreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public KeyValuePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public KeyValuePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142578);
    this.JsK = true;
    this.JsL = false;
    this.JaR = null;
    this.JsM = false;
    this.JsN = false;
    this.IaM = 17;
    this.JsO = 17;
    this.JsP = 0;
    this.JsQ = null;
    this.JsR = null;
    this.JsS = new LinkedList();
    setLayoutResource(2131494804);
    AppMethodBeat.o(142578);
  }
  
  public final void act(int paramInt)
  {
    AppMethodBeat.i(142581);
    this.JsU = paramInt;
    if (this.wSo != null) {
      this.wSo.setMaxLines(this.JsU);
    }
    AppMethodBeat.o(142581);
  }
  
  public final void fzD()
  {
    this.JsN = true;
    this.JsO = 5;
  }
  
  public final void fzE()
  {
    AppMethodBeat.i(142583);
    this.JsS.clear();
    AppMethodBeat.o(142583);
  }
  
  public final void fzF()
  {
    this.JsM = true;
    this.IaM = 49;
  }
  
  public final void gi(View paramView)
  {
    AppMethodBeat.i(142584);
    this.JsS.add(paramView);
    AppMethodBeat.o(142584);
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(142580);
    super.onBindView(paramView);
    this.contentView = paramView.findViewById(2131304242);
    if (this.Jtu != null) {
      this.contentView.setOnClickListener(new KeyValuePreference.1(this));
    }
    if (this.Jtv != null) {
      paramView.setOnLongClickListener(new KeyValuePreference.2(this));
    }
    this.wSo = ((TextView)paramView.findViewById(16908304));
    if (this.wSo != null)
    {
      this.wSo.setSingleLine(this.JsK);
      if (this.JsN) {
        this.wSo.setGravity(this.JsO);
      }
    }
    if (this.JsL) {
      setWidgetLayoutResource(2131494884);
    }
    this.titleTv = ((TextView)paramView.findViewById(16908310));
    if (!bt.isNullOrNil(this.JaR)) {
      this.titleTv.setText(this.JaR);
    }
    Object localObject;
    int i;
    if (this.titleTv != null)
    {
      localObject = this.titleTv.getLayoutParams();
      if (this.JsT == 0)
      {
        i = a.ax(this.mContext, 2131165370);
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.titleTv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      this.JsQ = ((ImageView)paramView.findViewById(2131300943));
      if (this.JsR == null) {
        break label368;
      }
      this.JsQ.setVisibility(this.JsP);
      this.JsQ.setImageDrawable(this.JsR);
    }
    for (;;)
    {
      if (this.JsM)
      {
        localObject = (LinearLayout)paramView.findViewById(2131298736);
        if (localObject != null) {
          ((LinearLayout)localObject).setGravity(this.IaM);
        }
      }
      if (this.JsS.size() <= 0) {
        break label380;
      }
      paramView = (LinearLayout)paramView.findViewById(2131305550);
      paramView.removeAllViews();
      localObject = this.JsS.iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        ViewGroup localViewGroup = (ViewGroup)localView.getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(localView);
        }
        paramView.addView(localView);
      }
      i = this.JsT;
      break;
      label368:
      this.JsQ.setVisibility(8);
    }
    label380:
    if (this.pxm != 0.0F)
    {
      this.titleTv.setTextSize(this.pxm);
      this.wSo.setTextSize(this.pxm);
    }
    if (this.JsU > 0) {
      this.wSo.setMaxLines(this.JsU);
    }
    AppMethodBeat.o(142580);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142579);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494832, localViewGroup);
    AppMethodBeat.o(142579);
    return paramViewGroup;
  }
  
  public final void xG(boolean paramBoolean)
  {
    AppMethodBeat.i(142582);
    this.JsL = paramBoolean;
    if (this.JsL) {
      setWidgetLayoutResource(2131494884);
    }
    AppMethodBeat.o(142582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.KeyValuePreference
 * JD-Core Version:    0.7.0.1
 */