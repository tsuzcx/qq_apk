package com.tencent.ttpic.particle;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TexturedColoredVertex
{
  public Vector4 color;
  public Vector2 texture;
  public Vector2 vertex;
  
  public TexturedColoredVertex()
  {
    AppMethodBeat.i(83640);
    this.vertex = new Vector2();
    this.texture = new Vector2();
    this.color = new Vector4();
    AppMethodBeat.o(83640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.particle.TexturedColoredVertex
 * JD-Core Version:    0.7.0.1
 */