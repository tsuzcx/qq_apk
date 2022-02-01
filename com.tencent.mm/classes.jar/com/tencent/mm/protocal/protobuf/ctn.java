package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctn
  extends com.tencent.mm.bw.a
{
  public String HEA;
  public String HEB;
  public String HEz;
  public String HnS;
  public String nJO;
  public String qkM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134253);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nJO != null) {
        paramVarArgs.d(1, this.nJO);
      }
      if (this.HEz != null) {
        paramVarArgs.d(2, this.HEz);
      }
      if (this.HnS != null) {
        paramVarArgs.d(3, this.HnS);
      }
      if (this.HEA != null) {
        paramVarArgs.d(4, this.HEA);
      }
      if (this.qkM != null) {
        paramVarArgs.d(5, this.qkM);
      }
      if (this.HEB != null) {
        paramVarArgs.d(6, this.HEB);
      }
      AppMethodBeat.o(134253);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nJO == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.nJO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HEz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HEz);
      }
      i = paramInt;
      if (this.HnS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HnS);
      }
      paramInt = i;
      if (this.HEA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HEA);
      }
      i = paramInt;
      if (this.qkM != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.qkM);
      }
      paramInt = i;
      if (this.HEB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HEB);
      }
      AppMethodBeat.o(134253);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(134253);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ctn localctn = (ctn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134253);
          return -1;
        case 1: 
          localctn.nJO = locala.OmT.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 2: 
          localctn.HEz = locala.OmT.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 3: 
          localctn.HnS = locala.OmT.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 4: 
          localctn.HEA = locala.OmT.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 5: 
          localctn.qkM = locala.OmT.readString();
          AppMethodBeat.o(134253);
          return 0;
        }
        localctn.HEB = locala.OmT.readString();
        AppMethodBeat.o(134253);
        return 0;
      }
      AppMethodBeat.o(134253);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctn
 * JD-Core Version:    0.7.0.1
 */