package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.m;
import java.util.HashMap;
import junit.framework.Assert;

public final class ChoicePreference
  extends Preference
{
  private int mTD = -1;
  String value;
  private final HashMap<CharSequence, b> values = new HashMap();
  private RadioGroup vbZ;
  private CharSequence[] vca;
  private CharSequence[] vcb;
  public Preference.a vcc;
  
  public ChoicePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChoicePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.ChoicePreference, paramInt, 0);
    this.vca = paramContext.getTextArray(a.m.ChoicePreference_entries);
    this.vcb = paramContext.getTextArray(a.m.ChoicePreference_entryValues);
    paramContext.recycle();
    cBs();
  }
  
  private void cBs()
  {
    int i = 0;
    if (this.vca == null) {
      this.vca = new CharSequence[0];
    }
    if (this.vcb == null) {
      this.vcb = new CharSequence[0];
    }
    if (this.vca.length == this.vcb.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("entries count different", bool);
      this.values.clear();
      while (i < this.vcb.length)
      {
        b localb = new b(this.vca[i], 1048576 + i);
        this.values.put(this.vcb[i], localb);
        i += 1;
      }
    }
  }
  
  public final void a(Preference.a parama)
  {
    this.vcc = parama;
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    if (this.vbZ != null) {
      this.vbZ.check(this.mTD);
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    Object localObject = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    ((ViewGroup)localObject).removeAllViews();
    localLayoutInflater.inflate(a.h.mm_preference_content_choice, (ViewGroup)localObject);
    this.vbZ = ((RadioGroup)paramViewGroup.findViewById(a.g.group));
    int i = 0;
    if (i < this.vcb.length)
    {
      localObject = this.vcb[i];
      localObject = (b)this.values.get(localObject);
      RadioButton localRadioButton;
      if (localObject != null)
      {
        if (i != 0) {
          break label138;
        }
        localRadioButton = (RadioButton)localLayoutInflater.inflate(a.h.mm_choice_btn_left, null);
        ((b)localObject).a(localRadioButton);
        this.vbZ.addView(localRadioButton);
      }
      for (;;)
      {
        i += 1;
        break;
        label138:
        if (i == this.vcb.length - 1)
        {
          localRadioButton = (RadioButton)localLayoutInflater.inflate(a.h.mm_choice_btn_right, null);
          ((b)localObject).a(localRadioButton);
          this.vbZ.addView(localRadioButton);
        }
        else
        {
          localRadioButton = (RadioButton)localLayoutInflater.inflate(a.h.mm_choice_btn_middle, null);
          ((b)localObject).a(localRadioButton);
          this.vbZ.addView(localRadioButton);
        }
      }
    }
    this.vbZ.setOnCheckedChangeListener(new ChoicePreference.1(this));
    return paramViewGroup;
  }
  
  public final void setValue(String paramString)
  {
    this.value = paramString;
    paramString = (b)this.values.get(paramString);
    if (paramString == null)
    {
      this.mTD = -1;
      return;
    }
    this.mTD = paramString.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ChoicePreference
 * JD-Core Version:    0.7.0.1
 */