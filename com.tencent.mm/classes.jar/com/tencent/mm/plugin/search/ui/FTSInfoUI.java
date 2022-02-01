package com.tencent.mm.plugin.search.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
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
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Calendar;

public class FTSInfoUI
  extends MMActivity
  implements l
{
  private p mHs;
  private TextView tLW;
  private View.OnClickListener yRA;
  private Button yRw;
  private Button yRx;
  private Button yRy;
  private Button yRz;
  
  public FTSInfoUI()
  {
    AppMethodBeat.i(28076);
    this.yRA = new FTSInfoUI.3(this);
    AppMethodBeat.o(28076);
  }
  
  public static long dCy()
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
    if (this.mHs != null) {
      this.mHs.dismiss();
    }
    paramk = new StringBuffer();
    paramk.append("[DBSize]=" + bu.DB(e.tEm.tEp * 1048576L));
    paramk.append("\n");
    paramk.append("[WXContact]=" + e.tEm.tEq);
    paramk.append("\n");
    paramk.append("[WXChatroom]=" + e.tEm.tEr);
    paramk.append("\n");
    paramk.append("[Favorite]=" + e.tEm.tEt);
    paramk.append("\n");
    paramk.append("[Message]=" + e.tEm.tEs);
    paramk.append("\n");
    paramk.append("[WebSearchH5Version]=" + ad.WL(0));
    paramk.append("\n");
    paramk.append("[TopStoryH5Version]=" + ad.WL(1));
    paramk.append("\n");
    paramk.append("[WxAppH5Version]=" + ad.WL(3));
    paramk.append("\n");
    paramk.append("[BoxH5Version]=" + ad.WL(2));
    paramk.append("\n");
    paramk.append("[TopStoryWebViewCore]=" + ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType());
    paramk.append("\n");
    paramk.append("[PardusH5Version]=" + ad.WL(5));
    paramk.append("\n");
    this.tLW.setText(paramk.toString());
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
    this.yRw = ((Button)findViewById(2131300999));
    this.tLW = ((TextView)findViewById(2131301013));
    this.yRw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28074);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/search/ui/FTSInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
        paramAnonymousView.jUf = 65526;
        paramAnonymousView.tGa = FTSInfoUI.this;
        ((n)g.ad(n.class)).search(10000, paramAnonymousView);
        a.a(this, "com/tencent/mm/plugin/search/ui/FTSInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28074);
      }
    });
    this.yRx = ((Button)findViewById(2131303407));
    this.yRy = ((Button)findViewById(2131303409));
    this.yRz = ((Button)findViewById(2131303408));
    this.yRx.setTag(Integer.valueOf(1));
    this.yRy.setTag(Integer.valueOf(2));
    this.yRz.setTag(Integer.valueOf(3));
    this.yRx.setOnClickListener(this.yRA);
    this.yRy.setOnClickListener(this.yRA);
    this.yRz.setOnClickListener(this.yRA);
    AppMethodBeat.o(28077);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.search.ui.FTSInfoUI
 * JD-Core Version:    0.7.0.1
 */