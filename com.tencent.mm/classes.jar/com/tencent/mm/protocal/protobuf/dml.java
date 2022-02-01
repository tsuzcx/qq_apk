package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dml
  extends erp
{
  public int aaSy;
  public int aaSz;
  public String iaI;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114044);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.iaI != null) {
        paramVarArgs.g(2, this.iaI);
      }
      paramVarArgs.bS(3, this.aaSy);
      paramVarArgs.bS(4, this.aaSz);
      paramVarArgs.bS(5, this.scene);
      AppMethodBeat.o(114044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label480;
      }
    }
    label480:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iaI != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.iaI);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.aaSy);
      int j = i.a.a.b.b.a.cJ(4, this.aaSz);
      int k = i.a.a.b.b.a.cJ(5, this.scene);
      AppMethodBeat.o(114044);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114044);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dml localdml = (dml)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114044);
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
            localdml.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(114044);
          return 0;
        case 2: 
          localdml.iaI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114044);
          return 0;
        case 3: 
          localdml.aaSy = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114044);
          return 0;
        case 4: 
          localdml.aaSz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114044);
          return 0;
        }
        localdml.scene = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(114044);
        return 0;
      }
      AppMethodBeat.o(114044);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dml
 * JD-Core Version:    0.7.0.1
 */