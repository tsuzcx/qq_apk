package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clu
  extends erp
{
  public long Bee;
  public int aatK;
  public String mdG;
  public String mdH;
  public int oeO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125732);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.Bee);
      paramVarArgs.bS(3, this.aatK);
      if (this.mdH != null) {
        paramVarArgs.g(4, this.mdH);
      }
      if (this.mdG != null) {
        paramVarArgs.g(5, this.mdG);
      }
      paramVarArgs.bS(6, this.oeO);
      AppMethodBeat.o(125732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label536;
      }
    }
    label536:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.Bee) + i.a.a.b.b.a.cJ(3, this.aatK);
      paramInt = i;
      if (this.mdH != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.mdH);
      }
      i = paramInt;
      if (this.mdG != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.mdG);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.oeO);
      AppMethodBeat.o(125732);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125732);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        clu localclu = (clu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125732);
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
            localclu.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(125732);
          return 0;
        case 2: 
          localclu.Bee = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(125732);
          return 0;
        case 3: 
          localclu.aatK = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125732);
          return 0;
        case 4: 
          localclu.mdH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125732);
          return 0;
        case 5: 
          localclu.mdG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125732);
          return 0;
        }
        localclu.oeO = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(125732);
        return 0;
      }
      AppMethodBeat.o(125732);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clu
 * JD-Core Version:    0.7.0.1
 */