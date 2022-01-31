package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R.f;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.le;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.appbrand.b;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.r.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

final class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$a
  extends e
{
  List<String> dAY;
  private Paint gaZ = new Paint();
  private String username;
  private HashMap<String, Boolean> vOS;
  private HashMap<String, String> vOT;
  private com.tencent.mm.sdk.b.c<le> vhg;
  
  AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$a(Context paramContext, String paramString, r.a parama)
  {
    super(paramContext, parama);
    this.username = paramString;
    this.vOS = new HashMap();
    this.vOT = new HashMap();
    this.dAY = new ArrayList();
    this.vhg = new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.a.1(this);
    com.tencent.mm.sdk.b.a.udP.c(this.vhg);
  }
  
  protected final void a(String paramString, e.g paramg)
  {
    Object localObject1 = (Boolean)this.vOS.get(paramString);
    boolean bool;
    if (localObject1 == null)
    {
      Object localObject2 = ((com.tencent.mm.plugin.appbrand.r.c)g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(paramString);
      if ((localObject2 != null) && ((((WxaAttributes)localObject2).field_appOpt & 0x2) > 0))
      {
        bool = true;
        this.vOS.put(paramString, localObject1);
        label63:
        if (!bool) {
          break label594;
        }
        paramg.veM.setVisibility(0);
        paramg.veM.setImageResource(R.k.chat_reject_icon);
        label86:
        localObject2 = (String)this.vOT.get(paramString);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = b.ada(b.acZ(paramString));
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            this.vOT.put(paramString, localObject2);
            localObject1 = localObject2;
          }
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label683;
        }
        paramg.vQy.setVisibility(0);
        localObject1 = this.context.getString(R.l.app_brand_source_from, new Object[] { localObject1 });
        paramg.vQy.setText((CharSequence)localObject1);
        if (this.context.getResources().getDisplayMetrics() == null) {
          break label719;
        }
      }
    }
    label261:
    label329:
    label719:
    for (int i = this.context.getResources().getDisplayMetrics().widthPixels;; i = 0)
    {
      int k;
      int j;
      float f1;
      label336:
      float f2;
      if (com.tencent.mm.cb.a.fh(this.context))
      {
        k = this.context.getResources().getDimensionPixelOffset(R.f.NormalAvatarWrapLargeSize);
        j = this.context.getResources().getDimensionPixelOffset(R.f.ConversationTimeSmallWidth);
        int m = this.context.getResources().getDimensionPixelOffset(R.f.LargePadding);
        int n = this.context.getResources().getDimensionPixelOffset(R.f.NormalPadding);
        localObject1 = (e.d)this.veF.get(paramString);
        if ((localObject1 == null) || (((e.d)localObject1).nickName == null)) {
          break label639;
        }
        localObject1 = ((e.d)localObject1).nickName.toString();
        if (localObject1 != null) {
          break label647;
        }
        f1 = 0.0F;
        f2 = 48.0F + f1;
        int i1 = this.context.getResources().getDimensionPixelOffset(R.f.ConversationTimeSmallerWidth);
        int i2 = this.context.getResources().getDimensionPixelOffset(R.f.LittlePadding);
        y.i("MicroMsg.ConversationAdapter", "screenWidth:%d, avatarLayoutWidth:%d, timeTVWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
        f1 = 0.0F;
        if (i > 0) {
          f1 = i - k - m - n - j;
        }
        if ((f2 > f1) || (f2 >= f1) || (f1 <= 0.0F)) {
          break label671;
        }
        f2 = Math.min(f2 / f1, (f1 - i1 - i2 - 48.0F) / f1);
        f1 = 1.0F - f2;
        label478:
        localObject1 = (LinearLayout.LayoutParams)paramg.veJ.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).width = 0;
        ((LinearLayout.LayoutParams)localObject1).weight = f2;
        paramg.veJ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (LinearLayout.LayoutParams)paramg.vQy.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).width = 0;
        ((LinearLayout.LayoutParams)localObject1).weight = f1;
        paramg.vQy.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      for (;;)
      {
        a.b.n(paramg.doU, paramString);
        if (!this.dAY.contains(paramString)) {
          this.dAY.add(paramString);
        }
        return;
        bool = false;
        break;
        bool = ((Boolean)localObject1).booleanValue();
        break label63;
        label594:
        paramg.veM.setVisibility(8);
        break label86;
        k = this.context.getResources().getDimensionPixelOffset(R.f.NormalAvatarWrapSize);
        j = this.context.getResources().getDimensionPixelOffset(R.f.ConversationTimeSmallerWidth);
        break label261;
        label639:
        localObject1 = "";
        break label329;
        this.gaZ.setTextSize(this.veC);
        f1 = this.gaZ.measureText((String)localObject1);
        break label336;
        f2 = 0.6F;
        f1 = 0.4F;
        break label478;
        localObject1 = (LinearLayout.LayoutParams)paramg.veJ.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).width = -1;
        ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
        paramg.veJ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  public final void detach()
  {
    this.vOS = null;
    com.tencent.mm.sdk.b.a.udP.d(this.vhg);
  }
  
  public final void yc()
  {
    au.Hx();
    setCursor(com.tencent.mm.model.c.FB().c(s.dUZ, this.dru, this.username));
    if (this.uMi != null) {
      this.uMi.Wp();
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.a
 * JD-Core Version:    0.7.0.1
 */