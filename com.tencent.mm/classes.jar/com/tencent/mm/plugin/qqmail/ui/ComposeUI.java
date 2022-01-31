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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.t;
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
  private static List<com.tencent.mm.plugin.qqmail.b.o> pLc;
  private com.tencent.mm.ui.base.p gDl;
  private int mode;
  private int pII;
  private com.tencent.mm.plugin.qqmail.b.ab pJX;
  private long pKF;
  private Map<String, String> pKe;
  public boolean pLA;
  public boolean pLB;
  public boolean pLC;
  private String pLD;
  private String pLE;
  private String pLF;
  private String pLG;
  private String pLH;
  private String pLI;
  private String pLJ;
  private String pLK;
  private String pLL;
  private boolean pLM;
  private boolean pLN;
  private ap pLO;
  private ap pLP;
  p.a pLQ;
  private View.OnClickListener pLR;
  private View.OnClickListener pLS;
  private MenuItem.OnMenuItemClickListener pLT;
  private View.OnClickListener pLU;
  private View.OnClickListener pLV;
  private v.a pLW;
  private ScrollView pLd;
  protected MailAddrsViewControl pLe;
  private ImageView pLf;
  private LinearLayout pLg;
  private LinearLayout pLh;
  private MailAddrsViewControl pLi;
  private ImageView pLj;
  private LinearLayout pLk;
  private MailAddrsViewControl pLl;
  private ImageView pLm;
  private EditText pLn;
  private LinearLayout pLo;
  private TextView pLp;
  private ImageView pLq;
  private LinearLayout pLr;
  private TextView pLs;
  private EditText pLt;
  private MMWebView pLu;
  private com.tencent.mm.plugin.qqmail.b.p pLv;
  private b pLw;
  public c pLx;
  private String pLy;
  private com.tencent.mm.ui.base.o pLz;
  
  public ComposeUI()
  {
    AppMethodBeat.i(68213);
    this.pLx = new c(this);
    this.pII = 1;
    this.pLA = true;
    this.pLB = true;
    this.pLC = false;
    this.pLD = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    this.pLE = "document.getElementById('history').innerHTML";
    this.pLF = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    this.pLG = "</div>";
    this.pLH = null;
    this.mode = 5;
    this.pKe = new HashMap();
    this.pJX = ac.cdR();
    this.pLI = null;
    this.pLJ = "weixin://get_img_info/";
    this.pLK = "weixin://get_mail_content/";
    this.pLL = "weixin://img_onclick/";
    this.pLM = false;
    this.pLN = false;
    this.pLO = new ap(new ComposeUI.1(this), true);
    this.pLP = new ap(new ComposeUI.12(this), true);
    this.pLQ = new ComposeUI.17(this);
    this.pLR = new ComposeUI.7(this);
    this.pLS = new ComposeUI.8(this);
    this.pLT = new ComposeUI.10(this);
    this.pLU = new ComposeUI.11(this);
    this.pLV = new ComposeUI.13(this);
    this.pLW = new ComposeUI.15(this);
    AppMethodBeat.o(68213);
  }
  
  private void Xy(String paramString)
  {
    AppMethodBeat.i(68229);
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      AppMethodBeat.o(68229);
      return;
    }
    if (this.pLw.xm(paramString))
    {
      h.h(getContext(), 2131302151, 2131297087);
      AppMethodBeat.o(68229);
      return;
    }
    int i = (int)localFile.length();
    if (i > 20971520)
    {
      h.a(this, 2131302152, 2131297087, null);
      AppMethodBeat.o(68229);
      return;
    }
    h.a(this, getString(2131302154, new Object[] { bo.hk(i) }), getString(2131297087), new ComposeUI.16(this, i, localFile, paramString), null);
    AppMethodBeat.o(68229);
  }
  
  private static void a(MailAddrsViewControl paramMailAddrsViewControl)
  {
    AppMethodBeat.i(68227);
    if (pLc == null)
    {
      AppMethodBeat.o(68227);
      return;
    }
    paramMailAddrsViewControl.setMailAdds(pLc);
    AppMethodBeat.o(68227);
  }
  
  private void bEq()
  {
    AppMethodBeat.i(68222);
    if (!n.c(this, com.tencent.mm.compatible.util.e.esr, "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
      Toast.makeText(this, getString(2131303074), 1).show();
    }
    AppMethodBeat.o(68222);
  }
  
  static void cD(List<com.tencent.mm.plugin.qqmail.b.o> paramList)
  {
    pLc = paramList;
  }
  
  private void ced()
  {
    AppMethodBeat.i(68218);
    this.pLe.clearFocus();
    this.pLi.clearFocus();
    this.pLl.clearFocus();
    AppMethodBeat.o(68218);
  }
  
  private void cee()
  {
    AppMethodBeat.i(68220);
    if (this.pLu != null)
    {
      this.pLu.clearFocus();
      this.pLu.getSettings().setJavaScriptEnabled(true);
      this.pLu.setWebViewClient(new ComposeUI.b(this, (byte)0));
      this.pLu.setWebChromeClient(new ComposeUI.a(this, (byte)0));
      this.pLu.setOnTouchListener(new ComposeUI.6(this));
    }
    AppMethodBeat.o(68220);
  }
  
  private String cef()
  {
    AppMethodBeat.i(68224);
    String str;
    if (this.mode == 6)
    {
      u.b(this.pLu, this.pLK, this.pLE);
      if (this.pLI != null)
      {
        int i = this.pLI.indexOf(this.pLF);
        int j = this.pLI.lastIndexOf(this.pLG);
        if ((i != -1) && (j != -1))
        {
          str = this.pLI.substring(i + this.pLF.length(), j + this.pLG.length());
          AppMethodBeat.o(68224);
          return str;
        }
        str = this.pLI;
        AppMethodBeat.o(68224);
        return str;
      }
    }
    else if (this.mode == 5)
    {
      str = this.pLt.getText().toString();
      AppMethodBeat.o(68224);
      return str;
    }
    AppMethodBeat.o(68224);
    return null;
  }
  
  private String getSubject()
  {
    int i = 40;
    AppMethodBeat.i(68225);
    String str = this.pLn.getText().toString();
    if (str.trim().length() > 0)
    {
      AppMethodBeat.o(68225);
      return str;
    }
    str = cef();
    if (this.mode == 5)
    {
      if (str.length() > 0)
      {
        if (str.length() > 40) {}
        for (;;)
        {
          str = str.substring(0, i);
          AppMethodBeat.o(68225);
          return str;
          i = str.length();
        }
      }
    }
    else if ((this.mode == 6) && (!bo.isNullOrNil(str)))
    {
      if (str.length() > 40) {}
      for (;;)
      {
        str = str.substring(0, i);
        AppMethodBeat.o(68225);
        return str;
        i = str.length();
      }
    }
    str = getString(2131302131);
    AppMethodBeat.o(68225);
    return str;
  }
  
  protected final boolean ceg()
  {
    AppMethodBeat.i(68226);
    if (!this.pLe.cev())
    {
      Toast.makeText(this, 2131302137, 1).show();
      AppMethodBeat.o(68226);
      return false;
    }
    if (!this.pLi.cev())
    {
      Toast.makeText(this, 2131302128, 1).show();
      AppMethodBeat.o(68226);
      return false;
    }
    if (!this.pLl.cev())
    {
      Toast.makeText(this, 2131302126, 1).show();
      AppMethodBeat.o(68226);
      return false;
    }
    if (this.pLe.getMailAddrs().size() + this.pLi.getMailAddrs().size() + this.pLl.getMailAddrs().size() > 20)
    {
      Toast.makeText(this, 2131302143, 1).show();
      AppMethodBeat.o(68226);
      return false;
    }
    AppMethodBeat.o(68226);
    return true;
  }
  
  public int getLayoutId()
  {
    return 2130970484;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68219);
    this.pLd = ((ScrollView)findViewById(2131826900));
    this.pLe = ((MailAddrsViewControl)findViewById(2131826904));
    this.pLf = ((ImageView)findViewById(2131826905));
    this.pLg = ((LinearLayout)findViewById(2131826906));
    this.pLh = ((LinearLayout)findViewById(2131826907));
    this.pLi = ((MailAddrsViewControl)findViewById(2131826908));
    this.pLj = ((ImageView)findViewById(2131826909));
    this.pLk = ((LinearLayout)findViewById(2131826910));
    this.pLl = ((MailAddrsViewControl)findViewById(2131826911));
    this.pLm = ((ImageView)findViewById(2131826912));
    this.pLn = ((EditText)findViewById(2131826914));
    this.pLo = ((LinearLayout)findViewById(2131826916));
    this.pLs = ((TextView)findViewById(2131826920));
    this.pLt = ((EditText)findViewById(2131826921));
    this.pLu = MMWebView.a.p(this, 2131826922);
    this.pLp = ((TextView)findViewById(2131826917));
    this.pLq = ((ImageView)findViewById(2131826918));
    this.pLr = ((LinearLayout)findViewById(2131826919));
    this.pLe.setEditable(true);
    this.pLi.setEditable(true);
    this.pLl.setEditable(true);
    Object localObject3 = getIntent().getStringExtra("mail_content");
    Object localObject4 = getIntent().getStringArrayListExtra("mail_attach");
    Object localObject1 = getIntent().getStringArrayListExtra("mail_attach_title");
    Object localObject2 = ac.cdQ().pJD.da(this.pLy, this.pII);
    this.pLw = new b(this, this.pLp, this.pLq, this.pLr, (byte)0);
    int i;
    if (!bo.isNullOrNil((String)localObject3))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "read mail from extra");
      if (this.mode == 6)
      {
        cee();
        this.pLe.requestFocus();
        this.pLI = String.format(this.pLH, new Object[] { localObject3 });
        this.pLu.loadDataWithBaseURL("", this.pLI, "text/html", "utf-8", "");
        this.pLt.setVisibility(8);
        this.pLu.setVisibility(0);
        this.pLw.mode = this.mode;
        if (this.mode == 6)
        {
          localObject2 = ((List)localObject4).iterator();
          i = 0;
          label485:
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            localObject4 = new File((String)localObject3);
            if (((File)localObject4).exists())
            {
              if ((int)((File)localObject4).length() + this.pLw.cer() <= 52428800) {
                break label1224;
              }
              h.a(this, 2131302153, 2131297087, null);
            }
          }
        }
        if (this.pII == 1) {
          break label1580;
        }
        localObject1 = getIntent().getStringArrayExtra("toList");
        localObject3 = getIntent().getStringArrayExtra("ccList");
        localObject4 = getIntent().getStringArrayExtra("bccList");
        localObject2 = getIntent().getStringExtra("subject");
        this.pLe.b((String[])localObject1, false);
        this.pLi.b((String[])localObject3, false);
        this.pLl.b((String[])localObject4, false);
        if (!bo.isNullOrNil((String)localObject2))
        {
          localObject3 = this.pLn;
          localObject4 = new StringBuilder();
          if (this.pII != 2) {
            break label1573;
          }
          localObject1 = "Re:";
          label673:
          ((EditText)localObject3).setText((String)localObject1 + (String)localObject2);
        }
        label691:
        if ((this.pLi.getMailAddrs().size() > 0) || (this.pLl.getMailAddrs().size() > 0))
        {
          this.pLg.setVisibility(8);
          this.pLh.setVisibility(0);
          this.pLk.setVisibility(0);
        }
        if ((this.pII == 2) && (this.mode != 6) && (this.mode == 5))
        {
          this.pLt.requestFocus();
          this.pLt.setSelection(0);
          this.pLd.postDelayed(new ComposeUI.18(this), 1000L);
        }
        this.pLe.setOnActionListener(new ComposeUI.c(this, this.pLf, 0));
        this.pLi.setOnActionListener(new ComposeUI.c(this, this.pLj, 1));
        this.pLl.setOnActionListener(new ComposeUI.c(this, this.pLm, 2));
        localObject1 = new ComposeUI.19(this);
        this.pLe.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
        this.pLi.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
        this.pLl.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
        this.pLf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(68203);
            paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
            paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.pLe.a(false, null));
            paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", 2131034228);
            paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", 2131034181);
            ComposeUI.this.startActivityForResult(paramAnonymousView, 0);
            ComposeUI.this.overridePendingTransition(2131034230, 2131034182);
            AppMethodBeat.o(68203);
          }
        });
        this.pLj.setOnClickListener(new ComposeUI.21(this));
        this.pLm.setOnClickListener(new ComposeUI.22(this));
        this.pLg.setOnClickListener(this.pLR);
        localObject1 = (ImageView)findViewById(2131826915);
        if ((this.pLB) && (this.pLn.getText().length() > 0)) {
          ((ImageView)localObject1).setVisibility(0);
        }
        this.pLn.setOnFocusChangeListener(new ComposeUI.23(this));
        this.pLn.addTextChangedListener(new ComposeUI.2(this, (ImageView)localObject1));
        ((ImageView)localObject1).setOnClickListener(new ComposeUI.3(this));
        this.pLo.setOnClickListener(this.pLS);
        setMMTitle(2131302135);
        if (getIntent().getBooleanExtra("show_qqmail", false))
        {
          i = ((Integer)g.RL().Ru().get(9, Integer.valueOf(0))).intValue();
          if (i != 0) {
            break label1684;
          }
          com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ComposeUI", "want to show qqmail address, but unbind qq");
        }
        label1099:
        setBackBtn(this.pLT);
        if (this.mode != 5) {
          break label1718;
        }
        addTextOptionMenu(0, getString(2131297067), new ComposeUI.4(this));
      }
    }
    for (;;)
    {
      enableOptionMenu(false);
      ced();
      AppMethodBeat.o(68219);
      return;
      if (this.mode != 5) {
        break;
      }
      this.pLt.setVisibility(0);
      this.pLu.setVisibility(8);
      if (((String)localObject3).indexOf("<div>") != -1)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "set content in html format");
        this.pLt.setText(Html.fromHtml((String)localObject3));
        break;
      }
      this.pLt.setText((CharSequence)localObject3);
      break;
      label1224:
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "in upload file mode = %d", new Object[] { Integer.valueOf(this.mode) });
      this.pLw.fO((String)localObject3, (String)((List)localObject1).get(i));
      i += 1;
      break label485;
      if ((localObject2 != null) && (this.mode == 6))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "read mail from draftMail");
        this.pLe.cF(((j)localObject2).pIK);
        this.pLi.cF(((j)localObject2).pIL);
        this.pLl.cF(((j)localObject2).pIM);
        this.pLn.setText(((j)localObject2).pIO);
        localObject1 = ((j)localObject2).content;
        this.mode = 5;
        if (((String)localObject1).indexOf("<div>") != -1)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "set content in html format");
          this.pLt.setText(Html.fromHtml((String)localObject1));
        }
        for (;;)
        {
          this.pLw.mode = this.mode;
          this.pLw.cE(((j)localObject2).pIN);
          this.pLw.ceq();
          this.pLu.setVisibility(8);
          this.pLt.setVisibility(0);
          break;
          this.pLt.setText((CharSequence)localObject1);
        }
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "no extra or draf mail content");
      if (this.mode == 6)
      {
        cee();
        this.pLe.requestFocus();
        this.pLI = String.format(this.pLH, new Object[] { "" });
        this.pLu.loadDataWithBaseURL("", this.pLI, "text/html", "utf-8", "");
        this.pLt.setVisibility(8);
        this.pLu.setVisibility(0);
      }
      for (;;)
      {
        this.pLw.mode = this.mode;
        break;
        if (this.mode == 5)
        {
          this.pLu.setVisibility(8);
          this.pLt.setVisibility(0);
        }
      }
      label1573:
      localObject1 = "Fwd:";
      break label673;
      label1580:
      if ((this.pII == 2) || (this.pII == 3))
      {
        this.pLs.setVisibility(0);
        break label691;
      }
      if (this.pII == 4)
      {
        localObject1 = getIntent().getStringArrayExtra("toList");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label691;
        }
        this.pLe.b((String[])localObject1, false);
        break label691;
      }
      if (this.pII != 1) {
        break label691;
      }
      localObject1 = getIntent().getStringExtra("subject");
      if (bo.isNullOrNil((String)localObject1)) {
        break label691;
      }
      this.pLn.setText((CharSequence)localObject1);
      break label691;
      label1684:
      setMMSubTitle(new com.tencent.mm.a.p(i) + "@qq.com");
      break label1099;
      label1718:
      if (this.mode == 6)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "set onShareModeSendListener");
        addTextOptionMenu(0, getString(2131297067), new ComposeUI.5(this));
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68228);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(68228);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(68228);
      return;
      a(this.pLe);
      showVKB();
      AppMethodBeat.o(68228);
      return;
      a(this.pLi);
      showVKB();
      AppMethodBeat.o(68228);
      return;
      a(this.pLl);
      showVKB();
      AppMethodBeat.o(68228);
      return;
      paramIntent = n.h(this, paramIntent, com.tencent.mm.plugin.i.c.YK());
      if (paramIntent != null)
      {
        Xy(paramIntent);
        ced();
        AppMethodBeat.o(68228);
        return;
        if (paramIntent != null)
        {
          paramIntent = a.i(this, paramIntent, com.tencent.mm.plugin.i.c.YK());
          if ((paramIntent != null) && (paramIntent.length() > 0))
          {
            Xy(paramIntent);
            ced();
            AppMethodBeat.o(68228);
            return;
            if (paramIntent != null)
            {
              Xy(paramIntent.getStringExtra("choosed_file_path"));
              ced();
            }
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68214);
    super.onCreate(paramBundle);
    this.pLH = (this.pLF + "%s" + this.pLG);
    this.pLM = false;
    this.pLN = false;
    this.pII = getIntent().getIntExtra("composeType", 1);
    this.pLy = getIntent().getStringExtra("mailid");
    if (this.pLy == null) {
      this.pLy = "";
    }
    this.mode = getIntent().getIntExtra("mail_mode", 5);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ComposeUI", "onCreate, mode = %d", new Object[] { Integer.valueOf(this.mode) });
    initView();
    this.pLv = ac.cdQ().pJC;
    this.pLv.a(this.pLQ);
    this.pLv.cdE();
    this.pLP.ag(180000L, 180000L);
    AppMethodBeat.o(68214);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68217);
    super.onDestroy();
    if (pLc != null) {
      pLc = null;
    }
    this.pLw.ceo();
    b localb = this.pLw;
    g.RK().eHt.b(484, localb);
    this.pLv.b(this.pLQ);
    this.pLx.release();
    this.pLP.stopTimer();
    AppMethodBeat.o(68217);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68221);
    if (paramInt == 4)
    {
      this.pLT.onMenuItemClick(null);
      AppMethodBeat.o(68221);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(68221);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68216);
    super.onPause();
    hideVKB();
    this.pLO.stopTimer();
    if (this.pLz != null) {
      this.pLz.dismiss();
    }
    AppMethodBeat.o(68216);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(68223);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(68223);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ComposeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(68223);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bEq();
        AppMethodBeat.o(68223);
        return;
      }
      h.a(this, getString(2131302067), getString(2131302083), getString(2131300996), getString(2131296888), false, new ComposeUI.9(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68215);
    super.onResume();
    this.pLO.ag(1500L, 1500L);
    AppMethodBeat.o(68215);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setRequestedOrientation(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI
 * JD-Core Version:    0.7.0.1
 */