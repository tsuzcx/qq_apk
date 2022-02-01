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
import com.tencent.mm.g.b.a.fm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.i.l;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.j.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RangeWidget
  extends RelativeLayout
{
  private View contentView;
  private Activity jHh;
  public int style;
  private l xXq;
  private TextView yAT;
  private TextView yEd;
  private LinearLayout yEe;
  private TextView yEf;
  private View yEg;
  private boolean yEh;
  private int yEi;
  String yEj;
  private String yEk;
  private String yEl;
  private String yEm;
  private View.OnClickListener yEn;
  private ImageView yxG;
  SnsUploadConfigView yxJ;
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98227);
    this.yEh = true;
    this.yEi = 0;
    this.yEj = "";
    this.xXq = null;
    this.yEk = "";
    this.yEl = "";
    this.yEm = "";
    this.yEn = null;
    this.style = 0;
    init(paramContext);
    AppMethodBeat.o(98227);
  }
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98226);
    this.yEh = true;
    this.yEi = 0;
    this.yEj = "";
    this.xXq = null;
    this.yEk = "";
    this.yEl = "";
    this.yEm = "";
    this.yEn = null;
    this.style = 0;
    init(paramContext);
    AppMethodBeat.o(98226);
  }
  
  private static List<String> Q(List<String> paramList)
  {
    AppMethodBeat.i(98229);
    LinkedList localLinkedList = new LinkedList();
    g.agS();
    if (!g.agP().afY())
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
      g.agS();
      ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str);
      paramList = str;
      if (localai != null)
      {
        paramList = str;
        if ((int)localai.fLJ != 0) {
          paramList = localai.aaS();
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
    this.jHh = ((Activity)paramContext);
    this.contentView = View.inflate(paramContext, getLayoutResource(), this);
    this.xXq = af.dHN().xXq;
    this.yEd = ((TextView)this.contentView.findViewById(2131305083));
    this.yAT = ((TextView)this.contentView.findViewById(2131301393));
    this.yxG = ((ImageView)this.contentView.findViewById(2131303712));
    this.yEe = ((LinearLayout)this.contentView.findViewById(2131305079));
    this.yEf = ((TextView)this.contentView.findViewById(2131305078));
    this.yEg = this.contentView.findViewById(2131303715);
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98224);
        paramAnonymousView = new Intent(RangeWidget.a(RangeWidget.this), SnsLabelUI.class);
        paramAnonymousView.putExtra("KLabel_range_index", RangeWidget.b(RangeWidget.this));
        paramAnonymousView.putExtra("Klabel_name_list", RangeWidget.c(RangeWidget.this));
        paramAnonymousView.putExtra("Kother_user_name_list", RangeWidget.d(RangeWidget.this));
        paramAnonymousView.putExtra("Kchat_room_name_list", RangeWidget.e(RangeWidget.this));
        paramAnonymousView.putExtra("k_sns_label_ui_style", RangeWidget.this.style);
        RangeWidget.a(RangeWidget.this).startActivityForResult(paramAnonymousView, 5);
        paramAnonymousView = f.ydE;
        if (paramAnonymousView.ydM != null)
        {
          if (paramAnonymousView.ydM.dXD <= 0)
          {
            paramAnonymousView.ydM.dXD = 1;
            AppMethodBeat.o(98224);
            return;
          }
          paramAnonymousView.ydM.dXD += 1;
        }
        AppMethodBeat.o(98224);
      }
    });
    if ((this.yEe != null) && (this.yEf != null) && (this.yEg != null))
    {
      this.yEe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98225);
          if (RangeWidget.f(RangeWidget.this) != null)
          {
            RangeWidget.f(RangeWidget.this).onClick(paramAnonymousView);
            f.ydE.ydM.dXF = 1;
          }
          AppMethodBeat.o(98225);
        }
      });
      int i;
      Object localObject1;
      Iterator localIterator;
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWj, 1) == 1)
      {
        i = 1;
        this.yEg.setBackground(null);
        this.yEe.setVisibility(8);
        if ((i != 0) && (this.xXq != null) && (this.xXq.yaR != null) && (!this.xXq.yaR.isEmpty()))
        {
          localObject1 = new ArrayList();
          localIterator = this.xXq.yaR.iterator();
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
            localObject2 = com.tencent.mm.plugin.label.a.a.cWd().ajz(((m)localObject2).name);
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
            g.agS();
            ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(((m)localObject2).name);
            if ((localai != null) && ((int)localai.fLJ != 0)) {
              ((List)localObject1).add(((m)localObject2).name);
            }
          }
          else
          {
            ((List)localObject1).add(((m)localObject2).name);
          }
        }
        label430:
        if (!bs.gY((List)localObject1))
        {
          this.yEg.setBackground(paramContext.getResources().getDrawable(2131232867));
          this.yEe.setVisibility(0);
          localObject1 = bs.n(Q((List)localObject1), ",");
          this.yEf.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), String.format(paramContext.getResources().getString(2131764000), new Object[] { localObject1 }), this.yEf.getTextSize()));
          i = j;
          if (this.xXq.yaT) {
            i = 2;
          }
          f.ydE.ydM.dXE = i;
          f.ydE.fC(this.xXq.yaR);
        }
      }
    }
    AppMethodBeat.o(98228);
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent, AtContactWidget paramAtContactWidget)
  {
    AppMethodBeat.i(98230);
    this.yEi = paramIntent.getIntExtra("Ktag_range_index", 0);
    this.yEk = paramIntent.getStringExtra("Klabel_name_list");
    this.yEl = paramIntent.getStringExtra("Kother_user_name_list");
    this.yEm = paramIntent.getStringExtra("Kchat_room_name_list");
    paramInt1 = getMaxTagNameLen();
    Object localObject = "";
    if (!bs.isNullOrNil(this.yEm))
    {
      paramIntent = bs.n(Q(Arrays.asList(this.yEm.split(","))), ",");
      localObject = "" + paramIntent;
    }
    paramIntent = (Intent)localObject;
    if (!bs.isNullOrNil(this.yEk))
    {
      if (((String)localObject).length() > 0) {
        paramIntent = (String)localObject + "," + this.yEk;
      }
    }
    else
    {
      localObject = paramIntent;
      if (!bs.isNullOrNil(this.yEl))
      {
        localObject = bs.n(Q(Arrays.asList(this.yEl.split(","))), ",");
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
      paramInt1 = this.yEi;
      paramIntent = com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), paramIntent, this.yEd.getTextSize());
      if (this.yxG != null)
      {
        this.yxG.setImageDrawable(am.k(this.jHh, 2131689530, getContext().getResources().getColor(2131101171)));
        this.yAT.setTextColor(getResources().getColor(2131100464));
        this.yEd.setTextColor(getResources().getColor(2131100464));
      }
      if (this.yxJ != null) {
        this.yxJ.setPrivated(false);
      }
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98230);
      return true;
      paramIntent = (String)localObject + this.yEk;
      break;
      label462:
      localObject = paramIntent + (String)localObject;
      break label235;
      if (this.yxG != null)
      {
        this.yxG.setImageDrawable(am.k(this.jHh, 2131689529, getContext().getResources().getColor(2131100499)));
        this.yAT.setTextColor(getResources().getColor(2131100711));
        this.yEd.setTextColor(getResources().getColor(2131100490));
      }
      this.yEd.setText(2131763871);
      continue;
      if (this.yxJ != null) {
        this.yxJ.setPrivated(true);
      }
      if ((paramAtContactWidget != null) && (this.yxJ != null) && (paramAtContactWidget.getAtList().size() > 0))
      {
        h.l(this.jHh, 2131764011, 2131755906);
        paramAtContactWidget.dNf();
        this.yxJ.dRc();
      }
      this.yEd.setText(2131763869);
      continue;
      if (this.yxG != null)
      {
        this.yxG.setImageDrawable(am.k(this.jHh, 2131689529, getResources().getColor(2131100464)));
        this.yAT.setText(getResources().getString(2131764019));
        this.yAT.setTextColor(getResources().getColor(2131100464));
        this.yEd.setTextColor(getResources().getColor(2131100464));
      }
      this.yEd.setText(paramIntent);
      continue;
      if (this.yxG != null)
      {
        this.yxG.setImageDrawable(am.k(this.jHh, 2131689529, -65536));
        this.yAT.setText(getResources().getString(2131763999));
        this.yAT.setTextColor(-65536);
        this.yEd.setTextColor(-65536);
      }
      this.yEd.setText(paramIntent);
    }
  }
  
  public int getLabelRange()
  {
    return this.yEi;
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
    this.yEh = paramBoolean;
  }
  
  public void setRangeTipClickListener(View.OnClickListener paramOnClickListener)
  {
    this.yEn = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RangeWidget
 * JD-Core Version:    0.7.0.1
 */