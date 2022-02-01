package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayz
  extends cvp
{
  public String Gwj;
  public int Gwk;
  public cwg Gwl;
  public String Gwm;
  public cwe Gwn;
  public long ePP;
  public int fKN;
  public String fKO;
  public int fKP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101808);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101808);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Gwj != null) {
        paramVarArgs.d(2, this.Gwj);
      }
      paramVarArgs.aS(3, this.fKN);
      if (this.fKO != null) {
        paramVarArgs.d(4, this.fKO);
      }
      paramVarArgs.aS(5, this.fKP);
      paramVarArgs.aS(6, this.Gwk);
      paramVarArgs.aY(7, this.ePP);
      if (this.Gwl != null)
      {
        paramVarArgs.lC(8, this.Gwl.computeSize());
        this.Gwl.writeFields(paramVarArgs);
      }
      if (this.Gwm != null) {
        paramVarArgs.d(9, this.Gwm);
      }
      if (this.Gwn != null)
      {
        paramVarArgs.lC(10, this.Gwn.computeSize());
        this.Gwn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1030;
      }
    }
    label1030:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gwj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Gwj);
      }
      i += f.a.a.b.b.a.bz(3, this.fKN);
      paramInt = i;
      if (this.fKO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fKO);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.fKP) + f.a.a.b.b.a.bz(6, this.Gwk) + f.a.a.b.b.a.p(7, this.ePP);
      paramInt = i;
      if (this.Gwl != null) {
        paramInt = i + f.a.a.a.lB(8, this.Gwl.computeSize());
      }
      i = paramInt;
      if (this.Gwm != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Gwm);
      }
      paramInt = i;
      if (this.Gwn != null) {
        paramInt = i + f.a.a.a.lB(10, this.Gwn.computeSize());
      }
      AppMethodBeat.o(101808);
      return paramInt;
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
          AppMethodBeat.o(101808);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101808);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayz localayz = (ayz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101808);
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
            localayz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101808);
          return 0;
        case 2: 
          localayz.Gwj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101808);
          return 0;
        case 3: 
          localayz.fKN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101808);
          return 0;
        case 4: 
          localayz.fKO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101808);
          return 0;
        case 5: 
          localayz.fKP = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101808);
          return 0;
        case 6: 
          localayz.Gwk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101808);
          return 0;
        case 7: 
          localayz.ePP = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(101808);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayz.Gwl = ((cwg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101808);
          return 0;
        case 9: 
          localayz.Gwm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101808);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localayz.Gwn = ((cwe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101808);
        return 0;
      }
      AppMethodBeat.o(101808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayz
 * JD-Core Version:    0.7.0.1
 */