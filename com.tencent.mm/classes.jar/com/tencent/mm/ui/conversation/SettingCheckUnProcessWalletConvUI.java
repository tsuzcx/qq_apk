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
import com.tencent.mm.g.c.bb;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ci;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.v;
import java.util.HashMap;
import java.util.List;

public class SettingCheckUnProcessWalletConvUI
  extends MMActivity
{
  private List<String> Qhr;
  private a Qhs;
  private ListView krb;
  private int[] utT;
  
  public SettingCheckUnProcessWalletConvUI()
  {
    AppMethodBeat.i(38753);
    this.utT = new int[2];
    AppMethodBeat.o(38753);
  }
  
  public int getLayoutId()
  {
    return 2131496237;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38754);
    super.onCreate(paramBundle);
    setMMTitle(2131767659);
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
    this.krb = ((ListView)findViewById(2131299240));
    this.Qhr = getIntent().getStringArrayListExtra("key_conversation_list");
    if ((this.Qhr != null) && (this.Qhr.size() > 0))
    {
      this.Qhs = new a();
      this.krb.setAdapter(this.Qhs);
      this.krb.setOnTouchListener(new View.OnTouchListener()
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
      this.krb.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38739);
          b localb = new b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          paramAnonymousAdapterView = SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.this).anZ(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(38739);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
          paramAnonymousView.putExtra("chat_from_scene", 4);
          com.tencent.mm.br.c.f(SettingCheckUnProcessWalletConvUI.this, ".ui.chatting.ChattingUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38739);
        }
      });
      this.krb.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38743);
          paramAnonymousAdapterView = SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.this).anZ(paramAnonymousInt - SettingCheckUnProcessWalletConvUI.c(SettingCheckUnProcessWalletConvUI.this).getHeaderViewsCount());
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(38743);
            return true;
          }
          final String str = paramAnonymousAdapterView.field_username;
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(SettingCheckUnProcessWalletConvUI.this);
          locala.QSs = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(38740);
              paramAnonymous2ContextMenu.add(0, 1, 0, 2131762843);
              AppMethodBeat.o(38740);
            }
          };
          locala.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, SettingCheckUnProcessWalletConvUI.this, new o.g()
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
                    SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.this).remove(SettingCheckUnProcessWalletConvUI.4.2.this.gMw);
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
    private float Paq;
    protected float Pat;
    private float Pau;
    private ColorStateList[] Pav;
    private HashMap<String, a> Pax;
    private final int QbV;
    private final int QbW;
    
    public a()
    {
      AppMethodBeat.i(38744);
      this.Pav = new ColorStateList[5];
      this.Paq = -1.0F;
      this.Pat = -1.0F;
      this.Pau = -1.0F;
      this.Pav[0] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100594);
      this.Pav[1] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100813);
      this.Pav[3] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100904);
      this.Pav[2] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100810);
      this.Pav[2] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100810);
      this.Pav[4] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100681);
      if (com.tencent.mm.cb.a.jk(SettingCheckUnProcessWalletConvUI.this)) {
        this.QbW = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165249);
      }
      for (this.QbV = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165251);; this.QbV = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165252))
      {
        this.Paq = com.tencent.mm.cb.a.aG(SettingCheckUnProcessWalletConvUI.this, 2131165535);
        this.Pat = com.tencent.mm.cb.a.aG(SettingCheckUnProcessWalletConvUI.this, 2131165482);
        this.Pau = com.tencent.mm.cb.a.aG(SettingCheckUnProcessWalletConvUI.this, 2131165594);
        this.Pax = new HashMap();
        AppMethodBeat.o(38744);
        return;
        this.QbW = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165248);
      }
    }
    
    private static int ahn(String paramString)
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
    
    private static String bmp(String paramString)
    {
      AppMethodBeat.i(38751);
      if ((paramString != null) && (paramString.length() == 32))
      {
        paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amp(paramString);
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
        localObject1 = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(2131762834));
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.e(SettingCheckUnProcessWalletConvUI.this, paramaz.field_editingMsg, paramInt));
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
        bg.aVF();
        if (Util.nullAsNil((Integer)com.tencent.mm.model.c.azQ().get(17, null)) == 1) {}
        for (i = 1; i == 0; i = 0)
        {
          paramaz = SettingCheckUnProcessWalletConvUI.this.getString(2131765538);
          AppMethodBeat.o(38750);
          return paramaz;
        }
      }
      if (((String)localObject1).equals("tmessage"))
      {
        bg.aVF();
        localObject1 = com.tencent.mm.model.c.aSW().aEY("@t.qq.com");
        if ((localObject1 != null) && (((ci)localObject1).isEnable())) {}
        for (i = 1; i == 0; i = 0)
        {
          paramaz = SettingCheckUnProcessWalletConvUI.this.getString(2131765538);
          AppMethodBeat.o(38750);
          return paramaz;
        }
      }
      String str1;
      if ((paramaz.field_msgType != null) && ((paramaz.field_msgType.equals("47")) || (paramaz.field_msgType.equals("1048625"))))
      {
        localObject1 = bmp(paramaz.field_digest);
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
            String str2 = bmp(paramaz.field_digest.substring(paramaz.field_digest.indexOf(":") + 1).replace(" ", ""));
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
        str1 = SettingCheckUnProcessWalletConvUI.this.getString(2131755793);
        if (Util.isNullOrNil((String)localObject1))
        {
          localObject1 = str1;
          paramaz.Cm((String)localObject1);
        }
      }
      else
      {
        if (Util.isNullOrNil(paramaz.field_digest)) {
          break label775;
        }
        if (Util.isNullOrNil(paramaz.field_digestUser)) {
          break label764;
        }
        if ((paramaz.field_isSend != 0) || (!ab.Eq(paramaz.field_username))) {
          break label752;
        }
        localObject1 = aa.getDisplayName(paramaz.field_digestUser, paramaz.field_username);
      }
      label752:
      label764:
      Object localObject2;
      for (;;)
      {
        try
        {
          localObject1 = String.format(paramaz.field_digest, new Object[] { localObject1 });
          str1 = ((String)localObject1).replace('\n', ' ');
          if ((paramaz.field_atCount <= 0) || (paramaz.field_unReadCount <= 0)) {
            break label806;
          }
          paramaz = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(2131762825));
          paramaz.setSpan(new ForegroundColorSpan(-5569532), 0, paramaz.length(), 33);
          paramaz.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.e(SettingCheckUnProcessWalletConvUI.this, str1, paramInt));
          AppMethodBeat.o(38750);
          return paramaz;
        }
        catch (Exception localException) {}
        localObject1 = (String)localObject1 + ": " + str1;
        break;
        localObject1 = aa.getDisplayName(paramaz.field_digestUser);
        continue;
        localObject1 = paramaz.field_digest;
        continue;
        label775:
        localObject2 = h.a(paramaz.field_isSend, paramaz.field_username, paramaz.field_content, ahn(paramaz.field_msgType), SettingCheckUnProcessWalletConvUI.this);
      }
      label806:
      if ((paramBoolean) && (paramaz.field_unReadCount > 1)) {
        localObject2 = SettingCheckUnProcessWalletConvUI.this.getString(2131762828, new Object[] { Integer.valueOf(paramaz.field_unReadCount), str1 });
      }
      for (;;)
      {
        paramaz = com.tencent.mm.pluginsdk.ui.span.l.e(SettingCheckUnProcessWalletConvUI.this, (CharSequence)localObject2, paramInt);
        AppMethodBeat.o(38750);
        return paramaz;
        localObject2 = str1;
        if (paramaz.field_unReadCount > 1)
        {
          localObject2 = str1;
          if (ab.Js(paramaz.field_parentRef)) {
            localObject2 = SettingCheckUnProcessWalletConvUI.this.getString(2131762828, new Object[] { Integer.valueOf(paramaz.field_unReadCount), str1 });
          }
        }
      }
    }
    
    private CharSequence i(az paramaz)
    {
      AppMethodBeat.i(38749);
      if (paramaz.field_status == 1)
      {
        paramaz = SettingCheckUnProcessWalletConvUI.this.getString(2131762861);
        AppMethodBeat.o(38749);
        return paramaz;
      }
      if (paramaz.field_conversationTime == 9223372036854775807L)
      {
        AppMethodBeat.o(38749);
        return "";
      }
      paramaz = f.c(SettingCheckUnProcessWalletConvUI.this, paramaz.field_conversationTime, true);
      AppMethodBeat.o(38749);
      return paramaz;
    }
    
    public final az anZ(int paramInt)
    {
      AppMethodBeat.i(38746);
      Object localObject = (String)SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.this).get(paramInt);
      bg.aVF();
      localObject = com.tencent.mm.model.c.aST().bjY((String)localObject);
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
        if (com.tencent.mm.cb.a.jk(SettingCheckUnProcessWalletConvUI.this))
        {
          paramView = View.inflate(SettingCheckUnProcessWalletConvUI.this, 2131493793, null);
          paramViewGroup.gvv = ((ImageView)paramView.findViewById(2131297134));
          paramViewGroup.PaE = ((NoMeasuredTextView)paramView.findViewById(2131305440));
          paramViewGroup.Qcr = ((NoMeasuredTextView)paramView.findViewById(2131308313));
          paramViewGroup.PaF = ((NoMeasuredTextView)paramView.findViewById(2131309606));
          paramViewGroup.PaG = ((NoMeasuredTextView)paramView.findViewById(2131303011));
          paramViewGroup.plf = ((TextView)paramView.findViewById(2131309165));
          paramViewGroup.plf.setBackgroundResource(v.kH(SettingCheckUnProcessWalletConvUI.this));
          paramViewGroup.PaH = ((ImageView)paramView.findViewById(2131302590));
          paramViewGroup.PaJ = paramView.findViewById(2131297142);
          paramViewGroup.PaI = ((ImageView)paramView.findViewById(2131308917));
          paramViewGroup.Qcs = ((ImageView)paramView.findViewById(2131303751));
          paramView.setTag(paramViewGroup);
          paramViewGroup.PaG.setTextSize(0, this.Pat);
          paramViewGroup.PaF.setTextSize(0, this.Pau);
          paramViewGroup.PaE.setTextSize(0, this.Paq);
          paramViewGroup.Qcr.setTextSize(0, this.Pat);
          paramViewGroup.PaG.setTextColor(this.Pav[0]);
          paramViewGroup.PaF.setTextColor(this.Pav[4]);
          paramViewGroup.PaE.setTextColor(this.Pav[3]);
          paramViewGroup.Qcr.setTextColor(this.Pav[0]);
          paramViewGroup.PaG.setShouldEllipsize(true);
          paramViewGroup.PaF.setShouldEllipsize(false);
          paramViewGroup.PaE.setShouldEllipsize(true);
          paramViewGroup.Qcr.setShouldEllipsize(true);
          paramViewGroup.PaF.setGravity(5);
        }
      }
      az localaz;
      for (;;)
      {
        localaz = anZ(paramInt);
        if (localaz != null) {
          break label384;
        }
        AppMethodBeat.o(38747);
        return paramView;
        paramView = View.inflate(SettingCheckUnProcessWalletConvUI.this, 2131493792, null);
        break;
        paramViewGroup = (b)paramView.getTag();
      }
      label384:
      a.b.c(paramViewGroup.gvv, localaz.field_username);
      paramViewGroup.gvv.getDrawable();
      String str2 = localaz.field_username;
      Object localObject2 = (a)this.Pax.get(str2);
      Object localObject1 = localObject2;
      boolean bool;
      if (localObject2 == null)
      {
        localObject2 = new a((byte)0);
        ((a)localObject2).Qch = -1;
        ((a)localObject2).Qcg = -1;
        ((a)localObject2).Qcm = false;
        ((a)localObject2).Qco = false;
        ((a)localObject2).Qcn = false;
        ((a)localObject2).tcb = ab.Eq(localaz.field_username);
        if ((((a)localObject2).tcb) && (((a)localObject2).Qcn) && (localaz.field_unReadCount > 0))
        {
          bool = true;
          ((a)localObject2).Qcl = bool;
          ((a)localObject2).qcr = 0;
          if ((ahn(localaz.field_msgType) == 34) && (localaz.field_isSend == 0) && (!Util.isNullOrNil(localaz.field_content)))
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
            if (!new p((String)localObject1).jsi) {
              ((a)localObject2).qcr = 1;
            }
          }
          localObject1 = aa.getDisplayName(str2);
          if ((!((a)localObject2).tcb) || (localObject1 != null)) {
            break label1237;
          }
          ((a)localObject2).nickName = SettingCheckUnProcessWalletConvUI.this.getString(2131757507);
          label724:
          ((a)localObject2).Qcd = i(localaz);
          ((a)localObject2).Qce = c(localaz, (int)paramViewGroup.PaG.getTextSize(), ((a)localObject2).Qcl);
          ((a)localObject2).Qcp = localaz.field_attrflag;
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
          ((a)localObject2).Qcf = paramInt;
          ((a)localObject2).Qci = ab.a(localaz);
          bg.aVF();
          ((a)localObject2).PaB = com.tencent.mm.model.c.aST().h(localaz);
          ((a)localObject2).Qcj = false;
          ((a)localObject2).Qck = LocaleUtil.isChineseAppLang();
          this.Pax.put(str2, localObject2);
          localObject1 = localObject2;
          if (((a)localObject1).Qcd == null) {
            ((a)localObject1).Qcd = i(localaz);
          }
          if ((((a)localObject1).Qcl) || (ab.Js(localaz.field_parentRef)))
          {
            paramViewGroup.PaG.setTextColor(this.Pav[0]);
            label930:
            if (!str2.toLowerCase().endsWith("@t.qq.com")) {
              break label1308;
            }
            paramViewGroup.PaE.setCompoundRightDrawablesWithIntrinsicBounds(2131233117);
            paramViewGroup.PaE.setDrawRightDrawable(true);
            label961:
            paramInt = ((a)localObject1).Qcf;
            if (paramInt == -1) {
              break label1319;
            }
            paramViewGroup.PaG.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
            paramViewGroup.PaG.setDrawLeftDrawable(true);
            label988:
            paramViewGroup.PaE.setText(((a)localObject1).nickName);
            paramViewGroup.Qcr.setVisibility(8);
            localObject2 = paramViewGroup.PaF.getLayoutParams();
            if (((a)localObject1).Qcd.length() <= 9) {
              break label1330;
            }
            if (((ViewGroup.LayoutParams)localObject2).width != this.QbW)
            {
              ((ViewGroup.LayoutParams)localObject2).width = this.QbW;
              paramViewGroup.PaF.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
            label1063:
            Log.v("MicroMsg.SettingCheckUnProcessWalletConvUI", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
            paramViewGroup.PaF.setText(((a)localObject1).Qcd);
            paramViewGroup.PaG.setText(((a)localObject1).Qce);
            if ((!((a)localObject1).tcb) || (!((a)localObject1).Qcn)) {
              break label1363;
            }
            paramViewGroup.PaH.setVisibility(0);
            label1135:
            a.b.c(paramViewGroup.gvv, str2);
            if ((!((a)localObject1).Qci) && (((a)localObject1).PaB) && (bg.aAc()))
            {
              bg.aVF();
              com.tencent.mm.model.c.aST().g(localaz);
            }
            if ((!((a)localObject1).PaB) || (localaz.field_conversationTime == -1L)) {
              break label1394;
            }
            paramView.findViewById(2131299246).setBackgroundResource(2131231897);
          }
          break;
        }
      }
      for (;;)
      {
        paramViewGroup.PaI.setVisibility(8);
        AppMethodBeat.o(38747);
        return paramView;
        bool = false;
        break;
        label1237:
        ((a)localObject2).nickName = com.tencent.mm.pluginsdk.ui.span.l.b(SettingCheckUnProcessWalletConvUI.this, aa.getDisplayName(str2), paramViewGroup.PaE.getTextSize());
        break label724;
        paramInt = -1;
        break label814;
        paramInt = 2131691165;
        break label814;
        paramInt = -1;
        break label814;
        paramInt = 2131691164;
        break label814;
        paramViewGroup.PaG.setTextColor(this.Pav[localObject1.qcr]);
        break label930;
        label1308:
        paramViewGroup.PaE.setDrawRightDrawable(false);
        break label961;
        label1319:
        paramViewGroup.PaG.setDrawLeftDrawable(false);
        break label988;
        label1330:
        if (((ViewGroup.LayoutParams)localObject2).width == this.QbV) {
          break label1063;
        }
        ((ViewGroup.LayoutParams)localObject2).width = this.QbV;
        paramViewGroup.PaF.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break label1063;
        label1363:
        if (((a)localObject1).Qcj)
        {
          paramViewGroup.PaH.setVisibility(0);
          break label1135;
        }
        paramViewGroup.PaH.setVisibility(8);
        break label1135;
        label1394:
        paramView.findViewById(2131299246).setBackgroundResource(2131231898);
      }
    }
    
    final class a
    {
      public boolean PaB;
      public CharSequence Qcd;
      public CharSequence Qce;
      public int Qcf;
      public int Qcg;
      public int Qch;
      public boolean Qci;
      public boolean Qcj;
      public boolean Qck;
      public boolean Qcl;
      public boolean Qcm;
      public boolean Qcn;
      public boolean Qco;
      public int Qcp;
      public CharSequence nickName;
      public int qcr;
      public boolean tcb;
      
      private a() {}
    }
    
    final class b
    {
      public NoMeasuredTextView PaE;
      public NoMeasuredTextView PaF;
      public NoMeasuredTextView PaG;
      public ImageView PaH;
      public ImageView PaI;
      public View PaJ;
      public NoMeasuredTextView Qcr;
      public ImageView Qcs;
      public ImageView gvv;
      public TextView plf;
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI
 * JD-Core Version:    0.7.0.1
 */