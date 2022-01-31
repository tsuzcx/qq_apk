package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;

public final class k
{
  public ArrayList<k.a> hUi = new ArrayList();
  public int mRotateAngle = 0;
  public v2protocal pTa = new v2protocal(new ah(Looper.myLooper()));
  public boolean qbT = false;
  public int qbU;
  public int qbV;
  
  private final class b
  {
    public int qbW;
    public int qbX;
    public int qbY;
    public int qbZ;
    
    public b() {}
    
    public final String toString()
    {
      return String.format("topLeftX:%d, topLeftY:%d, rightBottomX:%d, rightBottomY:%d", new Object[] { Integer.valueOf(this.qbW), Integer.valueOf(this.qbX), Integer.valueOf(this.qbY), Integer.valueOf(this.qbZ) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.k
 * JD-Core Version:    0.7.0.1
 */