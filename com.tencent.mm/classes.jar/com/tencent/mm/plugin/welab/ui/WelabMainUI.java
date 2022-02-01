package com.tencent.mm.plugin.welab.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.welab.a.a;
import com.tencent.mm.plugin.welab.a.b;
import com.tencent.mm.plugin.welab.a.c;
import com.tencent.mm.plugin.welab.a.d;
import com.tencent.mm.plugin.welab.a.e;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.protocal.protobuf.erx;
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

@com.tencent.mm.kernel.k
public class WelabMainUI
  extends MMActivity
{
  private static final Map<String, String> QFK;
  private LinearLayout QFD;
  private LinearLayout QFE;
  private LinearLayout QFF;
  private LinearLayout QFG;
  private View QFH;
  private View QFI;
  private List<String> QFJ;
  private View.OnClickListener QFL;
  private View.OnLongClickListener QFM;
  private boolean QFs;
  private Comparator<com.tencent.mm.plugin.welab.d.a.a> bLX;
  
  static
  {
    AppMethodBeat.i(248574);
    QFK = new WelabMainUI.3();
    AppMethodBeat.o(248574);
  }
  
  public WelabMainUI()
  {
    AppMethodBeat.i(146289);
    this.QFs = false;
    this.bLX = new WelabMainUI.4(this);
    this.QFL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(248577);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/welab/ui/WelabMainUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
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
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/welab/ui/WelabMainUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((WelabMainUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/welab/ui/WelabMainUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = com.tencent.mm.plugin.welab.e.b.hdh();
            localObject2 = paramAnonymousView.field_LabsAppId;
            ((com.tencent.mm.plugin.welab.e.b)localObject1).QFi.put(localObject2, Integer.valueOf(1));
            ((com.tencent.mm.plugin.welab.e.b)localObject1).tag = (((com.tencent.mm.plugin.welab.e.b)localObject1).tag + "&" + (String)localObject2 + "=1");
            h.aHG().aHp().set(ar.a.Vqj, ((com.tencent.mm.plugin.welab.e.b)localObject1).tag);
            com.tencent.mm.plugin.welab.e.b.hdj();
            localObject1 = (String)WelabMainUI.QFK.get(paramAnonymousView.field_LabsAppId);
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              com.tencent.mm.plugin.newtips.a.fiO().aap(g.aSW((String)localObject1));
            }
            Log.i("MicroMsg.WelabMainUI", "click ".concat(String.valueOf(paramAnonymousView)));
          }
        }
        else
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/welab/ui/WelabMainUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(248577);
          return;
        }
        ((Intent)localObject2).putExtra("para_appid", paramAnonymousView.field_LabsAppId);
        if (com.tencent.mm.plugin.welab.e.b.hdh().e(paramAnonymousView)) {}
        for (int i = 1;; i = 0)
        {
          ((Intent)localObject2).putExtra("para_from_with_red_point", i);
          ((Intent)localObject2).setClass(WelabMainUI.this, WelabAppInfoUI.class);
          break;
        }
      }
    };
    this.QFM = new WelabMainUI.6(this);
    AppMethodBeat.o(146289);
  }
  
  private void a(com.tencent.mm.plugin.welab.d.a.a parama, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(146295);
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(a.d.QEU, paramLinearLayout, false);
    Object localObject = (ImageView)localLinearLayout.findViewById(a.c.QER);
    ImageView localImageView = (ImageView)localLinearLayout.findViewById(a.c.app_img);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(a.c.title);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(a.c.summary);
    TextView localTextView3 = (TextView)localLinearLayout.findViewById(a.c.QES);
    if (com.tencent.mm.plugin.welab.e.b.hdh().e(parama))
    {
      ((ImageView)localObject).setVisibility(0);
      if (!Util.isEqual(parama.field_LabsAppId, "wximeplugin")) {
        break label206;
      }
      localImageView.setImageResource(a.b.QEH);
    }
    for (;;)
    {
      com.tencent.mm.plugin.welab.b.hcS();
      localTextView1.setText(com.tencent.mm.plugin.welab.b.a(parama));
      localTextView2.setText(parama.bnH("field_Desc"));
      localLinearLayout.setTag(parama);
      localLinearLayout.setOnClickListener(this.QFL);
      localLinearLayout.setOnLongClickListener(this.QFM);
      paramLinearLayout.addView(localLinearLayout);
      AppMethodBeat.o(146295);
      return;
      ((ImageView)localObject).setVisibility(8);
      localObject = new a((ImageView)localObject, localTextView3, parama, localLinearLayout);
      com.tencent.mm.plugin.newtips.a.fiO().h((com.tencent.mm.plugin.newtips.a.a)localObject);
      break;
      label206:
      com.tencent.mm.ay.a.a.bms().a(parama.bnH("field_ThumbUrl"), localImageView, com.tencent.mm.plugin.welab.b.hcS().PCP);
    }
  }
  
  private void hdg()
  {
    AppMethodBeat.i(146294);
    Object localObject = com.tencent.mm.plugin.welab.b.hcS().QFd.hda();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
      if ((System.currentTimeMillis() / 1000L - locala.field_endtime >= 2592000L) || ("labs1de6f3".equals(locala.field_LabsAppId)))
      {
        localIterator.remove();
        com.tencent.mm.plugin.welab.b.QFc.QFd.delete(locala, new String[0]);
      }
      else if ((locala.isExpired()) && (locala.field_Switch != 3))
      {
        locala.field_Switch = 3;
        com.tencent.mm.plugin.welab.b.QFc.QFd.update(locala, new String[0]);
      }
      else if (locala.field_Switch != 3)
      {
        localIterator.remove();
      }
    }
    Log.i("WelabMgr", "stopped lab %s", new Object[] { localObject.toString() });
    if (((List)localObject).isEmpty())
    {
      this.QFE.setVisibility(8);
      AppMethodBeat.o(146294);
      return;
    }
    this.QFE.setVisibility(0);
    Collections.sort((List)localObject, this.bLX);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next(), this.QFG);
    }
    Log.d("MicroMsg.WelabMainUI", "get online app count " + this.QFG.getChildCount());
    AppMethodBeat.o(146294);
  }
  
  public int getLayoutId()
  {
    return a.d.QEW;
  }
  
  public void initView()
  {
    AppMethodBeat.i(146291);
    setMMTitle(a.e.QEZ);
    setTitleDividerColor(a.a.white);
    setActionbarColor(getResources().getColor(a.a.QEG));
    setActionbarElementColor(getResources().getColor(a.a.White));
    this.QFD = ((LinearLayout)findViewById(a.c.QEM));
    this.QFF = ((LinearLayout)findViewById(a.c.QEN));
    this.QFE = ((LinearLayout)findViewById(a.c.QEO));
    this.QFG = ((LinearLayout)findViewById(a.c.QEP));
    this.QFH = findViewById(a.c.privacy_detail);
    this.QFI = findViewById(a.c.QEL);
    this.QFH.setOnClickListener(new WelabMainUI.1(this));
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
      this.QFs = bool;
      this.QFJ = getIntent().getStringArrayListExtra("key_exclude_apps");
    }
    initView();
    com.tencent.mm.plugin.welab.e.b.hdh();
    MMApplicationContext.getDefaultPreference().edit().putBoolean("key_has_enter_welab", true).commit();
    com.tencent.mm.plugin.welab.e.b.hdj();
    e.C("", 1, this.QFs);
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
    this.QFF.removeAllViews();
    this.QFG.removeAllViews();
    Object localObject;
    if (((d)h.ae(d.class)).gK(getContext()))
    {
      com.tencent.mm.plugin.welab.b.hcS();
      localObject = com.tencent.mm.plugin.welab.b.hcU();
      Log.i("MicroMsg.WelabMainUI", "inInputMethod:%s", new Object[] { Boolean.valueOf(((d)h.ae(d.class)).eCH()) });
      ((d)h.ae(d.class)).eCF();
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        break label171;
      }
      this.QFD.setVisibility(8);
    }
    for (;;)
    {
      hdg();
      if ((this.QFD.getVisibility() == 0) || (this.QFE.getVisibility() == 0)) {
        break label337;
      }
      this.QFI.setVisibility(0);
      AppMethodBeat.o(146292);
      return;
      localObject = com.tencent.mm.plugin.welab.b.hcS().hcT();
      break;
      label171:
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
        if ((!Util.isNullOrNil(locala.field_LabsAppId)) && (this.QFJ.contains(locala.field_LabsAppId))) {
          localIterator.remove();
        }
      }
      if (((List)localObject).isEmpty())
      {
        this.QFD.setVisibility(8);
      }
      else
      {
        this.QFD.setVisibility(0);
        Collections.sort((List)localObject, this.bLX);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a((com.tencent.mm.plugin.welab.d.a.a)((Iterator)localObject).next(), this.QFF);
        }
        Log.d("MicroMsg.WelabMainUI", "get online app count " + this.QFF.getChildCount());
      }
    }
    label337:
    this.QFI.setVisibility(8);
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
    public ImageView QFO;
    public TextView QFP;
    public com.tencent.mm.plugin.welab.d.a.a QFQ;
    public View oFW;
    
    public a(ImageView paramImageView, TextView paramTextView, com.tencent.mm.plugin.welab.d.a.a parama, View paramView)
    {
      this.QFO = paramImageView;
      this.QFP = paramTextView;
      this.QFQ = parama;
      this.oFW = paramView;
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean) {}
    
    public final boolean a(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean eQW()
    {
      return false;
    }
    
    public final String getPath()
    {
      AppMethodBeat.i(248533);
      if (this.QFQ == null)
      {
        AppMethodBeat.o(248533);
        return null;
      }
      String str = (String)WelabMainUI.QFK.get(this.QFQ.field_LabsAppId);
      AppMethodBeat.o(248533);
      return str;
    }
    
    public final View getRoot()
    {
      return this.oFW;
    }
    
    public final boolean tX(boolean paramBoolean)
    {
      return false;
    }
    
    public final boolean tY(boolean paramBoolean)
    {
      return false;
    }
    
    public final boolean tZ(boolean paramBoolean)
    {
      AppMethodBeat.i(248536);
      if (paramBoolean) {
        this.QFP.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(248536);
        return true;
        this.QFP.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabMainUI
 * JD-Core Version:    0.7.0.1
 */