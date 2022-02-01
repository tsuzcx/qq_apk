package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class li
  extends erp
{
  public int YMY;
  public LinkedList<dpi> YMZ;
  public int scene;
  
  public li()
  {
    AppMethodBeat.i(259244);
    this.YMZ = new LinkedList();
    AppMethodBeat.o(259244);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259248);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YMY);
      paramVarArgs.e(3, 8, this.YMZ);
      paramVarArgs.bS(4, this.scene);
      AppMethodBeat.o(259248);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.YMY);
      int j = i.a.a.a.c(3, 8, this.YMZ);
      int k = i.a.a.b.b.a.cJ(4, this.scene);
      AppMethodBeat.o(259248);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YMZ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259248);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        li localli = (li)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259248);
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
            localli.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259248);
          return 0;
        case 2: 
          localli.YMY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259248);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dpi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dpi)localObject2).parseFrom((byte[])localObject1);
            }
            localli.YMZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259248);
          return 0;
        }
        localli.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259248);
        return 0;
      }
      AppMethodBeat.o(259248);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.li
 * JD-Core Version:    0.7.0.1
 */