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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.o;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.ca;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.z.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class b
  extends s<as>
  implements i
{
  public String BZP;
  public String PSf;
  public String[] Paj;
  private boolean QBi;
  private as QBj;
  private boolean QBk;
  public boolean QBl;
  private boolean QBm;
  private Context context;
  private int dDG;
  private ProgressDialog gtM;
  private List<String> gzY;
  private LinkedList<drr> iAd;
  public com.tencent.mm.ui.applet.b kex;
  private b.b kez;
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext, new as());
    AppMethodBeat.i(39544);
    this.QBi = false;
    this.QBj = null;
    this.iAd = new LinkedList();
    this.gzY = null;
    this.QBk = true;
    this.gtM = null;
    this.QBl = false;
    this.dDG = 1;
    this.kex = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
    {
      public final Bitmap Ta(String paramAnonymousString)
      {
        AppMethodBeat.i(39532);
        paramAnonymousString = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(39532);
        return paramAnonymousString;
      }
    });
    this.kez = null;
    this.QBm = false;
    this.context = paramContext;
    this.dDG = paramInt;
    this.QBj = new as();
    this.QBj.setUsername("_find_more_public_contact_");
    this.QBj.aqZ();
    this.PSf = "@micromsg.with.all.biz.qq.com";
    AppMethodBeat.o(39544);
  }
  
  public static String boi(String paramString)
  {
    AppMethodBeat.i(39562);
    String str = paramString.trim();
    paramString = str;
    if (str.startsWith("@")) {
      paramString = str.substring(1) + "%@micromsg.with.all.biz.qq.com";
    }
    Log.d("MicroMsg.SearchResultAdapter", "translateQueryText [" + paramString + "]");
    AppMethodBeat.o(39562);
    return paramString;
  }
  
  public final void CQ(boolean paramBoolean)
  {
    AppMethodBeat.i(39546);
    this.QBl = paramBoolean;
    if (paramBoolean) {
      this.QBj.aqZ();
    }
    AppMethodBeat.o(39546);
  }
  
  public final void CR(final boolean paramBoolean)
  {
    AppMethodBeat.i(39552);
    aO(new Runnable()
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
  
  public final as Ln(int paramInt)
  {
    AppMethodBeat.i(39551);
    if (Ox(paramInt))
    {
      localas = (as)dWw();
      AppMethodBeat.o(39551);
      return localas;
    }
    as localas = (as)super.getItem(paramInt);
    AppMethodBeat.o(39551);
    return localas;
  }
  
  public final void aO(final Runnable paramRunnable)
  {
    AppMethodBeat.i(39564);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      notifyDataSetChanged();
      AppMethodBeat.o(39564);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
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
  
  public final void anp()
  {
    AppMethodBeat.i(39557);
    vw(false);
    AppMethodBeat.o(39557);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(39559);
    ebf();
    vw(false);
    AppMethodBeat.o(39559);
  }
  
  public final drr aos(int paramInt)
  {
    AppMethodBeat.i(39550);
    try
    {
      Log.d("MicroMsg.SearchResultAdapter", "position " + paramInt + " size " + this.iAd.size() + "  " + (paramInt - getRealCount()));
      drr localdrr = (drr)this.iAd.get(paramInt - getRealCount() - 1);
      AppMethodBeat.o(39550);
      return localdrr;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SearchResultAdapter", localException, "", new Object[0]);
      AppMethodBeat.o(39550);
    }
    return null;
  }
  
  public final boolean aot(int paramInt)
  {
    AppMethodBeat.i(39554);
    if (this.QBi)
    {
      int i = getRealCount();
      if ((paramInt == i) && (paramInt < i + dWu()))
      {
        AppMethodBeat.o(39554);
        return true;
      }
    }
    AppMethodBeat.o(39554);
    return false;
  }
  
  public final void boh(final String paramString)
  {
    AppMethodBeat.i(39553);
    aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39538);
        if (b.b(b.this).isHidden())
        {
          b.b(b.this).ara();
          if (b.c(b.this))
          {
            f localf = new f(paramString, 3);
            bg.azz().a(localf, 0);
            b.d(b.this);
            AppMethodBeat.o(39538);
          }
        }
        else
        {
          b.b(b.this).aqZ();
        }
        AppMethodBeat.o(39538);
      }
    });
    AppMethodBeat.o(39553);
  }
  
  public final boolean boj(String paramString)
  {
    AppMethodBeat.i(39565);
    if ((this.gzY != null) && (paramString != null))
    {
      Iterator localIterator = this.gzY.iterator();
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
  
  public final int dWu()
  {
    int i = 0;
    AppMethodBeat.i(39549);
    if (this.QBi)
    {
      if (this.QBj.isHidden()) {}
      for (;;)
      {
        AppMethodBeat.o(39549);
        return i + 1;
        i = this.iAd.size();
      }
    }
    AppMethodBeat.o(39549);
    return 0;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(39547);
    if (this.kex != null)
    {
      this.kex.detach();
      this.kex = null;
    }
    AppMethodBeat.o(39547);
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(39548);
    if (this.dDG == 2)
    {
      AppMethodBeat.o(39548);
      return 2;
    }
    if (aot(paramInt))
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
    boolean bool1 = Ox(paramInt);
    boolean bool2 = aot(paramInt);
    Object localObject4;
    if ((this.QBi) && (bool1))
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
          if (((a)localObject1).QBq == null) {
            paramViewGroup = null;
          }
        }
      }
      if (paramViewGroup == null) {
        if (bool2)
        {
          paramViewGroup = View.inflate(this.context, 2131493716, null);
          paramView = new a();
          paramView.gwR = ((TextView)paramViewGroup.findViewById(2131299167));
          paramView.QBq = ((ProgressBar)paramViewGroup.findViewById(2131307414));
          paramViewGroup.setTag(paramView);
        }
      }
      for (;;)
      {
        if (!bool2)
        {
          if (this.kez == null) {
            this.kez = new b.b()
            {
              public final int bnW()
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
              
              public final String vg(int paramAnonymousInt)
              {
                AppMethodBeat.i(39539);
                if (paramAnonymousInt < 0)
                {
                  Log.e("MicroMsg.SearchResultAdapter", "pos is invalid");
                  AppMethodBeat.o(39539);
                  return null;
                }
                Object localObject = b.this;
                localObject = ((b)localObject).aos(b.e((b)localObject) + paramAnonymousInt + 1);
                if (localObject == null)
                {
                  AppMethodBeat.o(39539);
                  return null;
                }
                localObject = ((drr)localObject).Lqk.MTo;
                AppMethodBeat.o(39539);
                return localObject;
              }
            };
          }
          if (this.kex != null) {
            this.kex.a(paramInt - getRealCount() - 1, this.kez);
          }
          localObject1 = aos(paramInt);
          paramView.yuS.setVisibility(8);
          if (localObject1 == null)
          {
            AppMethodBeat.o(39556);
            return paramViewGroup;
            paramViewGroup = View.inflate(this.context, 2131493774, null);
            paramView = new a();
            paramView.yuS = ((TextView)paramViewGroup.findViewById(2131299162));
            paramView.gAN = ((MaskLayout)paramViewGroup.findViewById(2131299159));
            paramView.gwR = ((TextView)paramViewGroup.findViewById(2131299167));
            paramView.jVQ = ((CheckBox)paramViewGroup.findViewById(2131299169));
            paramView.Fxp = ((TextView)paramViewGroup.findViewById(2131299157));
            paramViewGroup.setTag(paramView);
            continue;
            paramView = (a)paramViewGroup.getTag();
          }
          else
          {
            paramView.Fxp.setVisibility(8);
            a.b.c((ImageView)paramView.gAN.getContentView(), ((drr)localObject1).Lqk.MTo);
            if (((drr)localObject1).MmK != 0) {
              if (ay.a.iDs != null)
              {
                localObject4 = ay.a.iDs.rW(((drr)localObject1).MmK);
                if (localObject4 != null)
                {
                  localObject4 = o.Nw((String)localObject4);
                  paramView.gAN.a((Bitmap)localObject4, MaskLayout.a.OUJ);
                  localObject1 = Util.nullAsNil(((drr)localObject1).Mjj.MTo);
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
          paramView.gwR.setText(l.b(this.context, (CharSequence)localObject1, paramView.gwR.getTextSize()));
          AppMethodBeat.o(39556);
          return paramViewGroup;
          paramView.gAN.setMaskDrawable(null);
          break;
          paramView.gAN.setMaskDrawable(null);
          break;
          paramView.gAN.setMaskDrawable(null);
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.SearchResultAdapter", localException1, "", new Object[0]);
          paramView.gwR.setText("");
          continue;
        }
        if (this.QBm) {
          paramView.QBq.setVisibility(0);
        }
        for (;;)
        {
          Log.d("MicroMsg.SearchResultAdapter", "refresh  " + this.QBk);
          if (((this.iAd != null) && (this.iAd.size() != 0)) || (this.QBk)) {
            break label621;
          }
          paramView.gwR.setText(this.context.getString(2131755246));
          paramView.gwR.setTextColor(this.context.getResources().getColor(2131100682));
          break;
          paramView.QBq.setVisibility(8);
        }
        label621:
        paramView.gwR.setText(this.context.getString(2131755247));
        paramView.gwR.setTextColor(com.tencent.mm.cb.a.m(this.context, 2131100808));
      }
    }
    if (this.dDG == 2)
    {
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2131496837, null);
        paramViewGroup = new a();
        paramViewGroup.gwR = ((TextView)paramView.findViewById(2131299167));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject2 = Ln(paramInt);
        paramViewGroup.gwR.setTextColor(com.tencent.mm.cb.a.m(this.context, 2131100808));
        try
        {
          localObject2 = this.context.getString(2131767199, new Object[] { com.tencent.mm.model.aa.b((as)localObject2, ((ax)localObject2).field_username) });
          paramViewGroup.gwR.setText(l.b(this.context, (CharSequence)localObject2, paramViewGroup.gwR.getTextSize()));
          paramViewGroup.gwR.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          AppMethodBeat.o(39556);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            paramViewGroup.gwR.setText("");
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
        paramView = com.tencent.mm.ui.aa.jQ(this.context).inflate(2131493774, null);
        paramViewGroup = new a();
        paramViewGroup.yuS = ((TextView)paramView.findViewById(2131299162));
        paramViewGroup.gAN = ((MaskLayout)paramView.findViewById(2131299159));
        paramViewGroup.gwR = ((TextView)paramView.findViewById(2131299167));
        paramViewGroup.jVQ = ((CheckBox)paramView.findViewById(2131299169));
        paramViewGroup.Fxp = ((TextView)paramView.findViewById(2131299157));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject3 = Ln(paramInt);
        if (paramViewGroup.yuS != null) {
          paramViewGroup.yuS.setVisibility(8);
        }
        localObject4 = paramViewGroup.gwR;
        Context localContext = this.context;
        if (!ab.JE(((ax)localObject3).field_username)) {
          paramInt = 2131100808;
        }
        for (;;)
        {
          ((TextView)localObject4).setTextColor(com.tencent.mm.cb.a.m(localContext, paramInt));
          a.b.c((ImageView)paramViewGroup.gAN.getContentView(), ((ax)localObject3).field_username);
          paramViewGroup.Fxp.setVisibility(8);
          if (((ax)localObject3).field_verifyFlag != 0) {
            if (ay.a.iDs != null)
            {
              localObject4 = ay.a.iDs.rW(((ax)localObject3).field_verifyFlag);
              if (localObject4 != null)
              {
                localObject4 = o.Nw((String)localObject4);
                paramViewGroup.gAN.a((Bitmap)localObject4, MaskLayout.a.OUJ);
              }
            }
          }
          try
          {
            label1091:
            localObject4 = l.e(this.context, com.tencent.mm.model.aa.getDisplayName(((ax)localObject3).field_username), (int)paramViewGroup.gwR.getTextSize());
            if (ab.Iz(((ax)localObject3).field_username))
            {
              localObject3 = ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).a(this.context, (CharSequence)localObject4);
              paramViewGroup.gwR.setText((CharSequence)localObject3);
            }
            for (;;)
            {
              AppMethodBeat.o(39556);
              return paramView;
              paramInt = 2131100809;
              break;
              paramViewGroup.gAN.setMaskDrawable(null);
              break label1091;
              paramViewGroup.gAN.setMaskDrawable(null);
              break label1091;
              paramViewGroup.gAN.setMaskDrawable(null);
              break label1091;
              paramViewGroup.gwR.setText((CharSequence)localObject4);
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              paramViewGroup.gwR.setText("");
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
    if ((aot(paramInt)) && ((this.iAd == null) || (this.iAd.size() == 0)) && (!this.QBk))
    {
      AppMethodBeat.o(39555);
      return false;
    }
    AppMethodBeat.o(39555);
    return true;
  }
  
  public final void jB(final List<String> paramList)
  {
    AppMethodBeat.i(39545);
    aO(new Runnable()
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
    bg.azz().b(106, this);
    AppMethodBeat.o(39561);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(39560);
    bg.azz().a(106, this);
    AppMethodBeat.o(39560);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(39563);
    Log.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramq.getType() != 106)
    {
      Log.e("MicroMsg.SearchResultAdapter", "error type");
      AppMethodBeat.o(39563);
      return;
    }
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    this.QBm = false;
    if (z.a.a(this.context, paramInt1, paramInt2, paramString, 7))
    {
      this.QBk = false;
      AppMethodBeat.o(39563);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      aO(new Runnable()
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
      aO(new Runnable()
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
    aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39534);
        Object localObject1 = ((f)paramq).eiq();
        Log.d("MicroMsg.SearchResultAdapter", "count " + ((drt)localObject1).LUB);
        if (((drt)localObject1).LUB > 0)
        {
          localObject1 = ((drt)localObject1).LUC.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (drr)((Iterator)localObject1).next();
            if (ab.rR(((drr)localObject2).MmK))
            {
              if (b.f(b.this) == null) {
                b.a(b.this, new LinkedList());
              }
              b.f(b.this).add(localObject2);
            }
          }
        }
        Object localObject2 = z.a(((drt)localObject1).Lqk);
        Log.d("MicroMsg.SearchResultAdapter", "user ".concat(String.valueOf(localObject2)));
        if (Util.nullAsNil((String)localObject2).length() > 0)
        {
          drr localdrr = new drr();
          localdrr.Lqk = ((drt)localObject1).Lqk;
          localdrr.MmK = ((drt)localObject1).MmK;
          localdrr.keb = ((drt)localObject1).keb;
          localdrr.Mjj = ((drt)localObject1).Mjj;
          localdrr.ked = ((drt)localObject1).ked;
          localdrr.keh = ((drt)localObject1).keh;
          localdrr.kea = ((drt)localObject1).kea;
          localdrr.kdZ = ((drt)localObject1).kdZ;
          localdrr.kdY = ((drt)localObject1).kdY;
          localdrr.MmL = ((drt)localObject1).MmL;
          localdrr.MmO = ((drt)localObject1).MmO;
          localdrr.MmM = ((drt)localObject1).MmM;
          localdrr.MmN = ((drt)localObject1).MmN;
          localdrr.MmQ = ((drt)localObject1).MmQ;
          p.aYn().h((String)localObject2, z.a(((drt)localObject1).KHp));
          if (b.f(b.this) == null) {
            b.a(b.this, new LinkedList());
          }
          b.f(b.this).clear();
          if (ab.rR(localdrr.MmK)) {
            b.f(b.this).add(localdrr);
          }
          Log.d("MicroMsg.SearchResultAdapter", "count " + b.f(b.this).size());
        }
        b.b(b.this, false);
        AppMethodBeat.o(39534);
      }
    });
    AppMethodBeat.o(39563);
  }
  
  public final void vw(final boolean paramBoolean)
  {
    AppMethodBeat.i(39558);
    aO(new Runnable()
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
            if (b.this.boj((String)localObject3)) {
              ((List)localObject1).add(localObject3);
            }
            i += 1;
          }
          if (((List)localObject1).size() > 0)
          {
            localObject2 = b.this;
            bg.aVF();
            b.a((b)localObject2, com.tencent.mm.model.c.aSN().a((String[])((List)localObject1).toArray(new String[((List)localObject1).size()]), b.h(b.this), b.a(b.this)));
            AppMethodBeat.o(39541);
            return;
          }
          localObject1 = b.this;
          bg.aVF();
          b.b((b)localObject1, com.tencent.mm.model.c.aSN().gCo());
          AppMethodBeat.o(39541);
          return;
        }
        if (b.i(b.this) != null)
        {
          if (!b.h(b.this).equals("@all.chatroom.contact"))
          {
            localObject1 = bg.aVF().iBp.a(b.i(b.this), b.h(b.this), b.a(b.this), true);
            b.c(b.this, (Cursor)localObject1);
            AppMethodBeat.o(39541);
            return;
          }
          if (paramBoolean)
          {
            localObject1 = bg.aVF().iBp.a(b.i(b.this), "@micromsg.with.all.biz.qq.com.openim", b.a(b.this), false);
            localObject2 = new ArrayList();
            localObject3 = new ArrayList();
          }
          for (;;)
          {
            if (!((Cursor)localObject1).moveToNext()) {
              break label393;
            }
            String str = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("username"));
            if (!ab.Iw(str))
            {
              ((ArrayList)localObject2).add(str);
              continue;
              localObject1 = bg.aVF().iBp.a(b.i(b.this), "@micromsg.with.all.biz.qq.com", b.a(b.this), false);
              break;
            }
            ((ArrayList)localObject3).add(str);
          }
          label393:
          if (!((Cursor)localObject1).isClosed()) {
            ((Cursor)localObject1).close();
          }
          if ((((ArrayList)localObject2).size() != 0) || (((ArrayList)localObject3).size() != 0)) {}
          for (localObject1 = bg.aVF().iBp.a(b.i(b.this), (ArrayList)localObject2, null, (ArrayList)localObject3, b.a(b.this));; localObject1 = com.tencent.mm.model.c.aSN().gCo())
          {
            b.d(b.this, (Cursor)localObject1);
            AppMethodBeat.o(39541);
            return;
            bg.aVF();
          }
        }
        Object localObject1 = b.this;
        bg.aVF();
        b.e((b)localObject1, com.tencent.mm.model.c.aSN().gCo());
        AppMethodBeat.o(39541);
      }
    });
    AppMethodBeat.o(39558);
  }
  
  protected static final class a
  {
    public TextView Fxp;
    public ProgressBar QBq;
    public MaskLayout gAN;
    public TextView gwR;
    public CheckBox jVQ;
    public TextView yuS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b
 * JD-Core Version:    0.7.0.1
 */