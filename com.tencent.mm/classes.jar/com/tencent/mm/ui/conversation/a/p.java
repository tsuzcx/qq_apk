package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public final class p
  extends b
{
  private boolean Anm;
  private WeImageView Any;
  private View jGC;
  private View jGD;
  private TextView titleTv;
  
  public p(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(34728);
    this.Anm = false;
    if ((!this.Anm) && (this.view != null))
    {
      this.jGC = this.view.findViewById(2131824232);
      this.jGD = this.view.findViewById(2131821667);
      this.Any = ((WeImageView)this.view.findViewById(2131826645));
      this.Any.setIconColor(((Context)this.vUD.get()).getResources().getColor(2131690589));
      this.titleTv = ((TextView)this.view.findViewById(2131826646));
      this.Anm = true;
    }
    AppMethodBeat.o(34728);
  }
  
  private static boolean j(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(34731);
    if (paramObject == null)
    {
      AppMethodBeat.o(34731);
      return true;
    }
    if (((Integer)paramObject).intValue() != paramInt)
    {
      AppMethodBeat.o(34731);
      return true;
    }
    AppMethodBeat.o(34731);
    return false;
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(34730);
    Object localObject;
    boolean bool;
    if ((this.nwf) && (this.eUx))
    {
      this.jGD.setBackgroundResource(2130840583);
      this.jGC.setBackground(null);
      this.titleTv.setBackground(null);
      aw.aaz();
      if (!c.Yw()) {
        break label211;
      }
      aw.aaz();
      if (!n.lT(c.Yx())) {
        break label211;
      }
      localObject = aw.Rc();
      aw.aaz();
      ((com.tencent.mm.ai.p)localObject).a(new n(c.Yx()), 0);
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
        AppMethodBeat.o(34730);
        return bool;
        if (this.nwf)
        {
          this.jGD.setBackgroundResource(2130839279);
          this.jGC.setBackgroundResource(2130839278);
          this.titleTv.setBackgroundResource(2130839276);
          break;
        }
        if (this.eUx)
        {
          this.jGD.setBackgroundResource(2130839279);
          this.jGC.setBackgroundResource(2130839276);
          this.titleTv.setBackground(null);
          break;
        }
        this.jGD.setBackgroundResource(2130839279);
        this.jGC.setBackground(null);
        this.titleTv.setBackgroundResource(2130839276);
        break;
        label211:
        aw.aaz();
        if ((c.Yw()) && (!ah.isNullOrNil(n.fPe)) && (!n.ajz()))
        {
          if (r.kt(r.Zt())) {
            if ((!n.ajC()) && (n.ajA()))
            {
              this.titleTv.setText(n.fPl);
              label267:
              this.Any.setIconColor(((Context)this.vUD.get()).getResources().getColor(2131690589));
              if (n.ajy() != 1) {
                break label425;
              }
              if (j(this.Any.getTag(), 2131231504))
              {
                this.Any.setTag(Integer.valueOf(2131231504));
                this.Any.setImageResource(2131231504);
              }
            }
          }
          for (;;)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("intent.key.online_version", n.ajB());
            this.view.setOnClickListener(new p.1(this, (Intent)localObject));
            bool = true;
            break;
            this.titleTv.setText(n.fPe);
            break label267;
            if ((!n.ajC()) && (n.ajA()))
            {
              this.titleTv.setText(n.fPm);
              break label267;
            }
            this.titleTv.setText(n.fPh);
            break label267;
            label425:
            if (n.ajy() == 2)
            {
              if (n.ajA())
              {
                if (j(this.Any.getTag(), 2131231510))
                {
                  this.Any.setTag(Integer.valueOf(2131231510));
                  this.Any.setImageResource(2131231510);
                }
              }
              else if (j(this.Any.getTag(), 2131231509))
              {
                this.Any.setTag(Integer.valueOf(2131231509));
                this.Any.setImageResource(2131231509);
              }
            }
            else if (n.ajy() == 3)
            {
              if (j(this.Any.getTag(), 2131231526))
              {
                this.Any.setTag(Integer.valueOf(2131231526));
                this.Any.setImageResource(2131231526);
              }
            }
            else if (j(this.Any.getTag(), 2131232090))
            {
              this.Any.setTag(Integer.valueOf(2131232090));
              this.Any.setImageResource(2131232090);
            }
          }
        }
        if (!f.EX_DEVICE_LOGIN) {
          break label728;
        }
        aw.aaz();
        if (!c.Yw()) {
          break label728;
        }
        int i = n.getDeviceType();
        if ((n.ajy() != 0) || ((i != 2) && (i != 1))) {
          break label728;
        }
        this.view.setOnClickListener(null);
        if (j(this.Any.getTag(), 2131232090))
        {
          this.Any.setTag(Integer.valueOf(2131232090));
          this.Any.setImageResource(2131232090);
        }
        if (i == 2)
        {
          this.titleTv.setText(2131306159);
          bool = true;
          break label93;
        }
        if (i == 1) {
          this.titleTv.setText(2131306160);
        }
        bool = true;
        break label93;
        setVisibility(8);
      }
      label728:
      bool = false;
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2130970397;
  }
  
  public final int getOrder()
  {
    return 2;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(34729);
    if (this.jGC != null) {
      this.jGC.setVisibility(paramInt);
    }
    AppMethodBeat.o(34729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.p
 * JD-Core Version:    0.7.0.1
 */