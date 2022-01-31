package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bic
  extends com.tencent.mm.bv.a
{
  public String appId;
  public String blZ;
  public String elx;
  public String userName;
  public String wOA;
  public String wOB;
  public int xxl;
  public String xxm;
  public String xxn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80131);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.e(1, this.userName);
      }
      if (this.blZ != null) {
        paramVarArgs.e(2, this.blZ);
      }
      if (this.elx != null) {
        paramVarArgs.e(3, this.elx);
      }
      if (this.wOA != null) {
        paramVarArgs.e(4, this.wOA);
      }
      if (this.wOB != null) {
        paramVarArgs.e(5, this.wOB);
      }
      paramVarArgs.aO(6, this.xxl);
      if (this.appId != null) {
        paramVarArgs.e(7, this.appId);
      }
      if (this.xxm != null) {
        paramVarArgs.e(8, this.xxm);
      }
      if (this.xxn != null) {
        paramVarArgs.e(9, this.xxn);
      }
      AppMethodBeat.o(80131);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label686;
      }
    }
    label686:
    for (int i = e.a.a.b.b.a.f(1, this.userName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.blZ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.blZ);
      }
      i = paramInt;
      if (this.elx != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.elx);
      }
      paramInt = i;
      if (this.wOA != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wOA);
      }
      i = paramInt;
      if (this.wOB != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wOB);
      }
      i += e.a.a.b.b.a.bl(6, this.xxl);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.appId);
      }
      i = paramInt;
      if (this.xxm != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xxm);
      }
      paramInt = i;
      if (this.xxn != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xxn);
      }
      AppMethodBeat.o(80131);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80131);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bic localbic = (bic)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80131);
          return -1;
        case 1: 
          localbic.userName = locala.CLY.readString();
          AppMethodBeat.o(80131);
          return 0;
        case 2: 
          localbic.blZ = locala.CLY.readString();
          AppMethodBeat.o(80131);
          return 0;
        case 3: 
          localbic.elx = locala.CLY.readString();
          AppMethodBeat.o(80131);
          return 0;
        case 4: 
          localbic.wOA = locala.CLY.readString();
          AppMethodBeat.o(80131);
          return 0;
        case 5: 
          localbic.wOB = locala.CLY.readString();
          AppMethodBeat.o(80131);
          return 0;
        case 6: 
          localbic.xxl = locala.CLY.sl();
          AppMethodBeat.o(80131);
          return 0;
        case 7: 
          localbic.appId = locala.CLY.readString();
          AppMethodBeat.o(80131);
          return 0;
        case 8: 
          localbic.xxm = locala.CLY.readString();
          AppMethodBeat.o(80131);
          return 0;
        }
        localbic.xxn = locala.CLY.readString();
        AppMethodBeat.o(80131);
        return 0;
      }
      AppMethodBeat.o(80131);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bic
 * JD-Core Version:    0.7.0.1
 */