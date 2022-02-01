package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dtj
  extends com.tencent.mm.bx.a
{
  public int EHZ;
  public int EIa;
  public String Md5;
  public String rNA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110860);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(110860);
        throw paramVarArgs;
      }
      if (this.rNA == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadUrl");
        AppMethodBeat.o(110860);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      if (this.rNA != null) {
        paramVarArgs.d(2, this.rNA);
      }
      paramVarArgs.aR(3, this.EHZ);
      paramVarArgs.aR(4, this.EIa);
      AppMethodBeat.o(110860);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.b.b.a.e(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rNA != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.rNA);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.EHZ);
      int j = f.a.a.b.b.a.bA(4, this.EIa);
      AppMethodBeat.o(110860);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(110860);
          throw paramVarArgs;
        }
        if (this.rNA == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadUrl");
          AppMethodBeat.o(110860);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110860);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dtj localdtj = (dtj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110860);
          return -1;
        case 1: 
          localdtj.Md5 = locala.KhF.readString();
          AppMethodBeat.o(110860);
          return 0;
        case 2: 
          localdtj.rNA = locala.KhF.readString();
          AppMethodBeat.o(110860);
          return 0;
        case 3: 
          localdtj.EHZ = locala.KhF.xS();
          AppMethodBeat.o(110860);
          return 0;
        }
        localdtj.EIa = locala.KhF.xS();
        AppMethodBeat.o(110860);
        return 0;
      }
      AppMethodBeat.o(110860);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtj
 * JD-Core Version:    0.7.0.1
 */