package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dux
  extends cvc
{
  public String Daf;
  public String FzC;
  public LinkedList<Integer> HqA;
  public String HqB;
  public String HqC;
  public String HqE;
  public String dkR;
  public String dpf;
  public String duW;
  
  public dux()
  {
    AppMethodBeat.i(123675);
    this.HqA = new LinkedList();
    AppMethodBeat.o(123675);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123676);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      paramVarArgs.e(3, 2, this.HqA);
      if (this.HqB != null) {
        paramVarArgs.d(4, this.HqB);
      }
      if (this.FzC != null) {
        paramVarArgs.d(5, this.FzC);
      }
      if (this.dpf != null) {
        paramVarArgs.d(6, this.dpf);
      }
      if (this.Daf != null) {
        paramVarArgs.d(7, this.Daf);
      }
      if (this.HqE != null) {
        paramVarArgs.d(8, this.HqE);
      }
      if (this.dkR != null) {
        paramVarArgs.d(9, this.dkR);
      }
      if (this.HqC != null) {
        paramVarArgs.d(10, this.HqC);
      }
      AppMethodBeat.o(123676);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label861;
      }
    }
    label861:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.duW);
      }
      i += f.a.a.a.c(3, 2, this.HqA);
      paramInt = i;
      if (this.HqB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HqB);
      }
      i = paramInt;
      if (this.FzC != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FzC);
      }
      paramInt = i;
      if (this.dpf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dpf);
      }
      i = paramInt;
      if (this.Daf != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Daf);
      }
      paramInt = i;
      if (this.HqE != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HqE);
      }
      i = paramInt;
      if (this.dkR != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.dkR);
      }
      paramInt = i;
      if (this.HqC != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.HqC);
      }
      AppMethodBeat.o(123676);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HqA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123676);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dux localdux = (dux)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123676);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdux.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123676);
          return 0;
        case 2: 
          localdux.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123676);
          return 0;
        case 3: 
          localdux.HqA.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
          AppMethodBeat.o(123676);
          return 0;
        case 4: 
          localdux.HqB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123676);
          return 0;
        case 5: 
          localdux.FzC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123676);
          return 0;
        case 6: 
          localdux.dpf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123676);
          return 0;
        case 7: 
          localdux.Daf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123676);
          return 0;
        case 8: 
          localdux.HqE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123676);
          return 0;
        case 9: 
          localdux.dkR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123676);
          return 0;
        }
        localdux.HqC = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123676);
        return 0;
      }
      AppMethodBeat.o(123676);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dux
 * JD-Core Version:    0.7.0.1
 */