import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ajul
  extends MSFServlet
{
  private byte[] a(byte paramByte, String paramString1, String paramString2)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1372);
    localOIDBSSOPkg.uint32_service_type.set(1);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(9);
    paramString1 = Long.valueOf(Long.parseLong(paramString1));
    int i = (byte)(int)(paramString1.longValue() & 0xFF);
    int j = (byte)(int)(paramString1.longValue() >> 8 & 0xFF);
    int k = (byte)(int)(paramString1.longValue() >> 16 & 0xFF);
    int m = (byte)(int)(paramString1.longValue() >> 24 & 0xFF);
    paramString1 = Long.valueOf(Long.parseLong(paramString2));
    int n = (byte)(int)(paramString1.longValue() & 0xFF);
    int i1 = (byte)(int)(paramString1.longValue() >> 8 & 0xFF);
    int i2 = (byte)(int)(paramString1.longValue() >> 16 & 0xFF);
    int i3 = (byte)(int)(paramString1.longValue() >> 24 & 0xFF);
    localByteBuffer.put(new byte[] { m, k, j, i }).put(new byte[] { i3, i2, i1, n }).put(paramByte);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramString1 = localOIDBSSOPkg.toByteArray();
    paramString2 = ByteBuffer.allocate(paramString1.length + 4);
    paramString2.putInt(paramString1.length + 4);
    paramString2.put(paramString1);
    return paramString2.array();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = false;
    int i = paramIntent.getIntExtra("command", -1);
    boolean bool1 = paramFromServiceMsg.isSuccess();
    Bundle localBundle = new Bundle();
    switch (i)
    {
    }
    label120:
    byte b;
    for (;;)
    {
      notifyObserver(paramIntent, i, bool1, localBundle, ajuc.class);
      return;
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        Object localObject1 = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get((byte[])localObject1);
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])localObject1);
        int j = paramFromServiceMsg.uint32_result.get();
        if (j != 0) {
          break label366;
        }
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.d("set_troop_admin", 2, "resultCode: " + j);
        }
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (bool1)
        {
          localObject1 = new byte[4];
          paramFromServiceMsg.get((byte[])localObject1);
          localObject1 = String.valueOf(azzz.a((byte[])localObject1, 0));
          Object localObject2 = new byte[4];
          paramFromServiceMsg.get((byte[])localObject2);
          localObject2 = String.valueOf(azzz.a((byte[])localObject2, 0));
          b = paramFromServiceMsg.get();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("set troop admin response. troopCode: ").append((String)localObject1).append(" memberUin: ").append((String)localObject2).append(" operation: ");
            if (b != 0) {
              break label372;
            }
            paramFromServiceMsg = "delete";
            label269:
            QLog.d("set_troop_admin", 2, paramFromServiceMsg);
          }
          if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (localObject2 == null) || (((String)localObject2).length() <= 0)) {
            break label389;
          }
          localBundle.putString("troop_code", (String)localObject1);
          localBundle.putString("troop_member_uin", (String)localObject2);
          localBundle.putByte("operation", b);
        }
        else
        {
          localBundle.putInt("error_code", j);
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        bool1 = bool2;
      }
    }
    for (;;)
    {
      break;
      label366:
      bool1 = false;
      break label120;
      label372:
      if (b == 1)
      {
        paramFromServiceMsg = "add";
        break label269;
      }
      paramFromServiceMsg = "unkonwn";
      break label269;
      label389:
      bool1 = false;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("command", -1);
    String str1 = null;
    switch (i)
    {
    default: 
      paramIntent = str1;
      if (paramIntent != null) {
        paramPacket.setSSOCommand(paramIntent);
      }
      return;
    }
    byte b = paramIntent.getByteExtra("operation", (byte)0);
    str1 = paramIntent.getStringExtra("troop_code");
    String str2 = paramIntent.getStringExtra("troop_member_uin");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("request set troop admin. troopCode: ").append(str1).append(" memberUin: ").append(str2).append(" operation: ");
      if (b != 0) {
        break label150;
      }
      paramIntent = "delete";
    }
    for (;;)
    {
      QLog.d("set_troop_admin", 2, paramIntent);
      paramPacket.putSendData(a(b, str1, str2));
      paramIntent = "OidbSvc.0x55c_1";
      break;
      label150:
      if (b == 1) {
        paramIntent = "add";
      } else {
        paramIntent = "unkonwn";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajul
 * JD-Core Version:    0.7.0.1
 */