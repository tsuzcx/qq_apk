package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.m.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelmulti.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.i.a.a;
import com.tencent.mm.ui.i.a.b;
import com.tencent.mm.ui.i.a.c;
import com.tencent.mm.ui.s;

public class InviteFriendsBy3rdUI
  extends MMPreference
  implements com.tencent.mm.ah.f, a.a, a.b
{
  private static int pxP = 1;
  private static int pxQ = 2;
  private static int pxR = 3;
  private static int pxS = 4;
  private static int pxT = 5;
  private static int pxU = 0;
  private static int pxV = 1;
  private ProgressDialog dnm = null;
  private int fromScene;
  private ProgressBar kjT = null;
  private ProgressDialog lxZ = null;
  private com.tencent.mm.ui.i.a piY = new com.tencent.mm.ui.i.a();
  private int pxW = 0;
  private Bitmap pxX = null;
  private View pxY;
  private ImageView pxZ = null;
  private EditText pya = null;
  private boolean pyb = false;
  private boolean pyc = false;
  
  /* Error */
  private static byte[] FR(String paramString)
  {
    // Byte code:
    //   0: invokestatic 95	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   3: pop
    //   4: invokestatic 101	com/tencent/mm/model/c:FG	()Ljava/lang/String;
    //   7: astore_1
    //   8: invokestatic 95	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   11: pop
    //   12: aload_1
    //   13: invokestatic 104	com/tencent/mm/model/c:FH	()Ljava/lang/String;
    //   16: ldc 106
    //   18: aload_0
    //   19: invokevirtual 112	java/lang/String:getBytes	()[B
    //   22: invokestatic 118	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   25: ldc 120
    //   27: invokestatic 126	com/tencent/mm/sdk/platformtools/h:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_0
    //   31: new 128	java/io/RandomAccessFile
    //   34: dup
    //   35: aload_0
    //   36: ldc 130
    //   38: invokespecial 133	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: astore_1
    //   42: aload_1
    //   43: astore_0
    //   44: aload_1
    //   45: invokevirtual 137	java/io/RandomAccessFile:length	()J
    //   48: l2i
    //   49: newarray byte
    //   51: astore_2
    //   52: aload_1
    //   53: astore_0
    //   54: aload_1
    //   55: aload_2
    //   56: invokevirtual 141	java/io/RandomAccessFile:read	([B)I
    //   59: pop
    //   60: aload_1
    //   61: invokevirtual 144	java/io/RandomAccessFile:close	()V
    //   64: aload_2
    //   65: areturn
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_1
    //   69: aload_1
    //   70: astore_0
    //   71: ldc 146
    //   73: aload_2
    //   74: ldc 148
    //   76: iconst_0
    //   77: anewarray 150	java/lang/Object
    //   80: invokestatic 156	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 144	java/io/RandomAccessFile:close	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 144	java/io/RandomAccessFile:close	()V
    //   104: aload_1
    //   105: athrow
    //   106: astore_0
    //   107: aload_2
    //   108: areturn
    //   109: astore_0
    //   110: goto -19 -> 91
    //   113: astore_0
    //   114: goto -10 -> 104
    //   117: astore_1
    //   118: goto -22 -> 96
    //   121: astore_2
    //   122: goto -53 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramString	String
    //   7	81	1	localObject1	Object
    //   93	12	1	localObject2	Object
    //   117	1	1	localObject3	Object
    //   51	14	2	arrayOfByte	byte[]
    //   66	42	2	localException1	java.lang.Exception
    //   121	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   31	42	66	java/lang/Exception
    //   31	42	93	finally
    //   60	64	106	java/lang/Exception
    //   87	91	109	java/lang/Exception
    //   100	104	113	java/lang/Exception
    //   44	52	117	finally
    //   54	60	117	finally
    //   71	83	117	finally
    //   44	52	121	java/lang/Exception
    //   54	60	121	java/lang/Exception
  }
  
  private static boolean au(Context paramContext, String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  private static Bitmap bdf()
  {
    byte[] arrayOfByte = FR(q.Gj());
    if (arrayOfByte == null) {
      return null;
    }
    return com.tencent.mm.sdk.platformtools.c.bu(arrayOfByte);
  }
  
  private void m(int paramInt, String paramString1, String paramString2)
  {
    this.pxY = View.inflate(this.mController.uMN, R.i.confirm_dialog_item, null);
    this.pya = ((EditText)this.pxY.findViewById(R.h.confirm_dialog_text_et));
    this.pxZ = ((ImageView)this.pxY.findViewById(R.h.confirm_dialog_imageview));
    this.kjT = ((ProgressBar)this.pxY.findViewById(R.h.loading_pb));
    ((View)this.pxZ.getParent()).setVisibility(8);
    this.pya.setText(paramString1);
    this.pxX = bdf();
    if (this.pxX == null)
    {
      Object localObject = q.Gj();
      au.Hx();
      localObject = new com.tencent.mm.ba.a((String)localObject, bk.g((Integer)com.tencent.mm.model.c.Dz().get(66561, null)));
      au.Dk().a((m)localObject, 0);
      ((ProgressBar)this.pxY.findViewById(R.h.loading_pb)).setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.pluginsdk.ui.applet.g.a(this.mController, paramString2, this.pxY, getResources().getString(R.l.app_send), new InviteFriendsBy3rdUI.2(this, paramString1, paramInt));
      return;
      if (this.pxZ != null) {
        this.pxZ.setImageBitmap(this.pxX);
      }
    }
  }
  
  private void sS(int paramInt)
  {
    com.tencent.mm.ui.base.h.a(this.mController.uMN, paramInt, R.l.app_tip, new DialogInterface.OnClickListener()new InviteFriendsBy3rdUI.11
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new InviteFriendsBy3rdUI.11(this));
  }
  
  private void zo(int paramInt)
  {
    d locald = new d(paramInt);
    getString(R.l.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(this, getString(R.l.loading_tips), true, new InviteFriendsBy3rdUI.8(this, locald));
    au.Dk().a(locald, 0);
  }
  
  public final void a(a.c paramc)
  {
    if (this.lxZ != null) {
      this.lxZ.cancel();
    }
    switch (InviteFriendsBy3rdUI.3.lyx[paramc.ordinal()])
    {
    case 2: 
    default: 
      return;
    case 1: 
      sS(R.l.twitterlogin_success);
      return;
    }
    sS(R.l.twitterlogin_failed);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    if ("invite_friends_by_message".equals(paramPreference.mKey))
    {
      this.pxW = pxQ;
      zo(2);
      return true;
    }
    if ("invite_friends_by_mail".equals(paramPreference.mKey))
    {
      this.pxW = pxP;
      zo(1);
      return true;
    }
    if ("invite_friends_by_whatsapp".equals(paramPreference.mKey))
    {
      this.pxW = pxR;
      zo(4);
      return true;
    }
    if ("invite_friends_by_facebook".equals(paramPreference.mKey))
    {
      this.pxW = pxS;
      if (q.GL())
      {
        this.pyc = true;
        zo(8);
        return true;
      }
      com.tencent.mm.ui.base.h.a(this.mController.uMN, R.l.settings_facebook_notice, R.l.app_tip, new InviteFriendsBy3rdUI.4(this), new InviteFriendsBy3rdUI.5(this));
      return true;
    }
    if ("invite_friends_by_twitter".equals(paramPreference.mKey))
    {
      this.pxW = pxT;
      if (this.piY.cJJ())
      {
        this.pyb = true;
        zo(16);
        return true;
      }
      com.tencent.mm.ui.base.h.a(this.mController.uMN, R.l.settings_twitter_notice, R.l.app_tip, new InviteFriendsBy3rdUI.6(this), new InviteFriendsBy3rdUI.7(this));
      return true;
    }
    return false;
  }
  
  public final void b(a.c paramc) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.find_friends_by_invite_friend);
    this.fromScene = getIntent().getIntExtra("Invite_friends", 4);
    int i = bk.getInt(com.tencent.mm.m.g.AA().getValue("InviteFriendsInviteFlags"), 0);
    paramBundle = this.vdd;
    if ((i & 0x2) <= 0) {
      paramBundle.ade("invite_friends_by_message");
    }
    if ((i & 0x1) <= 0) {
      paramBundle.ade("invite_friends_by_mail");
    }
    if (((i & 0x4) <= 0) || (!au(this.mController.uMN, "com.whatsapp"))) {
      paramBundle.ade("invite_friends_by_whatsapp");
    }
    if (((i & 0x8) <= 0) || (!q.GI())) {
      paramBundle.ade("invite_friends_by_facebook");
    }
    if ((i & 0x10) <= 0) {
      paramBundle.ade("invite_friends_by_twitter");
    }
    paramBundle.notifyDataSetChanged();
    au.Dk().a(1803, this);
    au.Dk().a(1804, this);
    au.Dk().a(168, this);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        InviteFriendsBy3rdUI.this.finish();
        return true;
      }
    });
  }
  
  protected void onDestroy()
  {
    au.Dk().b(1803, this);
    au.Dk().b(1804, this);
    au.Dk().b(168, this);
    if (this.pxW == 0) {
      com.tencent.mm.plugin.report.service.h.nFQ.f(14035, new Object[] { Integer.valueOf(this.pxW), Integer.valueOf(pxU), Integer.valueOf(this.fromScene) });
    }
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.InviteFriendsBy3rdUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.service.h.nFQ.f(14035, new Object[] { Integer.valueOf(this.pxW), Integer.valueOf(pxU), Integer.valueOf(this.fromScene) });
    }
    if (paramm.getType() == 1803) {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        com.tencent.mm.ui.base.h.h(this.mController.uMN, R.l.loading_failed, R.l.app_tip);
      }
    }
    label185:
    label496:
    label888:
    do
    {
      return;
      paramString = (d)paramm;
      Object localObject1;
      int i;
      if (bk.bl(paramString.title))
      {
        localObject1 = null;
        paramString = (d)paramm;
        if (!bk.bl(paramString.content)) {
          break label866;
        }
        paramString = null;
        Object localObject2 = q.Gk();
        au.Hx();
        String str = (String)com.tencent.mm.model.c.Dz().get(6, null);
        Object localObject3 = localObject2;
        if (bk.bl((String)localObject2)) {
          localObject3 = str;
        }
        i = ((d)paramm).esw;
        localObject2 = paramString;
        if ((i & 0x1) > 0)
        {
          localObject2 = localObject1;
          if (bk.bl((String)localObject1)) {
            localObject2 = String.format(getString(R.l.invite_friends_mail_title), new Object[] { q.Gl() });
          }
          localObject1 = paramString;
          if (bk.bl(paramString)) {
            localObject1 = String.format(getString(R.l.invite_friends_mail_content), new Object[] { localObject3 });
          }
          paramString = new Intent("android.intent.action.SEND");
          paramString.putExtra("android.intent.extra.SUBJECT", (String)localObject2);
          paramString.putExtra("android.intent.extra.TEXT", (String)localObject1);
          paramString.setType("plain/text");
          startActivity(Intent.createChooser(paramString, getString(R.l.invite_friends_by_mail_select)));
          com.tencent.mm.plugin.report.service.h.nFQ.f(14035, new Object[] { Integer.valueOf(this.pxW), Integer.valueOf(pxV), Integer.valueOf(this.fromScene) });
          localObject2 = localObject1;
        }
        paramString = (String)localObject2;
        if ((i & 0x2) > 0)
        {
          paramString = (String)localObject2;
          if (bk.bl((String)localObject2)) {
            paramString = String.format(getString(R.l.invite_friends_message_content), new Object[] { localObject3 });
          }
          localObject1 = new Intent("android.intent.action.VIEW");
          ((Intent)localObject1).putExtra("sms_body", paramString);
          ((Intent)localObject1).setType("vnd.android-dir/mms-sms");
          if (!bk.i(this, (Intent)localObject1)) {
            break label874;
          }
          startActivity((Intent)localObject1);
          com.tencent.mm.plugin.report.service.h.nFQ.f(14035, new Object[] { Integer.valueOf(this.pxW), Integer.valueOf(pxV), Integer.valueOf(this.fromScene) });
        }
        localObject1 = paramString;
        if ((i & 0x4) > 0)
        {
          localObject1 = paramString;
          if (bk.bl(paramString)) {
            localObject1 = String.format(getString(R.l.invite_friends_message_content), new Object[] { localObject3 });
          }
          paramString = new Intent();
          paramString.setAction("android.intent.action.SEND");
          paramString.putExtra("android.intent.extra.TEXT", (String)localObject1);
          paramString.setType("text/plain");
          paramString.setPackage("com.whatsapp");
          startActivity(paramString);
          com.tencent.mm.plugin.report.service.h.nFQ.f(14035, new Object[] { Integer.valueOf(this.pxW), Integer.valueOf(pxV), Integer.valueOf(this.fromScene) });
        }
        localObject2 = localObject1;
        if ((i & 0x8) > 0)
        {
          paramString = (String)localObject1;
          if (bk.bl((String)localObject1))
          {
            if (!bk.bl(q.Gk())) {
              break label888;
            }
            paramString = getString(R.l.invite_friends_facebook_twitter_no_wechatid_content);
          }
          localObject1 = getString(R.l.invite_friends_by_facebook);
          localObject2 = paramString;
          if (this.pyc == true)
          {
            m(i, paramString, (String)localObject1);
            this.pyc = false;
            localObject2 = paramString;
          }
        }
        if ((i & 0x10) > 0)
        {
          this.piY.a(this);
          paramString = (String)localObject2;
          if (bk.bl((String)localObject2)) {
            if (!bk.bl(q.Gk())) {
              break label912;
            }
          }
        }
      }
      for (paramString = getString(R.l.invite_friends_facebook_twitter_no_wechatid_content);; paramString = String.format(getString(R.l.invite_friends_facebook_twitter_content), new Object[] { q.Gk() }))
      {
        localObject1 = getString(R.l.invite_friends_by_twitter);
        if (this.pyb == true)
        {
          m(i, paramString, (String)localObject1);
          this.pyb = false;
        }
        if (paramm.getType() != 1804) {
          break label993;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          break label936;
        }
        com.tencent.mm.ui.base.h.h(this.mController.uMN, R.l.sendrequest_send_fail, R.l.app_tip);
        return;
        localObject1 = paramString.title;
        break;
        paramString = paramString.content;
        break label185;
        Toast.makeText(this, R.l.selectsmsapp_none, 1).show();
        break label496;
        paramString = String.format(getString(R.l.invite_friends_facebook_twitter_content), new Object[] { q.Gk() });
        break label708;
      }
      com.tencent.mm.ui.base.h.bC(this, getResources().getString(R.l.confirm_dialog_sent));
      com.tencent.mm.plugin.report.service.h.nFQ.f(14035, new Object[] { Integer.valueOf(this.pxW), Integer.valueOf(pxV), Integer.valueOf(this.fromScene) });
    } while ((paramm.getType() != 168) || (paramInt1 != 0) || (paramInt2 != 0) || (this.pxZ == null));
    label708:
    label866:
    label874:
    if (this.kjT != null) {
      this.kjT.setVisibility(8);
    }
    label912:
    label936:
    label993:
    this.pxZ.setImageBitmap(bdf());
  }
  
  public final int xj()
  {
    return R.o.invate_friends_by_3rd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI
 * JD-Core Version:    0.7.0.1
 */