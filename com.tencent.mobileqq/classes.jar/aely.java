import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import java.util.HashMap;

public class aely
  extends aelu
{
  public static String[] a;
  public int a;
  public Bitmap a;
  public AnimationView.AnimationInfo a;
  public HashMap<String, Bitmap> a;
  public String b;
  public String c;
  public String d;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "icon_def", "icon_txt", "icon_voice", "icon_video", "icon_sp" };
  }
  
  public aely(String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public Bitmap a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    Object localObject;
    if (paramRedPacketInfo == null)
    {
      localObject = null;
      return localObject;
    }
    if ((paramRedPacketInfo.a instanceof MessageForQQWalletMsg))
    {
      paramRedPacketInfo = (MessageForQQWalletMsg)paramRedPacketInfo.a;
      if (paramRedPacketInfo.messageType == 6) {
        paramRedPacketInfo = "icon_txt";
      }
    }
    for (;;)
    {
      label38:
      if (paramRedPacketInfo != null) {}
      for (paramRedPacketInfo = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramRedPacketInfo);; paramRedPacketInfo = null)
      {
        localObject = paramRedPacketInfo;
        if (paramRedPacketInfo != null) {
          break;
        }
        return (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get("icon_def");
        if (paramRedPacketInfo.messageType == 14)
        {
          paramRedPacketInfo = "icon_video";
          break label38;
        }
        if ((paramRedPacketInfo.messageType == 13) || (paramRedPacketInfo.messageType == 15))
        {
          paramRedPacketInfo = "icon_voice";
          break label38;
        }
        if (paramRedPacketInfo.messageType == 18)
        {
          paramRedPacketInfo = "icon_ksong";
          break label38;
        }
        if (paramRedPacketInfo.messageType == 19)
        {
          paramRedPacketInfo = "icon_emoji";
          break label38;
        }
        if (paramRedPacketInfo.messageType == 22)
        {
          paramRedPacketInfo = "icon_draw";
          break label38;
        }
        if ((paramRedPacketInfo.messageType != 7) && (paramRedPacketInfo.messageType != 8) && (paramRedPacketInfo.messageType != 11) && (paramRedPacketInfo.messageType != 12) && (paramRedPacketInfo.messageType != 23)) {
          break label213;
        }
        paramRedPacketInfo = "icon_sp";
        break label38;
      }
      label213:
      paramRedPacketInfo = null;
    }
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.b = paramRedPacketInfo.background;
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramRedPacketInfo.corner;
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo = paramRedPacketInfo.animInfo;
      this.c = paramRedPacketInfo.title;
      this.jdField_a_of_type_Int = paramRedPacketInfo.isHideTitle;
      this.d = paramRedPacketInfo.resPath;
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (paramRedPacketInfo.attribute.containsKey(str))
        {
          Bitmap localBitmap = (Bitmap)paramRedPacketInfo.attribute.getParcelable(str);
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localBitmap);
        }
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    return (this.b != null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aely
 * JD-Core Version:    0.7.0.1
 */