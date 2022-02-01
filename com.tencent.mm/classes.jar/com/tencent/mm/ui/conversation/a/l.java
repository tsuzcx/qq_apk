package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public final class l
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  protected bh KyB;
  private TextView KyC;
  private View nAt;
  private View nAu;
  
  public l(Context paramContext, bh parambh)
  {
    super(paramContext);
    AppMethodBeat.i(38811);
    this.KyB = null;
    this.KyB = parambh;
    final int i;
    final int j;
    if (this.view != null)
    {
      this.nAt = this.view.findViewById(2131297178);
      this.nAu = this.view.findViewById(2131297183);
      paramContext = (WeImageView)this.view.findViewById(2131302005);
      paramContext.setIconColor(((Context)this.EXg.get()).getResources().getColor(2131099676));
      this.KyC = ((TextView)this.view.findViewById(2131302006));
      switch (this.KyB.type)
      {
      case 5: 
      default: 
        parambh = this.view;
        i = this.KyB.type;
        j = this.KyB.dlp;
        switch (i)
        {
        case 5: 
        default: 
          paramContext = null;
        }
        break;
      }
    }
    for (;;)
    {
      parambh.setOnClickListener(paramContext);
      AppMethodBeat.o(38811);
      return;
      paramContext.setImageResource(2131690530);
      this.KyC.setText(2131756414);
      break;
      paramContext.setImageResource(2131690548);
      this.KyC.setText(2131759112);
      break;
      paramContext.setImageResource(2131690520);
      this.KyC.setText(2131756425);
      break;
      paramContext.setImageResource(2131691354);
      this.KyC.setText(2131756417);
      break;
      paramContext.setImageResource(2131691349);
      this.KyC.setText(2131756421);
      break;
      paramContext.setImageResource(2131691350);
      this.KyC.setText(2131756420);
      break;
      paramContext.setImageResource(2131691352);
      this.KyC.setText(2131756422);
      break;
      paramContext.setImageResource(2131691353);
      this.KyC.setText(2131756418);
      break;
      paramContext.setImageResource(2131691348);
      this.KyC.setText(2131756411);
      break;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38802);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          bi.aBW().dd(i, j);
          paramAnonymousView = (Context)l.this.EXg.get();
          if (paramAnonymousView != null)
          {
            g.yhR.f(11002, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            ba.aBQ();
            boolean bool = com.tencent.mm.sdk.platformtools.bt.o((Boolean)c.ajl().get(4103, null));
            new Intent().putExtra("KEnterFromBanner", true);
            if (bool) {
              break label161;
            }
            d.Q(paramAnonymousView, "nearby", ".ui.NearbyFriendsIntroUI");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38802);
            return;
            label161:
            localObject = com.tencent.mm.model.bt.aCw();
            if (localObject == null)
            {
              d.Q(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
            }
            else
            {
              String str = com.tencent.mm.sdk.platformtools.bt.nullAsNil(((com.tencent.mm.model.bt)localObject).getProvince());
              int i = com.tencent.mm.sdk.platformtools.bt.a(Integer.valueOf(((com.tencent.mm.model.bt)localObject).ePk), 0);
              if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str)) || (i == 0))
              {
                d.Q(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
              }
              else
              {
                localObject = LauncherUI.getInstance();
                if (localObject != null) {
                  ((LauncherUI)localObject).IYQ.getMainTabUI().aVt("tab_find_friend");
                }
                com.tencent.mm.bq.a.hh(paramAnonymousView);
              }
            }
          }
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38803);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          bi.aBW().dd(i, j);
          paramAnonymousView = (Context)l.this.EXg.get();
          if (paramAnonymousView != null)
          {
            ba.aBQ();
            if (c.isSDCardAvailable()) {
              break label99;
            }
            t.g(paramAnonymousView, null);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38803);
            return;
            label99:
            localObject = new Intent();
            ((Intent)localObject).putExtra("intent_set_avatar", true);
            ((Intent)localObject).putExtra("KEnterFromBanner", true);
            d.b(paramAnonymousView, "setting", ".ui.setting.SettingsPersonalInfoUI", (Intent)localObject);
            g.yhR.f(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
          }
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38804);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          bi.aBW().dd(i, j);
          l.J((Context)l.this.EXg.get(), false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38804);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38805);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          bi.aBW().dd(i, j);
          l.J((Context)l.this.EXg.get(), true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38805);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38806);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          bi.aBW().dd(i, j);
          paramAnonymousView = (Context)l.this.EXg.get();
          localObject = new Intent();
          ((Intent)localObject).putExtra("preceding_scence", 17);
          d.b(paramAnonymousView, "emoji", ".ui.v2.EmojiStoreV2UI", (Intent)localObject);
          g.yhR.f(11002, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
          g.yhR.f(12065, new Object[] { Integer.valueOf(2) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38806);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38807);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          bi.aBW().dd(i, j);
          d.Q((Context)l.this.EXg.get(), "game", ".ui.GameCenterUI");
          g.yhR.f(11002, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38807);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38808);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          bi.aBW().dd(i, j);
          paramAnonymousView = (Context)l.this.EXg.get();
          int i;
          if ((u.aAy() & 0x10000) == 0)
          {
            i = 1;
            if (i == 0) {
              break label136;
            }
            d.Q(paramAnonymousView, "masssend", ".ui.MassSendHistoryUI");
          }
          for (;;)
          {
            g.yhR.f(11002, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38808);
            return;
            i = 0;
            break;
            label136:
            d.b(paramAnonymousView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
          }
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38809);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          bi.aBW().dd(i, j);
          paramAnonymousView = (Context)l.this.EXg.get();
          ba.aBQ();
          localObject = (String)c.ajl().get(68377, null);
          ba.aBQ();
          c.ajl().set(68377, "");
          Intent localIntent = new Intent();
          localIntent.putExtra("sns_timeline_NeedFirstLoadint", true);
          if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject)) {}
          for (boolean bool1 = false;; bool1 = true)
          {
            boolean bool2 = bool1;
            if (o.zbU != null)
            {
              bool2 = bool1;
              if (o.zbU.bUJ() > 0) {
                bool2 = false;
              }
            }
            localIntent.putExtra("sns_resume_state", bool2);
            d.b(paramAnonymousView, "sns", ".ui.SnsTimeLineUI", localIntent);
            g.yhR.f(11002, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38809);
            return;
          }
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38810);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          bi.aBW().dd(i, j);
          d.b((Context)l.this.EXg.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38810);
        }
      };
    }
  }
  
  public final boolean bAa()
  {
    AppMethodBeat.i(38812);
    if ((this.isFirst) && (this.hjE))
    {
      this.nAu.setBackgroundResource(2131234377);
      this.nAt.setBackground(null);
      this.KyC.setBackground(null);
    }
    for (;;)
    {
      boolean bool = super.bAa();
      AppMethodBeat.o(38812);
      return bool;
      if (this.isFirst)
      {
        this.nAu.setBackgroundResource(2131232872);
        this.nAt.setBackgroundResource(2131232870);
        this.KyC.setBackgroundResource(2131232867);
      }
      else if (this.hjE)
      {
        this.nAu.setBackgroundResource(2131232872);
        this.nAt.setBackgroundResource(2131232867);
        this.KyC.setBackground(null);
      }
      else
      {
        this.nAu.setBackgroundResource(2131232872);
        this.nAt.setBackground(null);
        this.KyC.setBackgroundResource(2131232867);
      }
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131494686;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38813);
    if (this.nAt != null) {
      this.nAt.setVisibility(paramInt);
    }
    AppMethodBeat.o(38813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l
 * JD-Core Version:    0.7.0.1
 */