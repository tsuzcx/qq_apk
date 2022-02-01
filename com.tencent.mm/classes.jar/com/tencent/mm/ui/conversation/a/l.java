package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.a;
import com.tencent.mm.br.d;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public final class l
  extends b
{
  protected bg IHt;
  private TextView IHu;
  private View mZW;
  private View mZX;
  
  public l(Context paramContext, bg parambg)
  {
    super(paramContext);
    AppMethodBeat.i(38811);
    this.IHt = null;
    this.IHt = parambg;
    final int i;
    final int j;
    if (this.view != null)
    {
      this.mZW = this.view.findViewById(2131297178);
      this.mZX = this.view.findViewById(2131297183);
      paramContext = (WeImageView)this.view.findViewById(2131302005);
      paramContext.setIconColor(((Context)this.Dsc.get()).getResources().getColor(2131099676));
      this.IHu = ((TextView)this.view.findViewById(2131302006));
      switch (this.IHt.type)
      {
      case 5: 
      default: 
        parambg = this.view;
        i = this.IHt.type;
        j = this.IHt.cZX;
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
      parambg.setOnClickListener(paramContext);
      AppMethodBeat.o(38811);
      return;
      paramContext.setImageResource(2131690530);
      this.IHu.setText(2131756414);
      break;
      paramContext.setImageResource(2131690548);
      this.IHu.setText(2131759112);
      break;
      paramContext.setImageResource(2131690520);
      this.IHu.setText(2131756425);
      break;
      paramContext.setImageResource(2131691354);
      this.IHu.setText(2131756417);
      break;
      paramContext.setImageResource(2131691349);
      this.IHu.setText(2131756421);
      break;
      paramContext.setImageResource(2131691350);
      this.IHu.setText(2131756420);
      break;
      paramContext.setImageResource(2131691352);
      this.IHu.setText(2131756422);
      break;
      paramContext.setImageResource(2131691353);
      this.IHu.setText(2131756418);
      break;
      paramContext.setImageResource(2131691348);
      this.IHu.setText(2131756411);
      break;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38802);
          bh.ayS().db(i, j);
          paramAnonymousView = (Context)l.this.Dsc.get();
          if (paramAnonymousView != null)
          {
            h.wUl.f(11002, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            az.ayM();
            boolean bool = com.tencent.mm.sdk.platformtools.bs.l((Boolean)c.agA().get(4103, null));
            new Intent().putExtra("KEnterFromBanner", true);
            if (!bool)
            {
              d.N(paramAnonymousView, "nearby", ".ui.NearbyFriendsIntroUI");
              AppMethodBeat.o(38802);
              return;
            }
            Object localObject = com.tencent.mm.model.bs.azt();
            if (localObject == null)
            {
              d.N(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
              AppMethodBeat.o(38802);
              return;
            }
            String str = com.tencent.mm.sdk.platformtools.bs.nullAsNil(((com.tencent.mm.model.bs)localObject).getProvince());
            int i = com.tencent.mm.sdk.platformtools.bs.a(Integer.valueOf(((com.tencent.mm.model.bs)localObject).exL), 0);
            if ((com.tencent.mm.sdk.platformtools.bs.isNullOrNil(str)) || (i == 0))
            {
              d.N(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
              AppMethodBeat.o(38802);
              return;
            }
            localObject = LauncherUI.getInstance();
            if (localObject != null) {
              ((LauncherUI)localObject).Hlj.getMainTabUI().aPD("tab_find_friend");
            }
            a.hc(paramAnonymousView);
          }
          AppMethodBeat.o(38802);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38803);
          bh.ayS().db(i, j);
          paramAnonymousView = (Context)l.this.Dsc.get();
          if (paramAnonymousView != null)
          {
            az.ayM();
            if (!c.isSDCardAvailable())
            {
              t.g(paramAnonymousView, null);
              AppMethodBeat.o(38803);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("intent_set_avatar", true);
            localIntent.putExtra("KEnterFromBanner", true);
            d.b(paramAnonymousView, "setting", ".ui.setting.SettingsPersonalInfoUI", localIntent);
            h.wUl.f(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
          }
          AppMethodBeat.o(38803);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38804);
          bh.ayS().db(i, j);
          l.H((Context)l.this.Dsc.get(), false);
          AppMethodBeat.o(38804);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38805);
          bh.ayS().db(i, j);
          l.H((Context)l.this.Dsc.get(), true);
          AppMethodBeat.o(38805);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38806);
          bh.ayS().db(i, j);
          paramAnonymousView = (Context)l.this.Dsc.get();
          Intent localIntent = new Intent();
          localIntent.putExtra("preceding_scence", 17);
          d.b(paramAnonymousView, "emoji", ".ui.v2.EmojiStoreV2UI", localIntent);
          h.wUl.f(11002, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
          h.wUl.f(12065, new Object[] { Integer.valueOf(2) });
          AppMethodBeat.o(38806);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38807);
          bh.ayS().db(i, j);
          d.N((Context)l.this.Dsc.get(), "game", ".ui.GameCenterUI");
          h.wUl.f(11002, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
          AppMethodBeat.o(38807);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38808);
          bh.ayS().db(i, j);
          paramAnonymousView = (Context)l.this.Dsc.get();
          int i;
          if ((u.axI() & 0x10000) == 0)
          {
            i = 1;
            if (i == 0) {
              break label95;
            }
            d.N(paramAnonymousView, "masssend", ".ui.MassSendHistoryUI");
          }
          for (;;)
          {
            h.wUl.f(11002, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
            AppMethodBeat.o(38808);
            return;
            i = 0;
            break;
            label95:
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
          bh.ayS().db(i, j);
          paramAnonymousView = (Context)l.this.Dsc.get();
          az.ayM();
          String str = (String)c.agA().get(68377, null);
          az.ayM();
          c.agA().set(68377, "");
          Intent localIntent = new Intent();
          localIntent.putExtra("sns_timeline_NeedFirstLoadint", true);
          if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(str)) {}
          for (boolean bool1 = false;; bool1 = true)
          {
            boolean bool2 = bool1;
            if (o.xMc != null)
            {
              bool2 = bool1;
              if (o.xMc.bQe() > 0) {
                bool2 = false;
              }
            }
            localIntent.putExtra("sns_resume_state", bool2);
            d.b(paramAnonymousView, "sns", ".ui.SnsTimeLineUI", localIntent);
            h.wUl.f(11002, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
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
          bh.ayS().db(i, j);
          d.b((Context)l.this.Dsc.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
          AppMethodBeat.o(38810);
        }
      };
    }
  }
  
  public final boolean bvU()
  {
    AppMethodBeat.i(38812);
    if ((this.isFirst) && (this.gRm))
    {
      this.mZX.setBackgroundResource(2131234377);
      this.mZW.setBackground(null);
      this.IHu.setBackground(null);
    }
    for (;;)
    {
      boolean bool = super.bvU();
      AppMethodBeat.o(38812);
      return bool;
      if (this.isFirst)
      {
        this.mZX.setBackgroundResource(2131232872);
        this.mZW.setBackgroundResource(2131232870);
        this.IHu.setBackgroundResource(2131232867);
      }
      else if (this.gRm)
      {
        this.mZX.setBackgroundResource(2131232872);
        this.mZW.setBackgroundResource(2131232867);
        this.IHu.setBackground(null);
      }
      else
      {
        this.mZX.setBackgroundResource(2131232872);
        this.mZW.setBackground(null);
        this.IHu.setBackgroundResource(2131232867);
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
    if (this.mZW != null) {
      this.mZW.setVisibility(paramInt);
    }
    AppMethodBeat.o(38813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l
 * JD-Core Version:    0.7.0.1
 */