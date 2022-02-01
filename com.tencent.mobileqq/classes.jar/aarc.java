import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.util.DisplayMetrics;
import com.tencent.biz.subscribe.widget.textview.RichTextParser.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aarc
{
  private static HashMap<String, Drawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  public static final Pattern a;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\{img:(.*?),w:(\\d+),h:(\\d+)\\}");
    jdField_a_of_type_JavaUtilMap = new RichTextParser.1();
  }
  
  public static CertifiedAccountMeta.StUser a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("uin:");
    int k = "uin:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new CertifiedAccountMeta.StUser();
    }
    String str = paramString1.substring(j + k, i);
    j = paramString1.length();
    paramString1 = paramString1.substring(i + paramString2.length(), j - 1);
    try
    {
      paramString2 = URLDecoder.decode(paramString1, "UTF-8");
      paramString1 = paramString2;
    }
    catch (Exception paramString2)
    {
      label72:
      break label72;
    }
    paramString2 = new CertifiedAccountMeta.StUser();
    paramString2.nick.set(paramString1);
    paramString2.id.set(str);
    return paramString2;
  }
  
  public static aard a(aare paramaare, Context paramContext, CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt1, int paramInt2, int paramInt3, aaqt paramaaqt, aaqr paramaaqr, aaqp paramaaqp, URLDrawable.URLDrawableListener paramURLDrawableListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramaaqr = paramCharSequence;
    try
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        paramaaqr = "";
      }
      paramCharSequence = new aard(paramaaqr);
      if (paramBoolean1) {
        a(paramContext, paramCharSequence);
      }
      if (!paramBoolean2)
      {
        a(paramContext, paramCharSequence, paramColorStateList, paramaaqt);
        a(paramContext, paramCharSequence, paramInt1, paramaaqt);
      }
      a(paramaare, paramaaqr, a(paramaare), paramCharSequence, paramURLDrawableListener);
      paramaare.jdField_a_of_type_Float += bhtq.b(4.0F);
      b(paramaare, paramaaqr, a(paramaare), paramCharSequence, paramURLDrawableListener);
      return paramCharSequence;
    }
    catch (Exception paramaare)
    {
      QLog.e("RichTextParser", 2, paramaare.getStackTrace());
    }
    return new aard("");
  }
  
  private static VerticalCenterImageSpan a(aare paramaare, Drawable paramDrawable)
  {
    int i = (int)paramaare.jdField_a_of_type_Float;
    Rect localRect = new Rect(0, 0, i, i);
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(localRect);
      return new VerticalCenterImageSpan(paramDrawable, paramaare.jdField_a_of_type_Int);
    }
    return null;
  }
  
  public static ArrayList<CertifiedAccountMeta.StUser> a(Context paramContext, aard paramaard, int paramInt, aaqt paramaaqt)
  {
    paramContext = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramaard)) {}
    Object localObject2;
    for (;;)
    {
      return localObject1;
      Matcher localMatcher = aakd.c.matcher(paramaard);
      int i = 0;
      localObject1 = paramContext;
      localObject2 = paramContext;
      try
      {
        if (localMatcher.find())
        {
          localObject2 = paramContext;
          paramaard.a = true;
          localObject2 = paramContext;
          int j = localMatcher.start() - i;
          localObject2 = paramContext;
          int k = localMatcher.end();
          localObject2 = paramContext;
          localObject1 = localMatcher.group();
          localObject2 = paramContext;
          CertifiedAccountMeta.StUser localStUser = a((String)localObject1, ",nickname:");
          localObject2 = paramContext;
          String str1 = localStUser.id.get();
          localObject2 = paramContext;
          String str2 = "@" + localStUser.nick + " ";
          localObject2 = paramContext;
          paramaard.replace(j, k - i, str2);
          localObject2 = paramContext;
          i += ((String)localObject1).length() - str2.length();
          localObject2 = paramContext;
          k = str2.length() + j;
          if (paramInt != -2147483648)
          {
            localObject2 = paramContext;
            paramaard.setSpan(new ForegroundColorSpan(paramInt), j, k, 33);
          }
          localObject2 = paramContext;
          paramaard.setSpan(new aaqs(str1, paramInt, paramaaqt), j, k, 33);
          localObject2 = paramContext;
          paramaard.setSpan(new StyleSpan(1), j, k, 33);
          localObject1 = paramContext;
          if (paramContext == null)
          {
            localObject2 = paramContext;
            localObject1 = new ArrayList();
          }
          localObject2 = localObject1;
          ((ArrayList)localObject1).add(localStUser);
          paramContext = (Context)localObject1;
        }
      }
      catch (Exception paramContext) {}
    }
    return localObject2;
  }
  
  private static HashMap<String, ImageSpan> a(aare paramaare)
  {
    int i = 0;
    paramaare = paramaare.jdField_a_of_type_JavaLangCharSequence;
    if ((paramaare != null) && ((paramaare instanceof Spannable)))
    {
      paramaare = (Spannable)paramaare;
      paramaare = (ImageSpan[])paramaare.getSpans(0, paramaare.length(), ImageSpan.class);
      if (paramaare != null)
      {
        HashMap localHashMap = new HashMap();
        int j = paramaare.length;
        while (i < j)
        {
          Object localObject = paramaare[i];
          localHashMap.put(localObject.getSource(), localObject);
          i += 1;
        }
        return localHashMap;
      }
    }
    return null;
  }
  
  public static void a(aare paramaare, CharSequence paramCharSequence, HashMap<String, ImageSpan> paramHashMap, aard paramaard, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    a(paramaare, paramCharSequence, paramHashMap, paramaard, paramURLDrawableListener, true);
  }
  
  public static void a(aare paramaare, CharSequence paramCharSequence, HashMap<String, ImageSpan> paramHashMap, aard paramaard, URLDrawable.URLDrawableListener paramURLDrawableListener, boolean paramBoolean)
  {
    if (paramaard == null) {
      return;
    }
    Matcher localMatcher = aakd.g.matcher(paramaard);
    label14:
    int i;
    int j;
    String str;
    if (localMatcher.find())
    {
      paramaard.c = true;
      i = localMatcher.start();
      j = localMatcher.end();
      str = paramaard.subSequence(i, j).toString();
      paramCharSequence = null;
      paramHashMap = paramCharSequence;
      if (paramBoolean)
      {
        paramHashMap = paramCharSequence;
        if (jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
          paramHashMap = (Drawable)jdField_a_of_type_JavaUtilHashMap.get(str);
        }
      }
      paramCharSequence = paramHashMap;
      if (paramHashMap == null)
      {
        if (asle.a(str) == -1) {
          break label157;
        }
        paramCharSequence = asle.a(asle.a(str));
      }
    }
    for (;;)
    {
      if (paramCharSequence != null)
      {
        if (paramBoolean) {
          jdField_a_of_type_JavaUtilHashMap.put(str, paramCharSequence);
        }
        paramCharSequence = a(paramaare, paramCharSequence);
        if (paramCharSequence == null) {
          break label14;
        }
        paramaard.setSpan(paramCharSequence, i, j, 33);
        break label14;
        break;
        label157:
        if (askx.a(str) == -1) {
          break label178;
        }
        paramCharSequence = askx.a(askx.a(str));
        continue;
      }
      break label14;
      label178:
      int k = str.indexOf("[em]") + "[em]".length();
      int m = str.indexOf("[/em]");
      if ((k == -1) || (m == -1)) {
        break;
      }
      paramHashMap = str.substring(k, m);
      try
      {
        paramCharSequence = bnqj.e(paramHashMap);
        paramHashMap = URLDrawable.URLDrawableOptions.obtain();
        paramHashMap.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130848250);
        paramHashMap = URLDrawable.getDrawable(paramCharSequence, paramHashMap);
        paramCharSequence = paramHashMap;
        if (paramHashMap == null) {
          continue;
        }
        paramCharSequence = paramHashMap;
        if (paramURLDrawableListener == null) {
          continue;
        }
        paramHashMap.setURLDrawableListener(paramURLDrawableListener);
        paramCharSequence = paramHashMap;
      }
      catch (Exception paramCharSequence)
      {
        for (;;)
        {
          paramCharSequence = "https://qzonestyle.gtimg.cn/qzone/em/" + paramHashMap + ".gif";
        }
      }
    }
  }
  
  public static void a(Context paramContext, aard paramaard, ColorStateList paramColorStateList, aaqt paramaaqt)
  {
    if ((TextUtils.isEmpty(paramaard)) || (paramContext == null)) {}
    for (;;)
    {
      return;
      Matcher localMatcher = aakd.jdField_a_of_type_JavaUtilRegexPattern.matcher(paramaard);
      int i = 0;
      while (localMatcher.find())
      {
        paramaard.a = true;
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        Object localObject = a(str1, ",nickname:");
        String str2 = ((CertifiedAccountMeta.StUser)localObject).id.get();
        localObject = ((CertifiedAccountMeta.StUser)localObject).nick.get();
        paramaard.replace(j, k - i, (CharSequence)localObject);
        k = str1.length();
        int m = ((String)localObject).length();
        int n = j + ((String)localObject).length();
        if (paramColorStateList != null) {
          paramaard.setSpan(new TextAppearanceSpan(null, 1, (int)(14.0F * paramContext.getResources().getDisplayMetrics().density), paramColorStateList, null), j, n, 33);
        }
        paramaard.setSpan(new aaqs(str2, paramColorStateList, paramaaqt), j, n, 33);
        i += k - m;
      }
    }
  }
  
  private static void a(Context paramContext, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((TextUtils.isEmpty(paramSpannableStringBuilder)) || (paramContext == null)) {
      return;
    }
    Matcher localMatcher = aakd.i.matcher(paramSpannableStringBuilder);
    int i = 0;
    label23:
    int j;
    int k;
    String str2;
    int n;
    String str1;
    int m;
    Object localObject;
    if (localMatcher.find())
    {
      j = localMatcher.start() - i;
      k = localMatcher.end();
      str2 = localMatcher.group();
      n = str2.indexOf(",color:");
      int i1 = ",color:".length();
      int i2 = str2.indexOf(",useDefaultFont:");
      str1 = "";
      m = str2.indexOf("text:");
      if (m == -1) {
        break label270;
      }
      localObject = str2.substring(i1 + n, i2);
      n = str2.indexOf(",color:");
      str1 = str2.substring("text:".length() + m, n);
      localObject = (Integer)jdField_a_of_type_JavaUtilMap.get(localObject);
      if (localObject == null) {
        break label264;
      }
      localObject = paramContext.getResources().getColorStateList(((Integer)localObject).intValue());
    }
    for (;;)
    {
      paramSpannableStringBuilder.replace(j, k - i, str1);
      k = str2.length();
      m = str1.length();
      n = str1.length();
      if (localObject != null) {
        paramSpannableStringBuilder.setSpan(new TextAppearanceSpan(null, 1, (int)(14.0F * paramContext.getResources().getDisplayMetrics().density), (ColorStateList)localObject, null), j, j + n, 33);
      }
      i += k - m;
      break label23;
      break;
      label264:
      localObject = null;
      continue;
      label270:
      localObject = null;
    }
  }
  
  private static void b(aare paramaare, CharSequence paramCharSequence, HashMap<String, ImageSpan> paramHashMap, aard paramaard, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    if (TextUtils.isEmpty(paramaard)) {
      return;
    }
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramaard);
    for (;;)
    {
      try
      {
        if (!localMatcher.find()) {
          break;
        }
        str2 = localMatcher.group(1);
        if (!str2.startsWith("https://qzonestyle.gtimg.cn/")) {
          continue;
        }
        str3 = localMatcher.group(2);
        str4 = localMatcher.group(3);
        i = localMatcher.start();
        j = localMatcher.end();
        str1 = paramaard.subSequence(i, j).toString();
        paramCharSequence = null;
        if (jdField_a_of_type_JavaUtilHashMap.containsKey(str1)) {
          paramCharSequence = (Drawable)jdField_a_of_type_JavaUtilHashMap.get(str1);
        }
        paramHashMap = paramCharSequence;
        if (paramCharSequence == null) {
          paramCharSequence = URLDrawable.URLDrawableOptions.obtain();
        }
      }
      catch (Exception paramaare)
      {
        String str2;
        String str3;
        String str4;
        int i;
        int j;
        String str1;
        int k;
        int m;
        paramaare.printStackTrace();
        return;
      }
      try
      {
        k = Integer.parseInt(str4);
        m = Integer.parseInt(str3);
        if ((k > 0) && (m > 0))
        {
          paramCharSequence.mRequestHeight = k;
          paramCharSequence.mRequestWidth = m;
        }
      }
      catch (Exception paramHashMap)
      {
        QLog.e("RichTextParser", 1, paramHashMap, new Object[0]);
        continue;
      }
      paramCharSequence.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130848250);
      paramCharSequence = URLDrawable.getDrawable(str2, paramCharSequence);
      paramHashMap = paramCharSequence;
      if (paramCharSequence != null)
      {
        paramHashMap = paramCharSequence;
        if (paramURLDrawableListener != null)
        {
          paramCharSequence.setURLDrawableListener(paramURLDrawableListener);
          paramHashMap = paramCharSequence;
        }
      }
      if (paramHashMap != null)
      {
        jdField_a_of_type_JavaUtilHashMap.put(str1, paramHashMap);
        paramCharSequence = a(paramaare, paramHashMap);
        if (paramCharSequence != null) {
          paramaard.setSpan(paramCharSequence, i, j, 33);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aarc
 * JD-Core Version:    0.7.0.1
 */