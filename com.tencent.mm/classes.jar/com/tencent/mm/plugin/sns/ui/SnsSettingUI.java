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
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsSettingUI
  extends MMActivity
{
  private a EJb;
  private String TAG;
  private LinkedList hUG;
  private ListView hUI;
  
  public SnsSettingUI()
  {
    AppMethodBeat.i(203651);
    this.TAG = "MicroMsg.SnsSettingUI";
    this.hUG = new LinkedList();
    this.EJb = new a();
    this.hUI = null;
    AppMethodBeat.o(203651);
  }
  
  private static int[] L(int... paramVarArgs)
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
  
  private static List<String> P(String... paramVarArgs)
  {
    AppMethodBeat.i(203653);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 2)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(203653);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131496484;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203652);
    super.onCreate(paramBundle);
    this.hUI = ((ListView)findViewById(2131308197));
    this.hUI.setAdapter(this.EJb);
    this.hUG.add(new c("清空朋友圈漏读提醒", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203637);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = aj.faZ();
        try
        {
          s.deleteFile(paramAnonymousView.DNm);
          com.tencent.mm.ui.base.u.makeText(MMApplicationContext.getContext(), "好了", 1).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203637);
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
    this.hUG.add(new c("朋友圈缩略图下载", "进行套图下载", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203638);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        be.EGH = 1;
        h.c(SnsSettingUI.this, "已调整到套图下载，即刻生效！", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203638);
      }
    }));
    this.hUG.add(new c("朋友圈缩略图下载", "进行单图下载", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203639);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        be.EGH = 2;
        h.c(SnsSettingUI.this, "已调整到单图下载，即刻生效！", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203639);
      }
    }));
    this.hUG.add(new c("朋友圈缩略图下载", "目前状态", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203640);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        switch (be.EGH)
        {
        default: 
          if (be.fiv()) {
            h.c(SnsSettingUI.this, "套图下载", "", true);
          }
          break;
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203640);
          return;
          h.c(SnsSettingUI.this, "套图下载", "", true);
          continue;
          h.c(SnsSettingUI.this, "单图下载", "", true);
          continue;
          h.c(SnsSettingUI.this, "单图下载", "", true);
        }
      }
    }));
    this.hUG.add(new c("朋友圈预加载cgi触发", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203641);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        g.aAi();
        g.aAg().hqi.a(new com.tencent.mm.plugin.sns.model.u(), 0);
        h.c(SnsSettingUI.this, "妥了", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203641);
      }
    }));
    this.hUG.add(new b("朋友圈微商折叠辅助工具", ar.a.Ooo, P(new String[] { "关", "开" }), L(new int[] { 0, 1 })));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(203642);
        SnsSettingUI.this.finish();
        AppMethodBeat.o(203642);
        return false;
      }
    });
    AppMethodBeat.o(203652);
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
      AppMethodBeat.i(203644);
      int i = SnsSettingUI.c(SnsSettingUI.this).size();
      AppMethodBeat.o(203644);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(203645);
      Object localObject = SnsSettingUI.c(SnsSettingUI.this).get(paramInt);
      AppMethodBeat.o(203645);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(203646);
      paramView = new TextView(SnsSettingUI.this);
      paramViewGroup = (SnsSettingUI.d)getItem(paramInt);
      paramView.setTag(paramViewGroup);
      paramView.setText(paramViewGroup.auk() + "->:" + paramViewGroup.value());
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(203643);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramViewGroup.cp(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203643);
        }
      });
      AppMethodBeat.o(203646);
      return paramView;
    }
  }
  
  final class b
    implements SnsSettingUI.d
  {
    String hUN = "";
    ar.a hUO = null;
    Object hUQ = null;
    List<String> vQe = null;
    
    public b(ar.a parama, List<String> paramList, Object paramObject)
    {
      this.hUN = parama;
      this.hUO = paramList;
      this.vQe = paramObject;
      Object localObject;
      this.hUQ = localObject;
    }
    
    public final String auk()
    {
      return this.hUN;
    }
    
    public final void cp(View paramView)
    {
      AppMethodBeat.i(203649);
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < this.vQe.size())
      {
        paramView.add(this.vQe.get(i));
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      h.a(SnsSettingUI.this, "", paramView, localLinkedList, "", new h.e()
      {
        public final void cy(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(203647);
          try
          {
            if ((SnsSettingUI.b.this.hUQ instanceof int[]))
            {
              paramAnonymousInt1 = ((int[])(int[])SnsSettingUI.b.this.hUQ)[paramAnonymousInt1];
              g.aAh().azQ().set(SnsSettingUI.b.this.hUO, Integer.valueOf(paramAnonymousInt1));
            }
            for (;;)
            {
              SnsSettingUI.a(SnsSettingUI.this).notifyDataSetChanged();
              AppMethodBeat.o(203647);
              return;
              if ((SnsSettingUI.b.this.hUQ instanceof long[]))
              {
                long l = ((long[])(long[])SnsSettingUI.b.this.hUQ)[paramAnonymousInt1];
                g.aAh().azQ().set(SnsSettingUI.b.this.hUO, Long.valueOf(l));
              }
            }
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace(SnsSettingUI.b(SnsSettingUI.this), localException, "", new Object[0]);
            AppMethodBeat.o(203647);
          }
        }
      });
      AppMethodBeat.o(203649);
    }
    
    public final String value()
    {
      AppMethodBeat.i(203648);
      Object localObject = "";
      if ((this.hUQ instanceof int[]))
      {
        j = g.aAh().azQ().getInt(this.hUO, 0);
        str = (String)this.vQe.get(0);
        i = 0;
        localObject = str;
        if (i < ((int[])this.hUQ).length)
        {
          if ((j != ((int[])(int[])this.hUQ)[i]) || (i >= this.vQe.size())) {
            break label122;
          }
          localObject = (String)this.vQe.get(i);
        }
      }
      label122:
      while (!(this.hUQ instanceof long[])) {
        for (;;)
        {
          int j;
          AppMethodBeat.o(203648);
          return localObject;
          i += 1;
        }
      }
      long l = g.aAh().azQ().a(this.hUO, 0L);
      String str = (String)this.vQe.get(0);
      int i = 0;
      for (;;)
      {
        localObject = str;
        if (i >= ((long[])this.hUQ).length) {
          break;
        }
        if ((l == ((long[])(long[])this.hUQ)[i]) && (i < this.vQe.size()))
        {
          localObject = (String)this.vQe.get(i);
          break;
        }
        i += 1;
      }
    }
  }
  
  final class c
    implements SnsSettingUI.d
  {
    private View.OnClickListener EJh = null;
    private String title = null;
    private String value = null;
    
    public c(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
    {
      this.title = paramString1;
      this.value = paramString2;
      this.EJh = paramOnClickListener;
    }
    
    public final String auk()
    {
      return this.title;
    }
    
    public final void cp(View paramView)
    {
      AppMethodBeat.i(203650);
      this.EJh.onClick(paramView);
      com.tencent.mm.ui.base.u.makeText(MMApplicationContext.getContext(), "ClickItem Done", 1).show();
      AppMethodBeat.o(203650);
    }
    
    public final String value()
    {
      return this.value;
    }
  }
  
  static abstract interface d
  {
    public abstract String auk();
    
    public abstract void cp(View paramView);
    
    public abstract String value();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSettingUI
 * JD-Core Version:    0.7.0.1
 */