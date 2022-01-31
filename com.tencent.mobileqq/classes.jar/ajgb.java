import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ajgb
{
  private ajgc jdField_a_of_type_Ajgc;
  private ajgf jdField_a_of_type_Ajgf;
  private ajgg jdField_a_of_type_Ajgg;
  private ajgk jdField_a_of_type_Ajgk;
  private ajgl jdField_a_of_type_Ajgl;
  private ajgm jdField_a_of_type_Ajgm;
  private boolean jdField_a_of_type_Boolean;
  
  public ajgb(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteScriptManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Ajgf = new ajgf();
    this.jdField_a_of_type_Ajgf.a(paramString);
    this.jdField_a_of_type_Ajgk = new ajgk(this.jdField_a_of_type_Ajgf);
    this.jdField_a_of_type_Ajgm = new ajgm(this.jdField_a_of_type_Ajgf, this.jdField_a_of_type_Ajgk, this);
    this.jdField_a_of_type_Ajgl = new ajgl(this.jdField_a_of_type_Ajgf);
    this.jdField_a_of_type_Ajgg = new ajgg(this.jdField_a_of_type_Ajgf, this.jdField_a_of_type_Ajgk, this.jdField_a_of_type_Ajgl, this.jdField_a_of_type_Ajgm);
    this.jdField_a_of_type_Ajgf.a(this.jdField_a_of_type_Ajgl);
  }
  
  public ajgc a()
  {
    return this.jdField_a_of_type_Ajgc;
  }
  
  public ajgf a()
  {
    return this.jdField_a_of_type_Ajgf;
  }
  
  public ajgl a()
  {
    return this.jdField_a_of_type_Ajgl;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajgc != null) {
      this.jdField_a_of_type_Ajgc.a(1);
    }
    this.jdField_a_of_type_Ajgf.a(-1);
  }
  
  public void a(int paramInt)
  {
    QLog.i("CmShow_SpriteScriptManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Ajgf == null) || (this.jdField_a_of_type_Ajgg == null) || (this.jdField_a_of_type_Ajgm == null)) {
      return;
    }
    this.jdField_a_of_type_Ajgf.a(0, 0);
    this.jdField_a_of_type_Ajgf.b(true);
    paramInt = ajfh.b(this.jdField_a_of_type_Ajgf.e);
    this.jdField_a_of_type_Ajgf.b(paramInt);
    ajlo.a(paramInt, 100, 0, new Object[] { "onSurfaceReady" });
    ajlo.a(paramInt, 200);
    this.jdField_a_of_type_Ajgm.a();
    ajlo.a(paramInt, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Ajgf.a(true);
    ajlo.a(paramInt, 300);
    ajlo.a(paramInt, 300, 0, new Object[] { "initSprite done" });
    ajlo.a(paramInt, 1, 0, new Object[] { "terminal all done" });
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ajgc = ((ajgc)this.jdField_a_of_type_Ajgm.a(100));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ajgg.a(paramInt1, paramInt2);
  }
  
  public void a(aiuz paramaiuz)
  {
    if (paramaiuz == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Ajgf.a(paramaiuz);
      localApolloCmdChannel = ApolloUtil.a();
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramaiuz);
  }
  
  public void a(ajfx paramajfx)
  {
    this.jdField_a_of_type_Ajgk.a(paramajfx);
  }
  
  public void a(CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    this.jdField_a_of_type_Ajgg.a(this.jdField_a_of_type_Ajgf, paramPlayActionConfig);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Ajgg.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Ajgg.a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Ajgg.a(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Ajgg != null) {
      this.jdField_a_of_type_Ajgg.a(this.jdField_a_of_type_Ajgf, paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Ajgf.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Ajgf.b = paramString1;
    this.jdField_a_of_type_Ajgf.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Ajgk != null) {
      this.jdField_a_of_type_Ajgg.a(this.jdField_a_of_type_Ajgf, paramInt, this.jdField_a_of_type_Ajgk.a, paramBundle);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ajgg.a(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ajgg.a(paramString, paramBoolean);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ajgg.a(paramList, paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ajgc != null) {
      this.jdField_a_of_type_Ajgc.a(2);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ajgl != null) {
      this.jdField_a_of_type_Ajgl.a();
    }
    Object localObject = this.jdField_a_of_type_Ajgf.a();
    if (localObject != null)
    {
      localObject = ((aiuz)localObject).getRenderImpl();
      if (localObject != null) {
        ((aitk)localObject).c();
      }
    }
    ajlo.a(this.jdField_a_of_type_Ajgf.a(), true);
    this.jdField_a_of_type_Ajgk.a();
    this.jdField_a_of_type_Ajgm.b();
    this.jdField_a_of_type_Ajgf.c();
    this.jdField_a_of_type_Ajgg.a();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajgb
 * JD-Core Version:    0.7.0.1
 */