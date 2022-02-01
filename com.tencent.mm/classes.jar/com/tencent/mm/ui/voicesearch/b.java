package com.tencent.mm.ui.voicesearch;

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
import com.tencent.mm.am.s;
import com.tencent.mm.an.o;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.eve;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.ae.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends x<au>
  implements com.tencent.mm.am.h
{
  public String NTq;
  public String[] aeaP;
  private boolean afRD;
  private au afRE;
  private boolean afRF;
  public boolean afRG;
  private boolean afRH;
  public String afau;
  private Context context;
  private int hAN;
  private List<String> lMF;
  private ProgressDialog lzP;
  private LinkedList<eve> nUC;
  public com.tencent.mm.ui.applet.b pSE;
  private b.b pSF;
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext, new au());
    AppMethodBeat.i(39544);
    this.afRD = false;
    this.afRE = null;
    this.nUC = new LinkedList();
    this.lMF = null;
    this.afRF = true;
    this.lzP = null;
    this.afRG = false;
    this.hAN = 1;
    this.pSE = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
    {
      public final Bitmap getHeadImg(String paramAnonymousString)
      {
        AppMethodBeat.i(39532);
        paramAnonymousString = d.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(39532);
        return paramAnonymousString;
      }
    });
    this.pSF = null;
    this.afRH = false;
    this.context = paramContext;
    this.hAN = paramInt;
    this.afRE = new au();
    this.afRE.setUsername("_find_more_public_contact_");
    this.afRE.aRZ();
    this.afau = "@micromsg.with.all.biz.qq.com";
    AppMethodBeat.o(39544);
  }
  
  public static String bDq(String paramString)
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
  
  public final void Ek(final boolean paramBoolean)
  {
    AppMethodBeat.i(39558);
    bd(new Runnable()
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
            if (b.this.bDr((String)localObject3)) {
              ((List)localObject1).add(localObject3);
            }
            i += 1;
          }
          if (((List)localObject1).size() > 0)
          {
            localObject2 = b.this;
            bh.bCz();
            b.a((b)localObject2, c.bzA().a((String[])((List)localObject1).toArray(new String[((List)localObject1).size()]), b.h(b.this), b.a(b.this)));
            AppMethodBeat.o(39541);
            return;
          }
          localObject1 = b.this;
          bh.bCz();
          b.b((b)localObject1, c.bzA().jaF());
          AppMethodBeat.o(39541);
          return;
        }
        if (b.i(b.this) != null)
        {
          if (!b.h(b.this).equals("@all.chatroom.contact"))
          {
            localObject1 = bh.bCz().oiu.a(b.i(b.this), b.h(b.this), b.a(b.this), true);
            b.c(b.this, (Cursor)localObject1);
            AppMethodBeat.o(39541);
            return;
          }
          if (paramBoolean)
          {
            localObject1 = bh.bCz().oiu.a(b.i(b.this), "@micromsg.with.all.biz.qq.com.openim", b.a(b.this), false);
            localObject2 = new ArrayList();
            localObject3 = new ArrayList();
          }
          for (;;)
          {
            if (!((Cursor)localObject1).moveToNext()) {
              break label393;
            }
            String str = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("username"));
            if (!au.bwE(str))
            {
              ((ArrayList)localObject2).add(str);
              continue;
              localObject1 = bh.bCz().oiu.a(b.i(b.this), "@micromsg.with.all.biz.qq.com", b.a(b.this), false);
              break;
            }
            ((ArrayList)localObject3).add(str);
          }
          label393:
          if (!((Cursor)localObject1).isClosed()) {
            ((Cursor)localObject1).close();
          }
          if ((((ArrayList)localObject2).size() != 0) || (((ArrayList)localObject3).size() != 0)) {}
          for (localObject1 = bh.bCz().oiu.a(b.i(b.this), (ArrayList)localObject2, null, (ArrayList)localObject3, b.a(b.this));; localObject1 = c.bzA().jaF())
          {
            b.d(b.this, (Cursor)localObject1);
            AppMethodBeat.o(39541);
            return;
            bh.bCz();
          }
        }
        Object localObject1 = b.this;
        bh.bCz();
        b.e((b)localObject1, c.bzA().jaF());
        AppMethodBeat.o(39541);
      }
    });
    AppMethodBeat.o(39558);
  }
  
  public final void Ng(boolean paramBoolean)
  {
    AppMethodBeat.i(39546);
    this.afRG = paramBoolean;
    if (paramBoolean) {
      this.afRE.aRZ();
    }
    AppMethodBeat.o(39546);
  }
  
  public final void Nh(final boolean paramBoolean)
  {
    AppMethodBeat.i(39552);
    bd(new Runnable()
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
  
  public final au TF(int paramInt)
  {
    AppMethodBeat.i(39551);
    if (XL(paramInt))
    {
      localau = (au)fHA();
      AppMethodBeat.o(39551);
      return localau;
    }
    au localau = (au)super.getItem(paramInt);
    AppMethodBeat.o(39551);
    return localau;
  }
  
  public final eve aEk(int paramInt)
  {
    AppMethodBeat.i(39550);
    try
    {
      Log.d("MicroMsg.SearchResultAdapter", "position " + paramInt + " size " + this.nUC.size() + "  " + (paramInt - getRealCount()));
      eve localeve = (eve)this.nUC.get(paramInt - getRealCount() - 1);
      AppMethodBeat.o(39550);
      return localeve;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SearchResultAdapter", localException, "", new Object[0]);
      AppMethodBeat.o(39550);
    }
    return null;
  }
  
  public final boolean aEl(int paramInt)
  {
    AppMethodBeat.i(39554);
    if (this.afRD)
    {
      int i = getRealCount();
      if ((paramInt == i) && (paramInt < i + fHy()))
      {
        AppMethodBeat.o(39554);
        return true;
      }
    }
    AppMethodBeat.o(39554);
    return false;
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(39557);
    Ek(false);
    AppMethodBeat.o(39557);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(39559);
    fSd();
    Ek(false);
    AppMethodBeat.o(39559);
  }
  
  public final void bDp(final String paramString)
  {
    AppMethodBeat.i(39553);
    bd(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39538);
        if (b.b(b.this).isHidden())
        {
          b.b(b.this).aSa();
          if (b.c(b.this))
          {
            f localf = new f(paramString, 3);
            bh.aZW().a(localf, 0);
            b.d(b.this);
            AppMethodBeat.o(39538);
          }
        }
        else
        {
          b.b(b.this).aRZ();
        }
        AppMethodBeat.o(39538);
      }
    });
    AppMethodBeat.o(39553);
  }
  
  public final boolean bDr(String paramString)
  {
    AppMethodBeat.i(39565);
    if ((this.lMF != null) && (paramString != null))
    {
      Iterator localIterator = this.lMF.iterator();
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
  
  public final void bd(final Runnable paramRunnable)
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
  
  public final void detach()
  {
    AppMethodBeat.i(39547);
    if (this.pSE != null)
    {
      this.pSE.detach();
      this.pSE = null;
    }
    AppMethodBeat.o(39547);
  }
  
  public final int fHy()
  {
    int i = 0;
    AppMethodBeat.i(39549);
    if (this.afRD)
    {
      if (this.afRE.isHidden()) {}
      for (;;)
      {
        AppMethodBeat.o(39549);
        return i + 1;
        i = this.nUC.size();
      }
    }
    AppMethodBeat.o(39549);
    return 0;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(39548);
    if (this.hAN == 2)
    {
      AppMethodBeat.o(39548);
      return 2;
    }
    if (aEl(paramInt))
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
    boolean bool1 = XL(paramInt);
    boolean bool2 = aEl(paramInt);
    Object localObject4;
    if ((this.afRD) && (bool1))
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
          if (((a)localObject1).afRL == null) {
            paramViewGroup = null;
          }
        }
      }
      if (paramViewGroup == null) {
        if (bool2)
        {
          paramViewGroup = View.inflate(this.context, R.i.ghJ, null);
          paramView = new a();
          paramView.lDe = ((TextView)paramViewGroup.findViewById(R.h.fDq));
          paramView.afRL = ((ProgressBar)paramViewGroup.findViewById(R.h.search_progress));
          paramViewGroup.setTag(paramView);
        }
      }
      for (;;)
      {
        if (!bool2)
        {
          if (this.pSF == null) {
            this.pSF = new b.b()
            {
              public final int bWT()
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
              
              public final String yq(int paramAnonymousInt)
              {
                AppMethodBeat.i(39539);
                if (paramAnonymousInt < 0)
                {
                  Log.e("MicroMsg.SearchResultAdapter", "pos is invalid");
                  AppMethodBeat.o(39539);
                  return null;
                }
                Object localObject = b.this;
                localObject = ((b)localObject).aEk(b.e((b)localObject) + paramAnonymousInt + 1);
                if (localObject == null)
                {
                  AppMethodBeat.o(39539);
                  return null;
                }
                localObject = ((eve)localObject).ZqL.abwM;
                AppMethodBeat.o(39539);
                return localObject;
              }
            };
          }
          if (this.pSE != null) {
            this.pSE.a(paramInt - getRealCount() - 1, this.pSF);
          }
          localObject1 = aEk(paramInt);
          paramView.JMf.setVisibility(8);
          if (localObject1 == null)
          {
            AppMethodBeat.o(39556);
            return paramViewGroup;
            paramViewGroup = View.inflate(this.context, R.i.gim, null);
            paramView = new a();
            paramView.JMf = ((TextView)paramViewGroup.findViewById(R.h.contactitem_catalog));
            paramView.lNy = ((MaskLayout)paramViewGroup.findViewById(R.h.fDl));
            paramView.lDe = ((TextView)paramViewGroup.findViewById(R.h.fDq));
            paramView.pJL = ((CheckBox)paramViewGroup.findViewById(R.h.fDr));
            paramView.StX = ((TextView)paramViewGroup.findViewById(R.h.fDj));
            paramViewGroup.setTag(paramView);
            continue;
            paramView = (a)paramViewGroup.getTag();
          }
          else
          {
            paramView.StX.setVisibility(8);
            a.b.g((ImageView)paramView.lNy.getContentView(), ((eve)localObject1).ZqL.abwM);
            if (((eve)localObject1).aaMm != 0) {
              if (az.a.okR != null)
              {
                localObject4 = az.a.okR.ve(((eve)localObject1).aaMm);
                if (localObject4 != null)
                {
                  localObject4 = o.MR((String)localObject4);
                  paramView.lNy.a((Bitmap)localObject4, MaskLayout.a.adVl);
                  localObject1 = Util.nullAsNil(((eve)localObject1).aaIz.abwM);
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
          paramView.lDe.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.context, (CharSequence)localObject1, paramView.lDe.getTextSize()));
          AppMethodBeat.o(39556);
          return paramViewGroup;
          paramView.lNy.setMaskDrawable(null);
          break;
          paramView.lNy.setMaskDrawable(null);
          break;
          paramView.lNy.setMaskDrawable(null);
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.SearchResultAdapter", localException1, "", new Object[0]);
          paramView.lDe.setText("");
          continue;
        }
        if (this.afRH) {
          paramView.afRL.setVisibility(0);
        }
        for (;;)
        {
          Log.d("MicroMsg.SearchResultAdapter", "refresh  " + this.afRF);
          if (((this.nUC != null) && (this.nUC.size() != 0)) || (this.afRF)) {
            break label621;
          }
          paramView.lDe.setText(this.context.getString(R.l.gqJ));
          paramView.lDe.setTextColor(this.context.getResources().getColor(R.e.lightgrey));
          break;
          paramView.afRL.setVisibility(8);
        }
        label621:
        paramView.lDe.setText(this.context.getString(R.l.gqK));
        paramView.lDe.setTextColor(a.l(this.context, R.e.mm_list_textcolor_one));
      }
    }
    if (this.hAN == 2)
    {
      if (paramView == null)
      {
        paramView = View.inflate(this.context, R.i.goP, null);
        paramViewGroup = new a();
        paramViewGroup.lDe = ((TextView)paramView.findViewById(R.h.fDq));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject2 = TF(paramInt);
        paramViewGroup.lDe.setTextColor(a.l(this.context, R.e.mm_list_textcolor_one));
        try
        {
          localObject2 = this.context.getString(R.l.gYs, new Object[] { aa.b((au)localObject2, ((az)localObject2).field_username) });
          paramViewGroup.lDe.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.context, (CharSequence)localObject2, paramViewGroup.lDe.getTextSize()));
          paramViewGroup.lDe.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          AppMethodBeat.o(39556);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            paramViewGroup.lDe.setText("");
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
        paramView = af.mU(this.context).inflate(R.i.gim, null);
        paramViewGroup = new a();
        paramViewGroup.JMf = ((TextView)paramView.findViewById(R.h.contactitem_catalog));
        paramViewGroup.lNy = ((MaskLayout)paramView.findViewById(R.h.fDl));
        paramViewGroup.lDe = ((TextView)paramView.findViewById(R.h.fDq));
        paramViewGroup.pJL = ((CheckBox)paramView.findViewById(R.h.fDr));
        paramViewGroup.StX = ((TextView)paramView.findViewById(R.h.fDj));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject3 = TF(paramInt);
        if (paramViewGroup.JMf != null) {
          paramViewGroup.JMf.setVisibility(8);
        }
        localObject4 = paramViewGroup.lDe;
        Context localContext = this.context;
        if (!ab.IV(((az)localObject3).field_username)) {
          paramInt = R.e.mm_list_textcolor_one;
        }
        for (;;)
        {
          ((TextView)localObject4).setTextColor(a.l(localContext, paramInt));
          a.b.g((ImageView)paramViewGroup.lNy.getContentView(), ((az)localObject3).field_username);
          paramViewGroup.StX.setVisibility(8);
          if (((az)localObject3).field_verifyFlag != 0) {
            if (az.a.okR != null)
            {
              localObject4 = az.a.okR.ve(((az)localObject3).field_verifyFlag);
              if (localObject4 != null)
              {
                localObject4 = o.MR((String)localObject4);
                paramViewGroup.lNy.a((Bitmap)localObject4, MaskLayout.a.adVl);
              }
            }
          }
          try
          {
            label1091:
            localObject4 = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, aa.getDisplayName(((az)localObject3).field_username), (int)paramViewGroup.lDe.getTextSize());
            if (ab.IG(((az)localObject3).field_username))
            {
              localObject3 = ((e)com.tencent.mm.kernel.h.ax(e.class)).a(this.context, (CharSequence)localObject4);
              paramViewGroup.lDe.setText((CharSequence)localObject3);
            }
            for (;;)
            {
              AppMethodBeat.o(39556);
              return paramView;
              paramInt = R.e.mm_list_textcolor_spuser;
              break;
              paramViewGroup.lNy.setMaskDrawable(null);
              break label1091;
              paramViewGroup.lNy.setMaskDrawable(null);
              break label1091;
              paramViewGroup.lNy.setMaskDrawable(null);
              break label1091;
              paramViewGroup.lDe.setText((CharSequence)localObject4);
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              paramViewGroup.lDe.setText("");
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
    if ((aEl(paramInt)) && ((this.nUC == null) || (this.nUC.size() == 0)) && (!this.afRF))
    {
      AppMethodBeat.o(39555);
      return false;
    }
    AppMethodBeat.o(39555);
    return true;
  }
  
  public final void nM(final List<String> paramList)
  {
    AppMethodBeat.i(39545);
    bd(new Runnable()
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
    bh.aZW().b(106, this);
    AppMethodBeat.o(39561);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(39560);
    bh.aZW().a(106, this);
    AppMethodBeat.o(39560);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(39563);
    Log.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramp.getType() != 106)
    {
      Log.e("MicroMsg.SearchResultAdapter", "error type");
      AppMethodBeat.o(39563);
      return;
    }
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    this.afRH = false;
    if (ae.a.a(this.context, paramInt1, paramInt2, paramString, 7))
    {
      this.afRF = false;
      AppMethodBeat.o(39563);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      bd(new Runnable()
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
      bd(new Runnable()
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
    bd(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39534);
        Object localObject1 = ((f)paramp).gaH();
        Log.d("MicroMsg.SearchResultAdapter", "count " + ((evg)localObject1).aaqy);
        if (((evg)localObject1).aaqy > 0)
        {
          localObject1 = ((evg)localObject1).aaqz.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (eve)((Iterator)localObject1).next();
            if (ab.uY(((eve)localObject2).aaMm))
            {
              if (b.f(b.this) == null) {
                b.a(b.this, new LinkedList());
              }
              b.f(b.this).add(localObject2);
            }
          }
        }
        Object localObject2 = w.a(((evg)localObject1).ZqL);
        Log.d("MicroMsg.SearchResultAdapter", "user ".concat(String.valueOf(localObject2)));
        if (Util.nullAsNil((String)localObject2).length() > 0)
        {
          eve localeve = new eve();
          localeve.ZqL = ((evg)localObject1).ZqL;
          localeve.aaMm = ((evg)localObject1).aaMm;
          localeve.pSi = ((evg)localObject1).pSi;
          localeve.aaIz = ((evg)localObject1).aaIz;
          localeve.pSk = ((evg)localObject1).pSk;
          localeve.pSo = ((evg)localObject1).pSo;
          localeve.pSh = ((evg)localObject1).pSh;
          localeve.pSg = ((evg)localObject1).pSg;
          localeve.pSf = ((evg)localObject1).pSf;
          localeve.aaMn = ((evg)localObject1).aaMn;
          localeve.aaMq = ((evg)localObject1).aaMq;
          localeve.aaMo = ((evg)localObject1).aaMo;
          localeve.aaMp = ((evg)localObject1).aaMp;
          localeve.aaMs = ((evg)localObject1).aaMs;
          q.bFp().j((String)localObject2, w.a(((evg)localObject1).YFI));
          if (b.f(b.this) == null) {
            b.a(b.this, new LinkedList());
          }
          b.f(b.this).clear();
          if (ab.uY(localeve.aaMm)) {
            b.f(b.this).add(localeve);
          }
          Log.d("MicroMsg.SearchResultAdapter", "count " + b.f(b.this).size());
        }
        b.b(b.this, false);
        AppMethodBeat.o(39534);
      }
    });
    AppMethodBeat.o(39563);
  }
  
  protected static final class a
  {
    public TextView JMf;
    public TextView StX;
    public ProgressBar afRL;
    public TextView lDe;
    public MaskLayout lNy;
    public CheckBox pJL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b
 * JD-Core Version:    0.7.0.1
 */