package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tl.b;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.g.a.uw.a;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.network.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.b.d;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class NormalUserFooterPreference
  extends Preference
  implements k.a
{
  private MMActivity cmc;
  private ad contact;
  public ProgressDialog eeN;
  protected l<NormalUserFooterPreference.e, String> frK;
  private int gyR;
  private String jMG;
  private boolean lJS;
  private String mVw;
  private Button oxn;
  private long pAI;
  private int pAe;
  private String pAm;
  private boolean pAr;
  private boolean pBI;
  private boolean pBJ;
  private boolean pBK;
  private boolean pBL;
  private NormalUserFooterPreference.a pBM;
  private View pBN;
  private Button pBO;
  private Button pBP;
  private Button pBQ;
  private View pBR;
  private Button pBS;
  private TextView pBT;
  private View pBU;
  private Button pBV;
  private Button pBW;
  private Button pBX;
  private Button pBY;
  private Button pBZ;
  private Button pCa;
  private TextView pCb;
  private boolean pCc;
  public boolean pCd;
  private boolean pxJ;
  private boolean pyp;
  private int pzM;
  
  public NormalUserFooterPreference(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(23733);
    this.pxJ = false;
    this.pAI = 0L;
    this.pAm = "";
    this.mVw = "";
    this.pAr = false;
    this.pBK = false;
    this.pBL = false;
    this.pCc = false;
    this.pzM = 0;
    this.eeN = null;
    this.pCd = false;
    this.jMG = null;
    this.frK = new NormalUserFooterPreference.1(this);
    this.cmc = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(23733);
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23734);
    this.pxJ = false;
    this.pAI = 0L;
    this.pAm = "";
    this.mVw = "";
    this.pAr = false;
    this.pBK = false;
    this.pBL = false;
    this.pCc = false;
    this.pzM = 0;
    this.eeN = null;
    this.pCd = false;
    this.jMG = null;
    this.frK = new NormalUserFooterPreference.1(this);
    this.cmc = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(23734);
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23735);
    this.pxJ = false;
    this.pAI = 0L;
    this.pAm = "";
    this.mVw = "";
    this.pAr = false;
    this.pBK = false;
    this.pBL = false;
    this.pCc = false;
    this.pzM = 0;
    this.eeN = null;
    this.pCd = false;
    this.jMG = null;
    this.frK = new NormalUserFooterPreference.1(this);
    this.cmc = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(23735);
  }
  
  private void init()
  {
    this.lJS = false;
    this.pBM = null;
  }
  
  private void initView()
  {
    AppMethodBeat.i(23736);
    if ((!this.lJS) || (this.contact == null))
    {
      ab.w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.lJS + " contact = " + this.contact);
      if (this.pBM != null) {
        try
        {
          this.pBM.ccz();
          AppMethodBeat.o(23736);
          return;
        }
        catch (Throwable localThrowable) {}
      }
      AppMethodBeat.o(23736);
      return;
    }
    if (this.pBM != null) {
      this.pBM.Yj();
    }
    ccu();
    AppMethodBeat.o(23736);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(23741);
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(23741);
      return;
    }
    if ((this.contact != null) && ((paramString.equals(this.contact.field_username)) || (paramString.equals(this.contact.field_encryptUsername))))
    {
      aw.aaz();
      this.contact = com.tencent.mm.model.c.YA().arw(this.contact.field_username);
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23671);
          NormalUserFooterPreference.this.ccu();
          AppMethodBeat.o(23671);
        }
      });
    }
    AppMethodBeat.o(23741);
  }
  
  public final boolean a(ad paramad, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2, boolean paramBoolean4, boolean paramBoolean5, long paramLong, String paramString2)
  {
    AppMethodBeat.i(23738);
    bkb();
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bo.nullAsNil(paramad.field_username).length() <= 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!ad.ark(r.Zn()).equals(paramad.field_username)) {
        break label80;
      }
      AppMethodBeat.o(23738);
      return false;
      bool = false;
      break;
    }
    label80:
    this.contact = paramad;
    this.mVw = paramString1;
    this.pyp = paramBoolean1;
    this.gyR = paramInt1;
    this.pAe = paramInt2;
    this.pBJ = bo.a(Boolean.valueOf(t.nR(paramad.field_username)), false);
    this.pxJ = paramBoolean4;
    this.pBI = paramBoolean5;
    this.pAI = paramLong;
    this.pAm = paramString2;
    this.pCd = false;
    if (paramad.field_deleteFlag == 1)
    {
      paramBoolean1 = true;
      this.pAr = paramBoolean1;
      this.pCc = this.cmc.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
      this.pzM = this.cmc.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.pBK = this.cmc.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
      this.pBL = this.cmc.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
      this.jMG = this.cmc.getIntent().getStringExtra("lbs_ticket");
      if (!r.nB(paramad.field_username))
      {
        aw.aaz();
        if (!com.tencent.mm.model.c.YI().has(paramad.field_username)) {
          break label321;
        }
      }
      this.pBM = new NormalUserFooterPreference.c(this);
      this.pCd = true;
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(23738);
      return true;
      paramBoolean1 = false;
      break;
      label321:
      if (ad.arc(paramad.field_username))
      {
        this.pBM = new h();
      }
      else if (t.og(paramad.field_username))
      {
        this.pBM = new NormalUserFooterPreference.d(this);
      }
      else if (t.nR(paramad.field_username))
      {
        this.pBM = new NormalUserFooterPreference.g(this);
      }
      else if (ad.ard(paramad.field_username))
      {
        this.pBM = new NormalUserFooterPreference.f(this);
      }
      else if ((com.tencent.mm.n.a.je(paramad.field_type)) && (!ad.nM(paramad.field_username)))
      {
        this.pBM = new NormalUserFooterPreference.c(this);
        this.pCd = true;
      }
      else if (paramBoolean2)
      {
        this.pBM = new j();
        this.pCd = true;
      }
      else if ((paramBoolean3) || (ad.nM(paramad.field_username)))
      {
        this.pBM = new NormalUserFooterPreference.b(this);
      }
      else
      {
        this.pBM = new NormalUserFooterPreference.c(this);
        this.pCd = true;
      }
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(23740);
    if (this.pBM != null) {
      this.pBM.onDetach();
    }
    this.frK.removeAll();
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    AppMethodBeat.o(23740);
    return true;
  }
  
  public final boolean ccu()
  {
    AppMethodBeat.i(23739);
    if ((this.pCc) && (com.tencent.mm.n.a.je(this.contact.field_type)))
    {
      this.pCa.setVisibility(0);
      AppMethodBeat.o(23739);
      return true;
    }
    this.pCa.setVisibility(8);
    AppMethodBeat.o(23739);
    return false;
  }
  
  public final void ccv()
  {
    AppMethodBeat.i(23742);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.cmc, "android.permission.RECORD_AUDIO", 82, "", "");
    ab.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.cmc });
    if (!bool)
    {
      AppMethodBeat.o(23742);
      return;
    }
    ux localux = new ux();
    localux.cLs.cut = 5;
    localux.cLs.talker = this.contact.field_username;
    localux.cLs.context = this.cmc;
    localux.cLs.cLm = 4;
    com.tencent.mm.sdk.b.a.ymk.l(localux);
    AppMethodBeat.o(23742);
  }
  
  public final void ccw()
  {
    AppMethodBeat.i(23743);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.cmc, "android.permission.CAMERA", 19, "", "");
    ab.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.cmc });
    if (!bool)
    {
      AppMethodBeat.o(23743);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.cmc, "android.permission.RECORD_AUDIO", 19, "", "");
    ab.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.cmc });
    if (!bool)
    {
      AppMethodBeat.o(23743);
      return;
    }
    ux localux = new ux();
    localux.cLs.cut = 5;
    localux.cLs.talker = this.contact.field_username;
    localux.cLs.context = this.cmc;
    localux.cLs.cLm = 2;
    com.tencent.mm.sdk.b.a.ymk.l(localux);
    AppMethodBeat.o(23743);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23737);
    ab.d("MicroMsg.NormalUserFooterPreference", "on bindView " + paramView.toString());
    this.pBN = paramView.findViewById(2131823083);
    this.pBO = ((Button)paramView.findViewById(2131823084));
    this.pBP = ((Button)paramView.findViewById(2131823091));
    this.pBS = ((Button)paramView.findViewById(2131823087));
    this.pBT = ((TextView)paramView.findViewById(2131823098));
    this.pBR = paramView.findViewById(2131823086);
    this.pBQ = ((Button)paramView.findViewById(2131823085));
    this.pBX = ((Button)paramView.findViewById(2131823092));
    this.pBU = paramView.findViewById(2131823088);
    this.pBV = ((Button)paramView.findViewById(2131823090));
    this.pBW = ((Button)paramView.findViewById(2131823089));
    this.oxn = ((Button)paramView.findViewById(2131823093));
    this.pCa = ((Button)paramView.findViewById(2131823096));
    this.pBY = ((Button)paramView.findViewById(2131823094));
    this.pBZ = ((Button)paramView.findViewById(2131823095));
    this.pCb = ((TextView)paramView.findViewById(2131823097));
    this.lJS = true;
    initView();
    super.onBindView(paramView);
    if ((this.cmc.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) == true) && (this.pBO != null)) {
      this.pBO.performClick();
    }
    AppMethodBeat.o(23737);
  }
  
  final class h
    extends NormalUserFooterPreference.a
  {
    public h()
    {
      super();
    }
    
    protected final void ccx()
    {
      AppMethodBeat.i(23715);
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
      if ((!NormalUserFooterPreference.this.ccu()) && (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(r.Zn())) && (!t.oD(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!t.ow(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))) {
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
      }
      for (;;)
      {
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setText(2131298746);
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(8);
        AppMethodBeat.o(23715);
        return;
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
      }
    }
    
    protected final void ccz() {}
  }
  
  class i
    extends NormalUserFooterPreference.c
    implements f
  {
    private ProgressDialog eeN;
    
    public i()
    {
      super();
    }
    
    private void Nx()
    {
      AppMethodBeat.i(23722);
      NormalUserFooterPreference localNormalUserFooterPreference = NormalUserFooterPreference.this;
      aw.aaz();
      ad localad2 = com.tencent.mm.model.c.YA().arw(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      if (localad2 != null)
      {
        localad1 = localad2;
        if ((int)localad2.euF != 0) {}
      }
      else
      {
        localad1 = NormalUserFooterPreference.a(NormalUserFooterPreference.this);
        aw.aaz();
        if (com.tencent.mm.model.c.YA().X(localad1)) {
          break label131;
        }
        ab.e("MicroMsg.NormalUserFooterPreference", "insert contact failed, username = " + localad1.field_username);
      }
      for (ad localad1 = null;; localad1 = com.tencent.mm.model.c.YA().arw(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
      {
        NormalUserFooterPreference.a(localNormalUserFooterPreference, localad1);
        if (NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) {
          t.q(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
        }
        AppMethodBeat.o(23722);
        return;
        label131:
        aw.aaz();
      }
    }
    
    protected void ccE()
    {
      AppMethodBeat.i(23723);
      if (NormalUserFooterPreference.u(NormalUserFooterPreference.this) != null) {
        NormalUserFooterPreference.u(NormalUserFooterPreference.this).onDetach();
      }
      NormalUserFooterPreference.a(NormalUserFooterPreference.this, new NormalUserFooterPreference.c(NormalUserFooterPreference.this));
      NormalUserFooterPreference.u(NormalUserFooterPreference.this).Yj();
      AppMethodBeat.o(23723);
    }
    
    protected void ccx()
    {
      AppMethodBeat.i(23719);
      onDetach();
      onStop();
      aw.Rc().a(30, this);
      aw.Rc().a(667, this);
      aw.Rc().a(853, this);
      super.ccx();
      AppMethodBeat.o(23719);
    }
    
    protected void onDetach()
    {
      AppMethodBeat.i(23721);
      if (this.eeN != null)
      {
        this.eeN.dismiss();
        this.eeN = null;
      }
      if (NormalUserFooterPreference.r(NormalUserFooterPreference.this) != null) {
        NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      }
      if (NormalUserFooterPreference.s(NormalUserFooterPreference.this) != null) {
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(0);
      }
      if (NormalUserFooterPreference.f(NormalUserFooterPreference.this) != null) {
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(8);
      }
      if (NormalUserFooterPreference.g(NormalUserFooterPreference.this) != null) {
        NormalUserFooterPreference.g(NormalUserFooterPreference.this).setVisibility(8);
      }
      if (NormalUserFooterPreference.h(NormalUserFooterPreference.this) != null) {
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
      }
      if (NormalUserFooterPreference.t(NormalUserFooterPreference.this) != null) {
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
      }
      if (NormalUserFooterPreference.q(NormalUserFooterPreference.this) != null) {
        NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(8);
      }
      onStop();
      AppMethodBeat.o(23721);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
    {
      int j = 0;
      AppMethodBeat.i(23724);
      ab.d("MicroMsg.NormalUserFooterPreference", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      if ((paramm.getType() != 30) && (paramm.getType() != 667) && (paramm.getType() != 853))
      {
        AppMethodBeat.o(23724);
        return;
      }
      onStop();
      if (this.eeN != null)
      {
        this.eeN.dismiss();
        this.eeN = null;
      }
      if (!bo.cB(NormalUserFooterPreference.this.mContext))
      {
        AppMethodBeat.o(23724);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramm.getType() == 30)
        {
          paramInt1 = ((com.tencent.mm.pluginsdk.model.m)paramm).cut;
          ab.d("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, opCode = ".concat(String.valueOf(paramInt1)));
          if ((paramInt1 == 1) || (paramInt1 == 3))
          {
            paramString = ((com.tencent.mm.pluginsdk.model.m)paramm).vKs;
            if ((paramString != null) && (paramString.contains(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)))
            {
              NormalUserFooterPreference.v(NormalUserFooterPreference.this);
              Nx();
              ccE();
              paramString = paramString.iterator();
              while (paramString.hasNext()) {
                com.tencent.mm.pluginsdk.ui.preference.b.bI((String)paramString.next(), NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              }
              aw.getNotification().IG();
            }
          }
          AppMethodBeat.o(23724);
          return;
        }
        if ((paramm.getType() == 667) || (paramm.getType() == 853))
        {
          NormalUserFooterPreference.v(NormalUserFooterPreference.this);
          Nx();
          ccE();
          com.tencent.mm.pluginsdk.ui.preference.b.bI(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, NormalUserFooterPreference.l(NormalUserFooterPreference.this));
          aw.getNotification().IG();
          AppMethodBeat.o(23724);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -302)) {
        if (paramm.getType() != 30) {
          break label878;
        }
      }
      label878:
      for (paramInt1 = ((com.tencent.mm.pluginsdk.model.m)paramm).cut;; paramInt1 = 0)
      {
        ab.w("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", new Object[] { Integer.valueOf(paramInt1) });
        if ((paramInt1 == 3) || (paramm.getType() == 853)) {
          com.tencent.mm.ui.base.h.d(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131298826), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131297087), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131296537), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131296888), new NormalUserFooterPreference.i.3(this), null);
        }
        AppMethodBeat.o(23724);
        return;
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!bo.isNullOrNil(paramString)))
        {
          Toast.makeText(NormalUserFooterPreference.b(NormalUserFooterPreference.this), paramString, 1).show();
          AppMethodBeat.o(23724);
          return;
        }
        int i = j;
        switch (paramInt1)
        {
        default: 
          i = j;
        }
        while (i != 0)
        {
          AppMethodBeat.o(23724);
          return;
          if (aw.Rc().adu())
          {
            aw.Rc().getNetworkServerIp();
            new StringBuilder().append(paramInt2);
            i = 1;
          }
          else
          {
            i = j;
            if (ac.cm(NormalUserFooterPreference.this.mContext))
            {
              com.tencent.mm.pluginsdk.ui.tools.h.fY(NormalUserFooterPreference.this.mContext);
              i = 1;
              continue;
              Toast.makeText(NormalUserFooterPreference.this.mContext, NormalUserFooterPreference.this.mContext.getString(2131300044, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
              i = 1;
              continue;
              if (paramInt2 == -100)
              {
                com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, aw.QD(), com.tencent.mm.cb.a.aq(NormalUserFooterPreference.this.mContext, 2131297087), new DialogInterface.OnClickListener()new NormalUserFooterPreference.i.2
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(23716);
                    NormalUserFooterPreference.i.this.onStop();
                    paramAnonymousDialogInterface = new Intent();
                    paramAnonymousDialogInterface.putExtra("Intro_Switch", true).addFlags(67108864);
                    com.tencent.mm.plugin.profile.b.gmO.p(paramAnonymousDialogInterface, NormalUserFooterPreference.this.mContext);
                    AppMethodBeat.o(23716);
                  }
                }, new NormalUserFooterPreference.i.2(this));
                i = 1;
              }
              else
              {
                if ((paramInt1 == 4) && (paramInt2 == -34)) {
                  paramm = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131300013);
                }
                for (;;)
                {
                  Toast.makeText(NormalUserFooterPreference.b(NormalUserFooterPreference.this), paramm, 1).show();
                  i = j;
                  break;
                  if ((paramInt1 == 4) && (paramInt2 == -94))
                  {
                    paramm = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131300016);
                  }
                  else if (paramInt1 == 4)
                  {
                    paramm = paramString;
                    if (!bo.isNullOrNil(paramString)) {}
                  }
                  else
                  {
                    paramm = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131303126);
                  }
                }
              }
            }
          }
        }
        AppMethodBeat.o(23724);
        return;
      }
    }
    
    final void onStop()
    {
      AppMethodBeat.i(23720);
      aw.Rc().b(30, this);
      aw.Rc().b(667, this);
      aw.Rc().b(853, this);
      AppMethodBeat.o(23720);
    }
  }
  
  final class j
    extends NormalUserFooterPreference.i
    implements f
  {
    public j()
    {
      super();
    }
    
    protected final void ccE()
    {
      AppMethodBeat.i(23731);
      super.ccE();
      AppMethodBeat.o(23731);
    }
    
    protected final void ccx()
    {
      AppMethodBeat.i(23729);
      super.ccx();
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(0);
      NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.g(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.k(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.i(NormalUserFooterPreference.this).setVisibility(0);
      NormalUserFooterPreference.w(NormalUserFooterPreference.this).setVisibility(0);
      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).NW())
      {
        NormalUserFooterPreference.x(NormalUserFooterPreference.this).setText(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131298680));
        NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(0);
      }
      for (;;)
      {
        NormalUserFooterPreference.z(NormalUserFooterPreference.this).setOnClickListener(new NormalUserFooterPreference.j.1(this));
        NormalUserFooterPreference.x(NormalUserFooterPreference.this).setOnClickListener(new NormalUserFooterPreference.j.2(this));
        AppMethodBeat.o(23729);
        return;
        NormalUserFooterPreference.x(NormalUserFooterPreference.this).setText(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131298675));
      }
    }
    
    protected final void ccz()
    {
      AppMethodBeat.i(23728);
      if ((NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) && (com.tencent.mm.n.a.je(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)))
      {
        ccy();
        AppMethodBeat.o(23728);
        return;
      }
      F(false, true);
      AppMethodBeat.o(23728);
    }
    
    protected final void onDetach()
    {
      AppMethodBeat.i(23730);
      super.onDetach();
      AppMethodBeat.o(23730);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
    {
      AppMethodBeat.i(23732);
      super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
      AppMethodBeat.o(23732);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference
 * JD-Core Version:    0.7.0.1
 */