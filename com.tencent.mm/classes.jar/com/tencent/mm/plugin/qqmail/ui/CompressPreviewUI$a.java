package com.tencent.mm.plugin.qqmail.ui;

final class CompressPreviewUI$a
{
  boolean aoD;
  String id;
  String name;
  String nhg;
  String size;
  int type;
  
  public CompressPreviewUI$a(CompressPreviewUI paramCompressPreviewUI, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean)
  {
    this.id = paramString1;
    this.name = paramString2;
    paramCompressPreviewUI = paramString3;
    if (paramString3 == null) {
      paramCompressPreviewUI = "";
    }
    this.nhg = paramCompressPreviewUI;
    this.type = paramInt;
    this.size = paramString4;
    this.aoD = paramBoolean;
  }
  
  public final boolean btY()
  {
    return this.type == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.a
 * JD-Core Version:    0.7.0.1
 */