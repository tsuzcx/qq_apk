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
import com.tencent.mm.ae.a.a;
import java.util.HashMap;
import junit.framework.Assert;

public final class ChoicePreference
  extends Preference
{
  private RadioGroup HDQ;
  private CharSequence[] HDR;
  private CharSequence[] HDS;
  public Preference.a HDT;
  private int vGl;
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
    this.vGl = -1;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ChoicePreference, paramInt, 0);
    this.HDR = paramContext.getTextArray(0);
    this.HDS = paramContext.getTextArray(1);
    paramContext.recycle();
    fji();
    AppMethodBeat.o(142523);
  }
  
  private void fji()
  {
    int i = 0;
    AppMethodBeat.i(142525);
    if (this.HDR == null) {
      this.HDR = new CharSequence[0];
    }
    if (this.HDS == null) {
      this.HDS = new CharSequence[0];
    }
    if (this.HDR.length == this.HDS.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("entries count different", bool);
      this.values.clear();
      while (i < this.HDS.length)
      {
        b localb = new b(this.HDR[i], 1048576 + i);
        this.values.put(this.HDS[i], localb);
        i += 1;
      }
    }
    AppMethodBeat.o(142525);
  }
  
  public final void a(Preference.a parama)
  {
    this.HDT = parama;
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142526);
    super.onBindView(paramView);
    if (this.HDQ != null) {
      this.HDQ.check(this.vGl);
    }
    AppMethodBeat.o(142526);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142524);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    Object localObject = (ViewGroup)paramViewGroup.findViewById(2131298739);
    ((ViewGroup)localObject).removeAllViews();
    localLayoutInflater.inflate(2131494825, (ViewGroup)localObject);
    this.HDQ = ((RadioGroup)paramViewGroup.findViewById(2131300621));
    int i = 0;
    if (i < this.HDS.length)
    {
      localObject = this.HDS[i];
      localObject = (b)this.values.get(localObject);
      RadioButton localRadioButton;
      if (localObject != null)
      {
        if (i != 0) {
          break label139;
        }
        localRadioButton = (RadioButton)localLayoutInflater.inflate(2131494778, null);
        ((b)localObject).a(localRadioButton);
        this.HDQ.addView(localRadioButton);
      }
      for (;;)
      {
        i += 1;
        break;
        label139:
        if (i == this.HDS.length - 1)
        {
          localRadioButton = (RadioButton)localLayoutInflater.inflate(2131494780, null);
          ((b)localObject).a(localRadioButton);
          this.HDQ.addView(localRadioButton);
        }
        else
        {
          localRadioButton = (RadioButton)localLayoutInflater.inflate(2131494779, null);
          ((b)localObject).a(localRadioButton);
          this.HDQ.addView(localRadioButton);
        }
      }
    }
    this.HDQ.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
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
      this.vGl = -1;
      AppMethodBeat.o(142527);
      return;
    }
    this.vGl = paramString.id;
    AppMethodBeat.o(142527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.ChoicePreference
 * JD-Core Version:    0.7.0.1
 */