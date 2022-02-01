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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

public class SnsSettingUI
  extends MMActivity
{
  private a Aiv;
  private LinkedList gYZ;
  private ListView gZb;
  
  public SnsSettingUI()
  {
    AppMethodBeat.i(198393);
    this.gYZ = new LinkedList();
    this.Aiv = new a();
    this.gZb = null;
    AppMethodBeat.o(198393);
  }
  
  public int getLayoutId()
  {
    return 2131496492;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198394);
    super.onCreate(paramBundle);
    this.gZb = ((ListView)findViewById(2131308431));
    this.gZb.setAdapter(this.Aiv);
    this.gYZ.add(new b("清空朋友圈漏读提醒", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198383);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = ag.dUn();
        try
        {
          i.deleteFile(paramAnonymousView.zlT);
          t.makeText(aj.getContext(), "好了", 1).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198383);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ad.w("MicroMsg.SnsUnreadTipManager", "removeLastFault error:%s", new Object[] { paramAnonymousView.getMessage() });
          }
        }
      }
    }));
    this.gYZ.add(new b("朋友圈缩略图下载", "进行套图下载", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198384);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        bb.Agf = 1;
        h.c(SnsSettingUI.this, "已调整到套图下载，即刻生效！", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198384);
      }
    }));
    this.gYZ.add(new b("朋友圈缩略图下载", "进行单图下载", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198385);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        bb.Agf = 2;
        h.c(SnsSettingUI.this, "已调整到单图下载，即刻生效！", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198385);
      }
    }));
    this.gYZ.add(new b("朋友圈缩略图下载", "目前状态", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198386);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        switch (bb.Agf)
        {
        default: 
          if (bb.eco()) {
            h.c(SnsSettingUI.this, "套图下载", "", true);
          }
          break;
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198386);
          return;
          h.c(SnsSettingUI.this, "套图下载", "", true);
          continue;
          h.c(SnsSettingUI.this, "单图下载", "", true);
          continue;
          h.c(SnsSettingUI.this, "单图下载", "", true);
        }
      }
    }));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(198387);
        SnsSettingUI.this.finish();
        AppMethodBeat.o(198387);
        return false;
      }
    });
    AppMethodBeat.o(198394);
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
      AppMethodBeat.i(198389);
      int i = SnsSettingUI.a(SnsSettingUI.this).size();
      AppMethodBeat.o(198389);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(198390);
      Object localObject = SnsSettingUI.a(SnsSettingUI.this).get(paramInt);
      AppMethodBeat.o(198390);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(198391);
      paramView = new TextView(SnsSettingUI.this);
      paramViewGroup = (SnsSettingUI.c)getItem(paramInt);
      paramView.setTag(paramViewGroup);
      paramView.setText(paramViewGroup.aer() + "->:" + paramViewGroup.value());
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198388);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSettingUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramViewGroup.cy(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198388);
        }
      });
      AppMethodBeat.o(198391);
      return paramView;
    }
  }
  
  final class b
    implements SnsSettingUI.c
  {
    private View.OnClickListener Aiz = null;
    private String title = null;
    private String value = null;
    
    public b(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
    {
      this.title = paramString1;
      this.value = paramString2;
      this.Aiz = paramOnClickListener;
    }
    
    public final String aer()
    {
      return this.title;
    }
    
    public final void cy(View paramView)
    {
      AppMethodBeat.i(198392);
      this.Aiz.onClick(paramView);
      t.makeText(aj.getContext(), "ClickItem Done", 1).show();
      AppMethodBeat.o(198392);
    }
    
    public final String value()
    {
      return this.value;
    }
  }
  
  static abstract interface c
  {
    public abstract String aer();
    
    public abstract void cy(View paramView);
    
    public abstract String value();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSettingUI
 * JD-Core Version:    0.7.0.1
 */