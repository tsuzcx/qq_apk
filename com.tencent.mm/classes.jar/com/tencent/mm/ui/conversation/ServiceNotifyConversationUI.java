package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.config.ae;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.v.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class ServiceNotifyConversationUI
  extends MMActivity
{
  private ListView XEt;
  private a XEu;
  private i.a XEv;
  private String XzI;
  private az conversation;
  private TextView emptyTipTv;
  private String lEm;
  private String talker = "";
  
  public int getLayoutId()
  {
    return R.i.tmessage;
  }
  
  public void initView()
  {
    AppMethodBeat.i(219070);
    setMMTitle(this.XzI);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(274279);
        ServiceNotifyConversationUI.this.finish();
        AppMethodBeat.o(274279);
        return true;
      }
    });
    setTitleBarDoubleClickListener(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(287842);
        if ((ServiceNotifyConversationUI.this.activityHasDestroyed()) || (ServiceNotifyConversationUI.this.isFinishing()))
        {
          AppMethodBeat.o(287842);
          return;
        }
        ServiceNotifyConversationUI.b(ServiceNotifyConversationUI.this);
        AppMethodBeat.o(287842);
      }
    });
    this.XEt = ((ListView)findViewById(R.h.tmessage_lv));
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.eNO);
    this.XEu = new a(this, this.lEm, new v.a()
    {
      public final void bxN()
      {
        AppMethodBeat.i(290884);
        ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this, ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this).getCount());
        AppMethodBeat.o(290884);
      }
    });
    this.XEu.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dO(View paramAnonymousView)
      {
        AppMethodBeat.i(285570);
        int i = ServiceNotifyConversationUI.c(ServiceNotifyConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(285570);
        return i;
      }
    });
    this.XEu.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(279513);
        ServiceNotifyConversationUI.c(ServiceNotifyConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(279513);
      }
    });
    this.XEt.setAdapter(this.XEu);
    this.XEt.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(283284);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousAdapterView);
        ((b)localObject).bn(paramAnonymousView);
        ((b)localObject).sg(paramAnonymousInt);
        ((b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aFi());
        ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this, (az)ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this).getItem(paramAnonymousInt));
        ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this, ServiceNotifyConversationUI.d(ServiceNotifyConversationUI.this).field_username);
        paramAnonymousView = ServiceNotifyConversationUI.d(ServiceNotifyConversationUI.this);
        if (paramAnonymousView == null)
        {
          Log.e("MicroMsg.ServiceNotifyConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this).getCount()) });
          ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this).notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(283284);
          return;
        }
        localObject = new Intent(ServiceNotifyConversationUI.this, ChattingUI.class);
        if (Util.isNullOrNil(paramAnonymousView.field_parentRef)) {}
        for (paramAnonymousAdapterView = paramAnonymousView.field_username;; paramAnonymousAdapterView = paramAnonymousView.field_parentRef)
        {
          ((Intent)localObject).putExtra("Chat_User", paramAnonymousAdapterView);
          ((Intent)localObject).putExtra("key_notify_message_real_username", paramAnonymousView.field_username);
          ((Intent)localObject).putExtra("finish_direct", true);
          ((Intent)localObject).putExtra("biz_click_item_unread_count", ServiceNotifyConversationUI.d(ServiceNotifyConversationUI.this).field_unReadCount);
          ((Intent)localObject).putExtra("biz_click_item_position", paramAnonymousInt + 1);
          ((Intent)localObject).putExtra("KOpenArticleSceneFromScene", 92);
          ((Intent)localObject).putExtra("specific_chat_from_scene", 6);
          paramAnonymousAdapterView = ServiceNotifyConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousAdapterView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this);
          ServiceNotifyConversationUI.a.m(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(283284);
          return;
        }
      }
    });
    this.XEu.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dO(View paramAnonymousView)
      {
        AppMethodBeat.i(287400);
        int i = ServiceNotifyConversationUI.c(ServiceNotifyConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(287400);
        return i;
      }
    });
    this.XEu.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(270902);
        ServiceNotifyConversationUI.c(ServiceNotifyConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(270902);
      }
    });
    AppMethodBeat.o(219070);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(219073);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.talker != null) && (!this.talker.isEmpty())) {
      this.talker = "";
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(219073);
      return;
    }
    AppMethodBeat.o(219073);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(219057);
    super.onCreate(paramBundle);
    if (!bh.aHB())
    {
      Log.e("MicroMsg.ServiceNotifyConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(219057);
      return;
    }
    this.lEm = "notifymessage";
    this.XzI = getIntent().getStringExtra("enterprise_biz_display_name");
    if (Util.isNullOrNil(this.XzI)) {
      this.XzI = getString(R.l.eHi);
    }
    initView();
    removeAllOptionMenu();
    addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, false, new ServiceNotifyConversationUI.3(this));
    bh.beI();
    c.bbR().add(this.XEu);
    this.XEv = new i.a()
    {
      public final void onNotifyChange(i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(291339);
        if ((paramAnonymousi != null) && (paramAnonymousc.kvM != null))
        {
          paramAnonymousi = paramAnonymousc.kvM.iterator();
          while (paramAnonymousi.hasNext())
          {
            Object localObject = (ca)paramAnonymousi.next();
            if ((localObject != null) && ("notifymessage".equals(paramAnonymousc.talker)))
            {
              bh.beI();
              c.getNotifyMessageRecordStorage();
              localObject = cf.bv((ca)localObject);
              if ((!Util.isNullOrNil((String)localObject)) && (ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this) != null)) {
                ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this).onNotifyChange((String)localObject, null);
              }
            }
          }
        }
        AppMethodBeat.o(291339);
      }
    };
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this.XEv, Looper.getMainLooper());
    AppMethodBeat.o(219057);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(219059);
    if (this.XEv != null)
    {
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this.XEv);
      this.XEv = null;
    }
    if (bh.aHB())
    {
      bh.beI();
      c.bbR().remove(this.XEu);
    }
    if (this.XEu != null) {
      this.XEu.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(219059);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(219064);
    Log.i("MicroMsg.ServiceNotifyConversationUI", "on pause");
    if (this.XEu != null) {
      this.XEu.onPause();
    }
    super.onPause();
    AppMethodBeat.o(219064);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(219062);
    Log.v("MicroMsg.ServiceNotifyConversationUI", "on resume");
    if (this.XEu != null) {
      this.XEu.onResume();
    }
    super.onResume();
    AppMethodBeat.o(219062);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends f
  {
    private Set<String> XEx;
    private String username;
    
    public a(Context paramContext, String paramString, v.a parama)
    {
      super(parama);
      AppMethodBeat.i(275798);
      this.XEx = new HashSet();
      this.username = paramString;
      AppMethodBeat.o(275798);
    }
    
    public static void m(az paramaz)
    {
      AppMethodBeat.i(275805);
      com.tencent.mm.plugin.report.service.h.IzE.a(21825, new Object[] { Integer.valueOf(5), paramaz.field_username, Long.valueOf(Util.nowSecond()), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(275805);
    }
    
    private static String w(Cursor paramCursor)
    {
      AppMethodBeat.i(275806);
      int i = paramCursor.getColumnIndex("talker");
      if (i >= 0)
      {
        paramCursor = paramCursor.getString(i);
        AppMethodBeat.o(275806);
        return paramCursor;
      }
      AppMethodBeat.o(275806);
      return null;
    }
    
    public final az a(az paramaz, Cursor paramCursor)
    {
      AppMethodBeat.i(275800);
      az localaz = paramaz;
      if (paramaz == null) {
        localaz = new az();
      }
      localaz.setUsername(w(paramCursor));
      int i = paramCursor.getColumnIndex("createTime");
      long l;
      if (i >= 0)
      {
        l = paramCursor.getLong(i);
        localaz.EB(l);
        i = paramCursor.getColumnIndex("digest");
        if (i < 0) {
          break label141;
        }
      }
      label141:
      for (paramaz = paramCursor.getString(i);; paramaz = null)
      {
        localaz.Ja(paramaz);
        localaz.Jc("notifymessage");
        localaz.setStatus(2);
        localaz.pJ(1);
        localaz.pH(0);
        localaz.IZ(Integer.toString(1));
        localaz.Jb("");
        AppMethodBeat.o(275800);
        return localaz;
        l = 0L;
        break;
      }
    }
    
    protected final void a(az paramaz, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      AppMethodBeat.i(275802);
      if (Util.isNullOrNil(paramaz.field_username))
      {
        AppMethodBeat.o(275802);
        return;
      }
      this.XEx.add(paramaz.field_username);
      AppMethodBeat.o(275802);
    }
    
    public final void atr()
    {
      AppMethodBeat.i(275799);
      eKd();
      bh.beI();
      v(c.getNotifyMessageRecordStorage().hAA());
      if (this.VZc != null) {
        this.VZc.bxN();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(275799);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(275801);
      paramViewGroup = super.getView(paramInt, paramView, paramViewGroup);
      f.g localg = (f.g)paramViewGroup.getTag();
      if (localg.WtR.getText() == null)
      {
        AppMethodBeat.o(275801);
        return paramViewGroup;
      }
      String str = localg.WtR.getText().toString();
      paramView = null;
      ae localae;
      if (as.OS(str))
      {
        localae = y.afd(str);
        if (localae == null) {}
      }
      for (paramView = localae.nickname;; paramView = aa.PJ(str))
      {
        if (!Util.nullAsNil(str).equals(paramView)) {
          localg.WtR.setText(paramView);
        }
        AppMethodBeat.o(275801);
        return paramViewGroup;
      }
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(275804);
      Object localObject1 = hK();
      if (localObject1 != null)
      {
        if ((localObject1 != null) && (!((Cursor)localObject1).isClosed()) && (((Cursor)localObject1).moveToFirst())) {
          break label125;
        }
        localObject1 = null;
        if (localObject1 != null) {
          if (localObject1 != null) {
            break label268;
          }
        }
      }
      label268:
      for (localObject1 = null;; localObject1 = String.format(Locale.US, "%d:%d:%d", new Object[] { Integer.valueOf(((ServiceNotifyConversationUI.b)localObject1).XEz), Integer.valueOf(((ServiceNotifyConversationUI.b)localObject1).XEy), Integer.valueOf(((ServiceNotifyConversationUI.b)localObject1).XEA) }))
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(21825, new Object[] { Integer.valueOf(4), null, Long.valueOf(Util.nowSecond()), localObject1, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        super.onDestroy();
        AppMethodBeat.o(275804);
        return;
        label125:
        Object localObject2 = new HashSet();
        String str;
        do
        {
          str = w((Cursor)localObject1);
          if (!Util.isNullOrNil(str)) {
            ((Set)localObject2).add(str);
          }
        } while (((Cursor)localObject1).moveToNext());
        localObject1 = new ServiceNotifyConversationUI.b((byte)0);
        if (!((Set)localObject2).isEmpty())
        {
          localObject2 = ((Set)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            if (as.OS(str)) {
              ((ServiceNotifyConversationUI.b)localObject1).XEy += 1;
            } else if (Util.nullAsNil(str).startsWith("gh_")) {
              ((ServiceNotifyConversationUI.b)localObject1).XEz += 1;
            } else {
              ((ServiceNotifyConversationUI.b)localObject1).XEA += 1;
            }
          }
        }
        break;
      }
    }
  }
  
  static final class b
  {
    public int XEA;
    public int XEy;
    public int XEz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ServiceNotifyConversationUI
 * JD-Core Version:    0.7.0.1
 */