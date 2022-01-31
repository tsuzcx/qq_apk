package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.app.b;
import com.tencent.mm.as.g;
import com.tencent.mm.as.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMImageView;
import com.tencent.tinker.loader.app.ApplicationLike;

final class i$a
  extends c.a
{
  public static final int vCE = (int)com.tencent.mm.cb.a.getDensity(b.applicationLike.getApplication()) * 64;
  public TextView eXO;
  public TextView eXP;
  public TextView pmh;
  public int vBZ = 0;
  public MMImageView vBn;
  public View vCC;
  public boolean vCD;
  
  public final void a(Context paramContext, g.a parama, String paramString, boolean paramBoolean)
  {
    Y(this.igg, this.vBZ);
    Object localObject1;
    switch (parama.type)
    {
    default: 
      this.eXO.setText(parama.description);
      this.eXP.setText(parama.dRL);
      this.vBn.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = o.ON();
        parama = o.OJ().F(paramString, true);
        paramString = this.vBn;
        localObject1 = new com.tencent.mm.as.a.a.c.a();
        ((com.tencent.mm.as.a.a.c.a)localObject1).erk = 1;
        localObject1 = ((com.tencent.mm.as.a.a.c.a)localObject1).bn(vCE, vCE);
        ((com.tencent.mm.as.a.a.c.a)localObject1).eru = R.k.app_attach_file_icon_webpage;
        ((com.tencent.mm.as.a.a.c.a)localObject1).erD = true;
        paramContext.a(parama, paramString, ((com.tencent.mm.as.a.a.c.a)localObject1).OV());
        return;
      }
      break;
    case 16: 
      this.eXO.setText(parama.description);
      this.eXP.setText(parama.dRL);
      this.vBn.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = o.OJ().a(paramString, com.tencent.mm.cb.a.getDensity(paramContext), false);
        if ((paramContext != null) && (!paramContext.isRecycled()))
        {
          paramContext = com.tencent.mm.sdk.platformtools.c.a(paramContext, false, paramContext.getWidth() / 2);
          this.vBn.setImageBitmap(paramContext);
          return;
        }
        paramContext = o.ON();
        parama = parama.thumburl;
        paramString = this.vBn;
        localObject1 = new com.tencent.mm.as.a.a.c.a().bn(vCE, vCE);
        ((com.tencent.mm.as.a.a.c.a)localObject1).eru = R.k.app_attach_file_icon_webpage;
        ((com.tencent.mm.as.a.a.c.a)localObject1).erD = true;
        paramContext.a(parama, paramString, ((com.tencent.mm.as.a.a.c.a)localObject1).OV());
        return;
      }
      this.vBn.setImageResource(R.g.nosdcard_app);
      return;
    case 34: 
      if ((parama.title != null) && (parama.title.length() > 0))
      {
        this.eXO.setVisibility(0);
        this.eXO.setText(parama.title);
        if (!bk.bl(parama.dRU))
        {
          this.eXO.setTextColor(bk.bq(parama.dRU, paramContext.getResources().getColor(R.e.black)));
          this.eXP.setMaxLines(2);
          this.eXP.setVisibility(0);
          this.eXP.setText(parama.description);
          if (bk.bl(parama.dRV)) {
            break label599;
          }
          this.eXP.setTextColor(bk.bq(parama.dRV, paramContext.getResources().getColor(R.e.grey_background_text_color)));
          label428:
          if (bk.bl(parama.dRQ)) {
            break label619;
          }
          this.pmh.setText(parama.dRQ);
          label449:
          if (!paramBoolean) {
            break label719;
          }
          paramString = o.OJ().a(paramString, com.tencent.mm.cb.a.getDensity(paramContext), false);
          if ((paramString == null) || (paramString.isRecycled())) {
            break label632;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.c.a(paramString, false, paramString.getWidth() / 2);
          this.vBn.setImageBitmap((Bitmap)localObject1);
        }
      }
      for (;;)
      {
        if (bk.bl(parama.dRT)) {
          break label698;
        }
        paramString = o.ON();
        parama = parama.dRT;
        localObject1 = new ImageView(paramContext);
        Object localObject2 = new com.tencent.mm.as.a.a.c.a();
        ((com.tencent.mm.as.a.a.c.a)localObject2).erf = true;
        paramString.a(parama, (ImageView)localObject1, ((com.tencent.mm.as.a.a.c.a)localObject2).OV(), new i.a.1(this, paramContext));
        return;
        this.eXO.setTextColor(paramContext.getResources().getColor(R.e.black));
        break;
        this.eXO.setVisibility(8);
        break;
        label599:
        this.eXP.setTextColor(paramContext.getResources().getColor(R.e.grey_background_text_color));
        break label428;
        label619:
        this.pmh.setText(R.l.chatting_item_coupon_card);
        break label449;
        label632:
        localObject1 = o.ON();
        localObject2 = parama.thumburl;
        MMImageView localMMImageView = this.vBn;
        com.tencent.mm.as.a.a.c.a locala = new com.tencent.mm.as.a.a.c.a().bn(vCE, vCE);
        locala.eru = R.k.app_attach_file_icon_webpage;
        locala.erD = true;
        ((com.tencent.mm.as.a.a)localObject1).a((String)localObject2, localMMImageView, locala.OV());
      }
      label698:
      this.vCC.getViewTreeObserver().addOnPreDrawListener(new i.a.2(this, paramContext, paramString));
      return;
      label719:
      this.vBn.setImageBitmap(BitmapFactory.decodeResource(paramContext.getResources(), R.g.nosdcard_app));
      return;
    }
    this.vBn.setImageResource(R.g.nosdcard_app);
  }
  
  public final a t(View paramView, boolean paramBoolean)
  {
    super.dN(paramView);
    this.vCD = paramBoolean;
    this.dsz = ((TextView)this.kKz.findViewById(R.h.chatting_time_tv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = this.kKz.findViewById(R.h.chatting_maskview);
    this.nSa = ((TextView)this.kKz.findViewById(R.h.chatting_user_tv));
    this.vBn = ((MMImageView)this.kKz.findViewById(R.h.appmsg_coupon_card_icon));
    this.eXO = ((TextView)this.kKz.findViewById(R.h.appmsg_coupon_card_title));
    this.eXP = ((TextView)this.kKz.findViewById(R.h.appmsg_coupon_card_desc));
    this.pmh = ((TextView)this.kKz.findViewById(R.h.appmsg_coupon_card_bottom_title));
    this.vCC = this.kKz.findViewById(R.h.appmsg_coupon_card_content);
    this.vBZ = c.gT(ae.getContext());
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.a
 * JD-Core Version:    0.7.0.1
 */