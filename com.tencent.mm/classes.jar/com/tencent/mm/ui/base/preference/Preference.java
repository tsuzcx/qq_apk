package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable.Creator;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.m;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.y;
import java.util.List;

public class Preference
  implements Comparable<Preference>
{
  private CharSequence BM;
  private int[] FV = { a.c.title, a.c.summary };
  private boolean IL = true;
  public int Ub;
  public int izu = -1;
  public Drawable kc;
  public final Context mContext;
  private Bundle mExtras;
  public String mKey;
  private CharSequence mYY;
  private a vdB;
  public b vdC;
  public c vdD;
  private int vdE = 2147483647;
  private int vdF;
  private int vdG;
  private String vdH;
  boolean vdI = true;
  private boolean vdJ;
  public boolean vdK = true;
  String vdL;
  private Object vdM;
  private boolean vdN = true;
  private boolean vdO = true;
  private int vdP = a.h.mm_preference;
  int vdQ;
  private boolean vdR = false;
  private List<Preference> vdS;
  
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
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.Preference, paramInt, 0);
    paramInt = paramAttributeSet.getIndexCount();
    if (paramInt >= 0)
    {
      int i = paramAttributeSet.getIndex(paramInt);
      if (i == a.m.Preference_icon) {
        this.Ub = paramAttributeSet.getResourceId(i, 0);
      }
      for (;;)
      {
        paramInt -= 1;
        break;
        if (i == a.m.Preference_key)
        {
          this.mKey = paramAttributeSet.getString(i);
        }
        else if (i == a.m.Preference_title)
        {
          this.vdF = paramAttributeSet.getResourceId(i, 0);
          this.BM = paramAttributeSet.getString(i);
          if (this.vdF != 0) {
            this.BM = paramContext.getString(this.vdF);
          }
        }
        else if (i == a.m.Preference_summary)
        {
          this.mYY = paramAttributeSet.getString(i);
          this.vdG = paramAttributeSet.getResourceId(i, 0);
          if (this.vdG != 0) {
            this.mYY = paramContext.getString(this.vdG);
          }
        }
        else if (i == a.m.Preference_order)
        {
          this.vdE = paramAttributeSet.getInt(i, this.vdE);
        }
        else if (i == a.m.Preference_fragment)
        {
          this.vdH = paramAttributeSet.getString(i);
        }
        else if (i == a.m.Preference_layout)
        {
          this.vdP = paramAttributeSet.getResourceId(i, this.vdP);
        }
        else if (i == a.m.Preference_widgetLayout)
        {
          this.vdQ = paramAttributeSet.getResourceId(i, this.vdQ);
        }
        else if (i == a.m.Preference_enabled)
        {
          this.IL = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == a.m.Preference_selectable)
        {
          this.vdI = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == a.m.Preference_persistent)
        {
          this.vdK = paramAttributeSet.getBoolean(i, this.vdK);
        }
        else if (i == a.m.Preference_dependency)
        {
          this.vdL = paramAttributeSet.getString(i);
        }
        else if (i == a.m.Preference_defaultValue)
        {
          this.vdM = null;
        }
        else if (i == a.m.Preference_shouldDisableView)
        {
          this.vdO = paramAttributeSet.getBoolean(i, this.vdO);
        }
      }
    }
    paramAttributeSet.recycle();
    if (!getClass().getName().startsWith("android.preference")) {
      this.vdR = true;
    }
  }
  
  private void notifyDependencyChange(boolean paramBoolean)
  {
    List localList = this.vdS;
    if (localList == null) {
      return;
    }
    int j = localList.size();
    int i = 0;
    label22:
    Preference localPreference;
    if (i < j)
    {
      localPreference = (Preference)localList.get(i);
      if (localPreference.vdN == paramBoolean) {
        if (paramBoolean) {
          break label85;
        }
      }
    }
    label85:
    for (boolean bool = true;; bool = false)
    {
      localPreference.vdN = bool;
      localPreference.notifyDependencyChange(localPreference.shouldDisableDependents());
      localPreference.notifyChanged();
      i += 1;
      break label22;
      break;
    }
  }
  
  private void p(View paramView, boolean paramBoolean)
  {
    paramView.setEnabled(paramBoolean);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = paramView.getChildCount() - 1;
      while (i >= 0)
      {
        p(paramView.getChildAt(i), paramBoolean);
        i -= 1;
      }
    }
  }
  
  private boolean shouldDisableDependents()
  {
    return !isEnabled();
  }
  
  public void a(a parama)
  {
    this.vdB = parama;
  }
  
  public final boolean callChangeListener(Object paramObject)
  {
    if (this.vdB == null) {
      return true;
    }
    return this.vdB.a(this, paramObject);
  }
  
  public final Bundle getExtras()
  {
    if (this.mExtras == null) {
      this.mExtras = new Bundle();
    }
    return this.mExtras;
  }
  
  public int getLayoutResource()
  {
    return this.vdP;
  }
  
  public CharSequence getSummary()
  {
    return this.mYY;
  }
  
  public CharSequence getTitle()
  {
    return this.BM;
  }
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = onCreateView(paramViewGroup);
    }
    onBindView(localView);
    return localView;
  }
  
  public final boolean isEnabled()
  {
    return (this.IL) && (this.vdN);
  }
  
  public void notifyChanged() {}
  
  public void onBindView(View paramView)
  {
    int i = 0;
    Object localObject = paramView.findViewById(a.g.content);
    if (localObject != null) {
      ((View)localObject).setMinimumHeight((int)(paramView.getResources().getDimensionPixelSize(a.e.SmallListHeight) * a.fg(this.mContext)));
    }
    localObject = (TextView)paramView.findViewById(16908310);
    if (localObject != null)
    {
      CharSequence localCharSequence = getTitle();
      if ((localCharSequence != null) && ((localCharSequence instanceof Spannable)))
      {
        if (((TextView)localObject).isClickable()) {
          ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
        }
        ((TextView)localObject).setText(localCharSequence);
      }
    }
    else
    {
      localObject = (TextView)paramView.findViewById(16908304);
      if (localObject != null)
      {
        if (TextUtils.isEmpty(getSummary())) {
          break label259;
        }
        if (((TextView)localObject).getVisibility() != 0) {
          ((TextView)localObject).setVisibility(0);
        }
        ((TextView)localObject).setText(getSummary());
        if (this.izu != -1) {
          ((TextView)localObject).setTextColor(this.izu);
        }
      }
      label153:
      localObject = (ImageView)paramView.findViewById(16908294);
      if (localObject != null)
      {
        if ((this.Ub != 0) || (this.kc != null))
        {
          if (this.kc == null) {
            this.kc = this.mContext.getResources().getDrawable(this.Ub);
          }
          if (this.kc != null) {
            ((ImageView)localObject).setImageDrawable(this.kc);
          }
        }
        if (this.kc == null) {
          break label277;
        }
      }
    }
    for (;;)
    {
      ((ImageView)localObject).setVisibility(i);
      if (this.vdO) {
        p(paramView, isEnabled());
      }
      return;
      ((TextView)localObject).setMovementMethod(null);
      break;
      label259:
      if (((TextView)localObject).getVisibility() == 8) {
        break label153;
      }
      ((TextView)localObject).setVisibility(8);
      break label153;
      label277:
      i = 8;
    }
  }
  
  public View onCreateView(ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = y.gt(this.mContext);
    paramViewGroup = localLayoutInflater.inflate(this.vdP, paramViewGroup, false);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(16908312);
    if (localViewGroup != null)
    {
      if (this.vdQ != 0) {
        localLayoutInflater.inflate(this.vdQ, localViewGroup);
      }
    }
    else {
      return paramViewGroup;
    }
    localViewGroup.setVisibility(8);
    return paramViewGroup;
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    if (this.IL != paramBoolean)
    {
      this.IL = paramBoolean;
      notifyDependencyChange(shouldDisableDependents());
      notifyChanged();
    }
  }
  
  public final void setKey(String paramString)
  {
    this.mKey = paramString;
    if (this.vdJ)
    {
      int i;
      if (!TextUtils.isEmpty(this.mKey)) {
        i = 1;
      }
      while (i == 0) {
        if (this.mKey == null)
        {
          throw new IllegalStateException("Preference does not have a key assigned.");
          i = 0;
        }
        else
        {
          this.vdJ = true;
        }
      }
    }
  }
  
  public final void setLayoutResource(int paramInt)
  {
    if (paramInt != this.vdP) {
      this.vdR = true;
    }
    this.vdP = paramInt;
  }
  
  public final void setSelectable(boolean paramBoolean)
  {
    if (this.vdI != paramBoolean)
    {
      this.vdI = paramBoolean;
      notifyChanged();
    }
  }
  
  public void setSummary(int paramInt)
  {
    setSummary(this.mContext.getString(paramInt));
  }
  
  public void setSummary(CharSequence paramCharSequence)
  {
    if (((paramCharSequence == null) && (this.mYY != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.mYY))))
    {
      this.mYY = paramCharSequence;
      notifyChanged();
    }
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(this.mContext.getString(paramInt));
    this.vdF = paramInt;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (((paramCharSequence == null) && (this.BM != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.BM))))
    {
      this.vdF = 0;
      this.BM = paramCharSequence;
      notifyChanged();
    }
  }
  
  public final void setWidgetLayoutResource(int paramInt)
  {
    if (paramInt != this.vdQ) {
      this.vdR = true;
    }
    this.vdQ = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    CharSequence localCharSequence = getTitle();
    if (!TextUtils.isEmpty(localCharSequence)) {
      localStringBuilder.append(localCharSequence).append(' ');
    }
    localCharSequence = getSummary();
    if (!TextUtils.isEmpty(localCharSequence)) {
      localStringBuilder.append(localCharSequence).append(' ');
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.setLength(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  public static abstract interface a
  {
    public abstract boolean a(Preference paramPreference, Object paramObject);
  }
  
  public static abstract interface b
  {
    public abstract boolean bsE();
  }
  
  public static abstract interface c
  {
    public abstract boolean bsU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.Preference
 * JD-Core Version:    0.7.0.1
 */