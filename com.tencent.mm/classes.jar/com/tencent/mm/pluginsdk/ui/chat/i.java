package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class i
{
  ImageView bQf = null;
  Bitmap bitmap = null;
  private View contentView = null;
  Context context;
  SharedPreferences dnD;
  View khn;
  View lHw;
  i.a sgA;
  private h sgv;
  g sgw;
  o sgx;
  boolean sgy = true;
  h.a sgz;
  
  public i(Context paramContext, View paramView1, View paramView2, i.a parama)
  {
    this.context = paramContext;
    this.khn = paramView1;
    this.lHw = paramView2;
    this.sgv = new h(this.context);
    this.dnD = paramContext.getSharedPreferences(ae.cqR(), 0);
    this.sgA = parama;
    this.contentView = View.inflate(this.context, R.i.chatting_footer_recent_image_bubble, null);
    this.bQf = ((ImageView)this.contentView.findViewById(R.h.recent_image_iv));
    this.sgx = new o(this.contentView, -2, -2, true);
    this.sgx.setBackgroundDrawable(new ColorDrawable(0));
    this.sgx.setOutsideTouchable(true);
    this.contentView.setOnClickListener(new i.1(this));
  }
  
  final float Eo(int paramInt)
  {
    return TypedValue.applyDimension(1, paramInt, this.context.getResources().getDisplayMetrics());
  }
  
  public final String cnN()
  {
    for (;;)
    {
      try
      {
        if (this.sgv == null)
        {
          y.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
          localObject1 = null;
          this.sgw = ((g)localObject1);
          localObject1 = this.sgw;
          if (localObject1 == null)
          {
            localObject1 = null;
            return localObject1;
          }
        }
        else
        {
          localObject1 = this.sgv.cnM();
          if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
          {
            y.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
            localObject1 = null;
            continue;
          }
          g localg = (g)((ArrayList)localObject1).get(0);
          if (localg != null)
          {
            if (bk.cn(localg.kGY) >= 0L) {
              break label288;
            }
            i = 1;
            if (i != 0)
            {
              y.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", new Object[] { localg.sgu });
              localObject1 = null;
              continue;
            }
          }
          if ((localg != null) && (localg.sgu != null) && (localg.sgu.contains(e.bkG)))
          {
            localObject1 = null;
            continue;
          }
          if (localg != null)
          {
            if (bk.cn(localg.kGY) > 30L) {
              break label293;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = localg;
              if (!this.dnD.getString("chattingui_recent_shown_image_path", "").equals(localg.sgu)) {
                continue;
              }
              y.d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
              localObject1 = null;
              continue;
            }
          }
          if (localg != null) {
            break label298;
          }
          bool = true;
          y.d("MicroMsg.RecentImageBubble", "because of checkAddDate(addDate) == false, or imageItem == null : %s", new Object[] { Boolean.valueOf(bool) });
          localObject1 = null;
          continue;
        }
        Object localObject1 = this.sgw.thumbPath;
        if (this.sgw.thumbPath != null) {
          continue;
        }
        localObject1 = this.sgw.sgu;
        continue;
        i = 0;
      }
      finally {}
      label288:
      continue;
      label293:
      int i = 0;
      continue;
      label298:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.i
 * JD-Core Version:    0.7.0.1
 */