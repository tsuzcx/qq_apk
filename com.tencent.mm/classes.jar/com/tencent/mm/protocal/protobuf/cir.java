package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cir
  extends erp
{
  public LinkedList<String> aarm;
  public int scene;
  
  public cir()
  {
    AppMethodBeat.i(114025);
    this.aarm = new LinkedList();
    AppMethodBeat.o(114025);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114026);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.aarm);
      paramVarArgs.bS(3, this.scene);
      AppMethodBeat.o(114026);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 1, this.aarm);
      int j = i.a.a.b.b.a.cJ(3, this.scene);
      AppMethodBeat.o(114026);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aarm.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114026);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cir localcir = (cir)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114026);
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
            localcir.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(114026);
          return 0;
        case 2: 
          localcir.aarm.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(114026);
          return 0;
        }
        localcir.scene = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(114026);
        return 0;
      }
      AppMethodBeat.o(114026);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cir
 * JD-Core Version:    0.7.0.1
 */