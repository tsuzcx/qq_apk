package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class auo
  extends com.tencent.mm.bx.a
{
  public int FFN;
  public int GsN;
  public String GsO;
  public String GsP;
  public String iht;
  public com.tencent.mm.bx.b nCV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50086);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iht == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: AppId");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.nCV == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.GsP == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: EventInfo");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.iht != null) {
        paramVarArgs.d(1, this.iht);
      }
      paramVarArgs.aS(2, this.FFN);
      paramVarArgs.aS(3, this.GsN);
      if (this.nCV != null) {
        paramVarArgs.c(4, this.nCV);
      }
      if (this.GsO != null) {
        paramVarArgs.d(5, this.GsO);
      }
      if (this.GsP != null) {
        paramVarArgs.d(6, this.GsP);
      }
      AppMethodBeat.o(50086);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iht == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.b.b.a.e(1, this.iht) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FFN) + f.a.a.b.b.a.bz(3, this.GsN);
      paramInt = i;
      if (this.nCV != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.nCV);
      }
      i = paramInt;
      if (this.GsO != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GsO);
      }
      paramInt = i;
      if (this.GsP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GsP);
      }
      AppMethodBeat.o(50086);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.iht == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: AppId");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        if (this.nCV == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        if (this.GsP == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: EventInfo");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        AppMethodBeat.o(50086);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        auo localauo = (auo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50086);
          return -1;
        case 1: 
          localauo.iht = locala.NPN.readString();
          AppMethodBeat.o(50086);
          return 0;
        case 2: 
          localauo.FFN = locala.NPN.zc();
          AppMethodBeat.o(50086);
          return 0;
        case 3: 
          localauo.GsN = locala.NPN.zc();
          AppMethodBeat.o(50086);
          return 0;
        case 4: 
          localauo.nCV = locala.NPN.gxI();
          AppMethodBeat.o(50086);
          return 0;
        case 5: 
          localauo.GsO = locala.NPN.readString();
          AppMethodBeat.o(50086);
          return 0;
        }
        localauo.GsP = locala.NPN.readString();
        AppMethodBeat.o(50086);
        return 0;
      }
      AppMethodBeat.o(50086);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auo
 * JD-Core Version:    0.7.0.1
 */