package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cja
  extends com.tencent.mm.bw.a
{
  public String HvD;
  public int HvE;
  public long createTime;
  public String dzZ;
  public String hGT;
  public long nCM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(213437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dzZ != null) {
        paramVarArgs.d(1, this.dzZ);
      }
      if (this.HvD != null) {
        paramVarArgs.d(2, this.HvD);
      }
      if (this.hGT != null) {
        paramVarArgs.d(3, this.hGT);
      }
      paramVarArgs.aZ(4, this.createTime);
      paramVarArgs.aS(5, this.HvE);
      paramVarArgs.aZ(6, this.nCM);
      AppMethodBeat.o(213437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dzZ == null) {
        break label474;
      }
    }
    label474:
    for (int i = f.a.a.b.b.a.e(1, this.dzZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HvD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HvD);
      }
      i = paramInt;
      if (this.hGT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hGT);
      }
      paramInt = f.a.a.b.b.a.p(4, this.createTime);
      int j = f.a.a.b.b.a.bz(5, this.HvE);
      int k = f.a.a.b.b.a.p(6, this.nCM);
      AppMethodBeat.o(213437);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(213437);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cja localcja = (cja)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(213437);
          return -1;
        case 1: 
          localcja.dzZ = locala.OmT.readString();
          AppMethodBeat.o(213437);
          return 0;
        case 2: 
          localcja.HvD = locala.OmT.readString();
          AppMethodBeat.o(213437);
          return 0;
        case 3: 
          localcja.hGT = locala.OmT.readString();
          AppMethodBeat.o(213437);
          return 0;
        case 4: 
          localcja.createTime = locala.OmT.zd();
          AppMethodBeat.o(213437);
          return 0;
        case 5: 
          localcja.HvE = locala.OmT.zc();
          AppMethodBeat.o(213437);
          return 0;
        }
        localcja.nCM = locala.OmT.zd();
        AppMethodBeat.o(213437);
        return 0;
      }
      AppMethodBeat.o(213437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cja
 * JD-Core Version:    0.7.0.1
 */