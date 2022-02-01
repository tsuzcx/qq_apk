package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ek
  extends erp
{
  public int IKW;
  public long YGA;
  public String YGy;
  public String YGz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258982);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YGy != null) {
        paramVarArgs.g(2, this.YGy);
      }
      if (this.YGz != null) {
        paramVarArgs.g(3, this.YGz);
      }
      paramVarArgs.bS(4, this.IKW);
      paramVarArgs.bv(5, this.YGA);
      AppMethodBeat.o(258982);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label496;
      }
    }
    label496:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YGy != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YGy);
      }
      i = paramInt;
      if (this.YGz != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YGz);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.IKW);
      int j = i.a.a.b.b.a.q(5, this.YGA);
      AppMethodBeat.o(258982);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258982);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ek localek = (ek)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258982);
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
            localek.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(258982);
          return 0;
        case 2: 
          localek.YGy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258982);
          return 0;
        case 3: 
          localek.YGz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258982);
          return 0;
        case 4: 
          localek.IKW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258982);
          return 0;
        }
        localek.YGA = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258982);
        return 0;
      }
      AppMethodBeat.o(258982);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ek
 * JD-Core Version:    0.7.0.1
 */