import org.json.JSONObject;

public class acil
{
  @aqrf(a="structmsg_switch")
  public int a;
  @aqrf(a="msf_http_monitor_ban")
  public boolean a;
  @aqrf(a="structmsg_sampling")
  public int b;
  @aqrf(a="structmsg_filternumber")
  public int c;
  @aqrf(a="switch_background_start_activity")
  public int d;
  @aqrf(a="switch_open_third_app")
  public int e;
  @aqrf(a="switch_imei")
  public int f;
  
  public JSONObject a()
  {
    return aqrg.a(this);
  }
  
  public String toString()
  {
    return a().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acil
 * JD-Core Version:    0.7.0.1
 */