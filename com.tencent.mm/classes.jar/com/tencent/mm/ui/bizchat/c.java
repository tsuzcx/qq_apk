package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.d;
import com.tencent.mm.am.af;
import com.tencent.mm.aw.a.a;
import com.tencent.mm.aw.o;
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
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.q.a;

public final class c
  extends q<com.tencent.mm.am.a.c>
  implements n.b
{
  private com.tencent.mm.aw.a.a.c fvx;
  private final MMActivity imP;
  protected MMSlideDelView.g mRk;
  protected MMSlideDelView.c mRl;
  protected MMSlideDelView.f mRm;
  protected MMSlideDelView.d mRn;
  private final String mVj;
  
  public c(Context paramContext, q.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.am.a.c());
    AppMethodBeat.i(33958);
    this.mRn = MMSlideDelView.getItemStatusCallBack();
    this.fvx = null;
    super.a(parama);
    this.imP = ((MMActivity)paramContext);
    this.mVj = paramString;
    paramContext = new com.tencent.mm.aw.a.a.c.a();
    paramContext.prefixPath = com.tencent.mm.am.a.e.dH(this.mVj);
    paramContext.hjU = true;
    paramContext.gjA = true;
    paramContext.hkf = 2131690013;
    this.fvx = paramContext.azc();
    AppMethodBeat.o(33958);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(33959);
    cHX();
    d locald = af.awg();
    Object localObject = this.mVj;
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
    if (this.FNn != null) {
      this.FNn.aIp();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(33959);
  }
  
  public final void We()
  {
    AppMethodBeat.i(33962);
    Wd();
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
    this.mRm = paramf;
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
      localView = View.inflate(this.imP, 2131493846, null);
      paramView.frr = ((ImageView)localView.findViewById(2131297008));
      paramView.frs = ((TextView)localView.findViewById(2131302666));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      o.ayJ().a(localc.field_headImageUrl, paramViewGroup.frr, this.fvx);
      paramViewGroup.frs.setText(k.b(this.imP, localc.field_chatName, (int)paramViewGroup.frs.getTextSize()));
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
    if (this.mRn != null) {
      this.mRn.cIg();
    }
    AppMethodBeat.o(33960);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.mRl = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.mRk = paramg;
  }
  
  public static final class a
  {
    public ImageView frr;
    public TextView frs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.c
 * JD-Core Version:    0.7.0.1
 */