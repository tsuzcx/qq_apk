package com.tencent.mm.plugin.sns.ad.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  public static k.b XV(int paramInt)
  {
    AppMethodBeat.i(202366);
    Object localObject = "1";
    if (paramInt == 0) {
      localObject = "0";
    }
    localObject = new a((String)localObject, (byte)0);
    AppMethodBeat.o(202366);
    return localObject;
  }
  
  static final class a
    extends k.a
  {
    private String mValue;
    
    private a(String paramString)
    {
      this.mValue = paramString;
    }
    
    public final String eYp()
    {
      return "ONLINE_FILE_COPY_AT_LANDING";
    }
    
    public final String eYq()
    {
      AppMethodBeat.i(202365);
      if (TextUtils.isEmpty(this.mValue))
      {
        AppMethodBeat.o(202365);
        return "";
      }
      String str = this.mValue;
      AppMethodBeat.o(202365);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.l
 * JD-Core Version:    0.7.0.1
 */