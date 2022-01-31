package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.js;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class a
  implements f
{
  private String chatroomName = "";
  private Context context;
  public String fiE = "";
  public String kzG = "";
  private LinkedList<String> nkA;
  private LinkedList<Integer> nkB;
  private a.a sbF;
  public a.b sbG;
  private LinkedList<String> sbH;
  public String sbI;
  String sbJ = "";
  public String sbK;
  public String sbL;
  public boolean sbM = true;
  public boolean sbN = true;
  public boolean sbO = false;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public a(Context paramContext, a.a parama)
  {
    this.context = paramContext;
    this.sbF = parama;
    this.nkA = new LinkedList();
    this.sbH = new LinkedList();
    this.tipDialog = null;
  }
  
  private void a(String paramString1, LinkedList<Integer> paramLinkedList, boolean paramBoolean, String paramString2)
  {
    boolean bool;
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramLinkedList == null) {
        break label181;
      }
      bool = true;
      label26:
      Assert.assertTrue(bool);
      this.sbM = paramBoolean;
      g.DO().dJT.a(30, this);
      g.DO().dJT.a(667, this);
      if (this.sbN)
      {
        Context localContext = this.context;
        this.context.getString(a.h.app_tip);
        this.tipDialog = h.b(localContext, this.context.getString(a.h.contact_info_adding_tip), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            a.a(a.this, false, a.this.sbJ, a.this.fiE);
          }
        });
      }
      this.nkB = paramLinkedList;
      this.nkA.add(paramString1);
      this.sbJ = paramString1;
      if (!ad.aaU(paramString1)) {
        break label201;
      }
      if (!this.sbH.isEmpty()) {
        break label187;
      }
    }
    label181:
    label187:
    for (paramLinkedList = "";; paramLinkedList = (String)this.sbH.getFirst())
    {
      paramString1 = new com.tencent.mm.openim.b.b(paramString1, paramLinkedList);
      g.DO().dJT.a(paramString1, 0);
      return;
      bool = false;
      break;
      bool = false;
      break label26;
    }
    label201:
    paramString1 = new com.tencent.mm.pluginsdk.model.m(1, this.nkA, paramLinkedList, this.sbH, "", this.kzG, null, this.chatroomName, paramString2);
    if (!bk.bl(this.sbK)) {
      paramString1.fP(this.sbK, this.sbL);
    }
    g.DO().dJT.a(paramString1, 0);
  }
  
  private void c(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (this.sbF != null) {
      this.sbF.a(paramBoolean1, paramBoolean2, paramString1, paramString2);
    }
    if (paramBoolean1)
    {
      paramString2 = new js();
      paramString2.bSd.username = paramString1;
      com.tencent.mm.sdk.b.a.udP.m(paramString2);
    }
  }
  
  private void w(int paramInt1, int paramInt2, String paramString)
  {
    if ((this.sbO) && (!bk.bl(paramString))) {
      Toast.makeText(this.context, paramString, 1).show();
    }
    for (;;)
    {
      c(false, false, this.sbJ, this.fiE);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -22)) {
        Toast.makeText(this.context, this.context.getString(a.h.addcontact_fail_blacklist), 1).show();
      } else if ((paramInt1 == 4) && (paramInt2 == -24) && (!bk.bl(paramString))) {
        Toast.makeText(this.context, paramString, 1).show();
      } else {
        Toast.makeText(this.context, this.context.getString(a.h.addcontact_fail), 1).show();
      }
    }
  }
  
  public final void WA(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.sbH.add(paramString);
    }
  }
  
  public final void a(String paramString1, LinkedList<Integer> paramLinkedList, String paramString2)
  {
    a(paramString1, paramLinkedList, false, paramString2);
  }
  
  public final void b(String paramString1, String paramString2, LinkedList<Integer> paramLinkedList)
  {
    this.chatroomName = paramString2;
    a(paramString1, paramLinkedList, false, "");
  }
  
  public final void b(String paramString, LinkedList<Integer> paramLinkedList, boolean paramBoolean)
  {
    a(paramString, paramLinkedList, paramBoolean, "");
  }
  
  public final void e(String paramString, LinkedList<Integer> paramLinkedList)
  {
    a(paramString, paramLinkedList, false, "");
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.d("MicroMsg.AddContact", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
    if ((paramm.getType() != 30) && (paramm.getType() != 667)) {
      y.w("MicroMsg.AddContact", "not expected scene,  type = " + paramm.getType());
    }
    do
    {
      do
      {
        return;
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        g.DO().dJT.b(30, this);
        g.DO().dJT.b(667, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramm.getType() == 30) {
            this.sbJ = ((com.tencent.mm.pluginsdk.model.m)paramm).ckC();
          }
          for (;;)
          {
            c(true, false, this.sbJ, this.fiE);
            return;
            if (paramm.getType() == 667) {
              this.sbJ = ((com.tencent.mm.openim.b.b)paramm).ePQ;
            }
          }
        }
        if (paramInt2 == -44)
        {
          paramm = this.fiE;
          Object localObject;
          if (this.sbG != null)
          {
            localObject = this.sbG;
            if (this.sbH.isEmpty()) {}
            for (paramString = "";; paramString = (String)this.sbH.getFirst())
            {
              ((a.b)localObject).pE(paramString);
              c(false, false, this.sbJ, paramm);
              return;
            }
          }
          paramString = new s(this.context, new a.4(this));
          if (this.sbI != null) {
            paramString.sbI = this.sbI;
          }
          if (this.sbM)
          {
            paramm = this.nkA;
            localObject = this.nkB;
            paramString.sdq = false;
            paramString.onStart();
            paramString.sdp = paramm;
            paramString.nkB = ((LinkedList)localObject);
            if ((paramm.size() == 1) && (ad.aaU((String)paramm.getFirst())))
            {
              paramString.cmS();
              return;
            }
            g.DO().dJT.a(new com.tencent.mm.pluginsdk.model.m(2, paramm, (List)localObject, "", ""), 0);
            return;
          }
          paramString.a(this.nkA, this.nkB, this.sbH);
          return;
        }
        if (paramInt2 == -87)
        {
          h.b(this.context, this.context.getString(a.h.contact_info_biz_join_fans_limit), "", true);
          return;
        }
        if ((paramInt2 == -101) && (!bk.bl(paramString)))
        {
          y.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString });
          h.a(this.context, paramString, "", false, new a.2(this));
          return;
        }
        if (paramInt2 != -302) {
          break;
        }
      } while (paramm.getType() == 667);
      paramInt1 = ((com.tencent.mm.pluginsdk.model.m)paramm).bNb;
      y.d("MicroMsg.AddContact", "onSceneEnd, verify relation out of date, opCode = %d", new Object[] { Integer.valueOf(paramInt1) });
    } while (paramInt1 != 3);
    h.a(this.context, this.context.getString(a.h.contact_info_verify_outofdate_msg), this.context.getString(a.h.app_tip), this.context.getString(a.h.app_add), this.context.getString(a.h.app_cancel), new a.3(this, paramm), null);
    return;
    if (paramInt2 == -2)
    {
      if (!bk.bl(paramString))
      {
        h.a(this.context, paramString, this.context.getString(a.h.app_tip), this.context.getString(a.h.app_ok), null);
        return;
      }
      w(paramInt1, paramInt2, null);
      return;
    }
    w(paramInt1, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.a
 * JD-Core Version:    0.7.0.1
 */