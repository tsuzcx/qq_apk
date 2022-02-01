package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;

public class ContactCountView
  extends FrameLayout
{
  private int PUr;
  private int count;
  private View jxm;
  private boolean nsS;
  private boolean visible;
  private TextView yul;
  
  public ContactCountView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37723);
    this.nsS = false;
    this.count = 0;
    this.visible = true;
    this.PUr = 1;
    init();
    AppMethodBeat.o(37723);
  }
  
  public ContactCountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37722);
    this.nsS = false;
    this.count = 0;
    this.visible = true;
    this.PUr = 1;
    init();
    AppMethodBeat.o(37722);
  }
  
  private void init()
  {
    AppMethodBeat.i(37724);
    inflate(getContext(), 2131493715, this);
    AppMethodBeat.o(37724);
  }
  
  public final void gUw()
  {
    AppMethodBeat.i(37726);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(233997);
        String[] arrayOfString;
        ContactCountView localContactCountView;
        if (!ContactCountView.a(ContactCountView.this))
        {
          arrayOfString = ab.iCO;
          if (ContactCountView.b(ContactCountView.this) != 1) {
            break label124;
          }
          localContactCountView = ContactCountView.this;
          bg.aVF();
          ContactCountView.a(localContactCountView, c.aSN().c(arrayOfString, new String[] { z.aTY(), "weixin", "helper_entry", "filehelper" }));
        }
        for (;;)
        {
          Log.d("MicroMsg.ContactCountView", "contact count %d", new Object[] { Integer.valueOf(ContactCountView.c(ContactCountView.this)) });
          ContactCountView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(233996);
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
                AppMethodBeat.o(233996);
                return;
                label119:
                ContactCountView.d(ContactCountView.this).setText(ContactCountView.this.getContext().getResources().getQuantityString(2131623936, ContactCountView.c(ContactCountView.this), new Object[] { Integer.valueOf(ContactCountView.c(ContactCountView.this)) }));
              }
            }
          });
          AppMethodBeat.o(233997);
          return;
          label124:
          localContactCountView = ContactCountView.this;
          bg.aVF();
          ContactCountView.a(localContactCountView, c.aSN().d(arrayOfString, new String[] { z.aTY(), "weixin", "helper_entry", "filehelper" }));
        }
      }
    });
    AppMethodBeat.o(37726);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37725);
    Log.d("MicroMsg.ContactCountView", "onMeasure");
    if (this.jxm == null)
    {
      this.jxm = ((FrameLayout)findViewById(2131299029));
      this.yul = ((TextView)findViewById(2131299028));
    }
    gUw();
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(37725);
  }
  
  public void setContactType(int paramInt)
  {
    this.PUr = paramInt;
  }
  
  public void setFixedContactCount(int paramInt)
  {
    AppMethodBeat.i(180043);
    this.nsS = true;
    this.count = paramInt;
    gUw();
    AppMethodBeat.o(180043);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37727);
    this.visible = paramBoolean;
    View localView;
    if (this.jxm != null)
    {
      localView = this.jxm;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactCountView
 * JD-Core Version:    0.7.0.1
 */