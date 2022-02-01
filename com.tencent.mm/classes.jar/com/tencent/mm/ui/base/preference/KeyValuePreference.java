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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KeyValuePreference
  extends Preference
{
  private int IuT;
  private boolean JNA;
  private boolean JNB;
  private boolean JNC;
  private int JND;
  public int JNE;
  protected ImageView JNF;
  public Drawable JNG;
  private List<View> JNH;
  public int JNI;
  int JNJ;
  public boolean JNz;
  public String Jvz;
  private View contentView;
  public float pDQ;
  protected TextView titleTv;
  protected TextView xif;
  
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
    this.JNz = true;
    this.JNA = false;
    this.Jvz = null;
    this.JNB = false;
    this.JNC = false;
    this.IuT = 17;
    this.JND = 17;
    this.JNE = 0;
    this.JNF = null;
    this.JNG = null;
    this.JNH = new LinkedList();
    setLayoutResource(2131494804);
    AppMethodBeat.o(142578);
  }
  
  public final void ada(int paramInt)
  {
    AppMethodBeat.i(142581);
    this.JNJ = paramInt;
    if (this.xif != null) {
      this.xif.setMaxLines(this.JNJ);
    }
    AppMethodBeat.o(142581);
  }
  
  public final void fDF()
  {
    this.JNC = true;
    this.JND = 5;
  }
  
  public final void fDG()
  {
    AppMethodBeat.i(142583);
    this.JNH.clear();
    AppMethodBeat.o(142583);
  }
  
  public final void fDH()
  {
    this.JNB = true;
    this.IuT = 49;
  }
  
  public final void gh(View paramView)
  {
    AppMethodBeat.i(142584);
    this.JNH.add(paramView);
    AppMethodBeat.o(142584);
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(142580);
    super.onBindView(paramView);
    this.contentView = paramView.findViewById(2131304242);
    if (this.JOj != null) {
      this.contentView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(142576);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/preference/KeyValuePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          KeyValuePreference.this.JOj.dDy();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/preference/KeyValuePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142576);
        }
      });
    }
    if (this.JOk != null) {
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(142577);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/preference/KeyValuePreference$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
          boolean bool = KeyValuePreference.this.JOk.dEL();
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/preference/KeyValuePreference$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(142577);
          return bool;
        }
      });
    }
    this.xif = ((TextView)paramView.findViewById(16908304));
    if (this.xif != null)
    {
      this.xif.setSingleLine(this.JNz);
      if (this.JNC) {
        this.xif.setGravity(this.JND);
      }
    }
    if (this.JNA) {
      setWidgetLayoutResource(2131494884);
    }
    this.titleTv = ((TextView)paramView.findViewById(16908310));
    if (!bu.isNullOrNil(this.Jvz)) {
      this.titleTv.setText(this.Jvz);
    }
    Object localObject;
    int i;
    if (this.titleTv != null)
    {
      localObject = this.titleTv.getLayoutParams();
      if (this.JNI == 0)
      {
        i = com.tencent.mm.cb.a.ax(this.mContext, 2131165370);
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.titleTv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      this.JNF = ((ImageView)paramView.findViewById(2131300943));
      if (this.JNG == null) {
        break label368;
      }
      this.JNF.setVisibility(this.JNE);
      this.JNF.setImageDrawable(this.JNG);
    }
    for (;;)
    {
      if (this.JNB)
      {
        localObject = (LinearLayout)paramView.findViewById(2131298736);
        if (localObject != null) {
          ((LinearLayout)localObject).setGravity(this.IuT);
        }
      }
      if (this.JNH.size() <= 0) {
        break label380;
      }
      paramView = (LinearLayout)paramView.findViewById(2131305550);
      paramView.removeAllViews();
      localObject = this.JNH.iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        ViewGroup localViewGroup = (ViewGroup)localView.getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(localView);
        }
        paramView.addView(localView);
      }
      i = this.JNI;
      break;
      label368:
      this.JNF.setVisibility(8);
    }
    label380:
    if (this.pDQ != 0.0F)
    {
      this.titleTv.setTextSize(this.pDQ);
      this.xif.setTextSize(this.pDQ);
    }
    if (this.JNJ > 0) {
      this.xif.setMaxLines(this.JNJ);
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
  
  public final void xN(boolean paramBoolean)
  {
    AppMethodBeat.i(142582);
    this.JNA = paramBoolean;
    if (this.JNA) {
      setWidgetLayoutResource(2131494884);
    }
    AppMethodBeat.o(142582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.KeyValuePreference
 * JD-Core Version:    0.7.0.1
 */