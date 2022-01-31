import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageReqInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageRespInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.InflaterInputStream;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.app.Packet;
import org.apache.http.util.ByteArrayBuffer;

public class agte
  extends mmi
{
  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("k_req_occasion", 0);
      int j = paramIntent.getIntExtra("k_version", -1);
      QLog.e("springHb_SpringFestivalRedpacketConfigServlet", 1, String.format("handleGetConfigFail reqOccasion=%s reqVersion=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      ((agtb)((QQAppInterface)getAppRuntime()).getManager(341)).a(false, j, 0, null, null, i);
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.e("springHb_SpringFestivalRedpacketConfigServlet", 1, "inflate fail.", paramArrayOfByte);
      return null;
    }
    return paramArrayOfByte;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d("parsons_test", 2, "-->入口配置请求回包");
    m = 1;
    int i4 = 1;
    i1 = 1;
    i6 = 1;
    int i3 = 1;
    j = 1;
    i8 = 1;
    i5 = 1;
    n = 1;
    i2 = 0;
    i7 = 0;
    int i9 = paramIntent.getIntExtra("k_cmd", -1);
    i = paramIntent.getIntExtra("k_id", 0);
    k = paramIntent.getIntExtra("k_version", -1);
    Object localObject1 = "";
    if (paramFromServiceMsg.isSuccess()) {}
    try
    {
      paramFromServiceMsg = bakc.b(paramFromServiceMsg.getWupBuffer());
      switch (i9)
      {
      default: 
        i2 = 0;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        m = j;
        i1 = k;
        j = i2;
      }
    }
    catch (Throwable paramFromServiceMsg)
    {
      for (;;)
      {
        Object localObject4;
        int i10;
        j = i;
        i = k;
        k = i1;
        m = i2;
        continue;
        Object localObject3;
        continue;
        k = 1;
        continue;
        for (;;)
        {
          i1 = j;
          j = 0;
          n = k;
          break;
          if ((i10 == 0) && (i8 != j)) {
            break label674;
          }
          m = i6;
          paramFromServiceMsg = localObject3;
          k = i5;
          if (i10 != 0)
          {
            m = i6;
            paramFromServiceMsg = localObject3;
            k = i5;
            if (i8 == j) {
              break label674;
            }
          }
        }
        k = 0;
      }
    }
    i2 = i1;
    k = j;
    localObject1 = paramFromServiceMsg;
    i1 = m;
    j = i2;
    label145:
    if ((i9 == 1) && (n != 0))
    {
      paramFromServiceMsg = (QQAppInterface)getAppRuntime();
      if (i1 == 0) {
        break label1458;
      }
    }
    for (m = 0;; m = 1)
    {
      for (;;)
      {
        agvn.a(paramFromServiceMsg, 1, m, 1007, i, j, true, MD5.toMD5((String)localObject1));
        if (k != 0) {}
        try
        {
          i = paramIntent.getIntExtra("k_retry", 0);
          if (i < 1)
          {
            paramIntent.putExtra("k_retry", i + 1);
            getAppRuntime().startServlet((NewIntent)paramIntent);
            do
            {
              return;
              localObject4 = (QQAppInterface)getAppRuntime();
            } while (localObject4 == null);
            localagtb = (agtb)((QQAppInterface)localObject4).getManager(341);
            localRespGetConfigByPage = new ConfigurationService.RespGetConfigByPage();
            localRespGetConfigByPage.mergeFrom(paramFromServiceMsg);
            j = localRespGetConfigByPage.result.get();
            m = localRespGetConfigByPage.type.get();
            if (QLog.isColorLevel()) {
              QLog.i("springHb_SpringFestivalRedpacketConfigServlet", 1, String.format("onReceive CMD_GET_CONFIG result=%s type=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(m) }));
            }
            if (j != 0) {
              m = 0;
            }
          }
        }
        catch (Exception paramIntent)
        {
          agtb localagtb;
          ConfigurationService.RespGetConfigByPage localRespGetConfigByPage;
          label674:
          ConfigurationService.PageRespInfo localPageRespInfo;
          Object localObject5;
          boolean bool;
          label1294:
          label1458:
          QLog.e("springHb_SpringFestivalRedpacketConfigServlet", 1, "onReceive fail.", paramIntent);
          return;
        }
        try
        {
          agvn.a(2, 2, 1007, i, k, true, new String[] { j + "" });
          j = 1;
          i1 = k;
          paramFromServiceMsg = (FromServiceMsg)localObject1;
        }
        catch (Throwable paramFromServiceMsg)
        {
          m = 0;
          paramFromServiceMsg = paramFromServiceMsg;
          j = i;
          n = 1;
          i = k;
          k = m;
          m = n;
          break label1294;
        }
      }
      if (m != 1007)
      {
        m = 0;
        agvn.a(2, 2, 1007, i, k, true, new String[] { "type is not 1007" });
        j = 1;
        i1 = k;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        break;
      }
      i7 = paramIntent.getIntExtra("k_req_occasion", 0);
      i8 = paramIntent.getIntExtra("k_version", -1);
      i10 = paramIntent.getIntExtra("k_offset", 0);
      j = ((ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get()).version.get();
      m = ((ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get()).task_id.get();
      i = m;
      n = i4;
      try
      {
        if (QLog.isColorLevel())
        {
          n = i4;
          QLog.i("springHb_SpringFestivalRedpacketConfigServlet", 1, String.format("onReceive CMD_GET_CONFIG reqOccasion=%s reqVersion=%s reqOffset=%s, rspVersion=%s, rspTaskId=%s", new Object[] { Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i10), Integer.valueOf(j), Integer.valueOf(i) }));
        }
        if ((i10 != 0) || (i8 != j)) {
          break label1657;
        }
        n = i4;
        if (QLog.isColorLevel())
        {
          n = i4;
          QLog.i("springHb_SpringFestivalRedpacketConfigServlet", 1, "onReceive CMD_GET_CONFIG no config need update.");
        }
        i1 = 0;
        n = i4;
        m = i6;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        k = i1;
        if (localagtb.a(false, j, i, null, null, i7)) {
          break label1643;
        }
        n = i4;
        agvn.a(2, 4, 1007, i, j, true, new String[0]);
        m = i6;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        k = i1;
      }
      catch (Throwable paramFromServiceMsg)
      {
        i1 = j;
        m = i2;
        k = n;
        j = i;
        i = i1;
      }
      n = i4;
      localPageRespInfo = (ConfigurationService.PageRespInfo)localRespGetConfigByPage.page_info.get();
      n = i4;
      paramFromServiceMsg = paramIntent.getByteArrayExtra("k_buff");
      n = i4;
      localObject4 = localRespGetConfigByPage.content.get().toByteArray();
      if (paramFromServiceMsg == null) {
        break label1709;
      }
      n = i4;
      k = paramFromServiceMsg.length;
      n = i4;
      localObject5 = new ByteArrayBuffer(k + localObject4.length);
      if (paramFromServiceMsg != null)
      {
        n = i4;
        ((ByteArrayBuffer)localObject5).append(paramFromServiceMsg, 0, paramFromServiceMsg.length);
      }
      n = i4;
      ((ByteArrayBuffer)localObject5).append((byte[])localObject4, 0, localObject4.length);
      n = i4;
      localObject4 = ((ByteArrayBuffer)localObject5).buffer();
      n = i4;
      k = localPageRespInfo.next_offset.get();
      if (k == -1)
      {
        n = i4;
        if (QLog.isColorLevel())
        {
          n = i4;
          QLog.i("springHb_SpringFestivalRedpacketConfigServlet", 1, "onReceive CMD_GET_CONFIG no more config to request.");
        }
        n = i4;
        paramFromServiceMsg = localPageRespInfo.md5.get();
        n = i4;
        localObject5 = attn.a((byte[])localObject4);
        n = i4;
        k = localPageRespInfo.total_size.get();
        n = i4;
        if ((localObject4.length == 0) || (k == 0))
        {
          n = i4;
          if (QLog.isColorLevel())
          {
            n = i4;
            QLog.i("springHb_SpringFestivalRedpacketConfigServlet", 1, "onReceive CMD_GET_CONFIG remote config was cleaned.");
          }
          n = i4;
          localagtb.a(true, j, i, null, null, i7);
          k = 0;
          paramFromServiceMsg = "";
          m = i3;
          break label1706;
        }
        if (k > 0)
        {
          n = i4;
          if (TextUtils.equals((CharSequence)localObject5, paramFromServiceMsg))
          {
            n = i4;
            if (QLog.isColorLevel())
            {
              n = i4;
              QLog.i("springHb_SpringFestivalRedpacketConfigServlet", 1, "onReceive CMD_GET_CONFIG get new config.");
            }
            paramFromServiceMsg = (FromServiceMsg)localObject4;
            n = i4;
            if (localPageRespInfo.compress.get() == 1)
            {
              n = i4;
              paramFromServiceMsg = a((byte[])localObject4);
            }
            if (paramFromServiceMsg != null)
            {
              localObject4 = null;
              n = i4;
              if (localRespGetConfigByPage.delay_time.has())
              {
                n = i4;
                localObject4 = (ArrayList)localRespGetConfigByPage.delay_time.get();
              }
              n = i4;
              paramFromServiceMsg = new String(paramFromServiceMsg, "utf-8");
            }
          }
        }
      }
      try
      {
        bool = localagtb.a(true, j, i, paramFromServiceMsg, (List)localObject4, i7);
        if (bool) {
          break label1637;
        }
        k = 0;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          localObject4 = paramFromServiceMsg;
          k = i;
          paramFromServiceMsg = localThrowable1;
          i = j;
          j = k;
          k = i1;
          Object localObject2 = localObject4;
          m = i2;
        }
      }
      try
      {
        agvn.a(2, 4, 1007, i, j, true, new String[0]);
        m = k;
        k = 1;
      }
      catch (Throwable localThrowable2)
      {
        localObject4 = paramFromServiceMsg;
        k = i;
        m = 0;
        paramFromServiceMsg = localThrowable2;
        i = j;
        j = k;
        k = m;
        localObject3 = localObject4;
        m = i2;
        break label1294;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.w("springHb_SpringFestivalRedpacketConfigServlet", 1, "onReceive CMD_GET_CONFIG config inflate fail.");
        }
        agvn.a(2, 3, 1007, i, j, true, new String[0]);
        paramFromServiceMsg = "";
        m = 0;
        k = 1;
      }
      catch (Throwable paramFromServiceMsg)
      {
        k = i;
        m = 0;
        i = j;
        j = k;
        k = m;
        m = i2;
        break label1294;
        j = k;
        i1 = m;
        n = i8;
        k = i7;
      }
      if (QLog.isColorLevel()) {
        QLog.w("springHb_SpringFestivalRedpacketConfigServlet", 1, "onReceive CMD_GET_CONFIG config in package invalid?");
      }
      agvn.a(2, 2, 1007, i, j, true, new String[] { "config in package invalid" });
      paramFromServiceMsg = "";
      m = 0;
      k = 1;
      break label1706;
      if (k != 0)
      {
        n = i4;
        if (QLog.isColorLevel())
        {
          n = i4;
          QLog.i("springHb_SpringFestivalRedpacketConfigServlet", 1, "onReceive CMD_GET_CONFIG request more config.");
        }
        n = i4;
        localagtb.a(i7, j, k, localPageRespInfo.task_id.get(), localPageRespInfo.cookies.get().toByteArray(), (byte[])localObject4);
        return;
        QLog.e("springHb_SpringFestivalRedpacketConfigServlet", 1, "onReceive fail.", paramFromServiceMsg);
        i2 = 0;
        agvn.a(2, 2, 1007, paramIntent.getIntExtra("k_id", 0), paramIntent.getIntExtra("k_version", 0), true, new String[] { QLog.getStackTraceString(paramFromServiceMsg) });
        n = i;
        i = j;
        j = n;
        i1 = k;
        n = i2;
        k = m;
        break label145;
      }
      m = 0;
      k = 0;
      n = k;
      if (QLog.isColorLevel())
      {
        n = k;
        QLog.w("springHb_SpringFestivalRedpacketConfigServlet", 1, "onReceive CMD_GET_CONFIG some thing wrong?");
      }
      n = k;
      agvn.a(2, 2, 1007, i, j, true, new String[] { "onReceive CMD_GET_CONFIG some thing wrong" });
      paramFromServiceMsg = (FromServiceMsg)localObject1;
      k = i5;
      break label1643;
      if (i9 != 1) {
        break label1618;
      }
      i2 = 1;
      n = 0;
      j = k;
      i1 = m;
      k = i2;
      break label145;
    }
    a(paramIntent);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = null;
    int i = paramIntent.getIntExtra("k_cmd", -1);
    int j = paramIntent.getIntExtra("k_retry", 0);
    boolean bool = paramIntent.getBooleanExtra("k_new_page", false);
    QLog.i("springHb_SpringFestivalRedpacketConfigServlet", 2, String.format("onSend cmd=%s retry=%s newPage=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) }));
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((j == 0) || (bool)) {
      switch (i)
      {
      default: 
        localObject2 = null;
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (localObject2 != null)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (!bool)
          {
            paramIntent.putExtra("k_sso_id", (String)localObject2);
            paramIntent.putExtra("k_sso_data", (byte[])localObject1);
            localObject4 = localObject2;
            localObject3 = localObject1;
          }
        }
        break;
      }
    }
    for (;;)
    {
      if ((localObject4 != null) && (localObject3 != null))
      {
        paramPacket.setSSOCommand((String)localObject4);
        paramPacket.putSendData((byte[])localObject3);
      }
      return;
      i = paramIntent.getIntExtra("k_id", 0);
      j = paramIntent.getIntExtra("k_offset", 0);
      int k = paramIntent.getIntExtra("k_version", 0);
      localObject2 = paramIntent.getByteArrayExtra("k_cookie");
      QLog.i("springHb_SpringFestivalRedpacketConfigServlet", 1, String.format("onSend CMD_GET_CONFIG taskId=%s offset=%s version=%s cookie=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Arrays.toString((byte[])localObject2) }));
      localObject1 = new ConfigurationService.PageReqInfo();
      ((ConfigurationService.PageReqInfo)localObject1).task_id.set(i);
      ((ConfigurationService.PageReqInfo)localObject1).offset.set(j);
      ((ConfigurationService.PageReqInfo)localObject1).version.set(k);
      if (localObject2 != null) {
        ((ConfigurationService.PageReqInfo)localObject1).cookies.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      localObject3 = new ConfigurationService.Screen();
      ((ConfigurationService.Screen)localObject3).setHasFlag(true);
      ((ConfigurationService.Screen)localObject3).model.set("");
      ((ConfigurationService.Screen)localObject3).width.set((int)babp.g());
      ((ConfigurationService.Screen)localObject3).height.set((int)babp.h());
      ((ConfigurationService.Screen)localObject3).dpi.set(babp.d());
      ((ConfigurationService.Screen)localObject3).multi_touch.set(babp.c());
      localObject2 = new ConfigurationService.DeviceInfo();
      ((ConfigurationService.DeviceInfo)localObject2).setHasFlag(true);
      ((ConfigurationService.DeviceInfo)localObject2).screen = ((ConfigurationService.Screen)localObject3);
      localObject3 = new ConfigurationService.ReqGetConfigByPage();
      ((ConfigurationService.ReqGetConfigByPage)localObject3).page_info.set((MessageMicro)localObject1);
      ((ConfigurationService.ReqGetConfigByPage)localObject3).device_info.set((MessageMicro)localObject2);
      ((ConfigurationService.ReqGetConfigByPage)localObject3).type.set(1007);
      localObject2 = "ConfigurationService.ReqGetConfigByPage";
      localObject1 = bakc.a(((ConfigurationService.ReqGetConfigByPage)localObject3).toByteArray());
      break;
      localObject4 = paramIntent.getStringExtra("k_sso_id");
      localObject3 = paramIntent.getByteArrayExtra("k_sso_data");
      paramIntent.putExtra("k_new_page", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agte
 * JD-Core Version:    0.7.0.1
 */