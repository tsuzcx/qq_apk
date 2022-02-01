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
import com.tencent.mm.g.b.a.dw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.j.l;
import com.tencent.mm.plugin.sns.j.m;
import com.tencent.mm.plugin.sns.k.f;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
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
  private Activity jgS;
  public int style;
  private l wKK;
  private ImageView xkO;
  SnsUploadConfigView xkR;
  private TextView xoc;
  private TextView xrn;
  private LinearLayout xro;
  private TextView xrp;
  private View xrq;
  private boolean xrr;
  private int xrs;
  String xrt;
  private String xru;
  private String xrv;
  private String xrw;
  private View.OnClickListener xrx;
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98227);
    this.xrr = true;
    this.xrs = 0;
    this.xrt = "";
    this.wKK = null;
    this.xru = "";
    this.xrv = "";
    this.xrw = "";
    this.xrx = null;
    this.style = 0;
    init(paramContext);
    AppMethodBeat.o(98227);
  }
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98226);
    this.xrr = true;
    this.xrs = 0;
    this.xrt = "";
    this.wKK = null;
    this.xru = "";
    this.xrv = "";
    this.xrw = "";
    this.xrx = null;
    this.style = 0;
    init(paramContext);
    AppMethodBeat.o(98226);
  }
  
  private static List<String> Z(List<String> paramList)
  {
    AppMethodBeat.i(98229);
    LinkedList localLinkedList = new LinkedList();
    g.afC();
    if (!g.afz().aeI())
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
      g.afC();
      com.tencent.mm.storage.af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(str);
      paramList = str;
      if (localaf != null)
      {
        paramList = str;
        if ((int)localaf.fId != 0) {
          paramList = localaf.ZX();
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
    this.jgS = ((Activity)paramContext);
    this.contentView = View.inflate(paramContext, getLayoutResource(), this);
    this.wKK = com.tencent.mm.plugin.sns.model.af.dtq().wKK;
    this.xrn = ((TextView)this.contentView.findViewById(2131305083));
    this.xoc = ((TextView)this.contentView.findViewById(2131301393));
    this.xkO = ((ImageView)this.contentView.findViewById(2131303712));
    this.xro = ((LinearLayout)this.contentView.findViewById(2131305079));
    this.xrp = ((TextView)this.contentView.findViewById(2131305078));
    this.xrq = this.contentView.findViewById(2131303715);
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
        paramAnonymousView = f.wQY;
        if (paramAnonymousView.wRg != null)
        {
          if (paramAnonymousView.wRg.dVI <= 0)
          {
            paramAnonymousView.wRg.dVI = 1;
            AppMethodBeat.o(98224);
            return;
          }
          paramAnonymousView.wRg.dVI += 1;
        }
        AppMethodBeat.o(98224);
      }
    });
    if ((this.xro != null) && (this.xrp != null) && (this.xrq != null))
    {
      this.xro.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98225);
          if (RangeWidget.f(RangeWidget.this) != null)
          {
            RangeWidget.f(RangeWidget.this).onClick(paramAnonymousView);
            f.wQY.wRg.dVK = 1;
          }
          AppMethodBeat.o(98225);
        }
      });
      int i;
      Object localObject1;
      Iterator localIterator;
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pse, 1) == 1)
      {
        i = 1;
        this.xrq.setBackground(null);
        this.xro.setVisibility(8);
        if ((i != 0) && (this.wKK != null) && (this.wKK.wOk != null) && (!this.wKK.wOk.isEmpty()))
        {
          localObject1 = new ArrayList();
          localIterator = this.wKK.wOk.iterator();
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
            localObject2 = com.tencent.mm.plugin.label.a.a.cIS().aeH(((m)localObject2).name);
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
            g.afC();
            com.tencent.mm.storage.af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(((m)localObject2).name);
            if ((localaf != null) && ((int)localaf.fId != 0)) {
              ((List)localObject1).add(((m)localObject2).name);
            }
          }
          else
          {
            ((List)localObject1).add(((m)localObject2).name);
          }
        }
        label430:
        if (!bt.gL((List)localObject1))
        {
          this.xrq.setBackground(paramContext.getResources().getDrawable(2131232867));
          this.xro.setVisibility(0);
          localObject1 = bt.n(Z((List)localObject1), ",");
          this.xrp.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), String.format(paramContext.getResources().getString(2131764000), new Object[] { localObject1 }), this.xrp.getTextSize()));
          i = j;
          if (this.wKK.wOm) {
            i = 2;
          }
          f.wQY.wRg.dVJ = i;
          f.wQY.fu(this.wKK.wOk);
        }
      }
    }
    AppMethodBeat.o(98228);
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent, AtContactWidget paramAtContactWidget)
  {
    AppMethodBeat.i(98230);
    this.xrs = paramIntent.getIntExtra("Ktag_range_index", 0);
    this.xru = paramIntent.getStringExtra("Klabel_name_list");
    this.xrv = paramIntent.getStringExtra("Kother_user_name_list");
    this.xrw = paramIntent.getStringExtra("Kchat_room_name_list");
    paramInt1 = getMaxTagNameLen();
    Object localObject = "";
    if (!bt.isNullOrNil(this.xrw))
    {
      paramIntent = bt.n(Z(Arrays.asList(this.xrw.split(","))), ",");
      localObject = "" + paramIntent;
    }
    paramIntent = (Intent)localObject;
    if (!bt.isNullOrNil(this.xru))
    {
      if (((String)localObject).length() > 0) {
        paramIntent = (String)localObject + "," + this.xru;
      }
    }
    else
    {
      localObject = paramIntent;
      if (!bt.isNullOrNil(this.xrv))
      {
        localObject = bt.n(Z(Arrays.asList(this.xrv.split(","))), ",");
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
      paramInt1 = this.xrs;
      paramIntent = com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), paramIntent, this.xrn.getTextSize());
      if (this.xkO != null)
      {
        this.xkO.setImageDrawable(am.i(this.jgS, 2131689530, getContext().getResources().getColor(2131101171)));
        this.xoc.setTextColor(getResources().getColor(2131100464));
        this.xrn.setTextColor(getResources().getColor(2131100464));
      }
      if (this.xkR != null) {
        this.xkR.setPrivated(false);
      }
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98230);
      return true;
      paramIntent = (String)localObject + this.xru;
      break;
      label462:
      localObject = paramIntent + (String)localObject;
      break label235;
      if (this.xkO != null)
      {
        this.xkO.setImageDrawable(am.i(this.jgS, 2131689529, getContext().getResources().getColor(2131100499)));
        this.xoc.setTextColor(getResources().getColor(2131100711));
        this.xrn.setTextColor(getResources().getColor(2131100490));
      }
      this.xrn.setText(2131763871);
      continue;
      if (this.xkR != null) {
        this.xkR.setPrivated(true);
      }
      if ((paramAtContactWidget != null) && (this.xkR != null) && (paramAtContactWidget.getAtList().size() > 0))
      {
        h.j(this.jgS, 2131764011, 2131755906);
        paramAtContactWidget.dyI();
        this.xkR.dCF();
      }
      this.xrn.setText(2131763869);
      continue;
      if (this.xkO != null)
      {
        this.xkO.setImageDrawable(am.i(this.jgS, 2131689529, getResources().getColor(2131100464)));
        this.xoc.setText(getResources().getString(2131764019));
        this.xoc.setTextColor(getResources().getColor(2131100464));
        this.xrn.setTextColor(getResources().getColor(2131100464));
      }
      this.xrn.setText(paramIntent);
      continue;
      if (this.xkO != null)
      {
        this.xkO.setImageDrawable(am.i(this.jgS, 2131689529, -65536));
        this.xoc.setText(getResources().getString(2131763999));
        this.xoc.setTextColor(-65536);
        this.xrn.setTextColor(-65536);
      }
      this.xrn.setText(paramIntent);
    }
  }
  
  public int getLabelRange()
  {
    return this.xrs;
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
    this.xrr = paramBoolean;
  }
  
  public void setRangeTipClickListener(View.OnClickListener paramOnClickListener)
  {
    this.xrx = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RangeWidget
 * JD-Core Version:    0.7.0.1
 */