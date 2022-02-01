package com.tencent.mm.plugin.qqmail.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.webkit.ConsoleMessage;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.qqmail.b.aj;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.q.a;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.w.a;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
public class ComposeUI
  extends MMActivity
{
  private static List<com.tencent.mm.plugin.qqmail.b.p> vWg;
  private com.tencent.mm.ui.base.p iQM;
  private EditText lMg;
  private int mode;
  private int vTS;
  private com.tencent.mm.plugin.qqmail.b.ac vTx;
  private long vVK;
  private Map<String, String> vVm;
  public c vWA;
  private String vWB;
  private com.tencent.mm.ui.base.o vWC;
  public boolean vWD;
  public boolean vWE;
  public boolean vWF;
  private String vWG;
  private String vWH;
  private String vWI;
  private String vWJ;
  private String vWK;
  private String vWL;
  private String vWM;
  private String vWN;
  private String vWO;
  private boolean vWP;
  private boolean vWQ;
  private au vWR;
  private au vWS;
  q.a vWT;
  private View.OnClickListener vWU;
  private View.OnClickListener vWV;
  private MenuItem.OnMenuItemClickListener vWW;
  private View.OnClickListener vWX;
  private View.OnClickListener vWY;
  private w.a vWZ;
  private ScrollView vWh;
  protected MailAddrsViewControl vWi;
  private ImageView vWj;
  private LinearLayout vWk;
  private LinearLayout vWl;
  private MailAddrsViewControl vWm;
  private ImageView vWn;
  private LinearLayout vWo;
  private MailAddrsViewControl vWp;
  private ImageView vWq;
  private EditText vWr;
  private LinearLayout vWs;
  private TextView vWt;
  private ImageView vWu;
  private LinearLayout vWv;
  private TextView vWw;
  private MMWebView vWx;
  private com.tencent.mm.plugin.qqmail.b.q vWy;
  private b vWz;
  
  public ComposeUI()
  {
    AppMethodBeat.i(122938);
    this.vWA = new c(this);
    this.vTS = 1;
    this.vWD = true;
    this.vWE = true;
    this.vWF = false;
    this.vWG = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    this.vWH = "document.getElementById('history').innerHTML";
    this.vWI = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    this.vWJ = "</div>";
    this.vWK = null;
    this.mode = 5;
    this.vVm = new HashMap();
    this.vTx = ((com.tencent.mm.plugin.qqmail.b.o)g.ad(com.tencent.mm.plugin.qqmail.b.o.class)).getShareModeMailAppService();
    this.vWL = null;
    this.vWM = "weixin://get_img_info/";
    this.vWN = "weixin://get_mail_content/";
    this.vWO = "weixin://img_onclick/";
    this.vWP = false;
    this.vWQ = false;
    this.vWR = new au(new ComposeUI.1(this), true);
    this.vWS = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(122909);
        if ((ComposeUI.this.vWD) && (ComposeUI.a(ComposeUI.this, false)) && (ComposeUI.a(ComposeUI.this) == 5))
        {
          ComposeUI.b(ComposeUI.this);
          if (ComposeUI.c(ComposeUI.this) != null) {
            ComposeUI.c(ComposeUI.this).dismiss();
          }
          ComposeUI.a(ComposeUI.this, t.a(ComposeUI.this, ComposeUI.this.getString(2131761963), 2000L));
        }
        AppMethodBeat.o(122909);
        return true;
      }
    }, true);
    this.vWT = new q.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(122920);
        MailAddrsViewControl.b localb = new MailAddrsViewControl.b(ComposeUI.this, ComposeUI.d(ComposeUI.this).apU(null));
        ComposeUI.this.vWi.setAddrsAdapter(localb);
        ComposeUI.e(ComposeUI.this).setAddrsAdapter(localb);
        ComposeUI.f(ComposeUI.this).setAddrsAdapter(localb);
        AppMethodBeat.o(122920);
      }
    };
    this.vWU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122899);
        ComposeUI.z(ComposeUI.this).setVisibility(8);
        ComposeUI.A(ComposeUI.this).setVisibility(0);
        ComposeUI.B(ComposeUI.this).setVisibility(0);
        ComposeUI.z(ComposeUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(122898);
            ComposeUI.A(ComposeUI.this).requestFocus();
            ComposeUI.e(ComposeUI.this).dss();
            ComposeUI.f(ComposeUI.this).dss();
            AppMethodBeat.o(122898);
          }
        });
        AppMethodBeat.o(122899);
      }
    };
    this.vWV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122901);
        paramAnonymousView = ComposeUI.this;
        String str1 = ComposeUI.this.getString(2131761962);
        String str2 = ComposeUI.this.getString(2131761959);
        String str3 = ComposeUI.this.getString(2131761960);
        h.c local1 = new h.c()
        {
          public final void kG(int paramAnonymous2Int)
          {
            AppMethodBeat.i(122900);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(122900);
              return;
              boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ComposeUI.this.getContext(), "android.permission.CAMERA", 16, "", "");
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), ComposeUI.this.getContext() });
              if (!bool)
              {
                AppMethodBeat.o(122900);
                return;
              }
              ComposeUI.C(ComposeUI.this);
              AppMethodBeat.o(122900);
              return;
              com.tencent.mm.pluginsdk.ui.tools.q.c(ComposeUI.this, 4, null);
              AppMethodBeat.o(122900);
              return;
              Intent localIntent = new Intent(ComposeUI.this, FileExplorerUI.class);
              ComposeUI.this.startActivityForResult(localIntent, 5);
            }
          }
        };
        com.tencent.mm.ui.base.h.a(paramAnonymousView, null, new String[] { str1, str2, str3 }, null, local1);
        AppMethodBeat.o(122901);
      }
    };
    this.vWW = new ComposeUI.10(this);
    this.vWX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122908);
        ComposeUI.this.hideVKB();
        ComposeUI.j(ComposeUI.this).getText();
        ComposeUI.D(ComposeUI.this);
        if (!ComposeUI.this.dsc())
        {
          AppMethodBeat.o(122908);
          return;
        }
        paramAnonymousView = ComposeUI.this;
        ComposeUI localComposeUI = ComposeUI.this;
        ComposeUI.this.getString(2131755906);
        ComposeUI.a(paramAnonymousView, com.tencent.mm.ui.base.h.b(localComposeUI, ComposeUI.this.getString(2131761953), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(122905);
            ComposeUI.E(ComposeUI.this).dsk();
            ComposeUI.E(ComposeUI.this).vXV = null;
            ((com.tencent.mm.plugin.qqmail.b.o)g.ad(com.tencent.mm.plugin.qqmail.b.o.class)).getNormalMailAppService().cancel(ComposeUI.F(ComposeUI.this));
            AppMethodBeat.o(122905);
          }
        }));
        if (!ComposeUI.E(ComposeUI.this).dsl())
        {
          ComposeUI.G(ComposeUI.this).setMessage(ComposeUI.this.getString(2131761950));
          ComposeUI.E(ComposeUI.this).vXV = new b.b()
          {
            public final void dsd()
            {
              AppMethodBeat.i(122906);
              ComposeUI.G(ComposeUI.this).setMessage(ComposeUI.this.getString(2131761950));
              AppMethodBeat.o(122906);
            }
            
            public final void onComplete()
            {
              AppMethodBeat.i(122907);
              ComposeUI.a(ComposeUI.this, ComposeUI.H(ComposeUI.this));
              AppMethodBeat.o(122907);
            }
          };
          AppMethodBeat.o(122908);
          return;
        }
        ComposeUI.a(ComposeUI.this, ComposeUI.H(ComposeUI.this));
        AppMethodBeat.o(122908);
      }
    };
    this.vWY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122912);
        if (!ComposeUI.E(ComposeUI.this).dsl())
        {
          ComposeUI.a(ComposeUI.this, com.tencent.mm.ui.base.h.b(ComposeUI.this, ComposeUI.this.getString(2131761950), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(122910);
              ComposeUI.E(ComposeUI.this).dsk();
              ComposeUI.E(ComposeUI.this).vXV = null;
              AppMethodBeat.o(122910);
            }
          }));
          ComposeUI.E(ComposeUI.this).vXV = new b.b()
          {
            public final void dsd() {}
            
            public final void onComplete()
            {
              AppMethodBeat.i(122911);
              ComposeUI.G(ComposeUI.this).dismiss();
              com.tencent.mm.pluginsdk.ui.tools.x.a(ComposeUI.s(ComposeUI.this), ComposeUI.n(ComposeUI.this), ComposeUI.x(ComposeUI.this));
              ComposeUI.I(ComposeUI.this);
              AppMethodBeat.o(122911);
            }
          };
          AppMethodBeat.o(122912);
          return;
        }
        com.tencent.mm.pluginsdk.ui.tools.x.a(ComposeUI.s(ComposeUI.this), ComposeUI.n(ComposeUI.this), ComposeUI.x(ComposeUI.this));
        ComposeUI.I(ComposeUI.this);
        AppMethodBeat.o(122912);
      }
    };
    this.vWZ = new w.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(122918);
        if (ComposeUI.G(ComposeUI.this) != null)
        {
          ComposeUI.G(ComposeUI.this).dismiss();
          ComposeUI.a(ComposeUI.this, null);
        }
        AppMethodBeat.o(122918);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(122917);
        if (paramAnonymousInt == -5)
        {
          ComposeUI.this.vWA.a(new c.a()
          {
            public final void drP()
            {
              AppMethodBeat.i(122915);
              ComposeUI.H(ComposeUI.this);
              AppMethodBeat.o(122915);
            }
            
            public final void drQ() {}
          });
          AppMethodBeat.o(122917);
          return;
        }
        com.tencent.mm.ui.base.h.d(ComposeUI.this, paramAnonymousString, ComposeUI.this.getString(2131761952), null);
        AppMethodBeat.o(122917);
      }
      
      public final void onSuccess(String paramAnonymousString, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(122916);
        com.tencent.mm.ui.base.h.a(ComposeUI.this, 2131761954, 2131755906, new ComposeUI.15.1(this));
        ComposeUI.d(ComposeUI.this).eD(ComposeUI.this.vWi.getMailAddrs());
        ComposeUI.d(ComposeUI.this).eD(ComposeUI.e(ComposeUI.this).getMailAddrs());
        ComposeUI.d(ComposeUI.this).eD(ComposeUI.f(ComposeUI.this).getMailAddrs());
        AppMethodBeat.o(122916);
      }
    };
    AppMethodBeat.o(122938);
  }
  
  private static void a(MailAddrsViewControl paramMailAddrsViewControl)
  {
    AppMethodBeat.i(122952);
    if (vWg == null)
    {
      AppMethodBeat.o(122952);
      return;
    }
    paramMailAddrsViewControl.setMailAdds(vWg);
    AppMethodBeat.o(122952);
  }
  
  private void aqa(final String paramString)
  {
    AppMethodBeat.i(122954);
    final com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(paramString);
    if (!locale.exists())
    {
      AppMethodBeat.o(122954);
      return;
    }
    if (this.vWz.Gt(paramString))
    {
      com.tencent.mm.ui.base.h.l(getContext(), 2131761990, 2131755906);
      AppMethodBeat.o(122954);
      return;
    }
    final int i = (int)locale.length();
    if (i > 20971520)
    {
      com.tencent.mm.ui.base.h.a(this, 2131761991, 2131755906, null);
      AppMethodBeat.o(122954);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(2131761993, new Object[] { bs.qz(i) }), getString(2131755906), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(122919);
        if (ComposeUI.E(ComposeUI.this).getTotalSize() + i > 52428800)
        {
          com.tencent.mm.ui.base.h.a(ComposeUI.this, 2131761992, 2131755906, null);
          AppMethodBeat.o(122919);
          return;
        }
        EditText localEditText;
        if (ComposeUI.j(ComposeUI.this).getText().toString().trim().length() == 0)
        {
          paramAnonymousDialogInterface = locale.getName().trim();
          paramAnonymousInt = paramAnonymousDialogInterface.lastIndexOf(".");
          localEditText = ComposeUI.j(ComposeUI.this);
          if (paramAnonymousInt <= 0) {
            break label151;
          }
        }
        for (;;)
        {
          localEditText.setText(paramAnonymousDialogInterface.substring(0, paramAnonymousInt));
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "in upload file mode = %d", new Object[] { Integer.valueOf(ComposeUI.a(ComposeUI.this)) });
          ComposeUI.E(ComposeUI.this).ir(paramString, null);
          AppMethodBeat.o(122919);
          return;
          label151:
          paramAnonymousInt = paramAnonymousDialogInterface.length();
        }
      }
    }, null);
    AppMethodBeat.o(122954);
  }
  
  private void cNE()
  {
    AppMethodBeat.i(122947);
    if (!com.tencent.mm.pluginsdk.ui.tools.q.d(this, com.tencent.mm.loader.j.b.aps(), "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
      Toast.makeText(this, getString(2131763022), 1).show();
    }
    AppMethodBeat.o(122947);
  }
  
  private void drZ()
  {
    AppMethodBeat.i(122943);
    this.vWi.clearFocus();
    this.vWm.clearFocus();
    this.vWp.clearFocus();
    AppMethodBeat.o(122943);
  }
  
  private void dsa()
  {
    AppMethodBeat.i(122945);
    if (this.vWx != null)
    {
      this.vWx.clearFocus();
      this.vWx.getSettings().setJavaScriptEnabled(true);
      this.vWx.setWebViewClient(new b((byte)0));
      this.vWx.setWebChromeClient(new a((byte)0));
      this.vWx.setOnTouchListener(new ComposeUI.6(this));
    }
    AppMethodBeat.o(122945);
  }
  
  private String dsb()
  {
    AppMethodBeat.i(122949);
    String str;
    if (this.mode == 6)
    {
      com.tencent.mm.pluginsdk.ui.tools.x.a(this.vWx, this.vWN, this.vWH);
      if (this.vWL != null)
      {
        int i = this.vWL.indexOf(this.vWI);
        int j = this.vWL.lastIndexOf(this.vWJ);
        if ((i != -1) && (j != -1))
        {
          str = this.vWL.substring(i + this.vWI.length(), j + this.vWJ.length());
          AppMethodBeat.o(122949);
          return str;
        }
        str = this.vWL;
        AppMethodBeat.o(122949);
        return str;
      }
    }
    else if (this.mode == 5)
    {
      str = this.lMg.getText().toString();
      AppMethodBeat.o(122949);
      return str;
    }
    AppMethodBeat.o(122949);
    return null;
  }
  
  static void eE(List<com.tencent.mm.plugin.qqmail.b.p> paramList)
  {
    vWg = paramList;
  }
  
  private String getSubject()
  {
    int i = 40;
    AppMethodBeat.i(122950);
    String str = this.vWr.getText().toString();
    if (str.trim().length() > 0)
    {
      AppMethodBeat.o(122950);
      return str;
    }
    str = dsb();
    if (this.mode == 5)
    {
      if (str.length() > 0)
      {
        if (str.length() > 40) {}
        for (;;)
        {
          str = str.substring(0, i);
          AppMethodBeat.o(122950);
          return str;
          i = str.length();
        }
      }
    }
    else if ((this.mode == 6) && (!bs.isNullOrNil(str)))
    {
      if (str.length() > 40) {}
      for (;;)
      {
        str = str.substring(0, i);
        AppMethodBeat.o(122950);
        return str;
        i = str.length();
      }
    }
    str = getString(2131761970);
    AppMethodBeat.o(122950);
    return str;
  }
  
  protected final boolean dsc()
  {
    AppMethodBeat.i(122951);
    if (!this.vWi.dsr())
    {
      Toast.makeText(this, 2131761976, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (!this.vWm.dsr())
    {
      Toast.makeText(this, 2131761967, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (!this.vWp.dsr())
    {
      Toast.makeText(this, 2131761965, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (this.vWi.getMailAddrs().size() + this.vWm.getMailAddrs().size() + this.vWp.getMailAddrs().size() > 20)
    {
      Toast.makeText(this, 2131761982, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    AppMethodBeat.o(122951);
    return true;
  }
  
  public int getLayoutId()
  {
    return 2131495157;
  }
  
  public void initView()
  {
    AppMethodBeat.i(122944);
    this.vWh = ((ScrollView)findViewById(2131303594));
    this.vWi = ((MailAddrsViewControl)findViewById(2131303590));
    this.vWj = ((ImageView)findViewById(2131303585));
    this.vWk = ((LinearLayout)findViewById(2131303593));
    this.vWl = ((LinearLayout)findViewById(2131303589));
    this.vWm = ((MailAddrsViewControl)findViewById(2131303588));
    this.vWn = ((ImageView)findViewById(2131303584));
    this.vWo = ((LinearLayout)findViewById(2131303587));
    this.vWp = ((MailAddrsViewControl)findViewById(2131303586));
    this.vWq = ((ImageView)findViewById(2131303583));
    this.vWr = ((EditText)findViewById(2131303598));
    this.vWs = ((LinearLayout)findViewById(2131303582));
    this.vWw = ((TextView)findViewById(2131303320));
    this.lMg = ((EditText)findViewById(2131303595));
    this.vWx = MMWebView.a.s(this, 2131303596);
    this.vWt = ((TextView)findViewById(2131303592));
    this.vWu = ((ImageView)findViewById(2131303591));
    this.vWv = ((LinearLayout)findViewById(2131303319));
    this.vWi.setEditable(true);
    this.vWm.setEditable(true);
    this.vWp.setEditable(true);
    Object localObject3 = getIntent().getStringExtra("mail_content");
    Object localObject4 = getIntent().getStringArrayListExtra("mail_attach");
    Object localObject1 = getIntent().getStringArrayListExtra("mail_attach_title");
    Object localObject2 = ((com.tencent.mm.plugin.qqmail.b.o)g.ad(com.tencent.mm.plugin.qqmail.b.o.class)).getNormalMailAppService().vUM.el(this.vWB, this.vTS);
    this.vWz = new b(this, this.vWt, this.vWu, this.vWv, (byte)0);
    int i;
    if (!bs.isNullOrNil((String)localObject3))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "read mail from extra");
      if (this.mode == 6)
      {
        dsa();
        this.vWi.requestFocus();
        this.vWL = String.format(this.vWK, new Object[] { localObject3 });
        this.vWx.loadDataWithBaseURL("", this.vWL, "text/html", "utf-8", "");
        this.lMg.setVisibility(8);
        this.vWx.setVisibility(0);
        this.vWz.mode = this.mode;
        if (this.mode == 6)
        {
          localObject2 = ((List)localObject4).iterator();
          i = 0;
          label495:
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            localObject4 = new com.tencent.mm.vfs.e((String)localObject3);
            if (((com.tencent.mm.vfs.e)localObject4).exists())
            {
              if ((int)((com.tencent.mm.vfs.e)localObject4).length() + this.vWz.getTotalSize() <= 52428800) {
                break label1234;
              }
              com.tencent.mm.ui.base.h.a(this, 2131761992, 2131755906, null);
            }
          }
        }
        label566:
        if (this.vTS == 1) {
          break label1728;
        }
        localObject1 = getIntent().getStringArrayExtra("toList");
        localObject3 = getIntent().getStringArrayExtra("ccList");
        localObject4 = getIntent().getStringArrayExtra("bccList");
        localObject2 = getIntent().getStringExtra("subject");
        this.vWi.c((String[])localObject1, false);
        this.vWm.c((String[])localObject3, false);
        this.vWp.c((String[])localObject4, false);
        if (!bs.isNullOrNil((String)localObject2))
        {
          localObject3 = this.vWr;
          localObject4 = new StringBuilder();
          if (this.vTS != 2) {
            break label1721;
          }
          localObject1 = "Re:";
          label683:
          ((EditText)localObject3).setText((String)localObject1 + (String)localObject2);
        }
        label701:
        if ((this.vWm.getMailAddrs().size() > 0) || (this.vWp.getMailAddrs().size() > 0))
        {
          this.vWk.setVisibility(8);
          this.vWl.setVisibility(0);
          this.vWo.setVisibility(0);
        }
        if ((this.vTS == 2) && (this.mode != 6) && (this.mode == 5))
        {
          this.lMg.requestFocus();
          this.lMg.setSelection(0);
          this.vWh.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(122921);
              ComposeUI.g(ComposeUI.this).fullScroll(130);
              AppMethodBeat.o(122921);
            }
          }, 1000L);
        }
        this.vWi.setOnActionListener(new c(this.vWj, 0));
        this.vWm.setOnActionListener(new c(this.vWn, 1));
        this.vWp.setOnActionListener(new c(this.vWq, 2));
        localObject1 = new MailAddrsViewControl.a()
        {
          public final void b(final MailAddrsViewControl paramAnonymousMailAddrsViewControl)
          {
            AppMethodBeat.i(122926);
            com.tencent.mm.ui.base.h.a(ComposeUI.this.getContext(), ComposeUI.this.getString(2131761980), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(122923);
                paramAnonymousMailAddrsViewControl.vYz.setText("");
                ComposeUI.i(ComposeUI.this).postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(122922);
                    ComposeUI.h(ComposeUI.this);
                    ComposeUI.19.1.this.vXi.requestFocus();
                    ComposeUI.this.showVKB();
                    AppMethodBeat.o(122922);
                  }
                }, 150L);
                AppMethodBeat.o(122923);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(122925);
                ComposeUI.i(ComposeUI.this).postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(122924);
                    ComposeUI.h(ComposeUI.this);
                    ComposeUI.19.2.this.vXi.requestFocus();
                    ComposeUI.this.showVKB();
                    AppMethodBeat.o(122924);
                  }
                }, 150L);
                AppMethodBeat.o(122925);
              }
            });
            AppMethodBeat.o(122926);
          }
          
          public final void dse()
          {
            AppMethodBeat.i(122927);
            t.a(ComposeUI.this, ComposeUI.this.getString(2131761980), 1500L);
            AppMethodBeat.o(122927);
          }
        };
        this.vWi.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
        this.vWm.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
        this.vWp.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
        this.vWj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(122928);
            paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
            paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.vWi.a(false, null));
            paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
            paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
            ComposeUI.this.startActivityForResult(paramAnonymousView, 0);
            ComposeUI.this.overridePendingTransition(2130772108, 2130772048);
            AppMethodBeat.o(122928);
          }
        });
        this.vWn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(122929);
            paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
            paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.e(ComposeUI.this).a(false, null));
            paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
            paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
            ComposeUI.this.startActivityForResult(paramAnonymousView, 1);
            ComposeUI.this.overridePendingTransition(2130772108, 2130772048);
            AppMethodBeat.o(122929);
          }
        });
        this.vWq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(122930);
            paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
            paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.f(ComposeUI.this).a(false, null));
            paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
            paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
            ComposeUI.this.startActivityForResult(paramAnonymousView, 2);
            ComposeUI.this.overridePendingTransition(2130772108, 2130772048);
            AppMethodBeat.o(122930);
          }
        });
        this.vWk.setOnClickListener(this.vWU);
        localObject1 = (ImageView)findViewById(2131303597);
        if ((this.vWE) && (this.vWr.getText().length() > 0)) {
          ((ImageView)localObject1).setVisibility(0);
        }
        this.vWr.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(122931);
            if (paramAnonymousBoolean) {
              ComposeUI.j(ComposeUI.this).setSelection(ComposeUI.j(ComposeUI.this).getText().length());
            }
            AppMethodBeat.o(122931);
          }
        });
        this.vWr.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            paramAnonymousInt1 = 4;
            AppMethodBeat.i(122893);
            if (ComposeUI.this.vWE)
            {
              paramAnonymousCharSequence = this.vXb;
              if (ComposeUI.j(ComposeUI.this).getText().length() > 0) {
                paramAnonymousInt1 = 0;
              }
              paramAnonymousCharSequence.setVisibility(paramAnonymousInt1);
              AppMethodBeat.o(122893);
              return;
            }
            this.vXb.setVisibility(4);
            AppMethodBeat.o(122893);
          }
        });
        ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(122894);
            ComposeUI.j(ComposeUI.this).getText().clear();
            ComposeUI.j(ComposeUI.this).requestFocus();
            AppMethodBeat.o(122894);
          }
        });
        this.vWs.setOnClickListener(this.vWV);
        setMMTitle(2131761974);
        if (getIntent().getBooleanExtra("show_qqmail", false))
        {
          i = ((Integer)g.agR().agA().get(9, Integer.valueOf(0))).intValue();
          if (i != 0) {
            break label1832;
          }
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ComposeUI", "want to show qqmail address, but unbind qq");
        }
        label1109:
        setBackBtn(this.vWW);
        if (this.mode != 5) {
          break label1866;
        }
        addTextOptionMenu(0, getString(2131755884), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(122895);
            ComposeUI.k(ComposeUI.this).onClick(null);
            AppMethodBeat.o(122895);
            return false;
          }
        });
      }
    }
    for (;;)
    {
      enableOptionMenu(false);
      drZ();
      AppMethodBeat.o(122944);
      return;
      if (this.mode != 5) {
        break;
      }
      this.lMg.setVisibility(0);
      this.vWx.setVisibility(8);
      if (((String)localObject3).indexOf("<div>") != -1)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "set content in html format");
        this.lMg.setText(Html.fromHtml((String)localObject3));
        break;
      }
      this.lMg.setText((CharSequence)localObject3);
      break;
      label1234:
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "in upload file mode = %d", new Object[] { Integer.valueOf(this.mode) });
      this.vWz.ir((String)localObject3, (String)((List)localObject1).get(i));
      i += 1;
      break label495;
      if ((localObject2 != null) && (this.mode == 6))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "read mail from draftMail");
        this.vWi.eF(((j)localObject2).vTU);
        this.vWm.eF(((j)localObject2).vTV);
        this.vWp.eF(((j)localObject2).vTW);
        this.vWr.setText(((j)localObject2).vTY);
        localObject1 = ((j)localObject2).content;
        this.mode = 5;
        if (((String)localObject1).indexOf("<div>") != -1)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "set content in html format");
          this.lMg.setText(Html.fromHtml((String)localObject1));
        }
        for (;;)
        {
          this.vWz.mode = this.mode;
          localObject1 = this.vWz;
          localObject2 = ((j)localObject2).vTX;
          if (localObject2 == null) {
            break label1561;
          }
          localObject3 = ((List)localObject2).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (aj)((Iterator)localObject3).next();
            ((b)localObject1).a((aj)localObject4);
            ((b)localObject1).vXR.put(((aj)localObject4).path, localObject4);
          }
          this.lMg.setText((CharSequence)localObject1);
        }
        if (((b)localObject1).mode == 6)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (aj)((Iterator)localObject2).next();
            ((b)localObject1).vXT.put(((aj)localObject3).path, ((aj)localObject3).tBd);
            ((b)localObject1).vXU.put(((aj)localObject3).path, ((aj)localObject3).name);
          }
        }
        label1561:
        this.vWz.dsm();
        this.vWx.setVisibility(8);
        this.lMg.setVisibility(0);
        break label566;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "no extra or draf mail content");
      if (this.mode == 6)
      {
        dsa();
        this.vWi.requestFocus();
        this.vWL = String.format(this.vWK, new Object[] { "" });
        this.vWx.loadDataWithBaseURL("", this.vWL, "text/html", "utf-8", "");
        this.lMg.setVisibility(8);
        this.vWx.setVisibility(0);
      }
      for (;;)
      {
        this.vWz.mode = this.mode;
        break;
        if (this.mode == 5)
        {
          this.vWx.setVisibility(8);
          this.lMg.setVisibility(0);
        }
      }
      label1721:
      localObject1 = "Fwd:";
      break label683;
      label1728:
      if ((this.vTS == 2) || (this.vTS == 3))
      {
        this.vWw.setVisibility(0);
        break label701;
      }
      if (this.vTS == 4)
      {
        localObject1 = getIntent().getStringArrayExtra("toList");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label701;
        }
        this.vWi.c((String[])localObject1, false);
        break label701;
      }
      if (this.vTS != 1) {
        break label701;
      }
      localObject1 = getIntent().getStringExtra("subject");
      if (bs.isNullOrNil((String)localObject1)) {
        break label701;
      }
      this.vWr.setText((CharSequence)localObject1);
      break label701;
      label1832:
      setMMSubTitle(new com.tencent.mm.b.p(i) + "@qq.com");
      break label1109;
      label1866:
      if (this.mode == 6)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "set onShareModeSendListener");
        addTextOptionMenu(0, getString(2131755884), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(122896);
            ComposeUI.l(ComposeUI.this).onClick(null);
            AppMethodBeat.o(122896);
            return false;
          }
        });
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(122953);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(122953);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122953);
      return;
      a(this.vWi);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      a(this.vWm);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      a(this.vWp);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.h(this, paramIntent, d.awL());
      if (paramIntent != null)
      {
        aqa(paramIntent);
        drZ();
        AppMethodBeat.o(122953);
        return;
        if (paramIntent != null)
        {
          paramIntent = com.tencent.mm.ui.tools.a.i(this, paramIntent, d.awL());
          if ((paramIntent != null) && (paramIntent.length() > 0))
          {
            aqa(paramIntent);
            drZ();
            AppMethodBeat.o(122953);
            return;
            if (paramIntent != null)
            {
              aqa(paramIntent.getStringExtra("choosed_file_path"));
              drZ();
            }
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122939);
    super.onCreate(paramBundle);
    this.vWK = (this.vWI + "%s" + this.vWJ);
    this.vWP = false;
    this.vWQ = false;
    this.vTS = getIntent().getIntExtra("composeType", 1);
    this.vWB = getIntent().getStringExtra("mailid");
    if (this.vWB == null) {
      this.vWB = "";
    }
    this.mode = getIntent().getIntExtra("mail_mode", 5);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ComposeUI", "onCreate, mode = %d", new Object[] { Integer.valueOf(this.mode) });
    initView();
    this.vWy = ((com.tencent.mm.plugin.qqmail.b.o)g.ad(com.tencent.mm.plugin.qqmail.b.o.class)).getNormalMailAppService().vUL;
    this.vWy.a(this.vWT);
    this.vWy.drE();
    this.vWS.au(180000L, 180000L);
    AppMethodBeat.o(122939);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122942);
    super.onDestroy();
    if (vWg != null) {
      vWg = null;
    }
    this.vWz.dsk();
    b localb = this.vWz;
    g.agQ().ghe.b(484, localb);
    this.vWy.b(this.vWT);
    this.vWA.release();
    this.vWS.stopTimer();
    AppMethodBeat.o(122942);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(122946);
    if (paramInt == 4)
    {
      this.vWW.onMenuItemClick(null);
      AppMethodBeat.o(122946);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(122946);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(122941);
    super.onPause();
    hideVKB();
    this.vWR.stopTimer();
    if (this.vWC != null) {
      this.vWC.dismiss();
    }
    AppMethodBeat.o(122941);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(122948);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(122948);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122948);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cNE();
        AppMethodBeat.o(122948);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new ComposeUI.9(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(122940);
    super.onResume();
    this.vWR.au(1500L, 1500L);
    AppMethodBeat.o(122940);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setRequestedOrientation(int paramInt) {}
  
  final class a
    extends com.tencent.xweb.x
  {
    private a() {}
    
    @Deprecated
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(122932);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "console, consoleMessage: %s", new Object[] { paramConsoleMessage });
      if (paramConsoleMessage != null) {}
      Object localObject4;
      Object localObject3;
      for (Object localObject1 = paramConsoleMessage.message();; localObject1 = null)
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.tools.x.aIg((String)localObject1);
        if (!((String)localObject1).startsWith(ComposeUI.m(ComposeUI.this))) {
          break label349;
        }
        ComposeUI.this.hideVKB();
        try
        {
          localObject1 = URLDecoder.decode(((String)localObject1).substring(ComposeUI.m(ComposeUI.this).length()), "utf-8").split("@@");
          localObject4 = localObject1[0].split(":");
          localObject3 = localObject4[0];
          localObject4 = localObject4[1];
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[] { localObject1[1], localObject3, localObject4 });
          localObject3 = ((k)g.ab(k.class)).dcr().vP(Integer.valueOf((String)localObject3).intValue());
          localObject1 = new Intent(ComposeUI.this, MailImageDownloadUI.class);
          ((Intent)localObject1).putExtra("img_msg_id", ((dy)localObject3).field_msgId);
          ((Intent)localObject1).putExtra("img_server_id", ((dy)localObject3).field_msgSvrId);
          ((Intent)localObject1).putExtra("img_download_compress_type", 0);
          ((Intent)localObject1).putExtra("img_download_username", ((dy)localObject3).field_talker);
          localObject3 = ComposeUI.this;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentChromeClient", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ComposeUI)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentChromeClient", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(122932);
          return true;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ComposeUI", "consoleMessage IMG_ONCLICK, ex = %s", new Object[] { localException.getMessage() });
        }
      }
      label349:
      do
      {
        boolean bool = super.onConsoleMessage(paramConsoleMessage);
        AppMethodBeat.o(122932);
        return bool;
        if (localException.startsWith(ComposeUI.n(ComposeUI.this))) {
          try
          {
            ComposeUI.a(ComposeUI.this, URLDecoder.decode(localException.substring(ComposeUI.n(ComposeUI.this).length()), "utf-8"));
            if (ComposeUI.o(ComposeUI.this)) {
              if (ComposeUI.p(ComposeUI.this).indexOf("<img") == -1)
              {
                ComposeUI.q(ComposeUI.this).clear();
                ComposeUI.r(ComposeUI.this);
                AppMethodBeat.o(122932);
                return true;
              }
            }
          }
          catch (Exception paramConsoleMessage)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ComposeUI", "consoleMessage GET_MAIL_CONTENT, ex = %s", new Object[] { paramConsoleMessage.getMessage() });
            }
            com.tencent.mm.pluginsdk.ui.tools.x.a(ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this), ComposeUI.u(ComposeUI.this));
            AppMethodBeat.o(122932);
            return true;
          }
        }
      } while (!localException.startsWith(ComposeUI.t(ComposeUI.this)));
      ComposeUI.q(ComposeUI.this).clear();
      try
      {
        paramConsoleMessage = URLDecoder.decode(localException.substring(ComposeUI.t(ComposeUI.this).length()), "utf-8");
        localObject3 = paramConsoleMessage.split("&&");
        int i = 0;
        while (i < localObject3.length)
        {
          paramConsoleMessage = localObject3[i].split("@@");
          localObject4 = paramConsoleMessage[0].split(":")[1];
          Object localObject2 = paramConsoleMessage[1];
          paramConsoleMessage = localObject2;
          if (localObject2.startsWith("file://")) {
            paramConsoleMessage = localObject2.replaceFirst("file://", "");
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", new Object[] { localObject4, paramConsoleMessage });
          ComposeUI.q(ComposeUI.this).put(localObject4, paramConsoleMessage);
          i += 1;
        }
        if (!ComposeUI.o(ComposeUI.this)) {
          break label703;
        }
      }
      catch (Exception paramConsoleMessage)
      {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", new Object[] { paramConsoleMessage.getMessage() });
        AppMethodBeat.o(122932);
        return true;
      }
      ComposeUI.r(ComposeUI.this);
      label703:
      AppMethodBeat.o(122932);
      return true;
    }
  }
  
  final class b
    extends com.tencent.xweb.ac
  {
    private boolean vXm = false;
    
    private b() {}
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(122933);
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ComposeUI", "shouldOverrideUrlLoading, url = %s", new Object[] { paramString });
      Object localObject;
      if (paramString.startsWith(ComposeUI.m(ComposeUI.this)))
      {
        ComposeUI.this.hideVKB();
        try
        {
          paramWebView = URLDecoder.decode(paramString.substring(ComposeUI.m(ComposeUI.this).length()), "utf-8").split("@@");
          localObject = paramWebView[0].split(":");
          paramString = localObject[0];
          localObject = localObject[1];
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[] { paramWebView[1], paramString, localObject });
          paramString = ((k)g.ab(k.class)).dcr().vP(Integer.valueOf(paramString).intValue());
          paramWebView = new Intent(ComposeUI.this, MailImageDownloadUI.class);
          paramWebView.putExtra("img_msg_id", paramString.field_msgId);
          paramWebView.putExtra("img_server_id", paramString.field_msgSvrId);
          paramWebView.putExtra("img_download_compress_type", 0);
          paramWebView.putExtra("img_download_username", paramString.field_talker);
          paramString = ComposeUI.this;
          paramWebView = new com.tencent.mm.hellhoundlib.b.a().ba(paramWebView);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramWebView.aeD(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramWebView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(122933);
          return true;
        }
        catch (Exception paramWebView)
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading IMG_ONCLICK, ex = %s", new Object[] { paramWebView.getMessage() });
        }
      }
      do
      {
        AppMethodBeat.o(122933);
        return true;
        if (paramString.startsWith(ComposeUI.n(ComposeUI.this))) {
          try
          {
            ComposeUI.a(ComposeUI.this, URLDecoder.decode(paramString.substring(ComposeUI.n(ComposeUI.this).length()), "utf-8"));
            if (ComposeUI.o(ComposeUI.this)) {
              if (ComposeUI.p(ComposeUI.this).indexOf("<img") == -1)
              {
                ComposeUI.q(ComposeUI.this).clear();
                ComposeUI.r(ComposeUI.this);
                AppMethodBeat.o(122933);
                return true;
              }
            }
          }
          catch (Exception paramWebView)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_MAIL_CONTENT, ex = %s", new Object[] { paramWebView.getMessage() });
            }
            com.tencent.mm.pluginsdk.ui.tools.x.a(ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this), ComposeUI.u(ComposeUI.this));
            AppMethodBeat.o(122933);
            return true;
          }
        }
      } while (!paramString.startsWith(ComposeUI.t(ComposeUI.this)));
      ComposeUI.q(ComposeUI.this).clear();
      try
      {
        paramWebView = URLDecoder.decode(paramString.substring(ComposeUI.t(ComposeUI.this).length()), "utf-8");
        localObject = paramWebView.split("&&");
        int i = 0;
        while (i < localObject.length)
        {
          paramWebView = localObject[i].split("@@");
          String str = paramWebView[0].split(":")[1];
          paramString = paramWebView[1];
          paramWebView = paramString;
          if (paramString.startsWith("file://")) {
            paramWebView = paramString.replaceFirst("file://", "");
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", new Object[] { str, paramWebView });
          ComposeUI.q(ComposeUI.this).put(str, paramWebView);
          i += 1;
        }
        if (!ComposeUI.o(ComposeUI.this)) {
          break label636;
        }
      }
      catch (Exception paramWebView)
      {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_IMG_INFO, ex = %s", new Object[] { paramWebView.getMessage() });
        AppMethodBeat.o(122933);
        return true;
      }
      ComposeUI.r(ComposeUI.this);
      label636:
      AppMethodBeat.o(122933);
      return true;
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(122935);
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", new Object[] { paramString, Boolean.valueOf(this.vXm) });
      if (!this.vXm)
      {
        this.vXm = true;
        com.tencent.mm.pluginsdk.ui.tools.x.a(ComposeUI.s(ComposeUI.this), ComposeUI.n(ComposeUI.this), ComposeUI.x(ComposeUI.this));
      }
      super.b(paramWebView, paramString);
      AppMethodBeat.o(122935);
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(122934);
      super.b(paramWebView, paramString, paramBitmap);
      if (!ComposeUI.v(ComposeUI.this))
      {
        com.tencent.mm.pluginsdk.ui.tools.x.c(ComposeUI.s(ComposeUI.this));
        ComposeUI.w(ComposeUI.this);
      }
      AppMethodBeat.o(122934);
    }
  }
  
  final class c
    extends MailAddrsViewControl.c
  {
    private int tag;
    private ImageView vXn;
    
    public c(ImageView paramImageView, int paramInt)
    {
      this.vXn = paramImageView;
      this.tag = paramInt;
    }
    
    public final void pa(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(122937);
      ComposeUI.y(ComposeUI.this);
      Object localObject;
      if (ComposeUI.this.vWF) {
        localObject = this.vXn;
      }
      for (;;)
      {
        ((ImageView)localObject).setVisibility(i);
        if (((this.tag == 1) || (this.tag == 2)) && (!paramBoolean)) {
          ComposeUI.z(ComposeUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(122936);
              if ((!ComposeUI.e(ComposeUI.this).vYz.isFocused()) && (!ComposeUI.f(ComposeUI.this).vYz.isFocused()) && (ComposeUI.e(ComposeUI.this).getMailAddrs().size() == 0) && (ComposeUI.f(ComposeUI.this).getMailAddrs().size() == 0) && (ComposeUI.e(ComposeUI.this).dso()) && (ComposeUI.f(ComposeUI.this).dso()))
              {
                ComposeUI.z(ComposeUI.this).setVisibility(0);
                ComposeUI.A(ComposeUI.this).setVisibility(8);
                ComposeUI.B(ComposeUI.this).setVisibility(8);
              }
              AppMethodBeat.o(122936);
            }
          }, 10L);
        }
        AppMethodBeat.o(122937);
        return;
        ImageView localImageView = this.vXn;
        localObject = localImageView;
        if (!paramBoolean)
        {
          i = 4;
          localObject = localImageView;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI
 * JD-Core Version:    0.7.0.1
 */