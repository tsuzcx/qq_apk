package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;

public final class DialogPreference
  extends Preference
{
  private final d OXA;
  a OXB;
  private Preference.a OXy;
  private com.tencent.mm.ui.widget.a.d kdo;
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142532);
    this.OXA = new d(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ChoicePreference, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(0, -1);
    if (paramInt != -1) {
      this.OXA.OXw = paramContext.getResources().getStringArray(paramInt);
    }
    this.OXA.OXx = paramAttributeSet.getTextArray(1);
    paramAttributeSet.recycle();
    this.OXA.gLC();
    AppMethodBeat.o(142532);
  }
  
  public final void a(Preference.a parama)
  {
    this.OXy = parama;
  }
  
  public final String getValue()
  {
    return this.OXA.value;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142534);
    c localc = (c)this.OXA.values.get(this.OXA.value);
    if (localc != null) {
      setSummary(localc.text);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(142534);
  }
  
  public final void setValue(String paramString)
  {
    AppMethodBeat.i(142533);
    this.OXA.value = paramString;
    paramString = (c)this.OXA.values.get(paramString);
    if (paramString == null)
    {
      this.OXA.BaH = -1;
      AppMethodBeat.o(142533);
      return;
    }
    this.OXA.BaH = paramString.id;
    AppMethodBeat.o(142533);
  }
  
  protected final void showDialog()
  {
    AppMethodBeat.i(142535);
    ListViewInScrollView localListViewInScrollView = (ListViewInScrollView)View.inflate(this.mContext, 2131495531, null);
    localListViewInScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142531);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/ui/base/preference/DialogPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (DialogPreference.a(DialogPreference.this) != null) {
          DialogPreference.a(DialogPreference.this).dismiss();
        }
        DialogPreference.this.setValue((String)DialogPreference.b(DialogPreference.this).OXx[paramAnonymousInt]);
        if (DialogPreference.c(DialogPreference.this) != null) {
          DialogPreference.c(DialogPreference.this).gLD();
        }
        if (DialogPreference.d(DialogPreference.this) != null) {
          DialogPreference.d(DialogPreference.this).a(DialogPreference.this, DialogPreference.this.getValue());
        }
        a.a(this, "com/tencent/mm/ui/base/preference/DialogPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(142531);
      }
    });
    localListViewInScrollView.setAdapter(this.OXA);
    d.a locala = new d.a(this.mContext);
    locala.bon(getTitle().toString());
    locala.hs(localListViewInScrollView);
    this.kdo = locala.hbn();
    this.kdo.show();
    h.a(this.mContext, this.kdo);
    AppMethodBeat.o(142535);
  }
  
  public static abstract interface a
  {
    public abstract void gLD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.DialogPreference
 * JD-Core Version:    0.7.0.1
 */