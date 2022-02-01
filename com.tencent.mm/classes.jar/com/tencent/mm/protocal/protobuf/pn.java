package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class pn
  extends esc
{
  public int BeA;
  public com.tencent.mm.bx.b YSV;
  public LinkedList<pi> YSX;
  public int YSY;
  public int YSZ;
  public int func_flag;
  
  public pn()
  {
    AppMethodBeat.i(258326);
    this.YSX = new LinkedList();
    AppMethodBeat.o(258326);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258330);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258330);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.YSX);
      if (this.YSV != null) {
        paramVarArgs.d(3, this.YSV);
      }
      paramVarArgs.bS(4, this.BeA);
      paramVarArgs.bS(5, this.YSY);
      paramVarArgs.bS(7, this.YSZ);
      paramVarArgs.bS(8, this.func_flag);
      AppMethodBeat.o(258330);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label702;
      }
    }
    label702:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.YSX);
      paramInt = i;
      if (this.YSV != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.YSV);
      }
      i = i.a.a.b.b.a.cJ(4, this.BeA);
      int j = i.a.a.b.b.a.cJ(5, this.YSY);
      int k = i.a.a.b.b.a.cJ(7, this.YSZ);
      int m = i.a.a.b.b.a.cJ(8, this.func_flag);
      AppMethodBeat.o(258330);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YSX.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(258330);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258330);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        pn localpn = (pn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(258330);
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
            localpn.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258330);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new pi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((pi)localObject2).parseFrom((byte[])localObject1);
            }
            localpn.YSX.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258330);
          return 0;
        case 3: 
          localpn.YSV = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258330);
          return 0;
        case 4: 
          localpn.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258330);
          return 0;
        case 5: 
          localpn.YSY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258330);
          return 0;
        case 7: 
          localpn.YSZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258330);
          return 0;
        }
        localpn.func_flag = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258330);
        return 0;
      }
      AppMethodBeat.o(258330);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pn
 * JD-Core Version:    0.7.0.1
 */