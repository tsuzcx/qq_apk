package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.sdk.platformtools.y;

final class SnsHeader$4
  implements View.OnClickListener
{
  SnsHeader$4(SnsHeader paramSnsHeader, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    if ((paramView.getTag() instanceof String))
    {
      localObject2 = (String)paramView.getTag();
      y.i("MicroMsg.SnsHeader", "sns Header localId " + (String)localObject2);
      paramView = af.bDF().OB((String)localObject2);
      if ((SnsHeader.h(this.oYq) != null) && (paramView != null))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(SnsHeader.h(this.oYq), SnsCommentDetailUI.class);
        if ((paramView != null) && (paramView.field_userName != null) && (!paramView.field_userName.equals(""))) {
          break label114;
        }
        y.i("MicroMsg.SnsHeader", "error cntinfo or username is null");
      }
    }
    for (;;)
    {
      return;
      label114:
      ((Intent)localObject1).putExtra("INTENT_TALKER", paramView.field_userName);
      ((Intent)localObject1).putExtra("INTENT_SNS_LOCAL_ID", (String)localObject2);
      ((Intent)localObject1).putExtra("INTENT_FROMGALLERY", true);
      localObject2 = b.jd(726);
      ((b)localObject2).jg(this.oYu).jg(this.ffJ).jg(paramView.field_createTime);
      ((b)localObject2).QX();
      SnsHeader.h(this.oYq).startActivity((Intent)localObject1);
      try
      {
        localObject1 = (awe)new awe().aH(paramView.field_postBuf);
        if ((((awe)localObject1).tsu == 201) || (((awe)localObject1).tsu == 210) || (((awe)localObject1).tsu != 211))
        {
          ((awe)localObject1).tsD = true;
          paramView.field_postBuf = ((awe)localObject1).toByteArray();
          af.bDF().b(paramView.oLk, paramView);
          return;
        }
      }
      catch (Exception paramView) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsHeader.4
 * JD-Core Version:    0.7.0.1
 */