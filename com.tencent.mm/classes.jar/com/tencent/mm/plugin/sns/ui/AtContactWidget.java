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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.tools.u;
import com.tencent.mm.ui.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AtContactWidget
  extends LinearLayout
{
  private View contentView;
  private Activity jHh;
  private TextView nNp;
  private ImageView yxG;
  private TextView yxH;
  private PreviewContactView yxI;
  SnsUploadConfigView yxJ;
  private List<String> yxK;
  private boolean yxL;
  
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97782);
    this.yxK = new LinkedList();
    this.yxL = false;
    init(paramContext);
    AppMethodBeat.o(97782);
  }
  
  @TargetApi(11)
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97781);
    this.yxK = new LinkedList();
    this.yxL = false;
    init(paramContext);
    AppMethodBeat.o(97781);
  }
  
  private void dNg()
  {
    AppMethodBeat.i(97787);
    if (this.yxK.size() > 0)
    {
      this.yxG.setImageDrawable(am.k(this.jHh, getWithDrawableId(), getContext().getResources().getColor(2131101171)));
      AppMethodBeat.o(97787);
      return;
    }
    this.yxG.setImageDrawable(am.k(this.jHh, getWithEmptyDrawableId(), getContext().getResources().getColor(2131100499)));
    AppMethodBeat.o(97787);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(97785);
    this.jHh = ((Activity)paramContext);
    this.contentView = z.jD(paramContext).inflate(getLayoutResource(), this);
    this.yxI = ((PreviewContactView)this.contentView.findViewById(2131296951));
    this.yxG = ((ImageView)this.contentView.findViewById(2131296952));
    this.yxH = ((TextView)this.contentView.findViewById(2131296954));
    this.nNp = ((TextView)this.contentView.findViewById(2131296955));
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97779);
        AtContactWidget.a(AtContactWidget.this);
        AppMethodBeat.o(97779);
      }
    });
    this.contentView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97780);
        int i = (int)(f.aNu().density * 36.0F);
        if (i != 0)
        {
          i = (AtContactWidget.b(AtContactWidget.this).getWidth() - AtContactWidget.c(AtContactWidget.this).getWidth() - AtContactWidget.d(AtContactWidget.this).getWidth() - (int)(f.aNu().density * 32.0F)) / i;
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
  
  public final boolean aI(Intent paramIntent)
  {
    AppMethodBeat.i(97786);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    new LinkedList();
    if ((paramIntent == null) || (paramIntent.equals(""))) {}
    Object localObject1;
    Object localObject2;
    for (paramIntent = new LinkedList();; paramIntent = bs.S(paramIntent.split(",")))
    {
      if (this.yxK == null) {
        this.yxK = new LinkedList();
      }
      this.yxK.clear();
      localObject1 = paramIntent.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!this.yxK.contains(localObject2)) {
          this.yxK.add(localObject2);
        }
      }
    }
    if (this.yxI != null) {
      this.yxI.setList(this.yxK);
    }
    int i;
    if (this.nNp != null)
    {
      localObject1 = this.nNp;
      localObject2 = getResources();
      if (paramIntent.isEmpty())
      {
        i = 2131100711;
        ((TextView)localObject1).setTextColor(((Resources)localObject2).getColor(i));
      }
    }
    else if (this.yxL)
    {
      ac.d("MicroMsg.AtContactWiget", "withList count " + this.yxK.size());
      if ((!this.yxL) || (this.yxH == null) || (this.yxK.size() <= 0)) {
        break label374;
      }
      this.yxH.setVisibility(0);
      if (this.yxK.size() >= 100) {
        break label352;
      }
      this.yxH.setText(this.yxK.size());
      this.yxH.setBackgroundResource(u.aM(getContext(), this.yxK.size()));
    }
    for (;;)
    {
      dNg();
      AppMethodBeat.o(97786);
      return true;
      i = 2131100464;
      break;
      label352:
      this.yxH.setText("");
      this.yxH.setBackgroundResource(2131689744);
      continue;
      label374:
      this.yxH.setVisibility(8);
    }
  }
  
  public final void dNf()
  {
    AppMethodBeat.i(97784);
    if (this.yxK == null) {
      this.yxK = new LinkedList();
    }
    this.yxK.clear();
    if (this.yxI != null) {
      this.yxI.setList(this.yxK);
    }
    dNg();
    if (this.yxH != null) {
      this.yxH.setVisibility(8);
    }
    if (this.nNp != null) {
      this.nNp.setTextColor(getResources().getColor(2131100711));
    }
    AppMethodBeat.o(97784);
  }
  
  public List<String> getAtList()
  {
    AppMethodBeat.i(97783);
    if (this.yxK == null) {
      this.yxK = new LinkedList();
    }
    List localList = this.yxK;
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
    if (this.yxI != null)
    {
      localPreviewContactView = this.yxI;
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
    this.yxL = paramBoolean;
  }
  
  public void setShowAtTips(boolean paramBoolean)
  {
    AppMethodBeat.i(97789);
    TextView localTextView;
    if ((this.contentView != null) && (this.nNp != null))
    {
      localTextView = this.nNp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AtContactWidget
 * JD-Core Version:    0.7.0.1
 */