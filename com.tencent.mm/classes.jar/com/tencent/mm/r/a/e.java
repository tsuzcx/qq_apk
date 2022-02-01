package com.tencent.mm.r.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class e
  extends erp
{
  public String hAB;
  public String mdG;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231416);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hAB != null) {
        paramVarArgs.g(2, this.hAB);
      }
      if (this.mdG != null) {
        paramVarArgs.g(3, this.mdG);
      }
      paramVarArgs.bS(4, this.source);
      AppMethodBeat.o(231416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label448;
      }
    }
    label448:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hAB != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAB);
      }
      i = paramInt;
      if (this.mdG != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.mdG);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.source);
      AppMethodBeat.o(231416);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(231416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231416);
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
            locale.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(231416);
          return 0;
        case 2: 
          locale.hAB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(231416);
          return 0;
        case 3: 
          locale.mdG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(231416);
          return 0;
        }
        locale.source = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(231416);
        return 0;
      }
      AppMethodBeat.o(231416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.r.a.e
 * JD-Core Version:    0.7.0.1
 */