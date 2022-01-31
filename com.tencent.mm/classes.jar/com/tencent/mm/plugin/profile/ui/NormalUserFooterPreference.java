package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.h.a.ru.b;
import com.tencent.mm.h.a.tc;
import com.tencent.mm.h.a.tc.a;
import com.tencent.mm.h.a.td;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class NormalUserFooterPreference
  extends Preference
  implements j.a
{
  private MMActivity bER;
  public ProgressDialog dnm = null;
  private ad dnp;
  protected k<NormalUserFooterPreference.e, String> ebu = new NormalUserFooterPreference.1(this);
  private int fhj;
  private String hST = null;
  private boolean jAt;
  private String kzG = "";
  private Button lXO;
  private boolean mVI;
  private int mWR = 0;
  private long mXV = 0L;
  private int mXi;
  private String mXq = "";
  private boolean mXw = false;
  private boolean mYA = false;
  public boolean mYB = false;
  private boolean mYf = false;
  private boolean mYg;
  private boolean mYh;
  private boolean mYi = false;
  private boolean mYj = false;
  private NormalUserFooterPreference.a mYk;
  private View mYl;
  private Button mYm;
  private Button mYn;
  private Button mYo;
  private View mYp;
  private Button mYq;
  private TextView mYr;
  private View mYs;
  private Button mYt;
  private Button mYu;
  private Button mYv;
  private Button mYw;
  private Button mYx;
  private Button mYy;
  private TextView mYz;
  
  public NormalUserFooterPreference(Context paramContext)
  {
    super(paramContext);
    this.bER = ((MMActivity)paramContext);
    init();
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    init();
  }
  
  public NormalUserFooterPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bER = ((MMActivity)paramContext);
    init();
  }
  
  private void init()
  {
    this.jAt = false;
    this.mYk = null;
  }
  
  private void initView()
  {
    if ((!this.jAt) || (this.dnp == null))
    {
      y.w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.jAt + " contact = " + this.dnp);
      if (this.mYk == null) {}
    }
    try
    {
      this.mYk.bsK();
      return;
    }
    catch (Throwable localThrowable) {}
    if (this.mYk != null) {
      this.mYk.Fj();
    }
    bsF();
    return;
  }
  
  public final void a(String paramString, l paraml)
  {
    if (bk.pm(paramString).length() <= 0) {}
    while ((this.dnp == null) || ((!paramString.equals(this.dnp.field_username)) && (!paramString.equals(this.dnp.field_encryptUsername)))) {
      return;
    }
    au.Hx();
    this.dnp = c.Fw().abl(this.dnp.field_username);
    ai.d(new Runnable()
    {
      public final void run()
      {
        NormalUserFooterPreference.this.bsF();
      }
    });
  }
  
  public final boolean a(ad paramad, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2, boolean paramBoolean4, boolean paramBoolean5, long paramLong, String paramString2)
  {
    awZ();
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bk.pm(paramad.field_username).length() <= 0) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!ad.aaZ(q.Gj()).equals(paramad.field_username)) {
        break label68;
      }
      return false;
      bool = false;
      break;
    }
    label68:
    this.dnp = paramad;
    this.kzG = paramString1;
    this.mVI = paramBoolean1;
    this.fhj = paramInt1;
    this.mXi = paramInt2;
    this.mYh = bk.a(Boolean.valueOf(com.tencent.mm.model.s.hi(paramad.field_username)), false);
    this.mYf = paramBoolean4;
    this.mYg = paramBoolean5;
    this.mXV = paramLong;
    this.mXq = paramString2;
    this.mYB = false;
    if (paramad.field_deleteFlag == 1)
    {
      paramBoolean1 = true;
      this.mXw = paramBoolean1;
      this.mYA = this.bER.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
      this.mWR = this.bER.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.mYi = this.bER.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
      this.mYj = this.bER.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
      this.hST = this.bER.getIntent().getStringExtra("lbs_ticket");
      if (!q.gS(paramad.field_username))
      {
        au.Hx();
        if (!c.FE().has(paramad.field_username)) {
          break label303;
        }
      }
      this.mYk = new NormalUserFooterPreference.c(this);
      this.mYB = true;
    }
    for (;;)
    {
      initView();
      return true;
      paramBoolean1 = false;
      break;
      label303:
      if (ad.aaR(paramad.field_username))
      {
        this.mYk = new NormalUserFooterPreference.h(this);
      }
      else if (com.tencent.mm.model.s.hx(paramad.field_username))
      {
        this.mYk = new d();
      }
      else if (com.tencent.mm.model.s.hi(paramad.field_username))
      {
        this.mYk = new NormalUserFooterPreference.g(this);
      }
      else if (ad.aaS(paramad.field_username))
      {
        this.mYk = new NormalUserFooterPreference.f(this);
      }
      else if ((com.tencent.mm.n.a.gR(paramad.field_type)) && (!ad.hd(paramad.field_username)))
      {
        this.mYk = new NormalUserFooterPreference.c(this);
        this.mYB = true;
      }
      else if (paramBoolean2)
      {
        this.mYk = new j();
        this.mYB = true;
      }
      else if ((paramBoolean3) || (ad.hd(paramad.field_username)))
      {
        this.mYk = new NormalUserFooterPreference.b(this);
      }
      else
      {
        this.mYk = new NormalUserFooterPreference.c(this);
        this.mYB = true;
      }
    }
  }
  
  public final boolean awZ()
  {
    if (this.mYk != null) {
      this.mYk.onDetach();
    }
    this.ebu.removeAll();
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    return true;
  }
  
  public final boolean bsF()
  {
    if ((this.mYA) && (com.tencent.mm.n.a.gR(this.dnp.field_type)))
    {
      this.mYy.setVisibility(0);
      return true;
    }
    this.mYy.setVisibility(8);
    return false;
  }
  
  public final void bsG()
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this.bER, "android.permission.RECORD_AUDIO", 82, "", "");
    y.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.bER });
    if (!bool) {
      return;
    }
    td localtd = new td();
    localtd.ccJ.bNb = 5;
    localtd.ccJ.talker = this.dnp.field_username;
    localtd.ccJ.context = this.bER;
    localtd.ccJ.ccE = 4;
    com.tencent.mm.sdk.b.a.udP.m(localtd);
  }
  
  public final void bsH()
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this.bER, "android.permission.CAMERA", 19, "", "");
    y.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.bER });
    if (!bool) {}
    do
    {
      return;
      bool = com.tencent.mm.pluginsdk.permission.a.a(this.bER, "android.permission.RECORD_AUDIO", 19, "", "");
      y.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.bER });
    } while (!bool);
    td localtd = new td();
    localtd.ccJ.bNb = 5;
    localtd.ccJ.talker = this.dnp.field_username;
    localtd.ccJ.context = this.bER;
    localtd.ccJ.ccE = 2;
    com.tencent.mm.sdk.b.a.udP.m(localtd);
  }
  
  public final void onBindView(View paramView)
  {
    y.d("MicroMsg.NormalUserFooterPreference", "on bindView " + paramView.toString());
    this.mYl = paramView.findViewById(R.h.contact_info_passive_verify);
    this.mYm = ((Button)paramView.findViewById(R.h.contact_info_verify_accept));
    this.mYn = ((Button)paramView.findViewById(R.h.contact_info_delete_contact));
    this.mYq = ((Button)paramView.findViewById(R.h.contact_info_verify_expose_btn));
    this.mYr = ((TextView)paramView.findViewById(R.h.contact_info_ww_tv));
    this.mYp = paramView.findViewById(R.h.contact_info_verify_mid);
    this.mYo = ((Button)paramView.findViewById(R.h.contact_info_verify_add_black));
    this.mYv = ((Button)paramView.findViewById(R.h.contact_info_add_contact_btn));
    this.mYs = paramView.findViewById(R.h.contact_info_sayhi_item);
    this.mYt = ((Button)paramView.findViewById(R.h.contact_info_sayhi_expose_btn));
    this.mYu = ((Button)paramView.findViewById(R.h.contact_info_sayhi_request_btn));
    this.lXO = ((Button)paramView.findViewById(R.h.contact_info_send_btn));
    this.mYy = ((Button)paramView.findViewById(R.h.contact_info_mod_snspermission_btn));
    this.mYw = ((Button)paramView.findViewById(R.h.contact_info_voip_btn));
    this.mYx = ((Button)paramView.findViewById(R.h.contact_info_black_list_expose_btn));
    this.mYz = ((TextView)paramView.findViewById(R.h.contact_info_movein_blacklist_tip_tv));
    this.jAt = true;
    initView();
    super.onBindView(paramView);
    if ((this.bER.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) == true) && (this.mYm != null)) {
      this.mYm.performClick();
    }
  }
  
  final class d
    extends NormalUserFooterPreference.a
  {
    public d()
    {
      super();
    }
    
    protected final void bsI()
    {
      Assert.assertTrue(com.tencent.mm.model.s.hx(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username));
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(0);
      NormalUserFooterPreference.g(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.k(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(8);
    }
    
    protected final void bsK() {}
  }
  
  final class j
    extends NormalUserFooterPreference.i
    implements f
  {
    public j()
    {
      super();
    }
    
    protected final void bsI()
    {
      super.bsI();
      NormalUserFooterPreference.r(NormalUserFooterPreference.this).setVisibility(0);
      NormalUserFooterPreference.t(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.f(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.g(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.h(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.k(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.s(NormalUserFooterPreference.this).setVisibility(8);
      NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(8);
      switch (NormalUserFooterPreference.l(NormalUserFooterPreference.this))
      {
      default: 
        NormalUserFooterPreference.i(NormalUserFooterPreference.this).setVisibility(8);
        NormalUserFooterPreference.w(NormalUserFooterPreference.this).setVisibility(8);
        if (NormalUserFooterPreference.a(NormalUserFooterPreference.this).Bg())
        {
          NormalUserFooterPreference.x(NormalUserFooterPreference.this).setText(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.contact_info_moveout_blacklist));
          NormalUserFooterPreference.q(NormalUserFooterPreference.this).setVisibility(0);
        }
        break;
      }
      for (;;)
      {
        NormalUserFooterPreference.z(NormalUserFooterPreference.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            NormalUserFooterPreference.b(NormalUserFooterPreference.this).getIntent().removeExtra("Accept_NewFriend_FromOutside");
            paramAnonymousView = new Intent(NormalUserFooterPreference.b(NormalUserFooterPreference.this), SayHiWithSnsPermissionUI.class);
            paramAnonymousView.putExtra("Contact_User", NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_username);
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
          }
        });
        NormalUserFooterPreference.x(NormalUserFooterPreference.this).setOnClickListener(new NormalUserFooterPreference.j.2(this));
        return;
        NormalUserFooterPreference.i(NormalUserFooterPreference.this).setVisibility(0);
        NormalUserFooterPreference.w(NormalUserFooterPreference.this).setVisibility(0);
        break;
        NormalUserFooterPreference.x(NormalUserFooterPreference.this).setText(NormalUserFooterPreference.b(NormalUserFooterPreference.this).getString(R.l.contact_info_movein_blacklist));
      }
    }
    
    protected final void bsK()
    {
      if ((NormalUserFooterPreference.a(NormalUserFooterPreference.this) != null) && (com.tencent.mm.n.a.gR(NormalUserFooterPreference.a(NormalUserFooterPreference.this).field_type)))
      {
        bsJ();
        return;
      }
      B(false, true);
    }
    
    protected final void bsO()
    {
      super.bsO();
    }
    
    protected final void onDetach()
    {
      super.onDetach();
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
    {
      super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference
 * JD-Core Version:    0.7.0.1
 */