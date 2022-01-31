package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.o;
import com.tencent.mm.cb.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.MaskLayout;

public class BizContactEntranceView
  extends RelativeLayout
{
  private View iUw = null;
  private Context mContext;
  View vJU;
  private TextView vJV;
  private boolean vJW = true;
  private boolean vJX;
  
  public BizContactEntranceView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
    cHr();
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
    cHr();
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
    cHr();
  }
  
  private void init()
  {
    this.vJX = false;
    View.inflate(getContext(), R.i.biz_contact_entrance_view, this);
    this.iUw = findViewById(R.h.container);
    this.vJU = this.iUw.findViewById(R.h.biz_contact_entrance_normal);
    Object localObject = this.vJU.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(a.ab(getContext(), R.f.ContactListHeight) * a.fg(getContext())));
    this.vJU.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.iUw.setOnClickListener(new BizContactEntranceView.1(this));
    this.vJU.setOnTouchListener(new BizContactEntranceView.2(this));
    localObject = (MaskLayout)this.vJU.findViewById(R.h.biz_contact_entrance_avatar_iv);
    ImageView localImageView = (ImageView)((MaskLayout)localObject).getContentView();
    o.JQ();
    localImageView.setImageBitmap(d.ki("service_officialaccounts"));
    this.vJV = ((TextView)((MaskLayout)localObject).findViewById(R.h.tipcnt_tv));
  }
  
  final void cHr()
  {
    long l = System.currentTimeMillis();
    au.Hx();
    int j = c.Fw().cur();
    View localView;
    if (j > 0)
    {
      this.vJW = true;
      localView = this.vJU;
      if (!this.vJW) {
        break label117;
      }
    }
    label117:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.vJW) {
        au.DS().O(new BizContactEntranceView.3(this));
      }
      y.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.vJW), Long.valueOf(System.currentTimeMillis() - l) });
      return;
      this.vJW = false;
      break;
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    int i = 0;
    y.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.vJW) });
    View localView = this.iUw;
    if ((paramBoolean) && (this.vJW)) {}
    for (;;)
    {
      localView.setVisibility(i);
      return;
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.BizContactEntranceView
 * JD-Core Version:    0.7.0.1
 */