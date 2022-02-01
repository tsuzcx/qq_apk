package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ciw
  extends esc
{
  public int aarr;
  public String aars;
  public int aart;
  public int aaru;
  public int vgN;
  public LinkedList<ang> vgO;
  
  public ciw()
  {
    AppMethodBeat.i(104792);
    this.vgO = new LinkedList();
    AppMethodBeat.o(104792);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104793);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104793);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vgN);
      paramVarArgs.e(3, 8, this.vgO);
      paramVarArgs.bS(4, this.aarr);
      if (this.aars != null) {
        paramVarArgs.g(5, this.aars);
      }
      paramVarArgs.bS(6, this.aart);
      paramVarArgs.bS(8, this.aaru);
      AppMethodBeat.o(104793);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vgN) + i.a.a.a.c(3, 8, this.vgO) + i.a.a.b.b.a.cJ(4, this.aarr);
      paramInt = i;
      if (this.aars != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aars);
      }
      i = i.a.a.b.b.a.cJ(6, this.aart);
      int j = i.a.a.b.b.a.cJ(8, this.aaru);
      AppMethodBeat.o(104793);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vgO.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104793);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104793);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ciw localciw = (ciw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 7: 
        default: 
          AppMethodBeat.o(104793);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localciw.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104793);
          return 0;
        case 2: 
          localciw.vgN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104793);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ang();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ang)localObject2).parseFrom((byte[])localObject1);
            }
            localciw.vgO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104793);
          return 0;
        case 4: 
          localciw.aarr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104793);
          return 0;
        case 5: 
          localciw.aars = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104793);
          return 0;
        case 6: 
          localciw.aart = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104793);
          return 0;
        }
        localciw.aaru = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(104793);
        return 0;
      }
      AppMethodBeat.o(104793);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciw
 * JD-Core Version:    0.7.0.1
 */