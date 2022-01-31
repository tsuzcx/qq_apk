import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class akxn
{
  private final int jdField_a_of_type_Int;
  private akxo jdField_a_of_type_Akxo;
  private akxr jdField_a_of_type_Akxr;
  private akxs jdField_a_of_type_Akxs;
  private akxw jdField_a_of_type_Akxw;
  private akxx jdField_a_of_type_Akxx;
  private akxy jdField_a_of_type_Akxy;
  private boolean jdField_a_of_type_Boolean;
  
  public akxn(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteScriptManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Akxr = new akxr();
    this.jdField_a_of_type_Akxr.a(paramString);
    this.jdField_a_of_type_Akxw = new akxw(this.jdField_a_of_type_Akxr);
    this.jdField_a_of_type_Akxy = new akxy(this.jdField_a_of_type_Akxr, this.jdField_a_of_type_Akxw, this);
    this.jdField_a_of_type_Akxx = new akxx(this.jdField_a_of_type_Akxr);
    this.jdField_a_of_type_Akxs = new akxs(this.jdField_a_of_type_Akxr, this.jdField_a_of_type_Akxw, this.jdField_a_of_type_Akxx, this.jdField_a_of_type_Akxy);
    this.jdField_a_of_type_Akxr.a(this.jdField_a_of_type_Akxx);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public akxo a()
  {
    return this.jdField_a_of_type_Akxo;
  }
  
  public akxr a()
  {
    return this.jdField_a_of_type_Akxr;
  }
  
  public akxx a()
  {
    return this.jdField_a_of_type_Akxx;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Akxo != null) {
      this.jdField_a_of_type_Akxo.a(1);
    }
    this.jdField_a_of_type_Akxr.a(-1);
  }
  
  public void a(int paramInt)
  {
    QLog.i("CmShow_SpriteScriptManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Akxr == null) || (this.jdField_a_of_type_Akxs == null) || (this.jdField_a_of_type_Akxy == null)) {
      return;
    }
    this.jdField_a_of_type_Akxr.a(0, 0);
    this.jdField_a_of_type_Akxr.b(true);
    paramInt = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Akxr.b(paramInt);
    this.jdField_a_of_type_Akxy.a();
    this.jdField_a_of_type_Akxr.a(true);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Akxo = ((akxo)this.jdField_a_of_type_Akxy.a(100));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Akxs.a(paramInt1, paramInt2);
  }
  
  public void a(akml paramakml)
  {
    if (paramakml == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Akxr.a(paramakml);
      localApolloCmdChannel = ApolloUtil.a();
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramakml);
  }
  
  public void a(akxj paramakxj)
  {
    this.jdField_a_of_type_Akxw.a(paramakxj);
  }
  
  public void a(CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    this.jdField_a_of_type_Akxs.a(this.jdField_a_of_type_Akxr, paramPlayActionConfig);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Akxs.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Akxs.a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Akxs.a(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Akxs != null) {
      this.jdField_a_of_type_Akxs.a(this.jdField_a_of_type_Akxr, paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Akxr.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Akxr.b = paramString1;
    this.jdField_a_of_type_Akxr.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Akxw != null) {
      this.jdField_a_of_type_Akxs.a(this.jdField_a_of_type_Akxr, paramInt, this.jdField_a_of_type_Akxw.a, paramBundle);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Akxs.a(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Akxs.a(paramString, paramBoolean);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Akxs.a(paramList, paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Akxo != null) {
      this.jdField_a_of_type_Akxo.a(2);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Akxx != null) {
      this.jdField_a_of_type_Akxx.a();
    }
    Object localObject = this.jdField_a_of_type_Akxr.a();
    if (localObject != null)
    {
      localObject = ((akml)localObject).getRenderImpl();
      if (localObject != null) {
        ((akkw)localObject).c();
      }
    }
    this.jdField_a_of_type_Akxw.a();
    this.jdField_a_of_type_Akxy.b();
    this.jdField_a_of_type_Akxr.c();
    this.jdField_a_of_type_Akxs.a();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxn
 * JD-Core Version:    0.7.0.1
 */