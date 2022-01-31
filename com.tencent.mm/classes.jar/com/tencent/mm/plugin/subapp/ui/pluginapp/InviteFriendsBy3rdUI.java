package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.Activity;
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
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.m.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.j.a.a;
import com.tencent.mm.ui.j.a.b;
import com.tencent.mm.ui.j.a.c;

public class InviteFriendsBy3rdUI
  extends MMPreference
  implements com.tencent.mm.ai.f, a.a, a.b
{
  private static int sZD = 1;
  private static int sZE = 2;
  private static int sZF = 3;
  private static int sZG = 4;
  private static int sZH = 5;
  private static int sZI = 0;
  private static int sZJ = 1;
  private ProgressDialog eeN;
  private int fromScene;
  private ProgressBar mEy;
  private ProgressDialog nVm;
  private int sZK;
  private Bitmap sZL;
  private View sZM;
  private ImageView sZN;
  private EditText sZO;
  private boolean sZP;
  private boolean sZQ;
  private com.tencent.mm.ui.j.a sbA;
  
  public InviteFriendsBy3rdUI()
  {
    AppMethodBeat.i(25545);
    this.sZK = 0;
    this.eeN = null;
    this.nVm = null;
    this.sZL = null;
    this.sZN = null;
    this.mEy = null;
    this.sZO = null;
    this.sbA = new com.tencent.mm.ui.j.a();
    this.sZP = false;
    this.sZQ = false;
    AppMethodBeat.o(25545);
  }
  
  private void Go(int paramInt)
  {
    AppMethodBeat.i(25550);
    com.tencent.mm.modelmulti.d locald = new com.tencent.mm.modelmulti.d(paramInt);
    getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b(this, getString(2131301086), true, new InviteFriendsBy3rdUI.8(this, locald));
    aw.Rc().a(locald, 0);
    AppMethodBeat.o(25550);
  }
  
  /* Error */
  private static byte[] Rt(String paramString)
  {
    // Byte code:
    //   0: sipush 25556
    //   3: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 134	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: invokestatic 140	com/tencent/mm/model/c:YK	()Ljava/lang/String;
    //   13: astore_1
    //   14: invokestatic 134	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   17: pop
    //   18: aload_1
    //   19: invokestatic 143	com/tencent/mm/model/c:YL	()Ljava/lang/String;
    //   22: ldc 145
    //   24: aload_0
    //   25: invokevirtual 151	java/lang/String:getBytes	()[B
    //   28: invokestatic 157	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   31: ldc 159
    //   33: invokestatic 165	com/tencent/mm/sdk/platformtools/j:h	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_0
    //   37: new 167	java/io/RandomAccessFile
    //   40: dup
    //   41: aload_0
    //   42: ldc 169
    //   44: invokespecial 172	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: astore_1
    //   48: aload_1
    //   49: astore_0
    //   50: aload_1
    //   51: invokevirtual 176	java/io/RandomAccessFile:length	()J
    //   54: l2i
    //   55: newarray byte
    //   57: astore_2
    //   58: aload_1
    //   59: astore_0
    //   60: aload_1
    //   61: aload_2
    //   62: invokevirtual 180	java/io/RandomAccessFile:read	([B)I
    //   65: pop
    //   66: aload_1
    //   67: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   70: sipush 25556
    //   73: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_2
    //   77: areturn
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: astore_0
    //   83: ldc 185
    //   85: aload_2
    //   86: ldc 187
    //   88: iconst_0
    //   89: anewarray 189	java/lang/Object
    //   92: invokestatic 195	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_1
    //   96: ifnull +7 -> 103
    //   99: aload_1
    //   100: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   103: sipush 25556
    //   106: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: ifnull +7 -> 122
    //   118: aload_0
    //   119: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   122: sipush 25556
    //   125: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_1
    //   129: athrow
    //   130: astore_0
    //   131: goto -61 -> 70
    //   134: astore_0
    //   135: goto -32 -> 103
    //   138: astore_0
    //   139: goto -17 -> 122
    //   142: astore_1
    //   143: goto -29 -> 114
    //   146: astore_2
    //   147: goto -66 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramString	String
    //   13	87	1	localObject1	Object
    //   111	18	1	localObject2	Object
    //   142	1	1	localObject3	Object
    //   57	20	2	arrayOfByte	byte[]
    //   78	8	2	localException1	java.lang.Exception
    //   146	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   37	48	78	java/lang/Exception
    //   37	48	111	finally
    //   66	70	130	java/lang/Exception
    //   99	103	134	java/lang/Exception
    //   118	122	138	java/lang/Exception
    //   50	58	142	finally
    //   60	66	142	finally
    //   83	95	142	finally
    //   50	58	146	java/lang/Exception
    //   60	66	146	java/lang/Exception
  }
  
  private static boolean aD(Context paramContext, String paramString)
  {
    AppMethodBeat.i(25551);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25551);
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      AppMethodBeat.o(25551);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(25551);
    }
    return false;
  }
  
  private static void adX(String paramString)
  {
    AppMethodBeat.i(25557);
    aw.aaz();
    paramString = new com.tencent.mm.bb.a(paramString, bo.g((Integer)c.Ru().get(66561, null)));
    aw.Rc().a(paramString, 0);
    AppMethodBeat.o(25557);
  }
  
  private static Bitmap bKp()
  {
    AppMethodBeat.i(25555);
    Object localObject = Rt(r.Zn());
    if (localObject == null)
    {
      AppMethodBeat.o(25555);
      return null;
    }
    localObject = com.tencent.mm.sdk.platformtools.d.bT((byte[])localObject);
    AppMethodBeat.o(25555);
    return localObject;
  }
  
  private void w(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(25554);
    this.sZM = View.inflate(getContext(), 2130969201, null);
    this.sZO = ((EditText)this.sZM.findViewById(2131822990));
    this.sZN = ((ImageView)this.sZM.findViewById(2131822989));
    this.mEy = ((ProgressBar)this.sZM.findViewById(2131821643));
    ((View)this.sZN.getParent()).setVisibility(8);
    this.sZO.setText(paramString1);
    this.sZL = bKp();
    if (this.sZL == null)
    {
      adX(r.Zn());
      ((ProgressBar)this.sZM.findViewById(2131821643)).setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.pluginsdk.ui.applet.g.a(this.mController, paramString2, this.sZM, getResources().getString(2131297067), new InviteFriendsBy3rdUI.2(this, paramString1, paramInt));
      AppMethodBeat.o(25554);
      return;
      if (this.sZN != null) {
        this.sZN.setImageBitmap(this.sZL);
      }
    }
  }
  
  private void xU(int paramInt)
  {
    AppMethodBeat.i(25552);
    com.tencent.mm.ui.base.h.a(getContext(), paramInt, 2131297087, new DialogInterface.OnClickListener()new InviteFriendsBy3rdUI.11
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new InviteFriendsBy3rdUI.11(this));
    AppMethodBeat.o(25552);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(25553);
    if (this.nVm != null) {
      this.nVm.cancel();
    }
    switch (InviteFriendsBy3rdUI.3.nVJ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25553);
      return;
      xU(2131304399);
      AppMethodBeat.o(25553);
      return;
      AppMethodBeat.o(25553);
      return;
      xU(2131304398);
    }
  }
  
  public final void b(a.c paramc) {}
  
  public int getResourceId()
  {
    return 2131165244;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25546);
    super.onCreate(paramBundle);
    setMMTitle(2131299900);
    this.fromScene = getIntent().getIntExtra("Invite_friends", 4);
    int i = bo.getInt(com.tencent.mm.m.g.Nq().getValue("InviteFriendsInviteFlags"), 0);
    paramBundle = getPreferenceScreen();
    if ((i & 0x2) <= 0) {
      paramBundle.aty("invite_friends_by_message");
    }
    if ((i & 0x1) <= 0) {
      paramBundle.aty("invite_friends_by_mail");
    }
    if (((i & 0x4) <= 0) || (!aD(getContext(), "com.whatsapp"))) {
      paramBundle.aty("invite_friends_by_whatsapp");
    }
    if (((i & 0x8) <= 0) || (!r.ZM())) {
      paramBundle.aty("invite_friends_by_facebook");
    }
    if ((i & 0x10) <= 0) {
      paramBundle.aty("invite_friends_by_twitter");
    }
    paramBundle.notifyDataSetChanged();
    aw.Rc().a(1803, this);
    aw.Rc().a(1804, this);
    aw.Rc().a(168, this);
    setBackBtn(new InviteFriendsBy3rdUI.1(this));
    AppMethodBeat.o(25546);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25547);
    aw.Rc().b(1803, this);
    aw.Rc().b(1804, this);
    aw.Rc().b(168, this);
    if (this.sZK == 0) {
      com.tencent.mm.plugin.report.service.h.qsU.e(14035, new Object[] { Integer.valueOf(this.sZK), Integer.valueOf(sZI), Integer.valueOf(this.fromScene) });
    }
    super.onDestroy();
    AppMethodBeat.o(25547);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(25548);
    if ("invite_friends_by_message".equals(paramPreference.mKey))
    {
      this.sZK = sZE;
      Go(2);
      AppMethodBeat.o(25548);
      return true;
    }
    if ("invite_friends_by_mail".equals(paramPreference.mKey))
    {
      this.sZK = sZD;
      Go(1);
      AppMethodBeat.o(25548);
      return true;
    }
    if ("invite_friends_by_whatsapp".equals(paramPreference.mKey))
    {
      this.sZK = sZF;
      Go(4);
      AppMethodBeat.o(25548);
      return true;
    }
    if ("invite_friends_by_facebook".equals(paramPreference.mKey))
    {
      this.sZK = sZG;
      if (r.ZP())
      {
        this.sZQ = true;
        Go(8);
      }
      for (;;)
      {
        AppMethodBeat.o(25548);
        return true;
        com.tencent.mm.ui.base.h.a(getContext(), 2131303251, 2131297087, new InviteFriendsBy3rdUI.4(this), new InviteFriendsBy3rdUI.5(this));
      }
    }
    if ("invite_friends_by_twitter".equals(paramPreference.mKey))
    {
      this.sZK = sZH;
      if (this.sbA.dOy())
      {
        this.sZP = true;
        Go(16);
      }
      for (;;)
      {
        AppMethodBeat.o(25548);
        return true;
        com.tencent.mm.ui.base.h.a(getContext(), 2131303493, 2131297087, new InviteFriendsBy3rdUI.6(this), new InviteFriendsBy3rdUI.7(this));
      }
    }
    AppMethodBeat.o(25548);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(25549);
    ab.i("MicroMsg.InviteFriendsBy3rdUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.service.h.qsU.e(14035, new Object[] { Integer.valueOf(this.sZK), Integer.valueOf(sZI), Integer.valueOf(this.fromScene) });
    }
    Object localObject1;
    label193:
    int i;
    if (paramm.getType() == 1803)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.ui.base.h.h(getContext(), 2131301084, 2131297087);
        AppMethodBeat.o(25549);
        return;
      }
      paramString = (com.tencent.mm.modelmulti.d)paramm;
      if (!bo.isNullOrNil(paramString.title)) {
        break label867;
      }
      localObject1 = null;
      paramString = (com.tencent.mm.modelmulti.d)paramm;
      if (!bo.isNullOrNil(paramString.content)) {
        break label876;
      }
      paramString = null;
      Object localObject2 = r.Zo();
      aw.aaz();
      String str = (String)c.Ru().get(6, null);
      Object localObject3 = localObject2;
      if (bo.isNullOrNil((String)localObject2)) {
        localObject3 = str;
      }
      i = ((com.tencent.mm.modelmulti.d)paramm).fIi;
      localObject2 = paramString;
      if ((i & 0x1) > 0)
      {
        localObject2 = localObject1;
        if (bo.isNullOrNil((String)localObject1)) {
          localObject2 = String.format(getString(2131300767), new Object[] { r.Zp() });
        }
        localObject1 = paramString;
        if (bo.isNullOrNil(paramString)) {
          localObject1 = String.format(getString(2131300766), new Object[] { localObject3 });
        }
        paramString = new Intent("android.intent.action.SEND");
        paramString.putExtra("android.intent.extra.SUBJECT", (String)localObject2);
        paramString.putExtra("android.intent.extra.TEXT", (String)localObject1);
        paramString.setType("plain/text");
        startActivity(Intent.createChooser(paramString, getString(2131300760)));
        com.tencent.mm.plugin.report.service.h.qsU.e(14035, new Object[] { Integer.valueOf(this.sZK), Integer.valueOf(sZJ), Integer.valueOf(this.fromScene) });
        localObject2 = localObject1;
      }
      paramString = (String)localObject2;
      if ((i & 0x2) > 0)
      {
        paramString = (String)localObject2;
        if (bo.isNullOrNil((String)localObject2)) {
          paramString = String.format(getString(2131300768), new Object[] { localObject3 });
        }
        localObject1 = new Intent("android.intent.action.VIEW");
        ((Intent)localObject1).putExtra("sms_body", paramString);
        ((Intent)localObject1).setType("vnd.android-dir/mms-sms");
        if (!bo.k(this, (Intent)localObject1)) {
          break label884;
        }
        startActivity((Intent)localObject1);
        label504:
        com.tencent.mm.plugin.report.service.h.qsU.e(14035, new Object[] { Integer.valueOf(this.sZK), Integer.valueOf(sZJ), Integer.valueOf(this.fromScene) });
      }
      localObject1 = paramString;
      if ((i & 0x4) > 0)
      {
        localObject1 = paramString;
        if (bo.isNullOrNil(paramString)) {
          localObject1 = String.format(getString(2131300768), new Object[] { localObject3 });
        }
        paramString = new Intent();
        paramString.setAction("android.intent.action.SEND");
        paramString.putExtra("android.intent.extra.TEXT", (String)localObject1);
        paramString.setType("text/plain");
        paramString.setPackage("com.whatsapp");
        startActivity(paramString);
        com.tencent.mm.plugin.report.service.h.qsU.e(14035, new Object[] { Integer.valueOf(this.sZK), Integer.valueOf(sZJ), Integer.valueOf(this.fromScene) });
      }
      localObject2 = localObject1;
      if ((i & 0x8) > 0)
      {
        paramString = (String)localObject1;
        if (bo.isNullOrNil((String)localObject1))
        {
          if (!bo.isNullOrNil(r.Zo())) {
            break label898;
          }
          paramString = getString(2131300765);
        }
        label716:
        localObject1 = getString(2131300757);
        localObject2 = paramString;
        if (this.sZQ == true)
        {
          w(i, paramString, (String)localObject1);
          this.sZQ = false;
          localObject2 = paramString;
        }
      }
      if ((i & 0x10) > 0)
      {
        this.sbA.a(this);
        paramString = (String)localObject2;
        if (bo.isNullOrNil((String)localObject2)) {
          if (!bo.isNullOrNil(r.Zo())) {
            break label922;
          }
        }
      }
    }
    label898:
    label922:
    for (paramString = getString(2131300765);; paramString = String.format(getString(2131300764), new Object[] { r.Zo() }))
    {
      localObject1 = getString(2131300762);
      if (this.sZP == true)
      {
        w(i, paramString, (String)localObject1);
        this.sZP = false;
      }
      if (paramm.getType() != 1804) {
        break label1003;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label946;
      }
      com.tencent.mm.ui.base.h.h(getContext(), 2131303126, 2131297087);
      AppMethodBeat.o(25549);
      return;
      label867:
      localObject1 = paramString.title;
      break;
      label876:
      paramString = paramString.content;
      break label193;
      label884:
      Toast.makeText(this, 2131303076, 1).show();
      break label504;
      paramString = String.format(getString(2131300764), new Object[] { r.Zo() });
      break label716;
    }
    label946:
    com.tencent.mm.ui.base.h.bO(this, getResources().getString(2131298502));
    com.tencent.mm.plugin.report.service.h.qsU.e(14035, new Object[] { Integer.valueOf(this.sZK), Integer.valueOf(sZJ), Integer.valueOf(this.fromScene) });
    label1003:
    if (paramm.getType() == 168)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(25549);
        return;
      }
      if (this.sZN != null)
      {
        if (this.mEy != null) {
          this.mEy.setVisibility(8);
        }
        this.sZN.setImageBitmap(bKp());
      }
    }
    AppMethodBeat.o(25549);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI
 * JD-Core Version:    0.7.0.1
 */