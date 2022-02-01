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
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "actionIndex", "actions", "Ljava/util/LinkedList;", "hintIcon", "Landroid/widget/ImageView;", "hintText", "Landroid/widget/TextView;", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "switchStickerHintRunnable", "Ljava/lang/Runnable;", "hideStickerHint", "", "onFinishInflate", "setStickerPack", "showStickerHint", "switchHint", "Companion", "plugin-sticker_release"})
public final class CaptureStickerHint
  extends LinearLayout
{
  private static final SparseArray<int[]> InC;
  private static final SparseArray<int[]> InD;
  public static final CaptureStickerHint.a InE;
  private int InA;
  private final Runnable InB;
  private final ImageView Iny;
  private final TextView Inz;
  private final String TAG;
  private LinkedList<Integer> lFr;
  private f pSk;
  
  static
  {
    AppMethodBeat.i(215394);
    InE = new CaptureStickerHint.a((byte)0);
    InC = new SparseArray();
    InD = new SparseArray();
    SparseArray localSparseArray = InC;
    e.a locala = e.Imp;
    localSparseArray.put(e.fnJ(), new int[] { 2131234192, 2131234193 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnK(), new int[] { 2131234190, 2131234191 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnL(), new int[] { 2131234188, 2131234189 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnM(), new int[] { 2131234194, 2131234195 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnN(), new int[] { 2131234180, 2131234181 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnO(), new int[] { 2131234182, 2131234183 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnP(), new int[] { 2131234186, 2131234187 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnQ(), new int[] { 2131234184, 2131234185 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnR(), new int[] { 2131234202, 2131234203 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnS(), new int[] { 2131234212, 2131234213 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnT(), new int[] { 2131234216, 2131234217 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnU(), new int[] { 2131234198, 2131234199 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnV(), new int[] { 2131234210, 2131234211 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnW(), new int[] { 2131234206, 2131234207 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnX(), new int[] { 2131234204, 2131234205 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnY(), new int[] { 2131234208, 2131234209 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fnZ(), new int[] { 2131234214, 2131234215 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.foa(), new int[] { 2131234218, 2131234219 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.fob(), new int[] { 2131234196, 2131234197 });
    localSparseArray = InC;
    locala = e.Imp;
    localSparseArray.put(e.foc(), new int[] { 2131234200, 2131234201 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnJ(), new int[] { 2131764162, 2131764163 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnK(), new int[] { 2131764160, 2131764161 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnL(), new int[] { 2131764158, 2131764159 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnM(), new int[] { 2131764164, 2131764165 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnN(), new int[] { 2131764150, 2131764151 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnO(), new int[] { 2131764152, 2131764153 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnP(), new int[] { 2131764156, 2131764157 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnQ(), new int[] { 2131764154, 2131764155 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnR(), new int[] { 2131764172, 2131764173 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnS(), new int[] { 2131764182, 2131764183 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnT(), new int[] { 2131764186, 2131764187 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnU(), new int[] { 2131764168, 2131764169 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnV(), new int[] { 2131764180, 2131764181 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnW(), new int[] { 2131764176, 2131764177 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnX(), new int[] { 2131764174, 2131764175 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnY(), new int[] { 2131764178, 2131764179 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fnZ(), new int[] { 2131764184, 2131764185 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.foa(), new int[] { 2131764188, 2131764189 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.fob(), new int[] { 2131764166, 2131764167 });
    localSparseArray = InD;
    locala = e.Imp;
    localSparseArray.put(e.foc(), new int[] { 2131764170, 2131764171 });
    AppMethodBeat.o(215394);
  }
  
  public CaptureStickerHint(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(215393);
    AppMethodBeat.o(215393);
  }
  
  public CaptureStickerHint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(215392);
    this.TAG = "MicroMsg.CaptureStickerHint";
    this.lFr = new LinkedList();
    this.InB = ((Runnable)new b(this));
    View.inflate(paramContext, 2131495642, (ViewGroup)this);
    paramContext = findViewById(2131305231);
    p.g(paramContext, "findViewById(R.id.sticker_preview_hint_icon)");
    this.Iny = ((ImageView)paramContext);
    paramContext = findViewById(2131305232);
    p.g(paramContext, "findViewById(R.id.sticker_preview_hint_text)");
    this.Inz = ((TextView)paramContext);
    AppMethodBeat.o(215392);
  }
  
  private void foC()
  {
    AppMethodBeat.i(215391);
    this.Iny.setImageDrawable(null);
    setVisibility(8);
    AppMethodBeat.o(215391);
  }
  
  public final void foB()
  {
    int i = 0;
    AppMethodBeat.i(215390);
    if (this.InA >= this.lFr.size())
    {
      foC();
      AppMethodBeat.o(215390);
      return;
    }
    setVisibility(0);
    Object localObject1 = InD;
    Object localObject2 = this.lFr.get(this.InA);
    p.g(localObject2, "actions[actionIndex]");
    localObject1 = (int[])((SparseArray)localObject1).get(((Number)localObject2).intValue());
    if (localObject1 != null) {
      if (this.InA == 0) {
        this.Inz.setText(localObject1[0]);
      }
    }
    for (;;)
    {
      localObject1 = InC;
      localObject2 = this.lFr.get(this.InA);
      p.g(localObject2, "actions[actionIndex]");
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
      this.Inz.setText(localObject1[1]);
      continue;
      this.Inz.setText(null);
    }
    this.Iny.setImageDrawable((Drawable)localObject2);
    ((a)localObject2).start();
    for (;;)
    {
      this.InA += 1;
      postDelayed(this.InB, 2000L);
      AppMethodBeat.o(215390);
      return;
      label271:
      this.Iny.setImageDrawable(null);
    }
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(215388);
    super.onFinishInflate();
    setOrientation(1);
    setGravity(17);
    AppMethodBeat.o(215388);
  }
  
  public final void setStickerPack(f paramf)
  {
    AppMethodBeat.i(215389);
    if ((p.i(this.pSk, paramf) ^ true))
    {
      removeCallbacks(this.InB);
      this.pSk = paramf;
      this.lFr.clear();
      if (paramf != null)
      {
        LinkedList localLinkedList = this.lFr;
        Object localObject1 = new LinkedList();
        Object localObject2 = paramf.Imr;
        if (localObject2 != null)
        {
          localObject2 = ((e)localObject2).IlS;
          if (localObject2 != null)
          {
            localObject2 = ((HashMap)localObject2).values();
            if (localObject2 != null) {
              ((LinkedList)localObject1).addAll((Collection)localObject2);
            }
          }
        }
        localObject2 = paramf.Ims;
        if (localObject2 != null)
        {
          localObject2 = ((e)localObject2).IlS;
          if (localObject2 != null)
          {
            localObject2 = ((HashMap)localObject2).values();
            if (localObject2 != null) {
              ((LinkedList)localObject1).addAll((Collection)localObject2);
            }
          }
        }
        paramf = paramf.Imt;
        if (paramf != null)
        {
          paramf = paramf.IlS;
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
          if (paramf.IlL > 0) {}
          for (paramf = Integer.valueOf(paramf.IlL);; paramf = null)
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
      if (this.lFr.size() > 0)
      {
        this.InA = 0;
        foB();
        AppMethodBeat.o(215389);
        return;
      }
      foC();
    }
    AppMethodBeat.o(215389);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CaptureStickerHint paramCaptureStickerHint) {}
    
    public final void run()
    {
      AppMethodBeat.i(215387);
      this.InF.foB();
      AppMethodBeat.o(215387);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.ui.view.CaptureStickerHint
 * JD-Core Version:    0.7.0.1
 */