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
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class FTSInfoUI
  extends MMActivity
  implements l
{
  private p mCn;
  private TextView tBf;
  private View.OnClickListener yBA;
  private Button yBw;
  private Button yBx;
  private Button yBy;
  private Button yBz;
  
  public FTSInfoUI()
  {
    AppMethodBeat.i(28076);
    this.yBA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28075);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/search/ui/FTSInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if (i == 1)
        {
          paramAnonymousView = (com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class);
          FTSInfoUI.dzh();
          paramAnonymousView = paramAnonymousView.cbB();
        }
        for (;;)
        {
          localObject = new StringBuffer();
          paramAnonymousView = paramAnonymousView.iterator();
          while (paramAnonymousView.hasNext())
          {
            Pair localPair = (Pair)paramAnonymousView.next();
            ((StringBuffer)localObject).append("[");
            ((StringBuffer)localObject).append(((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf((String)localPair.first));
            ((StringBuffer)localObject).append("]\n");
            ((StringBuffer)localObject).append((String)localPair.second);
            ((StringBuffer)localObject).append("\n");
          }
          if (i == 2)
          {
            paramAnonymousView = ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).tN(FTSInfoUI.dzh());
          }
          else
          {
            if (i != 3) {
              break;
            }
            paramAnonymousView = ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).tM(FTSInfoUI.dzh());
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
  
  public static long dzh()
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
    if (this.mCn != null) {
      this.mCn.dismiss();
    }
    paramk = new StringBuffer();
    paramk.append("[DBSize]=" + bt.Dd(e.ttv.tty * 1048576L));
    paramk.append("\n");
    paramk.append("[WXContact]=" + e.ttv.ttz);
    paramk.append("\n");
    paramk.append("[WXChatroom]=" + e.ttv.ttA);
    paramk.append("\n");
    paramk.append("[Favorite]=" + e.ttv.ttC);
    paramk.append("\n");
    paramk.append("[Message]=" + e.ttv.ttB);
    paramk.append("\n");
    paramk.append("[WebSearchH5Version]=" + ad.We(0));
    paramk.append("\n");
    paramk.append("[TopStoryH5Version]=" + ad.We(1));
    paramk.append("\n");
    paramk.append("[WxAppH5Version]=" + ad.We(3));
    paramk.append("\n");
    paramk.append("[BoxH5Version]=" + ad.We(2));
    paramk.append("\n");
    paramk.append("[TopStoryWebViewCore]=" + ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType());
    paramk.append("\n");
    paramk.append("[PardusH5Version]=" + ad.We(5));
    paramk.append("\n");
    this.tBf.setText(paramk.toString());
    AppMethodBeat.o(28079);
  }
  
  public int getLayoutId()
  {
    return 2131494205;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28077);
    super.onCreate(paramBundle);
    setMMTitle(2131759707);
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
    this.yBw = ((Button)findViewById(2131300999));
    this.tBf = ((TextView)findViewById(2131301013));
    this.yBw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28074);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/search/ui/FTSInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (FTSInfoUI.a(FTSInfoUI.this) == null) {
          FTSInfoUI.a(FTSInfoUI.this, h.b(FTSInfoUI.this, FTSInfoUI.this.getString(2131760709), true, new DialogInterface.OnCancelListener()
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
        paramAnonymousView.jQN = 65526;
        paramAnonymousView.tvj = FTSInfoUI.this;
        ((n)g.ad(n.class)).search(10000, paramAnonymousView);
        a.a(this, "com/tencent/mm/plugin/search/ui/FTSInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28074);
      }
    });
    this.yBx = ((Button)findViewById(2131303407));
    this.yBy = ((Button)findViewById(2131303409));
    this.yBz = ((Button)findViewById(2131303408));
    this.yBx.setTag(Integer.valueOf(1));
    this.yBy.setTag(Integer.valueOf(2));
    this.yBz.setTag(Integer.valueOf(3));
    this.yBx.setOnClickListener(this.yBA);
    this.yBy.setOnClickListener(this.yBA);
    this.yBz.setOnClickListener(this.yBA);
    AppMethodBeat.o(28077);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.search.ui.FTSInfoUI
 * JD-Core Version:    0.7.0.1
 */