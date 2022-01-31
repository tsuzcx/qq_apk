import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend.QueryRspItem;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.RspBody;

public class altb
  implements alkr
{
  protected void a() {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString) {}
  
  protected void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject) {}
  
  public void a(List<nearbyPeopleRecommend.QueryRspItem> paramList) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, String paramString2, String paramString3) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, oidb_0x8dd.RspBody paramRspBody, ToServiceMsg paramToServiceMsg, List<Object> paramList) {}
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo) {}
  
  protected void a(boolean paramBoolean, NearbyMyTabCard paramNearbyMyTabCard) {}
  
  protected void a(boolean paramBoolean, String paramString, long paramLong) {}
  
  public void a(boolean paramBoolean, String paramString1, List<auwl> paramList, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean1, ArrayList<StrangerInfo> paramArrayList, byte[] paramArrayOfByte, int paramInt, long paramLong1, String paramString, boolean paramBoolean2, long paramLong2, long paramLong3) {}
  
  protected void a(boolean paramBoolean, List<ilive_feeds_near_anchor.NearAnchorInfo> paramList) {}
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void b() {}
  
  protected void b(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void b(boolean paramBoolean, int paramInt, oidb_0x8dd.RspBody paramRspBody, ToServiceMsg paramToServiceMsg, List<Object> paramList) {}
  
  public void b(boolean paramBoolean, NearbyMyTabCard paramNearbyMyTabCard) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      Object[] arrayOfObject;
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return;
                            } while (paramObject == null);
                            paramObject = (Object[])paramObject;
                          } while (paramObject.length != 3);
                          a((FromServiceMsg)paramObject[0], (ToServiceMsg)paramObject[1], (Object[])paramObject[2]);
                          return;
                        } while (paramObject == null);
                        arrayOfObject = (Object[])paramObject;
                      } while (arrayOfObject.length < 4);
                      int i = ((Integer)arrayOfObject[0]).intValue();
                      paramObject = null;
                      if ((arrayOfObject[1] instanceof oidb_0x8dd.RspBody)) {
                        paramObject = (oidb_0x8dd.RspBody)arrayOfObject[1];
                      }
                      ToServiceMsg localToServiceMsg = null;
                      if ((arrayOfObject[2] instanceof ToServiceMsg)) {
                        localToServiceMsg = (ToServiceMsg)arrayOfObject[2];
                      }
                      List localList = null;
                      if ((arrayOfObject[3] instanceof List)) {
                        localList = (List)arrayOfObject[3];
                      }
                      if (paramInt == 1)
                      {
                        b(paramBoolean, i, paramObject, localToServiceMsg, localList);
                        return;
                      }
                      a(paramBoolean, i, paramObject, localToServiceMsg, localList);
                      return;
                      a();
                      return;
                      if ((paramBoolean) && ((paramObject instanceof Object[])))
                      {
                        a(paramBoolean, (NearbyMyTabCard)((Object[])(Object[])paramObject)[0]);
                        return;
                      }
                      a(false, null);
                      return;
                      paramObject = (Object[])paramObject;
                      if ((paramBoolean) && (paramObject != null))
                      {
                        b(true, (NearbyMyTabCard)paramObject[0]);
                        return;
                      }
                      b(false, null);
                      return;
                    } while ((!paramBoolean) || (paramObject == null));
                    a(true, (byte[])paramObject);
                    return;
                    if ((paramBoolean == true) && (paramObject != null))
                    {
                      paramObject = (Object[])paramObject;
                      a(true, new LBSInfo(String.valueOf(paramObject[0]), String.valueOf(paramObject[1]), String.valueOf(paramObject[2]), String.valueOf(paramObject[3]), String.valueOf(paramObject[4]), String.valueOf(paramObject[5]), String.valueOf(paramObject[6]), String.valueOf(paramObject[7]), ((Integer)paramObject[8]).doubleValue(), ((Integer)paramObject[9]).doubleValue(), ((Integer)paramObject[10]).doubleValue(), (String[])paramObject[11]));
                      return;
                    }
                    a(false, null);
                    return;
                  } while ((!paramBoolean) || (!(paramObject instanceof Object[])));
                  paramObject = (Object[])paramObject;
                  a(((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), (String)paramObject[7]);
                  return;
                } while ((!paramBoolean) || (!(paramObject instanceof Object[])));
                paramObject = (Object[])paramObject;
                a(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), ((Integer)paramObject[7]).intValue(), (String)paramObject[8]);
                return;
                paramObject = (Object[])paramObject;
                a(paramBoolean, (String)paramObject[0], (List)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
                return;
                paramObject = (Object[])paramObject;
                a(paramBoolean, (ArrayList)paramObject[0], (byte[])paramObject[1], ((Integer)paramObject[2]).intValue(), ((Long)paramObject[3]).longValue(), (String)paramObject[4], ((Boolean)paramObject[5]).booleanValue(), ((Long)paramObject[6]).longValue(), ((Long)paramObject[7]).longValue());
                return;
              } while ((!paramBoolean) || (!(paramObject instanceof Object[])));
              paramObject = (Object[])paramObject;
              a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), ((Integer)paramObject[7]).intValue(), ((Integer)paramObject[8]).intValue(), (String)paramObject[9], (String)paramObject[10], (String)paramObject[11]);
              return;
            } while (!(paramObject instanceof Object[]));
            paramObject = (Object[])paramObject;
            a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
            return;
          } while (!(paramObject instanceof Object[]));
          paramObject = (Object[])paramObject;
          b(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
          return;
        } while (!(paramObject instanceof Object[]));
        a(paramBoolean, (List)((Object[])(Object[])paramObject)[0]);
        return;
        b();
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    } while (!(paramObject instanceof Object[]));
    a((List)((Object[])(Object[])paramObject)[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     altb
 * JD-Core Version:    0.7.0.1
 */