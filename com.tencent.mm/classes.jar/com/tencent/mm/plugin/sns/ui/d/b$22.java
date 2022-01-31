package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

final class b$22
  implements View.OnClickListener
{
  b$22(b paramb) {}
  
  public final void onClick(View paramView)
  {
    q localq;
    Object localObject1;
    String str1;
    Object localObject2;
    String str2;
    int i;
    if ((paramView.getTag() instanceof q))
    {
      localq = (q)paramView.getTag();
      localObject1 = (awd)localq.oOz.tNr.sPJ.get(0);
      str1 = localq.bJQ;
      af.bDF().OA(str1);
      str1 = "";
      localObject2 = an.eJ(af.getAccSnsPath(), ((awd)localObject1).lsK);
      str2 = "";
      String str3 = i.j((awd)localObject1);
      if (e.bK((String)localObject2 + str3))
      {
        str1 = (String)localObject2 + str3;
        str2 = (String)localObject2 + i.e((awd)localObject1);
      }
      if (e.bK((String)localObject2 + i.p((awd)localObject1)))
      {
        str1 = (String)localObject2 + i.p((awd)localObject1);
        str2 = (String)localObject2 + i.n((awd)localObject1);
      }
      localObject1 = new int[2];
      localObject2 = paramView.findViewById(i.f.content_preview);
      if (localObject2 == null) {
        break label421;
      }
      ((View)localObject2).getLocationInWindow((int[])localObject1);
      i = ((View)localObject2).getWidth();
    }
    for (int j = ((View)localObject2).getHeight();; j = paramView.getHeight())
    {
      paramView = new Intent();
      paramView.setClass(this.ppl.activity, SnsOnlineVideoActivity.class);
      paramView.putExtra("intent_videopath", str1);
      paramView.putExtra("intent_thumbpath", str2);
      paramView.putExtra("intent_localid", localq.bJQ);
      paramView.putExtra("intent_isad", false);
      paramView.putExtra("intent_from_scene", this.ppl.source);
      paramView.putExtra("img_gallery_left", localObject1[0]);
      paramView.putExtra("img_gallery_top", localObject1[1]);
      paramView.putExtra("img_gallery_width", i);
      paramView.putExtra("img_gallery_height", j);
      this.ppl.activity.startActivity(paramView);
      this.ppl.activity.overridePendingTransition(0, 0);
      b.a(this.ppl, localq.oOz);
      return;
      label421:
      paramView.getLocationInWindow((int[])localObject1);
      i = paramView.getWidth();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.22
 * JD-Core Version:    0.7.0.1
 */