package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;

public class ContactCountView
  extends FrameLayout
{
  private int AbJ;
  private boolean arf;
  private int count;
  private View gcq;
  private TextView nRK;
  
  public ContactCountView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33602);
    this.count = 0;
    this.arf = true;
    this.AbJ = 1;
    init();
    AppMethodBeat.o(33602);
  }
  
  public ContactCountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33601);
    this.count = 0;
    this.arf = true;
    this.AbJ = 1;
    init();
    AppMethodBeat.o(33601);
  }
  
  private void init()
  {
    AppMethodBeat.i(33603);
    inflate(getContext(), 2130969213, this);
    AppMethodBeat.o(33603);
  }
  
  public final void dLJ()
  {
    AppMethodBeat.i(33605);
    String[] arrayOfString = t.fll;
    if (this.AbJ == 1)
    {
      aw.aaz();
      this.count = c.YA().b(arrayOfString, new String[] { r.Zn(), "weixin", "helper_entry", "filehelper" });
      ab.d("MicroMsg.ContactCountView", "contact count %d", new Object[] { Integer.valueOf(this.count) });
      if (this.nRK != null)
      {
        if (this.AbJ != 1) {
          break label191;
        }
        this.nRK.setText(getContext().getResources().getQuantityString(2131361793, this.count, new Object[] { Integer.valueOf(this.count) }));
      }
    }
    for (;;)
    {
      setVisible(this.arf);
      AppMethodBeat.o(33605);
      return;
      aw.aaz();
      this.count = c.YA().c(arrayOfString, new String[] { r.Zn(), "weixin", "helper_entry", "filehelper" });
      break;
      label191:
      this.nRK.setText(getContext().getResources().getQuantityString(2131361792, this.count, new Object[] { Integer.valueOf(this.count) }));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33604);
    ab.d("MicroMsg.ContactCountView", "onMeasure");
    if (this.gcq == null)
    {
      this.gcq = ((FrameLayout)findViewById(2131823033));
      this.nRK = ((TextView)findViewById(2131823034));
    }
    dLJ();
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(33604);
  }
  
  public void setContactType(int paramInt)
  {
    this.AbJ = paramInt;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(33606);
    this.arf = paramBoolean;
    View localView;
    if (this.gcq != null)
    {
      localView = this.gcq;
      if ((!paramBoolean) || (this.count <= 0)) {
        break label46;
      }
    }
    label46:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(33606);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactCountView
 * JD-Core Version:    0.7.0.1
 */