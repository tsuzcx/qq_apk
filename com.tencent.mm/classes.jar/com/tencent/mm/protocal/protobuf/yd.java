package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yd
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> Gqd;
  public String Gqe;
  public long Gqf;
  public int nJA;
  
  public yd()
  {
    AppMethodBeat.i(6401);
    this.Gqd = new LinkedList();
    AppMethodBeat.o(6401);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nJA);
      paramVarArgs.e(2, 1, this.Gqd);
      if (this.Gqe != null) {
        paramVarArgs.d(3, this.Gqe);
      }
      paramVarArgs.aZ(4, this.Gqf);
      AppMethodBeat.o(6402);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nJA) + 0 + f.a.a.a.c(2, 1, this.Gqd);
      paramInt = i;
      if (this.Gqe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Gqe);
      }
      i = f.a.a.b.b.a.p(4, this.Gqf);
      AppMethodBeat.o(6402);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gqd.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(6402);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      yd localyd = (yd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(6402);
        return -1;
      case 1: 
        localyd.nJA = locala.OmT.zc();
        AppMethodBeat.o(6402);
        return 0;
      case 2: 
        localyd.Gqd.add(locala.OmT.readString());
        AppMethodBeat.o(6402);
        return 0;
      case 3: 
        localyd.Gqe = locala.OmT.readString();
        AppMethodBeat.o(6402);
        return 0;
      }
      localyd.Gqf = locala.OmT.zd();
      AppMethodBeat.o(6402);
      return 0;
    }
    AppMethodBeat.o(6402);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yd
 * JD-Core Version:    0.7.0.1
 */