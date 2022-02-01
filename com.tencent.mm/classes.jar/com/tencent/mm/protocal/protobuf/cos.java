package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cos
  extends cvp
{
  public String Cyu;
  public String Hen;
  public String Heo;
  public dmr HhA;
  public cla HhB;
  public String HhC;
  public av Hhz;
  public int ozR;
  public String ozS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72565);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72565);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      if (this.Hen != null) {
        paramVarArgs.d(4, this.Hen);
      }
      if (this.Heo != null) {
        paramVarArgs.d(5, this.Heo);
      }
      if (this.Hhz != null)
      {
        paramVarArgs.lC(6, this.Hhz.computeSize());
        this.Hhz.writeFields(paramVarArgs);
      }
      if (this.HhA != null)
      {
        paramVarArgs.lC(7, this.HhA.computeSize());
        this.HhA.writeFields(paramVarArgs);
      }
      if (this.HhB != null)
      {
        paramVarArgs.lC(8, this.HhB.computeSize());
        this.HhB.writeFields(paramVarArgs);
      }
      if (this.HhC != null) {
        paramVarArgs.d(9, this.HhC);
      }
      if (this.Cyu != null) {
        paramVarArgs.d(100, this.Cyu);
      }
      AppMethodBeat.o(72565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1210;
      }
    }
    label1210:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.Hen != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Hen);
      }
      paramInt = i;
      if (this.Heo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Heo);
      }
      i = paramInt;
      if (this.Hhz != null) {
        i = paramInt + f.a.a.a.lB(6, this.Hhz.computeSize());
      }
      paramInt = i;
      if (this.HhA != null) {
        paramInt = i + f.a.a.a.lB(7, this.HhA.computeSize());
      }
      i = paramInt;
      if (this.HhB != null) {
        i = paramInt + f.a.a.a.lB(8, this.HhB.computeSize());
      }
      paramInt = i;
      if (this.HhC != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HhC);
      }
      i = paramInt;
      if (this.Cyu != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.Cyu);
      }
      AppMethodBeat.o(72565);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72565);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72565);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cos localcos = (cos)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72565);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcos.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 2: 
          localcos.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72565);
          return 0;
        case 3: 
          localcos.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 4: 
          localcos.Hen = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 5: 
          localcos.Heo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new av();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((av)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcos.Hhz = ((av)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcos.HhA = ((dmr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cla();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cla)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcos.HhB = ((cla)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 9: 
          localcos.HhC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72565);
          return 0;
        }
        localcos.Cyu = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72565);
        return 0;
      }
      AppMethodBeat.o(72565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cos
 * JD-Core Version:    0.7.0.1
 */