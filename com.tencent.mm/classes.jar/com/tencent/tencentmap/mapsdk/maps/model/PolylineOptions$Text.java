package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PolylineOptions$Text
{
  private Builder mBuilder;
  private final List<PolylineOptions.SegmentText> mSegmentTexts;
  
  private PolylineOptions$Text(Builder paramBuilder)
  {
    AppMethodBeat.i(173345);
    this.mSegmentTexts = Collections.unmodifiableList(paramBuilder.mTexts);
    this.mBuilder = paramBuilder;
    AppMethodBeat.o(173345);
  }
  
  public final PolylineOptions.TextPriority getPriority()
  {
    AppMethodBeat.i(173352);
    PolylineOptions.TextPriority localTextPriority = this.mBuilder.priority;
    AppMethodBeat.o(173352);
    return localTextPriority;
  }
  
  public final List<PolylineOptions.SegmentText> getSegmentTexts()
  {
    return this.mSegmentTexts;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(173348);
    int i = this.mBuilder.strokeColor;
    AppMethodBeat.o(173348);
    return i;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(173346);
    int i = this.mBuilder.textColor;
    AppMethodBeat.o(173346);
    return i;
  }
  
  public final int getTextSize()
  {
    AppMethodBeat.i(173350);
    int i = this.mBuilder.textSize;
    AppMethodBeat.o(173350);
    return i;
  }
  
  public final void setPriority(PolylineOptions.TextPriority paramTextPriority)
  {
    AppMethodBeat.i(173353);
    Builder.access$502(this.mBuilder, paramTextPriority);
    AppMethodBeat.o(173353);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(173349);
    Builder.access$302(this.mBuilder, paramInt);
    AppMethodBeat.o(173349);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(173347);
    Builder.access$202(this.mBuilder, paramInt);
    AppMethodBeat.o(173347);
  }
  
  public final void setTextSize(int paramInt)
  {
    AppMethodBeat.i(173351);
    Builder.access$402(this.mBuilder, paramInt);
    AppMethodBeat.o(173351);
  }
  
  public static final class Builder
  {
    private List<PolylineOptions.SegmentText> mTexts;
    private PolylineOptions.TextPriority priority;
    private int strokeColor;
    private int textColor;
    private int textSize;
    
    public Builder(PolylineOptions.SegmentText paramSegmentText)
    {
      AppMethodBeat.i(173340);
      this.mTexts = new ArrayList();
      this.textColor = -16777216;
      this.strokeColor = -1;
      this.textSize = 14;
      this.priority = PolylineOptions.TextPriority.HIGH;
      addSegmentText(paramSegmentText);
      AppMethodBeat.o(173340);
    }
    
    public Builder(List<PolylineOptions.SegmentText> paramList)
    {
      AppMethodBeat.i(173341);
      this.mTexts = new ArrayList();
      this.textColor = -16777216;
      this.strokeColor = -1;
      this.textSize = 14;
      this.priority = PolylineOptions.TextPriority.HIGH;
      addAllSegmentText(paramList);
      AppMethodBeat.o(173341);
    }
    
    public final Builder addAllSegmentText(List<PolylineOptions.SegmentText> paramList)
    {
      AppMethodBeat.i(173343);
      this.mTexts.addAll(paramList);
      AppMethodBeat.o(173343);
      return this;
    }
    
    public final Builder addSegmentText(PolylineOptions.SegmentText paramSegmentText)
    {
      AppMethodBeat.i(173342);
      this.mTexts.add(paramSegmentText);
      AppMethodBeat.o(173342);
      return this;
    }
    
    public final PolylineOptions.Text build()
    {
      AppMethodBeat.i(173344);
      PolylineOptions.Text localText = new PolylineOptions.Text(this, null);
      AppMethodBeat.o(173344);
      return localText;
    }
    
    public final Builder color(int paramInt)
    {
      this.textColor = paramInt;
      return this;
    }
    
    public final Builder priority(PolylineOptions.TextPriority paramTextPriority)
    {
      this.priority = paramTextPriority;
      return this;
    }
    
    public final Builder size(int paramInt)
    {
      this.textSize = paramInt;
      return this;
    }
    
    public final Builder strokeColor(int paramInt)
    {
      this.strokeColor = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text
 * JD-Core Version:    0.7.0.1
 */