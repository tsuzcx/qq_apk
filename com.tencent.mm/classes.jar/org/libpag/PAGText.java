package org.libpag;

import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PAGText
{
  public boolean applyFill;
  public boolean applyStroke;
  public int backgroundAlpha;
  public int backgroundColor;
  public float baselineShift;
  public boolean boxText;
  public RectF boxTextRect;
  public boolean fauxBold;
  public boolean fauxItalic;
  public int fillColor;
  public float firstBaseLine;
  public String fontFamily;
  public float fontSize;
  public String fontStyle;
  public int justification;
  public float leading;
  public int strokeColor;
  public boolean strokeOverFill;
  public float strokeWidth;
  public String text;
  public float tracking;
  
  public PAGText()
  {
    AppMethodBeat.i(195287);
    this.applyFill = true;
    this.applyStroke = false;
    this.baselineShift = 0.0F;
    this.boxText = false;
    this.boxTextRect = new RectF();
    this.firstBaseLine = 0.0F;
    this.fauxBold = false;
    this.fauxItalic = false;
    this.fillColor = 0;
    this.fontFamily = "";
    this.fontStyle = "";
    this.fontSize = 24.0F;
    this.strokeColor = 0;
    this.strokeOverFill = true;
    this.strokeWidth = 1.0F;
    this.text = "";
    this.justification = 0;
    this.leading = 0.0F;
    this.tracking = 0.0F;
    AppMethodBeat.o(195287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.libpag.PAGText
 * JD-Core Version:    0.7.0.1
 */