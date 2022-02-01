package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fyl
  extends erp
{
  public String abWb;
  public LinkedList<String> abWn;
  
  public fyl()
  {
    AppMethodBeat.i(257725);
    this.abWn = new LinkedList();
    AppMethodBeat.o(257725);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257729);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.abWn);
      if (this.abWb != null) {
        paramVarArgs.g(3, this.abWb);
      }
      AppMethodBeat.o(257729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label404;
      }
    }
    label404:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 1, this.abWn);
      paramInt = i;
      if (this.abWb != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abWb);
      }
      AppMethodBeat.o(257729);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abWn.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257729);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fyl localfyl = (fyl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257729);
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
            localfyl.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257729);
          return 0;
        case 2: 
          localfyl.abWn.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(257729);
          return 0;
        }
        localfyl.abWb = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257729);
        return 0;
      }
      AppMethodBeat.o(257729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fyl
 * JD-Core Version:    0.7.0.1
 */