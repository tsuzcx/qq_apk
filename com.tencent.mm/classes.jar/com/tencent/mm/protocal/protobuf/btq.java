package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btq
  extends com.tencent.mm.bx.a
{
  public String FVo;
  public String FVp;
  public String Guj;
  public String nDo;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      if (this.nEt != null) {
        paramVarArgs.d(2, this.nEt);
      }
      if (this.FVo != null) {
        paramVarArgs.d(3, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(4, this.FVp);
      }
      if (this.Guj != null) {
        paramVarArgs.d(5, this.Guj);
      }
      AppMethodBeat.o(138178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.nDo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nEt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nEt);
      }
      i = paramInt;
      if (this.FVo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FVo);
      }
      paramInt = i;
      if (this.FVp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FVp);
      }
      i = paramInt;
      if (this.Guj != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Guj);
      }
      AppMethodBeat.o(138178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(138178);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        btq localbtq = (btq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138178);
          return -1;
        case 1: 
          localbtq.nDo = locala.NPN.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 2: 
          localbtq.nEt = locala.NPN.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 3: 
          localbtq.FVo = locala.NPN.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 4: 
          localbtq.FVp = locala.NPN.readString();
          AppMethodBeat.o(138178);
          return 0;
        }
        localbtq.Guj = locala.NPN.readString();
        AppMethodBeat.o(138178);
        return 0;
      }
      AppMethodBeat.o(138178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btq
 * JD-Core Version:    0.7.0.1
 */