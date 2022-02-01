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
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.u;
import java.util.List;

public final class l
  extends RelativeLayout
{
  public static Boolean Kml = Boolean.TRUE;
  private final av JFB;
  private View Kmm;
  k.a Kmn;
  private boolean Kmo;
  private Context context;
  private boolean isVisible;
  private View ize;
  
  public l(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37837);
    this.context = null;
    this.ize = null;
    this.Kmm = null;
    this.isVisible = true;
    this.JFB = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(37831);
        ad.d("MicroMsg.FMessageContactView", "refresh timer expired, update");
        l.fHZ();
        l.a(l.this);
        AppMethodBeat.o(37831);
        return false;
      }
    }, true);
    this.Kmn = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(37832);
        ad.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
        if (!l.b(l.this).fkZ()) {
          l.b(l.this).stopTimer();
        }
        paramAnonymousString = l.b(l.this);
        if (l.c(l.this)) {}
        for (long l = 500L;; l = 1000L)
        {
          paramAnonymousString.az(l, l);
          AppMethodBeat.o(37832);
          return;
        }
      }
    };
    this.Kmo = false;
    this.context = paramContext;
    com.tencent.mm.bk.d.aMo().add(this.Kmn);
    fHX();
    init();
    AppMethodBeat.o(37837);
  }
  
  private void a(bf parambf)
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
    if (com.tencent.mm.cc.a.im(this.context))
    {
      this.ize = View.inflate(this.context, 2131494150, this);
      ((TextView)this.ize.findViewById(2131300167)).setText(k.c(this.context, parambf.field_displayName));
      localTextView = (TextView)this.ize.findViewById(2131300166);
      localObject = com.tencent.mm.bk.d.aMn().apM(parambf.field_talker);
      Context localContext = this.context;
      int i = ((bh)localObject).field_type;
      int j = parambf.field_addScene;
      String str = ((bh)localObject).field_msgContent;
      if (((bh)localObject).frm()) {
        break label240;
      }
      bool = true;
      label136:
      localObject = com.tencent.mm.pluginsdk.ui.preference.b.a(localContext, i, j, str, bool);
      if (!bt.isNullOrNil((String)localObject)) {
        break label246;
      }
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      this.Kmm = this.ize.findViewById(2131300149);
      this.ize.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37835);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/FMessageContactView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
          ba.aBQ();
          c.ajl().set(143618, Integer.valueOf(0));
          com.tencent.mm.bs.d.b(l.d(l.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/FMessageContactView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37835);
        }
      });
      a.b.c((ImageView)((MaskLayout)this.ize.findViewById(2131300144)).getContentView(), parambf.field_talker);
      AppMethodBeat.o(37840);
      return;
      this.ize = View.inflate(this.context, 2131494149, this);
      break;
      label240:
      bool = false;
      break label136;
      label246:
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  private void fHW()
  {
    AppMethodBeat.i(37839);
    if (this.context == null)
    {
      ad.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
      AppMethodBeat.o(37839);
      return;
    }
    this.ize = View.inflate(this.context, 2131494147, this);
    this.Kmm = this.ize.findViewById(2131300162);
    Object localObject = this.Kmm.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(com.tencent.mm.cc.a.ay(this.context, 2131165242) * com.tencent.mm.cc.a.il(this.context)));
    this.Kmm.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.ize.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37834);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/FMessageContactView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
        com.tencent.mm.bs.d.b(l.d(l.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/FMessageContactView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37834);
      }
    });
    localObject = (MaskLayout)this.ize.findViewById(2131300144);
    p.aEk();
    Bitmap localBitmap = e.Dc("fmessage");
    ((ImageView)((MaskLayout)localObject).getContentView()).setImageBitmap(localBitmap);
    AppMethodBeat.o(37839);
  }
  
  private static void fHX()
  {
    AppMethodBeat.i(37843);
    int i = com.tencent.mm.bk.d.aMo().frk();
    ad.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      ba.aBQ();
      c.ajl().set(143618, Integer.valueOf(i));
    }
    AppMethodBeat.o(37843);
  }
  
  public static void fHY()
  {
    AppMethodBeat.i(37844);
    ba.aBQ();
    if (c.aiI())
    {
      ba.aBQ();
      if (c.ajl().getInt(143618, 0) > 0) {
        aa.aq("fmessage", 2);
      }
    }
    ba.aBQ();
    c.ajl().set(143618, Integer.valueOf(0));
    AppMethodBeat.o(37844);
  }
  
  private void init()
  {
    AppMethodBeat.i(37838);
    Object localObject = com.tencent.mm.bk.d.aMo().fri();
    int i = ((List)localObject).size();
    ad.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", new Object[] { Integer.valueOf(i) });
    removeAllViews();
    if (i <= 0)
    {
      fHW();
      localObject = this.ize.findViewById(2131300149);
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
      this.Kmm.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(37833);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/FMessageContactView$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          if ((l.d(l.this) instanceof MMActivity)) {
            ((MMActivity)l.d(l.this)).hideVKB();
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/contact/FMessageContactView$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(37833);
          return false;
        }
      });
      i = com.tencent.mm.bk.d.aMo().frk();
      ad.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)this.ize.findViewById(2131300160);
      ((TextView)localObject).setBackgroundResource(u.kE(this.context));
      if (i > 0) {
        break label204;
      }
      ((TextView)localObject).setVisibility(8);
      Kml = Boolean.FALSE;
      AppMethodBeat.o(37838);
      return;
      if (i == 1)
      {
        a((bf)((List)localObject).get(0));
        break;
      }
      iv((List)localObject);
      break;
    }
    label204:
    ((TextView)localObject).setVisibility(0);
    Kml = Boolean.TRUE;
    if (i > 99)
    {
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(2131689744);
      AppMethodBeat.o(37838);
      return;
    }
    ((TextView)localObject).setText(String.valueOf(i));
    ((TextView)localObject).setBackgroundResource(u.aP(this.context, i));
    AppMethodBeat.o(37838);
  }
  
  private void iv(List<bf> paramList)
  {
    AppMethodBeat.i(37841);
    if (this.context == null)
    {
      ad.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
      AppMethodBeat.o(37841);
      return;
    }
    this.ize = View.inflate(this.context, 2131494148, this);
    int i = paramList.size();
    ad.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", new Object[] { Integer.valueOf(i) });
    Object localObject = (bf)paramList.get(0);
    MaskLayout localMaskLayout = (MaskLayout)this.ize.findViewById(2131300144);
    a.b.c((ImageView)localMaskLayout.getContentView(), ((bf)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    localObject = (bf)paramList.get(1);
    localMaskLayout = (MaskLayout)this.ize.findViewById(2131300145);
    a.b.c((ImageView)localMaskLayout.getContentView(), ((bf)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    if (i > 2)
    {
      localObject = (bf)paramList.get(2);
      localMaskLayout = (MaskLayout)this.ize.findViewById(2131300146);
      a.b.c((ImageView)localMaskLayout.getContentView(), ((bf)localObject).field_talker);
      localMaskLayout.setVisibility(0);
    }
    if (i > 3)
    {
      paramList = (bf)paramList.get(3);
      localObject = (MaskLayout)this.ize.findViewById(2131300147);
      a.b.c((ImageView)((MaskLayout)localObject).getContentView(), paramList.field_talker);
      ((MaskLayout)localObject).setVisibility(0);
    }
    this.Kmm = this.ize.findViewById(2131300149);
    this.Kmm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37836);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/FMessageContactView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
        ba.aBQ();
        c.ajl().set(143618, Integer.valueOf(0));
        com.tencent.mm.bs.d.b(l.d(l.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/FMessageContactView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37836);
      }
    });
    AppMethodBeat.o(37841);
  }
  
  public final void setFrontGround(boolean paramBoolean)
  {
    this.Kmo = paramBoolean;
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37842);
    ad.d("MicroMsg.FMessageContactView", "setVisible visible = ".concat(String.valueOf(paramBoolean)));
    View localView = this.ize.findViewById(2131300149);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.l
 * JD-Core Version:    0.7.0.1
 */