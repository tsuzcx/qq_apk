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
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.c;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import java.util.List;

public class Preference
  implements Comparable<Preference>
{
  private CharSequence Naa;
  private ImageView QNl;
  private int Yvv;
  private Preference.a adZN;
  public Preference.b adZO;
  public Preference.c adZP;
  private int adZQ;
  private int adZR;
  private String adZS;
  boolean adZT;
  private boolean adZU;
  public boolean adZV;
  String adZW;
  private boolean adZX;
  private int adZY;
  private boolean adZZ;
  public boolean aeaa;
  public boolean aeab;
  public boolean aeac;
  private boolean aead;
  private int aeae;
  public int aeaf;
  private boolean aeag;
  private List<Preference> aeah;
  public boolean aeai;
  private CharSequence cZ;
  private int dmU;
  private Drawable fM;
  private int lR;
  public final Context mContext;
  private Object mDefaultValue;
  private boolean mEnabled;
  private Bundle mExtras;
  public String mKey;
  private int[] pD;
  public int wKL;
  
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
    this.pD = new int[] { a.c.title, a.c.summary };
    this.dmU = 2147483647;
    this.Yvv = 0;
    this.mEnabled = true;
    this.adZT = true;
    this.adZV = true;
    this.adZX = true;
    this.wKL = -1;
    this.QNl = null;
    this.adZY = 0;
    this.adZZ = false;
    this.aeaa = false;
    this.aeab = false;
    this.aeac = false;
    this.aead = true;
    this.aeae = a.h.mm_preference;
    this.aeag = false;
    this.aeai = false;
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.Preference, paramInt, 0);
    paramInt = paramAttributeSet.getIndexCount();
    if (paramInt >= 0)
    {
      int i = paramAttributeSet.getIndex(paramInt);
      if (i == a.m.Preference_icon) {
        this.lR = paramAttributeSet.getResourceId(i, 0);
      }
      for (;;)
      {
        paramInt -= 1;
        break;
        if (i == a.m.Preference_iconColor)
        {
          this.Yvv = paramAttributeSet.getColor(i, 0);
        }
        else if (i == a.m.Preference_key)
        {
          this.mKey = paramAttributeSet.getString(i);
        }
        else if (i == a.m.Preference_title)
        {
          this.adZQ = paramAttributeSet.getResourceId(i, 0);
          this.cZ = paramAttributeSet.getString(i);
          if (this.adZQ != 0) {
            this.cZ = paramContext.getString(this.adZQ);
          }
        }
        else if (i == a.m.Preference_summary)
        {
          this.Naa = paramAttributeSet.getString(i);
          this.adZR = paramAttributeSet.getResourceId(i, 0);
          if (this.adZR != 0) {
            this.Naa = paramContext.getString(this.adZR);
          }
        }
        else if (i == a.m.Preference_order)
        {
          this.dmU = paramAttributeSet.getInt(i, this.dmU);
        }
        else if (i == a.m.Preference_fragment)
        {
          this.adZS = paramAttributeSet.getString(i);
        }
        else if (i == a.m.Preference_layout)
        {
          this.aeae = paramAttributeSet.getResourceId(i, this.aeae);
        }
        else if (i == a.m.Preference_widgetLayout)
        {
          this.aeaf = paramAttributeSet.getResourceId(i, this.aeaf);
        }
        else if (i == a.m.Preference_enabled)
        {
          this.mEnabled = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == a.m.Preference_selectable)
        {
          this.adZT = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == a.m.Preference_persistent)
        {
          this.adZV = paramAttributeSet.getBoolean(i, this.adZV);
        }
        else if (i == a.m.Preference_dependency)
        {
          this.adZW = paramAttributeSet.getString(i);
        }
        else if (i == a.m.Preference_defaultValue)
        {
          this.mDefaultValue = null;
        }
        else if (i == a.m.Preference_shouldDisableView)
        {
          this.aead = paramAttributeSet.getBoolean(i, this.aead);
        }
      }
    }
    paramAttributeSet.recycle();
    if (!getClass().getName().startsWith("android.preference")) {
      this.aeag = true;
    }
    AppMethodBeat.o(142632);
  }
  
  private void H(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(142637);
    paramView.setEnabled(paramBoolean);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = paramView.getChildCount() - 1;
      while (i >= 0)
      {
        H(paramView.getChildAt(i), paramBoolean);
        i -= 1;
      }
    }
    AppMethodBeat.o(142637);
  }
  
  private void LI(boolean paramBoolean)
  {
    AppMethodBeat.i(142649);
    List localList = this.aeah;
    if (localList == null)
    {
      AppMethodBeat.o(142649);
      return;
    }
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      ((Preference)localList.get(i)).LJ(paramBoolean);
      i += 1;
    }
    AppMethodBeat.o(142649);
  }
  
  private void LJ(boolean paramBoolean)
  {
    AppMethodBeat.i(142650);
    if (this.adZX == paramBoolean) {
      if (paramBoolean) {
        break label44;
      }
    }
    label44:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.adZX = paramBoolean;
      LI(jnE());
      notifyChanged();
      AppMethodBeat.o(142650);
      return;
    }
  }
  
  private void jnC()
  {
    AppMethodBeat.i(142646);
    if (this.mKey == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Preference does not have a key assigned.");
      AppMethodBeat.o(142646);
      throw localIllegalStateException;
    }
    this.adZU = true;
    AppMethodBeat.o(142646);
  }
  
  private boolean jnD()
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
  
  private boolean jnE()
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
  
  public final void LH(boolean paramBoolean)
  {
    AppMethodBeat.i(142644);
    if (this.adZT != paramBoolean)
    {
      this.adZT = paramBoolean;
      notifyChanged();
    }
    AppMethodBeat.o(142644);
  }
  
  public void a(Preference.a parama)
  {
    this.adZN = parama;
  }
  
  public void aBk(int paramInt)
  {
    AppMethodBeat.i(142642);
    aS(this.mContext.getString(paramInt));
    AppMethodBeat.o(142642);
  }
  
  public final void aBp(int paramInt)
  {
    if (paramInt != this.aeaf) {
      this.aeag = true;
    }
    this.aeaf = paramInt;
  }
  
  public final void aBq(int paramInt)
  {
    AppMethodBeat.i(142652);
    this.adZY = paramInt;
    if (this.QNl != null) {
      this.QNl.setVisibility(paramInt);
    }
    AppMethodBeat.o(142652);
  }
  
  public void aS(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142641);
    if (((paramCharSequence == null) && (this.Naa != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.Naa))))
    {
      this.Naa = paramCharSequence;
      notifyChanged();
    }
    AppMethodBeat.o(142641);
  }
  
  public View b(View paramView, ViewGroup paramViewGroup)
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
  
  public final int dqA()
  {
    return this.lR;
  }
  
  public CharSequence gBR()
  {
    return this.Naa;
  }
  
  public final boolean gH(Object paramObject)
  {
    AppMethodBeat.i(142648);
    if (this.adZN == null)
    {
      AppMethodBeat.o(142648);
      return true;
    }
    boolean bool = this.adZN.a(this, paramObject);
    AppMethodBeat.o(142648);
    return bool;
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
  
  public final Drawable getIcon()
  {
    return this.fM;
  }
  
  public final int getIconColor()
  {
    return this.Yvv;
  }
  
  public int getLayoutResource()
  {
    return this.aeae;
  }
  
  public CharSequence getTitle()
  {
    return this.cZ;
  }
  
  public final boolean isEnabled()
  {
    return (this.mEnabled) && (this.adZX);
  }
  
  protected void notifyChanged() {}
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(142636);
    Object localObject1 = paramView.findViewById(a.g.content);
    if (localObject1 != null)
    {
      ((View)localObject1).setMinimumHeight((int)(this.mContext.getResources().getDimensionPixelSize(a.e.ListItemHeight) * a.mo(this.mContext)));
      Log.d("dancy test", "resource:%s, height:%s, scale:%s", new Object[] { this.mContext.getResources(), Integer.valueOf(this.mContext.getResources().getDimensionPixelSize(a.e.ListItemHeight)), Float.valueOf(a.mo(this.mContext)) });
      if (this.aeai) {
        ((View)localObject1).setPadding(0, ((View)localObject1).getPaddingTop(), ((View)localObject1).getPaddingRight(), ((View)localObject1).getPaddingBottom());
      }
    }
    localObject1 = (TextView)paramView.findViewById(16908310);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = getTitle();
      if ((localObject2 != null) && ((localObject2 instanceof Spannable)))
      {
        if (this.aeab) {
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
        if (TextUtils.isEmpty(gBR())) {
          break label500;
        }
        if (((TextView)localObject2).getVisibility() != 0) {
          ((TextView)localObject2).setVisibility(0);
        }
        if (!this.aeaa) {
          break label488;
        }
        ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)localObject2).setClickable(true);
        ((TextView)localObject2).setText(gBR(), TextView.BufferType.SPANNABLE);
        label264:
        if (this.wKL != -1) {
          ((TextView)localObject2).setTextColor(this.wKL);
        }
        if (this.aeac) {
          ((TextView)localObject2).setSingleLine();
        }
        if ((localObject1 != null) && (this.adZZ)) {
          ((TextView)localObject2).post(new Preference.1(this, (TextView)localObject2, (TextView)localObject1));
        }
      }
      label321:
      localObject1 = (ImageView)paramView.findViewById(16908294);
      if (localObject1 != null)
      {
        if ((this.lR != 0) || (this.fM != null))
        {
          if (this.fM == null) {
            this.fM = this.mContext.getResources().getDrawable(this.lR);
          }
          if (this.fM != null)
          {
            ((ImageView)localObject1).setImageDrawable(this.fM);
            if (this.Yvv != 0) {
              ((ImageView)localObject1).getDrawable().setColorFilter(this.Yvv, PorterDuff.Mode.SRC_ATOP);
            }
          }
        }
        if (this.fM == null) {
          break label520;
        }
      }
    }
    label520:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject1).setVisibility(i);
      this.QNl = ((ImageView)paramView.findViewById(a.g.right_arrow));
      if (this.QNl != null) {
        this.QNl.setVisibility(this.adZY);
      }
      if (this.aead) {
        H(paramView, isEnabled());
      }
      AppMethodBeat.o(142636);
      return;
      ((TextView)localObject1).setMovementMethod(null);
      break;
      label488:
      ((TextView)localObject2).setText(gBR());
      break label264;
      label500:
      if (((TextView)localObject2).getVisibility() == 8) {
        break label321;
      }
      ((TextView)localObject2).setVisibility(8);
      break label321;
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142635);
    LayoutInflater localLayoutInflater = af.mU(this.mContext);
    paramViewGroup = localLayoutInflater.inflate(this.aeae, paramViewGroup, false);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(16908312);
    if (localViewGroup != null)
    {
      if (this.aeaf == 0) {
        break label65;
      }
      localLayoutInflater.inflate(this.aeaf, localViewGroup);
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
      LI(jnE());
      notifyChanged();
    }
    AppMethodBeat.o(142643);
  }
  
  public void setIcon(int paramInt)
  {
    AppMethodBeat.i(251514);
    this.lR = paramInt;
    Drawable localDrawable = this.mContext.getResources().getDrawable(paramInt);
    if (((localDrawable == null) && (this.fM != null)) || ((localDrawable != null) && (this.fM != localDrawable)))
    {
      this.fM = localDrawable;
      notifyChanged();
    }
    AppMethodBeat.o(251514);
  }
  
  public final void setKey(String paramString)
  {
    AppMethodBeat.i(142645);
    this.mKey = paramString;
    if ((this.adZU) && (!jnD())) {
      jnC();
    }
    AppMethodBeat.o(142645);
  }
  
  public final void setLayoutResource(int paramInt)
  {
    if (paramInt != this.aeae) {
      this.aeag = true;
    }
    this.aeae = paramInt;
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(142639);
    setTitle(this.mContext.getString(paramInt));
    this.adZQ = paramInt;
    AppMethodBeat.o(142639);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142638);
    if (((paramCharSequence == null) && (this.cZ != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.cZ))))
    {
      this.adZQ = 0;
      this.cZ = paramCharSequence;
      notifyChanged();
    }
    AppMethodBeat.o(142638);
  }
  
  public String toString()
  {
    AppMethodBeat.i(142653);
    Object localObject = new StringBuilder();
    CharSequence localCharSequence = getTitle();
    if (!TextUtils.isEmpty(localCharSequence)) {
      ((StringBuilder)localObject).append(localCharSequence).append(' ');
    }
    localCharSequence = gBR();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.Preference
 * JD-Core Version:    0.7.0.1
 */