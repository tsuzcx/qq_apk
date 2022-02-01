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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.app.d;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.tinker.entry.ApplicationLike;

final class j$a
  extends c.a
{
  public static final int PJW;
  public TextView EVj;
  public MMImageView PHM;
  public boolean PJV;
  public int PJa = 0;
  public TextView jBR;
  public TextView jVO;
  public View lJG;
  
  static
  {
    AppMethodBeat.i(36902);
    PJW = (int)com.tencent.mm.cb.a.getDensity(d.dks.getApplication()) * 64;
    AppMethodBeat.o(36902);
  }
  
  public final a H(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36900);
    super.create(paramView);
    this.PJV = paramBoolean;
    this.timeTV = ((TextView)this.convertView.findViewById(2131298558));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = this.convertView.findViewById(2131298508);
    this.userTV = ((TextView)this.convertView.findViewById(2131298566));
    this.PHM = ((MMImageView)this.convertView.findViewById(2131297031));
    this.jVO = ((TextView)this.convertView.findViewById(2131297032));
    this.jBR = ((TextView)this.convertView.findViewById(2131297030));
    this.EVj = ((TextView)this.convertView.findViewById(2131297028));
    this.lJG = this.convertView.findViewById(2131297029);
    this.PJa = c.kl(MMApplicationContext.getContext());
    AppMethodBeat.o(36900);
    return this;
  }
  
  public final void a(final Context paramContext, k.b paramb, final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36901);
    resetChatBubbleWidth(this.clickArea, this.PJa);
    Object localObject1;
    int i;
    switch (paramb.type)
    {
    default: 
      this.jVO.setText(paramb.description);
      this.jBR.setText(paramb.ixU);
      this.PHM.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = q.bcV();
        paramb = q.bcR().R(paramString, true);
        paramString = this.PHM;
        localObject1 = new com.tencent.mm.av.a.a.c.a();
        ((com.tencent.mm.av.a.a.c.a)localObject1).jbi = 1;
        i = PJW;
        localObject1 = ((com.tencent.mm.av.a.a.c.a)localObject1).dr(i, i);
        ((com.tencent.mm.av.a.a.c.a)localObject1).jbq = 2131689587;
        ((com.tencent.mm.av.a.a.c.a)localObject1).iaT = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.av.a.a.c.a)localObject1).bdv());
        AppMethodBeat.o(36901);
        return;
      }
      break;
    case 16: 
      this.jVO.setText(paramb.description);
      this.jBR.setText(paramb.ixU);
      this.PHM.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = q.bcV();
        paramb = paramb.thumburl;
        paramString = this.PHM;
        localObject1 = new com.tencent.mm.av.a.a.c.a();
        i = PJW;
        localObject1 = ((com.tencent.mm.av.a.a.c.a)localObject1).dr(i, i);
        ((com.tencent.mm.av.a.a.c.a)localObject1).jbq = 2131689587;
        ((com.tencent.mm.av.a.a.c.a)localObject1).iaT = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.av.a.a.c.a)localObject1).bdv());
        AppMethodBeat.o(36901);
        return;
      }
      this.PHM.setImageResource(2131234278);
      AppMethodBeat.o(36901);
      return;
    case 34: 
      if ((paramb.title != null) && (paramb.title.length() > 0))
      {
        this.jVO.setVisibility(0);
        this.jVO.setText(paramb.title);
        if (!Util.isNullOrNil(paramb.iyd))
        {
          this.jVO.setTextColor(Util.convertStringToRGB(paramb.iyd, paramContext.getResources().getColor(2131100904)));
          this.jBR.setMaxLines(2);
          this.jBR.setVisibility(0);
          this.jBR.setText(paramb.description);
          if (Util.isNullOrNil(paramb.iye)) {
            break label605;
          }
          this.jBR.setTextColor(Util.convertStringToRGB(paramb.iye, paramContext.getResources().getColor(2131100571)));
          label410:
          if (Util.isNullOrNil(paramb.ixZ)) {
            break label624;
          }
          this.EVj.setText(paramb.ixZ);
        }
      }
      for (;;)
      {
        if (paramBoolean)
        {
          Object localObject2;
          com.tencent.mm.av.a.a.c.a locala;
          if (!Util.isNullOrNil(paramb.iyc))
          {
            paramString = q.bcV();
            localObject1 = paramb.thumburl;
            localObject2 = this.PHM;
            locala = new com.tencent.mm.av.a.a.c.a();
            i = PJW;
            locala = locala.dr(i, i);
            locala.jbq = 2131689587;
            locala.iaT = true;
            paramString.a((String)localObject1, (ImageView)localObject2, locala.bdv());
            paramString = q.bcV();
            paramb = paramb.iyc;
            localObject1 = new ImageView(paramContext);
            localObject2 = new com.tencent.mm.av.a.a.c.a();
            ((com.tencent.mm.av.a.a.c.a)localObject2).jbf = true;
            paramString.a(paramb, (ImageView)localObject1, ((com.tencent.mm.av.a.a.c.a)localObject2).bdv(), new h()
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
                  j.a.this.lJG.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                  {
                    public final boolean onPreDraw()
                    {
                      AppMethodBeat.i(36897);
                      j.a.this.lJG.getViewTreeObserver().removeOnPreDrawListener(this);
                      int j = j.a.this.lJG.getHeight();
                      int k = j.a.this.lJG.getWidth();
                      int i = j;
                      if (j == 0) {
                        i = com.tencent.mm.cb.a.aG(j.a.1.this.val$context, 2131166076);
                      }
                      j = k;
                      if (k == 0) {
                        j = com.tencent.mm.cb.a.aG(j.a.1.this.val$context, 2131166077);
                      }
                      if (j.a.this.PJV) {}
                      for (Object localObject = BitmapUtil.createMaskImage(paramAnonymousString, 2131231617, j, i);; localObject = BitmapUtil.createMaskImage(paramAnonymousString, 2131231653, j, i))
                      {
                        localObject = new BitmapDrawable((Bitmap)localObject);
                        j.a.this.lJG.setBackgroundDrawable((Drawable)localObject);
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
            this.jVO.setTextColor(paramContext.getResources().getColor(2131100904));
            break;
            this.jVO.setVisibility(8);
            break;
            label605:
            this.jBR.setTextColor(paramContext.getResources().getColor(2131100571));
            break label410;
            label624:
            this.EVj.setText(2131757418);
            continue;
          }
          paramString = q.bcR().a(paramString, com.tencent.mm.cb.a.getDensity(paramContext), false);
          if ((paramString != null) && (!paramString.isRecycled()))
          {
            paramb = BitmapUtil.getRoundedCornerBitmap(paramString, false, paramString.getWidth() / 2);
            this.PHM.setImageBitmap(paramb);
          }
          for (;;)
          {
            this.lJG.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
            {
              private boolean qCs = false;
              
              public final boolean onPreDraw()
              {
                AppMethodBeat.i(36899);
                if (this.qCs)
                {
                  j.a.this.lJG.getViewTreeObserver().removeOnPreDrawListener(this);
                  AppMethodBeat.o(36899);
                  return true;
                }
                j.a.this.lJG.getViewTreeObserver().removeOnPreDrawListener(this);
                this.qCs = true;
                int i = com.tencent.mm.cb.a.fromDPToPix(paramContext, 24);
                Bitmap localBitmap = paramString;
                if (localBitmap != null)
                {
                  localObject = localBitmap;
                  if (!localBitmap.isRecycled()) {}
                }
                else
                {
                  localObject = BitmapUtil.createColorBitmap(paramContext.getResources().getColor(2131100161), i, i);
                }
                int j = ((Bitmap)localObject).getHeight();
                if (i > j)
                {
                  i = j;
                  localObject = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true), 0.9F), 20);
                  j = j.a.this.lJG.getHeight();
                  int k = j.a.this.lJG.getWidth();
                  i = j;
                  if (j == 0) {
                    i = com.tencent.mm.cb.a.aG(paramContext, 2131166076);
                  }
                  j = k;
                  if (k == 0) {
                    j = com.tencent.mm.cb.a.aG(paramContext, 2131166077);
                  }
                  if (!j.a.this.PJV) {
                    break label245;
                  }
                }
                label245:
                for (Object localObject = BitmapUtil.createMaskImage((Bitmap)localObject, 2131231617, j, i);; localObject = BitmapUtil.createMaskImage((Bitmap)localObject, 2131231653, j, i))
                {
                  localObject = new BitmapDrawable((Bitmap)localObject);
                  j.a.this.lJG.setBackgroundDrawable((Drawable)localObject);
                  AppMethodBeat.o(36899);
                  return true;
                  break;
                }
              }
            });
            AppMethodBeat.o(36901);
            return;
            localObject1 = q.bcV();
            paramb = paramb.thumburl;
            localObject2 = this.PHM;
            locala = new com.tencent.mm.av.a.a.c.a();
            i = PJW;
            locala = locala.dr(i, i);
            locala.jbq = 2131689587;
            locala.iaT = true;
            ((com.tencent.mm.av.a.a)localObject1).a(paramb, (ImageView)localObject2, locala.bdv());
          }
        }
      }
      this.PHM.setImageBitmap(BitmapFactory.decodeResource(paramContext.getResources(), 2131234278));
      AppMethodBeat.o(36901);
      return;
    }
    this.PHM.setImageResource(2131234278);
    AppMethodBeat.o(36901);
  }
  
  public final View getMainContainerView()
  {
    return this.convertView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.a
 * JD-Core Version:    0.7.0.1
 */