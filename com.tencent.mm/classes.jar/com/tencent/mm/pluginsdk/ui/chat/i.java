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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.v;
import java.util.ArrayList;

public final class i
{
  View KgR;
  private h Ykj;
  g Ykk;
  v Ykl;
  boolean Ykm;
  h.a Ykn;
  a Yko;
  Bitmap bitmap;
  private View contentView;
  Context context;
  ImageView hNV;
  View lBX;
  SharedPreferences sp;
  
  public i(Context paramContext, View paramView1, View paramView2, a parama)
  {
    AppMethodBeat.i(31756);
    this.contentView = null;
    this.hNV = null;
    this.bitmap = null;
    this.Ykm = true;
    this.context = paramContext;
    this.lBX = paramView1;
    this.KgR = paramView2;
    this.Ykj = new h(this.context);
    this.sp = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    this.Yko = parama;
    this.contentView = View.inflate(this.context, R.i.geZ, null);
    this.hNV = ((ImageView)this.contentView.findViewById(R.h.fUg));
    this.Ykl = new v(this.contentView, -2, -2, false);
    this.Ykl.setBackgroundDrawable(new ColorDrawable(0));
    this.Ykl.setOutsideTouchable(true);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31751);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/pluginsdk/ui/chat/RecentImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((i.this.Yko != null) && (i.this.Ykk != null)) {
          i.this.Yko.brj(i.this.Ykk.Ykh);
        }
        i.this.Ykl.dismiss();
        a.a(this, "com/tencent/mm/pluginsdk/ui/chat/RecentImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31751);
      }
    });
    AppMethodBeat.o(31756);
  }
  
  final float Ei(int paramInt)
  {
    AppMethodBeat.i(31759);
    float f = TypedValue.applyDimension(1, paramInt, this.context.getResources().getDisplayMetrics());
    AppMethodBeat.o(31759);
    return f;
  }
  
  public final void iNm()
  {
    AppMethodBeat.i(31757);
    if (!this.Ykn.iMJ())
    {
      Log.w("MicroMsg.RecentImageBubble", "[checkIfShow] is not support.");
      AppMethodBeat.o(31757);
      return;
    }
    final MMHandler local2 = new MMHandler(this.context.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(31752);
        paramAnonymousMessage = i.this;
        if (!paramAnonymousMessage.Ykn.iMJ())
        {
          Log.w("MicroMsg.RecentImageBubble", "[checkIfShow] is not support.");
          AppMethodBeat.o(31752);
          return;
        }
        if ((paramAnonymousMessage.hNV == null) || (paramAnonymousMessage.Ykk == null) || (paramAnonymousMessage.bitmap == null) || (paramAnonymousMessage.Ykl == null) || (paramAnonymousMessage.lBX == null) || (paramAnonymousMessage.KgR == null))
        {
          AppMethodBeat.o(31752);
          return;
        }
        paramAnonymousMessage.hNV.setImageBitmap(paramAnonymousMessage.bitmap);
        int k;
        if (paramAnonymousMessage.Ykm) {
          k = 83;
        }
        for (;;)
        {
          int j;
          label117:
          int i;
          label134:
          int n;
          int m;
          Rect localRect;
          if (paramAnonymousMessage.Ykm)
          {
            j = 0;
            if (paramAnonymousMessage.Ykn == null) {
              break label302;
            }
            i = paramAnonymousMessage.Ykn.getYFromBottom();
            n = j;
            m = i;
            if (Build.VERSION.SDK_INT >= 21)
            {
              localRect = aw.jkO();
              if (!paramAnonymousMessage.Ykm) {
                break label313;
              }
              j = 0;
              m = i + localRect.bottom;
              Log.i("MicroMsg.RecentImageBubble", "recent bubble navbar height %s %s", new Object[] { Integer.valueOf(localRect.right), Integer.valueOf(localRect.bottom) });
              n = j;
            }
            if ((!(paramAnonymousMessage.context instanceof Activity)) || (((Activity)paramAnonymousMessage.context).isFinishing()) || (((Activity)paramAnonymousMessage.context).isDestroyed())) {}
          }
          try
          {
            paramAnonymousMessage.Ykl.showAtLocation(paramAnonymousMessage.lBX, k, n, m);
            new MTimerHandler(new i.4(paramAnonymousMessage), false).startTimer(10000L);
            AppMethodBeat.o(31752);
            return;
            k = 85;
            continue;
            j = 10;
            break label117;
            label302:
            i = paramAnonymousMessage.KgR.getHeight();
            break label134;
            label313:
            j += localRect.right;
          }
          catch (NullPointerException localNullPointerException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.RecentImageBubble", localNullPointerException, "", new Object[0]);
            }
          }
        }
      }
    };
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31753);
        i locali = i.this;
        Object localObject = locali.iNn();
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
          i = (int)locali.Ei(70);
          j = (int)locali.Ei(120);
          m = BackwardSupportUtil.ExifHelper.getExifOrientation((String)localObject);
          if ((m != 90) && (m != 270)) {
            break label197;
          }
        }
        for (;;)
        {
          int k = (int)locali.Ei(4);
          localObject = BitmapUtil.extractThumbNail((String)localObject, i, j, true);
          if (localObject != null)
          {
            locali.bitmap = BitmapUtil.getRoundedCornerBitmap(BitmapUtil.rotate((Bitmap)localObject, m), true, k);
            locali.sp.edit().putString("chattingui_recent_shown_image_path", locali.Ykk.Ykh).commit();
            Log.d("MicroMsg.RecentImageBubble", "check ok");
            i = 1;
            break;
          }
          Log.e("MicroMsg.RecentImageBubble", "image hits hole.");
          i = 0;
          break;
          Log.d("MicroMsg.RecentImageBubble", "check false");
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
  
  public final String iNn()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(31758);
        if (this.Ykj == null)
        {
          Log.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
          localObject1 = null;
          this.Ykk = ((g)localObject1);
          if (this.Ykk == null)
          {
            AppMethodBeat.o(31758);
            localObject1 = null;
            return localObject1;
          }
        }
        else
        {
          localObject1 = this.Ykj.iNl();
          if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
          {
            Log.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
            localObject1 = null;
            continue;
          }
          g localg = (g)((ArrayList)localObject1).get(0);
          if (localg != null)
          {
            if (Util.secondsToNow(localg.Yki) >= 0L) {
              break label308;
            }
            i = 1;
            if (i != 0)
            {
              Log.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", new Object[] { localg.Ykh });
              localObject1 = null;
              continue;
            }
          }
          if ((localg != null) && (localg.Ykh != null) && (localg.Ykh.contains(com.tencent.mm.loader.i.b.bmp())))
          {
            localObject1 = null;
            continue;
          }
          if (localg != null)
          {
            if (Util.secondsToNow(localg.Yki) > 30L) {
              break label313;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = localg;
              if (!this.sp.getString("chattingui_recent_shown_image_path", "").equals(localg.Ykh)) {
                continue;
              }
              Log.d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
              localObject1 = null;
              continue;
            }
          }
          if (localg != null) {
            break label318;
          }
          bool = true;
          Log.d("MicroMsg.RecentImageBubble", "because of checkAddDate(generateDate) == false, or imageItem == null : %s", new Object[] { Boolean.valueOf(bool) });
          localObject1 = null;
          continue;
        }
        Object localObject1 = this.Ykk.thumbPath;
        if (this.Ykk.thumbPath == null) {
          localObject1 = this.Ykk.Ykh;
        }
        AppMethodBeat.o(31758);
        continue;
        i = 0;
      }
      finally {}
      label308:
      continue;
      label313:
      int i = 0;
      continue;
      label318:
      boolean bool = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void brj(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.i
 * JD-Core Version:    0.7.0.1
 */