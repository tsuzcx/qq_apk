package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vw
  extends com.tencent.mm.bx.a
{
  public String FVn;
  public String FVo;
  public String FVp;
  public int FVq;
  public String FVr;
  public String FVs;
  public String FVt;
  public String nDo;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43087);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      if (this.nEt != null) {
        paramVarArgs.d(2, this.nEt);
      }
      if (this.FVn != null) {
        paramVarArgs.d(3, this.FVn);
      }
      if (this.FVo != null) {
        paramVarArgs.d(4, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(5, this.FVp);
      }
      paramVarArgs.aS(6, this.FVq);
      if (this.FVr != null) {
        paramVarArgs.d(7, this.FVr);
      }
      if (this.FVs != null) {
        paramVarArgs.d(10, this.FVs);
      }
      if (this.FVt != null) {
        paramVarArgs.d(11, this.FVt);
      }
      AppMethodBeat.o(43087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label694;
      }
    }
    label694:
    for (int i = f.a.a.b.b.a.e(1, this.nDo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nEt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nEt);
      }
      i = paramInt;
      if (this.FVn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FVn);
      }
      paramInt = i;
      if (this.FVo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FVo);
      }
      i = paramInt;
      if (this.FVp != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FVp);
      }
      i += f.a.a.b.b.a.bz(6, this.FVq);
      paramInt = i;
      if (this.FVr != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FVr);
      }
      i = paramInt;
      if (this.FVs != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FVs);
      }
      paramInt = i;
      if (this.FVt != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FVt);
      }
      AppMethodBeat.o(43087);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(43087);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        vw localvw = (vw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(43087);
          return -1;
        case 1: 
          localvw.nDo = locala.NPN.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 2: 
          localvw.nEt = locala.NPN.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 3: 
          localvw.FVn = locala.NPN.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 4: 
          localvw.FVo = locala.NPN.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 5: 
          localvw.FVp = locala.NPN.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 6: 
          localvw.FVq = locala.NPN.zc();
          AppMethodBeat.o(43087);
          return 0;
        case 7: 
          localvw.FVr = locala.NPN.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 10: 
          localvw.FVs = locala.NPN.readString();
          AppMethodBeat.o(43087);
          return 0;
        }
        localvw.FVt = locala.NPN.readString();
        AppMethodBeat.o(43087);
        return 0;
      }
      AppMethodBeat.o(43087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vw
 * JD-Core Version:    0.7.0.1
 */