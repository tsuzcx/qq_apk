package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dk
  extends com.tencent.mm.bx.a
{
  public String doh;
  public int dtM;
  public String nTQ;
  public String tfH;
  public String tfI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.dtM);
      if (this.doh != null) {
        paramVarArgs.d(2, this.doh);
      }
      if (this.tfH != null) {
        paramVarArgs.d(3, this.tfH);
      }
      if (this.tfI != null) {
        paramVarArgs.d(4, this.tfI);
      }
      if (this.nTQ != null) {
        paramVarArgs.d(5, this.nTQ);
      }
      AppMethodBeat.o(72416);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.dtM) + 0;
      paramInt = i;
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.doh);
      }
      i = paramInt;
      if (this.tfH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tfH);
      }
      paramInt = i;
      if (this.tfI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tfI);
      }
      i = paramInt;
      if (this.nTQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nTQ);
      }
      AppMethodBeat.o(72416);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(72416);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dk localdk = (dk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72416);
        return -1;
      case 1: 
        localdk.dtM = locala.KhF.xS();
        AppMethodBeat.o(72416);
        return 0;
      case 2: 
        localdk.doh = locala.KhF.readString();
        AppMethodBeat.o(72416);
        return 0;
      case 3: 
        localdk.tfH = locala.KhF.readString();
        AppMethodBeat.o(72416);
        return 0;
      case 4: 
        localdk.tfI = locala.KhF.readString();
        AppMethodBeat.o(72416);
        return 0;
      }
      localdk.nTQ = locala.KhF.readString();
      AppMethodBeat.o(72416);
      return 0;
    }
    AppMethodBeat.o(72416);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dk
 * JD-Core Version:    0.7.0.1
 */