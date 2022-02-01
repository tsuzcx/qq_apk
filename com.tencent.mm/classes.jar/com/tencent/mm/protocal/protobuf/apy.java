package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apy
  extends com.tencent.mm.bw.a
{
  public int DLE;
  public String DPF;
  public String DYh;
  public String EIT;
  public String EIU;
  public String EIV;
  public String EpV;
  public String ncR;
  public String ndW;
  public String tia;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32218);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPF != null) {
        paramVarArgs.d(1, this.DPF);
      }
      if (this.ndW != null) {
        paramVarArgs.d(2, this.ndW);
      }
      if (this.ncR != null) {
        paramVarArgs.d(3, this.ncR);
      }
      if (this.tia != null) {
        paramVarArgs.d(4, this.tia);
      }
      if (this.EIT != null) {
        paramVarArgs.d(5, this.EIT);
      }
      if (this.EIU != null) {
        paramVarArgs.d(6, this.EIU);
      }
      if (this.DYh != null) {
        paramVarArgs.d(7, this.DYh);
      }
      if (this.EpV != null) {
        paramVarArgs.d(8, this.EpV);
      }
      if (this.EIV != null) {
        paramVarArgs.d(9, this.EIV);
      }
      paramVarArgs.aR(10, this.DLE);
      AppMethodBeat.o(32218);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DPF == null) {
        break label766;
      }
    }
    label766:
    for (int i = f.a.a.b.b.a.e(1, this.DPF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ndW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ndW);
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ncR);
      }
      paramInt = i;
      if (this.tia != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tia);
      }
      i = paramInt;
      if (this.EIT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EIT);
      }
      paramInt = i;
      if (this.EIU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EIU);
      }
      i = paramInt;
      if (this.DYh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DYh);
      }
      paramInt = i;
      if (this.EpV != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EpV);
      }
      i = paramInt;
      if (this.EIV != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EIV);
      }
      paramInt = f.a.a.b.b.a.bx(10, this.DLE);
      AppMethodBeat.o(32218);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32218);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        apy localapy = (apy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32218);
          return -1;
        case 1: 
          localapy.DPF = locala.LVo.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 2: 
          localapy.ndW = locala.LVo.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 3: 
          localapy.ncR = locala.LVo.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 4: 
          localapy.tia = locala.LVo.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 5: 
          localapy.EIT = locala.LVo.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 6: 
          localapy.EIU = locala.LVo.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 7: 
          localapy.DYh = locala.LVo.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 8: 
          localapy.EpV = locala.LVo.readString();
          AppMethodBeat.o(32218);
          return 0;
        case 9: 
          localapy.EIV = locala.LVo.readString();
          AppMethodBeat.o(32218);
          return 0;
        }
        localapy.DLE = locala.LVo.xF();
        AppMethodBeat.o(32218);
        return 0;
      }
      AppMethodBeat.o(32218);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apy
 * JD-Core Version:    0.7.0.1
 */