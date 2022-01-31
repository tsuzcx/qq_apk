package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.tools.t;
import com.tencent.mm.ui.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AtContactWidget
  extends LinearLayout
{
  private View contentView;
  private Activity gQx;
  private TextView iEo;
  private ImageView rFb;
  private TextView rFc;
  private PreviewContactView rFd;
  SnsUploadConfigView rFe;
  private List<String> rFf;
  private boolean rFg;
  
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38153);
    this.rFf = new LinkedList();
    this.rFg = false;
    init(paramContext);
    AppMethodBeat.o(38153);
  }
  
  @TargetApi(11)
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38152);
    this.rFf = new LinkedList();
    this.rFg = false;
    init(paramContext);
    AppMethodBeat.o(38152);
  }
  
  private void ctp()
  {
    AppMethodBeat.i(38158);
    if (this.rFf.size() > 0)
    {
      this.rFb.setImageDrawable(aj.g(this.gQx, getWithDrawableId(), getContext().getResources().getColor(2131690701)));
      AppMethodBeat.o(38158);
      return;
    }
    this.rFb.setImageDrawable(aj.g(this.gQx, getWithEmptyDrawableId(), -16777216));
    AppMethodBeat.o(38158);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(38156);
    this.gQx = ((Activity)paramContext);
    this.contentView = w.hM(paramContext).inflate(getLayoutResource(), this);
    this.rFd = ((PreviewContactView)this.contentView.findViewById(2131821554));
    this.rFb = ((ImageView)this.contentView.findViewById(2131821552));
    this.rFc = ((TextView)this.contentView.findViewById(2131827788));
    this.iEo = ((TextView)this.contentView.findViewById(2131821553));
    this.contentView.setOnClickListener(new AtContactWidget.1(this));
    this.contentView.post(new AtContactWidget.2(this));
    AppMethodBeat.o(38156);
  }
  
  public final boolean an(Intent paramIntent)
  {
    AppMethodBeat.i(38157);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    new LinkedList();
    if ((paramIntent == null) || (paramIntent.equals(""))) {}
    Object localObject1;
    Object localObject2;
    for (paramIntent = new LinkedList();; paramIntent = bo.P(paramIntent.split(",")))
    {
      if (this.rFf == null) {
        this.rFf = new LinkedList();
      }
      this.rFf.clear();
      localObject1 = paramIntent.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!this.rFf.contains(localObject2)) {
          this.rFf.add(localObject2);
        }
      }
    }
    if (this.rFd != null) {
      this.rFd.setList(this.rFf);
    }
    int i;
    if (this.iEo != null)
    {
      localObject1 = this.iEo;
      localObject2 = getResources();
      if (paramIntent.isEmpty())
      {
        i = 2131690322;
        ((TextView)localObject1).setTextColor(((Resources)localObject2).getColor(i));
      }
    }
    else if (this.rFg)
    {
      ab.d("MicroMsg.AtContactWiget", "withList count " + this.rFf.size());
      if ((!this.rFg) || (this.rFc == null) || (this.rFf.size() <= 0)) {
        break label365;
      }
      this.rFc.setVisibility(0);
      if (this.rFf.size() >= 100) {
        break label343;
      }
      this.rFc.setText(this.rFf.size());
      this.rFc.setBackgroundResource(t.iF(getContext()));
    }
    for (;;)
    {
      ctp();
      AppMethodBeat.o(38157);
      return true;
      i = 2131690139;
      break;
      label343:
      this.rFc.setText("");
      this.rFc.setBackgroundResource(2131230963);
      continue;
      label365:
      this.rFc.setVisibility(8);
    }
  }
  
  public final void cto()
  {
    AppMethodBeat.i(38155);
    if (this.rFf == null) {
      this.rFf = new LinkedList();
    }
    this.rFf.clear();
    if (this.rFd != null) {
      this.rFd.setList(this.rFf);
    }
    ctp();
    if (this.rFc != null) {
      this.rFc.setVisibility(8);
    }
    if (this.iEo != null) {
      this.iEo.setTextColor(getResources().getColor(2131690322));
    }
    AppMethodBeat.o(38155);
  }
  
  public List<String> getAtList()
  {
    AppMethodBeat.i(38154);
    if (this.rFf == null) {
      this.rFf = new LinkedList();
    }
    List localList = this.rFf;
    AppMethodBeat.o(38154);
    return localList;
  }
  
  protected int getLayoutResource()
  {
    return 2130968785;
  }
  
  protected int getWithDrawableId()
  {
    return 2131230780;
  }
  
  protected int getWithEmptyDrawableId()
  {
    return 2131230779;
  }
  
  public void setShowAtList(boolean paramBoolean)
  {
    AppMethodBeat.i(38159);
    PreviewContactView localPreviewContactView;
    if (this.rFd != null)
    {
      localPreviewContactView = this.rFd;
      if (!paramBoolean) {
        break label36;
      }
    }
    label36:
    for (int i = 0;; i = 8)
    {
      localPreviewContactView.setVisibility(i);
      AppMethodBeat.o(38159);
      return;
    }
  }
  
  public void setShowAtNum(boolean paramBoolean)
  {
    this.rFg = paramBoolean;
  }
  
  public void setShowAtTips(boolean paramBoolean)
  {
    AppMethodBeat.i(38160);
    TextView localTextView;
    if ((this.contentView != null) && (this.iEo != null))
    {
      localTextView = this.iEo;
      if (!paramBoolean) {
        break label43;
      }
    }
    label43:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(38160);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AtContactWidget
 * JD-Core Version:    0.7.0.1
 */