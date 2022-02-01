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
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.u;
import java.util.List;

public final class l
  extends RelativeLayout
{
  public static Boolean KIF = Boolean.TRUE;
  private View KIG;
  k.a KIH;
  private boolean KII;
  private final aw Kas;
  private Context context;
  private View iBX;
  private boolean isVisible;
  
  public l(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37837);
    this.context = null;
    this.iBX = null;
    this.KIG = null;
    this.isVisible = true;
    this.Kas = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(37831);
        ae.d("MicroMsg.FMessageContactView", "refresh timer expired, update");
        l.fMr();
        l.a(l.this);
        AppMethodBeat.o(37831);
        return false;
      }
    }, true);
    this.KIH = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(37832);
        ae.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
        if (!l.b(l.this).foU()) {
          l.b(l.this).stopTimer();
        }
        paramAnonymousString = l.b(l.this);
        if (l.c(l.this)) {}
        for (long l = 500L;; l = 1000L)
        {
          paramAnonymousString.ay(l, l);
          AppMethodBeat.o(37832);
          return;
        }
      }
    };
    this.KII = false;
    this.context = paramContext;
    com.tencent.mm.bj.d.aMM().add(this.KIH);
    fMp();
    init();
    AppMethodBeat.o(37837);
  }
  
  private void a(bg parambg)
  {
    AppMethodBeat.i(37840);
    if (this.context == null)
    {
      ae.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
      AppMethodBeat.o(37840);
      return;
    }
    TextView localTextView;
    Object localObject;
    boolean bool;
    if (com.tencent.mm.cb.a.ir(this.context))
    {
      this.iBX = View.inflate(this.context, 2131494150, this);
      ((TextView)this.iBX.findViewById(2131300167)).setText(k.c(this.context, parambg.field_displayName));
      localTextView = (TextView)this.iBX.findViewById(2131300166);
      localObject = com.tencent.mm.bj.d.aML().aqR(parambg.field_talker);
      Context localContext = this.context;
      int i = ((bi)localObject).field_type;
      int j = parambg.field_addScene;
      String str = ((bi)localObject).field_msgContent;
      if (((bi)localObject).fvm()) {
        break label240;
      }
      bool = true;
      label136:
      localObject = com.tencent.mm.pluginsdk.ui.preference.b.a(localContext, i, j, str, bool);
      if (!bu.isNullOrNil((String)localObject)) {
        break label246;
      }
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      this.KIG = this.iBX.findViewById(2131300149);
      this.iBX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37835);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/FMessageContactView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
          bc.aCg();
          c.ajA().set(143618, Integer.valueOf(0));
          com.tencent.mm.br.d.b(l.d(l.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/FMessageContactView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37835);
        }
      });
      a.b.c((ImageView)((MaskLayout)this.iBX.findViewById(2131300144)).getContentView(), parambg.field_talker);
      AppMethodBeat.o(37840);
      return;
      this.iBX = View.inflate(this.context, 2131494149, this);
      break;
      label240:
      bool = false;
      break label136;
      label246:
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  private void fMo()
  {
    AppMethodBeat.i(37839);
    if (this.context == null)
    {
      ae.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
      AppMethodBeat.o(37839);
      return;
    }
    this.iBX = View.inflate(this.context, 2131494147, this);
    this.KIG = this.iBX.findViewById(2131300162);
    Object localObject = this.KIG.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(com.tencent.mm.cb.a.ay(this.context, 2131165242) * com.tencent.mm.cb.a.iq(this.context)));
    this.KIG.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.iBX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37834);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/FMessageContactView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
        com.tencent.mm.br.d.b(l.d(l.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/FMessageContactView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37834);
      }
    });
    localObject = (MaskLayout)this.iBX.findViewById(2131300144);
    p.aEA();
    Bitmap localBitmap = e.DE("fmessage");
    ((ImageView)((MaskLayout)localObject).getContentView()).setImageBitmap(localBitmap);
    AppMethodBeat.o(37839);
  }
  
  private static void fMp()
  {
    AppMethodBeat.i(37843);
    int i = com.tencent.mm.bj.d.aMM().fvk();
    ae.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      bc.aCg();
      c.ajA().set(143618, Integer.valueOf(i));
    }
    AppMethodBeat.o(37843);
  }
  
  public static void fMq()
  {
    AppMethodBeat.i(37844);
    bc.aCg();
    if (c.aiX())
    {
      bc.aCg();
      if (c.ajA().getInt(143618, 0) > 0) {
        ab.ar("fmessage", 2);
      }
    }
    bc.aCg();
    c.ajA().set(143618, Integer.valueOf(0));
    AppMethodBeat.o(37844);
  }
  
  private void iF(List<bg> paramList)
  {
    AppMethodBeat.i(37841);
    if (this.context == null)
    {
      ae.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
      AppMethodBeat.o(37841);
      return;
    }
    this.iBX = View.inflate(this.context, 2131494148, this);
    int i = paramList.size();
    ae.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", new Object[] { Integer.valueOf(i) });
    Object localObject = (bg)paramList.get(0);
    MaskLayout localMaskLayout = (MaskLayout)this.iBX.findViewById(2131300144);
    a.b.c((ImageView)localMaskLayout.getContentView(), ((bg)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    localObject = (bg)paramList.get(1);
    localMaskLayout = (MaskLayout)this.iBX.findViewById(2131300145);
    a.b.c((ImageView)localMaskLayout.getContentView(), ((bg)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    if (i > 2)
    {
      localObject = (bg)paramList.get(2);
      localMaskLayout = (MaskLayout)this.iBX.findViewById(2131300146);
      a.b.c((ImageView)localMaskLayout.getContentView(), ((bg)localObject).field_talker);
      localMaskLayout.setVisibility(0);
    }
    if (i > 3)
    {
      paramList = (bg)paramList.get(3);
      localObject = (MaskLayout)this.iBX.findViewById(2131300147);
      a.b.c((ImageView)((MaskLayout)localObject).getContentView(), paramList.field_talker);
      ((MaskLayout)localObject).setVisibility(0);
    }
    this.KIG = this.iBX.findViewById(2131300149);
    this.KIG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37836);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/FMessageContactView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
        bc.aCg();
        c.ajA().set(143618, Integer.valueOf(0));
        com.tencent.mm.br.d.b(l.d(l.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/FMessageContactView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37836);
      }
    });
    AppMethodBeat.o(37841);
  }
  
  private void init()
  {
    AppMethodBeat.i(37838);
    Object localObject = com.tencent.mm.bj.d.aMM().fvi();
    int i = ((List)localObject).size();
    ae.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", new Object[] { Integer.valueOf(i) });
    removeAllViews();
    if (i <= 0)
    {
      fMo();
      localObject = this.iBX.findViewById(2131300149);
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
      this.KIG.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(37833);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/FMessageContactView$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          if ((l.d(l.this) instanceof MMActivity)) {
            ((MMActivity)l.d(l.this)).hideVKB();
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/contact/FMessageContactView$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(37833);
          return false;
        }
      });
      i = com.tencent.mm.bj.d.aMM().fvk();
      ae.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)this.iBX.findViewById(2131300160);
      ((TextView)localObject).setBackgroundResource(u.kL(this.context));
      if (i > 0) {
        break label204;
      }
      ((TextView)localObject).setVisibility(8);
      KIF = Boolean.FALSE;
      AppMethodBeat.o(37838);
      return;
      if (i == 1)
      {
        a((bg)((List)localObject).get(0));
        break;
      }
      iF((List)localObject);
      break;
    }
    label204:
    ((TextView)localObject).setVisibility(0);
    KIF = Boolean.TRUE;
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
  
  public final void setFrontGround(boolean paramBoolean)
  {
    this.KII = paramBoolean;
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37842);
    ae.d("MicroMsg.FMessageContactView", "setVisible visible = ".concat(String.valueOf(paramBoolean)));
    View localView = this.iBX.findViewById(2131300149);
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