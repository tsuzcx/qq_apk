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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.k.a.a;
import com.tencent.mm.ui.k.a.b;
import com.tencent.mm.ui.k.a.c;

public class InviteFriendsBy3rdUI
  extends MMPreference
  implements com.tencent.mm.ak.f, a.a, a.b
{
  private static int BCt = 1;
  private static int BCu = 2;
  private static int BCv = 3;
  private static int BCw = 4;
  private static int BCx = 5;
  private static int BCy = 0;
  private static int BCz = 1;
  private com.tencent.mm.ui.k.a AFP;
  private int BCA;
  private Bitmap BCB;
  private View BCC;
  private ImageView BCD;
  private EditText BCE;
  private boolean BCF;
  private boolean BCG;
  private ProgressDialog fOC;
  private int fromScene;
  private ProgressBar lxB;
  private ProgressDialog sMH;
  
  public InviteFriendsBy3rdUI()
  {
    AppMethodBeat.i(29235);
    this.BCA = 0;
    this.fOC = null;
    this.sMH = null;
    this.BCB = null;
    this.BCD = null;
    this.lxB = null;
    this.BCE = null;
    this.AFP = new com.tencent.mm.ui.k.a();
    this.BCF = false;
    this.BCG = false;
    AppMethodBeat.o(29235);
  }
  
  private void B(final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(29244);
    this.BCC = View.inflate(getContext(), 2131493586, null);
    this.BCE = ((EditText)this.BCC.findViewById(2131298569));
    this.BCD = ((ImageView)this.BCC.findViewById(2131298566));
    this.lxB = ((ProgressBar)this.BCC.findViewById(2131301506));
    ((View)this.BCD.getParent()).setVisibility(8);
    this.BCE.setText(paramString1);
    this.BCB = dhz();
    if (this.BCB == null)
    {
      aDW(v.aAC());
      ((ProgressBar)this.BCC.findViewById(2131301506)).setVisibility(0);
    }
    for (;;)
    {
      o.a(this.mController, paramString2, this.BCC, getResources().getString(2131755884), new y.b()
      {
        public final void nS(boolean paramAnonymousBoolean)
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
      if (this.BCD != null) {
        this.BCD.setImageBitmap(this.BCB);
      }
    }
  }
  
  private void Jl(int paramInt)
  {
    AppMethodBeat.i(29242);
    com.tencent.mm.ui.base.h.a(getContext(), paramInt, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(29242);
  }
  
  private void Ts(int paramInt)
  {
    AppMethodBeat.i(29240);
    final com.tencent.mm.modelmulti.e locale = new com.tencent.mm.modelmulti.e(paramInt);
    getString(2131755906);
    this.fOC = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(29233);
        bc.ajj().a(locale);
        AppMethodBeat.o(29233);
      }
    });
    bc.ajj().a(locale, 0);
    AppMethodBeat.o(29240);
  }
  
  private static void aDW(String paramString)
  {
    AppMethodBeat.i(29247);
    bc.aCg();
    paramString = new com.tencent.mm.bc.a(paramString, bu.o((Integer)c.ajA().get(66561, null)));
    bc.ajj().a(paramString, 0);
    AppMethodBeat.o(29247);
  }
  
  /* Error */
  private static byte[] aoU(String paramString)
  {
    // Byte code:
    //   0: sipush 29246
    //   3: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 246	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: invokestatic 278	com/tencent/mm/model/c:azQ	()Ljava/lang/String;
    //   13: astore_1
    //   14: invokestatic 246	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
    //   17: pop
    //   18: aload_1
    //   19: invokestatic 281	com/tencent/mm/model/c:azR	()Ljava/lang/String;
    //   22: ldc_w 283
    //   25: aload_0
    //   26: invokevirtual 289	java/lang/String:getBytes	()[B
    //   29: invokestatic 295	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   32: ldc_w 297
    //   35: invokestatic 303	com/tencent/mm/sdk/platformtools/n:j	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_0
    //   39: aload_0
    //   40: iconst_0
    //   41: invokestatic 309	com/tencent/mm/vfs/o:dg	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   44: astore_1
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: invokevirtual 315	java/io/RandomAccessFile:length	()J
    //   51: l2i
    //   52: newarray byte
    //   54: astore_2
    //   55: aload_1
    //   56: astore_0
    //   57: aload_1
    //   58: aload_2
    //   59: invokevirtual 319	java/io/RandomAccessFile:read	([B)I
    //   62: pop
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 322	java/io/RandomAccessFile:close	()V
    //   71: sipush 29246
    //   74: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_2
    //   78: areturn
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: astore_0
    //   84: ldc_w 324
    //   87: aload_2
    //   88: ldc_w 326
    //   91: iconst_0
    //   92: anewarray 328	java/lang/Object
    //   95: invokestatic 334	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: aload_1
    //   99: ifnull +7 -> 106
    //   102: aload_1
    //   103: invokevirtual 322	java/io/RandomAccessFile:close	()V
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
    //   122: invokevirtual 322	java/io/RandomAccessFile:close	()V
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
  
  private static boolean checkApkExist(Context paramContext, String paramString)
  {
    AppMethodBeat.i(29241);
    if (bu.isNullOrNil(paramString))
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
  
  private static Bitmap dhz()
  {
    AppMethodBeat.i(29245);
    Object localObject = aoU(v.aAC());
    if (localObject == null)
    {
      AppMethodBeat.o(29245);
      return null;
    }
    localObject = com.tencent.mm.sdk.platformtools.h.cu((byte[])localObject);
    AppMethodBeat.o(29245);
    return localObject;
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(29243);
    if (this.sMH != null) {
      this.sMH.cancel();
    }
    switch (InviteFriendsBy3rdUI.3.vfI[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29243);
      return;
      Jl(2131764543);
      AppMethodBeat.o(29243);
      return;
      AppMethodBeat.o(29243);
      return;
      Jl(2131764542);
    }
  }
  
  public final void b(a.c paramc) {}
  
  public int getResourceId()
  {
    return 2131951686;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29236);
    super.onCreate(paramBundle);
    setMMTitle(2131759087);
    this.fromScene = getIntent().getIntExtra("Invite_friends", 4);
    int i = bu.getInt(com.tencent.mm.n.g.acL().getValue("InviteFriendsInviteFlags"), 0);
    paramBundle = getPreferenceScreen();
    if ((i & 0x2) <= 0) {
      paramBundle.aXf("invite_friends_by_message");
    }
    if ((i & 0x1) <= 0) {
      paramBundle.aXf("invite_friends_by_mail");
    }
    if (((i & 0x4) <= 0) || (!checkApkExist(getContext(), "com.whatsapp"))) {
      paramBundle.aXf("invite_friends_by_whatsapp");
    }
    if (((i & 0x8) <= 0) || (!v.aBf())) {
      paramBundle.aXf("invite_friends_by_facebook");
    }
    if ((i & 0x10) <= 0) {
      paramBundle.aXf("invite_friends_by_twitter");
    }
    paramBundle.notifyDataSetChanged();
    bc.ajj().a(1803, this);
    bc.ajj().a(1804, this);
    bc.ajj().a(168, this);
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
    bc.ajj().b(1803, this);
    bc.ajj().b(1804, this);
    bc.ajj().b(168, this);
    if (this.BCA == 0) {
      com.tencent.mm.plugin.report.service.g.yxI.f(14035, new Object[] { Integer.valueOf(this.BCA), Integer.valueOf(BCy), Integer.valueOf(this.fromScene) });
    }
    super.onDestroy();
    AppMethodBeat.o(29237);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29238);
    if ("invite_friends_by_message".equals(paramPreference.mKey))
    {
      this.BCA = BCu;
      Ts(2);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_mail".equals(paramPreference.mKey))
    {
      this.BCA = BCt;
      Ts(1);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_whatsapp".equals(paramPreference.mKey))
    {
      this.BCA = BCv;
      Ts(4);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_facebook".equals(paramPreference.mKey))
    {
      this.BCA = BCw;
      if (v.aBi())
      {
        this.BCG = true;
        Ts(8);
      }
      for (;;)
      {
        AppMethodBeat.o(29238);
        return true;
        com.tencent.mm.ui.base.h.a(getContext(), 2131763220, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(29231);
            d.b(InviteFriendsBy3rdUI.this.getContext(), "account", ".ui.FacebookAuthUI", new Intent());
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
      this.BCA = BCx;
      if (this.AFP.fPD())
      {
        this.BCF = true;
        Ts(16);
      }
      for (;;)
      {
        AppMethodBeat.o(29238);
        return true;
        com.tencent.mm.ui.base.h.a(getContext(), 2131763475, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(29232);
            paramAnonymousDialogInterface = InviteFriendsBy3rdUI.this;
            AppCompatActivity localAppCompatActivity = InviteFriendsBy3rdUI.this.getContext();
            InviteFriendsBy3rdUI.this.getContext().getString(2131755906);
            InviteFriendsBy3rdUI.a(paramAnonymousDialogInterface, com.tencent.mm.ui.base.h.b(localAppCompatActivity, InviteFriendsBy3rdUI.this.getContext().getString(2131764541), true, new DialogInterface.OnCancelListener()
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29239);
    ae.i("MicroMsg.InviteFriendsBy3rdUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.service.g.yxI.f(14035, new Object[] { Integer.valueOf(this.BCA), Integer.valueOf(BCy), Integer.valueOf(this.fromScene) });
    }
    Object localObject1;
    label194:
    Object localObject2;
    Object localObject3;
    if (paramn.getType() == 1803)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.ui.base.h.l(getContext(), 2131760707, 2131755906);
        AppMethodBeat.o(29239);
        return;
      }
      paramString = (com.tencent.mm.modelmulti.e)paramn;
      if (!bu.isNullOrNil(paramString.title)) {
        break label1072;
      }
      localObject1 = null;
      paramString = (com.tencent.mm.modelmulti.e)paramn;
      if (!bu.isNullOrNil(paramString.content)) {
        break label1081;
      }
      paramString = null;
      localObject2 = v.aAD();
      bc.aCg();
      localObject3 = (String)c.ajA().get(6, null);
      if (!bu.isNullOrNil((String)localObject2)) {
        break label1290;
      }
      localObject2 = localObject3;
    }
    label1152:
    label1281:
    label1290:
    for (;;)
    {
      int i = ((com.tencent.mm.modelmulti.e)paramn).ihA;
      if ((i & 0x1) > 0)
      {
        localObject3 = localObject1;
        if (bu.isNullOrNil((String)localObject1)) {
          localObject3 = String.format(getString(2131760368), new Object[] { v.aAE() });
        }
        if (bu.isNullOrNil(paramString))
        {
          paramString = String.format(getString(2131760367), new Object[] { localObject2 });
          label307:
          localObject1 = new Intent("android.intent.action.SEND");
          ((Intent)localObject1).putExtra("android.intent.extra.SUBJECT", (String)localObject3);
          ((Intent)localObject1).putExtra("android.intent.extra.TEXT", paramString);
          ((Intent)localObject1).setType("plain/text");
          localObject1 = Intent.createChooser((Intent)localObject1, getString(2131760361));
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.g.yxI.f(14035, new Object[] { Integer.valueOf(this.BCA), Integer.valueOf(BCz), Integer.valueOf(this.fromScene) });
        }
      }
      for (;;)
      {
        localObject1 = paramString;
        if ((i & 0x2) > 0)
        {
          if (!bu.isNullOrNil(paramString)) {
            break label1281;
          }
          paramString = String.format(getString(2131760369), new Object[] { localObject2 });
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
          if (bu.aj(this, (Intent)localObject1))
          {
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            label634:
            com.tencent.mm.plugin.report.service.g.yxI.f(14035, new Object[] { Integer.valueOf(this.BCA), Integer.valueOf(BCz), Integer.valueOf(this.fromScene) });
            localObject1 = paramString;
            paramString = (String)localObject1;
            if ((i & 0x4) > 0) {
              if (!bu.isNullOrNil((String)localObject1)) {
                break label1275;
              }
            }
          }
          label1103:
          label1128:
          label1275:
          for (paramString = String.format(getString(2131760369), new Object[] { localObject2 });; paramString = (String)localObject1)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).setAction("android.intent.action.SEND");
            ((Intent)localObject1).putExtra("android.intent.extra.TEXT", paramString);
            ((Intent)localObject1).setType("text/plain");
            ((Intent)localObject1).setPackage("com.whatsapp");
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.g.yxI.f(14035, new Object[] { Integer.valueOf(this.BCA), Integer.valueOf(BCz), Integer.valueOf(this.fromScene) });
            localObject2 = paramString;
            if ((i & 0x8) > 0)
            {
              localObject1 = paramString;
              if (bu.isNullOrNil(paramString))
              {
                if (!bu.isNullOrNil(v.aAD())) {
                  break label1103;
                }
                localObject1 = getString(2131760366);
              }
              paramString = getString(2131760358);
              localObject2 = localObject1;
              if (this.BCG == true)
              {
                B(i, (String)localObject1, paramString);
                this.BCG = false;
                localObject2 = localObject1;
              }
            }
            if ((i & 0x10) > 0)
            {
              this.AFP.a(this);
              paramString = (String)localObject2;
              if (bu.isNullOrNil((String)localObject2)) {
                if (!bu.isNullOrNil(v.aAD())) {
                  break label1128;
                }
              }
            }
            for (paramString = getString(2131760366);; paramString = String.format(getString(2131760365), new Object[] { v.aAD() }))
            {
              localObject1 = getString(2131760363);
              if (this.BCF == true)
              {
                B(i, paramString, (String)localObject1);
                this.BCF = false;
              }
              if (paramn.getType() != 1804) {
                break label1209;
              }
              if ((paramInt1 == 0) && (paramInt2 == 0)) {
                break label1152;
              }
              com.tencent.mm.ui.base.h.l(getContext(), 2131763075, 2131755906);
              AppMethodBeat.o(29239);
              return;
              localObject1 = paramString.title;
              break;
              paramString = paramString.content;
              break label194;
              Toast.makeText(this, 2131763024, 1).show();
              break label634;
              localObject1 = String.format(getString(2131760365), new Object[] { v.aAD() });
              break label920;
            }
            com.tencent.mm.ui.base.h.cm(this, getResources().getString(2131757561));
            com.tencent.mm.plugin.report.service.g.yxI.f(14035, new Object[] { Integer.valueOf(this.BCA), Integer.valueOf(BCz), Integer.valueOf(this.fromScene) });
            if (paramn.getType() == 168)
            {
              if ((paramInt1 != 0) || (paramInt2 != 0))
              {
                AppMethodBeat.o(29239);
                return;
              }
              if (this.BCD != null)
              {
                if (this.lxB != null) {
                  this.lxB.setVisibility(8);
                }
                this.BCD.setImageBitmap(dhz());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI
 * JD-Core Version:    0.7.0.1
 */