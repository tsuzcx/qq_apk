import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class alno
{
  private static HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap;
  private static List<Integer> jdField_a_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1000), Integer.valueOf(10004), Integer.valueOf(1020), Integer.valueOf(1003), Integer.valueOf(1005), Integer.valueOf(1004), Integer.valueOf(1008), Integer.valueOf(10005), Integer.valueOf(1009), Integer.valueOf(1021), Integer.valueOf(1022), Integer.valueOf(1023), Integer.valueOf(1024), Integer.valueOf(1025), Integer.valueOf(7400), Integer.valueOf(8112), Integer.valueOf(10008), Integer.valueOf(10010), Integer.valueOf(10009) });
  private static HashMap<Integer, Integer> jdField_b_of_type_JavaUtilHashMap;
  private static List<Integer> jdField_b_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(1001), Integer.valueOf(1010), Integer.valueOf(10002) });
  public aoof a;
  private aoog jdField_a_of_type_Aoog;
  protected QQAppInterface a;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    c();
    d();
  }
  
  public alno(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public alno(QQAppInterface paramQQAppInterface, aoog paramaoog)
  {
    this(paramQQAppInterface, paramaoog, false);
  }
  
  public alno(QQAppInterface paramQQAppInterface, aoog paramaoog, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aoof = new aoof(BaseApplication.getContext(), paramQQAppInterface);
    this.jdField_a_of_type_Aoof.a(paramaoog);
    this.jdField_a_of_type_Aoog = paramaoog;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  private Drawable a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return bhmq.b();
    case 4: 
      return bhmq.c();
    case 101: 
    case 113: 
    case 1001: 
      return bhmq.e();
    case 11: 
      return bhmq.b();
    case 102: 
      return bhmq.b(102);
    case 107: 
      return bhmq.b(107);
    case 103: 
      return bhmq.f();
    case 32: 
      return bhmq.b();
    }
    return bhmq.a(true);
  }
  
  public static Pair<Integer, Integer> a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return new Pair(jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)), Integer.valueOf(-2147483648));
    }
    if (jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return new Pair(Integer.valueOf(-2147483648), jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    }
    if (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) {
      return b(paramString);
    }
    if (jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) {
      return a(paramString);
    }
    return b(paramQQAppInterface, paramInt, paramString);
  }
  
  private static Pair<Integer, Integer> a(String paramString)
  {
    int j = -2147483648;
    int i;
    if (String.valueOf(antf.H).equals(paramString)) {
      i = 2130840363;
    }
    for (;;)
    {
      return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
      if (antf.al.equals(paramString))
      {
        i = 2130845503;
      }
      else if (antf.am.equals(paramString))
      {
        i = 2130845502;
      }
      else if (antf.an.equals(paramString))
      {
        i = 2130845504;
      }
      else if (antf.ao.equals(paramString))
      {
        i = 2130845501;
      }
      else if (antf.ap.equals(paramString))
      {
        i = 2130845505;
      }
      else
      {
        j = 32;
        i = -2147483648;
      }
    }
  }
  
  private Drawable b(String paramString, int paramInt)
  {
    if (paramInt == 104) {
      return DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(paramString);
    }
    if (paramInt == 105)
    {
      paramString = tyi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 1);
      if ((paramString != null) && (paramString.a() != null)) {
        return paramString.a();
      }
      return tyi.a(BaseApplication.getContext(), 1);
    }
    if (paramInt == 111)
    {
      paramString = tyi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 3);
      if ((paramString != null) && (paramString.a() != null)) {}
      for (paramString = paramString.a();; paramString = tyi.a(BaseApplication.getContext(), 3)) {
        return ozs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      }
    }
    if (paramInt == 106) {
      return oek.a(BaseApplication.getContext());
    }
    if (paramInt == 108) {
      return ((ajan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(138)).a();
    }
    if (paramInt == 110)
    {
      paramString = tyi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 2);
      if ((paramString != null) && (paramString.a() != null)) {
        return paramString.a();
      }
      return tyi.a(BaseApplication.getContext(), 2);
    }
    if (paramInt == 112) {
      return BaseApplicationImpl.sApplication.getResources().getDrawable(tug.a());
    }
    return null;
  }
  
  private static Pair<Integer, Integer> b(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int k = 2130845002;
    int j = -2147483648;
    int i;
    switch (paramInt)
    {
    default: 
      paramInt = -2147483648;
      i = j;
    }
    for (;;)
    {
      return Pair.create(Integer.valueOf(i), Integer.valueOf(paramInt));
      HotChatManager localHotChatManager = paramQQAppInterface.a(false);
      anzm localanzm = (anzm)paramQQAppInterface.getManager(255);
      if ((localanzm != null) && (localanzm.a(paramString))) {
        paramInt = 1;
      }
      for (;;)
      {
        if (((localHotChatManager != null) && (localHotChatManager.b(paramString))) || (paramInt != 0))
        {
          if (paramInt != 0)
          {
            paramInt = 2130838535;
            i = j;
            break;
            paramInt = 0;
            continue;
          }
          paramInt = HotChatManager.a(paramString, paramQQAppInterface);
          i = j;
          break;
        }
      }
      if (bguq.a(paramString))
      {
        i = 4;
        paramInt = -2147483648;
      }
      else
      {
        i = 113;
        paramInt = -2147483648;
        continue;
        if (antf.x.equals(paramString))
        {
          paramInt = 2130840368;
          i = j;
        }
        else
        {
          i = 103;
          paramInt = -2147483648;
          continue;
          i = 104;
          paramInt = 2130839571;
          continue;
          i = 106;
          paramInt = 2130847042;
          continue;
          if (TextUtils.isEmpty(tyi.e)) {}
          for (paramInt = tug.a();; paramInt = 2147483647)
          {
            i = 112;
            break;
          }
          paramInt = k;
          i = j;
          if (!TextUtils.equals(paramString, antf.aM))
          {
            paramInt = k;
            i = j;
            if (TextUtils.equals(paramString, antf.aN))
            {
              paramInt = 2130845003;
              i = j;
            }
          }
        }
      }
    }
  }
  
  private static Pair<Integer, Integer> b(String paramString)
  {
    int i = 2130840369;
    int k = -2147483648;
    int j;
    if (String.valueOf(antf.G).equals(paramString)) {
      j = k;
    }
    for (;;)
    {
      return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
      j = k;
      if (!String.valueOf(antf.J).equals(paramString)) {
        if (String.valueOf(antf.w).equals(paramString))
        {
          i = 2130840372;
          j = k;
        }
        else if (antf.E.equals(paramString))
        {
          i = 2130840506;
          j = k;
        }
        else if (antf.az.equals(paramString))
        {
          j = 110;
          i = -2147483648;
        }
        else
        {
          j = 1;
          i = -2147483648;
        }
      }
    }
  }
  
  private static void c()
  {
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(6002), Integer.valueOf(104));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1006), Integer.valueOf(11));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3000), Integer.valueOf(101));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3002), Integer.valueOf(1001));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(8113), Integer.valueOf(4));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(9003), Integer.valueOf(108));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(7210), Integer.valueOf(105));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(7220), Integer.valueOf(111));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1033), Integer.valueOf(1));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1044), Integer.valueOf(1));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1045), Integer.valueOf(1));
  }
  
  private static void d()
  {
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(6000), Integer.valueOf(2130844234));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(6003), Integer.valueOf(2130844232));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(4000), Integer.valueOf(2130840359));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9002), Integer.valueOf(2130844746));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(5000), Integer.valueOf(2130840370));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(5001), Integer.valueOf(2130842526));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(7200), Integer.valueOf(2130840365));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9000), Integer.valueOf(2130840369));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9503), Integer.valueOf(2130840366));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9999), Integer.valueOf(2130839598));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(1031), Integer.valueOf(2130840347));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(6004), Integer.valueOf(2130850551));
  }
  
  public Drawable a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, true);
  }
  
  public Drawable a(int paramInt, String paramString, boolean paramBoolean)
  {
    Pair localPair = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramString);
    int i = ((Integer)localPair.first).intValue();
    int j = ((Integer)localPair.second).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable uintype = " + paramInt + ", uin = " + paramString + ", isGetResFace = " + paramBoolean + ", faceType = " + i + ", faceResId = " + j);
    }
    if (j == 2147483647) {}
    try
    {
      return a(i, paramString);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    if (i != -2147483648) {
      return a(paramString, i);
    }
    if ((j != -2147483648) && (paramBoolean))
    {
      paramString = BaseApplication.getContext().getResources().getDrawable(j);
      return paramString;
    }
    return null;
  }
  
  public Drawable a(RecentBaseData paramRecentBaseData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable start");
    }
    int j = paramRecentBaseData.getRecentUserType();
    int i;
    if (paramRecentBaseData.getRecentUserType() == 8)
    {
      i = paramRecentBaseData.mExtraType;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "getFaceDrawable type = " + i);
      }
      if (i != 0) {
        if (i == 25)
        {
          localObject = (axfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
          if (localObject == null) {
            break label392;
          }
        }
      }
    }
    label392:
    for (Object localObject = ((axfr)localObject).c(paramRecentBaseData.mPhoneNumber);; localObject = null)
    {
      if (localObject != null)
      {
        localObject = aoot.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.mPhoneNumber, (byte)3);
        paramRecentBaseData = (RecentBaseData)localObject;
        if (localObject == null) {
          paramRecentBaseData = bhmq.b();
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentFaceDecoder", 2, "getFaceDrawable end");
        }
        return paramRecentBaseData;
        paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(16, paramRecentBaseData.getRecentUserUin(), (byte)3, true, 16);
        if (paramRecentBaseData == null)
        {
          paramRecentBaseData = bhmq.b();
        }
        else
        {
          paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);
          continue;
          paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramRecentBaseData.getRecentUserUin(), (byte)3, true);
          if (paramRecentBaseData == null)
          {
            paramRecentBaseData = bhmq.b();
          }
          else
          {
            paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);
            continue;
            paramRecentBaseData = a(i, paramRecentBaseData.getRecentUserUin());
            continue;
            if (j == 26)
            {
              paramRecentBaseData = baob.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.getRecentUserUin());
            }
            else if (j == 1034)
            {
              j = 2130844984;
              i = j;
              if ((paramRecentBaseData instanceof RecentItemConfessMsg))
              {
                i = j;
                if (((RecentItemConfessMsg)paramRecentBaseData).mConfessInfo.confessorSex == 1) {
                  i = 2130844985;
                }
              }
              paramRecentBaseData = BaseApplication.getContext().getResources().getDrawable(i);
            }
            else if (avxz.a(j, paramRecentBaseData))
            {
              paramRecentBaseData = a(114, ((RecentItemImaxADData)paramRecentBaseData).mHeaderUrl);
            }
            else
            {
              localObject = paramRecentBaseData.getRecentUserUin();
              i = j;
              if ((paramRecentBaseData instanceof RecentCallItem))
              {
                i = j;
                if (((RecentCallItem)paramRecentBaseData).a()) {
                  i = 3002;
                }
              }
              paramRecentBaseData = a(i, (String)localObject);
            }
          }
        }
      }
    }
  }
  
  public Drawable a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable facetype = " + paramInt + ", uin = " + paramString);
    }
    Object localObject2 = b(paramString, paramInt);
    if (localObject2 != null) {
      return localObject2;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt, paramString, false, 0);
      return null;
    }
    if ((this.jdField_b_of_type_Boolean) && (!this.c))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 1");
      }
      return a(paramInt);
    }
    if (paramInt == 103) {}
    for (int i = 1;; i = paramInt)
    {
      Object localObject1;
      if (this.jdField_a_of_type_Aoof != null) {
        if (paramInt == 32) {
          localObject1 = this.jdField_a_of_type_Aoof.a(i, paramString, 200);
        }
      }
      for (;;)
      {
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("requestDecodeFace| [").append(paramString).append(",").append(paramInt).append(",").append(localObject1).append("], isPausing=");
          if (this.jdField_a_of_type_Aoof == null)
          {
            localObject2 = "null";
            label215:
            QLog.i("Q.recent", 4, localObject2);
          }
        }
        else
        {
          if (localObject1 != null) {
            break label373;
          }
          if ((this.jdField_a_of_type_Aoof != null) && (!this.jdField_a_of_type_Aoof.a()))
          {
            if (i != 32) {
              break label325;
            }
            this.jdField_a_of_type_Aoof.a(paramString, 200, true, false);
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 2");
          }
          return a(paramInt);
          localObject1 = this.jdField_a_of_type_Aoof.a(i, paramString);
          break;
          localObject2 = Boolean.valueOf(this.jdField_a_of_type_Aoof.a());
          break label215;
          label325:
          this.jdField_a_of_type_Aoof.a(paramString, i, true, (byte)0);
          if ((i == 1001) && (this.jdField_a_of_type_Aoof.a(101, paramString) == null)) {
            this.jdField_a_of_type_Aoof.a(paramString, 101, true, (byte)0);
          }
        }
        label373:
        if (paramInt == 103)
        {
          localObject2 = BaseApplication.getContext().getResources().getDrawable(2130840354);
          if ((localObject2 instanceof SkinnableBitmapDrawable)) {
            ((SkinnableBitmapDrawable)localObject2).setGravity(81);
          }
          if ((localObject2 instanceof BitmapDrawable)) {
            ((BitmapDrawable)localObject2).setGravity(81);
          }
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        }
        for (localObject1 = new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject1), localObject2 });; localObject1 = new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject1))
        {
          localObject2 = localObject1;
          if (!antf.aQ.equals(paramString)) {
            break;
          }
          return KandianSubscribeManager.a((Drawable)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject1 = null;
      }
    }
  }
  
  public Drawable a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    paramString1 = aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, (byte)3);
    try
    {
      QLog.d("RecentFaceDecoder", 2, "getAppletsFolderDrawable width = " + paramInt1 + ", height = " + paramInt2 + ", url = " + paramString2 + ", urlSimple = " + paramString3);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = agej.a(paramInt1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources());
      localURLDrawableOptions.mRequestHeight = agej.a(paramInt2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources());
      localURLDrawableOptions.mLoadingDrawable = paramString1;
      localURLDrawableOptions.mFailedDrawable = paramString1;
      if (bdgb.a())
      {
        if (!TextUtils.isEmpty(paramString3))
        {
          paramInt1 = Math.min(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight);
          paramString3 = URLDrawable.getDrawable(paramString3, localURLDrawableOptions);
          paramString3.setTag(new int[] { paramInt1, paramInt1, (int)(paramInt1 * 0.07142858F) });
          paramString3.setDecodeHandler(bhez.j);
          return paramString3;
        }
      }
      else if (!TextUtils.isEmpty(paramString2))
      {
        paramString3 = URLDrawable.getDrawable(paramString2, localURLDrawableOptions);
        return paramString3;
      }
    }
    catch (Exception paramString3)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RecentFaceDecoder", 2, "getAppletsFolderDrawable illegal url format: " + paramString2);
      }
    }
    return paramString1;
  }
  
  public URLDrawable a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1000: 
      paramString = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(paramString);
      localDrawable = bhmq.c();
      return URLDrawable.getDrawable(paramString.iconUrl, localDrawable, localDrawable);
    case 112: 
      paramString = BaseApplicationImpl.sApplication.getResources().getDrawable(tug.a());
      return URLDrawable.getDrawable(tyi.e, paramString, paramString);
    }
    Drawable localDrawable = bhmq.b();
    paramString = URLDrawable.getDrawable(paramString, localDrawable, localDrawable);
    paramString.setDecodeHandler(bhez.a);
    return paramString;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aoof != null)
    {
      this.jdField_a_of_type_Aoof.d();
      this.jdField_a_of_type_Aoof = null;
    }
    this.jdField_a_of_type_Aoog = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Aoof != null)
    {
      this.jdField_a_of_type_Aoof.a(paramQQAppInterface);
      this.jdField_a_of_type_Aoof.a(this.jdField_a_of_type_Aoog);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void b()
  {
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alno
 * JD-Core Version:    0.7.0.1
 */