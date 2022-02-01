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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.z;
import java.util.List;

public class Preference
  implements Comparable<Preference>
{
  int FlJ;
  private CharSequence Hd;
  private boolean JtA;
  public boolean JtB;
  String JtC;
  private boolean JtD;
  private int JtE;
  private boolean JtF;
  public boolean JtG;
  public boolean JtH;
  private boolean JtI;
  private boolean JtJ;
  private int JtK;
  public int JtL;
  private boolean JtM;
  private List<Preference> JtN;
  private a Jtt;
  public b Jtu;
  public c Jtv;
  private int Jtw;
  private int Jtx;
  private String Jty;
  boolean Jtz;
  private int[] Qo;
  protected Drawable Xj;
  protected int aeA;
  private int bJr;
  public final Context mContext;
  private Object mDefaultValue;
  private boolean mEnabled;
  private Bundle mExtras;
  public String mKey;
  public int oPT;
  private CharSequence wUo;
  private ImageView zCz;
  
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
    this.FlJ = 0;
    this.mEnabled = true;
    this.Jtz = true;
    this.JtB = true;
    this.JtD = true;
    this.oPT = -1;
    this.zCz = null;
    this.JtE = 0;
    this.JtF = false;
    this.JtG = false;
    this.JtH = false;
    this.JtI = false;
    this.JtJ = true;
    this.JtK = 2131494804;
    this.JtM = false;
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
          this.FlJ = paramAttributeSet.getColor(i, 0);
        }
        else if (i == 6)
        {
          this.mKey = paramAttributeSet.getString(i);
        }
        else if (i == 13)
        {
          this.Jtw = paramAttributeSet.getResourceId(i, 0);
          this.Hd = paramAttributeSet.getString(i);
          if (this.Jtw != 0) {
            this.Hd = paramContext.getString(this.Jtw);
          }
        }
        else if (i == 12)
        {
          this.wUo = paramAttributeSet.getString(i);
          this.Jtx = paramAttributeSet.getResourceId(i, 0);
          if (this.Jtx != 0) {
            this.wUo = paramContext.getString(this.Jtx);
          }
        }
        else if (i == 8)
        {
          this.bJr = paramAttributeSet.getInt(i, this.bJr);
        }
        else if (i == 3)
        {
          this.Jty = paramAttributeSet.getString(i);
        }
        else if (i == 7)
        {
          this.JtK = paramAttributeSet.getResourceId(i, this.JtK);
        }
        else if (i == 14)
        {
          this.JtL = paramAttributeSet.getResourceId(i, this.JtL);
        }
        else if (i == 2)
        {
          this.mEnabled = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == 10)
        {
          this.Jtz = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == 9)
        {
          this.JtB = paramAttributeSet.getBoolean(i, this.JtB);
        }
        else if (i == 1)
        {
          this.JtC = paramAttributeSet.getString(i);
        }
        else if (i == 0)
        {
          this.mDefaultValue = null;
        }
        else if (i == 11)
        {
          this.JtJ = paramAttributeSet.getBoolean(i, this.JtJ);
        }
      }
    }
    paramAttributeSet.recycle();
    if (!getClass().getName().startsWith("android.preference")) {
      this.JtM = true;
    }
    AppMethodBeat.o(142632);
  }
  
  private void fzH()
  {
    AppMethodBeat.i(142646);
    if (this.mKey == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Preference does not have a key assigned.");
      AppMethodBeat.o(142646);
      throw localIllegalStateException;
    }
    this.JtA = true;
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
    List localList = this.JtN;
    if (localList == null)
    {
      AppMethodBeat.o(142649);
      return;
    }
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      ((Preference)localList.get(i)).xH(paramBoolean);
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
  
  private void xH(boolean paramBoolean)
  {
    AppMethodBeat.i(142650);
    if (this.JtD == paramBoolean) {
      if (paramBoolean) {
        break label44;
      }
    }
    label44:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.JtD = paramBoolean;
      notifyDependencyChange(shouldDisableDependents());
      notifyChanged();
      AppMethodBeat.o(142650);
      return;
    }
  }
  
  public void a(a parama)
  {
    this.Jtt = parama;
  }
  
  public final void acw(int paramInt)
  {
    AppMethodBeat.i(142652);
    this.JtE = paramInt;
    if (this.zCz != null) {
      this.zCz.setVisibility(paramInt);
    }
    AppMethodBeat.o(142652);
  }
  
  protected final boolean callChangeListener(Object paramObject)
  {
    AppMethodBeat.i(142648);
    if (this.Jtt == null)
    {
      AppMethodBeat.o(142648);
      return true;
    }
    boolean bool = this.Jtt.a(this, paramObject);
    AppMethodBeat.o(142648);
    return bool;
  }
  
  public final void fzI()
  {
    this.JtB = false;
  }
  
  public final void fzJ()
  {
    this.JtI = true;
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
    return this.JtK;
  }
  
  public CharSequence getSummary()
  {
    return this.wUo;
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
    return (this.mEnabled) && (this.JtD);
  }
  
  protected void notifyChanged() {}
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(142636);
    Object localObject1 = paramView.findViewById(2131298739);
    if (localObject1 != null)
    {
      ((View)localObject1).setMinimumHeight((int)(this.mContext.getResources().getDimensionPixelSize(2131165488) * a.il(this.mContext)));
      ad.d("dancy test", "resource:%s, height:%s, scale:%s", new Object[] { this.mContext.getResources(), Integer.valueOf(this.mContext.getResources().getDimensionPixelSize(2131165488)), Float.valueOf(a.il(this.mContext)) });
    }
    localObject1 = (TextView)paramView.findViewById(16908310);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = getTitle();
      if ((localObject2 != null) && ((localObject2 instanceof Spannable)))
      {
        if (this.JtH) {
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
        if (!this.JtG) {
          break label464;
        }
        ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)localObject2).setClickable(true);
        ((TextView)localObject2).setText(getSummary(), TextView.BufferType.SPANNABLE);
        label240:
        if (this.oPT != -1) {
          ((TextView)localObject2).setTextColor(this.oPT);
        }
        if (this.JtI) {
          ((TextView)localObject2).setSingleLine();
        }
        if ((localObject1 != null) && (this.JtF)) {
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
              int i = this.wFd.getMeasuredWidth() + this.JtO.getMeasuredWidth();
              if (i > 0)
              {
                int j = (int)this.JtO.getPaint().measureText(this.JtO.getText().toString());
                if ((int)this.wFd.getPaint().measureText(localCharSequence, 0, localCharSequence.length()) + j > i)
                {
                  localCharSequence = TextUtils.ellipsize(localCharSequence, this.wFd.getPaint(), i - j - 5, TextUtils.TruncateAt.END);
                  this.wFd.setText(localCharSequence);
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
            if (this.FlJ != 0) {
              ((ImageView)localObject1).getDrawable().setColorFilter(this.FlJ, PorterDuff.Mode.SRC_ATOP);
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
      this.zCz = ((ImageView)paramView.findViewById(2131304172));
      if (this.zCz != null) {
        this.zCz.setVisibility(this.JtE);
      }
      if (this.JtJ) {
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
    LayoutInflater localLayoutInflater = z.jO(this.mContext);
    paramViewGroup = localLayoutInflater.inflate(this.JtK, paramViewGroup, false);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(16908312);
    if (localViewGroup != null)
    {
      if (this.JtL == 0) {
        break label65;
      }
      localLayoutInflater.inflate(this.JtL, localViewGroup);
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
    if ((this.JtA) && (!hasKey())) {
      fzH();
    }
    AppMethodBeat.o(142645);
  }
  
  public final void setLayoutResource(int paramInt)
  {
    if (paramInt != this.JtK) {
      this.JtM = true;
    }
    this.JtK = paramInt;
  }
  
  public final void setSelectable(boolean paramBoolean)
  {
    AppMethodBeat.i(142644);
    if (this.Jtz != paramBoolean)
    {
      this.Jtz = paramBoolean;
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
    if (((paramCharSequence == null) && (this.wUo != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.wUo))))
    {
      this.wUo = paramCharSequence;
      notifyChanged();
    }
    AppMethodBeat.o(142641);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(142639);
    setTitle(this.mContext.getString(paramInt));
    this.Jtw = paramInt;
    AppMethodBeat.o(142639);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142638);
    if (((paramCharSequence == null) && (this.Hd != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.Hd))))
    {
      this.Jtw = 0;
      this.Hd = paramCharSequence;
      notifyChanged();
    }
    AppMethodBeat.o(142638);
  }
  
  public final void setWidgetLayoutResource(int paramInt)
  {
    if (paramInt != this.JtL) {
      this.JtM = true;
    }
    this.JtL = paramInt;
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
    public abstract boolean dAh();
  }
  
  public static abstract interface c
  {
    public abstract boolean dBu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.Preference
 * JD-Core Version:    0.7.0.1
 */