package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dts
  extends com.tencent.mm.bx.a
{
  public String EIq;
  public String EIr;
  public String doh;
  public String uLz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152729);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EIq != null) {
        paramVarArgs.d(1, this.EIq);
      }
      if (this.doh != null) {
        paramVarArgs.d(2, this.doh);
      }
      if (this.uLz != null) {
        paramVarArgs.d(3, this.uLz);
      }
      if (this.EIr != null) {
        paramVarArgs.d(4, this.EIr);
      }
      AppMethodBeat.o(152729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EIq == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.EIq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.doh);
      }
      i = paramInt;
      if (this.uLz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uLz);
      }
      paramInt = i;
      if (this.EIr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EIr);
      }
      AppMethodBeat.o(152729);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152729);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dts localdts = (dts)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152729);
          return -1;
        case 1: 
          localdts.EIq = locala.KhF.readString();
          AppMethodBeat.o(152729);
          return 0;
        case 2: 
          localdts.doh = locala.KhF.readString();
          AppMethodBeat.o(152729);
          return 0;
        case 3: 
          localdts.uLz = locala.KhF.readString();
          AppMethodBeat.o(152729);
          return 0;
        }
        localdts.EIr = locala.KhF.readString();
        AppMethodBeat.o(152729);
        return 0;
      }
      AppMethodBeat.o(152729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dts
 * JD-Core Version:    0.7.0.1
 */