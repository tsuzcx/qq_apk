package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanProductInfo;", "", "()V", "age", "", "getAge", "()I", "setAge", "(I)V", "classId", "getClassId", "setClassId", "hit", "getHit", "setHit", "id", "getId", "setId", "prob", "", "getProb", "()F", "setProb", "(F)V", "shouldShow", "", "getShouldShow", "()Z", "setShouldShow", "(Z)V", "x1", "getX1", "setX1", "x2", "getX2", "setX2", "y1", "getY1", "setY1", "y2", "getY2", "setY2", "copy", "toCopy", "toDebugString", "", "toString", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanProductInfo
{
  private int age;
  private int classId;
  private int hit;
  private int id;
  private float prob;
  private boolean shouldShow;
  private float x1;
  private float x2;
  private float y1;
  private float y2;
  
  public final ScanProductInfo copy(ScanProductInfo paramScanProductInfo)
  {
    AppMethodBeat.i(314365);
    s.u(paramScanProductInfo, "toCopy");
    ScanProductInfo localScanProductInfo = (ScanProductInfo)this;
    localScanProductInfo.setX1(paramScanProductInfo.getX1());
    localScanProductInfo.setX2(paramScanProductInfo.getX2());
    localScanProductInfo.setY1(paramScanProductInfo.getY1());
    localScanProductInfo.setY2(paramScanProductInfo.getY2());
    localScanProductInfo.setProb(paramScanProductInfo.getProb());
    localScanProductInfo.setId(paramScanProductInfo.getId());
    localScanProductInfo.setAge(paramScanProductInfo.getAge());
    localScanProductInfo.setHit(paramScanProductInfo.getHit());
    localScanProductInfo.setClassId(paramScanProductInfo.getClassId());
    localScanProductInfo.setShouldShow(paramScanProductInfo.getShouldShow());
    paramScanProductInfo = (ScanProductInfo)this;
    AppMethodBeat.o(314365);
    return paramScanProductInfo;
  }
  
  public final int getAge()
  {
    return this.age;
  }
  
  public final int getClassId()
  {
    return this.classId;
  }
  
  public final int getHit()
  {
    return this.hit;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final float getProb()
  {
    return this.prob;
  }
  
  public final boolean getShouldShow()
  {
    return this.shouldShow;
  }
  
  public final float getX1()
  {
    return this.x1;
  }
  
  public final float getX2()
  {
    return this.x2;
  }
  
  public final float getY1()
  {
    return this.y1;
  }
  
  public final float getY2()
  {
    return this.y2;
  }
  
  public final void setAge(int paramInt)
  {
    this.age = paramInt;
  }
  
  public final void setClassId(int paramInt)
  {
    this.classId = paramInt;
  }
  
  public final void setHit(int paramInt)
  {
    this.hit = paramInt;
  }
  
  public final void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public final void setProb(float paramFloat)
  {
    this.prob = paramFloat;
  }
  
  public final void setShouldShow(boolean paramBoolean)
  {
    this.shouldShow = paramBoolean;
  }
  
  public final void setX1(float paramFloat)
  {
    this.x1 = paramFloat;
  }
  
  public final void setX2(float paramFloat)
  {
    this.x2 = paramFloat;
  }
  
  public final void setY1(float paramFloat)
  {
    this.y1 = paramFloat;
  }
  
  public final void setY2(float paramFloat)
  {
    this.y2 = paramFloat;
  }
  
  public final String toDebugString()
  {
    AppMethodBeat.i(314361);
    String str = "shouldShow: " + this.shouldShow + "\nlocation: " + this.x1 + ", " + this.y1 + ", " + this.x2 + ", " + this.y2 + "\nprob: " + this.prob + "\ntrackId: " + this.id + "\nage: " + this.age + "\nhit: " + this.hit + "\nclassId: " + this.classId + '\n';
    AppMethodBeat.o(314361);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(314357);
    String str = "ScanProductInfo: (" + this.x1 + ", " + this.y1 + "), (" + this.x2 + ", " + this.y2 + ") prob=" + this.prob + ", id=" + this.id + ", age=" + this.age + ", hit=" + this.hit + ", classId: " + this.classId + ", shouldShow=" + this.shouldShow;
    AppMethodBeat.o(314357);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ScanProductInfo
 * JD-Core Version:    0.7.0.1
 */