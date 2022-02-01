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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class aklg
{
  private static HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap;
  private static List<Integer> jdField_a_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1000), Integer.valueOf(10004), Integer.valueOf(1020), Integer.valueOf(1003), Integer.valueOf(1005), Integer.valueOf(1004), Integer.valueOf(1008), Integer.valueOf(10005), Integer.valueOf(1009), Integer.valueOf(1021), Integer.valueOf(1022), Integer.valueOf(1023), Integer.valueOf(1024), Integer.valueOf(1025), Integer.valueOf(7400), Integer.valueOf(8112), Integer.valueOf(10008), Integer.valueOf(10010), Integer.valueOf(10009) });
  private static HashMap<Integer, Integer> jdField_b_of_type_JavaUtilHashMap;
  private static List<Integer> jdField_b_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(1001), Integer.valueOf(1010), Integer.valueOf(10002) });
  protected QQAppInterface a;
  private FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener;
  public FaceDecoder a;
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
  
  public aklg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public aklg(QQAppInterface paramQQAppInterface, FaceDecoder.DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this(paramQQAppInterface, paramDecodeTaskCompletionListener, false);
  }
  
  public aklg(QQAppInterface paramQQAppInterface, FaceDecoder.DecodeTaskCompletionListener paramDecodeTaskCompletionListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(BaseApplication.getContext(), paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(paramDecodeTaskCompletionListener);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener = paramDecodeTaskCompletionListener;
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
      return bfvo.b();
    case 4: 
      return bfvo.c();
    case 101: 
    case 113: 
    case 1001: 
      return bfvo.e();
    case 11: 
      return bfvo.b();
    case 102: 
      return bfvo.b(102);
    case 107: 
      return bfvo.b(107);
    case 103: 
      return bfvo.f();
    case 32: 
      return bfvo.b();
    case 115: 
      return bfvo.a(true);
    }
    return arid.a(6);
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
    if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(paramString)) {
      i = 2130840401;
    }
    for (;;)
    {
      return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
      if (AppConstants.MSG_BOX_INTERACT_UIN.equals(paramString))
      {
        i = 2130845382;
      }
      else if (AppConstants.MSG_BOX_FOLLOW_UIN.equals(paramString))
      {
        i = 2130845381;
      }
      else if (AppConstants.MSG_BOX_MYMOMMENT_UIN.equals(paramString))
      {
        i = 2130845383;
      }
      else if (AppConstants.MSG_BOX_DAREN_ASSISTANT_UIN.equals(paramString))
      {
        i = 2130845380;
      }
      else if (AppConstants.MSG_BOX_YANZHI_UIN.equals(paramString))
      {
        i = 2130845384;
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
      paramString = uex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 1);
      if ((paramString != null) && (paramString.a() != null)) {
        return paramString.a();
      }
      return uex.a(BaseApplication.getContext(), 1);
    }
    if (paramInt == 111)
    {
      paramString = uex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 3);
      if ((paramString != null) && (paramString.a() != null)) {}
      for (paramString = paramString.a();; paramString = uex.a(BaseApplication.getContext(), 3)) {
        return pay.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      }
    }
    if (paramInt == 106) {
      return ofx.a(BaseApplication.getContext());
    }
    if (paramInt == 108) {
      return ((ahux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(138)).a();
    }
    if (paramInt == 110)
    {
      paramString = uex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 2);
      if ((paramString != null) && (paramString.a() != null)) {
        return paramString.a();
      }
      return uex.a(BaseApplication.getContext(), 2);
    }
    if (paramInt == 112) {
      return BaseApplicationImpl.sApplication.getResources().getDrawable(uaw.a());
    }
    if (paramInt == 116) {
      return arid.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    }
    return null;
  }
  
  private static Pair<Integer, Integer> b(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int k = 2130844883;
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
      HotChatManager localHotChatManager = paramQQAppInterface.getHotChatMng(false);
      amtm localamtm = (amtm)paramQQAppInterface.getManager(255);
      if ((localamtm != null) && (localamtm.a(paramString))) {
        paramInt = 1;
      }
      for (;;)
      {
        if (((localHotChatManager != null) && (localHotChatManager.b(paramString))) || (paramInt != 0))
        {
          if (paramInt != 0)
          {
            paramInt = 2130838560;
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
      if (TroopUtils.hasSetTroopHead(paramString))
      {
        i = 4;
        paramInt = -2147483648;
      }
      else
      {
        i = 113;
        paramInt = -2147483648;
        continue;
        if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramString))
        {
          paramInt = 2130840406;
          i = j;
        }
        else
        {
          i = 103;
          paramInt = -2147483648;
          continue;
          i = 104;
          paramInt = 2130839606;
          continue;
          i = 106;
          paramInt = 2130846950;
          continue;
          if (TextUtils.isEmpty(uex.e)) {}
          for (paramInt = uaw.a();; paramInt = 2147483647)
          {
            i = 112;
            break;
          }
          paramInt = k;
          i = j;
          if (!TextUtils.equals(paramString, AppConstants.CONFESS_UIN))
          {
            paramInt = k;
            i = j;
            if (TextUtils.equals(paramString, AppConstants.CONFESS_FRD_REC_UIN))
            {
              paramInt = 2130844884;
              i = j;
            }
          }
        }
      }
    }
  }
  
  private static Pair<Integer, Integer> b(String paramString)
  {
    int i = 2130840407;
    int k = -2147483648;
    int j;
    if (String.valueOf(AppConstants.SYSTEM_MSG_UIN).equals(paramString)) {
      j = k;
    }
    for (;;)
    {
      return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
      j = k;
      if (!String.valueOf(AppConstants.QQBROADCAST_MSG_UIN).equals(paramString)) {
        if (String.valueOf(AppConstants.SAME_STATE_BOX_UIN).equals(paramString))
        {
          i = 2130840410;
          j = k;
        }
        else if (AppConstants.VOTE_MSG_UIN.equals(paramString))
        {
          i = 2130840541;
          j = k;
        }
        else if (AppConstants.NEW_KANDIAN_UIN.equals(paramString))
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
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1044), Integer.valueOf(116));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1045), Integer.valueOf(116));
  }
  
  private static void d()
  {
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(6000), Integer.valueOf(2130844119));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(6003), Integer.valueOf(2130844117));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(4000), Integer.valueOf(2130840397));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9002), Integer.valueOf(2130844622));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(5000), Integer.valueOf(2130840408));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(5001), Integer.valueOf(2130842572));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(7200), Integer.valueOf(2130840403));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9000), Integer.valueOf(2130840407));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9503), Integer.valueOf(2130840404));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9999), Integer.valueOf(2130839635));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(1031), Integer.valueOf(2130840385));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(6004), Integer.valueOf(2130850476));
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
          localObject = (avsy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
          if (localObject == null) {
            break label392;
          }
        }
      }
    }
    label392:
    for (Object localObject = ((avsy)localObject).c(paramRecentBaseData.mPhoneNumber);; localObject = null)
    {
      if (localObject != null)
      {
        localObject = FaceDrawable.getMobileFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.mPhoneNumber, (byte)3);
        paramRecentBaseData = (RecentBaseData)localObject;
        if (localObject == null) {
          paramRecentBaseData = bfvo.b();
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentFaceDecoder", 2, "getFaceDrawable end");
        }
        return paramRecentBaseData;
        paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(16, paramRecentBaseData.getRecentUserUin(), (byte)3, true, 16);
        if (paramRecentBaseData == null)
        {
          paramRecentBaseData = bfvo.b();
        }
        else
        {
          paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);
          continue;
          paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramRecentBaseData.getRecentUserUin(), (byte)3, true);
          if (paramRecentBaseData == null)
          {
            paramRecentBaseData = bfvo.b();
          }
          else
          {
            paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);
            continue;
            paramRecentBaseData = a(i, paramRecentBaseData.getRecentUserUin());
            continue;
            if (j == 26)
            {
              paramRecentBaseData = azij.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.getRecentUserUin());
            }
            else if (j == 1034)
            {
              j = 2130844865;
              i = j;
              if ((paramRecentBaseData instanceof RecentItemConfessMsg))
              {
                i = j;
                if (((RecentItemConfessMsg)paramRecentBaseData).mConfessInfo.confessorSex == 1) {
                  i = 2130844866;
                }
              }
              paramRecentBaseData = BaseApplication.getContext().getResources().getDrawable(i);
            }
            else if (aukz.a(j, paramRecentBaseData))
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramInt, paramString, false, 0);
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
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
        if (paramInt == 32) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(i, paramString, 200);
        }
      }
      for (;;)
      {
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("requestDecodeFace| [").append(paramString).append(",").append(paramInt).append(",").append(localObject1).append("], isPausing=");
          if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder == null)
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
          if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()))
          {
            if (i != 32) {
              break label325;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeStrangeFace(paramString, 200, true, false);
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 2");
          }
          return a(paramInt);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(i, paramString);
          break;
          localObject2 = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing());
          break label215;
          label325:
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, i, true, (byte)0);
          if ((i == 1001) && (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(101, paramString) == null)) {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, 101, true, (byte)0);
          }
        }
        label373:
        if (paramInt == 103)
        {
          localObject2 = BaseApplication.getContext().getResources().getDrawable(2130840392);
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
          if (!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramString)) {
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
    paramString1 = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, (byte)3);
    try
    {
      QLog.d("RecentFaceDecoder", 2, "getAppletsFolderDrawable width = " + paramInt1 + ", height = " + paramInt2 + ", url = " + paramString2 + ", urlSimple = " + paramString3);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = AIOUtils.dp2px(paramInt1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources());
      localURLDrawableOptions.mRequestHeight = AIOUtils.dp2px(paramInt2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources());
      localURLDrawableOptions.mLoadingDrawable = paramString1;
      localURLDrawableOptions.mFailedDrawable = paramString1;
      if (bbyp.a())
      {
        if (!TextUtils.isEmpty(paramString3))
        {
          paramInt1 = Math.min(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight);
          paramString3 = URLDrawable.getDrawable(paramString3, localURLDrawableOptions);
          paramString3.setTag(new int[] { paramInt1, paramInt1, (int)(paramInt1 * 0.07142858F) });
          paramString3.setDecodeHandler(bfol.j);
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
      localDrawable = bfvo.c();
      return URLDrawable.getDrawable(paramString.iconUrl, localDrawable, localDrawable);
    case 112: 
      paramString = BaseApplicationImpl.sApplication.getResources().getDrawable(uaw.a());
      return URLDrawable.getDrawable(uex.e, paramString, paramString);
    }
    Drawable localDrawable = bfvo.b();
    paramString = URLDrawable.getDrawable(paramString, localDrawable, localDrawable);
    paramString.setDecodeHandler(bfol.a);
    return paramString;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setAppRuntime(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void b()
  {
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aklg
 * JD-Core Version:    0.7.0.1
 */