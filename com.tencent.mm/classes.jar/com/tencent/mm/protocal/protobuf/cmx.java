package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c;
import java.util.LinkedList;

public final class cmx
  extends esc
{
  public c VIz;
  public String aaoE;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91492);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.VIz != null)
      {
        paramVarArgs.qD(4, this.VIz.computeSize());
        this.VIz.writeFields(paramVarArgs);
      }
      if (this.aaoE != null) {
        paramVarArgs.g(5, this.aaoE);
      }
      AppMethodBeat.o(91492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.VIz != null) {
        i = paramInt + i.a.a.a.qC(4, this.VIz.computeSize());
      }
      paramInt = i;
      if (this.aaoE != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaoE);
      }
      AppMethodBeat.o(91492);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91492);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cmx localcmx = (cmx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91492);
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
            localcmx.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91492);
          return 0;
        case 2: 
          localcmx.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91492);
          return 0;
        case 3: 
          localcmx.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91492);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new c();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((c)localObject2).parseFrom((byte[])localObject1);
            }
            localcmx.VIz = ((c)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91492);
          return 0;
        }
        localcmx.aaoE = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91492);
        return 0;
      }
      AppMethodBeat.o(91492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmx
 * JD-Core Version:    0.7.0.1
 */