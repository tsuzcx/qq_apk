package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ani
  extends cvc
{
  public alk Gle;
  public LinkedList<alz> GmA;
  public LinkedList<aly> GmB;
  public LinkedList<alw> GmC;
  public LinkedList<String> Gmx;
  public int Gmy;
  public String Gmz;
  
  public ani()
  {
    AppMethodBeat.i(209293);
    this.Gmx = new LinkedList();
    this.GmA = new LinkedList();
    this.GmB = new LinkedList();
    this.GmC = new LinkedList();
    AppMethodBeat.o(209293);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209294);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gle != null)
      {
        paramVarArgs.lC(2, this.Gle.computeSize());
        this.Gle.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 1, this.Gmx);
      paramVarArgs.aS(4, this.Gmy);
      if (this.Gmz != null) {
        paramVarArgs.d(5, this.Gmz);
      }
      paramVarArgs.e(6, 8, this.GmA);
      paramVarArgs.e(7, 8, this.GmB);
      paramVarArgs.e(8, 8, this.GmC);
      AppMethodBeat.o(209294);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1054;
      }
    }
    label1054:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gle != null) {
        i = paramInt + f.a.a.a.lB(2, this.Gle.computeSize());
      }
      i = i + f.a.a.a.c(3, 1, this.Gmx) + f.a.a.b.b.a.bz(4, this.Gmy);
      paramInt = i;
      if (this.Gmz != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gmz);
      }
      i = f.a.a.a.c(6, 8, this.GmA);
      int j = f.a.a.a.c(7, 8, this.GmB);
      int k = f.a.a.a.c(8, 8, this.GmC);
      AppMethodBeat.o(209294);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gmx.clear();
        this.GmA.clear();
        this.GmB.clear();
        this.GmC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209294);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ani localani = (ani)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209294);
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
            localani.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209294);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localani.Gle = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209294);
          return 0;
        case 3: 
          localani.Gmx.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(209294);
          return 0;
        case 4: 
          localani.Gmy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209294);
          return 0;
        case 5: 
          localani.Gmz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209294);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localani.GmA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209294);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aly();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aly)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localani.GmB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209294);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localani.GmC.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209294);
        return 0;
      }
      AppMethodBeat.o(209294);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ani
 * JD-Core Version:    0.7.0.1
 */