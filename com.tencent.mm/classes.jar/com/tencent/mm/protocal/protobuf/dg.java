package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dg
  extends erp
{
  public int YFx;
  public String YFy;
  public String YFz;
  public String nUv;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127430);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nUv != null) {
        paramVarArgs.g(2, this.nUv);
      }
      paramVarArgs.bS(3, this.vhJ);
      paramVarArgs.bS(4, this.YFx);
      if (this.YFy != null) {
        paramVarArgs.g(5, this.YFy);
      }
      if (this.YFz != null) {
        paramVarArgs.g(6, this.YFz);
      }
      AppMethodBeat.o(127430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label552;
      }
    }
    label552:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nUv != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.nUv);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.vhJ) + i.a.a.b.b.a.cJ(4, this.YFx);
      paramInt = i;
      if (this.YFy != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YFy);
      }
      i = paramInt;
      if (this.YFz != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YFz);
      }
      AppMethodBeat.o(127430);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127430);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dg localdg = (dg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127430);
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
            localdg.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(127430);
          return 0;
        case 2: 
          localdg.nUv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(127430);
          return 0;
        case 3: 
          localdg.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(127430);
          return 0;
        case 4: 
          localdg.YFx = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(127430);
          return 0;
        case 5: 
          localdg.YFy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(127430);
          return 0;
        }
        localdg.YFz = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(127430);
        return 0;
      }
      AppMethodBeat.o(127430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dg
 * JD-Core Version:    0.7.0.1
 */