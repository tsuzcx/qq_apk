package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aoc
  extends cvc
{
  public alk GmL;
  public String GmM;
  public long GmN;
  public long GmO;
  public String ovm;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209309);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.scene);
      if (this.ovm != null) {
        paramVarArgs.d(3, this.ovm);
      }
      if (this.GmL != null)
      {
        paramVarArgs.lC(4, this.GmL.computeSize());
        this.GmL.writeFields(paramVarArgs);
      }
      if (this.GmM != null) {
        paramVarArgs.d(5, this.GmM);
      }
      paramVarArgs.aY(6, this.GmN);
      paramVarArgs.aY(7, this.GmO);
      AppMethodBeat.o(209309);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.scene);
      paramInt = i;
      if (this.ovm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ovm);
      }
      i = paramInt;
      if (this.GmL != null) {
        i = paramInt + f.a.a.a.lB(4, this.GmL.computeSize());
      }
      paramInt = i;
      if (this.GmM != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GmM);
      }
      i = f.a.a.b.b.a.p(6, this.GmN);
      int j = f.a.a.b.b.a.p(7, this.GmO);
      AppMethodBeat.o(209309);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209309);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aoc localaoc = (aoc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209309);
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
            localaoc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209309);
          return 0;
        case 2: 
          localaoc.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209309);
          return 0;
        case 3: 
          localaoc.ovm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209309);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoc.GmL = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209309);
          return 0;
        case 5: 
          localaoc.GmM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209309);
          return 0;
        case 6: 
          localaoc.GmN = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(209309);
          return 0;
        }
        localaoc.GmO = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(209309);
        return 0;
      }
      AppMethodBeat.o(209309);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoc
 * JD-Core Version:    0.7.0.1
 */