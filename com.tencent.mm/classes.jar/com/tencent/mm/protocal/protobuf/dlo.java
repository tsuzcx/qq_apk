package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlo
  extends com.tencent.mm.bx.a
{
  public String FJU;
  public LinkedList<dlp> FJV;
  public long FJW;
  public String GfK;
  public String GfL;
  public dlq HzY;
  public dls HzZ;
  
  public dlo()
  {
    AppMethodBeat.i(124556);
    this.FJV = new LinkedList();
    AppMethodBeat.o(124556);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124557);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GfK != null) {
        paramVarArgs.d(1, this.GfK);
      }
      if (this.HzY != null)
      {
        paramVarArgs.lC(2, this.HzY.computeSize());
        this.HzY.writeFields(paramVarArgs);
      }
      if (this.FJU != null) {
        paramVarArgs.d(3, this.FJU);
      }
      paramVarArgs.e(4, 8, this.FJV);
      if (this.GfL != null) {
        paramVarArgs.d(5, this.GfL);
      }
      paramVarArgs.aY(6, this.FJW);
      if (this.HzZ != null)
      {
        paramVarArgs.lC(7, this.HzZ.computeSize());
        this.HzZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GfK == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.b.b.a.e(1, this.GfK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HzY != null) {
        paramInt = i + f.a.a.a.lB(2, this.HzY.computeSize());
      }
      i = paramInt;
      if (this.FJU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FJU);
      }
      i += f.a.a.a.c(4, 8, this.FJV);
      paramInt = i;
      if (this.GfL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GfL);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.FJW);
      paramInt = i;
      if (this.HzZ != null) {
        paramInt = i + f.a.a.a.lB(7, this.HzZ.computeSize());
      }
      AppMethodBeat.o(124557);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FJV.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124557);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlo localdlo = (dlo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124557);
          return -1;
        case 1: 
          localdlo.GfK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlo.HzY = ((dlq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124557);
          return 0;
        case 3: 
          localdlo.FJU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlo.FJV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124557);
          return 0;
        case 5: 
          localdlo.GfL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 6: 
          localdlo.FJW = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(124557);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dls();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dls)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdlo.HzZ = ((dls)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124557);
        return 0;
      }
      AppMethodBeat.o(124557);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlo
 * JD-Core Version:    0.7.0.1
 */