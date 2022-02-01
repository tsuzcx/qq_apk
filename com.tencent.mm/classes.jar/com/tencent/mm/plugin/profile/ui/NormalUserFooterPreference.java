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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.b;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yg.a;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.b.a.dp;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  private an contact;
  private MMActivity fNT;
  public ProgressDialog fOC;
  private Button gpu;
  protected com.tencent.mm.sdk.e.l<e, String> hPq;
  private int jij;
  private String nUm;
  private boolean qnX;
  private String tIA;
  private boolean xfQ;
  private boolean xfh;
  private int xhF;
  private String xhN;
  private boolean xhS;
  private int xho;
  private long xik;
  private TextView xjA;
  private boolean xjB;
  public boolean xjC;
  private boolean xjh;
  private boolean xji;
  private boolean xjj;
  private boolean xjk;
  private a xjl;
  private View xjm;
  private Button xjn;
  private Button xjo;
  private Button xjp;
  private View xjq;
  private Button xjr;
  private TextView xjs;
  private View xjt;
  private Button xju;
  private Button xjv;
  private Button xjw;
  private Button xjx;
  private Button xjy;
  private Button xjz;
  
  public NormalUserFooterPreference(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(27352);
    this.xfh = false;
    this.xik = 0L;
    this.xhN = "";
    this.tIA = "";
    this.xhS = false;
    this.xjj = false;
    this.xjk = false;
    this.xjB = false;
    this.xho = 0;
    this.fOC = null;
    this.xjC = false;
    this.nUm = null;
    this.hPq = new com.tencent.mm.sdk.e.l() {};
    this.fNT = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27352);
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27353);
    this.xfh = false;
    this.xik = 0L;
    this.xhN = "";
    this.tIA = "";
    this.xhS = false;
    this.xjj = false;
    this.xjk = false;
    this.xjB = false;
    this.xho = 0;
    this.fOC = null;
    this.xjC = false;
    this.nUm = null;
    this.hPq = new com.tencent.mm.sdk.e.l() {};
    this.fNT = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27353);
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27354);
    this.xfh = false;
    this.xik = 0L;
    this.xhN = "";
    this.tIA = "";
    this.xhS = false;
    this.xjj = false;
    this.xjk = false;
    this.xjB = false;
    this.xho = 0;
    this.fOC = null;
    this.xjC = false;
    this.nUm = null;
    this.hPq = new com.tencent.mm.sdk.e.l() {};
    this.fNT = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27354);
  }
  
  private void init()
  {
    this.qnX = false;
    this.xjl = null;
  }
  
  private void initView()
  {
    AppMethodBeat.i(27355);
    if ((!this.qnX) || (this.contact == null))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.qnX + " contact = " + this.contact);
      if (this.xjl != null) {
        try
        {
          this.xjl.dEs();
          AppMethodBeat.o(27355);
          return;
        }
        catch (Throwable localThrowable) {}
      }
      AppMethodBeat.o(27355);
      return;
    }
    if (this.xjl != null) {
      this.xjl.azm();
    }
    dEn();
    AppMethodBeat.o(27355);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(27360);
    if (bu.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27360);
      return;
    }
    if ((this.contact != null) && ((paramString.equals(this.contact.field_username)) || (paramString.equals(this.contact.field_encryptUsername))))
    {
      bc.aCg();
      this.contact = com.tencent.mm.model.c.azF().BH(this.contact.field_username);
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27291);
          NormalUserFooterPreference.this.dEn();
          AppMethodBeat.o(27291);
        }
      });
    }
    AppMethodBeat.o(27360);
  }
  
  public final boolean a(an paraman, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2, boolean paramBoolean4, boolean paramBoolean5, long paramLong, String paramString2)
  {
    AppMethodBeat.i(27357);
    ceC();
    if (paraman != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bu.nullAsNil(paraman.field_username).length() <= 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!an.aUA(v.aAC()).equals(paraman.field_username)) {
        break label80;
      }
      AppMethodBeat.o(27357);
      return false;
      bool = false;
      break;
    }
    label80:
    this.contact = paraman;
    this.tIA = paramString1;
    this.xfQ = paramBoolean1;
    this.jij = paramInt1;
    this.xhF = paramInt2;
    this.xji = bu.a(Boolean.valueOf(x.Al(paraman.field_username)), false);
    this.xfh = paramBoolean4;
    this.xjh = paramBoolean5;
    this.xik = paramLong;
    this.xhN = paramString2;
    this.xjC = false;
    if (paraman.field_deleteFlag == 1)
    {
      paramBoolean1 = true;
      this.xhS = paramBoolean1;
      this.xjB = this.fNT.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
      this.xho = this.fNT.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.xjj = this.fNT.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
      this.xjk = this.fNT.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
      this.nUm = this.fNT.getIntent().getStringExtra("lbs_ticket");
      if (!v.zK(paraman.field_username))
      {
        bc.aCg();
        if (!com.tencent.mm.model.c.azO().has(paraman.field_username)) {
          break label321;
        }
      }
      this.xjl = new c();
      this.xjC = true;
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(27357);
      return true;
      paramBoolean1 = false;
      break;
      label321:
      if (an.aUn(paraman.field_username))
      {
        this.xjl = new h();
      }
      else if (x.AA(paraman.field_username))
      {
        this.xjl = new d();
      }
      else if (x.Al(paraman.field_username))
      {
        this.xjl = new g();
      }
      else if (an.aUo(paraman.field_username))
      {
        this.xjl = new f();
      }
      else if ((com.tencent.mm.contact.c.lO(paraman.field_type)) && (!an.Ac(paraman.field_username)))
      {
        this.xjl = new c();
        this.xjC = true;
      }
      else if (paramBoolean2)
      {
        this.xjl = new j();
        this.xjC = true;
      }
      else if ((paramBoolean3) || (an.Ac(paraman.field_username)))
      {
        this.xjl = new b();
      }
      else
      {
        this.xjl = new c();
        this.xjC = true;
      }
    }
  }
  
  public final boolean ceC()
  {
    AppMethodBeat.i(27359);
    if (this.xjl != null) {
      this.xjl.onDetach();
    }
    this.hPq.removeAll();
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    AppMethodBeat.o(27359);
    return true;
  }
  
  public final boolean dEn()
  {
    AppMethodBeat.i(27358);
    if ((this.xjB) && (com.tencent.mm.contact.c.lO(this.contact.field_type)))
    {
      this.xjz.setVisibility(0);
      AppMethodBeat.o(27358);
      return true;
    }
    this.xjz.setVisibility(8);
    AppMethodBeat.o(27358);
    return false;
  }
  
  public final void dEo()
  {
    AppMethodBeat.i(27361);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.fNT, "android.permission.RECORD_AUDIO", 82, "", "");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.fNT });
    if (!bool)
    {
      AppMethodBeat.o(27361);
      return;
    }
    yh localyh = new yh();
    localyh.dNE.dto = 5;
    localyh.dNE.talker = this.contact.field_username;
    localyh.dNE.context = this.fNT;
    localyh.dNE.dNA = 4;
    com.tencent.mm.sdk.b.a.IvT.l(localyh);
    AppMethodBeat.o(27361);
  }
  
  public final void dEp()
  {
    AppMethodBeat.i(27362);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.fNT, "android.permission.CAMERA", 19, "", "");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.fNT });
    if (!bool)
    {
      AppMethodBeat.o(27362);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.fNT, "android.permission.RECORD_AUDIO", 19, "", "");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.fNT });
    if (!bool)
    {
      AppMethodBeat.o(27362);
      return;
    }
    yh localyh = new yh();
    localyh.dNE.dto = 5;
    localyh.dNE.talker = this.contact.field_username;
    localyh.dNE.context = this.fNT;
    localyh.dNE.dNA = 2;
    com.tencent.mm.sdk.b.a.IvT.l(localyh);
    AppMethodBeat.o(27362);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27356);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NormalUserFooterPreference", "on bindView " + paramView.toString());
    this.xjm = paramView.findViewById(2131298633);
    this.xjn = ((Button)paramView.findViewById(2131298664));
    this.xjo = ((Button)paramView.findViewById(2131298608));
    this.xjr = ((Button)paramView.findViewById(2131298666));
    this.xjs = ((TextView)paramView.findViewById(2131298670));
    this.xjq = paramView.findViewById(2131298667);
    this.xjp = ((Button)paramView.findViewById(2131298665));
    this.xjw = ((Button)paramView.findViewById(2131298596));
    this.xjt = paramView.findViewById(2131298639);
    this.xju = ((Button)paramView.findViewById(2131298638));
    this.xjv = ((Button)paramView.findViewById(2131298640));
    this.gpu = ((Button)paramView.findViewById(2131298641));
    this.xjz = ((Button)paramView.findViewById(2131298629));
    this.xjx = ((Button)paramView.findViewById(2131298668));
    this.xjy = ((Button)paramView.findViewById(2131298605));
    this.xjA = ((TextView)paramView.findViewById(2131298630));
    this.qnX = true;
    initView();
    super.onBindView(paramView);
    if ((this.fNT.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) == true) && (this.xjn != null)) {
      this.xjn.performClick();
    }
    AppMethodBeat.o(27356);
  }
  
  abstract class a
    implements f, com.tencent.mm.pluginsdk.h.a.a
  {
    boolean isDeleteCancel = false;
    private e xeN = null;
    
    public a() {}
    
    final void Oq(String paramString)
    {
      NormalUserFooterPreference.a(NormalUserFooterPreference.this).acT();
      if (an.aUq(paramString))
      {
        ((r)com.tencent.mm.kernel.g.ab(r.class)).wr(paramString);
        au.a.hIG.Bu(paramString);
        return;
      }
      ((com.tencent.mm.pluginsdk.h.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.h.a.class)).Oq(paramString);
    }
    
    protected final void Y(final boolean paramBoolean1, final boolean paramBoolean2)
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
          paramAnonymousMenuItem.LfT = new n.e()
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
                NormalUserFooterPreference.a.this.avS(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
                AppMethodBeat.o(27305);
                return;
              case 8: 
                NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this);
                AppMethodBeat.o(27305);
                return;
              }
              paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext;
              Context localContext = NormalUserFooterPreference.this.mContext;
              if (an.aUq(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {}
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
          paramAnonymousMenuItem.LfS = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(27306);
              if (!NormalUserFooterPreference.a.10.this.xjH)
              {
                if (!an.aUq(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
                  break label95;
                }
                paramAnonymous2l.aM(1, 2131757927, 2131689826);
              }
              while (!NormalUserFooterPreference.a.10.this.xjI) {
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).adv())
                {
                  paramAnonymous2l.aM(8, 2131757741, 2131689795);
                  AppMethodBeat.o(27306);
                  return;
                  label95:
                  paramAnonymous2l.aM(1, 2131757731, 2131689826);
                }
                else if (!x.Am(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2l.aM(5, 2131757736, 2131689795);
                }
              }
              AppMethodBeat.o(27306);
            }
          };
          paramAnonymousMenuItem.cPF();
          AppMethodBeat.o(27307);
          return true;
        }
      });
    }
    
    public final void a(String paramString, int paramInt, che paramche)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      if (paramInt == 0)
      {
        if (!paramString.equals(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NormalUserFooterPreference", "not current contact %s,%s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, paramString });
          return;
        }
        switch (NormalUserFooterPreference.l(NormalUserFooterPreference.this))
        {
        default: 
          if (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 9)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NormalUserFooterPreference", "add scene unkown, check the contact getsource: " + NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource());
            switch (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource())
            {
            }
          }
          break;
        }
        for (;;)
        {
          if (NormalUserFooterPreference.o(NormalUserFooterPreference.this) != 0) {
            break label501;
          }
          paramString = new Intent();
          paramString.addFlags(67108864);
          com.tencent.mm.plugin.profile.b.iUz.p(paramString, NormalUserFooterPreference.this.mContext);
          return;
          paramche = com.tencent.mm.plugin.account.a.getQQListStg().Ki(paramString);
          if (paramche == null) {
            break;
          }
          paramche.jhL = 1;
          com.tencent.mm.plugin.account.a.getQQListStg().a(paramche.jhK, paramche);
          break;
          paramche = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(paramString);
          if ((paramche != null) && (!bu.isNullOrNil(paramche.jfU)))
          {
            paramche.status = 1;
            com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramche.Lj(), paramche);
          }
          t.K(NormalUserFooterPreference.this.mContext, paramString);
          break;
          t.K(NormalUserFooterPreference.this.mContext, paramString);
          break;
          paramche = com.tencent.mm.plugin.account.a.getFacebookFrdStg();
          Object localObject3 = "select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + paramString + "\"";
          localObject3 = paramche.hKK.a((String)localObject3, null, 2);
          if (localObject3 == null) {
            paramche = localObject1;
          }
          while (paramche != null)
          {
            paramche.status = 100;
            com.tencent.mm.plugin.account.a.getFacebookFrdStg().a(paramche);
            break;
            paramche = localObject2;
            if (((Cursor)localObject3).moveToFirst())
            {
              paramche = new com.tencent.mm.plugin.account.friend.a.g();
              paramche.convertFrom((Cursor)localObject3);
            }
            ((Cursor)localObject3).close();
          }
          com.tencent.mm.plugin.account.a.getGoogleFriendStorage().aC(paramString, 2);
          break;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
          t.K(NormalUserFooterPreference.this.mContext, paramString);
        }
        label501:
        NormalUserFooterPreference.b(NormalUserFooterPreference.this).setResult(-1, NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().putExtra("_delete_ok_", true));
        ((Activity)NormalUserFooterPreference.this.mContext).finish();
        return;
      }
      if (!bu.isNullOrNil(paramche.hFS))
      {
        com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.b(NormalUserFooterPreference.this), paramche.hFS, paramche.Title, true);
        return;
      }
      com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755708), "", true);
    }
    
    final void avS(String paramString)
    {
      if (bu.isNullOrNil(paramString))
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NormalUserFooterPreference", "mod stranger remark, username is null");
        return;
      }
      paramString = new Intent();
      paramString.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
      paramString.putExtra("Contact_mode_name_type", 0);
      paramString.putExtra("Contact_ModStrangerRemark", true);
      paramString.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      paramString.putExtra("Contact_Nick", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_nickname);
      paramString.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_conRemark);
      com.tencent.mm.plugin.profile.b.iUz.n(paramString, NormalUserFooterPreference.this.mContext);
    }
    
    protected void azm()
    {
      dEq();
      dEs();
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27308);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NormalUserFooterPreference", "sendButton onClick %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
          Intent localIntent;
          if (NormalUserFooterPreference.e(NormalUserFooterPreference.this))
          {
            paramAnonymousView = NormalUserFooterPreference.a.this;
            localObject = NormalUserFooterPreference.a(paramAnonymousView.xjD).field_username;
            localIntent = new Intent();
            localIntent.addFlags(67108864);
            if (NormalUserFooterPreference.n(paramAnonymousView.xjD))
            {
              localIntent.putExtra("Chat_User", (String)localObject);
              localIntent.putExtra("Chat_Mode", 1);
              ((Activity)paramAnonymousView.xjD.mContext).setResult(-1, localIntent);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent())), Integer.valueOf(4), Integer.valueOf(1), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27308);
            return;
            localIntent.putExtra("Chat_User", (String)localObject);
            localIntent.putExtra("Chat_Mode", 1);
            com.tencent.mm.plugin.profile.b.iUz.d(localIntent, paramAnonymousView.xjD.mContext);
            continue;
            paramAnonymousView = NormalUserFooterPreference.a.this;
            localObject = new Intent();
            ((Intent)localObject).addFlags(67108864);
            if (NormalUserFooterPreference.n(paramAnonymousView.xjD))
            {
              ((Intent)localObject).putExtra("Chat_User", NormalUserFooterPreference.a(paramAnonymousView.xjD).field_username);
              ((Intent)localObject).putExtra("Chat_Mode", 1);
              ((Activity)paramAnonymousView.xjD.mContext).setResult(-1, (Intent)localObject);
            }
            else
            {
              ((Intent)localObject).putExtra("Chat_User", NormalUserFooterPreference.a(paramAnonymousView.xjD).field_username);
              ((Intent)localObject).putExtra("Chat_Mode", 1);
              com.tencent.mm.plugin.profile.b.iUz.d((Intent)localObject, paramAnonymousView.xjD.mContext);
            }
          }
        }
      });
      NormalUserFooterPreference.g(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27309);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_permission_userName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          paramAnonymousView.putExtra("sns_permission_anim", true);
          paramAnonymousView.putExtra("sns_permission_block_scene", 4);
          com.tencent.mm.br.d.b(NormalUserFooterPreference.b(NormalUserFooterPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27309);
        }
      });
      NormalUserFooterPreference.h(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27310);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = NormalUserFooterPreference.a.this;
          localObject = new yg();
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          int i;
          if ((!NormalUserFooterPreference.a(paramAnonymousView.xjD).field_username.equals(((yg)localObject).dNC.talker)) && ((((yg)localObject).dNC.dlr) || (((yg)localObject).dNC.dls))) {
            if (((yg)localObject).dNC.dND)
            {
              i = 2131756778;
              Toast.makeText(NormalUserFooterPreference.b(paramAnonymousView.xjD).getContext(), i, 0).show();
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NormalUserFooterPreference", "voip is running, can't do this");
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent())), Integer.valueOf(5), Integer.valueOf(1), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27310);
            return;
            i = 2131756779;
            break;
            if ((!com.tencent.mm.r.a.cf(NormalUserFooterPreference.b(paramAnonymousView.xjD))) && (!com.tencent.mm.r.a.cj(NormalUserFooterPreference.b(paramAnonymousView.xjD))))
            {
              localObject = new wq();
              ((wq)localObject).dMc.dMe = true;
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
              localObject = ((wq)localObject).dMd.dMg;
              if (!bu.isNullOrNil((String)localObject))
              {
                com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.NormalUserFooterPreference", "Talkroom is on: ".concat(String.valueOf(localObject)));
                com.tencent.mm.ui.base.h.e(NormalUserFooterPreference.b(paramAnonymousView.xjD), NormalUserFooterPreference.b(paramAnonymousView.xjD).getString(2131764350), "", NormalUserFooterPreference.b(paramAnonymousView.xjD).getString(2131755835), NormalUserFooterPreference.b(paramAnonymousView.xjD).getString(2131755691), new NormalUserFooterPreference.a.2(paramAnonymousView), new NormalUserFooterPreference.a.3(paramAnonymousView));
              }
              else
              {
                paramAnonymousView.dEt();
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
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27311);
        }
      });
      NormalUserFooterPreference.j(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27312);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27312);
        }
      });
      NormalUserFooterPreference.k(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27313);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27313);
        }
      });
      ((com.tencent.mm.pluginsdk.h.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.h.a.class)).a(this);
    }
    
    protected abstract void dEq();
    
    protected final void dEr()
    {
      NormalUserFooterPreference.b(NormalUserFooterPreference.this).addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27296);
          paramAnonymousMenuItem = new e(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
          paramAnonymousMenuItem.LfT = new n.e()
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
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).adx())
                {
                  x.y(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  com.tencent.mm.ui.base.h.cm(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757891));
                }
                for (;;)
                {
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this;
                  bc.aCg();
                  NormalUserFooterPreference.a(paramAnonymous2MenuItem, com.tencent.mm.model.c.azF().BH(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
                  AppMethodBeat.o(27294);
                  return;
                  x.x(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  com.tencent.mm.ui.base.h.cm(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757665));
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
                ((Intent)localObject1).putExtra("Select_Talker_Name", NormalUserFooterPreference.a(paramAnonymous2MenuItem.xjD).field_username);
                ((Intent)localObject1).putExtra("Select_block_List", NormalUserFooterPreference.a(paramAnonymous2MenuItem.xjD).field_username);
                ((Intent)localObject1).putExtra("Select_Conv_Type", 3);
                ((Intent)localObject1).putExtra("Select_Send_Card", true);
                ((Intent)localObject1).putExtra("mutil_select_is_ret", true);
                com.tencent.mm.plugin.profile.b.iUz.a((Intent)localObject1, NormalUserFooterPreference.b(paramAnonymous2MenuItem.xjD));
                AppMethodBeat.o(27294);
                return;
                NormalUserFooterPreference.this.hPq.dW("hide_btn");
                NormalUserFooterPreference.this.hPq.doNotify();
                NormalUserFooterPreference.a locala = NormalUserFooterPreference.a.this;
                paramAnonymous2MenuItem = locala.xjD;
                bc.aCg();
                NormalUserFooterPreference.a(paramAnonymous2MenuItem, com.tencent.mm.model.c.azF().BH(NormalUserFooterPreference.a(locala.xjD).field_username));
                if (!com.tencent.mm.contact.c.lO(NormalUserFooterPreference.a(locala.xjD).field_type))
                {
                  locala.avS(NormalUserFooterPreference.a(locala.xjD).field_username);
                  AppMethodBeat.o(27294);
                  return;
                }
                Intent localIntent = new Intent();
                localIntent.putExtra("Contact_Scene", NormalUserFooterPreference.l(locala.xjD));
                localIntent.putExtra("Contact_User", NormalUserFooterPreference.a(locala.xjD).field_username);
                localIntent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(locala.xjD).getIntent().getStringExtra("Contact_RoomNickname"));
                localIntent.putExtra("contact_phone_number_list", NormalUserFooterPreference.a(locala.xjD).eRu);
                Object localObject2 = "";
                localObject1 = localObject2;
                String str;
                if (!NormalUserFooterPreference.a(locala.xjD).adC())
                {
                  localObject1 = NormalUserFooterPreference.b(locala.xjD).getIntent().getStringExtra("Contact_Mobile_MD5");
                  str = NormalUserFooterPreference.b(locala.xjD).getIntent().getStringExtra("Contact_full_Mobile_MD5");
                  if ((!bu.isNullOrNil((String)localObject1)) || (!bu.isNullOrNil(str))) {
                    break label803;
                  }
                  paramAnonymous2MenuItem = localObject3;
                  if (!bu.isNullOrNil(NormalUserFooterPreference.a(locala.xjD).field_username)) {
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(NormalUserFooterPreference.a(locala.xjD).field_username);
                  }
                }
                for (;;)
                {
                  localObject1 = localObject2;
                  if (paramAnonymous2MenuItem != null)
                  {
                    localObject1 = localObject2;
                    if (!bu.isNullOrNil(paramAnonymous2MenuItem.Lj())) {
                      localObject1 = bu.nullAsNil(paramAnonymous2MenuItem.aTc()).replace(" ", "");
                    }
                  }
                  localIntent.putExtra("contact_phone_number_by_md5", (String)localObject1);
                  com.tencent.mm.plugin.profile.b.iUz.m(localIntent, locala.xjD.mContext);
                  AppMethodBeat.o(27294);
                  return;
                  label803:
                  if (bu.isNullOrNil((String)localObject1))
                  {
                    paramAnonymous2MenuItem = localObject3;
                    if (bu.isNullOrNil(str)) {}
                  }
                  else
                  {
                    localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW((String)localObject1);
                    if (localObject1 != null)
                    {
                      paramAnonymous2MenuItem = (MenuItem)localObject1;
                      if (!bu.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Lj())) {}
                    }
                    else
                    {
                      paramAnonymous2MenuItem = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW(str);
                    }
                  }
                }
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).adv())
                {
                  NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this);
                  AppMethodBeat.o(27294);
                  return;
                }
                paramAnonymous2MenuItem = View.inflate(NormalUserFooterPreference.this.mContext, 2131494763, null);
                paramAnonymous2MenuItem.setPadding(0, 0, 0, 0);
                localObject1 = (TextView)paramAnonymous2MenuItem.findViewById(2131302306);
                ((TextView)localObject1).setPadding(0, 0, 0, 0);
                if (an.aUq(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
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
                        if (this.xfi.isChecked()) {
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
                if (x.Al(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext.getString(2131758022, new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).adG() });
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
                      NormalUserFooterPreference.a.this.dEu();
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
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext.getString(2131758020, new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).adG() });
                  break;
                  label1487:
                  paramAnonymous2MenuItem.setVisibility(8);
                  ((TextView)localObject2).setVisibility(8);
                }
                paramAnonymous2MenuItem = NormalUserFooterPreference.a.this;
                com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NormalUserFooterPreference", "dealAddShortcut, username = " + NormalUserFooterPreference.a(paramAnonymous2MenuItem.xjD).field_username);
                com.tencent.mm.plugin.base.model.b.aa(NormalUserFooterPreference.b(paramAnonymous2MenuItem.xjD), NormalUserFooterPreference.a(paramAnonymous2MenuItem.xjD).field_username);
                ar.o(new NormalUserFooterPreference.a.9(paramAnonymous2MenuItem), 1000L);
                AppMethodBeat.o(27294);
                return;
                NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
              }
            }
          };
          paramAnonymousMenuItem.LfS = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(27295);
              com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent())), Integer.valueOf(7), Integer.valueOf(1), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              if (an.aUq(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
              {
                paramAnonymous2l.aM(1, 2131757927, 2131689826);
                if (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).adx()) {
                  break label318;
                }
                str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getResources().getString(2131757890);
                label151:
                paramAnonymous2l.a(2, str, 2131689829);
                if (!an.aUq(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
                  paramAnonymous2l.aM(3, 2131757747, 2131689817);
                }
                paramAnonymous2l.aM(4, 2131757808, 2131689831);
                paramAnonymous2l.aM(9, 2131756596, 2131689799);
                if (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).adv()) {
                  break label343;
                }
              }
              label318:
              label343:
              for (String str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757741);; str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757736))
              {
                paramAnonymous2l.a(5, str, 2131689795);
                if (!NormalUserFooterPreference.c(NormalUserFooterPreference.this)) {
                  paramAnonymous2l.aM(6, 2131756457, 2131689802);
                }
                paramAnonymous2l.aM(7, 2131757578, 2131689803);
                AppMethodBeat.o(27295);
                return;
                paramAnonymous2l.aM(1, 2131757731, 2131689826);
                break;
                str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getResources().getString(2131757664);
                break label151;
              }
            }
          };
          paramAnonymousMenuItem.cPF();
          AppMethodBeat.o(27296);
          return true;
        }
      });
    }
    
    protected void dEs()
    {
      if (NormalUserFooterPreference.d(NormalUserFooterPreference.this)) {
        NormalUserFooterPreference.b(NormalUserFooterPreference.this).showOptionMenu(false);
      }
      do
      {
        do
        {
          return;
        } while (v.aAC().equals(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
        if (!com.tencent.mm.contact.c.lO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) {
          break;
        }
      } while (x.AQ(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
      dEr();
      return;
      Y(false, false);
    }
    
    final void dEt()
    {
      this.xeN = new e(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
      this.xeN.LfS = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(27299);
          paramAnonymousl.aM(2, 2131755762, 2131691164);
          paramAnonymousl.aM(1, 2131755764, 2131691165);
          AppMethodBeat.o(27299);
        }
      };
      this.xeN.LfT = new n.e()
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
            NormalUserFooterPreference.this.dEo();
            AppMethodBeat.o(27300);
            return;
            NormalUserFooterPreference.this.dEp();
          }
        }
      };
      this.xeN.cPF();
    }
    
    protected final void dEu()
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(2), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
      final String str = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
      if (x.Al(str))
      {
        NormalUserFooterPreference.a(NormalUserFooterPreference.this).acT();
        bc.aCg();
        com.tencent.mm.model.c.azE().d(new com.tencent.mm.ba.d(str));
        bc.aCg();
        com.tencent.mm.model.c.azF().aUS(str);
        bc.aCg();
        com.tencent.mm.model.c.azP().BD(str);
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
      for (localObject = com.tencent.mm.pluginsdk.wallet.d.aPl(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);; localObject = null)
      {
        if (!bu.isNullOrNil((String)localObject))
        {
          localp.dismiss();
          com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, false, NormalUserFooterPreference.this.mContext.getString(2131765236, new Object[] { localObject }), null, NormalUserFooterPreference.this.mContext.getString(2131760081), NormalUserFooterPreference.this.mContext.getString(2131758036), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27301);
              com.tencent.mm.plugin.report.service.g.yxI.f(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(4), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              NormalUserFooterPreference.a.this.isDeleteCancel = true;
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("Chat_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
              paramAnonymousDialogInterface.addFlags(67108864);
              com.tencent.mm.br.d.f(NormalUserFooterPreference.this.mContext, ".ui.chatting.ChattingUI", paramAnonymousDialogInterface);
              AppMethodBeat.o(27301);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27302);
              com.tencent.mm.plugin.report.service.g.yxI.f(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(3), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              localp.show();
              NormalUserFooterPreference.a.this.isDeleteCancel = false;
              NormalUserFooterPreference.a.this.Oq(str);
              AppMethodBeat.o(27302);
            }
          }, -1, 2131099904);
          return;
        }
        Oq(str);
        return;
      }
    }
    
    protected void onDetach()
    {
      ((com.tencent.mm.pluginsdk.h.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.h.a.class)).b(this);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NormalUserFooterPreference", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    }
  }
  
  final class b
    extends NormalUserFooterPreference.c
  {
    public b()
    {
      super();
    }
    
    protected final void dEq()
    {
      AppMethodBeat.i(27317);
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      if ((!com.tencent.mm.contact.c.lO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) || ((com.tencent.mm.contact.c.lO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) && (an.Ac(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))))
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
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NearByFriendHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              NormalUserFooterPreference.b.this.dEv();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NearByFriendHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(27314);
            }
          });
        }
        NormalUserFooterPreference.A(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(27315);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NearByFriendHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if ((NormalUserFooterPreference.c(NormalUserFooterPreference.this)) && (com.tencent.mm.bp.a.fcr()))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Chat_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername);
              paramAnonymousView.putExtra("lbs_mode", true);
              paramAnonymousView.putExtra("lbs_ticket", NormalUserFooterPreference.C(NormalUserFooterPreference.this));
              paramAnonymousView.putExtra("add_scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              com.tencent.mm.plugin.profile.b.iUz.d(paramAnonymousView, NormalUserFooterPreference.b(NormalUserFooterPreference.this));
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NearByFriendHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(27315);
              return;
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
              paramAnonymousView.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              paramAnonymousView.putExtra(e.c.JoX, NormalUserFooterPreference.a(NormalUserFooterPreference.this).eRv);
              com.tencent.mm.plugin.profile.b.iUz.a(paramAnonymousView, NormalUserFooterPreference.this.mContext);
            }
          }
        });
        AppMethodBeat.o(27317);
        return;
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
        if ((NormalUserFooterPreference.this.dEn()) || (NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(v.aAC()))) {
          break;
        }
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
      }
    }
    
    protected final void dEs()
    {
      AppMethodBeat.i(27316);
      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this) == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
        AppMethodBeat.o(27316);
        return;
      }
      if ((!com.tencent.mm.contact.c.lO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) || ((com.tencent.mm.contact.c.lO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) && (an.Ac(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))))
      {
        if (an.Ac(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
        {
          Y(true, true);
          AppMethodBeat.o(27316);
          return;
        }
        Y(false, true);
        AppMethodBeat.o(27316);
        return;
      }
      dEr();
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
    
    private void dEw()
    {
      AppMethodBeat.i(27327);
      Object localObject2 = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("Contact_Mobile_MD5");
      Object localObject1 = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("Contact_full_Mobile_MD5");
      String str = bu.nullAsNil((String)localObject2);
      localObject1 = bu.nullAsNil((String)localObject1);
      if ((!str.equals("")) || (!((String)localObject1).equals("")))
      {
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW(str);
        if (localObject2 != null) {
          break label113;
        }
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW((String)localObject1);
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
    
    protected final void azm()
    {
      AppMethodBeat.i(27323);
      super.azm();
      AppMethodBeat.o(27323);
    }
    
    protected void dEq()
    {
      AppMethodBeat.i(27325);
      boolean bool;
      if (!x.AZ(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
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
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            NormalUserFooterPreference.c.this.dEu();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27318);
          }
        });
        if (!com.tencent.mm.contact.c.lO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) {
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
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if (NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent() != null)
          {
            paramAnonymousView = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("key_ww_add_session_id");
            if (!bu.isNullOrNil(paramAnonymousView))
            {
              localObject = new dp();
              ((dp)localObject).nm(paramAnonymousView);
              ((dp)localObject).eeJ = 0L;
              ((dp)localObject).eir = 1L;
              ((dp)localObject).aLH();
            }
          }
          NormalUserFooterPreference.c.this.dEv();
          if (NormalUserFooterPreference.E(NormalUserFooterPreference.this) != 0) {
            com.tencent.mm.plugin.report.service.g.yxI.f(11263, new Object[] { Integer.valueOf(NormalUserFooterPreference.E(NormalUserFooterPreference.this)), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27319);
        }
      });
      if (!com.tencent.mm.contact.c.lO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type))
      {
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(0);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.g(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
        if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).adv())
        {
          NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(0);
          AppMethodBeat.o(27325);
        }
      }
      else
      {
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
        if ((!NormalUserFooterPreference.this.dEn()) && (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(v.aAC())) && (!x.AZ(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!x.AQ(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!an.aUq(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!x.Am(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))) {
          NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
        }
        for (;;)
        {
          bc.aCg();
          if (!com.tencent.mm.model.c.azF().aUP(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
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
    
    protected final void dEv()
    {
      AppMethodBeat.i(27326);
      if ((int)NormalUserFooterPreference.a(NormalUserFooterPreference.this).ght == 0)
      {
        bc.aCg();
        if (com.tencent.mm.model.c.azF().ao(NormalUserFooterPreference.a(NormalUserFooterPreference.this)) != -1)
        {
          localObject = NormalUserFooterPreference.this;
          bc.aCg();
          NormalUserFooterPreference.a((NormalUserFooterPreference)localObject, com.tencent.mm.model.c.azF().BH(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
        }
      }
      if ((NormalUserFooterPreference.F(NormalUserFooterPreference.this)) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 12))
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NormalUserFooterPreference", "qqNum " + NormalUserFooterPreference.G(NormalUserFooterPreference.this) + " qqReamrk " + NormalUserFooterPreference.H(NormalUserFooterPreference.this));
        if ((NormalUserFooterPreference.G(NormalUserFooterPreference.this) != 0L) && (NormalUserFooterPreference.H(NormalUserFooterPreference.this) != null) && (!NormalUserFooterPreference.H(NormalUserFooterPreference.this).equals("")))
        {
          localObject = com.tencent.mm.plugin.account.a.getQQListStg().sO(NormalUserFooterPreference.G(NormalUserFooterPreference.this));
          if (localObject != null) {
            break label452;
          }
          localObject = new as();
          ((as)localObject).nickname = "";
          ((as)localObject).jhK = NormalUserFooterPreference.G(NormalUserFooterPreference.this);
          ((as)localObject).jhS = NormalUserFooterPreference.H(NormalUserFooterPreference.this);
          ((as)localObject).username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
          ((as)localObject).aTQ();
          com.tencent.mm.plugin.account.a.getQQListStg().a((as)localObject);
        }
      }
      final com.tencent.mm.pluginsdk.ui.applet.a locala;
      final LinkedList localLinkedList;
      final String str;
      for (;;)
      {
        dEw();
        locala = new com.tencent.mm.pluginsdk.ui.applet.a(NormalUserFooterPreference.this.mContext, new com.tencent.mm.pluginsdk.ui.applet.a.a()
        {
          public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(27320);
            if (paramAnonymousBoolean1)
            {
              NormalUserFooterPreference.this.hPq.dW("hide_btn");
              NormalUserFooterPreference.this.hPq.doNotify();
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
                  com.tencent.mm.plugin.report.service.g.yxI.f(10991, new Object[] { Integer.valueOf(i), Integer.valueOf(6), Integer.valueOf(j) });
                }
              }
              AppMethodBeat.o(27320);
              return;
              if (paramAnonymousBoolean2)
              {
                com.tencent.mm.bj.d.aMM().gw(paramAnonymousString1, 2);
                au.aE(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername, 1);
                paramAnonymousString1 = new qk();
                paramAnonymousString1.dGj.username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername;
                paramAnonymousString1.dGj.type = 1;
                com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString1);
              }
              else
              {
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NormalUserFooterPreference", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(paramAnonymousString1)));
              }
            }
          }
        });
        localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(NormalUserFooterPreference.l(NormalUserFooterPreference.this)));
        localObject = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("source_from_user_name");
        str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("source_from_nick_name");
        locala.lB((String)localObject, str);
        locala.Fni = new a.b()
        {
          public final boolean aA(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(27321);
            String str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("room_name");
            int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOK, 0);
            SayHiWithSnsPermissionUI localSayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.class;
            Object localObject;
            if ((!an.aUq(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (i == 1)) {
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
              ((Intent)localObject).putExtra("source_from_user_name", this.xeZ);
              ((Intent)localObject).putExtra("source_from_nick_name", str);
              ((Intent)localObject).putExtra("sayhi_with_sns_perm_send_verify", true);
              ((Intent)localObject).putExtra("sayhi_with_sns_perm_add_remark", true);
              ((Intent)localObject).putExtra("sayhi_with_sns_perm_set_label", false);
              ((Intent)localObject).putExtra(e.c.JoX, paramAnonymousString);
              ((Intent)localObject).putExtra("sayhi_verify_add_errcode", paramAnonymousInt);
              NormalUserFooterPreference.b(NormalUserFooterPreference.this).startActivityForResult((Intent)localObject, 0);
              AppMethodBeat.o(27321);
              return true;
              localObject = localSayHiWithSnsPermissionUI;
              if (!an.aUq(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
              {
                localObject = localSayHiWithSnsPermissionUI;
                if (i == 2) {
                  localObject = SayHiWithSnsPermissionUI3.class;
                }
              }
            }
          }
        };
        str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("room_name");
        localObject = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra(e.c.JoX);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NormalUserFooterPreference", "add contact case 1:%s", new Object[] { localObject });
        locala.aOa((String)localObject);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, "", localLinkedList);
        AppMethodBeat.o(27326);
        return;
        label452:
        ((as)localObject).jhK = NormalUserFooterPreference.G(NormalUserFooterPreference.this);
        ((as)localObject).jhS = NormalUserFooterPreference.H(NormalUserFooterPreference.this);
        ((as)localObject).username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
        ((as)localObject).aTQ();
        com.tencent.mm.plugin.account.a.getQQListStg().a(NormalUserFooterPreference.G(NormalUserFooterPreference.this), (as)localObject);
        continue;
        if ((NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 58) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 59) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 60)) {
          com.tencent.mm.plugin.account.a.getGoogleFriendStorage().aC(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, 1);
        }
      }
      if (TextUtils.isEmpty(str))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NormalUserFooterPreference", "add contact case 2, %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).eRv });
        locala.aOa(NormalUserFooterPreference.a(NormalUserFooterPreference.this).eRv);
        locala.h(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      if (!TextUtils.isEmpty(locala.tIA))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NormalUserFooterPreference", "add contact case 3, %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).eRv });
        locala.aOa(NormalUserFooterPreference.a(NormalUserFooterPreference.this).eRv);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      bc.aCg();
      Object localObject = com.tencent.mm.model.c.azF().BH(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      if (localObject != null) {}
      for (localObject = bu.bI(((aw)localObject).eRv, "");; localObject = "")
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NormalUserFooterPreference", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localObject });
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        locala.aOa((String)localObject);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      au.a.hIG.a(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, new au.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27322);
          bc.aCg();
          paramAnonymousString = com.tencent.mm.model.c.azF().BH(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          if (paramAnonymousString != null) {}
          for (paramAnonymousString = bu.bI(paramAnonymousString.eRv, "");; paramAnonymousString = "")
          {
            locala.aOa(paramAnonymousString);
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
    
    protected final void dEq()
    {
      AppMethodBeat.i(27329);
      Assert.assertTrue(x.AA(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
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
    
    protected final void dEs() {}
  }
  
  public static abstract interface e {}
  
  final class f
    extends NormalUserFooterPreference.a
  {
    public f()
    {
      super();
    }
    
    protected final void dEq()
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
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$QrcodeHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.plugin.normsg.a.b.wJt.ao(1, 1, 5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          paramAnonymousView.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
          paramAnonymousView.putExtra(e.c.JoX, NormalUserFooterPreference.a(NormalUserFooterPreference.this).eRv);
          com.tencent.mm.plugin.profile.b.iUz.a(paramAnonymousView, NormalUserFooterPreference.this.mContext);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$QrcodeHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27330);
        }
      });
      AppMethodBeat.o(27332);
    }
    
    protected final void dEs()
    {
      AppMethodBeat.i(27331);
      if ((NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) && (com.tencent.mm.contact.c.lO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)))
      {
        dEr();
        AppMethodBeat.o(27331);
        return;
      }
      Y(false, true);
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
    
    protected final void dEq()
    {
      boolean bool2 = true;
      AppMethodBeat.i(27333);
      if (!v.zK(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
      {
        bool1 = true;
        Assert.assertTrue(bool1);
        if (x.AZ(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
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
    
    public final void dEs() {}
  }
  
  final class h
    extends NormalUserFooterPreference.a
  {
    public h()
    {
      super();
    }
    
    protected final void dEq()
    {
      AppMethodBeat.i(27334);
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
      if ((!NormalUserFooterPreference.this.dEn()) && (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(v.aAC())) && (!x.AZ(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!x.AQ(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))) {
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
    
    protected final void dEs() {}
  }
  
  class i
    extends NormalUserFooterPreference.c
    implements f
  {
    private ProgressDialog fOC;
    
    public i()
    {
      super();
    }
    
    private void acS()
    {
      AppMethodBeat.i(27341);
      NormalUserFooterPreference localNormalUserFooterPreference = NormalUserFooterPreference.this;
      bc.aCg();
      an localan2 = com.tencent.mm.model.c.azF().BH(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      if (localan2 != null)
      {
        localan1 = localan2;
        if ((int)localan2.ght != 0) {}
      }
      else
      {
        localan1 = NormalUserFooterPreference.a(NormalUserFooterPreference.this);
        bc.aCg();
        if (com.tencent.mm.model.c.azF().am(localan1)) {
          break label131;
        }
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NormalUserFooterPreference", "insert contact failed, username = " + localan1.field_username);
      }
      for (an localan1 = null;; localan1 = com.tencent.mm.model.c.azF().BH(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
      {
        NormalUserFooterPreference.a(localNormalUserFooterPreference, localan1);
        if (NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) {
          x.B(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
        }
        AppMethodBeat.o(27341);
        return;
        label131:
        bc.aCg();
      }
    }
    
    protected void dEq()
    {
      AppMethodBeat.i(27338);
      onDetach();
      onStop();
      bc.ajj().a(30, this);
      bc.ajj().a(667, this);
      bc.ajj().a(853, this);
      super.dEq();
      AppMethodBeat.o(27338);
    }
    
    protected void dEx()
    {
      AppMethodBeat.i(27342);
      if (NormalUserFooterPreference.u(NormalUserFooterPreference.this) != null) {
        NormalUserFooterPreference.u(NormalUserFooterPreference.this).onDetach();
      }
      NormalUserFooterPreference.a(NormalUserFooterPreference.this, new NormalUserFooterPreference.c(NormalUserFooterPreference.this));
      NormalUserFooterPreference.u(NormalUserFooterPreference.this).azm();
      AppMethodBeat.o(27342);
    }
    
    protected void onDetach()
    {
      AppMethodBeat.i(27340);
      if (this.fOC != null)
      {
        this.fOC.dismiss();
        this.fOC = null;
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
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NormalUserFooterPreference", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      if ((paramn.getType() != 30) && (paramn.getType() != 667) && (paramn.getType() != 853))
      {
        AppMethodBeat.o(27343);
        return;
      }
      onStop();
      if (this.fOC != null)
      {
        this.fOC.dismiss();
        this.fOC = null;
      }
      if (!bu.jn(NormalUserFooterPreference.this.mContext))
      {
        AppMethodBeat.o(27343);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn.getType() == 30)
        {
          paramInt1 = ((com.tencent.mm.pluginsdk.model.o)paramn).dto;
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, opCode = ".concat(String.valueOf(paramInt1)));
          if ((paramInt1 == 1) || (paramInt1 == 3))
          {
            paramString = ((com.tencent.mm.pluginsdk.model.o)paramn).Fes;
            if ((paramString != null) && (paramString.contains(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)))
            {
              NormalUserFooterPreference.v(NormalUserFooterPreference.this);
              acS();
              dEx();
              paramString = paramString.iterator();
              while (paramString.hasNext()) {
                com.tencent.mm.pluginsdk.ui.preference.b.cv((String)paramString.next(), NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              }
              bc.getNotification().Xo();
            }
          }
          AppMethodBeat.o(27343);
          return;
        }
        if ((paramn.getType() == 667) || (paramn.getType() == 853))
        {
          NormalUserFooterPreference.v(NormalUserFooterPreference.this);
          acS();
          dEx();
          com.tencent.mm.pluginsdk.ui.preference.b.cv(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, NormalUserFooterPreference.l(NormalUserFooterPreference.this));
          bc.getNotification().Xo();
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
      for (paramInt1 = ((com.tencent.mm.pluginsdk.model.o)paramn).dto;; paramInt1 = 0)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", new Object[] { Integer.valueOf(paramInt1) });
        if ((paramInt1 == 3) || (paramn.getType() == 853)) {
          com.tencent.mm.ui.base.h.e(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757894), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755906), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755272), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27337);
              NormalUserFooterPreference.i.this.dEv();
              AppMethodBeat.o(27337);
            }
          }, null);
        }
        AppMethodBeat.o(27343);
        return;
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!bu.isNullOrNil(paramString)))
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
          if (bc.ajj().aFe())
          {
            bc.ajj().getNetworkServerIp();
            new StringBuilder().append(paramInt2);
            i = 1;
          }
          else
          {
            i = j;
            if (com.tencent.mm.network.ae.cR(NormalUserFooterPreference.this.mContext))
            {
              k.hI(NormalUserFooterPreference.this.mContext);
              i = 1;
              continue;
              Toast.makeText(NormalUserFooterPreference.this.mContext, NormalUserFooterPreference.this.mContext.getString(2131759511, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
              i = 1;
              continue;
              if (paramInt2 == -100)
              {
                com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, bc.aiH(), com.tencent.mm.cb.a.az(NormalUserFooterPreference.this.mContext, 2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(27335);
                    NormalUserFooterPreference.i.this.onStop();
                    paramAnonymousDialogInterface = new Intent();
                    paramAnonymousDialogInterface.putExtra("Intro_Switch", true).addFlags(67108864);
                    com.tencent.mm.plugin.profile.b.iUz.p(paramAnonymousDialogInterface, NormalUserFooterPreference.this.mContext);
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
                    com.tencent.mm.plugin.profile.b.iUz.p(paramAnonymousDialogInterface, NormalUserFooterPreference.this.mContext);
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
                    if (!bu.isNullOrNil(paramString)) {}
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
      bc.ajj().b(30, this);
      bc.ajj().b(667, this);
      bc.ajj().b(853, this);
      AppMethodBeat.o(27339);
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
    
    protected final void dEq()
    {
      AppMethodBeat.i(27348);
      super.dEq();
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
      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).adv())
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
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().removeExtra("Accept_NewFriend_FromOutside");
            int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOK, 0);
            localObject = SayHiWithSnsPermissionUI.class;
            if ((!an.aUq(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (i == 1)) {
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
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(27344);
              return;
              paramAnonymousView = (View)localObject;
              if (!an.aUq(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
              {
                paramAnonymousView = (View)localObject;
                if (i == 2) {
                  paramAnonymousView = SayHiWithSnsPermissionUI3.class;
                }
              }
            }
          }
        });
        NormalUserFooterPreference.x(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(27346);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).adv())
            {
              x.u(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
              NormalUserFooterPreference.a(NormalUserFooterPreference.this).acV();
              NormalUserFooterPreference.j.this.dEq();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(27346);
              return;
            }
            paramAnonymousView = NormalUserFooterPreference.this.mContext;
            localObject = NormalUserFooterPreference.this.mContext;
            if (an.aUq(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {}
            for (int i = 2131757738;; i = 2131757737)
            {
              com.tencent.mm.ui.base.h.a(paramAnonymousView, ((Context)localObject).getString(i), NormalUserFooterPreference.this.mContext.getString(2131757736), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(27345);
                  x.t(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  NormalUserFooterPreference.a(NormalUserFooterPreference.this).acU();
                  NormalUserFooterPreference.j.this.dEq();
                  AppMethodBeat.o(27345);
                }
              }, null);
              break;
            }
          }
        });
        AppMethodBeat.o(27348);
        return;
        NormalUserFooterPreference.x(NormalUserFooterPreference.this).setText(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757736));
      }
    }
    
    protected final void dEs()
    {
      AppMethodBeat.i(27347);
      if ((NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) && (com.tencent.mm.contact.c.lO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)))
      {
        dEr();
        AppMethodBeat.o(27347);
        return;
      }
      Y(false, true);
      AppMethodBeat.o(27347);
    }
    
    protected final void dEx()
    {
      AppMethodBeat.i(27350);
      super.dEx();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference
 * JD-Core Version:    0.7.0.1
 */