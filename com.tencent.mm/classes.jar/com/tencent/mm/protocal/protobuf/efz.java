package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efz
  extends erp
{
  public flb abls;
  public boolean ablt;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153290);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abls != null)
      {
        paramVarArgs.qD(2, this.abls.computeSize());
        this.abls.writeFields(paramVarArgs);
      }
      paramVarArgs.di(3, this.ablt);
      paramVarArgs.bS(4, this.scene);
      AppMethodBeat.o(153290);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abls != null) {
        i = paramInt + i.a.a.a.qC(2, this.abls.computeSize());
      }
      paramInt = i.a.a.b.b.a.ko(3);
      int j = i.a.a.b.b.a.cJ(4, this.scene);
      AppMethodBeat.o(153290);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153290);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        efz localefz = (efz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153290);
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
            localefz.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153290);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new flb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((flb)localObject2).parseFrom((byte[])localObject1);
            }
            localefz.abls = ((flb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153290);
          return 0;
        case 3: 
          localefz.ablt = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(153290);
          return 0;
        }
        localefz.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(153290);
        return 0;
      }
      AppMethodBeat.o(153290);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efz
 * JD-Core Version:    0.7.0.1
 */