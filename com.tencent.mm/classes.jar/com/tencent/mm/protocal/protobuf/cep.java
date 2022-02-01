package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cep
  extends com.tencent.mm.bx.a
{
  public int GAX;
  public cer GAY;
  public int GYA;
  public ceq GYB;
  public int GYC;
  public int GYD;
  public int GYE;
  public int Gmy;
  public String app_id;
  public String iHB;
  public int vKb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152631);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iHB != null) {
        paramVarArgs.d(1, this.iHB);
      }
      paramVarArgs.aS(2, this.GYA);
      if (this.GYB != null)
      {
        paramVarArgs.lC(3, this.GYB.computeSize());
        this.GYB.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GAX);
      if (this.GAY != null)
      {
        paramVarArgs.lC(5, this.GAY.computeSize());
        this.GAY.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.GYC);
      paramVarArgs.aS(7, this.GYD);
      paramVarArgs.aS(8, this.vKb);
      paramVarArgs.aS(9, this.GYE);
      if (this.app_id != null) {
        paramVarArgs.d(10, this.app_id);
      }
      paramVarArgs.aS(11, this.Gmy);
      AppMethodBeat.o(152631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iHB == null) {
        break label898;
      }
    }
    label898:
    for (paramInt = f.a.a.b.b.a.e(1, this.iHB) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GYA);
      paramInt = i;
      if (this.GYB != null) {
        paramInt = i + f.a.a.a.lB(3, this.GYB.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GAX);
      paramInt = i;
      if (this.GAY != null) {
        paramInt = i + f.a.a.a.lB(5, this.GAY.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.GYC) + f.a.a.b.b.a.bz(7, this.GYD) + f.a.a.b.b.a.bz(8, this.vKb) + f.a.a.b.b.a.bz(9, this.GYE);
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.app_id);
      }
      i = f.a.a.b.b.a.bz(11, this.Gmy);
      AppMethodBeat.o(152631);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152631);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cep localcep = (cep)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152631);
          return -1;
        case 1: 
          localcep.iHB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152631);
          return 0;
        case 2: 
          localcep.GYA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152631);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ceq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ceq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcep.GYB = ((ceq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152631);
          return 0;
        case 4: 
          localcep.GAX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152631);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cer();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cer)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcep.GAY = ((cer)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152631);
          return 0;
        case 6: 
          localcep.GYC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152631);
          return 0;
        case 7: 
          localcep.GYD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152631);
          return 0;
        case 8: 
          localcep.vKb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152631);
          return 0;
        case 9: 
          localcep.GYE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152631);
          return 0;
        case 10: 
          localcep.app_id = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152631);
          return 0;
        }
        localcep.Gmy = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152631);
        return 0;
      }
      AppMethodBeat.o(152631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cep
 * JD-Core Version:    0.7.0.1
 */