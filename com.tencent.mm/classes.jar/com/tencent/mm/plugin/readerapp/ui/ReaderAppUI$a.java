package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.at.q;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bm;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ReaderAppUI$a
  extends a<String>
{
  private Context context;
  private int eke;
  private int jVA;
  private int jVv;
  private int jVw;
  private int jVx;
  private int jVy;
  private int kxm;
  private Html.ImageGetter pUk;
  private int pUl;
  private int pUm;
  
  public ReaderAppUI$a(ReaderAppUI paramReaderAppUI, Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    AppMethodBeat.i(76825);
    this.pUk = new ReaderAppUI.a.1(this);
    this.pUl = 0;
    this.jVy = 0;
    this.jVw = 0;
    this.jVx = 0;
    this.pUm = 0;
    this.context = paramContext;
    this.kxm = 3;
    this.eke = g.cfl().kH(ReaderAppUI.a(paramReaderAppUI));
    this.jVy = paramContext.getResources().getDimensionPixelSize(2131427854);
    this.jVw = paramContext.getResources().getDimensionPixelSize(2131427772);
    this.pUl = paramContext.getResources().getDimensionPixelSize(2131427496);
    this.jVx = paramContext.getResources().getDimensionPixelSize(2131427792);
    this.jVv = paramContext.getResources().getDimensionPixelSize(2131428215);
    this.jVA = paramContext.getResources().getDimensionPixelSize(2131428213);
    int i = com.tencent.mm.cb.a.gw(paramContext);
    int j = com.tencent.mm.cb.a.gx(paramContext);
    if (i < j) {}
    for (;;)
    {
      this.pUm = ((int)((i - (int)(ReaderAppUI.ceD() * 32.0F)) / 2.35D));
      AppMethodBeat.o(76825);
      return;
      i = j;
    }
  }
  
  private static void R(View paramView, int paramInt)
  {
    AppMethodBeat.i(76833);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(76833);
  }
  
  private void a(ReaderAppUI.a.a parama, int paramInt, List<bl> paramList)
  {
    AppMethodBeat.i(76834);
    int i = paramList.size();
    if (paramInt == 1) {
      if (bo.isNullOrNil(((bl)paramList.get(0)).aaZ()))
      {
        parama.jXs.setVisibility(0);
        R(parama.jXs, this.jVw);
      }
    }
    while (paramInt == 1) {
      if (paramInt == i - 1)
      {
        parama.jXt.setPadding(0, this.jVw, 0, this.jVw);
        AppMethodBeat.o(76834);
        return;
        parama.jXs.setVisibility(8);
        continue;
        parama.jXs.setVisibility(0);
        bl localbl = (bl)paramList.get(paramInt - 1);
        paramList = (bl)paramList.get(paramInt);
        if ((bo.isNullOrNil(localbl.aaZ())) || (bo.isNullOrNil(paramList.aaZ()))) {
          R(parama.jXs, this.jVw);
        } else {
          R(parama.jXs, this.jVA);
        }
      }
      else
      {
        parama.jXt.setPadding(0, this.jVw, 0, this.jVy);
        AppMethodBeat.o(76834);
        return;
      }
    }
    if (paramInt == i - 1)
    {
      parama.jXt.setPadding(0, this.jVy, 0, this.jVw);
      AppMethodBeat.o(76834);
      return;
    }
    parama.jXt.setPadding(0, this.jVy, 0, this.jVy);
    AppMethodBeat.o(76834);
  }
  
  private static void a(ReaderAppUI.a.b paramb, ReaderAppUI.a.a parama)
  {
    AppMethodBeat.i(76824);
    if (paramb == null)
    {
      AppMethodBeat.o(76824);
      return;
    }
    paramb.pUr.addView(parama.jXr);
    paramb.jYd.add(parama);
    AppMethodBeat.o(76824);
  }
  
  private void a(ReaderAppUI.a.b paramb, List<bl> paramList, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(76831);
    ReaderAppUI.a.a locala = new ReaderAppUI.a.a(this);
    locala.jXr = View.inflate(this.context, paramInt1, null);
    locala.gui = ((TextView)locala.jXr.findViewById(2131820680));
    locala.jXx = ((ImageView)locala.jXr.findViewById(2131821438));
    locala.jXw = locala.jXr.findViewById(2131821437);
    locala.jXs = locala.jXr.findViewById(2131821887);
    locala.jXt = locala.jXr.findViewById(2131821888);
    a(paramb, locala);
    paramb = (bl)paramList.get(paramInt2);
    a(locala, paramInt2, paramList);
    locala.gui.setText(paramb.getTitle());
    if (paramb.aaU())
    {
      locala.gui.setText(Html.fromHtml(paramb.getTitle() + "<img src='2130841726'/>", this.pUk, null));
      if (bo.isNullOrNil(paramb.aaZ())) {
        break label284;
      }
      locala.jXx.setVisibility(0);
      a(paramb.aaZ(), locala.jXx, this.jVv, this.jVv);
    }
    for (;;)
    {
      paramb = this.pUg.a(paramb, ReaderAppUI.a(this.pUg), paramInt2, paramString);
      locala.jXr.setOnClickListener(paramb);
      AppMethodBeat.o(76831);
      return;
      locala.gui.setText(paramb.getTitle());
      break;
      label284:
      locala.jXw.setVisibility(8);
    }
  }
  
  private static void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141045);
    if (q.ahJ()) {
      paramString = q.tu(paramString);
    }
    for (;;)
    {
      com.tencent.mm.at.a.a locala = o.ahG();
      c.a locala1 = new c.a();
      locala1.eOa = 2131689878;
      locala1.eNM = true;
      locala1 = locala1.cx(paramInt1, paramInt2);
      locala1.fHk = new f();
      locala1.eNO = p.aln(paramString);
      locala.a(paramString, paramImageView, locala1.ahY(), null, new com.tencent.mm.pluginsdk.ui.applet.e(0, 0, null, null));
      AppMethodBeat.o(141045);
      return;
    }
  }
  
  private void dd(View paramView)
  {
    AppMethodBeat.i(76832);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = this.pUm;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(76832);
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(76829);
    String str = (String)super.getItem(paramInt);
    AppMethodBeat.o(76829);
    return str;
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(76828);
    long l = System.currentTimeMillis();
    this.eke = g.cfl().kH(20);
    setCursor(g.cfl().ct(this.kxm, 20));
    ab.i("MicroMsg.ReaderAppUI", "[resetCursor] cost:%sms showCount:%s totalCount:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.kxm), Integer.valueOf(this.eke) });
    super.notifyDataSetChanged();
    AppMethodBeat.o(76828);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(76826);
    Ku();
    AppMethodBeat.o(76826);
  }
  
  public final boolean bem()
  {
    return this.kxm >= this.eke;
  }
  
  public final int ben()
  {
    AppMethodBeat.i(76827);
    if (bem())
    {
      AppMethodBeat.o(76827);
      return 0;
    }
    this.kxm += 3;
    if (this.kxm <= this.eke)
    {
      AppMethodBeat.o(76827);
      return 3;
    }
    this.kxm = this.eke;
    int i = this.eke;
    AppMethodBeat.o(76827);
    return i % 3;
  }
  
  public final int getShowCount()
  {
    return this.kxm;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(76830);
    if (paramView == null)
    {
      paramViewGroup = new ReaderAppUI.a.b(this);
      paramView = View.inflate(this.context, 2130970508, null);
      paramViewGroup.nxi = ((TextView)paramView.findViewById(2131827031));
      paramViewGroup.pUr = ((ViewGroup)paramView.findViewById(2131827032));
      paramViewGroup.gEY = paramView.findViewById(2131822522);
      paramViewGroup.jYA = paramView.findViewById(2131822519);
      paramViewGroup.jXH = ((ImageView)paramView.findViewById(2131821909));
      paramViewGroup.pUt = ((ImageView)paramView.findViewById(2131822520));
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131827034));
      paramViewGroup.pUq = ((ImageView)paramView.findViewById(2131827033));
      paramViewGroup.oBQ = ((TextView)paramView.findViewById(2131827035));
      paramViewGroup.jXW = paramView.findViewById(2131821905);
      paramViewGroup.pUs = ((MMNeat7extView)paramView.findViewById(2131822521));
      paramViewGroup.jYd = new ArrayList();
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject1 = paramViewGroup.jYd.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ReaderAppUI.a.a)((Iterator)localObject1).next();
        paramViewGroup.pUr.removeView(((ReaderAppUI.a.a)localObject2).jXr);
      }
      paramViewGroup = (ReaderAppUI.a.b)paramView.getTag();
    }
    paramViewGroup.jYd.clear();
    Object localObject1 = getItem(paramInt);
    Object localObject2 = g.cfl().Q((String)localObject1, 20);
    int k;
    Object localObject3;
    label441:
    boolean bool;
    label483:
    int i;
    label521:
    label568:
    int j;
    label594:
    Object localObject4;
    Object localObject5;
    if (((List)localObject2).size() > 0)
    {
      k = ((List)localObject2).size();
      localObject3 = (bl)((List)localObject2).get(0);
      paramViewGroup.nxi.setText(h.c(this.context, ((bl)localObject3).time, false));
      if (ReaderAppUI.h(this.pUg) != null)
      {
        paramViewGroup.nxi.setTextColor(ReaderAppUI.h(this.pUg).vQa);
        if (ReaderAppUI.h(this.pUg).vQb)
        {
          paramViewGroup.nxi.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.h(this.pUg).vQc);
          if (!ReaderAppUI.h(this.pUg).vQd) {
            break label956;
          }
          paramViewGroup.nxi.setBackgroundResource(2130838245);
          paramViewGroup.nxi.setPadding(this.jVy, this.pUl, this.jVy, this.pUl);
        }
      }
      else
      {
        localObject1 = this.pUg.a((bl)localObject3, ReaderAppUI.a(this.pUg), 0, ((bl)localObject3).getTitle());
        paramViewGroup.jXW.setOnClickListener((View.OnClickListener)localObject1);
        if (k != 1) {
          break label967;
        }
        bool = true;
        paramViewGroup.gui.setText(((bl)localObject3).getTitle());
        paramViewGroup.oBQ.setText(((bl)localObject3).getDigest());
        if (bo.isNullOrNil(((bl)localObject3).aaZ())) {
          break label973;
        }
        i = 1;
        if (!((bl)localObject3).aaU()) {
          break label979;
        }
        paramViewGroup.pUs.af(Html.fromHtml(((bl)localObject3).getTitle() + "<img src='2130841733'/>", this.pUk, null));
        localObject1 = paramViewGroup.oBQ;
        if ((bool) && (!bo.isNullOrNil(((bl)localObject3).getDigest()))) {
          break label994;
        }
        j = 8;
        ((TextView)localObject1).setVisibility(j);
        paramViewGroup.pUt.setVisibility(8);
        if (!bool) {
          break label1000;
        }
        paramViewGroup.jXH.setBackgroundResource(2130838352);
        paramViewGroup.gEY.setVisibility(0);
        paramViewGroup.pUs.setVisibility(8);
        paramViewGroup.gui.setVisibility(0);
        dd(paramViewGroup.jXH);
        dd(paramViewGroup.jYA);
        if (i == 0) {
          break label1102;
        }
        paramViewGroup.jYA.setVisibility(0);
        localObject1 = ((bl)localObject3).aaZ();
        localObject4 = paramViewGroup.pUq;
        i = this.pUm;
        localObject5 = new ReaderAppUI.a.2(this, bool, paramViewGroup);
        if (!q.ahJ()) {
          break label1463;
        }
        localObject1 = q.tu((String)localObject1);
      }
    }
    label1203:
    label1463:
    for (;;)
    {
      float f = ((ImageView)localObject4).getResources().getDimensionPixelSize(2131428218);
      j = com.tencent.mm.cb.a.gw(((ImageView)localObject4).getContext()) - (int)(ReaderAppUI.ceD() * 32.0F);
      com.tencent.mm.at.a.a locala = o.ahG();
      c.a locala1 = new c.a();
      locala1.eOa = 2130837920;
      locala1.eNM = true;
      locala1.eOc = "2130837914";
      locala1 = locala1.cx(j, i);
      locala1.fHk = new f();
      locala1.eNO = p.aln((String)localObject1);
      locala.a((String)localObject1, (ImageView)localObject4, locala1.ahY(), null, new com.tencent.mm.pluginsdk.ui.applet.e(j, i, true, false, f, (e.a)localObject5));
      paramViewGroup.gEY.setBackgroundResource(2130838328);
      paramViewGroup.gEY.setPadding(this.jVw, this.jVx, this.jVw, this.jVw);
      paramViewGroup.jXH.setVisibility(0);
      if (k > 1)
      {
        i = 1;
        for (;;)
        {
          if (i < k - 1)
          {
            a(paramViewGroup, (List)localObject2, 2130970515, i, ((bl)localObject3).getTitle());
            i += 1;
            continue;
            paramViewGroup.nxi.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            break;
            label956:
            paramViewGroup.nxi.setBackgroundColor(0);
            break label441;
            label967:
            bool = false;
            break label483;
            label973:
            i = 0;
            break label521;
            label979:
            paramViewGroup.pUs.af(((bl)localObject3).getTitle());
            break label568;
            label994:
            j = 0;
            break label594;
            label1000:
            paramViewGroup.jXH.setBackgroundResource(2130838354);
            localObject1 = paramViewGroup.gEY;
            if (i != 0) {}
            for (j = 8;; j = 0)
            {
              ((View)localObject1).setVisibility(j);
              paramViewGroup.gui.setVisibility(8);
              paramViewGroup.pUs.setVisibility(0);
              paramViewGroup.pUs.setTextColor(this.pUg.getContext().getResources().getColor(2131690208));
              paramViewGroup.pUs.setBackgroundResource(2130839676);
              paramViewGroup.pUs.getPaint().setFakeBoldText(true);
              break;
            }
            label1102:
            paramViewGroup.jYA.setVisibility(8);
            paramViewGroup.gui.setVisibility(0);
            localObject1 = paramViewGroup.oBQ;
            if (bo.isNullOrNil(((bl)localObject3).getDigest()))
            {
              i = 8;
              label1140:
              ((TextView)localObject1).setVisibility(i);
              if (!bool) {
                break label1203;
              }
              paramViewGroup.gEY.setBackgroundResource(2130838337);
            }
            for (;;)
            {
              paramViewGroup.gEY.setPadding(this.jVw, this.jVw, this.jVw, this.jVw);
              paramViewGroup.jXH.setVisibility(8);
              break;
              i = 0;
              break label1140;
              paramViewGroup.gEY.setBackgroundResource(2130838336);
            }
          }
        }
        a(paramViewGroup, (List)localObject2, 2130970514, k - 1, ((bl)localObject3).getTitle());
      }
      paramViewGroup.jXW.setTag(Integer.valueOf(paramInt));
      paramViewGroup.jXW.setTag(2131820655, Integer.valueOf(0));
      localObject1 = ReaderAppUI.i(this.pUg);
      localObject3 = paramViewGroup.jXW;
      localObject4 = this.pUg;
      if (((List)localObject2).size() == 1)
      {
        bool = true;
        ((com.tencent.mm.ui.widget.c.a)localObject1).c((View)localObject3, ReaderAppUI.a((ReaderAppUI)localObject4, bool), ReaderAppUI.g(this.pUg));
        paramViewGroup = paramViewGroup.jYd.iterator();
        i = 1;
        if (!paramViewGroup.hasNext()) {
          break label1455;
        }
        localObject1 = (ReaderAppUI.a.a)paramViewGroup.next();
        ((ReaderAppUI.a.a)localObject1).jXr.setTag(Integer.valueOf(paramInt));
        localObject3 = ReaderAppUI.i(this.pUg);
        localObject4 = ((ReaderAppUI.a.a)localObject1).jXr;
        localObject5 = this.pUg;
        if (((List)localObject2).size() != 1) {
          break label1449;
        }
      }
      for (bool = true;; bool = false)
      {
        ((com.tencent.mm.ui.widget.c.a)localObject3).c((View)localObject4, ReaderAppUI.a((ReaderAppUI)localObject5, bool), ReaderAppUI.g(this.pUg));
        ((ReaderAppUI.a.a)localObject1).jXr.setTag(2131820655, Integer.valueOf(i));
        i += 1;
        break label1329;
        bool = false;
        break;
      }
      AppMethodBeat.o(76830);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.a
 * JD-Core Version:    0.7.0.1
 */