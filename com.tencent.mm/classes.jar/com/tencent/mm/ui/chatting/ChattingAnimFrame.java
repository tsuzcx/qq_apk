package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.az.d;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChattingAnimFrame
  extends FrameLayout
{
  private static String iWK = "";
  private int aqF;
  private int aqG;
  private int mScreenHeight = a.fk(getContext());
  private int ujn = 40;
  List<MMAnimateView> viE = new ArrayList();
  private int viF = 30;
  private int viG = 30;
  private boolean viH = false;
  private int viI = 0;
  private ArrayList<Integer> viJ = new ArrayList();
  
  public ChattingAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void GM(int paramInt)
  {
    if (paramInt <= 0) {
      y.w("MicroMsg.ChattingAnimFrame", "count is zero.");
    }
    for (;;)
    {
      return;
      int i = (int)(paramInt * 0.1D);
      if (this.viJ != null) {
        this.viJ.clear();
      }
      while (this.viJ.size() < i)
      {
        int j = (int)L(0.0F, paramInt);
        if (!this.viJ.contains(Integer.valueOf(j)))
        {
          this.viJ.add(Integer.valueOf(j));
          continue;
          this.viJ = new ArrayList();
        }
      }
    }
  }
  
  static float L(float paramFloat1, float paramFloat2)
  {
    return (float)Math.random() * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  private static String getDataEmojiPath()
  {
    if (bk.bl(iWK))
    {
      iWK = com.tencent.mm.compatible.util.e.dOQ.replace("/data/user/0", "/data/data");
      iWK += "/emoji";
    }
    return iWK;
  }
  
  public final void a(d paramd)
  {
    stop();
    if (paramd == null) {
      y.w("MicroMsg.ChattingAnimFrame", "egg info is null. ignore.");
    }
    for (;;)
    {
      return;
      Object localObject = getDataEmojiPath() + "/egg/" + paramd.ewD;
      if (!com.tencent.mm.vfs.e.bK((String)localObject))
      {
        y.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
        return;
      }
      setVisibility(0);
      label112:
      label127:
      int i;
      label201:
      int j;
      int k;
      boolean bool;
      if (paramd.ewF > 0)
      {
        this.viF = paramd.ewF;
        if (this.viF > 60) {
          this.viF = 60;
        }
        if (paramd.ewG <= 0) {
          break label431;
        }
        this.viG = paramd.ewG;
        if (paramd.maxSize <= 0) {
          break label440;
        }
        this.ujn = paramd.maxSize;
        y.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", new Object[] { Integer.valueOf(this.viF), Integer.valueOf(this.viG), Integer.valueOf(this.ujn), Integer.valueOf(paramd.ewE), Integer.valueOf(paramd.ewz) });
        l = 0L;
        GM(this.viF);
        i = 0;
        if (i >= this.viF) {
          break label552;
        }
        j = this.viG;
        k = this.ujn;
        j = (int)L(j, k);
        j = a.fromDPToPix(getContext(), j);
        k = paramd.ewE;
        if ((this.viJ == null) || (!this.viJ.contains(Integer.valueOf(i)))) {
          break label449;
        }
        bool = true;
        label269:
        ChattingAnimFrame.c localc = new ChattingAnimFrame.c(this, k, j, l, bool);
        MMAnimateView localMMAnimateView = new MMAnimateView(getContext());
        localMMAnimateView.setImageFilePath((String)localObject);
        localMMAnimateView.setAnimation(localc);
        localMMAnimateView.setLayerType(2, null);
        localc.viT = localMMAnimateView;
        localMMAnimateView.setLayoutParams(new FrameLayout.LayoutParams(localc.mSize, localc.mSize));
        this.viE.add(localMMAnimateView);
        addView(localMMAnimateView);
        j = paramd.ewE;
        k = this.viF;
      }
      switch (j)
      {
      default: 
      case 3: 
        for (l = (int)(L(0.0F, 4.0F) * 1000.0F);; l += ((Math.abs(i - k * 0.5D - 5.0D) / (k * 6) + 0.06D) * 1000.0D))
        {
          i += 1;
          break label201;
          this.viF = 30;
          break;
          label431:
          this.viG = 30;
          break label112;
          label440:
          this.ujn = 40;
          break label127;
          label449:
          bool = false;
          break label269;
        }
      }
      if (i < 2) {}
      for (long l = 800L + l;; l = ((Math.abs(i - k * 0.5D - 5.0D) / (k * 3) + 0.01D) * 1000.0D) + l) {
        break;
      }
      label552:
      if (this.viE != null)
      {
        paramd = this.viE.iterator();
        while (paramd.hasNext())
        {
          localObject = (View)paramd.next();
          if ((localObject != null) && ((((View)localObject).getAnimation() instanceof ChattingAnimFrame.c))) {
            ChattingAnimFrame.c.a((ChattingAnimFrame.c)((View)localObject).getAnimation());
          }
        }
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.aqG = getMeasuredHeight();
    this.aqF = getMeasuredWidth();
    y.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", new Object[] { Integer.valueOf(this.aqF), Integer.valueOf(this.aqG) });
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.aqG = (paramInt4 - paramInt2);
    this.aqF = (paramInt3 - paramInt1);
    if (this.aqG < this.mScreenHeight) {
      this.viH = true;
    }
    for (this.viI = (this.mScreenHeight - this.aqG);; this.viI = 0)
    {
      y.d("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", new Object[] { Integer.valueOf(this.aqF), Integer.valueOf(this.aqG), Boolean.valueOf(this.viH), Integer.valueOf(this.viI) });
      return;
      this.viH = false;
    }
  }
  
  public final void stop()
  {
    Iterator localIterator = this.viE.iterator();
    while (localIterator.hasNext())
    {
      MMAnimateView localMMAnimateView = (MMAnimateView)localIterator.next();
      localMMAnimateView.clearAnimation();
      localMMAnimateView.recycle();
    }
    removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingAnimFrame
 * JD-Core Version:    0.7.0.1
 */