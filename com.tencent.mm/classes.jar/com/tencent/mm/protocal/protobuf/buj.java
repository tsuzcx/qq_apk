package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buj
  extends com.tencent.mm.bx.a
{
  public String FVo;
  public String FVp;
  public String Guj;
  public int nDG;
  public String nDo;
  public String nEt;
  public String yhw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155433);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yhw != null) {
        paramVarArgs.d(1, this.yhw);
      }
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      paramVarArgs.aS(3, this.nDG);
      if (this.FVo != null) {
        paramVarArgs.d(4, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(5, this.FVp);
      }
      if (this.nEt != null) {
        paramVarArgs.d(6, this.nEt);
      }
      if (this.Guj != null) {
        paramVarArgs.d(7, this.Guj);
      }
      AppMethodBeat.o(155433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yhw == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.b.b.a.e(1, this.yhw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nDo);
      }
      i += f.a.a.b.b.a.bz(3, this.nDG);
      paramInt = i;
      if (this.FVo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FVo);
      }
      i = paramInt;
      if (this.FVp != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FVp);
      }
      paramInt = i;
      if (this.nEt != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.nEt);
      }
      i = paramInt;
      if (this.Guj != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Guj);
      }
      AppMethodBeat.o(155433);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(155433);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        buj localbuj = (buj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155433);
          return -1;
        case 1: 
          localbuj.yhw = locala.NPN.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 2: 
          localbuj.nDo = locala.NPN.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 3: 
          localbuj.nDG = locala.NPN.zc();
          AppMethodBeat.o(155433);
          return 0;
        case 4: 
          localbuj.FVo = locala.NPN.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 5: 
          localbuj.FVp = locala.NPN.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 6: 
          localbuj.nEt = locala.NPN.readString();
          AppMethodBeat.o(155433);
          return 0;
        }
        localbuj.Guj = locala.NPN.readString();
        AppMethodBeat.o(155433);
        return 0;
      }
      AppMethodBeat.o(155433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buj
 * JD-Core Version:    0.7.0.1
 */