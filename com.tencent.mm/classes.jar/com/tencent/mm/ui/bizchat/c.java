package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.q;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.a;

public final class c
  extends s<com.tencent.mm.al.a.c>
  implements MStorageEx.IOnStorageChange
{
  private final MMActivity gte;
  private com.tencent.mm.av.a.a.c gzE;
  protected MMSlideDelView.g pkY;
  protected MMSlideDelView.c pkZ;
  protected MMSlideDelView.f pla;
  protected MMSlideDelView.d plb;
  private final String ppO;
  
  public c(Context paramContext, s.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.al.a.c());
    AppMethodBeat.i(33958);
    this.plb = MMSlideDelView.getItemStatusCallBack();
    this.gzE = null;
    super.a(parama);
    this.gte = ((MMActivity)paramContext);
    this.ppO = paramString;
    paramContext = new com.tencent.mm.av.a.a.c.a();
    paramContext.prefixPath = e.fe(this.ppO);
    paramContext.jbf = true;
    paramContext.hZF = true;
    paramContext.jbq = 2131690042;
    this.gzE = paramContext.bdv();
    AppMethodBeat.o(33958);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.pla = paramf;
  }
  
  public final void anp()
  {
    AppMethodBeat.i(33959);
    ebf();
    d locald = ag.baj();
    Object localObject = this.ppO;
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
    Log.d("MicroMsg.BizChatInfoStorage", "getBizChatFavCursor: sql:%s", new Object[] { localStringBuilder.toString() });
    setCursor(locald.db.rawQuery(localStringBuilder.toString(), null));
    if (this.OFI != null) {
      this.OFI.bnE();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(33959);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(33962);
    anp();
    AppMethodBeat.o(33962);
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33961);
    com.tencent.mm.al.a.c localc = (com.tencent.mm.al.a.c)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new a();
      localView = View.inflate(this.gte, 2131494001, null);
      paramView.gvv = ((ImageView)localView.findViewById(2131297134));
      paramView.gvw = ((TextView)localView.findViewById(2131305220));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      q.bcV().a(localc.field_headImageUrl, paramViewGroup.gvv, this.gzE);
      paramViewGroup.gvw.setText(l.e(this.gte, localc.field_chatName, (int)paramViewGroup.gvw.getTextSize()));
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
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(33963);
    super.onNotifyChange(paramInt, paramMStorageEx, paramObject);
    AppMethodBeat.o(33963);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(33960);
    if (this.plb != null) {
      this.plb.ebo();
    }
    AppMethodBeat.o(33960);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.pkZ = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.pkY = paramg;
  }
  
  public static final class a
  {
    public ImageView gvv;
    public TextView gvw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.c
 * JD-Core Version:    0.7.0.1
 */