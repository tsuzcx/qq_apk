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
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.k.a.a;
import com.tencent.mm.ui.k.a.b;
import com.tencent.mm.ui.k.a.c;

public class InviteFriendsBy3rdUI
  extends MMPreference
  implements com.tencent.mm.al.g, a.a, a.b
{
  private static int yGb = 1;
  private static int yGc = 2;
  private static int yGd = 3;
  private static int yGe = 4;
  private static int yGf = 5;
  private static int yGg = 0;
  private static int yGh = 1;
  private ProgressDialog fpP;
  private int fromScene;
  private ProgressBar kuP;
  private ProgressDialog qLE;
  private com.tencent.mm.ui.k.a xKc;
  private int yGi;
  private Bitmap yGj;
  private View yGk;
  private ImageView yGl;
  private EditText yGm;
  private boolean yGn;
  private boolean yGo;
  
  public InviteFriendsBy3rdUI()
  {
    AppMethodBeat.i(29235);
    this.yGi = 0;
    this.fpP = null;
    this.qLE = null;
    this.yGj = null;
    this.yGl = null;
    this.kuP = null;
    this.yGm = null;
    this.xKc = new com.tencent.mm.ui.k.a();
    this.yGn = false;
    this.yGo = false;
    AppMethodBeat.o(29235);
  }
  
  private void C(final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(29244);
    this.yGk = View.inflate(getContext(), 2131493586, null);
    this.yGm = ((EditText)this.yGk.findViewById(2131298569));
    this.yGl = ((ImageView)this.yGk.findViewById(2131298566));
    this.kuP = ((ProgressBar)this.yGk.findViewById(2131301506));
    ((View)this.yGl.getParent()).setVisibility(8);
    this.yGm.setText(paramString1);
    this.yGj = cIl();
    if (this.yGj == null)
    {
      asq(u.aqG());
      ((ProgressBar)this.yGk.findViewById(2131301506)).setVisibility(0);
    }
    for (;;)
    {
      o.a(this.mController, paramString2, this.yGk, getResources().getString(2131755884), new y.b()
      {
        public final void mB(boolean paramAnonymousBoolean)
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
      if (this.yGl != null) {
        this.yGl.setImageBitmap(this.yGj);
      }
    }
  }
  
  private void Fw(int paramInt)
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
  
  private void OV(int paramInt)
  {
    AppMethodBeat.i(29240);
    com.tencent.mm.modelmulti.e locale = new com.tencent.mm.modelmulti.e(paramInt);
    getString(2131755906);
    this.fpP = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new InviteFriendsBy3rdUI.8(this, locale));
    az.aeS().a(locale, 0);
    AppMethodBeat.o(29240);
  }
  
  /* Error */
  private static byte[] aen(String paramString)
  {
    // Byte code:
    //   0: sipush 29246
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 244	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: invokestatic 249	com/tencent/mm/model/c:apW	()Ljava/lang/String;
    //   13: astore_1
    //   14: invokestatic 244	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
    //   17: pop
    //   18: aload_1
    //   19: invokestatic 252	com/tencent/mm/model/c:apX	()Ljava/lang/String;
    //   22: ldc 254
    //   24: aload_0
    //   25: invokevirtual 260	java/lang/String:getBytes	()[B
    //   28: invokestatic 266	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   31: ldc_w 268
    //   34: invokestatic 274	com/tencent/mm/sdk/platformtools/l:j	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: astore_0
    //   38: aload_0
    //   39: iconst_0
    //   40: invokestatic 280	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   43: astore_1
    //   44: aload_1
    //   45: astore_0
    //   46: aload_1
    //   47: invokevirtual 286	java/io/RandomAccessFile:length	()J
    //   50: l2i
    //   51: newarray byte
    //   53: astore_2
    //   54: aload_1
    //   55: astore_0
    //   56: aload_1
    //   57: aload_2
    //   58: invokevirtual 290	java/io/RandomAccessFile:read	([B)I
    //   61: pop
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 293	java/io/RandomAccessFile:close	()V
    //   70: sipush 29246
    //   73: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_2
    //   77: areturn
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: astore_0
    //   83: ldc_w 295
    //   86: aload_2
    //   87: ldc_w 297
    //   90: iconst_0
    //   91: anewarray 299	java/lang/Object
    //   94: invokestatic 305	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_1
    //   98: ifnull +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 293	java/io/RandomAccessFile:close	()V
    //   105: sipush 29246
    //   108: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_1
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_0
    //   117: ifnull +7 -> 124
    //   120: aload_0
    //   121: invokevirtual 293	java/io/RandomAccessFile:close	()V
    //   124: sipush 29246
    //   127: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_1
    //   131: athrow
    //   132: astore_0
    //   133: goto -63 -> 70
    //   136: astore_0
    //   137: goto -32 -> 105
    //   140: astore_0
    //   141: goto -17 -> 124
    //   144: astore_1
    //   145: goto -29 -> 116
    //   148: astore_2
    //   149: goto -68 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramString	String
    //   13	89	1	localObject1	Object
    //   113	18	1	localObject2	Object
    //   144	1	1	localObject3	Object
    //   53	24	2	arrayOfByte	byte[]
    //   78	9	2	localException1	java.lang.Exception
    //   148	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   38	44	78	java/lang/Exception
    //   38	44	113	finally
    //   66	70	132	java/lang/Exception
    //   101	105	136	java/lang/Exception
    //   120	124	140	java/lang/Exception
    //   46	54	144	finally
    //   56	62	144	finally
    //   83	97	144	finally
    //   46	54	148	java/lang/Exception
    //   56	62	148	java/lang/Exception
  }
  
  private static void asq(String paramString)
  {
    AppMethodBeat.i(29247);
    az.arV();
    paramString = new com.tencent.mm.bd.a(paramString, bt.l((Integer)c.afk().get(66561, null)));
    az.aeS().a(paramString, 0);
    AppMethodBeat.o(29247);
  }
  
  private static Bitmap cIl()
  {
    AppMethodBeat.i(29245);
    Object localObject = aen(u.aqG());
    if (localObject == null)
    {
      AppMethodBeat.o(29245);
      return null;
    }
    localObject = com.tencent.mm.sdk.platformtools.f.cl((byte[])localObject);
    AppMethodBeat.o(29245);
    return localObject;
  }
  
  private static boolean checkApkExist(Context paramContext, String paramString)
  {
    AppMethodBeat.i(29241);
    if (bt.isNullOrNil(paramString))
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
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(29243);
    if (this.qLE != null) {
      this.qLE.cancel();
    }
    switch (3.sJC[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29243);
      return;
      Fw(2131764543);
      AppMethodBeat.o(29243);
      return;
      AppMethodBeat.o(29243);
      return;
      Fw(2131764542);
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
    int i = bt.getInt(com.tencent.mm.m.g.Zd().getValue("InviteFriendsInviteFlags"), 0);
    paramBundle = getPreferenceScreen();
    if ((i & 0x2) <= 0) {
      paramBundle.aKl("invite_friends_by_message");
    }
    if ((i & 0x1) <= 0) {
      paramBundle.aKl("invite_friends_by_mail");
    }
    if (((i & 0x4) <= 0) || (!checkApkExist(getContext(), "com.whatsapp"))) {
      paramBundle.aKl("invite_friends_by_whatsapp");
    }
    if (((i & 0x8) <= 0) || (!u.arg())) {
      paramBundle.aKl("invite_friends_by_facebook");
    }
    if ((i & 0x10) <= 0) {
      paramBundle.aKl("invite_friends_by_twitter");
    }
    paramBundle.notifyDataSetChanged();
    az.aeS().a(1803, this);
    az.aeS().a(1804, this);
    az.aeS().a(168, this);
    setBackBtn(new InviteFriendsBy3rdUI.1(this));
    AppMethodBeat.o(29236);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29237);
    az.aeS().b(1803, this);
    az.aeS().b(1804, this);
    az.aeS().b(168, this);
    if (this.yGi == 0) {
      com.tencent.mm.plugin.report.service.h.vKh.f(14035, new Object[] { Integer.valueOf(this.yGi), Integer.valueOf(yGg), Integer.valueOf(this.fromScene) });
    }
    super.onDestroy();
    AppMethodBeat.o(29237);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29238);
    if ("invite_friends_by_message".equals(paramPreference.mKey))
    {
      this.yGi = yGc;
      OV(2);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_mail".equals(paramPreference.mKey))
    {
      this.yGi = yGb;
      OV(1);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_whatsapp".equals(paramPreference.mKey))
    {
      this.yGi = yGd;
      OV(4);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_facebook".equals(paramPreference.mKey))
    {
      this.yGi = yGe;
      if (u.arj())
      {
        this.yGo = true;
        OV(8);
      }
      for (;;)
      {
        AppMethodBeat.o(29238);
        return true;
        com.tencent.mm.ui.base.h.a(getContext(), 2131763220, 2131755906, new InviteFriendsBy3rdUI.4(this), new InviteFriendsBy3rdUI.5(this));
      }
    }
    if ("invite_friends_by_twitter".equals(paramPreference.mKey))
    {
      this.yGi = yGf;
      if (this.xKc.feC())
      {
        this.yGn = true;
        OV(16);
      }
      for (;;)
      {
        AppMethodBeat.o(29238);
        return true;
        com.tencent.mm.ui.base.h.a(getContext(), 2131763475, 2131755906, new DialogInterface.OnClickListener()new InviteFriendsBy3rdUI.7
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
        }, new InviteFriendsBy3rdUI.7(this));
      }
    }
    AppMethodBeat.o(29238);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29239);
    ad.i("MicroMsg.InviteFriendsBy3rdUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.service.h.vKh.f(14035, new Object[] { Integer.valueOf(this.yGi), Integer.valueOf(yGg), Integer.valueOf(this.fromScene) });
    }
    Object localObject1;
    label194:
    Object localObject2;
    Object localObject3;
    if (paramn.getType() == 1803)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.ui.base.h.j(getContext(), 2131760707, 2131755906);
        AppMethodBeat.o(29239);
        return;
      }
      paramString = (com.tencent.mm.modelmulti.e)paramn;
      if (!bt.isNullOrNil(paramString.title)) {
        break label1072;
      }
      localObject1 = null;
      paramString = (com.tencent.mm.modelmulti.e)paramn;
      if (!bt.isNullOrNil(paramString.content)) {
        break label1081;
      }
      paramString = null;
      localObject2 = u.aqH();
      az.arV();
      localObject3 = (String)c.afk().get(6, null);
      if (!bt.isNullOrNil((String)localObject2)) {
        break label1290;
      }
      localObject2 = localObject3;
    }
    label1152:
    label1281:
    label1290:
    for (;;)
    {
      int i = ((com.tencent.mm.modelmulti.e)paramn).hll;
      if ((i & 0x1) > 0)
      {
        localObject3 = localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          localObject3 = String.format(getString(2131760368), new Object[] { u.aqI() });
        }
        if (bt.isNullOrNil(paramString))
        {
          paramString = String.format(getString(2131760367), new Object[] { localObject2 });
          label307:
          localObject1 = new Intent("android.intent.action.SEND");
          ((Intent)localObject1).putExtra("android.intent.extra.SUBJECT", (String)localObject3);
          ((Intent)localObject1).putExtra("android.intent.extra.TEXT", paramString);
          ((Intent)localObject1).setType("plain/text");
          localObject1 = Intent.createChooser((Intent)localObject1, getString(2131760361));
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.vKh.f(14035, new Object[] { Integer.valueOf(this.yGi), Integer.valueOf(yGh), Integer.valueOf(this.fromScene) });
        }
      }
      for (;;)
      {
        localObject1 = paramString;
        if ((i & 0x2) > 0)
        {
          if (!bt.isNullOrNil(paramString)) {
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
          if (bt.T(this, (Intent)localObject1))
          {
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            label634:
            com.tencent.mm.plugin.report.service.h.vKh.f(14035, new Object[] { Integer.valueOf(this.yGi), Integer.valueOf(yGh), Integer.valueOf(this.fromScene) });
            localObject1 = paramString;
            paramString = (String)localObject1;
            if ((i & 0x4) > 0) {
              if (!bt.isNullOrNil((String)localObject1)) {
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
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.vKh.f(14035, new Object[] { Integer.valueOf(this.yGi), Integer.valueOf(yGh), Integer.valueOf(this.fromScene) });
            localObject2 = paramString;
            if ((i & 0x8) > 0)
            {
              localObject1 = paramString;
              if (bt.isNullOrNil(paramString))
              {
                if (!bt.isNullOrNil(u.aqH())) {
                  break label1103;
                }
                localObject1 = getString(2131760366);
              }
              paramString = getString(2131760358);
              localObject2 = localObject1;
              if (this.yGo == true)
              {
                C(i, (String)localObject1, paramString);
                this.yGo = false;
                localObject2 = localObject1;
              }
            }
            if ((i & 0x10) > 0)
            {
              this.xKc.a(this);
              paramString = (String)localObject2;
              if (bt.isNullOrNil((String)localObject2)) {
                if (!bt.isNullOrNil(u.aqH())) {
                  break label1128;
                }
              }
            }
            for (paramString = getString(2131760366);; paramString = String.format(getString(2131760365), new Object[] { u.aqH() }))
            {
              localObject1 = getString(2131760363);
              if (this.yGn == true)
              {
                C(i, paramString, (String)localObject1);
                this.yGn = false;
              }
              if (paramn.getType() != 1804) {
                break label1209;
              }
              if ((paramInt1 == 0) && (paramInt2 == 0)) {
                break label1152;
              }
              com.tencent.mm.ui.base.h.j(getContext(), 2131763075, 2131755906);
              AppMethodBeat.o(29239);
              return;
              localObject1 = paramString.title;
              break;
              paramString = paramString.content;
              break label194;
              Toast.makeText(this, 2131763024, 1).show();
              break label634;
              localObject1 = String.format(getString(2131760365), new Object[] { u.aqH() });
              break label920;
            }
            com.tencent.mm.ui.base.h.cf(this, getResources().getString(2131757561));
            com.tencent.mm.plugin.report.service.h.vKh.f(14035, new Object[] { Integer.valueOf(this.yGi), Integer.valueOf(yGh), Integer.valueOf(this.fromScene) });
            if (paramn.getType() == 168)
            {
              if ((paramInt1 != 0) || (paramInt2 != 0))
              {
                AppMethodBeat.o(29239);
                return;
              }
              if (this.yGl != null)
              {
                if (this.kuP != null) {
                  this.kuP.setVisibility(8);
                }
                this.yGl.setImageBitmap(cIl());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI
 * JD-Core Version:    0.7.0.1
 */