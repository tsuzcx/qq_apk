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
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.aaq;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.gg;
import com.tencent.mm.autogen.a.tu;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.lg;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.network.ah;
import com.tencent.mm.plugin.account.friend.model.ap;
import com.tencent.mm.plugin.account.friend.model.aq;
import com.tencent.mm.plugin.account.friend.model.e;
import com.tencent.mm.plugin.account.friend.model.l;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.widget.a.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class NormalUserFooterPreference
  extends Preference
  implements MStorage.IOnStorageChange
{
  boolean MUD;
  boolean MVt;
  long MXS;
  int MXc;
  int MXu;
  boolean MYZ;
  String MZa;
  boolean MZb;
  boolean MZc;
  boolean MZd;
  boolean MZe;
  a MZf;
  private View MZg;
  private Button MZh;
  private Button MZi;
  private Button MZj;
  private View MZk;
  private Button MZl;
  private TextView MZm;
  private View MZn;
  private Button MZo;
  private Button MZp;
  private Button MZq;
  private Button MZr;
  private Button MZs;
  private Button MZt;
  private TextView MZu;
  boolean MZv;
  public boolean MZw;
  au contact;
  public ProgressDialog lzP;
  MMActivity lzt;
  private Button mkz;
  protected MStorageEvent<e, String> ose;
  String pPi;
  int pUt;
  String vsZ;
  private boolean yxr;
  
  public NormalUserFooterPreference(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(27352);
    this.MUD = false;
    this.MXS = 0L;
    this.MZa = "";
    this.pPi = "";
    this.MZb = false;
    this.MZd = false;
    this.MZe = false;
    this.MZv = false;
    this.MXc = 0;
    this.lzP = null;
    this.MZw = false;
    this.vsZ = null;
    this.ose = new MStorageEvent() {};
    this.lzt = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27352);
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27353);
    this.MUD = false;
    this.MXS = 0L;
    this.MZa = "";
    this.pPi = "";
    this.MZb = false;
    this.MZd = false;
    this.MZe = false;
    this.MZv = false;
    this.MXc = 0;
    this.lzP = null;
    this.MZw = false;
    this.vsZ = null;
    this.ose = new MStorageEvent() {};
    this.lzt = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27353);
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27354);
    this.MUD = false;
    this.MXS = 0L;
    this.MZa = "";
    this.pPi = "";
    this.MZb = false;
    this.MZd = false;
    this.MZe = false;
    this.MZv = false;
    this.MXc = 0;
    this.lzP = null;
    this.MZw = false;
    this.vsZ = null;
    this.ose = new MStorageEvent() {};
    this.lzt = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27354);
  }
  
  private void init()
  {
    this.yxr = false;
    this.MZf = null;
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(27359);
    if (this.MZf != null) {
      this.MZf.onDetach();
    }
    this.ose.removeAll();
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    AppMethodBeat.o(27359);
    return true;
  }
  
  public final boolean gBS()
  {
    AppMethodBeat.i(27358);
    if ((this.MZv) && (com.tencent.mm.contact.d.rs(this.contact.field_type)))
    {
      this.MZt.setVisibility(0);
      AppMethodBeat.o(27358);
      return true;
    }
    this.MZt.setVisibility(8);
    AppMethodBeat.o(27358);
    return false;
  }
  
  public final void gBT()
  {
    AppMethodBeat.i(27361);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.lzt, "android.permission.RECORD_AUDIO", 82, "");
    Log.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.lzt });
    if (!bool)
    {
      AppMethodBeat.o(27361);
      return;
    }
    acn localacn = new acn();
    localacn.ifU.hId = 5;
    localacn.ifU.talker = this.contact.field_username;
    localacn.ifU.context = this.lzt;
    localacn.ifU.ifQ = 4;
    localacn.publish();
    AppMethodBeat.o(27361);
  }
  
  public final void gBU()
  {
    AppMethodBeat.i(27362);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.lzt, "android.permission.CAMERA", 19, "");
    Log.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.lzt });
    if (!bool)
    {
      AppMethodBeat.o(27362);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this.lzt, "android.permission.RECORD_AUDIO", 19, "");
    Log.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.lzt });
    if (!bool)
    {
      AppMethodBeat.o(27362);
      return;
    }
    acn localacn = new acn();
    localacn.ifU.hId = 5;
    localacn.ifU.talker = this.contact.field_username;
    localacn.ifU.context = this.lzt;
    localacn.ifU.ifQ = 2;
    localacn.publish();
    AppMethodBeat.o(27362);
  }
  
  final void initView()
  {
    AppMethodBeat.i(27355);
    if ((!this.yxr) || (this.contact == null))
    {
      Log.w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.yxr + " contact = " + this.contact);
      if (this.MZf != null) {
        try
        {
          this.MZf.gBX();
          AppMethodBeat.o(27355);
          return;
        }
        finally {}
      }
      AppMethodBeat.o(27355);
      return;
    }
    if (this.MZf != null) {
      this.MZf.bwk();
    }
    gBS();
    AppMethodBeat.o(27355);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27356);
    Log.d("MicroMsg.NormalUserFooterPreference", "on bindView " + paramView.toString());
    this.MZg = paramView.findViewById(R.h.fCC);
    this.MZh = ((Button)paramView.findViewById(R.h.contact_info_verify_accept));
    this.MZi = ((Button)paramView.findViewById(R.h.contact_info_delete_contact));
    this.MZl = ((Button)paramView.findViewById(R.h.fCW));
    this.MZm = ((TextView)paramView.findViewById(R.h.fDa));
    this.MZk = paramView.findViewById(R.h.fCX);
    this.MZj = ((Button)paramView.findViewById(R.h.fCV));
    this.MZq = ((Button)paramView.findViewById(R.h.fBK));
    this.MZn = paramView.findViewById(R.h.fCK);
    this.MZo = ((Button)paramView.findViewById(R.h.fCJ));
    this.MZp = ((Button)paramView.findViewById(R.h.fCL));
    this.mkz = ((Button)paramView.findViewById(R.h.fCM));
    this.MZt = ((Button)paramView.findViewById(R.h.fCz));
    this.MZr = ((Button)paramView.findViewById(R.h.fCY));
    this.MZs = ((Button)paramView.findViewById(R.h.fCh));
    this.MZu = ((TextView)paramView.findViewById(R.h.fCA));
    this.yxr = true;
    initView();
    super.onBindView(paramView);
    if ((this.lzt.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) == true) && (this.MZh != null)) {
      this.MZh.performClick();
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
      bh.bCz();
      this.contact = com.tencent.mm.model.c.bzA().JE(this.contact.field_username);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27291);
          NormalUserFooterPreference.this.gBS();
          AppMethodBeat.o(27291);
        }
      });
    }
    AppMethodBeat.o(27360);
  }
  
  abstract class a
    implements com.tencent.mm.am.h, com.tencent.mm.pluginsdk.i.a.a
  {
    private f MTX = null;
    private boolean isDeleteCancel = false;
    
    public a() {}
    
    private void XN(String paramString)
    {
      NormalUserFooterPreference.a(NormalUserFooterPreference.this).aRL();
      if (au.bwO(paramString))
      {
        ((u)com.tencent.mm.kernel.h.ax(u.class)).Eg(paramString);
        az.a.okP.Jr(paramString);
        return;
      }
      ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.i.a.class)).XN(paramString);
    }
    
    private void gBY()
    {
      this.MTX = new f(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
      this.MTX.Vtg = new u.g()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
        {
          AppMethodBeat.i(27299);
          paramAnonymouss.bx(2, R.l.app_field_voip, R.k.sharemore_videovoip);
          paramAnonymouss.bx(1, R.l.app_field_voipaudio, R.k.sharemore_voipvoice);
          AppMethodBeat.o(27299);
        }
      };
      this.MTX.GAC = new u.i()
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
            NormalUserFooterPreference.this.gBT();
            AppMethodBeat.o(27300);
            return;
            NormalUserFooterPreference.this.gBU();
          }
        }
      };
      this.MTX.dDn();
    }
    
    protected final void aG(final boolean paramBoolean1, final boolean paramBoolean2)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        return;
      }
      NormalUserFooterPreference.b(NormalUserFooterPreference.this).addIconOptionMenu(0, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27307);
          paramAnonymousMenuItem = new f(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
          paramAnonymousMenuItem.GAC = new u.i()
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
              if (au.bwO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {}
              for (paramAnonymous2Int = R.l.gBE;; paramAnonymous2Int = R.l.gBD)
              {
                k.a(paramAnonymous2MenuItem, localContext.getString(paramAnonymous2Int), NormalUserFooterPreference.this.mContext.getString(R.l.contact_info_movein_blacklist), new DialogInterface.OnClickListener()
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
          paramAnonymousMenuItem.Vtg = new u.g()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
            {
              AppMethodBeat.i(27306);
              if (!NormalUserFooterPreference.a.10.this.MZB)
              {
                if (!au.bwO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
                  break label99;
                }
                paramAnonymous2s.bx(1, R.l.gDi, R.k.bottomsheet_icon_remarks);
              }
              while (!NormalUserFooterPreference.a.10.this.MZC) {
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).aSF())
                {
                  paramAnonymous2s.bx(8, R.l.contact_info_moveout_blacklist, R.k.bottomsheet_icon_blacklist);
                  AppMethodBeat.o(27306);
                  return;
                  label99:
                  paramAnonymous2s.bx(1, R.l.gBA, R.k.bottomsheet_icon_remarks);
                }
                else if (!au.bxa(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2s.bx(5, R.l.contact_info_movein_blacklist, R.k.bottomsheet_icon_blacklist);
                }
              }
              AppMethodBeat.o(27306);
            }
          };
          paramAnonymousMenuItem.dDn();
          AppMethodBeat.o(27307);
          return true;
        }
      });
    }
    
    final void aRR(String paramString)
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
      com.tencent.mm.plugin.profile.b.pFn.l(paramString, NormalUserFooterPreference.this.mContext);
    }
    
    protected void bwk()
    {
      gBV();
      gBX();
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27308);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.NormalUserFooterPreference", "sendButton onClick %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
          if (NormalUserFooterPreference.e(NormalUserFooterPreference.this)) {
            NormalUserFooterPreference.a.f(NormalUserFooterPreference.a.this);
          }
          for (;;)
          {
            com.tencent.mm.plugin.profile.d.b(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent(), 4, 1, NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
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
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          NormalUserFooterPreference.a.h(NormalUserFooterPreference.a.this);
          com.tencent.mm.plugin.profile.d.b(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent(), 5, 1, NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
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
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          NormalUserFooterPreference.a.d(NormalUserFooterPreference.a.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$BaseHandler$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27313);
        }
      });
      ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.i.a.class)).a(this);
    }
    
    protected abstract void gBV();
    
    protected final void gBW()
    {
      NormalUserFooterPreference.b(NormalUserFooterPreference.this).addIconOptionMenu(0, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27296);
          paramAnonymousMenuItem = new f(NormalUserFooterPreference.b(NormalUserFooterPreference.this), 1, false);
          paramAnonymousMenuItem.GAC = new u.i()
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
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).aSK())
                {
                  ab.F(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  k.cZ(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.gDa));
                }
                for (;;)
                {
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this;
                  bh.bCz();
                  NormalUserFooterPreference.a(paramAnonymous2MenuItem, com.tencent.mm.model.c.bzA().JE(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
                  AppMethodBeat.o(27294);
                  return;
                  ab.E(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  k.cZ(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.gBp));
                }
                paramAnonymous2MenuItem = new Intent();
                paramAnonymous2MenuItem.putExtra("sns_permission_userName", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
                paramAnonymous2MenuItem.putExtra("sns_permission_anim", true);
                paramAnonymous2MenuItem.putExtra("sns_permission_block_scene", 1);
                com.tencent.mm.br.c.b(NormalUserFooterPreference.b(NormalUserFooterPreference.this), "sns", ".ui.SnsPermissionUI", paramAnonymous2MenuItem);
                AppMethodBeat.o(27294);
                return;
                NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this);
                AppMethodBeat.o(27294);
                return;
                NormalUserFooterPreference.this.ose.event("hide_btn");
                NormalUserFooterPreference.this.ose.doNotify();
                NormalUserFooterPreference.a locala = NormalUserFooterPreference.a.this;
                paramAnonymous2MenuItem = locala.MZx;
                bh.bCz();
                NormalUserFooterPreference.a(paramAnonymous2MenuItem, com.tencent.mm.model.c.bzA().JE(NormalUserFooterPreference.a(locala.MZx).field_username));
                if (!com.tencent.mm.contact.d.rs(NormalUserFooterPreference.a(locala.MZx).field_type))
                {
                  locala.aRR(NormalUserFooterPreference.a(locala.MZx).field_username);
                  AppMethodBeat.o(27294);
                  return;
                }
                Intent localIntent = new Intent();
                localIntent.putExtra("Contact_Scene", NormalUserFooterPreference.l(locala.MZx));
                localIntent.putExtra("Contact_User", NormalUserFooterPreference.a(locala.MZx).field_username);
                localIntent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(locala.MZx).getIntent().getStringExtra("Contact_RoomNickname"));
                localIntent.putExtra("contact_phone_number_list", NormalUserFooterPreference.a(locala.MZx).kar);
                Object localObject2 = "";
                Object localObject1 = localObject2;
                String str;
                if (!NormalUserFooterPreference.a(locala.MZx).aSR())
                {
                  localObject1 = NormalUserFooterPreference.b(locala.MZx).getIntent().getStringExtra("Contact_Mobile_MD5");
                  str = NormalUserFooterPreference.b(locala.MZx).getIntent().getStringExtra("Contact_full_Mobile_MD5");
                  if ((!Util.isNullOrNil((String)localObject1)) || (!Util.isNullOrNil(str))) {
                    break label724;
                  }
                  paramAnonymous2MenuItem = localObject3;
                  if (!Util.isNullOrNil(NormalUserFooterPreference.a(locala.MZx).field_username)) {
                    paramAnonymous2MenuItem = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(NormalUserFooterPreference.a(locala.MZx).field_username);
                  }
                }
                for (;;)
                {
                  localObject1 = localObject2;
                  if (paramAnonymous2MenuItem != null)
                  {
                    localObject1 = localObject2;
                    if (!Util.isNullOrNil(paramAnonymous2MenuItem.getMd5())) {
                      localObject1 = Util.nullAsNil(paramAnonymous2MenuItem.bWN()).replace(" ", "");
                    }
                  }
                  localIntent.putExtra("contact_phone_number_by_md5", (String)localObject1);
                  com.tencent.mm.plugin.profile.b.pFn.k(localIntent, locala.MZx.mContext);
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
                    localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU((String)localObject1);
                    if (localObject1 != null)
                    {
                      paramAnonymous2MenuItem = (MenuItem)localObject1;
                      if (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.model.a)localObject1).getMd5())) {}
                    }
                    else
                    {
                      paramAnonymous2MenuItem = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU(str);
                    }
                  }
                }
                if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).aSF())
                {
                  NormalUserFooterPreference.a.b(NormalUserFooterPreference.a.this);
                  AppMethodBeat.o(27294);
                  return;
                }
                paramAnonymous2MenuItem = View.inflate(NormalUserFooterPreference.this.mContext, R.i.mm_alert_checkbox, null);
                paramAnonymous2MenuItem.setPadding(0, 0, 0, 0);
                localObject1 = (TextView)paramAnonymous2MenuItem.findViewById(R.h.mm_alert_dialog_info);
                ((TextView)localObject1).setPadding(0, 0, 0, 0);
                if (au.bwO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2Int = R.l.gBE;
                  ((TextView)localObject1).setText(paramAnonymous2Int);
                  localObject1 = (CheckBox)paramAnonymous2MenuItem.findViewById(R.h.mm_alert_dialog_cb);
                  ((CheckBox)localObject1).setChecked(false);
                  localObject2 = (TextView)paramAnonymous2MenuItem.findViewById(R.h.mm_alert_dialog_cb_txt);
                  ((TextView)localObject2).setText(R.l.gBF);
                  if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource() != 18) {
                    break label1061;
                  }
                  ((CheckBox)localObject1).setVisibility(0);
                  ((TextView)localObject2).setVisibility(0);
                }
                for (;;)
                {
                  k.a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(R.l.contact_info_movein_blacklist), paramAnonymous2MenuItem, NormalUserFooterPreference.this.mContext.getString(R.l.app_ok), NormalUserFooterPreference.this.mContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(27292);
                      NormalUserFooterPreference.a.c(NormalUserFooterPreference.a.this);
                      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource() == 18)
                      {
                        NormalUserFooterPreference.a(NormalUserFooterPreference.this, 9);
                        if (this.MUE.isChecked()) {
                          NormalUserFooterPreference.a.d(NormalUserFooterPreference.a.this);
                        }
                      }
                      AppMethodBeat.o(27292);
                    }
                  }, null);
                  AppMethodBeat.o(27294);
                  return;
                  paramAnonymous2Int = R.l.gBD;
                  break;
                  label1061:
                  ((CheckBox)localObject1).setVisibility(8);
                  ((TextView)localObject2).setVisibility(8);
                }
                localObject1 = View.inflate(NormalUserFooterPreference.this.mContext, R.i.mm_alert_checkbox, null);
                ((View)localObject1).setPadding(0, 0, 0, 0);
                localObject2 = (TextView)((View)localObject1).findViewById(R.h.mm_alert_dialog_info);
                ((TextView)localObject2).setPadding(0, 0, 0, 0);
                if (ab.IQ(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
                {
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext.getString(R.l.gEa, new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).aSV() });
                  ((TextView)localObject2).setText(paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = (CheckBox)((View)localObject1).findViewById(R.h.mm_alert_dialog_cb);
                  paramAnonymous2MenuItem.setChecked(false);
                  localObject2 = (TextView)((View)localObject1).findViewById(R.h.mm_alert_dialog_cb_txt);
                  ((TextView)localObject2).setText(R.l.gBF);
                  if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).getSource() != 18) {
                    break label1408;
                  }
                  paramAnonymous2MenuItem.setVisibility(0);
                  ((TextView)localObject2).setVisibility(0);
                }
                for (;;)
                {
                  k.a(NormalUserFooterPreference.this.mContext, true, NormalUserFooterPreference.this.mContext.getString(R.l.contact_info_delete_contact), (View)localObject1, NormalUserFooterPreference.this.mContext.getString(R.l.app_delete), NormalUserFooterPreference.this.mContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(27293);
                      NormalUserFooterPreference.a.this.gBZ();
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
                  paramAnonymous2MenuItem = NormalUserFooterPreference.this.mContext.getString(R.l.gDX, new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).aSV() });
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
          paramAnonymousMenuItem.Vtg = new u.g()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
            {
              AppMethodBeat.i(27295);
              com.tencent.mm.plugin.profile.d.b(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent(), 7, 1, NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
              if (au.bwO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
              {
                paramAnonymous2s.bx(1, R.l.gDi, R.k.bottomsheet_icon_remarks);
                if (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).aSK()) {
                  break label302;
                }
                str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getResources().getString(R.l.gCZ);
                label120:
                paramAnonymous2s.a(2, str, R.k.bottomsheet_icon_star);
                if (!au.bwO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
                  paramAnonymous2s.bx(3, R.l.contact_info_op_sns_permission, R.k.bottomsheet_icon_moment);
                }
                paramAnonymous2s.bx(4, R.l.gBW, R.k.bottomsheet_icon_transmit);
                paramAnonymous2s.bx(9, R.l.biz_report_text, R.k.bottomsheet_icon_complain);
                if (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).aSF()) {
                  break label328;
                }
              }
              label302:
              label328:
              for (String str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.contact_info_moveout_blacklist);; str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.contact_info_movein_blacklist))
              {
                paramAnonymous2s.a(5, str, R.k.bottomsheet_icon_blacklist);
                if (!NormalUserFooterPreference.c(NormalUserFooterPreference.this)) {
                  paramAnonymous2s.bx(6, R.l.bind_mcontact_del_btn_text, R.k.bottomsheet_icon_del);
                }
                paramAnonymous2s.bx(7, R.l.gAF, R.k.bottomsheet_icon_desktop);
                AppMethodBeat.o(27295);
                return;
                paramAnonymous2s.bx(1, R.l.gBA, R.k.bottomsheet_icon_remarks);
                break;
                str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getResources().getString(R.l.gBo);
                break label120;
              }
            }
          };
          paramAnonymousMenuItem.dDn();
          AppMethodBeat.o(27296);
          return true;
        }
      });
    }
    
    protected void gBX()
    {
      if (NormalUserFooterPreference.d(NormalUserFooterPreference.this)) {
        NormalUserFooterPreference.b(NormalUserFooterPreference.this).showOptionMenu(false);
      }
      do
      {
        do
        {
          return;
        } while (z.bAM().equals(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
        if (!com.tencent.mm.contact.d.rs(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) {
          break;
        }
      } while (au.bws(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
      gBW();
      return;
      aG(false, false);
    }
    
    protected final void gBZ()
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(2), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
      final String str = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
      if (ab.IQ(str))
      {
        NormalUserFooterPreference.a(NormalUserFooterPreference.this).aRL();
        bh.bCz();
        com.tencent.mm.model.c.bzz().d(new com.tencent.mm.ay.d(str));
        bh.bCz();
        com.tencent.mm.model.c.bzA().bxC(str);
        bh.bCz();
        com.tencent.mm.model.c.bzK().JA(str);
        return;
      }
      this.isDeleteCancel = false;
      Object localObject = NormalUserFooterPreference.this.mContext;
      NormalUserFooterPreference.this.mContext.getString(R.l.app_tip);
      final w localw = k.a((Context)localObject, NormalUserFooterPreference.this.mContext.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(305614);
          NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this, true);
          AppMethodBeat.o(305614);
        }
      });
      if (!this.isDeleteCancel) {}
      for (localObject = com.tencent.mm.pluginsdk.wallet.d.brY(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);; localObject = null)
      {
        if (!Util.isNullOrNil((String)localObject))
        {
          localw.dismiss();
          k.a(NormalUserFooterPreference.this.mContext, false, NormalUserFooterPreference.this.mContext.getString(R.l.gYF, new Object[] { localObject }), null, NormalUserFooterPreference.this.mContext.getString(R.l.goto_conversation), NormalUserFooterPreference.this.mContext.getString(R.l.gEd), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27301);
              com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(4), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this, true);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("Chat_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
              paramAnonymousDialogInterface.addFlags(67108864);
              com.tencent.mm.br.c.g(NormalUserFooterPreference.this.mContext, ".ui.chatting.ChattingUI", paramAnonymousDialogInterface);
              AppMethodBeat.o(27301);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27302);
              com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(3), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
              localw.show();
              NormalUserFooterPreference.a.a(NormalUserFooterPreference.a.this, false);
              NormalUserFooterPreference.a.b(NormalUserFooterPreference.a.this, str);
              AppMethodBeat.o(27302);
            }
          }, -1, R.e.alert_btn_color_warn);
          return;
        }
        XN(str);
        return;
      }
    }
    
    public void onDeleteContact(String paramString, int paramInt, dzc paramdzc)
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
        case 10: 
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
            break label458;
          }
          paramString = new Intent();
          paramString.addFlags(67108864);
          com.tencent.mm.plugin.profile.b.pFn.n(paramString, NormalUserFooterPreference.this.mContext);
          return;
          paramString = com.tencent.mm.plugin.account.b.getQQListStg().Tf(paramString);
          if (paramString == null) {
            break;
          }
          paramString.pTV = 1;
          com.tencent.mm.plugin.account.b.getQQListStg().a(paramString.pTU, paramString);
          break;
          paramString = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(paramString);
          if ((paramString == null) || (Util.isNullOrNil(paramString.pSe))) {
            break;
          }
          paramString.status = 1;
          com.tencent.mm.plugin.account.b.getAddrUploadStg().a(paramString.getMd5(), paramString);
          break;
          paramdzc = com.tencent.mm.plugin.account.b.getFacebookFrdStg();
          paramString = "select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + paramString + "\"";
          paramdzc = paramdzc.omV.rawQuery(paramString, null, 2);
          if (paramdzc == null) {
            paramString = localObject1;
          }
          while (paramString != null)
          {
            paramString.status = 100;
            com.tencent.mm.plugin.account.b.getFacebookFrdStg().a(paramString);
            break;
            paramString = localObject2;
            if (paramdzc.moveToFirst())
            {
              paramString = new com.tencent.mm.plugin.account.friend.model.d();
              paramString.convertFrom(paramdzc);
            }
            paramdzc.close();
          }
          com.tencent.mm.plugin.account.b.getGoogleFriendStorage().bp(paramString, 2);
          break;
          Log.i("MicroMsg.NormalUserFooterPreference", "delete the system contact info added by wechat");
        }
        label458:
        NormalUserFooterPreference.b(NormalUserFooterPreference.this).setResult(-1, NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().putExtra("_delete_ok_", true));
        ((Activity)NormalUserFooterPreference.this.mContext).finish();
        return;
      }
      if (!Util.isNullOrNil(paramdzc.nUB))
      {
        k.c(NormalUserFooterPreference.b(NormalUserFooterPreference.this), paramdzc.nUB, paramdzc.hAP, true);
        return;
      }
      k.c(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.app_delete_failed), "", true);
    }
    
    protected void onDetach()
    {
      ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.i.a.class)).b(this);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      Log.i("MicroMsg.NormalUserFooterPreference", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramp.getType());
    }
  }
  
  final class b
    extends NormalUserFooterPreference.c
  {
    public b()
    {
      super();
    }
    
    protected final void gBV()
    {
      AppMethodBeat.i(27317);
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      if ((!com.tencent.mm.contact.d.rs(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) || ((com.tencent.mm.contact.d.rs(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) && (au.bwS(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))))
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
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NearByFriendHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if ((NormalUserFooterPreference.c(NormalUserFooterPreference.this)) && (com.tencent.mm.bp.a.iGn()))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Chat_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername);
              paramAnonymousView.putExtra("lbs_mode", true);
              paramAnonymousView.putExtra("lbs_ticket", NormalUserFooterPreference.C(NormalUserFooterPreference.this));
              paramAnonymousView.putExtra("add_scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              com.tencent.mm.plugin.profile.b.pFn.d(paramAnonymousView, NormalUserFooterPreference.b(NormalUserFooterPreference.this));
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NearByFriendHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(27315);
              return;
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
              paramAnonymousView.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              paramAnonymousView.putExtra(f.e.adwe, NormalUserFooterPreference.a(NormalUserFooterPreference.this).kas);
              com.tencent.mm.plugin.profile.b.pFn.a(paramAnonymousView, NormalUserFooterPreference.this.mContext);
            }
          }
        });
        AppMethodBeat.o(27317);
        return;
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
        if ((NormalUserFooterPreference.this.gBS()) || (NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(z.bAM()))) {
          break;
        }
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
      }
    }
    
    protected final void gBX()
    {
      AppMethodBeat.i(27316);
      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this) == null)
      {
        Log.e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
        AppMethodBeat.o(27316);
        return;
      }
      if ((!com.tencent.mm.contact.d.rs(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) || ((com.tencent.mm.contact.d.rs(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) && (au.bwS(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))))
      {
        if (au.bwS(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
        {
          aG(true, true);
          AppMethodBeat.o(27316);
          return;
        }
        aG(false, true);
        AppMethodBeat.o(27316);
        return;
      }
      gBW();
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
    
    private void gAN()
    {
      AppMethodBeat.i(27327);
      Object localObject2 = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("Contact_Mobile_MD5");
      Object localObject1 = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("Contact_full_Mobile_MD5");
      String str = Util.nullAsNil((String)localObject2);
      localObject1 = Util.nullAsNil((String)localObject1);
      if ((!str.equals("")) || (!((String)localObject1).equals("")))
      {
        localObject2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU(str);
        if (localObject2 != null) {
          break label113;
        }
        localObject2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU((String)localObject1);
      }
      for (;;)
      {
        if (localObject2 == null)
        {
          AppMethodBeat.o(27327);
          return;
        }
        com.tencent.mm.plugin.account.b.getAddrUploadStg().a((String)localObject1, (com.tencent.mm.plugin.account.friend.model.a)localObject2);
        AppMethodBeat.o(27327);
        return;
        label113:
        localObject1 = str;
      }
    }
    
    protected final void bwk()
    {
      AppMethodBeat.i(27323);
      super.bwk();
      AppMethodBeat.o(27323);
    }
    
    protected void gBV()
    {
      AppMethodBeat.i(27325);
      boolean bool;
      if (!ab.IV(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
      {
        bool = true;
        Assert.assertTrue(bool);
        NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        if (!NormalUserFooterPreference.d(NormalUserFooterPreference.this)) {
          break label194;
        }
        NormalUserFooterPreference.D(NormalUserFooterPreference.this).setOnClickListener(new NormalUserFooterPreference.c.1(this));
        if (!com.tencent.mm.contact.d.rs(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)) {
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if (NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent() != null)
          {
            paramAnonymousView = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("key_ww_add_session_id");
            if (!Util.isNullOrNil(paramAnonymousView))
            {
              localObject = new lg();
              ((lg)localObject).ud(paramAnonymousView);
              ((lg)localObject).isX = 0L;
              ((lg)localObject).iZG = 1L;
              ((lg)localObject).bMH();
            }
          }
          NormalUserFooterPreference.c.this.gCa();
          if (NormalUserFooterPreference.E(NormalUserFooterPreference.this) != 0) {
            com.tencent.mm.plugin.report.service.h.OAn.b(11263, new Object[] { Integer.valueOf(NormalUserFooterPreference.E(NormalUserFooterPreference.this)), NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NormalHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27319);
        }
      });
      if (!com.tencent.mm.contact.d.rs(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type))
      {
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(0);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.g(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
        if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).aSF())
        {
          NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(0);
          AppMethodBeat.o(27325);
        }
      }
      else
      {
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
        if ((!NormalUserFooterPreference.this.gBS()) && (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(z.bAM())) && (!ab.IV(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!au.bws(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!au.bwO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!au.bxa(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))) {
          NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
        }
        for (;;)
        {
          bh.bCz();
          if (!com.tencent.mm.model.c.bzA().bxz(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
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
    
    protected final void gCa()
    {
      AppMethodBeat.i(27326);
      if ((int)NormalUserFooterPreference.a(NormalUserFooterPreference.this).maN == 0)
      {
        bh.bCz();
        if (com.tencent.mm.model.c.bzA().aC(NormalUserFooterPreference.a(NormalUserFooterPreference.this)) != -1)
        {
          localObject = NormalUserFooterPreference.this;
          bh.bCz();
          NormalUserFooterPreference.a((NormalUserFooterPreference)localObject, com.tencent.mm.model.c.bzA().JE(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
        }
      }
      if ((NormalUserFooterPreference.F(NormalUserFooterPreference.this)) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 12))
      {
        Log.d("MicroMsg.NormalUserFooterPreference", "qqNum " + NormalUserFooterPreference.G(NormalUserFooterPreference.this) + " qqReamrk " + NormalUserFooterPreference.H(NormalUserFooterPreference.this));
        if ((NormalUserFooterPreference.G(NormalUserFooterPreference.this) != 0L) && (NormalUserFooterPreference.H(NormalUserFooterPreference.this) != null) && (!NormalUserFooterPreference.H(NormalUserFooterPreference.this).equals("")))
        {
          localObject = com.tencent.mm.plugin.account.b.getQQListStg().jt(NormalUserFooterPreference.G(NormalUserFooterPreference.this));
          if (localObject != null) {
            break label452;
          }
          localObject = new ap();
          ((ap)localObject).nickname = "";
          ((ap)localObject).pTU = NormalUserFooterPreference.G(NormalUserFooterPreference.this);
          ((ap)localObject).pUc = NormalUserFooterPreference.H(NormalUserFooterPreference.this);
          ((ap)localObject).username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
          ((ap)localObject).bXz();
          com.tencent.mm.plugin.account.b.getQQListStg().a((ap)localObject);
        }
      }
      final com.tencent.mm.pluginsdk.ui.applet.a locala;
      final LinkedList localLinkedList;
      final String str;
      for (;;)
      {
        gAN();
        locala = new com.tencent.mm.pluginsdk.ui.applet.a(NormalUserFooterPreference.this.mContext, new com.tencent.mm.pluginsdk.ui.applet.a.a()
        {
          public final void canAddContact(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(27320);
            if (paramAnonymousBoolean1)
            {
              NormalUserFooterPreference.this.ose.event("hide_btn");
              NormalUserFooterPreference.this.ose.doNotify();
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
                com.tencent.mm.modelverify.d.bNI().fP(paramAnonymousString1, 2);
                com.tencent.mm.plugin.account.friend.model.ar.br(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername, 1);
                paramAnonymousString1 = new tu();
                paramAnonymousString1.hXJ.username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_encryptUsername;
                paramAnonymousString1.hXJ.type = 1;
                paramAnonymousString1.publish();
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
        locala.pk((String)localObject, str);
        locala.YaM = new a.b()
        {
          public final boolean n(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
          {
            AppMethodBeat.i(305577);
            String str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("room_name");
            int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpi, 2);
            int j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpl, 5000);
            SayHiWithSnsPermissionUI localSayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.class;
            if ((!au.bwO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (i == 1)) {
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
              paramAnonymousString2.putExtra("source_from_user_name", this.MUd);
              paramAnonymousString2.putExtra("source_from_nick_name", str);
              paramAnonymousString2.putExtra("sayhi_with_sns_perm_send_verify", true);
              paramAnonymousString2.putExtra("sayhi_with_sns_perm_add_remark", true);
              paramAnonymousString2.putExtra("sayhi_with_sns_perm_set_label", false);
              paramAnonymousString2.putExtra(f.e.adwe, paramAnonymousString1);
              paramAnonymousString2.putExtra("sayhi_verify_add_errcode", paramAnonymousInt);
              NormalUserFooterPreference.b(NormalUserFooterPreference.this).startActivityForResult(paramAnonymousString2, 0);
              AppMethodBeat.o(305577);
              return true;
              paramAnonymousString2 = localSayHiWithSnsPermissionUI;
              if (!au.bwO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
              {
                paramAnonymousString2 = localSayHiWithSnsPermissionUI;
                if (i == 2)
                {
                  paramAnonymousString2 = localSayHiWithSnsPermissionUI;
                  if (ab.bBW() >= j) {
                    paramAnonymousString2 = SayHiWithSnsPermissionUI3.class;
                  }
                }
              }
            }
          }
        };
        str = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra("room_name");
        localObject = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().getStringExtra(f.e.adwe);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        Log.i("MicroMsg.NormalUserFooterPreference", "add contact case 1:%s", new Object[] { localObject });
        locala.bqM((String)localObject);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, "", localLinkedList);
        AppMethodBeat.o(27326);
        return;
        label452:
        ((ap)localObject).pTU = NormalUserFooterPreference.G(NormalUserFooterPreference.this);
        ((ap)localObject).pUc = NormalUserFooterPreference.H(NormalUserFooterPreference.this);
        ((ap)localObject).username = NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username;
        ((ap)localObject).bXz();
        com.tencent.mm.plugin.account.b.getQQListStg().a(NormalUserFooterPreference.G(NormalUserFooterPreference.this), (ap)localObject);
        continue;
        if ((NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 58) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 59) || (NormalUserFooterPreference.l(NormalUserFooterPreference.this) == 60)) {
          com.tencent.mm.plugin.account.b.getGoogleFriendStorage().bp(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, 1);
        }
      }
      if (TextUtils.isEmpty(str))
      {
        Log.i("MicroMsg.NormalUserFooterPreference", "add contact case 2, %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).kas });
        locala.bqM(NormalUserFooterPreference.a(NormalUserFooterPreference.this).kas);
        locala.i(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      if (!TextUtils.isEmpty(locala.pPi))
      {
        Log.i("MicroMsg.NormalUserFooterPreference", "add contact case 3, %s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).kas });
        locala.bqM(NormalUserFooterPreference.a(NormalUserFooterPreference.this).kas);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      bh.bCz();
      Object localObject = com.tencent.mm.model.c.bzA().JE(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      if (localObject != null) {}
      for (localObject = Util.nullAs(((az)localObject).kas, "");; localObject = "")
      {
        Log.i("MicroMsg.NormalUserFooterPreference", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localObject });
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        locala.bqM((String)localObject);
        locala.d(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, localLinkedList);
        AppMethodBeat.o(27326);
        return;
      }
      az.a.okP.a(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, str, new az.b.a()
      {
        public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27322);
          bh.bCz();
          paramAnonymousString = com.tencent.mm.model.c.bzA().JE(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          if (paramAnonymousString != null) {}
          for (paramAnonymousString = Util.nullAs(paramAnonymousString.kas, "");; paramAnonymousString = "")
          {
            locala.bqM(paramAnonymousString);
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
    
    protected final void gBV()
    {
      AppMethodBeat.i(27329);
      Assert.assertTrue(au.bwc(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
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
    
    protected final void gBX() {}
  }
  
  public static abstract interface e {}
  
  final class f
    extends NormalUserFooterPreference.a
  {
    public f()
    {
      super();
    }
    
    protected final void gBV()
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
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$QrcodeHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.mm.plugin.normsg.a.d.MtP.aW(1, 1, 5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
          paramAnonymousView.putExtra("Contact_Scene", NormalUserFooterPreference.l(NormalUserFooterPreference.this));
          paramAnonymousView.putExtra(f.e.adwe, NormalUserFooterPreference.a(NormalUserFooterPreference.this).kas);
          com.tencent.mm.plugin.profile.b.pFn.a(paramAnonymousView, NormalUserFooterPreference.this.mContext);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$QrcodeHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27330);
        }
      });
      AppMethodBeat.o(27332);
    }
    
    protected final void gBX()
    {
      AppMethodBeat.i(27331);
      if ((NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) && (com.tencent.mm.contact.d.rs(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)))
      {
        gBW();
        AppMethodBeat.o(27331);
        return;
      }
      aG(false, true);
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
    
    protected final void gBV()
    {
      boolean bool2 = true;
      AppMethodBeat.i(27333);
      if (!z.Iy(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
      {
        bool1 = true;
        Assert.assertTrue(bool1);
        if (ab.IV(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {
          break label148;
        }
      }
      label148:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Assert.assertTrue(bool1);
        NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setText(R.l.gCb);
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
    
    public final void gBX() {}
  }
  
  final class h
    extends NormalUserFooterPreference.a
  {
    public h()
    {
      super();
    }
    
    protected final void gBV()
    {
      AppMethodBeat.i(27334);
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
      if ((!NormalUserFooterPreference.this.gBS()) && (!NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username.equals(z.bAM())) && (!ab.IV(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (!au.bws(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))) {
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(0);
      }
      for (;;)
      {
        NormalUserFooterPreference.f(NormalUserFooterPreference.this).setText(R.l.gBX);
        NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(8);
        AppMethodBeat.o(27334);
        return;
        NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
      }
    }
    
    protected final void gBX() {}
  }
  
  class i
    extends NormalUserFooterPreference.c
  {
    private ProgressDialog lzP;
    
    public i()
    {
      super();
    }
    
    private void aRK()
    {
      AppMethodBeat.i(27341);
      NormalUserFooterPreference localNormalUserFooterPreference = NormalUserFooterPreference.this;
      bh.bCz();
      au localau2 = com.tencent.mm.model.c.bzA().JE(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
      if (localau2 != null)
      {
        localau1 = localau2;
        if ((int)localau2.maN != 0) {}
      }
      else
      {
        localau1 = NormalUserFooterPreference.a(NormalUserFooterPreference.this);
        bh.bCz();
        if (com.tencent.mm.model.c.bzA().aA(localau1)) {
          break label131;
        }
        Log.e("MicroMsg.NormalUserFooterPreference", "insert contact failed, username = " + localau1.field_username);
      }
      for (au localau1 = null;; localau1 = com.tencent.mm.model.c.bzA().JE(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
      {
        NormalUserFooterPreference.a(localNormalUserFooterPreference, localau1);
        if (NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) {
          ab.I(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
        }
        AppMethodBeat.o(27341);
        return;
        label131:
        bh.bCz();
      }
    }
    
    private void onStop()
    {
      AppMethodBeat.i(27339);
      bh.aZW().b(30, this);
      bh.aZW().b(667, this);
      bh.aZW().b(853, this);
      AppMethodBeat.o(27339);
    }
    
    protected void gBV()
    {
      AppMethodBeat.i(27338);
      onDetach();
      onStop();
      bh.aZW().a(30, this);
      bh.aZW().a(667, this);
      bh.aZW().a(853, this);
      super.gBV();
      AppMethodBeat.o(27338);
    }
    
    protected void gCb()
    {
      AppMethodBeat.i(27342);
      if (NormalUserFooterPreference.u(NormalUserFooterPreference.this) != null) {
        NormalUserFooterPreference.u(NormalUserFooterPreference.this).onDetach();
      }
      NormalUserFooterPreference.a(NormalUserFooterPreference.this, new NormalUserFooterPreference.c(NormalUserFooterPreference.this));
      NormalUserFooterPreference.u(NormalUserFooterPreference.this).bwk();
      AppMethodBeat.o(27342);
    }
    
    protected void onDetach()
    {
      AppMethodBeat.i(27340);
      if (this.lzP != null)
      {
        this.lzP.dismiss();
        this.lzP = null;
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
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      int j = 0;
      AppMethodBeat.i(27343);
      Log.d("MicroMsg.NormalUserFooterPreference", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      if ((paramp.getType() != 30) && (paramp.getType() != 667) && (paramp.getType() != 853))
      {
        AppMethodBeat.o(27343);
        return;
      }
      onStop();
      if (this.lzP != null)
      {
        this.lzP.dismiss();
        this.lzP = null;
      }
      if (!Util.isTopActivity(NormalUserFooterPreference.this.mContext))
      {
        AppMethodBeat.o(27343);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramp.getType() == 30)
        {
          paramInt1 = ((v)paramp).hId;
          Log.d("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, opCode = ".concat(String.valueOf(paramInt1)));
          if ((paramInt1 == 1) || (paramInt1 == 3))
          {
            paramString = ((v)paramp).XRr;
            if ((paramString != null) && (paramString.contains(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)))
            {
              NormalUserFooterPreference.v(NormalUserFooterPreference.this);
              aRK();
              gCb();
              paramString = paramString.iterator();
              while (paramString.hasNext()) {
                com.tencent.mm.pluginsdk.ui.preference.b.dz((String)paramString.next(), NormalUserFooterPreference.l(NormalUserFooterPreference.this));
              }
              bh.getNotification().aKV();
            }
          }
          AppMethodBeat.o(27343);
          return;
        }
        if ((paramp.getType() == 667) || (paramp.getType() == 853))
        {
          NormalUserFooterPreference.v(NormalUserFooterPreference.this);
          aRK();
          gCb();
          com.tencent.mm.pluginsdk.ui.preference.b.dz(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username, NormalUserFooterPreference.l(NormalUserFooterPreference.this));
          bh.getNotification().aKV();
          AppMethodBeat.o(27343);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -302)) {
        if (paramp.getType() != 30) {
          break label885;
        }
      }
      label885:
      for (paramInt1 = ((v)paramp).hId;; paramInt1 = 0)
      {
        Log.w("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", new Object[] { Integer.valueOf(paramInt1) });
        if ((paramInt1 == 3) || (paramp.getType() == 853)) {
          k.b(NormalUserFooterPreference.b(NormalUserFooterPreference.this), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.contact_info_verify_outofdate_msg), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.app_tip), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.app_add), NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(27337);
              NormalUserFooterPreference.i.this.gCa();
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
          if (bh.aZW().bFR())
          {
            bh.aZW().getNetworkServerIp();
            new StringBuilder().append(paramInt2);
            i = 1;
          }
          else
          {
            i = j;
            if (ah.eb(NormalUserFooterPreference.this.mContext))
            {
              com.tencent.mm.pluginsdk.ui.tools.m.lE(NormalUserFooterPreference.this.mContext);
              i = 1;
              continue;
              Toast.makeText(NormalUserFooterPreference.this.mContext, NormalUserFooterPreference.this.mContext.getString(R.l.fmt_iap_err, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
              i = 1;
              continue;
              if ((paramInt2 == -100) || (paramInt2 == -2023))
              {
                k.a(NormalUserFooterPreference.this.mContext, bh.aZu(), com.tencent.mm.cd.a.bt(NormalUserFooterPreference.this.mContext, R.l.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(27335);
                    NormalUserFooterPreference.i.a(NormalUserFooterPreference.i.this);
                    paramAnonymousDialogInterface = new Intent();
                    paramAnonymousDialogInterface.putExtra("Intro_Switch", true).addFlags(67108864);
                    com.tencent.mm.plugin.profile.b.pFn.n(paramAnonymousDialogInterface, NormalUserFooterPreference.this.mContext);
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
                    com.tencent.mm.plugin.profile.b.pFn.n(paramAnonymousDialogInterface, NormalUserFooterPreference.this.mContext);
                    AppMethodBeat.o(27336);
                  }
                });
                i = 1;
              }
              else
              {
                if ((paramInt1 == 4) && (paramInt2 == -34)) {
                  paramp = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.fmessage_request_too_offen);
                }
                for (;;)
                {
                  Toast.makeText(NormalUserFooterPreference.b(NormalUserFooterPreference.this), paramp, 1).show();
                  i = j;
                  break;
                  if ((paramInt1 == 4) && (paramInt2 == -94))
                  {
                    paramp = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.fmessage_user_not_support);
                  }
                  else if (paramInt1 == 4)
                  {
                    paramp = paramString;
                    if (!Util.isNullOrNil(paramString)) {}
                  }
                  else
                  {
                    paramp = NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.sendrequest_send_fail);
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
    
    protected final void gBV()
    {
      AppMethodBeat.i(27348);
      super.gBV();
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
      if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).aSF())
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().removeExtra("Accept_NewFriend_FromOutside");
            int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpi, 2);
            int j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpl, 5000);
            localObject = SayHiWithSnsPermissionUI.class;
            if ((!au.bwO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) && (i == 1)) {
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
              if (!au.bwO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username))
              {
                paramAnonymousView = (View)localObject;
                if (i == 2)
                {
                  paramAnonymousView = (View)localObject;
                  if (ab.bBW() >= j) {
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).aSF())
            {
              ab.B(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
              NormalUserFooterPreference.a(NormalUserFooterPreference.this).aRN();
              NormalUserFooterPreference.j.this.gBV();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$VertifyCardHandler$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(27346);
              return;
            }
            paramAnonymousView = NormalUserFooterPreference.this.mContext;
            localObject = NormalUserFooterPreference.this.mContext;
            if (au.bwO(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username)) {}
            for (int i = R.l.gBE;; i = R.l.gBD)
            {
              k.a(paramAnonymousView, ((Context)localObject).getString(i), NormalUserFooterPreference.this.mContext.getString(R.l.contact_info_movein_blacklist), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(27345);
                  ab.A(NormalUserFooterPreference.a(NormalUserFooterPreference.this));
                  NormalUserFooterPreference.a(NormalUserFooterPreference.this).aRM();
                  NormalUserFooterPreference.j.this.gBV();
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
    
    protected final void gBX()
    {
      AppMethodBeat.i(27347);
      if ((NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) && (com.tencent.mm.contact.d.rs(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)))
      {
        gBW();
        AppMethodBeat.o(27347);
        return;
      }
      aG(false, true);
      AppMethodBeat.o(27347);
    }
    
    protected final void gCb()
    {
      AppMethodBeat.i(27350);
      super.gCb();
      AppMethodBeat.o(27350);
    }
    
    protected final void onDetach()
    {
      AppMethodBeat.i(27349);
      super.onDetach();
      AppMethodBeat.o(27349);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(27351);
      super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
      AppMethodBeat.o(27351);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference
 * JD-Core Version:    0.7.0.1
 */