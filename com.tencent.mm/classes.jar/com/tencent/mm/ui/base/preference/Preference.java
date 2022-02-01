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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.z;
import java.util.List;

public class Preference
  implements Comparable<Preference>
{
  int FEh;
  private CharSequence Hd;
  public int JOA;
  private boolean JOB;
  private List<Preference> JOC;
  private a JOi;
  public b JOj;
  public c JOk;
  private int JOl;
  private int JOm;
  private String JOn;
  boolean JOo;
  private boolean JOp;
  public boolean JOq;
  String JOr;
  private boolean JOs;
  private int JOt;
  private boolean JOu;
  public boolean JOv;
  public boolean JOw;
  private boolean JOx;
  private boolean JOy;
  private int JOz;
  private int[] Qo;
  protected Drawable Xj;
  protected int aeA;
  private int bJr;
  public final Context mContext;
  private Object mDefaultValue;
  private boolean mEnabled;
  private Bundle mExtras;
  public String mKey;
  public int oWv;
  private CharSequence xkf;
  private ImageView zTB;
  
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
    this.Qo = new int[] { 2130969590, 2130969495 };
    this.bJr = 2147483647;
    this.FEh = 0;
    this.mEnabled = true;
    this.JOo = true;
    this.JOq = true;
    this.JOs = true;
    this.oWv = -1;
    this.zTB = null;
    this.JOt = 0;
    this.JOu = false;
    this.JOv = false;
    this.JOw = false;
    this.JOx = false;
    this.JOy = true;
    this.JOz = 2131494804;
    this.JOB = false;
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.Preference, paramInt, 0);
    paramInt = paramAttributeSet.getIndexCount();
    if (paramInt >= 0)
    {
      int i = paramAttributeSet.getIndex(paramInt);
      if (i == 4) {
        this.aeA = paramAttributeSet.getResourceId(i, 0);
      }
      for (;;)
      {
        paramInt -= 1;
        break;
        if (i == 5)
        {
          this.FEh = paramAttributeSet.getColor(i, 0);
        }
        else if (i == 6)
        {
          this.mKey = paramAttributeSet.getString(i);
        }
        else if (i == 13)
        {
          this.JOl = paramAttributeSet.getResourceId(i, 0);
          this.Hd = paramAttributeSet.getString(i);
          if (this.JOl != 0) {
            this.Hd = paramContext.getString(this.JOl);
          }
        }
        else if (i == 12)
        {
          this.xkf = paramAttributeSet.getString(i);
          this.JOm = paramAttributeSet.getResourceId(i, 0);
          if (this.JOm != 0) {
            this.xkf = paramContext.getString(this.JOm);
          }
        }
        else if (i == 8)
        {
          this.bJr = paramAttributeSet.getInt(i, this.bJr);
        }
        else if (i == 3)
        {
          this.JOn = paramAttributeSet.getString(i);
        }
        else if (i == 7)
        {
          this.JOz = paramAttributeSet.getResourceId(i, this.JOz);
        }
        else if (i == 14)
        {
          this.JOA = paramAttributeSet.getResourceId(i, this.JOA);
        }
        else if (i == 2)
        {
          this.mEnabled = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == 10)
        {
          this.JOo = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == 9)
        {
          this.JOq = paramAttributeSet.getBoolean(i, this.JOq);
        }
        else if (i == 1)
        {
          this.JOr = paramAttributeSet.getString(i);
        }
        else if (i == 0)
        {
          this.mDefaultValue = null;
        }
        else if (i == 11)
        {
          this.JOy = paramAttributeSet.getBoolean(i, this.JOy);
        }
      }
    }
    paramAttributeSet.recycle();
    if (!getClass().getName().startsWith("android.preference")) {
      this.JOB = true;
    }
    AppMethodBeat.o(142632);
  }
  
  private void fDJ()
  {
    AppMethodBeat.i(142646);
    if (this.mKey == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Preference does not have a key assigned.");
      AppMethodBeat.o(142646);
      throw localIllegalStateException;
    }
    this.JOp = true;
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
    List localList = this.JOC;
    if (localList == null)
    {
      AppMethodBeat.o(142649);
      return;
    }
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      ((Preference)localList.get(i)).xO(paramBoolean);
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
  
  private void x(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(142637);
    paramView.setEnabled(paramBoolean);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = paramView.getChildCount() - 1;
      while (i >= 0)
      {
        x(paramView.getChildAt(i), paramBoolean);
        i -= 1;
      }
    }
    AppMethodBeat.o(142637);
  }
  
  private void xO(boolean paramBoolean)
  {
    AppMethodBeat.i(142650);
    if (this.JOs == paramBoolean) {
      if (paramBoolean) {
        break label44;
      }
    }
    label44:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.JOs = paramBoolean;
      notifyDependencyChange(shouldDisableDependents());
      notifyChanged();
      AppMethodBeat.o(142650);
      return;
    }
  }
  
  public void a(a parama)
  {
    this.JOi = parama;
  }
  
  public final void ade(int paramInt)
  {
    AppMethodBeat.i(142652);
    this.JOt = paramInt;
    if (this.zTB != null) {
      this.zTB.setVisibility(paramInt);
    }
    AppMethodBeat.o(142652);
  }
  
  public final boolean callChangeListener(Object paramObject)
  {
    AppMethodBeat.i(142648);
    if (this.JOi == null)
    {
      AppMethodBeat.o(142648);
      return true;
    }
    boolean bool = this.JOi.a(this, paramObject);
    AppMethodBeat.o(142648);
    return bool;
  }
  
  public final void fDK()
  {
    this.JOq = false;
  }
  
  public final void fDL()
  {
    this.JOx = true;
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
    return this.JOz;
  }
  
  public CharSequence getSummary()
  {
    return this.xkf;
  }
  
  public CharSequence getTitle()
  {
    return this.Hd;
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
  
  public void gk()
  {
    AppMethodBeat.i(142640);
    this.aeA = 2131689519;
    Drawable localDrawable = this.mContext.getResources().getDrawable(2131689519);
    if (((localDrawable == null) && (this.Xj != null)) || ((localDrawable != null) && (this.Xj != localDrawable)))
    {
      this.Xj = localDrawable;
      notifyChanged();
    }
    AppMethodBeat.o(142640);
  }
  
  public final boolean isEnabled()
  {
    return (this.mEnabled) && (this.JOs);
  }
  
  protected void notifyChanged() {}
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(142636);
    Object localObject1 = paramView.findViewById(2131298739);
    if (localObject1 != null)
    {
      ((View)localObject1).setMinimumHeight((int)(this.mContext.getResources().getDimensionPixelSize(2131165488) * a.iq(this.mContext)));
      ae.d("dancy test", "resource:%s, height:%s, scale:%s", new Object[] { this.mContext.getResources(), Integer.valueOf(this.mContext.getResources().getDimensionPixelSize(2131165488)), Float.valueOf(a.iq(this.mContext)) });
    }
    localObject1 = (TextView)paramView.findViewById(16908310);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = getTitle();
      if ((localObject2 != null) && ((localObject2 instanceof Spannable)))
      {
        if (this.JOw) {
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
        if (!this.JOv) {
          break label464;
        }
        ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)localObject2).setClickable(true);
        ((TextView)localObject2).setText(getSummary(), TextView.BufferType.SPANNABLE);
        label240:
        if (this.oWv != -1) {
          ((TextView)localObject2).setTextColor(this.oWv);
        }
        if (this.JOx) {
          ((TextView)localObject2).setSingleLine();
        }
        if ((localObject1 != null) && (this.JOu)) {
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
              int i = this.wUO.getMeasuredWidth() + this.JOD.getMeasuredWidth();
              if (i > 0)
              {
                int j = (int)this.JOD.getPaint().measureText(this.JOD.getText().toString());
                if ((int)this.wUO.getPaint().measureText(localCharSequence, 0, localCharSequence.length()) + j > i)
                {
                  localCharSequence = TextUtils.ellipsize(localCharSequence, this.wUO.getPaint(), i - j - 5, TextUtils.TruncateAt.END);
                  this.wUO.setText(localCharSequence);
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
        if ((this.aeA != 0) || (this.Xj != null))
        {
          if (this.Xj == null) {
            this.Xj = this.mContext.getResources().getDrawable(this.aeA);
          }
          if (this.Xj != null)
          {
            ((ImageView)localObject1).setImageDrawable(this.Xj);
            if (this.FEh != 0) {
              ((ImageView)localObject1).getDrawable().setColorFilter(this.FEh, PorterDuff.Mode.SRC_ATOP);
            }
          }
        }
        if (this.Xj == null) {
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
      this.zTB = ((ImageView)paramView.findViewById(2131304172));
      if (this.zTB != null) {
        this.zTB.setVisibility(this.JOt);
      }
      if (this.JOy) {
        x(paramView, isEnabled());
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
    LayoutInflater localLayoutInflater = z.jV(this.mContext);
    paramViewGroup = localLayoutInflater.inflate(this.JOz, paramViewGroup, false);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(16908312);
    if (localViewGroup != null)
    {
      if (this.JOA == 0) {
        break label65;
      }
      localLayoutInflater.inflate(this.JOA, localViewGroup);
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
    if ((this.JOp) && (!hasKey())) {
      fDJ();
    }
    AppMethodBeat.o(142645);
  }
  
  public final void setLayoutResource(int paramInt)
  {
    if (paramInt != this.JOz) {
      this.JOB = true;
    }
    this.JOz = paramInt;
  }
  
  public final void setSelectable(boolean paramBoolean)
  {
    AppMethodBeat.i(142644);
    if (this.JOo != paramBoolean)
    {
      this.JOo = paramBoolean;
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
    if (((paramCharSequence == null) && (this.xkf != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.xkf))))
    {
      this.xkf = paramCharSequence;
      notifyChanged();
    }
    AppMethodBeat.o(142641);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(142639);
    setTitle(this.mContext.getString(paramInt));
    this.JOl = paramInt;
    AppMethodBeat.o(142639);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142638);
    if (((paramCharSequence == null) && (this.Hd != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.Hd))))
    {
      this.JOl = 0;
      this.Hd = paramCharSequence;
      notifyChanged();
    }
    AppMethodBeat.o(142638);
  }
  
  public final void setWidgetLayoutResource(int paramInt)
  {
    if (paramInt != this.JOA) {
      this.JOB = true;
    }
    this.JOA = paramInt;
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
    public abstract boolean dDy();
  }
  
  public static abstract interface c
  {
    public abstract boolean dEL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.Preference
 * JD-Core Version:    0.7.0.1
 */