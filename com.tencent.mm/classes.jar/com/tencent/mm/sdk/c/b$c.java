package com.tencent.mm.sdk.c;

import java.util.Map;

public class b$c
{
  public String content;
  public Map<String, String> ndM = null;
  public int status = 0;
  public b.a uee;
  
  public b$c(String paramString)
  {
    this.content = paramString;
  }
  
  public void onComplete() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Response status:").append(this.status).append(", cookie:");
    Object localObject;
    if (this.ndM != null)
    {
      localObject = this.ndM;
      localObject = localStringBuilder.append(localObject).append(", content length :");
      if (this.content == null) {
        break label75;
      }
    }
    label75:
    for (int i = this.content.length();; i = 0)
    {
      return i;
      localObject = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.c.b.c
 * JD-Core Version:    0.7.0.1
 */