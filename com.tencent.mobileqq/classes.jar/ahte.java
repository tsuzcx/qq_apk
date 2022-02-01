import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;
import cooperation.comic.VipComicJumpActivity;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public class ahte
  extends ahsd
  implements bkjj
{
  private ahui jdField_a_of_type_Ahui;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  Button b;
  Button c;
  Button d;
  TextView f;
  TextView g;
  private TextView h;
  boolean v = false;
  
  public ahte(Activity paramActivity, abfp paramabfp, ahul paramahul, String paramString)
  {
    super(paramActivity, paramabfp, paramahul, paramString);
  }
  
  private void I()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "cancleProgressDailog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
        this.jdField_a_of_type_AndroidAppProgressDialog = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static int a(String[] paramArrayOfString)
  {
    int j = 0;
    int i = j;
    if (paramArrayOfString != null)
    {
      i = j;
      if (paramArrayOfString.length >= 8)
      {
        j = 1;
        if (paramArrayOfString[7].equals("link")) {}
        do
        {
          return 3;
          i = j;
          if (paramArrayOfString.length < 9) {
            break;
          }
          i = j;
          if (!paramArrayOfString[7].equals("scrawl_link")) {
            break;
          }
          paramArrayOfString = paramArrayOfString[8];
          i = j;
          if (TextUtils.isEmpty(paramArrayOfString)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("AIOImageData", 2, "name = " + paramArrayOfString + " , name.length = " + paramArrayOfString.length());
          }
          i = j;
          if (paramArrayOfString.startsWith("upload")) {
            break;
          }
        } while (paramArrayOfString.trim().length() <= 32);
        i = j;
      }
    }
    return i;
  }
  
  public static String a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg != null) && ((paramChatMessage.structingMsg instanceof StructMsgForImageShare))) {
        return a((StructMsgForImageShare)paramChatMessage.structingMsg);
      }
    }
    return null;
  }
  
  public static String a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramStructMsgForImageShare != null)
    {
      if (!a(paramStructMsgForImageShare.mMsgActionData)) {
        break label70;
      }
      if ((TextUtils.isEmpty(paramStructMsgForImageShare.mMsg_A_ActionData)) || (paramStructMsgForImageShare.mMsg_A_ActionData.indexOf("|") <= 0)) {
        break label65;
      }
      localObject1 = "comic_plugin.apk|" + paramStructMsgForImageShare.mMsg_A_ActionData;
    }
    label65:
    label70:
    do
    {
      return localObject1;
      return paramStructMsgForImageShare.mMsgActionData;
      localObject1 = localObject2;
    } while (!b(paramStructMsgForImageShare.mMsgActionData));
    return paramStructMsgForImageShare.mMsgActionData;
  }
  
  public static String a(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (a(paramString))
    {
      paramString = paramString.substring(paramString.indexOf("|") + 1).split("\\|");
      str1 = str2;
      if (paramString.length >= 8)
      {
        if (!paramString[7].equals("link")) {
          break label57;
        }
        str1 = paramString[4];
      }
    }
    label57:
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (!paramString[7].equals("scrawl_link"));
      str1 = str2;
    } while (paramString.length < 9);
    return paramString[8];
  }
  
  private void a(ahui paramahui, AIOImageData paramAIOImageData, boolean paramBoolean)
  {
    StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)bcwd.a((byte[])paramAIOImageData.a);
    String[] arrayOfString = a(localStructMsgForImageShare);
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    paramAIOImageData = localObject2;
    if (arrayOfString != null)
    {
      localObject1 = localObject3;
      paramAIOImageData = localObject2;
      if (arrayOfString.length >= 8)
      {
        paramAIOImageData = arrayOfString[1];
        localObject1 = arrayOfString[3] + anni.a(2131698870) + arrayOfString[5] + anni.a(2131698885);
        if ((paramAIOImageData == null) || (paramAIOImageData.length() < 7)) {
          break label405;
        }
        paramAIOImageData = paramAIOImageData.substring(0, 6) + "...";
      }
    }
    label385:
    label405:
    for (;;)
    {
      if (!this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramahui.hashCode())))
      {
        blaq.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "3008", "1", "30004", arrayOfString[0], new String[] { arrayOfString[2], arrayOfString[4], a(localStructMsgForImageShare.mMsgActionData) });
        this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramahui.hashCode()));
      }
      if (TextUtils.isEmpty(paramAIOImageData))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label385;
        }
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
      for (;;)
      {
        if (this.f != null) {
          this.f.setText(anni.a(2131698845));
        }
        if ((arrayOfString != null) && (arrayOfString.length >= 8) && (this.f != null)) {
          this.f.setVisibility(0);
        }
        this.jdField_a_of_type_AndroidViewView.invalidate();
        this.jdField_a_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare);
        this.jdField_b_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare);
        this.c.setTag(localStructMsgForImageShare);
        if (paramBoolean)
        {
          this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setText(paramAIOImageData);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        break;
        this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      }
    }
  }
  
  private void a(Context paramContext, String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        I();
      }
      for (;;)
      {
        this.h.setText(paramString);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(paramContext, 2131755823);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.getWindow().setDimAmount(0.0F);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559567);
        this.h = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372466));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachineQQBrowserActivity", 2, "showProgressDialog error " + paramContext.getMessage());
      }
    }
  }
  
  private void a(AIOImageData paramAIOImageData)
  {
    paramAIOImageData = (StructMsgForImageShare)bcwd.a((byte[])paramAIOImageData.a);
    b(paramAIOImageData);
    Object localObject2 = b(paramAIOImageData.mMsgActionData);
    if ((localObject2 != null) && (localObject2.length > 2))
    {
      paramAIOImageData = "";
      localObject1 = Uri.parse(localObject2[1]);
    }
    try
    {
      localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
      paramAIOImageData = (AIOImageData)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    Object localObject1 = paramAIOImageData;
    if (paramAIOImageData == null) {
      localObject1 = "";
    }
    paramAIOImageData = "";
    if (localObject2.length > 3)
    {
      localObject2 = localObject2[3];
      if (localObject2 != null)
      {
        paramAIOImageData = (AIOImageData)localObject2;
        if (((String)localObject2).equals("1")) {}
      }
      else
      {
        paramAIOImageData = "";
      }
    }
    oat.a(null, "", "0X8007130", "0X8007130", 0, 0, (String)localObject1, paramAIOImageData, "", "");
  }
  
  private void a(AIOImageData paramAIOImageData, StructMsgForImageShare paramStructMsgForImageShare)
  {
    Object localObject;
    if (paramAIOImageData.b == 2)
    {
      localObject = b(paramStructMsgForImageShare.mMsgActionData);
      if ((localObject != null) && (localObject.length > 2))
      {
        paramAIOImageData = "";
        paramStructMsgForImageShare = Uri.parse(localObject[1]);
      }
    }
    try
    {
      paramStructMsgForImageShare = paramStructMsgForImageShare.getQueryParameter("article_id");
      paramAIOImageData = paramStructMsgForImageShare;
    }
    catch (Exception paramStructMsgForImageShare)
    {
      for (;;)
      {
        paramStructMsgForImageShare.printStackTrace();
      }
    }
    paramStructMsgForImageShare = paramAIOImageData;
    if (paramAIOImageData == null) {
      paramStructMsgForImageShare = "";
    }
    paramAIOImageData = "";
    if (localObject.length > 3)
    {
      localObject = localObject[3];
      if (localObject != null)
      {
        paramAIOImageData = (AIOImageData)localObject;
        if (((String)localObject).equals("1")) {}
      }
      else
      {
        paramAIOImageData = "";
      }
    }
    oat.a(null, "", "0X8007131", "0X8007131", 0, 0, paramStructMsgForImageShare, paramAIOImageData, "", "");
  }
  
  private void a(AIOImageData paramAIOImageData, boolean paramBoolean1, boolean paramBoolean2)
  {
    StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)bcwd.a((byte[])paramAIOImageData.a);
    String[] arrayOfString = b(localStructMsgForImageShare.mMsgActionData);
    if ((arrayOfString != null) && (arrayOfString.length > 2))
    {
      Object localObject = arrayOfString[2];
      paramAIOImageData = (AIOImageData)localObject;
      if (localObject != null)
      {
        paramAIOImageData = (AIOImageData)localObject;
        if (((String)localObject).length() > 17) {
          paramAIOImageData = ((String)localObject).substring(0, 16) + "...";
        }
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(paramAIOImageData);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      if (paramBoolean1)
      {
        paramAIOImageData = "";
        localObject = Uri.parse(arrayOfString[1]);
      }
      try
      {
        localObject = ((Uri)localObject).getQueryParameter("article_id");
        paramAIOImageData = (AIOImageData)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str;
          localException.printStackTrace();
        }
      }
      localObject = paramAIOImageData;
      if (paramAIOImageData == null) {
        localObject = "";
      }
      paramAIOImageData = "";
      if (arrayOfString.length > 3)
      {
        str = arrayOfString[3];
        if (str != null)
        {
          paramAIOImageData = str;
          if (str.equals("1")) {}
        }
        else
        {
          paramAIOImageData = "";
        }
      }
      oat.a(null, "", "0X8007153", "0X8007153", 0, 0, (String)localObject, paramAIOImageData, "", "");
      oat.a("0X8007153", "", (String)localObject, paramAIOImageData, "", "");
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      if (this.f != null)
      {
        this.f.setText(anni.a(2131698849));
        if ((arrayOfString != null) && (arrayOfString.length > 3))
        {
          paramAIOImageData = arrayOfString[3];
          if ((paramAIOImageData != null) && (paramAIOImageData.equals("1"))) {
            this.f.setText(anni.a(2131698883));
          }
        }
      }
      this.jdField_a_of_type_AndroidViewView.invalidate();
      this.jdField_a_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare);
      this.jdField_b_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare);
      this.c.setTag(localStructMsgForImageShare);
      if (paramBoolean2)
      {
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  private void a(boolean paramBoolean, String[] paramArrayOfString, StructMsgForImageShare paramStructMsgForImageShare, File paramFile)
  {
    if (paramBoolean)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramArrayOfString[7].equals("scrawl_link"))
      {
        localObject1 = localObject2;
        if (paramArrayOfString.length > 8) {
          localObject1 = paramArrayOfString[8];
        }
      }
      String str2 = paramArrayOfString[3] + anni.a(2131698853) + paramArrayOfString[5] + anni.a(2131698865);
      String str1 = "ADTAG=comic.plugin.read&id=" + paramArrayOfString[0] + "&name=" + URLEncoder.encode(paramArrayOfString[1]) + "&sectionID=" + paramArrayOfString[2] + "&sectionName=" + URLEncoder.encode(paramArrayOfString[3]) + "&pageID=" + paramArrayOfString[4] + "&page=" + paramArrayOfString[5] + "&type=" + paramArrayOfString[6];
      localObject2 = str1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = str1 + "&scrawl_link=" + URLEncoder.encode((String)localObject1);
      }
      localObject1 = VipComicJumpActivity.a("comicReadShare", "5123", null, null, "354", null, (String)localObject2);
      new bljl(6).a("nLinkType", 0).b("sTitle", paramArrayOfString[1]).b("sUrl", (String)localObject1).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", paramStructMsgForImageShare.mSourceName).b("sBrief", str2).b("sPath", paramFile.getAbsolutePath()).b("sResUrl", paramStructMsgForImageShare.mSourceUrl).a("lCategory", 1L).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString);
      bljv.a(null, 6, 2);
      if (paramArrayOfString.length < 8) {
        break label453;
      }
      if (!paramArrayOfString[7].equals("link")) {
        break label426;
      }
      paramStructMsgForImageShare = paramArrayOfString[4];
    }
    for (;;)
    {
      blaq.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40058", paramArrayOfString[0], new String[] { "2", "", paramStructMsgForImageShare });
      return;
      label426:
      if ((paramArrayOfString[7].equals("scrawl_link")) && (paramArrayOfString.length >= 9)) {
        paramStructMsgForImageShare = paramArrayOfString[8];
      } else {
        label453:
        paramStructMsgForImageShare = "";
      }
    }
  }
  
  private void a(String[] paramArrayOfString, StructMsgForImageShare paramStructMsgForImageShare)
  {
    String str = paramArrayOfString[1];
    Object localObject = paramArrayOfString[2];
    localObject = paramStructMsgForImageShare.getFirstImageElement();
    if (localObject != null)
    {
      if (((bcxy)localObject).a == null) {
        ((bcxy)localObject).a = paramStructMsgForImageShare;
      }
      AIOImageData localAIOImageData = ahth.a(((bcxy)localObject).a());
      localObject = localAIOImageData.a(4);
      paramStructMsgForImageShare = (StructMsgForImageShare)localObject;
      if (localObject == null) {
        paramStructMsgForImageShare = localAIOImageData.a(2);
      }
      if (paramStructMsgForImageShare != null) {
        paramStructMsgForImageShare.getAbsolutePath();
      }
    }
    bljl.a(str).c(this.jdField_b_of_type_JavaLangString).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString);
    bljv.a(null, 6, 2);
    paramStructMsgForImageShare = "";
    localObject = Uri.parse(paramArrayOfString[1]);
    try
    {
      localObject = ((Uri)localObject).getQueryParameter("article_id");
      paramStructMsgForImageShare = (StructMsgForImageShare)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    localObject = paramStructMsgForImageShare;
    if (paramStructMsgForImageShare == null) {
      localObject = "";
    }
    paramStructMsgForImageShare = "";
    if (paramArrayOfString.length > 3)
    {
      paramArrayOfString = paramArrayOfString[3];
      if (paramArrayOfString != null)
      {
        paramStructMsgForImageShare = paramArrayOfString;
        if (paramArrayOfString.equals("1")) {}
      }
      else
      {
        paramStructMsgForImageShare = "";
      }
    }
    oat.a(null, "", "0X8007132", "0X8007132", 0, 0, (String)localObject, paramStructMsgForImageShare, "", "");
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("comic_plugin.apk"));
  }
  
  public static final String[] a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    int j = 1;
    String[] arrayOfString;
    if ((paramStructMsgForImageShare.mMsgActionData != null) && (paramStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
    {
      arrayOfString = paramStructMsgForImageShare.mMsgActionData.substring(paramStructMsgForImageShare.mMsgActionData.indexOf("|") + 1).split("\\|");
      if ((arrayOfString.length < 8) || ((!arrayOfString[7].equals("link")) && (!arrayOfString[7].equals("scrawl_link")))) {
        break label142;
      }
    }
    label142:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!TextUtils.isEmpty(paramStructMsgForImageShare.mMsg_A_ActionData)))
      {
        paramStructMsgForImageShare = paramStructMsgForImageShare.mMsg_A_ActionData.split("\\|");
        if ((paramStructMsgForImageShare.length >= 8) && (paramStructMsgForImageShare[7].equals("link"))) {
          i = j;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          return paramStructMsgForImageShare;
          i = 0;
        }
        else
        {
          return null;
          paramStructMsgForImageShare = arrayOfString;
        }
      }
    }
  }
  
  public static String[] a(String paramString)
  {
    if (a(paramString)) {
      return paramString.substring(paramString.indexOf("|") + 1).split("\\|");
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (a(paramString))
    {
      paramString = paramString.substring(paramString.indexOf("|") + 1).split("\\|");
      str1 = str2;
      if (paramString.length >= 8) {
        if (!paramString[7].equals("link"))
        {
          str1 = str2;
          if (!paramString[7].equals("scrawl_link")) {}
        }
        else
        {
          str1 = paramString[0];
        }
      }
    }
    return str1;
  }
  
  private void b(StructMsgForImageShare paramStructMsgForImageShare)
  {
    paramStructMsgForImageShare = b(paramStructMsgForImageShare.mMsgActionData);
    if ((paramStructMsgForImageShare != null) && (paramStructMsgForImageShare.length > 2))
    {
      paramStructMsgForImageShare = paramStructMsgForImageShare[1];
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, PublicAccountBrowser.class);
      localIntent.putExtra("uin", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("url", paramStructMsgForImageShare);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
  }
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("ScreenShotShare"));
  }
  
  public static String[] b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.split("\\|");
    }
    return null;
  }
  
  public void F()
  {
    String str;
    if ((this.jdField_a_of_type_Ahtj.b.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) {
      str = "0X8009AB2";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        bcst.b(null, "dc00898", "", "", str, str, this.k, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Abgc.a() == null)
      {
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return;
        if ((this.jdField_a_of_type_Ahtj.b.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)) {
          str = "0X8009AB3";
        }
      }
      else
      {
        this.jdField_a_of_type_Abgc.a();
        return;
      }
      str = null;
    }
  }
  
  public void G()
  {
    if (this.k == 4) {
      return;
    }
    this.jdField_a_of_type_Ahtd.e = false;
    u();
  }
  
  public void H() {}
  
  public ahui a()
  {
    return this.jdField_a_of_type_Ahui;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_d_of_type_AndroidViewView.setAlpha(paramFloat);
    if (paramFloat < 0.8F)
    {
      this.jdField_a_of_type_Ahtd.e = true;
      u();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 19002)
    {
      if (paramInt2 == -1) {
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramIntent);
      }
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 != 19000) {
            break;
          }
        } while (paramInt2 != -1);
        return;
        if (paramInt1 != 19005) {
          break;
        }
      } while (paramInt2 != -1);
      return;
    } while (paramInt1 == 103);
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void a(ahui paramahui, Activity paramActivity, int paramInt)
  {
    int i = 4;
    AIOImageData localAIOImageData;
    File localFile;
    if ((this.k == 1) || (this.k == 2) || (this.k == 3) || (this.k == 5) || (this.k == 6))
    {
      if (!AIOImageData.class.isInstance(paramahui.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        return;
      }
      localAIOImageData = (AIOImageData)paramahui.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      localFile = localAIOImageData.a(4);
      if (localFile != null) {
        break label328;
      }
      localFile = localAIOImageData.a(2);
    }
    label328:
    for (paramInt = 0;; paramInt = 1)
    {
      Bundle localBundle = new Bundle(paramActivity.getIntent().getExtras());
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localAIOImageData.a(1));
      paramahui = paramahui.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (paramInt != 0) {}
      for (;;)
      {
        localBundle.putString("forward_urldrawable_big_url", paramahui.a(i));
        if (localFile == null) {
          break;
        }
        try
        {
          localBundle.putString("forward_filepath", localFile.getAbsolutePath());
          localBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          if (paramInt != 0) {
            localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
          }
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", localAIOImageData);
          localBundle.putBoolean("key_help_forward_pic", true);
          localBundle.putBoolean("key_allow_multiple_forward_from_limit", false);
          paramahui = new Intent();
          paramahui.putExtras(localBundle);
          aufz.a(paramActivity, paramahui, 19005);
          return;
        }
        catch (NullPointerException paramahui) {}
        i = 2;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,cache path is null");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,NullPointerException: " + paramahui);
      return;
      super.a(paramahui, paramActivity, paramInt);
      return;
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    if ((Build.VERSION.SDK_INT >= 21) && (!akws.d()))
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindow().clearFlags(67108864);
      this.jdField_a_of_type_AndroidAppActivity.getWindow().addFlags(-2147483648);
      this.jdField_a_of_type_AndroidAppActivity.getWindow().setStatusBarColor(0);
      this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().setSystemUiVisibility(1280);
    }
    paramViewGroup = (RelativeLayout)a();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131563057, null);
    this.jdField_a_of_type_AndroidViewView.setClickable(true);
    Object localObject = new RelativeLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, 72.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics()));
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131380978));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131380979));
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.c = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131380976));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380980));
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    localObject = new ahtf(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject);
    this.c.setOnClickListener((View.OnClickListener)localObject);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.g = autv.a(this.jdField_a_of_type_AndroidAppActivity, paramViewGroup);
    this.g.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365725));
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
    this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_a_of_type_Ahtj.b.b());
  }
  
  protected void a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (paramStructMsgForImageShare == null) {}
    Object localObject2;
    Object localObject1;
    URLDrawable localURLDrawable;
    label66:
    do
    {
      return;
      localObject2 = paramStructMsgForImageShare.getFirstImageElement();
      if (localObject2 == null) {
        break label369;
      }
      if (((bcxy)localObject2).a == null) {
        ((bcxy)localObject2).a = paramStructMsgForImageShare;
      }
      localObject1 = ((bcxy)localObject2).a();
      localURLDrawable = ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity, (MessageForPic)localObject1);
      if (!new File(((MessageForPic)localObject1).path).exists()) {
        break;
      }
      ((bcxy)localObject2).aa = ((MessageForPic)localObject1).path;
      if (!TextUtils.isEmpty(((bcxy)localObject2).aa)) {
        break label173;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AIOGalleryScene", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement.mShareImageUrl is null!!!");
    return;
    String str = localURLDrawable.getURL().toString();
    if (bdsh.b(str))
    {
      localObject1 = bdsh.a(str);
      if (localObject1 == null) {
        break label419;
      }
      localObject1 = ((File)localObject1).getAbsolutePath();
    }
    for (;;)
    {
      ((bcxy)localObject2).aa = ((String)localObject1);
      break label66;
      localObject1 = bdzx.a((ayye)localObject1, 65537);
      if (localObject1 != null)
      {
        localObject1 = bdsh.a(((URL)localObject1).toString());
        if ((localObject1 != null) && (((File)localObject1).exists()))
        {
          localObject1 = ((File)localObject1).getAbsolutePath();
          continue;
          label173:
          if (!bdsh.b(localURLDrawable.getURL().toString())) {
            localURLDrawable.startDownload();
          }
          localObject1 = new Bundle();
          if ((paramStructMsgForImageShare.source_puin != null) && (!"".equals(paramStructMsgForImageShare.source_puin))) {
            ((Bundle)localObject1).putString("source_puin", paramStructMsgForImageShare.source_puin);
          }
          ((Bundle)localObject1).putInt("forward_type", -3);
          paramStructMsgForImageShare.mCommentText = null;
          ((Bundle)localObject1).putInt("structmsg_service_id", paramStructMsgForImageShare.mMsgServiceID);
          ((Bundle)localObject1).putByteArray("stuctmsg_bytes", paramStructMsgForImageShare.getBytes());
          localObject2 = new Intent();
          ((Intent)localObject2).putExtras((Bundle)localObject1);
          aufz.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 0);
          localObject1 = a(paramStructMsgForImageShare);
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break;
          }
          if (localObject1.length >= 8) {
            if (localObject1[7].equals("link")) {
              paramStructMsgForImageShare = localObject1[4];
            }
          }
          for (;;)
          {
            blaq.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40058", localObject1[0], new String[] { "1", "", paramStructMsgForImageShare });
            return;
            label369:
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("AIOGalleryScene", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement is null!!!");
            return;
            if ((localObject1[7].equals("scrawl_link")) && (localObject1.length >= 9)) {
              paramStructMsgForImageShare = localObject1[8];
            } else {
              paramStructMsgForImageShare = "";
            }
          }
        }
      }
      label419:
      localObject1 = null;
    }
  }
  
  protected void a(StructMsgForImageShare paramStructMsgForImageShare, String paramString)
  {
    Object localObject2 = "";
    paramStructMsgForImageShare = a(paramStructMsgForImageShare);
    Object localObject1 = localObject2;
    if (paramStructMsgForImageShare != null)
    {
      localObject1 = localObject2;
      if (paramStructMsgForImageShare.length > 0) {
        localObject1 = paramStructMsgForImageShare[0];
      }
    }
    localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, JumpActivity.class);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("from", "13");
      localJSONObject.put("jumpto", "com.qqcomic.activity.VipComicMainTabActivity");
      localJSONObject.put("leftViewText", anni.a(2131698864));
      localJSONObject.put("maintab", "index");
      ((Intent)localObject2).setData(Uri.parse("mqqapi://qqcomic/jump?options=" + localJSONObject.toString()));
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
      if ((paramStructMsgForImageShare != null) && (paramStructMsgForImageShare.length >= 8))
      {
        if (paramStructMsgForImageShare[7].equals("link"))
        {
          paramStructMsgForImageShare = paramStructMsgForImageShare[4];
          if (!"5".equals(paramString)) {
            break label251;
          }
          blaq.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40057", localObject1, new String[] { "", "", paramStructMsgForImageShare });
        }
        label251:
        while (!"6".equals(paramString))
        {
          return;
          if ((!paramStructMsgForImageShare[7].equals("scrawl_link")) || (paramStructMsgForImageShare.length < 9)) {
            break label308;
          }
          paramStructMsgForImageShare = paramStructMsgForImageShare[8];
          break;
        }
        blaq.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40058", localObject1, new String[] { "4", "", paramStructMsgForImageShare });
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        label308:
        paramStructMsgForImageShare = "";
      }
    }
  }
  
  boolean a(ahui paramahui)
  {
    if (paramahui == null) {
      return false;
    }
    if ((this.jdField_a_of_type_Ahui != null) && (this.jdField_a_of_type_Ahui.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramahui.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long) && (this.jdField_a_of_type_Ahui.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int == paramahui.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      this.jdField_a_of_type_Ahui = paramahui;
      boolean bool2;
      AIOImageData localAIOImageData;
      if ((this.jdField_b_of_type_AndroidWidgetImageButton.getVisibility() != 4) || (this.jdField_a_of_type_AndroidViewView.getVisibility() != 4))
      {
        bool2 = true;
        if (AIOImageData.class.isInstance(paramahui.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          localAIOImageData = (AIOImageData)paramahui.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if (localAIOImageData.b != 1) {
            break label160;
          }
          a(paramahui, localAIOImageData, bool2);
        }
        label123:
        if ((!a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidWidgetRelativeLayout)) || (!this.v)) {
          break label229;
        }
        this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
      }
      for (;;)
      {
        return true;
        bool2 = false;
        break;
        label160:
        if (localAIOImageData.b == 2)
        {
          a(localAIOImageData, bool1, bool2);
          break label123;
        }
        if (localAIOImageData.b == 5)
        {
          autv.a(this.g, this.jdField_a_of_type_AndroidAppActivity, localAIOImageData, this);
          break label123;
        }
        if (!bool2) {
          break label123;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        break label123;
        label229:
        if (this.jdField_d_of_type_AndroidWidgetButton != null) {
          this.jdField_d_of_type_AndroidWidgetButton.setVisibility(4);
        }
      }
    }
  }
  
  public boolean a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if (!bclh.j()) {
      return false;
    }
    if (this.jdField_a_of_type_Ahtj.a() != null)
    {
      Object localObject = this.jdField_a_of_type_Ahtj.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if ((localObject instanceof AIOShortVideoData))
      {
        AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)localObject;
        if (localAIOShortVideoData.k == 2)
        {
          if (this.jdField_d_of_type_AndroidWidgetButton != null) {
            return true;
          }
          if (localAIOShortVideoData.g == 0) {
            localObject = anni.a(2131698856);
          }
          for (;;)
          {
            this.jdField_d_of_type_AndroidWidgetButton = new Button(paramActivity);
            this.jdField_d_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
            this.jdField_d_of_type_AndroidWidgetButton.setTextColor(-1);
            this.jdField_d_of_type_AndroidWidgetButton.setTextSize(18.0F);
            int i = (int)(bgtn.a() * 0.42D);
            paramActivity = new RelativeLayout.LayoutParams(i, i * 114 / 314);
            paramActivity.addRule(14);
            paramActivity.addRule(12);
            paramActivity.bottomMargin = 56;
            paramViewGroup.addView(this.jdField_d_of_type_AndroidWidgetButton, paramActivity);
            this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(new ahtg(this, localAIOShortVideoData));
            return true;
            if (1 == localAIOShortVideoData.g)
            {
              localObject = anni.a(2131698843);
            }
            else
            {
              if (3000 != localAIOShortVideoData.g) {
                break;
              }
              localObject = anni.a(2131698872);
            }
          }
          return false;
        }
      }
    }
    return false;
  }
  
  boolean a(bkho parambkho, AIOImageData paramAIOImageData)
  {
    if ((parambkho == null) || (paramAIOImageData == null)) {}
    do
    {
      return false;
      if (paramAIOImageData.b == 1)
      {
        parambkho.b(2131692953);
        parambkho.b(2131692951);
        parambkho.b(2131692949);
        parambkho.b(2131692948);
        return true;
      }
    } while (paramAIOImageData.b != 2);
    parambkho.b(2131692951);
    parambkho.b(2131692953);
    parambkho.b(2131692946);
    Object localObject = b(((StructMsgForImageShare)bcwd.a((byte[])paramAIOImageData.a)).mMsgActionData);
    if ((localObject != null) && (localObject.length > 2))
    {
      parambkho = "";
      paramAIOImageData = Uri.parse(localObject[1]);
    }
    try
    {
      paramAIOImageData = paramAIOImageData.getQueryParameter("article_id");
      parambkho = paramAIOImageData;
    }
    catch (Exception paramAIOImageData)
    {
      for (;;)
      {
        paramAIOImageData.printStackTrace();
      }
    }
    paramAIOImageData = parambkho;
    if (parambkho == null) {
      paramAIOImageData = "";
    }
    parambkho = "";
    if (localObject.length > 3)
    {
      localObject = localObject[3];
      if (localObject != null)
      {
        parambkho = (bkho)localObject;
        if (((String)localObject).equals("1")) {}
      }
      else
      {
        parambkho = "";
      }
    }
    oat.a(null, "", "0X8007154", "0X8007154", 0, 0, paramAIOImageData, parambkho, "", "");
    return true;
  }
  
  boolean a(String paramString, AIOImageData paramAIOImageData, File paramFile)
  {
    boolean bool2 = true;
    if ((paramString == null) || (paramAIOImageData == null) || (paramFile == null)) {}
    label188:
    do
    {
      do
      {
        do
        {
          return false;
          if (!paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692953))) {
            break;
          }
        } while ((paramAIOImageData.b != 1) && (paramAIOImageData.b != 2));
        paramString = (StructMsgForImageShare)bcwd.a((byte[])paramAIOImageData.a);
        a(paramString);
        a(paramAIOImageData, paramString);
        return true;
        if (!paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692951))) {
          break;
        }
        if (paramAIOImageData.b == 1)
        {
          paramString = (StructMsgForImageShare)bcwd.a((byte[])paramAIOImageData.a);
          paramAIOImageData = a(paramString);
          if ((paramAIOImageData != null) && (paramAIOImageData.length >= 8))
          {
            bool1 = bool2;
            if (!paramAIOImageData[7].equals("link")) {
              if (!paramAIOImageData[7].equals("scrawl_link")) {
                break label188;
              }
            }
          }
          for (boolean bool1 = bool2;; bool1 = false)
          {
            a(bool1, paramAIOImageData, paramString, paramFile);
            return bool1;
          }
        }
      } while (paramAIOImageData.b != 2);
      paramString = (StructMsgForImageShare)bcwd.a((byte[])paramAIOImageData.a);
      paramAIOImageData = b(paramString.mMsgActionData);
    } while ((paramAIOImageData == null) || (paramAIOImageData.length <= 2));
    a(paramAIOImageData, paramString);
    for (;;)
    {
      return true;
      if (paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692949)))
      {
        if (paramAIOImageData.b != 1) {
          break;
        }
        b((StructMsgForImageShare)bcwd.a((byte[])paramAIOImageData.a), "6");
        return true;
      }
      if (paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692948)))
      {
        if (paramAIOImageData.b != 1) {
          break;
        }
        a((StructMsgForImageShare)bcwd.a((byte[])paramAIOImageData.a), "6");
        return true;
      }
      if ((!paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692946))) || (paramAIOImageData.b != 2)) {
        break;
      }
      a(paramAIOImageData);
    }
  }
  
  protected void b(StructMsgForImageShare paramStructMsgForImageShare, String paramString)
  {
    String[] arrayOfString = a(paramStructMsgForImageShare);
    if ((arrayOfString == null) || (arrayOfString.length < 8)) {}
    for (;;)
    {
      return;
      paramStructMsgForImageShare = new Intent(this.jdField_a_of_type_AndroidAppActivity, JumpActivity.class);
      JSONObject localJSONObject = new JSONObject();
      String str = VipComicJumpActivity.a("comicDetailComic", null, null, "1", "354", null, "ADTAG=comic.plugin.fav&pos=aio&id=" + arrayOfString[0]);
      try
      {
        localJSONObject.put("from", "13");
        localJSONObject.put("jumpto", "com.qqcomic.activity.VipComicTabBrowserActivity");
        localJSONObject.put("url", URLEncoder.encode(str));
        localJSONObject.put("leftViewText", anni.a(2131698863));
        paramStructMsgForImageShare.setData(Uri.parse("mqqapi://qqcomic/jump?options=" + localJSONObject.toString()));
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramStructMsgForImageShare);
        if (arrayOfString.length >= 8)
        {
          if (arrayOfString[7].equals("link")) {}
          for (paramStructMsgForImageShare = arrayOfString[4]; "5".equals(paramString); paramStructMsgForImageShare = arrayOfString[8])
          {
            blaq.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40055", arrayOfString[0], new String[] { "", "", paramStructMsgForImageShare });
            return;
            if ((!arrayOfString[7].equals("scrawl_link")) || (arrayOfString.length < 9)) {
              break label334;
            }
          }
          if (!"6".equals(paramString)) {
            continue;
          }
          blaq.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40058", arrayOfString[0], new String[] { "3", "", paramStructMsgForImageShare });
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          label334:
          paramStructMsgForImageShare = "";
        }
      }
    }
  }
  
  protected void c(StructMsgForImageShare paramStructMsgForImageShare, String paramString)
  {
    String[] arrayOfString = a(paramStructMsgForImageShare);
    if ((arrayOfString == null) || (arrayOfString.length < 8)) {
      return;
    }
    int i = 1;
    paramString = new JSONObject();
    paramStructMsgForImageShare = new JSONObject();
    try
    {
      paramStructMsgForImageShare.put("comicID", arrayOfString[0]);
      paramStructMsgForImageShare.put("comicSectionID", arrayOfString[2]);
      paramStructMsgForImageShare.put("comicPageID", arrayOfString[4]);
      paramStructMsgForImageShare.put("type", arrayOfString[6]);
      paramString.put("jumpto", "com.qqcomic.activity.reader.VipComicPortraitReadingActivity");
      paramString.put("comic", paramStructMsgForImageShare);
      paramString.put("from", "13");
      if (i != 0)
      {
        paramStructMsgForImageShare = new Intent(this.jdField_a_of_type_AndroidAppActivity, VipComicJumpActivity.class);
        paramStructMsgForImageShare.putExtra("options", paramString.toString());
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramStructMsgForImageShare);
        paramString = "";
        if (arrayOfString.length < 8) {
          break label381;
        }
        paramStructMsgForImageShare = arrayOfString[4];
        if (!arrayOfString[7].equals("link")) {
          break label347;
        }
        paramString = arrayOfString[4];
        blaq.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "100008", "2", "40056", arrayOfString[0], new String[] { "", paramStructMsgForImageShare, paramString });
      }
    }
    catch (Exception paramStructMsgForImageShare)
    {
      for (;;)
      {
        i = 0;
        continue;
        paramString = "https://cdn.vip.qq.com/club/client/comic/release/html/redirect.html?_wv=5123&_bid=354&_cfrom=13&action=read&actionType=keepread&id=" + arrayOfString[0] + "&name=" + URLEncoder.encode(arrayOfString[1]) + "&sectionID=" + arrayOfString[2] + "&pageID=" + arrayOfString[4] + "&pageOffset=0&type=" + arrayOfString[6];
        paramStructMsgForImageShare = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
        paramStructMsgForImageShare.putExtra("url", paramString);
        continue;
        label347:
        paramString = paramStructMsgForImageShare;
        if (arrayOfString[7].equals("scrawl_link"))
        {
          paramString = paramStructMsgForImageShare;
          if (arrayOfString.length >= 9)
          {
            paramString = arrayOfString[8];
            continue;
          }
        }
        label381:
        paramStructMsgForImageShare = paramString;
        paramString = "";
      }
    }
  }
  
  boolean g()
  {
    Object localObject = this.jdField_a_of_type_Ahtj.b();
    if ((localObject != null) && (AIOImageData.class.isInstance(((ahui)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
    {
      localObject = (AIOImageData)((ahui)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if ((((AIOImageData)localObject).b != 1) && (((AIOImageData)localObject).b != 2)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Ahtj.a() != null)
        {
          localObject = this.jdField_a_of_type_Ahtj.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if ((localObject != null) && ((localObject instanceof AIOShortVideoData)) && (((AIOShortVideoData)localObject).k == 2) && (this.jdField_d_of_type_AndroidWidgetButton != null)) {
            this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
          }
        }
        this.v = true;
        return true;
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
    }
  }
  
  boolean h()
  {
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    if (this.jdField_d_of_type_AndroidWidgetButton != null) {
      this.jdField_d_of_type_AndroidWidgetButton.setVisibility(4);
    }
    return true;
  }
  
  public void h_()
  {
    super.h_();
    I();
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentWidgetDragView.a();
    this.jdField_d_of_type_AndroidViewView.setAlpha(1.0F);
    this.jdField_a_of_type_Ahtd = new ahtd(this);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    if (this.jdField_a_of_type_Abgc.a() != null) {
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_a_of_type_Ahtj.b.jdField_a_of_type_AndroidGraphicsRect);
    }
    while ((this.jdField_a_of_type_Ahtj.b.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData))
    {
      this.jdField_a_of_type_ComTencentWidgetGallery.a(false);
      this.jdField_a_of_type_ComTencentWidgetGallery.b(false);
      return;
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_a_of_type_Ahtj.b.b);
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.a(true);
    this.jdField_a_of_type_ComTencentWidgetGallery.b(true);
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentWidgetDragView.a)
    {
      this.jdField_a_of_type_Abgc.a().i();
      return;
    }
    super.q();
  }
  
  protected void u()
  {
    super.u();
    if ((this.jdField_a_of_type_Ahtd.a) || (this.jdField_a_of_type_Ahtd.d) || (this.jdField_a_of_type_Ahtd.e) || (this.jdField_a_of_type_Ahtd.f))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryScene", 2, "updateUI selectedItem all gone");
      }
      this.g.setVisibility(4);
    }
    while ((this.jdField_a_of_type_Ahtj == null) || (this.jdField_a_of_type_Ahtj.a() == null) || (!(this.jdField_a_of_type_Ahtj.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) || (((AIOImageData)this.jdField_a_of_type_Ahtj.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b != 5)) {
      return;
    }
    this.g.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahte
 * JD-Core Version:    0.7.0.1
 */