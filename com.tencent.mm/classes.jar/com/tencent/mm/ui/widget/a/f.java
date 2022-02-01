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
    public boolean EyN;
    public final d.a Fop;
    private String LtH;
    private String LtI;
    private boolean LtJ;
    private RadioGroup LtK;
    public d jfl;
    Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159373);
      this.LtH = null;
      this.LtI = null;
      this.LtJ = false;
      this.EyN = false;
      this.mContext = paramContext;
      this.Fop = new d.a(this.mContext);
      this.Fop.zf(false);
      this.Fop.zg(false);
      this.Fop.a(new d.a.d()
      {
        public final CharSequence a(CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
        {
          AppMethodBeat.i(159368);
          paramAnonymousCharSequence = b.c(f.a.this.mContext, paramAnonymousCharSequence, paramAnonymousFloat);
          AppMethodBeat.o(159368);
          return paramAnonymousCharSequence;
        }
      });
      this.LtI = this.mContext.getResources().getString(2131756755);
      this.LtH = this.mContext.getResources().getString(2131756757);
      AppMethodBeat.o(159373);
    }
    
    public final a a(final f.b paramb)
    {
      AppMethodBeat.i(159389);
      if (this.LtK != null) {
        this.LtK.setTag(this.jfl);
      }
      if ((this.LtH == null) || ((this.LtH != null) && (this.LtH.length() == 0))) {
        this.LtH = this.mContext.getResources().getString(2131756757);
      }
      this.Fop.aZo(this.LtH);
      this.Fop.c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(159371);
          if (paramb != null)
          {
            if (paramAnonymousDialogInterface != null) {
              ((d)paramAnonymousDialogInterface).fQs();
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
      if ((this.LtI == null) || ((this.LtI != null) && (this.LtI.length() == 0))) {
        this.LtI = this.mContext.getResources().getString(2131756755);
      }
      this.Fop.aZp(this.LtI);
      if (!this.EyN) {
        this.Fop.d(new DialogInterface.OnClickListener()
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
      if ((this.LtI == null) || ((this.LtI != null) && (this.LtI.length() == 0))) {
        this.LtI = this.mContext.getResources().getString(2131756755);
      }
      this.Fop.aZp(this.LtI);
      if (!this.EyN) {
        this.Fop.d(new DialogInterface.OnClickListener()
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
      if (this.LtK != null) {
        this.LtK.setTag(this.jfl);
      }
      a(paramc1);
      b(paramc2);
      if (this.LtJ) {
        this.Fop.afX(this.mContext.getResources().getColor(2131100035));
      }
      AppMethodBeat.o(159385);
      return this;
    }
    
    public final a a(ArrayList<String> paramArrayList, RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener, int paramInt)
    {
      AppMethodBeat.i(175622);
      View localView = View.inflate(this.mContext, 2131493715, null);
      this.LtK = ((RadioGroup)localView.findViewById(2131303707));
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
          this.LtK.addView(localRadioButton);
          j += 1;
        }
        this.LtK.setOnCheckedChangeListener(paramOnCheckedChangeListener);
        this.Fop.hd(localView);
        AppMethodBeat.o(175622);
        return this;
      }
    }
    
    public final a aZq(String paramString)
    {
      AppMethodBeat.i(159376);
      this.Fop.aZi(paramString);
      AppMethodBeat.o(159376);
      return this;
    }
    
    public final a aZr(String paramString)
    {
      AppMethodBeat.i(159378);
      this.Fop.aZk(paramString);
      AppMethodBeat.o(159378);
      return this;
    }
    
    public final a aZs(String paramString)
    {
      AppMethodBeat.i(159381);
      this.Fop.aZm(paramString);
      AppMethodBeat.o(159381);
      return this;
    }
    
    public final a aZt(String paramString)
    {
      AppMethodBeat.i(159382);
      this.Fop.aZn(paramString);
      AppMethodBeat.o(159382);
      return this;
    }
    
    public final a aZu(String paramString)
    {
      AppMethodBeat.i(200364);
      this.LtH = paramString;
      this.Fop.aZo(this.LtH);
      AppMethodBeat.o(200364);
      return this;
    }
    
    public final a aZv(String paramString)
    {
      AppMethodBeat.i(200365);
      this.LtI = paramString;
      this.Fop.aZp(this.LtI);
      AppMethodBeat.o(200365);
      return this;
    }
    
    public final a afY(int paramInt)
    {
      AppMethodBeat.i(159383);
      this.LtH = this.mContext.getResources().getString(paramInt);
      this.Fop.aZo(this.LtH);
      AppMethodBeat.o(159383);
      return this;
    }
    
    public final a afZ(int paramInt)
    {
      AppMethodBeat.i(159384);
      this.Fop.afW(paramInt);
      AppMethodBeat.o(159384);
      return this;
    }
    
    public final a au(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(159375);
      int i = aq.fromDPToPix(this.mContext, (int)(20.0F * aq.ef(this.mContext)));
      if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
      {
        CharSequence localCharSequence = b.h(this.mContext, paramCharSequence.toString(), i);
        this.Fop.ar(localCharSequence);
      }
      this.Fop.ar(paramCharSequence);
      AppMethodBeat.o(159375);
      return this;
    }
    
    public final a av(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(159377);
      int i = aq.fromDPToPix(this.mContext, (int)(14.0F * aq.ef(this.mContext)));
      if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
      {
        CharSequence localCharSequence = b.h(this.mContext, paramCharSequence.toString(), i);
        this.Fop.at(localCharSequence);
      }
      this.Fop.at(paramCharSequence);
      AppMethodBeat.o(159377);
      return this;
    }
    
    public final a b(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(159390);
      this.Fop.a(paramOnDismissListener);
      AppMethodBeat.o(159390);
      return this;
    }
    
    public final a b(final f.c paramc)
    {
      AppMethodBeat.i(159387);
      if ((this.LtH == null) || ((this.LtH != null) && (this.LtH.length() == 0))) {
        this.LtH = this.mContext.getResources().getString(2131756757);
      }
      this.Fop.aZo(this.LtH);
      this.Fop.c(new DialogInterface.OnClickListener()
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
          for (paramAnonymousDialogInterface = null;; paramAnonymousDialogInterface = ((d)paramAnonymousDialogInterface).fQs())
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
      if (this.LtK != null) {
        this.LtK.setTag(this.jfl);
      }
      b(paramc);
      a(paramc);
      AppMethodBeat.o(159388);
      return this;
    }
    
    public final a fQD()
    {
      this.EyN = true;
      return this;
    }
    
    public final d fQE()
    {
      return this.jfl;
    }
    
    public final a hg(View paramView)
    {
      AppMethodBeat.i(159379);
      this.Fop.hd(paramView);
      AppMethodBeat.o(159379);
      return this;
    }
    
    public final a s(Boolean paramBoolean)
    {
      AppMethodBeat.i(159380);
      this.Fop.ze(paramBoolean.booleanValue());
      AppMethodBeat.o(159380);
      return this;
    }
    
    public final void show()
    {
      AppMethodBeat.i(159391);
      if ((this.mContext instanceof Activity))
      {
        if (this.jfl == null) {
          this.jfl = this.Fop.fQv();
        }
        this.jfl.show();
        AppMethodBeat.o(159391);
        return;
      }
      AlertActivity.a(this.Fop);
      Object localObject = new Intent(this.mContext, AlertActivity.class);
      ((Intent)localObject).setFlags(335544320);
      Context localContext = this.mContext;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(159391);
    }
    
    public final a zi(boolean paramBoolean)
    {
      AppMethodBeat.i(159374);
      this.Fop.zf(paramBoolean);
      this.Fop.zg(paramBoolean);
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