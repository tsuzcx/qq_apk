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
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.qqmail.d.aj;
import com.tencent.mm.plugin.qqmail.d.j;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.l;
import com.tencent.mm.plugin.qqmail.d.m;
import com.tencent.mm.plugin.qqmail.d.m.a;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.qqmail.e.a;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.ad;
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

@com.tencent.mm.ui.widget.pulldown.c(0)
@SuppressLint({"SetJavaScriptEnabled"})
public class ComposeUI
  extends MMActivity
  implements com.tencent.mm.an.i
{
  private static List<l> Hom;
  private int HlJ;
  private com.tencent.mm.plugin.qqmail.d.ab Hlo;
  private Map<String, String> HmE;
  private ImageView HoA;
  private LinearLayout HoB;
  private MMWebView HoC;
  private m HoD;
  private b HoE;
  public c HoF;
  private String HoG;
  private r HoH;
  public boolean HoI;
  public boolean HoJ;
  public boolean HoK;
  private String HoL;
  private String HoM;
  private String HoN;
  private String HoO;
  private String HoP;
  private String HoQ;
  private List<Bundle> HoR;
  private List<String> HoS;
  private String HoT;
  private String HoU;
  private String HoV;
  private boolean HoW;
  private boolean HoX;
  private MTimerHandler HoY;
  private MTimerHandler HoZ;
  private ScrollView Hon;
  protected MailAddrsViewControl Hoo;
  private ImageView Hop;
  private LinearLayout Hoq;
  private LinearLayout Hor;
  private MailAddrsViewControl Hos;
  private ImageView Hot;
  private LinearLayout Hou;
  private MailAddrsViewControl Hov;
  private ImageView How;
  private EditText Hox;
  private LinearLayout Hoy;
  private TextView Hoz;
  m.a Hpa;
  private View.OnClickListener Hpb;
  private View.OnClickListener Hpc;
  private MenuItem.OnMenuItemClickListener Hpd;
  private View.OnClickListener Hpe;
  private String fIY;
  private int mode;
  private s ncM;
  private EditText qDO;
  
  public ComposeUI()
  {
    AppMethodBeat.i(122938);
    this.HoF = new c(this);
    this.HlJ = 1;
    this.HoI = true;
    this.HoJ = true;
    this.HoK = false;
    this.HoL = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    this.HoM = "document.getElementById('history').innerHTML";
    this.HoN = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    this.HoO = "</div>";
    this.HoP = null;
    this.mode = 20;
    this.HmE = new HashMap();
    this.Hlo = ((k)com.tencent.mm.kernel.h.ag(k.class)).getShareModeMailAppService();
    this.HoQ = null;
    this.HoR = null;
    this.HoS = null;
    this.HoT = "weixin://get_img_info/";
    this.HoU = "weixin://get_mail_content/";
    this.HoV = "weixin://img_onclick/";
    this.HoW = false;
    this.HoX = false;
    this.HoY = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(122892);
        ComposeUI.this.enableOptionMenu(ComposeUI.a(ComposeUI.this, true));
        AppMethodBeat.o(122892);
        return true;
      }
    }, true);
    this.HoZ = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(122909);
        if ((ComposeUI.this.HoI) && (ComposeUI.a(ComposeUI.this, false)) && (ComposeUI.a(ComposeUI.this) == 20))
        {
          ComposeUI.b(ComposeUI.this);
          if (ComposeUI.c(ComposeUI.this) != null) {
            ComposeUI.c(ComposeUI.this).dismiss();
          }
          ComposeUI.a(ComposeUI.this, w.a(ComposeUI.this, ComposeUI.this.getString(e.i.plugin_qqmail_composeui_auto_save), 2000L));
        }
        AppMethodBeat.o(122909);
        return true;
      }
    }, true);
    this.Hpa = new m.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(122920);
        Log.i("MicroMsg.Mail.ComposeUI", "sync addr complete");
        MailAddrsViewControl.b localb = new MailAddrsViewControl.b(ComposeUI.this, ComposeUI.d(ComposeUI.this).aVe(null));
        ComposeUI.this.Hoo.setAddrsAdapter(localb);
        ComposeUI.e(ComposeUI.this).setAddrsAdapter(localb);
        ComposeUI.f(ComposeUI.this).setAddrsAdapter(localb);
        AppMethodBeat.o(122920);
      }
    };
    this.Hpb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(251111);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ComposeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ComposeUI.y(ComposeUI.this).setVisibility(8);
        ComposeUI.z(ComposeUI.this).setVisibility(0);
        ComposeUI.A(ComposeUI.this).setVisibility(0);
        ComposeUI.y(ComposeUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(249768);
            ComposeUI.z(ComposeUI.this).requestFocus();
            ComposeUI.e(ComposeUI.this).ftb();
            ComposeUI.f(ComposeUI.this).ftb();
            AppMethodBeat.o(249768);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(251111);
      }
    };
    this.Hpc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122899);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ComposeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = ComposeUI.this;
        localObject = ComposeUI.this.getString(e.i.plugin_qqmail_composeui_attach_take_phote);
        String str1 = ComposeUI.this.getString(e.i.plugin_qqmail_composeui_attach_choose_album);
        String str2 = ComposeUI.this.getString(e.i.plugin_qqmail_composeui_attach_choose_file);
        h.d local1 = new h.d()
        {
          public final void qy(int paramAnonymous2Int)
          {
            AppMethodBeat.i(250006);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(250006);
              return;
              boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ComposeUI.this.getContext(), "android.permission.CAMERA", 16, "", "");
              Log.i("MicroMsg.Mail.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), ComposeUI.this.getContext() });
              if (!bool)
              {
                AppMethodBeat.o(250006);
                return;
              }
              ComposeUI.B(ComposeUI.this);
              AppMethodBeat.o(250006);
              return;
              u.d(ComposeUI.this, 4, null);
              AppMethodBeat.o(250006);
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
    this.Hpd = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(250536);
        if (((ComposeUI.a(ComposeUI.this, false)) && (ComposeUI.a(ComposeUI.this) == 20)) || (ComposeUI.a(ComposeUI.this) == 21)) {
          com.tencent.mm.ui.base.h.c(ComposeUI.this.getContext(), ComposeUI.this.getString(e.i.plugin_qqmail_composeui_leave_alert), "", ComposeUI.this.getString(e.i.plugin_qqmail_composeui_quit_delete), ComposeUI.this.getString(e.i.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(249709);
              ComposeUI.this.setResult(0);
              ComposeUI.this.finish();
              AppMethodBeat.o(249709);
            }
          }, null);
        }
        for (;;)
        {
          AppMethodBeat.o(250536);
          return true;
          ComposeUI.this.setResult(0);
          ComposeUI.this.finish();
        }
      }
    };
    this.Hpe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(249711);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        ComposeUI.this.hideVKB();
        ComposeUI.j(ComposeUI.this).getText();
        ComposeUI.C(ComposeUI.this);
        if (!ComposeUI.this.fsI())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(249711);
          return;
        }
        paramAnonymousView = ComposeUI.p(ComposeUI.this).entrySet().iterator();
        while (paramAnonymousView.hasNext())
        {
          Object localObject2 = (Map.Entry)paramAnonymousView.next();
          localObject1 = ComposeUI.D(ComposeUI.this);
          localObject2 = (String)((Map.Entry)localObject2).getValue();
          Log.i("MicroMsg.Mail.FileUploadHelper", "uploadContentImage path=%s", new Object[] { localObject2 });
          if ((localObject2 != null) && (((String)localObject2).length() != 0) && (!((b)localObject1).HpU.containsKey(localObject2)))
          {
            com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q((String)localObject2);
            if ((localq.ifE()) && (localq.ifH()))
            {
              aj localaj = new aj();
              localaj.path = ((String)localObject2);
              localaj.name = localq.getName();
              localaj.size = localq.length();
              localaj.state = 0;
              ((b)localObject1).HpU.put(localObject2, localaj);
              if (localaj.state == 0) {
                localaj.yjR = ((b)localObject1).aVk(localaj.path);
              }
            }
          }
        }
        paramAnonymousView = ComposeUI.this;
        localObject1 = ComposeUI.this;
        ComposeUI.this.getString(e.i.app_tip);
        ComposeUI.a(paramAnonymousView, com.tencent.mm.ui.base.h.a((Context)localObject1, ComposeUI.this.getString(e.i.plugin_qqmail_compose_send_ing), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(250144);
            ComposeUI.D(ComposeUI.this).fsT();
            ComposeUI.D(ComposeUI.this).HpX = null;
            AppMethodBeat.o(250144);
          }
        }));
        if (!ComposeUI.D(ComposeUI.this).fsU())
        {
          ComposeUI.E(ComposeUI.this).setMessage(ComposeUI.this.getString(e.i.plugin_qqmail_attach_uploading));
          ComposeUI.D(ComposeUI.this).HpX = new b.b()
          {
            public final void fsJ()
            {
              AppMethodBeat.i(249977);
              ComposeUI.E(ComposeUI.this).setMessage(ComposeUI.this.getString(e.i.plugin_qqmail_attach_uploading));
              AppMethodBeat.o(249977);
            }
            
            public final void onComplete()
            {
              AppMethodBeat.i(249978);
              ComposeUI.b(ComposeUI.this, ComposeUI.q(ComposeUI.this));
              AppMethodBeat.o(249978);
            }
          };
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(249711);
          return;
          ComposeUI.b(ComposeUI.this, ComposeUI.q(ComposeUI.this));
        }
      }
    };
    AppMethodBeat.o(122938);
  }
  
  private static List<l> N(String[] paramArrayOfString)
  {
    AppMethodBeat.i(249827);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        l locall = m.aVf(paramArrayOfString[i]);
        if (locall != null) {
          localArrayList.add(locall);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(249827);
    return localArrayList;
  }
  
  private static void a(MailAddrsViewControl paramMailAddrsViewControl)
  {
    AppMethodBeat.i(122952);
    if (Hom == null)
    {
      AppMethodBeat.o(122952);
      return;
    }
    paramMailAddrsViewControl.setMailAdds(Hom);
    AppMethodBeat.o(122952);
  }
  
  private void aVh(final String paramString)
  {
    AppMethodBeat.i(122954);
    final com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(paramString);
    if (!localq.ifE())
    {
      AppMethodBeat.o(122954);
      return;
    }
    if (this.HoE.aaL(paramString))
    {
      com.tencent.mm.ui.base.h.p(getContext(), e.i.plugin_qqmail_upload_attach_exist, e.i.app_tip);
      AppMethodBeat.o(122954);
      return;
    }
    final int i = (int)localq.length();
    if (i > 20971520)
    {
      com.tencent.mm.ui.base.h.a(this, e.i.plugin_qqmail_upload_attach_single_file_size_exceed, e.i.app_tip, null);
      AppMethodBeat.o(122954);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(e.i.plugin_qqmail_upload_attach_size_tip, new Object[] { Util.getSizeKB(i) }), getString(e.i.app_tip), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(249670);
        if (ComposeUI.D(ComposeUI.this).getTotalSize() + i > 52428800)
        {
          com.tencent.mm.ui.base.h.a(ComposeUI.this, e.i.plugin_qqmail_upload_attach_size_exceed, e.i.app_tip, null);
          AppMethodBeat.o(249670);
          return;
        }
        Object localObject;
        if (ComposeUI.j(ComposeUI.this).getText().toString().trim().length() == 0)
        {
          paramAnonymousDialogInterface = localq.getName().trim();
          paramAnonymousInt = paramAnonymousDialogInterface.lastIndexOf(".");
          localObject = ComposeUI.j(ComposeUI.this);
          if (paramAnonymousInt <= 0) {
            break label175;
          }
        }
        for (;;)
        {
          ((EditText)localObject).setText(paramAnonymousDialogInterface.substring(0, paramAnonymousInt));
          Log.i("MicroMsg.Mail.ComposeUI", "in upload file mode = %d", new Object[] { Integer.valueOf(ComposeUI.a(ComposeUI.this)) });
          paramAnonymousDialogInterface = ComposeUI.D(ComposeUI.this);
          localObject = paramString;
          if ((localObject != null) && (((String)localObject).length() != 0) && (!paramAnonymousDialogInterface.HpU.containsKey(localObject))) {
            break;
          }
          AppMethodBeat.o(249670);
          return;
          label175:
          paramAnonymousInt = paramAnonymousDialogInterface.length();
        }
        com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q((String)localObject);
        if ((!localq.ifE()) || (!localq.ifH()))
        {
          AppMethodBeat.o(249670);
          return;
        }
        aj localaj = new aj();
        localaj.path = ((String)localObject);
        localaj.name = localq.getName();
        localaj.size = localq.length();
        localaj.state = 0;
        paramAnonymousDialogInterface.HpU.put(localObject, localaj);
        paramAnonymousDialogInterface.a(localaj);
        AppMethodBeat.o(249670);
      }
    }, null);
    AppMethodBeat.o(122954);
  }
  
  private void euy()
  {
    AppMethodBeat.i(122947);
    if (!u.d(this, com.tencent.mm.loader.j.b.aSX(), "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
      Toast.makeText(this, getString(e.i.selectcameraapp_none), 1).show();
    }
    AppMethodBeat.o(122947);
  }
  
  private void fsF()
  {
    AppMethodBeat.i(122943);
    this.Hoo.clearFocus();
    this.Hos.clearFocus();
    this.Hov.clearFocus();
    AppMethodBeat.o(122943);
  }
  
  private void fsG()
  {
    AppMethodBeat.i(122945);
    if (this.HoC != null)
    {
      this.HoC.clearFocus();
      this.HoC.getSettings().setJavaScriptEnabled(true);
      this.HoC.setWebViewClient(new b((byte)0));
      this.HoC.setWebChromeClient(new a((byte)0));
      this.HoC.setOnTouchListener(new ComposeUI.5(this));
    }
    AppMethodBeat.o(122945);
  }
  
  private String fsH()
  {
    AppMethodBeat.i(122949);
    Object localObject = new StringBuilder(this.qDO.getText().toString());
    com.tencent.mm.pluginsdk.ui.tools.ab.b(this.HoC, this.HoU, this.HoM);
    if (!Util.isNullOrNil(this.HoQ))
    {
      int i = this.HoQ.indexOf(this.HoN);
      int j = this.HoQ.lastIndexOf(this.HoO);
      if ((i == -1) || (j == -1)) {
        break label136;
      }
      String str = this.HoQ.substring(i + this.HoN.length(), j + this.HoO.length());
      ((StringBuilder)localObject).append("\n").append(str);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(122949);
      return localObject;
      label136:
      ((StringBuilder)localObject).append("\n").append(this.HoQ);
    }
  }
  
  static void gA(List<l> paramList)
  {
    Hom = paramList;
  }
  
  private static ArrayList<Bundle> gz(List<l> paramList)
  {
    AppMethodBeat.i(249829);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      l locall = (l)paramList.next();
      Bundle localBundle = new Bundle();
      localBundle.putString("item_addr", locall.Ejj);
      localBundle.putString("item_name", locall.name);
      localArrayList.add(localBundle);
    }
    AppMethodBeat.o(249829);
    return localArrayList;
  }
  
  protected final boolean fsI()
  {
    AppMethodBeat.i(122951);
    if (!this.Hoo.fta())
    {
      Toast.makeText(this, e.i.plugin_qqmail_composeui_toaddr_invalid, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (!this.Hos.fta())
    {
      Toast.makeText(this, e.i.plugin_qqmail_composeui_ccaddr_invalid, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (!this.Hov.fta())
    {
      Toast.makeText(this, e.i.plugin_qqmail_composeui_bccaddr_invalid, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (this.Hoo.getMailAddrs().size() + this.Hos.getMailAddrs().size() + this.Hov.getMailAddrs().size() > 20)
    {
      Toast.makeText(this, e.i.plugin_qqmail_svr_error_desc_101, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    AppMethodBeat.o(122951);
    return true;
  }
  
  public int getLayoutId()
  {
    return e.f.qqmail_compose;
  }
  
  public void initView()
  {
    AppMethodBeat.i(122944);
    this.Hon = ((ScrollView)findViewById(e.e.qqmail_compose_container_sv));
    this.Hoo = ((MailAddrsViewControl)findViewById(e.e.qqmail_compose_addr_to_control));
    this.Hop = ((ImageView)findViewById(e.e.qqmail_compose_add_to_iv));
    this.Hoq = ((LinearLayout)findViewById(e.e.qqmail_compose_ccbacc_ll));
    this.Hor = ((LinearLayout)findViewById(e.e.qqmail_compose_addr_cc_fl));
    this.Hos = ((MailAddrsViewControl)findViewById(e.e.qqmail_compose_addr_cc_control));
    this.Hot = ((ImageView)findViewById(e.e.qqmail_compose_add_cc_iv));
    this.Hou = ((LinearLayout)findViewById(e.e.qqmail_compose_addr_bcc_fl));
    this.Hov = ((MailAddrsViewControl)findViewById(e.e.qqmail_compose_addr_bcc_control));
    this.How = ((ImageView)findViewById(e.e.qqmail_compose_add_bcc_iv));
    this.Hox = ((EditText)findViewById(e.e.qqmail_compose_subject_et));
    this.Hoy = ((LinearLayout)findViewById(e.e.qqmail_compose_add_attach_ll));
    this.qDO = ((EditText)findViewById(e.e.qqmail_compose_content_et));
    this.HoC = MMWebView.a.s(this, e.e.qqmail_compose_content_web);
    this.Hoz = ((TextView)findViewById(e.e.qqmail_compose_attach_summary_iv));
    this.HoA = ((ImageView)findViewById(e.e.qqmail_compose_attach_summary_icon));
    this.HoB = ((LinearLayout)findViewById(e.e.plugin_qqmail_compose_attachment_container));
    this.Hoo.setEditable(true);
    this.Hos.setEditable(true);
    this.Hov.setEditable(true);
    Object localObject2 = getIntent().getStringExtra("mail_content");
    this.HoR = getIntent().getParcelableArrayListExtra("mail_attach");
    this.HoS = getIntent().getStringArrayListExtra("mail_attach_file");
    Object localObject1 = ((k)com.tencent.mm.kernel.h.ag(k.class)).getNormalMailAppService().Hmo.fG(this.HoG, this.HlJ);
    this.HoE = new b(this, this.Hoz, this.HoA, this.HoB, (byte)0);
    Object localObject3;
    Object localObject4;
    if (!Util.isNullOrNil((String)localObject2)) {
      if (this.mode == 21)
      {
        fsG();
        this.Hoo.requestFocus();
        this.HoQ = String.format(this.HoP, new Object[] { localObject2 });
        this.HoC.loadDataWithBaseURL("", this.HoQ, "text/html", "utf-8", "");
        this.HoC.setVisibility(0);
        if (this.HlJ == 1) {
          break label1512;
        }
        localObject1 = getIntent().getStringArrayExtra("toList");
        localObject3 = getIntent().getStringArrayExtra("ccList");
        localObject4 = getIntent().getStringArrayExtra("bccList");
        localObject2 = getIntent().getStringExtra("subject");
        this.Hoo.k(N((String[])localObject1), false);
        this.Hos.k(N((String[])localObject3), false);
        this.Hov.k(N((String[])localObject4), false);
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject3 = this.Hox;
          localObject4 = new StringBuilder();
          if (this.HlJ != 2) {
            break label1084;
          }
        }
      }
    }
    label1084:
    for (localObject1 = "Re:";; localObject1 = "Fwd:")
    {
      ((EditText)localObject3).setText((String)localObject1 + (String)localObject2);
      if (this.HoR == null) {
        break label1108;
      }
      localObject1 = new ArrayList();
      localObject2 = this.HoR.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Bundle)((Iterator)localObject2).next();
        localObject4 = new aj();
        ((aj)localObject4).name = ((Bundle)localObject3).getString("attach_name");
        StringBuilder localStringBuilder = new StringBuilder();
        ((k)com.tencent.mm.kernel.h.ag(k.class)).getNormalMailAppService();
        ((aj)localObject4).path = (v.fst() + ((aj)localObject4).name);
        ((aj)localObject4).state = 2;
        ((aj)localObject4).size = ((Bundle)localObject3).getInt("attach_size");
        ((aj)localObject4).svrId = ((Bundle)localObject3).getString("attach_fileId");
        ((List)localObject1).add(localObject4);
      }
      if (this.mode != 20) {
        break;
      }
      this.qDO.setVisibility(0);
      this.HoC.setVisibility(8);
      if (((String)localObject2).indexOf("<div>") != -1)
      {
        Log.i("MicroMsg.Mail.ComposeUI", "set content in html format");
        this.qDO.setText(Html.fromHtml((String)localObject2));
        break;
      }
      this.qDO.setText((CharSequence)localObject2);
      break;
      if ((localObject1 != null) && (this.mode == 21))
      {
        Log.i("MicroMsg.Mail.ComposeUI", "read mail from draftMail");
        this.Hoo.k(((com.tencent.mm.plugin.qqmail.d.i)localObject1).HlK, false);
        this.Hos.k(((com.tencent.mm.plugin.qqmail.d.i)localObject1).HlL, false);
        this.Hov.k(((com.tencent.mm.plugin.qqmail.d.i)localObject1).HlM, false);
        this.Hox.setText(((com.tencent.mm.plugin.qqmail.d.i)localObject1).BDX);
        localObject2 = ((com.tencent.mm.plugin.qqmail.d.i)localObject1).content;
        this.mode = 20;
        if (((String)localObject2).indexOf("<div>") != -1)
        {
          Log.i("MicroMsg.Mail.ComposeUI", "set content in html format");
          this.qDO.setText(Html.fromHtml((String)localObject2));
        }
        for (;;)
        {
          this.HoE.gB(((com.tencent.mm.plugin.qqmail.d.i)localObject1).HlN);
          this.HoE.fsV();
          this.HoC.setVisibility(8);
          this.qDO.setVisibility(0);
          break;
          this.qDO.setText((CharSequence)localObject2);
        }
      }
      Log.i("MicroMsg.Mail.ComposeUI", "no extra or draf mail content");
      if (this.mode == 21)
      {
        fsG();
        this.Hoo.requestFocus();
        this.HoQ = String.format(this.HoP, new Object[] { "" });
        this.HoC.loadDataWithBaseURL("", this.HoQ, "text/html", "utf-8", "");
        this.qDO.setVisibility(8);
        this.HoC.setVisibility(0);
        break;
      }
      if (this.mode != 20) {
        break;
      }
      this.HoC.setVisibility(8);
      this.qDO.setVisibility(0);
      break;
    }
    if (!((List)localObject1).isEmpty()) {
      this.HoE.gB((List)localObject1);
    }
    for (;;)
    {
      label1108:
      if ((this.Hos.getMailAddrs().size() > 0) || (this.Hov.getMailAddrs().size() > 0))
      {
        this.Hoq.setVisibility(8);
        this.Hor.setVisibility(0);
        this.Hou.setVisibility(0);
      }
      if ((this.HlJ == 2) && (this.mode != 21) && (this.mode == 20))
      {
        this.qDO.requestFocus();
        this.qDO.setSelection(0);
        this.Hon.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(122921);
            ComposeUI.g(ComposeUI.this).fullScroll(130);
            AppMethodBeat.o(122921);
          }
        }, 1000L);
      }
      this.Hoo.setOnActionListener(new c(this.Hop, 0));
      this.Hos.setOnActionListener(new c(this.Hot, 1));
      this.Hov.setOnActionListener(new c(this.How, 2));
      localObject1 = new MailAddrsViewControl.a()
      {
        public final void b(final MailAddrsViewControl paramAnonymousMailAddrsViewControl)
        {
          AppMethodBeat.i(122926);
          com.tencent.mm.ui.base.h.a(ComposeUI.this.getContext(), ComposeUI.this.getString(e.i.plugin_qqmail_mail_addr_format_invalid), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(122923);
              paramAnonymousMailAddrsViewControl.Hqw.setText("");
              ComposeUI.i(ComposeUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(122922);
                  ComposeUI.h(ComposeUI.this);
                  ComposeUI.15.1.this.Hpm.requestFocus();
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
                  ComposeUI.15.2.this.Hpm.requestFocus();
                  ComposeUI.this.showVKB();
                  AppMethodBeat.o(122924);
                }
              }, 150L);
              AppMethodBeat.o(122925);
            }
          });
          AppMethodBeat.o(122926);
        }
        
        public final void fsK()
        {
          AppMethodBeat.i(122927);
          w.a(ComposeUI.this, ComposeUI.this.getString(e.i.plugin_qqmail_mail_addr_format_invalid), 1500L);
          AppMethodBeat.o(122927);
        }
      };
      this.Hoo.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
      this.Hos.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
      this.Hov.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
      this.Hop.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122928);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ComposeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
          paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.Hoo.getMailAddrStringArray());
          paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", e.a.push_down_out);
          paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", e.a.fast_faded_in);
          ComposeUI.this.startActivityForResult(paramAnonymousView, 0);
          BackwardSupportUtil.AnimationHelper.overridePendingTransition(ComposeUI.this, e.a.push_up_in, e.a.fast_faded_out);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122928);
        }
      });
      this.Hot.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122929);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ComposeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
          paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.e(ComposeUI.this).getMailAddrStringArray());
          paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", e.a.push_down_out);
          paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", e.a.fast_faded_in);
          ComposeUI.this.startActivityForResult(paramAnonymousView, 1);
          BackwardSupportUtil.AnimationHelper.overridePendingTransition(ComposeUI.this, e.a.push_up_in, e.a.fast_faded_out);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122929);
        }
      });
      this.How.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122930);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ComposeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
          paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.f(ComposeUI.this).getMailAddrStringArray());
          paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", e.a.push_down_out);
          paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", e.a.fast_faded_in);
          ComposeUI.this.startActivityForResult(paramAnonymousView, 2);
          BackwardSupportUtil.AnimationHelper.overridePendingTransition(ComposeUI.this, e.a.push_up_in, e.a.fast_faded_out);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122930);
        }
      });
      this.Hoq.setOnClickListener(this.Hpb);
      localObject1 = (ImageView)findViewById(e.e.qqmail_compose_subject_clear_iv);
      if ((this.HoJ) && (this.Hox.getText().length() > 0)) {
        ((ImageView)localObject1).setVisibility(0);
      }
      this.Hox.setOnFocusChangeListener(new ComposeUI.19(this));
      this.Hox.addTextChangedListener(new ComposeUI.2(this, (ImageView)localObject1));
      ((ImageView)localObject1).setOnClickListener(new ComposeUI.3(this));
      this.Hoy.setOnClickListener(this.Hpc);
      setMMTitle(e.i.plugin_qqmail_composeui_title);
      setBackBtn(this.Hpd);
      addTextOptionMenu(0, getString(e.i.app_send), new ComposeUI.4(this));
      enableOptionMenu(false);
      fsF();
      AppMethodBeat.o(122944);
      return;
      label1512:
      localObject1 = getIntent().getStringExtra("subject");
      if (!Util.isNullOrNil((String)localObject1)) {
        this.Hox.setText((CharSequence)localObject1);
      }
      if (this.HoS != null)
      {
        localObject1 = this.HoS.iterator();
        while (((Iterator)localObject1).hasNext()) {
          aVh((String)((Iterator)localObject1).next());
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
      a(this.Hoo);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      a(this.Hos);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      a(this.Hov);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      paramIntent = u.g(this, paramIntent, com.tencent.mm.plugin.image.d.bbW());
      if (paramIntent != null)
      {
        aVh(paramIntent);
        fsF();
        AppMethodBeat.o(122953);
        return;
        if (paramIntent != null)
        {
          paramIntent = com.tencent.mm.ui.tools.b.h(this, paramIntent, com.tencent.mm.plugin.image.d.bbW());
          if ((paramIntent != null) && (paramIntent.length() > 0))
          {
            aVh(paramIntent);
            fsF();
            AppMethodBeat.o(122953);
            return;
            if (paramIntent != null)
            {
              aVh(paramIntent.getStringExtra("choosed_file_path"));
              fsF();
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
    this.HoP = (this.HoN + "%s" + this.HoO);
    this.HoW = false;
    this.HoX = false;
    this.HlJ = getIntent().getIntExtra("composeType", 1);
    this.HoG = getIntent().getStringExtra("mailid");
    if (this.HoG == null) {
      this.HoG = "";
    }
    this.mode = getIntent().getIntExtra("mail_mode", 20);
    Log.d("MicroMsg.Mail.ComposeUI", "onCreate, mode = %d", new Object[] { Integer.valueOf(this.mode) });
    initView();
    this.HoD = ((k)com.tencent.mm.kernel.h.ag(k.class)).getNormalMailAppService().Hmn;
    this.HoD.a(this.Hpa);
    this.HoD.fso();
    this.HoZ.startTimer(180000L);
    com.tencent.mm.kernel.h.aGY().a(11166, this);
    AppMethodBeat.o(122939);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122942);
    super.onDestroy();
    if (Hom != null) {
      Hom = null;
    }
    this.HoE.fsT();
    b localb = this.HoE;
    com.tencent.mm.kernel.h.aHF().kcd.b(11665, localb);
    this.HoD.b(this.Hpa);
    this.HoF.release();
    com.tencent.mm.kernel.h.aGY().b(11166, this);
    this.HoZ.stopTimer();
    AppMethodBeat.o(122942);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(122946);
    if (paramInt == 4)
    {
      this.Hpd.onMenuItemClick(null);
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
    this.HoY.stopTimer();
    if (this.HoH != null) {
      this.HoH.dismiss();
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
        euy();
        AppMethodBeat.o(122948);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(e.i.permission_camera_request_again_msg), getString(e.i.permission_tips_title), getString(e.i.jump_to_settings), getString(e.i.app_cancel), false, new ComposeUI.8(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(122940);
    super.onResume();
    this.HoY.startTimer(1500L);
    AppMethodBeat.o(122940);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(249833);
    Log.i("MicroMsg.Mail.ComposeUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!((com.tencent.mm.plugin.qqmail.e.d)paramq).fIY.equals(this.fIY))
    {
      Log.w("MicroMsg.Mail.ComposeUI", "not current request, ignore");
      AppMethodBeat.o(249833);
      return;
    }
    if (this.ncM != null) {
      this.ncM.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Toast.makeText(this, e.i.plugin_qqmail_compose_send_success, 1).show();
      paramString = ((k)com.tencent.mm.kernel.h.ag(k.class)).getNormalMailAppService().Hmo;
      paramq = this.HoG;
      paramInt1 = this.HlJ;
      paramString = new com.tencent.mm.vfs.q(paramString.HlI.HlQ + com.tencent.mm.plugin.qqmail.d.h.fH(paramq, paramInt1));
      if (paramString.ifE()) {
        paramString.cFq();
      }
      this.HoD.gy(this.Hoo.getMailAddrs());
      this.HoD.gy(this.Hos.getMailAddrs());
      this.HoD.gy(this.Hov.getMailAddrs());
      setResult(-1);
      finish();
      AppMethodBeat.o(249833);
      return;
    }
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = getString(e.i.plugin_qqmail_compose_send_error);
    }
    Toast.makeText(this, paramq, 1).show();
    AppMethodBeat.o(249833);
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
        localObject1 = com.tencent.mm.pluginsdk.ui.tools.ab.bsd((String)localObject1);
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
          localObject3 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(Integer.valueOf((String)localObject3).intValue());
          localObject1 = new Intent(ComposeUI.this, MailImageDownloadUI.class);
          ((Intent)localObject1).putExtra("img_msg_id", ((et)localObject3).field_msgId);
          ((Intent)localObject1).putExtra("img_server_id", ((et)localObject3).field_msgSvrId);
          ((Intent)localObject1).putExtra("img_download_compress_type", 0);
          ((Intent)localObject1).putExtra("img_download_username", ((et)localObject3).field_talker);
          localObject3 = ComposeUI.this;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentChromeClient", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ComposeUI)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentChromeClient", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
            com.tencent.mm.pluginsdk.ui.tools.ab.b(ComposeUI.r(ComposeUI.this), ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this));
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
          break label705;
        }
      }
      catch (Exception paramConsoleMessage)
      {
        Log.w("MicroMsg.Mail.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", new Object[] { paramConsoleMessage.getMessage() });
        AppMethodBeat.o(122932);
        return true;
      }
      ComposeUI.q(ComposeUI.this);
      label705:
      AppMethodBeat.o(122932);
      return true;
    }
  }
  
  final class b
    extends ad
  {
    private boolean Hpq = false;
    
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
          paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(Integer.valueOf(paramString).intValue());
          paramWebView = new Intent(ComposeUI.this, MailImageDownloadUI.class);
          paramWebView.putExtra("img_msg_id", paramString.field_msgId);
          paramWebView.putExtra("img_server_id", paramString.field_msgSvrId);
          paramWebView.putExtra("img_download_compress_type", 0);
          paramWebView.putExtra("img_download_username", paramString.field_talker);
          paramString = ComposeUI.this;
          paramWebView = new com.tencent.mm.hellhoundlib.b.a().bm(paramWebView);
          com.tencent.mm.hellhoundlib.a.a.b(paramString, paramWebView.aFh(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramWebView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
            com.tencent.mm.pluginsdk.ui.tools.ab.b(ComposeUI.r(ComposeUI.this), ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this));
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
      Log.d("MicroMsg.Mail.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", new Object[] { paramString, Boolean.valueOf(this.Hpq) });
      if (!this.Hpq)
      {
        this.Hpq = true;
        com.tencent.mm.pluginsdk.ui.tools.ab.b(ComposeUI.r(ComposeUI.this), ComposeUI.m(ComposeUI.this), ComposeUI.w(ComposeUI.this));
        if (ComposeUI.this.getIntent().getBooleanExtra("mail_edit_mode", false)) {
          com.tencent.mm.pluginsdk.ui.tools.ab.b(ComposeUI.r(ComposeUI.this), ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this));
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
        com.tencent.mm.pluginsdk.ui.tools.ab.d(ComposeUI.r(ComposeUI.this));
        ComposeUI.v(ComposeUI.this);
      }
      AppMethodBeat.o(122934);
    }
  }
  
  final class c
    extends MailAddrsViewControl.c
  {
    private ImageView Hpr;
    private int tag;
    
    public c(ImageView paramImageView, int paramInt)
    {
      this.Hpr = paramImageView;
      this.tag = paramInt;
    }
    
    public final void wm(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(122937);
      ComposeUI.x(ComposeUI.this);
      Object localObject;
      if (ComposeUI.this.HoK) {
        localObject = this.Hpr;
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
              if ((!ComposeUI.e(ComposeUI.this).Hqw.isFocused()) && (!ComposeUI.f(ComposeUI.this).Hqw.isFocused()) && (ComposeUI.e(ComposeUI.this).getMailAddrs().size() == 0) && (ComposeUI.f(ComposeUI.this).getMailAddrs().size() == 0) && (ComposeUI.e(ComposeUI.this).fsX()) && (ComposeUI.f(ComposeUI.this).fsX()))
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
        ImageView localImageView = this.Hpr;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI
 * JD-Core Version:    0.7.0.1
 */