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
import com.tencent.mm.app.e;
import com.tencent.mm.message.k.b;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.loader.c.b;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.tinker.entry.ApplicationLike;

final class k$a
  extends c.a
{
  public static final int aePz;
  public TextView Qcc;
  public MMImageView aeNf;
  public int aeOt = 0;
  public boolean aePy;
  public TextView pJJ;
  public TextView plr;
  public View rIZ;
  
  static
  {
    AppMethodBeat.i(36902);
    aePz = (int)com.tencent.mm.cd.a.getDensity(e.hfI.getApplication()) * 64;
    AppMethodBeat.o(36902);
  }
  
  public final a Q(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36900);
    super.create(paramView);
    this.aePy = paramBoolean;
    this.timeTV = ((TextView)this.convertView.findViewById(R.h.fAm));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = this.convertView.findViewById(R.h.fzn);
    this.userTV = ((TextView)this.convertView.findViewById(R.h.fAr));
    this.aeNf = ((MMImageView)this.convertView.findViewById(R.h.fsg));
    this.pJJ = ((TextView)this.convertView.findViewById(R.h.fsh));
    this.plr = ((TextView)this.convertView.findViewById(R.h.fsf));
    this.Qcc = ((TextView)this.convertView.findViewById(R.h.fsd));
    this.rIZ = this.convertView.findViewById(R.h.fse);
    this.aeOt = c.nn(MMApplicationContext.getContext());
    AppMethodBeat.o(36900);
    return this;
  }
  
  public final void a(final Context paramContext, k.b paramb, final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36901);
    resetChatBubbleWidth(this.clickArea, this.aeOt);
    Object localObject1;
    int i;
    switch (paramb.type)
    {
    default: 
      this.pJJ.setText(paramb.description);
      this.plr.setText(paramb.nSo);
      this.aeNf.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = r.bKe();
        paramb = r.bKa().X(paramString, true);
        paramString = this.aeNf;
        localObject1 = new com.tencent.mm.modelimage.loader.a.c.a();
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKs = 1;
        i = aePz;
        localObject1 = ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).eG(i, i);
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKB = R.k.app_attach_file_icon_webpage;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).nrc = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).bKx());
        AppMethodBeat.o(36901);
        return;
      }
      break;
    case 16: 
      this.pJJ.setText(paramb.description);
      this.plr.setText(paramb.nSo);
      this.aeNf.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = r.bKe();
        paramb = paramb.thumburl;
        paramString = this.aeNf;
        localObject1 = new com.tencent.mm.modelimage.loader.a.c.a();
        i = aePz;
        localObject1 = ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).eG(i, i);
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKB = R.k.app_attach_file_icon_webpage;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).nrc = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).bKx());
        AppMethodBeat.o(36901);
        return;
      }
      this.aeNf.setImageResource(R.g.foI);
      AppMethodBeat.o(36901);
      return;
    case 34: 
      if ((paramb.title != null) && (paramb.title.length() > 0))
      {
        this.pJJ.setVisibility(0);
        this.pJJ.setText(paramb.title);
        if (!Util.isNullOrNil(paramb.nSx))
        {
          this.pJJ.setTextColor(Util.convertStringToRGB(paramb.nSx, paramContext.getResources().getColor(R.e.normal_text_color)));
          this.plr.setMaxLines(2);
          this.plr.setVisibility(0);
          this.plr.setText(paramb.description);
          if (Util.isNullOrNil(paramb.nSy)) {
            break label612;
          }
          this.plr.setTextColor(Util.convertStringToRGB(paramb.nSy, paramContext.getResources().getColor(R.e.grey_background_text_color)));
          label415:
          if (Util.isNullOrNil(paramb.nSt)) {
            break label632;
          }
          this.Qcc.setText(paramb.nSt);
        }
      }
      for (;;)
      {
        if (paramBoolean)
        {
          Object localObject2;
          com.tencent.mm.modelimage.loader.a.c.a locala;
          if (!Util.isNullOrNil(paramb.nSw))
          {
            paramString = r.bKe();
            localObject1 = paramb.thumburl;
            localObject2 = this.aeNf;
            locala = new com.tencent.mm.modelimage.loader.a.c.a();
            i = aePz;
            locala = locala.eG(i, i);
            locala.oKB = R.k.app_attach_file_icon_webpage;
            locala.nrc = true;
            paramString.a((String)localObject1, (ImageView)localObject2, locala.bKx());
            paramString = r.bKe();
            paramb = paramb.nSw;
            localObject1 = new ImageView(paramContext);
            localObject2 = new com.tencent.mm.modelimage.loader.a.c.a();
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).oKp = true;
            paramString.a(paramb, (ImageView)localObject1, ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).bKx(), new h()
            {
              public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
              {
                return null;
              }
              
              public final void b(final String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
              {
                AppMethodBeat.i(36898);
                if (paramAnonymousb.bitmap != null)
                {
                  paramAnonymousString = paramAnonymousb.bitmap;
                  k.a.this.rIZ.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                  {
                    public final boolean onPreDraw()
                    {
                      AppMethodBeat.i(36897);
                      k.a.this.rIZ.getViewTreeObserver().removeOnPreDrawListener(this);
                      int j = k.a.this.rIZ.getHeight();
                      int k = k.a.this.rIZ.getWidth();
                      int i = j;
                      if (j == 0) {
                        i = com.tencent.mm.cd.a.br(k.a.1.this.val$context, R.f.chatting_music_item_height);
                      }
                      j = k;
                      if (k == 0) {
                        j = com.tencent.mm.cd.a.br(k.a.1.this.val$context, R.f.chatting_music_item_width);
                      }
                      if (k.a.this.aePy) {}
                      for (Object localObject = BitmapUtil.createMaskImage(paramAnonymousString, R.g.chat_from_content_bg_mask, j, i);; localObject = BitmapUtil.createMaskImage(paramAnonymousString, R.g.chat_to_content_bg_mask, j, i))
                      {
                        localObject = new BitmapDrawable((Bitmap)localObject);
                        k.a.this.rIZ.setBackgroundDrawable((Drawable)localObject);
                        AppMethodBeat.o(36897);
                        return true;
                      }
                    }
                  });
                }
                AppMethodBeat.o(36898);
              }
              
              public final void c(String paramAnonymousString, View paramAnonymousView) {}
            });
            AppMethodBeat.o(36901);
            return;
            this.pJJ.setTextColor(paramContext.getResources().getColor(R.e.normal_text_color));
            break;
            this.pJJ.setVisibility(8);
            break;
            label612:
            this.plr.setTextColor(paramContext.getResources().getColor(R.e.grey_background_text_color));
            break label415;
            label632:
            this.Qcc.setText(R.l.gyc);
            continue;
          }
          paramString = r.bKa().a(paramString, com.tencent.mm.cd.a.getDensity(paramContext), false);
          if ((paramString != null) && (!paramString.isRecycled()))
          {
            paramb = BitmapUtil.getRoundedCornerBitmap(paramString, false, paramString.getWidth() / 2);
            this.aeNf.setImageBitmap(paramb);
          }
          for (;;)
          {
            this.rIZ.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
            {
              private boolean aeOC = false;
              
              public final boolean onPreDraw()
              {
                AppMethodBeat.i(36899);
                if (this.aeOC)
                {
                  k.a.this.rIZ.getViewTreeObserver().removeOnPreDrawListener(this);
                  AppMethodBeat.o(36899);
                  return true;
                }
                k.a.this.rIZ.getViewTreeObserver().removeOnPreDrawListener(this);
                this.aeOC = true;
                int i = com.tencent.mm.cd.a.fromDPToPix(paramContext, 24);
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
                  j = k.a.this.rIZ.getHeight();
                  int k = k.a.this.rIZ.getWidth();
                  i = j;
                  if (j == 0) {
                    i = com.tencent.mm.cd.a.br(paramContext, R.f.chatting_music_item_height);
                  }
                  j = k;
                  if (k == 0) {
                    j = com.tencent.mm.cd.a.br(paramContext, R.f.chatting_music_item_width);
                  }
                  if (!k.a.this.aePy) {
                    break label249;
                  }
                }
                label249:
                for (Object localObject = BitmapUtil.createMaskImage((Bitmap)localObject, R.g.chat_from_content_bg_mask, j, i);; localObject = BitmapUtil.createMaskImage((Bitmap)localObject, R.g.chat_to_content_bg_mask, j, i))
                {
                  localObject = new BitmapDrawable((Bitmap)localObject);
                  k.a.this.rIZ.setBackgroundDrawable((Drawable)localObject);
                  AppMethodBeat.o(36899);
                  return true;
                  break;
                }
              }
            });
            AppMethodBeat.o(36901);
            return;
            localObject1 = r.bKe();
            paramb = paramb.thumburl;
            localObject2 = this.aeNf;
            locala = new com.tencent.mm.modelimage.loader.a.c.a();
            i = aePz;
            locala = locala.eG(i, i);
            locala.oKB = R.k.app_attach_file_icon_webpage;
            locala.nrc = true;
            ((com.tencent.mm.modelimage.loader.a)localObject1).a(paramb, (ImageView)localObject2, locala.bKx());
          }
        }
      }
      this.aeNf.setImageBitmap(BitmapFactory.decodeResource(paramContext.getResources(), R.g.foI));
      AppMethodBeat.o(36901);
      return;
    }
    this.aeNf.setImageResource(R.g.foI);
    AppMethodBeat.o(36901);
  }
  
  public final View getMainContainerView()
  {
    return this.convertView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k.a
 * JD-Core Version:    0.7.0.1
 */