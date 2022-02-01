package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ay
  extends com.tencent.mm.bw.a
{
  public String FKQ;
  public String FKR;
  public String FKS;
  public String ikm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125688);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ikm != null) {
        paramVarArgs.d(1, this.ikm);
      }
      if (this.FKQ != null) {
        paramVarArgs.d(2, this.FKQ);
      }
      if (this.FKR != null) {
        paramVarArgs.d(3, this.FKR);
      }
      if (this.FKS != null) {
        paramVarArgs.d(4, this.FKS);
      }
      AppMethodBeat.o(125688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ikm == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.ikm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FKQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FKQ);
      }
      i = paramInt;
      if (this.FKR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FKR);
      }
      paramInt = i;
      if (this.FKS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FKS);
      }
      AppMethodBeat.o(125688);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          localay.ikm = locala.OmT.readString();
          AppMethodBeat.o(125688);
          return 0;
        case 2: 
          localay.FKQ = locala.OmT.readString();
          AppMethodBeat.o(125688);
          return 0;
        case 3: 
          localay.FKR = locala.OmT.readString();
          AppMethodBeat.o(125688);
          return 0;
        }
        localay.FKS = locala.OmT.readString();
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