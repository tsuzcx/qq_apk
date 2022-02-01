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
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bp;

public class ContactCountView
  extends FrameLayout
{
  private int KkY;
  private int count;
  private View ize;
  private boolean mee;
  private TextView uPZ;
  private boolean visible;
  
  public ContactCountView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37723);
    this.mee = false;
    this.count = 0;
    this.visible = true;
    this.KkY = 1;
    init();
    AppMethodBeat.o(37723);
  }
  
  public ContactCountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37722);
    this.mee = false;
    this.count = 0;
    this.visible = true;
    this.KkY = 1;
    init();
    AppMethodBeat.o(37722);
  }
  
  private void init()
  {
    AppMethodBeat.i(37724);
    inflate(getContext(), 2131493598, this);
    AppMethodBeat.o(37724);
  }
  
  public final void fHK()
  {
    AppMethodBeat.i(37726);
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194538);
        String[] arrayOfString;
        ContactCountView localContactCountView;
        if (!ContactCountView.a(ContactCountView.this))
        {
          arrayOfString = w.hFm;
          if (ContactCountView.b(ContactCountView.this) != 1) {
            break label124;
          }
          localContactCountView = ContactCountView.this;
          ba.aBQ();
          ContactCountView.a(localContactCountView, c.azp().c(arrayOfString, new String[] { u.aAm(), "weixin", "helper_entry", "filehelper" }));
        }
        for (;;)
        {
          ad.d("MicroMsg.ContactCountView", "contact count %d", new Object[] { Integer.valueOf(ContactCountView.c(ContactCountView.this)) });
          ContactCountView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194537);
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
                AppMethodBeat.o(194537);
                return;
                label119:
                ContactCountView.d(ContactCountView.this).setText(ContactCountView.this.getContext().getResources().getQuantityString(2131623936, ContactCountView.c(ContactCountView.this), new Object[] { Integer.valueOf(ContactCountView.c(ContactCountView.this)) }));
              }
            }
          });
          AppMethodBeat.o(194538);
          return;
          label124:
          localContactCountView = ContactCountView.this;
          ba.aBQ();
          ContactCountView.a(localContactCountView, c.azp().d(arrayOfString, new String[] { u.aAm(), "weixin", "helper_entry", "filehelper" }));
        }
      }
    });
    AppMethodBeat.o(37726);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37725);
    ad.d("MicroMsg.ContactCountView", "onMeasure");
    if (this.ize == null)
    {
      this.ize = ((FrameLayout)findViewById(2131298592));
      this.uPZ = ((TextView)findViewById(2131298591));
    }
    fHK();
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(37725);
  }
  
  public void setContactType(int paramInt)
  {
    this.KkY = paramInt;
  }
  
  public void setFixedContactCount(int paramInt)
  {
    AppMethodBeat.i(180043);
    this.mee = true;
    this.count = paramInt;
    fHK();
    AppMethodBeat.o(180043);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37727);
    this.visible = paramBoolean;
    View localView;
    if (this.ize != null)
    {
      localView = this.ize;
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