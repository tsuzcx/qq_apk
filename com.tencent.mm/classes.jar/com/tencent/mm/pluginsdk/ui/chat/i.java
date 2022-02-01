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
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class i
{
  private h DyE;
  g DyF;
  o DyG;
  boolean DyH;
  h.a DyI;
  a DyJ;
  Bitmap bitmap;
  private View contentView;
  Context context;
  ImageView dkL;
  View fvu;
  SharedPreferences sp;
  View ubI;
  
  public i(Context paramContext, View paramView1, View paramView2, a parama)
  {
    AppMethodBeat.i(31756);
    this.contentView = null;
    this.dkL = null;
    this.bitmap = null;
    this.DyH = true;
    this.context = paramContext;
    this.fvu = paramView1;
    this.ubI = paramView2;
    this.DyE = new h(this.context);
    this.sp = paramContext.getSharedPreferences(ai.eUX(), 0);
    this.DyJ = parama;
    this.contentView = View.inflate(this.context, 2131493402, null);
    this.dkL = ((ImageView)this.contentView.findViewById(2131303810));
    this.DyG = new o(this.contentView, -2, -2, false);
    this.DyG.setBackgroundDrawable(new ColorDrawable(0));
    this.DyG.setOutsideTouchable(true);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31751);
        if ((i.this.DyJ != null) && (i.this.DyF != null)) {
          i.this.DyJ.aHx(i.this.DyF.DyC);
        }
        i.this.DyG.dismiss();
        AppMethodBeat.o(31751);
      }
    });
    AppMethodBeat.o(31756);
  }
  
  final float Xp(int paramInt)
  {
    AppMethodBeat.i(31759);
    float f = TypedValue.applyDimension(1, paramInt, this.context.getResources().getDisplayMetrics());
    AppMethodBeat.o(31759);
    return f;
  }
  
  public final void ePt()
  {
    AppMethodBeat.i(31757);
    final ao local2 = new ao(this.context.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(31752);
        paramAnonymousMessage = i.this;
        if ((paramAnonymousMessage.dkL == null) || (paramAnonymousMessage.DyF == null) || (paramAnonymousMessage.bitmap == null) || (paramAnonymousMessage.DyG == null) || (paramAnonymousMessage.fvu == null) || (paramAnonymousMessage.ubI == null))
        {
          AppMethodBeat.o(31752);
          return;
        }
        paramAnonymousMessage.dkL.setImageBitmap(paramAnonymousMessage.bitmap);
        int k;
        int j;
        label91:
        int i;
        label108:
        int n;
        int m;
        Rect localRect;
        if (paramAnonymousMessage.DyH)
        {
          k = 83;
          if (!paramAnonymousMessage.DyH) {
            break label273;
          }
          j = 0;
          if (paramAnonymousMessage.DyI == null) {
            break label279;
          }
          i = paramAnonymousMessage.DyI.getYFromBottom();
          n = j;
          m = i;
          if (Build.VERSION.SDK_INT >= 21)
          {
            localRect = aj.fhy();
            if (!paramAnonymousMessage.DyH) {
              break label290;
            }
            j = 0;
          }
        }
        for (;;)
        {
          m = i + localRect.bottom;
          ac.i("MicroMsg.RecentImageBubble", "recent bubble navbar height %s %s", new Object[] { Integer.valueOf(localRect.right), Integer.valueOf(localRect.bottom) });
          n = j;
          if (((paramAnonymousMessage.context instanceof Activity)) && (!((Activity)paramAnonymousMessage.context).isFinishing()) && (!((Activity)paramAnonymousMessage.context).isDestroyed())) {
            paramAnonymousMessage.DyG.showAtLocation(paramAnonymousMessage.fvu, k, n, m);
          }
          new au(new i.4(paramAnonymousMessage), false).au(10000L, 10000L);
          AppMethodBeat.o(31752);
          return;
          k = 85;
          break;
          label273:
          j = 10;
          break label91;
          label279:
          i = paramAnonymousMessage.ubI.getHeight();
          break label108;
          label290:
          j += localRect.right;
        }
      }
    };
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31753);
        i locali = i.this;
        Object localObject = locali.ePu();
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
          i = (int)locali.Xp(70);
          j = (int)locali.Xp(120);
          m = BackwardSupportUtil.ExifHelper.ce((String)localObject);
          if ((m != 90) && (m != 270)) {
            break label197;
          }
        }
        for (;;)
        {
          int k = (int)locali.Xp(4);
          localObject = f.e((String)localObject, i, j, true);
          if (localObject != null)
          {
            locali.bitmap = f.a(f.a((Bitmap)localObject, m), true, k);
            locali.sp.edit().putString("chattingui_recent_shown_image_path", locali.DyF.DyC).commit();
            ac.d("MicroMsg.RecentImageBubble", "check ok");
            i = 1;
            break;
          }
          ac.e("MicroMsg.RecentImageBubble", "image hits hole.");
          i = 0;
          break;
          ac.d("MicroMsg.RecentImageBubble", "check false");
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
  
  public final String ePu()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(31758);
        if (this.DyE == null)
        {
          ac.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
          localObject1 = null;
          this.DyF = ((g)localObject1);
          if (this.DyF == null)
          {
            AppMethodBeat.o(31758);
            localObject1 = null;
            return localObject1;
          }
        }
        else
        {
          localObject1 = this.DyE.ePs();
          if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
          {
            ac.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
            localObject1 = null;
            continue;
          }
          g localg = (g)((ArrayList)localObject1).get(0);
          if (localg != null)
          {
            if (bs.pN(localg.DyD) >= 0L) {
              break label304;
            }
            i = 1;
            if (i != 0)
            {
              ac.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", new Object[] { localg.DyC });
              localObject1 = null;
              continue;
            }
          }
          if ((localg != null) && (localg.DyC != null) && (localg.DyC.contains(b.aoX())))
          {
            localObject1 = null;
            continue;
          }
          if (localg != null)
          {
            if (bs.pN(localg.DyD) > 30L) {
              break label309;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = localg;
              if (!this.sp.getString("chattingui_recent_shown_image_path", "").equals(localg.DyC)) {
                continue;
              }
              ac.d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
              localObject1 = null;
              continue;
            }
          }
          if (localg != null) {
            break label314;
          }
          bool = true;
          ac.d("MicroMsg.RecentImageBubble", "because of checkAddDate(generateDate) == false, or imageItem == null : %s", new Object[] { Boolean.valueOf(bool) });
          localObject1 = null;
          continue;
        }
        Object localObject1 = this.DyF.thumbPath;
        if (this.DyF.thumbPath == null) {
          localObject1 = this.DyF.DyC;
        }
        AppMethodBeat.o(31758);
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
    public abstract void aHx(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.i
 * JD-Core Version:    0.7.0.1
 */