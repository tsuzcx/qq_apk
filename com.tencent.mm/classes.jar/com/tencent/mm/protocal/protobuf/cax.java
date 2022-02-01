package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cax
  extends com.tencent.mm.bx.a
{
  public float COI;
  public float COJ;
  public String DEN;
  public String DXk;
  public String DXl;
  public long DXm;
  public String ijO;
  public String ijV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117892);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DXk != null) {
        paramVarArgs.d(1, this.DXk);
      }
      if (this.ijV != null) {
        paramVarArgs.d(2, this.ijV);
      }
      if (this.ijO != null) {
        paramVarArgs.d(3, this.ijO);
      }
      if (this.DEN != null) {
        paramVarArgs.d(4, this.DEN);
      }
      paramVarArgs.x(5, this.COJ);
      paramVarArgs.x(6, this.COI);
      if (this.DXl != null) {
        paramVarArgs.d(7, this.DXl);
      }
      paramVarArgs.aG(8, this.DXm);
      AppMethodBeat.o(117892);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DXk == null) {
        break label592;
      }
    }
    label592:
    for (int i = f.a.a.b.b.a.e(1, this.DXk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ijV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ijV);
      }
      i = paramInt;
      if (this.ijO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ijO);
      }
      paramInt = i;
      if (this.DEN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DEN);
      }
      i = paramInt + (f.a.a.b.b.a.fY(5) + 4) + (f.a.a.b.b.a.fY(6) + 4);
      paramInt = i;
      if (this.DXl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DXl);
      }
      i = f.a.a.b.b.a.q(8, this.DXm);
      AppMethodBeat.o(117892);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117892);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cax localcax = (cax)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117892);
          return -1;
        case 1: 
          localcax.DXk = locala.KhF.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 2: 
          localcax.ijV = locala.KhF.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 3: 
          localcax.ijO = locala.KhF.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 4: 
          localcax.DEN = locala.KhF.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 5: 
          localcax.COJ = Float.intBitsToFloat(locala.KhF.fHx());
          AppMethodBeat.o(117892);
          return 0;
        case 6: 
          localcax.COI = Float.intBitsToFloat(locala.KhF.fHx());
          AppMethodBeat.o(117892);
          return 0;
        case 7: 
          localcax.DXl = locala.KhF.readString();
          AppMethodBeat.o(117892);
          return 0;
        }
        localcax.DXm = locala.KhF.xT();
        AppMethodBeat.o(117892);
        return 0;
      }
      AppMethodBeat.o(117892);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cax
 * JD-Core Version:    0.7.0.1
 */