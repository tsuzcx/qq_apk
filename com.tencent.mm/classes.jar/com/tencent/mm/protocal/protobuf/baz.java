package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class baz
  extends cld
{
  public int DyJ;
  public LinkedList<cgi> DyK;
  public int DyL;
  public int DyM;
  public int DyN;
  public bef DyO;
  public LinkedList<beg> scJ;
  public LinkedList<bj> sdc;
  
  public baz()
  {
    AppMethodBeat.i(152598);
    this.DyK = new LinkedList();
    this.sdc = new LinkedList();
    this.scJ = new LinkedList();
    AppMethodBeat.o(152598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152599);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152599);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DyJ);
      paramVarArgs.e(3, 8, this.DyK);
      paramVarArgs.aR(4, this.DyL);
      paramVarArgs.aR(5, this.DyM);
      paramVarArgs.e(6, 8, this.sdc);
      paramVarArgs.aR(7, this.DyN);
      paramVarArgs.e(8, 8, this.scJ);
      if (this.DyO != null)
      {
        paramVarArgs.kX(9, this.DyO.computeSize());
        this.DyO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1102;
      }
    }
    label1102:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DyJ) + f.a.a.a.c(3, 8, this.DyK) + f.a.a.b.b.a.bA(4, this.DyL) + f.a.a.b.b.a.bA(5, this.DyM) + f.a.a.a.c(6, 8, this.sdc) + f.a.a.b.b.a.bA(7, this.DyN) + f.a.a.a.c(8, 8, this.scJ);
      paramInt = i;
      if (this.DyO != null) {
        paramInt = i + f.a.a.a.kW(9, this.DyO.computeSize());
      }
      AppMethodBeat.o(152599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DyK.clear();
        this.sdc.clear();
        this.scJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152599);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152599);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        baz localbaz = (baz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152599);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 2: 
          localbaz.DyJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152599);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaz.DyK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 4: 
          localbaz.DyL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152599);
          return 0;
        case 5: 
          localbaz.DyM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152599);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaz.sdc.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 7: 
          localbaz.DyN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152599);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new beg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((beg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaz.scJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bef();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bef)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbaz.DyO = ((bef)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152599);
        return 0;
      }
      AppMethodBeat.o(152599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baz
 * JD-Core Version:    0.7.0.1
 */