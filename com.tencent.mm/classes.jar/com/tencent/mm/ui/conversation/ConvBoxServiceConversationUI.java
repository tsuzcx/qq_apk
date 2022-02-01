package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.appbrand.e;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.x.a;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConvBoxServiceConversationUI
  extends BaseConversationUI
{
  static final String TAG = "MicroMsg.ConvBoxServiceConversationUI";
  private View contentView;
  
  public void finish()
  {
    AppMethodBeat.i(256576);
    super.finish();
    ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.n.class)).cJu();
    AppMethodBeat.o(256576);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256571);
    super.onCreate(paramBundle);
    this.contentView = com.tencent.mm.ui.af.mU(this).inflate(R.i.geL, null);
    setContentView(this.contentView);
    this.conversationFm = new ConvBoxServiceConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(R.h.fOk, this.conversationFm).FW();
    com.tencent.mm.pluginsdk.h.b(this, this.contentView);
    AppMethodBeat.o(256571);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class ConvBoxServiceConversationFmUI
    extends BaseConversationUI.BaseConversationFmUI
  {
    public static final int CONTEXT_MENU_LONGCLICK_DELETE = 4;
    public static final int CONTEXT_MENU_LONGCLICK_DISMISS = 3;
    public static final int CONTEXT_MENU_LONGCLICK_MARK_READ = 2;
    public static final int CONTEXT_MENU_LONGCLICK_SET_UN_READ = 1;
    private static final String TAG = "MicroMsg.ConvBoxServiceConversationFmUI";
    private g adapter;
    private ListView appbrandMessageLV;
    private bb conversation;
    private TextView emptyTipTv;
    boolean isFirstOnResume = true;
    private String mAppId;
    private String superUsername;
    private String talker = "";
    private w tipDialog = null;
    private int x_down;
    private int y_down;
    
    private boolean isReaded(String paramString)
    {
      AppMethodBeat.i(256675);
      bh.bCz();
      paramString = c.bzG().bxM(paramString);
      if (paramString != null)
      {
        if ((paramString.field_unReadCount <= 0) && (!paramString.rx(1048576)))
        {
          AppMethodBeat.o(256675);
          return true;
        }
        AppMethodBeat.o(256675);
        return false;
      }
      AppMethodBeat.o(256675);
      return false;
    }
    
    private void setShowView(int paramInt)
    {
      AppMethodBeat.i(256680);
      if (paramInt <= 0)
      {
        this.emptyTipTv.setVisibility(0);
        this.appbrandMessageLV.setVisibility(8);
        AppMethodBeat.o(256680);
        return;
      }
      this.emptyTipTv.setVisibility(8);
      this.appbrandMessageLV.setVisibility(0);
      AppMethodBeat.o(256680);
    }
    
    public int getLayoutId()
    {
      return R.i.tmessage;
    }
    
    public String getUserName()
    {
      return this.superUsername;
    }
    
    protected void initView()
    {
      AppMethodBeat.i(256742);
      setMMTitle(getString(R.l.gDs));
      this.appbrandMessageLV = ((ListView)findViewById(R.h.tmessage_lv));
      this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
      this.emptyTipTv.setTextColor(getResources().getColor(R.e.FG_2));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.emptyTipTv.getLayoutParams();
      localLayoutParams.topMargin = 200;
      this.emptyTipTv.setLayoutParams(localLayoutParams);
      this.emptyTipTv.setText(R.l.gDr);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(256705);
          ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.finish();
          AppMethodBeat.o(256705);
          return true;
        }
      });
      this.adapter = new a(thisActivity(), this.superUsername, new x.a()
      {
        public final void bWC()
        {
          AppMethodBeat.i(256708);
          ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.access$100(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this, ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.adapter.getCount());
          AppMethodBeat.o(256708);
        }
      });
      this.adapter.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int eB(View paramAnonymousView)
        {
          AppMethodBeat.i(256707);
          int i = ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(paramAnonymousView);
          AppMethodBeat.o(256707);
          return i;
        }
      });
      this.adapter.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(256706);
          ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.appbrandMessageLV.performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(256706);
        }
      });
      this.appbrandMessageLV.setAdapter(this.adapter);
      this.appbrandMessageLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(256717);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/ConvBoxServiceConversationUI$ConvBoxServiceConversationFmUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.access$302(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this, (bb)ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.adapter.getItem(paramAnonymousInt));
          paramAnonymousAdapterView = ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.conversation;
          if (paramAnonymousAdapterView == null)
          {
            Log.e("MicroMsg.ConvBoxServiceConversationFmUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.adapter.getCount()) });
            ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.adapter.notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConvBoxServiceConversationUI$ConvBoxServiceConversationFmUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(256717);
            return;
          }
          if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramAnonymousAdapterView.field_username) == null)
          {
            Log.e("MicroMsg.ConvBoxServiceConversationFmUI", "position=%s cont is null", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConvBoxServiceConversationUI$ConvBoxServiceConversationFmUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(256717);
            return;
          }
          paramAnonymousView = new Bundle();
          paramAnonymousView.putInt("specific_chat_from_scene", 7);
          paramAnonymousView.putInt("KOpenArticleSceneFromScene", 93);
          paramAnonymousView.putInt("chat_from_scene_for_group_chats", 3);
          paramAnonymousView.putInt("Main_IndexInSessionList", paramAnonymousInt);
          paramAnonymousView.putInt("Main_UnreadCount", paramAnonymousAdapterView.field_unReadCount);
          paramAnonymousView.putInt("chat_from_scene", 0);
          ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.ui.startChatting(paramAnonymousAdapterView.field_username, paramAnonymousView, true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConvBoxServiceConversationUI$ConvBoxServiceConversationFmUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(256717);
        }
      });
      this.appbrandMessageLV.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(256716);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(256716);
            return false;
            ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.hideVKB();
            ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.access$402(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this, (int)paramAnonymousMotionEvent.getRawX());
            ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.access$502(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this, (int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.appbrandMessageLV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(256722);
          ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.access$302(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this, (bb)ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.adapter.getItem(paramAnonymousInt));
          ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.access$602(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this, ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.conversation.field_username);
          new com.tencent.mm.ui.widget.b.a(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.getContext()).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, new View.OnCreateContextMenuListener()new u.i
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(256640);
              if (ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.access$700(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this, ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker)) {
                paramAnonymous2ContextMenu.add(0, 1, 0, R.l.gNf);
              }
              for (;;)
              {
                paramAnonymous2ContextMenu.add(paramAnonymousInt, 3, 0, R.l.main_conversation_dismiss);
                paramAnonymous2ContextMenu.add(paramAnonymousInt, 4, 0, R.l.gDv);
                AppMethodBeat.o(256640);
                return;
                paramAnonymous2ContextMenu.add(0, 2, 0, R.l.gNd);
              }
            }
          }, new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(256646);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(256646);
                return;
                bh.bCz();
                c.bzG().bxQ(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker);
                com.tencent.mm.modelstat.b.oUZ.ab(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker, true);
                com.tencent.mm.modelsimple.ac.aZ(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker, 13);
                AppMethodBeat.o(256646);
                return;
                bh.bCz();
                c.bzG().bxO(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker);
                MMAppMgr.iH(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker);
                com.tencent.mm.modelsimple.ac.aZ(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker, 1);
                com.tencent.mm.modelstat.b.oUZ.ab(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker, false);
                com.tencent.mm.modelgetchatroommsg.b.bJr();
                com.tencent.mm.modelgetchatroommsg.b.NJ(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker);
                AppMethodBeat.o(256646);
                return;
                com.tencent.mm.ui.h.c(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.thisActivity(), new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(256693);
                    if ((au.bwg(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker)) || (au.bvW(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker)))
                    {
                      bh.bCz();
                      c.bzG().bxL(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker);
                    }
                    for (;;)
                    {
                      com.tencent.mm.modelsimple.ac.aY(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker, 14);
                      AppMethodBeat.o(256693);
                      return;
                      if ((com.tencent.mm.an.g.MB(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker)) || (com.tencent.mm.an.g.Dn(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker)))
                      {
                        com.tencent.mm.an.af.bHi().MV(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker);
                        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxK(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker);
                      }
                      else
                      {
                        com.tencent.mm.model.ac.Jk(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker);
                      }
                    }
                  }
                });
                AppMethodBeat.o(256646);
                return;
                paramAnonymous2MenuItem = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(256697);
                    com.tencent.threadpool.h.ahAA.bm(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(256503);
                        bh.bCz();
                        c.bzG().bxK(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker);
                        AppMethodBeat.o(256503);
                      }
                    });
                    AppMethodBeat.o(256697);
                  }
                };
                d.a(ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.talker, ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.appbrandMessageLV.getContext(), ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.conversation, paramAnonymous2MenuItem, true, false);
              }
            }
          }, ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.x_down, ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.y_down);
          AppMethodBeat.o(256722);
          return true;
        }
      });
      this.adapter.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int eB(View paramAnonymousView)
        {
          AppMethodBeat.i(256719);
          int i = ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(paramAnonymousView);
          AppMethodBeat.o(256719);
          return i;
        }
      });
      this.adapter.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(256666);
          ConvBoxServiceConversationUI.ConvBoxServiceConversationFmUI.this.appbrandMessageLV.performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(256666);
        }
      });
      AppMethodBeat.o(256742);
    }
    
    public void onActivityCreated(Bundle paramBundle)
    {
      AppMethodBeat.i(256724);
      Log.i("MicroMsg.ConvBoxServiceConversationFmUI", "onActivityCreated");
      super.onActivityCreated(paramBundle);
      this.superUsername = getStringExtra("Contact_User");
      if (TextUtils.isEmpty(this.superUsername)) {
        this.superUsername = "conversationboxservice";
      }
      initView();
      bh.bCz();
      c.bzG().add(this.adapter);
      AppMethodBeat.o(256724);
    }
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(256747);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if ((this.talker != null) && (!this.talker.isEmpty())) {
        this.talker = "";
      }
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(256747);
        return;
      }
      AppMethodBeat.o(256747);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(256732);
      if (bh.baz())
      {
        bh.bCz();
        c.bzG().remove(this.adapter);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().remove(this.adapter);
      if (this.adapter != null) {
        this.adapter.onDestroy();
      }
      super.onDestroy();
      AppMethodBeat.o(256732);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(256738);
      Log.i("MicroMsg.ConvBoxServiceConversationFmUI", "on pause");
      bh.bCz();
      c.bzG().bxO(this.superUsername);
      if (this.adapter != null) {
        this.adapter.onPause();
      }
      com.tencent.mm.modelsimple.ac.aZ("@placeholder_foldgroup", 1);
      super.onPause();
      AppMethodBeat.o(256738);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(256735);
      Log.i("MicroMsg.ConvBoxServiceConversationFmUI", "on resume");
      if (this.adapter != null) {
        this.adapter.onResume();
      }
      this.adapter.aNy();
      if (this.isFirstOnResume)
      {
        com.tencent.mm.modelsimple.ac.aZ("@placeholder_foldgroup", 1);
        this.isFirstOnResume = false;
      }
      super.onResume();
      AppMethodBeat.o(256735);
    }
    
    static final class a
      extends g
    {
      private HashMap<String, String> afmt;
      private List<String> maB;
      private Paint paint;
      private String username;
      
      a(Context paramContext, String paramString, x.a parama)
      {
        super(parama);
        AppMethodBeat.i(256626);
        this.paint = new Paint();
        this.username = paramString;
        this.afmt = new HashMap();
        this.maB = new ArrayList();
        AppMethodBeat.o(256626);
      }
      
      protected final void a(String paramString, final g.g paramg)
      {
        AppMethodBeat.i(256644);
        Object localObject2 = (String)this.afmt.get(paramString);
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = e.bzV(e.bzU(paramString));
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            this.afmt.put(paramString, localObject2);
            localObject1 = localObject2;
          }
        }
        final int j;
        int m;
        int n;
        int k;
        final int i;
        float f1;
        label267:
        float f2;
        label294:
        float f4;
        int i1;
        int i2;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramg.afno.setVisibility(0);
          localObject1 = this.context.getString(R.l.grA, new Object[] { localObject1 });
          paramg.afno.setText((CharSequence)localObject1);
          j = 0;
          if (this.context.getResources().getDisplayMetrics() != null) {
            j = this.context.getResources().getDisplayMetrics().widthPixels;
          }
          m = paramg.aebk.getLayoutParams().width;
          if (com.tencent.mm.cd.a.mp(this.context))
          {
            n = this.context.getResources().getDimensionPixelOffset(R.f.NormalAvatarWrapLargeSize);
            k = n;
            i = m;
            if (m < 0)
            {
              i = this.context.getResources().getDimensionPixelOffset(R.f.ConversationTimeSmallWidth);
              k = n;
            }
            m = this.context.getResources().getDimensionPixelOffset(R.f.LargePadding);
            n = this.context.getResources().getDimensionPixelOffset(R.f.LargePadding);
            localObject1 = bCe(paramString);
            localObject2 = paramg.aebj;
            if ((localObject2 != null) && (localObject1 != null)) {
              break label759;
            }
            f1 = 0.0F;
            f2 = 48.0F + f1;
            localObject2 = paramg.aebj;
            if ((localObject2 != null) && (!Util.isNullOrNil((String)localObject1))) {
              break label773;
            }
            f1 = 0.0F;
            f4 = (int)Math.min(f2, f1 + 48.0F);
            Log.i("MicroMsg.ConversationAdapter", "nickNameMinWidth:%f", new Object[] { Float.valueOf(f4) });
            i1 = this.context.getResources().getDimensionPixelOffset(R.f.ConversationTimeSmallerWidth);
            i2 = this.context.getResources().getDimensionPixelOffset(R.f.LittlePadding);
            Log.i("MicroMsg.ConversationAdapter", "screenWidth:%d, avatarLayoutWidth:%d, timeTVWidth:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
            if (j <= 0) {
              break label888;
            }
          }
        }
        label464:
        label759:
        label888:
        for (float f3 = j - k - m * 2 - i - n - i2;; f3 = 0.0F)
        {
          if ((f2 <= f3) && (f2 < f3) && (f3 > 0.0F))
          {
            f1 = Math.min(f2 / f3, (f3 - i1) / f3);
            f2 = 1.0F - f1;
            Log.i("MicroMsg.ConversationAdapter", "nickNameParentRemainWidth: %f, nicknameTVWeight:%f, sourceTVWeight:%f", new Object[] { Float.valueOf(f3), Float.valueOf(f1), Float.valueOf(f2) });
            if (f3 <= 0.0F) {
              break label885;
            }
            f4 = Math.min(1.0F, f4 / f3);
            if (f4 <= f1) {
              break label885;
            }
            f2 = 1.0F - f4;
            f1 = f4;
          }
          for (;;)
          {
            Log.i("MicroMsg.ConversationAdapter", "weight fixed, nicknameTVWeight:%f, sourceTVWeight:%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
            if (WeChatEnvironment.hasDebugger())
            {
              i = (int)(i2 + f3);
              j = (int)(f1 * f3);
              paramg.aebj.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(256599);
                  ViewParent localViewParent = paramg.aebj.getParent();
                  if ((localViewParent instanceof View)) {}
                  for (int i = ((View)localViewParent).getWidth();; i = 0)
                  {
                    Log.i("MicroMsg.ConversationAdapter", "expected nicknameParent width: %d, nicknameParent width:%d, expected nickname width: %d, nickname width:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramg.aebj.getWidth()) });
                    AppMethodBeat.o(256599);
                    return;
                  }
                }
              });
            }
            localObject1 = (LinearLayout.LayoutParams)paramg.aebj.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = 0;
            ((LinearLayout.LayoutParams)localObject1).weight = f1;
            paramg.aebj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            localObject1 = (LinearLayout.LayoutParams)paramg.afno.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = 0;
            ((LinearLayout.LayoutParams)localObject1).weight = f2;
            paramg.afno.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            for (;;)
            {
              a.b.a(paramg.lBC, paramString, 0.1F, false);
              if (!this.maB.contains(paramString)) {
                this.maB.add(paramString);
              }
              AppMethodBeat.o(256644);
              return;
              n = this.context.getResources().getDimensionPixelOffset(R.f.NormalAvatarWrapSize);
              k = n;
              i = m;
              if (m >= 0) {
                break;
              }
              i = this.context.getResources().getDimensionPixelOffset(R.f.ConversationTimeSmallerWidth);
              k = n;
              break;
              f1 = ((NoMeasuredTextView)localObject2).getPaint().measureText((String)localObject1);
              break label267;
              localObject1 = ((String)localObject1).substring(0, ((String)localObject1).offsetByCodePoints(0, 1)) + "…";
              Log.i("MicroMsg.ConversationAdapter", "getMinTextWidth, minText: ".concat(String.valueOf(localObject1)));
              f1 = ((NoMeasuredTextView)localObject2).getPaint().measureText((String)localObject1);
              break label294;
              f1 = 0.6F;
              f2 = 0.4F;
              break label464;
              localObject1 = (LinearLayout.LayoutParams)paramg.aebj.getLayoutParams();
              ((LinearLayout.LayoutParams)localObject1).width = -1;
              ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
              paramg.aebj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
          }
        }
      }
      
      public final void aNy()
      {
        AppMethodBeat.i(256633);
        bh.bCz();
        w(c.bzG().a(5, this.lMF, "conversationboxservice"));
        if (this.adDx != null) {
          this.adDx.bWC();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(256633);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConvBoxServiceConversationUI
 * JD-Core Version:    0.7.0.1
 */