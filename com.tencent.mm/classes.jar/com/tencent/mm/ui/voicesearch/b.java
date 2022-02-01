package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.o;
import com.tencent.mm.cc.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.c;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.y.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class b
  extends r<am>
  implements com.tencent.mm.al.f
{
  public String[] Juo;
  private boolean KPC;
  private am KPD;
  private boolean KPE;
  public boolean KPF;
  private boolean KPG;
  public String KiP;
  private Context context;
  private int dlp;
  private ProgressDialog fMu;
  private List<String> fSL;
  private LinkedList<cya> hDb;
  public com.tencent.mm.ui.applet.b jdB;
  private b.b jdC;
  public String xJc;
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext, new am());
    AppMethodBeat.i(39544);
    this.KPC = false;
    this.KPD = null;
    this.hDb = new LinkedList();
    this.fSL = null;
    this.KPE = true;
    this.fMu = null;
    this.KPF = false;
    this.dlp = 1;
    this.jdB = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
    {
      public final Bitmap JD(String paramAnonymousString)
      {
        AppMethodBeat.i(39532);
        paramAnonymousString = com.tencent.mm.ak.c.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(39532);
        return paramAnonymousString;
      }
    });
    this.jdC = null;
    this.KPG = false;
    this.context = paramContext;
    this.dlp = paramInt;
    this.KPD = new am();
    this.KPD.setUsername("_find_more_public_contact_");
    this.KPD.acQ();
    this.KiP = "@micromsg.with.all.biz.qq.com";
    AppMethodBeat.o(39544);
  }
  
  public static String aXA(String paramString)
  {
    AppMethodBeat.i(39562);
    String str = paramString.trim();
    paramString = str;
    if (str.startsWith("@")) {
      paramString = str.substring(1) + "%@micromsg.with.all.biz.qq.com";
    }
    ad.d("MicroMsg.SearchResultAdapter", "translateQueryText [" + paramString + "]");
    AppMethodBeat.o(39562);
    return paramString;
  }
  
  public final am FC(int paramInt)
  {
    AppMethodBeat.i(39551);
    if (HY(paramInt))
    {
      localam = (am)dae();
      AppMethodBeat.o(39551);
      return localam;
    }
    am localam = (am)super.getItem(paramInt);
    AppMethodBeat.o(39551);
    return localam;
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(39557);
    rT(false);
    AppMethodBeat.o(39557);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(39559);
    det();
    rT(false);
    AppMethodBeat.o(39559);
  }
  
  public final void aJ(final Runnable paramRunnable)
  {
    AppMethodBeat.i(39564);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      notifyDataSetChanged();
      AppMethodBeat.o(39564);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39535);
        paramRunnable.run();
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(39535);
      }
    });
    AppMethodBeat.o(39564);
  }
  
  public final boolean aXB(String paramString)
  {
    AppMethodBeat.i(39565);
    if ((this.fSL != null) && (paramString != null))
    {
      Iterator localIterator = this.fSL.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(paramString))
        {
          AppMethodBeat.o(39565);
          return false;
        }
      }
    }
    AppMethodBeat.o(39565);
    return true;
  }
  
  public final void aXz(final String paramString)
  {
    AppMethodBeat.i(39553);
    aJ(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39538);
        if (b.b(b.this).isHidden())
        {
          b.b(b.this).acR();
          if (b.c(b.this))
          {
            com.tencent.mm.plugin.messenger.a.f localf = new com.tencent.mm.plugin.messenger.a.f(paramString, 3);
            ba.aiU().a(localf, 0);
            b.d(b.this);
            AppMethodBeat.o(39538);
          }
        }
        else
        {
          b.b(b.this).acQ();
        }
        AppMethodBeat.o(39538);
      }
    });
    AppMethodBeat.o(39553);
  }
  
  public final cya aeW(int paramInt)
  {
    AppMethodBeat.i(39550);
    try
    {
      ad.d("MicroMsg.SearchResultAdapter", "position " + paramInt + " size " + this.hDb.size() + "  " + (paramInt - getRealCount()));
      cya localcya = (cya)this.hDb.get(paramInt - getRealCount() - 1);
      AppMethodBeat.o(39550);
      return localcya;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SearchResultAdapter", localException, "", new Object[0]);
      AppMethodBeat.o(39550);
    }
    return null;
  }
  
  public final boolean aeX(int paramInt)
  {
    AppMethodBeat.i(39554);
    if (this.KPC)
    {
      int i = getRealCount();
      if ((paramInt == i) && (paramInt < i + dac()))
      {
        AppMethodBeat.o(39554);
        return true;
      }
    }
    AppMethodBeat.o(39554);
    return false;
  }
  
  public final int dac()
  {
    int i = 0;
    AppMethodBeat.i(39549);
    if (this.KPC)
    {
      if (this.KPD.isHidden()) {}
      for (;;)
      {
        AppMethodBeat.o(39549);
        return i + 1;
        i = this.hDb.size();
      }
    }
    AppMethodBeat.o(39549);
    return 0;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(39547);
    if (this.jdB != null)
    {
      this.jdB.detach();
      this.jdB = null;
    }
    AppMethodBeat.o(39547);
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(39548);
    if (this.dlp == 2)
    {
      AppMethodBeat.o(39548);
      return 2;
    }
    if (aeX(paramInt))
    {
      AppMethodBeat.o(39548);
      return 1;
    }
    AppMethodBeat.o(39548);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39556);
    boolean bool1 = HY(paramInt);
    boolean bool2 = aeX(paramInt);
    Object localObject4;
    if ((this.KPC) && (bool1))
    {
      paramViewGroup = paramView;
      Object localObject1;
      if (paramView != null)
      {
        localObject1 = (a)paramView.getTag();
        paramViewGroup = paramView;
        if (bool2)
        {
          paramViewGroup = paramView;
          if (((a)localObject1).KPK == null) {
            paramViewGroup = null;
          }
        }
      }
      if (paramViewGroup == null) {
        if (bool2)
        {
          paramViewGroup = View.inflate(this.context, 2131493599, null);
          paramView = new a();
          paramView.fPC = ((TextView)paramViewGroup.findViewById(2131298729));
          paramView.KPK = ((ProgressBar)paramViewGroup.findViewById(2131304438));
          paramViewGroup.setTag(paramView);
        }
      }
      for (;;)
      {
        if (!bool2)
        {
          if (this.jdC == null) {
            this.jdC = new b.b()
            {
              public final int aSL()
              {
                AppMethodBeat.i(39540);
                if (b.f(b.this) == null)
                {
                  AppMethodBeat.o(39540);
                  return 0;
                }
                int i = b.f(b.this).size();
                AppMethodBeat.o(39540);
                return i;
              }
              
              public final String rn(int paramAnonymousInt)
              {
                AppMethodBeat.i(39539);
                if (paramAnonymousInt < 0)
                {
                  ad.e("MicroMsg.SearchResultAdapter", "pos is invalid");
                  AppMethodBeat.o(39539);
                  return null;
                }
                Object localObject = b.this;
                localObject = ((b)localObject).aeW(b.e((b)localObject) + paramAnonymousInt + 1);
                if (localObject == null)
                {
                  AppMethodBeat.o(39539);
                  return null;
                }
                localObject = ((cya)localObject).GbY.HoB;
                AppMethodBeat.o(39539);
                return localObject;
              }
            };
          }
          if (this.jdB != null) {
            this.jdB.a(paramInt - getRealCount() - 1, this.jdC);
          }
          localObject1 = aeW(paramInt);
          paramView.uQG.setVisibility(8);
          if (localObject1 == null)
          {
            AppMethodBeat.o(39556);
            return paramViewGroup;
            paramViewGroup = View.inflate(this.context, 2131493644, null);
            paramView = new a();
            paramView.uQG = ((TextView)paramViewGroup.findViewById(2131298724));
            paramView.fTA = ((MaskLayout)paramViewGroup.findViewById(2131298721));
            paramView.fPC = ((TextView)paramViewGroup.findViewById(2131298729));
            paramView.iVs = ((CheckBox)paramViewGroup.findViewById(2131298731));
            paramView.AVb = ((TextView)paramViewGroup.findViewById(2131298719));
            paramViewGroup.setTag(paramView);
            continue;
            paramView = (a)paramViewGroup.getTag();
          }
          else
          {
            paramView.AVb.setVisibility(8);
            a.b.c((ImageView)paramView.fTA.getContentView(), ((cya)localObject1).GbY.HoB);
            if (((cya)localObject1).GNU != 0) {
              if (as.a.hFQ != null)
              {
                localObject4 = as.a.hFQ.os(((cya)localObject1).GNU);
                if (localObject4 != null)
                {
                  localObject4 = o.Eg((String)localObject4);
                  paramView.fTA.a((Bitmap)localObject4, MaskLayout.a.Jpb);
                  localObject1 = bt.nullAsNil(((cya)localObject1).GKC.HoB);
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          paramView.fPC.setText(k.b(this.context, (CharSequence)localObject1, paramView.fPC.getTextSize()));
          AppMethodBeat.o(39556);
          return paramViewGroup;
          paramView.fTA.setMaskDrawable(null);
          break;
          paramView.fTA.setMaskDrawable(null);
          break;
          paramView.fTA.setMaskDrawable(null);
        }
        catch (Exception localException1)
        {
          ad.printErrStackTrace("MicroMsg.SearchResultAdapter", localException1, "", new Object[0]);
          paramView.fPC.setText("");
          continue;
        }
        if (this.KPG) {
          paramView.KPK.setVisibility(0);
        }
        for (;;)
        {
          ad.d("MicroMsg.SearchResultAdapter", "refresh  " + this.KPE);
          if (((this.hDb != null) && (this.hDb.size() != 0)) || (this.KPE)) {
            break label621;
          }
          paramView.fPC.setText(this.context.getString(2131755213));
          paramView.fPC.setTextColor(this.context.getResources().getColor(2131100544));
          break;
          paramView.KPK.setVisibility(8);
        }
        label621:
        paramView.fPC.setText(this.context.getString(2131755214));
        paramView.fPC.setTextColor(a.m(this.context, 2131100638));
      }
    }
    if (this.dlp == 2)
    {
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2131495857, null);
        paramViewGroup = new a();
        paramViewGroup.fPC = ((TextView)paramView.findViewById(2131298729));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject2 = FC(paramInt);
        paramViewGroup.fPC.setTextColor(a.m(this.context, 2131100638));
        try
        {
          localObject2 = this.context.getString(2131764762, new Object[] { v.b((am)localObject2, ((aw)localObject2).field_username) });
          paramViewGroup.fPC.setText(k.b(this.context, (CharSequence)localObject2, paramViewGroup.fPC.getTextSize()));
          paramViewGroup.fPC.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          AppMethodBeat.o(39556);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            paramViewGroup.fPC.setText("");
          }
        }
      }
    }
    if (paramView != null)
    {
      paramViewGroup = (a)paramView.getTag();
      if (paramViewGroup == null) {
        paramView = null;
      }
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramView = com.tencent.mm.ui.z.jO(this.context).inflate(2131493644, null);
        paramViewGroup = new a();
        paramViewGroup.uQG = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.fTA = ((MaskLayout)paramView.findViewById(2131298721));
        paramViewGroup.fPC = ((TextView)paramView.findViewById(2131298729));
        paramViewGroup.iVs = ((CheckBox)paramView.findViewById(2131298731));
        paramViewGroup.AVb = ((TextView)paramView.findViewById(2131298719));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject3 = FC(paramInt);
        if (paramViewGroup.uQG != null) {
          paramViewGroup.uQG.setVisibility(8);
        }
        localObject4 = paramViewGroup.fPC;
        Context localContext = this.context;
        if (!w.Ap(((aw)localObject3).field_username)) {
          paramInt = 2131100638;
        }
        for (;;)
        {
          ((TextView)localObject4).setTextColor(a.m(localContext, paramInt));
          a.b.c((ImageView)paramViewGroup.fTA.getContentView(), ((aw)localObject3).field_username);
          paramViewGroup.AVb.setVisibility(8);
          if (((aw)localObject3).field_verifyFlag != 0) {
            if (as.a.hFQ != null)
            {
              localObject4 = as.a.hFQ.os(((aw)localObject3).field_verifyFlag);
              if (localObject4 != null)
              {
                localObject4 = o.Eg((String)localObject4);
                paramViewGroup.fTA.a((Bitmap)localObject4, MaskLayout.a.Jpb);
              }
            }
          }
          try
          {
            label1091:
            localObject4 = k.b(this.context, v.zf(((aw)localObject3).field_username), (int)paramViewGroup.fPC.getTextSize());
            if (w.zm(((aw)localObject3).field_username))
            {
              localObject3 = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(this.context, (CharSequence)localObject4);
              paramViewGroup.fPC.setText((CharSequence)localObject3);
            }
            for (;;)
            {
              AppMethodBeat.o(39556);
              return paramView;
              paramInt = 2131100639;
              break;
              paramViewGroup.fTA.setMaskDrawable(null);
              break label1091;
              paramViewGroup.fTA.setMaskDrawable(null);
              break label1091;
              paramViewGroup.fTA.setMaskDrawable(null);
              break label1091;
              paramViewGroup.fPC.setText((CharSequence)localObject4);
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              paramViewGroup.fPC.setText("");
            }
          }
        }
      }
      continue;
      paramViewGroup = null;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 3;
  }
  
  public final void io(final List<String> paramList)
  {
    AppMethodBeat.i(39545);
    aJ(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39536);
        if (b.a(b.this) == null) {
          b.a(b.this, new ArrayList());
        }
        b.a(b.this).clear();
        b.a(b.this).addAll(paramList);
        b.a(b.this).add("officialaccounts");
        b.a(b.this).add("helper_entry");
        AppMethodBeat.o(39536);
      }
    });
    AppMethodBeat.o(39545);
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(39555);
    if ((aeX(paramInt)) && ((this.hDb == null) || (this.hDb.size() == 0)) && (!this.KPE))
    {
      AppMethodBeat.o(39555);
      return false;
    }
    AppMethodBeat.o(39555);
    return true;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(39561);
    ba.aiU().b(106, this);
    AppMethodBeat.o(39561);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(39560);
    ba.aiU().a(106, this);
    AppMethodBeat.o(39560);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(39563);
    ad.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() != 106)
    {
      ad.e("MicroMsg.SearchResultAdapter", "error type");
      AppMethodBeat.o(39563);
      return;
    }
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    this.KPG = false;
    if (y.a.a(this.context, paramInt1, paramInt2, paramString, 7))
    {
      this.KPE = false;
      AppMethodBeat.o(39563);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      aJ(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39543);
          b.b(b.this, false);
          AppMethodBeat.o(39543);
        }
      });
      AppMethodBeat.o(39563);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      aJ(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39533);
          b.b(b.this, false);
          AppMethodBeat.o(39533);
        }
      });
      AppMethodBeat.o(39563);
      return;
    }
    aJ(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39534);
        Object localObject1 = ((com.tencent.mm.plugin.messenger.a.f)paramn).dlC();
        ad.d("MicroMsg.SearchResultAdapter", "count " + ((cyc)localObject1).GwU);
        if (((cyc)localObject1).GwU > 0)
        {
          localObject1 = ((cyc)localObject1).GwV.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (cya)((Iterator)localObject1).next();
            if (w.on(((cya)localObject2).GNU))
            {
              if (b.f(b.this) == null) {
                b.a(b.this, new LinkedList());
              }
              b.f(b.this).add(localObject2);
            }
          }
        }
        Object localObject2 = com.tencent.mm.platformtools.z.a(((cyc)localObject1).GbY);
        ad.d("MicroMsg.SearchResultAdapter", "user ".concat(String.valueOf(localObject2)));
        if (bt.nullAsNil((String)localObject2).length() > 0)
        {
          cya localcya = new cya();
          localcya.GbY = ((cyc)localObject1).GbY;
          localcya.GNU = ((cyc)localObject1).GNU;
          localcya.jdf = ((cyc)localObject1).jdf;
          localcya.GKC = ((cyc)localObject1).GKC;
          localcya.jdh = ((cyc)localObject1).jdh;
          localcya.jdl = ((cyc)localObject1).jdl;
          localcya.jde = ((cyc)localObject1).jde;
          localcya.jdd = ((cyc)localObject1).jdd;
          localcya.jdc = ((cyc)localObject1).jdc;
          localcya.GNV = ((cyc)localObject1).GNV;
          localcya.GNY = ((cyc)localObject1).GNY;
          localcya.GNW = ((cyc)localObject1).GNW;
          localcya.GNX = ((cyc)localObject1).GNX;
          localcya.GOa = ((cyc)localObject1).GOa;
          p.aEk().h((String)localObject2, com.tencent.mm.platformtools.z.a(((cyc)localObject1).Fvm));
          if (b.f(b.this) == null) {
            b.a(b.this, new LinkedList());
          }
          b.f(b.this).clear();
          if (w.on(localcya.GNU)) {
            b.f(b.this).add(localcya);
          }
          ad.d("MicroMsg.SearchResultAdapter", "count " + b.f(b.this).size());
        }
        b.b(b.this, false);
        AppMethodBeat.o(39534);
      }
    });
    AppMethodBeat.o(39563);
  }
  
  public final void rT(final boolean paramBoolean)
  {
    AppMethodBeat.i(39558);
    aJ(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(39541);
        Object localObject2;
        Object localObject3;
        if ((b.g(b.this) != null) && (b.g(b.this).length != 0))
        {
          localObject1 = new ArrayList();
          localObject2 = b.g(b.this);
          int j = localObject2.length;
          while (i < j)
          {
            localObject3 = localObject2[i];
            if (b.this.aXB((String)localObject3)) {
              ((List)localObject1).add(localObject3);
            }
            i += 1;
          }
          if (((List)localObject1).size() > 0)
          {
            localObject2 = b.this;
            ba.aBQ();
            b.a((b)localObject2, com.tencent.mm.model.c.azp().a((String[])((List)localObject1).toArray(new String[((List)localObject1).size()]), b.h(b.this), b.a(b.this)));
            AppMethodBeat.o(39541);
            return;
          }
          localObject1 = b.this;
          ba.aBQ();
          b.b((b)localObject1, com.tencent.mm.model.c.azp().fqH());
          AppMethodBeat.o(39541);
          return;
        }
        if (b.i(b.this) != null)
        {
          if (!b.h(b.this).equals("@all.chatroom.contact"))
          {
            localObject1 = ba.aBQ().hEm.a(b.i(b.this), b.h(b.this), b.a(b.this), true);
            b.c(b.this, (Cursor)localObject1);
            AppMethodBeat.o(39541);
            return;
          }
          if (paramBoolean)
          {
            localObject1 = ba.aBQ().hEm.a(b.i(b.this), "@micromsg.with.all.biz.qq.com.openim", b.a(b.this), false);
            localObject2 = new ArrayList();
            localObject3 = new ArrayList();
          }
          for (;;)
          {
            if (!((Cursor)localObject1).moveToNext()) {
              break label393;
            }
            String str = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("username"));
            if (!w.zj(str))
            {
              ((ArrayList)localObject2).add(str);
              continue;
              localObject1 = ba.aBQ().hEm.a(b.i(b.this), "@micromsg.with.all.biz.qq.com", b.a(b.this), false);
              break;
            }
            ((ArrayList)localObject3).add(str);
          }
          label393:
          if (!((Cursor)localObject1).isClosed()) {
            ((Cursor)localObject1).close();
          }
          if ((((ArrayList)localObject2).size() != 0) || (((ArrayList)localObject3).size() != 0)) {}
          for (localObject1 = ba.aBQ().hEm.a(b.i(b.this), (ArrayList)localObject2, null, (ArrayList)localObject3, b.a(b.this));; localObject1 = com.tencent.mm.model.c.azp().fqH())
          {
            b.d(b.this, (Cursor)localObject1);
            AppMethodBeat.o(39541);
            return;
            ba.aBQ();
          }
        }
        Object localObject1 = b.this;
        ba.aBQ();
        b.e((b)localObject1, com.tencent.mm.model.c.azp().fqH());
        AppMethodBeat.o(39541);
      }
    });
    AppMethodBeat.o(39558);
  }
  
  public final void yH(boolean paramBoolean)
  {
    AppMethodBeat.i(39546);
    this.KPF = paramBoolean;
    if (paramBoolean) {
      this.KPD.acQ();
    }
    AppMethodBeat.o(39546);
  }
  
  public final void yI(final boolean paramBoolean)
  {
    AppMethodBeat.i(39552);
    aJ(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39537);
        b.a(b.this, paramBoolean);
        AppMethodBeat.o(39537);
      }
    });
    AppMethodBeat.o(39552);
  }
  
  protected static final class a
  {
    public TextView AVb;
    public ProgressBar KPK;
    public TextView fPC;
    public MaskLayout fTA;
    public CheckBox iVs;
    public TextView uQG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b
 * JD-Core Version:    0.7.0.1
 */