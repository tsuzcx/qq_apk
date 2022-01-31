import org.json.JSONObject;

public abstract interface alwn
{
  public abstract boolean needProcess(JSONObject paramJSONObject);
  
  public abstract void process(JSONObject paramJSONObject, alwo paramalwo, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alwn
 * JD-Core Version:    0.7.0.1
 */