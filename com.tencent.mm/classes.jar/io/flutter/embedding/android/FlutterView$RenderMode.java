package io.flutter.embedding.android;

import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public enum FlutterView$RenderMode
{
  static
  {
    AppMethodBeat.i(10024);
    surface = new RenderMode("surface", 0);
    texture = new RenderMode("texture", 1);
    image = new RenderMode("image", 2);
    $VALUES = new RenderMode[] { surface, texture, image };
    AppMethodBeat.o(10024);
  }
  
  private FlutterView$RenderMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterView.RenderMode
 * JD-Core Version:    0.7.0.1
 */