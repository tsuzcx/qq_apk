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
import com.tencent.mm.cd.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.x.a;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class b
  extends com.tencent.mm.ui.q<af>
  implements com.tencent.mm.al.g
{
  public String GRX;
  public String[] GgH;
  private boolean Hya;
  private af Hyb;
  private boolean Hyc;
  public boolean Hyd;
  private boolean Hye;
  private Context context;
  private int dcz;
  private ProgressDialog fpP;
  private List<String> fvP;
  private LinkedList<cnj> gKs;
  public com.tencent.mm.ui.applet.b ikl;
  private b.b ikm;
  public String vpQ;
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext, new af());
    AppMethodBeat.i(39544);
    this.Hya = false;
    this.Hyb = null;
    this.gKs = new LinkedList();
    this.fvP = null;
    this.Hyc = true;
    this.fpP = null;
    this.Hyd = false;
    this.dcz = 1;
    this.ikl = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
    {
      public final Bitmap Cl(String paramAnonymousString)
      {
        AppMethodBeat.i(39532);
        paramAnonymousString = com.tencent.mm.ak.c.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(39532);
        return paramAnonymousString;
      }
    });
    this.ikm = null;
    this.Hye = false;
    this.context = paramContext;
    this.dcz = paramInt;
    this.Hyb = new af();
    this.Hyb.setUsername("_find_more_public_contact_");
    this.Hyb.Zt();
    this.GRX = "@micromsg.with.all.biz.qq.com";
    AppMethodBeat.o(39544);
  }
  
  public static String aMa(String paramString)
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
  
  public final void Wd()
  {
    AppMethodBeat.i(39557);
    qr(false);
    AppMethodBeat.o(39557);
  }
  
  public final void We()
  {
    AppMethodBeat.i(39559);
    cHX();
    qr(false);
    AppMethodBeat.o(39559);
  }
  
  public final void aH(final Runnable paramRunnable)
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
  
  public final void aLZ(final String paramString)
  {
    AppMethodBeat.i(39553);
    aH(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39538);
        if (b.b(b.this).isHidden())
        {
          b.b(b.this).Zu();
          if (b.c(b.this))
          {
            com.tencent.mm.plugin.messenger.a.g localg = new com.tencent.mm.plugin.messenger.a.g(paramString, 3);
            az.aeS().a(localg, 0);
            b.d(b.this);
            AppMethodBeat.o(39538);
          }
        }
        else
        {
          b.b(b.this).Zt();
        }
        AppMethodBeat.o(39538);
      }
    });
    AppMethodBeat.o(39553);
  }
  
  public final boolean aMb(String paramString)
  {
    AppMethodBeat.i(39565);
    if ((this.fvP != null) && (paramString != null))
    {
      Iterator localIterator = this.fvP.iterator();
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
  
  public final cnj aal(int paramInt)
  {
    AppMethodBeat.i(39550);
    try
    {
      ad.d("MicroMsg.SearchResultAdapter", "position " + paramInt + " size " + this.gKs.size() + "  " + (paramInt - getRealCount()));
      cnj localcnj = (cnj)this.gKs.get(paramInt - getRealCount() - 1);
      AppMethodBeat.o(39550);
      return localcnj;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SearchResultAdapter", localException, "", new Object[0]);
      AppMethodBeat.o(39550);
    }
    return null;
  }
  
  public final af aam(int paramInt)
  {
    AppMethodBeat.i(39551);
    if (EJ(paramInt))
    {
      localaf = (af)cEp();
      AppMethodBeat.o(39551);
      return localaf;
    }
    af localaf = (af)super.getItem(paramInt);
    AppMethodBeat.o(39551);
    return localaf;
  }
  
  public final boolean aan(int paramInt)
  {
    AppMethodBeat.i(39554);
    if (this.Hya)
    {
      int i = getRealCount();
      if ((paramInt == i) && (paramInt < i + cEn()))
      {
        AppMethodBeat.o(39554);
        return true;
      }
    }
    AppMethodBeat.o(39554);
    return false;
  }
  
  public final int cEn()
  {
    int i = 0;
    AppMethodBeat.i(39549);
    if (this.Hya)
    {
      if (this.Hyb.isHidden()) {}
      for (;;)
      {
        AppMethodBeat.o(39549);
        return i + 1;
        i = this.gKs.size();
      }
    }
    AppMethodBeat.o(39549);
    return 0;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(39547);
    if (this.ikl != null)
    {
      this.ikl.detach();
      this.ikl = null;
    }
    AppMethodBeat.o(39547);
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(39548);
    if (this.dcz == 2)
    {
      AppMethodBeat.o(39548);
      return 2;
    }
    if (aan(paramInt))
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
    boolean bool1 = EJ(paramInt);
    boolean bool2 = aan(paramInt);
    Object localObject4;
    if ((this.Hya) && (bool1))
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
          if (((a)localObject1).Hyi == null) {
            paramViewGroup = null;
          }
        }
      }
      if (paramViewGroup == null) {
        if (bool2)
        {
          paramViewGroup = View.inflate(this.context, 2131493599, null);
          paramView = new a();
          paramView.fsI = ((TextView)paramViewGroup.findViewById(2131298729));
          paramView.Hyi = ((ProgressBar)paramViewGroup.findViewById(2131304438));
          paramViewGroup.setTag(paramView);
        }
      }
      for (;;)
      {
        if (!bool2)
        {
          if (this.ikm == null) {
            this.ikm = new b.b()
            {
              public final int aII()
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
              
              public final String qa(int paramAnonymousInt)
              {
                AppMethodBeat.i(39539);
                if (paramAnonymousInt < 0)
                {
                  ad.e("MicroMsg.SearchResultAdapter", "pos is invalid");
                  AppMethodBeat.o(39539);
                  return null;
                }
                Object localObject = b.this;
                localObject = ((b)localObject).aal(b.e((b)localObject) + paramAnonymousInt + 1);
                if (localObject == null)
                {
                  AppMethodBeat.o(39539);
                  return null;
                }
                localObject = ((cnj)localObject).Dby.Ehn;
                AppMethodBeat.o(39539);
                return localObject;
              }
            };
          }
          if (this.ikl != null) {
            this.ikl.a(paramInt - getRealCount() - 1, this.ikm);
          }
          localObject1 = aal(paramInt);
          paramView.sGm.setVisibility(8);
          if (localObject1 == null)
          {
            AppMethodBeat.o(39556);
            return paramViewGroup;
            paramViewGroup = View.inflate(this.context, 2131493644, null);
            paramView = new a();
            paramView.sGm = ((TextView)paramViewGroup.findViewById(2131298724));
            paramView.fwD = ((MaskLayout)paramViewGroup.findViewById(2131298721));
            paramView.fsI = ((TextView)paramViewGroup.findViewById(2131298729));
            paramView.icb = ((CheckBox)paramViewGroup.findViewById(2131298731));
            paramView.yqe = ((TextView)paramViewGroup.findViewById(2131298719));
            paramViewGroup.setTag(paramView);
            continue;
            paramView = (a)paramViewGroup.getTag();
          }
          else
          {
            paramView.yqe.setVisibility(8);
            a.b.c((ImageView)paramView.fwD.getContentView(), ((cnj)localObject1).Dby.Ehn);
            if (((cnj)localObject1).DIV != 0) {
              if (ar.a.gMY != null)
              {
                localObject4 = ar.a.gMY.ne(((cnj)localObject1).DIV);
                if (localObject4 != null)
                {
                  localObject4 = com.tencent.mm.am.n.xb((String)localObject4);
                  paramView.fwD.a((Bitmap)localObject4, MaskLayout.a.Gbv);
                  localObject1 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(((cnj)localObject1).DFJ.Ehn);
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
          paramView.fsI.setText(k.b(this.context, (CharSequence)localObject1, paramView.fsI.getTextSize()));
          AppMethodBeat.o(39556);
          return paramViewGroup;
          paramView.fwD.setMaskDrawable(null);
          break;
          paramView.fwD.setMaskDrawable(null);
          break;
          paramView.fwD.setMaskDrawable(null);
        }
        catch (Exception localException1)
        {
          ad.printErrStackTrace("MicroMsg.SearchResultAdapter", localException1, "", new Object[0]);
          paramView.fsI.setText("");
          continue;
        }
        if (this.Hye) {
          paramView.Hyi.setVisibility(0);
        }
        for (;;)
        {
          ad.d("MicroMsg.SearchResultAdapter", "refresh  " + this.Hyc);
          if (((this.gKs != null) && (this.gKs.size() != 0)) || (this.Hyc)) {
            break label621;
          }
          paramView.fsI.setText(this.context.getString(2131755213));
          paramView.fsI.setTextColor(this.context.getResources().getColor(2131100544));
          break;
          paramView.Hyi.setVisibility(8);
        }
        label621:
        paramView.fsI.setText(this.context.getString(2131755214));
        paramView.fsI.setTextColor(a.m(this.context, 2131100638));
      }
    }
    if (this.dcz == 2)
    {
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2131495857, null);
        paramViewGroup = new a();
        paramViewGroup.fsI = ((TextView)paramView.findViewById(2131298729));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject2 = aam(paramInt);
        paramViewGroup.fsI.setTextColor(a.m(this.context, 2131100638));
        try
        {
          localObject2 = this.context.getString(2131764762, new Object[] { v.b((af)localObject2, ((au)localObject2).field_username) });
          paramViewGroup.fsI.setText(k.b(this.context, (CharSequence)localObject2, paramViewGroup.fsI.getTextSize()));
          paramViewGroup.fsI.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          AppMethodBeat.o(39556);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            paramViewGroup.fsI.setText("");
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
        paramView = y.js(this.context).inflate(2131493644, null);
        paramViewGroup = new a();
        paramViewGroup.sGm = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.fwD = ((MaskLayout)paramView.findViewById(2131298721));
        paramViewGroup.fsI = ((TextView)paramView.findViewById(2131298729));
        paramViewGroup.icb = ((CheckBox)paramView.findViewById(2131298731));
        paramViewGroup.yqe = ((TextView)paramView.findViewById(2131298719));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject3 = aam(paramInt);
        if (paramViewGroup.sGm != null) {
          paramViewGroup.sGm.setVisibility(8);
        }
        localObject4 = paramViewGroup.fsI;
        Context localContext = this.context;
        if (!w.to(((au)localObject3).field_username)) {
          paramInt = 2131100638;
        }
        for (;;)
        {
          ((TextView)localObject4).setTextColor(a.m(localContext, paramInt));
          a.b.c((ImageView)paramViewGroup.fwD.getContentView(), ((au)localObject3).field_username);
          paramViewGroup.yqe.setVisibility(8);
          if (((au)localObject3).field_verifyFlag != 0) {
            if (ar.a.gMY != null)
            {
              localObject4 = ar.a.gMY.ne(((au)localObject3).field_verifyFlag);
              if (localObject4 != null)
              {
                localObject4 = com.tencent.mm.am.n.xb((String)localObject4);
                paramViewGroup.fwD.a((Bitmap)localObject4, MaskLayout.a.Gbv);
              }
            }
          }
          try
          {
            label1091:
            localObject4 = k.b(this.context, v.sh(((au)localObject3).field_username), (int)paramViewGroup.fsI.getTextSize());
            if (w.so(((au)localObject3).field_username))
            {
              localObject3 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(this.context, (CharSequence)localObject4);
              paramViewGroup.fsI.setText((CharSequence)localObject3);
            }
            for (;;)
            {
              AppMethodBeat.o(39556);
              return paramView;
              paramInt = 2131100639;
              break;
              paramViewGroup.fwD.setMaskDrawable(null);
              break label1091;
              paramViewGroup.fwD.setMaskDrawable(null);
              break label1091;
              paramViewGroup.fwD.setMaskDrawable(null);
              break label1091;
              paramViewGroup.fsI.setText((CharSequence)localObject4);
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              paramViewGroup.fsI.setText("");
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
  
  public final void hP(final List<String> paramList)
  {
    AppMethodBeat.i(39545);
    aH(new Runnable()
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
    if ((aan(paramInt)) && ((this.gKs == null) || (this.gKs.size() == 0)) && (!this.Hyc))
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
    az.aeS().b(106, this);
    AppMethodBeat.o(39561);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(39560);
    az.aeS().a(106, this);
    AppMethodBeat.o(39560);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(39563);
    ad.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() != 106)
    {
      ad.e("MicroMsg.SearchResultAdapter", "error type");
      AppMethodBeat.o(39563);
      return;
    }
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    this.Hye = false;
    if (x.a.a(this.context, paramInt1, paramInt2, paramString, 7))
    {
      this.Hyc = false;
      AppMethodBeat.o(39563);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      aH(new Runnable()
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
      aH(new Runnable()
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
    aH(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39534);
        Object localObject1 = ((com.tencent.mm.plugin.messenger.a.g)paramn).cOA();
        ad.d("MicroMsg.SearchResultAdapter", "count " + ((cnl)localObject1).DsM);
        if (((cnl)localObject1).DsM > 0)
        {
          localObject1 = ((cnl)localObject1).DsN.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (cnj)((Iterator)localObject1).next();
            if (w.mZ(((cnj)localObject2).DIV))
            {
              if (b.f(b.this) == null) {
                b.a(b.this, new LinkedList());
              }
              b.f(b.this).add(localObject2);
            }
          }
        }
        Object localObject2 = z.a(((cnl)localObject1).Dby);
        ad.d("MicroMsg.SearchResultAdapter", "user ".concat(String.valueOf(localObject2)));
        if (com.tencent.mm.sdk.platformtools.bt.nullAsNil((String)localObject2).length() > 0)
        {
          cnj localcnj = new cnj();
          localcnj.Dby = ((cnl)localObject1).Dby;
          localcnj.DIV = ((cnl)localObject1).DIV;
          localcnj.ijP = ((cnl)localObject1).ijP;
          localcnj.DFJ = ((cnl)localObject1).DFJ;
          localcnj.ijR = ((cnl)localObject1).ijR;
          localcnj.ijV = ((cnl)localObject1).ijV;
          localcnj.ijO = ((cnl)localObject1).ijO;
          localcnj.ijN = ((cnl)localObject1).ijN;
          localcnj.ijM = ((cnl)localObject1).ijM;
          localcnj.DIW = ((cnl)localObject1).DIW;
          localcnj.DIZ = ((cnl)localObject1).DIZ;
          localcnj.DIX = ((cnl)localObject1).DIX;
          localcnj.DIY = ((cnl)localObject1).DIY;
          localcnj.DJb = ((cnl)localObject1).DJb;
          p.auq().h((String)localObject2, z.a(((cnl)localObject1).CxB));
          if (b.f(b.this) == null) {
            b.a(b.this, new LinkedList());
          }
          b.f(b.this).clear();
          if (w.mZ(localcnj.DIV)) {
            b.f(b.this).add(localcnj);
          }
          ad.d("MicroMsg.SearchResultAdapter", "count " + b.f(b.this).size());
        }
        b.b(b.this, false);
        AppMethodBeat.o(39534);
      }
    });
    AppMethodBeat.o(39563);
  }
  
  public final void qr(final boolean paramBoolean)
  {
    AppMethodBeat.i(39558);
    aH(new Runnable()
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
            if (b.this.aMb((String)localObject3)) {
              ((List)localObject1).add(localObject3);
            }
            i += 1;
          }
          if (((List)localObject1).size() > 0)
          {
            localObject2 = b.this;
            az.arV();
            b.a((b)localObject2, com.tencent.mm.model.c.apM().a((String[])((List)localObject1).toArray(new String[((List)localObject1).size()]), b.h(b.this), b.a(b.this)));
            AppMethodBeat.o(39541);
            return;
          }
          localObject1 = b.this;
          az.arV();
          b.b((b)localObject1, com.tencent.mm.model.c.apM().eLc());
          AppMethodBeat.o(39541);
          return;
        }
        if (b.i(b.this) != null)
        {
          if (!b.h(b.this).equals("@all.chatroom.contact"))
          {
            localObject1 = az.arV().gLz.a(b.i(b.this), b.h(b.this), b.a(b.this), true);
            b.c(b.this, (Cursor)localObject1);
            AppMethodBeat.o(39541);
            return;
          }
          if (paramBoolean)
          {
            localObject1 = az.arV().gLz.a(b.i(b.this), "@micromsg.with.all.biz.qq.com.openim", b.a(b.this), false);
            localObject2 = new ArrayList();
            localObject3 = new ArrayList();
          }
          for (;;)
          {
            if (!((Cursor)localObject1).moveToNext()) {
              break label393;
            }
            String str = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("username"));
            if (!w.sl(str))
            {
              ((ArrayList)localObject2).add(str);
              continue;
              localObject1 = az.arV().gLz.a(b.i(b.this), "@micromsg.with.all.biz.qq.com", b.a(b.this), false);
              break;
            }
            ((ArrayList)localObject3).add(str);
          }
          label393:
          if (!((Cursor)localObject1).isClosed()) {
            ((Cursor)localObject1).close();
          }
          if ((((ArrayList)localObject2).size() != 0) || (((ArrayList)localObject3).size() != 0)) {}
          for (localObject1 = az.arV().gLz.a(b.i(b.this), (ArrayList)localObject2, null, (ArrayList)localObject3, b.a(b.this));; localObject1 = com.tencent.mm.model.c.apM().eLc())
          {
            b.d(b.this, (Cursor)localObject1);
            AppMethodBeat.o(39541);
            return;
            az.arV();
          }
        }
        Object localObject1 = b.this;
        az.arV();
        b.e((b)localObject1, com.tencent.mm.model.c.apM().eLc());
        AppMethodBeat.o(39541);
      }
    });
    AppMethodBeat.o(39558);
  }
  
  public final void wM(boolean paramBoolean)
  {
    AppMethodBeat.i(39546);
    this.Hyd = paramBoolean;
    if (paramBoolean) {
      this.Hyb.Zt();
    }
    AppMethodBeat.o(39546);
  }
  
  public final void wN(final boolean paramBoolean)
  {
    AppMethodBeat.i(39552);
    aH(new Runnable()
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
    public ProgressBar Hyi;
    public TextView fsI;
    public MaskLayout fwD;
    public CheckBox icb;
    public TextView sGm;
    public TextView yqe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b
 * JD-Core Version:    0.7.0.1
 */