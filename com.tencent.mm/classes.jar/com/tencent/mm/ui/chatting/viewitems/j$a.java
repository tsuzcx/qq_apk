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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.app.d;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMImageView;
import com.tencent.tinker.entry.ApplicationLike;

final class j$a
  extends c.a
{
  public static final int KxG;
  public TextView ALf;
  public MMImageView Kvv;
  public int KwJ = 0;
  public boolean KxF;
  public TextView iFO;
  public TextView iYj;
  public View kFf;
  
  static
  {
    AppMethodBeat.i(36902);
    KxG = (int)com.tencent.mm.cb.a.getDensity(d.cTZ.getApplication()) * 64;
    AppMethodBeat.o(36902);
  }
  
  public final a F(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36900);
    super.gs(paramView);
    this.KxF = paramBoolean;
    this.fVV = ((TextView)this.uan.findViewById(2131298178));
    this.iFD = ((CheckBox)paramView.findViewById(2131298068));
    this.hcH = this.uan.findViewById(2131298147);
    this.yUp = ((TextView)this.uan.findViewById(2131298185));
    this.Kvv = ((MMImageView)this.uan.findViewById(2131296926));
    this.iYj = ((TextView)this.uan.findViewById(2131296927));
    this.iFO = ((TextView)this.uan.findViewById(2131296925));
    this.ALf = ((TextView)this.uan.findViewById(2131296923));
    this.kFf = this.uan.findViewById(2131296924);
    this.KwJ = c.ku(ak.getContext());
    AppMethodBeat.o(36900);
    return this;
  }
  
  public final void a(final Context paramContext, k.b paramb, final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36901);
    aI(this.olI, this.KwJ);
    Object localObject1;
    int i;
    switch (paramb.type)
    {
    default: 
      this.iYj.setText(paramb.description);
      this.iFO.setText(paramb.hDP);
      this.Kvv.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = q.aJb();
        paramb = q.aIX().R(paramString, true);
        paramString = this.Kvv;
        localObject1 = new com.tencent.mm.av.a.a.c.a();
        ((com.tencent.mm.av.a.a.c.a)localObject1).ign = 1;
        i = KxG;
        localObject1 = ((com.tencent.mm.av.a.a.c.a)localObject1).dh(i, i);
        ((com.tencent.mm.av.a.a.c.a)localObject1).igv = 2131689584;
        ((com.tencent.mm.av.a.a.c.a)localObject1).hhW = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.av.a.a.c.a)localObject1).aJu());
        AppMethodBeat.o(36901);
        return;
      }
      break;
    case 16: 
      this.iYj.setText(paramb.description);
      this.iFO.setText(paramb.hDP);
      this.Kvv.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = q.aJb();
        paramb = paramb.thumburl;
        paramString = this.Kvv;
        localObject1 = new com.tencent.mm.av.a.a.c.a();
        i = KxG;
        localObject1 = ((com.tencent.mm.av.a.a.c.a)localObject1).dh(i, i);
        ((com.tencent.mm.av.a.a.c.a)localObject1).igv = 2131689584;
        ((com.tencent.mm.av.a.a.c.a)localObject1).hhW = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.av.a.a.c.a)localObject1).aJu());
        AppMethodBeat.o(36901);
        return;
      }
      this.Kvv.setImageResource(2131233475);
      AppMethodBeat.o(36901);
      return;
    case 34: 
      if ((paramb.title != null) && (paramb.title.length() > 0))
      {
        this.iYj.setVisibility(0);
        this.iYj.setText(paramb.title);
        if (!bu.isNullOrNil(paramb.titleColor))
        {
          this.iYj.setTextColor(bu.cN(paramb.titleColor, paramContext.getResources().getColor(2131100711)));
          this.iFO.setMaxLines(2);
          this.iFO.setVisibility(0);
          this.iFO.setText(paramb.description);
          if (bu.isNullOrNil(paramb.hDY)) {
            break label605;
          }
          this.iFO.setTextColor(bu.cN(paramb.hDY, paramContext.getResources().getColor(2131100469)));
          label410:
          if (bu.isNullOrNil(paramb.hDU)) {
            break label624;
          }
          this.ALf.setText(paramb.hDU);
        }
      }
      for (;;)
      {
        if (paramBoolean)
        {
          Object localObject2;
          com.tencent.mm.av.a.a.c.a locala;
          if (!bu.isNullOrNil(paramb.hDX))
          {
            paramString = q.aJb();
            localObject1 = paramb.thumburl;
            localObject2 = this.Kvv;
            locala = new com.tencent.mm.av.a.a.c.a();
            i = KxG;
            locala = locala.dh(i, i);
            locala.igv = 2131689584;
            locala.hhW = true;
            paramString.a((String)localObject1, (ImageView)localObject2, locala.aJu());
            paramString = q.aJb();
            paramb = paramb.hDX;
            localObject1 = new ImageView(paramContext);
            localObject2 = new com.tencent.mm.av.a.a.c.a();
            ((com.tencent.mm.av.a.a.c.a)localObject2).igk = true;
            paramString.a(paramb, (ImageView)localObject1, ((com.tencent.mm.av.a.a.c.a)localObject2).aJu(), new com.tencent.mm.av.a.c.h()
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
                  j.a.this.kFf.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                  {
                    public final boolean onPreDraw()
                    {
                      AppMethodBeat.i(36897);
                      j.a.this.kFf.getViewTreeObserver().removeOnPreDrawListener(this);
                      int j = j.a.this.kFf.getHeight();
                      int k = j.a.this.kFf.getWidth();
                      int i = j;
                      if (j == 0) {
                        i = com.tencent.mm.cb.a.ax(j.a.1.this.val$context, 2131166036);
                      }
                      j = k;
                      if (k == 0) {
                        j = com.tencent.mm.cb.a.ax(j.a.1.this.val$context, 2131166037);
                      }
                      if (j.a.this.KxF) {}
                      for (Object localObject = com.tencent.mm.sdk.platformtools.h.b(paramAnonymousString, 2131231553, j, i);; localObject = com.tencent.mm.sdk.platformtools.h.b(paramAnonymousString, 2131231589, j, i))
                      {
                        localObject = new BitmapDrawable((Bitmap)localObject);
                        j.a.this.kFf.setBackgroundDrawable((Drawable)localObject);
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
            this.iYj.setTextColor(paramContext.getResources().getColor(2131100711));
            break;
            this.iYj.setVisibility(8);
            break;
            label605:
            this.iFO.setTextColor(paramContext.getResources().getColor(2131100469));
            break label410;
            label624:
            this.ALf.setText(2131757206);
            continue;
          }
          paramString = q.aIX().a(paramString, com.tencent.mm.cb.a.getDensity(paramContext), false);
          if ((paramString != null) && (!paramString.isRecycled()))
          {
            paramb = com.tencent.mm.sdk.platformtools.h.a(paramString, false, paramString.getWidth() / 2);
            this.Kvv.setImageBitmap(paramb);
          }
          for (;;)
          {
            this.kFf.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
            {
              private boolean KwS = false;
              
              public final boolean onPreDraw()
              {
                AppMethodBeat.i(36899);
                if (this.KwS)
                {
                  j.a.this.kFf.getViewTreeObserver().removeOnPreDrawListener(this);
                  AppMethodBeat.o(36899);
                  return true;
                }
                j.a.this.kFf.getViewTreeObserver().removeOnPreDrawListener(this);
                this.KwS = true;
                int i = com.tencent.mm.cb.a.fromDPToPix(paramContext, 24);
                Bitmap localBitmap = paramString;
                if (localBitmap != null)
                {
                  localObject = localBitmap;
                  if (!localBitmap.isRecycled()) {}
                }
                else
                {
                  localObject = com.tencent.mm.sdk.platformtools.h.aK(paramContext.getResources().getColor(2131100129), i, i);
                }
                int j = ((Bitmap)localObject).getHeight();
                if (i > j)
                {
                  i = j;
                  localObject = com.tencent.mm.sdk.platformtools.h.l(com.tencent.mm.sdk.platformtools.h.aE(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                  j = j.a.this.kFf.getHeight();
                  int k = j.a.this.kFf.getWidth();
                  i = j;
                  if (j == 0) {
                    i = com.tencent.mm.cb.a.ax(paramContext, 2131166036);
                  }
                  j = k;
                  if (k == 0) {
                    j = com.tencent.mm.cb.a.ax(paramContext, 2131166037);
                  }
                  if (!j.a.this.KxF) {
                    break label243;
                  }
                }
                label243:
                for (Object localObject = com.tencent.mm.sdk.platformtools.h.b((Bitmap)localObject, 2131231553, j, i);; localObject = com.tencent.mm.sdk.platformtools.h.b((Bitmap)localObject, 2131231589, j, i))
                {
                  localObject = new BitmapDrawable((Bitmap)localObject);
                  j.a.this.kFf.setBackgroundDrawable((Drawable)localObject);
                  AppMethodBeat.o(36899);
                  return true;
                  break;
                }
              }
            });
            AppMethodBeat.o(36901);
            return;
            localObject1 = q.aJb();
            paramb = paramb.thumburl;
            localObject2 = this.Kvv;
            locala = new com.tencent.mm.av.a.a.c.a();
            i = KxG;
            locala = locala.dh(i, i);
            locala.igv = 2131689584;
            locala.hhW = true;
            ((com.tencent.mm.av.a.a)localObject1).a(paramb, (ImageView)localObject2, locala.aJu());
          }
        }
      }
      this.Kvv.setImageBitmap(BitmapFactory.decodeResource(paramContext.getResources(), 2131233475));
      AppMethodBeat.o(36901);
      return;
    }
    this.Kvv.setImageResource(2131233475);
    AppMethodBeat.o(36901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.a
 * JD-Core Version:    0.7.0.1
 */