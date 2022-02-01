package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.cb;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.u;
import java.util.HashMap;
import java.util.List;

public class SettingCheckUnProcessWalletConvUI
  extends MMActivity
{
  private List<String> KUb;
  private a KUc;
  private ListView jsM;
  private int[] tuX;
  
  public SettingCheckUnProcessWalletConvUI()
  {
    AppMethodBeat.i(38753);
    this.tuX = new int[2];
    AppMethodBeat.o(38753);
  }
  
  public int getLayoutId()
  {
    return 2131495376;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38754);
    super.onCreate(paramBundle);
    setMMTitle(2131765216);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(38737);
        SettingCheckUnProcessWalletConvUI.this.finish();
        AppMethodBeat.o(38737);
        return false;
      }
    });
    this.jsM = ((ListView)findViewById(2131298790));
    this.KUb = getIntent().getStringArrayListExtra("key_conversation_list");
    if ((this.KUb != null) && (this.KUb.size() > 0))
    {
      this.KUc = new a();
      this.jsM.setAdapter(this.KUc);
      this.jsM.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(38738);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(38738);
            return false;
            SettingCheckUnProcessWalletConvUI.this.hideVKB();
            SettingCheckUnProcessWalletConvUI.a(SettingCheckUnProcessWalletConvUI.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
            SettingCheckUnProcessWalletConvUI.a(SettingCheckUnProcessWalletConvUI.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.jsM.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38739);
          b localb = new b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          paramAnonymousAdapterView = SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.this).afp(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(38739);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
          paramAnonymousView.putExtra("chat_from_scene", 4);
          com.tencent.mm.br.d.f(SettingCheckUnProcessWalletConvUI.this, ".ui.chatting.ChattingUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38739);
        }
      });
      this.jsM.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38743);
          paramAnonymousAdapterView = SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.this).afp(paramAnonymousInt - SettingCheckUnProcessWalletConvUI.c(SettingCheckUnProcessWalletConvUI.this).getHeaderViewsCount());
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(38743);
            return true;
          }
          final String str = paramAnonymousAdapterView.field_username;
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(SettingCheckUnProcessWalletConvUI.this);
          locala.LwG = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(38740);
              paramAnonymous2ContextMenu.add(0, 1, 0, 2131761057);
              AppMethodBeat.o(38740);
            }
          };
          locala.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, SettingCheckUnProcessWalletConvUI.this, new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(38742);
              if (paramAnonymous2MenuItem.getItemId() == 1) {
                c.a(str, SettingCheckUnProcessWalletConvUI.this, paramAnonymousAdapterView, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(38741);
                    SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.this).remove(SettingCheckUnProcessWalletConvUI.4.2.this.ggQ);
                    SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.this).notifyDataSetChanged();
                    AppMethodBeat.o(38741);
                  }
                }, false, true);
              }
              AppMethodBeat.o(38742);
            }
          }, SettingCheckUnProcessWalletConvUI.a(SettingCheckUnProcessWalletConvUI.this)[0], SettingCheckUnProcessWalletConvUI.a(SettingCheckUnProcessWalletConvUI.this)[1]);
          AppMethodBeat.o(38743);
          return true;
        }
      });
    }
    AppMethodBeat.o(38754);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private float JPl;
    protected float JPo;
    private float JPp;
    private ColorStateList[] JPq;
    private HashMap<String, a> JPs;
    private final int KOU;
    private final int KOV;
    
    public a()
    {
      AppMethodBeat.i(38744);
      this.JPq = new ColorStateList[5];
      this.JPl = -1.0F;
      this.JPo = -1.0F;
      this.JPp = -1.0F;
      this.JPq[0] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100490);
      this.JPq[1] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100643);
      this.JPq[3] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100711);
      this.JPq[2] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100640);
      this.JPq[2] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100640);
      this.JPq[4] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100543);
      if (com.tencent.mm.cb.a.ir(SettingCheckUnProcessWalletConvUI.this)) {
        this.KOV = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165245);
      }
      for (this.KOU = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165247);; this.KOU = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165248))
      {
        this.JPl = com.tencent.mm.cb.a.ax(SettingCheckUnProcessWalletConvUI.this, 2131165517);
        this.JPo = com.tencent.mm.cb.a.ax(SettingCheckUnProcessWalletConvUI.this, 2131165466);
        this.JPp = com.tencent.mm.cb.a.ax(SettingCheckUnProcessWalletConvUI.this, 2131165576);
        this.JPs = new HashMap();
        AppMethodBeat.o(38744);
        return;
        this.KOV = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165244);
      }
    }
    
    private static int Xr(String paramString)
    {
      int j = 1;
      AppMethodBeat.i(38748);
      int i = j;
      if (paramString != null)
      {
        i = j;
        if (paramString.length() <= 0) {}
      }
      try
      {
        i = Integer.valueOf(paramString).intValue();
        AppMethodBeat.o(38748);
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
    
    private static String aXl(String paramString)
    {
      AppMethodBeat.i(38751);
      if ((paramString != null) && (paramString.length() == 32))
      {
        paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acm(paramString);
        AppMethodBeat.o(38751);
        return paramString;
      }
      AppMethodBeat.o(38751);
      return null;
    }
    
    private CharSequence c(au paramau, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(38750);
      if ((!bu.isNullOrNil(paramau.field_editingMsg)) && ((paramau.field_atCount <= 0) || (paramau.field_unReadCount <= 0)))
      {
        localObject1 = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(2131761048));
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        ((SpannableStringBuilder)localObject1).append(" ").append(k.b(SettingCheckUnProcessWalletConvUI.this, paramau.field_editingMsg, paramInt));
        AppMethodBeat.o(38750);
        return localObject1;
      }
      Object localObject1 = paramau.field_digest;
      if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
      {
        paramau = new SpannableString(k.e(SettingCheckUnProcessWalletConvUI.this, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38750);
        return paramau;
      }
      localObject1 = paramau.field_username;
      int i;
      if (((String)localObject1).equals("qqmail"))
      {
        bc.aCg();
        if (bu.o((Integer)com.tencent.mm.model.c.ajA().get(17, null)) == 1) {}
        for (i = 1; i == 0; i = 0)
        {
          paramau = SettingCheckUnProcessWalletConvUI.this.getString(2131763356);
          AppMethodBeat.o(38750);
          return paramau;
        }
      }
      if (((String)localObject1).equals("tmessage"))
      {
        bc.aCg();
        localObject1 = com.tencent.mm.model.c.azO().arD("@t.qq.com");
        if ((localObject1 != null) && (((cb)localObject1).isEnable())) {}
        for (i = 1; i == 0; i = 0)
        {
          paramau = SettingCheckUnProcessWalletConvUI.this.getString(2131763356);
          AppMethodBeat.o(38750);
          return paramau;
        }
      }
      String str1;
      if ((paramau.field_msgType != null) && ((paramau.field_msgType.equals("47")) || (paramau.field_msgType.equals("1048625"))))
      {
        localObject1 = aXl(paramau.field_digest);
        str1 = "";
        if (localObject1 != null)
        {
          paramau = "[" + (String)localObject1 + "]";
          AppMethodBeat.o(38750);
          return paramau;
        }
        localObject1 = str1;
        if (paramau.field_digest != null)
        {
          localObject1 = str1;
          if (paramau.field_digest.contains(":"))
          {
            str1 = paramau.field_digest.substring(0, paramau.field_digest.indexOf(":"));
            String str2 = aXl(paramau.field_digest.substring(paramau.field_digest.indexOf(":") + 1).replace(" ", ""));
            localObject1 = str1;
            if (str2 != null)
            {
              paramau = "[" + str2 + "]";
              if (bu.isNullOrNil(str1))
              {
                AppMethodBeat.o(38750);
                return paramau;
              }
              paramau = str1 + ": " + paramau;
              AppMethodBeat.o(38750);
              return paramau;
            }
          }
        }
        str1 = SettingCheckUnProcessWalletConvUI.this.getString(2131755722);
        if (bu.isNullOrNil((String)localObject1))
        {
          localObject1 = str1;
          paramau.tW((String)localObject1);
        }
      }
      else
      {
        if (bu.isNullOrNil(paramau.field_digest)) {
          break label775;
        }
        if (bu.isNullOrNil(paramau.field_digestUser)) {
          break label764;
        }
        if ((paramau.field_isSend != 0) || (!x.wb(paramau.field_username))) {
          break label752;
        }
        localObject1 = w.getDisplayName(paramau.field_digestUser, paramau.field_username);
      }
      label752:
      label764:
      Object localObject2;
      for (;;)
      {
        try
        {
          localObject1 = String.format(paramau.field_digest, new Object[] { localObject1 });
          str1 = ((String)localObject1).replace('\n', ' ');
          if ((paramau.field_atCount <= 0) || (paramau.field_unReadCount <= 0)) {
            break label806;
          }
          paramau = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(2131761044));
          paramau.setSpan(new ForegroundColorSpan(-5569532), 0, paramau.length(), 33);
          paramau.append(" ").append(k.b(SettingCheckUnProcessWalletConvUI.this, str1, paramInt));
          AppMethodBeat.o(38750);
          return paramau;
        }
        catch (Exception localException) {}
        localObject1 = (String)localObject1 + ": " + str1;
        break;
        localObject1 = w.zP(paramau.field_digestUser);
        continue;
        localObject1 = paramau.field_digest;
        continue;
        label775:
        localObject2 = h.a(paramau.field_isSend, paramau.field_username, paramau.field_content, Xr(paramau.field_msgType), SettingCheckUnProcessWalletConvUI.this);
      }
      label806:
      if ((paramBoolean) && (paramau.field_unReadCount > 1)) {
        localObject2 = SettingCheckUnProcessWalletConvUI.this.getString(2131761047, new Object[] { Integer.valueOf(paramau.field_unReadCount), str1 });
      }
      for (;;)
      {
        paramau = k.b(SettingCheckUnProcessWalletConvUI.this, (CharSequence)localObject2, paramInt);
        AppMethodBeat.o(38750);
        return paramau;
        localObject2 = str1;
        if (paramau.field_unReadCount > 1)
        {
          localObject2 = str1;
          if (x.AN(paramau.field_parentRef)) {
            localObject2 = SettingCheckUnProcessWalletConvUI.this.getString(2131761047, new Object[] { Integer.valueOf(paramau.field_unReadCount), str1 });
          }
        }
      }
    }
    
    private CharSequence i(au paramau)
    {
      AppMethodBeat.i(38749);
      if (paramau.field_status == 1)
      {
        paramau = SettingCheckUnProcessWalletConvUI.this.getString(2131761075);
        AppMethodBeat.o(38749);
        return paramau;
      }
      if (paramau.field_conversationTime == 9223372036854775807L)
      {
        AppMethodBeat.o(38749);
        return "";
      }
      paramau = i.c(SettingCheckUnProcessWalletConvUI.this, paramau.field_conversationTime, true);
      AppMethodBeat.o(38749);
      return paramau;
    }
    
    public final au afp(int paramInt)
    {
      AppMethodBeat.i(38746);
      Object localObject = (String)SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.this).get(paramInt);
      bc.aCg();
      localObject = com.tencent.mm.model.c.azL().aVa((String)localObject);
      AppMethodBeat.o(38746);
      return localObject;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(38745);
      int i = SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.this).size();
      AppMethodBeat.o(38745);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(38747);
      if (paramView == null)
      {
        paramViewGroup = new b((byte)0);
        if (com.tencent.mm.cb.a.ir(SettingCheckUnProcessWalletConvUI.this))
        {
          paramView = View.inflate(SettingCheckUnProcessWalletConvUI.this, 2131493663, null);
          paramViewGroup.fQl = ((ImageView)paramView.findViewById(2131297008));
          paramViewGroup.JPz = ((NoMeasuredTextView)paramView.findViewById(2131302867));
          paramViewGroup.KPq = ((NoMeasuredTextView)paramView.findViewById(2131305134));
          paramViewGroup.JPA = ((NoMeasuredTextView)paramView.findViewById(2131306207));
          paramViewGroup.JPB = ((NoMeasuredTextView)paramView.findViewById(2131301311));
          paramViewGroup.oaj = ((TextView)paramView.findViewById(2131305882));
          paramViewGroup.oaj.setBackgroundResource(u.kL(SettingCheckUnProcessWalletConvUI.this));
          paramViewGroup.JPC = ((ImageView)paramView.findViewById(2131300954));
          paramViewGroup.JPE = paramView.findViewById(2131297015);
          paramViewGroup.JPD = ((ImageView)paramView.findViewById(2131305672));
          paramViewGroup.KPr = ((ImageView)paramView.findViewById(2131301541));
          paramView.setTag(paramViewGroup);
          paramViewGroup.JPB.setTextSize(0, this.JPo);
          paramViewGroup.JPA.setTextSize(0, this.JPp);
          paramViewGroup.JPz.setTextSize(0, this.JPl);
          paramViewGroup.KPq.setTextSize(0, this.JPo);
          paramViewGroup.JPB.setTextColor(this.JPq[0]);
          paramViewGroup.JPA.setTextColor(this.JPq[4]);
          paramViewGroup.JPz.setTextColor(this.JPq[3]);
          paramViewGroup.KPq.setTextColor(this.JPq[0]);
          paramViewGroup.JPB.setShouldEllipsize(true);
          paramViewGroup.JPA.setShouldEllipsize(false);
          paramViewGroup.JPz.setShouldEllipsize(true);
          paramViewGroup.KPq.setShouldEllipsize(true);
          paramViewGroup.JPA.setGravity(5);
        }
      }
      au localau;
      for (;;)
      {
        localau = afp(paramInt);
        if (localau != null) {
          break label384;
        }
        AppMethodBeat.o(38747);
        return paramView;
        paramView = View.inflate(SettingCheckUnProcessWalletConvUI.this, 2131493662, null);
        break;
        paramViewGroup = (b)paramView.getTag();
      }
      label384:
      a.b.c(paramViewGroup.fQl, localau.field_username);
      paramViewGroup.fQl.getDrawable();
      String str2 = localau.field_username;
      Object localObject2 = (a)this.JPs.get(str2);
      Object localObject1 = localObject2;
      boolean bool;
      if (localObject2 == null)
      {
        localObject2 = new a((byte)0);
        ((a)localObject2).KPg = -1;
        ((a)localObject2).KPf = -1;
        ((a)localObject2).KPl = false;
        ((a)localObject2).KPn = false;
        ((a)localObject2).KPm = false;
        ((a)localObject2).rCw = x.wb(localau.field_username);
        if ((((a)localObject2).rCw) && (((a)localObject2).KPm) && (localau.field_unReadCount > 0))
        {
          bool = true;
          ((a)localObject2).KPk = bool;
          ((a)localObject2).oOD = 0;
          if ((Xr(localau.field_msgType) == 34) && (localau.field_isSend == 0) && (!bu.isNullOrNil(localau.field_content)))
          {
            String str1 = localau.field_content;
            if (!str2.equals("qmessage"))
            {
              localObject1 = str1;
              if (!str2.equals("floatbottle")) {}
            }
            else
            {
              String[] arrayOfString = str1.split(":");
              localObject1 = str1;
              if (arrayOfString != null)
              {
                localObject1 = str1;
                if (arrayOfString.length > 3) {
                  localObject1 = arrayOfString[1] + ":" + arrayOfString[2] + ":" + arrayOfString[3];
                }
              }
            }
            if (!new p((String)localObject1).iwT) {
              ((a)localObject2).oOD = 1;
            }
          }
          localObject1 = w.zP(str2);
          if ((!((a)localObject2).rCw) || (localObject1 != null)) {
            break label1237;
          }
          ((a)localObject2).nickName = SettingCheckUnProcessWalletConvUI.this.getString(2131757293);
          label724:
          ((a)localObject2).KPc = i(localau);
          ((a)localObject2).KPd = c(localau, (int)paramViewGroup.JPB.getTextSize(), ((a)localObject2).KPk);
          ((a)localObject2).KPo = localau.field_attrflag;
        }
      }
      else
      {
        switch (localau.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label814:
          ((a)localObject2).KPe = paramInt;
          ((a)localObject2).KPh = x.a(localau);
          bc.aCg();
          ((a)localObject2).JPw = com.tencent.mm.model.c.azL().h(localau);
          ((a)localObject2).KPi = false;
          ((a)localObject2).KPj = ad.foi();
          this.JPs.put(str2, localObject2);
          localObject1 = localObject2;
          if (((a)localObject1).KPc == null) {
            ((a)localObject1).KPc = i(localau);
          }
          if ((((a)localObject1).KPk) || (x.AN(localau.field_parentRef)))
          {
            paramViewGroup.JPB.setTextColor(this.JPq[0]);
            label930:
            if (!str2.toLowerCase().endsWith("@t.qq.com")) {
              break label1308;
            }
            paramViewGroup.JPz.setCompoundRightDrawablesWithIntrinsicBounds(2131232700);
            paramViewGroup.JPz.setDrawRightDrawable(true);
            label961:
            paramInt = ((a)localObject1).KPe;
            if (paramInt == -1) {
              break label1319;
            }
            paramViewGroup.JPB.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
            paramViewGroup.JPB.setDrawLeftDrawable(true);
            label988:
            paramViewGroup.JPz.setText(((a)localObject1).nickName);
            paramViewGroup.KPq.setVisibility(8);
            localObject2 = paramViewGroup.JPA.getLayoutParams();
            if (((a)localObject1).KPc.length() <= 9) {
              break label1330;
            }
            if (((ViewGroup.LayoutParams)localObject2).width != this.KOV)
            {
              ((ViewGroup.LayoutParams)localObject2).width = this.KOV;
              paramViewGroup.JPA.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
            label1063:
            ae.v("MicroMsg.SettingCheckUnProcessWalletConvUI", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
            paramViewGroup.JPA.setText(((a)localObject1).KPc);
            paramViewGroup.JPB.setText(((a)localObject1).KPd);
            if ((!((a)localObject1).rCw) || (!((a)localObject1).KPm)) {
              break label1363;
            }
            paramViewGroup.JPC.setVisibility(0);
            label1135:
            a.b.c(paramViewGroup.fQl, str2);
            if ((!((a)localObject1).KPh) && (((a)localObject1).JPw) && (bc.ajM()))
            {
              bc.aCg();
              com.tencent.mm.model.c.azL().g(localau);
            }
            if ((!((a)localObject1).JPw) || (localau.field_conversationTime == -1L)) {
              break label1394;
            }
            paramView.findViewById(2131298792).setBackgroundResource(2131231817);
          }
          break;
        }
      }
      for (;;)
      {
        paramViewGroup.JPD.setVisibility(8);
        AppMethodBeat.o(38747);
        return paramView;
        bool = false;
        break;
        label1237:
        ((a)localObject2).nickName = k.b(SettingCheckUnProcessWalletConvUI.this, w.zP(str2), paramViewGroup.JPz.getTextSize());
        break label724;
        paramInt = -1;
        break label814;
        paramInt = 2131690878;
        break label814;
        paramInt = -1;
        break label814;
        paramInt = 2131690877;
        break label814;
        paramViewGroup.JPB.setTextColor(this.JPq[localObject1.oOD]);
        break label930;
        label1308:
        paramViewGroup.JPz.setDrawRightDrawable(false);
        break label961;
        label1319:
        paramViewGroup.JPB.setDrawLeftDrawable(false);
        break label988;
        label1330:
        if (((ViewGroup.LayoutParams)localObject2).width == this.KOU) {
          break label1063;
        }
        ((ViewGroup.LayoutParams)localObject2).width = this.KOU;
        paramViewGroup.JPA.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break label1063;
        label1363:
        if (((a)localObject1).KPi)
        {
          paramViewGroup.JPC.setVisibility(0);
          break label1135;
        }
        paramViewGroup.JPC.setVisibility(8);
        break label1135;
        label1394:
        paramView.findViewById(2131298792).setBackgroundResource(2131231818);
      }
    }
    
    final class a
    {
      public boolean JPw;
      public CharSequence KPc;
      public CharSequence KPd;
      public int KPe;
      public int KPf;
      public int KPg;
      public boolean KPh;
      public boolean KPi;
      public boolean KPj;
      public boolean KPk;
      public boolean KPl;
      public boolean KPm;
      public boolean KPn;
      public int KPo;
      public CharSequence nickName;
      public int oOD;
      public boolean rCw;
      
      private a() {}
    }
    
    final class b
    {
      public NoMeasuredTextView JPA;
      public NoMeasuredTextView JPB;
      public ImageView JPC;
      public ImageView JPD;
      public View JPE;
      public NoMeasuredTextView JPz;
      public NoMeasuredTextView KPq;
      public ImageView KPr;
      public ImageView fQl;
      public TextView oaj;
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI
 * JD-Core Version:    0.7.0.1
 */