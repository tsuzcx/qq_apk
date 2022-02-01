package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.m;
import java.util.HashMap;
import junit.framework.Assert;

public final class ChoicePreference
  extends Preference
{
  private int MSi;
  private RadioGroup adXU;
  private CharSequence[] adXV;
  private CharSequence[] adXW;
  public Preference.a adXX;
  String value;
  private final HashMap<CharSequence, b> values;
  
  public ChoicePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChoicePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142523);
    this.values = new HashMap();
    this.MSi = -1;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.ChoicePreference, paramInt, 0);
    this.adXV = paramContext.getTextArray(a.m.ChoicePreference_entries);
    this.adXW = paramContext.getTextArray(a.m.ChoicePreference_entryValues);
    paramContext.recycle();
    jni();
    AppMethodBeat.o(142523);
  }
  
  private void jni()
  {
    int i = 0;
    AppMethodBeat.i(142525);
    if (this.adXV == null) {
      this.adXV = new CharSequence[0];
    }
    if (this.adXW == null) {
      this.adXW = new CharSequence[0];
    }
    if (this.adXV.length == this.adXW.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("entries count different", bool);
      this.values.clear();
      while (i < this.adXW.length)
      {
        b localb = new b(this.adXV[i], 1048576 + i);
        this.values.put(this.adXW[i], localb);
        i += 1;
      }
    }
    AppMethodBeat.o(142525);
  }
  
  public final void a(Preference.a parama)
  {
    this.adXX = parama;
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142526);
    super.onBindView(paramView);
    if (this.adXU != null) {
      this.adXU.check(this.MSi);
    }
    AppMethodBeat.o(142526);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142524);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    Object localObject = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    ((ViewGroup)localObject).removeAllViews();
    localLayoutInflater.inflate(a.h.mm_preference_content_choice, (ViewGroup)localObject);
    this.adXU = ((RadioGroup)paramViewGroup.findViewById(a.g.group));
    int i = 0;
    if (i < this.adXW.length)
    {
      localObject = this.adXW[i];
      localObject = (b)this.values.get(localObject);
      RadioButton localRadioButton;
      if (localObject != null)
      {
        if (i != 0) {
          break label143;
        }
        localRadioButton = (RadioButton)localLayoutInflater.inflate(a.h.mm_choice_btn_left, null);
        ((b)localObject).a(localRadioButton);
        this.adXU.addView(localRadioButton);
      }
      for (;;)
      {
        i += 1;
        break;
        label143:
        if (i == this.adXW.length - 1)
        {
          localRadioButton = (RadioButton)localLayoutInflater.inflate(a.h.mm_choice_btn_right, null);
          ((b)localObject).a(localRadioButton);
          this.adXU.addView(localRadioButton);
        }
        else
        {
          localRadioButton = (RadioButton)localLayoutInflater.inflate(a.h.mm_choice_btn_middle, null);
          ((b)localObject).a(localRadioButton);
          this.adXU.addView(localRadioButton);
        }
      }
    }
    this.adXU.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(142522);
        if (ChoicePreference.a(ChoicePreference.this) != null)
        {
          if (paramAnonymousInt == -1) {
            break label92;
          }
          ChoicePreference.a(ChoicePreference.this, ChoicePreference.b(ChoicePreference.this)[(paramAnonymousInt - 1048576)]);
        }
        for (;;)
        {
          ChoicePreference.a(ChoicePreference.this, paramAnonymousInt);
          ChoicePreference.a(ChoicePreference.this).a(ChoicePreference.this, ChoicePreference.this.value);
          AppMethodBeat.o(142522);
          return;
          label92:
          ChoicePreference.a(ChoicePreference.this, null);
        }
      }
    });
    AppMethodBeat.o(142524);
    return paramViewGroup;
  }
  
  public final void setValue(String paramString)
  {
    AppMethodBeat.i(142527);
    this.value = paramString;
    paramString = (b)this.values.get(paramString);
    if (paramString == null)
    {
      this.MSi = -1;
      AppMethodBeat.o(142527);
      return;
    }
    this.MSi = paramString.id;
    AppMethodBeat.o(142527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ChoicePreference
 * JD-Core Version:    0.7.0.1
 */