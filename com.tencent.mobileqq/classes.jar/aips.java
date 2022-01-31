import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransFileController.ProcHandler;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.base.ShareProcessorUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

class aips
  implements Runnable
{
  aips(aipr paramaipr) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "ImageUploadStep|run|retry=" + aipr.a(this.a));
    }
    if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.a.f();
      return;
    }
    String str3 = this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    int i;
    byte b1;
    if ((!TextUtils.isEmpty(ForwardSdkShareProcessor.b(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor))) && (TextUtils.isEmpty(ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor))))
    {
      i = 1;
      if (i == 0) {
        break label206;
      }
      b1 = 2;
    }
    String str2;
    Object localObject1;
    label206:
    Object localObject3;
    long l1;
    Object localObject4;
    label364:
    boolean bool2;
    label513:
    boolean bool1;
    label624:
    int j;
    for (;;)
    {
      if (i != 0)
      {
        str2 = ForwardSdkShareProcessor.b(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor);
        localObject1 = new CompressInfo(str2, 0);
        ((CompressInfo)localObject1).f = 0;
        CompressOperator.b((CompressInfo)localObject1);
        if (!TextUtils.isEmpty(((CompressInfo)localObject1).e)) {
          ForwardSdkShareProcessor.e(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor, ((CompressInfo)localObject1).e);
        }
        if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          this.a.f();
          return;
          i = 0;
          break;
          b1 = 4;
          continue;
        }
        long l2 = System.currentTimeMillis();
        localObject3 = null;
        localObject1 = new File(ForwardSdkShareProcessor.b(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
        if (((File)localObject1).exists())
        {
          l1 = ((File)localObject1).length();
          localObject4 = FileUtils.b(ForwardSdkShareProcessor.b(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
          localObject1 = localObject3;
          if (l1 > 0L)
          {
            localObject1 = localObject3;
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = HttpUtil.a(ShareProcessorUtil.a(String.format("http://cgi.connect.qq.com/qqconnectopen/query_share_image?key=%s&size=%d", new Object[] { localObject4, Long.valueOf(l1) }), 1007), str3, ForwardSdkShareProcessor.f(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
            }
          }
          l1 = System.currentTimeMillis() - l2;
          if (localObject1 != null) {
            break label2364;
          }
          localObject1 = new Pair(Integer.valueOf(-1), "");
          if (QLog.isColorLevel()) {
            QLog.d("Q.share.ForwardSdkShareProcessor", 2, "ImageUploadStep|queryImage|ret=" + ((Pair)localObject1).first + ",cost=" + l1 + ",url=" + (String)((Pair)localObject1).second);
          }
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("report_type", "102");
          ((Bundle)localObject3).putString("act_type", "16");
          ((Bundle)localObject3).putString("intext_1", "" + ((Pair)localObject1).first);
          localObject4 = new StringBuilder().append("");
          if (((Integer)((Pair)localObject1).first).intValue() != -1) {
            break label1217;
          }
          i = 0;
          ((Bundle)localObject3).putString("intext_2", i);
          ((Bundle)localObject3).putString("intext_5", "" + l1);
          ReportCenter.a().a((Bundle)localObject3, "", str3, false);
          bool2 = false;
          if (TextUtils.isEmpty((CharSequence)((Pair)localObject1).second)) {
            break label1232;
          }
          bool1 = true;
          ForwardSdkShareProcessor.c(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor, (String)((Pair)localObject1).second);
          ForwardSdkShareProcessor.b(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).set(true);
          i = 0;
          l1 = System.currentTimeMillis() - l2;
          if (QLog.isColorLevel())
          {
            localObject1 = "ImageUploadStep|uploadImage|suc=" + bool1 + ",cost=" + l1 + ",localImgUrl=" + ForwardSdkShareProcessor.b(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor) + ",targetUrl=" + ForwardSdkShareProcessor.e(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor);
            if ((bool1) && (l1 <= 5000L)) {
              break label1673;
            }
            QLog.e("Q.share.ForwardSdkShareProcessor", 2, (String)localObject1);
          }
          label728:
          if (!bool1) {
            QLog.e("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|uploadImage|ret=" + i + ",retry=" + aipr.a(this.a));
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("report_type", "102");
          ((Bundle)localObject1).putString("act_type", "11");
          localObject3 = new StringBuilder().append("");
          if (!bool1) {
            break label1684;
          }
          j = 0;
          ((Bundle)localObject1).putString("intext_1", j);
          ((Bundle)localObject1).putString("intext_2", "" + i);
          ((Bundle)localObject1).putString("intext_3", "0");
          ((Bundle)localObject1).putString("intext_5", "" + l1);
          if (!bool1)
          {
            ((Bundle)localObject1).putString("stringext_2", ForwardSdkShareProcessor.b(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
            ((Bundle)localObject1).putString("stringext_1", ForwardSdkShareProcessor.e(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
          }
          ReportCenter.a().a((Bundle)localObject1, "", str3, false);
          if (!bool1) {
            break label1735;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          localObject1 = new File(str2).toURL().toString();
          ShareProcessorUtil.a(true, (String)localObject1, ForwardSdkShareProcessor.b(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor), ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
          b2 = 1;
          localObject1 = this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          if ((localObject1 != null) && ((localObject1 instanceof MessageForStructing)) && ((((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg)))
          {
            localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
            ((AbsShareMsg)localObject1).updateCover(ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
            ((AbsShareMsg)localObject1).shareData.imageUrlStatus = b2;
            this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long, ((AbsShareMsg)localObject1).getBytes());
          }
          ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).set(true);
          this.a.b();
          return;
          l1 = 0L;
          break;
          label1217:
          i = ((Integer)((Pair)localObject1).first).intValue();
          break label513;
          label1232:
          if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            this.a.f();
            return;
          }
          localObject4 = new HashMap();
          ((Map)localObject4).put("Connection", "keep-alive");
          ((Map)localObject4).put("Referer", "http://www.qq.com");
          ((Map)localObject4).put("Host", "cgi.connect.qq.com");
          localObject1 = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getPskey(str3, "cgi.connect.qq.com");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((Map)localObject4).put("Cookie", "p_uin=" + str3 + ";p_skey=" + (String)localObject1);
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("share_image", ForwardSdkShareProcessor.b(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("report_type", "102");
          ((Bundle)localObject1).putString("act_type", "51");
          ((Bundle)localObject1).putString("intext_3", "0");
          ((Bundle)localObject1).putString("stringext_1", ForwardSdkShareProcessor.e(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
          ReportCenter.a().a((Bundle)localObject1, "", str3, false);
          localObject3 = HttpUtil.a(ShareProcessorUtil.a("http://cgi.connect.qq.com/qqconnectopen/upload_share_image", 1007), str3, ForwardSdkShareProcessor.f(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor), null, localHashMap, (Map)localObject4);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = HttpUtil.a("http://cgi.connect.qq.com/qqconnectopen/upload_share_image", str3, ForwardSdkShareProcessor.f(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor), null, localHashMap, (Map)localObject4);
          }
          if (localObject1 == null) {
            break label2355;
          }
          try
          {
            localObject1 = new JSONObject((String)localObject1);
            i = ((JSONObject)localObject1).getInt("retcode");
            if (i != 0) {
              break label2349;
            }
          }
          catch (JSONException localJSONException1)
          {
            try
            {
              if (!((JSONObject)localObject1).has("result")) {
                break label2349;
              }
              localObject1 = ((JSONObject)localObject1).getJSONObject("result");
              ForwardSdkShareProcessor.c(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor, ((JSONObject)localObject1).getString("url"));
              ForwardSdkShareProcessor.b(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).set(true);
              bool1 = true;
            }
            catch (JSONException localJSONException2)
            {
              for (;;)
              {
                Object localObject2;
                j = i;
              }
            }
            localJSONException1 = localJSONException1;
            j = 0;
          }
        }
        i = j;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break label624;
        }
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, localJSONException1.getMessage());
        i = j;
        bool1 = bool2;
        break label624;
        label1673:
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, localJSONException1);
        break label728;
        label1684:
        j = 1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.share.ForwardSdkShareProcessor", 2, "srcPath to URL err:" + localMalformedURLException.getMessage());
        }
        localObject2 = str2;
        continue;
      }
      label1735:
      if ((i == 100000) && (ForwardSdkShareProcessor.c(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor) < 2))
      {
        ForwardSdkShareProcessor.d(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor);
        ForwardSdkShareProcessor.d(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor, null);
        ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor, true);
        ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor);
        return;
      }
      if (aipr.b(this.a) < 2)
      {
        ThreadManager.post(this, 8, null, true);
        return;
      }
      this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.b(9402, "upload share thumbnail fail");
      this.a.c();
      return;
      byte b2 = b1;
      if (!TextUtils.isEmpty(ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor)))
      {
        try
        {
          l1 = System.currentTimeMillis();
          localObject2 = ShareProcessorUtil.a(ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor), str3);
          i = ((Integer)localObject2[0]).intValue();
          bool1 = ((Boolean)localObject2[1]).booleanValue();
          str2 = (String)localObject2[2];
          l1 = System.currentTimeMillis() - l1;
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.share.ForwardSdkShareProcessor", 4, "ImageUploadStep|changeImgUrl,ret=" + i + ",needRich=" + bool1 + ",url=" + str2 + ",cost=" + l1);
          }
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("report_type", "102");
          ((Bundle)localObject3).putString("act_type", "19");
          ((Bundle)localObject3).putString("intext_1", "" + i);
          if (bool1)
          {
            localObject2 = "1";
            label2053:
            ((Bundle)localObject3).putString("intext_2", (String)localObject2);
            ((Bundle)localObject3).putString("intext_3", "1");
            ((Bundle)localObject3).putString("intext_5", "" + l1);
            ((Bundle)localObject3).putString("stringext_2", ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
            ReportCenter.a().a((Bundle)localObject3, "", this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
            if ((!bool1) || (ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor) == null) || (ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).a)) {
              break label2257;
            }
            this.a.f();
            this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new aipt(this));
          }
        }
        catch (Exception localException1) {}
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.share.ForwardSdkShareProcessor", 2, "ImageUploadStep|changeImgUrl,err=" + localException1);
          }
          b2 = b1;
          break;
          String str1 = "0";
          break label2053;
          label2257:
          if (i == -1) {
            break label2346;
          }
          b1 = 3;
          if (i == 0) {}
          try
          {
            if (!TextUtils.isEmpty(str2))
            {
              ShareProcessorUtil.a(false, ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor), ForwardSdkShareProcessor.a(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor), str2);
              ForwardSdkShareProcessor.c(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor, str2);
            }
            else
            {
              ForwardSdkShareProcessor.c(this.a.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor, null);
            }
          }
          catch (Exception localException2) {}
        }
        label2346:
        label2349:
        bool1 = false;
        continue;
        label2355:
        i = 0;
        bool1 = bool2;
        break label624;
        label2364:
        break label364;
        b2 = b1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aips
 * JD-Core Version:    0.7.0.1
 */