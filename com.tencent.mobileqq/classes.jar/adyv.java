import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class adyv
  extends anwy
{
  public adyv(BaseChatPie paramBaseChatPie) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while ((BaseChatPie.a(this.a) == null) || (paramObject == null) || (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx == null));
      localObject = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      paramObject = (EmoticonResp)paramObject;
      BaseChatPie.a(this.a).a(paramBoolean, paramInt, paramObject, (String)localObject);
      return;
      if ((this.a.jdField_a_of_type_Bjbs != null) && (this.a.jdField_a_of_type_Bjbs.isShowing())) {
        this.a.jdField_a_of_type_Bjbs.dismiss();
      }
    } while (paramObject == null);
    Object localObject = (EmoticonResp)paramObject;
    int i;
    if (paramBoolean)
    {
      i = ((EmoticonResp)localObject).delEpId;
      if ((((EmoticonResp)localObject).keySeq == null) || (((EmoticonResp)localObject).keySeq.equals(""))) {
        paramObject = anzj.a(2131699899);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(((EmoticonResp)localObject).emoticonId)) {
        break label240;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "auth type emoticon id is null");
      return;
      paramObject = ((EmoticonResp)localObject).keySeq;
      continue;
      paramObject = anzj.a(2131699884);
      i = -404;
    }
    label240:
    ((axfj)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(String.valueOf(((EmoticonResp)localObject).epId), ((EmoticonResp)localObject).emoticonId, new adyw(this, paramInt, i, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyv
 * JD-Core Version:    0.7.0.1
 */