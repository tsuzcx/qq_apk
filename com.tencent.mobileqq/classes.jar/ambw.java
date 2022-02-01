import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ambw
{
  private final int jdField_a_of_type_Int;
  private ambx jdField_a_of_type_Ambx;
  private amca jdField_a_of_type_Amca;
  private amcb jdField_a_of_type_Amcb;
  private amcf jdField_a_of_type_Amcf;
  private amcg jdField_a_of_type_Amcg;
  private amch jdField_a_of_type_Amch;
  private boolean jdField_a_of_type_Boolean;
  
  public ambw(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteScriptManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Amca = new amca();
    this.jdField_a_of_type_Amca.a(paramString);
    this.jdField_a_of_type_Amcf = new amcf(this.jdField_a_of_type_Amca);
    this.jdField_a_of_type_Amch = new amch(this.jdField_a_of_type_Amca, this.jdField_a_of_type_Amcf, this);
    this.jdField_a_of_type_Amcg = new amcg(this.jdField_a_of_type_Amca);
    this.jdField_a_of_type_Amcb = new amcb(this.jdField_a_of_type_Amca, this.jdField_a_of_type_Amcf, this.jdField_a_of_type_Amcg, this.jdField_a_of_type_Amch);
    this.jdField_a_of_type_Amca.a(this.jdField_a_of_type_Amcg);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public ambx a()
  {
    return this.jdField_a_of_type_Ambx;
  }
  
  public amca a()
  {
    return this.jdField_a_of_type_Amca;
  }
  
  public amcg a()
  {
    return this.jdField_a_of_type_Amcg;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ambx != null) {
      this.jdField_a_of_type_Ambx.a(1);
    }
    this.jdField_a_of_type_Amca.a(-1);
  }
  
  public void a(int paramInt)
  {
    QLog.i("CmShow_SpriteScriptManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Amca == null) || (this.jdField_a_of_type_Amcb == null) || (this.jdField_a_of_type_Amch == null)) {
      return;
    }
    this.jdField_a_of_type_Amca.a(0, 0);
    this.jdField_a_of_type_Amca.b(true);
    paramInt = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Amca.b(paramInt);
    this.jdField_a_of_type_Amch.a();
    this.jdField_a_of_type_Amca.a(true);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ambx = ((ambx)this.jdField_a_of_type_Amch.a(100));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Amcb.a(paramInt1, paramInt2);
  }
  
  public void a(alqu paramalqu)
  {
    if (paramalqu == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Amca.a(paramalqu);
      localApolloCmdChannel = ApolloUtil.a();
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramalqu);
  }
  
  public void a(ambs paramambs)
  {
    this.jdField_a_of_type_Amcf.a(paramambs);
  }
  
  public void a(CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    this.jdField_a_of_type_Amcb.a(this.jdField_a_of_type_Amca, paramPlayActionConfig);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Amcb.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Amcb.a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Amcb.a(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Amcb != null) {
      this.jdField_a_of_type_Amcb.a(this.jdField_a_of_type_Amca, paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Amca.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Amca.b = paramString1;
    this.jdField_a_of_type_Amca.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Amcf != null) {
      this.jdField_a_of_type_Amcb.a(this.jdField_a_of_type_Amca, paramInt, this.jdField_a_of_type_Amcf.a, paramBundle);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Amcb.a(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Amcb.a(paramString, paramBoolean);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Amcb.a(paramList, paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ambx != null) {
      this.jdField_a_of_type_Ambx.a(2);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Amcg != null) {
      this.jdField_a_of_type_Amcg.a();
    }
    Object localObject = this.jdField_a_of_type_Amca.a();
    if (localObject != null)
    {
      localObject = ((alqu)localObject).getRenderImpl();
      if (localObject != null) {
        ((alpf)localObject).c();
      }
    }
    this.jdField_a_of_type_Amcf.a();
    this.jdField_a_of_type_Amch.b();
    this.jdField_a_of_type_Amca.c();
    this.jdField_a_of_type_Amcb.a();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambw
 * JD-Core Version:    0.7.0.1
 */