package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class eem
  extends com.tencent.mm.bw.a
{
  public long FSD;
  public String HGP;
  public String Title;
  public String hFS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32533);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HGP == null)
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
      if (this.hFS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32533);
        throw paramVarArgs;
      }
      if (this.HGP != null) {
        paramVarArgs.d(1, this.HGP);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.hFS != null) {
        paramVarArgs.d(3, this.hFS);
      }
      paramVarArgs.aZ(4, this.FSD);
      AppMethodBeat.o(32533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HGP == null) {
        break label540;
      }
    }
    label540:
    for (int i = f.a.a.b.b.a.e(1, this.HGP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.hFS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hFS);
      }
      paramInt = f.a.a.b.b.a.p(4, this.FSD);
      AppMethodBeat.o(32533);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HGP == null)
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
        if (this.hFS == null)
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
        eem localeem = (eem)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32533);
          return -1;
        case 1: 
          localeem.HGP = locala.OmT.readString();
          AppMethodBeat.o(32533);
          return 0;
        case 2: 
          localeem.Title = locala.OmT.readString();
          AppMethodBeat.o(32533);
          return 0;
        case 3: 
          localeem.hFS = locala.OmT.readString();
          AppMethodBeat.o(32533);
          return 0;
        }
        localeem.FSD = locala.OmT.zd();
        AppMethodBeat.o(32533);
        return 0;
      }
      AppMethodBeat.o(32533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eem
 * JD-Core Version:    0.7.0.1
 */