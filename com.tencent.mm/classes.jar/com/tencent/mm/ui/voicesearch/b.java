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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.v.a;
import com.tencent.mm.ui.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class b
  extends com.tencent.mm.ui.p<ad>
  implements f
{
  private boolean ABC;
  private ad ABD;
  private boolean ABE;
  public boolean ABF;
  private boolean ABG;
  private Context context;
  private ProgressDialog eeN;
  private List<String> ejc;
  private LinkedList<bxf> fjy;
  public com.tencent.mm.ui.applet.b gxo;
  private b.b gxp;
  public String sIj;
  private int showType;
  public String zZK;
  public String[] zsR;
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext, new ad());
    AppMethodBeat.i(35339);
    this.ABC = false;
    this.ABD = null;
    this.fjy = new LinkedList();
    this.ejc = null;
    this.ABE = true;
    this.eeN = null;
    this.ABF = false;
    this.showType = 1;
    this.gxo = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
    {
      public final Bitmap xh(String paramAnonymousString)
      {
        AppMethodBeat.i(35327);
        paramAnonymousString = com.tencent.mm.ah.b.b(paramAnonymousString, false, -1);
        AppMethodBeat.o(35327);
        return paramAnonymousString;
      }
    });
    this.gxp = null;
    this.ABG = false;
    this.context = paramContext;
    this.showType = paramInt;
    this.ABD = new ad();
    this.ABD.setUsername("_find_more_public_contact_");
    this.ABD.NG();
    this.zZK = "@micromsg.with.all.biz.qq.com";
    AppMethodBeat.o(35339);
  }
  
  public static String avh(String paramString)
  {
    AppMethodBeat.i(35357);
    String str = paramString.trim();
    paramString = str;
    if (str.startsWith("@")) {
      paramString = str.substring(1) + "%@micromsg.with.all.biz.qq.com";
    }
    ab.d("MicroMsg.SearchResultAdapter", "translateQueryText [" + paramString + "]");
    AppMethodBeat.o(35357);
    return paramString;
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(35352);
    lE(false);
    AppMethodBeat.o(35352);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(35354);
    bKb();
    lE(false);
    AppMethodBeat.o(35354);
  }
  
  public final bxf QU(int paramInt)
  {
    AppMethodBeat.i(35345);
    try
    {
      ab.d("MicroMsg.SearchResultAdapter", "position " + paramInt + " size " + this.fjy.size() + "  " + (paramInt - getRealCount()));
      bxf localbxf = (bxf)this.fjy.get(paramInt - getRealCount() - 1);
      AppMethodBeat.o(35345);
      return localbxf;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SearchResultAdapter", localException, "", new Object[0]);
      AppMethodBeat.o(35345);
    }
    return null;
  }
  
  public final ad QV(int paramInt)
  {
    AppMethodBeat.i(35346);
    if (xj(paramInt))
    {
      localad = (ad)bHt();
      AppMethodBeat.o(35346);
      return localad;
    }
    ad localad = (ad)super.getItem(paramInt);
    AppMethodBeat.o(35346);
    return localad;
  }
  
  public final boolean QW(int paramInt)
  {
    AppMethodBeat.i(35349);
    if (this.ABC)
    {
      int i = getRealCount();
      if ((paramInt == i) && (paramInt < i + bHs()))
      {
        AppMethodBeat.o(35349);
        return true;
      }
    }
    AppMethodBeat.o(35349);
    return false;
  }
  
  public final void avg(String paramString)
  {
    AppMethodBeat.i(35348);
    ax(new b.7(this, paramString));
    AppMethodBeat.o(35348);
  }
  
  public final boolean avi(String paramString)
  {
    AppMethodBeat.i(35360);
    if ((this.ejc != null) && (paramString != null))
    {
      Iterator localIterator = this.ejc.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(paramString))
        {
          AppMethodBeat.o(35360);
          return false;
        }
      }
    }
    AppMethodBeat.o(35360);
    return true;
  }
  
  public final void ax(Runnable paramRunnable)
  {
    AppMethodBeat.i(35359);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      notifyDataSetChanged();
      AppMethodBeat.o(35359);
      return;
    }
    al.d(new b.4(this, paramRunnable));
    AppMethodBeat.o(35359);
  }
  
  public final int bHs()
  {
    int i = 0;
    AppMethodBeat.i(35344);
    if (this.ABC)
    {
      if (this.ABD.isHidden()) {}
      for (;;)
      {
        AppMethodBeat.o(35344);
        return i + 1;
        i = this.fjy.size();
      }
    }
    AppMethodBeat.o(35344);
    return 0;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(35342);
    if (this.gxo != null)
    {
      this.gxo.detach();
      this.gxo = null;
    }
    AppMethodBeat.o(35342);
  }
  
  public final void ft(List<String> paramList)
  {
    AppMethodBeat.i(35340);
    ax(new b.5(this, paramList));
    AppMethodBeat.o(35340);
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(35343);
    if (this.showType == 2)
    {
      AppMethodBeat.o(35343);
      return 2;
    }
    if (QW(paramInt))
    {
      AppMethodBeat.o(35343);
      return 1;
    }
    AppMethodBeat.o(35343);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(35351);
    boolean bool1 = xj(paramInt);
    boolean bool2 = QW(paramInt);
    Object localObject4;
    if ((this.ABC) && (bool1))
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
          if (((b.a)localObject1).ABK == null) {
            paramViewGroup = null;
          }
        }
      }
      if (paramViewGroup == null) {
        if (bool2)
        {
          paramViewGroup = View.inflate(this.context, 2130969214, null);
          paramView = new b.a();
          paramView.ejj = ((TextView)paramViewGroup.findViewById(2131821099));
          paramView.ABK = ((ProgressBar)paramViewGroup.findViewById(2131823035));
          paramViewGroup.setTag(paramView);
        }
      }
      for (;;)
      {
        if (!bool2)
        {
          if (this.gxp == null) {
            this.gxp = new b.8(this);
          }
          if (this.gxo != null) {
            this.gxo.a(paramInt - getRealCount() - 1, this.gxp);
          }
          localObject1 = QU(paramInt);
          paramView.nSs.setVisibility(8);
          if (localObject1 == null)
          {
            AppMethodBeat.o(35351);
            return paramViewGroup;
            paramViewGroup = View.inflate(this.context, 2130969256, null);
            paramView = new b.a();
            paramView.nSs = ((TextView)paramViewGroup.findViewById(2131821089));
            paramView.ejS = ((MaskLayout)paramViewGroup.findViewById(2131821092));
            paramView.ejj = ((TextView)paramViewGroup.findViewById(2131821099));
            paramView.gpN = ((CheckBox)paramViewGroup.findViewById(2131821096));
            paramView.AfH = ((TextView)paramViewGroup.findViewById(2131821100));
            paramViewGroup.setTag(paramView);
            continue;
            paramView = (b.a)paramViewGroup.getTag();
          }
          else
          {
            paramView.AfH.setVisibility(8);
            a.b.c((ImageView)paramView.ejS.getContentView(), ((bxf)localObject1).wOT.xJE);
            if (((bxf)localObject1).xpe != 0) {
              if (ao.a.flK != null)
              {
                localObject4 = ao.a.flK.ky(((bxf)localObject1).xpe);
                if (localObject4 != null)
                {
                  localObject4 = com.tencent.mm.aj.m.sf((String)localObject4);
                  paramView.ejS.a((Bitmap)localObject4, MaskLayout.a.znW);
                  localObject1 = bo.nullAsNil(((bxf)localObject1).xmi.xJE);
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
          paramView.ejj.setText(j.b(this.context, (CharSequence)localObject1, paramView.ejj.getTextSize()));
          AppMethodBeat.o(35351);
          return paramViewGroup;
          paramView.ejS.setMaskDrawable(null);
          break;
          paramView.ejS.setMaskDrawable(null);
          break;
          paramView.ejS.setMaskDrawable(null);
        }
        catch (Exception localException1)
        {
          ab.printErrStackTrace("MicroMsg.SearchResultAdapter", localException1, "", new Object[0]);
          paramView.ejj.setText("");
          continue;
        }
        if (this.ABG) {
          paramView.ABK.setVisibility(0);
        }
        for (;;)
        {
          ab.d("MicroMsg.SearchResultAdapter", "refresh  " + this.ABE);
          if (((this.fjy != null) && (this.fjy.size() != 0)) || (this.ABE)) {
            break label619;
          }
          paramView.ejj.setText(this.context.getString(2131296481));
          paramView.ejj.setTextColor(this.context.getResources().getColor(2131690211));
          break;
          paramView.ABK.setVisibility(8);
        }
        label619:
        paramView.ejj.setText(this.context.getString(2131296482));
        paramView.ejj.setTextColor(a.l(this.context, 2131690768));
      }
    }
    if (this.showType == 2)
    {
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2130971087, null);
        paramViewGroup = new b.a();
        paramViewGroup.ejj = ((TextView)paramView.findViewById(2131821099));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject2 = QV(paramInt);
        paramViewGroup.ejj.setTextColor(a.l(this.context, 2131690768));
        try
        {
          localObject2 = this.context.getString(2131304589, new Object[] { s.a((ad)localObject2, ((aq)localObject2).field_username) });
          paramViewGroup.ejj.setText(j.b(this.context, (CharSequence)localObject2, paramViewGroup.ejj.getTextSize()));
          paramViewGroup.ejj.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          AppMethodBeat.o(35351);
          return paramView;
          paramViewGroup = (b.a)paramView.getTag();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            paramViewGroup.ejj.setText("");
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
        paramView = w.hM(this.context).inflate(2130969256, null);
        paramViewGroup = new b.a();
        paramViewGroup.nSs = ((TextView)paramView.findViewById(2131821089));
        paramViewGroup.ejS = ((MaskLayout)paramView.findViewById(2131821092));
        paramViewGroup.ejj = ((TextView)paramView.findViewById(2131821099));
        paramViewGroup.gpN = ((CheckBox)paramView.findViewById(2131821096));
        paramViewGroup.AfH = ((TextView)paramView.findViewById(2131821100));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject3 = QV(paramInt);
        if (paramViewGroup.nSs != null) {
          paramViewGroup.nSs.setVisibility(8);
        }
        localObject4 = paramViewGroup.ejj;
        Context localContext = this.context;
        if (!t.oD(((aq)localObject3).field_username)) {
          paramInt = 2131690768;
        }
        for (;;)
        {
          ((TextView)localObject4).setTextColor(a.l(localContext, paramInt));
          a.b.c((ImageView)paramViewGroup.ejS.getContentView(), ((aq)localObject3).field_username);
          paramViewGroup.AfH.setVisibility(8);
          if (((aq)localObject3).field_verifyFlag != 0) {
            if (ao.a.flK != null)
            {
              localObject4 = ao.a.flK.ky(((aq)localObject3).field_verifyFlag);
              if (localObject4 != null)
              {
                localObject4 = com.tencent.mm.aj.m.sf((String)localObject4);
                paramViewGroup.ejS.a((Bitmap)localObject4, MaskLayout.a.znW);
              }
            }
          }
          try
          {
            label1088:
            localObject4 = j.b(this.context, s.nE(((aq)localObject3).field_username), (int)paramViewGroup.ejj.getTextSize());
            if (t.nK(((aq)localObject3).field_username))
            {
              localObject3 = ((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).a(this.context, (CharSequence)localObject4);
              paramViewGroup.ejj.setText((CharSequence)localObject3);
            }
            for (;;)
            {
              AppMethodBeat.o(35351);
              return paramView;
              paramInt = 2131690769;
              break;
              paramViewGroup.ejS.setMaskDrawable(null);
              break label1088;
              paramViewGroup.ejS.setMaskDrawable(null);
              break label1088;
              paramViewGroup.ejS.setMaskDrawable(null);
              break label1088;
              paramViewGroup.ejj.setText((CharSequence)localObject4);
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              paramViewGroup.ejj.setText("");
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
    AppMethodBeat.i(35350);
    if ((QW(paramInt)) && ((this.fjy == null) || (this.fjy.size() == 0)) && (!this.ABE))
    {
      AppMethodBeat.o(35350);
      return false;
    }
    AppMethodBeat.o(35350);
    return true;
  }
  
  public final void lE(boolean paramBoolean)
  {
    AppMethodBeat.i(35353);
    ax(new b.9(this, paramBoolean));
    AppMethodBeat.o(35353);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(35356);
    aw.Rc().b(106, this);
    AppMethodBeat.o(35356);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(35355);
    aw.Rc().a(106, this);
    AppMethodBeat.o(35355);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(35358);
    ab.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramm.getType() != 106)
    {
      ab.e("MicroMsg.SearchResultAdapter", "error type");
      AppMethodBeat.o(35358);
      return;
    }
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    this.ABG = false;
    if (v.a.a(this.context, paramInt1, paramInt2, paramString, 7))
    {
      this.ABE = false;
      AppMethodBeat.o(35358);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      ax(new b.11(this));
      AppMethodBeat.o(35358);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ax(new b.2(this));
      AppMethodBeat.o(35358);
      return;
    }
    ax(new b.3(this, paramm));
    AppMethodBeat.o(35358);
  }
  
  public final void ry(boolean paramBoolean)
  {
    AppMethodBeat.i(35341);
    this.ABF = paramBoolean;
    if (paramBoolean) {
      this.ABD.NG();
    }
    AppMethodBeat.o(35341);
  }
  
  public final void rz(boolean paramBoolean)
  {
    AppMethodBeat.i(35347);
    ax(new b.6(this, paramBoolean));
    AppMethodBeat.o(35347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b
 * JD-Core Version:    0.7.0.1
 */