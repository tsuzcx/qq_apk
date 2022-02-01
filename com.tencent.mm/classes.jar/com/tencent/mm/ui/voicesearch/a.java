package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.g;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.cb;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a
  extends com.tencent.mm.ui.r<au>
{
  private ColorStateList[] JPq;
  private HashMap<String, a> JPs;
  private boolean KOK;
  private b LlU;
  protected List<String> fUR;
  private String jff;
  private com.tencent.mm.ui.applet.b jgu;
  private b.b jgv;
  
  public a(Context paramContext, r.a parama)
  {
    super(paramContext, new au());
    AppMethodBeat.i(39514);
    this.fUR = null;
    this.JPq = new ColorStateList[2];
    this.KOK = true;
    this.jgv = null;
    this.jgu = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap Kc(String paramAnonymousString)
      {
        AppMethodBeat.i(39511);
        paramAnonymousString = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(39511);
        return paramAnonymousString;
      }
    });
    super.a(parama);
    this.JPq[0] = com.tencent.mm.cb.a.m(paramContext, 2131100642);
    this.JPq[1] = com.tencent.mm.cb.a.m(paramContext, 2131100643);
    this.JPs = new HashMap();
    AppMethodBeat.o(39514);
  }
  
  private static int Xr(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(39519);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(39519);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public final void JN(String paramString)
  {
    AppMethodBeat.i(39521);
    this.jff = paramString;
    dhl();
    ZD();
    AppMethodBeat.o(39521);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(39517);
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = bc.aCg().hHd.a(x.hHV, this.fUR, this.jff);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((this.fUR != null) && (this.fUR.size() > 0)) {
      localArrayList1.addAll(this.fUR);
    }
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!x.wb(str)) {
          localArrayList2.add(str);
        }
        ae.d("MicroMsg.SearchConversationAdapter", "block user ".concat(String.valueOf(str)));
      }
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SearchConversationAdapter", localException, "", new Object[0]);
      arrayOfCursor[1] = bc.aCg().hHe.a(this.jff, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      setCursor(new MergeCursor(arrayOfCursor));
      if ((this.LlU != null) && (this.jff != null)) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(39517);
    }
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(39516);
    ZD();
    AppMethodBeat.o(39516);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(39520);
    if ((paramString != null) && (!paramString.equals("")) && (this.JPs != null)) {
      this.JPs.remove(paramString);
    }
    for (;;)
    {
      super.a(paramString, paramm);
      AppMethodBeat.o(39520);
      return;
      if (this.JPs != null) {
        this.JPs.clear();
      }
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39518);
    if (this.jgv == null) {
      this.jgv = new b.b()
      {
        public final int aTk()
        {
          AppMethodBeat.i(39513);
          int i = a.this.getCount();
          AppMethodBeat.o(39513);
          return i;
        }
        
        public final String rq(int paramAnonymousInt)
        {
          AppMethodBeat.i(39512);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= a.this.getCount()))
          {
            ae.e("MicroMsg.SearchConversationAdapter", "pos is invalid");
            AppMethodBeat.o(39512);
            return null;
          }
          Object localObject = (au)a.this.getItem(paramAnonymousInt);
          if (localObject == null)
          {
            AppMethodBeat.o(39512);
            return null;
          }
          localObject = ((ba)localObject).field_username;
          AppMethodBeat.o(39512);
          return localObject;
        }
      };
    }
    if (this.jgu != null) {
      this.jgu.a(paramInt, this.jgv);
    }
    au localau = (au)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if ((Xr(localau.field_msgType) == 34) && (localau.field_isSend == 0) && (!bu.isNullOrNil(localau.field_content)))
    {
      localObject1 = localau.field_content;
      if (!localau.field_username.equals("qmessage"))
      {
        paramViewGroup = (ViewGroup)localObject1;
        if (!localau.field_username.equals("floatbottle")) {}
      }
      else
      {
        localObject2 = ((String)localObject1).split(":");
        paramViewGroup = (ViewGroup)localObject1;
        if (localObject2 != null)
        {
          paramViewGroup = (ViewGroup)localObject1;
          if (localObject2.length > 3) {
            paramViewGroup = localObject2[1] + ":" + localObject2[2] + ":" + localObject2[3];
          }
        }
      }
      if (new p(paramViewGroup).iwT) {}
    }
    for (int i = 1;; i = 0)
    {
      label467:
      int j;
      int k;
      if (paramView == null)
      {
        paramViewGroup = new c();
        localObject1 = View.inflate(this.context, 2131495322, null);
        paramViewGroup.fQl = ((ImageView)((View)localObject1).findViewById(2131297008));
        paramViewGroup.fQm = ((TextView)((View)localObject1).findViewById(2131302867));
        paramViewGroup.oah = ((TextView)((View)localObject1).findViewById(2131306207));
        paramViewGroup.oai = ((TextView)((View)localObject1).findViewById(2131301311));
        paramViewGroup.oaj = ((TextView)((View)localObject1).findViewById(2131305882));
        paramViewGroup.oaj.setBackgroundResource(u.kL(this.context));
        paramViewGroup.JPC = ((ImageView)((View)localObject1).findViewById(2131300954));
        paramViewGroup.JPD = ((ImageView)((View)localObject1).findViewById(2131305672));
        ((View)localObject1).setTag(paramViewGroup);
        localObject2 = (a)this.JPs.get(localau.field_username + localau.field_content);
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          localObject2 = new a((byte)0);
          ((a)localObject2).nickName = k.b(this.context, w.zP(localau.field_username), paramViewGroup.fQm.getTextSize());
          if (localau.field_status != 1) {
            break label1091;
          }
          paramView = this.context.getString(2131761075);
          ((a)localObject2).KPc = paramView;
          j = (int)paramViewGroup.oai.getTextSize();
          k = v.aAG();
          paramView = localau.field_username;
          bc.aCg();
          if (bu.o((Integer)com.tencent.mm.model.c.ajA().get(17, null)) != 1) {
            break label1126;
          }
          paramInt = 1;
          label519:
          if ((!paramView.equals("qqmail")) || (paramInt != 0)) {
            break label1131;
          }
          paramView = this.context.getString(2131763356);
          label544:
          ((a)localObject2).KPd = paramView;
          if ((x.wb(localau.field_username)) && (com.tencent.mm.model.r.zC(localau.field_username) == 0)) {
            ((a)localObject2).nickName = this.context.getString(2131757293);
          }
        }
        switch (localau.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label634:
          ((a)localObject2).KPe = paramInt;
          this.JPs.put(localau.field_username + localau.field_content, localObject2);
          paramView = (View)localObject2;
          paramViewGroup.oai.setTextColor(this.JPq[i]);
          paramViewGroup.fQm.setText(paramView.nickName);
          paramViewGroup.oah.setText(paramView.KPc);
          paramViewGroup.oai.setText(k.b(this.context, paramView.KPd.toString(), paramViewGroup.oai.getTextSize()));
          if (localau.field_conversationTime == 0L)
          {
            paramViewGroup.oah.setVisibility(8);
            label764:
            paramViewGroup.JPC.setVisibility(8);
            if (x.wb(localau.field_username))
            {
              bc.aCg();
              paramView = com.tencent.mm.model.c.azF().BH(localau.field_username);
              if ((paramView != null) && (paramView.eRd == 0)) {
                paramViewGroup.JPC.setVisibility(0);
              }
            }
            com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.fQl, localau.field_username);
            if (this.KOK)
            {
              if (localau.field_unReadCount <= 100) {
                break label1317;
              }
              paramViewGroup.oaj.setText("...");
              paramViewGroup.oaj.setVisibility(0);
            }
            label868:
            if (bc.ajM())
            {
              if (!x.a(localau))
              {
                bc.aCg();
                if (com.tencent.mm.model.c.azL().h(localau))
                {
                  bc.aCg();
                  com.tencent.mm.model.c.azL().g(localau);
                }
              }
              bc.aCg();
              if (com.tencent.mm.model.c.azL().h(localau)) {
                break label1391;
              }
              ((View)localObject1).findViewById(2131298792).setBackgroundResource(2131231818);
            }
            label945:
            paramView = new wq();
            paramView.dMc.dMe = true;
            com.tencent.mm.sdk.b.a.IvT.l(paramView);
            if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localau, 7, 0L)) && (!localau.field_username.equals(paramView.dMd.dMg)))
            {
              localau.qI(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localau, 6, localau.field_conversationTime));
              bc.aCg();
              com.tencent.mm.model.c.azL().a(localau, localau.field_username);
            }
            if ((g.ium != null) && (g.ium.Hj(localau.field_username))) {
              break label1408;
            }
            paramViewGroup.JPD.setVisibility(8);
          }
          break;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(39518);
        return localObject1;
        paramViewGroup = (c)paramView.getTag();
        localObject1 = paramView;
        break;
        label1091:
        if (localau.field_conversationTime == 9223372036854775807L)
        {
          paramView = "";
          break label467;
        }
        paramView = i.c(this.context, localau.field_conversationTime, true);
        break label467;
        label1126:
        paramInt = 0;
        break label519;
        label1131:
        bc.aCg();
        cb localcb = com.tencent.mm.model.c.azO().arD("@t.qq.com");
        if ((localcb != null) && (localcb.isEnable())) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!paramView.equals("tmessage")) || (paramInt != 0)) {
            break label1196;
          }
          paramView = this.context.getString(2131763356);
          break;
        }
        label1196:
        if ((k & 0x40) != 0) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!paramView.equals("qmessage")) || (paramInt != 0)) {
            break label1239;
          }
          paramView = this.context.getString(2131763356);
          break;
        }
        label1239:
        paramView = k.b(this.context, h.a(localau.field_isSend, localau.field_username, localau.field_content, Xr(localau.field_msgType), this.context), j);
        break label544;
        paramInt = -1;
        break label634;
        paramInt = 2131690878;
        break label634;
        paramInt = -1;
        break label634;
        paramInt = 2131690877;
        break label634;
        paramViewGroup.oah.setVisibility(0);
        break label764;
        label1317:
        if (localau.field_unReadCount > 0)
        {
          paramViewGroup.oaj.setText(localau.field_unReadCount);
          paramViewGroup.oaj.setBackgroundResource(u.aP(this.context, localau.field_unReadCount));
          paramViewGroup.oaj.setVisibility(0);
          break label868;
        }
        paramViewGroup.oaj.setVisibility(4);
        break label868;
        label1391:
        ((View)localObject1).findViewById(2131298792).setBackgroundResource(2131231817);
        break label945;
        label1408:
        paramViewGroup.JPD.setVisibility(0);
        if (localau.field_username.equals(paramView.dMd.dMg)) {
          paramViewGroup.JPD.setImageResource(2131691273);
        } else {
          paramViewGroup.JPD.setImageResource(2131691272);
        }
      }
    }
  }
  
  public final void iy(List<String> paramList)
  {
    AppMethodBeat.i(39515);
    this.fUR = paramList;
    a(null, null);
    AppMethodBeat.o(39515);
  }
  
  final class a
  {
    public CharSequence KPc;
    public CharSequence KPd;
    public int KPe;
    public CharSequence nickName;
    
    private a() {}
  }
  
  public static abstract interface b {}
  
  public static final class c
  {
    public ImageView JPC;
    public ImageView JPD;
    public ImageView fQl;
    public TextView fQm;
    public TextView oah;
    public TextView oai;
    public TextView oaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.a
 * JD-Core Version:    0.7.0.1
 */