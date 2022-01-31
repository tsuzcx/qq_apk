import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.10.1;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.10.2;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.10.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class adjg
  extends anfw
{
  adjg(adje paramadje) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    Object localObject2;
    if (paramInt != 0)
    {
      localObject1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (adjt)((Iterator)localObject1).next();
        if ((((adjt)localObject2).jdField_a_of_type_Anla != null) && (paramEmoticonPackage.epId.equals(((adjt)localObject2).jdField_a_of_type_Anla.a.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "Download magic Emoji fail!");
          }
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.10.1(this, (adjt)localObject2));
        }
      }
    }
    do
    {
      this.a.jdField_a_of_type_JavaUtilList.remove(localObject2);
      return;
      while ((!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) || (paramEmoticonPackage == null)) {}
      localObject1 = ((arnz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramEmoticonPackage.epId);
    } while (localObject1 == null);
    Object localObject1 = ((List)localObject1).iterator();
    Emoticon localEmoticon;
    boolean bool;
    label295:
    Boolean localBoolean;
    if (((Iterator)localObject1).hasNext())
    {
      localEmoticon = (Emoticon)((Iterator)localObject1).next();
      localObject2 = this.a.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (adjt)((Iterator)localObject2).next();
          if ((((adjt)localObject1).jdField_a_of_type_Anla != null) && (paramEmoticonPackage.epId.equals(((adjt)localObject1).jdField_a_of_type_Anla.a.epId)))
          {
            localObject2 = ((adjt)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if ((((adjt)localObject1).jdField_a_of_type_Boolean) && (((adjt)localObject1).e.hasWindowFocus()))
            {
              bool = true;
              ((adjt)localObject1).jdField_a_of_type_Boolean = false;
              localBoolean = Boolean.valueOf(bool);
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localBoolean.booleanValue()) {
        if (localObject2 != null)
        {
          localObject2 = ((ChatMessage)localObject2).senderuin;
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.10.2(this, localEmoticon, (String)localObject2, (adjt)localObject1));
        }
      }
      for (;;)
      {
        localObject1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (adjt)((Iterator)localObject1).next();
        if ((((adjt)localObject2).jdField_a_of_type_Anla == null) || (!paramEmoticonPackage.epId.equals(((adjt)localObject2).jdField_a_of_type_Anla.a.epId))) {
          break;
        }
        if (((adjt)localObject2).jdField_a_of_type_Anla.a.jobType == 2) {
          bajo.a(this.a.b, null);
        }
        this.a.jdField_a_of_type_JavaUtilList.remove(localObject2);
        return;
        bool = false;
        break label295;
        if ((localEmoticon != null) && (localEmoticon.jobType == 4)) {
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.10.3(this, (adjt)localObject1, localEmoticon));
        }
      }
      localObject2 = null;
      localBoolean = Boolean.valueOf(false);
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adjg
 * JD-Core Version:    0.7.0.1
 */