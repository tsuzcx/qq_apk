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
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ck.a.i;
import com.tencent.mm.ui.AlertActivity;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.i.c.b;
import java.util.ArrayList;

public final class g$a
{
  public final e.a GGP;
  public boolean Xdm;
  private String agfv;
  private String agfw;
  private boolean agfx;
  private RadioGroup agfy;
  Context mContext;
  public e pRv;
  
  public g$a(Context paramContext)
  {
    AppMethodBeat.i(159373);
    this.agfv = null;
    this.agfw = null;
    this.agfx = false;
    this.Xdm = false;
    this.mContext = paramContext;
    this.GGP = new e.a(this.mContext);
    this.GGP.NC(false);
    this.GGP.ND(false);
    this.GGP.a(new e.a.d()
    {
      public final CharSequence a(CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
      {
        AppMethodBeat.i(159368);
        paramAnonymousCharSequence = b.c(g.a.this.mContext, paramAnonymousCharSequence, paramAnonymousFloat);
        AppMethodBeat.o(159368);
        return paramAnonymousCharSequence;
      }
    });
    this.agfw = this.mContext.getResources().getString(a.i.button_cancel);
    this.agfv = this.mContext.getResources().getString(a.i.button_ok);
    AppMethodBeat.o(159373);
  }
  
  public final a N(Boolean paramBoolean)
  {
    AppMethodBeat.i(159380);
    this.GGP.NB(paramBoolean.booleanValue());
    AppMethodBeat.o(159380);
    return this;
  }
  
  public final a NF(boolean paramBoolean)
  {
    AppMethodBeat.i(159374);
    this.GGP.NC(paramBoolean);
    this.GGP.ND(paramBoolean);
    AppMethodBeat.o(159374);
    return this;
  }
  
  public final a a(final g.b paramb)
  {
    AppMethodBeat.i(159389);
    if (this.agfy != null) {
      this.agfy.setTag(this.pRv);
    }
    if ((this.agfv == null) || ((this.agfv != null) && (this.agfv.length() == 0))) {
      this.agfv = this.mContext.getResources().getString(a.i.button_ok);
    }
    this.GGP.bDC(this.agfv);
    this.GGP.c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(159371);
        String str;
        if (paramb != null)
        {
          if (paramAnonymousDialogInterface != null) {
            break label44;
          }
          str = null;
          if (paramAnonymousDialogInterface != null) {
            break label56;
          }
        }
        label44:
        label56:
        for (boolean bool = false;; bool = ((e)paramAnonymousDialogInterface).nd.isChecked())
        {
          paramb.e(true, str, bool);
          AppMethodBeat.o(159371);
          return;
          str = ((e)paramAnonymousDialogInterface).jHE();
          break;
        }
      }
    });
    if ((this.agfw == null) || ((this.agfw != null) && (this.agfw.length() == 0))) {
      this.agfw = this.mContext.getResources().getString(a.i.button_cancel);
    }
    this.GGP.bDD(this.agfw);
    if (!this.Xdm) {
      this.GGP.d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(159372);
          if (paramb != null) {
            if (paramAnonymousDialogInterface != null) {
              break label36;
            }
          }
          label36:
          for (boolean bool = false;; bool = ((e)paramAnonymousDialogInterface).nd.isChecked())
          {
            paramb.e(false, null, bool);
            AppMethodBeat.o(159372);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(159389);
    return this;
  }
  
  public final a a(g.c paramc)
  {
    AppMethodBeat.i(159386);
    if ((this.agfw == null) || ((this.agfw != null) && (this.agfw.length() == 0))) {
      this.agfw = this.mContext.getResources().getString(a.i.button_cancel);
    }
    this.GGP.bDD(this.agfw);
    if (!this.Xdm) {
      this.GGP.d(new g.a.2(this, paramc));
    }
    AppMethodBeat.o(159386);
    return this;
  }
  
  public final a a(g.c paramc1, g.c paramc2)
  {
    AppMethodBeat.i(159385);
    if (this.agfy != null) {
      this.agfy.setTag(this.pRv);
    }
    a(paramc1);
    b(paramc2);
    AppMethodBeat.o(159385);
    return this;
  }
  
  public final a a(ArrayList<String> paramArrayList, RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener, int paramInt)
  {
    AppMethodBeat.i(175622);
    View localView = View.inflate(this.mContext, a.g.dialog_radio_view, null);
    this.agfy = ((RadioGroup)localView.findViewById(a.f.radio_group));
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
        this.agfy.addView(localRadioButton);
        j += 1;
      }
      this.agfy.setOnCheckedChangeListener(paramOnCheckedChangeListener);
      this.GGP.md(localView);
      AppMethodBeat.o(175622);
      return this;
    }
  }
  
  public final a aEX(int paramInt)
  {
    AppMethodBeat.i(159383);
    this.agfv = this.mContext.getResources().getString(paramInt);
    this.GGP.bDC(this.agfv);
    AppMethodBeat.o(159383);
    return this;
  }
  
  public final a aEY(int paramInt)
  {
    AppMethodBeat.i(159384);
    this.GGP.aET(paramInt);
    AppMethodBeat.o(159384);
    return this;
  }
  
  public final a aEZ(int paramInt)
  {
    AppMethodBeat.i(251804);
    this.GGP.aEU(paramInt);
    AppMethodBeat.o(251804);
    return this;
  }
  
  public final a b(DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    AppMethodBeat.i(251828);
    this.GGP.a(paramOnClickListener1, paramOnClickListener2, paramOnClickListener3);
    AppMethodBeat.o(251828);
    return this;
  }
  
  public final a b(g.c paramc)
  {
    AppMethodBeat.i(159387);
    if ((this.agfv == null) || ((this.agfv != null) && (this.agfv.length() == 0))) {
      this.agfv = this.mContext.getResources().getString(a.i.button_ok);
    }
    this.GGP.bDC(this.agfv);
    this.GGP.c(new g.a.3(this, paramc));
    AppMethodBeat.o(159387);
    return this;
  }
  
  public final a bDE(String paramString)
  {
    AppMethodBeat.i(159376);
    this.GGP.bDw(paramString);
    AppMethodBeat.o(159376);
    return this;
  }
  
  public final a bDF(String paramString)
  {
    AppMethodBeat.i(159378);
    this.GGP.bDy(paramString);
    AppMethodBeat.o(159378);
    return this;
  }
  
  public final a bDG(String paramString)
  {
    AppMethodBeat.i(159381);
    this.GGP.bDA(paramString);
    AppMethodBeat.o(159381);
    return this;
  }
  
  public final a bDH(String paramString)
  {
    AppMethodBeat.i(159382);
    this.GGP.bDB(paramString);
    AppMethodBeat.o(159382);
    return this;
  }
  
  public final a bDI(String paramString)
  {
    AppMethodBeat.i(251785);
    this.agfv = paramString;
    this.GGP.bDC(this.agfv);
    AppMethodBeat.o(251785);
    return this;
  }
  
  public final a bDJ(String paramString)
  {
    AppMethodBeat.i(251792);
    this.agfw = paramString;
    this.GGP.bDD(this.agfw);
    AppMethodBeat.o(251792);
    return this;
  }
  
  public final a bO(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(251795);
    this.GGP.bN(paramString1, paramString2, paramString3);
    AppMethodBeat.o(251795);
    return this;
  }
  
  public final a bf(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159375);
    int i = bd.fromDPToPix(this.mContext, (int)(20.0F * bd.getScaleSize(this.mContext)));
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      CharSequence localCharSequence = b.a(this.mContext, paramCharSequence.toString(), i);
      this.GGP.bc(localCharSequence);
    }
    this.GGP.bc(paramCharSequence);
    AppMethodBeat.o(159375);
    return this;
  }
  
  public final a bg(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159377);
    int i = bd.fromDPToPix(this.mContext, (int)(14.0F * bd.getScaleSize(this.mContext)));
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      CharSequence localCharSequence = b.a(this.mContext, paramCharSequence.toString(), i);
      this.GGP.be(localCharSequence);
    }
    this.GGP.be(paramCharSequence);
    AppMethodBeat.o(159377);
    return this;
  }
  
  public final a c(g.c paramc)
  {
    AppMethodBeat.i(159388);
    if (this.agfy != null) {
      this.agfy.setTag(this.pRv);
    }
    b(paramc);
    a(paramc);
    AppMethodBeat.o(159388);
    return this;
  }
  
  public final a d(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(159390);
    this.GGP.c(paramOnDismissListener);
    AppMethodBeat.o(159390);
    return this;
  }
  
  public final a jHM()
  {
    AppMethodBeat.i(251841);
    this.GGP.jHG();
    AppMethodBeat.o(251841);
    return this;
  }
  
  public final a mg(View paramView)
  {
    AppMethodBeat.i(159379);
    this.GGP.md(paramView);
    AppMethodBeat.o(159379);
    return this;
  }
  
  public final void show()
  {
    AppMethodBeat.i(159391);
    if ((this.mContext instanceof Activity))
    {
      if (this.pRv == null) {
        this.pRv = this.GGP.jHH();
      }
      this.pRv.show();
      AppMethodBeat.o(159391);
      return;
    }
    AlertActivity.a(this.GGP);
    Object localObject = new Intent(this.mContext, AlertActivity.class);
    ((Intent)localObject).setFlags(335544320);
    Context localContext = this.mContext;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(159391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.g.a
 * JD-Core Version:    0.7.0.1
 */