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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.d;
import com.tencent.mm.bj.g;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.f.a.yx;
import com.tencent.mm.f.a.yx.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cj;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.tools.w;
import com.tencent.mm.ui.v.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a
  extends com.tencent.mm.ui.v<az>
{
  private ColorStateList[] WtI;
  private HashMap<String, a> WtK;
  private boolean XAa;
  private b XZB;
  protected List<String> jkb;
  private String mUI;
  private com.tencent.mm.ui.applet.b mVX;
  private b.b mVY;
  
  public a(Context paramContext, v.a parama)
  {
    super(paramContext, new az());
    AppMethodBeat.i(39514);
    this.jkb = null;
    this.WtI = new ColorStateList[2];
    this.XAa = true;
    this.mVY = null;
    this.mVX = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap aaG(String paramAnonymousString)
      {
        AppMethodBeat.i(39511);
        paramAnonymousString = d.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(39511);
        return paramAnonymousString;
      }
    });
    super.a(parama);
    this.WtI[0] = com.tencent.mm.ci.a.l(paramContext, R.e.mm_list_textcolor_two);
    this.WtI[1] = com.tencent.mm.ci.a.l(paramContext, R.e.mm_list_textcolor_unread);
    this.WtK = new HashMap();
    AppMethodBeat.o(39514);
  }
  
  private static int aoT(String paramString)
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
  
  public final void aas(String paramString)
  {
    AppMethodBeat.i(39521);
    this.mUI = paramString;
    eKd();
    atr();
    AppMethodBeat.o(39521);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(39517);
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = bh.beI().lqS.a(ab.lsA, this.jkb, this.mUI);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((this.jkb != null) && (this.jkb.size() > 0)) {
      localArrayList1.addAll(this.jkb);
    }
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!ab.Lj(str)) {
          localArrayList2.add(str);
        }
        Log.d("MicroMsg.SearchConversationAdapter", "block user ".concat(String.valueOf(str)));
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SearchConversationAdapter", localException, "", new Object[0]);
      arrayOfCursor[1] = bh.beI().lqT.a(this.mUI, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      v(new MergeCursor(arrayOfCursor));
      if ((this.XZB != null) && (this.mUI != null)) {
        hK().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(39517);
    }
  }
  
  public final void ats()
  {
    AppMethodBeat.i(39516);
    atr();
    AppMethodBeat.o(39516);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39518);
    if (this.mVY == null) {
      this.mVY = new b.b()
      {
        public final int byf()
        {
          AppMethodBeat.i(39513);
          int i = a.this.getCount();
          AppMethodBeat.o(39513);
          return i;
        }
        
        public final String yk(int paramAnonymousInt)
        {
          AppMethodBeat.i(39512);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= a.this.getCount()))
          {
            Log.e("MicroMsg.SearchConversationAdapter", "pos is invalid");
            AppMethodBeat.o(39512);
            return null;
          }
          Object localObject = (az)a.this.getItem(paramAnonymousInt);
          if (localObject == null)
          {
            AppMethodBeat.o(39512);
            return null;
          }
          localObject = ((bb)localObject).field_username;
          AppMethodBeat.o(39512);
          return localObject;
        }
      };
    }
    if (this.mVX != null) {
      this.mVX.a(paramInt, this.mVY);
    }
    az localaz = (az)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if ((aoT(localaz.field_msgType) == 34) && (localaz.field_isSend == 0) && (!Util.isNullOrNil(localaz.field_content)))
    {
      localObject1 = localaz.field_content;
      if (!localaz.field_username.equals("qmessage"))
      {
        paramViewGroup = (ViewGroup)localObject1;
        if (!localaz.field_username.equals("floatbottle")) {}
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
      if (new p(paramViewGroup).mhL) {}
    }
    for (int i = 1;; i = 0)
    {
      label467:
      int j;
      int k;
      if (paramView == null)
      {
        paramViewGroup = new c();
        localObject1 = View.inflate(this.context, R.i.ekG, null);
        paramViewGroup.iZG = ((ImageView)((View)localObject1).findViewById(R.h.avatar_iv));
        paramViewGroup.iZH = ((TextView)((View)localObject1).findViewById(R.h.nickname_tv));
        paramViewGroup.snm = ((TextView)((View)localObject1).findViewById(R.h.update_time_tv));
        paramViewGroup.snn = ((TextView)((View)localObject1).findViewById(R.h.last_msg_tv));
        paramViewGroup.sno = ((TextView)((View)localObject1).findViewById(R.h.tipcnt_tv));
        paramViewGroup.sno.setBackgroundResource(w.lE(this.context));
        paramViewGroup.WtU = ((ImageView)((View)localObject1).findViewById(R.h.dIR));
        paramViewGroup.WtV = ((ImageView)((View)localObject1).findViewById(R.h.dWs));
        ((View)localObject1).setTag(paramViewGroup);
        localObject2 = (a)this.WtK.get(localaz.field_username + localaz.field_content);
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          localObject2 = new a((byte)0);
          ((a)localObject2).nickName = com.tencent.mm.pluginsdk.ui.span.l.b(this.context, aa.PJ(localaz.field_username), paramViewGroup.iZH.getTextSize());
          if (localaz.field_status != 1) {
            break label1091;
          }
          paramView = this.context.getString(R.l.eLv);
          ((a)localObject2).XAs = paramView;
          j = (int)paramViewGroup.snn.getTextSize();
          k = z.bdd();
          paramView = localaz.field_username;
          bh.beI();
          if (Util.nullAsNil((Integer)c.aHp().b(17, null)) != 1) {
            break label1127;
          }
          paramInt = 1;
          label519:
          if ((!paramView.equals("qqmail")) || (paramInt != 0)) {
            break label1132;
          }
          paramView = this.context.getString(R.l.settings_plugins_disable);
          label544:
          ((a)localObject2).XAt = paramView;
          if ((ab.Lj(localaz.field_username)) && (com.tencent.mm.model.v.Pu(localaz.field_username) == 0)) {
            ((a)localObject2).nickName = this.context.getString(R.l.ewS);
          }
        }
        switch (localaz.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label634:
          ((a)localObject2).XAu = paramInt;
          this.WtK.put(localaz.field_username + localaz.field_content, localObject2);
          paramView = (View)localObject2;
          paramViewGroup.snn.setTextColor(this.WtI[i]);
          paramViewGroup.iZH.setText(paramView.nickName);
          paramViewGroup.snm.setText(paramView.XAs);
          paramViewGroup.snn.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, paramView.XAt.toString(), paramViewGroup.snn.getTextSize()));
          if (localaz.field_conversationTime == 0L)
          {
            paramViewGroup.snm.setVisibility(8);
            label764:
            paramViewGroup.WtU.setVisibility(8);
            if (ab.Lj(localaz.field_username))
            {
              bh.beI();
              paramView = c.bbL().RG(localaz.field_username);
              if ((paramView != null) && (paramView.hDj == 0)) {
                paramViewGroup.WtU.setVisibility(0);
              }
            }
            com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.iZG, localaz.field_username);
            if (this.XAa)
            {
              if (localaz.field_unReadCount <= 100) {
                break label1318;
              }
              paramViewGroup.sno.setText("...");
              paramViewGroup.sno.setVisibility(0);
            }
            label868:
            if (bh.aHB())
            {
              if (!ab.a(localaz))
              {
                bh.beI();
                if (c.bbR().h(localaz))
                {
                  bh.beI();
                  c.bbR().g(localaz);
                }
              }
              bh.beI();
              if (c.bbR().h(localaz)) {
                break label1392;
              }
              ((View)localObject1).findViewById(R.h.dCL).setBackgroundResource(R.g.comm_list_item_selector);
            }
            label945:
            paramView = new yx();
            paramView.fYg.fYi = true;
            EventCenter.instance.publish(paramView);
            if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, 7, 0L)) && (!localaz.field_username.equals(paramView.fYh.fYk)))
            {
              localaz.EC(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, 6, localaz.field_conversationTime));
              bh.beI();
              c.bbR().a(localaz, localaz.field_username);
            }
            if ((g.meT != null) && (g.meT.Xt(localaz.field_username))) {
              break label1409;
            }
            paramViewGroup.WtV.setVisibility(8);
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
        if (localaz.field_conversationTime == 9223372036854775807L)
        {
          paramView = "";
          break label467;
        }
        paramView = f.d(this.context, localaz.field_conversationTime, true);
        break label467;
        label1127:
        paramInt = 0;
        break label519;
        label1132:
        bh.beI();
        cj localcj = c.bbU().aPi("@t.qq.com");
        if ((localcj != null) && (localcj.isEnable())) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!paramView.equals("tmessage")) || (paramInt != 0)) {
            break label1197;
          }
          paramView = this.context.getString(R.l.settings_plugins_disable);
          break;
        }
        label1197:
        if ((k & 0x40) != 0) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!paramView.equals("qmessage")) || (paramInt != 0)) {
            break label1240;
          }
          paramView = this.context.getString(R.l.settings_plugins_disable);
          break;
        }
        label1240:
        paramView = com.tencent.mm.pluginsdk.ui.span.l.d(this.context, h.a(localaz.field_isSend, localaz.field_username, localaz.field_content, aoT(localaz.field_msgType), this.context), j);
        break label544;
        paramInt = -1;
        break label634;
        paramInt = R.k.msg_state_sending;
        break label634;
        paramInt = -1;
        break label634;
        paramInt = R.k.msg_state_failed;
        break label634;
        paramViewGroup.snm.setVisibility(0);
        break label764;
        label1318:
        if (localaz.field_unReadCount > 0)
        {
          paramViewGroup.sno.setText(localaz.field_unReadCount);
          paramViewGroup.sno.setBackgroundResource(w.bj(this.context, localaz.field_unReadCount));
          paramViewGroup.sno.setVisibility(0);
          break label868;
        }
        paramViewGroup.sno.setVisibility(4);
        break label868;
        label1392:
        ((View)localObject1).findViewById(R.h.dCL).setBackgroundResource(R.g.comm_item_highlight_selector);
        break label945;
        label1409:
        paramViewGroup.WtV.setVisibility(0);
        if (localaz.field_username.equals(paramView.fYh.fYk)) {
          paramViewGroup.WtV.setImageResource(R.k.talk_room_mic_speaking);
        } else {
          paramViewGroup.WtV.setImageResource(R.k.talk_room_mic_idle);
        }
      }
    }
  }
  
  public final void kw(List<String> paramList)
  {
    AppMethodBeat.i(39515);
    this.jkb = paramList;
    onNotifyChange(null, null);
    AppMethodBeat.o(39515);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(39520);
    if ((paramString != null) && (!paramString.equals("")) && (this.WtK != null)) {
      this.WtK.remove(paramString);
    }
    for (;;)
    {
      super.onNotifyChange(paramString, paramMStorageEventData);
      AppMethodBeat.o(39520);
      return;
      if (this.WtK != null) {
        this.WtK.clear();
      }
    }
  }
  
  final class a
  {
    public CharSequence XAs;
    public CharSequence XAt;
    public int XAu;
    public CharSequence nickName;
    
    private a() {}
  }
  
  public static abstract interface b {}
  
  public static final class c
  {
    public ImageView WtU;
    public ImageView WtV;
    public ImageView iZG;
    public TextView iZH;
    public TextView snm;
    public TextView snn;
    public TextView sno;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.a
 * JD-Core Version:    0.7.0.1
 */