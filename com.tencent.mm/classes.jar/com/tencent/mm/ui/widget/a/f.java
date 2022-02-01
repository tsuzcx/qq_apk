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
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.g.c.b;
import java.util.ArrayList;

public final class f
{
  public static final class a
  {
    public boolean JnN;
    public final d.a Kfg;
    private String QOJ;
    private String QOK;
    private boolean QOL;
    private RadioGroup QOM;
    public d kdo;
    Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159373);
      this.QOJ = null;
      this.QOK = null;
      this.QOL = false;
      this.JnN = false;
      this.mContext = paramContext;
      this.Kfg = new d.a(this.mContext);
      this.Kfg.Dk(false);
      this.Kfg.Dl(false);
      this.Kfg.a(new d.a.d()
      {
        public final CharSequence a(CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
        {
          AppMethodBeat.i(159368);
          paramAnonymousCharSequence = b.c(f.a.this.mContext, paramAnonymousCharSequence, paramAnonymousFloat);
          AppMethodBeat.o(159368);
          return paramAnonymousCharSequence;
        }
      });
      this.QOK = this.mContext.getResources().getString(2131756918);
      this.QOJ = this.mContext.getResources().getString(2131756920);
      AppMethodBeat.o(159373);
    }
    
    public final a Dq(boolean paramBoolean)
    {
      AppMethodBeat.i(159374);
      this.Kfg.Dk(paramBoolean);
      this.Kfg.Dl(paramBoolean);
      AppMethodBeat.o(159374);
      return this;
    }
    
    public final a a(final f.b paramb)
    {
      AppMethodBeat.i(159389);
      if (this.QOM != null) {
        this.QOM.setTag(this.kdo);
      }
      if ((this.QOJ == null) || ((this.QOJ != null) && (this.QOJ.length() == 0))) {
        this.QOJ = this.mContext.getResources().getString(2131756920);
      }
      this.Kfg.bou(this.QOJ);
      this.Kfg.c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(159371);
          if (paramb != null)
          {
            if (paramAnonymousDialogInterface != null) {
              ((d)paramAnonymousDialogInterface).hbk();
            }
            if (paramAnonymousDialogInterface != null) {
              break label47;
            }
          }
          label47:
          for (boolean bool = false;; bool = ((d)paramAnonymousDialogInterface).afU.isChecked())
          {
            paramb.D(true, bool);
            AppMethodBeat.o(159371);
            return;
          }
        }
      });
      if ((this.QOK == null) || ((this.QOK != null) && (this.QOK.length() == 0))) {
        this.QOK = this.mContext.getResources().getString(2131756918);
      }
      this.Kfg.bov(this.QOK);
      if (!this.JnN) {
        this.Kfg.d(new DialogInterface.OnClickListener()
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
            for (boolean bool = false;; bool = ((d)paramAnonymousDialogInterface).afU.isChecked())
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
      if ((this.QOK == null) || ((this.QOK != null) && (this.QOK.length() == 0))) {
        this.QOK = this.mContext.getResources().getString(2131756918);
      }
      this.Kfg.bov(this.QOK);
      if (!this.JnN) {
        this.Kfg.d(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(159369);
            if (paramc != null) {
              paramc.e(false, null);
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
      if (this.QOM != null) {
        this.QOM.setTag(this.kdo);
      }
      a(paramc1);
      b(paramc2);
      if (this.QOL) {
        this.Kfg.aoY(this.mContext.getResources().getColor(2131100063));
      }
      AppMethodBeat.o(159385);
      return this;
    }
    
    public final a a(ArrayList<String> paramArrayList, RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener, int paramInt)
    {
      AppMethodBeat.i(175622);
      View localView = View.inflate(this.mContext, 2131493848, null);
      this.QOM = ((RadioGroup)localView.findViewById(2131306493));
      if (paramArrayList != null) {}
      for (int i = paramArrayList.size();; i = 0)
      {
        int j = 0;
        while (j < i)
        {
          RadioButton localRadioButton = (RadioButton)View.inflate(this.mContext, 2131493847, null);
          localRadioButton.setId(j);
          if (j == paramInt) {
            localRadioButton.setChecked(true);
          }
          localRadioButton.setText((CharSequence)paramArrayList.get(j));
          this.QOM.addView(localRadioButton);
          j += 1;
        }
        this.QOM.setOnCheckedChangeListener(paramOnCheckedChangeListener);
        this.Kfg.hs(localView);
        AppMethodBeat.o(175622);
        return this;
      }
    }
    
    public final a aC(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(159375);
      int i = at.fromDPToPix(this.mContext, (int)(20.0F * at.ez(this.mContext)));
      if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
      {
        CharSequence localCharSequence = b.a(this.mContext, paramCharSequence.toString(), i);
        this.Kfg.az(localCharSequence);
      }
      this.Kfg.az(paramCharSequence);
      AppMethodBeat.o(159375);
      return this;
    }
    
    public final a aD(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(159377);
      int i = at.fromDPToPix(this.mContext, (int)(14.0F * at.ez(this.mContext)));
      if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
      {
        CharSequence localCharSequence = b.a(this.mContext, paramCharSequence.toString(), i);
        this.Kfg.aB(localCharSequence);
      }
      this.Kfg.aB(paramCharSequence);
      AppMethodBeat.o(159377);
      return this;
    }
    
    public final a apa(int paramInt)
    {
      AppMethodBeat.i(159383);
      this.QOJ = this.mContext.getResources().getString(paramInt);
      this.Kfg.bou(this.QOJ);
      AppMethodBeat.o(159383);
      return this;
    }
    
    public final a apb(int paramInt)
    {
      AppMethodBeat.i(159384);
      this.Kfg.aoX(paramInt);
      AppMethodBeat.o(159384);
      return this;
    }
    
    public final a apc(int paramInt)
    {
      AppMethodBeat.i(198249);
      this.Kfg.aoY(paramInt);
      AppMethodBeat.o(198249);
      return this;
    }
    
    public final a b(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(159390);
      this.Kfg.a(paramOnDismissListener);
      AppMethodBeat.o(159390);
      return this;
    }
    
    public final a b(final f.c paramc)
    {
      AppMethodBeat.i(159387);
      if ((this.QOJ == null) || ((this.QOJ != null) && (this.QOJ.length() == 0))) {
        this.QOJ = this.mContext.getResources().getString(2131756920);
      }
      this.Kfg.bou(this.QOJ);
      this.Kfg.c(new DialogInterface.OnClickListener()
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
          for (paramAnonymousDialogInterface = null;; paramAnonymousDialogInterface = ((d)paramAnonymousDialogInterface).hbk())
          {
            paramc.e(true, paramAnonymousDialogInterface);
            AppMethodBeat.o(159370);
            return;
          }
        }
      });
      AppMethodBeat.o(159387);
      return this;
    }
    
    public final a boA(String paramString)
    {
      AppMethodBeat.i(198247);
      this.QOJ = paramString;
      this.Kfg.bou(this.QOJ);
      AppMethodBeat.o(198247);
      return this;
    }
    
    public final a boB(String paramString)
    {
      AppMethodBeat.i(198248);
      this.QOK = paramString;
      this.Kfg.bov(this.QOK);
      AppMethodBeat.o(198248);
      return this;
    }
    
    public final a bow(String paramString)
    {
      AppMethodBeat.i(159376);
      this.Kfg.boo(paramString);
      AppMethodBeat.o(159376);
      return this;
    }
    
    public final a box(String paramString)
    {
      AppMethodBeat.i(159378);
      this.Kfg.boq(paramString);
      AppMethodBeat.o(159378);
      return this;
    }
    
    public final a boy(String paramString)
    {
      AppMethodBeat.i(159381);
      this.Kfg.bos(paramString);
      AppMethodBeat.o(159381);
      return this;
    }
    
    public final a boz(String paramString)
    {
      AppMethodBeat.i(159382);
      this.Kfg.bot(paramString);
      AppMethodBeat.o(159382);
      return this;
    }
    
    public final a c(f.c paramc)
    {
      AppMethodBeat.i(159388);
      if (this.QOM != null) {
        this.QOM.setTag(this.kdo);
      }
      b(paramc);
      a(paramc);
      AppMethodBeat.o(159388);
      return this;
    }
    
    public final a hbu()
    {
      this.JnN = true;
      return this;
    }
    
    public final d hbv()
    {
      return this.kdo;
    }
    
    public final a hu(View paramView)
    {
      AppMethodBeat.i(159379);
      this.Kfg.hs(paramView);
      AppMethodBeat.o(159379);
      return this;
    }
    
    public final void show()
    {
      AppMethodBeat.i(159391);
      if ((this.mContext instanceof Activity))
      {
        if (this.kdo == null) {
          this.kdo = this.Kfg.hbn();
        }
        this.kdo.show();
        AppMethodBeat.o(159391);
        return;
      }
      AlertActivity.a(this.Kfg);
      Object localObject = new Intent(this.mContext, AlertActivity.class);
      ((Intent)localObject).setFlags(335544320);
      Context localContext = this.mContext;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(159391);
    }
    
    public final a u(Boolean paramBoolean)
    {
      AppMethodBeat.i(159380);
      this.Kfg.Dj(paramBoolean.booleanValue());
      AppMethodBeat.o(159380);
      return this;
    }
  }
  
  public static abstract interface b
  {
    public abstract void D(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  public static abstract interface c
  {
    public abstract void e(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.f
 * JD-Core Version:    0.7.0.1
 */