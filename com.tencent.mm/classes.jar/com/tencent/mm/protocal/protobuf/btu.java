package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btu
  extends com.tencent.mm.cd.a
{
  public int RYM;
  public dyi TdO;
  public csp TdP;
  public int TdQ;
  public boolean TdR;
  public boolean TdS;
  public int TdT;
  public String ufy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175244);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TdO != null)
      {
        paramVarArgs.oE(1, this.TdO.computeSize());
        this.TdO.writeFields(paramVarArgs);
      }
      if (this.TdP != null)
      {
        paramVarArgs.oE(2, this.TdP.computeSize());
        this.TdP.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.TdQ);
      paramVarArgs.aY(4, this.RYM);
      paramVarArgs.co(5, this.TdR);
      paramVarArgs.co(6, this.TdS);
      paramVarArgs.aY(7, this.TdT);
      if (this.ufy != null) {
        paramVarArgs.f(8, this.ufy);
      }
      AppMethodBeat.o(175244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TdO == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = g.a.a.a.oD(1, this.TdO.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TdP != null) {
        i = paramInt + g.a.a.a.oD(2, this.TdP.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(3, this.TdQ) + g.a.a.b.b.a.bM(4, this.RYM) + (g.a.a.b.b.a.gL(5) + 1) + (g.a.a.b.b.a.gL(6) + 1) + g.a.a.b.b.a.bM(7, this.TdT);
      paramInt = i;
      if (this.ufy != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.ufy);
      }
      AppMethodBeat.o(175244);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(175244);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        btu localbtu = (btu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(175244);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dyi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dyi)localObject2).parseFrom((byte[])localObject1);
            }
            localbtu.TdO = ((dyi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(175244);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new csp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((csp)localObject2).parseFrom((byte[])localObject1);
            }
            localbtu.TdP = ((csp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(175244);
          return 0;
        case 3: 
          localbtu.TdQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(175244);
          return 0;
        case 4: 
          localbtu.RYM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(175244);
          return 0;
        case 5: 
          localbtu.TdR = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(175244);
          return 0;
        case 6: 
          localbtu.TdS = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(175244);
          return 0;
        case 7: 
          localbtu.TdT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(175244);
          return 0;
        }
        localbtu.ufy = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(175244);
        return 0;
      }
      AppMethodBeat.o(175244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btu
 * JD-Core Version:    0.7.0.1
 */