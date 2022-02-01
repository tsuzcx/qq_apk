package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ape
  extends com.tencent.mm.bx.a
{
  public String GnN;
  public long GnO;
  public LinkedList<String> GnP;
  
  public ape()
  {
    AppMethodBeat.i(209331);
    this.GnP = new LinkedList();
    AppMethodBeat.o(209331);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GnN != null) {
        paramVarArgs.d(1, this.GnN);
      }
      paramVarArgs.aY(2, this.GnO);
      paramVarArgs.e(3, 1, this.GnP);
      AppMethodBeat.o(209332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GnN == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.GnN) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.GnO);
      int j = f.a.a.a.c(3, 1, this.GnP);
      AppMethodBeat.o(209332);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GnP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209332);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ape localape = (ape)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209332);
          return -1;
        case 1: 
          localape.GnN = locala.NPN.readString();
          AppMethodBeat.o(209332);
          return 0;
        case 2: 
          localape.GnO = locala.NPN.zd();
          AppMethodBeat.o(209332);
          return 0;
        }
        localape.GnP.add(locala.NPN.readString());
        AppMethodBeat.o(209332);
        return 0;
      }
      AppMethodBeat.o(209332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ape
 * JD-Core Version:    0.7.0.1
 */