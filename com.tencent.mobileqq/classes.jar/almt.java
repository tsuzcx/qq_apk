import android.content.Context;
import android.content.res.Resources;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class almt
{
  public double a;
  public int a;
  public almu a;
  @Deprecated
  public alny a;
  public NinePatch a;
  public String a;
  public HashMap<String, alnx> a;
  public List<Pair<almu, almu>> a;
  public boolean a;
  public String[] a;
  public int b;
  public almu b;
  public NinePatch b;
  public String b;
  public HashMap<String, String> b;
  List<View> b;
  public boolean b;
  public String[] b;
  public int c;
  public String c;
  List<View> c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  private int g;
  private int h;
  
  public almt(int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public almt(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
  }
  
  public almt(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, alny paramalny, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, double paramDouble, String[] paramArrayOfString, almu paramalmu1, int paramInt5, int paramInt6, almu paramalmu2, List<Pair<almu, almu>> paramList, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_e_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_Alny = paramalny;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Double = paramDouble;
    this.jdField_e_of_type_Int = paramInt5;
    this.jdField_f_of_type_Int = paramInt6;
    this.jdField_b_of_type_ArrayOfJavaLangString = paramArrayOfString;
    paramString1 = paramList;
    if (paramList == null) {
      paramString1 = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList = paramString1;
    this.jdField_a_of_type_Almu = paramalmu1;
    this.jdField_b_of_type_Almu = paramalmu2;
    paramString1 = paramHashMap;
    if (paramHashMap == null) {
      paramString1 = new HashMap();
    }
    this.jdField_b_of_type_JavaUtilHashMap = paramString1;
  }
  
  private Drawable a(Context paramContext, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("bubbleinfo_").append(paramInt1).append("_bg_").append(paramBoolean1).append("_").append(paramBoolean2);
    Object localObject = (Pair)BaseApplicationImpl.sImageCache.get(localStringBuffer.toString());
    if ((localObject != null) && (((Pair)localObject).first != null)) {
      paramContext = ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(paramContext.getResources());
    }
    do
    {
      return paramContext;
      Drawable localDrawable = paramContext.getResources().getDrawable(paramInt2);
      paramContext = paramContext.getResources().getDrawable(paramInt3);
      localObject = new StateListDrawable();
      if (localDrawable != null) {
        ((StateListDrawable)localObject).addState(new int[] { 16842919, 16842910 }, localDrawable);
      }
      if (paramContext != null)
      {
        ((StateListDrawable)localObject).addState(new int[] { 16842910 }, paramContext);
        ((StateListDrawable)localObject).addState(new int[] { -16842910 }, paramContext);
      }
      paramInt1 = azzg.a(localDrawable) + azzg.a(paramContext);
      paramContext = (Context)localObject;
    } while (paramInt1 <= 0);
    BaseApplicationImpl.sImageCache.put(localStringBuffer.toString(), new Pair(((StateListDrawable)localObject).getConstantState(), Integer.valueOf(paramInt1)));
    return localObject;
  }
  
  private Pair<almu, almu> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Pair localPair;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localPair = (Pair)localIterator.next();
      } while (!paramString.equals(((almu)localPair.first).jdField_b_of_type_JavaLangString));
    }
    for (paramString = localPair;; paramString = null) {
      return paramString;
    }
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, View paramView, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleInfo", 2, "getBubbleDrawable, bubbleId=" + this.jdField_a_of_type_Int + ", isUser=" + paramBoolean1 + ", needVipBubble=" + paramBoolean2 + ", useAnimationBg=" + paramBoolean3 + ", senderUin=" + paramString);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    boolean bool;
    if (paramBoolean2)
    {
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
        break label650;
      }
      localObject2 = new alok(paramQQAppInterface.getApp().getResources(), this.jdField_a_of_type_AndroidGraphicsNinePatch, this.jdField_b_of_type_AndroidGraphicsNinePatch, this.jdField_a_of_type_Int);
      if (paramBoolean1) {
        break label644;
      }
      bool = true;
      ((alok)localObject2).a(bool, paramBoolean3);
      if (QLog.isColorLevel()) {
        QLog.d("BubbleInfo", 2, "getBubbleDrawable, bubbleId=" + this.jdField_a_of_type_Int + ", vipBubbleDrawable=" + localObject2);
      }
      localObject1 = localObject2;
      if (!BubbleManager.jdField_a_of_type_Boolean)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Int != 0)
        {
          BubbleManager.jdField_a_of_type_Boolean = true;
          localObject1 = localObject2;
        }
      }
    }
    label221:
    label235:
    Object localObject3;
    if (localObject1 == null) {
      if (paramBoolean1)
      {
        localObject2 = "bubblebg://default_mine";
        if (BaseApplicationImpl.sImageCache == null) {
          break label860;
        }
        localObject3 = (Drawable.ConstantState)BaseApplicationImpl.sImageCache.get(localObject2);
        if (localObject3 == null) {
          break label860;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BubbleInfo", 2, "getBubbleDrawable, get Default from imageCache, key=" + (String)localObject2 + ", bubbleId=" + this.jdField_a_of_type_Int);
        }
        localObject1 = ((Drawable.ConstantState)localObject3).newDrawable();
      }
    }
    label339:
    label728:
    label860:
    for (;;)
    {
      localObject2 = localObject1;
      int i;
      if (localObject1 == null)
      {
        localObject2 = paramQQAppInterface.getApp().getResources();
        if (!paramBoolean1) {
          break label720;
        }
        i = 2130848703;
        localObject1 = ((Resources)localObject2).getDrawable(i);
        if (!paramBoolean1) {
          break label728;
        }
        i = 2130848702;
        label357:
        localObject2 = ((Resources)localObject2).getDrawable(i);
        localObject3 = new StateListDrawable();
        ((StateListDrawable)localObject3).addState(new int[] { 16842919 }, (Drawable)localObject1);
        ((StateListDrawable)localObject3).addState(new int[] { 16842910 }, (Drawable)localObject2);
        localObject2 = localObject3;
        if (BaseApplicationImpl.sImageCache != null)
        {
          if (!paramBoolean1) {
            break label736;
          }
          localObject1 = "bubblebg://default_mine";
          if (QLog.isColorLevel()) {
            QLog.d("BubbleInfo", 2, "getBubbleDrawable, put default bubble to imageCache, key=" + (String)localObject1 + ", bubbleId=" + this.jdField_a_of_type_Int);
          }
          BaseApplicationImpl.sImageCache.put(localObject1, ((StateListDrawable)localObject3).getConstantState());
          localObject2 = localObject3;
        }
      }
      int j;
      if (((localObject2 instanceof alok)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
      {
        if ((this.jdField_a_of_type_Alny == null) || (paramView == null)) {
          break label832;
        }
        j = paramView.getWidth();
        if (this.jdField_a_of_type_Alny.jdField_c_of_type_Int == 0) {
          ((alok)localObject2).a(true, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Alny.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_Alny.jdField_a_of_type_JavaLangString);
        }
      }
      else if (((localObject2 instanceof alok)) && (paramBoolean2) && (!paramBoolean3) && (paramInt > 0))
      {
        paramString = paramString + "_" + paramInt;
        localObject1 = (alok)localObject2;
        if (paramBoolean1) {
          break label855;
        }
      }
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        ((alok)localObject1).a(paramQQAppInterface, paramString, paramBoolean1);
        a(paramView, (Drawable)localObject2);
        return localObject2;
        bool = false;
        break;
        if (this.jdField_a_of_type_Int != 100000)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Int != 100001) {
            break label221;
          }
        }
        if (paramBoolean1) {}
        for (localObject1 = null;; localObject1 = a(paramQQAppInterface.getApp(), this.jdField_a_of_type_Int, paramBoolean1, paramBoolean3, this.g, this.h)) {
          break;
        }
        localObject2 = "bubblebg://default_friend";
        break label235;
        i = 2130848510;
        break label339;
        i = 2130848509;
        break label357;
        label736:
        localObject1 = "bubblebg://default_friend";
        break label424;
        i = j;
        if (j == 0)
        {
          paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          i = paramView.getMeasuredWidth();
        }
        if (i > this.jdField_a_of_type_Alny.jdField_c_of_type_Int)
        {
          ((alok)localObject2).a(true, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Alny.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_Alny.jdField_a_of_type_JavaLangString);
          break label562;
        }
        ((alok)localObject2).a(false, null, null, null);
        break label562;
        if (!(localObject2 instanceof alok)) {
          break label562;
        }
        ((alok)localObject2).a(false, null, null, null);
        break label562;
      }
    }
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, View paramView, boolean paramBoolean4)
  {
    alny localalny = this.jdField_a_of_type_Alny;
    if (!paramBoolean4) {
      this.jdField_a_of_type_Alny = null;
    }
    paramQQAppInterface = a(paramQQAppInterface, paramBoolean1, paramBoolean2, paramBoolean3, paramView, "", 0);
    this.jdField_a_of_type_Alny = localalny;
    return paramQQAppInterface;
  }
  
  public Pair<almu, almu> a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject3 = null;
    Object localObject1;
    if (paramQQAppInterface != null)
    {
      localObject1 = (BubbleManager)paramQQAppInterface.getManager(44);
      localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = ((BubbleManager)localObject1).a(this.jdField_a_of_type_Int, true);
        if (localObject2 != null) {
          break label53;
        }
        localObject2 = localObject3;
      }
    }
    label53:
    label102:
    do
    {
      do
      {
        return localObject2;
        localObject1 = null;
        break;
        switch (paramInt)
        {
        case 4: 
        case 5: 
        default: 
          paramQQAppInterface = null;
          localObject2 = localObject3;
        }
      } while (TextUtils.isEmpty(paramQQAppInterface));
      localObject2 = a(paramQQAppInterface);
      localObject1 = ((BubbleManager)localObject1).a(this.jdField_a_of_type_Int, paramQQAppInterface, (Pair)localObject2);
      localObject2 = localObject1;
    } while (!QLog.isDevelopLevel());
    Object localObject2 = new StringBuilder().append("getAttrs|key=").append(paramQQAppInterface).append(", animAttrs=");
    if (localObject1 == null) {}
    for (paramQQAppInterface = "null";; paramQQAppInterface = "first:" + ((Pair)localObject1).first + ",second:" + ((Pair)localObject1).second)
    {
      QLog.w("BubbleInfo", 4, paramQQAppInterface);
      return localObject1;
      if (((almq)localObject2).a == null) {
        break;
      }
      paramQQAppInterface = ((almq)localObject2).a.jdField_b_of_type_JavaLangString;
      break label102;
      if (((almq)localObject2).b == null) {
        break;
      }
      paramQQAppInterface = ((almq)localObject2).b.jdField_b_of_type_JavaLangString;
      break label102;
      paramQQAppInterface = "width";
      if (((almq)localObject2).c == null) {
        break label102;
      }
      paramQQAppInterface = ((almq)localObject2).c.jdField_b_of_type_JavaLangString;
      break label102;
      if ((this.jdField_b_of_type_JavaUtilHashMap == null) || (this.jdField_b_of_type_JavaUtilHashMap.size() <= 0) || (this.jdField_f_of_type_JavaLangString == null)) {
        break;
      }
      paramQQAppInterface = (String)this.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_f_of_type_JavaLangString);
      break label102;
      if (((almq)localObject2).d == null) {
        break;
      }
      paramQQAppInterface = ((almq)localObject2).d.jdField_b_of_type_JavaLangString;
      break label102;
      if (((almq)localObject2).e == null) {
        break;
      }
      paramQQAppInterface = ((almq)localObject2).e.jdField_b_of_type_JavaLangString;
      break label102;
    }
  }
  
  public String a(String paramString)
  {
    if ((this.jdField_b_of_type_ArrayOfJavaLangString != null) && (!TextUtils.isEmpty(paramString)))
    {
      String[] arrayOfString = this.jdField_b_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (paramString.indexOf(str.toLowerCase()) != -1)
        {
          this.jdField_f_of_type_JavaLangString = str;
          return str;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public void a()
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void a(View paramView, Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (paramView == null)) {
      return;
    }
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    int i = paramView.getPaddingTop();
    int j = localRect.top;
    int k = paramView.getPaddingLeft();
    int m = localRect.left;
    int n = paramView.getPaddingRight();
    int i1 = localRect.right;
    int i2 = paramView.getPaddingBottom();
    int i3 = localRect.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(k + m, i + j, n + i1, i3 + i2);
  }
  
  public void a(View arg1, View paramView2)
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      this.jdField_b_of_type_JavaUtilList.remove(???);
    }
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      this.jdField_c_of_type_JavaUtilList.remove(paramView2);
      return;
      ??? = finally;
      throw ???;
    }
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_e_of_type_Int > 0) && (this.jdField_f_of_type_Int > this.jdField_e_of_type_Int) && (paramInt >= this.jdField_e_of_type_Int) && (paramInt <= this.jdField_f_of_type_Int);
  }
  
  public String toString()
  {
    return "BubbleInfo [bubbleId=" + this.jdField_a_of_type_Int + ",aioUserBgNorResPath=" + this.jdField_a_of_type_JavaLangString + ",aioUserPicNorResPath=" + this.jdField_b_of_type_JavaLangString + ",bubbleThumbnailResPath=" + this.jdField_d_of_type_JavaLangString + ",bubbleChartletResPath=" + this.jdField_e_of_type_JavaLangString + ", mTextColor=" + this.jdField_b_of_type_Int + ", mKeyWords=" + Arrays.toString(this.jdField_b_of_type_ArrayOfJavaLangString) + ", currKeyWord=" + this.jdField_f_of_type_JavaLangString + ", mBubbleHeightBegin=" + this.jdField_e_of_type_Int + ", mBubbleHeightEnd=" + this.jdField_f_of_type_Int + ", pttAttrs=" + this.jdField_a_of_type_Almu + ", heightAttrs=" + this.jdField_b_of_type_Almu + ", keywordAttrs=" + this.jdField_a_of_type_JavaUtilList + ", keyWorsAnimMap=" + this.jdField_b_of_type_JavaUtilHashMap + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     almt
 * JD-Core Version:    0.7.0.1
 */