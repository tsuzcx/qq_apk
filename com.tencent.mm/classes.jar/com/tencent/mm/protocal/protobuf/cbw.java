package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbw
  extends cld
{
  public int CEu;
  public String CEv;
  public String CPg;
  public LinkedList<aec> DYf;
  public LinkedList<ax> DYg;
  public int DYh;
  public int DuP;
  
  public cbw()
  {
    AppMethodBeat.i(91628);
    this.DYf = new LinkedList();
    this.DYg = new LinkedList();
    AppMethodBeat.o(91628);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91629);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DuP);
      paramVarArgs.e(3, 8, this.DYf);
      if (this.CPg != null) {
        paramVarArgs.d(4, this.CPg);
      }
      paramVarArgs.aR(5, this.CEu);
      if (this.CEv != null) {
        paramVarArgs.d(6, this.CEv);
      }
      paramVarArgs.e(7, 8, this.DYg);
      paramVarArgs.aR(8, this.DYh);
      AppMethodBeat.o(91629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label850;
      }
    }
    label850:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DuP) + f.a.a.a.c(3, 8, this.DYf);
      paramInt = i;
      if (this.CPg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CPg);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CEu);
      paramInt = i;
      if (this.CEv != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CEv);
      }
      i = f.a.a.a.c(7, 8, this.DYg);
      int j = f.a.a.b.b.a.bA(8, this.DYh);
      AppMethodBeat.o(91629);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DYf.clear();
        this.DYg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91629);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbw localcbw = (cbw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91629);
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
            localcbw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        case 2: 
          localcbw.DuP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91629);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aec();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aec)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbw.DYf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        case 4: 
          localcbw.CPg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91629);
          return 0;
        case 5: 
          localcbw.CEu = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91629);
          return 0;
        case 6: 
          localcbw.CEv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91629);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ax();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ax)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbw.DYg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        }
        localcbw.DYh = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91629);
        return 0;
      }
      AppMethodBeat.o(91629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbw
 * JD-Core Version:    0.7.0.1
 */