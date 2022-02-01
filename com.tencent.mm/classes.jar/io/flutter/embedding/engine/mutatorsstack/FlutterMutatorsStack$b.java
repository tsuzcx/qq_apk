package io.flutter.embedding.engine.mutatorsstack;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FlutterMutatorsStack$b
{
  static
  {
    AppMethodBeat.i(214976);
    SPu = new b("CLIP_RECT", 0);
    SPv = new b("CLIP_RRECT", 1);
    SPw = new b("CLIP_PATH", 2);
    SPx = new b("TRANSFORM", 3);
    SPy = new b("OPACITY", 4);
    SPz = new b[] { SPu, SPv, SPw, SPx, SPy };
    AppMethodBeat.o(214976);
  }
  
  private FlutterMutatorsStack$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack.b
 * JD-Core Version:    0.7.0.1
 */