package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aca
  extends cvc
{
  public String GbA;
  public String GbB;
  public btm GbC;
  public LinkedList<cwt> GbD;
  public String GbE;
  public String GbF;
  public String Name;
  public int nDi;
  
  public aca()
  {
    AppMethodBeat.i(32181);
    this.GbD = new LinkedList();
    AppMethodBeat.o(32181);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32182);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbC == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(32182);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      if (this.GbA != null) {
        paramVarArgs.d(3, this.GbA);
      }
      if (this.GbB != null) {
        paramVarArgs.d(4, this.GbB);
      }
      if (this.GbC != null)
      {
        paramVarArgs.lC(5, this.GbC.computeSize());
        this.GbC.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.nDi);
      paramVarArgs.e(7, 8, this.GbD);
      if (this.GbE != null) {
        paramVarArgs.d(8, this.GbE);
      }
      if (this.GbF != null) {
        paramVarArgs.d(9, this.GbF);
      }
      AppMethodBeat.o(32182);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1021;
      }
    }
    label1021:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = paramInt;
      if (this.GbA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GbA);
      }
      paramInt = i;
      if (this.GbB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GbB);
      }
      i = paramInt;
      if (this.GbC != null) {
        i = paramInt + f.a.a.a.lB(5, this.GbC.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(6, this.nDi) + f.a.a.a.c(7, 8, this.GbD);
      paramInt = i;
      if (this.GbE != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GbE);
      }
      i = paramInt;
      if (this.GbF != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GbF);
      }
      AppMethodBeat.o(32182);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GbD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GbC == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(32182);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32182);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aca localaca = (aca)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32182);
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
            localaca.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 2: 
          localaca.Name = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 3: 
          localaca.GbA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 4: 
          localaca.GbB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaca.GbC = ((btm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 6: 
          localaca.nDi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32182);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaca.GbD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 8: 
          localaca.GbE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32182);
          return 0;
        }
        localaca.GbF = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32182);
        return 0;
      }
      AppMethodBeat.o(32182);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aca
 * JD-Core Version:    0.7.0.1
 */