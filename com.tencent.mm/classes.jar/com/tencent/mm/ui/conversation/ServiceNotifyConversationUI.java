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
import com.tencent.mm.g.c.bb;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.config.ae;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
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
import com.tencent.mm.ui.s.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class ServiceNotifyConversationUI
  extends MMActivity
{
  private String Qbv;
  private ListView Qhj;
  private a Qhk;
  private i.a Qhl;
  private az conversation;
  private TextView emptyTipTv;
  private String iNV;
  private String talker = "";
  
  public int getLayoutId()
  {
    return 2131496720;
  }
  
  public void initView()
  {
    AppMethodBeat.i(234279);
    setMMTitle(this.Qbv);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(234259);
        ServiceNotifyConversationUI.this.finish();
        AppMethodBeat.o(234259);
        return true;
      }
    });
    setTitleBarDoubleClickListener(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234260);
        if ((ServiceNotifyConversationUI.this.activityHasDestroyed()) || (ServiceNotifyConversationUI.this.isFinishing()))
        {
          AppMethodBeat.o(234260);
          return;
        }
        ServiceNotifyConversationUI.b(ServiceNotifyConversationUI.this);
        AppMethodBeat.o(234260);
      }
    });
    this.Qhj = ((ListView)findViewById(2131309254));
    this.emptyTipTv = ((TextView)findViewById(2131300096));
    this.emptyTipTv.setText(2131763702);
    this.Qhk = new a(this, this.iNV, new s.a()
    {
      public final void bnE()
      {
        AppMethodBeat.i(234261);
        ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this, ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this).getCount());
        AppMethodBeat.o(234261);
      }
    });
    this.Qhk.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dr(View paramAnonymousView)
      {
        AppMethodBeat.i(234262);
        int i = ServiceNotifyConversationUI.c(ServiceNotifyConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(234262);
        return i;
      }
    });
    this.Qhk.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(234263);
        ServiceNotifyConversationUI.c(ServiceNotifyConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(234263);
      }
    });
    this.Qhj.setAdapter(this.Qhk);
    this.Qhj.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(234264);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousAdapterView);
        ((b)localObject).bm(paramAnonymousView);
        ((b)localObject).pH(paramAnonymousInt);
        ((b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).axR());
        ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this, (az)ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this).getItem(paramAnonymousInt));
        ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this, ServiceNotifyConversationUI.d(ServiceNotifyConversationUI.this).field_username);
        paramAnonymousView = ServiceNotifyConversationUI.d(ServiceNotifyConversationUI.this);
        if (paramAnonymousView == null)
        {
          Log.e("MicroMsg.ServiceNotifyConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this).getCount()) });
          ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this).notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(234264);
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousAdapterView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this);
          ServiceNotifyConversationUI.a.n(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(234264);
          return;
        }
      }
    });
    this.Qhk.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dr(View paramAnonymousView)
      {
        AppMethodBeat.i(234265);
        int i = ServiceNotifyConversationUI.c(ServiceNotifyConversationUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(234265);
        return i;
      }
    });
    this.Qhk.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(234257);
        ServiceNotifyConversationUI.c(ServiceNotifyConversationUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(234257);
      }
    });
    AppMethodBeat.o(234279);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(234280);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.talker != null) && (!this.talker.isEmpty())) {
      this.talker = "";
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(234280);
      return;
    }
    AppMethodBeat.o(234280);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(234275);
    super.onCreate(paramBundle);
    if (!bg.aAc())
    {
      Log.e("MicroMsg.ServiceNotifyConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(234275);
      return;
    }
    this.iNV = "notifymessage";
    this.Qbv = getIntent().getStringExtra("enterprise_biz_display_name");
    if (Util.isNullOrNil(this.Qbv)) {
      this.Qbv = getString(2131761573);
    }
    initView();
    removeAllOptionMenu();
    addIconOptionMenu(0, 2131755153, 2131689513, false, new ServiceNotifyConversationUI.3(this));
    bg.aVF();
    c.aST().add(this.Qhk);
    this.Qhl = new i.a()
    {
      public final void a(i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(234256);
        if ((paramAnonymousi != null) && (paramAnonymousc.hIs != null))
        {
          paramAnonymousi = paramAnonymousc.hIs.iterator();
          while (paramAnonymousi.hasNext())
          {
            Object localObject = (ca)paramAnonymousi.next();
            if ((localObject != null) && ("notifymessage".equals(paramAnonymousc.talker)))
            {
              bg.aVF();
              c.getNotifyMessageRecordStorage();
              localObject = cf.bc((ca)localObject);
              if ((!Util.isNullOrNil((String)localObject)) && (ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this) != null)) {
                ServiceNotifyConversationUI.a(ServiceNotifyConversationUI.this).onNotifyChange((String)localObject, null);
              }
            }
          }
        }
        AppMethodBeat.o(234256);
      }
    };
    ((l)g.af(l.class)).eiy().a(this.Qhl, Looper.getMainLooper());
    AppMethodBeat.o(234275);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(234276);
    if (this.Qhl != null)
    {
      ((l)g.af(l.class)).eiy().a(this.Qhl);
      this.Qhl = null;
    }
    if (bg.aAc())
    {
      bg.aVF();
      c.aST().remove(this.Qhk);
    }
    if (this.Qhk != null) {
      this.Qhk.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(234276);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(234278);
    Log.i("MicroMsg.ServiceNotifyConversationUI", "on pause");
    if (this.Qhk != null) {
      this.Qhk.onPause();
    }
    super.onPause();
    AppMethodBeat.o(234278);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(234277);
    Log.v("MicroMsg.ServiceNotifyConversationUI", "on resume");
    if (this.Qhk != null) {
      this.Qhk.onResume();
    }
    super.onResume();
    AppMethodBeat.o(234277);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends e
  {
    private Set<String> Qhn;
    private String username;
    
    public a(Context paramContext, String paramString, s.a parama)
    {
      super(parama);
      AppMethodBeat.i(234266);
      this.Qhn = new HashSet();
      this.username = paramString;
      AppMethodBeat.o(234266);
    }
    
    public static void n(az paramaz)
    {
      AppMethodBeat.i(234272);
      h.CyF.a(21825, new Object[] { Integer.valueOf(5), paramaz.field_username, Long.valueOf(Util.nowSecond()), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(234272);
    }
    
    private static String s(Cursor paramCursor)
    {
      AppMethodBeat.i(234273);
      int i = paramCursor.getColumnIndex("talker");
      if (i >= 0)
      {
        paramCursor = paramCursor.getString(i);
        AppMethodBeat.o(234273);
        return paramCursor;
      }
      AppMethodBeat.o(234273);
      return null;
    }
    
    public final az a(az paramaz, Cursor paramCursor)
    {
      AppMethodBeat.i(234268);
      az localaz = paramaz;
      if (paramaz == null) {
        localaz = new az();
      }
      localaz.setUsername(s(paramCursor));
      int i = paramCursor.getColumnIndex("createTime");
      long l;
      if (i >= 0)
      {
        l = paramCursor.getLong(i);
        localaz.yA(l);
        i = paramCursor.getColumnIndex("digest");
        if (i < 0) {
          break label141;
        }
      }
      label141:
      for (paramaz = paramCursor.getString(i);; paramaz = null)
      {
        localaz.Cm(paramaz);
        localaz.Co("notifymessage");
        localaz.setStatus(2);
        localaz.nv(1);
        localaz.nt(0);
        localaz.Cl(Integer.toString(1));
        localaz.Cn("");
        AppMethodBeat.o(234268);
        return localaz;
        l = 0L;
        break;
      }
    }
    
    protected final void a(az paramaz, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      AppMethodBeat.i(234270);
      if (Util.isNullOrNil(paramaz.field_username))
      {
        AppMethodBeat.o(234270);
        return;
      }
      this.Qhn.add(paramaz.field_username);
      AppMethodBeat.o(234270);
    }
    
    public final void anp()
    {
      AppMethodBeat.i(234267);
      ebf();
      bg.aVF();
      setCursor(c.getNotifyMessageRecordStorage().gEk());
      if (this.OFI != null) {
        this.OFI.bnE();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(234267);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(234269);
      paramViewGroup = super.getView(paramInt, paramView, paramViewGroup);
      e.g localg = (e.g)paramViewGroup.getTag();
      if (localg.PaE.getText() == null)
      {
        AppMethodBeat.o(234269);
        return paramViewGroup;
      }
      String str = localg.PaE.getText().toString();
      paramView = null;
      ae localae;
      if (as.HF(str))
      {
        localae = y.Xr(str);
        if (localae == null) {}
      }
      for (paramView = localae.nickname;; paramView = aa.getDisplayName(str))
      {
        if (!Util.nullAsNil(str).equals(paramView)) {
          localg.PaE.setText(paramView);
        }
        AppMethodBeat.o(234269);
        return paramViewGroup;
      }
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(234271);
      Object localObject1 = getCursor();
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
      for (localObject1 = null;; localObject1 = String.format(Locale.US, "%d,%d,%d", new Object[] { Integer.valueOf(((ServiceNotifyConversationUI.b)localObject1).Qhp), Integer.valueOf(((ServiceNotifyConversationUI.b)localObject1).Qho), Integer.valueOf(((ServiceNotifyConversationUI.b)localObject1).Qhq) }))
      {
        h.CyF.a(21825, new Object[] { Integer.valueOf(4), null, Long.valueOf(Util.nowSecond()), localObject1, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        super.onDestroy();
        AppMethodBeat.o(234271);
        return;
        label125:
        Object localObject2 = new HashSet();
        String str;
        do
        {
          str = s((Cursor)localObject1);
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
            if (as.HF(str)) {
              ((ServiceNotifyConversationUI.b)localObject1).Qho += 1;
            } else if (Util.nullAsNil(str).startsWith("gh_")) {
              ((ServiceNotifyConversationUI.b)localObject1).Qhp += 1;
            } else {
              ((ServiceNotifyConversationUI.b)localObject1).Qhq += 1;
            }
          }
        }
        break;
      }
    }
  }
  
  static final class b
  {
    public int Qho;
    public int Qhp;
    public int Qhq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ServiceNotifyConversationUI
 * JD-Core Version:    0.7.0.1
 */