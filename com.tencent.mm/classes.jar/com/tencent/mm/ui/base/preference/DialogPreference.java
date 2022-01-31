package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.m;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c.a;
import java.util.HashMap;

public final class DialogPreference
  extends Preference
{
  private com.tencent.mm.ui.widget.a.c few;
  public Preference.a vcc;
  private final d vce;
  DialogPreference.a vcf;
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.vce = new d(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.ChoicePreference, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.m.ChoicePreference_entries, -1);
    if (paramInt != -1) {
      this.vce.vca = paramContext.getResources().getStringArray(paramInt);
    }
    this.vce.vcb = paramAttributeSet.getTextArray(a.m.ChoicePreference_entryValues);
    paramAttributeSet.recycle();
    this.vce.cBs();
  }
  
  public final void a(Preference.a parama)
  {
    this.vcc = parama;
  }
  
  public final String getValue()
  {
    return this.vce.value;
  }
  
  public final void onBindView(View paramView)
  {
    c localc = (c)this.vce.values.get(this.vce.value);
    if (localc != null) {
      setSummary(localc.text);
    }
    super.onBindView(paramView);
  }
  
  public final void setValue(String paramString)
  {
    this.vce.value = paramString;
    paramString = (c)this.vce.values.get(paramString);
    if (paramString == null)
    {
      this.vce.mTD = -1;
      return;
    }
    this.vce.mTD = paramString.id;
  }
  
  protected final void showDialog()
  {
    ListViewInScrollView localListViewInScrollView = (ListViewInScrollView)View.inflate(this.mContext, a.h.mm_list, null);
    localListViewInScrollView.setOnItemClickListener(new DialogPreference.1(this));
    localListViewInScrollView.setAdapter(this.vce);
    c.a locala = new c.a(this.mContext);
    locala.aez(getTitle().toString());
    locala.ei(localListViewInScrollView);
    this.few = locala.aoP();
    this.few.show();
    h.a(this.mContext, this.few);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.DialogPreference
 * JD-Core Version:    0.7.0.1
 */