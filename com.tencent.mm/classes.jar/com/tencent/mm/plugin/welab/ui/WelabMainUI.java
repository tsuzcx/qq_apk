package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.welab.a.a;
import com.tencent.mm.plugin.welab.a.b;
import com.tencent.mm.plugin.welab.a.c;
import com.tencent.mm.plugin.welab.a.d;
import com.tencent.mm.plugin.welab.a.e;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.protocal.protobuf.fng;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@com.tencent.mm.kernel.k
public class WelabMainUI
  extends MMActivity
{
  private static final Map<String, String> Xzi;
  private boolean XyQ;
  private LinearLayout Xzb;
  private LinearLayout Xzc;
  private LinearLayout Xzd;
  private LinearLayout Xze;
  private View Xzf;
  private View Xzg;
  private List<String> Xzh;
  private View.OnClickListener Xzj;
  private View.OnLongClickListener Xzk;
  private Comparator<com.tencent.mm.plugin.welab.d.a.a> dFF;
  
  static
  {
    AppMethodBeat.i(262791);
    Xzi = new WelabMainUI.3();
    AppMethodBeat.o(262791);
  }
  
  public WelabMainUI()
  {
    AppMethodBeat.i(146289);
    this.XyQ = false;
    this.dFF = new Comparator() {};
    this.Xzj = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(262787);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/welab/ui/WelabMainUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        paramAnonymousView = paramAnonymousView.getTag();
        Object localObject2;
        if ((paramAnonymousView instanceof com.tencent.mm.plugin.welab.d.a.a))
        {
          paramAnonymousView = (com.tencent.mm.plugin.welab.d.a.a)paramAnonymousView;
          localObject2 = new Intent();
          if (Util.isEqual("wximeplugin", paramAnonymousView.field_LabsAppId))
          {
            ((Intent)localObject2).setClassName(WelabMainUI.this, "com.tencent.mm.plugin.hld.ui.WelabHldInfoUI");
            localObject1 = WelabMainUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/welab/ui/WelabMainUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((WelabMainUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/welab/ui/WelabMainUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = com.tencent.mm.plugin.welab.e.b.iDO();
            localObject2 = paramAnonymousView.field_LabsAppId;
            ((com.tencent.mm.plugin.welab.e.b)localObject1).XyG.put(localObject2, Integer.valueOf(1));
            ((com.tencent.mm.plugin.welab.e.b)localObject1).tag = (((com.tencent.mm.plugin.welab.e.b)localObject1).tag + "&" + (String)localObject2 + "=1");
            h.baE().ban().set(at.a.acRL, ((com.tencent.mm.plugin.welab.e.b)localObject1).tag);
            com.tencent.mm.plugin.welab.e.b.iDQ();
            localObject1 = (String)WelabMainUI.aYC().get(paramAnonymousView.field_LabsAppId);
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              com.tencent.mm.plugin.newtips.a.gtf().aeI(g.aPV((String)localObject1));
            }
            Log.i("MicroMsg.WelabMainUI", "click ".concat(String.valueOf(paramAnonymousView)));
          }
        }
        else
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/welab/ui/WelabMainUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(262787);
          return;
        }
        ((Intent)localObject2).putExtra("para_appid", paramAnonymousView.field_LabsAppId);
        if (com.tencent.mm.plugin.welab.e.b.iDO().e(paramAnonymousView)) {}
        for (int i = 1;; i = 0)
        {
          ((Intent)localObject2).putExtra("para_from_with_red_point", i);
          ((Intent)localObject2).setClass(WelabMainUI.this, WelabAppInfoUI.class);
          break;
        }
      }
    };
    this.Xzk = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(262788);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/welab/ui/WelabMainUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = paramAnonymousView.getTag();
        if (((paramAnonymousView instanceof com.tencent.mm.plugin.welab.d.a.a)) && ("wximeplugin".equals(((com.tencent.mm.plugin.welab.d.a.a)paramAnonymousView).field_LabsAppId)))
        {
          paramAnonymousView = com.tencent.mm.util.d.agsY;
          if (!com.tencent.mm.util.d.jJv()) {}
        }
        try
        {
          localObject = new Intent(WelabMainUI.this.getContext(), Class.forName("com.tencent.mm.plugin.hld.ui.HldDebugUI"));
          ((Intent)localObject).setFlags(268435456);
          paramAnonymousView = WelabMainUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/welab/ui/WelabMainUI$6", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/welab/ui/WelabMainUI$6", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          label163:
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/welab/ui/WelabMainUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(262788);
          return true;
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/welab/ui/WelabMainUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(262788);
          return false;
        }
        catch (ClassNotFoundException paramAnonymousView)
        {
          break label163;
        }
      }
    };
    AppMethodBeat.o(146289);
  }
  
  private void a(com.tencent.mm.plugin.welab.d.a.a parama, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(146295);
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(a.d.Xys, paramLinearLayout, false);
    Object localObject = (ImageView)localLinearLayout.findViewById(a.c.Xyp);
    ImageView localImageView = (ImageView)localLinearLayout.findViewById(a.c.app_img);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(a.c.title);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(a.c.summary);
    TextView localTextView3 = (TextView)localLinearLayout.findViewById(a.c.Xyq);
    if (com.tencent.mm.plugin.welab.e.b.iDO().e(parama))
    {
      ((ImageView)localObject).setVisibility(0);
      if (!Util.isEqual(parama.field_LabsAppId, "wximeplugin")) {
        break label206;
      }
      localImageView.setImageResource(a.b.Xyf);
    }
    for (;;)
    {
      com.tencent.mm.plugin.welab.b.iDA();
      localTextView1.setText(com.tencent.mm.plugin.welab.b.a(parama));
      localTextView2.setText(parama.bnv("field_Desc"));
      localLinearLayout.setTag(parama);
      localLinearLayout.setOnClickListener(this.Xzj);
      localLinearLayout.setOnLongClickListener(this.Xzk);
      paramLinearLayout.addView(localLinearLayout);
      AppMethodBeat.o(146295);
      return;
      ((ImageView)localObject).setVisibility(8);
      localObject = new a((ImageView)localObject, localTextView3, parama, localLinearLayout);
      com.tencent.mm.plugin.newtips.a.gtf().h((com.tencent.mm.plugin.newtips.a.a)localObject);
      break;
      label206:
      com.tencent.mm.modelimage.loader.a.bKl().a(parama.bnv("field_ThumbUrl"), localImageView, com.tencent.mm.plugin.welab.b.iDA().Wtu);
    }
  }
  
  private void iDN()
  {
    AppMethodBeat.i(146294);
    List localList = com.tencent.mm.plugin.welab.b.iDA().XyB.iDI();
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next();
      if ((System.currentTimeMillis() / 1000L - locala.field_endtime >= 2592000L) || ("labs1de6f3".equals(locala.field_LabsAppId)))
      {
        ((Iterator)localObject).remove();
        com.tencent.mm.plugin.welab.b.XyA.XyB.delete(locala, new String[0]);
      }
      else if ((locala.isExpired()) && (locala.field_Switch != 3))
      {
        locala.field_Switch = 3;
        com.tencent.mm.plugin.welab.b.XyA.XyB.update(locala, new String[0]);
      }
      else if (locala.field_Switch != 3)
      {
        ((Iterator)localObject).remove();
      }
    }
    if (localList != null) {}
    for (localObject = localList.toString();; localObject = "")
    {
      Log.i("WelabMgr", "stopped lab %s", new Object[] { localObject });
      if ((localList != null) && (!localList.isEmpty())) {
        break;
      }
      this.Xzc.setVisibility(8);
      AppMethodBeat.o(146294);
      return;
    }
    this.Xzc.setVisibility(0);
    Collections.sort(localList, this.dFF);
    localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next(), this.Xze);
    }
    Log.d("MicroMsg.WelabMainUI", "get online app count " + this.Xze.getChildCount());
    AppMethodBeat.o(146294);
  }
  
  public int getLayoutId()
  {
    return a.d.Xyu;
  }
  
  public void initView()
  {
    AppMethodBeat.i(146291);
    setMMTitle(a.e.Xyx);
    setTitleDividerColor(a.a.white);
    setActionbarColor(getResources().getColor(a.a.Xye));
    setActionbarElementColor(getResources().getColor(a.a.White));
    this.Xzb = ((LinearLayout)findViewById(a.c.Xyk));
    this.Xzd = ((LinearLayout)findViewById(a.c.Xyl));
    this.Xzc = ((LinearLayout)findViewById(a.c.Xym));
    this.Xze = ((LinearLayout)findViewById(a.c.Xyn));
    this.Xzf = findViewById(a.c.privacy_detail);
    this.Xzg = findViewById(a.c.Xyj);
    this.Xzf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(146285);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/welab/ui/WelabMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = new Intent();
        ((Intent)localObject).putExtra("title", paramAnonymousView.getResources().getString(a.e.Xyz));
        ((Intent)localObject).putExtra("rawUrl", WelabMainUI.this.getContext().getString(a.e.Xyv, new Object[] { LocaleUtil.getApplicationLanguage(), Integer.valueOf(com.tencent.mm.protocal.d.Yxh) }));
        ((Intent)localObject).putExtra("showShare", false);
        c.b(paramAnonymousView.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/welab/ui/WelabMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      this.XyQ = bool;
      this.Xzh = getIntent().getStringArrayListExtra("key_exclude_apps");
    }
    initView();
    com.tencent.mm.plugin.welab.e.b.iDO();
    MMApplicationContext.getDefaultPreference().edit().putBoolean("key_has_enter_welab", true).commit();
    com.tencent.mm.plugin.welab.e.b.iDQ();
    e.E("", 1, this.XyQ);
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
    this.Xzd.removeAllViews();
    this.Xze.removeAllViews();
    Object localObject;
    if (((com.tencent.mm.plugin.hld.a.d)h.ax(com.tencent.mm.plugin.hld.a.d.class)).id(getContext()))
    {
      com.tencent.mm.plugin.welab.b.iDA();
      localObject = com.tencent.mm.plugin.welab.b.iDC();
      Log.i("MicroMsg.WelabMainUI", "inInputMethod:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.hld.a.d)h.ax(com.tencent.mm.plugin.hld.a.d.class)).fKK()) });
      ((com.tencent.mm.plugin.hld.a.d)h.ax(com.tencent.mm.plugin.hld.a.d.class)).fKI();
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        break label171;
      }
      this.Xzb.setVisibility(8);
    }
    for (;;)
    {
      iDN();
      if ((this.Xzb.getVisibility() == 0) || (this.Xzc.getVisibility() == 0)) {
        break label337;
      }
      this.Xzg.setVisibility(0);
      AppMethodBeat.o(146292);
      return;
      localObject = com.tencent.mm.plugin.welab.b.iDA().iDB();
      break;
      label171:
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
        if ((!Util.isNullOrNil(locala.field_LabsAppId)) && (this.Xzh.contains(locala.field_LabsAppId))) {
          localIterator.remove();
        }
      }
      if (((List)localObject).isEmpty())
      {
        this.Xzb.setVisibility(8);
      }
      else
      {
        this.Xzb.setVisibility(0);
        Collections.sort((List)localObject, this.dFF);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a((com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next(), this.Xzd);
        }
        Log.d("MicroMsg.WelabMainUI", "get online app count " + this.Xzd.getChildCount());
      }
    }
    label337:
    this.Xzg.setVisibility(8);
    AppMethodBeat.o(146292);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    public ImageView Xzm;
    public TextView Xzn;
    public com.tencent.mm.plugin.welab.d.a.a Xzo;
    public View rootView;
    
    public a(ImageView paramImageView, TextView paramTextView, com.tencent.mm.plugin.welab.d.a.a parama, View paramView)
    {
      this.Xzm = paramImageView;
      this.Xzn = paramTextView;
      this.Xzo = parama;
      this.rootView = paramView;
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean) {}
    
    public final boolean a(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean fZD()
    {
      return false;
    }
    
    public final String getPath()
    {
      AppMethodBeat.i(262782);
      if (this.Xzo == null)
      {
        AppMethodBeat.o(262782);
        return null;
      }
      String str = (String)WelabMainUI.aYC().get(this.Xzo.field_LabsAppId);
      AppMethodBeat.o(262782);
      return str;
    }
    
    public final View getRoot()
    {
      return this.rootView;
    }
    
    public final boolean ym(boolean paramBoolean)
    {
      return false;
    }
    
    public final boolean yn(boolean paramBoolean)
    {
      return false;
    }
    
    public final boolean yo(boolean paramBoolean)
    {
      AppMethodBeat.i(262790);
      if (paramBoolean) {
        this.Xzn.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(262790);
        return true;
        this.Xzn.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabMainUI
 * JD-Core Version:    0.7.0.1
 */