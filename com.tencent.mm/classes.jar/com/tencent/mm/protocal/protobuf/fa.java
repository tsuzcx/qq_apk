package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fa
  extends com.tencent.mm.bw.a
{
  public String Id;
  public String KIq;
  public String KIr;
  public int KIs;
  public String Version;
  public String xMq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125709);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.e(1, this.Id);
      }
      if (this.Version != null) {
        paramVarArgs.e(2, this.Version);
      }
      if (this.xMq != null) {
        paramVarArgs.e(3, this.xMq);
      }
      if (this.KIq != null) {
        paramVarArgs.e(4, this.KIq);
      }
      if (this.KIr != null) {
        paramVarArgs.e(5, this.KIr);
      }
      paramVarArgs.aM(6, this.KIs);
      AppMethodBeat.o(125709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.f(1, this.Id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Version != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Version);
      }
      i = paramInt;
      if (this.xMq != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xMq);
      }
      paramInt = i;
      if (this.KIq != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KIq);
      }
      i = paramInt;
      if (this.KIr != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KIr);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.KIs);
      AppMethodBeat.o(125709);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125709);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fa localfa = (fa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125709);
          return -1;
        case 1: 
          localfa.Id = locala.UbS.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 2: 
          localfa.Version = locala.UbS.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 3: 
          localfa.xMq = locala.UbS.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 4: 
          localfa.KIq = locala.UbS.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 5: 
          localfa.KIr = locala.UbS.readString();
          AppMethodBeat.o(125709);
          return 0;
        }
        localfa.KIs = locala.UbS.zi();
        AppMethodBeat.o(125709);
        return 0;
      }
      AppMethodBeat.o(125709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fa
 * JD-Core Version:    0.7.0.1
 */