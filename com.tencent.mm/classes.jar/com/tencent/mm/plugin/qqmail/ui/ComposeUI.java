package com.tencent.mm.plugin.qqmail.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.qqmail.e.a;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.plugin.qqmail.model.ai;
import com.tencent.mm.plugin.qqmail.model.g;
import com.tencent.mm.plugin.qqmail.model.j;
import com.tencent.mm.plugin.qqmail.model.l;
import com.tencent.mm.plugin.qqmail.model.l.a;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.sensitive.d.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import com.tencent.xweb.ag;
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

@com.tencent.mm.ui.widget.pulldown.c(0)
public class ComposeUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private static List<com.tencent.mm.plugin.qqmail.model.k> NlZ;
  private com.tencent.mm.plugin.qqmail.model.aa Njb;
  private int Njx;
  private Map<String, String> Nks;
  private String NmA;
  private String NmB;
  private String NmC;
  private String NmD;
  private List<Bundle> NmE;
  private List<String> NmF;
  private String NmG;
  private String NmH;
  private String NmI;
  private boolean NmJ;
  private boolean NmK;
  private MTimerHandler NmL;
  private MTimerHandler NmM;
  l.a NmN;
  private View.OnClickListener NmO;
  private View.OnClickListener NmP;
  private MenuItem.OnMenuItemClickListener NmQ;
  private View.OnClickListener NmR;
  private ScrollView Nma;
  protected MailAddrsViewControl Nmb;
  private ImageView Nmc;
  private LinearLayout Nmd;
  private LinearLayout Nme;
  private MailAddrsViewControl Nmf;
  private ImageView Nmg;
  private LinearLayout Nmh;
  private MailAddrsViewControl Nmi;
  private ImageView Nmj;
  private EditText Nmk;
  private LinearLayout Nml;
  private TextView Nmm;
  private ImageView Nmn;
  private LinearLayout Nmo;
  private MMWebView Nmp;
  private l Nmq;
  private b Nmr;
  public c Nms;
  private String Nmt;
  private v Nmu;
  public boolean Nmv;
  public boolean Nmw;
  public boolean Nmx;
  private String Nmy;
  private String Nmz;
  private String hOG;
  private int mode;
  private w qbW;
  private EditText tID;
  
  public ComposeUI()
  {
    AppMethodBeat.i(122938);
    this.Nms = new c(this);
    this.Njx = 1;
    this.Nmv = true;
    this.Nmw = true;
    this.Nmx = false;
    this.Nmy = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    this.Nmz = "document.getElementById('history').innerHTML";
    this.NmA = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    this.NmB = "</div>";
    this.NmC = null;
    this.mode = 20;
    this.Nks = new HashMap();
    this.Njb = ((j)com.tencent.mm.kernel.h.az(j.class)).getShareModeMailAppService();
    this.NmD = null;
    this.NmE = null;
    this.NmF = null;
    this.NmG = "weixin://get_img_info/";
    this.NmH = "weixin://get_mail_content/";
    this.NmI = "weixin://img_onclick/";
    this.NmJ = false;
    this.NmK = false;
    this.NmL = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(122892);
        ComposeUI.this.enableOptionMenu(ComposeUI.a(ComposeUI.this, true));
        AppMethodBeat.o(122892);
        return true;
      }
    }, true);
    this.NmM = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(122909);
        if ((ComposeUI.this.Nmv) && (ComposeUI.a(ComposeUI.this, false)) && (ComposeUI.a(ComposeUI.this) == 20))
        {
          ComposeUI.b(ComposeUI.this);
          if (ComposeUI.c(ComposeUI.this) != null) {
            ComposeUI.c(ComposeUI.this).dismiss();
          }
          ComposeUI.a(ComposeUI.this, com.tencent.mm.ui.base.aa.a(ComposeUI.this, ComposeUI.this.getString(e.i.plugin_qqmail_composeui_auto_save), 2000L));
        }
        AppMethodBeat.o(122909);
        return true;
      }
    }, true);
    this.NmN = new l.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(122920);
        Log.i("MicroMsg.Mail.ComposeUI", "sync addr complete");
        MailAddrsViewControl.b localb = new MailAddrsViewControl.b(ComposeUI.this, ComposeUI.d(ComposeUI.this).aSm(null));
        ComposeUI.this.Nmb.setAddrsAdapter(localb);
        ComposeUI.e(ComposeUI.this).setAddrsAdapter(localb);
        ComposeUI.f(ComposeUI.this).setAddrsAdapter(localb);
        AppMethodBeat.o(122920);
      }
    };
    this.NmO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(266927);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ComposeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ComposeUI.y(ComposeUI.this).setVisibility(8);
        ComposeUI.z(ComposeUI.this).setVisibility(0);
        ComposeUI.A(ComposeUI.this).setVisibility(0);
        ComposeUI.y(ComposeUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(266937);
            ComposeUI.z(ComposeUI.this).requestFocus();
            ComposeUI.e(ComposeUI.this).gEK();
            ComposeUI.f(ComposeUI.this).gEK();
            AppMethodBeat.o(266937);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(266927);
      }
    };
    this.NmP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122899);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ComposeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = ComposeUI.this;
        localObject = ComposeUI.this.getString(e.i.plugin_qqmail_composeui_attach_take_phote);
        String str1 = ComposeUI.this.getString(e.i.plugin_qqmail_composeui_attach_choose_album);
        String str2 = ComposeUI.this.getString(e.i.plugin_qqmail_composeui_attach_choose_file);
        k.d local1 = new k.d()
        {
          public final void qz(int paramAnonymous2Int)
          {
            AppMethodBeat.i(266998);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(266998);
              return;
              boolean bool = com.tencent.mm.pluginsdk.permission.b.a(ComposeUI.this.getContext(), "android.permission.CAMERA", 16, "");
              Log.i("MicroMsg.Mail.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), ComposeUI.this.getContext() });
              if (!bool)
              {
                AppMethodBeat.o(266998);
                return;
              }
              ComposeUI.B(ComposeUI.this);
              AppMethodBeat.o(266998);
              return;
              t.d(ComposeUI.this, 4, null);
              AppMethodBeat.o(266998);
              return;
              final Intent localIntent = new Intent(ComposeUI.this, FileExplorerUI.class);
              if (((com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class)).checkAndShowPermissionDialog(d.c.actw, new d.f()
              {
                public final void onOp(Boolean paramAnonymous3Boolean)
                {
                  AppMethodBeat.i(266992);
                  if (paramAnonymous3Boolean.booleanValue()) {
                    ComposeUI.this.startActivityForResult(localIntent, 5);
                  }
                  AppMethodBeat.o(266992);
                }
              }))
              {
                AppMethodBeat.o(266998);
                return;
              }
              ComposeUI.this.startActivityForResult(localIntent, 5);
            }
          }
        };
        com.tencent.mm.ui.base.k.a(paramAnonymousView, null, new String[] { localObject, str1, str2 }, null, local1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122899);
      }
    };
    this.NmQ = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(266938);
        if (((ComposeUI.a(ComposeUI.this, false)) && (ComposeUI.a(ComposeUI.this) == 20)) || (ComposeUI.a(ComposeUI.this) == 21)) {
          com.tencent.mm.ui.base.k.b(ComposeUI.this.getContext(), ComposeUI.this.getString(e.i.plugin_qqmail_composeui_leave_alert), "", ComposeUI.this.getString(e.i.plugin_qqmail_composeui_quit_delete), ComposeUI.this.getString(e.i.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(266993);
              ComposeUI.this.setResult(0);
              ComposeUI.this.finish();
              AppMethodBeat.o(266993);
            }
          }, null);
        }
        for (;;)
        {
          AppMethodBeat.o(266938);
          return true;
          ComposeUI.this.setResult(0);
          ComposeUI.this.finish();
        }
      }
    };
    this.NmR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(266947);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        ComposeUI.this.hideVKB();
        ComposeUI.j(ComposeUI.this).getText();
        ComposeUI.C(ComposeUI.this);
        if (!ComposeUI.this.gEr())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(266947);
          return;
        }
        paramAnonymousView = ComposeUI.p(ComposeUI.this).entrySet().iterator();
        while (paramAnonymousView.hasNext())
        {
          Object localObject2 = (Map.Entry)paramAnonymousView.next();
          localObject1 = ComposeUI.D(ComposeUI.this);
          localObject2 = (String)((Map.Entry)localObject2).getValue();
          Log.i("MicroMsg.Mail.FileUploadHelper", "uploadContentImage path=%s", new Object[] { localObject2 });
          if ((localObject2 != null) && (((String)localObject2).length() != 0) && (!((b)localObject1).NnI.containsKey(localObject2)))
          {
            com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u((String)localObject2);
            if ((localu.jKS()) && (localu.jKV()))
            {
              ai localai = new ai();
              localai.path = ((String)localObject2);
              localai.name = localu.getName();
              localai.size = localu.length();
              localai.state = 0;
              ((b)localObject1).NnI.put(localObject2, localai);
              if (localai.state == 0) {
                localai.Bjl = ((b)localObject1).aSs(localai.path);
              }
            }
          }
        }
        paramAnonymousView = ComposeUI.this;
        localObject1 = ComposeUI.this;
        ComposeUI.this.getString(e.i.app_tip);
        ComposeUI.a(paramAnonymousView, com.tencent.mm.ui.base.k.a((Context)localObject1, ComposeUI.this.getString(e.i.plugin_qqmail_compose_send_ing), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(267013);
            ComposeUI.D(ComposeUI.this).gEC();
            ComposeUI.D(ComposeUI.this).NnL = null;
            AppMethodBeat.o(267013);
          }
        }));
        if (!ComposeUI.D(ComposeUI.this).gED())
        {
          ComposeUI.E(ComposeUI.this).setMessage(ComposeUI.this.getString(e.i.plugin_qqmail_attach_uploading));
          ComposeUI.D(ComposeUI.this).NnL = new b.b()
          {
            public final void gEs()
            {
              AppMethodBeat.i(267015);
              ComposeUI.E(ComposeUI.this).setMessage(ComposeUI.this.getString(e.i.plugin_qqmail_attach_uploading));
              AppMethodBeat.o(267015);
            }
            
            public final void onComplete()
            {
              AppMethodBeat.i(267017);
              ComposeUI.b(ComposeUI.this, ComposeUI.q(ComposeUI.this));
              AppMethodBeat.o(267017);
            }
          };
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(266947);
          return;
          ComposeUI.b(ComposeUI.this, ComposeUI.q(ComposeUI.this));
        }
      }
    };
    AppMethodBeat.o(122938);
  }
  
  private static List<com.tencent.mm.plugin.qqmail.model.k> O(String[] paramArrayOfString)
  {
    AppMethodBeat.i(267027);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        com.tencent.mm.plugin.qqmail.model.k localk = l.aSn(paramArrayOfString[i]);
        if (localk != null) {
          localArrayList.add(localk);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(267027);
    return localArrayList;
  }
  
  private static void a(MailAddrsViewControl paramMailAddrsViewControl)
  {
    AppMethodBeat.i(122952);
    if (NlZ == null)
    {
      AppMethodBeat.o(122952);
      return;
    }
    paramMailAddrsViewControl.setMailAdds(NlZ);
    AppMethodBeat.o(122952);
  }
  
  private void aSp(final String paramString)
  {
    AppMethodBeat.i(122954);
    final com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u(paramString);
    if (!localu.jKS())
    {
      AppMethodBeat.o(122954);
      return;
    }
    if (this.Nmr.Te(paramString))
    {
      com.tencent.mm.ui.base.k.s(getContext(), e.i.plugin_qqmail_upload_attach_exist, e.i.app_tip);
      AppMethodBeat.o(122954);
      return;
    }
    final int i = (int)localu.length();
    if (i > 20971520)
    {
      com.tencent.mm.ui.base.k.a(this, e.i.plugin_qqmail_upload_attach_single_file_size_exceed, e.i.app_tip, null);
      AppMethodBeat.o(122954);
      return;
    }
    com.tencent.mm.ui.base.k.a(this, getString(e.i.plugin_qqmail_upload_attach_size_tip, new Object[] { Util.getSizeKB(i) }), getString(e.i.app_tip), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(266946);
        if (ComposeUI.D(ComposeUI.this).getTotalSize() + i > 52428800)
        {
          com.tencent.mm.ui.base.k.a(ComposeUI.this, e.i.plugin_qqmail_upload_attach_size_exceed, e.i.app_tip, null);
          AppMethodBeat.o(266946);
          return;
        }
        Object localObject;
        if (ComposeUI.j(ComposeUI.this).getText().toString().trim().length() == 0)
        {
          paramAnonymousDialogInterface = localu.getName().trim();
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
          if ((localObject != null) && (((String)localObject).length() != 0) && (!paramAnonymousDialogInterface.NnI.containsKey(localObject))) {
            break;
          }
          AppMethodBeat.o(266946);
          return;
          label175:
          paramAnonymousInt = paramAnonymousDialogInterface.length();
        }
        com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u((String)localObject);
        if ((!localu.jKS()) || (!localu.jKV()))
        {
          AppMethodBeat.o(266946);
          return;
        }
        ai localai = new ai();
        localai.path = ((String)localObject);
        localai.name = localu.getName();
        localai.size = localu.length();
        localai.state = 0;
        paramAnonymousDialogInterface.NnI.put(localObject, localai);
        paramAnonymousDialogInterface.a(localai);
        AppMethodBeat.o(266946);
      }
    }, null);
    AppMethodBeat.o(122954);
  }
  
  private void fBt()
  {
    AppMethodBeat.i(122947);
    if (!t.d(this, com.tencent.mm.loader.i.b.bmL(), "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
      Toast.makeText(this, getString(e.i.selectcameraapp_none), 1).show();
    }
    AppMethodBeat.o(122947);
  }
  
  private void gEo()
  {
    AppMethodBeat.i(122943);
    this.Nmb.clearFocus();
    this.Nmf.clearFocus();
    this.Nmi.clearFocus();
    AppMethodBeat.o(122943);
  }
  
  private void gEp()
  {
    AppMethodBeat.i(122945);
    if (this.Nmp != null)
    {
      this.Nmp.clearFocus();
      this.Nmp.getSettings().setJavaScriptEnabled(true);
      this.Nmp.setWebViewClient(new b((byte)0));
      this.Nmp.setWebChromeClient(new a((byte)0));
      this.Nmp.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(266924);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(266924);
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
  
  private String gEq()
  {
    AppMethodBeat.i(122949);
    Object localObject = new StringBuilder(this.tID.getText().toString());
    com.tencent.mm.pluginsdk.ui.tools.aa.b(this.Nmp, this.NmH, this.Nmz);
    if (!Util.isNullOrNil(this.NmD))
    {
      int i = this.NmD.indexOf(this.NmA);
      int j = this.NmD.lastIndexOf(this.NmB);
      if ((i == -1) || (j == -1)) {
        break label136;
      }
      String str = this.NmD.substring(i + this.NmA.length(), j + this.NmB.length());
      ((StringBuilder)localObject).append("\n").append(str);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(122949);
      return localObject;
      label136:
      ((StringBuilder)localObject).append("\n").append(this.NmD);
    }
  }
  
  static void jA(List<com.tencent.mm.plugin.qqmail.model.k> paramList)
  {
    NlZ = paramList;
  }
  
  private static ArrayList<Bundle> jz(List<com.tencent.mm.plugin.qqmail.model.k> paramList)
  {
    AppMethodBeat.i(267042);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.qqmail.model.k localk = (com.tencent.mm.plugin.qqmail.model.k)paramList.next();
      Bundle localBundle = new Bundle();
      localBundle.putString("item_addr", localk.KbS);
      localBundle.putString("item_name", localk.name);
      localArrayList.add(localBundle);
    }
    AppMethodBeat.o(267042);
    return localArrayList;
  }
  
  protected final boolean gEr()
  {
    AppMethodBeat.i(122951);
    if (!this.Nmb.gEJ())
    {
      Toast.makeText(this, e.i.plugin_qqmail_composeui_toaddr_invalid, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (!this.Nmf.gEJ())
    {
      Toast.makeText(this, e.i.plugin_qqmail_composeui_ccaddr_invalid, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (!this.Nmi.gEJ())
    {
      Toast.makeText(this, e.i.plugin_qqmail_composeui_bccaddr_invalid, 1).show();
      AppMethodBeat.o(122951);
      return false;
    }
    if (this.Nmb.getMailAddrs().size() + this.Nmf.getMailAddrs().size() + this.Nmi.getMailAddrs().size() > 20)
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
    this.Nma = ((ScrollView)findViewById(e.e.qqmail_compose_container_sv));
    this.Nmb = ((MailAddrsViewControl)findViewById(e.e.qqmail_compose_addr_to_control));
    this.Nmc = ((ImageView)findViewById(e.e.qqmail_compose_add_to_iv));
    this.Nmd = ((LinearLayout)findViewById(e.e.qqmail_compose_ccbacc_ll));
    this.Nme = ((LinearLayout)findViewById(e.e.qqmail_compose_addr_cc_fl));
    this.Nmf = ((MailAddrsViewControl)findViewById(e.e.qqmail_compose_addr_cc_control));
    this.Nmg = ((ImageView)findViewById(e.e.qqmail_compose_add_cc_iv));
    this.Nmh = ((LinearLayout)findViewById(e.e.qqmail_compose_addr_bcc_fl));
    this.Nmi = ((MailAddrsViewControl)findViewById(e.e.qqmail_compose_addr_bcc_control));
    this.Nmj = ((ImageView)findViewById(e.e.qqmail_compose_add_bcc_iv));
    this.Nmk = ((EditText)findViewById(e.e.qqmail_compose_subject_et));
    this.Nml = ((LinearLayout)findViewById(e.e.qqmail_compose_add_attach_ll));
    this.tID = ((EditText)findViewById(e.e.qqmail_compose_content_et));
    this.Nmp = MMWebView.a.u(this, e.e.qqmail_compose_content_web);
    this.Nmm = ((TextView)findViewById(e.e.qqmail_compose_attach_summary_iv));
    this.Nmn = ((ImageView)findViewById(e.e.qqmail_compose_attach_summary_icon));
    this.Nmo = ((LinearLayout)findViewById(e.e.plugin_qqmail_compose_attachment_container));
    this.Nmb.setEditable(true);
    this.Nmf.setEditable(true);
    this.Nmi.setEditable(true);
    Object localObject2 = getIntent().getStringExtra("mail_content");
    this.NmE = getIntent().getParcelableArrayListExtra("mail_attach");
    this.NmF = getIntent().getStringArrayListExtra("mail_attach_file");
    Object localObject1 = ((j)com.tencent.mm.kernel.h.az(j.class)).getNormalMailAppService().Nkc.gy(this.Nmt, this.Njx);
    this.Nmr = new b(this, this.Nmm, this.Nmn, this.Nmo, (byte)0);
    Object localObject3;
    Object localObject4;
    if (!Util.isNullOrNil((String)localObject2)) {
      if (this.mode == 21)
      {
        gEp();
        this.Nmb.requestFocus();
        this.NmD = String.format(this.NmC, new Object[] { localObject2 });
        this.Nmp.loadDataWithBaseURL("", this.NmD, "text/html", "utf-8", "");
        this.Nmp.setVisibility(0);
        if (this.Njx == 1) {
          break label1512;
        }
        localObject1 = getIntent().getStringArrayExtra("toList");
        localObject3 = getIntent().getStringArrayExtra("ccList");
        localObject4 = getIntent().getStringArrayExtra("bccList");
        localObject2 = getIntent().getStringExtra("subject");
        this.Nmb.y(O((String[])localObject1), false);
        this.Nmf.y(O((String[])localObject3), false);
        this.Nmi.y(O((String[])localObject4), false);
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject3 = this.Nmk;
          localObject4 = new StringBuilder();
          if (this.Njx != 2) {
            break label1084;
          }
        }
      }
    }
    label1084:
    for (localObject1 = "Re:";; localObject1 = "Fwd:")
    {
      ((EditText)localObject3).setText((String)localObject1 + (String)localObject2);
      if (this.NmE == null) {
        break label1108;
      }
      localObject1 = new ArrayList();
      localObject2 = this.NmE.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Bundle)((Iterator)localObject2).next();
        localObject4 = new ai();
        ((ai)localObject4).name = ((Bundle)localObject3).getString("attach_name");
        StringBuilder localStringBuilder = new StringBuilder();
        ((j)com.tencent.mm.kernel.h.az(j.class)).getNormalMailAppService();
        ((ai)localObject4).path = (com.tencent.mm.plugin.qqmail.model.u.gEb() + ((ai)localObject4).name);
        ((ai)localObject4).state = 2;
        ((ai)localObject4).size = ((Bundle)localObject3).getInt("attach_size");
        ((ai)localObject4).svrId = ((Bundle)localObject3).getString("attach_fileId");
        ((List)localObject1).add(localObject4);
      }
      if (this.mode != 20) {
        break;
      }
      this.tID.setVisibility(0);
      this.Nmp.setVisibility(8);
      if (((String)localObject2).indexOf("<div>") != -1)
      {
        Log.i("MicroMsg.Mail.ComposeUI", "set content in html format");
        this.tID.setText(Html.fromHtml((String)localObject2));
        break;
      }
      this.tID.setText((CharSequence)localObject2);
      break;
      if ((localObject1 != null) && (this.mode == 21))
      {
        Log.i("MicroMsg.Mail.ComposeUI", "read mail from draftMail");
        this.Nmb.y(((com.tencent.mm.plugin.qqmail.model.h)localObject1).Njy, false);
        this.Nmf.y(((com.tencent.mm.plugin.qqmail.model.h)localObject1).Njz, false);
        this.Nmi.y(((com.tencent.mm.plugin.qqmail.model.h)localObject1).NjA, false);
        this.Nmk.setText(((com.tencent.mm.plugin.qqmail.model.h)localObject1).Hox);
        localObject2 = ((com.tencent.mm.plugin.qqmail.model.h)localObject1).content;
        this.mode = 20;
        if (((String)localObject2).indexOf("<div>") != -1)
        {
          Log.i("MicroMsg.Mail.ComposeUI", "set content in html format");
          this.tID.setText(Html.fromHtml((String)localObject2));
        }
        for (;;)
        {
          this.Nmr.jB(((com.tencent.mm.plugin.qqmail.model.h)localObject1).NjB);
          this.Nmr.gEE();
          this.Nmp.setVisibility(8);
          this.tID.setVisibility(0);
          break;
          this.tID.setText((CharSequence)localObject2);
        }
      }
      Log.i("MicroMsg.Mail.ComposeUI", "no extra or draf mail content");
      if (this.mode == 21)
      {
        gEp();
        this.Nmb.requestFocus();
        this.NmD = String.format(this.NmC, new Object[] { "" });
        this.Nmp.loadDataWithBaseURL("", this.NmD, "text/html", "utf-8", "");
        this.tID.setVisibility(8);
        this.Nmp.setVisibility(0);
        break;
      }
      if (this.mode != 20) {
        break;
      }
      this.Nmp.setVisibility(8);
      this.tID.setVisibility(0);
      break;
    }
    if (!((List)localObject1).isEmpty()) {
      this.Nmr.jB((List)localObject1);
    }
    for (;;)
    {
      label1108:
      if ((this.Nmf.getMailAddrs().size() > 0) || (this.Nmi.getMailAddrs().size() > 0))
      {
        this.Nmd.setVisibility(8);
        this.Nme.setVisibility(0);
        this.Nmh.setVisibility(0);
      }
      if ((this.Njx == 2) && (this.mode != 21) && (this.mode == 20))
      {
        this.tID.requestFocus();
        this.tID.setSelection(0);
        this.Nma.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(122921);
            ComposeUI.g(ComposeUI.this).fullScroll(130);
            AppMethodBeat.o(122921);
          }
        }, 1000L);
      }
      this.Nmb.setOnActionListener(new c(this.Nmc, 0));
      this.Nmf.setOnActionListener(new c(this.Nmg, 1));
      this.Nmi.setOnActionListener(new c(this.Nmj, 2));
      localObject1 = new MailAddrsViewControl.a()
      {
        public final void b(final MailAddrsViewControl paramAnonymousMailAddrsViewControl)
        {
          AppMethodBeat.i(122926);
          com.tencent.mm.ui.base.k.a(ComposeUI.this.getContext(), ComposeUI.this.getString(e.i.plugin_qqmail_mail_addr_format_invalid), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(122923);
              paramAnonymousMailAddrsViewControl.Nok.setText("");
              ComposeUI.i(ComposeUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(122922);
                  ComposeUI.h(ComposeUI.this);
                  ComposeUI.15.1.this.Nna.requestFocus();
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
                  ComposeUI.15.2.this.Nna.requestFocus();
                  ComposeUI.this.showVKB();
                  AppMethodBeat.o(122924);
                }
              }, 150L);
              AppMethodBeat.o(122925);
            }
          });
          AppMethodBeat.o(122926);
        }
        
        public final void gEt()
        {
          AppMethodBeat.i(122927);
          com.tencent.mm.ui.base.aa.a(ComposeUI.this, ComposeUI.this.getString(e.i.plugin_qqmail_mail_addr_format_invalid), 1500L);
          AppMethodBeat.o(122927);
        }
      };
      this.Nmb.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
      this.Nmf.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
      this.Nmi.setInvalidMailAddrListener((MailAddrsViewControl.a)localObject1);
      this.Nmc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122928);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ComposeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new Intent(ComposeUI.this, MailAddrListUI.class);
          paramAnonymousView.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.Nmb.getMailAddrStringArray());
          paramAnonymousView.putExtra("MMActivity.OverrideExitAnimation", e.a.push_down_out);
          paramAnonymousView.putExtra("MMActivity.OverrideEnterAnimation", e.a.fast_faded_in);
          ComposeUI.this.startActivityForResult(paramAnonymousView, 0);
          BackwardSupportUtil.AnimationHelper.overridePendingTransition(ComposeUI.this, e.a.push_up_in, e.a.fast_faded_out);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122928);
        }
      });
      this.Nmg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122929);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ComposeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
      this.Nmj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122930);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ComposeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
      this.Nmd.setOnClickListener(this.NmO);
      localObject1 = (ImageView)findViewById(e.e.qqmail_compose_subject_clear_iv);
      if ((this.Nmw) && (this.Nmk.getText().length() > 0)) {
        ((ImageView)localObject1).setVisibility(0);
      }
      this.Nmk.setOnFocusChangeListener(new View.OnFocusChangeListener()
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
      this.Nmk.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          paramAnonymousInt1 = 4;
          AppMethodBeat.i(122893);
          if (ComposeUI.this.Nmw)
          {
            paramAnonymousCharSequence = this.NmT;
            if (ComposeUI.j(ComposeUI.this).getText().length() > 0) {
              paramAnonymousInt1 = 0;
            }
            paramAnonymousCharSequence.setVisibility(paramAnonymousInt1);
            AppMethodBeat.o(122893);
            return;
          }
          this.NmT.setVisibility(4);
          AppMethodBeat.o(122893);
        }
      });
      ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(122894);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/ComposeUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          ComposeUI.j(ComposeUI.this).getText().clear();
          ComposeUI.j(ComposeUI.this).requestFocus();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122894);
        }
      });
      this.Nml.setOnClickListener(this.NmP);
      setMMTitle(e.i.plugin_qqmail_composeui_title);
      setBackBtn(this.NmQ);
      addTextOptionMenu(0, getString(e.i.app_send), new MenuItem.OnMenuItemClickListener()
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
      gEo();
      AppMethodBeat.o(122944);
      return;
      label1512:
      localObject1 = getIntent().getStringExtra("subject");
      if (!Util.isNullOrNil((String)localObject1)) {
        this.Nmk.setText((CharSequence)localObject1);
      }
      if (this.NmF != null)
      {
        localObject1 = this.NmF.iterator();
        while (((Iterator)localObject1).hasNext()) {
          aSp((String)((Iterator)localObject1).next());
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
      a(this.Nmb);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      a(this.Nmf);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      a(this.Nmi);
      showVKB();
      AppMethodBeat.o(122953);
      return;
      paramIntent = t.g(this, paramIntent, com.tencent.mm.plugin.image.d.bzL());
      if (paramIntent != null)
      {
        aSp(paramIntent);
        gEo();
        AppMethodBeat.o(122953);
        return;
        if (paramIntent != null)
        {
          paramIntent = com.tencent.mm.ui.tools.b.i(this, paramIntent, com.tencent.mm.plugin.image.d.bzL());
          if ((paramIntent != null) && (paramIntent.length() > 0))
          {
            aSp(paramIntent);
            gEo();
            AppMethodBeat.o(122953);
            return;
            if (paramIntent != null)
            {
              aSp(paramIntent.getStringExtra("choosed_file_path"));
              gEo();
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
    this.NmC = (this.NmA + "%s" + this.NmB);
    this.NmJ = false;
    this.NmK = false;
    this.Njx = getIntent().getIntExtra("composeType", 1);
    this.Nmt = getIntent().getStringExtra("mailid");
    if (this.Nmt == null) {
      this.Nmt = "";
    }
    this.mode = getIntent().getIntExtra("mail_mode", 20);
    Log.d("MicroMsg.Mail.ComposeUI", "onCreate, mode = %d", new Object[] { Integer.valueOf(this.mode) });
    initView();
    this.Nmq = ((j)com.tencent.mm.kernel.h.az(j.class)).getNormalMailAppService().Nkb;
    this.Nmq.a(this.NmN);
    this.Nmq.gDW();
    this.NmM.startTimer(180000L);
    com.tencent.mm.kernel.h.aZW().a(11166, this);
    AppMethodBeat.o(122939);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122942);
    super.onDestroy();
    if (NlZ != null) {
      NlZ = null;
    }
    this.Nmr.gEC();
    b localb = this.Nmr;
    com.tencent.mm.kernel.h.baD().mCm.b(11665, localb);
    this.Nmq.b(this.NmN);
    this.Nms.release();
    com.tencent.mm.kernel.h.aZW().b(11166, this);
    this.NmM.stopTimer();
    AppMethodBeat.o(122942);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(122946);
    if (paramInt == 4)
    {
      this.NmQ.onMenuItemClick(null);
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
    this.NmL.stopTimer();
    if (this.Nmu != null) {
      this.Nmu.dismiss();
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
        fBt();
        AppMethodBeat.o(122948);
        return;
      }
      com.tencent.mm.ui.base.k.a(this, getString(e.i.permission_camera_request_again_msg), getString(e.i.permission_tips_title), getString(e.i.jump_to_settings), getString(e.i.app_cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(266941);
          com.tencent.mm.pluginsdk.permission.b.lx(ComposeUI.this.getContext());
          AppMethodBeat.o(266941);
        }
      }, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(122940);
    super.onResume();
    this.NmL.startTimer(1500L);
    AppMethodBeat.o(122940);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(267109);
    Log.i("MicroMsg.Mail.ComposeUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!((com.tencent.mm.plugin.qqmail.d.d)paramp).hOG.equals(this.hOG))
    {
      Log.w("MicroMsg.Mail.ComposeUI", "not current request, ignore");
      AppMethodBeat.o(267109);
      return;
    }
    if (this.qbW != null) {
      this.qbW.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Toast.makeText(this, e.i.plugin_qqmail_compose_send_success, 1).show();
      paramString = ((j)com.tencent.mm.kernel.h.az(j.class)).getNormalMailAppService().Nkc;
      paramp = this.Nmt;
      paramInt1 = this.Njx;
      paramString = new com.tencent.mm.vfs.u(paramString.Njw.NjE + g.gz(paramp, paramInt1));
      if (paramString.jKS()) {
        paramString.diJ();
      }
      this.Nmq.jy(this.Nmb.getMailAddrs());
      this.Nmq.jy(this.Nmf.getMailAddrs());
      this.Nmq.jy(this.Nmi.getMailAddrs());
      setResult(-1);
      finish();
      AppMethodBeat.o(267109);
      return;
    }
    paramp = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramp = getString(e.i.plugin_qqmail_compose_send_error);
    }
    Toast.makeText(this, paramp, 1).show();
    AppMethodBeat.o(267109);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setRequestedOrientation(int paramInt) {}
  
  final class a
    extends z
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
        localObject1 = com.tencent.mm.pluginsdk.ui.tools.aa.brU((String)localObject1);
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
          localObject3 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(Integer.valueOf((String)localObject3).intValue());
          localObject1 = new Intent(ComposeUI.this, MailImageDownloadUI.class);
          ((Intent)localObject1).putExtra("img_msg_id", ((fi)localObject3).field_msgId);
          ((Intent)localObject1).putExtra("img_server_id", ((fi)localObject3).field_msgSvrId);
          ((Intent)localObject1).putExtra("img_download_compress_type", 0);
          ((Intent)localObject1).putExtra("img_download_username", ((fi)localObject3).field_talker);
          localObject3 = ComposeUI.this;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentChromeClient", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ComposeUI)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
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
            com.tencent.mm.pluginsdk.ui.tools.aa.b(ComposeUI.r(ComposeUI.this), ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this));
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
    extends ag
  {
    private boolean Nne = false;
    
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
          paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(Integer.valueOf(paramString).intValue());
          paramWebView = new Intent(ComposeUI.this, MailImageDownloadUI.class);
          paramWebView.putExtra("img_msg_id", paramString.field_msgId);
          paramWebView.putExtra("img_server_id", paramString.field_msgSvrId);
          paramWebView.putExtra("img_download_compress_type", 0);
          paramWebView.putExtra("img_download_username", paramString.field_talker);
          paramString = ComposeUI.this;
          paramWebView = new com.tencent.mm.hellhoundlib.b.a().cG(paramWebView);
          com.tencent.mm.hellhoundlib.a.a.b(paramString, paramWebView.aYi(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramWebView.sb(0));
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
            com.tencent.mm.pluginsdk.ui.tools.aa.b(ComposeUI.r(ComposeUI.this), ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this));
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
      Log.d("MicroMsg.Mail.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", new Object[] { paramString, Boolean.valueOf(this.Nne) });
      if (!this.Nne)
      {
        this.Nne = true;
        com.tencent.mm.pluginsdk.ui.tools.aa.b(ComposeUI.r(ComposeUI.this), ComposeUI.m(ComposeUI.this), ComposeUI.w(ComposeUI.this));
        if (ComposeUI.this.getIntent().getBooleanExtra("mail_edit_mode", false)) {
          com.tencent.mm.pluginsdk.ui.tools.aa.b(ComposeUI.r(ComposeUI.this), ComposeUI.s(ComposeUI.this), ComposeUI.t(ComposeUI.this));
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
        com.tencent.mm.pluginsdk.ui.tools.aa.e(ComposeUI.r(ComposeUI.this));
        ComposeUI.v(ComposeUI.this);
      }
      AppMethodBeat.o(122934);
    }
  }
  
  final class c
    extends MailAddrsViewControl.c
  {
    private ImageView Nnf;
    private int tag;
    
    public c(ImageView paramImageView, int paramInt)
    {
      this.Nnf = paramImageView;
      this.tag = paramInt;
    }
    
    public final void AM(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(122937);
      ComposeUI.x(ComposeUI.this);
      Object localObject;
      if (ComposeUI.this.Nmx) {
        localObject = this.Nnf;
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
              if ((!ComposeUI.e(ComposeUI.this).Nok.isFocused()) && (!ComposeUI.f(ComposeUI.this).Nok.isFocused()) && (ComposeUI.e(ComposeUI.this).getMailAddrs().size() == 0) && (ComposeUI.f(ComposeUI.this).getMailAddrs().size() == 0) && (ComposeUI.e(ComposeUI.this).gEG()) && (ComposeUI.f(ComposeUI.this).gEG()))
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
        ImageView localImageView = this.Nnf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI
 * JD-Core Version:    0.7.0.1
 */