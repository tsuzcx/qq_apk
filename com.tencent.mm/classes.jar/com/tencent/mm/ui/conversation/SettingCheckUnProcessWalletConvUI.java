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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.u;
import java.util.HashMap;
import java.util.List;

public class SettingCheckUnProcessWalletConvUI
  extends MMActivity
{
  private List<String> KxH;
  private a KxI;
  private ListView jpT;
  private int[] tkf;
  
  public SettingCheckUnProcessWalletConvUI()
  {
    AppMethodBeat.i(38753);
    this.tkf = new int[2];
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
    this.jpT = ((ListView)findViewById(2131298790));
    this.KxH = getIntent().getStringArrayListExtra("key_conversation_list");
    if ((this.KxH != null) && (this.KxH.size() > 0))
    {
      this.KxI = new a();
      this.jpT.setAdapter(this.KxI);
      this.jpT.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(38738);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
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
      this.jpT.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38739);
          b localb = new b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          paramAnonymousAdapterView = SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.this).aeG(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(38739);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
          paramAnonymousView.putExtra("chat_from_scene", 4);
          com.tencent.mm.bs.d.f(SettingCheckUnProcessWalletConvUI.this, ".ui.chatting.ChattingUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38739);
        }
      });
      this.jpT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38743);
          paramAnonymousAdapterView = SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.this).aeG(paramAnonymousInt - SettingCheckUnProcessWalletConvUI.c(SettingCheckUnProcessWalletConvUI.this).getHeaderViewsCount());
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(38743);
            return true;
          }
          final String str = paramAnonymousAdapterView.field_username;
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(SettingCheckUnProcessWalletConvUI.this);
          locala.Lai = new View.OnCreateContextMenuListener()
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
                    SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.this).remove(SettingCheckUnProcessWalletConvUI.4.2.this.geH);
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
    private float JuA;
    private ColorStateList[] JuB;
    private HashMap<String, a> JuD;
    private float Juw;
    protected float Juz;
    private final int KsA;
    private final int KsB;
    
    public a()
    {
      AppMethodBeat.i(38744);
      this.JuB = new ColorStateList[5];
      this.Juw = -1.0F;
      this.Juz = -1.0F;
      this.JuA = -1.0F;
      this.JuB[0] = com.tencent.mm.cc.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100490);
      this.JuB[1] = com.tencent.mm.cc.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100643);
      this.JuB[3] = com.tencent.mm.cc.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100711);
      this.JuB[2] = com.tencent.mm.cc.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100640);
      this.JuB[2] = com.tencent.mm.cc.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100640);
      this.JuB[4] = com.tencent.mm.cc.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100543);
      if (com.tencent.mm.cc.a.im(SettingCheckUnProcessWalletConvUI.this)) {
        this.KsB = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165245);
      }
      for (this.KsA = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165247);; this.KsA = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165248))
      {
        this.Juw = com.tencent.mm.cc.a.ax(SettingCheckUnProcessWalletConvUI.this, 2131165517);
        this.Juz = com.tencent.mm.cc.a.ax(SettingCheckUnProcessWalletConvUI.this, 2131165466);
        this.JuA = com.tencent.mm.cc.a.ax(SettingCheckUnProcessWalletConvUI.this, 2131165576);
        this.JuD = new HashMap();
        AppMethodBeat.o(38744);
        return;
        this.KsB = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165244);
      }
    }
    
    private static int WF(String paramString)
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
    
    private static String aVK(String paramString)
    {
      AppMethodBeat.i(38751);
      if ((paramString != null) && (paramString.length() == 32))
      {
        paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abv(paramString);
        AppMethodBeat.o(38751);
        return paramString;
      }
      AppMethodBeat.o(38751);
      return null;
    }
    
    private CharSequence c(at paramat, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(38750);
      if ((!bt.isNullOrNil(paramat.field_editingMsg)) && ((paramat.field_atCount <= 0) || (paramat.field_unReadCount <= 0)))
      {
        localObject1 = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(2131761048));
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        ((SpannableStringBuilder)localObject1).append(" ").append(k.b(SettingCheckUnProcessWalletConvUI.this, paramat.field_editingMsg, paramInt));
        AppMethodBeat.o(38750);
        return localObject1;
      }
      Object localObject1 = paramat.field_digest;
      if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
      {
        paramat = new SpannableString(k.e(SettingCheckUnProcessWalletConvUI.this, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38750);
        return paramat;
      }
      localObject1 = paramat.field_username;
      int i;
      if (((String)localObject1).equals("qqmail"))
      {
        com.tencent.mm.model.ba.aBQ();
        if (bt.n((Integer)com.tencent.mm.model.c.ajl().get(17, null)) == 1) {}
        for (i = 1; i == 0; i = 0)
        {
          paramat = SettingCheckUnProcessWalletConvUI.this.getString(2131763356);
          AppMethodBeat.o(38750);
          return paramat;
        }
      }
      if (((String)localObject1).equals("tmessage"))
      {
        com.tencent.mm.model.ba.aBQ();
        localObject1 = com.tencent.mm.model.c.azy().aqy("@t.qq.com");
        if ((localObject1 != null) && (((ca)localObject1).isEnable())) {}
        for (i = 1; i == 0; i = 0)
        {
          paramat = SettingCheckUnProcessWalletConvUI.this.getString(2131763356);
          AppMethodBeat.o(38750);
          return paramat;
        }
      }
      String str1;
      if ((paramat.field_msgType != null) && ((paramat.field_msgType.equals("47")) || (paramat.field_msgType.equals("1048625"))))
      {
        localObject1 = aVK(paramat.field_digest);
        str1 = "";
        if (localObject1 != null)
        {
          paramat = "[" + (String)localObject1 + "]";
          AppMethodBeat.o(38750);
          return paramat;
        }
        localObject1 = str1;
        if (paramat.field_digest != null)
        {
          localObject1 = str1;
          if (paramat.field_digest.contains(":"))
          {
            str1 = paramat.field_digest.substring(0, paramat.field_digest.indexOf(":"));
            String str2 = aVK(paramat.field_digest.substring(paramat.field_digest.indexOf(":") + 1).replace(" ", ""));
            localObject1 = str1;
            if (str2 != null)
            {
              paramat = "[" + str2 + "]";
              if (bt.isNullOrNil(str1))
              {
                AppMethodBeat.o(38750);
                return paramat;
              }
              paramat = str1 + ": " + paramat;
              AppMethodBeat.o(38750);
              return paramat;
            }
          }
        }
        str1 = SettingCheckUnProcessWalletConvUI.this.getString(2131755722);
        if (bt.isNullOrNil((String)localObject1))
        {
          localObject1 = str1;
          paramat.tB((String)localObject1);
        }
      }
      else
      {
        if (bt.isNullOrNil(paramat.field_digest)) {
          break label775;
        }
        if (bt.isNullOrNil(paramat.field_digestUser)) {
          break label764;
        }
        if ((paramat.field_isSend != 0) || (!w.vF(paramat.field_username))) {
          break label752;
        }
        localObject1 = v.getDisplayName(paramat.field_digestUser, paramat.field_username);
      }
      label752:
      label764:
      Object localObject2;
      for (;;)
      {
        try
        {
          localObject1 = String.format(paramat.field_digest, new Object[] { localObject1 });
          str1 = ((String)localObject1).replace('\n', ' ');
          if ((paramat.field_atCount <= 0) || (paramat.field_unReadCount <= 0)) {
            break label806;
          }
          paramat = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(2131761044));
          paramat.setSpan(new ForegroundColorSpan(-5569532), 0, paramat.length(), 33);
          paramat.append(" ").append(k.b(SettingCheckUnProcessWalletConvUI.this, str1, paramInt));
          AppMethodBeat.o(38750);
          return paramat;
        }
        catch (Exception localException) {}
        localObject1 = (String)localObject1 + ": " + str1;
        break;
        localObject1 = v.zf(paramat.field_digestUser);
        continue;
        localObject1 = paramat.field_digest;
        continue;
        label775:
        localObject2 = h.a(paramat.field_isSend, paramat.field_username, paramat.field_content, WF(paramat.field_msgType), SettingCheckUnProcessWalletConvUI.this);
      }
      label806:
      if ((paramBoolean) && (paramat.field_unReadCount > 1)) {
        localObject2 = SettingCheckUnProcessWalletConvUI.this.getString(2131761047, new Object[] { Integer.valueOf(paramat.field_unReadCount), str1 });
      }
      for (;;)
      {
        paramat = k.b(SettingCheckUnProcessWalletConvUI.this, (CharSequence)localObject2, paramInt);
        AppMethodBeat.o(38750);
        return paramat;
        localObject2 = str1;
        if (paramat.field_unReadCount > 1)
        {
          localObject2 = str1;
          if (w.Ad(paramat.field_parentRef)) {
            localObject2 = SettingCheckUnProcessWalletConvUI.this.getString(2131761047, new Object[] { Integer.valueOf(paramat.field_unReadCount), str1 });
          }
        }
      }
    }
    
    private CharSequence i(at paramat)
    {
      AppMethodBeat.i(38749);
      if (paramat.field_status == 1)
      {
        paramat = SettingCheckUnProcessWalletConvUI.this.getString(2131761075);
        AppMethodBeat.o(38749);
        return paramat;
      }
      if (paramat.field_conversationTime == 9223372036854775807L)
      {
        AppMethodBeat.o(38749);
        return "";
      }
      paramat = i.c(SettingCheckUnProcessWalletConvUI.this, paramat.field_conversationTime, true);
      AppMethodBeat.o(38749);
      return paramat;
    }
    
    public final at aeG(int paramInt)
    {
      AppMethodBeat.i(38746);
      Object localObject = (String)SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.this).get(paramInt);
      com.tencent.mm.model.ba.aBQ();
      localObject = com.tencent.mm.model.c.azv().aTz((String)localObject);
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
        if (com.tencent.mm.cc.a.im(SettingCheckUnProcessWalletConvUI.this))
        {
          paramView = View.inflate(SettingCheckUnProcessWalletConvUI.this, 2131493663, null);
          paramViewGroup.fOf = ((ImageView)paramView.findViewById(2131297008));
          paramViewGroup.JuK = ((NoMeasuredTextView)paramView.findViewById(2131302867));
          paramViewGroup.KsW = ((NoMeasuredTextView)paramView.findViewById(2131305134));
          paramViewGroup.JuL = ((NoMeasuredTextView)paramView.findViewById(2131306207));
          paramViewGroup.JuM = ((NoMeasuredTextView)paramView.findViewById(2131301311));
          paramViewGroup.nUD = ((TextView)paramView.findViewById(2131305882));
          paramViewGroup.nUD.setBackgroundResource(u.kE(SettingCheckUnProcessWalletConvUI.this));
          paramViewGroup.JuN = ((ImageView)paramView.findViewById(2131300954));
          paramViewGroup.JuP = paramView.findViewById(2131297015);
          paramViewGroup.JuO = ((ImageView)paramView.findViewById(2131305672));
          paramViewGroup.KsX = ((ImageView)paramView.findViewById(2131301541));
          paramView.setTag(paramViewGroup);
          paramViewGroup.JuM.setTextSize(0, this.Juz);
          paramViewGroup.JuL.setTextSize(0, this.JuA);
          paramViewGroup.JuK.setTextSize(0, this.Juw);
          paramViewGroup.KsW.setTextSize(0, this.Juz);
          paramViewGroup.JuM.setTextColor(this.JuB[0]);
          paramViewGroup.JuL.setTextColor(this.JuB[4]);
          paramViewGroup.JuK.setTextColor(this.JuB[3]);
          paramViewGroup.KsW.setTextColor(this.JuB[0]);
          paramViewGroup.JuM.setShouldEllipsize(true);
          paramViewGroup.JuL.setShouldEllipsize(false);
          paramViewGroup.JuK.setShouldEllipsize(true);
          paramViewGroup.KsW.setShouldEllipsize(true);
          paramViewGroup.JuL.setGravity(5);
        }
      }
      at localat;
      for (;;)
      {
        localat = aeG(paramInt);
        if (localat != null) {
          break label384;
        }
        AppMethodBeat.o(38747);
        return paramView;
        paramView = View.inflate(SettingCheckUnProcessWalletConvUI.this, 2131493662, null);
        break;
        paramViewGroup = (b)paramView.getTag();
      }
      label384:
      a.b.c(paramViewGroup.fOf, localat.field_username);
      paramViewGroup.fOf.getDrawable();
      String str2 = localat.field_username;
      Object localObject2 = (a)this.JuD.get(str2);
      Object localObject1 = localObject2;
      boolean bool;
      if (localObject2 == null)
      {
        localObject2 = new a((byte)0);
        ((a)localObject2).KsM = -1;
        ((a)localObject2).KsL = -1;
        ((a)localObject2).KsR = false;
        ((a)localObject2).KsT = false;
        ((a)localObject2).KsS = false;
        ((a)localObject2).ruk = w.vF(localat.field_username);
        if ((((a)localObject2).ruk) && (((a)localObject2).KsS) && (localat.field_unReadCount > 0))
        {
          bool = true;
          ((a)localObject2).KsQ = bool;
          ((a)localObject2).oIb = 0;
          if ((WF(localat.field_msgType) == 34) && (localat.field_isSend == 0) && (!bt.isNullOrNil(localat.field_content)))
          {
            String str1 = localat.field_content;
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
            if (!new p((String)localObject1).itZ) {
              ((a)localObject2).oIb = 1;
            }
          }
          localObject1 = v.zf(str2);
          if ((!((a)localObject2).ruk) || (localObject1 != null)) {
            break label1237;
          }
          ((a)localObject2).nickName = SettingCheckUnProcessWalletConvUI.this.getString(2131757293);
          label724:
          ((a)localObject2).KsI = i(localat);
          ((a)localObject2).KsJ = c(localat, (int)paramViewGroup.JuM.getTextSize(), ((a)localObject2).KsQ);
          ((a)localObject2).KsU = localat.field_attrflag;
        }
      }
      else
      {
        switch (localat.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label814:
          ((a)localObject2).KsK = paramInt;
          ((a)localObject2).KsN = w.a(localat);
          com.tencent.mm.model.ba.aBQ();
          ((a)localObject2).JuH = com.tencent.mm.model.c.azv().h(localat);
          ((a)localObject2).KsO = false;
          ((a)localObject2).KsP = ac.fko();
          this.JuD.put(str2, localObject2);
          localObject1 = localObject2;
          if (((a)localObject1).KsI == null) {
            ((a)localObject1).KsI = i(localat);
          }
          if ((((a)localObject1).KsQ) || (w.Ad(localat.field_parentRef)))
          {
            paramViewGroup.JuM.setTextColor(this.JuB[0]);
            label930:
            if (!str2.toLowerCase().endsWith("@t.qq.com")) {
              break label1308;
            }
            paramViewGroup.JuK.setCompoundRightDrawablesWithIntrinsicBounds(2131232700);
            paramViewGroup.JuK.setDrawRightDrawable(true);
            label961:
            paramInt = ((a)localObject1).KsK;
            if (paramInt == -1) {
              break label1319;
            }
            paramViewGroup.JuM.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
            paramViewGroup.JuM.setDrawLeftDrawable(true);
            label988:
            paramViewGroup.JuK.setText(((a)localObject1).nickName);
            paramViewGroup.KsW.setVisibility(8);
            localObject2 = paramViewGroup.JuL.getLayoutParams();
            if (((a)localObject1).KsI.length() <= 9) {
              break label1330;
            }
            if (((ViewGroup.LayoutParams)localObject2).width != this.KsB)
            {
              ((ViewGroup.LayoutParams)localObject2).width = this.KsB;
              paramViewGroup.JuL.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
            label1063:
            ad.v("MicroMsg.SettingCheckUnProcessWalletConvUI", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
            paramViewGroup.JuL.setText(((a)localObject1).KsI);
            paramViewGroup.JuM.setText(((a)localObject1).KsJ);
            if ((!((a)localObject1).ruk) || (!((a)localObject1).KsS)) {
              break label1363;
            }
            paramViewGroup.JuN.setVisibility(0);
            label1135:
            a.b.c(paramViewGroup.fOf, str2);
            if ((!((a)localObject1).KsN) && (((a)localObject1).JuH) && (com.tencent.mm.model.ba.ajx()))
            {
              com.tencent.mm.model.ba.aBQ();
              com.tencent.mm.model.c.azv().g(localat);
            }
            if ((!((a)localObject1).JuH) || (localat.field_conversationTime == -1L)) {
              break label1394;
            }
            paramView.findViewById(2131298792).setBackgroundResource(2131231817);
          }
          break;
        }
      }
      for (;;)
      {
        paramViewGroup.JuO.setVisibility(8);
        AppMethodBeat.o(38747);
        return paramView;
        bool = false;
        break;
        label1237:
        ((a)localObject2).nickName = k.b(SettingCheckUnProcessWalletConvUI.this, v.zf(str2), paramViewGroup.JuK.getTextSize());
        break label724;
        paramInt = -1;
        break label814;
        paramInt = 2131690878;
        break label814;
        paramInt = -1;
        break label814;
        paramInt = 2131690877;
        break label814;
        paramViewGroup.JuM.setTextColor(this.JuB[localObject1.oIb]);
        break label930;
        label1308:
        paramViewGroup.JuK.setDrawRightDrawable(false);
        break label961;
        label1319:
        paramViewGroup.JuM.setDrawLeftDrawable(false);
        break label988;
        label1330:
        if (((ViewGroup.LayoutParams)localObject2).width == this.KsA) {
          break label1063;
        }
        ((ViewGroup.LayoutParams)localObject2).width = this.KsA;
        paramViewGroup.JuL.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break label1063;
        label1363:
        if (((a)localObject1).KsO)
        {
          paramViewGroup.JuN.setVisibility(0);
          break label1135;
        }
        paramViewGroup.JuN.setVisibility(8);
        break label1135;
        label1394:
        paramView.findViewById(2131298792).setBackgroundResource(2131231818);
      }
    }
    
    final class a
    {
      public boolean JuH;
      public CharSequence KsI;
      public CharSequence KsJ;
      public int KsK;
      public int KsL;
      public int KsM;
      public boolean KsN;
      public boolean KsO;
      public boolean KsP;
      public boolean KsQ;
      public boolean KsR;
      public boolean KsS;
      public boolean KsT;
      public int KsU;
      public CharSequence nickName;
      public int oIb;
      public boolean ruk;
      
      private a() {}
    }
    
    final class b
    {
      public NoMeasuredTextView JuK;
      public NoMeasuredTextView JuL;
      public NoMeasuredTextView JuM;
      public ImageView JuN;
      public ImageView JuO;
      public View JuP;
      public NoMeasuredTextView KsW;
      public ImageView KsX;
      public ImageView fOf;
      public TextView nUD;
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI
 * JD-Core Version:    0.7.0.1
 */