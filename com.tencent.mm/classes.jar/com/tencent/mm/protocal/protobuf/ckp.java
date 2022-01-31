package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckp
  extends com.tencent.mm.bv.a
{
  public int Category;
  public String ntu;
  public int xFw;
  public LinkedList<String> xFy;
  public long xUA;
  public int xUB;
  
  public ckp()
  {
    AppMethodBeat.i(55704);
    this.xFy = new LinkedList();
    AppMethodBeat.o(55704);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55705);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ntu != null) {
        paramVarArgs.e(1, this.ntu);
      }
      paramVarArgs.am(2, this.xUA);
      paramVarArgs.aO(3, this.xFw);
      paramVarArgs.aO(4, this.xUB);
      paramVarArgs.aO(5, this.Category);
      paramVarArgs.e(6, 1, this.xFy);
      AppMethodBeat.o(55705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ntu == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = e.a.a.b.b.a.f(1, this.ntu) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.p(2, this.xUA);
      int j = e.a.a.b.b.a.bl(3, this.xFw);
      int k = e.a.a.b.b.a.bl(4, this.xUB);
      int m = e.a.a.b.b.a.bl(5, this.Category);
      int n = e.a.a.a.c(6, 1, this.xFy);
      AppMethodBeat.o(55705);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xFy.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(55705);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ckp localckp = (ckp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(55705);
          return -1;
        case 1: 
          localckp.ntu = locala.CLY.readString();
          AppMethodBeat.o(55705);
          return 0;
        case 2: 
          localckp.xUA = locala.CLY.sm();
          AppMethodBeat.o(55705);
          return 0;
        case 3: 
          localckp.xFw = locala.CLY.sl();
          AppMethodBeat.o(55705);
          return 0;
        case 4: 
          localckp.xUB = locala.CLY.sl();
          AppMethodBeat.o(55705);
          return 0;
        case 5: 
          localckp.Category = locala.CLY.sl();
          AppMethodBeat.o(55705);
          return 0;
        }
        localckp.xFy.add(locala.CLY.readString());
        AppMethodBeat.o(55705);
        return 0;
      }
      AppMethodBeat.o(55705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckp
 * JD-Core Version:    0.7.0.1
 */