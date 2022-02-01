package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vt.b;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.a.xg.a;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.b.a.cu;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.network.ae;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class NormalUserFooterPreference
  extends Preference
  implements k.a
{
  private ai contact;
  private Button fTu;
  public ProgressDialog fts;
  protected com.tencent.mm.sdk.e.l<e, String> huf;
  private MMActivity iMV;
  private int iMg;
  private String nnS;
  private boolean pDN;
  private String sBi;
  private boolean vIS;
  private boolean vIm;
  private int vKF;
  private String vKN;
  private boolean vKS;
  private int vKo;
  private long vLk;
  private TextView vMA;
  private boolean vMB;
  public boolean vMC;
  private boolean vMh;
  private boolean vMi;
  private boolean vMj;
  private boolean vMk;
  private a vMl;
  private View vMm;
  private Button vMn;
  private Button vMo;
  private Button vMp;
  private View vMq;
  private Button vMr;
  private TextView vMs;
  private View vMt;
  private Button vMu;
  private Button vMv;
  private Button vMw;
  private Button vMx;
  private Button vMy;
  private Button vMz;
  
  public NormalUserFooterPreference(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(27352);
    this.vIm = false;
    this.vLk = 0L;
    this.vKN = "";
    this.sBi = "";
    this.vKS = false;
    this.vMj = false;
    this.vMk = false;
    this.vMB = false;
    this.vKo = 0;
    this.fts = null;
    this.vMC = false;
    this.nnS = null;
    this.huf = new com.tencent.mm.sdk.e.l() {};
    this.iMV = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27352);
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27353);
    this.vIm = false;
    this.vLk = 0L;
    this.vKN = "";
    this.sBi = "";
    this.vKS = false;
    this.vMj = false;
    this.vMk = false;
    this.vMB = false;
    this.vKo = 0;
    this.fts = null;
    this.vMC = false;
    this.nnS = null;
    this.huf = new com.tencent.mm.sdk.e.l() {};
    this.iMV = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27353);
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27354);
    this.vIm = false;
    this.vLk = 0L;
    this.vKN = "";
    this.sBi = "";
    this.vKS = false;
    this.vMj = false;
    this.vMk = false;
    this.vMB = false;
    this.vKo = 0;
    this.fts = null;
    this.vMC = false;
    this.nnS = null;
    this.huf = new com.tencent.mm.sdk.e.l() {};
    this.iMV = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27354);
  }
  
  private void init()
  {
    this.pDN = false;
    this.vMl = null;
  }
  
  private void initView()
  {
    AppMethodBeat.i(27355);
    if ((!this.pDN) || (this.contact == null))
    {
      ac.w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.pDN + " contact = " + this.contact);
      if (this.vMl != null) {
        try
        {
          this.vMl.dqy();
          AppMethodBeat.o(27355);
          return;
        }
        catch (Throwable localThrowable) {}
      }
      AppMethodBeat.o(27355);
      return;
    }
    if (this.vMl != null) {
      this.vMl.awk();
    }
    dqt();
    AppMethodBeat.o(27355);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(27360);
    if (bs.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27360);
      return;
    }
    if ((this.contact != null) && ((paramString.equals(this.contact.field_username)) || (paramString.equals(this.contact.field_encryptUsername))))
    {
      az.ayM();
      this.contact = com.tencent.mm.model.c.awB().aNt(this.contact.field_username);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27291);
          NormalUserFooterPreference.this.dqt();
          AppMethodBeat.o(27291);
        }
      });
    }
    AppMethodBeat.o(27360);
  }
  
  public final boolean a(ai paramai, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2, boolean paramBoolean4, boolean paramBoolean5, long paramLong, String paramString2)
  {
    AppMethodBeat.i(27357);
    bYJ();
    if (paramai != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bs.nullAsNil(paramai.field_username).length() <= 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!ai.aNh(u.axw()).equals(paramai.field_username)) {
        break label80;
      }
      AppMethodBeat.o(27357);
      return false;
      bool = false;
      break;
    }
    label80:
    this.contact = paramai;
    this.sBi = paramString1;
    this.vIS = paramBoolean1;
    this.iMg = paramInt1;
    this.vKF = paramInt2;
    this.vMi = bs.a(Boolean.valueOf(w.wE(paramai.field_username)), false);
    this.vIm = paramBoolean4;
    this.vMh = paramBoolean5;
    this.vLk = paramLong;
    this.vKN = paramString2;
    this.vMC = false;
    if (paramai.field_deleteFlag == 1)
    {
      paramBoolean1 = true;
      this.vKS = paramBoolean1;
      this.vMB = this.iMV.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
      this.vKo = this.iMV.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.vMj = this.iMV.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
      this.vMk = this.iMV.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
      this.nnS = this.iMV.getIntent().getStringExtra("lbs_ticket");
      if (!u.wh(paramai.field_username))
      {
        az.ayM();
        if (!com.tencent.mm.model.c.awJ().has(paramai.field_username)) {
          break label321;
        }
      }
      this.vMl = new c();
      this.vMC = true;
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(27357);
      return true;
      paramBoolean1 = false;
      break;
      label321:
      if (ai.aMZ(paramai.field_username))
      {
        this.vMl = new h();
      }
      else if (w.wT(paramai.field_username))
      {
        this.vMl = new d();
      }
      else if (w.wE(paramai.field_username))
      {
        this.vMl = new g();
      }
      else if (ai.aNa(paramai.field_username))
      {
        this.vMl = new f();
      }
      else if ((com.tencent.mm.n.b.ln(paramai.field_type)) && (!ai.ww(paramai.field_username)))
      {
        this.vMl = new c();
        this.vMC = true;
      }
      else if (paramBoolean2)
      {
        this.vMl = new j();
        this.vMC = true;
      }
      else if ((paramBoolean3) || (ai.ww(paramai.field_username)))
      {
        this.vMl = new b();
      }
      else
      {
        this.vMl = new c();
        this.vMC = true;
      }
    }
  }
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(27359);
    if (this.vMl != null) {
      this.vMl.onDetach();
    }
    this.huf.removeAll();
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    AppMethodBeat.o(27359);
    return true;
  }
  
  public final boolean dqt()
  {
    AppMethodBeat.i(27358);
    if ((this.vMB) && (com.tencent.mm.n.b.ln(this.contact.field_type)))
    {
      this.vMz.setVisibility(0);
      AppMethodBeat.o(27358);
      return true;
    }
    this.vMz.setVisibility(8);
    AppMethodBeat.o(27358);
    return false;
  }
  
  public final void dqu()
  {
    AppMethodBeat.i(27361);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.iMV, "android.permission.RECORD_AUDIO", 82, "", "");
    ac.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this.iMV });
    if (!bool)
    {
      AppMethodBeat.o(27361);
      return;
    }
    xh localxh = new xh();
    localxh.dAb.dgL = 5;
    localxh.dAb.talker = this.contact.field_username;
    localxh.dAb.context = this.iMV;
    localxh.dAb.dzX = 4;
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    AppMethodBeat.o(27361);
  }
  
  public final void dqv()
  {
    AppMethodBeat.i(27362);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.iMV, "android.permission.CAMERA", 19, "", "");
    ac.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this.iMV });
    if (!bool)
    {
      AppMethodBeat.o(27362);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.iMV, "android.permission.RECORD_AUDIO", 19, "", "");
    ac.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this.iMV });
    if (!bool)
    {
      AppMethodBeat.o(27362);
      return;
    }
    xh localxh = new xh();
    localxh.dAb.dgL = 5;
    localxh.dAb.talker = this.contact.field_username;
    localxh.dAb.context = this.iMV;
    localxh.dAb.dzX = 2;
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    AppMethodBeat.o(27362);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27356);
    ac.d("MicroMsg.NormalUserFooterPreference", "on bindView " + paramView.toString());
    this.vMm = paramView.findViewById(2131298633);
    this.vMn = ((Button)paramView.findViewById(2131298664));
    this.vMo = ((Button)paramView.findViewById(2131298608));
    this.vMr = ((Button)paramView.findViewById(2131298666));
    this.vMs = ((TextView)paramView.findViewById(2131298670));
    this.vMq = paramView.findViewById(2131298667);
    this.vMp = ((Button)paramView.findViewById(2131298665));
    this.vMw = ((Button)paramView.findViewById(2131298596));
    this.vMt = paramView.findViewById(2131298639);
    this.vMu = ((Button)paramView.findViewById(2131298638));
    this.vMv = ((Button)paramView.findViewById(2131298640));
    this.fTu = ((Button)paramView.findViewById(2131298641));
    this.vMz = ((Button)paramView.findViewById(2131298629));
    this.vMx = ((Button)paramView.findViewById(2131298668));
    this.vMy = ((Button)paramView.findViewById(2131298605));
    this.vMA = ((TextView)paramView.findViewById(2131298630));
    this.pDN = true;
    initView();
    super.onBindView(paramView);
    if ((this.iMV.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) == true) && (this.vMn != null)) {
      this.vMn.performClick();
    }
    AppMethodBeat.o(27356);
  }
  
  abstract class a
    implements com.tencent.mm.ak.g, com.tencent.mm.pluginsdk.f.a.a
  {
    boolean isDeleteCancel = false;
    private e vHS = null;
    
    public a() {}
    
    final void Kp(String paramString)
    {
      NormalUserFooterPreference.a(NormalUserFooterPreference.this).aag();
      if (ai.aNc(paramString))
      {
        ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).Fj(paramString);
        ar.a.hnw.ye(paramString);
        return;
      }
      ((com.tencent.mm.pluginsdk.f.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.f.a.class)).Kp(paramString);
    }
    
    protected final void V(final boolean paramBoolean1, final boolean paramBoolean2)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        return;
      }
      NormalUserFooterPreference.b(NormalUserFooterPreference.this).addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27307);
          paramAnonymousMenuItem = new e(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
          paramAnonymousMenuItem.ISv = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(27305);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                AppMethodBeat.o(27305);
                return;
              case 1: 
                NormalUserFooterPreference.a.this.apx(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
                AppMethodBeat.o(27305);
                return;
              case 8: 
                NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this);
                AppMethodBeat.o(27305);
                return;
              }
              paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext;
              Context localContext = NormalUserFooterPreference.this.mContext;
              if (ai.aNc(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {}
              for (paramAnonymous2Int = 2131757738;; paramAnonymous2Int = 2131757737)
              {
                com.tencent.mm.ui.base.h.a(paramAnonymous2MenuItem, localContext.getString(paramAnonymous2Int), NormalUserFooterPreference.this.mContext.getString(2131757736), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(27304);
                    NormalUserFooterPreference.a.b(NormalUserFooterPreference.a.this);
                    AppMethodBeat.o(27304);
                  }
                }, null);
                break;
              }
            }
          };
          paramAnonymousMenuItem.ISu = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(27306);
              if (!NormalUserFooterPreference.a.10.this.vMH)
              {
                if (!ai.aNc(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
                  break label95;
                }
                paramAnonymous2l.aJ(1, 2131757927, 2131689826);
              }
              while (!NormalUserFooterPreference.a.10.this.vMI) {
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).aaH())
                {
                  paramAnonymous2l.aJ(8, 2131757741, 2131689795);
                  AppMethodBeat.o(27306);
                  return;
                  label95:
                  paramAnonymous2l.aJ(1, 2131757731, 2131689826);
                }
                else if (!w.wF(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2l.aJ(5, 2131757736, 2131689795);
                }
              }
              AppMethodBeat.o(27306);
            }
          };
          paramAnonymousMenuItem.cED();
          AppMethodBeat.o(27307);
          return true;
        }
      });
    }
    
    public final void a(String paramString, int paramInt, cbt paramcbt)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      if (paramInt == 0)
      {
        switch (NormalUserFooterPreference.l(NormalUserFooterPreference.this))
        {
        default: 
          if (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 9)
          {
            ac.i("MicroMsg.NormalUserFooterPreference", "add scene unkown, check the contact getsource: " + NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource());
            switch (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource())
            {
            }
          }
          break;
        }
        for (;;)
        {
          if (NormalUserFooterPreference.o(NormalUserFooterPreference.this) != 0) {
            break label453;
          }
          paramString = new Intent();
          paramString.addFlags(67108864);
          com.tencent.mm.plugin.profile.b.iyx.p(paramString, NormalUserFooterPreference.this.mContext);
          return;
          paramcbt = com.tencent.mm.plugin.account.a.getQQListStg().Gu(paramString);
          if (paramcbt == null) {
            break;
          }
          paramcbt.iLJ = 1;
          com.tencent.mm.plugin.account.a.getQQListStg().a(paramcbt.iLI, paramcbt);
          break;
          paramcbt = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(paramString);
          if ((paramcbt != null) && (!bs.isNullOrNil(paramcbt.iJS)))
          {
            paramcbt.status = 1;
            com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramcbt.JC(), paramcbt);
          }
          t.K(NormalUserFooterPreference.this.mContext, paramString);
          break;
          t.K(NormalUserFooterPreference.this.mContext, paramString);
          break;
          paramcbt = com.tencent.mm.plugin.account.a.getFacebookFrdStg();
          Object localObject3 = "select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + paramString + "\"";
          localObject3 = paramcbt.hpA.a((String)localObject3, null, 2);
          if (localObject3 == null) {
            paramcbt = localObject1;
          }
          while (paramcbt != null)
          {
            paramcbt.status = 100;
            com.tencent.mm.plugin.account.a.getFacebookFrdStg().a(paramcbt);
            break;
            paramcbt = localObject2;
            if (((Cursor)localObject3).moveToFirst())
            {
              paramcbt = new com.tencent.mm.plugin.account.friend.a.g();
              paramcbt.convertFrom((Cursor)localObject3);
            }
            ((Cursor)localObject3).close();
          }
          com.tencent.mm.plugin.account.a.getGoogleFriendStorage().az(paramString, 2);
          break;
          ac.i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
          t.K(NormalUserFooterPreference.this.mContext, paramString);
        }
        label453:
        NormalUserFooterPreference.b(NormalUserFooterPreference.this).setResult(-1, NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().putExtra("_delete_ok_", true));
        ((Activity)NormalUserFooterPreference.this.mContext).finish();
        return;
      }
      if (!bs.isNullOrNil(paramcbt.hkR))
      {
        com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.b(NormalUserFooterPreference.this), paramcbt.hkR, paramcbt.Title, true);
        return;
      }
      com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755708), "", true);
    }
    
    final void apx(String paramString)
    {
      if (bs.isNullOrNil(paramString))
      {
        ac.w("MicroMsg.NormalUserFooterPreference", "mod stranger remark, username is null");
        return;
      }
      paramString = new Intent();
      paramString.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
      paramString.putExtra("Contact_mode_name_type", 0);
      paramString.putExtra("Contact_ModStrangerRemark", true);
      paramString.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      paramString.putExtra("Contact_Nick", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_nickname);
      paramString.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_conRemark);
      com.tencent.mm.plugin.profile.b.iyx.n(paramString, NormalUserFooterPreference.this.mContext);
    }
    
    protected void awk()
    {
      dqw();
      dqy();
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27308);
          ac.i("MicroMsg.NormalUserFooterPreference", "sendButton onClick %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
          Object localObject;
          Intent localIntent;
          if (NormalUserFooterPreference.e(NormalUserFooterPreference.this))
          {
            paramAnonymousView = NormalUserFooterPreference.a.this;
            localObject = NormalUserFooterPreference.a(paramAnonymousView.vMD).field_username;
            localIntent = new Intent();
            localIntent.addFlags(67108864);
            if (NormalUserFooterPreference.n(paramAnonymousView.vMD))
            {
              localIntent.putExtra("Chat_User", (String)localObject);
              localIntent.putExtra("Chat_Mode", 1);
              ((Activity)paramAnonymousView.vMD.mContext).setResult(-1, localIntent);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent())), Integer.valueOf(4), Integer.valueOf(1), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
            AppMethodBeat.o(27308);
            return;
            localIntent.putExtra("Chat_User", (String)localObject);
            localIntent.putExtra("Chat_Mode", 1);
            com.tencent.mm.plugin.profile.b.iyx.d(localIntent, paramAnonymousView.vMD.mContext);
            continue;
            paramAnonymousView = NormalUserFooterPreference.a.this;
            localObject = new Intent();
            ((Intent)localObject).addFlags(67108864);
            if (NormalUserFooterPreference.n(paramAnonymousView.vMD))
            {
              ((Intent)localObject).putExtra("Chat_User", NormalUserFooterPreference.a(paramAnonymousView.vMD).field_username);
              ((Intent)localObject).putExtra("Chat_Mode", 1);
              ((Activity)paramAnonymousView.vMD.mContext).setResult(-1, (Intent)localObject);
            }
            else
            {
              ((Intent)localObject).putExtra("Chat_User", NormalUserFooterPreference.a(paramAnonymousView.vMD).field_username);
              ((Intent)localObject).putExtra("Chat_Mode", 1);
              com.tencent.mm.plugin.profile.b.iyx.d((Intent)localObject, paramAnonymousView.vMD.mContext);
            }
          }
        }
      });
      NormalUserFooterPreference.g(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27309);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_permission_userName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          paramAnonymousView.putExtra("sns_permission_anim", true);
          paramAnonymousView.putExtra("sns_permission_block_scene", 4);
          com.tencent.mm.br.d.b(NormalUserFooterPreference.b(NormalUserFooterPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymousView);
          AppMethodBeat.o(27309);
        }
      });
      NormalUserFooterPreference.h(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27310);
          paramAnonymousView = NormalUserFooterPreference.a.this;
          Object localObject = new xg();
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
          int i;
          if ((!NormalUserFooterPreference.a(paramAnonymousView.vMD).field_username.equals(((xg)localObject).dzZ.talker)) && ((((xg)localObject).dzZ.cYX) || (((xg)localObject).dzZ.cYY))) {
            if (((xg)localObject).dzZ.dAa)
            {
              i = 2131756778;
              Toast.makeText(NormalUserFooterPreference.b(paramAnonymousView.vMD).getContext(), i, 0).show();
              ac.i("MicroMsg.NormalUserFooterPreference", "voip is running, can't do this");
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent())), Integer.valueOf(5), Integer.valueOf(1), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
            AppMethodBeat.o(27310);
            return;
            i = 2131756779;
            break;
            if ((!com.tencent.mm.r.a.cf(NormalUserFooterPreference.b(paramAnonymousView.vMD))) && (!com.tencent.mm.r.a.ck(NormalUserFooterPreference.b(paramAnonymousView.vMD))))
            {
              localObject = new vt();
              ((vt)localObject).dyB.dyD = true;
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
              localObject = ((vt)localObject).dyC.dyF;
              if (!bs.isNullOrNil((String)localObject))
              {
                ac.v("MicroMsg.NormalUserFooterPreference", "Talkroom is on: ".concat(String.valueOf(localObject)));
                com.tencent.mm.ui.base.h.d(NormalUserFooterPreference.b(paramAnonymousView.vMD), NormalUserFooterPreference.b(paramAnonymousView.vMD).getString(2131764350), "", NormalUserFooterPreference.b(paramAnonymousView.vMD).getString(2131755835), NormalUserFooterPreference.b(paramAnonymousView.vMD).getString(2131755691), new NormalUserFooterPreference.a.2(paramAnonymousView), new NormalUserFooterPreference.a.3(paramAnonymousView));
              }
              else
              {
                paramAnonymousView.dqz();
              }
            }
          }
        }
      });
      NormalUserFooterPreference.i(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27311);
          NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
          AppMethodBeat.o(27311);
        }
      });
      NormalUserFooterPreference.j(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27312);
          NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
          AppMethodBeat.o(27312);
        }
      });
      NormalUserFooterPreference.k(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27313);
          NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
          AppMethodBeat.o(27313);
        }
      });
      ((com.tencent.mm.pluginsdk.f.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.f.a.class)).a(this);
    }
    
    protected final void dqA()
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(2), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
      final String str = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
      if (w.wE(str))
      {
        NormalUserFooterPreference.a(NormalUserFooterPreference.this).aag();
        az.ayM();
        com.tencent.mm.model.c.awA().c(new com.tencent.mm.ba.d(str));
        az.ayM();
        com.tencent.mm.model.c.awB().aNA(str);
        az.ayM();
        com.tencent.mm.model.c.awK().xT(str);
        return;
      }
      this.isDeleteCancel = false;
      Object localObject = NormalUserFooterPreference.this.mContext;
      NormalUserFooterPreference.this.mContext.getString(2131755906);
      final p localp = com.tencent.mm.ui.base.h.b((Context)localObject, NormalUserFooterPreference.this.mContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          NormalUserFooterPreference.a.this.isDeleteCancel = true;
        }
      });
      if (!this.isDeleteCancel) {}
      for (localObject = com.tencent.mm.pluginsdk.wallet.d.aIl(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);; localObject = null)
      {
        if (!bs.isNullOrNil((String)localObject))
        {
          localp.dismiss();
          com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, false, NormalUserFooterPreference.this.mContext.getString(2131765236, new Object[] { localObject }), null, NormalUserFooterPreference.this.mContext.getString(2131760081), NormalUserFooterPreference.this.mContext.getString(2131758036), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27301);
              com.tencent.mm.plugin.report.service.h.wUl.f(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(4), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              NormalUserFooterPreference.a.this.isDeleteCancel = true;
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("Chat_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
              paramAnonymousDialogInterface.addFlags(67108864);
              com.tencent.mm.br.d.e(NormalUserFooterPreference.this.mContext, ".ui.chatting.ChattingUI", paramAnonymousDialogInterface);
              AppMethodBeat.o(27301);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27302);
              com.tencent.mm.plugin.report.service.h.wUl.f(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(3), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              localp.show();
              NormalUserFooterPreference.a.this.isDeleteCancel = false;
              NormalUserFooterPreference.a.this.Kp(str);
              AppMethodBeat.o(27302);
            }
          }, -1, 2131099904);
          return;
        }
        Kp(str);
        return;
      }
    }
    
    protected abstract void dqw();
    
    protected final void dqx()
    {
      NormalUserFooterPreference.b(NormalUserFooterPreference.this).addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27296);
          paramAnonymousMenuItem = new e(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
          paramAnonymousMenuItem.ISv = new n.d()
          {
            public final void onMMMenuItemSelected(final MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              Object localObject3 = null;
              AppMethodBeat.i(27294);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(27294);
                return;
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).aaJ())
                {
                  w.r(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  com.tencent.mm.ui.base.h.cg(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757891));
                }
                for (;;)
                {
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this;
                  az.ayM();
                  NormalUserFooterPreference.a(paramAnonymous2MenuItem, com.tencent.mm.model.c.awB().aNt(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
                  AppMethodBeat.o(27294);
                  return;
                  w.q(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  com.tencent.mm.ui.base.h.cg(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757665));
                }
                paramAnonymous2MenuItem = new Intent();
                paramAnonymous2MenuItem.putExtra("sns_permission_userName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
                paramAnonymous2MenuItem.putExtra("sns_permission_anim", true);
                paramAnonymous2MenuItem.putExtra("sns_permission_block_scene", 1);
                com.tencent.mm.br.d.b(NormalUserFooterPreference.b(NormalUserFooterPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymous2MenuItem);
                AppMethodBeat.o(27294);
                return;
                paramAnonymous2MenuItem = NormalUserFooterPreference.a.this;
                Object localObject1 = new Intent();
                ((Intent)localObject1).putExtra("Select_Talker_Name", NormalUserFooterPreference.a(paramAnonymous2MenuItem.vMD).field_username);
                ((Intent)localObject1).putExtra("Select_block_List", NormalUserFooterPreference.a(paramAnonymous2MenuItem.vMD).field_username);
                ((Intent)localObject1).putExtra("Select_Conv_Type", 3);
                ((Intent)localObject1).putExtra("Select_Send_Card", true);
                ((Intent)localObject1).putExtra("mutil_select_is_ret", true);
                com.tencent.mm.plugin.profile.b.iyx.a((Intent)localObject1, NormalUserFooterPreference.b(paramAnonymous2MenuItem.vMD));
                AppMethodBeat.o(27294);
                return;
                NormalUserFooterPreference.this.huf.dS("hide_btn");
                NormalUserFooterPreference.this.huf.doNotify();
                NormalUserFooterPreference.a locala = NormalUserFooterPreference.a.this;
                paramAnonymous2MenuItem = locala.vMD;
                az.ayM();
                NormalUserFooterPreference.a(paramAnonymous2MenuItem, com.tencent.mm.model.c.awB().aNt(NormalUserFooterPreference.a(locala.vMD).field_username));
                if (!com.tencent.mm.n.b.ln(NormalUserFooterPreference.a(locala.vMD).field_type))
                {
                  locala.apx(NormalUserFooterPreference.a(locala.vMD).field_username);
                  AppMethodBeat.o(27294);
                  return;
                }
                Intent localIntent = new Intent();
                localIntent.putExtra("Contact_Scene", NormalUserFooterPreference.l(locala.vMD));
                localIntent.putExtra("Contact_User", NormalUserFooterPreference.a(locala.vMD).field_username);
                localIntent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(locala.vMD).getIntent().getStringExtra("Contact_RoomNickname"));
                localIntent.putExtra("contact_phone_number_list", NormalUserFooterPreference.a(locala.vMD).eyl);
                Object localObject2 = "";
                localObject1 = localObject2;
                String str;
                if (!NormalUserFooterPreference.a(locala.vMD).aaO())
                {
                  localObject1 = NormalUserFooterPreference.b(locala.vMD).getIntent().getStringExtra("Contact_Mobile_MD5");
                  str = NormalUserFooterPreference.b(locala.vMD).getIntent().getStringExtra("Contact_full_Mobile_MD5");
                  if ((!bs.isNullOrNil((String)localObject1)) || (!bs.isNullOrNil(str))) {
                    break label803;
                  }
                  paramAnonymous2MenuItem = localObject3;
                  if (!bs.isNullOrNil(NormalUserFooterPreference.a(locala.vMD).field_username)) {
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(NormalUserFooterPreference.a(locala.vMD).field_username);
                  }
                }
                for (;;)
                {
                  localObject1 = localObject2;
                  if (paramAnonymous2MenuItem != null)
                  {
                    localObject1 = localObject2;
                    if (!bs.isNullOrNil(paramAnonymous2MenuItem.JC())) {
                      localObject1 = bs.nullAsNil(paramAnonymous2MenuItem.aPr()).replace(" ", "");
                    }
                  }
                  localIntent.putExtra("contact_phone_number_by_md5", (String)localObject1);
                  com.tencent.mm.plugin.profile.b.iyx.m(localIntent, locala.vMD.mContext);
                  AppMethodBeat.o(27294);
                  return;
                  label803:
                  if (bs.isNullOrNil((String)localObject1))
                  {
                    paramAnonymous2MenuItem = localObject3;
                    if (bs.isNullOrNil(str)) {}
                  }
                  else
                  {
                    localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi((String)localObject1);
                    if (localObject1 != null)
                    {
                      paramAnonymous2MenuItem = (MenuItem)localObject1;
                      if (!bs.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).JC())) {}
                    }
                    else
                    {
                      paramAnonymous2MenuItem = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi(str);
                    }
                  }
                }
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).aaH())
                {
                  NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this);
                  AppMethodBeat.o(27294);
                  return;
                }
                paramAnonymous2MenuItem = View.inflate(NormalUserFooterPreference.this.mContext, 2131494763, null);
                paramAnonymous2MenuItem.setPadding(0, 0, 0, 0);
                localObject1 = (TextView)paramAnonymous2MenuItem.findViewById(2131302306);
                ((TextView)localObject1).setPadding(0, 0, 0, 0);
                if (ai.aNc(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2Int = 2131757738;
                  ((TextView)localObject1).setText(paramAnonymous2Int);
                  localObject1 = (CheckBox)paramAnonymous2MenuItem.findViewById(2131302304);
                  ((CheckBox)localObject1).setChecked(false);
                  localObject2 = (TextView)paramAnonymous2MenuItem.findViewById(2131302305);
                  ((TextView)localObject2).setText(2131757739);
                  if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource() != 18) {
                    break label1140;
                  }
                  ((CheckBox)localObject1).setVisibility(0);
                  ((TextView)localObject2).setVisibility(0);
                }
                for (;;)
                {
                  com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(2131757736), paramAnonymous2MenuItem, NormalUserFooterPreference.this.mContext.getString(2131755835), NormalUserFooterPreference.this.mContext.getString(2131755691), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(27292);
                      NormalUserFooterPreference.a.b(NormalUserFooterPreference.a.this);
                      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource() == 18)
                      {
                        NormalUserFooterPreference.a(NormalUserFooterPreference.this, 9);
                        if (this.vIn.isChecked()) {
                          NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
                        }
                      }
                      AppMethodBeat.o(27292);
                    }
                  }, null);
                  AppMethodBeat.o(27294);
                  return;
                  paramAnonymous2Int = 2131757737;
                  break;
                  label1140:
                  ((CheckBox)localObject1).setVisibility(8);
                  ((TextView)localObject2).setVisibility(8);
                }
                localObject1 = View.inflate(NormalUserFooterPreference.this.mContext, 2131494763, null);
                ((View)localObject1).setPadding(0, 0, 0, 0);
                localObject2 = (TextView)((View)localObject1).findViewById(2131302306);
                ((TextView)localObject2).setPadding(0, 0, 0, 0);
                if (w.wE(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext.getString(2131758022, new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).aaS() });
                  ((TextView)localObject2).setText(paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = (CheckBox)((View)localObject1).findViewById(2131302304);
                  paramAnonymous2MenuItem.setChecked(false);
                  localObject2 = (TextView)((View)localObject1).findViewById(2131302305);
                  ((TextView)localObject2).setText(2131757739);
                  if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource() != 18) {
                    break label1487;
                  }
                  paramAnonymous2MenuItem.setVisibility(0);
                  ((TextView)localObject2).setVisibility(0);
                }
                for (;;)
                {
                  com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(2131757641), (View)localObject1, NormalUserFooterPreference.this.mContext.getString(2131755707), NormalUserFooterPreference.this.mContext.getString(2131755691), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(27293);
                      NormalUserFooterPreference.a.this.dqA();
                      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource() == 18)
                      {
                        NormalUserFooterPreference.a(NormalUserFooterPreference.this, 9);
                        if (paramAnonymous2MenuItem.isChecked()) {
                          NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
                        }
                      }
                      AppMethodBeat.o(27293);
                    }
                  }, null, 2131099904);
                  AppMethodBeat.o(27294);
                  return;
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext.getString(2131758020, new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).aaS() });
                  break;
                  label1487:
                  paramAnonymous2MenuItem.setVisibility(8);
                  ((TextView)localObject2).setVisibility(8);
                }
                paramAnonymous2MenuItem = NormalUserFooterPreference.a.this;
                ac.d("MicroMsg.NormalUserFooterPreference", "dealAddShortcut, username = " + NormalUserFooterPreference.a(paramAnonymous2MenuItem.vMD).field_username);
                com.tencent.mm.plugin.base.model.b.Z(NormalUserFooterPreference.b(paramAnonymous2MenuItem.vMD), NormalUserFooterPreference.a(paramAnonymous2MenuItem.vMD).field_username);
                ap.n(new NormalUserFooterPreference.a.9(paramAnonymous2MenuItem), 1000L);
                AppMethodBeat.o(27294);
                return;
                NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
              }
            }
          };
          paramAnonymousMenuItem.ISu = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(27295);
              com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent())), Integer.valueOf(7), Integer.valueOf(1), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              if (ai.aNc(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
              {
                paramAnonymous2l.aJ(1, 2131757927, 2131689826);
                if (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).aaJ()) {
                  break label318;
                }
                str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getResources().getString(2131757890);
                label151:
                paramAnonymous2l.a(2, str, 2131689829);
                if (!ai.aNc(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
                  paramAnonymous2l.aJ(3, 2131757747, 2131689817);
                }
                paramAnonymous2l.aJ(4, 2131757808, 2131689831);
                paramAnonymous2l.aJ(9, 2131756596, 2131689799);
                if (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).aaH()) {
                  break label343;
                }
              }
              label318:
              label343:
              for (String str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757741);; str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757736))
              {
                paramAnonymous2l.a(5, str, 2131689795);
                if (!NormalUserFooterPreference.c(NormalUserFooterPreference.this)) {
                  paramAnonymous2l.aJ(6, 2131756457, 2131689802);
                }
                paramAnonymous2l.aJ(7, 2131757578, 2131689803);
                AppMethodBeat.o(27295);
                return;
                paramAnonymous2l.aJ(1, 2131757731, 2131689826);
                break;
                str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getResources().getString(2131757664);
                break label151;
              }
            }
          };
          paramAnonymousMenuItem.cED();
          AppMethodBeat.o(27296);
          return true;
        }
      });
    }
    
    protected void dqy()
    {
      if (NormalUserFooterPreference.d(NormalUserFooterPreference.this)) {
        NormalUserFooterPreference.b(NormalUserFooterPreference.this).showOptionMenu(false);
      }
      do
      {
        do
        {
          return;
        } while (u.axw().equals(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
        if (!com.tencent.mm.n.b.ln(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) {
          break;
        }
      } while (w.xj(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
      dqx();
      return;
      V(false, false);
    }
    
    final void dqz()
    {
      this.vHS = new e(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
      this.vHS.ISu = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(27299);
          paramAnonymousl.aJ(2, 2131755762, 2131691164);
          paramAnonymousl.aJ(1, 2131755764, 2131691165);
          AppMethodBeat.o(27299);
        }
      };
      this.vHS.ISv = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(27300);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(27300);
            return;
            NormalUserFooterPreference.this.dqu();
            AppMethodBeat.o(27300);
            return;
            NormalUserFooterPreference.this.dqv();
          }
        }
      };
      this.vHS.cED();
    }
    
    protected void onDetach()
    {
      ((com.tencent.mm.pluginsdk.f.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.f.a.class)).b(this);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      ac.i("MicroMsg.NormalUserFooterPreference", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    }
  }
  
  final class b
    extends NormalUserFooterPreference.c
  {
    public b()
    {
      super();
    }
    
    protected final void dqw()
    {
      AppMethodBeat.i(27317);
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      if ((!com.tencent.mm.n.b.ln(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) || ((com.tencent.mm.n.b.ln(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) && (ai.ww(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))))
      {
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(0);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.g(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
      }
      for (;;)
      {
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.k(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(8);
        if (NormalUserFooterPreference.B(NormalUserFooterPreference.this))
        {
          NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
          NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(0);
          NormalUserFooterPreference.t(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(27314);
              NormalUserFooterPreference.b.this.dqB();
              AppMethodBeat.o(27314);
            }
          });
        }
        NormalUserFooterPreference.A(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(27315);
            if ((NormalUserFooterPreference.c(NormalUserFooterPreference.this)) && (com.tencent.mm.bp.a.eJP()))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Chat_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername);
              paramAnonymousView.putExtra("lbs_mode", true);
              paramAnonymousView.putExtra("lbs_ticket", NormalUserFooterPreference.C(NormalUserFooterPreference.this));
              paramAnonymousView.putExtra("add_scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              com.tencent.mm.plugin.profile.b.iyx.d(paramAnonymousView, NormalUserFooterPreference.b(NormalUserFooterPreference.this));
              AppMethodBeat.o(27315);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
            paramAnonymousView.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
            paramAnonymousView.putExtra(e.c.HgZ, NormalUserFooterPreference.a(NormalUserFooterPreference.this).eym);
            com.tencent.mm.plugin.profile.b.iyx.a(paramAnonymousView, NormalUserFooterPreference.this.mContext);
            AppMethodBeat.o(27315);
          }
        });
        AppMethodBeat.o(27317);
        return;
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
        if ((NormalUserFooterPreference.this.dqt()) || (NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(u.axw()))) {
          break;
        }
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
      }
    }
    
    protected final void dqy()
    {
      AppMethodBeat.i(27316);
      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this) == null)
      {
        ac.e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
        AppMethodBeat.o(27316);
        return;
      }
      if ((!com.tencent.mm.n.b.ln(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) || ((com.tencent.mm.n.b.ln(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) && (ai.ww(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))))
      {
        if (ai.ww(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
        {
          V(true, true);
          AppMethodBeat.o(27316);
          return;
        }
        V(false, true);
        AppMethodBeat.o(27316);
        return;
      }
      dqx();
      AppMethodBeat.o(27316);
    }
  }
  
  class c
    extends NormalUserFooterPreference.a
  {
    public c()
    {
      super();
    }
    
    private void dqC()
    {
      AppMethodBeat.i(27327);
      Object localObject2 = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("Contact_Mobile_MD5");
      Object localObject1 = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("Contact_full_Mobile_MD5");
      String str = bs.nullAsNil((String)localObject2);
      localObject1 = bs.nullAsNil((String)localObject1);
      if ((!str.equals("")) || (!((String)localObject1).equals("")))
      {
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi(str);
        if (localObject2 != null) {
          break label113;
        }
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi((String)localObject1);
      }
      for (;;)
      {
        if (localObject2 == null)
        {
          AppMethodBeat.o(27327);
          return;
        }
        com.tencent.mm.plugin.account.a.getAddrUploadStg().a((String)localObject1, (com.tencent.mm.plugin.account.friend.a.a)localObject2);
        AppMethodBeat.o(27327);
        return;
        label113:
        localObject1 = str;
      }
    }
    
    protected final void awk()
    {
      AppMethodBeat.i(27323);
      super.awk();
      AppMethodBeat.o(27323);
    }
    
    protected final void dqB()
    {
      AppMethodBeat.i(27326);
      if ((int)NormalUserFooterPreference.a(NormalUserFooterPreference.this).fLJ == 0)
      {
        az.ayM();
        if (com.tencent.mm.model.c.awB().ah(NormalUserFooterPreference.a(NormalUserFooterPreference.this)) != -1)
        {
          localObject = NormalUserFooterPreference.this;
          az.ayM();
          NormalUserFooterPreference.a((NormalUserFooterPreference)localObject, com.tencent.mm.model.c.awB().aNt(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
        }
      }
      if ((NormalUserFooterPreference.F(NormalUserFooterPreference.this)) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 12))
      {
        ac.d("MicroMsg.NormalUserFooterPreference", "qqNum " + NormalUserFooterPreference.G(NormalUserFooterPreference.this) + " qqReamrk " + NormalUserFooterPreference.H(NormalUserFooterPreference.this));
        if ((NormalUserFooterPreference.G(NormalUserFooterPreference.this) != 0L) && (NormalUserFooterPreference.H(NormalUserFooterPreference.this) != null) && (!NormalUserFooterPreference.H(NormalUserFooterPreference.this).equals("")))
        {
          localObject = com.tencent.mm.plugin.account.a.getQQListStg().qC(NormalUserFooterPreference.G(NormalUserFooterPreference.this));
          if (localObject != null) {
            break label451;
          }
          localObject = new as();
          ((as)localObject).nickname = "";
          ((as)localObject).iLI = NormalUserFooterPreference.G(NormalUserFooterPreference.this);
          ((as)localObject).iLQ = NormalUserFooterPreference.H(NormalUserFooterPreference.this);
          ((as)localObject).username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
          ((as)localObject).aQf();
          com.tencent.mm.plugin.account.a.getQQListStg().a((as)localObject);
        }
      }
      final com.tencent.mm.pluginsdk.ui.applet.a locala;
      final LinkedList localLinkedList;
      final String str;
      for (;;)
      {
        dqC();
        locala = new com.tencent.mm.pluginsdk.ui.applet.a(NormalUserFooterPreference.this.mContext, new com.tencent.mm.pluginsdk.ui.applet.a.a()
        {
          public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(27320);
            if (paramAnonymousBoolean1)
            {
              NormalUserFooterPreference.this.huf.dS("hide_btn");
              NormalUserFooterPreference.this.huf.doNotify();
              NormalUserFooterPreference.v(NormalUserFooterPreference.this);
              NormalUserFooterPreference.c.a(NormalUserFooterPreference.c.this, paramAnonymousString1);
            }
            for (;;)
            {
              if ((paramAnonymousBoolean1) || (paramAnonymousBoolean2))
              {
                paramAnonymousString1 = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent();
                int i = paramAnonymousString1.getIntExtra("search_kvstat_scene", 0);
                int j = paramAnonymousString1.getIntExtra("search_kvstat_position", 0);
                if ((i > 0) && (j > 0)) {
                  com.tencent.mm.plugin.report.service.h.wUl.f(10991, new Object[] { Integer.valueOf(i), Integer.valueOf(6), Integer.valueOf(j) });
                }
              }
              AppMethodBeat.o(27320);
              return;
              if (paramAnonymousBoolean2)
              {
                com.tencent.mm.bj.d.aJe().fQ(paramAnonymousString1, 2);
                au.aB(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername, 1);
                paramAnonymousString1 = new py();
                paramAnonymousString1.dtc.username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername;
                paramAnonymousString1.dtc.type = 1;
                com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString1);
              }
              else
              {
                ac.e("MicroMsg.NormalUserFooterPreference", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(paramAnonymousString1)));
              }
            }
          }
        });
        localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(NormalUserFooterPreference.l(NormalUserFooterPreference.this)));
        localObject = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("source_from_user_name");
        str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("source_from_nick_name");
        locala.kX((String)localObject, str);
        locala.DpJ = new a.b()
        {
          public final boolean ax(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(27321);
            String str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("room_name");
            int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbC, 0);
            Object localObject = SayHiWithSnsPermissionUI.class;
            if (i == 1) {
              localObject = SayHiWithSnsPermissionUI2.class;
            }
            for (;;)
            {
              localObject = new Intent(NormalUserFooterPreference.b(NormalUserFooterPreference.this), (Class)localObject);
              ((Intent)localObject).putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
              ((Intent)localObject).putExtra("Contact_Nick", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_nickname);
              ((Intent)localObject).putExtra("Contact_RemarkName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_conRemark);
              if ((NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 14) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 8)) {
                ((Intent)localObject).putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("Contact_RoomNickname"));
              }
              ((Intent)localObject).putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              ((Intent)localObject).putExtra("room_name", str);
              ((Intent)localObject).putExtra("source_from_user_name", this.vIb);
              ((Intent)localObject).putExtra("source_from_nick_name", str);
              ((Intent)localObject).putExtra("sayhi_with_sns_perm_send_verify", true);
              ((Intent)localObject).putExtra("sayhi_with_sns_perm_add_remark", true);
              ((Intent)localObject).putExtra("sayhi_with_sns_perm_set_label", false);
              ((Intent)localObject).putExtra(e.c.HgZ, paramAnonymousString);
              ((Intent)localObject).putExtra("sayhi_verify_add_errcode", paramAnonymousInt);
              NormalUserFooterPreference.b(NormalUserFooterPreference.this).startActivityForResult((Intent)localObject, 0);
              AppMethodBeat.o(27321);
              return true;
              if (i == 2) {
                localObject = SayHiWithSnsPermissionUI3.class;
              }
            }
          }
        };
        str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("room_name");
        localObject = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra(e.c.HgZ);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        ac.i("MicroMsg.NormalUserFooterPreference", "add contact case 1:%s", new Object[] { localObject });
        locala.aHb((String)localObject);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, "", localLinkedList);
        AppMethodBeat.o(27326);
        return;
        label451:
        ((as)localObject).iLI = NormalUserFooterPreference.G(NormalUserFooterPreference.this);
        ((as)localObject).iLQ = NormalUserFooterPreference.H(NormalUserFooterPreference.this);
        ((as)localObject).username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
        ((as)localObject).aQf();
        com.tencent.mm.plugin.account.a.getQQListStg().a(NormalUserFooterPreference.G(NormalUserFooterPreference.this), (as)localObject);
        continue;
        if ((NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 58) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 59) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 60)) {
          com.tencent.mm.plugin.account.a.getGoogleFriendStorage().az(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, 1);
        }
      }
      if (TextUtils.isEmpty(str))
      {
        ac.i("MicroMsg.NormalUserFooterPreference", "add contact case 2, %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).eym });
        locala.aHb(NormalUserFooterPreference.a(NormalUserFooterPreference.this).eym);
        locala.i(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      if (!TextUtils.isEmpty(locala.sBi))
      {
        ac.i("MicroMsg.NormalUserFooterPreference", "add contact case 3, %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).eym });
        locala.aHb(NormalUserFooterPreference.a(NormalUserFooterPreference.this).eym);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      az.ayM();
      Object localObject = com.tencent.mm.model.c.awB().aNt(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      if (localObject != null) {}
      for (localObject = bs.bG(((av)localObject).eym, "");; localObject = "")
      {
        ac.i("MicroMsg.NormalUserFooterPreference", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localObject });
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        locala.aHb((String)localObject);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      ar.a.hnw.a(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27322);
          az.ayM();
          paramAnonymousString = com.tencent.mm.model.c.awB().aNt(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          if (paramAnonymousString != null) {}
          for (paramAnonymousString = bs.bG(paramAnonymousString.eym, "");; paramAnonymousString = "")
          {
            locala.aHb(paramAnonymousString);
            locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localLinkedList);
            AppMethodBeat.o(27322);
            return;
          }
        }
      });
      AppMethodBeat.o(27326);
    }
    
    protected void dqw()
    {
      AppMethodBeat.i(27325);
      boolean bool;
      if (!w.xr(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
      {
        bool = true;
        Assert.assertTrue(bool);
        NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        if (!NormalUserFooterPreference.d(NormalUserFooterPreference.this)) {
          break label194;
        }
        NormalUserFooterPreference.D(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(27318);
            NormalUserFooterPreference.c.this.dqA();
            AppMethodBeat.o(27318);
          }
        });
        if (!com.tencent.mm.n.b.ln(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) {
          break label179;
        }
        NormalUserFooterPreference.D(NormalUserFooterPreference.this).setVisibility(0);
      }
      for (;;)
      {
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.g(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(8);
        AppMethodBeat.o(27325);
        return;
        bool = false;
        break;
        label179:
        NormalUserFooterPreference.D(NormalUserFooterPreference.this).setVisibility(8);
      }
      label194:
      NormalUserFooterPreference.t(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27319);
          if (NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent() != null)
          {
            paramAnonymousView = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("key_ww_add_session_id");
            if (!bs.isNullOrNil(paramAnonymousView))
            {
              cu localcu = new cu();
              localcu.kQ(paramAnonymousView);
              localcu.dNZ = 0L;
              localcu.dRk = 1L;
              localcu.aHZ();
            }
          }
          NormalUserFooterPreference.c.this.dqB();
          if (NormalUserFooterPreference.E(NormalUserFooterPreference.this) != 0) {
            com.tencent.mm.plugin.report.service.h.wUl.f(11263, new Object[] { Integer.valueOf(NormalUserFooterPreference.E(NormalUserFooterPreference.this)), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
          }
          AppMethodBeat.o(27319);
        }
      });
      if (!com.tencent.mm.n.b.ln(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type))
      {
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(0);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.g(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
        if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).aaH())
        {
          NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(0);
          AppMethodBeat.o(27325);
        }
      }
      else
      {
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
        if ((!NormalUserFooterPreference.this.dqt()) && (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(u.axw())) && (!w.xr(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!w.xj(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!ai.aNc(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!w.wF(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))) {
          NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
        }
        for (;;)
        {
          az.ayM();
          if (!com.tencent.mm.model.c.awB().aNx(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
            break;
          }
          NormalUserFooterPreference.k(NormalUserFooterPreference.this).setVisibility(0);
          NormalUserFooterPreference.a(NormalUserFooterPreference.this, NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource());
          break;
          NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
        }
      }
      NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(8);
      AppMethodBeat.o(27325);
    }
    
    protected void onDetach()
    {
      AppMethodBeat.i(27324);
      super.onDetach();
      AppMethodBeat.o(27324);
    }
  }
  
  final class d
    extends NormalUserFooterPreference.a
  {
    public d()
    {
      super();
    }
    
    protected final void dqw()
    {
      AppMethodBeat.i(27329);
      Assert.assertTrue(w.wT(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
      NormalUserFooterPreference.g(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.k(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(8);
      AppMethodBeat.o(27329);
    }
    
    protected final void dqy() {}
  }
  
  public static abstract interface e {}
  
  final class f
    extends NormalUserFooterPreference.a
  {
    public f()
    {
      super();
    }
    
    protected final void dqw()
    {
      AppMethodBeat.i(27332);
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(0);
      NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.g(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.k(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.A(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27330);
          com.tencent.mm.plugin.normsg.a.b.vor.ao(1, 1, 5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          paramAnonymousView.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
          paramAnonymousView.putExtra(e.c.HgZ, NormalUserFooterPreference.a(NormalUserFooterPreference.this).eym);
          com.tencent.mm.plugin.profile.b.iyx.a(paramAnonymousView, NormalUserFooterPreference.this.mContext);
          AppMethodBeat.o(27330);
        }
      });
      AppMethodBeat.o(27332);
    }
    
    protected final void dqy()
    {
      AppMethodBeat.i(27331);
      if ((NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) && (com.tencent.mm.n.b.ln(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)))
      {
        dqx();
        AppMethodBeat.o(27331);
        return;
      }
      V(false, true);
      AppMethodBeat.o(27331);
    }
  }
  
  final class g
    extends NormalUserFooterPreference.a
  {
    public g()
    {
      super();
    }
    
    protected final void dqw()
    {
      boolean bool2 = true;
      AppMethodBeat.i(27333);
      if (!u.wh(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
      {
        bool1 = true;
        Assert.assertTrue(bool1);
        if (w.xr(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
          break label147;
        }
      }
      label147:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Assert.assertTrue(bool1);
        NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setText(2131757813);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(8);
        AppMethodBeat.o(27333);
        return;
        bool1 = false;
        break;
      }
    }
    
    public final void dqy() {}
  }
  
  final class h
    extends NormalUserFooterPreference.a
  {
    public h()
    {
      super();
    }
    
    protected final void dqw()
    {
      AppMethodBeat.i(27334);
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
      if ((!NormalUserFooterPreference.this.dqt()) && (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(u.axw())) && (!w.xr(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!w.xj(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))) {
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
      }
      for (;;)
      {
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setText(2131757809);
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(8);
        AppMethodBeat.o(27334);
        return;
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
      }
    }
    
    protected final void dqy() {}
  }
  
  class i
    extends NormalUserFooterPreference.c
    implements com.tencent.mm.ak.g
  {
    private ProgressDialog fts;
    
    public i()
    {
      super();
    }
    
    private void aaf()
    {
      AppMethodBeat.i(27341);
      NormalUserFooterPreference localNormalUserFooterPreference = NormalUserFooterPreference.this;
      az.ayM();
      ai localai2 = com.tencent.mm.model.c.awB().aNt(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      if (localai2 != null)
      {
        localai1 = localai2;
        if ((int)localai2.fLJ != 0) {}
      }
      else
      {
        localai1 = NormalUserFooterPreference.a(NormalUserFooterPreference.this);
        az.ayM();
        if (com.tencent.mm.model.c.awB().af(localai1)) {
          break label131;
        }
        ac.e("MicroMsg.NormalUserFooterPreference", "insert contact failed, username = " + localai1.field_username);
      }
      for (ai localai1 = null;; localai1 = com.tencent.mm.model.c.awB().aNt(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
      {
        NormalUserFooterPreference.a(localNormalUserFooterPreference, localai1);
        if (NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) {
          w.u(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
        }
        AppMethodBeat.o(27341);
        return;
        label131:
        az.ayM();
      }
    }
    
    protected void dqD()
    {
      AppMethodBeat.i(27342);
      if (NormalUserFooterPreference.u(NormalUserFooterPreference.this) != null) {
        NormalUserFooterPreference.u(NormalUserFooterPreference.this).onDetach();
      }
      NormalUserFooterPreference.a(NormalUserFooterPreference.this, new NormalUserFooterPreference.c(NormalUserFooterPreference.this));
      NormalUserFooterPreference.u(NormalUserFooterPreference.this).awk();
      AppMethodBeat.o(27342);
    }
    
    protected void dqw()
    {
      AppMethodBeat.i(27338);
      onDetach();
      onStop();
      az.agi().a(30, this);
      az.agi().a(667, this);
      az.agi().a(853, this);
      super.dqw();
      AppMethodBeat.o(27338);
    }
    
    protected void onDetach()
    {
      AppMethodBeat.i(27340);
      if (this.fts != null)
      {
        this.fts.dismiss();
        this.fts = null;
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
      AppMethodBeat.o(27340);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      int j = 0;
      AppMethodBeat.i(27343);
      ac.d("MicroMsg.NormalUserFooterPreference", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      if ((paramn.getType() != 30) && (paramn.getType() != 667) && (paramn.getType() != 853))
      {
        AppMethodBeat.o(27343);
        return;
      }
      onStop();
      if (this.fts != null)
      {
        this.fts.dismiss();
        this.fts = null;
      }
      if (!bs.iX(NormalUserFooterPreference.this.mContext))
      {
        AppMethodBeat.o(27343);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn.getType() == 30)
        {
          paramInt1 = ((com.tencent.mm.pluginsdk.model.o)paramn).dgL;
          ac.d("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, opCode = ".concat(String.valueOf(paramInt1)));
          if ((paramInt1 == 1) || (paramInt1 == 3))
          {
            paramString = ((com.tencent.mm.pluginsdk.model.o)paramn).Dhk;
            if ((paramString != null) && (paramString.contains(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)))
            {
              NormalUserFooterPreference.v(NormalUserFooterPreference.this);
              aaf();
              dqD();
              paramString = paramString.iterator();
              while (paramString.hasNext()) {
                com.tencent.mm.pluginsdk.ui.preference.b.co((String)paramString.next(), NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              }
              az.getNotification().UP();
            }
          }
          AppMethodBeat.o(27343);
          return;
        }
        if ((paramn.getType() == 667) || (paramn.getType() == 853))
        {
          NormalUserFooterPreference.v(NormalUserFooterPreference.this);
          aaf();
          dqD();
          com.tencent.mm.pluginsdk.ui.preference.b.co(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, NormalUserFooterPreference.l(NormalUserFooterPreference.this));
          az.getNotification().UP();
          AppMethodBeat.o(27343);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -302)) {
        if (paramn.getType() != 30) {
          break label878;
        }
      }
      label878:
      for (paramInt1 = ((com.tencent.mm.pluginsdk.model.o)paramn).dgL;; paramInt1 = 0)
      {
        ac.w("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", new Object[] { Integer.valueOf(paramInt1) });
        if ((paramInt1 == 3) || (paramn.getType() == 853)) {
          com.tencent.mm.ui.base.h.d(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757894), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755906), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755272), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27337);
              NormalUserFooterPreference.i.this.dqB();
              AppMethodBeat.o(27337);
            }
          }, null);
        }
        AppMethodBeat.o(27343);
        return;
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!bs.isNullOrNil(paramString)))
        {
          Toast.makeText(NormalUserFooterPreference.b(NormalUserFooterPreference.this), paramString, 1).show();
          AppMethodBeat.o(27343);
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
          AppMethodBeat.o(27343);
          return;
          if (az.agi().aBL())
          {
            az.agi().getNetworkServerIp();
            new StringBuilder().append(paramInt2);
            i = 1;
          }
          else
          {
            i = j;
            if (ae.cS(NormalUserFooterPreference.this.mContext))
            {
              com.tencent.mm.pluginsdk.ui.tools.k.hx(NormalUserFooterPreference.this.mContext);
              i = 1;
              continue;
              Toast.makeText(NormalUserFooterPreference.this.mContext, NormalUserFooterPreference.this.mContext.getString(2131759511, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
              i = 1;
              continue;
              if (paramInt2 == -100)
              {
                com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, az.afG(), com.tencent.mm.cc.a.aw(NormalUserFooterPreference.this.mContext, 2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(27335);
                    NormalUserFooterPreference.i.this.onStop();
                    paramAnonymousDialogInterface = new Intent();
                    paramAnonymousDialogInterface.putExtra("Intro_Switch", true).addFlags(67108864);
                    com.tencent.mm.plugin.profile.b.iyx.p(paramAnonymousDialogInterface, NormalUserFooterPreference.this.mContext);
                    AppMethodBeat.o(27335);
                  }
                }, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                  {
                    AppMethodBeat.i(27336);
                    NormalUserFooterPreference.i.this.onStop();
                    paramAnonymousDialogInterface = new Intent();
                    paramAnonymousDialogInterface.putExtra("Intro_Switch", true).addFlags(67108864);
                    com.tencent.mm.plugin.profile.b.iyx.p(paramAnonymousDialogInterface, NormalUserFooterPreference.this.mContext);
                    AppMethodBeat.o(27336);
                  }
                });
                i = 1;
              }
              else
              {
                if ((paramInt1 == 4) && (paramInt2 == -34)) {
                  paramn = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131759479);
                }
                for (;;)
                {
                  Toast.makeText(NormalUserFooterPreference.b(NormalUserFooterPreference.this), paramn, 1).show();
                  i = j;
                  break;
                  if ((paramInt1 == 4) && (paramInt2 == -94))
                  {
                    paramn = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131759482);
                  }
                  else if (paramInt1 == 4)
                  {
                    paramn = paramString;
                    if (!bs.isNullOrNil(paramString)) {}
                  }
                  else
                  {
                    paramn = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131763075);
                  }
                }
              }
            }
          }
        }
        AppMethodBeat.o(27343);
        return;
      }
    }
    
    final void onStop()
    {
      AppMethodBeat.i(27339);
      az.agi().b(30, this);
      az.agi().b(667, this);
      az.agi().b(853, this);
      AppMethodBeat.o(27339);
    }
  }
  
  final class j
    extends NormalUserFooterPreference.i
    implements com.tencent.mm.ak.g
  {
    public j()
    {
      super();
    }
    
    protected final void dqD()
    {
      AppMethodBeat.i(27350);
      super.dqD();
      AppMethodBeat.o(27350);
    }
    
    protected final void dqw()
    {
      AppMethodBeat.i(27348);
      super.dqw();
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
      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).aaH())
      {
        NormalUserFooterPreference.x(NormalUserFooterPreference.this).setText(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757741));
        NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(0);
      }
      for (;;)
      {
        NormalUserFooterPreference.z(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(27344);
            NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().removeExtra("Accept_NewFriend_FromOutside");
            int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbC, 0);
            paramAnonymousView = SayHiWithSnsPermissionUI.class;
            if (i == 1) {
              paramAnonymousView = SayHiWithSnsPermissionUI2.class;
            }
            for (;;)
            {
              paramAnonymousView = new Intent(NormalUserFooterPreference.b(NormalUserFooterPreference.this), paramAnonymousView);
              paramAnonymousView.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
              paramAnonymousView.putExtra("room_name", NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("room_name"));
              paramAnonymousView.putExtra("Contact_Nick", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_nickname);
              paramAnonymousView.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_conRemark);
              if ((NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 14) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 8)) {
                paramAnonymousView.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("Contact_RoomNickname"));
              }
              paramAnonymousView.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              paramAnonymousView.putExtra("Verify_ticket", NormalUserFooterPreference.y(NormalUserFooterPreference.this));
              paramAnonymousView.putExtra("sayhi_with_sns_perm_send_verify", false);
              paramAnonymousView.putExtra("sayhi_with_sns_perm_add_remark", true);
              paramAnonymousView.putExtra("sayhi_with_sns_perm_set_label", true);
              NormalUserFooterPreference.b(NormalUserFooterPreference.this).startActivityForResult(paramAnonymousView, 0);
              AppMethodBeat.o(27344);
              return;
              if (i == 2) {
                paramAnonymousView = SayHiWithSnsPermissionUI3.class;
              }
            }
          }
        });
        NormalUserFooterPreference.x(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(27346);
            if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).aaH())
            {
              w.n(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
              NormalUserFooterPreference.a(NormalUserFooterPreference.this).aai();
              NormalUserFooterPreference.j.this.dqw();
              AppMethodBeat.o(27346);
              return;
            }
            paramAnonymousView = NormalUserFooterPreference.this.mContext;
            Context localContext = NormalUserFooterPreference.this.mContext;
            if (ai.aNc(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {}
            for (int i = 2131757738;; i = 2131757737)
            {
              com.tencent.mm.ui.base.h.a(paramAnonymousView, localContext.getString(i), NormalUserFooterPreference.this.mContext.getString(2131757736), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(27345);
                  w.m(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  NormalUserFooterPreference.a(NormalUserFooterPreference.this).aah();
                  NormalUserFooterPreference.j.this.dqw();
                  AppMethodBeat.o(27345);
                }
              }, null);
              AppMethodBeat.o(27346);
              return;
            }
          }
        });
        AppMethodBeat.o(27348);
        return;
        NormalUserFooterPreference.x(NormalUserFooterPreference.this).setText(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757736));
      }
    }
    
    protected final void dqy()
    {
      AppMethodBeat.i(27347);
      if ((NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) && (com.tencent.mm.n.b.ln(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)))
      {
        dqx();
        AppMethodBeat.o(27347);
        return;
      }
      V(false, true);
      AppMethodBeat.o(27347);
    }
    
    protected final void onDetach()
    {
      AppMethodBeat.i(27349);
      super.onDetach();
      AppMethodBeat.o(27349);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(27351);
      super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
      AppMethodBeat.o(27351);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference
 * JD-Core Version:    0.7.0.1
 */