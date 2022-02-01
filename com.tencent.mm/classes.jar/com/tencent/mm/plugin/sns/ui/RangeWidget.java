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
import com.tencent.mm.g.b.a.kb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.j.m;
import com.tencent.mm.plugin.sns.j.n;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
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
  private m DOH;
  SnsUploadConfigView Eoy;
  private TextView ErY;
  private String EvA;
  private String EvB;
  private View.OnClickListener EvC;
  private TextView Evs;
  private LinearLayout Evt;
  private TextView Evu;
  private View Evv;
  private boolean Evw;
  private int Evx;
  String Evy;
  private String Evz;
  private View contentView;
  private Activity mContext;
  public int style;
  private ImageView uzC;
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98227);
    this.Evw = true;
    this.Evx = 0;
    this.Evy = "";
    this.DOH = null;
    this.Evz = "";
    this.EvA = "";
    this.EvB = "";
    this.EvC = null;
    this.style = 0;
    init(paramContext);
    AppMethodBeat.o(98227);
  }
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98226);
    this.Evw = true;
    this.Evx = 0;
    this.Evy = "";
    this.DOH = null;
    this.Evz = "";
    this.EvA = "";
    this.EvB = "";
    this.EvC = null;
    this.style = 0;
    init(paramContext);
    AppMethodBeat.o(98226);
  }
  
  private static List<String> V(List<String> paramList)
  {
    AppMethodBeat.i(98229);
    LinkedList localLinkedList = new LinkedList();
    g.aAi();
    if (!g.aAf().azp())
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
      g.aAi();
      as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
      paramList = str;
      if (localas != null)
      {
        paramList = str;
        if ((int)localas.gMZ != 0) {
          paramList = localas.arJ();
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
    this.mContext = ((Activity)paramContext);
    this.contentView = View.inflate(paramContext, getLayoutResource(), this);
    this.DOH = aj.faK().DOH;
    this.Evs = ((TextView)this.contentView.findViewById(2131308239));
    this.ErY = ((TextView)this.contentView.findViewById(2131303148));
    this.uzC = ((ImageView)this.contentView.findViewById(2131306498));
    this.Evt = ((LinearLayout)this.contentView.findViewById(2131308235));
    this.Evu = ((TextView)this.contentView.findViewById(2131308234));
    this.Evv = this.contentView.findViewById(2131306501);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98224);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/RangeWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent(RangeWidget.a(RangeWidget.this), SnsLabelUI.class);
        paramAnonymousView.putExtra("KLabel_range_index", RangeWidget.b(RangeWidget.this));
        paramAnonymousView.putExtra("Klabel_name_list", RangeWidget.c(RangeWidget.this));
        paramAnonymousView.putExtra("Kother_user_name_list", RangeWidget.d(RangeWidget.this));
        paramAnonymousView.putExtra("Kchat_room_name_list", RangeWidget.e(RangeWidget.this));
        paramAnonymousView.putExtra("k_sns_label_ui_style", RangeWidget.this.style);
        RangeWidget.a(RangeWidget.this).startActivityForResult(paramAnonymousView, 5);
        paramAnonymousView = e.DUQ;
        if (paramAnonymousView.DVa != null) {
          if (paramAnonymousView.DVa.eTe > 0) {
            break label180;
          }
        }
        label180:
        for (paramAnonymousView.DVa.eTe = 1;; paramAnonymousView.DVa.eTe += 1)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/RangeWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98224);
          return;
        }
      }
    });
    if ((this.Evt != null) && (this.Evu != null) && (this.Evv != null))
    {
      this.Evt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98225);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/RangeWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (RangeWidget.f(RangeWidget.this) != null)
          {
            RangeWidget.f(RangeWidget.this).onClick(paramAnonymousView);
            e.DUQ.DVa.eTg = 1;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/RangeWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98225);
        }
      });
      int i;
      Object localObject1;
      Iterator localIterator;
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sdD, 1) == 1)
      {
        i = 1;
        this.Evv.setBackground(null);
        this.Evt.setVisibility(8);
        if ((i != 0) && (this.DOH != null) && (this.DOH.DSe != null) && (!this.DOH.DSe.isEmpty()))
        {
          localObject1 = new ArrayList();
          localIterator = this.DOH.DSe.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label430;
          }
          Object localObject2 = (n)localIterator.next();
          if (((n)localObject2).type == 1)
          {
            localObject2 = com.tencent.mm.plugin.label.a.a.ecg().aCG(((n)localObject2).name);
            if (localObject2 == null) {
              continue;
            }
            ((List)localObject1).add(localObject2);
            continue;
            i = 0;
            break;
          }
          if (((n)localObject2).type == 2)
          {
            g.aAi();
            as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(((n)localObject2).name);
            if ((localas != null) && ((int)localas.gMZ != 0)) {
              ((List)localObject1).add(((n)localObject2).name);
            }
          }
          else
          {
            ((List)localObject1).add(((n)localObject2).name);
          }
        }
        label430:
        if (!Util.isNullOrNil((List)localObject1))
        {
          this.Evv.setBackground(paramContext.getResources().getDrawable(2131233327));
          this.Evt.setVisibility(0);
          localObject1 = Util.listToString(V((List)localObject1), ",");
          this.Evu.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), String.format(paramContext.getResources().getString(2131766238), new Object[] { localObject1 }), this.Evu.getTextSize()));
          i = j;
          if (this.DOH.DSg) {
            i = 2;
          }
          e.DUQ.DVa.eTf = i;
          aj.faB().execute(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(203356);
              Object localObject1 = e.DUQ;
              Object localObject4 = RangeWidget.g(RangeWidget.this).DSe;
              if ((localObject4 != null) && (!((List)localObject4).isEmpty()) && (((e)localObject1).DVa != null))
              {
                Object localObject2 = new ArrayList();
                ArrayList localArrayList = new ArrayList();
                Object localObject3 = new ArrayList();
                localObject4 = ((List)localObject4).iterator();
                Object localObject5;
                while (((Iterator)localObject4).hasNext())
                {
                  localObject5 = (n)((Iterator)localObject4).next();
                  switch (((n)localObject5).type)
                  {
                  default: 
                    break;
                  case 0: 
                    localArrayList.add(((n)localObject5).name);
                    break;
                  case 2: 
                    ((List)localObject2).add(((n)localObject5).name);
                    break;
                  case 1: 
                    ((List)localObject3).add(((n)localObject5).name);
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
                    localObject7 = com.tencent.mm.plugin.label.a.a.ecg().aCK(com.tencent.mm.plugin.label.a.a.ecg().aCH((String)localObject6));
                    if ((localObject7 != null) && (((List)localObject7).size() != 0)) {
                      ((StringBuilder)localObject4).append((String)localObject6).append("|").append(((List)localObject7).size()).append(";");
                    }
                  }
                  ((e)localObject1).DVa.eTl = ((List)localObject3).size();
                  localObject3 = ((e)localObject1).DVa;
                  ((kb)localObject3).eTm = ((kb)localObject3).x("LatestTimelinePsotSettingLabelList", ((StringBuilder)localObject4).toString(), true);
                }
                if (((List)localObject2).size() > 0)
                {
                  localObject3 = new StringBuilder();
                  localObject4 = ((List)localObject2).iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (String)((Iterator)localObject4).next();
                    localObject6 = new ArrayList();
                    localObject7 = v.Id((String)localObject5);
                    if (localObject7 != null)
                    {
                      localObject7 = ((List)localObject7).iterator();
                      while (((Iterator)localObject7).hasNext())
                      {
                        String str = (String)((Iterator)localObject7).next();
                        if (ab.IS(str)) {
                          ((List)localObject6).add(str);
                        }
                      }
                      ((StringBuilder)localObject3).append((String)localObject5).append("|").append(((List)localObject6).size()).append(";");
                    }
                  }
                  ((e)localObject1).DVa.eTh = ((List)localObject2).size();
                  localObject2 = ((e)localObject1).DVa;
                  ((kb)localObject2).eTi = ((kb)localObject2).x("LatestTimelinePsotSettingGroupList", ((StringBuilder)localObject3).toString(), true);
                }
                ((e)localObject1).DVa.eTj = localArrayList.size();
                localObject1 = ((e)localObject1).DVa;
                ((kb)localObject1).eTk = ((kb)localObject1).x("LatestTimelinePsotSettingUinList", Util.listToString(localArrayList, "|"), true);
              }
              AppMethodBeat.o(203356);
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
    this.Evx = paramIntent.getIntExtra("Ktag_range_index", 0);
    this.Evz = paramIntent.getStringExtra("Klabel_name_list");
    this.EvA = paramIntent.getStringExtra("Kother_user_name_list");
    this.EvB = paramIntent.getStringExtra("Kchat_room_name_list");
    paramInt1 = getMaxTagNameLen();
    Object localObject = "";
    if (!Util.isNullOrNil(this.EvB))
    {
      paramIntent = Util.listToString(V(Arrays.asList(this.EvB.split(","))), ",");
      localObject = "" + paramIntent;
    }
    paramIntent = (Intent)localObject;
    if (!Util.isNullOrNil(this.Evz))
    {
      if (((String)localObject).length() > 0) {
        paramIntent = (String)localObject + "," + this.Evz;
      }
    }
    else
    {
      localObject = paramIntent;
      if (!Util.isNullOrNil(this.EvA))
      {
        localObject = Util.listToString(V(Arrays.asList(this.EvA.split(","))), ",");
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
      paramInt1 = this.Evx;
      paramIntent = com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), paramIntent, this.Evs.getTextSize());
      if (this.uzC != null)
      {
        this.uzC.setImageDrawable(ar.m(this.mContext, 2131689533, getContext().getResources().getColor(2131101414)));
        this.ErY.setTextColor(getResources().getColor(2131100566));
        this.Evs.setTextColor(getResources().getColor(2131100566));
      }
      if (this.Eoy != null) {
        this.Eoy.setPrivated(false);
      }
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98230);
      return true;
      paramIntent = (String)localObject + this.Evz;
      break;
      label462:
      localObject = paramIntent + (String)localObject;
      break label235;
      if (this.uzC != null)
      {
        this.uzC.setImageDrawable(ar.m(this.mContext, 2131689532, getContext().getResources().getColor(2131100634)));
        this.ErY.setTextColor(getResources().getColor(2131100904));
        this.Evs.setTextColor(getResources().getColor(2131100594));
      }
      this.Evs.setText(2131766098);
      continue;
      if (this.Eoy != null) {
        this.Eoy.setPrivated(true);
      }
      if ((paramAtContactWidget != null) && (this.Eoy != null) && (paramAtContactWidget.getAtList().size() > 0))
      {
        h.n(this.mContext, 2131766249, 2131755998);
        paramAtContactWidget.ffm();
        this.Eoy.fjD();
      }
      this.Evs.setText(2131766096);
      continue;
      if (this.uzC != null)
      {
        this.uzC.setImageDrawable(ar.m(this.mContext, 2131689532, getResources().getColor(2131100566)));
        this.ErY.setText(getResources().getString(2131766257));
        this.ErY.setTextColor(getResources().getColor(2131100566));
        this.Evs.setTextColor(getResources().getColor(2131100566));
      }
      this.Evs.setText(paramIntent);
      continue;
      if (this.uzC != null)
      {
        this.uzC.setImageDrawable(ar.m(this.mContext, 2131689532, -65536));
        this.ErY.setText(getResources().getString(2131766237));
        this.ErY.setTextColor(-65536);
        this.Evs.setTextColor(-65536);
      }
      this.Evs.setText(paramIntent);
    }
  }
  
  public int getLabelRange()
  {
    return this.Evx;
  }
  
  protected int getLayoutResource()
  {
    return 2131496017;
  }
  
  protected int getMaxTagNameLen()
  {
    return -1;
  }
  
  public void setEnablePrivate(boolean paramBoolean)
  {
    this.Evw = paramBoolean;
  }
  
  public void setRangeTipClickListener(View.OnClickListener paramOnClickListener)
  {
    this.EvC = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RangeWidget
 * JD-Core Version:    0.7.0.1
 */