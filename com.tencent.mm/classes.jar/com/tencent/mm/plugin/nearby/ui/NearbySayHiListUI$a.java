package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;

final class NearbySayHiListUI$a
  extends r<bf>
{
  private MMActivity bER;
  protected MMSlideDelView.g hZd;
  protected MMSlideDelView.c hZe;
  protected MMSlideDelView.d hZg = MMSlideDelView.getItemStatusCallBack();
  int limit = -1;
  private bg mDI;
  protected MMSlideDelView.f mDS;
  
  public NearbySayHiListUI$a(NearbySayHiListUI paramNearbySayHiListUI, Context paramContext, bg parambg, int paramInt)
  {
    super(paramContext, new bf());
    this.bER = ((MMActivity)paramContext);
    this.limit = paramInt;
    this.mDI = parambg;
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.mDS = paramf;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bf localbf = (bf)getItem(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new NearbySayHiListUI.a.a(this);
      paramView = (MMSlideDelView)View.inflate(this.bER, b.e.base_slide_del_view, null);
      localObject = View.inflate(this.bER, b.e.say_hi_item, null);
      paramViewGroup.dpY = ((ImageView)((View)localObject).findViewById(b.d.contactitem_avatar_iv));
      paramViewGroup.fdY = ((TextView)((View)localObject).findViewById(b.d.display_name));
      paramViewGroup.mbo = ((TextView)((View)localObject).findViewById(b.d.sayhi_content));
      paramViewGroup.hZl = paramView.findViewById(b.d.slide_del_del_view);
      paramViewGroup.hZm = ((TextView)paramView.findViewById(b.d.slide_del_view_del_word));
      paramView.setView((View)localObject);
      paramView.setPerformItemClickListener(this.hZd);
      paramView.setGetViewPositionCallback(this.hZe);
      paramView.setItemStatusCallBack(this.hZg);
      paramView.setEnable(false);
      paramView.setTag(paramViewGroup);
      if (localbf.field_flag == 0) {
        break label286;
      }
    }
    label286:
    for (Object localObject = bi.d.acc(localbf.field_content).nickname;; localObject = localbf.field_talker)
    {
      paramViewGroup.fdY.setText(j.a(this.bER, (CharSequence)localObject, paramViewGroup.fdY.getTextSize()));
      paramViewGroup.mbo.setText(j.a(this.bER, localbf.field_sayhicontent, paramViewGroup.mbo.getTextSize()));
      paramViewGroup.hZl.setTag(Long.valueOf(localbf.field_svrid));
      paramViewGroup.hZl.setOnClickListener(new NearbySayHiListUI.a.1(this));
      a.b.a(paramViewGroup.dpY, localbf.field_sayhiuser);
      return paramView;
      paramViewGroup = (NearbySayHiListUI.a.a)paramView.getTag();
      break;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.hZe = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.hZd = paramg;
  }
  
  public final void yc()
  {
    bg localbg;
    int i;
    String str;
    if (a.cki())
    {
      localbg = this.mDI;
      i = this.limit;
      str = "SELECT sayhiencryptuser,max(createtime) createtime FROM " + localbg.getTableName() + " where isSend = 0 GROUP BY sayhiencryptuser LIMIT " + i;
      str = "SELECT a.* FROM (" + str + ") b left join " + localbg.getTableName() + " a on b.sayhiencryptuser=a.sayhiencryptuser and b.createtime=a.createtime where a.isSend = 0 ORDER BY a.createtime desc LIMIT " + i;
      setCursor(localbg.dXw.rawQuery(str, null));
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      return;
      localbg = this.mDI;
      i = this.limit;
      str = "SELECT * FROM " + localbg.getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + i;
      setCursor(localbg.dXw.rawQuery(str, null));
    }
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.a
 * JD-Core Version:    0.7.0.1
 */