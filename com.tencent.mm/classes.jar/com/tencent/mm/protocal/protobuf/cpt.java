package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpt
  extends erp
{
  public String aawn;
  public String aawo;
  public String vid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116454);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.vid != null) {
        paramVarArgs.g(2, this.vid);
      }
      if (this.aawn != null) {
        paramVarArgs.g(3, this.aawn);
      }
      if (this.aawo != null) {
        paramVarArgs.g(4, this.aawo);
      }
      AppMethodBeat.o(116454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label464;
      }
    }
    label464:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vid);
      }
      i = paramInt;
      if (this.aawn != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aawn);
      }
      paramInt = i;
      if (this.aawo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aawo);
      }
      AppMethodBeat.o(116454);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116454);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cpt localcpt = (cpt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116454);
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
            localcpt.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(116454);
          return 0;
        case 2: 
          localcpt.vid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116454);
          return 0;
        case 3: 
          localcpt.aawn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116454);
          return 0;
        }
        localcpt.aawo = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(116454);
        return 0;
      }
      AppMethodBeat.o(116454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpt
 * JD-Core Version:    0.7.0.1
 */