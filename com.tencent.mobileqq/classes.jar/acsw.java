import org.json.JSONObject;

public class acsw
{
  @arlz(a="structmsg_switch")
  public int a;
  @arlz(a="msf_http_monitor_ban")
  public boolean a;
  @arlz(a="structmsg_sampling")
  public int b;
  @arlz(a="structmsg_filternumber")
  public int c;
  @arlz(a="switch_background_start_activity")
  public int d;
  @arlz(a="switch_open_third_app")
  public int e;
  @arlz(a="switch_imei")
  public int f;
  
  public JSONObject a()
  {
    return arma.a(this);
  }
  
  public String toString()
  {
    return a().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acsw
 * JD-Core Version:    0.7.0.1
 */