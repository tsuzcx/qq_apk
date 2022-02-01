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
import com.tencent.mm.an.a.d;
import com.tencent.mm.an.a.e;
import com.tencent.mm.an.af;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.ui.span.p;
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
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;

public final class c
  extends x<com.tencent.mm.an.a.c>
  implements MStorageEx.IOnStorageChange
{
  private com.tencent.mm.modelimage.loader.a.c lMm;
  private final MMActivity lzt;
  private final String vEu;
  protected MMSlideDelView.g vzf;
  protected MMSlideDelView.c vzg;
  protected MMSlideDelView.f vzh;
  protected MMSlideDelView.d vzi;
  
  public c(Context paramContext, x.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.an.a.c());
    AppMethodBeat.i(33958);
    this.vzi = MMSlideDelView.getItemStatusCallBack();
    this.lMm = null;
    super.a(parama);
    this.lzt = ((MMActivity)paramContext);
    this.vEu = paramString;
    paramContext = new com.tencent.mm.modelimage.loader.a.c.a();
    paramContext.prefixPath = e.hx(this.vEu);
    paramContext.oKp = true;
    paramContext.nqa = true;
    paramContext.oKB = R.k.default_avatar;
    this.lMm = paramContext.bKx();
    AppMethodBeat.o(33958);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.vzh = paramf;
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(33959);
    fSd();
    d locald = af.bHh();
    Object localObject = this.vEu;
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
    w(locald.db.rawQuery(localStringBuilder.toString(), null));
    if (this.adDx != null) {
      this.adDx.bWC();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(33959);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(33962);
    aNy();
    AppMethodBeat.o(33962);
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33961);
    com.tencent.mm.an.a.c localc = (com.tencent.mm.an.a.c)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new a();
      localView = View.inflate(this.lzt, R.i.enterprise_bizchat_list_item, null);
      paramView.lBC = ((ImageView)localView.findViewById(R.h.avatar_iv));
      paramView.lBD = ((TextView)localView.findViewById(R.h.name_tv));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      r.bKe().a(localc.field_headImageUrl, paramViewGroup.lBC, this.lMm);
      paramViewGroup.lBD.setText(p.d(this.lzt, localc.field_chatName, (int)paramViewGroup.lBD.getTextSize()));
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
    if (this.vzi != null) {
      this.vzi.fSm();
    }
    AppMethodBeat.o(33960);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.vzg = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.vzf = paramg;
  }
  
  public static final class a
  {
    public ImageView lBC;
    public TextView lBD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.c
 * JD-Core Version:    0.7.0.1
 */