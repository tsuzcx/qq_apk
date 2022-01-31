package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class PhantomItem
{
  private int blendMode;
  private String dataPath;
  private String id;
  private String maskImage;
  private double opacity;
  private double scale;
  private double xAsin;
  private double xBcos;
  private double xK;
  private double xOffset;
  private double xPhase;
  private double[] xRange;
  private double xStep;
  private double xtime;
  private double yAsin;
  private double yBcos;
  private double yK;
  private double yOffset;
  private double yPhase;
  private double[] yRange;
  private double yStep;
  private double ytime;
  
  public PhantomItem()
  {
    AppMethodBeat.i(83510);
    this.id = "";
    this.maskImage = "";
    this.blendMode = 0;
    this.scale = 1.0D;
    this.opacity = 1.0D;
    this.xK = 0.0D;
    this.xAsin = 0.0D;
    this.xBcos = 0.0D;
    this.xPhase = 0.0D;
    this.xOffset = 0.0D;
    this.xStep = 0.0D;
    this.xRange = new double[] { 0.0D, 360.0D };
    this.xtime = 0.0D;
    this.yK = 0.0D;
    this.yAsin = 0.0D;
    this.yBcos = 0.0D;
    this.yPhase = 0.0D;
    this.yOffset = 0.0D;
    this.yStep = 0.0D;
    this.yRange = new double[] { 0.0D, 360.0D };
    this.ytime = 0.0D;
    AppMethodBeat.o(83510);
  }
  
  public int getBlendMode()
  {
    return this.blendMode;
  }
  
  public String getDataPath()
  {
    return this.dataPath;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getMaskImage()
  {
    return this.maskImage;
  }
  
  public double getOpacity()
  {
    return this.opacity;
  }
  
  public double getScale()
  {
    return this.scale;
  }
  
  public double getXtime()
  {
    return this.xtime;
  }
  
  public double getYtime()
  {
    return this.ytime;
  }
  
  public double getxAsin()
  {
    return this.xAsin / this.scale;
  }
  
  public double getxBcos()
  {
    return this.xBcos / this.scale;
  }
  
  public double getxK()
  {
    return this.xK;
  }
  
  public double getxOffset()
  {
    return (this.xOffset - 0.5D * (1.0D - this.scale)) / this.scale;
  }
  
  public double getxPhase()
  {
    return this.xPhase;
  }
  
  public double[] getxRange()
  {
    return this.xRange;
  }
  
  public double getxStep()
  {
    return this.xStep;
  }
  
  public double getyAsin()
  {
    return this.yAsin / this.scale;
  }
  
  public double getyBcos()
  {
    return this.yBcos / this.scale;
  }
  
  public double getyK()
  {
    return this.yK;
  }
  
  public double getyOffset()
  {
    return (this.yOffset - 0.5D * (1.0D - this.scale)) / this.scale;
  }
  
  public double getyPhase()
  {
    return this.yPhase;
  }
  
  public double[] getyRange()
  {
    return this.yRange;
  }
  
  public double getyStep()
  {
    return this.yStep;
  }
  
  public void makeXStep(long paramLong)
  {
    this.xtime += this.xStep * paramLong * 0.03D;
    if (this.xtime > this.xRange[1]) {
      this.xtime = this.xRange[0];
    }
  }
  
  public void makeYStep(long paramLong)
  {
    this.ytime += this.yStep * paramLong * 0.03D;
    if (this.ytime > this.yRange[1]) {
      this.ytime = this.yRange[0];
    }
  }
  
  public void setBlendMode(int paramInt)
  {
    this.blendMode = paramInt;
  }
  
  public void setDataPath(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setMaskImage(String paramString)
  {
    this.maskImage = paramString;
  }
  
  public void setOpacity(double paramDouble)
  {
    if (paramDouble > 1.0D)
    {
      this.opacity = 1.0D;
      return;
    }
    if (paramDouble < 0.0D)
    {
      this.opacity = 0.0D;
      return;
    }
    this.opacity = paramDouble;
  }
  
  public void setScale(double paramDouble)
  {
    if (paramDouble <= 0.0D)
    {
      this.scale = 1.0D;
      return;
    }
    this.scale = paramDouble;
  }
  
  public void setXtime(double paramDouble)
  {
    this.xtime = paramDouble;
  }
  
  public void setYtime(double paramDouble)
  {
    this.ytime = paramDouble;
  }
  
  public void setxAsin(double paramDouble)
  {
    this.xAsin = paramDouble;
  }
  
  public void setxBcos(double paramDouble)
  {
    this.xBcos = paramDouble;
  }
  
  public void setxK(double paramDouble)
  {
    this.xK = paramDouble;
  }
  
  public void setxOffset(double paramDouble)
  {
    this.xOffset = paramDouble;
  }
  
  public void setxPhase(double paramDouble)
  {
    this.xPhase = paramDouble;
  }
  
  public void setxRange(double[] paramArrayOfDouble)
  {
    this.xRange = paramArrayOfDouble;
  }
  
  public void setxStep(double paramDouble)
  {
    this.xStep = paramDouble;
  }
  
  public void setyAsin(double paramDouble)
  {
    this.yAsin = paramDouble;
  }
  
  public void setyBcos(double paramDouble)
  {
    this.yBcos = paramDouble;
  }
  
  public void setyK(double paramDouble)
  {
    this.yK = paramDouble;
  }
  
  public void setyOffset(double paramDouble)
  {
    this.yOffset = paramDouble;
  }
  
  public void setyPhase(double paramDouble)
  {
    this.yPhase = paramDouble;
  }
  
  public void setyRange(double[] paramArrayOfDouble)
  {
    this.yRange = paramArrayOfDouble;
  }
  
  public void setyStep(double paramDouble)
  {
    this.yStep = paramDouble;
  }
  
  public String toString()
  {
    AppMethodBeat.i(83511);
    String str = "PhantomItem{dataPath='" + this.dataPath + '\'' + ", id='" + this.id + '\'' + ", maskImage='" + this.maskImage + '\'' + ", blendMode=" + this.blendMode + ", scale=" + this.scale + ", opacity=" + this.opacity + ", xK=" + this.xK + ", xAsin=" + this.xAsin + ", xBcos=" + this.xBcos + ", xPhase=" + this.xPhase + ", xOffset=" + this.xOffset + ", xStep=" + this.xStep + ", xRange=" + Arrays.toString(this.xRange) + ", yK=" + this.yK + ", yAsin=" + this.yAsin + ", yBcos=" + this.yBcos + ", yPhase=" + this.yPhase + ", yOffset=" + this.yOffset + ", yStep=" + this.yStep + ", yRange=" + Arrays.toString(this.yRange) + '}';
    AppMethodBeat.o(83511);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.model.PhantomItem
 * JD-Core Version:    0.7.0.1
 */