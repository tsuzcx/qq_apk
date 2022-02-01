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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.d;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.o;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ac.a;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class b
  extends v<as>
  implements i
{
  public String HWE;
  public String[] Wtw;
  private boolean XZH;
  private as XZI;
  private boolean XZJ;
  public boolean XZK;
  private boolean XZL;
  public String XoS;
  private Context context;
  private int fwp;
  private ProgressDialog iXX;
  private List<String> jkb;
  private LinkedList<ebn> lpz;
  public com.tencent.mm.ui.applet.b mVX;
  private b.b mVY;
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext, new as());
    AppMethodBeat.i(39544);
    this.XZH = false;
    this.XZI = null;
    this.lpz = new LinkedList();
    this.jkb = null;
    this.XZJ = true;
    this.iXX = null;
    this.XZK = false;
    this.fwp = 1;
    this.mVX = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
    {
      public final Bitmap aaG(String paramAnonymousString)
      {
        AppMethodBeat.i(39532);
        paramAnonymousString = d.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(39532);
        return paramAnonymousString;
      }
    });
    this.mVY = null;
    this.XZL = false;
    this.context = paramContext;
    this.fwp = paramInt;
    this.XZI = new as();
    this.XZI.setUsername("_find_more_public_contact_");
    this.XZI.axx();
    this.XoS = "@micromsg.with.all.biz.qq.com";
    AppMethodBeat.o(39544);
  }
  
  public static String bAX(String paramString)
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
  
  public final void Hk(boolean paramBoolean)
  {
    AppMethodBeat.i(39546);
    this.XZK = paramBoolean;
    if (paramBoolean) {
      this.XZI.axx();
    }
    AppMethodBeat.o(39546);
  }
  
  public final void Hl(final boolean paramBoolean)
  {
    AppMethodBeat.i(39552);
    aV(new Runnable()
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
  
  public final as Qx(int paramInt)
  {
    AppMethodBeat.i(39551);
    if (TR(paramInt))
    {
      localas = (as)ezC();
      AppMethodBeat.o(39551);
      return localas;
    }
    as localas = (as)super.getItem(paramInt);
    AppMethodBeat.o(39551);
    return localas;
  }
  
  public final void aV(final Runnable paramRunnable)
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
  
  public final void atr()
  {
    AppMethodBeat.i(39557);
    za(false);
    AppMethodBeat.o(39557);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(39559);
    eKd();
    za(false);
    AppMethodBeat.o(39559);
  }
  
  public final ebn axA(int paramInt)
  {
    AppMethodBeat.i(39550);
    try
    {
      Log.d("MicroMsg.SearchResultAdapter", "position " + paramInt + " size " + this.lpz.size() + "  " + (paramInt - getRealCount()));
      ebn localebn = (ebn)this.lpz.get(paramInt - getRealCount() - 1);
      AppMethodBeat.o(39550);
      return localebn;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SearchResultAdapter", localException, "", new Object[0]);
      AppMethodBeat.o(39550);
    }
    return null;
  }
  
  public final boolean axB(int paramInt)
  {
    AppMethodBeat.i(39554);
    if (this.XZH)
    {
      int i = getRealCount();
      if ((paramInt == i) && (paramInt < i + ezA()))
      {
        AppMethodBeat.o(39554);
        return true;
      }
    }
    AppMethodBeat.o(39554);
    return false;
  }
  
  public final void bAW(final String paramString)
  {
    AppMethodBeat.i(39553);
    aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39538);
        if (b.b(b.this).isHidden())
        {
          b.b(b.this).axy();
          if (b.c(b.this))
          {
            f localf = new f(paramString, 3);
            bh.aGY().a(localf, 0);
            b.d(b.this);
            AppMethodBeat.o(39538);
          }
        }
        else
        {
          b.b(b.this).axx();
        }
        AppMethodBeat.o(39538);
      }
    });
    AppMethodBeat.o(39553);
  }
  
  public final boolean bAY(String paramString)
  {
    AppMethodBeat.i(39565);
    if ((this.jkb != null) && (paramString != null))
    {
      Iterator localIterator = this.jkb.iterator();
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
  
  public final void detach()
  {
    AppMethodBeat.i(39547);
    if (this.mVX != null)
    {
      this.mVX.detach();
      this.mVX = null;
    }
    AppMethodBeat.o(39547);
  }
  
  public final int ezA()
  {
    int i = 0;
    AppMethodBeat.i(39549);
    if (this.XZH)
    {
      if (this.XZI.isHidden()) {}
      for (;;)
      {
        AppMethodBeat.o(39549);
        return i + 1;
        i = this.lpz.size();
      }
    }
    AppMethodBeat.o(39549);
    return 0;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(39548);
    if (this.fwp == 2)
    {
      AppMethodBeat.o(39548);
      return 2;
    }
    if (axB(paramInt))
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
    boolean bool1 = TR(paramInt);
    boolean bool2 = axB(paramInt);
    Object localObject4;
    if ((this.XZH) && (bool1))
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
          if (((a)localObject1).XZP == null) {
            paramViewGroup = null;
          }
        }
      }
      if (paramViewGroup == null) {
        if (bool2)
        {
          paramViewGroup = View.inflate(this.context, R.i.eeR, null);
          paramView = new a();
          paramView.jbe = ((TextView)paramViewGroup.findViewById(R.h.dCB));
          paramView.XZP = ((ProgressBar)paramViewGroup.findViewById(R.h.search_progress));
          paramViewGroup.setTag(paramView);
        }
      }
      for (;;)
      {
        if (!bool2)
        {
          if (this.mVY == null) {
            this.mVY = new b.b()
            {
              public final int byf()
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
              
              public final String yk(int paramAnonymousInt)
              {
                AppMethodBeat.i(39539);
                if (paramAnonymousInt < 0)
                {
                  Log.e("MicroMsg.SearchResultAdapter", "pos is invalid");
                  AppMethodBeat.o(39539);
                  return null;
                }
                Object localObject = b.this;
                localObject = ((b)localObject).axA(b.e((b)localObject) + paramAnonymousInt + 1);
                if (localObject == null)
                {
                  AppMethodBeat.o(39539);
                  return null;
                }
                localObject = ((ebn)localObject).SrH.Ufy;
                AppMethodBeat.o(39539);
                return localObject;
              }
            };
          }
          if (this.mVX != null) {
            this.mVX.a(paramInt - getRealCount() - 1, this.mVY);
          }
          localObject1 = axA(paramInt);
          paramView.DUW.setVisibility(8);
          if (localObject1 == null)
          {
            AppMethodBeat.o(39556);
            return paramViewGroup;
            paramViewGroup = View.inflate(this.context, R.i.efr, null);
            paramView = new a();
            paramView.DUW = ((TextView)paramViewGroup.findViewById(R.h.dCx));
            paramView.jkT = ((MaskLayout)paramViewGroup.findViewById(R.h.dCv));
            paramView.jbe = ((TextView)paramViewGroup.findViewById(R.h.dCB));
            paramView.mNd = ((CheckBox)paramViewGroup.findViewById(R.h.dCC));
            paramView.LRr = ((TextView)paramViewGroup.findViewById(R.h.dCt));
            paramViewGroup.setTag(paramView);
            continue;
            paramView = (a)paramViewGroup.getTag();
          }
          else
          {
            paramView.LRr.setVisibility(8);
            a.b.c((ImageView)paramView.jkT.getContentView(), ((ebn)localObject1).SrH.Ufy);
            if (((ebn)localObject1).TxF != 0) {
              if (az.a.ltt != null)
              {
                localObject4 = az.a.ltt.uT(((ebn)localObject1).TxF);
                if (localObject4 != null)
                {
                  localObject4 = o.US((String)localObject4);
                  paramView.jkT.a((Bitmap)localObject4, MaskLayout.a.WnW);
                  localObject1 = Util.nullAsNil(((ebn)localObject1).TtX.Ufy);
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
          paramView.jbe.setText(l.b(this.context, (CharSequence)localObject1, paramView.jbe.getTextSize()));
          AppMethodBeat.o(39556);
          return paramViewGroup;
          paramView.jkT.setMaskDrawable(null);
          break;
          paramView.jkT.setMaskDrawable(null);
          break;
          paramView.jkT.setMaskDrawable(null);
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.SearchResultAdapter", localException1, "", new Object[0]);
          paramView.jbe.setText("");
          continue;
        }
        if (this.XZL) {
          paramView.XZP.setVisibility(0);
        }
        for (;;)
        {
          Log.d("MicroMsg.SearchResultAdapter", "refresh  " + this.XZJ);
          if (((this.lpz != null) && (this.lpz.size() != 0)) || (this.XZJ)) {
            break label621;
          }
          paramView.jbe.setText(this.context.getString(R.l.enI));
          paramView.jbe.setTextColor(this.context.getResources().getColor(R.e.lightgrey));
          break;
          paramView.XZP.setVisibility(8);
        }
        label621:
        paramView.jbe.setText(this.context.getString(R.l.enJ));
        paramView.jbe.setTextColor(com.tencent.mm.ci.a.l(this.context, R.e.mm_list_textcolor_one));
      }
    }
    if (this.fwp == 2)
    {
      if (paramView == null)
      {
        paramView = View.inflate(this.context, R.i.elL, null);
        paramViewGroup = new a();
        paramViewGroup.jbe = ((TextView)paramView.findViewById(R.h.dCB));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject2 = Qx(paramInt);
        paramViewGroup.jbe.setTextColor(com.tencent.mm.ci.a.l(this.context, R.e.mm_list_textcolor_one));
        try
        {
          localObject2 = this.context.getString(R.l.eVo, new Object[] { aa.b((as)localObject2, ((ax)localObject2).field_username) });
          paramViewGroup.jbe.setText(l.b(this.context, (CharSequence)localObject2, paramViewGroup.jbe.getTextSize()));
          paramViewGroup.jbe.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          AppMethodBeat.o(39556);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            paramViewGroup.jbe.setText("");
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
        paramView = ad.kS(this.context).inflate(R.i.efr, null);
        paramViewGroup = new a();
        paramViewGroup.DUW = ((TextView)paramView.findViewById(R.h.dCx));
        paramViewGroup.jkT = ((MaskLayout)paramView.findViewById(R.h.dCv));
        paramViewGroup.jbe = ((TextView)paramView.findViewById(R.h.dCB));
        paramViewGroup.mNd = ((CheckBox)paramView.findViewById(R.h.dCC));
        paramViewGroup.LRr = ((TextView)paramView.findViewById(R.h.dCt));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject3 = Qx(paramInt);
        if (paramViewGroup.DUW != null) {
          paramViewGroup.DUW.setVisibility(8);
        }
        localObject4 = paramViewGroup.jbe;
        Context localContext = this.context;
        if (!ab.QX(((ax)localObject3).field_username)) {
          paramInt = R.e.mm_list_textcolor_one;
        }
        for (;;)
        {
          ((TextView)localObject4).setTextColor(com.tencent.mm.ci.a.l(localContext, paramInt));
          a.b.c((ImageView)paramViewGroup.jkT.getContentView(), ((ax)localObject3).field_username);
          paramViewGroup.LRr.setVisibility(8);
          if (((ax)localObject3).field_verifyFlag != 0) {
            if (az.a.ltt != null)
            {
              localObject4 = az.a.ltt.uT(((ax)localObject3).field_verifyFlag);
              if (localObject4 != null)
              {
                localObject4 = o.US((String)localObject4);
                paramViewGroup.jkT.a((Bitmap)localObject4, MaskLayout.a.WnW);
              }
            }
          }
          try
          {
            label1091:
            localObject4 = l.d(this.context, aa.PJ(((ax)localObject3).field_username), (int)paramViewGroup.jbe.getTextSize());
            if (ab.PR(((ax)localObject3).field_username))
            {
              localObject3 = ((com.tencent.mm.openim.a.a)h.ae(com.tencent.mm.openim.a.a.class)).a(this.context, (CharSequence)localObject4);
              paramViewGroup.jbe.setText((CharSequence)localObject3);
            }
            for (;;)
            {
              AppMethodBeat.o(39556);
              return paramView;
              paramInt = R.e.mm_list_textcolor_spuser;
              break;
              paramViewGroup.jkT.setMaskDrawable(null);
              break label1091;
              paramViewGroup.jkT.setMaskDrawable(null);
              break label1091;
              paramViewGroup.jkT.setMaskDrawable(null);
              break label1091;
              paramViewGroup.jbe.setText((CharSequence)localObject4);
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              paramViewGroup.jbe.setText("");
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
    if ((axB(paramInt)) && ((this.lpz == null) || (this.lpz.size() == 0)) && (!this.XZJ))
    {
      AppMethodBeat.o(39555);
      return false;
    }
    AppMethodBeat.o(39555);
    return true;
  }
  
  public final void kw(final List<String> paramList)
  {
    AppMethodBeat.i(39545);
    aV(new Runnable()
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
    bh.aGY().b(106, this);
    AppMethodBeat.o(39561);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(39560);
    bh.aGY().a(106, this);
    AppMethodBeat.o(39560);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(39563);
    Log.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramq.getType() != 106)
    {
      Log.e("MicroMsg.SearchResultAdapter", "error type");
      AppMethodBeat.o(39563);
      return;
    }
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    this.XZL = false;
    if (ac.a.a(this.context, paramInt1, paramInt2, paramString, 7))
    {
      this.XZJ = false;
      AppMethodBeat.o(39563);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      aV(new b.11(this));
      AppMethodBeat.o(39563);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      aV(new b.2(this));
      AppMethodBeat.o(39563);
      return;
    }
    aV(new b.3(this, paramq));
    AppMethodBeat.o(39563);
  }
  
  public final void za(final boolean paramBoolean)
  {
    AppMethodBeat.i(39558);
    aV(new Runnable()
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
            if (b.this.bAY((String)localObject3)) {
              ((List)localObject1).add(localObject3);
            }
            i += 1;
          }
          if (((List)localObject1).size() > 0)
          {
            localObject2 = b.this;
            bh.beI();
            b.a((b)localObject2, c.bbL().a((String[])((List)localObject1).toArray(new String[((List)localObject1).size()]), b.h(b.this), b.a(b.this)));
            AppMethodBeat.o(39541);
            return;
          }
          localObject1 = b.this;
          bh.beI();
          b.b((b)localObject1, c.bbL().hyA());
          AppMethodBeat.o(39541);
          return;
        }
        if (b.i(b.this) != null)
        {
          if (!b.h(b.this).equals("@all.chatroom.contact"))
          {
            localObject1 = bh.beI().lqT.a(b.i(b.this), b.h(b.this), b.a(b.this), true);
            b.c(b.this, (Cursor)localObject1);
            AppMethodBeat.o(39541);
            return;
          }
          if (paramBoolean)
          {
            localObject1 = bh.beI().lqT.a(b.i(b.this), "@micromsg.with.all.biz.qq.com.openim", b.a(b.this), false);
            localObject2 = new ArrayList();
            localObject3 = new ArrayList();
          }
          for (;;)
          {
            if (!((Cursor)localObject1).moveToNext()) {
              break label393;
            }
            String str = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("username"));
            if (!ab.PO(str))
            {
              ((ArrayList)localObject2).add(str);
              continue;
              localObject1 = bh.beI().lqT.a(b.i(b.this), "@micromsg.with.all.biz.qq.com", b.a(b.this), false);
              break;
            }
            ((ArrayList)localObject3).add(str);
          }
          label393:
          if (!((Cursor)localObject1).isClosed()) {
            ((Cursor)localObject1).close();
          }
          if ((((ArrayList)localObject2).size() != 0) || (((ArrayList)localObject3).size() != 0)) {}
          for (localObject1 = bh.beI().lqT.a(b.i(b.this), (ArrayList)localObject2, null, (ArrayList)localObject3, b.a(b.this));; localObject1 = c.bbL().hyA())
          {
            b.d(b.this, (Cursor)localObject1);
            AppMethodBeat.o(39541);
            return;
            bh.beI();
          }
        }
        Object localObject1 = b.this;
        bh.beI();
        b.e((b)localObject1, c.bbL().hyA());
        AppMethodBeat.o(39541);
      }
    });
    AppMethodBeat.o(39558);
  }
  
  protected static final class a
  {
    public TextView DUW;
    public TextView LRr;
    public ProgressBar XZP;
    public TextView jbe;
    public MaskLayout jkT;
    public CheckBox mNd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b
 * JD-Core Version:    0.7.0.1
 */