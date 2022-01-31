import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanel.CmshowAppController.1;
import com.tencent.mobileqq.apollo.view.ApolloPanel.CmshowAppController.4;
import com.tencent.mobileqq.apollo.view.ApolloPanel.CmshowAppController.5;
import com.tencent.mobileqq.apollo.view.ApolloPanel.CmshowAppController.6;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ajda
  extends batl
  implements View.OnClickListener, bckr
{
  private float jdField_a_of_type_Float;
  private volatile int jdField_a_of_type_Int = 0;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private bckp jdField_a_of_type_Bckp = new bckp();
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public ajda(ApolloPanel paramApolloPanel)
  {
    this.jdField_a_of_type_Bckp.a(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(paramApolloPanel.a.a, paramApolloPanel.a.a());
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(ApolloPanel.a(paramApolloPanel), aifs.d, aiys.k + "kapu/apollo_kapu_progress_lottie.zip", false);
  }
  
  private Drawable a()
  {
    Object localObject = aifs.c;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getResources().getDrawable(2130838288);
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getResources().getDrawable(2130838288);
    localObject = aitu.a("" + ((String)localObject).hashCode(), localURLDrawableOptions, (String)localObject, false);
    if (localObject != null) {
      ((URLDrawable)localObject).startDownload();
    }
    return localObject;
  }
  
  private JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appId", aifs.g);
      localJSONObject.put("iconUrl", aifs.c);
      localJSONObject.put("apkUrl", aifs.b);
      localJSONObject.put("packageName", aifs.jdField_a_of_type_JavaLangString);
      localJSONObject.put("versionCode", aifs.jdField_a_of_type_Int);
      localJSONObject.put("apkSign", aifs.h);
      localJSONObject.put("appName", aifs.i);
      localJSONObject.put("sourceId", "biz_src_zf_lmx");
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QLog.e("CmshowAppController", 1, localException, new Object[0]);
    }
    return null;
  }
  
  private void a(float paramFloat)
  {
    ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel).post(new ApolloPanel.CmshowAppController.4(this, paramFloat));
  }
  
  private boolean a()
  {
    boolean bool = true;
    Object localObject = aifs.b;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a == null) || (TextUtils.isEmpty((CharSequence)localObject))) {
      bool = false;
    }
    do
    {
      return bool;
      localObject = a();
    } while (localObject == null);
    ApolloPanel.c(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel, true);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bckp.a((JSONObject)localObject, 2);
      return true;
    }
    this.b = true;
    return true;
  }
  
  private void d()
  {
    if (ApolloPanel.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel).getBackground() == null) {
      ApolloPanel.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel).setBackgroundDrawable(a());
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      a(this.jdField_a_of_type_Float);
      return;
    }
    ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel).endAnimation();
    ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.postDelayed(new ApolloPanel.CmshowAppController.1(this), 1000L);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bckp.a(a(), 5);
  }
  
  public void a()
  {
    c();
    d();
  }
  
  public void a(int paramInt, WadlResult paramWadlResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmshowAppController", 2, new Object[] { "onTaskStatusChanged localStatus:", Integer.valueOf(paramInt), ",wadlResult:", paramWadlResult });
    }
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      ApolloPanel.c(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel, false);
      this.jdField_a_of_type_Int = 2;
      ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel).post(new ApolloPanel.CmshowAppController.5(this));
      return;
    case -2: 
      ApolloPanel.c(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel, false);
      this.jdField_a_of_type_Int = 0;
      ThreadManager.getUIHandler().post(new ApolloPanel.CmshowAppController.6(this));
      return;
    }
    this.jdField_a_of_type_Float = (paramWadlResult.d / 100.0F);
    a(this.jdField_a_of_type_Float);
  }
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmshowAppController", 2, new Object[] { "onTaskQuery resInfos:", paramArrayList, ",mIsNeedDownload:", Boolean.valueOf(this.b) });
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bckp.a(aifs.g, aifs.b, aifs.jdField_a_of_type_Int, paramArrayList))
    {
      this.jdField_a_of_type_Int = 0;
      if (this.b)
      {
        a();
        this.jdField_a_of_type_Int = 1;
        this.b = false;
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 1) {
        e();
      }
      this.jdField_a_of_type_Int = 2;
    } while (!QLog.isColorLevel());
    QLog.d("CmshowAppController", 2, new Object[] { "onTaskQuery find apk already download, mStatus:", Integer.valueOf(this.jdField_a_of_type_Int) });
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.c();
    this.jdField_a_of_type_Bckp.a();
  }
  
  void c()
  {
    if (bady.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getContext(), aifs.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getContext().getPackageManager().getLaunchIntentForPackage(aifs.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_AndroidContentIntent != null) {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmshowAppController", 2, new Object[] { "checkStatus mStatus:", Integer.valueOf(this.jdField_a_of_type_Int) });
      }
      if (this.jdField_a_of_type_Int == 0) {}
      return;
      if (ApolloPanel.e(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel))
      {
        this.jdField_a_of_type_Int = 1;
      }
      else
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bckp.a(aifs.g);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    try
    {
      switch (this.jdField_a_of_type_Int)
      {
      case 1: 
      case 0: 
        for (;;)
        {
          if (this.jdField_a_of_type_Int != 3) {
            break label342;
          }
          i = 0;
          label46:
          bajr.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a, "cmshow", "Apollo", "aio_clickkapoo", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.b()), i, new String[0]);
          return;
          paramView = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getContext();
          if (badq.g(paramView)) {
            break;
          }
          bbmy.a(paramView, 1, paramView.getString(2131629294), 0).b(0);
        }
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        int i;
        QLog.e("CmshowAppController", 2, paramView, new Object[0]);
        if (this.jdField_a_of_type_Int == 3) {
          bbmy.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getContext(), 1, ajjy.a(2131634687), 0).b(0);
        }
        for (;;)
        {
          a();
          return;
          if (badq.h(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getContext()))
          {
            if (!a()) {
              break;
            }
            this.jdField_a_of_type_Int = 1;
            d();
            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.r();
            break;
          }
          ajdb localajdb = new ajdb(this);
          ajdc localajdc = new ajdc(this);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("即将消耗");
          localStringBuilder.append(aifs.f);
          localStringBuilder.append("流量下载厘米秀APP，当前为非WIFI网络，是否继续下载？");
          babr.a(paramView, 230, ajjy.a(2131634678), localStringBuilder.toString(), ajjy.a(2131634673), ajjy.a(2131634671), localajdc, localajdb).show();
          break;
          e();
          break;
          if (this.jdField_a_of_type_AndroidContentIntent != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getContext().startActivity(this.jdField_a_of_type_AndroidContentIntent);
            break;
          }
          a();
          break;
          label342:
          i = this.jdField_a_of_type_Int;
          if (i == 2)
          {
            i = 2;
            break label46;
          }
          i = 1;
          break label46;
          bbmy.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getContext(), 1, ajjy.a(2131634679), 0).b(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajda
 * JD-Core Version:    0.7.0.1
 */