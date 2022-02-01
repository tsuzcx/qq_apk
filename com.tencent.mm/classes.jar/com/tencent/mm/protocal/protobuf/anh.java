package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class anh
  extends com.tencent.mm.bx.a
{
  public int CKO;
  public String Cxw;
  public String Doo;
  public String Dov;
  public String fVC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42637);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fVC == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(42637);
        throw paramVarArgs;
      }
      if (this.Dov == null)
      {
        paramVarArgs = new b("Not all required fields were included: RecommendKey");
        AppMethodBeat.o(42637);
        throw paramVarArgs;
      }
      if (this.fVC != null) {
        paramVarArgs.d(1, this.fVC);
      }
      if (this.Dov != null) {
        paramVarArgs.d(2, this.Dov);
      }
      if (this.Cxw != null) {
        paramVarArgs.d(3, this.Cxw);
      }
      paramVarArgs.aR(4, this.CKO);
      if (this.Doo != null) {
        paramVarArgs.d(5, this.Doo);
      }
      AppMethodBeat.o(42637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fVC == null) {
        break label534;
      }
    }
    label534:
    for (int i = f.a.a.b.b.a.e(1, this.fVC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Dov != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dov);
      }
      i = paramInt;
      if (this.Cxw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Cxw);
      }
      i += f.a.a.b.b.a.bA(4, this.CKO);
      paramInt = i;
      if (this.Doo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Doo);
      }
      AppMethodBeat.o(42637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.fVC == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(42637);
          throw paramVarArgs;
        }
        if (this.Dov == null)
        {
          paramVarArgs = new b("Not all required fields were included: RecommendKey");
          AppMethodBeat.o(42637);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42637);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        anh localanh = (anh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42637);
          return -1;
        case 1: 
          localanh.fVC = locala.KhF.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 2: 
          localanh.Dov = locala.KhF.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 3: 
          localanh.Cxw = locala.KhF.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 4: 
          localanh.CKO = locala.KhF.xS();
          AppMethodBeat.o(42637);
          return 0;
        }
        localanh.Doo = locala.KhF.readString();
        AppMethodBeat.o(42637);
        return 0;
      }
      AppMethodBeat.o(42637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anh
 * JD-Core Version:    0.7.0.1
 */