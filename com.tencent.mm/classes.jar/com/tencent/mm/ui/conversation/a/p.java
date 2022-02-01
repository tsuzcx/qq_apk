package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public final class p
  extends b
{
  private boolean IHQ;
  private WeImageView IIc;
  private View mZW;
  private View mZX;
  private TextView titleTv;
  
  public p(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38853);
    this.IHQ = false;
    if ((!this.IHQ) && (this.view != null))
    {
      this.mZW = this.view.findViewById(2131297178);
      this.mZX = this.view.findViewById(2131297183);
      this.IIc = ((WeImageView)this.view.findViewById(2131297180));
      this.IIc.setIconColor(((Context)this.Dsc.get()).getResources().getColor(2131099676));
      this.titleTv = ((TextView)this.view.findViewById(2131297184));
      this.IHQ = true;
    }
    AppMethodBeat.o(38853);
  }
  
  private static boolean n(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(38856);
    if (paramObject == null)
    {
      AppMethodBeat.o(38856);
      return true;
    }
    if (((Integer)paramObject).intValue() != paramInt)
    {
      AppMethodBeat.o(38856);
      return true;
    }
    AppMethodBeat.o(38856);
    return false;
  }
  
  public final boolean bvU()
  {
    AppMethodBeat.i(38855);
    Object localObject;
    boolean bool;
    if ((this.isFirst) && (this.gRm))
    {
      this.mZX.setBackgroundResource(2131234377);
      this.mZW.setBackground(null);
      this.titleTv.setBackground(null);
      az.ayM();
      if (!c.afW()) {
        break label211;
      }
      az.ayM();
      if (!n.pp(c.awy())) {
        break label211;
      }
      localObject = az.agi();
      az.ayM();
      ((q)localObject).a(new n(c.awy()), 0);
      bool = false;
    }
    for (;;)
    {
      label93:
      if (bool) {
        setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(38855);
        return bool;
        if (this.isFirst)
        {
          this.mZX.setBackgroundResource(2131232872);
          this.mZW.setBackgroundResource(2131232870);
          this.titleTv.setBackgroundResource(2131232867);
          break;
        }
        if (this.gRm)
        {
          this.mZX.setBackgroundResource(2131232872);
          this.mZW.setBackgroundResource(2131232867);
          this.titleTv.setBackground(null);
          break;
        }
        this.mZX.setBackgroundResource(2131232872);
        this.mZW.setBackground(null);
        this.titleTv.setBackgroundResource(2131232867);
        break;
        label211:
        az.ayM();
        if ((c.afW()) && (!bs.isNullOrNil(n.hSk)) && (!n.aHt()))
        {
          if (u.nM(u.axC())) {
            if ((!n.aHw()) && (n.aHu()))
            {
              this.titleTv.setText(n.hSq);
              label267:
              this.IIc.setIconColor(((Context)this.Dsc.get()).getResources().getColor(2131099676));
              if (n.aHs() != 1) {
                break label449;
              }
              if (n(this.IIc.getTag(), 2131690555))
              {
                this.IIc.setTag(Integer.valueOf(2131690555));
                this.IIc.setImageResource(2131690555);
              }
            }
          }
          for (;;)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("intent.key.online_version", n.aHv());
            this.view.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(38852);
                d.b((Context)p.this.Dsc.get(), "webwx", ".ui.WebWXLogoutUI", this.val$intent);
                AppMethodBeat.o(38852);
              }
            });
            bool = true;
            break;
            this.titleTv.setText(n.hSk + " " + n.hSl);
            break label267;
            if ((!n.aHw()) && (n.aHu()))
            {
              this.titleTv.setText(n.hSr);
              break label267;
            }
            this.titleTv.setText(n.hSo);
            break label267;
            label449:
            if (n.aHs() == 2)
            {
              if (n.aHu())
              {
                if (n(this.IIc.getTag(), 2131690584))
                {
                  this.IIc.setTag(Integer.valueOf(2131690584));
                  this.IIc.setImageResource(2131690584);
                }
              }
              else if (n(this.IIc.getTag(), 2131690583))
              {
                this.IIc.setTag(Integer.valueOf(2131690583));
                this.IIc.setImageResource(2131690583);
              }
            }
            else if (n.aHs() == 3)
            {
              if (n(this.IIc.getTag(), 2131690615))
              {
                this.IIc.setTag(Integer.valueOf(2131690615));
                this.IIc.setImageResource(2131690615);
              }
            }
            else if (n.aHs() == 6)
            {
              if (n(this.IIc.getTag(), 2131689964))
              {
                this.IIc.setTag(Integer.valueOf(2131689964));
                this.IIc.setImageResource(2131689964);
              }
            }
            else if (n(this.IIc.getTag(), 2131691293))
            {
              this.IIc.setTag(Integer.valueOf(2131691293));
              this.IIc.setImageResource(2131691293);
            }
          }
        }
        if (!h.EX_DEVICE_LOGIN) {
          break label801;
        }
        az.ayM();
        if (!c.afW()) {
          break label801;
        }
        int i = n.getDeviceType();
        if ((n.aHs() != 0) || ((i != 2) && (i != 1))) {
          break label801;
        }
        this.view.setOnClickListener(null);
        if (n(this.IIc.getTag(), 2131691293))
        {
          this.IIc.setTag(Integer.valueOf(2131691293));
          this.IIc.setImageResource(2131691293);
        }
        if (i == 2)
        {
          this.titleTv.setText(2131758551);
          bool = true;
          break label93;
        }
        if (i == 1) {
          this.titleTv.setText(2131758552);
        }
        bool = true;
        break label93;
        setVisibility(8);
      }
      label801:
      bool = false;
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131495061;
  }
  
  public final int getOrder()
  {
    return 2;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38854);
    if (this.mZW != null) {
      this.mZW.setVisibility(paramInt);
    }
    AppMethodBeat.o(38854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.p
 * JD-Core Version:    0.7.0.1
 */