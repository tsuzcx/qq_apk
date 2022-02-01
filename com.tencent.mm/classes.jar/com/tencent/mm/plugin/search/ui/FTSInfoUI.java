package com.tencent.mm.plugin.search.ui;

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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class FTSInfoUI
  extends MMActivity
  implements com.tencent.mm.plugin.fts.a.l
{
  private TextView HAL;
  private Button Plm;
  private Button Pln;
  private Button Plo;
  private Button Plp;
  private View.OnClickListener Plq;
  private w rYw;
  
  public FTSInfoUI()
  {
    AppMethodBeat.i(28076);
    this.Plq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28075);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/search/ui/FTSInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if (i == 1)
        {
          paramAnonymousView = (c)h.ax(c.class);
          FTSInfoUI.gzM();
          paramAnonymousView = paramAnonymousView.dsU();
        }
        for (;;)
        {
          localObject = new StringBuffer();
          paramAnonymousView = paramAnonymousView.iterator();
          while (paramAnonymousView.hasNext())
          {
            Pair localPair = (Pair)paramAnonymousView.next();
            ((StringBuffer)localObject).append("[");
            ((StringBuffer)localObject).append(((com.tencent.mm.plugin.messenger.a.b)h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName((String)localPair.first));
            ((StringBuffer)localObject).append("]\n");
            ((StringBuffer)localObject).append((String)localPair.second);
            ((StringBuffer)localObject).append("\n");
          }
          if (i == 2)
          {
            paramAnonymousView = ((c)h.ax(c.class)).kK(FTSInfoUI.gzM());
          }
          else
          {
            if (i != 3) {
              break;
            }
            paramAnonymousView = ((c)h.ax(c.class)).kJ(FTSInfoUI.gzM());
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
  
  public static long gzM()
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
  
  public final void b(m paramm)
  {
    AppMethodBeat.i(28079);
    if (this.rYw != null) {
      this.rYw.dismiss();
    }
    paramm = new StringBuffer();
    paramm.append("[DBSize]=" + Util.getSizeMB(e.HrL.HrP * 1048576L));
    paramm.append("\n");
    paramm.append("[WXContact]=" + e.HrL.HrQ);
    paramm.append("\n");
    paramm.append("[WXChatroom]=" + e.HrL.HrR);
    paramm.append("\n");
    paramm.append("[Favorite]=" + e.HrL.HrT);
    paramm.append("\n");
    paramm.append("[Message]=" + e.HrL.HrS);
    paramm.append("\n");
    paramm.append("[WebSearchH5Version]=" + aj.asY(0));
    paramm.append("\n");
    paramm.append("[TopStoryH5Version]=" + aj.asY(1));
    paramm.append("\n");
    paramm.append("[WxAppH5Version]=" + aj.asY(3));
    paramm.append("\n");
    paramm.append("[BoxH5Version]=" + aj.asY(2));
    paramm.append("\n");
    paramm.append("[TopStoryWebViewCore]=" + ((com.tencent.mm.plugin.topstory.a.b)h.az(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType());
    paramm.append("\n");
    paramm.append("[PardusH5Version]=" + aj.asY(5));
    paramm.append("\n");
    this.HAL.setText(paramm.toString());
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
    this.Plm = ((Button)findViewById(R.h.index_info_btn));
    this.HAL = ((TextView)findViewById(R.h.info_tv));
    this.Plm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28074);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/search/ui/FTSInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (FTSInfoUI.a(FTSInfoUI.this) == null) {
          FTSInfoUI.a(FTSInfoUI.this, k.a(FTSInfoUI.this, FTSInfoUI.this.getString(R.l.loading_tips), true, new DialogInterface.OnCancelListener()
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
        paramAnonymousView = new com.tencent.mm.plugin.fts.a.a.l();
        paramAnonymousView.qRb = 65526;
        paramAnonymousView.HtC = FTSInfoUI.this;
        ((n)h.az(n.class)).search(10000, paramAnonymousView);
        a.a(this, "com/tencent/mm/plugin/search/ui/FTSInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28074);
      }
    });
    this.Pln = ((Button)findViewById(R.h.priority_chat_info));
    this.Plo = ((Button)findViewById(R.h.priority_img_info));
    this.Plp = ((Button)findViewById(R.h.priority_file_info));
    this.Pln.setTag(Integer.valueOf(1));
    this.Plo.setTag(Integer.valueOf(2));
    this.Plp.setTag(Integer.valueOf(3));
    this.Pln.setOnClickListener(this.Plq);
    this.Plo.setOnClickListener(this.Plq);
    this.Plp.setOnClickListener(this.Plq);
    AppMethodBeat.o(28077);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.search.ui.FTSInfoUI
 * JD-Core Version:    0.7.0.1
 */