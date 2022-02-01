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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.o;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class aa
  implements i
{
  private LinkedList<Integer> Bym;
  TextView BzK;
  private String CAZ;
  private String EQM;
  private LinkedList<String> Keb;
  boolean Kef;
  a Kgf;
  LinkedList<String> Kgg;
  public Map<String, Integer> Kgh;
  private boolean Kgi;
  private p Kgj;
  private boolean Kgk;
  public String chatroomName;
  public String content;
  Context context;
  View kdm;
  d kdo;
  EditText nBD;
  com.tencent.mm.ui.base.q tipDialog;
  String wHV;
  
  public aa(Context paramContext, a parama)
  {
    AppMethodBeat.i(152244);
    this.kdo = null;
    this.content = "";
    this.Kef = true;
    this.Kgi = true;
    this.Kgk = false;
    this.context = paramContext;
    this.Kgf = parama;
    AppMethodBeat.o(152244);
  }
  
  private void onStart()
  {
    AppMethodBeat.i(152245);
    g.aAg().hqi.a(30, this);
    g.aAg().hqi.a(243, this);
    AppMethodBeat.o(152245);
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
      this.Kgg = paramLinkedList1;
      this.Bym = paramLinkedList;
      this.Keb = paramLinkedList2;
      this.kdm = View.inflate(this.context, 2131496232, null);
      if (this.wHV != null) {
        break label322;
      }
      bool = true;
      label78:
      if (this.wHV != null) {
        break label328;
      }
    }
    label316:
    label322:
    label328:
    for (int i = 0;; i = this.wHV.length())
    {
      Log.i("MicroMsg.SendVerifyRequest", "verifyTip is null: %b, length : %d, value : [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), this.wHV });
      if (!Util.isNullOrNil(this.wHV)) {
        ((TextView)this.kdm.findViewById(2131307637)).setText(this.wHV);
      }
      this.nBD = ((EditText)this.kdm.findViewById(2131307636));
      this.BzK = ((TextView)this.kdm.findViewById(2131310528));
      this.BzK.setVisibility(0);
      this.nBD.setText(null);
      this.BzK.setText("50");
      this.nBD.setFilters(l.KvQ);
      this.nBD.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(152237);
          int j = 50 - paramAnonymousEditable.length();
          int i = j;
          if (j < 0) {
            i = 0;
          }
          if (aa.this.BzK != null) {
            aa.this.BzK.setText(String.valueOf(i));
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
          if (aa.this.kdo != null)
          {
            aa.this.kdo.dismiss();
            aa.this.kdo = null;
          }
          new MTimerHandler(new MTimerHandler.CallBack()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(152238);
              aa localaa;
              if (aa.this.kdm != null)
              {
                localaa = aa.this;
                String str = aa.this.nBD.getText().toString().trim();
                Context localContext = localaa.context;
                localaa.context.getString(2131755998);
                localaa.tipDialog = com.tencent.mm.ui.base.h.a(localContext, localaa.context.getString(2131765237), true, new aa.5(localaa));
                localaa.content = str;
                if ((localaa.Kgg.size() != 1) || (!as.bjp((String)localaa.Kgg.getFirst()))) {
                  break label130;
                }
                localaa.gpJ();
              }
              for (;;)
              {
                AppMethodBeat.o(152238);
                return false;
                label130:
                localaa.gpf();
              }
            }
          }, false).startTimer(500L);
          AppMethodBeat.o(152239);
        }
      };
      paramLinkedList = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(152240);
          if (aa.this.kdo != null)
          {
            aa.this.kdo.dismiss();
            aa.this.kdo = null;
          }
          aa.this.onStop();
          if (aa.this.Kgf != null) {
            aa.this.Kgf.jdMethod_do(false);
          }
          AppMethodBeat.o(152240);
        }
      };
      this.kdo = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(2131765241), this.kdm, paramLinkedList1, paramLinkedList);
      if (this.kdo == null) {
        onStop();
      }
      this.nBD.post(new Runnable()
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
  
  public final void gpI()
  {
    AppMethodBeat.i(152247);
    if (this.Kgj != null) {
      g.azz().a(this.Kgj);
    }
    AppMethodBeat.o(152247);
  }
  
  final void gpJ()
  {
    AppMethodBeat.i(152251);
    if ((this.Keb == null) || (this.Keb.isEmpty()))
    {
      this.Kgk = true;
      g.aAg().hqi.a(881, this);
      g.aAg().hqi.a(new com.tencent.mm.openim.b.h((String)this.Kgg.getFirst(), "", ""), 0);
      AppMethodBeat.o(152251);
      return;
    }
    g.aAg().hqi.a(new o((String)this.Kgg.getFirst(), this.content, (String)this.Keb.getFirst(), 0), 0);
    AppMethodBeat.o(152251);
  }
  
  final void gpf()
  {
    AppMethodBeat.i(152250);
    this.Kgj = new p(this.Kgg, this.Bym, this.content, "", this.Kgh, this.chatroomName);
    this.Kgj.zJ(this.Kef);
    this.Kgj.mw(this.CAZ, this.EQM);
    g.aAg().hqi.a(this.Kgj, 0);
    AppMethodBeat.o(152250);
  }
  
  public final void mw(String paramString1, String paramString2)
  {
    this.CAZ = paramString1;
    this.EQM = paramString2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(152252);
    if (paramq.getType() == 881)
    {
      g.aAg().hqi.b(881, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.Kgk)
        {
          paramString = ((com.tencent.mm.openim.b.h)paramq).jHb.KHz;
          g.aAg().hqi.a(new o((String)this.Kgg.getFirst(), this.content, paramString, 0), 0);
        }
      }
      for (;;)
      {
        this.Kgk = false;
        AppMethodBeat.o(152252);
        return;
        Toast.makeText(this.context, this.context.getString(2131765235), 1).show();
      }
    }
    if ((paramq.getType() != 30) && (paramq.getType() != 243))
    {
      Log.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + paramq.getType());
      AppMethodBeat.o(152252);
      return;
    }
    if (((paramq instanceof p)) && (((p)paramq).dKy != 2))
    {
      Log.e("MicroMsg.SendVerifyRequest", "not opcode sendrequest!");
      AppMethodBeat.o(152252);
      return;
    }
    Log.d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    onStop();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.Kgi) {
        com.tencent.mm.ui.base.h.cD(this.context, this.context.getString(2131765236));
      }
      if (this.Kgf != null)
      {
        this.Kgf.jdMethod_do(true);
        AppMethodBeat.o(152252);
      }
    }
    else
    {
      if ((paramInt1 != 4) || (paramInt2 != -34)) {
        break label403;
      }
      paramq = this.context.getString(2131760794);
    }
    for (;;)
    {
      if ((this.Kgi) && (!Util.isNullOrNil(paramq))) {
        Toast.makeText(this.context, paramq, 1).show();
      }
      if (this.Kgf != null) {
        this.Kgf.jdMethod_do(false);
      }
      AppMethodBeat.o(152252);
      return;
      label403:
      if ((paramInt1 == 4) && (paramInt2 == -94))
      {
        paramq = this.context.getString(2131760797);
      }
      else if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramq = paramString;
        if (!Util.isNullOrNil(paramString)) {}
      }
      else
      {
        if (paramInt2 == -160)
        {
          if (!Util.isNullOrNil(paramString))
          {
            com.tencent.mm.ui.base.h.c(this.context, paramString, "", this.context.getResources().getString(2131755771), this.context.getResources().getString(2131755761), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(152243);
                aa.this.Kef = false;
                aa.this.gpf();
                AppMethodBeat.o(152243);
              }
            }, null);
            paramq = null;
          }
        }
        else
        {
          if (paramInt1 == 4)
          {
            paramq = paramString;
            if (!Util.isNullOrNil(paramString)) {
              continue;
            }
          }
          paramq = this.context.getString(2131765235);
          continue;
        }
        paramq = null;
      }
    }
  }
  
  final void onStop()
  {
    AppMethodBeat.i(152246);
    g.aAg().hqi.b(30, this);
    g.aAg().hqi.b(243, this);
    if (this.kdo != null)
    {
      this.kdo.dismiss();
      this.kdo = null;
    }
    AppMethodBeat.o(152246);
  }
  
  public final void z(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(152249);
    this.Kgi = false;
    onStart();
    this.Kgg = new LinkedList(paramList);
    this.Bym = new LinkedList(paramList1);
    if ((paramList.size() == 1) && (as.bjp((String)this.Kgg.getFirst())))
    {
      gpJ();
      AppMethodBeat.o(152249);
      return;
    }
    gpf();
    AppMethodBeat.o(152249);
  }
  
  public static abstract interface a
  {
    public abstract void jdMethod_do(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.aa
 * JD-Core Version:    0.7.0.1
 */