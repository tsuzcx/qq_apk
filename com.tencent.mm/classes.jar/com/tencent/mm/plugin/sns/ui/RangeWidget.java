package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RangeWidget
  extends RelativeLayout
{
  private View contentView;
  private Activity fyk;
  private ImageView oNr;
  SnsUploadConfigView oNv;
  private TextView oQq;
  private TextView oSR;
  private boolean oSS = true;
  private int oST = 0;
  String oSU = "";
  private String oSV = "";
  private String oSW = "";
  public int style = 0;
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public RangeWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private static List<String> F(List<String> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    g.DQ();
    if (!g.DN().Dc()) {
      return localLinkedList;
    }
    if (paramList == null) {
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      g.DQ();
      ad localad = ((j)g.r(j.class)).Fw().abl(str);
      paramList = str;
      if (localad != null)
      {
        paramList = str;
        if ((int)localad.dBe != 0) {
          paramList = localad.Bq();
        }
      }
      localLinkedList.add(paramList);
    }
    return localLinkedList;
  }
  
  private void init(Context paramContext)
  {
    this.fyk = ((Activity)paramContext);
    this.contentView = View.inflate(paramContext, getLayoutResource(), this);
    this.oSR = ((TextView)this.contentView.findViewById(i.f.sns_tag_range_list));
    this.oQq = ((TextView)this.contentView.findViewById(i.f.left_tv));
    this.oNr = ((ImageView)this.contentView.findViewById(i.f.rang_icon));
    this.contentView.setOnClickListener(new RangeWidget.1(this));
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent, AtContactWidget paramAtContactWidget)
  {
    this.oST = paramIntent.getIntExtra("Ktag_range_index", 0);
    this.oSV = paramIntent.getStringExtra("Klabel_name_list");
    this.oSW = paramIntent.getStringExtra("Kother_user_name_list");
    paramInt1 = getMaxTagNameLen();
    Object localObject = "";
    if (!bk.bl(this.oSV)) {
      localObject = "" + this.oSV;
    }
    paramIntent = (Intent)localObject;
    if (!bk.bl(this.oSW))
    {
      paramIntent = bk.c(F(Arrays.asList(this.oSW.split(","))), ",");
      if (((String)localObject).length() <= 0) {
        break label298;
      }
    }
    label298:
    for (paramIntent = (String)localObject + "," + paramIntent;; paramIntent = (String)localObject + paramIntent)
    {
      localObject = paramIntent;
      if (paramInt1 != -1)
      {
        localObject = paramIntent;
        if (paramIntent != null)
        {
          localObject = paramIntent;
          if (paramIntent.length() > paramInt1) {
            localObject = paramIntent.substring(0, paramInt1) + "...";
          }
        }
      }
      paramInt1 = this.oST;
      if (this.oNr != null)
      {
        this.oNr.setImageResource(i.i.album_group_icon_pressed);
        this.oQq.setTextColor(getResources().getColor(i.c.green_text_color));
        this.oSR.setTextColor(getResources().getColor(i.c.green_text_color));
      }
      if (this.oNv != null) {
        this.oNv.setPrivated(false);
      }
      switch (paramInt1)
      {
      default: 
        return true;
      }
    }
    if (this.oNr != null)
    {
      this.oNr.setImageResource(i.i.album_group_icon_normal);
      this.oQq.setTextColor(getResources().getColor(i.c.normal_text_color));
      this.oSR.setTextColor(getResources().getColor(i.c.hint_text_color));
    }
    this.oSR.setText(i.j.sns_label_public);
    return true;
    if (this.oNv != null) {
      this.oNv.setPrivated(true);
    }
    if ((paramAtContactWidget != null) && (this.oNv != null) && (paramAtContactWidget.getAtList().size() > 0))
    {
      h.h(this.fyk, i.j.sns_tag_privacy_with_others_tip, i.j.app_tip);
      paramAtContactWidget.bHk();
      this.oNv.bJS();
    }
    this.oSR.setText(i.j.sns_label_private);
    return true;
    this.oSR.setText((CharSequence)localObject);
    return true;
    paramIntent = this.oSR;
    paramAtContactWidget = this.fyk.getString(i.j.sns_label_exclide_prefix);
    localObject = paramAtContactWidget + "  " + (String)localObject;
    SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
    localSpannableString.setSpan(new ForegroundColorSpan(-65536), paramAtContactWidget.length() + 2, ((String)localObject).length(), 33);
    paramIntent.setText(localSpannableString);
    return true;
  }
  
  public int getLabelRange()
  {
    return this.oST;
  }
  
  protected int getLayoutResource()
  {
    return i.g.rang_layout;
  }
  
  protected int getMaxTagNameLen()
  {
    return -1;
  }
  
  public void setEnablePrivate(boolean paramBoolean)
  {
    this.oSS = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RangeWidget
 * JD-Core Version:    0.7.0.1
 */