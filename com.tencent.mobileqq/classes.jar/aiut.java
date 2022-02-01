import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class aiut
  implements aiwf, Handler.Callback, View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = anzj.a(2131700186);
  private static final String jdField_b_of_type_JavaLangString = anzj.a(2131700187);
  private int jdField_a_of_type_Int;
  private aiwh jdField_a_of_type_Aiwh;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bkgt jdField_a_of_type_Bkgt;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private int jdField_b_of_type_Int;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public aiut(BaseActivity paramBaseActivity, aiwh paramaiwh)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Aiwh = paramaiwh;
    this.jdField_a_of_type_Bkgt = ((bkgt)paramBaseActivity.app.getManager(165));
    paramBaseActivity = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0);
    this.d = paramBaseActivity.getString("sp_c2b_tip_content", jdField_a_of_type_JavaLangString);
    this.c = paramBaseActivity.getString("sp_c2b_tip_url", "https://m.qidian.qq.com/agreement/verified.html");
    this.e = paramBaseActivity.getString("sp_c2b_tip_highlight", jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Int = paramBaseActivity.getInt("sp_c2b_tip_is_show", 1);
    this.jdField_a_of_type_JavaUtilSet = paramBaseActivity.getStringSet("sp_c2b_tip_uins_shown", new HashSet());
    this.jdField_b_of_type_Int = paramBaseActivity.getInt("sp_c2b_tip_hide_time", 60);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  public static void a()
  {
    SharedPreferences.Editor localEditor = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0).edit();
    localEditor.remove("sp_c2b_tip_content");
    localEditor.remove("sp_c2b_tip_url");
    localEditor.remove("sp_c2b_tip_highlight");
    localEditor.remove("sp_c2b_tip_is_show");
    localEditor.remove("sp_c2b_tip_hide_time");
    localEditor.apply();
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (!"lawtip".equals(paramString.getString("type"))) {
        return false;
      }
      SharedPreferences.Editor localEditor = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0).edit();
      localEditor.putString("sp_c2b_tip_content", paramString.getString("content"));
      localEditor.putString("sp_c2b_tip_url", paramString.getString("url"));
      localEditor.putString("sp_c2b_tip_highlight", paramString.getString("highlight"));
      localEditor.putInt("sp_c2b_tip_is_show", paramString.getInt("show"));
      localEditor.putInt("sp_c2b_tip_hide_time", paramString.getInt("hideTime"));
      localEditor.apply();
      return true;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("C2BTipsBar", 2, "parse config error:" + paramString.toString());
      }
    }
    return false;
  }
  
  public int a()
  {
    return 59;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558647, null);
    TextView localTextView = (TextView)paramVarArgs.findViewById(2131362503);
    SpannableString localSpannableString = new SpannableString(this.d);
    int i = 0;
    for (;;)
    {
      if (i < this.d.length())
      {
        i = this.d.indexOf(this.e, i);
        if (i >= 0) {}
      }
      else
      {
        localTextView.setText(localSpannableString);
        paramVarArgs.setOnClickListener(this);
        paramVarArgs.findViewById(2131362502).setOnClickListener(this);
        return paramVarArgs;
      }
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#12b7f5")), i, this.e.length() + i, 33);
      i += this.e.length();
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
      return;
    }
    this.f = paramString;
    this.jdField_a_of_type_Aiwh.a(this, new Object[0]);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, this.jdField_b_of_type_Int * 1000);
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 22;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (this.jdField_a_of_type_Aiwh.a() == this)) {
      this.jdField_a_of_type_Aiwh.a();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.c);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00899", "Qidian", this.f, "0X8009788", "ClickLawTip", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), this.jdField_a_of_type_Bkgt.a(this.f), "8.4.5", "");
      continue;
      localObject = new HashSet(this.jdField_a_of_type_JavaUtilSet);
      ((HashSet)localObject).add(this.f);
      SharedPreferences.Editor localEditor = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0).edit();
      localEditor.putStringSet("sp_c2b_tip_uins_shown", (Set)localObject);
      localEditor.apply();
      this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_Aiwh.a();
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00899", "Qidian", this.f, "0X8009789", "CloseLawTip", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), this.jdField_a_of_type_Bkgt.a(this.f), "8.4.5", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiut
 * JD-Core Version:    0.7.0.1
 */