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
import com.tencent.mm.emoji.a.b;
import com.tencent.mm.emoji.a.b.a;
import com.tencent.mm.emoji.a.f;
import com.tencent.mm.emoji.a.f.a;
import com.tencent.mm.emoji.c.q;
import com.tencent.mm.emoji.f.c;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.smiley.EmojiHelper;
import com.tencent.mm.smiley.o;
import com.tencent.mm.ui.bd;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/popview/SmileyPopView;", "Lcom/tencent/mm/view/popview/AbstractPopView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animDrawable", "Lcom/tencent/mm/plugin/gif/MMWXGFDrawable;", "descView", "Landroid/widget/TextView;", "popBottomWidth", "popLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "preview", "Landroid/widget/ImageView;", "previewFrame", "Landroid/view/View;", "getWindowLayoutParams", "onWindowFocusChanged", "", "hasWindowFocus", "", "setSmileyItem", "item", "Lcom/tencent/mm/emoji/model/SmileyInfo;", "updateWindowLayoutParams", "anchor", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SmileyPopView
  extends AbstractPopView
{
  public static final SmileyPopView.a agNx;
  private TextView FcR;
  private int agNA;
  private final WindowManager.LayoutParams agNo;
  private View agNy;
  private ImageView agNz;
  private com.tencent.mm.plugin.gif.h mfI;
  
  static
  {
    AppMethodBeat.i(235077);
    agNx = new SmileyPopView.a((byte)0);
    AppMethodBeat.o(235077);
  }
  
  public SmileyPopView(Context paramContext)
  {
    this(paramContext, null, 6, (byte)0);
    AppMethodBeat.i(235069);
    AppMethodBeat.o(235069);
  }
  
  public SmileyPopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
    AppMethodBeat.i(235066);
    AppMethodBeat.o(235066);
  }
  
  public SmileyPopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(105305);
    AbstractPopView.inflate(paramContext, a.h.emoji_pop_smiley_view, (ViewGroup)this);
    this.agNy = findViewById(a.g.smiley_pop_frame);
    this.agNz = ((ImageView)findViewById(a.g.emoji_pop_image));
    this.FcR = ((TextView)findViewById(a.g.emoji_pop_desc));
    this.agNo = new WindowManager.LayoutParams(2, 264, 1);
    this.agNA = getResources().getDimensionPixelOffset(a.e.smiley_pop_frame_width_bottom);
    this.agNo.width = paramContext.getResources().getDimensionPixelSize(a.e.smiley_pop_frame_width);
    this.agNo.height = paramContext.getResources().getDimensionPixelSize(a.e.smiley_pop_frame_height);
    this.agNo.gravity = 49;
    AppMethodBeat.o(105305);
  }
  
  public final WindowManager.LayoutParams getWindowLayoutParams()
  {
    return this.agNo;
  }
  
  public final void mB(View paramView)
  {
    AppMethodBeat.i(105307);
    s.u(paramView, "anchor");
    nO(paramView.getContext());
    paramView.setPressed(false);
    paramView.setSelected(false);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    int k = (this.agNo.width - this.agNA) / 2;
    this.agNo.y = (arrayOfInt[1] - this.agNo.height + paramView.getMeasuredHeight() - this.agNe);
    if (j < this.agNo.width / 2)
    {
      paramView = this.agNy;
      s.checkNotNull(paramView);
      paramView.setBackground(bd.by(getContext(), a.c.emoji_pop_bg_smiley_left));
      this.agNo.x = (j + k - i / 2);
      AppMethodBeat.o(105307);
      return;
    }
    if (this.agNo.width / 2 + j > i)
    {
      paramView = this.agNy;
      s.checkNotNull(paramView);
      paramView.setBackground(bd.by(getContext(), a.c.emoji_pop_bg_smiley_right));
      this.agNo.x = (j - k - i / 2);
      AppMethodBeat.o(105307);
      return;
    }
    paramView = this.agNy;
    s.checkNotNull(paramView);
    paramView.setBackground(bd.by(getContext(), a.c.emoji_pop_bg_smiley));
    this.agNo.x = (j - i / 2);
    AppMethodBeat.o(105307);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(235093);
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean) {
      dismiss();
    }
    AppMethodBeat.o(235093);
  }
  
  public final void setSmileyItem(q paramq)
  {
    AppMethodBeat.i(105306);
    s.u(paramq, "item");
    Object localObject1 = o.iVl().buD(paramq.key);
    EmojiHelper.iUM();
    Object localObject2 = EmojiHelper.buv((String)localObject1);
    Log.i("MicroMsg.SmileyPopView", "pop smiley %s, %s, %s", new Object[] { paramq.key, localObject1, localObject2 });
    s.s(localObject2, "desc");
    int k = n.a((CharSequence)localObject2, "[", 0, false, 6);
    s.s(localObject2, "desc");
    int j = n.a((CharSequence)localObject2, "]", 0, false, 6);
    int i = j;
    if (j == -1) {
      i = ((String)localObject2).length();
    }
    s.s(localObject2, "desc");
    localObject1 = ((String)localObject2).substring(k + 1, i);
    s.s(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localObject2 = this.FcR;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = f.mfZ;
    localObject2 = ((Iterable)f.aUn().mfy).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = ((Iterator)localObject2).next();
    } while (!s.p(((b.a)localObject1).key, paramq.key));
    for (;;)
    {
      localObject2 = (b.a)localObject1;
      if (localObject2 == null)
      {
        localObject1 = null;
        com.tencent.mm.plugin.gif.h localh = this.mfI;
        if (localh != null) {
          localh.recycle();
        }
        this.mfI = null;
        if (!y.ZC((String)localObject1)) {}
      }
      else
      {
        try
        {
          this.mfI = new com.tencent.mm.plugin.gif.h(y.bi((String)localObject1, 0, -1));
          paramq = this.agNz;
          if (paramq != null) {
            paramq.setImageDrawable((Drawable)this.mfI);
          }
          paramq = this.mfI;
          if (paramq == null) {
            break label476;
          }
          paramq.resume();
          AppMethodBeat.o(105306);
          return;
          localObject1 = null;
          continue;
          localObject1 = c.moq;
          localObject1 = s.X(c.aWD(), ((b.a)localObject2).mfz);
        }
        catch (Exception paramq)
        {
          for (;;)
          {
            if ((paramq instanceof MMGIFException)) {
              com.tencent.mm.plugin.report.service.h.OAn.kJ(711, 22);
            }
          }
        }
      }
    }
    localObject1 = this.agNz;
    if (localObject1 != null)
    {
      o.iVl();
      ((ImageView)localObject1).setImageDrawable(o.buC(paramq.key));
    }
    paramq = new StringBuilder("setSmileyItem: ").append(paramq.key).append(", ");
    localObject1 = f.mfZ;
    Log.i("MicroMsg.SmileyPopView", f.aUn().mfy.size());
    if (localObject2 != null)
    {
      paramq = f.mfZ;
      f.a.aUs();
    }
    label476:
    AppMethodBeat.o(105306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.popview.SmileyPopView
 * JD-Core Version:    0.7.0.1
 */