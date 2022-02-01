package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PolylineOptions
{
  private static final int COLOR_DEFAULT_POLYLINE;
  private static final int LINE_DEFAULT_WIDTH = 9;
  private static final int LINE_UNINITIALIZED_WIDTH = -1;
  @Deprecated
  private static String sDefaultArrowTexture;
  private static String sDefaultColorTexture;
  private float alpha;
  private boolean boArraw;
  private boolean boIsAbove;
  private boolean boIsGeodes;
  private boolean boVisible;
  private PolylineOptions.ColorType colorType;
  private int eraseColor;
  private float fBorderWidth;
  private int fIndex;
  private float fwidth;
  private int[] iBorderColors;
  private int[] iColors;
  private int[] iIndexs;
  private int iLevel;
  private int iStrokeColor;
  private Animation initAnimation;
  private boolean lineCap;
  private int lineType;
  private final List<LatLng> listLatLngs;
  private boolean mAboveMaskLayer;
  private int mArrowSpacing;
  private BitmapDescriptor mArrowTexture;
  private boolean mClickable;
  private BitmapDescriptor mCustomeColorTexture;
  private IndoorInfo mIndoorInfo;
  private boolean mIsRoad;
  private Text mText;
  private List<Integer> pattern;
  @Deprecated
  private String strCustomerTextName;
  
  static
  {
    AppMethodBeat.i(181087);
    COLOR_DEFAULT_POLYLINE = Color.argb(200, 0, 163, 255);
    sDefaultColorTexture = "color_texture_flat_style.png";
    AppMethodBeat.o(181087);
  }
  
  public PolylineOptions()
  {
    AppMethodBeat.i(173357);
    this.boIsAbove = false;
    this.iColors = null;
    this.iBorderColors = new int[] { -16711936 };
    this.iIndexs = null;
    this.eraseColor = -7829368;
    this.lineType = 0;
    this.mCustomeColorTexture = BitmapDescriptorFactory.fromAsset(sDefaultColorTexture);
    this.mAboveMaskLayer = false;
    this.mIsRoad = true;
    this.mArrowTexture = null;
    this.colorType = PolylineOptions.ColorType.LINE_COLOR_NONE;
    this.iLevel = OverlayLevel.OverlayLevelAboveRoads;
    this.strCustomerTextName = sDefaultColorTexture;
    this.mArrowSpacing = 100;
    this.fwidth = -1.0F;
    this.iStrokeColor = COLOR_DEFAULT_POLYLINE;
    this.boVisible = true;
    this.boIsGeodes = false;
    this.listLatLngs = new ArrayList();
    this.alpha = 1.0F;
    this.lineCap = false;
    this.fIndex = 0;
    AppMethodBeat.o(173357);
  }
  
  private PolylineOptions geodesic(boolean paramBoolean)
  {
    this.boIsGeodes = paramBoolean;
    return this;
  }
  
  @Deprecated
  public static String getsDefaultArrowTexture()
  {
    return sDefaultArrowTexture;
  }
  
  private boolean isGeodesic()
  {
    return this.boIsGeodes;
  }
  
  @Deprecated
  public static void setDefaultArrowTexture(String paramString)
  {
    sDefaultArrowTexture = paramString;
  }
  
  public PolylineOptions aboveMaskLayer(boolean paramBoolean)
  {
    this.mAboveMaskLayer = paramBoolean;
    return this;
  }
  
  public PolylineOptions abovePillar(boolean paramBoolean)
  {
    this.boIsAbove = paramBoolean;
    if (this.mIndoorInfo != null) {
      this.boIsAbove = true;
    }
    return this;
  }
  
  public PolylineOptions add(LatLng paramLatLng, LatLng... paramVarArgs)
  {
    AppMethodBeat.i(173360);
    this.listLatLngs.add(paramLatLng);
    if (paramVarArgs != null) {
      add(paramVarArgs);
    }
    AppMethodBeat.o(173360);
    return this;
  }
  
  public PolylineOptions add(LatLng[] paramArrayOfLatLng)
  {
    AppMethodBeat.i(173361);
    if (paramArrayOfLatLng != null) {
      this.listLatLngs.addAll(Arrays.asList(paramArrayOfLatLng));
    }
    AppMethodBeat.o(173361);
    return this;
  }
  
  public PolylineOptions addAll(Iterable<LatLng> paramIterable)
  {
    AppMethodBeat.i(173362);
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        add((LatLng)paramIterable.next(), new LatLng[0]);
      }
    }
    AppMethodBeat.o(173362);
    return this;
  }
  
  public PolylineOptions alpha(float paramFloat)
  {
    this.alpha = paramFloat;
    return this;
  }
  
  public PolylineOptions animation(Animation paramAnimation)
  {
    this.initAnimation = paramAnimation;
    return this;
  }
  
  public PolylineOptions arrow(boolean paramBoolean)
  {
    this.boArraw = paramBoolean;
    return this;
  }
  
  public PolylineOptions arrowSpacing(int paramInt)
  {
    this.mArrowSpacing = paramInt;
    return this;
  }
  
  public PolylineOptions arrowTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    this.mArrowTexture = paramBitmapDescriptor;
    return this;
  }
  
  public PolylineOptions borderColor(int paramInt)
  {
    this.iBorderColors = new int[] { paramInt };
    return this;
  }
  
  public PolylineOptions borderColors(int[] paramArrayOfInt)
  {
    this.iBorderColors = paramArrayOfInt;
    return this;
  }
  
  public PolylineOptions borderWidth(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.fBorderWidth = 1.0F;
      return this;
    }
    this.fBorderWidth = paramFloat;
    return this;
  }
  
  public PolylineOptions clickable(boolean paramBoolean)
  {
    this.mClickable = paramBoolean;
    return this;
  }
  
  public PolylineOptions color(int paramInt)
  {
    this.iStrokeColor = paramInt;
    return this;
  }
  
  public PolylineOptions colorTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    this.mCustomeColorTexture = paramBitmapDescriptor;
    this.colorType = PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
    return this;
  }
  
  public PolylineOptions colorType(PolylineOptions.ColorType paramColorType)
  {
    this.colorType = paramColorType;
    return this;
  }
  
  public PolylineOptions colors(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.iColors = paramArrayOfInt1;
    this.iIndexs = paramArrayOfInt2;
    return this;
  }
  
  public PolylineOptions eraseColor(int paramInt)
  {
    this.eraseColor = paramInt;
    return this;
  }
  
  public float getAlpha()
  {
    return this.alpha;
  }
  
  public Animation getAnimation()
  {
    return this.initAnimation;
  }
  
  public int getArrowSpacing()
  {
    return this.mArrowSpacing;
  }
  
  public BitmapDescriptor getArrowTexture()
  {
    return this.mArrowTexture;
  }
  
  public int[] getBorderColors()
  {
    return this.iBorderColors;
  }
  
  public float getBorderWidth()
  {
    return this.fBorderWidth;
  }
  
  public int getColor()
  {
    return this.iStrokeColor;
  }
  
  public BitmapDescriptor getColorTexture()
  {
    return this.mCustomeColorTexture;
  }
  
  public PolylineOptions.ColorType getColorType()
  {
    return this.colorType;
  }
  
  public int[][] getColors()
  {
    if ((this.iColors == null) || (this.iIndexs == null)) {}
    while (this.iColors.length != this.iIndexs.length) {
      return null;
    }
    int i = this.iColors.length;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, i });
    arrayOfInt[0] = this.iColors;
    arrayOfInt[1] = this.iIndexs;
    return arrayOfInt;
  }
  
  public int getEraseColor()
  {
    return this.eraseColor;
  }
  
  public IndoorInfo getIndoorInfo()
  {
    return this.mIndoorInfo;
  }
  
  public int getLevel()
  {
    return this.iLevel;
  }
  
  public boolean getLineCap()
  {
    return this.lineCap;
  }
  
  public int getLineType()
  {
    return this.lineType;
  }
  
  public List<Integer> getPattern()
  {
    return this.pattern;
  }
  
  public List<LatLng> getPoints()
  {
    return this.listLatLngs;
  }
  
  public Text getText()
  {
    return this.mText;
  }
  
  @Deprecated
  public String getTextureName()
  {
    return this.strCustomerTextName;
  }
  
  public float getWidth()
  {
    return this.fwidth;
  }
  
  public int getZIndex()
  {
    return this.fIndex;
  }
  
  public PolylineOptions indoorInfo(IndoorInfo paramIndoorInfo)
  {
    if (paramIndoorInfo != null)
    {
      this.mIndoorInfo = paramIndoorInfo;
      this.boIsAbove = true;
    }
    return this;
  }
  
  public boolean isAboveMaskLayer()
  {
    return this.mAboveMaskLayer;
  }
  
  public boolean isAbovePillar()
  {
    return this.boIsAbove;
  }
  
  public boolean isArrow()
  {
    return this.boArraw;
  }
  
  public boolean isClickable()
  {
    return this.mClickable;
  }
  
  public boolean isRoad()
  {
    return this.mIsRoad;
  }
  
  public boolean isVisible()
  {
    return this.boVisible;
  }
  
  public PolylineOptions latLngs(List<LatLng> paramList)
  {
    AppMethodBeat.i(173359);
    if (paramList != null)
    {
      this.listLatLngs.clear();
      this.listLatLngs.addAll(paramList);
    }
    AppMethodBeat.o(173359);
    return this;
  }
  
  public PolylineOptions level(int paramInt)
  {
    if ((paramInt < OverlayLevel.OverlayLevelAboveRoads) || (paramInt > OverlayLevel.OverlayLevelAboveLabels)) {
      return this;
    }
    this.iLevel = paramInt;
    return this;
  }
  
  public PolylineOptions lineCap(boolean paramBoolean)
  {
    this.lineCap = paramBoolean;
    return this;
  }
  
  public PolylineOptions lineType(int paramInt)
  {
    this.lineType = paramInt;
    return this;
  }
  
  public PolylineOptions pattern(List<Integer> paramList)
  {
    this.pattern = paramList;
    return this;
  }
  
  public PolylineOptions road(boolean paramBoolean)
  {
    this.mIsRoad = paramBoolean;
    return this;
  }
  
  @Deprecated
  public PolylineOptions setColorTexture(String paramString)
  {
    AppMethodBeat.i(173365);
    this.strCustomerTextName = paramString;
    paramString = colorTexture(BitmapDescriptorFactory.fromAsset(paramString));
    AppMethodBeat.o(173365);
    return paramString;
  }
  
  @Deprecated
  public void setColors(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.iColors = paramArrayOfInt1;
    this.iIndexs = paramArrayOfInt2;
  }
  
  @Deprecated
  public void setLatLngs(List<LatLng> paramList)
  {
    AppMethodBeat.i(173358);
    latLngs(paramList);
    AppMethodBeat.o(173358);
  }
  
  @Deprecated
  public PolylineOptions setLineType(int paramInt)
  {
    AppMethodBeat.i(173364);
    PolylineOptions localPolylineOptions = lineType(paramInt);
    AppMethodBeat.o(173364);
    return localPolylineOptions;
  }
  
  public PolylineOptions text(Text paramText)
  {
    this.mText = paramText;
    return this;
  }
  
  public PolylineOptions updatePoints(Iterable<LatLng> paramIterable)
  {
    AppMethodBeat.i(181086);
    ArrayList localArrayList = new ArrayList();
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localArrayList.add((LatLng)paramIterable.next());
      }
    }
    this.listLatLngs.clear();
    addAll(localArrayList);
    AppMethodBeat.o(181086);
    return this;
  }
  
  public PolylineOptions visible(boolean paramBoolean)
  {
    this.boVisible = paramBoolean;
    return this;
  }
  
  public PolylineOptions width(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.fwidth = 9.0F;
      return this;
    }
    float f = paramFloat;
    if (paramFloat > 128.0F) {
      f = 128.0F;
    }
    this.fwidth = f;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(173366);
    if (paramParcel == null)
    {
      AppMethodBeat.o(173366);
      return;
    }
    paramParcel.writeFloat(this.fwidth);
    AppMethodBeat.o(173366);
  }
  
  public PolylineOptions zIndex(int paramInt)
  {
    AppMethodBeat.i(173363);
    this.fIndex = Math.max(0, paramInt);
    AppMethodBeat.o(173363);
    return this;
  }
  
  public static final class Colors
  {
    public static final int DARK_BLUE = 6;
    public static final int DASHED = 33;
    public static final int GRAYBLUE = 8;
    public static final int GREEN = 4;
    public static final int GREY = 0;
    public static final int LAST_BLUE = 20;
    public static final int LIGHT_BLUE = 1;
    public static final int LIVER_RED = 9;
    public static final int MID_BLUE = 5;
    public static final int RED = 2;
    public static final int TRANSPARENT = 7;
    public static final int WHITE_BLUE = 19;
    public static final int YELLOW = 3;
  }
  
  public static final class Text
  {
    private Builder mBuilder;
    private final List<PolylineOptions.SegmentText> mSegmentTexts;
    
    private Text(Builder paramBuilder)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions
 * JD-Core Version:    0.7.0.1
 */