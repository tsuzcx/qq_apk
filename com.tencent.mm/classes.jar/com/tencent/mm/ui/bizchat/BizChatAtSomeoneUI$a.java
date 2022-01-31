package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.p;
import java.util.List;

final class BizChatAtSomeoneUI$a
  extends p<com.tencent.mm.aj.a.j>
{
  private com.tencent.mm.at.a.a.c eiK;
  private List<String> ejc;
  String ejd;
  private com.tencent.mm.aj.a.c zsO;
  private String[] zsR;
  private Bitmap zsS;
  
  public BizChatAtSomeoneUI$a(Context paramContext, com.tencent.mm.aj.a.j paramj, com.tencent.mm.aj.a.c paramc, String[] paramArrayOfString, List<String> paramList)
  {
    super(paramContext, paramj);
    AppMethodBeat.i(30031);
    this.eiK = null;
    this.zsO = paramc;
    this.zsR = paramArrayOfString;
    this.ejc = paramList;
    paramj = new c.a();
    paramj.eNP = com.tencent.mm.aj.a.e.su(this.zsO.field_brandUserName);
    paramj.eNM = true;
    paramj.eOe = true;
    paramj.eNY = 2131231207;
    this.eiK = paramj.ahY();
    this.zsS = d.u(paramContext.getResources().getDrawable(2131230931));
    AppMethodBeat.o(30031);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(30034);
    bKb();
    k localk = z.afm();
    Object localObject2 = this.zsR;
    Object localObject1 = this.ejd;
    List localList = this.ejc;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select *  from BizChatUserInfo where ");
    localObject2 = localStringBuilder.append(k.a((String[])localObject2, localList));
    if ((localObject1 == null) || (((String)localObject1).equals(""))) {}
    for (localObject1 = "";; localObject1 = " and (" + "userName like '%" + (String)localObject1 + "%' )")
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = localStringBuilder.append(" order by ");
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append(" case when length(BizChatUserInfo.userNamePY) > 0 then upper(BizChatUserInfo.userNamePY) ");
      ((StringBuffer)localObject2).append(" else upper(BizChatUserInfo.userName) end asc, ");
      ((StringBuffer)localObject2).append(" upper(BizChatUserInfo.userNamePY) asc, ");
      ((StringBuffer)localObject2).append(" upper(BizChatUserInfo.userName) asc ");
      ((StringBuilder)localObject1).append(((StringBuffer)localObject2).toString());
      setCursor(localk.db.rawQuery(localStringBuilder.toString(), null));
      super.notifyDataSetChanged();
      AppMethodBeat.o(30034);
      return;
    }
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(30035);
    Ku();
    AppMethodBeat.o(30035);
  }
  
  public final int bHs()
  {
    AppMethodBeat.i(30032);
    if (BizChatAtSomeoneUI.access$100())
    {
      AppMethodBeat.o(30032);
      return 1;
    }
    AppMethodBeat.o(30032);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(30033);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2130968786, null);
      paramViewGroup = new BizChatAtSomeoneUI.b((byte)0);
      paramViewGroup.ejS = ((MaskLayout)paramView.findViewById(2131821557));
      paramViewGroup.ejj = ((TextView)paramView.findViewById(2131821558));
      paramView.setTag(paramViewGroup);
    }
    while ((paramInt == 0) && (BizChatAtSomeoneUI.access$100()))
    {
      paramViewGroup.zsT.setImageBitmap(this.zsS);
      paramViewGroup.ejj.setText(this.context.getResources().getString(2131297210, new Object[] { "@" }));
      AppMethodBeat.o(30033);
      return paramView;
      paramViewGroup = (BizChatAtSomeoneUI.b)paramView.getTag();
    }
    if (BizChatAtSomeoneUI.access$100()) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = (com.tencent.mm.aj.a.j)getItem(paramInt - i);
      paramViewGroup.ejj.setTextColor(com.tencent.mm.cb.a.l(this.context, 2131690768));
      ImageView localImageView = (ImageView)paramViewGroup.ejS.getContentView();
      o.ahG().a(((com.tencent.mm.aj.a.j)localObject).field_headImageUrl, localImageView, this.eiK);
      paramViewGroup.ejS.setMaskDrawable(null);
      localObject = BizChatAtSomeoneUI.a(this.zsO, ((com.tencent.mm.aj.a.j)localObject).field_userId);
      paramViewGroup.ejj.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, (CharSequence)localObject, paramViewGroup.ejj.getTextSize()));
      AppMethodBeat.o(30033);
      return paramView;
    }
  }
  
  public final boolean xj(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI.a
 * JD-Core Version:    0.7.0.1
 */