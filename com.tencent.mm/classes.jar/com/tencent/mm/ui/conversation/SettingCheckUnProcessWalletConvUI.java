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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.tools.w;
import java.util.HashMap;
import java.util.List;

public class SettingCheckUnProcessWalletConvUI
  extends MMActivity
{
  private List<String> XEB;
  private a XEC;
  private ListView niO;
  private int[] xYT;
  
  public SettingCheckUnProcessWalletConvUI()
  {
    AppMethodBeat.i(38753);
    this.xYT = new int[2];
    AppMethodBeat.o(38753);
  }
  
  public int getLayoutId()
  {
    return R.i.ekP;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38754);
    super.onCreate(paramBundle);
    setMMTitle(R.l.eVy);
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
    this.niO = ((ListView)findViewById(R.h.dCK));
    this.XEB = getIntent().getStringArrayListExtra("key_conversation_list");
    if ((this.XEB != null) && (this.XEB.size() > 0))
    {
      this.XEC = new a();
      this.niO.setAdapter(this.XEC);
      this.niO.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(38738);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(38738);
            return false;
            SettingCheckUnProcessWalletConvUI.this.hideVKB();
            SettingCheckUnProcessWalletConvUI.a(SettingCheckUnProcessWalletConvUI.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
            SettingCheckUnProcessWalletConvUI.a(SettingCheckUnProcessWalletConvUI.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.niO.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38739);
          b localb = new b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          paramAnonymousAdapterView = SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.this).axe(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(38739);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
          paramAnonymousView.putExtra("chat_from_scene", 4);
          com.tencent.mm.by.c.f(SettingCheckUnProcessWalletConvUI.this, ".ui.chatting.ChattingUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38739);
        }
      });
      this.niO.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38743);
          paramAnonymousAdapterView = SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.this).axe(paramAnonymousInt - SettingCheckUnProcessWalletConvUI.c(SettingCheckUnProcessWalletConvUI.this).getHeaderViewsCount());
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(38743);
            return true;
          }
          final String str = paramAnonymousAdapterView.field_username;
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(SettingCheckUnProcessWalletConvUI.this);
          locala.Yrf = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(38740);
              paramAnonymous2ContextMenu.add(0, 1, 0, R.l.main_delete);
              AppMethodBeat.o(38740);
            }
          };
          locala.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, SettingCheckUnProcessWalletConvUI.this, new q.g()
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
                    SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.this).remove(SettingCheckUnProcessWalletConvUI.4.2.this.jwL);
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
    private float WtD;
    protected float WtG;
    private float WtH;
    private ColorStateList[] WtI;
    private HashMap<String, a> WtK;
    private final int XAk;
    private final int XAl;
    
    public a()
    {
      AppMethodBeat.i(38744);
      this.WtI = new ColorStateList[5];
      this.WtD = -1.0F;
      this.WtG = -1.0F;
      this.WtH = -1.0F;
      this.WtI[0] = com.tencent.mm.ci.a.l(SettingCheckUnProcessWalletConvUI.this, R.e.hint_text_color);
      this.WtI[1] = com.tencent.mm.ci.a.l(SettingCheckUnProcessWalletConvUI.this, R.e.mm_list_textcolor_unread);
      this.WtI[3] = com.tencent.mm.ci.a.l(SettingCheckUnProcessWalletConvUI.this, R.e.normal_text_color);
      this.WtI[2] = com.tencent.mm.ci.a.l(SettingCheckUnProcessWalletConvUI.this, R.e.mm_list_textcolor_three);
      this.WtI[2] = com.tencent.mm.ci.a.l(SettingCheckUnProcessWalletConvUI.this, R.e.mm_list_textcolor_three);
      this.WtI[4] = com.tencent.mm.ci.a.l(SettingCheckUnProcessWalletConvUI.this, R.e.light_text_color);
      if (com.tencent.mm.ci.a.ko(SettingCheckUnProcessWalletConvUI.this)) {
        this.XAl = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.f.ConversationTimeBiggerWidth);
      }
      for (this.XAk = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);; this.XAk = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallerWidth))
      {
        this.WtD = com.tencent.mm.ci.a.aY(SettingCheckUnProcessWalletConvUI.this, R.f.NormalTextSize);
        this.WtG = com.tencent.mm.ci.a.aY(SettingCheckUnProcessWalletConvUI.this, R.f.HintTextSize);
        this.WtH = com.tencent.mm.ci.a.aY(SettingCheckUnProcessWalletConvUI.this, R.f.SmallestTextSize);
        this.WtK = new HashMap();
        AppMethodBeat.o(38744);
        return;
        this.XAl = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.f.ConversationTimeBigWidth);
      }
    }
    
    private static int aoT(String paramString)
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
    
    private static String byO(String paramString)
    {
      AppMethodBeat.i(38751);
      if ((paramString != null) && (paramString.length() == 32))
      {
        paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auh(paramString);
        AppMethodBeat.o(38751);
        return paramString;
      }
      AppMethodBeat.o(38751);
      return null;
    }
    
    private CharSequence c(az paramaz, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(38750);
      if ((!Util.isNullOrNil(paramaz.field_editingMsg)) && ((paramaz.field_atCount <= 0) || (paramaz.field_unReadCount <= 0)))
      {
        localObject1 = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(R.l.eLh));
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.d(SettingCheckUnProcessWalletConvUI.this, paramaz.field_editingMsg, paramInt));
        AppMethodBeat.o(38750);
        return localObject1;
      }
      Object localObject1 = paramaz.field_digest;
      if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
      {
        paramaz = new SpannableString(com.tencent.mm.pluginsdk.ui.span.l.e(SettingCheckUnProcessWalletConvUI.this, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38750);
        return paramaz;
      }
      localObject1 = paramaz.field_username;
      int i;
      if (((String)localObject1).equals("qqmail"))
      {
        bh.beI();
        if (Util.nullAsNil((Integer)com.tencent.mm.model.c.aHp().b(17, null)) == 1) {}
        for (i = 1; i == 0; i = 0)
        {
          paramaz = SettingCheckUnProcessWalletConvUI.this.getString(R.l.settings_plugins_disable);
          AppMethodBeat.o(38750);
          return paramaz;
        }
      }
      if (((String)localObject1).equals("tmessage"))
      {
        bh.beI();
        localObject1 = com.tencent.mm.model.c.bbU().aPi("@t.qq.com");
        if ((localObject1 != null) && (((cj)localObject1).isEnable())) {}
        for (i = 1; i == 0; i = 0)
        {
          paramaz = SettingCheckUnProcessWalletConvUI.this.getString(R.l.settings_plugins_disable);
          AppMethodBeat.o(38750);
          return paramaz;
        }
      }
      String str1;
      if ((paramaz.field_msgType != null) && ((paramaz.field_msgType.equals("47")) || (paramaz.field_msgType.equals("1048625"))))
      {
        localObject1 = byO(paramaz.field_digest);
        str1 = "";
        if (localObject1 != null)
        {
          paramaz = "[" + (String)localObject1 + "]";
          AppMethodBeat.o(38750);
          return paramaz;
        }
        localObject1 = str1;
        if (paramaz.field_digest != null)
        {
          localObject1 = str1;
          if (paramaz.field_digest.contains(":"))
          {
            str1 = paramaz.field_digest.substring(0, paramaz.field_digest.indexOf(":"));
            String str2 = byO(paramaz.field_digest.substring(paramaz.field_digest.indexOf(":") + 1).replace(" ", ""));
            localObject1 = str1;
            if (str2 != null)
            {
              paramaz = "[" + str2 + "]";
              if (Util.isNullOrNil(str1))
              {
                AppMethodBeat.o(38750);
                return paramaz;
              }
              paramaz = str1 + ": " + paramaz;
              AppMethodBeat.o(38750);
              return paramaz;
            }
          }
        }
        str1 = SettingCheckUnProcessWalletConvUI.this.getString(R.l.app_emoji);
        if (Util.isNullOrNil((String)localObject1))
        {
          localObject1 = str1;
          paramaz.Ja((String)localObject1);
        }
      }
      else
      {
        if (Util.isNullOrNil(paramaz.field_digest)) {
          break label780;
        }
        if (Util.isNullOrNil(paramaz.field_digestUser)) {
          break label769;
        }
        if ((paramaz.field_isSend != 0) || (!ab.Lj(paramaz.field_username))) {
          break label757;
        }
        localObject1 = aa.aL(paramaz.field_digestUser, paramaz.field_username);
      }
      label757:
      Object localObject2;
      for (;;)
      {
        label769:
        try
        {
          localObject1 = String.format(paramaz.field_digest, new Object[] { localObject1 });
          str1 = ((String)localObject1).replace('\n', ' ');
          if ((paramaz.field_atCount <= 0) || (paramaz.field_unReadCount <= 0)) {
            break label811;
          }
          paramaz = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(R.l.eLd));
          paramaz.setSpan(new ForegroundColorSpan(-5569532), 0, paramaz.length(), 33);
          paramaz.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.d(SettingCheckUnProcessWalletConvUI.this, str1, paramInt));
          AppMethodBeat.o(38750);
          return paramaz;
        }
        catch (Exception localException) {}
        localObject1 = (String)localObject1 + ": " + str1;
        break;
        localObject1 = aa.PJ(paramaz.field_digestUser);
        continue;
        localObject1 = paramaz.field_digest;
        continue;
        label780:
        localObject2 = com.tencent.mm.booter.notification.a.h.a(paramaz.field_isSend, paramaz.field_username, paramaz.field_content, aoT(paramaz.field_msgType), SettingCheckUnProcessWalletConvUI.this);
      }
      label811:
      if ((paramBoolean) && (paramaz.field_unReadCount > 1)) {
        localObject2 = SettingCheckUnProcessWalletConvUI.this.getString(R.l.eLg, new Object[] { Integer.valueOf(paramaz.field_unReadCount), str1 });
      }
      for (;;)
      {
        paramaz = com.tencent.mm.pluginsdk.ui.span.l.d(SettingCheckUnProcessWalletConvUI.this, (CharSequence)localObject2, paramInt);
        AppMethodBeat.o(38750);
        return paramaz;
        localObject2 = str1;
        if (paramaz.field_unReadCount > 1)
        {
          localObject2 = str1;
          if (ab.QL(paramaz.field_parentRef)) {
            localObject2 = SettingCheckUnProcessWalletConvUI.this.getString(R.l.eLg, new Object[] { Integer.valueOf(paramaz.field_unReadCount), str1 });
          }
        }
      }
    }
    
    private CharSequence i(az paramaz)
    {
      AppMethodBeat.i(38749);
      if (paramaz.field_status == 1)
      {
        paramaz = SettingCheckUnProcessWalletConvUI.this.getString(R.l.eLv);
        AppMethodBeat.o(38749);
        return paramaz;
      }
      if (paramaz.field_conversationTime == 9223372036854775807L)
      {
        AppMethodBeat.o(38749);
        return "";
      }
      paramaz = f.d(SettingCheckUnProcessWalletConvUI.this, paramaz.field_conversationTime, true);
      AppMethodBeat.o(38749);
      return paramaz;
    }
    
    public final az axe(int paramInt)
    {
      AppMethodBeat.i(38746);
      Object localObject = (String)SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.this).get(paramInt);
      bh.beI();
      localObject = com.tencent.mm.model.c.bbR().bwx((String)localObject);
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
        if (com.tencent.mm.ci.a.ko(SettingCheckUnProcessWalletConvUI.this))
        {
          paramView = View.inflate(SettingCheckUnProcessWalletConvUI.this, R.i.efG, null);
          paramViewGroup.iZG = ((ImageView)paramView.findViewById(R.h.avatar_iv));
          paramViewGroup.WtR = ((NoMeasuredTextView)paramView.findViewById(R.h.nickname_tv));
          paramViewGroup.XAG = ((NoMeasuredTextView)paramView.findViewById(R.h.source_tv));
          paramViewGroup.WtS = ((NoMeasuredTextView)paramView.findViewById(R.h.update_time_tv));
          paramViewGroup.WtT = ((NoMeasuredTextView)paramView.findViewById(R.h.last_msg_tv));
          paramViewGroup.sno = ((TextView)paramView.findViewById(R.h.tipcnt_tv));
          paramViewGroup.sno.setBackgroundResource(w.lE(SettingCheckUnProcessWalletConvUI.this));
          paramViewGroup.WtU = ((ImageView)paramView.findViewById(R.h.dIR));
          paramViewGroup.WtW = paramView.findViewById(R.h.dse);
          paramViewGroup.WtV = ((ImageView)paramView.findViewById(R.h.dWs));
          paramViewGroup.XAH = ((ImageView)paramView.findViewById(R.h.dLB));
          paramView.setTag(paramViewGroup);
          paramViewGroup.WtT.setTextSize(0, this.WtG);
          paramViewGroup.WtS.setTextSize(0, this.WtH);
          paramViewGroup.WtR.setTextSize(0, this.WtD);
          paramViewGroup.XAG.setTextSize(0, this.WtG);
          paramViewGroup.WtT.setTextColor(this.WtI[0]);
          paramViewGroup.WtS.setTextColor(this.WtI[4]);
          paramViewGroup.WtR.setTextColor(this.WtI[3]);
          paramViewGroup.XAG.setTextColor(this.WtI[0]);
          paramViewGroup.WtT.setShouldEllipsize(true);
          paramViewGroup.WtS.setShouldEllipsize(false);
          paramViewGroup.WtR.setShouldEllipsize(true);
          paramViewGroup.XAG.setShouldEllipsize(true);
          paramViewGroup.WtS.setGravity(5);
        }
      }
      az localaz;
      for (;;)
      {
        localaz = axe(paramInt);
        if (localaz != null) {
          break label384;
        }
        AppMethodBeat.o(38747);
        return paramView;
        paramView = View.inflate(SettingCheckUnProcessWalletConvUI.this, R.i.efF, null);
        break;
        paramViewGroup = (b)paramView.getTag();
      }
      label384:
      a.b.c(paramViewGroup.iZG, localaz.field_username);
      paramViewGroup.iZG.getDrawable();
      String str2 = localaz.field_username;
      Object localObject2 = (a)this.WtK.get(str2);
      Object localObject1 = localObject2;
      boolean bool;
      if (localObject2 == null)
      {
        localObject2 = new a((byte)0);
        ((a)localObject2).XAw = -1;
        ((a)localObject2).XAv = -1;
        ((a)localObject2).XAB = false;
        ((a)localObject2).XAD = false;
        ((a)localObject2).XAC = false;
        ((a)localObject2).wIg = ab.Lj(localaz.field_username);
        if ((((a)localObject2).wIg) && (((a)localObject2).XAC) && (localaz.field_unReadCount > 0))
        {
          bool = true;
          ((a)localObject2).XAA = bool;
          ((a)localObject2).viewType = 0;
          if ((aoT(localaz.field_msgType) == 34) && (localaz.field_isSend == 0) && (!Util.isNullOrNil(localaz.field_content)))
          {
            String str1 = localaz.field_content;
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
            if (!new p((String)localObject1).mhL) {
              ((a)localObject2).viewType = 1;
            }
          }
          localObject1 = aa.PJ(str2);
          if ((!((a)localObject2).wIg) || (localObject1 != null)) {
            break label1238;
          }
          ((a)localObject2).nickName = SettingCheckUnProcessWalletConvUI.this.getString(R.l.ewS);
          label724:
          ((a)localObject2).XAs = i(localaz);
          ((a)localObject2).XAt = c(localaz, (int)paramViewGroup.WtT.getTextSize(), ((a)localObject2).XAA);
          ((a)localObject2).XAE = localaz.field_attrflag;
        }
      }
      else
      {
        switch (localaz.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label814:
          ((a)localObject2).XAu = paramInt;
          ((a)localObject2).XAx = ab.a(localaz);
          bh.beI();
          ((a)localObject2).WtO = com.tencent.mm.model.c.bbR().h(localaz);
          ((a)localObject2).XAy = false;
          ((a)localObject2).XAz = LocaleUtil.isChineseAppLang();
          this.WtK.put(str2, localObject2);
          localObject1 = localObject2;
          if (((a)localObject1).XAs == null) {
            ((a)localObject1).XAs = i(localaz);
          }
          if ((((a)localObject1).XAA) || (ab.QL(localaz.field_parentRef)))
          {
            paramViewGroup.WtT.setTextColor(this.WtI[0]);
            label930:
            if (!str2.toLowerCase().endsWith("@t.qq.com")) {
              break label1309;
            }
            paramViewGroup.WtR.setCompoundRightDrawablesWithIntrinsicBounds(R.g.icon_tencent_weibo);
            paramViewGroup.WtR.setDrawRightDrawable(true);
            label962:
            paramInt = ((a)localObject1).XAu;
            if (paramInt == -1) {
              break label1320;
            }
            paramViewGroup.WtT.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
            paramViewGroup.WtT.setDrawLeftDrawable(true);
            label989:
            paramViewGroup.WtR.setText(((a)localObject1).nickName);
            paramViewGroup.XAG.setVisibility(8);
            localObject2 = paramViewGroup.WtS.getLayoutParams();
            if (((a)localObject1).XAs.length() <= 9) {
              break label1331;
            }
            if (((ViewGroup.LayoutParams)localObject2).width != this.XAl)
            {
              ((ViewGroup.LayoutParams)localObject2).width = this.XAl;
              paramViewGroup.WtS.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
            label1064:
            Log.v("MicroMsg.SettingCheckUnProcessWalletConvUI", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
            paramViewGroup.WtS.setText(((a)localObject1).XAs);
            paramViewGroup.WtT.setText(((a)localObject1).XAt);
            if ((!((a)localObject1).wIg) || (!((a)localObject1).XAC)) {
              break label1364;
            }
            paramViewGroup.WtU.setVisibility(0);
            label1136:
            a.b.c(paramViewGroup.iZG, str2);
            if ((!((a)localObject1).XAx) && (((a)localObject1).WtO) && (bh.aHB()))
            {
              bh.beI();
              com.tencent.mm.model.c.bbR().g(localaz);
            }
            if ((!((a)localObject1).WtO) || (localaz.field_conversationTime == -1L)) {
              break label1395;
            }
            paramView.findViewById(R.h.dCL).setBackgroundResource(R.g.comm_item_highlight_selector);
          }
          break;
        }
      }
      for (;;)
      {
        paramViewGroup.WtV.setVisibility(8);
        AppMethodBeat.o(38747);
        return paramView;
        bool = false;
        break;
        label1238:
        ((a)localObject2).nickName = com.tencent.mm.pluginsdk.ui.span.l.b(SettingCheckUnProcessWalletConvUI.this, aa.PJ(str2), paramViewGroup.WtR.getTextSize());
        break label724;
        paramInt = -1;
        break label814;
        paramInt = R.k.msg_state_sending;
        break label814;
        paramInt = -1;
        break label814;
        paramInt = R.k.msg_state_failed;
        break label814;
        paramViewGroup.WtT.setTextColor(this.WtI[localObject1.viewType]);
        break label930;
        label1309:
        paramViewGroup.WtR.setDrawRightDrawable(false);
        break label962;
        label1320:
        paramViewGroup.WtT.setDrawLeftDrawable(false);
        break label989;
        label1331:
        if (((ViewGroup.LayoutParams)localObject2).width == this.XAk) {
          break label1064;
        }
        ((ViewGroup.LayoutParams)localObject2).width = this.XAk;
        paramViewGroup.WtS.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break label1064;
        label1364:
        if (((a)localObject1).XAy)
        {
          paramViewGroup.WtU.setVisibility(0);
          break label1136;
        }
        paramViewGroup.WtU.setVisibility(8);
        break label1136;
        label1395:
        paramView.findViewById(R.h.dCL).setBackgroundResource(R.g.comm_list_item_selector);
      }
    }
    
    final class a
    {
      public boolean WtO;
      public boolean XAA;
      public boolean XAB;
      public boolean XAC;
      public boolean XAD;
      public int XAE;
      public CharSequence XAs;
      public CharSequence XAt;
      public int XAu;
      public int XAv;
      public int XAw;
      public boolean XAx;
      public boolean XAy;
      public boolean XAz;
      public CharSequence nickName;
      public int viewType;
      public boolean wIg;
      
      private a() {}
    }
    
    final class b
    {
      public NoMeasuredTextView WtR;
      public NoMeasuredTextView WtS;
      public NoMeasuredTextView WtT;
      public ImageView WtU;
      public ImageView WtV;
      public View WtW;
      public NoMeasuredTextView XAG;
      public ImageView XAH;
      public ImageView iZG;
      public TextView sno;
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI
 * JD-Core Version:    0.7.0.1
 */