package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edu
  extends com.tencent.mm.bx.a
{
  public String NjO;
  public long ihV;
  public int state;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91619);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.NjO != null) {
        paramVarArgs.g(1, this.NjO);
      }
      paramVarArgs.bv(2, this.ihV);
      paramVarArgs.bS(3, this.state);
      if (this.wording != null) {
        paramVarArgs.g(4, this.wording);
      }
      AppMethodBeat.o(91619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NjO == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = i.a.a.b.b.a.h(1, this.NjO) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.ihV) + i.a.a.b.b.a.cJ(3, this.state);
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.wording);
      }
      AppMethodBeat.o(91619);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91619);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        edu localedu = (edu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91619);
          return -1;
        case 1: 
          localedu.NjO = locala.ajGk.readString();
          AppMethodBeat.o(91619);
          return 0;
        case 2: 
          localedu.ihV = locala.ajGk.aaw();
          AppMethodBeat.o(91619);
          return 0;
        case 3: 
          localedu.state = locala.ajGk.aar();
          AppMethodBeat.o(91619);
          return 0;
        }
        localedu.wording = locala.ajGk.readString();
        AppMethodBeat.o(91619);
        return 0;
      }
      AppMethodBeat.o(91619);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edu
 * JD-Core Version:    0.7.0.1
 */