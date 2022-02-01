package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amo
  extends com.tencent.mm.bw.a
{
  public int LxJ;
  public String iyZ;
  public String izb;
  public String izc;
  public String izd;
  public String ize;
  public String izf;
  public String izg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127460);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.iyZ != null) {
        paramVarArgs.e(1, this.iyZ);
      }
      paramVarArgs.aM(2, this.LxJ);
      if (this.izc != null) {
        paramVarArgs.e(3, this.izc);
      }
      if (this.izd != null) {
        paramVarArgs.e(4, this.izd);
      }
      if (this.izb != null) {
        paramVarArgs.e(5, this.izb);
      }
      if (this.ize != null) {
        paramVarArgs.e(6, this.ize);
      }
      if (this.izf != null) {
        paramVarArgs.e(7, this.izf);
      }
      if (this.izg != null) {
        paramVarArgs.e(8, this.izg);
      }
      AppMethodBeat.o(127460);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iyZ == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = g.a.a.b.b.a.f(1, this.iyZ) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LxJ);
      paramInt = i;
      if (this.izc != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.izc);
      }
      i = paramInt;
      if (this.izd != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.izd);
      }
      paramInt = i;
      if (this.izb != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.izb);
      }
      i = paramInt;
      if (this.ize != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.ize);
      }
      paramInt = i;
      if (this.izf != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.izf);
      }
      i = paramInt;
      if (this.izg != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.izg);
      }
      AppMethodBeat.o(127460);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127460);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        amo localamo = (amo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127460);
          return -1;
        case 1: 
          localamo.iyZ = locala.UbS.readString();
          AppMethodBeat.o(127460);
          return 0;
        case 2: 
          localamo.LxJ = locala.UbS.zi();
          AppMethodBeat.o(127460);
          return 0;
        case 3: 
          localamo.izc = locala.UbS.readString();
          AppMethodBeat.o(127460);
          return 0;
        case 4: 
          localamo.izd = locala.UbS.readString();
          AppMethodBeat.o(127460);
          return 0;
        case 5: 
          localamo.izb = locala.UbS.readString();
          AppMethodBeat.o(127460);
          return 0;
        case 6: 
          localamo.ize = locala.UbS.readString();
          AppMethodBeat.o(127460);
          return 0;
        case 7: 
          localamo.izf = locala.UbS.readString();
          AppMethodBeat.o(127460);
          return 0;
        }
        localamo.izg = locala.UbS.readString();
        AppMethodBeat.o(127460);
        return 0;
      }
      AppMethodBeat.o(127460);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amo
 * JD-Core Version:    0.7.0.1
 */