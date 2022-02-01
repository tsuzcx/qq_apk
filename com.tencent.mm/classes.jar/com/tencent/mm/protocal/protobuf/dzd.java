package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzd
  extends com.tencent.mm.bx.a
{
  public String HMv;
  public String HMw;
  public LinkedList<String> HMx;
  public int HMy;
  
  public dzd()
  {
    AppMethodBeat.i(147784);
    this.HMx = new LinkedList();
    AppMethodBeat.o(147784);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147785);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMv != null) {
        paramVarArgs.d(1, this.HMv);
      }
      if (this.HMw != null) {
        paramVarArgs.d(2, this.HMw);
      }
      paramVarArgs.e(3, 1, this.HMx);
      paramVarArgs.aS(4, this.HMy);
      AppMethodBeat.o(147785);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HMv == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.HMv) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HMw != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HMw);
      }
      paramInt = f.a.a.a.c(3, 1, this.HMx);
      int j = f.a.a.b.b.a.bz(4, this.HMy);
      AppMethodBeat.o(147785);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HMx.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(147785);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dzd localdzd = (dzd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147785);
          return -1;
        case 1: 
          localdzd.HMv = locala.NPN.readString();
          AppMethodBeat.o(147785);
          return 0;
        case 2: 
          localdzd.HMw = locala.NPN.readString();
          AppMethodBeat.o(147785);
          return 0;
        case 3: 
          localdzd.HMx.add(locala.NPN.readString());
          AppMethodBeat.o(147785);
          return 0;
        }
        localdzd.HMy = locala.NPN.zc();
        AppMethodBeat.o(147785);
        return 0;
      }
      AppMethodBeat.o(147785);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzd
 * JD-Core Version:    0.7.0.1
 */