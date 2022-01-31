package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.ui.RecordMsgImageUI;
import com.tencent.mm.protocal.c.xv;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = (com.tencent.mm.plugin.record.ui.a.b)paramView.getTag();
    switch (((com.tencent.mm.plugin.record.ui.a.b)localObject).aYU)
    {
    default: 
      return;
    case 0: 
      localIntent = new Intent(paramView.getContext(), RecordMsgImageUI.class);
      localIntent.putExtra("message_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject).bIt);
      localIntent.putExtra("record_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject).bNt.kgC);
      localIntent.putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject).bWL);
      if (((paramView.getContext() instanceof Activity)) && (((Activity)paramView.getContext()).getIntent() != null))
      {
        localObject = ((Activity)paramView.getContext()).getIntent().getBundleExtra("_stat_obj");
        if (localObject != null) {
          localIntent.putExtra("_stat_obj", (Bundle)localObject);
        }
      }
      paramView.getContext().startActivity(localIntent);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject).khA.field_localId);
    localIntent.putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject).bNt.kgC);
    com.tencent.mm.plugin.fav.a.b.b(paramView.getContext(), ".ui.FavImgGalleryUI", localIntent, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a.1
 * JD-Core Version:    0.7.0.1
 */