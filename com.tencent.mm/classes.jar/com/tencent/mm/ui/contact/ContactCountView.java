package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bx;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public class ContactCountView
  extends FrameLayout
{
  private int AAF;
  private TextView JLz;
  private int count;
  private View hDw;
  private boolean tzC;
  private boolean visible;
  
  public ContactCountView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37723);
    this.tzC = false;
    this.count = 0;
    this.visible = true;
    this.AAF = 1;
    init();
    AppMethodBeat.o(37723);
  }
  
  public ContactCountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37722);
    this.tzC = false;
    this.count = 0;
    this.visible = true;
    this.AAF = 1;
    init();
    AppMethodBeat.o(37722);
  }
  
  private void init()
  {
    AppMethodBeat.i(37724);
    inflate(getContext(), R.i.ghI, this);
    AppMethodBeat.o(37724);
  }
  
  public final void jyf()
  {
    AppMethodBeat.i(37726);
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(253274);
        String[] arrayOfString;
        ContactCountView localContactCountView;
        if (!ContactCountView.a(ContactCountView.this))
        {
          arrayOfString = ab.oko;
          if (ContactCountView.b(ContactCountView.this) != 1) {
            break label124;
          }
          localContactCountView = ContactCountView.this;
          bh.bCz();
          ContactCountView.a(localContactCountView, c.bzA().d(arrayOfString, new String[] { z.bAM(), "weixin", "helper_entry", "filehelper" }));
        }
        for (;;)
        {
          Log.d("MicroMsg.ContactCountView", "contact count %d", new Object[] { Integer.valueOf(ContactCountView.c(ContactCountView.this)) });
          ContactCountView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(252921);
              if (ContactCountView.d(ContactCountView.this) != null)
              {
                if (ContactCountView.b(ContactCountView.this) != 1) {
                  break label120;
                }
                ContactCountView.d(ContactCountView.this).setText(ContactCountView.this.getContext().getResources().getQuantityString(R.j.gpl, ContactCountView.c(ContactCountView.this), new Object[] { Integer.valueOf(ContactCountView.c(ContactCountView.this)) }));
              }
              for (;;)
              {
                ContactCountView.this.setVisible(ContactCountView.e(ContactCountView.this));
                AppMethodBeat.o(252921);
                return;
                label120:
                ContactCountView.d(ContactCountView.this).setText(ContactCountView.this.getContext().getResources().getQuantityString(R.j.gpk, ContactCountView.c(ContactCountView.this), new Object[] { Integer.valueOf(ContactCountView.c(ContactCountView.this)) }));
              }
            }
          });
          AppMethodBeat.o(253274);
          return;
          label124:
          localContactCountView = ContactCountView.this;
          bh.bCz();
          ContactCountView.a(localContactCountView, c.bzA().e(arrayOfString, new String[] { z.bAM(), "weixin", "helper_entry", "filehelper" }));
        }
      }
    });
    AppMethodBeat.o(37726);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37725);
    Log.d("MicroMsg.ContactCountView", "onMeasure");
    if (this.hDw == null)
    {
      this.hDw = ((FrameLayout)findViewById(R.h.fBH));
      this.JLz = ((TextView)findViewById(R.h.fBG));
    }
    jyf();
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(37725);
  }
  
  public void setContactType(int paramInt)
  {
    this.AAF = paramInt;
  }
  
  public void setFixedContactCount(int paramInt)
  {
    AppMethodBeat.i(180043);
    this.tzC = true;
    this.count = paramInt;
    jyf();
    AppMethodBeat.o(180043);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37727);
    this.visible = paramBoolean;
    View localView;
    if (this.hDw != null)
    {
      localView = this.hDw;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactCountView
 * JD-Core Version:    0.7.0.1
 */