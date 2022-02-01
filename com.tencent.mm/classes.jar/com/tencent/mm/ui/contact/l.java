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
import com.tencent.mm.cc.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.u;
import java.util.List;

public final class l
  extends RelativeLayout
{
  public static Boolean IvF = Boolean.TRUE;
  private final au HRJ;
  private View IvG;
  k.a IvH;
  private boolean IvI;
  private Context context;
  private View ifK;
  private boolean isVisible;
  
  public l(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37837);
    this.context = null;
    this.ifK = null;
    this.IvG = null;
    this.isVisible = true;
    this.HRJ = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(37831);
        ac.d("MicroMsg.FMessageContactView", "refresh timer expired, update");
        l.frm();
        l.a(l.this);
        AppMethodBeat.o(37831);
        return false;
      }
    }, true);
    this.IvH = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(37832);
        ac.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
        if (!l.b(l.this).eVs()) {
          l.b(l.this).stopTimer();
        }
        paramAnonymousString = l.b(l.this);
        if (l.c(l.this)) {}
        for (long l = 500L;; l = 1000L)
        {
          paramAnonymousString.au(l, l);
          AppMethodBeat.o(37832);
          return;
        }
      }
    };
    this.IvI = false;
    this.context = paramContext;
    com.tencent.mm.bj.d.aJe().add(this.IvH);
    frk();
    init();
    AppMethodBeat.o(37837);
  }
  
  private void a(bb parambb)
  {
    AppMethodBeat.i(37840);
    if (this.context == null)
    {
      ac.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
      AppMethodBeat.o(37840);
      return;
    }
    TextView localTextView;
    Object localObject;
    boolean bool;
    if (a.id(this.context))
    {
      this.ifK = View.inflate(this.context, 2131494150, this);
      ((TextView)this.ifK.findViewById(2131300167)).setText(k.c(this.context, parambb.field_displayName));
      localTextView = (TextView)this.ifK.findViewById(2131300166);
      localObject = com.tencent.mm.bj.d.aJd().ala(parambb.field_talker);
      Context localContext = this.context;
      int i = ((bd)localObject).field_type;
      int j = parambb.field_addScene;
      String str = ((bd)localObject).field_msgContent;
      if (((bd)localObject).fbj()) {
        break label240;
      }
      bool = true;
      label136:
      localObject = b.a(localContext, i, j, str, bool);
      if (!bs.isNullOrNil((String)localObject)) {
        break label246;
      }
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      this.IvG = this.ifK.findViewById(2131300149);
      this.ifK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37835);
          ac.d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
          az.ayM();
          c.agA().set(143618, Integer.valueOf(0));
          com.tencent.mm.br.d.b(l.d(l.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
          AppMethodBeat.o(37835);
        }
      });
      a.b.c((ImageView)((MaskLayout)this.ifK.findViewById(2131300144)).getContentView(), parambb.field_talker);
      AppMethodBeat.o(37840);
      return;
      this.ifK = View.inflate(this.context, 2131494149, this);
      break;
      label240:
      bool = false;
      break label136;
      label246:
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  private void frj()
  {
    AppMethodBeat.i(37839);
    if (this.context == null)
    {
      ac.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
      AppMethodBeat.o(37839);
      return;
    }
    this.ifK = View.inflate(this.context, 2131494147, this);
    this.IvG = this.ifK.findViewById(2131300162);
    Object localObject = this.IvG.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(a.av(this.context, 2131165242) * a.ic(this.context)));
    this.IvG.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.ifK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37834);
        ac.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
        com.tencent.mm.br.d.b(l.d(l.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
        AppMethodBeat.o(37834);
      }
    });
    localObject = (MaskLayout)this.ifK.findViewById(2131300144);
    p.aBh();
    Bitmap localBitmap = e.Ad("fmessage");
    ((ImageView)((MaskLayout)localObject).getContentView()).setImageBitmap(localBitmap);
    AppMethodBeat.o(37839);
  }
  
  private static void frk()
  {
    AppMethodBeat.i(37843);
    int i = com.tencent.mm.bj.d.aJe().fbh();
    ac.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      az.ayM();
      c.agA().set(143618, Integer.valueOf(i));
    }
    AppMethodBeat.o(37843);
  }
  
  public static void frl()
  {
    AppMethodBeat.i(37844);
    az.ayM();
    if (c.afW())
    {
      az.ayM();
      if (c.agA().getInt(143618, 0) > 0) {
        aa.ao("fmessage", 2);
      }
    }
    az.ayM();
    c.agA().set(143618, Integer.valueOf(0));
    AppMethodBeat.o(37844);
  }
  
  private void ij(List<bb> paramList)
  {
    AppMethodBeat.i(37841);
    if (this.context == null)
    {
      ac.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
      AppMethodBeat.o(37841);
      return;
    }
    this.ifK = View.inflate(this.context, 2131494148, this);
    int i = paramList.size();
    ac.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", new Object[] { Integer.valueOf(i) });
    Object localObject = (bb)paramList.get(0);
    MaskLayout localMaskLayout = (MaskLayout)this.ifK.findViewById(2131300144);
    a.b.c((ImageView)localMaskLayout.getContentView(), ((bb)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    localObject = (bb)paramList.get(1);
    localMaskLayout = (MaskLayout)this.ifK.findViewById(2131300145);
    a.b.c((ImageView)localMaskLayout.getContentView(), ((bb)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    if (i > 2)
    {
      localObject = (bb)paramList.get(2);
      localMaskLayout = (MaskLayout)this.ifK.findViewById(2131300146);
      a.b.c((ImageView)localMaskLayout.getContentView(), ((bb)localObject).field_talker);
      localMaskLayout.setVisibility(0);
    }
    if (i > 3)
    {
      paramList = (bb)paramList.get(3);
      localObject = (MaskLayout)this.ifK.findViewById(2131300147);
      a.b.c((ImageView)((MaskLayout)localObject).getContentView(), paramList.field_talker);
      ((MaskLayout)localObject).setVisibility(0);
    }
    this.IvG = this.ifK.findViewById(2131300149);
    this.IvG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37836);
        ac.d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
        az.ayM();
        c.agA().set(143618, Integer.valueOf(0));
        com.tencent.mm.br.d.b(l.d(l.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
        AppMethodBeat.o(37836);
      }
    });
    AppMethodBeat.o(37841);
  }
  
  private void init()
  {
    AppMethodBeat.i(37838);
    Object localObject = com.tencent.mm.bj.d.aJe().fbf();
    int i = ((List)localObject).size();
    ac.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", new Object[] { Integer.valueOf(i) });
    removeAllViews();
    if (i <= 0)
    {
      frj();
      localObject = this.ifK.findViewById(2131300149);
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
      this.IvG.setOnTouchListener(new View.OnTouchListener()
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
      i = com.tencent.mm.bj.d.aJe().fbh();
      ac.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)this.ifK.findViewById(2131300160);
      ((TextView)localObject).setBackgroundResource(u.ks(this.context));
      if (i > 0) {
        break label204;
      }
      ((TextView)localObject).setVisibility(8);
      IvF = Boolean.FALSE;
      AppMethodBeat.o(37838);
      return;
      if (i == 1)
      {
        a((bb)((List)localObject).get(0));
        break;
      }
      ij((List)localObject);
      break;
    }
    label204:
    ((TextView)localObject).setVisibility(0);
    IvF = Boolean.TRUE;
    if (i > 99)
    {
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(2131689744);
      AppMethodBeat.o(37838);
      return;
    }
    ((TextView)localObject).setText(String.valueOf(i));
    ((TextView)localObject).setBackgroundResource(u.aM(this.context, i));
    AppMethodBeat.o(37838);
  }
  
  public final void setFrontGround(boolean paramBoolean)
  {
    this.IvI = paramBoolean;
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37842);
    ac.d("MicroMsg.FMessageContactView", "setVisible visible = ".concat(String.valueOf(paramBoolean)));
    View localView = this.ifK.findViewById(2131300149);
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