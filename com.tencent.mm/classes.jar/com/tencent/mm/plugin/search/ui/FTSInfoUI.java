package com.tencent.mm.plugin.search.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class FTSInfoUI
  extends MMActivity
  implements l
{
  private TextView BOV;
  private Button Jbv;
  private Button Jbw;
  private Button Jbx;
  private Button Jby;
  private View.OnClickListener Jbz;
  private s oTk;
  
  public FTSInfoUI()
  {
    AppMethodBeat.i(28076);
    this.Jbz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28075);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/search/ui/FTSInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if (i == 1)
        {
          paramAnonymousView = (com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class);
          FTSInfoUI.foJ();
          paramAnonymousView = paramAnonymousView.cPo();
        }
        for (;;)
        {
          localObject = new StringBuffer();
          paramAnonymousView = paramAnonymousView.iterator();
          while (paramAnonymousView.hasNext())
          {
            Pair localPair = (Pair)paramAnonymousView.next();
            ((StringBuffer)localObject).append("[");
            ((StringBuffer)localObject).append(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ((String)localPair.first));
            ((StringBuffer)localObject).append("]\n");
            ((StringBuffer)localObject).append((String)localPair.second);
            ((StringBuffer)localObject).append("\n");
          }
          if (i == 2)
          {
            paramAnonymousView = ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).Is(FTSInfoUI.foJ());
          }
          else
          {
            if (i != 3) {
              break;
            }
            paramAnonymousView = ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).Ir(FTSInfoUI.foJ());
          }
        }
        a.a(this, "com/tencent/mm/plugin/search/ui/FTSInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28075);
        return;
        FTSInfoUI.b(FTSInfoUI.this).setText(((StringBuffer)localObject).toString());
        a.a(this, "com/tencent/mm/plugin/search/ui/FTSInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28075);
      }
    };
    AppMethodBeat.o(28076);
  }
  
  public static long foJ()
  {
    AppMethodBeat.i(28078);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    long l = localCalendar.getTimeInMillis();
    AppMethodBeat.o(28078);
    return l;
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(28079);
    if (this.oTk != null) {
      this.oTk.dismiss();
    }
    paramk = new StringBuffer();
    paramk.append("[DBSize]=" + Util.getSizeMB(e.BHh.BHk * 1048576L));
    paramk.append("\n");
    paramk.append("[WXContact]=" + e.BHh.BHl);
    paramk.append("\n");
    paramk.append("[WXChatroom]=" + e.BHh.BHm);
    paramk.append("\n");
    paramk.append("[Favorite]=" + e.BHh.BHo);
    paramk.append("\n");
    paramk.append("[Message]=" + e.BHh.BHn);
    paramk.append("\n");
    paramk.append("[WebSearchH5Version]=" + ai.anh(0));
    paramk.append("\n");
    paramk.append("[TopStoryH5Version]=" + ai.anh(1));
    paramk.append("\n");
    paramk.append("[WxAppH5Version]=" + ai.anh(3));
    paramk.append("\n");
    paramk.append("[BoxH5Version]=" + ai.anh(2));
    paramk.append("\n");
    paramk.append("[TopStoryWebViewCore]=" + ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType());
    paramk.append("\n");
    paramk.append("[PardusH5Version]=" + ai.anh(5));
    paramk.append("\n");
    this.BOV.setText(paramk.toString());
    AppMethodBeat.o(28079);
  }
  
  public int getLayoutId()
  {
    return R.i.fts_info_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28077);
    super.onCreate(paramBundle);
    setMMTitle(R.l.fts_info_ui_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28072);
        FTSInfoUI.this.finish();
        AppMethodBeat.o(28072);
        return false;
      }
    });
    this.Jbv = ((Button)findViewById(R.h.index_info_btn));
    this.BOV = ((TextView)findViewById(R.h.info_tv));
    this.Jbv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28074);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/search/ui/FTSInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (FTSInfoUI.a(FTSInfoUI.this) == null) {
          FTSInfoUI.a(FTSInfoUI.this, com.tencent.mm.ui.base.h.a(FTSInfoUI.this, FTSInfoUI.this.getString(R.l.loading_tips), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(28073);
              FTSInfoUI.this.finish();
              AppMethodBeat.o(28073);
            }
          }));
        }
        FTSInfoUI.a(FTSInfoUI.this).show();
        paramAnonymousView = new j();
        paramAnonymousView.nRn = 65526;
        paramAnonymousView.BIU = FTSInfoUI.this;
        ((n)com.tencent.mm.kernel.h.ag(n.class)).search(10000, paramAnonymousView);
        a.a(this, "com/tencent/mm/plugin/search/ui/FTSInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28074);
      }
    });
    this.Jbw = ((Button)findViewById(R.h.priority_chat_info));
    this.Jbx = ((Button)findViewById(R.h.priority_img_info));
    this.Jby = ((Button)findViewById(R.h.priority_file_info));
    this.Jbw.setTag(Integer.valueOf(1));
    this.Jbx.setTag(Integer.valueOf(2));
    this.Jby.setTag(Integer.valueOf(3));
    this.Jbw.setOnClickListener(this.Jbz);
    this.Jbx.setOnClickListener(this.Jbz);
    this.Jby.setOnClickListener(this.Jbz);
    AppMethodBeat.o(28077);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.search.ui.FTSInfoUI
 * JD-Core Version:    0.7.0.1
 */