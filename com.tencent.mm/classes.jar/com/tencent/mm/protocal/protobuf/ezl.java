package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ezl
  extends erp
{
  public int vgN;
  public LinkedList<al> vgO;
  
  public ezl()
  {
    AppMethodBeat.i(6432);
    this.vgO = new LinkedList();
    AppMethodBeat.o(6432);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6433);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vgN);
      paramVarArgs.e(3, 8, this.vgO);
      AppMethodBeat.o(6433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label459;
      }
    }
    label459:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vgN);
      int j = i.a.a.a.c(3, 8, this.vgO);
      AppMethodBeat.o(6433);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vgO.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(6433);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ezl localezl = (ezl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6433);
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
            localezl.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6433);
          return 0;
        case 2: 
          localezl.vgN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(6433);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new al();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((al)localObject2).parseFrom((byte[])localObject1);
          }
          localezl.vgO.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(6433);
        return 0;
      }
      AppMethodBeat.o(6433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezl
 * JD-Core Version:    0.7.0.1
 */