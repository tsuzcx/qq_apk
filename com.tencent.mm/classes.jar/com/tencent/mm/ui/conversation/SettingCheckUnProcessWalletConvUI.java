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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.u;
import java.util.HashMap;
import java.util.List;

public class SettingCheckUnProcessWalletConvUI
  extends MMActivity
{
  private List<String> IGB;
  private a IGC;
  private ListView iWK;
  private int[] snC;
  
  public SettingCheckUnProcessWalletConvUI()
  {
    AppMethodBeat.i(38753);
    this.snC = new int[2];
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
    this.iWK = ((ListView)findViewById(2131298790));
    this.IGB = getIntent().getStringArrayListExtra("key_conversation_list");
    if ((this.IGB != null) && (this.IGB.size() > 0))
    {
      this.IGC = new a();
      this.iWK.setAdapter(this.IGC);
      this.iWK.setOnTouchListener(new View.OnTouchListener()
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
      this.iWK.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38739);
          paramAnonymousAdapterView = SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.this).aci(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(38739);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
          paramAnonymousView.putExtra("chat_from_scene", 4);
          com.tencent.mm.br.d.e(SettingCheckUnProcessWalletConvUI.this, ".ui.chatting.ChattingUI", paramAnonymousView);
          AppMethodBeat.o(38739);
        }
      });
      this.iWK.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38743);
          paramAnonymousAdapterView = SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.this).aci(paramAnonymousInt - SettingCheckUnProcessWalletConvUI.c(SettingCheckUnProcessWalletConvUI.this).getHeaderViewsCount());
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(38743);
            return true;
          }
          final String str = paramAnonymousAdapterView.field_username;
          com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a(SettingCheckUnProcessWalletConvUI.this);
          locala.JiR = new View.OnCreateContextMenuListener()
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
                    SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.this).remove(SettingCheckUnProcessWalletConvUI.4.2.this.fLg);
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
    private float HGF;
    protected float HGI;
    private float HGJ;
    private ColorStateList[] HGK;
    private HashMap<String, a> HGM;
    private final int IBu;
    private final int IBv;
    
    public a()
    {
      AppMethodBeat.i(38744);
      this.HGK = new ColorStateList[5];
      this.HGF = -1.0F;
      this.HGI = -1.0F;
      this.HGJ = -1.0F;
      this.HGK[0] = com.tencent.mm.cc.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100490);
      this.HGK[1] = com.tencent.mm.cc.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100643);
      this.HGK[3] = com.tencent.mm.cc.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100711);
      this.HGK[2] = com.tencent.mm.cc.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100640);
      this.HGK[2] = com.tencent.mm.cc.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100640);
      this.HGK[4] = com.tencent.mm.cc.a.m(SettingCheckUnProcessWalletConvUI.this, 2131100543);
      if (com.tencent.mm.cc.a.id(SettingCheckUnProcessWalletConvUI.this)) {
        this.IBv = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165245);
      }
      for (this.IBu = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165247);; this.IBu = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165248))
      {
        this.HGF = com.tencent.mm.cc.a.au(SettingCheckUnProcessWalletConvUI.this, 2131165517);
        this.HGI = com.tencent.mm.cc.a.au(SettingCheckUnProcessWalletConvUI.this, 2131165466);
        this.HGJ = com.tencent.mm.cc.a.au(SettingCheckUnProcessWalletConvUI.this, 2131165576);
        this.HGM = new HashMap();
        AppMethodBeat.o(38744);
        return;
        this.IBv = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(2131165244);
      }
    }
    
    private static int Tf(String paramString)
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
    
    private static String aPU(String paramString)
    {
      AppMethodBeat.i(38751);
      if ((paramString != null) && (paramString.length() == 32))
      {
        paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XP(paramString);
        AppMethodBeat.o(38751);
        return paramString;
      }
      AppMethodBeat.o(38751);
      return null;
    }
    
    private CharSequence c(ap paramap, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(38750);
      if ((!bs.isNullOrNil(paramap.field_editingMsg)) && ((paramap.field_atCount <= 0) || (paramap.field_unReadCount <= 0)))
      {
        localObject1 = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(2131761048));
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(SettingCheckUnProcessWalletConvUI.this, paramap.field_editingMsg, paramInt));
        AppMethodBeat.o(38750);
        return localObject1;
      }
      Object localObject1 = paramap.field_digest;
      if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
      {
        paramap = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.e(SettingCheckUnProcessWalletConvUI.this, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38750);
        return paramap;
      }
      localObject1 = paramap.field_username;
      int i;
      if (((String)localObject1).equals("qqmail"))
      {
        com.tencent.mm.model.az.ayM();
        if (bs.m((Integer)com.tencent.mm.model.c.agA().get(17, null)) == 1) {}
        for (i = 1; i == 0; i = 0)
        {
          paramap = SettingCheckUnProcessWalletConvUI.this.getString(2131763356);
          AppMethodBeat.o(38750);
          return paramap;
        }
      }
      if (((String)localObject1).equals("tmessage"))
      {
        com.tencent.mm.model.az.ayM();
        localObject1 = com.tencent.mm.model.c.awJ().alJ("@t.qq.com");
        if ((localObject1 != null) && (((bu)localObject1).isEnable())) {}
        for (i = 1; i == 0; i = 0)
        {
          paramap = SettingCheckUnProcessWalletConvUI.this.getString(2131763356);
          AppMethodBeat.o(38750);
          return paramap;
        }
      }
      String str1;
      if ((paramap.field_msgType != null) && ((paramap.field_msgType.equals("47")) || (paramap.field_msgType.equals("1048625"))))
      {
        localObject1 = aPU(paramap.field_digest);
        str1 = "";
        if (localObject1 != null)
        {
          paramap = "[" + (String)localObject1 + "]";
          AppMethodBeat.o(38750);
          return paramap;
        }
        localObject1 = str1;
        if (paramap.field_digest != null)
        {
          localObject1 = str1;
          if (paramap.field_digest.contains(":"))
          {
            str1 = paramap.field_digest.substring(0, paramap.field_digest.indexOf(":"));
            String str2 = aPU(paramap.field_digest.substring(paramap.field_digest.indexOf(":") + 1).replace(" ", ""));
            localObject1 = str1;
            if (str2 != null)
            {
              paramap = "[" + str2 + "]";
              if (bs.isNullOrNil(str1))
              {
                AppMethodBeat.o(38750);
                return paramap;
              }
              paramap = str1 + ": " + paramap;
              AppMethodBeat.o(38750);
              return paramap;
            }
          }
        }
        str1 = SettingCheckUnProcessWalletConvUI.this.getString(2131755722);
        if (bs.isNullOrNil((String)localObject1))
        {
          localObject1 = str1;
          paramap.qR((String)localObject1);
        }
      }
      else
      {
        if (bs.isNullOrNil(paramap.field_digest)) {
          break label775;
        }
        if (bs.isNullOrNil(paramap.field_digestUser)) {
          break label764;
        }
        if ((paramap.field_isSend != 0) || (!w.sQ(paramap.field_username))) {
          break label752;
        }
        localObject1 = v.getDisplayName(paramap.field_digestUser, paramap.field_username);
      }
      label752:
      label764:
      Object localObject2;
      for (;;)
      {
        try
        {
          localObject1 = String.format(paramap.field_digest, new Object[] { localObject1 });
          str1 = ((String)localObject1).replace('\n', ' ');
          if ((paramap.field_atCount <= 0) || (paramap.field_unReadCount <= 0)) {
            break label806;
          }
          paramap = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(2131761044));
          paramap.setSpan(new ForegroundColorSpan(-5569532), 0, paramap.length(), 33);
          paramap.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(SettingCheckUnProcessWalletConvUI.this, str1, paramInt));
          AppMethodBeat.o(38750);
          return paramap;
        }
        catch (Exception localException) {}
        localObject1 = (String)localObject1 + ": " + str1;
        break;
        localObject1 = v.wk(paramap.field_digestUser);
        continue;
        localObject1 = paramap.field_digest;
        continue;
        label775:
        localObject2 = com.tencent.mm.booter.notification.a.h.a(paramap.field_isSend, paramap.field_username, paramap.field_content, Tf(paramap.field_msgType), SettingCheckUnProcessWalletConvUI.this);
      }
      label806:
      if ((paramBoolean) && (paramap.field_unReadCount > 1)) {
        localObject2 = SettingCheckUnProcessWalletConvUI.this.getString(2131761047, new Object[] { Integer.valueOf(paramap.field_unReadCount), str1 });
      }
      for (;;)
      {
        paramap = com.tencent.mm.pluginsdk.ui.span.k.b(SettingCheckUnProcessWalletConvUI.this, (CharSequence)localObject2, paramInt);
        AppMethodBeat.o(38750);
        return paramap;
        localObject2 = str1;
        if (paramap.field_unReadCount > 1)
        {
          localObject2 = str1;
          if (w.xg(paramap.field_parentRef)) {
            localObject2 = SettingCheckUnProcessWalletConvUI.this.getString(2131761047, new Object[] { Integer.valueOf(paramap.field_unReadCount), str1 });
          }
        }
      }
    }
    
    private CharSequence i(ap paramap)
    {
      AppMethodBeat.i(38749);
      if (paramap.field_status == 1)
      {
        paramap = SettingCheckUnProcessWalletConvUI.this.getString(2131761075);
        AppMethodBeat.o(38749);
        return paramap;
      }
      if (paramap.field_conversationTime == 9223372036854775807L)
      {
        AppMethodBeat.o(38749);
        return "";
      }
      paramap = com.tencent.mm.pluginsdk.g.h.c(SettingCheckUnProcessWalletConvUI.this, paramap.field_conversationTime, true);
      AppMethodBeat.o(38749);
      return paramap;
    }
    
    public final ap aci(int paramInt)
    {
      AppMethodBeat.i(38746);
      Object localObject = (String)SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.this).get(paramInt);
      com.tencent.mm.model.az.ayM();
      localObject = com.tencent.mm.model.c.awG().aNI((String)localObject);
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
        if (com.tencent.mm.cc.a.id(SettingCheckUnProcessWalletConvUI.this))
        {
          paramView = View.inflate(SettingCheckUnProcessWalletConvUI.this, 2131493663, null);
          paramViewGroup.fuY = ((ImageView)paramView.findViewById(2131297008));
          paramViewGroup.HGT = ((NoMeasuredTextView)paramView.findViewById(2131302867));
          paramViewGroup.IBQ = ((NoMeasuredTextView)paramView.findViewById(2131305134));
          paramViewGroup.HGU = ((NoMeasuredTextView)paramView.findViewById(2131306207));
          paramViewGroup.HGV = ((NoMeasuredTextView)paramView.findViewById(2131301311));
          paramViewGroup.ntH = ((TextView)paramView.findViewById(2131305882));
          paramViewGroup.ntH.setBackgroundResource(u.ks(SettingCheckUnProcessWalletConvUI.this));
          paramViewGroup.HGW = ((ImageView)paramView.findViewById(2131300954));
          paramViewGroup.HGY = paramView.findViewById(2131297015);
          paramViewGroup.HGX = ((ImageView)paramView.findViewById(2131305672));
          paramViewGroup.IBR = ((ImageView)paramView.findViewById(2131301541));
          paramView.setTag(paramViewGroup);
          paramViewGroup.HGV.setTextSize(0, this.HGI);
          paramViewGroup.HGU.setTextSize(0, this.HGJ);
          paramViewGroup.HGT.setTextSize(0, this.HGF);
          paramViewGroup.IBQ.setTextSize(0, this.HGI);
          paramViewGroup.HGV.setTextColor(this.HGK[0]);
          paramViewGroup.HGU.setTextColor(this.HGK[4]);
          paramViewGroup.HGT.setTextColor(this.HGK[3]);
          paramViewGroup.IBQ.setTextColor(this.HGK[0]);
          paramViewGroup.HGV.setShouldEllipsize(true);
          paramViewGroup.HGU.setShouldEllipsize(false);
          paramViewGroup.HGT.setShouldEllipsize(true);
          paramViewGroup.IBQ.setShouldEllipsize(true);
          paramViewGroup.HGU.setGravity(5);
        }
      }
      ap localap;
      for (;;)
      {
        localap = aci(paramInt);
        if (localap != null) {
          break label384;
        }
        AppMethodBeat.o(38747);
        return paramView;
        paramView = View.inflate(SettingCheckUnProcessWalletConvUI.this, 2131493662, null);
        break;
        paramViewGroup = (b)paramView.getTag();
      }
      label384:
      a.b.c(paramViewGroup.fuY, localap.field_username);
      paramViewGroup.fuY.getDrawable();
      String str2 = localap.field_username;
      Object localObject2 = (a)this.HGM.get(str2);
      Object localObject1 = localObject2;
      boolean bool;
      if (localObject2 == null)
      {
        localObject2 = new a((byte)0);
        ((a)localObject2).IBG = -1;
        ((a)localObject2).IBF = -1;
        ((a)localObject2).IBL = false;
        ((a)localObject2).IBN = false;
        ((a)localObject2).IBM = false;
        ((a)localObject2).qKi = w.sQ(localap.field_username);
        if ((((a)localObject2).qKi) && (((a)localObject2).IBM) && (localap.field_unReadCount > 0))
        {
          bool = true;
          ((a)localObject2).IBK = bool;
          ((a)localObject2).oeH = 0;
          if ((Tf(localap.field_msgType) == 34) && (localap.field_isSend == 0) && (!bs.isNullOrNil(localap.field_content)))
          {
            String str1 = localap.field_content;
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
            if (!new p((String)localObject1).iaD) {
              ((a)localObject2).oeH = 1;
            }
          }
          localObject1 = v.wk(str2);
          if ((!((a)localObject2).qKi) || (localObject1 != null)) {
            break label1237;
          }
          ((a)localObject2).nickName = SettingCheckUnProcessWalletConvUI.this.getString(2131757293);
          label724:
          ((a)localObject2).IBC = i(localap);
          ((a)localObject2).IBD = c(localap, (int)paramViewGroup.HGV.getTextSize(), ((a)localObject2).IBK);
          ((a)localObject2).IBO = localap.field_attrflag;
        }
      }
      else
      {
        switch (localap.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label814:
          ((a)localObject2).IBE = paramInt;
          ((a)localObject2).IBH = w.a(localap);
          com.tencent.mm.model.az.ayM();
          ((a)localObject2).HGQ = com.tencent.mm.model.c.awG().h(localap);
          ((a)localObject2).IBI = false;
          ((a)localObject2).IBJ = ab.eUK();
          this.HGM.put(str2, localObject2);
          localObject1 = localObject2;
          if (((a)localObject1).IBC == null) {
            ((a)localObject1).IBC = i(localap);
          }
          if ((((a)localObject1).IBK) || (w.xg(localap.field_parentRef)))
          {
            paramViewGroup.HGV.setTextColor(this.HGK[0]);
            label930:
            if (!str2.toLowerCase().endsWith("@t.qq.com")) {
              break label1308;
            }
            paramViewGroup.HGT.setCompoundRightDrawablesWithIntrinsicBounds(2131232700);
            paramViewGroup.HGT.setDrawRightDrawable(true);
            label961:
            paramInt = ((a)localObject1).IBE;
            if (paramInt == -1) {
              break label1319;
            }
            paramViewGroup.HGV.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
            paramViewGroup.HGV.setDrawLeftDrawable(true);
            label988:
            paramViewGroup.HGT.setText(((a)localObject1).nickName);
            paramViewGroup.IBQ.setVisibility(8);
            localObject2 = paramViewGroup.HGU.getLayoutParams();
            if (((a)localObject1).IBC.length() <= 9) {
              break label1330;
            }
            if (((ViewGroup.LayoutParams)localObject2).width != this.IBv)
            {
              ((ViewGroup.LayoutParams)localObject2).width = this.IBv;
              paramViewGroup.HGU.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
            label1063:
            ac.v("MicroMsg.SettingCheckUnProcessWalletConvUI", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
            paramViewGroup.HGU.setText(((a)localObject1).IBC);
            paramViewGroup.HGV.setText(((a)localObject1).IBD);
            if ((!((a)localObject1).qKi) || (!((a)localObject1).IBM)) {
              break label1363;
            }
            paramViewGroup.HGW.setVisibility(0);
            label1135:
            a.b.c(paramViewGroup.fuY, str2);
            if ((!((a)localObject1).IBH) && (((a)localObject1).HGQ) && (com.tencent.mm.model.az.agM()))
            {
              com.tencent.mm.model.az.ayM();
              com.tencent.mm.model.c.awG().g(localap);
            }
            if ((!((a)localObject1).HGQ) || (localap.field_conversationTime == -1L)) {
              break label1394;
            }
            paramView.findViewById(2131298792).setBackgroundResource(2131231817);
          }
          break;
        }
      }
      for (;;)
      {
        paramViewGroup.HGX.setVisibility(8);
        AppMethodBeat.o(38747);
        return paramView;
        bool = false;
        break;
        label1237:
        ((a)localObject2).nickName = com.tencent.mm.pluginsdk.ui.span.k.b(SettingCheckUnProcessWalletConvUI.this, v.wk(str2), paramViewGroup.HGT.getTextSize());
        break label724;
        paramInt = -1;
        break label814;
        paramInt = 2131690878;
        break label814;
        paramInt = -1;
        break label814;
        paramInt = 2131690877;
        break label814;
        paramViewGroup.HGV.setTextColor(this.HGK[localObject1.oeH]);
        break label930;
        label1308:
        paramViewGroup.HGT.setDrawRightDrawable(false);
        break label961;
        label1319:
        paramViewGroup.HGV.setDrawLeftDrawable(false);
        break label988;
        label1330:
        if (((ViewGroup.LayoutParams)localObject2).width == this.IBu) {
          break label1063;
        }
        ((ViewGroup.LayoutParams)localObject2).width = this.IBu;
        paramViewGroup.HGU.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break label1063;
        label1363:
        if (((a)localObject1).IBI)
        {
          paramViewGroup.HGW.setVisibility(0);
          break label1135;
        }
        paramViewGroup.HGW.setVisibility(8);
        break label1135;
        label1394:
        paramView.findViewById(2131298792).setBackgroundResource(2131231818);
      }
    }
    
    final class a
    {
      public boolean HGQ;
      public CharSequence IBC;
      public CharSequence IBD;
      public int IBE;
      public int IBF;
      public int IBG;
      public boolean IBH;
      public boolean IBI;
      public boolean IBJ;
      public boolean IBK;
      public boolean IBL;
      public boolean IBM;
      public boolean IBN;
      public int IBO;
      public CharSequence nickName;
      public int oeH;
      public boolean qKi;
      
      private a() {}
    }
    
    final class b
    {
      public NoMeasuredTextView HGT;
      public NoMeasuredTextView HGU;
      public NoMeasuredTextView HGV;
      public ImageView HGW;
      public ImageView HGX;
      public View HGY;
      public NoMeasuredTextView IBQ;
      public ImageView IBR;
      public ImageView fuY;
      public TextView ntH;
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI
 * JD-Core Version:    0.7.0.1
 */