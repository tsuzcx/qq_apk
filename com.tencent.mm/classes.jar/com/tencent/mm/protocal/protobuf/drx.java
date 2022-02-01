package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class drx
  extends com.tencent.mm.bx.a
{
  public long aaXD;
  public boolean aaXE;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259961);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "clickCostTime", Long.valueOf(this.aaXD), false);
      com.tencent.mm.bk.a.a(localJSONObject, "canConvertTranslucent", Boolean.valueOf(this.aaXE), false);
      label41:
      AppMethodBeat.o(259961);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259967);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaXD);
      paramVarArgs.di(2, this.aaXE);
      AppMethodBeat.o(259967);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.aaXD);
      int i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(259967);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259967);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      drx localdrx = (drx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259967);
        return -1;
      case 1: 
        localdrx.aaXD = locala.ajGk.aaw();
        AppMethodBeat.o(259967);
        return 0;
      }
      localdrx.aaXE = locala.ajGk.aai();
      AppMethodBeat.o(259967);
      return 0;
    }
    AppMethodBeat.o(259967);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drx
 * JD-Core Version:    0.7.0.1
 */