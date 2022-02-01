package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfi
  extends com.tencent.mm.bw.a
{
  public String EqH;
  public boolean FtN;
  public boolean FtO;
  public String bno;
  public String dnz;
  public String lJV;
  public String lJW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123634);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dnz != null) {
        paramVarArgs.d(1, this.dnz);
      }
      if (this.EqH != null) {
        paramVarArgs.d(2, this.EqH);
      }
      paramVarArgs.bl(3, this.FtN);
      paramVarArgs.bl(4, this.FtO);
      if (this.lJV != null) {
        paramVarArgs.d(5, this.lJV);
      }
      if (this.bno != null) {
        paramVarArgs.d(6, this.bno);
      }
      if (this.lJW != null) {
        paramVarArgs.d(7, this.lJW);
      }
      AppMethodBeat.o(123634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dnz == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = f.a.a.b.b.a.e(1, this.dnz) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EqH != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EqH);
      }
      i = i + (f.a.a.b.b.a.fK(3) + 1) + (f.a.a.b.b.a.fK(4) + 1);
      paramInt = i;
      if (this.lJV != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.lJV);
      }
      i = paramInt;
      if (this.bno != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.bno);
      }
      paramInt = i;
      if (this.lJW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.lJW);
      }
      AppMethodBeat.o(123634);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123634);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cfi localcfi = (cfi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123634);
          return -1;
        case 1: 
          localcfi.dnz = locala.LVo.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 2: 
          localcfi.EqH = locala.LVo.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 3: 
          localcfi.FtN = locala.LVo.fZX();
          AppMethodBeat.o(123634);
          return 0;
        case 4: 
          localcfi.FtO = locala.LVo.fZX();
          AppMethodBeat.o(123634);
          return 0;
        case 5: 
          localcfi.lJV = locala.LVo.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 6: 
          localcfi.bno = locala.LVo.readString();
          AppMethodBeat.o(123634);
          return 0;
        }
        localcfi.lJW = locala.LVo.readString();
        AppMethodBeat.o(123634);
        return 0;
      }
      AppMethodBeat.o(123634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfi
 * JD-Core Version:    0.7.0.1
 */