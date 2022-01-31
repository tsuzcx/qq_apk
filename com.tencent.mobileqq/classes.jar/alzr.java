import com.tencent.biz.pubaccount.AccountDetail.jce.SetRecvMsgStateRsp;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class alzr
  implements alpg
{
  public void a(int paramInt) {}
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo) {}
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt) {}
  
  public void a(boolean paramBoolean, SetRecvMsgStateRsp paramSetRecvMsgStateRsp) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, ArrayList<Long> paramArrayList) {}
  
  public void a(boolean paramBoolean, npo paramnpo) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(int paramInt, PublicAccountInfo paramPublicAccountInfo) {}
  
  public void b(boolean paramBoolean, int paramInt) {}
  
  public void b(boolean paramBoolean, String paramString) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (100 == paramInt)
    {
      paramObject = (alzt)paramObject;
      a(paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_Boolean);
    }
    do
    {
      return;
      if (101 == paramInt)
      {
        if ((paramObject instanceof alzs))
        {
          paramObject = (alzs)paramObject;
          b(paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
          return;
        }
        if ((paramObject instanceof Integer))
        {
          b(paramBoolean, ((Integer)paramObject).intValue());
          return;
        }
        a(paramBoolean, String.valueOf(paramObject));
        return;
      }
      if (102 == paramInt)
      {
        if ((paramObject instanceof alzs))
        {
          paramObject = (alzs)paramObject;
          a(paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
          return;
        }
        b(paramBoolean, String.valueOf(paramObject));
        return;
      }
      if (103 == paramInt)
      {
        t_();
        return;
      }
      if (104 == paramInt)
      {
        a(paramBoolean);
        return;
      }
      if (105 == paramInt)
      {
        a(((Integer)paramObject).intValue());
        return;
      }
      if (106 == paramInt)
      {
        a(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      }
      if (109 == paramInt)
      {
        a(paramBoolean, (npo)paramObject);
        return;
      }
      if (108 == paramInt)
      {
        paramObject = (HashMap)paramObject;
        a(paramBoolean, ((Integer)paramObject.get("seq")).intValue(), ((Long)paramObject.get("uin")).longValue());
        return;
      }
      if (110 == paramInt)
      {
        a(paramBoolean, (ArrayList)paramObject);
        return;
      }
      if (111 == paramInt)
      {
        paramObject = (HashMap)paramObject;
        long l = 0L;
        paramInt = 0;
        if (paramObject != null)
        {
          l = ((Long)paramObject.get("uin")).longValue();
          paramInt = ((Integer)paramObject.get("status")).intValue();
        }
        a(paramBoolean, l, paramInt);
        return;
      }
    } while ((112 != paramInt) || (!(paramObject instanceof SetRecvMsgStateRsp)));
    a(paramBoolean, (SetRecvMsgStateRsp)paramObject);
  }
  
  public void t_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alzr
 * JD-Core Version:    0.7.0.1
 */