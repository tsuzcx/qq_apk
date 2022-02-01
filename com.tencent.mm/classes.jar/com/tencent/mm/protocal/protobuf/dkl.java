package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkl
  extends erp
{
  public String aaQr;
  public String lang;
  public int limit;
  public int offset;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152624);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.offset);
      paramVarArgs.bS(3, this.limit);
      if (this.lang != null) {
        paramVarArgs.g(4, this.lang);
      }
      if (this.aaQr != null) {
        paramVarArgs.g(5, this.aaQr);
      }
      AppMethodBeat.o(152624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.offset) + i.a.a.b.b.a.cJ(3, this.limit);
      paramInt = i;
      if (this.lang != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.lang);
      }
      i = paramInt;
      if (this.aaQr != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaQr);
      }
      AppMethodBeat.o(152624);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dkl localdkl = (dkl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152624);
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
            localdkl.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(152624);
          return 0;
        case 2: 
          localdkl.offset = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152624);
          return 0;
        case 3: 
          localdkl.limit = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152624);
          return 0;
        case 4: 
          localdkl.lang = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152624);
          return 0;
        }
        localdkl.aaQr = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152624);
        return 0;
      }
      AppMethodBeat.o(152624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkl
 * JD-Core Version:    0.7.0.1
 */