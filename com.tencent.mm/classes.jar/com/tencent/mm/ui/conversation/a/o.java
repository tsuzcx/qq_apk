package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public final class o
  extends b
{
  private boolean XFO;
  private WeImageView jQn;
  private View rSI;
  private View rSJ;
  private TextView titleTv;
  
  public o(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38853);
    this.XFO = false;
    if ((!this.XFO) && (this.view != null))
    {
      this.rSI = this.view.findViewById(R.h.banner);
      this.rSJ = this.view.findViewById(R.h.banner_root);
      this.jQn = ((WeImageView)this.view.findViewById(R.h.dtc));
      this.jQn.setIconColor(((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50));
      this.titleTv = ((TextView)this.view.findViewById(R.h.dtd));
      this.XFO = true;
    }
    AppMethodBeat.o(38853);
  }
  
  private static boolean w(Object paramObject, int paramInt)
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
  
  public final boolean ckL()
  {
    AppMethodBeat.i(38855);
    Object localObject;
    boolean bool;
    if ((this.isFirst) && (this.kUc))
    {
      this.rSJ.setBackgroundResource(R.g.tips_bar_white_selector);
      this.rSI.setBackground(null);
      this.titleTv.setBackground(null);
      bh.beI();
      if (!c.aGK()) {
        break label219;
      }
      bh.beI();
      if (!com.tencent.mm.modelsimple.o.wK(c.bbI())) {
        break label219;
      }
      localObject = bh.aGY();
      bh.beI();
      ((t)localObject).a(new com.tencent.mm.modelsimple.o(c.bbI()), 0);
      bool = false;
    }
    for (;;)
    {
      label94:
      if (bool) {
        setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(38855);
        return bool;
        if (this.isFirst)
        {
          this.rSJ.setBackgroundResource(R.g.list_item_top_selector);
          this.rSI.setBackgroundResource(R.g.list_item_top_normal);
          this.titleTv.setBackgroundResource(R.g.list_item_normal);
          break;
        }
        if (this.kUc)
        {
          this.rSJ.setBackgroundResource(R.g.list_item_top_selector);
          this.rSI.setBackgroundResource(R.g.list_item_normal);
          this.titleTv.setBackground(null);
          break;
        }
        this.rSJ.setBackgroundResource(R.g.list_item_top_selector);
        this.rSI.setBackground(null);
        this.titleTv.setBackgroundResource(R.g.list_item_normal);
        break;
        label219:
        bh.beI();
        if ((c.aGK()) && (!Util.isNullOrNil(com.tencent.mm.modelsimple.o.lZx)) && (!com.tencent.mm.modelsimple.o.bos()))
        {
          if (z.awX()) {
            if ((!com.tencent.mm.modelsimple.o.bow()) && (com.tencent.mm.modelsimple.o.bot()))
            {
              this.titleTv.setText(com.tencent.mm.modelsimple.o.lZD);
              label272:
              this.jQn.setIconColor(((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50));
              if (com.tencent.mm.modelsimple.o.bor() != 1) {
                break label459;
              }
              if (w(this.jQn.getTag(), R.k.icons_outlined_display))
              {
                this.jQn.setTag(Integer.valueOf(R.k.icons_outlined_display));
                this.jQn.setImageResource(R.k.icons_outlined_display);
              }
            }
          }
          for (;;)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("intent.key.online_version", com.tencent.mm.modelsimple.o.bou());
            this.view.setOnClickListener(new o.1(this, (Intent)localObject));
            bool = true;
            break;
            this.titleTv.setText(com.tencent.mm.modelsimple.o.lZx + " " + com.tencent.mm.modelsimple.o.lZy);
            break label272;
            if ((!com.tencent.mm.modelsimple.o.bow()) && (com.tencent.mm.modelsimple.o.bot()))
            {
              this.titleTv.setText(com.tencent.mm.modelsimple.o.lZE);
              break label272;
            }
            this.titleTv.setText(com.tencent.mm.modelsimple.o.lZB);
            break label272;
            label459:
            if (com.tencent.mm.modelsimple.o.bor() == 2)
            {
              if (com.tencent.mm.modelsimple.o.bot())
              {
                if (w(this.jQn.getTag(), R.k.icons_outlined_imac_lock))
                {
                  this.jQn.setTag(Integer.valueOf(R.k.icons_outlined_imac_lock));
                  this.jQn.setImageResource(R.k.icons_outlined_imac_lock);
                }
              }
              else if (w(this.jQn.getTag(), R.k.icons_outlined_imac))
              {
                this.jQn.setTag(Integer.valueOf(R.k.icons_outlined_imac));
                this.jQn.setImageResource(R.k.icons_outlined_imac);
              }
            }
            else if (com.tencent.mm.modelsimple.o.bor() == 3)
            {
              if (w(this.jQn.getTag(), R.k.icons_outlined_pad))
              {
                this.jQn.setTag(Integer.valueOf(R.k.icons_outlined_pad));
                this.jQn.setImageResource(R.k.icons_outlined_pad);
              }
            }
            else if (com.tencent.mm.modelsimple.o.bor() == 6)
            {
              if (w(this.jQn.getTag(), R.k.connect_car))
              {
                this.jQn.setTag(Integer.valueOf(R.k.connect_car));
                this.jQn.setImageResource(R.k.connect_car);
              }
            }
            else if (com.tencent.mm.modelsimple.o.bor() == 7)
            {
              if (w(this.jQn.getTag(), R.k.connect_kidwatch))
              {
                this.jQn.setTag(Integer.valueOf(R.k.connect_kidwatch));
                this.jQn.setImageResource(R.k.connect_kidwatch);
              }
            }
            else if (com.tencent.mm.modelsimple.o.bor() == 8)
            {
              if (w(this.jQn.getTag(), R.k.icons_outlined_android_pad))
              {
                this.jQn.setTag(Integer.valueOf(R.k.icons_outlined_android_pad));
                this.jQn.setImageResource(R.k.icons_outlined_android_pad);
              }
            }
            else if (w(this.jQn.getTag(), R.k.tipsbar_icon_default))
            {
              this.jQn.setTag(Integer.valueOf(R.k.tipsbar_icon_default));
              this.jQn.setImageResource(R.k.tipsbar_icon_default);
            }
          }
        }
        if ((!BuildInfo.EX_DEVICE_LOGIN) && (!ar.hIE())) {
          break label935;
        }
        bh.beI();
        if (!c.aGK()) {
          break label935;
        }
        int i = com.tencent.mm.modelsimple.o.bov();
        if ((com.tencent.mm.modelsimple.o.bor() != 0) || ((i != 2) && (i != 1))) {
          break label935;
        }
        this.view.setOnClickListener(null);
        if (w(this.jQn.getTag(), R.k.tipsbar_icon_default))
        {
          this.jQn.setTag(Integer.valueOf(R.k.tipsbar_icon_default));
          this.jQn.setImageResource(R.k.tipsbar_icon_default);
        }
        if (i == 2)
        {
          this.titleTv.setText(R.l.eDD);
          bool = true;
          break label94;
        }
        if (i == 1) {
          this.titleTv.setText(R.l.eDE);
        }
        bool = true;
        break label94;
        setVisibility(8);
      }
      label935:
      bool = false;
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.ejO;
  }
  
  public final int getOrder()
  {
    return 2;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38854);
    if (this.rSI != null) {
      this.rSI.setVisibility(paramInt);
    }
    AppMethodBeat.o(38854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.o
 * JD-Core Version:    0.7.0.1
 */