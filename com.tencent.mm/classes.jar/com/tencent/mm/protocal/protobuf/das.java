package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class das
  extends com.tencent.mm.bw.a
{
  public String FNU;
  public long FNV;
  public String HJU;
  public String iKt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152690);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iKt == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.HJU == null)
      {
        paramVarArgs = new b("Not all required fields were included: verify_content");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.FNU == null)
      {
        paramVarArgs = new b("Not all required fields were included: antispam_ticket");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.iKt != null) {
        paramVarArgs.d(1, this.iKt);
      }
      if (this.HJU != null) {
        paramVarArgs.d(2, this.HJU);
      }
      if (this.FNU != null) {
        paramVarArgs.d(3, this.FNU);
      }
      paramVarArgs.aZ(4, this.FNV);
      AppMethodBeat.o(152690);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iKt == null) {
        break label522;
      }
    }
    label522:
    for (int i = f.a.a.b.b.a.e(1, this.iKt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HJU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HJU);
      }
      i = paramInt;
      if (this.FNU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FNU);
      }
      paramInt = f.a.a.b.b.a.p(4, this.FNV);
      AppMethodBeat.o(152690);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.iKt == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        if (this.HJU == null)
        {
          paramVarArgs = new b("Not all required fields were included: verify_content");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        if (this.FNU == null)
        {
          paramVarArgs = new b("Not all required fields were included: antispam_ticket");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152690);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        das localdas = (das)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152690);
          return -1;
        case 1: 
          localdas.iKt = locala.OmT.readString();
          AppMethodBeat.o(152690);
          return 0;
        case 2: 
          localdas.HJU = locala.OmT.readString();
          AppMethodBeat.o(152690);
          return 0;
        case 3: 
          localdas.FNU = locala.OmT.readString();
          AppMethodBeat.o(152690);
          return 0;
        }
        localdas.FNV = locala.OmT.zd();
        AppMethodBeat.o(152690);
        return 0;
      }
      AppMethodBeat.o(152690);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.das
 * JD-Core Version:    0.7.0.1
 */