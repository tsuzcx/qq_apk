package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ano
  extends com.tencent.mm.bx.a
{
  public int CHC;
  public int DoL;
  public String DoM;
  public String DoN;
  public String hnC;
  public com.tencent.mm.bx.b mAx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50086);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hnC == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: AppId");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.mAx == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.DoN == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: EventInfo");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.hnC != null) {
        paramVarArgs.d(1, this.hnC);
      }
      paramVarArgs.aR(2, this.CHC);
      paramVarArgs.aR(3, this.DoL);
      if (this.mAx != null) {
        paramVarArgs.c(4, this.mAx);
      }
      if (this.DoM != null) {
        paramVarArgs.d(5, this.DoM);
      }
      if (this.DoN != null) {
        paramVarArgs.d(6, this.DoN);
      }
      AppMethodBeat.o(50086);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hnC == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.b.b.a.e(1, this.hnC) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CHC) + f.a.a.b.b.a.bA(3, this.DoL);
      paramInt = i;
      if (this.mAx != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.mAx);
      }
      i = paramInt;
      if (this.DoM != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DoM);
      }
      paramInt = i;
      if (this.DoN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DoN);
      }
      AppMethodBeat.o(50086);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.hnC == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: AppId");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        if (this.mAx == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        if (this.DoN == null)
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
        ano localano = (ano)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50086);
          return -1;
        case 1: 
          localano.hnC = locala.KhF.readString();
          AppMethodBeat.o(50086);
          return 0;
        case 2: 
          localano.CHC = locala.KhF.xS();
          AppMethodBeat.o(50086);
          return 0;
        case 3: 
          localano.DoL = locala.KhF.xS();
          AppMethodBeat.o(50086);
          return 0;
        case 4: 
          localano.mAx = locala.KhF.fMu();
          AppMethodBeat.o(50086);
          return 0;
        case 5: 
          localano.DoM = locala.KhF.readString();
          AppMethodBeat.o(50086);
          return 0;
        }
        localano.DoN = locala.KhF.readString();
        AppMethodBeat.o(50086);
        return 0;
      }
      AppMethodBeat.o(50086);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ano
 * JD-Core Version:    0.7.0.1
 */