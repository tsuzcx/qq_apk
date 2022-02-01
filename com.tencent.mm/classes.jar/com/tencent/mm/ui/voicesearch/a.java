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
import com.tencent.mm.bi.g;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.wm.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.q;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a
  extends r<at>
{
  private ColorStateList[] JuB;
  private HashMap<String, a> JuD;
  private b KPw;
  private boolean Ksq;
  protected List<String> fSL;
  private String jcm;
  private com.tencent.mm.ui.applet.b jdB;
  private b.b jdC;
  
  public a(Context paramContext, r.a parama)
  {
    super(paramContext, new at());
    AppMethodBeat.i(39514);
    this.fSL = null;
    this.JuB = new ColorStateList[2];
    this.Ksq = true;
    this.jdC = null;
    this.jdB = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap JD(String paramAnonymousString)
      {
        AppMethodBeat.i(39511);
        paramAnonymousString = com.tencent.mm.ak.c.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(39511);
        return paramAnonymousString;
      }
    });
    super.a(parama);
    this.JuB[0] = com.tencent.mm.cc.a.m(paramContext, 2131100642);
    this.JuB[1] = com.tencent.mm.cc.a.m(paramContext, 2131100643);
    this.JuD = new HashMap();
    AppMethodBeat.o(39514);
  }
  
  private static int WF(String paramString)
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
  
  public final void Jo(String paramString)
  {
    AppMethodBeat.i(39521);
    this.jcm = paramString;
    det();
    Zu();
    AppMethodBeat.o(39521);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(39517);
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = com.tencent.mm.model.ba.aBQ().hEl.a(w.hFd, this.fSL, this.jcm);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((this.fSL != null) && (this.fSL.size() > 0)) {
      localArrayList1.addAll(this.fSL);
    }
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!w.vF(str)) {
          localArrayList2.add(str);
        }
        ad.d("MicroMsg.SearchConversationAdapter", "block user ".concat(String.valueOf(str)));
      }
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SearchConversationAdapter", localException, "", new Object[0]);
      arrayOfCursor[1] = com.tencent.mm.model.ba.aBQ().hEm.a(this.jcm, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      setCursor(new MergeCursor(arrayOfCursor));
      if ((this.KPw != null) && (this.jcm != null)) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(39517);
    }
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(39516);
    Zu();
    AppMethodBeat.o(39516);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(39520);
    if ((paramString != null) && (!paramString.equals("")) && (this.JuD != null)) {
      this.JuD.remove(paramString);
    }
    for (;;)
    {
      super.a(paramString, paramm);
      AppMethodBeat.o(39520);
      return;
      if (this.JuD != null) {
        this.JuD.clear();
      }
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39518);
    if (this.jdC == null) {
      this.jdC = new b.b()
      {
        public final int aSL()
        {
          AppMethodBeat.i(39513);
          int i = a.this.getCount();
          AppMethodBeat.o(39513);
          return i;
        }
        
        public final String rn(int paramAnonymousInt)
        {
          AppMethodBeat.i(39512);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= a.this.getCount()))
          {
            ad.e("MicroMsg.SearchConversationAdapter", "pos is invalid");
            AppMethodBeat.o(39512);
            return null;
          }
          Object localObject = (at)a.this.getItem(paramAnonymousInt);
          if (localObject == null)
          {
            AppMethodBeat.o(39512);
            return null;
          }
          localObject = ((com.tencent.mm.g.c.ba)localObject).field_username;
          AppMethodBeat.o(39512);
          return localObject;
        }
      };
    }
    if (this.jdB != null) {
      this.jdB.a(paramInt, this.jdC);
    }
    at localat = (at)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if ((WF(localat.field_msgType) == 34) && (localat.field_isSend == 0) && (!bt.isNullOrNil(localat.field_content)))
    {
      localObject1 = localat.field_content;
      if (!localat.field_username.equals("qmessage"))
      {
        paramViewGroup = (ViewGroup)localObject1;
        if (!localat.field_username.equals("floatbottle")) {}
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
      if (new p(paramViewGroup).itZ) {}
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
        paramViewGroup.fOf = ((ImageView)((View)localObject1).findViewById(2131297008));
        paramViewGroup.fOg = ((TextView)((View)localObject1).findViewById(2131302867));
        paramViewGroup.nUB = ((TextView)((View)localObject1).findViewById(2131306207));
        paramViewGroup.nUC = ((TextView)((View)localObject1).findViewById(2131301311));
        paramViewGroup.nUD = ((TextView)((View)localObject1).findViewById(2131305882));
        paramViewGroup.nUD.setBackgroundResource(com.tencent.mm.ui.tools.u.kE(this.context));
        paramViewGroup.JuN = ((ImageView)((View)localObject1).findViewById(2131300954));
        paramViewGroup.JuO = ((ImageView)((View)localObject1).findViewById(2131305672));
        ((View)localObject1).setTag(paramViewGroup);
        localObject2 = (a)this.JuD.get(localat.field_username + localat.field_content);
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          localObject2 = new a((byte)0);
          ((a)localObject2).nickName = k.b(this.context, v.zf(localat.field_username), paramViewGroup.fOg.getTextSize());
          if (localat.field_status != 1) {
            break label1091;
          }
          paramView = this.context.getString(2131761075);
          ((a)localObject2).KsI = paramView;
          j = (int)paramViewGroup.nUC.getTextSize();
          k = com.tencent.mm.model.u.aAq();
          paramView = localat.field_username;
          com.tencent.mm.model.ba.aBQ();
          if (bt.n((Integer)com.tencent.mm.model.c.ajl().get(17, null)) != 1) {
            break label1126;
          }
          paramInt = 1;
          label519:
          if ((!paramView.equals("qqmail")) || (paramInt != 0)) {
            break label1131;
          }
          paramView = this.context.getString(2131763356);
          label544:
          ((a)localObject2).KsJ = paramView;
          if ((w.vF(localat.field_username)) && (q.yS(localat.field_username) == 0)) {
            ((a)localObject2).nickName = this.context.getString(2131757293);
          }
        }
        switch (localat.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label634:
          ((a)localObject2).KsK = paramInt;
          this.JuD.put(localat.field_username + localat.field_content, localObject2);
          paramView = (View)localObject2;
          paramViewGroup.nUC.setTextColor(this.JuB[i]);
          paramViewGroup.fOg.setText(paramView.nickName);
          paramViewGroup.nUB.setText(paramView.KsI);
          paramViewGroup.nUC.setText(k.b(this.context, paramView.KsJ.toString(), paramViewGroup.nUC.getTextSize()));
          if (localat.field_conversationTime == 0L)
          {
            paramViewGroup.nUB.setVisibility(8);
            label764:
            paramViewGroup.JuN.setVisibility(8);
            if (w.vF(localat.field_username))
            {
              com.tencent.mm.model.ba.aBQ();
              paramView = com.tencent.mm.model.c.azp().Bf(localat.field_username);
              if ((paramView != null) && (paramView.ePs == 0)) {
                paramViewGroup.JuN.setVisibility(0);
              }
            }
            com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.fOf, localat.field_username);
            if (this.Ksq)
            {
              if (localat.field_unReadCount <= 100) {
                break label1317;
              }
              paramViewGroup.nUD.setText("...");
              paramViewGroup.nUD.setVisibility(0);
            }
            label868:
            if (com.tencent.mm.model.ba.ajx())
            {
              if (!w.a(localat))
              {
                com.tencent.mm.model.ba.aBQ();
                if (com.tencent.mm.model.c.azv().h(localat))
                {
                  com.tencent.mm.model.ba.aBQ();
                  com.tencent.mm.model.c.azv().g(localat);
                }
              }
              com.tencent.mm.model.ba.aBQ();
              if (com.tencent.mm.model.c.azv().h(localat)) {
                break label1391;
              }
              ((View)localObject1).findViewById(2131298792).setBackgroundResource(2131231818);
            }
            label945:
            paramView = new wm();
            paramView.dKN.dKP = true;
            com.tencent.mm.sdk.b.a.IbL.l(paramView);
            if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localat, 7, 0L)) && (!localat.field_username.equals(paramView.dKO.dKR)))
            {
              localat.qv(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localat, 6, localat.field_conversationTime));
              com.tencent.mm.model.ba.aBQ();
              com.tencent.mm.model.c.azv().a(localat, localat.field_username);
            }
            if ((g.irs != null) && (g.irs.GH(localat.field_username))) {
              break label1408;
            }
            paramViewGroup.JuO.setVisibility(8);
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
        if (localat.field_conversationTime == 9223372036854775807L)
        {
          paramView = "";
          break label467;
        }
        paramView = i.c(this.context, localat.field_conversationTime, true);
        break label467;
        label1126:
        paramInt = 0;
        break label519;
        label1131:
        com.tencent.mm.model.ba.aBQ();
        ca localca = com.tencent.mm.model.c.azy().aqy("@t.qq.com");
        if ((localca != null) && (localca.isEnable())) {}
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
        paramView = k.b(this.context, h.a(localat.field_isSend, localat.field_username, localat.field_content, WF(localat.field_msgType), this.context), j);
        break label544;
        paramInt = -1;
        break label634;
        paramInt = 2131690878;
        break label634;
        paramInt = -1;
        break label634;
        paramInt = 2131690877;
        break label634;
        paramViewGroup.nUB.setVisibility(0);
        break label764;
        label1317:
        if (localat.field_unReadCount > 0)
        {
          paramViewGroup.nUD.setText(localat.field_unReadCount);
          paramViewGroup.nUD.setBackgroundResource(com.tencent.mm.ui.tools.u.aP(this.context, localat.field_unReadCount));
          paramViewGroup.nUD.setVisibility(0);
          break label868;
        }
        paramViewGroup.nUD.setVisibility(4);
        break label868;
        label1391:
        ((View)localObject1).findViewById(2131298792).setBackgroundResource(2131231817);
        break label945;
        label1408:
        paramViewGroup.JuO.setVisibility(0);
        if (localat.field_username.equals(paramView.dKO.dKR)) {
          paramViewGroup.JuO.setImageResource(2131691273);
        } else {
          paramViewGroup.JuO.setImageResource(2131691272);
        }
      }
    }
  }
  
  public final void io(List<String> paramList)
  {
    AppMethodBeat.i(39515);
    this.fSL = paramList;
    a(null, null);
    AppMethodBeat.o(39515);
  }
  
  final class a
  {
    public CharSequence KsI;
    public CharSequence KsJ;
    public int KsK;
    public CharSequence nickName;
    
    private a() {}
  }
  
  public static abstract interface b {}
  
  public static final class c
  {
    public ImageView JuN;
    public ImageView JuO;
    public ImageView fOf;
    public TextView fOg;
    public TextView nUB;
    public TextView nUC;
    public TextView nUD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.a
 * JD-Core Version:    0.7.0.1
 */