package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class auh
  extends com.tencent.mm.bx.a
{
  public int FJz;
  public String Fvh;
  public String Gsq;
  public String Gsx;
  public String gsT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42637);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gsT == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(42637);
        throw paramVarArgs;
      }
      if (this.Gsx == null)
      {
        paramVarArgs = new b("Not all required fields were included: RecommendKey");
        AppMethodBeat.o(42637);
        throw paramVarArgs;
      }
      if (this.gsT != null) {
        paramVarArgs.d(1, this.gsT);
      }
      if (this.Gsx != null) {
        paramVarArgs.d(2, this.Gsx);
      }
      if (this.Fvh != null) {
        paramVarArgs.d(3, this.Fvh);
      }
      paramVarArgs.aS(4, this.FJz);
      if (this.Gsq != null) {
        paramVarArgs.d(5, this.Gsq);
      }
      AppMethodBeat.o(42637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gsT == null) {
        break label534;
      }
    }
    label534:
    for (int i = f.a.a.b.b.a.e(1, this.gsT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gsx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gsx);
      }
      i = paramInt;
      if (this.Fvh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fvh);
      }
      i += f.a.a.b.b.a.bz(4, this.FJz);
      paramInt = i;
      if (this.Gsq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gsq);
      }
      AppMethodBeat.o(42637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.gsT == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(42637);
          throw paramVarArgs;
        }
        if (this.Gsx == null)
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
        auh localauh = (auh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42637);
          return -1;
        case 1: 
          localauh.gsT = locala.NPN.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 2: 
          localauh.Gsx = locala.NPN.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 3: 
          localauh.Fvh = locala.NPN.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 4: 
          localauh.FJz = locala.NPN.zc();
          AppMethodBeat.o(42637);
          return 0;
        }
        localauh.Gsq = locala.NPN.readString();
        AppMethodBeat.o(42637);
        return 0;
      }
      AppMethodBeat.o(42637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auh
 * JD-Core Version:    0.7.0.1
 */