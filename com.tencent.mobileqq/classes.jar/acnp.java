import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeywords;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.EmotionKeyword;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.EmotionKeywordAdapter;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.emosm.EmosmPb.BqAssocInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class acnp
  implements Runnable
{
  public acnp(EmotionKeywordAdapter paramEmotionKeywordAdapter, EmoticonResp paramEmoticonResp, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonResp.resetKeywordExpose) {
      EmotionKeywordAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter).a(EmotionKeywordAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter));
    }
    Object localObject1 = new EmoticonKeywords();
    ((EmoticonKeywords)localObject1).keyword = EmotionKeywordAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter);
    ((EmoticonKeywords)localObject1).lastReqTime = System.currentTimeMillis();
    EmotionKeywordAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter).a((EmoticonKeywords)localObject1);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticonResp.data;
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordAdapter", 2, "handleCloudEmotionForKeywordResp keyword = " + EmotionKeywordAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter) + ",resp size = " + ((List)localObject1).size());
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("handleCloudEmotionForKeywordResp : eId = ");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(EmotionKeywordAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter));
    Object localObject3 = ((List)localObject1).iterator();
    EmosmPb.BqAssocInfo localBqAssocInfo;
    Emoticon localEmoticon;
    while (((Iterator)localObject3).hasNext())
    {
      localBqAssocInfo = (EmosmPb.BqAssocInfo)((Iterator)localObject3).next();
      localEmoticon = new Emoticon();
      localEmoticon.epId = String.valueOf(localBqAssocInfo.u32_tab_id.get());
      localEmoticon.eId = localBqAssocInfo.str_item_id.get();
      localEmoticon.name = localBqAssocInfo.str_item_name.get();
      localEmoticon.encryptKey = localBqAssocInfo.str_item_key.get();
      localEmoticon.ipsiteUrl = localBqAssocInfo.str_ipsite_url.get();
      localEmoticon.ipsiteName = localBqAssocInfo.str_ipsite_name.get();
      if (QLog.isColorLevel()) {
        QLog.d("EmotionKeywordAdapter", 2, "handleCloudEmotionForKeywordResp keyword = " + EmotionKeywordAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter) + "id = " + localEmoticon.epId + " ipSiteName = " + localEmoticon.ipsiteName + " ipsiteUrl = " + localEmoticon.ipsiteUrl);
      }
      if ((!TextUtils.isEmpty(localEmoticon.epId)) && (!TextUtils.isEmpty(localEmoticon.eId)) && (!TextUtils.isEmpty(localEmoticon.encryptKey)))
      {
        localObject1 = localBqAssocInfo.rpt_str_item_keyword.get();
        if (localObject1 != null) {
          break label926;
        }
        localObject1 = new ArrayList();
      }
    }
    label926:
    for (;;)
    {
      if (EmotionKeywordAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter).a(localEmoticon.epId) == null) {
        ((EmojiManager)EmotionKeywordAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter).getManager(42)).a(localEmoticon.epId, EmojiManager.b);
      }
      label472:
      int i;
      label504:
      boolean bool;
      if (((List)localObject1).size() > 0)
      {
        localObject1 = localObject1.toString();
        localEmoticon.keyword = ((String)localObject1);
        localEmoticon.keywords = ((String)localObject1);
        i = localBqAssocInfo.i32_tab_ringtype.get();
        if (i != 1) {
          break label744;
        }
        localEmoticon.isSound = true;
        localEmoticon.jobType = 0;
        localEmoticon.width = 200;
        localEmoticon.height = 200;
        localEmoticon.businessExtra = "";
        if (localBqAssocInfo.uint32_emoji_type.has())
        {
          if (localBqAssocInfo.uint32_emoji_type.get() != 2) {
            break label752;
          }
          bool = true;
          label558:
          localEmoticon.isAPNG = bool;
        }
        if (!localBqAssocInfo.rpt_apng_support_size.has()) {
          break label757;
        }
        EmotionKeywordAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter).a(localEmoticon.epId, localEmoticon, localBqAssocInfo.rpt_apng_support_size.get());
        label600:
        localObject1 = new EmotionKeyword();
        ((EmotionKeyword)localObject1).keyword = EmotionKeywordAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter).toLowerCase();
        ((EmotionKeyword)localObject1).epId = localEmoticon.epId;
        ((EmotionKeyword)localObject1).eId = localEmoticon.eId;
        EmotionKeywordAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter).a((EmotionKeyword)localObject1);
        EmotionKeywordAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter).a(localEmoticon);
        i = 0;
      }
      for (;;)
      {
        if (i < localArrayList.size())
        {
          localObject1 = (Emoticon)localArrayList.get(i);
          if ((localObject1 != null) && ("NONE".equals(((Emoticon)localObject1).epId))) {
            localArrayList.set(i, localEmoticon);
          }
        }
        else
        {
          ((StringBuilder)localObject2).append(localEmoticon.eId).append(",");
          break;
          localObject1 = this.jdField_a_of_type_JavaLangString;
          break label472;
          label744:
          if (i != 4) {
            break label504;
          }
          break;
          label752:
          bool = false;
          break label558;
          label757:
          if (!localBqAssocInfo.rpt_support_size.has()) {
            break label600;
          }
          EmotionKeywordAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter).a(localEmoticon.epId, localEmoticon, localBqAssocInfo.rpt_support_size.get());
          break label600;
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmotionKeywordAdapter", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = new ArrayList();
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Emoticon)((Iterator)localObject2).next();
        if ((localObject3 != null) && ("NONE".equals(((Emoticon)localObject3).epId))) {
          ((List)localObject1).add(localObject3);
        }
      }
      if (((List)localObject1).size() > 0) {
        localArrayList.removeAll((Collection)localObject1);
      }
      ThreadManager.getUIHandler().post(new acnq(this, localArrayList));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acnp
 * JD-Core Version:    0.7.0.1
 */