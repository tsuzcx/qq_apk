import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ajgd
{
  private ajge jdField_a_of_type_Ajge;
  private ajgh jdField_a_of_type_Ajgh;
  private ajgi jdField_a_of_type_Ajgi;
  private ajgm jdField_a_of_type_Ajgm;
  private ajgn jdField_a_of_type_Ajgn;
  private ajgo jdField_a_of_type_Ajgo;
  private boolean jdField_a_of_type_Boolean;
  
  public ajgd(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteScriptManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Ajgh = new ajgh();
    this.jdField_a_of_type_Ajgh.a(paramString);
    this.jdField_a_of_type_Ajgm = new ajgm(this.jdField_a_of_type_Ajgh);
    this.jdField_a_of_type_Ajgo = new ajgo(this.jdField_a_of_type_Ajgh, this.jdField_a_of_type_Ajgm, this);
    this.jdField_a_of_type_Ajgn = new ajgn(this.jdField_a_of_type_Ajgh);
    this.jdField_a_of_type_Ajgi = new ajgi(this.jdField_a_of_type_Ajgh, this.jdField_a_of_type_Ajgm, this.jdField_a_of_type_Ajgn, this.jdField_a_of_type_Ajgo);
    this.jdField_a_of_type_Ajgh.a(this.jdField_a_of_type_Ajgn);
  }
  
  public ajge a()
  {
    return this.jdField_a_of_type_Ajge;
  }
  
  public ajgh a()
  {
    return this.jdField_a_of_type_Ajgh;
  }
  
  public ajgn a()
  {
    return this.jdField_a_of_type_Ajgn;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajge != null) {
      this.jdField_a_of_type_Ajge.a(1);
    }
    this.jdField_a_of_type_Ajgh.a(-1);
  }
  
  public void a(int paramInt)
  {
    QLog.i("CmShow_SpriteScriptManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Ajgh == null) || (this.jdField_a_of_type_Ajgi == null) || (this.jdField_a_of_type_Ajgo == null)) {
      return;
    }
    this.jdField_a_of_type_Ajgh.a(0, 0);
    this.jdField_a_of_type_Ajgh.b(true);
    paramInt = ajfj.b(this.jdField_a_of_type_Ajgh.e);
    this.jdField_a_of_type_Ajgh.b(paramInt);
    ajlq.a(paramInt, 100, 0, new Object[] { "onSurfaceReady" });
    ajlq.a(paramInt, 200);
    this.jdField_a_of_type_Ajgo.a();
    ajlq.a(paramInt, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Ajgh.a(true);
    ajlq.a(paramInt, 300);
    ajlq.a(paramInt, 300, 0, new Object[] { "initSprite done" });
    ajlq.a(paramInt, 1, 0, new Object[] { "terminal all done" });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ajge = ((ajge)this.jdField_a_of_type_Ajgo.a(100));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ajgi.a(paramInt1, paramInt2);
  }
  
  public void a(aivb paramaivb)
  {
    if (paramaivb == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Ajgh.a(paramaivb);
      localApolloCmdChannel = ApolloUtil.a();
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramaivb);
  }
  
  public void a(ajfz paramajfz)
  {
    this.jdField_a_of_type_Ajgm.a(paramajfz);
  }
  
  public void a(CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    this.jdField_a_of_type_Ajgi.a(this.jdField_a_of_type_Ajgh, paramPlayActionConfig);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Ajgi.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Ajgi.a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Ajgi.a(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Ajgi != null) {
      this.jdField_a_of_type_Ajgi.a(this.jdField_a_of_type_Ajgh, paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Ajgh.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Ajgh.b = paramString1;
    this.jdField_a_of_type_Ajgh.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Ajgm != null) {
      this.jdField_a_of_type_Ajgi.a(this.jdField_a_of_type_Ajgh, paramInt, this.jdField_a_of_type_Ajgm.a, paramBundle);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ajgi.a(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ajgi.a(paramString, paramBoolean);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ajgi.a(paramList, paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ajge != null) {
      this.jdField_a_of_type_Ajge.a(2);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ajgn != null) {
      this.jdField_a_of_type_Ajgn.a();
    }
    Object localObject = this.jdField_a_of_type_Ajgh.a();
    if (localObject != null)
    {
      localObject = ((aivb)localObject).getRenderImpl();
      if (localObject != null) {
        ((aitm)localObject).c();
      }
    }
    ajlq.a(this.jdField_a_of_type_Ajgh.a(), true);
    this.jdField_a_of_type_Ajgm.a();
    this.jdField_a_of_type_Ajgo.b();
    this.jdField_a_of_type_Ajgh.c();
    this.jdField_a_of_type_Ajgi.a();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajgd
 * JD-Core Version:    0.7.0.1
 */