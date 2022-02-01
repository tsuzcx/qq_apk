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
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.lang.ref.WeakReference;

public class CategoryTipView
  extends RelativeLayout
  implements c
{
  private long Dqp;
  private TextView PUg;
  private int mStatus;
  private String vPa;
  
  public CategoryTipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37670);
    this.PUg = null;
    this.mStatus = 0;
    this.Dqp = 0L;
    this.vPa = "";
    init();
    AppMethodBeat.o(37670);
  }
  
  public CategoryTipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(37671);
    this.PUg = null;
    this.mStatus = 0;
    this.Dqp = 0L;
    this.vPa = "";
    init();
    AppMethodBeat.o(37671);
  }
  
  private boolean gUv()
  {
    AppMethodBeat.i(37675);
    Object localObject = getTag();
    if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 32)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.CategoryTipView", "%s isFavourHeader=%s", new Object[] { this, Boolean.valueOf(bool) });
      AppMethodBeat.o(37675);
      return bool;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(37673);
    LayoutInflater.from(getContext()).inflate(2131492981, this, true);
    this.PUg = ((TextView)findViewById(2131299165));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37668);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/CategoryTipView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (Util.ticksToNow(CategoryTipView.a(CategoryTipView.this)) < 1000L)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/CategoryTipView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37668);
          return;
        }
        CategoryTipView.a(CategoryTipView.this, Util.currentTicks());
        if (CategoryTipView.b(CategoryTipView.this))
        {
          paramAnonymousView = com.tencent.mm.plugin.story.h.h.FuH;
          com.tencent.mm.plugin.story.h.h.fqi().wU(CategoryTipView.c(CategoryTipView.this));
          paramAnonymousView = com.tencent.mm.plugin.story.h.h.FuH;
          com.tencent.mm.plugin.story.h.h.fqi().eQv = 6L;
          o.a(CategoryTipView.this.getContext(), ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().fnc(), null, null);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/CategoryTipView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37668);
      }
    });
    ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().h(new WeakReference(this));
    AppMethodBeat.o(37673);
  }
  
  public final void aaD(final int paramInt)
  {
    AppMethodBeat.i(37676);
    Log.d("MicroMsg.CategoryTipView", "%s mStatus=%s newStatus=%s", new Object[] { this, Integer.valueOf(this.mStatus), Integer.valueOf(paramInt) });
    if ((getVisibility() == 0) && (gUv()) && (this.mStatus != paramInt)) {
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
  
  public final void anG(int paramInt)
  {
    AppMethodBeat.i(37674);
    this.mStatus = paramInt;
    if (gUv())
    {
      int i = com.tencent.mm.n.h.aqJ().getInt("StoryShouldShowEntraceInFavorFriend", 1);
      Drawable localDrawable;
      if ((i == 1) && ((paramInt & 0x1) != 0))
      {
        Log.i("MicroMsg.CategoryTipView", "%s showStoryCategory has new story %s", new Object[] { this, Integer.valueOf(i) });
        setVisibility(0);
        this.PUg.setVisibility(0);
        localDrawable = getContext().getResources().getDrawable(2131690455);
        localDrawable.setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(getContext(), 20));
        this.PUg.setCompoundDrawables(null, null, localDrawable, null);
        this.PUg.invalidate();
        AppMethodBeat.o(37674);
        return;
      }
      if ((i == 1) && ((paramInt & 0x2) != 0))
      {
        Log.i("MicroMsg.CategoryTipView", "%s showStoryCategory has story %s", new Object[] { this, Integer.valueOf(i) });
        setVisibility(0);
        this.PUg.setVisibility(0);
        localDrawable = ar.m(getContext(), 2131690859, getContext().getResources().getColor(2131100044));
        localDrawable.setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(getContext(), 20));
        this.PUg.setCompoundDrawables(null, null, localDrawable, null);
        this.PUg.invalidate();
        AppMethodBeat.o(37674);
        return;
      }
      setVisibility(8);
      this.PUg.setVisibility(8);
      AppMethodBeat.o(37674);
      return;
    }
    setVisibility(8);
    this.PUg.setVisibility(8);
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
      Log.d("MicroMsg.CategoryTipView", "visibility == View.VISIBLE : %s", new Object[] { Boolean.valueOf(bool) });
      if (paramInt == 0) {
        this.vPa = com.tencent.mm.ui.e.avA("6");
      }
      AppMethodBeat.o(37672);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.CategoryTipView
 * JD-Core Version:    0.7.0.1
 */