package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgt
  extends erp
{
  public String aapB;
  public String aapC;
  public double latitude;
  public double longitude;
  public String wws;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114020);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.d(2, this.latitude);
      paramVarArgs.d(3, this.longitude);
      if (this.wws != null) {
        paramVarArgs.g(4, this.wws);
      }
      if (this.aapB != null) {
        paramVarArgs.g(5, this.aapB);
      }
      if (this.aapC != null) {
        paramVarArgs.g(6, this.aapC);
      }
      AppMethodBeat.o(114020);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 8) + (i.a.a.b.b.a.ko(3) + 8);
      paramInt = i;
      if (this.wws != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.wws);
      }
      i = paramInt;
      if (this.aapB != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aapB);
      }
      paramInt = i;
      if (this.aapC != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aapC);
      }
      AppMethodBeat.o(114020);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114020);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cgt localcgt = (cgt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114020);
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
            localcgt.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(114020);
          return 0;
        case 2: 
          localcgt.latitude = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(114020);
          return 0;
        case 3: 
          localcgt.longitude = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(114020);
          return 0;
        case 4: 
          localcgt.wws = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114020);
          return 0;
        case 5: 
          localcgt.aapB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114020);
          return 0;
        }
        localcgt.aapC = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(114020);
        return 0;
      }
      AppMethodBeat.o(114020);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgt
 * JD-Core Version:    0.7.0.1
 */