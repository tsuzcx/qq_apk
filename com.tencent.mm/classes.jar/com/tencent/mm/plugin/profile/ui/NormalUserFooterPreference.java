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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.fv;
import com.tencent.mm.f.a.se;
import com.tencent.mm.f.a.yx;
import com.tencent.mm.f.b.a.iw;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.dgv;
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
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.f.d;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class NormalUserFooterPreference
  extends Preference
  implements MStorage.IOnStorageChange
{
  String BLy;
  boolean GWK;
  boolean GXw;
  int GYZ;
  long GZN;
  int GZr;
  boolean HaS;
  String HaT;
  boolean HaU;
  boolean HaV;
  boolean HaW;
  boolean HaX;
  a HaY;
  private View HaZ;
  private Button Hba;
  private Button Hbb;
  private Button Hbc;
  private View Hbd;
  private Button Hbe;
  private TextView Hbf;
  private View Hbg;
  private Button Hbh;
  private Button Hbi;
  private Button Hbj;
  private Button Hbk;
  private Button Hbl;
  private Button Hbm;
  private TextView Hbn;
  boolean Hbo;
  public boolean Hbp;
  com.tencent.mm.storage.as contact;
  public ProgressDialog iXX;
  MMActivity iXq;
  private Button jLo;
  protected MStorageEvent<e, String> lAD;
  int mXL;
  String she;
  private boolean vkO;
  
  public NormalUserFooterPreference(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(27352);
    this.GWK = false;
    this.GZN = 0L;
    this.HaT = "";
    this.BLy = "";
    this.HaU = false;
    this.HaW = false;
    this.HaX = false;
    this.Hbo = false;
    this.GYZ = 0;
    this.iXX = null;
    this.Hbp = false;
    this.she = null;
    this.lAD = new MStorageEvent() {};
    this.iXq = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27352);
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27353);
    this.GWK = false;
    this.GZN = 0L;
    this.HaT = "";
    this.BLy = "";
    this.HaU = false;
    this.HaW = false;
    this.HaX = false;
    this.Hbo = false;
    this.GYZ = 0;
    this.iXX = null;
    this.Hbp = false;
    this.she = null;
    this.lAD = new MStorageEvent() {};
    this.iXq = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27353);
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27354);
    this.GWK = false;
    this.GZN = 0L;
    this.HaT = "";
    this.BLy = "";
    this.HaU = false;
    this.HaW = false;
    this.HaX = false;
    this.Hbo = false;
    this.GYZ = 0;
    this.iXX = null;
    this.Hbp = false;
    this.she = null;
    this.lAD = new MStorageEvent() {};
    this.iXq = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27354);
  }
  
  private void init()
  {
    this.vkO = false;
    this.HaY = null;
  }
  
  public final boolean cQX()
  {
    AppMethodBeat.i(27359);
    if (this.HaY != null) {
      this.HaY.onDetach();
    }
    this.lAD.removeAll();
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    AppMethodBeat.o(27359);
    return true;
  }
  
  public final boolean fqx()
  {
    AppMethodBeat.i(27358);
    if ((this.Hbo) && (com.tencent.mm.contact.d.rk(this.contact.field_type)))
    {
      this.Hbm.setVisibility(0);
      AppMethodBeat.o(27358);
      return true;
    }
    this.Hbm.setVisibility(8);
    AppMethodBeat.o(27358);
    return false;
  }
  
  public final void fqy()
  {
    AppMethodBeat.i(27361);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.iXq, "android.permission.RECORD_AUDIO", 82, "", "");
    Log.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.iXq });
    if (!bool)
    {
      AppMethodBeat.o(27361);
      return;
    }
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 5;
    localaaq.fZM.talker = this.contact.field_username;
    localaaq.fZM.context = this.iXq;
    localaaq.fZM.fZI = 4;
    EventCenter.instance.publish(localaaq);
    AppMethodBeat.o(27361);
  }
  
  public final void fqz()
  {
    AppMethodBeat.i(27362);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.iXq, "android.permission.CAMERA", 19, "", "");
    Log.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.iXq });
    if (!bool)
    {
      AppMethodBeat.o(27362);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.iXq, "android.permission.RECORD_AUDIO", 19, "", "");
    Log.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.iXq });
    if (!bool)
    {
      AppMethodBeat.o(27362);
      return;
    }
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 5;
    localaaq.fZM.talker = this.contact.field_username;
    localaaq.fZM.context = this.iXq;
    localaaq.fZM.fZI = 2;
    EventCenter.instance.publish(localaaq);
    AppMethodBeat.o(27362);
  }
  
  final void initView()
  {
    AppMethodBeat.i(27355);
    if ((!this.vkO) || (this.contact == null))
    {
      Log.w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.vkO + " contact = " + this.contact);
      if (this.HaY != null) {
        try
        {
          this.HaY.fqC();
          AppMethodBeat.o(27355);
          return;
        }
        catch (Throwable localThrowable) {}
      }
      AppMethodBeat.o(27355);
      return;
    }
    if (this.HaY != null) {
      this.HaY.bbp();
    }
    fqx();
    AppMethodBeat.o(27355);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27356);
    Log.d("MicroMsg.NormalUserFooterPreference", "on bindView " + paramView.toString());
    this.HaZ = paramView.findViewById(R.h.dBo);
    this.Hba = ((Button)paramView.findViewById(R.h.contact_info_verify_accept));
    this.Hbb = ((Button)paramView.findViewById(R.h.contact_info_delete_contact));
    this.Hbe = ((Button)paramView.findViewById(R.h.dBI));
    this.Hbf = ((TextView)paramView.findViewById(R.h.dBM));
    this.Hbd = paramView.findViewById(R.h.dBJ);
    this.Hbc = ((Button)paramView.findViewById(R.h.dBH));
    this.Hbj = ((Button)paramView.findViewById(R.h.dAK));
    this.Hbg = paramView.findViewById(R.h.dBw);
    this.Hbh = ((Button)paramView.findViewById(R.h.dBv));
    this.Hbi = ((Button)paramView.findViewById(R.h.dBx));
    this.jLo = ((Button)paramView.findViewById(R.h.dBy));
    this.Hbm = ((Button)paramView.findViewById(R.h.dBl));
    this.Hbk = ((Button)paramView.findViewById(R.h.dBK));
    this.Hbl = ((Button)paramView.findViewById(R.h.dAS));
    this.Hbn = ((TextView)paramView.findViewById(R.h.dBm));
    this.vkO = true;
    initView();
    super.onBindView(paramView);
    if ((this.iXq.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) == true) && (this.Hba != null)) {
      this.Hba.performClick();
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
      bh.beI();
      this.contact = com.tencent.mm.model.c.bbL().RG(this.contact.field_username);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27291);
          NormalUserFooterPreference.this.fqx();
          AppMethodBeat.o(27291);
        }
      });
    }
    AppMethodBeat.o(27360);
  }
  
  abstract class a
    implements i, com.tencent.mm.pluginsdk.i.a.a
  {
    private e GWo = null;
    private boolean isDeleteCancel = false;
    
    public a() {}
    
    private void afm(String paramString)
    {
      NormalUserFooterPreference.a(NormalUserFooterPreference.this).axl();
      if (com.tencent.mm.storage.as.bvK(paramString))
      {
        ((u)com.tencent.mm.kernel.h.ae(u.class)).Lz(paramString);
        az.a.ltq.Rs(paramString);
        return;
      }
      ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.i.a.class)).afm(paramString);
    }
    
    private void fqD()
    {
      this.GWo = new e(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
      this.GWo.ODT = new q.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
        {
          AppMethodBeat.i(27299);
          paramAnonymouso.aW(2, R.l.app_field_voip, R.k.sharemore_videovoip);
          paramAnonymouso.aW(1, R.l.app_field_voipaudio, R.k.sharemore_voipvoice);
          AppMethodBeat.o(27299);
        }
      };
      this.GWo.ODU = new q.g()
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
            NormalUserFooterPreference.this.fqy();
            AppMethodBeat.o(27300);
            return;
            NormalUserFooterPreference.this.fqz();
          }
        }
      };
      this.GWo.eik();
    }
    
    public final void a(String paramString, int paramInt, dgv paramdgv)
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
          com.tencent.mm.plugin.profile.b.mIG.n(paramString, NormalUserFooterPreference.this.mContext);
          return;
          paramdgv = com.tencent.mm.plugin.account.b.getQQListStg().aaM(paramString);
          if (paramdgv == null) {
            break;
          }
          paramdgv.mXn = 1;
          com.tencent.mm.plugin.account.b.getQQListStg().a(paramdgv.mXm, paramdgv);
          break;
          paramdgv = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(paramString);
          if ((paramdgv != null) && (!Util.isNullOrNil(paramdgv.mVx)))
          {
            paramdgv.status = 1;
            com.tencent.mm.plugin.account.b.getAddrUploadStg().a(paramdgv.getMd5(), paramdgv);
          }
          com.tencent.mm.platformtools.t.P(NormalUserFooterPreference.this.mContext, paramString);
          break;
          com.tencent.mm.platformtools.t.P(NormalUserFooterPreference.this.mContext, paramString);
          break;
          paramdgv = com.tencent.mm.plugin.account.b.getFacebookFrdStg();
          Object localObject3 = "select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + paramString + "\"";
          localObject3 = paramdgv.lvy.rawQuery((String)localObject3, null, 2);
          if (localObject3 == null) {
            paramdgv = localObject1;
          }
          while (paramdgv != null)
          {
            paramdgv.status = 100;
            com.tencent.mm.plugin.account.b.getFacebookFrdStg().a(paramdgv);
            break;
            paramdgv = localObject2;
            if (((Cursor)localObject3).moveToFirst())
            {
              paramdgv = new g();
              paramdgv.convertFrom((Cursor)localObject3);
            }
            ((Cursor)localObject3).close();
          }
          com.tencent.mm.plugin.account.b.getGoogleFriendStorage().aZ(paramString, 2);
          break;
          Log.i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
          com.tencent.mm.platformtools.t.P(NormalUserFooterPreference.this.mContext, paramString);
        }
        label501:
        NormalUserFooterPreference.b(NormalUserFooterPreference.this).setResult(-1, NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().putExtra("_delete_ok_", true));
        ((Activity)NormalUserFooterPreference.this.mContext).finish();
        return;
      }
      if (!Util.isNullOrNil(paramdgv.lpy))
      {
        com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.b(NormalUserFooterPreference.this), paramdgv.lpy, paramdgv.fwr, true);
        return;
      }
      com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.app_delete_failed), "", true);
    }
    
    final void aUJ(String paramString)
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
      com.tencent.mm.plugin.profile.b.mIG.l(paramString, NormalUserFooterPreference.this.mContext);
    }
    
    protected final void an(final boolean paramBoolean1, final boolean paramBoolean2)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        return;
      }
      NormalUserFooterPreference.b(NormalUserFooterPreference.this).addIconOptionMenu(0, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27307);
          paramAnonymousMenuItem = new e(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
          paramAnonymousMenuItem.ODU = new q.g()
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
                NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this, NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
                AppMethodBeat.o(27305);
                return;
              case 8: 
                NormalUserFooterPreference.a.b(NormalUserFooterPreference.a.this);
                AppMethodBeat.o(27305);
                return;
              }
              paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext;
              Context localContext = NormalUserFooterPreference.this.mContext;
              if (com.tencent.mm.storage.as.bvK(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {}
              for (paramAnonymous2Int = R.l.eyM;; paramAnonymous2Int = R.l.eyL)
              {
                com.tencent.mm.ui.base.h.a(paramAnonymous2MenuItem, localContext.getString(paramAnonymous2Int), NormalUserFooterPreference.this.mContext.getString(R.l.contact_info_movein_blacklist), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(27304);
                    NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
                    AppMethodBeat.o(27304);
                  }
                }, null);
                break;
              }
            }
          };
          paramAnonymousMenuItem.ODT = new q.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
            {
              AppMethodBeat.i(27306);
              if (!NormalUserFooterPreference.a.10.this.Hbu)
              {
                if (!com.tencent.mm.storage.as.bvK(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
                  break label99;
                }
                paramAnonymous2o.aW(1, R.l.eAq, R.k.bottomsheet_icon_remarks);
              }
              while (!NormalUserFooterPreference.a.10.this.Hbv) {
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ayc())
                {
                  paramAnonymous2o.aW(8, R.l.contact_info_moveout_blacklist, R.k.bottomsheet_icon_blacklist);
                  AppMethodBeat.o(27306);
                  return;
                  label99:
                  paramAnonymous2o.aW(1, R.l.eyI, R.k.bottomsheet_icon_remarks);
                }
                else if (!ab.Qk(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2o.aW(5, R.l.contact_info_movein_blacklist, R.k.bottomsheet_icon_blacklist);
                }
              }
              AppMethodBeat.o(27306);
            }
          };
          paramAnonymousMenuItem.eik();
          AppMethodBeat.o(27307);
          return true;
        }
      });
    }
    
    protected void bbp()
    {
      fqA();
      fqC();
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27308);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.NormalUserFooterPreference", "sendButton onClick %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
          if (NormalUserFooterPreference.e(NormalUserFooterPreference.this)) {
            NormalUserFooterPreference.a.f(NormalUserFooterPreference.a.this);
          }
          for (;;)
          {
            com.tencent.mm.plugin.profile.d.a(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent(), 4, 1, NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27308);
            return;
            NormalUserFooterPreference.a.g(NormalUserFooterPreference.a.this);
          }
        }
      });
      NormalUserFooterPreference.g(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27309);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_permission_userName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          paramAnonymousView.putExtra("sns_permission_anim", true);
          paramAnonymousView.putExtra("sns_permission_block_scene", 4);
          com.tencent.mm.by.c.b(NormalUserFooterPreference.b(NormalUserFooterPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27309);
        }
      });
      NormalUserFooterPreference.h(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27310);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          NormalUserFooterPreference.a.h(NormalUserFooterPreference.a.this);
          com.tencent.mm.plugin.profile.d.a(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent(), 5, 1, NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27310);
        }
      });
      NormalUserFooterPreference.i(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27311);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          NormalUserFooterPreference.a.d(NormalUserFooterPreference.a.this);
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
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          NormalUserFooterPreference.a.d(NormalUserFooterPreference.a.this);
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
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          NormalUserFooterPreference.a.d(NormalUserFooterPreference.a.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27313);
        }
      });
      ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.i.a.class)).a(this);
    }
    
    protected abstract void fqA();
    
    protected final void fqB()
    {
      NormalUserFooterPreference.b(NormalUserFooterPreference.this).addIconOptionMenu(0, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27296);
          paramAnonymousMenuItem = new e(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
          paramAnonymousMenuItem.ODU = new q.g()
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
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ayh())
                {
                  ab.E(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  com.tencent.mm.ui.base.h.cO(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.eAk));
                }
                for (;;)
                {
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this;
                  bh.beI();
                  NormalUserFooterPreference.a(paramAnonymous2MenuItem, com.tencent.mm.model.c.bbL().RG(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
                  AppMethodBeat.o(27294);
                  return;
                  ab.D(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  com.tencent.mm.ui.base.h.cO(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.eyx));
                }
                paramAnonymous2MenuItem = new Intent();
                paramAnonymous2MenuItem.putExtra("sns_permission_userName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
                paramAnonymous2MenuItem.putExtra("sns_permission_anim", true);
                paramAnonymous2MenuItem.putExtra("sns_permission_block_scene", 1);
                com.tencent.mm.by.c.b(NormalUserFooterPreference.b(NormalUserFooterPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymous2MenuItem);
                AppMethodBeat.o(27294);
                return;
                NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this);
                AppMethodBeat.o(27294);
                return;
                NormalUserFooterPreference.this.lAD.event("hide_btn");
                NormalUserFooterPreference.this.lAD.doNotify();
                NormalUserFooterPreference.a locala = NormalUserFooterPreference.a.this;
                paramAnonymous2MenuItem = locala.Hbq;
                bh.beI();
                NormalUserFooterPreference.a(paramAnonymous2MenuItem, com.tencent.mm.model.c.bbL().RG(NormalUserFooterPreference.a(locala.Hbq).field_username));
                if (!com.tencent.mm.contact.d.rk(NormalUserFooterPreference.a(locala.Hbq).field_type))
                {
                  locala.aUJ(NormalUserFooterPreference.a(locala.Hbq).field_username);
                  AppMethodBeat.o(27294);
                  return;
                }
                Intent localIntent = new Intent();
                localIntent.putExtra("Contact_Scene", NormalUserFooterPreference.l(locala.Hbq));
                localIntent.putExtra("Contact_User", NormalUserFooterPreference.a(locala.Hbq).field_username);
                localIntent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(locala.Hbq).getIntent().getStringExtra("Contact_RoomNickname"));
                localIntent.putExtra("contact_phone_number_list", NormalUserFooterPreference.a(locala.Hbq).hDw);
                Object localObject2 = "";
                Object localObject1 = localObject2;
                String str;
                if (!NormalUserFooterPreference.a(locala.Hbq).ayo())
                {
                  localObject1 = NormalUserFooterPreference.b(locala.Hbq).getIntent().getStringExtra("Contact_Mobile_MD5");
                  str = NormalUserFooterPreference.b(locala.Hbq).getIntent().getStringExtra("Contact_full_Mobile_MD5");
                  if ((!Util.isNullOrNil((String)localObject1)) || (!Util.isNullOrNil(str))) {
                    break label724;
                  }
                  paramAnonymous2MenuItem = localObject3;
                  if (!Util.isNullOrNil(NormalUserFooterPreference.a(locala.Hbq).field_username)) {
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(NormalUserFooterPreference.a(locala.Hbq).field_username);
                  }
                }
                for (;;)
                {
                  localObject1 = localObject2;
                  if (paramAnonymous2MenuItem != null)
                  {
                    localObject1 = localObject2;
                    if (!Util.isNullOrNil(paramAnonymous2MenuItem.getMd5())) {
                      localObject1 = Util.nullAsNil(paramAnonymous2MenuItem.bxY()).replace(" ", "");
                    }
                  }
                  localIntent.putExtra("contact_phone_number_by_md5", (String)localObject1);
                  com.tencent.mm.plugin.profile.b.mIG.k(localIntent, locala.Hbq.mContext);
                  AppMethodBeat.o(27294);
                  return;
                  label724:
                  if (Util.isNullOrNil((String)localObject1))
                  {
                    paramAnonymous2MenuItem = localObject3;
                    if (Util.isNullOrNil(str)) {}
                  }
                  else
                  {
                    localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaA((String)localObject1);
                    if (localObject1 != null)
                    {
                      paramAnonymous2MenuItem = (MenuItem)localObject1;
                      if (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).getMd5())) {}
                    }
                    else
                    {
                      paramAnonymous2MenuItem = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaA(str);
                    }
                  }
                }
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ayc())
                {
                  NormalUserFooterPreference.a.b(NormalUserFooterPreference.a.this);
                  AppMethodBeat.o(27294);
                  return;
                }
                paramAnonymous2MenuItem = View.inflate(NormalUserFooterPreference.this.mContext, R.i.mm_alert_checkbox, null);
                paramAnonymous2MenuItem.setPadding(0, 0, 0, 0);
                localObject1 = (TextView)paramAnonymous2MenuItem.findViewById(R.h.mm_alert_dialog_info);
                ((TextView)localObject1).setPadding(0, 0, 0, 0);
                if (com.tencent.mm.storage.as.bvK(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2Int = R.l.eyM;
                  ((TextView)localObject1).setText(paramAnonymous2Int);
                  localObject1 = (CheckBox)paramAnonymous2MenuItem.findViewById(R.h.mm_alert_dialog_cb);
                  ((CheckBox)localObject1).setChecked(false);
                  localObject2 = (TextView)paramAnonymous2MenuItem.findViewById(R.h.mm_alert_dialog_cb_txt);
                  ((TextView)localObject2).setText(R.l.eyN);
                  if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource() != 18) {
                    break label1061;
                  }
                  ((CheckBox)localObject1).setVisibility(0);
                  ((TextView)localObject2).setVisibility(0);
                }
                for (;;)
                {
                  com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(R.l.contact_info_movein_blacklist), paramAnonymous2MenuItem, NormalUserFooterPreference.this.mContext.getString(R.l.app_ok), NormalUserFooterPreference.this.mContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(27292);
                      NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
                      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource() == 18)
                      {
                        NormalUserFooterPreference.a(NormalUserFooterPreference.this, 9);
                        if (this.GWL.isChecked()) {
                          NormalUserFooterPreference.a.d(NormalUserFooterPreference.a.this);
                        }
                      }
                      AppMethodBeat.o(27292);
                    }
                  }, null);
                  AppMethodBeat.o(27294);
                  return;
                  paramAnonymous2Int = R.l.eyL;
                  break;
                  label1061:
                  ((CheckBox)localObject1).setVisibility(8);
                  ((TextView)localObject2).setVisibility(8);
                }
                localObject1 = View.inflate(NormalUserFooterPreference.this.mContext, R.i.mm_alert_checkbox, null);
                ((View)localObject1).setPadding(0, 0, 0, 0);
                localObject2 = (TextView)((View)localObject1).findViewById(R.h.mm_alert_dialog_info);
                ((TextView)localObject2).setPadding(0, 0, 0, 0);
                if (ab.Qj(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext.getString(R.l.eAY, new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).ays() });
                  ((TextView)localObject2).setText(paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = (CheckBox)((View)localObject1).findViewById(R.h.mm_alert_dialog_cb);
                  paramAnonymous2MenuItem.setChecked(false);
                  localObject2 = (TextView)((View)localObject1).findViewById(R.h.mm_alert_dialog_cb_txt);
                  ((TextView)localObject2).setText(R.l.eyN);
                  if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource() != 18) {
                    break label1408;
                  }
                  paramAnonymous2MenuItem.setVisibility(0);
                  ((TextView)localObject2).setVisibility(0);
                }
                for (;;)
                {
                  com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(R.l.contact_info_delete_contact), (View)localObject1, NormalUserFooterPreference.this.mContext.getString(R.l.app_delete), NormalUserFooterPreference.this.mContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(27293);
                      NormalUserFooterPreference.a.this.fqE();
                      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource() == 18)
                      {
                        NormalUserFooterPreference.a(NormalUserFooterPreference.this, 9);
                        if (paramAnonymous2MenuItem.isChecked()) {
                          NormalUserFooterPreference.a.d(NormalUserFooterPreference.a.this);
                        }
                      }
                      AppMethodBeat.o(27293);
                    }
                  }, null, R.e.alert_btn_color_warn);
                  AppMethodBeat.o(27294);
                  return;
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext.getString(R.l.eAW, new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).ays() });
                  break;
                  label1408:
                  paramAnonymous2MenuItem.setVisibility(8);
                  ((TextView)localObject2).setVisibility(8);
                }
                NormalUserFooterPreference.a.e(NormalUserFooterPreference.a.this);
                AppMethodBeat.o(27294);
                return;
                NormalUserFooterPreference.a.d(NormalUserFooterPreference.a.this);
              }
            }
          };
          paramAnonymousMenuItem.ODT = new q.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
            {
              AppMethodBeat.i(27295);
              com.tencent.mm.plugin.profile.d.a(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent(), 7, 1, NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
              if (com.tencent.mm.storage.as.bvK(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
              {
                paramAnonymous2o.aW(1, R.l.eAq, R.k.bottomsheet_icon_remarks);
                if (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).ayh()) {
                  break label302;
                }
                str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getResources().getString(R.l.eAj);
                label120:
                paramAnonymous2o.b(2, str, R.k.bottomsheet_icon_star);
                if (!com.tencent.mm.storage.as.bvK(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
                  paramAnonymous2o.aW(3, R.l.contact_info_op_sns_permission, R.k.bottomsheet_icon_moment);
                }
                paramAnonymous2o.aW(4, R.l.ezh, R.k.bottomsheet_icon_transmit);
                paramAnonymous2o.aW(9, R.l.biz_report_text, R.k.bottomsheet_icon_complain);
                if (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).ayc()) {
                  break label328;
                }
              }
              label302:
              label328:
              for (String str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.contact_info_moveout_blacklist);; str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.contact_info_movein_blacklist))
              {
                paramAnonymous2o.b(5, str, R.k.bottomsheet_icon_blacklist);
                if (!NormalUserFooterPreference.c(NormalUserFooterPreference.this)) {
                  paramAnonymous2o.aW(6, R.l.bind_mcontact_del_btn_text, R.k.bottomsheet_icon_del);
                }
                paramAnonymous2o.aW(7, R.l.exQ, R.k.bottomsheet_icon_desktop);
                AppMethodBeat.o(27295);
                return;
                paramAnonymous2o.aW(1, R.l.eyI, R.k.bottomsheet_icon_remarks);
                break;
                str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getResources().getString(R.l.eyw);
                break label120;
              }
            }
          };
          paramAnonymousMenuItem.eik();
          AppMethodBeat.o(27296);
          return true;
        }
      });
    }
    
    protected void fqC()
    {
      if (NormalUserFooterPreference.d(NormalUserFooterPreference.this)) {
        NormalUserFooterPreference.b(NormalUserFooterPreference.this).showOptionMenu(false);
      }
      do
      {
        do
        {
          return;
        } while (z.bcZ().equals(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
        if (!com.tencent.mm.contact.d.rk(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) {
          break;
        }
      } while (ab.QO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
      fqB();
      return;
      an(false, false);
    }
    
    protected final void fqE()
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(2), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
      final String str = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
      if (ab.Qj(str))
      {
        NormalUserFooterPreference.a(NormalUserFooterPreference.this).axl();
        bh.beI();
        com.tencent.mm.model.c.bbK().d(new com.tencent.mm.bd.d(str));
        bh.beI();
        com.tencent.mm.model.c.bbL().bwp(str);
        bh.beI();
        com.tencent.mm.model.c.bbV().RC(str);
        return;
      }
      this.isDeleteCancel = false;
      Object localObject = NormalUserFooterPreference.this.mContext;
      NormalUserFooterPreference.this.mContext.getString(R.l.app_tip);
      final s locals = com.tencent.mm.ui.base.h.a((Context)localObject, NormalUserFooterPreference.this.mContext.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(289006);
          NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this, true);
          AppMethodBeat.o(289006);
        }
      });
      if (!this.isDeleteCancel) {}
      for (localObject = com.tencent.mm.pluginsdk.wallet.d.bsh(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);; localObject = null)
      {
        if (!Util.isNullOrNil((String)localObject))
        {
          locals.dismiss();
          com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, false, NormalUserFooterPreference.this.mContext.getString(R.l.eVz, new Object[] { localObject }), null, NormalUserFooterPreference.this.mContext.getString(R.l.goto_conversation), NormalUserFooterPreference.this.mContext.getString(R.l.eBb), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27301);
              com.tencent.mm.plugin.report.service.h.IzE.a(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(4), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this, true);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("Chat_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
              paramAnonymousDialogInterface.addFlags(67108864);
              com.tencent.mm.by.c.f(NormalUserFooterPreference.this.mContext, ".ui.chatting.ChattingUI", paramAnonymousDialogInterface);
              AppMethodBeat.o(27301);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27302);
              com.tencent.mm.plugin.report.service.h.IzE.a(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(3), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              locals.show();
              NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this, false);
              NormalUserFooterPreference.a.b(NormalUserFooterPreference.a.this, str);
              AppMethodBeat.o(27302);
            }
          }, -1, R.e.alert_btn_color_warn);
          return;
        }
        afm(str);
        return;
      }
    }
    
    protected void onDetach()
    {
      ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.i.a.class)).b(this);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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
    
    protected final void fqA()
    {
      AppMethodBeat.i(27317);
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      if ((!com.tencent.mm.contact.d.rk(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) || ((com.tencent.mm.contact.d.rk(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) && (com.tencent.mm.storage.as.PY(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))))
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
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NearByFriendHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if ((NormalUserFooterPreference.c(NormalUserFooterPreference.this)) && (com.tencent.mm.bw.a.hft()))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Chat_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername);
              paramAnonymousView.putExtra("lbs_mode", true);
              paramAnonymousView.putExtra("lbs_ticket", NormalUserFooterPreference.C(NormalUserFooterPreference.this));
              paramAnonymousView.putExtra("add_scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              com.tencent.mm.plugin.profile.b.mIG.d(paramAnonymousView, NormalUserFooterPreference.b(NormalUserFooterPreference.this));
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NearByFriendHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(27315);
              return;
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
              paramAnonymousView.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              paramAnonymousView.putExtra(f.d.VRW, NormalUserFooterPreference.a(NormalUserFooterPreference.this).hDx);
              com.tencent.mm.plugin.profile.b.mIG.a(paramAnonymousView, NormalUserFooterPreference.this.mContext);
            }
          }
        });
        AppMethodBeat.o(27317);
        return;
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
        if ((NormalUserFooterPreference.this.fqx()) || (NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(z.bcZ()))) {
          break;
        }
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
      }
    }
    
    protected final void fqC()
    {
      AppMethodBeat.i(27316);
      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this) == null)
      {
        Log.e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
        AppMethodBeat.o(27316);
        return;
      }
      if ((!com.tencent.mm.contact.d.rk(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) || ((com.tencent.mm.contact.d.rk(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) && (com.tencent.mm.storage.as.PY(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))))
      {
        if (com.tencent.mm.storage.as.PY(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
        {
          an(true, true);
          AppMethodBeat.o(27316);
          return;
        }
        an(false, true);
        AppMethodBeat.o(27316);
        return;
      }
      fqB();
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
    
    private void fqG()
    {
      AppMethodBeat.i(27327);
      Object localObject2 = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("Contact_Mobile_MD5");
      Object localObject1 = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("Contact_full_Mobile_MD5");
      String str = Util.nullAsNil((String)localObject2);
      localObject1 = Util.nullAsNil((String)localObject1);
      if ((!str.equals("")) || (!((String)localObject1).equals("")))
      {
        localObject2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaA(str);
        if (localObject2 != null) {
          break label113;
        }
        localObject2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaA((String)localObject1);
      }
      for (;;)
      {
        if (localObject2 == null)
        {
          AppMethodBeat.o(27327);
          return;
        }
        com.tencent.mm.plugin.account.b.getAddrUploadStg().a((String)localObject1, (com.tencent.mm.plugin.account.friend.a.a)localObject2);
        AppMethodBeat.o(27327);
        return;
        label113:
        localObject1 = str;
      }
    }
    
    protected final void bbp()
    {
      AppMethodBeat.i(27323);
      super.bbp();
      AppMethodBeat.o(27323);
    }
    
    protected void fqA()
    {
      AppMethodBeat.i(27325);
      boolean bool;
      if (!ab.QX(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
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
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            NormalUserFooterPreference.c.this.fqE();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27318);
          }
        });
        if (!com.tencent.mm.contact.d.rk(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) {
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if (NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent() != null)
          {
            paramAnonymousView = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("key_ww_add_session_id");
            if (!Util.isNullOrNil(paramAnonymousView))
            {
              localObject = new iw();
              ((iw)localObject).zS(paramAnonymousView);
              ((iw)localObject).gzc = 0L;
              ((iw)localObject).gKq = 1L;
              ((iw)localObject).bpa();
            }
          }
          NormalUserFooterPreference.c.this.fqF();
          if (NormalUserFooterPreference.E(NormalUserFooterPreference.this) != 0) {
            com.tencent.mm.plugin.report.service.h.IzE.a(11263, new Object[] { Integer.valueOf(NormalUserFooterPreference.E(NormalUserFooterPreference.this)), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27319);
        }
      });
      if (!com.tencent.mm.contact.d.rk(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type))
      {
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(0);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.g(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
        if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ayc())
        {
          NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(0);
          AppMethodBeat.o(27325);
        }
      }
      else
      {
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
        if ((!NormalUserFooterPreference.this.fqx()) && (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(z.bcZ())) && (!ab.QX(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!ab.QO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!com.tencent.mm.storage.as.bvK(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!ab.Qk(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))) {
          NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
        }
        for (;;)
        {
          bh.beI();
          if (!com.tencent.mm.model.c.bbL().bwm(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
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
    
    protected final void fqF()
    {
      AppMethodBeat.i(27326);
      if ((int)NormalUserFooterPreference.a(NormalUserFooterPreference.this).jxt == 0)
      {
        bh.beI();
        if (com.tencent.mm.model.c.bbL().aw(NormalUserFooterPreference.a(NormalUserFooterPreference.this)) != -1)
        {
          localObject = NormalUserFooterPreference.this;
          bh.beI();
          NormalUserFooterPreference.a((NormalUserFooterPreference)localObject, com.tencent.mm.model.c.bbL().RG(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
        }
      }
      if ((NormalUserFooterPreference.F(NormalUserFooterPreference.this)) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 12))
      {
        Log.d("MicroMsg.NormalUserFooterPreference", "qqNum " + NormalUserFooterPreference.G(NormalUserFooterPreference.this) + " qqReamrk " + NormalUserFooterPreference.H(NormalUserFooterPreference.this));
        if ((NormalUserFooterPreference.G(NormalUserFooterPreference.this) != 0L) && (NormalUserFooterPreference.H(NormalUserFooterPreference.this) != null) && (!NormalUserFooterPreference.H(NormalUserFooterPreference.this).equals("")))
        {
          localObject = com.tencent.mm.plugin.account.b.getQQListStg().Hd(NormalUserFooterPreference.G(NormalUserFooterPreference.this));
          if (localObject != null) {
            break label452;
          }
          localObject = new com.tencent.mm.plugin.account.friend.a.as();
          ((com.tencent.mm.plugin.account.friend.a.as)localObject).nickname = "";
          ((com.tencent.mm.plugin.account.friend.a.as)localObject).mXm = NormalUserFooterPreference.G(NormalUserFooterPreference.this);
          ((com.tencent.mm.plugin.account.friend.a.as)localObject).mXu = NormalUserFooterPreference.H(NormalUserFooterPreference.this);
          ((com.tencent.mm.plugin.account.friend.a.as)localObject).username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
          ((com.tencent.mm.plugin.account.friend.a.as)localObject).byL();
          com.tencent.mm.plugin.account.b.getQQListStg().a((com.tencent.mm.plugin.account.friend.a.as)localObject);
        }
      }
      final com.tencent.mm.pluginsdk.ui.applet.a locala;
      final LinkedList localLinkedList;
      final String str;
      for (;;)
      {
        fqG();
        locala = new com.tencent.mm.pluginsdk.ui.applet.a(NormalUserFooterPreference.this.mContext, new com.tencent.mm.pluginsdk.ui.applet.a.a()
        {
          public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(27320);
            if (paramAnonymousBoolean1)
            {
              NormalUserFooterPreference.this.lAD.event("hide_btn");
              NormalUserFooterPreference.this.lAD.doNotify();
              NormalUserFooterPreference.v(NormalUserFooterPreference.this);
              NormalUserFooterPreference.c.a(NormalUserFooterPreference.c.this, paramAnonymousString1);
            }
            for (;;)
            {
              if ((paramAnonymousBoolean1) || (paramAnonymousBoolean2)) {
                NormalUserFooterPreference.c.a(NormalUserFooterPreference.c.this);
              }
              AppMethodBeat.o(27320);
              return;
              if (paramAnonymousBoolean2)
              {
                com.tencent.mm.bl.d.bqc().hx(paramAnonymousString1, 2);
                au.bb(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername, 1);
                paramAnonymousString1 = new se();
                paramAnonymousString1.fRL.username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername;
                paramAnonymousString1.fRL.type = 1;
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
        locala.np((String)localObject, str);
        locala.ReH = new a.b()
        {
          public final boolean m(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
          {
            AppMethodBeat.i(292156);
            String str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("room_name");
            int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWD, 2);
            int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWG, 5000);
            SayHiWithSnsPermissionUI localSayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.class;
            if ((!com.tencent.mm.storage.as.bvK(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (i == 1)) {
              paramAnonymousString2 = SayHiWithSnsPermissionUI2.class;
            }
            for (;;)
            {
              paramAnonymousString2 = new Intent(NormalUserFooterPreference.b(NormalUserFooterPreference.this), paramAnonymousString2);
              paramAnonymousString2.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
              paramAnonymousString2.putExtra("Contact_Nick", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_nickname);
              paramAnonymousString2.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_conRemark);
              if ((NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 14) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 8)) {
                paramAnonymousString2.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("Contact_RoomNickname"));
              }
              paramAnonymousString2.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              paramAnonymousString2.putExtra("room_name", str);
              paramAnonymousString2.putExtra("source_from_user_name", this.GWD);
              paramAnonymousString2.putExtra("source_from_nick_name", str);
              paramAnonymousString2.putExtra("sayhi_with_sns_perm_send_verify", true);
              paramAnonymousString2.putExtra("sayhi_with_sns_perm_add_remark", true);
              paramAnonymousString2.putExtra("sayhi_with_sns_perm_set_label", false);
              paramAnonymousString2.putExtra(f.d.VRW, paramAnonymousString1);
              paramAnonymousString2.putExtra("sayhi_verify_add_errcode", paramAnonymousInt);
              NormalUserFooterPreference.b(NormalUserFooterPreference.this).startActivityForResult(paramAnonymousString2, 0);
              AppMethodBeat.o(292156);
              return true;
              paramAnonymousString2 = localSayHiWithSnsPermissionUI;
              if (!com.tencent.mm.storage.as.bvK(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
              {
                paramAnonymousString2 = localSayHiWithSnsPermissionUI;
                if (i == 2)
                {
                  paramAnonymousString2 = localSayHiWithSnsPermissionUI;
                  if (ab.bef() >= j) {
                    paramAnonymousString2 = SayHiWithSnsPermissionUI3.class;
                  }
                }
              }
            }
          }
        };
        str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("room_name");
        localObject = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra(f.d.VRW);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        Log.i("MicroMsg.NormalUserFooterPreference", "add contact case 1:%s", new Object[] { localObject });
        locala.bqY((String)localObject);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, "", localLinkedList);
        AppMethodBeat.o(27326);
        return;
        label452:
        ((com.tencent.mm.plugin.account.friend.a.as)localObject).mXm = NormalUserFooterPreference.G(NormalUserFooterPreference.this);
        ((com.tencent.mm.plugin.account.friend.a.as)localObject).mXu = NormalUserFooterPreference.H(NormalUserFooterPreference.this);
        ((com.tencent.mm.plugin.account.friend.a.as)localObject).username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
        ((com.tencent.mm.plugin.account.friend.a.as)localObject).byL();
        com.tencent.mm.plugin.account.b.getQQListStg().a(NormalUserFooterPreference.G(NormalUserFooterPreference.this), (com.tencent.mm.plugin.account.friend.a.as)localObject);
        continue;
        if ((NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 58) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 59) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 60)) {
          com.tencent.mm.plugin.account.b.getGoogleFriendStorage().aZ(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, 1);
        }
      }
      if (TextUtils.isEmpty(str))
      {
        Log.i("MicroMsg.NormalUserFooterPreference", "add contact case 2, %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).hDx });
        locala.bqY(NormalUserFooterPreference.a(NormalUserFooterPreference.this).hDx);
        locala.i(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      if (!TextUtils.isEmpty(locala.BLy))
      {
        Log.i("MicroMsg.NormalUserFooterPreference", "add contact case 3, %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).hDx });
        locala.bqY(NormalUserFooterPreference.a(NormalUserFooterPreference.this).hDx);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      bh.beI();
      Object localObject = com.tencent.mm.model.c.bbL().RG(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      if (localObject != null) {}
      for (localObject = Util.nullAs(((ax)localObject).hDx, "");; localObject = "")
      {
        Log.i("MicroMsg.NormalUserFooterPreference", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localObject });
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        locala.bqY((String)localObject);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      az.a.ltq.a(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, new az.b.a()
      {
        public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27322);
          bh.beI();
          paramAnonymousString = com.tencent.mm.model.c.bbL().RG(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          if (paramAnonymousString != null) {}
          for (paramAnonymousString = Util.nullAs(paramAnonymousString.hDx, "");; paramAnonymousString = "")
          {
            locala.bqY(paramAnonymousString);
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
    
    protected final void fqA()
    {
      AppMethodBeat.i(27329);
      Assert.assertTrue(ab.Qy(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
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
    
    protected final void fqC() {}
  }
  
  public static abstract interface e {}
  
  final class f
    extends NormalUserFooterPreference.a
  {
    public f()
    {
      super();
    }
    
    protected final void fqA()
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
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$QrcodeHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.normsg.a.d.GxJ.ay(1, 1, 5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          paramAnonymousView.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
          paramAnonymousView.putExtra(f.d.VRW, NormalUserFooterPreference.a(NormalUserFooterPreference.this).hDx);
          com.tencent.mm.plugin.profile.b.mIG.a(paramAnonymousView, NormalUserFooterPreference.this.mContext);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$QrcodeHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27330);
        }
      });
      AppMethodBeat.o(27332);
    }
    
    protected final void fqC()
    {
      AppMethodBeat.i(27331);
      if ((NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) && (com.tencent.mm.contact.d.rk(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)))
      {
        fqB();
        AppMethodBeat.o(27331);
        return;
      }
      an(false, true);
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
    
    protected final void fqA()
    {
      boolean bool2 = true;
      AppMethodBeat.i(27333);
      if (!z.PD(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
      {
        bool1 = true;
        Assert.assertTrue(bool1);
        if (ab.QX(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
          break label148;
        }
      }
      label148:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Assert.assertTrue(bool1);
        NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setText(R.l.ezm);
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
    
    public final void fqC() {}
  }
  
  final class h
    extends NormalUserFooterPreference.a
  {
    public h()
    {
      super();
    }
    
    protected final void fqA()
    {
      AppMethodBeat.i(27334);
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
      if ((!NormalUserFooterPreference.this.fqx()) && (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(z.bcZ())) && (!ab.QX(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!ab.QO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))) {
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
      }
      for (;;)
      {
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setText(R.l.ezi);
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(8);
        AppMethodBeat.o(27334);
        return;
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
      }
    }
    
    protected final void fqC() {}
  }
  
  class i
    extends NormalUserFooterPreference.c
  {
    private ProgressDialog iXX;
    
    public i()
    {
      super();
    }
    
    private void axk()
    {
      AppMethodBeat.i(27341);
      NormalUserFooterPreference localNormalUserFooterPreference = NormalUserFooterPreference.this;
      bh.beI();
      com.tencent.mm.storage.as localas2 = com.tencent.mm.model.c.bbL().RG(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      if (localas2 != null)
      {
        localas1 = localas2;
        if ((int)localas2.jxt != 0) {}
      }
      else
      {
        localas1 = NormalUserFooterPreference.a(NormalUserFooterPreference.this);
        bh.beI();
        if (com.tencent.mm.model.c.bbL().au(localas1)) {
          break label131;
        }
        Log.e("MicroMsg.NormalUserFooterPreference", "insert contact failed, username = " + localas1.field_username);
      }
      for (com.tencent.mm.storage.as localas1 = null;; localas1 = com.tencent.mm.model.c.bbL().RG(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
      {
        NormalUserFooterPreference.a(localNormalUserFooterPreference, localas1);
        if (NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) {
          ab.H(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
        }
        AppMethodBeat.o(27341);
        return;
        label131:
        bh.beI();
      }
    }
    
    private void onStop()
    {
      AppMethodBeat.i(27339);
      bh.aGY().b(30, this);
      bh.aGY().b(667, this);
      bh.aGY().b(853, this);
      AppMethodBeat.o(27339);
    }
    
    protected void fqA()
    {
      AppMethodBeat.i(27338);
      onDetach();
      onStop();
      bh.aGY().a(30, this);
      bh.aGY().a(667, this);
      bh.aGY().a(853, this);
      super.fqA();
      AppMethodBeat.o(27338);
    }
    
    protected void fqH()
    {
      AppMethodBeat.i(27342);
      if (NormalUserFooterPreference.u(NormalUserFooterPreference.this) != null) {
        NormalUserFooterPreference.u(NormalUserFooterPreference.this).onDetach();
      }
      NormalUserFooterPreference.a(NormalUserFooterPreference.this, new NormalUserFooterPreference.c(NormalUserFooterPreference.this));
      NormalUserFooterPreference.u(NormalUserFooterPreference.this).bbp();
      AppMethodBeat.o(27342);
    }
    
    protected void onDetach()
    {
      AppMethodBeat.i(27340);
      if (this.iXX != null)
      {
        this.iXX.dismiss();
        this.iXX = null;
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
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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
      if (this.iXX != null)
      {
        this.iXX.dismiss();
        this.iXX = null;
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
          paramInt1 = ((com.tencent.mm.pluginsdk.model.t)paramq).fDn;
          Log.d("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, opCode = ".concat(String.valueOf(paramInt1)));
          if ((paramInt1 == 1) || (paramInt1 == 3))
          {
            paramString = ((com.tencent.mm.pluginsdk.model.t)paramq).QVu;
            if ((paramString != null) && (paramString.contains(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)))
            {
              NormalUserFooterPreference.v(NormalUserFooterPreference.this);
              axk();
              fqH();
              paramString = paramString.iterator();
              while (paramString.hasNext()) {
                com.tencent.mm.pluginsdk.ui.preference.b.cX((String)paramString.next(), NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              }
              bh.getNotification().aqY();
            }
          }
          AppMethodBeat.o(27343);
          return;
        }
        if ((paramq.getType() == 667) || (paramq.getType() == 853))
        {
          NormalUserFooterPreference.v(NormalUserFooterPreference.this);
          axk();
          fqH();
          com.tencent.mm.pluginsdk.ui.preference.b.cX(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, NormalUserFooterPreference.l(NormalUserFooterPreference.this));
          bh.getNotification().aqY();
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
      for (paramInt1 = ((com.tencent.mm.pluginsdk.model.t)paramq).fDn;; paramInt1 = 0)
      {
        Log.w("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", new Object[] { Integer.valueOf(paramInt1) });
        if ((paramInt1 == 3) || (paramq.getType() == 853)) {
          com.tencent.mm.ui.base.h.c(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.contact_info_verify_outofdate_msg), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.app_tip), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.app_add), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27337);
              NormalUserFooterPreference.i.this.fqF();
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
          if (bh.aGY().bii())
          {
            bh.aGY().getNetworkServerIp();
            new StringBuilder().append(paramInt2);
            i = 1;
          }
          else
          {
            i = j;
            if (ag.dj(NormalUserFooterPreference.this.mContext))
            {
              n.jF(NormalUserFooterPreference.this.mContext);
              i = 1;
              continue;
              Toast.makeText(NormalUserFooterPreference.this.mContext, NormalUserFooterPreference.this.mContext.getString(R.l.fmt_iap_err, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
              i = 1;
              continue;
              if ((paramInt2 == -100) || (paramInt2 == -2023))
              {
                com.tencent.mm.ui.base.h.a(NormalUserFooterPreference.this.mContext, bh.aGs(), com.tencent.mm.ci.a.ba(NormalUserFooterPreference.this.mContext, R.l.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(27335);
                    NormalUserFooterPreference.i.a(NormalUserFooterPreference.i.this);
                    paramAnonymousDialogInterface = new Intent();
                    paramAnonymousDialogInterface.putExtra("Intro_Switch", true).addFlags(67108864);
                    com.tencent.mm.plugin.profile.b.mIG.n(paramAnonymousDialogInterface, NormalUserFooterPreference.this.mContext);
                    AppMethodBeat.o(27335);
                  }
                }, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                  {
                    AppMethodBeat.i(27336);
                    NormalUserFooterPreference.i.a(NormalUserFooterPreference.i.this);
                    paramAnonymousDialogInterface = new Intent();
                    paramAnonymousDialogInterface.putExtra("Intro_Switch", true).addFlags(67108864);
                    com.tencent.mm.plugin.profile.b.mIG.n(paramAnonymousDialogInterface, NormalUserFooterPreference.this.mContext);
                    AppMethodBeat.o(27336);
                  }
                });
                i = 1;
              }
              else
              {
                if ((paramInt1 == 4) && (paramInt2 == -34)) {
                  paramq = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.fmessage_request_too_offen);
                }
                for (;;)
                {
                  Toast.makeText(NormalUserFooterPreference.b(NormalUserFooterPreference.this), paramq, 1).show();
                  i = j;
                  break;
                  if ((paramInt1 == 4) && (paramInt2 == -94))
                  {
                    paramq = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.fmessage_user_not_support);
                  }
                  else if (paramInt1 == 4)
                  {
                    paramq = paramString;
                    if (!Util.isNullOrNil(paramString)) {}
                  }
                  else
                  {
                    paramq = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.sendrequest_send_fail);
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
  }
  
  final class j
    extends NormalUserFooterPreference.i
  {
    public j()
    {
      super();
    }
    
    protected final void fqA()
    {
      AppMethodBeat.i(27348);
      super.fqA();
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
      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ayc())
      {
        NormalUserFooterPreference.x(NormalUserFooterPreference.this).setText(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.contact_info_moveout_blacklist));
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().removeExtra("Accept_NewFriend_FromOutside");
            int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWD, 2);
            int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWG, 5000);
            localObject = SayHiWithSnsPermissionUI.class;
            if ((!com.tencent.mm.storage.as.bvK(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (i == 1)) {
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
              if (!com.tencent.mm.storage.as.bvK(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
              {
                paramAnonymousView = (View)localObject;
                if (i == 2)
                {
                  paramAnonymousView = (View)localObject;
                  if (ab.bef() >= j) {
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).ayc())
            {
              ab.A(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
              NormalUserFooterPreference.a(NormalUserFooterPreference.this).axn();
              NormalUserFooterPreference.j.this.fqA();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(27346);
              return;
            }
            paramAnonymousView = NormalUserFooterPreference.this.mContext;
            localObject = NormalUserFooterPreference.this.mContext;
            if (com.tencent.mm.storage.as.bvK(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {}
            for (int i = R.l.eyM;; i = R.l.eyL)
            {
              com.tencent.mm.ui.base.h.a(paramAnonymousView, ((Context)localObject).getString(i), NormalUserFooterPreference.this.mContext.getString(R.l.contact_info_movein_blacklist), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(27345);
                  ab.z(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  NormalUserFooterPreference.a(NormalUserFooterPreference.this).axm();
                  NormalUserFooterPreference.j.this.fqA();
                  AppMethodBeat.o(27345);
                }
              }, null);
              break;
            }
          }
        });
        AppMethodBeat.o(27348);
        return;
        NormalUserFooterPreference.x(NormalUserFooterPreference.this).setText(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.contact_info_movein_blacklist));
      }
    }
    
    protected final void fqC()
    {
      AppMethodBeat.i(27347);
      if ((NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) && (com.tencent.mm.contact.d.rk(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)))
      {
        fqB();
        AppMethodBeat.o(27347);
        return;
      }
      an(false, true);
      AppMethodBeat.o(27347);
    }
    
    protected final void fqH()
    {
      AppMethodBeat.i(27350);
      super.fqH();
      AppMethodBeat.o(27350);
    }
    
    protected final void onDetach()
    {
      AppMethodBeat.i(27349);
      super.onDetach();
      AppMethodBeat.o(27349);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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