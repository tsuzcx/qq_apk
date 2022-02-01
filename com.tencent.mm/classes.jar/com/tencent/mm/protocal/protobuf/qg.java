package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class qg
  extends erp
{
  public int YLL;
  public b YPG;
  public String YPH;
  public int YVb;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118407);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YPG != null) {
        paramVarArgs.d(2, this.YPG);
      }
      paramVarArgs.bS(3, this.source);
      paramVarArgs.bS(4, this.YVb);
      if (this.YPH != null) {
        paramVarArgs.g(5, this.YPH);
      }
      paramVarArgs.bS(6, this.YLL);
      AppMethodBeat.o(118407);
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
      int i = paramInt;
      if (this.YPG != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.YPG);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.source) + i.a.a.b.b.a.cJ(4, this.YVb);
      paramInt = i;
      if (this.YPH != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YPH);
      }
      i = i.a.a.b.b.a.cJ(6, this.YLL);
      AppMethodBeat.o(118407);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(118407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        qg localqg = (qg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118407);
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
            localqg.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(118407);
          return 0;
        case 2: 
          localqg.YPG = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(118407);
          return 0;
        case 3: 
          localqg.source = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(118407);
          return 0;
        case 4: 
          localqg.YVb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(118407);
          return 0;
        case 5: 
          localqg.YPH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(118407);
          return 0;
        }
        localqg.YLL = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118407);
        return 0;
      }
      AppMethodBeat.o(118407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qg
 * JD-Core Version:    0.7.0.1
 */