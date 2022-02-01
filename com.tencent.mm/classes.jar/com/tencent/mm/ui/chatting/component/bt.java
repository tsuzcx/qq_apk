package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
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
import com.tencent.mm.am.p;
import com.tencent.mm.api.c.b;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q;
import com.tencent.mm.au.b;
import com.tencent.mm.autogen.a.ace;
import com.tencent.mm.autogen.a.acf;
import com.tencent.mm.autogen.a.acg;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.d;
import com.tencent.mm.model.az.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.t;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ae.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.component.api.ad;
import com.tencent.mm.ui.chatting.component.api.bf;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.n;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.viewitems.bl.a;
import com.tencent.mm.ui.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import kotlin.ah;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=bf.class)
public class bt
  extends a
  implements com.tencent.mm.am.h, bf
{
  private static Object lock;
  private az.d SIW;
  private d aeyY;
  private boolean aeyZ;
  private long aeza;
  private WeakReference<View> aezb;
  private ConcurrentHashMap<Long, Boolean> aezc;
  private boolean aezd;
  private q aeze;
  private boolean aezf;
  private boolean aezg;
  private long aezh;
  private boolean aezi;
  private long aezj;
  private bt.a aezk;
  private Future aezl;
  private IListener<acf> aezm;
  private IListener<acg> aezn;
  private View aezo;
  public ChatFooter.d aezp;
  private IListener<ace> aezq;
  private List<WeakReference<View>> aezr;
  private Future dBj;
  private int rIW;
  public boolean xCS;
  
  static
  {
    AppMethodBeat.i(256406);
    lock = new Object();
    AppMethodBeat.o(256406);
  }
  
  public bt()
  {
    AppMethodBeat.i(35775);
    this.aeyY = null;
    this.xCS = false;
    this.aeyZ = false;
    this.aezc = new ConcurrentHashMap();
    this.aezd = false;
    this.aeze = new q()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(256055);
        if (bt.a(bt.this)) {
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(256134);
              bt.this.releaseWakeLock();
              AppMethodBeat.o(256134);
            }
          });
        }
        AppMethodBeat.o(256055);
      }
      
      public final void onAppForeground(String paramAnonymousString) {}
    };
    this.aezf = false;
    this.rIW = -1;
    this.aezg = false;
    this.dBj = null;
    this.aezh = -1L;
    this.aezi = false;
    this.aezj = -1L;
    this.aezk = null;
    this.aezl = null;
    this.SIW = new az.d()
    {
      public final void C(String paramAnonymousString, final long paramAnonymousLong)
      {
        AppMethodBeat.i(256249);
        Log.d("MicroMsg.ChattingUI.VoiceComponent", "onVoiceRemind " + paramAnonymousString + " time " + paramAnonymousLong);
        if (au.bwn(bh.getNotification().aKU())) {
          com.tencent.mm.ui.base.k.a(bt.this.hlc.aezO.getContext(), false, paramAnonymousString, bt.this.hlc.aezO.getMMResources().getString(R.l.gYr), bt.this.hlc.aezO.getMMResources().getString(R.l.gYo), bt.this.hlc.aezO.getMMResources().getString(R.l.gYq), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(256341);
              bh.bCz();
              if (com.tencent.mm.model.c.bzD().aZ(bh.getNotification().aKU(), paramAnonymousLong))
              {
                int i = ((m)bt.this.hlc.cm(m.class)).dWF();
                paramAnonymous2Int = ((m)bt.this.hlc.cm(m.class)).getCount();
                bh.bCz();
                i = com.tencent.mm.model.c.bzD().k(bh.getNotification().aKU(), paramAnonymousLong, i - paramAnonymous2Int);
                if (i < 0)
                {
                  AppMethodBeat.o(256341);
                  return;
                }
                if (paramAnonymous2Int > i) {
                  bt.this.hlc.b(i, false, false, 0);
                }
              }
              AppMethodBeat.o(256341);
            }
          }, null);
        }
        AppMethodBeat.o(256249);
      }
    };
    this.aezm = new VoiceComponent.3(this, com.tencent.mm.app.f.hfK);
    this.aezn = new VoiceComponent.4(this, com.tencent.mm.app.f.hfK);
    this.aezo = null;
    this.aezp = new ChatFooter.d()
    {
      public final void J(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(256232);
        if (paramAnonymousBoolean.booleanValue())
        {
          if (bt.h(bt.this) == null) {
            bt.a(bt.this, ((ViewStub)bt.this.hlc.findViewById(R.h.gcq)).inflate());
          }
          bt.h(bt.this).setVisibility(0);
          AppMethodBeat.o(256232);
          return;
        }
        if ((bt.h(bt.this) != null) && (bt.h(bt.this).getVisibility() == 0)) {
          bt.h(bt.this).setVisibility(8);
        }
        AppMethodBeat.o(256232);
      }
    };
    this.aezq = new VoiceComponent.6(this, com.tencent.mm.app.f.hfK);
    this.aezr = new ArrayList();
    AppMethodBeat.o(35775);
  }
  
  private void doPause()
  {
    AppMethodBeat.i(256346);
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "voiceComponent doPause");
    this.aeyZ = false;
    if ((au.bwn(this.hlc.getTalkerUserName())) && (az.a.okS != null)) {
      az.a.okS.b(this.SIW);
    }
    if ((this.aezo != null) && (this.aezo.getVisibility() == 0))
    {
      Log.i("MicroMsg.ChattingUI.VoiceComponent", "doPause set voiceinputMask GONE");
      this.aezo.setVisibility(8);
    }
    ((com.tencent.mm.ui.chatting.component.api.x)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.x.class)).setVoiceInputShowCallback(null);
    bh.bCz();
    com.tencent.mm.model.c.ban().B(26, Boolean.valueOf(this.xCS));
    if ((this.aeyY != null) && (this.aeyY.isPlaying()))
    {
      localx = com.tencent.mm.ui.tools.x.afLD;
      if (!com.tencent.mm.ui.tools.x.jDr())
      {
        this.aezd = true;
        localx = com.tencent.mm.ui.tools.x.afLD;
        com.tencent.mm.ui.tools.x.Nb(true);
        AppForegroundDelegate.heY.a(this.aeze);
        AppMethodBeat.o(256346);
        return;
      }
    }
    com.tencent.mm.ui.tools.x localx = com.tencent.mm.ui.tools.x.afLD;
    com.tencent.mm.ui.tools.x.Nb(true);
    if ((!y.jjS()) && (this.aeyY != null))
    {
      this.aeyY.joz();
      this.aeyY.joD();
      this.aeyY.release();
    }
    AppMethodBeat.o(256346);
  }
  
  public static boolean juz()
  {
    return true;
  }
  
  public final void Ad(long paramLong)
  {
    AppMethodBeat.i(256433);
    this.aezc.put(Long.valueOf(paramLong), Boolean.TRUE);
    AppMethodBeat.o(256433);
  }
  
  public final boolean Ae(long paramLong)
  {
    AppMethodBeat.i(256434);
    if (this.aezc.containsKey(Long.valueOf(paramLong)))
    {
      boolean bool = ((Boolean)this.aezc.get(Long.valueOf(paramLong))).booleanValue();
      AppMethodBeat.o(256434);
      return bool;
    }
    AppMethodBeat.o(256434);
    return false;
  }
  
  public final void Af(long paramLong)
  {
    AppMethodBeat.i(256448);
    if (this.aezh == paramLong) {}
    synchronized (lock)
    {
      this.aezf = true;
      ??? = ((m)this.hlc.cm(m.class)).ht(this.aezh);
      if (??? != null)
      {
        ??? = (RelativeLayout)((View)???).findViewById(R.h.fyk);
        if (??? != null)
        {
          this.aezh = -1L;
          ((RelativeLayout)???).setVisibility(8);
        }
      }
      AppMethodBeat.o(256448);
      return;
    }
  }
  
  public final void Ag(long paramLong)
  {
    AppMethodBeat.i(256453);
    synchronized (lock)
    {
      this.aezf = true;
      if (this.aezh == paramLong)
      {
        ??? = ((m)this.hlc.cm(m.class)).ht(this.aezh);
        if (??? != null)
        {
          ??? = (RelativeLayout)((View)???).findViewById(R.h.fyk);
          if (??? != null)
          {
            this.aezh = -1L;
            ((RelativeLayout)???).setVisibility(8);
          }
        }
      }
      AppMethodBeat.o(256453);
      return;
    }
  }
  
  public final boolean Ah(long paramLong)
  {
    return this.aezh == paramLong;
  }
  
  public final void Me(boolean paramBoolean)
  {
    AppMethodBeat.i(35781);
    if (this.aeyY == null)
    {
      Log.e("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff error, autoPlay is null!!!");
      AppMethodBeat.o(35781);
      return;
    }
    Log.printInfoStack("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff value is %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ad localad = (ad)this.hlc.cm(ad.class);
    if (paramBoolean)
    {
      this.aeyY.LT(false);
      this.xCS = true;
      bh.bCz();
      com.tencent.mm.model.c.ban().B(26, Boolean.TRUE);
      localad.setTitlePhoneIconVisibility(0);
      Toast.makeText(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gIG), 0).show();
      this.aeyY.joC();
      this.hlc.aCr(R.k.actionbar_ear_icon);
      AppMethodBeat.o(35781);
      return;
    }
    if (!com.tencent.mm.plugin.audio.c.a.cTX()) {
      this.aeyY.LT(true);
    }
    for (;;)
    {
      this.xCS = false;
      bh.bCz();
      com.tencent.mm.model.c.ban().B(26, Boolean.FALSE);
      localad.setTitlePhoneIconVisibility(8);
      Toast.makeText(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gIH), 0).show();
      this.aeyY.joC();
      this.hlc.aCr(R.k.actionbar_loud_icon);
      AppMethodBeat.o(35781);
      return;
      Log.i("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff true but isBluetoothOn");
    }
  }
  
  public final void a(long paramLong, View paramView)
  {
    AppMethodBeat.i(256442);
    this.aeza = paramLong;
    this.aezb = new WeakReference(paramView);
    AppMethodBeat.o(256442);
  }
  
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
        if (this.hlc.aezO.getMMResources().getConfiguration().orientation == 2)
        {
          paramMMFragment.setRequestedOrientation(0);
          AppMethodBeat.o(35784);
          return;
        }
        if (this.hlc.aezO.getMMResources().getConfiguration().orientation == 1)
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
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(256469);
    super.a(parama);
    this.aezq.alive();
    AppMethodBeat.o(256469);
  }
  
  public final boolean aGe()
  {
    AppMethodBeat.i(35777);
    boolean bool1 = ((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqV();
    boolean bool2 = ((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqW();
    int i;
    if ((this.hlc.juF()) || (bool2)) {
      i = 1;
    }
    while (bool1) {
      if (bool2)
      {
        bool1 = ((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqT().nG(1);
        AppMethodBeat.o(35777);
        return bool1;
        i = 0;
      }
      else
      {
        bool1 = ((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqU().nG(1);
        AppMethodBeat.o(35777);
        return bool1;
      }
    }
    if (((i != 0) && (this.hlc.Uxa.kaf == 0)) || (this.hlc.Uxa.aGe()))
    {
      AppMethodBeat.o(35777);
      return true;
    }
    AppMethodBeat.o(35777);
    return false;
  }
  
  public final void acquireWakeLock()
  {
    AppMethodBeat.i(35779);
    this.hlc.setKeepScreenOn(true);
    AppMethodBeat.o(35779);
  }
  
  public final boolean cU(cc paramcc)
  {
    AppMethodBeat.i(35783);
    if (paramcc.iYj())
    {
      bh.bCz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        aa.j(this.hlc.aezO.getContext(), this.hlc.aezO.getContentView());
        AppMethodBeat.o(35783);
        return true;
      }
      if (paramcc.field_msgId == this.aeyY.aeeT) {
        this.aeyY.joD();
      }
      if (!this.hlc.getTalkerUserName().equals("medianote"))
      {
        bh.bCz();
        com.tencent.mm.model.c.bzz().d(new com.tencent.mm.ay.f(paramcc.field_talker, paramcc.field_msgSvrId));
      }
      an.co(paramcc);
      AppMethodBeat.o(35783);
      return true;
    }
    AppMethodBeat.o(35783);
    return false;
  }
  
  public final boolean db(cc paramcc)
  {
    AppMethodBeat.i(35782);
    if (paramcc.iYj())
    {
      if (paramcc.field_msgId == this.aeyY.aeeT) {
        this.aeyY.joD();
      }
      AppMethodBeat.o(35782);
      return true;
    }
    AppMethodBeat.o(35782);
    return false;
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35787);
    juu();
    AppMethodBeat.o(35787);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35788);
    bh.aZW().a(127, this);
    this.aezm.alive();
    this.aezn.alive();
    this.aezf = false;
    juy();
    AppMethodBeat.o(35788);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(35789);
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay looper[%s]", new Object[] { Looper.myLooper() });
    this.aeyZ = true;
    long l = System.currentTimeMillis();
    Object localObject;
    if (!this.aezd)
    {
      Log.i("MicroMsg.ChattingUI.VoiceComponent", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", new Object[] { this.aeyY, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper() });
      if (this.aeyY != null) {
        break label399;
      }
      this.aeyY = new d(this.hlc, this, this.hlc.getTalkerUserName());
      t.c(this.aeyY);
      com.tencent.mm.modelvoice.e.a(this.aeyY);
      bh.bCz();
      bool = Util.nullAs((Boolean)com.tencent.mm.model.c.ban().d(16387, null), true);
      localObject = this.aeyY;
      if (!((d)localObject).aefb)
      {
        ((d)localObject).auto = bool;
        ((d)localObject).joz();
      }
      localObject = ((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqS();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.api.c)localObject).dO(false);
        if (localObject != null)
        {
          if (((c.b)localObject).hcG != null)
          {
            if (((c.b)localObject).hcG.optInt("AudioPlayType", 0) != 1) {
              break label416;
            }
            bool = true;
            label234:
            ((c.b)localObject).hcW = bool;
          }
          if (((c.b)localObject).hcW) {
            this.aeyY.aefa = false;
          }
        }
      }
      localObject = this.aeyY;
      if (this.xCS) {
        break label421;
      }
    }
    label399:
    label416:
    label421:
    for (boolean bool = true;; bool = false)
    {
      ((d)localObject).LT(bool);
      this.aeyY.bN(true, false);
      Log.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay end take[%s]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if ((au.bwn(this.hlc.getTalkerUserName())) && (az.a.okS != null)) {
        az.a.okS.a(this.SIW);
      }
      if (!b.bKI()) {
        ((com.tencent.mm.ui.chatting.component.api.x)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.x.class)).setVoiceInputShowCallback(this.aezp);
      }
      juu();
      AppForegroundDelegate.heY.b(this.aeze);
      localObject = com.tencent.mm.ui.tools.x.afLD;
      com.tencent.mm.ui.tools.x.Nb(true);
      AppMethodBeat.o(35789);
      return;
      this.aeyY.bAx(this.hlc.getTalkerUserName());
      break;
      bool = false;
      break label234;
    }
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35790);
    doPause();
    AppMethodBeat.o(35790);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35791);
    bh.aZW().b(127, this);
    if (this.aezl != null) {
      this.aezl.cancel(true);
    }
    this.aezm.dead();
    this.aezn.dead();
    this.aezc.clear();
    AppMethodBeat.o(35791);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35785);
    super.jqF();
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "doDestroy, autoPlay:%s", new Object[] { this.aeyY });
    t.b(this.aeyY);
    com.tencent.mm.modelvoice.e.b(this.aeyY);
    bh.aZW().b(127, this);
    releaseWakeLock();
    if (this.aeyY != null)
    {
      this.aeyY.joz();
      localObject = this.aeyY;
      ((d)localObject).release();
      ((d)localObject).xCQ.unInit();
      ((d)localObject).context = null;
      ((d)localObject).aefb = false;
      ((d)localObject).aefh.dead();
      bh.aDI().b((com.tencent.mm.model.aq)localObject);
      this.aeyY = null;
    }
    Object localObject = com.tencent.mm.am.a.otm;
    com.tencent.mm.am.a.LV("VoiceComponent_playUploadVoiceSound");
    this.aezq.dead();
    AppMethodBeat.o(35785);
  }
  
  public final d jut()
  {
    return this.aeyY;
  }
  
  public final void juu()
  {
    AppMethodBeat.i(35778);
    ad localad = (ad)this.hlc.cm(ad.class);
    Object localObject = (n)this.hlc.cm(n.class);
    com.tencent.mm.ui.chatting.component.api.ap localap = (com.tencent.mm.ui.chatting.component.api.ap)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ap.class);
    if ((((n)localObject).jrJ()) || (localap.jtm()))
    {
      Log.d("MicroMsg.ChattingUI.VoiceComponent", "trigger title icon, in show mode");
      this.hlc.Mg(false);
      localad.setTitlePhoneIconVisibility(8);
      localad.setTitleMuteIconVisibility(8);
      AppMethodBeat.o(35778);
      return;
    }
    if (aGe())
    {
      localad.setTitleMuteIconVisibility(0);
      bh.bCz();
      localObject = (Boolean)com.tencent.mm.model.c.ban().d(26, null);
      if (localObject != null) {
        break label205;
      }
      this.xCS = false;
      label148:
      Log.printInfoStack("MicroMsg.ChattingUI.VoiceComponent", "triggerTitleIcon and setForceSpeakOff value is %s", new Object[] { Boolean.valueOf(this.xCS) });
      if (!this.xCS) {
        break label216;
      }
    }
    label205:
    label216:
    for (int i = 0;; i = 8)
    {
      localad.setTitlePhoneIconVisibility(i);
      AppMethodBeat.o(35778);
      return;
      localad.setTitleMuteIconVisibility(8);
      break;
      this.xCS = ((Boolean)localObject).booleanValue();
      break label148;
    }
  }
  
  public final boolean juv()
  {
    return this.xCS;
  }
  
  public final void juw()
  {
    this.aeza = 0L;
  }
  
  public final void jux()
  {
    AppMethodBeat.i(256458);
    this.aezi = true;
    juy();
    AppMethodBeat.o(256458);
  }
  
  public final void juy()
  {
    AppMethodBeat.i(256515);
    if (((com.tencent.mm.ui.chatting.component.api.ap)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ap.class)).jtm())
    {
      AppMethodBeat.o(256515);
      return;
    }
    final m localm = (m)this.hlc.cm(m.class);
    final SparseArray localSparseArray = localm.jqi();
    if (localSparseArray != null) {
      this.aezl = com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256211);
          Log.d("MicroMsg.ChattingUI.VoiceComponent", "showVoiceFastTransTextBt lastScrollState:%s", new Object[] { bt.l(bt.this) });
          long l = bt.m(bt.this);
          bt.a(bt.this, -1L);
          int j = bt.n(bt.this);
          bt.o(bt.this).clear();
          int i = localSparseArray.size() - 1;
          Object localObject1 = null;
          Object localObject2;
          Object localObject3;
          if (i >= 0)
          {
            localObject2 = (cc)localSparseArray.get(i);
            localObject3 = bt.a(bt.this, localm, (cc)localObject2, j);
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
              localObject1 = ((fi)localObject2).field_msgId + "_" + Util.secPrint(((fi)localObject2).field_content);
              Log.i("MicroMsg.ChattingUI.VoiceComponent", "showVoiceFastTransTextBt msg:%s", new Object[] { localObject1 });
              if (localObject2 == null) {
                break label472;
              }
              localObject1 = localm.ht(((fi)localObject2).field_msgId);
              if (localObject1 == null) {
                break label472;
              }
              localObject1 = (RelativeLayout)((View)localObject1).findViewById(R.h.fyk);
              if (localObject1 != null) {
                bt.a(bt.this, ((fi)localObject2).field_msgId);
              }
            }
            for (;;)
            {
              if ((l != 0L) && ((localObject2 == null) || (l != ((fi)localObject2).field_msgId)))
              {
                localObject2 = localm.ht(l);
                if (localObject2 != null)
                {
                  localObject2 = (RelativeLayout)((View)localObject2).findViewById(R.h.fyk);
                  if (localObject2 != null) {
                    bt.o(bt.this).add(new WeakReference(localObject2));
                  }
                }
              }
              localObject2 = bt.o(bt.this).iterator();
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
                if (l != bt.m(bt.this)) {
                  bl.a.bq(1, bt.m(bt.this));
                }
              }
              AppMethodBeat.o(256211);
              return;
              localObject1 = null;
            }
          }
        }
      });
    }
    AppMethodBeat.o(256515);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35786);
    AppMethodBeat.o(35786);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(35792);
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramp.getType());
    this.hlc.aDM();
    if (!this.hlc.ffv)
    {
      Log.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35792);
      return;
    }
    if (!Util.isTopActivity(this.hlc.aezO.getContext()))
    {
      AppMethodBeat.o(35792);
      return;
    }
    Activity localActivity = this.hlc.aezO.getContext();
    int i;
    if (ae.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
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
      switch (paramp.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35792);
      return;
      paramString = com.tencent.mm.modelvoice.s.QQ(((com.tencent.mm.modelvoice.f)paramp).fileName);
      if ((paramString != null) && (paramString.status == 99))
      {
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ztA, 1) == 1) {}
        for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
        {
          Log.i("MicroMsg.ChattingUI.VoiceComponent", "async playUploadVoiceSound");
          paramString = com.tencent.mm.am.a.otm;
          com.tencent.mm.am.a.k("VoiceComponent_playUploadVoiceSound", new kotlin.g.a.a() {});
          AppMethodBeat.o(35792);
          return;
        }
        Log.i("MicroMsg.ChattingUI.VoiceComponent", "sync playUploadVoiceSound");
        PlaySound.play(this.hlc.aezO.getContext(), R.l.after_upload_voice);
      }
    }
  }
  
  public final void onScroll(AbsListView arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(256505);
    if (paramInt2 == 0)
    {
      Log.w("MicroMsg.ChattingUI.VoiceComponent", "onScroll visibleItemCount == 0");
      AppMethodBeat.o(256505);
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.aezj != -1L) && (l - this.aezj > 2000L)) {
      this.aezi = false;
    }
    this.aezj = l;
    Object localObject1 = (m)this.hlc.cm(m.class);
    ??? = new bt.a();
    int i = this.hlc.joT();
    cc localcc = ((m)localObject1).aBV(paramInt1 - i);
    if (localcc != null) {
      ???.aezz = localcc.field_msgId;
    }
    for (;;)
    {
      int j = paramInt1 - i + paramInt2 + 2;
      i = j;
      if (j > ((m)localObject1).getCount() - 1) {
        i = ((m)localObject1).getCount() - 1;
      }
      localObject1 = ((m)localObject1).aBV(i);
      if (localObject1 != null) {
        ???.aezA = ((fi)localObject1).field_msgId;
      }
      this.aezk = ???;
      Log.d("MicroMsg.ChattingUI.VoiceComponent", "onScroll firstVisibleItem:%s visibleItemCount:%s totalItemCount:%s isNoSmoothScrool:%s ifScroll:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.aezi), Boolean.valueOf(this.aezg) });
      if (!this.aezg) {
        break;
      }
      this.aezi = false;
      if (this.dBj != null) {
        this.dBj.cancel(true);
      }
      this.dBj = com.tencent.threadpool.h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256229);
          synchronized (bt.juA())
          {
            if (bt.j(bt.this))
            {
              AppMethodBeat.o(256229);
              return;
            }
            bt.this.juy();
            bt.k(bt.this);
            AppMethodBeat.o(256229);
            return;
          }
        }
      }, 300L);
      AppMethodBeat.o(256505);
      return;
      localcc = ((m)localObject1).aBV(paramInt1 + 1 - i);
      if (localcc != null) {
        ???.aezz = localcc.field_msgId;
      }
    }
    synchronized (lock)
    {
      if (this.aezf)
      {
        this.aezi = false;
        AppMethodBeat.o(256505);
        return;
      }
      if (this.aezi)
      {
        this.aezi = false;
        AppMethodBeat.o(256505);
        return;
      }
    }
    this.aezi = true;
    juy();
    AppMethodBeat.o(256505);
  }
  
  public final void onScrollStateChanged(AbsListView arg1, int paramInt)
  {
    AppMethodBeat.i(256498);
    super.onScrollStateChanged(???, paramInt);
    Log.i("MicroMsg.ChattingUI.VoiceComponent", "onScrollStateChanged %s", new Object[] { Integer.valueOf(paramInt) });
    this.aezi = false;
    if (paramInt == 0)
    {
      this.aezg = false;
      synchronized (lock)
      {
        if (this.aezf)
        {
          AppMethodBeat.o(256498);
          return;
        }
        juy();
        AppMethodBeat.o(256498);
        return;
      }
    }
    this.aezg = true;
    AppMethodBeat.o(256498);
  }
  
  public final void releaseWakeLock()
  {
    AppMethodBeat.i(35780);
    this.hlc.setKeepScreenOn(false);
    if ((this.aeyY != null) && (this.aezd))
    {
      this.aezd = false;
      this.aeyY.joz();
      this.aeyY.joD();
      this.aeyY.release();
    }
    AppForegroundDelegate.heY.b(this.aeze);
    this.aezd = false;
    AppMethodBeat.o(35780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bt
 * JD-Core Version:    0.7.0.1
 */