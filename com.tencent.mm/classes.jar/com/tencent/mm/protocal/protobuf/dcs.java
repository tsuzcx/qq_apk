package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcs
  extends com.tencent.mm.bw.a
{
  public float AAH;
  public int MHY;
  public String MHf;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209796);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      if (this.MHf != null) {
        paramVarArgs.e(2, this.MHf);
      }
      paramVarArgs.aM(3, this.MHY);
      paramVarArgs.E(4, this.AAH);
      AppMethodBeat.o(209796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label365;
      }
    }
    label365:
    for (paramInt = g.a.a.b.b.a.f(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MHf != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MHf);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.MHY);
      int j = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(209796);
      return i + paramInt + (j + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209796);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dcs localdcs = (dcs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209796);
          return -1;
        case 1: 
          localdcs.Name = locala.UbS.readString();
          AppMethodBeat.o(209796);
          return 0;
        case 2: 
          localdcs.MHf = locala.UbS.readString();
          AppMethodBeat.o(209796);
          return 0;
        case 3: 
          localdcs.MHY = locala.UbS.zi();
          AppMethodBeat.o(209796);
          return 0;
        }
        localdcs.AAH = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209796);
        return 0;
      }
      AppMethodBeat.o(209796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcs
 * JD-Core Version:    0.7.0.1
 */