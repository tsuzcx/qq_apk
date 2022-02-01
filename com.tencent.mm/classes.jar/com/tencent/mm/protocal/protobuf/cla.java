package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cla
  extends erp
{
  public boolean Zqb;
  public ebs aaqS;
  public String aatc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72488);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aatc != null) {
        paramVarArgs.g(2, this.aatc);
      }
      if (this.aaqS != null)
      {
        paramVarArgs.qD(3, this.aaqS.computeSize());
        this.aaqS.writeFields(paramVarArgs);
      }
      paramVarArgs.di(4, this.Zqb);
      AppMethodBeat.o(72488);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aatc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aatc);
      }
      i = paramInt;
      if (this.aaqS != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaqS.computeSize());
      }
      paramInt = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(72488);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72488);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cla localcla = (cla)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72488);
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
            localcla.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72488);
          return 0;
        case 2: 
          localcla.aatc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72488);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ebs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ebs)localObject2).parseFrom((byte[])localObject1);
            }
            localcla.aaqS = ((ebs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72488);
          return 0;
        }
        localcla.Zqb = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(72488);
        return 0;
      }
      AppMethodBeat.o(72488);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cla
 * JD-Core Version:    0.7.0.1
 */