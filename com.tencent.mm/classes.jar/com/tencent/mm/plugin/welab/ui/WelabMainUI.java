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
import com.tencent.mm.plugin.welab.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
  private boolean BBU;
  private LinearLayout BCf;
  private LinearLayout BCg;
  private LinearLayout BCh;
  private LinearLayout BCi;
  private View BCj;
  private View BCk;
  private List<String> BCl;
  private View.OnClickListener BCm;
  private Comparator<com.tencent.mm.plugin.welab.d.a.a> bGk;
  
  public WelabMainUI()
  {
    AppMethodBeat.i(146289);
    this.BBU = false;
    this.bGk = new WelabMainUI.3(this);
    this.BCm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(146288);
        paramAnonymousView = paramAnonymousView.getTag();
        Object localObject2;
        if ((paramAnonymousView instanceof com.tencent.mm.plugin.welab.d.a.a))
        {
          paramAnonymousView = (com.tencent.mm.plugin.welab.d.a.a)paramAnonymousView;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("para_appid", paramAnonymousView.field_LabsAppId);
          if (!b.esr().e(paramAnonymousView)) {
            break label246;
          }
        }
        label246:
        for (int i = 1;; i = 0)
        {
          ((Intent)localObject2).putExtra("para_from_with_red_point", i);
          ((Intent)localObject2).setClass(WelabMainUI.this, WelabAppInfoUI.class);
          Object localObject1 = WelabMainUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/welab/ui/WelabMainUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((WelabMainUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/welab/ui/WelabMainUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = b.esr();
          localObject2 = paramAnonymousView.field_LabsAppId;
          ((b)localObject1).BBH.put(localObject2, Integer.valueOf(1));
          ((b)localObject1).tag = (((b)localObject1).tag + "&" + (String)localObject2 + "=1");
          g.afB().afk().set(ae.a.Fpm, ((b)localObject1).tag);
          b.est();
          ad.i("MicroMsg.WelabMainUI", "click ".concat(String.valueOf(paramAnonymousView)));
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
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131496096, paramLinearLayout, false);
    ImageView localImageView1 = (ImageView)localLinearLayout.findViewById(2131305941);
    ImageView localImageView2 = (ImageView)localLinearLayout.findViewById(2131296854);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131305902);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131305546);
    if (b.esr().e(parama)) {
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.aw.a.a.ayO().a(parama.aze("field_ThumbUrl"), localImageView2, com.tencent.mm.plugin.welab.a.esb().AJq);
      com.tencent.mm.plugin.welab.a.esb();
      localTextView1.setText(com.tencent.mm.plugin.welab.a.a(parama));
      localTextView2.setText(parama.aze("field_Desc"));
      localLinearLayout.setTag(parama);
      localLinearLayout.setOnClickListener(this.BCm);
      paramLinearLayout.addView(localLinearLayout);
      AppMethodBeat.o(146295);
      return;
      localImageView1.setVisibility(8);
    }
  }
  
  private void esq()
  {
    AppMethodBeat.i(146294);
    Object localObject = com.tencent.mm.plugin.welab.a.esb().BBC.esj();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
      if ((System.currentTimeMillis() / 1000L - locala.field_endtime >= 2592000L) || ("labs1de6f3".equals(locala.field_LabsAppId)))
      {
        localIterator.remove();
        com.tencent.mm.plugin.welab.a.BBB.BBC.delete(locala, new String[0]);
      }
      else if ((locala.isExpired()) && (locala.field_Switch != 3))
      {
        locala.field_Switch = 3;
        com.tencent.mm.plugin.welab.a.BBB.BBC.update(locala, new String[0]);
      }
      else if (locala.field_Switch != 3)
      {
        localIterator.remove();
      }
    }
    ad.i("WelabMgr", "stopped lab %s", new Object[] { localObject.toString() });
    if (((List)localObject).isEmpty())
    {
      this.BCg.setVisibility(8);
      AppMethodBeat.o(146294);
      return;
    }
    this.BCg.setVisibility(0);
    Collections.sort((List)localObject, this.bGk);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next(), this.BCi);
    }
    ad.d("MicroMsg.WelabMainUI", "get online app count " + this.BCi.getChildCount());
    AppMethodBeat.o(146294);
  }
  
  public int getLayoutId()
  {
    return 2131496098;
  }
  
  public void initView()
  {
    AppMethodBeat.i(146291);
    setMMTitle(2131766200);
    setTitleDividerColor(2131101179);
    setActionbarColor(getResources().getColor(2131101178));
    setActionbarElementColor(getResources().getColor(2131099828));
    this.BCf = ((LinearLayout)findViewById(2131303013));
    this.BCh = ((LinearLayout)findViewById(2131303014));
    this.BCg = ((LinearLayout)findViewById(2131305241));
    this.BCi = ((LinearLayout)findViewById(2131305242));
    this.BCj = findViewById(2131303410);
    this.BCk = findViewById(2131302868);
    this.BCj.setOnClickListener(new WelabMainUI.1(this));
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
      this.BBU = bool;
      this.BCl = getIntent().getStringArrayListExtra("key_exclude_apps");
    }
    initView();
    b.esr();
    aj.eFE().edit().putBoolean("key_has_enter_welab", true).commit();
    b.est();
    d.v("", 1, this.BBU);
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
    this.BCh.removeAllViews();
    this.BCi.removeAllViews();
    Object localObject = com.tencent.mm.plugin.welab.a.esb().esc();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      this.BCf.setVisibility(8);
    }
    for (;;)
    {
      esq();
      if ((this.BCf.getVisibility() == 0) || (this.BCg.getVisibility() == 0)) {
        break;
      }
      this.BCk.setVisibility(0);
      AppMethodBeat.o(146292);
      return;
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
        if ((!bt.isNullOrNil(locala.field_LabsAppId)) && (this.BCl.contains(locala.field_LabsAppId))) {
          localIterator.remove();
        }
      }
      if (((List)localObject).isEmpty())
      {
        this.BCf.setVisibility(8);
      }
      else
      {
        this.BCf.setVisibility(0);
        Collections.sort((List)localObject, this.bGk);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a((com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next(), this.BCh);
        }
        ad.d("MicroMsg.WelabMainUI", "get online app count " + this.BCh.getChildCount());
      }
    }
    this.BCk.setVisibility(8);
    AppMethodBeat.o(146292);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabMainUI
 * JD-Core Version:    0.7.0.1
 */