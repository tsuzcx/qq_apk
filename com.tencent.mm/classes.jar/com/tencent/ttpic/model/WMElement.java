package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class WMElement
{
  public static final String ANIMATE_TYPE_DITHERING = "dithering";
  public static final String ANIMATE_TYPE_SCALE = "scale";
  private static final int EDIT_TYPE_EDITABLE = 1;
  protected static final String INT_D = "%d";
  protected static final String LOGIC = "[logic]";
  private static final String TAG = WMElement.class.getSimpleName();
  public static final int TEXT_SIZE_ADJUST = 1;
  public static final int TEXT_SIZE_FIXED = 0;
  private int active = 0;
  public String alignment;
  public PointF anchor;
  public String animateType;
  private Bitmap[] bitmaps = new Bitmap[2];
  public String color;
  public String curShaderBmp;
  public String curValue;
  protected Set<String> dataKeys = new HashSet();
  public String dataPath;
  public int edittype;
  public boolean emboss;
  public RectF finalContentRect = new RectF();
  protected boolean firstDrew = false;
  public String fmtstr;
  public boolean fontBold;
  public int fontFit;
  public boolean fontItalics;
  public String fontName;
  public float fontSize;
  public String fontTexture;
  public int frameDuration;
  public int frames;
  public int height;
  public String id;
  public String imgPath;
  private boolean isContentChanged = false;
  public String itemId;
  public int kern;
  public String lastValue;
  public WMLogic logic;
  public boolean multiRow;
  public int offsetX;
  public int offsetY;
  public String outerStrokeColor;
  public float outerStrokeSize;
  public PointF relativeAnchor;
  public String relativeID;
  public String shaderBmp;
  public String shadowColor;
  public float shadowDx;
  public float shadowDy;
  public float shadowSize;
  public String sid;
  public String strokeColor;
  public float strokeSize;
  public String userValue;
  public int vertical;
  public int width;
  public int wmtype;
  
  public void clear()
  {
    Bitmap[] arrayOfBitmap = this.bitmaps;
    int j = arrayOfBitmap.length;
    int i = 0;
    while (i < j)
    {
      Bitmap localBitmap = arrayOfBitmap[i];
      if (BitmapUtils.isLegal(localBitmap)) {
        localBitmap.recycle();
      }
      i += 1;
    }
    if (((this instanceof TextWMElement)) && (this.edittype == 1)) {
      LogicDataManager.getInstance().removeEditableWMElement(this);
    }
    this.dataKeys.clear();
    this.lastValue = null;
    this.firstDrew = false;
  }
  
  public Bitmap getBitmap()
  {
    return this.bitmaps[this.active];
  }
  
  public Bitmap getIdleBitmap()
  {
    return this.bitmaps[(this.active ^ 0x1)];
  }
  
  public void init()
  {
    clear();
    this.bitmaps[0] = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
    this.bitmaps[1] = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
    if (((this instanceof TextWMElement)) && (this.edittype == 1)) {
      LogicDataManager.getInstance().addEditableWMElement(this);
    }
    Pattern localPattern = Pattern.compile("(\\[.+?\\])");
    if (this.wmtype == WMElement.WMType.TEXT.value) {}
    for (Object localObject = this.fmtstr;; localObject = this.imgPath)
    {
      localObject = localPattern.matcher((CharSequence)localObject);
      while (((Matcher)localObject).find()) {
        if (((Matcher)localObject).groupCount() > 0) {
          this.dataKeys.add(((Matcher)localObject).group());
        }
      }
    }
    if ((this.logic != null) && (!TextUtils.isEmpty(this.logic.data))) {
      this.dataKeys.add(this.logic.data);
    }
    if (this.dataKeys.contains("[db]")) {
      LogicDataManager.getInstance().setNeedDB(true);
    }
    if (!TextUtils.isEmpty(this.shaderBmp)) {
      this.curShaderBmp = String.format(this.shaderBmp, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public boolean isContentChanged()
  {
    return this.isContentChanged;
  }
  
  public void reset() {}
  
  public void setContentChanged(boolean paramBoolean)
  {
    this.isContentChanged = paramBoolean;
  }
  
  public void setDataPath(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public void setIdleBitmap(Bitmap paramBitmap)
  {
    this.bitmaps[(this.active ^ 0x1)] = paramBitmap;
  }
  
  public void swapActiveBitmap()
  {
    this.active ^= 0x1;
  }
  
  public abstract boolean updateBitmap(long paramLong, boolean paramBoolean);
  
  public abstract boolean updateBitmap(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.model.WMElement
 * JD-Core Version:    0.7.0.1
 */