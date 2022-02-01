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
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.tools.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AtContactWidget
  extends LinearLayout
{
  private boolean EoA;
  private TextView Eow;
  private PreviewContactView Eox;
  SnsUploadConfigView Eoy;
  private List<String> Eoz;
  private View contentView;
  private Activity mContext;
  private TextView pJV;
  private ImageView uzC;
  
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97782);
    this.Eoz = new LinkedList();
    this.EoA = false;
    init(paramContext);
    AppMethodBeat.o(97782);
  }
  
  @TargetApi(11)
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97781);
    this.Eoz = new LinkedList();
    this.EoA = false;
    init(paramContext);
    AppMethodBeat.o(97781);
  }
  
  private void ffn()
  {
    AppMethodBeat.i(97787);
    if (this.Eoz.size() > 0)
    {
      this.uzC.setImageDrawable(ar.m(this.mContext, getWithDrawableId(), getContext().getResources().getColor(2131101414)));
      AppMethodBeat.o(97787);
      return;
    }
    this.uzC.setImageDrawable(ar.m(this.mContext, getWithEmptyDrawableId(), getContext().getResources().getColor(2131100634)));
    AppMethodBeat.o(97787);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(97785);
    this.mContext = ((Activity)paramContext);
    this.contentView = aa.jQ(paramContext).inflate(getLayoutResource(), this);
    this.Eox = ((PreviewContactView)this.contentView.findViewById(2131297060));
    this.uzC = ((ImageView)this.contentView.findViewById(2131297061));
    this.Eow = ((TextView)this.contentView.findViewById(2131297063));
    this.pJV = ((TextView)this.contentView.findViewById(2131297064));
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97779);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/AtContactWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
        int i = (int)(BitmapUtil.getDefaultDisplayMetrics().density * 36.0F);
        if (i != 0)
        {
          i = (AtContactWidget.b(AtContactWidget.this).getWidth() - AtContactWidget.c(AtContactWidget.this).getWidth() - AtContactWidget.d(AtContactWidget.this).getWidth() - (int)(BitmapUtil.getDefaultDisplayMetrics().density * 32.0F)) / i;
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
  
  public final boolean aY(Intent paramIntent)
  {
    AppMethodBeat.i(97786);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    new LinkedList();
    if ((paramIntent == null) || (paramIntent.equals(""))) {}
    Object localObject1;
    Object localObject2;
    for (paramIntent = new LinkedList();; paramIntent = Util.stringsToList(paramIntent.split(",")))
    {
      if (this.Eoz == null) {
        this.Eoz = new LinkedList();
      }
      this.Eoz.clear();
      localObject1 = paramIntent.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!this.Eoz.contains(localObject2)) {
          this.Eoz.add(localObject2);
        }
      }
    }
    if (this.Eox != null) {
      this.Eox.setList(this.Eoz);
    }
    int i;
    if (this.pJV != null)
    {
      localObject1 = this.pJV;
      localObject2 = getResources();
      if (paramIntent.isEmpty())
      {
        i = 2131100904;
        ((TextView)localObject1).setTextColor(((Resources)localObject2).getColor(i));
      }
    }
    else if (this.EoA)
    {
      Log.d("MicroMsg.AtContactWiget", "withList count " + this.Eoz.size());
      if ((!this.EoA) || (this.Eow == null) || (this.Eoz.size() <= 0)) {
        break label374;
      }
      this.Eow.setVisibility(0);
      if (this.Eoz.size() >= 100) {
        break label352;
      }
      this.Eow.setText(this.Eoz.size());
      this.Eow.setBackgroundResource(v.aQ(getContext(), this.Eoz.size()));
    }
    for (;;)
    {
      ffn();
      AppMethodBeat.o(97786);
      return true;
      i = 2131100566;
      break;
      label352:
      this.Eow.setText("");
      this.Eow.setBackgroundResource(2131689753);
      continue;
      label374:
      this.Eow.setVisibility(8);
    }
  }
  
  public final void ffm()
  {
    AppMethodBeat.i(97784);
    if (this.Eoz == null) {
      this.Eoz = new LinkedList();
    }
    this.Eoz.clear();
    if (this.Eox != null) {
      this.Eox.setList(this.Eoz);
    }
    ffn();
    if (this.Eow != null) {
      this.Eow.setVisibility(8);
    }
    if (this.pJV != null) {
      this.pJV.setTextColor(getResources().getColor(2131100904));
    }
    AppMethodBeat.o(97784);
  }
  
  public List<String> getAtList()
  {
    AppMethodBeat.i(97783);
    if (this.Eoz == null) {
      this.Eoz = new LinkedList();
    }
    List localList = this.Eoz;
    AppMethodBeat.o(97783);
    return localList;
  }
  
  protected int getLayoutResource()
  {
    return 2131493156;
  }
  
  protected int getWithDrawableId()
  {
    return 2131689538;
  }
  
  protected int getWithEmptyDrawableId()
  {
    return 2131689537;
  }
  
  public void setShowAtList(boolean paramBoolean)
  {
    AppMethodBeat.i(97788);
    PreviewContactView localPreviewContactView;
    if (this.Eox != null)
    {
      localPreviewContactView = this.Eox;
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
    this.EoA = paramBoolean;
  }
  
  public void setShowAtTips(boolean paramBoolean)
  {
    AppMethodBeat.i(97789);
    TextView localTextView;
    if ((this.contentView != null) && (this.pJV != null))
    {
      localTextView = this.pJV;
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