import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.9.1;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.9.2;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.9.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class adus
  extends anwf
{
  adus(adug paramadug) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    Object localObject2;
    if (paramInt != 0)
    {
      localObject1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aduu)((Iterator)localObject1).next();
        if ((((aduu)localObject2).jdField_a_of_type_Aobk != null) && (paramEmoticonPackage.epId.equals(((aduu)localObject2).jdField_a_of_type_Aobk.a.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "Download magic Emoji fail!");
          }
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.9.1(this, (aduu)localObject2));
        }
      }
    }
    do
    {
      this.a.jdField_a_of_type_JavaUtilList.remove(localObject2);
      return;
      while ((!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) || (paramEmoticonPackage == null)) {}
      localObject1 = ((askd)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramEmoticonPackage.epId);
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
          localObject1 = (aduu)((Iterator)localObject2).next();
          if ((((aduu)localObject1).jdField_a_of_type_Aobk != null) && (paramEmoticonPackage.epId.equals(((aduu)localObject1).jdField_a_of_type_Aobk.a.epId)))
          {
            localObject2 = ((aduu)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if ((((aduu)localObject1).jdField_a_of_type_Boolean) && (((aduu)localObject1).e.hasWindowFocus()))
            {
              bool = true;
              ((aduu)localObject1).jdField_a_of_type_Boolean = false;
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
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.9.2(this, localEmoticon, (String)localObject2, (aduu)localObject1));
        }
      }
      for (;;)
      {
        localObject1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (aduu)((Iterator)localObject1).next();
        if ((((aduu)localObject2).jdField_a_of_type_Aobk == null) || (!paramEmoticonPackage.epId.equals(((aduu)localObject2).jdField_a_of_type_Aobk.a.epId))) {
          break;
        }
        if (((aduu)localObject2).jdField_a_of_type_Aobk.a.jobType == 2) {
          bbkv.a(this.a.b, null);
        }
        this.a.jdField_a_of_type_JavaUtilList.remove(localObject2);
        return;
        bool = false;
        break label295;
        if ((localEmoticon != null) && (localEmoticon.jobType == 4)) {
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.9.3(this, (aduu)localObject1, localEmoticon));
        }
      }
      localObject2 = null;
      localBoolean = Boolean.valueOf(false);
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adus
 * JD-Core Version:    0.7.0.1
 */