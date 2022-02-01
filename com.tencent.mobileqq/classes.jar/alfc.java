import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class alfc
  extends alej
{
  public boolean a;
  
  public alfc(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public alfc(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = anni.a(2131696959);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public Object a(int paramInt, bepr parambepr, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageRecord == null)
    {
      parambepr = null;
      return parambepr;
    }
    boolean bool = axci.a(paramMessageRecord);
    if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!bool)) {
      return null;
    }
    if (bool)
    {
      if ((paramObject instanceof alfc))
      {
        paramObject = (alfc)paramObject;
        paramObject.jdField_a_of_type_Beps.a(parambepr.jdField_a_of_type_Beps);
        return paramObject;
      }
      paramObject = new alfc(BaseApplication.getContext());
      paramObject.jdField_a_of_type_Beps = new beps(parambepr.jdField_a_of_type_Beps);
      return paramObject;
    }
    if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
    {
      paramQQAppInterface = (MessageForDeliverGiftTips)paramMessageRecord;
      paramInt = 1;
      i = 1;
      if (!(paramObject instanceof alfc)) {
        break label287;
      }
      paramMessageRecord = (alfc)paramObject;
      paramInt = i;
      if (paramMessageRecord.jdField_a_of_type_Boolean)
      {
        paramInt = i;
        if (!paramQQAppInterface.isToAll()) {
          paramInt = 0;
        }
      }
      i = paramInt;
      paramObject = paramMessageRecord;
      if (!paramMessageRecord.jdField_a_of_type_Boolean)
      {
        paramMessageRecord.jdField_a_of_type_Beps.a(parambepr.jdField_a_of_type_Beps);
        paramObject = paramMessageRecord;
      }
    }
    for (int i = paramInt;; i = paramInt)
    {
      parambepr = paramObject;
      if (i == 0) {
        break;
      }
      parambepr = paramObject;
      if (TextUtils.isEmpty(paramQQAppInterface.remindBrief)) {
        break;
      }
      parambepr = paramQQAppInterface.remindBrief.split("#");
      paramObject.jdField_a_of_type_JavaLangString = ("[" + parambepr[0] + "]");
      return paramObject;
      bcst.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_RECEIVED_FLOWSER_MSG, MessageRecord cast to GiftTips", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
      return null;
      label287:
      paramObject = new alfc(BaseApplication.getContext(), paramQQAppInterface.isToAll());
      paramObject.jdField_a_of_type_Beps = new beps(parambepr.jdField_a_of_type_Beps);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.jdField_a_of_type_Long = paramArrayOfByte.optLong("uniseq");
      this.jdField_b_of_type_Long = paramArrayOfByte.optLong("shmsgseq");
      this.jdField_a_of_type_JavaLangString = paramArrayOfByte.optString("content");
      this.jdField_b_of_type_Int = paramArrayOfByte.optInt("color");
      this.jdField_a_of_type_Boolean = paramArrayOfByte.optBoolean("isToAll");
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
      localJSONObject.put("isToAll", this.jdField_a_of_type_Boolean);
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
 * Qualified Name:     alfc
 * JD-Core Version:    0.7.0.1
 */