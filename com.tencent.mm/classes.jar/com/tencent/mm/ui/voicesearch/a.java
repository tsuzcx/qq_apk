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
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vj.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.q.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a
  extends com.tencent.mm.ui.q<am>
{
  private ColorStateList[] GgV;
  private HashMap<String, a> GgX;
  private boolean Hbd;
  private b HxU;
  protected List<String> fvP;
  private String iiW;
  private com.tencent.mm.ui.applet.b ikl;
  private b.b ikm;
  
  public a(Context paramContext, q.a parama)
  {
    super(paramContext, new am());
    AppMethodBeat.i(39514);
    this.fvP = null;
    this.GgV = new ColorStateList[2];
    this.Hbd = true;
    this.ikm = null;
    this.ikl = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap Cl(String paramAnonymousString)
      {
        AppMethodBeat.i(39511);
        paramAnonymousString = com.tencent.mm.ak.c.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(39511);
        return paramAnonymousString;
      }
    });
    super.a(parama);
    this.GgV[0] = com.tencent.mm.cd.a.m(paramContext, 2131100642);
    this.GgV[1] = com.tencent.mm.cd.a.m(paramContext, 2131100643);
    this.GgX = new HashMap();
    AppMethodBeat.o(39514);
  }
  
  private static int OV(String paramString)
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
  
  public final void BW(String paramString)
  {
    AppMethodBeat.i(39521);
    this.iiW = paramString;
    cHX();
    Wd();
    AppMethodBeat.o(39521);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(39517);
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = az.arV().gLy.b(w.gMn, this.fvP, this.iiW);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((this.fvP != null) && (this.fvP.size() > 0)) {
      localArrayList1.addAll(this.fvP);
    }
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!w.pF(str)) {
          localArrayList2.add(str);
        }
        ad.d("MicroMsg.SearchConversationAdapter", "block user ".concat(String.valueOf(str)));
      }
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SearchConversationAdapter", localException, "", new Object[0]);
      arrayOfCursor[1] = az.arV().gLz.a(this.iiW, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      setCursor(new MergeCursor(arrayOfCursor));
      if ((this.HxU != null) && (this.iiW != null)) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(39517);
    }
  }
  
  public final void We()
  {
    AppMethodBeat.i(39516);
    Wd();
    AppMethodBeat.o(39516);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(39520);
    if ((paramString != null) && (!paramString.equals("")) && (this.GgX != null)) {
      this.GgX.remove(paramString);
    }
    for (;;)
    {
      super.a(paramString, paramm);
      AppMethodBeat.o(39520);
      return;
      if (this.GgX != null) {
        this.GgX.clear();
      }
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39518);
    if (this.ikm == null) {
      this.ikm = new b.b()
      {
        public final int aII()
        {
          AppMethodBeat.i(39513);
          int i = a.this.getCount();
          AppMethodBeat.o(39513);
          return i;
        }
        
        public final String qa(int paramAnonymousInt)
        {
          AppMethodBeat.i(39512);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= a.this.getCount()))
          {
            ad.e("MicroMsg.SearchConversationAdapter", "pos is invalid");
            AppMethodBeat.o(39512);
            return null;
          }
          Object localObject = (am)a.this.getItem(paramAnonymousInt);
          if (localObject == null)
          {
            AppMethodBeat.o(39512);
            return null;
          }
          localObject = ((ay)localObject).field_username;
          AppMethodBeat.o(39512);
          return localObject;
        }
      };
    }
    if (this.ikl != null) {
      this.ikl.a(paramInt, this.ikm);
    }
    am localam = (am)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if ((OV(localam.field_msgType) == 34) && (localam.field_isSend == 0) && (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(localam.field_content)))
    {
      localObject1 = localam.field_content;
      if (!localam.field_username.equals("qmessage"))
      {
        paramViewGroup = (ViewGroup)localObject1;
        if (!localam.field_username.equals("floatbottle")) {}
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
      if (new p(paramViewGroup).hAc) {}
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
        paramViewGroup.frr = ((ImageView)((View)localObject1).findViewById(2131297008));
        paramViewGroup.frs = ((TextView)((View)localObject1).findViewById(2131302867));
        paramViewGroup.mRp = ((TextView)((View)localObject1).findViewById(2131306207));
        paramViewGroup.mRq = ((TextView)((View)localObject1).findViewById(2131301311));
        paramViewGroup.mRr = ((TextView)((View)localObject1).findViewById(2131305882));
        paramViewGroup.mRr.setBackgroundResource(com.tencent.mm.ui.tools.u.kh(this.context));
        paramViewGroup.Ghh = ((ImageView)((View)localObject1).findViewById(2131300954));
        paramViewGroup.Ghi = ((ImageView)((View)localObject1).findViewById(2131305672));
        ((View)localObject1).setTag(paramViewGroup);
        localObject2 = (a)this.GgX.get(localam.field_username + localam.field_content);
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          localObject2 = new a((byte)0);
          ((a)localObject2).nickName = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, v.sh(localam.field_username), paramViewGroup.frs.getTextSize());
          if (localam.field_status != 1) {
            break label1091;
          }
          paramView = this.context.getString(2131761075);
          ((a)localObject2).Hbw = paramView;
          j = (int)paramViewGroup.mRq.getTextSize();
          k = com.tencent.mm.model.u.aqK();
          paramView = localam.field_username;
          az.arV();
          if (com.tencent.mm.sdk.platformtools.bt.l((Integer)com.tencent.mm.model.c.afk().get(17, null)) != 1) {
            break label1126;
          }
          paramInt = 1;
          label519:
          if ((!paramView.equals("qqmail")) || (paramInt != 0)) {
            break label1131;
          }
          paramView = this.context.getString(2131763356);
          label544:
          ((a)localObject2).Hbx = paramView;
          if ((w.pF(localam.field_username)) && (com.tencent.mm.model.q.rY(localam.field_username) == 0)) {
            ((a)localObject2).nickName = this.context.getString(2131757293);
          }
        }
        switch (localam.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label634:
          ((a)localObject2).Hby = paramInt;
          this.GgX.put(localam.field_username + localam.field_content, localObject2);
          paramView = (View)localObject2;
          paramViewGroup.mRq.setTextColor(this.GgV[i]);
          paramViewGroup.frs.setText(paramView.nickName);
          paramViewGroup.mRp.setText(paramView.Hbw);
          paramViewGroup.mRq.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramView.Hbx.toString(), paramViewGroup.mRq.getTextSize()));
          if (localam.field_conversationTime == 0L)
          {
            paramViewGroup.mRp.setVisibility(8);
            label764:
            paramViewGroup.Ghh.setVisibility(8);
            if (w.pF(localam.field_username))
            {
              az.arV();
              paramView = com.tencent.mm.model.c.apM().aHY(localam.field_username);
              if ((paramView != null) && (paramView.evx == 0)) {
                paramViewGroup.Ghh.setVisibility(0);
              }
            }
            com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.frr, localam.field_username);
            if (this.Hbd)
            {
              if (localam.field_unReadCount <= 100) {
                break label1317;
              }
              paramViewGroup.mRr.setText("...");
              paramViewGroup.mRr.setVisibility(0);
            }
            label868:
            if (az.afw())
            {
              if (!w.a(localam))
              {
                az.arV();
                if (com.tencent.mm.model.c.apR().h(localam))
                {
                  az.arV();
                  com.tencent.mm.model.c.apR().g(localam);
                }
              }
              az.arV();
              if (com.tencent.mm.model.c.apR().h(localam)) {
                break label1391;
              }
              ((View)localObject1).findViewById(2131298792).setBackgroundResource(2131231818);
            }
            label945:
            paramView = new vj();
            paramView.dAP.dAR = true;
            com.tencent.mm.sdk.b.a.ESL.l(paramView);
            if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localam, 7, 0L)) && (!localam.field_username.equals(paramView.dAQ.dAT)))
            {
              localam.kT(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localam, 6, localam.field_conversationTime));
              az.arV();
              com.tencent.mm.model.c.apR().a(localam, localam.field_username);
            }
            if ((g.hxv != null) && (g.hxv.zx(localam.field_username))) {
              break label1408;
            }
            paramViewGroup.Ghi.setVisibility(8);
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
        if (localam.field_conversationTime == 9223372036854775807L)
        {
          paramView = "";
          break label467;
        }
        paramView = com.tencent.mm.pluginsdk.g.h.c(this.context, localam.field_conversationTime, true);
        break label467;
        label1126:
        paramInt = 0;
        break label519;
        label1131:
        az.arV();
        br localbr = com.tencent.mm.model.c.apU().agP("@t.qq.com");
        if ((localbr != null) && (localbr.isEnable())) {}
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
        paramView = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, com.tencent.mm.booter.notification.a.h.a(localam.field_isSend, localam.field_username, localam.field_content, OV(localam.field_msgType), this.context), j);
        break label544;
        paramInt = -1;
        break label634;
        paramInt = 2131690878;
        break label634;
        paramInt = -1;
        break label634;
        paramInt = 2131690877;
        break label634;
        paramViewGroup.mRp.setVisibility(0);
        break label764;
        label1317:
        if (localam.field_unReadCount > 0)
        {
          paramViewGroup.mRr.setText(localam.field_unReadCount);
          paramViewGroup.mRr.setBackgroundResource(com.tencent.mm.ui.tools.u.aG(this.context, localam.field_unReadCount));
          paramViewGroup.mRr.setVisibility(0);
          break label868;
        }
        paramViewGroup.mRr.setVisibility(4);
        break label868;
        label1391:
        ((View)localObject1).findViewById(2131298792).setBackgroundResource(2131231817);
        break label945;
        label1408:
        paramViewGroup.Ghi.setVisibility(0);
        if (localam.field_username.equals(paramView.dAQ.dAT)) {
          paramViewGroup.Ghi.setImageResource(2131691273);
        } else {
          paramViewGroup.Ghi.setImageResource(2131691272);
        }
      }
    }
  }
  
  public final void hP(List<String> paramList)
  {
    AppMethodBeat.i(39515);
    this.fvP = paramList;
    a(null, null);
    AppMethodBeat.o(39515);
  }
  
  final class a
  {
    public CharSequence Hbw;
    public CharSequence Hbx;
    public int Hby;
    public CharSequence nickName;
    
    private a() {}
  }
  
  public static abstract interface b {}
  
  public static final class c
  {
    public ImageView Ghh;
    public ImageView Ghi;
    public ImageView frr;
    public TextView frs;
    public TextView mRp;
    public TextView mRq;
    public TextView mRr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.a
 * JD-Core Version:    0.7.0.1
 */