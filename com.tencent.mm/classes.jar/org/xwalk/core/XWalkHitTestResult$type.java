package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum XWalkHitTestResult$type
{
  static
  {
    AppMethodBeat.i(85644);
    UNKNOWN_TYPE = new type("UNKNOWN_TYPE", 0);
    ANCHOR_TYPE = new type("ANCHOR_TYPE", 1);
    PHONE_TYPE = new type("PHONE_TYPE", 2);
    GEO_TYPE = new type("GEO_TYPE", 3);
    EMAIL_TYPE = new type("EMAIL_TYPE", 4);
    IMAGE_TYPE = new type("IMAGE_TYPE", 5);
    IMAGE_ANCHOR_TYPE = new type("IMAGE_ANCHOR_TYPE", 6);
    SRC_ANCHOR_TYPE = new type("SRC_ANCHOR_TYPE", 7);
    SRC_IMAGE_ANCHOR_TYPE = new type("SRC_IMAGE_ANCHOR_TYPE", 8);
    EDIT_TEXT_TYPE = new type("EDIT_TEXT_TYPE", 9);
    $VALUES = new type[] { UNKNOWN_TYPE, ANCHOR_TYPE, PHONE_TYPE, GEO_TYPE, EMAIL_TYPE, IMAGE_TYPE, IMAGE_ANCHOR_TYPE, SRC_ANCHOR_TYPE, SRC_IMAGE_ANCHOR_TYPE, EDIT_TEXT_TYPE };
    AppMethodBeat.o(85644);
  }
  
  private XWalkHitTestResult$type() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.xwalk.core.XWalkHitTestResult.type
 * JD-Core Version:    0.7.0.1
 */