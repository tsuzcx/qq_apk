import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.intimate_relation.intimate_relation.IntimateBuddy;
import tencent.intimate_relation.intimate_relation.IntimateInfo;
import tencent.intimate_relation.intimate_relation.IntimateLadybro;
import tencent.intimate_relation.intimate_relation.IntimateLover;
import tencent.intimate_relation.intimate_relation.SnsRelationInfo;

public class aerw
{
  public int a;
  
  public static aerw a(byte[] paramArrayOfByte)
  {
    intimate_relation.IntimateInfo localIntimateInfo = null;
    intimate_relation.SnsRelationInfo localSnsRelationInfo = new intimate_relation.SnsRelationInfo();
    for (;;)
    {
      try
      {
        localSnsRelationInfo.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = localIntimateInfo;
        if (localSnsRelationInfo.intimate_list.has())
        {
          paramArrayOfByte = localIntimateInfo;
          if (localSnsRelationInfo.intimate_list.size() > 0)
          {
            paramArrayOfByte = new aerw();
            localIntimateInfo = (intimate_relation.IntimateInfo)localSnsRelationInfo.intimate_list.get(0);
            if ((!localIntimateInfo.lover.has()) || (!((intimate_relation.IntimateLover)localIntimateInfo.lover.get()).level.has())) {
              break label173;
            }
            paramArrayOfByte.a = ((intimate_relation.IntimateLover)localIntimateInfo.lover.get()).level.get();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("ExtSnsIntimateInfo", 1, "parseFrom retInfo:" + paramArrayOfByte);
        }
        return paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte)
      {
        QLog.i("ExtSnsIntimateInfo", 1, "parseFrom error:" + paramArrayOfByte.getMessage());
        return null;
      }
      label173:
      if ((localIntimateInfo.buddy.has()) && (((intimate_relation.IntimateBuddy)localIntimateInfo.buddy.get()).level.has())) {
        paramArrayOfByte.a = ((intimate_relation.IntimateBuddy)localIntimateInfo.buddy.get()).level.get();
      } else if ((localIntimateInfo.ladybro.has()) && (((intimate_relation.IntimateLadybro)localIntimateInfo.ladybro.get()).level.has())) {
        paramArrayOfByte.a = ((intimate_relation.IntimateLadybro)localIntimateInfo.ladybro.get()).level.get();
      }
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtSnsIntimatePushInfo{");
    localStringBuilder.append("intimate_level:").append(this.a).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aerw
 * JD-Core Version:    0.7.0.1
 */