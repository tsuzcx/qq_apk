package com.tencent.mm.ui.conversation;

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
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.plugin.appbrand.config.al;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.x.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class ServiceNotifyConversationUI
  extends MMActivity
{
  private MMEditText GBE;
  private String afpa;
  private ListView afsq;
  private a afsr;
  private i.a afss;
  private bb conversation;
  private TextView emptyTipTv;
  private String ovT;
  private String talker = "";
  
  public int getLayoutId()
  {
    return R.i.gnS;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(256691);
    HashSet localHashSet = new HashSet();
    localHashSet.add(v.class);
    AppMethodBeat.o(256691);
    return localHashSet;
  }
  
  public void initView()
  {
    AppMethodBeat.i(256715);
    setMMTitle(this.afpa);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(256484);
        ServiceNotifyConversationUI.this.finish();
        AppMethodBeat.o(256484);
        return true;
      }
    });
    setTitleBarDoubleClickListener(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(256485);
        if ((ServiceNotifyConversationUI.this.activityHasDestroyed()) || (ServiceNotifyConversationUI.this.isFinishing()))
        {
          AppMethodBeat.o(256485);
          return;
        }
        ServiceNotifyConversationUI.b(ServiceNotifyConversationUI.this);
        AppMethodBeat.o(256485);
      }
    });
    this.afsq = ((ListView)findViewById(R.h.tmessage_lv));
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.gQc);
    this.GBE = ((MMEditText)findViewById(R.h.fVL));
    this.GBE.setOnClickListener(new ServiceNotifyConversationUI.7(this));
    this.afsr = new a(this, this.ovT, new x.a()
    {
      public final void bWC()
      {
        AppMethodBeat.i(256482);
        ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this, ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this).getCount());
        AppMethodBeat.o(256482);
      }
    });
    this.afsr.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int eB(View paramAnonymousView)
      {
        AppMethodBeat.i(256506);
        int i = ServiceNotifyConversationUI.c(ServiceNotifyConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(256506);
        return i;
      }
    });
    this.afsr.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(256815);
        ServiceNotifyConversationUI.c(ServiceNotifyConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(256815);
      }
    });
    this.afsq.setAdapter(this.afsr);
    this.afsq.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(256810);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousAdapterView);
        ((b)localObject).cH(paramAnonymousView);
        ((b)localObject).sc(paramAnonymousInt);
        ((b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aYj());
        ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this, (bb)ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this).getItem(paramAnonymousInt));
        ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this, ServiceNotifyConversationUI.d(ServiceNotifyConversationUI.this).field_username);
        paramAnonymousView = ServiceNotifyConversationUI.d(ServiceNotifyConversationUI.this);
        if (paramAnonymousView == null)
        {
          Log.e("MicroMsg.ServiceNotifyConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this).getCount()) });
          ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this).notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(256810);
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$9", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousAdapterView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$9", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this);
          ServiceNotifyConversationUI.a.x(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(256810);
          return;
        }
      }
    });
    this.afsr.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int eB(View paramAnonymousView)
      {
        AppMethodBeat.i(256496);
        int i = ServiceNotifyConversationUI.c(ServiceNotifyConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(256496);
        return i;
      }
    });
    this.afsr.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(256489);
        ServiceNotifyConversationUI.c(ServiceNotifyConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(256489);
      }
    });
    AppMethodBeat.o(256715);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(256721);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.talker != null) && (!this.talker.isEmpty())) {
      this.talker = "";
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(256721);
      return;
    }
    AppMethodBeat.o(256721);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256696);
    super.onCreate(paramBundle);
    if (!bh.baz())
    {
      Log.e("MicroMsg.ServiceNotifyConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(256696);
      return;
    }
    this.ovT = "notifymessage";
    this.afpa = getIntent().getStringExtra("enterprise_biz_display_name");
    if (Util.isNullOrNil(this.afpa)) {
      this.afpa = getString(R.l.hardcode_plugin_notify_message_nick);
    }
    initView();
    removeAllOptionMenu();
    addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, false, new ServiceNotifyConversationUI.4(this));
    bh.bCz();
    c.bzG().add(this.afsr);
    this.afss = new i.a()
    {
      public final void onNotifyChange(i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(256494);
        if ((paramAnonymousi != null) && (paramAnonymousc.mZo != null))
        {
          paramAnonymousi = paramAnonymousc.mZo.iterator();
          while (paramAnonymousi.hasNext())
          {
            Object localObject = (cc)paramAnonymousi.next();
            if ((localObject != null) && ("notifymessage".equals(paramAnonymousc.talker)))
            {
              bh.bCz();
              localObject = c.getNotifyMessageRecordStorage().z((cc)localObject);
              if ((!Util.isNullOrNil((String)localObject)) && (ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this) != null)) {
                ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this).onNotifyChange((String)localObject, null);
              }
            }
          }
        }
        AppMethodBeat.o(256494);
      }
    };
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.afss, Looper.getMainLooper());
    AppMethodBeat.o(256696);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(256702);
    if (this.afss != null)
    {
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.afss);
      this.afss = null;
    }
    if (bh.baz())
    {
      bh.bCz();
      c.bzG().remove(this.afsr);
    }
    if (this.afsr != null) {
      this.afsr.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(256702);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(256709);
    Log.i("MicroMsg.ServiceNotifyConversationUI", "on pause");
    if (this.afsr != null) {
      this.afsr.onPause();
    }
    super.onPause();
    AppMethodBeat.o(256709);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(256704);
    Log.v("MicroMsg.ServiceNotifyConversationUI", "on resume");
    if (this.afsr != null) {
      this.afsr.onResume();
    }
    super.onResume();
    AppMethodBeat.o(256704);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends g
  {
    private Set<String> afsu;
    private String username;
    
    public a(Context paramContext, String paramString, x.a parama)
    {
      super(parama);
      AppMethodBeat.i(256550);
      this.afsu = new HashSet();
      this.username = paramString;
      AppMethodBeat.o(256550);
    }
    
    private static String x(Cursor paramCursor)
    {
      AppMethodBeat.i(256561);
      int i = paramCursor.getColumnIndex("talker");
      if (i >= 0)
      {
        paramCursor = paramCursor.getString(i);
        AppMethodBeat.o(256561);
        return paramCursor;
      }
      AppMethodBeat.o(256561);
      return null;
    }
    
    public static void x(bb parambb)
    {
      AppMethodBeat.i(256557);
      com.tencent.mm.plugin.report.service.h.OAn.b(21825, new Object[] { Integer.valueOf(5), parambb.field_username, Long.valueOf(Util.nowSecond()), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(256557);
    }
    
    public final bb a(bb parambb, Cursor paramCursor)
    {
      AppMethodBeat.i(256570);
      bb localbb = parambb;
      if (parambb == null) {
        localbb = new bb();
      }
      localbb.setUsername(x(paramCursor));
      int i = paramCursor.getColumnIndex("createTime");
      long l;
      if (i >= 0)
      {
        l = paramCursor.getLong(i);
        localbb.gR(l);
        i = paramCursor.getColumnIndex("digest");
        if (i < 0) {
          break label141;
        }
      }
      label141:
      for (parambb = paramCursor.getString(i);; parambb = null)
      {
        localbb.BF(parambb);
        localbb.BH("notifymessage");
        localbb.setStatus(2);
        localbb.pI(1);
        localbb.pG(0);
        localbb.BE(Integer.toString(1));
        localbb.BG("");
        AppMethodBeat.o(256570);
        return localbb;
        l = 0L;
        break;
      }
    }
    
    protected final void a(bb parambb, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      AppMethodBeat.i(256580);
      if (Util.isNullOrNil(parambb.field_username))
      {
        AppMethodBeat.o(256580);
        return;
      }
      this.afsu.add(parambb.field_username);
      AppMethodBeat.o(256580);
    }
    
    public final void aNy()
    {
      AppMethodBeat.i(256564);
      fSd();
      bh.bCz();
      w(c.getNotifyMessageRecordStorage().bwz());
      if (this.adDx != null) {
        this.adDx.bWC();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(256564);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(256577);
      paramViewGroup = super.getView(paramInt, paramView, paramViewGroup);
      g.g localg = (g.g)paramViewGroup.getTag();
      if (localg.aebj.getText() == null)
      {
        AppMethodBeat.o(256577);
        return paramViewGroup;
      }
      String str = localg.aebj.getText().toString();
      paramView = null;
      al localal;
      if (au.Hh(str))
      {
        localal = ad.XE(str);
        if (localal == null) {}
      }
      for (paramView = localal.nickname;; paramView = aa.getDisplayName(str))
      {
        if (!Util.nullAsNil(str).equals(paramView)) {
          localg.aebj.setText(paramView);
        }
        AppMethodBeat.o(256577);
        return paramViewGroup;
      }
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(256587);
      Object localObject1 = Fv();
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
      for (localObject1 = null;; localObject1 = String.format(Locale.US, "%d:%d:%d", new Object[] { Integer.valueOf(((ServiceNotifyConversationUI.b)localObject1).afsw), Integer.valueOf(((ServiceNotifyConversationUI.b)localObject1).afsv), Integer.valueOf(((ServiceNotifyConversationUI.b)localObject1).afsx) }))
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(21825, new Object[] { Integer.valueOf(4), null, Long.valueOf(Util.nowSecond()), localObject1, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        super.onDestroy();
        AppMethodBeat.o(256587);
        return;
        label125:
        Object localObject2 = new HashSet();
        String str;
        do
        {
          str = x((Cursor)localObject1);
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
            if (au.Hh(str)) {
              ((ServiceNotifyConversationUI.b)localObject1).afsv += 1;
            } else if (Util.nullAsNil(str).startsWith("gh_")) {
              ((ServiceNotifyConversationUI.b)localObject1).afsw += 1;
            } else {
              ((ServiceNotifyConversationUI.b)localObject1).afsx += 1;
            }
          }
        }
        break;
      }
    }
  }
  
  static final class b
  {
    public int afsv;
    public int afsw;
    public int afsx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ServiceNotifyConversationUI
 * JD-Core Version:    0.7.0.1
 */