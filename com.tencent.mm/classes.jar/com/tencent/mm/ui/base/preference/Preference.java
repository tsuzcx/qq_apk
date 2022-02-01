package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.a.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.y;
import java.util.List;

public class Preference
  implements Comparable<Preference>
{
  int Coj;
  private CharSequence Eo;
  private a GfN;
  public b GfO;
  public c GfP;
  private int GfQ;
  private int GfR;
  private String GfS;
  boolean GfT;
  private boolean GfU;
  public boolean GfV;
  String GfW;
  private boolean GfX;
  private int GfY;
  private boolean GfZ;
  public boolean Gga;
  public boolean Ggb;
  private boolean Ggc;
  private int Ggd;
  public int Gge;
  private boolean Ggf;
  private List<Preference> Ggg;
  private int[] NC;
  protected Drawable Uy;
  protected int abP;
  private int bBv;
  public final Context mContext;
  private Object mDefaultValue;
  private boolean mEnabled;
  private Bundle mExtras;
  public String mKey;
  public int nJy;
  private CharSequence uEo;
  private ImageView wYW;
  
  public Preference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Preference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842894);
  }
  
  public Preference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(142632);
    this.NC = new int[] { 2130969590, 2130969495 };
    this.bBv = 2147483647;
    this.Coj = 0;
    this.mEnabled = true;
    this.GfT = true;
    this.GfV = true;
    this.GfX = true;
    this.nJy = -1;
    this.wYW = null;
    this.GfY = 0;
    this.GfZ = false;
    this.Gga = false;
    this.Ggb = false;
    this.Ggc = true;
    this.Ggd = 2131494804;
    this.Ggf = false;
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.Preference, paramInt, 0);
    paramInt = paramAttributeSet.getIndexCount();
    if (paramInt >= 0)
    {
      int i = paramAttributeSet.getIndex(paramInt);
      if (i == 4) {
        this.abP = paramAttributeSet.getResourceId(i, 0);
      }
      for (;;)
      {
        paramInt -= 1;
        break;
        if (i == 5)
        {
          this.Coj = paramAttributeSet.getColor(i, 0);
        }
        else if (i == 6)
        {
          this.mKey = paramAttributeSet.getString(i);
        }
        else if (i == 13)
        {
          this.GfQ = paramAttributeSet.getResourceId(i, 0);
          this.Eo = paramAttributeSet.getString(i);
          if (this.GfQ != 0) {
            this.Eo = paramContext.getString(this.GfQ);
          }
        }
        else if (i == 12)
        {
          this.uEo = paramAttributeSet.getString(i);
          this.GfR = paramAttributeSet.getResourceId(i, 0);
          if (this.GfR != 0) {
            this.uEo = paramContext.getString(this.GfR);
          }
        }
        else if (i == 8)
        {
          this.bBv = paramAttributeSet.getInt(i, this.bBv);
        }
        else if (i == 3)
        {
          this.GfS = paramAttributeSet.getString(i);
        }
        else if (i == 7)
        {
          this.Ggd = paramAttributeSet.getResourceId(i, this.Ggd);
        }
        else if (i == 14)
        {
          this.Gge = paramAttributeSet.getResourceId(i, this.Gge);
        }
        else if (i == 2)
        {
          this.mEnabled = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == 10)
        {
          this.GfT = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == 9)
        {
          this.GfV = paramAttributeSet.getBoolean(i, this.GfV);
        }
        else if (i == 1)
        {
          this.GfW = paramAttributeSet.getString(i);
        }
        else if (i == 0)
        {
          this.mDefaultValue = null;
        }
        else if (i == 11)
        {
          this.Ggc = paramAttributeSet.getBoolean(i, this.Ggc);
        }
      }
    }
    paramAttributeSet.recycle();
    if (!getClass().getName().startsWith("android.preference")) {
      this.Ggf = true;
    }
    AppMethodBeat.o(142632);
  }
  
  private void eTG()
  {
    AppMethodBeat.i(142646);
    if (this.mKey == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Preference does not have a key assigned.");
      AppMethodBeat.o(142646);
      throw localIllegalStateException;
    }
    this.GfU = true;
    AppMethodBeat.o(142646);
  }
  
  private boolean hasKey()
  {
    AppMethodBeat.i(142647);
    if (!TextUtils.isEmpty(this.mKey))
    {
      AppMethodBeat.o(142647);
      return true;
    }
    AppMethodBeat.o(142647);
    return false;
  }
  
  private void notifyDependencyChange(boolean paramBoolean)
  {
    AppMethodBeat.i(142649);
    List localList = this.Ggg;
    if (localList == null)
    {
      AppMethodBeat.o(142649);
      return;
    }
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      ((Preference)localList.get(i)).vS(paramBoolean);
      i += 1;
    }
    AppMethodBeat.o(142649);
  }
  
  private boolean shouldDisableDependents()
  {
    AppMethodBeat.i(142651);
    if (!isEnabled())
    {
      AppMethodBeat.o(142651);
      return true;
    }
    AppMethodBeat.o(142651);
    return false;
  }
  
  private void vS(boolean paramBoolean)
  {
    AppMethodBeat.i(142650);
    if (this.GfX == paramBoolean) {
      if (paramBoolean) {
        break label42;
      }
    }
    label42:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.GfX = paramBoolean;
      notifyDependencyChange(shouldDisableDependents());
      notifyChanged();
      AppMethodBeat.o(142650);
      return;
    }
  }
  
  private void w(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(142637);
    paramView.setEnabled(paramBoolean);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = paramView.getChildCount() - 1;
      while (i >= 0)
      {
        w(paramView.getChildAt(i), paramBoolean);
        i -= 1;
      }
    }
    AppMethodBeat.o(142637);
  }
  
  public final void Yb(int paramInt)
  {
    AppMethodBeat.i(142652);
    this.GfY = paramInt;
    if (this.wYW != null) {
      this.wYW.setVisibility(paramInt);
    }
    AppMethodBeat.o(142652);
  }
  
  public void a(a parama)
  {
    this.GfN = parama;
  }
  
  protected final boolean callChangeListener(Object paramObject)
  {
    AppMethodBeat.i(142648);
    if (this.GfN == null)
    {
      AppMethodBeat.o(142648);
      return true;
    }
    boolean bool = this.GfN.a(this, paramObject);
    AppMethodBeat.o(142648);
    return bool;
  }
  
  public final void eTH()
  {
    this.GfZ = true;
  }
  
  public void fK()
  {
    AppMethodBeat.i(142640);
    this.abP = 2131689519;
    Drawable localDrawable = this.mContext.getResources().getDrawable(2131689519);
    if (((localDrawable == null) && (this.Uy != null)) || ((localDrawable != null) && (this.Uy != localDrawable)))
    {
      this.Uy = localDrawable;
      notifyChanged();
    }
    AppMethodBeat.o(142640);
  }
  
  public final void gah()
  {
    this.GfV = false;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final Bundle getExtras()
  {
    AppMethodBeat.i(142633);
    if (this.mExtras == null) {
      this.mExtras = new Bundle();
    }
    Bundle localBundle = this.mExtras;
    AppMethodBeat.o(142633);
    return localBundle;
  }
  
  public final String getKey()
  {
    return this.mKey;
  }
  
  public int getLayoutResource()
  {
    return this.Ggd;
  }
  
  public CharSequence getSummary()
  {
    return this.uEo;
  }
  
  public CharSequence getTitle()
  {
    return this.Eo;
  }
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142634);
    View localView = paramView;
    if (paramView == null) {
      localView = onCreateView(paramViewGroup);
    }
    onBindView(localView);
    AppMethodBeat.o(142634);
    return localView;
  }
  
  public final boolean isEnabled()
  {
    return (this.mEnabled) && (this.GfX);
  }
  
  protected void notifyChanged() {}
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(142636);
    Object localObject1 = paramView.findViewById(2131298739);
    if (localObject1 != null)
    {
      ((View)localObject1).setMinimumHeight((int)(this.mContext.getResources().getDimensionPixelSize(2131165488) * a.hR(this.mContext)));
      ad.d("dancy test", "resource:%s, height:%s, scale:%s", new Object[] { this.mContext.getResources(), Integer.valueOf(this.mContext.getResources().getDimensionPixelSize(2131165488)), Float.valueOf(a.hR(this.mContext)) });
    }
    localObject1 = (TextView)paramView.findViewById(16908310);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = getTitle();
      if ((localObject2 != null) && ((localObject2 instanceof Spannable)))
      {
        if (this.Ggb) {
          ((TextView)localObject1).setClickable(true);
        }
        if (((TextView)localObject1).isClickable()) {
          ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
        }
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
    }
    else
    {
      localObject2 = (TextView)paramView.findViewById(16908304);
      if (localObject2 != null)
      {
        if (TextUtils.isEmpty(getSummary())) {
          break label464;
        }
        if (((TextView)localObject2).getVisibility() != 0) {
          ((TextView)localObject2).setVisibility(0);
        }
        if (!this.Gga) {
          break label452;
        }
        ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)localObject2).setClickable(true);
        ((TextView)localObject2).setText(getSummary(), TextView.BufferType.SPANNABLE);
        label240:
        if (this.nJy != -1) {
          ((TextView)localObject2).setTextColor(this.nJy);
        }
        if ((localObject1 != null) && (this.GfZ)) {
          ((TextView)localObject2).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(164171);
              CharSequence localCharSequence = Preference.this.getSummary();
              if (localCharSequence == null)
              {
                AppMethodBeat.o(164171);
                return;
              }
              int i = this.uqN.getMeasuredWidth() + this.Ggh.getMeasuredWidth();
              if (i > 0)
              {
                int j = (int)this.Ggh.getPaint().measureText(this.Ggh.getText().toString());
                if ((int)this.uqN.getPaint().measureText(localCharSequence, 0, localCharSequence.length()) + j > i)
                {
                  localCharSequence = TextUtils.ellipsize(localCharSequence, this.uqN.getPaint(), i - j - 5, TextUtils.TruncateAt.END);
                  this.uqN.setText(localCharSequence);
                }
              }
              AppMethodBeat.o(164171);
            }
          });
        }
      }
      label285:
      localObject1 = (ImageView)paramView.findViewById(16908294);
      if (localObject1 != null)
      {
        if ((this.abP != 0) || (this.Uy != null))
        {
          if (this.Uy == null) {
            this.Uy = this.mContext.getResources().getDrawable(this.abP);
          }
          if (this.Uy != null)
          {
            ((ImageView)localObject1).setImageDrawable(this.Uy);
            if (this.Coj != 0) {
              ((ImageView)localObject1).getDrawable().setColorFilter(this.Coj, PorterDuff.Mode.SRC_ATOP);
            }
          }
        }
        if (this.Uy == null) {
          break label484;
        }
      }
    }
    label452:
    label464:
    label484:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject1).setVisibility(i);
      this.wYW = ((ImageView)paramView.findViewById(2131304172));
      if (this.wYW != null) {
        this.wYW.setVisibility(this.GfY);
      }
      if (this.Ggc) {
        w(paramView, isEnabled());
      }
      AppMethodBeat.o(142636);
      return;
      ((TextView)localObject1).setMovementMethod(null);
      break;
      ((TextView)localObject2).setText(getSummary());
      break label240;
      if (((TextView)localObject2).getVisibility() == 8) {
        break label285;
      }
      ((TextView)localObject2).setVisibility(8);
      break label285;
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142635);
    LayoutInflater localLayoutInflater = y.js(this.mContext);
    paramViewGroup = localLayoutInflater.inflate(this.Ggd, paramViewGroup, false);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(16908312);
    if (localViewGroup != null)
    {
      if (this.Gge == 0) {
        break label65;
      }
      localLayoutInflater.inflate(this.Gge, localViewGroup);
    }
    for (;;)
    {
      AppMethodBeat.o(142635);
      return paramViewGroup;
      label65:
      localViewGroup.setVisibility(8);
    }
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(142643);
    if (this.mEnabled != paramBoolean)
    {
      this.mEnabled = paramBoolean;
      notifyDependencyChange(shouldDisableDependents());
      notifyChanged();
    }
    AppMethodBeat.o(142643);
  }
  
  public final void setKey(String paramString)
  {
    AppMethodBeat.i(142645);
    this.mKey = paramString;
    if ((this.GfU) && (!hasKey())) {
      eTG();
    }
    AppMethodBeat.o(142645);
  }
  
  public final void setLayoutResource(int paramInt)
  {
    if (paramInt != this.Ggd) {
      this.Ggf = true;
    }
    this.Ggd = paramInt;
  }
  
  public final void setSelectable(boolean paramBoolean)
  {
    AppMethodBeat.i(142644);
    if (this.GfT != paramBoolean)
    {
      this.GfT = paramBoolean;
      notifyChanged();
    }
    AppMethodBeat.o(142644);
  }
  
  public void setSummary(int paramInt)
  {
    AppMethodBeat.i(142642);
    setSummary(this.mContext.getString(paramInt));
    AppMethodBeat.o(142642);
  }
  
  public void setSummary(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142641);
    if (((paramCharSequence == null) && (this.uEo != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.uEo))))
    {
      this.uEo = paramCharSequence;
      notifyChanged();
    }
    AppMethodBeat.o(142641);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(142639);
    setTitle(this.mContext.getString(paramInt));
    this.GfQ = paramInt;
    AppMethodBeat.o(142639);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142638);
    if (((paramCharSequence == null) && (this.Eo != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.Eo))))
    {
      this.GfQ = 0;
      this.Eo = paramCharSequence;
      notifyChanged();
    }
    AppMethodBeat.o(142638);
  }
  
  public final void setWidgetLayoutResource(int paramInt)
  {
    if (paramInt != this.Gge) {
      this.Ggf = true;
    }
    this.Gge = paramInt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(142653);
    Object localObject = new StringBuilder();
    CharSequence localCharSequence = getTitle();
    if (!TextUtils.isEmpty(localCharSequence)) {
      ((StringBuilder)localObject).append(localCharSequence).append(' ');
    }
    localCharSequence = getSummary();
    if (!TextUtils.isEmpty(localCharSequence)) {
      ((StringBuilder)localObject).append(localCharSequence).append(' ');
    }
    if (((StringBuilder)localObject).length() > 0) {
      ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 1);
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(142653);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(Preference paramPreference, Object paramObject);
  }
  
  public static abstract interface b
  {
    public abstract boolean dbW();
  }
  
  public static abstract interface c
  {
    public abstract boolean ddk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.Preference
 * JD-Core Version:    0.7.0.1
 */