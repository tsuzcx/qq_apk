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
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView
  extends ProfileItemView
  implements MMPhoneNumberEditText.a
{
  public String Rdn;
  public String Rdo;
  public String[] Rdp;
  private LinearLayout Rdq;
  private View Rdr;
  public a Rds;
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void hjK()
  {
    AppMethodBeat.i(31217);
    if (this.Rds != null) {
      this.Rds.onChange();
    }
    AppMethodBeat.o(31217);
  }
  
  private void hjL()
  {
    AppMethodBeat.i(286325);
    this.Rdr.setVisibility(0);
    if (this.Rds != null) {
      this.Rds.hjO();
    }
    AppMethodBeat.o(286325);
  }
  
  private void hjM()
  {
    AppMethodBeat.i(286326);
    this.Rdr.setVisibility(8);
    if (this.Rds != null) {
      this.Rds.hjO();
    }
    AppMethodBeat.o(286326);
  }
  
  private void p(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(286324);
    final View localView1 = LayoutInflater.from(getContext()).inflate(R.i.eka, null);
    final MMPhoneNumberEditText localMMPhoneNumberEditText = (MMPhoneNumberEditText)localView1.findViewById(R.h.dRa);
    View localView3 = localView1.findViewById(R.h.dDI);
    View localView2 = localView1.findViewById(R.h.line);
    if (localView3 != null) {
      localView3.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213992);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/ProfileEditPhoneNumberView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          ProfileEditPhoneNumberView.a(ProfileEditPhoneNumberView.this).removeView(localView1);
          ProfileEditPhoneNumberView.b(ProfileEditPhoneNumberView.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/ProfileEditPhoneNumberView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213992);
        }
      });
    }
    localMMPhoneNumberEditText.setHint(getResources().getString(R.l.emM));
    if (paramBoolean1) {
      localMMPhoneNumberEditText.hjw();
    }
    localMMPhoneNumberEditText.setCallback(this);
    localMMPhoneNumberEditText.setText(paramString);
    localMMPhoneNumberEditText.setSelection(localMMPhoneNumberEditText.getText().length());
    localMMPhoneNumberEditText.setBackgroundColor(getResources().getColor(R.e.transparent));
    paramString = localView1.findViewById(R.h.dRb);
    paramString.setPadding(paramString.getPaddingLeft(), 0, paramString.getPaddingRight(), 0);
    paramString = new LinearLayout.LayoutParams(-1, -2);
    paramString.setMargins(0, 0, 0, 0);
    this.Rdq.addView(localView1, this.Rdq.getChildCount() - 1, paramString);
    localMMPhoneNumberEditText.setPadding(0, 0, 0, 0);
    localMMPhoneNumberEditText.requestFocus();
    if (paramBoolean2) {
      localMMPhoneNumberEditText.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(258698);
          localMMPhoneNumberEditText.setSelection(localMMPhoneNumberEditText.getText().length());
          ((InputMethodManager)localMMPhoneNumberEditText.getContext().getSystemService("input_method")).showSoftInput(localMMPhoneNumberEditText, 0);
          AppMethodBeat.o(258698);
        }
      }, 100L);
    }
    if (this.Rds != null) {
      this.Rds.hr(localMMPhoneNumberEditText);
    }
    if (localView2 != null)
    {
      if (this.Rdq.getChildCount() > 5)
      {
        localView2.setVisibility(8);
        AppMethodBeat.o(286324);
        return;
      }
      localView2.setVisibility(0);
    }
    AppMethodBeat.o(286324);
  }
  
  public final boolean ap(as paramas)
  {
    this.uNk = paramas;
    return true;
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(31214);
    int i = 1;
    while (i < this.Rdq.getChildCount())
    {
      this.Rdq.getChildAt(i).clearFocus();
      i += 1;
    }
    AppMethodBeat.o(31214);
  }
  
  public final void f(final MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(31218);
    if (paramMMPhoneNumberEditText.RcV)
    {
      h.a(getContext(), R.l.eHT, 0, R.l.eHS, R.l.eHR, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(31212);
          ProfileEditPhoneNumberView.this.Rdn = "";
          ProfileEditPhoneNumberView.this.Rds.hjN();
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
    hjK();
    AppMethodBeat.o(31218);
  }
  
  public final boolean fqK()
  {
    AppMethodBeat.i(31215);
    int j;
    if (!Util.isNullOrNil(this.Rdn))
    {
      p(this.Rdn, true, false);
      j = 1;
    }
    for (int i = 1;; i = 0)
    {
      int k = i;
      if (!Util.isNullOrNil(this.Rdo))
      {
        this.Rdp = com.tencent.mm.contact.a.a(this.uNk, this.Rdo);
        k = i;
        if (this.Rdp != null) {
          for (;;)
          {
            k = i;
            if (i >= this.Rdp.length + j) {
              break;
            }
            p(this.Rdp[(i - j)].trim(), false, false);
            i += 1;
          }
        }
      }
      if (k < 5) {
        hjL();
      }
      for (;;)
      {
        AppMethodBeat.o(31215);
        return false;
        hjM();
      }
      j = 0;
    }
  }
  
  public int getLayout()
  {
    return R.i.ekb;
  }
  
  public ArrayList<String> getPhoneNumberList()
  {
    AppMethodBeat.i(31216);
    int j = this.Rdq.getChildCount();
    if (j == 0)
    {
      AppMethodBeat.o(31216);
      return null;
    }
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      Object localObject = this.Rdq.getChildAt(i).findViewById(R.h.dRa);
      if ((localObject instanceof MMPhoneNumberEditText))
      {
        localObject = ((MMPhoneNumberEditText)localObject).getText().toString();
        if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).trim().equals(""))) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    if ((!Util.isNullOrNil(this.Rdn)) && (localArrayList.size() > 0)) {
      localArrayList.remove(0);
    }
    AppMethodBeat.o(31216);
    return localArrayList;
  }
  
  public final void hjA()
  {
    AppMethodBeat.i(31220);
    hjK();
    AppMethodBeat.o(31220);
  }
  
  public final void hjB()
  {
    AppMethodBeat.i(286323);
    if (this.Rdq.getChildCount() - 1 == 1)
    {
      AppMethodBeat.o(286323);
      return;
    }
    hjK();
    AppMethodBeat.o(286323);
  }
  
  public final void hjC()
  {
    AppMethodBeat.i(31219);
    hjK();
    AppMethodBeat.o(31219);
  }
  
  public final boolean hjJ()
  {
    AppMethodBeat.i(286319);
    if ((this.Rdr != null) && (this.Rdr.getVisibility() == 0))
    {
      AppMethodBeat.o(286319);
      return true;
    }
    AppMethodBeat.o(286319);
    return false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31213);
    this.Rdq = ((LinearLayout)findViewById(R.h.main_layout));
    this.Rdr = LayoutInflater.from(getContext()).inflate(R.i.ejZ, null);
    this.Rdr.findViewById(R.h.dqh);
    View localView = this.Rdr.findViewById(R.h.dQZ);
    localView.setPadding(localView.getPaddingLeft(), 0, localView.getPaddingRight(), 0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(0, 0, 0, 0);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(287918);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/ProfileEditPhoneNumberView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ProfileEditPhoneNumberView.c(ProfileEditPhoneNumberView.this);
        if (ProfileEditPhoneNumberView.a(ProfileEditPhoneNumberView.this).getChildCount() > 5) {
          ProfileEditPhoneNumberView.d(ProfileEditPhoneNumberView.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/ProfileEditPhoneNumberView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(287918);
          return;
          ProfileEditPhoneNumberView.b(ProfileEditPhoneNumberView.this);
        }
      }
    });
    this.Rdq.addView(this.Rdr, localLayoutParams);
    AppMethodBeat.o(31213);
  }
  
  public static abstract interface a
  {
    public abstract void hjN();
    
    public abstract void hjO();
    
    public abstract void hr(View paramView);
    
    public abstract void onChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView
 * JD-Core Version:    0.7.0.1
 */