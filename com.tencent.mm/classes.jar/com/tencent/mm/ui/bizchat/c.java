package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.d;
import com.tencent.mm.am.ag;
import com.tencent.mm.aw.a.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

public final class c
  extends r<com.tencent.mm.am.a.c>
  implements n.b
{
  private final MMActivity fLP;
  private com.tencent.mm.aw.a.a.c fSr;
  protected MMSlideDelView.g nUw;
  protected MMSlideDelView.c nUx;
  protected MMSlideDelView.f nUy;
  protected MMSlideDelView.d nUz;
  private final String nZh;
  
  public c(Context paramContext, r.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.am.a.c());
    AppMethodBeat.i(33958);
    this.nUz = MMSlideDelView.getItemStatusCallBack();
    this.fSr = null;
    super.a(parama);
    this.fLP = ((MMActivity)paramContext);
    this.nZh = paramString;
    paramContext = new com.tencent.mm.aw.a.a.c.a();
    paramContext.prefixPath = com.tencent.mm.am.a.e.es(this.nZh);
    paramContext.idr = true;
    paramContext.hdX = true;
    paramContext.idD = 2131690013;
    this.fSr = paramContext.aJc();
    AppMethodBeat.o(33958);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(33959);
    det();
    d locald = ag.aGb();
    Object localObject = this.nZh;
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
    ad.d("MicroMsg.BizChatInfoStorage", "getBizChatFavCursor: sql:%s", new Object[] { localStringBuilder.toString() });
    setCursor(locald.db.rawQuery(localStringBuilder.toString(), null));
    if (this.JaF != null) {
      this.JaF.aSs();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(33959);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(33962);
    Zu();
    AppMethodBeat.o(33962);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(33963);
    super.a(paramInt, paramn, paramObject);
    AppMethodBeat.o(33963);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.nUy = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33961);
    com.tencent.mm.am.a.c localc = (com.tencent.mm.am.a.c)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new a();
      localView = View.inflate(this.fLP, 2131493846, null);
      paramView.fOf = ((ImageView)localView.findViewById(2131297008));
      paramView.fOg = ((TextView)localView.findViewById(2131302666));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      q.aIJ().a(localc.field_headImageUrl, paramViewGroup.fOf, this.fSr);
      paramViewGroup.fOg.setText(k.b(this.fLP, localc.field_chatName, (int)paramViewGroup.fOg.getTextSize()));
      AppMethodBeat.o(33961);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(33960);
    if (this.nUz != null) {
      this.nUz.deC();
    }
    AppMethodBeat.o(33960);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.nUx = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.nUw = paramg;
  }
  
  public static final class a
  {
    public ImageView fOf;
    public TextView fOg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.c
 * JD-Core Version:    0.7.0.1
 */