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
import com.tencent.mm.plugin.aq.a.a;
import com.tencent.mm.plugin.aq.a.b;
import com.tencent.mm.plugin.aq.a.c;
import com.tencent.mm.plugin.aq.a.d;
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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "actionIndex", "actions", "Ljava/util/LinkedList;", "hintIcon", "Landroid/widget/ImageView;", "hintText", "Landroid/widget/TextView;", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "switchStickerHintRunnable", "Ljava/lang/Runnable;", "hideStickerHint", "", "onFinishInflate", "setStickerPack", "showStickerHint", "switchHint", "Companion", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CaptureStickerHint
  extends LinearLayout
{
  private static final SparseArray<int[]> acDB;
  private static final SparseArray<int[]> acDC;
  public static final CaptureStickerHint.a acDx;
  private final TextView FxM;
  private final String TAG;
  private final Runnable acDA;
  private final ImageView acDy;
  private int acDz;
  private LinkedList<Integer> sXD;
  private f yhU;
  
  static
  {
    AppMethodBeat.i(233923);
    acDx = new CaptureStickerHint.a((byte)0);
    acDB = new SparseArray();
    acDC = new SparseArray();
    SparseArray localSparseArray = acDB;
    e.a locala = e.acBV;
    localSparseArray.put(e.iWe(), new int[] { a.a.sticker_tips_action_mouth_open_1, a.a.sticker_tips_action_mouth_open_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWf(), new int[] { a.a.sticker_tips_action_mouth_kiss_1, a.a.sticker_tips_action_mouth_kiss_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWg(), new int[] { a.a.sticker_tips_action_lefteye_blink_1, a.a.sticker_tips_action_lefteye_blink_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWh(), new int[] { a.a.sticker_tips_action_righteye_blink_1, a.a.sticker_tips_action_righteye_blink_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWi(), new int[] { a.a.sticker_tips_action_eye_blink_1, a.a.sticker_tips_action_eye_blink_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWj(), new int[] { a.a.sticker_tips_action_eyebrow_up_1, a.a.sticker_tips_action_eyebrow_up_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWk(), new int[] { a.a.sticker_tips_action_head_shake_1, a.a.sticker_tips_action_head_shake_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWl(), new int[] { a.a.sticker_tips_action_head_nod_1, a.a.sticker_tips_action_head_nod_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWm(), new int[] { a.a.sticker_tips_hand_action_heart_1, a.a.sticker_tips_hand_action_heart_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWn(), new int[] { a.a.sticker_tips_hand_action_paper_1, a.a.sticker_tips_hand_action_paper_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWo(), new int[] { a.a.sticker_tips_hand_action_scissor_1, a.a.sticker_tips_hand_action_scissor_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWp(), new int[] { a.a.sticker_tips_hand_action_fist_1, a.a.sticker_tips_hand_action_fist_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWq(), new int[] { a.a.sticker_tips_hand_action_one_1, a.a.sticker_tips_hand_action_one_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWr(), new int[] { a.a.sticker_tips_hand_action_love_1, a.a.sticker_tips_hand_action_love_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWs(), new int[] { a.a.sticker_tips_hand_action_like_1, a.a.sticker_tips_hand_action_like_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWt(), new int[] { a.a.sticker_tips_hand_action_ok_1, a.a.sticker_tips_hand_action_ok_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWu(), new int[] { a.a.sticker_tips_hand_action_rock_1, a.a.sticker_tips_hand_action_rock_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWv(), new int[] { a.a.sticker_tips_hand_action_six_1, a.a.sticker_tips_hand_action_six_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWw(), new int[] { a.a.sticker_tips_hand_action_eight_1, a.a.sticker_tips_hand_action_eight_2 });
    localSparseArray = acDB;
    locala = e.acBV;
    localSparseArray.put(e.iWx(), new int[] { a.a.sticker_tips_hand_action_good_fortune_1, a.a.sticker_tips_hand_action_good_fortune_2 });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWe(), new int[] { a.d.sticker_tips_action_mouth_open, a.d.sticker_tips_action_mouth_open_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWf(), new int[] { a.d.sticker_tips_action_mouth_kiss, a.d.sticker_tips_action_mouth_kiss_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWg(), new int[] { a.d.sticker_tips_action_lefteye_blink, a.d.sticker_tips_action_lefteye_blink_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWh(), new int[] { a.d.sticker_tips_action_righteye_blink, a.d.sticker_tips_action_righteye_blink_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWi(), new int[] { a.d.sticker_tips_action_eye_blink, a.d.sticker_tips_action_eye_blink_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWj(), new int[] { a.d.sticker_tips_action_eyebrow_up, a.d.sticker_tips_action_eyebrow_up_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWk(), new int[] { a.d.sticker_tips_action_head_shake, a.d.sticker_tips_action_head_shake_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWl(), new int[] { a.d.sticker_tips_action_head_nod, a.d.sticker_tips_action_head_nod_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWm(), new int[] { a.d.sticker_tips_hand_action_heart, a.d.sticker_tips_hand_action_heart_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWn(), new int[] { a.d.sticker_tips_hand_action_paper, a.d.sticker_tips_hand_action_paper_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWo(), new int[] { a.d.sticker_tips_hand_action_scissor, a.d.sticker_tips_hand_action_scissor_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWp(), new int[] { a.d.sticker_tips_hand_action_fist, a.d.sticker_tips_hand_action_fist_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWq(), new int[] { a.d.sticker_tips_hand_action_one, a.d.sticker_tips_hand_action_one_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWr(), new int[] { a.d.sticker_tips_hand_action_love, a.d.sticker_tips_hand_action_love_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWs(), new int[] { a.d.sticker_tips_hand_action_like, a.d.sticker_tips_hand_action_like_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWt(), new int[] { a.d.sticker_tips_hand_action_ok, a.d.sticker_tips_hand_action_ok_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWu(), new int[] { a.d.sticker_tips_hand_action_rock, a.d.sticker_tips_hand_action_rock_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWv(), new int[] { a.d.sticker_tips_hand_action_six, a.d.sticker_tips_hand_action_six_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWw(), new int[] { a.d.sticker_tips_hand_action_eight, a.d.sticker_tips_hand_action_eight_next });
    localSparseArray = acDC;
    locala = e.acBV;
    localSparseArray.put(e.iWx(), new int[] { a.d.sticker_tips_hand_action_good_fortune, a.d.sticker_tips_hand_action_good_fortune_next });
    AppMethodBeat.o(233923);
  }
  
  public CaptureStickerHint(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(233910);
    AppMethodBeat.o(233910);
  }
  
  public CaptureStickerHint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(233907);
    this.TAG = "MicroMsg.CaptureStickerHint";
    this.sXD = new LinkedList();
    this.acDA = new CaptureStickerHint..ExternalSyntheticLambda0(this);
    View.inflate(paramContext, a.c.sticker_preview_hint, (ViewGroup)this);
    paramContext = findViewById(a.b.sticker_preview_hint_icon);
    s.s(paramContext, "findViewById(R.id.sticker_preview_hint_icon)");
    this.acDy = ((ImageView)paramContext);
    paramContext = findViewById(a.b.sticker_preview_hint_text);
    s.s(paramContext, "findViewById(R.id.sticker_preview_hint_text)");
    this.FxM = ((TextView)paramContext);
    AppMethodBeat.o(233907);
  }
  
  private static final void a(CaptureStickerHint paramCaptureStickerHint)
  {
    AppMethodBeat.i(233917);
    s.u(paramCaptureStickerHint, "this$0");
    paramCaptureStickerHint.iWV();
    AppMethodBeat.o(233917);
  }
  
  private void iWV()
  {
    int i = 0;
    AppMethodBeat.i(233913);
    if (this.acDz >= this.sXD.size())
    {
      iWW();
      AppMethodBeat.o(233913);
      return;
    }
    setVisibility(0);
    Object localObject1 = acDC;
    Object localObject2 = this.sXD.get(this.acDz);
    s.s(localObject2, "actions[actionIndex]");
    localObject1 = (int[])((SparseArray)localObject1).get(((Number)localObject2).intValue());
    if (localObject1 != null) {
      if (this.acDz == 0) {
        this.FxM.setText(localObject1[0]);
      }
    }
    for (;;)
    {
      localObject1 = acDB;
      localObject2 = this.sXD.get(this.acDz);
      s.s(localObject2, "actions[actionIndex]");
      localObject1 = (int[])((SparseArray)localObject1).get(((Number)localObject2).intValue());
      if (localObject1 == null) {
        break label280;
      }
      localObject2 = new a();
      int j = localObject1.length;
      while (i < j)
      {
        int k = localObject1[i];
        Drawable localDrawable = getContext().getDrawable(k);
        s.checkNotNull(localDrawable);
        ((a)localObject2).addFrame(localDrawable, 300);
        i += 1;
      }
      this.FxM.setText(localObject1[1]);
      continue;
      this.FxM.setText(null);
    }
    this.acDy.setImageDrawable((Drawable)localObject2);
    ((a)localObject2).start();
    for (;;)
    {
      this.acDz += 1;
      postDelayed(this.acDA, 2000L);
      AppMethodBeat.o(233913);
      return;
      label280:
      this.acDy.setImageDrawable(null);
    }
  }
  
  private void iWW()
  {
    AppMethodBeat.i(233915);
    this.acDy.setImageDrawable(null);
    setVisibility(8);
    AppMethodBeat.o(233915);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(233925);
    super.onFinishInflate();
    setOrientation(1);
    setGravity(17);
    AppMethodBeat.o(233925);
  }
  
  public final void setStickerPack(f paramf)
  {
    AppMethodBeat.i(233927);
    if (!s.p(this.yhU, paramf))
    {
      removeCallbacks(this.acDA);
      this.yhU = paramf;
      this.sXD.clear();
      if (paramf != null)
      {
        LinkedList localLinkedList = this.sXD;
        Object localObject1 = new LinkedList();
        Object localObject2 = paramf.acCw;
        if (localObject2 != null)
        {
          localObject2 = ((e)localObject2).acBX;
          if (localObject2 != null)
          {
            localObject2 = ((HashMap)localObject2).values();
            if (localObject2 != null) {
              ((LinkedList)localObject1).addAll((Collection)localObject2);
            }
          }
        }
        localObject2 = paramf.acCx;
        if (localObject2 != null)
        {
          localObject2 = ((e)localObject2).acBX;
          if (localObject2 != null)
          {
            localObject2 = ((HashMap)localObject2).values();
            if (localObject2 != null) {
              ((LinkedList)localObject1).addAll((Collection)localObject2);
            }
          }
        }
        paramf = paramf.acCy;
        if (paramf != null)
        {
          paramf = paramf.acBX;
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
        label253:
        while (((Iterator)localObject2).hasNext())
        {
          paramf = (d)((Iterator)localObject2).next();
          if (paramf.acBQ > 0) {}
          for (paramf = Integer.valueOf(paramf.acBQ);; paramf = null)
          {
            if (paramf == null) {
              break label253;
            }
            ((Collection)localObject1).add(paramf);
            break;
          }
        }
        localLinkedList.addAll((Collection)localObject1);
      }
      if (this.sXD.size() > 0)
      {
        this.acDz = 0;
        iWV();
        AppMethodBeat.o(233927);
        return;
      }
      iWW();
    }
    AppMethodBeat.o(233927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.sticker.ui.view.CaptureStickerHint
 * JD-Core Version:    0.7.0.1
 */