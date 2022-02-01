package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public final class az
  extends esc
{
  public long NlA;
  public boolean NlB;
  public LinkedList<ak> Nlx;
  public LinkedList<ak> Nly;
  public LinkedList<ak> Nlz;
  
  public az()
  {
    AppMethodBeat.i(267046);
    this.Nlx = new LinkedList();
    this.Nly = new LinkedList();
    this.Nlz = new LinkedList();
    AppMethodBeat.o(267046);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267054);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Nlx);
      paramVarArgs.e(3, 8, this.Nly);
      paramVarArgs.e(4, 8, this.Nlz);
      paramVarArgs.bv(5, this.NlA);
      paramVarArgs.di(6, this.NlB);
      AppMethodBeat.o(267054);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.Nlx);
      int j = i.a.a.a.c(3, 8, this.Nly);
      int k = i.a.a.a.c(4, 8, this.Nlz);
      int m = i.a.a.b.b.a.q(5, this.NlA);
      int n = i.a.a.b.b.a.ko(6);
      AppMethodBeat.o(267054);
      return paramInt + i + j + k + m + (n + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nlx.clear();
        this.Nly.clear();
        this.Nlz.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(267054);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        az localaz = (az)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(267054);
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
            localaz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(267054);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ak();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ak)localObject2).parseFrom((byte[])localObject1);
            }
            localaz.Nlx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(267054);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ak();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ak)localObject2).parseFrom((byte[])localObject1);
            }
            localaz.Nly.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(267054);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ak();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ak)localObject2).parseFrom((byte[])localObject1);
            }
            localaz.Nlz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(267054);
          return 0;
        case 5: 
          localaz.NlA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(267054);
          return 0;
        }
        localaz.NlB = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(267054);
        return 0;
      }
      AppMethodBeat.o(267054);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.az
 * JD-Core Version:    0.7.0.1
 */