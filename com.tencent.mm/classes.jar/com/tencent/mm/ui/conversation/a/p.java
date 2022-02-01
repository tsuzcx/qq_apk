package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public final class p
  extends b
{
  private WeImageView HhJ;
  private boolean Hhx;
  private View mxV;
  private View mxW;
  private TextView titleTv;
  
  public p(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38853);
    this.Hhx = false;
    if ((!this.Hhx) && (this.view != null))
    {
      this.mxV = this.view.findViewById(2131297178);
      this.mxW = this.view.findViewById(2131297183);
      this.HhJ = ((WeImageView)this.view.findViewById(2131297180));
      this.HhJ.setIconColor(((Context)this.BZM.get()).getResources().getColor(2131099676));
      this.titleTv = ((TextView)this.view.findViewById(2131297184));
      this.Hhx = true;
    }
    AppMethodBeat.o(38853);
  }
  
  private static boolean k(Object paramObject, int paramInt)
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
  
  public final boolean boZ()
  {
    AppMethodBeat.i(38855);
    Object localObject;
    boolean bool;
    if ((this.isFirst) && (this.gqE))
    {
      this.mxW.setBackgroundResource(2131234377);
      this.mxV.setBackground(null);
      this.titleTv.setBackground(null);
      az.arV();
      if (!c.aeG()) {
        break label211;
      }
      az.arV();
      if (!n.oB(c.apJ())) {
        break label211;
      }
      localObject = az.aeS();
      az.arV();
      ((q)localObject).a(new n(c.apJ()), 0);
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
          this.mxW.setBackgroundResource(2131232872);
          this.mxV.setBackgroundResource(2131232870);
          this.titleTv.setBackgroundResource(2131232867);
          break;
        }
        if (this.gqE)
        {
          this.mxW.setBackgroundResource(2131232872);
          this.mxV.setBackgroundResource(2131232867);
          this.titleTv.setBackground(null);
          break;
        }
        this.mxW.setBackgroundResource(2131232872);
        this.mxV.setBackground(null);
        this.titleTv.setBackgroundResource(2131232867);
        break;
        label211:
        az.arV();
        if ((c.aeG()) && (!bt.isNullOrNil(n.hrI)) && (!n.aAD()))
        {
          if (u.mY(u.aqM())) {
            if ((!n.aAG()) && (n.aAE()))
            {
              this.titleTv.setText(n.hrO);
              label267:
              this.HhJ.setIconColor(((Context)this.BZM.get()).getResources().getColor(2131099676));
              if (n.aAC() != 1) {
                break label449;
              }
              if (k(this.HhJ.getTag(), 2131690555))
              {
                this.HhJ.setTag(Integer.valueOf(2131690555));
                this.HhJ.setImageResource(2131690555);
              }
            }
          }
          for (;;)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("intent.key.online_version", n.aAF());
            this.view.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(38852);
                d.b((Context)p.this.BZM.get(), "webwx", ".ui.WebWXLogoutUI", this.val$intent);
                AppMethodBeat.o(38852);
              }
            });
            bool = true;
            break;
            this.titleTv.setText(n.hrI + " " + n.hrJ);
            break label267;
            if ((!n.aAG()) && (n.aAE()))
            {
              this.titleTv.setText(n.hrP);
              break label267;
            }
            this.titleTv.setText(n.hrM);
            break label267;
            label449:
            if (n.aAC() == 2)
            {
              if (n.aAE())
              {
                if (k(this.HhJ.getTag(), 2131690584))
                {
                  this.HhJ.setTag(Integer.valueOf(2131690584));
                  this.HhJ.setImageResource(2131690584);
                }
              }
              else if (k(this.HhJ.getTag(), 2131690583))
              {
                this.HhJ.setTag(Integer.valueOf(2131690583));
                this.HhJ.setImageResource(2131690583);
              }
            }
            else if (n.aAC() == 3)
            {
              if (k(this.HhJ.getTag(), 2131690615))
              {
                this.HhJ.setTag(Integer.valueOf(2131690615));
                this.HhJ.setImageResource(2131690615);
              }
            }
            else if (n.aAC() == 6)
            {
              if (k(this.HhJ.getTag(), 2131689964))
              {
                this.HhJ.setTag(Integer.valueOf(2131689964));
                this.HhJ.setImageResource(2131689964);
              }
            }
            else if (k(this.HhJ.getTag(), 2131691293))
            {
              this.HhJ.setTag(Integer.valueOf(2131691293));
              this.HhJ.setImageResource(2131691293);
            }
          }
        }
        if (!h.EX_DEVICE_LOGIN) {
          break label801;
        }
        az.arV();
        if (!c.aeG()) {
          break label801;
        }
        int i = n.getDeviceType();
        if ((n.aAC() != 0) || ((i != 2) && (i != 1))) {
          break label801;
        }
        this.view.setOnClickListener(null);
        if (k(this.HhJ.getTag(), 2131691293))
        {
          this.HhJ.setTag(Integer.valueOf(2131691293));
          this.HhJ.setImageResource(2131691293);
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
    if (this.mxV != null) {
      this.mxV.setVisibility(paramInt);
    }
    AppMethodBeat.o(38854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.p
 * JD-Core Version:    0.7.0.1
 */