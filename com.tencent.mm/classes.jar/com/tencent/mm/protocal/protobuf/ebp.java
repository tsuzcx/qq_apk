package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebp
  extends erp
{
  public String MEX;
  public int MFe;
  public String MFp;
  public bi Zbi;
  public int abhg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91575);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abhg);
      if (this.MEX != null) {
        paramVarArgs.g(3, this.MEX);
      }
      paramVarArgs.bS(4, this.MFe);
      if (this.MFp != null) {
        paramVarArgs.g(5, this.MFp);
      }
      if (this.Zbi != null)
      {
        paramVarArgs.qD(6, this.Zbi.computeSize());
        this.Zbi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91575);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abhg);
      paramInt = i;
      if (this.MEX != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.MEX);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.MFe);
      paramInt = i;
      if (this.MFp != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.MFp);
      }
      i = paramInt;
      if (this.Zbi != null) {
        i = paramInt + i.a.a.a.qC(6, this.Zbi.computeSize());
      }
      AppMethodBeat.o(91575);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91575);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ebp localebp = (ebp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91575);
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
            localebp.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91575);
          return 0;
        case 2: 
          localebp.abhg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91575);
          return 0;
        case 3: 
          localebp.MEX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91575);
          return 0;
        case 4: 
          localebp.MFe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91575);
          return 0;
        case 5: 
          localebp.MFp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91575);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bi)localObject2).parseFrom((byte[])localObject1);
          }
          localebp.Zbi = ((bi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91575);
        return 0;
      }
      AppMethodBeat.o(91575);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebp
 * JD-Core Version:    0.7.0.1
 */