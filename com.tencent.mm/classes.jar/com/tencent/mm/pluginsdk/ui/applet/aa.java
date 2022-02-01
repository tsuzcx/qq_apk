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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class aa
  implements com.tencent.mm.al.g
{
  private LinkedList<String> BXt;
  String BXu;
  boolean BXz;
  a BZA;
  LinkedList<String> BZB;
  public Map<String, Integer> BZC;
  private boolean BZD;
  private com.tencent.mm.pluginsdk.model.o BZE;
  private boolean BZF;
  public String chatroomName;
  public String content;
  Context context;
  View ija;
  d ijc;
  EditText lmq;
  p tipDialog;
  private LinkedList<Integer> uRO;
  TextView uTo;
  private String xLh;
  private String xLi;
  
  public aa(Context paramContext, a parama)
  {
    AppMethodBeat.i(152244);
    this.ijc = null;
    this.content = "";
    this.BXz = true;
    this.BZD = true;
    this.BZF = false;
    this.context = paramContext;
    this.BZA = parama;
    AppMethodBeat.o(152244);
  }
  
  private void onStart()
  {
    AppMethodBeat.i(152245);
    com.tencent.mm.kernel.g.afA().gcy.a(30, this);
    com.tencent.mm.kernel.g.afA().gcy.a(243, this);
    AppMethodBeat.o(152245);
  }
  
  public final void D(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(152249);
    this.BZD = false;
    onStart();
    this.BZB = new LinkedList(paramList);
    this.uRO = new LinkedList(paramList1);
    if ((paramList.size() == 1) && (af.aHH((String)this.BZB.getFirst())))
    {
      eyt();
      AppMethodBeat.o(152249);
      return;
    }
    exP();
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
      this.BZB = paramLinkedList1;
      this.uRO = paramLinkedList;
      this.BXt = paramLinkedList2;
      this.ija = View.inflate(this.context, 2131495371, null);
      if (this.BXu != null) {
        break label322;
      }
      bool = true;
      label78:
      if (this.BXu != null) {
        break label328;
      }
    }
    label316:
    label322:
    label328:
    for (int i = 0;; i = this.BXu.length())
    {
      ad.i("MicroMsg.SendVerifyRequest", "verifyTip is null: %b, length : %d, value : [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), this.BXu });
      if (!bt.isNullOrNil(this.BXu)) {
        ((TextView)this.ija.findViewById(2131304591)).setText(this.BXu);
      }
      this.lmq = ((EditText)this.ija.findViewById(2131304590));
      this.uTo = ((TextView)this.ija.findViewById(2131307005));
      this.uTo.setVisibility(0);
      this.lmq.setText(null);
      this.uTo.setText("50");
      this.lmq.setFilters(j.CmX);
      this.lmq.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(152237);
          int j = 50 - paramAnonymousEditable.length();
          int i = j;
          if (j < 0) {
            i = 0;
          }
          if (aa.this.uTo != null) {
            aa.this.uTo.setText(String.valueOf(i));
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
          if (aa.this.ijc != null)
          {
            aa.this.ijc.dismiss();
            aa.this.ijc = null;
          }
          new av(new av.a()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(152238);
              aa localaa;
              if (aa.this.ija != null)
              {
                localaa = aa.this;
                String str = aa.this.lmq.getText().toString().trim();
                Context localContext = localaa.context;
                localaa.context.getString(2131755906);
                localaa.tipDialog = com.tencent.mm.ui.base.h.b(localContext, localaa.context.getString(2131763077), true, new aa.5(localaa));
                localaa.content = str;
                if ((localaa.BZB.size() != 1) || (!af.aHH((String)localaa.BZB.getFirst()))) {
                  break label130;
                }
                localaa.eyt();
              }
              for (;;)
              {
                AppMethodBeat.o(152238);
                return false;
                label130:
                localaa.exP();
              }
            }
          }, false).av(500L, 500L);
          AppMethodBeat.o(152239);
        }
      };
      paramLinkedList = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(152240);
          if (aa.this.ijc != null)
          {
            aa.this.ijc.dismiss();
            aa.this.ijc = null;
          }
          aa.this.onStop();
          if (aa.this.BZA != null) {
            aa.this.BZA.cE(false);
          }
          AppMethodBeat.o(152240);
        }
      };
      this.ijc = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(2131763081), this.ija, paramLinkedList1, paramLinkedList);
      if (this.ijc == null) {
        onStop();
      }
      this.lmq.post(new Runnable()
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
  
  final void exP()
  {
    AppMethodBeat.i(152250);
    this.BZE = new com.tencent.mm.pluginsdk.model.o(this.BZB, this.uRO, this.content, "", this.BZC, this.chatroomName);
    this.BZE.tS(this.BXz);
    this.BZE.kx(this.xLh, this.xLi);
    com.tencent.mm.kernel.g.afA().gcy.a(this.BZE, 0);
    AppMethodBeat.o(152250);
  }
  
  public final void eys()
  {
    AppMethodBeat.i(152247);
    if (this.BZE != null) {
      com.tencent.mm.kernel.g.aeS().a(this.BZE);
    }
    AppMethodBeat.o(152247);
  }
  
  final void eyt()
  {
    AppMethodBeat.i(152251);
    if ((this.BXt == null) || (this.BXt.isEmpty()))
    {
      this.BZF = true;
      com.tencent.mm.kernel.g.afA().gcy.a(881, this);
      com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.openim.b.h((String)this.BZB.getFirst(), "", ""), 0);
      AppMethodBeat.o(152251);
      return;
    }
    com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.openim.b.o((String)this.BZB.getFirst(), this.content, (String)this.BXt.getFirst()), 0);
    AppMethodBeat.o(152251);
  }
  
  public final void kx(String paramString1, String paramString2)
  {
    this.xLh = paramString1;
    this.xLi = paramString2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(152252);
    if (paramn.getType() == 881)
    {
      com.tencent.mm.kernel.g.afA().gcy.b(881, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.BZF)
        {
          paramString = ((com.tencent.mm.openim.b.h)paramn).hNJ.CxM;
          com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.openim.b.o((String)this.BZB.getFirst(), this.content, paramString), 0);
        }
      }
      for (;;)
      {
        this.BZF = false;
        AppMethodBeat.o(152252);
        return;
        Toast.makeText(this.context, this.context.getString(2131763075), 1).show();
      }
    }
    if ((paramn.getType() != 30) && (paramn.getType() != 243))
    {
      ad.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + paramn.getType());
      AppMethodBeat.o(152252);
      return;
    }
    if (((paramn instanceof com.tencent.mm.pluginsdk.model.o)) && (((com.tencent.mm.pluginsdk.model.o)paramn).djq != 2))
    {
      ad.e("MicroMsg.SendVerifyRequest", "not opcode sendrequest!");
      AppMethodBeat.o(152252);
      return;
    }
    ad.d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    onStop();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.BZD) {
        com.tencent.mm.ui.base.h.cf(this.context, this.context.getString(2131763076));
      }
      if (this.BZA != null)
      {
        this.BZA.cE(true);
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
      if ((this.BZD) && (!bt.isNullOrNil(paramn))) {
        Toast.makeText(this.context, paramn, 1).show();
      }
      if (this.BZA != null) {
        this.BZA.cE(false);
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
        if (!bt.isNullOrNil(paramString)) {}
      }
      else
      {
        if (paramInt2 == -160)
        {
          if (!bt.isNullOrNil(paramString))
          {
            com.tencent.mm.ui.base.h.d(this.context, paramString, "", this.context.getResources().getString(2131755700), this.context.getResources().getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(152243);
                aa.this.BXz = false;
                aa.this.exP();
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
            if (!bt.isNullOrNil(paramString)) {
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
    com.tencent.mm.kernel.g.afA().gcy.b(30, this);
    com.tencent.mm.kernel.g.afA().gcy.b(243, this);
    if (this.ijc != null)
    {
      this.ijc.dismiss();
      this.ijc = null;
    }
    AppMethodBeat.o(152246);
  }
  
  public static abstract interface a
  {
    public abstract void cE(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.aa
 * JD-Core Version:    0.7.0.1
 */