package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class wv
  extends cvp
{
  public efu FWe;
  public boolean FWf;
  public String FWg;
  public String FWh;
  public boolean FWi;
  public String FWj;
  public String FWk;
  public String FWl;
  public String FWm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123562);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FWe != null)
      {
        paramVarArgs.lC(2, this.FWe.computeSize());
        this.FWe.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(3, this.FWf);
      if (this.FWg != null) {
        paramVarArgs.d(4, this.FWg);
      }
      if (this.FWh != null) {
        paramVarArgs.d(5, this.FWh);
      }
      paramVarArgs.bt(6, this.FWi);
      if (this.FWj != null) {
        paramVarArgs.d(7, this.FWj);
      }
      if (this.FWk != null) {
        paramVarArgs.d(8, this.FWk);
      }
      if (this.FWl != null) {
        paramVarArgs.d(9, this.FWl);
      }
      if (this.FWm != null) {
        paramVarArgs.d(10, this.FWm);
      }
      AppMethodBeat.o(123562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label962;
      }
    }
    label962:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FWe != null) {
        i = paramInt + f.a.a.a.lB(2, this.FWe.computeSize());
      }
      i += f.a.a.b.b.a.alV(3);
      paramInt = i;
      if (this.FWg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FWg);
      }
      i = paramInt;
      if (this.FWh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FWh);
      }
      i += f.a.a.b.b.a.alV(6);
      paramInt = i;
      if (this.FWj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FWj);
      }
      i = paramInt;
      if (this.FWk != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FWk);
      }
      paramInt = i;
      if (this.FWl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FWl);
      }
      i = paramInt;
      if (this.FWm != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FWm);
      }
      AppMethodBeat.o(123562);
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
          AppMethodBeat.o(123562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wv localwv = (wv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123562);
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
            localwv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123562);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((efu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwv.FWe = ((efu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123562);
          return 0;
        case 3: 
          localwv.FWf = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(123562);
          return 0;
        case 4: 
          localwv.FWg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 5: 
          localwv.FWh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 6: 
          localwv.FWi = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(123562);
          return 0;
        case 7: 
          localwv.FWj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 8: 
          localwv.FWk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 9: 
          localwv.FWl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123562);
          return 0;
        }
        localwv.FWm = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123562);
        return 0;
      }
      AppMethodBeat.o(123562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wv
 * JD-Core Version:    0.7.0.1
 */