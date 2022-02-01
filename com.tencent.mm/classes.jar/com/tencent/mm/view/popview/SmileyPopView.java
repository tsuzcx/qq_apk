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
import com.tencent.mm.ce.e;
import com.tencent.mm.emoji.a.b.a;
import com.tencent.mm.emoji.a.f;
import com.tencent.mm.emoji.a.f.a;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/popview/SmileyPopView;", "Lcom/tencent/mm/view/popview/AbstractPopView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animDrawable", "Lcom/tencent/mm/plugin/gif/MMWXGFDrawable;", "descView", "Landroid/widget/TextView;", "popBottomWidth", "popLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "preview", "Landroid/widget/ImageView;", "previewFrame", "Landroid/view/View;", "getWindowLayoutParams", "setSmileyItem", "", "item", "Lcom/tencent/mm/emoji/model/SmileyInfo;", "updateWindowLayoutParams", "anchor", "Companion", "plugin-emojisdk_release"})
public final class SmileyPopView
  extends AbstractPopView
{
  public static final SmileyPopView.a Rqy;
  private final WindowManager.LayoutParams Rqm;
  private View Rqv;
  private ImageView Rqw;
  private int Rqx;
  private com.tencent.mm.plugin.gif.h gVb;
  private TextView xVY;
  
  static
  {
    AppMethodBeat.i(200105);
    Rqy = new SmileyPopView.a((byte)0);
    AppMethodBeat.o(200105);
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
    AbstractPopView.inflate(paramContext, 2131493942, (ViewGroup)this);
    this.Rqv = findViewById(2131307960);
    this.Rqw = ((ImageView)findViewById(2131300025));
    this.xVY = ((TextView)findViewById(2131300024));
    this.Rqm = new WindowManager.LayoutParams(2, 264, 1);
    this.Rqx = getResources().getDimensionPixelOffset(2131166948);
    this.Rqm.width = paramContext.getResources().getDimensionPixelSize(2131166947);
    this.Rqm.height = paramContext.getResources().getDimensionPixelSize(2131166945);
    this.Rqm.gravity = 49;
    AppMethodBeat.o(105305);
  }
  
  public final WindowManager.LayoutParams getWindowLayoutParams()
  {
    return this.Rqm;
  }
  
  public final void hI(View paramView)
  {
    AppMethodBeat.i(105307);
    kotlin.g.b.p.h(paramView, "anchor");
    kO(paramView.getContext());
    paramView.setPressed(false);
    paramView.setSelected(false);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Resources localResources = getResources();
    kotlin.g.b.p.g(localResources, "resources");
    int i = localResources.getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    int k = (this.Rqm.width - this.Rqx) / 2;
    this.Rqm.y = (arrayOfInt[1] - this.Rqm.height + paramView.getMeasuredHeight() - this.Rqa);
    if (j < this.Rqm.width / 2)
    {
      paramView = this.Rqv;
      if (paramView == null) {
        kotlin.g.b.p.hyc();
      }
      paramView.setBackground(at.aN(getContext(), 2130968996));
      this.Rqm.x = (j + k - i / 2);
      AppMethodBeat.o(105307);
      return;
    }
    if (this.Rqm.width / 2 + j > i)
    {
      paramView = this.Rqv;
      if (paramView == null) {
        kotlin.g.b.p.hyc();
      }
      paramView.setBackground(at.aN(getContext(), 2130968997));
      this.Rqm.x = (j - k - i / 2);
      AppMethodBeat.o(105307);
      return;
    }
    paramView = this.Rqv;
    if (paramView == null) {
      kotlin.g.b.p.hyc();
    }
    paramView.setBackground(at.aN(getContext(), 2130968995));
    this.Rqm.x = (j - i / 2);
    AppMethodBeat.o(105307);
  }
  
  public final void setSmileyItem(com.tencent.mm.emoji.b.p paramp)
  {
    AppMethodBeat.i(105306);
    kotlin.g.b.p.h(paramp, "item");
    Object localObject1 = e.gxR().bie(paramp.key);
    Object localObject2 = com.tencent.mm.ce.b.gxI().bib((String)localObject1);
    Log.i("MicroMsg.SmileyPopView", "pop smiley %s, %s, %s", new Object[] { paramp.key, localObject1, localObject2 });
    kotlin.g.b.p.g(localObject2, "desc");
    int k = n.a((CharSequence)localObject2, "[", 0, false, 6);
    int j = n.a((CharSequence)localObject2, "]", 0, false, 6);
    int i = j;
    if (j == -1) {
      i = ((String)localObject2).length();
    }
    localObject1 = ((String)localObject2).substring(k + 1, i);
    kotlin.g.b.p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localObject2 = this.xVY;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = f.gVz;
    localObject2 = ((Iterable)f.auu().gUV).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = ((Iterator)localObject2).next();
    } while (!kotlin.g.b.p.j(((b.a)localObject1).key, paramp.key));
    for (;;)
    {
      localObject2 = (b.a)localObject1;
      Object localObject3;
      if (localObject2 == null)
      {
        localObject1 = null;
        localObject3 = this.gVb;
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.gif.h)localObject3).recycle();
        }
        this.gVb = null;
        if (!s.YS((String)localObject1)) {
          break;
        }
      }
      else
      {
        try
        {
          this.gVb = new com.tencent.mm.plugin.gif.h(s.aW((String)localObject1, 0, -1));
          paramp = this.Rqw;
          if (paramp != null) {
            paramp.setImageDrawable((Drawable)this.gVb);
          }
          paramp = this.gVb;
          if (paramp != null)
          {
            paramp.resume();
            AppMethodBeat.o(105306);
            return;
            localObject1 = null;
            continue;
            localObject1 = new StringBuilder();
            localObject3 = a.hdT;
            localObject1 = a.aww() + ((b.a)localObject2).gUW;
          }
        }
        catch (Exception paramp)
        {
          for (;;)
          {
            if ((paramp instanceof MMGIFException)) {
              com.tencent.mm.plugin.report.service.h.CyF.dN(711, 22);
            }
          }
          AppMethodBeat.o(105306);
          return;
        }
      }
    }
    localObject1 = this.Rqw;
    if (localObject1 != null)
    {
      e.gxR();
      ((ImageView)localObject1).setImageDrawable(e.bid(paramp.key));
    }
    paramp = new StringBuilder("setSmileyItem: ").append(paramp.key).append(", ");
    localObject1 = f.gVz;
    Log.i("MicroMsg.SmileyPopView", f.auu().gUV.size());
    if (localObject2 != null)
    {
      paramp = f.gVz;
      f.a.auz();
    }
    AppMethodBeat.o(105306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.popview.SmileyPopView
 * JD-Core Version:    0.7.0.1
 */