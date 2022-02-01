package com.tencent.mm.sdk.d;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;

public final class d$a
{
  private d Gvb;
  private long Gvc;
  private int Gvd;
  private String Gve;
  private a Gvf;
  private a Gvg;
  private a Gvh;
  
  d$a(d paramd, Message paramMessage, String paramString, a parama1, a parama2, a parama3)
  {
    AppMethodBeat.i(158011);
    a(paramd, paramMessage, paramString, parama1, parama2, parama3);
    AppMethodBeat.o(158011);
  }
  
  public final void a(d paramd, Message paramMessage, String paramString, a parama1, a parama2, a parama3)
  {
    AppMethodBeat.i(158012);
    this.Gvb = paramd;
    this.Gvc = System.currentTimeMillis();
    if (paramMessage != null) {}
    for (int i = paramMessage.what;; i = 0)
    {
      this.Gvd = i;
      this.Gve = paramString;
      this.Gvf = parama1;
      this.Gvg = parama2;
      this.Gvh = parama3;
      AppMethodBeat.o(158012);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158013);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time=");
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.Gvc);
    localStringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[] { localObject, localObject, localObject, localObject, localObject, localObject }));
    localStringBuilder.append(" processed=");
    if (this.Gvf == null)
    {
      localObject = "<null>";
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" org=");
      if (this.Gvg != null) {
        break label249;
      }
      localObject = "<null>";
      label111:
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" dest=");
      if (this.Gvh != null) {
        break label262;
      }
      localObject = "<null>";
      label134:
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" what=");
      if (this.Gvb == null) {
        break label275;
      }
      localObject = null;
      label156:
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label281;
      }
      localStringBuilder.append(this.Gvd);
      localStringBuilder.append("(0x");
      localStringBuilder.append(Integer.toHexString(this.Gvd));
      localStringBuilder.append(")");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.Gve))
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(this.Gve);
      }
      localObject = localStringBuilder.toString();
      AppMethodBeat.o(158013);
      return localObject;
      localObject = this.Gvf.getName();
      break;
      label249:
      localObject = this.Gvg.getName();
      break label111;
      label262:
      localObject = this.Gvh.getName();
      break label134;
      label275:
      localObject = "";
      break label156;
      label281:
      localStringBuilder.append((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.d.d.a
 * JD-Core Version:    0.7.0.1
 */