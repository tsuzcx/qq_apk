package io.flutter.embedding.engine.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public final String aari;
  public final String aarj;
  public final String aark;
  public final String aarl;
  public final String aarm;
  public final String aarn;
  public final boolean aaro;
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    AppMethodBeat.i(255938);
    String str = paramString1;
    if (paramString1 == null) {
      str = "libapp.so";
    }
    this.aari = str;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "vm_snapshot_data";
    }
    this.aarj = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "isolate_snapshot_data";
    }
    this.aark = paramString1;
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "flutter_assets";
    }
    this.aarl = paramString1;
    this.aarn = paramString6;
    paramString1 = paramString5;
    if (paramString5 == null) {
      paramString1 = "";
    }
    this.aarm = paramString1;
    this.aaro = paramBoolean;
    AppMethodBeat.o(255938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.a.b
 * JD-Core Version:    0.7.0.1
 */