package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.q;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.pluginsdk.ui.d.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public class AddressView
  extends View
  implements a.a, d.a
{
  private static final String TAG = "MicroMsg.AddressView";
  public final int AVATAR_LAYOUT_WIDTH = getResources().getDimensionPixelSize(R.f.ContactAvatarSize);
  public final int AVATAR_PADDING;
  public final int AVATAR_START_POS;
  public final int AVATAR_WIDTH = getResources().getDimensionPixelSize(R.f.ContactAvatarSize);
  public final int COMMON_PADDING;
  public final int DESCRIPTION_PADDING;
  public final float DESCRIPTION_TEXT_SIZE;
  public final float NAME_TEXT_SIZE;
  public final int TEXT_TOP_PADDING;
  public final int WEIBO_ICON_SIZE;
  Drawable avatarDrawable;
  Context context;
  float density;
  String description;
  private Paint.FontMetrics descriptionFontMetrics;
  private TextPaint descriptionPaint;
  CharSequence destNickName;
  private TextPaint displayNamePaint;
  Drawable drawable = getResources().getDrawable(R.g.signature_bg);
  private Paint.FontMetrics fm;
  boolean imageViewHasSetBounds;
  StaticLayout layout;
  boolean nameIsSpanned;
  boolean needInvaildate;
  boolean needInvaliate;
  BitmapDrawable needMask;
  boolean needUpdatePostion = true;
  CharSequence nickName;
  private int nickNameCurrentTextColor;
  int nickNameHeight;
  private ColorStateList nickNameTextColor;
  int nickNameWidth;
  StaticLayout nickNamelayout;
  int nickWidth;
  float textBaseY;
  
  public AddressView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public AddressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AddressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.NAME_TEXT_SIZE = com.tencent.mm.cb.a.aa(paramContext, R.f.NormalTextSize);
    this.DESCRIPTION_TEXT_SIZE = com.tencent.mm.cb.a.aa(paramContext, R.f.SmallestTextSize);
    this.WEIBO_ICON_SIZE = getResources().getDimensionPixelSize(R.f.SmallIconSize);
    this.AVATAR_START_POS = 0;
    this.AVATAR_PADDING = getResources().getDimensionPixelSize(R.f.BigPadding);
    this.COMMON_PADDING = 0;
    this.DESCRIPTION_PADDING = (getResources().getDimensionPixelSize(R.f.LargestPadding) * 2);
    this.TEXT_TOP_PADDING = getResources().getDimensionPixelSize(R.f.SmallestPadding);
    if (this.displayNamePaint == null) {
      this.displayNamePaint = generateOnePaint();
    }
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private TextPaint generateDescriptionPaint()
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setAntiAlias(true);
    localTextPaint.setTextSize(this.DESCRIPTION_TEXT_SIZE);
    localTextPaint.setColor(getResources().getColor(R.e.hint_text_color));
    return localTextPaint;
  }
  
  private TextPaint generateOnePaint()
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setAntiAlias(true);
    localTextPaint.setTextSize(this.NAME_TEXT_SIZE);
    localTextPaint.setColor(getResources().getColor(R.e.normal_text_color));
    return localTextPaint;
  }
  
  private Paint.FontMetrics getFontMetrics()
  {
    if (this.displayNamePaint == null) {
      this.displayNamePaint = generateOnePaint();
    }
    if (this.fm == null) {
      this.fm = this.displayNamePaint.getFontMetrics();
    }
    return this.fm;
  }
  
  private void installAccessibilityDelegate()
  {
    q.a(this, new AddressView.1(this));
  }
  
  private void updateDrawableBounds()
  {
    if (this.avatarDrawable == null) {
      return;
    }
    this.avatarDrawable.setBounds(this.AVATAR_START_POS, (getHeight() - this.AVATAR_WIDTH) / 2, this.AVATAR_START_POS + this.AVATAR_WIDTH, (getHeight() - this.AVATAR_WIDTH) / 2 + this.AVATAR_WIDTH);
    this.needMask.setBounds(this.AVATAR_START_POS + this.AVATAR_WIDTH - this.needMask.getIntrinsicWidth() / 2, (getHeight() - this.AVATAR_WIDTH) / 2 + this.AVATAR_WIDTH - this.needMask.getIntrinsicHeight() / 2 - this.COMMON_PADDING * 2, this.AVATAR_START_POS + this.AVATAR_WIDTH + this.needMask.getIntrinsicWidth() / 2, (getHeight() - this.AVATAR_WIDTH) / 2 + this.AVATAR_WIDTH - this.needMask.getIntrinsicHeight() / 2 - this.COMMON_PADDING * 2 + this.needMask.getIntrinsicHeight());
  }
  
  public void doInvalidate()
  {
    invalidate();
  }
  
  protected void drawableStateChanged()
  {
    updateTextColors();
    super.drawableStateChanged();
  }
  
  public int fromDPToPix(Context paramContext, int paramInt)
  {
    return Math.round(getDensity(paramContext) * paramInt);
  }
  
  public float getDensity(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = getContext();
    }
    if (this.density < 0.0F) {
      this.density = localContext.getResources().getDisplayMetrics().density;
    }
    return this.density;
  }
  
  public float getDesiredWidth(CharSequence paramCharSequence, TextPaint paramTextPaint)
  {
    if ((paramCharSequence instanceof Spanned)) {
      return Layout.getDesiredWidth(paramCharSequence, paramTextPaint);
    }
    Object localObject = paramCharSequence;
    if (paramCharSequence == null)
    {
      y.w("MicroMsg.AddressView", "source is null, set it empty.");
      localObject = "";
    }
    return paramTextPaint.measureText((CharSequence)localObject, 0, ((CharSequence)localObject).length());
  }
  
  public Drawable getDrawable()
  {
    return this.avatarDrawable;
  }
  
  public CharSequence getNickName()
  {
    return this.nickName;
  }
  
  public float getNickNameSize()
  {
    return this.NAME_TEXT_SIZE;
  }
  
  public int getTextAreaWidth()
  {
    return getMeasuredWidth() - this.AVATAR_LAYOUT_WIDTH - this.AVATAR_PADDING;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    updatePosition();
    if (this.avatarDrawable != null) {
      this.avatarDrawable.draw(paramCanvas);
    }
    if (this.needMask != null) {
      this.needMask.draw(paramCanvas);
    }
    if (this.nameIsSpanned)
    {
      paramCanvas.save();
      paramCanvas.translate(this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING, (getHeight() - this.nickNameHeight) / 2);
      this.nickNamelayout.draw(paramCanvas);
      paramCanvas.restore();
    }
    label325:
    do
    {
      do
      {
        return;
        if (bk.bl(this.description)) {
          break;
        }
      } while (this.destNickName == null);
      Object localObject1 = this.destNickName;
      int i = this.destNickName.length();
      float f1 = this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING;
      float f2 = (getHeight() - (this.fm.bottom - this.fm.top)) / 2.0F;
      float f3 = this.fm.top / 3.0F;
      paramCanvas.drawText((CharSequence)localObject1, 0, i, f1, this.TEXT_TOP_PADDING + (f2 - f3), this.displayNamePaint);
      int j = getWidth();
      f1 = this.descriptionPaint.measureText(this.description);
      localObject1 = this.description;
      Object localObject2 = localObject1;
      if (f1 > j - this.DESCRIPTION_PADDING)
      {
        i = 1;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= this.description.length()) {
            break label325;
          }
          localObject2 = this.description.substring(0, i);
          if (this.descriptionPaint.measureText((String)localObject2) >= j - this.DESCRIPTION_PADDING) {
            break;
          }
          i += 1;
          localObject1 = localObject2;
        }
        localObject2 = (String)localObject1 + "...";
      }
      i = ((String)localObject2).length();
      f1 = this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING;
      f2 = (getHeight() - (this.descriptionFontMetrics.bottom - this.descriptionFontMetrics.top)) / 2.0F;
      f3 = (int)(this.descriptionFontMetrics.top * 1.7D);
      paramCanvas.drawText((String)localObject2, 0, i, f1, this.TEXT_TOP_PADDING + (f2 - f3), this.descriptionPaint);
      return;
    } while (this.destNickName == null);
    paramCanvas.drawText(this.destNickName, 0, this.destNickName.length(), this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING, (getHeight() - (this.fm.bottom - this.fm.top)) / 2.0F - this.fm.top, this.displayNamePaint);
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    CharSequence localCharSequence2 = getContentDescription();
    CharSequence localCharSequence1 = localCharSequence2;
    if (bk.bl((String)localCharSequence2)) {
      localCharSequence1 = this.nickName;
    }
    paramAccessibilityNodeInfo.setText(localCharSequence1);
  }
  
  @TargetApi(14)
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    CharSequence localCharSequence2 = getContentDescription();
    CharSequence localCharSequence1 = localCharSequence2;
    if (bk.bl((String)localCharSequence2)) {
      localCharSequence1 = this.nickName;
    }
    paramAccessibilityEvent.getText().add(localCharSequence1);
  }
  
  public void onScrollStateChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      stopAvatarLoad();
      return;
    }
    resumeAvatarLoad();
  }
  
  public void resumeAvatarLoad()
  {
    if (this.avatarDrawable != null) {
      ((com.tencent.mm.pluginsdk.ui.a)this.avatarDrawable).cmk();
    }
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
    if (this.descriptionPaint == null)
    {
      this.descriptionPaint = generateDescriptionPaint();
      this.descriptionFontMetrics = this.descriptionPaint.getFontMetrics();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.avatarDrawable = paramDrawable;
    if (paramDrawable != null) {
      this.avatarDrawable.setCallback(this);
    }
  }
  
  public void setMaskBitmap(Bitmap paramBitmap)
  {
    this.needMask = new BitmapDrawable(getResources(), paramBitmap);
  }
  
  public void setName(CharSequence paramCharSequence)
  {
    if ((this.nickName == null) || (!this.nickName.equals(paramCharSequence))) {
      this.needInvaildate = true;
    }
    this.nickName = paramCharSequence;
    this.nameIsSpanned = (paramCharSequence instanceof Spanned);
    getFontMetrics();
  }
  
  public void setNickNameTextColor(ColorStateList paramColorStateList)
  {
    this.nickNameTextColor = paramColorStateList;
  }
  
  public void stopAvatarLoad()
  {
    if (this.avatarDrawable != null) {
      ((com.tencent.mm.pluginsdk.ui.a)this.avatarDrawable).cmj();
    }
  }
  
  public void updateDrawBounds()
  {
    updateDrawableBounds();
  }
  
  public void updatePosition()
  {
    if (!this.needUpdatePostion) {
      return;
    }
    this.nickNameWidth = (getTextAreaWidth() - getPaddingLeft() - getPaddingRight());
    if ((int)getDesiredWidth(this.nickName, this.displayNamePaint) > this.nickNameWidth)
    {
      this.destNickName = TextUtils.ellipsize(this.nickName, this.displayNamePaint, this.nickNameWidth, TextUtils.TruncateAt.END);
      if (!(this.nickName instanceof Spanned)) {
        break label157;
      }
      this.nickNamelayout = new StaticLayout(this.destNickName, this.displayNamePaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    }
    label157:
    Paint.FontMetrics localFontMetrics;
    for (this.nickNameHeight = this.nickNamelayout.getHeight();; this.nickNameHeight = ((int)Math.ceil(localFontMetrics.descent - localFontMetrics.top) + 2))
    {
      updateDrawBounds();
      this.needUpdatePostion = false;
      return;
      this.destNickName = this.nickName;
      this.nickNameWidth = ((int)getDesiredWidth(this.destNickName, this.displayNamePaint));
      break;
      this.nickNamelayout = null;
      localFontMetrics = getFontMetrics();
    }
  }
  
  public void updatePositionFlag()
  {
    this.needUpdatePostion = true;
    if (this.needInvaildate)
    {
      invalidate();
      this.needInvaildate = false;
    }
  }
  
  public void updateTextColors()
  {
    if (this.nickNameTextColor != null)
    {
      int i = this.nickNameTextColor.getColorForState(getDrawableState(), 0);
      if (i != this.nickNameCurrentTextColor)
      {
        this.nickNameCurrentTextColor = i;
        if (this.displayNamePaint == null) {
          this.displayNamePaint = generateOnePaint();
        }
        this.displayNamePaint.setColor(this.nickNameCurrentTextColor);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.AddressView
 * JD-Core Version:    0.7.0.1
 */