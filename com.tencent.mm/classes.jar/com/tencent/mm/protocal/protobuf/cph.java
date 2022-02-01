package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cph
  extends erp
{
  public String IMu;
  public String aavX;
  public int aavY;
  public LinkedList<etl> aavZ;
  public int aawa;
  
  public cph()
  {
    AppMethodBeat.i(91494);
    this.aavZ = new LinkedList();
    AppMethodBeat.o(91494);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91495);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aavX != null) {
        paramVarArgs.g(2, this.aavX);
      }
      paramVarArgs.bS(3, this.aavY);
      paramVarArgs.e(4, 8, this.aavZ);
      if (this.IMu != null) {
        paramVarArgs.g(5, this.IMu);
      }
      paramVarArgs.bS(6, this.aawa);
      AppMethodBeat.o(91495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aavX != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aavX);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.aavY) + i.a.a.a.c(4, 8, this.aavZ);
      paramInt = i;
      if (this.IMu != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.IMu);
      }
      i = i.a.a.b.b.a.cJ(6, this.aawa);
      AppMethodBeat.o(91495);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aavZ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91495);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cph localcph = (cph)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91495);
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
            localcph.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91495);
          return 0;
        case 2: 
          localcph.aavX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91495);
          return 0;
        case 3: 
          localcph.aavY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91495);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localcph.aavZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91495);
          return 0;
        case 5: 
          localcph.IMu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91495);
          return 0;
        }
        localcph.aawa = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91495);
        return 0;
      }
      AppMethodBeat.o(91495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cph
 * JD-Core Version:    0.7.0.1
 */