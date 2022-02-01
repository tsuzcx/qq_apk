package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fw
  extends erp
{
  public LinkedList<fv> YHr;
  public fv YHs;
  
  public fw()
  {
    AppMethodBeat.i(103182);
    this.YHr = new LinkedList();
    AppMethodBeat.o(103182);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103183);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.YHr);
      if (this.YHs != null)
      {
        paramVarArgs.qD(3, this.YHs.computeSize());
        this.YHs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(103183);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label536;
      }
    }
    label536:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.YHr);
      paramInt = i;
      if (this.YHs != null) {
        paramInt = i + i.a.a.a.qC(3, this.YHs.computeSize());
      }
      AppMethodBeat.o(103183);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YHr.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(103183);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fw localfw = (fw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103183);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localfw.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(103183);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fv)localObject2).parseFrom((byte[])localObject1);
            }
            localfw.YHr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(103183);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fv)localObject2).parseFrom((byte[])localObject1);
          }
          localfw.YHs = ((fv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(103183);
        return 0;
      }
      AppMethodBeat.o(103183);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fw
 * JD-Core Version:    0.7.0.1
 */