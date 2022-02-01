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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class aa
  implements f
{
  private String AGU;
  private String AGV;
  private LinkedList<String> Fnj;
  String Fnk;
  boolean Fnp;
  a Fpo;
  LinkedList<String> Fpp;
  public Map<String, Integer> Fpq;
  private boolean Fpr;
  private com.tencent.mm.pluginsdk.model.o Fps;
  private boolean Fpt;
  public String chatroomName;
  public String content;
  Context context;
  View jfj;
  d jfl;
  EditText mqR;
  p tipDialog;
  private LinkedList<Integer> xyj;
  TextView xzJ;
  
  public aa(Context paramContext, a parama)
  {
    AppMethodBeat.i(152244);
    this.jfl = null;
    this.content = "";
    this.Fnp = true;
    this.Fpr = true;
    this.Fpt = false;
    this.context = paramContext;
    this.Fpo = parama;
    AppMethodBeat.o(152244);
  }
  
  private void onStart()
  {
    AppMethodBeat.i(152245);
    g.ajQ().gDv.a(30, this);
    g.ajQ().gDv.a(243, this);
    AppMethodBeat.o(152245);
  }
  
  public final void D(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(152249);
    this.Fpr = false;
    onStart();
    this.Fpp = new LinkedList(paramList);
    this.xyj = new LinkedList(paramList1);
    if ((paramList.size() == 1) && (an.aUq((String)this.Fpp.getFirst())))
    {
      fgA();
      AppMethodBeat.o(152249);
      return;
    }
    ffW();
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
      this.Fpp = paramLinkedList1;
      this.xyj = paramLinkedList;
      this.Fnj = paramLinkedList2;
      this.jfj = View.inflate(this.context, 2131495371, null);
      if (this.Fnk != null) {
        break label322;
      }
      bool = true;
      label78:
      if (this.Fnk != null) {
        break label328;
      }
    }
    label316:
    label322:
    label328:
    for (int i = 0;; i = this.Fnk.length())
    {
      ae.i("MicroMsg.SendVerifyRequest", "verifyTip is null: %b, length : %d, value : [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), this.Fnk });
      if (!bu.isNullOrNil(this.Fnk)) {
        ((TextView)this.jfj.findViewById(2131304591)).setText(this.Fnk);
      }
      this.mqR = ((EditText)this.jfj.findViewById(2131304590));
      this.xzJ = ((TextView)this.jfj.findViewById(2131307005));
      this.xzJ.setVisibility(0);
      this.mqR.setText(null);
      this.xzJ.setText("50");
      this.mqR.setFilters(j.FCS);
      this.mqR.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(152237);
          int j = 50 - paramAnonymousEditable.length();
          int i = j;
          if (j < 0) {
            i = 0;
          }
          if (aa.this.xzJ != null) {
            aa.this.xzJ.setText(String.valueOf(i));
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
          if (aa.this.jfl != null)
          {
            aa.this.jfl.dismiss();
            aa.this.jfl = null;
          }
          new aw(new aw.a()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(152238);
              aa localaa;
              if (aa.this.jfj != null)
              {
                localaa = aa.this;
                String str = aa.this.mqR.getText().toString().trim();
                Context localContext = localaa.context;
                localaa.context.getString(2131755906);
                localaa.tipDialog = com.tencent.mm.ui.base.h.b(localContext, localaa.context.getString(2131763077), true, new aa.5(localaa));
                localaa.content = str;
                if ((localaa.Fpp.size() != 1) || (!an.aUq((String)localaa.Fpp.getFirst()))) {
                  break label130;
                }
                localaa.fgA();
              }
              for (;;)
              {
                AppMethodBeat.o(152238);
                return false;
                label130:
                localaa.ffW();
              }
            }
          }, false).ay(500L, 500L);
          AppMethodBeat.o(152239);
        }
      };
      paramLinkedList = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(152240);
          if (aa.this.jfl != null)
          {
            aa.this.jfl.dismiss();
            aa.this.jfl = null;
          }
          aa.this.onStop();
          if (aa.this.Fpo != null) {
            aa.this.Fpo.cF(false);
          }
          AppMethodBeat.o(152240);
        }
      };
      this.jfl = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(2131763081), this.jfj, paramLinkedList1, paramLinkedList);
      if (this.jfl == null) {
        onStop();
      }
      this.mqR.post(new Runnable()
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
  
  final void ffW()
  {
    AppMethodBeat.i(152250);
    this.Fps = new com.tencent.mm.pluginsdk.model.o(this.Fpp, this.xyj, this.content, "", this.Fpq, this.chatroomName);
    this.Fps.vM(this.Fnp);
    this.Fps.ly(this.AGU, this.AGV);
    g.ajQ().gDv.a(this.Fps, 0);
    AppMethodBeat.o(152250);
  }
  
  final void fgA()
  {
    AppMethodBeat.i(152251);
    if ((this.Fnj == null) || (this.Fnj.isEmpty()))
    {
      this.Fpt = true;
      g.ajQ().gDv.a(881, this);
      g.ajQ().gDv.a(new com.tencent.mm.openim.b.h((String)this.Fpp.getFirst(), "", ""), 0);
      AppMethodBeat.o(152251);
      return;
    }
    g.ajQ().gDv.a(new com.tencent.mm.openim.b.o((String)this.Fpp.getFirst(), this.content, (String)this.Fnj.getFirst(), 0), 0);
    AppMethodBeat.o(152251);
  }
  
  public final void fgz()
  {
    AppMethodBeat.i(152247);
    if (this.Fps != null) {
      g.ajj().a(this.Fps);
    }
    AppMethodBeat.o(152247);
  }
  
  public final void ly(String paramString1, String paramString2)
  {
    this.AGU = paramString1;
    this.AGV = paramString2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(152252);
    if (paramn.getType() == 881)
    {
      g.ajQ().gDv.b(881, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.Fpt)
        {
          paramString = ((com.tencent.mm.openim.b.h)paramn).iKv.FNU;
          g.ajQ().gDv.a(new com.tencent.mm.openim.b.o((String)this.Fpp.getFirst(), this.content, paramString, 0), 0);
        }
      }
      for (;;)
      {
        this.Fpt = false;
        AppMethodBeat.o(152252);
        return;
        Toast.makeText(this.context, this.context.getString(2131763075), 1).show();
      }
    }
    if ((paramn.getType() != 30) && (paramn.getType() != 243))
    {
      ae.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + paramn.getType());
      AppMethodBeat.o(152252);
      return;
    }
    if (((paramn instanceof com.tencent.mm.pluginsdk.model.o)) && (((com.tencent.mm.pluginsdk.model.o)paramn).dto != 2))
    {
      ae.e("MicroMsg.SendVerifyRequest", "not opcode sendrequest!");
      AppMethodBeat.o(152252);
      return;
    }
    ae.d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    onStop();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.Fpr) {
        com.tencent.mm.ui.base.h.cm(this.context, this.context.getString(2131763076));
      }
      if (this.Fpo != null)
      {
        this.Fpo.cF(true);
        AppMethodBeat.o(152252);
      }
    }
    else
    {
      if ((paramInt1 != 4) || (paramInt2 != -34)) {
        break label403;
      }
      paramn = this.context.getString(2131759479);
    }
    for (;;)
    {
      if ((this.Fpr) && (!bu.isNullOrNil(paramn))) {
        Toast.makeText(this.context, paramn, 1).show();
      }
      if (this.Fpo != null) {
        this.Fpo.cF(false);
      }
      AppMethodBeat.o(152252);
      return;
      label403:
      if ((paramInt1 == 4) && (paramInt2 == -94))
      {
        paramn = this.context.getString(2131759482);
      }
      else if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramn = paramString;
        if (!bu.isNullOrNil(paramString)) {}
      }
      else
      {
        if (paramInt2 == -160)
        {
          if (!bu.isNullOrNil(paramString))
          {
            com.tencent.mm.ui.base.h.e(this.context, paramString, "", this.context.getResources().getString(2131755700), this.context.getResources().getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(152243);
                aa.this.Fnp = false;
                aa.this.ffW();
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
            if (!bu.isNullOrNil(paramString)) {
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
    g.ajQ().gDv.b(30, this);
    g.ajQ().gDv.b(243, this);
    if (this.jfl != null)
    {
      this.jfl.dismiss();
      this.jfl = null;
    }
    AppMethodBeat.o(152246);
  }
  
  public static abstract interface a
  {
    public abstract void cF(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.aa
 * JD-Core Version:    0.7.0.1
 */