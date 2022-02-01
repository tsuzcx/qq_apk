package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class aox
  extends erp
{
  public int IJG;
  public int OzG;
  public String nUB;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259644);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nUB == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(259644);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vhJ);
      paramVarArgs.bS(3, this.IJG);
      paramVarArgs.bS(4, this.OzG);
      if (this.nUB != null) {
        paramVarArgs.g(5, this.nUB);
      }
      AppMethodBeat.o(259644);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label520;
      }
    }
    label520:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhJ) + i.a.a.b.b.a.cJ(3, this.IJG) + i.a.a.b.b.a.cJ(4, this.OzG);
      paramInt = i;
      if (this.nUB != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.nUB);
      }
      AppMethodBeat.o(259644);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.nUB == null)
        {
          paramVarArgs = new b("Not all required fields were included: Content");
          AppMethodBeat.o(259644);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259644);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aox localaox = (aox)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259644);
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
            localaox.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259644);
          return 0;
        case 2: 
          localaox.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259644);
          return 0;
        case 3: 
          localaox.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259644);
          return 0;
        case 4: 
          localaox.OzG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259644);
          return 0;
        }
        localaox.nUB = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259644);
        return 0;
      }
      AppMethodBeat.o(259644);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aox
 * JD-Core Version:    0.7.0.1
 */