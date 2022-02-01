package com.tencent.mm.plugin.sns.ad.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public static h.b Ql(int paramInt)
  {
    AppMethodBeat.i(219183);
    Object localObject = "1";
    if (paramInt == 0) {
      localObject = "0";
    }
    localObject = new a((String)localObject, (byte)0);
    AppMethodBeat.o(219183);
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
    
    public final String dVH()
    {
      return "ONLINE_FILE_COPY_AT_LANDING";
    }
    
    public final String dVI()
    {
      AppMethodBeat.i(219182);
      if (TextUtils.isEmpty(this.mValue))
      {
        AppMethodBeat.o(219182);
        return "";
      }
      String str = this.mValue;
      AppMethodBeat.o(219182);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.i
 * JD-Core Version:    0.7.0.1
 */