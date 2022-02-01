package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ao
  extends com.tencent.mm.cd.a
{
  public String MFz;
  public String MGG;
  public int live_member_count;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243684);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MFz != null) {
        paramVarArgs.f(1, this.MFz);
      }
      if (this.MGG != null) {
        paramVarArgs.f(2, this.MGG);
      }
      paramVarArgs.aY(3, this.live_member_count);
      AppMethodBeat.o(243684);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MFz == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.MFz) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MGG != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.MGG);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.live_member_count);
      AppMethodBeat.o(243684);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243684);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ao localao = (ao)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(243684);
          return -1;
        case 1: 
          localao.MFz = locala.abFh.readString();
          AppMethodBeat.o(243684);
          return 0;
        case 2: 
          localao.MGG = locala.abFh.readString();
          AppMethodBeat.o(243684);
          return 0;
        }
        localao.live_member_count = locala.abFh.AK();
        AppMethodBeat.o(243684);
        return 0;
      }
      AppMethodBeat.o(243684);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ao
 * JD-Core Version:    0.7.0.1
 */