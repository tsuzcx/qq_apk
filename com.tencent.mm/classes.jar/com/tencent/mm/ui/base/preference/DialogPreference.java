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
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.HashMap;

public final class DialogPreference
  extends Preference
{
  private Preference.a adXX;
  private final d adXZ;
  a adYa;
  private e pRv;
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142532);
    this.adXZ = new d(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.ChoicePreference, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.m.ChoicePreference_entries, -1);
    if (paramInt != -1) {
      this.adXZ.adXV = paramContext.getResources().getStringArray(paramInt);
    }
    this.adXZ.adXW = paramAttributeSet.getTextArray(a.m.ChoicePreference_entryValues);
    paramAttributeSet.recycle();
    this.adXZ.jni();
    AppMethodBeat.o(142532);
  }
  
  public final void a(Preference.a parama)
  {
    this.adXX = parama;
  }
  
  protected final void fpM()
  {
    AppMethodBeat.i(142535);
    ListViewInScrollView localListViewInScrollView = (ListViewInScrollView)View.inflate(this.mContext, a.h.mm_list, null);
    localListViewInScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142531);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/ui/base/preference/DialogPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        if (DialogPreference.a(DialogPreference.this) != null) {
          DialogPreference.a(DialogPreference.this).dismiss();
        }
        DialogPreference.this.setValue((String)DialogPreference.b(DialogPreference.this).adXW[paramAnonymousInt]);
        if (DialogPreference.c(DialogPreference.this) != null) {
          DialogPreference.c(DialogPreference.this).jnj();
        }
        if (DialogPreference.d(DialogPreference.this) != null) {
          DialogPreference.d(DialogPreference.this).a(DialogPreference.this, DialogPreference.this.getValue());
        }
        a.a(this, "com/tencent/mm/ui/base/preference/DialogPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(142531);
      }
    });
    localListViewInScrollView.setAdapter(this.adXZ);
    e.a locala = new e.a(this.mContext);
    locala.bDv(getTitle().toString());
    locala.md(localListViewInScrollView);
    this.pRv = locala.jHH();
    this.pRv.show();
    k.a(this.mContext, this.pRv);
    AppMethodBeat.o(142535);
  }
  
  public final String getValue()
  {
    return this.adXZ.value;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142534);
    c localc = (c)this.adXZ.values.get(this.adXZ.value);
    if (localc != null) {
      aS(localc.bba);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(142534);
  }
  
  public final void setValue(String paramString)
  {
    AppMethodBeat.i(142533);
    this.adXZ.value = paramString;
    paramString = (c)this.adXZ.values.get(paramString);
    if (paramString == null)
    {
      this.adXZ.MSi = -1;
      AppMethodBeat.o(142533);
      return;
    }
    this.adXZ.MSi = paramString.id;
    AppMethodBeat.o(142533);
  }
  
  public static abstract interface a
  {
    public abstract void jnj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.DialogPreference
 * JD-Core Version:    0.7.0.1
 */