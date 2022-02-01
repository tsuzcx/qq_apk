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
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.k.a.a;
import com.tencent.mm.ui.k.a.b;
import com.tencent.mm.ui.k.a.c;

public class InviteFriendsBy3rdUI
  extends MMPreference
  implements com.tencent.mm.ak.g, a.a, a.b
{
  private static int zTp = 1;
  private static int zTq = 2;
  private static int zTr = 3;
  private static int zTs = 4;
  private static int zTt = 5;
  private static int zTu = 0;
  private static int zTv = 1;
  private int fromScene;
  private ProgressDialog fts;
  private ProgressBar kWd;
  private ProgressDialog rGq;
  private com.tencent.mm.ui.k.a yWS;
  private EditText zTA;
  private boolean zTB;
  private boolean zTC;
  private int zTw;
  private Bitmap zTx;
  private View zTy;
  private ImageView zTz;
  
  public InviteFriendsBy3rdUI()
  {
    AppMethodBeat.i(29235);
    this.zTw = 0;
    this.fts = null;
    this.rGq = null;
    this.zTx = null;
    this.zTz = null;
    this.kWd = null;
    this.zTA = null;
    this.yWS = new com.tencent.mm.ui.k.a();
    this.zTB = false;
    this.zTC = false;
    AppMethodBeat.o(29235);
  }
  
  private void C(final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(29244);
    this.zTy = View.inflate(getContext(), 2131493586, null);
    this.zTA = ((EditText)this.zTy.findViewById(2131298569));
    this.zTz = ((ImageView)this.zTy.findViewById(2131298566));
    this.kWd = ((ProgressBar)this.zTy.findViewById(2131301506));
    ((View)this.zTz.getParent()).setVisibility(8);
    this.zTA.setText(paramString1);
    this.zTx = cVw();
    if (this.zTx == null)
    {
      axz(u.axw());
      ((ProgressBar)this.zTy.findViewById(2131301506)).setVisibility(0);
    }
    for (;;)
    {
      o.a(this.mController, paramString2, this.zTy, getResources().getString(2131755884), new y.b()
      {
        public final void nu(boolean paramAnonymousBoolean)
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
      if (this.zTz != null) {
        this.zTz.setImageBitmap(this.zTx);
      }
    }
  }
  
  private void Hr(int paramInt)
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
  
  private void Rb(int paramInt)
  {
    AppMethodBeat.i(29240);
    final com.tencent.mm.modelmulti.e locale = new com.tencent.mm.modelmulti.e(paramInt);
    getString(2131755906);
    this.fts = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(29233);
        az.agi().a(locale);
        AppMethodBeat.o(29233);
      }
    });
    az.agi().a(locale, 0);
    AppMethodBeat.o(29240);
  }
  
  /* Error */
  private static byte[] ajf(String paramString)
  {
    // Byte code:
    //   0: sipush 29246
    //   3: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 250	com/tencent/mm/model/az:ayM	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: invokestatic 255	com/tencent/mm/model/c:awL	()Ljava/lang/String;
    //   13: astore_1
    //   14: invokestatic 250	com/tencent/mm/model/az:ayM	()Lcom/tencent/mm/model/c;
    //   17: pop
    //   18: aload_1
    //   19: invokestatic 258	com/tencent/mm/model/c:awM	()Ljava/lang/String;
    //   22: ldc_w 260
    //   25: aload_0
    //   26: invokevirtual 266	java/lang/String:getBytes	()[B
    //   29: invokestatic 272	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   32: ldc_w 274
    //   35: invokestatic 280	com/tencent/mm/sdk/platformtools/l:j	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_0
    //   39: aload_0
    //   40: iconst_0
    //   41: invokestatic 286	com/tencent/mm/vfs/i:cY	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   44: astore_1
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: invokevirtual 292	java/io/RandomAccessFile:length	()J
    //   51: l2i
    //   52: newarray byte
    //   54: astore_2
    //   55: aload_1
    //   56: astore_0
    //   57: aload_1
    //   58: aload_2
    //   59: invokevirtual 296	java/io/RandomAccessFile:read	([B)I
    //   62: pop
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 299	java/io/RandomAccessFile:close	()V
    //   71: sipush 29246
    //   74: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_2
    //   78: areturn
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: astore_0
    //   84: ldc_w 301
    //   87: aload_2
    //   88: ldc_w 303
    //   91: iconst_0
    //   92: anewarray 305	java/lang/Object
    //   95: invokestatic 311	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: aload_1
    //   99: ifnull +7 -> 106
    //   102: aload_1
    //   103: invokevirtual 299	java/io/RandomAccessFile:close	()V
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
    //   122: invokevirtual 299	java/io/RandomAccessFile:close	()V
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
  
  private static void axz(String paramString)
  {
    AppMethodBeat.i(29247);
    az.ayM();
    paramString = new com.tencent.mm.bc.a(paramString, bs.m((Integer)c.agA().get(66561, null)));
    az.agi().a(paramString, 0);
    AppMethodBeat.o(29247);
  }
  
  private static Bitmap cVw()
  {
    AppMethodBeat.i(29245);
    Object localObject = ajf(u.axw());
    if (localObject == null)
    {
      AppMethodBeat.o(29245);
      return null;
    }
    localObject = com.tencent.mm.sdk.platformtools.f.ck((byte[])localObject);
    AppMethodBeat.o(29245);
    return localObject;
  }
  
  private static boolean checkApkExist(Context paramContext, String paramString)
  {
    AppMethodBeat.i(29241);
    if (bs.isNullOrNil(paramString))
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
    if (this.rGq != null) {
      this.rGq.cancel();
    }
    switch (InviteFriendsBy3rdUI.3.tRi[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29243);
      return;
      Hr(2131764543);
      AppMethodBeat.o(29243);
      return;
      AppMethodBeat.o(29243);
      return;
      Hr(2131764542);
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
    int i = bs.getInt(com.tencent.mm.m.g.ZY().getValue("InviteFriendsInviteFlags"), 0);
    paramBundle = getPreferenceScreen();
    if ((i & 0x2) <= 0) {
      paramBundle.aPO("invite_friends_by_message");
    }
    if ((i & 0x1) <= 0) {
      paramBundle.aPO("invite_friends_by_mail");
    }
    if (((i & 0x4) <= 0) || (!checkApkExist(getContext(), "com.whatsapp"))) {
      paramBundle.aPO("invite_friends_by_whatsapp");
    }
    if (((i & 0x8) <= 0) || (!u.axW())) {
      paramBundle.aPO("invite_friends_by_facebook");
    }
    if ((i & 0x10) <= 0) {
      paramBundle.aPO("invite_friends_by_twitter");
    }
    paramBundle.notifyDataSetChanged();
    az.agi().a(1803, this);
    az.agi().a(1804, this);
    az.agi().a(168, this);
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
    az.agi().b(1803, this);
    az.agi().b(1804, this);
    az.agi().b(168, this);
    if (this.zTw == 0) {
      com.tencent.mm.plugin.report.service.h.wUl.f(14035, new Object[] { Integer.valueOf(this.zTw), Integer.valueOf(zTu), Integer.valueOf(this.fromScene) });
    }
    super.onDestroy();
    AppMethodBeat.o(29237);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29238);
    if ("invite_friends_by_message".equals(paramPreference.mKey))
    {
      this.zTw = zTq;
      Rb(2);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_mail".equals(paramPreference.mKey))
    {
      this.zTw = zTp;
      Rb(1);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_whatsapp".equals(paramPreference.mKey))
    {
      this.zTw = zTr;
      Rb(4);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_facebook".equals(paramPreference.mKey))
    {
      this.zTw = zTs;
      if (u.axZ())
      {
        this.zTC = true;
        Rb(8);
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
      this.zTw = zTt;
      if (this.yWS.fux())
      {
        this.zTB = true;
        Rb(16);
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
    ac.i("MicroMsg.InviteFriendsBy3rdUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.service.h.wUl.f(14035, new Object[] { Integer.valueOf(this.zTw), Integer.valueOf(zTu), Integer.valueOf(this.fromScene) });
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
      if (!bs.isNullOrNil(paramString.title)) {
        break label1072;
      }
      localObject1 = null;
      paramString = (com.tencent.mm.modelmulti.e)paramn;
      if (!bs.isNullOrNil(paramString.content)) {
        break label1081;
      }
      paramString = null;
      localObject2 = u.axx();
      az.ayM();
      localObject3 = (String)c.agA().get(6, null);
      if (!bs.isNullOrNil((String)localObject2)) {
        break label1290;
      }
      localObject2 = localObject3;
    }
    label1152:
    label1281:
    label1290:
    for (;;)
    {
      int i = ((com.tencent.mm.modelmulti.e)paramn).hLO;
      if ((i & 0x1) > 0)
      {
        localObject3 = localObject1;
        if (bs.isNullOrNil((String)localObject1)) {
          localObject3 = String.format(getString(2131760368), new Object[] { u.axy() });
        }
        if (bs.isNullOrNil(paramString))
        {
          paramString = String.format(getString(2131760367), new Object[] { localObject2 });
          label307:
          localObject1 = new Intent("android.intent.action.SEND");
          ((Intent)localObject1).putExtra("android.intent.extra.SUBJECT", (String)localObject3);
          ((Intent)localObject1).putExtra("android.intent.extra.TEXT", paramString);
          ((Intent)localObject1).setType("plain/text");
          localObject1 = Intent.createChooser((Intent)localObject1, getString(2131760361));
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.wUl.f(14035, new Object[] { Integer.valueOf(this.zTw), Integer.valueOf(zTv), Integer.valueOf(this.fromScene) });
        }
      }
      for (;;)
      {
        localObject1 = paramString;
        if ((i & 0x2) > 0)
        {
          if (!bs.isNullOrNil(paramString)) {
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
          if (bs.ah(this, (Intent)localObject1))
          {
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            label634:
            com.tencent.mm.plugin.report.service.h.wUl.f(14035, new Object[] { Integer.valueOf(this.zTw), Integer.valueOf(zTv), Integer.valueOf(this.fromScene) });
            localObject1 = paramString;
            paramString = (String)localObject1;
            if ((i & 0x4) > 0) {
              if (!bs.isNullOrNil((String)localObject1)) {
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
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.wUl.f(14035, new Object[] { Integer.valueOf(this.zTw), Integer.valueOf(zTv), Integer.valueOf(this.fromScene) });
            localObject2 = paramString;
            if ((i & 0x8) > 0)
            {
              localObject1 = paramString;
              if (bs.isNullOrNil(paramString))
              {
                if (!bs.isNullOrNil(u.axx())) {
                  break label1103;
                }
                localObject1 = getString(2131760366);
              }
              paramString = getString(2131760358);
              localObject2 = localObject1;
              if (this.zTC == true)
              {
                C(i, (String)localObject1, paramString);
                this.zTC = false;
                localObject2 = localObject1;
              }
            }
            if ((i & 0x10) > 0)
            {
              this.yWS.a(this);
              paramString = (String)localObject2;
              if (bs.isNullOrNil((String)localObject2)) {
                if (!bs.isNullOrNil(u.axx())) {
                  break label1128;
                }
              }
            }
            for (paramString = getString(2131760366);; paramString = String.format(getString(2131760365), new Object[] { u.axx() }))
            {
              localObject1 = getString(2131760363);
              if (this.zTB == true)
              {
                C(i, paramString, (String)localObject1);
                this.zTB = false;
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
              localObject1 = String.format(getString(2131760365), new Object[] { u.axx() });
              break label920;
            }
            com.tencent.mm.ui.base.h.cg(this, getResources().getString(2131757561));
            com.tencent.mm.plugin.report.service.h.wUl.f(14035, new Object[] { Integer.valueOf(this.zTw), Integer.valueOf(zTv), Integer.valueOf(this.fromScene) });
            if (paramn.getType() == 168)
            {
              if ((paramInt1 != 0) || (paramInt2 != 0))
              {
                AppMethodBeat.o(29239);
                return;
              }
              if (this.zTz != null)
              {
                if (this.kWd != null) {
                  this.kWd.setVisibility(8);
                }
                this.zTz.setImageBitmap(cVw());
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