package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public final class l
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  protected bn Qil;
  private TextView Qim;
  private View oQL;
  private View oQM;
  
  public l(Context paramContext, bn parambn)
  {
    super(paramContext);
    AppMethodBeat.i(38811);
    this.Qil = null;
    this.Qil = parambn;
    final int i;
    final int j;
    if (this.view != null)
    {
      this.oQL = this.view.findViewById(2131297322);
      this.oQM = this.view.findViewById(2131297327);
      paramContext = (WeImageView)this.view.findViewById(2131304344);
      paramContext.setIconColor(((Context)this.Kgr.get()).getResources().getColor(2131099683));
      this.Qim = ((TextView)this.view.findViewById(2131304345));
      switch (this.Qil.type)
      {
      case 5: 
      default: 
        parambn = this.view;
        i = this.Qil.type;
        j = this.Qil.dDG;
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
      parambn.setOnClickListener(paramContext);
      AppMethodBeat.o(38811);
      return;
      paramContext.setImageResource(2131690755);
      this.Qim.setText(2131756549);
      break;
      paramContext.setImageResource(2131690776);
      this.Qim.setText(2131759446);
      break;
      paramContext.setImageResource(2131690742);
      this.Qim.setText(2131756560);
      break;
      paramContext.setImageResource(2131691686);
      this.Qim.setText(2131756552);
      break;
      paramContext.setImageResource(2131691681);
      this.Qim.setText(2131756556);
      break;
      paramContext.setImageResource(2131691682);
      this.Qim.setText(2131756555);
      break;
      paramContext.setImageResource(2131691684);
      this.Qim.setText(2131756557);
      break;
      paramContext.setImageResource(2131691685);
      this.Qim.setText(2131756553);
      break;
      paramContext.setImageResource(2131691680);
      this.Qim.setText(2131756546);
      break;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38802);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          bo.aVL().dn(i, j);
          paramAnonymousView = (Context)l.this.Kgr.get();
          if (paramAnonymousView != null)
          {
            h.CyF.a(11002, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            bg.aVF();
            boolean bool = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.azQ().get(4103, null));
            new Intent().putExtra("KEnterFromBanner", true);
            if (bool) {
              break label161;
            }
            com.tencent.mm.br.c.V(paramAnonymousView, "nearby", ".ui.NearbyFriendsIntroUI");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38802);
            return;
            label161:
            localObject = bz.aWk();
            if (localObject == null)
            {
              com.tencent.mm.br.c.V(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
            }
            else
            {
              String str = Util.nullAsNil(((bz)localObject).getProvince());
              int i = Util.nullAs(Integer.valueOf(((bz)localObject).fuA), 0);
              if ((Util.isNullOrNil(str)) || (i == 0))
              {
                com.tencent.mm.br.c.V(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
              }
              else
              {
                localObject = LauncherUI.getInstance();
                if (localObject != null) {
                  ((LauncherUI)localObject).ODR.getMainTabUI().blU("tab_find_friend");
                }
                com.tencent.mm.bp.a.ih(paramAnonymousView);
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          bo.aVL().dn(i, j);
          paramAnonymousView = (Context)l.this.Kgr.get();
          if (paramAnonymousView != null)
          {
            bg.aVF();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
              break label99;
            }
            u.g(paramAnonymousView, null);
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
            com.tencent.mm.br.c.b(paramAnonymousView, "setting", ".ui.setting.SettingsPersonalInfoUI", (Intent)localObject);
            h.CyF.a(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
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
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          bo.aVL().dn(i, j);
          l.K((Context)l.this.Kgr.get(), false);
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
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          bo.aVL().dn(i, j);
          l.K((Context)l.this.Kgr.get(), true);
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          bo.aVL().dn(i, j);
          paramAnonymousView = (Context)l.this.Kgr.get();
          localObject = new Intent();
          ((Intent)localObject).putExtra("preceding_scence", 17);
          com.tencent.mm.br.c.b(paramAnonymousView, "emoji", ".ui.v2.EmojiStoreV2UI", (Intent)localObject);
          h.CyF.a(11002, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
          h.CyF.a(12065, new Object[] { Integer.valueOf(2) });
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
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          bo.aVL().dn(i, j);
          com.tencent.mm.br.c.V((Context)l.this.Kgr.get(), "game", ".ui.GameCenterUI");
          h.CyF.a(11002, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
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
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          bo.aVL().dn(i, j);
          paramAnonymousView = (Context)l.this.Kgr.get();
          int i;
          if ((z.aUl() & 0x10000) == 0)
          {
            i = 1;
            if (i == 0) {
              break label136;
            }
            com.tencent.mm.br.c.V(paramAnonymousView, "masssend", ".ui.MassSendHistoryUI");
          }
          for (;;)
          {
            h.CyF.a(11002, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38808);
            return;
            i = 0;
            break;
            label136:
            com.tencent.mm.br.c.b(paramAnonymousView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          bo.aVL().dn(i, j);
          paramAnonymousView = (Context)l.this.Kgr.get();
          bg.aVF();
          localObject = (String)com.tencent.mm.model.c.azQ().get(68377, null);
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(68377, "");
          Intent localIntent = new Intent();
          localIntent.putExtra("sns_timeline_NeedFirstLoadint", true);
          if (!Util.isNullOrNil((String)localObject)) {}
          for (boolean bool1 = false;; bool1 = true)
          {
            boolean bool2 = bool1;
            if (o.DCO != null)
            {
              bool2 = bool1;
              if (o.DCO.ctM() > 0) {
                bool2 = false;
              }
            }
            localIntent.putExtra("sns_resume_state", bool2);
            com.tencent.mm.br.c.b(paramAnonymousView, "sns", ".ui.SnsTimeLineUI", localIntent);
            h.CyF.a(11002, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
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
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/MainFrameBanner$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          bo.aVL().dn(i, j);
          com.tencent.mm.br.c.b((Context)l.this.Kgr.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38810);
        }
      };
    }
  }
  
  public final boolean bYa()
  {
    AppMethodBeat.i(38812);
    if ((this.isFirst) && (this.ifo))
    {
      this.oQM.setBackgroundResource(2131235299);
      this.oQL.setBackground(null);
      this.Qim.setBackground(null);
    }
    for (;;)
    {
      boolean bool = super.bYa();
      AppMethodBeat.o(38812);
      return bool;
      if (this.isFirst)
      {
        this.oQM.setBackgroundResource(2131233332);
        this.oQL.setBackgroundResource(2131233330);
        this.Qim.setBackgroundResource(2131233327);
      }
      else if (this.ifo)
      {
        this.oQM.setBackgroundResource(2131233332);
        this.oQL.setBackgroundResource(2131233327);
        this.Qim.setBackground(null);
      }
      else
      {
        this.oQM.setBackgroundResource(2131233332);
        this.oQL.setBackground(null);
        this.Qim.setBackgroundResource(2131233327);
      }
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131495412;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38813);
    if (this.oQL != null) {
      this.oQL.setVisibility(paramInt);
    }
    AppMethodBeat.o(38813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l
 * JD-Core Version:    0.7.0.1
 */