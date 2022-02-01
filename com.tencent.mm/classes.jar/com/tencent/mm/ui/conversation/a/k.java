package com.tencent.mm.ui.conversation.a;

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
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public final class k
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  protected bo XFr;
  private TextView XFs;
  private View rSI;
  private View rSJ;
  
  public k(Context paramContext, bo parambo)
  {
    super(paramContext);
    AppMethodBeat.i(38811);
    this.XFr = null;
    this.XFr = parambo;
    final int i;
    final int j;
    if (this.view != null)
    {
      this.rSI = this.view.findViewById(R.h.banner);
      this.rSJ = this.view.findViewById(R.h.banner_root);
      paramContext = (WeImageView)this.view.findViewById(R.h.mainframe_banner_icon);
      paramContext.setIconColor(((Context)this.Rhc.get()).getResources().getColor(R.e.BW_50));
      this.XFs = ((TextView)this.view.findViewById(R.h.mainframe_banner_text));
      switch (this.XFr.type)
      {
      case 5: 
      default: 
        parambo = this.view;
        i = this.XFr.type;
        j = this.XFr.fwp;
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
      parambo.setOnClickListener(paramContext);
      AppMethodBeat.o(38811);
      return;
      paramContext.setImageResource(R.k.icons_outlined_cellphone);
      this.XFs.setText(R.l.esx);
      break;
      paramContext.setImageResource(R.k.icons_outlined_contacts);
      this.XFs.setText(R.l.find_mcontact_add_frined_btn);
      break;
      paramContext.setImageResource(R.k.icons_outlined_avatar);
      this.XFs.setText(R.l.esH);
      break;
      paramContext.setImageResource(R.k.userguide_nearfriends_icon);
      this.XFs.setText(R.l.esz);
      break;
      paramContext.setImageResource(R.k.userguide_emostore_icon);
      this.XFs.setText(R.l.esD);
      break;
      paramContext.setImageResource(R.k.userguide_gamecenter_icon);
      this.XFs.setText(R.l.esC);
      break;
      paramContext.setImageResource(R.k.userguide_grounpmessage_icon);
      this.XFs.setText(R.l.esE);
      break;
      paramContext.setImageResource(R.k.userguide_moments_icon);
      this.XFs.setText(R.l.esA);
      break;
      paramContext.setImageResource(R.k.userguide_autoadd_icon);
      this.XFs.setText(R.l.esw);
      break;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38802);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          bp.beO().dJ(i, j);
          paramAnonymousView = (Context)k.this.Rhc.get();
          if (paramAnonymousView != null)
          {
            h.IzE.a(11002, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            bh.beI();
            boolean bool = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.aHp().b(4103, null));
            new Intent().putExtra("KEnterFromBanner", true);
            if (bool) {
              break label161;
            }
            com.tencent.mm.by.c.ad(paramAnonymousView, "nearby", ".ui.NearbyFriendsIntroUI");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38802);
            return;
            label161:
            localObject = ca.bfo();
            if (localObject == null)
            {
              com.tencent.mm.by.c.ad(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
            }
            else
            {
              String str = Util.nullAsNil(((ca)localObject).getProvince());
              int i = Util.nullAs(Integer.valueOf(((ca)localObject).sex), 0);
              if ((Util.isNullOrNil(str)) || (i == 0))
              {
                com.tencent.mm.by.c.ad(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
              }
              else
              {
                localObject = LauncherUI.getInstance();
                if (localObject != null) {
                  ((LauncherUI)localObject).VXk.getMainTabUI().byt("tab_find_friend");
                }
                com.tencent.mm.bw.a.jk(paramAnonymousView);
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          bp.beO().dJ(i, j);
          paramAnonymousView = (Context)k.this.Rhc.get();
          if (paramAnonymousView != null)
          {
            bh.beI();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
              break label99;
            }
            w.g(paramAnonymousView, null);
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
            com.tencent.mm.by.c.b(paramAnonymousView, "setting", ".ui.setting.SettingsPersonalInfoUI", (Intent)localObject);
            h.IzE.a(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
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
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          bp.beO().dJ(i, j);
          k.P((Context)k.this.Rhc.get(), false);
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
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          bp.beO().dJ(i, j);
          k.P((Context)k.this.Rhc.get(), true);
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          bp.beO().dJ(i, j);
          paramAnonymousView = (Context)k.this.Rhc.get();
          localObject = new Intent();
          ((Intent)localObject).putExtra("preceding_scence", 17);
          com.tencent.mm.by.c.b(paramAnonymousView, "emoji", ".ui.v2.EmojiStoreV2UI", (Intent)localObject);
          h.IzE.a(11002, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
          h.IzE.a(12065, new Object[] { Integer.valueOf(2) });
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
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          bp.beO().dJ(i, j);
          com.tencent.mm.by.c.ad((Context)k.this.Rhc.get(), "game", ".ui.GameCenterUI");
          h.IzE.a(11002, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
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
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          bp.beO().dJ(i, j);
          paramAnonymousView = (Context)k.this.Rhc.get();
          int i;
          if ((z.bdn() & 0x10000) == 0)
          {
            i = 1;
            if (i == 0) {
              break label136;
            }
            com.tencent.mm.by.c.ad(paramAnonymousView, "masssend", ".ui.MassSendHistoryUI");
          }
          for (;;)
          {
            h.IzE.a(11002, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38808);
            return;
            i = 0;
            break;
            label136:
            com.tencent.mm.by.c.b(paramAnonymousView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          bp.beO().dJ(i, j);
          paramAnonymousView = (Context)k.this.Rhc.get();
          bh.beI();
          localObject = (String)com.tencent.mm.model.c.aHp().b(68377, null);
          bh.beI();
          com.tencent.mm.model.c.aHp().i(68377, "");
          Intent localIntent = new Intent();
          localIntent.putExtra("sns_timeline_NeedFirstLoadint", true);
          if (!Util.isNullOrNil((String)localObject)) {}
          for (boolean bool1 = false;; bool1 = true)
          {
            boolean bool2 = bool1;
            if (p.JPe != null)
            {
              bool2 = bool1;
              if (p.JPe.cHo() > 0) {
                bool2 = false;
              }
            }
            localIntent.putExtra("sns_resume_state", bool2);
            com.tencent.mm.by.c.b(paramAnonymousView, "sns", ".ui.SnsTimeLineUI", localIntent);
            h.IzE.a(11002, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
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
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/MainFrameBanner$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          bp.beO().dJ(i, j);
          com.tencent.mm.by.c.b((Context)k.this.Rhc.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/MainFrameBanner$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38810);
        }
      };
    }
  }
  
  public final boolean ckL()
  {
    AppMethodBeat.i(38812);
    if ((this.isFirst) && (this.kUc))
    {
      this.rSJ.setBackgroundResource(R.g.tips_bar_white_selector);
      this.rSI.setBackground(null);
      this.XFs.setBackground(null);
    }
    for (;;)
    {
      boolean bool = super.ckL();
      AppMethodBeat.o(38812);
      return bool;
      if (this.isFirst)
      {
        this.rSJ.setBackgroundResource(R.g.list_item_top_selector);
        this.rSI.setBackgroundResource(R.g.list_item_top_normal);
        this.XFs.setBackgroundResource(R.g.list_item_normal);
      }
      else if (this.kUc)
      {
        this.rSJ.setBackgroundResource(R.g.list_item_top_selector);
        this.rSI.setBackgroundResource(R.g.list_item_normal);
        this.XFs.setBackground(null);
      }
      else
      {
        this.rSJ.setBackgroundResource(R.g.list_item_top_selector);
        this.rSI.setBackground(null);
        this.XFs.setBackgroundResource(R.g.list_item_normal);
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
    if (this.rSI != null) {
      this.rSI.setVisibility(paramInt);
    }
    AppMethodBeat.o(38813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.k
 * JD-Core Version:    0.7.0.1
 */