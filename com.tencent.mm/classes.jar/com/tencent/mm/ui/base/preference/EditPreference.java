package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;

public class EditPreference
  extends Preference
{
  private c gwf;
  private EditText naN;
  String value;
  private Preference.a zqD;
  EditPreference.a zqI;
  
  public EditPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(Preference.a parama)
  {
    this.zqD = parama;
  }
  
  public final void showDialog()
  {
    AppMethodBeat.i(107162);
    EditText localEditText;
    if (this.naN != null) {
      localEditText = this.naN;
    }
    for (;;)
    {
      Object localObject = localEditText.getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        int i = localEditText.getResources().getDimensionPixelSize(2131427772);
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i;
      }
      if (localEditText.getParent() != null) {
        ((ViewGroup)localEditText.getParent()).removeView(localEditText);
      }
      this.gwf = h.a(this.mContext, getTitle().toString(), localEditText, a.aq(this.mContext, 2131297018), a.aq(this.mContext, 2131296888), new EditPreference.1(this, localEditText), new EditPreference.2(this));
      AppMethodBeat.o(107162);
      return;
      localEditText = new EditText(this.mContext);
      localEditText.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      localEditText.setSingleLine(true);
      localEditText.setText(this.value);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.EditPreference
 * JD-Core Version:    0.7.0.1
 */