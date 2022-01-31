package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;

final class BizContactEntranceView$1
  implements View.OnClickListener
{
  BizContactEntranceView$1(BizContactEntranceView paramBizContactEntranceView) {}
  
  public final void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("intent_service_type", 251658241);
    d.b(paramView.getContext(), "brandservice", ".ui.BrandServiceIndexUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.BizContactEntranceView.1
 * JD-Core Version:    0.7.0.1
 */