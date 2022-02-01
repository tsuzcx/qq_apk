package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class efe
  extends com.tencent.mm.bw.a
{
  public String Gfd;
  public String HGP;
  public String MD5;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32556);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HGP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.MD5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.Gfd == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.HGP != null) {
        paramVarArgs.d(1, this.HGP);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(2, this.MD5);
      }
      if (this.Gfd != null) {
        paramVarArgs.d(3, this.Gfd);
      }
      paramVarArgs.aS(4, this.Scene);
      AppMethodBeat.o(32556);
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
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.MD5);
      }
      i = paramInt;
      if (this.Gfd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gfd);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Scene);
      AppMethodBeat.o(32556);
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
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: MD5");
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        if (this.Gfd == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32556);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        efe localefe = (efe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32556);
          return -1;
        case 1: 
          localefe.HGP = locala.OmT.readString();
          AppMethodBeat.o(32556);
          return 0;
        case 2: 
          localefe.MD5 = locala.OmT.readString();
          AppMethodBeat.o(32556);
          return 0;
        case 3: 
          localefe.Gfd = locala.OmT.readString();
          AppMethodBeat.o(32556);
          return 0;
        }
        localefe.Scene = locala.OmT.zc();
        AppMethodBeat.o(32556);
        return 0;
      }
      AppMethodBeat.o(32556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efe
 * JD-Core Version:    0.7.0.1
 */