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
import com.tencent.mm.contact.d;
import com.tencent.mm.f.b.a.mt;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.j.m;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class RangeWidget
  extends RelativeLayout
{
  SnsUploadConfigView KBH;
  private TextView KFt;
  private TextView KJj;
  private LinearLayout KJk;
  private TextView KJl;
  private View KJm;
  private boolean KJn;
  private int KJo;
  String KJp;
  private String KJq;
  private String KJr;
  private String KJs;
  private View.OnClickListener KJt;
  private m KbO;
  private View contentView;
  private Activity mContext;
  public int style;
  private ImageView yVe;
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98227);
    this.KJn = true;
    this.KJo = 0;
    this.KJp = "";
    this.KbO = null;
    this.KJq = "";
    this.KJr = "";
    this.KJs = "";
    this.KJt = null;
    this.style = 0;
    init(paramContext);
    AppMethodBeat.o(98227);
  }
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98226);
    this.KJn = true;
    this.KJo = 0;
    this.KJp = "";
    this.KbO = null;
    this.KJq = "";
    this.KJr = "";
    this.KJs = "";
    this.KJt = null;
    this.style = 0;
    init(paramContext);
    AppMethodBeat.o(98226);
  }
  
  private static List<String> S(List<String> paramList)
  {
    AppMethodBeat.i(98229);
    LinkedList localLinkedList = new LinkedList();
    com.tencent.mm.kernel.h.aHH();
    if (!com.tencent.mm.kernel.h.aHE().aGM())
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
      com.tencent.mm.kernel.h.aHH();
      as localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(str);
      paramList = str;
      if (localas != null)
      {
        paramList = str;
        if ((int)localas.jxt != 0) {
          paramList = localas.ays();
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
    this.KbO = aj.fOE().KbO;
    this.KJj = ((TextView)this.contentView.findViewById(i.f.sns_tag_range_list));
    this.KFt = ((TextView)this.contentView.findViewById(i.f.left_tv));
    this.yVe = ((ImageView)this.contentView.findViewById(i.f.rang_icon));
    this.KJk = ((LinearLayout)this.contentView.findViewById(i.f.sns_tag_last_range_list_group));
    this.KJl = ((TextView)this.contentView.findViewById(i.f.sns_tag_last_range_list));
    this.KJm = this.contentView.findViewById(i.f.range_content_group);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98224);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/RangeWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Intent(RangeWidget.a(RangeWidget.this), SnsLabelUI.class);
        paramAnonymousView.putExtra("KLabel_range_index", RangeWidget.b(RangeWidget.this));
        paramAnonymousView.putExtra("Klabel_name_list", RangeWidget.c(RangeWidget.this));
        paramAnonymousView.putExtra("Kother_user_name_list", RangeWidget.d(RangeWidget.this));
        paramAnonymousView.putExtra("Kchat_room_name_list", RangeWidget.e(RangeWidget.this));
        paramAnonymousView.putExtra("k_sns_label_ui_style", RangeWidget.this.style);
        RangeWidget.a(RangeWidget.this).startActivityForResult(paramAnonymousView, 5);
        paramAnonymousView = g.Kia;
        if (paramAnonymousView.Kik != null) {
          if (paramAnonymousView.Kik.gVs > 0) {
            break label180;
          }
        }
        label180:
        for (paramAnonymousView.Kik.gVs = 1;; paramAnonymousView.Kik.gVs += 1)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/RangeWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98224);
          return;
        }
      }
    });
    if ((this.KJk != null) && (this.KJl != null) && (this.KJm != null))
    {
      this.KJk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98225);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/RangeWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (RangeWidget.f(RangeWidget.this) != null)
          {
            RangeWidget.f(RangeWidget.this).onClick(paramAnonymousView);
            g.Kia.Kik.gVu = 1;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/RangeWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98225);
        }
      });
      int i;
      Object localObject1;
      Iterator localIterator;
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vMX, 1) == 1)
      {
        i = 1;
        this.KJm.setBackground(null);
        this.KJk.setVisibility(8);
        if ((i != 0) && (this.KbO != null) && (this.KbO.Kfm != null) && (!this.KbO.Kfm.isEmpty()))
        {
          localObject1 = new ArrayList();
          localIterator = this.KbO.Kfm.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label436;
          }
          Object localObject2 = (com.tencent.mm.plugin.sns.j.n)localIterator.next();
          if (((com.tencent.mm.plugin.sns.j.n)localObject2).type == 1)
          {
            localObject2 = com.tencent.mm.plugin.label.a.a.eLe().aMN(((com.tencent.mm.plugin.sns.j.n)localObject2).name);
            if (localObject2 == null) {
              continue;
            }
            ((List)localObject1).add(localObject2);
            continue;
            i = 0;
            break;
          }
          if (((com.tencent.mm.plugin.sns.j.n)localObject2).type == 2)
          {
            com.tencent.mm.kernel.h.aHH();
            as localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(((com.tencent.mm.plugin.sns.j.n)localObject2).name);
            if ((localas != null) && ((int)localas.jxt != 0)) {
              ((List)localObject1).add(((com.tencent.mm.plugin.sns.j.n)localObject2).name);
            }
          }
          else
          {
            ((List)localObject1).add(((com.tencent.mm.plugin.sns.j.n)localObject2).name);
          }
        }
        label436:
        if (!Util.isNullOrNil((List)localObject1))
        {
          this.KJm.setBackground(paramContext.getResources().getDrawable(i.e.list_item_normal));
          this.KJk.setVisibility(0);
          localObject1 = Util.listToString(S((List)localObject1), ",");
          this.KJl.setText(l.b(getContext(), String.format(paramContext.getResources().getString(i.j.sns_tag_last_tip), new Object[] { localObject1 }), this.KJl.getTextSize()));
          i = j;
          if (this.KbO.Kfo) {
            i = 2;
          }
          g.Kia.Kik.gVt = i;
          aj.fOv().execute(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(265656);
              Object localObject1 = g.Kia;
              Object localObject4 = RangeWidget.g(RangeWidget.this).Kfm;
              if ((localObject4 != null) && (!((List)localObject4).isEmpty()) && (((g)localObject1).Kik != null))
              {
                Object localObject2 = new ArrayList();
                ArrayList localArrayList = new ArrayList();
                Object localObject3 = new ArrayList();
                localObject4 = ((List)localObject4).iterator();
                Object localObject5;
                while (((Iterator)localObject4).hasNext())
                {
                  localObject5 = (com.tencent.mm.plugin.sns.j.n)((Iterator)localObject4).next();
                  switch (((com.tencent.mm.plugin.sns.j.n)localObject5).type)
                  {
                  default: 
                    break;
                  case 0: 
                    localArrayList.add(((com.tencent.mm.plugin.sns.j.n)localObject5).name);
                    break;
                  case 2: 
                    ((List)localObject2).add(((com.tencent.mm.plugin.sns.j.n)localObject5).name);
                    break;
                  case 1: 
                    ((List)localObject3).add(((com.tencent.mm.plugin.sns.j.n)localObject5).name);
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
                    localObject7 = com.tencent.mm.plugin.label.a.a.eLe().aMR(com.tencent.mm.plugin.label.a.a.eLe().aMO((String)localObject6));
                    if ((localObject7 != null) && (((List)localObject7).size() != 0)) {
                      ((StringBuilder)localObject4).append((String)localObject6).append("|").append(((List)localObject7).size()).append(";");
                    }
                  }
                  ((g)localObject1).Kik.gVz = ((List)localObject3).size();
                  localObject3 = ((g)localObject1).Kik;
                  ((mt)localObject3).gVA = ((mt)localObject3).z("LatestTimelinePsotSettingLabelList", ((StringBuilder)localObject4).toString(), true);
                }
                if (((List)localObject2).size() > 0)
                {
                  localObject3 = new StringBuilder();
                  localObject4 = ((List)localObject2).iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (String)((Iterator)localObject4).next();
                    localObject6 = new ArrayList();
                    localObject7 = v.Pt((String)localObject5);
                    if (localObject7 != null)
                    {
                      localObject7 = ((List)localObject7).iterator();
                      while (((Iterator)localObject7).hasNext())
                      {
                        String str = (String)((Iterator)localObject7).next();
                        if (ab.Ql(str)) {
                          ((List)localObject6).add(str);
                        }
                      }
                      ((StringBuilder)localObject3).append((String)localObject5).append("|").append(((List)localObject6).size()).append(";");
                    }
                  }
                  ((g)localObject1).Kik.gVv = ((List)localObject2).size();
                  localObject2 = ((g)localObject1).Kik;
                  ((mt)localObject2).gVw = ((mt)localObject2).z("LatestTimelinePsotSettingGroupList", ((StringBuilder)localObject3).toString(), true);
                }
                ((g)localObject1).Kik.gVx = localArrayList.size();
                localObject1 = ((g)localObject1).Kik;
                ((mt)localObject1).gVy = ((mt)localObject1).z("LatestTimelinePsotSettingUinList", Util.listToString(localArrayList, "|"), true);
              }
              AppMethodBeat.o(265656);
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
    this.KJo = paramIntent.getIntExtra("Ktag_range_index", 0);
    this.KJq = paramIntent.getStringExtra("Klabel_name_list");
    this.KJr = paramIntent.getStringExtra("Kother_user_name_list");
    this.KJs = paramIntent.getStringExtra("Kchat_room_name_list");
    paramInt1 = getMaxTagNameLen();
    Object localObject = "";
    if (!Util.isNullOrNil(this.KJs))
    {
      paramIntent = Util.listToString(S(Arrays.asList(this.KJs.split(","))), ",");
      localObject = "" + paramIntent;
    }
    paramIntent = (Intent)localObject;
    if (!Util.isNullOrNil(this.KJq))
    {
      if (((String)localObject).length() > 0) {
        paramIntent = (String)localObject + "," + this.KJq;
      }
    }
    else
    {
      localObject = paramIntent;
      if (!Util.isNullOrNil(this.KJr))
      {
        localObject = Util.listToString(S(Arrays.asList(this.KJr.split(","))), ",");
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
      paramInt1 = this.KJo;
      paramIntent = l.b(getContext(), paramIntent, this.KJj.getTextSize());
      if (this.yVe != null)
      {
        this.yVe.setImageDrawable(au.o(this.mContext, i.i.album_group_icon_pressed, getContext().getResources().getColor(i.c.wechat_green)));
        this.KFt.setTextColor(getResources().getColor(i.c.green_text_color));
        this.KJj.setTextColor(getResources().getColor(i.c.green_text_color));
      }
      if (this.KBH != null) {
        this.KBH.setPrivated(false);
      }
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98230);
      return true;
      paramIntent = (String)localObject + this.KJq;
      break;
      label462:
      localObject = paramIntent + (String)localObject;
      break label235;
      if (this.yVe != null)
      {
        this.yVe.setImageDrawable(au.o(this.mContext, i.i.album_group_icon_normal, getContext().getResources().getColor(i.c.icon_color)));
        this.KFt.setTextColor(getResources().getColor(i.c.normal_text_color));
        this.KJj.setTextColor(getResources().getColor(i.c.hint_text_color));
      }
      this.KJj.setText(i.j.sns_label_public);
      continue;
      if (this.KBH != null) {
        this.KBH.setPrivated(true);
      }
      if ((paramAtContactWidget != null) && (this.KBH != null) && (paramAtContactWidget.getAtList().size() > 0))
      {
        com.tencent.mm.ui.base.h.p(this.mContext, i.j.sns_tag_privacy_with_others_tip, i.j.app_tip);
        paramAtContactWidget.fTh();
        this.KBH.fXQ();
      }
      this.KJj.setText(i.j.sns_label_private);
      continue;
      if (this.yVe != null)
      {
        this.yVe.setImageDrawable(au.o(this.mContext, i.i.album_group_icon_normal, getResources().getColor(i.c.green_text_color)));
        this.KFt.setText(getResources().getString(i.j.sns_tag_visibl_range));
        this.KFt.setTextColor(getResources().getColor(i.c.green_text_color));
        this.KJj.setTextColor(getResources().getColor(i.c.green_text_color));
      }
      this.KJj.setText(paramIntent);
      continue;
      if (this.yVe != null)
      {
        this.yVe.setImageDrawable(au.o(this.mContext, i.i.album_group_icon_normal, -65536));
        this.KFt.setText(getResources().getString(i.j.sns_tag_invisibl_range));
        this.KFt.setTextColor(-65536);
        this.KJj.setTextColor(-65536);
      }
      this.KJj.setText(paramIntent);
    }
  }
  
  public int getLabelRange()
  {
    return this.KJo;
  }
  
  protected int getLayoutResource()
  {
    return i.g.rang_layout;
  }
  
  protected int getMaxTagNameLen()
  {
    return -1;
  }
  
  public void setEnablePrivate(boolean paramBoolean)
  {
    this.KJn = paramBoolean;
  }
  
  public void setRangeTipClickListener(View.OnClickListener paramOnClickListener)
  {
    this.KJt = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RangeWidget
 * JD-Core Version:    0.7.0.1
 */