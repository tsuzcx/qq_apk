package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.ao.a.d;
import com.tencent.mm.ao.a.e;
import com.tencent.mm.ao.af;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.q;
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
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.v.a;

public final class c
  extends v<com.tencent.mm.ao.a.c>
  implements MStorageEx.IOnStorageChange
{
  private final MMActivity iXq;
  private com.tencent.mm.ay.a.a.c jjH;
  protected MMSlideDelView.g snh;
  protected MMSlideDelView.c sni;
  protected MMSlideDelView.f snj;
  protected MMSlideDelView.d snk;
  private final String syN;
  
  public c(Context paramContext, v.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.ao.a.c());
    AppMethodBeat.i(33958);
    this.snk = MMSlideDelView.getItemStatusCallBack();
    this.jjH = null;
    super.a(parama);
    this.iXq = ((MMActivity)paramContext);
    this.syN = paramString;
    paramContext = new com.tencent.mm.ay.a.a.c.a();
    paramContext.prefixPath = e.fU(this.syN);
    paramContext.lRD = true;
    paramContext.kOl = true;
    paramContext.lRP = R.k.default_avatar;
    this.jjH = paramContext.bmL();
    AppMethodBeat.o(33958);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.snj = paramf;
  }
  
  public final void atr()
  {
    AppMethodBeat.i(33959);
    eKd();
    d locald = af.bjx();
    Object localObject = this.syN;
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
    v(locald.db.rawQuery(localStringBuilder.toString(), null));
    if (this.VZc != null) {
      this.VZc.bxN();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(33959);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(33962);
    atr();
    AppMethodBeat.o(33962);
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33961);
    com.tencent.mm.ao.a.c localc = (com.tencent.mm.ao.a.c)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new a();
      localView = View.inflate(this.iXq, R.i.efZ, null);
      paramView.iZG = ((ImageView)localView.findViewById(R.h.avatar_iv));
      paramView.iZH = ((TextView)localView.findViewById(R.h.name_tv));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      q.bml().a(localc.field_headImageUrl, paramViewGroup.iZG, this.jjH);
      paramViewGroup.iZH.setText(l.d(this.iXq, localc.field_chatName, (int)paramViewGroup.iZH.getTextSize()));
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
    if (this.snk != null) {
      this.snk.eKm();
    }
    AppMethodBeat.o(33960);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.sni = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.snh = paramg;
  }
  
  public static final class a
  {
    public ImageView iZG;
    public TextView iZH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.c
 * JD-Core Version:    0.7.0.1
 */