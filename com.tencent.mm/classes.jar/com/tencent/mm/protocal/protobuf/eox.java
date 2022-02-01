package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eox
  extends erp
{
  public gol abtd;
  public gol abte;
  public int bUl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(129973);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abtd != null)
      {
        paramVarArgs.qD(2, this.abtd.computeSize());
        this.abtd.writeFields(paramVarArgs);
      }
      if (this.abte != null)
      {
        paramVarArgs.qD(3, this.abte.computeSize());
        this.abte.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.bUl);
      AppMethodBeat.o(129973);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label592;
      }
    }
    label592:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abtd != null) {
        paramInt = i + i.a.a.a.qC(2, this.abtd.computeSize());
      }
      i = paramInt;
      if (this.abte != null) {
        i = paramInt + i.a.a.a.qC(3, this.abte.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.bUl);
      AppMethodBeat.o(129973);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(129973);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eox localeox = (eox)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(129973);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localeox.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(129973);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localeox.abtd = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(129973);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localeox.abte = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(129973);
          return 0;
        }
        localeox.bUl = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(129973);
        return 0;
      }
      AppMethodBeat.o(129973);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eox
 * JD-Core Version:    0.7.0.1
 */