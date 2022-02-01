package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.pv;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.k.m;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class RangeWidget
  extends RelativeLayout
{
  private m Qzf;
  private WeImageView Rbm;
  SnsUploadConfigView Rbp;
  private TextView ReT;
  private TextView RiK;
  private LinearLayout RiL;
  private TextView RiM;
  private View RiN;
  private boolean RiO;
  private int RiP;
  String RiQ;
  private String RiR;
  private String RiS;
  private String RiT;
  private View.OnClickListener RiU;
  public boolean RiV;
  private View contentView;
  private Activity mContext;
  public int style;
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98227);
    this.RiO = true;
    this.RiP = 0;
    this.RiQ = "";
    this.Qzf = null;
    this.RiR = "";
    this.RiS = "";
    this.RiT = "";
    this.RiU = null;
    this.style = 0;
    this.RiV = false;
    init(paramContext);
    AppMethodBeat.o(98227);
  }
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98226);
    this.RiO = true;
    this.RiP = 0;
    this.RiQ = "";
    this.Qzf = null;
    this.RiR = "";
    this.RiS = "";
    this.RiT = "";
    this.RiU = null;
    this.style = 0;
    this.RiV = false;
    init(paramContext);
    AppMethodBeat.o(98226);
  }
  
  private static List<String> bs(List<String> paramList)
  {
    AppMethodBeat.i(98229);
    LinkedList localLinkedList = new LinkedList();
    h.baF();
    if (!h.baC().aZN())
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
      h.baF();
      au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(str);
      paramList = str;
      if (localau != null)
      {
        paramList = str;
        if ((int)localau.maN != 0) {
          paramList = localau.aSV();
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
    this.Qzf = al.hgx().Qzf;
    this.RiK = ((TextView)this.contentView.findViewById(b.f.sns_tag_range_list));
    this.ReT = ((TextView)this.contentView.findViewById(b.f.left_tv));
    this.Rbm = ((WeImageView)this.contentView.findViewById(b.f.rang_icon));
    this.RiL = ((LinearLayout)this.contentView.findViewById(b.f.sns_tag_last_range_list_group));
    this.RiM = ((TextView)this.contentView.findViewById(b.f.sns_tag_last_range_list));
    this.RiN = this.contentView.findViewById(b.f.range_content_group);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98224);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/RangeWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new Intent(RangeWidget.a(RangeWidget.this), SnsLabelUI.class);
        paramAnonymousView.putExtra("KLabel_range_index", RangeWidget.b(RangeWidget.this));
        paramAnonymousView.putExtra("Klabel_name_list", RangeWidget.c(RangeWidget.this));
        paramAnonymousView.putExtra("Kother_user_name_list", RangeWidget.d(RangeWidget.this));
        paramAnonymousView.putExtra("Kchat_room_name_list", RangeWidget.e(RangeWidget.this));
        paramAnonymousView.putExtra("k_sns_label_ui_style", RangeWidget.this.style);
        paramAnonymousView.putExtra("Kis_with_together", RangeWidget.this.RiV);
        com.tencent.mm.hellhoundlib.a.a.a(RangeWidget.a(RangeWidget.this), com.tencent.mm.hellhoundlib.b.c.a(5, new com.tencent.mm.hellhoundlib.b.a()).cG(paramAnonymousView).aYi(), "com/tencent/mm/plugin/sns/ui/RangeWidget$1", "onClick", "(Landroid/view/View;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
        paramAnonymousView = j.QFS;
        if (paramAnonymousView.QGd != null) {
          if (paramAnonymousView.QGd.joO > 0) {
            break label223;
          }
        }
        label223:
        for (paramAnonymousView.QGd.joO = 1;; paramAnonymousView.QGd.joO += 1)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/RangeWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98224);
          return;
        }
      }
    });
    if ((this.RiL != null) && (this.RiM != null) && (this.RiN != null))
    {
      this.RiL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98225);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/RangeWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (RangeWidget.f(RangeWidget.this) != null)
          {
            RangeWidget.f(RangeWidget.this).onClick(paramAnonymousView);
            j.QFS.QGd.joQ = 1;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/RangeWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98225);
        }
      });
      int i;
      Object localObject1;
      Iterator localIterator;
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zeW, 1) == 1)
      {
        i = 1;
        this.RiN.setBackground(null);
        this.RiL.setVisibility(8);
        if ((i != 0) && (this.Qzf != null) && (this.Qzf.QCT != null) && (!this.Qzf.QCT.isEmpty()))
        {
          localObject1 = new ArrayList();
          localIterator = this.Qzf.QCT.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label436;
          }
          Object localObject2 = (com.tencent.mm.plugin.sns.k.n)localIterator.next();
          if (((com.tencent.mm.plugin.sns.k.n)localObject2).type == 1)
          {
            localObject2 = com.tencent.mm.plugin.label.a.a.fTb().aJG(((com.tencent.mm.plugin.sns.k.n)localObject2).name);
            if (localObject2 == null) {
              continue;
            }
            ((List)localObject1).add(localObject2);
            continue;
            i = 0;
            break;
          }
          if (((com.tencent.mm.plugin.sns.k.n)localObject2).type == 2)
          {
            h.baF();
            au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(((com.tencent.mm.plugin.sns.k.n)localObject2).name);
            if ((localau != null) && ((int)localau.maN != 0)) {
              ((List)localObject1).add(((com.tencent.mm.plugin.sns.k.n)localObject2).name);
            }
          }
          else
          {
            ((List)localObject1).add(((com.tencent.mm.plugin.sns.k.n)localObject2).name);
          }
        }
        label436:
        if (!Util.isNullOrNil((List)localObject1))
        {
          this.RiN.setBackground(paramContext.getResources().getDrawable(b.e.list_item_normal));
          this.RiL.setVisibility(0);
          localObject1 = Util.listToString(bs((List)localObject1), ",");
          this.RiM.setText(p.b(getContext(), String.format(paramContext.getResources().getString(b.j.sns_tag_last_tip), new Object[] { localObject1 }), this.RiM.getTextSize()));
          i = j;
          if (this.Qzf.QCV) {
            i = 2;
          }
          j.QFS.QGd.joP = i;
          al.hgo().execute(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(308242);
              Object localObject1 = j.QFS;
              Object localObject4 = RangeWidget.g(RangeWidget.this).QCT;
              if ((localObject4 != null) && (!((List)localObject4).isEmpty()) && (((j)localObject1).QGd != null))
              {
                Object localObject2 = new ArrayList();
                ArrayList localArrayList = new ArrayList();
                Object localObject3 = new ArrayList();
                localObject4 = ((List)localObject4).iterator();
                Object localObject5;
                while (((Iterator)localObject4).hasNext())
                {
                  localObject5 = (com.tencent.mm.plugin.sns.k.n)((Iterator)localObject4).next();
                  switch (((com.tencent.mm.plugin.sns.k.n)localObject5).type)
                  {
                  default: 
                    break;
                  case 0: 
                    localArrayList.add(((com.tencent.mm.plugin.sns.k.n)localObject5).name);
                    break;
                  case 2: 
                    ((List)localObject2).add(((com.tencent.mm.plugin.sns.k.n)localObject5).name);
                    break;
                  case 1: 
                    ((List)localObject3).add(((com.tencent.mm.plugin.sns.k.n)localObject5).name);
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
                    localObject7 = com.tencent.mm.plugin.label.a.a.fTb().aJK(com.tencent.mm.plugin.label.a.a.fTb().aJH((String)localObject6));
                    if ((localObject7 != null) && (((List)localObject7).size() != 0)) {
                      ((StringBuilder)localObject4).append((String)localObject6).append("|").append(((List)localObject7).size()).append(";");
                    }
                  }
                  ((j)localObject1).QGd.joV = ((List)localObject3).size();
                  localObject3 = ((j)localObject1).QGd;
                  ((pv)localObject3).joW = ((pv)localObject3).F("LatestTimelinePsotSettingLabelList", ((StringBuilder)localObject4).toString(), true);
                }
                if (((List)localObject2).size() > 0)
                {
                  localObject3 = new StringBuilder();
                  localObject4 = ((List)localObject2).iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (String)((Iterator)localObject4).next();
                    localObject6 = new ArrayList();
                    localObject7 = v.Im((String)localObject5);
                    if (localObject7 != null)
                    {
                      localObject7 = ((List)localObject7).iterator();
                      while (((Iterator)localObject7).hasNext())
                      {
                        String str = (String)((Iterator)localObject7).next();
                        if (ab.IR(str)) {
                          ((List)localObject6).add(str);
                        }
                      }
                      ((StringBuilder)localObject3).append((String)localObject5).append("|").append(((List)localObject6).size()).append(";");
                    }
                  }
                  ((j)localObject1).QGd.joR = ((List)localObject2).size();
                  localObject2 = ((j)localObject1).QGd;
                  ((pv)localObject2).joS = ((pv)localObject2).F("LatestTimelinePsotSettingGroupList", ((StringBuilder)localObject3).toString(), true);
                }
                ((j)localObject1).QGd.joT = localArrayList.size();
                localObject1 = ((j)localObject1).QGd;
                ((pv)localObject1).joU = ((pv)localObject1).F("LatestTimelinePsotSettingUinList", Util.listToString(localArrayList, "|"), true);
              }
              AppMethodBeat.o(308242);
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
    this.RiP = paramIntent.getIntExtra("Ktag_range_index", 0);
    this.RiR = paramIntent.getStringExtra("Klabel_name_list");
    this.RiS = paramIntent.getStringExtra("Kother_user_name_list");
    this.RiT = paramIntent.getStringExtra("Kchat_room_name_list");
    paramInt1 = getMaxTagNameLen();
    Object localObject = "";
    if (!Util.isNullOrNil(this.RiT))
    {
      paramIntent = Util.listToString(bs(Arrays.asList(this.RiT.split(","))), ",");
      localObject = "" + paramIntent;
    }
    paramIntent = (Intent)localObject;
    if (!Util.isNullOrNil(this.RiR))
    {
      if (((String)localObject).length() > 0) {
        paramIntent = (String)localObject + "," + this.RiR;
      }
    }
    else
    {
      localObject = paramIntent;
      if (!Util.isNullOrNil(this.RiS))
      {
        localObject = Util.listToString(bs(Arrays.asList(this.RiS.split(","))), ",");
        if (paramIntent.length() <= 0) {
          break label446;
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
      paramInt1 = this.RiP;
      paramIntent = p.b(getContext(), paramIntent, this.RiK.getTextSize());
      if (this.Rbm != null)
      {
        this.Rbm.oR(b.i.album_group_icon_pressed, b.c.wechat_green);
        this.ReT.setTextColor(getResources().getColor(b.c.green_text_color));
        this.RiK.setTextColor(getResources().getColor(b.c.green_text_color));
      }
      if (this.Rbp != null) {
        this.Rbp.setPrivated(false);
      }
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98230);
      return true;
      paramIntent = (String)localObject + this.RiR;
      break;
      label446:
      localObject = paramIntent + (String)localObject;
      break label235;
      if (this.Rbm != null)
      {
        this.Rbm.oR(b.i.album_group_icon_normal, b.c.icon_color);
        this.ReT.setTextColor(getResources().getColor(b.c.normal_text_color));
        this.RiK.setTextColor(getResources().getColor(b.c.desc_text_color));
      }
      this.RiK.setText(b.j.sns_label_public);
      continue;
      if (this.Rbp != null) {
        this.Rbp.setPrivated(true);
      }
      if ((paramAtContactWidget != null) && (this.Rbp != null) && (paramAtContactWidget.getAtList().size() > 0))
      {
        k.s(this.mContext, b.j.sns_tag_privacy_with_others_tip, b.j.app_tip);
        paramAtContactWidget.hlx();
        this.Rbp.hql();
      }
      this.RiK.setText(b.j.sns_label_private);
      continue;
      if (this.Rbm != null)
      {
        this.ReT.setText(getResources().getString(b.j.sns_tag_visibl_range));
        this.ReT.setTextColor(getResources().getColor(b.c.green_text_color));
        this.RiK.setTextColor(getResources().getColor(b.c.green_text_color));
      }
      this.RiK.setText(paramIntent);
      continue;
      if (this.Rbm != null)
      {
        this.Rbm.setIconColor(-65536);
        this.ReT.setText(getResources().getString(b.j.sns_tag_invisibl_range));
        this.ReT.setTextColor(-65536);
        this.RiK.setTextColor(-65536);
      }
      this.RiK.setText(paramIntent);
    }
  }
  
  public int getLabelRange()
  {
    return this.RiP;
  }
  
  protected int getLayoutResource()
  {
    return b.g.rang_layout;
  }
  
  protected int getMaxTagNameLen()
  {
    return -1;
  }
  
  public void setEnablePrivate(boolean paramBoolean)
  {
    this.RiO = paramBoolean;
  }
  
  public void setRangeTipClickListener(View.OnClickListener paramOnClickListener)
  {
    this.RiU = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RangeWidget
 * JD-Core Version:    0.7.0.1
 */