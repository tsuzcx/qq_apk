package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a.a;
import java.util.HashMap;
import junit.framework.Assert;

public final class ChoicePreference
  extends Preference
{
  private int pvJ;
  String value;
  private final HashMap<CharSequence, b> values;
  private RadioGroup zqA;
  private CharSequence[] zqB;
  private CharSequence[] zqC;
  public Preference.a zqD;
  
  public ChoicePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChoicePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107146);
    this.values = new HashMap();
    this.pvJ = -1;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ChoicePreference, paramInt, 0);
    this.zqB = paramContext.getTextArray(0);
    this.zqC = paramContext.getTextArray(1);
    paramContext.recycle();
    dEH();
    AppMethodBeat.o(107146);
  }
  
  private void dEH()
  {
    int i = 0;
    AppMethodBeat.i(107148);
    if (this.zqB == null) {
      this.zqB = new CharSequence[0];
    }
    if (this.zqC == null) {
      this.zqC = new CharSequence[0];
    }
    if (this.zqB.length == this.zqC.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("entries count different", bool);
      this.values.clear();
      while (i < this.zqC.length)
      {
        b localb = new b(this.zqB[i], 1048576 + i);
        this.values.put(this.zqC[i], localb);
        i += 1;
      }
    }
    AppMethodBeat.o(107148);
  }
  
  public final void a(Preference.a parama)
  {
    this.zqD = parama;
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(107149);
    super.onBindView(paramView);
    if (this.zqA != null) {
      this.zqA.check(this.pvJ);
    }
    AppMethodBeat.o(107149);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107147);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    Object localObject = (ViewGroup)paramViewGroup.findViewById(2131820946);
    ((ViewGroup)localObject).removeAllViews();
    localLayoutInflater.inflate(2130970198, (ViewGroup)localObject);
    this.zqA = ((RadioGroup)paramViewGroup.findViewById(2131826210));
    int i = 0;
    if (i < this.zqC.length)
    {
      localObject = this.zqC[i];
      localObject = (b)this.values.get(localObject);
      RadioButton localRadioButton;
      if (localObject != null)
      {
        if (i != 0) {
          break label139;
        }
        localRadioButton = (RadioButton)localLayoutInflater.inflate(2130970155, null);
        ((b)localObject).a(localRadioButton);
        this.zqA.addView(localRadioButton);
      }
      for (;;)
      {
        i += 1;
        break;
        label139:
        if (i == this.zqC.length - 1)
        {
          localRadioButton = (RadioButton)localLayoutInflater.inflate(2130970157, null);
          ((b)localObject).a(localRadioButton);
          this.zqA.addView(localRadioButton);
        }
        else
        {
          localRadioButton = (RadioButton)localLayoutInflater.inflate(2130970156, null);
          ((b)localObject).a(localRadioButton);
          this.zqA.addView(localRadioButton);
        }
      }
    }
    this.zqA.setOnCheckedChangeListener(new ChoicePreference.1(this));
    AppMethodBeat.o(107147);
    return paramViewGroup;
  }
  
  public final void setValue(String paramString)
  {
    AppMethodBeat.i(107150);
    this.value = paramString;
    paramString = (b)this.values.get(paramString);
    if (paramString == null)
    {
      this.pvJ = -1;
      AppMethodBeat.o(107150);
      return;
    }
    this.pvJ = paramString.id;
    AppMethodBeat.o(107150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ChoicePreference
 * JD-Core Version:    0.7.0.1
 */