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
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.av.g;
import com.tencent.mm.av.o;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMImageView;
import com.tencent.tinker.entry.ApplicationLike;

final class j$a
  extends c.a
{
  public static final int IkQ;
  public MMImageView IiE;
  public int IjS = 0;
  public boolean IkP;
  public TextView iCg;
  public TextView ijE;
  public View khc;
  public TextView zbZ;
  
  static
  {
    AppMethodBeat.i(36902);
    IkQ = (int)com.tencent.mm.cc.a.getDensity(d.cIg.getApplication()) * 64;
    AppMethodBeat.o(36902);
  }
  
  public final a A(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36900);
    super.fX(paramView);
    this.IkP = paramBoolean;
    this.fAz = ((TextView)this.sSS.findViewById(2131298178));
    this.ijt = ((CheckBox)paramView.findViewById(2131298068));
    this.gGk = this.sSS.findViewById(2131298147);
    this.xpH = ((TextView)this.sSS.findViewById(2131298185));
    this.IiE = ((MMImageView)this.sSS.findViewById(2131296926));
    this.iCg = ((TextView)this.sSS.findViewById(2131296927));
    this.ijE = ((TextView)this.sSS.findViewById(2131296925));
    this.zbZ = ((TextView)this.sSS.findViewById(2131296923));
    this.khc = this.sSS.findViewById(2131296924);
    this.IjS = c.kb(ai.getContext());
    AppMethodBeat.o(36900);
    return this;
  }
  
  public final void a(final Context paramContext, k.b paramb, final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36901);
    aG(this.nDl, this.IjS);
    Object localObject1;
    int i;
    switch (paramb.type)
    {
    default: 
      this.iCg.setText(paramb.description);
      this.ijE.setText(paramb.hiS);
      this.IiE.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = o.aFB();
        paramb = o.aFx().R(paramString, true);
        paramString = this.IiE;
        localObject1 = new com.tencent.mm.av.a.a.c.a();
        ((com.tencent.mm.av.a.a.c.a)localObject1).hKA = 1;
        i = IkQ;
        localObject1 = ((com.tencent.mm.av.a.a.c.a)localObject1).de(i, i);
        ((com.tencent.mm.av.a.a.c.a)localObject1).hKI = 2131689584;
        ((com.tencent.mm.av.a.a.c.a)localObject1).gLt = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.av.a.a.c.a)localObject1).aFT());
        AppMethodBeat.o(36901);
        return;
      }
      break;
    case 16: 
      this.iCg.setText(paramb.description);
      this.ijE.setText(paramb.hiS);
      this.IiE.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = o.aFB();
        paramb = paramb.thumburl;
        paramString = this.IiE;
        localObject1 = new com.tencent.mm.av.a.a.c.a();
        i = IkQ;
        localObject1 = ((com.tencent.mm.av.a.a.c.a)localObject1).de(i, i);
        ((com.tencent.mm.av.a.a.c.a)localObject1).hKI = 2131689584;
        ((com.tencent.mm.av.a.a.c.a)localObject1).gLt = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.av.a.a.c.a)localObject1).aFT());
        AppMethodBeat.o(36901);
        return;
      }
      this.IiE.setImageResource(2131233475);
      AppMethodBeat.o(36901);
      return;
    case 34: 
      if ((paramb.title != null) && (paramb.title.length() > 0))
      {
        this.iCg.setVisibility(0);
        this.iCg.setText(paramb.title);
        if (!bs.isNullOrNil(paramb.titleColor))
        {
          this.iCg.setTextColor(bs.cG(paramb.titleColor, paramContext.getResources().getColor(2131100711)));
          this.ijE.setMaxLines(2);
          this.ijE.setVisibility(0);
          this.ijE.setText(paramb.description);
          if (bs.isNullOrNil(paramb.hjb)) {
            break label605;
          }
          this.ijE.setTextColor(bs.cG(paramb.hjb, paramContext.getResources().getColor(2131100469)));
          label410:
          if (bs.isNullOrNil(paramb.hiX)) {
            break label624;
          }
          this.zbZ.setText(paramb.hiX);
        }
      }
      for (;;)
      {
        if (paramBoolean)
        {
          Object localObject2;
          com.tencent.mm.av.a.a.c.a locala;
          if (!bs.isNullOrNil(paramb.hja))
          {
            paramString = o.aFB();
            localObject1 = paramb.thumburl;
            localObject2 = this.IiE;
            locala = new com.tencent.mm.av.a.a.c.a();
            i = IkQ;
            locala = locala.de(i, i);
            locala.hKI = 2131689584;
            locala.gLt = true;
            paramString.a((String)localObject1, (ImageView)localObject2, locala.aFT());
            paramString = o.aFB();
            paramb = paramb.hja;
            localObject1 = new ImageView(paramContext);
            localObject2 = new com.tencent.mm.av.a.a.c.a();
            ((com.tencent.mm.av.a.a.c.a)localObject2).hKx = true;
            paramString.a(paramb, (ImageView)localObject1, ((com.tencent.mm.av.a.a.c.a)localObject2).aFT(), new h()
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
                  j.a.this.khc.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                  {
                    public final boolean onPreDraw()
                    {
                      AppMethodBeat.i(36897);
                      j.a.this.khc.getViewTreeObserver().removeOnPreDrawListener(this);
                      int j = j.a.this.khc.getHeight();
                      int k = j.a.this.khc.getWidth();
                      int i = j;
                      if (j == 0) {
                        i = com.tencent.mm.cc.a.au(j.a.1.this.val$context, 2131166036);
                      }
                      j = k;
                      if (k == 0) {
                        j = com.tencent.mm.cc.a.au(j.a.1.this.val$context, 2131166037);
                      }
                      if (j.a.this.IkP) {}
                      for (Object localObject = f.b(paramAnonymousString, 2131231553, j, i);; localObject = f.b(paramAnonymousString, 2131231589, j, i))
                      {
                        localObject = new BitmapDrawable((Bitmap)localObject);
                        j.a.this.khc.setBackgroundDrawable((Drawable)localObject);
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
            this.iCg.setTextColor(paramContext.getResources().getColor(2131100711));
            break;
            this.iCg.setVisibility(8);
            break;
            label605:
            this.ijE.setTextColor(paramContext.getResources().getColor(2131100469));
            break label410;
            label624:
            this.zbZ.setText(2131757206);
            continue;
          }
          paramString = o.aFx().a(paramString, com.tencent.mm.cc.a.getDensity(paramContext), false);
          if ((paramString != null) && (!paramString.isRecycled()))
          {
            paramb = f.a(paramString, false, paramString.getWidth() / 2);
            this.IiE.setImageBitmap(paramb);
          }
          for (;;)
          {
            this.khc.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
            {
              private boolean Ikb = false;
              
              public final boolean onPreDraw()
              {
                AppMethodBeat.i(36899);
                if (this.Ikb)
                {
                  j.a.this.khc.getViewTreeObserver().removeOnPreDrawListener(this);
                  AppMethodBeat.o(36899);
                  return true;
                }
                j.a.this.khc.getViewTreeObserver().removeOnPreDrawListener(this);
                this.Ikb = true;
                int i = com.tencent.mm.cc.a.fromDPToPix(paramContext, 24);
                Bitmap localBitmap = paramString;
                if (localBitmap != null)
                {
                  localObject = localBitmap;
                  if (!localBitmap.isRecycled()) {}
                }
                else
                {
                  localObject = f.aH(paramContext.getResources().getColor(2131100129), i, i);
                }
                int j = ((Bitmap)localObject).getHeight();
                if (i > j)
                {
                  i = j;
                  localObject = f.l(f.aB(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                  j = j.a.this.khc.getHeight();
                  int k = j.a.this.khc.getWidth();
                  i = j;
                  if (j == 0) {
                    i = com.tencent.mm.cc.a.au(paramContext, 2131166036);
                  }
                  j = k;
                  if (k == 0) {
                    j = com.tencent.mm.cc.a.au(paramContext, 2131166037);
                  }
                  if (!j.a.this.IkP) {
                    break label243;
                  }
                }
                label243:
                for (Object localObject = f.b((Bitmap)localObject, 2131231553, j, i);; localObject = f.b((Bitmap)localObject, 2131231589, j, i))
                {
                  localObject = new BitmapDrawable((Bitmap)localObject);
                  j.a.this.khc.setBackgroundDrawable((Drawable)localObject);
                  AppMethodBeat.o(36899);
                  return true;
                  break;
                }
              }
            });
            AppMethodBeat.o(36901);
            return;
            localObject1 = o.aFB();
            paramb = paramb.thumburl;
            localObject2 = this.IiE;
            locala = new com.tencent.mm.av.a.a.c.a();
            i = IkQ;
            locala = locala.de(i, i);
            locala.hKI = 2131689584;
            locala.gLt = true;
            ((com.tencent.mm.av.a.a)localObject1).a(paramb, (ImageView)localObject2, locala.aFT());
          }
        }
      }
      this.IiE.setImageBitmap(BitmapFactory.decodeResource(paramContext.getResources(), 2131233475));
      AppMethodBeat.o(36901);
      return;
    }
    this.IiE.setImageResource(2131233475);
    AppMethodBeat.o(36901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.a
 * JD-Core Version:    0.7.0.1
 */