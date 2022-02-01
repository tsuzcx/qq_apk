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
import com.tencent.mm.plugin.ao.a.a;
import com.tencent.mm.plugin.ao.a.b;
import com.tencent.mm.plugin.ao.a.c;
import com.tencent.mm.plugin.ao.a.d;
import com.tencent.mm.sticker.d;
import com.tencent.mm.sticker.e;
import com.tencent.mm.sticker.e.a;
import com.tencent.mm.sticker.f;
import com.tencent.mm.ui.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "actionIndex", "actions", "Ljava/util/LinkedList;", "hintIcon", "Landroid/widget/ImageView;", "hintText", "Landroid/widget/TextView;", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "switchStickerHintRunnable", "Ljava/lang/Runnable;", "hideStickerHint", "", "onFinishInflate", "setStickerPack", "showStickerHint", "switchHint", "Companion", "plugin-sticker_release"})
public final class CaptureStickerHint
  extends LinearLayout
{
  private static final SparseArray<int[]> Vcp;
  private static final SparseArray<int[]> Vcq;
  public static final a Vcr;
  private final TextView AbR;
  private final String TAG;
  private final ImageView Vcm;
  private int Vcn;
  private final Runnable Vco;
  private LinkedList<Integer> pSC;
  private f uVs;
  
  static
  {
    AppMethodBeat.i(232968);
    Vcr = new a((byte)0);
    Vcp = new SparseArray();
    Vcq = new SparseArray();
    SparseArray localSparseArray = Vcp;
    e.a locala = e.Vba;
    localSparseArray.put(e.huC(), new int[] { a.a.sticker_tips_action_mouth_open_1, a.a.sticker_tips_action_mouth_open_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huD(), new int[] { a.a.sticker_tips_action_mouth_kiss_1, a.a.sticker_tips_action_mouth_kiss_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huE(), new int[] { a.a.sticker_tips_action_lefteye_blink_1, a.a.sticker_tips_action_lefteye_blink_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huF(), new int[] { a.a.sticker_tips_action_righteye_blink_1, a.a.sticker_tips_action_righteye_blink_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huG(), new int[] { a.a.sticker_tips_action_eye_blink_1, a.a.sticker_tips_action_eye_blink_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huH(), new int[] { a.a.sticker_tips_action_eyebrow_up_1, a.a.sticker_tips_action_eyebrow_up_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huI(), new int[] { a.a.sticker_tips_action_head_shake_1, a.a.sticker_tips_action_head_shake_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huJ(), new int[] { a.a.sticker_tips_action_head_nod_1, a.a.sticker_tips_action_head_nod_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huK(), new int[] { a.a.sticker_tips_hand_action_heart_1, a.a.sticker_tips_hand_action_heart_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huL(), new int[] { a.a.sticker_tips_hand_action_paper_1, a.a.sticker_tips_hand_action_paper_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huM(), new int[] { a.a.sticker_tips_hand_action_scissor_1, a.a.sticker_tips_hand_action_scissor_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huN(), new int[] { a.a.sticker_tips_hand_action_fist_1, a.a.sticker_tips_hand_action_fist_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huO(), new int[] { a.a.sticker_tips_hand_action_one_1, a.a.sticker_tips_hand_action_one_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huP(), new int[] { a.a.sticker_tips_hand_action_love_1, a.a.sticker_tips_hand_action_love_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huQ(), new int[] { a.a.sticker_tips_hand_action_like_1, a.a.sticker_tips_hand_action_like_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huR(), new int[] { a.a.sticker_tips_hand_action_ok_1, a.a.sticker_tips_hand_action_ok_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huS(), new int[] { a.a.sticker_tips_hand_action_rock_1, a.a.sticker_tips_hand_action_rock_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huT(), new int[] { a.a.sticker_tips_hand_action_six_1, a.a.sticker_tips_hand_action_six_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huU(), new int[] { a.a.sticker_tips_hand_action_eight_1, a.a.sticker_tips_hand_action_eight_2 });
    localSparseArray = Vcp;
    locala = e.Vba;
    localSparseArray.put(e.huV(), new int[] { a.a.sticker_tips_hand_action_good_fortune_1, a.a.sticker_tips_hand_action_good_fortune_2 });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huC(), new int[] { a.d.sticker_tips_action_mouth_open, a.d.sticker_tips_action_mouth_open_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huD(), new int[] { a.d.sticker_tips_action_mouth_kiss, a.d.sticker_tips_action_mouth_kiss_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huE(), new int[] { a.d.sticker_tips_action_lefteye_blink, a.d.sticker_tips_action_lefteye_blink_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huF(), new int[] { a.d.sticker_tips_action_righteye_blink, a.d.sticker_tips_action_righteye_blink_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huG(), new int[] { a.d.sticker_tips_action_eye_blink, a.d.sticker_tips_action_eye_blink_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huH(), new int[] { a.d.sticker_tips_action_eyebrow_up, a.d.sticker_tips_action_eyebrow_up_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huI(), new int[] { a.d.sticker_tips_action_head_shake, a.d.sticker_tips_action_head_shake_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huJ(), new int[] { a.d.sticker_tips_action_head_nod, a.d.sticker_tips_action_head_nod_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huK(), new int[] { a.d.sticker_tips_hand_action_heart, a.d.sticker_tips_hand_action_heart_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huL(), new int[] { a.d.sticker_tips_hand_action_paper, a.d.sticker_tips_hand_action_paper_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huM(), new int[] { a.d.sticker_tips_hand_action_scissor, a.d.sticker_tips_hand_action_scissor_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huN(), new int[] { a.d.sticker_tips_hand_action_fist, a.d.sticker_tips_hand_action_fist_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huO(), new int[] { a.d.sticker_tips_hand_action_one, a.d.sticker_tips_hand_action_one_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huP(), new int[] { a.d.sticker_tips_hand_action_love, a.d.sticker_tips_hand_action_love_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huQ(), new int[] { a.d.sticker_tips_hand_action_like, a.d.sticker_tips_hand_action_like_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huR(), new int[] { a.d.sticker_tips_hand_action_ok, a.d.sticker_tips_hand_action_ok_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huS(), new int[] { a.d.sticker_tips_hand_action_rock, a.d.sticker_tips_hand_action_rock_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huT(), new int[] { a.d.sticker_tips_hand_action_six, a.d.sticker_tips_hand_action_six_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huU(), new int[] { a.d.sticker_tips_hand_action_eight, a.d.sticker_tips_hand_action_eight_next });
    localSparseArray = Vcq;
    locala = e.Vba;
    localSparseArray.put(e.huV(), new int[] { a.d.sticker_tips_hand_action_good_fortune, a.d.sticker_tips_hand_action_good_fortune_next });
    AppMethodBeat.o(232968);
  }
  
  public CaptureStickerHint(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(232965);
    AppMethodBeat.o(232965);
  }
  
  public CaptureStickerHint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(232964);
    this.TAG = "MicroMsg.CaptureStickerHint";
    this.pSC = new LinkedList();
    this.Vco = ((Runnable)new b(this));
    View.inflate(paramContext, a.c.sticker_preview_hint, (ViewGroup)this);
    paramContext = findViewById(a.b.sticker_preview_hint_icon);
    p.j(paramContext, "findViewById(R.id.sticker_preview_hint_icon)");
    this.Vcm = ((ImageView)paramContext);
    paramContext = findViewById(a.b.sticker_preview_hint_text);
    p.j(paramContext, "findViewById(R.id.sticker_preview_hint_text)");
    this.AbR = ((TextView)paramContext);
    AppMethodBeat.o(232964);
  }
  
  private void hvw()
  {
    AppMethodBeat.i(232962);
    this.Vcm.setImageDrawable(null);
    setVisibility(8);
    AppMethodBeat.o(232962);
  }
  
  public final void hvv()
  {
    int i = 0;
    AppMethodBeat.i(232960);
    if (this.Vcn >= this.pSC.size())
    {
      hvw();
      AppMethodBeat.o(232960);
      return;
    }
    setVisibility(0);
    Object localObject1 = Vcq;
    Object localObject2 = this.pSC.get(this.Vcn);
    p.j(localObject2, "actions[actionIndex]");
    localObject1 = (int[])((SparseArray)localObject1).get(((Number)localObject2).intValue());
    if (localObject1 != null) {
      if (this.Vcn == 0) {
        this.AbR.setText(localObject1[0]);
      }
    }
    for (;;)
    {
      localObject1 = Vcp;
      localObject2 = this.pSC.get(this.Vcn);
      p.j(localObject2, "actions[actionIndex]");
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
          p.iCn();
        }
        ((a)localObject2).addFrame(localDrawable, 300);
        i += 1;
      }
      this.AbR.setText(localObject1[1]);
      continue;
      this.AbR.setText(null);
    }
    this.Vcm.setImageDrawable((Drawable)localObject2);
    ((a)localObject2).start();
    for (;;)
    {
      this.Vcn += 1;
      postDelayed(this.Vco, 2000L);
      AppMethodBeat.o(232960);
      return;
      label283:
      this.Vcm.setImageDrawable(null);
    }
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(232957);
    super.onFinishInflate();
    setOrientation(1);
    setGravity(17);
    AppMethodBeat.o(232957);
  }
  
  public final void setStickerPack(f paramf)
  {
    AppMethodBeat.i(232958);
    if ((p.h(this.uVs, paramf) ^ true))
    {
      removeCallbacks(this.Vco);
      this.uVs = paramf;
      this.pSC.clear();
      if (paramf != null)
      {
        LinkedList localLinkedList = this.pSC;
        Object localObject1 = new LinkedList();
        Object localObject2 = paramf.Vbc;
        if (localObject2 != null)
        {
          localObject2 = ((e)localObject2).VaD;
          if (localObject2 != null)
          {
            localObject2 = ((HashMap)localObject2).values();
            if (localObject2 != null) {
              ((LinkedList)localObject1).addAll((Collection)localObject2);
            }
          }
        }
        localObject2 = paramf.Vbd;
        if (localObject2 != null)
        {
          localObject2 = ((e)localObject2).VaD;
          if (localObject2 != null)
          {
            localObject2 = ((HashMap)localObject2).values();
            if (localObject2 != null) {
              ((LinkedList)localObject1).addAll((Collection)localObject2);
            }
          }
        }
        paramf = paramf.Vbe;
        if (paramf != null)
        {
          paramf = paramf.VaD;
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
          if (paramf.Vax > 0) {}
          for (paramf = Integer.valueOf(paramf.Vax);; paramf = null)
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
      if (this.pSC.size() > 0)
      {
        this.Vcn = 0;
        hvv();
        AppMethodBeat.o(232958);
        return;
      }
      hvw();
    }
    AppMethodBeat.o(232958);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint$Companion;", "", "()V", "tipsIconIds", "Landroid/util/SparseArray;", "", "getTipsIconIds", "()Landroid/util/SparseArray;", "tipsStrIds", "getTipsStrIds", "plugin-sticker_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CaptureStickerHint paramCaptureStickerHint) {}
    
    public final void run()
    {
      AppMethodBeat.i(232787);
      this.Vcs.hvv();
      AppMethodBeat.o(232787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.ui.view.CaptureStickerHint
 * JD-Core Version:    0.7.0.1
 */