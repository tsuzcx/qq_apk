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
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.plugin.readerapp.a.b;
import com.tencent.mm.plugin.readerapp.a.c;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMNeatTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ReaderAppUI$a
  extends a<String>
{
  private Context context;
  private int dsw;
  private int ieH;
  private int ieI = 0;
  private int ieJ = 0;
  private int ieK = 0;
  private int ieL;
  private int iwi;
  private Html.ImageGetter noW = new ReaderAppUI.a.1(this);
  private int noX = 0;
  private int noY = 0;
  
  public ReaderAppUI$a(ReaderAppUI paramReaderAppUI, Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    this.context = paramContext;
    this.iwi = 3;
    this.dsw = g.buZ().hU(ReaderAppUI.a(paramReaderAppUI));
    this.ieK = paramContext.getResources().getDimensionPixelSize(a.b.SmallPadding);
    this.ieI = paramContext.getResources().getDimensionPixelSize(a.b.LargePadding);
    this.noX = paramContext.getResources().getDimensionPixelSize(a.b.BasicPaddingSize);
    this.ieJ = paramContext.getResources().getDimensionPixelSize(a.b.MiddlePadding);
    this.ieH = paramContext.getResources().getDimensionPixelSize(a.b.chatting_item_biz_sub_item_pic_size);
    this.ieL = paramContext.getResources().getDimensionPixelSize(a.b.chatting_item_biz_line_big_padding);
    int i = com.tencent.mm.cb.a.fj(paramContext);
    int j = com.tencent.mm.cb.a.fk(paramContext);
    if (i < j) {}
    for (;;)
    {
      this.noY = ((int)((i - (int)(ReaderAppUI.bur() * 32.0F)) / 2.35D));
      return;
      i = j;
    }
  }
  
  private static void E(View paramView, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void a(ReaderAppUI.a.b paramb, List<bj> paramList, int paramInt1, int paramInt2, String paramString)
  {
    ReaderAppUI.a.a locala = new ReaderAppUI.a.a(this);
    locala.ifA = View.inflate(this.context, paramInt1, null);
    locala.fcy = ((TextView)locala.ifA.findViewById(a.d.title));
    locala.ifG = ((ImageView)locala.ifA.findViewById(a.d.cover));
    locala.ifF = locala.ifA.findViewById(a.d.cover_area);
    locala.ifB = locala.ifA.findViewById(a.d.top_line);
    locala.ifC = locala.ifA.findViewById(a.d.content_ll);
    if (paramb != null)
    {
      paramb.npd.addView(locala.ifA);
      paramb.ifY.add(locala);
    }
    bj localbj = (bj)paramList.get(paramInt2);
    paramInt1 = paramList.size();
    if (paramInt2 == 1) {
      if (com.tencent.mm.sdk.platformtools.bk.bl(((bj)paramList.get(0)).Ia()))
      {
        locala.ifB.setVisibility(0);
        E(locala.ifB, this.ieI);
        if (paramInt2 != 1) {
          break label610;
        }
        if (paramInt2 != paramInt1 - 1) {
          break label589;
        }
        locala.ifC.setPadding(0, this.ieI, 0, this.ieI);
        label236:
        locala.fcy.setText(localbj.getTitle());
        if (!localbj.HV()) {
          break label660;
        }
        locala.fcy.setText(Html.fromHtml(localbj.getTitle() + "<img src='" + a.c.reader_news_video_small + "'/>", this.noW, null));
        label309:
        if (com.tencent.mm.sdk.platformtools.bk.bl(localbj.Ia())) {
          break label676;
        }
        locala.ifG.setVisibility(0);
        paramList = localbj.Ia();
        ImageView localImageView = locala.ifG;
        paramInt1 = localbj.type;
        int i = this.ieH;
        int j = this.ieH;
        paramb = paramList;
        if (com.tencent.mm.as.q.OQ()) {
          paramb = com.tencent.mm.as.q.mo(paramList);
        }
        paramList = o.ON();
        c.a locala1 = new c.a();
        locala1.ery = a.a.chatting_item_biz_default_bg;
        locala1.erf = true;
        locala1 = locala1.bn(i, j);
        locala1.eqU = new f();
        locala1.erh = com.tencent.mm.pluginsdk.model.q.y(paramb, paramInt1, "@S");
        paramList.a(paramb, localImageView, locala1.OV(), null, new com.tencent.mm.pluginsdk.ui.applet.e(0, 0, 0, null));
      }
    }
    for (;;)
    {
      paramb = this.noS.a(localbj, ReaderAppUI.a(this.noS), paramInt2, paramString);
      locala.ifA.setOnClickListener(paramb);
      return;
      locala.ifB.setVisibility(8);
      break;
      locala.ifB.setVisibility(0);
      paramb = (bj)paramList.get(paramInt2 - 1);
      paramList = (bj)paramList.get(paramInt2);
      if ((com.tencent.mm.sdk.platformtools.bk.bl(paramb.Ia())) || (com.tencent.mm.sdk.platformtools.bk.bl(paramList.Ia())))
      {
        E(locala.ifB, this.ieI);
        break;
      }
      E(locala.ifB, this.ieL);
      break;
      label589:
      locala.ifC.setPadding(0, this.ieI, 0, this.ieK);
      break label236;
      label610:
      if (paramInt2 == paramInt1 - 1)
      {
        locala.ifC.setPadding(0, this.ieK, 0, this.ieI);
        break label236;
      }
      locala.ifC.setPadding(0, this.ieK, 0, this.ieK);
      break label236;
      label660:
      locala.fcy.setText(localbj.getTitle());
      break label309;
      label676:
      locala.ifF.setVisibility(8);
    }
  }
  
  private void cB(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = this.noY;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private String ke(int paramInt)
  {
    return (String)super.getItem(paramInt);
  }
  
  public final boolean aCc()
  {
    return this.iwi >= this.dsw;
  }
  
  public final int aCd()
  {
    if (aCc()) {
      return 0;
    }
    this.iwi += 3;
    if (this.iwi <= this.dsw) {
      return 3;
    }
    this.iwi = this.dsw;
    return this.dsw % 3;
  }
  
  public final int getShowCount()
  {
    return this.iwi;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new ReaderAppUI.a.b(this);
      paramView = View.inflate(this.context, a.e.reader_app_list_item, null);
      paramViewGroup.kZl = ((TextView)paramView.findViewById(a.d.reader_app_item_time_tv));
      paramViewGroup.npd = ((ViewGroup)paramView.findViewById(a.d.reader_app_content_ll));
      paramViewGroup.fnF = paramView.findViewById(a.d.bottom_container);
      paramViewGroup.igj = paramView.findViewById(a.d.cover_container);
      paramViewGroup.ifM = ((ImageView)paramView.findViewById(a.d.press_mask_iv));
      paramViewGroup.npf = ((ImageView)paramView.findViewById(a.d.cover_shadow_mask_iv));
      paramViewGroup.fcy = ((TextView)paramView.findViewById(a.d.reader_app_item_title_tv));
      paramViewGroup.npc = ((ImageView)paramView.findViewById(a.d.reader_app_item_photo_iv));
      paramViewGroup.mbo = ((TextView)paramView.findViewById(a.d.reader_app_item_content_tv));
      paramViewGroup.ifK = paramView.findViewById(a.d.topSlot);
      paramViewGroup.npe = ((MMNeatTextView)paramView.findViewById(a.d.title_textview_in_image));
      paramViewGroup.ifY = new ArrayList();
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject1 = paramViewGroup.ifY.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ReaderAppUI.a.a)((Iterator)localObject1).next();
        paramViewGroup.npd.removeView(((ReaderAppUI.a.a)localObject2).ifA);
      }
      paramViewGroup = (ReaderAppUI.a.b)paramView.getTag();
    }
    paramViewGroup.ifY.clear();
    Object localObject1 = ke(paramInt);
    List localList = g.buZ().I((String)localObject1, 20);
    label435:
    label477:
    int i;
    label515:
    label574:
    Object localObject4;
    if (localList.size() > 0)
    {
      int k = localList.size();
      localObject3 = (bj)localList.get(0);
      paramViewGroup.kZl.setText(h.c(this.context, ((bj)localObject3).time, false));
      if (ReaderAppUI.h(this.noS) != null)
      {
        paramViewGroup.kZl.setTextColor(ReaderAppUI.h(this.noS).rZj);
        if (ReaderAppUI.h(this.noS).rZk)
        {
          paramViewGroup.kZl.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.h(this.noS).rZl);
          if (!ReaderAppUI.h(this.noS).rZm) {
            break label973;
          }
          paramViewGroup.kZl.setBackgroundResource(a.c.chat_tips_bg);
          paramViewGroup.kZl.setPadding(this.ieK, this.noX, this.ieK, this.noX);
        }
      }
      else
      {
        localObject1 = this.noS.a((bj)localObject3, ReaderAppUI.a(this.noS), 0, ((bj)localObject3).getTitle());
        paramViewGroup.ifK.setOnClickListener((View.OnClickListener)localObject1);
        if (k != 1) {
          break label984;
        }
        bool = true;
        paramViewGroup.fcy.setText(((bj)localObject3).getTitle());
        paramViewGroup.mbo.setText(((bj)localObject3).getDigest());
        if (com.tencent.mm.sdk.platformtools.bk.bl(((bj)localObject3).Ia())) {
          break label990;
        }
        i = 1;
        if (!((bj)localObject3).HV()) {
          break label996;
        }
        paramViewGroup.npe.R(Html.fromHtml(((bj)localObject3).getTitle() + "<img src='" + a.c.reader_news_video_big + "'/>", this.noW, null));
        localObject1 = paramViewGroup.mbo;
        if ((bool) && (!com.tencent.mm.sdk.platformtools.bk.bl(((bj)localObject3).getDigest()))) {
          break label1011;
        }
      }
      label973:
      label984:
      label990:
      label996:
      label1011:
      for (int j = 8;; j = 0)
      {
        ((TextView)localObject1).setVisibility(j);
        paramViewGroup.npf.setVisibility(8);
        if (!bool) {
          break label1017;
        }
        paramViewGroup.ifM.setBackgroundResource(a.c.chatting_share_reader_mask);
        paramViewGroup.fnF.setVisibility(0);
        paramViewGroup.npe.setVisibility(8);
        paramViewGroup.fcy.setVisibility(0);
        cB(paramViewGroup.ifM);
        cB(paramViewGroup.igj);
        if (i == 0) {
          break label1122;
        }
        paramViewGroup.igj.setVisibility(0);
        localObject2 = ((bj)localObject3).Ia();
        localObject4 = paramViewGroup.npc;
        i = ((bj)localObject3).type;
        j = this.noY;
        ReaderAppUI.a.2 local2 = new ReaderAppUI.a.2(this, bool, paramViewGroup);
        localObject1 = localObject2;
        if (com.tencent.mm.as.q.OQ()) {
          localObject1 = com.tencent.mm.as.q.mo((String)localObject2);
        }
        int m = a.c.biz_bg_top_rounded_mask;
        int n = a.c.biz_item_cover_top_round_bg;
        int i1 = com.tencent.mm.cb.a.fj(((ImageView)localObject4).getContext()) - (int)(ReaderAppUI.bur() * 32.0F);
        localObject2 = o.ON();
        c.a locala = new c.a();
        locala.ery = n;
        locala.erf = true;
        locala.erA = String.valueOf(m);
        locala = locala.bn(i1, j);
        locala.eqU = new f();
        locala.erh = com.tencent.mm.pluginsdk.model.q.y((String)localObject1, i, "@T");
        ((com.tencent.mm.as.a.a)localObject2).a((String)localObject1, (ImageView)localObject4, locala.OV(), null, new com.tencent.mm.pluginsdk.ui.applet.e(m, i1, j, local2));
        paramViewGroup.fnF.setBackgroundResource(a.c.chatting_item_multbg_bottom_normal);
        paramViewGroup.fnF.setPadding(this.ieI, this.ieJ, this.ieI, this.ieI);
        paramViewGroup.ifM.setVisibility(0);
        if (k <= 1) {
          break label1255;
        }
        i = 1;
        while (i < k - 1)
        {
          a(paramViewGroup, localList, a.e.reader_news_item_slot_middle, i, ((bj)localObject3).getTitle());
          i += 1;
        }
        paramViewGroup.kZl.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        break;
        paramViewGroup.kZl.setBackgroundColor(0);
        break label435;
        bool = false;
        break label477;
        i = 0;
        break label515;
        paramViewGroup.npe.R(((bj)localObject3).getTitle());
        break label574;
      }
      label1017:
      paramViewGroup.ifM.setBackgroundResource(a.c.chatting_share_reader_mask_top_round);
      localObject1 = paramViewGroup.fnF;
      if (i != 0) {}
      for (j = 8;; j = 0)
      {
        ((View)localObject1).setVisibility(j);
        paramViewGroup.fcy.setVisibility(8);
        paramViewGroup.npe.setVisibility(0);
        paramViewGroup.npe.setTextColor(this.noS.mController.uMN.getResources().getColor(a.a.light_grey_text_color));
        paramViewGroup.npe.setBackgroundResource(a.c.mm_trans);
        paramViewGroup.npe.getPaint().setFakeBoldText(true);
        break;
      }
      label1122:
      paramViewGroup.igj.setVisibility(8);
      paramViewGroup.fcy.setVisibility(0);
      localObject1 = paramViewGroup.mbo;
      if (com.tencent.mm.sdk.platformtools.bk.bl(((bj)localObject3).getDigest()))
      {
        i = 8;
        label1160:
        ((TextView)localObject1).setVisibility(i);
        if (!bool) {
          break label1223;
        }
        paramViewGroup.fnF.setBackgroundResource(a.c.chatting_item_one_item);
      }
      for (;;)
      {
        paramViewGroup.fnF.setPadding(this.ieI, this.ieI, this.ieI, this.ieI);
        paramViewGroup.ifM.setVisibility(8);
        break;
        i = 0;
        break label1160;
        label1223:
        paramViewGroup.fnF.setBackgroundResource(a.c.chatting_item_multi_top);
      }
      a(paramViewGroup, localList, a.e.reader_news_item_slot_bottom, k - 1, ((bj)localObject3).getTitle());
    }
    label1255:
    paramViewGroup.ifK.setTag(Integer.valueOf(paramInt));
    paramViewGroup.ifK.setTag(a.d.reader_msgindex, Integer.valueOf(0));
    localObject1 = ReaderAppUI.i(this.noS);
    Object localObject2 = paramViewGroup.ifK;
    Object localObject3 = this.noS;
    if (localList.size() == 1)
    {
      bool = true;
      ((com.tencent.mm.ui.widget.b.a)localObject1).c((View)localObject2, ReaderAppUI.a((ReaderAppUI)localObject3, bool), ReaderAppUI.g(this.noS));
      paramViewGroup = paramViewGroup.ifY.iterator();
      i = 1;
      label1349:
      if (!paramViewGroup.hasNext()) {
        return paramView;
      }
      localObject1 = (ReaderAppUI.a.a)paramViewGroup.next();
      ((ReaderAppUI.a.a)localObject1).ifA.setTag(Integer.valueOf(paramInt));
      localObject2 = ReaderAppUI.i(this.noS);
      localObject3 = ((ReaderAppUI.a.a)localObject1).ifA;
      localObject4 = this.noS;
      if (localList.size() != 1) {
        break label1469;
      }
    }
    label1469:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.ui.widget.b.a)localObject2).c((View)localObject3, ReaderAppUI.a((ReaderAppUI)localObject4, bool), ReaderAppUI.g(this.noS));
      ((ReaderAppUI.a.a)localObject1).ifA.setTag(a.d.reader_msgindex, Integer.valueOf(i));
      i += 1;
      break label1349;
      bool = false;
      break;
    }
    return paramView;
  }
  
  public final void yc()
  {
    long l = System.currentTimeMillis();
    this.dsw = g.buZ().hU(20);
    setCursor(g.buZ().bj(this.iwi, 20));
    y.i("MicroMsg.ReaderAppUI", "[resetCursor] cost:%sms showCount:%s totalCount:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.iwi), Integer.valueOf(this.dsw) });
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.a
 * JD-Core Version:    0.7.0.1
 */