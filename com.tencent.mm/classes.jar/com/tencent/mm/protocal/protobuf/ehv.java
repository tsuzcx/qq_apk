package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ehv
  extends erp
{
  public String abmS;
  public String abmT;
  public String abmU;
  public String abmV;
  public String abmW;
  public int abmX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32374);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abmS != null) {
        paramVarArgs.g(2, this.abmS);
      }
      if (this.abmT != null) {
        paramVarArgs.g(3, this.abmT);
      }
      if (this.abmU != null) {
        paramVarArgs.g(4, this.abmU);
      }
      if (this.abmV != null) {
        paramVarArgs.g(5, this.abmV);
      }
      if (this.abmW != null) {
        paramVarArgs.g(6, this.abmW);
      }
      paramVarArgs.bS(7, this.abmX);
      AppMethodBeat.o(32374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label645;
      }
    }
    label645:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abmS != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abmS);
      }
      i = paramInt;
      if (this.abmT != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abmT);
      }
      paramInt = i;
      if (this.abmU != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abmU);
      }
      i = paramInt;
      if (this.abmV != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abmV);
      }
      paramInt = i;
      if (this.abmW != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abmW);
      }
      i = i.a.a.b.b.a.cJ(7, this.abmX);
      AppMethodBeat.o(32374);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32374);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ehv localehv = (ehv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32374);
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
            localehv.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32374);
          return 0;
        case 2: 
          localehv.abmS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 3: 
          localehv.abmT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 4: 
          localehv.abmU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 5: 
          localehv.abmV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 6: 
          localehv.abmW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32374);
          return 0;
        }
        localehv.abmX = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32374);
        return 0;
      }
      AppMethodBeat.o(32374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehv
 * JD-Core Version:    0.7.0.1
 */