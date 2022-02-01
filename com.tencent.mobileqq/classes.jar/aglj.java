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
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.3;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.8;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.MsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoItem;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoMsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.TextLocation;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.TextMsgNode;
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

public class aglj
  implements agma, View.OnClickListener
{
  private static volatile boolean jdField_b_of_type_Boolean;
  private agls jdField_a_of_type_Agls;
  private ClipData jdField_a_of_type_AndroidContentClipData;
  private Context jdField_a_of_type_AndroidContentContext;
  private Html.ImageGetter jdField_a_of_type_AndroidTextHtml$ImageGetter = new aglk(this);
  private Html.TagHandler jdField_a_of_type_AndroidTextHtml$TagHandler = new aglm(this);
  public View a;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  public ImageButton a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bkqa jdField_a_of_type_Bkqa = new agll(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PatchedButton jdField_a_of_type_ComTencentWidgetPatchedButton;
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap(40);
  private ClipData jdField_b_of_type_AndroidContentClipData;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private volatile boolean c;
  
  static
  {
    if (!aglj.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_b_of_type_Boolean = true;
      return;
    }
  }
  
  public aglj(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
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
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = paramString;
    if (paramTextLocation == MixedMsgInfo.TextLocation.HEADER) {
      str = bdol.a(paramString, true);
    }
    paramString = str;
    if (paramTextLocation == MixedMsgInfo.TextLocation.TAILOR) {
      paramString = bdol.a(str, false);
    }
    return new MixedMsgInfo.TextMsgNode(paramString);
  }
  
  private String a(Spanned paramSpanned, int paramInt)
  {
    Map localMap = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText());
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
        if (!TextUtils.isEmpty(str))
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
      if ((k >= 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
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
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    if (((ImageSpan[])localEditable.getSpans(0, localEditable.length(), ImageSpan.class)).length + paramInt > 20)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694292, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDimensionPixelSize(2131298998));
      return true;
    }
    return false;
  }
  
  private int b()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
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
    this.c = paramBoolean;
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(paramBoolean);
  }
  
  private static boolean c(Editable paramEditable, String paramString)
  {
    if (TextUtils.isEmpty(paramEditable)) {}
    while (paramEditable.charAt(0) != paramString.charAt(0)) {
      return false;
    }
    return true;
  }
  
  private static boolean d(Editable paramEditable, String paramString)
  {
    if (TextUtils.isEmpty(paramEditable)) {}
    while (paramEditable.charAt(paramEditable.length() - 1) != paramString.charAt(0)) {
      return false;
    }
    return true;
  }
  
  private void e()
  {
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD27", "0X800AD27", b(), 0, "", "", "", "");
    b(true);
    afur.k = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m();
    amuf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "full_screen_input", true);
    afur.l = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Beqr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Beqr.k();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Beqr.g();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Beqr.d = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bl();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Arng != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Arng.c();
    }
    ((armt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(214)).c(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.F();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bk();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.B());
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().width = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(100);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(48);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, 0, 0, 0);
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(afur.a(24.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), afur.a(10.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), afur.a(24.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bf();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bj();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().post(new FullScreenInputHelper.8(this));
  }
  
  private void g() {}
  
  private void h()
  {
    k();
    awmf.a();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFilters(new InputFilter[0]);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.b(this.jdField_a_of_type_Bkqa);
    }
    awmf.a(null);
    awmf.a(null);
  }
  
  private void j()
  {
    ClipboardManager localClipboardManager;
    ClipData localClipData;
    if (this.jdField_a_of_type_AndroidContentClipData != null)
    {
      localClipboardManager = (ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("clipboard");
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
  
  private void k()
  {
    if (this.jdField_b_of_type_AndroidContentClipData != null) {
      ((ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("clipboard")).setPrimaryClip(this.jdField_b_of_type_AndroidContentClipData);
    }
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
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
    return (ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("clipboard");
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
      paramString = ThumbnailUtils.extractThumbnail(auqs.a(paramString, localOptions, 1, 4), j, i, 2);
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
    return bdod.b.newEditable(paramCharSequence);
  }
  
  public MixedMsgInfo a()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText());
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
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
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return "<img src=\"" + paramString + "\">";
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new aglr(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 13) {
      i();
    }
    do
    {
      return;
      if (paramInt == 5)
      {
        g();
        return;
      }
    } while (paramInt != 9);
    h();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131367262);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramViewGroup.findViewById(2131367259));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)paramViewGroup.findViewById(2131367963));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131367275));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)paramViewGroup.findViewById(2131367260));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    if (AppSetting.c)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(anni.a(2131703752));
      this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(anni.a(2131703749));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFilters(new InputFilter[] { new agln(this) });
    if ((Build.VERSION.SDK_INT >= 23) && (!bcnj.b()))
    {
      paramViewGroup = new aglo(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCustomInsertionActionModeCallback(paramViewGroup);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCustomSelectionActionModeCallback(paramViewGroup);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.a(this.jdField_a_of_type_Bkqa);
    jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnDragListener(new aglp(this));
    paramViewGroup = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLocationOnScreen(paramViewGroup);
    paramViewGroup = awmf.a(paramViewGroup[0], ImageSpan.class);
    awmf.a(this);
    awmf.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnKeyboardShowListener(paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnWindowFocusChangedListener(new aglq(this));
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Agls = new agls(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if (QLog.isColorLevel()) {
        QLog.d("FullScreenInputHelper", 2, "[mix] handleBeforeTextChange mTextChangeInfo: " + this.jdField_a_of_type_Agls);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FullScreenInputHelper", 2, "[mix]resetMixedMsgFromDraft draft: " + paramString);
    }
    paramString = a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramString);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    if (a(paramList.size())) {
      return;
    }
    Editable localEditable1 = a("");
    Editable localEditable2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
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
      Selection.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText(), i + 1);
    }
    jdField_b_of_type_Boolean = true;
    awmg.a("0X800AE19", paramList.size());
  }
  
  public void a(boolean paramBoolean)
  {
    if (!a()) {
      return;
    }
    b(false);
    afur.k = false;
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.C()) {
        amuf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "full_screen_input", false);
      }
    }
    afur.l = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Beqr != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Beqr.d = false;
    }
    ((armt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(214)).c(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.u(this.jdField_a_of_type_ComTencentWidgetPatchedButton.isEnabled());
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.G();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height = -2;
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = -2;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, afur.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -2;
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(afur.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(6);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(16);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(afur.a(11.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), afur.a(6.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), afur.a(11.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), afur.a(6.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, afur.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -2;
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(afur.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(6);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(16);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(afur.a(11.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), afur.a(6.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), afur.a(11.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()), afur.a(6.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().postDelayed(new FullScreenInputHelper.3(this), 100L);
    b();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.bj();
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public boolean a(Editable paramEditable)
  {
    if (jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Agls.a(paramEditable);
    }
    try
    {
      this.jdField_a_of_type_Agls.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      if (this.c) {
        if (paramEditable.length() > 0)
        {
          c(true);
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
      c(false);
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 3) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h()) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.C()) && (!bcnj.b())) {
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
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionEnd();
    Object localObject2 = (Spanned)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().subSequence(i, j);
    String str1 = a((Spanned)localObject2, i);
    String str2 = b((Spanned)localObject2);
    if (TextUtils.isEmpty(str2)) {
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
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
      ((Editable)localObject1).delete(i, j);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject1);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(j);
    }
  }
  
  public int[] a()
  {
    return new int[] { 5, 13, 9 };
  }
  
  public void b()
  {
    float f = Math.abs(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint().getFontMetrics().bottom - this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint().getFontMetrics().top);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxHeight(Math.round(f * 6.0F));
  }
  
  public boolean b()
  {
    return TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText());
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aW();
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
    Editable localEditable2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
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
    switch (paramView.getId())
    {
    default: 
    case 2131367963: 
    case 2131367259: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F36", "0X8009F36", b(), 0, "", "", "", "");
        a(false);
        continue;
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F27", "0X8009F27", b(), 0, "", "", "", "");
        e();
      }
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD28", "0X800AD28", b(), 0, "", "", "", "");
    if (a() > 0) {}
    for (int i = a();; i = 21)
    {
      awmg.a("0X800AE1A", i);
      if (a()) {
        a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglj
 * JD-Core Version:    0.7.0.1
 */