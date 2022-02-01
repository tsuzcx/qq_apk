package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ci.a;
import com.tencent.mm.f.a.pm;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.appbrand.e;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.v.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

final class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$a
  extends f
{
  private IListener<pm> WQk;
  private HashMap<String, Boolean> Xzf;
  private HashMap<String, String> Xzg;
  List<String> jxh;
  private Paint paint;
  private String username;
  
  AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$a(Context paramContext, String paramString, v.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(38120);
    this.paint = new Paint();
    this.username = paramString;
    this.Xzf = new HashMap();
    this.Xzg = new HashMap();
    this.jxh = new ArrayList();
    this.WQk = new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.a.1(this);
    EventCenter.instance.addListener(this.WQk);
    AppMethodBeat.o(38120);
  }
  
  protected final void a(String paramString, f.g paramg)
  {
    AppMethodBeat.i(38122);
    Object localObject1 = (Boolean)this.Xzf.get(paramString);
    boolean bool;
    label68:
    label91:
    int i;
    int k;
    int j;
    label269:
    int m;
    int n;
    label313:
    float f2;
    int i1;
    int i2;
    if (localObject1 == null)
    {
      Object localObject2 = ((q)h.ae(q.class)).aeW(paramString);
      if ((localObject2 != null) && ((((WxaAttributes)localObject2).field_appOpt & 0x2) > 0))
      {
        bool = true;
        this.Xzf.put(paramString, localObject1);
        if (!bool) {
          break label573;
        }
        paramg.WtU.setVisibility(0);
        paramg.WtU.setImageResource(R.k.chat_reject_icon);
        localObject2 = (String)this.Xzg.get(paramString);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = e.byx(e.byw(paramString));
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            this.Xzg.put(paramString, localObject2);
            localObject1 = localObject2;
          }
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label654;
        }
        paramg.XAG.setVisibility(0);
        localObject1 = this.context.getString(R.l.eoB, new Object[] { localObject1 });
        paramg.XAG.setText((CharSequence)localObject1);
        i = 0;
        if (this.context.getResources().getDisplayMetrics() != null) {
          i = this.context.getResources().getDisplayMetrics().widthPixels;
        }
        if (!a.ko(this.context)) {
          break label585;
        }
        k = this.context.getResources().getDimensionPixelOffset(R.f.NormalAvatarWrapLargeSize);
        j = this.context.getResources().getDimensionPixelOffset(R.f.ConversationTimeSmallWidth);
        m = this.context.getResources().getDimensionPixelOffset(R.f.LargePadding);
        n = this.context.getResources().getDimensionPixelOffset(R.f.NormalPadding);
        localObject1 = bAm(paramString);
        if (localObject1 != null) {
          break label618;
        }
        f1 = 0.0F;
        f2 = 48.0F + f1;
        i1 = this.context.getResources().getDimensionPixelOffset(R.f.ConversationTimeSmallerWidth);
        i2 = this.context.getResources().getDimensionPixelOffset(R.f.LittlePadding);
        Log.i("MicroMsg.ConversationAdapter", "screenWidth:%d, avatarLayoutWidth:%d, timeTVWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
        if (i <= 0) {
          break label690;
        }
      }
    }
    label654:
    label690:
    for (float f1 = i - k - m - n - j;; f1 = 0.0F)
    {
      if ((f2 <= f1) && (f2 < f1) && (f1 > 0.0F))
      {
        f1 = Math.min(f2 / f1, (f1 - i1 - i2 - 48.0F) / f1);
        f2 = 1.0F - f1;
        label452:
        localObject1 = (LinearLayout.LayoutParams)paramg.WtR.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).width = 0;
        ((LinearLayout.LayoutParams)localObject1).weight = f1;
        paramg.WtR.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (LinearLayout.LayoutParams)paramg.XAG.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).width = 0;
        ((LinearLayout.LayoutParams)localObject1).weight = f2;
        paramg.XAG.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      for (;;)
      {
        a.b.d(paramg.iZG, paramString);
        if (!this.jxh.contains(paramString)) {
          this.jxh.add(paramString);
        }
        AppMethodBeat.o(38122);
        return;
        bool = false;
        break;
        bool = ((Boolean)localObject1).booleanValue();
        break label68;
        label573:
        paramg.WtU.setVisibility(8);
        break label91;
        label585:
        k = this.context.getResources().getDimensionPixelOffset(R.f.NormalAvatarWrapSize);
        j = this.context.getResources().getDimensionPixelOffset(R.f.ConversationTimeSmallerWidth);
        break label269;
        label618:
        this.paint.setTextSize(this.WtG);
        f1 = this.paint.measureText((String)localObject1);
        break label313;
        f2 = 0.4F;
        f1 = 0.6F;
        break label452;
        localObject1 = (LinearLayout.LayoutParams)paramg.WtR.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).width = -1;
        ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
        paramg.WtR.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  public final void atr()
  {
    AppMethodBeat.i(38121);
    bh.beI();
    v(c.bbR().a(4, this.jkb, this.username));
    if (this.VZc != null) {
      this.VZc.bxN();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(38121);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(38123);
    this.Xzf = null;
    EventCenter.instance.removeListener(this.WQk);
    AppMethodBeat.o(38123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.a
 * JD-Core Version:    0.7.0.1
 */