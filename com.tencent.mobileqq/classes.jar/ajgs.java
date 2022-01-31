import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ajgs
{
  public static int a;
  private ajgb jdField_a_of_type_Ajgb;
  private ajgq jdField_a_of_type_Ajgq;
  private ApolloTextureView jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  private int b;
  
  public ajgs(CmShowRenderView paramCmShowRenderView)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = paramCmShowRenderView;
  }
  
  public static void a(ArrayList<String> paramArrayList, int[] paramArrayOfInt)
  {
    QLog.i("CmShow_RenderViewController", 1, "CmShow_ preLoadRes start");
    Bundle localBundle = new Bundle();
    localBundle.putIntArray("actionIds", paramArrayOfInt);
    localBundle.putStringArrayList("uins", paramArrayList);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_preload_res", localBundle, new ajgt());
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "onResume");
    }
    if ((a()) && (this.jdField_a_of_type_Ajgb != null)) {
      this.jdField_a_of_type_Ajgb.b();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ajgb != null) {
      this.jdField_a_of_type_Ajgb.a(paramInt1, paramInt2);
    }
  }
  
  public void a(ajfx paramajfx)
  {
    if (this.jdField_a_of_type_Ajgq != null) {
      this.jdField_a_of_type_Ajgq.a(paramajfx);
    }
    if (this.jdField_a_of_type_Ajgb != null) {
      this.jdField_a_of_type_Ajgb.a(paramajfx);
    }
  }
  
  public void a(CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    if (this.jdField_a_of_type_Ajgb != null) {
      this.jdField_a_of_type_Ajgb.a(paramPlayActionConfig);
    }
  }
  
  @TargetApi(14)
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "initApolloSurfaceView");
    }
    int i = ajfh.b(3);
    ajlo.a(i);
    ajlo.a(i, 100);
    this.jdField_a_of_type_Ajgb = new ajgb(paramString);
    this.jdField_a_of_type_Ajgq = new ajgq(this.jdField_a_of_type_Ajgb, 0);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this.jdField_a_of_type_Ajgq);
    this.jdField_a_of_type_Ajgb.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
    i = ajfh.a();
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setInitHeight(i);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Ajgb != null) {
      this.jdField_a_of_type_Ajgb.a(paramString, paramInt);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Ajgb != null) {
      this.jdField_a_of_type_Ajgb.a(paramString, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Ajgb != null) {
      this.jdField_a_of_type_Ajgb.a(paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Ajgb != null) {
      this.jdField_a_of_type_Ajgb.a(paramString1, paramString2, paramFloat, paramInt, paramBundle);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ajgb != null) {
      this.jdField_a_of_type_Ajgb.a(paramString1, paramString2, paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ajgb != null) {
      this.jdField_a_of_type_Ajgb.a(paramString, paramBoolean);
    }
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ajgb != null) {
      this.jdField_a_of_type_Ajgb.a(paramList, paramBoolean);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "onPause");
    }
    if ((a()) && (this.jdField_a_of_type_Ajgb != null)) {
      this.jdField_a_of_type_Ajgb.a();
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Ajgb != null) {
      this.jdField_a_of_type_Ajgb.a(paramString);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_RenderViewController", 2, "onDestroy ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      ApolloRender localApolloRender = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender();
      if (localApolloRender != null) {
        localApolloRender.queueDestroy();
      }
    }
    if (this.jdField_a_of_type_Ajgb != null)
    {
      this.jdField_a_of_type_Ajgb.c();
      this.jdField_a_of_type_Ajgb = null;
    }
    if (!a())
    {
      QLog.e("CmShow_RenderViewController", 1, new Object[] { "[onDestory] isViewAvailable:", Boolean.valueOf(a()) });
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = null;
    }
    this.b = 0;
    ajfs.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajgs
 * JD-Core Version:    0.7.0.1
 */