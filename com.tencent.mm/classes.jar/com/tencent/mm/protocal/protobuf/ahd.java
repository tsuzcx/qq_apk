package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahd
  extends esc
{
  public LinkedList<dxg> YFR;
  public String Zqf;
  public String Zqg;
  public String pss;
  
  public ahd()
  {
    AppMethodBeat.i(152524);
    this.YFR = new LinkedList();
    AppMethodBeat.o(152524);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152525);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.pss != null) {
        paramVarArgs.g(2, this.pss);
      }
      paramVarArgs.e(3, 8, this.YFR);
      if (this.Zqf != null) {
        paramVarArgs.g(4, this.Zqf);
      }
      if (this.Zqg != null) {
        paramVarArgs.g(5, this.Zqg);
      }
      AppMethodBeat.o(152525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label586;
      }
    }
    label586:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pss != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.pss);
      }
      i += i.a.a.a.c(3, 8, this.YFR);
      paramInt = i;
      if (this.Zqf != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zqf);
      }
      i = paramInt;
      if (this.Zqg != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Zqg);
      }
      AppMethodBeat.o(152525);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YFR.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ahd localahd = (ahd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152525);
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
            localahd.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152525);
          return 0;
        case 2: 
          localahd.pss = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152525);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dxg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dxg)localObject2).parseFrom((byte[])localObject1);
            }
            localahd.YFR.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152525);
          return 0;
        case 4: 
          localahd.Zqf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152525);
          return 0;
        }
        localahd.Zqg = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(152525);
        return 0;
      }
      AppMethodBeat.o(152525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahd
 * JD-Core Version:    0.7.0.1
 */