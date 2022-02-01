package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ay
  extends com.tencent.mm.bx.a
{
  public String Fss;
  public String Fst;
  public String Fsu;
  public String iht;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125688);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iht != null) {
        paramVarArgs.d(1, this.iht);
      }
      if (this.Fss != null) {
        paramVarArgs.d(2, this.Fss);
      }
      if (this.Fst != null) {
        paramVarArgs.d(3, this.Fst);
      }
      if (this.Fsu != null) {
        paramVarArgs.d(4, this.Fsu);
      }
      AppMethodBeat.o(125688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iht == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.iht) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fss != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fss);
      }
      i = paramInt;
      if (this.Fst != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fst);
      }
      paramInt = i;
      if (this.Fsu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fsu);
      }
      AppMethodBeat.o(125688);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125688);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ay localay = (ay)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125688);
          return -1;
        case 1: 
          localay.iht = locala.NPN.readString();
          AppMethodBeat.o(125688);
          return 0;
        case 2: 
          localay.Fss = locala.NPN.readString();
          AppMethodBeat.o(125688);
          return 0;
        case 3: 
          localay.Fst = locala.NPN.readString();
          AppMethodBeat.o(125688);
          return 0;
        }
        localay.Fsu = locala.NPN.readString();
        AppMethodBeat.o(125688);
        return 0;
      }
      AppMethodBeat.o(125688);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ay
 * JD-Core Version:    0.7.0.1
 */