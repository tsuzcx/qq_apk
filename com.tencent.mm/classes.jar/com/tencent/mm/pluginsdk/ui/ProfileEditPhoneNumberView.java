package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView
  extends ProfileItemView
  implements MMPhoneNumberEditText.a
{
  public String XZt;
  public String XZu;
  public String[] XZv;
  private LinearLayout XZw;
  private View XZx;
  public a XZy;
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void iKC()
  {
    AppMethodBeat.i(31217);
    if (this.XZy != null) {
      this.XZy.onChange();
    }
    AppMethodBeat.o(31217);
  }
  
  private void iKD()
  {
    AppMethodBeat.i(245096);
    this.XZx.setVisibility(0);
    if (this.XZy != null) {
      this.XZy.iKG();
    }
    AppMethodBeat.o(245096);
  }
  
  private void iKE()
  {
    AppMethodBeat.i(245099);
    this.XZx.setVisibility(8);
    if (this.XZy != null) {
      this.XZy.iKG();
    }
    AppMethodBeat.o(245099);
  }
  
  private void t(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(245095);
    final View localView1 = LayoutInflater.from(getContext()).inflate(R.i.gnd, null);
    final MMPhoneNumberEditText localMMPhoneNumberEditText = (MMPhoneNumberEditText)localView1.findViewById(R.h.fTg);
    View localView3 = localView1.findViewById(R.h.fEA);
    View localView2 = localView1.findViewById(R.h.line);
    if (localView3 != null) {
      localView3.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(245059);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/ProfileEditPhoneNumberView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          ProfileEditPhoneNumberView.a(ProfileEditPhoneNumberView.this).removeView(localView1);
          ProfileEditPhoneNumberView.b(ProfileEditPhoneNumberView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/ProfileEditPhoneNumberView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(245059);
        }
      });
    }
    localMMPhoneNumberEditText.setHint(getResources().getString(R.l.gpN));
    if (paramBoolean1) {
      localMMPhoneNumberEditText.iKo();
    }
    localMMPhoneNumberEditText.setCallback(this);
    localMMPhoneNumberEditText.setText(paramString);
    localMMPhoneNumberEditText.setSelection(localMMPhoneNumberEditText.getText().length());
    localMMPhoneNumberEditText.setBackgroundColor(getResources().getColor(R.e.transparent));
    paramString = localView1.findViewById(R.h.fTh);
    paramString.setPadding(paramString.getPaddingLeft(), 0, paramString.getPaddingRight(), 0);
    paramString = new LinearLayout.LayoutParams(-1, -2);
    paramString.setMargins(0, 0, 0, 0);
    this.XZw.addView(localView1, this.XZw.getChildCount() - 1, paramString);
    localMMPhoneNumberEditText.setPadding(0, 0, 0, 0);
    localMMPhoneNumberEditText.requestFocus();
    if (paramBoolean2) {
      localMMPhoneNumberEditText.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(245042);
          localMMPhoneNumberEditText.setSelection(localMMPhoneNumberEditText.getText().length());
          ((InputMethodManager)localMMPhoneNumberEditText.getContext().getSystemService("input_method")).showSoftInput(localMMPhoneNumberEditText, 0);
          AppMethodBeat.o(245042);
        }
      }, 100L);
    }
    if (this.XZy != null) {
      this.XZy.kH(localMMPhoneNumberEditText);
    }
    if (localView2 != null)
    {
      if (this.XZw.getChildCount() > 5)
      {
        localView2.setVisibility(8);
        AppMethodBeat.o(245095);
        return;
      }
      localView2.setVisibility(0);
    }
    AppMethodBeat.o(245095);
  }
  
  public final boolean av(au paramau)
  {
    this.xVS = paramau;
    return true;
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(31214);
    int i = 1;
    while (i < this.XZw.getChildCount())
    {
      this.XZw.getChildAt(i).clearFocus();
      i += 1;
    }
    AppMethodBeat.o(31214);
  }
  
  public final void f(final MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(31218);
    if (paramMMPhoneNumberEditText.XZb)
    {
      k.a(getContext(), R.l.gJA, 0, R.l.gJz, R.l.gJy, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(31212);
          ProfileEditPhoneNumberView.this.XZt = "";
          ProfileEditPhoneNumberView.this.XZy.iKF();
          ProfileEditPhoneNumberView.a(ProfileEditPhoneNumberView.this, paramMMPhoneNumberEditText);
          if (ProfileEditPhoneNumberView.a(ProfileEditPhoneNumberView.this).getChildCount() <= 5) {
            ProfileEditPhoneNumberView.b(ProfileEditPhoneNumberView.this);
          }
          AppMethodBeat.o(31212);
        }
      }, null);
      AppMethodBeat.o(31218);
      return;
    }
    paramMMPhoneNumberEditText.setText("");
    iKC();
    AppMethodBeat.o(31218);
  }
  
  public final boolean gCe()
  {
    AppMethodBeat.i(31215);
    int j;
    if (!Util.isNullOrNil(this.XZt))
    {
      t(this.XZt, true, false);
      j = 1;
    }
    for (int i = 1;; i = 0)
    {
      int k = i;
      if (!Util.isNullOrNil(this.XZu))
      {
        this.XZv = com.tencent.mm.contact.a.a(this.xVS, this.XZu);
        k = i;
        if (this.XZv != null) {
          for (;;)
          {
            k = i;
            if (i >= this.XZv.length + j) {
              break;
            }
            t(this.XZv[(i - j)].trim(), false, false);
            i += 1;
          }
        }
      }
      if (k < 5) {
        iKD();
      }
      for (;;)
      {
        AppMethodBeat.o(31215);
        return false;
        iKE();
      }
      j = 0;
    }
  }
  
  public int getLayout()
  {
    return R.i.gne;
  }
  
  public ArrayList<String> getPhoneNumberList()
  {
    AppMethodBeat.i(31216);
    int j = this.XZw.getChildCount();
    if (j == 0)
    {
      AppMethodBeat.o(31216);
      return null;
    }
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      Object localObject = this.XZw.getChildAt(i).findViewById(R.h.fTg);
      if ((localObject instanceof MMPhoneNumberEditText))
      {
        localObject = ((MMPhoneNumberEditText)localObject).getText().toString();
        if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).trim().equals(""))) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    if ((!Util.isNullOrNil(this.XZt)) && (localArrayList.size() > 0)) {
      localArrayList.remove(0);
    }
    AppMethodBeat.o(31216);
    return localArrayList;
  }
  
  public final boolean iKB()
  {
    AppMethodBeat.i(245110);
    if ((this.XZx != null) && (this.XZx.getVisibility() == 0))
    {
      AppMethodBeat.o(245110);
      return true;
    }
    AppMethodBeat.o(245110);
    return false;
  }
  
  public final void iKs()
  {
    AppMethodBeat.i(31220);
    iKC();
    AppMethodBeat.o(31220);
  }
  
  public final void iKt()
  {
    AppMethodBeat.i(245115);
    if (this.XZw.getChildCount() - 1 == 1)
    {
      AppMethodBeat.o(245115);
      return;
    }
    iKC();
    AppMethodBeat.o(245115);
  }
  
  public final void iKu()
  {
    AppMethodBeat.i(31219);
    iKC();
    AppMethodBeat.o(31219);
  }
  
  public final void init()
  {
    AppMethodBeat.i(31213);
    this.XZw = ((LinearLayout)findViewById(R.h.main_layout));
    this.XZx = LayoutInflater.from(getContext()).inflate(R.i.gnc, null);
    this.XZx.findViewById(R.h.fqv);
    View localView = this.XZx.findViewById(R.h.fTf);
    localView.setPadding(localView.getPaddingLeft(), 0, localView.getPaddingRight(), 0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(0, 0, 0, 0);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(245041);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/ProfileEditPhoneNumberView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ProfileEditPhoneNumberView.c(ProfileEditPhoneNumberView.this);
        if (ProfileEditPhoneNumberView.a(ProfileEditPhoneNumberView.this).getChildCount() > 5) {
          ProfileEditPhoneNumberView.d(ProfileEditPhoneNumberView.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/ProfileEditPhoneNumberView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(245041);
          return;
          ProfileEditPhoneNumberView.b(ProfileEditPhoneNumberView.this);
        }
      }
    });
    this.XZw.addView(this.XZx, localLayoutParams);
    AppMethodBeat.o(31213);
  }
  
  public static abstract interface a
  {
    public abstract void iKF();
    
    public abstract void iKG();
    
    public abstract void kH(View paramView);
    
    public abstract void onChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView
 * JD-Core Version:    0.7.0.1
 */