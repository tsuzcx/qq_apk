import android.widget.ImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.9.1;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.9.2;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.9.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class afrd
  extends apns
{
  afrd(afqr paramafqr) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    Object localObject2;
    if (paramInt != 0)
    {
      localObject1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (afrf)((Iterator)localObject1).next();
        if ((((afrf)localObject2).jdField_a_of_type_Aptm != null) && (paramEmoticonPackage.epId.equals(((afrf)localObject2).jdField_a_of_type_Aptm.a.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "Download magic Emoji fail!");
          }
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.9.1(this, (afrf)localObject2));
        }
      }
    }
    do
    {
      this.a.jdField_a_of_type_JavaUtilList.remove(localObject2);
      return;
      while ((!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) || (paramEmoticonPackage == null)) {}
      localObject1 = ((aube)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramEmoticonPackage.epId);
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
          localObject1 = (afrf)((Iterator)localObject2).next();
          if ((((afrf)localObject1).jdField_a_of_type_Aptm != null) && (paramEmoticonPackage.epId.equals(((afrf)localObject1).jdField_a_of_type_Aptm.a.epId)))
          {
            localObject2 = ((afrf)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if ((((afrf)localObject1).jdField_a_of_type_Boolean) && (((afrf)localObject1).e.hasWindowFocus()))
            {
              bool = true;
              ((afrf)localObject1).jdField_a_of_type_Boolean = false;
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
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.9.2(this, localEmoticon, (String)localObject2, (afrf)localObject1));
        }
      }
      for (;;)
      {
        localObject1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (afrf)((Iterator)localObject1).next();
        if ((((afrf)localObject2).jdField_a_of_type_Aptm == null) || (!paramEmoticonPackage.epId.equals(((afrf)localObject2).jdField_a_of_type_Aptm.a.epId))) {
          break;
        }
        if (((afrf)localObject2).jdField_a_of_type_Aptm.a.jobType == 2) {
          bdkd.a(this.a.b, null);
        }
        this.a.jdField_a_of_type_JavaUtilList.remove(localObject2);
        return;
        bool = false;
        break label295;
        if ((localEmoticon != null) && (localEmoticon.jobType == 4)) {
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.9.3(this, (afrf)localObject1, localEmoticon));
        }
      }
      localObject2 = null;
      localBoolean = Boolean.valueOf(false);
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrd
 * JD-Core Version:    0.7.0.1
 */