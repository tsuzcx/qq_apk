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
import androidx.core.g.a.d;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.pluginsdk.ui.c;
import com.tencent.mm.pluginsdk.ui.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public class AddressView
  extends View
  implements a.a, e.a
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
  AddressView.a mergeCallback;
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
    AppMethodBeat.i(32901);
    this.drawable = getResources().getDrawable(R.g.signature_bg);
    this.needUpdatePostion = true;
    this.mergeCallback = null;
    this.AVATAR_LAYOUT_WIDTH = 0;
    this.AVATAR_WIDTH = 0;
    this.NAME_TEXT_SIZE = com.tencent.mm.ci.a.aY(paramContext, R.f.NormalTextSize);
    this.DESCRIPTION_TEXT_SIZE = com.tencent.mm.ci.a.aY(paramContext, R.f.SmallestTextSize);
    this.WEIBO_ICON_SIZE = getResources().getDimensionPixelSize(R.f.SmallIconSize);
    this.AVATAR_START_POS = 0;
    this.AVATAR_PADDING = 0;
    this.COMMON_PADDING = 0;
    this.DESCRIPTION_PADDING = (getResources().getDimensionPixelSize(R.f.LargestPadding) * 2);
    this.TEXT_TOP_PADDING = getResources().getDimensionPixelSize(R.f.SmallestPadding);
    this.NAME_RIGHT_PADDING = getResources().getDimensionPixelSize(R.f.AddressScrollBarWidth);
    if (this.displayNamePaint == null) {
      this.displayNamePaint = generateOnePaint();
    }
    AppMethodBeat.o(32901);
  }
  
  private TextPaint generateDescriptionPaint()
  {
    AppMethodBeat.i(32922);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setAntiAlias(true);
    localTextPaint.setTextSize(this.DESCRIPTION_TEXT_SIZE);
    localTextPaint.setColor(getResources().getColor(R.e.hint_text_color));
    AppMethodBeat.o(32922);
    return localTextPaint;
  }
  
  private TextPaint generateOnePaint()
  {
    AppMethodBeat.i(32921);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setAntiAlias(true);
    localTextPaint.setTextSize(this.NAME_TEXT_SIZE);
    localTextPaint.setColor(getContext().getResources().getColor(R.e.FG_0));
    AppMethodBeat.o(32921);
    return localTextPaint;
  }
  
  private Paint.FontMetrics getFontMetrics()
  {
    AppMethodBeat.i(32904);
    if (this.displayNamePaint == null) {
      this.displayNamePaint = generateOnePaint();
    }
    if (this.fm == null) {
      this.fm = this.displayNamePaint.getFontMetrics();
    }
    Paint.FontMetrics localFontMetrics = this.fm;
    AppMethodBeat.o(32904);
    return localFontMetrics;
  }
  
  private int getShowAreaWidth()
  {
    AppMethodBeat.i(32908);
    int i = getTextAreaWidth();
    int j = getPaddingLeft();
    int k = this.NAME_RIGHT_PADDING;
    AppMethodBeat.o(32908);
    return i - j - k;
  }
  
  private void installAccessibilityDelegate()
  {
    AppMethodBeat.i(32925);
    w.a(this, new androidx.core.g.a()
    {
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, d paramAnonymousd)
      {
        AppMethodBeat.i(282218);
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousd);
        CharSequence localCharSequence = AddressView.this.getContentDescription();
        paramAnonymousView = localCharSequence;
        if (Util.isNullOrNil((String)localCharSequence)) {
          paramAnonymousView = AddressView.this.nickName;
        }
        paramAnonymousd.setText(paramAnonymousView);
        AppMethodBeat.o(282218);
      }
      
      public final void onPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        AppMethodBeat.i(32899);
        super.onPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        CharSequence localCharSequence = AddressView.this.getContentDescription();
        paramAnonymousView = localCharSequence;
        if (Util.isNullOrNil((String)localCharSequence)) {
          paramAnonymousView = AddressView.this.nickName;
        }
        paramAnonymousAccessibilityEvent.getText().add(paramAnonymousView);
        AppMethodBeat.o(32899);
      }
    });
    AppMethodBeat.o(32925);
  }
  
  public void doInvalidate()
  {
    AppMethodBeat.i(32923);
    invalidate();
    AppMethodBeat.o(32923);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(32919);
    updateTextColors();
    super.drawableStateChanged();
    AppMethodBeat.o(32919);
  }
  
  public int fromDPToPix(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(32911);
    paramInt = Math.round(getDensity(paramContext) * paramInt);
    AppMethodBeat.o(32911);
    return paramInt;
  }
  
  public float getDensity(Context paramContext)
  {
    AppMethodBeat.i(32912);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = getContext();
    }
    if (this.density < 0.0F) {
      this.density = localContext.getResources().getDisplayMetrics().density;
    }
    float f = this.density;
    AppMethodBeat.o(32912);
    return f;
  }
  
  public float getDesiredWidth(CharSequence paramCharSequence, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(32906);
    if ((paramCharSequence instanceof Spanned))
    {
      f = Layout.getDesiredWidth(paramCharSequence, paramTextPaint);
      AppMethodBeat.o(32906);
      return f;
    }
    Object localObject = paramCharSequence;
    if (paramCharSequence == null)
    {
      Log.w("MicroMsg.AddressView", "source is null, set it empty.");
      localObject = "";
    }
    float f = paramTextPaint.measureText((CharSequence)localObject, 0, ((CharSequence)localObject).length());
    AppMethodBeat.o(32906);
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
    AppMethodBeat.i(32910);
    int i = getMeasuredWidth();
    int j = this.AVATAR_LAYOUT_WIDTH;
    int k = this.AVATAR_PADDING;
    AppMethodBeat.o(32910);
    return i - j - k;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(32918);
    invalidate();
    AppMethodBeat.o(32918);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(32902);
    super.onDraw(paramCanvas);
    if (this.mergeCallback != null) {
      getShowAreaWidth();
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
      AppMethodBeat.o(32902);
      return;
    }
    if (!Util.isNullOrNil(this.description))
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
              break label349;
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
        label349:
        i = ((String)localObject2).length();
        f1 = this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING;
        f2 = (getHeight() - (this.descriptionFontMetrics.bottom - this.descriptionFontMetrics.top)) / 2.0F;
        f3 = (int)(this.descriptionFontMetrics.top * 1.7D);
        paramCanvas.drawText((String)localObject2, 0, i, f1, this.TEXT_TOP_PADDING + (f2 - f3), this.descriptionPaint);
        AppMethodBeat.o(32902);
      }
    }
    else if (this.destNickName != null) {
      paramCanvas.drawText(this.destNickName, 0, this.destNickName.length(), this.AVATAR_LAYOUT_WIDTH + this.AVATAR_PADDING, (getHeight() - (this.fm.bottom - this.fm.top)) / 2.0F - this.fm.top, this.displayNamePaint);
    }
    AppMethodBeat.o(32902);
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(32926);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    CharSequence localCharSequence2 = getContentDescription();
    CharSequence localCharSequence1 = localCharSequence2;
    if (Util.isNullOrNil((String)localCharSequence2)) {
      localCharSequence1 = this.nickName;
    }
    paramAccessibilityNodeInfo.setText(localCharSequence1);
    AppMethodBeat.o(32926);
  }
  
  @TargetApi(14)
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(32924);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    CharSequence localCharSequence2 = getContentDescription();
    CharSequence localCharSequence1 = localCharSequence2;
    if (Util.isNullOrNil((String)localCharSequence2)) {
      localCharSequence1 = this.nickName;
    }
    paramAccessibilityEvent.getText().add(localCharSequence1);
    AppMethodBeat.o(32924);
  }
  
  public void onScrollStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(32917);
    if (paramBoolean)
    {
      stopAvatarLoad();
      AppMethodBeat.o(32917);
      return;
    }
    resumeAvatarLoad();
    AppMethodBeat.o(32917);
  }
  
  public void resumeAvatarLoad()
  {
    AppMethodBeat.i(32915);
    if (this.avatarDrawable != null) {
      ((c)this.avatarDrawable).hjv();
    }
    AppMethodBeat.o(32915);
  }
  
  public void setDescription(String paramString)
  {
    AppMethodBeat.i(32905);
    this.description = paramString;
    if (this.descriptionPaint == null)
    {
      this.descriptionPaint = generateDescriptionPaint();
      this.descriptionFontMetrics = this.descriptionPaint.getFontMetrics();
    }
    AppMethodBeat.o(32905);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(32914);
    this.avatarDrawable = paramDrawable;
    if (paramDrawable != null) {
      this.avatarDrawable.setCallback(this);
    }
    AppMethodBeat.o(32914);
  }
  
  public void setMaskBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(32913);
    this.needMask = new BitmapDrawable(getResources(), paramBitmap);
    AppMethodBeat.o(32913);
  }
  
  public void setMergeCallback(AddressView.a parama)
  {
    if (parama != null) {
      this.needInvaildate = true;
    }
    this.mergeCallback = parama;
  }
  
  public void setName(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(32903);
    if ((this.nickName == null) || (!this.nickName.equals(paramCharSequence))) {
      this.needInvaildate = true;
    }
    this.nickName = paramCharSequence;
    this.nameIsSpanned = (paramCharSequence instanceof Spanned);
    getFontMetrics();
    AppMethodBeat.o(32903);
  }
  
  public void setNickNameTextColor(ColorStateList paramColorStateList)
  {
    this.nickNameTextColor = paramColorStateList;
  }
  
  public void stopAvatarLoad()
  {
    AppMethodBeat.i(32916);
    if (this.avatarDrawable != null) {
      ((c)this.avatarDrawable).hju();
    }
    AppMethodBeat.o(32916);
  }
  
  public void updatePosition()
  {
    AppMethodBeat.i(32909);
    if (!this.needUpdatePostion)
    {
      AppMethodBeat.o(32909);
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
      AppMethodBeat.o(32909);
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
    AppMethodBeat.i(32907);
    this.needUpdatePostion = true;
    if (this.needInvaildate)
    {
      invalidate();
      this.needInvaildate = false;
    }
    AppMethodBeat.o(32907);
  }
  
  public void updateTextColors()
  {
    AppMethodBeat.i(32920);
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
    AppMethodBeat.o(32920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.AddressView
 * JD-Core Version:    0.7.0.1
 */