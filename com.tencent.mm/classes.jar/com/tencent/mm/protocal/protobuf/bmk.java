package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmk
  extends esc
{
  public String ZVc;
  public LinkedList<cby> ZVd;
  public boolean has_next;
  
  public bmk()
  {
    AppMethodBeat.i(258909);
    this.ZVd = new LinkedList();
    AppMethodBeat.o(258909);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258913);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZVd);
      paramVarArgs.di(3, this.has_next);
      if (this.ZVc != null) {
        paramVarArgs.g(4, this.ZVc);
      }
      AppMethodBeat.o(258913);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZVd) + (i.a.a.b.b.a.ko(3) + 1);
      paramInt = i;
      if (this.ZVc != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZVc);
      }
      AppMethodBeat.o(258913);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZVd.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258913);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bmk localbmk = (bmk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258913);
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
            localbmk.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258913);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cby();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cby)localObject2).parseFrom((byte[])localObject1);
            }
            localbmk.ZVd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258913);
          return 0;
        case 3: 
          localbmk.has_next = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(258913);
          return 0;
        }
        localbmk.ZVc = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258913);
        return 0;
      }
      AppMethodBeat.o(258913);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmk
 * JD-Core Version:    0.7.0.1
 */