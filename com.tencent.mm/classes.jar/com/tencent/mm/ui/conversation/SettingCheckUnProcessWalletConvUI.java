package com.tencent.mm.ui.conversation;

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
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.v;
import java.util.HashMap;
import java.util.List;

public class SettingCheckUnProcessWalletConvUI
  extends MMActivity
{
  private int[] Cxl;
  private List<String> afsy;
  private a afsz;
  private ListView qgc;
  
  public SettingCheckUnProcessWalletConvUI()
  {
    AppMethodBeat.i(38753);
    this.Cxl = new int[2];
    AppMethodBeat.o(38753);
  }
  
  public int getLayoutId()
  {
    return R.i.gnV;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38754);
    super.onCreate(paramBundle);
    setMMTitle(R.l.gYE);
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
    this.qgc = ((ListView)findViewById(R.h.fDA));
    this.afsy = getIntent().getStringArrayListExtra("key_conversation_list");
    if ((this.afsy != null) && (this.afsy.size() > 0))
    {
      this.afsz = new a();
      this.qgc.setAdapter(this.afsz);
      this.qgc.setOnTouchListener(new View.OnTouchListener()
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
      this.qgc.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38739);
          b localb = new b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          paramAnonymousAdapterView = SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.this).aDM(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(38739);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
          paramAnonymousView.putExtra("chat_from_scene", 4);
          com.tencent.mm.br.c.g(SettingCheckUnProcessWalletConvUI.this, ".ui.chatting.ChattingUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38739);
        }
      });
      this.qgc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38743);
          paramAnonymousAdapterView = SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.this).aDM(paramAnonymousInt - SettingCheckUnProcessWalletConvUI.c(SettingCheckUnProcessWalletConvUI.this).getHeaderViewsCount());
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(38743);
            return true;
          }
          final String str = paramAnonymousAdapterView.field_username;
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(SettingCheckUnProcessWalletConvUI.this);
          locala.agjt = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(38740);
              paramAnonymous2ContextMenu.add(0, 1, 0, R.l.main_delete);
              AppMethodBeat.o(38740);
            }
          };
          locala.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, SettingCheckUnProcessWalletConvUI.this, new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(38742);
              if (paramAnonymous2MenuItem.getItemId() == 1) {
                d.a(str, SettingCheckUnProcessWalletConvUI.this, paramAnonymousAdapterView, new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(38741);
                    SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.this).remove(SettingCheckUnProcessWalletConvUI.4.2.this.mae);
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
    private float aeaW;
    protected float aeaZ;
    private float aeba;
    private ColorStateList[] aebb;
    private HashMap<String, a> aebd;
    private final int afmS;
    private final int afmT;
    
    public a()
    {
      AppMethodBeat.i(38744);
      this.aebb = new ColorStateList[5];
      this.aeaW = -1.0F;
      this.aeaZ = -1.0F;
      this.aeba = -1.0F;
      this.aebb[0] = com.tencent.mm.cd.a.l(SettingCheckUnProcessWalletConvUI.this, R.e.hint_text_color);
      this.aebb[1] = com.tencent.mm.cd.a.l(SettingCheckUnProcessWalletConvUI.this, R.e.mm_list_textcolor_unread);
      this.aebb[3] = com.tencent.mm.cd.a.l(SettingCheckUnProcessWalletConvUI.this, R.e.normal_text_color);
      this.aebb[2] = com.tencent.mm.cd.a.l(SettingCheckUnProcessWalletConvUI.this, R.e.mm_list_textcolor_three);
      this.aebb[2] = com.tencent.mm.cd.a.l(SettingCheckUnProcessWalletConvUI.this, R.e.mm_list_textcolor_three);
      this.aebb[4] = com.tencent.mm.cd.a.l(SettingCheckUnProcessWalletConvUI.this, R.e.light_text_color);
      if (com.tencent.mm.cd.a.mp(SettingCheckUnProcessWalletConvUI.this)) {
        this.afmT = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.f.ConversationTimeBiggerWidth);
      }
      for (this.afmS = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);; this.afmS = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallerWidth))
      {
        this.aeaW = com.tencent.mm.cd.a.br(SettingCheckUnProcessWalletConvUI.this, R.f.NormalTextSize);
        this.aeaZ = com.tencent.mm.cd.a.br(SettingCheckUnProcessWalletConvUI.this, R.f.HintTextSize);
        this.aeba = com.tencent.mm.cd.a.br(SettingCheckUnProcessWalletConvUI.this, R.f.SmallestTextSize);
        this.aebd = new HashMap();
        AppMethodBeat.o(38744);
        return;
        this.afmT = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.f.ConversationTimeBigWidth);
      }
    }
    
    private static int aip(String paramString)
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
    
    private CharSequence b(bb parambb, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(38750);
      if ((!Util.isNullOrNil(parambb.field_editingMsg)) && ((parambb.field_atCount <= 0) || (parambb.field_unReadCount <= 0)))
      {
        localObject1 = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(R.l.gNc));
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.span.p.d(SettingCheckUnProcessWalletConvUI.this, parambb.field_editingMsg, paramInt));
        AppMethodBeat.o(38750);
        return localObject1;
      }
      Object localObject1 = parambb.field_digest;
      if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
      {
        parambb = new SpannableString(com.tencent.mm.pluginsdk.ui.span.p.e(SettingCheckUnProcessWalletConvUI.this, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38750);
        return parambb;
      }
      localObject1 = parambb.field_username;
      int i;
      if (((String)localObject1).equals("qqmail"))
      {
        bh.bCz();
        if (Util.nullAsNil((Integer)com.tencent.mm.model.c.ban().d(17, null)) == 1) {}
        for (i = 1; i == 0; i = 0)
        {
          parambb = SettingCheckUnProcessWalletConvUI.this.getString(R.l.settings_plugins_disable);
          AppMethodBeat.o(38750);
          return parambb;
        }
      }
      if (((String)localObject1).equals("tmessage"))
      {
        bh.bCz();
        localObject1 = com.tencent.mm.model.c.bzJ().aMh("@t.qq.com");
        if ((localObject1 != null) && (((cm)localObject1).isEnable())) {}
        for (i = 1; i == 0; i = 0)
        {
          parambb = SettingCheckUnProcessWalletConvUI.this.getString(R.l.settings_plugins_disable);
          AppMethodBeat.o(38750);
          return parambb;
        }
      }
      String str1;
      if ((parambb.field_msgType != null) && ((parambb.field_msgType.equals("47")) || (parambb.field_msgType.equals("1048625"))))
      {
        localObject1 = bAr(parambb.field_digest);
        str1 = "";
        if (localObject1 != null)
        {
          parambb = "[" + (String)localObject1 + "]";
          AppMethodBeat.o(38750);
          return parambb;
        }
        localObject1 = str1;
        if (parambb.field_digest != null)
        {
          localObject1 = str1;
          if (parambb.field_digest.contains(":"))
          {
            str1 = parambb.field_digest.substring(0, parambb.field_digest.indexOf(":"));
            String str2 = bAr(parambb.field_digest.substring(parambb.field_digest.indexOf(":") + 1).replace(" ", ""));
            localObject1 = str1;
            if (str2 != null)
            {
              parambb = "[" + str2 + "]";
              if (Util.isNullOrNil(str1))
              {
                AppMethodBeat.o(38750);
                return parambb;
              }
              parambb = str1 + ": " + parambb;
              AppMethodBeat.o(38750);
              return parambb;
            }
          }
        }
        str1 = SettingCheckUnProcessWalletConvUI.this.getString(R.l.app_emoji);
        if (Util.isNullOrNil((String)localObject1))
        {
          localObject1 = str1;
          parambb.BF((String)localObject1);
        }
      }
      else
      {
        if (Util.isNullOrNil(parambb.field_digest)) {
          break label780;
        }
        if (Util.isNullOrNil(parambb.field_digestUser)) {
          break label769;
        }
        if ((parambb.field_isSend != 0) || (!au.bwE(parambb.field_username))) {
          break label757;
        }
        localObject1 = aa.aV(parambb.field_digestUser, parambb.field_username);
      }
      label757:
      Object localObject2;
      for (;;)
      {
        label769:
        try
        {
          localObject1 = String.format(parambb.field_digest, new Object[] { localObject1 });
          str1 = ((String)localObject1).replace('\n', ' ');
          if ((parambb.field_atCount <= 0) || (parambb.field_unReadCount <= 0)) {
            break label811;
          }
          parambb = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(R.l.gMY));
          parambb.setSpan(new ForegroundColorSpan(-5569532), 0, parambb.length(), 33);
          parambb.append(" ").append(com.tencent.mm.pluginsdk.ui.span.p.d(SettingCheckUnProcessWalletConvUI.this, str1, paramInt));
          AppMethodBeat.o(38750);
          return parambb;
        }
        catch (Exception localException) {}
        localObject1 = (String)localObject1 + ": " + str1;
        break;
        localObject1 = aa.getDisplayName(parambb.field_digestUser);
        continue;
        localObject1 = parambb.field_digest;
        continue;
        label780:
        localObject2 = com.tencent.mm.booter.notification.a.h.a(parambb.field_isSend, parambb.field_username, parambb.field_content, aip(parambb.field_msgType), SettingCheckUnProcessWalletConvUI.this);
      }
      label811:
      if ((paramBoolean) && (parambb.field_unReadCount > 1)) {
        localObject2 = SettingCheckUnProcessWalletConvUI.this.getString(R.l.gNb, new Object[] { Integer.valueOf(parambb.field_unReadCount), str1 });
      }
      for (;;)
      {
        parambb = com.tencent.mm.pluginsdk.ui.span.p.d(SettingCheckUnProcessWalletConvUI.this, (CharSequence)localObject2, paramInt);
        AppMethodBeat.o(38750);
        return parambb;
        localObject2 = str1;
        if (parambb.field_unReadCount > 1)
        {
          localObject2 = str1;
          if (au.bwp(parambb.field_parentRef)) {
            localObject2 = SettingCheckUnProcessWalletConvUI.this.getString(R.l.gNb, new Object[] { Integer.valueOf(parambb.field_unReadCount), str1 });
          }
        }
      }
    }
    
    private static String bAr(String paramString)
    {
      AppMethodBeat.i(38751);
      if ((paramString != null) && (paramString.length() == 32))
      {
        paramString = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoi(paramString);
        AppMethodBeat.o(38751);
        return paramString;
      }
      AppMethodBeat.o(38751);
      return null;
    }
    
    private CharSequence q(bb parambb)
    {
      AppMethodBeat.i(38749);
      if (parambb.field_status == 1)
      {
        parambb = SettingCheckUnProcessWalletConvUI.this.getString(R.l.gNp);
        AppMethodBeat.o(38749);
        return parambb;
      }
      if (parambb.field_conversationTime == 9223372036854775807L)
      {
        AppMethodBeat.o(38749);
        return "";
      }
      parambb = f.d(SettingCheckUnProcessWalletConvUI.this, parambb.field_conversationTime, true);
      AppMethodBeat.o(38749);
      return parambb;
    }
    
    public final bb aDM(int paramInt)
    {
      AppMethodBeat.i(38746);
      Object localObject = (String)SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.this).get(paramInt);
      bh.bCz();
      localObject = com.tencent.mm.model.c.bzG().bxM((String)localObject);
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
        if (com.tencent.mm.cd.a.mp(SettingCheckUnProcessWalletConvUI.this))
        {
          paramView = View.inflate(SettingCheckUnProcessWalletConvUI.this, R.i.giF, null);
          paramViewGroup.lBC = ((ImageView)paramView.findViewById(R.h.avatar_iv));
          paramViewGroup.aebj = ((NoMeasuredTextView)paramView.findViewById(R.h.nickname_tv));
          paramViewGroup.afno = ((NoMeasuredTextView)paramView.findViewById(R.h.source_tv));
          paramViewGroup.aebk = ((NoMeasuredTextView)paramView.findViewById(R.h.update_time_tv));
          paramViewGroup.aebl = ((NoMeasuredTextView)paramView.findViewById(R.h.last_msg_tv));
          paramViewGroup.vzm = ((TextView)paramView.findViewById(R.h.tipcnt_tv));
          paramViewGroup.vzm.setBackgroundResource(v.nH(SettingCheckUnProcessWalletConvUI.this));
          paramViewGroup.aebm = ((ImageView)paramView.findViewById(R.h.fKm));
          paramViewGroup.aebo = paramView.findViewById(R.h.fsw);
          paramViewGroup.aebn = ((ImageView)paramView.findViewById(R.h.fYY));
          paramViewGroup.afnp = ((ImageView)paramView.findViewById(R.h.fNi));
          paramView.setTag(paramViewGroup);
          paramViewGroup.aebl.setTextSize(0, this.aeaZ);
          paramViewGroup.aebk.setTextSize(0, this.aeba);
          paramViewGroup.aebj.setTextSize(0, this.aeaW);
          paramViewGroup.afno.setTextSize(0, this.aeaZ);
          paramViewGroup.aebl.setTextColor(this.aebb[0]);
          paramViewGroup.aebk.setTextColor(this.aebb[4]);
          paramViewGroup.aebj.setTextColor(this.aebb[3]);
          paramViewGroup.afno.setTextColor(this.aebb[0]);
          paramViewGroup.aebl.setShouldEllipsize(true);
          paramViewGroup.aebk.setShouldEllipsize(false);
          paramViewGroup.aebj.setShouldEllipsize(true);
          paramViewGroup.afno.setShouldEllipsize(true);
          paramViewGroup.aebk.setGravity(5);
        }
      }
      bb localbb;
      for (;;)
      {
        localbb = aDM(paramInt);
        if (localbb != null) {
          break label384;
        }
        AppMethodBeat.o(38747);
        return paramView;
        paramView = View.inflate(SettingCheckUnProcessWalletConvUI.this, R.i.giE, null);
        break;
        paramViewGroup = (b)paramView.getTag();
      }
      label384:
      a.b.g(paramViewGroup.lBC, localbb.field_username);
      paramViewGroup.lBC.getDrawable();
      String str2 = localbb.field_username;
      Object localObject2 = (a)this.aebd.get(str2);
      Object localObject1 = localObject2;
      boolean bool;
      if (localObject2 == null)
      {
        localObject2 = new a((byte)0);
        ((a)localObject2).afne = -1;
        ((a)localObject2).afnd = -1;
        ((a)localObject2).afnj = false;
        ((a)localObject2).afnl = false;
        ((a)localObject2).afnk = false;
        ((a)localObject2).Aeu = au.bwE(localbb.field_username);
        if ((((a)localObject2).Aeu) && (((a)localObject2).afnk) && (localbb.field_unReadCount > 0))
        {
          bool = true;
          ((a)localObject2).afni = bool;
          ((a)localObject2).viewType = 0;
          if ((aip(localbb.field_msgType) == 34) && (localbb.field_isSend == 0) && (!Util.isNullOrNil(localbb.field_content)))
          {
            String str1 = localbb.field_content;
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
            if (!new com.tencent.mm.modelvoice.p((String)localObject1).paW) {
              ((a)localObject2).viewType = 1;
            }
          }
          localObject1 = aa.getDisplayName(str2);
          if ((!((a)localObject2).Aeu) || (localObject1 != null)) {
            break label1238;
          }
          ((a)localObject2).nickName = SettingCheckUnProcessWalletConvUI.this.getString(R.l.gzv);
          label724:
          ((a)localObject2).afna = q(localbb);
          ((a)localObject2).afnb = b(localbb, (int)paramViewGroup.aebl.getTextSize(), ((a)localObject2).afni);
          ((a)localObject2).afnm = localbb.field_attrflag;
        }
      }
      else
      {
        switch (localbb.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label814:
          ((a)localObject2).afnc = paramInt;
          ((a)localObject2).afnf = ab.a(localbb);
          bh.bCz();
          ((a)localObject2).aebg = com.tencent.mm.model.c.bzG().k(localbb);
          ((a)localObject2).afng = false;
          ((a)localObject2).afnh = LocaleUtil.isChineseAppLang();
          this.aebd.put(str2, localObject2);
          localObject1 = localObject2;
          if (((a)localObject1).afna == null) {
            ((a)localObject1).afna = q(localbb);
          }
          if ((((a)localObject1).afni) || (au.bwp(localbb.field_parentRef)))
          {
            paramViewGroup.aebl.setTextColor(this.aebb[0]);
            label930:
            if (!str2.toLowerCase().endsWith("@t.qq.com")) {
              break label1309;
            }
            paramViewGroup.aebj.setCompoundRightDrawablesWithIntrinsicBounds(R.g.icon_tencent_weibo);
            paramViewGroup.aebj.setDrawRightDrawable(true);
            label962:
            paramInt = ((a)localObject1).afnc;
            if (paramInt == -1) {
              break label1320;
            }
            paramViewGroup.aebl.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
            paramViewGroup.aebl.setDrawLeftDrawable(true);
            label989:
            paramViewGroup.aebj.setText(((a)localObject1).nickName);
            paramViewGroup.afno.setVisibility(8);
            localObject2 = paramViewGroup.aebk.getLayoutParams();
            if (((a)localObject1).afna.length() <= 9) {
              break label1331;
            }
            if (((ViewGroup.LayoutParams)localObject2).width != this.afmT)
            {
              ((ViewGroup.LayoutParams)localObject2).width = this.afmT;
              paramViewGroup.aebk.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
            label1064:
            Log.v("MicroMsg.SettingCheckUnProcessWalletConvUI", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
            paramViewGroup.aebk.setText(((a)localObject1).afna);
            paramViewGroup.aebl.setText(((a)localObject1).afnb);
            if ((!((a)localObject1).Aeu) || (!((a)localObject1).afnk)) {
              break label1364;
            }
            paramViewGroup.aebm.setVisibility(0);
            label1136:
            a.b.g(paramViewGroup.lBC, str2);
            if ((!((a)localObject1).afnf) && (((a)localObject1).aebg) && (bh.baz()))
            {
              bh.bCz();
              com.tencent.mm.model.c.bzG().j(localbb);
            }
            if ((!((a)localObject1).aebg) || (localbb.field_conversationTime == -1L)) {
              break label1395;
            }
            paramView.findViewById(R.h.fDC).setBackgroundResource(R.g.comm_item_highlight_selector);
          }
          break;
        }
      }
      for (;;)
      {
        paramViewGroup.aebn.setVisibility(8);
        AppMethodBeat.o(38747);
        return paramView;
        bool = false;
        break;
        label1238:
        ((a)localObject2).nickName = com.tencent.mm.pluginsdk.ui.span.p.b(SettingCheckUnProcessWalletConvUI.this, aa.getDisplayName(str2), paramViewGroup.aebj.getTextSize());
        break label724;
        paramInt = -1;
        break label814;
        paramInt = R.k.msg_state_sending;
        break label814;
        paramInt = -1;
        break label814;
        paramInt = R.k.msg_state_failed;
        break label814;
        paramViewGroup.aebl.setTextColor(this.aebb[localObject1.viewType]);
        break label930;
        label1309:
        paramViewGroup.aebj.setDrawRightDrawable(false);
        break label962;
        label1320:
        paramViewGroup.aebl.setDrawLeftDrawable(false);
        break label989;
        label1331:
        if (((ViewGroup.LayoutParams)localObject2).width == this.afmS) {
          break label1064;
        }
        ((ViewGroup.LayoutParams)localObject2).width = this.afmS;
        paramViewGroup.aebk.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break label1064;
        label1364:
        if (((a)localObject1).afng)
        {
          paramViewGroup.aebm.setVisibility(0);
          break label1136;
        }
        paramViewGroup.aebm.setVisibility(8);
        break label1136;
        label1395:
        paramView.findViewById(R.h.fDC).setBackgroundResource(R.g.comm_list_item_selector);
      }
    }
    
    final class a
    {
      public boolean Aeu;
      public boolean aebg;
      public CharSequence afna;
      public CharSequence afnb;
      public int afnc;
      public int afnd;
      public int afne;
      public boolean afnf;
      public boolean afng;
      public boolean afnh;
      public boolean afni;
      public boolean afnj;
      public boolean afnk;
      public boolean afnl;
      public int afnm;
      public CharSequence nickName;
      public int viewType;
      
      private a() {}
    }
    
    final class b
    {
      public NoMeasuredTextView aebj;
      public NoMeasuredTextView aebk;
      public NoMeasuredTextView aebl;
      public ImageView aebm;
      public ImageView aebn;
      public View aebo;
      public NoMeasuredTextView afno;
      public ImageView afnp;
      public ImageView lBC;
      public TextView vzm;
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI
 * JD-Core Version:    0.7.0.1
 */