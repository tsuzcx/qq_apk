import org.json.JSONObject;

public class aeov
{
  @atgw(a="structmsg_switch")
  public int a;
  @atgw(a="msf_http_monitor_ban")
  public boolean a;
  @atgw(a="structmsg_sampling")
  public int b;
  @atgw(a="structmsg_filternumber")
  public int c;
  @atgw(a="switch_background_start_activity")
  public int d;
  @atgw(a="switch_open_third_app")
  public int e;
  @atgw(a="switch_imei")
  public int f;
  
  public JSONObject a()
  {
    return atgx.a(this);
  }
  
  public String toString()
  {
    return a().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aeov
 * JD-Core Version:    0.7.0.1
 */