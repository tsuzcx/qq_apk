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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vj.b;
import com.tencent.mm.g.a.wv;
import com.tencent.mm.g.a.wv.a;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.b.a.bh;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.network.ae;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.protocal.protobuf.bwz;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
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
  private af contact;
  private Button fPz;
  public ProgressDialog fpP;
  protected com.tencent.mm.sdk.e.l<e, String> gTG;
  private MMActivity imP;
  private int ima;
  private String mLJ;
  private boolean paC;
  private String rso;
  private int uBM;
  private String uBU;
  private boolean uBZ;
  private int uBv;
  private long uCr;
  private Button uDA;
  private TextView uDB;
  private View uDC;
  private Button uDD;
  private Button uDE;
  private Button uDF;
  private Button uDG;
  private Button uDH;
  private Button uDI;
  private TextView uDJ;
  private boolean uDK;
  public boolean uDL;
  private boolean uDq;
  private boolean uDr;
  private boolean uDs;
  private boolean uDt;
  private a uDu;
  private View uDv;
  private Button uDw;
  private Button uDx;
  private Button uDy;
  private View uDz;
  private boolean uzZ;
  private boolean uzt;
  
  public NormalUserFooterPreference(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(27352);
    this.uzt = false;
    this.uCr = 0L;
    this.uBU = "";
    this.rso = "";
    this.uBZ = false;
    this.uDs = false;
    this.uDt = false;
    this.uDK = false;
    this.uBv = 0;
    this.fpP = null;
    this.uDL = false;
    this.mLJ = null;
    this.gTG = new com.tencent.mm.sdk.e.l() {};
    this.imP = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27352);
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27353);
    this.uzt = false;
    this.uCr = 0L;
    this.uBU = "";
    this.rso = "";
    this.uBZ = false;
    this.uDs = false;
    this.uDt = false;
    this.uDK = false;
    this.uBv = 0;
    this.fpP = null;
    this.uDL = false;
    this.mLJ = null;
    this.gTG = new com.tencent.mm.sdk.e.l() {};
    this.imP = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27353);
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27354);
    this.uzt = false;
    this.uCr = 0L;
    this.uBU = "";
    this.rso = "";
    this.uBZ = false;
    this.uDs = false;
    this.uDt = false;
    this.uDK = false;
    this.uBv = 0;
    this.fpP = null;
    this.uDL = false;
    this.mLJ = null;
    this.gTG = new com.tencent.mm.sdk.e.l() {};
    this.imP = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27354);
  }
  
  private void init()
  {
    this.paC = false;
    this.uDu = null;
  }
  
  private void initView()
  {
    AppMethodBeat.i(27355);
    if ((!this.paC) || (this.contact == null))
    {
      ad.w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.paC + " contact = " + this.contact);
      if (this.uDu != null) {
        try
        {
          this.uDu.dcQ();
          AppMethodBeat.o(27355);
          return;
        }
        catch (Throwable localThrowable) {}
      }
      AppMethodBeat.o(27355);
      return;
    }
    if (this.uDu != null) {
      this.uDu.apt();
    }
    dcL();
    AppMethodBeat.o(27355);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(27360);
    if (bt.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27360);
      return;
    }
    if ((this.contact != null) && ((paramString.equals(this.contact.field_username)) || (paramString.equals(this.contact.field_encryptUsername))))
    {
      com.tencent.mm.model.az.arV();
      this.contact = com.tencent.mm.model.c.apM().aHY(this.contact.field_username);
      com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27291);
          NormalUserFooterPreference.this.dcL();
          AppMethodBeat.o(27291);
        }
      });
    }
    AppMethodBeat.o(27360);
  }
  
  public final boolean a(af paramaf, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2, boolean paramBoolean4, boolean paramBoolean5, long paramLong, String paramString2)
  {
    AppMethodBeat.i(27357);
    bRu();
    if (paramaf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bt.nullAsNil(paramaf.field_username).length() <= 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!af.aHM(u.aqG()).equals(paramaf.field_username)) {
        break label80;
      }
      AppMethodBeat.o(27357);
      return false;
      bool = false;
      break;
    }
    label80:
    this.contact = paramaf;
    this.rso = paramString1;
    this.uzZ = paramBoolean1;
    this.ima = paramInt1;
    this.uBM = paramInt2;
    this.uDr = bt.a(Boolean.valueOf(w.sB(paramaf.field_username)), false);
    this.uzt = paramBoolean4;
    this.uDq = paramBoolean5;
    this.uCr = paramLong;
    this.uBU = paramString2;
    this.uDL = false;
    if (paramaf.field_deleteFlag == 1)
    {
      paramBoolean1 = true;
      this.uBZ = paramBoolean1;
      this.uDK = this.imP.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
      this.uBv = this.imP.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.uDs = this.imP.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
      this.uDt = this.imP.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
      this.mLJ = this.imP.getIntent().getStringExtra("lbs_ticket");
      if (!u.se(paramaf.field_username))
      {
        com.tencent.mm.model.az.arV();
        if (!com.tencent.mm.model.c.apU().has(paramaf.field_username)) {
          break label321;
        }
      }
      this.uDu = new c();
      this.uDL = true;
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(27357);
      return true;
      paramBoolean1 = false;
      break;
      label321:
      if (af.aHE(paramaf.field_username))
      {
        this.uDu = new h();
      }
      else if (w.sQ(paramaf.field_username))
      {
        this.uDu = new d();
      }
      else if (w.sB(paramaf.field_username))
      {
        this.uDu = new g();
      }
      else if (af.aHF(paramaf.field_username))
      {
        this.uDu = new f();
      }
      else if ((com.tencent.mm.n.b.ls(paramaf.field_type)) && (!af.st(paramaf.field_username)))
      {
        this.uDu = new c();
        this.uDL = true;
      }
      else if (paramBoolean2)
      {
        this.uDu = new j();
        this.uDL = true;
      }
      else if ((paramBoolean3) || (af.st(paramaf.field_username)))
      {
        this.uDu = new b();
      }
      else
      {
        this.uDu = new c();
        this.uDL = true;
      }
    }
  }
  
  public final boolean bRu()
  {
    AppMethodBeat.i(27359);
    if (this.uDu != null) {
      this.uDu.onDetach();
    }
    this.gTG.removeAll();
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    AppMethodBeat.o(27359);
    return true;
  }
  
  public final boolean dcL()
  {
    AppMethodBeat.i(27358);
    if ((this.uDK) && (com.tencent.mm.n.b.ls(this.contact.field_type)))
    {
      this.uDI.setVisibility(0);
      AppMethodBeat.o(27358);
      return true;
    }
    this.uDI.setVisibility(8);
    AppMethodBeat.o(27358);
    return false;
  }
  
  public final void dcM()
  {
    AppMethodBeat.i(27361);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.imP, "android.permission.RECORD_AUDIO", 82, "", "");
    ad.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this.imP });
    if (!bool)
    {
      AppMethodBeat.o(27361);
      return;
    }
    ww localww = new ww();
    localww.dCp.djq = 5;
    localww.dCp.talker = this.contact.field_username;
    localww.dCp.context = this.imP;
    localww.dCp.dCj = 4;
    com.tencent.mm.sdk.b.a.ESL.l(localww);
    AppMethodBeat.o(27361);
  }
  
  public final void dcN()
  {
    AppMethodBeat.i(27362);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.imP, "android.permission.CAMERA", 19, "", "");
    ad.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this.imP });
    if (!bool)
    {
      AppMethodBeat.o(27362);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.imP, "android.permission.RECORD_AUDIO", 19, "", "");
    ad.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this.imP });
    if (!bool)
    {
      AppMethodBeat.o(27362);
      return;
    }
    ww localww = new ww();
    localww.dCp.djq = 5;
    localww.dCp.talker = this.contact.field_username;
    localww.dCp.context = this.imP;
    localww.dCp.dCj = 2;
    com.tencent.mm.sdk.b.a.ESL.l(localww);
    AppMethodBeat.o(27362);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27356);
    ad.d("MicroMsg.NormalUserFooterPreference", "on bindView " + paramView.toString());
    this.uDv = paramView.findViewById(2131298633);
    this.uDw = ((Button)paramView.findViewById(2131298664));
    this.uDx = ((Button)paramView.findViewById(2131298608));
    this.uDA = ((Button)paramView.findViewById(2131298666));
    this.uDB = ((TextView)paramView.findViewById(2131298670));
    this.uDz = paramView.findViewById(2131298667);
    this.uDy = ((Button)paramView.findViewById(2131298665));
    this.uDF = ((Button)paramView.findViewById(2131298596));
    this.uDC = paramView.findViewById(2131298639);
    this.uDD = ((Button)paramView.findViewById(2131298638));
    this.uDE = ((Button)paramView.findViewById(2131298640));
    this.fPz = ((Button)paramView.findViewById(2131298641));
    this.uDI = ((Button)paramView.findViewById(2131298629));
    this.uDG = ((Button)paramView.findViewById(2131298668));
    this.uDH = ((Button)paramView.findViewById(2131298605));
    this.uDJ = ((TextView)paramView.findViewById(2131298630));
    this.paC = true;
    initView();
    super.onBindView(paramView);
    if ((this.imP.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) == true) && (this.uDw != null)) {
      this.uDw.performClick();
    }
    AppMethodBeat.o(27356);
  }
  
  abstract class a
    implements com.tencent.mm.al.g, com.tencent.mm.pluginsdk.f.a.a
  {
    boolean isDeleteCancel = false;
    private e uyZ = null;
    
    public a() {}
    
    final void Gl(String paramString)
    {
      NormalUserFooterPreference.a(NormalUserFooterPreference.this).Zl();
      if (af.aHH(paramString))
      {
        ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).Be(paramString);
        ar.a.gMW.tY(paramString);
        return;
      }
      ((com.tencent.mm.pluginsdk.f.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.f.a.class)).Gl(paramString);
    }
    
    protected final void S(final boolean paramBoolean1, final boolean paramBoolean2)
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
          paramAnonymousMenuItem.HrY = new n.d()
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
                NormalUserFooterPreference.a.this.aky(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
                AppMethodBeat.o(27305);
                return;
              case 8: 
                NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this);
                AppMethodBeat.o(27305);
                return;
              }
              paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext;
              Context localContext = NormalUserFooterPreference.this.mContext;
              if (af.aHH(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {}
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
          paramAnonymousMenuItem.HrX = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(27306);
              if (!NormalUserFooterPreference.a.10.this.uDQ)
              {
                if (!af.aHH(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
                  break label95;
                }
                paramAnonymous2l.aI(1, 2131757927, 2131689826);
              }
              while (!NormalUserFooterPreference.a.10.this.uDR) {
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ZM())
                {
                  paramAnonymous2l.aI(8, 2131757741, 2131689795);
                  AppMethodBeat.o(27306);
                  return;
                  label95:
                  paramAnonymous2l.aI(1, 2131757731, 2131689826);
                }
                else if (!w.sC(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2l.aI(5, 2131757736, 2131689795);
                }
              }
              AppMethodBeat.o(27306);
            }
          };
          paramAnonymousMenuItem.csG();
          AppMethodBeat.o(27307);
          return true;
        }
      });
    }
    
    public final void a(String paramString, int paramInt, bwz parambwz)
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
            ad.i("MicroMsg.NormalUserFooterPreference", "add scene unkown, check the contact getsource: " + NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource());
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
          com.tencent.mm.plugin.profile.b.hYt.p(paramString, NormalUserFooterPreference.this.mContext);
          return;
          parambwz = com.tencent.mm.plugin.account.a.getQQListStg().Cr(paramString);
          if (parambwz == null) {
            break;
          }
          parambwz.ilC = 1;
          com.tencent.mm.plugin.account.a.getQQListStg().a(parambwz.ilB, parambwz);
          break;
          parambwz = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(paramString);
          if ((parambwz != null) && (!bt.isNullOrNil(parambwz.ijL)))
          {
            parambwz.status = 1;
            com.tencent.mm.plugin.account.a.getAddrUploadStg().a(parambwz.JS(), parambwz);
          }
          t.J(NormalUserFooterPreference.this.mContext, paramString);
          break;
          t.J(NormalUserFooterPreference.this.mContext, paramString);
          break;
          parambwz = com.tencent.mm.plugin.account.a.getFacebookFrdStg();
          Object localObject3 = "select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + paramString + "\"";
          localObject3 = parambwz.gPa.a((String)localObject3, null, 2);
          if (localObject3 == null) {
            parambwz = localObject1;
          }
          while (parambwz != null)
          {
            parambwz.status = 100;
            com.tencent.mm.plugin.account.a.getFacebookFrdStg().a(parambwz);
            break;
            parambwz = localObject2;
            if (((Cursor)localObject3).moveToFirst())
            {
              parambwz = new com.tencent.mm.plugin.account.friend.a.g();
              parambwz.convertFrom((Cursor)localObject3);
            }
            ((Cursor)localObject3).close();
          }
          com.tencent.mm.plugin.account.a.getGoogleFriendStorage().av(paramString, 2);
          break;
          ad.i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
          t.J(NormalUserFooterPreference.this.mContext, paramString);
        }
        label453:
        NormalUserFooterPreference.b(NormalUserFooterPreference.this).setResult(-1, NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().putExtra("_delete_ok_", true));
        ((Activity)NormalUserFooterPreference.this.mContext).finish();
        return;
      }
      if (!bt.isNullOrNil(parambwz.gKr))
      {
        com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.b(NormalUserFooterPreference.this), parambwz.gKr, parambwz.Title, true);
        return;
      }
      com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755708), "", true);
    }
    
    final void aky(String paramString)
    {
      if (bt.isNullOrNil(paramString))
      {
        ad.w("MicroMsg.NormalUserFooterPreference", "mod stranger remark, username is null");
        return;
      }
      paramString = new Intent();
      paramString.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
      paramString.putExtra("Contact_mode_name_type", 0);
      paramString.putExtra("Contact_ModStrangerRemark", true);
      paramString.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      paramString.putExtra("Contact_Nick", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_nickname);
      paramString.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_conRemark);
      com.tencent.mm.plugin.profile.b.hYt.n(paramString, NormalUserFooterPreference.this.mContext);
    }
    
    protected void apt()
    {
      dcO();
      dcQ();
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27308);
          ad.i("MicroMsg.NormalUserFooterPreference", "sendButton onClick %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
          Object localObject;
          Intent localIntent;
          if (NormalUserFooterPreference.e(NormalUserFooterPreference.this))
          {
            paramAnonymousView = NormalUserFooterPreference.a.this;
            localObject = NormalUserFooterPreference.a(paramAnonymousView.uDM).field_username;
            localIntent = new Intent();
            localIntent.addFlags(67108864);
            if (NormalUserFooterPreference.n(paramAnonymousView.uDM))
            {
              localIntent.putExtra("Chat_User", (String)localObject);
              localIntent.putExtra("Chat_Mode", 1);
              ((Activity)paramAnonymousView.uDM.mContext).setResult(-1, localIntent);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent())), Integer.valueOf(4), Integer.valueOf(1), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
            AppMethodBeat.o(27308);
            return;
            localIntent.putExtra("Chat_User", (String)localObject);
            localIntent.putExtra("Chat_Mode", 1);
            com.tencent.mm.plugin.profile.b.hYt.d(localIntent, paramAnonymousView.uDM.mContext);
            continue;
            paramAnonymousView = NormalUserFooterPreference.a.this;
            localObject = new Intent();
            ((Intent)localObject).addFlags(67108864);
            if (NormalUserFooterPreference.n(paramAnonymousView.uDM))
            {
              ((Intent)localObject).putExtra("Chat_User", NormalUserFooterPreference.a(paramAnonymousView.uDM).field_username);
              ((Intent)localObject).putExtra("Chat_Mode", 1);
              ((Activity)paramAnonymousView.uDM.mContext).setResult(-1, (Intent)localObject);
            }
            else
            {
              ((Intent)localObject).putExtra("Chat_User", NormalUserFooterPreference.a(paramAnonymousView.uDM).field_username);
              ((Intent)localObject).putExtra("Chat_Mode", 1);
              com.tencent.mm.plugin.profile.b.hYt.d((Intent)localObject, paramAnonymousView.uDM.mContext);
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
          com.tencent.mm.bs.d.b(NormalUserFooterPreference.b(NormalUserFooterPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymousView);
          AppMethodBeat.o(27309);
        }
      });
      NormalUserFooterPreference.h(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27310);
          paramAnonymousView = NormalUserFooterPreference.a.this;
          Object localObject = new wv();
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
          int i;
          if ((!NormalUserFooterPreference.a(paramAnonymousView.uDM).field_username.equals(((wv)localObject).dCl.talker)) && ((((wv)localObject).dCl.dCn) || (((wv)localObject).dCl.dCo))) {
            if (((wv)localObject).dCl.dCm)
            {
              i = 2131756778;
              Toast.makeText(NormalUserFooterPreference.b(paramAnonymousView.uDM).getContext(), i, 0).show();
              ad.i("MicroMsg.NormalUserFooterPreference", "voip is running, can't do this");
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent())), Integer.valueOf(5), Integer.valueOf(1), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
            AppMethodBeat.o(27310);
            return;
            i = 2131756779;
            break;
            if (!com.tencent.mm.r.a.cc(NormalUserFooterPreference.b(paramAnonymousView.uDM)))
            {
              localObject = new vj();
              ((vj)localObject).dAP.dAR = true;
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
              localObject = ((vj)localObject).dAQ.dAT;
              if (!bt.isNullOrNil((String)localObject))
              {
                ad.v("MicroMsg.NormalUserFooterPreference", "Talkroom is on: ".concat(String.valueOf(localObject)));
                com.tencent.mm.ui.base.h.d(NormalUserFooterPreference.b(paramAnonymousView.uDM), NormalUserFooterPreference.b(paramAnonymousView.uDM).getString(2131764350), "", NormalUserFooterPreference.b(paramAnonymousView.uDM).getString(2131755835), NormalUserFooterPreference.b(paramAnonymousView.uDM).getString(2131755691), new NormalUserFooterPreference.a.2(paramAnonymousView), new NormalUserFooterPreference.a.3(paramAnonymousView));
              }
              else
              {
                paramAnonymousView.dcR();
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
    
    protected abstract void dcO();
    
    protected final void dcP()
    {
      NormalUserFooterPreference.b(NormalUserFooterPreference.this).addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27296);
          paramAnonymousMenuItem = new e(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
          paramAnonymousMenuItem.HrY = new n.d()
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
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ZO())
                {
                  w.r(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  com.tencent.mm.ui.base.h.cf(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757891));
                }
                for (;;)
                {
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this;
                  com.tencent.mm.model.az.arV();
                  NormalUserFooterPreference.a(paramAnonymous2MenuItem, com.tencent.mm.model.c.apM().aHY(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
                  AppMethodBeat.o(27294);
                  return;
                  w.q(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  com.tencent.mm.ui.base.h.cf(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757665));
                }
                paramAnonymous2MenuItem = new Intent();
                paramAnonymous2MenuItem.putExtra("sns_permission_userName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
                paramAnonymous2MenuItem.putExtra("sns_permission_anim", true);
                paramAnonymous2MenuItem.putExtra("sns_permission_block_scene", 1);
                com.tencent.mm.bs.d.b(NormalUserFooterPreference.b(NormalUserFooterPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymous2MenuItem);
                AppMethodBeat.o(27294);
                return;
                paramAnonymous2MenuItem = NormalUserFooterPreference.a.this;
                Object localObject1 = new Intent();
                ((Intent)localObject1).putExtra("Select_Talker_Name", NormalUserFooterPreference.a(paramAnonymous2MenuItem.uDM).field_username);
                ((Intent)localObject1).putExtra("Select_block_List", NormalUserFooterPreference.a(paramAnonymous2MenuItem.uDM).field_username);
                ((Intent)localObject1).putExtra("Select_Conv_Type", 3);
                ((Intent)localObject1).putExtra("Select_Send_Card", true);
                ((Intent)localObject1).putExtra("mutil_select_is_ret", true);
                com.tencent.mm.plugin.profile.b.hYt.a((Intent)localObject1, NormalUserFooterPreference.b(paramAnonymous2MenuItem.uDM));
                AppMethodBeat.o(27294);
                return;
                NormalUserFooterPreference.this.gTG.dR("hide_btn");
                NormalUserFooterPreference.this.gTG.doNotify();
                NormalUserFooterPreference.a locala = NormalUserFooterPreference.a.this;
                paramAnonymous2MenuItem = locala.uDM;
                com.tencent.mm.model.az.arV();
                NormalUserFooterPreference.a(paramAnonymous2MenuItem, com.tencent.mm.model.c.apM().aHY(NormalUserFooterPreference.a(locala.uDM).field_username));
                if (!com.tencent.mm.n.b.ls(NormalUserFooterPreference.a(locala.uDM).field_type))
                {
                  locala.aky(NormalUserFooterPreference.a(locala.uDM).field_username);
                  AppMethodBeat.o(27294);
                  return;
                }
                Intent localIntent = new Intent();
                localIntent.putExtra("Contact_Scene", NormalUserFooterPreference.l(locala.uDM));
                localIntent.putExtra("Contact_User", NormalUserFooterPreference.a(locala.uDM).field_username);
                localIntent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(locala.uDM).getIntent().getStringExtra("Contact_RoomNickname"));
                localIntent.putExtra("contact_phone_number_list", NormalUserFooterPreference.a(locala.uDM).evO);
                Object localObject2 = "";
                localObject1 = localObject2;
                String str;
                if (!NormalUserFooterPreference.a(locala.uDM).ZT())
                {
                  localObject1 = NormalUserFooterPreference.b(locala.uDM).getIntent().getStringExtra("Contact_Mobile_MD5");
                  str = NormalUserFooterPreference.b(locala.uDM).getIntent().getStringExtra("Contact_full_Mobile_MD5");
                  if ((!bt.isNullOrNil((String)localObject1)) || (!bt.isNullOrNil(str))) {
                    break label803;
                  }
                  paramAnonymous2MenuItem = localObject3;
                  if (!bt.isNullOrNil(NormalUserFooterPreference.a(locala.uDM).field_username)) {
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(NormalUserFooterPreference.a(locala.uDM).field_username);
                  }
                }
                for (;;)
                {
                  localObject1 = localObject2;
                  if (paramAnonymous2MenuItem != null)
                  {
                    localObject1 = localObject2;
                    if (!bt.isNullOrNil(paramAnonymous2MenuItem.JS())) {
                      localObject1 = bt.nullAsNil(paramAnonymous2MenuItem.aIA()).replace(" ", "");
                    }
                  }
                  localIntent.putExtra("contact_phone_number_by_md5", (String)localObject1);
                  com.tencent.mm.plugin.profile.b.hYt.m(localIntent, locala.uDM.mContext);
                  AppMethodBeat.o(27294);
                  return;
                  label803:
                  if (bt.isNullOrNil((String)localObject1))
                  {
                    paramAnonymous2MenuItem = localObject3;
                    if (bt.isNullOrNil(str)) {}
                  }
                  else
                  {
                    localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf((String)localObject1);
                    if (localObject1 != null)
                    {
                      paramAnonymous2MenuItem = (MenuItem)localObject1;
                      if (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).JS())) {}
                    }
                    else
                    {
                      paramAnonymous2MenuItem = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf(str);
                    }
                  }
                }
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ZM())
                {
                  NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this);
                  AppMethodBeat.o(27294);
                  return;
                }
                paramAnonymous2MenuItem = View.inflate(NormalUserFooterPreference.this.mContext, 2131494763, null);
                paramAnonymous2MenuItem.setPadding(0, 0, 0, 0);
                localObject1 = (TextView)paramAnonymous2MenuItem.findViewById(2131302306);
                ((TextView)localObject1).setPadding(0, 0, 0, 0);
                if (af.aHH(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
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
                        if (this.uzu.isChecked()) {
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
                if (w.sB(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext.getString(2131758022, new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).ZX() });
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
                      NormalUserFooterPreference.a.this.dcS();
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
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext.getString(2131758020, new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).ZX() });
                  break;
                  label1487:
                  paramAnonymous2MenuItem.setVisibility(8);
                  ((TextView)localObject2).setVisibility(8);
                }
                paramAnonymous2MenuItem = NormalUserFooterPreference.a.this;
                ad.d("MicroMsg.NormalUserFooterPreference", "dealAddShortcut, username = " + NormalUserFooterPreference.a(paramAnonymous2MenuItem.uDM).field_username);
                com.tencent.mm.plugin.base.model.b.Y(NormalUserFooterPreference.b(paramAnonymous2MenuItem.uDM), NormalUserFooterPreference.a(paramAnonymous2MenuItem.uDM).field_username);
                com.tencent.mm.sdk.platformtools.aq.n(new NormalUserFooterPreference.a.9(paramAnonymous2MenuItem), 1000L);
                AppMethodBeat.o(27294);
                return;
                NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
              }
            }
          };
          paramAnonymousMenuItem.HrX = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(27295);
              com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent())), Integer.valueOf(7), Integer.valueOf(1), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              if (af.aHH(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
              {
                paramAnonymous2l.aI(1, 2131757927, 2131689826);
                if (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).ZO()) {
                  break label318;
                }
                str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getResources().getString(2131757890);
                label151:
                paramAnonymous2l.a(2, str, 2131689829);
                if (!af.aHH(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
                  paramAnonymous2l.aI(3, 2131757747, 2131689817);
                }
                paramAnonymous2l.aI(4, 2131757808, 2131689831);
                paramAnonymous2l.aI(9, 2131756596, 2131689799);
                if (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).ZM()) {
                  break label343;
                }
              }
              label318:
              label343:
              for (String str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757741);; str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757736))
              {
                paramAnonymous2l.a(5, str, 2131689795);
                if (!NormalUserFooterPreference.c(NormalUserFooterPreference.this)) {
                  paramAnonymous2l.aI(6, 2131756457, 2131689802);
                }
                paramAnonymous2l.aI(7, 2131757578, 2131689803);
                AppMethodBeat.o(27295);
                return;
                paramAnonymous2l.aI(1, 2131757731, 2131689826);
                break;
                str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getResources().getString(2131757664);
                break label151;
              }
            }
          };
          paramAnonymousMenuItem.csG();
          AppMethodBeat.o(27296);
          return true;
        }
      });
    }
    
    protected void dcQ()
    {
      if (NormalUserFooterPreference.d(NormalUserFooterPreference.this)) {
        NormalUserFooterPreference.b(NormalUserFooterPreference.this).showOptionMenu(false);
      }
      do
      {
        do
        {
          return;
        } while (u.aqG().equals(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
        if (!com.tencent.mm.n.b.ls(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) {
          break;
        }
      } while (w.tg(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
      dcP();
      return;
      S(false, false);
    }
    
    final void dcR()
    {
      this.uyZ = new e(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
      this.uyZ.HrX = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(27299);
          paramAnonymousl.aI(2, 2131755762, 2131691164);
          paramAnonymousl.aI(1, 2131755764, 2131691165);
          AppMethodBeat.o(27299);
        }
      };
      this.uyZ.HrY = new n.d()
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
            NormalUserFooterPreference.this.dcM();
            AppMethodBeat.o(27300);
            return;
            NormalUserFooterPreference.this.dcN();
          }
        }
      };
      this.uyZ.csG();
    }
    
    protected final void dcS()
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(2), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
      final String str = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
      if (w.sB(str))
      {
        NormalUserFooterPreference.a(NormalUserFooterPreference.this).Zl();
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.apL().c(new com.tencent.mm.bb.c(str));
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.apM().aIf(str);
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.apV().tN(str);
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
      for (localObject = com.tencent.mm.pluginsdk.wallet.d.aCU(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);; localObject = null)
      {
        if (!bt.isNullOrNil((String)localObject))
        {
          localp.dismiss();
          com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, false, NormalUserFooterPreference.this.mContext.getString(2131765236, new Object[] { localObject }), null, NormalUserFooterPreference.this.mContext.getString(2131760081), NormalUserFooterPreference.this.mContext.getString(2131758036), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27301);
              com.tencent.mm.plugin.report.service.h.vKh.f(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(4), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              NormalUserFooterPreference.a.this.isDeleteCancel = true;
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("Chat_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
              paramAnonymousDialogInterface.addFlags(67108864);
              com.tencent.mm.bs.d.e(NormalUserFooterPreference.this.mContext, ".ui.chatting.ChattingUI", paramAnonymousDialogInterface);
              AppMethodBeat.o(27301);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27302);
              com.tencent.mm.plugin.report.service.h.vKh.f(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(3), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              localp.show();
              NormalUserFooterPreference.a.this.isDeleteCancel = false;
              NormalUserFooterPreference.a.this.Gl(str);
              AppMethodBeat.o(27302);
            }
          }, -1, 2131099904);
          return;
        }
        Gl(str);
        return;
      }
    }
    
    protected void onDetach()
    {
      ((com.tencent.mm.pluginsdk.f.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.f.a.class)).b(this);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      ad.i("MicroMsg.NormalUserFooterPreference", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    }
  }
  
  final class b
    extends NormalUserFooterPreference.c
  {
    public b()
    {
      super();
    }
    
    protected final void dcO()
    {
      AppMethodBeat.i(27317);
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      if ((!com.tencent.mm.n.b.ls(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) || ((com.tencent.mm.n.b.ls(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) && (af.st(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))))
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
              NormalUserFooterPreference.b.this.dcT();
              AppMethodBeat.o(27314);
            }
          });
        }
        NormalUserFooterPreference.A(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(27315);
            if ((NormalUserFooterPreference.c(NormalUserFooterPreference.this)) && (com.tencent.mm.bq.a.euw()))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Chat_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername);
              paramAnonymousView.putExtra("lbs_mode", true);
              paramAnonymousView.putExtra("lbs_ticket", NormalUserFooterPreference.C(NormalUserFooterPreference.this));
              paramAnonymousView.putExtra("add_scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              com.tencent.mm.plugin.profile.b.hYt.d(paramAnonymousView, NormalUserFooterPreference.b(NormalUserFooterPreference.this));
              AppMethodBeat.o(27315);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
            paramAnonymousView.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
            paramAnonymousView.putExtra(e.c.FHR, NormalUserFooterPreference.a(NormalUserFooterPreference.this).evP);
            com.tencent.mm.plugin.profile.b.hYt.a(paramAnonymousView, NormalUserFooterPreference.this.mContext);
            AppMethodBeat.o(27315);
          }
        });
        AppMethodBeat.o(27317);
        return;
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
        if ((NormalUserFooterPreference.this.dcL()) || (NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(u.aqG()))) {
          break;
        }
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
      }
    }
    
    protected final void dcQ()
    {
      AppMethodBeat.i(27316);
      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this) == null)
      {
        ad.e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
        AppMethodBeat.o(27316);
        return;
      }
      if ((!com.tencent.mm.n.b.ls(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) || ((com.tencent.mm.n.b.ls(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) && (af.st(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))))
      {
        if (af.st(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
        {
          S(true, true);
          AppMethodBeat.o(27316);
          return;
        }
        S(false, true);
        AppMethodBeat.o(27316);
        return;
      }
      dcP();
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
    
    private void dcU()
    {
      AppMethodBeat.i(27327);
      Object localObject2 = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("Contact_Mobile_MD5");
      Object localObject1 = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("Contact_full_Mobile_MD5");
      String str = bt.nullAsNil((String)localObject2);
      localObject1 = bt.nullAsNil((String)localObject1);
      if ((!str.equals("")) || (!((String)localObject1).equals("")))
      {
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf(str);
        if (localObject2 != null) {
          break label113;
        }
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf((String)localObject1);
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
    
    protected final void apt()
    {
      AppMethodBeat.i(27323);
      super.apt();
      AppMethodBeat.o(27323);
    }
    
    protected void dcO()
    {
      AppMethodBeat.i(27325);
      boolean bool;
      if (!w.to(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
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
            NormalUserFooterPreference.c.this.dcS();
            AppMethodBeat.o(27318);
          }
        });
        if (!com.tencent.mm.n.b.ls(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) {
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
            if (!bt.isNullOrNil(paramAnonymousView))
            {
              bh localbh = new bh();
              localbh.ia(paramAnonymousView);
              localbh.dPt = 0L;
              localbh.dPv = 1L;
              localbh.aBj();
            }
          }
          NormalUserFooterPreference.c.this.dcT();
          if (NormalUserFooterPreference.E(NormalUserFooterPreference.this) != 0) {
            com.tencent.mm.plugin.report.service.h.vKh.f(11263, new Object[] { Integer.valueOf(NormalUserFooterPreference.E(NormalUserFooterPreference.this)), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
          }
          AppMethodBeat.o(27319);
        }
      });
      if (!com.tencent.mm.n.b.ls(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type))
      {
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(0);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.g(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
        if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ZM())
        {
          NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(0);
          AppMethodBeat.o(27325);
        }
      }
      else
      {
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
        if ((!NormalUserFooterPreference.this.dcL()) && (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(u.aqG())) && (!w.to(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!w.tg(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!af.aHH(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!w.sC(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))) {
          NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
        }
        for (;;)
        {
          com.tencent.mm.model.az.arV();
          if (!com.tencent.mm.model.c.apM().aIc(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
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
    
    protected final void dcT()
    {
      AppMethodBeat.i(27326);
      if ((int)NormalUserFooterPreference.a(NormalUserFooterPreference.this).fId == 0)
      {
        com.tencent.mm.model.az.arV();
        if (com.tencent.mm.model.c.apM().ag(NormalUserFooterPreference.a(NormalUserFooterPreference.this)) != -1)
        {
          localObject = NormalUserFooterPreference.this;
          com.tencent.mm.model.az.arV();
          NormalUserFooterPreference.a((NormalUserFooterPreference)localObject, com.tencent.mm.model.c.apM().aHY(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
        }
      }
      if ((NormalUserFooterPreference.F(NormalUserFooterPreference.this)) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 12))
      {
        ad.d("MicroMsg.NormalUserFooterPreference", "qqNum " + NormalUserFooterPreference.G(NormalUserFooterPreference.this) + " qqReamrk " + NormalUserFooterPreference.H(NormalUserFooterPreference.this));
        if ((NormalUserFooterPreference.G(NormalUserFooterPreference.this) != 0L) && (NormalUserFooterPreference.H(NormalUserFooterPreference.this) != null) && (!NormalUserFooterPreference.H(NormalUserFooterPreference.this).equals("")))
        {
          localObject = com.tencent.mm.plugin.account.a.getQQListStg().mN(NormalUserFooterPreference.G(NormalUserFooterPreference.this));
          if (localObject != null) {
            break label452;
          }
          localObject = new as();
          ((as)localObject).nickname = "";
          ((as)localObject).ilB = NormalUserFooterPreference.G(NormalUserFooterPreference.this);
          ((as)localObject).ilJ = NormalUserFooterPreference.H(NormalUserFooterPreference.this);
          ((as)localObject).username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
          ((as)localObject).aJo();
          com.tencent.mm.plugin.account.a.getQQListStg().a((as)localObject);
        }
      }
      final com.tencent.mm.pluginsdk.ui.applet.a locala;
      final LinkedList localLinkedList;
      final String str;
      for (;;)
      {
        dcU();
        locala = new com.tencent.mm.pluginsdk.ui.applet.a(NormalUserFooterPreference.this.mContext, new com.tencent.mm.pluginsdk.ui.applet.a.a()
        {
          public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(27320);
            if (paramAnonymousBoolean1)
            {
              NormalUserFooterPreference.this.gTG.dR("hide_btn");
              NormalUserFooterPreference.this.gTG.doNotify();
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
                  com.tencent.mm.plugin.report.service.h.vKh.f(10991, new Object[] { Integer.valueOf(i), Integer.valueOf(6), Integer.valueOf(j) });
                }
              }
              AppMethodBeat.o(27320);
              return;
              if (paramAnonymousBoolean2)
              {
                com.tencent.mm.bk.d.aCo().fM(paramAnonymousString1, 2);
                com.tencent.mm.plugin.account.friend.a.au.ax(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername, 1);
                paramAnonymousString1 = new pp();
                paramAnonymousString1.dvq.username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername;
                paramAnonymousString1.dvq.type = 1;
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString1);
              }
              else
              {
                ad.e("MicroMsg.NormalUserFooterPreference", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(paramAnonymousString1)));
              }
            }
          }
        });
        localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(NormalUserFooterPreference.l(NormalUserFooterPreference.this)));
        localObject = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("source_from_user_name");
        str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("source_from_nick_name");
        locala.kA((String)localObject, str);
        locala.BXs = new a.b()
        {
          public final boolean at(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(27321);
            String str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("room_name");
            int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pxj, 0);
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
              ((Intent)localObject).putExtra("source_from_user_name", this.uzi);
              ((Intent)localObject).putExtra("source_from_nick_name", str);
              ((Intent)localObject).putExtra("sayhi_with_sns_perm_send_verify", true);
              ((Intent)localObject).putExtra("sayhi_with_sns_perm_add_remark", true);
              ((Intent)localObject).putExtra("sayhi_with_sns_perm_set_label", false);
              ((Intent)localObject).putExtra(e.c.FHR, paramAnonymousString);
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
        localObject = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra(e.c.FHR);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        ad.i("MicroMsg.NormalUserFooterPreference", "add contact case 1:%s", new Object[] { localObject });
        locala.aBJ((String)localObject);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, "", localLinkedList);
        AppMethodBeat.o(27326);
        return;
        label452:
        ((as)localObject).ilB = NormalUserFooterPreference.G(NormalUserFooterPreference.this);
        ((as)localObject).ilJ = NormalUserFooterPreference.H(NormalUserFooterPreference.this);
        ((as)localObject).username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
        ((as)localObject).aJo();
        com.tencent.mm.plugin.account.a.getQQListStg().a(NormalUserFooterPreference.G(NormalUserFooterPreference.this), (as)localObject);
        continue;
        if ((NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 58) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 59) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 60)) {
          com.tencent.mm.plugin.account.a.getGoogleFriendStorage().av(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, 1);
        }
      }
      if (TextUtils.isEmpty(str))
      {
        ad.i("MicroMsg.NormalUserFooterPreference", "add contact case 2, %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).evP });
        locala.aBJ(NormalUserFooterPreference.a(NormalUserFooterPreference.this).evP);
        locala.i(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      if (!TextUtils.isEmpty(locala.rso))
      {
        ad.i("MicroMsg.NormalUserFooterPreference", "add contact case 3, %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).evP });
        locala.aBJ(NormalUserFooterPreference.a(NormalUserFooterPreference.this).evP);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      com.tencent.mm.model.az.arV();
      Object localObject = com.tencent.mm.model.c.apM().aHY(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      if (localObject != null) {}
      for (localObject = bt.by(((com.tencent.mm.g.c.au)localObject).evP, "");; localObject = "")
      {
        ad.i("MicroMsg.NormalUserFooterPreference", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localObject });
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        locala.aBJ((String)localObject);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      ar.a.gMW.a(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27322);
          com.tencent.mm.model.az.arV();
          paramAnonymousString = com.tencent.mm.model.c.apM().aHY(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          if (paramAnonymousString != null) {}
          for (paramAnonymousString = bt.by(paramAnonymousString.evP, "");; paramAnonymousString = "")
          {
            locala.aBJ(paramAnonymousString);
            locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localLinkedList);
            AppMethodBeat.o(27322);
            return;
          }
        }
      });
      AppMethodBeat.o(27326);
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
    
    protected final void dcO()
    {
      AppMethodBeat.i(27329);
      Assert.assertTrue(w.sQ(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
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
    
    protected final void dcQ() {}
  }
  
  public static abstract interface e {}
  
  final class f
    extends NormalUserFooterPreference.a
  {
    public f()
    {
      super();
    }
    
    protected final void dcO()
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
          com.tencent.mm.plugin.normsg.a.b.ufs.am(1, 1, 5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          paramAnonymousView.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
          paramAnonymousView.putExtra(e.c.FHR, NormalUserFooterPreference.a(NormalUserFooterPreference.this).evP);
          com.tencent.mm.plugin.profile.b.hYt.a(paramAnonymousView, NormalUserFooterPreference.this.mContext);
          AppMethodBeat.o(27330);
        }
      });
      AppMethodBeat.o(27332);
    }
    
    protected final void dcQ()
    {
      AppMethodBeat.i(27331);
      if ((NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) && (com.tencent.mm.n.b.ls(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)))
      {
        dcP();
        AppMethodBeat.o(27331);
        return;
      }
      S(false, true);
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
    
    protected final void dcO()
    {
      boolean bool2 = true;
      AppMethodBeat.i(27333);
      if (!u.se(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
      {
        bool1 = true;
        Assert.assertTrue(bool1);
        if (w.to(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
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
    
    public final void dcQ() {}
  }
  
  final class h
    extends NormalUserFooterPreference.a
  {
    public h()
    {
      super();
    }
    
    protected final void dcO()
    {
      AppMethodBeat.i(27334);
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
      if ((!NormalUserFooterPreference.this.dcL()) && (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(u.aqG())) && (!w.to(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!w.tg(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))) {
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
    
    protected final void dcQ() {}
  }
  
  class i
    extends NormalUserFooterPreference.c
    implements com.tencent.mm.al.g
  {
    private ProgressDialog fpP;
    
    public i()
    {
      super();
    }
    
    private void Zk()
    {
      AppMethodBeat.i(27341);
      NormalUserFooterPreference localNormalUserFooterPreference = NormalUserFooterPreference.this;
      com.tencent.mm.model.az.arV();
      af localaf2 = com.tencent.mm.model.c.apM().aHY(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      if (localaf2 != null)
      {
        localaf1 = localaf2;
        if ((int)localaf2.fId != 0) {}
      }
      else
      {
        localaf1 = NormalUserFooterPreference.a(NormalUserFooterPreference.this);
        com.tencent.mm.model.az.arV();
        if (com.tencent.mm.model.c.apM().ae(localaf1)) {
          break label131;
        }
        ad.e("MicroMsg.NormalUserFooterPreference", "insert contact failed, username = " + localaf1.field_username);
      }
      for (af localaf1 = null;; localaf1 = com.tencent.mm.model.c.apM().aHY(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
      {
        NormalUserFooterPreference.a(localNormalUserFooterPreference, localaf1);
        if (NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) {
          w.u(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
        }
        AppMethodBeat.o(27341);
        return;
        label131:
        com.tencent.mm.model.az.arV();
      }
    }
    
    protected void dcO()
    {
      AppMethodBeat.i(27338);
      onDetach();
      onStop();
      com.tencent.mm.model.az.aeS().a(30, this);
      com.tencent.mm.model.az.aeS().a(667, this);
      com.tencent.mm.model.az.aeS().a(853, this);
      super.dcO();
      AppMethodBeat.o(27338);
    }
    
    protected void dcV()
    {
      AppMethodBeat.i(27342);
      if (NormalUserFooterPreference.u(NormalUserFooterPreference.this) != null) {
        NormalUserFooterPreference.u(NormalUserFooterPreference.this).onDetach();
      }
      NormalUserFooterPreference.a(NormalUserFooterPreference.this, new NormalUserFooterPreference.c(NormalUserFooterPreference.this));
      NormalUserFooterPreference.u(NormalUserFooterPreference.this).apt();
      AppMethodBeat.o(27342);
    }
    
    protected void onDetach()
    {
      AppMethodBeat.i(27340);
      if (this.fpP != null)
      {
        this.fpP.dismiss();
        this.fpP = null;
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
      ad.d("MicroMsg.NormalUserFooterPreference", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      if ((paramn.getType() != 30) && (paramn.getType() != 667) && (paramn.getType() != 853))
      {
        AppMethodBeat.o(27343);
        return;
      }
      onStop();
      if (this.fpP != null)
      {
        this.fpP.dismiss();
        this.fpP = null;
      }
      if (!bt.iM(NormalUserFooterPreference.this.mContext))
      {
        AppMethodBeat.o(27343);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn.getType() == 30)
        {
          paramInt1 = ((com.tencent.mm.pluginsdk.model.o)paramn).djq;
          ad.d("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, opCode = ".concat(String.valueOf(paramInt1)));
          if ((paramInt1 == 1) || (paramInt1 == 3))
          {
            paramString = ((com.tencent.mm.pluginsdk.model.o)paramn).BOW;
            if ((paramString != null) && (paramString.contains(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)))
            {
              NormalUserFooterPreference.v(NormalUserFooterPreference.this);
              Zk();
              dcV();
              paramString = paramString.iterator();
              while (paramString.hasNext()) {
                com.tencent.mm.pluginsdk.ui.preference.b.cj((String)paramString.next(), NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              }
              com.tencent.mm.model.az.getNotification().TU();
            }
          }
          AppMethodBeat.o(27343);
          return;
        }
        if ((paramn.getType() == 667) || (paramn.getType() == 853))
        {
          NormalUserFooterPreference.v(NormalUserFooterPreference.this);
          Zk();
          dcV();
          com.tencent.mm.pluginsdk.ui.preference.b.cj(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, NormalUserFooterPreference.l(NormalUserFooterPreference.this));
          com.tencent.mm.model.az.getNotification().TU();
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
      for (paramInt1 = ((com.tencent.mm.pluginsdk.model.o)paramn).djq;; paramInt1 = 0)
      {
        ad.w("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", new Object[] { Integer.valueOf(paramInt1) });
        if ((paramInt1 == 3) || (paramn.getType() == 853)) {
          com.tencent.mm.ui.base.h.d(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757894), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755906), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755272), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27337);
              NormalUserFooterPreference.i.this.dcT();
              AppMethodBeat.o(27337);
            }
          }, null);
        }
        AppMethodBeat.o(27343);
        return;
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!bt.isNullOrNil(paramString)))
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
          if (com.tencent.mm.model.az.aeS().auS())
          {
            com.tencent.mm.model.az.aeS().getNetworkServerIp();
            new StringBuilder().append(paramInt2);
            i = 1;
          }
          else
          {
            i = j;
            if (ae.cJ(NormalUserFooterPreference.this.mContext))
            {
              com.tencent.mm.pluginsdk.ui.tools.k.hm(NormalUserFooterPreference.this.mContext);
              i = 1;
              continue;
              Toast.makeText(NormalUserFooterPreference.this.mContext, NormalUserFooterPreference.this.mContext.getString(2131759511, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
              i = 1;
              continue;
              if (paramInt2 == -100)
              {
                com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, com.tencent.mm.model.az.aeq(), com.tencent.mm.cd.a.aq(NormalUserFooterPreference.this.mContext, 2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(27335);
                    NormalUserFooterPreference.i.this.onStop();
                    paramAnonymousDialogInterface = new Intent();
                    paramAnonymousDialogInterface.putExtra("Intro_Switch", true).addFlags(67108864);
                    com.tencent.mm.plugin.profile.b.hYt.p(paramAnonymousDialogInterface, NormalUserFooterPreference.this.mContext);
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
                    com.tencent.mm.plugin.profile.b.hYt.p(paramAnonymousDialogInterface, NormalUserFooterPreference.this.mContext);
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
                    if (!bt.isNullOrNil(paramString)) {}
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
      com.tencent.mm.model.az.aeS().b(30, this);
      com.tencent.mm.model.az.aeS().b(667, this);
      com.tencent.mm.model.az.aeS().b(853, this);
      AppMethodBeat.o(27339);
    }
  }
  
  final class j
    extends NormalUserFooterPreference.i
    implements com.tencent.mm.al.g
  {
    public j()
    {
      super();
    }
    
    protected final void dcO()
    {
      AppMethodBeat.i(27348);
      super.dcO();
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
      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ZM())
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
            int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pxj, 0);
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
            if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ZM())
            {
              w.n(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
              NormalUserFooterPreference.a(NormalUserFooterPreference.this).Zn();
              NormalUserFooterPreference.j.this.dcO();
              AppMethodBeat.o(27346);
              return;
            }
            paramAnonymousView = NormalUserFooterPreference.this.mContext;
            Context localContext = NormalUserFooterPreference.this.mContext;
            if (af.aHH(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {}
            for (int i = 2131757738;; i = 2131757737)
            {
              com.tencent.mm.ui.base.h.a(paramAnonymousView, localContext.getString(i), NormalUserFooterPreference.this.mContext.getString(2131757736), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(27345);
                  w.m(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  NormalUserFooterPreference.a(NormalUserFooterPreference.this).Zm();
                  NormalUserFooterPreference.j.this.dcO();
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
    
    protected final void dcQ()
    {
      AppMethodBeat.i(27347);
      if ((NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) && (com.tencent.mm.n.b.ls(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)))
      {
        dcP();
        AppMethodBeat.o(27347);
        return;
      }
      S(false, true);
      AppMethodBeat.o(27347);
    }
    
    protected final void dcV()
    {
      AppMethodBeat.i(27350);
      super.dcV();
      AppMethodBeat.o(27350);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference
 * JD-Core Version:    0.7.0.1
 */