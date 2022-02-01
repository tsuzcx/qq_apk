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
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bj;

public class ContactCountView
  extends FrameLayout
{
  private int Ius;
  private int count;
  private View ifK;
  private boolean lEA;
  private TextView tNm;
  private boolean visible;
  
  public ContactCountView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37723);
    this.lEA = false;
    this.count = 0;
    this.visible = true;
    this.Ius = 1;
    init();
    AppMethodBeat.o(37723);
  }
  
  public ContactCountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37722);
    this.lEA = false;
    this.count = 0;
    this.visible = true;
    this.Ius = 1;
    init();
    AppMethodBeat.o(37722);
  }
  
  private void init()
  {
    AppMethodBeat.i(37724);
    inflate(getContext(), 2131493598, this);
    AppMethodBeat.o(37724);
  }
  
  public final void fqX()
  {
    AppMethodBeat.i(37726);
    h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196747);
        String[] arrayOfString;
        ContactCountView localContactCountView;
        if (!ContactCountView.a(ContactCountView.this))
        {
          arrayOfString = w.hmW;
          if (ContactCountView.b(ContactCountView.this) != 1) {
            break label124;
          }
          localContactCountView = ContactCountView.this;
          az.ayM();
          ContactCountView.a(localContactCountView, c.awB().c(arrayOfString, new String[] { u.axw(), "weixin", "helper_entry", "filehelper" }));
        }
        for (;;)
        {
          ac.d("MicroMsg.ContactCountView", "contact count %d", new Object[] { Integer.valueOf(ContactCountView.c(ContactCountView.this)) });
          ContactCountView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(196746);
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
                AppMethodBeat.o(196746);
                return;
                label119:
                ContactCountView.d(ContactCountView.this).setText(ContactCountView.this.getContext().getResources().getQuantityString(2131623936, ContactCountView.c(ContactCountView.this), new Object[] { Integer.valueOf(ContactCountView.c(ContactCountView.this)) }));
              }
            }
          });
          AppMethodBeat.o(196747);
          return;
          label124:
          localContactCountView = ContactCountView.this;
          az.ayM();
          ContactCountView.a(localContactCountView, c.awB().d(arrayOfString, new String[] { u.axw(), "weixin", "helper_entry", "filehelper" }));
        }
      }
    });
    AppMethodBeat.o(37726);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37725);
    ac.d("MicroMsg.ContactCountView", "onMeasure");
    if (this.ifK == null)
    {
      this.ifK = ((FrameLayout)findViewById(2131298592));
      this.tNm = ((TextView)findViewById(2131298591));
    }
    fqX();
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(37725);
  }
  
  public void setContactType(int paramInt)
  {
    this.Ius = paramInt;
  }
  
  public void setFixedContactCount(int paramInt)
  {
    AppMethodBeat.i(180043);
    this.lEA = true;
    this.count = paramInt;
    fqX();
    AppMethodBeat.o(180043);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37727);
    this.visible = paramBoolean;
    View localView;
    if (this.ifK != null)
    {
      localView = this.ifK;
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