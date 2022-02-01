package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dre
  extends com.tencent.mm.bx.a
{
  public long CCn;
  public String Egc;
  public String Title;
  public String gKr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32533);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Egc == null)
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
      if (this.gKr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32533);
        throw paramVarArgs;
      }
      if (this.Egc != null) {
        paramVarArgs.d(1, this.Egc);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.gKr != null) {
        paramVarArgs.d(3, this.gKr);
      }
      paramVarArgs.aG(4, this.CCn);
      AppMethodBeat.o(32533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Egc == null) {
        break label540;
      }
    }
    label540:
    for (int i = f.a.a.b.b.a.e(1, this.Egc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.gKr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gKr);
      }
      paramInt = f.a.a.b.b.a.q(4, this.CCn);
      AppMethodBeat.o(32533);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Egc == null)
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
        if (this.gKr == null)
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
        dre localdre = (dre)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32533);
          return -1;
        case 1: 
          localdre.Egc = locala.KhF.readString();
          AppMethodBeat.o(32533);
          return 0;
        case 2: 
          localdre.Title = locala.KhF.readString();
          AppMethodBeat.o(32533);
          return 0;
        case 3: 
          localdre.gKr = locala.KhF.readString();
          AppMethodBeat.o(32533);
          return 0;
        }
        localdre.CCn = locala.KhF.xT();
        AppMethodBeat.o(32533);
        return 0;
      }
      AppMethodBeat.o(32533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dre
 * JD-Core Version:    0.7.0.1
 */