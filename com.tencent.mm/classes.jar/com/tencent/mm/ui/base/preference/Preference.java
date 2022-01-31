package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a.a;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.w;
import java.util.List;

public class Preference
  implements Comparable<Preference>
{
  private CharSequence Cv;
  private int[] GC;
  protected int UM;
  private int bdv;
  public int kCA;
  protected Drawable la;
  public final Context mContext;
  private Object mDefaultValue;
  private boolean mEnabled;
  private Bundle mExtras;
  public String mKey;
  private CharSequence pCy;
  private ImageView ruQ;
  private a zsb;
  public b zsc;
  public Preference.c zsd;
  private int zse;
  private int zsf;
  int zsg;
  private String zsh;
  boolean zsi;
  private boolean zsj;
  public boolean zsk;
  String zsl;
  private boolean zsm;
  private int zsn;
  private boolean zso;
  private int zsp;
  public int zsq;
  private boolean zsr;
  private List<Preference> zss;
  
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
    AppMethodBeat.i(107255);
    this.GC = new int[] { 2130772054, 2130772051 };
    this.bdv = 2147483647;
    this.zsg = 0;
    this.mEnabled = true;
    this.zsi = true;
    this.zsk = true;
    this.zsm = true;
    this.kCA = -1;
    this.ruQ = null;
    this.zsn = 0;
    this.zso = true;
    this.zsp = 2130970179;
    this.zsr = false;
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.Preference, paramInt, 0);
    paramInt = paramAttributeSet.getIndexCount();
    if (paramInt >= 0)
    {
      int i = paramAttributeSet.getIndex(paramInt);
      if (i == 5) {
        this.UM = paramAttributeSet.getResourceId(i, 0);
      }
      for (;;)
      {
        paramInt -= 1;
        break;
        if (i == 6)
        {
          this.zsg = paramAttributeSet.getColor(i, 0);
        }
        else if (i == 7)
        {
          this.mKey = paramAttributeSet.getString(i);
        }
        else if (i == 4)
        {
          this.zse = paramAttributeSet.getResourceId(i, 0);
          this.Cv = paramAttributeSet.getString(i);
          if (this.zse != 0) {
            this.Cv = paramContext.getString(this.zse);
          }
        }
        else if (i == 3)
        {
          this.pCy = paramAttributeSet.getString(i);
          this.zsf = paramAttributeSet.getResourceId(i, 0);
          if (this.zsf != 0) {
            this.pCy = paramContext.getString(this.zsf);
          }
        }
        else if (i == 8)
        {
          this.bdv = paramAttributeSet.getInt(i, this.bdv);
        }
        else if (i == 1)
        {
          this.zsh = paramAttributeSet.getString(i);
        }
        else if (i == 14)
        {
          this.zsp = paramAttributeSet.getResourceId(i, this.zsp);
        }
        else if (i == 9)
        {
          this.zsq = paramAttributeSet.getResourceId(i, this.zsq);
        }
        else if (i == 0)
        {
          this.mEnabled = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == 10)
        {
          this.zsi = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == 2)
        {
          this.zsk = paramAttributeSet.getBoolean(i, this.zsk);
        }
        else if (i == 11)
        {
          this.zsl = paramAttributeSet.getString(i);
        }
        else if (i == 12)
        {
          this.mDefaultValue = null;
        }
        else if (i == 13)
        {
          this.zso = paramAttributeSet.getBoolean(i, this.zso);
        }
      }
    }
    paramAttributeSet.recycle();
    if (!getClass().getName().startsWith("android.preference")) {
      this.zsr = true;
    }
    AppMethodBeat.o(107255);
  }
  
  private void dEQ()
  {
    AppMethodBeat.i(107269);
    if (this.mKey == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Preference does not have a key assigned.");
      AppMethodBeat.o(107269);
      throw localIllegalStateException;
    }
    this.zsj = true;
    AppMethodBeat.o(107269);
  }
  
  private boolean hasKey()
  {
    AppMethodBeat.i(107270);
    if (!TextUtils.isEmpty(this.mKey))
    {
      AppMethodBeat.o(107270);
      return true;
    }
    AppMethodBeat.o(107270);
    return false;
  }
  
  private void notifyDependencyChange(boolean paramBoolean)
  {
    AppMethodBeat.i(107272);
    List localList = this.zss;
    if (localList == null)
    {
      AppMethodBeat.o(107272);
      return;
    }
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      ((Preference)localList.get(i)).qK(paramBoolean);
      i += 1;
    }
    AppMethodBeat.o(107272);
  }
  
  private void qK(boolean paramBoolean)
  {
    AppMethodBeat.i(107273);
    if (this.zsm == paramBoolean) {
      if (paramBoolean) {
        break label42;
      }
    }
    label42:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.zsm = paramBoolean;
      notifyDependencyChange(shouldDisableDependents());
      notifyChanged();
      AppMethodBeat.o(107273);
      return;
    }
  }
  
  private boolean shouldDisableDependents()
  {
    AppMethodBeat.i(107274);
    if (!isEnabled())
    {
      AppMethodBeat.o(107274);
      return true;
    }
    AppMethodBeat.o(107274);
    return false;
  }
  
  private void x(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(107260);
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
    AppMethodBeat.o(107260);
  }
  
  public final void OW(int paramInt)
  {
    AppMethodBeat.i(107275);
    this.zsn = paramInt;
    if (this.ruQ != null) {
      this.ruQ.setVisibility(paramInt);
    }
    AppMethodBeat.o(107275);
  }
  
  public void a(a parama)
  {
    this.zsb = parama;
  }
  
  protected final boolean callChangeListener(Object paramObject)
  {
    AppMethodBeat.i(107271);
    if (this.zsb == null)
    {
      AppMethodBeat.o(107271);
      return true;
    }
    boolean bool = this.zsb.a(this, paramObject);
    AppMethodBeat.o(107271);
    return bool;
  }
  
  public void es()
  {
    AppMethodBeat.i(107263);
    this.UM = 2131230766;
    Drawable localDrawable = this.mContext.getResources().getDrawable(2131230766);
    if (((localDrawable == null) && (this.la != null)) || ((localDrawable != null) && (this.la != localDrawable)))
    {
      this.la = localDrawable;
      notifyChanged();
    }
    AppMethodBeat.o(107263);
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final Bundle getExtras()
  {
    AppMethodBeat.i(107256);
    if (this.mExtras == null) {
      this.mExtras = new Bundle();
    }
    Bundle localBundle = this.mExtras;
    AppMethodBeat.o(107256);
    return localBundle;
  }
  
  public int getLayoutResource()
  {
    return this.zsp;
  }
  
  public CharSequence getSummary()
  {
    return this.pCy;
  }
  
  public CharSequence getTitle()
  {
    return this.Cv;
  }
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107257);
    View localView = paramView;
    if (paramView == null) {
      localView = onCreateView(paramViewGroup);
    }
    onBindView(localView);
    AppMethodBeat.o(107257);
    return localView;
  }
  
  public final boolean isEnabled()
  {
    return (this.mEnabled) && (this.zsm);
  }
  
  protected void notifyChanged() {}
  
  protected void onBindView(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(107259);
    Object localObject = paramView.findViewById(2131820946);
    if (localObject != null)
    {
      ((View)localObject).setMinimumHeight((int)(this.mContext.getResources().getDimensionPixelSize(2131427780) * a.gs(this.mContext)));
      ab.d("dancy test", "resource:%s, height:%s, scale:%s", new Object[] { this.mContext.getResources(), Integer.valueOf(this.mContext.getResources().getDimensionPixelSize(2131427780)), Float.valueOf(a.gs(this.mContext)) });
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
          break label382;
        }
        if (((TextView)localObject).getVisibility() != 0) {
          ((TextView)localObject).setVisibility(0);
        }
        ((TextView)localObject).setText(getSummary());
        if (this.kCA != -1) {
          ((TextView)localObject).setTextColor(this.kCA);
        }
      }
      label217:
      localObject = (ImageView)paramView.findViewById(16908294);
      if (localObject != null)
      {
        if ((this.UM != 0) || (this.la != null))
        {
          if (this.la == null) {
            this.la = this.mContext.getResources().getDrawable(this.UM);
          }
          if (this.la != null)
          {
            ((ImageView)localObject).setImageDrawable(this.la);
            if (this.zsg != 0) {
              ((ImageView)localObject).getDrawable().setColorFilter(this.zsg, PorterDuff.Mode.SRC_ATOP);
            }
          }
        }
        if (this.la == null) {
          break label400;
        }
      }
    }
    for (;;)
    {
      ((ImageView)localObject).setVisibility(i);
      this.ruQ = ((ImageView)paramView.findViewById(2131821555));
      if (this.ruQ != null) {
        this.ruQ.setVisibility(this.zsn);
      }
      if (this.zso) {
        x(paramView, isEnabled());
      }
      AppMethodBeat.o(107259);
      return;
      ((TextView)localObject).setMovementMethod(null);
      break;
      label382:
      if (((TextView)localObject).getVisibility() == 8) {
        break label217;
      }
      ((TextView)localObject).setVisibility(8);
      break label217;
      label400:
      i = 8;
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107258);
    LayoutInflater localLayoutInflater = w.hM(this.mContext);
    paramViewGroup = localLayoutInflater.inflate(this.zsp, paramViewGroup, false);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(16908312);
    if (localViewGroup != null)
    {
      if (this.zsq == 0) {
        break label65;
      }
      localLayoutInflater.inflate(this.zsq, localViewGroup);
    }
    for (;;)
    {
      AppMethodBeat.o(107258);
      return paramViewGroup;
      label65:
      localViewGroup.setVisibility(8);
    }
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(107266);
    if (this.mEnabled != paramBoolean)
    {
      this.mEnabled = paramBoolean;
      notifyDependencyChange(shouldDisableDependents());
      notifyChanged();
    }
    AppMethodBeat.o(107266);
  }
  
  public final void setKey(String paramString)
  {
    AppMethodBeat.i(107268);
    this.mKey = paramString;
    if ((this.zsj) && (!hasKey())) {
      dEQ();
    }
    AppMethodBeat.o(107268);
  }
  
  public final void setLayoutResource(int paramInt)
  {
    if (paramInt != this.zsp) {
      this.zsr = true;
    }
    this.zsp = paramInt;
  }
  
  public final void setSelectable(boolean paramBoolean)
  {
    AppMethodBeat.i(107267);
    if (this.zsi != paramBoolean)
    {
      this.zsi = paramBoolean;
      notifyChanged();
    }
    AppMethodBeat.o(107267);
  }
  
  public void setSummary(int paramInt)
  {
    AppMethodBeat.i(107265);
    setSummary(this.mContext.getString(paramInt));
    AppMethodBeat.o(107265);
  }
  
  public void setSummary(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(107264);
    if (((paramCharSequence == null) && (this.pCy != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.pCy))))
    {
      this.pCy = paramCharSequence;
      notifyChanged();
    }
    AppMethodBeat.o(107264);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(107262);
    setTitle(this.mContext.getString(paramInt));
    this.zse = paramInt;
    AppMethodBeat.o(107262);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(107261);
    if (((paramCharSequence == null) && (this.Cv != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.Cv))))
    {
      this.zse = 0;
      this.Cv = paramCharSequence;
      notifyChanged();
    }
    AppMethodBeat.o(107261);
  }
  
  public final void setWidgetLayoutResource(int paramInt)
  {
    if (paramInt != this.zsq) {
      this.zsr = true;
    }
    this.zsq = paramInt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(107276);
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
    AppMethodBeat.o(107276);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(Preference paramPreference, Object paramObject);
  }
  
  public static abstract interface b
  {
    public abstract boolean cbH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.Preference
 * JD-Core Version:    0.7.0.1
 */