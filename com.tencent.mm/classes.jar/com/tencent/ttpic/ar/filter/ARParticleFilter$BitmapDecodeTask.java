package com.tencent.ttpic.ar.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.oscarcamera.particlesystem.Sprite;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class ARParticleFilter$BitmapDecodeTask
  extends AsyncTask<Void, Void, Void>
{
  ARParticleFilter$BitmapDecodeTask(ARParticleFilter paramARParticleFilter) {}
  
  private void preCalTexCoords(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(81649);
    int i = paramInt3 / paramInt5;
    int j = paramInt2 / paramInt4;
    float f1 = paramInt4 * 1.0F / paramInt2;
    float f2 = paramInt5 * 1.0F / paramInt3;
    ARParticleFilter.access$000(this.this$0).add(paramInt1, new ArrayList());
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      paramInt3 = 0;
      while (paramInt3 < j)
      {
        PointF localPointF1 = new PointF(paramInt3 * f1, paramInt2 * f2);
        PointF localPointF2 = new PointF(localPointF1.x, localPointF1.y + f2);
        PointF localPointF3 = new PointF(localPointF1.x + f1, localPointF1.y);
        PointF localPointF4 = new PointF(localPointF3.x, localPointF1.y + f2);
        ARParticleFilter.TexCoord localTexCoord = new ARParticleFilter.TexCoord(this.this$0);
        localTexCoord.texCoord[0] = localPointF3.x;
        localTexCoord.texCoord[1] = localPointF3.y;
        localTexCoord.texCoord[2] = localPointF4.x;
        localTexCoord.texCoord[3] = localPointF4.y;
        localTexCoord.texCoord[4] = localPointF2.x;
        localTexCoord.texCoord[5] = localPointF2.y;
        localTexCoord.texCoord[6] = localPointF3.x;
        localTexCoord.texCoord[7] = localPointF3.y;
        localTexCoord.texCoord[8] = localPointF2.x;
        localTexCoord.texCoord[9] = localPointF2.y;
        localTexCoord.texCoord[10] = localPointF1.x;
        localTexCoord.texCoord[11] = localPointF1.y;
        ((ArrayList)ARParticleFilter.access$000(this.this$0).get(paramInt1)).add(localTexCoord);
        paramInt3 += 1;
      }
      paramInt2 += 1;
    }
    AppMethodBeat.o(81649);
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    AppMethodBeat.i(81650);
    if ((ARParticleFilter.access$100(this.this$0) != null) && (ARParticleFilter.access$200(this.this$0) != null))
    {
      int i = 0;
      if ((i < ARParticleFilter.access$100(this.this$0).size()) && (i < ARParticleFilter.access$200(this.this$0).size()))
      {
        Sprite localSprite = (Sprite)ARParticleFilter.access$100(this.this$0).get(i);
        paramVarArgs = ARParticleFilter.access$300(this.this$0) + File.separator + (String)ARParticleFilter.access$200(this.this$0).get(i) + File.separator + localSprite.path;
        if (paramVarArgs.startsWith("assets://")) {}
        for (paramVarArgs = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(paramVarArgs), 2147483647, 2147483647);; paramVarArgs = BitmapUtils.decodeSampledBitmapFromFile(paramVarArgs, 2147483647, 2147483647))
        {
          if (ARParticleFilter.access$400(this.this$0, paramVarArgs))
          {
            preCalTexCoords(i, paramVarArgs.getWidth(), paramVarArgs.getHeight(), localSprite.width, localSprite.height);
            ARParticleFilter.access$500(this.this$0)[i] = paramVarArgs;
          }
          i += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(81650);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.ar.filter.ARParticleFilter.BitmapDecodeTask
 * JD-Core Version:    0.7.0.1
 */