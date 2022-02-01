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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.webkit.ConsoleMessage;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.ab;
import com.tencent.mm.plugin.qqmail.d.aj;
import com.tencent.mm.plugin.qqmail.d.j;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.m;
import com.tencent.mm.plugin.qqmail.d.m.a;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.x;
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
  implements com.tencent.mm.ak.i
{
  private static List<com.tencent.mm.plugin.qqmail.d.l> BtS;
  private ab BqV;
  private int Brp;
  private Map<String, String> Bsl;
  private ScrollView BtT;
  protected MailAddrsViewControl BtU;
  private ImageView BtV;
  private LinearLayout BtW;
  private LinearLayout BtX;
  private MailAddrsViewControl BtY;
  private ImageView BtZ;
  private String BuA;
  private String BuB;
  private boolean BuC;
  private boolean BuD;
  private MTimerHandler BuE;
  private MTimerHandler BuF;
  m.a BuG;
  private View.OnClickListener BuH;
  private View.OnClickListener BuI;
  private MenuItem.OnMenuItemClickListener BuJ;
  private View.OnClickListener BuK;
  private LinearLayout Bua;
  private MailAddrsViewControl Bub;
  private ImageView Buc;
  private EditText Bud;
  private LinearLayout Bue;
  private TextView Buf;
  private ImageView Bug;
  private LinearLayout Buh;
  private MMWebView Bui;
  private m Buj;
  private b Buk;
  public c Bul;
  private String Bum;
  private p Bun;
  public boolean Buo;
  public boolean Bup;
  public boolean Buq;
  private String Bur;
  private String Bus;
  private String But;
  private String Buu;
  private String Buv;
  private String Buw;
  private List<Bundle> Bux;
  private List<String> Buy;
  private String Buz;
  private String dPI;
  private com.tencent.mm.ui.base.q kkW;
  private int mode;
  private EditText nBD;
  
  public ComposeUI()
  {
    AppMethodBeat.i(122938);
    this.Bul = new c(this);
    this.Brp = 1;
    this.Buo = true;
    this.Bup = true;
    this.Buq = false;
    this.Bur = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    this.Bus = "document.getElementById('history').innerHTML";
    this.But = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    this.Buu = "</div>";
    this.Buv = null;
    this.mode = 20;
    this.Bsl = new HashMap();
    this.BqV = ((k)g.ah(k.class)).getShareModeMailAppService();
    this.Buw = null;
    this.Bux = null;
    this.Buy = null;
    this.Buz = "weixin://get_img_info/";
    this.BuA = "weixin://get_mail_content/";
    this.BuB = "weixin://img_onclick/";
    this.BuC = false;
    this.BuD = false;
    this.BuE = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(122892);
        ComposeUI.this.enableOptionMenu(ComposeUI.a(ComposeUI.this, true));
        AppMethodBeat.o(122892);
        return true;
      }
    }, true);
    this.BuF = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(122909);
        if ((ComposeUI.this.Buo) && (ComposeUI.a(ComposeUI.this, false)) && (ComposeUI.a(ComposeUI.this) == 20))
        {
          ComposeUI.b(ComposeUI.this);
          if (ComposeUI.c(ComposeUI.this) != null) {
            ComposeUI.c(ComposeUI.this).dismiss();
          }
          ComposeUI.a(ComposeUI.this, u.a(ComposeUI.this, ComposeUI.this.getString(2131763969), 2000L));
        }
        AppMethodBeat.o(122909);
        return true;
      }
    }, true);
    this.BuG = new m.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(122920);
        Log.i("MicroMsg.Mail.ComposeUI", "sync addr complete");
        MailAddrsViewControl.b localb = new MailAddrsViewControl.b(ComposeUI.this, ComposeUI.d(ComposeUI.this).aKD(null));
        ComposeUI.this.BtU.setAddrsAdapter(localb);
        ComposeUI.e(ComposeUI.this).setAddrsAdapter(localb);
        ComposeUI.f(ComposeUI.this).setAddrsAdapter(localb);
        AppMethodBeat.o(122920);
      }
    };
    this.BuH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198680);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ComposeUI.y(ComposeUI.this).setVisibility(8);
        ComposeUI.z(ComposeUI.this).setVisibility(0);
        ComposeUI.A(ComposeUI.this).setVisibility(0);
        ComposeUI.y(ComposeUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198679);
            ComposeUI.z(ComposeUI.this).requestFocus();
            ComposeUI.e(ComposeUI.this).eGW();
            ComposeUI.f(ComposeUI.this).eGW();
            AppMethodBeat.o(198679);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198680);
      }
    };
    this.BuI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122899);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = ComposeUI.this;
        localObject = ComposeUI.this.getString(2131763968);
        String str1 = ComposeUI.this.getString(2131763965);
        String str2 = ComposeUI.this.getString(2131763966);
        h.d local1 = new h.d()
        {
          public final void oj(int paramAnonymous2Int)
          {
            AppMethodBeat.i(198681);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(198681);
              return;
              boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ComposeUI.this.getContext(), "android.permission.CAMERA", 16, "", "");
              Log.i("MicroMsg.Mail.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), ComposeUI.this.getContext() });
              if (!bool)
              {
                AppMethodBeat.o(198681);
                return;
              }
              ComposeUI.B(ComposeUI.this);
              AppMethodBeat.o(198681);
              return;
              s.c(ComposeUI.this, 4, null);
              AppMethodBeat.o(198681);
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
    this.BuJ = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(198684);
        if (((ComposeUI.a(ComposeUI.this, false)) && (ComposeUI.a(ComposeUI.this) == 20)) || (ComposeUI.a(ComposeUI.this) == 21)) {
          com.tencent.mm.ui.base.h.c(ComposeUI.this.getContext(), ComposeUI.this.getString(2131763975), "", ComposeUI.this.getString(2131763977), ComposeUI.this.getString(2131755761), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(198683);
              ComposeUI.this.setResult(0);
              ComposeUI.this.finish();
              AppMethodBeat.o(198683);
            }
          }, null);
        }
        for (;;)
        {
          AppMethodBeat.o(198684);
          return true;
          ComposeUI.this.setResult(0);
          ComposeUI.this.finish();
        }
      }
    };
    this.BuK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198688);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        ComposeUI.this.hideVKB();
        ComposeUI.j(ComposeUI.this).getText();
        ComposeUI.C(ComposeUI.this);
        if (!ComposeUI.this.eGF())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198688);
          return;
        }
        paramAnonymousView = ComposeUI.p(ComposeUI.this).entrySet().iterator();
        while (paramAnonymousView.hasNext())
        {
          Object localObject2 = (Map.Entry)paramAnonymousView.next();
          localObject1 = ComposeUI.D(ComposeUI.this);
          localObject2 = (String)((Map.Entry)localObject2).getValue();
          Log.i("MicroMsg.Mail.FileUploadHelper", "uploadContentImage path=%s", new Object[] { localObject2 });
          if ((localObject2 != null) && (((String)localObject2).length() != 0) && (!((b)localObject1).Bvz.containsKey(localObject2)))
          {
            o localo = new o((String)localObject2);
            if ((localo.exists()) && (localo.isFile()))
            {
              aj localaj = new aj();
              localaj.path = ((String)localObject2);
              localaj.name = localo.getName();
              localaj.size = localo.length();
              localaj.state = 0;
              ((b)localObject1).Bvz.put(localObject2, localaj);
              if (localaj.state == 0) {
                localaj.ulj = ((b)localObject1).aKJ(localaj.path);
              }
            }
          }
        }
        paramAnonymousView = ComposeUI.this;
        localObject1 = ComposeUI.this;
        ComposeUI.this.getString(2131755998);
        ComposeUI.a(paramAnonymousView, com.tencent.mm.ui.base.h.a((Context)localObject1, ComposeUI.this.getString(2131763959), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(198685);
            ComposeUI.D(ComposeUI.this).eGO();
            ComposeUI.D(ComposeUI.this).BvC = null;
            AppMethodBeat.o(198685);
          }
        }));
        if (!ComposeUI.D(ComposeUI.this).eGP())
        {
          ComposeUI.E(ComposeUI.this).setMessage(ComposeUI.this.getString(2131763956));
          ComposeUI.D(ComposeUI.this).BvC = new b.b()
          {
            public final void eGG()
            {
              AppMethodBeat.i(198686);
              ComposeUI.E(ComposeUI.this).setMessage(ComposeUI.this.getString(2131763956));
              AppMethodBeat.o(198686);
            }
            
            public final void onComplete()
            {
              AppMethodBeat.i(198687);
              ComposeUI.b(ComposeUI.this, ComposeUI.q(ComposeUI.this));
              AppMethodBeat.o(198687);
            }
          };
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198688);
          return;
          ComposeUI.b(ComposeUI.this, ComposeUI.q(ComposeUI.this));
        }
      }
    };
    AppMethodBeat.o(122938);
  }
  
  private static List<com.tencent.mm.plugin.qqmail.d.l> M(String[] paramArrayOfString)
  {
    AppMethodBeat.i(198690);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        com.tencent.mm.plugin.qqmail.d.l locall = m.aKE(paramArrayOfString[i]);
        if (locall != null) {
          localArrayList.add(locall);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(198690);
    return localArrayList;
  }
  
  private static void a(MailAddrsViewControl paramMailAddrsViewControl)
  {
    AppMethodBeat.i(122952);
    if (BtS == null)
    {
      AppMethodBeat.o(122952);
      return;
    }
    paramMailAddrsViewControl.setMailAdds(BtS);
    AppMethodBeat.o(122952);
  }
  
  private void aKG(final String paramString)
  {
    AppMethodBeat.i(122954);
    final o localo = new o(paramString);
    if (!localo.exists())
    {
      AppMethodBeat.o(122954);
      return;
    }
    if (this.Buk.Tf(paramString))
    {
      com.tencent.mm.ui.base.h.n(getContext(), 2131763998, 2131755998);
      AppMethodBeat.o(122954);
      return;
    }
    final int i = (int)localo.length();
    if (i > 20971520)
    {
      com.tencent.mm.ui.base.h.a(this, 2131763999, 2131755998, null);
      AppMethodBeat.o(122954);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(2131764001, new Object[] { Util.getSizeKB(i) }), getString(2131755998), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(198689);
        if (ComposeUI.D(ComposeUI.this).getTotalSize() + i > 52428800)
        {
          com.tencent.mm.ui.base.h.a(ComposeUI.this, 2131764000, 2131755998, null);
          AppMethodBeat.o(198689);
          return;
        }
        Object localObject;
        if (ComposeUI.j(ComposeUI.this).getText().toString().trim().length() == 0)
        {
          paramAnonymousDialogInterface = localo.getName().trim();
          paramAnonymousInt = paramAnonymousDialogInterface.lastIndexOf(".");
          localObject = ComposeUI.j(ComposeUI.this);
          if (paramAnonymousInt <= 0) {
            break label173;
          }
        }
        for (;;)
        {
          ((EditText)localObject).setText(paramAnonymousDialogInterface.substring(0, paramAnonymousInt));
          Log.i("MicroMsg.Mail.ComposeUI", "in upload file mode = %d", new Object[] { Integer.valueOf(ComposeUI.a(ComposeUI.this)) });
          paramAnonymousDialogInterface = ComposeUI.D(ComposeUI.this);
          localObject = paramString;
          if ((localObject != null) && (((String)localObject).length() != 0) && (!paramAnonymousDialogInterface.Bvz.containsKey(localObject))) {
            break;
          }
          AppMethodBeat.o(198689);
          return;
          label173:
          paramAnonymousInt = paramAnonymousDialogInterface.length();
        }
        o localo = new o((String)localObject);
        if ((!localo.exists()) || (!localo.isFile()))
        {
          AppMethodBeat.o(198689);
          return;
        }
        aj localaj = new aj();
        localaj.path = ((String)localObject);
        localaj.name = localo.getName();
        localaj.size = localo.length();
        localaj.state = 0;
        paramAnonymousDialogInterface.Bvz.put(localObject, localaj);
        paramAnonymousDialogInterface.a(localaj);
        AppMethodBeat.o(198689);
      }
    }, null);
    AppMethodBeat.o(122954);
  }
  
  private void dRW()
  {
    AppMethodBeat.i(122947);
    if (!s.d(this, com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
      Toast.makeText(this, getString(2131765171), 1).show();
    }
    AppMethodBeat.o(122947);
  }
  
  private void eGC()
  {
    AppMethodBeat.i(122943);
    this.BtU.clearFocus();
    this.BtY.clearFocus();
    this.Bub.clearFocus();
    AppMethodBeat.o(122943);
  }
  
  private void eGD()
  {
    AppMethodBeat.i(122945);
    if (this.Bui != null)
    {
      this.Bui.clearFocus();
      this.Bui.getSettings().setJavaScriptEnabled(true);
      this.Bui.setWebViewClient(new b((byte)0));
      this.Bui.setWebChromeClient(new a((byte)0));
      this.Bui.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(198678);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(198678);
            return false;
            if (!paramAnonymousView.hasFocus()) {
              paramAnonymousView.requestFocus();
            }
          }
        }
      });
    }
    AppMethodBeat.o(122945);
  }
  
  private String eGE()
  {
    AppMethodBeat.i(122949);
    Object localObject = new StringBuilder(this.nBD.getText().toString());
    com.tencent.mm.pluginsdk.ui.tools.z.a(this.Bui, this.BuA, this.Bus);
    if (!Util.isNullOrNil(this.Buw))
    {
      int i = this.Buw.indexOf(this.But);
      int j = this.Buw.lastIndexOf(this.Buu);
      if ((i == -1) || (j == -1)) {
        break label136;
      }
      String str = this.Buw.substring(i + this.But.length(), j + this.Buu.length());
      ((StringBuilder)localObject).append("\n").append(str);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(122949);
      return localObject;
      label136:
      ((StringBuilder)localObject).append("\n").append(this.Buw);
    }
  }
  
  private static ArrayList<Bundle> fV(List<com.tencent.mm.plugin.qqmail.d.l> paramList)
  {
    AppMethodBeat.i(198691);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.qqmail.d.l locall = (com.tencent.mm.plugin.qqmail.d.l)paramList.next();
      Bundle localBundle = new Bundle();
      localBundle.putString("item_addr", locall.yFq);
      localBundle.putString("item_name", locall.name);
      localArrayList.add(localBundle);
    }
    AppMethodBeat.o(198691);
    return localArrayList;
  }
  
  static void fW(List<com.tencent.mm.plugin.qqmail.d.l> paramList)
  {
    BtS = paramList;
  }
  
  protected final boolean eGF()
  {
    AppMethodBeat.i(122951);
    if (!this.BtU.eGV())
    {
      Toast.makeText(this, 2131763982, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (!this.BtY.eGV())
    {
      Toast.makeText(this, 2131763973, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (!this.Bub.eGV())
    {
      Toast.makeText(this, 2131763971, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (this.BtU.getMailAddrs().size() + this.BtY.getMailAddrs().size() + this.Bub.getMailAddrs().size() > 20)
    {
      Toast.makeText(this, 2131763989, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    AppMethodBeat.o(122951);
    return true;
  }
  
  public int getLayoutId()
  {
    return 2131496000;
  }
  
  public void initView()
  {
    AppMethodBeat.i(122944);
    this.BtT = ((ScrollView)findViewById(2131306371));
    this.BtU = ((MailAddrsViewControl)findViewById(2131306367));
    this.BtV = ((ImageView)findViewById(2131306362));
    this.BtW = ((LinearLayout)findViewById(2131306370));
    this.BtX = ((LinearLayout)findViewById(2131306366));
    this.BtY = ((MailAddrsViewControl)findViewById(2131306365));
    this.BtZ = ((ImageView)findViewById(2131306361));
    this.Bua = ((LinearLayout)findViewById(2131306364));
    this.Bub = ((MailAddrsViewControl)findViewById(2131306363));
    this.Buc = ((ImageView)findViewById(2131306360));
    this.Bud = ((EditText)findViewById(2131306375));
    this.Bue = ((LinearLayout)findViewById(2131306359));
    this.nBD = ((EditText)findViewById(2131306372));
    this.Bui = MMWebView.a.r(this, 2131306373);
    this.Buf = ((TextView)findViewById(2131306369));
    this.Bug = ((ImageView)findViewById(2131306368));
    this.Buh = ((LinearLayout)findViewById(2131305993));
    this.BtU.setEditable(true);
    this.BtY.setEditable(true);
    this.Bub.setEditable(true);
    Object localObject2 = getIntent().getStringExtra("mail_content");
    this.Bux = getIntent().getParcelableArrayListExtra("mail_attach");
    this.Buy = getIntent().getStringArrayListExtra("mail_attach_file");
    Object localObject1 = ((k)g.ah(k.class)).getNormalMailAppService().BrV.fe(this.Bum, this.Brp);
    this.Buk = new b(this, this.Buf, this.Bug, this.Buh, (byte)0);
    Object localObject3;
    Object localObject4;
    if (!Util.isNullOrNil((String)localObject2)) {
      if (this.mode == 21)
      {
        eGD();
        this.BtU.requestFocus();
        this.Buw = String.format(this.Buv, new Object[] { localObject2 });
        this.Bui.loadDataWithBaseURL("", this.Buw, "text/html", "utf-8", "");
        this.Bui.setVisibility(0);
        if (this.Brp == 1) {
          break label1512;
        }
        localObject1 = getIntent().getStringArrayExtra("toList");
        localObject3 = getIntent().getStringArrayExtra("ccList");
        localObject4 = getIntent().getStringArrayExtra("bccList");
        localObject2 = getIntent().getStringExtra("subject");
        this.BtU.j(M((String[])localObject1), false);
        this.BtY.j(M((String[])localObject3), false);
        this.Bub.j(M((String[])localObject4), false);
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject3 = this.Bud;
          localObject4 = new StringBuilder();
          if (this.Brp != 2) {
            break label1084;
          }
        }
      }
    }
    label1084:
    for (localObject1 = "Re:";; localObject1 = "Fwd:")
    {
      ((EditText)localObject3).setText((String)localObject1 + (String)localObject2);
      if (this.Bux == null) {
        break label1108;
      }
      localObject1 = new ArrayList();
      localObject2 = this.Bux.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Bundle)((Iterator)localObject2).next();
        localObject4 = new aj();
        ((aj)localObject4).name = ((Bundle)localObject3).getString("attach_name");
        StringBuilder localStringBuilder = new StringBuilder();
        ((k)g.ah(k.class)).getNormalMailAppService();
        ((aj)localObject4).path = (v.getDownloadPath() + ((aj)localObject4).name);
        ((aj)localObject4).state = 2;
        ((aj)localObject4).size = ((Bundle)localObject3).getInt("attach_size");
        ((aj)localObject4).svrId = ((Bundle)localObject3).getString("attach_fileId");
        ((List)localObject1).add(localObject4);
      }
      if (this.mode != 20) {
        break;
      }
      this.nBD.setVisibility(0);
      this.Bui.setVisibility(8);
      if (((String)localObject2).indexOf("<div>") != -1)
      {
        Log.i("MicroMsg.Mail.ComposeUI", "set content in html format");
        this.nBD.setText(Html.fromHtml((String)localObject2));
        break;
      }
      this.nBD.setText((CharSequence)localObject2);
      break;
      if ((localObject1 != null) && (this.mode == 21))
      {
        Log.i("MicroMsg.Mail.ComposeUI", "read mail from draftMail");
        this.BtU.j(((com.tencent.mm.plugin.qqmail.d.i)localObject1).Brq, false);
        this.BtY.j(((com.tencent.mm.plugin.qqmail.d.i)localObject1).Brr, false);
        this.Bub.j(((com.tencent.mm.plugin.qqmail.d.i)localObject1).Brs, false);
        this.Bud.setText(((com.tencent.mm.plugin.qqmail.d.i)localObject1).Bru);
        localObject2 = ((com.tencent.mm.plugin.qqmail.d.i)localObject1).content;
        this.mode = 20;
        if (((String)localObject2).indexOf("<div>") != -1)
        {
          Log.i("MicroMsg.Mail.ComposeUI", "set content in html format");
          this.nBD.setText(Html.fromHtml((String)localObject2));
        }
        for (;;)
        {
          this.Buk.fX(((com.tencent.mm.plugin.qqmail.d.i)localObject1).Brt);
          this.Buk.eGQ();
          this.Bui.setVisibility(8);
          this.nBD.setVisibility(0);
          break;
          this.nBD.setText((CharSequence)localObject2);
        }
      }
      Log.i("MicroMsg.Mail.ComposeUI", "no extra or draf mail content");
      if (this.mode == 21)
      {
        eGD();
        this.BtU.requestFocus();
        this.Buw = String.format(this.Buv, new Object[] { "" });
        this.Bui.loadDataWithBaseURL("", this.Buw, "text/html", "utf-8", "");
        this.nBD.setVisibility(8);
        this.Bui.setVisibility(0);
        break;
      }
      if (this.mode != 20) {
        break;
      }
      this.Bui.setVisibility(8);
      this.nBD.setVisibility(0);
      break;
    }
    if (!((List)localObject1).isEmpty()) {
      this.Buk.fX((List)localObject1);
    }
    for (;;)
    {
      label1108:
      if ((this.BtY.getMailAddrs().size() > 0) || (this.Bub.getMailAddrs().size() > 0))
      {
        this.BtW.setVisibility(8);
        this.BtX.setVisibility(0);
        this.Bua.setVisibility(0);
      }
      if ((this.Brp == 2) && (this.mode != 21) && (this.mode == 20))
      {
        this.nBD.requestFocus();
        this.nBD.setSelection(0);
        this.BtT.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(122921);
            ComposeUI.g(ComposeUI.this).fullScroll(130);
            AppMethodBeat.o(122921);
          }
        }, 1000L);
      }
      this.BtU.setOnActionListener(new c(this.BtV, 0));
      this.BtY.setOnActionListener(new c(this.BtZ, 1));
      this.Bub.setOnActionListener(new c(this.Buc, 2));
      localObject1 = new MailAddrsViewControl.a()
      {
        public final void b(final MailAddrsViewControl paramAnonymousMailAddrsViewControl)
        {
          AppMethodBeat.i(122926);
          com.tencent.mm.ui.base.h.a(ComposeUI.this.getContext(), ComposeUI.this.getString(2131763986), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(122923);
              paramAnonymousMailAddrsViewControl.Bwb.setText("");
              ComposeUI.i(ComposeUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(122922);
                  ComposeUI.h(ComposeUI.this);
                  ComposeUI.15.1.this.BuR.requestFocus();
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
                  ComposeUI.15.2.this.BuR.requestFocus();
                  ComposeUI.this.showVKB();
                  AppMethodBeat.o(122924);
                }
              }, 150L);
              AppMethodBeat.o(122925);
            }
          });
          AppMethodBeat.o(122926);
        }
        
        public final void eGH()
        {
          AppMethodBeat.i(122927);
          u.a(ComposeUI.this, ComposeUI.this.getString(2131763986), 1500L);
          AppMethodBeat.o(122927);
        }
      };
      this.BtU.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
      this.BtY.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
      this.Bub.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
      this.BtV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122928);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
          paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.BtU.getMailAddrStringArray());
          paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", 2130772130);
          paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", 2130772059);
          ComposeUI.this.startActivityForResult(paramAnonymousView, 0);
          BackwardSupportUtil.AnimationHelper.overridePendingTransition(ComposeUI.this, 2130772132, 2130772060);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122928);
        }
      });
      this.BtZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122929);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
          paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.e(ComposeUI.this).getMailAddrStringArray());
          paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", 2130772130);
          paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", 2130772059);
          ComposeUI.this.startActivityForResult(paramAnonymousView, 1);
          BackwardSupportUtil.AnimationHelper.overridePendingTransition(ComposeUI.this, 2130772132, 2130772060);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122929);
        }
      });
      this.Buc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122930);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
          paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.f(ComposeUI.this).getMailAddrStringArray());
          paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", 2130772130);
          paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", 2130772059);
          ComposeUI.this.startActivityForResult(paramAnonymousView, 2);
          BackwardSupportUtil.AnimationHelper.overridePendingTransition(ComposeUI.this, 2130772132, 2130772060);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122930);
        }
      });
      this.BtW.setOnClickListener(this.BuH);
      localObject1 = (ImageView)findViewById(2131306374);
      if ((this.Bup) && (this.Bud.getText().length() > 0)) {
        ((ImageView)localObject1).setVisibility(0);
      }
      this.Bud.setOnFocusChangeListener(new View.OnFocusChangeListener()
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
      this.Bud.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          paramAnonymousInt1 = 4;
          AppMethodBeat.i(122893);
          if (ComposeUI.this.Bup)
          {
            paramAnonymousCharSequence = this.BuM;
            if (ComposeUI.j(ComposeUI.this).getText().length() > 0) {
              paramAnonymousInt1 = 0;
            }
            paramAnonymousCharSequence.setVisibility(paramAnonymousInt1);
            AppMethodBeat.o(122893);
            return;
          }
          this.BuM.setVisibility(4);
          AppMethodBeat.o(122893);
        }
      });
      ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122894);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          ComposeUI.j(ComposeUI.this).getText().clear();
          ComposeUI.j(ComposeUI.this).requestFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122894);
        }
      });
      this.Bue.setOnClickListener(this.BuI);
      setMMTitle(2131763980);
      setBackBtn(this.BuJ);
      addTextOptionMenu(0, getString(2131755976), new MenuItem.OnMenuItemClickListener()
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
      eGC();
      AppMethodBeat.o(122944);
      return;
      label1512:
      localObject1 = getIntent().getStringExtra("subject");
      if (!Util.isNullOrNil((String)localObject1)) {
        this.Bud.setText((CharSequence)localObject1);
      }
      if (this.Buy != null)
      {
        localObject1 = this.Buy.iterator();
        while (((Iterator)localObject1).hasNext()) {
          aKG((String)((Iterator)localObject1).next());
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
      a(this.BtU);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      a(this.BtY);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      a(this.Bub);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      paramIntent = s.h(this, paramIntent, com.tencent.mm.plugin.image.d.aSY());
      if (paramIntent != null)
      {
        aKG(paramIntent);
        eGC();
        AppMethodBeat.o(122953);
        return;
        if (paramIntent != null)
        {
          paramIntent = com.tencent.mm.ui.tools.a.i(this, paramIntent, com.tencent.mm.plugin.image.d.aSY());
          if ((paramIntent != null) && (paramIntent.length() > 0))
          {
            aKG(paramIntent);
            eGC();
            AppMethodBeat.o(122953);
            return;
            if (paramIntent != null)
            {
              aKG(paramIntent.getStringExtra("choosed_file_path"));
              eGC();
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
    this.Buv = (this.But + "%s" + this.Buu);
    this.BuC = false;
    this.BuD = false;
    this.Brp = getIntent().getIntExtra("composeType", 1);
    this.Bum = getIntent().getStringExtra("mailid");
    if (this.Bum == null) {
      this.Bum = "";
    }
    this.mode = getIntent().getIntExtra("mail_mode", 20);
    Log.d("MicroMsg.Mail.ComposeUI", "onCreate, mode = %d", new Object[] { Integer.valueOf(this.mode) });
    initView();
    this.Buj = ((k)g.ah(k.class)).getNormalMailAppService().BrU;
    this.Buj.a(this.BuG);
    this.Buj.eGn();
    this.BuF.startTimer(180000L);
    g.azz().a(11166, this);
    AppMethodBeat.o(122939);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122942);
    super.onDestroy();
    if (BtS != null) {
      BtS = null;
    }
    this.Buk.eGO();
    b localb = this.Buk;
    g.aAg().hqi.b(11665, localb);
    this.Buj.b(this.BuG);
    this.Bul.release();
    g.azz().b(11166, this);
    this.BuF.stopTimer();
    AppMethodBeat.o(122942);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(122946);
    if (paramInt == 4)
    {
      this.BuJ.onMenuItemClick(null);
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
    this.BuE.stopTimer();
    if (this.Bun != null) {
      this.Bun.dismiss();
    }
    AppMethodBeat.o(122941);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(122948);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.Mail.ComposeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(122948);
      return;
    }
    Log.i("MicroMsg.Mail.ComposeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122948);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        dRW();
        AppMethodBeat.o(122948);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763864), getString(2131763890), getString(2131762043), getString(2131755761), false, new ComposeUI.8(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(122940);
    super.onResume();
    this.BuE.startTimer(1500L);
    AppMethodBeat.o(122940);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(198692);
    Log.i("MicroMsg.Mail.ComposeUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!((com.tencent.mm.plugin.qqmail.e.d)paramq).dPI.equals(this.dPI))
    {
      Log.w("MicroMsg.Mail.ComposeUI", "not current request, ignore");
      AppMethodBeat.o(198692);
      return;
    }
    if (this.kkW != null) {
      this.kkW.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Toast.makeText(this, 2131763960, 1).show();
      paramString = ((k)g.ah(k.class)).getNormalMailAppService().BrV;
      paramq = this.Bum;
      paramInt1 = this.Brp;
      paramString = new o(paramString.Bro.Brx + com.tencent.mm.plugin.qqmail.d.h.ff(paramq, paramInt1));
      if (paramString.exists()) {
        paramString.delete();
      }
      this.Buj.fU(this.BtU.getMailAddrs());
      this.Buj.fU(this.BtY.getMailAddrs());
      this.Buj.fU(this.Bub.getMailAddrs());
      setResult(-1);
      finish();
      AppMethodBeat.o(198692);
      return;
    }
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = getString(2131763958);
    }
    Toast.makeText(this, paramq, 1).show();
    AppMethodBeat.o(198692);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setRequestedOrientation(int paramInt) {}
  
  final class a
    extends x
  {
    private a() {}
    
    @Deprecated
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(122932);
      Log.i("MicroMsg.Mail.ComposeUI", "console, consoleMessage: %s", new Object[] { paramConsoleMessage });
      if (paramConsoleMessage != null) {}
      Object localObject4;
      Object localObject3;
      for (Object localObject1 = paramConsoleMessage.message();; localObject1 = null)
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.tools.z.bfJ((String)localObject1);
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
          Log.i("MicroMsg.Mail.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[] { localObject1[1], localObject3, localObject4 });
          localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(Integer.valueOf((String)localObject3).intValue());
          localObject1 = new Intent(ComposeUI.this, MailImageDownloadUI.class);
          ((Intent)localObject1).putExtra("img_msg_id", ((eo)localObject3).field_msgId);
          ((Intent)localObject1).putExtra("img_server_id", ((eo)localObject3).field_msgSvrId);
          ((Intent)localObject1).putExtra("img_download_compress_type", 0);
          ((Intent)localObject1).putExtra("img_download_username", ((eo)localObject3).field_talker);
          localObject3 = ComposeUI.this;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentChromeClient", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ComposeUI)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentChromeClient", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(122932);
          return true;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.Mail.ComposeUI", "consoleMessage IMG_ONCLICK, ex = %s", new Object[] { localException.getMessage() });
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
              Log.w("MicroMsg.Mail.ComposeUI", "consoleMessage GET_MAIL_CONTENT, ex = %s", new Object[] { paramConsoleMessage.getMessage() });
            }
            com.tencent.mm.pluginsdk.ui.tools.z.a(ComposeUI.r(ComposeUI.this), ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this));
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
            Log.i("MicroMsg.Mail.ComposeUI", "put msgImgInfoMap, fileName: %s, path: %s", new Object[] { localObject4, paramConsoleMessage });
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
        Log.w("MicroMsg.Mail.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", new Object[] { paramConsoleMessage.getMessage() });
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
    private boolean BuV = false;
    
    private b() {}
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(122933);
      Log.d("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading, url = %s", new Object[] { paramString });
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
          Log.i("MicroMsg.Mail.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[] { paramWebView[1], paramString, localObject1 });
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(Integer.valueOf(paramString).intValue());
          paramWebView = new Intent(ComposeUI.this, MailImageDownloadUI.class);
          paramWebView.putExtra("img_msg_id", paramString.field_msgId);
          paramWebView.putExtra("img_server_id", paramString.field_msgSvrId);
          paramWebView.putExtra("img_download_compress_type", 0);
          paramWebView.putExtra("img_download_username", paramString.field_talker);
          paramString = ComposeUI.this;
          paramWebView = new com.tencent.mm.hellhoundlib.b.a().bl(paramWebView);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramWebView.axQ(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramWebView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(122933);
          return true;
        }
        catch (Exception paramWebView)
        {
          Log.w("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading IMG_ONCLICK, ex = %s", new Object[] { paramWebView.getMessage() });
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
              Log.w("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading GET_MAIL_CONTENT, ex = %s", new Object[] { paramWebView.getMessage() });
            }
            com.tencent.mm.pluginsdk.ui.tools.z.a(ComposeUI.r(ComposeUI.this), ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this));
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
            Log.i("MicroMsg.Mail.ComposeUI", "put msgImgInfoMap, fileName: %s, path: %s", new Object[] { localObject2, paramWebView });
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
        Log.w("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading GET_IMG_INFO, ex = %s", new Object[] { paramWebView.getMessage() });
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
      Log.d("MicroMsg.Mail.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", new Object[] { paramString, Boolean.valueOf(this.BuV) });
      if (!this.BuV)
      {
        this.BuV = true;
        com.tencent.mm.pluginsdk.ui.tools.z.a(ComposeUI.r(ComposeUI.this), ComposeUI.m(ComposeUI.this), ComposeUI.w(ComposeUI.this));
        if (ComposeUI.this.getIntent().getBooleanExtra("mail_edit_mode", false)) {
          com.tencent.mm.pluginsdk.ui.tools.z.a(ComposeUI.r(ComposeUI.this), ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this));
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
        com.tencent.mm.pluginsdk.ui.tools.z.c(ComposeUI.r(ComposeUI.this));
        ComposeUI.v(ComposeUI.this);
      }
      AppMethodBeat.o(122934);
    }
  }
  
  final class c
    extends MailAddrsViewControl.c
  {
    private ImageView BuW;
    private int tag;
    
    public c(ImageView paramImageView, int paramInt)
    {
      this.BuW = paramImageView;
      this.tag = paramInt;
    }
    
    public final void sS(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(122937);
      ComposeUI.x(ComposeUI.this);
      Object localObject;
      if (ComposeUI.this.Buq) {
        localObject = this.BuW;
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
              if ((!ComposeUI.e(ComposeUI.this).Bwb.isFocused()) && (!ComposeUI.f(ComposeUI.this).Bwb.isFocused()) && (ComposeUI.e(ComposeUI.this).getMailAddrs().size() == 0) && (ComposeUI.f(ComposeUI.this).getMailAddrs().size() == 0) && (ComposeUI.e(ComposeUI.this).eGS()) && (ComposeUI.f(ComposeUI.this).eGS()))
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
        ImageView localImageView = this.BuW;
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