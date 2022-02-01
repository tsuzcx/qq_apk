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

public class ahmc
  extends askq
{
  ahmc(ahlt paramahlt) {}
  
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
          paramList = (ahmg)localIterator.next();
          if ((paramList.jdField_a_of_type_Asre != null) && (paramEmoticonPackage.epId.equals(paramList.jdField_a_of_type_Asre.a.epId)))
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
    ahmg localahmg;
    if (paramInt != 0)
    {
      localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localahmg = (ahmg)((Iterator)localObject).next();
        if ((localahmg.jdField_a_of_type_Asre != null) && (paramEmoticonPackage.epId.equals(localahmg.jdField_a_of_type_Asre.a.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "Download magic Emoji fail!");
          }
          ((BaseActivity)this.a.b).runOnUiThread(new MarketFaceItemBuilder.6.1(this, localahmg));
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
          this.a.jdField_a_of_type_JavaUtilList.remove(localahmg);
          return;
          break label118;
          while ((!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) || (paramEmoticonPackage == null)) {}
          localObject = ((axfj)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramEmoticonPackage.epId);
        } while (localObject == null);
        a(paramEmoticonPackage, Boolean.valueOf(false), (List)localObject);
        localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      } while (!((Iterator)localObject).hasNext());
      localahmg = (ahmg)((Iterator)localObject).next();
    } while ((localahmg.jdField_a_of_type_Asre == null) || (!paramEmoticonPackage.epId.equals(localahmg.jdField_a_of_type_Asre.a.epId)));
    if (localahmg.jdField_a_of_type_Asre.a.jobType == 2) {
      bhto.a(this.a.b, null);
    }
    this.a.jdField_a_of_type_JavaUtilList.remove(localahmg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmc
 * JD-Core Version:    0.7.0.1
 */