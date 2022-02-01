package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fbt
  extends com.tencent.mm.cd.a
{
  public long SoR;
  public String UBS;
  public String UBT;
  public LinkedList<fco> UBU;
  public long UBV;
  public int UBW;
  public String UBX;
  
  public fbt()
  {
    AppMethodBeat.i(200429);
    this.UBU = new LinkedList();
    AppMethodBeat.o(200429);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200435);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UBS != null) {
        paramVarArgs.f(1, this.UBS);
      }
      paramVarArgs.bm(2, this.SoR);
      if (this.UBT != null) {
        paramVarArgs.f(3, this.UBT);
      }
      paramVarArgs.e(4, 8, this.UBU);
      paramVarArgs.bm(5, this.UBV);
      paramVarArgs.aY(6, this.UBW);
      if (this.UBX != null) {
        paramVarArgs.f(7, this.UBX);
      }
      AppMethodBeat.o(200435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UBS == null) {
        break label588;
      }
    }
    label588:
    for (paramInt = g.a.a.b.b.a.g(1, this.UBS) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.SoR);
      paramInt = i;
      if (this.UBT != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UBT);
      }
      i = paramInt + g.a.a.a.c(4, 8, this.UBU) + g.a.a.b.b.a.p(5, this.UBV) + g.a.a.b.b.a.bM(6, this.UBW);
      paramInt = i;
      if (this.UBX != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.UBX);
      }
      AppMethodBeat.o(200435);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UBU.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fbt localfbt = (fbt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200435);
          return -1;
        case 1: 
          localfbt.UBS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(200435);
          return 0;
        case 2: 
          localfbt.SoR = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(200435);
          return 0;
        case 3: 
          localfbt.UBT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(200435);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fco localfco = new fco();
            if ((localObject != null) && (localObject.length > 0)) {
              localfco.parseFrom((byte[])localObject);
            }
            localfbt.UBU.add(localfco);
            paramInt += 1;
          }
          AppMethodBeat.o(200435);
          return 0;
        case 5: 
          localfbt.UBV = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(200435);
          return 0;
        case 6: 
          localfbt.UBW = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(200435);
          return 0;
        }
        localfbt.UBX = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(200435);
        return 0;
      }
      AppMethodBeat.o(200435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbt
 * JD-Core Version:    0.7.0.1
 */