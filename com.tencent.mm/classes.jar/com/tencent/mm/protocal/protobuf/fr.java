package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class fr
  extends com.tencent.mm.bx.a
{
  public String IKJ;
  public String Id;
  public String Version;
  public String YHb;
  public String YHc;
  public int YHd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125709);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.g(1, this.Id);
      }
      if (this.Version != null) {
        paramVarArgs.g(2, this.Version);
      }
      if (this.IKJ != null) {
        paramVarArgs.g(3, this.IKJ);
      }
      if (this.YHb != null) {
        paramVarArgs.g(4, this.YHb);
      }
      if (this.YHc != null) {
        paramVarArgs.g(5, this.YHc);
      }
      paramVarArgs.bS(6, this.YHd);
      AppMethodBeat.o(125709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label498;
      }
    }
    label498:
    for (int i = i.a.a.b.b.a.h(1, this.Id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Version != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Version);
      }
      i = paramInt;
      if (this.IKJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IKJ);
      }
      paramInt = i;
      if (this.YHb != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YHb);
      }
      i = paramInt;
      if (this.YHc != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YHc);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.YHd);
      AppMethodBeat.o(125709);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125709);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fr localfr = (fr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125709);
          return -1;
        case 1: 
          localfr.Id = locala.ajGk.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 2: 
          localfr.Version = locala.ajGk.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 3: 
          localfr.IKJ = locala.ajGk.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 4: 
          localfr.YHb = locala.ajGk.readString();
          AppMethodBeat.o(125709);
          return 0;
        case 5: 
          localfr.YHc = locala.ajGk.readString();
          AppMethodBeat.o(125709);
          return 0;
        }
        localfr.YHd = locala.ajGk.aar();
        AppMethodBeat.o(125709);
        return 0;
      }
      AppMethodBeat.o(125709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fr
 * JD-Core Version:    0.7.0.1
 */