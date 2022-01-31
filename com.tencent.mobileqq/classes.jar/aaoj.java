import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.turingfd.sdk.xq.ITuringDID;
import com.tencent.turingfd.sdk.xq.TuringDIDConfig;
import com.tencent.turingfd.sdk.xq.TuringDIDConfig.Builder;
import com.tencent.turingfd.sdk.xq.TuringDIDService;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class aaoj
{
  private volatile Set<String> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  
  public static aaoj a()
  {
    return aaol.a();
  }
  
  private aaom a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!azot.b())
    {
      aanp.a("GdtAidHelper", "only arm support taid");
      return new aaom("", "", -2147483647, 0L, null);
    }
    boolean bool = false;
    aanp.a("GdtAidHelper", "getAidTicket start , businessId -> " + paramString + ", useCache -> " + paramBoolean1 + ", needVerifyBusinessId -> " + paramBoolean2 + "， TuringVersion : " + TuringDIDService.getVersionInfo());
    if (paramBoolean2) {
      bool = a(paramString);
    }
    paramString = BaseApplicationImpl.getContext().getApplicationContext();
    if (!this.jdField_a_of_type_Boolean) {
      aanp.a("GdtAidHelper", "getAidTicket init TuringSDK");
    }
    int j;
    long l;
    for (;;)
    {
      try
      {
        TuringDIDService.init(TuringDIDConfig.newBuilder(paramString).appid("1109803375").build());
        this.jdField_a_of_type_Boolean = true;
        if (paramBoolean1) {}
        String str1;
        String str2;
        paramString = TuringDIDService.getTuringDID(paramString);
      }
      catch (Throwable paramString)
      {
        try
        {
          paramString = TuringDIDService.getTuringDIDCached(paramString);
          j = paramString.getErrorCode();
          l = paramString.getExpiredTimestamp();
          if ((!paramBoolean2) || (j != 0)) {
            break label373;
          }
          i = 1;
          if (i == 0) {
            break;
          }
          azmj.b(null, "dc00898", "", "", "0X800A5B3", "0X800A5B3", 0, 0, "", "", "", "");
          str1 = paramString.getAIDTicket();
          str2 = paramString.getTAIDTicket();
          aanp.a("GdtAidHelper", "getAidTicket aid ticket ->" + str1 + ", taidTicket -> " + str2);
          return new aaom(paramString.getAIDTicket(), paramString.getTAIDTicket(), 0, l, null);
        }
        catch (Throwable paramString)
        {
          QLog.e("GdtAidHelper", 1, paramString, new Object[] { "Turing get aid crash" + TuringDIDService.getVersionInfo() });
          return new aaom("", "", -2147483645, 0L, paramString, null);
        }
        paramString = paramString;
        QLog.e("GdtAidHelper", 1, paramString, new Object[] { "Turing init crash fail" });
        return new aaom("", "", -2147483646, 0L, paramString, null);
      }
      continue;
      label373:
      i = 0;
    }
    int i = j;
    if (paramBoolean2)
    {
      i = j;
      if (!bool) {
        i = -2147483648;
      }
    }
    aanp.a("GdtAidHelper", "getAidTicket business id not verify, error code return only : error code-> " + i);
    return new aaom("", "", i, l, null);
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {}
    for (;;)
    {
      int i;
      try
      {
        HashSet localHashSet;
        if (this.jdField_a_of_type_JavaUtilSet == null) {
          localHashSet = new HashSet();
        }
        try
        {
          InputStream localInputStream = BaseApplicationImpl.getContext().getResources().getAssets().open("AidAuthorityFile.xml");
          localXmlPullParser = Xml.newPullParser();
          localXmlPullParser.setInput(localInputStream, "utf-8");
          i = localXmlPullParser.getEventType();
        }
        catch (IOException localIOException)
        {
          XmlPullParser localXmlPullParser;
          String str;
          localIOException.printStackTrace();
          this.jdField_a_of_type_JavaUtilSet = localHashSet;
          if ((this.jdField_a_of_type_JavaUtilSet == null) || (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
            break label228;
          }
          bool = true;
          if (bool) {
            continue;
          }
          azlr.a("GdtAidHelper", "business id verify fail, please check the business id");
          return bool;
          localIOException.close();
          continue;
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          localXmlPullParserException.printStackTrace();
          continue;
        }
        i = localXmlPullParser.next();
        break label233;
        if (!localXmlPullParser.getName().equalsIgnoreCase("business")) {
          continue;
        }
        str = localXmlPullParser.getAttributeValue(null, "id");
        localHashSet.add(str);
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("GdtAidHelper", 4, "init sensitive au, busiId = " + str);
        continue;
        boolean bool = false;
      }
      finally {}
      label228:
      continue;
      label233:
      if (i != 1) {
        switch (i)
        {
        }
      }
    }
  }
  
  public aaom a()
  {
    return a("", false, false);
  }
  
  aaom a(String paramString)
  {
    return a(paramString, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaoj
 * JD-Core Version:    0.7.0.1
 */