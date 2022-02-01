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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.app.d;
import com.tencent.mm.aw.a.c.h;
import com.tencent.mm.aw.a.d.b;
import com.tencent.mm.aw.i;
import com.tencent.mm.aw.q;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.MMImageView;
import com.tencent.tinker.entry.ApplicationLike;

final class j$a
  extends c.a
{
  public static final int Kbo;
  public TextView AtQ;
  public MMImageView JZc;
  public int Kaq = 0;
  public boolean Kbn;
  public TextView iCV;
  public TextView iVq;
  public View kBQ;
  
  static
  {
    AppMethodBeat.i(36902);
    Kbo = (int)com.tencent.mm.cc.a.getDensity(d.cTo.getApplication()) * 64;
    AppMethodBeat.o(36902);
  }
  
  public final a A(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36900);
    super.gn(paramView);
    this.Kbn = paramBoolean;
    this.fTP = ((TextView)this.tPw.findViewById(2131298178));
    this.iCK = ((CheckBox)paramView.findViewById(2131298068));
    this.gZU = this.tPw.findViewById(2131298147);
    this.yEk = ((TextView)this.tPw.findViewById(2131298185));
    this.JZc = ((MMImageView)this.tPw.findViewById(2131296926));
    this.iVq = ((TextView)this.tPw.findViewById(2131296927));
    this.iCV = ((TextView)this.tPw.findViewById(2131296925));
    this.AtQ = ((TextView)this.tPw.findViewById(2131296923));
    this.kBQ = this.tPw.findViewById(2131296924);
    this.Kaq = c.kn(aj.getContext());
    AppMethodBeat.o(36900);
    return this;
  }
  
  public final void a(final Context paramContext, k.b paramb, final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36901);
    aI(this.ofK, this.Kaq);
    Object localObject1;
    int i;
    switch (paramb.type)
    {
    default: 
      this.iVq.setText(paramb.description);
      this.iCV.setText(paramb.hBb);
      this.JZc.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = q.aIJ();
        paramb = q.aIF().R(paramString, true);
        paramString = this.JZc;
        localObject1 = new com.tencent.mm.aw.a.a.c.a();
        ((com.tencent.mm.aw.a.a.c.a)localObject1).idu = 1;
        i = Kbo;
        localObject1 = ((com.tencent.mm.aw.a.a.c.a)localObject1).dh(i, i);
        ((com.tencent.mm.aw.a.a.c.a)localObject1).idD = 2131689584;
        ((com.tencent.mm.aw.a.a.c.a)localObject1).hfi = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.aw.a.a.c.a)localObject1).aJc());
        AppMethodBeat.o(36901);
        return;
      }
      break;
    case 16: 
      this.iVq.setText(paramb.description);
      this.iCV.setText(paramb.hBb);
      this.JZc.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = q.aIJ();
        paramb = paramb.thumburl;
        paramString = this.JZc;
        localObject1 = new com.tencent.mm.aw.a.a.c.a();
        i = Kbo;
        localObject1 = ((com.tencent.mm.aw.a.a.c.a)localObject1).dh(i, i);
        ((com.tencent.mm.aw.a.a.c.a)localObject1).idD = 2131689584;
        ((com.tencent.mm.aw.a.a.c.a)localObject1).hfi = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.aw.a.a.c.a)localObject1).aJc());
        AppMethodBeat.o(36901);
        return;
      }
      this.JZc.setImageResource(2131233475);
      AppMethodBeat.o(36901);
      return;
    case 34: 
      if ((paramb.title != null) && (paramb.title.length() > 0))
      {
        this.iVq.setVisibility(0);
        this.iVq.setText(paramb.title);
        if (!bt.isNullOrNil(paramb.titleColor))
        {
          this.iVq.setTextColor(bt.cJ(paramb.titleColor, paramContext.getResources().getColor(2131100711)));
          this.iCV.setMaxLines(2);
          this.iCV.setVisibility(0);
          this.iCV.setText(paramb.description);
          if (bt.isNullOrNil(paramb.hBk)) {
            break label605;
          }
          this.iCV.setTextColor(bt.cJ(paramb.hBk, paramContext.getResources().getColor(2131100469)));
          label410:
          if (bt.isNullOrNil(paramb.hBg)) {
            break label624;
          }
          this.AtQ.setText(paramb.hBg);
        }
      }
      for (;;)
      {
        if (paramBoolean)
        {
          Object localObject2;
          com.tencent.mm.aw.a.a.c.a locala;
          if (!bt.isNullOrNil(paramb.hBj))
          {
            paramString = q.aIJ();
            localObject1 = paramb.thumburl;
            localObject2 = this.JZc;
            locala = new com.tencent.mm.aw.a.a.c.a();
            i = Kbo;
            locala = locala.dh(i, i);
            locala.idD = 2131689584;
            locala.hfi = true;
            paramString.a((String)localObject1, (ImageView)localObject2, locala.aJc());
            paramString = q.aIJ();
            paramb = paramb.hBj;
            localObject1 = new ImageView(paramContext);
            localObject2 = new com.tencent.mm.aw.a.a.c.a();
            ((com.tencent.mm.aw.a.a.c.a)localObject2).idr = true;
            paramString.a(paramb, (ImageView)localObject1, ((com.tencent.mm.aw.a.a.c.a)localObject2).aJc(), new h()
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
                  j.a.this.kBQ.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                  {
                    public final boolean onPreDraw()
                    {
                      AppMethodBeat.i(36897);
                      j.a.this.kBQ.getViewTreeObserver().removeOnPreDrawListener(this);
                      int j = j.a.this.kBQ.getHeight();
                      int k = j.a.this.kBQ.getWidth();
                      int i = j;
                      if (j == 0) {
                        i = com.tencent.mm.cc.a.ax(j.a.1.this.val$context, 2131166036);
                      }
                      j = k;
                      if (k == 0) {
                        j = com.tencent.mm.cc.a.ax(j.a.1.this.val$context, 2131166037);
                      }
                      if (j.a.this.Kbn) {}
                      for (Object localObject = g.b(paramAnonymousString, 2131231553, j, i);; localObject = g.b(paramAnonymousString, 2131231589, j, i))
                      {
                        localObject = new BitmapDrawable((Bitmap)localObject);
                        j.a.this.kBQ.setBackgroundDrawable((Drawable)localObject);
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
            this.iVq.setTextColor(paramContext.getResources().getColor(2131100711));
            break;
            this.iVq.setVisibility(8);
            break;
            label605:
            this.iCV.setTextColor(paramContext.getResources().getColor(2131100469));
            break label410;
            label624:
            this.AtQ.setText(2131757206);
            continue;
          }
          paramString = q.aIF().a(paramString, com.tencent.mm.cc.a.getDensity(paramContext), false);
          if ((paramString != null) && (!paramString.isRecycled()))
          {
            paramb = g.a(paramString, false, paramString.getWidth() / 2);
            this.JZc.setImageBitmap(paramb);
          }
          for (;;)
          {
            this.kBQ.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
            {
              private boolean Kaz = false;
              
              public final boolean onPreDraw()
              {
                AppMethodBeat.i(36899);
                if (this.Kaz)
                {
                  j.a.this.kBQ.getViewTreeObserver().removeOnPreDrawListener(this);
                  AppMethodBeat.o(36899);
                  return true;
                }
                j.a.this.kBQ.getViewTreeObserver().removeOnPreDrawListener(this);
                this.Kaz = true;
                int i = com.tencent.mm.cc.a.fromDPToPix(paramContext, 24);
                Bitmap localBitmap = paramString;
                if (localBitmap != null)
                {
                  localObject = localBitmap;
                  if (!localBitmap.isRecycled()) {}
                }
                else
                {
                  localObject = g.aJ(paramContext.getResources().getColor(2131100129), i, i);
                }
                int j = ((Bitmap)localObject).getHeight();
                if (i > j)
                {
                  i = j;
                  localObject = g.l(g.aD(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                  j = j.a.this.kBQ.getHeight();
                  int k = j.a.this.kBQ.getWidth();
                  i = j;
                  if (j == 0) {
                    i = com.tencent.mm.cc.a.ax(paramContext, 2131166036);
                  }
                  j = k;
                  if (k == 0) {
                    j = com.tencent.mm.cc.a.ax(paramContext, 2131166037);
                  }
                  if (!j.a.this.Kbn) {
                    break label243;
                  }
                }
                label243:
                for (Object localObject = g.b((Bitmap)localObject, 2131231553, j, i);; localObject = g.b((Bitmap)localObject, 2131231589, j, i))
                {
                  localObject = new BitmapDrawable((Bitmap)localObject);
                  j.a.this.kBQ.setBackgroundDrawable((Drawable)localObject);
                  AppMethodBeat.o(36899);
                  return true;
                  break;
                }
              }
            });
            AppMethodBeat.o(36901);
            return;
            localObject1 = q.aIJ();
            paramb = paramb.thumburl;
            localObject2 = this.JZc;
            locala = new com.tencent.mm.aw.a.a.c.a();
            i = Kbo;
            locala = locala.dh(i, i);
            locala.idD = 2131689584;
            locala.hfi = true;
            ((com.tencent.mm.aw.a.a)localObject1).a(paramb, (ImageView)localObject2, locala.aJc());
          }
        }
      }
      this.JZc.setImageBitmap(BitmapFactory.decodeResource(paramContext.getResources(), 2131233475));
      AppMethodBeat.o(36901);
      return;
    }
    this.JZc.setImageResource(2131233475);
    AppMethodBeat.o(36901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.a
 * JD-Core Version:    0.7.0.1
 */