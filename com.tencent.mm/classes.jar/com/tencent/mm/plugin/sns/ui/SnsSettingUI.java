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
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;

public class SnsSettingUI
  extends MMActivity
{
  private a AzH;
  private LinkedList hbM;
  private ListView hbO;
  
  public SnsSettingUI()
  {
    AppMethodBeat.i(219935);
    this.hbM = new LinkedList();
    this.AzH = new a();
    this.hbO = null;
    AppMethodBeat.o(219935);
  }
  
  public int getLayoutId()
  {
    return 2131496492;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(219936);
    super.onCreate(paramBundle);
    this.hbO = ((ListView)findViewById(2131308431));
    this.hbO.setAdapter(this.AzH);
    this.hbM.add(new b("清空朋友圈漏读提醒", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219924);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = ah.dXN();
        try
        {
          o.deleteFile(paramAnonymousView.zDi);
          com.tencent.mm.ui.base.t.makeText(ak.getContext(), "好了", 1).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219924);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ae.w("MicroMsg.SnsUnreadTipManager", "removeLastFault error:%s", new Object[] { paramAnonymousView.getMessage() });
          }
        }
      }
    }));
    this.hbM.add(new b("朋友圈缩略图下载", "进行套图下载", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219925);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        bb.Axr = 1;
        h.c(SnsSettingUI.this, "已调整到套图下载，即刻生效！", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(219925);
      }
    }));
    this.hbM.add(new b("朋友圈缩略图下载", "进行单图下载", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219926);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        bb.Axr = 2;
        h.c(SnsSettingUI.this, "已调整到单图下载，即刻生效！", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(219926);
      }
    }));
    this.hbM.add(new b("朋友圈缩略图下载", "目前状态", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219927);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        switch (bb.Axr)
        {
        default: 
          if (bb.efV()) {
            h.c(SnsSettingUI.this, "套图下载", "", true);
          }
          break;
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219927);
          return;
          h.c(SnsSettingUI.this, "套图下载", "", true);
          continue;
          h.c(SnsSettingUI.this, "单图下载", "", true);
          continue;
          h.c(SnsSettingUI.this, "单图下载", "", true);
        }
      }
    }));
    this.hbM.add(new b("朋友圈预加载cgi触发", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219928);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        g.ajS();
        g.ajQ().gDv.a(new com.tencent.mm.plugin.sns.model.t(), 0);
        h.c(SnsSettingUI.this, "妥了", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(219928);
      }
    }));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(219929);
        SnsSettingUI.this.finish();
        AppMethodBeat.o(219929);
        return false;
      }
    });
    AppMethodBeat.o(219936);
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
      AppMethodBeat.i(219931);
      int i = SnsSettingUI.a(SnsSettingUI.this).size();
      AppMethodBeat.o(219931);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(219932);
      Object localObject = SnsSettingUI.a(SnsSettingUI.this).get(paramInt);
      AppMethodBeat.o(219932);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(219933);
      paramView = new TextView(SnsSettingUI.this);
      paramViewGroup = (SnsSettingUI.c)getItem(paramInt);
      paramView.setTag(paramViewGroup);
      paramView.setText(paramViewGroup.aeD() + "->:" + paramViewGroup.value());
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(219930);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramViewGroup.cy(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219930);
        }
      });
      AppMethodBeat.o(219933);
      return paramView;
    }
  }
  
  final class b
    implements SnsSettingUI.c
  {
    private View.OnClickListener AzL = null;
    private String title = null;
    private String value = null;
    
    public b(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
    {
      this.title = paramString1;
      this.value = paramString2;
      this.AzL = paramOnClickListener;
    }
    
    public final String aeD()
    {
      return this.title;
    }
    
    public final void cy(View paramView)
    {
      AppMethodBeat.i(219934);
      this.AzL.onClick(paramView);
      com.tencent.mm.ui.base.t.makeText(ak.getContext(), "ClickItem Done", 1).show();
      AppMethodBeat.o(219934);
    }
    
    public final String value()
    {
      return this.value;
    }
  }
  
  static abstract interface c
  {
    public abstract String aeD();
    
    public abstract void cy(View paramView);
    
    public abstract String value();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSettingUI
 * JD-Core Version:    0.7.0.1
 */