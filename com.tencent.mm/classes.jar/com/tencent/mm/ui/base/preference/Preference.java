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
import com.tencent.mm.ae.a.a;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import java.util.List;

public class Preference
  implements Comparable<Preference>
{
  private CharSequence Bic;
  private ImageView EbJ;
  private CharSequence Hn;
  int Kxl;
  private boolean OZA;
  public boolean OZB;
  public boolean OZC;
  private boolean OZD;
  private boolean OZE;
  private int OZF;
  public int OZG;
  private boolean OZH;
  private List<Preference> OZI;
  private a OZo;
  public b OZp;
  public c OZq;
  private int OZr;
  private int OZs;
  private String OZt;
  boolean OZu;
  private boolean OZv;
  public boolean OZw;
  String OZx;
  private boolean OZy;
  private int OZz;
  private int[] QA;
  protected Drawable Xw;
  protected int aeN;
  private int bJH;
  public final Context mContext;
  private Object mDefaultValue;
  private boolean mEnabled;
  private Bundle mExtras;
  public String mKey;
  public int qlp;
  
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
    this.QA = new int[] { 2130969676, 2130969580 };
    this.bJH = 2147483647;
    this.Kxl = 0;
    this.mEnabled = true;
    this.OZu = true;
    this.OZw = true;
    this.OZy = true;
    this.qlp = -1;
    this.EbJ = null;
    this.OZz = 0;
    this.OZA = false;
    this.OZB = false;
    this.OZC = false;
    this.OZD = false;
    this.OZE = true;
    this.OZF = 2131495538;
    this.OZH = false;
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.Preference, paramInt, 0);
    paramInt = paramAttributeSet.getIndexCount();
    if (paramInt >= 0)
    {
      int i = paramAttributeSet.getIndex(paramInt);
      if (i == 4) {
        this.aeN = paramAttributeSet.getResourceId(i, 0);
      }
      for (;;)
      {
        paramInt -= 1;
        break;
        if (i == 5)
        {
          this.Kxl = paramAttributeSet.getColor(i, 0);
        }
        else if (i == 6)
        {
          this.mKey = paramAttributeSet.getString(i);
        }
        else if (i == 13)
        {
          this.OZr = paramAttributeSet.getResourceId(i, 0);
          this.Hn = paramAttributeSet.getString(i);
          if (this.OZr != 0) {
            this.Hn = paramContext.getString(this.OZr);
          }
        }
        else if (i == 12)
        {
          this.Bic = paramAttributeSet.getString(i);
          this.OZs = paramAttributeSet.getResourceId(i, 0);
          if (this.OZs != 0) {
            this.Bic = paramContext.getString(this.OZs);
          }
        }
        else if (i == 8)
        {
          this.bJH = paramAttributeSet.getInt(i, this.bJH);
        }
        else if (i == 3)
        {
          this.OZt = paramAttributeSet.getString(i);
        }
        else if (i == 7)
        {
          this.OZF = paramAttributeSet.getResourceId(i, this.OZF);
        }
        else if (i == 14)
        {
          this.OZG = paramAttributeSet.getResourceId(i, this.OZG);
        }
        else if (i == 2)
        {
          this.mEnabled = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == 10)
        {
          this.OZu = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == 9)
        {
          this.OZw = paramAttributeSet.getBoolean(i, this.OZw);
        }
        else if (i == 1)
        {
          this.OZx = paramAttributeSet.getString(i);
        }
        else if (i == 0)
        {
          this.mDefaultValue = null;
        }
        else if (i == 11)
        {
          this.OZE = paramAttributeSet.getBoolean(i, this.OZE);
        }
      }
    }
    paramAttributeSet.recycle();
    if (!getClass().getName().startsWith("android.preference")) {
      this.OZH = true;
    }
    AppMethodBeat.o(142632);
  }
  
  private void BD(boolean paramBoolean)
  {
    AppMethodBeat.i(142650);
    if (this.OZy == paramBoolean) {
      if (paramBoolean) {
        break label42;
      }
    }
    label42:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.OZy = paramBoolean;
      notifyDependencyChange(shouldDisableDependents());
      notifyChanged();
      AppMethodBeat.o(142650);
      return;
    }
  }
  
  private void gLQ()
  {
    AppMethodBeat.i(142646);
    if (this.mKey == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Preference does not have a key assigned.");
      AppMethodBeat.o(142646);
      throw localIllegalStateException;
    }
    this.OZv = true;
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
    List localList = this.OZI;
    if (localList == null)
    {
      AppMethodBeat.o(142649);
      return;
    }
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      ((Preference)localList.get(i)).BD(paramBoolean);
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
  
  private void z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(142637);
    paramView.setEnabled(paramBoolean);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = paramView.getChildCount() - 1;
      while (i >= 0)
      {
        z(paramView.getChildAt(i), paramBoolean);
        i -= 1;
      }
    }
    AppMethodBeat.o(142637);
  }
  
  public void a(a parama)
  {
    this.OZo = parama;
  }
  
  public final void alO(int paramInt)
  {
    AppMethodBeat.i(142652);
    this.OZz = paramInt;
    if (this.EbJ != null) {
      this.EbJ.setVisibility(paramInt);
    }
    AppMethodBeat.o(142652);
  }
  
  public final boolean callChangeListener(Object paramObject)
  {
    AppMethodBeat.i(142648);
    if (this.OZo == null)
    {
      AppMethodBeat.o(142648);
      return true;
    }
    boolean bool = this.OZo.a(this, paramObject);
    AppMethodBeat.o(142648);
    return bool;
  }
  
  public final void gLR()
  {
    this.OZw = false;
  }
  
  public final void gLS()
  {
    this.OZD = true;
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
    return this.OZF;
  }
  
  public CharSequence getSummary()
  {
    return this.Bic;
  }
  
  public CharSequence getTitle()
  {
    return this.Hn;
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
  
  public void gr()
  {
    AppMethodBeat.i(142640);
    this.aeN = 2131689522;
    Drawable localDrawable = this.mContext.getResources().getDrawable(2131689522);
    if (((localDrawable == null) && (this.Xw != null)) || ((localDrawable != null) && (this.Xw != localDrawable)))
    {
      this.Xw = localDrawable;
      notifyChanged();
    }
    AppMethodBeat.o(142640);
  }
  
  public final boolean isEnabled()
  {
    return (this.mEnabled) && (this.OZy);
  }
  
  protected void notifyChanged() {}
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(142636);
    Object localObject1 = paramView.findViewById(2131299180);
    if (localObject1 != null)
    {
      ((View)localObject1).setMinimumHeight((int)(this.mContext.getResources().getDimensionPixelSize(2131165506) * a.jj(this.mContext)));
      Log.d("dancy test", "resource:%s, height:%s, scale:%s", new Object[] { this.mContext.getResources(), Integer.valueOf(this.mContext.getResources().getDimensionPixelSize(2131165506)), Float.valueOf(a.jj(this.mContext)) });
    }
    localObject1 = (TextView)paramView.findViewById(16908310);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = getTitle();
      if ((localObject2 != null) && ((localObject2 instanceof Spannable)))
      {
        if (this.OZC) {
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
          break label476;
        }
        if (((TextView)localObject2).getVisibility() != 0) {
          ((TextView)localObject2).setVisibility(0);
        }
        if (!this.OZB) {
          break label464;
        }
        ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)localObject2).setClickable(true);
        ((TextView)localObject2).setText(getSummary(), TextView.BufferType.SPANNABLE);
        label240:
        if (this.qlp != -1) {
          ((TextView)localObject2).setTextColor(this.qlp);
        }
        if (this.OZD) {
          ((TextView)localObject2).setSingleLine();
        }
        if ((localObject1 != null) && (this.OZA)) {
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
              int i = this.AQK.getMeasuredWidth() + this.OZJ.getMeasuredWidth();
              if (i > 0)
              {
                int j = (int)this.OZJ.getPaint().measureText(this.OZJ.getText().toString());
                if ((int)this.AQK.getPaint().measureText(localCharSequence, 0, localCharSequence.length()) + j > i)
                {
                  localCharSequence = TextUtils.ellipsize(localCharSequence, this.AQK.getPaint(), i - j - 5, TextUtils.TruncateAt.END);
                  this.AQK.setText(localCharSequence);
                }
              }
              AppMethodBeat.o(164171);
            }
          });
        }
      }
      label297:
      localObject1 = (ImageView)paramView.findViewById(16908294);
      if (localObject1 != null)
      {
        if ((this.aeN != 0) || (this.Xw != null))
        {
          if (this.Xw == null) {
            this.Xw = this.mContext.getResources().getDrawable(this.aeN);
          }
          if (this.Xw != null)
          {
            ((ImageView)localObject1).setImageDrawable(this.Xw);
            if (this.Kxl != 0) {
              ((ImageView)localObject1).getDrawable().setColorFilter(this.Kxl, PorterDuff.Mode.SRC_ATOP);
            }
          }
        }
        if (this.Xw == null) {
          break label496;
        }
      }
    }
    label464:
    label476:
    label496:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject1).setVisibility(i);
      this.EbJ = ((ImageView)paramView.findViewById(2131307076));
      if (this.EbJ != null) {
        this.EbJ.setVisibility(this.OZz);
      }
      if (this.OZE) {
        z(paramView, isEnabled());
      }
      AppMethodBeat.o(142636);
      return;
      ((TextView)localObject1).setMovementMethod(null);
      break;
      ((TextView)localObject2).setText(getSummary());
      break label240;
      if (((TextView)localObject2).getVisibility() == 8) {
        break label297;
      }
      ((TextView)localObject2).setVisibility(8);
      break label297;
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142635);
    LayoutInflater localLayoutInflater = aa.jQ(this.mContext);
    paramViewGroup = localLayoutInflater.inflate(this.OZF, paramViewGroup, false);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(16908312);
    if (localViewGroup != null)
    {
      if (this.OZG == 0) {
        break label65;
      }
      localLayoutInflater.inflate(this.OZG, localViewGroup);
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
    if ((this.OZv) && (!hasKey())) {
      gLQ();
    }
    AppMethodBeat.o(142645);
  }
  
  public final void setLayoutResource(int paramInt)
  {
    if (paramInt != this.OZF) {
      this.OZH = true;
    }
    this.OZF = paramInt;
  }
  
  public final void setSelectable(boolean paramBoolean)
  {
    AppMethodBeat.i(142644);
    if (this.OZu != paramBoolean)
    {
      this.OZu = paramBoolean;
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
    if (((paramCharSequence == null) && (this.Bic != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.Bic))))
    {
      this.Bic = paramCharSequence;
      notifyChanged();
    }
    AppMethodBeat.o(142641);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(142639);
    setTitle(this.mContext.getString(paramInt));
    this.OZr = paramInt;
    AppMethodBeat.o(142639);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142638);
    if (((paramCharSequence == null) && (this.Hn != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.Hn))))
    {
      this.OZr = 0;
      this.Hn = paramCharSequence;
      notifyChanged();
    }
    AppMethodBeat.o(142638);
  }
  
  public final void setWidgetLayoutResource(int paramInt)
  {
    if (paramInt != this.OZG) {
      this.OZH = true;
    }
    this.OZG = paramInt;
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
    public abstract boolean a(Preference paramPreference);
  }
  
  public static abstract interface c
  {
    public abstract boolean eFh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.Preference
 * JD-Core Version:    0.7.0.1
 */