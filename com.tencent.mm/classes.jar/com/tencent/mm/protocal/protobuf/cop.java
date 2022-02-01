package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cop
  extends com.tencent.mm.bw.a
{
  public int FBB;
  public int FBC;
  public String fZq;
  public String fZr;
  public String fZs;
  public String fZt;
  public String nOF;
  public String ndw;
  public int xGK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123640);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ndw != null) {
        paramVarArgs.d(1, this.ndw);
      }
      paramVarArgs.aR(2, this.FBB);
      if (this.fZq != null) {
        paramVarArgs.d(3, this.fZq);
      }
      if (this.fZr != null) {
        paramVarArgs.d(4, this.fZr);
      }
      paramVarArgs.aR(5, this.xGK);
      paramVarArgs.aR(6, this.FBC);
      if (this.fZs != null) {
        paramVarArgs.d(7, this.fZs);
      }
      if (this.fZt != null) {
        paramVarArgs.d(8, this.fZt);
      }
      if (this.nOF != null) {
        paramVarArgs.d(9, this.nOF);
      }
      AppMethodBeat.o(123640);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ndw == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = f.a.a.b.b.a.e(1, this.ndw) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FBB);
      paramInt = i;
      if (this.fZq != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.fZq);
      }
      i = paramInt;
      if (this.fZr != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.fZr);
      }
      i = i + f.a.a.b.b.a.bx(5, this.xGK) + f.a.a.b.b.a.bx(6, this.FBC);
      paramInt = i;
      if (this.fZs != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.fZs);
      }
      i = paramInt;
      if (this.fZt != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.fZt);
      }
      paramInt = i;
      if (this.nOF != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nOF);
      }
      AppMethodBeat.o(123640);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123640);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cop localcop = (cop)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123640);
          return -1;
        case 1: 
          localcop.ndw = locala.LVo.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 2: 
          localcop.FBB = locala.LVo.xF();
          AppMethodBeat.o(123640);
          return 0;
        case 3: 
          localcop.fZq = locala.LVo.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 4: 
          localcop.fZr = locala.LVo.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 5: 
          localcop.xGK = locala.LVo.xF();
          AppMethodBeat.o(123640);
          return 0;
        case 6: 
          localcop.FBC = locala.LVo.xF();
          AppMethodBeat.o(123640);
          return 0;
        case 7: 
          localcop.fZs = locala.LVo.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 8: 
          localcop.fZt = locala.LVo.readString();
          AppMethodBeat.o(123640);
          return 0;
        }
        localcop.nOF = locala.LVo.readString();
        AppMethodBeat.o(123640);
        return 0;
      }
      AppMethodBeat.o(123640);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cop
 * JD-Core Version:    0.7.0.1
 */