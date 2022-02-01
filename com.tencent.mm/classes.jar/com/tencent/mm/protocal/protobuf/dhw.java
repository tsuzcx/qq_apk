package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhw
  extends cvc
{
  public com.tencent.mm.bx.b GPR;
  public String HwB;
  public String HwC;
  public String HwD;
  public int HwE;
  public int HwF;
  public int HwG;
  public int HwH;
  public dhu HwI;
  public dhu HwJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133198);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GPR == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ctx");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.HwB == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: network_type");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.HwC == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: network_info");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.HwD == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: device_info");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GPR != null) {
        paramVarArgs.c(2, this.GPR);
      }
      if (this.HwB != null) {
        paramVarArgs.d(3, this.HwB);
      }
      if (this.HwC != null) {
        paramVarArgs.d(4, this.HwC);
      }
      if (this.HwD != null) {
        paramVarArgs.d(5, this.HwD);
      }
      paramVarArgs.aS(6, this.HwE);
      paramVarArgs.aS(7, this.HwF);
      paramVarArgs.aS(8, this.HwG);
      paramVarArgs.aS(9, this.HwH);
      if (this.HwI != null)
      {
        paramVarArgs.lC(10, this.HwI.computeSize());
        this.HwI.writeFields(paramVarArgs);
      }
      if (this.HwJ != null)
      {
        paramVarArgs.lC(11, this.HwJ.computeSize());
        this.HwJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133198);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1234;
      }
    }
    label1234:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GPR != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.GPR);
      }
      i = paramInt;
      if (this.HwB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HwB);
      }
      paramInt = i;
      if (this.HwC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HwC);
      }
      i = paramInt;
      if (this.HwD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HwD);
      }
      i = i + f.a.a.b.b.a.bz(6, this.HwE) + f.a.a.b.b.a.bz(7, this.HwF) + f.a.a.b.b.a.bz(8, this.HwG) + f.a.a.b.b.a.bz(9, this.HwH);
      paramInt = i;
      if (this.HwI != null) {
        paramInt = i + f.a.a.a.lB(10, this.HwI.computeSize());
      }
      i = paramInt;
      if (this.HwJ != null) {
        i = paramInt + f.a.a.a.lB(11, this.HwJ.computeSize());
      }
      AppMethodBeat.o(133198);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GPR == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: ctx");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.HwB == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: network_type");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.HwC == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: network_info");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.HwD == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: device_info");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133198);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhw localdhw = (dhw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133198);
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
            localdhw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133198);
          return 0;
        case 2: 
          localdhw.GPR = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(133198);
          return 0;
        case 3: 
          localdhw.HwB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 4: 
          localdhw.HwC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 5: 
          localdhw.HwD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 6: 
          localdhw.HwE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133198);
          return 0;
        case 7: 
          localdhw.HwF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133198);
          return 0;
        case 8: 
          localdhw.HwG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133198);
          return 0;
        case 9: 
          localdhw.HwH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133198);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhw.HwI = ((dhu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133198);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdhw.HwJ = ((dhu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133198);
        return 0;
      }
      AppMethodBeat.o(133198);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhw
 * JD-Core Version:    0.7.0.1
 */