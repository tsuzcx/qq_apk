package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bi;

public final class v
  extends com.tencent.mm.ui.r<bi>
{
  private String ece;
  public String talker;
  private boolean vgB;
  private String vkV;
  public v.a vkW;
  
  public v(Context paramContext, bi parambi, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, parambi);
    this.talker = paramString1;
    this.ece = paramString2;
    this.vgB = paramBoolean;
  }
  
  private String aC(bi parambi)
  {
    if (parambi.field_isSend == 1) {
      return this.ece;
    }
    return this.talker;
  }
  
  private CharSequence aD(bi parambi)
  {
    if (parambi.field_createTime == 9223372036854775807L) {
      return "";
    }
    return h.c(this.context, parambi.field_createTime, true);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.context, R.i.search_chat_content_item, null);
      paramViewGroup = new v.b((byte)0);
      paramViewGroup.doU = ((ImageView)paramView.findViewById(R.h.avatar_iv));
      paramViewGroup.doV = ((TextView)paramView.findViewById(R.h.nickname_tv));
      paramViewGroup.hZi = ((TextView)paramView.findViewById(R.h.update_time_tv));
      paramViewGroup.vkX = ((TextView)paramView.findViewById(R.h.msg_tv));
      paramView.setTag(paramViewGroup);
    }
    Object localObject;
    for (;;)
    {
      localObject = (bi)getItem(paramInt);
      if (localObject != null)
      {
        if ((!this.vgB) || (((cs)localObject).field_isSend != 0)) {
          break;
        }
        String str1 = ((cs)localObject).field_content;
        String str2 = bd.iI(str1);
        if (!ah.bl(str2))
        {
          a.b.a(paramViewGroup.doU, str2);
          paramViewGroup.doV.setText(j.a(this.context, com.tencent.mm.model.r.gV(str2), paramViewGroup.doV.getTextSize()));
        }
        paramViewGroup.hZi.setText(aD((bi)localObject));
        localObject = bd.iJ(str1);
        paramViewGroup.vkX.setText(j.a(this.context, (CharSequence)localObject, paramViewGroup.vkX.getTextSize()));
      }
      return paramView;
      paramViewGroup = (v.b)paramView.getTag();
    }
    a.b.a(paramViewGroup.doU, aC((bi)localObject));
    paramViewGroup.doV.setText(j.a(this.context, com.tencent.mm.model.r.gV(aC((bi)localObject)), paramViewGroup.doV.getTextSize()));
    paramViewGroup.hZi.setText(aD((bi)localObject));
    paramViewGroup.vkX.setText(j.a(this.context, ((cs)localObject).field_content, paramViewGroup.vkX.getTextSize()));
    return paramView;
  }
  
  public final void pA(String paramString)
  {
    this.vkV = paramString;
    if (!ah.bl(this.vkV))
    {
      bcS();
      yc();
    }
  }
  
  public final void yc()
  {
    au.Hx();
    setCursor(c.Fy().dQ(this.talker, this.vkV));
    if ((this.vkW != null) && (!ah.bl(this.vkV))) {
      this.vkW.GR(getCount());
    }
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    bcS();
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v
 * JD-Core Version:    0.7.0.1
 */