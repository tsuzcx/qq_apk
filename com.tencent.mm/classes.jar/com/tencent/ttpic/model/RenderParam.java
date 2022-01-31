package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class RenderParam
{
  public String id;
  public float[] position;
  public float[] texAnchor;
  public float[] texCords;
  public float[] texRotate;
  public float texScale;
  public int texture;
  
  public RenderParam()
  {
    AppMethodBeat.i(83512);
    this.position = new float[12];
    this.texCords = new float[12];
    this.texAnchor = new float[2];
    this.texRotate = new float[] { 0.0F, 0.0F, 0.0F };
    this.texScale = 1.0F;
    AppMethodBeat.o(83512);
  }
  
  public RenderParam copy()
  {
    AppMethodBeat.i(83513);
    RenderParam localRenderParam = new RenderParam();
    localRenderParam.id = this.id;
    System.arraycopy(this.position, 0, localRenderParam.position, 0, this.position.length);
    System.arraycopy(this.texCords, 0, localRenderParam.texCords, 0, this.texCords.length);
    System.arraycopy(this.texAnchor, 0, localRenderParam.texAnchor, 0, this.texAnchor.length);
    System.arraycopy(this.texRotate, 0, localRenderParam.texRotate, 0, this.texRotate.length);
    localRenderParam.texScale = this.texScale;
    localRenderParam.texture = this.texture;
    AppMethodBeat.o(83513);
    return localRenderParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.model.RenderParam
 * JD-Core Version:    0.7.0.1
 */