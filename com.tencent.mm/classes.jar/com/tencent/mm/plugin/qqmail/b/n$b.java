package com.tencent.mm.plugin.qqmail.b;

import java.util.Map;

public final class n$b
{
  int ndK;
  Map<String, String> ndL;
  Map<String, String> ndM;
  n.d ndN;
  
  public n$b(int paramInt, Map<String, String> paramMap1, Map<String, String> paramMap2, n.d paramd)
  {
    this.ndK = paramInt;
    this.ndL = paramMap1;
    this.ndM = paramMap2;
    this.ndN = paramd;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Request method:").append(this.ndK).append(", params:");
    if (this.ndL != null)
    {
      localObject = this.ndL;
      localStringBuilder = localStringBuilder.append(localObject).append(", cookie:");
      if (this.ndM == null) {
        break label72;
      }
    }
    label72:
    for (Object localObject = this.ndM;; localObject = "")
    {
      return localObject;
      localObject = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.n.b
 * JD-Core Version:    0.7.0.1
 */