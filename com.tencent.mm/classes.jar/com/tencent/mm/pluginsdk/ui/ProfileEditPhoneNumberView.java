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
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView
  extends ProfileItemView
  implements MMPhoneNumberEditText.a
{
  public String FlQ;
  public String FlR;
  public String[] FlS;
  private LinearLayout FlT;
  private boolean FlU = false;
  public a FlV;
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void cE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31222);
    MMPhoneNumberEditText localMMPhoneNumberEditText = (MMPhoneNumberEditText)LayoutInflater.from(getContext()).inflate(2131495136, null);
    localMMPhoneNumberEditText.setHint(ak.getResources().getString(2131755149));
    if (paramBoolean) {
      localMMPhoneNumberEditText.ffB();
    }
    localMMPhoneNumberEditText.setCallback(this);
    localMMPhoneNumberEditText.setText(paramString);
    localMMPhoneNumberEditText.setSelection(localMMPhoneNumberEditText.getText().length());
    paramString = new LinearLayout.LayoutParams(-1, -2);
    paramString.setMargins(com.tencent.mm.cb.a.fromDPToPix(getContext(), 16), com.tencent.mm.cb.a.fromDPToPix(getContext(), 0), 0, 0);
    this.FlT.addView(localMMPhoneNumberEditText, paramString);
    AppMethodBeat.o(31222);
  }
  
  private void ffL()
  {
    AppMethodBeat.i(31217);
    if (this.FlV != null) {
      this.FlV.onChange();
    }
    AppMethodBeat.o(31217);
  }
  
  private void h(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(31223);
    this.FlT.removeView(paramMMPhoneNumberEditText);
    this.FlT.getChildAt(this.FlT.getChildCount() - 1).requestFocus();
    AppMethodBeat.o(31223);
  }
  
  public final boolean ah(an paraman)
  {
    this.pSY = paraman;
    return true;
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(31214);
    int i = 1;
    while (i < this.FlT.getChildCount())
    {
      this.FlT.getChildAt(i).clearFocus();
      i += 1;
    }
    AppMethodBeat.o(31214);
  }
  
  public final boolean dEA()
  {
    AppMethodBeat.i(31215);
    int j;
    if (!bu.isNullOrNil(this.FlQ))
    {
      cE(this.FlQ, true);
      j = 1;
    }
    for (int i = 1;; i = 0)
    {
      int k = i;
      if (!bu.isNullOrNil(this.FlR))
      {
        this.FlS = com.tencent.mm.contact.a.a(this.pSY, this.FlR);
        k = i;
        if (this.FlS != null) {
          for (;;)
          {
            k = i;
            if (i >= this.FlS.length + j) {
              break;
            }
            cE(this.FlS[(i - j)].trim(), false);
            i += 1;
          }
        }
      }
      if (k < 5) {
        cE(null, false);
      }
      for (this.FlU = false;; this.FlU = true)
      {
        AppMethodBeat.o(31215);
        return false;
      }
      j = 0;
    }
  }
  
  public final void f(final MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(31218);
    if (paramMMPhoneNumberEditText.Flx)
    {
      h.a(getContext(), 2131760245, 0, 2131760244, 2131760243, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(31212);
          ProfileEditPhoneNumberView.this.FlQ = "";
          ProfileEditPhoneNumberView.this.FlV.ffM();
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
    if (this.FlU)
    {
      cE(null, false);
      this.FlU = false;
    }
    ffL();
    AppMethodBeat.o(31218);
  }
  
  public final void ffF()
  {
    AppMethodBeat.i(31220);
    if (this.FlT.getChildCount() < 5) {
      cE(null, false);
    }
    for (;;)
    {
      ffL();
      AppMethodBeat.o(31220);
      return;
      this.FlU = true;
    }
  }
  
  public final void ffG()
  {
    AppMethodBeat.i(31219);
    ffL();
    AppMethodBeat.o(31219);
  }
  
  public final void g(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(31221);
    if (this.FlT.getChildCount() - 1 == 1)
    {
      AppMethodBeat.o(31221);
      return;
    }
    h(paramMMPhoneNumberEditText);
    if (this.FlU) {
      cE(null, false);
    }
    this.FlU = false;
    ffL();
    AppMethodBeat.o(31221);
  }
  
  public int getLayout()
  {
    return 2131495137;
  }
  
  public ArrayList<String> getPhoneNumberList()
  {
    AppMethodBeat.i(31216);
    int j = this.FlT.getChildCount();
    if (j == 0)
    {
      AppMethodBeat.o(31216);
      return null;
    }
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      String str = ((MMPhoneNumberEditText)this.FlT.getChildAt(i)).getText().toString();
      if ((!bu.isNullOrNil(str)) && (!str.trim().equals(""))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    if ((!bu.isNullOrNil(this.FlQ)) && (localArrayList.size() > 0)) {
      localArrayList.remove(0);
    }
    AppMethodBeat.o(31216);
    return localArrayList;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31213);
    this.FlT = ((LinearLayout)findViewById(2131301989));
    AppMethodBeat.o(31213);
  }
  
  public static abstract interface a
  {
    public abstract void ffM();
    
    public abstract void onChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView
 * JD-Core Version:    0.7.0.1
 */