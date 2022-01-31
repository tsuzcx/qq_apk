import org.json.JSONObject;

public class aekg
{
  @atcn(a="structmsg_switch")
  public int a;
  @atcn(a="msf_http_monitor_ban")
  public boolean a;
  @atcn(a="structmsg_sampling")
  public int b;
  @atcn(a="structmsg_filternumber")
  public int c;
  @atcn(a="switch_background_start_activity")
  public int d;
  @atcn(a="switch_open_third_app")
  public int e;
  @atcn(a="switch_imei")
  public int f;
  
  public JSONObject a()
  {
    return atco.a(this);
  }
  
  public String toString()
  {
    return a().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aekg
 * JD-Core Version:    0.7.0.1
 */