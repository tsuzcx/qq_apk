package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.util.VideoBitmapUtil;
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
  public String alignment;
  public PointF anchor;
  public String animateType;
  public Bitmap bitmap;
  public String color;
  public String curValue;
  protected Set<String> dataKeys = new HashSet();
  public int edittype;
  public RectF finalContentRect = new RectF();
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
  public boolean isContentChanged = true;
  public String itemId;
  public int kern;
  public String lastValue;
  public WMLogic logic;
  public int offsetX;
  public int offsetY;
  public PointF relativeAnchor;
  public String relativeID;
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
    if (VideoBitmapUtil.isLegal(this.bitmap)) {
      this.bitmap.recycle();
    }
    if (((this instanceof TextWMElement)) && (this.edittype == 1)) {
      LogicDataManager.getInstance().removeEditableWMElement(this);
    }
  }
  
  public Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public void init()
  {
    this.dataKeys.clear();
    this.bitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
    if (((this instanceof TextWMElement)) && (this.edittype == 1)) {
      LogicDataManager.getInstance().addEditableWMElement(this);
    }
    Pattern localPattern = Pattern.compile("(\\[.*?\\])");
    if (this.wmtype == WMElement.WMType.TEXT.value) {}
    for (Object localObject = this.fmtstr;; localObject = this.imgPath)
    {
      localObject = localPattern.matcher((CharSequence)localObject);
      while (((Matcher)localObject).find()) {
        if (((Matcher)localObject).groupCount() > 0) {
          this.dataKeys.add(((Matcher)localObject).group(0));
        }
      }
    }
    if ((this.logic != null) && (!TextUtils.isEmpty(this.logic.data))) {
      this.dataKeys.add(this.logic.data);
    }
    if (this.dataKeys.contains("[db]")) {
      LogicDataManager.getInstance().setNeedDB(true);
    }
  }
  
  public abstract boolean isContentChanged();
  
  public void reset() {}
  
  public abstract void updateBitmap(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.model.WMElement
 * JD-Core Version:    0.7.0.1
 */