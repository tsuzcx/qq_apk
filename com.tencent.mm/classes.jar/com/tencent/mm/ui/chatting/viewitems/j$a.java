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
import com.tencent.mm.aw.g;
import com.tencent.mm.aw.o;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMImageView;
import com.tencent.tinker.entry.ApplicationLike;

final class j$a
  extends c.a
{
  public static final int GKT;
  public MMImageView GIH;
  public int GJV = 0;
  public boolean GKS;
  public TextView hJe;
  public TextView ica;
  public View jGE;
  public TextView xPj;
  
  static
  {
    AppMethodBeat.i(36902);
    GKT = (int)com.tencent.mm.cd.a.getDensity(d.cKY.getApplication()) * 64;
    AppMethodBeat.o(36902);
  }
  
  public final a A(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36900);
    super.fK(paramView);
    this.GKS = paramBoolean;
    this.fwS = ((TextView)this.rLd.findViewById(2131298178));
    this.hIS = ((CheckBox)paramView.findViewById(2131298068));
    this.lRB = this.rLd.findViewById(2131298147);
    this.wet = ((TextView)this.rLd.findViewById(2131298185));
    this.GIH = ((MMImageView)this.rLd.findViewById(2131296926));
    this.ica = ((TextView)this.rLd.findViewById(2131296927));
    this.hJe = ((TextView)this.rLd.findViewById(2131296925));
    this.xPj = ((TextView)this.rLd.findViewById(2131296923));
    this.jGE = this.rLd.findViewById(2131296924);
    this.GJV = c.jQ(aj.getContext());
    AppMethodBeat.o(36900);
    return this;
  }
  
  public final void a(final Context paramContext, k.b paramb, final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36901);
    aE(this.naN, this.GJV);
    Object localObject1;
    int i;
    switch (paramb.type)
    {
    default: 
      this.ica.setText(paramb.description);
      this.hJe.setText(paramb.gIr);
      this.GIH.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = o.ayJ();
        paramb = o.ayF().Q(paramString, true);
        paramString = this.GIH;
        localObject1 = new com.tencent.mm.aw.a.a.c.a();
        ((com.tencent.mm.aw.a.a.c.a)localObject1).hjX = 1;
        i = GKT;
        localObject1 = ((com.tencent.mm.aw.a.a.c.a)localObject1).de(i, i);
        ((com.tencent.mm.aw.a.a.c.a)localObject1).hkf = 2131689584;
        ((com.tencent.mm.aw.a.a.c.a)localObject1).gkG = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.aw.a.a.c.a)localObject1).azc());
        AppMethodBeat.o(36901);
        return;
      }
      break;
    case 16: 
      this.ica.setText(paramb.description);
      this.hJe.setText(paramb.gIr);
      this.GIH.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = o.ayJ();
        paramb = paramb.thumburl;
        paramString = this.GIH;
        localObject1 = new com.tencent.mm.aw.a.a.c.a();
        i = GKT;
        localObject1 = ((com.tencent.mm.aw.a.a.c.a)localObject1).de(i, i);
        ((com.tencent.mm.aw.a.a.c.a)localObject1).hkf = 2131689584;
        ((com.tencent.mm.aw.a.a.c.a)localObject1).gkG = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.aw.a.a.c.a)localObject1).azc());
        AppMethodBeat.o(36901);
        return;
      }
      this.GIH.setImageResource(2131233475);
      AppMethodBeat.o(36901);
      return;
    case 34: 
      if ((paramb.title != null) && (paramb.title.length() > 0))
      {
        this.ica.setVisibility(0);
        this.ica.setText(paramb.title);
        if (!bt.isNullOrNil(paramb.gIA))
        {
          this.ica.setTextColor(bt.cB(paramb.gIA, paramContext.getResources().getColor(2131100711)));
          this.hJe.setMaxLines(2);
          this.hJe.setVisibility(0);
          this.hJe.setText(paramb.description);
          if (bt.isNullOrNil(paramb.gIB)) {
            break label605;
          }
          this.hJe.setTextColor(bt.cB(paramb.gIB, paramContext.getResources().getColor(2131100469)));
          label410:
          if (bt.isNullOrNil(paramb.gIw)) {
            break label624;
          }
          this.xPj.setText(paramb.gIw);
        }
      }
      for (;;)
      {
        if (paramBoolean)
        {
          Object localObject2;
          com.tencent.mm.aw.a.a.c.a locala;
          if (!bt.isNullOrNil(paramb.gIz))
          {
            paramString = o.ayJ();
            localObject1 = paramb.thumburl;
            localObject2 = this.GIH;
            locala = new com.tencent.mm.aw.a.a.c.a();
            i = GKT;
            locala = locala.de(i, i);
            locala.hkf = 2131689584;
            locala.gkG = true;
            paramString.a((String)localObject1, (ImageView)localObject2, locala.azc());
            paramString = o.ayJ();
            paramb = paramb.gIz;
            localObject1 = new ImageView(paramContext);
            localObject2 = new com.tencent.mm.aw.a.a.c.a();
            ((com.tencent.mm.aw.a.a.c.a)localObject2).hjU = true;
            paramString.a(paramb, (ImageView)localObject1, ((com.tencent.mm.aw.a.a.c.a)localObject2).azc(), new h()
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
                  j.a.this.jGE.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                  {
                    public final boolean onPreDraw()
                    {
                      AppMethodBeat.i(36897);
                      j.a.this.jGE.getViewTreeObserver().removeOnPreDrawListener(this);
                      int j = j.a.this.jGE.getHeight();
                      int k = j.a.this.jGE.getWidth();
                      int i = j;
                      if (j == 0) {
                        i = com.tencent.mm.cd.a.ao(j.a.1.this.val$context, 2131166036);
                      }
                      j = k;
                      if (k == 0) {
                        j = com.tencent.mm.cd.a.ao(j.a.1.this.val$context, 2131166037);
                      }
                      if (j.a.this.GKS) {}
                      for (Object localObject = f.b(paramAnonymousString, 2131231553, j, i);; localObject = f.b(paramAnonymousString, 2131231589, j, i))
                      {
                        localObject = new BitmapDrawable((Bitmap)localObject);
                        j.a.this.jGE.setBackgroundDrawable((Drawable)localObject);
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
            this.ica.setTextColor(paramContext.getResources().getColor(2131100711));
            break;
            this.ica.setVisibility(8);
            break;
            label605:
            this.hJe.setTextColor(paramContext.getResources().getColor(2131100469));
            break label410;
            label624:
            this.xPj.setText(2131757206);
            continue;
          }
          paramString = o.ayF().a(paramString, com.tencent.mm.cd.a.getDensity(paramContext), false);
          if ((paramString != null) && (!paramString.isRecycled()))
          {
            paramb = f.a(paramString, false, paramString.getWidth() / 2);
            this.GIH.setImageBitmap(paramb);
          }
          for (;;)
          {
            this.jGE.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
            {
              private boolean GKe = false;
              
              public final boolean onPreDraw()
              {
                AppMethodBeat.i(36899);
                if (this.GKe)
                {
                  j.a.this.jGE.getViewTreeObserver().removeOnPreDrawListener(this);
                  AppMethodBeat.o(36899);
                  return true;
                }
                j.a.this.jGE.getViewTreeObserver().removeOnPreDrawListener(this);
                this.GKe = true;
                int i = com.tencent.mm.cd.a.fromDPToPix(paramContext, 24);
                Bitmap localBitmap = paramString;
                if (localBitmap != null)
                {
                  localObject = localBitmap;
                  if (!localBitmap.isRecycled()) {}
                }
                else
                {
                  localObject = f.aG(paramContext.getResources().getColor(2131100129), i, i);
                }
                int j = ((Bitmap)localObject).getHeight();
                if (i > j)
                {
                  i = j;
                  localObject = f.l(f.az(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                  j = j.a.this.jGE.getHeight();
                  int k = j.a.this.jGE.getWidth();
                  i = j;
                  if (j == 0) {
                    i = com.tencent.mm.cd.a.ao(paramContext, 2131166036);
                  }
                  j = k;
                  if (k == 0) {
                    j = com.tencent.mm.cd.a.ao(paramContext, 2131166037);
                  }
                  if (!j.a.this.GKS) {
                    break label243;
                  }
                }
                label243:
                for (Object localObject = f.b((Bitmap)localObject, 2131231553, j, i);; localObject = f.b((Bitmap)localObject, 2131231589, j, i))
                {
                  localObject = new BitmapDrawable((Bitmap)localObject);
                  j.a.this.jGE.setBackgroundDrawable((Drawable)localObject);
                  AppMethodBeat.o(36899);
                  return true;
                  break;
                }
              }
            });
            AppMethodBeat.o(36901);
            return;
            localObject1 = o.ayJ();
            paramb = paramb.thumburl;
            localObject2 = this.GIH;
            locala = new com.tencent.mm.aw.a.a.c.a();
            i = GKT;
            locala = locala.de(i, i);
            locala.hkf = 2131689584;
            locala.gkG = true;
            ((com.tencent.mm.aw.a.a)localObject1).a(paramb, (ImageView)localObject2, locala.azc());
          }
        }
      }
      this.GIH.setImageBitmap(BitmapFactory.decodeResource(paramContext.getResources(), 2131233475));
      AppMethodBeat.o(36901);
      return;
    }
    this.GIH.setImageResource(2131233475);
    AppMethodBeat.o(36901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.a
 * JD-Core Version:    0.7.0.1
 */