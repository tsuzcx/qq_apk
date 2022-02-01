package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class biz
  extends cvp
{
  public int GDC;
  public LinkedList<cql> GDD;
  public int GDE;
  public int GDF;
  public int GDG;
  public bmf GDH;
  public LinkedList<bmg> uiJ;
  public LinkedList<bl> ujf;
  
  public biz()
  {
    AppMethodBeat.i(152598);
    this.GDD = new LinkedList();
    this.ujf = new LinkedList();
    this.uiJ = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GDC);
      paramVarArgs.e(3, 8, this.GDD);
      paramVarArgs.aS(4, this.GDE);
      paramVarArgs.aS(5, this.GDF);
      paramVarArgs.e(6, 8, this.ujf);
      paramVarArgs.aS(7, this.GDG);
      paramVarArgs.e(8, 8, this.uiJ);
      if (this.GDH != null)
      {
        paramVarArgs.lC(9, this.GDH.computeSize());
        this.GDH.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GDC) + f.a.a.a.c(3, 8, this.GDD) + f.a.a.b.b.a.bz(4, this.GDE) + f.a.a.b.b.a.bz(5, this.GDF) + f.a.a.a.c(6, 8, this.ujf) + f.a.a.b.b.a.bz(7, this.GDG) + f.a.a.a.c(8, 8, this.uiJ);
      paramInt = i;
      if (this.GDH != null) {
        paramInt = i + f.a.a.a.lB(9, this.GDH.computeSize());
      }
      AppMethodBeat.o(152599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GDD.clear();
        this.ujf.clear();
        this.uiJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        biz localbiz = (biz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152599);
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
            localbiz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 2: 
          localbiz.GDC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152599);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cql();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cql)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbiz.GDD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 4: 
          localbiz.GDE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152599);
          return 0;
        case 5: 
          localbiz.GDF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152599);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbiz.ujf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 7: 
          localbiz.GDG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152599);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbiz.uiJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbiz.GDH = ((bmf)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biz
 * JD-Core Version:    0.7.0.1
 */