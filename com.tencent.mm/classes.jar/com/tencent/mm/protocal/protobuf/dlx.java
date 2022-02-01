package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlx
  extends com.tencent.mm.bw.a
{
  public String MPC;
  public String dNI;
  public String gTt;
  public String path;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91668);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      if (this.MPC != null) {
        paramVarArgs.e(3, this.MPC);
      }
      if (this.path != null) {
        paramVarArgs.e(4, this.path);
      }
      if (this.gTt != null) {
        paramVarArgs.e(5, this.gTt);
      }
      AppMethodBeat.o(91668);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dNI);
      }
      i = paramInt;
      if (this.MPC != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MPC);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.path);
      }
      i = paramInt;
      if (this.gTt != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.gTt);
      }
      AppMethodBeat.o(91668);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91668);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dlx localdlx = (dlx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91668);
        return -1;
      case 1: 
        localdlx.type = locala.UbS.zi();
        AppMethodBeat.o(91668);
        return 0;
      case 2: 
        localdlx.dNI = locala.UbS.readString();
        AppMethodBeat.o(91668);
        return 0;
      case 3: 
        localdlx.MPC = locala.UbS.readString();
        AppMethodBeat.o(91668);
        return 0;
      case 4: 
        localdlx.path = locala.UbS.readString();
        AppMethodBeat.o(91668);
        return 0;
      }
      localdlx.gTt = locala.UbS.readString();
      AppMethodBeat.o(91668);
      return 0;
    }
    AppMethodBeat.o(91668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlx
 * JD-Core Version:    0.7.0.1
 */