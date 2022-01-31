import com.tencent.ims.SafeReport.LogItem;
import com.tencent.ims.SafeReport.ReqBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.QSecRptController;
import com.tencent.qqprotect.common.QSecRptControllerImpl;
import com.tencent.qqprotect.common.QSecRptItem;
import java.util.Iterator;
import java.util.Vector;

public class alwn
  implements Runnable
{
  public alwn(QSecRptControllerImpl paramQSecRptControllerImpl) {}
  
  public void run()
  {
    Object localObject2 = new SafeReport.ReqBody();
    Iterator localIterator = ((Vector)QSecRptControllerImpl.a(this.a).get(QSecRptControllerImpl.a(this.a).intValue())).iterator();
    int i = 0;
    int j = 0;
    Object localObject1;
    if (localIterator.hasNext())
    {
      Object localObject3 = (QSecRptItem)localIterator.next();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new SafeReport.ReqBody();
      }
      String str = QSecRptController.a(QSecRptController.a(((QSecRptItem)localObject3).jdField_a_of_type_Int));
      localObject2 = new SafeReport.LogItem();
      ((SafeReport.LogItem)localObject2).uint32_rpt_id.set(((QSecRptItem)localObject3).jdField_a_of_type_Int);
      localObject3 = str + "," + ((QSecRptItem)localObject3).b + "," + ((QSecRptItem)localObject3).jdField_a_of_type_JavaLangString;
      ((SafeReport.LogItem)localObject2).bytes_rpt_data.set(ByteStringMicro.copyFrom(((String)localObject3).getBytes()));
      ((SafeReport.ReqBody)localObject1).LogItem_reportdata.add((MessageMicro)localObject2);
      j += 1;
      i = ((String)localObject3).length() + i;
      if ((j != 20) && (i <= 1024)) {
        break label316;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QSRPT", 2, String.format("sending...item count: %d, package size: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
      }
      QSecRptControllerImpl.a(this.a, (SafeReport.ReqBody)localObject1);
      localObject1 = null;
      i = 0;
      j = 0;
    }
    label316:
    for (;;)
    {
      localObject2 = localObject1;
      break;
      if ((j > 0) && (localObject2 != null)) {
        QSecRptControllerImpl.a(this.a, (SafeReport.ReqBody)localObject2);
      }
      ((Vector)QSecRptControllerImpl.a(this.a).get(QSecRptControllerImpl.a(this.a).intValue())).removeAllElements();
      QSecRptControllerImpl.a(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alwn
 * JD-Core Version:    0.7.0.1
 */