package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgj
  extends com.tencent.mm.bx.a
{
  public String Fww;
  public String Fwx;
  public String Fwy;
  public int zTw;
  public int zTx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125804);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fww != null) {
        paramVarArgs.d(1, this.Fww);
      }
      if (this.Fwx != null) {
        paramVarArgs.d(2, this.Fwx);
      }
      if (this.Fwy != null) {
        paramVarArgs.d(3, this.Fwy);
      }
      paramVarArgs.aS(4, this.zTw);
      paramVarArgs.aS(5, this.zTx);
      AppMethodBeat.o(125804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fww == null) {
        break label426;
      }
    }
    label426:
    for (int i = f.a.a.b.b.a.e(1, this.Fww) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fwx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fwx);
      }
      i = paramInt;
      if (this.Fwy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fwy);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.zTw);
      int j = f.a.a.b.b.a.bz(5, this.zTx);
      AppMethodBeat.o(125804);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125804);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dgj localdgj = (dgj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125804);
          return -1;
        case 1: 
          localdgj.Fww = locala.NPN.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 2: 
          localdgj.Fwx = locala.NPN.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 3: 
          localdgj.Fwy = locala.NPN.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 4: 
          localdgj.zTw = locala.NPN.zc();
          AppMethodBeat.o(125804);
          return 0;
        }
        localdgj.zTx = locala.NPN.zc();
        AppMethodBeat.o(125804);
        return 0;
      }
      AppMethodBeat.o(125804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgj
 * JD-Core Version:    0.7.0.1
 */