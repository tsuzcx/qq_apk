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
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class alnc
  extends bead
  implements View.OnClickListener, bfsn
{
  private float jdField_a_of_type_Float;
  private volatile int jdField_a_of_type_Int = 0;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private bfsl jdField_a_of_type_Bfsl = new bfsl();
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public alnc(ApolloPanel paramApolloPanel)
  {
    this.jdField_a_of_type_Bfsl.a(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(paramApolloPanel.a.a, paramApolloPanel.a.a());
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(ApolloPanel.a(paramApolloPanel), akok.d, aliu.k + "kapu/apollo_kapu_progress_lottie.zip", false);
  }
  
  private Drawable a()
  {
    Object localObject = akok.c;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getResources().getDrawable(2130838357);
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getResources().getDrawable(2130838357);
    localObject = aldt.a("" + ((String)localObject).hashCode(), localURLDrawableOptions, (String)localObject, false);
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
      localJSONObject.put("appId", akok.g);
      localJSONObject.put("iconUrl", akok.c);
      localJSONObject.put("apkUrl", akok.jdField_b_of_type_JavaLangString);
      localJSONObject.put("packageName", akok.jdField_a_of_type_JavaLangString);
      localJSONObject.put("versionCode", akok.jdField_a_of_type_Int);
      localJSONObject.put("apkSign", akok.h);
      localJSONObject.put("appName", akok.i);
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
    Object localObject = akok.jdField_b_of_type_JavaLangString;
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
      this.jdField_a_of_type_Bfsl.a((JSONObject)localObject, 2);
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
    this.jdField_a_of_type_Bfsl.a(a(), 5);
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
      aknx.a(103, String.valueOf(akok.jdField_b_of_type_Int), akok.j, "{\"returnValue\":0}");
      return;
    case -2: 
      ApolloPanel.c(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel, false);
      this.jdField_a_of_type_Int = 0;
      ThreadManager.getUIHandler().post(new ApolloPanel.CmshowAppController.6(this));
      aknx.a(103, String.valueOf(akok.jdField_b_of_type_Int), akok.j, "{\"returnValue\":1}");
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
    if (this.jdField_a_of_type_Bfsl.a(akok.g, akok.jdField_b_of_type_JavaLangString, akok.jdField_a_of_type_Int, paramArrayList))
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
    this.jdField_a_of_type_Bfsl.a();
  }
  
  void c()
  {
    if (bdiv.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getContext(), akok.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getContext().getPackageManager().getLaunchIntentForPackage(akok.jdField_a_of_type_JavaLangString);
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
        this.jdField_a_of_type_Bfsl.a(akok.g);
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
            break label356;
          }
          i = 0;
          label46:
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a, "cmshow", "Apollo", "aio_clickkapoo", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.b()), i, new String[0]);
          return;
          paramView = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getContext();
          if (bdin.g(paramView)) {
            break;
          }
          QQToast.a(paramView, 1, paramView.getString(2131695131), 0).b(0);
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
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getContext(), 1, alud.a(2131700866), 0).b(0);
        }
        for (;;)
        {
          a();
          return;
          if (bdin.h(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getContext()))
          {
            if (!a()) {
              break;
            }
            this.jdField_a_of_type_Int = 1;
            d();
            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.r();
            break;
          }
          alnd localalnd = new alnd(this);
          alne localalne = new alne(this);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("即将消耗");
          localStringBuilder.append(akok.f);
          localStringBuilder.append("流量下载厘米秀APP，当前为非WIFI网络，是否继续下载？");
          bdgm.a(paramView, 230, alud.a(2131700857), localStringBuilder.toString(), alud.a(2131700853), alud.a(2131700851), localalne, localalnd).show();
          break;
          e();
          break;
          if (this.jdField_a_of_type_AndroidContentIntent != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getContext().startActivity(this.jdField_a_of_type_AndroidContentIntent);
          }
          for (;;)
          {
            aknx.a(102, String.valueOf(akok.jdField_b_of_type_Int), akok.j);
            break;
            a();
          }
          label356:
          i = this.jdField_a_of_type_Int;
          if (i == 2)
          {
            i = 2;
            break label46;
          }
          i = 1;
          break label46;
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.getContext(), 1, alud.a(2131700858), 0).b(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnc
 * JD-Core Version:    0.7.0.1
 */