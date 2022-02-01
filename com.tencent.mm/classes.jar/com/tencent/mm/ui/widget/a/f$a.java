package com.tencent.mm.ui.widget.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.cr.a.i;
import com.tencent.mm.ui.AlertActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.h.c.b;
import java.util.ArrayList;

public final class f$a
{
  public boolean Qlf;
  public final d.a RfU;
  private String Ynv;
  private String Ynw;
  private boolean Ynx;
  private RadioGroup Yny;
  Context mContext;
  public d mUO;
  
  public f$a(Context paramContext)
  {
    AppMethodBeat.i(159373);
    this.Ynv = null;
    this.Ynw = null;
    this.Ynx = false;
    this.Qlf = false;
    this.mContext = paramContext;
    this.RfU = new d.a(this.mContext);
    this.RfU.HG(false);
    this.RfU.HH(false);
    this.RfU.a(new f.a.1(this));
    this.Ynw = this.mContext.getResources().getString(a.i.button_cancel);
    this.Ynv = this.mContext.getResources().getString(a.i.button_ok);
    AppMethodBeat.o(159373);
  }
  
  public final a B(Boolean paramBoolean)
  {
    AppMethodBeat.i(159380);
    this.RfU.HF(paramBoolean.booleanValue());
    AppMethodBeat.o(159380);
    return this;
  }
  
  public final a HL(boolean paramBoolean)
  {
    AppMethodBeat.i(159374);
    this.RfU.HG(paramBoolean);
    this.RfU.HH(paramBoolean);
    AppMethodBeat.o(159374);
    return this;
  }
  
  public final a a(DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    d.a locala = this.RfU;
    locala.Ymv.UVL = paramOnClickListener1;
    locala.Ymv.UVM = paramOnClickListener2;
    locala.Ymv.UVN = paramOnClickListener3;
    return this;
  }
  
  public final a a(final f.b paramb)
  {
    AppMethodBeat.i(159389);
    if (this.Yny != null) {
      this.Yny.setTag(this.mUO);
    }
    if ((this.Ynv == null) || ((this.Ynv != null) && (this.Ynv.length() == 0))) {
      this.Ynv = this.mContext.getResources().getString(a.i.button_ok);
    }
    this.RfU.bBj(this.Ynv);
    this.RfU.c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(159371);
        if (paramb != null)
        {
          if (paramAnonymousDialogInterface != null) {
            ((d)paramAnonymousDialogInterface).icq();
          }
          if (paramAnonymousDialogInterface != null) {
            break label47;
          }
        }
        label47:
        for (boolean bool = false;; bool = ((d)paramAnonymousDialogInterface).me.isChecked())
        {
          paramb.H(true, bool);
          AppMethodBeat.o(159371);
          return;
        }
      }
    });
    if ((this.Ynw == null) || ((this.Ynw != null) && (this.Ynw.length() == 0))) {
      this.Ynw = this.mContext.getResources().getString(a.i.button_cancel);
    }
    this.RfU.bBk(this.Ynw);
    if (!this.Qlf) {
      this.RfU.d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(159372);
          if (paramb != null) {
            if (paramAnonymousDialogInterface != null) {
              break label35;
            }
          }
          label35:
          for (boolean bool = false;; bool = ((d)paramAnonymousDialogInterface).me.isChecked())
          {
            paramb.H(false, bool);
            AppMethodBeat.o(159372);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(159389);
    return this;
  }
  
  public final a a(f.c paramc)
  {
    AppMethodBeat.i(159386);
    if ((this.Ynw == null) || ((this.Ynw != null) && (this.Ynw.length() == 0))) {
      this.Ynw = this.mContext.getResources().getString(a.i.button_cancel);
    }
    this.RfU.bBk(this.Ynw);
    if (!this.Qlf) {
      this.RfU.d(new f.a.2(this, paramc));
    }
    AppMethodBeat.o(159386);
    return this;
  }
  
  public final a a(f.c paramc1, f.c paramc2)
  {
    AppMethodBeat.i(159385);
    if (this.Yny != null) {
      this.Yny.setTag(this.mUO);
    }
    a(paramc1);
    b(paramc2);
    if (this.Ynx) {
      this.RfU.aym(this.mContext.getResources().getColor(a.c.brand_text_color));
    }
    AppMethodBeat.o(159385);
    return this;
  }
  
  public final a a(ArrayList<String> paramArrayList, RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener, int paramInt)
  {
    AppMethodBeat.i(175622);
    View localView = View.inflate(this.mContext, a.g.dialog_radio_view, null);
    this.Yny = ((RadioGroup)localView.findViewById(a.f.radio_group));
    if (paramArrayList != null) {}
    for (int i = paramArrayList.size();; i = 0)
    {
      int j = 0;
      while (j < i)
      {
        RadioButton localRadioButton = (RadioButton)View.inflate(this.mContext, a.g.dialog_radio_item, null);
        localRadioButton.setId(j);
        if (j == paramInt) {
          localRadioButton.setChecked(true);
        }
        localRadioButton.setText((CharSequence)paramArrayList.get(j));
        this.Yny.addView(localRadioButton);
        j += 1;
      }
      this.Yny.setOnCheckedChangeListener(paramOnCheckedChangeListener);
      this.RfU.iI(localView);
      AppMethodBeat.o(175622);
      return this;
    }
  }
  
  public final a aR(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159375);
    int i = aw.fromDPToPix(this.mContext, (int)(20.0F * aw.ez(this.mContext)));
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      CharSequence localCharSequence = b.a(this.mContext, paramCharSequence.toString(), i);
      this.RfU.aO(localCharSequence);
    }
    this.RfU.aO(paramCharSequence);
    AppMethodBeat.o(159375);
    return this;
  }
  
  public final a aS(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159377);
    int i = aw.fromDPToPix(this.mContext, (int)(14.0F * aw.ez(this.mContext)));
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      CharSequence localCharSequence = b.a(this.mContext, paramCharSequence.toString(), i);
      this.RfU.aQ(localCharSequence);
    }
    this.RfU.aQ(paramCharSequence);
    AppMethodBeat.o(159377);
    return this;
  }
  
  public final a ayp(int paramInt)
  {
    AppMethodBeat.i(159383);
    this.Ynv = this.mContext.getResources().getString(paramInt);
    this.RfU.bBj(this.Ynv);
    AppMethodBeat.o(159383);
    return this;
  }
  
  public final a ayq(int paramInt)
  {
    AppMethodBeat.i(159384);
    this.RfU.ayl(paramInt);
    AppMethodBeat.o(159384);
    return this;
  }
  
  public final a ayr(int paramInt)
  {
    AppMethodBeat.i(249794);
    this.RfU.aym(paramInt);
    AppMethodBeat.o(249794);
    return this;
  }
  
  public final a b(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(159390);
    this.RfU.a(paramOnDismissListener);
    AppMethodBeat.o(159390);
    return this;
  }
  
  public final a b(f.c paramc)
  {
    AppMethodBeat.i(159387);
    if ((this.Ynv == null) || ((this.Ynv != null) && (this.Ynv.length() == 0))) {
      this.Ynv = this.mContext.getResources().getString(a.i.button_ok);
    }
    this.RfU.bBj(this.Ynv);
    this.RfU.c(new f.a.3(this, paramc));
    AppMethodBeat.o(159387);
    return this;
  }
  
  public final a bBl(String paramString)
  {
    AppMethodBeat.i(159376);
    this.RfU.bBd(paramString);
    AppMethodBeat.o(159376);
    return this;
  }
  
  public final a bBm(String paramString)
  {
    AppMethodBeat.i(159378);
    this.RfU.bBf(paramString);
    AppMethodBeat.o(159378);
    return this;
  }
  
  public final a bBn(String paramString)
  {
    AppMethodBeat.i(159381);
    this.RfU.bBh(paramString);
    AppMethodBeat.o(159381);
    return this;
  }
  
  public final a bBo(String paramString)
  {
    AppMethodBeat.i(159382);
    this.RfU.bBi(paramString);
    AppMethodBeat.o(159382);
    return this;
  }
  
  public final a bBp(String paramString)
  {
    AppMethodBeat.i(249789);
    this.Ynv = paramString;
    this.RfU.bBj(this.Ynv);
    AppMethodBeat.o(249789);
    return this;
  }
  
  public final a bBq(String paramString)
  {
    AppMethodBeat.i(249791);
    this.Ynw = paramString;
    this.RfU.bBk(this.Ynw);
    AppMethodBeat.o(249791);
    return this;
  }
  
  public final a br(String paramString1, String paramString2, String paramString3)
  {
    d.a locala = this.RfU;
    locala.Ymv.UVD = paramString1;
    locala.Ymv.UVE = paramString2;
    locala.Ymv.UVF = paramString3;
    return this;
  }
  
  public final a c(f.c paramc)
  {
    AppMethodBeat.i(159388);
    if (this.Yny != null) {
      this.Yny.setTag(this.mUO);
    }
    b(paramc);
    a(paramc);
    AppMethodBeat.o(159388);
    return this;
  }
  
  public final a iK(View paramView)
  {
    AppMethodBeat.i(159379);
    this.RfU.iI(paramView);
    AppMethodBeat.o(159379);
    return this;
  }
  
  public final a icD()
  {
    this.Qlf = true;
    return this;
  }
  
  public final d icE()
  {
    return this.mUO;
  }
  
  public final a icF()
  {
    AppMethodBeat.i(249800);
    this.RfU.ict();
    AppMethodBeat.o(249800);
    return this;
  }
  
  public final void show()
  {
    AppMethodBeat.i(159391);
    if ((this.mContext instanceof Activity))
    {
      if (this.mUO == null) {
        this.mUO = this.RfU.icu();
      }
      this.mUO.show();
      AppMethodBeat.o(159391);
      return;
    }
    AlertActivity.a(this.RfU);
    Object localObject = new Intent(this.mContext, AlertActivity.class);
    ((Intent)localObject).setFlags(335544320);
    Context localContext = this.mContext;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(159391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.f.a
 * JD-Core Version:    0.7.0.1
 */