package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqp
  extends com.tencent.mm.bw.a
{
  public String dlT;
  public String uVs;
  public String yhW;
  public String yis;
  public String yit;
  public String yiu;
  public String yiv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72612);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yis != null) {
        paramVarArgs.d(1, this.yis);
      }
      if (this.yit != null) {
        paramVarArgs.d(2, this.yit);
      }
      if (this.yhW != null) {
        paramVarArgs.d(3, this.yhW);
      }
      if (this.uVs != null) {
        paramVarArgs.d(4, this.uVs);
      }
      if (this.dlT != null) {
        paramVarArgs.d(5, this.dlT);
      }
      if (this.yiu != null) {
        paramVarArgs.d(6, this.yiu);
      }
      if (this.yiv != null) {
        paramVarArgs.d(7, this.yiv);
      }
      AppMethodBeat.o(72612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yis == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.yis) + 0;; i = 0)
    {
      paramInt = i;
      if (this.yit != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.yit);
      }
      i = paramInt;
      if (this.yhW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.yhW);
      }
      paramInt = i;
      if (this.uVs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uVs);
      }
      i = paramInt;
      if (this.dlT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dlT);
      }
      paramInt = i;
      if (this.yiu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.yiu);
      }
      i = paramInt;
      if (this.yiv != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.yiv);
      }
      AppMethodBeat.o(72612);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72612);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dqp localdqp = (dqp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72612);
          return -1;
        case 1: 
          localdqp.yis = locala.OmT.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 2: 
          localdqp.yit = locala.OmT.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 3: 
          localdqp.yhW = locala.OmT.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 4: 
          localdqp.uVs = locala.OmT.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 5: 
          localdqp.dlT = locala.OmT.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 6: 
          localdqp.yiu = locala.OmT.readString();
          AppMethodBeat.o(72612);
          return 0;
        }
        localdqp.yiv = locala.OmT.readString();
        AppMethodBeat.o(72612);
        return 0;
      }
      AppMethodBeat.o(72612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqp
 * JD-Core Version:    0.7.0.1
 */