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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.autogen.mmdata.rpt.ox;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bb;
import java.lang.ref.WeakReference;

public class CategoryTipView
  extends RelativeLayout
  implements c
{
  private String FUP;
  private long JqZ;
  private TextView afcs;
  private int mStatus;
  
  public CategoryTipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37670);
    this.afcs = null;
    this.mStatus = 0;
    this.JqZ = 0L;
    this.FUP = "";
    init();
    AppMethodBeat.o(37670);
  }
  
  public CategoryTipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(37671);
    this.afcs = null;
    this.mStatus = 0;
    this.JqZ = 0L;
    this.FUP = "";
    init();
    AppMethodBeat.o(37671);
  }
  
  private void init()
  {
    AppMethodBeat.i(37673);
    LayoutInflater.from(getContext()).inflate(R.i.gdW, this, true);
    this.afcs = ((TextView)findViewById(R.h.fDo));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37668);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/CategoryTipView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (Util.ticksToNow(CategoryTipView.a(CategoryTipView.this)) < 1000L)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/CategoryTipView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37668);
          return;
        }
        CategoryTipView.a(CategoryTipView.this, Util.currentTicks());
        if (CategoryTipView.b(CategoryTipView.this))
        {
          paramAnonymousView = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hxW().wA(CategoryTipView.c(CategoryTipView.this));
          paramAnonymousView = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hxW().jjn = 6L;
          o.a(CategoryTipView.this.getContext(), ((e)com.tencent.mm.kernel.h.az(e.class)).getFavourUserChecker().huO(), null, null);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/CategoryTipView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37668);
      }
    });
    ((e)com.tencent.mm.kernel.h.az(e.class)).getFavourUserChecker().i(new WeakReference(this));
    AppMethodBeat.o(37673);
  }
  
  private boolean jye()
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
  
  public final void aDs(int paramInt)
  {
    AppMethodBeat.i(37674);
    this.mStatus = paramInt;
    if (jye())
    {
      int i = i.aRC().getInt("StoryShouldShowEntraceInFavorFriend", 1);
      Drawable localDrawable;
      if ((i == 1) && ((paramInt & 0x1) != 0))
      {
        Log.i("MicroMsg.CategoryTipView", "%s showStoryCategory has new story %s", new Object[] { this, Integer.valueOf(i) });
        setVisibility(0);
        this.afcs.setVisibility(0);
        localDrawable = getContext().getResources().getDrawable(R.k.icon_outlined_one_day_video_blue);
        localDrawable.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 20), com.tencent.mm.cd.a.fromDPToPix(getContext(), 20));
        this.afcs.setCompoundDrawables(null, null, localDrawable, null);
        this.afcs.invalidate();
        AppMethodBeat.o(37674);
        return;
      }
      if ((i == 1) && ((paramInt & 0x2) != 0))
      {
        Log.i("MicroMsg.CategoryTipView", "%s showStoryCategory has story %s", new Object[] { this, Integer.valueOf(i) });
        setVisibility(0);
        this.afcs.setVisibility(0);
        localDrawable = bb.m(getContext(), R.k.icons_outlined_one_day_video, getContext().getResources().getColor(R.e.black_color));
        localDrawable.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 20), com.tencent.mm.cd.a.fromDPToPix(getContext(), 20));
        this.afcs.setCompoundDrawables(null, null, localDrawable, null);
        this.afcs.invalidate();
        AppMethodBeat.o(37674);
        return;
      }
      setVisibility(8);
      this.afcs.setVisibility(8);
      AppMethodBeat.o(37674);
      return;
    }
    setVisibility(8);
    this.afcs.setVisibility(8);
    AppMethodBeat.o(37674);
  }
  
  public final void amZ(final int paramInt)
  {
    AppMethodBeat.i(37676);
    Log.d("MicroMsg.CategoryTipView", "%s mStatus=%s newStatus=%s", new Object[] { this, Integer.valueOf(this.mStatus), Integer.valueOf(paramInt) });
    if ((getVisibility() == 0) && (jye()) && (this.mStatus != paramInt)) {
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
        this.FUP = com.tencent.mm.ui.f.bjC("6");
      }
      AppMethodBeat.o(37672);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.CategoryTipView
 * JD-Core Version:    0.7.0.1
 */