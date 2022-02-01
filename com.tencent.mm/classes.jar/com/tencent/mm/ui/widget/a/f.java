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
    public final d.a DqR;
    private String JfV;
    private String JfW;
    private boolean JfX;
    public boolean JfY;
    private RadioGroup JfZ;
    public d iJj;
    Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159373);
      this.JfV = null;
      this.JfW = null;
      this.JfX = false;
      this.JfY = false;
      this.mContext = paramContext;
      this.DqR = new d.a(this.mContext);
      this.DqR.yf(false);
      this.DqR.yg(false);
      this.DqR.a(new d.a.d()
      {
        public final CharSequence a(CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
        {
          AppMethodBeat.i(159368);
          paramAnonymousCharSequence = b.c(f.a.this.mContext, paramAnonymousCharSequence, paramAnonymousFloat);
          AppMethodBeat.o(159368);
          return paramAnonymousCharSequence;
        }
      });
      this.JfW = this.mContext.getResources().getString(2131756755);
      this.JfV = this.mContext.getResources().getString(2131756757);
      AppMethodBeat.o(159373);
    }
    
    public final a a(final f.b paramb)
    {
      AppMethodBeat.i(159389);
      if (this.JfZ != null) {
        this.JfZ.setTag(this.iJj);
      }
      if ((this.JfV == null) || ((this.JfV != null) && (this.JfV.length() == 0))) {
        this.JfV = this.mContext.getResources().getString(2131756757);
      }
      this.DqR.aRO(this.JfV);
      this.DqR.b(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(159371);
          if (paramb != null)
          {
            if (paramAnonymousDialogInterface != null) {
              ((d)paramAnonymousDialogInterface).fvm();
            }
            if (paramAnonymousDialogInterface != null) {
              break label47;
            }
          }
          label47:
          for (boolean bool = false;; bool = ((d)paramAnonymousDialogInterface).adQ.isChecked())
          {
            paramb.D(true, bool);
            AppMethodBeat.o(159371);
            return;
          }
        }
      });
      if ((this.JfW == null) || ((this.JfW != null) && (this.JfW.length() == 0))) {
        this.JfW = this.mContext.getResources().getString(2131756755);
      }
      this.DqR.aRP(this.JfW);
      if (!this.JfY) {
        this.DqR.c(new DialogInterface.OnClickListener()
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
            for (boolean bool = false;; bool = ((d)paramAnonymousDialogInterface).adQ.isChecked())
            {
              paramb.D(false, bool);
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
      if ((this.JfW == null) || ((this.JfW != null) && (this.JfW.length() == 0))) {
        this.JfW = this.mContext.getResources().getString(2131756755);
      }
      this.DqR.aRP(this.JfW);
      if (!this.JfY) {
        this.DqR.c(new DialogInterface.OnClickListener()
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
      if (this.JfZ != null) {
        this.JfZ.setTag(this.iJj);
      }
      a(paramc1);
      b(paramc2);
      if (this.JfX) {
        this.DqR.acP(this.mContext.getResources().getColor(2131100035));
      }
      AppMethodBeat.o(159385);
      return this;
    }
    
    public final a a(ArrayList<String> paramArrayList, RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener, int paramInt)
    {
      AppMethodBeat.i(175622);
      View localView = View.inflate(this.mContext, 2131493715, null);
      this.JfZ = ((RadioGroup)localView.findViewById(2131303707));
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
          this.JfZ.addView(localRadioButton);
          j += 1;
        }
        this.JfZ.setOnCheckedChangeListener(paramOnCheckedChangeListener);
        this.DqR.gH(localView);
        AppMethodBeat.o(175622);
        return this;
      }
    }
    
    public final a aRQ(String paramString)
    {
      AppMethodBeat.i(159376);
      this.DqR.aRI(paramString);
      AppMethodBeat.o(159376);
      return this;
    }
    
    public final a aRR(String paramString)
    {
      AppMethodBeat.i(159378);
      this.DqR.aRK(paramString);
      AppMethodBeat.o(159378);
      return this;
    }
    
    public final a aRS(String paramString)
    {
      AppMethodBeat.i(159381);
      this.DqR.aRM(paramString);
      AppMethodBeat.o(159381);
      return this;
    }
    
    public final a aRT(String paramString)
    {
      AppMethodBeat.i(159382);
      this.DqR.aRN(paramString);
      AppMethodBeat.o(159382);
      return this;
    }
    
    public final a aRU(String paramString)
    {
      AppMethodBeat.i(199682);
      this.JfV = paramString;
      this.DqR.aRO(this.JfV);
      AppMethodBeat.o(199682);
      return this;
    }
    
    public final a aRV(String paramString)
    {
      AppMethodBeat.i(199683);
      this.JfW = paramString;
      this.DqR.aRP(this.JfW);
      AppMethodBeat.o(199683);
      return this;
    }
    
    public final a acQ(int paramInt)
    {
      AppMethodBeat.i(159383);
      this.JfV = this.mContext.getResources().getString(paramInt);
      this.DqR.aRO(this.JfV);
      AppMethodBeat.o(159383);
      return this;
    }
    
    public final a acR(int paramInt)
    {
      AppMethodBeat.i(159384);
      this.DqR.acO(paramInt);
      AppMethodBeat.o(159384);
      return this;
    }
    
    public final a av(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(159375);
      int i = ao.fromDPToPix(this.mContext, (int)(20.0F * ao.eb(this.mContext)));
      if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
      {
        CharSequence localCharSequence = b.h(this.mContext, paramCharSequence.toString(), i);
        this.DqR.as(localCharSequence);
      }
      this.DqR.as(paramCharSequence);
      AppMethodBeat.o(159375);
      return this;
    }
    
    public final a aw(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(159377);
      int i = ao.fromDPToPix(this.mContext, (int)(14.0F * ao.eb(this.mContext)));
      if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
      {
        CharSequence localCharSequence = b.h(this.mContext, paramCharSequence.toString(), i);
        this.DqR.au(localCharSequence);
      }
      this.DqR.au(paramCharSequence);
      AppMethodBeat.o(159377);
      return this;
    }
    
    public final a b(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(159390);
      this.DqR.a(paramOnDismissListener);
      AppMethodBeat.o(159390);
      return this;
    }
    
    public final a b(final f.c paramc)
    {
      AppMethodBeat.i(159387);
      if ((this.JfV == null) || ((this.JfV != null) && (this.JfV.length() == 0))) {
        this.JfV = this.mContext.getResources().getString(2131756757);
      }
      this.DqR.aRO(this.JfV);
      this.DqR.b(new DialogInterface.OnClickListener()
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
          for (paramAnonymousDialogInterface = null;; paramAnonymousDialogInterface = ((d)paramAnonymousDialogInterface).fvm())
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
      if (this.JfZ != null) {
        this.JfZ.setTag(this.iJj);
      }
      b(paramc);
      a(paramc);
      AppMethodBeat.o(159388);
      return this;
    }
    
    public final a fvx()
    {
      this.JfY = true;
      return this;
    }
    
    public final a gK(View paramView)
    {
      AppMethodBeat.i(159379);
      this.DqR.gH(paramView);
      AppMethodBeat.o(159379);
      return this;
    }
    
    public final a p(Boolean paramBoolean)
    {
      AppMethodBeat.i(159380);
      this.DqR.ye(paramBoolean.booleanValue());
      AppMethodBeat.o(159380);
      return this;
    }
    
    public final void show()
    {
      AppMethodBeat.i(159391);
      if ((this.mContext instanceof Activity))
      {
        if (this.iJj == null) {
          this.iJj = this.DqR.fvp();
        }
        this.iJj.show();
        AppMethodBeat.o(159391);
        return;
      }
      AlertActivity.a(this.DqR);
      Object localObject = new Intent(this.mContext, AlertActivity.class);
      ((Intent)localObject).setFlags(335544320);
      Context localContext = this.mContext;
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(159391);
    }
    
    public final a yi(boolean paramBoolean)
    {
      AppMethodBeat.i(159374);
      this.DqR.yf(paramBoolean);
      this.DqR.yg(paramBoolean);
      AppMethodBeat.o(159374);
      return this;
    }
  }
  
  public static abstract interface b
  {
    public abstract void D(boolean paramBoolean1, boolean paramBoolean2);
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