package com.tencent.mm.ui.widget.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.AlertActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.f.c.b;

public final class e
{
  public static final class a
  {
    public String AHs;
    public String AHt;
    public boolean AHu;
    public boolean AHv;
    public RadioGroup AHw;
    public c gwf;
    public Context mContext;
    public final c.a vTt;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(112675);
      this.AHs = null;
      this.AHt = null;
      this.AHu = false;
      this.AHv = false;
      this.mContext = paramContext;
      this.vTt = new c.a(this.mContext);
      this.vTt.rG(false);
      this.vTt.rH(false);
      this.vTt.a(new c.a.d()
      {
        public final CharSequence a(CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
        {
          AppMethodBeat.i(112670);
          paramAnonymousCharSequence = b.c(e.a.this.mContext, paramAnonymousCharSequence, paramAnonymousFloat);
          AppMethodBeat.o(112670);
          return paramAnonymousCharSequence;
        }
      });
      AppMethodBeat.o(112675);
    }
    
    public final a Rm(int paramInt)
    {
      AppMethodBeat.i(112685);
      this.AHs = this.mContext.getResources().getString(paramInt);
      AppMethodBeat.o(112685);
      return this;
    }
    
    public final a Rn(int paramInt)
    {
      AppMethodBeat.i(112686);
      this.vTt.Rk(paramInt);
      AppMethodBeat.o(112686);
      return this;
    }
    
    public final a a(final e.b paramb)
    {
      AppMethodBeat.i(112691);
      if (this.AHw != null) {
        this.AHw.setTag(this.gwf);
      }
      if ((this.AHs == null) || ((this.AHs != null) && (this.AHs.length() == 0))) {
        this.AHs = this.mContext.getResources().getString(2131297828);
      }
      this.vTt.avs(this.AHs);
      this.vTt.a(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(112673);
          if (paramb != null)
          {
            if (paramAnonymousDialogInterface != null) {
              ((c)paramAnonymousDialogInterface).dOY();
            }
            if (paramAnonymousDialogInterface != null) {
              break label47;
            }
          }
          label47:
          for (boolean bool = false;; bool = ((c)paramAnonymousDialogInterface).VR.isChecked())
          {
            paramb.u(true, bool);
            AppMethodBeat.o(112673);
            return;
          }
        }
      });
      if ((this.AHt == null) || ((this.AHt != null) && (this.AHt.length() == 0))) {
        this.AHt = this.mContext.getResources().getString(2131297827);
      }
      this.vTt.avt(this.AHt);
      if (!this.AHv) {
        this.vTt.b(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(112674);
            if (paramb != null) {
              if (paramAnonymousDialogInterface != null) {
                break label35;
              }
            }
            label35:
            for (boolean bool = false;; bool = ((c)paramAnonymousDialogInterface).VR.isChecked())
            {
              paramb.u(false, bool);
              AppMethodBeat.o(112674);
              return;
            }
          }
        });
      }
      AppMethodBeat.o(112691);
      return this;
    }
    
    public final a a(final e.c paramc)
    {
      AppMethodBeat.i(112688);
      if ((this.AHt == null) || ((this.AHt != null) && (this.AHt.length() == 0))) {
        this.AHt = this.mContext.getResources().getString(2131297827);
      }
      this.vTt.avt(this.AHt);
      if (!this.AHv) {
        this.vTt.b(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(112671);
            if (paramc != null) {
              paramc.d(false, null);
            }
            AppMethodBeat.o(112671);
          }
        });
      }
      AppMethodBeat.o(112688);
      return this;
    }
    
    public final a a(e.c paramc1, e.c paramc2)
    {
      AppMethodBeat.i(112687);
      if (this.AHw != null) {
        this.AHw.setTag(this.gwf);
      }
      a(paramc1);
      b(paramc2);
      if (this.AHu) {
        this.vTt.Rl(this.mContext.getResources().getColor(2131689778));
      }
      AppMethodBeat.o(112687);
      return this;
    }
    
    public final a aj(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(112677);
      int i = al.fromDPToPix(this.mContext, (int)(20.0F * al.dr(this.mContext)));
      if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
      {
        CharSequence localCharSequence = b.h(this.mContext, paramCharSequence.toString(), i);
        this.vTt.ag(localCharSequence);
      }
      this.vTt.ag(paramCharSequence);
      AppMethodBeat.o(112677);
      return this;
    }
    
    public final a ak(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(112679);
      int i = al.fromDPToPix(this.mContext, (int)(14.0F * al.dr(this.mContext)));
      if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
      {
        CharSequence localCharSequence = b.h(this.mContext, paramCharSequence.toString(), i);
        this.vTt.ai(localCharSequence);
      }
      this.vTt.ai(paramCharSequence);
      AppMethodBeat.o(112679);
      return this;
    }
    
    public final a avu(String paramString)
    {
      AppMethodBeat.i(112678);
      this.vTt.avn(paramString);
      AppMethodBeat.o(112678);
      return this;
    }
    
    public final a avv(String paramString)
    {
      AppMethodBeat.i(112680);
      this.vTt.avo(paramString);
      AppMethodBeat.o(112680);
      return this;
    }
    
    public final a avw(String paramString)
    {
      AppMethodBeat.i(112683);
      this.vTt.avq(paramString);
      AppMethodBeat.o(112683);
      return this;
    }
    
    public final a avx(String paramString)
    {
      AppMethodBeat.i(112684);
      this.vTt.avr(paramString);
      AppMethodBeat.o(112684);
      return this;
    }
    
    public final a avy(String paramString)
    {
      this.AHs = paramString;
      return this;
    }
    
    public final a b(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(112692);
      this.vTt.a(paramOnDismissListener);
      AppMethodBeat.o(112692);
      return this;
    }
    
    public final a b(final e.c paramc)
    {
      AppMethodBeat.i(112689);
      if ((this.AHs == null) || ((this.AHs != null) && (this.AHs.length() == 0))) {
        this.AHs = this.mContext.getResources().getString(2131297828);
      }
      this.vTt.avs(this.AHs);
      this.vTt.a(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(112672);
          if (paramc != null) {
            if (paramAnonymousDialogInterface != null) {
              break label35;
            }
          }
          label35:
          for (paramAnonymousDialogInterface = null;; paramAnonymousDialogInterface = ((c)paramAnonymousDialogInterface).dOY())
          {
            paramc.d(true, paramAnonymousDialogInterface);
            AppMethodBeat.o(112672);
            return;
          }
        }
      });
      AppMethodBeat.o(112689);
      return this;
    }
    
    public final a c(e.c paramc)
    {
      AppMethodBeat.i(112690);
      if (this.AHw != null) {
        this.AHw.setTag(this.gwf);
      }
      b(paramc);
      a(paramc);
      AppMethodBeat.o(112690);
      return this;
    }
    
    public final a fv(View paramView)
    {
      AppMethodBeat.i(112681);
      this.vTt.fu(paramView);
      AppMethodBeat.o(112681);
      return this;
    }
    
    public final a n(Boolean paramBoolean)
    {
      AppMethodBeat.i(112682);
      this.vTt.rF(paramBoolean.booleanValue());
      AppMethodBeat.o(112682);
      return this;
    }
    
    public final a rI(boolean paramBoolean)
    {
      AppMethodBeat.i(112676);
      this.vTt.rG(paramBoolean);
      this.vTt.rH(paramBoolean);
      AppMethodBeat.o(112676);
      return this;
    }
    
    public final void show()
    {
      AppMethodBeat.i(112693);
      if ((this.mContext instanceof Activity))
      {
        if (this.gwf == null) {
          this.gwf = this.vTt.aLZ();
        }
        this.gwf.show();
        AppMethodBeat.o(112693);
        return;
      }
      AlertActivity.a(this.vTt);
      Intent localIntent = new Intent(this.mContext, AlertActivity.class);
      localIntent.setFlags(335544320);
      this.mContext.startActivity(localIntent);
      AppMethodBeat.o(112693);
    }
  }
  
  public static abstract interface b
  {
    public abstract void u(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  public static abstract interface c
  {
    public abstract void d(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.e
 * JD-Core Version:    0.7.0.1
 */