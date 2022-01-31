package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.d;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChattingAnimFrame
  extends FrameLayout
{
  private static String lfW = "";
  private int asY;
  private int asZ;
  private int mScreenHeight;
  private int yrn;
  private int zxA;
  private boolean zxB;
  private int zxC;
  private ArrayList<Integer> zxD;
  List<MMAnimateView> zxy;
  private int zxz;
  
  public ChattingAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(30518);
    this.zxy = new ArrayList();
    this.zxz = 30;
    this.zxA = 30;
    this.yrn = 40;
    this.zxB = false;
    this.zxC = 0;
    this.zxD = new ArrayList();
    this.mScreenHeight = a.gx(getContext());
    AppMethodBeat.o(30518);
  }
  
  private void Pn(int paramInt)
  {
    AppMethodBeat.i(30522);
    if (paramInt <= 0)
    {
      ab.w("MicroMsg.ChattingAnimFrame", "count is zero.");
      AppMethodBeat.o(30522);
      return;
    }
    int i = (int)(paramInt * 0.1D);
    if (this.zxD != null) {
      this.zxD.clear();
    }
    while (this.zxD.size() < i)
    {
      int j = (int)ab(0.0F, paramInt);
      if (!this.zxD.contains(Integer.valueOf(j)))
      {
        this.zxD.add(Integer.valueOf(j));
        continue;
        this.zxD = new ArrayList();
      }
    }
    AppMethodBeat.o(30522);
  }
  
  static float ab(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(30524);
    float f = (float)Math.random();
    AppMethodBeat.o(30524);
    return f * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  private static String getDataEmojiPath()
  {
    AppMethodBeat.i(30517);
    if (bo.isNullOrNil(lfW))
    {
      lfW = com.tencent.mm.compatible.util.e.eQw.replace("/data/user/0", "/data/data");
      lfW += "/emoji";
    }
    String str = lfW;
    AppMethodBeat.o(30517);
    return str;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(30521);
    stop();
    if (paramd == null)
    {
      ab.w("MicroMsg.ChattingAnimFrame", "egg info is null. ignore.");
      AppMethodBeat.o(30521);
      return;
    }
    Object localObject = getDataEmojiPath() + "/egg/" + paramd.fMs;
    if (!com.tencent.mm.vfs.e.cN((String)localObject))
    {
      ab.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
      AppMethodBeat.o(30521);
      return;
    }
    setVisibility(0);
    label130:
    label145:
    int i;
    label219:
    int j;
    int k;
    boolean bool;
    if (paramd.fMu > 0)
    {
      this.zxz = paramd.fMu;
      if (this.zxz > 60) {
        this.zxz = 60;
      }
      if (paramd.fMv <= 0) {
        break label451;
      }
      this.zxA = paramd.fMv;
      if (paramd.maxSize <= 0) {
        break label460;
      }
      this.yrn = paramd.maxSize;
      ab.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", new Object[] { Integer.valueOf(this.zxz), Integer.valueOf(this.zxA), Integer.valueOf(this.yrn), Integer.valueOf(paramd.fMt), Integer.valueOf(paramd.cFd) });
      l = 0L;
      Pn(this.zxz);
      i = 0;
      if (i >= this.zxz) {
        break label572;
      }
      j = this.zxA;
      k = this.yrn;
      j = (int)ab(j, k);
      j = a.fromDPToPix(getContext(), j);
      k = paramd.fMt;
      if ((this.zxD == null) || (!this.zxD.contains(Integer.valueOf(i)))) {
        break label469;
      }
      bool = true;
      label287:
      ChattingAnimFrame.c localc = new ChattingAnimFrame.c(this, k, j, l, bool);
      MMAnimateView localMMAnimateView = new MMAnimateView(getContext());
      localMMAnimateView.setImageFilePath((String)localObject);
      localMMAnimateView.setAnimation(localc);
      localMMAnimateView.setLayerType(2, null);
      localc.zxT = localMMAnimateView;
      localMMAnimateView.setLayoutParams(new FrameLayout.LayoutParams(localc.mSize, localc.mSize));
      this.zxy.add(localMMAnimateView);
      addView(localMMAnimateView);
      j = paramd.fMt;
      k = this.zxz;
    }
    switch (j)
    {
    default: 
    case 3: 
      for (l = (int)(ab(0.0F, 4.0F) * 1000.0F);; l += ((Math.abs(i - k * 0.5D - 5.0D) / (k * 6) + 0.06D) * 1000.0D))
      {
        i += 1;
        break label219;
        this.zxz = 30;
        break;
        label451:
        this.zxA = 30;
        break label130;
        label460:
        this.yrn = 40;
        break label145;
        label469:
        bool = false;
        break label287;
      }
    }
    if (i < 2) {}
    for (long l = 800L + l;; l = ((Math.abs(i - k * 0.5D - 5.0D) / (k * 3) + 0.01D) * 1000.0D) + l) {
      break;
    }
    label572:
    if (this.zxy != null)
    {
      paramd = this.zxy.iterator();
      while (paramd.hasNext())
      {
        localObject = (View)paramd.next();
        if ((localObject != null) && ((((View)localObject).getAnimation() instanceof ChattingAnimFrame.c))) {
          ChattingAnimFrame.c.a((ChattingAnimFrame.c)((View)localObject).getAnimation());
        }
      }
    }
    AppMethodBeat.o(30521);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(30519);
    super.onFinishInflate();
    this.asZ = getMeasuredHeight();
    this.asY = getMeasuredWidth();
    ab.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", new Object[] { Integer.valueOf(this.asY), Integer.valueOf(this.asZ) });
    AppMethodBeat.o(30519);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(30520);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.asZ = (paramInt4 - paramInt2);
    this.asY = (paramInt3 - paramInt1);
    if (this.asZ < this.mScreenHeight) {
      this.zxB = true;
    }
    for (this.zxC = (this.mScreenHeight - this.asZ);; this.zxC = 0)
    {
      ab.d("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", new Object[] { Integer.valueOf(this.asY), Integer.valueOf(this.asZ), Boolean.valueOf(this.zxB), Integer.valueOf(this.zxC) });
      AppMethodBeat.o(30520);
      return;
      this.zxB = false;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(30523);
    Iterator localIterator = this.zxy.iterator();
    while (localIterator.hasNext())
    {
      MMAnimateView localMMAnimateView = (MMAnimateView)localIterator.next();
      localMMAnimateView.clearAnimation();
      localMMAnimateView.recycle();
    }
    removeAllViews();
    AppMethodBeat.o(30523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingAnimFrame
 * JD-Core Version:    0.7.0.1
 */