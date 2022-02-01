package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ftt
  extends erp
{
  public boolean abRS;
  public int muB;
  public String oOI;
  public int vhI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123666);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      paramVarArgs.bS(3, this.vhI);
      paramVarArgs.di(4, this.abRS);
      paramVarArgs.bS(5, this.muB);
      AppMethodBeat.o(123666);
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
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.oOI);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.vhI);
      int j = i.a.a.b.b.a.ko(4);
      int k = i.a.a.b.b.a.cJ(5, this.muB);
      AppMethodBeat.o(123666);
      return i + paramInt + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ftt localftt = (ftt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123666);
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
            localftt.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(123666);
          return 0;
        case 2: 
          localftt.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123666);
          return 0;
        case 3: 
          localftt.vhI = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123666);
          return 0;
        case 4: 
          localftt.abRS = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(123666);
          return 0;
        }
        localftt.muB = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(123666);
        return 0;
      }
      AppMethodBeat.o(123666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ftt
 * JD-Core Version:    0.7.0.1
 */