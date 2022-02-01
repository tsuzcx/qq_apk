package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvk
  extends com.tencent.mm.bx.a
{
  public String CyI;
  public String CyJ;
  public String CyK;
  public int xpm;
  public int xpn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125804);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CyI != null) {
        paramVarArgs.d(1, this.CyI);
      }
      if (this.CyJ != null) {
        paramVarArgs.d(2, this.CyJ);
      }
      if (this.CyK != null) {
        paramVarArgs.d(3, this.CyK);
      }
      paramVarArgs.aR(4, this.xpm);
      paramVarArgs.aR(5, this.xpn);
      AppMethodBeat.o(125804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CyI == null) {
        break label426;
      }
    }
    label426:
    for (int i = f.a.a.b.b.a.e(1, this.CyI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CyJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CyJ);
      }
      i = paramInt;
      if (this.CyK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CyK);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.xpm);
      int j = f.a.a.b.b.a.bA(5, this.xpn);
      AppMethodBeat.o(125804);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125804);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cvk localcvk = (cvk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125804);
          return -1;
        case 1: 
          localcvk.CyI = locala.KhF.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 2: 
          localcvk.CyJ = locala.KhF.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 3: 
          localcvk.CyK = locala.KhF.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 4: 
          localcvk.xpm = locala.KhF.xS();
          AppMethodBeat.o(125804);
          return 0;
        }
        localcvk.xpn = locala.KhF.xS();
        AppMethodBeat.o(125804);
        return 0;
      }
      AppMethodBeat.o(125804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvk
 * JD-Core Version:    0.7.0.1
 */