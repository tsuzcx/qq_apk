package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class RangeWidget
  extends RelativeLayout
{
  private View contentView;
  private Activity kbt;
  public int style;
  private ImageView zOS;
  SnsUploadConfigView zOV;
  private TextView zSi;
  private TextView zVA;
  private View zVB;
  private boolean zVC;
  private int zVD;
  String zVE;
  private String zVF;
  private String zVG;
  private String zVH;
  private View.OnClickListener zVI;
  private TextView zVy;
  private LinearLayout zVz;
  private com.tencent.mm.plugin.sns.i.l znp;
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98227);
    this.zVC = true;
    this.zVD = 0;
    this.zVE = "";
    this.znp = null;
    this.zVF = "";
    this.zVG = "";
    this.zVH = "";
    this.zVI = null;
    this.style = 0;
    init(paramContext);
    AppMethodBeat.o(98227);
  }
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98226);
    this.zVC = true;
    this.zVD = 0;
    this.zVE = "";
    this.znp = null;
    this.zVF = "";
    this.zVG = "";
    this.zVH = "";
    this.zVI = null;
    this.style = 0;
    init(paramContext);
    AppMethodBeat.o(98226);
  }
  
  private static List<String> P(List<String> paramList)
  {
    AppMethodBeat.i(98229);
    LinkedList localLinkedList = new LinkedList();
    g.ajD();
    if (!g.ajA().aiK())
    {
      AppMethodBeat.o(98229);
      return localLinkedList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(98229);
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      g.ajD();
      am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(str);
      paramList = str;
      if (localam != null)
      {
        paramList = str;
        if ((int)localam.gfj != 0) {
          paramList = localam.adv();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(98229);
    return localLinkedList;
  }
  
  private void init(Context paramContext)
  {
    int j = 1;
    AppMethodBeat.i(98228);
    this.kbt = ((Activity)paramContext);
    this.contentView = View.inflate(paramContext, getLayoutResource(), this);
    this.znp = ag.dUa().znp;
    this.zVy = ((TextView)this.contentView.findViewById(2131305083));
    this.zSi = ((TextView)this.contentView.findViewById(2131301393));
    this.zOS = ((ImageView)this.contentView.findViewById(2131303712));
    this.zVz = ((LinearLayout)this.contentView.findViewById(2131305079));
    this.zVA = ((TextView)this.contentView.findViewById(2131305078));
    this.zVB = this.contentView.findViewById(2131303715);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98224);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/RangeWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new Intent(RangeWidget.a(RangeWidget.this), SnsLabelUI.class);
        paramAnonymousView.putExtra("KLabel_range_index", RangeWidget.b(RangeWidget.this));
        paramAnonymousView.putExtra("Klabel_name_list", RangeWidget.c(RangeWidget.this));
        paramAnonymousView.putExtra("Kother_user_name_list", RangeWidget.d(RangeWidget.this));
        paramAnonymousView.putExtra("Kchat_room_name_list", RangeWidget.e(RangeWidget.this));
        paramAnonymousView.putExtra("k_sns_label_ui_style", RangeWidget.this.style);
        RangeWidget.a(RangeWidget.this).startActivityForResult(paramAnonymousView, 5);
        paramAnonymousView = e.ztz;
        if (paramAnonymousView.ztH != null) {
          if (paramAnonymousView.ztH.enT > 0) {
            break label180;
          }
        }
        label180:
        for (paramAnonymousView.ztH.enT = 1;; paramAnonymousView.ztH.enT += 1)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/RangeWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98224);
          return;
        }
      }
    });
    if ((this.zVz != null) && (this.zVA != null) && (this.zVB != null))
    {
      this.zVz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98225);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/RangeWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (RangeWidget.f(RangeWidget.this) != null)
          {
            RangeWidget.f(RangeWidget.this).onClick(paramAnonymousView);
            e.ztz.ztH.enV = 1;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/RangeWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98225);
        }
      });
      int i;
      Object localObject1;
      Iterator localIterator;
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBd, 1) == 1)
      {
        i = 1;
        this.zVB.setBackground(null);
        this.zVz.setVisibility(8);
        if ((i != 0) && (this.znp != null) && (this.znp.zqN != null) && (!this.znp.zqN.isEmpty()))
        {
          localObject1 = new ArrayList();
          localIterator = this.znp.zqN.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label430;
          }
          Object localObject2 = (m)localIterator.next();
          if (((m)localObject2).type == 1)
          {
            localObject2 = com.tencent.mm.plugin.label.a.a.dfo().aol(((m)localObject2).name);
            if (localObject2 == null) {
              continue;
            }
            ((List)localObject1).add(localObject2);
            continue;
            i = 0;
            break;
          }
          if (((m)localObject2).type == 2)
          {
            g.ajD();
            am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(((m)localObject2).name);
            if ((localam != null) && ((int)localam.gfj != 0)) {
              ((List)localObject1).add(((m)localObject2).name);
            }
          }
          else
          {
            ((List)localObject1).add(((m)localObject2).name);
          }
        }
        label430:
        if (!bt.hj((List)localObject1))
        {
          this.zVB.setBackground(paramContext.getResources().getDrawable(2131232867));
          this.zVz.setVisibility(0);
          localObject1 = bt.m(P((List)localObject1), ",");
          this.zVA.setText(k.b(getContext(), String.format(paramContext.getResources().getString(2131764000), new Object[] { localObject1 }), this.zVA.getTextSize()));
          i = j;
          if (this.znp.zqP) {
            i = 2;
          }
          e.ztz.ztH.enU = i;
          ag.dTR().execute(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198215);
              Object localObject1 = e.ztz;
              Object localObject4 = RangeWidget.g(RangeWidget.this).zqN;
              if ((localObject4 != null) && (!((List)localObject4).isEmpty()) && (((e)localObject1).ztH != null))
              {
                Object localObject2 = new ArrayList();
                ArrayList localArrayList = new ArrayList();
                Object localObject3 = new ArrayList();
                localObject4 = ((List)localObject4).iterator();
                Object localObject5;
                while (((Iterator)localObject4).hasNext())
                {
                  localObject5 = (m)((Iterator)localObject4).next();
                  switch (((m)localObject5).type)
                  {
                  default: 
                    break;
                  case 0: 
                    localArrayList.add(((m)localObject5).name);
                    break;
                  case 2: 
                    ((List)localObject2).add(((m)localObject5).name);
                    break;
                  case 1: 
                    ((List)localObject3).add(((m)localObject5).name);
                  }
                }
                Object localObject6;
                Object localObject7;
                if (((List)localObject3).size() > 0)
                {
                  localObject4 = new StringBuilder();
                  localObject5 = ((List)localObject3).iterator();
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (String)((Iterator)localObject5).next();
                    localObject7 = com.tencent.mm.plugin.label.a.a.dfo().aop(com.tencent.mm.plugin.label.a.a.dfo().aom((String)localObject6));
                    if ((localObject7 != null) && (((List)localObject7).size() != 0)) {
                      ((StringBuilder)localObject4).append((String)localObject6).append("|").append(((List)localObject7).size()).append(";");
                    }
                  }
                  ((e)localObject1).ztH.eoa = ((List)localObject3).size();
                  localObject3 = ((e)localObject1).ztH;
                  ((gl)localObject3).eob = ((gl)localObject3).t("LatestTimelinePsotSettingLabelList", ((StringBuilder)localObject4).toString(), true);
                }
                if (((List)localObject2).size() > 0)
                {
                  localObject3 = new StringBuilder();
                  localObject4 = ((List)localObject2).iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (String)((Iterator)localObject4).next();
                    localObject6 = new ArrayList();
                    localObject7 = q.yR((String)localObject5);
                    if (localObject7 != null)
                    {
                      localObject7 = ((List)localObject7).iterator();
                      while (((Iterator)localObject7).hasNext())
                      {
                        String str = (String)((Iterator)localObject7).next();
                        if (w.zD(str)) {
                          ((List)localObject6).add(str);
                        }
                      }
                      ((StringBuilder)localObject3).append((String)localObject5).append("|").append(((List)localObject6).size()).append(";");
                    }
                  }
                  ((e)localObject1).ztH.enW = ((List)localObject2).size();
                  localObject2 = ((e)localObject1).ztH;
                  ((gl)localObject2).enX = ((gl)localObject2).t("LatestTimelinePsotSettingGroupList", ((StringBuilder)localObject3).toString(), true);
                }
                ((e)localObject1).ztH.enY = localArrayList.size();
                localObject1 = ((e)localObject1).ztH;
                ((gl)localObject1).enZ = ((gl)localObject1).t("LatestTimelinePsotSettingUinList", bt.m(localArrayList, "|"), true);
              }
              AppMethodBeat.o(198215);
            }
          });
        }
      }
    }
    AppMethodBeat.o(98228);
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent, AtContactWidget paramAtContactWidget)
  {
    AppMethodBeat.i(98230);
    this.zVD = paramIntent.getIntExtra("Ktag_range_index", 0);
    this.zVF = paramIntent.getStringExtra("Klabel_name_list");
    this.zVG = paramIntent.getStringExtra("Kother_user_name_list");
    this.zVH = paramIntent.getStringExtra("Kchat_room_name_list");
    paramInt1 = getMaxTagNameLen();
    Object localObject = "";
    if (!bt.isNullOrNil(this.zVH))
    {
      paramIntent = bt.m(P(Arrays.asList(this.zVH.split(","))), ",");
      localObject = "" + paramIntent;
    }
    paramIntent = (Intent)localObject;
    if (!bt.isNullOrNil(this.zVF))
    {
      if (((String)localObject).length() > 0) {
        paramIntent = (String)localObject + "," + this.zVF;
      }
    }
    else
    {
      localObject = paramIntent;
      if (!bt.isNullOrNil(this.zVG))
      {
        localObject = bt.m(P(Arrays.asList(this.zVG.split(","))), ",");
        if (paramIntent.length() <= 0) {
          break label462;
        }
        localObject = paramIntent + "," + (String)localObject;
      }
      label235:
      paramIntent = (Intent)localObject;
      if (paramInt1 != -1)
      {
        paramIntent = (Intent)localObject;
        if (localObject != null)
        {
          paramIntent = (Intent)localObject;
          if (((String)localObject).length() > paramInt1) {
            paramIntent = ((String)localObject).substring(0, paramInt1) + "...";
          }
        }
      }
      paramInt1 = this.zVD;
      paramIntent = k.b(getContext(), paramIntent, this.zVy.getTextSize());
      if (this.zOS != null)
      {
        this.zOS.setImageDrawable(ao.k(this.kbt, 2131689530, getContext().getResources().getColor(2131101171)));
        this.zSi.setTextColor(getResources().getColor(2131100464));
        this.zVy.setTextColor(getResources().getColor(2131100464));
      }
      if (this.zOV != null) {
        this.zOV.setPrivated(false);
      }
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98230);
      return true;
      paramIntent = (String)localObject + this.zVF;
      break;
      label462:
      localObject = paramIntent + (String)localObject;
      break label235;
      if (this.zOS != null)
      {
        this.zOS.setImageDrawable(ao.k(this.kbt, 2131689529, getContext().getResources().getColor(2131100499)));
        this.zSi.setTextColor(getResources().getColor(2131100711));
        this.zVy.setTextColor(getResources().getColor(2131100490));
      }
      this.zVy.setText(2131763871);
      continue;
      if (this.zOV != null) {
        this.zOV.setPrivated(true);
      }
      if ((paramAtContactWidget != null) && (this.zOV != null) && (paramAtContactWidget.getAtList().size() > 0))
      {
        h.l(this.kbt, 2131764011, 2131755906);
        paramAtContactWidget.dZu();
        this.zOV.edu();
      }
      this.zVy.setText(2131763869);
      continue;
      if (this.zOS != null)
      {
        this.zOS.setImageDrawable(ao.k(this.kbt, 2131689529, getResources().getColor(2131100464)));
        this.zSi.setText(getResources().getString(2131764019));
        this.zSi.setTextColor(getResources().getColor(2131100464));
        this.zVy.setTextColor(getResources().getColor(2131100464));
      }
      this.zVy.setText(paramIntent);
      continue;
      if (this.zOS != null)
      {
        this.zOS.setImageDrawable(ao.k(this.kbt, 2131689529, -65536));
        this.zSi.setText(getResources().getString(2131763999));
        this.zSi.setTextColor(-65536);
        this.zVy.setTextColor(-65536);
      }
      this.zVy.setText(paramIntent);
    }
  }
  
  public int getLabelRange()
  {
    return this.zVD;
  }
  
  protected int getLayoutResource()
  {
    return 2131495174;
  }
  
  protected int getMaxTagNameLen()
  {
    return -1;
  }
  
  public void setEnablePrivate(boolean paramBoolean)
  {
    this.zVC = paramBoolean;
  }
  
  public void setRangeTipClickListener(View.OnClickListener paramOnClickListener)
  {
    this.zVI = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RangeWidget
 * JD-Core Version:    0.7.0.1
 */