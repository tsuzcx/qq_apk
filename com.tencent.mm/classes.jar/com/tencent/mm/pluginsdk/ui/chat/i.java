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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class i
{
  private h Cgn;
  g Cgo;
  o Cgp;
  boolean Cgq;
  h.a Cgr;
  a Cgs;
  Bitmap bitmap;
  private View contentView;
  Context context;
  ImageView dnd;
  View frN;
  View sTw;
  SharedPreferences sp;
  
  public i(Context paramContext, View paramView1, View paramView2, a parama)
  {
    AppMethodBeat.i(31756);
    this.contentView = null;
    this.dnd = null;
    this.bitmap = null;
    this.Cgq = true;
    this.context = paramContext;
    this.frN = paramView1;
    this.sTw = paramView2;
    this.Cgn = new h(this.context);
    this.sp = paramContext.getSharedPreferences(aj.eFD(), 0);
    this.Cgs = parama;
    this.contentView = View.inflate(this.context, 2131493402, null);
    this.dnd = ((ImageView)this.contentView.findViewById(2131303810));
    this.Cgp = new o(this.contentView, -2, -2, false);
    this.Cgp.setBackgroundDrawable(new ColorDrawable(0));
    this.Cgp.setOutsideTouchable(true);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31751);
        if ((i.this.Cgs != null) && (i.this.Cgo != null)) {
          i.this.Cgs.aCf(i.this.Cgo.Cgl);
        }
        i.this.Cgp.dismiss();
        AppMethodBeat.o(31751);
      }
    });
    AppMethodBeat.o(31756);
  }
  
  final float Vg(int paramInt)
  {
    AppMethodBeat.i(31759);
    float f = TypedValue.applyDimension(1, paramInt, this.context.getResources().getDisplayMetrics());
    AppMethodBeat.o(31759);
    return f;
  }
  
  public final String eAa()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(31758);
        if (this.Cgn == null)
        {
          ad.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
          localObject1 = null;
          this.Cgo = ((g)localObject1);
          if (this.Cgo == null)
          {
            AppMethodBeat.o(31758);
            localObject1 = null;
            return localObject1;
          }
        }
        else
        {
          localObject1 = this.Cgn.ezY();
          if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
          {
            ad.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
            localObject1 = null;
            continue;
          }
          g localg = (g)((ArrayList)localObject1).get(0);
          if (localg != null)
          {
            if (bt.lZ(localg.Cgm) >= 0L) {
              break label304;
            }
            i = 1;
            if (i != 0)
            {
              ad.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", new Object[] { localg.Cgl });
              localObject1 = null;
              continue;
            }
          }
          if ((localg != null) && (localg.Cgl != null) && (localg.Cgl.contains(b.ahX())))
          {
            localObject1 = null;
            continue;
          }
          if (localg != null)
          {
            if (bt.lZ(localg.Cgm) > 30L) {
              break label309;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = localg;
              if (!this.sp.getString("chattingui_recent_shown_image_path", "").equals(localg.Cgl)) {
                continue;
              }
              ad.d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
              localObject1 = null;
              continue;
            }
          }
          if (localg != null) {
            break label314;
          }
          bool = true;
          ad.d("MicroMsg.RecentImageBubble", "because of checkAddDate(generateDate) == false, or imageItem == null : %s", new Object[] { Boolean.valueOf(bool) });
          localObject1 = null;
          continue;
        }
        Object localObject1 = this.Cgo.thumbPath;
        if (this.Cgo.thumbPath == null) {
          localObject1 = this.Cgo.Cgl;
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
  
  public final void ezZ()
  {
    AppMethodBeat.i(31757);
    final ap local2 = new ap(this.context.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(31752);
        paramAnonymousMessage = i.this;
        if ((paramAnonymousMessage.dnd == null) || (paramAnonymousMessage.Cgo == null) || (paramAnonymousMessage.bitmap == null) || (paramAnonymousMessage.Cgp == null) || (paramAnonymousMessage.frN == null) || (paramAnonymousMessage.sTw == null))
        {
          AppMethodBeat.o(31752);
          return;
        }
        paramAnonymousMessage.dnd.setImageBitmap(paramAnonymousMessage.bitmap);
        int k;
        int j;
        label91:
        int i;
        label108:
        int n;
        int m;
        Rect localRect;
        if (paramAnonymousMessage.Cgq)
        {
          k = 83;
          if (!paramAnonymousMessage.Cgq) {
            break label273;
          }
          j = 0;
          if (paramAnonymousMessage.Cgr == null) {
            break label279;
          }
          i = paramAnonymousMessage.Cgr.getYFromBottom();
          n = j;
          m = i;
          if (Build.VERSION.SDK_INT >= 21)
          {
            localRect = ai.eRO();
            if (!paramAnonymousMessage.Cgq) {
              break label290;
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
            paramAnonymousMessage.Cgp.showAtLocation(paramAnonymousMessage.frN, k, n, m);
          }
          new av(new i.4(paramAnonymousMessage), false).av(10000L, 10000L);
          AppMethodBeat.o(31752);
          return;
          k = 85;
          break;
          label273:
          j = 10;
          break label91;
          label279:
          i = paramAnonymousMessage.sTw.getHeight();
          break label108;
          label290:
          j += localRect.right;
        }
      }
    };
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31753);
        i locali = i.this;
        Object localObject = locali.eAa();
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
          i = (int)locali.Vg(70);
          j = (int)locali.Vg(120);
          m = BackwardSupportUtil.ExifHelper.co((String)localObject);
          if ((m != 90) && (m != 270)) {
            break label197;
          }
        }
        for (;;)
        {
          int k = (int)locali.Vg(4);
          localObject = f.e((String)localObject, i, j, true);
          if (localObject != null)
          {
            locali.bitmap = f.a(f.a((Bitmap)localObject, m), true, k);
            locali.sp.edit().putString("chattingui_recent_shown_image_path", locali.Cgo.Cgl).commit();
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
  
  public static abstract interface a
  {
    public abstract void aCf(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.i
 * JD-Core Version:    0.7.0.1
 */