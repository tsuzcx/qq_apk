import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManagerImpl;
import com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.qphone.base.util.QLog;

public class aagt
  implements Runnable
{
  public aagt(AREngine paramAREngine, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a())) {
      switch (this.jdField_a_of_type_Int)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.s();
                  return;
                  localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine;
                  if (this.b == 1) {}
                  for (boolean bool = true;; bool = false)
                  {
                    ((AREngine)localObject).f(bool);
                    return;
                  }
                } while (this.b != 0);
                AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, this.jdField_a_of_type_JavaLangObject.toString());
                return;
              } while (!(AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) instanceof ARRenderManagerImpl));
              localObject = (ARRenderManagerImpl)AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine);
            } while ((((ARRenderManagerImpl)localObject).a == null) || (!(((ARRenderManagerImpl)localObject).a instanceof Interactive3DRenderable)));
            localObject = (Interactive3DRenderable)((ARRenderManagerImpl)localObject).a;
            Object[] arrayOfObject = (Object[])this.jdField_a_of_type_JavaLangObject;
            ((Interactive3DRenderable)localObject).a(((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue(), (String)arrayOfObject[2]);
            return;
          } while (!(AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) instanceof ARRenderManagerImpl));
          localObject = (ARRenderManagerImpl)AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine);
        } while ((((ARRenderManagerImpl)localObject).a == null) || (!(((ARRenderManagerImpl)localObject).a instanceof Interactive3DRenderable)) || (this.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof String)));
        Object localObject = (Interactive3DRenderable)((ARRenderManagerImpl)localObject).a;
        if (this.b == 0)
        {
          ((Interactive3DRenderable)localObject).a(this.jdField_a_of_type_JavaLangObject.toString());
          return;
        }
        ((Interactive3DRenderable)localObject).b(this.jdField_a_of_type_JavaLangObject.toString());
        return;
      } while (this.b != 1);
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.g();
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.g();
    } while (!QLog.isColorLevel());
    QLog.d("AREngine_AREngine", 2, "binhai_pause ar cloud");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aagt
 * JD-Core Version:    0.7.0.1
 */