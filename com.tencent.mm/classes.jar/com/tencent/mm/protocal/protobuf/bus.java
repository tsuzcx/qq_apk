package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bus
  extends com.tencent.mm.bw.a
{
  public String Eof;
  public String Eog;
  public int FkA;
  public int FkB;
  public int iJT;
  public String iJU;
  public String iJV;
  public String iJW;
  public String iKc;
  public String ncR;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32348);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      paramVarArgs.aR(2, this.ndI);
      paramVarArgs.aR(3, this.iJT);
      if (this.iJV != null) {
        paramVarArgs.d(4, this.iJV);
      }
      if (this.iJU != null) {
        paramVarArgs.d(5, this.iJU);
      }
      if (this.iJW != null) {
        paramVarArgs.d(6, this.iJW);
      }
      paramVarArgs.aR(7, this.FkA);
      paramVarArgs.aR(8, this.FkB);
      if (this.iKc != null) {
        paramVarArgs.d(9, this.iKc);
      }
      if (this.Eof != null) {
        paramVarArgs.d(10, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(11, this.Eog);
      }
      AppMethodBeat.o(32348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = f.a.a.b.b.a.e(1, this.ncR) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndI) + f.a.a.b.b.a.bx(3, this.iJT);
      paramInt = i;
      if (this.iJV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iJV);
      }
      i = paramInt;
      if (this.iJU != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.iJU);
      }
      paramInt = i;
      if (this.iJW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iJW);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.FkA) + f.a.a.b.b.a.bx(8, this.FkB);
      paramInt = i;
      if (this.iKc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iKc);
      }
      i = paramInt;
      if (this.Eof != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Eof);
      }
      paramInt = i;
      if (this.Eog != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Eog);
      }
      AppMethodBeat.o(32348);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32348);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bus localbus = (bus)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32348);
          return -1;
        case 1: 
          localbus.ncR = locala.LVo.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 2: 
          localbus.ndI = locala.LVo.xF();
          AppMethodBeat.o(32348);
          return 0;
        case 3: 
          localbus.iJT = locala.LVo.xF();
          AppMethodBeat.o(32348);
          return 0;
        case 4: 
          localbus.iJV = locala.LVo.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 5: 
          localbus.iJU = locala.LVo.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 6: 
          localbus.iJW = locala.LVo.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 7: 
          localbus.FkA = locala.LVo.xF();
          AppMethodBeat.o(32348);
          return 0;
        case 8: 
          localbus.FkB = locala.LVo.xF();
          AppMethodBeat.o(32348);
          return 0;
        case 9: 
          localbus.iKc = locala.LVo.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 10: 
          localbus.Eof = locala.LVo.readString();
          AppMethodBeat.o(32348);
          return 0;
        }
        localbus.Eog = locala.LVo.readString();
        AppMethodBeat.o(32348);
        return 0;
      }
      AppMethodBeat.o(32348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bus
 * JD-Core Version:    0.7.0.1
 */