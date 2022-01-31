package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.ai.a.d;
import com.tencent.mm.ai.z;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.o;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

public final class c
  extends r<com.tencent.mm.ai.a.c>
  implements m.b
{
  private final MMActivity bER;
  private com.tencent.mm.as.a.a.c drd = null;
  protected MMSlideDelView.g hZd;
  protected MMSlideDelView.c hZe;
  protected MMSlideDelView.f hZf;
  protected MMSlideDelView.d hZg = MMSlideDelView.getItemStatusCallBack();
  private final String idQ;
  
  public c(Context paramContext, r.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.ai.a.c());
    this.uMi = parama;
    this.bER = ((MMActivity)paramContext);
    this.idQ = paramString;
    paramContext = new com.tencent.mm.as.a.a.c.a();
    paramContext.eri = com.tencent.mm.ai.a.e.bT(this.idQ);
    paramContext.erf = true;
    paramContext.erC = true;
    paramContext.eru = R.k.default_avatar;
    this.drd = paramContext.OV();
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    super.a(paramInt, paramm, paramObject);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.hZf = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.tencent.mm.ai.a.c localc = (com.tencent.mm.ai.a.c)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new c.a();
      localView = View.inflate(this.bER, R.i.enterprise_bizchat_list_item, null);
      paramView.doU = ((ImageView)localView.findViewById(R.h.avatar_iv));
      paramView.doV = ((TextView)localView.findViewById(R.h.name_tv));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      o.ON().a(localc.field_headImageUrl, paramViewGroup.doU, this.drd);
      paramViewGroup.doV.setText(j.b(this.bER, localc.field_chatName, (int)paramViewGroup.doV.getTextSize()));
      return localView;
      paramViewGroup = (c.a)paramView.getTag();
      localView = paramView;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final void onPause()
  {
    if (this.hZg != null) {
      this.hZg.bdb();
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
    bcS();
    d locald = z.MA();
    Object localObject = this.idQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from BizChatInfo");
    localStringBuilder.append(" where brandUserName = '").append((String)localObject).append("'");
    localStringBuilder.append(" and (bitFlag & 8) != 0 ");
    localObject = localStringBuilder.append(" order by ");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" case when length(BizChatInfo.chatNamePY) > 0 then upper(BizChatInfo.chatNamePY) ");
    localStringBuffer.append(" else upper(BizChatInfo.chatName) end asc, ");
    localStringBuffer.append(" upper(BizChatInfo.chatNamePY) asc, ");
    localStringBuffer.append(" upper(BizChatInfo.chatName) asc ");
    ((StringBuilder)localObject).append(localStringBuffer.toString());
    y.d("MicroMsg.BizChatInfoStorage", "getBizChatFavCursor: sql:%s", new Object[] { localStringBuilder.toString() });
    setCursor(locald.dXw.rawQuery(localStringBuilder.toString(), null));
    if (this.uMi != null) {
      this.uMi.Wp();
    }
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.c
 * JD-Core Version:    0.7.0.1
 */