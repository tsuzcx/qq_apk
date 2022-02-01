package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class af
  extends cvp
{
  public int FqN;
  public String FqO;
  public dej FqP;
  public css FqQ;
  public int FqX;
  public aav Frb;
  public boolean Frc;
  public int Frd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32100);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32100);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FqN);
      if (this.FqO != null) {
        paramVarArgs.d(3, this.FqO);
      }
      if (this.FqP != null)
      {
        paramVarArgs.lC(4, this.FqP.computeSize());
        this.FqP.writeFields(paramVarArgs);
      }
      if (this.FqQ != null)
      {
        paramVarArgs.lC(5, this.FqQ.computeSize());
        this.FqQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.FqX);
      if (this.Frb != null)
      {
        paramVarArgs.lC(7, this.Frb.computeSize());
        this.Frb.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(8, this.Frc);
      paramVarArgs.aS(9, this.Frd);
      AppMethodBeat.o(32100);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1081;
      }
    }
    label1081:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FqN);
      paramInt = i;
      if (this.FqO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FqO);
      }
      i = paramInt;
      if (this.FqP != null) {
        i = paramInt + f.a.a.a.lB(4, this.FqP.computeSize());
      }
      paramInt = i;
      if (this.FqQ != null) {
        paramInt = i + f.a.a.a.lB(5, this.FqQ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.FqX);
      paramInt = i;
      if (this.Frb != null) {
        paramInt = i + f.a.a.a.lB(7, this.Frb.computeSize());
      }
      i = f.a.a.b.b.a.alV(8);
      int j = f.a.a.b.b.a.bz(9, this.Frd);
      AppMethodBeat.o(32100);
      return paramInt + i + j;
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
          AppMethodBeat.o(32100);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32100);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        af localaf = (af)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32100);
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
            localaf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 2: 
          localaf.FqN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32100);
          return 0;
        case 3: 
          localaf.FqO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32100);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dej();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dej)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaf.FqP = ((dej)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new css();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((css)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaf.FqQ = ((css)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 6: 
          localaf.FqX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32100);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aav();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aav)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaf.Frb = ((aav)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32100);
          return 0;
        case 8: 
          localaf.Frc = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(32100);
          return 0;
        }
        localaf.Frd = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32100);
        return 0;
      }
      AppMethodBeat.o(32100);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.af
 * JD-Core Version:    0.7.0.1
 */