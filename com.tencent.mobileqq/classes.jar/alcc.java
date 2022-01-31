import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class alcc
{
  private final int jdField_a_of_type_Int;
  private alcd jdField_a_of_type_Alcd;
  private alcg jdField_a_of_type_Alcg;
  private alch jdField_a_of_type_Alch;
  private alcl jdField_a_of_type_Alcl;
  private alcm jdField_a_of_type_Alcm;
  private alcn jdField_a_of_type_Alcn;
  private boolean jdField_a_of_type_Boolean;
  
  public alcc(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteScriptManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Alcg = new alcg();
    this.jdField_a_of_type_Alcg.a(paramString);
    this.jdField_a_of_type_Alcl = new alcl(this.jdField_a_of_type_Alcg);
    this.jdField_a_of_type_Alcn = new alcn(this.jdField_a_of_type_Alcg, this.jdField_a_of_type_Alcl, this);
    this.jdField_a_of_type_Alcm = new alcm(this.jdField_a_of_type_Alcg);
    this.jdField_a_of_type_Alch = new alch(this.jdField_a_of_type_Alcg, this.jdField_a_of_type_Alcl, this.jdField_a_of_type_Alcm, this.jdField_a_of_type_Alcn);
    this.jdField_a_of_type_Alcg.a(this.jdField_a_of_type_Alcm);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public alcd a()
  {
    return this.jdField_a_of_type_Alcd;
  }
  
  public alcg a()
  {
    return this.jdField_a_of_type_Alcg;
  }
  
  public alcm a()
  {
    return this.jdField_a_of_type_Alcm;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Alcd != null) {
      this.jdField_a_of_type_Alcd.a(1);
    }
    this.jdField_a_of_type_Alcg.a(-1);
  }
  
  public void a(int paramInt)
  {
    QLog.i("CmShow_SpriteScriptManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Alcg == null) || (this.jdField_a_of_type_Alch == null) || (this.jdField_a_of_type_Alcn == null)) {
      return;
    }
    this.jdField_a_of_type_Alcg.a(0, 0);
    this.jdField_a_of_type_Alcg.b(true);
    paramInt = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Alcg.b(paramInt);
    this.jdField_a_of_type_Alcn.a();
    this.jdField_a_of_type_Alcg.a(true);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Alcd = ((alcd)this.jdField_a_of_type_Alcn.a(100));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Alch.a(paramInt1, paramInt2);
  }
  
  public void a(akra paramakra)
  {
    if (paramakra == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Alcg.a(paramakra);
      localApolloCmdChannel = ApolloUtil.a();
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramakra);
  }
  
  public void a(alby paramalby)
  {
    this.jdField_a_of_type_Alcl.a(paramalby);
  }
  
  public void a(CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    this.jdField_a_of_type_Alch.a(this.jdField_a_of_type_Alcg, paramPlayActionConfig);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Alch.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Alch.a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Alch.a(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Alch != null) {
      this.jdField_a_of_type_Alch.a(this.jdField_a_of_type_Alcg, paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Alcg.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Alcg.b = paramString1;
    this.jdField_a_of_type_Alcg.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Alcl != null) {
      this.jdField_a_of_type_Alch.a(this.jdField_a_of_type_Alcg, paramInt, this.jdField_a_of_type_Alcl.a, paramBundle);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Alch.a(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Alch.a(paramString, paramBoolean);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Alch.a(paramList, paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Alcd != null) {
      this.jdField_a_of_type_Alcd.a(2);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Alcm != null) {
      this.jdField_a_of_type_Alcm.a();
    }
    Object localObject = this.jdField_a_of_type_Alcg.a();
    if (localObject != null)
    {
      localObject = ((akra)localObject).getRenderImpl();
      if (localObject != null) {
        ((akpl)localObject).c();
      }
    }
    this.jdField_a_of_type_Alcl.a();
    this.jdField_a_of_type_Alcn.b();
    this.jdField_a_of_type_Alcg.c();
    this.jdField_a_of_type_Alch.a();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alcc
 * JD-Core Version:    0.7.0.1
 */