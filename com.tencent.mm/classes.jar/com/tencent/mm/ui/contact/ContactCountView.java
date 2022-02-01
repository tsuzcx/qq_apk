package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bg;

public class ContactCountView
  extends FrameLayout
{
  private int GUh;
  private int count;
  private View hFi;
  private boolean leK;
  private TextView sFF;
  private boolean visible;
  
  public ContactCountView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37723);
    this.leK = false;
    this.count = 0;
    this.visible = true;
    this.GUh = 1;
    init();
    AppMethodBeat.o(37723);
  }
  
  public ContactCountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37722);
    this.leK = false;
    this.count = 0;
    this.visible = true;
    this.GUh = 1;
    init();
    AppMethodBeat.o(37722);
  }
  
  private void init()
  {
    AppMethodBeat.i(37724);
    inflate(getContext(), 2131493598, this);
    AppMethodBeat.o(37724);
  }
  
  public final void fbg()
  {
    AppMethodBeat.i(37726);
    String[] arrayOfString;
    if (!this.leK)
    {
      arrayOfString = w.gMw;
      if (this.GUh == 1)
      {
        az.arV();
        this.count = c.apM().c(arrayOfString, new String[] { u.aqG(), "weixin", "helper_entry", "filehelper" });
      }
    }
    else
    {
      ad.d("MicroMsg.ContactCountView", "contact count %d", new Object[] { Integer.valueOf(this.count) });
      if (this.sFF != null)
      {
        if (this.GUh != 1) {
          break label198;
        }
        this.sFF.setText(getContext().getResources().getQuantityString(2131623937, this.count, new Object[] { Integer.valueOf(this.count) }));
      }
    }
    for (;;)
    {
      setVisible(this.visible);
      AppMethodBeat.o(37726);
      return;
      az.arV();
      this.count = c.apM().d(arrayOfString, new String[] { u.aqG(), "weixin", "helper_entry", "filehelper" });
      break;
      label198:
      this.sFF.setText(getContext().getResources().getQuantityString(2131623936, this.count, new Object[] { Integer.valueOf(this.count) }));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37725);
    ad.d("MicroMsg.ContactCountView", "onMeasure");
    if (this.hFi == null)
    {
      this.hFi = ((FrameLayout)findViewById(2131298592));
      this.sFF = ((TextView)findViewById(2131298591));
    }
    fbg();
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(37725);
  }
  
  public void setContactType(int paramInt)
  {
    this.GUh = paramInt;
  }
  
  public void setFixedContactCount(int paramInt)
  {
    AppMethodBeat.i(180043);
    this.leK = true;
    this.count = paramInt;
    fbg();
    AppMethodBeat.o(180043);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37727);
    this.visible = paramBoolean;
    View localView;
    if (this.hFi != null)
    {
      localView = this.hFi;
      if ((!paramBoolean) || (this.count <= 0)) {
        break label46;
      }
    }
    label46:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(37727);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactCountView
 * JD-Core Version:    0.7.0.1
 */