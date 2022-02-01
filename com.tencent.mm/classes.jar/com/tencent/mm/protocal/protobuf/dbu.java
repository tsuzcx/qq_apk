package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbu
  extends com.tencent.mm.bw.a
{
  public String BrH;
  public String dQx;
  public long eht;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91619);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BrH != null) {
        paramVarArgs.e(1, this.BrH);
      }
      paramVarArgs.bb(2, this.eht);
      paramVarArgs.aM(3, this.state);
      if (this.dQx != null) {
        paramVarArgs.e(4, this.dQx);
      }
      AppMethodBeat.o(91619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BrH == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = g.a.a.b.b.a.f(1, this.BrH) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.eht) + g.a.a.b.b.a.bu(3, this.state);
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dQx);
      }
      AppMethodBeat.o(91619);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91619);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dbu localdbu = (dbu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91619);
          return -1;
        case 1: 
          localdbu.BrH = locala.UbS.readString();
          AppMethodBeat.o(91619);
          return 0;
        case 2: 
          localdbu.eht = locala.UbS.zl();
          AppMethodBeat.o(91619);
          return 0;
        case 3: 
          localdbu.state = locala.UbS.zi();
          AppMethodBeat.o(91619);
          return 0;
        }
        localdbu.dQx = locala.UbS.readString();
        AppMethodBeat.o(91619);
        return 0;
      }
      AppMethodBeat.o(91619);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbu
 * JD-Core Version:    0.7.0.1
 */