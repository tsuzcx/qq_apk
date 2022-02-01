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
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class i
{
  private h Fwl;
  g Fwm;
  o Fwn;
  boolean Fwo;
  h.a Fwp;
  a Fwq;
  Bitmap bitmap;
  private View contentView;
  Context context;
  ImageView dxD;
  View fQH;
  SharedPreferences sp;
  View vqC;
  
  public i(Context paramContext, View paramView1, View paramView2, a parama)
  {
    AppMethodBeat.i(31756);
    this.contentView = null;
    this.dxD = null;
    this.bitmap = null;
    this.Fwo = true;
    this.context = paramContext;
    this.fQH = paramView1;
    this.vqC = paramView2;
    this.Fwl = new h(this.context);
    this.sp = paramContext.getSharedPreferences(ak.fow(), 0);
    this.Fwq = parama;
    this.contentView = View.inflate(this.context, 2131493402, null);
    this.dxD = ((ImageView)this.contentView.findViewById(2131303810));
    this.Fwn = new o(this.contentView, -2, -2, false);
    this.Fwn.setBackgroundDrawable(new ColorDrawable(0));
    this.Fwn.setOutsideTouchable(true);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31751);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/pluginsdk/ui/chat/RecentImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((i.this.Fwq != null) && (i.this.Fwm != null)) {
          i.this.Fwq.aOx(i.this.Fwm.Fwj);
        }
        i.this.Fwn.dismiss();
        a.a(this, "com/tencent/mm/pluginsdk/ui/chat/RecentImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31751);
      }
    });
    AppMethodBeat.o(31756);
  }
  
  final float ZR(int paramInt)
  {
    AppMethodBeat.i(31759);
    float f = TypedValue.applyDimension(1, paramInt, this.context.getResources().getDisplayMetrics());
    AppMethodBeat.o(31759);
    return f;
  }
  
  public final void fil()
  {
    AppMethodBeat.i(31757);
    if (!this.Fwp.fhJ())
    {
      ae.w("MicroMsg.RecentImageBubble", "[checkIfShow] is not support.");
      AppMethodBeat.o(31757);
      return;
    }
    final aq local2 = new aq(this.context.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(31752);
        paramAnonymousMessage = i.this;
        if (!paramAnonymousMessage.Fwp.fhJ())
        {
          ae.w("MicroMsg.RecentImageBubble", "[checkIfShow] is not support.");
          AppMethodBeat.o(31752);
          return;
        }
        if ((paramAnonymousMessage.dxD == null) || (paramAnonymousMessage.Fwm == null) || (paramAnonymousMessage.bitmap == null) || (paramAnonymousMessage.Fwn == null) || (paramAnonymousMessage.fQH == null) || (paramAnonymousMessage.vqC == null))
        {
          AppMethodBeat.o(31752);
          return;
        }
        paramAnonymousMessage.dxD.setImageBitmap(paramAnonymousMessage.bitmap);
        int k;
        if (paramAnonymousMessage.Fwo) {
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
          if (paramAnonymousMessage.Fwo)
          {
            j = 0;
            if (paramAnonymousMessage.Fwp == null) {
              break label305;
            }
            i = paramAnonymousMessage.Fwp.getYFromBottom();
            n = j;
            m = i;
            if (Build.VERSION.SDK_INT >= 21)
            {
              localRect = al.fBN();
              if (!paramAnonymousMessage.Fwo) {
                break label316;
              }
              j = 0;
              m = i + localRect.bottom;
              ae.i("MicroMsg.RecentImageBubble", "recent bubble navbar height %s %s", new Object[] { Integer.valueOf(localRect.right), Integer.valueOf(localRect.bottom) });
              n = j;
            }
            if ((!(paramAnonymousMessage.context instanceof Activity)) || (((Activity)paramAnonymousMessage.context).isFinishing()) || (((Activity)paramAnonymousMessage.context).isDestroyed())) {}
          }
          try
          {
            paramAnonymousMessage.Fwn.showAtLocation(paramAnonymousMessage.fQH, k, n, m);
            new aw(new i.4(paramAnonymousMessage), false).ay(10000L, 10000L);
            AppMethodBeat.o(31752);
            return;
            k = 85;
            continue;
            j = 10;
            break label117;
            label305:
            i = paramAnonymousMessage.vqC.getHeight();
            break label134;
            label316:
            j += localRect.right;
          }
          catch (NullPointerException localNullPointerException)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.RecentImageBubble", localNullPointerException, "", new Object[0]);
            }
          }
        }
      }
    };
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31753);
        i locali = i.this;
        Object localObject = locali.fim();
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
          i = (int)locali.ZR(70);
          j = (int)locali.ZR(120);
          m = BackwardSupportUtil.ExifHelper.df((String)localObject);
          if ((m != 90) && (m != 270)) {
            break label197;
          }
        }
        for (;;)
        {
          int k = (int)locali.ZR(4);
          localObject = com.tencent.mm.sdk.platformtools.h.d((String)localObject, i, j, true);
          if (localObject != null)
          {
            locali.bitmap = com.tencent.mm.sdk.platformtools.h.a(com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject, m), true, k);
            locali.sp.edit().putString("chattingui_recent_shown_image_path", locali.Fwm.Fwj).commit();
            ae.d("MicroMsg.RecentImageBubble", "check ok");
            i = 1;
            break;
          }
          ae.e("MicroMsg.RecentImageBubble", "image hits hole.");
          i = 0;
          break;
          ae.d("MicroMsg.RecentImageBubble", "check false");
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
  
  public final String fim()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(31758);
        if (this.Fwl == null)
        {
          ae.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
          localObject1 = null;
          this.Fwm = ((g)localObject1);
          if (this.Fwm == null)
          {
            AppMethodBeat.o(31758);
            localObject1 = null;
            return localObject1;
          }
        }
        else
        {
          localObject1 = this.Fwl.fik();
          if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
          {
            ae.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
            localObject1 = null;
            continue;
          }
          g localg = (g)((ArrayList)localObject1).get(0);
          if (localg != null)
          {
            if (bu.rZ(localg.Fwk) >= 0L) {
              break label306;
            }
            i = 1;
            if (i != 0)
            {
              ae.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", new Object[] { localg.Fwj });
              localObject1 = null;
              continue;
            }
          }
          if ((localg != null) && (localg.Fwj != null) && (localg.Fwj.contains(com.tencent.mm.loader.j.b.arZ())))
          {
            localObject1 = null;
            continue;
          }
          if (localg != null)
          {
            if (bu.rZ(localg.Fwk) > 30L) {
              break label311;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = localg;
              if (!this.sp.getString("chattingui_recent_shown_image_path", "").equals(localg.Fwj)) {
                continue;
              }
              ae.d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
              localObject1 = null;
              continue;
            }
          }
          if (localg != null) {
            break label316;
          }
          bool = true;
          ae.d("MicroMsg.RecentImageBubble", "because of checkAddDate(generateDate) == false, or imageItem == null : %s", new Object[] { Boolean.valueOf(bool) });
          localObject1 = null;
          continue;
        }
        Object localObject1 = this.Fwm.thumbPath;
        if (this.Fwm.thumbPath == null) {
          localObject1 = this.Fwm.Fwj;
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
    public abstract void aOx(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.i
 * JD-Core Version:    0.7.0.1
 */