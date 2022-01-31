package com.tencent.mm.sdk.d;

import android.os.Message;
import android.text.TextUtils;
import java.util.Calendar;

public final class d$a
{
  private d ujf;
  private long ujg;
  private int ujh;
  private String uji;
  private a ujj;
  private a ujk;
  private a ujl;
  
  d$a(d paramd, Message paramMessage, String paramString, a parama1, a parama2, a parama3)
  {
    a(paramd, paramMessage, paramString, parama1, parama2, parama3);
  }
  
  public final void a(d paramd, Message paramMessage, String paramString, a parama1, a parama2, a parama3)
  {
    this.ujf = paramd;
    this.ujg = System.currentTimeMillis();
    if (paramMessage != null) {}
    for (int i = paramMessage.what;; i = 0)
    {
      this.ujh = i;
      this.uji = paramString;
      this.ujj = parama1;
      this.ujk = parama2;
      this.ujl = parama3;
      return;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time=");
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.ujg);
    localStringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[] { localObject, localObject, localObject, localObject, localObject, localObject }));
    localStringBuilder.append(" processed=");
    if (this.ujj == null)
    {
      localObject = "<null>";
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" org=");
      if (this.ujk != null) {
        break label237;
      }
      localObject = "<null>";
      label106:
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" dest=");
      if (this.ujl != null) {
        break label250;
      }
      localObject = "<null>";
      label129:
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" what=");
      if (this.ujf == null) {
        break label263;
      }
      localObject = null;
      label151:
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label269;
      }
      localStringBuilder.append(this.ujh);
      localStringBuilder.append("(0x");
      localStringBuilder.append(Integer.toHexString(this.ujh));
      localStringBuilder.append(")");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.uji))
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(this.uji);
      }
      return localStringBuilder.toString();
      localObject = this.ujj.getName();
      break;
      label237:
      localObject = this.ujk.getName();
      break label106;
      label250:
      localObject = this.ujl.getName();
      break label129;
      label263:
      localObject = "";
      break label151;
      label269:
      localStringBuilder.append((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.d.d.a
 * JD-Core Version:    0.7.0.1
 */