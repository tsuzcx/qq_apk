package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aoo
  extends cvp
{
  public asg Gni;
  public int Gnj;
  public ckw Gnk;
  public int continueFlag;
  public com.tencent.mm.bx.b lastBuffer;
  public LinkedList<FinderObject> object;
  public long rTp;
  public cta saJ;
  
  public aoo()
  {
    AppMethodBeat.i(168991);
    this.object = new LinkedList();
    AppMethodBeat.o(168991);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168992);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(168992);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aS(4, this.continueFlag);
      paramVarArgs.aY(5, this.rTp);
      if (this.Gni != null)
      {
        paramVarArgs.lC(6, this.Gni.computeSize());
        this.Gni.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.Gnj);
      if (this.saJ != null)
      {
        paramVarArgs.lC(8, this.saJ.computeSize());
        this.saJ.writeFields(paramVarArgs);
      }
      if (this.Gnk != null)
      {
        paramVarArgs.lC(9, this.Gnk.computeSize());
        this.Gnk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168992);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1158;
      }
    }
    label1158:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.continueFlag) + f.a.a.b.b.a.p(5, this.rTp);
      paramInt = i;
      if (this.Gni != null) {
        paramInt = i + f.a.a.a.lB(6, this.Gni.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.Gnj);
      paramInt = i;
      if (this.saJ != null) {
        paramInt = i + f.a.a.a.lB(8, this.saJ.computeSize());
      }
      i = paramInt;
      if (this.Gnk != null) {
        i = paramInt + f.a.a.a.lB(9, this.Gnk.computeSize());
      }
      AppMethodBeat.o(168992);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(168992);
          throw paramVarArgs;
        }
        AppMethodBeat.o(168992);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aoo localaoo = (aoo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168992);
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
            localaoo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoo.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 3: 
          localaoo.lastBuffer = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(168992);
          return 0;
        case 4: 
          localaoo.continueFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168992);
          return 0;
        case 5: 
          localaoo.rTp = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(168992);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new asg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((asg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoo.Gni = ((asg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 7: 
          localaoo.Gnj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168992);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cta();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cta)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoo.saJ = ((cta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ckw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ckw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaoo.Gnk = ((ckw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168992);
        return 0;
      }
      AppMethodBeat.o(168992);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoo
 * JD-Core Version:    0.7.0.1
 */