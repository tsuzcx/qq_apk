package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.a.k;
import com.tencent.mm.ai.z;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.r;
import java.util.List;

final class BizChatAtSomeoneUI$a
  extends r<com.tencent.mm.ai.a.j>
{
  private com.tencent.mm.as.a.a.c drd = null;
  private List<String> dru;
  String drv;
  private com.tencent.mm.ai.a.c veo;
  private String[] ves;
  private Bitmap vet;
  
  public BizChatAtSomeoneUI$a(Context paramContext, com.tencent.mm.ai.a.j paramj, com.tencent.mm.ai.a.c paramc, String[] paramArrayOfString, List<String> paramList)
  {
    super(paramContext, paramj);
    this.veo = paramc;
    this.ves = paramArrayOfString;
    this.dru = paramList;
    paramj = new c.a();
    paramj.eri = com.tencent.mm.ai.a.e.ly(this.veo.field_brandUserName);
    paramj.erf = true;
    paramj.erC = true;
    paramj.eru = R.k.default_avatar;
    this.drd = paramj.OV();
    this.vet = com.tencent.mm.sdk.platformtools.c.q(paramContext.getResources().getDrawable(R.k.at_all_avater));
  }
  
  protected final int bam()
  {
    if (BizChatAtSomeoneUI.access$100()) {
      return 1;
    }
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.context, R.i.at_someone_item, null);
      paramViewGroup = new BizChatAtSomeoneUI.b((byte)0);
      paramViewGroup.dsk = ((MaskLayout)paramView.findViewById(R.h.at_someone_item_avatar));
      paramViewGroup.drB = ((TextView)paramView.findViewById(R.h.at_someone_item_nick));
      paramView.setTag(paramViewGroup);
    }
    while ((paramInt == 0) && (BizChatAtSomeoneUI.access$100()))
    {
      paramViewGroup.veu.setImageBitmap(this.vet);
      paramViewGroup.drB.setText(this.context.getResources().getString(R.l.at_all, new Object[] { "@" }));
      return paramView;
      paramViewGroup = (BizChatAtSomeoneUI.b)paramView.getTag();
    }
    if (BizChatAtSomeoneUI.access$100()) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = (com.tencent.mm.ai.a.j)getItem(paramInt - i);
      paramViewGroup.drB.setTextColor(com.tencent.mm.cb.a.h(this.context, R.e.mm_list_textcolor_one));
      ImageView localImageView = (ImageView)paramViewGroup.dsk.getContentView();
      o.ON().a(((com.tencent.mm.ai.a.j)localObject).field_headImageUrl, localImageView, this.drd);
      paramViewGroup.dsk.setMaskDrawable(null);
      localObject = BizChatAtSomeoneUI.a(this.veo, ((com.tencent.mm.ai.a.j)localObject).field_userId);
      paramViewGroup.drB.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, (CharSequence)localObject, paramViewGroup.drB.getTextSize()));
      return paramView;
    }
  }
  
  public final boolean sk(int paramInt)
  {
    return false;
  }
  
  public final void yc()
  {
    bcS();
    k localk = z.MC();
    Object localObject2 = this.ves;
    Object localObject1 = this.drv;
    List localList = this.dru;
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
      setCursor(localk.dXw.rawQuery(localStringBuilder.toString(), null));
      super.notifyDataSetChanged();
      return;
    }
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI.a
 * JD-Core Version:    0.7.0.1
 */