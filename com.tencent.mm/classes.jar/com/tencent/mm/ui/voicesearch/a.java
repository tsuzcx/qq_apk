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
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vt.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.q;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a
  extends r<ap>
{
  private ColorStateList[] HGK;
  private HashMap<String, a> HGM;
  private boolean IBk;
  private b IYr;
  protected List<String> fzw;
  private String iJd;
  private com.tencent.mm.ui.applet.b iKs;
  private b.b iKt;
  
  public a(Context paramContext, r.a parama)
  {
    super(paramContext, new ap());
    AppMethodBeat.i(39514);
    this.fzw = null;
    this.HGK = new ColorStateList[2];
    this.IBk = true;
    this.iKt = null;
    this.iKs = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap Go(String paramAnonymousString)
      {
        AppMethodBeat.i(39511);
        paramAnonymousString = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(39511);
        return paramAnonymousString;
      }
    });
    super.a(parama);
    this.HGK[0] = com.tencent.mm.cc.a.m(paramContext, 2131100642);
    this.HGK[1] = com.tencent.mm.cc.a.m(paramContext, 2131100643);
    this.HGM = new HashMap();
    AppMethodBeat.o(39514);
  }
  
  private static int Tf(String paramString)
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
  
  public final void FZ(String paramString)
  {
    AppMethodBeat.i(39521);
    this.iJd = paramString;
    cVi();
    Xb();
    AppMethodBeat.o(39521);
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(39517);
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = com.tencent.mm.model.az.ayM().hlY.b(w.hmN, this.fzw, this.iJd);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((this.fzw != null) && (this.fzw.size() > 0)) {
      localArrayList1.addAll(this.fzw);
    }
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!w.sQ(str)) {
          localArrayList2.add(str);
        }
        ac.d("MicroMsg.SearchConversationAdapter", "block user ".concat(String.valueOf(str)));
      }
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SearchConversationAdapter", localException, "", new Object[0]);
      arrayOfCursor[1] = com.tencent.mm.model.az.ayM().hlZ.a(this.iJd, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      setCursor(new MergeCursor(arrayOfCursor));
      if ((this.IYr != null) && (this.iJd != null)) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(39517);
    }
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(39516);
    Xb();
    AppMethodBeat.o(39516);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(39520);
    if ((paramString != null) && (!paramString.equals("")) && (this.HGM != null)) {
      this.HGM.remove(paramString);
    }
    for (;;)
    {
      super.a(paramString, paramm);
      AppMethodBeat.o(39520);
      return;
      if (this.HGM != null) {
        this.HGM.clear();
      }
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39518);
    if (this.iKt == null) {
      this.iKt = new b.b()
      {
        public final int aPz()
        {
          AppMethodBeat.i(39513);
          int i = a.this.getCount();
          AppMethodBeat.o(39513);
          return i;
        }
        
        public final String qN(int paramAnonymousInt)
        {
          AppMethodBeat.i(39512);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= a.this.getCount()))
          {
            ac.e("MicroMsg.SearchConversationAdapter", "pos is invalid");
            AppMethodBeat.o(39512);
            return null;
          }
          Object localObject = (ap)a.this.getItem(paramAnonymousInt);
          if (localObject == null)
          {
            AppMethodBeat.o(39512);
            return null;
          }
          localObject = ((com.tencent.mm.g.c.az)localObject).field_username;
          AppMethodBeat.o(39512);
          return localObject;
        }
      };
    }
    if (this.iKs != null) {
      this.iKs.a(paramInt, this.iKt);
    }
    ap localap = (ap)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if ((Tf(localap.field_msgType) == 34) && (localap.field_isSend == 0) && (!bs.isNullOrNil(localap.field_content)))
    {
      localObject1 = localap.field_content;
      if (!localap.field_username.equals("qmessage"))
      {
        paramViewGroup = (ViewGroup)localObject1;
        if (!localap.field_username.equals("floatbottle")) {}
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
      if (new p(paramViewGroup).iaD) {}
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
        paramViewGroup.fuY = ((ImageView)((View)localObject1).findViewById(2131297008));
        paramViewGroup.fuZ = ((TextView)((View)localObject1).findViewById(2131302867));
        paramViewGroup.ntF = ((TextView)((View)localObject1).findViewById(2131306207));
        paramViewGroup.ntG = ((TextView)((View)localObject1).findViewById(2131301311));
        paramViewGroup.ntH = ((TextView)((View)localObject1).findViewById(2131305882));
        paramViewGroup.ntH.setBackgroundResource(com.tencent.mm.ui.tools.u.ks(this.context));
        paramViewGroup.HGW = ((ImageView)((View)localObject1).findViewById(2131300954));
        paramViewGroup.HGX = ((ImageView)((View)localObject1).findViewById(2131305672));
        ((View)localObject1).setTag(paramViewGroup);
        localObject2 = (a)this.HGM.get(localap.field_username + localap.field_content);
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          localObject2 = new a((byte)0);
          ((a)localObject2).nickName = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, v.wk(localap.field_username), paramViewGroup.fuZ.getTextSize());
          if (localap.field_status != 1) {
            break label1091;
          }
          paramView = this.context.getString(2131761075);
          ((a)localObject2).IBC = paramView;
          j = (int)paramViewGroup.ntG.getTextSize();
          k = com.tencent.mm.model.u.axA();
          paramView = localap.field_username;
          com.tencent.mm.model.az.ayM();
          if (bs.m((Integer)com.tencent.mm.model.c.agA().get(17, null)) != 1) {
            break label1126;
          }
          paramInt = 1;
          label519:
          if ((!paramView.equals("qqmail")) || (paramInt != 0)) {
            break label1131;
          }
          paramView = this.context.getString(2131763356);
          label544:
          ((a)localObject2).IBD = paramView;
          if ((w.sQ(localap.field_username)) && (q.wb(localap.field_username) == 0)) {
            ((a)localObject2).nickName = this.context.getString(2131757293);
          }
        }
        switch (localap.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label634:
          ((a)localObject2).IBE = paramInt;
          this.HGM.put(localap.field_username + localap.field_content, localObject2);
          paramView = (View)localObject2;
          paramViewGroup.ntG.setTextColor(this.HGK[i]);
          paramViewGroup.fuZ.setText(paramView.nickName);
          paramViewGroup.ntF.setText(paramView.IBC);
          paramViewGroup.ntG.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramView.IBD.toString(), paramViewGroup.ntG.getTextSize()));
          if (localap.field_conversationTime == 0L)
          {
            paramViewGroup.ntF.setVisibility(8);
            label764:
            paramViewGroup.HGW.setVisibility(8);
            if (w.sQ(localap.field_username))
            {
              com.tencent.mm.model.az.ayM();
              paramView = com.tencent.mm.model.c.awB().aNt(localap.field_username);
              if ((paramView != null) && (paramView.exT == 0)) {
                paramViewGroup.HGW.setVisibility(0);
              }
            }
            com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.fuY, localap.field_username);
            if (this.IBk)
            {
              if (localap.field_unReadCount <= 100) {
                break label1317;
              }
              paramViewGroup.ntH.setText("...");
              paramViewGroup.ntH.setVisibility(0);
            }
            label868:
            if (com.tencent.mm.model.az.agM())
            {
              if (!w.a(localap))
              {
                com.tencent.mm.model.az.ayM();
                if (com.tencent.mm.model.c.awG().h(localap))
                {
                  com.tencent.mm.model.az.ayM();
                  com.tencent.mm.model.c.awG().g(localap);
                }
              }
              com.tencent.mm.model.az.ayM();
              if (com.tencent.mm.model.c.awG().h(localap)) {
                break label1391;
              }
              ((View)localObject1).findViewById(2131298792).setBackgroundResource(2131231818);
            }
            label945:
            paramView = new vt();
            paramView.dyB.dyD = true;
            com.tencent.mm.sdk.b.a.GpY.l(paramView);
            if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localap, 7, 0L)) && (!localap.field_username.equals(paramView.dyC.dyF)))
            {
              localap.ov(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localap, 6, localap.field_conversationTime));
              com.tencent.mm.model.az.ayM();
              com.tencent.mm.model.c.awG().a(localap, localap.field_username);
            }
            if ((g.hXW != null) && (g.hXW.DC(localap.field_username))) {
              break label1408;
            }
            paramViewGroup.HGX.setVisibility(8);
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
        if (localap.field_conversationTime == 9223372036854775807L)
        {
          paramView = "";
          break label467;
        }
        paramView = com.tencent.mm.pluginsdk.g.h.c(this.context, localap.field_conversationTime, true);
        break label467;
        label1126:
        paramInt = 0;
        break label519;
        label1131:
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.storage.bu localbu = com.tencent.mm.model.c.awJ().alJ("@t.qq.com");
        if ((localbu != null) && (localbu.isEnable())) {}
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
        paramView = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, com.tencent.mm.booter.notification.a.h.a(localap.field_isSend, localap.field_username, localap.field_content, Tf(localap.field_msgType), this.context), j);
        break label544;
        paramInt = -1;
        break label634;
        paramInt = 2131690878;
        break label634;
        paramInt = -1;
        break label634;
        paramInt = 2131690877;
        break label634;
        paramViewGroup.ntF.setVisibility(0);
        break label764;
        label1317:
        if (localap.field_unReadCount > 0)
        {
          paramViewGroup.ntH.setText(localap.field_unReadCount);
          paramViewGroup.ntH.setBackgroundResource(com.tencent.mm.ui.tools.u.aM(this.context, localap.field_unReadCount));
          paramViewGroup.ntH.setVisibility(0);
          break label868;
        }
        paramViewGroup.ntH.setVisibility(4);
        break label868;
        label1391:
        ((View)localObject1).findViewById(2131298792).setBackgroundResource(2131231817);
        break label945;
        label1408:
        paramViewGroup.HGX.setVisibility(0);
        if (localap.field_username.equals(paramView.dyC.dyF)) {
          paramViewGroup.HGX.setImageResource(2131691273);
        } else {
          paramViewGroup.HGX.setImageResource(2131691272);
        }
      }
    }
  }
  
  public final void ic(List<String> paramList)
  {
    AppMethodBeat.i(39515);
    this.fzw = paramList;
    a(null, null);
    AppMethodBeat.o(39515);
  }
  
  final class a
  {
    public CharSequence IBC;
    public CharSequence IBD;
    public int IBE;
    public CharSequence nickName;
    
    private a() {}
  }
  
  public static abstract interface b {}
  
  public static final class c
  {
    public ImageView HGW;
    public ImageView HGX;
    public ImageView fuY;
    public TextView fuZ;
    public TextView ntF;
    public TextView ntG;
    public TextView ntH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.a
 * JD-Core Version:    0.7.0.1
 */