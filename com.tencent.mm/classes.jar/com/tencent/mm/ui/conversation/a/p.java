package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public final class p
  extends b
{
  private boolean KVs;
  private View nFO;
  private View nFP;
  private WeImageView ofI;
  private TextView titleTv;
  
  public p(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38853);
    this.KVs = false;
    if ((!this.KVs) && (this.view != null))
    {
      this.nFO = this.view.findViewById(2131297178);
      this.nFP = this.view.findViewById(2131297183);
      this.ofI = ((WeImageView)this.view.findViewById(2131297180));
      this.ofI.setIconColor(((Context)this.FpA.get()).getResources().getColor(2131099676));
      this.titleTv = ((TextView)this.view.findViewById(2131297184));
      this.KVs = true;
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
  
  public final boolean bAV()
  {
    AppMethodBeat.i(38855);
    Object localObject;
    boolean bool;
    if ((this.isFirst) && (this.hms))
    {
      this.nFP.setBackgroundResource(2131234377);
      this.nFO.setBackground(null);
      this.titleTv.setBackground(null);
      bc.aCg();
      if (!c.aiX()) {
        break label211;
      }
      bc.aCg();
      if (!o.pV(c.azC())) {
        break label211;
      }
      localObject = bc.ajj();
      bc.aCg();
      ((q)localObject).a(new o(c.azC()), 0);
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
          this.nFP.setBackgroundResource(2131232872);
          this.nFO.setBackgroundResource(2131232870);
          this.titleTv.setBackgroundResource(2131232867);
          break;
        }
        if (this.hms)
        {
          this.nFP.setBackgroundResource(2131232872);
          this.nFO.setBackgroundResource(2131232867);
          this.titleTv.setBackground(null);
          break;
        }
        this.nFP.setBackgroundResource(2131232872);
        this.nFO.setBackground(null);
        this.titleTv.setBackgroundResource(2131232867);
        break;
        label211:
        bc.aCg();
        if ((c.aiX()) && (!bu.isNullOrNil(o.iou)) && (!o.aLb()))
        {
          if (v.acG()) {
            if ((!o.aLe()) && (o.aLc()))
            {
              this.titleTv.setText(o.ioA);
              label264:
              this.ofI.setIconColor(((Context)this.FpA.get()).getResources().getColor(2131099676));
              if (o.aLa() != 1) {
                break label446;
              }
              if (o(this.ofI.getTag(), 2131690555))
              {
                this.ofI.setTag(Integer.valueOf(2131690555));
                this.ofI.setImageResource(2131690555);
              }
            }
          }
          for (;;)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("intent.key.online_version", o.aLd());
            this.view.setOnClickListener(new p.1(this, (Intent)localObject));
            bool = true;
            break;
            this.titleTv.setText(o.iou + " " + o.iov);
            break label264;
            if ((!o.aLe()) && (o.aLc()))
            {
              this.titleTv.setText(o.ioB);
              break label264;
            }
            this.titleTv.setText(o.ioy);
            break label264;
            label446:
            if (o.aLa() == 2)
            {
              if (o.aLc())
              {
                if (o(this.ofI.getTag(), 2131690584))
                {
                  this.ofI.setTag(Integer.valueOf(2131690584));
                  this.ofI.setImageResource(2131690584);
                }
              }
              else if (o(this.ofI.getTag(), 2131690583))
              {
                this.ofI.setTag(Integer.valueOf(2131690583));
                this.ofI.setImageResource(2131690583);
              }
            }
            else if (o.aLa() == 3)
            {
              if (o(this.ofI.getTag(), 2131690615))
              {
                this.ofI.setTag(Integer.valueOf(2131690615));
                this.ofI.setImageResource(2131690615);
              }
            }
            else if (o.aLa() == 6)
            {
              if (o(this.ofI.getTag(), 2131689964))
              {
                this.ofI.setTag(Integer.valueOf(2131689964));
                this.ofI.setImageResource(2131689964);
              }
            }
            else if (o(this.ofI.getTag(), 2131691293))
            {
              this.ofI.setTag(Integer.valueOf(2131691293));
              this.ofI.setImageResource(2131691293);
            }
          }
        }
        if (!j.EX_DEVICE_LOGIN) {
          break label798;
        }
        bc.aCg();
        if (!c.aiX()) {
          break label798;
        }
        int i = o.getDeviceType();
        if ((o.aLa() != 0) || ((i != 2) && (i != 1))) {
          break label798;
        }
        this.view.setOnClickListener(null);
        if (o(this.ofI.getTag(), 2131691293))
        {
          this.ofI.setTag(Integer.valueOf(2131691293));
          this.ofI.setImageResource(2131691293);
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
    if (this.nFO != null) {
      this.nFO.setVisibility(paramInt);
    }
    AppMethodBeat.o(38854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.p
 * JD-Core Version:    0.7.0.1
 */