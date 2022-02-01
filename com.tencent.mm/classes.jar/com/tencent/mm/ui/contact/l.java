package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.p;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.u;
import java.util.List;

public final class l
  extends RelativeLayout
{
  public static Boolean GVr = Boolean.TRUE;
  private View GVs;
  k.a GVt;
  private boolean GVu;
  private final av GrR;
  private Context context;
  private View hFi;
  private boolean isVisible;
  
  public l(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37837);
    this.context = null;
    this.hFi = null;
    this.GVs = null;
    this.isVisible = true;
    this.GrR = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(37831);
        ad.d("MicroMsg.FMessageContactView", "refresh timer expired, update");
        l.fbv();
        l.a(l.this);
        AppMethodBeat.o(37831);
        return false;
      }
    }, true);
    this.GVt = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(37832);
        ad.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
        if (!l.b(l.this).eFX()) {
          l.b(l.this).stopTimer();
        }
        paramAnonymousString = l.b(l.this);
        if (l.c(l.this)) {}
        for (long l = 500L;; l = 1000L)
        {
          paramAnonymousString.av(l, l);
          AppMethodBeat.o(37832);
          return;
        }
      }
    };
    this.GVu = false;
    this.context = paramContext;
    com.tencent.mm.bk.d.aCo().add(this.GVt);
    fbt();
    init();
    AppMethodBeat.o(37837);
  }
  
  private void a(ay paramay)
  {
    AppMethodBeat.i(37840);
    if (this.context == null)
    {
      ad.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
      AppMethodBeat.o(37840);
      return;
    }
    TextView localTextView;
    Object localObject;
    boolean bool;
    if (a.hS(this.context))
    {
      this.hFi = View.inflate(this.context, 2131494150, this);
      ((TextView)this.hFi.findViewById(2131300167)).setText(k.c(this.context, paramay.field_displayName));
      localTextView = (TextView)this.hFi.findViewById(2131300166);
      localObject = com.tencent.mm.bk.d.aCn().agg(paramay.field_talker);
      Context localContext = this.context;
      int i = ((ba)localObject).field_type;
      int j = paramay.field_addScene;
      String str = ((ba)localObject).field_msgContent;
      if (((ba)localObject).eLF()) {
        break label240;
      }
      bool = true;
      label136:
      localObject = b.a(localContext, i, j, str, bool);
      if (!bt.isNullOrNil((String)localObject)) {
        break label246;
      }
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      this.GVs = this.hFi.findViewById(2131300149);
      this.hFi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37835);
          ad.d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
          com.tencent.mm.model.az.arV();
          c.afk().set(143618, Integer.valueOf(0));
          com.tencent.mm.bs.d.b(l.d(l.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
          AppMethodBeat.o(37835);
        }
      });
      a.b.c((ImageView)((MaskLayout)this.hFi.findViewById(2131300144)).getContentView(), paramay.field_talker);
      AppMethodBeat.o(37840);
      return;
      this.hFi = View.inflate(this.context, 2131494149, this);
      break;
      label240:
      bool = false;
      break label136;
      label246:
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  private void fbs()
  {
    AppMethodBeat.i(37839);
    if (this.context == null)
    {
      ad.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
      AppMethodBeat.o(37839);
      return;
    }
    this.hFi = View.inflate(this.context, 2131494147, this);
    this.GVs = this.hFi.findViewById(2131300162);
    Object localObject = this.GVs.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(a.ap(this.context, 2131165242) * a.hR(this.context)));
    this.GVs.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.hFi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37834);
        ad.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
        com.tencent.mm.bs.d.b(l.d(l.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
        AppMethodBeat.o(37834);
      }
    });
    localObject = (MaskLayout)this.hFi.findViewById(2131300144);
    p.auq();
    Bitmap localBitmap = e.vX("fmessage");
    ((ImageView)((MaskLayout)localObject).getContentView()).setImageBitmap(localBitmap);
    AppMethodBeat.o(37839);
  }
  
  private static void fbt()
  {
    AppMethodBeat.i(37843);
    int i = com.tencent.mm.bk.d.aCo().eLD();
    ad.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      com.tencent.mm.model.az.arV();
      c.afk().set(143618, Integer.valueOf(i));
    }
    AppMethodBeat.o(37843);
  }
  
  public static void fbu()
  {
    AppMethodBeat.i(37844);
    com.tencent.mm.model.az.arV();
    if (c.aeG())
    {
      com.tencent.mm.model.az.arV();
      if (c.afk().getInt(143618, 0) > 0) {
        aa.ak("fmessage", 2);
      }
    }
    com.tencent.mm.model.az.arV();
    c.afk().set(143618, Integer.valueOf(0));
    AppMethodBeat.o(37844);
  }
  
  private void hW(List<ay> paramList)
  {
    AppMethodBeat.i(37841);
    if (this.context == null)
    {
      ad.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
      AppMethodBeat.o(37841);
      return;
    }
    this.hFi = View.inflate(this.context, 2131494148, this);
    int i = paramList.size();
    ad.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", new Object[] { Integer.valueOf(i) });
    Object localObject = (ay)paramList.get(0);
    MaskLayout localMaskLayout = (MaskLayout)this.hFi.findViewById(2131300144);
    a.b.c((ImageView)localMaskLayout.getContentView(), ((ay)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    localObject = (ay)paramList.get(1);
    localMaskLayout = (MaskLayout)this.hFi.findViewById(2131300145);
    a.b.c((ImageView)localMaskLayout.getContentView(), ((ay)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    if (i > 2)
    {
      localObject = (ay)paramList.get(2);
      localMaskLayout = (MaskLayout)this.hFi.findViewById(2131300146);
      a.b.c((ImageView)localMaskLayout.getContentView(), ((ay)localObject).field_talker);
      localMaskLayout.setVisibility(0);
    }
    if (i > 3)
    {
      paramList = (ay)paramList.get(3);
      localObject = (MaskLayout)this.hFi.findViewById(2131300147);
      a.b.c((ImageView)((MaskLayout)localObject).getContentView(), paramList.field_talker);
      ((MaskLayout)localObject).setVisibility(0);
    }
    this.GVs = this.hFi.findViewById(2131300149);
    this.GVs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37836);
        ad.d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
        com.tencent.mm.model.az.arV();
        c.afk().set(143618, Integer.valueOf(0));
        com.tencent.mm.bs.d.b(l.d(l.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
        AppMethodBeat.o(37836);
      }
    });
    AppMethodBeat.o(37841);
  }
  
  private void init()
  {
    AppMethodBeat.i(37838);
    Object localObject = com.tencent.mm.bk.d.aCo().eLB();
    int i = ((List)localObject).size();
    ad.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", new Object[] { Integer.valueOf(i) });
    removeAllViews();
    if (i <= 0)
    {
      fbs();
      localObject = this.hFi.findViewById(2131300149);
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
      this.GVs.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(37833);
          if ((l.d(l.this) instanceof MMActivity)) {
            ((MMActivity)l.d(l.this)).hideVKB();
          }
          AppMethodBeat.o(37833);
          return false;
        }
      });
      i = com.tencent.mm.bk.d.aCo().eLD();
      ad.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)this.hFi.findViewById(2131300160);
      ((TextView)localObject).setBackgroundResource(u.kh(this.context));
      if (i > 0) {
        break label204;
      }
      ((TextView)localObject).setVisibility(8);
      GVr = Boolean.FALSE;
      AppMethodBeat.o(37838);
      return;
      if (i == 1)
      {
        a((ay)((List)localObject).get(0));
        break;
      }
      hW((List)localObject);
      break;
    }
    label204:
    ((TextView)localObject).setVisibility(0);
    GVr = Boolean.TRUE;
    if (i > 99)
    {
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(2131689744);
      AppMethodBeat.o(37838);
      return;
    }
    ((TextView)localObject).setText(String.valueOf(i));
    ((TextView)localObject).setBackgroundResource(u.aG(this.context, i));
    AppMethodBeat.o(37838);
  }
  
  public final void setFrontGround(boolean paramBoolean)
  {
    this.GVu = paramBoolean;
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37842);
    ad.d("MicroMsg.FMessageContactView", "setVisible visible = ".concat(String.valueOf(paramBoolean)));
    View localView = this.hFi.findViewById(2131300149);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.l
 * JD-Core Version:    0.7.0.1
 */