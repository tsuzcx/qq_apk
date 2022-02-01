package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjs
  extends erp
{
  public String aasl;
  public int scene;
  public String xlr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258492);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.scene);
      if (this.xlr != null) {
        paramVarArgs.g(3, this.xlr);
      }
      if (this.aasl != null) {
        paramVarArgs.g(4, this.aasl);
      }
      AppMethodBeat.o(258492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label448;
      }
    }
    label448:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.scene);
      paramInt = i;
      if (this.xlr != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.xlr);
      }
      i = paramInt;
      if (this.aasl != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aasl);
      }
      AppMethodBeat.o(258492);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258492);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cjs localcjs = (cjs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258492);
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
            localcjs.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(258492);
          return 0;
        case 2: 
          localcjs.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258492);
          return 0;
        case 3: 
          localcjs.xlr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258492);
          return 0;
        }
        localcjs.aasl = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258492);
        return 0;
      }
      AppMethodBeat.o(258492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjs
 * JD-Core Version:    0.7.0.1
 */