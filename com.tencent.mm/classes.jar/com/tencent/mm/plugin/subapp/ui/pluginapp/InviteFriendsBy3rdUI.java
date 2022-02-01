package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.e;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.o.a.a;
import com.tencent.mm.ui.o.a.b;
import com.tencent.mm.ui.o.a.c;

public class InviteFriendsBy3rdUI
  extends MMPreference
  implements i, a.a, a.b
{
  private static int FNf = 1;
  private static int FNg = 2;
  private static int FNh = 3;
  private static int FNi = 4;
  private static int FNj = 5;
  private static int FNk = 0;
  private static int FNl = 1;
  private com.tencent.mm.ui.o.a EPv;
  private int FNm;
  private Bitmap FNn;
  private View FNo;
  private ImageView FNp;
  private EditText FNq;
  private boolean FNr;
  private boolean FNs;
  private int fromScene;
  private ProgressDialog gtM;
  private ProgressBar mEz;
  private ProgressDialog vIA;
  
  public InviteFriendsBy3rdUI()
  {
    AppMethodBeat.i(29235);
    this.FNm = 0;
    this.gtM = null;
    this.vIA = null;
    this.FNn = null;
    this.FNp = null;
    this.mEz = null;
    this.FNq = null;
    this.EPv = new com.tencent.mm.ui.o.a();
    this.FNr = false;
    this.FNs = false;
    AppMethodBeat.o(29235);
  }
  
  private void E(final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(29244);
    this.FNo = View.inflate(getContext(), 2131493703, null);
    this.FNq = ((EditText)this.FNo.findViewById(2131299004));
    this.FNp = ((ImageView)this.FNo.findViewById(2131299001));
    this.mEz = ((ProgressBar)this.FNo.findViewById(2131303709));
    ((View)this.FNp.getParent()).setVisibility(8);
    this.FNq.setText(paramString1);
    this.FNn = ebs();
    if (this.FNn == null)
    {
      aSR(z.aTY());
      ((ProgressBar)this.FNo.findViewById(2131303709)).setVisibility(0);
    }
    for (;;)
    {
      o.a(this.mController, paramString2, this.FNo, getResources().getString(2131755976), new y.b()
      {
        public final void qB(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(29229);
          if (paramAnonymousBoolean)
          {
            if (InviteFriendsBy3rdUI.b(InviteFriendsBy3rdUI.this) == null) {}
            for (String str = paramString1;; str = InviteFriendsBy3rdUI.b(InviteFriendsBy3rdUI.this).getText().toString())
            {
              InviteFriendsBy3rdUI.a(InviteFriendsBy3rdUI.this, paramInt, str);
              AppMethodBeat.o(29229);
              return;
            }
          }
          AppMethodBeat.o(29229);
        }
      });
      AppMethodBeat.o(29244);
      return;
      if (this.FNp != null) {
        this.FNp.setImageBitmap(this.FNn);
      }
    }
  }
  
  private void Po(int paramInt)
  {
    AppMethodBeat.i(29242);
    com.tencent.mm.ui.base.h.a(getContext(), paramInt, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(29242);
  }
  
  /* Error */
  private static byte[] aCo(String paramString)
  {
    // Byte code:
    //   0: sipush 29246
    //   3: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 240	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: invokestatic 245	com/tencent/mm/model/c:aSY	()Ljava/lang/String;
    //   13: astore_1
    //   14: invokestatic 240	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   17: pop
    //   18: aload_1
    //   19: invokestatic 248	com/tencent/mm/model/c:aSZ	()Ljava/lang/String;
    //   22: ldc 250
    //   24: aload_0
    //   25: invokevirtual 256	java/lang/String:getBytes	()[B
    //   28: invokestatic 262	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   31: ldc_w 264
    //   34: iconst_1
    //   35: invokestatic 270	com/tencent/mm/sdk/platformtools/FilePathGenerator:defGenPathWithOld	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   38: astore_0
    //   39: aload_0
    //   40: iconst_0
    //   41: invokestatic 276	com/tencent/mm/vfs/s:dB	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   44: astore_1
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: invokevirtual 282	java/io/RandomAccessFile:length	()J
    //   51: l2i
    //   52: newarray byte
    //   54: astore_2
    //   55: aload_1
    //   56: astore_0
    //   57: aload_1
    //   58: aload_2
    //   59: invokevirtual 286	java/io/RandomAccessFile:read	([B)I
    //   62: pop
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 289	java/io/RandomAccessFile:close	()V
    //   71: sipush 29246
    //   74: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_2
    //   78: areturn
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: astore_0
    //   84: ldc_w 291
    //   87: aload_2
    //   88: ldc_w 293
    //   91: iconst_0
    //   92: anewarray 295	java/lang/Object
    //   95: invokestatic 301	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: aload_1
    //   99: ifnull +7 -> 106
    //   102: aload_1
    //   103: invokevirtual 289	java/io/RandomAccessFile:close	()V
    //   106: sipush 29246
    //   109: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_0
    //   117: aload_0
    //   118: ifnull +7 -> 125
    //   121: aload_0
    //   122: invokevirtual 289	java/io/RandomAccessFile:close	()V
    //   125: sipush 29246
    //   128: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_1
    //   132: athrow
    //   133: astore_0
    //   134: goto -63 -> 71
    //   137: astore_0
    //   138: goto -32 -> 106
    //   141: astore_0
    //   142: goto -17 -> 125
    //   145: astore_1
    //   146: goto -29 -> 117
    //   149: astore_2
    //   150: goto -68 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramString	String
    //   13	90	1	localObject1	Object
    //   114	18	1	localObject2	Object
    //   145	1	1	localObject3	Object
    //   54	24	2	arrayOfByte	byte[]
    //   79	9	2	localException1	java.lang.Exception
    //   149	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   39	45	79	java/lang/Exception
    //   39	45	114	finally
    //   67	71	133	java/lang/Exception
    //   102	106	137	java/lang/Exception
    //   121	125	141	java/lang/Exception
    //   47	55	145	finally
    //   57	63	145	finally
    //   84	98	145	finally
    //   47	55	149	java/lang/Exception
    //   57	63	149	java/lang/Exception
  }
  
  private static void aSR(String paramString)
  {
    AppMethodBeat.i(29247);
    bg.aVF();
    paramString = new com.tencent.mm.bc.a(paramString, Util.nullAsNil((Integer)com.tencent.mm.model.c.azQ().get(66561, null)));
    bg.azz().a(paramString, 0);
    AppMethodBeat.o(29247);
  }
  
  private void abo(int paramInt)
  {
    AppMethodBeat.i(29240);
    final e locale = new e(paramInt);
    getString(2131755998);
    this.gtM = com.tencent.mm.ui.base.h.a(this, getString(2131762446), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(29233);
        bg.azz().a(locale);
        AppMethodBeat.o(29233);
      }
    });
    bg.azz().a(locale, 0);
    AppMethodBeat.o(29240);
  }
  
  private static boolean checkApkExist(Context paramContext, String paramString)
  {
    AppMethodBeat.i(29241);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(29241);
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      AppMethodBeat.o(29241);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(29241);
    }
    return false;
  }
  
  private static Bitmap ebs()
  {
    AppMethodBeat.i(29245);
    Object localObject = aCo(z.aTY());
    if (localObject == null)
    {
      AppMethodBeat.o(29245);
      return null;
    }
    localObject = BitmapUtil.decodeByteArray((byte[])localObject);
    AppMethodBeat.o(29245);
    return localObject;
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(29243);
    if (this.vIA != null) {
      this.vIA.cancel();
    }
    switch (InviteFriendsBy3rdUI.3.yyh[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29243);
      return;
      Po(2131766888);
      AppMethodBeat.o(29243);
      return;
      AppMethodBeat.o(29243);
      return;
      Po(2131766887);
    }
  }
  
  public final void b(a.c paramc) {}
  
  public int getResourceId()
  {
    return 2132017228;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29236);
    super.onCreate(paramBundle);
    setMMTitle(2131759420);
    this.fromScene = getIntent().getIntExtra("Invite_friends", 4);
    int i = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("InviteFriendsInviteFlags"), 0);
    paramBundle = getPreferenceScreen();
    if ((i & 0x2) <= 0) {
      paramBundle.bmi("invite_friends_by_message");
    }
    if ((i & 0x1) <= 0) {
      paramBundle.bmi("invite_friends_by_mail");
    }
    if ((WeChatBrands.Business.Entries.Global3rdSrv.banned()) || ((i & 0x4) <= 0) || (!checkApkExist(getContext(), "com.whatsapp"))) {
      paramBundle.bmi("invite_friends_by_whatsapp");
    }
    if ((WeChatBrands.Business.Entries.Global3rdSrv.banned()) || ((i & 0x8) <= 0) || (!z.aUC())) {
      paramBundle.bmi("invite_friends_by_facebook");
    }
    if ((WeChatBrands.Business.Entries.Global3rdSrv.banned()) || ((i & 0x10) <= 0)) {
      paramBundle.bmi("invite_friends_by_twitter");
    }
    paramBundle.notifyDataSetChanged();
    bg.azz().a(1803, this);
    bg.azz().a(1804, this);
    bg.azz().a(168, this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29228);
        InviteFriendsBy3rdUI.this.finish();
        AppMethodBeat.o(29228);
        return true;
      }
    });
    AppMethodBeat.o(29236);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29237);
    bg.azz().b(1803, this);
    bg.azz().b(1804, this);
    bg.azz().b(168, this);
    if (this.FNm == 0) {
      com.tencent.mm.plugin.report.service.h.CyF.a(14035, new Object[] { Integer.valueOf(this.FNm), Integer.valueOf(FNk), Integer.valueOf(this.fromScene) });
    }
    super.onDestroy();
    AppMethodBeat.o(29237);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29238);
    if ("invite_friends_by_message".equals(paramPreference.mKey))
    {
      this.FNm = FNg;
      abo(2);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_mail".equals(paramPreference.mKey))
    {
      this.FNm = FNf;
      abo(1);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_whatsapp".equals(paramPreference.mKey))
    {
      this.FNm = FNh;
      abo(4);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_facebook".equals(paramPreference.mKey))
    {
      this.FNm = FNi;
      if (z.aUF())
      {
        this.FNs = true;
        abo(8);
      }
      for (;;)
      {
        AppMethodBeat.o(29238);
        return true;
        com.tencent.mm.ui.base.h.a(getContext(), 2131765389, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(29231);
            com.tencent.mm.br.c.b(InviteFriendsBy3rdUI.this.getContext(), "account", ".ui.FacebookAuthUI", new Intent());
            AppMethodBeat.o(29231);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
    }
    if ("invite_friends_by_twitter".equals(paramPreference.mKey))
    {
      this.FNm = FNj;
      if (this.EPv.gYx())
      {
        this.FNr = true;
        abo(16);
      }
      for (;;)
      {
        AppMethodBeat.o(29238);
        return true;
        com.tencent.mm.ui.base.h.a(getContext(), 2131765658, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(29232);
            paramAnonymousDialogInterface = InviteFriendsBy3rdUI.this;
            AppCompatActivity localAppCompatActivity = InviteFriendsBy3rdUI.this.getContext();
            InviteFriendsBy3rdUI.this.getContext().getString(2131755998);
            InviteFriendsBy3rdUI.a(paramAnonymousDialogInterface, com.tencent.mm.ui.base.h.a(localAppCompatActivity, InviteFriendsBy3rdUI.this.getContext().getString(2131766886), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface) {}
            }));
            InviteFriendsBy3rdUI.a(InviteFriendsBy3rdUI.this).a(InviteFriendsBy3rdUI.this, InviteFriendsBy3rdUI.this.getContext());
            AppMethodBeat.o(29232);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
    }
    AppMethodBeat.o(29238);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(29239);
    Log.i("MicroMsg.InviteFriendsBy3rdUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.service.h.CyF.a(14035, new Object[] { Integer.valueOf(this.FNm), Integer.valueOf(FNk), Integer.valueOf(this.fromScene) });
    }
    Object localObject1;
    label194:
    Object localObject2;
    Object localObject3;
    if (paramq.getType() == 1803)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.ui.base.h.n(getContext(), 2131762444, 2131755998);
        AppMethodBeat.o(29239);
        return;
      }
      paramString = (e)paramq;
      if (!Util.isNullOrNil(paramString.title)) {
        break label1072;
      }
      localObject1 = null;
      paramString = (e)paramq;
      if (!Util.isNullOrNil(paramString.content)) {
        break label1081;
      }
      paramString = null;
      localObject2 = z.aTZ();
      bg.aVF();
      localObject3 = (String)com.tencent.mm.model.c.azQ().get(6, null);
      if (!Util.isNullOrNil((String)localObject2)) {
        break label1290;
      }
      localObject2 = localObject3;
    }
    label1152:
    label1281:
    label1290:
    for (;;)
    {
      int i = ((e)paramq).jcv;
      if ((i & 0x1) > 0)
      {
        localObject3 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject3 = String.format(getString(2131761813), new Object[] { z.aUa() });
        }
        if (Util.isNullOrNil(paramString))
        {
          paramString = String.format(getString(2131761812), new Object[] { localObject2 });
          label307:
          localObject1 = new Intent("android.intent.action.SEND");
          ((Intent)localObject1).putExtra("android.intent.extra.SUBJECT", (String)localObject3);
          ((Intent)localObject1).putExtra("android.intent.extra.TEXT", paramString);
          ((Intent)localObject1).setType("plain/text");
          localObject1 = Intent.createChooser((Intent)localObject1, getString(2131761806));
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.CyF.a(14035, new Object[] { Integer.valueOf(this.FNm), Integer.valueOf(FNl), Integer.valueOf(this.fromScene) });
        }
      }
      for (;;)
      {
        localObject1 = paramString;
        if ((i & 0x2) > 0)
        {
          if (!Util.isNullOrNil(paramString)) {
            break label1281;
          }
          paramString = String.format(getString(2131761814), new Object[] { localObject2 });
        }
        label920:
        label1072:
        label1081:
        label1209:
        for (;;)
        {
          localObject1 = new Intent("android.intent.action.VIEW");
          ((Intent)localObject1).putExtra("sms_body", paramString);
          ((Intent)localObject1).setType("vnd.android-dir/mms-sms");
          if (Util.isIntentAvailable(this, (Intent)localObject1))
          {
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            label634:
            com.tencent.mm.plugin.report.service.h.CyF.a(14035, new Object[] { Integer.valueOf(this.FNm), Integer.valueOf(FNl), Integer.valueOf(this.fromScene) });
            localObject1 = paramString;
            paramString = (String)localObject1;
            if ((i & 0x4) > 0) {
              if (!Util.isNullOrNil((String)localObject1)) {
                break label1275;
              }
            }
          }
          label1103:
          label1128:
          label1275:
          for (paramString = String.format(getString(2131761814), new Object[] { localObject2 });; paramString = (String)localObject1)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).setAction("android.intent.action.SEND");
            ((Intent)localObject1).putExtra("android.intent.extra.TEXT", paramString);
            ((Intent)localObject1).setType("text/plain");
            ((Intent)localObject1).setPackage("com.whatsapp");
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.CyF.a(14035, new Object[] { Integer.valueOf(this.FNm), Integer.valueOf(FNl), Integer.valueOf(this.fromScene) });
            localObject2 = paramString;
            if ((i & 0x8) > 0)
            {
              localObject1 = paramString;
              if (Util.isNullOrNil(paramString))
              {
                if (!Util.isNullOrNil(z.aTZ())) {
                  break label1103;
                }
                localObject1 = getString(2131761811);
              }
              paramString = getString(2131761803);
              localObject2 = localObject1;
              if (this.FNs == true)
              {
                E(i, (String)localObject1, paramString);
                this.FNs = false;
                localObject2 = localObject1;
              }
            }
            if ((i & 0x10) > 0)
            {
              this.EPv.a(this);
              paramString = (String)localObject2;
              if (Util.isNullOrNil((String)localObject2)) {
                if (!Util.isNullOrNil(z.aTZ())) {
                  break label1128;
                }
              }
            }
            for (paramString = getString(2131761811);; paramString = String.format(getString(2131761810), new Object[] { z.aTZ() }))
            {
              localObject1 = getString(2131761808);
              if (this.FNr == true)
              {
                E(i, paramString, (String)localObject1);
                this.FNr = false;
              }
              if (paramq.getType() != 1804) {
                break label1209;
              }
              if ((paramInt1 == 0) && (paramInt2 == 0)) {
                break label1152;
              }
              com.tencent.mm.ui.base.h.n(getContext(), 2131765235, 2131755998);
              AppMethodBeat.o(29239);
              return;
              localObject1 = paramString.title;
              break;
              paramString = paramString.content;
              break label194;
              Toast.makeText(this, 2131765173, 1).show();
              break label634;
              localObject1 = String.format(getString(2131761810), new Object[] { z.aTZ() });
              break label920;
            }
            com.tencent.mm.ui.base.h.cD(this, getResources().getString(2131757788));
            com.tencent.mm.plugin.report.service.h.CyF.a(14035, new Object[] { Integer.valueOf(this.FNm), Integer.valueOf(FNl), Integer.valueOf(this.fromScene) });
            if (paramq.getType() == 168)
            {
              if ((paramInt1 != 0) || (paramInt2 != 0))
              {
                AppMethodBeat.o(29239);
                return;
              }
              if (this.FNp != null)
              {
                if (this.mEz != null) {
                  this.mEz.setVisibility(8);
                }
                this.FNp.setImageBitmap(ebs());
              }
            }
            AppMethodBeat.o(29239);
            return;
          }
        }
        break label307;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI
 * JD-Core Version:    0.7.0.1
 */