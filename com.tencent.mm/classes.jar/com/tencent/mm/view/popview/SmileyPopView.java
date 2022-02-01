package com.tencent.mm.view.popview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.b.a;
import com.tencent.mm.emoji.a.f.a;
import com.tencent.mm.emoji.b.q;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/popview/SmileyPopView;", "Lcom/tencent/mm/view/popview/AbstractPopView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animDrawable", "Lcom/tencent/mm/plugin/gif/MMWXGFDrawable;", "descView", "Landroid/widget/TextView;", "popBottomWidth", "popLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "preview", "Landroid/widget/ImageView;", "previewFrame", "Landroid/view/View;", "getWindowLayoutParams", "onWindowFocusChanged", "", "hasWindowFocus", "", "setSmileyItem", "item", "Lcom/tencent/mm/emoji/model/SmileyInfo;", "updateWindowLayoutParams", "anchor", "Companion", "plugin-emojisdk_release"})
public final class SmileyPopView
  extends AbstractPopView
{
  public static final SmileyPopView.a YRW;
  private final WindowManager.LayoutParams YRK;
  private View YRT;
  private ImageView YRU;
  private int YRV;
  private com.tencent.mm.plugin.gif.h jFU;
  private TextView zQG;
  
  static
  {
    AppMethodBeat.i(231706);
    YRW = new SmileyPopView.a((byte)0);
    AppMethodBeat.o(231706);
  }
  
  public SmileyPopView(Context paramContext)
  {
    this(paramContext, null, 6, (byte)0);
  }
  
  public SmileyPopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
  }
  
  public SmileyPopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(105305);
    AbstractPopView.inflate(paramContext, a.h.emoji_pop_smiley_view, (ViewGroup)this);
    this.YRT = findViewById(a.g.smiley_pop_frame);
    this.YRU = ((ImageView)findViewById(a.g.emoji_pop_image));
    this.zQG = ((TextView)findViewById(a.g.emoji_pop_desc));
    this.YRK = new WindowManager.LayoutParams(2, 264, 1);
    this.YRV = getResources().getDimensionPixelOffset(a.e.smiley_pop_frame_width_bottom);
    this.YRK.width = paramContext.getResources().getDimensionPixelSize(a.e.smiley_pop_frame_width);
    this.YRK.height = paramContext.getResources().getDimensionPixelSize(a.e.smiley_pop_frame_height);
    this.YRK.gravity = 49;
    AppMethodBeat.o(105305);
  }
  
  public final WindowManager.LayoutParams getWindowLayoutParams()
  {
    return this.YRK;
  }
  
  public final void jd(View paramView)
  {
    AppMethodBeat.i(105307);
    p.k(paramView, "anchor");
    lK(paramView.getContext());
    paramView.setPressed(false);
    paramView.setSelected(false);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Resources localResources = getResources();
    p.j(localResources, "resources");
    int i = localResources.getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    int k = (this.YRK.width - this.YRV) / 2;
    this.YRK.y = (arrayOfInt[1] - this.YRK.height + paramView.getMeasuredHeight() - this.YRy);
    if (j < this.YRK.width / 2)
    {
      paramView = this.YRT;
      if (paramView == null) {
        p.iCn();
      }
      paramView.setBackground(aw.bf(getContext(), a.c.emoji_pop_bg_smiley_left));
      this.YRK.x = (j + k - i / 2);
      AppMethodBeat.o(105307);
      return;
    }
    if (this.YRK.width / 2 + j > i)
    {
      paramView = this.YRT;
      if (paramView == null) {
        p.iCn();
      }
      paramView.setBackground(aw.bf(getContext(), a.c.emoji_pop_bg_smiley_right));
      this.YRK.x = (j - k - i / 2);
      AppMethodBeat.o(105307);
      return;
    }
    paramView = this.YRT;
    if (paramView == null) {
      p.iCn();
    }
    paramView.setBackground(aw.bf(getContext(), a.c.emoji_pop_bg_smiley));
    this.YRK.x = (j - i / 2);
    AppMethodBeat.o(105307);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(231695);
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean) {
      dismiss();
    }
    AppMethodBeat.o(231695);
  }
  
  public final void setSmileyItem(q paramq)
  {
    AppMethodBeat.i(105306);
    p.k(paramq, "item");
    Object localObject1 = com.tencent.mm.cl.f.htQ().buw(paramq.key);
    Object localObject2 = com.tencent.mm.cl.b.htF().buu((String)localObject1);
    Log.i("MicroMsg.SmileyPopView", "pop smiley %s, %s, %s", new Object[] { paramq.key, localObject1, localObject2 });
    p.j(localObject2, "desc");
    int k = n.a((CharSequence)localObject2, "[", 0, false, 6);
    int j = n.a((CharSequence)localObject2, "]", 0, false, 6);
    int i = j;
    if (j == -1) {
      i = ((String)localObject2).length();
    }
    localObject1 = ((String)localObject2).substring(k + 1, i);
    p.j(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localObject2 = this.zQG;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = com.tencent.mm.emoji.a.f.jGv;
    localObject2 = ((Iterable)com.tencent.mm.emoji.a.f.aBp().jFL).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = ((Iterator)localObject2).next();
    } while (!p.h(((b.a)localObject1).key, paramq.key));
    for (;;)
    {
      localObject2 = (b.a)localObject1;
      Object localObject3;
      if (localObject2 == null)
      {
        localObject1 = null;
        localObject3 = this.jFU;
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.gif.h)localObject3).recycle();
        }
        this.jFU = null;
        if (!u.agG((String)localObject1)) {
          break;
        }
      }
      else
      {
        try
        {
          this.jFU = new com.tencent.mm.plugin.gif.h(u.aY((String)localObject1, 0, -1));
          paramq = this.YRU;
          if (paramq != null) {
            paramq.setImageDrawable((Drawable)this.jFU);
          }
          paramq = this.jFU;
          if (paramq != null)
          {
            paramq.resume();
            AppMethodBeat.o(105306);
            return;
            localObject1 = null;
            continue;
            localObject1 = new StringBuilder();
            localObject3 = a.jPz;
            localObject1 = a.aDE() + ((b.a)localObject2).jFM;
          }
        }
        catch (Exception paramq)
        {
          for (;;)
          {
            if ((paramq instanceof MMGIFException)) {
              com.tencent.mm.plugin.report.service.h.IzE.el(711, 22);
            }
          }
          AppMethodBeat.o(105306);
          return;
        }
      }
    }
    localObject1 = this.YRU;
    if (localObject1 != null)
    {
      com.tencent.mm.cl.f.htQ();
      ((ImageView)localObject1).setImageDrawable(com.tencent.mm.cl.f.buv(paramq.key));
    }
    paramq = new StringBuilder("setSmileyItem: ").append(paramq.key).append(", ");
    localObject1 = com.tencent.mm.emoji.a.f.jGv;
    Log.i("MicroMsg.SmileyPopView", com.tencent.mm.emoji.a.f.aBp().jFL.size());
    if (localObject2 != null)
    {
      paramq = com.tencent.mm.emoji.a.f.jGv;
      f.a.aBu();
    }
    AppMethodBeat.o(105306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.popview.SmileyPopView
 * JD-Core Version:    0.7.0.1
 */