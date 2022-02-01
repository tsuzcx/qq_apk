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
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.o;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  extends r<an>
  implements com.tencent.mm.ak.f
{
  public String[] JPd;
  public String KFj;
  private boolean Lma;
  private an Lmb;
  private boolean Lmc;
  public boolean Lmd;
  private boolean Lme;
  private Context context;
  private int dmr;
  private ProgressDialog fOC;
  private List<String> fUR;
  private LinkedList<cyu> hFT;
  public com.tencent.mm.ui.applet.b jgu;
  private b.b jgv;
  public String xYX;
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext, new an());
    AppMethodBeat.i(39544);
    this.Lma = false;
    this.Lmb = null;
    this.hFT = new LinkedList();
    this.fUR = null;
    this.Lmc = true;
    this.fOC = null;
    this.Lmd = false;
    this.dmr = 1;
    this.jgu = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
    {
      public final Bitmap Kc(String paramAnonymousString)
      {
        AppMethodBeat.i(39532);
        paramAnonymousString = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(39532);
        return paramAnonymousString;
      }
    });
    this.jgv = null;
    this.Lme = false;
    this.context = paramContext;
    this.dmr = paramInt;
    this.Lmb = new an();
    this.Lmb.setUsername("_find_more_public_contact_");
    this.Lmb.adb();
    this.KFj = "@micromsg.with.all.biz.qq.com";
    AppMethodBeat.o(39544);
  }
  
  public static String aZc(String paramString)
  {
    AppMethodBeat.i(39562);
    String str = paramString.trim();
    paramString = str;
    if (str.startsWith("@")) {
      paramString = str.substring(1) + "%@micromsg.with.all.biz.qq.com";
    }
    ae.d("MicroMsg.SearchResultAdapter", "translateQueryText [" + paramString + "]");
    AppMethodBeat.o(39562);
    return paramString;
  }
  
  public final an Ga(int paramInt)
  {
    AppMethodBeat.i(39551);
    if (Iw(paramInt))
    {
      localan = (an)dcP();
      AppMethodBeat.o(39551);
      return localan;
    }
    an localan = (an)super.getItem(paramInt);
    AppMethodBeat.o(39551);
    return localan;
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(39557);
    sa(false);
    AppMethodBeat.o(39557);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(39559);
    dhl();
    sa(false);
    AppMethodBeat.o(39559);
  }
  
  public final void aG(final Runnable paramRunnable)
  {
    AppMethodBeat.i(39564);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      notifyDataSetChanged();
      AppMethodBeat.o(39564);
      return;
    }
    ar.f(new Runnable()
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
  
  public final void aZb(final String paramString)
  {
    AppMethodBeat.i(39553);
    aG(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39538);
        if (b.b(b.this).isHidden())
        {
          b.b(b.this).adc();
          if (b.c(b.this))
          {
            com.tencent.mm.plugin.messenger.a.f localf = new com.tencent.mm.plugin.messenger.a.f(paramString, 3);
            bc.ajj().a(localf, 0);
            b.d(b.this);
            AppMethodBeat.o(39538);
          }
        }
        else
        {
          b.b(b.this).adb();
        }
        AppMethodBeat.o(39538);
      }
    });
    AppMethodBeat.o(39553);
  }
  
  public final boolean aZd(String paramString)
  {
    AppMethodBeat.i(39565);
    if ((this.fUR != null) && (paramString != null))
    {
      Iterator localIterator = this.fUR.iterator();
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
  
  public final cyu afF(int paramInt)
  {
    AppMethodBeat.i(39550);
    try
    {
      ae.d("MicroMsg.SearchResultAdapter", "position " + paramInt + " size " + this.hFT.size() + "  " + (paramInt - getRealCount()));
      cyu localcyu = (cyu)this.hFT.get(paramInt - getRealCount() - 1);
      AppMethodBeat.o(39550);
      return localcyu;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SearchResultAdapter", localException, "", new Object[0]);
      AppMethodBeat.o(39550);
    }
    return null;
  }
  
  public final boolean afG(int paramInt)
  {
    AppMethodBeat.i(39554);
    if (this.Lma)
    {
      int i = getRealCount();
      if ((paramInt == i) && (paramInt < i + dcN()))
      {
        AppMethodBeat.o(39554);
        return true;
      }
    }
    AppMethodBeat.o(39554);
    return false;
  }
  
  public final int dcN()
  {
    int i = 0;
    AppMethodBeat.i(39549);
    if (this.Lma)
    {
      if (this.Lmb.isHidden()) {}
      for (;;)
      {
        AppMethodBeat.o(39549);
        return i + 1;
        i = this.hFT.size();
      }
    }
    AppMethodBeat.o(39549);
    return 0;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(39547);
    if (this.jgu != null)
    {
      this.jgu.detach();
      this.jgu = null;
    }
    AppMethodBeat.o(39547);
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(39548);
    if (this.dmr == 2)
    {
      AppMethodBeat.o(39548);
      return 2;
    }
    if (afG(paramInt))
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
    boolean bool1 = Iw(paramInt);
    boolean bool2 = afG(paramInt);
    Object localObject4;
    if ((this.Lma) && (bool1))
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
          if (((a)localObject1).Lmi == null) {
            paramViewGroup = null;
          }
        }
      }
      if (paramViewGroup == null) {
        if (bool2)
        {
          paramViewGroup = View.inflate(this.context, 2131493599, null);
          paramView = new a();
          paramView.fRI = ((TextView)paramViewGroup.findViewById(2131298729));
          paramView.Lmi = ((ProgressBar)paramViewGroup.findViewById(2131304438));
          paramViewGroup.setTag(paramView);
        }
      }
      for (;;)
      {
        if (!bool2)
        {
          if (this.jgv == null) {
            this.jgv = new b.b()
            {
              public final int aTk()
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
              
              public final String rq(int paramAnonymousInt)
              {
                AppMethodBeat.i(39539);
                if (paramAnonymousInt < 0)
                {
                  ae.e("MicroMsg.SearchResultAdapter", "pos is invalid");
                  AppMethodBeat.o(39539);
                  return null;
                }
                Object localObject = b.this;
                localObject = ((b)localObject).afF(b.e((b)localObject) + paramAnonymousInt + 1);
                if (localObject == null)
                {
                  AppMethodBeat.o(39539);
                  return null;
                }
                localObject = ((cyu)localObject).GuF.HId;
                AppMethodBeat.o(39539);
                return localObject;
              }
            };
          }
          if (this.jgu != null) {
            this.jgu.a(paramInt - getRealCount() - 1, this.jgv);
          }
          localObject1 = afF(paramInt);
          paramView.vcs.setVisibility(8);
          if (localObject1 == null)
          {
            AppMethodBeat.o(39556);
            return paramViewGroup;
            paramViewGroup = View.inflate(this.context, 2131493644, null);
            paramView = new a();
            paramView.vcs = ((TextView)paramViewGroup.findViewById(2131298724));
            paramView.fVG = ((MaskLayout)paramViewGroup.findViewById(2131298721));
            paramView.fRI = ((TextView)paramViewGroup.findViewById(2131298729));
            paramView.iYl = ((CheckBox)paramViewGroup.findViewById(2131298731));
            paramView.Bmz = ((TextView)paramViewGroup.findViewById(2131298719));
            paramViewGroup.setTag(paramView);
            continue;
            paramView = (a)paramViewGroup.getTag();
          }
          else
          {
            paramView.Bmz.setVisibility(8);
            a.b.c((ImageView)paramView.fVG.getContentView(), ((cyu)localObject1).GuF.HId);
            if (((cyu)localObject1).Hhu != 0) {
              if (au.a.hII != null)
              {
                localObject4 = au.a.hII.ov(((cyu)localObject1).Hhu);
                if (localObject4 != null)
                {
                  localObject4 = o.EI((String)localObject4);
                  paramView.fVG.a((Bitmap)localObject4, MaskLayout.a.JJQ);
                  localObject1 = bu.nullAsNil(((cyu)localObject1).Hed.HId);
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
          paramView.fRI.setText(k.b(this.context, (CharSequence)localObject1, paramView.fRI.getTextSize()));
          AppMethodBeat.o(39556);
          return paramViewGroup;
          paramView.fVG.setMaskDrawable(null);
          break;
          paramView.fVG.setMaskDrawable(null);
          break;
          paramView.fVG.setMaskDrawable(null);
        }
        catch (Exception localException1)
        {
          ae.printErrStackTrace("MicroMsg.SearchResultAdapter", localException1, "", new Object[0]);
          paramView.fRI.setText("");
          continue;
        }
        if (this.Lme) {
          paramView.Lmi.setVisibility(0);
        }
        for (;;)
        {
          ae.d("MicroMsg.SearchResultAdapter", "refresh  " + this.Lmc);
          if (((this.hFT != null) && (this.hFT.size() != 0)) || (this.Lmc)) {
            break label621;
          }
          paramView.fRI.setText(this.context.getString(2131755213));
          paramView.fRI.setTextColor(this.context.getResources().getColor(2131100544));
          break;
          paramView.Lmi.setVisibility(8);
        }
        label621:
        paramView.fRI.setText(this.context.getString(2131755214));
        paramView.fRI.setTextColor(com.tencent.mm.cb.a.m(this.context, 2131100638));
      }
    }
    if (this.dmr == 2)
    {
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2131495857, null);
        paramViewGroup = new a();
        paramViewGroup.fRI = ((TextView)paramView.findViewById(2131298729));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject2 = Ga(paramInt);
        paramViewGroup.fRI.setTextColor(com.tencent.mm.cb.a.m(this.context, 2131100638));
        try
        {
          localObject2 = this.context.getString(2131764762, new Object[] { w.b((an)localObject2, ((aw)localObject2).field_username) });
          paramViewGroup.fRI.setText(k.b(this.context, (CharSequence)localObject2, paramViewGroup.fRI.getTextSize()));
          paramViewGroup.fRI.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          AppMethodBeat.o(39556);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            paramViewGroup.fRI.setText("");
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
        paramView = com.tencent.mm.ui.z.jV(this.context).inflate(2131493644, null);
        paramViewGroup = new a();
        paramViewGroup.vcs = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.fVG = ((MaskLayout)paramView.findViewById(2131298721));
        paramViewGroup.fRI = ((TextView)paramView.findViewById(2131298729));
        paramViewGroup.iYl = ((CheckBox)paramView.findViewById(2131298731));
        paramViewGroup.Bmz = ((TextView)paramView.findViewById(2131298719));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject3 = Ga(paramInt);
        if (paramViewGroup.vcs != null) {
          paramViewGroup.vcs.setVisibility(8);
        }
        localObject4 = paramViewGroup.fRI;
        Context localContext = this.context;
        if (!x.AZ(((aw)localObject3).field_username)) {
          paramInt = 2131100638;
        }
        for (;;)
        {
          ((TextView)localObject4).setTextColor(com.tencent.mm.cb.a.m(localContext, paramInt));
          a.b.c((ImageView)paramViewGroup.fVG.getContentView(), ((aw)localObject3).field_username);
          paramViewGroup.Bmz.setVisibility(8);
          if (((aw)localObject3).field_verifyFlag != 0) {
            if (au.a.hII != null)
            {
              localObject4 = au.a.hII.ov(((aw)localObject3).field_verifyFlag);
              if (localObject4 != null)
              {
                localObject4 = o.EI((String)localObject4);
                paramViewGroup.fVG.a((Bitmap)localObject4, MaskLayout.a.JJQ);
              }
            }
          }
          try
          {
            label1091:
            localObject4 = k.b(this.context, w.zP(((aw)localObject3).field_username), (int)paramViewGroup.fRI.getTextSize());
            if (x.zW(((aw)localObject3).field_username))
            {
              localObject3 = ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).a(this.context, (CharSequence)localObject4);
              paramViewGroup.fRI.setText((CharSequence)localObject3);
            }
            for (;;)
            {
              AppMethodBeat.o(39556);
              return paramView;
              paramInt = 2131100639;
              break;
              paramViewGroup.fVG.setMaskDrawable(null);
              break label1091;
              paramViewGroup.fVG.setMaskDrawable(null);
              break label1091;
              paramViewGroup.fVG.setMaskDrawable(null);
              break label1091;
              paramViewGroup.fRI.setText((CharSequence)localObject4);
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              paramViewGroup.fRI.setText("");
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
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(39555);
    if ((afG(paramInt)) && ((this.hFT == null) || (this.hFT.size() == 0)) && (!this.Lmc))
    {
      AppMethodBeat.o(39555);
      return false;
    }
    AppMethodBeat.o(39555);
    return true;
  }
  
  public final void iy(final List<String> paramList)
  {
    AppMethodBeat.i(39545);
    aG(new Runnable()
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
  
  public final void onPause()
  {
    AppMethodBeat.i(39561);
    bc.ajj().b(106, this);
    AppMethodBeat.o(39561);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(39560);
    bc.ajj().a(106, this);
    AppMethodBeat.o(39560);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(39563);
    ae.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() != 106)
    {
      ae.e("MicroMsg.SearchResultAdapter", "error type");
      AppMethodBeat.o(39563);
      return;
    }
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    this.Lme = false;
    if (y.a.a(this.context, paramInt1, paramInt2, paramString, 7))
    {
      this.Lmc = false;
      AppMethodBeat.o(39563);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      aG(new Runnable()
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
      aG(new Runnable()
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
    aG(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39534);
        Object localObject1 = ((com.tencent.mm.plugin.messenger.a.f)paramn).doB();
        ae.d("MicroMsg.SearchResultAdapter", "count " + ((cyw)localObject1).GQu);
        if (((cyw)localObject1).GQu > 0)
        {
          localObject1 = ((cyw)localObject1).GQv.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (cyu)((Iterator)localObject1).next();
            if (x.oq(((cyu)localObject2).Hhu))
            {
              if (b.f(b.this) == null) {
                b.a(b.this, new LinkedList());
              }
              b.f(b.this).add(localObject2);
            }
          }
        }
        Object localObject2 = com.tencent.mm.platformtools.z.a(((cyw)localObject1).GuF);
        ae.d("MicroMsg.SearchResultAdapter", "user ".concat(String.valueOf(localObject2)));
        if (bu.nullAsNil((String)localObject2).length() > 0)
        {
          cyu localcyu = new cyu();
          localcyu.GuF = ((cyw)localObject1).GuF;
          localcyu.Hhu = ((cyw)localObject1).Hhu;
          localcyu.jfY = ((cyw)localObject1).jfY;
          localcyu.Hed = ((cyw)localObject1).Hed;
          localcyu.jga = ((cyw)localObject1).jga;
          localcyu.jge = ((cyw)localObject1).jge;
          localcyu.jfX = ((cyw)localObject1).jfX;
          localcyu.jfW = ((cyw)localObject1).jfW;
          localcyu.jfV = ((cyw)localObject1).jfV;
          localcyu.Hhv = ((cyw)localObject1).Hhv;
          localcyu.Hhy = ((cyw)localObject1).Hhy;
          localcyu.Hhw = ((cyw)localObject1).Hhw;
          localcyu.Hhx = ((cyw)localObject1).Hhx;
          localcyu.HhA = ((cyw)localObject1).HhA;
          p.aEA().h((String)localObject2, com.tencent.mm.platformtools.z.a(((cyw)localObject1).FNK));
          if (b.f(b.this) == null) {
            b.a(b.this, new LinkedList());
          }
          b.f(b.this).clear();
          if (x.oq(localcyu.Hhu)) {
            b.f(b.this).add(localcyu);
          }
          ae.d("MicroMsg.SearchResultAdapter", "count " + b.f(b.this).size());
        }
        b.b(b.this, false);
        AppMethodBeat.o(39534);
      }
    });
    AppMethodBeat.o(39563);
  }
  
  public final void sa(final boolean paramBoolean)
  {
    AppMethodBeat.i(39558);
    aG(new Runnable()
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
            if (b.this.aZd((String)localObject3)) {
              ((List)localObject1).add(localObject3);
            }
            i += 1;
          }
          if (((List)localObject1).size() > 0)
          {
            localObject2 = b.this;
            bc.aCg();
            b.a((b)localObject2, com.tencent.mm.model.c.azF().a((String[])((List)localObject1).toArray(new String[((List)localObject1).size()]), b.h(b.this), b.a(b.this)));
            AppMethodBeat.o(39541);
            return;
          }
          localObject1 = b.this;
          bc.aCg();
          b.b((b)localObject1, com.tencent.mm.model.c.azF().fuH());
          AppMethodBeat.o(39541);
          return;
        }
        if (b.i(b.this) != null)
        {
          if (!b.h(b.this).equals("@all.chatroom.contact"))
          {
            localObject1 = bc.aCg().hHe.a(b.i(b.this), b.h(b.this), b.a(b.this), true);
            b.c(b.this, (Cursor)localObject1);
            AppMethodBeat.o(39541);
            return;
          }
          if (paramBoolean)
          {
            localObject1 = bc.aCg().hHe.a(b.i(b.this), "@micromsg.with.all.biz.qq.com.openim", b.a(b.this), false);
            localObject2 = new ArrayList();
            localObject3 = new ArrayList();
          }
          for (;;)
          {
            if (!((Cursor)localObject1).moveToNext()) {
              break label393;
            }
            String str = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("username"));
            if (!x.zT(str))
            {
              ((ArrayList)localObject2).add(str);
              continue;
              localObject1 = bc.aCg().hHe.a(b.i(b.this), "@micromsg.with.all.biz.qq.com", b.a(b.this), false);
              break;
            }
            ((ArrayList)localObject3).add(str);
          }
          label393:
          if (!((Cursor)localObject1).isClosed()) {
            ((Cursor)localObject1).close();
          }
          if ((((ArrayList)localObject2).size() != 0) || (((ArrayList)localObject3).size() != 0)) {}
          for (localObject1 = bc.aCg().hHe.a(b.i(b.this), (ArrayList)localObject2, null, (ArrayList)localObject3, b.a(b.this));; localObject1 = com.tencent.mm.model.c.azF().fuH())
          {
            b.d(b.this, (Cursor)localObject1);
            AppMethodBeat.o(39541);
            return;
            bc.aCg();
          }
        }
        Object localObject1 = b.this;
        bc.aCg();
        b.e((b)localObject1, com.tencent.mm.model.c.azF().fuH());
        AppMethodBeat.o(39541);
      }
    });
    AppMethodBeat.o(39558);
  }
  
  public final void yV(boolean paramBoolean)
  {
    AppMethodBeat.i(39546);
    this.Lmd = paramBoolean;
    if (paramBoolean) {
      this.Lmb.adb();
    }
    AppMethodBeat.o(39546);
  }
  
  public final void yW(final boolean paramBoolean)
  {
    AppMethodBeat.i(39552);
    aG(new Runnable()
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
    public TextView Bmz;
    public ProgressBar Lmi;
    public TextView fRI;
    public MaskLayout fVG;
    public CheckBox iYl;
    public TextView vcs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b
 * JD-Core Version:    0.7.0.1
 */