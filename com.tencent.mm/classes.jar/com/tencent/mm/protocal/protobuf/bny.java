package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bny
  extends com.tencent.mm.bw.a
{
  public int EIx;
  public String fZq;
  public String fZr;
  public String fZs;
  public String fZt;
  public String fZu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116336);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fZq != null) {
        paramVarArgs.d(1, this.fZq);
      }
      if (this.fZr != null) {
        paramVarArgs.d(2, this.fZr);
      }
      if (this.fZs != null) {
        paramVarArgs.d(3, this.fZs);
      }
      if (this.fZt != null) {
        paramVarArgs.d(4, this.fZt);
      }
      if (this.fZu != null) {
        paramVarArgs.d(5, this.fZu);
      }
      paramVarArgs.aR(6, this.EIx);
      AppMethodBeat.o(116336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fZq == null) {
        break label502;
      }
    }
    label502:
    for (int i = f.a.a.b.b.a.e(1, this.fZq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fZr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fZr);
      }
      i = paramInt;
      if (this.fZs != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.fZs);
      }
      paramInt = i;
      if (this.fZt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fZt);
      }
      i = paramInt;
      if (this.fZu != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.fZu);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.EIx);
      AppMethodBeat.o(116336);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(116336);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bny localbny = (bny)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116336);
          return -1;
        case 1: 
          localbny.fZq = locala.LVo.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 2: 
          localbny.fZr = locala.LVo.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 3: 
          localbny.fZs = locala.LVo.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 4: 
          localbny.fZt = locala.LVo.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 5: 
          localbny.fZu = locala.LVo.readString();
          AppMethodBeat.o(116336);
          return 0;
        }
        localbny.EIx = locala.LVo.xF();
        AppMethodBeat.o(116336);
        return 0;
      }
      AppMethodBeat.o(116336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bny
 * JD-Core Version:    0.7.0.1
 */