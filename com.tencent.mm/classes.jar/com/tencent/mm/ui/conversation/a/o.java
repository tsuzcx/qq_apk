package com.tencent.mm.ui.conversation.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.aj;
import java.lang.ref.WeakReference;

public final class o
  extends b
{
  private TextView Anf;
  private TextView Ang;
  private ImageView Anh;
  private ImageView Ani;
  private ImageView Anj;
  private ProgressBar Ank;
  String Anl;
  private boolean Anm;
  int Ann;
  boolean Ano;
  boolean Anp;
  boolean Anq;
  String Anr;
  ap Ans;
  c<kv> Ant;
  boolean Anu;
  private ProgressDialog eeN;
  private boolean fIp;
  private TextView gFS;
  TextView gpL;
  private TextView gpM;
  private ImageView ivs;
  View jIo;
  int tng;
  
  public o(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(34719);
    this.eeN = null;
    this.fIp = false;
    this.Anm = false;
    this.tng = 0;
    this.jIo = null;
    this.Anu = false;
    initialize();
    AppMethodBeat.o(34719);
  }
  
  private void initialize()
  {
    AppMethodBeat.i(34720);
    if ((!this.Anm) && (this.view != null))
    {
      this.jIo = this.view.findViewById(2131826506);
      this.gpL = ((TextView)this.view.findViewById(2131826507));
      this.gpM = ((TextView)this.view.findViewById(2131826508));
      this.gFS = ((TextView)this.view.findViewById(2131826509));
      this.Anf = ((TextView)this.view.findViewById(2131824234));
      this.Ank = ((ProgressBar)this.view.findViewById(2131826510));
      this.ivs = ((ImageView)this.view.findViewById(2131824233));
      this.Anh = ((ImageView)this.view.findViewById(2131822762));
      this.Ani = ((ImageView)this.view.findViewById(2131826513));
      this.Anj = ((ImageView)this.view.findViewById(2131826512));
      this.Ang = ((TextView)this.view.findViewById(2131826511));
      this.Anh.setVisibility(8);
      this.Anm = true;
    }
    AppMethodBeat.o(34720);
  }
  
  private static boolean j(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(34723);
    if (paramObject == null)
    {
      AppMethodBeat.o(34723);
      return true;
    }
    if (((Integer)paramObject).intValue() != paramInt)
    {
      AppMethodBeat.o(34723);
      return true;
    }
    AppMethodBeat.o(34723);
    return false;
  }
  
  public final boolean aMK()
  {
    boolean bool3 = true;
    int i = 0;
    AppMethodBeat.i(34722);
    final int j = aw.Rc().adt();
    Object localObject = aw.Rc().getNetworkServerIp();
    this.Anl = String.format("http://w.mail.qq.com/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s", new Object[] { "0x" + Integer.toHexString(d.whH), d.eQs, r.Zn(), localObject, aa.dsG() });
    initialize();
    ab.i("MicroMsg.NetWarnView", "update st:%d", new Object[] { Integer.valueOf(j) });
    boolean bool1;
    boolean bool2;
    switch (j)
    {
    case 1: 
    case 4: 
    default: 
      bool1 = false;
      ((Context)this.vUD.get()).getResources().getColor(2131690589);
      if (bool1)
      {
        this.gFS.setVisibility(8);
        this.gpL.setVisibility(0);
        this.jIo.setBackgroundResource(2130840582);
        localObject = new LinearLayout.LayoutParams(this.ivs.getLayoutParams());
        ((LinearLayout.LayoutParams)localObject).setMargins(com.tencent.mm.cb.a.fromDPToPix((Context)this.vUD.get(), 28), 0, com.tencent.mm.cb.a.fromDPToPix((Context)this.vUD.get(), 24), 0);
        this.ivs.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (j(this.ivs.getTag(), 2131231456))
        {
          this.ivs.setTag(Integer.valueOf(2131231456));
          this.ivs.setImageDrawable(aj.g((Context)this.vUD.get(), 2131231456, ((Context)this.vUD.get()).getResources().getColor(2131689604)));
        }
        this.Ani.setVisibility(8);
        this.Anj.setVisibility(8);
        this.Ang.setVisibility(8);
      }
      bool2 = bool1;
      if (!bool1)
      {
        this.Anh.setVisibility(8);
        bool2 = bool1;
        if (ae.gke)
        {
          j = at.getBackgroundLimitType((Context)this.vUD.get());
          if ((!at.isLimited(j)) || (this.Anu)) {
            break;
          }
          this.gpL.setText(((Context)this.vUD.get()).getString(2131302177));
          this.gpM.setText(((Context)this.vUD.get()).getString(2131302176));
          this.gpM.setVisibility(0);
          this.Anf.setVisibility(8);
          this.Ank.setVisibility(8);
          this.ivs.setVisibility(0);
          this.Anh.setVisibility(0);
          this.jIo.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(34715);
              try
              {
                at.startSettingItent((Context)o.this.vUD.get(), j);
                AppMethodBeat.o(34715);
                return;
              }
              catch (Exception paramAnonymousView)
              {
                ab.printErrStackTrace("MicroMsg.NetWarnView", paramAnonymousView, "", new Object[0]);
                AppMethodBeat.o(34715);
              }
            }
          });
          this.Anh.setOnClickListener(new o.7(this, j));
          bool1 = bool3;
          label537:
          bool2 = bool1;
        }
      }
      if (j(this.Anj.getTag(), 2131231087))
      {
        this.Anj.setTag(Integer.valueOf(2131231087));
        this.Anj.setImageResource(2131231087);
      }
      if (j(this.Anh.getTag(), 2131231087))
      {
        this.Anh.setTag(Integer.valueOf(2131231087));
        this.Anh.setImageResource(2130838014);
      }
      localObject = this.jIo;
      if (!bool2) {}
      break;
    }
    for (;;)
    {
      ((View)localObject).setVisibility(i);
      AppMethodBeat.o(34722);
      return bool2;
      this.gpL.setText(2131301788);
      this.gpM.setVisibility(8);
      this.Anf.setVisibility(8);
      this.Ank.setVisibility(8);
      this.ivs.setVisibility(0);
      this.jIo.setOnClickListener(new o.3(this));
      bool1 = true;
      break;
      this.gpL.setText(2131301784);
      this.gpM.setVisibility(8);
      this.Anf.setVisibility(8);
      this.Ank.setVisibility(0);
      this.ivs.setVisibility(0);
      bool1 = true;
      break;
      if (this.tng == 1) {
        this.gpL.setText(((Context)this.vUD.get()).getResources().getString(2131301787, new Object[] { Integer.valueOf(this.Ann) }));
      }
      for (;;)
      {
        this.gpM.setVisibility(8);
        this.Anf.setVisibility(8);
        this.Ank.setVisibility(8);
        this.ivs.setVisibility(0);
        this.jIo.setOnClickListener(new o.4(this));
        bool1 = true;
        break;
        this.gpL.setText(2131301786);
      }
      this.gpL.setText(2131301789);
      this.gpM.setText(((Context)this.vUD.get()).getString(2131301790));
      this.gpM.setVisibility(0);
      this.Anf.setVisibility(8);
      this.Ank.setVisibility(8);
      this.ivs.setVisibility(0);
      this.jIo.setOnClickListener(new o.5(this));
      bool1 = true;
      break;
      this.Anh.setVisibility(8);
      break label537;
      i = 8;
    }
  }
  
  final void dNe()
  {
    AppMethodBeat.i(34721);
    if (this.Ans != null)
    {
      this.Ans.stopTimer();
      this.Ans = null;
    }
    AppMethodBeat.o(34721);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(34724);
    dNe();
    if (this.Ant != null) {
      com.tencent.mm.sdk.b.a.ymk.d(this.Ant);
    }
    AppMethodBeat.o(34724);
  }
  
  public final int getLayoutId()
  {
    return 2130970349;
  }
  
  public final int getOrder()
  {
    return 4;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(34725);
    if (this.jIo != null) {
      this.jIo.setVisibility(paramInt);
    }
    AppMethodBeat.o(34725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.o
 * JD-Core Version:    0.7.0.1
 */