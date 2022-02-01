package com.tencent.mm.plugin.qqmail.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.ab;
import com.tencent.mm.plugin.qqmail.d.aj;
import com.tencent.mm.plugin.qqmail.d.j;
import com.tencent.mm.plugin.qqmail.d.m;
import com.tencent.mm.plugin.qqmail.d.m.a;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.z;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@SuppressLint({"SetJavaScriptEnabled"})
public class ComposeUI
  extends MMActivity
  implements f
{
  private static List<com.tencent.mm.plugin.qqmail.d.l> xtP;
  private String dyb;
  private p jmN;
  private int mode;
  private EditText mqR;
  private ab xqS;
  private int xrm;
  private Map<String, String> xsh;
  private ScrollView xtQ;
  protected MailAddrsViewControl xtR;
  private ImageView xtS;
  private LinearLayout xtT;
  private LinearLayout xtU;
  private MailAddrsViewControl xtV;
  private ImageView xtW;
  private LinearLayout xtX;
  private MailAddrsViewControl xtY;
  private ImageView xtZ;
  private boolean xuA;
  private aw xuB;
  private aw xuC;
  m.a xuD;
  private View.OnClickListener xuE;
  private View.OnClickListener xuF;
  private MenuItem.OnMenuItemClickListener xuG;
  private View.OnClickListener xuH;
  private EditText xua;
  private LinearLayout xub;
  private TextView xuc;
  private ImageView xud;
  private LinearLayout xue;
  private MMWebView xuf;
  private m xug;
  private b xuh;
  public c xui;
  private String xuj;
  private o xuk;
  public boolean xul;
  public boolean xum;
  public boolean xun;
  private String xuo;
  private String xup;
  private String xuq;
  private String xur;
  private String xus;
  private String xut;
  private List<Bundle> xuu;
  private List<String> xuv;
  private String xuw;
  private String xux;
  private String xuy;
  private boolean xuz;
  
  public ComposeUI()
  {
    AppMethodBeat.i(122938);
    this.xui = new c(this);
    this.xrm = 1;
    this.xul = true;
    this.xum = true;
    this.xun = false;
    this.xuo = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    this.xup = "document.getElementById('history').innerHTML";
    this.xuq = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    this.xur = "</div>";
    this.xus = null;
    this.mode = 20;
    this.xsh = new HashMap();
    this.xqS = ((com.tencent.mm.plugin.qqmail.d.k)g.ad(com.tencent.mm.plugin.qqmail.d.k.class)).getShareModeMailAppService();
    this.xut = null;
    this.xuu = null;
    this.xuv = null;
    this.xuw = "weixin://get_img_info/";
    this.xux = "weixin://get_mail_content/";
    this.xuy = "weixin://img_onclick/";
    this.xuz = false;
    this.xuA = false;
    this.xuB = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(122892);
        ComposeUI.this.enableOptionMenu(ComposeUI.a(ComposeUI.this, true));
        AppMethodBeat.o(122892);
        return true;
      }
    }, true);
    this.xuC = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(122909);
        if ((ComposeUI.this.xul) && (ComposeUI.a(ComposeUI.this, false)) && (ComposeUI.a(ComposeUI.this) == 20))
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
    this.xuD = new m.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(122920);
        ae.i("MicroMsg.Mail.ComposeUI", "sync addr complete");
        MailAddrsViewControl.b localb = new MailAddrsViewControl.b(ComposeUI.this, ComposeUI.d(ComposeUI.this).awl(null));
        ComposeUI.this.xtR.setAddrsAdapter(localb);
        ComposeUI.e(ComposeUI.this).setAddrsAdapter(localb);
        ComposeUI.f(ComposeUI.this).setAddrsAdapter(localb);
        AppMethodBeat.o(122920);
      }
    };
    this.xuE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(218024);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ComposeUI.y(ComposeUI.this).setVisibility(8);
        ComposeUI.z(ComposeUI.this).setVisibility(0);
        ComposeUI.A(ComposeUI.this).setVisibility(0);
        ComposeUI.y(ComposeUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(218023);
            ComposeUI.z(ComposeUI.this).requestFocus();
            ComposeUI.e(ComposeUI.this).dGi();
            ComposeUI.f(ComposeUI.this).dGi();
            AppMethodBeat.o(218023);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(218024);
      }
    };
    this.xuF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122899);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = ComposeUI.this;
        localObject = ComposeUI.this.getString(2131761962);
        String str1 = ComposeUI.this.getString(2131761959);
        String str2 = ComposeUI.this.getString(2131761960);
        h.c local1 = new h.c()
        {
          public final void lh(int paramAnonymous2Int)
          {
            AppMethodBeat.i(218025);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(218025);
              return;
              boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ComposeUI.this.getContext(), "android.permission.CAMERA", 16, "", "");
              ae.i("MicroMsg.Mail.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), ComposeUI.this.getContext() });
              if (!bool)
              {
                AppMethodBeat.o(218025);
                return;
              }
              ComposeUI.B(ComposeUI.this);
              AppMethodBeat.o(218025);
              return;
              com.tencent.mm.pluginsdk.ui.tools.q.c(ComposeUI.this, 4, null);
              AppMethodBeat.o(218025);
              return;
              Intent localIntent = new Intent(ComposeUI.this, FileExplorerUI.class);
              ComposeUI.this.startActivityForResult(localIntent, 5);
            }
          }
        };
        com.tencent.mm.ui.base.h.a(paramAnonymousView, null, new String[] { localObject, str1, str2 }, null, local1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122899);
      }
    };
    this.xuG = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(218028);
        if (((ComposeUI.a(ComposeUI.this, false)) && (ComposeUI.a(ComposeUI.this) == 20)) || (ComposeUI.a(ComposeUI.this) == 21)) {
          com.tencent.mm.ui.base.h.e(ComposeUI.this.getContext(), ComposeUI.this.getString(2131761969), "", ComposeUI.this.getString(2131761971), ComposeUI.this.getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(218027);
              ComposeUI.this.setResult(0);
              ComposeUI.this.finish();
              AppMethodBeat.o(218027);
            }
          }, null);
        }
        for (;;)
        {
          AppMethodBeat.o(218028);
          return true;
          ComposeUI.this.setResult(0);
          ComposeUI.this.finish();
        }
      }
    };
    this.xuH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(218032);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        ComposeUI.this.hideVKB();
        ComposeUI.j(ComposeUI.this).getText();
        ComposeUI.C(ComposeUI.this);
        if (!ComposeUI.this.dFR())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(218032);
          return;
        }
        paramAnonymousView = ComposeUI.p(ComposeUI.this).entrySet().iterator();
        while (paramAnonymousView.hasNext())
        {
          Object localObject2 = (Map.Entry)paramAnonymousView.next();
          localObject1 = ComposeUI.D(ComposeUI.this);
          localObject2 = (String)((Map.Entry)localObject2).getValue();
          ae.i("MicroMsg.Mail.FileUploadHelper", "uploadContentImage path=%s", new Object[] { localObject2 });
          if ((localObject2 != null) && (((String)localObject2).length() != 0) && (!((b)localObject1).xvx.containsKey(localObject2)))
          {
            com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k((String)localObject2);
            if ((localk.exists()) && (localk.isFile()))
            {
              aj localaj = new aj();
              localaj.path = ((String)localObject2);
              localaj.name = localk.getName();
              localaj.size = localk.length();
              localaj.state = 0;
              ((b)localObject1).xvx.put(localObject2, localaj);
              if (localaj.state == 0) {
                localaj.xsF = ((b)localObject1).awr(localaj.path);
              }
            }
          }
        }
        paramAnonymousView = ComposeUI.this;
        localObject1 = ComposeUI.this;
        ComposeUI.this.getString(2131755906);
        ComposeUI.a(paramAnonymousView, com.tencent.mm.ui.base.h.b((Context)localObject1, ComposeUI.this.getString(2131761953), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(218029);
            ComposeUI.D(ComposeUI.this).dGa();
            ComposeUI.D(ComposeUI.this).xvA = null;
            AppMethodBeat.o(218029);
          }
        }));
        if (!ComposeUI.D(ComposeUI.this).dGb())
        {
          ComposeUI.E(ComposeUI.this).setMessage(ComposeUI.this.getString(2131761950));
          ComposeUI.D(ComposeUI.this).xvA = new b.b()
          {
            public final void dFS()
            {
              AppMethodBeat.i(218030);
              ComposeUI.E(ComposeUI.this).setMessage(ComposeUI.this.getString(2131761950));
              AppMethodBeat.o(218030);
            }
            
            public final void onComplete()
            {
              AppMethodBeat.i(218031);
              ComposeUI.b(ComposeUI.this, ComposeUI.q(ComposeUI.this));
              AppMethodBeat.o(218031);
            }
          };
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(218032);
          return;
          ComposeUI.b(ComposeUI.this, ComposeUI.q(ComposeUI.this));
        }
      }
    };
    AppMethodBeat.o(122938);
  }
  
  private static List<com.tencent.mm.plugin.qqmail.d.l> K(String[] paramArrayOfString)
  {
    AppMethodBeat.i(218034);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        com.tencent.mm.plugin.qqmail.d.l locall = m.awm(paramArrayOfString[i]);
        if (locall != null) {
          localArrayList.add(locall);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(218034);
    return localArrayList;
  }
  
  private static void a(MailAddrsViewControl paramMailAddrsViewControl)
  {
    AppMethodBeat.i(122952);
    if (xtP == null)
    {
      AppMethodBeat.o(122952);
      return;
    }
    paramMailAddrsViewControl.setMailAdds(xtP);
    AppMethodBeat.o(122952);
  }
  
  private void awo(final String paramString)
  {
    AppMethodBeat.i(122954);
    final com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(paramString);
    if (!localk.exists())
    {
      AppMethodBeat.o(122954);
      return;
    }
    if (this.xuh.Kh(paramString))
    {
      com.tencent.mm.ui.base.h.l(getContext(), 2131761990, 2131755906);
      AppMethodBeat.o(122954);
      return;
    }
    final int i = (int)localk.length();
    if (i > 20971520)
    {
      com.tencent.mm.ui.base.h.a(this, 2131761991, 2131755906, null);
      AppMethodBeat.o(122954);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(2131761993, new Object[] { bu.sL(i) }), getString(2131755906), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(218033);
        if (ComposeUI.D(ComposeUI.this).getTotalSize() + i > 52428800)
        {
          com.tencent.mm.ui.base.h.a(ComposeUI.this, 2131761992, 2131755906, null);
          AppMethodBeat.o(218033);
          return;
        }
        Object localObject;
        if (ComposeUI.j(ComposeUI.this).getText().toString().trim().length() == 0)
        {
          paramAnonymousDialogInterface = localk.getName().trim();
          paramAnonymousInt = paramAnonymousDialogInterface.lastIndexOf(".");
          localObject = ComposeUI.j(ComposeUI.this);
          if (paramAnonymousInt <= 0) {
            break label173;
          }
        }
        for (;;)
        {
          ((EditText)localObject).setText(paramAnonymousDialogInterface.substring(0, paramAnonymousInt));
          ae.i("MicroMsg.Mail.ComposeUI", "in upload file mode = %d", new Object[] { Integer.valueOf(ComposeUI.a(ComposeUI.this)) });
          paramAnonymousDialogInterface = ComposeUI.D(ComposeUI.this);
          localObject = paramString;
          if ((localObject != null) && (((String)localObject).length() != 0) && (!paramAnonymousDialogInterface.xvx.containsKey(localObject))) {
            break;
          }
          AppMethodBeat.o(218033);
          return;
          label173:
          paramAnonymousInt = paramAnonymousDialogInterface.length();
        }
        com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k((String)localObject);
        if ((!localk.exists()) || (!localk.isFile()))
        {
          AppMethodBeat.o(218033);
          return;
        }
        aj localaj = new aj();
        localaj.path = ((String)localObject);
        localaj.name = localk.getName();
        localaj.size = localk.length();
        localaj.state = 0;
        paramAnonymousDialogInterface.xvx.put(localObject, localaj);
        paramAnonymousDialogInterface.a(localaj);
        AppMethodBeat.o(218033);
      }
    }, null);
    AppMethodBeat.o(122954);
  }
  
  private void cYB()
  {
    AppMethodBeat.i(122947);
    if (!com.tencent.mm.pluginsdk.ui.tools.q.d(this, com.tencent.mm.loader.j.b.asv(), "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
      Toast.makeText(this, getString(2131763022), 1).show();
    }
    AppMethodBeat.o(122947);
  }
  
  private void dFO()
  {
    AppMethodBeat.i(122943);
    this.xtR.clearFocus();
    this.xtV.clearFocus();
    this.xtY.clearFocus();
    AppMethodBeat.o(122943);
  }
  
  private void dFP()
  {
    AppMethodBeat.i(122945);
    if (this.xuf != null)
    {
      this.xuf.clearFocus();
      this.xuf.getSettings().setJavaScriptEnabled(true);
      this.xuf.setWebViewClient(new b((byte)0));
      this.xuf.setWebChromeClient(new a((byte)0));
      this.xuf.setOnTouchListener(new ComposeUI.5(this));
    }
    AppMethodBeat.o(122945);
  }
  
  private String dFQ()
  {
    AppMethodBeat.i(122949);
    Object localObject = new StringBuilder(this.mqR.getText().toString());
    com.tencent.mm.pluginsdk.ui.tools.x.a(this.xuf, this.xux, this.xup);
    if (!bu.isNullOrNil(this.xut))
    {
      int i = this.xut.indexOf(this.xuq);
      int j = this.xut.lastIndexOf(this.xur);
      if ((i == -1) || (j == -1)) {
        break label136;
      }
      String str = this.xut.substring(i + this.xuq.length(), j + this.xur.length());
      ((StringBuilder)localObject).append("\n").append(str);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(122949);
      return localObject;
      label136:
      ((StringBuilder)localObject).append("\n").append(this.xut);
    }
  }
  
  private static ArrayList<Bundle> eZ(List<com.tencent.mm.plugin.qqmail.d.l> paramList)
  {
    AppMethodBeat.i(218035);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.qqmail.d.l locall = (com.tencent.mm.plugin.qqmail.d.l)paramList.next();
      Bundle localBundle = new Bundle();
      localBundle.putString("item_addr", locall.vly);
      localBundle.putString("item_name", locall.name);
      localArrayList.add(localBundle);
    }
    AppMethodBeat.o(218035);
    return localArrayList;
  }
  
  static void fa(List<com.tencent.mm.plugin.qqmail.d.l> paramList)
  {
    xtP = paramList;
  }
  
  protected final boolean dFR()
  {
    AppMethodBeat.i(122951);
    if (!this.xtR.dGh())
    {
      Toast.makeText(this, 2131761976, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (!this.xtV.dGh())
    {
      Toast.makeText(this, 2131761967, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (!this.xtY.dGh())
    {
      Toast.makeText(this, 2131761965, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (this.xtR.getMailAddrs().size() + this.xtV.getMailAddrs().size() + this.xtY.getMailAddrs().size() > 20)
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
    this.xtQ = ((ScrollView)findViewById(2131303594));
    this.xtR = ((MailAddrsViewControl)findViewById(2131303590));
    this.xtS = ((ImageView)findViewById(2131303585));
    this.xtT = ((LinearLayout)findViewById(2131303593));
    this.xtU = ((LinearLayout)findViewById(2131303589));
    this.xtV = ((MailAddrsViewControl)findViewById(2131303588));
    this.xtW = ((ImageView)findViewById(2131303584));
    this.xtX = ((LinearLayout)findViewById(2131303587));
    this.xtY = ((MailAddrsViewControl)findViewById(2131303586));
    this.xtZ = ((ImageView)findViewById(2131303583));
    this.xua = ((EditText)findViewById(2131303598));
    this.xub = ((LinearLayout)findViewById(2131303582));
    this.mqR = ((EditText)findViewById(2131303595));
    this.xuf = MMWebView.a.s(this, 2131303596);
    this.xuc = ((TextView)findViewById(2131303592));
    this.xud = ((ImageView)findViewById(2131303591));
    this.xue = ((LinearLayout)findViewById(2131303319));
    this.xtR.setEditable(true);
    this.xtV.setEditable(true);
    this.xtY.setEditable(true);
    Object localObject2 = getIntent().getStringExtra("mail_content");
    this.xuu = getIntent().getParcelableArrayListExtra("mail_attach");
    this.xuv = getIntent().getStringArrayListExtra("mail_attach_file");
    Object localObject1 = ((com.tencent.mm.plugin.qqmail.d.k)g.ad(com.tencent.mm.plugin.qqmail.d.k.class)).getNormalMailAppService().xrR.eM(this.xuj, this.xrm);
    this.xuh = new b(this, this.xuc, this.xud, this.xue, (byte)0);
    Object localObject3;
    Object localObject4;
    if (!bu.isNullOrNil((String)localObject2)) {
      if (this.mode == 21)
      {
        dFP();
        this.xtR.requestFocus();
        this.xut = String.format(this.xus, new Object[] { localObject2 });
        this.xuf.loadDataWithBaseURL("", this.xut, "text/html", "utf-8", "");
        this.xuf.setVisibility(0);
        if (this.xrm == 1) {
          break label1512;
        }
        localObject1 = getIntent().getStringArrayExtra("toList");
        localObject3 = getIntent().getStringArrayExtra("ccList");
        localObject4 = getIntent().getStringArrayExtra("bccList");
        localObject2 = getIntent().getStringExtra("subject");
        this.xtR.f(K((String[])localObject1), false);
        this.xtV.f(K((String[])localObject3), false);
        this.xtY.f(K((String[])localObject4), false);
        if (!bu.isNullOrNil((String)localObject2))
        {
          localObject3 = this.xua;
          localObject4 = new StringBuilder();
          if (this.xrm != 2) {
            break label1084;
          }
        }
      }
    }
    label1084:
    for (localObject1 = "Re:";; localObject1 = "Fwd:")
    {
      ((EditText)localObject3).setText((String)localObject1 + (String)localObject2);
      if (this.xuu == null) {
        break label1108;
      }
      localObject1 = new ArrayList();
      localObject2 = this.xuu.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Bundle)((Iterator)localObject2).next();
        localObject4 = new aj();
        ((aj)localObject4).name = ((Bundle)localObject3).getString("attach_name");
        StringBuilder localStringBuilder = new StringBuilder();
        ((com.tencent.mm.plugin.qqmail.d.k)g.ad(com.tencent.mm.plugin.qqmail.d.k.class)).getNormalMailAppService();
        ((aj)localObject4).path = (v.getDownloadPath() + ((aj)localObject4).name);
        ((aj)localObject4).state = 2;
        ((aj)localObject4).size = ((Bundle)localObject3).getInt("attach_size");
        ((aj)localObject4).uPr = ((Bundle)localObject3).getString("attach_fileId");
        ((List)localObject1).add(localObject4);
      }
      if (this.mode != 20) {
        break;
      }
      this.mqR.setVisibility(0);
      this.xuf.setVisibility(8);
      if (((String)localObject2).indexOf("<div>") != -1)
      {
        ae.i("MicroMsg.Mail.ComposeUI", "set content in html format");
        this.mqR.setText(Html.fromHtml((String)localObject2));
        break;
      }
      this.mqR.setText((CharSequence)localObject2);
      break;
      if ((localObject1 != null) && (this.mode == 21))
      {
        ae.i("MicroMsg.Mail.ComposeUI", "read mail from draftMail");
        this.xtR.f(((com.tencent.mm.plugin.qqmail.d.i)localObject1).xrn, false);
        this.xtV.f(((com.tencent.mm.plugin.qqmail.d.i)localObject1).xro, false);
        this.xtY.f(((com.tencent.mm.plugin.qqmail.d.i)localObject1).xrp, false);
        this.xua.setText(((com.tencent.mm.plugin.qqmail.d.i)localObject1).xrr);
        localObject2 = ((com.tencent.mm.plugin.qqmail.d.i)localObject1).content;
        this.mode = 20;
        if (((String)localObject2).indexOf("<div>") != -1)
        {
          ae.i("MicroMsg.Mail.ComposeUI", "set content in html format");
          this.mqR.setText(Html.fromHtml((String)localObject2));
        }
        for (;;)
        {
          this.xuh.fb(((com.tencent.mm.plugin.qqmail.d.i)localObject1).xrq);
          this.xuh.dGc();
          this.xuf.setVisibility(8);
          this.mqR.setVisibility(0);
          break;
          this.mqR.setText((CharSequence)localObject2);
        }
      }
      ae.i("MicroMsg.Mail.ComposeUI", "no extra or draf mail content");
      if (this.mode == 21)
      {
        dFP();
        this.xtR.requestFocus();
        this.xut = String.format(this.xus, new Object[] { "" });
        this.xuf.loadDataWithBaseURL("", this.xut, "text/html", "utf-8", "");
        this.mqR.setVisibility(8);
        this.xuf.setVisibility(0);
        break;
      }
      if (this.mode != 20) {
        break;
      }
      this.xuf.setVisibility(8);
      this.mqR.setVisibility(0);
      break;
    }
    if (!((List)localObject1).isEmpty()) {
      this.xuh.fb((List)localObject1);
    }
    for (;;)
    {
      label1108:
      if ((this.xtV.getMailAddrs().size() > 0) || (this.xtY.getMailAddrs().size() > 0))
      {
        this.xtT.setVisibility(8);
        this.xtU.setVisibility(0);
        this.xtX.setVisibility(0);
      }
      if ((this.xrm == 2) && (this.mode != 21) && (this.mode == 20))
      {
        this.mqR.requestFocus();
        this.mqR.setSelection(0);
        this.xtQ.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(122921);
            ComposeUI.g(ComposeUI.this).fullScroll(130);
            AppMethodBeat.o(122921);
          }
        }, 1000L);
      }
      this.xtR.setOnActionListener(new c(this.xtS, 0));
      this.xtV.setOnActionListener(new c(this.xtW, 1));
      this.xtY.setOnActionListener(new c(this.xtZ, 2));
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
              paramAnonymousMailAddrsViewControl.xwa.setText("");
              ComposeUI.i(ComposeUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(122922);
                  ComposeUI.h(ComposeUI.this);
                  ComposeUI.15.1.this.xuO.requestFocus();
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
                  ComposeUI.15.2.this.xuO.requestFocus();
                  ComposeUI.this.showVKB();
                  AppMethodBeat.o(122924);
                }
              }, 150L);
              AppMethodBeat.o(122925);
            }
          });
          AppMethodBeat.o(122926);
        }
        
        public final void dFT()
        {
          AppMethodBeat.i(122927);
          t.a(ComposeUI.this, ComposeUI.this.getString(2131761980), 1500L);
          AppMethodBeat.o(122927);
        }
      };
      this.xtR.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
      this.xtV.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
      this.xtY.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
      this.xtS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122928);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
          paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.xtR.getMailAddrStringArray());
          paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
          paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
          ComposeUI.this.startActivityForResult(paramAnonymousView, 0);
          ComposeUI.this.overridePendingTransition(2130772108, 2130772048);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122928);
        }
      });
      this.xtW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122929);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
          paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.e(ComposeUI.this).getMailAddrStringArray());
          paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
          paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
          ComposeUI.this.startActivityForResult(paramAnonymousView, 1);
          ComposeUI.this.overridePendingTransition(2130772108, 2130772048);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122929);
        }
      });
      this.xtZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122930);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
          paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.f(ComposeUI.this).getMailAddrStringArray());
          paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
          paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
          ComposeUI.this.startActivityForResult(paramAnonymousView, 2);
          ComposeUI.this.overridePendingTransition(2130772108, 2130772048);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122930);
        }
      });
      this.xtT.setOnClickListener(this.xuE);
      localObject1 = (ImageView)findViewById(2131303597);
      if ((this.xum) && (this.xua.getText().length() > 0)) {
        ((ImageView)localObject1).setVisibility(0);
      }
      this.xua.setOnFocusChangeListener(new View.OnFocusChangeListener()
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
      this.xua.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          paramAnonymousInt1 = 4;
          AppMethodBeat.i(122893);
          if (ComposeUI.this.xum)
          {
            paramAnonymousCharSequence = this.xuJ;
            if (ComposeUI.j(ComposeUI.this).getText().length() > 0) {
              paramAnonymousInt1 = 0;
            }
            paramAnonymousCharSequence.setVisibility(paramAnonymousInt1);
            AppMethodBeat.o(122893);
            return;
          }
          this.xuJ.setVisibility(4);
          AppMethodBeat.o(122893);
        }
      });
      ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122894);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ComposeUI.j(ComposeUI.this).getText().clear();
          ComposeUI.j(ComposeUI.this).requestFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122894);
        }
      });
      this.xub.setOnClickListener(this.xuF);
      setMMTitle(2131761974);
      setBackBtn(this.xuG);
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
      enableOptionMenu(false);
      dFO();
      AppMethodBeat.o(122944);
      return;
      label1512:
      localObject1 = getIntent().getStringExtra("subject");
      if (!bu.isNullOrNil((String)localObject1)) {
        this.xua.setText((CharSequence)localObject1);
      }
      if (this.xuv != null)
      {
        localObject1 = this.xuv.iterator();
        while (((Iterator)localObject1).hasNext()) {
          awo((String)((Iterator)localObject1).next());
        }
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
      a(this.xtR);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      a(this.xtV);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      a(this.xtY);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.i(this, paramIntent, com.tencent.mm.plugin.image.d.azQ());
      if (paramIntent != null)
      {
        awo(paramIntent);
        dFO();
        AppMethodBeat.o(122953);
        return;
        if (paramIntent != null)
        {
          paramIntent = com.tencent.mm.ui.tools.a.j(this, paramIntent, com.tencent.mm.plugin.image.d.azQ());
          if ((paramIntent != null) && (paramIntent.length() > 0))
          {
            awo(paramIntent);
            dFO();
            AppMethodBeat.o(122953);
            return;
            if (paramIntent != null)
            {
              awo(paramIntent.getStringExtra("choosed_file_path"));
              dFO();
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
    this.xus = (this.xuq + "%s" + this.xur);
    this.xuz = false;
    this.xuA = false;
    this.xrm = getIntent().getIntExtra("composeType", 1);
    this.xuj = getIntent().getStringExtra("mailid");
    if (this.xuj == null) {
      this.xuj = "";
    }
    this.mode = getIntent().getIntExtra("mail_mode", 20);
    ae.d("MicroMsg.Mail.ComposeUI", "onCreate, mode = %d", new Object[] { Integer.valueOf(this.mode) });
    initView();
    this.xug = ((com.tencent.mm.plugin.qqmail.d.k)g.ad(com.tencent.mm.plugin.qqmail.d.k.class)).getNormalMailAppService().xrQ;
    this.xug.a(this.xuD);
    this.xug.dFy();
    this.xuC.ay(180000L, 180000L);
    g.ajj().a(11166, this);
    AppMethodBeat.o(122939);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122942);
    super.onDestroy();
    if (xtP != null) {
      xtP = null;
    }
    this.xuh.dGa();
    b localb = this.xuh;
    g.ajQ().gDv.b(11665, localb);
    this.xug.b(this.xuD);
    this.xui.release();
    g.ajj().b(11166, this);
    this.xuC.stopTimer();
    AppMethodBeat.o(122942);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(122946);
    if (paramInt == 4)
    {
      this.xuG.onMenuItemClick(null);
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
    this.xuB.stopTimer();
    if (this.xuk != null) {
      this.xuk.dismiss();
    }
    AppMethodBeat.o(122941);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(122948);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.Mail.ComposeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(122948);
      return;
    }
    ae.i("MicroMsg.Mail.ComposeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122948);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cYB();
        AppMethodBeat.o(122948);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new ComposeUI.8(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(122940);
    super.onResume();
    this.xuB.ay(1500L, 1500L);
    AppMethodBeat.o(122940);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(218036);
    ae.i("MicroMsg.Mail.ComposeUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!((com.tencent.mm.plugin.qqmail.e.d)paramn).dyb.equals(this.dyb))
    {
      ae.w("MicroMsg.Mail.ComposeUI", "not current request, ignore");
      AppMethodBeat.o(218036);
      return;
    }
    if (this.jmN != null) {
      this.jmN.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Toast.makeText(this, 2131761954, 1).show();
      paramString = ((com.tencent.mm.plugin.qqmail.d.k)g.ad(com.tencent.mm.plugin.qqmail.d.k.class)).getNormalMailAppService().xrR;
      paramn = this.xuj;
      paramInt1 = this.xrm;
      paramString = new com.tencent.mm.vfs.k(paramString.xrl.xru + com.tencent.mm.plugin.qqmail.d.h.eN(paramn, paramInt1));
      if (paramString.exists()) {
        paramString.delete();
      }
      this.xug.eY(this.xtR.getMailAddrs());
      this.xug.eY(this.xtV.getMailAddrs());
      this.xug.eY(this.xtY.getMailAddrs());
      setResult(-1);
      finish();
      AppMethodBeat.o(218036);
      return;
    }
    paramn = paramString;
    if (bu.isNullOrNil(paramString)) {
      paramn = getString(2131761952);
    }
    Toast.makeText(this, paramn, 1).show();
    AppMethodBeat.o(218036);
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
      ae.i("MicroMsg.Mail.ComposeUI", "console, consoleMessage: %s", new Object[] { paramConsoleMessage });
      if (paramConsoleMessage != null) {}
      Object localObject4;
      Object localObject3;
      for (Object localObject1 = paramConsoleMessage.message();; localObject1 = null)
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.tools.x.aPf((String)localObject1);
        if (!((String)localObject1).startsWith(ComposeUI.l(ComposeUI.this))) {
          break label349;
        }
        ComposeUI.this.hideVKB();
        try
        {
          localObject1 = URLDecoder.decode(((String)localObject1).substring(ComposeUI.l(ComposeUI.this).length()), "utf-8").split("@@");
          localObject4 = localObject1[0].split(":");
          localObject3 = localObject4[0];
          localObject4 = localObject4[1];
          ae.i("MicroMsg.Mail.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[] { localObject1[1], localObject3, localObject4 });
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(Integer.valueOf((String)localObject3).intValue());
          localObject1 = new Intent(ComposeUI.this, MailImageDownloadUI.class);
          ((Intent)localObject1).putExtra("img_msg_id", ((ei)localObject3).field_msgId);
          ((Intent)localObject1).putExtra("img_server_id", ((ei)localObject3).field_msgSvrId);
          ((Intent)localObject1).putExtra("img_download_compress_type", 0);
          ((Intent)localObject1).putExtra("img_download_username", ((ei)localObject3).field_talker);
          localObject3 = ComposeUI.this;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentChromeClient", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ComposeUI)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentChromeClient", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(122932);
          return true;
        }
        catch (Exception localException)
        {
          ae.w("MicroMsg.Mail.ComposeUI", "consoleMessage IMG_ONCLICK, ex = %s", new Object[] { localException.getMessage() });
        }
      }
      label349:
      do
      {
        boolean bool = super.onConsoleMessage(paramConsoleMessage);
        AppMethodBeat.o(122932);
        return bool;
        if (localException.startsWith(ComposeUI.m(ComposeUI.this))) {
          try
          {
            ComposeUI.a(ComposeUI.this, URLDecoder.decode(localException.substring(ComposeUI.m(ComposeUI.this).length()), "utf-8"));
            if (ComposeUI.n(ComposeUI.this)) {
              if (ComposeUI.o(ComposeUI.this).indexOf("<img") == -1)
              {
                ComposeUI.p(ComposeUI.this).clear();
                ComposeUI.q(ComposeUI.this);
                AppMethodBeat.o(122932);
                return true;
              }
            }
          }
          catch (Exception paramConsoleMessage)
          {
            for (;;)
            {
              ae.w("MicroMsg.Mail.ComposeUI", "consoleMessage GET_MAIL_CONTENT, ex = %s", new Object[] { paramConsoleMessage.getMessage() });
            }
            com.tencent.mm.pluginsdk.ui.tools.x.a(ComposeUI.r(ComposeUI.this), ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this));
            AppMethodBeat.o(122932);
            return true;
          }
        }
      } while (!localException.startsWith(ComposeUI.s(ComposeUI.this)));
      ComposeUI.p(ComposeUI.this).clear();
      try
      {
        paramConsoleMessage = URLDecoder.decode(localException.substring(ComposeUI.s(ComposeUI.this).length()), "utf-8");
        localObject3 = paramConsoleMessage.split("&&");
        int i = 0;
        while (i < localObject3.length)
        {
          paramConsoleMessage = localObject3[i].split("@@");
          if (paramConsoleMessage.length >= 2)
          {
            localObject4 = paramConsoleMessage[0];
            Object localObject2 = paramConsoleMessage[1];
            paramConsoleMessage = localObject2;
            if (localObject2.startsWith("file://")) {
              paramConsoleMessage = localObject2.replaceFirst("file://", "");
            }
            ae.i("MicroMsg.Mail.ComposeUI", "put msgImgInfoMap, fileName: %s, path: %s", new Object[] { localObject4, paramConsoleMessage });
            ComposeUI.p(ComposeUI.this).put(localObject4, paramConsoleMessage);
          }
          i += 1;
        }
        if (!ComposeUI.n(ComposeUI.this)) {
          break label704;
        }
      }
      catch (Exception paramConsoleMessage)
      {
        ae.w("MicroMsg.Mail.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", new Object[] { paramConsoleMessage.getMessage() });
        AppMethodBeat.o(122932);
        return true;
      }
      ComposeUI.q(ComposeUI.this);
      label704:
      AppMethodBeat.o(122932);
      return true;
    }
  }
  
  final class b
    extends ac
  {
    private boolean xuS = false;
    
    private b() {}
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(122933);
      ae.d("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading, url = %s", new Object[] { paramString });
      Object localObject1;
      if (paramString.startsWith(ComposeUI.l(ComposeUI.this)))
      {
        ComposeUI.this.hideVKB();
        try
        {
          paramWebView = URLDecoder.decode(paramString.substring(ComposeUI.l(ComposeUI.this).length()), "utf-8").split("@@");
          localObject1 = paramWebView[0].split(":");
          paramString = localObject1[0];
          localObject1 = localObject1[1];
          ae.i("MicroMsg.Mail.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[] { paramWebView[1], paramString, localObject1 });
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(Integer.valueOf(paramString).intValue());
          paramWebView = new Intent(ComposeUI.this, MailImageDownloadUI.class);
          paramWebView.putExtra("img_msg_id", paramString.field_msgId);
          paramWebView.putExtra("img_server_id", paramString.field_msgSvrId);
          paramWebView.putExtra("img_download_compress_type", 0);
          paramWebView.putExtra("img_download_username", paramString.field_talker);
          paramString = ComposeUI.this;
          paramWebView = new com.tencent.mm.hellhoundlib.b.a().bc(paramWebView);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramWebView.ahE(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramWebView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(122933);
          return true;
        }
        catch (Exception paramWebView)
        {
          ae.w("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading IMG_ONCLICK, ex = %s", new Object[] { paramWebView.getMessage() });
        }
      }
      do
      {
        AppMethodBeat.o(122933);
        return true;
        if (paramString.startsWith(ComposeUI.m(ComposeUI.this))) {
          try
          {
            ComposeUI.a(ComposeUI.this, URLDecoder.decode(paramString.substring(ComposeUI.m(ComposeUI.this).length()), "utf-8"));
            if (ComposeUI.n(ComposeUI.this)) {
              if (ComposeUI.o(ComposeUI.this).indexOf("<img") == -1)
              {
                ComposeUI.p(ComposeUI.this).clear();
                ComposeUI.q(ComposeUI.this);
                AppMethodBeat.o(122933);
                return true;
              }
            }
          }
          catch (Exception paramWebView)
          {
            for (;;)
            {
              ae.w("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading GET_MAIL_CONTENT, ex = %s", new Object[] { paramWebView.getMessage() });
            }
            com.tencent.mm.pluginsdk.ui.tools.x.a(ComposeUI.r(ComposeUI.this), ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this));
            AppMethodBeat.o(122933);
            return true;
          }
        }
      } while (!paramString.startsWith(ComposeUI.s(ComposeUI.this)));
      ComposeUI.p(ComposeUI.this).clear();
      try
      {
        paramWebView = URLDecoder.decode(paramString.substring(ComposeUI.s(ComposeUI.this).length()), "utf-8");
        localObject1 = paramWebView.split("&&");
        int i = 0;
        while (i < localObject1.length)
        {
          paramWebView = localObject1[i].split("@@");
          if (paramWebView.length >= 2)
          {
            Object localObject2 = paramWebView[0];
            paramString = paramWebView[1];
            paramWebView = paramString;
            if (paramString.startsWith("file://")) {
              paramWebView = paramString.replaceFirst("file://", "");
            }
            ae.i("MicroMsg.Mail.ComposeUI", "put msgImgInfoMap, fileName: %s, path: %s", new Object[] { localObject2, paramWebView });
            ComposeUI.p(ComposeUI.this).put(localObject2, paramWebView);
          }
          i += 1;
        }
        if (!ComposeUI.n(ComposeUI.this)) {
          break label637;
        }
      }
      catch (Exception paramWebView)
      {
        ae.w("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading GET_IMG_INFO, ex = %s", new Object[] { paramWebView.getMessage() });
        AppMethodBeat.o(122933);
        return true;
      }
      ComposeUI.q(ComposeUI.this);
      label637:
      AppMethodBeat.o(122933);
      return true;
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(122935);
      ae.d("MicroMsg.Mail.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", new Object[] { paramString, Boolean.valueOf(this.xuS) });
      if (!this.xuS)
      {
        this.xuS = true;
        com.tencent.mm.pluginsdk.ui.tools.x.a(ComposeUI.r(ComposeUI.this), ComposeUI.m(ComposeUI.this), ComposeUI.w(ComposeUI.this));
        if (ComposeUI.this.getIntent().getBooleanExtra("mail_edit_mode", false)) {
          com.tencent.mm.pluginsdk.ui.tools.x.a(ComposeUI.r(ComposeUI.this), ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this));
        }
      }
      super.b(paramWebView, paramString);
      AppMethodBeat.o(122935);
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(122934);
      super.b(paramWebView, paramString, paramBitmap);
      if (!ComposeUI.u(ComposeUI.this))
      {
        com.tencent.mm.pluginsdk.ui.tools.x.c(ComposeUI.r(ComposeUI.this));
        ComposeUI.v(ComposeUI.this);
      }
      AppMethodBeat.o(122934);
    }
  }
  
  final class c
    extends MailAddrsViewControl.c
  {
    private int tag;
    private ImageView xuT;
    
    public c(ImageView paramImageView, int paramInt)
    {
      this.xuT = paramImageView;
      this.tag = paramInt;
    }
    
    public final void pH(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(122937);
      ComposeUI.x(ComposeUI.this);
      Object localObject;
      if (ComposeUI.this.xun) {
        localObject = this.xuT;
      }
      for (;;)
      {
        ((ImageView)localObject).setVisibility(i);
        if (((this.tag == 1) || (this.tag == 2)) && (!paramBoolean)) {
          ComposeUI.y(ComposeUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(122936);
              if ((!ComposeUI.e(ComposeUI.this).xwa.isFocused()) && (!ComposeUI.f(ComposeUI.this).xwa.isFocused()) && (ComposeUI.e(ComposeUI.this).getMailAddrs().size() == 0) && (ComposeUI.f(ComposeUI.this).getMailAddrs().size() == 0) && (ComposeUI.e(ComposeUI.this).dGe()) && (ComposeUI.f(ComposeUI.this).dGe()))
              {
                ComposeUI.y(ComposeUI.this).setVisibility(0);
                ComposeUI.z(ComposeUI.this).setVisibility(8);
                ComposeUI.A(ComposeUI.this).setVisibility(8);
              }
              AppMethodBeat.o(122936);
            }
          }, 10L);
        }
        AppMethodBeat.o(122937);
        return;
        ImageView localImageView = this.xuT;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI
 * JD-Core Version:    0.7.0.1
 */