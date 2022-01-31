package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.model.l;
import com.tencent.mm.plugin.setting.model.l.1;
import com.tencent.mm.plugin.setting.model.l.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.RealAlphabetScrollBar;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.b;>;

public class UnfamiliarContactDetailUI
  extends MMActivity
  implements f
{
  public static final String ejM;
  private com.tencent.mm.ui.base.p ehb;
  private ArrayList<UnfamiliarContactDetailUI.b> hXv;
  private boolean qEM;
  private boolean qEN;
  private boolean qEO;
  private RecyclerView qKR;
  private TextView qKS;
  private View qKT;
  private View qKU;
  private View qKV;
  private View qKW;
  private TextView qKX;
  private UnfamiliarContactDetailUI.a qKY;
  private RealAlphabetScrollBar qKZ;
  HashMap<String, Integer> qLa;
  private HashMap<Integer, String> qLb;
  private HashSet<Integer> qLc;
  private UnfamiliarContactDetailUI.d qLd;
  private int qLe;
  private HashSet<String> qLf;
  private l qLg;
  private boolean qLh;
  
  static
  {
    AppMethodBeat.i(127683);
    ejM = new String(Character.toChars(123));
    AppMethodBeat.o(127683);
  }
  
  public UnfamiliarContactDetailUI()
  {
    AppMethodBeat.i(127669);
    this.qLa = new HashMap();
    this.qLb = new HashMap();
    this.hXv = new ArrayList();
    this.qLc = new HashSet();
    this.qLe = -1;
    this.qLf = new HashSet();
    this.ehb = null;
    AppMethodBeat.o(127669);
  }
  
  private void cW(List<UnfamiliarContactDetailUI.b> paramList)
  {
    AppMethodBeat.i(127676);
    this.qLa.clear();
    this.qLb.clear();
    int i = 0;
    Iterator localIterator = paramList.iterator();
    Object localObject;
    for (paramList = null; localIterator.hasNext(); paramList = (List<UnfamiliarContactDetailUI.b>)localObject)
    {
      localObject = (UnfamiliarContactDetailUI.b)localIterator.next();
      if (ejM.equalsIgnoreCase(((UnfamiliarContactDetailUI.b)localObject).qLo)) {
        ((UnfamiliarContactDetailUI.b)localObject).qLo = "#";
      }
      localObject = ((UnfamiliarContactDetailUI.b)localObject).qLo;
      if (!((String)localObject).equalsIgnoreCase(paramList))
      {
        this.qLa.put(((String)localObject).toUpperCase(), Integer.valueOf(i));
        this.qLb.put(Integer.valueOf(i), ((String)localObject).toUpperCase());
      }
      i += 1;
    }
    AppMethodBeat.o(127676);
  }
  
  private void fV(boolean paramBoolean)
  {
    AppMethodBeat.i(127677);
    ab.i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.ehb = com.tencent.mm.ui.base.p.b(this, getString(2131304412), true, null);
      AppMethodBeat.o(127677);
      return;
    }
    if ((this.ehb != null) && (this.ehb.isShowing()))
    {
      this.ehb.dismiss();
      this.ehb = null;
    }
    AppMethodBeat.o(127677);
  }
  
  public int getLayoutId()
  {
    return 2130970707;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(127673);
    super.initView();
    setMMTitle(2131303501);
    addTextOptionMenu(1, getString(2131304415), new UnfamiliarContactDetailUI.1(this));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(127637);
        UnfamiliarContactDetailUI.this.finish();
        AppMethodBeat.o(127637);
        return true;
      }
    });
    View localView = findViewById(2131827676);
    if (this.qEM)
    {
      i = 0;
      localView.setVisibility(i);
      localView = findViewById(2131827677);
      if (!this.qEO) {
        break label351;
      }
      i = 0;
      label90:
      localView.setVisibility(i);
      localView = findViewById(2131827678);
      if (!this.qEN) {
        break label357;
      }
    }
    label351:
    label357:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      this.qKR = ((RecyclerView)findViewById(2131827680));
      this.qKT = findViewById(2131823738);
      this.qKS = ((TextView)findViewById(2131827675));
      this.qLd = new UnfamiliarContactDetailUI.d(this, this.qLc, new UnfamiliarContactDetailUI.6(this));
      this.qKU = findViewById(2131827684);
      this.qKU.setOnClickListener(new UnfamiliarContactDetailUI.7(this));
      this.qKV = findViewById(2131827683);
      this.qKV.setOnClickListener(new UnfamiliarContactDetailUI.8(this));
      this.qKW = findViewById(2131827682);
      this.qKW.setOnClickListener(new UnfamiliarContactDetailUI.9(this));
      this.qKX = ((TextView)findViewById(2131821071));
      this.qKR.setLayoutManager(new LinearLayoutManager());
      this.qKY = new UnfamiliarContactDetailUI.a(this);
      this.qKR.setAdapter(this.qKY);
      this.qKZ = ((RealAlphabetScrollBar)findViewById(2131827681));
      this.qKZ.setOnScrollBarTouchListener(new UnfamiliarContactDetailUI.10(this));
      AppMethodBeat.o(127673);
      return;
      i = 8;
      break;
      i = 8;
      break label90;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127670);
    super.onCreate(paramBundle);
    g.Rc().a(291, this);
    this.qEM = getIntent().getBooleanExtra("half_year_not_chat", false);
    this.qEN = getIntent().getBooleanExtra("half_year_not_response", false);
    this.qEO = getIntent().getBooleanExtra("has_not_same_chatroom", false);
    initView();
    paramBundle = new UnfamiliarContactDetailUI.11(this);
    this.qLg = new l(this.qEM, this.qEN, this.qEO, paramBundle);
    paramBundle = this.qLg;
    paramBundle.qEW = System.currentTimeMillis();
    paramBundle.qEV.a(UnfamiliarContactDetailUI.e.qLD);
    paramBundle.eIo.ac(new l.1(paramBundle));
    AppMethodBeat.o(127670);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127672);
    super.onDestroy();
    int i;
    int j;
    if (this.qEM)
    {
      i = 1;
      if (!this.qEO) {
        break label357;
      }
      j = 2;
      label28:
      if (!this.qEN) {
        break label362;
      }
    }
    label357:
    label362:
    for (int k = 4;; k = 0)
    {
      i = k | j | i;
      h.qsU.e(14434, new Object[] { Integer.valueOf(i), Integer.valueOf(f.qLG), Integer.valueOf(f.qLF), Integer.valueOf(f.qLK), Integer.valueOf(f.qLH), Integer.valueOf(f.qLJ), Integer.valueOf(f.qLI) });
      ab.i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(f.qLG), Integer.valueOf(f.qLF), Integer.valueOf(f.qLK), Integer.valueOf(f.qLH), Integer.valueOf(f.qLJ), Integer.valueOf(f.qLI) });
      f.qLF = 0;
      f.qLG = 0;
      f.qLH = 0;
      f.qLI = 0;
      f.qLJ = 0;
      f.qLK = 0;
      g.Rc().b(291, this);
      g.Rc().b(681, this.qLd);
      l locall = this.qLg;
      ab.i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", new Object[] { Boolean.valueOf(locall.qEN), Boolean.valueOf(locall.qEM), Boolean.valueOf(locall.qEO) });
      if (locall.qEU != null)
      {
        l.a locala = locall.qEU;
        g.Rc().b(292, locala);
      }
      d.ysm.remove(locall.mRunnable);
      locall.eIo.oNc.quit();
      AppMethodBeat.o(127672);
      return;
      i = 0;
      break;
      j = 0;
      break label28;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(127674);
    if (paramInt == 4)
    {
      onBackPressed();
      AppMethodBeat.o(127674);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(127674);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127671);
    super.onResume();
    int i;
    if (-1 != this.qLe)
    {
      if (-1 != this.qLe) {
        break label76;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        f.qLG += 1;
      }
      this.qLe = -1;
      this.qLf.clear();
      if (this.qKY != null) {
        this.qKY.ajb.notifyChanged();
      }
      AppMethodBeat.o(127671);
      return;
      label76:
      UnfamiliarContactDetailUI.b localb = (UnfamiliarContactDetailUI.b)this.hXv.get(this.qLe);
      ad localad1 = localb.contact;
      ad localad2 = ((j)g.E(j.class)).YA().arw(localad1.field_username);
      if ((!com.tencent.mm.n.a.je(localad2.field_type)) && (com.tencent.mm.n.a.je(localad1.field_type)))
      {
        this.hXv.remove(this.qLe);
        i = 1;
      }
      else
      {
        localb.contact = localad2;
        i = 0;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(127675);
    ab.i("MicroMsg.UnfamiliarContactUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramm.getType());
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this, getString(2131304417), 1).show();
    }
    if (paramm.getType() == 291)
    {
      fV(false);
      this.qLf.clear();
      this.qKY.ajb.notifyChanged();
    }
    AppMethodBeat.o(127675);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class f
  {
    static int qLF;
    static int qLG;
    static int qLH;
    static int qLI;
    static int qLJ;
    static int qLK;
  }
  
  public static abstract interface h
  {
    public abstract void a(UnfamiliarContactDetailUI.e parame);
    
    public abstract void e(HashSet paramHashSet);
    
    public abstract void onError();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI
 * JD-Core Version:    0.7.0.1
 */