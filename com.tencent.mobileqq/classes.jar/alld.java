import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class alld
  extends alkr
{
  public alld(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = anvx.a(2131697156);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, bffl parambffl, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    boolean bool = axoi.a(paramMessageRecord);
    if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!bool)) {
      return null;
    }
    if (bool)
    {
      if ((paramObject instanceof alld))
      {
        paramObject = (alld)paramObject;
        paramObject.jdField_a_of_type_Bffm.a(parambffl.jdField_a_of_type_Bffm);
        return paramObject;
      }
      paramObject = new alld(BaseApplication.getContext());
      paramObject.jdField_a_of_type_Bffm = new bffm(parambffl.jdField_a_of_type_Bffm);
      return paramObject;
    }
    if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
    {
      paramMessageRecord = (MessageForDeliverGiftTips)paramMessageRecord;
      if (!(paramObject instanceof alld)) {
        break label253;
      }
      paramObject = (alld)paramObject;
      paramObject.jdField_a_of_type_Bffm.a(parambffl.jdField_a_of_type_Bffm);
    }
    for (parambffl = paramObject;; parambffl = paramObject)
    {
      if (!TextUtils.isEmpty(paramMessageRecord.remindBrief))
      {
        paramObject = paramMessageRecord.remindBrief.split("#");
        if (paramObject.length > 1) {
          parambffl.jdField_a_of_type_JavaLangString = ("[" + paramObject[1] + "]");
        }
      }
      paramObject = (bggl)paramQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if (!paramObject.a(false)) {
        break;
      }
      return null;
      bdla.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_HAS_GIFT_IN_TROOP, MessageRecord cast to GiftTips error", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
      return null;
      label253:
      paramObject = new alld(BaseApplication.getContext());
      paramObject.jdField_a_of_type_Bffm = new bffm(parambffl.jdField_a_of_type_Bffm);
    }
    paramObject.a = 1;
    return parambffl;
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
      if (this.jdField_a_of_type_Bffm == null) {
        this.jdField_a_of_type_Bffm = new bffm();
      }
      this.jdField_a_of_type_Bffm.a(paramArrayOfByte.getString("messageNavInfo"));
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
      if (this.jdField_a_of_type_Bffm != null) {
        localJSONObject.put("messageNavInfo", this.jdField_a_of_type_Bffm.a());
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
 * Qualified Name:     alld
 * JD-Core Version:    0.7.0.1
 */