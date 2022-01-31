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

public class ajfa
{
  public bcws a;
  private bcwt jdField_a_of_type_Bcwt;
  protected QQAppInterface a;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public ajfa(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public ajfa(QQAppInterface paramQQAppInterface, bcwt parambcwt)
  {
    this(paramQQAppInterface, parambcwt, false);
  }
  
  public ajfa(QQAppInterface paramQQAppInterface, bcwt parambcwt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bcws = new bcws(BaseApplication.getContext(), paramQQAppInterface);
    this.jdField_a_of_type_Bcws.a(parambcwt);
    this.jdField_a_of_type_Bcwt = parambcwt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramBoolean;
  }
  
  private Drawable a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return bdda.b();
    case 4: 
      return bdda.c();
    case 101: 
    case 113: 
    case 1001: 
      return bdda.e();
    case 11: 
      return bdda.b();
    case 102: 
      return bdda.b(102);
    case 107: 
      return bdda.b(107);
    case 103: 
      return bdda.f();
    case 32: 
      return bdda.b();
    }
    return bdda.a(true);
  }
  
  public static Pair<Integer, Integer> a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int k = -2147483648;
    int m = 2130840178;
    int n = 1;
    int i = m;
    int j = k;
    switch (paramInt)
    {
    default: 
      i = -2147483648;
      j = k;
    }
    for (;;)
    {
      return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
      i = m;
      j = k;
      if (!String.valueOf(aljq.G).equals(paramString))
      {
        i = m;
        j = k;
        if (!String.valueOf(aljq.J).equals(paramString)) {
          if (String.valueOf(aljq.w).equals(paramString))
          {
            i = 2130840181;
            j = k;
          }
          else if (aljq.E.equals(paramString))
          {
            i = 2130840316;
            j = k;
          }
          else if (aljq.az.equals(paramString))
          {
            j = 110;
            i = -2147483648;
          }
          else
          {
            i = -2147483648;
            j = 1;
            continue;
            if (String.valueOf(aljq.H).equals(paramString))
            {
              i = 2130840172;
              j = k;
            }
            else if (aljq.al.equals(paramString))
            {
              i = 2130845020;
              j = k;
            }
            else if (aljq.am.equals(paramString))
            {
              i = 2130845019;
              j = k;
            }
            else if (aljq.an.equals(paramString))
            {
              i = 2130845021;
              j = k;
            }
            else if (aljq.ao.equals(paramString))
            {
              i = 2130845018;
              j = k;
            }
            else if (aljq.ap.equals(paramString))
            {
              i = 2130845022;
              j = k;
            }
            else
            {
              j = 32;
              i = -2147483648;
              continue;
              i = 2130843762;
              j = k;
              continue;
              i = 2130843760;
              j = k;
              continue;
              j = 104;
              i = -2147483648;
              continue;
              j = 11;
              i = -2147483648;
              continue;
              j = 101;
              i = -2147483648;
              continue;
              j = 1001;
              i = -2147483648;
              continue;
              i = -2147483648;
              j = 4;
              continue;
              HotChatManager localHotChatManager = paramQQAppInterface.a(false);
              alpr localalpr = (alpr)paramQQAppInterface.getManager(255);
              if ((localalpr != null) && (localalpr.a(paramString))) {
                paramInt = n;
              }
              for (;;)
              {
                if (((localHotChatManager != null) && (localHotChatManager.b(paramString))) || (paramInt != 0))
                {
                  if (paramInt != 0)
                  {
                    i = 2130838415;
                    j = k;
                    break;
                    paramInt = 0;
                    continue;
                  }
                  i = HotChatManager.a(paramString, paramQQAppInterface);
                  j = k;
                  break;
                }
              }
              if (bclo.a(paramString))
              {
                i = -2147483648;
                j = 4;
              }
              else
              {
                j = 113;
                i = -2147483648;
                continue;
                i = 2130840169;
                j = k;
                continue;
                i = 2130844266;
                j = k;
                continue;
                i = 2130840179;
                j = k;
                continue;
                i = 2130842190;
                j = k;
                continue;
                if (aljq.x.equals(paramString))
                {
                  i = 2130840177;
                  j = k;
                }
                else
                {
                  j = 103;
                  i = -2147483648;
                  continue;
                  i = 2130840174;
                  j = k;
                  continue;
                  j = 104;
                  i = 2130839382;
                  continue;
                  j = 108;
                  i = -2147483648;
                  continue;
                  j = 105;
                  i = -2147483648;
                  continue;
                  j = 111;
                  i = -2147483648;
                  continue;
                  j = 106;
                  i = 2130846511;
                  continue;
                  if (TextUtils.isEmpty(swy.e)) {}
                  for (i = ssp.a();; i = 2147483647)
                  {
                    j = 112;
                    break;
                  }
                  i = 2130840175;
                  j = k;
                  continue;
                  i = 2130839409;
                  j = k;
                  continue;
                  i = 2130840157;
                  j = k;
                  continue;
                  i = ((bcgi)paramQQAppInterface.getManager(183)).a();
                  j = k;
                  continue;
                  if (TextUtils.equals(paramString, aljq.aN))
                  {
                    i = 2130844521;
                    j = k;
                  }
                  else if (TextUtils.equals(paramString, aljq.aO))
                  {
                    i = 2130844522;
                    j = k;
                  }
                  else
                  {
                    i = 2130844521;
                    j = k;
                    continue;
                    i = -2147483648;
                    j = 1;
                    continue;
                    i = 2130849873;
                    j = k;
                  }
                }
              }
            }
          }
        }
      }
    }
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
    int j = paramRecentBaseData.a();
    int i;
    if (paramRecentBaseData.a() == 8)
    {
      i = paramRecentBaseData.mExtraType;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "getFaceDrawable type = " + i);
      }
      if (i != 0) {
        if (i == 25)
        {
          localObject = (aubm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
          if (localObject == null) {
            break label390;
          }
        }
      }
    }
    label390:
    for (Object localObject = ((aubm)localObject).c(paramRecentBaseData.mPhoneNumber);; localObject = null)
    {
      if (localObject != null)
      {
        localObject = bcxb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.mPhoneNumber, (byte)3);
        paramRecentBaseData = (RecentBaseData)localObject;
        if (localObject == null) {
          paramRecentBaseData = bdda.b();
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentFaceDecoder", 2, "getFaceDrawable end");
        }
        return paramRecentBaseData;
        paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(16, paramRecentBaseData.a(), (byte)3, true, 16);
        if (paramRecentBaseData == null)
        {
          paramRecentBaseData = bdda.b();
        }
        else
        {
          paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);
          continue;
          paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramRecentBaseData.a(), (byte)3, true);
          if (paramRecentBaseData == null)
          {
            paramRecentBaseData = bdda.b();
          }
          else
          {
            paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);
            continue;
            paramRecentBaseData = a(i, paramRecentBaseData.a());
            continue;
            if (j == 26)
            {
              paramRecentBaseData = awvn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.a());
            }
            else if (j == 1034)
            {
              j = 2130844503;
              i = j;
              if ((paramRecentBaseData instanceof RecentItemConfessMsg))
              {
                i = j;
                if (((RecentItemConfessMsg)paramRecentBaseData).mConfessInfo.confessorSex == 1) {
                  i = 2130844504;
                }
              }
              paramRecentBaseData = BaseApplication.getContext().getResources().getDrawable(i);
            }
            else if (astv.a(j, paramRecentBaseData))
            {
              paramRecentBaseData = a(114, ((RecentItemImaxADData)paramRecentBaseData).mHeaderUrl);
            }
            else
            {
              localObject = paramRecentBaseData.a();
              i = j;
              if ((paramRecentBaseData instanceof RecentCallItem))
              {
                i = j;
                if (((RecentCallItem)paramRecentBaseData).b()) {
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
    Object localObject2;
    if (paramInt == 104)
    {
      localObject2 = DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(paramString);
      return localObject2;
    }
    if (paramInt == 105)
    {
      paramString = swy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 1);
      if ((paramString != null) && (paramString.a() != null)) {
        return paramString.a();
      }
      return swy.a(BaseApplication.getContext(), 1);
    }
    if (paramInt == 111)
    {
      paramString = swy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 3);
      if ((paramString != null) && (paramString.a() != null)) {}
      for (paramString = paramString.a();; paramString = swy.a(BaseApplication.getContext(), 3)) {
        return ors.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      }
    }
    if (paramInt == 106) {
      return ntw.a(BaseApplication.getContext());
    }
    if (paramInt == 108) {
      return ((agyc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(138)).a();
    }
    if (paramInt == 110)
    {
      paramString = swy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 2);
      if ((paramString != null) && (paramString.a() != null)) {
        return paramString.a();
      }
      return swy.a(BaseApplication.getContext(), 2);
    }
    if (paramInt == 112) {
      return BaseApplicationImpl.sApplication.getResources().getDrawable(ssp.a());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt, paramString, false, 0);
      return null;
    }
    if ((this.b) && (!this.c))
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
      if (this.jdField_a_of_type_Bcws != null) {
        if (paramInt == 32) {
          localObject1 = this.jdField_a_of_type_Bcws.a(i, paramString, 200);
        }
      }
      for (;;)
      {
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("requestDecodeFace| [").append(paramString).append(",").append(paramInt).append(",").append(localObject1).append("], isPausing=");
          if (this.jdField_a_of_type_Bcws == null)
          {
            localObject2 = "null";
            label407:
            QLog.i("Q.recent", 4, localObject2);
          }
        }
        else
        {
          if (localObject1 != null) {
            break label564;
          }
          if ((this.jdField_a_of_type_Bcws != null) && (!this.jdField_a_of_type_Bcws.a()))
          {
            if (i != 32) {
              break label516;
            }
            this.jdField_a_of_type_Bcws.a(paramString, 200, true, false);
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 2");
          }
          return a(paramInt);
          localObject1 = this.jdField_a_of_type_Bcws.a(i, paramString);
          break;
          localObject2 = Boolean.valueOf(this.jdField_a_of_type_Bcws.a());
          break label407;
          label516:
          this.jdField_a_of_type_Bcws.a(paramString, i, true, (byte)0);
          if ((i == 1001) && (this.jdField_a_of_type_Bcws.a(101, paramString) == null)) {
            this.jdField_a_of_type_Bcws.a(paramString, 101, true, (byte)0);
          }
        }
        label564:
        if (paramInt == 103)
        {
          localObject2 = BaseApplication.getContext().getResources().getDrawable(2130840164);
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
          if (!aljq.aR.equals(paramString)) {
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
    paramString1 = bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, (byte)3);
    try
    {
      QLog.d("RecentFaceDecoder", 2, "getAppletsFolderDrawable width = " + paramInt1 + ", height = " + paramInt2 + ", url = " + paramString2 + ", urlSimple = " + paramString3);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = aekt.a(paramInt1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources());
      localURLDrawableOptions.mRequestHeight = aekt.a(paramInt2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources());
      localURLDrawableOptions.mLoadingDrawable = paramString1;
      localURLDrawableOptions.mFailedDrawable = paramString1;
      if (azib.a())
      {
        if (!TextUtils.isEmpty(paramString3))
        {
          paramInt1 = Math.min(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight);
          paramString3 = URLDrawable.getDrawable(paramString3, localURLDrawableOptions);
          paramString3.setTag(new int[] { paramInt1, paramInt1, (int)(paramInt1 * 0.07142858F) });
          paramString3.setDecodeHandler(bcuq.i);
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
      localDrawable = bdda.c();
      return URLDrawable.getDrawable(paramString.iconUrl, localDrawable, localDrawable);
    case 112: 
      paramString = BaseApplicationImpl.sApplication.getResources().getDrawable(ssp.a());
      return URLDrawable.getDrawable(swy.e, paramString, paramString);
    }
    Drawable localDrawable = bdda.b();
    paramString = URLDrawable.getDrawable(paramString, localDrawable, localDrawable);
    paramString.setDecodeHandler(bcuq.a);
    return paramString;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bcws != null)
    {
      this.jdField_a_of_type_Bcws.d();
      this.jdField_a_of_type_Bcws = null;
    }
    this.jdField_a_of_type_Bcwt = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Bcws != null)
    {
      this.jdField_a_of_type_Bcws.a(paramQQAppInterface);
      this.jdField_a_of_type_Bcws.a(this.jdField_a_of_type_Bcwt);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void b()
  {
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfa
 * JD-Core Version:    0.7.0.1
 */