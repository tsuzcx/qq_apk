import org.json.JSONObject;

public class acta
{
  @arlx(a="structmsg_switch")
  public int a;
  @arlx(a="msf_http_monitor_ban")
  public boolean a;
  @arlx(a="structmsg_sampling")
  public int b;
  @arlx(a="structmsg_filternumber")
  public int c;
  @arlx(a="switch_background_start_activity")
  public int d;
  @arlx(a="switch_open_third_app")
  public int e;
  @arlx(a="switch_imei")
  public int f;
  
  public JSONObject a()
  {
    return arly.a(this);
  }
  
  public String toString()
  {
    return a().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acta
 * JD-Core Version:    0.7.0.1
 */