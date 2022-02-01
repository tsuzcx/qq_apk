package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djb
  extends com.tencent.mm.bw.a
{
  public String LRO;
  public String LuX;
  public int MNf;
  public String SmallImgUrl;
  public String UserName;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127295);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      paramVarArgs.aM(2, this.MNf);
      if (this.oUJ != null) {
        paramVarArgs.e(3, this.oUJ);
      }
      if (this.SmallImgUrl != null) {
        paramVarArgs.e(4, this.SmallImgUrl);
      }
      if (this.LuX != null) {
        paramVarArgs.e(5, this.LuX);
      }
      if (this.LRO != null) {
        paramVarArgs.e(6, this.LRO);
      }
      AppMethodBeat.o(127295);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = g.a.a.b.b.a.f(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MNf);
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.oUJ);
      }
      i = paramInt;
      if (this.SmallImgUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.SmallImgUrl);
      }
      paramInt = i;
      if (this.LuX != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LuX);
      }
      i = paramInt;
      if (this.LRO != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.LRO);
      }
      AppMethodBeat.o(127295);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127295);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        djb localdjb = (djb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127295);
          return -1;
        case 1: 
          localdjb.UserName = locala.UbS.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 2: 
          localdjb.MNf = locala.UbS.zi();
          AppMethodBeat.o(127295);
          return 0;
        case 3: 
          localdjb.oUJ = locala.UbS.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 4: 
          localdjb.SmallImgUrl = locala.UbS.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 5: 
          localdjb.LuX = locala.UbS.readString();
          AppMethodBeat.o(127295);
          return 0;
        }
        localdjb.LRO = locala.UbS.readString();
        AppMethodBeat.o(127295);
        return 0;
      }
      AppMethodBeat.o(127295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djb
 * JD-Core Version:    0.7.0.1
 */