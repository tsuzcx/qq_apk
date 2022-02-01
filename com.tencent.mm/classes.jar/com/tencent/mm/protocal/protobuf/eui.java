package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eui
  extends esc
{
  public boolean YPZ;
  public int YQa;
  public LinkedList<nm> abxk;
  
  public eui()
  {
    AppMethodBeat.i(257616);
    this.abxk = new LinkedList();
    AppMethodBeat.o(257616);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257619);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.abxk);
      paramVarArgs.bS(3, this.YQa);
      paramVarArgs.di(4, this.YPZ);
      AppMethodBeat.o(257619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.abxk);
      int j = i.a.a.b.b.a.cJ(3, this.YQa);
      int k = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(257619);
      return paramInt + i + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abxk.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257619);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eui localeui = (eui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257619);
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
            localeui.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257619);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new nm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((nm)localObject2).parseFrom((byte[])localObject1);
            }
            localeui.abxk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257619);
          return 0;
        case 3: 
          localeui.YQa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257619);
          return 0;
        }
        localeui.YPZ = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(257619);
        return 0;
      }
      AppMethodBeat.o(257619);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eui
 * JD-Core Version:    0.7.0.1
 */