package io.flutter.embedding.android;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum RenderMode
{
  static
  {
    AppMethodBeat.i(190521);
    surface = new RenderMode("surface", 0);
    texture = new RenderMode("texture", 1);
    image = new RenderMode("image", 2);
    $VALUES = new RenderMode[] { surface, texture, image };
    AppMethodBeat.o(190521);
  }
  
  private RenderMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.android.RenderMode
 * JD-Core Version:    0.7.0.1
 */