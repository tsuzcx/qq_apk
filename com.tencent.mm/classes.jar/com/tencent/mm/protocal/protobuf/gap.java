package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gap
  extends erp
{
  public long ZvA;
  public int Zvz;
  public long abWT;
  public String abXZ;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115878);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zvz);
      paramVarArgs.bv(3, this.ZvA);
      if (this.abXZ != null) {
        paramVarArgs.g(4, this.abXZ);
      }
      paramVarArgs.bS(5, this.vhJ);
      paramVarArgs.bv(6, this.abWT);
      AppMethodBeat.o(115878);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label524;
      }
    }
    label524:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Zvz) + i.a.a.b.b.a.q(3, this.ZvA);
      paramInt = i;
      if (this.abXZ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abXZ);
      }
      i = i.a.a.b.b.a.cJ(5, this.vhJ);
      int j = i.a.a.b.b.a.q(6, this.abWT);
      AppMethodBeat.o(115878);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(115878);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gap localgap = (gap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115878);
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
            localgap.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(115878);
          return 0;
        case 2: 
          localgap.Zvz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115878);
          return 0;
        case 3: 
          localgap.ZvA = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(115878);
          return 0;
        case 4: 
          localgap.abXZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(115878);
          return 0;
        case 5: 
          localgap.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115878);
          return 0;
        }
        localgap.abWT = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(115878);
        return 0;
      }
      AppMethodBeat.o(115878);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gap
 * JD-Core Version:    0.7.0.1
 */