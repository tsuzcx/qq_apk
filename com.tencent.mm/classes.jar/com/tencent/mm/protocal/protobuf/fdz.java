package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fdz
  extends erp
{
  public int NkN;
  public int NkO;
  public String abDD;
  public int abDE;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125782);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.NkO);
      paramVarArgs.bS(3, this.NkN);
      if (this.abDD != null) {
        paramVarArgs.g(4, this.abDD);
      }
      paramVarArgs.bS(5, this.vhJ);
      paramVarArgs.bS(6, this.abDE);
      AppMethodBeat.o(125782);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label524;
      }
    }
    label524:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.NkO) + i.a.a.b.b.a.cJ(3, this.NkN);
      paramInt = i;
      if (this.abDD != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abDD);
      }
      i = i.a.a.b.b.a.cJ(5, this.vhJ);
      int j = i.a.a.b.b.a.cJ(6, this.abDE);
      AppMethodBeat.o(125782);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125782);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fdz localfdz = (fdz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125782);
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
            localfdz.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(125782);
          return 0;
        case 2: 
          localfdz.NkO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125782);
          return 0;
        case 3: 
          localfdz.NkN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125782);
          return 0;
        case 4: 
          localfdz.abDD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125782);
          return 0;
        case 5: 
          localfdz.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125782);
          return 0;
        }
        localfdz.abDE = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(125782);
        return 0;
      }
      AppMethodBeat.o(125782);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdz
 * JD-Core Version:    0.7.0.1
 */