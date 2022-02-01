package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class etf
  extends com.tencent.mm.bx.a
{
  public String YMe;
  public fmp ZoM;
  public float abwA;
  public long abwB;
  public eab abwz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91675);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YMe != null) {
        paramVarArgs.g(1, this.YMe);
      }
      if (this.ZoM != null)
      {
        paramVarArgs.qD(2, this.ZoM.computeSize());
        this.ZoM.writeFields(paramVarArgs);
      }
      if (this.abwz != null)
      {
        paramVarArgs.qD(3, this.abwz.computeSize());
        this.abwz.writeFields(paramVarArgs);
      }
      paramVarArgs.l(4, this.abwA);
      paramVarArgs.bv(5, this.abwB);
      AppMethodBeat.o(91675);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YMe == null) {
        break label569;
      }
    }
    label569:
    for (int i = i.a.a.b.b.a.h(1, this.YMe) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZoM != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZoM.computeSize());
      }
      i = paramInt;
      if (this.abwz != null) {
        i = paramInt + i.a.a.a.qC(3, this.abwz.computeSize());
      }
      paramInt = i.a.a.b.b.a.ko(4);
      int j = i.a.a.b.b.a.q(5, this.abwB);
      AppMethodBeat.o(91675);
      return i + (paramInt + 4) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91675);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        etf localetf = (etf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91675);
          return -1;
        case 1: 
          localetf.YMe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91675);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmp)localObject2).parseFrom((byte[])localObject1);
            }
            localetf.ZoM = ((fmp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91675);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eab();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eab)localObject2).parseFrom((byte[])localObject1);
            }
            localetf.abwz = ((eab)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91675);
          return 0;
        case 4: 
          localetf.abwA = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(91675);
          return 0;
        }
        localetf.abwB = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(91675);
        return 0;
      }
      AppMethodBeat.o(91675);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etf
 * JD-Core Version:    0.7.0.1
 */