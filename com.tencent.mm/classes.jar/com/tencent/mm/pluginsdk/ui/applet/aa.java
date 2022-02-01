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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
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
  private String ApH;
  private String ApI;
  private LinkedList<String> EUO;
  String EUP;
  boolean EUU;
  a EWU;
  LinkedList<String> EWV;
  public Map<String, Integer> EWW;
  private boolean EWX;
  private com.tencent.mm.pluginsdk.model.o EWY;
  private boolean EWZ;
  public String chatroomName;
  public String content;
  Context context;
  View jcq;
  d jcs;
  EditText mlU;
  p tipDialog;
  private LinkedList<Integer> xin;
  TextView xjM;
  
  public aa(Context paramContext, a parama)
  {
    AppMethodBeat.i(152244);
    this.jcs = null;
    this.content = "";
    this.EUU = true;
    this.EWX = true;
    this.EWZ = false;
    this.context = paramContext;
    this.EWU = parama;
    AppMethodBeat.o(152244);
  }
  
  private void onStart()
  {
    AppMethodBeat.i(152245);
    g.ajB().gAO.a(30, this);
    g.ajB().gAO.a(243, this);
    AppMethodBeat.o(152245);
  }
  
  public final void E(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(152249);
    this.EWX = false;
    onStart();
    this.EWV = new LinkedList(paramList);
    this.xin = new LinkedList(paramList1);
    if ((paramList.size() == 1) && (am.aSQ((String)this.EWV.getFirst())))
    {
      fcM();
      AppMethodBeat.o(152249);
      return;
    }
    fci();
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
      this.EWV = paramLinkedList1;
      this.xin = paramLinkedList;
      this.EUO = paramLinkedList2;
      this.jcq = View.inflate(this.context, 2131495371, null);
      if (this.EUP != null) {
        break label322;
      }
      bool = true;
      label78:
      if (this.EUP != null) {
        break label328;
      }
    }
    label316:
    label322:
    label328:
    for (int i = 0;; i = this.EUP.length())
    {
      ad.i("MicroMsg.SendVerifyRequest", "verifyTip is null: %b, length : %d, value : [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), this.EUP });
      if (!bt.isNullOrNil(this.EUP)) {
        ((TextView)this.jcq.findViewById(2131304591)).setText(this.EUP);
      }
      this.mlU = ((EditText)this.jcq.findViewById(2131304590));
      this.xjM = ((TextView)this.jcq.findViewById(2131307005));
      this.xjM.setVisibility(0);
      this.mlU.setText(null);
      this.xjM.setText("50");
      this.mlU.setFilters(j.Fku);
      this.mlU.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(152237);
          int j = 50 - paramAnonymousEditable.length();
          int i = j;
          if (j < 0) {
            i = 0;
          }
          if (aa.this.xjM != null) {
            aa.this.xjM.setText(String.valueOf(i));
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
          if (aa.this.jcs != null)
          {
            aa.this.jcs.dismiss();
            aa.this.jcs = null;
          }
          new av(new av.a()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(152238);
              aa localaa;
              if (aa.this.jcq != null)
              {
                localaa = aa.this;
                String str = aa.this.mlU.getText().toString().trim();
                Context localContext = localaa.context;
                localaa.context.getString(2131755906);
                localaa.tipDialog = com.tencent.mm.ui.base.h.b(localContext, localaa.context.getString(2131763077), true, new aa.5(localaa));
                localaa.content = str;
                if ((localaa.EWV.size() != 1) || (!am.aSQ((String)localaa.EWV.getFirst()))) {
                  break label130;
                }
                localaa.fcM();
              }
              for (;;)
              {
                AppMethodBeat.o(152238);
                return false;
                label130:
                localaa.fci();
              }
            }
          }, false).az(500L, 500L);
          AppMethodBeat.o(152239);
        }
      };
      paramLinkedList = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(152240);
          if (aa.this.jcs != null)
          {
            aa.this.jcs.dismiss();
            aa.this.jcs = null;
          }
          aa.this.onStop();
          if (aa.this.EWU != null) {
            aa.this.EWU.cF(false);
          }
          AppMethodBeat.o(152240);
        }
      };
      this.jcs = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(2131763081), this.jcq, paramLinkedList1, paramLinkedList);
      if (this.jcs == null) {
        onStop();
      }
      this.mlU.post(new Runnable()
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
  
  public final void fcL()
  {
    AppMethodBeat.i(152247);
    if (this.EWY != null) {
      g.aiU().a(this.EWY);
    }
    AppMethodBeat.o(152247);
  }
  
  final void fcM()
  {
    AppMethodBeat.i(152251);
    if ((this.EUO == null) || (this.EUO.isEmpty()))
    {
      this.EWZ = true;
      g.ajB().gAO.a(881, this);
      g.ajB().gAO.a(new com.tencent.mm.openim.b.h((String)this.EWV.getFirst(), "", ""), 0);
      AppMethodBeat.o(152251);
      return;
    }
    g.ajB().gAO.a(new com.tencent.mm.openim.b.o((String)this.EWV.getFirst(), this.content, (String)this.EUO.getFirst(), 0), 0);
    AppMethodBeat.o(152251);
  }
  
  final void fci()
  {
    AppMethodBeat.i(152250);
    this.EWY = new com.tencent.mm.pluginsdk.model.o(this.EWV, this.xin, this.content, "", this.EWW, this.chatroomName);
    this.EWY.vE(this.EUU);
    this.EWY.lr(this.ApH, this.ApI);
    g.ajB().gAO.a(this.EWY, 0);
    AppMethodBeat.o(152250);
  }
  
  public final void lr(String paramString1, String paramString2)
  {
    this.ApH = paramString1;
    this.ApI = paramString2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(152252);
    if (paramn.getType() == 881)
    {
      g.ajB().gAO.b(881, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (this.EWZ)
        {
          paramString = ((com.tencent.mm.openim.b.h)paramn).iHC.Fvw;
          g.ajB().gAO.a(new com.tencent.mm.openim.b.o((String)this.EWV.getFirst(), this.content, paramString, 0), 0);
        }
      }
      for (;;)
      {
        this.EWZ = false;
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
    if (((paramn instanceof com.tencent.mm.pluginsdk.model.o)) && (((com.tencent.mm.pluginsdk.model.o)paramn).dsi != 2))
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
      if (this.EWX) {
        com.tencent.mm.ui.base.h.cl(this.context, this.context.getString(2131763076));
      }
      if (this.EWU != null)
      {
        this.EWU.cF(true);
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
      if ((this.EWX) && (!bt.isNullOrNil(paramn))) {
        Toast.makeText(this.context, paramn, 1).show();
      }
      if (this.EWU != null) {
        this.EWU.cF(false);
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
        if (!bt.isNullOrNil(paramString)) {}
      }
      else
      {
        if (paramInt2 == -160)
        {
          if (!bt.isNullOrNil(paramString))
          {
            com.tencent.mm.ui.base.h.e(this.context, paramString, "", this.context.getResources().getString(2131755700), this.context.getResources().getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(152243);
                aa.this.EUU = false;
                aa.this.fci();
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
    g.ajB().gAO.b(30, this);
    g.ajB().gAO.b(243, this);
    if (this.jcs != null)
    {
      this.jcs.dismiss();
      this.jcs = null;
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