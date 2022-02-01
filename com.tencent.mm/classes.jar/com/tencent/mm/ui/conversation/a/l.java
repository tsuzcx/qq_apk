package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public final class l
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  protected bj KUV;
  private TextView KUW;
  private View nFO;
  private View nFP;
  
  public l(Context paramContext, bj parambj)
  {
    super(paramContext);
    AppMethodBeat.i(38811);
    this.KUV = null;
    this.KUV = parambj;
    final int i;
    final int j;
    if (this.view != null)
    {
      this.nFO = this.view.findViewById(2131297178);
      this.nFP = this.view.findViewById(2131297183);
      paramContext = (WeImageView)this.view.findViewById(2131302005);
      paramContext.setIconColor(((Context)this.FpA.get()).getResources().getColor(2131099676));
      this.KUW = ((TextView)this.view.findViewById(2131302006));
      switch (this.KUV.type)
      {
      case 5: 
      default: 
        parambj = this.view;
        i = this.KUV.type;
        j = this.KUV.dmr;
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
      parambj.setOnClickListener(paramContext);
      AppMethodBeat.o(38811);
      return;
      paramContext.setImageResource(2131690530);
      this.KUW.setText(2131756414);
      break;
      paramContext.setImageResource(2131690548);
      this.KUW.setText(2131759112);
      break;
      paramContext.setImageResource(2131690520);
      this.KUW.setText(2131756425);
      break;
      paramContext.setImageResource(2131691354);
      this.KUW.setText(2131756417);
      break;
      paramContext.setImageResource(2131691349);
      this.KUW.setText(2131756421);
      break;
      paramContext.setImageResource(2131691350);
      this.KUW.setText(2131756420);
      break;
      paramContext.setImageResource(2131691352);
      this.KUW.setText(2131756422);
      break;
      paramContext.setImageResource(2131691353);
      this.KUW.setText(2131756418);
      break;
      paramContext.setImageResource(2131691348);
      this.KUW.setText(2131756411);
      break;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38802);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          bk.aCm().dd(i, j);
          paramAnonymousView = (Context)l.this.FpA.get();
          if (paramAnonymousView != null)
          {
            g.yxI.f(11002, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            bc.aCg();
            boolean bool = bu.o((Boolean)c.ajA().get(4103, null));
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
            localObject = bv.aCM();
            if (localObject == null)
            {
              d.Q(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
            }
            else
            {
              String str = bu.nullAsNil(((bv)localObject).getProvince());
              int i = bu.a(Integer.valueOf(((bv)localObject).eQV), 0);
              if ((bu.isNullOrNil(str)) || (i == 0))
              {
                d.Q(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
              }
              else
              {
                localObject = LauncherUI.getInstance();
                if (localObject != null) {
                  ((LauncherUI)localObject).Jty.getMainTabUI().aWU("tab_find_friend");
                }
                com.tencent.mm.bp.a.hn(paramAnonymousView);
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          bk.aCm().dd(i, j);
          paramAnonymousView = (Context)l.this.FpA.get();
          if (paramAnonymousView != null)
          {
            bc.aCg();
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
            g.yxI.f(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          bk.aCm().dd(i, j);
          l.J((Context)l.this.FpA.get(), false);
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          bk.aCm().dd(i, j);
          l.J((Context)l.this.FpA.get(), true);
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          bk.aCm().dd(i, j);
          paramAnonymousView = (Context)l.this.FpA.get();
          localObject = new Intent();
          ((Intent)localObject).putExtra("preceding_scence", 17);
          d.b(paramAnonymousView, "emoji", ".ui.v2.EmojiStoreV2UI", (Intent)localObject);
          g.yxI.f(11002, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
          g.yxI.f(12065, new Object[] { Integer.valueOf(2) });
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          bk.aCm().dd(i, j);
          d.Q((Context)l.this.FpA.get(), "game", ".ui.GameCenterUI");
          g.yxI.f(11002, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          bk.aCm().dd(i, j);
          paramAnonymousView = (Context)l.this.FpA.get();
          int i;
          if ((v.aAO() & 0x10000) == 0)
          {
            i = 1;
            if (i == 0) {
              break label136;
            }
            d.Q(paramAnonymousView, "masssend", ".ui.MassSendHistoryUI");
          }
          for (;;)
          {
            g.yxI.f(11002, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          bk.aCm().dd(i, j);
          paramAnonymousView = (Context)l.this.FpA.get();
          bc.aCg();
          localObject = (String)c.ajA().get(68377, null);
          bc.aCg();
          c.ajA().set(68377, "");
          Intent localIntent = new Intent();
          localIntent.putExtra("sns_timeline_NeedFirstLoadint", true);
          if (!bu.isNullOrNil((String)localObject)) {}
          for (boolean bool1 = false;; bool1 = true)
          {
            boolean bool2 = bool1;
            if (o.zsx != null)
            {
              bool2 = bool1;
              if (o.zsx.bVY() > 0) {
                bool2 = false;
              }
            }
            localIntent.putExtra("sns_resume_state", bool2);
            d.b(paramAnonymousView, "sns", ".ui.SnsTimeLineUI", localIntent);
            g.yxI.f(11002, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          bk.aCm().dd(i, j);
          d.b((Context)l.this.FpA.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38810);
        }
      };
    }
  }
  
  public final boolean bAV()
  {
    AppMethodBeat.i(38812);
    if ((this.isFirst) && (this.hms))
    {
      this.nFP.setBackgroundResource(2131234377);
      this.nFO.setBackground(null);
      this.KUW.setBackground(null);
    }
    for (;;)
    {
      boolean bool = super.bAV();
      AppMethodBeat.o(38812);
      return bool;
      if (this.isFirst)
      {
        this.nFP.setBackgroundResource(2131232872);
        this.nFO.setBackgroundResource(2131232870);
        this.KUW.setBackgroundResource(2131232867);
      }
      else if (this.hms)
      {
        this.nFP.setBackgroundResource(2131232872);
        this.nFO.setBackgroundResource(2131232867);
        this.KUW.setBackground(null);
      }
      else
      {
        this.nFP.setBackgroundResource(2131232872);
        this.nFO.setBackground(null);
        this.KUW.setBackgroundResource(2131232867);
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
    if (this.nFO != null) {
      this.nFO.setVisibility(paramInt);
    }
    AppMethodBeat.o(38813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l
 * JD-Core Version:    0.7.0.1
 */