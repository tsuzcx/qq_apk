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
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;

public final class DialogPreference
  extends Preference
{
  private Preference.a HDT;
  private final d HDV;
  a HDW;
  private com.tencent.mm.ui.widget.a.d iJj;
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142532);
    this.HDV = new d(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ChoicePreference, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(0, -1);
    if (paramInt != -1) {
      this.HDV.HDR = paramContext.getResources().getStringArray(paramInt);
    }
    this.HDV.HDS = paramAttributeSet.getTextArray(1);
    paramAttributeSet.recycle();
    this.HDV.fji();
    AppMethodBeat.o(142532);
  }
  
  public final void a(Preference.a parama)
  {
    this.HDT = parama;
  }
  
  public final String getValue()
  {
    return this.HDV.value;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142534);
    c localc = (c)this.HDV.values.get(this.HDV.value);
    if (localc != null) {
      setSummary(localc.text);
    }
    super.onBindView(paramView);
    AppMethodBeat.o(142534);
  }
  
  public final void setValue(String paramString)
  {
    AppMethodBeat.i(142533);
    this.HDV.value = paramString;
    paramString = (c)this.HDV.values.get(paramString);
    if (paramString == null)
    {
      this.HDV.vGl = -1;
      AppMethodBeat.o(142533);
      return;
    }
    this.HDV.vGl = paramString.id;
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
        if (DialogPreference.a(DialogPreference.this) != null) {
          DialogPreference.a(DialogPreference.this).dismiss();
        }
        DialogPreference.this.setValue((String)DialogPreference.b(DialogPreference.this).HDS[paramAnonymousInt]);
        if (DialogPreference.c(DialogPreference.this) != null) {
          DialogPreference.c(DialogPreference.this).fjj();
        }
        if (DialogPreference.d(DialogPreference.this) != null) {
          DialogPreference.d(DialogPreference.this).a(DialogPreference.this, DialogPreference.this.getValue());
        }
        AppMethodBeat.o(142531);
      }
    });
    localListViewInScrollView.setAdapter(this.HDV);
    d.a locala = new d.a(this.mContext);
    locala.aRH(getTitle().toString());
    locala.gH(localListViewInScrollView);
    this.iJj = locala.fvp();
    this.iJj.show();
    h.a(this.mContext, this.iJj);
    AppMethodBeat.o(142535);
  }
  
  public static abstract interface a
  {
    public abstract void fjj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.DialogPreference
 * JD-Core Version:    0.7.0.1
 */