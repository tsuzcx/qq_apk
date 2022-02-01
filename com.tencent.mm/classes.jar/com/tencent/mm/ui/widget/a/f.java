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
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.f.c.b;
import java.util.ArrayList;

public final class f
{
  public static final class a
  {
    public final d.a EVU;
    public boolean EgK;
    private String KXj;
    private String KXk;
    private boolean KXl;
    private RadioGroup KXm;
    public d jcs;
    Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159373);
      this.KXj = null;
      this.KXk = null;
      this.KXl = false;
      this.EgK = false;
      this.mContext = paramContext;
      this.EVU = new d.a(this.mContext);
      this.EVU.yR(false);
      this.EVU.yS(false);
      this.EVU.a(new d.a.d()
      {
        public final CharSequence a(CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
        {
          AppMethodBeat.i(159368);
          paramAnonymousCharSequence = b.c(f.a.this.mContext, paramAnonymousCharSequence, paramAnonymousFloat);
          AppMethodBeat.o(159368);
          return paramAnonymousCharSequence;
        }
      });
      this.KXk = this.mContext.getResources().getString(2131756755);
      this.KXj = this.mContext.getResources().getString(2131756757);
      AppMethodBeat.o(159373);
    }
    
    public final a a(final f.b paramb)
    {
      AppMethodBeat.i(159389);
      if (this.KXm != null) {
        this.KXm.setTag(this.jcs);
      }
      if ((this.KXj == null) || ((this.KXj != null) && (this.KXj.length() == 0))) {
        this.KXj = this.mContext.getResources().getString(2131756757);
      }
      this.EVU.aXM(this.KXj);
      this.EVU.c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(159371);
          if (paramb != null)
          {
            if (paramAnonymousDialogInterface != null) {
              ((d)paramAnonymousDialogInterface).fLY();
            }
            if (paramAnonymousDialogInterface != null) {
              break label47;
            }
          }
          label47:
          for (boolean bool = false;; bool = ((d)paramAnonymousDialogInterface).afH.isChecked())
          {
            paramb.E(true, bool);
            AppMethodBeat.o(159371);
            return;
          }
        }
      });
      if ((this.KXk == null) || ((this.KXk != null) && (this.KXk.length() == 0))) {
        this.KXk = this.mContext.getResources().getString(2131756755);
      }
      this.EVU.aXN(this.KXk);
      if (!this.EgK) {
        this.EVU.d(new DialogInterface.OnClickListener()
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
            for (boolean bool = false;; bool = ((d)paramAnonymousDialogInterface).afH.isChecked())
            {
              paramb.E(false, bool);
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
      if ((this.KXk == null) || ((this.KXk != null) && (this.KXk.length() == 0))) {
        this.KXk = this.mContext.getResources().getString(2131756755);
      }
      this.EVU.aXN(this.KXk);
      if (!this.EgK) {
        this.EVU.d(new DialogInterface.OnClickListener()
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
      if (this.KXm != null) {
        this.KXm.setTag(this.jcs);
      }
      a(paramc1);
      b(paramc2);
      if (this.KXl) {
        this.EVU.afo(this.mContext.getResources().getColor(2131100035));
      }
      AppMethodBeat.o(159385);
      return this;
    }
    
    public final a a(ArrayList<String> paramArrayList, RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener, int paramInt)
    {
      AppMethodBeat.i(175622);
      View localView = View.inflate(this.mContext, 2131493715, null);
      this.KXm = ((RadioGroup)localView.findViewById(2131303707));
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
          this.KXm.addView(localRadioButton);
          j += 1;
        }
        this.KXm.setOnCheckedChangeListener(paramOnCheckedChangeListener);
        this.EVU.gY(localView);
        AppMethodBeat.o(175622);
        return this;
      }
    }
    
    public final a aXO(String paramString)
    {
      AppMethodBeat.i(159376);
      this.EVU.aXG(paramString);
      AppMethodBeat.o(159376);
      return this;
    }
    
    public final a aXP(String paramString)
    {
      AppMethodBeat.i(159378);
      this.EVU.aXI(paramString);
      AppMethodBeat.o(159378);
      return this;
    }
    
    public final a aXQ(String paramString)
    {
      AppMethodBeat.i(159381);
      this.EVU.aXK(paramString);
      AppMethodBeat.o(159381);
      return this;
    }
    
    public final a aXR(String paramString)
    {
      AppMethodBeat.i(159382);
      this.EVU.aXL(paramString);
      AppMethodBeat.o(159382);
      return this;
    }
    
    public final a aXS(String paramString)
    {
      AppMethodBeat.i(192599);
      this.KXj = paramString;
      this.EVU.aXM(this.KXj);
      AppMethodBeat.o(192599);
      return this;
    }
    
    public final a aXT(String paramString)
    {
      AppMethodBeat.i(192600);
      this.KXk = paramString;
      this.EVU.aXN(this.KXk);
      AppMethodBeat.o(192600);
      return this;
    }
    
    public final a afp(int paramInt)
    {
      AppMethodBeat.i(159383);
      this.KXj = this.mContext.getResources().getString(paramInt);
      this.EVU.aXM(this.KXj);
      AppMethodBeat.o(159383);
      return this;
    }
    
    public final a afq(int paramInt)
    {
      AppMethodBeat.i(159384);
      this.EVU.afn(paramInt);
      AppMethodBeat.o(159384);
      return this;
    }
    
    public final a av(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(159375);
      int i = aq.fromDPToPix(this.mContext, (int)(20.0F * aq.eb(this.mContext)));
      if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
      {
        CharSequence localCharSequence = b.h(this.mContext, paramCharSequence.toString(), i);
        this.EVU.as(localCharSequence);
      }
      this.EVU.as(paramCharSequence);
      AppMethodBeat.o(159375);
      return this;
    }
    
    public final a aw(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(159377);
      int i = aq.fromDPToPix(this.mContext, (int)(14.0F * aq.eb(this.mContext)));
      if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
      {
        CharSequence localCharSequence = b.h(this.mContext, paramCharSequence.toString(), i);
        this.EVU.au(localCharSequence);
      }
      this.EVU.au(paramCharSequence);
      AppMethodBeat.o(159377);
      return this;
    }
    
    public final a b(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(159390);
      this.EVU.a(paramOnDismissListener);
      AppMethodBeat.o(159390);
      return this;
    }
    
    public final a b(final f.c paramc)
    {
      AppMethodBeat.i(159387);
      if ((this.KXj == null) || ((this.KXj != null) && (this.KXj.length() == 0))) {
        this.KXj = this.mContext.getResources().getString(2131756757);
      }
      this.EVU.aXM(this.KXj);
      this.EVU.c(new DialogInterface.OnClickListener()
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
          for (paramAnonymousDialogInterface = null;; paramAnonymousDialogInterface = ((d)paramAnonymousDialogInterface).fLY())
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
      if (this.KXm != null) {
        this.KXm.setTag(this.jcs);
      }
      b(paramc);
      a(paramc);
      AppMethodBeat.o(159388);
      return this;
    }
    
    public final a fMj()
    {
      this.EgK = true;
      return this;
    }
    
    public final d fMk()
    {
      return this.jcs;
    }
    
    public final a hb(View paramView)
    {
      AppMethodBeat.i(159379);
      this.EVU.gY(paramView);
      AppMethodBeat.o(159379);
      return this;
    }
    
    public final a s(Boolean paramBoolean)
    {
      AppMethodBeat.i(159380);
      this.EVU.yQ(paramBoolean.booleanValue());
      AppMethodBeat.o(159380);
      return this;
    }
    
    public final void show()
    {
      AppMethodBeat.i(159391);
      if ((this.mContext instanceof Activity))
      {
        if (this.jcs == null) {
          this.jcs = this.EVU.fMb();
        }
        this.jcs.show();
        AppMethodBeat.o(159391);
        return;
      }
      AlertActivity.a(this.EVU);
      Object localObject = new Intent(this.mContext, AlertActivity.class);
      ((Intent)localObject).setFlags(335544320);
      Context localContext = this.mContext;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(159391);
    }
    
    public final a yU(boolean paramBoolean)
    {
      AppMethodBeat.i(159374);
      this.EVU.yR(paramBoolean);
      this.EVU.yS(paramBoolean);
      AppMethodBeat.o(159374);
      return this;
    }
  }
  
  public static abstract interface b
  {
    public abstract void E(boolean paramBoolean1, boolean paramBoolean2);
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