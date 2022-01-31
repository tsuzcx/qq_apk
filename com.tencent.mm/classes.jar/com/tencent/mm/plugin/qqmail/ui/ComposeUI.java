package com.tencent.mm.plugin.qqmail.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.b.a;
import com.tencent.mm.plugin.qqmail.b.f;
import com.tencent.mm.plugin.qqmail.b.g;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.ab;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.n;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
public class ComposeUI
  extends MMActivity
{
  private static List<com.tencent.mm.plugin.qqmail.b.o> nfN;
  private int mode = 5;
  private int ndr = 1;
  private ab neI = ac.btG();
  private Map<String, String> neP = new HashMap();
  private ScrollView nfO;
  protected MailAddrsViewControl nfP;
  private ImageView nfQ;
  private LinearLayout nfR;
  private LinearLayout nfS;
  private MailAddrsViewControl nfT;
  private ImageView nfU;
  private LinearLayout nfV;
  private MailAddrsViewControl nfW;
  private ImageView nfX;
  private EditText nfY;
  private LinearLayout nfZ;
  private long nfq;
  private am ngA = new am(new ComposeUI.1(this), true);
  private am ngB = new am(new ComposeUI.12(this), true);
  p.a ngC = new ComposeUI.17(this);
  private View.OnClickListener ngD = new ComposeUI.7(this);
  private View.OnClickListener ngE = new ComposeUI.8(this);
  private MenuItem.OnMenuItemClickListener ngF = new ComposeUI.10(this);
  private View.OnClickListener ngG = new ComposeUI.11(this);
  private View.OnClickListener ngH = new ComposeUI.13(this);
  private v.a ngI = new ComposeUI.15(this);
  private TextView nga;
  private ImageView ngb;
  private LinearLayout ngc;
  private TextView ngd;
  private EditText nge;
  private MMWebView ngf;
  private com.tencent.mm.plugin.qqmail.b.p ngg;
  private b ngh;
  public c ngi = new c(this);
  private com.tencent.mm.ui.base.p ngj;
  private String ngk;
  private com.tencent.mm.ui.base.o ngl;
  public boolean ngm = true;
  public boolean ngn = true;
  public boolean ngo = false;
  private String ngp = "(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim();
  private String ngq = "document.getElementById('history').innerHTML";
  private String ngr = "<div id=\"htmlContent\" contenteditable=\"true\" >";
  private String ngs = "</div>";
  private String ngt = null;
  private String ngu = null;
  private String ngv = "weixin://get_img_info/";
  private String ngw = "weixin://get_mail_content/";
  private String ngx = "weixin://img_onclick/";
  private boolean ngy = false;
  private boolean ngz = false;
  
  private void Lo(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      return;
    }
    if (this.ngh.nhC.containsKey(paramString))
    {
      h.h(this.mController.uMN, b.j.plugin_qqmail_upload_attach_exist, b.j.app_tip);
      return;
    }
    int i = (int)localFile.length();
    if (i > 20971520)
    {
      h.a(this, b.j.plugin_qqmail_upload_attach_single_file_size_exceed, b.j.app_tip, null);
      return;
    }
    h.a(this, getString(b.j.plugin_qqmail_upload_attach_size_tip, new Object[] { bk.cm(i) }), getString(b.j.app_tip), new ComposeUI.16(this, i, localFile, paramString), null);
  }
  
  private static void a(MailAddrsViewControl paramMailAddrsViewControl)
  {
    if (nfN == null) {
      return;
    }
    paramMailAddrsViewControl.setMailAdds(nfN);
  }
  
  private void awX()
  {
    if (!l.c(this, com.tencent.mm.compatible.util.e.dzD, "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
      Toast.makeText(this, getString(b.j.selectcameraapp_none), 1).show();
    }
  }
  
  private void btR()
  {
    this.nfP.clearFocus();
    this.nfT.clearFocus();
    this.nfW.clearFocus();
  }
  
  private void btS()
  {
    if (this.ngf != null)
    {
      this.ngf.clearFocus();
      this.ngf.getSettings().setJavaScriptEnabled(true);
      this.ngf.setWebViewClient(new ComposeUI.b(this, (byte)0));
      this.ngf.setWebChromeClient(new ComposeUI.a(this, (byte)0));
      this.ngf.setOnTouchListener(new ComposeUI.6(this));
    }
  }
  
  private String btT()
  {
    if (this.mode == 6)
    {
      com.tencent.mm.pluginsdk.ui.tools.s.c(this.ngf, this.ngw, this.ngq);
      if (this.ngu != null)
      {
        int i = this.ngu.indexOf(this.ngr);
        int j = this.ngu.lastIndexOf(this.ngs);
        if ((i != -1) && (j != -1)) {
          return this.ngu.substring(i + this.ngr.length(), j + this.ngs.length());
        }
        return this.ngu;
      }
    }
    else if (this.mode == 5)
    {
      return this.nge.getText().toString();
    }
    return null;
  }
  
  static void cb(List<com.tencent.mm.plugin.qqmail.b.o> paramList)
  {
    nfN = paramList;
  }
  
  private String getSubject()
  {
    int i = 40;
    String str = this.nfY.getText().toString();
    if (str.trim().length() > 0) {
      return str;
    }
    str = btT();
    if (this.mode == 5)
    {
      if (str.length() > 0)
      {
        if (str.length() > 40) {}
        for (;;)
        {
          return str.substring(0, i);
          i = str.length();
        }
      }
    }
    else if ((this.mode == 6) && (!bk.bl(str)))
    {
      if (str.length() > 40) {}
      for (;;)
      {
        return str.substring(0, i);
        i = str.length();
      }
    }
    return getString(b.j.plugin_qqmail_composeui_nosubject);
  }
  
  protected final boolean btU()
  {
    if (!this.nfP.buj())
    {
      Toast.makeText(this, b.j.plugin_qqmail_composeui_toaddr_invalid, 1).show();
      return false;
    }
    if (!this.nfT.buj())
    {
      Toast.makeText(this, b.j.plugin_qqmail_composeui_ccaddr_invalid, 1).show();
      return false;
    }
    if (!this.nfW.buj())
    {
      Toast.makeText(this, b.j.plugin_qqmail_composeui_bccaddr_invalid, 1).show();
      return false;
    }
    if (this.nfP.getMailAddrs().size() + this.nfT.getMailAddrs().size() + this.nfW.getMailAddrs().size() > 20)
    {
      Toast.makeText(this, b.j.plugin_qqmail_svr_error_desc_101, 1).show();
      return false;
    }
    return true;
  }
  
  protected final int getLayoutId()
  {
    return b.g.qqmail_compose;
  }
  
  protected final void initView()
  {
    this.nfO = ((ScrollView)findViewById(b.f.qqmail_compose_container_sv));
    this.nfP = ((MailAddrsViewControl)findViewById(b.f.qqmail_compose_addr_to_control));
    this.nfQ = ((ImageView)findViewById(b.f.qqmail_compose_add_to_iv));
    this.nfR = ((LinearLayout)findViewById(b.f.qqmail_compose_ccbacc_ll));
    this.nfS = ((LinearLayout)findViewById(b.f.qqmail_compose_addr_cc_fl));
    this.nfT = ((MailAddrsViewControl)findViewById(b.f.qqmail_compose_addr_cc_control));
    this.nfU = ((ImageView)findViewById(b.f.qqmail_compose_add_cc_iv));
    this.nfV = ((LinearLayout)findViewById(b.f.qqmail_compose_addr_bcc_fl));
    this.nfW = ((MailAddrsViewControl)findViewById(b.f.qqmail_compose_addr_bcc_control));
    this.nfX = ((ImageView)findViewById(b.f.qqmail_compose_add_bcc_iv));
    this.nfY = ((EditText)findViewById(b.f.qqmail_compose_subject_et));
    this.nfZ = ((LinearLayout)findViewById(b.f.qqmail_compose_add_attach_ll));
    this.ngd = ((TextView)findViewById(b.f.plugin_qqmail_compose_reply_hint_tv));
    this.nge = ((EditText)findViewById(b.f.qqmail_compose_content_et));
    this.ngf = MMWebView.a.m(this, b.f.qqmail_compose_content_web);
    this.nga = ((TextView)findViewById(b.f.qqmail_compose_attach_summary_iv));
    this.ngb = ((ImageView)findViewById(b.f.qqmail_compose_attach_summary_icon));
    this.ngc = ((LinearLayout)findViewById(b.f.plugin_qqmail_compose_attachment_container));
    this.nfP.setEditable(true);
    this.nfT.setEditable(true);
    this.nfW.setEditable(true);
    Object localObject3 = getIntent().getStringExtra("mail_content");
    Object localObject4 = getIntent().getStringArrayListExtra("mail_attach");
    Object localObject1 = getIntent().getStringArrayListExtra("mail_attach_title");
    Object localObject2 = ac.btF().nen.ch(this.ngk, this.ndr);
    this.ngh = new b(this, this.nga, this.ngb, this.ngc, (byte)0);
    int i;
    if (!bk.bl((String)localObject3))
    {
      y.i("MicroMsg.ComposeUI", "read mail from extra");
      if (this.mode == 6)
      {
        btS();
        this.nfP.requestFocus();
        this.ngu = String.format(this.ngt, new Object[] { localObject3 });
        this.ngf.loadDataWithBaseURL("", this.ngu, "text/html", "utf-8", "");
        this.nge.setVisibility(8);
        this.ngf.setVisibility(0);
        this.ngh.mode = this.mode;
        if (this.mode == 6)
        {
          localObject2 = ((List)localObject4).iterator();
          i = 0;
          label479:
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            localObject4 = new File((String)localObject3);
            if (((File)localObject4).exists())
            {
              if ((int)((File)localObject4).length() + this.ngh.buf() <= 52428800) {
                break label1212;
              }
              h.a(this, b.j.plugin_qqmail_upload_attach_size_exceed, b.j.app_tip, null);
            }
          }
        }
        if (this.ndr == 1) {
          break label1568;
        }
        localObject1 = getIntent().getStringArrayExtra("toList");
        localObject3 = getIntent().getStringArrayExtra("ccList");
        localObject4 = getIntent().getStringArrayExtra("bccList");
        localObject2 = getIntent().getStringExtra("subject");
        this.nfP.a((String[])localObject1, false);
        this.nfT.a((String[])localObject3, false);
        this.nfW.a((String[])localObject4, false);
        if (!bk.bl((String)localObject2))
        {
          localObject3 = this.nfY;
          localObject4 = new StringBuilder();
          if (this.ndr != 2) {
            break label1561;
          }
          localObject1 = "Re:";
          label667:
          ((EditText)localObject3).setText((String)localObject1 + (String)localObject2);
        }
        label685:
        if ((this.nfT.getMailAddrs().size() > 0) || (this.nfW.getMailAddrs().size() > 0))
        {
          this.nfR.setVisibility(8);
          this.nfS.setVisibility(0);
          this.nfV.setVisibility(0);
        }
        if ((this.ndr == 2) && (this.mode != 6) && (this.mode == 5))
        {
          this.nge.requestFocus();
          this.nge.setSelection(0);
          this.nfO.postDelayed(new ComposeUI.18(this), 1000L);
        }
        this.nfP.setOnActionListener(new ComposeUI.c(this, this.nfQ, 0));
        this.nfT.setOnActionListener(new ComposeUI.c(this, this.nfU, 1));
        this.nfW.setOnActionListener(new ComposeUI.c(this, this.nfX, 2));
        localObject1 = new ComposeUI.19(this);
        this.nfP.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
        this.nfT.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
        this.nfW.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
        this.nfQ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
            paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.nfP.a(false, null));
            paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", b.a.push_down_out);
            paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", b.a.fast_faded_in);
            ComposeUI.this.startActivityForResult(paramAnonymousView, 0);
            ComposeUI.this.overridePendingTransition(b.a.push_up_in, b.a.fast_faded_out);
          }
        });
        this.nfU.setOnClickListener(new ComposeUI.21(this));
        this.nfX.setOnClickListener(new ComposeUI.22(this));
        this.nfR.setOnClickListener(this.ngD);
        localObject1 = (ImageView)findViewById(b.f.qqmail_compose_subject_clear_iv);
        if ((this.ngn) && (this.nfY.getText().length() > 0)) {
          ((ImageView)localObject1).setVisibility(0);
        }
        this.nfY.setOnFocusChangeListener(new ComposeUI.23(this));
        this.nfY.addTextChangedListener(new ComposeUI.2(this, (ImageView)localObject1));
        ((ImageView)localObject1).setOnClickListener(new ComposeUI.3(this));
        this.nfZ.setOnClickListener(this.ngE);
        setMMTitle(b.j.plugin_qqmail_composeui_title);
        if (getIntent().getBooleanExtra("show_qqmail", false))
        {
          i = ((Integer)g.DP().Dz().get(9, Integer.valueOf(0))).intValue();
          if (i != 0) {
            break label1672;
          }
          y.w("MicroMsg.ComposeUI", "want to show qqmail address, but unbind qq");
        }
        label1093:
        setBackBtn(this.ngF);
        if (this.mode != 5) {
          break label1706;
        }
        addTextOptionMenu(0, getString(b.j.app_send), new ComposeUI.4(this));
      }
    }
    for (;;)
    {
      enableOptionMenu(false);
      btR();
      return;
      if (this.mode != 5) {
        break;
      }
      this.nge.setVisibility(0);
      this.ngf.setVisibility(8);
      if (((String)localObject3).indexOf("<div>") != -1)
      {
        y.i("MicroMsg.ComposeUI", "set content in html format");
        this.nge.setText(Html.fromHtml((String)localObject3));
        break;
      }
      this.nge.setText((CharSequence)localObject3);
      break;
      label1212:
      y.i("MicroMsg.ComposeUI", "in upload file mode = %d", new Object[] { Integer.valueOf(this.mode) });
      this.ngh.eq((String)localObject3, (String)((List)localObject1).get(i));
      i += 1;
      break label479;
      if ((localObject2 != null) && (this.mode == 6))
      {
        y.i("MicroMsg.ComposeUI", "read mail from draftMail");
        this.nfP.cd(((j)localObject2).ndt);
        this.nfT.cd(((j)localObject2).ndu);
        this.nfW.cd(((j)localObject2).ndv);
        this.nfY.setText(((j)localObject2).ndx);
        localObject1 = ((j)localObject2).content;
        this.mode = 5;
        if (((String)localObject1).indexOf("<div>") != -1)
        {
          y.i("MicroMsg.ComposeUI", "set content in html format");
          this.nge.setText(Html.fromHtml((String)localObject1));
        }
        for (;;)
        {
          this.ngh.mode = this.mode;
          this.ngh.cc(((j)localObject2).ndw);
          this.ngh.bue();
          this.ngf.setVisibility(8);
          this.nge.setVisibility(0);
          break;
          this.nge.setText((CharSequence)localObject1);
        }
      }
      y.i("MicroMsg.ComposeUI", "no extra or draf mail content");
      if (this.mode == 6)
      {
        btS();
        this.nfP.requestFocus();
        this.ngu = String.format(this.ngt, new Object[] { "" });
        this.ngf.loadDataWithBaseURL("", this.ngu, "text/html", "utf-8", "");
        this.nge.setVisibility(8);
        this.ngf.setVisibility(0);
      }
      for (;;)
      {
        this.ngh.mode = this.mode;
        break;
        if (this.mode == 5)
        {
          this.ngf.setVisibility(8);
          this.nge.setVisibility(0);
        }
      }
      label1561:
      localObject1 = "Fwd:";
      break label667;
      label1568:
      if ((this.ndr == 2) || (this.ndr == 3))
      {
        this.ngd.setVisibility(0);
        break label685;
      }
      if (this.ndr == 4)
      {
        localObject1 = getIntent().getStringArrayExtra("toList");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label685;
        }
        this.nfP.a((String[])localObject1, false);
        break label685;
      }
      if (this.ndr != 1) {
        break label685;
      }
      localObject1 = getIntent().getStringExtra("subject");
      if (bk.bl((String)localObject1)) {
        break label685;
      }
      this.nfY.setText((CharSequence)localObject1);
      break label685;
      label1672:
      setMMSubTitle(new com.tencent.mm.a.o(i) + "@qq.com");
      break label1093;
      label1706:
      if (this.mode == 6)
      {
        y.i("MicroMsg.ComposeUI", "set onShareModeSendListener");
        addTextOptionMenu(0, getString(b.j.app_send), new ComposeUI.5(this));
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramInt1)
            {
            default: 
              return;
            case 0: 
              a(this.nfP);
              showVKB();
              return;
            case 1: 
              a(this.nfT);
              showVKB();
              return;
            case 2: 
              a(this.nfW);
              showVKB();
              return;
            case 3: 
              paramIntent = l.f(this, paramIntent, com.tencent.mm.plugin.n.c.FG());
            }
          } while (paramIntent == null);
          Lo(paramIntent);
          btR();
          return;
        } while (paramIntent == null);
        paramIntent = a.g(this, paramIntent, com.tencent.mm.plugin.n.c.FG());
      } while ((paramIntent == null) || (paramIntent.length() <= 0));
      Lo(paramIntent);
      btR();
      return;
    } while (paramIntent == null);
    Lo(paramIntent.getStringExtra("choosed_file_path"));
    btR();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.ngt = (this.ngr + "%s" + this.ngs);
    this.ngy = false;
    this.ngz = false;
    this.ndr = getIntent().getIntExtra("composeType", 1);
    this.ngk = getIntent().getStringExtra("mailid");
    if (this.ngk == null) {
      this.ngk = "";
    }
    this.mode = getIntent().getIntExtra("mail_mode", 5);
    y.d("MicroMsg.ComposeUI", "onCreate, mode = %d", new Object[] { Integer.valueOf(this.mode) });
    initView();
    this.ngg = ac.btF().nem;
    this.ngg.a(this.ngC);
    this.ngg.btu();
    this.ngB.S(180000L, 180000L);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (nfN != null) {
      nfN = null;
    }
    this.ngh.buc();
    b localb = this.ngh;
    g.DO().dJT.b(484, localb);
    this.ngg.b(this.ngC);
    this.ngi.release();
    this.ngB.stopTimer();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.ngF.onMenuItemClick(null);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    XM();
    this.ngA.stopTimer();
    if (this.ngl != null) {
      this.ngl.dismiss();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.ComposeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      awX();
      return;
    }
    h.a(this, getString(b.j.permission_camera_request_again_msg), getString(b.j.permission_tips_title), getString(b.j.jump_to_settings), getString(b.j.app_cancel), false, new ComposeUI.9(this), null);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.ngA.S(1500L, 1500L);
  }
  
  public void setRequestedOrientation(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI
 * JD-Core Version:    0.7.0.1
 */