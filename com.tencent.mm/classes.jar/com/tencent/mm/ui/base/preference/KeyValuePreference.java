package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KeyValuePreference
  extends Preference
{
  public String DJc;
  protected TextView GZI;
  private int UVT;
  public boolean WrK;
  private boolean WrL;
  private boolean WrM;
  private boolean WrN;
  private int WrO;
  public int WrP;
  protected ImageView WrQ;
  public Drawable WrR;
  private List<View> WrS;
  public int WrT;
  int WrU;
  private View contentView;
  public float jAg;
  protected TextView titleTv;
  
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
    this.WrK = true;
    this.WrL = false;
    this.DJc = null;
    this.WrM = false;
    this.WrN = false;
    this.UVT = 17;
    this.WrO = 17;
    this.WrP = 0;
    this.WrQ = null;
    this.WrR = null;
    this.WrS = new LinkedList();
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(142578);
  }
  
  public final void FU(boolean paramBoolean)
  {
    AppMethodBeat.i(142582);
    this.WrL = paramBoolean;
    if (this.WrL) {
      auN(a.h.mm_preference_submenu);
    }
    AppMethodBeat.o(142582);
  }
  
  public final void auK(int paramInt)
  {
    AppMethodBeat.i(142581);
    this.WrU = paramInt;
    if (this.GZI != null) {
      this.GZI.setMaxLines(this.WrU);
    }
    AppMethodBeat.o(142581);
  }
  
  public final void hK(View paramView)
  {
    AppMethodBeat.i(142584);
    this.WrS.add(paramView);
    AppMethodBeat.o(142584);
  }
  
  public final void hKM()
  {
    this.WrN = true;
    this.WrO = 5;
  }
  
  public final void hKN()
  {
    AppMethodBeat.i(142583);
    this.WrS.clear();
    AppMethodBeat.o(142583);
  }
  
  public final void hKO()
  {
    this.WrM = true;
    this.UVT = 49;
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(142580);
    super.onBindView(paramView);
    this.contentView = paramView.findViewById(a.g.root_content);
    if (this.Wsy != null) {
      this.contentView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(142576);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/preference/KeyValuePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          KeyValuePreference.this.Wsy.fpI();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/preference/KeyValuePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142576);
        }
      });
    }
    if (this.Wsz != null) {
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(142577);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/preference/KeyValuePreference$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
          boolean bool = KeyValuePreference.this.Wsz.fqY();
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/preference/KeyValuePreference$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(142577);
          return bool;
        }
      });
    }
    this.GZI = ((TextView)paramView.findViewById(16908304));
    if (this.GZI != null)
    {
      this.GZI.setSingleLine(this.WrK);
      if (this.WrN) {
        this.GZI.setGravity(this.WrO);
      }
    }
    if (this.WrL) {
      auN(a.h.mm_preference_submenu);
    }
    this.titleTv = ((TextView)paramView.findViewById(16908310));
    if (!Util.isNullOrNil(this.DJc)) {
      this.titleTv.setText(this.DJc);
    }
    Object localObject;
    int i;
    if (this.titleTv != null)
    {
      localObject = this.titleTv.getLayoutParams();
      if (this.WrT == 0)
      {
        i = com.tencent.mm.ci.a.aY(this.mContext, a.e.FixedTitleWidth);
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.titleTv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      this.WrQ = ((ImageView)paramView.findViewById(a.g.image_iv));
      if (this.WrR == null) {
        break label374;
      }
      this.WrQ.setVisibility(this.WrP);
      this.WrQ.setImageDrawable(this.WrR);
    }
    for (;;)
    {
      if (this.WrM)
      {
        localObject = (LinearLayout)paramView.findViewById(a.g.container);
        if (localObject != null) {
          ((LinearLayout)localObject).setGravity(this.UVT);
        }
      }
      if (this.WrS.size() <= 0) {
        break label386;
      }
      paramView = (LinearLayout)paramView.findViewById(a.g.summary_container);
      paramView.removeAllViews();
      localObject = this.WrS.iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        ViewGroup localViewGroup = (ViewGroup)localView.getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(localView);
        }
        paramView.addView(localView);
      }
      i = this.WrT;
      break;
      label374:
      this.WrQ.setVisibility(8);
    }
    label386:
    if (this.jAg != 0.0F)
    {
      this.titleTv.setTextSize(this.jAg);
      this.GZI.setTextSize(this.jAg);
    }
    if (this.WrU > 0) {
      this.GZI.setMaxLines(this.WrU);
    }
    AppMethodBeat.o(142580);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142579);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(a.h.mm_preference_content_keyvalue, localViewGroup);
    AppMethodBeat.o(142579);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.KeyValuePreference
 * JD-Core Version:    0.7.0.1
 */