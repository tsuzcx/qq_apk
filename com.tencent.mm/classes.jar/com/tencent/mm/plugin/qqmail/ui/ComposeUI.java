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
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.ConsoleMessage;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.aj;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.q.a;
import com.tencent.mm.plugin.qqmail.b.w.a;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.y;
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
  private static List<com.tencent.mm.plugin.qqmail.b.p> uNq;
  private com.tencent.mm.ui.base.p iqF;
  private EditText lmq;
  private int mode;
  private ac uKG;
  private int uLb;
  private long uMU;
  private Map<String, String> uMw;
  private ImageView uNA;
  private EditText uNB;
  private LinearLayout uNC;
  private TextView uND;
  private ImageView uNE;
  private LinearLayout uNF;
  private TextView uNG;
  private MMWebView uNH;
  private com.tencent.mm.plugin.qqmail.b.q uNI;
  private b uNJ;
  public c uNK;
  private String uNL;
  private com.tencent.mm.ui.base.o uNM;
  public boolean uNN;
  public boolean uNO;
  public boolean uNP;
  private String uNQ;
  private String uNR;
  private String uNS;
  private String uNT;
  private String uNU;
  private String uNV;
  private String uNW;
  private String uNX;
  private String uNY;
  private boolean uNZ;
  private ScrollView uNr;
  protected MailAddrsViewControl uNs;
  private ImageView uNt;
  private LinearLayout uNu;
  private LinearLayout uNv;
  private MailAddrsViewControl uNw;
  private ImageView uNx;
  private LinearLayout uNy;
  private MailAddrsViewControl uNz;
  private boolean uOa;
  private av uOb;
  private av uOc;
  q.a uOd;
  private View.OnClickListener uOe;
  private View.OnClickListener uOf;
  private MenuItem.OnMenuItemClickListener uOg;
  private View.OnClickListener uOh;
  private View.OnClickListener uOi;
  private w.a uOj;
  
  public ComposeUI()
  {
    AppMethodBeat.i(122938);
    this.uNK = new c(this);
    this.uLb = 1;
    this.uNN = true;
    this.uNO = true;
    this.uNP = false;
    this.uNQ = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    this.uNR = "document.getElementById('history').innerHTML";
    this.uNS = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    this.uNT = "</div>";
    this.uNU = null;
    this.mode = 5;
    this.uMw = new HashMap();
    this.uKG = ((com.tencent.mm.plugin.qqmail.b.o)g.ad(com.tencent.mm.plugin.qqmail.b.o.class)).getShareModeMailAppService();
    this.uNV = null;
    this.uNW = "weixin://get_img_info/";
    this.uNX = "weixin://get_mail_content/";
    this.uNY = "weixin://img_onclick/";
    this.uNZ = false;
    this.uOa = false;
    this.uOb = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(122892);
        ComposeUI.this.enableOptionMenu(ComposeUI.a(ComposeUI.this, true));
        AppMethodBeat.o(122892);
        return true;
      }
    }, true);
    this.uOc = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(122909);
        if ((ComposeUI.this.uNN) && (ComposeUI.a(ComposeUI.this, false)) && (ComposeUI.a(ComposeUI.this) == 5))
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
    this.uOd = new q.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(122920);
        MailAddrsViewControl.b localb = new MailAddrsViewControl.b(ComposeUI.this, ComposeUI.d(ComposeUI.this).akV(null));
        ComposeUI.this.uNs.setAddrsAdapter(localb);
        ComposeUI.e(ComposeUI.this).setAddrsAdapter(localb);
        ComposeUI.f(ComposeUI.this).setAddrsAdapter(localb);
        AppMethodBeat.o(122920);
      }
    };
    this.uOe = new View.OnClickListener()
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
            ComposeUI.e(ComposeUI.this).deL();
            ComposeUI.f(ComposeUI.this).deL();
            AppMethodBeat.o(122898);
          }
        });
        AppMethodBeat.o(122899);
      }
    };
    this.uOf = new View.OnClickListener()
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
          public final void kM(int paramAnonymous2Int)
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
              ad.i("MicroMsg.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), ComposeUI.this.getContext() });
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
    this.uOg = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(122904);
        if (((ComposeUI.a(ComposeUI.this, false)) && (ComposeUI.a(ComposeUI.this) == 5)) || (ComposeUI.a(ComposeUI.this) == 6)) {
          com.tencent.mm.ui.base.h.d(ComposeUI.this.getContext(), ComposeUI.this.getString(2131761969), "", ComposeUI.this.getString(2131761971), ComposeUI.this.getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(122903);
              ComposeUI.this.setResult(0);
              ComposeUI.this.finish();
              AppMethodBeat.o(122903);
            }
          }, null);
        }
        for (;;)
        {
          AppMethodBeat.o(122904);
          return true;
          ComposeUI.this.setResult(0);
          ComposeUI.this.finish();
        }
      }
    };
    this.uOh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122908);
        ComposeUI.this.hideVKB();
        ComposeUI.j(ComposeUI.this).getText();
        ComposeUI.D(ComposeUI.this);
        if (!ComposeUI.this.deu())
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
            ComposeUI.E(ComposeUI.this).deC();
            ComposeUI.E(ComposeUI.this).uPf = null;
            ((com.tencent.mm.plugin.qqmail.b.o)g.ad(com.tencent.mm.plugin.qqmail.b.o.class)).getNormalMailAppService().cancel(ComposeUI.F(ComposeUI.this));
            AppMethodBeat.o(122905);
          }
        }));
        if (!ComposeUI.E(ComposeUI.this).deD())
        {
          ComposeUI.G(ComposeUI.this).setMessage(ComposeUI.this.getString(2131761950));
          ComposeUI.E(ComposeUI.this).uPf = new b.b()
          {
            public final void dev()
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
    this.uOi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122912);
        if (!ComposeUI.E(ComposeUI.this).deD())
        {
          ComposeUI.a(ComposeUI.this, com.tencent.mm.ui.base.h.b(ComposeUI.this, ComposeUI.this.getString(2131761950), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(122910);
              ComposeUI.E(ComposeUI.this).deC();
              ComposeUI.E(ComposeUI.this).uPf = null;
              AppMethodBeat.o(122910);
            }
          }));
          ComposeUI.E(ComposeUI.this).uPf = new b.b()
          {
            public final void dev() {}
            
            public final void onComplete()
            {
              AppMethodBeat.i(122911);
              ComposeUI.G(ComposeUI.this).dismiss();
              x.a(ComposeUI.s(ComposeUI.this), ComposeUI.n(ComposeUI.this), ComposeUI.x(ComposeUI.this));
              ComposeUI.I(ComposeUI.this);
              AppMethodBeat.o(122911);
            }
          };
          AppMethodBeat.o(122912);
          return;
        }
        x.a(ComposeUI.s(ComposeUI.this), ComposeUI.n(ComposeUI.this), ComposeUI.x(ComposeUI.this));
        ComposeUI.I(ComposeUI.this);
        AppMethodBeat.o(122912);
      }
    };
    this.uOj = new w.a()
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
          ComposeUI.this.uNK.a(new c.a()
          {
            public final void deh()
            {
              AppMethodBeat.i(122915);
              ComposeUI.H(ComposeUI.this);
              AppMethodBeat.o(122915);
            }
            
            public final void dei() {}
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
        com.tencent.mm.ui.base.h.a(ComposeUI.this, 2131761954, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(122914);
            paramAnonymous2DialogInterface = ((com.tencent.mm.plugin.qqmail.b.o)g.ad(com.tencent.mm.plugin.qqmail.b.o.class)).getNormalMailAppService().uLW;
            String str = ComposeUI.J(ComposeUI.this);
            paramAnonymous2Int = ComposeUI.K(ComposeUI.this);
            paramAnonymous2DialogInterface = new com.tencent.mm.vfs.e(paramAnonymous2DialogInterface.uLa.uLk + i.ef(str, paramAnonymous2Int));
            if (paramAnonymous2DialogInterface.exists()) {
              paramAnonymous2DialogInterface.delete();
            }
            ComposeUI.this.setResult(-1);
            ComposeUI.this.finish();
            AppMethodBeat.o(122914);
          }
        });
        ComposeUI.d(ComposeUI.this).ez(ComposeUI.this.uNs.getMailAddrs());
        ComposeUI.d(ComposeUI.this).ez(ComposeUI.e(ComposeUI.this).getMailAddrs());
        ComposeUI.d(ComposeUI.this).ez(ComposeUI.f(ComposeUI.this).getMailAddrs());
        AppMethodBeat.o(122916);
      }
    };
    AppMethodBeat.o(122938);
  }
  
  private static void a(MailAddrsViewControl paramMailAddrsViewControl)
  {
    AppMethodBeat.i(122952);
    if (uNq == null)
    {
      AppMethodBeat.o(122952);
      return;
    }
    paramMailAddrsViewControl.setMailAdds(uNq);
    AppMethodBeat.o(122952);
  }
  
  private void alb(final String paramString)
  {
    AppMethodBeat.i(122954);
    final com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(paramString);
    if (!locale.exists())
    {
      AppMethodBeat.o(122954);
      return;
    }
    if (this.uNJ.Cq(paramString))
    {
      com.tencent.mm.ui.base.h.j(getContext(), 2131761990, 2131755906);
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
    com.tencent.mm.ui.base.h.a(this, getString(2131761993, new Object[] { bt.mK(i) }), getString(2131755906), new DialogInterface.OnClickListener()
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
          ad.i("MicroMsg.ComposeUI", "in upload file mode = %d", new Object[] { Integer.valueOf(ComposeUI.a(ComposeUI.this)) });
          ComposeUI.E(ComposeUI.this).hY(paramString, null);
          AppMethodBeat.o(122919);
          return;
          label151:
          paramAnonymousInt = paramAnonymousDialogInterface.length();
        }
      }
    }, null);
    AppMethodBeat.o(122954);
  }
  
  private void cAv()
  {
    AppMethodBeat.i(122947);
    if (!com.tencent.mm.pluginsdk.ui.tools.q.d(this, com.tencent.mm.loader.j.b.ais(), "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
      Toast.makeText(this, getString(2131763022), 1).show();
    }
    AppMethodBeat.o(122947);
  }
  
  private void der()
  {
    AppMethodBeat.i(122943);
    this.uNs.clearFocus();
    this.uNw.clearFocus();
    this.uNz.clearFocus();
    AppMethodBeat.o(122943);
  }
  
  private void des()
  {
    AppMethodBeat.i(122945);
    if (this.uNH != null)
    {
      this.uNH.clearFocus();
      this.uNH.getSettings().setJavaScriptEnabled(true);
      this.uNH.setWebViewClient(new b((byte)0));
      this.uNH.setWebChromeClient(new a((byte)0));
      this.uNH.setOnTouchListener(new ComposeUI.6(this));
    }
    AppMethodBeat.o(122945);
  }
  
  private String det()
  {
    AppMethodBeat.i(122949);
    String str;
    if (this.mode == 6)
    {
      x.a(this.uNH, this.uNX, this.uNR);
      if (this.uNV != null)
      {
        int i = this.uNV.indexOf(this.uNS);
        int j = this.uNV.lastIndexOf(this.uNT);
        if ((i != -1) && (j != -1))
        {
          str = this.uNV.substring(i + this.uNS.length(), j + this.uNT.length());
          AppMethodBeat.o(122949);
          return str;
        }
        str = this.uNV;
        AppMethodBeat.o(122949);
        return str;
      }
    }
    else if (this.mode == 5)
    {
      str = this.lmq.getText().toString();
      AppMethodBeat.o(122949);
      return str;
    }
    AppMethodBeat.o(122949);
    return null;
  }
  
  static void eA(List<com.tencent.mm.plugin.qqmail.b.p> paramList)
  {
    uNq = paramList;
  }
  
  private String getSubject()
  {
    int i = 40;
    AppMethodBeat.i(122950);
    String str = this.uNB.getText().toString();
    if (str.trim().length() > 0)
    {
      AppMethodBeat.o(122950);
      return str;
    }
    str = det();
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
    else if ((this.mode == 6) && (!bt.isNullOrNil(str)))
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
  
  protected final boolean deu()
  {
    AppMethodBeat.i(122951);
    if (!this.uNs.deK())
    {
      Toast.makeText(this, 2131761976, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (!this.uNw.deK())
    {
      Toast.makeText(this, 2131761967, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (!this.uNz.deK())
    {
      Toast.makeText(this, 2131761965, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (this.uNs.getMailAddrs().size() + this.uNw.getMailAddrs().size() + this.uNz.getMailAddrs().size() > 20)
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
    this.uNr = ((ScrollView)findViewById(2131303594));
    this.uNs = ((MailAddrsViewControl)findViewById(2131303590));
    this.uNt = ((ImageView)findViewById(2131303585));
    this.uNu = ((LinearLayout)findViewById(2131303593));
    this.uNv = ((LinearLayout)findViewById(2131303589));
    this.uNw = ((MailAddrsViewControl)findViewById(2131303588));
    this.uNx = ((ImageView)findViewById(2131303584));
    this.uNy = ((LinearLayout)findViewById(2131303587));
    this.uNz = ((MailAddrsViewControl)findViewById(2131303586));
    this.uNA = ((ImageView)findViewById(2131303583));
    this.uNB = ((EditText)findViewById(2131303598));
    this.uNC = ((LinearLayout)findViewById(2131303582));
    this.uNG = ((TextView)findViewById(2131303320));
    this.lmq = ((EditText)findViewById(2131303595));
    this.uNH = MMWebView.a.s(this, 2131303596);
    this.uND = ((TextView)findViewById(2131303592));
    this.uNE = ((ImageView)findViewById(2131303591));
    this.uNF = ((LinearLayout)findViewById(2131303319));
    this.uNs.setEditable(true);
    this.uNw.setEditable(true);
    this.uNz.setEditable(true);
    Object localObject3 = getIntent().getStringExtra("mail_content");
    Object localObject4 = getIntent().getStringArrayListExtra("mail_attach");
    Object localObject1 = getIntent().getStringArrayListExtra("mail_attach_title");
    Object localObject2 = ((com.tencent.mm.plugin.qqmail.b.o)g.ad(com.tencent.mm.plugin.qqmail.b.o.class)).getNormalMailAppService().uLW.ee(this.uNL, this.uLb);
    this.uNJ = new b(this, this.uND, this.uNE, this.uNF, (byte)0);
    int i;
    if (!bt.isNullOrNil((String)localObject3))
    {
      ad.i("MicroMsg.ComposeUI", "read mail from extra");
      if (this.mode == 6)
      {
        des();
        this.uNs.requestFocus();
        this.uNV = String.format(this.uNU, new Object[] { localObject3 });
        this.uNH.loadDataWithBaseURL("", this.uNV, "text/html", "utf-8", "");
        this.lmq.setVisibility(8);
        this.uNH.setVisibility(0);
        this.uNJ.mode = this.mode;
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
              if ((int)((com.tencent.mm.vfs.e)localObject4).length() + this.uNJ.getTotalSize() <= 52428800) {
                break label1234;
              }
              com.tencent.mm.ui.base.h.a(this, 2131761992, 2131755906, null);
            }
          }
        }
        label566:
        if (this.uLb == 1) {
          break label1728;
        }
        localObject1 = getIntent().getStringArrayExtra("toList");
        localObject3 = getIntent().getStringArrayExtra("ccList");
        localObject4 = getIntent().getStringArrayExtra("bccList");
        localObject2 = getIntent().getStringExtra("subject");
        this.uNs.c((String[])localObject1, false);
        this.uNw.c((String[])localObject3, false);
        this.uNz.c((String[])localObject4, false);
        if (!bt.isNullOrNil((String)localObject2))
        {
          localObject3 = this.uNB;
          localObject4 = new StringBuilder();
          if (this.uLb != 2) {
            break label1721;
          }
          localObject1 = "Re:";
          label683:
          ((EditText)localObject3).setText((String)localObject1 + (String)localObject2);
        }
        label701:
        if ((this.uNw.getMailAddrs().size() > 0) || (this.uNz.getMailAddrs().size() > 0))
        {
          this.uNu.setVisibility(8);
          this.uNv.setVisibility(0);
          this.uNy.setVisibility(0);
        }
        if ((this.uLb == 2) && (this.mode != 6) && (this.mode == 5))
        {
          this.lmq.requestFocus();
          this.lmq.setSelection(0);
          this.uNr.postDelayed(new ComposeUI.18(this), 1000L);
        }
        this.uNs.setOnActionListener(new c(this.uNt, 0));
        this.uNw.setOnActionListener(new c(this.uNx, 1));
        this.uNz.setOnActionListener(new c(this.uNA, 2));
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
                paramAnonymousMailAddrsViewControl.uPJ.setText("");
                ComposeUI.i(ComposeUI.this).postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(122922);
                    ComposeUI.h(ComposeUI.this);
                    ComposeUI.19.1.this.uOs.requestFocus();
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
                    ComposeUI.19.2.this.uOs.requestFocus();
                    ComposeUI.this.showVKB();
                    AppMethodBeat.o(122924);
                  }
                }, 150L);
                AppMethodBeat.o(122925);
              }
            });
            AppMethodBeat.o(122926);
          }
          
          public final void dew()
          {
            AppMethodBeat.i(122927);
            t.a(ComposeUI.this, ComposeUI.this.getString(2131761980), 1500L);
            AppMethodBeat.o(122927);
          }
        };
        this.uNs.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
        this.uNw.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
        this.uNz.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
        this.uNt.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(122928);
            paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
            paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.uNs.a(false, null));
            paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
            paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
            ComposeUI.this.startActivityForResult(paramAnonymousView, 0);
            ComposeUI.this.overridePendingTransition(2130772108, 2130772048);
            AppMethodBeat.o(122928);
          }
        });
        this.uNx.setOnClickListener(new View.OnClickListener()
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
        this.uNA.setOnClickListener(new View.OnClickListener()
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
        this.uNu.setOnClickListener(this.uOe);
        localObject1 = (ImageView)findViewById(2131303597);
        if ((this.uNO) && (this.uNB.getText().length() > 0)) {
          ((ImageView)localObject1).setVisibility(0);
        }
        this.uNB.setOnFocusChangeListener(new ComposeUI.23(this));
        this.uNB.addTextChangedListener(new ComposeUI.2(this, (ImageView)localObject1));
        ((ImageView)localObject1).setOnClickListener(new ComposeUI.3(this));
        this.uNC.setOnClickListener(this.uOf);
        setMMTitle(2131761974);
        if (getIntent().getBooleanExtra("show_qqmail", false))
        {
          i = ((Integer)g.afB().afk().get(9, Integer.valueOf(0))).intValue();
          if (i != 0) {
            break label1832;
          }
          ad.w("MicroMsg.ComposeUI", "want to show qqmail address, but unbind qq");
        }
        label1109:
        setBackBtn(this.uOg);
        if (this.mode != 5) {
          break label1866;
        }
        addTextOptionMenu(0, getString(2131755884), new ComposeUI.4(this));
      }
    }
    for (;;)
    {
      enableOptionMenu(false);
      der();
      AppMethodBeat.o(122944);
      return;
      if (this.mode != 5) {
        break;
      }
      this.lmq.setVisibility(0);
      this.uNH.setVisibility(8);
      if (((String)localObject3).indexOf("<div>") != -1)
      {
        ad.i("MicroMsg.ComposeUI", "set content in html format");
        this.lmq.setText(Html.fromHtml((String)localObject3));
        break;
      }
      this.lmq.setText((CharSequence)localObject3);
      break;
      label1234:
      ad.i("MicroMsg.ComposeUI", "in upload file mode = %d", new Object[] { Integer.valueOf(this.mode) });
      this.uNJ.hY((String)localObject3, (String)((List)localObject1).get(i));
      i += 1;
      break label495;
      if ((localObject2 != null) && (this.mode == 6))
      {
        ad.i("MicroMsg.ComposeUI", "read mail from draftMail");
        this.uNs.eB(((j)localObject2).uLd);
        this.uNw.eB(((j)localObject2).uLe);
        this.uNz.eB(((j)localObject2).uLf);
        this.uNB.setText(((j)localObject2).uLh);
        localObject1 = ((j)localObject2).content;
        this.mode = 5;
        if (((String)localObject1).indexOf("<div>") != -1)
        {
          ad.i("MicroMsg.ComposeUI", "set content in html format");
          this.lmq.setText(Html.fromHtml((String)localObject1));
        }
        for (;;)
        {
          this.uNJ.mode = this.mode;
          localObject1 = this.uNJ;
          localObject2 = ((j)localObject2).uLg;
          if (localObject2 == null) {
            break label1561;
          }
          localObject3 = ((List)localObject2).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (aj)((Iterator)localObject3).next();
            ((b)localObject1).a((aj)localObject4);
            ((b)localObject1).uPb.put(((aj)localObject4).path, localObject4);
          }
          this.lmq.setText((CharSequence)localObject1);
        }
        if (((b)localObject1).mode == 6)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (aj)((Iterator)localObject2).next();
            ((b)localObject1).uPd.put(((aj)localObject3).path, ((aj)localObject3).stn);
            ((b)localObject1).uPe.put(((aj)localObject3).path, ((aj)localObject3).name);
          }
        }
        label1561:
        this.uNJ.deE();
        this.uNH.setVisibility(8);
        this.lmq.setVisibility(0);
        break label566;
      }
      ad.i("MicroMsg.ComposeUI", "no extra or draf mail content");
      if (this.mode == 6)
      {
        des();
        this.uNs.requestFocus();
        this.uNV = String.format(this.uNU, new Object[] { "" });
        this.uNH.loadDataWithBaseURL("", this.uNV, "text/html", "utf-8", "");
        this.lmq.setVisibility(8);
        this.uNH.setVisibility(0);
      }
      for (;;)
      {
        this.uNJ.mode = this.mode;
        break;
        if (this.mode == 5)
        {
          this.uNH.setVisibility(8);
          this.lmq.setVisibility(0);
        }
      }
      label1721:
      localObject1 = "Fwd:";
      break label683;
      label1728:
      if ((this.uLb == 2) || (this.uLb == 3))
      {
        this.uNG.setVisibility(0);
        break label701;
      }
      if (this.uLb == 4)
      {
        localObject1 = getIntent().getStringArrayExtra("toList");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label701;
        }
        this.uNs.c((String[])localObject1, false);
        break label701;
      }
      if (this.uLb != 1) {
        break label701;
      }
      localObject1 = getIntent().getStringExtra("subject");
      if (bt.isNullOrNil((String)localObject1)) {
        break label701;
      }
      this.uNB.setText((CharSequence)localObject1);
      break label701;
      label1832:
      setMMSubTitle(new com.tencent.mm.b.p(i) + "@qq.com");
      break label1109;
      label1866:
      if (this.mode == 6)
      {
        ad.i("MicroMsg.ComposeUI", "set onShareModeSendListener");
        addTextOptionMenu(0, getString(2131755884), new ComposeUI.5(this));
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
      a(this.uNs);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      a(this.uNw);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      a(this.uNz);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.h(this, paramIntent, d.apW());
      if (paramIntent != null)
      {
        alb(paramIntent);
        der();
        AppMethodBeat.o(122953);
        return;
        if (paramIntent != null)
        {
          paramIntent = com.tencent.mm.ui.tools.a.i(this, paramIntent, d.apW());
          if ((paramIntent != null) && (paramIntent.length() > 0))
          {
            alb(paramIntent);
            der();
            AppMethodBeat.o(122953);
            return;
            if (paramIntent != null)
            {
              alb(paramIntent.getStringExtra("choosed_file_path"));
              der();
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
    this.uNU = (this.uNS + "%s" + this.uNT);
    this.uNZ = false;
    this.uOa = false;
    this.uLb = getIntent().getIntExtra("composeType", 1);
    this.uNL = getIntent().getStringExtra("mailid");
    if (this.uNL == null) {
      this.uNL = "";
    }
    this.mode = getIntent().getIntExtra("mail_mode", 5);
    ad.d("MicroMsg.ComposeUI", "onCreate, mode = %d", new Object[] { Integer.valueOf(this.mode) });
    initView();
    this.uNI = ((com.tencent.mm.plugin.qqmail.b.o)g.ad(com.tencent.mm.plugin.qqmail.b.o.class)).getNormalMailAppService().uLV;
    this.uNI.a(this.uOd);
    this.uNI.ddW();
    this.uOc.av(180000L, 180000L);
    AppMethodBeat.o(122939);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122942);
    super.onDestroy();
    if (uNq != null) {
      uNq = null;
    }
    this.uNJ.deC();
    b localb = this.uNJ;
    g.afA().gcy.b(484, localb);
    this.uNI.b(this.uOd);
    this.uNK.release();
    this.uOc.stopTimer();
    AppMethodBeat.o(122942);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(122946);
    if (paramInt == 4)
    {
      this.uOg.onMenuItemClick(null);
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
    this.uOb.stopTimer();
    if (this.uNM != null) {
      this.uNM.dismiss();
    }
    AppMethodBeat.o(122941);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(122948);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.ComposeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(122948);
      return;
    }
    ad.i("MicroMsg.ComposeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122948);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cAv();
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
    this.uOb.av(1500L, 1500L);
    AppMethodBeat.o(122940);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setRequestedOrientation(int paramInt) {}
  
  final class a
    extends com.tencent.xweb.w
  {
    private a() {}
    
    @Deprecated
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(122932);
      ad.i("MicroMsg.ComposeUI", "console, consoleMessage: %s", new Object[] { paramConsoleMessage });
      if (paramConsoleMessage != null) {}
      Object localObject4;
      Object localObject3;
      for (Object localObject1 = paramConsoleMessage.message();; localObject1 = null)
      {
        localObject1 = x.aCO((String)localObject1);
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
          ad.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[] { localObject1[1], localObject3, localObject4 });
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(Integer.valueOf((String)localObject3).intValue());
          localObject1 = new Intent(ComposeUI.this, MailImageDownloadUI.class);
          ((Intent)localObject1).putExtra("img_msg_id", ((du)localObject3).field_msgId);
          ((Intent)localObject1).putExtra("img_server_id", ((du)localObject3).field_msgSvrId);
          ((Intent)localObject1).putExtra("img_download_compress_type", 0);
          ((Intent)localObject1).putExtra("img_download_username", ((du)localObject3).field_talker);
          localObject3 = ComposeUI.this;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentChromeClient", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ComposeUI)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentChromeClient", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(122932);
          return true;
        }
        catch (Exception localException)
        {
          ad.w("MicroMsg.ComposeUI", "consoleMessage IMG_ONCLICK, ex = %s", new Object[] { localException.getMessage() });
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
              ad.w("MicroMsg.ComposeUI", "consoleMessage GET_MAIL_CONTENT, ex = %s", new Object[] { paramConsoleMessage.getMessage() });
            }
            x.a(ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this), ComposeUI.u(ComposeUI.this));
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
          ad.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", new Object[] { localObject4, paramConsoleMessage });
          ComposeUI.q(ComposeUI.this).put(localObject4, paramConsoleMessage);
          i += 1;
        }
        if (!ComposeUI.o(ComposeUI.this)) {
          break label703;
        }
      }
      catch (Exception paramConsoleMessage)
      {
        ad.w("MicroMsg.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", new Object[] { paramConsoleMessage.getMessage() });
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
    extends com.tencent.xweb.ab
  {
    private boolean uOw = false;
    
    private b() {}
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(122933);
      ad.d("MicroMsg.ComposeUI", "shouldOverrideUrlLoading, url = %s", new Object[] { paramString });
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
          ad.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[] { paramWebView[1], paramString, localObject });
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(Integer.valueOf(paramString).intValue());
          paramWebView = new Intent(ComposeUI.this, MailImageDownloadUI.class);
          paramWebView.putExtra("img_msg_id", paramString.field_msgId);
          paramWebView.putExtra("img_server_id", paramString.field_msgSvrId);
          paramWebView.putExtra("img_download_compress_type", 0);
          paramWebView.putExtra("img_download_username", paramString.field_talker);
          paramString = ComposeUI.this;
          paramWebView = new com.tencent.mm.hellhoundlib.b.a().bd(paramWebView);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramWebView.adn(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramWebView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(122933);
          return true;
        }
        catch (Exception paramWebView)
        {
          ad.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading IMG_ONCLICK, ex = %s", new Object[] { paramWebView.getMessage() });
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
              ad.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_MAIL_CONTENT, ex = %s", new Object[] { paramWebView.getMessage() });
            }
            x.a(ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this), ComposeUI.u(ComposeUI.this));
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
          ad.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", new Object[] { str, paramWebView });
          ComposeUI.q(ComposeUI.this).put(str, paramWebView);
          i += 1;
        }
        if (!ComposeUI.o(ComposeUI.this)) {
          break label636;
        }
      }
      catch (Exception paramWebView)
      {
        ad.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_IMG_INFO, ex = %s", new Object[] { paramWebView.getMessage() });
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
      ad.d("MicroMsg.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", new Object[] { paramString, Boolean.valueOf(this.uOw) });
      if (!this.uOw)
      {
        this.uOw = true;
        x.a(ComposeUI.s(ComposeUI.this), ComposeUI.n(ComposeUI.this), ComposeUI.x(ComposeUI.this));
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
        x.c(ComposeUI.s(ComposeUI.this));
        ComposeUI.w(ComposeUI.this);
      }
      AppMethodBeat.o(122934);
    }
  }
  
  final class c
    extends MailAddrsViewControl.c
  {
    private int tag;
    private ImageView uOx;
    
    public c(ImageView paramImageView, int paramInt)
    {
      this.uOx = paramImageView;
      this.tag = paramInt;
    }
    
    public final void og(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(122937);
      ComposeUI.y(ComposeUI.this);
      Object localObject;
      if (ComposeUI.this.uNP) {
        localObject = this.uOx;
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
              if ((!ComposeUI.e(ComposeUI.this).uPJ.isFocused()) && (!ComposeUI.f(ComposeUI.this).uPJ.isFocused()) && (ComposeUI.e(ComposeUI.this).getMailAddrs().size() == 0) && (ComposeUI.f(ComposeUI.this).getMailAddrs().size() == 0) && (ComposeUI.e(ComposeUI.this).deH()) && (ComposeUI.f(ComposeUI.this).deH()))
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
        ImageView localImageView = this.uOx;
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