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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.ab;
import com.tencent.mm.plugin.qqmail.d.aj;
import com.tencent.mm.plugin.qqmail.d.j;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.m;
import com.tencent.mm.plugin.qqmail.d.m.a;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.vfs.e;
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
  private static List<com.tencent.mm.plugin.qqmail.d.l> xdY;
  private String dwW;
  private p jjU;
  private EditText mlU;
  private int mode;
  private ab xbb;
  private int xbv;
  private Map<String, String> xcq;
  private ScrollView xdZ;
  private String xeA;
  private String xeB;
  private String xeC;
  private List<Bundle> xeD;
  private String xeE;
  private String xeF;
  private String xeG;
  private boolean xeH;
  private boolean xeI;
  private av xeJ;
  private av xeK;
  m.a xeL;
  private View.OnClickListener xeM;
  private View.OnClickListener xeN;
  private MenuItem.OnMenuItemClickListener xeO;
  private View.OnClickListener xeP;
  protected MailAddrsViewControl xea;
  private ImageView xeb;
  private LinearLayout xec;
  private LinearLayout xed;
  private MailAddrsViewControl xee;
  private ImageView xef;
  private LinearLayout xeg;
  private MailAddrsViewControl xeh;
  private ImageView xei;
  private EditText xej;
  private LinearLayout xek;
  private TextView xel;
  private ImageView xem;
  private LinearLayout xen;
  private MMWebView xeo;
  private m xep;
  private b xeq;
  public c xer;
  private String xes;
  private o xet;
  public boolean xeu;
  public boolean xev;
  public boolean xew;
  private String xex;
  private String xey;
  private String xez;
  
  public ComposeUI()
  {
    AppMethodBeat.i(122938);
    this.xer = new c(this);
    this.xbv = 1;
    this.xeu = true;
    this.xev = true;
    this.xew = false;
    this.xex = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    this.xey = "document.getElementById('history').innerHTML";
    this.xez = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    this.xeA = "</div>";
    this.xeB = null;
    this.mode = 20;
    this.xcq = new HashMap();
    this.xbb = ((k)g.ad(k.class)).getShareModeMailAppService();
    this.xeC = null;
    this.xeD = null;
    this.xeE = "weixin://get_img_info/";
    this.xeF = "weixin://get_mail_content/";
    this.xeG = "weixin://img_onclick/";
    this.xeH = false;
    this.xeI = false;
    this.xeJ = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(122892);
        ComposeUI.this.enableOptionMenu(ComposeUI.a(ComposeUI.this, true));
        AppMethodBeat.o(122892);
        return true;
      }
    }, true);
    this.xeK = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(122909);
        if ((ComposeUI.this.xeu) && (ComposeUI.a(ComposeUI.this, false)) && (ComposeUI.a(ComposeUI.this) == 20))
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
    this.xeL = new m.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(122920);
        ad.i("MicroMsg.Mail.ComposeUI", "sync addr complete");
        MailAddrsViewControl.b localb = new MailAddrsViewControl.b(ComposeUI.this, ComposeUI.d(ComposeUI.this).auW(null));
        ComposeUI.this.xea.setAddrsAdapter(localb);
        ComposeUI.e(ComposeUI.this).setAddrsAdapter(localb);
        ComposeUI.f(ComposeUI.this).setAddrsAdapter(localb);
        AppMethodBeat.o(122920);
      }
    };
    this.xeM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(215278);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ComposeUI.y(ComposeUI.this).setVisibility(8);
        ComposeUI.z(ComposeUI.this).setVisibility(0);
        ComposeUI.A(ComposeUI.this).setVisibility(0);
        ComposeUI.y(ComposeUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215277);
            ComposeUI.z(ComposeUI.this).requestFocus();
            ComposeUI.e(ComposeUI.this).dCR();
            ComposeUI.f(ComposeUI.this).dCR();
            AppMethodBeat.o(215277);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(215278);
      }
    };
    this.xeN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122899);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = ComposeUI.this;
        localObject = ComposeUI.this.getString(2131761962);
        String str1 = ComposeUI.this.getString(2131761959);
        String str2 = ComposeUI.this.getString(2131761960);
        h.c local1 = new h.c()
        {
          public final void lf(int paramAnonymous2Int)
          {
            AppMethodBeat.i(215279);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(215279);
              return;
              boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ComposeUI.this.getContext(), "android.permission.CAMERA", 16, "", "");
              ad.i("MicroMsg.Mail.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), ComposeUI.this.getContext() });
              if (!bool)
              {
                AppMethodBeat.o(215279);
                return;
              }
              ComposeUI.B(ComposeUI.this);
              AppMethodBeat.o(215279);
              return;
              com.tencent.mm.pluginsdk.ui.tools.q.c(ComposeUI.this, 4, null);
              AppMethodBeat.o(215279);
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
    this.xeO = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(215282);
        if (((ComposeUI.a(ComposeUI.this, false)) && (ComposeUI.a(ComposeUI.this) == 20)) || (ComposeUI.a(ComposeUI.this) == 21)) {
          com.tencent.mm.ui.base.h.e(ComposeUI.this.getContext(), ComposeUI.this.getString(2131761969), "", ComposeUI.this.getString(2131761971), ComposeUI.this.getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(215281);
              ComposeUI.this.setResult(0);
              ComposeUI.this.finish();
              AppMethodBeat.o(215281);
            }
          }, null);
        }
        for (;;)
        {
          AppMethodBeat.o(215282);
          return true;
          ComposeUI.this.setResult(0);
          ComposeUI.this.finish();
        }
      }
    };
    this.xeP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(215286);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        ComposeUI.this.hideVKB();
        ComposeUI.j(ComposeUI.this).getText();
        ComposeUI.C(ComposeUI.this);
        if (!ComposeUI.this.dCA())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215286);
          return;
        }
        paramAnonymousView = ComposeUI.p(ComposeUI.this).entrySet().iterator();
        while (paramAnonymousView.hasNext())
        {
          Object localObject2 = (Map.Entry)paramAnonymousView.next();
          localObject1 = ComposeUI.D(ComposeUI.this);
          localObject2 = (String)((Map.Entry)localObject2).getValue();
          ad.i("MicroMsg.Mail.FileUploadHelper", "uploadContentImage path=%s", new Object[] { localObject2 });
          if ((localObject2 != null) && (((String)localObject2).length() != 0) && (!((b)localObject1).xfF.containsKey(localObject2)))
          {
            e locale = new e((String)localObject2);
            if ((locale.exists()) && (locale.isFile()))
            {
              aj localaj = new aj();
              localaj.path = ((String)localObject2);
              localaj.name = locale.getName();
              localaj.size = locale.length();
              localaj.state = 0;
              ((b)localObject1).xfF.put(localObject2, localaj);
              if (localaj.state == 0) {
                localaj.xcO = ((b)localObject1).avc(localaj.path);
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
            AppMethodBeat.i(215283);
            ComposeUI.D(ComposeUI.this).dCJ();
            ComposeUI.D(ComposeUI.this).xfI = null;
            AppMethodBeat.o(215283);
          }
        }));
        if (!ComposeUI.D(ComposeUI.this).dCK())
        {
          ComposeUI.E(ComposeUI.this).setMessage(ComposeUI.this.getString(2131761950));
          ComposeUI.D(ComposeUI.this).xfI = new b.b()
          {
            public final void dCB()
            {
              AppMethodBeat.i(215284);
              ComposeUI.E(ComposeUI.this).setMessage(ComposeUI.this.getString(2131761950));
              AppMethodBeat.o(215284);
            }
            
            public final void onComplete()
            {
              AppMethodBeat.i(215285);
              ComposeUI.b(ComposeUI.this, ComposeUI.q(ComposeUI.this));
              AppMethodBeat.o(215285);
            }
          };
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215286);
          return;
          ComposeUI.b(ComposeUI.this, ComposeUI.q(ComposeUI.this));
        }
      }
    };
    AppMethodBeat.o(122938);
  }
  
  private static List<com.tencent.mm.plugin.qqmail.d.l> K(String[] paramArrayOfString)
  {
    AppMethodBeat.i(215288);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        com.tencent.mm.plugin.qqmail.d.l locall = m.auX(paramArrayOfString[i]);
        if (locall != null) {
          localArrayList.add(locall);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(215288);
    return localArrayList;
  }
  
  private static void a(MailAddrsViewControl paramMailAddrsViewControl)
  {
    AppMethodBeat.i(122952);
    if (xdY == null)
    {
      AppMethodBeat.o(122952);
      return;
    }
    paramMailAddrsViewControl.setMailAdds(xdY);
    AppMethodBeat.o(122952);
  }
  
  private void auZ(final String paramString)
  {
    AppMethodBeat.i(122954);
    final e locale = new e(paramString);
    if (!locale.exists())
    {
      AppMethodBeat.o(122954);
      return;
    }
    if (this.xeq.JI(paramString))
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
    com.tencent.mm.ui.base.h.a(this, getString(2131761993, new Object[] { bt.sy(i) }), getString(2131755906), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(215287);
        if (ComposeUI.D(ComposeUI.this).getTotalSize() + i > 52428800)
        {
          com.tencent.mm.ui.base.h.a(ComposeUI.this, 2131761992, 2131755906, null);
          AppMethodBeat.o(215287);
          return;
        }
        Object localObject;
        if (ComposeUI.j(ComposeUI.this).getText().toString().trim().length() == 0)
        {
          paramAnonymousDialogInterface = locale.getName().trim();
          paramAnonymousInt = paramAnonymousDialogInterface.lastIndexOf(".");
          localObject = ComposeUI.j(ComposeUI.this);
          if (paramAnonymousInt <= 0) {
            break label173;
          }
        }
        for (;;)
        {
          ((EditText)localObject).setText(paramAnonymousDialogInterface.substring(0, paramAnonymousInt));
          ad.i("MicroMsg.Mail.ComposeUI", "in upload file mode = %d", new Object[] { Integer.valueOf(ComposeUI.a(ComposeUI.this)) });
          paramAnonymousDialogInterface = ComposeUI.D(ComposeUI.this);
          localObject = paramString;
          if ((localObject != null) && (((String)localObject).length() != 0) && (!paramAnonymousDialogInterface.xfF.containsKey(localObject))) {
            break;
          }
          AppMethodBeat.o(215287);
          return;
          label173:
          paramAnonymousInt = paramAnonymousDialogInterface.length();
        }
        e locale = new e((String)localObject);
        if ((!locale.exists()) || (!locale.isFile()))
        {
          AppMethodBeat.o(215287);
          return;
        }
        aj localaj = new aj();
        localaj.path = ((String)localObject);
        localaj.name = locale.getName();
        localaj.size = locale.length();
        localaj.state = 0;
        paramAnonymousDialogInterface.xfF.put(localObject, localaj);
        paramAnonymousDialogInterface.a(localaj);
        AppMethodBeat.o(215287);
      }
    }, null);
    AppMethodBeat.o(122954);
  }
  
  private void cVW()
  {
    AppMethodBeat.i(122947);
    if (!com.tencent.mm.pluginsdk.ui.tools.q.d(this, com.tencent.mm.loader.j.b.asg(), "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
      Toast.makeText(this, getString(2131763022), 1).show();
    }
    AppMethodBeat.o(122947);
  }
  
  private void dCx()
  {
    AppMethodBeat.i(122943);
    this.xea.clearFocus();
    this.xee.clearFocus();
    this.xeh.clearFocus();
    AppMethodBeat.o(122943);
  }
  
  private void dCy()
  {
    AppMethodBeat.i(122945);
    if (this.xeo != null)
    {
      this.xeo.clearFocus();
      this.xeo.getSettings().setJavaScriptEnabled(true);
      this.xeo.setWebViewClient(new b((byte)0));
      this.xeo.setWebChromeClient(new a((byte)0));
      this.xeo.setOnTouchListener(new ComposeUI.5(this));
    }
    AppMethodBeat.o(122945);
  }
  
  private String dCz()
  {
    AppMethodBeat.i(122949);
    Object localObject = new StringBuilder(this.mlU.getText().toString());
    com.tencent.mm.pluginsdk.ui.tools.x.a(this.xeo, this.xeF, this.xey);
    if (!bt.isNullOrNil(this.xeC))
    {
      int i = this.xeC.indexOf(this.xez);
      int j = this.xeC.lastIndexOf(this.xeA);
      if ((i == -1) || (j == -1)) {
        break label136;
      }
      String str = this.xeC.substring(i + this.xez.length(), j + this.xeA.length());
      ((StringBuilder)localObject).append("\n").append(str);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(122949);
      return localObject;
      label136:
      ((StringBuilder)localObject).append("\n").append(this.xeC);
    }
  }
  
  private static ArrayList<Bundle> eR(List<com.tencent.mm.plugin.qqmail.d.l> paramList)
  {
    AppMethodBeat.i(215289);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.qqmail.d.l locall = (com.tencent.mm.plugin.qqmail.d.l)paramList.next();
      Bundle localBundle = new Bundle();
      localBundle.putString("item_addr", locall.uZn);
      localBundle.putString("item_name", locall.name);
      localArrayList.add(localBundle);
    }
    AppMethodBeat.o(215289);
    return localArrayList;
  }
  
  static void eS(List<com.tencent.mm.plugin.qqmail.d.l> paramList)
  {
    xdY = paramList;
  }
  
  protected final boolean dCA()
  {
    AppMethodBeat.i(122951);
    if (!this.xea.dCQ())
    {
      Toast.makeText(this, 2131761976, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (!this.xee.dCQ())
    {
      Toast.makeText(this, 2131761967, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (!this.xeh.dCQ())
    {
      Toast.makeText(this, 2131761965, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (this.xea.getMailAddrs().size() + this.xee.getMailAddrs().size() + this.xeh.getMailAddrs().size() > 20)
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
    this.xdZ = ((ScrollView)findViewById(2131303594));
    this.xea = ((MailAddrsViewControl)findViewById(2131303590));
    this.xeb = ((ImageView)findViewById(2131303585));
    this.xec = ((LinearLayout)findViewById(2131303593));
    this.xed = ((LinearLayout)findViewById(2131303589));
    this.xee = ((MailAddrsViewControl)findViewById(2131303588));
    this.xef = ((ImageView)findViewById(2131303584));
    this.xeg = ((LinearLayout)findViewById(2131303587));
    this.xeh = ((MailAddrsViewControl)findViewById(2131303586));
    this.xei = ((ImageView)findViewById(2131303583));
    this.xej = ((EditText)findViewById(2131303598));
    this.xek = ((LinearLayout)findViewById(2131303582));
    this.mlU = ((EditText)findViewById(2131303595));
    this.xeo = MMWebView.a.s(this, 2131303596);
    this.xel = ((TextView)findViewById(2131303592));
    this.xem = ((ImageView)findViewById(2131303591));
    this.xen = ((LinearLayout)findViewById(2131303319));
    this.xea.setEditable(true);
    this.xee.setEditable(true);
    this.xeh.setEditable(true);
    Object localObject2 = getIntent().getStringExtra("mail_content");
    this.xeD = getIntent().getParcelableArrayListExtra("mail_attach");
    Object localObject1 = ((k)g.ad(k.class)).getNormalMailAppService().xca.eE(this.xes, this.xbv);
    this.xeq = new b(this, this.xel, this.xem, this.xen, (byte)0);
    Object localObject3;
    Object localObject4;
    if (!bt.isNullOrNil((String)localObject2)) {
      if (this.mode == 21)
      {
        dCy();
        this.xea.requestFocus();
        this.xeC = String.format(this.xeB, new Object[] { localObject2 });
        this.xeo.loadDataWithBaseURL("", this.xeC, "text/html", "utf-8", "");
        this.xeo.setVisibility(0);
        if (this.xbv == 1) {
          break label1498;
        }
        localObject1 = getIntent().getStringArrayExtra("toList");
        localObject3 = getIntent().getStringArrayExtra("ccList");
        localObject4 = getIntent().getStringArrayExtra("bccList");
        localObject2 = getIntent().getStringExtra("subject");
        this.xea.f(K((String[])localObject1), false);
        this.xee.f(K((String[])localObject3), false);
        this.xeh.f(K((String[])localObject4), false);
        if (!bt.isNullOrNil((String)localObject2))
        {
          localObject3 = this.xej;
          localObject4 = new StringBuilder();
          if (this.xbv != 2) {
            break label1070;
          }
        }
      }
    }
    label1070:
    for (localObject1 = "Re:";; localObject1 = "Fwd:")
    {
      ((EditText)localObject3).setText((String)localObject1 + (String)localObject2);
      if (this.xeD == null) {
        break label1094;
      }
      localObject1 = new ArrayList();
      localObject2 = this.xeD.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Bundle)((Iterator)localObject2).next();
        localObject4 = new aj();
        ((aj)localObject4).name = ((Bundle)localObject3).getString("attach_name");
        StringBuilder localStringBuilder = new StringBuilder();
        ((k)g.ad(k.class)).getNormalMailAppService();
        ((aj)localObject4).path = (v.getDownloadPath() + ((aj)localObject4).name);
        ((aj)localObject4).state = 2;
        ((aj)localObject4).size = ((Bundle)localObject3).getInt("attach_size");
        ((aj)localObject4).uDM = ((Bundle)localObject3).getString("attach_fileId");
        ((List)localObject1).add(localObject4);
      }
      if (this.mode != 20) {
        break;
      }
      this.mlU.setVisibility(0);
      this.xeo.setVisibility(8);
      if (((String)localObject2).indexOf("<div>") != -1)
      {
        ad.i("MicroMsg.Mail.ComposeUI", "set content in html format");
        this.mlU.setText(Html.fromHtml((String)localObject2));
        break;
      }
      this.mlU.setText((CharSequence)localObject2);
      break;
      if ((localObject1 != null) && (this.mode == 21))
      {
        ad.i("MicroMsg.Mail.ComposeUI", "read mail from draftMail");
        this.xea.f(((com.tencent.mm.plugin.qqmail.d.i)localObject1).xbw, false);
        this.xee.f(((com.tencent.mm.plugin.qqmail.d.i)localObject1).xbx, false);
        this.xeh.f(((com.tencent.mm.plugin.qqmail.d.i)localObject1).xby, false);
        this.xej.setText(((com.tencent.mm.plugin.qqmail.d.i)localObject1).xbA);
        localObject2 = ((com.tencent.mm.plugin.qqmail.d.i)localObject1).content;
        this.mode = 20;
        if (((String)localObject2).indexOf("<div>") != -1)
        {
          ad.i("MicroMsg.Mail.ComposeUI", "set content in html format");
          this.mlU.setText(Html.fromHtml((String)localObject2));
        }
        for (;;)
        {
          this.xeq.eT(((com.tencent.mm.plugin.qqmail.d.i)localObject1).xbz);
          this.xeq.dCL();
          this.xeo.setVisibility(8);
          this.mlU.setVisibility(0);
          break;
          this.mlU.setText((CharSequence)localObject2);
        }
      }
      ad.i("MicroMsg.Mail.ComposeUI", "no extra or draf mail content");
      if (this.mode == 21)
      {
        dCy();
        this.xea.requestFocus();
        this.xeC = String.format(this.xeB, new Object[] { "" });
        this.xeo.loadDataWithBaseURL("", this.xeC, "text/html", "utf-8", "");
        this.mlU.setVisibility(8);
        this.xeo.setVisibility(0);
        break;
      }
      if (this.mode != 20) {
        break;
      }
      this.xeo.setVisibility(8);
      this.mlU.setVisibility(0);
      break;
    }
    if (!((List)localObject1).isEmpty()) {
      this.xeq.eT((List)localObject1);
    }
    for (;;)
    {
      label1094:
      if ((this.xee.getMailAddrs().size() > 0) || (this.xeh.getMailAddrs().size() > 0))
      {
        this.xec.setVisibility(8);
        this.xed.setVisibility(0);
        this.xeg.setVisibility(0);
      }
      if ((this.xbv == 2) && (this.mode != 21) && (this.mode == 20))
      {
        this.mlU.requestFocus();
        this.mlU.setSelection(0);
        this.xdZ.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(122921);
            ComposeUI.g(ComposeUI.this).fullScroll(130);
            AppMethodBeat.o(122921);
          }
        }, 1000L);
      }
      this.xea.setOnActionListener(new c(this.xeb, 0));
      this.xee.setOnActionListener(new c(this.xef, 1));
      this.xeh.setOnActionListener(new c(this.xei, 2));
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
              paramAnonymousMailAddrsViewControl.xgi.setText("");
              ComposeUI.i(ComposeUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(122922);
                  ComposeUI.h(ComposeUI.this);
                  ComposeUI.15.1.this.xeW.requestFocus();
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
                  ComposeUI.15.2.this.xeW.requestFocus();
                  ComposeUI.this.showVKB();
                  AppMethodBeat.o(122924);
                }
              }, 150L);
              AppMethodBeat.o(122925);
            }
          });
          AppMethodBeat.o(122926);
        }
        
        public final void dCC()
        {
          AppMethodBeat.i(122927);
          t.a(ComposeUI.this, ComposeUI.this.getString(2131761980), 1500L);
          AppMethodBeat.o(122927);
        }
      };
      this.xea.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
      this.xee.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
      this.xeh.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
      this.xeb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122928);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
          paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.xea.getMailAddrStringArray());
          paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
          paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
          ComposeUI.this.startActivityForResult(paramAnonymousView, 0);
          ComposeUI.this.overridePendingTransition(2130772108, 2130772048);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122928);
        }
      });
      this.xef.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122929);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
      this.xei.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122930);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
      this.xec.setOnClickListener(this.xeM);
      localObject1 = (ImageView)findViewById(2131303597);
      if ((this.xev) && (this.xej.getText().length() > 0)) {
        ((ImageView)localObject1).setVisibility(0);
      }
      this.xej.setOnFocusChangeListener(new View.OnFocusChangeListener()
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
      this.xej.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          paramAnonymousInt1 = 4;
          AppMethodBeat.i(122893);
          if (ComposeUI.this.xev)
          {
            paramAnonymousCharSequence = this.xeR;
            if (ComposeUI.j(ComposeUI.this).getText().length() > 0) {
              paramAnonymousInt1 = 0;
            }
            paramAnonymousCharSequence.setVisibility(paramAnonymousInt1);
            AppMethodBeat.o(122893);
            return;
          }
          this.xeR.setVisibility(4);
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ComposeUI.j(ComposeUI.this).getText().clear();
          ComposeUI.j(ComposeUI.this).requestFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122894);
        }
      });
      this.xek.setOnClickListener(this.xeN);
      setMMTitle(2131761974);
      setBackBtn(this.xeO);
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
      dCx();
      AppMethodBeat.o(122944);
      return;
      label1498:
      localObject1 = getIntent().getStringExtra("subject");
      if (!bt.isNullOrNil((String)localObject1)) {
        this.xej.setText((CharSequence)localObject1);
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
      a(this.xea);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      a(this.xee);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      a(this.xeh);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.i(this, paramIntent, com.tencent.mm.plugin.image.d.azA());
      if (paramIntent != null)
      {
        auZ(paramIntent);
        dCx();
        AppMethodBeat.o(122953);
        return;
        if (paramIntent != null)
        {
          paramIntent = com.tencent.mm.ui.tools.a.j(this, paramIntent, com.tencent.mm.plugin.image.d.azA());
          if ((paramIntent != null) && (paramIntent.length() > 0))
          {
            auZ(paramIntent);
            dCx();
            AppMethodBeat.o(122953);
            return;
            if (paramIntent != null)
            {
              auZ(paramIntent.getStringExtra("choosed_file_path"));
              dCx();
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
    this.xeB = (this.xez + "%s" + this.xeA);
    this.xeH = false;
    this.xeI = false;
    this.xbv = getIntent().getIntExtra("composeType", 1);
    this.xes = getIntent().getStringExtra("mailid");
    if (this.xes == null) {
      this.xes = "";
    }
    this.mode = getIntent().getIntExtra("mail_mode", 20);
    ad.d("MicroMsg.Mail.ComposeUI", "onCreate, mode = %d", new Object[] { Integer.valueOf(this.mode) });
    initView();
    this.xep = ((k)g.ad(k.class)).getNormalMailAppService().xbZ;
    this.xep.a(this.xeL);
    this.xep.dCh();
    this.xeK.az(180000L, 180000L);
    g.aiU().a(11166, this);
    AppMethodBeat.o(122939);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122942);
    super.onDestroy();
    if (xdY != null) {
      xdY = null;
    }
    this.xeq.dCJ();
    b localb = this.xeq;
    g.ajB().gAO.b(11665, localb);
    this.xep.b(this.xeL);
    this.xer.release();
    g.aiU().b(11166, this);
    this.xeK.stopTimer();
    AppMethodBeat.o(122942);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(122946);
    if (paramInt == 4)
    {
      this.xeO.onMenuItemClick(null);
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
    this.xeJ.stopTimer();
    if (this.xet != null) {
      this.xet.dismiss();
    }
    AppMethodBeat.o(122941);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(122948);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.Mail.ComposeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(122948);
      return;
    }
    ad.i("MicroMsg.Mail.ComposeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122948);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cVW();
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
    this.xeJ.az(1500L, 1500L);
    AppMethodBeat.o(122940);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(215290);
    ad.i("MicroMsg.Mail.ComposeUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!((com.tencent.mm.plugin.qqmail.e.d)paramn).dwW.equals(this.dwW))
    {
      ad.w("MicroMsg.Mail.ComposeUI", "not current request, ignore");
      AppMethodBeat.o(215290);
      return;
    }
    if (this.jjU != null) {
      this.jjU.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Toast.makeText(this, 2131761954, 1).show();
      paramString = ((k)g.ad(k.class)).getNormalMailAppService().xca;
      paramn = this.xes;
      paramInt1 = this.xbv;
      paramString = new e(paramString.xbu.xbD + com.tencent.mm.plugin.qqmail.d.h.eF(paramn, paramInt1));
      if (paramString.exists()) {
        paramString.delete();
      }
      this.xep.eQ(this.xea.getMailAddrs());
      this.xep.eQ(this.xee.getMailAddrs());
      this.xep.eQ(this.xeh.getMailAddrs());
      setResult(-1);
      finish();
      AppMethodBeat.o(215290);
      return;
    }
    paramn = paramString;
    if (bt.isNullOrNil(paramString)) {
      paramn = getString(2131761952);
    }
    Toast.makeText(this, paramn, 1).show();
    AppMethodBeat.o(215290);
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
      ad.i("MicroMsg.Mail.ComposeUI", "console, consoleMessage: %s", new Object[] { paramConsoleMessage });
      if (paramConsoleMessage != null) {}
      Object localObject4;
      Object localObject3;
      for (Object localObject1 = paramConsoleMessage.message();; localObject1 = null)
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.tools.x.aNI((String)localObject1);
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
          ad.i("MicroMsg.Mail.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[] { localObject1[1], localObject3, localObject4 });
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(Integer.valueOf((String)localObject3).intValue());
          localObject1 = new Intent(ComposeUI.this, MailImageDownloadUI.class);
          ((Intent)localObject1).putExtra("img_msg_id", ((ei)localObject3).field_msgId);
          ((Intent)localObject1).putExtra("img_server_id", ((ei)localObject3).field_msgSvrId);
          ((Intent)localObject1).putExtra("img_download_compress_type", 0);
          ((Intent)localObject1).putExtra("img_download_username", ((ei)localObject3).field_talker);
          localObject3 = ComposeUI.this;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentChromeClient", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ComposeUI)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentChromeClient", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(122932);
          return true;
        }
        catch (Exception localException)
        {
          ad.w("MicroMsg.Mail.ComposeUI", "consoleMessage IMG_ONCLICK, ex = %s", new Object[] { localException.getMessage() });
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
              ad.w("MicroMsg.Mail.ComposeUI", "consoleMessage GET_MAIL_CONTENT, ex = %s", new Object[] { paramConsoleMessage.getMessage() });
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
            ad.i("MicroMsg.Mail.ComposeUI", "put msgImgInfoMap, fileName: %s, path: %s", new Object[] { localObject4, paramConsoleMessage });
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
        ad.w("MicroMsg.Mail.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", new Object[] { paramConsoleMessage.getMessage() });
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
    private boolean xfa = false;
    
    private b() {}
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(122933);
      ad.d("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading, url = %s", new Object[] { paramString });
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
          ad.i("MicroMsg.Mail.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[] { paramWebView[1], paramString, localObject1 });
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(Integer.valueOf(paramString).intValue());
          paramWebView = new Intent(ComposeUI.this, MailImageDownloadUI.class);
          paramWebView.putExtra("img_msg_id", paramString.field_msgId);
          paramWebView.putExtra("img_server_id", paramString.field_msgSvrId);
          paramWebView.putExtra("img_download_compress_type", 0);
          paramWebView.putExtra("img_download_username", paramString.field_talker);
          paramString = ComposeUI.this;
          paramWebView = new com.tencent.mm.hellhoundlib.b.a().bc(paramWebView);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramWebView.ahp(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramWebView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(122933);
          return true;
        }
        catch (Exception paramWebView)
        {
          ad.w("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading IMG_ONCLICK, ex = %s", new Object[] { paramWebView.getMessage() });
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
              ad.w("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading GET_MAIL_CONTENT, ex = %s", new Object[] { paramWebView.getMessage() });
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
            ad.i("MicroMsg.Mail.ComposeUI", "put msgImgInfoMap, fileName: %s, path: %s", new Object[] { localObject2, paramWebView });
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
        ad.w("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading GET_IMG_INFO, ex = %s", new Object[] { paramWebView.getMessage() });
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
      ad.d("MicroMsg.Mail.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", new Object[] { paramString, Boolean.valueOf(this.xfa) });
      if (!this.xfa)
      {
        this.xfa = true;
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
    private ImageView xfb;
    
    public c(ImageView paramImageView, int paramInt)
    {
      this.xfb = paramImageView;
      this.tag = paramInt;
    }
    
    public final void pz(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(122937);
      ComposeUI.x(ComposeUI.this);
      Object localObject;
      if (ComposeUI.this.xew) {
        localObject = this.xfb;
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
              if ((!ComposeUI.e(ComposeUI.this).xgi.isFocused()) && (!ComposeUI.f(ComposeUI.this).xgi.isFocused()) && (ComposeUI.e(ComposeUI.this).getMailAddrs().size() == 0) && (ComposeUI.f(ComposeUI.this).getMailAddrs().size() == 0) && (ComposeUI.e(ComposeUI.this).dCN()) && (ComposeUI.f(ComposeUI.this).dCN()))
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
        ImageView localImageView = this.xfb;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI
 * JD-Core Version:    0.7.0.1
 */