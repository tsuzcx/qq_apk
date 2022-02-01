package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.u;
import com.tencent.mm.ui.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AtContactWidget
  extends LinearLayout
{
  private View contentView;
  private Activity kbt;
  private TextView opV;
  private ImageView zOS;
  private TextView zOT;
  private PreviewContactView zOU;
  SnsUploadConfigView zOV;
  private List<String> zOW;
  private boolean zOX;
  
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97782);
    this.zOW = new LinkedList();
    this.zOX = false;
    init(paramContext);
    AppMethodBeat.o(97782);
  }
  
  @TargetApi(11)
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97781);
    this.zOW = new LinkedList();
    this.zOX = false;
    init(paramContext);
    AppMethodBeat.o(97781);
  }
  
  private void dZv()
  {
    AppMethodBeat.i(97787);
    if (this.zOW.size() > 0)
    {
      this.zOS.setImageDrawable(ao.k(this.kbt, getWithDrawableId(), getContext().getResources().getColor(2131101171)));
      AppMethodBeat.o(97787);
      return;
    }
    this.zOS.setImageDrawable(ao.k(this.kbt, getWithEmptyDrawableId(), getContext().getResources().getColor(2131100499)));
    AppMethodBeat.o(97787);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(97785);
    this.kbt = ((Activity)paramContext);
    this.contentView = z.jO(paramContext).inflate(getLayoutResource(), this);
    this.zOU = ((PreviewContactView)this.contentView.findViewById(2131296951));
    this.zOS = ((ImageView)this.contentView.findViewById(2131296952));
    this.zOT = ((TextView)this.contentView.findViewById(2131296954));
    this.opV = ((TextView)this.contentView.findViewById(2131296955));
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97779);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/AtContactWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        AtContactWidget.a(AtContactWidget.this);
        a.a(this, "com/tencent/mm/plugin/sns/ui/AtContactWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97779);
      }
    });
    this.contentView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97780);
        int i = (int)(g.aQF().density * 36.0F);
        if (i != 0)
        {
          i = (AtContactWidget.b(AtContactWidget.this).getWidth() - AtContactWidget.c(AtContactWidget.this).getWidth() - AtContactWidget.d(AtContactWidget.this).getWidth() - (int)(g.aQF().density * 32.0F)) / i;
          if ((i > 0) && (i < 5))
          {
            AtContactWidget.e(AtContactWidget.this).setLineNum(i);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)AtContactWidget.e(AtContactWidget.this).getLayoutParams();
            localLayoutParams.alignWithParent = true;
            AtContactWidget.e(AtContactWidget.this).setLayoutParams(localLayoutParams);
          }
        }
        AppMethodBeat.o(97780);
      }
    });
    AppMethodBeat.o(97785);
  }
  
  public final boolean aN(Intent paramIntent)
  {
    AppMethodBeat.i(97786);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    new LinkedList();
    if ((paramIntent == null) || (paramIntent.equals(""))) {}
    Object localObject1;
    Object localObject2;
    for (paramIntent = new LinkedList();; paramIntent = bt.U(paramIntent.split(",")))
    {
      if (this.zOW == null) {
        this.zOW = new LinkedList();
      }
      this.zOW.clear();
      localObject1 = paramIntent.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!this.zOW.contains(localObject2)) {
          this.zOW.add(localObject2);
        }
      }
    }
    if (this.zOU != null) {
      this.zOU.setList(this.zOW);
    }
    int i;
    if (this.opV != null)
    {
      localObject1 = this.opV;
      localObject2 = getResources();
      if (paramIntent.isEmpty())
      {
        i = 2131100711;
        ((TextView)localObject1).setTextColor(((Resources)localObject2).getColor(i));
      }
    }
    else if (this.zOX)
    {
      ad.d("MicroMsg.AtContactWiget", "withList count " + this.zOW.size());
      if ((!this.zOX) || (this.zOT == null) || (this.zOW.size() <= 0)) {
        break label374;
      }
      this.zOT.setVisibility(0);
      if (this.zOW.size() >= 100) {
        break label352;
      }
      this.zOT.setText(this.zOW.size());
      this.zOT.setBackgroundResource(u.aP(getContext(), this.zOW.size()));
    }
    for (;;)
    {
      dZv();
      AppMethodBeat.o(97786);
      return true;
      i = 2131100464;
      break;
      label352:
      this.zOT.setText("");
      this.zOT.setBackgroundResource(2131689744);
      continue;
      label374:
      this.zOT.setVisibility(8);
    }
  }
  
  public final void dZu()
  {
    AppMethodBeat.i(97784);
    if (this.zOW == null) {
      this.zOW = new LinkedList();
    }
    this.zOW.clear();
    if (this.zOU != null) {
      this.zOU.setList(this.zOW);
    }
    dZv();
    if (this.zOT != null) {
      this.zOT.setVisibility(8);
    }
    if (this.opV != null) {
      this.opV.setTextColor(getResources().getColor(2131100711));
    }
    AppMethodBeat.o(97784);
  }
  
  public List<String> getAtList()
  {
    AppMethodBeat.i(97783);
    if (this.zOW == null) {
      this.zOW = new LinkedList();
    }
    List localList = this.zOW;
    AppMethodBeat.o(97783);
    return localList;
  }
  
  protected int getLayoutResource()
  {
    return 2131493114;
  }
  
  protected int getWithDrawableId()
  {
    return 2131689535;
  }
  
  protected int getWithEmptyDrawableId()
  {
    return 2131689534;
  }
  
  public void setShowAtList(boolean paramBoolean)
  {
    AppMethodBeat.i(97788);
    PreviewContactView localPreviewContactView;
    if (this.zOU != null)
    {
      localPreviewContactView = this.zOU;
      if (!paramBoolean) {
        break label36;
      }
    }
    label36:
    for (int i = 0;; i = 8)
    {
      localPreviewContactView.setVisibility(i);
      AppMethodBeat.o(97788);
      return;
    }
  }
  
  public void setShowAtNum(boolean paramBoolean)
  {
    this.zOX = paramBoolean;
  }
  
  public void setShowAtTips(boolean paramBoolean)
  {
    AppMethodBeat.i(97789);
    TextView localTextView;
    if ((this.contentView != null) && (this.opV != null))
    {
      localTextView = this.opV;
      if (!paramBoolean) {
        break label43;
      }
    }
    label43:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(97789);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AtContactWidget
 * JD-Core Version:    0.7.0.1
 */