package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;

public class ContactCountView
  extends FrameLayout
{
  private boolean aoL = true;
  private int count = 0;
  private View eML;
  private TextView lus;
  private int vKj = 1;
  
  public ContactCountView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ContactCountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    inflate(getContext(), R.i.contact_count_view, this);
  }
  
  public final void cHs()
  {
    String[] arrayOfString = s.dVc;
    if (this.vKj == 1)
    {
      au.Hx();
      this.count = c.Fw().b(arrayOfString, new String[] { q.Gj(), "weixin", "helper_entry", "filehelper" });
      y.d("MicroMsg.ContactCountView", "contact count %d", new Object[] { Integer.valueOf(this.count) });
      if (this.lus != null)
      {
        if (this.vKj != 1) {
          break label182;
        }
        this.lus.setText(getContext().getResources().getQuantityString(R.j.address_contact_count, this.count, new Object[] { Integer.valueOf(this.count) }));
      }
    }
    for (;;)
    {
      setVisible(this.aoL);
      return;
      au.Hx();
      this.count = c.Fw().c(arrayOfString, new String[] { q.Gj(), "weixin", "helper_entry", "filehelper" });
      break;
      label182:
      this.lus.setText(getContext().getResources().getQuantityString(R.j.address_chatroom_contact_count, this.count, new Object[] { Integer.valueOf(this.count) }));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.ContactCountView", "onMeasure");
    if (this.eML == null)
    {
      this.eML = ((FrameLayout)findViewById(R.h.contact_count_view_fl));
      this.lus = ((TextView)findViewById(R.h.contact_count_tv));
    }
    cHs();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setContactType(int paramInt)
  {
    this.vKj = paramInt;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.aoL = paramBoolean;
    View localView;
    if (this.eML != null)
    {
      localView = this.eML;
      if ((!paramBoolean) || (this.count <= 0)) {
        break label36;
      }
    }
    label36:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactCountView
 * JD-Core Version:    0.7.0.1
 */