package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.cb.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.c;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.w.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class b
  extends com.tencent.mm.ui.r<ad>
  implements f
{
  private Context context;
  private LinkedList<bnk> dTx = new LinkedList();
  private ProgressDialog dnm = null;
  private List<String> dru = null;
  public com.tencent.mm.ui.applet.b ffG = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
  {
    public final Bitmap pM(String paramAnonymousString)
    {
      return com.tencent.mm.ag.b.a(paramAnonymousString, false, -1);
    }
  });
  private b.b ffH = null;
  private int showType = 1;
  public String vIs;
  public String[] ves;
  public String wiK;
  private boolean wiL = false;
  private ad wiM = null;
  private boolean wiN = true;
  public boolean wiO = false;
  private boolean wiP = false;
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext, new ad());
    this.context = paramContext;
    this.showType = paramInt;
    this.wiM = new ad();
    this.wiM.setUsername("_find_more_public_contact_");
    this.wiM.AQ();
    this.vIs = "@micromsg.with.all.biz.qq.com";
  }
  
  public static String aeu(String paramString)
  {
    String str = paramString.trim();
    paramString = str;
    if (str.startsWith("@")) {
      paramString = str.substring(1) + "%@micromsg.with.all.biz.qq.com";
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SearchResultAdapter", "translateQueryText [" + paramString + "]");
    return paramString;
  }
  
  public final bnk Ii(int paramInt)
  {
    try
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SearchResultAdapter", "position " + paramInt + " size " + this.dTx.size() + "  " + (paramInt - getRealCount()));
      bnk localbnk = (bnk)this.dTx.get(paramInt - getRealCount() - 1);
      return localbnk;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.SearchResultAdapter", localException, "", new Object[0]);
    }
    return null;
  }
  
  public final ad Ij(int paramInt)
  {
    if (sk(paramInt)) {
      return (ad)ban();
    }
    return (ad)super.getItem(paramInt);
  }
  
  public final boolean Ik(int paramInt)
  {
    if (this.wiL)
    {
      int i = getRealCount();
      if ((paramInt == i) && (paramInt < i + bam())) {
        return true;
      }
    }
    return false;
  }
  
  public final void aet(String paramString)
  {
    aj(new b.7(this, paramString));
  }
  
  public final boolean aev(String paramString)
  {
    if ((this.dru != null) && (paramString != null))
    {
      Iterator localIterator = this.dru.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(paramString)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public final void aj(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      notifyDataSetChanged();
      return;
    }
    ai.d(new b.4(this, paramRunnable));
  }
  
  protected final int bam()
  {
    int i = 0;
    int j = 0;
    if (this.wiL) {
      if (!this.wiM.isHidden()) {
        break label29;
      }
    }
    label29:
    for (i = j;; i = this.dTx.size())
    {
      i += 1;
      return i;
    }
  }
  
  public final void detach()
  {
    if (this.ffG != null)
    {
      this.ffG.detach();
      this.ffG = null;
    }
  }
  
  public final void ej(List<String> paramList)
  {
    aj(new b.5(this, paramList));
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (this.showType == 2) {
      return 2;
    }
    if (Ik(paramInt)) {
      return 1;
    }
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool1 = sk(paramInt);
    boolean bool2 = Ik(paramInt);
    Object localObject4;
    if ((this.wiL) && (bool1))
    {
      paramViewGroup = paramView;
      Object localObject1;
      if (paramView != null)
      {
        localObject1 = (b.a)paramView.getTag();
        paramViewGroup = paramView;
        if (bool2)
        {
          paramViewGroup = paramView;
          if (((b.a)localObject1).wiS == null) {
            paramViewGroup = null;
          }
        }
      }
      if (paramViewGroup == null) {
        if (bool2)
        {
          paramViewGroup = View.inflate(this.context, R.i.contact_find_more_item, null);
          paramView = new b.a();
          paramView.drB = ((TextView)paramViewGroup.findViewById(R.h.contactitem_nick));
          paramView.wiS = ((ProgressBar)paramViewGroup.findViewById(R.h.search_progress));
          paramViewGroup.setTag(paramView);
        }
      }
      while (!bool2)
      {
        if (this.ffH == null) {
          this.ffH = new b.b()
          {
            public final int WL()
            {
              if (b.f(b.this) == null) {
                return 0;
              }
              return b.f(b.this).size();
            }
            
            public final String jX(int paramAnonymousInt)
            {
              if (paramAnonymousInt < 0) {
                com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SearchResultAdapter", "pos is invalid");
              }
              bnk localbnk;
              do
              {
                return null;
                localbnk = b.this.Ii(b.e(b.this) + paramAnonymousInt + 1);
              } while (localbnk == null);
              return localbnk.sQs.tFO;
            }
          };
        }
        if (this.ffG != null) {
          this.ffG.a(paramInt - getRealCount() - 1, this.ffH);
        }
        localObject1 = Ii(paramInt);
        paramView.lvb.setVisibility(8);
        if (localObject1 == null)
        {
          return paramViewGroup;
          paramViewGroup = View.inflate(this.context, R.i.contact_item, null);
          paramView = new b.a();
          paramView.lvb = ((TextView)paramViewGroup.findViewById(R.h.contactitem_catalog));
          paramView.dsk = ((MaskLayout)paramViewGroup.findViewById(R.h.contactitem_avatar));
          paramView.drB = ((TextView)paramViewGroup.findViewById(R.h.contactitem_nick));
          paramView.eXQ = ((CheckBox)paramViewGroup.findViewById(R.h.contactitem_select_cb));
          paramView.vNZ = ((TextView)paramViewGroup.findViewById(R.h.contactitem_account));
          paramViewGroup.setTag(paramView);
          continue;
          paramView = (b.a)paramViewGroup.getTag();
        }
        else
        {
          paramView.vNZ.setVisibility(8);
          a.b.a((ImageView)paramView.dsk.getContentView(), ((bnk)localObject1).sQs.tFO);
          if (((bnk)localObject1).tpg != 0) {
            if (am.a.dVA != null)
            {
              localObject4 = am.a.dVA.hM(((bnk)localObject1).tpg);
              if (localObject4 != null)
              {
                localObject4 = com.tencent.mm.ai.m.lk((String)localObject4);
                paramView.dsk.a((Bitmap)localObject4, MaskLayout.a.uZF);
              }
            }
          }
          for (;;)
          {
            localObject1 = bk.pm(((bnk)localObject1).tmw.tFO);
            try
            {
              paramView.drB.setText(j.a(this.context, (CharSequence)localObject1, paramView.drB.getTextSize()));
              return paramViewGroup;
            }
            catch (Exception localException1)
            {
              com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.SearchResultAdapter", localException1, "", new Object[0]);
              paramView.drB.setText("");
              return paramViewGroup;
            }
            paramView.dsk.setMaskDrawable(null);
            continue;
            paramView.dsk.setMaskDrawable(null);
            continue;
            paramView.dsk.setMaskDrawable(null);
          }
        }
      }
      if (this.wiP) {
        paramView.wiS.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SearchResultAdapter", "refresh  " + this.wiN);
        if (((this.dTx != null) && (this.dTx.size() != 0)) || (this.wiN)) {
          break;
        }
        paramView.drB.setText(this.context.getString(R.l.address_more_no_public_contact));
        paramView.drB.setTextColor(this.context.getResources().getColor(R.e.lightgrey));
        return paramViewGroup;
        paramView.wiS.setVisibility(8);
      }
      paramView.drB.setText(this.context.getString(R.l.address_more_public_contact));
      paramView.drB.setTextColor(a.h(this.context, R.e.mm_list_textcolor_one));
      return paramViewGroup;
    }
    if (this.showType == 2)
    {
      if (paramView == null)
      {
        paramView = View.inflate(this.context, R.i.voice_dosearch_item, null);
        paramViewGroup = new b.a();
        paramViewGroup.drB = ((TextView)paramView.findViewById(R.h.contactitem_nick));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject2 = Ij(paramInt);
        paramViewGroup.drB.setTextColor(a.h(this.context, R.e.mm_list_textcolor_one));
        try
        {
          localObject2 = this.context.getString(R.l.voice_search_item_tip, new Object[] { com.tencent.mm.model.r.a((ad)localObject2, ((ao)localObject2).field_username) });
          paramViewGroup.drB.setText(j.a(this.context, (CharSequence)localObject2, paramViewGroup.drB.getTextSize()));
          paramViewGroup.drB.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          return paramView;
          paramViewGroup = (b.a)paramView.getTag();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            paramViewGroup.drB.setText("");
          }
        }
      }
    }
    if (paramView != null)
    {
      paramViewGroup = (b.a)paramView.getTag();
      if (paramViewGroup == null) {
        paramView = null;
      }
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramView = com.tencent.mm.ui.y.gt(this.context).inflate(R.i.contact_item, null);
        paramViewGroup = new b.a();
        paramViewGroup.lvb = ((TextView)paramView.findViewById(R.h.contactitem_catalog));
        paramViewGroup.dsk = ((MaskLayout)paramView.findViewById(R.h.contactitem_avatar));
        paramViewGroup.drB = ((TextView)paramView.findViewById(R.h.contactitem_nick));
        paramViewGroup.eXQ = ((CheckBox)paramView.findViewById(R.h.contactitem_select_cb));
        paramViewGroup.vNZ = ((TextView)paramView.findViewById(R.h.contactitem_account));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject3 = Ij(paramInt);
        if (paramViewGroup.lvb != null) {
          paramViewGroup.lvb.setVisibility(8);
        }
        localObject4 = paramViewGroup.drB;
        Context localContext = this.context;
        if (!s.hU(((ao)localObject3).field_username)) {
          paramInt = R.e.mm_list_textcolor_one;
        }
        for (;;)
        {
          ((TextView)localObject4).setTextColor(a.h(localContext, paramInt));
          a.b.a((ImageView)paramViewGroup.dsk.getContentView(), ((ao)localObject3).field_username);
          paramViewGroup.vNZ.setVisibility(8);
          if (((ao)localObject3).field_verifyFlag != 0) {
            if (am.a.dVA != null)
            {
              localObject4 = am.a.dVA.hM(((ao)localObject3).field_verifyFlag);
              if (localObject4 != null)
              {
                localObject4 = com.tencent.mm.ai.m.lk((String)localObject4);
                paramViewGroup.dsk.a((Bitmap)localObject4, MaskLayout.a.uZF);
              }
            }
          }
          try
          {
            label1061:
            localObject4 = j.b(this.context, com.tencent.mm.model.r.gV(((ao)localObject3).field_username), (int)paramViewGroup.drB.getTextSize());
            if (s.hb(((ao)localObject3).field_username))
            {
              localObject3 = ((com.tencent.mm.openim.a.b)g.r(com.tencent.mm.openim.a.b.class)).a(this.context, (CharSequence)localObject4);
              paramViewGroup.drB.setText((CharSequence)localObject3);
            }
            for (;;)
            {
              return paramView;
              paramInt = R.e.mm_list_textcolor_spuser;
              break;
              paramViewGroup.dsk.setMaskDrawable(null);
              break label1061;
              paramViewGroup.dsk.setMaskDrawable(null);
              break label1061;
              paramViewGroup.dsk.setMaskDrawable(null);
              break label1061;
              paramViewGroup.drB.setText((CharSequence)localObject4);
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              paramViewGroup.drB.setText("");
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
    return (!Ik(paramInt)) || ((this.dTx != null) && (this.dTx.size() != 0)) || (this.wiN);
  }
  
  public final void jy(boolean paramBoolean)
  {
    aj(new b.9(this, paramBoolean));
  }
  
  public final void nO(boolean paramBoolean)
  {
    this.wiO = paramBoolean;
    if (paramBoolean) {
      this.wiM.AQ();
    }
  }
  
  public final void nP(boolean paramBoolean)
  {
    aj(new b.6(this, paramBoolean));
  }
  
  public final void onPause()
  {
    au.Dk().b(106, this);
  }
  
  public final void onResume()
  {
    au.Dk().a(106, this);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramm.getType() != 106)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SearchResultAdapter", "error type");
      return;
    }
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    this.wiP = false;
    if (w.a.a(this.context, paramInt1, paramInt2, paramString, 7))
    {
      this.wiN = false;
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      aj(new b.11(this));
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      aj(new b.2(this));
      return;
    }
    aj(new b.3(this, paramm));
  }
  
  public final void yc()
  {
    jy(false);
  }
  
  protected final void yd()
  {
    bcS();
    jy(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b
 * JD-Core Version:    0.7.0.1
 */