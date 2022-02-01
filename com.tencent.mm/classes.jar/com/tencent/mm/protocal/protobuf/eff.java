package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class eff
  extends com.tencent.mm.bw.a
{
  public String FZl;
  public String Gfd;
  public String HGP;
  public String MD5;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32557);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HGP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.FZl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.MD5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.Gfd == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.HGP != null) {
        paramVarArgs.d(1, this.HGP);
      }
      if (this.FZl != null) {
        paramVarArgs.d(2, this.FZl);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      if (this.Gfd != null) {
        paramVarArgs.d(4, this.Gfd);
      }
      paramVarArgs.aS(5, this.Scene);
      AppMethodBeat.o(32557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HGP == null) {
        break label649;
      }
    }
    label649:
    for (int i = f.a.a.b.b.a.e(1, this.HGP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FZl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FZl);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.MD5);
      }
      paramInt = i;
      if (this.Gfd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gfd);
      }
      i = f.a.a.b.b.a.bz(5, this.Scene);
      AppMethodBeat.o(32557);
      return paramInt + i;
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
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        if (this.FZl == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: MD5");
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        if (this.Gfd == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32557);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eff localeff = (eff)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32557);
          return -1;
        case 1: 
          localeff.HGP = locala.OmT.readString();
          AppMethodBeat.o(32557);
          return 0;
        case 2: 
          localeff.FZl = locala.OmT.readString();
          AppMethodBeat.o(32557);
          return 0;
        case 3: 
          localeff.MD5 = locala.OmT.readString();
          AppMethodBeat.o(32557);
          return 0;
        case 4: 
          localeff.Gfd = locala.OmT.readString();
          AppMethodBeat.o(32557);
          return 0;
        }
        localeff.Scene = locala.OmT.zc();
        AppMethodBeat.o(32557);
        return 0;
      }
      AppMethodBeat.o(32557);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eff
 * JD-Core Version:    0.7.0.1
 */