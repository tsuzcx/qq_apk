package io.flutter.embedding.android;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum i
{
  static
  {
    AppMethodBeat.i(215038);
    SNO = new i("surface", 0);
    SNP = new i("texture", 1);
    SNQ = new i("image", 2);
    SNR = new i[] { SNO, SNP, SNQ };
    AppMethodBeat.o(215038);
  }
  
  private i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.i
 * JD-Core Version:    0.7.0.1
 */