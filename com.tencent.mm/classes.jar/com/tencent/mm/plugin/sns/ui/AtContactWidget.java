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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.u;
import com.tencent.mm.ui.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AtContactWidget
  extends LinearLayout
{
  private ImageView AfZ;
  private TextView Aga;
  private PreviewContactView Agb;
  SnsUploadConfigView Agc;
  private List<String> Agd;
  private boolean Age;
  private View contentView;
  private Activity keK;
  private TextView owr;
  
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97782);
    this.Agd = new LinkedList();
    this.Age = false;
    init(paramContext);
    AppMethodBeat.o(97782);
  }
  
  @TargetApi(11)
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97781);
    this.Agd = new LinkedList();
    this.Age = false;
    init(paramContext);
    AppMethodBeat.o(97781);
  }
  
  private void eda()
  {
    AppMethodBeat.i(97787);
    if (this.Agd.size() > 0)
    {
      this.AfZ.setImageDrawable(ao.k(this.keK, getWithDrawableId(), getContext().getResources().getColor(2131101171)));
      AppMethodBeat.o(97787);
      return;
    }
    this.AfZ.setImageDrawable(ao.k(this.keK, getWithEmptyDrawableId(), getContext().getResources().getColor(2131100499)));
    AppMethodBeat.o(97787);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(97785);
    this.keK = ((Activity)paramContext);
    this.contentView = z.jV(paramContext).inflate(getLayoutResource(), this);
    this.Agb = ((PreviewContactView)this.contentView.findViewById(2131296951));
    this.AfZ = ((ImageView)this.contentView.findViewById(2131296952));
    this.Aga = ((TextView)this.contentView.findViewById(2131296954));
    this.owr = ((TextView)this.contentView.findViewById(2131296955));
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97779);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/AtContactWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
        int i = (int)(h.aRe().density * 36.0F);
        if (i != 0)
        {
          i = (AtContactWidget.b(AtContactWidget.this).getWidth() - AtContactWidget.c(AtContactWidget.this).getWidth() - AtContactWidget.d(AtContactWidget.this).getWidth() - (int)(h.aRe().density * 32.0F)) / i;
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
  
  public final boolean aO(Intent paramIntent)
  {
    AppMethodBeat.i(97786);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    new LinkedList();
    if ((paramIntent == null) || (paramIntent.equals(""))) {}
    Object localObject1;
    Object localObject2;
    for (paramIntent = new LinkedList();; paramIntent = bu.U(paramIntent.split(",")))
    {
      if (this.Agd == null) {
        this.Agd = new LinkedList();
      }
      this.Agd.clear();
      localObject1 = paramIntent.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!this.Agd.contains(localObject2)) {
          this.Agd.add(localObject2);
        }
      }
    }
    if (this.Agb != null) {
      this.Agb.setList(this.Agd);
    }
    int i;
    if (this.owr != null)
    {
      localObject1 = this.owr;
      localObject2 = getResources();
      if (paramIntent.isEmpty())
      {
        i = 2131100711;
        ((TextView)localObject1).setTextColor(((Resources)localObject2).getColor(i));
      }
    }
    else if (this.Age)
    {
      ae.d("MicroMsg.AtContactWiget", "withList count " + this.Agd.size());
      if ((!this.Age) || (this.Aga == null) || (this.Agd.size() <= 0)) {
        break label374;
      }
      this.Aga.setVisibility(0);
      if (this.Agd.size() >= 100) {
        break label352;
      }
      this.Aga.setText(this.Agd.size());
      this.Aga.setBackgroundResource(u.aP(getContext(), this.Agd.size()));
    }
    for (;;)
    {
      eda();
      AppMethodBeat.o(97786);
      return true;
      i = 2131100464;
      break;
      label352:
      this.Aga.setText("");
      this.Aga.setBackgroundResource(2131689744);
      continue;
      label374:
      this.Aga.setVisibility(8);
    }
  }
  
  public final void ecZ()
  {
    AppMethodBeat.i(97784);
    if (this.Agd == null) {
      this.Agd = new LinkedList();
    }
    this.Agd.clear();
    if (this.Agb != null) {
      this.Agb.setList(this.Agd);
    }
    eda();
    if (this.Aga != null) {
      this.Aga.setVisibility(8);
    }
    if (this.owr != null) {
      this.owr.setTextColor(getResources().getColor(2131100711));
    }
    AppMethodBeat.o(97784);
  }
  
  public List<String> getAtList()
  {
    AppMethodBeat.i(97783);
    if (this.Agd == null) {
      this.Agd = new LinkedList();
    }
    List localList = this.Agd;
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
    if (this.Agb != null)
    {
      localPreviewContactView = this.Agb;
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
    this.Age = paramBoolean;
  }
  
  public void setShowAtTips(boolean paramBoolean)
  {
    AppMethodBeat.i(97789);
    TextView localTextView;
    if ((this.contentView != null) && (this.owr != null))
    {
      localTextView = this.owr;
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