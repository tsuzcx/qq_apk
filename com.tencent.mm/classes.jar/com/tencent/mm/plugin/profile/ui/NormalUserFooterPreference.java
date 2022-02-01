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
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zi.a;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.b.a.gr;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.d;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class NormalUserFooterPreference
  extends Preference
  implements MStorage.IOnStorageChange
{
  private boolean BcL;
  private boolean Bdx;
  private String BfH;
  private boolean BfM;
  private int Bfb;
  private int Bft;
  private long Bge;
  private boolean Bhe;
  private boolean Bhf;
  private boolean Bhg;
  private boolean Bhh;
  private a Bhi;
  private View Bhj;
  private Button Bhk;
  private Button Bhl;
  private Button Bhm;
  private View Bhn;
  private Button Bho;
  private TextView Bhp;
  private View Bhq;
  private Button Bhr;
  private Button Bhs;
  private Button Bht;
  private Button Bhu;
  private Button Bhv;
  private Button Bhw;
  private TextView Bhx;
  private boolean Bhy;
  public boolean Bhz;
  private com.tencent.mm.storage.as contact;
  public ProgressDialog gtM;
  private MMActivity gte;
  private Button han;
  protected MStorageEvent<e, String> iKx;
  private int kgm;
  private String pfa;
  private boolean rFe;
  private String wZz;
  
  public NormalUserFooterPreference(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(27352);
    this.BcL = false;
    this.Bge = 0L;
    this.BfH = "";
    this.wZz = "";
    this.BfM = false;
    this.Bhg = false;
    this.Bhh = false;
    this.Bhy = false;
    this.Bfb = 0;
    this.gtM = null;
    this.Bhz = false;
    this.pfa = null;
    this.iKx = new MStorageEvent() {};
    this.gte = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27352);
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27353);
    this.BcL = false;
    this.Bge = 0L;
    this.BfH = "";
    this.wZz = "";
    this.BfM = false;
    this.Bhg = false;
    this.Bhh = false;
    this.Bhy = false;
    this.Bfb = 0;
    this.gtM = null;
    this.Bhz = false;
    this.pfa = null;
    this.iKx = new MStorageEvent() {};
    this.gte = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27353);
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27354);
    this.BcL = false;
    this.Bge = 0L;
    this.BfH = "";
    this.wZz = "";
    this.BfM = false;
    this.Bhg = false;
    this.Bhh = false;
    this.Bhy = false;
    this.Bfb = 0;
    this.gtM = null;
    this.Bhz = false;
    this.pfa = null;
    this.iKx = new MStorageEvent() {};
    this.gte = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27354);
  }
  
  private void init()
  {
    this.rFe = false;
    this.Bhi = null;
  }
  
  private void initView()
  {
    AppMethodBeat.i(27355);
    if ((!this.rFe) || (this.contact == null))
    {
      Log.w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.rFe + " contact = " + this.contact);
      if (this.Bhi != null) {
        try
        {
          this.Bhi.eEO();
          AppMethodBeat.o(27355);
          return;
        }
        catch (Throwable localThrowable) {}
      }
      AppMethodBeat.o(27355);
      return;
    }
    if (this.Bhi != null) {
      this.Bhi.aSs();
    }
    eEJ();
    AppMethodBeat.o(27355);
  }
  
  public final boolean a(com.tencent.mm.storage.as paramas, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2, boolean paramBoolean4, boolean paramBoolean5, long paramLong, String paramString2)
  {
    AppMethodBeat.i(27357);
    cCs();
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (Util.nullAsNil(paramas.field_username).length() <= 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!com.tencent.mm.storage.as.bjz(z.aTY()).equals(paramas.field_username)) {
        break label80;
      }
      AppMethodBeat.o(27357);
      return false;
      bool = false;
      break;
    }
    label80:
    this.contact = paramas;
    this.wZz = paramString1;
    this.Bdx = paramBoolean1;
    this.kgm = paramInt1;
    this.Bft = paramInt2;
    this.Bhf = Util.nullAs(Boolean.valueOf(ab.IQ(paramas.field_username)), false);
    this.BcL = paramBoolean4;
    this.Bhe = paramBoolean5;
    this.Bge = paramLong;
    this.BfH = paramString2;
    this.Bhz = false;
    if (paramas.field_deleteFlag == 1)
    {
      paramBoolean1 = true;
      this.BfM = paramBoolean1;
      this.Bhy = this.gte.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
      this.Bfb = this.gte.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.Bhg = this.gte.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
      this.Bhh = this.gte.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
      this.pfa = this.gte.getIntent().getStringExtra("lbs_ticket");
      if (!z.Im(paramas.field_username))
      {
        bg.aVF();
        if (!com.tencent.mm.model.c.aSW().has(paramas.field_username)) {
          break label321;
        }
      }
      this.Bhi = new c();
      this.Bhz = true;
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(27357);
      return true;
      paramBoolean1 = false;
      break;
      label321:
      if (com.tencent.mm.storage.as.bjm(paramas.field_username))
      {
        this.Bhi = new h();
      }
      else if (ab.Jf(paramas.field_username))
      {
        this.Bhi = new d();
      }
      else if (ab.IQ(paramas.field_username))
      {
        this.Bhi = new g();
      }
      else if (com.tencent.mm.storage.as.bjn(paramas.field_username))
      {
        this.Bhi = new f();
      }
      else if ((com.tencent.mm.contact.c.oR(paramas.field_type)) && (!com.tencent.mm.storage.as.IG(paramas.field_username)))
      {
        this.Bhi = new c();
        this.Bhz = true;
      }
      else if (paramBoolean2)
      {
        this.Bhi = new j();
        this.Bhz = true;
      }
      else if ((paramBoolean3) || (com.tencent.mm.storage.as.IG(paramas.field_username)))
      {
        this.Bhi = new b();
      }
      else
      {
        this.Bhi = new c();
        this.Bhz = true;
      }
    }
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(27359);
    if (this.Bhi != null) {
      this.Bhi.onDetach();
    }
    this.iKx.removeAll();
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    AppMethodBeat.o(27359);
    return true;
  }
  
  public final boolean eEJ()
  {
    AppMethodBeat.i(27358);
    if ((this.Bhy) && (com.tencent.mm.contact.c.oR(this.contact.field_type)))
    {
      this.Bhw.setVisibility(0);
      AppMethodBeat.o(27358);
      return true;
    }
    this.Bhw.setVisibility(8);
    AppMethodBeat.o(27358);
    return false;
  }
  
  public final void eEK()
  {
    AppMethodBeat.i(27361);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.gte, "android.permission.RECORD_AUDIO", 82, "", "");
    Log.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.gte });
    if (!bool)
    {
      AppMethodBeat.o(27361);
      return;
    }
    zj localzj = new zj();
    localzj.efx.dKy = 5;
    localzj.efx.talker = this.contact.field_username;
    localzj.efx.context = this.gte;
    localzj.efx.eft = 4;
    EventCenter.instance.publish(localzj);
    AppMethodBeat.o(27361);
  }
  
  public final void eEL()
  {
    AppMethodBeat.i(27362);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.gte, "android.permission.CAMERA", 19, "", "");
    Log.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.gte });
    if (!bool)
    {
      AppMethodBeat.o(27362);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.gte, "android.permission.RECORD_AUDIO", 19, "", "");
    Log.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.gte });
    if (!bool)
    {
      AppMethodBeat.o(27362);
      return;
    }
    zj localzj = new zj();
    localzj.efx.dKy = 5;
    localzj.efx.talker = this.contact.field_username;
    localzj.efx.context = this.gte;
    localzj.efx.eft = 2;
    EventCenter.instance.publish(localzj);
    AppMethodBeat.o(27362);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27356);
    Log.d("MicroMsg.NormalUserFooterPreference", "on bindView " + paramView.toString());
    this.Bhj = paramView.findViewById(2131299070);
    this.Bhk = ((Button)paramView.findViewById(2131299101));
    this.Bhl = ((Button)paramView.findViewById(2131299045));
    this.Bho = ((Button)paramView.findViewById(2131299103));
    this.Bhp = ((TextView)paramView.findViewById(2131299107));
    this.Bhn = paramView.findViewById(2131299104);
    this.Bhm = ((Button)paramView.findViewById(2131299102));
    this.Bht = ((Button)paramView.findViewById(2131299033));
    this.Bhq = paramView.findViewById(2131299076);
    this.Bhr = ((Button)paramView.findViewById(2131299075));
    this.Bhs = ((Button)paramView.findViewById(2131299077));
    this.han = ((Button)paramView.findViewById(2131299078));
    this.Bhw = ((Button)paramView.findViewById(2131299066));
    this.Bhu = ((Button)paramView.findViewById(2131299105));
    this.Bhv = ((Button)paramView.findViewById(2131299042));
    this.Bhx = ((TextView)paramView.findViewById(2131299067));
    this.rFe = true;
    initView();
    super.onBindView(paramView);
    if ((this.gte.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) == true) && (this.Bhk != null)) {
      this.Bhk.performClick();
    }
    AppMethodBeat.o(27356);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(27360);
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(27360);
      return;
    }
    if ((this.contact != null) && ((paramString.equals(this.contact.field_username)) || (paramString.equals(this.contact.field_encryptUsername))))
    {
      bg.aVF();
      this.contact = com.tencent.mm.model.c.aSN().Kn(this.contact.field_username);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27291);
          NormalUserFooterPreference.this.eEJ();
          AppMethodBeat.o(27291);
        }
      });
    }
    AppMethodBeat.o(27360);
  }
  
  abstract class a
    implements i, com.tencent.mm.pluginsdk.h.a.a
  {
    private e Bcp = null;
    boolean isDeleteCancel = false;
    
    public a() {}
    
    final void XA(String paramString)
    {
      NormalUserFooterPreference.a(NormalUserFooterPreference.this).aqR();
      if (com.tencent.mm.storage.as.bjp(paramString))
      {
        ((r)com.tencent.mm.kernel.g.af(r.class)).EG(paramString);
        ay.a.iDq.Ka(paramString);
        return;
      }
      ((com.tencent.mm.pluginsdk.h.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.h.a.class)).XA(paramString);
    }
    
    public final void a(String paramString, int paramInt, cxl paramcxl)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      if (paramInt == 0)
      {
        if (!paramString.equals(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
        {
          Log.w("MicroMsg.NormalUserFooterPreference", "not current contact %s,%s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, paramString });
          return;
        }
        switch (NormalUserFooterPreference.l(NormalUserFooterPreference.this))
        {
        default: 
          if (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 9)
          {
            Log.i("MicroMsg.NormalUserFooterPreference", "add scene unkown, check the contact getsource: " + NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource());
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
          com.tencent.mm.plugin.profile.b.jRt.o(paramString, NormalUserFooterPreference.this.mContext);
          return;
          paramcxl = com.tencent.mm.plugin.account.a.getQQListStg().Tg(paramString);
          if (paramcxl == null) {
            break;
          }
          paramcxl.kfO = 1;
          com.tencent.mm.plugin.account.a.getQQListStg().a(paramcxl.kfN, paramcxl);
          break;
          paramcxl = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(paramString);
          if ((paramcxl != null) && (!Util.isNullOrNil(paramcxl.kdX)))
          {
            paramcxl.status = 1;
            com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramcxl.getMd5(), paramcxl);
          }
          com.tencent.mm.platformtools.t.R(NormalUserFooterPreference.this.mContext, paramString);
          break;
          com.tencent.mm.platformtools.t.R(NormalUserFooterPreference.this.mContext, paramString);
          break;
          paramcxl = com.tencent.mm.plugin.account.a.getFacebookFrdStg();
          Object localObject3 = "select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + paramString + "\"";
          localObject3 = paramcxl.iFy.rawQuery((String)localObject3, null, 2);
          if (localObject3 == null) {
            paramcxl = localObject1;
          }
          while (paramcxl != null)
          {
            paramcxl.status = 100;
            com.tencent.mm.plugin.account.a.getFacebookFrdStg().a(paramcxl);
            break;
            paramcxl = localObject2;
            if (((Cursor)localObject3).moveToFirst())
            {
              paramcxl = new com.tencent.mm.plugin.account.friend.a.g();
              paramcxl.convertFrom((Cursor)localObject3);
            }
            ((Cursor)localObject3).close();
          }
          com.tencent.mm.plugin.account.a.getGoogleFriendStorage().aG(paramString, 2);
          break;
          Log.i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
          com.tencent.mm.platformtools.t.R(NormalUserFooterPreference.this.mContext, paramString);
        }
        label501:
        NormalUserFooterPreference.b(NormalUserFooterPreference.this).setResult(-1, NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().putExtra("_delete_ok_", true));
        ((Activity)NormalUserFooterPreference.this.mContext).finish();
        return;
      }
      if (!Util.isNullOrNil(paramcxl.iAc))
      {
        com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.b(NormalUserFooterPreference.this), paramcxl.iAc, paramcxl.Title, true);
        return;
      }
      com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755779), "", true);
    }
    
    final void aKk(String paramString)
    {
      if (Util.isNullOrNil(paramString))
      {
        Log.w("MicroMsg.NormalUserFooterPreference", "mod stranger remark, username is null");
        return;
      }
      paramString = new Intent();
      paramString.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
      paramString.putExtra("Contact_mode_name_type", 0);
      paramString.putExtra("Contact_ModStrangerRemark", true);
      paramString.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      paramString.putExtra("Contact_Nick", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_nickname);
      paramString.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_conRemark);
      com.tencent.mm.plugin.profile.b.jRt.m(paramString, NormalUserFooterPreference.this.mContext);
    }
    
    protected void aSs()
    {
      eEM();
      eEO();
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27308);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          Log.i("MicroMsg.NormalUserFooterPreference", "sendButton onClick %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
          Intent localIntent;
          if (NormalUserFooterPreference.e(NormalUserFooterPreference.this))
          {
            paramAnonymousView = NormalUserFooterPreference.a.this;
            localObject = NormalUserFooterPreference.a(paramAnonymousView.BhA).field_username;
            localIntent = new Intent();
            localIntent.addFlags(67108864);
            if (NormalUserFooterPreference.n(paramAnonymousView.BhA))
            {
              localIntent.putExtra("Chat_User", (String)localObject);
              localIntent.putExtra("Chat_Mode", 1);
              ((Activity)paramAnonymousView.BhA.mContext).setResult(-1, localIntent);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent())), Integer.valueOf(4), Integer.valueOf(1), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27308);
            return;
            localIntent.putExtra("Chat_User", (String)localObject);
            localIntent.putExtra("Chat_Mode", 1);
            com.tencent.mm.plugin.profile.b.jRt.d(localIntent, paramAnonymousView.BhA.mContext);
            continue;
            paramAnonymousView = NormalUserFooterPreference.a.this;
            localObject = new Intent();
            ((Intent)localObject).addFlags(67108864);
            if (NormalUserFooterPreference.n(paramAnonymousView.BhA))
            {
              ((Intent)localObject).putExtra("Chat_User", NormalUserFooterPreference.a(paramAnonymousView.BhA).field_username);
              ((Intent)localObject).putExtra("Chat_Mode", 1);
              ((Activity)paramAnonymousView.BhA.mContext).setResult(-1, (Intent)localObject);
            }
            else
            {
              ((Intent)localObject).putExtra("Chat_User", NormalUserFooterPreference.a(paramAnonymousView.BhA).field_username);
              ((Intent)localObject).putExtra("Chat_Mode", 1);
              com.tencent.mm.plugin.profile.b.jRt.d((Intent)localObject, paramAnonymousView.BhA.mContext);
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
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_permission_userName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          paramAnonymousView.putExtra("sns_permission_anim", true);
          paramAnonymousView.putExtra("sns_permission_block_scene", 4);
          com.tencent.mm.br.c.b(NormalUserFooterPreference.b(NormalUserFooterPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymousView);
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = NormalUserFooterPreference.a.this;
          localObject = new zi();
          EventCenter.instance.publish((IEvent)localObject);
          int i;
          if ((!NormalUserFooterPreference.a(paramAnonymousView.BhA).field_username.equals(((zi)localObject).efv.talker)) && ((((zi)localObject).efv.dCH) || (((zi)localObject).efv.dCI))) {
            if (((zi)localObject).efv.efw)
            {
              i = 2131756942;
              Toast.makeText(NormalUserFooterPreference.b(paramAnonymousView.BhA).getContext(), i, 0).show();
              Log.i("MicroMsg.NormalUserFooterPreference", "voip is running, can't do this");
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent())), Integer.valueOf(5), Integer.valueOf(1), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27310);
            return;
            i = 2131756943;
            break;
            if ((!com.tencent.mm.q.a.cA(NormalUserFooterPreference.b(paramAnonymousView.BhA))) && (!com.tencent.mm.q.a.cE(NormalUserFooterPreference.b(paramAnonymousView.BhA))))
            {
              localObject = new xq();
              ((xq)localObject).edR.edT = true;
              EventCenter.instance.publish((IEvent)localObject);
              localObject = ((xq)localObject).edS.edV;
              if (!Util.isNullOrNil((String)localObject))
              {
                Log.v("MicroMsg.NormalUserFooterPreference", "Talkroom is on: ".concat(String.valueOf(localObject)));
                com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.b(paramAnonymousView.BhA), NormalUserFooterPreference.b(paramAnonymousView.BhA).getString(2131766611), "", NormalUserFooterPreference.b(paramAnonymousView.BhA).getString(2131755921), NormalUserFooterPreference.b(paramAnonymousView.BhA).getString(2131755761), new NormalUserFooterPreference.a.2(paramAnonymousView), new NormalUserFooterPreference.a.3(paramAnonymousView));
              }
              else
              {
                paramAnonymousView.eEP();
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
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27313);
        }
      });
      ((com.tencent.mm.pluginsdk.h.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.h.a.class)).a(this);
    }
    
    protected final void ac(final boolean paramBoolean1, final boolean paramBoolean2)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        return;
      }
      NormalUserFooterPreference.b(NormalUserFooterPreference.this).addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27307);
          paramAnonymousMenuItem = new e(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
          paramAnonymousMenuItem.HLY = new o.g()
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
                NormalUserFooterPreference.a.this.aKk(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
                AppMethodBeat.o(27305);
                return;
              case 8: 
                NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this);
                AppMethodBeat.o(27305);
                return;
              }
              paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext;
              Context localContext = NormalUserFooterPreference.this.mContext;
              if (com.tencent.mm.storage.as.bjp(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {}
              for (paramAnonymous2Int = 2131757975;; paramAnonymous2Int = 2131757974)
              {
                com.tencent.mm.ui.base.h.a(paramAnonymous2MenuItem, localContext.getString(paramAnonymous2Int), NormalUserFooterPreference.this.mContext.getString(2131757973), new DialogInterface.OnClickListener()
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
          paramAnonymousMenuItem.HLX = new o.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
            {
              AppMethodBeat.i(27306);
              if (!NormalUserFooterPreference.a.10.this.BhE)
              {
                if (!com.tencent.mm.storage.as.bjp(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
                  break label95;
                }
                paramAnonymous2m.aS(1, 2131758167, 2131689839);
              }
              while (!NormalUserFooterPreference.a.10.this.BhF) {
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ary())
                {
                  paramAnonymous2m.aS(8, 2131757978, 2131689807);
                  AppMethodBeat.o(27306);
                  return;
                  label95:
                  paramAnonymous2m.aS(1, 2131757968, 2131689839);
                }
                else if (!ab.IR(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2m.aS(5, 2131757973, 2131689807);
                }
              }
              AppMethodBeat.o(27306);
            }
          };
          paramAnonymousMenuItem.dGm();
          AppMethodBeat.o(27307);
          return true;
        }
      });
    }
    
    protected abstract void eEM();
    
    protected final void eEN()
    {
      NormalUserFooterPreference.b(NormalUserFooterPreference.this).addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27296);
          paramAnonymousMenuItem = new e(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
          paramAnonymousMenuItem.HLY = new o.g()
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
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).arA())
                {
                  ab.y(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  com.tencent.mm.ui.base.h.cD(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131758131));
                }
                for (;;)
                {
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this;
                  bg.aVF();
                  NormalUserFooterPreference.a(paramAnonymous2MenuItem, com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
                  AppMethodBeat.o(27294);
                  return;
                  ab.x(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  com.tencent.mm.ui.base.h.cD(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757893));
                }
                paramAnonymous2MenuItem = new Intent();
                paramAnonymous2MenuItem.putExtra("sns_permission_userName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
                paramAnonymous2MenuItem.putExtra("sns_permission_anim", true);
                paramAnonymous2MenuItem.putExtra("sns_permission_block_scene", 1);
                com.tencent.mm.br.c.b(NormalUserFooterPreference.b(NormalUserFooterPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymous2MenuItem);
                AppMethodBeat.o(27294);
                return;
                paramAnonymous2MenuItem = NormalUserFooterPreference.a.this;
                Object localObject1 = new Intent();
                ((Intent)localObject1).putExtra("Select_Talker_Name", NormalUserFooterPreference.a(paramAnonymous2MenuItem.BhA).field_username);
                ((Intent)localObject1).putExtra("Select_block_List", NormalUserFooterPreference.a(paramAnonymous2MenuItem.BhA).field_username);
                ((Intent)localObject1).putExtra("Select_Conv_Type", 3);
                ((Intent)localObject1).putExtra("Select_Send_Card", true);
                ((Intent)localObject1).putExtra("mutil_select_is_ret", true);
                com.tencent.mm.plugin.profile.b.jRt.a((Intent)localObject1, 1, NormalUserFooterPreference.b(paramAnonymous2MenuItem.BhA));
                AppMethodBeat.o(27294);
                return;
                NormalUserFooterPreference.this.iKx.event("hide_btn");
                NormalUserFooterPreference.this.iKx.doNotify();
                NormalUserFooterPreference.a locala = NormalUserFooterPreference.a.this;
                paramAnonymous2MenuItem = locala.BhA;
                bg.aVF();
                NormalUserFooterPreference.a(paramAnonymous2MenuItem, com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.a(locala.BhA).field_username));
                if (!com.tencent.mm.contact.c.oR(NormalUserFooterPreference.a(locala.BhA).field_type))
                {
                  locala.aKk(NormalUserFooterPreference.a(locala.BhA).field_username);
                  AppMethodBeat.o(27294);
                  return;
                }
                Intent localIntent = new Intent();
                localIntent.putExtra("Contact_Scene", NormalUserFooterPreference.l(locala.BhA));
                localIntent.putExtra("Contact_User", NormalUserFooterPreference.a(locala.BhA).field_username);
                localIntent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(locala.BhA).getIntent().getStringExtra("Contact_RoomNickname"));
                localIntent.putExtra("contact_phone_number_list", NormalUserFooterPreference.a(locala.BhA).fuX);
                Object localObject2 = "";
                localObject1 = localObject2;
                String str;
                if (!NormalUserFooterPreference.a(locala.BhA).arF())
                {
                  localObject1 = NormalUserFooterPreference.b(locala.BhA).getIntent().getStringExtra("Contact_Mobile_MD5");
                  str = NormalUserFooterPreference.b(locala.BhA).getIntent().getStringExtra("Contact_full_Mobile_MD5");
                  if ((!Util.isNullOrNil((String)localObject1)) || (!Util.isNullOrNil(str))) {
                    break label804;
                  }
                  paramAnonymous2MenuItem = localObject3;
                  if (!Util.isNullOrNil(NormalUserFooterPreference.a(locala.BhA).field_username)) {
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(NormalUserFooterPreference.a(locala.BhA).field_username);
                  }
                }
                for (;;)
                {
                  localObject1 = localObject2;
                  if (paramAnonymous2MenuItem != null)
                  {
                    localObject1 = localObject2;
                    if (!Util.isNullOrNil(paramAnonymous2MenuItem.getMd5())) {
                      localObject1 = Util.nullAsNil(paramAnonymous2MenuItem.bnP()).replace(" ", "");
                    }
                  }
                  localIntent.putExtra("contact_phone_number_by_md5", (String)localObject1);
                  com.tencent.mm.plugin.profile.b.jRt.l(localIntent, locala.BhA.mContext);
                  AppMethodBeat.o(27294);
                  return;
                  label804:
                  if (Util.isNullOrNil((String)localObject1))
                  {
                    paramAnonymous2MenuItem = localObject3;
                    if (Util.isNullOrNil(str)) {}
                  }
                  else
                  {
                    localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU((String)localObject1);
                    if (localObject1 != null)
                    {
                      paramAnonymous2MenuItem = (MenuItem)localObject1;
                      if (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).getMd5())) {}
                    }
                    else
                    {
                      paramAnonymous2MenuItem = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(str);
                    }
                  }
                }
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ary())
                {
                  NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this);
                  AppMethodBeat.o(27294);
                  return;
                }
                paramAnonymous2MenuItem = View.inflate(NormalUserFooterPreference.this.mContext, 2131495497, null);
                paramAnonymous2MenuItem.setPadding(0, 0, 0, 0);
                localObject1 = (TextView)paramAnonymous2MenuItem.findViewById(2131304700);
                ((TextView)localObject1).setPadding(0, 0, 0, 0);
                if (com.tencent.mm.storage.as.bjp(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2Int = 2131757975;
                  ((TextView)localObject1).setText(paramAnonymous2Int);
                  localObject1 = (CheckBox)paramAnonymous2MenuItem.findViewById(2131304698);
                  ((CheckBox)localObject1).setChecked(false);
                  localObject2 = (TextView)paramAnonymous2MenuItem.findViewById(2131304699);
                  ((TextView)localObject2).setText(2131757976);
                  if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource() != 18) {
                    break label1141;
                  }
                  ((CheckBox)localObject1).setVisibility(0);
                  ((TextView)localObject2).setVisibility(0);
                }
                for (;;)
                {
                  com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(2131757973), paramAnonymous2MenuItem, NormalUserFooterPreference.this.mContext.getString(2131755921), NormalUserFooterPreference.this.mContext.getString(2131755761), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(27292);
                      NormalUserFooterPreference.a.b(NormalUserFooterPreference.a.this);
                      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource() == 18)
                      {
                        NormalUserFooterPreference.a(NormalUserFooterPreference.this, 9);
                        if (this.BcM.isChecked()) {
                          NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
                        }
                      }
                      AppMethodBeat.o(27292);
                    }
                  }, null);
                  AppMethodBeat.o(27294);
                  return;
                  paramAnonymous2Int = 2131757974;
                  break;
                  label1141:
                  ((CheckBox)localObject1).setVisibility(8);
                  ((TextView)localObject2).setVisibility(8);
                }
                localObject1 = View.inflate(NormalUserFooterPreference.this.mContext, 2131495497, null);
                ((View)localObject1).setPadding(0, 0, 0, 0);
                localObject2 = (TextView)((View)localObject1).findViewById(2131304700);
                ((TextView)localObject2).setPadding(0, 0, 0, 0);
                if (ab.IQ(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext.getString(2131758274, new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).arJ() });
                  ((TextView)localObject2).setText(paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = (CheckBox)((View)localObject1).findViewById(2131304698);
                  paramAnonymous2MenuItem.setChecked(false);
                  localObject2 = (TextView)((View)localObject1).findViewById(2131304699);
                  ((TextView)localObject2).setText(2131757976);
                  if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource() != 18) {
                    break label1488;
                  }
                  paramAnonymous2MenuItem.setVisibility(0);
                  ((TextView)localObject2).setVisibility(0);
                }
                for (;;)
                {
                  com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(2131757869), (View)localObject1, NormalUserFooterPreference.this.mContext.getString(2131755778), NormalUserFooterPreference.this.mContext.getString(2131755761), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(27293);
                      NormalUserFooterPreference.a.this.eEQ();
                      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource() == 18)
                      {
                        NormalUserFooterPreference.a(NormalUserFooterPreference.this, 9);
                        if (paramAnonymous2MenuItem.isChecked()) {
                          NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
                        }
                      }
                      AppMethodBeat.o(27293);
                    }
                  }, null, 2131099922);
                  AppMethodBeat.o(27294);
                  return;
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext.getString(2131758272, new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).arJ() });
                  break;
                  label1488:
                  paramAnonymous2MenuItem.setVisibility(8);
                  ((TextView)localObject2).setVisibility(8);
                }
                paramAnonymous2MenuItem = NormalUserFooterPreference.a.this;
                Log.d("MicroMsg.NormalUserFooterPreference", "dealAddShortcut, username = " + NormalUserFooterPreference.a(paramAnonymous2MenuItem.BhA).field_username);
                com.tencent.mm.plugin.base.model.b.ai(NormalUserFooterPreference.b(paramAnonymous2MenuItem.BhA), NormalUserFooterPreference.a(paramAnonymous2MenuItem.BhA).field_username);
                MMHandlerThread.postToMainThreadDelayed(new NormalUserFooterPreference.a.9(paramAnonymous2MenuItem), 1000L);
                AppMethodBeat.o(27294);
                return;
                NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
              }
            }
          };
          paramAnonymousMenuItem.HLX = new o.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
            {
              AppMethodBeat.i(27295);
              com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent())), Integer.valueOf(7), Integer.valueOf(1), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              if (com.tencent.mm.storage.as.bjp(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
              {
                paramAnonymous2m.aS(1, 2131758167, 2131689839);
                if (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).arA()) {
                  break label318;
                }
                str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getResources().getString(2131758130);
                label151:
                paramAnonymous2m.b(2, str, 2131689842);
                if (!com.tencent.mm.storage.as.bjp(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
                  paramAnonymous2m.aS(3, 2131757984, 2131689830);
                }
                paramAnonymous2m.aS(4, 2131758048, 2131689844);
                paramAnonymous2m.aS(9, 2131756736, 2131689811);
                if (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).ary()) {
                  break label343;
                }
              }
              label318:
              label343:
              for (String str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757978);; str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757973))
              {
                paramAnonymous2m.b(5, str, 2131689807);
                if (!NormalUserFooterPreference.c(NormalUserFooterPreference.this)) {
                  paramAnonymous2m.aS(6, 2131756593, 2131689814);
                }
                paramAnonymous2m.aS(7, 2131757805, 2131689815);
                AppMethodBeat.o(27295);
                return;
                paramAnonymous2m.aS(1, 2131757968, 2131689839);
                break;
                str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getResources().getString(2131757892);
                break label151;
              }
            }
          };
          paramAnonymousMenuItem.dGm();
          AppMethodBeat.o(27296);
          return true;
        }
      });
    }
    
    protected void eEO()
    {
      if (NormalUserFooterPreference.d(NormalUserFooterPreference.this)) {
        NormalUserFooterPreference.b(NormalUserFooterPreference.this).showOptionMenu(false);
      }
      do
      {
        do
        {
          return;
        } while (z.aTY().equals(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
        if (!com.tencent.mm.contact.c.oR(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) {
          break;
        }
      } while (ab.Jv(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
      eEN();
      return;
      ac(false, false);
    }
    
    final void eEP()
    {
      this.Bcp = new e(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
      this.Bcp.HLX = new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(27299);
          paramAnonymousm.aS(2, 2131755840, 2131691478);
          paramAnonymousm.aS(1, 2131755842, 2131691479);
          AppMethodBeat.o(27299);
        }
      };
      this.Bcp.HLY = new o.g()
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
            NormalUserFooterPreference.this.eEK();
            AppMethodBeat.o(27300);
            return;
            NormalUserFooterPreference.this.eEL();
          }
        }
      };
      this.Bcp.dGm();
    }
    
    protected final void eEQ()
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(2), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
      final String str = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
      if (ab.IQ(str))
      {
        NormalUserFooterPreference.a(NormalUserFooterPreference.this).aqR();
        bg.aVF();
        com.tencent.mm.model.c.aSM().d(new com.tencent.mm.ba.d(str));
        bg.aVF();
        com.tencent.mm.model.c.aSN().aNa(str);
        bg.aVF();
        com.tencent.mm.model.c.aSX().Kj(str);
        return;
      }
      this.isDeleteCancel = false;
      Object localObject = NormalUserFooterPreference.this.mContext;
      NormalUserFooterPreference.this.mContext.getString(2131755998);
      final com.tencent.mm.ui.base.q localq = com.tencent.mm.ui.base.h.a((Context)localObject, NormalUserFooterPreference.this.mContext.getString(2131756029), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          NormalUserFooterPreference.a.this.isDeleteCancel = true;
        }
      });
      if (!this.isDeleteCancel) {}
      for (localObject = com.tencent.mm.pluginsdk.wallet.d.bfO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);; localObject = null)
      {
        if (!Util.isNullOrNil((String)localObject))
        {
          localq.dismiss();
          com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, false, NormalUserFooterPreference.this.mContext.getString(2131767679, new Object[] { localObject }), null, NormalUserFooterPreference.this.mContext.getString(2131761460), NormalUserFooterPreference.this.mContext.getString(2131758288), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27301);
              com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(4), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              NormalUserFooterPreference.a.this.isDeleteCancel = true;
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("Chat_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
              paramAnonymousDialogInterface.addFlags(67108864);
              com.tencent.mm.br.c.f(NormalUserFooterPreference.this.mContext, ".ui.chatting.ChattingUI", paramAnonymousDialogInterface);
              AppMethodBeat.o(27301);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27302);
              com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(3), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              localq.show();
              NormalUserFooterPreference.a.this.isDeleteCancel = false;
              NormalUserFooterPreference.a.this.XA(str);
              AppMethodBeat.o(27302);
            }
          }, -1, 2131099922);
          return;
        }
        XA(str);
        return;
      }
    }
    
    protected void onDetach()
    {
      ((com.tencent.mm.pluginsdk.h.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.h.a.class)).b(this);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      Log.i("MicroMsg.NormalUserFooterPreference", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramq.getType());
    }
  }
  
  final class b
    extends NormalUserFooterPreference.c
  {
    public b()
    {
      super();
    }
    
    protected final void eEM()
    {
      AppMethodBeat.i(27317);
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      if ((!com.tencent.mm.contact.c.oR(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) || ((com.tencent.mm.contact.c.oR(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) && (com.tencent.mm.storage.as.IG(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))))
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
          NormalUserFooterPreference.t(NormalUserFooterPreference.this).setOnClickListener(new NormalUserFooterPreference.b.1(this));
        }
        NormalUserFooterPreference.A(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(27315);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NearByFriendHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if ((NormalUserFooterPreference.c(NormalUserFooterPreference.this)) && (com.tencent.mm.bp.a.glC()))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Chat_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername);
              paramAnonymousView.putExtra("lbs_mode", true);
              paramAnonymousView.putExtra("lbs_ticket", NormalUserFooterPreference.C(NormalUserFooterPreference.this));
              paramAnonymousView.putExtra("add_scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              com.tencent.mm.plugin.profile.b.jRt.d(paramAnonymousView, NormalUserFooterPreference.b(NormalUserFooterPreference.this));
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NearByFriendHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(27315);
              return;
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
              paramAnonymousView.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              paramAnonymousView.putExtra(e.d.OyT, NormalUserFooterPreference.a(NormalUserFooterPreference.this).fuY);
              com.tencent.mm.plugin.profile.b.jRt.a(paramAnonymousView, NormalUserFooterPreference.this.mContext);
            }
          }
        });
        AppMethodBeat.o(27317);
        return;
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
        if ((NormalUserFooterPreference.this.eEJ()) || (NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(z.aTY()))) {
          break;
        }
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
      }
    }
    
    protected final void eEO()
    {
      AppMethodBeat.i(27316);
      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this) == null)
      {
        Log.e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
        AppMethodBeat.o(27316);
        return;
      }
      if ((!com.tencent.mm.contact.c.oR(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) || ((com.tencent.mm.contact.c.oR(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) && (com.tencent.mm.storage.as.IG(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))))
      {
        if (com.tencent.mm.storage.as.IG(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
        {
          ac(true, true);
          AppMethodBeat.o(27316);
          return;
        }
        ac(false, true);
        AppMethodBeat.o(27316);
        return;
      }
      eEN();
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
    
    private void eES()
    {
      AppMethodBeat.i(27327);
      Object localObject2 = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("Contact_Mobile_MD5");
      Object localObject1 = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("Contact_full_Mobile_MD5");
      String str = Util.nullAsNil((String)localObject2);
      localObject1 = Util.nullAsNil((String)localObject1);
      if ((!str.equals("")) || (!((String)localObject1).equals("")))
      {
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(str);
        if (localObject2 != null) {
          break label113;
        }
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU((String)localObject1);
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
    
    protected final void aSs()
    {
      AppMethodBeat.i(27323);
      super.aSs();
      AppMethodBeat.o(27323);
    }
    
    protected void eEM()
    {
      AppMethodBeat.i(27325);
      boolean bool;
      if (!ab.JE(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
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
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            NormalUserFooterPreference.c.this.eEQ();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27318);
          }
        });
        if (!com.tencent.mm.contact.c.oR(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) {
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if (NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent() != null)
          {
            paramAnonymousView = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("key_ww_add_session_id");
            if (!Util.isNullOrNil(paramAnonymousView))
            {
              localObject = new gr();
              ((gr)localObject).ut(paramAnonymousView);
              ((gr)localObject).eCt = 0L;
              ((gr)localObject).eKM = 1L;
              ((gr)localObject).bfK();
            }
          }
          NormalUserFooterPreference.c.this.eER();
          if (NormalUserFooterPreference.E(NormalUserFooterPreference.this) != 0) {
            com.tencent.mm.plugin.report.service.h.CyF.a(11263, new Object[] { Integer.valueOf(NormalUserFooterPreference.E(NormalUserFooterPreference.this)), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27319);
        }
      });
      if (!com.tencent.mm.contact.c.oR(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type))
      {
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(0);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.g(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
        if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ary())
        {
          NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(0);
          AppMethodBeat.o(27325);
        }
      }
      else
      {
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
        if ((!NormalUserFooterPreference.this.eEJ()) && (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(z.aTY())) && (!ab.JE(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!ab.Jv(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!com.tencent.mm.storage.as.bjp(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!ab.IR(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))) {
          NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
        }
        for (;;)
        {
          bg.aVF();
          if (!com.tencent.mm.model.c.aSN().bjO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
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
    
    protected final void eER()
    {
      AppMethodBeat.i(27326);
      if ((int)NormalUserFooterPreference.a(NormalUserFooterPreference.this).gMZ == 0)
      {
        bg.aVF();
        if (com.tencent.mm.model.c.aSN().aq(NormalUserFooterPreference.a(NormalUserFooterPreference.this)) != -1)
        {
          localObject = NormalUserFooterPreference.this;
          bg.aVF();
          NormalUserFooterPreference.a((NormalUserFooterPreference)localObject, com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
        }
      }
      if ((NormalUserFooterPreference.F(NormalUserFooterPreference.this)) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 12))
      {
        Log.d("MicroMsg.NormalUserFooterPreference", "qqNum " + NormalUserFooterPreference.G(NormalUserFooterPreference.this) + " qqReamrk " + NormalUserFooterPreference.H(NormalUserFooterPreference.this));
        if ((NormalUserFooterPreference.G(NormalUserFooterPreference.this) != 0L) && (NormalUserFooterPreference.H(NormalUserFooterPreference.this) != null) && (!NormalUserFooterPreference.H(NormalUserFooterPreference.this).equals("")))
        {
          localObject = com.tencent.mm.plugin.account.a.getQQListStg().AT(NormalUserFooterPreference.G(NormalUserFooterPreference.this));
          if (localObject != null) {
            break label452;
          }
          localObject = new com.tencent.mm.plugin.account.friend.a.as();
          ((com.tencent.mm.plugin.account.friend.a.as)localObject).nickname = "";
          ((com.tencent.mm.plugin.account.friend.a.as)localObject).kfN = NormalUserFooterPreference.G(NormalUserFooterPreference.this);
          ((com.tencent.mm.plugin.account.friend.a.as)localObject).kfV = NormalUserFooterPreference.H(NormalUserFooterPreference.this);
          ((com.tencent.mm.plugin.account.friend.a.as)localObject).username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
          ((com.tencent.mm.plugin.account.friend.a.as)localObject).boC();
          com.tencent.mm.plugin.account.a.getQQListStg().a((com.tencent.mm.plugin.account.friend.a.as)localObject);
        }
      }
      final com.tencent.mm.pluginsdk.ui.applet.a locala;
      final LinkedList localLinkedList;
      final String str;
      for (;;)
      {
        eES();
        locala = new com.tencent.mm.pluginsdk.ui.applet.a(NormalUserFooterPreference.this.mContext, new com.tencent.mm.pluginsdk.ui.applet.a.a()
        {
          public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(27320);
            if (paramAnonymousBoolean1)
            {
              NormalUserFooterPreference.this.iKx.event("hide_btn");
              NormalUserFooterPreference.this.iKx.doNotify();
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
                  com.tencent.mm.plugin.report.service.h.CyF.a(10991, new Object[] { Integer.valueOf(i), Integer.valueOf(6), Integer.valueOf(j) });
                }
              }
              AppMethodBeat.o(27320);
              return;
              if (paramAnonymousBoolean2)
              {
                com.tencent.mm.bj.d.bgN().gP(paramAnonymousString1, 2);
                au.aI(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername, 1);
                paramAnonymousString1 = new re();
                paramAnonymousString1.dXU.username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername;
                paramAnonymousString1.dXU.type = 1;
                EventCenter.instance.publish(paramAnonymousString1);
              }
              else
              {
                Log.e("MicroMsg.NormalUserFooterPreference", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(paramAnonymousString1)));
              }
            }
          }
        });
        localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(NormalUserFooterPreference.l(NormalUserFooterPreference.this)));
        localObject = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("source_from_user_name");
        str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("source_from_nick_name");
        locala.mz((String)localObject, str);
        locala.Kea = new a.b()
        {
          public final boolean aE(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(27321);
            String str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("room_name");
            int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slQ, 2);
            int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slT, 1000);
            SayHiWithSnsPermissionUI localSayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.class;
            Object localObject;
            if ((!com.tencent.mm.storage.as.bjp(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (i == 1)) {
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
              ((Intent)localObject).putExtra("source_from_user_name", this.BcD);
              ((Intent)localObject).putExtra("source_from_nick_name", str);
              ((Intent)localObject).putExtra("sayhi_with_sns_perm_send_verify", true);
              ((Intent)localObject).putExtra("sayhi_with_sns_perm_add_remark", true);
              ((Intent)localObject).putExtra("sayhi_with_sns_perm_set_label", false);
              ((Intent)localObject).putExtra(e.d.OyT, paramAnonymousString);
              ((Intent)localObject).putExtra("sayhi_verify_add_errcode", paramAnonymousInt);
              NormalUserFooterPreference.b(NormalUserFooterPreference.this).startActivityForResult((Intent)localObject, 0);
              AppMethodBeat.o(27321);
              return true;
              localObject = localSayHiWithSnsPermissionUI;
              if (!com.tencent.mm.storage.as.bjp(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
              {
                localObject = localSayHiWithSnsPermissionUI;
                if (i == 2)
                {
                  localObject = localSayHiWithSnsPermissionUI;
                  if (ab.aVc() >= j) {
                    localObject = SayHiWithSnsPermissionUI3.class;
                  }
                }
              }
            }
          }
        };
        str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("room_name");
        localObject = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra(e.d.OyT);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        Log.i("MicroMsg.NormalUserFooterPreference", "add contact case 1:%s", new Object[] { localObject });
        locala.beC((String)localObject);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, "", localLinkedList);
        AppMethodBeat.o(27326);
        return;
        label452:
        ((com.tencent.mm.plugin.account.friend.a.as)localObject).kfN = NormalUserFooterPreference.G(NormalUserFooterPreference.this);
        ((com.tencent.mm.plugin.account.friend.a.as)localObject).kfV = NormalUserFooterPreference.H(NormalUserFooterPreference.this);
        ((com.tencent.mm.plugin.account.friend.a.as)localObject).username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
        ((com.tencent.mm.plugin.account.friend.a.as)localObject).boC();
        com.tencent.mm.plugin.account.a.getQQListStg().a(NormalUserFooterPreference.G(NormalUserFooterPreference.this), (com.tencent.mm.plugin.account.friend.a.as)localObject);
        continue;
        if ((NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 58) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 59) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 60)) {
          com.tencent.mm.plugin.account.a.getGoogleFriendStorage().aG(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, 1);
        }
      }
      if (TextUtils.isEmpty(str))
      {
        Log.i("MicroMsg.NormalUserFooterPreference", "add contact case 2, %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).fuY });
        locala.beC(NormalUserFooterPreference.a(NormalUserFooterPreference.this).fuY);
        locala.h(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      if (!TextUtils.isEmpty(locala.wZz))
      {
        Log.i("MicroMsg.NormalUserFooterPreference", "add contact case 3, %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).fuY });
        locala.beC(NormalUserFooterPreference.a(NormalUserFooterPreference.this).fuY);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      bg.aVF();
      Object localObject = com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      if (localObject != null) {}
      for (localObject = Util.nullAs(((com.tencent.mm.g.c.ax)localObject).fuY, "");; localObject = "")
      {
        Log.i("MicroMsg.NormalUserFooterPreference", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localObject });
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        locala.beC((String)localObject);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      ay.a.iDq.a(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, new ay.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27322);
          bg.aVF();
          paramAnonymousString = com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          if (paramAnonymousString != null) {}
          for (paramAnonymousString = Util.nullAs(paramAnonymousString.fuY, "");; paramAnonymousString = "")
          {
            locala.beC(paramAnonymousString);
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
    
    protected final void eEM()
    {
      AppMethodBeat.i(27329);
      Assert.assertTrue(ab.Jf(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
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
    
    protected final void eEO() {}
  }
  
  public static abstract interface e {}
  
  final class f
    extends NormalUserFooterPreference.a
  {
    public f()
    {
      super();
    }
    
    protected final void eEM()
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
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$QrcodeHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.plugin.normsg.a.d.AEF.au(1, 1, 5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          paramAnonymousView.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
          paramAnonymousView.putExtra(e.d.OyT, NormalUserFooterPreference.a(NormalUserFooterPreference.this).fuY);
          com.tencent.mm.plugin.profile.b.jRt.a(paramAnonymousView, NormalUserFooterPreference.this.mContext);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$QrcodeHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27330);
        }
      });
      AppMethodBeat.o(27332);
    }
    
    protected final void eEO()
    {
      AppMethodBeat.i(27331);
      if ((NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) && (com.tencent.mm.contact.c.oR(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)))
      {
        eEN();
        AppMethodBeat.o(27331);
        return;
      }
      ac(false, true);
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
    
    protected final void eEM()
    {
      boolean bool2 = true;
      AppMethodBeat.i(27333);
      if (!z.Im(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
      {
        bool1 = true;
        Assert.assertTrue(bool1);
        if (ab.JE(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
          break label147;
        }
      }
      label147:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Assert.assertTrue(bool1);
        NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setText(2131758053);
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
    
    public final void eEO() {}
  }
  
  final class h
    extends NormalUserFooterPreference.a
  {
    public h()
    {
      super();
    }
    
    protected final void eEM()
    {
      AppMethodBeat.i(27334);
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
      if ((!NormalUserFooterPreference.this.eEJ()) && (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(z.aTY())) && (!ab.JE(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!ab.Jv(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))) {
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
      }
      for (;;)
      {
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setText(2131758049);
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(8);
        AppMethodBeat.o(27334);
        return;
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
      }
    }
    
    protected final void eEO() {}
  }
  
  class i
    extends NormalUserFooterPreference.c
    implements i
  {
    private ProgressDialog gtM;
    
    public i()
    {
      super();
    }
    
    private void aqQ()
    {
      AppMethodBeat.i(27341);
      NormalUserFooterPreference localNormalUserFooterPreference = NormalUserFooterPreference.this;
      bg.aVF();
      com.tencent.mm.storage.as localas2 = com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      if (localas2 != null)
      {
        localas1 = localas2;
        if ((int)localas2.gMZ != 0) {}
      }
      else
      {
        localas1 = NormalUserFooterPreference.a(NormalUserFooterPreference.this);
        bg.aVF();
        if (com.tencent.mm.model.c.aSN().ao(localas1)) {
          break label131;
        }
        Log.e("MicroMsg.NormalUserFooterPreference", "insert contact failed, username = " + localas1.field_username);
      }
      for (com.tencent.mm.storage.as localas1 = null;; localas1 = com.tencent.mm.model.c.aSN().Kn(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
      {
        NormalUserFooterPreference.a(localNormalUserFooterPreference, localas1);
        if (NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) {
          ab.B(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
        }
        AppMethodBeat.o(27341);
        return;
        label131:
        bg.aVF();
      }
    }
    
    protected void eEM()
    {
      AppMethodBeat.i(27338);
      onDetach();
      onStop();
      bg.azz().a(30, this);
      bg.azz().a(667, this);
      bg.azz().a(853, this);
      super.eEM();
      AppMethodBeat.o(27338);
    }
    
    protected void eET()
    {
      AppMethodBeat.i(27342);
      if (NormalUserFooterPreference.u(NormalUserFooterPreference.this) != null) {
        NormalUserFooterPreference.u(NormalUserFooterPreference.this).onDetach();
      }
      NormalUserFooterPreference.a(NormalUserFooterPreference.this, new NormalUserFooterPreference.c(NormalUserFooterPreference.this));
      NormalUserFooterPreference.u(NormalUserFooterPreference.this).aSs();
      AppMethodBeat.o(27342);
    }
    
    protected void onDetach()
    {
      AppMethodBeat.i(27340);
      if (this.gtM != null)
      {
        this.gtM.dismiss();
        this.gtM = null;
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
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      int j = 0;
      AppMethodBeat.i(27343);
      Log.d("MicroMsg.NormalUserFooterPreference", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      if ((paramq.getType() != 30) && (paramq.getType() != 667) && (paramq.getType() != 853))
      {
        AppMethodBeat.o(27343);
        return;
      }
      onStop();
      if (this.gtM != null)
      {
        this.gtM.dismiss();
        this.gtM = null;
      }
      if (!Util.isTopActivity(NormalUserFooterPreference.this.mContext))
      {
        AppMethodBeat.o(27343);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramq.getType() == 30)
        {
          paramInt1 = ((p)paramq).dKy;
          Log.d("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, opCode = ".concat(String.valueOf(paramInt1)));
          if ((paramInt1 == 1) || (paramInt1 == 3))
          {
            paramString = ((p)paramq).JVj;
            if ((paramString != null) && (paramString.contains(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)))
            {
              NormalUserFooterPreference.v(NormalUserFooterPreference.this);
              aqQ();
              eET();
              paramString = paramString.iterator();
              while (paramString.hasNext()) {
                com.tencent.mm.pluginsdk.ui.preference.b.cC((String)paramString.next(), NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              }
              bg.getNotification().alb();
            }
          }
          AppMethodBeat.o(27343);
          return;
        }
        if ((paramq.getType() == 667) || (paramq.getType() == 853))
        {
          NormalUserFooterPreference.v(NormalUserFooterPreference.this);
          aqQ();
          eET();
          com.tencent.mm.pluginsdk.ui.preference.b.cC(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, NormalUserFooterPreference.l(NormalUserFooterPreference.this));
          bg.getNotification().alb();
          AppMethodBeat.o(27343);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -302)) {
        if (paramq.getType() != 30) {
          break label885;
        }
      }
      label885:
      for (paramInt1 = ((p)paramq).dKy;; paramInt1 = 0)
      {
        Log.w("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", new Object[] { Integer.valueOf(paramInt1) });
        if ((paramInt1 == 3) || (paramq.getType() == 853)) {
          com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131758134), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755998), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755307), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131755761), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27337);
              NormalUserFooterPreference.i.this.eER();
              AppMethodBeat.o(27337);
            }
          }, null);
        }
        AppMethodBeat.o(27343);
        return;
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString)))
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
          if (bg.azz().aYT())
          {
            bg.azz().getNetworkServerIp();
            new StringBuilder().append(paramInt2);
            i = 1;
          }
          else
          {
            i = j;
            if (ag.dm(NormalUserFooterPreference.this.mContext))
            {
              com.tencent.mm.pluginsdk.ui.tools.m.iC(NormalUserFooterPreference.this.mContext);
              i = 1;
              continue;
              Toast.makeText(NormalUserFooterPreference.this.mContext, NormalUserFooterPreference.this.mContext.getString(2131760826, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
              i = 1;
              continue;
              if ((paramInt2 == -100) || (paramInt2 == -2023))
              {
                com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, bg.ayX(), com.tencent.mm.cb.a.aI(NormalUserFooterPreference.this.mContext, 2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(27335);
                    NormalUserFooterPreference.i.this.onStop();
                    paramAnonymousDialogInterface = new Intent();
                    paramAnonymousDialogInterface.putExtra("Intro_Switch", true).addFlags(67108864);
                    com.tencent.mm.plugin.profile.b.jRt.o(paramAnonymousDialogInterface, NormalUserFooterPreference.this.mContext);
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
                    com.tencent.mm.plugin.profile.b.jRt.o(paramAnonymousDialogInterface, NormalUserFooterPreference.this.mContext);
                    AppMethodBeat.o(27336);
                  }
                });
                i = 1;
              }
              else
              {
                if ((paramInt1 == 4) && (paramInt2 == -34)) {
                  paramq = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131760794);
                }
                for (;;)
                {
                  Toast.makeText(NormalUserFooterPreference.b(NormalUserFooterPreference.this), paramq, 1).show();
                  i = j;
                  break;
                  if ((paramInt1 == 4) && (paramInt2 == -94))
                  {
                    paramq = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131760797);
                  }
                  else if (paramInt1 == 4)
                  {
                    paramq = paramString;
                    if (!Util.isNullOrNil(paramString)) {}
                  }
                  else
                  {
                    paramq = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131765235);
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
      bg.azz().b(30, this);
      bg.azz().b(667, this);
      bg.azz().b(853, this);
      AppMethodBeat.o(27339);
    }
  }
  
  final class j
    extends NormalUserFooterPreference.i
    implements i
  {
    public j()
    {
      super();
    }
    
    protected final void eEM()
    {
      AppMethodBeat.i(27348);
      super.eEM();
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
      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ary())
      {
        NormalUserFooterPreference.x(NormalUserFooterPreference.this).setText(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757978));
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().removeExtra("Accept_NewFriend_FromOutside");
            int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slQ, 2);
            int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slT, 1000);
            localObject = SayHiWithSnsPermissionUI.class;
            if ((!com.tencent.mm.storage.as.bjp(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (i == 1)) {
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
              if (!com.tencent.mm.storage.as.bjp(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
              {
                paramAnonymousView = (View)localObject;
                if (i == 2)
                {
                  paramAnonymousView = (View)localObject;
                  if (ab.aVc() >= j) {
                    paramAnonymousView = SayHiWithSnsPermissionUI3.class;
                  }
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ary())
            {
              ab.u(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
              NormalUserFooterPreference.a(NormalUserFooterPreference.this).aqT();
              NormalUserFooterPreference.j.this.eEM();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(27346);
              return;
            }
            paramAnonymousView = NormalUserFooterPreference.this.mContext;
            localObject = NormalUserFooterPreference.this.mContext;
            if (com.tencent.mm.storage.as.bjp(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {}
            for (int i = 2131757975;; i = 2131757974)
            {
              com.tencent.mm.ui.base.h.a(paramAnonymousView, ((Context)localObject).getString(i), NormalUserFooterPreference.this.mContext.getString(2131757973), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(27345);
                  ab.t(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  NormalUserFooterPreference.a(NormalUserFooterPreference.this).aqS();
                  NormalUserFooterPreference.j.this.eEM();
                  AppMethodBeat.o(27345);
                }
              }, null);
              break;
            }
          }
        });
        AppMethodBeat.o(27348);
        return;
        NormalUserFooterPreference.x(NormalUserFooterPreference.this).setText(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(2131757973));
      }
    }
    
    protected final void eEO()
    {
      AppMethodBeat.i(27347);
      if ((NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) && (com.tencent.mm.contact.c.oR(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)))
      {
        eEN();
        AppMethodBeat.o(27347);
        return;
      }
      ac(false, true);
      AppMethodBeat.o(27347);
    }
    
    protected final void eET()
    {
      AppMethodBeat.i(27350);
      super.eET();
      AppMethodBeat.o(27350);
    }
    
    protected final void onDetach()
    {
      AppMethodBeat.i(27349);
      super.onDetach();
      AppMethodBeat.o(27349);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(27351);
      super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      AppMethodBeat.o(27351);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference
 * JD-Core Version:    0.7.0.1
 */