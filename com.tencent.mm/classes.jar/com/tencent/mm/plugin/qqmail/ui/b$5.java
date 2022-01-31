package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.b.ai;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class b$5
  extends v.a
{
  b$5(b paramb, String paramString) {}
  
  public final void onComplete()
  {
    b.a(this.nhJ);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    y.e("MicroMsg.FileUploadHelper", "errCode:%d, desc:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    paramString = (ai)this.nhJ.nhC.get(this.dlh);
    if (paramString != null)
    {
      paramString.state = 3;
      this.nhJ.b(paramString);
    }
    if (paramInt == -5) {
      this.nhJ.nhA.ngi.a(new b.5.1(this));
    }
  }
  
  public final boolean onReady()
  {
    ai localai = (ai)this.nhJ.nhC.get(this.dlh);
    if (localai != null)
    {
      localai.state = 1;
      this.nhJ.b(localai);
    }
    return true;
  }
  
  public final void onSuccess(String paramString, Map<String, String> paramMap)
  {
    paramString = (String)paramMap.get(".Response.result.DataID");
    paramMap = (ai)this.nhJ.nhC.get(this.dlh);
    if (paramMap != null)
    {
      paramMap.state = 2;
      paramMap.nfr = paramString;
      this.nhJ.b(paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.b.5
 * JD-Core Version:    0.7.0.1
 */