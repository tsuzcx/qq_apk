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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.r;
import java.util.ArrayList;

public final class i
{
  View Eol;
  private h RnS;
  g RnT;
  r RnU;
  boolean RnV;
  h.a RnW;
  a RnX;
  Bitmap bitmap;
  private View contentView;
  Context context;
  ImageView fIv;
  View jac;
  SharedPreferences sp;
  
  public i(Context paramContext, View paramView1, View paramView2, a parama)
  {
    AppMethodBeat.i(31756);
    this.contentView = null;
    this.fIv = null;
    this.bitmap = null;
    this.RnV = true;
    this.context = paramContext;
    this.jac = paramView1;
    this.Eol = paramView2;
    this.RnS = new h(this.context);
    this.sp = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    this.RnX = parama;
    this.contentView = View.inflate(this.context, R.i.ecr, null);
    this.fIv = ((ImageView)this.contentView.findViewById(R.h.dSg));
    this.RnU = new r(this.contentView, -2, -2, false);
    this.RnU.setBackgroundDrawable(new ColorDrawable(0));
    this.RnU.setOutsideTouchable(true);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31751);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/pluginsdk/ui/chat/RecentImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((i.this.RnX != null) && (i.this.RnT != null)) {
          i.this.RnX.brv(i.this.RnT.RnQ);
        }
        i.this.RnU.dismiss();
        a.a(this, "com/tencent/mm/pluginsdk/ui/chat/RecentImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31751);
      }
    });
    AppMethodBeat.o(31756);
  }
  
  final float DI(int paramInt)
  {
    AppMethodBeat.i(31759);
    float f = TypedValue.applyDimension(1, paramInt, this.context.getResources().getDisplayMetrics());
    AppMethodBeat.o(31759);
    return f;
  }
  
  public final void hmw()
  {
    AppMethodBeat.i(31757);
    if (!this.RnW.hlS())
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
        if (!paramAnonymousMessage.RnW.hlS())
        {
          Log.w("MicroMsg.RecentImageBubble", "[checkIfShow] is not support.");
          AppMethodBeat.o(31752);
          return;
        }
        if ((paramAnonymousMessage.fIv == null) || (paramAnonymousMessage.RnT == null) || (paramAnonymousMessage.bitmap == null) || (paramAnonymousMessage.RnU == null) || (paramAnonymousMessage.jac == null) || (paramAnonymousMessage.Eol == null))
        {
          AppMethodBeat.o(31752);
          return;
        }
        paramAnonymousMessage.fIv.setImageBitmap(paramAnonymousMessage.bitmap);
        int k;
        if (paramAnonymousMessage.RnV) {
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
          if (paramAnonymousMessage.RnV)
          {
            j = 0;
            if (paramAnonymousMessage.RnW == null) {
              break label302;
            }
            i = paramAnonymousMessage.RnW.getYFromBottom();
            n = j;
            m = i;
            if (Build.VERSION.SDK_INT >= 21)
            {
              localRect = ar.hID();
              if (!paramAnonymousMessage.RnV) {
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
            paramAnonymousMessage.RnU.showAtLocation(paramAnonymousMessage.jac, k, n, m);
            new MTimerHandler(new i.4(paramAnonymousMessage), false).startTimer(10000L);
            AppMethodBeat.o(31752);
            return;
            k = 85;
            continue;
            j = 10;
            break label117;
            label302:
            i = paramAnonymousMessage.Eol.getHeight();
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
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31753);
        i locali = i.this;
        Object localObject = locali.hmx();
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
          i = (int)locali.DI(70);
          j = (int)locali.DI(120);
          m = BackwardSupportUtil.ExifHelper.getExifOrientation((String)localObject);
          if ((m != 90) && (m != 270)) {
            break label197;
          }
        }
        for (;;)
        {
          int k = (int)locali.DI(4);
          localObject = BitmapUtil.extractThumbNail((String)localObject, i, j, true);
          if (localObject != null)
          {
            locali.bitmap = BitmapUtil.getRoundedCornerBitmap(BitmapUtil.rotate((Bitmap)localObject, m), true, k);
            locali.sp.edit().putString("chattingui_recent_shown_image_path", locali.RnT.RnQ).commit();
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
  
  public final String hmx()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(31758);
        if (this.RnS == null)
        {
          Log.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
          localObject1 = null;
          this.RnT = ((g)localObject1);
          if (this.RnT == null)
          {
            AppMethodBeat.o(31758);
            localObject1 = null;
            return localObject1;
          }
        }
        else
        {
          localObject1 = this.RnS.hmv();
          if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
          {
            Log.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
            localObject1 = null;
            continue;
          }
          g localg = (g)((ArrayList)localObject1).get(0);
          if (localg != null)
          {
            if (Util.secondsToNow(localg.RnR) >= 0L) {
              break label308;
            }
            i = 1;
            if (i != 0)
            {
              Log.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", new Object[] { localg.RnQ });
              localObject1 = null;
              continue;
            }
          }
          if ((localg != null) && (localg.RnQ != null) && (localg.RnQ.contains(com.tencent.mm.loader.j.b.aSB())))
          {
            localObject1 = null;
            continue;
          }
          if (localg != null)
          {
            if (Util.secondsToNow(localg.RnR) > 30L) {
              break label313;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = localg;
              if (!this.sp.getString("chattingui_recent_shown_image_path", "").equals(localg.RnQ)) {
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
        Object localObject1 = this.RnT.thumbPath;
        if (this.RnT.thumbPath == null) {
          localObject1 = this.RnT.RnQ;
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
    public abstract void brv(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.i
 * JD-Core Version:    0.7.0.1
 */