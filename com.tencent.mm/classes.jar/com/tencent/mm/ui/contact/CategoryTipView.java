package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.plugin.story.api.b;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.am;
import java.lang.ref.WeakReference;

public class CategoryTipView
  extends RelativeLayout
  implements c
{
  private TextView Iuh;
  private int mStatus;
  private String uJD;
  private long xGD;
  
  public CategoryTipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37670);
    this.Iuh = null;
    this.mStatus = 0;
    this.xGD = 0L;
    this.uJD = "";
    init();
    AppMethodBeat.o(37670);
  }
  
  public CategoryTipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(37671);
    this.Iuh = null;
    this.mStatus = 0;
    this.xGD = 0L;
    this.uJD = "";
    init();
    AppMethodBeat.o(37671);
  }
  
  private boolean fqW()
  {
    AppMethodBeat.i(37675);
    Object localObject = getTag();
    if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 32)) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.CategoryTipView", "%s isFavourHeader=%s", new Object[] { this, Boolean.valueOf(bool) });
      AppMethodBeat.o(37675);
      return bool;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(37673);
    LayoutInflater.from(getContext()).inflate(2131492948, this, true);
    this.Iuh = ((TextView)findViewById(2131298727));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37668);
        if (bs.aO(CategoryTipView.a(CategoryTipView.this)) < 1000L)
        {
          AppMethodBeat.o(37668);
          return;
        }
        CategoryTipView.a(CategoryTipView.this, bs.Gn());
        if (CategoryTipView.b(CategoryTipView.this))
        {
          paramAnonymousView = h.zAU;
          h.dXK().mD(CategoryTipView.c(CategoryTipView.this));
          paramAnonymousView = h.zAU;
          h.dXK().dUP = 6L;
          o.a(CategoryTipView.this.getContext(), ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().dUF(), null, null);
        }
        AppMethodBeat.o(37668);
      }
    });
    ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().c(new WeakReference(this));
    AppMethodBeat.o(37673);
  }
  
  public final void Qr(final int paramInt)
  {
    AppMethodBeat.i(37676);
    ac.d("MicroMsg.CategoryTipView", "%s mStatus=%s newStatus=%s", new Object[] { this, Integer.valueOf(this.mStatus), Integer.valueOf(paramInt) });
    if ((getVisibility() == 0) && (fqW()) && (this.mStatus != paramInt)) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37669);
          CategoryTipView.a(CategoryTipView.this, paramInt);
          AppMethodBeat.o(37669);
        }
      });
    }
    AppMethodBeat.o(37676);
  }
  
  public final void abP(int paramInt)
  {
    AppMethodBeat.i(37674);
    this.mStatus = paramInt;
    if (fqW())
    {
      int i = com.tencent.mm.m.g.ZY().getInt("StoryShouldShowEntraceInFavorFriend", 1);
      Drawable localDrawable;
      if ((i == 1) && ((paramInt & 0x1) != 0))
      {
        ac.i("MicroMsg.CategoryTipView", "%s showStoryCategory has new story %s", new Object[] { this, Integer.valueOf(i) });
        setVisibility(0);
        this.Iuh.setVisibility(0);
        localDrawable = getContext().getResources().getDrawable(2131690332);
        localDrawable.setBounds(0, 0, a.fromDPToPix(getContext(), 20), a.fromDPToPix(getContext(), 20));
        this.Iuh.setCompoundDrawables(null, null, localDrawable, null);
        this.Iuh.invalidate();
        AppMethodBeat.o(37674);
        return;
      }
      if ((i == 1) && ((paramInt & 0x2) != 0))
      {
        ac.i("MicroMsg.CategoryTipView", "%s showStoryCategory has story %s", new Object[] { this, Integer.valueOf(i) });
        setVisibility(0);
        this.Iuh.setVisibility(0);
        localDrawable = am.k(getContext(), 2131690614, getContext().getResources().getColor(2131100018));
        localDrawable.setBounds(0, 0, a.fromDPToPix(getContext(), 20), a.fromDPToPix(getContext(), 20));
        this.Iuh.setCompoundDrawables(null, null, localDrawable, null);
        this.Iuh.invalidate();
        AppMethodBeat.o(37674);
        return;
      }
      setVisibility(8);
      this.Iuh.setVisibility(8);
      AppMethodBeat.o(37674);
      return;
    }
    setVisibility(8);
    this.Iuh.setVisibility(8);
    AppMethodBeat.o(37674);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(37672);
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {}
    for (;;)
    {
      ac.d("MicroMsg.CategoryTipView", "visibility == View.VISIBLE : %s", new Object[] { Boolean.valueOf(bool) });
      if (paramInt == 0) {
        this.uJD = com.tencent.mm.ui.e.aPv("6");
      }
      AppMethodBeat.o(37672);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.CategoryTipView
 * JD-Core Version:    0.7.0.1
 */