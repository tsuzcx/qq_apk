import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class alev
  extends alej
{
  public alev(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = anni.a(2131696692);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, bepr parambepr, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    boolean bool = axci.a(paramMessageRecord);
    if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!bool)) {
      return null;
    }
    if (bool)
    {
      if ((paramObject instanceof alev))
      {
        paramObject = (alev)paramObject;
        paramObject.jdField_a_of_type_Beps.a(parambepr.jdField_a_of_type_Beps);
        return paramObject;
      }
      paramObject = new alev(BaseApplication.getContext());
      paramObject.jdField_a_of_type_Beps = new beps(parambepr.jdField_a_of_type_Beps);
      return paramObject;
    }
    if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
    {
      paramMessageRecord = (MessageForDeliverGiftTips)paramMessageRecord;
      if (!(paramObject instanceof alev)) {
        break label253;
      }
      paramObject = (alev)paramObject;
      paramObject.jdField_a_of_type_Beps.a(parambepr.jdField_a_of_type_Beps);
    }
    for (parambepr = paramObject;; parambepr = paramObject)
    {
      if (!TextUtils.isEmpty(paramMessageRecord.remindBrief))
      {
        paramObject = paramMessageRecord.remindBrief.split("#");
        if (paramObject.length > 1) {
          parambepr.jdField_a_of_type_JavaLangString = ("[" + paramObject[1] + "]");
        }
      }
      paramObject = (bfos)paramQQAppInterface.getManager(223);
      if (!paramObject.a(false)) {
        break;
      }
      return null;
      bcst.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_HAS_GIFT_IN_TROOP, MessageRecord cast to GiftTips error", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
      return null;
      label253:
      paramObject = new alev(BaseApplication.getContext());
      paramObject.jdField_a_of_type_Beps = new beps(parambepr.jdField_a_of_type_Beps);
    }
    paramObject.a = 1;
    return parambepr;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.jdField_a_of_type_Long = paramArrayOfByte.getLong("uniseq");
      this.jdField_b_of_type_Long = paramArrayOfByte.getLong("shmsgseq");
      this.jdField_a_of_type_JavaLangString = paramArrayOfByte.getString("content");
      this.jdField_b_of_type_Int = paramArrayOfByte.getInt("color");
      if (this.jdField_a_of_type_Beps == null) {
        this.jdField_a_of_type_Beps = new beps();
      }
      this.jdField_a_of_type_Beps.a(paramArrayOfByte.getString("messageNavInfo"));
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public byte[] a()
  {
    return b();
  }
  
  public byte[] b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uniseq", this.jdField_a_of_type_Long);
      localJSONObject.put("shmsgseq", this.jdField_b_of_type_Long);
      localJSONObject.put("content", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("color", this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Beps != null) {
        localJSONObject.put("messageNavInfo", this.jdField_a_of_type_Beps.a());
      }
      return localJSONObject.toString().getBytes();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alev
 * JD-Core Version:    0.7.0.1
 */