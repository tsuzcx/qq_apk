package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qv
  extends erp
{
  public String YSF;
  public long YVJ;
  public int YVO;
  public String YVP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257445);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.YVJ);
      paramVarArgs.bS(3, this.YVO);
      if (this.YSF != null) {
        paramVarArgs.g(4, this.YSF);
      }
      if (this.YVP != null) {
        paramVarArgs.g(5, this.YVP);
      }
      AppMethodBeat.o(257445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.YVJ) + i.a.a.b.b.a.cJ(3, this.YVO);
      paramInt = i;
      if (this.YSF != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YSF);
      }
      i = paramInt;
      if (this.YVP != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YVP);
      }
      AppMethodBeat.o(257445);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        qv localqv = (qv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257445);
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
            localqv.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257445);
          return 0;
        case 2: 
          localqv.YVJ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(257445);
          return 0;
        case 3: 
          localqv.YVO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257445);
          return 0;
        case 4: 
          localqv.YSF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257445);
          return 0;
        }
        localqv.YVP = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257445);
        return 0;
      }
      AppMethodBeat.o(257445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qv
 * JD-Core Version:    0.7.0.1
 */