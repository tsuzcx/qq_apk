package com.tencent.ttpic.util.youtu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFaceAttr.PTExpression;

class GestureDetector$1
  implements Runnable
{
  GestureDetector$1(GestureDetector paramGestureDetector, byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    AppMethodBeat.i(84348);
    GestureDetector.access$002(true);
    GestureDetector localGestureDetector = this.this$0;
    byte[] arrayOfByte = this.val$image;
    int i = this.val$width;
    int j = this.val$height;
    float[] arrayOfFloat1 = this.this$0.mDetectorOutputXMin;
    float[] arrayOfFloat2 = this.this$0.mDetectorOutputYMin;
    float[] arrayOfFloat3 = this.this$0.mDetectorOutputXMax;
    float[] arrayOfFloat4 = this.this$0.mDetectorOutputYMax;
    float[] arrayOfFloat5 = this.this$0.mDetectorOutputConfidence;
    int[] arrayOfInt = this.this$0.mLabelIndex;
    float[] arrayOfFloat6 = this.this$0.mClassifyOutputConfidence;
    if (localGestureDetector.Gesture(arrayOfByte, i, j, 2, arrayOfFloat1, arrayOfFloat2, arrayOfFloat3, arrayOfFloat4, arrayOfFloat5, new int[] { 0 }, arrayOfInt, arrayOfFloat6) == true)
    {
      i = 0;
      if (i <= 0)
      {
        if ((PTFaceAttr.PTExpression.HAND_LABEL_HEART.ordinal() <= this.this$0.mLabelIndex[0] + 20) && (this.this$0.mLabelIndex[0] + 20 <= PTFaceAttr.PTExpression.HAND_LABEL_GOOD_FORTUNE.ordinal())) {
          if (this.this$0.mClassifyOutputConfidence[0] <= GestureDetector.access$100()[this.this$0.mLabelIndex[0]]) {
            break label245;
          }
        }
        label245:
        for (GestureDetector.access$200(this.this$0).value = (this.this$0.mLabelIndex[0] + 201);; GestureDetector.access$200(this.this$0).value = 200)
        {
          GestureDetector.access$200(this.this$0).lostStartTimestamp = -1L;
          i += 1;
          break;
        }
      }
      this.this$0.updateActionCount();
    }
    for (;;)
    {
      GestureDetector.access$002(false);
      AppMethodBeat.o(84348);
      return;
      GestureDetector.access$200(this.this$0).value = 200;
      this.this$0.mDetectorOutputXMin[0] = 0.0F;
      this.this$0.mDetectorOutputYMin[0] = 0.0F;
      this.this$0.mDetectorOutputXMax[0] = 0.0F;
      this.this$0.mDetectorOutputYMax[0] = 0.0F;
      this.this$0.updateActionCount();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.GestureDetector.1
 * JD-Core Version:    0.7.0.1
 */