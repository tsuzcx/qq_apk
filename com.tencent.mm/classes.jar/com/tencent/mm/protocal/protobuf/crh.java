package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class crh
  extends erp
{
  public String aaxU;
  public int aaxV;
  public b aaxW;
  public String nQE;
  public int nQF;
  public int scene_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258832);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nQE != null) {
        paramVarArgs.g(2, this.nQE);
      }
      if (this.aaxU != null) {
        paramVarArgs.g(3, this.aaxU);
      }
      paramVarArgs.bS(4, this.aaxV);
      paramVarArgs.bS(5, this.nQF);
      paramVarArgs.bS(6, this.scene_type);
      if (this.aaxW != null) {
        paramVarArgs.d(7, this.aaxW);
      }
      AppMethodBeat.o(258832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label596;
      }
    }
    label596:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nQE != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nQE);
      }
      i = paramInt;
      if (this.aaxU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaxU);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.aaxV) + i.a.a.b.b.a.cJ(5, this.nQF) + i.a.a.b.b.a.cJ(6, this.scene_type);
      paramInt = i;
      if (this.aaxW != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.aaxW);
      }
      AppMethodBeat.o(258832);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258832);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        crh localcrh = (crh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258832);
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
            localcrh.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(258832);
          return 0;
        case 2: 
          localcrh.nQE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258832);
          return 0;
        case 3: 
          localcrh.aaxU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258832);
          return 0;
        case 4: 
          localcrh.aaxV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258832);
          return 0;
        case 5: 
          localcrh.nQF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258832);
          return 0;
        case 6: 
          localcrh.scene_type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258832);
          return 0;
        }
        localcrh.aaxW = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(258832);
        return 0;
      }
      AppMethodBeat.o(258832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crh
 * JD-Core Version:    0.7.0.1
 */