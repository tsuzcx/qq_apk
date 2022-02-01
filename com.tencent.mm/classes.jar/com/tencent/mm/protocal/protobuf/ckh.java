package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckh
  extends com.tencent.mm.bx.a
{
  public String FXR;
  public boolean HdS;
  public boolean HdT;
  public String bxJ;
  public String dzn;
  public String mjL;
  public String mjM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123634);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dzn != null) {
        paramVarArgs.d(1, this.dzn);
      }
      if (this.FXR != null) {
        paramVarArgs.d(2, this.FXR);
      }
      paramVarArgs.bt(3, this.HdS);
      paramVarArgs.bt(4, this.HdT);
      if (this.mjL != null) {
        paramVarArgs.d(5, this.mjL);
      }
      if (this.bxJ != null) {
        paramVarArgs.d(6, this.bxJ);
      }
      if (this.mjM != null) {
        paramVarArgs.d(7, this.mjM);
      }
      AppMethodBeat.o(123634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dzn == null) {
        break label538;
      }
    }
    label538:
    for (paramInt = f.a.a.b.b.a.e(1, this.dzn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FXR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FXR);
      }
      i = i + f.a.a.b.b.a.alV(3) + f.a.a.b.b.a.alV(4);
      paramInt = i;
      if (this.mjL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.mjL);
      }
      i = paramInt;
      if (this.bxJ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.bxJ);
      }
      paramInt = i;
      if (this.mjM != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.mjM);
      }
      AppMethodBeat.o(123634);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123634);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ckh localckh = (ckh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123634);
          return -1;
        case 1: 
          localckh.dzn = locala.NPN.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 2: 
          localckh.FXR = locala.NPN.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 3: 
          localckh.HdS = locala.NPN.grw();
          AppMethodBeat.o(123634);
          return 0;
        case 4: 
          localckh.HdT = locala.NPN.grw();
          AppMethodBeat.o(123634);
          return 0;
        case 5: 
          localckh.mjL = locala.NPN.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 6: 
          localckh.bxJ = locala.NPN.readString();
          AppMethodBeat.o(123634);
          return 0;
        }
        localckh.mjM = locala.NPN.readString();
        AppMethodBeat.o(123634);
        return 0;
      }
      AppMethodBeat.o(123634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckh
 * JD-Core Version:    0.7.0.1
 */