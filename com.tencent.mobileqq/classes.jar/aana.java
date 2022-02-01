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

public class aana
{
  private static HashMap<String, Drawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  public static final Pattern a;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\{img:(.*),w:(\\d+),h:(\\d+)\\}");
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
  
  public static aanb a(aanc paramaanc, Context paramContext, CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt1, int paramInt2, int paramInt3, aamr paramaamr, aamp paramaamp, aamn paramaamn, URLDrawable.URLDrawableListener paramURLDrawableListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramaamp = paramCharSequence;
    try
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        paramaamp = "";
      }
      paramCharSequence = new aanb(paramaamp);
      if (paramBoolean1) {
        a(paramContext, paramCharSequence);
      }
      if (!paramBoolean2)
      {
        a(paramContext, paramCharSequence, paramColorStateList, paramaamr);
        a(paramContext, paramCharSequence, paramInt1, paramaamr);
      }
      a(paramaanc, paramaamp, a(paramaanc), paramCharSequence);
      a(paramaanc, paramaamp, a(paramaanc), paramCharSequence, paramURLDrawableListener);
      return paramCharSequence;
    }
    catch (Exception paramaanc)
    {
      QLog.e("RichTextParser", 2, paramaanc.getStackTrace());
    }
    return new aanb("");
  }
  
  private static VerticalCenterImageSpan a(aanc paramaanc, Drawable paramDrawable)
  {
    int i = (int)paramaanc.jdField_a_of_type_Float;
    Rect localRect = new Rect(0, 0, i, i);
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(localRect);
      return new VerticalCenterImageSpan(paramDrawable, paramaanc.jdField_a_of_type_Int);
    }
    return null;
  }
  
  public static ArrayList<CertifiedAccountMeta.StUser> a(Context paramContext, aanb paramaanb, int paramInt, aamr paramaamr)
  {
    paramContext = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramaanb)) {}
    Object localObject2;
    for (;;)
    {
      return localObject1;
      Matcher localMatcher = aagc.c.matcher(paramaanb);
      int i = 0;
      localObject1 = paramContext;
      localObject2 = paramContext;
      try
      {
        if (localMatcher.find())
        {
          localObject2 = paramContext;
          paramaanb.a = true;
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
          paramaanb.replace(j, k - i, str2);
          localObject2 = paramContext;
          i += ((String)localObject1).length() - str2.length();
          localObject2 = paramContext;
          k = str2.length() + j;
          if (paramInt != -2147483648)
          {
            localObject2 = paramContext;
            paramaanb.setSpan(new ForegroundColorSpan(paramInt), j, k, 33);
          }
          localObject2 = paramContext;
          paramaanb.setSpan(new aamq(str1, paramInt, paramaamr), j, k, 33);
          localObject2 = paramContext;
          paramaanb.setSpan(new StyleSpan(1), j, k, 33);
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
  
  private static HashMap<String, ImageSpan> a(aanc paramaanc)
  {
    int i = 0;
    paramaanc = paramaanc.jdField_a_of_type_JavaLangCharSequence;
    if ((paramaanc != null) && ((paramaanc instanceof Spannable)))
    {
      paramaanc = (Spannable)paramaanc;
      paramaanc = (ImageSpan[])paramaanc.getSpans(0, paramaanc.length(), ImageSpan.class);
      if (paramaanc != null)
      {
        HashMap localHashMap = new HashMap();
        int j = paramaanc.length;
        while (i < j)
        {
          Object localObject = paramaanc[i];
          localHashMap.put(localObject.getSource(), localObject);
          i += 1;
        }
        return localHashMap;
      }
    }
    return null;
  }
  
  public static void a(aanc paramaanc, CharSequence paramCharSequence, HashMap<String, ImageSpan> paramHashMap, aanb paramaanb)
  {
    a(paramaanc, paramCharSequence, paramHashMap, paramaanb, true);
  }
  
  private static void a(aanc paramaanc, CharSequence paramCharSequence, HashMap<String, ImageSpan> paramHashMap, aanb paramaanb, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    if (TextUtils.isEmpty(paramaanb)) {}
    for (;;)
    {
      return;
      Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramaanb);
      try
      {
        while (localMatcher.find())
        {
          String str2 = localMatcher.group(1);
          if (str2.startsWith("https://qzonestyle.gtimg.cn/"))
          {
            localMatcher.group(2);
            localMatcher.group(3);
            int i = localMatcher.start();
            int j = localMatcher.end();
            String str1 = paramaanb.subSequence(i, j).toString();
            paramCharSequence = null;
            if (jdField_a_of_type_JavaUtilHashMap.containsKey(str1)) {
              paramCharSequence = (Drawable)jdField_a_of_type_JavaUtilHashMap.get(str1);
            }
            paramHashMap = paramCharSequence;
            if (paramCharSequence == null)
            {
              paramCharSequence = URLDrawable.URLDrawableOptions.obtain();
              paramCharSequence.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130848231);
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
            }
            if (paramHashMap != null)
            {
              jdField_a_of_type_JavaUtilHashMap.put(str1, paramHashMap);
              paramCharSequence = a(paramaanc, paramHashMap);
              if (paramCharSequence != null) {
                paramaanb.setSpan(paramCharSequence, i, j, 33);
              }
            }
          }
        }
        return;
      }
      catch (Exception paramaanc)
      {
        paramaanc.printStackTrace();
      }
    }
  }
  
  public static void a(aanc paramaanc, CharSequence paramCharSequence, HashMap<String, ImageSpan> paramHashMap, aanb paramaanb, boolean paramBoolean)
  {
    if (paramaanb == null) {
      return;
    }
    Matcher localMatcher = aagc.g.matcher(paramaanb);
    label14:
    int i;
    int j;
    String str;
    if (localMatcher.find())
    {
      paramaanb.c = true;
      i = localMatcher.start();
      j = localMatcher.end();
      str = paramaanb.subSequence(i, j).toString();
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
        if (arvq.a(str) == -1) {
          break label157;
        }
        paramCharSequence = arvq.a(arvq.a(str));
      }
    }
    for (;;)
    {
      if (paramCharSequence != null)
      {
        if (paramBoolean) {
          jdField_a_of_type_JavaUtilHashMap.put(str, paramCharSequence);
        }
        paramCharSequence = a(paramaanc, paramCharSequence);
        if (paramCharSequence == null) {
          break label14;
        }
        paramaanb.setSpan(paramCharSequence, i, j, 33);
        break label14;
        break;
        label157:
        if (arvj.a(str) == -1) {
          break label178;
        }
        paramCharSequence = arvj.a(arvj.a(str));
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
        paramCharSequence = bmpg.e(paramHashMap);
        paramHashMap = URLDrawable.URLDrawableOptions.obtain();
        paramHashMap.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130848231);
        paramCharSequence = URLDrawable.getDrawable(paramCharSequence, paramHashMap);
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
  
  public static void a(Context paramContext, aanb paramaanb, ColorStateList paramColorStateList, aamr paramaamr)
  {
    if ((TextUtils.isEmpty(paramaanb)) || (paramContext == null)) {}
    for (;;)
    {
      return;
      Matcher localMatcher = aagc.jdField_a_of_type_JavaUtilRegexPattern.matcher(paramaanb);
      int i = 0;
      while (localMatcher.find())
      {
        paramaanb.a = true;
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        Object localObject = a(str1, ",nickname:");
        String str2 = ((CertifiedAccountMeta.StUser)localObject).id.get();
        localObject = ((CertifiedAccountMeta.StUser)localObject).nick.get();
        paramaanb.replace(j, k - i, (CharSequence)localObject);
        k = str1.length();
        int m = ((String)localObject).length();
        int n = j + ((String)localObject).length();
        if (paramColorStateList != null) {
          paramaanb.setSpan(new TextAppearanceSpan(null, 1, (int)(14.0F * paramContext.getResources().getDisplayMetrics().density), paramColorStateList, null), j, n, 33);
        }
        paramaanb.setSpan(new aamq(str2, paramColorStateList, paramaamr), j, n, 33);
        i += k - m;
      }
    }
  }
  
  private static void a(Context paramContext, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((TextUtils.isEmpty(paramSpannableStringBuilder)) || (paramContext == null)) {
      return;
    }
    Matcher localMatcher = aagc.i.matcher(paramSpannableStringBuilder);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aana
 * JD-Core Version:    0.7.0.1
 */