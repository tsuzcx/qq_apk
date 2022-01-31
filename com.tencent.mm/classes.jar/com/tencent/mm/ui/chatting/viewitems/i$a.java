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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.app.b;
import com.tencent.mm.at.g;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMImageView;
import com.tencent.tinker.entry.ApplicationLike;

final class i$a
  extends c.a
{
  public static final int zTH;
  public TextView gpL;
  public TextView gpM;
  public View iDQ;
  public TextView sfX;
  public MMImageView zRM;
  public int zSN = 0;
  public boolean zTG;
  
  static
  {
    AppMethodBeat.i(32918);
    zTH = (int)com.tencent.mm.cb.a.getDensity(b.bXD.getApplication()) * 64;
    AppMethodBeat.o(32918);
  }
  
  public final a B(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(32916);
    super.eV(paramView);
    this.zTG = paramBoolean;
    this.ekh = ((TextView)this.ngZ.findViewById(2131820587));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = this.ngZ.findViewById(2131820586);
    this.qFY = ((TextView)this.ngZ.findViewById(2131821122));
    this.zRM = ((MMImageView)this.ngZ.findViewById(2131822662));
    this.gpL = ((TextView)this.ngZ.findViewById(2131822663));
    this.gpM = ((TextView)this.ngZ.findViewById(2131822664));
    this.sfX = ((TextView)this.ngZ.findViewById(2131822665));
    this.iDQ = this.ngZ.findViewById(2131822661);
    this.zSN = c.io(ah.getContext());
    AppMethodBeat.o(32916);
    return this;
  }
  
  public final void a(Context paramContext, j.b paramb, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(32917);
    ar(this.jYu, this.zSN);
    Object localObject1;
    int i;
    switch (paramb.type)
    {
    default: 
      this.gpL.setText(paramb.description);
      this.gpM.setText(paramb.fhK);
      this.zRM.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = o.ahG();
        paramb = o.ahC().J(paramString, true);
        paramString = this.zRM;
        localObject1 = new com.tencent.mm.at.a.a.c.a();
        ((com.tencent.mm.at.a.a.c.a)localObject1).fHt = 1;
        i = zTH;
        localObject1 = ((com.tencent.mm.at.a.a.c.a)localObject1).cx(i, i);
        ((com.tencent.mm.at.a.a.c.a)localObject1).eNY = 2131230829;
        ((com.tencent.mm.at.a.a.c.a)localObject1).eOk = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.at.a.a.c.a)localObject1).ahY());
        AppMethodBeat.o(32917);
        return;
      }
      break;
    case 16: 
      this.gpL.setText(paramb.description);
      this.gpM.setText(paramb.fhK);
      this.zRM.setVisibility(0);
      if (paramBoolean)
      {
        paramContext = o.ahG();
        paramb = paramb.thumburl;
        paramString = this.zRM;
        localObject1 = new com.tencent.mm.at.a.a.c.a();
        i = zTH;
        localObject1 = ((com.tencent.mm.at.a.a.c.a)localObject1).cx(i, i);
        ((com.tencent.mm.at.a.a.c.a)localObject1).eNY = 2131230829;
        ((com.tencent.mm.at.a.a.c.a)localObject1).eOk = true;
        paramContext.a(paramb, paramString, ((com.tencent.mm.at.a.a.c.a)localObject1).ahY());
        AppMethodBeat.o(32917);
        return;
      }
      this.zRM.setImageResource(2130839820);
      AppMethodBeat.o(32917);
      return;
    case 34: 
      if ((paramb.title != null) && (paramb.title.length() > 0))
      {
        this.gpL.setVisibility(0);
        this.gpL.setText(paramb.title);
        if (!bo.isNullOrNil(paramb.fhT))
        {
          this.gpL.setTextColor(bo.bS(paramb.fhT, paramContext.getResources().getColor(2131689763)));
          this.gpM.setMaxLines(2);
          this.gpM.setVisibility(0);
          this.gpM.setText(paramb.description);
          if (bo.isNullOrNil(paramb.fhU)) {
            break label605;
          }
          this.gpM.setTextColor(bo.bS(paramb.fhU, paramContext.getResources().getColor(2131690143)));
          label410:
          if (bo.isNullOrNil(paramb.fhP)) {
            break label624;
          }
          this.sfX.setText(paramb.fhP);
        }
      }
      for (;;)
      {
        if (paramBoolean)
        {
          Object localObject2;
          com.tencent.mm.at.a.a.c.a locala;
          if (!bo.isNullOrNil(paramb.fhS))
          {
            paramString = o.ahG();
            localObject1 = paramb.thumburl;
            localObject2 = this.zRM;
            locala = new com.tencent.mm.at.a.a.c.a();
            i = zTH;
            locala = locala.cx(i, i);
            locala.eNY = 2131230829;
            locala.eOk = true;
            paramString.a((String)localObject1, (ImageView)localObject2, locala.ahY());
            paramString = o.ahG();
            paramb = paramb.fhS;
            localObject1 = new ImageView(paramContext);
            localObject2 = new com.tencent.mm.at.a.a.c.a();
            ((com.tencent.mm.at.a.a.c.a)localObject2).eNM = true;
            paramString.a(paramb, (ImageView)localObject1, ((com.tencent.mm.at.a.a.c.a)localObject2).ahY(), new i.a.1(this, paramContext));
            AppMethodBeat.o(32917);
            return;
            this.gpL.setTextColor(paramContext.getResources().getColor(2131689763));
            break;
            this.gpL.setVisibility(8);
            break;
            label605:
            this.gpM.setTextColor(paramContext.getResources().getColor(2131690143));
            break label410;
            label624:
            this.sfX.setText(2131298217);
            continue;
          }
          paramString = o.ahC().a(paramString, com.tencent.mm.cb.a.getDensity(paramContext), false);
          if ((paramString != null) && (!paramString.isRecycled()))
          {
            paramb = d.a(paramString, false, paramString.getWidth() / 2);
            this.zRM.setImageBitmap(paramb);
          }
          for (;;)
          {
            this.iDQ.getViewTreeObserver().addOnPreDrawListener(new i.a.2(this, paramContext, paramString));
            AppMethodBeat.o(32917);
            return;
            localObject1 = o.ahG();
            paramb = paramb.thumburl;
            localObject2 = this.zRM;
            locala = new com.tencent.mm.at.a.a.c.a();
            i = zTH;
            locala = locala.cx(i, i);
            locala.eNY = 2131230829;
            locala.eOk = true;
            ((com.tencent.mm.at.a.a)localObject1).a(paramb, (ImageView)localObject2, locala.ahY());
          }
        }
      }
      this.zRM.setImageBitmap(BitmapFactory.decodeResource(paramContext.getResources(), 2130839820));
      AppMethodBeat.o(32917);
      return;
    }
    this.zRM.setImageResource(2130839820);
    AppMethodBeat.o(32917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.a
 * JD-Core Version:    0.7.0.1
 */