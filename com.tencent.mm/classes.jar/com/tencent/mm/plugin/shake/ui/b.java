package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;

final class b
  extends r<bt>
{
  private MMActivity bER;
  protected MMSlideDelView.g hZd;
  protected MMSlideDelView.c hZe;
  protected MMSlideDelView.d hZg = MMSlideDelView.getItemStatusCallBack();
  private int limit = -1;
  protected MMSlideDelView.f mDS;
  private bu obk;
  
  public b(Context paramContext, bu parambu, int paramInt)
  {
    super(paramContext, new bt());
    this.bER = ((MMActivity)paramContext);
    this.limit = paramInt;
    this.obk = parambu;
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.mDS = paramf;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bt localbt = (bt)getItem(paramInt);
    Object localObject;
    if (paramView == null)
    {
      localObject = (MMSlideDelView)View.inflate(this.bER, R.i.base_slide_del_view, null);
      paramView = new b.a();
      paramViewGroup = View.inflate(this.bER, R.i.say_hi_item, null);
      paramView.dpY = ((ImageView)paramViewGroup.findViewById(R.h.contactitem_avatar_iv));
      paramView.fdY = ((TextView)paramViewGroup.findViewById(R.h.display_name));
      paramView.mbo = ((TextView)paramViewGroup.findViewById(R.h.sayhi_content));
      paramView.hZl = ((MMSlideDelView)localObject).findViewById(R.h.slide_del_del_view);
      paramView.hZm = ((TextView)((MMSlideDelView)localObject).findViewById(R.h.slide_del_view_del_word));
      ((MMSlideDelView)localObject).setView(paramViewGroup);
      ((MMSlideDelView)localObject).setPerformItemClickListener(this.hZd);
      ((MMSlideDelView)localObject).setGetViewPositionCallback(this.hZe);
      ((MMSlideDelView)localObject).setItemStatusCallBack(this.hZg);
      ((MMSlideDelView)localObject).setEnable(false);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.hZl.setTag(Long.valueOf(localbt.field_svrid));
      paramViewGroup.hZl.setOnClickListener(new b.1(this));
      paramView = bi.d.acc(localbt.field_content);
      paramViewGroup.fdY.setText(j.a(this.bER, paramView.getDisplayName(), paramViewGroup.fdY.getTextSize()));
      paramViewGroup.mbo.setText(localbt.field_sayhicontent);
      a.b.a(paramViewGroup.dpY, localbt.field_sayhiuser);
      return localObject;
      paramViewGroup = (b.a)paramView.getTag();
      localObject = paramView;
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
  
  public final void xp(int paramInt)
  {
    bcS();
    this.limit = paramInt;
    yc();
  }
  
  public final void yc()
  {
    bu localbu = this.obk;
    int i = this.limit;
    String str = "SELECT * FROM " + localbu.getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + i;
    setCursor(localbu.dXw.rawQuery(str, null));
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.b
 * JD-Core Version:    0.7.0.1
 */