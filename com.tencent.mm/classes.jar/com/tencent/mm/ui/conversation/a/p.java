package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public final class p
  extends b
{
  private boolean KyY;
  private View nAt;
  private View nAu;
  private WeImageView nZY;
  private TextView titleTv;
  
  public p(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38853);
    this.KyY = false;
    if ((!this.KyY) && (this.view != null))
    {
      this.nAt = this.view.findViewById(2131297178);
      this.nAu = this.view.findViewById(2131297183);
      this.nZY = ((WeImageView)this.view.findViewById(2131297180));
      this.nZY.setIconColor(((Context)this.EXg.get()).getResources().getColor(2131099676));
      this.titleTv = ((TextView)this.view.findViewById(2131297184));
      this.KyY = true;
    }
    AppMethodBeat.o(38853);
  }
  
  private static boolean o(Object paramObject, int paramInt)
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
  
  public final boolean bAa()
  {
    AppMethodBeat.i(38855);
    Object localObject;
    boolean bool;
    if ((this.isFirst) && (this.hjE))
    {
      this.nAu.setBackgroundResource(2131234377);
      this.nAt.setBackground(null);
      this.titleTv.setBackground(null);
      ba.aBQ();
      if (!c.aiI()) {
        break label211;
      }
      ba.aBQ();
      if (!n.pS(c.azm())) {
        break label211;
      }
      localObject = ba.aiU();
      ba.aBQ();
      ((q)localObject).a(new n(c.azm()), 0);
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
          this.nAu.setBackgroundResource(2131232872);
          this.nAt.setBackgroundResource(2131232870);
          this.titleTv.setBackgroundResource(2131232867);
          break;
        }
        if (this.hjE)
        {
          this.nAu.setBackgroundResource(2131232872);
          this.nAt.setBackgroundResource(2131232867);
          this.titleTv.setBackground(null);
          break;
        }
        this.nAu.setBackgroundResource(2131232872);
        this.nAt.setBackground(null);
        this.titleTv.setBackgroundResource(2131232867);
        break;
        label211:
        ba.aBQ();
        if ((c.aiI()) && (!bt.isNullOrNil(n.ilB)) && (!n.aKE()))
        {
          if (u.acv()) {
            if ((!n.aKH()) && (n.aKF()))
            {
              this.titleTv.setText(n.ilH);
              label264:
              this.nZY.setIconColor(((Context)this.EXg.get()).getResources().getColor(2131099676));
              if (n.aKD() != 1) {
                break label446;
              }
              if (o(this.nZY.getTag(), 2131690555))
              {
                this.nZY.setTag(Integer.valueOf(2131690555));
                this.nZY.setImageResource(2131690555);
              }
            }
          }
          for (;;)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("intent.key.online_version", n.aKG());
            this.view.setOnClickListener(new p.1(this, (Intent)localObject));
            bool = true;
            break;
            this.titleTv.setText(n.ilB + " " + n.ilC);
            break label264;
            if ((!n.aKH()) && (n.aKF()))
            {
              this.titleTv.setText(n.ilI);
              break label264;
            }
            this.titleTv.setText(n.ilF);
            break label264;
            label446:
            if (n.aKD() == 2)
            {
              if (n.aKF())
              {
                if (o(this.nZY.getTag(), 2131690584))
                {
                  this.nZY.setTag(Integer.valueOf(2131690584));
                  this.nZY.setImageResource(2131690584);
                }
              }
              else if (o(this.nZY.getTag(), 2131690583))
              {
                this.nZY.setTag(Integer.valueOf(2131690583));
                this.nZY.setImageResource(2131690583);
              }
            }
            else if (n.aKD() == 3)
            {
              if (o(this.nZY.getTag(), 2131690615))
              {
                this.nZY.setTag(Integer.valueOf(2131690615));
                this.nZY.setImageResource(2131690615);
              }
            }
            else if (n.aKD() == 6)
            {
              if (o(this.nZY.getTag(), 2131689964))
              {
                this.nZY.setTag(Integer.valueOf(2131689964));
                this.nZY.setImageResource(2131689964);
              }
            }
            else if (o(this.nZY.getTag(), 2131691293))
            {
              this.nZY.setTag(Integer.valueOf(2131691293));
              this.nZY.setImageResource(2131691293);
            }
          }
        }
        if (!i.EX_DEVICE_LOGIN) {
          break label798;
        }
        ba.aBQ();
        if (!c.aiI()) {
          break label798;
        }
        int i = n.getDeviceType();
        if ((n.aKD() != 0) || ((i != 2) && (i != 1))) {
          break label798;
        }
        this.view.setOnClickListener(null);
        if (o(this.nZY.getTag(), 2131691293))
        {
          this.nZY.setTag(Integer.valueOf(2131691293));
          this.nZY.setImageResource(2131691293);
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
      label798:
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
    if (this.nAt != null) {
      this.nAt.setVisibility(paramInt);
    }
    AppMethodBeat.o(38854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.p
 * JD-Core Version:    0.7.0.1
 */