package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auu
  extends cvc
{
  public String GsZ;
  public int Gta;
  public LinkedList<auw> Gtb;
  public int SetType;
  
  public auu()
  {
    AppMethodBeat.i(221049);
    this.Gtb = new LinkedList();
    AppMethodBeat.o(221049);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74654);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.SetType);
      if (this.GsZ != null) {
        paramVarArgs.d(3, this.GsZ);
      }
      paramVarArgs.aS(4, this.Gta);
      paramVarArgs.e(5, 8, this.Gtb);
      AppMethodBeat.o(74654);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.SetType);
      paramInt = i;
      if (this.GsZ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GsZ);
      }
      i = f.a.a.b.b.a.bz(4, this.Gta);
      int j = f.a.a.a.c(5, 8, this.Gtb);
      AppMethodBeat.o(74654);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gtb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(74654);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        auu localauu = (auu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74654);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74654);
          return 0;
        case 2: 
          localauu.SetType = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(74654);
          return 0;
        case 3: 
          localauu.GsZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(74654);
          return 0;
        case 4: 
          localauu.Gta = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(74654);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new auw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((auw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localauu.Gtb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(74654);
        return 0;
      }
      AppMethodBeat.o(74654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auu
 * JD-Core Version:    0.7.0.1
 */