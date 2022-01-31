import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class aegr
  implements Runnable
{
  aegr(aegp paramaegp, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new File(this.jdField_a_of_type_JavaLangString);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int i = 0;
        for (;;)
        {
          if (i < localObject1.length)
          {
            Object localObject2 = localObject1[i].getName();
            String str = this.jdField_a_of_type_JavaLangString + (String)localObject2;
            localObject2 = localObject2.split("\\.")[0];
            Object localObject3 = new SimpleDateFormat("yyyyMMddHHmmssSS");
            try
            {
              localObject2 = ((SimpleDateFormat)localObject3).parse((String)localObject2);
              localObject3 = Calendar.getInstance();
              ((Calendar)localObject3).set(11, 0);
              ((Calendar)localObject3).set(13, 0);
              ((Calendar)localObject3).set(12, 0);
              ((Calendar)localObject3).set(14, 0);
              if (((Date)localObject2).before(((Calendar)localObject3).getTime()))
              {
                localObject1[i].delete();
                SharePreferenceUtils.a(this.jdField_a_of_type_Aegp.a, str);
              }
              i += 1;
            }
            catch (ParseException localParseException)
            {
              for (;;)
              {
                localParseException.printStackTrace();
              }
            }
          }
        }
      }
      long l = System.currentTimeMillis();
      localObject1 = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
      SharePreferenceUtils.a(this.jdField_a_of_type_Aegp.a, "LAST_DELETE_TIME", (String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegr
 * JD-Core Version:    0.7.0.1
 */