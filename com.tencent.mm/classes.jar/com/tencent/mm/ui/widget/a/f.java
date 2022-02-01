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
import com.tencent.mm.ui.AlertActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.f.c.b;
import java.util.ArrayList;

public final class f
{
  public static final class a
  {
    public final d.a BYA;
    private boolean HFA;
    public boolean HFB;
    private RadioGroup HFC;
    private String HFy;
    private String HFz;
    public d ijc;
    Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159373);
      this.HFy = null;
      this.HFz = null;
      this.HFA = false;
      this.HFB = false;
      this.mContext = paramContext;
      this.BYA = new d.a(this.mContext);
      this.BYA.wX(false);
      this.BYA.wY(false);
      this.BYA.a(new d.a.d()
      {
        public final CharSequence a(CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
        {
          AppMethodBeat.i(159368);
          paramAnonymousCharSequence = b.c(f.a.this.mContext, paramAnonymousCharSequence, paramAnonymousFloat);
          AppMethodBeat.o(159368);
          return paramAnonymousCharSequence;
        }
      });
      this.HFz = this.mContext.getResources().getString(2131756755);
      this.HFy = this.mContext.getResources().getString(2131756757);
      AppMethodBeat.o(159373);
    }
    
    public final a a(final f.b paramb)
    {
      AppMethodBeat.i(159389);
      if (this.HFC != null) {
        this.HFC.setTag(this.ijc);
      }
      if ((this.HFy == null) || ((this.HFy != null) && (this.HFy.length() == 0))) {
        this.HFy = this.mContext.getResources().getString(2131756757);
      }
      this.BYA.aMm(this.HFy);
      this.BYA.b(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(159371);
          if (paramb != null)
          {
            if (paramAnonymousDialogInterface != null) {
              ((d)paramAnonymousDialogInterface).ffq();
            }
            if (paramAnonymousDialogInterface != null) {
              break label47;
            }
          }
          label47:
          for (boolean bool = false;; bool = ((d)paramAnonymousDialogInterface).acW.isChecked())
          {
            paramb.C(true, bool);
            AppMethodBeat.o(159371);
            return;
          }
        }
      });
      if ((this.HFz == null) || ((this.HFz != null) && (this.HFz.length() == 0))) {
        this.HFz = this.mContext.getResources().getString(2131756755);
      }
      this.BYA.aMn(this.HFz);
      if (!this.HFB) {
        this.BYA.c(new DialogInterface.OnClickListener()
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
            for (boolean bool = false;; bool = ((d)paramAnonymousDialogInterface).acW.isChecked())
            {
              paramb.C(false, bool);
              AppMethodBeat.o(159372);
              return;
            }
          }
        });
      }
      AppMethodBeat.o(159389);
      return this;
    }
    
    public final a a(final f.c paramc)
    {
      AppMethodBeat.i(159386);
      if ((this.HFz == null) || ((this.HFz != null) && (this.HFz.length() == 0))) {
        this.HFz = this.mContext.getResources().getString(2131756755);
      }
      this.BYA.aMn(this.HFz);
      if (!this.HFB) {
        this.BYA.c(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(159369);
            if (paramc != null) {
              paramc.d(false, null);
            }
            AppMethodBeat.o(159369);
          }
        });
      }
      AppMethodBeat.o(159386);
      return this;
    }
    
    public final a a(f.c paramc1, f.c paramc2)
    {
      AppMethodBeat.i(159385);
      if (this.HFC != null) {
        this.HFC.setTag(this.ijc);
      }
      a(paramc1);
      b(paramc2);
      if (this.HFA) {
        this.BYA.aaE(this.mContext.getResources().getColor(2131100035));
      }
      AppMethodBeat.o(159385);
      return this;
    }
    
    public final a a(ArrayList<String> paramArrayList, RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener, int paramInt)
    {
      AppMethodBeat.i(175622);
      View localView = View.inflate(this.mContext, 2131493715, null);
      this.HFC = ((RadioGroup)localView.findViewById(2131303707));
      if (paramArrayList != null) {}
      for (int i = paramArrayList.size();; i = 0)
      {
        int j = 0;
        while (j < i)
        {
          RadioButton localRadioButton = (RadioButton)View.inflate(this.mContext, 2131493714, null);
          localRadioButton.setId(j);
          if (j == paramInt) {
            localRadioButton.setChecked(true);
          }
          localRadioButton.setText((CharSequence)paramArrayList.get(j));
          this.HFC.addView(localRadioButton);
          j += 1;
        }
        this.HFC.setOnCheckedChangeListener(paramOnCheckedChangeListener);
        this.BYA.gs(localView);
        AppMethodBeat.o(175622);
        return this;
      }
    }
    
    public final a aMo(String paramString)
    {
      AppMethodBeat.i(159376);
      this.BYA.aMg(paramString);
      AppMethodBeat.o(159376);
      return this;
    }
    
    public final a aMp(String paramString)
    {
      AppMethodBeat.i(159378);
      this.BYA.aMi(paramString);
      AppMethodBeat.o(159378);
      return this;
    }
    
    public final a aMq(String paramString)
    {
      AppMethodBeat.i(159381);
      this.BYA.aMk(paramString);
      AppMethodBeat.o(159381);
      return this;
    }
    
    public final a aMr(String paramString)
    {
      AppMethodBeat.i(159382);
      this.BYA.aMl(paramString);
      AppMethodBeat.o(159382);
      return this;
    }
    
    public final a aMs(String paramString)
    {
      AppMethodBeat.i(195211);
      this.HFy = paramString;
      this.BYA.aMm(this.HFy);
      AppMethodBeat.o(195211);
      return this;
    }
    
    public final a aMt(String paramString)
    {
      AppMethodBeat.i(195212);
      this.HFz = paramString;
      this.BYA.aMn(this.HFz);
      AppMethodBeat.o(195212);
      return this;
    }
    
    public final a aaF(int paramInt)
    {
      AppMethodBeat.i(159383);
      this.HFy = this.mContext.getResources().getString(paramInt);
      this.BYA.aMm(this.HFy);
      AppMethodBeat.o(159383);
      return this;
    }
    
    public final a aaG(int paramInt)
    {
      AppMethodBeat.i(159384);
      this.BYA.aaD(paramInt);
      AppMethodBeat.o(159384);
      return this;
    }
    
    public final a au(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(159375);
      int i = ao.fromDPToPix(this.mContext, (int)(20.0F * ao.dT(this.mContext)));
      if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
      {
        CharSequence localCharSequence = b.g(this.mContext, paramCharSequence.toString(), i);
        this.BYA.ar(localCharSequence);
      }
      this.BYA.ar(paramCharSequence);
      AppMethodBeat.o(159375);
      return this;
    }
    
    public final a av(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(159377);
      int i = ao.fromDPToPix(this.mContext, (int)(14.0F * ao.dT(this.mContext)));
      if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
      {
        CharSequence localCharSequence = b.g(this.mContext, paramCharSequence.toString(), i);
        this.BYA.at(localCharSequence);
      }
      this.BYA.at(paramCharSequence);
      AppMethodBeat.o(159377);
      return this;
    }
    
    public final a b(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(159390);
      this.BYA.a(paramOnDismissListener);
      AppMethodBeat.o(159390);
      return this;
    }
    
    public final a b(final f.c paramc)
    {
      AppMethodBeat.i(159387);
      if ((this.HFy == null) || ((this.HFy != null) && (this.HFy.length() == 0))) {
        this.HFy = this.mContext.getResources().getString(2131756757);
      }
      this.BYA.aMm(this.HFy);
      this.BYA.b(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(159370);
          if (paramc != null) {
            if (paramAnonymousDialogInterface != null) {
              break label35;
            }
          }
          label35:
          for (paramAnonymousDialogInterface = null;; paramAnonymousDialogInterface = ((d)paramAnonymousDialogInterface).ffq())
          {
            paramc.d(true, paramAnonymousDialogInterface);
            AppMethodBeat.o(159370);
            return;
          }
        }
      });
      AppMethodBeat.o(159387);
      return this;
    }
    
    public final a c(f.c paramc)
    {
      AppMethodBeat.i(159388);
      if (this.HFC != null) {
        this.HFC.setTag(this.ijc);
      }
      b(paramc);
      a(paramc);
      AppMethodBeat.o(159388);
      return this;
    }
    
    public final a gan()
    {
      this.HFB = true;
      return this;
    }
    
    public final a gu(View paramView)
    {
      AppMethodBeat.i(159379);
      this.BYA.gs(paramView);
      AppMethodBeat.o(159379);
      return this;
    }
    
    public final a p(Boolean paramBoolean)
    {
      AppMethodBeat.i(159380);
      this.BYA.wW(paramBoolean.booleanValue());
      AppMethodBeat.o(159380);
      return this;
    }
    
    public final void show()
    {
      AppMethodBeat.i(159391);
      if ((this.mContext instanceof Activity))
      {
        if (this.ijc == null) {
          this.ijc = this.BYA.fft();
        }
        this.ijc.show();
        AppMethodBeat.o(159391);
        return;
      }
      AlertActivity.a(this.BYA);
      Object localObject = new Intent(this.mContext, AlertActivity.class);
      ((Intent)localObject).setFlags(335544320);
      Context localContext = this.mContext;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(159391);
    }
    
    public final a wZ(boolean paramBoolean)
    {
      AppMethodBeat.i(159374);
      this.BYA.wX(paramBoolean);
      this.BYA.wY(paramBoolean);
      AppMethodBeat.o(159374);
      return this;
    }
  }
  
  public static abstract interface b
  {
    public abstract void C(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  public static abstract interface c
  {
    public abstract void d(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.f
 * JD-Core Version:    0.7.0.1
 */