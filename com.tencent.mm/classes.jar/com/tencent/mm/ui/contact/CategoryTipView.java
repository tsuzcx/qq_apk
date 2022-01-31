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
import com.tencent.mm.cb.a;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.plugin.story.api.b;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

public class CategoryTipView
  extends RelativeLayout
  implements c
{
  private TextView Abz;
  private int mStatus;
  private String oFX;
  private long qWP;
  
  public CategoryTipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33551);
    this.Abz = null;
    this.mStatus = 0;
    this.qWP = 0L;
    this.oFX = "";
    init();
    AppMethodBeat.o(33551);
  }
  
  public CategoryTipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33552);
    this.Abz = null;
    this.mStatus = 0;
    this.qWP = 0L;
    this.oFX = "";
    init();
    AppMethodBeat.o(33552);
  }
  
  private boolean dLI()
  {
    AppMethodBeat.i(33556);
    Object localObject = getTag();
    if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 32)) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.CategoryTipView", "%s isFavourHeader=%s", new Object[] { this, Boolean.valueOf(bool) });
      AppMethodBeat.o(33556);
      return bool;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(33554);
    LayoutInflater.from(getContext()).inflate(2130968640, this, true);
    this.Abz = ((TextView)findViewById(2131821083));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33549);
        if (bo.av(CategoryTipView.a(CategoryTipView.this)) < 1000L)
        {
          AppMethodBeat.o(33549);
          return;
        }
        CategoryTipView.a(CategoryTipView.this, bo.yB());
        if (CategoryTipView.b(CategoryTipView.this))
        {
          paramAnonymousView = i.sFa;
          i.cDo().gp(CategoryTipView.c(CategoryTipView.this));
          paramAnonymousView = i.sFa;
          i.cDo().cVa = 6L;
          n.a(CategoryTipView.this.getContext(), ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().czp(), null, null);
        }
        AppMethodBeat.o(33549);
      }
    });
    ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().b(new WeakReference(this));
    AppMethodBeat.o(33554);
  }
  
  public final void FA(final int paramInt)
  {
    AppMethodBeat.i(33557);
    ab.d("MicroMsg.CategoryTipView", "%s mStatus=%s newStatus=%s", new Object[] { this, Integer.valueOf(this.mStatus), Integer.valueOf(paramInt) });
    if ((getVisibility() == 0) && (dLI()) && (this.mStatus != paramInt)) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33550);
          CategoryTipView.a(CategoryTipView.this, paramInt);
          AppMethodBeat.o(33550);
        }
      });
    }
    AppMethodBeat.o(33557);
  }
  
  public final void Qs(int paramInt)
  {
    AppMethodBeat.i(33555);
    this.mStatus = paramInt;
    if (dLI())
    {
      int i = com.tencent.mm.m.g.Nq().getInt("StoryShouldShowEntraceInFavorFriend", 1);
      Drawable localDrawable;
      if ((i == 1) && ((paramInt & 0x1) != 0))
      {
        ab.i("MicroMsg.CategoryTipView", "%s showStoryCategory has new story %s", new Object[] { this, Integer.valueOf(i) });
        setVisibility(0);
        this.Abz.setVisibility(0);
        localDrawable = getContext().getResources().getDrawable(2131231428);
        localDrawable.setBounds(0, 0, a.fromDPToPix(getContext(), 20), a.fromDPToPix(getContext(), 20));
        this.Abz.setCompoundDrawables(null, null, localDrawable, null);
        this.Abz.invalidate();
        AppMethodBeat.o(33555);
        return;
      }
      if ((i == 1) && ((paramInt & 0x2) != 0))
      {
        ab.i("MicroMsg.CategoryTipView", "%s showStoryCategory has story %s", new Object[] { this, Integer.valueOf(i) });
        setVisibility(0);
        this.Abz.setVisibility(0);
        localDrawable = getContext().getResources().getDrawable(2131231525);
        localDrawable.setBounds(0, 0, a.fromDPToPix(getContext(), 20), a.fromDPToPix(getContext(), 20));
        this.Abz.setCompoundDrawables(null, null, localDrawable, null);
        this.Abz.invalidate();
        AppMethodBeat.o(33555);
        return;
      }
      setVisibility(8);
      this.Abz.setVisibility(8);
      AppMethodBeat.o(33555);
      return;
    }
    setVisibility(8);
    this.Abz.setVisibility(8);
    AppMethodBeat.o(33555);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(33553);
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {}
    for (;;)
    {
      ab.d("MicroMsg.CategoryTipView", "visibility == View.VISIBLE : %s", new Object[] { Boolean.valueOf(bool) });
      if (paramInt == 0) {
        this.oFX = com.tencent.mm.ui.e.atl("6");
      }
      AppMethodBeat.o(33553);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.CategoryTipView
 * JD-Core Version:    0.7.0.1
 */