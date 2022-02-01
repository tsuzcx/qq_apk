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
  private int GUG;
  private RadioGroup WqF;
  private CharSequence[] WqG;
  private CharSequence[] WqH;
  public Preference.a WqI;
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
    this.GUG = -1;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.ChoicePreference, paramInt, 0);
    this.WqG = paramContext.getTextArray(a.m.ChoicePreference_entries);
    this.WqH = paramContext.getTextArray(a.m.ChoicePreference_entryValues);
    paramContext.recycle();
    hKE();
    AppMethodBeat.o(142523);
  }
  
  private void hKE()
  {
    int i = 0;
    AppMethodBeat.i(142525);
    if (this.WqG == null) {
      this.WqG = new CharSequence[0];
    }
    if (this.WqH == null) {
      this.WqH = new CharSequence[0];
    }
    if (this.WqG.length == this.WqH.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("entries count different", bool);
      this.values.clear();
      while (i < this.WqH.length)
      {
        b localb = new b(this.WqG[i], 1048576 + i);
        this.values.put(this.WqH[i], localb);
        i += 1;
      }
    }
    AppMethodBeat.o(142525);
  }
  
  public final void a(Preference.a parama)
  {
    this.WqI = parama;
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142526);
    super.onBindView(paramView);
    if (this.WqF != null) {
      this.WqF.check(this.GUG);
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
    this.WqF = ((RadioGroup)paramViewGroup.findViewById(a.g.group));
    int i = 0;
    if (i < this.WqH.length)
    {
      localObject = this.WqH[i];
      localObject = (b)this.values.get(localObject);
      RadioButton localRadioButton;
      if (localObject != null)
      {
        if (i != 0) {
          break label143;
        }
        localRadioButton = (RadioButton)localLayoutInflater.inflate(a.h.mm_choice_btn_left, null);
        ((b)localObject).a(localRadioButton);
        this.WqF.addView(localRadioButton);
      }
      for (;;)
      {
        i += 1;
        break;
        label143:
        if (i == this.WqH.length - 1)
        {
          localRadioButton = (RadioButton)localLayoutInflater.inflate(a.h.mm_choice_btn_right, null);
          ((b)localObject).a(localRadioButton);
          this.WqF.addView(localRadioButton);
        }
        else
        {
          localRadioButton = (RadioButton)localLayoutInflater.inflate(a.h.mm_choice_btn_middle, null);
          ((b)localObject).a(localRadioButton);
          this.WqF.addView(localRadioButton);
        }
      }
    }
    this.WqF.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
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
      this.GUG = -1;
      AppMethodBeat.o(142527);
      return;
    }
    this.GUG = paramString.id;
    AppMethodBeat.o(142527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ChoicePreference
 * JD-Core Version:    0.7.0.1
 */