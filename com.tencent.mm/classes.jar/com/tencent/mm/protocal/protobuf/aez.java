package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aez
  extends com.tencent.mm.bw.a
{
  public String Gvi;
  public String Gvj;
  public String kgh;
  public String model;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196245);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.kgh != null) {
        paramVarArgs.d(1, this.kgh);
      }
      if (this.model != null) {
        paramVarArgs.d(2, this.model);
      }
      if (this.Gvi != null) {
        paramVarArgs.d(3, this.Gvi);
      }
      if (this.Gvj != null) {
        paramVarArgs.d(4, this.Gvj);
      }
      AppMethodBeat.o(196245);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kgh == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.kgh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.model != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.model);
      }
      i = paramInt;
      if (this.Gvi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gvi);
      }
      paramInt = i;
      if (this.Gvj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gvj);
      }
      AppMethodBeat.o(196245);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(196245);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aez localaez = (aez)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(196245);
          return -1;
        case 1: 
          localaez.kgh = locala.OmT.readString();
          AppMethodBeat.o(196245);
          return 0;
        case 2: 
          localaez.model = locala.OmT.readString();
          AppMethodBeat.o(196245);
          return 0;
        case 3: 
          localaez.Gvi = locala.OmT.readString();
          AppMethodBeat.o(196245);
          return 0;
        }
        localaez.Gvj = locala.OmT.readString();
        AppMethodBeat.o(196245);
        return 0;
      }
      AppMethodBeat.o(196245);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aez
 * JD-Core Version:    0.7.0.1
 */