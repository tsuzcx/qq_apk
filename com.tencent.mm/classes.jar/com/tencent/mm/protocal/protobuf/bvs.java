package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bvs
  extends com.tencent.mm.bx.a
{
  public dwb FPc;
  public float dAp;
  public float dyz;
  public String jDf;
  public String xOD;
  public afx xPq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140927);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xOD == null)
      {
        paramVarArgs = new b("Not all required fields were included: cityName");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.jDf == null)
      {
        paramVarArgs = new b("Not all required fields were included: poiName");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.FPc == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.xOD != null) {
        paramVarArgs.d(1, this.xOD);
      }
      if (this.jDf != null) {
        paramVarArgs.d(2, this.jDf);
      }
      if (this.FPc != null)
      {
        paramVarArgs.lC(4, this.FPc.computeSize());
        this.FPc.writeFields(paramVarArgs);
      }
      paramVarArgs.z(5, this.dAp);
      paramVarArgs.z(6, this.dyz);
      if (this.xPq != null)
      {
        paramVarArgs.lC(7, this.xPq.computeSize());
        this.xPq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(140927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xOD == null) {
        break label820;
      }
    }
    label820:
    for (int i = f.a.a.b.b.a.e(1, this.xOD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jDf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.jDf);
      }
      i = paramInt;
      if (this.FPc != null) {
        i = paramInt + f.a.a.a.lB(4, this.FPc.computeSize());
      }
      i = i + f.a.a.b.b.a.alU(5) + f.a.a.b.b.a.alU(6);
      paramInt = i;
      if (this.xPq != null) {
        paramInt = i + f.a.a.a.lB(7, this.xPq.computeSize());
      }
      AppMethodBeat.o(140927);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.xOD == null)
        {
          paramVarArgs = new b("Not all required fields were included: cityName");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        if (this.jDf == null)
        {
          paramVarArgs = new b("Not all required fields were included: poiName");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        if (this.FPc == null)
        {
          paramVarArgs = new b("Not all required fields were included: matrix");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        AppMethodBeat.o(140927);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvs localbvs = (bvs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(140927);
          return -1;
        case 1: 
          localbvs.xOD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(140927);
          return 0;
        case 2: 
          localbvs.jDf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(140927);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvs.FPc = ((dwb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140927);
          return 0;
        case 5: 
          localbvs.dAp = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(140927);
          return 0;
        case 6: 
          localbvs.dyz = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(140927);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbvs.xPq = ((afx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(140927);
        return 0;
      }
      AppMethodBeat.o(140927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvs
 * JD-Core Version:    0.7.0.1
 */