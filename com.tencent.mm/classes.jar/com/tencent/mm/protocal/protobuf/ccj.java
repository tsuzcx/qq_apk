package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccj
  extends com.tencent.mm.bw.a
{
  public String Md5;
  public String Name;
  public String Type;
  public String Url;
  public int oUq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32329);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Type != null) {
        paramVarArgs.e(1, this.Type);
      }
      paramVarArgs.aM(2, this.oUq);
      if (this.Md5 != null) {
        paramVarArgs.e(3, this.Md5);
      }
      if (this.Url != null) {
        paramVarArgs.e(4, this.Url);
      }
      if (this.Name != null) {
        paramVarArgs.e(5, this.Name);
      }
      AppMethodBeat.o(32329);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Type == null) {
        break label449;
      }
    }
    label449:
    for (paramInt = g.a.a.b.b.a.f(1, this.Type) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oUq);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Md5);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Url);
      }
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Name);
      }
      AppMethodBeat.o(32329);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32329);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ccj localccj = (ccj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32329);
          return -1;
        case 1: 
          localccj.Type = locala.UbS.readString();
          AppMethodBeat.o(32329);
          return 0;
        case 2: 
          localccj.oUq = locala.UbS.zi();
          AppMethodBeat.o(32329);
          return 0;
        case 3: 
          localccj.Md5 = locala.UbS.readString();
          AppMethodBeat.o(32329);
          return 0;
        case 4: 
          localccj.Url = locala.UbS.readString();
          AppMethodBeat.o(32329);
          return 0;
        }
        localccj.Name = locala.UbS.readString();
        AppMethodBeat.o(32329);
        return 0;
      }
      AppMethodBeat.o(32329);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccj
 * JD-Core Version:    0.7.0.1
 */