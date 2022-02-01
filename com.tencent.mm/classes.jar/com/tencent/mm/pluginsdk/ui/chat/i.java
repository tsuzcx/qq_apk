package com.tencent.mm.pluginsdk.ui.chat;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class i
{
  private h FdN;
  g FdO;
  o FdP;
  boolean FdQ;
  h.a FdR;
  a FdS;
  Bitmap bitmap;
  private View contentView;
  Context context;
  ImageView dwy;
  View fOB;
  SharedPreferences sp;
  View ves;
  
  public i(Context paramContext, View paramView1, View paramView2, a parama)
  {
    AppMethodBeat.i(31756);
    this.contentView = null;
    this.dwy = null;
    this.bitmap = null;
    this.FdQ = true;
    this.context = paramContext;
    this.fOB = paramView1;
    this.ves = paramView2;
    this.FdN = new h(this.context);
    this.sp = paramContext.getSharedPreferences(aj.fkC(), 0);
    this.FdS = parama;
    this.contentView = View.inflate(this.context, 2131493402, null);
    this.dwy = ((ImageView)this.contentView.findViewById(2131303810));
    this.FdP = new o(this.contentView, -2, -2, false);
    this.FdP.setBackgroundDrawable(new ColorDrawable(0));
    this.FdP.setOutsideTouchable(true);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31751);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/chat/RecentImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((i.this.FdS != null) && (i.this.FdO != null)) {
          i.this.FdS.aNa(i.this.FdO.FdL);
        }
        i.this.FdP.dismiss();
        a.a(this, "com/tencent/mm/pluginsdk/ui/chat/RecentImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31751);
      }
    });
    AppMethodBeat.o(31756);
  }
  
  final float Zl(int paramInt)
  {
    AppMethodBeat.i(31759);
    float f = TypedValue.applyDimension(1, paramInt, this.context.getResources().getDisplayMetrics());
    AppMethodBeat.o(31759);
    return f;
  }
  
  public final void fev()
  {
    AppMethodBeat.i(31757);
    if (!this.FdR.fdU())
    {
      ad.w("MicroMsg.RecentImageBubble", "[checkIfShow] is not support.");
      AppMethodBeat.o(31757);
      return;
    }
    final ap local2 = new ap(this.context.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(31752);
        paramAnonymousMessage = i.this;
        if (!paramAnonymousMessage.FdR.fdU())
        {
          ad.w("MicroMsg.RecentImageBubble", "[checkIfShow] is not support.");
          AppMethodBeat.o(31752);
          return;
        }
        if ((paramAnonymousMessage.dwy == null) || (paramAnonymousMessage.FdO == null) || (paramAnonymousMessage.bitmap == null) || (paramAnonymousMessage.FdP == null) || (paramAnonymousMessage.fOB == null) || (paramAnonymousMessage.ves == null))
        {
          AppMethodBeat.o(31752);
          return;
        }
        paramAnonymousMessage.dwy.setImageBitmap(paramAnonymousMessage.bitmap);
        int k;
        int j;
        label117:
        int i;
        label134:
        int n;
        int m;
        Rect localRect;
        if (paramAnonymousMessage.FdQ)
        {
          k = 83;
          if (!paramAnonymousMessage.FdQ) {
            break label299;
          }
          j = 0;
          if (paramAnonymousMessage.FdR == null) {
            break label305;
          }
          i = paramAnonymousMessage.FdR.getYFromBottom();
          n = j;
          m = i;
          if (Build.VERSION.SDK_INT >= 21)
          {
            localRect = al.fxL();
            if (!paramAnonymousMessage.FdQ) {
              break label316;
            }
            j = 0;
          }
        }
        for (;;)
        {
          m = i + localRect.bottom;
          ad.i("MicroMsg.RecentImageBubble", "recent bubble navbar height %s %s", new Object[] { Integer.valueOf(localRect.right), Integer.valueOf(localRect.bottom) });
          n = j;
          if (((paramAnonymousMessage.context instanceof Activity)) && (!((Activity)paramAnonymousMessage.context).isFinishing()) && (!((Activity)paramAnonymousMessage.context).isDestroyed())) {
            paramAnonymousMessage.FdP.showAtLocation(paramAnonymousMessage.fOB, k, n, m);
          }
          new av(new i.4(paramAnonymousMessage), false).az(10000L, 10000L);
          AppMethodBeat.o(31752);
          return;
          k = 85;
          break;
          label299:
          j = 10;
          break label117;
          label305:
          i = paramAnonymousMessage.ves.getHeight();
          break label134;
          label316:
          j += localRect.right;
        }
      }
    };
    ba.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31753);
        i locali = i.this;
        Object localObject = locali.few();
        int i;
        int j;
        int m;
        if (localObject == null)
        {
          i = 0;
          if (i != 0)
          {
            local2.sendEmptyMessage(0);
            AppMethodBeat.o(31753);
          }
        }
        else
        {
          i = (int)locali.Zl(70);
          j = (int)locali.Zl(120);
          m = BackwardSupportUtil.ExifHelper.cY((String)localObject);
          if ((m != 90) && (m != 270)) {
            break label197;
          }
        }
        for (;;)
        {
          int k = (int)locali.Zl(4);
          localObject = com.tencent.mm.sdk.platformtools.g.d((String)localObject, i, j, true);
          if (localObject != null)
          {
            locali.bitmap = com.tencent.mm.sdk.platformtools.g.a(com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject, m), true, k);
            locali.sp.edit().putString("chattingui_recent_shown_image_path", locali.FdO.FdL).commit();
            ad.d("MicroMsg.RecentImageBubble", "check ok");
            i = 1;
            break;
          }
          ad.e("MicroMsg.RecentImageBubble", "image hits hole.");
          i = 0;
          break;
          ad.d("MicroMsg.RecentImageBubble", "check false");
          AppMethodBeat.o(31753);
          return;
          label197:
          k = i;
          i = j;
          j = k;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(31754);
        String str = super.toString() + "|checkIfShow";
        AppMethodBeat.o(31754);
        return str;
      }
    });
    AppMethodBeat.o(31757);
  }
  
  public final String few()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(31758);
        if (this.FdN == null)
        {
          ad.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
          localObject1 = null;
          this.FdO = ((g)localObject1);
          if (this.FdO == null)
          {
            AppMethodBeat.o(31758);
            localObject1 = null;
            return localObject1;
          }
        }
        else
        {
          localObject1 = this.FdN.feu();
          if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
          {
            ad.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
            localObject1 = null;
            continue;
          }
          g localg = (g)((ArrayList)localObject1).get(0);
          if (localg != null)
          {
            if (bt.rM(localg.FdM) >= 0L) {
              break label306;
            }
            i = 1;
            if (i != 0)
            {
              ad.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", new Object[] { localg.FdL });
              localObject1 = null;
              continue;
            }
          }
          if ((localg != null) && (localg.FdL != null) && (localg.FdL.contains(com.tencent.mm.loader.j.b.arK())))
          {
            localObject1 = null;
            continue;
          }
          if (localg != null)
          {
            if (bt.rM(localg.FdM) > 30L) {
              break label311;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = localg;
              if (!this.sp.getString("chattingui_recent_shown_image_path", "").equals(localg.FdL)) {
                continue;
              }
              ad.d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
              localObject1 = null;
              continue;
            }
          }
          if (localg != null) {
            break label316;
          }
          bool = true;
          ad.d("MicroMsg.RecentImageBubble", "because of checkAddDate(generateDate) == false, or imageItem == null : %s", new Object[] { Boolean.valueOf(bool) });
          localObject1 = null;
          continue;
        }
        Object localObject1 = this.FdO.thumbPath;
        if (this.FdO.thumbPath == null) {
          localObject1 = this.FdO.FdL;
        }
        AppMethodBeat.o(31758);
        continue;
        i = 0;
      }
      finally {}
      label306:
      continue;
      label311:
      int i = 0;
      continue;
      label316:
      boolean bool = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aNa(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.i
 * JD-Core Version:    0.7.0.1
 */