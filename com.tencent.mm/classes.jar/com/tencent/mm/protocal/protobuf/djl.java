package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djl
  extends com.tencent.mm.bx.a
{
  public int GEe;
  public String GSI;
  public int GSJ;
  public int GSU;
  public long GSV;
  public String GSW;
  public String GSX;
  public int GSY;
  public String GSZ;
  public String GTa;
  public int GTb;
  public String GTc;
  public String GTd;
  public float Hyq;
  public String Id;
  public String Url;
  public int dJd;
  public String md5;
  public int nEf;
  public int subType;
  public String taskId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118454);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      paramVarArgs.aS(2, this.nEf);
      if (this.Url != null) {
        paramVarArgs.d(3, this.Url);
      }
      paramVarArgs.aS(4, this.GEe);
      if (this.GSI != null) {
        paramVarArgs.d(5, this.GSI);
      }
      paramVarArgs.aS(6, this.GSJ);
      paramVarArgs.aS(7, this.subType);
      if (this.md5 != null) {
        paramVarArgs.d(8, this.md5);
      }
      if (this.GTd != null) {
        paramVarArgs.d(9, this.GTd);
      }
      paramVarArgs.aS(10, this.dJd);
      paramVarArgs.aS(11, this.GSU);
      paramVarArgs.aY(12, this.GSV);
      if (this.GSW != null) {
        paramVarArgs.d(13, this.GSW);
      }
      if (this.GSX != null) {
        paramVarArgs.d(14, this.GSX);
      }
      paramVarArgs.aS(15, this.GSY);
      if (this.GSZ != null) {
        paramVarArgs.d(16, this.GSZ);
      }
      if (this.GTa != null) {
        paramVarArgs.d(17, this.GTa);
      }
      paramVarArgs.aS(18, this.GTb);
      if (this.GTc != null) {
        paramVarArgs.d(19, this.GTc);
      }
      paramVarArgs.z(20, this.Hyq);
      if (this.taskId != null) {
        paramVarArgs.d(21, this.taskId);
      }
      AppMethodBeat.o(118454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label1281;
      }
    }
    label1281:
    for (paramInt = f.a.a.b.b.a.e(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nEf);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Url);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GEe);
      paramInt = i;
      if (this.GSI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GSI);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.GSJ) + f.a.a.b.b.a.bz(7, this.subType);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.md5);
      }
      i = paramInt;
      if (this.GTd != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GTd);
      }
      i = i + f.a.a.b.b.a.bz(10, this.dJd) + f.a.a.b.b.a.bz(11, this.GSU) + f.a.a.b.b.a.p(12, this.GSV);
      paramInt = i;
      if (this.GSW != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.GSW);
      }
      i = paramInt;
      if (this.GSX != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.GSX);
      }
      i += f.a.a.b.b.a.bz(15, this.GSY);
      paramInt = i;
      if (this.GSZ != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.GSZ);
      }
      i = paramInt;
      if (this.GTa != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.GTa);
      }
      i += f.a.a.b.b.a.bz(18, this.GTb);
      paramInt = i;
      if (this.GTc != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.GTc);
      }
      i = paramInt + f.a.a.b.b.a.alU(20);
      paramInt = i;
      if (this.taskId != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.taskId);
      }
      AppMethodBeat.o(118454);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(118454);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        djl localdjl = (djl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118454);
          return -1;
        case 1: 
          localdjl.Id = locala.NPN.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 2: 
          localdjl.nEf = locala.NPN.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 3: 
          localdjl.Url = locala.NPN.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 4: 
          localdjl.GEe = locala.NPN.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 5: 
          localdjl.GSI = locala.NPN.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 6: 
          localdjl.GSJ = locala.NPN.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 7: 
          localdjl.subType = locala.NPN.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 8: 
          localdjl.md5 = locala.NPN.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 9: 
          localdjl.GTd = locala.NPN.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 10: 
          localdjl.dJd = locala.NPN.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 11: 
          localdjl.GSU = locala.NPN.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 12: 
          localdjl.GSV = locala.NPN.zd();
          AppMethodBeat.o(118454);
          return 0;
        case 13: 
          localdjl.GSW = locala.NPN.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 14: 
          localdjl.GSX = locala.NPN.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 15: 
          localdjl.GSY = locala.NPN.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 16: 
          localdjl.GSZ = locala.NPN.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 17: 
          localdjl.GTa = locala.NPN.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 18: 
          localdjl.GTb = locala.NPN.zc();
          AppMethodBeat.o(118454);
          return 0;
        case 19: 
          localdjl.GTc = locala.NPN.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 20: 
          localdjl.Hyq = Float.intBitsToFloat(locala.NPN.grz());
          AppMethodBeat.o(118454);
          return 0;
        }
        localdjl.taskId = locala.NPN.readString();
        AppMethodBeat.o(118454);
        return 0;
      }
      AppMethodBeat.o(118454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djl
 * JD-Core Version:    0.7.0.1
 */