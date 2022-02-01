package com.tencent.mm.sticker.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.d;
import com.tencent.mm.sticker.e;
import com.tencent.mm.sticker.e.a;
import com.tencent.mm.sticker.f;
import com.tencent.mm.ui.f.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "actionIndex", "actions", "Ljava/util/LinkedList;", "hintIcon", "Landroid/widget/ImageView;", "hintText", "Landroid/widget/TextView;", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "switchStickerHintRunnable", "Ljava/lang/Runnable;", "hideStickerHint", "", "onFinishInflate", "setStickerPack", "showStickerHint", "switchHint", "Companion", "plugin-sticker_release"})
public final class CaptureStickerHint
  extends LinearLayout
{
  private static final SparseArray<int[]> NOG;
  private static final SparseArray<int[]> NOH;
  public static final CaptureStickerHint.a NOI;
  private final ImageView NOD;
  private int NOE;
  private final Runnable NOF;
  private final String TAG;
  private LinkedList<Integer> mRG;
  private f rpM;
  private final TextView vuT;
  
  static
  {
    AppMethodBeat.i(194241);
    NOI = new CaptureStickerHint.a((byte)0);
    NOG = new SparseArray();
    NOH = new SparseArray();
    SparseArray localSparseArray = NOG;
    e.a locala = e.NNq;
    localSparseArray.put(e.gyC(), new int[] { 2131235068, 2131235069 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyD(), new int[] { 2131235066, 2131235067 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyE(), new int[] { 2131235064, 2131235065 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyF(), new int[] { 2131235070, 2131235071 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyG(), new int[] { 2131235056, 2131235057 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyH(), new int[] { 2131235058, 2131235059 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyI(), new int[] { 2131235062, 2131235063 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyJ(), new int[] { 2131235060, 2131235061 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyK(), new int[] { 2131235078, 2131235079 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyL(), new int[] { 2131235088, 2131235089 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyM(), new int[] { 2131235092, 2131235093 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyN(), new int[] { 2131235074, 2131235075 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyO(), new int[] { 2131235086, 2131235087 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyP(), new int[] { 2131235082, 2131235083 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyQ(), new int[] { 2131235080, 2131235081 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyR(), new int[] { 2131235084, 2131235085 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyS(), new int[] { 2131235090, 2131235091 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyT(), new int[] { 2131235094, 2131235095 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyU(), new int[] { 2131235072, 2131235073 });
    localSparseArray = NOG;
    locala = e.NNq;
    localSparseArray.put(e.gyV(), new int[] { 2131235076, 2131235077 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyC(), new int[] { 2131766418, 2131766419 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyD(), new int[] { 2131766416, 2131766417 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyE(), new int[] { 2131766414, 2131766415 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyF(), new int[] { 2131766420, 2131766421 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyG(), new int[] { 2131766406, 2131766407 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyH(), new int[] { 2131766408, 2131766409 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyI(), new int[] { 2131766412, 2131766413 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyJ(), new int[] { 2131766410, 2131766411 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyK(), new int[] { 2131766428, 2131766429 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyL(), new int[] { 2131766438, 2131766439 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyM(), new int[] { 2131766442, 2131766443 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyN(), new int[] { 2131766424, 2131766425 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyO(), new int[] { 2131766436, 2131766437 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyP(), new int[] { 2131766432, 2131766433 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyQ(), new int[] { 2131766430, 2131766431 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyR(), new int[] { 2131766434, 2131766435 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyS(), new int[] { 2131766440, 2131766441 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyT(), new int[] { 2131766444, 2131766445 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyU(), new int[] { 2131766422, 2131766423 });
    localSparseArray = NOH;
    locala = e.NNq;
    localSparseArray.put(e.gyV(), new int[] { 2131766426, 2131766427 });
    AppMethodBeat.o(194241);
  }
  
  public CaptureStickerHint(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(194240);
    AppMethodBeat.o(194240);
  }
  
  public CaptureStickerHint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194239);
    this.TAG = "MicroMsg.CaptureStickerHint";
    this.mRG = new LinkedList();
    this.NOF = ((Runnable)new b(this));
    View.inflate(paramContext, 2131496547, (ViewGroup)this);
    paramContext = findViewById(2131308435);
    p.g(paramContext, "findViewById(R.id.sticker_preview_hint_icon)");
    this.NOD = ((ImageView)paramContext);
    paramContext = findViewById(2131308436);
    p.g(paramContext, "findViewById(R.id.sticker_preview_hint_text)");
    this.vuT = ((TextView)paramContext);
    AppMethodBeat.o(194239);
  }
  
  private void gzw()
  {
    AppMethodBeat.i(194238);
    this.NOD.setImageDrawable(null);
    setVisibility(8);
    AppMethodBeat.o(194238);
  }
  
  public final void gzv()
  {
    int i = 0;
    AppMethodBeat.i(194237);
    if (this.NOE >= this.mRG.size())
    {
      gzw();
      AppMethodBeat.o(194237);
      return;
    }
    setVisibility(0);
    Object localObject1 = NOH;
    Object localObject2 = this.mRG.get(this.NOE);
    p.g(localObject2, "actions[actionIndex]");
    localObject1 = (int[])((SparseArray)localObject1).get(((Number)localObject2).intValue());
    if (localObject1 != null) {
      if (this.NOE == 0) {
        this.vuT.setText(localObject1[0]);
      }
    }
    for (;;)
    {
      localObject1 = NOG;
      localObject2 = this.mRG.get(this.NOE);
      p.g(localObject2, "actions[actionIndex]");
      localObject1 = (int[])((SparseArray)localObject1).get(((Number)localObject2).intValue());
      if (localObject1 == null) {
        break label283;
      }
      localObject2 = new a();
      int j = localObject1.length;
      while (i < j)
      {
        int k = localObject1[i];
        Drawable localDrawable = getContext().getDrawable(k);
        if (localDrawable == null) {
          p.hyc();
        }
        ((a)localObject2).addFrame(localDrawable, 300);
        i += 1;
      }
      this.vuT.setText(localObject1[1]);
      continue;
      this.vuT.setText(null);
    }
    this.NOD.setImageDrawable((Drawable)localObject2);
    ((a)localObject2).start();
    for (;;)
    {
      this.NOE += 1;
      postDelayed(this.NOF, 2000L);
      AppMethodBeat.o(194237);
      return;
      label283:
      this.NOD.setImageDrawable(null);
    }
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(194235);
    super.onFinishInflate();
    setOrientation(1);
    setGravity(17);
    AppMethodBeat.o(194235);
  }
  
  public final void setStickerPack(f paramf)
  {
    AppMethodBeat.i(194236);
    if ((p.j(this.rpM, paramf) ^ true))
    {
      removeCallbacks(this.NOF);
      this.rpM = paramf;
      this.mRG.clear();
      if (paramf != null)
      {
        LinkedList localLinkedList = this.mRG;
        Object localObject1 = new LinkedList();
        Object localObject2 = paramf.NNs;
        if (localObject2 != null)
        {
          localObject2 = ((e)localObject2).NMT;
          if (localObject2 != null)
          {
            localObject2 = ((HashMap)localObject2).values();
            if (localObject2 != null) {
              ((LinkedList)localObject1).addAll((Collection)localObject2);
            }
          }
        }
        localObject2 = paramf.NNt;
        if (localObject2 != null)
        {
          localObject2 = ((e)localObject2).NMT;
          if (localObject2 != null)
          {
            localObject2 = ((HashMap)localObject2).values();
            if (localObject2 != null) {
              ((LinkedList)localObject1).addAll((Collection)localObject2);
            }
          }
        }
        paramf = paramf.NNu;
        if (paramf != null)
        {
          paramf = paramf.NMT;
          if (paramf != null)
          {
            paramf = paramf.values();
            if (paramf != null) {
              ((LinkedList)localObject1).addAll(paramf);
            }
          }
        }
        paramf = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = paramf.iterator();
        label255:
        while (((Iterator)localObject2).hasNext())
        {
          paramf = (d)((Iterator)localObject2).next();
          if (paramf.NMN > 0) {}
          for (paramf = Integer.valueOf(paramf.NMN);; paramf = null)
          {
            if (paramf == null) {
              break label255;
            }
            ((Collection)localObject1).add(paramf);
            break;
          }
        }
        localLinkedList.addAll((Collection)localObject1);
      }
      if (this.mRG.size() > 0)
      {
        this.NOE = 0;
        gzv();
        AppMethodBeat.o(194236);
        return;
      }
      gzw();
    }
    AppMethodBeat.o(194236);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CaptureStickerHint paramCaptureStickerHint) {}
    
    public final void run()
    {
      AppMethodBeat.i(194234);
      this.NOJ.gzv();
      AppMethodBeat.o(194234);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.ui.view.CaptureStickerHint
 * JD-Core Version:    0.7.0.1
 */