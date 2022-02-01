package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cck
  extends com.tencent.mm.bw.a
{
  public String BvP;
  public String FqT;
  public String app_id;
  public String ofa;
  public String ofc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72540);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.d(1, this.app_id);
      }
      if (this.BvP != null) {
        paramVarArgs.d(2, this.BvP);
      }
      if (this.ofc != null) {
        paramVarArgs.d(3, this.ofc);
      }
      if (this.ofa != null) {
        paramVarArgs.d(4, this.ofa);
      }
      if (this.FqT != null) {
        paramVarArgs.d(5, this.FqT);
      }
      AppMethodBeat.o(72540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.BvP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.BvP);
      }
      i = paramInt;
      if (this.ofc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ofc);
      }
      paramInt = i;
      if (this.ofa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ofa);
      }
      i = paramInt;
      if (this.FqT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FqT);
      }
      AppMethodBeat.o(72540);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72540);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cck localcck = (cck)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72540);
          return -1;
        case 1: 
          localcck.app_id = locala.LVo.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 2: 
          localcck.BvP = locala.LVo.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 3: 
          localcck.ofc = locala.LVo.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 4: 
          localcck.ofa = locala.LVo.readString();
          AppMethodBeat.o(72540);
          return 0;
        }
        localcck.FqT = locala.LVo.readString();
        AppMethodBeat.o(72540);
        return 0;
      }
      AppMethodBeat.o(72540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cck
 * JD-Core Version:    0.7.0.1
 */