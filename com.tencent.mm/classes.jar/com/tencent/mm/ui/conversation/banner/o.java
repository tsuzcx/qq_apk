package com.tencent.mm.ui.conversation.banner;

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
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.b.a;
import com.tencent.mm.plugin.messenger.b.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class o
  extends b
{
  private boolean aftM;
  private WeImageView mpe;
  private TextView titleTv;
  private View vdX;
  private View vdY;
  
  public o(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38853);
    this.aftM = false;
    if ((!this.aftM) && (this.view != null))
    {
      this.vdX = this.view.findViewById(R.h.banner);
      this.vdY = this.view.findViewById(R.h.banner_root);
      this.mpe = ((WeImageView)this.view.findViewById(R.h.fts));
      this.mpe.setIconColor(((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50));
      this.titleTv = ((TextView)this.view.findViewById(R.h.ftt));
      this.aftM = true;
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
  
  public final boolean cMa()
  {
    AppMethodBeat.i(38855);
    if ((this.isFirst) && (this.nzL))
    {
      this.vdY.setBackgroundResource(R.g.tips_bar_white_selector);
      this.vdX.setBackground(null);
      this.titleTv.setBackground(null);
    }
    Object localObject;
    boolean bool;
    for (;;)
    {
      bh.bCz();
      if (!c.bzw()) {
        break;
      }
      bh.bCz();
      if (!a.aau(c.bzx())) {
        break;
      }
      localObject = bh.aZW();
      bh.bCz();
      ((s)localObject).a(new a(c.bzx()), 0);
      bool = false;
      if (!bool) {
        break label1268;
      }
      setVisibility(0);
      label103:
      AppMethodBeat.o(38855);
      return bool;
      if (this.isFirst)
      {
        this.vdY.setBackgroundResource(R.g.list_item_top_selector);
        this.vdX.setBackgroundResource(R.g.list_item_top_normal);
        this.titleTv.setBackgroundResource(R.g.list_item_normal);
      }
      else if (this.nzL)
      {
        this.vdY.setBackgroundResource(R.g.list_item_top_selector);
        this.vdX.setBackgroundResource(R.g.list_item_normal);
        this.titleTv.setBackground(null);
      }
      else
      {
        this.vdY.setBackgroundResource(R.g.list_item_top_selector);
        this.vdX.setBackground(null);
        this.titleTv.setBackgroundResource(R.g.list_item_normal);
      }
    }
    bh.bCz();
    StringBuilder localStringBuilder;
    if ((c.bzw()) && (!Util.isNullOrNil(a.KPK)) && (!a.gaN())) {
      if (a.gaJ())
      {
        localStringBuilder = new StringBuilder(MMApplicationContext.getContext().getString(R.l.gQY, new Object[] { a.gaL().size() }));
        Iterator localIterator = a.gaL().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (a.a)localIterator.next();
        } while ((((a.a)localObject).KQc) || (!((a.a)localObject).KQf));
      }
    }
    for (;;)
    {
      if (z.aRx())
      {
        if (localObject != null) {
          localStringBuilder.append("，").append(((a.a)localObject).KPX);
        }
        label363:
        this.titleTv.setText(localStringBuilder);
        label372:
        this.mpe.setIconColor(((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50));
        if (a.gaM() != 1) {
          break label692;
        }
        if (w(this.mpe.getTag(), R.k.icons_outlined_display))
        {
          this.mpe.setTag(Integer.valueOf(R.k.icons_outlined_display));
          this.mpe.setImageResource(R.k.icons_outlined_display);
        }
      }
      for (;;)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("intent.key.online_version", a.gaP());
        this.view.setOnClickListener(new o.1(this, (Intent)localObject));
        bool = true;
        break;
        localStringBuilder.append("，");
        if (localObject != null)
        {
          localStringBuilder.append(((a.a)localObject).KPY);
          break label363;
        }
        localStringBuilder.append(MMApplicationContext.getContext().getString(R.l.gQX));
        break label363;
        localObject = a.gaK();
        if (z.aRx())
        {
          if ((localObject != null) && (!((a.a)localObject).KQc) && (((a.a)localObject).KQf))
          {
            this.titleTv.setText(((a.a)localObject).KPX);
            break label372;
          }
          this.titleTv.setText(a.KPK + " " + a.KPL);
          break label372;
        }
        if (localObject != null)
        {
          if ((!((a.a)localObject).KQc) && (((a.a)localObject).KQf))
          {
            this.titleTv.setText(((a.a)localObject).KPY);
            break label372;
          }
          this.titleTv.setText(((a.a)localObject).KPU);
          break label372;
        }
        this.titleTv.setText(a.KPK + " " + a.KPL);
        break label372;
        label692:
        if (a.gaM() == 2)
        {
          localObject = a.gaK();
          if ((localObject != null) && (((a.a)localObject).KQf))
          {
            if (w(this.mpe.getTag(), R.k.icons_outlined_imac_lock))
            {
              this.mpe.setTag(Integer.valueOf(R.k.icons_outlined_imac_lock));
              this.mpe.setImageResource(R.k.icons_outlined_imac_lock);
            }
          }
          else if (w(this.mpe.getTag(), R.k.icons_outlined_imac))
          {
            this.mpe.setTag(Integer.valueOf(R.k.icons_outlined_imac));
            this.mpe.setImageResource(R.k.icons_outlined_imac);
          }
        }
        else if (a.gaM() == 3)
        {
          if (w(this.mpe.getTag(), R.k.icons_outlined_pad))
          {
            this.mpe.setTag(Integer.valueOf(R.k.icons_outlined_pad));
            this.mpe.setImageResource(R.k.icons_outlined_pad);
          }
        }
        else if (a.gaM() == 6)
        {
          if (w(this.mpe.getTag(), R.k.icons_outlined_car))
          {
            this.mpe.setTag(Integer.valueOf(R.k.icons_outlined_car));
            this.mpe.setImageResource(R.k.icons_outlined_car);
          }
        }
        else if (a.gaM() == 7)
        {
          if (w(this.mpe.getTag(), R.k.connect_kidwatch))
          {
            this.mpe.setTag(Integer.valueOf(R.k.connect_kidwatch));
            this.mpe.setImageResource(R.k.connect_kidwatch);
          }
        }
        else if (a.gaM() == 8)
        {
          if (w(this.mpe.getTag(), R.k.icons_outlined_android_pad))
          {
            this.mpe.setTag(Integer.valueOf(R.k.icons_outlined_android_pad));
            this.mpe.setImageResource(R.k.icons_outlined_android_pad);
          }
        }
        else if (a.gaM() == 9)
        {
          if (w(this.mpe.getTag(), R.k.icons_outlined_multi_device))
          {
            this.mpe.setTag(Integer.valueOf(R.k.icons_outlined_multi_device));
            this.mpe.setImageResource(R.k.icons_outlined_multi_device);
          }
        }
        else if (a.gaM() == 10)
        {
          if (w(this.mpe.getTag(), R.k.icons_outlined_folder))
          {
            this.mpe.setTag(Integer.valueOf(R.k.icons_outlined_folder));
            this.mpe.setImageResource(R.k.icons_outlined_folder);
          }
        }
        else if (w(this.mpe.getTag(), R.k.tipsbar_icon_default))
        {
          this.mpe.setTag(Integer.valueOf(R.k.tipsbar_icon_default));
          this.mpe.setImageResource(R.k.tipsbar_icon_default);
        }
      }
      if ((BuildInfo.EX_DEVICE_LOGIN) || (aw.jkP()))
      {
        bh.bCz();
        if (c.bzw())
        {
          int i = a.gaQ();
          if ((a.gaM() == 0) && ((i == 2) || (i == 1)))
          {
            this.view.setOnClickListener(null);
            if (w(this.mpe.getTag(), R.k.tipsbar_icon_default))
            {
              this.mpe.setTag(Integer.valueOf(R.k.tipsbar_icon_default));
              this.mpe.setImageResource(R.k.tipsbar_icon_default);
            }
            if (i == 2)
            {
              this.titleTv.setText(R.l.gGr);
              bool = true;
              break;
            }
            if (i == 1) {
              this.titleTv.setText(R.l.gGs);
            }
            bool = true;
            break;
            label1268:
            setVisibility(8);
            break label103;
          }
        }
      }
      bool = false;
      break;
      localObject = null;
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.gmR;
  }
  
  public final int getOrder()
  {
    return 2;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38854);
    if (this.vdX != null) {
      this.vdX.setVisibility(paramInt);
    }
    AppMethodBeat.o(38854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.o
 * JD-Core Version:    0.7.0.1
 */