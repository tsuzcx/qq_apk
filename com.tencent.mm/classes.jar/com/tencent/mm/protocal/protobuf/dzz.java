package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzz
  extends com.tencent.mm.cd.a
{
  public String ROQ;
  public erh SpR;
  public dhr Ufm;
  public float Ufn;
  public long Ufo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91675);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ROQ != null) {
        paramVarArgs.f(1, this.ROQ);
      }
      if (this.SpR != null)
      {
        paramVarArgs.oE(2, this.SpR.computeSize());
        this.SpR.writeFields(paramVarArgs);
      }
      if (this.Ufm != null)
      {
        paramVarArgs.oE(3, this.Ufm.computeSize());
        this.Ufm.writeFields(paramVarArgs);
      }
      paramVarArgs.i(4, this.Ufn);
      paramVarArgs.bm(5, this.Ufo);
      AppMethodBeat.o(91675);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ROQ == null) {
        break label573;
      }
    }
    label573:
    for (int i = g.a.a.b.b.a.g(1, this.ROQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SpR != null) {
        paramInt = i + g.a.a.a.oD(2, this.SpR.computeSize());
      }
      i = paramInt;
      if (this.Ufm != null) {
        i = paramInt + g.a.a.a.oD(3, this.Ufm.computeSize());
      }
      paramInt = g.a.a.b.b.a.gL(4);
      int j = g.a.a.b.b.a.p(5, this.Ufo);
      AppMethodBeat.o(91675);
      return i + (paramInt + 4) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91675);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dzz localdzz = (dzz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91675);
          return -1;
        case 1: 
          localdzz.ROQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91675);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new erh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((erh)localObject2).parseFrom((byte[])localObject1);
            }
            localdzz.SpR = ((erh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91675);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhr)localObject2).parseFrom((byte[])localObject1);
            }
            localdzz.Ufm = ((dhr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91675);
          return 0;
        case 4: 
          localdzz.Ufn = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(91675);
          return 0;
        }
        localdzz.Ufo = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(91675);
        return 0;
      }
      AppMethodBeat.o(91675);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzz
 * JD-Core Version:    0.7.0.1
 */