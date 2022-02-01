package com.tencent.mm.ui.conversation.banner;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.c.f;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public final class k
  extends com.tencent.mm.pluginsdk.ui.a.b
{
  protected bp aftp;
  private TextView aftq;
  private View vdX;
  private View vdY;
  
  public k(Context paramContext, bp parambp)
  {
    super(paramContext);
    AppMethodBeat.i(38811);
    this.aftp = null;
    this.aftp = parambp;
    final int i;
    final int j;
    if (this.view != null)
    {
      this.vdX = this.view.findViewById(R.h.banner);
      this.vdY = this.view.findViewById(R.h.banner_root);
      paramContext = (WeImageView)this.view.findViewById(R.h.mainframe_banner_icon);
      paramContext.setIconColor(((Context)this.Ydi.get()).getResources().getColor(R.e.BW_50));
      this.aftq = ((TextView)this.view.findViewById(R.h.mainframe_banner_text));
      switch (this.aftp.type)
      {
      case 5: 
      default: 
        parambp = this.view;
        i = this.aftp.type;
        j = this.aftp.hAN;
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
      parambp.setOnClickListener(paramContext);
      AppMethodBeat.o(38811);
      return;
      paramContext.setImageResource(R.k.icons_outlined_cellphone);
      this.aftq.setText(R.l.gvy);
      break;
      paramContext.setImageResource(R.k.icons_outlined_contacts);
      this.aftq.setText(R.l.find_mcontact_add_frined_btn);
      break;
      paramContext.setImageResource(R.k.icons_outlined_avatar);
      this.aftq.setText(R.l.gvG);
      break;
      paramContext.setImageResource(R.k.userguide_nearfriends_icon);
      this.aftq.setText(R.l.gvA);
      break;
      paramContext.setImageResource(R.k.userguide_emostore_icon);
      this.aftq.setText(R.l.gvE);
      break;
      paramContext.setImageResource(R.k.userguide_gamecenter_icon);
      this.aftq.setText(R.l.gvD);
      break;
      paramContext.setImageResource(R.k.userguide_grounpmessage_icon);
      this.aftq.setText(R.l.gvF);
      break;
      paramContext.setImageResource(R.k.userguide_moments_icon);
      this.aftq.setText(R.l.gvB);
      break;
      paramContext.setImageResource(R.k.userguide_autoadd_icon);
      this.aftq.setText(R.l.gvx);
      break;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38802);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          bq.bCF().eD(i, j);
          paramAnonymousView = (Context)k.this.Ydi.get();
          if (paramAnonymousView != null)
          {
            h.OAn.b(11002, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            bh.bCz();
            boolean bool = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.ban().d(4103, null));
            new Intent().putExtra("KEnterFromBanner", true);
            if (bool) {
              break label161;
            }
            com.tencent.mm.br.c.ai(paramAnonymousView, "nearby", ".ui.NearbyFriendsIntroUI");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38802);
            return;
            label161:
            localObject = cb.bDf();
            if (localObject == null)
            {
              com.tencent.mm.br.c.ai(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
            }
            else
            {
              String str = Util.nullAsNil(((cb)localObject).getProvince());
              int i = Util.nullAs(Integer.valueOf(((cb)localObject).sex), 0);
              if ((Util.isNullOrNil(str)) || (i == 0))
              {
                com.tencent.mm.br.c.ai(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
              }
              else
              {
                localObject = LauncherUI.getInstance();
                if (localObject != null) {
                  ((LauncherUI)localObject).adBG.getMainTabUI().bzP("tab_find_friend");
                }
                com.tencent.mm.bp.a.li(paramAnonymousView);
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          bq.bCF().eD(i, j);
          paramAnonymousView = (Context)k.this.Ydi.get();
          if (paramAnonymousView != null)
          {
            bh.bCz();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
              break label99;
            }
            aa.j(paramAnonymousView, null);
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
            h.OAn.b(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
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
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          bq.bCF().eD(i, j);
          k.Y((Context)k.this.Ydi.get(), false);
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
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          bq.bCF().eD(i, j);
          k.Y((Context)k.this.Ydi.get(), true);
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          bq.bCF().eD(i, j);
          paramAnonymousView = (Context)k.this.Ydi.get();
          localObject = new Intent();
          ((Intent)localObject).putExtra("preceding_scence", 17);
          com.tencent.mm.br.c.b(paramAnonymousView, "emoji", ".ui.v2.EmojiStoreV2UI", (Intent)localObject);
          h.OAn.b(11002, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
          h.OAn.b(12065, new Object[] { Integer.valueOf(2) });
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
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          bq.bCF().eD(i, j);
          com.tencent.mm.br.c.ai((Context)k.this.Ydi.get(), "game", ".ui.GameCenterUI");
          h.OAn.b(11002, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
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
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          bq.bCF().eD(i, j);
          paramAnonymousView = (Context)k.this.Ydi.get();
          int i;
          if ((z.bBf() & 0x10000) == 0)
          {
            i = 1;
            if (i == 0) {
              break label136;
            }
            com.tencent.mm.br.c.ai(paramAnonymousView, "masssend", ".ui.MassSendHistoryUI");
          }
          for (;;)
          {
            h.OAn.b(11002, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          bq.bCF().eD(i, j);
          paramAnonymousView = (Context)k.this.Ydi.get();
          bh.bCz();
          localObject = (String)com.tencent.mm.model.c.ban().d(68377, null);
          bh.bCz();
          com.tencent.mm.model.c.ban().B(68377, "");
          Intent localIntent = new Intent();
          localIntent.putExtra("sns_timeline_NeedFirstLoadint", true);
          if (!Util.isNullOrNil((String)localObject)) {}
          for (boolean bool1 = false;; bool1 = true)
          {
            boolean bool2 = bool1;
            if (q.Qkk != null)
            {
              bool2 = bool1;
              if (q.Qkk.dkF() > 0) {
                bool2 = false;
              }
            }
            localIntent.putExtra("sns_resume_state", bool2);
            com.tencent.mm.br.c.b(paramAnonymousView, "sns", ".ui.SnsTimeLineUI", localIntent);
            h.OAn.b(11002, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
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
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          bq.bCF().eD(i, j);
          com.tencent.mm.br.c.b((Context)k.this.Ydi.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38810);
        }
      };
    }
  }
  
  public final boolean cMa()
  {
    AppMethodBeat.i(38812);
    if ((this.isFirst) && (this.nzL))
    {
      this.vdY.setBackgroundResource(R.g.tips_bar_white_selector);
      this.vdX.setBackground(null);
      this.aftq.setBackground(null);
    }
    for (;;)
    {
      boolean bool = super.cMa();
      AppMethodBeat.o(38812);
      return bool;
      if (this.isFirst)
      {
        this.vdY.setBackgroundResource(R.g.list_item_top_selector);
        this.vdX.setBackgroundResource(R.g.list_item_top_normal);
        this.aftq.setBackgroundResource(R.g.list_item_normal);
      }
      else if (this.nzL)
      {
        this.vdY.setBackgroundResource(R.g.list_item_top_selector);
        this.vdX.setBackgroundResource(R.g.list_item_normal);
        this.aftq.setBackground(null);
      }
      else
      {
        this.vdY.setBackgroundResource(R.g.list_item_top_selector);
        this.vdX.setBackground(null);
        this.aftq.setBackgroundResource(R.g.list_item_normal);
      }
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.mainframe_banner_header_view;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38813);
    if (this.vdX != null) {
      this.vdX.setVisibility(paramInt);
    }
    AppMethodBeat.o(38813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.k
 * JD-Core Version:    0.7.0.1
 */