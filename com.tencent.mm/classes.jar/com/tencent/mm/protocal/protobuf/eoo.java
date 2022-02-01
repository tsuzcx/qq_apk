package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eoo
  extends erp
{
  public String YBL;
  public String YBM;
  public long mMJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259418);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.mMJ);
      if (this.YBL != null) {
        paramVarArgs.g(3, this.YBL);
      }
      if (this.YBM != null) {
        paramVarArgs.g(4, this.YBM);
      }
      AppMethodBeat.o(259418);
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
      int i = paramInt + i.a.a.b.b.a.q(2, this.mMJ);
      paramInt = i;
      if (this.YBL != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YBL);
      }
      i = paramInt;
      if (this.YBM != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YBM);
      }
      AppMethodBeat.o(259418);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259418);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eoo localeoo = (eoo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259418);
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
            localeoo.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259418);
          return 0;
        case 2: 
          localeoo.mMJ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259418);
          return 0;
        case 3: 
          localeoo.YBL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259418);
          return 0;
        }
        localeoo.YBM = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259418);
        return 0;
      }
      AppMethodBeat.o(259418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoo
 * JD-Core Version:    0.7.0.1
 */