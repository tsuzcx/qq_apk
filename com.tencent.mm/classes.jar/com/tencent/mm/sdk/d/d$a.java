package com.tencent.mm.sdk.d;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;

public final class d$a
{
  private d yrf;
  private long yrg;
  private int yrh;
  private String yri;
  private a yrj;
  private a yrk;
  private a yrl;
  
  d$a(d paramd, Message paramMessage, String paramString, a parama1, a parama2, a parama3)
  {
    AppMethodBeat.i(52448);
    a(paramd, paramMessage, paramString, parama1, parama2, parama3);
    AppMethodBeat.o(52448);
  }
  
  public final void a(d paramd, Message paramMessage, String paramString, a parama1, a parama2, a parama3)
  {
    AppMethodBeat.i(52449);
    this.yrf = paramd;
    this.yrg = System.currentTimeMillis();
    if (paramMessage != null) {}
    for (int i = paramMessage.what;; i = 0)
    {
      this.yrh = i;
      this.yri = paramString;
      this.yrj = parama1;
      this.yrk = parama2;
      this.yrl = parama3;
      AppMethodBeat.o(52449);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(52450);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time=");
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.yrg);
    localStringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[] { localObject, localObject, localObject, localObject, localObject, localObject }));
    localStringBuilder.append(" processed=");
    if (this.yrj == null)
    {
      localObject = "<null>";
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" org=");
      if (this.yrk != null) {
        break label249;
      }
      localObject = "<null>";
      label111:
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" dest=");
      if (this.yrl != null) {
        break label262;
      }
      localObject = "<null>";
      label134:
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" what=");
      if (this.yrf == null) {
        break label275;
      }
      localObject = null;
      label156:
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label281;
      }
      localStringBuilder.append(this.yrh);
      localStringBuilder.append("(0x");
      localStringBuilder.append(Integer.toHexString(this.yrh));
      localStringBuilder.append(")");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.yri))
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(this.yri);
      }
      localObject = localStringBuilder.toString();
      AppMethodBeat.o(52450);
      return localObject;
      localObject = this.yrj.getName();
      break;
      label249:
      localObject = this.yrk.getName();
      break label111;
      label262:
      localObject = this.yrl.getName();
      break label134;
      label275:
      localObject = "";
      break label156;
      label281:
      localStringBuilder.append((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.d.d.a
 * JD-Core Version:    0.7.0.1
 */