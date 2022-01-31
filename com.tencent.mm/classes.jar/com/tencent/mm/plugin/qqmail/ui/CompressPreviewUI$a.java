package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class CompressPreviewUI$a
{
  boolean aqX;
  String id;
  String name;
  String pMu;
  String size;
  int type;
  
  public CompressPreviewUI$a(CompressPreviewUI paramCompressPreviewUI, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(68245);
    this.id = paramString1;
    this.name = paramString2;
    paramCompressPreviewUI = paramString3;
    if (paramString3 == null) {
      paramCompressPreviewUI = "";
    }
    this.pMu = paramCompressPreviewUI;
    this.type = paramInt;
    this.size = paramString4;
    this.aqX = paramBoolean;
    AppMethodBeat.o(68245);
  }
  
  public final boolean cek()
  {
    return this.type == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.a
 * JD-Core Version:    0.7.0.1
 */