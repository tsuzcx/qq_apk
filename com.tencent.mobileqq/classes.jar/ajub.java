import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.ui.RoundProgressBar;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.observer.BusinessObserver;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.OStatisticInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.RspBody;

public class ajub
  implements BusinessObserver
{
  private final WeakReference a;
  
  public ajub(TroopMoreDetailView paramTroopMoreDetailView)
  {
    this.a = new WeakReference(paramTroopMoreDetailView);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject2 = (TroopMoreDetailView)this.a.get();
    if (localObject2 == null) {}
    label17:
    Object localObject1;
    Context localContext;
    int j;
    label129:
    View localView;
    StringBuffer localStringBuffer;
    do
    {
      do
      {
        break label17;
        break label17;
        for (;;)
        {
          return;
          if (paramBoolean)
          {
            localObject1 = paramBundle.getByteArray("data");
            if (localObject1 == null) {
              break;
            }
            localContext = ((TroopMoreDetailView)localObject2).getContext();
            if (localContext == null) {
              break;
            }
            try
            {
              paramBundle = new troop_member_distribute.RspBody();
              paramBundle.mergeFrom((byte[])localObject1);
              if (paramBundle.uint32_result.get() == 0)
              {
                localObject1 = paramBundle.rpt_msg_statistic.get();
                j = paramBundle.uint32_group_member.get();
                if (j != 0) {
                  break label129;
                }
                if (QLog.isColorLevel())
                {
                  QLog.d("TroopMoreDetailView", 2, "mGetTroopMemberDistributeObserver.onReceive: memberCount should not be 0!");
                  return;
                }
              }
            }
            catch (InvalidProtocolBufferMicroException paramBundle) {}
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("TroopMoreDetailView", 2, paramBundle, new Object[0]);
      return;
      localView = localObject2.a[5];
      localStringBuffer = new StringBuffer(((TroopMoreDetailView)localObject2).getResources().getString(2131433110));
    } while ((localView == null) || (((List)localObject1).size() < 4));
    localView.setVisibility(0);
    if (localObject2.a[4] != null) {
      localObject2.a[4].setBackgroundResource(2130838635);
    }
    localStringBuffer.append(",本群共").append(j).append("人");
    paramBundle = localView.findViewById(2131366548);
    int i = 0;
    if (i < ((List)localObject1).size())
    {
      paramInt = Color.parseColor("#ffffff00");
      switch (i)
      {
      }
    }
    for (;;)
    {
      localObject2 = (troop_member_distribute.OStatisticInfo)((List)localObject1).get(i);
      Object localObject3 = (RoundProgressBar)paramBundle.findViewById(2131368506);
      ((RoundProgressBar)localObject3).setTextColor(localContext.getResources().getColor(2131494215));
      ((RoundProgressBar)localObject3).setCircleColor(Color.parseColor("#b2ffffff"));
      ((RoundProgressBar)localObject3).setRoundWidth(2.0F);
      ((RoundProgressBar)localObject3).setTextSize(34.0F);
      ((RoundProgressBar)localObject3).setCircleProgressColor(paramInt);
      paramInt = ((troop_member_distribute.OStatisticInfo)localObject2).uint32_count.get() * 100 / j;
      ((RoundProgressBar)localObject3).setProgress(paramInt);
      localObject3 = (TextView)paramBundle.findViewById(2131363378);
      localObject2 = ((troop_member_distribute.OStatisticInfo)localObject2).bytes_desc.get().toStringUtf8();
      ((TextView)localObject3).setText((CharSequence)localObject2);
      localObject2 = ((String)localObject2).split("-");
      localStringBuffer.append(", 百分之").append(paramInt).append("为").append(localObject2[0]);
      i += 1;
      break;
      paramBundle = localView.findViewById(2131366548);
      paramInt = Color.parseColor("#ff771bf4");
      continue;
      paramBundle = localView.findViewById(2131366549);
      paramInt = Color.parseColor("#ff0eddb8");
      continue;
      paramBundle = localView.findViewById(2131366550);
      paramInt = Color.parseColor("#ff0d8aff");
      continue;
      paramBundle = localView.findViewById(2131366551);
      paramInt = Color.parseColor("#ffff8400");
      continue;
      localView.setContentDescription(localStringBuffer);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajub
 * JD-Core Version:    0.7.0.1
 */