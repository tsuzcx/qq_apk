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
import com.tencent.mm.ak.q;
import com.tencent.mm.cc.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  extends r<ai>
  implements com.tencent.mm.ak.g
{
  public String[] HGx;
  public boolean IYA;
  private boolean IYB;
  private boolean IYx;
  private ai IYy;
  private boolean IYz;
  public String Isk;
  private int cZX;
  private Context context;
  private ProgressDialog fts;
  private List<String> fzw;
  private LinkedList<csq> hkS;
  public com.tencent.mm.ui.applet.b iKs;
  private b.b iKt;
  public String wzP;
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext, new ai());
    AppMethodBeat.i(39544);
    this.IYx = false;
    this.IYy = null;
    this.hkS = new LinkedList();
    this.fzw = null;
    this.IYz = true;
    this.fts = null;
    this.IYA = false;
    this.cZX = 1;
    this.iKs = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
    {
      public final Bitmap Go(String paramAnonymousString)
      {
        AppMethodBeat.i(39532);
        paramAnonymousString = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(39532);
        return paramAnonymousString;
      }
    });
    this.iKt = null;
    this.IYB = false;
    this.context = paramContext;
    this.cZX = paramInt;
    this.IYy = new ai();
    this.IYy.setUsername("_find_more_public_contact_");
    this.IYy.aao();
    this.Isk = "@micromsg.with.all.biz.qq.com";
    AppMethodBeat.o(39544);
  }
  
  public static String aRC(String paramString)
  {
    AppMethodBeat.i(39562);
    String str = paramString.trim();
    paramString = str;
    if (str.startsWith("@")) {
      paramString = str.substring(1) + "%@micromsg.with.all.biz.qq.com";
    }
    ac.d("MicroMsg.SearchResultAdapter", "translateQueryText [" + paramString + "]");
    AppMethodBeat.o(39562);
    return paramString;
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(39557);
    rp(false);
    AppMethodBeat.o(39557);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(39559);
    cVi();
    rp(false);
    AppMethodBeat.o(39559);
  }
  
  public final void aK(final Runnable paramRunnable)
  {
    AppMethodBeat.i(39564);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      notifyDataSetChanged();
      AppMethodBeat.o(39564);
      return;
    }
    ap.f(new Runnable()
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
  
  public final void aRB(final String paramString)
  {
    AppMethodBeat.i(39553);
    aK(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39538);
        if (b.b(b.this).isHidden())
        {
          b.b(b.this).aap();
          if (b.c(b.this))
          {
            com.tencent.mm.plugin.messenger.a.g localg = new com.tencent.mm.plugin.messenger.a.g(paramString, 3);
            az.agi().a(localg, 0);
            b.d(b.this);
            AppMethodBeat.o(39538);
          }
        }
        else
        {
          b.b(b.this).aao();
        }
        AppMethodBeat.o(39538);
      }
    });
    AppMethodBeat.o(39553);
  }
  
  public final boolean aRD(String paramString)
  {
    AppMethodBeat.i(39565);
    if ((this.fzw != null) && (paramString != null))
    {
      Iterator localIterator = this.fzw.iterator();
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
  
  public final boolean acA(int paramInt)
  {
    AppMethodBeat.i(39554);
    if (this.IYx)
    {
      int i = getRealCount();
      if ((paramInt == i) && (paramInt < i + cRx()))
      {
        AppMethodBeat.o(39554);
        return true;
      }
    }
    AppMethodBeat.o(39554);
    return false;
  }
  
  public final csq acy(int paramInt)
  {
    AppMethodBeat.i(39550);
    try
    {
      ac.d("MicroMsg.SearchResultAdapter", "position " + paramInt + " size " + this.hkS.size() + "  " + (paramInt - getRealCount()));
      csq localcsq = (csq)this.hkS.get(paramInt - getRealCount() - 1);
      AppMethodBeat.o(39550);
      return localcsq;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SearchResultAdapter", localException, "", new Object[0]);
      AppMethodBeat.o(39550);
    }
    return null;
  }
  
  public final ai acz(int paramInt)
  {
    AppMethodBeat.i(39551);
    if (GF(paramInt))
    {
      localai = (ai)cRz();
      AppMethodBeat.o(39551);
      return localai;
    }
    ai localai = (ai)super.getItem(paramInt);
    AppMethodBeat.o(39551);
    return localai;
  }
  
  public final int cRx()
  {
    int i = 0;
    AppMethodBeat.i(39549);
    if (this.IYx)
    {
      if (this.IYy.isHidden()) {}
      for (;;)
      {
        AppMethodBeat.o(39549);
        return i + 1;
        i = this.hkS.size();
      }
    }
    AppMethodBeat.o(39549);
    return 0;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(39547);
    if (this.iKs != null)
    {
      this.iKs.detach();
      this.iKs = null;
    }
    AppMethodBeat.o(39547);
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(39548);
    if (this.cZX == 2)
    {
      AppMethodBeat.o(39548);
      return 2;
    }
    if (acA(paramInt))
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
    boolean bool1 = GF(paramInt);
    boolean bool2 = acA(paramInt);
    Object localObject4;
    if ((this.IYx) && (bool1))
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
          if (((a)localObject1).IYF == null) {
            paramViewGroup = null;
          }
        }
      }
      if (paramViewGroup == null) {
        if (bool2)
        {
          paramViewGroup = View.inflate(this.context, 2131493599, null);
          paramView = new a();
          paramView.fwp = ((TextView)paramViewGroup.findViewById(2131298729));
          paramView.IYF = ((ProgressBar)paramViewGroup.findViewById(2131304438));
          paramViewGroup.setTag(paramView);
        }
      }
      for (;;)
      {
        if (!bool2)
        {
          if (this.iKt == null) {
            this.iKt = new b.b()
            {
              public final int aPz()
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
              
              public final String qN(int paramAnonymousInt)
              {
                AppMethodBeat.i(39539);
                if (paramAnonymousInt < 0)
                {
                  ac.e("MicroMsg.SearchResultAdapter", "pos is invalid");
                  AppMethodBeat.o(39539);
                  return null;
                }
                Object localObject = b.this;
                localObject = ((b)localObject).acy(b.e((b)localObject) + paramAnonymousInt + 1);
                if (localObject == null)
                {
                  AppMethodBeat.o(39539);
                  return null;
                }
                localObject = ((csq)localObject).EuE.FEm;
                AppMethodBeat.o(39539);
                return localObject;
              }
            };
          }
          if (this.iKs != null) {
            this.iKs.a(paramInt - getRealCount() - 1, this.iKt);
          }
          localObject1 = acy(paramInt);
          paramView.tNT.setVisibility(8);
          if (localObject1 == null)
          {
            AppMethodBeat.o(39556);
            return paramViewGroup;
            paramViewGroup = View.inflate(this.context, 2131493644, null);
            paramView = new a();
            paramView.tNT = ((TextView)paramViewGroup.findViewById(2131298724));
            paramView.fAk = ((MaskLayout)paramViewGroup.findViewById(2131298721));
            paramView.fwp = ((TextView)paramViewGroup.findViewById(2131298729));
            paramView.iCi = ((CheckBox)paramViewGroup.findViewById(2131298731));
            paramView.zDC = ((TextView)paramViewGroup.findViewById(2131298719));
            paramViewGroup.setTag(paramView);
            continue;
            paramView = (a)paramViewGroup.getTag();
          }
          else
          {
            paramView.zDC.setVisibility(8);
            a.b.c((ImageView)paramView.fAk.getContentView(), ((csq)localObject1).EuE.FEm);
            if (((csq)localObject1).Feq != 0) {
              if (ar.a.hny != null)
              {
                localObject4 = ar.a.hny.nS(((csq)localObject1).Feq);
                if (localObject4 != null)
                {
                  localObject4 = com.tencent.mm.al.n.Bh((String)localObject4);
                  paramView.fAk.a((Bitmap)localObject4, MaskLayout.a.HBk);
                  localObject1 = bs.nullAsNil(((csq)localObject1).Fbd.FEm);
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
          paramView.fwp.setText(k.b(this.context, (CharSequence)localObject1, paramView.fwp.getTextSize()));
          AppMethodBeat.o(39556);
          return paramViewGroup;
          paramView.fAk.setMaskDrawable(null);
          break;
          paramView.fAk.setMaskDrawable(null);
          break;
          paramView.fAk.setMaskDrawable(null);
        }
        catch (Exception localException1)
        {
          ac.printErrStackTrace("MicroMsg.SearchResultAdapter", localException1, "", new Object[0]);
          paramView.fwp.setText("");
          continue;
        }
        if (this.IYB) {
          paramView.IYF.setVisibility(0);
        }
        for (;;)
        {
          ac.d("MicroMsg.SearchResultAdapter", "refresh  " + this.IYz);
          if (((this.hkS != null) && (this.hkS.size() != 0)) || (this.IYz)) {
            break label621;
          }
          paramView.fwp.setText(this.context.getString(2131755213));
          paramView.fwp.setTextColor(this.context.getResources().getColor(2131100544));
          break;
          paramView.IYF.setVisibility(8);
        }
        label621:
        paramView.fwp.setText(this.context.getString(2131755214));
        paramView.fwp.setTextColor(a.m(this.context, 2131100638));
      }
    }
    if (this.cZX == 2)
    {
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2131495857, null);
        paramViewGroup = new a();
        paramViewGroup.fwp = ((TextView)paramView.findViewById(2131298729));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject2 = acz(paramInt);
        paramViewGroup.fwp.setTextColor(a.m(this.context, 2131100638));
        try
        {
          localObject2 = this.context.getString(2131764762, new Object[] { v.b((ai)localObject2, ((av)localObject2).field_username) });
          paramViewGroup.fwp.setText(k.b(this.context, (CharSequence)localObject2, paramViewGroup.fwp.getTextSize()));
          paramViewGroup.fwp.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          AppMethodBeat.o(39556);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            paramViewGroup.fwp.setText("");
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
        paramView = com.tencent.mm.ui.z.jD(this.context).inflate(2131493644, null);
        paramViewGroup = new a();
        paramViewGroup.tNT = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.fAk = ((MaskLayout)paramView.findViewById(2131298721));
        paramViewGroup.fwp = ((TextView)paramView.findViewById(2131298729));
        paramViewGroup.iCi = ((CheckBox)paramView.findViewById(2131298731));
        paramViewGroup.zDC = ((TextView)paramView.findViewById(2131298719));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject3 = acz(paramInt);
        if (paramViewGroup.tNT != null) {
          paramViewGroup.tNT.setVisibility(8);
        }
        localObject4 = paramViewGroup.fwp;
        Context localContext = this.context;
        if (!w.xr(((av)localObject3).field_username)) {
          paramInt = 2131100638;
        }
        for (;;)
        {
          ((TextView)localObject4).setTextColor(a.m(localContext, paramInt));
          a.b.c((ImageView)paramViewGroup.fAk.getContentView(), ((av)localObject3).field_username);
          paramViewGroup.zDC.setVisibility(8);
          if (((av)localObject3).field_verifyFlag != 0) {
            if (ar.a.hny != null)
            {
              localObject4 = ar.a.hny.nS(((av)localObject3).field_verifyFlag);
              if (localObject4 != null)
              {
                localObject4 = com.tencent.mm.al.n.Bh((String)localObject4);
                paramViewGroup.fAk.a((Bitmap)localObject4, MaskLayout.a.HBk);
              }
            }
          }
          try
          {
            label1091:
            localObject4 = k.b(this.context, v.wk(((av)localObject3).field_username), (int)paramViewGroup.fwp.getTextSize());
            if (w.wr(((av)localObject3).field_username))
            {
              localObject3 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(this.context, (CharSequence)localObject4);
              paramViewGroup.fwp.setText((CharSequence)localObject3);
            }
            for (;;)
            {
              AppMethodBeat.o(39556);
              return paramView;
              paramInt = 2131100639;
              break;
              paramViewGroup.fAk.setMaskDrawable(null);
              break label1091;
              paramViewGroup.fAk.setMaskDrawable(null);
              break label1091;
              paramViewGroup.fAk.setMaskDrawable(null);
              break label1091;
              paramViewGroup.fwp.setText((CharSequence)localObject4);
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              paramViewGroup.fwp.setText("");
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
  
  public final void ic(final List<String> paramList)
  {
    AppMethodBeat.i(39545);
    aK(new Runnable()
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
    if ((acA(paramInt)) && ((this.hkS == null) || (this.hkS.size() == 0)) && (!this.IYz))
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
    az.agi().b(106, this);
    AppMethodBeat.o(39561);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(39560);
    az.agi().a(106, this);
    AppMethodBeat.o(39560);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(39563);
    ac.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() != 106)
    {
      ac.e("MicroMsg.SearchResultAdapter", "error type");
      AppMethodBeat.o(39563);
      return;
    }
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    this.IYB = false;
    if (y.a.a(this.context, paramInt1, paramInt2, paramString, 7))
    {
      this.IYz = false;
      AppMethodBeat.o(39563);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      aK(new Runnable()
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
      aK(new Runnable()
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
    aK(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39534);
        Object localObject1 = ((com.tencent.mm.plugin.messenger.a.g)paramn).dcj();
        ac.d("MicroMsg.SearchResultAdapter", "count " + ((css)localObject1).ENQ);
        if (((css)localObject1).ENQ > 0)
        {
          localObject1 = ((css)localObject1).ENR.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (csq)((Iterator)localObject1).next();
            if (w.nN(((csq)localObject2).Feq))
            {
              if (b.f(b.this) == null) {
                b.a(b.this, new LinkedList());
              }
              b.f(b.this).add(localObject2);
            }
          }
        }
        Object localObject2 = com.tencent.mm.platformtools.z.a(((css)localObject1).EuE);
        ac.d("MicroMsg.SearchResultAdapter", "user ".concat(String.valueOf(localObject2)));
        if (bs.nullAsNil((String)localObject2).length() > 0)
        {
          csq localcsq = new csq();
          localcsq.EuE = ((css)localObject1).EuE;
          localcsq.Feq = ((css)localObject1).Feq;
          localcsq.iJW = ((css)localObject1).iJW;
          localcsq.Fbd = ((css)localObject1).Fbd;
          localcsq.iJY = ((css)localObject1).iJY;
          localcsq.iKc = ((css)localObject1).iKc;
          localcsq.iJV = ((css)localObject1).iJV;
          localcsq.iJU = ((css)localObject1).iJU;
          localcsq.iJT = ((css)localObject1).iJT;
          localcsq.Fer = ((css)localObject1).Fer;
          localcsq.Feu = ((css)localObject1).Feu;
          localcsq.Fes = ((css)localObject1).Fes;
          localcsq.Fet = ((css)localObject1).Fet;
          localcsq.Few = ((css)localObject1).Few;
          p.aBh().h((String)localObject2, com.tencent.mm.platformtools.z.a(((css)localObject1).DPX));
          if (b.f(b.this) == null) {
            b.a(b.this, new LinkedList());
          }
          b.f(b.this).clear();
          if (w.nN(localcsq.Feq)) {
            b.f(b.this).add(localcsq);
          }
          ac.d("MicroMsg.SearchResultAdapter", "count " + b.f(b.this).size());
        }
        b.b(b.this, false);
        AppMethodBeat.o(39534);
      }
    });
    AppMethodBeat.o(39563);
  }
  
  public final void rp(final boolean paramBoolean)
  {
    AppMethodBeat.i(39558);
    aK(new Runnable()
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
            if (b.this.aRD((String)localObject3)) {
              ((List)localObject1).add(localObject3);
            }
            i += 1;
          }
          if (((List)localObject1).size() > 0)
          {
            localObject2 = b.this;
            az.ayM();
            b.a((b)localObject2, com.tencent.mm.model.c.awB().a((String[])((List)localObject1).toArray(new String[((List)localObject1).size()]), b.h(b.this), b.a(b.this)));
            AppMethodBeat.o(39541);
            return;
          }
          localObject1 = b.this;
          az.ayM();
          b.b((b)localObject1, com.tencent.mm.model.c.awB().faE());
          AppMethodBeat.o(39541);
          return;
        }
        if (b.i(b.this) != null)
        {
          if (!b.h(b.this).equals("@all.chatroom.contact"))
          {
            localObject1 = az.ayM().hlZ.a(b.i(b.this), b.h(b.this), b.a(b.this), true);
            b.c(b.this, (Cursor)localObject1);
            AppMethodBeat.o(39541);
            return;
          }
          if (paramBoolean)
          {
            localObject1 = az.ayM().hlZ.a(b.i(b.this), "@micromsg.with.all.biz.qq.com.openim", b.a(b.this), false);
            localObject2 = new ArrayList();
            localObject3 = new ArrayList();
          }
          for (;;)
          {
            if (!((Cursor)localObject1).moveToNext()) {
              break label393;
            }
            String str = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("username"));
            if (!w.wo(str))
            {
              ((ArrayList)localObject2).add(str);
              continue;
              localObject1 = az.ayM().hlZ.a(b.i(b.this), "@micromsg.with.all.biz.qq.com", b.a(b.this), false);
              break;
            }
            ((ArrayList)localObject3).add(str);
          }
          label393:
          if (!((Cursor)localObject1).isClosed()) {
            ((Cursor)localObject1).close();
          }
          if ((((ArrayList)localObject2).size() != 0) || (((ArrayList)localObject3).size() != 0)) {}
          for (localObject1 = az.ayM().hlZ.a(b.i(b.this), (ArrayList)localObject2, null, (ArrayList)localObject3, b.a(b.this));; localObject1 = com.tencent.mm.model.c.awB().faE())
          {
            b.d(b.this, (Cursor)localObject1);
            AppMethodBeat.o(39541);
            return;
            az.ayM();
          }
        }
        Object localObject1 = b.this;
        az.ayM();
        b.e((b)localObject1, com.tencent.mm.model.c.awB().faE());
        AppMethodBeat.o(39541);
      }
    });
    AppMethodBeat.o(39558);
  }
  
  public final void xT(boolean paramBoolean)
  {
    AppMethodBeat.i(39546);
    this.IYA = paramBoolean;
    if (paramBoolean) {
      this.IYy.aao();
    }
    AppMethodBeat.o(39546);
  }
  
  public final void xU(final boolean paramBoolean)
  {
    AppMethodBeat.i(39552);
    aK(new Runnable()
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
    public ProgressBar IYF;
    public MaskLayout fAk;
    public TextView fwp;
    public CheckBox iCi;
    public TextView tNT;
    public TextView zDC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b
 * JD-Core Version:    0.7.0.1
 */