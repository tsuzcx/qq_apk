package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class fdr
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public int aaMx;
  public String aanB;
  public String abDr;
  public int abDs;
  public int abDt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125773);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abDr != null) {
        paramVarArgs.g(1, this.abDr);
      }
      paramVarArgs.bS(2, this.abDs);
      if (this.UserName != null) {
        paramVarArgs.g(3, this.UserName);
      }
      if (this.aanB != null) {
        paramVarArgs.g(4, this.aanB);
      }
      paramVarArgs.bS(5, this.aaMx);
      paramVarArgs.bS(6, this.abDt);
      AppMethodBeat.o(125773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abDr == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.b.b.a.h(1, this.abDr) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abDs);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.UserName);
      }
      i = paramInt;
      if (this.aanB != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aanB);
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.aaMx);
      int j = i.a.a.b.b.a.cJ(6, this.abDt);
      AppMethodBeat.o(125773);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125773);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fdr localfdr = (fdr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125773);
          return -1;
        case 1: 
          localfdr.abDr = locala.ajGk.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 2: 
          localfdr.abDs = locala.ajGk.aar();
          AppMethodBeat.o(125773);
          return 0;
        case 3: 
          localfdr.UserName = locala.ajGk.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 4: 
          localfdr.aanB = locala.ajGk.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 5: 
          localfdr.aaMx = locala.ajGk.aar();
          AppMethodBeat.o(125773);
          return 0;
        }
        localfdr.abDt = locala.ajGk.aar();
        AppMethodBeat.o(125773);
        return 0;
      }
      AppMethodBeat.o(125773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdr
 * JD-Core Version:    0.7.0.1
 */