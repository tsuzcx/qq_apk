package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chy
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public String Md5;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104817);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.e(1, this.Url);
      }
      if (this.AesKey != null) {
        paramVarArgs.e(2, this.AesKey);
      }
      if (this.Md5 != null) {
        paramVarArgs.e(3, this.Md5);
      }
      AppMethodBeat.o(104817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.Url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.AesKey);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Md5);
      }
      AppMethodBeat.o(104817);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104817);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        chy localchy = (chy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104817);
          return -1;
        case 1: 
          localchy.Url = locala.UbS.readString();
          AppMethodBeat.o(104817);
          return 0;
        case 2: 
          localchy.AesKey = locala.UbS.readString();
          AppMethodBeat.o(104817);
          return 0;
        }
        localchy.Md5 = locala.UbS.readString();
        AppMethodBeat.o(104817);
        return 0;
      }
      AppMethodBeat.o(104817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chy
 * JD-Core Version:    0.7.0.1
 */