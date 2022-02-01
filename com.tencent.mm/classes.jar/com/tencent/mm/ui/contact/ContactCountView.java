package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bq;

public class ContactCountView
  extends FrameLayout
{
  private int KHs;
  private int count;
  private View iBX;
  private boolean miy;
  private TextView vbL;
  private boolean visible;
  
  public ContactCountView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37723);
    this.miy = false;
    this.count = 0;
    this.visible = true;
    this.KHs = 1;
    init();
    AppMethodBeat.o(37723);
  }
  
  public ContactCountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37722);
    this.miy = false;
    this.count = 0;
    this.visible = true;
    this.KHs = 1;
    init();
    AppMethodBeat.o(37722);
  }
  
  private void init()
  {
    AppMethodBeat.i(37724);
    inflate(getContext(), 2131493598, this);
    AppMethodBeat.o(37724);
  }
  
  public final void fMc()
  {
    AppMethodBeat.i(37726);
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187939);
        String[] arrayOfString;
        ContactCountView localContactCountView;
        if (!ContactCountView.a(ContactCountView.this))
        {
          arrayOfString = x.hIe;
          if (ContactCountView.b(ContactCountView.this) != 1) {
            break label124;
          }
          localContactCountView = ContactCountView.this;
          bc.aCg();
          ContactCountView.a(localContactCountView, c.azF().c(arrayOfString, new String[] { v.aAC(), "weixin", "helper_entry", "filehelper" }));
        }
        for (;;)
        {
          ae.d("MicroMsg.ContactCountView", "contact count %d", new Object[] { Integer.valueOf(ContactCountView.c(ContactCountView.this)) });
          ContactCountView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187938);
              if (ContactCountView.d(ContactCountView.this) != null)
              {
                if (ContactCountView.b(ContactCountView.this) != 1) {
                  break label119;
                }
                ContactCountView.d(ContactCountView.this).setText(ContactCountView.this.getContext().getResources().getQuantityString(2131623937, ContactCountView.c(ContactCountView.this), new Object[] { Integer.valueOf(ContactCountView.c(ContactCountView.this)) }));
              }
              for (;;)
              {
                ContactCountView.this.setVisible(ContactCountView.e(ContactCountView.this));
                AppMethodBeat.o(187938);
                return;
                label119:
                ContactCountView.d(ContactCountView.this).setText(ContactCountView.this.getContext().getResources().getQuantityString(2131623936, ContactCountView.c(ContactCountView.this), new Object[] { Integer.valueOf(ContactCountView.c(ContactCountView.this)) }));
              }
            }
          });
          AppMethodBeat.o(187939);
          return;
          label124:
          localContactCountView = ContactCountView.this;
          bc.aCg();
          ContactCountView.a(localContactCountView, c.azF().d(arrayOfString, new String[] { v.aAC(), "weixin", "helper_entry", "filehelper" }));
        }
      }
    });
    AppMethodBeat.o(37726);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37725);
    ae.d("MicroMsg.ContactCountView", "onMeasure");
    if (this.iBX == null)
    {
      this.iBX = ((FrameLayout)findViewById(2131298592));
      this.vbL = ((TextView)findViewById(2131298591));
    }
    fMc();
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(37725);
  }
  
  public void setContactType(int paramInt)
  {
    this.KHs = paramInt;
  }
  
  public void setFixedContactCount(int paramInt)
  {
    AppMethodBeat.i(180043);
    this.miy = true;
    this.count = paramInt;
    fMc();
    AppMethodBeat.o(180043);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37727);
    this.visible = paramBoolean;
    View localView;
    if (this.iBX != null)
    {
      localView = this.iBX;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactCountView
 * JD-Core Version:    0.7.0.1
 */