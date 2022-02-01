package com.tencent.mm.plugin.welab.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@i
public class WelabMainUI
  extends MMActivity
{
  private boolean JGg;
  private LinearLayout JGr;
  private LinearLayout JGs;
  private LinearLayout JGt;
  private LinearLayout JGu;
  private View JGv;
  private View JGw;
  private List<String> JGx;
  private View.OnClickListener JGy;
  private Comparator<com.tencent.mm.plugin.welab.d.a.a> nlt;
  
  public WelabMainUI()
  {
    AppMethodBeat.i(146289);
    this.JGg = false;
    this.nlt = new WelabMainUI.3(this);
    this.JGy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(146288);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/welab/ui/WelabMainUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        paramAnonymousView = paramAnonymousView.getTag();
        Object localObject2;
        if ((paramAnonymousView instanceof com.tencent.mm.plugin.welab.d.a.a))
        {
          paramAnonymousView = (com.tencent.mm.plugin.welab.d.a.a)paramAnonymousView;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("para_appid", paramAnonymousView.field_LabsAppId);
          if (!com.tencent.mm.plugin.welab.e.b.gju().e(paramAnonymousView)) {
            break label287;
          }
        }
        label287:
        for (int i = 1;; i = 0)
        {
          ((Intent)localObject2).putExtra("para_from_with_red_point", i);
          ((Intent)localObject2).setClass(WelabMainUI.this, WelabAppInfoUI.class);
          localObject1 = WelabMainUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/welab/ui/WelabMainUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((WelabMainUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/welab/ui/WelabMainUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = com.tencent.mm.plugin.welab.e.b.gju();
          localObject2 = paramAnonymousView.field_LabsAppId;
          ((com.tencent.mm.plugin.welab.e.b)localObject1).JFW.put(localObject2, Integer.valueOf(1));
          ((com.tencent.mm.plugin.welab.e.b)localObject1).tag = (((com.tencent.mm.plugin.welab.e.b)localObject1).tag + "&" + (String)localObject2 + "=1");
          g.aAh().azQ().set(ar.a.Ocg, ((com.tencent.mm.plugin.welab.e.b)localObject1).tag);
          com.tencent.mm.plugin.welab.e.b.gjw();
          Log.i("MicroMsg.WelabMainUI", "click ".concat(String.valueOf(paramAnonymousView)));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/welab/ui/WelabMainUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(146288);
          return;
        }
      }
    };
    AppMethodBeat.o(146289);
  }
  
  private void a(com.tencent.mm.plugin.welab.d.a.a parama, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(146295);
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131497084, paramLinearLayout, false);
    ImageView localImageView1 = (ImageView)localLinearLayout.findViewById(2131309240);
    ImageView localImageView2 = (ImageView)localLinearLayout.findViewById(2131296946);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131309195);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131308767);
    if (com.tencent.mm.plugin.welab.e.b.gju().e(parama)) {
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.av.a.a.bdb().a(parama.bbH("field_ThumbUrl"), localImageView2, com.tencent.mm.plugin.welab.a.gjg().IIu);
      com.tencent.mm.plugin.welab.a.gjg();
      localTextView1.setText(com.tencent.mm.plugin.welab.a.a(parama));
      localTextView2.setText(parama.bbH("field_Desc"));
      localLinearLayout.setTag(parama);
      localLinearLayout.setOnClickListener(this.JGy);
      paramLinearLayout.addView(localLinearLayout);
      AppMethodBeat.o(146295);
      return;
      localImageView1.setVisibility(8);
    }
  }
  
  private void gjt()
  {
    AppMethodBeat.i(146294);
    Object localObject = com.tencent.mm.plugin.welab.a.gjg().JFR.gjn();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
      if ((System.currentTimeMillis() / 1000L - locala.field_endtime >= 2592000L) || ("labs1de6f3".equals(locala.field_LabsAppId)))
      {
        localIterator.remove();
        com.tencent.mm.plugin.welab.a.JFQ.JFR.delete(locala, new String[0]);
      }
      else if ((locala.isExpired()) && (locala.field_Switch != 3))
      {
        locala.field_Switch = 3;
        com.tencent.mm.plugin.welab.a.JFQ.JFR.update(locala, new String[0]);
      }
      else if (locala.field_Switch != 3)
      {
        localIterator.remove();
      }
    }
    Log.i("WelabMgr", "stopped lab %s", new Object[] { localObject.toString() });
    if (((List)localObject).isEmpty())
    {
      this.JGs.setVisibility(8);
      AppMethodBeat.o(146294);
      return;
    }
    this.JGs.setVisibility(0);
    Collections.sort((List)localObject, this.nlt);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next(), this.JGu);
    }
    Log.d("MicroMsg.WelabMainUI", "get online app count " + this.JGu.getChildCount());
    AppMethodBeat.o(146294);
  }
  
  public int getLayoutId()
  {
    return 2131497086;
  }
  
  public void initView()
  {
    AppMethodBeat.i(146291);
    setMMTitle(2131768708);
    setTitleDividerColor(2131101424);
    setActionbarColor(getResources().getColor(2131101423));
    setActionbarElementColor(getResources().getColor(2131099844));
    this.JGr = ((LinearLayout)findViewById(2131305606));
    this.JGt = ((LinearLayout)findViewById(2131305607));
    this.JGs = ((LinearLayout)findViewById(2131308445));
    this.JGu = ((LinearLayout)findViewById(2131308446));
    this.JGv = findViewById(2131306131);
    this.JGw = findViewById(2131305441);
    this.JGv.setOnClickListener(new WelabMainUI.1(this));
    setBackBtn(new WelabMainUI.2(this));
    AppMethodBeat.o(146291);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(146290);
    super.onCreate(paramBundle);
    setIsDarkActionbarBg(true);
    hideActionbarLine();
    if (getIntent() != null)
    {
      if (getIntent().getIntExtra("para_from_with_red_point", 0) == 1) {
        bool = true;
      }
      this.JGg = bool;
      this.JGx = getIntent().getStringArrayListExtra("key_exclude_apps");
    }
    initView();
    com.tencent.mm.plugin.welab.e.b.gju();
    MMApplicationContext.getDefaultPreference().edit().putBoolean("key_has_enter_welab", true).commit();
    com.tencent.mm.plugin.welab.e.b.gjw();
    d.y("", 1, this.JGg);
    AppMethodBeat.o(146290);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(146293);
    super.onPause();
    AppMethodBeat.o(146293);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(146292);
    super.onResume();
    this.JGt.removeAllViews();
    this.JGu.removeAllViews();
    Object localObject = com.tencent.mm.plugin.welab.a.gjg().gjh();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      this.JGr.setVisibility(8);
    }
    for (;;)
    {
      gjt();
      if ((this.JGr.getVisibility() == 0) || (this.JGs.getVisibility() == 0)) {
        break;
      }
      this.JGw.setVisibility(0);
      AppMethodBeat.o(146292);
      return;
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
        if ((!Util.isNullOrNil(locala.field_LabsAppId)) && (this.JGx.contains(locala.field_LabsAppId))) {
          localIterator.remove();
        }
      }
      if (((List)localObject).isEmpty())
      {
        this.JGr.setVisibility(8);
      }
      else
      {
        this.JGr.setVisibility(0);
        Collections.sort((List)localObject, this.nlt);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a((com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next(), this.JGt);
        }
        Log.d("MicroMsg.WelabMainUI", "get online app count " + this.JGt.getChildCount());
      }
    }
    this.JGw.setVisibility(8);
    AppMethodBeat.o(146292);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabMainUI
 * JD-Core Version:    0.7.0.1
 */