package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fip
  extends erp
{
  public String UserName;
  public String abDu;
  public long abDv;
  public long abEV;
  public int abEW;
  public int ytH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118449);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abDu != null) {
        paramVarArgs.g(2, this.abDu);
      }
      if (this.UserName != null) {
        paramVarArgs.g(3, this.UserName);
      }
      paramVarArgs.bS(4, this.ytH);
      paramVarArgs.bv(5, this.abDv);
      paramVarArgs.bv(6, this.abEV);
      paramVarArgs.bS(7, this.abEW);
      AppMethodBeat.o(118449);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label592;
      }
    }
    label592:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abDu != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abDu);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.UserName);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.ytH);
      int j = i.a.a.b.b.a.q(5, this.abDv);
      int k = i.a.a.b.b.a.q(6, this.abEV);
      int m = i.a.a.b.b.a.cJ(7, this.abEW);
      AppMethodBeat.o(118449);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(118449);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fip localfip = (fip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118449);
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
            localfip.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(118449);
          return 0;
        case 2: 
          localfip.abDu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(118449);
          return 0;
        case 3: 
          localfip.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(118449);
          return 0;
        case 4: 
          localfip.ytH = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(118449);
          return 0;
        case 5: 
          localfip.abDv = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(118449);
          return 0;
        case 6: 
          localfip.abEV = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(118449);
          return 0;
        }
        localfip.abEW = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118449);
        return 0;
      }
      AppMethodBeat.o(118449);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fip
 * JD-Core Version:    0.7.0.1
 */