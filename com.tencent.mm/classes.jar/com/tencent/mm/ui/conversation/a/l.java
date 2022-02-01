package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.c.e;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public final class l
  extends b
{
  protected bg Hha;
  private TextView Hhb;
  private View mxV;
  private View mxW;
  
  public l(Context paramContext, bg parambg)
  {
    super(paramContext);
    AppMethodBeat.i(38811);
    this.Hha = null;
    this.Hha = parambg;
    final int i;
    final int j;
    if (this.view != null)
    {
      this.mxV = this.view.findViewById(2131297178);
      this.mxW = this.view.findViewById(2131297183);
      paramContext = (WeImageView)this.view.findViewById(2131302005);
      paramContext.setIconColor(((Context)this.BZM.get()).getResources().getColor(2131099676));
      this.Hhb = ((TextView)this.view.findViewById(2131302006));
      switch (this.Hha.type)
      {
      case 5: 
      default: 
        parambg = this.view;
        i = this.Hha.type;
        j = this.Hha.dcz;
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
      this.Hhb.setText(2131756414);
      break;
      paramContext.setImageResource(2131690548);
      this.Hhb.setText(2131759112);
      break;
      paramContext.setImageResource(2131690520);
      this.Hhb.setText(2131756425);
      break;
      paramContext.setImageResource(2131691354);
      this.Hhb.setText(2131756417);
      break;
      paramContext.setImageResource(2131691349);
      this.Hhb.setText(2131756421);
      break;
      paramContext.setImageResource(2131691350);
      this.Hhb.setText(2131756420);
      break;
      paramContext.setImageResource(2131691352);
      this.Hhb.setText(2131756422);
      break;
      paramContext.setImageResource(2131691353);
      this.Hhb.setText(2131756418);
      break;
      paramContext.setImageResource(2131691348);
      this.Hhb.setText(2131756411);
      break;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38802);
          bh.asb().db(i, j);
          paramAnonymousView = (Context)l.this.BZM.get();
          if (paramAnonymousView != null)
          {
            h.vKh.f(11002, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            az.arV();
            boolean bool = bt.l((Boolean)c.afk().get(4103, null));
            new Intent().putExtra("KEnterFromBanner", true);
            if (!bool)
            {
              d.O(paramAnonymousView, "nearby", ".ui.NearbyFriendsIntroUI");
              AppMethodBeat.o(38802);
              return;
            }
            Object localObject = bs.asC();
            if (localObject == null)
            {
              d.O(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
              AppMethodBeat.o(38802);
              return;
            }
            String str = bt.nullAsNil(((bs)localObject).getProvince());
            int i = bt.a(Integer.valueOf(((bs)localObject).evp), 0);
            if ((bt.isNullOrNil(str)) || (i == 0))
            {
              d.O(paramAnonymousView, "nearby", ".ui.NearbyPersonalInfoUI");
              AppMethodBeat.o(38802);
              return;
            }
            localObject = LauncherUI.getInstance();
            if (localObject != null) {
              ((LauncherUI)localObject).FMb.getMainTabUI().aKb("tab_find_friend");
            }
            a.gR(paramAnonymousView);
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
          bh.asb().db(i, j);
          paramAnonymousView = (Context)l.this.BZM.get();
          if (paramAnonymousView != null)
          {
            az.arV();
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
            h.vKh.f(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
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
          bh.asb().db(i, j);
          l.G((Context)l.this.BZM.get(), false);
          AppMethodBeat.o(38804);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38805);
          bh.asb().db(i, j);
          l.G((Context)l.this.BZM.get(), true);
          AppMethodBeat.o(38805);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38806);
          bh.asb().db(i, j);
          paramAnonymousView = (Context)l.this.BZM.get();
          Intent localIntent = new Intent();
          localIntent.putExtra("preceding_scence", 17);
          d.b(paramAnonymousView, "emoji", ".ui.v2.EmojiStoreV2UI", localIntent);
          h.vKh.f(11002, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
          h.vKh.f(12065, new Object[] { Integer.valueOf(2) });
          AppMethodBeat.o(38806);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38807);
          bh.asb().db(i, j);
          d.O((Context)l.this.BZM.get(), "game", ".ui.GameCenterUI");
          h.vKh.f(11002, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
          AppMethodBeat.o(38807);
        }
      };
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38808);
          bh.asb().db(i, j);
          paramAnonymousView = (Context)l.this.BZM.get();
          int i;
          if ((u.aqS() & 0x10000) == 0)
          {
            i = 1;
            if (i == 0) {
              break label95;
            }
            d.O(paramAnonymousView, "masssend", ".ui.MassSendHistoryUI");
          }
          for (;;)
          {
            h.vKh.f(11002, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
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
          bh.asb().db(i, j);
          paramAnonymousView = (Context)l.this.BZM.get();
          az.arV();
          String str = (String)c.afk().get(68377, null);
          az.arV();
          c.afk().set(68377, "");
          Intent localIntent = new Intent();
          localIntent.putExtra("sns_timeline_NeedFirstLoadint", true);
          if (!bt.isNullOrNil(str)) {}
          for (boolean bool1 = false;; bool1 = true)
          {
            boolean bool2 = bool1;
            if (o.wzI != null)
            {
              bool2 = bool1;
              if (o.wzI.bIR() > 0) {
                bool2 = false;
              }
            }
            localIntent.putExtra("sns_resume_state", bool2);
            d.b(paramAnonymousView, "sns", ".ui.SnsTimeLineUI", localIntent);
            h.vKh.f(11002, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
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
          bh.asb().db(i, j);
          d.b((Context)l.this.BZM.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
          AppMethodBeat.o(38810);
        }
      };
    }
  }
  
  public final boolean boZ()
  {
    AppMethodBeat.i(38812);
    if ((this.isFirst) && (this.gqE))
    {
      this.mxW.setBackgroundResource(2131234377);
      this.mxV.setBackground(null);
      this.Hhb.setBackground(null);
    }
    for (;;)
    {
      boolean bool = super.boZ();
      AppMethodBeat.o(38812);
      return bool;
      if (this.isFirst)
      {
        this.mxW.setBackgroundResource(2131232872);
        this.mxV.setBackgroundResource(2131232870);
        this.Hhb.setBackgroundResource(2131232867);
      }
      else if (this.gqE)
      {
        this.mxW.setBackgroundResource(2131232872);
        this.mxV.setBackgroundResource(2131232867);
        this.Hhb.setBackground(null);
      }
      else
      {
        this.mxW.setBackgroundResource(2131232872);
        this.mxV.setBackground(null);
        this.Hhb.setBackgroundResource(2131232867);
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
    if (this.mxV != null) {
      this.mxV.setVisibility(paramInt);
    }
    AppMethodBeat.o(38813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l
 * JD-Core Version:    0.7.0.1
 */