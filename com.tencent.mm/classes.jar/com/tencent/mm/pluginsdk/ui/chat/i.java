package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class i
{
  Bitmap bitmap;
  private View contentView;
  private Context context;
  ImageView cxy;
  View kgr;
  View oeJ;
  SharedPreferences sp;
  private h vYN;
  g vYO;
  o vYP;
  boolean vYQ;
  h.a vYR;
  a vYS;
  
  public i(Context paramContext, View paramView1, View paramView2, a parama)
  {
    AppMethodBeat.i(27960);
    this.contentView = null;
    this.cxy = null;
    this.bitmap = null;
    this.vYQ = true;
    this.context = paramContext;
    this.kgr = paramView1;
    this.oeJ = paramView2;
    this.vYN = new h(this.context);
    this.sp = paramContext.getSharedPreferences(ah.dsP(), 0);
    this.vYS = parama;
    this.contentView = View.inflate(this.context, 2130969040, null);
    this.cxy = ((ImageView)this.contentView.findViewById(2131822502));
    this.vYP = new o(this.contentView, -2, -2, true);
    this.vYP.setBackgroundDrawable(new ColorDrawable(0));
    this.vYP.setOutsideTouchable(true);
    this.contentView.setOnClickListener(new i.1(this));
    AppMethodBeat.o(27960);
  }
  
  final float Mm(int paramInt)
  {
    AppMethodBeat.i(27963);
    float f = TypedValue.applyDimension(1, paramInt, this.context.getResources().getDisplayMetrics());
    AppMethodBeat.o(27963);
    return f;
  }
  
  public final void doU()
  {
    AppMethodBeat.i(27961);
    i.2 local2 = new i.2(this, this.context.getMainLooper());
    aw.RO().ac(new i.3(this, local2));
    AppMethodBeat.o(27961);
  }
  
  public final String doV()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(27962);
        if (this.vYN == null)
        {
          ab.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
          localObject1 = null;
          this.vYO = ((g)localObject1);
          if (this.vYO == null)
          {
            AppMethodBeat.o(27962);
            localObject1 = null;
            return localObject1;
          }
        }
        else
        {
          localObject1 = this.vYN.doT();
          if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
          {
            ab.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
            localObject1 = null;
            continue;
          }
          g localg = (g)((ArrayList)localObject1).get(0);
          if (localg != null)
          {
            if (bo.gz(localg.vYM) >= 0L) {
              break label304;
            }
            i = 1;
            if (i != 0)
            {
              ab.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", new Object[] { localg.vYL });
              localObject1 = null;
              continue;
            }
          }
          if ((localg != null) && (localg.vYL != null) && (localg.vYL.contains(e.eQy)))
          {
            localObject1 = null;
            continue;
          }
          if (localg != null)
          {
            if (bo.gz(localg.vYM) > 30L) {
              break label309;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = localg;
              if (!this.sp.getString("chattingui_recent_shown_image_path", "").equals(localg.vYL)) {
                continue;
              }
              ab.d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
              localObject1 = null;
              continue;
            }
          }
          if (localg != null) {
            break label314;
          }
          bool = true;
          ab.d("MicroMsg.RecentImageBubble", "because of checkAddDate(generateDate) == false, or imageItem == null : %s", new Object[] { Boolean.valueOf(bool) });
          localObject1 = null;
          continue;
        }
        Object localObject1 = this.vYO.thumbPath;
        if (this.vYO.thumbPath == null) {
          localObject1 = this.vYO.vYL;
        }
        AppMethodBeat.o(27962);
        continue;
        i = 0;
      }
      finally {}
      label304:
      continue;
      label309:
      int i = 0;
      continue;
      label314:
      boolean bool = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void ams(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.i
 * JD-Core Version:    0.7.0.1
 */