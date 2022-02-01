package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsk
  extends com.tencent.mm.bx.a
{
  public int Gro;
  public String gsM;
  public String gsN;
  public String gsO;
  public String gsP;
  public String gsQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116336);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gsM != null) {
        paramVarArgs.d(1, this.gsM);
      }
      if (this.gsN != null) {
        paramVarArgs.d(2, this.gsN);
      }
      if (this.gsO != null) {
        paramVarArgs.d(3, this.gsO);
      }
      if (this.gsP != null) {
        paramVarArgs.d(4, this.gsP);
      }
      if (this.gsQ != null) {
        paramVarArgs.d(5, this.gsQ);
      }
      paramVarArgs.aS(6, this.Gro);
      AppMethodBeat.o(116336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gsM == null) {
        break label502;
      }
    }
    label502:
    for (int i = f.a.a.b.b.a.e(1, this.gsM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gsN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gsN);
      }
      i = paramInt;
      if (this.gsO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gsO);
      }
      paramInt = i;
      if (this.gsP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gsP);
      }
      i = paramInt;
      if (this.gsQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.gsQ);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Gro);
      AppMethodBeat.o(116336);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(116336);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bsk localbsk = (bsk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116336);
          return -1;
        case 1: 
          localbsk.gsM = locala.NPN.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 2: 
          localbsk.gsN = locala.NPN.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 3: 
          localbsk.gsO = locala.NPN.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 4: 
          localbsk.gsP = locala.NPN.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 5: 
          localbsk.gsQ = locala.NPN.readString();
          AppMethodBeat.o(116336);
          return 0;
        }
        localbsk.Gro = locala.NPN.zc();
        AppMethodBeat.o(116336);
        return 0;
      }
      AppMethodBeat.o(116336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsk
 * JD-Core Version:    0.7.0.1
 */