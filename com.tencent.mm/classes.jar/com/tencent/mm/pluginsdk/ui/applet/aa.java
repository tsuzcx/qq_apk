package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.protocal.protobuf.cae;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class aa
  implements com.tencent.mm.ak.g
{
  private LinkedList<String> DpK;
  String DpL;
  boolean DpQ;
  a DrQ;
  LinkedList<String> DrR;
  public Map<String, Integer> DrS;
  private boolean DrT;
  private com.tencent.mm.pluginsdk.model.o DrU;
  private boolean DrV;
  public String chatroomName;
  public String content;
  Context context;
  View iJh;
  d iJj;
  EditText lMg;
  p tipDialog;
  private LinkedList<Integer> waD;
  TextView wcd;
  private String yXW;
  private String yXX;
  
  public aa(Context paramContext, a parama)
  {
    AppMethodBeat.i(152244);
    this.iJj = null;
    this.content = "";
    this.DpQ = true;
    this.DrT = true;
    this.DrV = false;
    this.context = paramContext;
    this.DrQ = parama;
    AppMethodBeat.o(152244);
  }
  
  private void onStart()
  {
    AppMethodBeat.i(152245);
    com.tencent.mm.kernel.g.agQ().ghe.a(30, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(243, this);
    AppMethodBeat.o(152245);
  }
  
  public final void C(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(152249);
    this.DrT = false;
    onStart();
    this.DrR = new LinkedList(paramList);
    this.waD = new LinkedList(paramList1);
    if ((paramList.size() == 1) && (ai.aNc((String)this.DrR.getFirst())))
    {
      eNN();
      AppMethodBeat.o(152249);
      return;
    }
    eNj();
    AppMethodBeat.o(152249);
  }
  
  public final void a(LinkedList<String> paramLinkedList1, LinkedList<Integer> paramLinkedList, LinkedList<String> paramLinkedList2)
  {
    AppMethodBeat.i(152248);
    boolean bool;
    if (paramLinkedList1.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramLinkedList.size() <= 0) {
        break label316;
      }
      bool = true;
      label30:
      Assert.assertTrue(bool);
      onStart();
      this.DrR = paramLinkedList1;
      this.waD = paramLinkedList;
      this.DpK = paramLinkedList2;
      this.iJh = View.inflate(this.context, 2131495371, null);
      if (this.DpL != null) {
        break label322;
      }
      bool = true;
      label78:
      if (this.DpL != null) {
        break label328;
      }
    }
    label316:
    label322:
    label328:
    for (int i = 0;; i = this.DpL.length())
    {
      ac.i("MicroMsg.SendVerifyRequest", "verifyTip is null: %b, length : %d, value : [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), this.DpL });
      if (!bs.isNullOrNil(this.DpL)) {
        ((TextView)this.iJh.findViewById(2131304591)).setText(this.DpL);
      }
      this.lMg = ((EditText)this.iJh.findViewById(2131304590));
      this.wcd = ((TextView)this.iJh.findViewById(2131307005));
      this.wcd.setVisibility(0);
      this.lMg.setText(null);
      this.wcd.setText("50");
      this.lMg.setFilters(j.DFp);
      this.lMg.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(152237);
          int j = 50 - paramAnonymousEditable.length();
          int i = j;
          if (j < 0) {
            i = 0;
          }
          if (aa.this.wcd != null) {
            aa.this.wcd.setText(String.valueOf(i));
          }
          AppMethodBeat.o(152237);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      paramLinkedList1 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(152239);
          if (aa.this.iJj != null)
          {
            aa.this.iJj.dismiss();
            aa.this.iJj = null;
          }
          new au(new au.a()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(152238);
              aa localaa;
              if (aa.this.iJh != null)
              {
                localaa = aa.this;
                String str = aa.this.lMg.getText().toString().trim();
                Context localContext = localaa.context;
                localaa.context.getString(2131755906);
                localaa.tipDialog = com.tencent.mm.ui.base.h.b(localContext, localaa.context.getString(2131763077), true, new aa.5(localaa));
                localaa.content = str;
                if ((localaa.DrR.size() != 1) || (!ai.aNc((String)localaa.DrR.getFirst()))) {
                  break label130;
                }
                localaa.eNN();
              }
              for (;;)
              {
                AppMethodBeat.o(152238);
                return false;
                label130:
                localaa.eNj();
              }
            }
          }, false).au(500L, 500L);
          AppMethodBeat.o(152239);
        }
      };
      paramLinkedList = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(152240);
          if (aa.this.iJj != null)
          {
            aa.this.iJj.dismiss();
            aa.this.iJj = null;
          }
          aa.this.onStop();
          if (aa.this.DrQ != null) {
            aa.this.DrQ.cD(false);
          }
          AppMethodBeat.o(152240);
        }
      };
      this.iJj = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(2131763081), this.iJh, paramLinkedList1, paramLinkedList);
      if (this.iJj == null) {
        onStop();
      }
      this.lMg.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(152241);
          if ((aa.this.context instanceof MMActivity)) {
            ((MMActivity)aa.this.context).showVKB();
          }
          AppMethodBeat.o(152241);
        }
      });
      AppMethodBeat.o(152248);
      return;
      bool = false;
      break;
      bool = false;
      break label30;
      bool = false;
      break label78;
    }
  }
  
  public final void eNM()
  {
    AppMethodBeat.i(152247);
    if (this.DrU != null) {
      com.tencent.mm.kernel.g.agi().a(this.DrU);
    }
    AppMethodBeat.o(152247);
  }
  
  final void eNN()
  {
    AppMethodBeat.i(152251);
    if ((this.DpK == null) || (this.DpK.isEmpty()))
    {
      this.DrV = true;
      com.tencent.mm.kernel.g.agQ().ghe.a(881, this);
      com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.openim.b.h((String)this.DrR.getFirst(), "", ""), 0);
      AppMethodBeat.o(152251);
      return;
    }
    com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.openim.b.o((String)this.DrR.getFirst(), this.content, (String)this.DpK.getFirst()), 0);
    AppMethodBeat.o(152251);
  }
  
  final void eNj()
  {
    AppMethodBeat.i(152250);
    this.DrU = new com.tencent.mm.pluginsdk.model.o(this.DrR, this.waD, this.content, "", this.DrS, this.chatroomName);
    this.DrU.uT(this.DpQ);
    this.DrU.kU(this.yXW, this.yXX);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.DrU, 0);
    AppMethodBeat.o(152250);
  }
  
  public final void kU(String paramString1, String paramString2)
  {
    this.yXW = paramString1;
    this.yXX = paramString2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(152252);
    if (paramn.getType() == 881)
    {
      com.tencent.mm.kernel.g.agQ().ghe.b(881, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.DrV)
        {
          paramString = ((com.tencent.mm.openim.b.h)paramn).iof.DQi;
          com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.openim.b.o((String)this.DrR.getFirst(), this.content, paramString), 0);
        }
      }
      for (;;)
      {
        this.DrV = false;
        AppMethodBeat.o(152252);
        return;
        Toast.makeText(this.context, this.context.getString(2131763075), 1).show();
      }
    }
    if ((paramn.getType() != 30) && (paramn.getType() != 243))
    {
      ac.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + paramn.getType());
      AppMethodBeat.o(152252);
      return;
    }
    if (((paramn instanceof com.tencent.mm.pluginsdk.model.o)) && (((com.tencent.mm.pluginsdk.model.o)paramn).dgL != 2))
    {
      ac.e("MicroMsg.SendVerifyRequest", "not opcode sendrequest!");
      AppMethodBeat.o(152252);
      return;
    }
    ac.d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    onStop();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.DrT) {
        com.tencent.mm.ui.base.h.cg(this.context, this.context.getString(2131763076));
      }
      if (this.DrQ != null)
      {
        this.DrQ.cD(true);
        AppMethodBeat.o(152252);
      }
    }
    else
    {
      if ((paramInt1 != 4) || (paramInt2 != -34)) {
        break label402;
      }
      paramn = this.context.getString(2131759479);
    }
    for (;;)
    {
      if ((this.DrT) && (!bs.isNullOrNil(paramn))) {
        Toast.makeText(this.context, paramn, 1).show();
      }
      if (this.DrQ != null) {
        this.DrQ.cD(false);
      }
      AppMethodBeat.o(152252);
      return;
      label402:
      if ((paramInt1 == 4) && (paramInt2 == -94))
      {
        paramn = this.context.getString(2131759482);
      }
      else if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramn = paramString;
        if (!bs.isNullOrNil(paramString)) {}
      }
      else
      {
        if (paramInt2 == -160)
        {
          if (!bs.isNullOrNil(paramString))
          {
            com.tencent.mm.ui.base.h.d(this.context, paramString, "", this.context.getResources().getString(2131755700), this.context.getResources().getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(152243);
                aa.this.DpQ = false;
                aa.this.eNj();
                AppMethodBeat.o(152243);
              }
            }, null);
            paramn = null;
          }
        }
        else
        {
          if (paramInt1 == 4)
          {
            paramn = paramString;
            if (!bs.isNullOrNil(paramString)) {
              continue;
            }
          }
          paramn = this.context.getString(2131763075);
          continue;
        }
        paramn = null;
      }
    }
  }
  
  final void onStop()
  {
    AppMethodBeat.i(152246);
    com.tencent.mm.kernel.g.agQ().ghe.b(30, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(243, this);
    if (this.iJj != null)
    {
      this.iJj.dismiss();
      this.iJj = null;
    }
    AppMethodBeat.o(152246);
  }
  
  public static abstract interface a
  {
    public abstract void cD(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.aa
 * JD-Core Version:    0.7.0.1
 */