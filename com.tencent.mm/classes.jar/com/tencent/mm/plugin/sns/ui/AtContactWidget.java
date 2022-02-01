package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AtContactWidget
  extends LinearLayout
{
  private TextView DMt;
  private WeImageView Rbm;
  private TextView Rbn;
  private PreviewContactView Rbo;
  SnsUploadConfigView Rbp;
  private List<String> Rbq;
  private boolean Rbr;
  private View contentView;
  private Activity mContext;
  
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97782);
    this.Rbq = new LinkedList();
    this.Rbr = false;
    init(paramContext);
    AppMethodBeat.o(97782);
  }
  
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97781);
    this.Rbq = new LinkedList();
    this.Rbr = false;
    init(paramContext);
    AppMethodBeat.o(97781);
  }
  
  private void hly()
  {
    AppMethodBeat.i(307942);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.Rbq.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(ab.Jg(str).aSU() + ",");
    }
    this.contentView.setContentDescription(this.DMt.getText() + " " + localStringBuilder);
    AppMethodBeat.o(307942);
  }
  
  private void hlz()
  {
    AppMethodBeat.i(97787);
    if (this.Rbq.size() > 0)
    {
      this.Rbm.oR(getWithDrawableId(), b.c.wechat_green);
      AppMethodBeat.o(97787);
      return;
    }
    this.Rbm.oR(getWithEmptyDrawableId(), b.c.icon_color);
    AppMethodBeat.o(97787);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(97785);
    this.mContext = ((Activity)paramContext);
    this.contentView = af.mU(paramContext).inflate(getLayoutResource(), this);
    this.Rbo = ((PreviewContactView)this.contentView.findViewById(b.f.at_contact_avatar));
    this.Rbm = ((WeImageView)this.contentView.findViewById(b.f.at_contact_iv));
    this.Rbn = ((TextView)this.contentView.findViewById(b.f.at_contact_num));
    this.DMt = ((TextView)this.contentView.findViewById(b.f.at_contact_tips));
    int i;
    if (aj.hga())
    {
      this.DMt.setText(b.j.sns_together_with_you);
      paramContext = this.contentView.findViewById(b.f.at_contact_tips_reddot);
      if (aj.hgb())
      {
        i = 0;
        paramContext.setVisibility(i);
      }
    }
    for (;;)
    {
      this.contentView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97779);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/sns/ui/AtContactWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          AtContactWidget.a(AtContactWidget.this).findViewById(b.f.at_contact_tips_reddot).setVisibility(8);
          if (aj.hgb()) {
            MultiProcessMMKV.getDefault().encode("sns_with_together_at_contact_red", 1);
          }
          AtContactWidget.b(AtContactWidget.this);
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
            i = (AtContactWidget.a(AtContactWidget.this).getWidth() - AtContactWidget.c(AtContactWidget.this).getWidth() - AtContactWidget.d(AtContactWidget.this).getWidth() - (int)(BitmapUtil.getDefaultDisplayMetrics().density * 32.0F)) / i;
            if ((i > 0) && (i < 5))
            {
              AtContactWidget.e(AtContactWidget.this).setLineNum(i);
              LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)AtContactWidget.e(AtContactWidget.this).getLayoutParams();
              AtContactWidget.e(AtContactWidget.this).setLayoutParams(localLayoutParams);
            }
          }
          AppMethodBeat.o(97780);
        }
      });
      hly();
      AppMethodBeat.o(97785);
      return;
      i = 8;
      break;
      this.contentView.findViewById(b.f.at_contact_tips_reddot).setVisibility(8);
    }
  }
  
  public final void DY(boolean paramBoolean)
  {
    AppMethodBeat.i(307967);
    if ((this.Rbq.size() > 0) && (!paramBoolean) && (aj.hga()))
    {
      getRootView().findViewById(b.f.show_withta_msg).setVisibility(0);
      AppMethodBeat.o(307967);
      return;
    }
    getRootView().findViewById(b.f.show_withta_msg).setVisibility(8);
    AppMethodBeat.o(307967);
  }
  
  public final boolean d(Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(307971);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    new LinkedList();
    if ((paramIntent == null) || (paramIntent.equals(""))) {}
    Object localObject1;
    Object localObject2;
    for (paramIntent = new LinkedList();; paramIntent = Util.stringsToList(paramIntent.split(",")))
    {
      if (this.Rbq == null) {
        this.Rbq = new LinkedList();
      }
      this.Rbq.clear();
      localObject1 = paramIntent.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!this.Rbq.contains(localObject2)) {
          this.Rbq.add(localObject2);
        }
      }
    }
    if (this.Rbo != null) {
      this.Rbo.setList(this.Rbq);
    }
    DY(paramBoolean);
    int i;
    if (this.DMt != null)
    {
      localObject1 = this.DMt;
      localObject2 = getResources();
      if (paramIntent.isEmpty())
      {
        i = b.c.normal_text_color;
        ((TextView)localObject1).setTextColor(((Resources)localObject2).getColor(i));
      }
    }
    else if (this.Rbr)
    {
      Log.d("MicroMsg.AtContactWiget", "withList count " + this.Rbq.size());
      if ((!this.Rbr) || (this.Rbn == null) || (this.Rbq.size() <= 0)) {
        break label392;
      }
      this.Rbn.setVisibility(0);
      if (this.Rbq.size() >= 100) {
        break label369;
      }
      this.Rbn.setText(this.Rbq.size());
      this.Rbn.setBackgroundResource(v.bC(getContext(), this.Rbq.size()));
    }
    for (;;)
    {
      hlz();
      hly();
      AppMethodBeat.o(307971);
      return true;
      i = b.c.green_text_color;
      break;
      label369:
      this.Rbn.setText("");
      this.Rbn.setBackgroundResource(b.i.badge_count_more);
      continue;
      label392:
      this.Rbn.setVisibility(8);
    }
  }
  
  public List<String> getAtList()
  {
    AppMethodBeat.i(97783);
    if (this.Rbq == null) {
      this.Rbq = new LinkedList();
    }
    List localList = this.Rbq;
    AppMethodBeat.o(97783);
    return localList;
  }
  
  protected int getLayoutResource()
  {
    return b.g.at_contact_widget;
  }
  
  protected int getWithDrawableId()
  {
    AppMethodBeat.i(307980);
    if (aj.hga())
    {
      i = b.i.icon_filled_together;
      AppMethodBeat.o(307980);
      return i;
    }
    int i = b.i.album_mention_icon_pressed;
    AppMethodBeat.o(307980);
    return i;
  }
  
  protected int getWithEmptyDrawableId()
  {
    AppMethodBeat.i(307983);
    if (aj.hga())
    {
      i = b.i.icon_outlined_together;
      AppMethodBeat.o(307983);
      return i;
    }
    int i = b.i.album_mention_icon_normal;
    AppMethodBeat.o(307983);
    return i;
  }
  
  public final void hlx()
  {
    AppMethodBeat.i(97784);
    if (this.Rbq == null) {
      this.Rbq = new LinkedList();
    }
    this.Rbq.clear();
    if (this.Rbo != null) {
      this.Rbo.setList(this.Rbq);
    }
    hlz();
    if (this.Rbn != null) {
      this.Rbn.setVisibility(8);
    }
    if (this.DMt != null) {
      this.DMt.setTextColor(getResources().getColor(b.c.normal_text_color));
    }
    AppMethodBeat.o(97784);
  }
  
  public void setShowAtList(boolean paramBoolean)
  {
    AppMethodBeat.i(97788);
    PreviewContactView localPreviewContactView;
    if (this.Rbo != null)
    {
      localPreviewContactView = this.Rbo;
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
    this.Rbr = paramBoolean;
  }
  
  public void setShowAtTips(boolean paramBoolean)
  {
    AppMethodBeat.i(97789);
    TextView localTextView;
    if ((this.contentView != null) && (this.DMt != null))
    {
      localTextView = this.DMt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AtContactWidget
 * JD-Core Version:    0.7.0.1
 */