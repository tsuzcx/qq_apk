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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
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
import com.tencent.mm.ui.q.a.a;
import com.tencent.mm.ui.q.a.b;
import com.tencent.mm.ui.q.a.c;

public class InviteFriendsBy3rdUI
  extends MMPreference
  implements i, a.a, a.b
{
  private static int Mhg = 1;
  private static int Mhh = 2;
  private static int Mhi = 3;
  private static int Mhj = 4;
  private static int Mhk = 5;
  private static int Mhl = 0;
  private static int Mhm = 1;
  private ProgressDialog Apv;
  private com.tencent.mm.ui.q.a Ldq;
  private int Mhn;
  private Bitmap Mho;
  private View Mhp;
  private ImageView Mhq;
  private EditText Mhr;
  private boolean Mhs;
  private boolean Mht;
  private int fromScene;
  private ProgressDialog iXX;
  private ProgressBar pDL;
  
  public InviteFriendsBy3rdUI()
  {
    AppMethodBeat.i(29235);
    this.Mhn = 0;
    this.iXX = null;
    this.Apv = null;
    this.Mho = null;
    this.Mhq = null;
    this.pDL = null;
    this.Mhr = null;
    this.Ldq = new com.tencent.mm.ui.q.a();
    this.Mhs = false;
    this.Mht = false;
    AppMethodBeat.o(29235);
  }
  
  private void H(final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(29244);
    this.Mhp = View.inflate(getContext(), R.i.confirm_dialog_item, null);
    this.Mhr = ((EditText)this.Mhp.findViewById(R.h.confirm_dialog_text_et));
    this.Mhq = ((ImageView)this.Mhp.findViewById(R.h.confirm_dialog_imageview));
    this.pDL = ((ProgressBar)this.Mhp.findViewById(R.h.loading_pb));
    ((View)this.Mhq.getParent()).setVisibility(8);
    this.Mhr.setText(paramString1);
    this.Mho = eKq();
    if (this.Mho == null)
    {
      bdV(z.bcZ());
      ((ProgressBar)this.Mhp.findViewById(R.h.loading_pb)).setVisibility(0);
    }
    for (;;)
    {
      o.a(this.mController, paramString2, this.Mhp, getResources().getString(R.l.app_send), new y.b()
      {
        public final void tD(boolean paramAnonymousBoolean)
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
      if (this.Mhq != null) {
        this.Mhq.setImageBitmap(this.Mho);
      }
    }
  }
  
  private void Vx(int paramInt)
  {
    AppMethodBeat.i(29242);
    com.tencent.mm.ui.base.h.a(getContext(), paramInt, R.l.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(29242);
  }
  
  /* Error */
  private static byte[] aMv(String paramString)
  {
    // Byte code:
    //   0: sipush 29246
    //   3: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 260	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: invokestatic 265	com/tencent/mm/model/c:bbW	()Ljava/lang/String;
    //   13: astore_1
    //   14: invokestatic 260	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   17: pop
    //   18: aload_1
    //   19: invokestatic 268	com/tencent/mm/model/c:bbX	()Ljava/lang/String;
    //   22: ldc_w 270
    //   25: aload_0
    //   26: invokevirtual 276	java/lang/String:getBytes	()[B
    //   29: invokestatic 282	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   32: ldc_w 284
    //   35: iconst_1
    //   36: invokestatic 290	com/tencent/mm/sdk/platformtools/FilePathGenerator:defGenPathWithOld	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   39: astore_0
    //   40: aload_0
    //   41: iconst_0
    //   42: invokestatic 296	com/tencent/mm/vfs/u:dO	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   45: astore_1
    //   46: aload_1
    //   47: astore_0
    //   48: aload_1
    //   49: invokevirtual 302	java/io/RandomAccessFile:length	()J
    //   52: l2i
    //   53: newarray byte
    //   55: astore_2
    //   56: aload_1
    //   57: astore_0
    //   58: aload_1
    //   59: aload_2
    //   60: invokevirtual 306	java/io/RandomAccessFile:read	([B)I
    //   63: pop
    //   64: aload_1
    //   65: ifnull +7 -> 72
    //   68: aload_1
    //   69: invokevirtual 309	java/io/RandomAccessFile:close	()V
    //   72: sipush 29246
    //   75: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_2
    //   79: areturn
    //   80: astore_2
    //   81: aconst_null
    //   82: astore_1
    //   83: aload_1
    //   84: astore_0
    //   85: ldc_w 311
    //   88: aload_2
    //   89: ldc_w 313
    //   92: iconst_0
    //   93: anewarray 315	java/lang/Object
    //   96: invokestatic 321	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 309	java/io/RandomAccessFile:close	()V
    //   107: sipush 29246
    //   110: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_0
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 309	java/io/RandomAccessFile:close	()V
    //   126: sipush 29246
    //   129: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload_1
    //   133: athrow
    //   134: astore_0
    //   135: goto -63 -> 72
    //   138: astore_0
    //   139: goto -32 -> 107
    //   142: astore_0
    //   143: goto -17 -> 126
    //   146: astore_1
    //   147: goto -29 -> 118
    //   150: astore_2
    //   151: goto -68 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramString	String
    //   13	91	1	localObject1	Object
    //   115	18	1	localObject2	Object
    //   146	1	1	localObject3	Object
    //   55	24	2	arrayOfByte	byte[]
    //   80	9	2	localException1	java.lang.Exception
    //   150	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   40	46	80	java/lang/Exception
    //   40	46	115	finally
    //   68	72	134	java/lang/Exception
    //   103	107	138	java/lang/Exception
    //   122	126	142	java/lang/Exception
    //   48	56	146	finally
    //   58	64	146	finally
    //   85	99	146	finally
    //   48	56	150	java/lang/Exception
    //   58	64	150	java/lang/Exception
  }
  
  private void aiK(int paramInt)
  {
    AppMethodBeat.i(29240);
    final e locale = new e(paramInt);
    getString(R.l.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a(this, getString(R.l.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(29233);
        bh.aGY().a(locale);
        AppMethodBeat.o(29233);
      }
    });
    bh.aGY().a(locale, 0);
    AppMethodBeat.o(29240);
  }
  
  private static void bdV(String paramString)
  {
    AppMethodBeat.i(29247);
    bh.beI();
    paramString = new com.tencent.mm.bf.a(paramString, Util.nullAsNil((Integer)com.tencent.mm.model.c.aHp().b(66561, null)));
    bh.aGY().a(paramString, 0);
    AppMethodBeat.o(29247);
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
  
  private static Bitmap eKq()
  {
    AppMethodBeat.i(29245);
    Object localObject = aMv(z.bcZ());
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
    if (this.Apv != null) {
      this.Apv.cancel();
    }
    switch (InviteFriendsBy3rdUI.3.DYl[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29243);
      return;
      Vx(R.l.twitterlogin_success);
      AppMethodBeat.o(29243);
      return;
      AppMethodBeat.o(29243);
      return;
      Vx(R.l.twitterlogin_failed);
    }
  }
  
  public final void b(a.c paramc) {}
  
  public int getResourceId()
  {
    return R.o.eXE;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29236);
    super.onCreate(paramBundle);
    setMMTitle(R.l.eFa);
    this.fromScene = getIntent().getIntExtra("Invite_friends", 4);
    int i = Util.getInt(com.tencent.mm.n.h.axc().getValue("InviteFriendsInviteFlags"), 0);
    paramBundle = getPreferenceScreen();
    if ((i & 0x2) <= 0) {
      paramBundle.byI("invite_friends_by_message");
    }
    if ((i & 0x1) <= 0) {
      paramBundle.byI("invite_friends_by_mail");
    }
    if ((WeChatBrands.Business.Entries.Global3rdSrv.banned()) || ((i & 0x4) <= 0) || (!checkApkExist(getContext(), "com.whatsapp"))) {
      paramBundle.byI("invite_friends_by_whatsapp");
    }
    if ((WeChatBrands.Business.Entries.Global3rdSrv.banned()) || ((i & 0x8) <= 0) || (!z.bdE())) {
      paramBundle.byI("invite_friends_by_facebook");
    }
    if ((WeChatBrands.Business.Entries.Global3rdSrv.banned()) || ((i & 0x10) <= 0)) {
      paramBundle.byI("invite_friends_by_twitter");
    }
    paramBundle.notifyDataSetChanged();
    bh.aGY().a(1803, this);
    bh.aGY().a(1804, this);
    bh.aGY().a(168, this);
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
    bh.aGY().b(1803, this);
    bh.aGY().b(1804, this);
    bh.aGY().b(168, this);
    if (this.Mhn == 0) {
      com.tencent.mm.plugin.report.service.h.IzE.a(14035, new Object[] { Integer.valueOf(this.Mhn), Integer.valueOf(Mhl), Integer.valueOf(this.fromScene) });
    }
    super.onDestroy();
    AppMethodBeat.o(29237);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29238);
    if ("invite_friends_by_message".equals(paramPreference.mKey))
    {
      this.Mhn = Mhh;
      aiK(2);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_mail".equals(paramPreference.mKey))
    {
      this.Mhn = Mhg;
      aiK(1);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_whatsapp".equals(paramPreference.mKey))
    {
      this.Mhn = Mhi;
      aiK(4);
      AppMethodBeat.o(29238);
      return true;
    }
    if ("invite_friends_by_facebook".equals(paramPreference.mKey))
    {
      this.Mhn = Mhj;
      if (z.bdH())
      {
        this.Mht = true;
        aiK(8);
      }
      for (;;)
      {
        AppMethodBeat.o(29238);
        return true;
        com.tencent.mm.ui.base.h.a(getContext(), R.l.settings_facebook_notice, R.l.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(29231);
            com.tencent.mm.by.c.b(InviteFriendsBy3rdUI.this.getContext(), "account", ".ui.FacebookAuthUI", new Intent());
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
      this.Mhn = Mhk;
      if (this.Ldq.hZk())
      {
        this.Mhs = true;
        aiK(16);
      }
      for (;;)
      {
        AppMethodBeat.o(29238);
        return true;
        com.tencent.mm.ui.base.h.a(getContext(), R.l.settings_twitter_notice, R.l.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(29232);
            paramAnonymousDialogInterface = InviteFriendsBy3rdUI.this;
            AppCompatActivity localAppCompatActivity = InviteFriendsBy3rdUI.this.getContext();
            InviteFriendsBy3rdUI.this.getContext().getString(R.l.app_tip);
            InviteFriendsBy3rdUI.a(paramAnonymousDialogInterface, com.tencent.mm.ui.base.h.a(localAppCompatActivity, InviteFriendsBy3rdUI.this.getContext().getString(R.l.twitter_loading), true, new DialogInterface.OnCancelListener()
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
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.service.h.IzE.a(14035, new Object[] { Integer.valueOf(this.Mhn), Integer.valueOf(Mhl), Integer.valueOf(this.fromScene) });
    }
    Object localObject1;
    label195:
    Object localObject2;
    Object localObject3;
    if (paramq.getType() == 1803)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.ui.base.h.p(getContext(), R.l.loading_failed, R.l.app_tip);
        AppMethodBeat.o(29239);
        return;
      }
      paramString = (e)paramq;
      if (!Util.isNullOrNil(paramString.title)) {
        break label1074;
      }
      localObject1 = null;
      paramString = (e)paramq;
      if (!Util.isNullOrNil(paramString.content)) {
        break label1083;
      }
      paramString = null;
      localObject2 = z.bda();
      bh.beI();
      localObject3 = (String)com.tencent.mm.model.c.aHp().b(6, null);
      if (!Util.isNullOrNil((String)localObject2)) {
        break label1292;
      }
      localObject2 = localObject3;
    }
    label1154:
    label1283:
    label1292:
    for (;;)
    {
      int i = ((e)paramq).lSU;
      if ((i & 0x1) > 0)
      {
        localObject3 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject3 = String.format(getString(R.l.invite_friends_mail_title), new Object[] { z.bdb() });
        }
        if (Util.isNullOrNil(paramString))
        {
          paramString = String.format(getString(R.l.invite_friends_mail_content), new Object[] { localObject2 });
          label308:
          localObject1 = new Intent("android.intent.action.SEND");
          ((Intent)localObject1).putExtra("android.intent.extra.SUBJECT", (String)localObject3);
          ((Intent)localObject1).putExtra("android.intent.extra.TEXT", paramString);
          ((Intent)localObject1).setType("plain/text");
          localObject1 = Intent.createChooser((Intent)localObject1, getString(R.l.invite_friends_by_mail_select));
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.IzE.a(14035, new Object[] { Integer.valueOf(this.Mhn), Integer.valueOf(Mhm), Integer.valueOf(this.fromScene) });
        }
      }
      for (;;)
      {
        localObject1 = paramString;
        if ((i & 0x2) > 0)
        {
          if (!Util.isNullOrNil(paramString)) {
            break label1283;
          }
          paramString = String.format(getString(R.l.invite_friends_message_content), new Object[] { localObject2 });
        }
        label921:
        label1074:
        label1083:
        label1211:
        for (;;)
        {
          localObject1 = new Intent("android.intent.action.VIEW");
          ((Intent)localObject1).putExtra("sms_body", paramString);
          ((Intent)localObject1).setType("vnd.android-dir/mms-sms");
          if (Util.isIntentAvailable(this, (Intent)localObject1))
          {
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
            com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            label635:
            com.tencent.mm.plugin.report.service.h.IzE.a(14035, new Object[] { Integer.valueOf(this.Mhn), Integer.valueOf(Mhm), Integer.valueOf(this.fromScene) });
            localObject1 = paramString;
            paramString = (String)localObject1;
            if ((i & 0x4) > 0) {
              if (!Util.isNullOrNil((String)localObject1)) {
                break label1277;
              }
            }
          }
          label1105:
          label1130:
          label1277:
          for (paramString = String.format(getString(R.l.invite_friends_message_content), new Object[] { localObject2 });; paramString = (String)localObject1)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).setAction("android.intent.action.SEND");
            ((Intent)localObject1).putExtra("android.intent.extra.TEXT", paramString);
            ((Intent)localObject1).setType("text/plain");
            ((Intent)localObject1).setPackage("com.whatsapp");
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
            com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/InviteFriendsBy3rdUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.IzE.a(14035, new Object[] { Integer.valueOf(this.Mhn), Integer.valueOf(Mhm), Integer.valueOf(this.fromScene) });
            localObject2 = paramString;
            if ((i & 0x8) > 0)
            {
              localObject1 = paramString;
              if (Util.isNullOrNil(paramString))
              {
                if (!Util.isNullOrNil(z.bda())) {
                  break label1105;
                }
                localObject1 = getString(R.l.invite_friends_facebook_twitter_no_wechatid_content);
              }
              paramString = getString(R.l.invite_friends_by_facebook);
              localObject2 = localObject1;
              if (this.Mht == true)
              {
                H(i, (String)localObject1, paramString);
                this.Mht = false;
                localObject2 = localObject1;
              }
            }
            if ((i & 0x10) > 0)
            {
              this.Ldq.a(this);
              paramString = (String)localObject2;
              if (Util.isNullOrNil((String)localObject2)) {
                if (!Util.isNullOrNil(z.bda())) {
                  break label1130;
                }
              }
            }
            for (paramString = getString(R.l.invite_friends_facebook_twitter_no_wechatid_content);; paramString = String.format(getString(R.l.invite_friends_facebook_twitter_content), new Object[] { z.bda() }))
            {
              localObject1 = getString(R.l.invite_friends_by_twitter);
              if (this.Mhs == true)
              {
                H(i, paramString, (String)localObject1);
                this.Mhs = false;
              }
              if (paramq.getType() != 1804) {
                break label1211;
              }
              if ((paramInt1 == 0) && (paramInt2 == 0)) {
                break label1154;
              }
              com.tencent.mm.ui.base.h.p(getContext(), R.l.sendrequest_send_fail, R.l.app_tip);
              AppMethodBeat.o(29239);
              return;
              localObject1 = paramString.title;
              break;
              paramString = paramString.content;
              break label195;
              Toast.makeText(this, R.l.selectsmsapp_none, 1).show();
              break label635;
              localObject1 = String.format(getString(R.l.invite_friends_facebook_twitter_content), new Object[] { z.bda() });
              break label921;
            }
            com.tencent.mm.ui.base.h.cO(this, getResources().getString(R.l.confirm_dialog_sent));
            com.tencent.mm.plugin.report.service.h.IzE.a(14035, new Object[] { Integer.valueOf(this.Mhn), Integer.valueOf(Mhm), Integer.valueOf(this.fromScene) });
            if (paramq.getType() == 168)
            {
              if ((paramInt1 != 0) || (paramInt2 != 0))
              {
                AppMethodBeat.o(29239);
                return;
              }
              if (this.Mhq != null)
              {
                if (this.pDL != null) {
                  this.pDL.setVisibility(8);
                }
                this.Mhq.setImageBitmap(eKq());
              }
            }
            AppMethodBeat.o(29239);
            return;
          }
        }
        break label308;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI
 * JD-Core Version:    0.7.0.1
 */