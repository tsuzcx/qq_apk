package BOSSStrategyCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class tPullStrategyFeedoper
  extends JceStruct
{
  public int i_app_id;
  public int i_oper_source;
  public int i_oper_times;
  public int i_oper_type;
  public int i_pattern_id;
  public int i_platform_id;
  public int i_resource_id;
  public int i_task_id;
  public long l_user;
  public int phone_sourceid;
  public String s_app_trace_info = "";
  public String s_oper_aux = "";
  public String s_phone_qua = "";
  
  public tPullStrategyFeedoper() {}
  
  public tPullStrategyFeedoper(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString1, String paramString2, int paramInt9, String paramString3)
  {
    this.l_user = paramLong;
    this.i_app_id = paramInt1;
    this.i_task_id = paramInt2;
    this.i_resource_id = paramInt3;
    this.i_pattern_id = paramInt4;
    this.i_platform_id = paramInt5;
    this.i_oper_type = paramInt6;
    this.i_oper_times = paramInt7;
    this.i_oper_source = paramInt8;
    this.s_oper_aux = paramString1;
    this.s_phone_qua = paramString2;
    this.phone_sourceid = paramInt9;
    this.s_app_trace_info = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.l_user = paramJceInputStream.read(this.l_user, 0, true);
    this.i_app_id = paramJceInputStream.read(this.i_app_id, 1, true);
    this.i_task_id = paramJceInputStream.read(this.i_task_id, 2, true);
    this.i_resource_id = paramJceInputStream.read(this.i_resource_id, 3, true);
    this.i_pattern_id = paramJceInputStream.read(this.i_pattern_id, 4, true);
    this.i_platform_id = paramJceInputStream.read(this.i_platform_id, 5, true);
    this.i_oper_type = paramJceInputStream.read(this.i_oper_type, 6, true);
    this.i_oper_times = paramJceInputStream.read(this.i_oper_times, 7, false);
    this.i_oper_source = paramJceInputStream.read(this.i_oper_source, 8, false);
    this.s_oper_aux = paramJceInputStream.readString(9, false);
    this.s_phone_qua = paramJceInputStream.readString(10, false);
    this.phone_sourceid = paramJceInputStream.read(this.phone_sourceid, 11, false);
    this.s_app_trace_info = paramJceInputStream.readString(12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.l_user, 0);
    paramJceOutputStream.write(this.i_app_id, 1);
    paramJceOutputStream.write(this.i_task_id, 2);
    paramJceOutputStream.write(this.i_resource_id, 3);
    paramJceOutputStream.write(this.i_pattern_id, 4);
    paramJceOutputStream.write(this.i_platform_id, 5);
    paramJceOutputStream.write(this.i_oper_type, 6);
    paramJceOutputStream.write(this.i_oper_times, 7);
    paramJceOutputStream.write(this.i_oper_source, 8);
    String str = this.s_oper_aux;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    str = this.s_phone_qua;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
    paramJceOutputStream.write(this.phone_sourceid, 11);
    str = this.s_app_trace_info;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     BOSSStrategyCenter.tPullStrategyFeedoper
 * JD-Core Version:    0.7.0.1
 */