package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class NativeInfo
  extends com.tencent.mm.bx.a
{
  public int native_type;
  public String necessary_params;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257527);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.native_type);
      if (this.necessary_params != null) {
        paramVarArgs.g(2, this.necessary_params);
      }
      AppMethodBeat.o(257527);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.native_type) + 0;
      paramInt = i;
      if (this.necessary_params != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.necessary_params);
      }
      AppMethodBeat.o(257527);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257527);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      NativeInfo localNativeInfo = (NativeInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257527);
        return -1;
      case 1: 
        localNativeInfo.native_type = locala.ajGk.aar();
        AppMethodBeat.o(257527);
        return 0;
      }
      localNativeInfo.necessary_params = locala.ajGk.readString();
      AppMethodBeat.o(257527);
      return 0;
    }
    AppMethodBeat.o(257527);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.NativeInfo
 * JD-Core Version:    0.7.0.1
 */