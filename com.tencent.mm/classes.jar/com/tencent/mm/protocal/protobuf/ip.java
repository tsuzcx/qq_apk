package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ip
  extends com.tencent.mm.bx.a
{
  public boolean FBA;
  public String FBB;
  public String FBo;
  public String FBq;
  public String dkR;
  public String uJF;
  public String xSd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19405);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uJF != null) {
        paramVarArgs.d(1, this.uJF);
      }
      if (this.xSd != null) {
        paramVarArgs.d(2, this.xSd);
      }
      if (this.dkR != null) {
        paramVarArgs.d(3, this.dkR);
      }
      paramVarArgs.bt(4, this.FBA);
      if (this.FBq != null) {
        paramVarArgs.d(5, this.FBq);
      }
      if (this.FBo != null) {
        paramVarArgs.d(6, this.FBo);
      }
      if (this.FBB != null) {
        paramVarArgs.d(7, this.FBB);
      }
      AppMethodBeat.o(19405);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uJF == null) {
        break label571;
      }
    }
    label571:
    for (int i = f.a.a.b.b.a.e(1, this.uJF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xSd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xSd);
      }
      i = paramInt;
      if (this.dkR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dkR);
      }
      i += f.a.a.b.b.a.alV(4);
      paramInt = i;
      if (this.FBq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FBq);
      }
      i = paramInt;
      if (this.FBo != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FBo);
      }
      paramInt = i;
      if (this.FBB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FBB);
      }
      AppMethodBeat.o(19405);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(19405);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ip localip = (ip)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(19405);
          return -1;
        case 1: 
          localip.uJF = locala.NPN.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 2: 
          localip.xSd = locala.NPN.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 3: 
          localip.dkR = locala.NPN.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 4: 
          localip.FBA = locala.NPN.grw();
          AppMethodBeat.o(19405);
          return 0;
        case 5: 
          localip.FBq = locala.NPN.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 6: 
          localip.FBo = locala.NPN.readString();
          AppMethodBeat.o(19405);
          return 0;
        }
        localip.FBB = locala.NPN.readString();
        AppMethodBeat.o(19405);
        return 0;
      }
      AppMethodBeat.o(19405);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ip
 * JD-Core Version:    0.7.0.1
 */