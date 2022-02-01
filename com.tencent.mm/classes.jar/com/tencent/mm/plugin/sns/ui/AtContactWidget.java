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
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.tools.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AtContactWidget
  extends LinearLayout
{
  private TextView AWF;
  private TextView KBF;
  private PreviewContactView KBG;
  SnsUploadConfigView KBH;
  private List<String> KBI;
  private boolean KBJ;
  private View contentView;
  private Activity mContext;
  private ImageView yVe;
  
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97782);
    this.KBI = new LinkedList();
    this.KBJ = false;
    init(paramContext);
    AppMethodBeat.o(97782);
  }
  
  @TargetApi(11)
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97781);
    this.KBI = new LinkedList();
    this.KBJ = false;
    init(paramContext);
    AppMethodBeat.o(97781);
  }
  
  private void fTi()
  {
    AppMethodBeat.i(97787);
    if (this.KBI.size() > 0)
    {
      this.yVe.setImageDrawable(au.o(this.mContext, getWithDrawableId(), getContext().getResources().getColor(i.c.wechat_green)));
      AppMethodBeat.o(97787);
      return;
    }
    this.yVe.setImageDrawable(au.o(this.mContext, getWithEmptyDrawableId(), getContext().getResources().getColor(i.c.icon_color)));
    AppMethodBeat.o(97787);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(97785);
    this.mContext = ((Activity)paramContext);
    this.contentView = ad.kS(paramContext).inflate(getLayoutResource(), this);
    this.KBG = ((PreviewContactView)this.contentView.findViewById(i.f.at_contact_avatar));
    this.yVe = ((ImageView)this.contentView.findViewById(i.f.at_contact_iv));
    this.KBF = ((TextView)this.contentView.findViewById(i.f.at_contact_num));
    this.AWF = ((TextView)this.contentView.findViewById(i.f.at_contact_tips));
    this.contentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97779);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/AtContactWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
      if (this.KBI == null) {
        this.KBI = new LinkedList();
      }
      this.KBI.clear();
      localObject1 = paramIntent.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!this.KBI.contains(localObject2)) {
          this.KBI.add(localObject2);
        }
      }
    }
    if (this.KBG != null) {
      this.KBG.setList(this.KBI);
    }
    int i;
    if (this.AWF != null)
    {
      localObject1 = this.AWF;
      localObject2 = getResources();
      if (paramIntent.isEmpty())
      {
        i = i.c.normal_text_color;
        ((TextView)localObject1).setTextColor(((Resources)localObject2).getColor(i));
      }
    }
    else if (this.KBJ)
    {
      Log.d("MicroMsg.AtContactWiget", "withList count " + this.KBI.size());
      if ((!this.KBJ) || (this.KBF == null) || (this.KBI.size() <= 0)) {
        break label378;
      }
      this.KBF.setVisibility(0);
      if (this.KBI.size() >= 100) {
        break label355;
      }
      this.KBF.setText(this.KBI.size());
      this.KBF.setBackgroundResource(w.bj(getContext(), this.KBI.size()));
    }
    for (;;)
    {
      fTi();
      AppMethodBeat.o(97786);
      return true;
      i = i.c.green_text_color;
      break;
      label355:
      this.KBF.setText("");
      this.KBF.setBackgroundResource(i.i.badge_count_more);
      continue;
      label378:
      this.KBF.setVisibility(8);
    }
  }
  
  public final void fTh()
  {
    AppMethodBeat.i(97784);
    if (this.KBI == null) {
      this.KBI = new LinkedList();
    }
    this.KBI.clear();
    if (this.KBG != null) {
      this.KBG.setList(this.KBI);
    }
    fTi();
    if (this.KBF != null) {
      this.KBF.setVisibility(8);
    }
    if (this.AWF != null) {
      this.AWF.setTextColor(getResources().getColor(i.c.normal_text_color));
    }
    AppMethodBeat.o(97784);
  }
  
  public List<String> getAtList()
  {
    AppMethodBeat.i(97783);
    if (this.KBI == null) {
      this.KBI = new LinkedList();
    }
    List localList = this.KBI;
    AppMethodBeat.o(97783);
    return localList;
  }
  
  protected int getLayoutResource()
  {
    return i.g.at_contact_widget;
  }
  
  protected int getWithDrawableId()
  {
    return i.i.album_mention_icon_pressed;
  }
  
  protected int getWithEmptyDrawableId()
  {
    return i.i.album_mention_icon_normal;
  }
  
  public void setShowAtList(boolean paramBoolean)
  {
    AppMethodBeat.i(97788);
    PreviewContactView localPreviewContactView;
    if (this.KBG != null)
    {
      localPreviewContactView = this.KBG;
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
    this.KBJ = paramBoolean;
  }
  
  public void setShowAtTips(boolean paramBoolean)
  {
    AppMethodBeat.i(97789);
    TextView localTextView;
    if ((this.contentView != null) && (this.AWF != null))
    {
      localTextView = this.AWF;
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