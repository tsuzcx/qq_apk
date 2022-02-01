package com.tencent.mm.ui.voicesearch;

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
import com.tencent.mm.autogen.a.aaq;
import com.tencent.mm.autogen.a.aaq.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.bc.g;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a
  extends x<bb>
{
  private ColorStateList[] aebb;
  private HashMap<String, a> aebd;
  private b afRx;
  private boolean afmI;
  protected List<String> lMF;
  private String pRp;
  private com.tencent.mm.ui.applet.b pSE;
  private b.b pSF;
  
  public a(Context paramContext, x.a parama)
  {
    super(paramContext, new bb());
    AppMethodBeat.i(39514);
    this.lMF = null;
    this.aebb = new ColorStateList[2];
    this.afmI = true;
    this.pSF = null;
    this.pSE = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap getHeadImg(String paramAnonymousString)
      {
        AppMethodBeat.i(39511);
        paramAnonymousString = d.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(39511);
        return paramAnonymousString;
      }
    });
    super.a(parama);
    this.aebb[0] = com.tencent.mm.cd.a.l(paramContext, R.e.mm_list_textcolor_two);
    this.aebb[1] = com.tencent.mm.cd.a.l(paramContext, R.e.mm_list_textcolor_unread);
    this.aebd = new HashMap();
    AppMethodBeat.o(39514);
  }
  
  private static int aip(String paramString)
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
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(39521);
    this.pRp = paramString;
    fSd();
    aNy();
    AppMethodBeat.o(39521);
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(39517);
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = bh.bCz().oit.a(ab.ojZ, this.lMF, this.pRp);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((this.lMF != null) && (this.lMF.size() > 0)) {
      localArrayList1.addAll(this.lMF);
    }
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!au.bwE(str)) {
          localArrayList2.add(str);
        }
        Log.d("MicroMsg.SearchConversationAdapter", "block user ".concat(String.valueOf(str)));
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SearchConversationAdapter", localException, "", new Object[0]);
      arrayOfCursor[1] = bh.bCz().oiu.a(this.pRp, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      w(new MergeCursor(arrayOfCursor));
      if ((this.afRx != null) && (this.pRp != null)) {
        Fv().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(39517);
    }
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(39516);
    aNy();
    AppMethodBeat.o(39516);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39518);
    if (this.pSF == null) {
      this.pSF = new b.b()
      {
        public final int bWT()
        {
          AppMethodBeat.i(39513);
          int i = a.this.getCount();
          AppMethodBeat.o(39513);
          return i;
        }
        
        public final String yq(int paramAnonymousInt)
        {
          AppMethodBeat.i(39512);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= a.this.getCount()))
          {
            Log.e("MicroMsg.SearchConversationAdapter", "pos is invalid");
            AppMethodBeat.o(39512);
            return null;
          }
          Object localObject = (bb)a.this.getItem(paramAnonymousInt);
          if (localObject == null)
          {
            AppMethodBeat.o(39512);
            return null;
          }
          localObject = ((bd)localObject).field_username;
          AppMethodBeat.o(39512);
          return localObject;
        }
      };
    }
    if (this.pSE != null) {
      this.pSE.a(paramInt, this.pSF);
    }
    bb localbb = (bb)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if ((aip(localbb.field_msgType) == 34) && (localbb.field_isSend == 0) && (!Util.isNullOrNil(localbb.field_content)))
    {
      localObject1 = localbb.field_content;
      if (!localbb.field_username.equals("qmessage"))
      {
        paramViewGroup = (ViewGroup)localObject1;
        if (!localbb.field_username.equals("floatbottle")) {}
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
      if (new com.tencent.mm.modelvoice.p(paramViewGroup).paW) {}
    }
    for (int i = 1;; i = 0)
    {
      label467:
      int j;
      int k;
      if (paramView == null)
      {
        paramViewGroup = new c();
        localObject1 = View.inflate(this.context, R.i.gnL, null);
        paramViewGroup.lBC = ((ImageView)((View)localObject1).findViewById(R.h.avatar_iv));
        paramViewGroup.lBD = ((TextView)((View)localObject1).findViewById(R.h.nickname_tv));
        paramViewGroup.vzk = ((TextView)((View)localObject1).findViewById(R.h.update_time_tv));
        paramViewGroup.vzl = ((TextView)((View)localObject1).findViewById(R.h.last_msg_tv));
        paramViewGroup.vzm = ((TextView)((View)localObject1).findViewById(R.h.tipcnt_tv));
        paramViewGroup.vzm.setBackgroundResource(com.tencent.mm.ui.tools.v.nH(this.context));
        paramViewGroup.aebm = ((ImageView)((View)localObject1).findViewById(R.h.fKm));
        paramViewGroup.aebn = ((ImageView)((View)localObject1).findViewById(R.h.fYY));
        ((View)localObject1).setTag(paramViewGroup);
        localObject2 = (a)this.aebd.get(localbb.field_username + localbb.field_content);
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          localObject2 = new a((byte)0);
          ((a)localObject2).nickName = com.tencent.mm.pluginsdk.ui.span.p.b(this.context, aa.getDisplayName(localbb.field_username), paramViewGroup.lBD.getTextSize());
          if (localbb.field_status != 1) {
            break label1088;
          }
          paramView = this.context.getString(R.l.gNp);
          ((a)localObject2).afna = paramView;
          j = (int)paramViewGroup.vzl.getTextSize();
          k = z.bAQ();
          paramView = localbb.field_username;
          bh.bCz();
          if (Util.nullAsNil((Integer)c.ban().d(17, null)) != 1) {
            break label1124;
          }
          paramInt = 1;
          label519:
          if ((!paramView.equals("qqmail")) || (paramInt != 0)) {
            break label1129;
          }
          paramView = this.context.getString(R.l.settings_plugins_disable);
          label544:
          ((a)localObject2).afnb = paramView;
          if ((au.bwE(localbb.field_username)) && (com.tencent.mm.model.v.getMembersCountByChatRoomName(localbb.field_username) == 0)) {
            ((a)localObject2).nickName = this.context.getString(R.l.gzv);
          }
        }
        switch (localbb.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label634:
          ((a)localObject2).afnc = paramInt;
          this.aebd.put(localbb.field_username + localbb.field_content, localObject2);
          paramView = (View)localObject2;
          paramViewGroup.vzl.setTextColor(this.aebb[i]);
          paramViewGroup.lBD.setText(paramView.nickName);
          paramViewGroup.vzk.setText(paramView.afna);
          paramViewGroup.vzl.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.context, paramView.afnb.toString(), paramViewGroup.vzl.getTextSize()));
          if (localbb.field_conversationTime == 0L)
          {
            paramViewGroup.vzk.setVisibility(8);
            label764:
            paramViewGroup.aebm.setVisibility(8);
            if (au.bwE(localbb.field_username))
            {
              bh.bCz();
              paramView = c.bzA().JE(localbb.field_username);
              if ((paramView != null) && (paramView.kaf == 0)) {
                paramViewGroup.aebm.setVisibility(0);
              }
            }
            com.tencent.mm.pluginsdk.ui.a.b.g(paramViewGroup.lBC, localbb.field_username);
            if (this.afmI)
            {
              if (localbb.field_unReadCount <= 100) {
                break label1315;
              }
              paramViewGroup.vzm.setText("...");
              paramViewGroup.vzm.setVisibility(0);
            }
            label868:
            if (bh.baz())
            {
              if (!ab.a(localbb))
              {
                bh.bCz();
                if (c.bzG().k(localbb))
                {
                  bh.bCz();
                  c.bzG().j(localbb);
                }
              }
              bh.bCz();
              if (c.bzG().k(localbb)) {
                break label1389;
              }
              ((View)localObject1).findViewById(R.h.fDC).setBackgroundResource(R.g.comm_list_item_selector);
            }
            label945:
            paramView = new aaq();
            paramView.ieg.iei = true;
            paramView.publish();
            if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localbb, 7, 0L)) && (!localbb.field_username.equals(paramView.ieh.iek)))
            {
              localbb.gS(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localbb, 6, localbb.field_conversationTime));
              bh.bCz();
              c.bzG().c(localbb, localbb.field_username);
            }
            if ((g.oXL != null) && (g.oXL.Pv(localbb.field_username))) {
              break label1406;
            }
            paramViewGroup.aebn.setVisibility(8);
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
        label1088:
        if (localbb.field_conversationTime == 9223372036854775807L)
        {
          paramView = "";
          break label467;
        }
        paramView = f.d(this.context, localbb.field_conversationTime, true);
        break label467;
        label1124:
        paramInt = 0;
        break label519;
        label1129:
        bh.bCz();
        cm localcm = c.bzJ().aMh("@t.qq.com");
        if ((localcm != null) && (localcm.isEnable())) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!paramView.equals("tmessage")) || (paramInt != 0)) {
            break label1194;
          }
          paramView = this.context.getString(R.l.settings_plugins_disable);
          break;
        }
        label1194:
        if ((k & 0x40) != 0) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!paramView.equals("qmessage")) || (paramInt != 0)) {
            break label1237;
          }
          paramView = this.context.getString(R.l.settings_plugins_disable);
          break;
        }
        label1237:
        paramView = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, h.a(localbb.field_isSend, localbb.field_username, localbb.field_content, aip(localbb.field_msgType), this.context), j);
        break label544;
        paramInt = -1;
        break label634;
        paramInt = R.k.msg_state_sending;
        break label634;
        paramInt = -1;
        break label634;
        paramInt = R.k.msg_state_failed;
        break label634;
        paramViewGroup.vzk.setVisibility(0);
        break label764;
        label1315:
        if (localbb.field_unReadCount > 0)
        {
          paramViewGroup.vzm.setText(localbb.field_unReadCount);
          paramViewGroup.vzm.setBackgroundResource(com.tencent.mm.ui.tools.v.bC(this.context, localbb.field_unReadCount));
          paramViewGroup.vzm.setVisibility(0);
          break label868;
        }
        paramViewGroup.vzm.setVisibility(4);
        break label868;
        label1389:
        ((View)localObject1).findViewById(R.h.fDC).setBackgroundResource(R.g.comm_item_highlight_selector);
        break label945;
        label1406:
        paramViewGroup.aebn.setVisibility(0);
        if (localbb.field_username.equals(paramView.ieh.iek)) {
          paramViewGroup.aebn.setImageResource(R.k.talk_room_mic_speaking);
        } else {
          paramViewGroup.aebn.setImageResource(R.k.talk_room_mic_idle);
        }
      }
    }
  }
  
  public final void nM(List<String> paramList)
  {
    AppMethodBeat.i(39515);
    this.lMF = paramList;
    onNotifyChange(null, null);
    AppMethodBeat.o(39515);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(39520);
    if ((paramString != null) && (!paramString.equals("")) && (this.aebd != null)) {
      this.aebd.remove(paramString);
    }
    for (;;)
    {
      super.onNotifyChange(paramString, paramMStorageEventData);
      AppMethodBeat.o(39520);
      return;
      if (this.aebd != null) {
        this.aebd.clear();
      }
    }
  }
  
  final class a
  {
    public CharSequence afna;
    public CharSequence afnb;
    public int afnc;
    public CharSequence nickName;
    
    private a() {}
  }
  
  public static abstract interface b {}
  
  public static final class c
  {
    public ImageView aebm;
    public ImageView aebn;
    public ImageView lBC;
    public TextView lBD;
    public TextView vzk;
    public TextView vzl;
    public TextView vzm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.a
 * JD-Core Version:    0.7.0.1
 */