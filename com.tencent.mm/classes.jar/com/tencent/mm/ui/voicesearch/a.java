package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.g;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tl.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.p.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a
  extends com.tencent.mm.ui.p<ak>
{
  private a.b ABw;
  private boolean AhA;
  protected List<String> ejc;
  private String gvZ;
  private com.tencent.mm.ui.applet.b gxo;
  private b.b gxp;
  private ColorStateList[] ztd;
  private HashMap<String, a.a> zte;
  
  public a(Context paramContext, p.a parama)
  {
    super(paramContext, new ak());
    AppMethodBeat.i(35307);
    this.ejc = null;
    this.ztd = new ColorStateList[2];
    this.AhA = true;
    this.gxp = null;
    this.gxo = new com.tencent.mm.ui.applet.b(new a.1(this));
    super.a(parama);
    this.ztd[0] = com.tencent.mm.cb.a.l(paramContext, 2131690772);
    this.ztd[1] = com.tencent.mm.cb.a.l(paramContext, 2131690773);
    this.zte = new HashMap();
    AppMethodBeat.o(35307);
  }
  
  private static int GH(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(35312);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(35312);
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
  
  public final void Ku()
  {
    AppMethodBeat.i(35310);
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = aw.aaz().fkq.b(com.tencent.mm.model.t.flc, this.ejc, this.gvZ);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((this.ejc != null) && (this.ejc.size() > 0)) {
      localArrayList1.addAll(this.ejc);
    }
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!com.tencent.mm.model.t.lA(str)) {
          localArrayList2.add(str);
        }
        ab.d("MicroMsg.SearchConversationAdapter", "block user ".concat(String.valueOf(str)));
      }
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SearchConversationAdapter", localException, "", new Object[0]);
      arrayOfCursor[1] = aw.aaz().fkr.a(this.gvZ, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      setCursor(new MergeCursor(arrayOfCursor));
      if ((this.ABw != null) && (this.gvZ != null)) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(35310);
    }
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(35309);
    Ku();
    AppMethodBeat.o(35309);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(35313);
    if ((paramString != null) && (!paramString.equals("")) && (this.zte != null)) {
      this.zte.remove(paramString);
    }
    for (;;)
    {
      super.a(paramString, paramm);
      AppMethodBeat.o(35313);
      return;
      if (this.zte != null) {
        this.zte.clear();
      }
    }
  }
  
  public final void ft(List<String> paramList)
  {
    AppMethodBeat.i(35308);
    this.ejc = paramList;
    a(null, null);
    AppMethodBeat.o(35308);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(35311);
    if (this.gxp == null) {
      this.gxp = new b.b()
      {
        public final int aqn()
        {
          AppMethodBeat.i(35306);
          int i = a.this.getCount();
          AppMethodBeat.o(35306);
          return i;
        }
        
        public final String mS(int paramAnonymousInt)
        {
          AppMethodBeat.i(35305);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= a.this.getCount()))
          {
            ab.e("MicroMsg.SearchConversationAdapter", "pos is invalid");
            AppMethodBeat.o(35305);
            return null;
          }
          Object localObject = (ak)a.this.getItem(paramAnonymousInt);
          if (localObject == null)
          {
            AppMethodBeat.o(35305);
            return null;
          }
          localObject = ((au)localObject).field_username;
          AppMethodBeat.o(35305);
          return localObject;
        }
      };
    }
    if (this.gxo != null) {
      this.gxo.a(paramInt, this.gxp);
    }
    ak localak = (ak)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if ((GH(localak.field_msgType) == 34) && (localak.field_isSend == 0) && (!ah.isNullOrNil(localak.field_content)))
    {
      localObject1 = localak.field_content;
      if (!localak.field_username.equals("qmessage"))
      {
        paramViewGroup = (ViewGroup)localObject1;
        if (!localak.field_username.equals("floatbottle")) {}
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
      if (new com.tencent.mm.modelvoice.p(paramViewGroup).fXr) {}
    }
    for (int i = 1;; i = 0)
    {
      label467:
      int j;
      int k;
      if (paramView == null)
      {
        paramViewGroup = new a.c();
        localObject1 = View.inflate(this.context, 2130970627, null);
        paramViewGroup.egq = ((ImageView)((View)localObject1).findViewById(2131821210));
        paramViewGroup.egr = ((TextView)((View)localObject1).findViewById(2131823254));
        paramViewGroup.jSg = ((TextView)((View)localObject1).findViewById(2131823255));
        paramViewGroup.jSh = ((TextView)((View)localObject1).findViewById(2131823256));
        paramViewGroup.jSi = ((TextView)((View)localObject1).findViewById(2131821087));
        paramViewGroup.jSi.setBackgroundResource(com.tencent.mm.ui.tools.t.iF(this.context));
        paramViewGroup.ztl = ((ImageView)((View)localObject1).findViewById(2131823258));
        paramViewGroup.ztm = ((ImageView)((View)localObject1).findViewById(2131823259));
        ((View)localObject1).setTag(paramViewGroup);
        localObject2 = (a.a)this.zte.get(localak.field_username + localak.field_content);
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          localObject2 = new a.a(this, (byte)0);
          ((a.a)localObject2).nickName = j.b(this.context, s.nE(localak.field_username), paramViewGroup.egr.getTextSize());
          if (localak.field_status != 1) {
            break label1091;
          }
          paramView = this.context.getString(2131301428);
          ((a.a)localObject2).AhU = paramView;
          j = (int)paramViewGroup.jSh.getTextSize();
          k = r.Zr();
          paramView = localak.field_username;
          aw.aaz();
          if (ah.g((Integer)c.Ru().get(17, null)) != 1) {
            break label1126;
          }
          paramInt = 1;
          label519:
          if ((!paramView.equals("qqmail")) || (paramInt != 0)) {
            break label1131;
          }
          paramView = this.context.getString(2131303374);
          label544:
          ((a.a)localObject2).AhV = paramView;
          if ((com.tencent.mm.model.t.lA(localak.field_username)) && (n.nv(localak.field_username) == 0)) {
            ((a.a)localObject2).nickName = this.context.getString(2131298302);
          }
        }
        switch (localak.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label634:
          ((a.a)localObject2).AhW = paramInt;
          this.zte.put(localak.field_username + localak.field_content, localObject2);
          paramView = (View)localObject2;
          paramViewGroup.jSh.setTextColor(this.ztd[i]);
          paramViewGroup.egr.setText(paramView.nickName);
          paramViewGroup.jSg.setText(paramView.AhU);
          paramViewGroup.jSh.setText(j.b(this.context, paramView.AhV.toString(), paramViewGroup.jSh.getTextSize()));
          if (localak.field_conversationTime == 0L)
          {
            paramViewGroup.jSg.setVisibility(8);
            label764:
            paramViewGroup.ztl.setVisibility(8);
            if (com.tencent.mm.model.t.lA(localak.field_username))
            {
              aw.aaz();
              paramView = c.YA().arw(localak.field_username);
              if ((paramView != null) && (paramView.dqK == 0)) {
                paramViewGroup.ztl.setVisibility(0);
              }
            }
            com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.egq, localak.field_username);
            if (this.AhA)
            {
              if (localak.field_unReadCount <= 100) {
                break label1317;
              }
              paramViewGroup.jSi.setText("...");
              paramViewGroup.jSi.setVisibility(0);
            }
            label868:
            if (aw.RG())
            {
              if (!com.tencent.mm.model.t.a(localak))
              {
                aw.aaz();
                if (c.YF().g(localak))
                {
                  aw.aaz();
                  c.YF().f(localak);
                }
              }
              aw.aaz();
              if (c.YF().g(localak)) {
                break label1372;
              }
              ((View)localObject1).findViewById(2131823252).setBackgroundResource(2130838445);
            }
            label945:
            paramView = new tl();
            paramView.cJT.cJV = true;
            com.tencent.mm.sdk.b.a.ymk.l(paramView);
            if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localak, 7, 0L)) && (!localak.field_username.equals(paramView.cJU.cJX)))
            {
              localak.fL(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localak, 6, localak.field_conversationTime));
              aw.aaz();
              c.YF().a(localak, localak.field_username);
            }
            if ((g.fUM != null) && (g.fUM.uL(localak.field_username))) {
              break label1389;
            }
            paramViewGroup.ztm.setVisibility(8);
          }
          break;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(35311);
        return localObject1;
        paramViewGroup = (a.c)paramView.getTag();
        localObject1 = paramView;
        break;
        label1091:
        if (localak.field_conversationTime == 9223372036854775807L)
        {
          paramView = "";
          break label467;
        }
        paramView = com.tencent.mm.pluginsdk.f.h.c(this.context, localak.field_conversationTime, true);
        break label467;
        label1126:
        paramInt = 0;
        break label519;
        label1131:
        aw.aaz();
        com.tencent.mm.storage.bq localbq = c.YI().TL("@t.qq.com");
        if ((localbq != null) && (localbq.isEnable())) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!paramView.equals("tmessage")) || (paramInt != 0)) {
            break label1196;
          }
          paramView = this.context.getString(2131303374);
          break;
        }
        label1196:
        if ((k & 0x40) != 0) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!paramView.equals("qmessage")) || (paramInt != 0)) {
            break label1239;
          }
          paramView = this.context.getString(2131303374);
          break;
        }
        label1239:
        paramView = j.b(this.context, com.tencent.mm.booter.notification.a.h.a(localak.field_isSend, localak.field_username, localak.field_content, GH(localak.field_msgType), this.context), j);
        break label544;
        paramInt = -1;
        break label634;
        paramInt = 2131231716;
        break label634;
        paramInt = -1;
        break label634;
        paramInt = 2131231715;
        break label634;
        paramViewGroup.jSg.setVisibility(0);
        break label764;
        label1317:
        if (localak.field_unReadCount > 0)
        {
          paramViewGroup.jSi.setText(localak.field_unReadCount);
          paramViewGroup.jSi.setVisibility(0);
          break label868;
        }
        paramViewGroup.jSi.setVisibility(4);
        break label868;
        label1372:
        ((View)localObject1).findViewById(2131823252).setBackgroundResource(2130838444);
        break label945;
        label1389:
        paramViewGroup.ztm.setVisibility(0);
        if (localak.field_username.equals(paramView.cJU.cJX)) {
          paramViewGroup.ztm.setImageResource(2131232073);
        } else {
          paramViewGroup.ztm.setImageResource(2131232072);
        }
      }
    }
  }
  
  public final void wQ(String paramString)
  {
    AppMethodBeat.i(35314);
    this.gvZ = paramString;
    bKb();
    Ku();
    AppMethodBeat.o(35314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.a
 * JD-Core Version:    0.7.0.1
 */