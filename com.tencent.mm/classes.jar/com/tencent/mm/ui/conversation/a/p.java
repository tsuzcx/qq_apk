package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public final class p
  extends b
{
  private boolean QiI;
  private WeImageView hex;
  private View oQL;
  private View oQM;
  private TextView titleTv;
  
  public p(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38853);
    this.QiI = false;
    if ((!this.QiI) && (this.view != null))
    {
      this.oQL = this.view.findViewById(2131297322);
      this.oQM = this.view.findViewById(2131297327);
      this.hex = ((WeImageView)this.view.findViewById(2131297324));
      this.hex.setIconColor(((Context)this.Kgr.get()).getResources().getColor(2131099683));
      this.titleTv = ((TextView)this.view.findViewById(2131297328));
      this.QiI = true;
    }
    AppMethodBeat.o(38853);
  }
  
  private static boolean q(Object paramObject, int paramInt)
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
  
  public final boolean bYa()
  {
    AppMethodBeat.i(38855);
    Object localObject;
    boolean bool;
    if ((this.isFirst) && (this.ifo))
    {
      this.oQM.setBackgroundResource(2131235299);
      this.oQL.setBackground(null);
      this.titleTv.setBackground(null);
      bg.aVF();
      if (!c.azn()) {
        break label211;
      }
      bg.aVF();
      if (!o.tK(c.aSK())) {
        break label211;
      }
      localObject = bg.azz();
      bg.aVF();
      ((t)localObject).a(new o(c.aSK()), 0);
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
          this.oQM.setBackgroundResource(2131233332);
          this.oQL.setBackgroundResource(2131233330);
          this.titleTv.setBackgroundResource(2131233327);
          break;
        }
        if (this.ifo)
        {
          this.oQM.setBackgroundResource(2131233332);
          this.oQL.setBackgroundResource(2131233327);
          this.titleTv.setBackground(null);
          break;
        }
        this.oQM.setBackgroundResource(2131233332);
        this.oQL.setBackground(null);
        this.titleTv.setBackgroundResource(2131233327);
        break;
        label211:
        bg.aVF();
        if ((c.azn()) && (!Util.isNullOrNil(o.jjB)) && (!o.bfd()))
        {
          if (z.aqE()) {
            if ((!o.bfg()) && (o.bfe()))
            {
              this.titleTv.setText(o.jjH);
              label264:
              this.hex.setIconColor(((Context)this.Kgr.get()).getResources().getColor(2131099683));
              if (o.bfc() != 1) {
                break label446;
              }
              if (q(this.hex.getTag(), 2131690784))
              {
                this.hex.setTag(Integer.valueOf(2131690784));
                this.hex.setImageResource(2131690784);
              }
            }
          }
          for (;;)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("intent.key.online_version", o.bff());
            this.view.setOnClickListener(new p.1(this, (Intent)localObject));
            bool = true;
            break;
            this.titleTv.setText(o.jjB + " " + o.jjC);
            break label264;
            if ((!o.bfg()) && (o.bfe()))
            {
              this.titleTv.setText(o.jjI);
              break label264;
            }
            this.titleTv.setText(o.jjF);
            break label264;
            label446:
            if (o.bfc() == 2)
            {
              if (o.bfe())
              {
                if (q(this.hex.getTag(), 2131690819))
                {
                  this.hex.setTag(Integer.valueOf(2131690819));
                  this.hex.setImageResource(2131690819);
                }
              }
              else if (q(this.hex.getTag(), 2131690818))
              {
                this.hex.setTag(Integer.valueOf(2131690818));
                this.hex.setImageResource(2131690818);
              }
            }
            else if (o.bfc() == 3)
            {
              if (q(this.hex.getTag(), 2131690861))
              {
                this.hex.setTag(Integer.valueOf(2131690861));
                this.hex.setImageResource(2131690861);
              }
            }
            else if (o.bfc() == 6)
            {
              if (q(this.hex.getTag(), 2131689991))
              {
                this.hex.setTag(Integer.valueOf(2131689991));
                this.hex.setImageResource(2131689991);
              }
            }
            else if (o.bfc() == 7)
            {
              if (q(this.hex.getTag(), 2131690003))
              {
                this.hex.setTag(Integer.valueOf(2131690003));
                this.hex.setImageResource(2131690003);
              }
            }
            else if (o.bfc() == 8)
            {
              if (q(this.hex.getTag(), 2131690735))
              {
                this.hex.setTag(Integer.valueOf(2131690735));
                this.hex.setImageResource(2131690735);
              }
            }
            else if (q(this.hex.getTag(), 2131691625))
            {
              this.hex.setTag(Integer.valueOf(2131691625));
              this.hex.setImageResource(2131691625);
            }
          }
        }
        if ((!BuildInfo.EX_DEVICE_LOGIN) && (!ao.gJH())) {
          break label898;
        }
        bg.aVF();
        if (!c.azn()) {
          break label898;
        }
        int i = o.getDeviceType();
        if ((o.bfc() != 0) || ((i != 2) && (i != 1))) {
          break label898;
        }
        this.view.setOnClickListener(null);
        if (q(this.hex.getTag(), 2131691625))
        {
          this.hex.setTag(Integer.valueOf(2131691625));
          this.hex.setImageResource(2131691625);
        }
        if (i == 2)
        {
          this.titleTv.setText(2131758850);
          bool = true;
          break label93;
        }
        if (i == 1) {
          this.titleTv.setText(2131758852);
        }
        bool = true;
        break label93;
        setVisibility(8);
      }
      label898:
      bool = false;
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131495895;
  }
  
  public final int getOrder()
  {
    return 2;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38854);
    if (this.oQL != null) {
      this.oQL.setVisibility(paramInt);
    }
    AppMethodBeat.o(38854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.p
 * JD-Core Version:    0.7.0.1
 */