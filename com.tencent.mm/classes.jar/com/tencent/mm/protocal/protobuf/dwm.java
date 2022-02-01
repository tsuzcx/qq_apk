package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwm
  extends com.tencent.mm.bx.a
{
  public String IcZ;
  public int Nju;
  public int YWY;
  public int ZkT;
  public int abcs;
  public int abct;
  public String abcu;
  public int abcv;
  public String abcw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32360);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IcZ != null) {
        paramVarArgs.g(1, this.IcZ);
      }
      paramVarArgs.bS(2, this.abcs);
      paramVarArgs.bS(3, this.abct);
      paramVarArgs.bS(4, this.YWY);
      if (this.abcu != null) {
        paramVarArgs.g(5, this.abcu);
      }
      paramVarArgs.bS(6, this.Nju);
      paramVarArgs.bS(7, this.abcv);
      paramVarArgs.bS(8, this.ZkT);
      if (this.abcw != null) {
        paramVarArgs.g(9, this.abcw);
      }
      AppMethodBeat.o(32360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IcZ == null) {
        break label609;
      }
    }
    label609:
    for (paramInt = i.a.a.b.b.a.h(1, this.IcZ) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abcs) + i.a.a.b.b.a.cJ(3, this.abct) + i.a.a.b.b.a.cJ(4, this.YWY);
      paramInt = i;
      if (this.abcu != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abcu);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.Nju) + i.a.a.b.b.a.cJ(7, this.abcv) + i.a.a.b.b.a.cJ(8, this.ZkT);
      paramInt = i;
      if (this.abcw != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abcw);
      }
      AppMethodBeat.o(32360);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32360);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dwm localdwm = (dwm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32360);
          return -1;
        case 1: 
          localdwm.IcZ = locala.ajGk.readString();
          AppMethodBeat.o(32360);
          return 0;
        case 2: 
          localdwm.abcs = locala.ajGk.aar();
          AppMethodBeat.o(32360);
          return 0;
        case 3: 
          localdwm.abct = locala.ajGk.aar();
          AppMethodBeat.o(32360);
          return 0;
        case 4: 
          localdwm.YWY = locala.ajGk.aar();
          AppMethodBeat.o(32360);
          return 0;
        case 5: 
          localdwm.abcu = locala.ajGk.readString();
          AppMethodBeat.o(32360);
          return 0;
        case 6: 
          localdwm.Nju = locala.ajGk.aar();
          AppMethodBeat.o(32360);
          return 0;
        case 7: 
          localdwm.abcv = locala.ajGk.aar();
          AppMethodBeat.o(32360);
          return 0;
        case 8: 
          localdwm.ZkT = locala.ajGk.aar();
          AppMethodBeat.o(32360);
          return 0;
        }
        localdwm.abcw = locala.ajGk.readString();
        AppMethodBeat.o(32360);
        return 0;
      }
      AppMethodBeat.o(32360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwm
 * JD-Core Version:    0.7.0.1
 */