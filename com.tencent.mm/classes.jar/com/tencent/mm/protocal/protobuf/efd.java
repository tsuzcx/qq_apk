package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efd
  extends erp
{
  public int IJG;
  public int YIq;
  public String abkA;
  public String abkB;
  public String abkz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259600);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YIq);
      paramVarArgs.bS(3, this.IJG);
      if (this.abkz != null) {
        paramVarArgs.g(4, this.abkz);
      }
      if (this.abkA != null) {
        paramVarArgs.g(5, this.abkA);
      }
      if (this.abkB != null) {
        paramVarArgs.g(6, this.abkB);
      }
      AppMethodBeat.o(259600);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label552;
      }
    }
    label552:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YIq) + i.a.a.b.b.a.cJ(3, this.IJG);
      paramInt = i;
      if (this.abkz != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abkz);
      }
      i = paramInt;
      if (this.abkA != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abkA);
      }
      paramInt = i;
      if (this.abkB != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abkB);
      }
      AppMethodBeat.o(259600);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259600);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        efd localefd = (efd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259600);
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
            localefd.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259600);
          return 0;
        case 2: 
          localefd.YIq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259600);
          return 0;
        case 3: 
          localefd.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259600);
          return 0;
        case 4: 
          localefd.abkz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259600);
          return 0;
        case 5: 
          localefd.abkA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259600);
          return 0;
        }
        localefd.abkB = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259600);
        return 0;
      }
      AppMethodBeat.o(259600);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efd
 * JD-Core Version:    0.7.0.1
 */