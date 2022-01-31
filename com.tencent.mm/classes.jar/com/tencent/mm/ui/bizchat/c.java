package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.d;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.o;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.p.a;

public final class c
  extends p<com.tencent.mm.aj.a.c>
  implements n.b
{
  private final MMActivity cmc;
  private com.tencent.mm.at.a.a.c eiK;
  protected MMSlideDelView.g jSb;
  protected MMSlideDelView.c jSc;
  protected MMSlideDelView.f jSd;
  protected MMSlideDelView.d jSe;
  private final String jUE;
  
  public c(Context paramContext, p.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.aj.a.c());
    AppMethodBeat.i(30100);
    this.jSe = MMSlideDelView.getItemStatusCallBack();
    this.eiK = null;
    super.a(parama);
    this.cmc = ((MMActivity)paramContext);
    this.jUE = paramString;
    paramContext = new com.tencent.mm.at.a.a.c.a();
    paramContext.eNP = com.tencent.mm.aj.a.e.cV(this.jUE);
    paramContext.eNM = true;
    paramContext.eOe = true;
    paramContext.eNY = 2131231207;
    this.eiK = paramContext.ahY();
    AppMethodBeat.o(30100);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(30101);
    bKb();
    d locald = z.afk();
    Object localObject = this.jUE;
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
    ab.d("MicroMsg.BizChatInfoStorage", "getBizChatFavCursor: sql:%s", new Object[] { localStringBuilder.toString() });
    setCursor(locald.db.rawQuery(localStringBuilder.toString(), null));
    if (this.zaq != null) {
      this.zaq.apT();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(30101);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(30104);
    Ku();
    AppMethodBeat.o(30104);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(30105);
    super.a(paramInt, paramn, paramObject);
    AppMethodBeat.o(30105);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.jSd = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(30103);
    com.tencent.mm.aj.a.c localc = (com.tencent.mm.aj.a.c)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new c.a();
      localView = View.inflate(this.cmc, 2130969434, null);
      paramView.egq = ((ImageView)localView.findViewById(2131821210));
      paramView.egr = ((TextView)localView.findViewById(2131821254));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      o.ahG().a(localc.field_headImageUrl, paramViewGroup.egq, this.eiK);
      paramViewGroup.egr.setText(j.b(this.cmc, localc.field_chatName, (int)paramViewGroup.egr.getTextSize()));
      AppMethodBeat.o(30103);
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
    AppMethodBeat.i(30102);
    if (this.jSe != null) {
      this.jSe.bKk();
    }
    AppMethodBeat.o(30102);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.jSc = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.jSb = paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.c
 * JD-Core Version:    0.7.0.1
 */