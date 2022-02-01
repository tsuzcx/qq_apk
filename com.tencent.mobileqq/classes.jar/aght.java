import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.3;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.7;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.MsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoItem;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoMsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.TextLocation;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.TextMsgNode;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.xml.sax.XMLReader;

public class aght
  implements agin, View.OnClickListener
{
  private static volatile boolean jdField_b_of_type_Boolean;
  private agic jdField_a_of_type_Agic;
  private ClipData jdField_a_of_type_AndroidContentClipData;
  private Context jdField_a_of_type_AndroidContentContext;
  private Html.ImageGetter jdField_a_of_type_AndroidTextHtml$ImageGetter = new aghu(this);
  private Html.TagHandler jdField_a_of_type_AndroidTextHtml$TagHandler = new aghw(this);
  public View a;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  public ImageButton a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private blgp jdField_a_of_type_Blgp = new aghv(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PatchedButton jdField_a_of_type_ComTencentWidgetPatchedButton;
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap(40);
  private ClipData jdField_b_of_type_AndroidContentClipData;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private volatile boolean c;
  
  static
  {
    if (!aght.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_b_of_type_Boolean = true;
      return;
    }
  }
  
  public aght(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
  }
  
  private Editable a(String paramString)
  {
    paramString = (Editable)Html.fromHtml(paramString, this.jdField_a_of_type_AndroidTextHtml$ImageGetter, this.jdField_a_of_type_AndroidTextHtml$TagHandler);
    int i = paramString.length();
    int j;
    do
    {
      j = i - 1;
      if (j < 0) {
        break;
      }
      i = j;
    } while (paramString.charAt(j) == "\n".charAt(0));
    return a(paramString.subSequence(0, j + 1));
  }
  
  private MixedMsgInfo.MsgNode a(String paramString, MixedMsgInfo.TextLocation paramTextLocation)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = paramString;
    if (paramTextLocation == MixedMsgInfo.TextLocation.HEADER) {
      str = com.tencent.mobileqq.text.TextUtils.trimNewLine(paramString, true);
    }
    paramString = str;
    if (paramTextLocation == MixedMsgInfo.TextLocation.TAILOR) {
      paramString = com.tencent.mobileqq.text.TextUtils.trimNewLine(str, false);
    }
    return new MixedMsgInfo.TextMsgNode(paramString);
  }
  
  private String a(Spanned paramSpanned, int paramInt)
  {
    Map localMap = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText());
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramSpanned.length())
    {
      char c1 = paramSpanned.charAt(i);
      String str;
      int j;
      if (c1 == "￼".charAt(0))
      {
        str = (String)localMap.get(Integer.valueOf(i + paramInt));
        j = i;
        if (!android.text.TextUtils.isEmpty(str))
        {
          localStringBuilder.append(a(str));
          j = i;
        }
      }
      for (;;)
      {
        i = j + 1;
        break;
        if (c1 == '\n')
        {
          localStringBuilder.append(a());
          j = i;
        }
        else if (c1 == '\024')
        {
          j = i;
          if (i + 1 < paramSpanned.length())
          {
            i += 1;
            str = a(paramSpanned.charAt(i));
            localStringBuilder.append(str);
            j = i;
            if (QLog.isColorLevel())
            {
              QLog.d("FullScreenInputHelper", 2, "[mix]getHtmlStr emotionTag: " + str);
              j = i;
            }
          }
        }
        else
        {
          localStringBuilder.append(c1);
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.d("FullScreenInputHelper", 2, "[mix]getHtmlStr char: " + c1);
            j = i;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FullScreenInputHelper", 2, "[mix]getHtmlStr source: " + paramSpanned + " result: " + localStringBuilder);
    }
    return localStringBuilder.toString();
  }
  
  private String a(XMLReader paramXMLReader, String paramString)
  {
    try
    {
      Object localObject = paramXMLReader.getClass().getDeclaredField("theNewElement");
      ((Field)localObject).setAccessible(true);
      paramXMLReader = ((Field)localObject).get(paramXMLReader);
      localObject = paramXMLReader.getClass().getDeclaredField("theAtts");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(paramXMLReader);
      paramXMLReader = localObject.getClass().getDeclaredField("data");
      paramXMLReader.setAccessible(true);
      paramXMLReader = (String[])paramXMLReader.get(localObject);
      Field localField = localObject.getClass().getDeclaredField("length");
      localField.setAccessible(true);
      int j = ((Integer)localField.get(localObject)).intValue();
      int i = 0;
      while (i < j)
      {
        localObject = paramXMLReader[(i * 5 + 1)];
        localField = paramXMLReader[(i * 5 + 4)];
        boolean bool = ((String)localObject).equalsIgnoreCase(paramString);
        if (bool) {
          return localField;
        }
        i += 1;
      }
      return null;
    }
    catch (Exception paramXMLReader)
    {
      paramXMLReader.printStackTrace();
    }
  }
  
  private Map<Integer, String> a(Spanned paramSpanned)
  {
    int i = 0;
    HashMap localHashMap = new HashMap(20);
    ImageSpan[] arrayOfImageSpan = (ImageSpan[])paramSpanned.getSpans(0, paramSpanned.length(), ImageSpan.class);
    int j = arrayOfImageSpan.length;
    while (i < j)
    {
      Object localObject = arrayOfImageSpan[i];
      int k = paramSpanned.getSpanStart(localObject);
      localObject = ((ImageSpan)localObject).getSource();
      if ((k >= 0) && (!android.text.TextUtils.isEmpty((CharSequence)localObject)))
      {
        if ((!jdField_a_of_type_Boolean) && (localObject == null)) {
          throw new AssertionError();
        }
        localHashMap.put(Integer.valueOf(k), localObject);
      }
      i += 1;
    }
    return localHashMap;
  }
  
  private boolean a(int paramInt)
  {
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText();
    if (((ImageSpan[])localEditable.getSpans(0, localEditable.length(), ImageSpan.class)).length + paramInt > 20)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp(), 2131694649, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getResources().getDimensionPixelSize(2131299080));
      return true;
    }
    return false;
  }
  
  private int b()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType;
    if ((i >= 1000) && (i <= 1038)) {
      return 3;
    }
    switch (i)
    {
    default: 
      return 4;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  private String b(Spanned paramSpanned)
  {
    paramSpanned = a(paramSpanned);
    if (paramSpanned == null) {
      return "";
    }
    return paramSpanned.a();
  }
  
  private void b(boolean paramBoolean)
  {
    f();
    FrameLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localLayoutParams = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageButton.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299206);
        this.jdField_b_of_type_AndroidWidgetImageButton.setLayoutParams(localLayoutParams);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localLayoutParams = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageButton.getLayoutParams();
    } while (localLayoutParams == null);
    localLayoutParams.bottomMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299203);
    this.jdField_b_of_type_AndroidWidgetImageButton.setLayoutParams(localLayoutParams);
  }
  
  private void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  private static boolean c(Editable paramEditable, String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramEditable)) {}
    while (paramEditable.charAt(0) != paramString.charAt(0)) {
      return false;
    }
    return true;
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(paramBoolean);
  }
  
  private boolean d()
  {
    benk localbenk = (benk)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(74);
    return (localbenk != null) && (localbenk.a()) && (arhn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app));
  }
  
  private static boolean d(Editable paramEditable, String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramEditable)) {}
    while (paramEditable.charAt(paramEditable.length() - 1) != paramString.charAt(0)) {
      return false;
    }
    return true;
  }
  
  private void e()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app;
    bdla.b(localQQAppInterface, "dc00898", "", "", "0X800AD27", "0X800AD27", b(), 0, "", "", "", "");
    c(true);
    AIOUtils.isForbidPokeMessageAnimationPlay = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.updateAddFriendAndShieldView();
    ancb.a(localQQAppInterface, "full_screen_input", true);
    AIOUtils.isForbidTipsShow = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mTroopTips != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mTroopTips.k();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mTroopTips.g();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mTroopTips.d = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.handleRemoveTips();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mComboUIManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mComboUIManager.c();
    }
    ((asaa)localQQAppInterface.getManager(QQManagerFactory.DOUTU_MAGAGER)).c(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onExpandFullScreen();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.handlePanelOnExpandFullScreen();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getFunBtnEnable());
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getLayoutParams().width = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setMaxLines(100);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setGravity(48);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    if ((a() == 0) && (d())) {
      b(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.setPadding(0, 0, 0, 0);
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getLayoutParams()).setMargins(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setPadding(AIOUtils.dp2px(24.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.dp2px(10.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.dp2px(24.0F, localQQAppInterface.getApplication().getResources()), 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getLayoutParams().height = -1;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hideZhituIcon();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onFullScreenStateChange();
      return;
      b(false);
    }
  }
  
  @SuppressLint({"RtlHardcoded"})
  private void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131364087);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131720148));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167089));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130850022);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299205);
    localLayoutParams.bottomMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299204);
    localLayoutParams.gravity = 85;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (AppSetting.c) {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anvx.a(2131689494));
    }
    ((FrameLayout)this.jdField_a_of_type_AndroidViewView).addView(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().post(new FullScreenInputHelper.7(this));
  }
  
  private void h()
  {
    
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setOnDragListener(new agia(this));
    }
  }
  
  private void i()
  {
    l();
    awyf.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setOnDragListener(null);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input != null)
    {
      if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setFilters(new InputFilter[0]);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setOnWindowFocusChangedListener(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.b(this.jdField_a_of_type_Blgp);
    }
    awyf.a(null);
    awyf.a(null);
  }
  
  private void k()
  {
    ClipboardManager localClipboardManager;
    ClipData localClipData;
    if (this.jdField_a_of_type_AndroidContentClipData != null)
    {
      localClipboardManager = (ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getSystemService("clipboard");
      localClipData = localClipboardManager.getPrimaryClip();
      if (localClipData != null) {
        break label42;
      }
      localClipboardManager.setPrimaryClip(this.jdField_a_of_type_AndroidContentClipData);
    }
    label42:
    while ((this.jdField_b_of_type_AndroidContentClipData == null) || (localClipData.getItemAt(0).getText() == null) || (this.jdField_b_of_type_AndroidContentClipData.getItemAt(0).getText() == null) || (!localClipData.getItemAt(0).getText().toString().equals(this.jdField_b_of_type_AndroidContentClipData.getItemAt(0).getText().toString()))) {
      return;
    }
    localClipboardManager.setPrimaryClip(this.jdField_a_of_type_AndroidContentClipData);
  }
  
  private void l()
  {
    if (this.jdField_b_of_type_AndroidContentClipData != null) {
      ((ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getSystemService("clipboard")).setPrimaryClip(this.jdField_b_of_type_AndroidContentClipData);
    }
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText();
    if ((localObject != null) && (((Spanned)localObject).length() > 0))
    {
      localObject = (ImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), ImageSpan.class);
      if (localObject != null) {
        return localObject.length;
      }
    }
    return 0;
  }
  
  ClipboardManager a()
  {
    return (ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.getSystemService("clipboard");
  }
  
  Drawable a(Context paramContext, String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    ThumbWidthHeightDP localThumbWidthHeightDP = ThumbWidthHeightDP.getThumbWidthHeightDP(false);
    int m = localThumbWidthHeightDP.mMinWidth;
    int k = localThumbWidthHeightDP.mMinHeight;
    int n = localThumbWidthHeightDP.mMaxWidth;
    int i1 = localThumbWidthHeightDP.mMaxHeight;
    int j = localOptions.outWidth;
    int i = localOptions.outHeight;
    float f1;
    if ((j > 0) && (i > 0)) {
      if ((j < m) || (i < k)) {
        if (j < i)
        {
          f1 = m / j;
          k = Math.min((int)(i * f1 + 0.5F), i1);
          i = k;
          j = m;
          if (QLog.isColorLevel())
          {
            QLog.d("FullScreenInputHelper", 2, "scale1:" + f1);
            j = m;
            i = k;
          }
        }
      }
    }
    for (;;)
    {
      f1 = paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F;
      j = (int)(j * f1 + 0.5F);
      i = (int)(f1 * i + 0.5F);
      localOptions.inSampleSize = Utils.calculateInSampleSize(localOptions, j, i);
      localOptions.inJustDecodeBounds = false;
      paramString = ThumbnailUtils.extractThumbnail(avax.a(paramString, localOptions, 1, 4), j, i, 2);
      paramContext = new BitmapDrawable(paramContext.getResources(), paramString);
      paramContext.setBounds(0, 0, j, i);
      if (QLog.isColorLevel()) {
        QLog.d("FullScreenInputHelper", 2, "thumb drawable setBounds, w:" + j + ", h:" + i);
      }
      return paramContext;
      f1 = k / i;
      m = Math.min((int)(j * f1 + 0.5F), n);
      break;
      if ((j >= n) || (i >= i1))
      {
        if (j > i)
        {
          f1 = n / j;
          label380:
          if (j <= i) {
            break label489;
          }
        }
        label489:
        for (float f2 = k / i;; f2 = m / j)
        {
          f1 = Math.max(f1, f2);
          k = (int)(j * f1 + 0.5F);
          m = (int)(i * f1 + 0.5F);
          i = m;
          j = k;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("FullScreenInputHelper", 2, "scale2:" + f1);
          i = m;
          j = k;
          break;
          f1 = i1 / i;
          break label380;
        }
        i = 99;
        j = 99;
      }
    }
  }
  
  Editable a(CharSequence paramCharSequence)
  {
    return QQTextBuilder.EMOTION_INPUT_FACTORY.newEditable(paramCharSequence);
  }
  
  public MixedMsgInfo a()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText());
  }
  
  public MixedMsgInfo a(Spanned paramSpanned)
  {
    if (paramSpanned.length() <= 0) {
      return null;
    }
    MixedMsgInfo localMixedMsgInfo = new MixedMsgInfo();
    Object localObject1 = (ImageSpan[])paramSpanned.getSpans(0, paramSpanned.length(), ImageSpan.class);
    Object localObject2 = new SparseArray();
    int j = localObject1.length;
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject3 = localObject1[i];
      ((SparseArray)localObject2).append(paramSpanned.getSpanStart(localObject3), localObject3);
      i += 1;
    }
    j = 0;
    i = 0;
    if (j < ((SparseArray)localObject2).size())
    {
      localObject3 = (ImageSpan)((SparseArray)localObject2).valueAt(j);
      int m = paramSpanned.getSpanStart(localObject3);
      int k = paramSpanned.getSpanEnd(localObject3);
      String str = paramSpanned.subSequence(i, m).toString();
      if (QLog.isColorLevel()) {
        QLog.d("FullScreenInputHelper", 2, "[mix]getMixedText ImageSpan: " + ((ImageSpan)localObject3).getSource() + " {start: " + m + " end: " + k + " all: " + paramSpanned.length() + "} prefix: " + str);
      }
      if (j == 0)
      {
        localObject1 = MixedMsgInfo.TextLocation.HEADER;
        label242:
        localMixedMsgInfo.a(a(str, (MixedMsgInfo.TextLocation)localObject1));
        localObject1 = ((ImageSpan)localObject3).getSource();
        localObject3 = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(localObject1);
        if (localObject3 == null) {
          break label331;
        }
      }
      label331:
      for (boolean bool = ((Boolean)localObject3).booleanValue();; bool = false)
      {
        localMixedMsgInfo.a(new MixedMsgInfo.PhotoMsgNode(new MixedMsgInfo.PhotoItem((String)localObject1, bool)));
        j += 1;
        i = k;
        break;
        localObject1 = MixedMsgInfo.TextLocation.INLINE;
        break label242;
      }
    }
    localObject1 = paramSpanned.subSequence(i, paramSpanned.length()).toString();
    localMixedMsgInfo.a(a((String)localObject1, MixedMsgInfo.TextLocation.TAILOR));
    localObject2 = localMixedMsgInfo.a();
    if (QLog.isColorLevel()) {
      QLog.d("FullScreenInputHelper", 2, "[mix]mixedMsgInfo size:" + localMixedMsgInfo.a().size() + ", result: " + (String)localObject2 + " [start: " + i + " end: " + paramSpanned.length() + "] suffix: " + (String)localObject1);
    }
    return localMixedMsgInfo;
  }
  
  String a()
  {
    return "<newLine>";
  }
  
  String a(int paramInt)
  {
    return "<emotion id=\"" + paramInt + "\">";
  }
  
  public String a(Spanned paramSpanned)
  {
    Object localObject = paramSpanned;
    if (paramSpanned == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText();
    }
    paramSpanned = a((Spanned)localObject, 0);
    if (QLog.isColorLevel()) {
      QLog.d("FullScreenInputHelper", 2, "[mix]getMixedMsgDraft result: " + paramSpanned);
    }
    return paramSpanned;
  }
  
  public String a(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText();
    }
    if (localObject == null) {
      paramCharSequence = null;
    }
    do
    {
      return paramCharSequence;
      localObject = ((CharSequence)localObject).toString().replaceAll("￼", "[图片]");
      paramCharSequence = (CharSequence)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("FullScreenInputHelper", 2, "[mix]getMixedMsgInfoText result: " + (String)localObject);
    return localObject;
  }
  
  String a(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return "";
    }
    return "<img src=\"" + paramString + "\">";
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new agib(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 14) {
      j();
    }
    do
    {
      return;
      if (paramInt == 6)
      {
        h();
        return;
      }
    } while (paramInt != 10);
    i();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131367464);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramViewGroup.findViewById(2131367461));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)paramViewGroup.findViewById(2131368203));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131367477));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)paramViewGroup.findViewById(2131367462));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    if (AppSetting.c)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(anvx.a(2131704439));
      this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(anvx.a(2131704436));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setFilters(new InputFilter[] { new aghx(this) });
    paramViewGroup = new aghy(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setCustomSelectionActionModeCallback(paramViewGroup);
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setCustomInsertionActionModeCallback(paramViewGroup);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.a(this.jdField_a_of_type_Blgp);
    jdField_b_of_type_Boolean = true;
    paramViewGroup = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getLocationOnScreen(paramViewGroup);
    paramViewGroup = awyf.a(paramViewGroup[0], ImageSpan.class);
    awyf.a(this);
    awyf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setMovementMethod(paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setOnKeyboardShowListener(paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setOnWindowFocusChangedListener(new aghz(this));
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Agic = new agic(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if (QLog.isColorLevel()) {
        QLog.d("FullScreenInputHelper", 2, "[mix] handleBeforeTextChange mTextChangeInfo: " + this.jdField_a_of_type_Agic);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FullScreenInputHelper", 2, "[mix]resetMixedMsgFromDraft draft: " + paramString);
    }
    paramString = a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setText(paramString);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    if (a(paramList.size())) {
      return;
    }
    Editable localEditable1 = a("");
    Editable localEditable2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText();
    int i = Selection.getSelectionStart(localEditable2);
    if ((i > 0) && (!localEditable2.subSequence(0, i).toString().endsWith("\n"))) {
      localEditable1.append("\n");
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localEditable1.append(a(a(str))).append("\n");
      this.jdField_a_of_type_JavaUtilMap.put(str, Boolean.valueOf(paramBoolean));
    }
    if (localEditable2.subSequence(i, localEditable2.length()).toString().startsWith("\n")) {
      localEditable1.delete(localEditable1.length() - 1, localEditable1.length());
    }
    jdField_b_of_type_Boolean = false;
    localEditable2.insert(i, localEditable1);
    i = Selection.getSelectionStart(localEditable2);
    if (localEditable2.charAt(i - 1) == "￼".charAt(0)) {
      Selection.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText(), i + 1);
    }
    jdField_b_of_type_Boolean = true;
    awyg.a("0X800AE19", paramList.size());
  }
  
  public void a(boolean paramBoolean)
  {
    if (!a()) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app;
    c(false);
    AIOUtils.isForbidPokeMessageAnimationPlay = false;
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.updateAddFriendAndShieldView();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getInputEnable()) {
        ancb.a(localQQAppInterface, "full_screen_input", false);
      }
    }
    AIOUtils.isForbidTipsShow = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mTroopTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mTroopTips.d = false;
    }
    ((asaa)localQQAppInterface.getManager(QQManagerFactory.DOUTU_MAGAGER)).c(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.funBtnEnable(this.jdField_a_of_type_ComTencentWidgetPatchedButton.isEnabled());
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    b(false);
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onHideFullScreen();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getLayoutParams().height = -2;
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = -2;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.setPadding(0, AIOUtils.dp2px(8.0F, localQQAppInterface.getApplication().getResources()), 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getLayoutParams().height = -2;
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getLayoutParams()).setMargins(AIOUtils.dp2px(14.0F, localQQAppInterface.getApplication().getResources()), 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setMaxLines(6);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setGravity(16);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setPadding(AIOUtils.dp2px(11.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.dp2px(6.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.dp2px(11.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.dp2px(6.0F, localQQAppInterface.getApplication().getResources()));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.setPadding(0, AIOUtils.dp2px(8.0F, localQQAppInterface.getApplication().getResources()), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getLayoutParams().height = -2;
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getLayoutParams()).setMargins(AIOUtils.dp2px(14.0F, localQQAppInterface.getApplication().getResources()), 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setMaxLines(6);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setGravity(16);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setPadding(AIOUtils.dp2px(11.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.dp2px(6.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.dp2px(11.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.dp2px(6.0F, localQQAppInterface.getApplication().getResources()));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().postDelayed(new FullScreenInputHelper.3(this), 100L);
    b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onFullScreenStateChange();
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public boolean a(Editable paramEditable)
  {
    boolean bool;
    if ((a()) && (d()))
    {
      if (a() != 0) {
        break label79;
      }
      bool = true;
    }
    for (;;)
    {
      b(bool);
      if (jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Agic.a(paramEditable);
      }
      try
      {
        this.jdField_a_of_type_Agic.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input);
        if (this.c) {
          if (paramEditable.length() > 0)
          {
            d(true);
            return true;
            label79:
            bool = false;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
        d(false);
        return true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getLineCount() > 3) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.enableFullScreenInput()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getInputEnable()) && (!bdfk.b())) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
  
  boolean a(boolean paramBoolean)
  {
    Object localObject1 = a();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getSelectionStart();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getSelectionEnd();
    Object localObject2 = (Spanned)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText().subSequence(i, j);
    String str1 = a((Spanned)localObject2, i);
    String str2 = b((Spanned)localObject2);
    if (android.text.TextUtils.isEmpty(str2)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FullScreenInputHelper", 2, "[mix]ClipBoard CopyOrCut startIndex: " + i + " endIndex: " + j + " mixed: " + str2 + " text: " + localObject2 + " html: " + str1 + " revert: " + a(str1));
    }
    localObject2 = ClipData.newPlainText("FullScreenInputHelper", str2);
    Intent localIntent = new Intent();
    localIntent.putExtra("FullScreenInputHelper", str1);
    ((ClipData)localObject2).addItem(new ClipData.Item(localIntent));
    ((ClipboardManager)localObject1).setPrimaryClip((ClipData)localObject2);
    this.jdField_a_of_type_AndroidContentClipData = ((ClipData)localObject2);
    this.jdField_b_of_type_AndroidContentClipData = ClipData.newPlainText("FullScreenInputHelper", str2);
    if (paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText();
      ((Editable)localObject1).delete(i, j);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setText((CharSequence)localObject1);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setSelection(j);
    }
  }
  
  public int[] a()
  {
    return new int[] { 6, 14, 10 };
  }
  
  public void b()
  {
    float f = Math.abs(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getPaint().getFontMetrics().bottom - this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getPaint().getFontMetrics().top);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setMaxHeight(Math.round(f * 6.0F));
  }
  
  public boolean b()
  {
    return android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText());
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.clearInput();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  boolean c()
  {
    boolean bool2 = false;
    Object localObject = a().getPrimaryClip();
    boolean bool1 = bool2;
    Editable localEditable1;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((ClipData)localObject).getItemCount() == 2)
      {
        bool1 = bool2;
        if (((ClipData)localObject).getItemAt(1).getIntent() != null)
        {
          localObject = ((ClipData)localObject).getItemAt(1).getIntent().getStringExtra("FullScreenInputHelper");
          localEditable1 = a((String)localObject);
          if (!a(((ImageSpan[])localEditable1.getSpans(0, localEditable1.length(), ImageSpan.class)).length)) {
            break label93;
          }
          bool1 = true;
        }
      }
    }
    return bool1;
    label93:
    Editable localEditable2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText();
    localEditable2 = localEditable2.replace(Selection.getSelectionStart(localEditable2), Selection.getSelectionEnd(localEditable2), localEditable1, 0, localEditable1.length());
    if (QLog.isColorLevel()) {
      QLog.d("FullScreenInputHelper", 2, "[mix] ClipBoard paste html: " + (String)localObject + " text: " + localEditable1 + " result: " + localEditable2);
    }
    return true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdla.b((QQAppInterface)localObject, "dc00898", "", "", "0X8009F36", "0X8009F36", b(), 0, "", "", "", "");
      a(false);
      continue;
      bdla.b((QQAppInterface)localObject, "dc00898", "", "", "0X8009F27", "0X8009F27", b(), 0, "", "", "", "");
      e();
      continue;
      bdla.b((QQAppInterface)localObject, "dc00898", "", "", "0X800AD28", "0X800AD28", b(), 0, "", "", "", "");
      if (a() > 0) {}
      for (int i = a();; i = 21)
      {
        awyg.a("0X800AE1A", i);
        if (a()) {
          a(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.send();
        break;
      }
      localObject = (benk)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(74);
      if (localObject != null) {
        ((benk)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText().toString(), 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aght
 * JD-Core Version:    0.7.0.1
 */