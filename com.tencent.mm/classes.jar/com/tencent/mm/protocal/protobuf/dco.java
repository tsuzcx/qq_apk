package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dco
  extends com.tencent.mm.bx.a
{
  public int Category;
  public int EcG;
  public LinkedList<String> EcI;
  public long EtZ;
  public int Eua;
  public String gKr;
  
  public dco()
  {
    AppMethodBeat.i(152998);
    this.EcI = new LinkedList();
    AppMethodBeat.o(152998);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152999);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gKr != null) {
        paramVarArgs.d(1, this.gKr);
      }
      paramVarArgs.aG(2, this.EtZ);
      paramVarArgs.aR(3, this.EcG);
      paramVarArgs.aR(4, this.Eua);
      paramVarArgs.aR(5, this.Category);
      paramVarArgs.e(6, 1, this.EcI);
      AppMethodBeat.o(152999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gKr == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.b.b.a.e(1, this.gKr) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.q(2, this.EtZ);
      int j = f.a.a.b.b.a.bA(3, this.EcG);
      int k = f.a.a.b.b.a.bA(4, this.Eua);
      int m = f.a.a.b.b.a.bA(5, this.Category);
      int n = f.a.a.a.c(6, 1, this.EcI);
      AppMethodBeat.o(152999);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EcI.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152999);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dco localdco = (dco)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152999);
          return -1;
        case 1: 
          localdco.gKr = locala.KhF.readString();
          AppMethodBeat.o(152999);
          return 0;
        case 2: 
          localdco.EtZ = locala.KhF.xT();
          AppMethodBeat.o(152999);
          return 0;
        case 3: 
          localdco.EcG = locala.KhF.xS();
          AppMethodBeat.o(152999);
          return 0;
        case 4: 
          localdco.Eua = locala.KhF.xS();
          AppMethodBeat.o(152999);
          return 0;
        case 5: 
          localdco.Category = locala.KhF.xS();
          AppMethodBeat.o(152999);
          return 0;
        }
        localdco.EcI.add(locala.KhF.readString());
        AppMethodBeat.o(152999);
        return 0;
      }
      AppMethodBeat.o(152999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dco
 * JD-Core Version:    0.7.0.1
 */