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
import com.tencent.mm.ui.e.a;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "actionIndex", "actions", "Ljava/util/LinkedList;", "hintIcon", "Landroid/widget/ImageView;", "hintText", "Landroid/widget/TextView;", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "switchStickerHintRunnable", "Ljava/lang/Runnable;", "hideStickerHint", "", "onFinishInflate", "setStickerPack", "showStickerHint", "switchHint", "Companion", "plugin-sticker_release"})
public final class CaptureStickerHint
  extends LinearLayout
{
  private static final SparseArray<int[]> GBI;
  private static final SparseArray<int[]> GBJ;
  public static final CaptureStickerHint.a GBK;
  private final ImageView GBE;
  private final TextView GBF;
  private int GBG;
  private final Runnable GBH;
  private final String TAG;
  private LinkedList<Integer> lio;
  private f poJ;
  
  static
  {
    AppMethodBeat.i(204925);
    GBK = new CaptureStickerHint.a((byte)0);
    GBI = new SparseArray();
    GBJ = new SparseArray();
    SparseArray localSparseArray = GBI;
    e.a locala = e.GAv;
    localSparseArray.put(e.eXZ(), new int[] { 2131234192, 2131234193 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYa(), new int[] { 2131234190, 2131234191 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYb(), new int[] { 2131234188, 2131234189 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYc(), new int[] { 2131234194, 2131234195 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYd(), new int[] { 2131234180, 2131234181 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYe(), new int[] { 2131234182, 2131234183 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYf(), new int[] { 2131234186, 2131234187 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYg(), new int[] { 2131234184, 2131234185 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYh(), new int[] { 2131234202, 2131234203 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYi(), new int[] { 2131234212, 2131234213 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYj(), new int[] { 2131234216, 2131234217 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYk(), new int[] { 2131234198, 2131234199 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYl(), new int[] { 2131234210, 2131234211 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYm(), new int[] { 2131234206, 2131234207 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYn(), new int[] { 2131234204, 2131234205 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYo(), new int[] { 2131234208, 2131234209 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYp(), new int[] { 2131234214, 2131234215 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYq(), new int[] { 2131234218, 2131234219 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYr(), new int[] { 2131234196, 2131234197 });
    localSparseArray = GBI;
    locala = e.GAv;
    localSparseArray.put(e.eYs(), new int[] { 2131234200, 2131234201 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eXZ(), new int[] { 2131764162, 2131764163 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYa(), new int[] { 2131764160, 2131764161 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYb(), new int[] { 2131764158, 2131764159 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYc(), new int[] { 2131764164, 2131764165 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYd(), new int[] { 2131764150, 2131764151 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYe(), new int[] { 2131764152, 2131764153 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYf(), new int[] { 2131764156, 2131764157 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYg(), new int[] { 2131764154, 2131764155 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYh(), new int[] { 2131764172, 2131764173 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYi(), new int[] { 2131764182, 2131764183 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYj(), new int[] { 2131764186, 2131764187 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYk(), new int[] { 2131764168, 2131764169 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYl(), new int[] { 2131764180, 2131764181 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYm(), new int[] { 2131764176, 2131764177 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYn(), new int[] { 2131764174, 2131764175 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYo(), new int[] { 2131764178, 2131764179 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYp(), new int[] { 2131764184, 2131764185 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYq(), new int[] { 2131764188, 2131764189 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYr(), new int[] { 2131764166, 2131764167 });
    localSparseArray = GBJ;
    locala = e.GAv;
    localSparseArray.put(e.eYs(), new int[] { 2131764170, 2131764171 });
    AppMethodBeat.o(204925);
  }
  
  public CaptureStickerHint(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(204924);
    AppMethodBeat.o(204924);
  }
  
  public CaptureStickerHint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204923);
    this.TAG = "MicroMsg.CaptureStickerHint";
    this.lio = new LinkedList();
    this.GBH = ((Runnable)new b(this));
    View.inflate(paramContext, 2131495642, (ViewGroup)this);
    paramContext = findViewById(2131305231);
    k.g(paramContext, "findViewById(R.id.sticker_preview_hint_icon)");
    this.GBE = ((ImageView)paramContext);
    paramContext = findViewById(2131305232);
    k.g(paramContext, "findViewById(R.id.sticker_preview_hint_text)");
    this.GBF = ((TextView)paramContext);
    AppMethodBeat.o(204923);
  }
  
  private void eYS()
  {
    AppMethodBeat.i(204922);
    this.GBE.setImageDrawable(null);
    setVisibility(8);
    AppMethodBeat.o(204922);
  }
  
  public final void eYR()
  {
    int i = 0;
    AppMethodBeat.i(204921);
    if (this.GBG >= this.lio.size())
    {
      eYS();
      AppMethodBeat.o(204921);
      return;
    }
    setVisibility(0);
    Object localObject1 = GBJ;
    Object localObject2 = this.lio.get(this.GBG);
    k.g(localObject2, "actions[actionIndex]");
    localObject1 = (int[])((SparseArray)localObject1).get(((Number)localObject2).intValue());
    if (localObject1 != null) {
      if (this.GBG == 0) {
        this.GBF.setText(localObject1[0]);
      }
    }
    for (;;)
    {
      localObject1 = GBI;
      localObject2 = this.lio.get(this.GBG);
      k.g(localObject2, "actions[actionIndex]");
      localObject1 = (int[])((SparseArray)localObject1).get(((Number)localObject2).intValue());
      if (localObject1 == null) {
        break label271;
      }
      localObject2 = new a();
      int j = localObject1.length;
      while (i < j)
      {
        int k = localObject1[i];
        ((a)localObject2).addFrame(getContext().getDrawable(k), 300);
        i += 1;
      }
      this.GBF.setText(localObject1[1]);
      continue;
      this.GBF.setText(null);
    }
    this.GBE.setImageDrawable((Drawable)localObject2);
    ((a)localObject2).start();
    for (;;)
    {
      this.GBG += 1;
      postDelayed(this.GBH, 2000L);
      AppMethodBeat.o(204921);
      return;
      label271:
      this.GBE.setImageDrawable(null);
    }
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(204919);
    super.onFinishInflate();
    setOrientation(1);
    setGravity(17);
    AppMethodBeat.o(204919);
  }
  
  public final void setStickerPack(f paramf)
  {
    AppMethodBeat.i(204920);
    if ((k.g(this.poJ, paramf) ^ true))
    {
      removeCallbacks(this.GBH);
      this.poJ = paramf;
      this.lio.clear();
      if (paramf != null)
      {
        LinkedList localLinkedList = this.lio;
        Object localObject1 = new LinkedList();
        Object localObject2 = paramf.GAx;
        if (localObject2 != null)
        {
          localObject2 = ((e)localObject2).GzY;
          if (localObject2 != null)
          {
            localObject2 = ((HashMap)localObject2).values();
            if (localObject2 != null) {
              ((LinkedList)localObject1).addAll((Collection)localObject2);
            }
          }
        }
        localObject2 = paramf.GAy;
        if (localObject2 != null)
        {
          localObject2 = ((e)localObject2).GzY;
          if (localObject2 != null)
          {
            localObject2 = ((HashMap)localObject2).values();
            if (localObject2 != null) {
              ((LinkedList)localObject1).addAll((Collection)localObject2);
            }
          }
        }
        paramf = paramf.GAz;
        if (paramf != null)
        {
          paramf = paramf.GzY;
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
          if (paramf.GzR > 0) {}
          for (paramf = Integer.valueOf(paramf.GzR);; paramf = null)
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
      if (this.lio.size() > 0)
      {
        this.GBG = 0;
        eYR();
        AppMethodBeat.o(204920);
        return;
      }
      eYS();
    }
    AppMethodBeat.o(204920);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CaptureStickerHint paramCaptureStickerHint) {}
    
    public final void run()
    {
      AppMethodBeat.i(204918);
      this.GBL.eYR();
      AppMethodBeat.o(204918);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.ui.view.CaptureStickerHint
 * JD-Core Version:    0.7.0.1
 */