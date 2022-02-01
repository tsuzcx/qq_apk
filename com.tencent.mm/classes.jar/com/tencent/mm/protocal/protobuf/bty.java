package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class bty
  extends com.tencent.mm.cd.a
{
  public String Md5;
  public String StN;
  public String TdZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104789);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TdZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActivityId");
        AppMethodBeat.o(104789);
        throw paramVarArgs;
      }
      if (this.TdZ != null) {
        paramVarArgs.f(1, this.TdZ);
      }
      if (this.Md5 != null) {
        paramVarArgs.f(2, this.Md5);
      }
      if (this.StN != null) {
        paramVarArgs.f(3, this.StN);
      }
      AppMethodBeat.o(104789);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TdZ == null) {
        break label382;
      }
    }
    label382:
    for (int i = g.a.a.b.b.a.g(1, this.TdZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Md5);
      }
      i = paramInt;
      if (this.StN != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.StN);
      }
      AppMethodBeat.o(104789);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TdZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActivityId");
          AppMethodBeat.o(104789);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104789);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bty localbty = (bty)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104789);
          return -1;
        case 1: 
          localbty.TdZ = locala.abFh.readString();
          AppMethodBeat.o(104789);
          return 0;
        case 2: 
          localbty.Md5 = locala.abFh.readString();
          AppMethodBeat.o(104789);
          return 0;
        }
        localbty.StN = locala.abFh.readString();
        AppMethodBeat.o(104789);
        return 0;
      }
      AppMethodBeat.o(104789);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bty
 * JD-Core Version:    0.7.0.1
 */