package com.tencent.mm.ui.contact;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.bj.d;
import com.tencent.mm.cb.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.v;
import java.util.List;

public final class l
  extends RelativeLayout
{
  public static Boolean PVD = Boolean.TRUE;
  private View PVE;
  MStorage.IOnStorageChange PVF;
  private boolean PVG;
  private final MTimerHandler PlP;
  private Context context;
  private boolean isVisible;
  private View jxm;
  
  public l(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37837);
    this.context = null;
    this.jxm = null;
    this.PVE = null;
    this.isVisible = true;
    this.PlP = new MTimerHandler(new l.1(this), true);
    this.PVF = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(37832);
        Log.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
        if (!l.b(l.this).stopped()) {
          l.b(l.this).stopTimer();
        }
        paramAnonymousString = l.b(l.this);
        if (l.c(l.this)) {}
        for (long l = 500L;; l = 1000L)
        {
          paramAnonymousString.startTimer(l);
          AppMethodBeat.o(37832);
          return;
        }
      }
    };
    this.PVG = false;
    this.context = paramContext;
    d.bgN().add(this.PVF);
    gUJ();
    init();
    AppMethodBeat.o(37837);
  }
  
  private void a(bl parambl)
  {
    AppMethodBeat.i(37840);
    if (this.context == null)
    {
      Log.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
      AppMethodBeat.o(37840);
      return;
    }
    TextView localTextView;
    Object localObject;
    boolean bool;
    if (a.jk(this.context))
    {
      this.jxm = View.inflate(this.context, 2131494705, this);
      ((TextView)this.jxm.findViewById(2131301618)).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.context, parambl.field_displayName));
      localTextView = (TextView)this.jxm.findViewById(2131301617);
      localObject = d.bgM().aEm(parambl.field_talker);
      Context localContext = this.context;
      int i = ((bn)localObject).field_type;
      int j = parambl.field_addScene;
      String str = ((bn)localObject).field_msgContent;
      if (((bn)localObject).gCT()) {
        break label240;
      }
      bool = true;
      label136:
      localObject = b.a(localContext, i, j, str, bool);
      if (!Util.isNullOrNil((String)localObject)) {
        break label246;
      }
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      this.PVE = this.jxm.findViewById(2131301600);
      this.jxm.setOnClickListener(new l.5(this));
      a.b.c((ImageView)((MaskLayout)this.jxm.findViewById(2131301595)).getContentView(), parambl.field_talker);
      AppMethodBeat.o(37840);
      return;
      this.jxm = View.inflate(this.context, 2131494704, this);
      break;
      label240:
      bool = false;
      break label136;
      label246:
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  private void gUI()
  {
    AppMethodBeat.i(37839);
    if (this.context == null)
    {
      Log.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
      AppMethodBeat.o(37839);
      return;
    }
    this.jxm = View.inflate(this.context, 2131494702, this);
    this.PVE = this.jxm.findViewById(2131301613);
    Object localObject = this.PVE.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(a.aH(this.context, 2131165246) * a.jj(this.context)));
    this.PVE.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jxm.setOnClickListener(new l.4(this));
    localObject = (MaskLayout)this.jxm.findViewById(2131301595);
    p.aYn();
    Bitmap localBitmap = e.Mp("fmessage");
    ((ImageView)((MaskLayout)localObject).getContentView()).setImageBitmap(localBitmap);
    AppMethodBeat.o(37839);
  }
  
  private static void gUJ()
  {
    AppMethodBeat.i(37843);
    int i = d.bgN().gCR();
    Log.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      bg.aVF();
      c.azQ().set(143618, Integer.valueOf(i));
    }
    AppMethodBeat.o(37843);
  }
  
  public static void gUK()
  {
    AppMethodBeat.i(37844);
    bg.aVF();
    if (c.azn())
    {
      bg.aVF();
      if (c.azQ().getInt(143618, 0) > 0) {
        ab.av("fmessage", 2);
      }
    }
    bg.aVF();
    c.azQ().set(143618, Integer.valueOf(0));
    AppMethodBeat.o(37844);
  }
  
  private void init()
  {
    AppMethodBeat.i(37838);
    Object localObject = d.bgN().gCP();
    int i = ((List)localObject).size();
    Log.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", new Object[] { Integer.valueOf(i) });
    removeAllViews();
    if (i <= 0)
    {
      gUI();
      localObject = this.jxm.findViewById(2131301600);
      if (localObject != null) {
        if (!this.isVisible) {
          break label198;
        }
      }
    }
    label198:
    for (i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      this.PVE.setOnTouchListener(new l.3(this));
      i = d.bgN().gCR();
      Log.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)this.jxm.findViewById(2131301611);
      ((TextView)localObject).setBackgroundResource(v.kH(this.context));
      if (i > 0) {
        break label204;
      }
      ((TextView)localObject).setVisibility(8);
      PVD = Boolean.FALSE;
      AppMethodBeat.o(37838);
      return;
      if (i == 1)
      {
        a((bl)((List)localObject).get(0));
        break;
      }
      jI((List)localObject);
      break;
    }
    label204:
    ((TextView)localObject).setVisibility(0);
    PVD = Boolean.TRUE;
    if (i > 99)
    {
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(2131689753);
      AppMethodBeat.o(37838);
      return;
    }
    ((TextView)localObject).setText(String.valueOf(i));
    ((TextView)localObject).setBackgroundResource(v.aQ(this.context, i));
    AppMethodBeat.o(37838);
  }
  
  private void jI(List<bl> paramList)
  {
    AppMethodBeat.i(37841);
    if (this.context == null)
    {
      Log.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
      AppMethodBeat.o(37841);
      return;
    }
    this.jxm = View.inflate(this.context, 2131494703, this);
    int i = paramList.size();
    Log.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", new Object[] { Integer.valueOf(i) });
    Object localObject = (bl)paramList.get(0);
    MaskLayout localMaskLayout = (MaskLayout)this.jxm.findViewById(2131301595);
    a.b.c((ImageView)localMaskLayout.getContentView(), ((bl)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    localObject = (bl)paramList.get(1);
    localMaskLayout = (MaskLayout)this.jxm.findViewById(2131301596);
    a.b.c((ImageView)localMaskLayout.getContentView(), ((bl)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    if (i > 2)
    {
      localObject = (bl)paramList.get(2);
      localMaskLayout = (MaskLayout)this.jxm.findViewById(2131301597);
      a.b.c((ImageView)localMaskLayout.getContentView(), ((bl)localObject).field_talker);
      localMaskLayout.setVisibility(0);
    }
    if (i > 3)
    {
      paramList = (bl)paramList.get(3);
      localObject = (MaskLayout)this.jxm.findViewById(2131301598);
      a.b.c((ImageView)((MaskLayout)localObject).getContentView(), paramList.field_talker);
      ((MaskLayout)localObject).setVisibility(0);
    }
    this.PVE = this.jxm.findViewById(2131301600);
    this.PVE.setOnClickListener(new l.6(this));
    AppMethodBeat.o(37841);
  }
  
  public final void setFrontGround(boolean paramBoolean)
  {
    this.PVG = paramBoolean;
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37842);
    Log.d("MicroMsg.FMessageContactView", "setVisible visible = ".concat(String.valueOf(paramBoolean)));
    View localView = this.jxm.findViewById(2131301600);
    if (localView != null) {
      if (!paramBoolean) {
        break label58;
      }
    }
    label58:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      this.isVisible = paramBoolean;
      AppMethodBeat.o(37842);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.l
 * JD-Core Version:    0.7.0.1
 */