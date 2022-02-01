package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dwt
  extends com.tencent.mm.bw.a
{
  public int DRa;
  public String Etg;
  public String GdA;
  public String GdB;
  public String GdC;
  public String GdD;
  public String Gdy;
  public String Gdz;
  public String eNn;
  public String ncW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32531);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gdy == null)
      {
        paramVarArgs = new b("Not all required fields were included: LocalNodeId");
        AppMethodBeat.o(32531);
        throw paramVarArgs;
      }
      if (this.Gdy != null) {
        paramVarArgs.d(1, this.Gdy);
      }
      if (this.ncW != null) {
        paramVarArgs.d(2, this.ncW);
      }
      if (this.Gdz != null) {
        paramVarArgs.d(3, this.Gdz);
      }
      if (this.eNn != null) {
        paramVarArgs.d(4, this.eNn);
      }
      if (this.GdA != null) {
        paramVarArgs.d(5, this.GdA);
      }
      if (this.Etg != null) {
        paramVarArgs.d(6, this.Etg);
      }
      if (this.GdB != null) {
        paramVarArgs.d(7, this.GdB);
      }
      if (this.GdC != null) {
        paramVarArgs.d(8, this.GdC);
      }
      if (this.GdD != null) {
        paramVarArgs.d(9, this.GdD);
      }
      paramVarArgs.aR(10, this.DRa);
      AppMethodBeat.o(32531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gdy == null) {
        break label814;
      }
    }
    label814:
    for (int i = f.a.a.b.b.a.e(1, this.Gdy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ncW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ncW);
      }
      i = paramInt;
      if (this.Gdz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gdz);
      }
      paramInt = i;
      if (this.eNn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.eNn);
      }
      i = paramInt;
      if (this.GdA != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GdA);
      }
      paramInt = i;
      if (this.Etg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Etg);
      }
      i = paramInt;
      if (this.GdB != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GdB);
      }
      paramInt = i;
      if (this.GdC != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GdC);
      }
      i = paramInt;
      if (this.GdD != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GdD);
      }
      paramInt = f.a.a.b.b.a.bx(10, this.DRa);
      AppMethodBeat.o(32531);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Gdy == null)
        {
          paramVarArgs = new b("Not all required fields were included: LocalNodeId");
          AppMethodBeat.o(32531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32531);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dwt localdwt = (dwt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32531);
          return -1;
        case 1: 
          localdwt.Gdy = locala.LVo.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 2: 
          localdwt.ncW = locala.LVo.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 3: 
          localdwt.Gdz = locala.LVo.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 4: 
          localdwt.eNn = locala.LVo.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 5: 
          localdwt.GdA = locala.LVo.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 6: 
          localdwt.Etg = locala.LVo.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 7: 
          localdwt.GdB = locala.LVo.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 8: 
          localdwt.GdC = locala.LVo.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 9: 
          localdwt.GdD = locala.LVo.readString();
          AppMethodBeat.o(32531);
          return 0;
        }
        localdwt.DRa = locala.LVo.xF();
        AppMethodBeat.o(32531);
        return 0;
      }
      AppMethodBeat.o(32531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwt
 * JD-Core Version:    0.7.0.1
 */