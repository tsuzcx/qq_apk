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
import com.tencent.mm.ah.a.c;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import java.util.List;

public class Preference
  implements Comparable<Preference>
{
  private CharSequence HbS;
  private ImageView Kpe;
  private int RyZ;
  private int WsA;
  private int WsB;
  private String WsC;
  boolean WsD;
  private boolean WsE;
  public boolean WsF;
  String WsG;
  private boolean WsH;
  private int WsI;
  private boolean WsJ;
  public boolean WsK;
  public boolean WsL;
  private boolean WsM;
  private boolean WsN;
  private int WsO;
  public int WsP;
  private boolean WsQ;
  private List<Preference> WsR;
  private a Wsx;
  public Preference.b Wsy;
  public Preference.c Wsz;
  private int btr;
  private CharSequence cZ;
  private Drawable eK;
  private int kV;
  public final Context mContext;
  private Object mDefaultValue;
  private boolean mEnabled;
  private Bundle mExtras;
  public String mKey;
  private int[] oG;
  public int tHk;
  
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
    this.oG = new int[] { a.c.title, a.c.summary };
    this.btr = 2147483647;
    this.RyZ = 0;
    this.mEnabled = true;
    this.WsD = true;
    this.WsF = true;
    this.WsH = true;
    this.tHk = -1;
    this.Kpe = null;
    this.WsI = 0;
    this.WsJ = false;
    this.WsK = false;
    this.WsL = false;
    this.WsM = false;
    this.WsN = true;
    this.WsO = a.h.mm_preference;
    this.WsQ = false;
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.Preference, paramInt, 0);
    paramInt = paramAttributeSet.getIndexCount();
    if (paramInt >= 0)
    {
      int i = paramAttributeSet.getIndex(paramInt);
      if (i == a.m.Preference_icon) {
        this.kV = paramAttributeSet.getResourceId(i, 0);
      }
      for (;;)
      {
        paramInt -= 1;
        break;
        if (i == a.m.Preference_iconColor)
        {
          this.RyZ = paramAttributeSet.getColor(i, 0);
        }
        else if (i == a.m.Preference_key)
        {
          this.mKey = paramAttributeSet.getString(i);
        }
        else if (i == a.m.Preference_title)
        {
          this.WsA = paramAttributeSet.getResourceId(i, 0);
          this.cZ = paramAttributeSet.getString(i);
          if (this.WsA != 0) {
            this.cZ = paramContext.getString(this.WsA);
          }
        }
        else if (i == a.m.Preference_summary)
        {
          this.HbS = paramAttributeSet.getString(i);
          this.WsB = paramAttributeSet.getResourceId(i, 0);
          if (this.WsB != 0) {
            this.HbS = paramContext.getString(this.WsB);
          }
        }
        else if (i == a.m.Preference_order)
        {
          this.btr = paramAttributeSet.getInt(i, this.btr);
        }
        else if (i == a.m.Preference_fragment)
        {
          this.WsC = paramAttributeSet.getString(i);
        }
        else if (i == a.m.Preference_layout)
        {
          this.WsO = paramAttributeSet.getResourceId(i, this.WsO);
        }
        else if (i == a.m.Preference_widgetLayout)
        {
          this.WsP = paramAttributeSet.getResourceId(i, this.WsP);
        }
        else if (i == a.m.Preference_enabled)
        {
          this.mEnabled = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == a.m.Preference_selectable)
        {
          this.WsD = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == a.m.Preference_persistent)
        {
          this.WsF = paramAttributeSet.getBoolean(i, this.WsF);
        }
        else if (i == a.m.Preference_dependency)
        {
          this.WsG = paramAttributeSet.getString(i);
        }
        else if (i == a.m.Preference_defaultValue)
        {
          this.mDefaultValue = null;
        }
        else if (i == a.m.Preference_shouldDisableView)
        {
          this.WsN = paramAttributeSet.getBoolean(i, this.WsN);
        }
      }
    }
    paramAttributeSet.recycle();
    if (!getClass().getName().startsWith("android.preference")) {
      this.WsQ = true;
    }
    AppMethodBeat.o(142632);
  }
  
  private void B(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(142637);
    paramView.setEnabled(paramBoolean);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = paramView.getChildCount() - 1;
      while (i >= 0)
      {
        B(paramView.getChildAt(i), paramBoolean);
        i -= 1;
      }
    }
    AppMethodBeat.o(142637);
  }
  
  private void FW(boolean paramBoolean)
  {
    AppMethodBeat.i(142649);
    List localList = this.WsR;
    if (localList == null)
    {
      AppMethodBeat.o(142649);
      return;
    }
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      ((Preference)localList.get(i)).FX(paramBoolean);
      i += 1;
    }
    AppMethodBeat.o(142649);
  }
  
  private void FX(boolean paramBoolean)
  {
    AppMethodBeat.i(142650);
    if (this.WsH == paramBoolean) {
      if (paramBoolean) {
        break label44;
      }
    }
    label44:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.WsH = paramBoolean;
      FW(hKZ());
      notifyChanged();
      AppMethodBeat.o(142650);
      return;
    }
  }
  
  private void hKW()
  {
    AppMethodBeat.i(142646);
    if (this.mKey == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Preference does not have a key assigned.");
      AppMethodBeat.o(142646);
      throw localIllegalStateException;
    }
    this.WsE = true;
    AppMethodBeat.o(142646);
  }
  
  private boolean hKX()
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
  
  private boolean hKZ()
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
  
  public final void FV(boolean paramBoolean)
  {
    AppMethodBeat.i(142644);
    if (this.WsD != paramBoolean)
    {
      this.WsD = paramBoolean;
      notifyChanged();
    }
    AppMethodBeat.o(142644);
  }
  
  public void a(a parama)
  {
    this.Wsx = parama;
  }
  
  public void aF(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142641);
    if (((paramCharSequence == null) && (this.HbS != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.HbS))))
    {
      this.HbS = paramCharSequence;
      notifyChanged();
    }
    AppMethodBeat.o(142641);
  }
  
  public void auI(int paramInt)
  {
    AppMethodBeat.i(142642);
    aF(this.mContext.getString(paramInt));
    AppMethodBeat.o(142642);
  }
  
  public final void auN(int paramInt)
  {
    if (paramInt != this.WsP) {
      this.WsQ = true;
    }
    this.WsP = paramInt;
  }
  
  public final void auO(int paramInt)
  {
    AppMethodBeat.i(142652);
    this.WsI = paramInt;
    if (this.Kpe != null) {
      this.Kpe.setVisibility(paramInt);
    }
    AppMethodBeat.o(142652);
  }
  
  public View c(View paramView, ViewGroup paramViewGroup)
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
  
  public final int cMV()
  {
    return this.kV;
  }
  
  public final boolean ej(Object paramObject)
  {
    AppMethodBeat.i(142648);
    if (this.Wsx == null)
    {
      AppMethodBeat.o(142648);
      return true;
    }
    boolean bool = this.Wsx.a(this, paramObject);
    AppMethodBeat.o(142648);
    return bool;
  }
  
  public CharSequence fqw()
  {
    return this.HbS;
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
  
  public final Drawable getIcon()
  {
    return this.eK;
  }
  
  public final String getKey()
  {
    return this.mKey;
  }
  
  public int getLayoutResource()
  {
    return this.WsO;
  }
  
  public CharSequence getTitle()
  {
    return this.cZ;
  }
  
  public final int hKV()
  {
    return this.RyZ;
  }
  
  public final void hKY()
  {
    this.WsF = false;
  }
  
  public final void hLa()
  {
    this.WsM = true;
  }
  
  public final boolean isEnabled()
  {
    return (this.mEnabled) && (this.WsH);
  }
  
  protected void notifyChanged() {}
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(142636);
    Object localObject1 = paramView.findViewById(a.g.content);
    if (localObject1 != null)
    {
      ((View)localObject1).setMinimumHeight((int)(this.mContext.getResources().getDimensionPixelSize(a.e.ListItemHeight) * a.kn(this.mContext)));
      Log.d("dancy test", "resource:%s, height:%s, scale:%s", new Object[] { this.mContext.getResources(), Integer.valueOf(this.mContext.getResources().getDimensionPixelSize(a.e.ListItemHeight)), Float.valueOf(a.kn(this.mContext)) });
    }
    localObject1 = (TextView)paramView.findViewById(16908310);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = getTitle();
      if ((localObject2 != null) && ((localObject2 instanceof Spannable)))
      {
        if (this.WsL) {
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
        if (TextUtils.isEmpty(fqw())) {
          break label476;
        }
        if (((TextView)localObject2).getVisibility() != 0) {
          ((TextView)localObject2).setVisibility(0);
        }
        if (!this.WsK) {
          break label464;
        }
        ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)localObject2).setClickable(true);
        ((TextView)localObject2).setText(fqw(), TextView.BufferType.SPANNABLE);
        label240:
        if (this.tHk != -1) {
          ((TextView)localObject2).setTextColor(this.tHk);
        }
        if (this.WsM) {
          ((TextView)localObject2).setSingleLine();
        }
        if ((localObject1 != null) && (this.WsJ)) {
          ((TextView)localObject2).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(164171);
              CharSequence localCharSequence = Preference.this.fqw();
              if (localCharSequence == null)
              {
                AppMethodBeat.o(164171);
                return;
              }
              int i = this.GJV.getMeasuredWidth() + this.WsS.getMeasuredWidth();
              if (i > 0)
              {
                int j = (int)this.WsS.getPaint().measureText(this.WsS.getText().toString());
                if ((int)this.GJV.getPaint().measureText(localCharSequence, 0, localCharSequence.length()) + j > i)
                {
                  localCharSequence = TextUtils.ellipsize(localCharSequence, this.GJV.getPaint(), i - j - 5, TextUtils.TruncateAt.END);
                  this.GJV.setText(localCharSequence);
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
        if ((this.kV != 0) || (this.eK != null))
        {
          if (this.eK == null) {
            this.eK = this.mContext.getResources().getDrawable(this.kV);
          }
          if (this.eK != null)
          {
            ((ImageView)localObject1).setImageDrawable(this.eK);
            if (this.RyZ != 0) {
              ((ImageView)localObject1).getDrawable().setColorFilter(this.RyZ, PorterDuff.Mode.SRC_ATOP);
            }
          }
        }
        if (this.eK == null) {
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
      this.Kpe = ((ImageView)paramView.findViewById(a.g.right_arrow));
      if (this.Kpe != null) {
        this.Kpe.setVisibility(this.WsI);
      }
      if (this.WsN) {
        B(paramView, isEnabled());
      }
      AppMethodBeat.o(142636);
      return;
      ((TextView)localObject1).setMovementMethod(null);
      break;
      ((TextView)localObject2).setText(fqw());
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
    LayoutInflater localLayoutInflater = ad.kS(this.mContext);
    paramViewGroup = localLayoutInflater.inflate(this.WsO, paramViewGroup, false);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(16908312);
    if (localViewGroup != null)
    {
      if (this.WsP == 0) {
        break label65;
      }
      localLayoutInflater.inflate(this.WsP, localViewGroup);
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
      FW(hKZ());
      notifyChanged();
    }
    AppMethodBeat.o(142643);
  }
  
  public void setIcon(int paramInt)
  {
    AppMethodBeat.i(199692);
    this.kV = paramInt;
    Drawable localDrawable = this.mContext.getResources().getDrawable(paramInt);
    if (((localDrawable == null) && (this.eK != null)) || ((localDrawable != null) && (this.eK != localDrawable)))
    {
      this.eK = localDrawable;
      notifyChanged();
    }
    AppMethodBeat.o(199692);
  }
  
  public final void setKey(String paramString)
  {
    AppMethodBeat.i(142645);
    this.mKey = paramString;
    if ((this.WsE) && (!hKX())) {
      hKW();
    }
    AppMethodBeat.o(142645);
  }
  
  public final void setLayoutResource(int paramInt)
  {
    if (paramInt != this.WsO) {
      this.WsQ = true;
    }
    this.WsO = paramInt;
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(142639);
    setTitle(this.mContext.getString(paramInt));
    this.WsA = paramInt;
    AppMethodBeat.o(142639);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142638);
    if (((paramCharSequence == null) && (this.cZ != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.cZ))))
    {
      this.WsA = 0;
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
    localCharSequence = fqw();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.Preference
 * JD-Core Version:    0.7.0.1
 */