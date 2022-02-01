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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.k.a.a;
import com.tencent.mm.ui.k.a.b;
import com.tencent.mm.ui.k.a.c;

public class InviteFriendsBy3rdUI
  extends MMPreference
  implements com.tencent.mm.al.f, a.a, a.b
{
  private static int BkU = 1;
  private static int BkV = 2;
  private static int BkW = 3;
  private static int BkX = 4;
  private static int BkY = 5;
  private static int BkZ = 0;
  private static int Bla = 1;
  private com.tencent.mm.ui.k.a AoC;
  private int Blb;
  private Bitmap Blc;
  private View Bld;
  private ImageView Ble;
  private EditText Blf;
  private boolean Blg;
  private boolean Blh;
  private ProgressDialog fMu;
  private int fromScene;
  private ProgressBar ltc;
  private ProgressDialog sBI;
  
  public InviteFriendsBy3rdUI()
  {
    AppMethodBeat.i(29235);
    this.Blb = 0;
    this.fMu = null;
    this.sBI = null;
    this.Blc = null;
    this.Ble = null;
    this.ltc = null;
    this.Blf = null;
    this.AoC = new com.tencent.mm.ui.k.a();
    this.Blg = false;
    this.Blh = false;
    AppMethodBeat.o(29235);
  }
  
  private void B(final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(29244);
    this.Bld = View.inflate(getContext(), 2131493586, null);
    this.Blf = ((EditText)this.Bld.findViewById(2131298569));
    this.Ble = ((ImageView)this.Bld.findViewById(2131298566));
    this.ltc = ((ProgressBar)this.Bld.findViewById(2131301506));
    ((View)this.Ble.getParent()).setVisibility(8);
    this.Blf.setText(paramString1);
    this.Blc = deH();
    if (this.Blc == null)
    {
      aCD(u.aAm());
      ((ProgressBar)this.Bld.findViewById(2131301506)).setVisibility(0);
    }
    for (;;)
    {
      o.a(this.mController, paramString2, this.Bld, getResources().getString(2131755884), new y.b()
      {
        public final void nO(boolean paramAnonymousBoolean)
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
      if (this.Ble != null) {
        this.Ble.setImageBitmap(this.Blc);
      }
    }
  }
  
  private void IN(int paramInt)
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
  
  private void SL(int paramInt)
  {
    AppMethodBeat.i(29240);
    final com.tencent.mm.modelmulti.e locale = new com.tencent.mm.modelmulti.e(paramInt);
    getString(2131755906);
    this.fMu = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(29233);
        ba.aiU().a(locale);
        AppMethodBeat.o(29233);
      }
    });
    ba.aiU().a(locale, 0);
    AppMethodBeat.o(29240);
  }
  
  private static void aCD(String paramString)
  {
    AppMethodBeat.i(29247);
    ba.aBQ();
    paramString = new com.tencent.mm.bd.a(paramString, bt.n((Integer)c.ajl().get(66561, null)));
    ba.aiU().a(paramString, 0);
    AppMethodBeat.o(29247);
  }
  
  /* Error */
  private static byte[] anS(String paramString)
  {
    // Byte code:
    //   0: sipush 29246
    //   3: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 246	com/tencent/mm/model/ba:aBQ	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: invokestatic 279	com/tencent/mm/model/c:azA	()Ljava/lang/String;
    //   13: astore_1
    //   14: invokestatic 246	com/tencent/mm/model/ba:aBQ	()Lcom/tencent/mm/model/c;
    //   17: pop
    //   18: aload_1
    //   19: invokestatic 282	com/tencent/mm/model/c:azB	()Ljava/lang/String;
    //   22: ldc_w 284
    //   25: aload_0
    //   26: invokevirtual 290	java/lang/String:getBytes	()[B
    //   29: invokestatic 296	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   32: ldc_w 298
    //   35: invokestatic 304	com/tencent/mm/sdk/platformtools/m:j	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_0
    //   39: aload_0
    //   40: iconst_0
    //   41: invokestatic 310	com/tencent/mm/vfs/i:dd	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   44: astore_1
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: invokevirtual 316	java/io/RandomAccessFile:length	()J
    //   51: l2i
    //   52: newarray byte
    //   54: astore_2
    //   55: aload_1
    //   56: astore_0
    //   57: aload_1
    //   58: aload_2
    //   59: invokevirtual 320	java/io/RandomAccessFile:read	([B)I
    //   62: pop
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 323	java/io/RandomAccessFile:close	()V
    //   71: sipush 29246
    //   74: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_2
    //   78: areturn
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: astore_0
    //   84: ldc_w 325
    //   87: aload_2
    //   88: ldc_w 327
    //   91: iconst_0
    //   92: anewarray 329	java/lang/Object
    //   95: invokestatic 335	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: aload_1
    //   99: ifnull +7 -> 106
    //   102: aload_1
    //   103: invokevirtual 323	java/io/RandomAccessFile:close	()V
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
    //   122: invokevirtual 323	java/io/RandomAccessFile:close	()V
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
  
  private static Bitmap deH()
  {
    AppMethodBeat.i(29245);
    Object localObject = anS(u.aAm());
    if (localObject == null)
    {
      AppMethodBeat.o(29245);
      return null;
    }
    localObject = com.tencent.mm.sdk.platformtools.g.cr((byte[])localObject);
    AppMethodBeat.o(29245);
    return localObject;
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(29243);
    if (this.sBI != null) {
      this.sBI.cancel();
    }
    switch (InviteFriendsBy3rdUI.3.uTV[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29243);
      return;
      IN(2131764543);
      AppMethodBeat.o(29243);
      return;
      AppMethodBeat.o(29243);
      return;
      IN(2131764542);
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
    int i = bt.getInt(com.tencent.mm.n.g.acA().getValue("InviteFriendsInviteFlags"), 0);
    paramBundle = getPreferenceScreen();
    if ((i & 0x2) <= 0) {
      paramBundle.aVE("invite_friends_by_message");
    }
    if ((i & 0x1) <= 0) {
      paramBundle.aVE("invite_friends_by_mail");
    }
    if (((i & 0x4) <= 0) || (!checkApkExist(getContext(), "com.whatsapp"))) {
      paramBundle.aVE("invite_friends_by_whatsapp");
    }
    if (((i & 0x8) <= 0) || (!u.aAP())) {
      paramBundle.aVE("invite_friends_by_facebook");
    }
    if ((i & 0x10) <= 0) {
      paramBundle.aVE("invite_friends_by_twitter");
    }
    paramBundle.notifyDataSetChanged();
    ba.aiU().a(1803, this);
    ba.aiU().a(1804, this);
    ba.aiU().a(168, this);
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
    ba.aiU().b(1803, this);
    ba.aiU().b(1804, this);
    ba.aiU().b(168, this);
    if (this.Blb == 0) {
      com.tencent.mm.plugin.report.service.g.yhR.f(14035, new Object[] { Integer.valueOf(this.Blb), Integer.valueOf(BkZ), Integer.valueOf(this.fromScene) });
    }
    super.onDestroy();
    AppMethodBeat.o(29237);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29238);
    if ("invite_friends_by_message".equals(paramPreference.mKey))
    {
      this.Blb = BkV;
      SL(2);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_mail".equals(paramPreference.mKey))
    {
      this.Blb = BkU;
      SL(1);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_whatsapp".equals(paramPreference.mKey))
    {
      this.Blb = BkW;
      SL(4);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_facebook".equals(paramPreference.mKey))
    {
      this.Blb = BkX;
      if (u.aAS())
      {
        this.Blh = true;
        SL(8);
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
      this.Blb = BkY;
      if (this.AoC.fLk())
      {
        this.Blg = true;
        SL(16);
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
    ad.i("MicroMsg.InviteFriendsBy3rdUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.service.g.yhR.f(14035, new Object[] { Integer.valueOf(this.Blb), Integer.valueOf(BkZ), Integer.valueOf(this.fromScene) });
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
      if (!bt.isNullOrNil(paramString.title)) {
        break label1072;
      }
      localObject1 = null;
      paramString = (com.tencent.mm.modelmulti.e)paramn;
      if (!bt.isNullOrNil(paramString.content)) {
        break label1081;
      }
      paramString = null;
      localObject2 = u.aAn();
      ba.aBQ();
      localObject3 = (String)c.ajl().get(6, null);
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
      int i = ((com.tencent.mm.modelmulti.e)paramn).ieI;
      if ((i & 0x1) > 0)
      {
        localObject3 = localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          localObject3 = String.format(getString(2131760368), new Object[] { u.aAo() });
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
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.g.yhR.f(14035, new Object[] { Integer.valueOf(this.Blb), Integer.valueOf(Bla), Integer.valueOf(this.fromScene) });
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
          if (bt.aj(this, (Intent)localObject1))
          {
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            label634:
            com.tencent.mm.plugin.report.service.g.yhR.f(14035, new Object[] { Integer.valueOf(this.Blb), Integer.valueOf(Bla), Integer.valueOf(this.fromScene) });
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
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.g.yhR.f(14035, new Object[] { Integer.valueOf(this.Blb), Integer.valueOf(Bla), Integer.valueOf(this.fromScene) });
            localObject2 = paramString;
            if ((i & 0x8) > 0)
            {
              localObject1 = paramString;
              if (bt.isNullOrNil(paramString))
              {
                if (!bt.isNullOrNil(u.aAn())) {
                  break label1103;
                }
                localObject1 = getString(2131760366);
              }
              paramString = getString(2131760358);
              localObject2 = localObject1;
              if (this.Blh == true)
              {
                B(i, (String)localObject1, paramString);
                this.Blh = false;
                localObject2 = localObject1;
              }
            }
            if ((i & 0x10) > 0)
            {
              this.AoC.a(this);
              paramString = (String)localObject2;
              if (bt.isNullOrNil((String)localObject2)) {
                if (!bt.isNullOrNil(u.aAn())) {
                  break label1128;
                }
              }
            }
            for (paramString = getString(2131760366);; paramString = String.format(getString(2131760365), new Object[] { u.aAn() }))
            {
              localObject1 = getString(2131760363);
              if (this.Blg == true)
              {
                B(i, paramString, (String)localObject1);
                this.Blg = false;
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
              localObject1 = String.format(getString(2131760365), new Object[] { u.aAn() });
              break label920;
            }
            com.tencent.mm.ui.base.h.cl(this, getResources().getString(2131757561));
            com.tencent.mm.plugin.report.service.g.yhR.f(14035, new Object[] { Integer.valueOf(this.Blb), Integer.valueOf(Bla), Integer.valueOf(this.fromScene) });
            if (paramn.getType() == 168)
            {
              if ((paramInt1 != 0) || (paramInt2 != 0))
              {
                AppMethodBeat.o(29239);
                return;
              }
              if (this.Ble != null)
              {
                if (this.ltc != null) {
                  this.ltc.setVisibility(8);
                }
                this.Ble.setImageBitmap(deH());
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