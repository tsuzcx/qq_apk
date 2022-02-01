package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ehs
  extends com.tencent.mm.bw.a
{
  public String KJV;
  public String iwv;
  public int weight;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124569);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KJV != null) {
        paramVarArgs.e(1, this.KJV);
      }
      if (this.iwv != null) {
        paramVarArgs.e(2, this.iwv);
      }
      paramVarArgs.aM(3, this.weight);
      AppMethodBeat.o(124569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KJV == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.KJV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iwv != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.iwv);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.weight);
      AppMethodBeat.o(124569);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124569);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ehs localehs = (ehs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124569);
          return -1;
        case 1: 
          localehs.KJV = locala.UbS.readString();
          AppMethodBeat.o(124569);
          return 0;
        case 2: 
          localehs.iwv = locala.UbS.readString();
          AppMethodBeat.o(124569);
          return 0;
        }
        localehs.weight = locala.UbS.zi();
        AppMethodBeat.o(124569);
        return 0;
      }
      AppMethodBeat.o(124569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehs
 * JD-Core Version:    0.7.0.1
 */