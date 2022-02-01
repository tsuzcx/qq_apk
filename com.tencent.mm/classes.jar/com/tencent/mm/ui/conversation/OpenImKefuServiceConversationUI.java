package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.openim.api.OpenIMKefuStartConversationRequest;
import com.tencent.mm.openim.api.c.a;
import com.tencent.mm.openim.api.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.dyf;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.appbrand.f;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.x.a;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@com.tencent.mm.ui.widget.pulldown.c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI;", "Lcom/tencent/mm/ui/conversation/BaseConversationUI;", "()V", "backToLauncherUIWhenFinish", "", "getBackToLauncherUIWhenFinish", "()Z", "backToLauncherUIWhenFinish$delegate", "Lkotlin/Lazy;", "fromScene", "", "getFromScene", "()I", "fromScene$delegate", "hasJumped", "isConfirmPageShown", "isConfirmPageShown$delegate", "mContentView", "Landroid/view/View;", "startConversationRequest", "Lcom/tencent/mm/openim/api/OpenIMKefuStartConversationRequest;", "getStartConversationRequest", "()Lcom/tencent/mm/openim/api/OpenIMKefuStartConversationRequest;", "startConversationRequest$delegate", "getChattingUIFragment", "Lcom/tencent/mm/ui/chatting/ChattingUIFragment;", "handleBack", "handleJump", "", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "reportEnter", "Companion", "OpenImKefuChattingUIFragment", "OpenImKefuServiceConversationFmUI", "SendAppMsgRunnable", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OpenImKefuServiceConversationUI
  extends BaseConversationUI
{
  public static final a afrK;
  private final kotlin.j BlM;
  private final kotlin.j afrH;
  private final kotlin.j afrI;
  private boolean afrL;
  private final kotlin.j afrM;
  private View mContentView;
  
  static
  {
    AppMethodBeat.i(256694);
    afrK = new a((byte)0);
    AppMethodBeat.o(256694);
  }
  
  public OpenImKefuServiceConversationUI()
  {
    AppMethodBeat.i(256673);
    this.afrH = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.afrI = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.afrM = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.BlM = kotlin.k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(256673);
  }
  
  private final int getFromScene()
  {
    AppMethodBeat.i(256681);
    int i = ((Number)this.BlM.getValue()).intValue();
    AppMethodBeat.o(256681);
    return i;
  }
  
  private final OpenIMKefuStartConversationRequest jAY()
  {
    AppMethodBeat.i(256676);
    OpenIMKefuStartConversationRequest localOpenIMKefuStartConversationRequest = (OpenIMKefuStartConversationRequest)this.afrH.getValue();
    AppMethodBeat.o(256676);
    return localOpenIMKefuStartConversationRequest;
  }
  
  private final boolean jAZ()
  {
    AppMethodBeat.i(256679);
    boolean bool = ((Boolean)this.afrI.getValue()).booleanValue();
    AppMethodBeat.o(256679);
    return bool;
  }
  
  protected final ChattingUIFragment getChattingUIFragment()
  {
    AppMethodBeat.i(256720);
    ChattingUIFragment localChattingUIFragment = (ChattingUIFragment)new OpenImKefuChattingUIFragment();
    AppMethodBeat.o(256720);
    return localChattingUIFragment;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(256710);
    if (((Boolean)this.afrM.getValue()).booleanValue())
    {
      Object localObject = new Intent((Context)this, LauncherUI.class);
      ((Intent)localObject).addFlags(67108864);
      ah localah = ah.aiuX;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI", "handleBack", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI", "handleBack", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(MMFragmentActivity.a.upW, MMFragmentActivity.a.upX);
      finish();
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        super.onBackPressed();
      }
      AppMethodBeat.o(256710);
      return;
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(256713);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.pluginsdk.h.b((MMFragmentActivity)this, this.mContentView);
    AppMethodBeat.o(256713);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256699);
    super.onCreate(paramBundle);
    this.mContentView = af.mU((Context)this).inflate(R.i.geL, null);
    setContentView(this.mContentView);
    this.conversationFm = ((BaseConversationUI.BaseConversationFmUI)new OpenImKefuServiceConversationFmUI());
    paramBundle = getSupportFragmentManager().beginTransaction();
    s.s(paramBundle, "supportFragmentManager.beginTransaction()");
    paramBundle.a(R.h.fOk, (Fragment)this.conversationFm).FW();
    com.tencent.mm.pluginsdk.h.b((MMFragmentActivity)this, this.mContentView);
    this.afrL = false;
    com.tencent.mm.openim.d.a.xI(2);
    if (getFromScene() == 1) {
      com.tencent.mm.openim.d.a.xI(1);
    }
    AppMethodBeat.o(256699);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(256703);
    super.onResume();
    Object localObject;
    boolean bool1;
    if (jAY() != null)
    {
      if (!this.afrL)
      {
        this.afrL = true;
        localObject = jAY();
        s.checkNotNull(localObject);
        Log.i("MicroMsg.OpenImKefuServiceConversationUI", "alvinluo handleJump from startConversationRequest getContactScene: %s, hasJumped: %b, isConfirmPageShown: %s", new Object[] { Integer.valueOf(((OpenIMKefuStartConversationRequest)localObject).prw), Boolean.valueOf(this.afrL), Boolean.valueOf(jAZ()) });
        BaseConversationUI localBaseConversationUI = (BaseConversationUI)this;
        localObject = jAY();
        if (localObject == null) {
          localObject = "";
        }
        for (;;)
        {
          OpenIMKefuStartConversationRequest localOpenIMKefuStartConversationRequest = jAY();
          s.checkNotNull(localOpenIMKefuStartConversationRequest);
          a.b(localBaseConversationUI, (String)localObject, localOpenIMKefuStartConversationRequest.prC, false, (kotlin.g.a.b)new e(this));
          AppMethodBeat.o(256703);
          return;
          localObject = ((OpenIMKefuStartConversationRequest)localObject).pry;
          if (localObject == null)
          {
            localObject = "";
          }
          else
          {
            localObject = ((du)localObject).username;
            if (localObject == null) {
              localObject = "";
            }
          }
        }
      }
    }
    else
    {
      localObject = getIntent();
      if (localObject != null) {
        break label310;
      }
      bool1 = false;
      if ((bool1) && (!this.afrL))
      {
        this.afrL = true;
        localObject = getIntent();
        if (localObject != null) {
          break label322;
        }
        localObject = "";
        label216:
        if (getFromScene() == 2) {
          break label344;
        }
      }
    }
    label310:
    label322:
    label344:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.OpenImKefuServiceConversationUI", "alvinluo handleJump fromScene: %s, needJump: %b, hasJumped: %b, neeChattingAnim: %b", new Object[] { Integer.valueOf(getFromScene()), Boolean.valueOf(bool1), Boolean.valueOf(this.afrL), Boolean.valueOf(bool2) });
      a.a((BaseConversationUI)this, (String)localObject, bool2, false, (kotlin.g.a.b)OpenImKefuServiceConversationUI.a.a.afrN);
      if (getFromScene() == 2) {
        com.tencent.mm.openim.d.a.bm((String)localObject, 25);
      }
      AppMethodBeat.o(256703);
      return;
      bool1 = ((Intent)localObject).getBooleanExtra("open_im_kefu_jump_chatting", false);
      break;
      localObject = ((Intent)localObject).getStringExtra("open_im_kefu_chatting_username");
      if (localObject == null)
      {
        localObject = "";
        break label216;
      }
      break label216;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI$OpenImKefuChattingUIFragment;", "Lcom/tencent/mm/ui/chatting/ChattingUIFragment;", "()V", "isCurrent", "", "(Z)V", "appBrandServiceImageBubble", "Lcom/tencent/mm/ui/appbrand/AppBrandServiceImageBubble;", "openIMStartChattingExtraInfo", "Lcom/tencent/mm/protocal/protobuf/OpenIMStartChattingExtraInfo;", "sendMessageDefaultImg", "", "doCreate", "", "obtainMessageDefaultImg", "onViewAttachedToWindow", "v", "Landroid/view/View;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class OpenImKefuChattingUIFragment
    extends ChattingUIFragment
  {
    private f aeeE;
    private byte[] aeez;
    private final dyf afrQ;
    
    public OpenImKefuChattingUIFragment()
    {
      AppMethodBeat.i(256761);
      this.afrQ = new dyf();
      AppMethodBeat.o(256761);
    }
    
    public OpenImKefuChattingUIFragment(byte paramByte)
    {
      super();
      AppMethodBeat.i(256763);
      this.afrQ = new dyf();
      AppMethodBeat.o(256763);
    }
    
    private static final void a(OpenImKefuChattingUIFragment paramOpenImKefuChattingUIFragment)
    {
      AppMethodBeat.i(256778);
      s.u(paramOpenImKefuChattingUIFragment, "this$0");
      paramOpenImKefuChattingUIFragment.hideVKB();
      com.tencent.mm.message.k.b localb = new com.tencent.mm.message.k.b();
      localb.title = paramOpenImKefuChattingUIFragment.afrQ.rSy;
      localb.type = 33;
      String str2 = paramOpenImKefuChattingUIFragment.afrQ.username;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localb.nTD = str1;
      localb.nTC = paramOpenImKefuChattingUIFragment.afrQ.rSz;
      str2 = paramOpenImKefuChattingUIFragment.afrQ.appId;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localb.nTE = str1;
      localb.nTW = paramOpenImKefuChattingUIFragment.afrQ.qHO;
      localb.nTX = paramOpenImKefuChattingUIFragment.afrQ.pkgVersion;
      str2 = paramOpenImKefuChattingUIFragment.afrQ.rcM;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localb.nTG = str1;
      localb.nTF = 2;
      str2 = paramOpenImKefuChattingUIFragment.afrQ.rcN;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localb.url = str1;
      str2 = paramOpenImKefuChattingUIFragment.afrQ.iconUrl;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localb.nTY = str1;
      localb.iag = ("wxapp_" + paramOpenImKefuChattingUIFragment.afrQ.appId + paramOpenImKefuChattingUIFragment.afrQ.hUf);
      str2 = paramOpenImKefuChattingUIFragment.afrQ.username;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localb.iaa = str1;
      str2 = paramOpenImKefuChattingUIFragment.afrQ.nickname;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localb.iab = str1;
      OpenImKefuServiceConversationUI.b localb1 = new OpenImKefuServiceConversationUI.b();
      str2 = paramOpenImKefuChattingUIFragment.afrQ.appId;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localb1.appId = str1;
      localb1.hWV = localb;
      localb1.rSy = paramOpenImKefuChattingUIFragment.afrQ.rSy;
      localb1.rSA = paramOpenImKefuChattingUIFragment.afrQ.rSA;
      localb1.rSC = paramOpenImKefuChattingUIFragment.afrQ.rSC;
      localb1.NBt = paramOpenImKefuChattingUIFragment.iNh().getTalkerUserName();
      localb1.rSD = paramOpenImKefuChattingUIFragment.afrQ.rSD;
      localb1.aeez = paramOpenImKefuChattingUIFragment.aeez;
      com.tencent.threadpool.h.ahAA.bm((Runnable)localb1);
      AppMethodBeat.o(256778);
    }
    
    private static byte[] jov()
    {
      AppMethodBeat.i(256766);
      try
      {
        Object localObject = BitmapUtil.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        new Canvas((Bitmap)localObject).drawColor(-1);
        localObject = BitmapUtil.Bitmap2Bytes((Bitmap)localObject);
        AppMethodBeat.o(256766);
        return localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.BaseChattingUIFragment", (Throwable)localException, "obtainMessageDefaultImg fail", new Object[0]);
          byte[] arrayOfByte = new byte[0];
        }
      }
    }
    
    public final void jou()
    {
      AppMethodBeat.i(256785);
      super.jou();
      try
      {
        byte[] arrayOfByte = getByteArrayExtra("key_appbrand_chat_info");
        if (arrayOfByte != null) {
          this.afrQ.parseFrom(arrayOfByte);
        }
        this.aeez = jov();
        AppMethodBeat.o(256785);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.BaseChattingUIFragment", (Throwable)localException, "parse OpenIMStartChattingExtraInfo exception", new Object[0]);
        AppMethodBeat.o(256785);
      }
    }
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(256789);
      super.onViewAttachedToWindow(paramView);
      int i;
      f localf;
      if (this.afrQ.rSB)
      {
        if (this.aeeE == null)
        {
          paramView = ((x)iNh().cm(x.class)).jsd();
          this.aeeE = new f((Context)getActivity(), (View)paramView, paramView);
          paramView = this.aeeE;
          s.checkNotNull(paramView);
          paramView.Ykm = false;
        }
        Log.i("MicroMsg.BaseChattingUIFragment", "appBrandServiceImageBubble %s, %s", new Object[] { this.afrQ.rSC, this.afrQ.rSA });
        paramView = (CharSequence)this.afrQ.rSC;
        if ((paramView != null) && (paramView.length() != 0)) {
          break label262;
        }
        i = 1;
        if (i != 0) {
          break label267;
        }
        paramView = com.tencent.mm.modelappbrand.a.b.bEY();
        localf = this.aeeE;
        s.checkNotNull(localf);
        paramView.a((b.k)localf, s.X("file://", this.afrQ.rSC), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).eE(com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 75), com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 60)));
      }
      label262:
      label267:
      label371:
      for (;;)
      {
        paramView = this.aeeE;
        s.checkNotNull(paramView);
        paramView.adNz = new OpenImKefuServiceConversationUI.OpenImKefuChattingUIFragment..ExternalSyntheticLambda0(this);
        paramView = this.aeeE;
        s.checkNotNull(paramView);
        paramView.show();
        AppMethodBeat.o(256789);
        return;
        i = 0;
        break;
        paramView = (CharSequence)this.afrQ.rSA;
        if ((paramView == null) || (paramView.length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label371;
          }
          paramView = com.tencent.mm.modelappbrand.a.b.bEY();
          localf = this.aeeE;
          s.checkNotNull(localf);
          paramView.a((b.k)localf, this.afrQ.rSA, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).eE(com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 75), com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 60)));
          break;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI$OpenImKefuServiceConversationFmUI;", "Lcom/tencent/mm/ui/conversation/BaseConversationUI$BaseConversationFmUI;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "()V", "adapter", "Lcom/tencent/mm/ui/conversation/OpenImKefuConversationAdapter;", "conversation", "Lcom/tencent/mm/storage/Conversation;", "conversationList", "Landroid/widget/ListView;", "emptyTipTv", "Landroid/widget/TextView;", "firstCreate", "", "isDeleteCancel", "menuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "superUsername", "", "talker", "x_down", "", "y_down", "asyncDelMsg", "", "batchGetContact", "clearKefuServiceConversationUnReadCount", "closeConversation", "deleteConversationAndMsg", "doCloseConversation", "getLayoutId", "initData", "initView", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDestroy", "onNotifyChange", "event", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "onPause", "onResume", "setShowView", "count", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class OpenImKefuServiceConversationFmUI
    extends BaseConversationUI.BaseConversationFmUI
    implements MStorageEx.IOnStorageChange
  {
    public static final OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI.a afrR;
    private ListView afrS;
    private r afrT;
    private bb conversation;
    private TextView emptyTipTv;
    private boolean isDeleteCancel;
    private String superUsername;
    private String talker;
    private com.tencent.mm.ui.widget.b.a vEV;
    private final u.i vGU;
    private int x_down;
    private boolean xtT;
    private int y_down;
    
    static
    {
      AppMethodBeat.i(256826);
      afrR = new OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI.a((byte)0);
      AppMethodBeat.o(256826);
    }
    
    public OpenImKefuServiceConversationFmUI()
    {
      AppMethodBeat.i(256771);
      this.talker = "";
      this.xtT = true;
      this.vGU = new OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI..ExternalSyntheticLambda7(this);
      AppMethodBeat.o(256771);
    }
    
    private static final void a(OpenImKefuServiceConversationFmUI paramOpenImKefuServiceConversationFmUI)
    {
      AppMethodBeat.i(256811);
      s.u(paramOpenImKefuServiceConversationFmUI, "this$0");
      Log.i("MicroMsg.OpenImKefuServiceConversationUI", "alvinluo clearKefuServiceConversationUnReadCount");
      bh.bCz();
      com.tencent.mm.model.c.bzG().bxO(paramOpenImKefuServiceConversationFmUI.superUsername);
      AppMethodBeat.o(256811);
    }
    
    private static final void a(OpenImKefuServiceConversationFmUI paramOpenImKefuServiceConversationFmUI, DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(256804);
      s.u(paramOpenImKefuServiceConversationFmUI, "this$0");
      paramOpenImKefuServiceConversationFmUI.isDeleteCancel = true;
      AppMethodBeat.o(256804);
    }
    
    private static final void a(OpenImKefuServiceConversationFmUI paramOpenImKefuServiceConversationFmUI, MenuItem paramMenuItem, int paramInt)
    {
      paramInt = 0;
      AppMethodBeat.i(256781);
      s.u(paramOpenImKefuServiceConversationFmUI, "this$0");
      Object localObject1;
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(256781);
        return;
      case 1: 
        str = paramOpenImKefuServiceConversationFmUI.talker;
        paramMenuItem = (CharSequence)str;
        if ((paramMenuItem == null) || (paramMenuItem.length() == 0)) {
          paramInt = 1;
        }
        if (paramInt != 0)
        {
          Log.e("MicroMsg.OpenImKefuServiceConversationUI", "closeConversation talker invalid");
          AppMethodBeat.o(256781);
          return;
        }
        com.tencent.mm.ui.report.b.a(3, str, paramOpenImKefuServiceConversationFmUI.conversation);
        localContext = (Context)paramOpenImKefuServiceConversationFmUI.getContext();
        paramMenuItem = paramOpenImKefuServiceConversationFmUI.getContext();
        if (paramMenuItem == null)
        {
          paramMenuItem = null;
          localObject1 = paramOpenImKefuServiceConversationFmUI.getContext();
          if (localObject1 != null) {
            break label188;
          }
          localObject1 = null;
          label131:
          localObject2 = paramOpenImKefuServiceConversationFmUI.getContext();
          if (localObject2 != null) {
            break label199;
          }
        }
        label188:
        label199:
        for (localObject2 = null;; localObject2 = ((Activity)localObject2).getString(R.l.app_cancel))
        {
          com.tencent.mm.ui.base.k.a(localContext, paramMenuItem, "", (String)localObject1, (String)localObject2, new OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI..ExternalSyntheticLambda2(str, paramOpenImKefuServiceConversationFmUI), null, R.e.alert_btn_color_warn);
          AppMethodBeat.o(256781);
          return;
          paramMenuItem = paramMenuItem.getString(R.l.gRb);
          break;
          localObject1 = ((Activity)localObject1).getString(R.l.gQZ);
          break label131;
        }
      }
      String str = paramOpenImKefuServiceConversationFmUI.talker;
      paramMenuItem = (CharSequence)str;
      if ((paramMenuItem == null) || (paramMenuItem.length() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        Log.e("MicroMsg.OpenImKefuServiceConversationUI", "deleteConversationAndMsg talker invalid");
        AppMethodBeat.o(256781);
        return;
      }
      com.tencent.mm.ui.report.b.a(1, str, paramOpenImKefuServiceConversationFmUI.conversation);
      Context localContext = (Context)paramOpenImKefuServiceConversationFmUI.getContext();
      paramMenuItem = paramOpenImKefuServiceConversationFmUI.getContext();
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        label292:
        localObject1 = paramOpenImKefuServiceConversationFmUI.getContext();
        if (localObject1 != null) {
          break label357;
        }
        localObject1 = null;
        label303:
        localObject2 = paramOpenImKefuServiceConversationFmUI.getContext();
        if (localObject2 != null) {
          break label368;
        }
      }
      label357:
      label368:
      for (Object localObject2 = null;; localObject2 = ((Activity)localObject2).getString(R.l.app_cancel))
      {
        com.tencent.mm.ui.base.k.a(localContext, paramMenuItem, "", (String)localObject1, (String)localObject2, new OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI..ExternalSyntheticLambda1(str, paramOpenImKefuServiceConversationFmUI), null, R.e.alert_btn_color_warn);
        break;
        paramMenuItem = paramMenuItem.getString(R.l.gIs);
        break label292;
        localObject1 = ((Activity)localObject1).getString(R.l.app_delete);
        break label303;
      }
    }
    
    private static final void a(OpenImKefuServiceConversationFmUI paramOpenImKefuServiceConversationFmUI, View paramView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(256786);
      s.u(paramOpenImKefuServiceConversationFmUI, "this$0");
      paramOpenImKefuServiceConversationFmUI = paramOpenImKefuServiceConversationFmUI.afrS;
      if (paramOpenImKefuServiceConversationFmUI != null) {
        paramOpenImKefuServiceConversationFmUI.performItemClick(paramView, paramInt1, paramInt2);
      }
      AppMethodBeat.o(256786);
    }
    
    private static final void a(OpenImKefuServiceConversationFmUI paramOpenImKefuServiceConversationFmUI, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      Object localObject1 = null;
      AppMethodBeat.i(256790);
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramOpenImKefuServiceConversationFmUI);
      localb.cH(paramAdapterView);
      localb.cH(paramView);
      localb.sc(paramInt);
      localb.hB(paramLong);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI$OpenImKefuServiceConversationFmUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", localObject2, localb.aYj());
      s.u(paramOpenImKefuServiceConversationFmUI, "this$0");
      paramAdapterView = paramOpenImKefuServiceConversationFmUI.afrT;
      label103:
      int i;
      if (paramAdapterView == null)
      {
        paramAdapterView = null;
        if (paramAdapterView != null) {
          break label221;
        }
        paramView = null;
        paramView = (CharSequence)paramView;
        if ((paramView != null) && (paramView.length() != 0)) {
          break label229;
        }
        i = 1;
        label124:
        if (i != 0) {
          Log.e("MicroMsg.OpenImKefuServiceConversationUI", s.X("alvinluo startKefuChatting username invalid, position: ", Integer.valueOf(paramInt)));
        }
        paramView = OpenImKefuServiceConversationUI.afrK;
        paramView = paramOpenImKefuServiceConversationFmUI.ui;
        s.s(paramView, "ui");
        if (paramAdapterView != null) {
          break label235;
        }
      }
      label221:
      label229:
      label235:
      for (paramOpenImKefuServiceConversationFmUI = localObject1;; paramOpenImKefuServiceConversationFmUI = paramAdapterView.field_username)
      {
        OpenImKefuServiceConversationUI.a.b(paramView, paramOpenImKefuServiceConversationFmUI, true, true, (kotlin.g.a.b)e.afrV);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI$OpenImKefuServiceConversationFmUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(256790);
        return;
        paramAdapterView = (bb)paramAdapterView.getItem(paramInt);
        break;
        paramView = paramAdapterView.field_username;
        break label103;
        i = 0;
        break label124;
      }
    }
    
    private static final void a(String paramString, OpenImKefuServiceConversationFmUI paramOpenImKefuServiceConversationFmUI, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(256794);
      s.u(paramOpenImKefuServiceConversationFmUI, "this$0");
      com.tencent.mm.ui.report.b.a(4, paramString, paramOpenImKefuServiceConversationFmUI.conversation);
      ((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).a(paramString, (c.b)new c(paramOpenImKefuServiceConversationFmUI));
      AppMethodBeat.o(256794);
    }
    
    private static final boolean a(OpenImKefuServiceConversationFmUI paramOpenImKefuServiceConversationFmUI, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(256784);
      s.u(paramOpenImKefuServiceConversationFmUI, "this$0");
      paramOpenImKefuServiceConversationFmUI.finish();
      AppMethodBeat.o(256784);
      return true;
    }
    
    private static final void b(String paramString, OpenImKefuServiceConversationFmUI paramOpenImKefuServiceConversationFmUI, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(256802);
      s.u(paramOpenImKefuServiceConversationFmUI, "this$0");
      com.tencent.mm.ui.report.b.a(2, paramString, paramOpenImKefuServiceConversationFmUI.conversation);
      bh.bCz();
      paramDialogInterface = com.tencent.mm.model.c.bzD().aLF(paramString);
      aig localaig = new aig();
      localaig.ZqL = new etl().btH(paramString);
      localaig.Njv = paramDialogInterface.field_msgSvrId;
      bh.bCz();
      com.tencent.mm.model.c.bzz().d((com.tencent.mm.plugin.messenger.foundation.a.a.k.b)new k.a(8, (com.tencent.mm.bx.a)localaig));
      paramOpenImKefuServiceConversationFmUI.isDeleteCancel = false;
      paramDialogInterface = (Context)paramOpenImKefuServiceConversationFmUI.thisActivity();
      paramOpenImKefuServiceConversationFmUI.getString(R.l.app_tip);
      br.a(paramString, (br.a)new b(paramOpenImKefuServiceConversationFmUI, com.tencent.mm.ui.base.k.a(paramDialogInterface, paramOpenImKefuServiceConversationFmUI.getString(R.l.app_waiting), true, new OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI..ExternalSyntheticLambda0(paramOpenImKefuServiceConversationFmUI))));
      bh.bCz();
      com.tencent.mm.model.c.bzG().bxK(paramString);
      com.tencent.threadpool.h.ahAA.bm(OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI..ExternalSyntheticLambda9.INSTANCE);
      AppMethodBeat.o(256802);
    }
    
    private static final boolean b(OpenImKefuServiceConversationFmUI paramOpenImKefuServiceConversationFmUI, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(256792);
      s.u(paramOpenImKefuServiceConversationFmUI, "this$0");
      paramAdapterView = paramOpenImKefuServiceConversationFmUI.afrT;
      if (paramAdapterView == null)
      {
        paramAdapterView = null;
        paramOpenImKefuServiceConversationFmUI.conversation = paramAdapterView;
        paramAdapterView = paramOpenImKefuServiceConversationFmUI.conversation;
        if (paramAdapterView != null) {
          break label110;
        }
        paramAdapterView = "";
      }
      for (;;)
      {
        paramOpenImKefuServiceConversationFmUI.talker = paramAdapterView;
        paramAdapterView = paramOpenImKefuServiceConversationFmUI.vEV;
        if (paramAdapterView != null) {
          paramAdapterView.a(paramView, paramInt, paramLong, (View.OnCreateContextMenuListener)paramOpenImKefuServiceConversationFmUI, paramOpenImKefuServiceConversationFmUI.vGU, paramOpenImKefuServiceConversationFmUI.x_down, paramOpenImKefuServiceConversationFmUI.y_down);
        }
        com.tencent.mm.ui.report.b.a(5, paramOpenImKefuServiceConversationFmUI.talker, paramOpenImKefuServiceConversationFmUI.conversation);
        AppMethodBeat.o(256792);
        return true;
        paramAdapterView = (bb)paramAdapterView.getItem(paramInt);
        break;
        label110:
        String str = paramAdapterView.field_username;
        paramAdapterView = str;
        if (str == null) {
          paramAdapterView = "";
        }
      }
    }
    
    private static final void jBa()
    {
      AppMethodBeat.i(256798);
      ((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).d(null);
      AppMethodBeat.o(256798);
    }
    
    public final int getLayoutId()
    {
      return R.i.glh;
    }
    
    public final void onActivityCreated(Bundle paramBundle)
    {
      Object localObject = null;
      AppMethodBeat.i(256864);
      super.onActivityCreated(paramBundle);
      paramBundle = thisActivity();
      if (paramBundle == null) {
        paramBundle = localObject;
      }
      for (;;)
      {
        this.superUsername = paramBundle;
        Log.d("MicroMsg.OpenImKefuServiceConversationUI", "alvinluo startOpenImKefuServiceConversationUI superUsername: %s", new Object[] { this.superUsername });
        setMMTitle(getString(R.l.gRe));
        this.afrS = ((ListView)findViewById(R.h.fDE));
        this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
        paramBundle = this.emptyTipTv;
        if (paramBundle != null) {
          paramBundle.setText(R.l.gRf);
        }
        setBackBtn(new OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI..ExternalSyntheticLambda3(this));
        this.afrT = new r(this.superUsername, (Context)thisActivity(), (x.a)new d(this));
        paramBundle = this.afrT;
        if (paramBundle != null) {
          paramBundle.setPerformItemClickListener(new OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI..ExternalSyntheticLambda6(this));
        }
        paramBundle = this.afrS;
        if (paramBundle != null) {
          paramBundle.setAdapter((ListAdapter)this.afrT);
        }
        paramBundle = this.afrS;
        if (paramBundle != null) {
          paramBundle.setOnItemClickListener(new OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI..ExternalSyntheticLambda4(this));
        }
        paramBundle = this.afrS;
        if (paramBundle != null) {
          paramBundle.setOnTouchListener((View.OnTouchListener)new f(this));
        }
        this.vEV = new com.tencent.mm.ui.widget.b.a((Context)thisActivity());
        paramBundle = this.afrS;
        if (paramBundle != null) {
          paramBundle.setOnItemLongClickListener(new OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI..ExternalSyntheticLambda5(this));
        }
        AppMethodBeat.o(256864);
        return;
        Intent localIntent = paramBundle.getIntent();
        paramBundle = localObject;
        if (localIntent != null) {
          paramBundle = localIntent.getStringExtra("Contact_User");
        }
      }
    }
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(256889);
      s.u(paramContextMenu, "menu");
      s.u(paramView, "v");
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      bh.bCz();
      paramView = com.tencent.mm.model.c.bzA().JE(this.talker);
      if (paramView == null)
      {
        Log.e("MicroMsg.OpenImKefuServiceConversationUI", s.X("onCreateContextMenu, contact is null, talker = ", this.talker));
        AppMethodBeat.o(256889);
        return;
      }
      if (paramContextMenuInfo == null)
      {
        paramContextMenu = new NullPointerException("null cannot be cast to non-null type android.widget.AdapterView.AdapterContextMenuInfo");
        AppMethodBeat.o(256889);
        throw paramContextMenu;
      }
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      if (paramView.maN >= 0L) {
        paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.gRd);
      }
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, R.l.main_delete);
      AppMethodBeat.o(256889);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(256900);
      super.onDestroy();
      r localr = this.afrT;
      if (localr != null) {
        localr.onDestroy();
      }
      AppMethodBeat.o(256900);
    }
    
    public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject) {}
    
    public final void onPause()
    {
      AppMethodBeat.i(256877);
      super.onPause();
      r localr = this.afrT;
      if (localr != null) {
        localr.onPause();
      }
      com.tencent.threadpool.h.ahAA.bo(new OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI..ExternalSyntheticLambda8(this));
      AppMethodBeat.o(256877);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(256870);
      Log.i("MicroMsg.OpenImKefuServiceConversationUI", "onResume chattingClosed: %s", new Object[] { Boolean.valueOf(this.ui.mChattingClosed) });
      super.onResume();
      Object localObject;
      if (this.ui.mChattingClosed)
      {
        localObject = this.afrT;
        if (localObject != null) {
          ((r)localObject).onResume();
        }
      }
      if (this.xtT)
      {
        this.xtT = false;
        localObject = this.afrS;
        if (localObject != null) {
          ((ListView)localObject).requestFocus();
        }
      }
      AppMethodBeat.o(256870);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI$OpenImKefuServiceConversationFmUI$asyncDelMsg$1", "Lcom/tencent/mm/model/MsgInfoStorageLogic$IDeleteMsg;", "finishCallback", "", "isCancel", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements br.a
    {
      b(OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI paramOpenImKefuServiceConversationFmUI, w paramw) {}
      
      public final boolean aMJ()
      {
        AppMethodBeat.i(256772);
        boolean bool = OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI.c(this.afrU);
        AppMethodBeat.o(256772);
        return bool;
      }
      
      public final void aMK()
      {
        AppMethodBeat.i(256779);
        w localw = this.KRz;
        if (localw != null) {
          localw.dismiss();
        }
        AppMethodBeat.o(256779);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI$OpenImKefuServiceConversationFmUI$doCloseConversation$1", "Lcom/tencent/mm/openim/api/IOpenIMKefuService$OpContactCallback;", "onOpFailed", "", "opType", "", "errType", "errCode", "errMsg", "", "data", "Landroid/os/Bundle;", "onOpSuccess", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      implements c.b
    {
      c(OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI paramOpenImKefuServiceConversationFmUI) {}
      
      public final void bRY()
      {
        AppMethodBeat.i(256770);
        Log.i("MicroMsg.OpenImKefuServiceConversationUI", "alvinluo closeOpenImKfConversation success");
        Context localContext = (Context)this.afrU.getContext();
        Object localObject = this.afrU.getContext();
        if (localObject == null) {}
        for (localObject = null;; localObject = ((Activity)localObject).getString(R.l.gRc))
        {
          aa.y(localContext, (String)localObject, R.k.icons_filled_done);
          AppMethodBeat.o(256770);
          return;
        }
      }
      
      public final void o(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(256777);
        Log.e("MicroMsg.OpenImKefuServiceConversationUI", "alvinluo closeOpenImKfConversation failed errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
        Context localContext = (Context)this.afrU.getContext();
        paramString = this.afrU.getContext();
        if (paramString == null) {}
        for (paramString = null;; paramString = paramString.getString(R.l.gRa))
        {
          aa.y(localContext, paramString, R.k.ic_filled_loading_fail);
          AppMethodBeat.o(256777);
          return;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI$OpenImKefuServiceConversationFmUI$initData$1", "Lcom/tencent/mm/ui/MListAdapter$CallBack;", "onPostReset", "", "thiz", "", "onPreReset", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class d
      implements x.a
    {
      d(OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI paramOpenImKefuServiceConversationFmUI) {}
      
      public final void bWC()
      {
        AppMethodBeat.i(256754);
        OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI localOpenImKefuServiceConversationFmUI = this.afrU;
        r localr = OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI.b(this.afrU);
        if (localr == null) {}
        for (int i = 0;; i = localr.getCount())
        {
          OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI.a(localOpenImKefuServiceConversationFmUI, i);
          AppMethodBeat.o(256754);
          return;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "contact", "Lcom/tencent/mm/openim/api/IOpenIMKefuContact;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends u
      implements kotlin.g.a.b<com.tencent.mm.openim.api.a, ah>
    {
      public static final e afrV;
      
      static
      {
        AppMethodBeat.i(256755);
        afrV = new e();
        AppMethodBeat.o(256755);
      }
      
      e()
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI$OpenImKefuServiceConversationFmUI$initData$4", "Landroid/view/View$OnTouchListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class f
      implements View.OnTouchListener
    {
      f(OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI paramOpenImKefuServiceConversationFmUI) {}
      
      public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
      {
        AppMethodBeat.i(256759);
        s.u(paramView, "v");
        s.u(paramMotionEvent, "event");
        if (paramMotionEvent.getAction() == 0)
        {
          OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI.b(this.afrU, (int)paramMotionEvent.getRawX());
          OpenImKefuServiceConversationUI.OpenImKefuServiceConversationFmUI.c(this.afrU, (int)paramMotionEvent.getRawY());
        }
        AppMethodBeat.o(256759);
        return false;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI$Companion;", "", "()V", "TAG", "", "startKefuChatting", "", "context", "Lcom/tencent/mm/ui/conversation/BaseConversationUI;", "username", "needAnim", "", "post", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/openim/api/IOpenIMKefuContact;", "Lkotlin/ParameterName;", "name", "contact", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static void a(final BaseConversationUI paramBaseConversationUI, String paramString, final boolean paramBoolean1, final boolean paramBoolean2, kotlin.g.a.b<? super com.tencent.mm.openim.api.a, ah> paramb)
    {
      AppMethodBeat.i(256730);
      Log.i("MicroMsg.OpenImKefuServiceConversationUI", "alvinluo startKefuChatting username: " + paramString + ", needAnim: " + paramBoolean1 + ", post: " + paramBoolean2);
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.e("MicroMsg.OpenImKefuServiceConversationUI", "alvinluo startKefuChatting talker is empty");
        AppMethodBeat.o(256730);
        return;
      }
      ((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).a(paramString, (c.a)new b(paramb, paramBaseConversationUI, paramBoolean1, paramBoolean2));
      AppMethodBeat.o(256730);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI$Companion$startKefuChatting$2", "Lcom/tencent/mm/openim/api/IOpenIMKefuService$GetContactCallback;", "isCancelled", "", "tipsDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "onFinish", "", "result", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;", "onTryFetch", "username", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements c.a
    {
      private w Psj;
      private boolean isCancelled;
      
      b(kotlin.g.a.b<? super com.tencent.mm.openim.api.a, ah> paramb, BaseConversationUI paramBaseConversationUI, boolean paramBoolean1, boolean paramBoolean2) {}
      
      private static final void a(b paramb, DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(256639);
        s.u(paramb, "this$0");
        Log.i("MicroMsg.OpenImKefuServiceConversationUI", "alvinluo startKefuChatting loading cancel");
        paramb.isCancelled = true;
        AppMethodBeat.o(256639);
      }
      
      public final void RF(String paramString)
      {
        AppMethodBeat.i(256649);
        Log.i("MicroMsg.OpenImKefuServiceConversationUI", "alvinluo startKefuChatting try fetch contact, show loading");
        this.Psj = com.tencent.mm.ui.base.k.a((Context)paramBaseConversationUI, paramBaseConversationUI.getString(R.l.app_waiting), true, new OpenImKefuServiceConversationUI.a.b..ExternalSyntheticLambda0(this));
        AppMethodBeat.o(256649);
      }
      
      public final void a(com.tencent.mm.openim.api.j paramj)
      {
        AppMethodBeat.i(256647);
        Object localObject1;
        Object localObject2;
        if (paramj == null)
        {
          localObject1 = null;
          this.$callback.invoke(localObject1);
          if (localObject1 != null) {
            break label149;
          }
          localObject2 = null;
          label29:
          Log.i("MicroMsg.OpenImKefuServiceConversationUI", "alvinluo startKefuChatting getContact %s, isCancelled: %b", new Object[] { localObject2, Boolean.valueOf(this.isCancelled) });
          localObject2 = this.Psj;
          if (localObject2 != null) {
            ((w)localObject2).dismiss();
          }
          if (this.isCancelled) {
            break label168;
          }
          if ((localObject1 == null) || (((com.tencent.mm.openim.api.a)localObject1).isValid() != true)) {
            break label163;
          }
        }
        label149:
        label163:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label168;
          }
          paramj = new Bundle();
          paramj.putBoolean("finish_direct", true);
          paramBaseConversationUI.startChatting(((com.tencent.mm.openim.api.a)localObject1).getUsername(), paramj, paramBoolean1, paramBoolean2);
          AppMethodBeat.o(256647);
          return;
          localObject1 = paramj.prp;
          break;
          localObject2 = Boolean.valueOf(((com.tencent.mm.openim.api.a)localObject1).isValid());
          break label29;
        }
        label168:
        if ((paramj != null) && (paramj.errCode == -3601)) {}
        for (i = 1; i != 0; i = 0)
        {
          paramj = paramBaseConversationUI.getResources().getString(R.l.open_im_kefu_confirm_get_contact_deleted);
          s.s(paramj, "context.resources.getStr…firm_get_contact_deleted)");
          localObject1 = paramBaseConversationUI.getResources().getString(R.l.app_i_know);
          s.s(localObject1, "context.resources.getString(R.string.app_i_know)");
          com.tencent.mm.ui.base.k.a((Context)paramBaseConversationUI, "", paramj, (String)localObject1, null);
          AppMethodBeat.o(256647);
          return;
        }
        aa.makeText((Context)paramBaseConversationUI, (CharSequence)paramBaseConversationUI.getResources().getString(R.l.open_im_kefu_start_conversation_error_tips), 0).show();
        AppMethodBeat.o(256647);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI$SendAppMsgRunnable;", "Ljava/lang/Runnable;", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "getContent", "()Lcom/tencent/mm/message/AppMessage$Content;", "setContent", "(Lcom/tencent/mm/message/AppMessage$Content;)V", "needDelThumb", "", "getNeedDelThumb", "()Z", "setNeedDelThumb", "(Z)V", "sendMessageDefaultImg", "", "getSendMessageDefaultImg", "()[B", "setSendMessageDefaultImg", "([B)V", "sendMessageImg", "getSendMessageImg", "setSendMessageImg", "sendMessageLocalImg", "getSendMessageLocalImg", "setSendMessageLocalImg", "sendMessageTitle", "getSendMessageTitle", "setSendMessageTitle", "talkerUserName", "getTalkerUserName", "setTalkerUserName", "doSendAppMessage", "", "run", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    implements Runnable
  {
    String NBt;
    byte[] aeez;
    String appId;
    com.tencent.mm.message.k.b hWV;
    String rSA;
    String rSC;
    boolean rSD;
    String rSy;
    
    public final void run()
    {
      boolean bool1 = true;
      AppMethodBeat.i(256737);
      Object localObject2;
      if (!Util.isNullOrNil(this.rSC))
      {
        localObject2 = com.tencent.mm.modelappbrand.a.b.bEY().a(s.X("file://", this.rSC), null);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((Bitmap)localObject2).isRecycled()) {}
        }
        else
        {
          localObject2 = BitmapUtil.getBitmapNative(this.rSA);
          localObject1 = localObject2;
          if (this.rSD)
          {
            boolean bool2 = y.deleteFile(this.rSC);
            Log.v("MicroMsg.OpenImKefuServiceConversationUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.rSA, Boolean.valueOf(bool2) });
          }
        }
      }
      for (Object localObject1 = localObject2; (localObject1 != null) && (!((Bitmap)localObject1).isRecycled()); localObject1 = com.tencent.mm.modelappbrand.a.b.bEY().a(this.rSA, null))
      {
        Log.i("MicroMsg.OpenImKefuServiceConversationUI", "thumb image is not null ");
        localObject2 = new ByteArrayOutputStream();
        ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
        localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
        n.a(this.hWV, this.appId, this.rSy, this.NBt, null, (byte[])localObject1);
        AppMethodBeat.o(256737);
        return;
      }
      if (this.aeez != null) {}
      for (;;)
      {
        Log.e("MicroMsg.OpenImKefuServiceConversationUI", "thumb image is null sendMessageDefaultImg:%b", new Object[] { Boolean.valueOf(bool1) });
        localObject1 = this.aeez;
        break;
        bool1 = false;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    c(OpenImKefuServiceConversationUI paramOpenImKefuServiceConversationUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Integer>
  {
    d(OpenImKefuServiceConversationUI paramOpenImKefuServiceConversationUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "contact", "Lcom/tencent/mm/openim/api/IOpenIMKefuContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<com.tencent.mm.openim.api.a, ah>
  {
    e(OpenImKefuServiceConversationUI paramOpenImKefuServiceConversationUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    f(OpenImKefuServiceConversationUI paramOpenImKefuServiceConversationUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/openim/api/OpenIMKefuStartConversationRequest;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<OpenIMKefuStartConversationRequest>
  {
    g(OpenImKefuServiceConversationUI paramOpenImKefuServiceConversationUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.OpenImKefuServiceConversationUI
 * JD-Core Version:    0.7.0.1
 */