package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmo
  extends erp
{
  public LinkedList<String> aaur;
  public long mMJ;
  
  public cmo()
  {
    AppMethodBeat.i(257410);
    this.aaur = new LinkedList();
    AppMethodBeat.o(257410);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257414);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.mMJ);
      paramVarArgs.e(3, 1, this.aaur);
      AppMethodBeat.o(257414);
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
      int i = i.a.a.b.b.a.q(2, this.mMJ);
      int j = i.a.a.a.c(3, 1, this.aaur);
      AppMethodBeat.o(257414);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaur.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257414);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cmo localcmo = (cmo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257414);
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
            localcmo.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257414);
          return 0;
        case 2: 
          localcmo.mMJ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(257414);
          return 0;
        }
        localcmo.aaur.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(257414);
        return 0;
      }
      AppMethodBeat.o(257414);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmo
 * JD-Core Version:    0.7.0.1
 */