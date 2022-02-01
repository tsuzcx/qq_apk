package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cbx
  extends com.tencent.mm.bx.a
{
  public String DYi;
  public int DYj;
  public String appId;
  public int deP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153295);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.d(1, this.appId);
      }
      if (this.DYi != null) {
        paramVarArgs.d(2, this.DYi);
      }
      paramVarArgs.aR(3, this.deP);
      paramVarArgs.aR(4, this.DYj);
      AppMethodBeat.o(153295);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DYi != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DYi);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.deP);
      int j = f.a.a.b.b.a.bA(4, this.DYj);
      AppMethodBeat.o(153295);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153295);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cbx localcbx = (cbx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153295);
          return -1;
        case 1: 
          localcbx.appId = locala.KhF.readString();
          AppMethodBeat.o(153295);
          return 0;
        case 2: 
          localcbx.DYi = locala.KhF.readString();
          AppMethodBeat.o(153295);
          return 0;
        case 3: 
          localcbx.deP = locala.KhF.xS();
          AppMethodBeat.o(153295);
          return 0;
        }
        localcbx.DYj = locala.KhF.xS();
        AppMethodBeat.o(153295);
        return 0;
      }
      AppMethodBeat.o(153295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbx
 * JD-Core Version:    0.7.0.1
 */