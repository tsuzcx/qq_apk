package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView
  extends ProfileItemView
  implements MMPhoneNumberEditText.a
{
  public String BVY;
  public String BVZ;
  public String[] BWa;
  private LinearLayout BWb;
  private boolean BWc = false;
  public a BWd;
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void cp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31222);
    MMPhoneNumberEditText localMMPhoneNumberEditText = (MMPhoneNumberEditText)LayoutInflater.from(getContext()).inflate(2131495136, null);
    localMMPhoneNumberEditText.setHint(aj.getResources().getString(2131755149));
    if (paramBoolean) {
      localMMPhoneNumberEditText.exu();
    }
    localMMPhoneNumberEditText.setCallback(this);
    localMMPhoneNumberEditText.setText(paramString);
    localMMPhoneNumberEditText.setSelection(localMMPhoneNumberEditText.getText().length());
    paramString = new LinearLayout.LayoutParams(-1, -2);
    paramString.setMargins(com.tencent.mm.cd.a.fromDPToPix(getContext(), 16), com.tencent.mm.cd.a.fromDPToPix(getContext(), 0), 0, 0);
    this.BWb.addView(localMMPhoneNumberEditText, paramString);
    AppMethodBeat.o(31222);
  }
  
  private void exE()
  {
    AppMethodBeat.i(31217);
    if (this.BWd != null) {
      this.BWd.onChange();
    }
    AppMethodBeat.o(31217);
  }
  
  private void h(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(31223);
    this.BWb.removeView(paramMMPhoneNumberEditText);
    this.BWb.getChildAt(this.BWb.getChildCount() - 1).requestFocus();
    AppMethodBeat.o(31223);
  }
  
  public final boolean Z(af paramaf)
  {
    this.oFt = paramaf;
    return true;
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(31214);
    int i = 1;
    while (i < this.BWb.getChildCount())
    {
      this.BWb.getChildAt(i).clearFocus();
      i += 1;
    }
    AppMethodBeat.o(31214);
  }
  
  public final boolean dcY()
  {
    AppMethodBeat.i(31215);
    int j;
    if (!bt.isNullOrNil(this.BVY))
    {
      cp(this.BVY, true);
      j = 1;
    }
    for (int i = 1;; i = 0)
    {
      int k = i;
      if (!bt.isNullOrNil(this.BVZ))
      {
        this.BWa = com.tencent.mm.n.a.a(this.oFt, this.BVZ);
        k = i;
        if (this.BWa != null) {
          for (;;)
          {
            k = i;
            if (i >= this.BWa.length + j) {
              break;
            }
            cp(this.BWa[(i - j)].trim(), false);
            i += 1;
          }
        }
      }
      if (k < 5) {
        cp(null, false);
      }
      for (this.BWc = false;; this.BWc = true)
      {
        AppMethodBeat.o(31215);
        return false;
      }
      j = 0;
    }
  }
  
  public final void exy()
  {
    AppMethodBeat.i(31220);
    if (this.BWb.getChildCount() < 5) {
      cp(null, false);
    }
    for (;;)
    {
      exE();
      AppMethodBeat.o(31220);
      return;
      this.BWc = true;
    }
  }
  
  public final void exz()
  {
    AppMethodBeat.i(31219);
    exE();
    AppMethodBeat.o(31219);
  }
  
  public final void f(final MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(31218);
    if (paramMMPhoneNumberEditText.BVF)
    {
      h.b(getContext(), 2131760245, 0, 2131760244, 2131760243, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(31212);
          ProfileEditPhoneNumberView.this.BVY = "";
          ProfileEditPhoneNumberView.this.BWd.exF();
          ProfileEditPhoneNumberView.a(ProfileEditPhoneNumberView.this, paramMMPhoneNumberEditText);
          if (!ProfileEditPhoneNumberView.a(ProfileEditPhoneNumberView.this)) {
            ProfileEditPhoneNumberView.b(ProfileEditPhoneNumberView.this);
          }
          AppMethodBeat.o(31212);
        }
      }, null);
      AppMethodBeat.o(31218);
      return;
    }
    h(paramMMPhoneNumberEditText);
    if (this.BWc)
    {
      cp(null, false);
      this.BWc = false;
    }
    exE();
    AppMethodBeat.o(31218);
  }
  
  public final void g(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(31221);
    if (this.BWb.getChildCount() - 1 == 1)
    {
      AppMethodBeat.o(31221);
      return;
    }
    h(paramMMPhoneNumberEditText);
    if (this.BWc) {
      cp(null, false);
    }
    this.BWc = false;
    exE();
    AppMethodBeat.o(31221);
  }
  
  public int getLayout()
  {
    return 2131495137;
  }
  
  public ArrayList<String> getPhoneNumberList()
  {
    AppMethodBeat.i(31216);
    int j = this.BWb.getChildCount();
    if (j == 0)
    {
      AppMethodBeat.o(31216);
      return null;
    }
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      String str = ((MMPhoneNumberEditText)this.BWb.getChildAt(i)).getText().toString();
      if ((!bt.isNullOrNil(str)) && (!str.trim().equals(""))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    if ((!bt.isNullOrNil(this.BVY)) && (localArrayList.size() > 0)) {
      localArrayList.remove(0);
    }
    AppMethodBeat.o(31216);
    return localArrayList;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31213);
    this.BWb = ((LinearLayout)findViewById(2131301989));
    AppMethodBeat.o(31213);
  }
  
  public static abstract interface a
  {
    public abstract void exF();
    
    public abstract void onChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView
 * JD-Core Version:    0.7.0.1
 */