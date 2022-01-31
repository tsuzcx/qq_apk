package com.tencent.mm.ui.chatting.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.d;
import com.tencent.mm.at.l;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.b;
import com.tencent.mm.g.b.a.e.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

@SuppressLint({"UseSparseArrays"})
public final class c
  extends com.tencent.mm.ui.base.u
{
  public static long jUy = -1L;
  public static boolean muT = false;
  private String edK;
  private ArrayList<bi> mCl;
  public ImageGalleryUI zJK;
  protected c.a zJL;
  private String zJM;
  boolean zJN;
  public boolean zJO;
  public e zJP;
  public j zJQ;
  public i zJR;
  public c.c zJS;
  boolean zJT;
  protected boolean zJU;
  private com.tencent.mm.g.b.a.e zJV;
  
  public c(ImageGalleryUI paramImageGalleryUI, long paramLong1, String paramString1, boolean paramBoolean1, long paramLong2, boolean paramBoolean2, String paramString2, Boolean paramBoolean)
  {
    AppMethodBeat.i(31977);
    this.zJN = true;
    this.zJO = false;
    this.edK = null;
    this.zJU = true;
    this.mCl = new ArrayList();
    this.zJV = null;
    String str = "MicroMsg.ImageGalleryAdapter, invalid argument, context = " + paramImageGalleryUI + ", currentMsgId = " + paramLong1 + ", talker = " + paramString1 + ", stack = " + bo.dtY();
    if ((paramLong1 > 0L) && (paramString1 != null) && (paramString1.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(str, bool);
      this.zJK = paramImageGalleryUI;
      muT = paramBoolean1;
      jUy = paramLong2;
      this.edK = paramString1;
      this.zJL = new c.a(paramLong1, paramString1, this, paramBoolean);
      this.zJO = paramBoolean2;
      this.zJM = paramString2;
      this.zJP = new e(this);
      this.zJQ = new j(this);
      this.zJR = new i(this);
      AppMethodBeat.o(31977);
      return;
    }
  }
  
  public static boolean a(Context paramContext, bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(31997);
    if (parambi == null)
    {
      AppMethodBeat.o(31997);
      return false;
    }
    s locals = com.tencent.mm.modelvideo.o.alE().vd(parambi.field_imgPath);
    boolean bool = false;
    if (locals != null)
    {
      int i = 0;
      if (com.tencent.mm.model.t.lA(locals.getUser())) {
        i = com.tencent.mm.model.n.nv(locals.getUser());
      }
      bool = locals.alS();
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, 216L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.e(12084, new Object[] { Integer.valueOf(locals.fsd), Integer.valueOf(locals.fXx * 1000), Integer.valueOf(0), Integer.valueOf(2), locals.getUser(), Integer.valueOf(i), s.vc(locals.alP()), Long.valueOf(locals.createTime) });
    }
    if (!bool)
    {
      ab.w("MicroMsg.ImageGalleryAdapter", "do export video but video had not download finish.");
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131304521), 1).show();
      }
      AppMethodBeat.o(31997);
      return false;
    }
    com.tencent.mm.modelvideo.o.alE();
    parambi = com.tencent.mm.modelvideo.u.vs(com.tencent.mm.modelvideo.t.vf(parambi.field_imgPath));
    if (bo.isNullOrNil(parambi))
    {
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131304521), 1).show();
      }
      AppMethodBeat.o(31997);
      return false;
    }
    if (paramBoolean) {
      Toast.makeText(paramContext, paramContext.getString(2131304522, new Object[] { parambi }), 1).show();
    }
    com.tencent.mm.pluginsdk.ui.tools.n.a(parambi, paramContext);
    AppMethodBeat.o(31997);
    return true;
  }
  
  public static boolean b(Context paramContext, bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(31998);
    if (bs(parambi)) {}
    for (Object localObject = e(parambi); (localObject == null) || (((String)localObject).length() == 0); localObject = e.a(parambi, (com.tencent.mm.at.e)localObject))
    {
      ab.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + parambi.field_msgId);
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131302867), 1).show();
      }
      AppMethodBeat.o(31998);
      return false;
      if ((parambi == null) || (parambi.field_msgId == 0L))
      {
        ab.e("MicroMsg.ImageGalleryAdapter", "msg is null");
        if (paramBoolean) {
          Toast.makeText(paramContext, paramContext.getString(2131302867), 1).show();
        }
        AppMethodBeat.o(31998);
        return false;
      }
      localObject = e.d(parambi);
      if ((localObject == null) || (((com.tencent.mm.at.e)localObject).fDL == 0L))
      {
        StringBuilder localStringBuilder = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
        if (parambi == null)
        {
          parambi = "null";
          localStringBuilder = localStringBuilder.append(parambi).append(", imgLocalId = ");
          if (localObject != null) {
            break label241;
          }
        }
        label241:
        for (parambi = "null";; parambi = Long.valueOf(((com.tencent.mm.at.e)localObject).fDL))
        {
          ab.e("MicroMsg.ImageGalleryAdapter", parambi);
          if (paramBoolean) {
            Toast.makeText(paramContext, paramContext.getString(2131302867), 1).show();
          }
          AppMethodBeat.o(31998);
          return false;
          parambi = Long.valueOf(parambi.field_msgId);
          break;
        }
      }
    }
    if (!q.a((String)localObject, paramContext, paramBoolean, 2131298889))
    {
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131302867), 1).show();
      }
      AppMethodBeat.o(31998);
      return false;
    }
    AppMethodBeat.o(31998);
    return true;
  }
  
  public static boolean b(bi parambi, com.tencent.mm.at.e parame)
  {
    AppMethodBeat.i(31988);
    if ((parambi == null) || (parame == null))
    {
      AppMethodBeat.o(31988);
      return false;
    }
    boolean bool = com.tencent.mm.at.o.ahD().a(parame.fDL, parambi.field_msgId, 1);
    AppMethodBeat.o(31988);
    return bool;
  }
  
  public static boolean bq(bi parambi)
  {
    AppMethodBeat.i(31984);
    if (parambi == null)
    {
      AppMethodBeat.o(31984);
      return false;
    }
    if (parambi.getType() == 62)
    {
      AppMethodBeat.o(31984);
      return true;
    }
    AppMethodBeat.o(31984);
    return false;
  }
  
  public static boolean br(bi parambi)
  {
    AppMethodBeat.i(31985);
    if (parambi == null)
    {
      AppMethodBeat.o(31985);
      return false;
    }
    if (parambi.getType() == 49)
    {
      AppMethodBeat.o(31985);
      return true;
    }
    AppMethodBeat.o(31985);
    return false;
  }
  
  public static boolean bs(bi parambi)
  {
    AppMethodBeat.i(31986);
    if (parambi == null)
    {
      AppMethodBeat.o(31986);
      return false;
    }
    if (parambi.getType() == 268435505)
    {
      AppMethodBeat.o(31986);
      return true;
    }
    AppMethodBeat.o(31986);
    return false;
  }
  
  public static b bu(bi parambi)
  {
    AppMethodBeat.i(31991);
    b localb = b.zKo;
    if (parambi == null) {
      localb = b.zKo;
    }
    if (bs(parambi))
    {
      parambi = b.zKs;
      AppMethodBeat.o(31991);
      return parambi;
    }
    if (c(parambi))
    {
      parambi = b.zKp;
      AppMethodBeat.o(31991);
      return parambi;
    }
    if (bv(parambi))
    {
      parambi = b.zKr;
      AppMethodBeat.o(31991);
      return parambi;
    }
    if (f(parambi))
    {
      parambi = b.zKq;
      AppMethodBeat.o(31991);
      return parambi;
    }
    if (bq(parambi))
    {
      parambi = b.zKq;
      AppMethodBeat.o(31991);
      return parambi;
    }
    parambi = b.zKo;
    AppMethodBeat.o(31991);
    return parambi;
  }
  
  private static boolean bv(bi parambi)
  {
    AppMethodBeat.i(31992);
    if (parambi != null)
    {
      parambi = com.tencent.mm.modelvideo.u.vr(parambi.field_imgPath);
      if ((parambi != null) && (parambi.fXG != null) && ((!bo.isNullOrNil(parambi.fXG.fiO)) || (parambi.fXG.wUJ > 0) || (!bo.isNullOrNil(parambi.fXG.fiR)) || (!bo.isNullOrNil(parambi.fXG.fiS)) || (!bo.isNullOrNil(parambi.fXG.fiQ)) || (!bo.isNullOrNil(parambi.fXG.fiT)) || (!bo.isNullOrNil(parambi.fXG.fiU)) || (!bo.isNullOrNil(parambi.fXG.fiV))))
      {
        AppMethodBeat.o(31992);
        return true;
      }
    }
    AppMethodBeat.o(31992);
    return false;
  }
  
  public static int c(bi parambi, com.tencent.mm.at.e parame)
  {
    AppMethodBeat.i(32003);
    if (parambi.field_isSend == 1)
    {
      if (parame.ahh())
      {
        parambi = com.tencent.mm.at.f.a(parame);
        if ((parambi != null) && (parambi.fDL > 0L) && (parambi.ahg()) && (com.tencent.mm.vfs.e.cN(com.tencent.mm.at.o.ahC().q(parambi.fDM, "", ""))))
        {
          AppMethodBeat.o(32003);
          return 1;
        }
      }
      AppMethodBeat.o(32003);
      return 0;
    }
    if (parame.ahg())
    {
      if (parame.ahh())
      {
        parambi = com.tencent.mm.at.f.a(parame);
        if ((parambi != null) && (parambi.fDL > 0L) && (parambi.ahg()) && (com.tencent.mm.vfs.e.cN(com.tencent.mm.at.o.ahC().q(parambi.fDM, "", ""))))
        {
          AppMethodBeat.o(32003);
          return 1;
        }
      }
      AppMethodBeat.o(32003);
      return 0;
    }
    AppMethodBeat.o(32003);
    return 0;
  }
  
  public static boolean c(bi parambi)
  {
    AppMethodBeat.i(31982);
    if (parambi == null)
    {
      AppMethodBeat.o(31982);
      return false;
    }
    if ((parambi.getType() == 3) || (parambi.getType() == 39) || (parambi.getType() == 13))
    {
      AppMethodBeat.o(31982);
      return true;
    }
    AppMethodBeat.o(31982);
    return false;
  }
  
  public static String e(bi parambi)
  {
    Object localObject1 = null;
    AppMethodBeat.i(32001);
    Object localObject2 = j.b.mY(parambi.field_content);
    if (localObject2 == null)
    {
      AppMethodBeat.o(32001);
      return null;
    }
    parambi = localObject1;
    if (((j.b)localObject2).cmN != null)
    {
      parambi = localObject1;
      if (((j.b)localObject2).cmN.length() > 0)
      {
        localObject2 = al.aUJ().alo(((j.b)localObject2).cmN);
        parambi = localObject1;
        if (localObject2 != null) {
          parambi = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath;
        }
      }
    }
    AppMethodBeat.o(32001);
    return parambi;
  }
  
  public static boolean f(Context paramContext, List<bi> paramList)
  {
    AppMethodBeat.i(31996);
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(31996);
      return false;
    }
    boolean bool1;
    int i;
    label52:
    bi localbi;
    boolean bool2;
    if (paramList.size() <= 1)
    {
      bool1 = true;
      paramList = paramList.iterator();
      i = 0;
      if (!paramList.hasNext()) {
        break label120;
      }
      localbi = (bi)paramList.next();
      if (!f(localbi)) {
        break label108;
      }
      bool2 = a(paramContext, localbi, bool1);
      label89:
      if ((i != 0) || (!bool2)) {
        break label187;
      }
      i = 1;
    }
    label187:
    for (;;)
    {
      break label52;
      bool1 = false;
      break;
      label108:
      bool2 = b(paramContext, localbi, bool1);
      break label89;
      label120:
      if ((i == 0) && (!bool1)) {
        Toast.makeText(paramContext, paramContext.getString(2131302868), 1).show();
      }
      for (;;)
      {
        AppMethodBeat.o(31996);
        return true;
        if ((i != 0) && (!bool1)) {
          Toast.makeText(paramContext, paramContext.getString(2131299498, new Object[] { com.tencent.mm.compatible.util.e.esr }), 1).show();
        }
      }
    }
  }
  
  public static boolean f(bi parambi)
  {
    AppMethodBeat.i(31983);
    if (parambi == null)
    {
      AppMethodBeat.o(31983);
      return false;
    }
    if (bv(parambi))
    {
      AppMethodBeat.o(31983);
      return false;
    }
    if ((parambi.getType() == 43) || (parambi.getType() == 44) || (parambi.getType() == 62))
    {
      AppMethodBeat.o(31983);
      return true;
    }
    AppMethodBeat.o(31983);
    return false;
  }
  
  private void l(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(31994);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.ImageGalleryAdapter", "doRestransmitImg fail, imgPath is null");
      AppMethodBeat.o(31994);
      return;
    }
    if (bo.isNullOrNil(this.zJM))
    {
      ab.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
      Intent localIntent = new Intent(this.zJK, MsgRetransmitUI.class);
      localIntent.putExtra("Retr_File_Name", paramString);
      localIntent.putExtra("Retr_Msg_Id", paramLong);
      localIntent.putExtra("Retr_Msg_Type", 0);
      localIntent.putExtra("Retr_Compress_Type", paramInt);
      this.zJK.startActivity(localIntent);
      AppMethodBeat.o(31994);
      return;
    }
    ab.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", new Object[] { this.zJM });
    if (!bo.isNullOrNil(paramString))
    {
      paramString = new l(r.Zn(), this.zJM, paramString, paramInt);
      aw.Rc().a(paramString, 0);
      bv.abc().c(bv.fnI, null);
    }
    if (this.zJN)
    {
      paramString = new Intent(this.zJK, ChattingUI.class);
      paramString.addFlags(67108864);
      paramString.putExtra("Chat_User", this.zJM);
      this.zJK.startActivity(paramString);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), this.zJM });
      AppMethodBeat.o(31994);
      return;
      com.tencent.mm.ui.base.h.bO(this.zJK, this.zJK.getString(2131297064));
    }
  }
  
  public final void PR(int paramInt)
  {
    AppMethodBeat.i(31989);
    bi localbi = Pz(paramInt);
    Object localObject = bu(localbi);
    switch (2.zJZ[localObject.ordinal()])
    {
    default: 
      bx(localbi);
      AppMethodBeat.o(31989);
      return;
    case 1: 
    case 2: 
      bw(localbi);
      AppMethodBeat.o(31989);
      return;
    }
    localObject = e(localbi);
    Intent localIntent = new Intent(this.zJK, MsgRetransmitUI.class);
    localIntent.putExtra("Retr_File_Name", (String)localObject);
    localIntent.putExtra("Retr_Msg_Id", localbi.field_msgId);
    localIntent.putExtra("Retr_Msg_Type", 16);
    localIntent.putExtra("Retr_Msg_content", localbi.field_content);
    localIntent.putExtra("Retr_Compress_Type", 0);
    this.zJK.startActivity(localIntent);
    AppMethodBeat.o(31989);
  }
  
  public final void PS(int paramInt)
  {
    AppMethodBeat.i(31990);
    bi localbi = Pz(paramInt);
    Object localObject = bu(localbi);
    switch (2.zJZ[localObject.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31990);
      return;
      localObject = new Intent(this.zJK, ChattingSendDataToDeviceUI.class);
      ((Intent)localObject).putExtra("Retr_Msg_Id", localbi.field_msgId);
      this.zJK.startActivity((Intent)localObject);
    }
  }
  
  public final void PT(int paramInt)
  {
    AppMethodBeat.i(31999);
    bi localbi = Pz(paramInt);
    cm localcm = new cm();
    com.tencent.mm.pluginsdk.model.e.d(localcm, localbi);
    localcm.cpR.activity = this.zJK;
    localcm.cpR.cpY = 44;
    com.tencent.mm.sdk.b.a.ymk.l(localcm);
    if (localcm.cpS.ret == 0)
    {
      if (localbi.byk()) {
        com.tencent.mm.ui.chatting.a.a(a.c.zvl, a.d.zvr, localbi, 0);
      }
      com.tencent.mm.modelstat.b.fRu.D(localbi);
    }
    AppMethodBeat.o(31999);
  }
  
  public final View PU(int paramInt)
  {
    AppMethodBeat.i(32007);
    View localView3 = super.Gm(paramInt);
    if (localView3 == null)
    {
      ab.e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(32007);
      return null;
    }
    View localView2 = localView3.findViewById(2131825120);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = localView3.findViewById(2131824108);
    }
    if ((localView1 == null) || (localView1.getVisibility() == 8))
    {
      AppMethodBeat.o(32007);
      return null;
    }
    AppMethodBeat.o(32007);
    return localView1;
  }
  
  public final void PV(int paramInt)
  {
    AppMethodBeat.i(32008);
    this.zJQ.i(Pz(paramInt), paramInt);
    AppMethodBeat.o(32008);
  }
  
  public final void PW(int paramInt)
  {
    AppMethodBeat.i(32009);
    this.zJQ.j(Pz(paramInt), paramInt);
    AppMethodBeat.o(32009);
  }
  
  public final void PX(int paramInt)
  {
    AppMethodBeat.i(32012);
    this.zJQ.PQ(paramInt);
    AppMethodBeat.o(32012);
  }
  
  public final void PY(int paramInt)
  {
    AppMethodBeat.i(32015);
    bi localbi = Pz(paramInt);
    if ((localbi == null) || (!c(localbi)))
    {
      AppMethodBeat.o(32015);
      return;
    }
    this.zJP.bC(localbi);
    AppMethodBeat.o(32015);
  }
  
  public final void PZ(int paramInt)
  {
    AppMethodBeat.i(32016);
    this.zJR.Qf(paramInt);
    AppMethodBeat.o(32016);
  }
  
  public final bi Pz(int paramInt)
  {
    AppMethodBeat.i(31979);
    bi localbi = this.zJL.Qb(paramInt);
    AppMethodBeat.o(31979);
    return localbi;
  }
  
  public final void a(bi parambi, com.tencent.mm.at.e parame, int paramInt, e.a parama)
  {
    AppMethodBeat.i(32019);
    if (parambi == null)
    {
      AppMethodBeat.o(32019);
      return;
    }
    if (this.zJV == null)
    {
      AppMethodBeat.o(32019);
      return;
    }
    this.zJV.Fk().cPN = parama;
    long l1 = parambi.field_msgSvrId;
    if (paramInt == 1) {}
    for (int i = 1; (this.zJV.cPF != l1) && (this.zJV.cPH != i); i = 0)
    {
      ab.w("MicroMsg.ImageGalleryAdapter", "waiting img[%d] download finish but other img[%d] download finish callback don't report", new Object[] { Long.valueOf(this.zJV.cPF), Long.valueOf(l1) });
      parambi = this.zJV;
      parambi.cPN = e.a.cPP;
      parambi.ake();
      AppMethodBeat.o(32019);
      return;
    }
    long l4 = 0L;
    long l5 = 0L;
    long l6 = 0L;
    long l7 = bo.yB();
    long l3 = l6;
    long l2 = l5;
    l1 = l4;
    if (parama == e.a.cPO)
    {
      parambi = e.a(parambi, parame);
      l3 = l6;
      l2 = l5;
      l1 = l4;
      if (!bo.isNullOrNil(parambi))
      {
        l1 = com.tencent.mm.vfs.e.avI(parambi);
        parambi = e.aud(parambi);
        l3 = parambi.outWidth;
        l2 = parambi.outHeight;
      }
    }
    parambi = this.zJV;
    parambi.cPI = l1;
    parambi.cPK = l2;
    parambi.cPJ = l3;
    this.zJV.ake();
    ab.i("MicroMsg.ImageGalleryAdapter", "stopWaitingImg [%d] [%s]", new Object[] { Long.valueOf(bo.av(l7)), this.zJV.Ff() });
    this.zJV = null;
    AppMethodBeat.o(32019);
  }
  
  public final void aI(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32004);
    this.zJP.aI(paramInt, paramBoolean);
    AppMethodBeat.o(32004);
  }
  
  public final boolean bt(bi parambi)
  {
    AppMethodBeat.i(31987);
    if (parambi == null)
    {
      AppMethodBeat.o(31987);
      return false;
    }
    com.tencent.mm.at.e locale = f(parambi, false);
    if (locale != null)
    {
      if ((parambi == null) || (locale == null))
      {
        AppMethodBeat.o(31987);
        return false;
      }
      if ((com.tencent.mm.at.o.ahD().a(locale.fDL, parambi.field_msgId, 0)) || (b(parambi, locale)))
      {
        AppMethodBeat.o(31987);
        return true;
      }
      AppMethodBeat.o(31987);
      return false;
    }
    parambi = j.bH(parambi);
    if (parambi != null)
    {
      if (parambi == null)
      {
        AppMethodBeat.o(31987);
        return false;
      }
      int i = parambi.status;
      int j = com.tencent.mm.modelvideo.u.g(parambi);
      if (((i == 112) || (i == 122)) && (j < 100)) {}
      for (boolean bool = true;; bool = false)
      {
        ab.i("MicroMsg.ImageGalleryAdapter", "it is video downloading %b, status %d, download progress %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(31987);
        return bool;
      }
    }
    AppMethodBeat.o(31987);
    return false;
  }
  
  public final void bw(bi parambi)
  {
    AppMethodBeat.i(31993);
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.ii(this.zJK);
      AppMethodBeat.o(31993);
      return;
    }
    s locals = com.tencent.mm.modelvideo.u.vr(parambi.field_imgPath);
    if (locals == null)
    {
      ab.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
      AppMethodBeat.o(31993);
      return;
    }
    Intent localIntent = new Intent(this.zJK, MsgRetransmitUI.class);
    localIntent.putExtra("Retr_length", locals.fXx);
    localIntent.putExtra("Retr_File_Name", parambi.field_imgPath);
    localIntent.putExtra("Retr_video_isexport", locals.fXB);
    if (bq(parambi)) {}
    for (int i = 11;; i = 1)
    {
      localIntent.putExtra("Retr_Msg_Type", i);
      localIntent.putExtra("Retr_Msg_Id", parambi.field_msgId);
      localIntent.putExtra("Retr_From", "gallery");
      this.zJK.startActivity(localIntent);
      AppMethodBeat.o(31993);
      return;
    }
  }
  
  public final void bx(bi parambi)
  {
    AppMethodBeat.i(31995);
    com.tencent.mm.at.e locale = e.d(parambi);
    if ((parambi == null) || (parambi.field_msgId == 0L) || (locale == null) || (locale.fDL == 0L))
    {
      localObject = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
      if (parambi == null)
      {
        parambi = "null";
        localObject = ((StringBuilder)localObject).append(parambi).append(", imgLocalId = ");
        if (locale != null) {
          break label107;
        }
      }
      label107:
      for (parambi = "null";; parambi = Long.valueOf(locale.fDL))
      {
        ab.e("MicroMsg.ImageGalleryAdapter", parambi);
        AppMethodBeat.o(31995);
        return;
        parambi = Long.valueOf(parambi.field_msgId);
        break;
      }
    }
    Object localObject = e.a(parambi, locale);
    if (bo.isNullOrNil((String)localObject))
    {
      ab.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + parambi.field_msgId + ", imgLocalId = " + locale.fDL);
      AppMethodBeat.o(31995);
      return;
    }
    l((String)localObject, c(parambi, locale), parambi.field_msgId);
    AppMethodBeat.o(31995);
  }
  
  public final View d(int paramInt, View paramView)
  {
    AppMethodBeat.i(32000);
    bi localbi = Pz(paramInt);
    View localView;
    k localk;
    if (paramView == null)
    {
      localView = View.inflate(this.zJK, 2130969892, null);
      localk = new k(this, localView);
      localView.setTag(localk);
      paramView = bu(localbi);
      localk.mPosition = paramInt;
      localk.zNi = paramView;
      k.aq(localk.ngZ, 0);
      switch (k.5.zJZ[paramView.ordinal()])
      {
      default: 
        label108:
        k.aq(localk.zNF, 8);
        k.aq(localk.zNG, 8);
        k.aq(localk.zNH, 8);
        k.aq(localk.zNw, 8);
        k.aq(localk.zNC, 8);
        k.aq(localk.zNB, 8);
        ab.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", new Object[] { Integer.valueOf(paramInt), paramView });
        switch (2.zJZ[paramView.ordinal()])
        {
        }
        break;
      }
    }
    for (;;)
    {
      this.zJU = false;
      AppMethodBeat.o(32000);
      return localView;
      localk = (k)paramView.getTag();
      localView = paramView;
      break;
      k.aq(localk.zNq, 8);
      k.aq(localk.zNk, 8);
      break label108;
      localk.dKP();
      k.aq(localk.zNq, 0);
      k.aq(localk.zNk, 8);
      if (localk.zNk == null) {
        break label108;
      }
      k.aq(localk.zNm, 8);
      break label108;
      localk.dKO();
      k.aq(localk.zNq, 8);
      k.aq(localk.zNk, 0);
      break label108;
      k.aq(localk.ngZ, 8);
      k.aq(localk.zNq, 8);
      k.aq(localk.zNk, 8);
      break label108;
      this.zJP.a(localk, localbi, paramInt);
      if (paramInt == 100000)
      {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.comm.a.b.class)).T(localbi);
        continue;
        k.aq(localk.zNF, 0);
        k.aq(localk.zNw, 8);
        k.aq(localk.zNB, 8);
        k.aq(localk.zNC, 8);
        k.aq(localk.zNu, 8);
        String str = e(localbi);
        try
        {
          paramView = x.wy(str);
          localObject = paramView;
          if (paramView == null)
          {
            localObject = x.wx(com.tencent.mm.at.o.ahC().J(localbi.field_imgPath, true));
            k.aq(localk.zNB, 0);
            new ak().post(new c.1(this, localbi, localk, str));
          }
          if (localObject == null)
          {
            ab.w("MicroMsg.ImageGalleryAdapter", "get image fail");
            localk.zNF.setVisibility(8);
            localk.dKN().zNC.setVisibility(0);
            localk.dKN().zNE.setImageResource(2131231546);
            localk.dKN().zND.setText(this.zJK.getString(2131300727));
            if (paramInt != 100000) {
              continue;
            }
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.comm.a.b.class)).T(localbi);
          }
        }
        catch (OutOfMemoryError paramView)
        {
          for (;;)
          {
            Object localObject;
            ab.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[] { str });
            Runtime.getRuntime().gc();
            Runtime.getRuntime().runFinalization();
            paramView = x.wx(str);
            continue;
            localk.zNF.setEnableHorLongBmpMode(false);
            com.tencent.mm.sdk.platformtools.n.x(localk.zNF, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localk.zNF.cb(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localk.zNF.setImageBitmap((Bitmap)localObject);
            localk.zNF.invalidate();
          }
        }
        this.zJQ.a(localk, localbi, paramInt);
        continue;
        this.zJR.a(localk, localbi, paramInt);
      }
    }
  }
  
  public final void dJV()
  {
    AppMethodBeat.i(31980);
    this.zJL.dJV();
    AppMethodBeat.o(31980);
  }
  
  public final boolean dJW()
  {
    return this.zJL.prepared;
  }
  
  public final bi dJX()
  {
    AppMethodBeat.i(32010);
    bi localbi = Pz(this.zJK.getCurrentItem());
    AppMethodBeat.o(32010);
    return localbi;
  }
  
  public final k dJY()
  {
    AppMethodBeat.i(32011);
    Object localObject2 = this.zJP.PP(this.zJK.getCurrentItem());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.zJQ.PP(this.zJK.getCurrentItem());
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.zJR.PP(this.zJK.getCurrentItem());
    }
    AppMethodBeat.o(32011);
    return localObject2;
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(32014);
    this.zJQ.onResume();
    AppMethodBeat.o(32014);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(32017);
    paramViewGroup.removeView((View)paramObject);
    super.destroyItem(paramViewGroup, paramInt, paramObject);
    AppMethodBeat.o(32017);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(32002);
    this.zJP.detach();
    this.zJQ.detach();
    this.zJR.detach();
    if (this.zJV != null)
    {
      com.tencent.mm.g.b.a.e locale = this.zJV.Fk();
      locale.cPN = e.a.cPP;
      locale.ake();
    }
    super.detach();
    AppMethodBeat.o(32002);
  }
  
  public final com.tencent.mm.at.e f(bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(31981);
    parambi = this.zJP.f(parambi, paramBoolean);
    AppMethodBeat.o(31981);
    return parambi;
  }
  
  public final int firstItemPosForDetermine()
  {
    return 100000 - this.zJL.zKb;
  }
  
  public final void g(bi parambi, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(32018);
    if (parambi == null)
    {
      AppMethodBeat.o(32018);
      return;
    }
    Object localObject = dJX();
    if ((localObject == null) || (((dd)localObject).field_msgId != parambi.field_msgId))
    {
      ab.d("MicroMsg.ImageGalleryAdapter", "it is not curr msg[%d] handle nothing. arg msg[%d]", new Object[] { Long.valueOf(((dd)localObject).field_msgId), Long.valueOf(parambi.field_msgId) });
      AppMethodBeat.o(32018);
      return;
    }
    long l = parambi.field_msgSvrId;
    if ((this.zJV != null) && ((this.zJV.cPF != l) || (this.zJV.cPH != paramBoolean)))
    {
      localObject = this.zJV.Fk();
      ((com.tencent.mm.g.b.a.e)localObject).cPN = e.a.cPP;
      ((com.tencent.mm.g.b.a.e)localObject).ake();
    }
    this.zJV = new com.tencent.mm.g.b.a.e();
    this.zJV.Fj();
    localObject = this.zJV;
    ((com.tencent.mm.g.b.a.e)localObject).cPF = l;
    ((com.tencent.mm.g.b.a.e)localObject).cPG = parambi.field_createTime;
    ((com.tencent.mm.g.b.a.e)localObject).cPH = paramBoolean;
    if (com.tencent.mm.model.t.lA(this.edK)) {
      i = com.tencent.mm.model.n.nv(this.edK);
    }
    this.zJV.eQ(this.edK).cPE = i;
    AppMethodBeat.o(32018);
  }
  
  public final int getCount()
  {
    c.a locala = this.zJL;
    return locala.eke - locala.zKb + 100000 + 1;
  }
  
  public final int getRealCount()
  {
    return this.zJL.eke;
  }
  
  public final int lastItemPosForDetermine()
  {
    return 100000 - this.zJL.zKb + this.zJL.eke - 1;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(32013);
    super.notifyDataSetChanged();
    AppMethodBeat.o(32013);
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(31978);
    if ((this.zJP != null) && (c(Pz(paramInt)))) {
      this.zJP.zLb.onPageSelected(paramInt);
    }
    AppMethodBeat.o(31978);
  }
  
  public final MultiTouchImageView wT(int paramInt)
  {
    AppMethodBeat.i(32005);
    Object localObject = super.Gm(paramInt);
    if (localObject == null)
    {
      ab.e("MicroMsg.ImageGalleryAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(32005);
      return null;
    }
    localObject = ((View)localObject).findViewById(2131820629);
    if ((localObject == null) || (((View)localObject).getVisibility() == 8))
    {
      AppMethodBeat.o(32005);
      return null;
    }
    localObject = (MultiTouchImageView)localObject;
    AppMethodBeat.o(32005);
    return localObject;
  }
  
  public final WxImageView wU(int paramInt)
  {
    AppMethodBeat.i(32006);
    Object localObject = super.Gm(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(32006);
      return null;
    }
    localObject = ((View)localObject).findViewById(2131825112);
    if ((localObject == null) || (((View)localObject).getVisibility() == 8))
    {
      AppMethodBeat.o(32006);
      return null;
    }
    localObject = (WxImageView)localObject;
    AppMethodBeat.o(32006);
    return localObject;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(31976);
      zKo = new b("unkown", 0);
      zKp = new b("image", 1);
      zKq = new b("video", 2);
      zKr = new b("sight", 3);
      zKs = new b("appimage", 4);
      zKt = new b[] { zKo, zKp, zKq, zKr, zKs };
      AppMethodBeat.o(31976);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c
 * JD-Core Version:    0.7.0.1
 */