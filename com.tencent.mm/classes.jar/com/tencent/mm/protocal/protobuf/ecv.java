package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ecv
  extends com.tencent.mm.bx.a
{
  public long FAf;
  public String Hnp;
  public String Title;
  public String hDa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32533);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hnp == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32533);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(32533);
        throw paramVarArgs;
      }
      if (this.hDa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32533);
        throw paramVarArgs;
      }
      if (this.Hnp != null) {
        paramVarArgs.d(1, this.Hnp);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.hDa != null) {
        paramVarArgs.d(3, this.hDa);
      }
      paramVarArgs.aY(4, this.FAf);
      AppMethodBeat.o(32533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hnp == null) {
        break label540;
      }
    }
    label540:
    for (int i = f.a.a.b.b.a.e(1, this.Hnp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.hDa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hDa);
      }
      paramInt = f.a.a.b.b.a.p(4, this.FAf);
      AppMethodBeat.o(32533);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Hnp == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32533);
          throw paramVarArgs;
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(32533);
          throw paramVarArgs;
        }
        if (this.hDa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Content");
          AppMethodBeat.o(32533);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32533);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ecv localecv = (ecv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32533);
          return -1;
        case 1: 
          localecv.Hnp = locala.NPN.readString();
          AppMethodBeat.o(32533);
          return 0;
        case 2: 
          localecv.Title = locala.NPN.readString();
          AppMethodBeat.o(32533);
          return 0;
        case 3: 
          localecv.hDa = locala.NPN.readString();
          AppMethodBeat.o(32533);
          return 0;
        }
        localecv.FAf = locala.NPN.zd();
        AppMethodBeat.o(32533);
        return 0;
      }
      AppMethodBeat.o(32533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecv
 * JD-Core Version:    0.7.0.1
 */