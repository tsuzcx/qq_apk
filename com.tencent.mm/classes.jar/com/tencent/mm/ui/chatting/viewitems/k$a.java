package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.app.d;
import com.tencent.mm.ay.a.c.h;
import com.tencent.mm.ay.a.d.b;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.tinker.entry.ApplicationLike;

final class k$a
  extends c.a
{
  public static final int Xfw;
  public TextView JKu;
  public MMImageView Xdh;
  public int Xev = 0;
  public boolean Xfv;
  public TextView mNb;
  public TextView mrM;
  public View oFU;
  
  static
  {
    AppMethodBeat.i(36902);
    Xfw = (int)com.tencent.mm.ci.a.getDensity(d.fcb.getApplication()) * 64;
    AppMethodBeat.o(36902);
  }
  
  public final a K(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36900);
    super.create(paramView);
    this.Xfv = paramBoolean;
    this.timeTV = ((TextView)this.convertView.findViewById(R.h.dzs));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = this.convertView.findViewById(R.h.dyD);
    this.userTV = ((TextView)this.convertView.findViewById(R.h.chatting_user_tv));
    this.Xdh = ((MMImageView)this.convertView.findViewById(R.h.drO));
    this.mNb = ((TextView)this.convertView.findViewById(R.h.drP));
    this.mrM = ((TextView)this.convertView.findViewById(R.h.drN));
    this.JKu = ((TextView)this.convertView.findViewById(R.h.drL));
    this.oFU = this.convertView.findViewById(R.h.drM);
    this.Xev = c.lj(MMApplicationContext.getContext());
    AppMethodBeat.o(36900);
    return this;
  }
  
  public final void a(final Context paramContext, k.b paramb, final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36901);
    resetChatBubbleWidth(this.clickArea, this.Xev);
    Object localObject1;
    int i;
    switch (paramb.type)
    {
    default: 
      this.mNb.setText(paramb.description);
      this.mrM.setText(paramb.lnk);
      this.Xdh.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = q.bml();
        paramb = q.bmh().T(paramString, true);
        paramString = this.Xdh;
        localObject1 = new com.tencent.mm.ay.a.a.c.a();
        ((com.tencent.mm.ay.a.a.c.a)localObject1).lRG = 1;
        i = Xfw;
        localObject1 = ((com.tencent.mm.ay.a.a.c.a)localObject1).dO(i, i);
        ((com.tencent.mm.ay.a.a.c.a)localObject1).lRP = R.k.app_attach_file_icon_webpage;
        ((com.tencent.mm.ay.a.a.c.a)localObject1).kPz = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.ay.a.a.c.a)localObject1).bmL());
        AppMethodBeat.o(36901);
        return;
      }
      break;
    case 16: 
      this.mNb.setText(paramb.description);
      this.mrM.setText(paramb.lnk);
      this.Xdh.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = q.bml();
        paramb = paramb.thumburl;
        paramString = this.Xdh;
        localObject1 = new com.tencent.mm.ay.a.a.c.a();
        i = Xfw;
        localObject1 = ((com.tencent.mm.ay.a.a.c.a)localObject1).dO(i, i);
        ((com.tencent.mm.ay.a.a.c.a)localObject1).lRP = R.k.app_attach_file_icon_webpage;
        ((com.tencent.mm.ay.a.a.c.a)localObject1).kPz = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.ay.a.a.c.a)localObject1).bmL());
        AppMethodBeat.o(36901);
        return;
      }
      this.Xdh.setImageResource(R.g.dok);
      AppMethodBeat.o(36901);
      return;
    case 34: 
      if ((paramb.title != null) && (paramb.title.length() > 0))
      {
        this.mNb.setVisibility(0);
        this.mNb.setText(paramb.title);
        if (!Util.isNullOrNil(paramb.lnt))
        {
          this.mNb.setTextColor(Util.convertStringToRGB(paramb.lnt, paramContext.getResources().getColor(R.e.normal_text_color)));
          this.mrM.setMaxLines(2);
          this.mrM.setVisibility(0);
          this.mrM.setText(paramb.description);
          if (Util.isNullOrNil(paramb.lnu)) {
            break label612;
          }
          this.mrM.setTextColor(Util.convertStringToRGB(paramb.lnu, paramContext.getResources().getColor(R.e.grey_background_text_color)));
          label415:
          if (Util.isNullOrNil(paramb.lnp)) {
            break label632;
          }
          this.JKu.setText(paramb.lnp);
        }
      }
      for (;;)
      {
        if (paramBoolean)
        {
          Object localObject2;
          com.tencent.mm.ay.a.a.c.a locala;
          if (!Util.isNullOrNil(paramb.lns))
          {
            paramString = q.bml();
            localObject1 = paramb.thumburl;
            localObject2 = this.Xdh;
            locala = new com.tencent.mm.ay.a.a.c.a();
            i = Xfw;
            locala = locala.dO(i, i);
            locala.lRP = R.k.app_attach_file_icon_webpage;
            locala.kPz = true;
            paramString.a((String)localObject1, (ImageView)localObject2, locala.bmL());
            paramString = q.bml();
            paramb = paramb.lns;
            localObject1 = new ImageView(paramContext);
            localObject2 = new com.tencent.mm.ay.a.a.c.a();
            ((com.tencent.mm.ay.a.a.c.a)localObject2).lRD = true;
            paramString.a(paramb, (ImageView)localObject1, ((com.tencent.mm.ay.a.a.c.a)localObject2).bmL(), new h()
            {
              public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
              {
                return null;
              }
              
              public final void b(String paramAnonymousString, View paramAnonymousView) {}
              
              public final void b(final String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
              {
                AppMethodBeat.i(36898);
                if (paramAnonymousb.bitmap != null)
                {
                  paramAnonymousString = paramAnonymousb.bitmap;
                  k.a.this.oFU.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                  {
                    public final boolean onPreDraw()
                    {
                      AppMethodBeat.i(36897);
                      k.a.this.oFU.getViewTreeObserver().removeOnPreDrawListener(this);
                      int j = k.a.this.oFU.getHeight();
                      int k = k.a.this.oFU.getWidth();
                      int i = j;
                      if (j == 0) {
                        i = com.tencent.mm.ci.a.aY(k.a.1.this.val$context, R.f.chatting_music_item_height);
                      }
                      j = k;
                      if (k == 0) {
                        j = com.tencent.mm.ci.a.aY(k.a.1.this.val$context, R.f.chatting_music_item_width);
                      }
                      if (k.a.this.Xfv) {}
                      for (Object localObject = BitmapUtil.createMaskImage(paramAnonymousString, R.g.chat_from_content_bg_mask, j, i);; localObject = BitmapUtil.createMaskImage(paramAnonymousString, R.g.chat_to_content_bg_mask, j, i))
                      {
                        localObject = new BitmapDrawable((Bitmap)localObject);
                        k.a.this.oFU.setBackgroundDrawable((Drawable)localObject);
                        AppMethodBeat.o(36897);
                        return true;
                      }
                    }
                  });
                }
                AppMethodBeat.o(36898);
              }
            });
            AppMethodBeat.o(36901);
            return;
            this.mNb.setTextColor(paramContext.getResources().getColor(R.e.normal_text_color));
            break;
            this.mNb.setVisibility(8);
            break;
            label612:
            this.mrM.setTextColor(paramContext.getResources().getColor(R.e.grey_background_text_color));
            break label415;
            label632:
            this.JKu.setText(R.l.evC);
            continue;
          }
          paramString = q.bmh().a(paramString, com.tencent.mm.ci.a.getDensity(paramContext), false);
          if ((paramString != null) && (!paramString.isRecycled()))
          {
            paramb = BitmapUtil.getRoundedCornerBitmap(paramString, false, paramString.getWidth() / 2);
            this.Xdh.setImageBitmap(paramb);
          }
          for (;;)
          {
            this.oFU.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
            {
              private boolean XeE = false;
              
              public final boolean onPreDraw()
              {
                AppMethodBeat.i(36899);
                if (this.XeE)
                {
                  k.a.this.oFU.getViewTreeObserver().removeOnPreDrawListener(this);
                  AppMethodBeat.o(36899);
                  return true;
                }
                k.a.this.oFU.getViewTreeObserver().removeOnPreDrawListener(this);
                this.XeE = true;
                int i = com.tencent.mm.ci.a.fromDPToPix(paramContext, 24);
                Bitmap localBitmap = paramString;
                if (localBitmap != null)
                {
                  localObject = localBitmap;
                  if (!localBitmap.isRecycled()) {}
                }
                else
                {
                  localObject = BitmapUtil.createColorBitmap(paramContext.getResources().getColor(R.e.chat_item_default_mucic_mask_color), i, i);
                }
                int j = ((Bitmap)localObject).getHeight();
                if (i > j)
                {
                  i = j;
                  localObject = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true), 0.9F), 20);
                  j = k.a.this.oFU.getHeight();
                  int k = k.a.this.oFU.getWidth();
                  i = j;
                  if (j == 0) {
                    i = com.tencent.mm.ci.a.aY(paramContext, R.f.chatting_music_item_height);
                  }
                  j = k;
                  if (k == 0) {
                    j = com.tencent.mm.ci.a.aY(paramContext, R.f.chatting_music_item_width);
                  }
                  if (!k.a.this.Xfv) {
                    break label249;
                  }
                }
                label249:
                for (Object localObject = BitmapUtil.createMaskImage((Bitmap)localObject, R.g.chat_from_content_bg_mask, j, i);; localObject = BitmapUtil.createMaskImage((Bitmap)localObject, R.g.chat_to_content_bg_mask, j, i))
                {
                  localObject = new BitmapDrawable((Bitmap)localObject);
                  k.a.this.oFU.setBackgroundDrawable((Drawable)localObject);
                  AppMethodBeat.o(36899);
                  return true;
                  break;
                }
              }
            });
            AppMethodBeat.o(36901);
            return;
            localObject1 = q.bml();
            paramb = paramb.thumburl;
            localObject2 = this.Xdh;
            locala = new com.tencent.mm.ay.a.a.c.a();
            i = Xfw;
            locala = locala.dO(i, i);
            locala.lRP = R.k.app_attach_file_icon_webpage;
            locala.kPz = true;
            ((com.tencent.mm.ay.a.a)localObject1).a(paramb, (ImageView)localObject2, locala.bmL());
          }
        }
      }
      this.Xdh.setImageBitmap(BitmapFactory.decodeResource(paramContext.getResources(), R.g.dok));
      AppMethodBeat.o(36901);
      return;
    }
    this.Xdh.setImageResource(R.g.dok);
    AppMethodBeat.o(36901);
  }
  
  public final View getMainContainerView()
  {
    return this.convertView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k.a
 * JD-Core Version:    0.7.0.1
 */