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
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ci;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a
  extends s<az>
{
  private ColorStateList[] Pav;
  private HashMap<String, a> Pax;
  private b QBc;
  private boolean QbL;
  protected List<String> gzY;
  private String kdi;
  private com.tencent.mm.ui.applet.b kex;
  private b.b kez;
  
  public a(Context paramContext, s.a parama)
  {
    super(paramContext, new az());
    AppMethodBeat.i(39514);
    this.gzY = null;
    this.Pav = new ColorStateList[2];
    this.QbL = true;
    this.kez = null;
    this.kex = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap Ta(String paramAnonymousString)
      {
        AppMethodBeat.i(39511);
        paramAnonymousString = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(39511);
        return paramAnonymousString;
      }
    });
    super.a(parama);
    this.Pav[0] = com.tencent.mm.cb.a.m(paramContext, 2131100812);
    this.Pav[1] = com.tencent.mm.cb.a.m(paramContext, 2131100813);
    this.Pax = new HashMap();
    AppMethodBeat.o(39514);
  }
  
  private static int ahn(String paramString)
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
    this.kdi = paramString;
    ebf();
    anp();
    AppMethodBeat.o(39521);
  }
  
  public final void anp()
  {
    AppMethodBeat.i(39517);
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = bg.aVF().iBo.a(ab.iCF, this.gzY, this.kdi);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((this.gzY != null) && (this.gzY.size() > 0)) {
      localArrayList1.addAll(this.gzY);
    }
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!ab.Eq(str)) {
          localArrayList2.add(str);
        }
        Log.d("MicroMsg.SearchConversationAdapter", "block user ".concat(String.valueOf(str)));
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SearchConversationAdapter", localException, "", new Object[0]);
      arrayOfCursor[1] = bg.aVF().iBp.a(this.kdi, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      setCursor(new MergeCursor(arrayOfCursor));
      if ((this.QBc != null) && (this.kdi != null)) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(39517);
    }
  }
  
  public final void anq()
  {
    AppMethodBeat.i(39516);
    anp();
    AppMethodBeat.o(39516);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39518);
    if (this.kez == null) {
      this.kez = new b.b()
      {
        public final int bnW()
        {
          AppMethodBeat.i(39513);
          int i = a.this.getCount();
          AppMethodBeat.o(39513);
          return i;
        }
        
        public final String vg(int paramAnonymousInt)
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
    if (this.kex != null) {
      this.kex.a(paramInt, this.kez);
    }
    az localaz = (az)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if ((ahn(localaz.field_msgType) == 34) && (localaz.field_isSend == 0) && (!Util.isNullOrNil(localaz.field_content)))
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
      if (new p(paramViewGroup).jsi) {}
    }
    for (int i = 1;; i = 0)
    {
      label467:
      int j;
      int k;
      if (paramView == null)
      {
        paramViewGroup = new c();
        localObject1 = View.inflate(this.context, 2131496180, null);
        paramViewGroup.gvv = ((ImageView)((View)localObject1).findViewById(2131297134));
        paramViewGroup.gvw = ((TextView)((View)localObject1).findViewById(2131305440));
        paramViewGroup.pld = ((TextView)((View)localObject1).findViewById(2131309606));
        paramViewGroup.ple = ((TextView)((View)localObject1).findViewById(2131303011));
        paramViewGroup.plf = ((TextView)((View)localObject1).findViewById(2131309165));
        paramViewGroup.plf.setBackgroundResource(com.tencent.mm.ui.tools.v.kH(this.context));
        paramViewGroup.PaH = ((ImageView)((View)localObject1).findViewById(2131302590));
        paramViewGroup.PaI = ((ImageView)((View)localObject1).findViewById(2131308917));
        ((View)localObject1).setTag(paramViewGroup);
        localObject2 = (a)this.Pax.get(localaz.field_username + localaz.field_content);
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          localObject2 = new a((byte)0);
          ((a)localObject2).nickName = com.tencent.mm.pluginsdk.ui.span.l.b(this.context, aa.getDisplayName(localaz.field_username), paramViewGroup.gvw.getTextSize());
          if (localaz.field_status != 1) {
            break label1091;
          }
          paramView = this.context.getString(2131762861);
          ((a)localObject2).Qcd = paramView;
          j = (int)paramViewGroup.ple.getTextSize();
          k = z.aUc();
          paramView = localaz.field_username;
          bg.aVF();
          if (Util.nullAsNil((Integer)com.tencent.mm.model.c.azQ().get(17, null)) != 1) {
            break label1127;
          }
          paramInt = 1;
          label519:
          if ((!paramView.equals("qqmail")) || (paramInt != 0)) {
            break label1132;
          }
          paramView = this.context.getString(2131765538);
          label544:
          ((a)localObject2).Qce = paramView;
          if ((ab.Eq(localaz.field_username)) && (com.tencent.mm.model.v.Ie(localaz.field_username) == 0)) {
            ((a)localObject2).nickName = this.context.getString(2131757507);
          }
        }
        switch (localaz.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label634:
          ((a)localObject2).Qcf = paramInt;
          this.Pax.put(localaz.field_username + localaz.field_content, localObject2);
          paramView = (View)localObject2;
          paramViewGroup.ple.setTextColor(this.Pav[i]);
          paramViewGroup.gvw.setText(paramView.nickName);
          paramViewGroup.pld.setText(paramView.Qcd);
          paramViewGroup.ple.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, paramView.Qce.toString(), paramViewGroup.ple.getTextSize()));
          if (localaz.field_conversationTime == 0L)
          {
            paramViewGroup.pld.setVisibility(8);
            label764:
            paramViewGroup.PaH.setVisibility(8);
            if (ab.Eq(localaz.field_username))
            {
              bg.aVF();
              paramView = com.tencent.mm.model.c.aSN().Kn(localaz.field_username);
              if ((paramView != null) && (paramView.fuH == 0)) {
                paramViewGroup.PaH.setVisibility(0);
              }
            }
            com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.gvv, localaz.field_username);
            if (this.QbL)
            {
              if (localaz.field_unReadCount <= 100) {
                break label1318;
              }
              paramViewGroup.plf.setText("...");
              paramViewGroup.plf.setVisibility(0);
            }
            label868:
            if (bg.aAc())
            {
              if (!ab.a(localaz))
              {
                bg.aVF();
                if (com.tencent.mm.model.c.aST().h(localaz))
                {
                  bg.aVF();
                  com.tencent.mm.model.c.aST().g(localaz);
                }
              }
              bg.aVF();
              if (com.tencent.mm.model.c.aST().h(localaz)) {
                break label1392;
              }
              ((View)localObject1).findViewById(2131299246).setBackgroundResource(2131231898);
            }
            label945:
            paramView = new xq();
            paramView.edR.edT = true;
            EventCenter.instance.publish(paramView);
            if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, 7, 0L)) && (!localaz.field_username.equals(paramView.edS.edV)))
            {
              localaz.yB(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, 6, localaz.field_conversationTime));
              bg.aVF();
              com.tencent.mm.model.c.aST().a(localaz, localaz.field_username);
            }
            if ((g.jpy != null) && (g.jpy.PW(localaz.field_username))) {
              break label1409;
            }
            paramViewGroup.PaI.setVisibility(8);
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
        paramView = f.c(this.context, localaz.field_conversationTime, true);
        break label467;
        label1127:
        paramInt = 0;
        break label519;
        label1132:
        bg.aVF();
        ci localci = com.tencent.mm.model.c.aSW().aEY("@t.qq.com");
        if ((localci != null) && (localci.isEnable())) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!paramView.equals("tmessage")) || (paramInt != 0)) {
            break label1197;
          }
          paramView = this.context.getString(2131765538);
          break;
        }
        label1197:
        if ((k & 0x40) != 0) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!paramView.equals("qmessage")) || (paramInt != 0)) {
            break label1240;
          }
          paramView = this.context.getString(2131765538);
          break;
        }
        label1240:
        paramView = com.tencent.mm.pluginsdk.ui.span.l.e(this.context, h.a(localaz.field_isSend, localaz.field_username, localaz.field_content, ahn(localaz.field_msgType), this.context), j);
        break label544;
        paramInt = -1;
        break label634;
        paramInt = 2131691165;
        break label634;
        paramInt = -1;
        break label634;
        paramInt = 2131691164;
        break label634;
        paramViewGroup.pld.setVisibility(0);
        break label764;
        label1318:
        if (localaz.field_unReadCount > 0)
        {
          paramViewGroup.plf.setText(localaz.field_unReadCount);
          paramViewGroup.plf.setBackgroundResource(com.tencent.mm.ui.tools.v.aQ(this.context, localaz.field_unReadCount));
          paramViewGroup.plf.setVisibility(0);
          break label868;
        }
        paramViewGroup.plf.setVisibility(4);
        break label868;
        label1392:
        ((View)localObject1).findViewById(2131299246).setBackgroundResource(2131231897);
        break label945;
        label1409:
        paramViewGroup.PaI.setVisibility(0);
        if (localaz.field_username.equals(paramView.edS.edV)) {
          paramViewGroup.PaI.setImageResource(2131691604);
        } else {
          paramViewGroup.PaI.setImageResource(2131691603);
        }
      }
    }
  }
  
  public final void jB(List<String> paramList)
  {
    AppMethodBeat.i(39515);
    this.gzY = paramList;
    onNotifyChange(null, null);
    AppMethodBeat.o(39515);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(39520);
    if ((paramString != null) && (!paramString.equals("")) && (this.Pax != null)) {
      this.Pax.remove(paramString);
    }
    for (;;)
    {
      super.onNotifyChange(paramString, paramMStorageEventData);
      AppMethodBeat.o(39520);
      return;
      if (this.Pax != null) {
        this.Pax.clear();
      }
    }
  }
  
  final class a
  {
    public CharSequence Qcd;
    public CharSequence Qce;
    public int Qcf;
    public CharSequence nickName;
    
    private a() {}
  }
  
  public static abstract interface b {}
  
  public static final class c
  {
    public ImageView PaH;
    public ImageView PaI;
    public ImageView gvv;
    public TextView gvw;
    public TextView pld;
    public TextView ple;
    public TextView plf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.a
 * JD-Core Version:    0.7.0.1
 */