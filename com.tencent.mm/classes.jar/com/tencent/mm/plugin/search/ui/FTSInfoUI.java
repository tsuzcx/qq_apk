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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class FTSInfoUI
  extends MMActivity
  implements l
{
  private Button CVJ;
  private Button CVK;
  private Button CVL;
  private Button CVM;
  private View.OnClickListener CVN;
  private q nUq;
  private TextView xcX;
  
  public FTSInfoUI()
  {
    AppMethodBeat.i(28076);
    this.CVN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28075);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/search/ui/FTSInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if (i == 1)
        {
          paramAnonymousView = (com.tencent.mm.plugin.comm.a.b)g.af(com.tencent.mm.plugin.comm.a.b.class);
          FTSInfoUI.eCQ();
          paramAnonymousView = paramAnonymousView.cAL();
        }
        for (;;)
        {
          localObject = new StringBuffer();
          paramAnonymousView = paramAnonymousView.iterator();
          while (paramAnonymousView.hasNext())
          {
            Pair localPair = (Pair)paramAnonymousView.next();
            ((StringBuffer)localObject).append("[");
            ((StringBuffer)localObject).append(((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName((String)localPair.first));
            ((StringBuffer)localObject).append("]\n");
            ((StringBuffer)localObject).append((String)localPair.second);
            ((StringBuffer)localObject).append("\n");
          }
          if (i == 2)
          {
            paramAnonymousView = ((com.tencent.mm.plugin.comm.a.b)g.af(com.tencent.mm.plugin.comm.a.b.class)).Cj(FTSInfoUI.eCQ());
          }
          else
          {
            if (i != 3) {
              break;
            }
            paramAnonymousView = ((com.tencent.mm.plugin.comm.a.b)g.af(com.tencent.mm.plugin.comm.a.b.class)).Ci(FTSInfoUI.eCQ());
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
  
  public static long eCQ()
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
    if (this.nUq != null) {
      this.nUq.dismiss();
    }
    paramk = new StringBuffer();
    paramk.append("[DBSize]=" + Util.getSizeMB(e.wVl.wVo * 1048576L));
    paramk.append("\n");
    paramk.append("[WXContact]=" + e.wVl.wVp);
    paramk.append("\n");
    paramk.append("[WXChatroom]=" + e.wVl.wVq);
    paramk.append("\n");
    paramk.append("[Favorite]=" + e.wVl.wVs);
    paramk.append("\n");
    paramk.append("[Message]=" + e.wVl.wVr);
    paramk.append("\n");
    paramk.append("[WebSearchH5Version]=" + ai.aft(0));
    paramk.append("\n");
    paramk.append("[TopStoryH5Version]=" + ai.aft(1));
    paramk.append("\n");
    paramk.append("[WxAppH5Version]=" + ai.aft(3));
    paramk.append("\n");
    paramk.append("[BoxH5Version]=" + ai.aft(2));
    paramk.append("\n");
    paramk.append("[TopStoryWebViewCore]=" + ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType());
    paramk.append("\n");
    paramk.append("[PardusH5Version]=" + ai.aft(5));
    paramk.append("\n");
    this.xcX.setText(paramk.toString());
    AppMethodBeat.o(28079);
  }
  
  public int getLayoutId()
  {
    return 2131494758;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28077);
    super.onCreate(paramBundle);
    setMMTitle(2131761028);
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
    this.CVJ = ((Button)findViewById(2131302640));
    this.xcX = ((TextView)findViewById(2131302657));
    this.CVJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28074);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/search/ui/FTSInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (FTSInfoUI.a(FTSInfoUI.this) == null) {
          FTSInfoUI.a(FTSInfoUI.this, h.a(FTSInfoUI.this, FTSInfoUI.this.getString(2131762446), true, new DialogInterface.OnCancelListener()
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
        paramAnonymousView.kXb = 65526;
        paramAnonymousView.wWZ = FTSInfoUI.this;
        ((n)g.ah(n.class)).search(10000, paramAnonymousView);
        a.a(this, "com/tencent/mm/plugin/search/ui/FTSInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28074);
      }
    });
    this.CVK = ((Button)findViewById(2131306128));
    this.CVL = ((Button)findViewById(2131306130));
    this.CVM = ((Button)findViewById(2131306129));
    this.CVK.setTag(Integer.valueOf(1));
    this.CVL.setTag(Integer.valueOf(2));
    this.CVM.setTag(Integer.valueOf(3));
    this.CVK.setOnClickListener(this.CVN);
    this.CVL.setOnClickListener(this.CVN);
    this.CVM.setOnClickListener(this.CVN);
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