package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class djg
  extends com.tencent.mm.bx.a
{
  public String Hye;
  public String Hyf;
  public String Hyg;
  public String Hyh;
  public String Hyi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101531);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hye == null)
      {
        paramVarArgs = new b("Not all required fields were included: videoFileMD5");
        AppMethodBeat.o(101531);
        throw paramVarArgs;
      }
      if (this.Hye != null) {
        paramVarArgs.d(1, this.Hye);
      }
      if (this.Hyf != null) {
        paramVarArgs.d(2, this.Hyf);
      }
      if (this.Hyg != null) {
        paramVarArgs.d(3, this.Hyg);
      }
      if (this.Hyh != null) {
        paramVarArgs.d(4, this.Hyh);
      }
      if (this.Hyi != null) {
        paramVarArgs.d(5, this.Hyi);
      }
      AppMethodBeat.o(101531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hye == null) {
        break label502;
      }
    }
    label502:
    for (int i = f.a.a.b.b.a.e(1, this.Hye) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hyf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hyf);
      }
      i = paramInt;
      if (this.Hyg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hyg);
      }
      paramInt = i;
      if (this.Hyh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hyh);
      }
      i = paramInt;
      if (this.Hyi != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hyi);
      }
      AppMethodBeat.o(101531);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Hye == null)
        {
          paramVarArgs = new b("Not all required fields were included: videoFileMD5");
          AppMethodBeat.o(101531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101531);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        djg localdjg = (djg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101531);
          return -1;
        case 1: 
          localdjg.Hye = locala.NPN.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 2: 
          localdjg.Hyf = locala.NPN.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 3: 
          localdjg.Hyg = locala.NPN.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 4: 
          localdjg.Hyh = locala.NPN.readString();
          AppMethodBeat.o(101531);
          return 0;
        }
        localdjg.Hyi = locala.NPN.readString();
        AppMethodBeat.o(101531);
        return 0;
      }
      AppMethodBeat.o(101531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djg
 * JD-Core Version:    0.7.0.1
 */