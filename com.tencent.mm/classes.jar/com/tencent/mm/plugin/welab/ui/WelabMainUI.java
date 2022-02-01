package com.tencent.mm.plugin.welab.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.welab.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  private boolean CUa;
  private LinearLayout CUl;
  private LinearLayout CUm;
  private LinearLayout CUn;
  private LinearLayout CUo;
  private View CUp;
  private View CUq;
  private List<String> CUr;
  private View.OnClickListener CUs;
  private Comparator<com.tencent.mm.plugin.welab.d.a.a> bDS;
  
  public WelabMainUI()
  {
    AppMethodBeat.i(146289);
    this.CUa = false;
    this.bDS = new Comparator() {};
    this.CUs = new View.OnClickListener()
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
          if (!b.eHK().e(paramAnonymousView)) {
            break label246;
          }
        }
        label246:
        for (int i = 1;; i = 0)
        {
          ((Intent)localObject2).putExtra("para_from_with_red_point", i);
          ((Intent)localObject2).setClass(WelabMainUI.this, WelabAppInfoUI.class);
          Object localObject1 = WelabMainUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/welab/ui/WelabMainUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((WelabMainUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/welab/ui/WelabMainUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = b.eHK();
          localObject2 = paramAnonymousView.field_LabsAppId;
          ((b)localObject1).CTN.put(localObject2, Integer.valueOf(1));
          ((b)localObject1).tag = (((b)localObject1).tag + "&" + (String)localObject2 + "=1");
          g.agR().agA().set(ah.a.GNc, ((b)localObject1).tag);
          b.eHM();
          ac.i("MicroMsg.WelabMainUI", "click ".concat(String.valueOf(paramAnonymousView)));
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
    if (b.eHK().e(parama)) {
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.av.a.a.aFG().a(parama.aEv("field_ThumbUrl"), localImageView2, com.tencent.mm.plugin.welab.a.eHv().CbH);
      com.tencent.mm.plugin.welab.a.eHv();
      localTextView1.setText(com.tencent.mm.plugin.welab.a.a(parama));
      localTextView2.setText(parama.aEv("field_Desc"));
      localLinearLayout.setTag(parama);
      localLinearLayout.setOnClickListener(this.CUs);
      paramLinearLayout.addView(localLinearLayout);
      AppMethodBeat.o(146295);
      return;
      localImageView1.setVisibility(8);
    }
  }
  
  private void eHJ()
  {
    AppMethodBeat.i(146294);
    Object localObject = com.tencent.mm.plugin.welab.a.eHv().CTI.eHD();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
      if ((System.currentTimeMillis() / 1000L - locala.field_endtime >= 2592000L) || ("labs1de6f3".equals(locala.field_LabsAppId)))
      {
        localIterator.remove();
        com.tencent.mm.plugin.welab.a.CTH.CTI.delete(locala, new String[0]);
      }
      else if ((locala.isExpired()) && (locala.field_Switch != 3))
      {
        locala.field_Switch = 3;
        com.tencent.mm.plugin.welab.a.CTH.CTI.update(locala, new String[0]);
      }
      else if (locala.field_Switch != 3)
      {
        localIterator.remove();
      }
    }
    ac.i("WelabMgr", "stopped lab %s", new Object[] { localObject.toString() });
    if (((List)localObject).isEmpty())
    {
      this.CUm.setVisibility(8);
      AppMethodBeat.o(146294);
      return;
    }
    this.CUm.setVisibility(0);
    Collections.sort((List)localObject, this.bDS);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next(), this.CUo);
    }
    ac.d("MicroMsg.WelabMainUI", "get online app count " + this.CUo.getChildCount());
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
    this.CUl = ((LinearLayout)findViewById(2131303013));
    this.CUn = ((LinearLayout)findViewById(2131303014));
    this.CUm = ((LinearLayout)findViewById(2131305241));
    this.CUo = ((LinearLayout)findViewById(2131305242));
    this.CUp = findViewById(2131303410);
    this.CUq = findViewById(2131302868);
    this.CUp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(146285);
        Intent localIntent = new Intent();
        localIntent.putExtra("title", paramAnonymousView.getResources().getString(2131766203));
        localIntent.putExtra("rawUrl", WelabMainUI.this.getContext().getString(2131766198, new Object[] { ab.eUO(), Integer.valueOf(com.tencent.mm.protocal.d.DIc) }));
        localIntent.putExtra("showShare", false);
        com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(146285);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(146286);
        WelabMainUI.this.hideVKB();
        WelabMainUI.this.finish();
        AppMethodBeat.o(146286);
        return true;
      }
    });
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
      this.CUa = bool;
      this.CUr = getIntent().getStringArrayListExtra("key_exclude_apps");
    }
    initView();
    b.eHK();
    ai.eUY().edit().putBoolean("key_has_enter_welab", true).commit();
    b.eHM();
    com.tencent.mm.plugin.welab.d.v("", 1, this.CUa);
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
    this.CUn.removeAllViews();
    this.CUo.removeAllViews();
    Object localObject = com.tencent.mm.plugin.welab.a.eHv().eHw();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      this.CUl.setVisibility(8);
    }
    for (;;)
    {
      eHJ();
      if ((this.CUl.getVisibility() == 0) || (this.CUm.getVisibility() == 0)) {
        break;
      }
      this.CUq.setVisibility(0);
      AppMethodBeat.o(146292);
      return;
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
        if ((!bs.isNullOrNil(locala.field_LabsAppId)) && (this.CUr.contains(locala.field_LabsAppId))) {
          localIterator.remove();
        }
      }
      if (((List)localObject).isEmpty())
      {
        this.CUl.setVisibility(8);
      }
      else
      {
        this.CUl.setVisibility(0);
        Collections.sort((List)localObject, this.bDS);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a((com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next(), this.CUn);
        }
        ac.d("MicroMsg.WelabMainUI", "get online app count " + this.CUn.getChildCount());
      }
    }
    this.CUq.setVisibility(8);
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