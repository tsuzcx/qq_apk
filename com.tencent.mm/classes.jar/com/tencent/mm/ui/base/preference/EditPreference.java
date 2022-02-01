package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;

public class EditPreference
  extends Preference
{
  private Preference.a Gee;
  a Gej;
  private d ijc;
  private EditText sz;
  String value;
  
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
    this.Gee = parama;
  }
  
  public final void showDialog()
  {
    AppMethodBeat.i(142539);
    final EditText localEditText;
    if (this.sz != null) {
      localEditText = this.sz;
    }
    for (;;)
    {
      Object localObject = localEditText.getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        int i = localEditText.getResources().getDimensionPixelSize(2131165480);
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i;
      }
      if (localEditText.getParent() != null) {
        ((ViewGroup)localEditText.getParent()).removeView(localEditText);
      }
      this.ijc = h.a(this.mContext, getTitle().toString(), localEditText, a.aq(this.mContext, 2131755835), a.aq(this.mContext, 2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(142537);
          if (EditPreference.a(EditPreference.this) != null) {
            EditPreference.a(EditPreference.this).dismiss();
          }
          EditPreference.this.value = localEditText.getText().toString();
          if (EditPreference.b(EditPreference.this) != null) {
            EditPreference.b(EditPreference.this).eTx();
          }
          if (EditPreference.c(EditPreference.this) != null) {
            EditPreference.c(EditPreference.this).a(EditPreference.this, EditPreference.d(EditPreference.this));
          }
          AppMethodBeat.o(142537);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(142538);
          if (EditPreference.a(EditPreference.this) != null) {
            EditPreference.a(EditPreference.this).dismiss();
          }
          AppMethodBeat.o(142538);
        }
      });
      AppMethodBeat.o(142539);
      return;
      localEditText = new EditText(this.mContext);
      localEditText.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      localEditText.setSingleLine(true);
      localEditText.setText(this.value);
    }
  }
  
  public static abstract interface a
  {
    public abstract void eTx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.EditPreference
 * JD-Core Version:    0.7.0.1
 */