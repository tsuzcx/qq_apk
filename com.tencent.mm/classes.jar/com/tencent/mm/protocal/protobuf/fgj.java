package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fgj
  extends erp
{
  public String RZY;
  public int aamt;
  public int abGn;
  public String mXG;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91696);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.scene);
      if (this.RZY != null) {
        paramVarArgs.g(3, this.RZY);
      }
      if (this.mXG != null) {
        paramVarArgs.g(4, this.mXG);
      }
      paramVarArgs.bS(5, this.abGn);
      paramVarArgs.bS(6, this.aamt);
      AppMethodBeat.o(91696);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label540;
      }
    }
    label540:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.scene);
      paramInt = i;
      if (this.RZY != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.RZY);
      }
      i = paramInt;
      if (this.mXG != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.mXG);
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.abGn);
      int j = i.a.a.b.b.a.cJ(6, this.aamt);
      AppMethodBeat.o(91696);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91696);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fgj localfgj = (fgj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91696);
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
            localfgj.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91696);
          return 0;
        case 2: 
          localfgj.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91696);
          return 0;
        case 3: 
          localfgj.RZY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91696);
          return 0;
        case 4: 
          localfgj.mXG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91696);
          return 0;
        case 5: 
          localfgj.abGn = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91696);
          return 0;
        }
        localfgj.aamt = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91696);
        return 0;
      }
      AppMethodBeat.o(91696);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgj
 * JD-Core Version:    0.7.0.1
 */