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
import com.tencent.mm.g.c.ay;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.u;
import java.util.HashMap;
import java.util.List;

public class SettingCheckUnProcessWalletConvUI
  extends MMActivity
{
  private List<String> Hgi;
  private a Hgj;
  private ListView iwH;
  private int[] reK;
  
  public SettingCheckUnProcessWalletConvUI()
  {
    AppMethodBeat.i(38753);
    this.reK = new int[2];
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
    this.iwH = ((ListView)findViewById(2131298790));
    this.Hgi = getIntent().getStringArrayListExtra("key_conversation_list");
    if ((this.Hgi != null) && (this.Hgi.size() > 0))
    {
      this.Hgj = new a();
      this.iwH.setAdapter(this.Hgj);
      this.iwH.setOnTouchListener(new View.OnTouchListener()
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
      this.iwH.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38739);
          paramAnonymousAdapterView = SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.this).ZV(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(38739);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
          paramAnonymousView.putExtra("chat_from_scene", 4);
          com.tencent.mm.bs.d.e(SettingCheckUnProcessWalletConvUI.this, ".ui.chatting.ChattingUI", paramAnonymousView);
          AppMethodBeat.o(38739);
        }
      });
      this.iwH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38743);
          paramAnonymousAdapterView = SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.this).ZV(paramAnonymousInt - SettingCheckUnProcessWalletConvUI.c(SettingCheckUnProcessWalletConvUI.this).getHeaderViewsCount());
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(38743);
            return true;
          }
          final String str = paramAnonymousAdapterView.field_username;
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(SettingCheckUnProcessWalletConvUI.this);
          locala.HIu = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(38740);
              paramAnonymous2ContextMenu.add(0, 1, 0, 2131761057);
              AppMethodBeat.o(38740);
            }
          };
          locala.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, SettingCheckUnProcessWalletConvUI.this, new n.d()
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
                    SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.this).remove(SettingCheckUnProcessWalletConvUI.4.2.this.fHA);
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
    private float GgQ;
    protected float GgT;
    private float GgU;
    private ColorStateList[] GgV;
    private HashMap<String, a> GgX;
    private final int Hbn;
    private final int Hbo;
    
    public a()
    {
      AppMethodBeat.i(38744);
      this.GgV = new ColorStateList[5];
      this.GgQ = -1.0F;
      this.GgT = -1.0F;
      this.GgU = -1.0F;
      this.GgV[0] = com.tencent.mm.cd.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100490);
      this.GgV[1] = com.tencent.mm.cd.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100643);
      this.GgV[3] = com.tencent.mm.cd.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100711);
      this.GgV[2] = com.tencent.mm.cd.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100640);
      this.GgV[2] = com.tencent.mm.cd.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100640);
      this.GgV[4] = com.tencent.mm.cd.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100543);
      if (com.tencent.mm.cd.a.hS(SettingCheckUnProcessWalletConvUI.this)) {
        this.Hbo = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165245);
      }
      for (this.Hbn = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165247);; this.Hbn = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165248))
      {
        this.GgQ = com.tencent.mm.cd.a.ao(SettingCheckUnProcessWalletConvUI.this, 2131165517);
        this.GgT = com.tencent.mm.cd.a.ao(SettingCheckUnProcessWalletConvUI.this, 2131165466);
        this.GgU = com.tencent.mm.cd.a.ao(SettingCheckUnProcessWalletConvUI.this, 2131165576);
        this.GgX = new HashMap();
        AppMethodBeat.o(38744);
        return;
        this.Hbo = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165244);
      }
    }
    
    private static int OV(String paramString)
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
    
    private static String aKr(String paramString)
    {
      AppMethodBeat.i(38751);
      if ((paramString != null) && (paramString.length() == 32))
      {
        paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TD(paramString);
        AppMethodBeat.o(38751);
        return paramString;
      }
      AppMethodBeat.o(38751);
      return null;
    }
    
    private CharSequence c(am paramam, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(38750);
      if ((!bt.isNullOrNil(paramam.field_editingMsg)) && ((paramam.field_atCount <= 0) || (paramam.field_unReadCount <= 0)))
      {
        localObject1 = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(2131761048));
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(SettingCheckUnProcessWalletConvUI.this, paramam.field_editingMsg, paramInt));
        AppMethodBeat.o(38750);
        return localObject1;
      }
      Object localObject1 = paramam.field_digest;
      if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
      {
        paramam = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.e(SettingCheckUnProcessWalletConvUI.this, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38750);
        return paramam;
      }
      localObject1 = paramam.field_username;
      int i;
      if (((String)localObject1).equals("qqmail"))
      {
        az.arV();
        if (bt.l((Integer)com.tencent.mm.model.c.afk().get(17, null)) == 1) {}
        for (i = 1; i == 0; i = 0)
        {
          paramam = SettingCheckUnProcessWalletConvUI.this.getString(2131763356);
          AppMethodBeat.o(38750);
          return paramam;
        }
      }
      if (((String)localObject1).equals("tmessage"))
      {
        az.arV();
        localObject1 = com.tencent.mm.model.c.apU().agP("@t.qq.com");
        if ((localObject1 != null) && (((br)localObject1).isEnable())) {}
        for (i = 1; i == 0; i = 0)
        {
          paramam = SettingCheckUnProcessWalletConvUI.this.getString(2131763356);
          AppMethodBeat.o(38750);
          return paramam;
        }
      }
      String str1;
      if ((paramam.field_msgType != null) && ((paramam.field_msgType.equals("47")) || (paramam.field_msgType.equals("1048625"))))
      {
        localObject1 = aKr(paramam.field_digest);
        str1 = "";
        if (localObject1 != null)
        {
          paramam = "[" + (String)localObject1 + "]";
          AppMethodBeat.o(38750);
          return paramam;
        }
        localObject1 = str1;
        if (paramam.field_digest != null)
        {
          localObject1 = str1;
          if (paramam.field_digest.contains(":"))
          {
            str1 = paramam.field_digest.substring(0, paramam.field_digest.indexOf(":"));
            String str2 = aKr(paramam.field_digest.substring(paramam.field_digest.indexOf(":") + 1).replace(" ", ""));
            localObject1 = str1;
            if (str2 != null)
            {
              paramam = "[" + str2 + "]";
              if (bt.isNullOrNil(str1))
              {
                AppMethodBeat.o(38750);
                return paramam;
              }
              paramam = str1 + ": " + paramam;
              AppMethodBeat.o(38750);
              return paramam;
            }
          }
        }
        str1 = SettingCheckUnProcessWalletConvUI.this.getString(2131755722);
        if (bt.isNullOrNil((String)localObject1))
        {
          localObject1 = str1;
          paramam.nL((String)localObject1);
        }
      }
      else
      {
        if (bt.isNullOrNil(paramam.field_digest)) {
          break label775;
        }
        if (bt.isNullOrNil(paramam.field_digestUser)) {
          break label764;
        }
        if ((paramam.field_isSend != 0) || (!w.pF(paramam.field_username))) {
          break label752;
        }
        localObject1 = v.getDisplayName(paramam.field_digestUser, paramam.field_username);
      }
      label752:
      label764:
      Object localObject2;
      for (;;)
      {
        try
        {
          localObject1 = String.format(paramam.field_digest, new Object[] { localObject1 });
          str1 = ((String)localObject1).replace('\n', ' ');
          if ((paramam.field_atCount <= 0) || (paramam.field_unReadCount <= 0)) {
            break label806;
          }
          paramam = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(2131761044));
          paramam.setSpan(new ForegroundColorSpan(-5569532), 0, paramam.length(), 33);
          paramam.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(SettingCheckUnProcessWalletConvUI.this, str1, paramInt));
          AppMethodBeat.o(38750);
          return paramam;
        }
        catch (Exception localException) {}
        localObject1 = (String)localObject1 + ": " + str1;
        break;
        localObject1 = v.sh(paramam.field_digestUser);
        continue;
        localObject1 = paramam.field_digest;
        continue;
        label775:
        localObject2 = com.tencent.mm.booter.notification.a.h.a(paramam.field_isSend, paramam.field_username, paramam.field_content, OV(paramam.field_msgType), SettingCheckUnProcessWalletConvUI.this);
      }
      label806:
      if ((paramBoolean) && (paramam.field_unReadCount > 1)) {
        localObject2 = SettingCheckUnProcessWalletConvUI.this.getString(2131761047, new Object[] { Integer.valueOf(paramam.field_unReadCount), str1 });
      }
      for (;;)
      {
        paramam = com.tencent.mm.pluginsdk.ui.span.k.b(SettingCheckUnProcessWalletConvUI.this, (CharSequence)localObject2, paramInt);
        AppMethodBeat.o(38750);
        return paramam;
        localObject2 = str1;
        if (paramam.field_unReadCount > 1)
        {
          localObject2 = str1;
          if (w.td(paramam.field_parentRef)) {
            localObject2 = SettingCheckUnProcessWalletConvUI.this.getString(2131761047, new Object[] { Integer.valueOf(paramam.field_unReadCount), str1 });
          }
        }
      }
    }
    
    private CharSequence i(am paramam)
    {
      AppMethodBeat.i(38749);
      if (paramam.field_status == 1)
      {
        paramam = SettingCheckUnProcessWalletConvUI.this.getString(2131761075);
        AppMethodBeat.o(38749);
        return paramam;
      }
      if (paramam.field_conversationTime == 9223372036854775807L)
      {
        AppMethodBeat.o(38749);
        return "";
      }
      paramam = com.tencent.mm.pluginsdk.g.h.c(SettingCheckUnProcessWalletConvUI.this, paramam.field_conversationTime, true);
      AppMethodBeat.o(38749);
      return paramam;
    }
    
    public final am ZV(int paramInt)
    {
      AppMethodBeat.i(38746);
      Object localObject = (String)SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.this).get(paramInt);
      az.arV();
      localObject = com.tencent.mm.model.c.apR().aIn((String)localObject);
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
        if (com.tencent.mm.cd.a.hS(SettingCheckUnProcessWalletConvUI.this))
        {
          paramView = View.inflate(SettingCheckUnProcessWalletConvUI.this, 2131493663, null);
          paramViewGroup.frr = ((ImageView)paramView.findViewById(2131297008));
          paramViewGroup.Ghe = ((NoMeasuredTextView)paramView.findViewById(2131302867));
          paramViewGroup.HbK = ((NoMeasuredTextView)paramView.findViewById(2131305134));
          paramViewGroup.Ghf = ((NoMeasuredTextView)paramView.findViewById(2131306207));
          paramViewGroup.Ghg = ((NoMeasuredTextView)paramView.findViewById(2131301311));
          paramViewGroup.mRr = ((TextView)paramView.findViewById(2131305882));
          paramViewGroup.mRr.setBackgroundResource(u.kh(SettingCheckUnProcessWalletConvUI.this));
          paramViewGroup.Ghh = ((ImageView)paramView.findViewById(2131300954));
          paramViewGroup.Ghj = paramView.findViewById(2131297015);
          paramViewGroup.Ghi = ((ImageView)paramView.findViewById(2131305672));
          paramViewGroup.HbL = ((ImageView)paramView.findViewById(2131301541));
          paramView.setTag(paramViewGroup);
          paramViewGroup.Ghg.setTextSize(0, this.GgT);
          paramViewGroup.Ghf.setTextSize(0, this.GgU);
          paramViewGroup.Ghe.setTextSize(0, this.GgQ);
          paramViewGroup.HbK.setTextSize(0, this.GgT);
          paramViewGroup.Ghg.setTextColor(this.GgV[0]);
          paramViewGroup.Ghf.setTextColor(this.GgV[4]);
          paramViewGroup.Ghe.setTextColor(this.GgV[3]);
          paramViewGroup.HbK.setTextColor(this.GgV[0]);
          paramViewGroup.Ghg.setShouldEllipsize(true);
          paramViewGroup.Ghf.setShouldEllipsize(false);
          paramViewGroup.Ghe.setShouldEllipsize(true);
          paramViewGroup.HbK.setShouldEllipsize(true);
          paramViewGroup.Ghf.setGravity(5);
        }
      }
      am localam;
      for (;;)
      {
        localam = ZV(paramInt);
        if (localam != null) {
          break label384;
        }
        AppMethodBeat.o(38747);
        return paramView;
        paramView = View.inflate(SettingCheckUnProcessWalletConvUI.this, 2131493662, null);
        break;
        paramViewGroup = (b)paramView.getTag();
      }
      label384:
      a.b.c(paramViewGroup.frr, localam.field_username);
      paramViewGroup.frr.getDrawable();
      String str2 = localam.field_username;
      Object localObject2 = (a)this.GgX.get(str2);
      Object localObject1 = localObject2;
      boolean bool;
      if (localObject2 == null)
      {
        localObject2 = new a((byte)0);
        ((a)localObject2).HbA = -1;
        ((a)localObject2).Hbz = -1;
        ((a)localObject2).HbF = false;
        ((a)localObject2).HbH = false;
        ((a)localObject2).HbG = false;
        ((a)localObject2).qbC = w.pF(localam.field_username);
        if ((((a)localObject2).qbC) && (((a)localObject2).HbG) && (localam.field_unReadCount > 0))
        {
          bool = true;
          ((a)localObject2).HbE = bool;
          ((a)localObject2).nBH = 0;
          if ((OV(localam.field_msgType) == 34) && (localam.field_isSend == 0) && (!bt.isNullOrNil(localam.field_content)))
          {
            String str1 = localam.field_content;
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
            if (!new p((String)localObject1).hAc) {
              ((a)localObject2).nBH = 1;
            }
          }
          localObject1 = v.sh(str2);
          if ((!((a)localObject2).qbC) || (localObject1 != null)) {
            break label1237;
          }
          ((a)localObject2).nickName = SettingCheckUnProcessWalletConvUI.this.getString(2131757293);
          label724:
          ((a)localObject2).Hbw = i(localam);
          ((a)localObject2).Hbx = c(localam, (int)paramViewGroup.Ghg.getTextSize(), ((a)localObject2).HbE);
          ((a)localObject2).HbI = localam.field_attrflag;
        }
      }
      else
      {
        switch (localam.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label814:
          ((a)localObject2).Hby = paramInt;
          ((a)localObject2).HbB = w.a(localam);
          az.arV();
          ((a)localObject2).Ghb = com.tencent.mm.model.c.apR().h(localam);
          ((a)localObject2).HbC = false;
          ((a)localObject2).HbD = ac.eFq();
          this.GgX.put(str2, localObject2);
          localObject1 = localObject2;
          if (((a)localObject1).Hbw == null) {
            ((a)localObject1).Hbw = i(localam);
          }
          if ((((a)localObject1).HbE) || (w.td(localam.field_parentRef)))
          {
            paramViewGroup.Ghg.setTextColor(this.GgV[0]);
            label930:
            if (!str2.toLowerCase().endsWith("@t.qq.com")) {
              break label1308;
            }
            paramViewGroup.Ghe.setCompoundRightDrawablesWithIntrinsicBounds(2131232700);
            paramViewGroup.Ghe.setDrawRightDrawable(true);
            label961:
            paramInt = ((a)localObject1).Hby;
            if (paramInt == -1) {
              break label1319;
            }
            paramViewGroup.Ghg.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
            paramViewGroup.Ghg.setDrawLeftDrawable(true);
            label988:
            paramViewGroup.Ghe.setText(((a)localObject1).nickName);
            paramViewGroup.HbK.setVisibility(8);
            localObject2 = paramViewGroup.Ghf.getLayoutParams();
            if (((a)localObject1).Hbw.length() <= 9) {
              break label1330;
            }
            if (((ViewGroup.LayoutParams)localObject2).width != this.Hbo)
            {
              ((ViewGroup.LayoutParams)localObject2).width = this.Hbo;
              paramViewGroup.Ghf.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
            label1063:
            ad.v("MicroMsg.SettingCheckUnProcessWalletConvUI", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
            paramViewGroup.Ghf.setText(((a)localObject1).Hbw);
            paramViewGroup.Ghg.setText(((a)localObject1).Hbx);
            if ((!((a)localObject1).qbC) || (!((a)localObject1).HbG)) {
              break label1363;
            }
            paramViewGroup.Ghh.setVisibility(0);
            label1135:
            a.b.c(paramViewGroup.frr, str2);
            if ((!((a)localObject1).HbB) && (((a)localObject1).Ghb) && (az.afw()))
            {
              az.arV();
              com.tencent.mm.model.c.apR().g(localam);
            }
            if ((!((a)localObject1).Ghb) || (localam.field_conversationTime == -1L)) {
              break label1394;
            }
            paramView.findViewById(2131298792).setBackgroundResource(2131231817);
          }
          break;
        }
      }
      for (;;)
      {
        paramViewGroup.Ghi.setVisibility(8);
        AppMethodBeat.o(38747);
        return paramView;
        bool = false;
        break;
        label1237:
        ((a)localObject2).nickName = com.tencent.mm.pluginsdk.ui.span.k.b(SettingCheckUnProcessWalletConvUI.this, v.sh(str2), paramViewGroup.Ghe.getTextSize());
        break label724;
        paramInt = -1;
        break label814;
        paramInt = 2131690878;
        break label814;
        paramInt = -1;
        break label814;
        paramInt = 2131690877;
        break label814;
        paramViewGroup.Ghg.setTextColor(this.GgV[localObject1.nBH]);
        break label930;
        label1308:
        paramViewGroup.Ghe.setDrawRightDrawable(false);
        break label961;
        label1319:
        paramViewGroup.Ghg.setDrawLeftDrawable(false);
        break label988;
        label1330:
        if (((ViewGroup.LayoutParams)localObject2).width == this.Hbn) {
          break label1063;
        }
        ((ViewGroup.LayoutParams)localObject2).width = this.Hbn;
        paramViewGroup.Ghf.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break label1063;
        label1363:
        if (((a)localObject1).HbC)
        {
          paramViewGroup.Ghh.setVisibility(0);
          break label1135;
        }
        paramViewGroup.Ghh.setVisibility(8);
        break label1135;
        label1394:
        paramView.findViewById(2131298792).setBackgroundResource(2131231818);
      }
    }
    
    final class a
    {
      public boolean Ghb;
      public int HbA;
      public boolean HbB;
      public boolean HbC;
      public boolean HbD;
      public boolean HbE;
      public boolean HbF;
      public boolean HbG;
      public boolean HbH;
      public int HbI;
      public CharSequence Hbw;
      public CharSequence Hbx;
      public int Hby;
      public int Hbz;
      public int nBH;
      public CharSequence nickName;
      public boolean qbC;
      
      private a() {}
    }
    
    final class b
    {
      public NoMeasuredTextView Ghe;
      public NoMeasuredTextView Ghf;
      public NoMeasuredTextView Ghg;
      public ImageView Ghh;
      public ImageView Ghi;
      public View Ghj;
      public NoMeasuredTextView HbK;
      public ImageView HbL;
      public ImageView frr;
      public TextView mRr;
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI
 * JD-Core Version:    0.7.0.1
 */