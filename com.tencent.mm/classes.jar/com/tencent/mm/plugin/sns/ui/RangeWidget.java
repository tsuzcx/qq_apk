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
import com.tencent.mm.contact.c;
import com.tencent.mm.g.b.a.gn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private ImageView AfZ;
  SnsUploadConfigView Agc;
  private TextView Ajp;
  private TextView AmG;
  private LinearLayout AmH;
  private TextView AmI;
  private View AmJ;
  private boolean AmK;
  private int AmL;
  String AmM;
  private String AmN;
  private String AmO;
  private String AmP;
  private View.OnClickListener AmQ;
  private View contentView;
  private Activity keK;
  public int style;
  private com.tencent.mm.plugin.sns.i.l zEE;
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98227);
    this.AmK = true;
    this.AmL = 0;
    this.AmM = "";
    this.zEE = null;
    this.AmN = "";
    this.AmO = "";
    this.AmP = "";
    this.AmQ = null;
    this.style = 0;
    init(paramContext);
    AppMethodBeat.o(98227);
  }
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98226);
    this.AmK = true;
    this.AmL = 0;
    this.AmM = "";
    this.zEE = null;
    this.AmN = "";
    this.AmO = "";
    this.AmP = "";
    this.AmQ = null;
    this.style = 0;
    init(paramContext);
    AppMethodBeat.o(98226);
  }
  
  private static List<String> P(List<String> paramList)
  {
    AppMethodBeat.i(98229);
    LinkedList localLinkedList = new LinkedList();
    g.ajS();
    if (!g.ajP().aiZ())
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
      g.ajS();
      an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(str);
      paramList = str;
      if (localan != null)
      {
        paramList = str;
        if ((int)localan.ght != 0) {
          paramList = localan.adG();
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
    this.keK = ((Activity)paramContext);
    this.contentView = View.inflate(paramContext, getLayoutResource(), this);
    this.zEE = ah.dXA().zEE;
    this.AmG = ((TextView)this.contentView.findViewById(2131305083));
    this.Ajp = ((TextView)this.contentView.findViewById(2131301393));
    this.AfZ = ((ImageView)this.contentView.findViewById(2131303712));
    this.AmH = ((LinearLayout)this.contentView.findViewById(2131305079));
    this.AmI = ((TextView)this.contentView.findViewById(2131305078));
    this.AmJ = this.contentView.findViewById(2131303715);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98224);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/RangeWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent(RangeWidget.a(RangeWidget.this), SnsLabelUI.class);
        paramAnonymousView.putExtra("KLabel_range_index", RangeWidget.b(RangeWidget.this));
        paramAnonymousView.putExtra("Klabel_name_list", RangeWidget.c(RangeWidget.this));
        paramAnonymousView.putExtra("Kother_user_name_list", RangeWidget.d(RangeWidget.this));
        paramAnonymousView.putExtra("Kchat_room_name_list", RangeWidget.e(RangeWidget.this));
        paramAnonymousView.putExtra("k_sns_label_ui_style", RangeWidget.this.style);
        RangeWidget.a(RangeWidget.this).startActivityForResult(paramAnonymousView, 5);
        paramAnonymousView = e.zKO;
        if (paramAnonymousView.zKY != null) {
          if (paramAnonymousView.zKY.epB > 0) {
            break label180;
          }
        }
        label180:
        for (paramAnonymousView.zKY.epB = 1;; paramAnonymousView.zKY.epB += 1)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/RangeWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98224);
          return;
        }
      }
    });
    if ((this.AmH != null) && (this.AmI != null) && (this.AmJ != null))
    {
      this.AmH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98225);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/RangeWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (RangeWidget.f(RangeWidget.this) != null)
          {
            RangeWidget.f(RangeWidget.this).onClick(paramAnonymousView);
            e.zKO.zKY.epD = 1;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/RangeWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98225);
        }
      });
      int i;
      Object localObject1;
      Iterator localIterator;
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIw, 1) == 1)
      {
        i = 1;
        this.AmJ.setBackground(null);
        this.AmH.setVisibility(8);
        if ((i != 0) && (this.zEE != null) && (this.zEE.zIc != null) && (!this.zEE.zIc.isEmpty()))
        {
          localObject1 = new ArrayList();
          localIterator = this.zEE.zIc.iterator();
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
            localObject2 = com.tencent.mm.plugin.label.a.a.dig().apn(((m)localObject2).name);
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
            g.ajS();
            an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(((m)localObject2).name);
            if ((localan != null) && ((int)localan.ght != 0)) {
              ((List)localObject1).add(((m)localObject2).name);
            }
          }
          else
          {
            ((List)localObject1).add(((m)localObject2).name);
          }
        }
        label430:
        if (!bu.ht((List)localObject1))
        {
          this.AmJ.setBackground(paramContext.getResources().getDrawable(2131232867));
          this.AmH.setVisibility(0);
          localObject1 = bu.m(P((List)localObject1), ",");
          this.AmI.setText(k.b(getContext(), String.format(paramContext.getResources().getString(2131764000), new Object[] { localObject1 }), this.AmI.getTextSize()));
          i = j;
          if (this.zEE.zIe) {
            i = 2;
          }
          e.zKO.zKY.epC = i;
          ah.dXr().execute(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219744);
              Object localObject1 = e.zKO;
              Object localObject4 = RangeWidget.g(RangeWidget.this).zIc;
              if ((localObject4 != null) && (!((List)localObject4).isEmpty()) && (((e)localObject1).zKY != null))
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
                    localObject7 = com.tencent.mm.plugin.label.a.a.dig().apr(com.tencent.mm.plugin.label.a.a.dig().apo((String)localObject6));
                    if ((localObject7 != null) && (((List)localObject7).size() != 0)) {
                      ((StringBuilder)localObject4).append((String)localObject6).append("|").append(((List)localObject7).size()).append(";");
                    }
                  }
                  ((e)localObject1).zKY.epI = ((List)localObject3).size();
                  localObject3 = ((e)localObject1).zKY;
                  ((gn)localObject3).epJ = ((gn)localObject3).t("LatestTimelinePsotSettingLabelList", ((StringBuilder)localObject4).toString(), true);
                }
                if (((List)localObject2).size() > 0)
                {
                  localObject3 = new StringBuilder();
                  localObject4 = ((List)localObject2).iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (String)((Iterator)localObject4).next();
                    localObject6 = new ArrayList();
                    localObject7 = r.zB((String)localObject5);
                    if (localObject7 != null)
                    {
                      localObject7 = ((List)localObject7).iterator();
                      while (((Iterator)localObject7).hasNext())
                      {
                        String str = (String)((Iterator)localObject7).next();
                        if (x.An(str)) {
                          ((List)localObject6).add(str);
                        }
                      }
                      ((StringBuilder)localObject3).append((String)localObject5).append("|").append(((List)localObject6).size()).append(";");
                    }
                  }
                  ((e)localObject1).zKY.epE = ((List)localObject2).size();
                  localObject2 = ((e)localObject1).zKY;
                  ((gn)localObject2).epF = ((gn)localObject2).t("LatestTimelinePsotSettingGroupList", ((StringBuilder)localObject3).toString(), true);
                }
                ((e)localObject1).zKY.epG = localArrayList.size();
                localObject1 = ((e)localObject1).zKY;
                ((gn)localObject1).epH = ((gn)localObject1).t("LatestTimelinePsotSettingUinList", bu.m(localArrayList, "|"), true);
              }
              AppMethodBeat.o(219744);
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
    this.AmL = paramIntent.getIntExtra("Ktag_range_index", 0);
    this.AmN = paramIntent.getStringExtra("Klabel_name_list");
    this.AmO = paramIntent.getStringExtra("Kother_user_name_list");
    this.AmP = paramIntent.getStringExtra("Kchat_room_name_list");
    paramInt1 = getMaxTagNameLen();
    Object localObject = "";
    if (!bu.isNullOrNil(this.AmP))
    {
      paramIntent = bu.m(P(Arrays.asList(this.AmP.split(","))), ",");
      localObject = "" + paramIntent;
    }
    paramIntent = (Intent)localObject;
    if (!bu.isNullOrNil(this.AmN))
    {
      if (((String)localObject).length() > 0) {
        paramIntent = (String)localObject + "," + this.AmN;
      }
    }
    else
    {
      localObject = paramIntent;
      if (!bu.isNullOrNil(this.AmO))
      {
        localObject = bu.m(P(Arrays.asList(this.AmO.split(","))), ",");
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
      paramInt1 = this.AmL;
      paramIntent = k.b(getContext(), paramIntent, this.AmG.getTextSize());
      if (this.AfZ != null)
      {
        this.AfZ.setImageDrawable(ao.k(this.keK, 2131689530, getContext().getResources().getColor(2131101171)));
        this.Ajp.setTextColor(getResources().getColor(2131100464));
        this.AmG.setTextColor(getResources().getColor(2131100464));
      }
      if (this.Agc != null) {
        this.Agc.setPrivated(false);
      }
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98230);
      return true;
      paramIntent = (String)localObject + this.AmN;
      break;
      label462:
      localObject = paramIntent + (String)localObject;
      break label235;
      if (this.AfZ != null)
      {
        this.AfZ.setImageDrawable(ao.k(this.keK, 2131689529, getContext().getResources().getColor(2131100499)));
        this.Ajp.setTextColor(getResources().getColor(2131100711));
        this.AmG.setTextColor(getResources().getColor(2131100490));
      }
      this.AmG.setText(2131763871);
      continue;
      if (this.Agc != null) {
        this.Agc.setPrivated(true);
      }
      if ((paramAtContactWidget != null) && (this.Agc != null) && (paramAtContactWidget.getAtList().size() > 0))
      {
        h.l(this.keK, 2131764011, 2131755906);
        paramAtContactWidget.ecZ();
        this.Agc.ehb();
      }
      this.AmG.setText(2131763869);
      continue;
      if (this.AfZ != null)
      {
        this.AfZ.setImageDrawable(ao.k(this.keK, 2131689529, getResources().getColor(2131100464)));
        this.Ajp.setText(getResources().getString(2131764019));
        this.Ajp.setTextColor(getResources().getColor(2131100464));
        this.AmG.setTextColor(getResources().getColor(2131100464));
      }
      this.AmG.setText(paramIntent);
      continue;
      if (this.AfZ != null)
      {
        this.AfZ.setImageDrawable(ao.k(this.keK, 2131689529, -65536));
        this.Ajp.setText(getResources().getString(2131763999));
        this.Ajp.setTextColor(-65536);
        this.AmG.setTextColor(-65536);
      }
      this.AmG.setText(paramIntent);
    }
  }
  
  public int getLabelRange()
  {
    return this.AmL;
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
    this.AmK = paramBoolean;
  }
  
  public void setRangeTipClickListener(View.OnClickListener paramOnClickListener)
  {
    this.AmQ = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RangeWidget
 * JD-Core Version:    0.7.0.1
 */