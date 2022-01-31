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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.sns.h.k;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.aj;
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
  private Activity gQx;
  private ImageView rFb;
  SnsUploadConfigView rFe;
  private TextView rIc;
  private TextView rKJ;
  private LinearLayout rKK;
  private TextView rKL;
  private View rKM;
  private boolean rKN;
  private int rKO;
  String rKP;
  private String rKQ;
  private String rKR;
  private String rKS;
  private View.OnClickListener rKT;
  private com.tencent.mm.plugin.sns.h.j riU;
  public int style;
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38541);
    this.rKN = true;
    this.rKO = 0;
    this.rKP = "";
    this.riU = null;
    this.rKQ = "";
    this.rKR = "";
    this.rKS = "";
    this.rKT = null;
    this.style = 0;
    init(paramContext);
    AppMethodBeat.o(38541);
  }
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38540);
    this.rKN = true;
    this.rKO = 0;
    this.rKP = "";
    this.riU = null;
    this.rKQ = "";
    this.rKR = "";
    this.rKS = "";
    this.rKT = null;
    this.style = 0;
    init(paramContext);
    AppMethodBeat.o(38540);
  }
  
  private static List<String> M(List<String> paramList)
  {
    AppMethodBeat.i(38543);
    LinkedList localLinkedList = new LinkedList();
    g.RM();
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(38543);
      return localLinkedList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(38543);
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      g.RM();
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(str);
      paramList = str;
      if (localad != null)
      {
        paramList = str;
        if ((int)localad.euF != 0) {
          paramList = localad.Of();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(38543);
    return localLinkedList;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(38542);
    this.gQx = ((Activity)paramContext);
    this.contentView = View.inflate(paramContext, getLayoutResource(), this);
    this.riU = ag.cpb().riU;
    this.rKJ = ((TextView)this.contentView.findViewById(2131827012));
    this.rIc = ((TextView)this.contentView.findViewById(2131823493));
    this.rFb = ((ImageView)this.contentView.findViewById(2131827010));
    this.rKK = ((LinearLayout)this.contentView.findViewById(2131827013));
    this.rKL = ((TextView)this.contentView.findViewById(2131827014));
    this.rKM = this.contentView.findViewById(2131827011);
    this.contentView.setOnClickListener(new RangeWidget.1(this));
    if ((this.rKK != null) && (this.rKL != null) && (this.rKM != null))
    {
      this.rKK.setOnClickListener(new RangeWidget.2(this));
      int i;
      if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lWj, 1) == 1) {
        i = 1;
      }
      while ((i != 0) && (this.riU != null) && (this.riU.rlZ != null) && (!this.riU.rlZ.isEmpty()))
      {
        this.rKM.setBackground(paramContext.getResources().getDrawable(2130839276));
        this.rKK.setVisibility(0);
        Object localObject = new ArrayList();
        Iterator localIterator = this.riU.rlZ.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ((List)localObject).add(((k)localIterator.next()).name);
            continue;
            i = 0;
            break;
          }
        }
        localObject = bo.d(M((List)localObject), ",");
        this.rKL.setText(String.format(paramContext.getResources().getString(2131303983), new Object[] { localObject }));
        AppMethodBeat.o(38542);
        return;
      }
      this.rKM.setBackground(null);
      this.rKK.setVisibility(8);
    }
    AppMethodBeat.o(38542);
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent, AtContactWidget paramAtContactWidget)
  {
    AppMethodBeat.i(38544);
    this.rKO = paramIntent.getIntExtra("Ktag_range_index", 0);
    this.rKQ = paramIntent.getStringExtra("Klabel_name_list");
    this.rKR = paramIntent.getStringExtra("Kother_user_name_list");
    this.rKS = paramIntent.getStringExtra("Kchat_room_name_list");
    paramInt1 = getMaxTagNameLen();
    Object localObject = "";
    if (!bo.isNullOrNil(this.rKS))
    {
      paramIntent = bo.d(M(Arrays.asList(this.rKS.split(","))), ",");
      localObject = "" + paramIntent;
    }
    paramIntent = (Intent)localObject;
    if (!bo.isNullOrNil(this.rKQ))
    {
      if (((String)localObject).length() > 0) {
        paramIntent = (String)localObject + "," + this.rKQ;
      }
    }
    else
    {
      localObject = paramIntent;
      if (!bo.isNullOrNil(this.rKR))
      {
        localObject = bo.d(M(Arrays.asList(this.rKR.split(","))), ",");
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
      paramInt1 = this.rKO;
      if (this.rFb != null)
      {
        this.rFb.setImageDrawable(aj.g(this.gQx, 2131230775, getContext().getResources().getColor(2131690701)));
        this.rIc.setTextColor(getResources().getColor(2131690139));
        this.rKJ.setTextColor(getResources().getColor(2131690139));
      }
      if (this.rFe != null) {
        this.rFe.setPrivated(false);
      }
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(38544);
      return true;
      paramIntent = (String)localObject + this.rKQ;
      break;
      label446:
      localObject = paramIntent + (String)localObject;
      break label235;
      if (this.rFb != null)
      {
        this.rFb.setImageDrawable(aj.g(this.gQx, 2131230774, -16777216));
        this.rIc.setTextColor(getResources().getColor(2131690322));
        this.rKJ.setTextColor(getResources().getColor(2131690168));
      }
      this.rKJ.setText(2131303862);
      continue;
      if (this.rFe != null) {
        this.rFe.setPrivated(true);
      }
      if ((paramAtContactWidget != null) && (this.rFe != null) && (paramAtContactWidget.getAtList().size() > 0))
      {
        h.h(this.gQx, 2131303994, 2131297087);
        paramAtContactWidget.cto();
        this.rFe.cww();
      }
      this.rKJ.setText(2131303860);
      continue;
      if (this.rFb != null)
      {
        this.rFb.setImageDrawable(aj.g(this.gQx, 2131230774, getResources().getColor(2131690139)));
        this.rIc.setText(getResources().getString(2131304002));
        this.rIc.setTextColor(getResources().getColor(2131690139));
        this.rKJ.setTextColor(getResources().getColor(2131690139));
      }
      this.rKJ.setText(paramIntent);
      continue;
      if (this.rFb != null)
      {
        this.rFb.setImageDrawable(aj.g(this.gQx, 2131230774, -65536));
        this.rIc.setText(getResources().getString(2131303982));
        this.rIc.setTextColor(-65536);
        this.rKJ.setTextColor(-65536);
      }
      this.rKJ.setText(paramIntent);
    }
  }
  
  public int getLabelRange()
  {
    return this.rKO;
  }
  
  protected int getLayoutResource()
  {
    return 2130970501;
  }
  
  protected int getMaxTagNameLen()
  {
    return -1;
  }
  
  public void setEnablePrivate(boolean paramBoolean)
  {
    this.rKN = paramBoolean;
  }
  
  public void setRangeTipClickListener(View.OnClickListener paramOnClickListener)
  {
    this.rKT = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RangeWidget
 * JD-Core Version:    0.7.0.1
 */