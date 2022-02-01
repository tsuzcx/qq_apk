package com.tencent.mm.ui.chatting.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.za;
import com.tencent.mm.g.a.zb;
import com.tencent.mm.g.a.zc;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.an;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.d;
import com.tencent.mm.model.ay.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.ui.chatting.viewitems.bf.a;
import com.tencent.mm.ui.z.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import kotlin.g.b.p;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.d.a.a(gRF=aw.class)
public class bi
  extends a
  implements com.tencent.mm.ak.i, aw
{
  private static Object lock;
  private ay.d FNy;
  private IListener<zb> PvA;
  private IListener<zc> PvB;
  private View PvC;
  public ChatFooter.d PvD;
  private IListener<za> PvE;
  private List<WeakReference<View>> PvF;
  private com.tencent.mm.ui.chatting.d Pvm;
  private boolean Pvn;
  private long Pvo;
  private WeakReference<View> Pvp;
  private ConcurrentHashMap<Long, Boolean> Pvq;
  private boolean Pvr;
  private o Pvs;
  private boolean Pvt;
  private boolean Pvu;
  private long Pvv;
  private boolean Pvw;
  private long Pvx;
  private bi.a Pvy;
  private Future Pvz;
  private Future dBz;
  private int minHeight;
  public boolean qUn;
  
  static
  {
    AppMethodBeat.i(233260);
    lock = new Object();
    AppMethodBeat.o(233260);
  }
  
  public bi()
  {
    AppMethodBeat.i(35775);
    this.Pvm = null;
    this.qUn = false;
    this.Pvn = false;
    this.Pvq = new ConcurrentHashMap();
    this.Pvr = false;
    this.Pvs = new o()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(233230);
        if (bi.a(bi.this)) {
          com.tencent.f.h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(233229);
              bi.this.releaseWakeLock();
              AppMethodBeat.o(233229);
            }
          });
        }
        AppMethodBeat.o(233230);
      }
      
      public final void onAppForeground(String paramAnonymousString) {}
    };
    this.Pvt = false;
    this.minHeight = -1;
    this.Pvu = false;
    this.dBz = null;
    this.Pvv = -1L;
    this.Pvw = false;
    this.Pvx = -1L;
    this.Pvy = null;
    this.Pvz = null;
    this.FNy = new ay.d()
    {
      public final void B(String paramAnonymousString, final long paramAnonymousLong)
      {
        AppMethodBeat.i(233232);
        Log.d("MicroMsg.ChattingUI.VoiceComponent", "onVoiceRemind " + paramAnonymousString + " time " + paramAnonymousLong);
        if (ab.Jq(bg.getNotification().ala())) {
          com.tencent.mm.ui.base.h.a(bi.this.dom.Pwc.getContext(), false, paramAnonymousString, bi.this.dom.Pwc.getMMResources().getString(2131767197), bi.this.dom.Pwc.getMMResources().getString(2131767194), bi.this.dom.Pwc.getMMResources().getString(2131767196), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(233231);
              bg.aVF();
              if (com.tencent.mm.model.c.aSQ().aO(bg.getNotification().ala(), paramAnonymousLong))
              {
                int i = ((com.tencent.mm.ui.chatting.d.b.k)bi.this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).cZm();
                paramAnonymous2Int = ((com.tencent.mm.ui.chatting.d.b.k)bi.this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).getCount();
                bg.aVF();
                i = com.tencent.mm.model.c.aSQ().h(bg.getNotification().ala(), paramAnonymousLong, i - paramAnonymous2Int);
                if (i < 0)
                {
                  AppMethodBeat.o(233231);
                  return;
                }
                if (paramAnonymous2Int > i) {
                  bi.this.dom.amm(i);
                }
              }
              AppMethodBeat.o(233231);
            }
          }, null);
        }
        AppMethodBeat.o(233232);
      }
    };
    this.PvA = new IListener() {};
    this.PvB = new IListener() {};
    this.PvC = null;
    this.PvD = new ChatFooter.d()
    {
      public final void q(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(233238);
        if (paramAnonymousBoolean.booleanValue())
        {
          if (bi.h(bi.this) == null) {
            bi.a(bi.this, ((ViewStub)bi.this.dom.findViewById(2131309901)).inflate());
          }
          bi.h(bi.this).setVisibility(0);
          AppMethodBeat.o(233238);
          return;
        }
        if ((bi.h(bi.this) != null) && (bi.h(bi.this).getVisibility() == 0)) {
          bi.h(bi.this).setVisibility(8);
        }
        AppMethodBeat.o(233238);
      }
    };
    this.PvE = new IListener() {};
    this.PvF = new ArrayList();
    AppMethodBeat.o(35775);
  }
  
  private void doPause()
  {
    AppMethodBeat.i(233245);
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "voiceComponent doPause");
    this.Pvn = false;
    if ((ab.Jq(this.dom.getTalkerUserName())) && (ay.a.iDt != null)) {
      ay.a.iDt.b(this.FNy);
    }
    if ((this.PvC != null) && (this.PvC.getVisibility() == 0))
    {
      Log.i("MicroMsg.ChattingUI.VoiceComponent", "doPause set voiceinputMask GONE");
      this.PvC.setVisibility(8);
    }
    ((com.tencent.mm.ui.chatting.d.b.u)this.dom.bh(com.tencent.mm.ui.chatting.d.b.u.class)).setVoiceInputShowCallback(null);
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(26, Boolean.valueOf(this.qUn));
    if ((this.Pvm != null) && (this.Pvm.isPlaying()))
    {
      localx = com.tencent.mm.ui.tools.x.Qxl;
      if (!com.tencent.mm.ui.tools.x.gXX())
      {
        this.Pvr = true;
        localx = com.tencent.mm.ui.tools.x.Qxl;
        com.tencent.mm.ui.tools.x.CM(true);
        AppForegroundDelegate.djR.a(this.Pvs);
        AppMethodBeat.o(233245);
        return;
      }
    }
    com.tencent.mm.ui.tools.x localx = com.tencent.mm.ui.tools.x.Qxl;
    com.tencent.mm.ui.tools.x.CM(true);
    if ((!com.tencent.mm.ui.t.gIO()) && (this.Pvm != null))
    {
      this.Pvm.gMO();
      this.Pvm.gMT();
      this.Pvm.release();
    }
    AppMethodBeat.o(233245);
  }
  
  public static boolean gRD()
  {
    AppMethodBeat.i(233256);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.siw, 0);
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "isOpenVoiceTransTextBt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(233256);
      return true;
    }
    AppMethodBeat.o(233256);
    return false;
  }
  
  public final void BV(boolean paramBoolean)
  {
    AppMethodBeat.i(35781);
    if (this.Pvm == null)
    {
      Log.e("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff error, autoPlay is null!!!");
      AppMethodBeat.o(35781);
      return;
    }
    Log.printInfoStack("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff value is %s", new Object[] { Boolean.valueOf(paramBoolean) });
    aa localaa = (aa)this.dom.bh(aa.class);
    if (paramBoolean)
    {
      this.Pvm.BL(false);
      this.qUn = true;
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(26, Boolean.TRUE);
      localaa.setTitlePhoneIconVisibility(0);
      Toast.makeText(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131760874), 0).show();
      this.Pvm.gMS();
      this.dom.amK(2131689485);
      AppMethodBeat.o(35781);
      return;
    }
    if (!com.tencent.mm.plugin.audio.c.a.ceb()) {
      this.Pvm.BL(true);
    }
    for (;;)
    {
      this.qUn = false;
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(26, Boolean.FALSE);
      localaa.setTitlePhoneIconVisibility(8);
      Toast.makeText(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131760875), 0).show();
      this.Pvm.gMS();
      this.dom.amK(2131689505);
      AppMethodBeat.o(35781);
      return;
      Log.i("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff true but isBluetoothOn");
    }
  }
  
  public final void NJ(long paramLong)
  {
    AppMethodBeat.i(233246);
    this.Pvq.put(Long.valueOf(paramLong), Boolean.TRUE);
    AppMethodBeat.o(233246);
  }
  
  public final boolean NK(long paramLong)
  {
    AppMethodBeat.i(233247);
    if (this.Pvq.containsKey(Long.valueOf(paramLong)))
    {
      boolean bool = ((Boolean)this.Pvq.get(Long.valueOf(paramLong))).booleanValue();
      AppMethodBeat.o(233247);
      return bool;
    }
    AppMethodBeat.o(233247);
    return false;
  }
  
  public final void NL(long paramLong)
  {
    AppMethodBeat.i(233249);
    if (this.Pvv == paramLong) {}
    synchronized (lock)
    {
      this.Pvt = true;
      ??? = ((com.tencent.mm.ui.chatting.d.b.k)this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).zh(this.Pvv);
      if (??? != null)
      {
        ??? = (RelativeLayout)((View)???).findViewById(2131298448);
        if (??? != null)
        {
          this.Pvv = -1L;
          ((RelativeLayout)???).setVisibility(8);
        }
      }
      AppMethodBeat.o(233249);
      return;
    }
  }
  
  public final void NM(long paramLong)
  {
    AppMethodBeat.i(233250);
    synchronized (lock)
    {
      this.Pvt = true;
      if (this.Pvv == paramLong)
      {
        ??? = ((com.tencent.mm.ui.chatting.d.b.k)this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).zh(this.Pvv);
        if (??? != null)
        {
          ??? = (RelativeLayout)((View)???).findViewById(2131298448);
          if (??? != null)
          {
            this.Pvv = -1L;
            ((RelativeLayout)???).setVisibility(8);
          }
        }
      }
      AppMethodBeat.o(233250);
      return;
    }
  }
  
  public final boolean NN(long paramLong)
  {
    return this.Pvv == paramLong;
  }
  
  public final boolean Zx()
  {
    AppMethodBeat.i(35777);
    boolean bool1 = ((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP();
    boolean bool2 = ((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ();
    int i;
    if ((this.dom.gRL()) || (bool2)) {
      i = 1;
    }
    while (bool1) {
      if (bool2)
      {
        bool1 = ((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gON().iE(1);
        AppMethodBeat.o(35777);
        return bool1;
        i = 0;
      }
      else
      {
        bool1 = ((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOO().iE(1);
        AppMethodBeat.o(35777);
        return bool1;
      }
    }
    if (((i != 0) && (this.dom.GUe.fuH == 0)) || (this.dom.GUe.Zx()))
    {
      AppMethodBeat.o(35777);
      return true;
    }
    AppMethodBeat.o(35777);
    return false;
  }
  
  public final void a(long paramLong, View paramView)
  {
    AppMethodBeat.i(233248);
    this.Pvo = paramLong;
    this.Pvp = new WeakReference(paramView);
    AppMethodBeat.o(233248);
  }
  
  @TargetApi(9)
  public final void a(MMFragment paramMMFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(35784);
    if (paramMMFragment.getLandscapeMode()) {
      if (paramBoolean)
      {
        if (Build.VERSION.SDK_INT >= 9)
        {
          Log.i("MicroMsg.ChattingUI.VoiceComponent", "rotation %d", new Object[] { Integer.valueOf(paramMMFragment.getWindowManager().getDefaultDisplay().getOrientation()) });
          switch (paramMMFragment.getWindowManager().getDefaultDisplay().getOrientation())
          {
          default: 
            AppMethodBeat.o(35784);
            return;
          case 0: 
            paramMMFragment.setRequestedOrientation(1);
            AppMethodBeat.o(35784);
            return;
          case 1: 
            paramMMFragment.setRequestedOrientation(0);
            AppMethodBeat.o(35784);
            return;
          case 2: 
            paramMMFragment.setRequestedOrientation(9);
            AppMethodBeat.o(35784);
            return;
          }
          paramMMFragment.setRequestedOrientation(8);
          AppMethodBeat.o(35784);
          return;
        }
        if (this.dom.Pwc.getMMResources().getConfiguration().orientation == 2)
        {
          paramMMFragment.setRequestedOrientation(0);
          AppMethodBeat.o(35784);
          return;
        }
        if (this.dom.Pwc.getMMResources().getConfiguration().orientation == 1)
        {
          paramMMFragment.setRequestedOrientation(1);
          AppMethodBeat.o(35784);
        }
      }
      else
      {
        paramMMFragment.setRequestedOrientation(-1);
      }
    }
    AppMethodBeat.o(35784);
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(233252);
    super.a(parama);
    this.PvE.alive();
    AppMethodBeat.o(233252);
  }
  
  public final void acquireWakeLock()
  {
    AppMethodBeat.i(35779);
    this.dom.setKeepScreenOn(true);
    AppMethodBeat.o(35779);
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(35789);
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay looper[%s]", new Object[] { Looper.myLooper() });
    this.Pvn = true;
    long l = System.currentTimeMillis();
    Object localObject;
    if (!this.Pvr)
    {
      Log.i("MicroMsg.ChattingUI.VoiceComponent", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", new Object[] { this.Pvm, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper() });
      if (this.Pvm != null) {
        break label398;
      }
      this.Pvm = new com.tencent.mm.ui.chatting.d(this.dom, this, this.dom.getTalkerUserName());
      com.tencent.mm.modelvoice.t.c(this.Pvm);
      com.tencent.mm.modelvoice.e.a(this.Pvm);
      bg.aVF();
      bool = Util.nullAs((Boolean)com.tencent.mm.model.c.azQ().get(16387, null), true);
      localObject = this.Pvm;
      if (!((com.tencent.mm.ui.chatting.d)localObject).Peo)
      {
        ((com.tencent.mm.ui.chatting.d)localObject).Pem = bool;
        ((com.tencent.mm.ui.chatting.d)localObject).gMO();
      }
      localObject = ((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOM();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.api.c)localObject).cG(false);
        if (localObject != null)
        {
          if (((c.b)localObject).dhz != null)
          {
            if (((c.b)localObject).dhz.optInt("AudioPlayType", 0) != 1) {
              break label415;
            }
            bool = true;
            label234:
            ((c.b)localObject).dhP = bool;
          }
          if (((c.b)localObject).dhP) {
            this.Pvm.Pen = false;
          }
        }
      }
      localObject = this.Pvm;
      if (this.qUn) {
        break label420;
      }
    }
    label398:
    label415:
    label420:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.ui.chatting.d)localObject).BL(bool);
      this.Pvm.BK(true);
      Log.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay end take[%s]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if ((ab.Jq(this.dom.getTalkerUserName())) && (ay.a.iDt != null)) {
        ay.a.iDt.a(this.FNy);
      }
      if (!com.tencent.mm.aw.b.bdC()) {
        ((com.tencent.mm.ui.chatting.d.b.u)this.dom.bh(com.tencent.mm.ui.chatting.d.b.u.class)).setVoiceInputShowCallback(this.PvD);
      }
      gRy();
      AppForegroundDelegate.djR.b(this.Pvs);
      localObject = com.tencent.mm.ui.tools.x.Qxl;
      com.tencent.mm.ui.tools.x.CM(true);
      AppMethodBeat.o(35789);
      return;
      this.Pvm.bmt(this.dom.getTalkerUserName());
      break;
      bool = false;
      break label234;
    }
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35790);
    doPause();
    AppMethodBeat.o(35790);
  }
  
  public final boolean cl(ca paramca)
  {
    AppMethodBeat.i(35782);
    if (paramca.gAy())
    {
      if (paramca.field_msgId == this.Pvm.Pei) {
        this.Pvm.gMT();
      }
      AppMethodBeat.o(35782);
      return true;
    }
    AppMethodBeat.o(35782);
    return false;
  }
  
  public final boolean cm(ca paramca)
  {
    AppMethodBeat.i(35783);
    if (paramca.gAy())
    {
      bg.aVF();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.u.g(this.dom.Pwc.getContext(), this.dom.Pwc.getContentView());
        AppMethodBeat.o(35783);
        return true;
      }
      if (paramca.field_msgId == this.Pvm.Pei) {
        this.Pvm.gMT();
      }
      if (!this.dom.getTalkerUserName().equals("medianote"))
      {
        bg.aVF();
        com.tencent.mm.model.c.aSM().d(new com.tencent.mm.ba.f(paramca.field_talker, paramca.field_msgSvrId));
      }
      ak.bG(paramca);
      AppMethodBeat.o(35783);
      return true;
    }
    AppMethodBeat.o(35783);
    return false;
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35787);
    gRy();
    AppMethodBeat.o(35787);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35788);
    bg.azz().a(127, this);
    this.PvA.alive();
    this.PvB.alive();
    this.Pvt = false;
    gRC();
    AppMethodBeat.o(35788);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35791);
    bg.azz().b(127, this);
    if (this.Pvz != null) {
      this.Pvz.cancel(true);
    }
    this.PvA.dead();
    this.PvB.dead();
    this.Pvq.clear();
    AppMethodBeat.o(35791);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35785);
    super.gOK();
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "doDestroy, autoPlay:%s", new Object[] { this.Pvm });
    com.tencent.mm.modelvoice.t.b(this.Pvm);
    com.tencent.mm.modelvoice.e.b(this.Pvm);
    bg.azz().b(127, this);
    releaseWakeLock();
    if (this.Pvm != null)
    {
      this.Pvm.gMO();
      localObject = this.Pvm;
      ((com.tencent.mm.ui.chatting.d)localObject).release();
      ((com.tencent.mm.ui.chatting.d)localObject).qUl.unInit();
      ((com.tencent.mm.ui.chatting.d)localObject).context = null;
      ((com.tencent.mm.ui.chatting.d)localObject).Peo = false;
      EventCenter.instance.removeListener(((com.tencent.mm.ui.chatting.d)localObject).Pet);
      bg.Xi().b((com.tencent.mm.model.ao)localObject);
      this.Pvm = null;
    }
    Object localObject = com.tencent.mm.ak.a.iLw;
    com.tencent.mm.ak.a.MA("VoiceComponent_playUploadVoiceSound");
    this.PvE.dead();
    AppMethodBeat.o(35785);
  }
  
  public final void gRA()
  {
    this.Pvo = 0L;
  }
  
  public final void gRB()
  {
    AppMethodBeat.i(233251);
    this.Pvw = true;
    gRC();
    AppMethodBeat.o(233251);
  }
  
  public final void gRC()
  {
    AppMethodBeat.i(233255);
    if (((ai)this.dom.bh(ai.class)).gQN())
    {
      AppMethodBeat.o(233255);
      return;
    }
    if (!gRD())
    {
      AppMethodBeat.o(233255);
      return;
    }
    final com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class);
    final SparseArray localSparseArray = localk.gOq();
    if (localSparseArray != null) {
      this.Pvz = com.tencent.f.h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233243);
          Log.d("MicroMsg.ChattingUI.VoiceComponent", "showVoiceFastTransTextBt lastScrollState:%s", new Object[] { bi.l(bi.this) });
          long l = bi.m(bi.this);
          bi.a(bi.this, -1L);
          int j = bi.n(bi.this);
          bi.o(bi.this).clear();
          int i = localSparseArray.size() - 1;
          Object localObject1 = null;
          Object localObject2;
          Object localObject3;
          if (i >= 0)
          {
            localObject2 = (ca)localSparseArray.get(i);
            localObject3 = bi.a(bi.this, localk, (ca)localObject2, j);
            if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
              break label473;
            }
            localObject1 = localObject2;
          }
          label467:
          label473:
          for (;;)
          {
            localObject2 = localObject1;
            if (((Boolean)((Pair)localObject3).first).booleanValue())
            {
              i -= 1;
              break;
              localObject2 = localObject1;
            }
            if (localObject2 != null)
            {
              localObject1 = ((eo)localObject2).field_msgId + "_" + ((eo)localObject2).field_content;
              Log.i("MicroMsg.ChattingUI.VoiceComponent", "showVoiceFastTransTextBt msg:%s", new Object[] { localObject1 });
              if (localObject2 == null) {
                break label467;
              }
              localObject1 = localk.zh(((eo)localObject2).field_msgId);
              if (localObject1 == null) {
                break label467;
              }
              localObject1 = (RelativeLayout)((View)localObject1).findViewById(2131298448);
              if (localObject1 != null) {
                bi.a(bi.this, ((eo)localObject2).field_msgId);
              }
            }
            for (;;)
            {
              if ((l != 0L) && ((localObject2 == null) || (l != ((eo)localObject2).field_msgId)))
              {
                localObject2 = localk.zh(l);
                if (localObject2 != null)
                {
                  localObject2 = (RelativeLayout)((View)localObject2).findViewById(2131298448);
                  if (localObject2 != null) {
                    bi.o(bi.this).add(new WeakReference(localObject2));
                  }
                }
              }
              localObject2 = bi.o(bi.this).iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (WeakReference)((Iterator)localObject2).next();
                  if ((localObject3 != null) && (((WeakReference)localObject3).get() != null) && (((WeakReference)localObject3).get() != localObject1))
                  {
                    ((View)((WeakReference)localObject3).get()).setVisibility(8);
                    continue;
                    localObject1 = "null";
                    break;
                  }
                }
              }
              if (localObject1 != null)
              {
                ((RelativeLayout)localObject1).setVisibility(0);
                if (l != bi.m(bi.this)) {
                  bf.a.aW(1, bi.m(bi.this));
                }
              }
              AppMethodBeat.o(233243);
              return;
              localObject1 = null;
            }
          }
        }
      });
    }
    AppMethodBeat.o(233255);
  }
  
  public final com.tencent.mm.ui.chatting.d gRx()
  {
    return this.Pvm;
  }
  
  public final void gRy()
  {
    AppMethodBeat.i(35778);
    aa localaa = (aa)this.dom.bh(aa.class);
    Object localObject = (l)this.dom.bh(l.class);
    ai localai = (ai)this.dom.bh(ai.class);
    if ((((l)localObject).gPB()) || (localai.gQN()))
    {
      Log.d("MicroMsg.ChattingUI.VoiceComponent", "trigger title icon, in show mode");
      this.dom.BW(false);
      localaa.setTitlePhoneIconVisibility(8);
      localaa.setTitleMuteIconVisibility(8);
      AppMethodBeat.o(35778);
      return;
    }
    if (((com.tencent.mm.plugin.forcenotify.a.b)g.af(com.tencent.mm.plugin.forcenotify.a.b.class)).axC(this.dom.getTalkerUserName()))
    {
      localaa.setTitleForceNotifyIconVisibility(0);
      localaa.setTitleMuteIconVisibility(8);
      label147:
      bg.aVF();
      localObject = (Boolean)com.tencent.mm.model.c.azQ().get(26, null);
      if (localObject != null) {
        break label244;
      }
      this.qUn = false;
      label173:
      Log.printInfoStack("MicroMsg.ChattingUI.VoiceComponent", "triggerTitleIcon and setForceSpeakOff value is %s", new Object[] { Boolean.valueOf(this.qUn) });
      if (!this.qUn) {
        break label255;
      }
    }
    label244:
    label255:
    for (int i = 0;; i = 8)
    {
      localaa.setTitlePhoneIconVisibility(i);
      AppMethodBeat.o(35778);
      return;
      localaa.setTitleForceNotifyIconVisibility(8);
      if (!Zx()) {
        break;
      }
      localaa.setTitleMuteIconVisibility(0);
      break label147;
      this.qUn = ((Boolean)localObject).booleanValue();
      break label173;
    }
  }
  
  public final boolean gRz()
  {
    return this.qUn;
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35786);
    AppMethodBeat.o(35786);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(35792);
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramq.getType());
    this.dom.dismissDialog();
    if (!this.dom.cQp)
    {
      Log.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35792);
      return;
    }
    if (!Util.isTopActivity(this.dom.Pwc.getContext()))
    {
      AppMethodBeat.o(35792);
      return;
    }
    Activity localActivity = this.dom.Pwc.getContext();
    int i;
    if (z.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(35792);
      return;
      if (com.tencent.mm.plugin.account.ui.a.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramq.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35792);
      return;
      paramString = s.Ro(((com.tencent.mm.modelvoice.f)paramq).fileName);
      if ((paramString != null) && (paramString.status == 99))
      {
        if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.soy, 1) == 1)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label504;
          }
          Log.i("MicroMsg.ChattingUI.VoiceComponent", "async playUploadVoiceSound");
          paramString = com.tencent.mm.ak.a.iLw;
          paramq = new kotlin.g.a.a() {};
          p.h("VoiceComponent_playUploadVoiceSound", "tag");
          p.h(paramq, "callback");
          Log.i(com.tencent.mm.ak.a.TAG, "play, tag:".concat(String.valueOf("VoiceComponent_playUploadVoiceSound")));
          paramString = (com.tencent.mm.ak.e)com.tencent.mm.ak.a.iLv.get("VoiceComponent_playUploadVoiceSound");
          if ((paramString == null) || (!paramString.thread.isAlive())) {
            break label427;
          }
        }
        for (paramString = paramString.handler;; paramString = paramString.handler)
        {
          paramString.post((Runnable)new com.tencent.mm.ak.b(paramq));
          AppMethodBeat.o(35792);
          return;
          paramInt1 = 0;
          break;
          label427:
          Log.i(com.tencent.mm.ak.a.TAG, "createNewHandler, tag:".concat(String.valueOf("VoiceComponent_playUploadVoiceSound")));
          paramString = new HandlerThread("VoiceComponent_playUploadVoiceSound");
          paramString.start();
          paramString = new com.tencent.mm.ak.e(paramString, new MMHandler(paramString.getLooper()));
          ((Map)com.tencent.mm.ak.a.iLv).put("VoiceComponent_playUploadVoiceSound", paramString);
        }
        label504:
        Log.i("MicroMsg.ChattingUI.VoiceComponent", "sync playUploadVoiceSound");
        PlaySound.play(this.dom.Pwc.getContext(), 2131755280);
      }
    }
  }
  
  public final void onScroll(AbsListView arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(233254);
    if (paramInt2 == 0)
    {
      Log.w("MicroMsg.ChattingUI.VoiceComponent", "onScroll visibleItemCount == 0");
      AppMethodBeat.o(233254);
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.Pvx != -1L) && (l - this.Pvx > 2000L)) {
      this.Pvw = false;
    }
    this.Pvx = l;
    Object localObject1 = (com.tencent.mm.ui.chatting.d.b.k)this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class);
    ??? = new bi.a();
    int i = this.dom.getHeaderViewsCount();
    ca localca = ((com.tencent.mm.ui.chatting.d.b.k)localObject1).amt(paramInt1 - i);
    if (localca != null) {
      ???.PvN = localca.field_msgId;
    }
    for (;;)
    {
      int j = paramInt1 - i + paramInt2 + 2;
      i = j;
      if (j > ((com.tencent.mm.ui.chatting.d.b.k)localObject1).getCount() - 1) {
        i = ((com.tencent.mm.ui.chatting.d.b.k)localObject1).getCount() - 1;
      }
      localObject1 = ((com.tencent.mm.ui.chatting.d.b.k)localObject1).amt(i);
      if (localObject1 != null) {
        ???.PvO = ((eo)localObject1).field_msgId;
      }
      this.Pvy = ???;
      Log.d("MicroMsg.ChattingUI.VoiceComponent", "onScroll firstVisibleItem:%s visibleItemCount:%s totalItemCount:%s isNoSmoothScrool:%s ifScroll:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.Pvw), Boolean.valueOf(this.Pvu) });
      if (!this.Pvu) {
        break;
      }
      this.Pvw = false;
      if (this.dBz != null) {
        this.dBz.cancel(true);
      }
      this.dBz = com.tencent.f.h.RTc.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233241);
          synchronized (bi.gRE())
          {
            if (bi.j(bi.this))
            {
              AppMethodBeat.o(233241);
              return;
            }
            bi.this.gRC();
            bi.k(bi.this);
            AppMethodBeat.o(233241);
            return;
          }
        }
      }, 300L);
      AppMethodBeat.o(233254);
      return;
      localca = ((com.tencent.mm.ui.chatting.d.b.k)localObject1).amt(paramInt1 + 1 - i);
      if (localca != null) {
        ???.PvN = localca.field_msgId;
      }
    }
    synchronized (lock)
    {
      if (this.Pvt)
      {
        this.Pvw = false;
        AppMethodBeat.o(233254);
        return;
      }
      if (this.Pvw)
      {
        this.Pvw = false;
        AppMethodBeat.o(233254);
        return;
      }
    }
    this.Pvw = true;
    gRC();
    AppMethodBeat.o(233254);
  }
  
  public final void onScrollStateChanged(AbsListView arg1, int paramInt)
  {
    AppMethodBeat.i(233253);
    super.onScrollStateChanged(???, paramInt);
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "onScrollStateChanged %s", new Object[] { Integer.valueOf(paramInt) });
    this.Pvw = false;
    if (paramInt == 0)
    {
      this.Pvu = false;
      synchronized (lock)
      {
        if (this.Pvt)
        {
          AppMethodBeat.o(233253);
          return;
        }
        gRC();
        AppMethodBeat.o(233253);
        return;
      }
    }
    this.Pvu = true;
    AppMethodBeat.o(233253);
  }
  
  public final void releaseWakeLock()
  {
    AppMethodBeat.i(35780);
    this.dom.setKeepScreenOn(false);
    if ((this.Pvm != null) && (this.Pvr))
    {
      this.Pvr = false;
      this.Pvm.gMO();
      this.Pvm.gMT();
      this.Pvm.release();
    }
    AppForegroundDelegate.djR.b(this.Pvs);
    this.Pvr = false;
    AppMethodBeat.o(35780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bi
 * JD-Core Version:    0.7.0.1
 */