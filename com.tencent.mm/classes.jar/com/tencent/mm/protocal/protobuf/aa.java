package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aa
  extends erp
{
  public String YAA;
  public int YAB;
  public int YAC;
  public String YAD;
  public int limit;
  public int offset;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91336);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.limit);
      paramVarArgs.bS(3, this.offset);
      paramVarArgs.bS(4, this.type);
      if (this.YAA != null) {
        paramVarArgs.g(5, this.YAA);
      }
      paramVarArgs.bS(6, this.YAB);
      paramVarArgs.bS(7, this.YAC);
      if (this.YAD != null) {
        paramVarArgs.g(8, this.YAD);
      }
      AppMethodBeat.o(91336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label624;
      }
    }
    label624:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.limit) + i.a.a.b.b.a.cJ(3, this.offset) + i.a.a.b.b.a.cJ(4, this.type);
      paramInt = i;
      if (this.YAA != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YAA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.YAB) + i.a.a.b.b.a.cJ(7, this.YAC);
      paramInt = i;
      if (this.YAD != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YAD);
      }
      AppMethodBeat.o(91336);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91336);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91336);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localaa.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91336);
          return 0;
        case 2: 
          localaa.limit = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91336);
          return 0;
        case 3: 
          localaa.offset = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91336);
          return 0;
        case 4: 
          localaa.type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91336);
          return 0;
        case 5: 
          localaa.YAA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91336);
          return 0;
        case 6: 
          localaa.YAB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91336);
          return 0;
        case 7: 
          localaa.YAC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91336);
          return 0;
        }
        localaa.YAD = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91336);
        return 0;
      }
      AppMethodBeat.o(91336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aa
 * JD-Core Version:    0.7.0.1
 */