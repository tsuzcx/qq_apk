package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqt
  extends com.tencent.mm.bx.a
{
  public String Doi;
  public long Doj;
  public LinkedList<cqp> EjF;
  public int index;
  public String pZX;
  public boolean qHI;
  public int type;
  
  public cqt()
  {
    AppMethodBeat.i(169384);
    this.EjF = new LinkedList();
    this.qHI = false;
    this.type = 0;
    this.index = -1;
    AppMethodBeat.o(169384);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169385);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pZX != null) {
        paramVarArgs.d(1, this.pZX);
      }
      paramVarArgs.aG(2, this.Doj);
      paramVarArgs.e(3, 8, this.EjF);
      if (this.Doi != null) {
        paramVarArgs.d(4, this.Doi);
      }
      paramVarArgs.bg(5, this.qHI);
      paramVarArgs.aR(6, this.type);
      paramVarArgs.aR(7, this.index);
      AppMethodBeat.o(169385);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pZX == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.pZX) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.Doj) + f.a.a.a.c(3, 8, this.EjF);
      paramInt = i;
      if (this.Doi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Doi);
      }
      i = f.a.a.b.b.a.fY(5);
      int j = f.a.a.b.b.a.bA(6, this.type);
      int k = f.a.a.b.b.a.bA(7, this.index);
      AppMethodBeat.o(169385);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EjF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169385);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqt localcqt = (cqt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169385);
          return -1;
        case 1: 
          localcqt.pZX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169385);
          return 0;
        case 2: 
          localcqt.Doj = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169385);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cqp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqt.EjF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169385);
          return 0;
        case 4: 
          localcqt.Doi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169385);
          return 0;
        case 5: 
          localcqt.qHI = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(169385);
          return 0;
        case 6: 
          localcqt.type = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169385);
          return 0;
        }
        localcqt.index = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(169385);
        return 0;
      }
      AppMethodBeat.o(169385);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqt
 * JD-Core Version:    0.7.0.1
 */