package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a.a;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.HashMap;

public final class DialogPreference
  extends Preference
{
  private com.tencent.mm.ui.widget.b.c gwf;
  public Preference.a zqD;
  private final d zqF;
  DialogPreference.a zqG;
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107155);
    this.zqF = new d(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ChoicePreference, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(0, -1);
    if (paramInt != -1) {
      this.zqF.zqB = paramContext.getResources().getStringArray(paramInt);
    }
    this.zqF.zqC = paramAttributeSet.getTextArray(1);
    paramAttributeSet.recycle();
    this.zqF.dEH();
    AppMethodBeat.o(107155);
  }
  
  public final void a(Preference.a parama)
  {
    this.zqD = parama;
  }
  
  public final String getValue()
  {
    return this.zqF.value;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(107157);
    c localc = (c)this.zqF.values.get(this.zqF.value);
    if (localc != null) {
      setSummary(localc.text);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(107157);
  }
  
  public final void setValue(String paramString)
  {
    AppMethodBeat.i(107156);
    this.zqF.value = paramString;
    paramString = (c)this.zqF.values.get(paramString);
    if (paramString == null)
    {
      this.zqF.pvJ = -1;
      AppMethodBeat.o(107156);
      return;
    }
    this.zqF.pvJ = paramString.id;
    AppMethodBeat.o(107156);
  }
  
  protected final void showDialog()
  {
    AppMethodBeat.i(107158);
    ListViewInScrollView localListViewInScrollView = (ListViewInScrollView)View.inflate(this.mContext, 2130970172, null);
    localListViewInScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(107154);
        if (DialogPreference.a(DialogPreference.this) != null) {
          DialogPreference.a(DialogPreference.this).dismiss();
        }
        DialogPreference.this.setValue((String)DialogPreference.b(DialogPreference.this).zqC[paramAnonymousInt]);
        if (DialogPreference.c(DialogPreference.this) != null) {
          DialogPreference.c(DialogPreference.this).dEI();
        }
        if (DialogPreference.d(DialogPreference.this) != null) {
          DialogPreference.d(DialogPreference.this).a(DialogPreference.this, DialogPreference.this.getValue());
        }
        AppMethodBeat.o(107154);
      }
    });
    localListViewInScrollView.setAdapter(this.zqF);
    c.a locala = new c.a(this.mContext);
    locala.avm(getTitle().toString());
    locala.fu(localListViewInScrollView);
    this.gwf = locala.aLZ();
    this.gwf.show();
    h.a(this.mContext, this.gwf);
    AppMethodBeat.o(107158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.DialogPreference
 * JD-Core Version:    0.7.0.1
 */