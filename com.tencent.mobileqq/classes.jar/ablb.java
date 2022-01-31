import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleNewAnimConf;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ablb
  implements Runnable
{
  public ablb(BubbleInterActiveAnim paramBubbleInterActiveAnim, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = AIOUtils.a(AIOUtils.a(BubbleInterActiveAnim.a(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim), AIOUtils.a(this.jdField_a_of_type_Long, BubbleInterActiveAnim.b(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim).getAdapter())));
    if ((localObject1 != null) && ((localObject1 instanceof BaseBubbleBuilder.ViewHolder))) {}
    for (localObject1 = (BaseBubbleBuilder.ViewHolder)localObject1;; localObject1 = null)
    {
      Object localObject4 = AIOUtils.a(AIOUtils.a(BubbleInterActiveAnim.c(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim), AIOUtils.a(this.b, BubbleInterActiveAnim.d(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim).getAdapter())));
      Object localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject2 = localObject3;
        if ((localObject4 instanceof BaseBubbleBuilder.ViewHolder)) {
          localObject2 = (BaseBubbleBuilder.ViewHolder)localObject4;
        }
      }
      if ((localObject1 == null) || (localObject2 == null) || (((BaseBubbleBuilder.ViewHolder)localObject1).a == null) || (((BaseBubbleBuilder.ViewHolder)localObject2).a == null)) {
        return;
      }
      int i;
      if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((BaseBubbleBuilder.ViewHolder)localObject1).a.a, 8)) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((BaseBubbleBuilder.ViewHolder)localObject2).a.a, 8))) {
        i = 1;
      }
      while (i != 0)
      {
        localObject3 = new Pair(Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.b));
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        ((Message)localObject4).obj = localObject3;
        this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject4);
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((BaseBubbleBuilder.ViewHolder)localObject1).a.a, false);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((BaseBubbleBuilder.ViewHolder)localObject2).a.a, false);
        localObject4 = ((BubbleConfig)localObject4).b.values().iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim.a((BubbleNewAnimConf)((Iterator)localObject4).next(), ((BaseBubbleBuilder.ViewHolder)localObject1).a.a);
            continue;
            i = 0;
            break;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim.a((BubbleNewAnimConf)((BubbleConfig)localObject3).b.get("passive_animation"), ((BaseBubbleBuilder.ViewHolder)localObject2).a.a);
        return;
      }
      QLog.e("BubbleInterActiveAnim", 1, "resource is not all ready, originalMsg: " + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((BaseBubbleBuilder.ViewHolder)localObject1).a.a, 8) + ", target msg: " + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(((BaseBubbleBuilder.ViewHolder)localObject2).a.a, 8));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ablb
 * JD-Core Version:    0.7.0.1
 */