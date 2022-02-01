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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.z;
import java.util.List;

public class Preference
  implements Comparable<Preference>
{
  int DGC;
  private CharSequence Fm;
  private a HFC;
  public b HFD;
  public c HFE;
  private int HFF;
  private int HFG;
  private String HFH;
  boolean HFI;
  private boolean HFJ;
  public boolean HFK;
  String HFL;
  private boolean HFM;
  private int HFN;
  private boolean HFO;
  public boolean HFP;
  public boolean HFQ;
  private boolean HFR;
  private boolean HFS;
  private int HFT;
  public int HFU;
  private boolean HFV;
  private List<Preference> HFW;
  private int[] Ox;
  protected Drawable Vu;
  protected int acJ;
  private int bzd;
  public final Context mContext;
  private Object mDefaultValue;
  private boolean mEnabled;
  private Bundle mExtras;
  public String mKey;
  public int omy;
  private CharSequence vNf;
  private ImageView ylK;
  
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
    this.Ox = new int[] { 2130969590, 2130969495 };
    this.bzd = 2147483647;
    this.DGC = 0;
    this.mEnabled = true;
    this.HFI = true;
    this.HFK = true;
    this.HFM = true;
    this.omy = -1;
    this.ylK = null;
    this.HFN = 0;
    this.HFO = false;
    this.HFP = false;
    this.HFQ = false;
    this.HFR = false;
    this.HFS = true;
    this.HFT = 2131494804;
    this.HFV = false;
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.Preference, paramInt, 0);
    paramInt = paramAttributeSet.getIndexCount();
    if (paramInt >= 0)
    {
      int i = paramAttributeSet.getIndex(paramInt);
      if (i == 4) {
        this.acJ = paramAttributeSet.getResourceId(i, 0);
      }
      for (;;)
      {
        paramInt -= 1;
        break;
        if (i == 5)
        {
          this.DGC = paramAttributeSet.getColor(i, 0);
        }
        else if (i == 6)
        {
          this.mKey = paramAttributeSet.getString(i);
        }
        else if (i == 13)
        {
          this.HFF = paramAttributeSet.getResourceId(i, 0);
          this.Fm = paramAttributeSet.getString(i);
          if (this.HFF != 0) {
            this.Fm = paramContext.getString(this.HFF);
          }
        }
        else if (i == 12)
        {
          this.vNf = paramAttributeSet.getString(i);
          this.HFG = paramAttributeSet.getResourceId(i, 0);
          if (this.HFG != 0) {
            this.vNf = paramContext.getString(this.HFG);
          }
        }
        else if (i == 8)
        {
          this.bzd = paramAttributeSet.getInt(i, this.bzd);
        }
        else if (i == 3)
        {
          this.HFH = paramAttributeSet.getString(i);
        }
        else if (i == 7)
        {
          this.HFT = paramAttributeSet.getResourceId(i, this.HFT);
        }
        else if (i == 14)
        {
          this.HFU = paramAttributeSet.getResourceId(i, this.HFU);
        }
        else if (i == 2)
        {
          this.mEnabled = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == 10)
        {
          this.HFI = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == 9)
        {
          this.HFK = paramAttributeSet.getBoolean(i, this.HFK);
        }
        else if (i == 1)
        {
          this.HFL = paramAttributeSet.getString(i);
        }
        else if (i == 0)
        {
          this.mDefaultValue = null;
        }
        else if (i == 11)
        {
          this.HFS = paramAttributeSet.getBoolean(i, this.HFS);
        }
      }
    }
    paramAttributeSet.recycle();
    if (!getClass().getName().startsWith("android.preference")) {
      this.HFV = true;
    }
    AppMethodBeat.o(142632);
  }
  
  private void fjs()
  {
    AppMethodBeat.i(142646);
    if (this.mKey == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Preference does not have a key assigned.");
      AppMethodBeat.o(142646);
      throw localIllegalStateException;
    }
    this.HFJ = true;
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
    List localList = this.HFW;
    if (localList == null)
    {
      AppMethodBeat.o(142649);
      return;
    }
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      ((Preference)localList.get(i)).wW(paramBoolean);
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
  
  private void wW(boolean paramBoolean)
  {
    AppMethodBeat.i(142650);
    if (this.HFM == paramBoolean) {
      if (paramBoolean) {
        break label44;
      }
    }
    label44:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.HFM = paramBoolean;
      notifyDependencyChange(shouldDisableDependents());
      notifyChanged();
      AppMethodBeat.o(142650);
      return;
    }
  }
  
  public void a(a parama)
  {
    this.HFC = parama;
  }
  
  public final void aam(int paramInt)
  {
    AppMethodBeat.i(142652);
    this.HFN = paramInt;
    if (this.ylK != null) {
      this.ylK.setVisibility(paramInt);
    }
    AppMethodBeat.o(142652);
  }
  
  protected final boolean callChangeListener(Object paramObject)
  {
    AppMethodBeat.i(142648);
    if (this.HFC == null)
    {
      AppMethodBeat.o(142648);
      return true;
    }
    boolean bool = this.HFC.a(this, paramObject);
    AppMethodBeat.o(142648);
    return bool;
  }
  
  public void fS()
  {
    AppMethodBeat.i(142640);
    this.acJ = 2131689519;
    Drawable localDrawable = this.mContext.getResources().getDrawable(2131689519);
    if (((localDrawable == null) && (this.Vu != null)) || ((localDrawable != null) && (this.Vu != localDrawable)))
    {
      this.Vu = localDrawable;
      notifyChanged();
    }
    AppMethodBeat.o(142640);
  }
  
  public final void fjt()
  {
    this.HFK = false;
  }
  
  public final void fju()
  {
    this.HFR = true;
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
    return this.HFT;
  }
  
  public CharSequence getSummary()
  {
    return this.vNf;
  }
  
  public CharSequence getTitle()
  {
    return this.Fm;
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
    return (this.mEnabled) && (this.HFM);
  }
  
  protected void notifyChanged() {}
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(142636);
    Object localObject1 = paramView.findViewById(2131298739);
    if (localObject1 != null)
    {
      ((View)localObject1).setMinimumHeight((int)(this.mContext.getResources().getDimensionPixelSize(2131165488) * a.ic(this.mContext)));
      ac.d("dancy test", "resource:%s, height:%s, scale:%s", new Object[] { this.mContext.getResources(), Integer.valueOf(this.mContext.getResources().getDimensionPixelSize(2131165488)), Float.valueOf(a.ic(this.mContext)) });
    }
    localObject1 = (TextView)paramView.findViewById(16908310);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = getTitle();
      if ((localObject2 != null) && ((localObject2 instanceof Spannable)))
      {
        if (this.HFQ) {
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
        if (!this.HFP) {
          break label464;
        }
        ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)localObject2).setClickable(true);
        ((TextView)localObject2).setText(getSummary(), TextView.BufferType.SPANNABLE);
        label240:
        if (this.omy != -1) {
          ((TextView)localObject2).setTextColor(this.omy);
        }
        if (this.HFR) {
          ((TextView)localObject2).setSingleLine();
        }
        if ((localObject1 != null) && (this.HFO)) {
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
              int i = this.vzJ.getMeasuredWidth() + this.HFX.getMeasuredWidth();
              if (i > 0)
              {
                int j = (int)this.HFX.getPaint().measureText(this.HFX.getText().toString());
                if ((int)this.vzJ.getPaint().measureText(localCharSequence, 0, localCharSequence.length()) + j > i)
                {
                  localCharSequence = TextUtils.ellipsize(localCharSequence, this.vzJ.getPaint(), i - j - 5, TextUtils.TruncateAt.END);
                  this.vzJ.setText(localCharSequence);
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
        if ((this.acJ != 0) || (this.Vu != null))
        {
          if (this.Vu == null) {
            this.Vu = this.mContext.getResources().getDrawable(this.acJ);
          }
          if (this.Vu != null)
          {
            ((ImageView)localObject1).setImageDrawable(this.Vu);
            if (this.DGC != 0) {
              ((ImageView)localObject1).getDrawable().setColorFilter(this.DGC, PorterDuff.Mode.SRC_ATOP);
            }
          }
        }
        if (this.Vu == null) {
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
      this.ylK = ((ImageView)paramView.findViewById(2131304172));
      if (this.ylK != null) {
        this.ylK.setVisibility(this.HFN);
      }
      if (this.HFS) {
        w(paramView, isEnabled());
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
    LayoutInflater localLayoutInflater = z.jD(this.mContext);
    paramViewGroup = localLayoutInflater.inflate(this.HFT, paramViewGroup, false);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(16908312);
    if (localViewGroup != null)
    {
      if (this.HFU == 0) {
        break label65;
      }
      localLayoutInflater.inflate(this.HFU, localViewGroup);
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
    if ((this.HFJ) && (!hasKey())) {
      fjs();
    }
    AppMethodBeat.o(142645);
  }
  
  public final void setLayoutResource(int paramInt)
  {
    if (paramInt != this.HFT) {
      this.HFV = true;
    }
    this.HFT = paramInt;
  }
  
  public final void setSelectable(boolean paramBoolean)
  {
    AppMethodBeat.i(142644);
    if (this.HFI != paramBoolean)
    {
      this.HFI = paramBoolean;
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
    if (((paramCharSequence == null) && (this.vNf != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.vNf))))
    {
      this.vNf = paramCharSequence;
      notifyChanged();
    }
    AppMethodBeat.o(142641);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(142639);
    setTitle(this.mContext.getString(paramInt));
    this.HFF = paramInt;
    AppMethodBeat.o(142639);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142638);
    if (((paramCharSequence == null) && (this.Fm != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.Fm))))
    {
      this.HFF = 0;
      this.Fm = paramCharSequence;
      notifyChanged();
    }
    AppMethodBeat.o(142638);
  }
  
  public final void setWidgetLayoutResource(int paramInt)
  {
    if (paramInt != this.HFU) {
      this.HFV = true;
    }
    this.HFU = paramInt;
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
    public abstract boolean dpE();
  }
  
  public static abstract interface c
  {
    public abstract boolean dqS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.Preference
 * JD-Core Version:    0.7.0.1
 */