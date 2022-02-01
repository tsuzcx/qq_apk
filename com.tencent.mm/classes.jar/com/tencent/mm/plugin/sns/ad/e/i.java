package com.tencent.mm.plugin.sns.ad.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public static h.b PE(int paramInt)
  {
    AppMethodBeat.i(197711);
    Object localObject = "1";
    if (paramInt == 0) {
      localObject = "0";
    }
    localObject = new a((String)localObject, (byte)0);
    AppMethodBeat.o(197711);
    return localObject;
  }
  
  static final class a
    extends h.a
  {
    private String mValue;
    
    private a(String paramString)
    {
      this.mValue = paramString;
    }
    
    public final String dSj()
    {
      return "ONLINE_FILE_COPY_AT_LANDING";
    }
    
    public final String dSk()
    {
      AppMethodBeat.i(197710);
      if (TextUtils.isEmpty(this.mValue))
      {
        AppMethodBeat.o(197710);
        return "";
      }
      String str = this.mValue;
      AppMethodBeat.o(197710);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.i
 * JD-Core Version:    0.7.0.1
 */