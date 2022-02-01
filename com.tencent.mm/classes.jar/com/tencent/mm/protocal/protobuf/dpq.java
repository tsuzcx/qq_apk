package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpq
  extends cvc
{
  public String FpY;
  public String FvI;
  public String HDA;
  public String HDI;
  public String HDi;
  public String HDj;
  public int vls;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72609);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FpY != null) {
        paramVarArgs.d(2, this.FpY);
      }
      if (this.FvI != null) {
        paramVarArgs.d(3, this.FvI);
      }
      if (this.HDi != null) {
        paramVarArgs.d(4, this.HDi);
      }
      if (this.HDj != null) {
        paramVarArgs.d(5, this.HDj);
      }
      paramVarArgs.aS(6, this.vls);
      if (this.HDA != null) {
        paramVarArgs.d(7, this.HDA);
      }
      if (this.HDI != null) {
        paramVarArgs.d(8, this.HDI);
      }
      AppMethodBeat.o(72609);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FpY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FpY);
      }
      i = paramInt;
      if (this.FvI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FvI);
      }
      paramInt = i;
      if (this.HDi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HDi);
      }
      i = paramInt;
      if (this.HDj != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HDj);
      }
      i += f.a.a.b.b.a.bz(6, this.vls);
      paramInt = i;
      if (this.HDA != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HDA);
      }
      i = paramInt;
      if (this.HDI != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HDI);
      }
      AppMethodBeat.o(72609);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72609);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpq localdpq = (dpq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72609);
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
            localdpq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72609);
          return 0;
        case 2: 
          localdpq.FpY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 3: 
          localdpq.FvI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 4: 
          localdpq.HDi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 5: 
          localdpq.HDj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 6: 
          localdpq.vls = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72609);
          return 0;
        case 7: 
          localdpq.HDA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72609);
          return 0;
        }
        localdpq.HDI = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72609);
        return 0;
      }
      AppMethodBeat.o(72609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpq
 * JD-Core Version:    0.7.0.1
 */