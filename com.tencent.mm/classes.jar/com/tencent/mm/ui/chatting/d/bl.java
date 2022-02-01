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
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.f.a.aah;
import com.tencent.mm.f.a.aai;
import com.tencent.mm.f.a.aaj;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.d;
import com.tencent.mm.model.az.f;
import com.tencent.mm.model.bh;
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
import com.tencent.mm.ui.ac.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.viewitems.bk.a;
import com.tencent.mm.ui.tools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import kotlin.g.b.p;
import kotlin.x;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.ax.class)
public class bl
  extends a
  implements com.tencent.mm.an.i, com.tencent.mm.ui.chatting.d.b.ax
{
  private static Object lock;
  private az.d Mhz;
  private com.tencent.mm.ui.chatting.d WPF;
  private boolean WPG;
  private long WPH;
  private WeakReference<View> WPI;
  private ConcurrentHashMap<Long, Boolean> WPJ;
  private boolean WPK;
  private o WPL;
  private boolean WPM;
  private boolean WPN;
  private long WPO;
  private boolean WPP;
  private long WPQ;
  private bl.a WPR;
  private Future WPS;
  private IListener<aai> WPT;
  private IListener<aaj> WPU;
  private View WPV;
  public ChatFooter.d WPW;
  private IListener<aah> WPX;
  private List<WeakReference<View>> WPY;
  private Future fuk;
  private int oFY;
  public boolean uwt;
  
  static
  {
    AppMethodBeat.i(266995);
    lock = new Object();
    AppMethodBeat.o(266995);
  }
  
  public bl()
  {
    AppMethodBeat.i(35775);
    this.WPF = null;
    this.uwt = false;
    this.WPG = false;
    this.WPJ = new ConcurrentHashMap();
    this.WPK = false;
    this.WPL = new o()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(289262);
        if (bl.a(bl.this)) {
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(269761);
              bl.this.releaseWakeLock();
              AppMethodBeat.o(269761);
            }
          });
        }
        AppMethodBeat.o(289262);
      }
      
      public final void onAppForeground(String paramAnonymousString) {}
    };
    this.WPM = false;
    this.oFY = -1;
    this.WPN = false;
    this.fuk = null;
    this.WPO = -1L;
    this.WPP = false;
    this.WPQ = -1L;
    this.WPR = null;
    this.WPS = null;
    this.Mhz = new az.d()
    {
      public final void y(String paramAnonymousString, final long paramAnonymousLong)
      {
        AppMethodBeat.i(229118);
        Log.d("MicroMsg.ChattingUI.VoiceComponent", "onVoiceRemind " + paramAnonymousString + " time " + paramAnonymousLong);
        if (ab.QJ(bh.getNotification().aqX())) {
          com.tencent.mm.ui.base.h.a(bl.this.fgR.WQv.getContext(), false, paramAnonymousString, bl.this.fgR.WQv.getMMResources().getString(R.l.eVn), bl.this.fgR.WQv.getMMResources().getString(R.l.eVk), bl.this.fgR.WQv.getMMResources().getString(R.l.eVm), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(277389);
              bh.beI();
              if (com.tencent.mm.model.c.bbO().aQ(bh.getNotification().aqX(), paramAnonymousLong))
              {
                int i = ((com.tencent.mm.ui.chatting.d.b.k)bl.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).dpe();
                paramAnonymous2Int = ((com.tencent.mm.ui.chatting.d.b.k)bl.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).getCount();
                bh.beI();
                i = com.tencent.mm.model.c.bbO().i(bh.getNotification().aqX(), paramAnonymousLong, i - paramAnonymous2Int);
                if (i < 0)
                {
                  AppMethodBeat.o(277389);
                  return;
                }
                if (paramAnonymous2Int > i) {
                  bl.this.fgR.avn(i);
                }
              }
              AppMethodBeat.o(277389);
            }
          }, null);
        }
        AppMethodBeat.o(229118);
      }
    };
    this.WPT = new IListener() {};
    this.WPU = new IListener() {};
    this.WPV = null;
    this.WPW = new ChatFooter.d()
    {
      public final void x(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(289715);
        if (paramAnonymousBoolean.booleanValue())
        {
          if (bl.h(bl.this) == null) {
            bl.a(bl.this, ((ViewStub)bl.this.fgR.findViewById(R.h.dZC)).inflate());
          }
          bl.h(bl.this).setVisibility(0);
          AppMethodBeat.o(289715);
          return;
        }
        if ((bl.h(bl.this) != null) && (bl.h(bl.this).getVisibility() == 0)) {
          bl.h(bl.this).setVisibility(8);
        }
        AppMethodBeat.o(289715);
      }
    };
    this.WPX = new IListener() {};
    this.WPY = new ArrayList();
    AppMethodBeat.o(35775);
  }
  
  private void doPause()
  {
    AppMethodBeat.i(266974);
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "voiceComponent doPause");
    this.WPG = false;
    if ((ab.QJ(this.fgR.getTalkerUserName())) && (az.a.ltu != null)) {
      az.a.ltu.b(this.Mhz);
    }
    if ((this.WPV != null) && (this.WPV.getVisibility() == 0))
    {
      Log.i("MicroMsg.ChattingUI.VoiceComponent", "doPause set voiceinputMask GONE");
      this.WPV.setVisibility(8);
    }
    ((u)this.fgR.bC(u.class)).setVoiceInputShowCallback(null);
    bh.beI();
    com.tencent.mm.model.c.aHp().i(26, Boolean.valueOf(this.uwt));
    if ((this.WPF != null) && (this.WPF.isPlaying()))
    {
      localy = y.XVr;
      if (!y.hYI())
      {
        this.WPK = true;
        localy = y.XVr;
        y.Hg(true);
        AppForegroundDelegate.fby.a(this.WPL);
        AppMethodBeat.o(266974);
        return;
      }
    }
    y localy = y.XVr;
    y.Hg(true);
    if ((!com.tencent.mm.ui.w.hHJ()) && (this.WPF != null))
    {
      this.WPF.hLX();
      this.WPF.hMc();
      this.WPF.release();
    }
    AppMethodBeat.o(266974);
  }
  
  public static boolean hRa()
  {
    AppMethodBeat.i(266990);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vSu, 0);
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "isOpenVoiceTransTextBt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(266990);
      return true;
    }
    AppMethodBeat.o(266990);
    return false;
  }
  
  public final void Gq(boolean paramBoolean)
  {
    AppMethodBeat.i(35781);
    if (this.WPF == null)
    {
      Log.e("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff error, autoPlay is null!!!");
      AppMethodBeat.o(35781);
      return;
    }
    Log.printInfoStack("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff value is %s", new Object[] { Boolean.valueOf(paramBoolean) });
    aa localaa = (aa)this.fgR.bC(aa.class);
    if (paramBoolean)
    {
      this.WPF.Gg(false);
      this.uwt = true;
      bh.beI();
      com.tencent.mm.model.c.aHp().i(26, Boolean.TRUE);
      localaa.setTitlePhoneIconVisibility(0);
      Toast.makeText(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.eFL), 0).show();
      this.WPF.hMb();
      this.fgR.avL(R.k.actionbar_ear_icon);
      AppMethodBeat.o(35781);
      return;
    }
    if (!com.tencent.mm.plugin.audio.c.a.cro()) {
      this.WPF.Gg(true);
    }
    for (;;)
    {
      this.uwt = false;
      bh.beI();
      com.tencent.mm.model.c.aHp().i(26, Boolean.FALSE);
      localaa.setTitlePhoneIconVisibility(8);
      Toast.makeText(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.eFM), 0).show();
      this.WPF.hMb();
      this.fgR.avL(R.k.actionbar_loud_icon);
      AppMethodBeat.o(35781);
      return;
      Log.i("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff true but isBluetoothOn");
    }
  }
  
  public final void VV(long paramLong)
  {
    AppMethodBeat.i(266977);
    this.WPJ.put(Long.valueOf(paramLong), Boolean.TRUE);
    AppMethodBeat.o(266977);
  }
  
  public final boolean VW(long paramLong)
  {
    AppMethodBeat.i(266978);
    if (this.WPJ.containsKey(Long.valueOf(paramLong)))
    {
      boolean bool = ((Boolean)this.WPJ.get(Long.valueOf(paramLong))).booleanValue();
      AppMethodBeat.o(266978);
      return bool;
    }
    AppMethodBeat.o(266978);
    return false;
  }
  
  public final void VX(long paramLong)
  {
    AppMethodBeat.i(266982);
    if (this.WPO == paramLong) {}
    synchronized (lock)
    {
      this.WPM = true;
      ??? = ((com.tencent.mm.ui.chatting.d.b.k)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).Fl(this.WPO);
      if (??? != null)
      {
        ??? = (RelativeLayout)((View)???).findViewById(R.h.dxG);
        if (??? != null)
        {
          this.WPO = -1L;
          ((RelativeLayout)???).setVisibility(8);
        }
      }
      AppMethodBeat.o(266982);
      return;
    }
  }
  
  public final void VY(long paramLong)
  {
    AppMethodBeat.i(266983);
    synchronized (lock)
    {
      this.WPM = true;
      if (this.WPO == paramLong)
      {
        ??? = ((com.tencent.mm.ui.chatting.d.b.k)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).Fl(this.WPO);
        if (??? != null)
        {
          ??? = (RelativeLayout)((View)???).findViewById(R.h.dxG);
          if (??? != null)
          {
            this.WPO = -1L;
            ((RelativeLayout)???).setVisibility(8);
          }
        }
      }
      AppMethodBeat.o(266983);
      return;
    }
  }
  
  public final boolean VZ(long paramLong)
  {
    return this.WPO == paramLong;
  }
  
  public final void a(long paramLong, View paramView)
  {
    AppMethodBeat.i(266980);
    this.WPH = paramLong;
    this.WPI = new WeakReference(paramView);
    AppMethodBeat.o(266980);
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
        if (this.fgR.WQv.getMMResources().getConfiguration().orientation == 2)
        {
          paramMMFragment.setRequestedOrientation(0);
          AppMethodBeat.o(35784);
          return;
        }
        if (this.fgR.WQv.getMMResources().getConfiguration().orientation == 1)
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
    AppMethodBeat.i(266985);
    super.a(parama);
    this.WPX.alive();
    AppMethodBeat.o(266985);
  }
  
  public final void acquireWakeLock()
  {
    AppMethodBeat.i(35779);
    this.fgR.setKeepScreenOn(true);
    AppMethodBeat.o(35779);
  }
  
  public final boolean aeg()
  {
    AppMethodBeat.i(35777);
    boolean bool1 = ((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe();
    boolean bool2 = ((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOf();
    int i;
    if ((this.fgR.hRh()) || (bool2)) {
      i = 1;
    }
    while (bool1) {
      if (bool2)
      {
        bool1 = ((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOc().jQ(1);
        AppMethodBeat.o(35777);
        return bool1;
        i = 0;
      }
      else
      {
        bool1 = ((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOd().jQ(1);
        AppMethodBeat.o(35777);
        return bool1;
      }
    }
    if (((i != 0) && (this.fgR.NKq.hDj == 0)) || (this.fgR.NKq.aeg()))
    {
      AppMethodBeat.o(35777);
      return true;
    }
    AppMethodBeat.o(35777);
    return false;
  }
  
  public final boolean cE(ca paramca)
  {
    AppMethodBeat.i(35782);
    if (paramca.hwF())
    {
      if (paramca.field_msgId == this.WPF.WxA) {
        this.WPF.hMc();
      }
      AppMethodBeat.o(35782);
      return true;
    }
    AppMethodBeat.o(35782);
    return false;
  }
  
  public final boolean cF(ca paramca)
  {
    AppMethodBeat.i(35783);
    if (paramca.hwF())
    {
      bh.beI();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.w.g(this.fgR.WQv.getContext(), this.fgR.WQv.getContentView());
        AppMethodBeat.o(35783);
        return true;
      }
      if (paramca.field_msgId == this.WPF.WxA) {
        this.WPF.hMc();
      }
      if (!this.fgR.getTalkerUserName().equals("medianote"))
      {
        bh.beI();
        com.tencent.mm.model.c.bbK().d(new com.tencent.mm.bd.f(paramca.field_talker, paramca.field_msgSvrId));
      }
      ak.ca(paramca);
      AppMethodBeat.o(35783);
      return true;
    }
    AppMethodBeat.o(35783);
    return false;
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35787);
    hQV();
    AppMethodBeat.o(35787);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35788);
    bh.aGY().a(127, this);
    this.WPT.alive();
    this.WPU.alive();
    this.WPM = false;
    hQZ();
    AppMethodBeat.o(35788);
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(35789);
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay looper[%s]", new Object[] { Looper.myLooper() });
    this.WPG = true;
    long l = System.currentTimeMillis();
    Object localObject;
    if (!this.WPK)
    {
      Log.i("MicroMsg.ChattingUI.VoiceComponent", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", new Object[] { this.WPF, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper() });
      if (this.WPF != null) {
        break label398;
      }
      this.WPF = new com.tencent.mm.ui.chatting.d(this.fgR, this, this.fgR.getTalkerUserName());
      com.tencent.mm.modelvoice.t.c(this.WPF);
      com.tencent.mm.modelvoice.e.a(this.WPF);
      bh.beI();
      bool = Util.nullAs((Boolean)com.tencent.mm.model.c.aHp().b(16387, null), true);
      localObject = this.WPF;
      if (!((com.tencent.mm.ui.chatting.d)localObject).WxG)
      {
        ((com.tencent.mm.ui.chatting.d)localObject).auto = bool;
        ((com.tencent.mm.ui.chatting.d)localObject).hLX();
      }
      localObject = ((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOb();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.api.c)localObject).dc(false);
        if (localObject != null)
        {
          if (((c.b)localObject).eZg != null)
          {
            if (((c.b)localObject).eZg.optInt("AudioPlayType", 0) != 1) {
              break label415;
            }
            bool = true;
            label234:
            ((c.b)localObject).eZw = bool;
          }
          if (((c.b)localObject).eZw) {
            this.WPF.WxF = false;
          }
        }
      }
      localObject = this.WPF;
      if (this.uwt) {
        break label420;
      }
    }
    label398:
    label415:
    label420:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.ui.chatting.d)localObject).Gg(bool);
      this.WPF.oO(true);
      Log.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay end take[%s]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if ((ab.QJ(this.fgR.getTalkerUserName())) && (az.a.ltu != null)) {
        az.a.ltu.a(this.Mhz);
      }
      if (!com.tencent.mm.az.b.bmW()) {
        ((u)this.fgR.bC(u.class)).setVoiceInputShowCallback(this.WPW);
      }
      hQV();
      AppForegroundDelegate.fby.b(this.WPL);
      localObject = y.XVr;
      y.Hg(true);
      AppMethodBeat.o(35789);
      return;
      this.WPF.byU(this.fgR.getTalkerUserName());
      break;
      bool = false;
      break label234;
    }
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35790);
    doPause();
    AppMethodBeat.o(35790);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35791);
    bh.aGY().b(127, this);
    if (this.WPS != null) {
      this.WPS.cancel(true);
    }
    this.WPT.dead();
    this.WPU.dead();
    this.WPJ.clear();
    AppMethodBeat.o(35791);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35785);
    super.hNZ();
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "doDestroy, autoPlay:%s", new Object[] { this.WPF });
    com.tencent.mm.modelvoice.t.b(this.WPF);
    com.tencent.mm.modelvoice.e.b(this.WPF);
    bh.aGY().b(127, this);
    releaseWakeLock();
    if (this.WPF != null)
    {
      this.WPF.hLX();
      localObject = this.WPF;
      ((com.tencent.mm.ui.chatting.d)localObject).release();
      ((com.tencent.mm.ui.chatting.d)localObject).uwr.unInit();
      ((com.tencent.mm.ui.chatting.d)localObject).context = null;
      ((com.tencent.mm.ui.chatting.d)localObject).WxG = false;
      EventCenter.instance.removeListener(((com.tencent.mm.ui.chatting.d)localObject).WxL);
      bh.abL().b((ap)localObject);
      this.WPF = null;
    }
    Object localObject = com.tencent.mm.an.a.lBD;
    com.tencent.mm.an.a.TV("VoiceComponent_playUploadVoiceSound");
    this.WPX.dead();
    AppMethodBeat.o(35785);
  }
  
  public final com.tencent.mm.ui.chatting.d hQU()
  {
    return this.WPF;
  }
  
  public final void hQV()
  {
    AppMethodBeat.i(35778);
    aa localaa = (aa)this.fgR.bC(aa.class);
    Object localObject = (l)this.fgR.bC(l.class);
    ai localai = (ai)this.fgR.bC(ai.class);
    if ((((l)localObject).hOT()) || (localai.hQk()))
    {
      Log.d("MicroMsg.ChattingUI.VoiceComponent", "trigger title icon, in show mode");
      this.fgR.Gr(false);
      localaa.setTitlePhoneIconVisibility(8);
      localaa.setTitleMuteIconVisibility(8);
      AppMethodBeat.o(35778);
      return;
    }
    if (aeg())
    {
      localaa.setTitleMuteIconVisibility(0);
      bh.beI();
      localObject = (Boolean)com.tencent.mm.model.c.aHp().b(26, null);
      if (localObject != null) {
        break label205;
      }
      this.uwt = false;
      label148:
      Log.printInfoStack("MicroMsg.ChattingUI.VoiceComponent", "triggerTitleIcon and setForceSpeakOff value is %s", new Object[] { Boolean.valueOf(this.uwt) });
      if (!this.uwt) {
        break label216;
      }
    }
    label205:
    label216:
    for (int i = 0;; i = 8)
    {
      localaa.setTitlePhoneIconVisibility(i);
      AppMethodBeat.o(35778);
      return;
      localaa.setTitleMuteIconVisibility(8);
      break;
      this.uwt = ((Boolean)localObject).booleanValue();
      break label148;
    }
  }
  
  public final boolean hQW()
  {
    return this.uwt;
  }
  
  public final void hQX()
  {
    this.WPH = 0L;
  }
  
  public final void hQY()
  {
    AppMethodBeat.i(266984);
    this.WPP = true;
    hQZ();
    AppMethodBeat.o(266984);
  }
  
  public final void hQZ()
  {
    AppMethodBeat.i(266989);
    if (((ai)this.fgR.bC(ai.class)).hQk())
    {
      AppMethodBeat.o(266989);
      return;
    }
    if (!hRa())
    {
      AppMethodBeat.o(266989);
      return;
    }
    final com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class);
    final SparseArray localSparseArray = localk.hNB();
    if (localSparseArray != null) {
      this.WPS = com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(289549);
          Log.d("MicroMsg.ChattingUI.VoiceComponent", "showVoiceFastTransTextBt lastScrollState:%s", new Object[] { bl.l(bl.this) });
          long l = bl.m(bl.this);
          bl.a(bl.this, -1L);
          int j = bl.n(bl.this);
          bl.o(bl.this).clear();
          int i = localSparseArray.size() - 1;
          Object localObject1 = null;
          Object localObject2;
          Object localObject3;
          if (i >= 0)
          {
            localObject2 = (ca)localSparseArray.get(i);
            localObject3 = bl.a(bl.this, localk, (ca)localObject2, j);
            if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
              break label478;
            }
            localObject1 = localObject2;
          }
          label472:
          label478:
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
              localObject1 = ((et)localObject2).field_msgId + "_" + Util.secPrint(((et)localObject2).field_content);
              Log.i("MicroMsg.ChattingUI.VoiceComponent", "showVoiceFastTransTextBt msg:%s", new Object[] { localObject1 });
              if (localObject2 == null) {
                break label472;
              }
              localObject1 = localk.Fl(((et)localObject2).field_msgId);
              if (localObject1 == null) {
                break label472;
              }
              localObject1 = (RelativeLayout)((View)localObject1).findViewById(R.h.dxG);
              if (localObject1 != null) {
                bl.a(bl.this, ((et)localObject2).field_msgId);
              }
            }
            for (;;)
            {
              if ((l != 0L) && ((localObject2 == null) || (l != ((et)localObject2).field_msgId)))
              {
                localObject2 = localk.Fl(l);
                if (localObject2 != null)
                {
                  localObject2 = (RelativeLayout)((View)localObject2).findViewById(R.h.dxG);
                  if (localObject2 != null) {
                    bl.o(bl.this).add(new WeakReference(localObject2));
                  }
                }
              }
              localObject2 = bl.o(bl.this).iterator();
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
                if (l != bl.m(bl.this)) {
                  bk.a.bh(1, bl.m(bl.this));
                }
              }
              AppMethodBeat.o(289549);
              return;
              localObject1 = null;
            }
          }
        }
      });
    }
    AppMethodBeat.o(266989);
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
    this.fgR.dismissDialog();
    if (!this.fgR.dgo)
    {
      Log.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35792);
      return;
    }
    if (!Util.isTopActivity(this.fgR.WQv.getContext()))
    {
      AppMethodBeat.o(35792);
      return;
    }
    Activity localActivity = this.fgR.WQv.getContext();
    int i;
    if (ac.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
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
      paramString = s.YL(((com.tencent.mm.modelvoice.f)paramq).fileName);
      if ((paramString != null) && (paramString.status == 99))
      {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vZY, 1) == 1)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label504;
          }
          Log.i("MicroMsg.ChattingUI.VoiceComponent", "async playUploadVoiceSound");
          paramString = com.tencent.mm.an.a.lBD;
          paramq = new kotlin.g.a.a() {};
          p.k("VoiceComponent_playUploadVoiceSound", "tag");
          p.k(paramq, "callback");
          Log.i(com.tencent.mm.an.a.TAG, "play, tag:".concat(String.valueOf("VoiceComponent_playUploadVoiceSound")));
          paramString = (com.tencent.mm.an.e)com.tencent.mm.an.a.lBC.get("VoiceComponent_playUploadVoiceSound");
          if ((paramString == null) || (!paramString.thread.isAlive())) {
            break label427;
          }
        }
        for (paramString = paramString.handler;; paramString = paramString.handler)
        {
          paramString.post((Runnable)new com.tencent.mm.an.b(paramq));
          AppMethodBeat.o(35792);
          return;
          paramInt1 = 0;
          break;
          label427:
          Log.i(com.tencent.mm.an.a.TAG, "createNewHandler, tag:".concat(String.valueOf("VoiceComponent_playUploadVoiceSound")));
          paramString = new HandlerThread("VoiceComponent_playUploadVoiceSound");
          paramString.start();
          paramString = new com.tencent.mm.an.e(paramString, new MMHandler(paramString.getLooper()));
          ((Map)com.tencent.mm.an.a.lBC).put("VoiceComponent_playUploadVoiceSound", paramString);
        }
        label504:
        Log.i("MicroMsg.ChattingUI.VoiceComponent", "sync playUploadVoiceSound");
        PlaySound.play(this.fgR.WQv.getContext(), R.l.after_upload_voice);
      }
    }
  }
  
  public final void onScroll(AbsListView arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(266988);
    if (paramInt2 == 0)
    {
      Log.w("MicroMsg.ChattingUI.VoiceComponent", "onScroll visibleItemCount == 0");
      AppMethodBeat.o(266988);
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.WPQ != -1L) && (l - this.WPQ > 2000L)) {
      this.WPP = false;
    }
    this.WPQ = l;
    Object localObject1 = (com.tencent.mm.ui.chatting.d.b.k)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class);
    ??? = new bl.a();
    int i = this.fgR.hMq();
    ca localca = ((com.tencent.mm.ui.chatting.d.b.k)localObject1).avt(paramInt1 - i);
    if (localca != null) {
      ???.WQg = localca.field_msgId;
    }
    for (;;)
    {
      int j = paramInt1 - i + paramInt2 + 2;
      i = j;
      if (j > ((com.tencent.mm.ui.chatting.d.b.k)localObject1).getCount() - 1) {
        i = ((com.tencent.mm.ui.chatting.d.b.k)localObject1).getCount() - 1;
      }
      localObject1 = ((com.tencent.mm.ui.chatting.d.b.k)localObject1).avt(i);
      if (localObject1 != null) {
        ???.WQh = ((et)localObject1).field_msgId;
      }
      this.WPR = ???;
      Log.d("MicroMsg.ChattingUI.VoiceComponent", "onScroll firstVisibleItem:%s visibleItemCount:%s totalItemCount:%s isNoSmoothScrool:%s ifScroll:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.WPP), Boolean.valueOf(this.WPN) });
      if (!this.WPN) {
        break;
      }
      this.WPP = false;
      if (this.fuk != null) {
        this.fuk.cancel(true);
      }
      this.fuk = com.tencent.e.h.ZvG.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(280525);
          synchronized (bl.hRb())
          {
            if (bl.j(bl.this))
            {
              AppMethodBeat.o(280525);
              return;
            }
            bl.this.hQZ();
            bl.k(bl.this);
            AppMethodBeat.o(280525);
            return;
          }
        }
      }, 300L);
      AppMethodBeat.o(266988);
      return;
      localca = ((com.tencent.mm.ui.chatting.d.b.k)localObject1).avt(paramInt1 + 1 - i);
      if (localca != null) {
        ???.WQg = localca.field_msgId;
      }
    }
    synchronized (lock)
    {
      if (this.WPM)
      {
        this.WPP = false;
        AppMethodBeat.o(266988);
        return;
      }
      if (this.WPP)
      {
        this.WPP = false;
        AppMethodBeat.o(266988);
        return;
      }
    }
    this.WPP = true;
    hQZ();
    AppMethodBeat.o(266988);
  }
  
  public final void onScrollStateChanged(AbsListView arg1, int paramInt)
  {
    AppMethodBeat.i(266986);
    super.onScrollStateChanged(???, paramInt);
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "onScrollStateChanged %s", new Object[] { Integer.valueOf(paramInt) });
    this.WPP = false;
    if (paramInt == 0)
    {
      this.WPN = false;
      synchronized (lock)
      {
        if (this.WPM)
        {
          AppMethodBeat.o(266986);
          return;
        }
        hQZ();
        AppMethodBeat.o(266986);
        return;
      }
    }
    this.WPN = true;
    AppMethodBeat.o(266986);
  }
  
  public final void releaseWakeLock()
  {
    AppMethodBeat.i(35780);
    this.fgR.setKeepScreenOn(false);
    if ((this.WPF != null) && (this.WPK))
    {
      this.WPK = false;
      this.WPF.hLX();
      this.WPF.hMc();
      this.WPF.release();
    }
    AppForegroundDelegate.fby.b(this.WPL);
    this.WPK = false;
    AppMethodBeat.o(35780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bl
 * JD-Core Version:    0.7.0.1
 */