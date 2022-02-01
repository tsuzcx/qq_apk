import android.widget.ImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.6.1;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.6.2;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.6.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ahcq
  extends arvc
{
  ahcq(ahch paramahch) {}
  
  private void a(EmoticonPackage paramEmoticonPackage, Boolean paramBoolean, List<Emoticon> paramList)
  {
    Boolean localBoolean = null;
    paramList = paramList.iterator();
    Emoticon localEmoticon;
    boolean bool;
    if (paramList.hasNext())
    {
      localEmoticon = (Emoticon)paramList.next();
      Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramList = (ahcu)localIterator.next();
          if ((paramList.jdField_a_of_type_Asbq != null) && (paramEmoticonPackage.epId.equals(paramList.jdField_a_of_type_Asbq.a.epId)))
          {
            paramBoolean = paramList.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if ((paramList.jdField_a_of_type_Boolean) && (paramList.e.hasWindowFocus()))
            {
              bool = true;
              localBoolean = Boolean.valueOf(bool);
              paramList.jdField_a_of_type_Boolean = false;
              paramEmoticonPackage = paramList;
              paramList = paramBoolean;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localBoolean.booleanValue()) {
        if (paramList != null)
        {
          paramBoolean = paramList.senderuin;
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.6.2(this, localEmoticon, paramBoolean, paramEmoticonPackage));
        }
      }
      while ((localEmoticon == null) || (localEmoticon.jobType != 4))
      {
        return;
        bool = false;
        break;
      }
      ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.6.3(this, paramEmoticonPackage, localEmoticon));
      return;
      paramList = null;
      paramEmoticonPackage = localBoolean;
      localBoolean = paramBoolean;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    Object localObject;
    ahcu localahcu;
    if (paramInt != 0)
    {
      localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localahcu = (ahcu)((Iterator)localObject).next();
        if ((localahcu.jdField_a_of_type_Asbq != null) && (paramEmoticonPackage.epId.equals(localahcu.jdField_a_of_type_Asbq.a.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "Download magic Emoji fail!");
          }
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.6.1(this, localahcu));
        }
      }
    }
    label118:
    do
    {
      do
      {
        do
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(localahcu);
          return;
          break label118;
          while ((!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) || (paramEmoticonPackage == null)) {}
          localObject = ((awmr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramEmoticonPackage.epId);
        } while (localObject == null);
        a(paramEmoticonPackage, Boolean.valueOf(false), (List)localObject);
        localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      } while (!((Iterator)localObject).hasNext());
      localahcu = (ahcu)((Iterator)localObject).next();
    } while ((localahcu.jdField_a_of_type_Asbq == null) || (!paramEmoticonPackage.epId.equals(localahcu.jdField_a_of_type_Asbq.a.epId)));
    if (localahcu.jdField_a_of_type_Asbq.a.jobType == 2) {
      bgtl.a(this.a.b, null);
    }
    this.a.jdField_a_of_type_JavaUtilList.remove(localahcu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcq
 * JD-Core Version:    0.7.0.1
 */