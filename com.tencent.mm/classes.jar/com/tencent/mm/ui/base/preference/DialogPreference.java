package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;

public final class DialogPreference
  extends Preference
{
  private Preference.a WqI;
  private final d WqK;
  a WqL;
  private com.tencent.mm.ui.widget.a.d mUO;
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142532);
    this.WqK = new d(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.ChoicePreference, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.m.ChoicePreference_entries, -1);
    if (paramInt != -1) {
      this.WqK.WqG = paramContext.getResources().getStringArray(paramInt);
    }
    this.WqK.WqH = paramAttributeSet.getTextArray(a.m.ChoicePreference_entryValues);
    paramAttributeSet.recycle();
    this.WqK.hKE();
    AppMethodBeat.o(142532);
  }
  
  public final void a(Preference.a parama)
  {
    this.WqI = parama;
  }
  
  protected final void elK()
  {
    AppMethodBeat.i(142535);
    ListViewInScrollView localListViewInScrollView = (ListViewInScrollView)View.inflate(this.mContext, a.h.mm_list, null);
    localListViewInScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142531);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        a.c("com/tencent/mm/ui/base/preference/DialogPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        if (DialogPreference.a(DialogPreference.this) != null) {
          DialogPreference.a(DialogPreference.this).dismiss();
        }
        DialogPreference.this.setValue((String)DialogPreference.b(DialogPreference.this).WqH[paramAnonymousInt]);
        if (DialogPreference.c(DialogPreference.this) != null) {
          DialogPreference.c(DialogPreference.this).hKF();
        }
        if (DialogPreference.d(DialogPreference.this) != null) {
          DialogPreference.d(DialogPreference.this).a(DialogPreference.this, DialogPreference.this.getValue());
        }
        a.a(this, "com/tencent/mm/ui/base/preference/DialogPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(142531);
      }
    });
    localListViewInScrollView.setAdapter(this.WqK);
    d.a locala = new d.a(this.mContext);
    locala.bBc(getTitle().toString());
    locala.iI(localListViewInScrollView);
    this.mUO = locala.icu();
    this.mUO.show();
    h.a(this.mContext, this.mUO);
    AppMethodBeat.o(142535);
  }
  
  public final String getValue()
  {
    return this.WqK.value;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142534);
    c localc = (c)this.WqK.values.get(this.WqK.value);
    if (localc != null) {
      aF(localc.LV);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(142534);
  }
  
  public final void setValue(String paramString)
  {
    AppMethodBeat.i(142533);
    this.WqK.value = paramString;
    paramString = (c)this.WqK.values.get(paramString);
    if (paramString == null)
    {
      this.WqK.GUG = -1;
      AppMethodBeat.o(142533);
      return;
    }
    this.WqK.GUG = paramString.id;
    AppMethodBeat.o(142533);
  }
  
  public static abstract interface a
  {
    public abstract void hKF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.DialogPreference
 * JD-Core Version:    0.7.0.1
 */