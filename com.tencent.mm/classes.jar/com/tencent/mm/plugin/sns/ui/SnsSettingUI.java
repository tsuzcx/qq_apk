package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsSettingUI
  extends MMActivity
{
  private a KXd;
  private String TAG;
  private LinkedList kJf;
  private ListView kJh;
  
  public SnsSettingUI()
  {
    AppMethodBeat.i(208833);
    this.TAG = "MicroMsg.SnsSettingUI";
    this.kJf = new LinkedList();
    this.KXd = new a();
    this.kJh = null;
    AppMethodBeat.o(208833);
  }
  
  private static int[] K(int... paramVarArgs)
  {
    int[] arrayOfInt = new int[2];
    int i = 0;
    while (i < 2)
    {
      arrayOfInt[i] = paramVarArgs[i];
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static List<String> Q(String... paramVarArgs)
  {
    AppMethodBeat.i(208839);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 2)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(208839);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return i.g.sns_setting_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(208837);
    super.onCreate(paramBundle);
    if (!WeChatEnvironment.hasDebugger())
    {
      finish();
      AppMethodBeat.o(208837);
      return;
    }
    this.kJh = ((ListView)findViewById(i.f.sns_profile));
    this.kJh.setAdapter(this.KXd);
    this.kJf.add(new c("清空朋友圈漏读提醒", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(244260);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = aj.fOT();
        try
        {
          com.tencent.mm.vfs.u.deleteFile(paramAnonymousView.Kao);
          w.makeText(MMApplicationContext.getContext(), "好了", 1).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(244260);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            Log.w("MicroMsg.SnsUnreadTipManager", "removeLastFault error:%s", new Object[] { paramAnonymousView.getMessage() });
          }
        }
      }
    }));
    this.kJf.add(new c("朋友圈缩略图下载", "进行套图下载", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(270117);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        bg.KUB = 1;
        com.tencent.mm.ui.base.h.c(SnsSettingUI.this, "已调整到套图下载，即刻生效！", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(270117);
      }
    }));
    this.kJf.add(new c("朋友圈缩略图下载", "进行单图下载", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(222257);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        bg.KUB = 2;
        com.tencent.mm.ui.base.h.c(SnsSettingUI.this, "已调整到单图下载，即刻生效！", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(222257);
      }
    }));
    this.kJf.add(new c("朋友圈缩略图下载", "目前状态", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(270258);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        switch (bg.KUB)
        {
        default: 
          if (bg.fWH()) {
            com.tencent.mm.ui.base.h.c(SnsSettingUI.this, "套图下载", "", true);
          }
          break;
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(270258);
          return;
          com.tencent.mm.ui.base.h.c(SnsSettingUI.this, "套图下载", "", true);
          continue;
          com.tencent.mm.ui.base.h.c(SnsSettingUI.this, "单图下载", "", true);
          continue;
          com.tencent.mm.ui.base.h.c(SnsSettingUI.this, "单图下载", "", true);
        }
      }
    }));
    this.kJf.add(new c("朋友圈预加载cgi触发", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(209853);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (com.tencent.mm.kernel.h.aHB()) {
          com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.sns.model.u(), 0);
        }
        com.tencent.mm.ui.base.h.c(SnsSettingUI.this, "妥了", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(209853);
      }
    }));
    this.kJf.add(new b("朋友圈微商折叠辅助工具", ar.a.VDH, Q(new String[] { "关", "开" }), K(new int[] { 0, 1 })));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(242104);
        SnsSettingUI.this.finish();
        AppMethodBeat.o(242104);
        return false;
      }
    });
    AppMethodBeat.o(208837);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(228351);
      int i = SnsSettingUI.c(SnsSettingUI.this).size();
      AppMethodBeat.o(228351);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(228352);
      Object localObject = SnsSettingUI.c(SnsSettingUI.this).get(paramInt);
      AppMethodBeat.o(228352);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(228358);
      paramView = new TextView(SnsSettingUI.this);
      paramViewGroup = (SnsSettingUI.d)getItem(paramInt);
      paramView.setTag(paramViewGroup);
      paramView.setText(paramViewGroup.aBd() + "->:" + paramViewGroup.value());
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(267373);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramViewGroup.cI(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(267373);
        }
      });
      AppMethodBeat.o(228358);
      return paramView;
    }
  }
  
  final class b
    implements SnsSettingUI.d
  {
    List<String> Axc = null;
    String kJm = "";
    ar.a kJn = null;
    Object kJp = null;
    
    public b(ar.a parama, List<String> paramList, Object paramObject)
    {
      this.kJm = parama;
      this.kJn = paramList;
      this.Axc = paramObject;
      Object localObject;
      this.kJp = localObject;
    }
    
    public final String aBd()
    {
      return this.kJm;
    }
    
    public final void cI(View paramView)
    {
      AppMethodBeat.i(238015);
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < this.Axc.size())
      {
        paramView.add(this.Axc.get(i));
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      com.tencent.mm.ui.base.h.a(SnsSettingUI.this, "", paramView, localLinkedList, "", new h.e()
      {
        public final void cS(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(209832);
          try
          {
            if ((SnsSettingUI.b.this.kJp instanceof int[]))
            {
              paramAnonymousInt1 = ((int[])(int[])SnsSettingUI.b.this.kJp)[paramAnonymousInt1];
              if (com.tencent.mm.kernel.h.aHB()) {
                com.tencent.mm.kernel.h.aHG().aHp().set(SnsSettingUI.b.this.kJn, Integer.valueOf(paramAnonymousInt1));
              }
            }
            for (;;)
            {
              SnsSettingUI.a(SnsSettingUI.this).notifyDataSetChanged();
              AppMethodBeat.o(209832);
              return;
              if ((SnsSettingUI.b.this.kJp instanceof long[]))
              {
                long l = ((long[])(long[])SnsSettingUI.b.this.kJp)[paramAnonymousInt1];
                if (com.tencent.mm.kernel.h.aHB()) {
                  com.tencent.mm.kernel.h.aHG().aHp().set(SnsSettingUI.b.this.kJn, Long.valueOf(l));
                }
              }
            }
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace(SnsSettingUI.b(SnsSettingUI.this), localException, "", new Object[0]);
            AppMethodBeat.o(209832);
          }
        }
      });
      AppMethodBeat.o(238015);
    }
    
    public final String value()
    {
      AppMethodBeat.i(238012);
      String str2 = "";
      String str1;
      if ((this.kJp instanceof int[]))
      {
        str1 = str2;
        if (com.tencent.mm.kernel.h.aHB())
        {
          int j = com.tencent.mm.kernel.h.aHG().aHp().getInt(this.kJn, 0);
          str2 = (String)this.Axc.get(0);
          i = 0;
          str1 = str2;
          if (i < ((int[])this.kJp).length)
          {
            if ((j != ((int[])(int[])this.kJp)[i]) || (i >= this.Axc.size())) {
              break label132;
            }
            str1 = (String)this.Axc.get(i);
          }
        }
      }
      label132:
      do
      {
        do
        {
          AppMethodBeat.o(238012);
          return str1;
          i += 1;
          break;
          str1 = str2;
        } while (!(this.kJp instanceof long[]));
        str1 = str2;
      } while (!com.tencent.mm.kernel.h.aHB());
      long l = com.tencent.mm.kernel.h.aHG().aHp().a(this.kJn, 0L);
      str2 = (String)this.Axc.get(0);
      int i = 0;
      for (;;)
      {
        str1 = str2;
        if (i >= ((long[])this.kJp).length) {
          break;
        }
        if ((l == ((long[])(long[])this.kJp)[i]) && (i < this.Axc.size()))
        {
          str1 = (String)this.Axc.get(i);
          break;
        }
        i += 1;
      }
    }
  }
  
  final class c
    implements SnsSettingUI.d
  {
    private View.OnClickListener KXi = null;
    private String title = null;
    private String value = null;
    
    public c(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
    {
      this.title = paramString1;
      this.value = paramString2;
      this.KXi = paramOnClickListener;
    }
    
    public final String aBd()
    {
      return this.title;
    }
    
    public final void cI(View paramView)
    {
      AppMethodBeat.i(257081);
      this.KXi.onClick(paramView);
      w.makeText(MMApplicationContext.getContext(), "ClickItem Done", 1).show();
      AppMethodBeat.o(257081);
    }
    
    public final String value()
    {
      return this.value;
    }
  }
  
  static abstract interface d
  {
    public abstract String aBd();
    
    public abstract void cI(View paramView);
    
    public abstract String value();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSettingUI
 * JD-Core Version:    0.7.0.1
 */