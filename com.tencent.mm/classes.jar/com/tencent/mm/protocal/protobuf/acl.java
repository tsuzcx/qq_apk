package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acl
  extends com.tencent.mm.bw.a
{
  public String Hwr;
  public String LmX;
  public String LmY;
  public String pTL;
  public int uSc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200196);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LmX != null) {
        paramVarArgs.e(1, this.LmX);
      }
      if (this.LmY != null) {
        paramVarArgs.e(2, this.LmY);
      }
      paramVarArgs.aM(3, this.uSc);
      if (this.pTL != null) {
        paramVarArgs.e(4, this.pTL);
      }
      if (this.Hwr != null) {
        paramVarArgs.e(5, this.Hwr);
      }
      AppMethodBeat.o(200196);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LmX == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = g.a.a.b.b.a.f(1, this.LmX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LmY != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LmY);
      }
      i += g.a.a.b.b.a.bu(3, this.uSc);
      paramInt = i;
      if (this.pTL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.pTL);
      }
      i = paramInt;
      if (this.Hwr != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Hwr);
      }
      AppMethodBeat.o(200196);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200196);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        acl localacl = (acl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200196);
          return -1;
        case 1: 
          localacl.LmX = locala.UbS.readString();
          AppMethodBeat.o(200196);
          return 0;
        case 2: 
          localacl.LmY = locala.UbS.readString();
          AppMethodBeat.o(200196);
          return 0;
        case 3: 
          localacl.uSc = locala.UbS.zi();
          AppMethodBeat.o(200196);
          return 0;
        case 4: 
          localacl.pTL = locala.UbS.readString();
          AppMethodBeat.o(200196);
          return 0;
        }
        localacl.Hwr = locala.UbS.readString();
        AppMethodBeat.o(200196);
        return 0;
      }
      AppMethodBeat.o(200196);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acl
 * JD-Core Version:    0.7.0.1
 */