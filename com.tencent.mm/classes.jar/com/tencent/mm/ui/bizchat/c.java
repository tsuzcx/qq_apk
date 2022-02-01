package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.af;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.o;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

public final class c
  extends r<com.tencent.mm.al.a.c>
  implements n.b
{
  private com.tencent.mm.av.a.a.c fze;
  private final MMActivity iMV;
  protected MMSlideDelView.g ntA;
  protected MMSlideDelView.c ntB;
  protected MMSlideDelView.f ntC;
  protected MMSlideDelView.d ntD;
  private final String nxJ;
  
  public c(Context paramContext, r.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.al.a.c());
    AppMethodBeat.i(33958);
    this.ntD = MMSlideDelView.getItemStatusCallBack();
    this.fze = null;
    super.a(parama);
    this.iMV = ((MMActivity)paramContext);
    this.nxJ = paramString;
    paramContext = new com.tencent.mm.av.a.a.c.a();
    paramContext.prefixPath = com.tencent.mm.al.a.e.dw(this.nxJ);
    paramContext.hKx = true;
    paramContext.gKm = true;
    paramContext.hKI = 2131690013;
    this.fze = paramContext.aFT();
    AppMethodBeat.o(33958);
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(33959);
    cVi();
    d locald = af.aCY();
    Object localObject = this.nxJ;
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
    ac.d("MicroMsg.BizChatInfoStorage", "getBizChatFavCursor: sql:%s", new Object[] { localStringBuilder.toString() });
    setCursor(locald.db.rawQuery(localStringBuilder.toString(), null));
    if (this.HmY != null) {
      this.HmY.aPg();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(33959);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(33962);
    Xb();
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
    this.ntC = paramf;
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
      localView = View.inflate(this.iMV, 2131493846, null);
      paramView.fuY = ((ImageView)localView.findViewById(2131297008));
      paramView.fuZ = ((TextView)localView.findViewById(2131302666));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      o.aFB().a(localc.field_headImageUrl, paramViewGroup.fuY, this.fze);
      paramViewGroup.fuZ.setText(k.b(this.iMV, localc.field_chatName, (int)paramViewGroup.fuZ.getTextSize()));
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
    if (this.ntD != null) {
      this.ntD.cVr();
    }
    AppMethodBeat.o(33960);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.ntB = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.ntA = paramg;
  }
  
  public static final class a
  {
    public ImageView fuY;
    public TextView fuZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.c
 * JD-Core Version:    0.7.0.1
 */