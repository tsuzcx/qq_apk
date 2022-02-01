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
  private final d JMA;
  a JMB;
  private Preference.a JMy;
  private com.tencent.mm.ui.widget.a.d jfl;
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142532);
    this.JMA = new d(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ChoicePreference, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(0, -1);
    if (paramInt != -1) {
      this.JMA.JMw = paramContext.getResources().getStringArray(paramInt);
    }
    this.JMA.JMx = paramAttributeSet.getTextArray(1);
    paramAttributeSet.recycle();
    this.JMA.fDz();
    AppMethodBeat.o(142532);
  }
  
  public final void a(Preference.a parama)
  {
    this.JMy = parama;
  }
  
  public final String getValue()
  {
    return this.JMA.value;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142534);
    c localc = (c)this.JMA.values.get(this.JMA.value);
    if (localc != null) {
      setSummary(localc.text);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(142534);
  }
  
  public final void setValue(String paramString)
  {
    AppMethodBeat.i(142533);
    this.JMA.value = paramString;
    paramString = (c)this.JMA.values.get(paramString);
    if (paramString == null)
    {
      this.JMA.xdf = -1;
      AppMethodBeat.o(142533);
      return;
    }
    this.JMA.xdf = paramString.id;
    AppMethodBeat.o(142533);
  }
  
  protected final void showDialog()
  {
    AppMethodBeat.i(142535);
    ListViewInScrollView localListViewInScrollView = (ListViewInScrollView)View.inflate(this.mContext, 2131494797, null);
    localListViewInScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142531);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        a.b("com/tencent/mm/ui/base/preference/DialogPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        if (DialogPreference.a(DialogPreference.this) != null) {
          DialogPreference.a(DialogPreference.this).dismiss();
        }
        DialogPreference.this.setValue((String)DialogPreference.b(DialogPreference.this).JMx[paramAnonymousInt]);
        if (DialogPreference.c(DialogPreference.this) != null) {
          DialogPreference.c(DialogPreference.this).fDA();
        }
        if (DialogPreference.d(DialogPreference.this) != null) {
          DialogPreference.d(DialogPreference.this).a(DialogPreference.this, DialogPreference.this.getValue());
        }
        a.a(this, "com/tencent/mm/ui/base/preference/DialogPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(142531);
      }
    });
    localListViewInScrollView.setAdapter(this.JMA);
    d.a locala = new d.a(this.mContext);
    locala.aZh(getTitle().toString());
    locala.hd(localListViewInScrollView);
    this.jfl = locala.fQv();
    this.jfl.show();
    h.a(this.mContext, this.jfl);
    AppMethodBeat.o(142535);
  }
  
  public static abstract interface a
  {
    public abstract void fDA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.DialogPreference
 * JD-Core Version:    0.7.0.1
 */