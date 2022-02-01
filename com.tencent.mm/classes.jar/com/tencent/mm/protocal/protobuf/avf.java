package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class avf
  extends cvc
{
  public int FCF;
  public int FxO;
  public int FzW;
  public String GtA;
  public LinkedList<ave> GtB;
  public LinkedList<b> GtC;
  public int Gtz;
  public int Scene;
  public String orm;
  
  public avf()
  {
    AppMethodBeat.i(152547);
    this.GtB = new LinkedList();
    this.GtC = new LinkedList();
    AppMethodBeat.o(152547);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152548);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FCF);
      paramVarArgs.aS(3, this.Scene);
      paramVarArgs.aS(4, this.FzW);
      paramVarArgs.aS(5, this.Gtz);
      if (this.orm != null) {
        paramVarArgs.d(6, this.orm);
      }
      if (this.GtA != null) {
        paramVarArgs.d(7, this.GtA);
      }
      paramVarArgs.aS(8, this.FxO);
      paramVarArgs.e(9, 8, this.GtB);
      paramVarArgs.e(10, 6, this.GtC);
      AppMethodBeat.o(152548);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label858;
      }
    }
    label858:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FCF) + f.a.a.b.b.a.bz(3, this.Scene) + f.a.a.b.b.a.bz(4, this.FzW) + f.a.a.b.b.a.bz(5, this.Gtz);
      paramInt = i;
      if (this.orm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.orm);
      }
      i = paramInt;
      if (this.GtA != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GtA);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.FxO);
      int j = f.a.a.a.c(9, 8, this.GtB);
      int k = f.a.a.a.c(10, 6, this.GtC);
      AppMethodBeat.o(152548);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GtB.clear();
        this.GtC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152548);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avf localavf = (avf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152548);
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
            localavf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152548);
          return 0;
        case 2: 
          localavf.FCF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152548);
          return 0;
        case 3: 
          localavf.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152548);
          return 0;
        case 4: 
          localavf.FzW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152548);
          return 0;
        case 5: 
          localavf.Gtz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152548);
          return 0;
        case 6: 
          localavf.orm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152548);
          return 0;
        case 7: 
          localavf.GtA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152548);
          return 0;
        case 8: 
          localavf.FxO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152548);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ave();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ave)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavf.GtB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152548);
          return 0;
        }
        localavf.GtC.add(((f.a.a.a.a)localObject1).NPN.gxI());
        AppMethodBeat.o(152548);
        return 0;
      }
      AppMethodBeat.o(152548);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avf
 * JD-Core Version:    0.7.0.1
 */