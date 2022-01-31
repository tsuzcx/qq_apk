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
import android.support.v4.view.t;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.pluginsdk.ui.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public class AddressView
  extends View
  implements a.a, d.a
{
  private static final String TAG = "MicroMsg.AddressView";
  public final int AVATAR_LAYOUT_WIDTH;
  public final int AVATAR_PADDING;
  public final int AVATAR_START_POS;
  public final int AVATAR_WIDTH;
  public final int COMMON_PADDING;
  public final int DESCRIPTION_PADDING;
  public final float DESCRIPTION_TEXT_SIZE;
  private int NAME_RIGHT_PADDING;
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
  Drawable drawable;
  private Paint.FontMetrics fm;
  StaticLayout layout;
  a mergeCallback;
  boolean nameIsSpanned;
  boolean needInvaildate;
  BitmapDrawable needMask;
  boolean needUpdatePostion;
  CharSequence nickName;
  private int nickNameCurrentTextColor;
  int nickNameHeight;
  private ColorStateList nickNameTextColor;
  int nickNameWidth;
  StaticLayout nickNamelayout;
  
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
    AppMethodBeat.i(29078);
    this.drawable = getResources().getDrawable(2130840337);
    this.needUpdatePostion = true;
    this.mergeCallback = null;
    this.AVATAR_LAYOUT_WIDTH = 0;
    this.AVATAR_WIDTH = 0;
    this.NAME_TEXT_SIZE = com.tencent.mm.cb.a.ao(paramContext, 2131427809);
    this.DESCRIPTION_TEXT_SIZE = com.tencent.mm.cb.a.ao(paramContext, 2131427862);
    this.WEIBO_ICON_SIZE = getResources().getDimensionPixelSize(2131427852);
    this.AVATAR_START_POS = 0;
    this.AVATAR_PADDING = 0;
    this.COMMON_PADDING = 0;
    this.DESCRIPTION_PADDING = (getResources().getDimensionPixelSize(2131427776) * 2);
    this.TEXT_TOP_PADDING = getResources().getDimensionPixelSize(2131427861);
    this.NAME_RIGHT_PADDING = getResources().getDimensionPixelSize(2131427494);
    if (this.displayNamePaint == null) {
      this.displayNamePaint = generateOnePaint();
    }
    AppMethodBeat.o(29078);
  }
  
  private TextPaint generateDescriptionPaint()
  {
    AppMethodBeat.i(29100);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setAntiAlias(true);
    localTextPaint.setTextSize(this.DESCRIPTION_TEXT_SIZE);
    localTextPaint.setColor(getResources().getColor(2131690168));
    AppMethodBeat.o(29100);
    return localTextPaint;
  }
  
  private TextPaint generateOnePaint()
  {
    AppMethodBeat.i(29099);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setAntiAlias(true);
    localTextPaint.setTextSize(this.NAME_TEXT_SIZE);
    localTextPaint.setColor(getResources().getColor(2131690322));
    AppMethodBeat.o(29099);
    return localTextPaint;
  }
  
  private Paint.FontMetrics getFontMetrics()
  {
    AppMethodBeat.i(29081);
    if (this.displayNamePaint == null) {
      this.displayNamePaint = generateOnePaint();
    }
    if (this.fm == null) {
      this.fm = this.displayNamePaint.getFontMetrics();
    }
    Paint.FontMetrics localFontMetrics = this.fm;
    AppMethodBeat.o(29081);
    return localFontMetrics;
  }
  
  private int getShowAreaWidth()
  {
    AppMethodBeat.i(156709);
    int i = getTextAreaWidth();
    int j = getPaddingLeft();
    int k = this.NAME_RIGHT_PADDING;
    AppMethodBeat.o(156709);
    return i - j - k;
  }
  
  private void installAccessibilityDelegate()
  {
    AppMethodBeat.i(29103);
    t.a(this, new android.support.v4.view.a()
    {
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, android.support.v4.view.a.b paramAnonymousb)
      {
        AppMethodBeat.i(29077);
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousb);
        CharSequence localCharSequence = AddressView.this.getContentDescription();
        paramAnonymousView = localCharSequence;
        if (bo.isNullOrNil((String)localCharSequence)) {
          paramAnonymousView = AddressView.this.nickName;
        }
        paramAnonymousb.setText(paramAnonymousView);
        AppMethodBeat.o(29077);
      }
      
      public final void onPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        AppMethodBeat.i(29076);
        super.onPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        CharSequence localCharSequence = AddressView.this.getContentDescription();
        paramAnonymousView = localCharSequence;
        if (bo.isNullOrNil((String)localCharSequence)) {
          paramAnonymousView = AddressView.this.nickName;
        }
        paramAnonymousAccessibilityEvent.getText().add(paramAnonymousView);
        AppMethodBeat.o(29076);
      }
    });
    AppMethodBeat.o(29103);
  }
  
  public void doInvalidate()
  {
    AppMethodBeat.i(29101);
    invalidate();
    AppMethodBeat.o(29101);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(29097);
    updateTextColors();
    super.drawableStateChanged();
    AppMethodBeat.o(29097);
  }
  
  public int fromDPToPix(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(29088);
    paramInt = Math.round(getDensity(paramContext) * paramInt);
    AppMethodBeat.o(29088);
    return paramInt;
  }
  
  public float getDensity(Context paramContext)
  {
    AppMethodBeat.i(29089);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = getContext();
    }
    if (this.density < 0.0F) {
      this.density = localContext.getResources().getDisplayMetrics().density;
    }
    float f = this.density;
    AppMethodBeat.o(29089);
    return f;
  }
  
  public float getDesiredWidth(CharSequence paramCharSequence, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(29083);
    if ((paramCharSequence instanceof Spanned))
    {
      f = Layout.getDesiredWidth(paramCharSequence, paramTextPaint);
      AppMethodBeat.o(29083);
      return f;
    }
    Object localObject = paramCharSequence;
    if (paramCharSequence == null)
    {
      ab.w("MicroMsg.AddressView", "source is null, set it empty.");
      localObject = "";
    }
    float f = paramTextPaint.measureText((CharSequence)localObject, 0, ((CharSequence)localObject).length());
    AppMethodBeat.o(29083);
    return f;
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
    AppMethodBeat.i(29087);
    int i = getMeasuredWidth();
    int j = this.AVATAR_LAYOUT_WIDTH;
    int k = this.AVATAR_PADDING;
    AppMethodBeat.o(29087);
    return i - j - k;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(29095);
    invalidate();
    AppMethodBeat.o(29095);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(29079);
    super.onDraw(paramCanvas);
    if (this.mergeCallback != null) {
      this.mergeCallback.NT(getShowAreaWidth());
    }
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
      AppMethodBeat.o(29079);
      return;
    }
    if (!bo.isNullOrNil(this.description))
    {
      if (this.destNickName != null)
      {
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
              break label358;
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
        label358:
        i = ((String)localObject2).length();
        f1 = this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING;
        f2 = (getHeight() - (this.descriptionFontMetrics.bottom - this.descriptionFontMetrics.top)) / 2.0F;
        f3 = (int)(this.descriptionFontMetrics.top * 1.7D);
        paramCanvas.drawText((String)localObject2, 0, i, f1, this.TEXT_TOP_PADDING + (f2 - f3), this.descriptionPaint);
        AppMethodBeat.o(29079);
      }
    }
    else if (this.destNickName != null) {
      paramCanvas.drawText(this.destNickName, 0, this.destNickName.length(), this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING, (getHeight() - (this.fm.bottom - this.fm.top)) / 2.0F - this.fm.top, this.displayNamePaint);
    }
    AppMethodBeat.o(29079);
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(29104);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    CharSequence localCharSequence2 = getContentDescription();
    CharSequence localCharSequence1 = localCharSequence2;
    if (bo.isNullOrNil((String)localCharSequence2)) {
      localCharSequence1 = this.nickName;
    }
    paramAccessibilityNodeInfo.setText(localCharSequence1);
    AppMethodBeat.o(29104);
  }
  
  @TargetApi(14)
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(29102);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    CharSequence localCharSequence2 = getContentDescription();
    CharSequence localCharSequence1 = localCharSequence2;
    if (bo.isNullOrNil((String)localCharSequence2)) {
      localCharSequence1 = this.nickName;
    }
    paramAccessibilityEvent.getText().add(localCharSequence1);
    AppMethodBeat.o(29102);
  }
  
  public void onScrollStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(29094);
    if (paramBoolean)
    {
      stopAvatarLoad();
      AppMethodBeat.o(29094);
      return;
    }
    resumeAvatarLoad();
    AppMethodBeat.o(29094);
  }
  
  public void resumeAvatarLoad()
  {
    AppMethodBeat.i(29092);
    if (this.avatarDrawable != null) {
      ((com.tencent.mm.pluginsdk.ui.b)this.avatarDrawable).dmZ();
    }
    AppMethodBeat.o(29092);
  }
  
  public void setDescription(String paramString)
  {
    AppMethodBeat.i(29082);
    this.description = paramString;
    if (this.descriptionPaint == null)
    {
      this.descriptionPaint = generateDescriptionPaint();
      this.descriptionFontMetrics = this.descriptionPaint.getFontMetrics();
    }
    AppMethodBeat.o(29082);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(29091);
    this.avatarDrawable = paramDrawable;
    if (paramDrawable != null) {
      this.avatarDrawable.setCallback(this);
    }
    AppMethodBeat.o(29091);
  }
  
  public void setMaskBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(29090);
    this.needMask = new BitmapDrawable(getResources(), paramBitmap);
    AppMethodBeat.o(29090);
  }
  
  public void setMergeCallback(a parama)
  {
    if (parama != null) {
      this.needInvaildate = true;
    }
    this.mergeCallback = parama;
  }
  
  public void setName(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(29080);
    if ((this.nickName == null) || (!this.nickName.equals(paramCharSequence))) {
      this.needInvaildate = true;
    }
    this.nickName = paramCharSequence;
    this.nameIsSpanned = (paramCharSequence instanceof Spanned);
    getFontMetrics();
    AppMethodBeat.o(29080);
  }
  
  public void setNickNameTextColor(ColorStateList paramColorStateList)
  {
    this.nickNameTextColor = paramColorStateList;
  }
  
  public void stopAvatarLoad()
  {
    AppMethodBeat.i(29093);
    if (this.avatarDrawable != null) {
      ((com.tencent.mm.pluginsdk.ui.b)this.avatarDrawable).dmY();
    }
    AppMethodBeat.o(29093);
  }
  
  public void updatePosition()
  {
    AppMethodBeat.i(29085);
    if (!this.needUpdatePostion)
    {
      AppMethodBeat.o(29085);
      return;
    }
    this.nickNameWidth = (getTextAreaWidth() - getPaddingLeft() - this.NAME_RIGHT_PADDING);
    if ((int)getDesiredWidth(this.nickName, this.displayNamePaint) > this.nickNameWidth)
    {
      this.destNickName = TextUtils.ellipsize(this.nickName, this.displayNamePaint, this.nickNameWidth, TextUtils.TruncateAt.END);
      if (!(this.nickName instanceof Spanned)) {
        break label171;
      }
      this.nickNamelayout = new StaticLayout(this.destNickName, this.displayNamePaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    }
    label171:
    Paint.FontMetrics localFontMetrics;
    for (this.nickNameHeight = this.nickNamelayout.getHeight();; this.nickNameHeight = ((int)Math.ceil(localFontMetrics.descent - localFontMetrics.top) + 2))
    {
      this.needUpdatePostion = false;
      AppMethodBeat.o(29085);
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
    AppMethodBeat.i(29084);
    this.needUpdatePostion = true;
    if (this.needInvaildate)
    {
      invalidate();
      this.needInvaildate = false;
    }
    AppMethodBeat.o(29084);
  }
  
  public void updateTextColors()
  {
    AppMethodBeat.i(29098);
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
    AppMethodBeat.o(29098);
  }
  
  public static abstract interface a
  {
    public abstract CharSequence NT(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.AddressView
 * JD-Core Version:    0.7.0.1
 */