package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class dlx
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public long aaRY;
  public long aaRZ;
  public int aaSa;
  public String aayd;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259058);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Json", this.aayd, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Interval", Long.valueOf(this.aaRZ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "LastCacheSecond", Long.valueOf(this.aaRY), false);
      com.tencent.mm.bk.a.a(localJSONObject, "IsPreload", Integer.valueOf(this.aaSa), false);
      label80:
      AppMethodBeat.o(259058);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label80;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117877);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IJG);
      if (this.aayd != null) {
        paramVarArgs.g(2, this.aayd);
      }
      paramVarArgs.bv(3, this.aaRZ);
      paramVarArgs.bv(4, this.aaRY);
      paramVarArgs.bS(5, this.aaSa);
      AppMethodBeat.o(117877);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.IJG) + 0;
      paramInt = i;
      if (this.aayd != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aayd);
      }
      i = i.a.a.b.b.a.q(3, this.aaRZ);
      int j = i.a.a.b.b.a.q(4, this.aaRY);
      int k = i.a.a.b.b.a.cJ(5, this.aaSa);
      AppMethodBeat.o(117877);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117877);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dlx localdlx = (dlx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117877);
        return -1;
      case 1: 
        localdlx.IJG = locala.ajGk.aar();
        AppMethodBeat.o(117877);
        return 0;
      case 2: 
        localdlx.aayd = locala.ajGk.readString();
        AppMethodBeat.o(117877);
        return 0;
      case 3: 
        localdlx.aaRZ = locala.ajGk.aaw();
        AppMethodBeat.o(117877);
        return 0;
      case 4: 
        localdlx.aaRY = locala.ajGk.aaw();
        AppMethodBeat.o(117877);
        return 0;
      }
      localdlx.aaSa = locala.ajGk.aar();
      AppMethodBeat.o(117877);
      return 0;
    }
    AppMethodBeat.o(117877);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlx
 * JD-Core Version:    0.7.0.1
 */