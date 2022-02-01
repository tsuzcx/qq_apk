package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfx
  extends com.tencent.mm.bw.a
{
  public int LOF;
  public String hid;
  public String hie;
  public String hif;
  public String hig;
  public String hih;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116336);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.hid != null) {
        paramVarArgs.e(1, this.hid);
      }
      if (this.hie != null) {
        paramVarArgs.e(2, this.hie);
      }
      if (this.hif != null) {
        paramVarArgs.e(3, this.hif);
      }
      if (this.hig != null) {
        paramVarArgs.e(4, this.hig);
      }
      if (this.hih != null) {
        paramVarArgs.e(5, this.hih);
      }
      paramVarArgs.aM(6, this.LOF);
      AppMethodBeat.o(116336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hid == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.f(1, this.hid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hie != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.hie);
      }
      i = paramInt;
      if (this.hif != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.hif);
      }
      paramInt = i;
      if (this.hig != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.hig);
      }
      i = paramInt;
      if (this.hih != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.hih);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.LOF);
      AppMethodBeat.o(116336);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(116336);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cfx localcfx = (cfx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116336);
          return -1;
        case 1: 
          localcfx.hid = locala.UbS.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 2: 
          localcfx.hie = locala.UbS.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 3: 
          localcfx.hif = locala.UbS.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 4: 
          localcfx.hig = locala.UbS.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 5: 
          localcfx.hih = locala.UbS.readString();
          AppMethodBeat.o(116336);
          return 0;
        }
        localcfx.LOF = locala.UbS.zi();
        AppMethodBeat.o(116336);
        return 0;
      }
      AppMethodBeat.o(116336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfx
 * JD-Core Version:    0.7.0.1
 */