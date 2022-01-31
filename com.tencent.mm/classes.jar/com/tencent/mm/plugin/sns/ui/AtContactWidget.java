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
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AtContactWidget
  extends LinearLayout
{
  private View contentView;
  private Activity fyk;
  private ImageView oNr;
  private TextView oNs;
  private TextView oNt;
  private PreviewContactView oNu;
  SnsUploadConfigView oNv;
  private List<String> oNw = new LinkedList();
  private boolean oNx = false;
  
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  @TargetApi(11)
  public AtContactWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void bHl()
  {
    if (this.oNw.size() > 0)
    {
      this.oNr.setImageResource(getWithDrawableId());
      return;
    }
    this.oNr.setImageResource(getWithEmptyDrawableId());
  }
  
  private void init(Context paramContext)
  {
    this.fyk = ((Activity)paramContext);
    this.contentView = com.tencent.mm.ui.y.gt(paramContext).inflate(getLayoutResource(), this);
    this.oNu = ((PreviewContactView)this.contentView.findViewById(i.f.at_contact_avatar));
    this.oNr = ((ImageView)this.contentView.findViewById(i.f.at_contact_iv));
    this.oNs = ((TextView)this.contentView.findViewById(i.f.at_contact_num));
    this.oNt = ((TextView)this.contentView.findViewById(i.f.at_contact_tips));
    this.contentView.setOnClickListener(new AtContactWidget.1(this));
    this.contentView.post(new AtContactWidget.2(this));
  }
  
  public final boolean U(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    new LinkedList();
    if ((paramIntent == null) || (paramIntent.equals(""))) {}
    Object localObject1;
    Object localObject2;
    for (paramIntent = new LinkedList();; paramIntent = bk.G(paramIntent.split(",")))
    {
      if (this.oNw == null) {
        this.oNw = new LinkedList();
      }
      this.oNw.clear();
      localObject1 = paramIntent.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!this.oNw.contains(localObject2)) {
          this.oNw.add(localObject2);
        }
      }
    }
    if (this.oNu != null) {
      this.oNu.setList(this.oNw);
    }
    int i;
    if (this.oNt != null)
    {
      localObject1 = this.oNt;
      localObject2 = getResources();
      if (paramIntent.isEmpty())
      {
        i = i.c.normal_text_color;
        ((TextView)localObject1).setTextColor(((Resources)localObject2).getColor(i));
      }
    }
    else if (this.oNx)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AtContactWiget", "withList count " + this.oNw.size());
      if ((!this.oNx) || (this.oNs == null) || (this.oNw.size() <= 0)) {
        break label332;
      }
      this.oNs.setVisibility(0);
      if (this.oNw.size() >= 100) {
        break label319;
      }
      this.oNs.setText(this.oNw.size());
    }
    for (;;)
    {
      bHl();
      return true;
      i = i.c.green_text_color;
      break;
      label319:
      this.oNs.setText(i.j.unread_count_overt_100);
      continue;
      label332:
      this.oNs.setVisibility(8);
    }
  }
  
  public final void bHk()
  {
    if (this.oNw == null) {
      this.oNw = new LinkedList();
    }
    this.oNw.clear();
    if (this.oNu != null) {
      this.oNu.setList(this.oNw);
    }
    bHl();
    if (this.oNs != null) {
      this.oNs.setVisibility(8);
    }
    if (this.oNt != null) {
      this.oNt.setTextColor(getResources().getColor(i.c.normal_text_color));
    }
  }
  
  public List<String> getAtList()
  {
    if (this.oNw == null) {
      this.oNw = new LinkedList();
    }
    return this.oNw;
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
    PreviewContactView localPreviewContactView;
    if (this.oNu != null)
    {
      localPreviewContactView = this.oNu;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localPreviewContactView.setVisibility(i);
      return;
    }
  }
  
  public void setShowAtNum(boolean paramBoolean)
  {
    this.oNx = paramBoolean;
  }
  
  public void setShowAtTips(boolean paramBoolean)
  {
    TextView localTextView;
    if ((this.contentView != null) && (this.oNt != null))
    {
      localTextView = this.oNt;
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AtContactWidget
 * JD-Core Version:    0.7.0.1
 */