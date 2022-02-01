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
import com.tencent.mm.sticker.c;
import com.tencent.mm.sticker.d;
import com.tencent.mm.sticker.d.a;
import com.tencent.mm.sticker.e;
import com.tencent.mm.ui.e.a;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "actionIndex", "actions", "Ljava/util/LinkedList;", "hintIcon", "Landroid/widget/ImageView;", "hintText", "Landroid/widget/TextView;", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "switchStickerHintRunnable", "Ljava/lang/Runnable;", "hideStickerHint", "", "onFinishInflate", "setStickerPack", "showStickerHint", "switchHint", "Companion", "plugin-sticker_release"})
public final class CaptureStickerHint
  extends LinearLayout
{
  private static final SparseArray<int[]> LAF;
  private static final SparseArray<int[]> LAG;
  public static final a LAH;
  private final ImageView LAB;
  private final TextView LAC;
  private int LAD;
  private final Runnable LAE;
  private final String TAG;
  private LinkedList<Integer> kGU;
  private e oLp;
  
  static
  {
    AppMethodBeat.i(202314);
    LAH = new a((byte)0);
    LAF = new SparseArray();
    LAG = new SparseArray();
    SparseArray localSparseArray = LAF;
    d.a locala = d.FcY;
    localSparseArray.put(d.eID(), new int[] { 2131234192, 2131234193 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIE(), new int[] { 2131234190, 2131234191 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIF(), new int[] { 2131234188, 2131234189 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIG(), new int[] { 2131234194, 2131234195 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIH(), new int[] { 2131234180, 2131234181 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eII(), new int[] { 2131234182, 2131234183 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIJ(), new int[] { 2131234186, 2131234187 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIK(), new int[] { 2131234184, 2131234185 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIL(), new int[] { 2131234202, 2131234203 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIM(), new int[] { 2131234212, 2131234213 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIN(), new int[] { 2131234216, 2131234217 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIO(), new int[] { 2131234198, 2131234199 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIP(), new int[] { 2131234210, 2131234211 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIQ(), new int[] { 2131234206, 2131234207 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIR(), new int[] { 2131234204, 2131234205 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIS(), new int[] { 2131234208, 2131234209 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIT(), new int[] { 2131234214, 2131234215 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIU(), new int[] { 2131234218, 2131234219 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIV(), new int[] { 2131234196, 2131234197 });
    localSparseArray = LAF;
    locala = d.FcY;
    localSparseArray.put(d.eIW(), new int[] { 2131234200, 2131234201 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eID(), new int[] { 2131764162, 2131764163 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIE(), new int[] { 2131764160, 2131764161 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIF(), new int[] { 2131764158, 2131764159 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIG(), new int[] { 2131764164, 2131764165 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIH(), new int[] { 2131764150, 2131764151 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eII(), new int[] { 2131764152, 2131764153 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIJ(), new int[] { 2131764156, 2131764157 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIK(), new int[] { 2131764154, 2131764155 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIL(), new int[] { 2131764172, 2131764173 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIM(), new int[] { 2131764182, 2131764183 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIN(), new int[] { 2131764186, 2131764187 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIO(), new int[] { 2131764168, 2131764169 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIP(), new int[] { 2131764180, 2131764181 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIQ(), new int[] { 2131764176, 2131764177 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIR(), new int[] { 2131764174, 2131764175 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIS(), new int[] { 2131764178, 2131764179 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIT(), new int[] { 2131764184, 2131764185 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIU(), new int[] { 2131764188, 2131764189 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIV(), new int[] { 2131764166, 2131764167 });
    localSparseArray = LAG;
    locala = d.FcY;
    localSparseArray.put(d.eIW(), new int[] { 2131764170, 2131764171 });
    AppMethodBeat.o(202314);
  }
  
  public CaptureStickerHint(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(202313);
    AppMethodBeat.o(202313);
  }
  
  public CaptureStickerHint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(202312);
    this.TAG = "MicroMsg.CaptureStickerHint";
    this.kGU = new LinkedList();
    this.LAE = ((Runnable)new b(this));
    View.inflate(paramContext, 2131495642, (ViewGroup)this);
    paramContext = findViewById(2131305231);
    k.g(paramContext, "findViewById(R.id.sticker_preview_hint_icon)");
    this.LAB = ((ImageView)paramContext);
    paramContext = findViewById(2131305232);
    k.g(paramContext, "findViewById(R.id.sticker_preview_hint_text)");
    this.LAC = ((TextView)paramContext);
    AppMethodBeat.o(202312);
  }
  
  private void fZI()
  {
    AppMethodBeat.i(202311);
    this.LAB.setImageDrawable(null);
    setVisibility(8);
    AppMethodBeat.o(202311);
  }
  
  public final void fZH()
  {
    int i = 0;
    AppMethodBeat.i(202310);
    if (this.LAD >= this.kGU.size())
    {
      fZI();
      AppMethodBeat.o(202310);
      return;
    }
    setVisibility(0);
    Object localObject1 = LAG;
    Object localObject2 = this.kGU.get(this.LAD);
    k.g(localObject2, "actions[actionIndex]");
    localObject1 = (int[])((SparseArray)localObject1).get(((Number)localObject2).intValue());
    if (localObject1 != null) {
      if (this.LAD == 0) {
        this.LAC.setText(localObject1[0]);
      }
    }
    for (;;)
    {
      localObject1 = LAF;
      localObject2 = this.kGU.get(this.LAD);
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
      this.LAC.setText(localObject1[1]);
      continue;
      this.LAC.setText(null);
    }
    this.LAB.setImageDrawable((Drawable)localObject2);
    ((a)localObject2).start();
    for (;;)
    {
      this.LAD += 1;
      postDelayed(this.LAE, 2000L);
      AppMethodBeat.o(202310);
      return;
      label271:
      this.LAB.setImageDrawable(null);
    }
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(202308);
    super.onFinishInflate();
    setOrientation(1);
    setGravity(17);
    AppMethodBeat.o(202308);
  }
  
  public final void setStickerPack(e parame)
  {
    AppMethodBeat.i(202309);
    if ((k.g(this.oLp, parame) ^ true))
    {
      removeCallbacks(this.LAE);
      this.oLp = parame;
      this.kGU.clear();
      if (parame != null)
      {
        LinkedList localLinkedList = this.kGU;
        Object localObject1 = new LinkedList();
        Object localObject2 = parame.Fda;
        if (localObject2 != null)
        {
          localObject2 = ((d)localObject2).FcB;
          if (localObject2 != null)
          {
            localObject2 = ((HashMap)localObject2).values();
            if (localObject2 != null) {
              ((LinkedList)localObject1).addAll((Collection)localObject2);
            }
          }
        }
        localObject2 = parame.Fdb;
        if (localObject2 != null)
        {
          localObject2 = ((d)localObject2).FcB;
          if (localObject2 != null)
          {
            localObject2 = ((HashMap)localObject2).values();
            if (localObject2 != null) {
              ((LinkedList)localObject1).addAll((Collection)localObject2);
            }
          }
        }
        parame = parame.Fdc;
        if (parame != null)
        {
          parame = parame.FcB;
          if (parame != null)
          {
            parame = parame.values();
            if (parame != null) {
              ((LinkedList)localObject1).addAll(parame);
            }
          }
        }
        parame = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = parame.iterator();
        label255:
        while (((Iterator)localObject2).hasNext())
        {
          parame = (c)((Iterator)localObject2).next();
          if (parame.Fcu > 0) {}
          for (parame = Integer.valueOf(parame.Fcu);; parame = null)
          {
            if (parame == null) {
              break label255;
            }
            ((Collection)localObject1).add(parame);
            break;
          }
        }
        localLinkedList.addAll((Collection)localObject1);
      }
      if (this.kGU.size() > 0)
      {
        this.LAD = 0;
        fZH();
        AppMethodBeat.o(202309);
        return;
      }
      fZI();
    }
    AppMethodBeat.o(202309);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint$Companion;", "", "()V", "tipsIconIds", "Landroid/util/SparseArray;", "", "getTipsIconIds", "()Landroid/util/SparseArray;", "tipsStrIds", "getTipsStrIds", "plugin-sticker_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CaptureStickerHint paramCaptureStickerHint) {}
    
    public final void run()
    {
      AppMethodBeat.i(202307);
      this.LAI.fZH();
      AppMethodBeat.o(202307);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sticker.ui.view.CaptureStickerHint
 * JD-Core Version:    0.7.0.1
 */