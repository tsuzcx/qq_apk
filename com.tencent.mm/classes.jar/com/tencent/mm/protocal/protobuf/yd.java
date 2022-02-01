package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yd
  extends erp
{
  public String Oln;
  public String ZgS;
  public String ZgT;
  public String ZgU;
  public int amount;
  public String hMy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72435);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hMy != null) {
        paramVarArgs.g(2, this.hMy);
      }
      if (this.ZgU != null) {
        paramVarArgs.g(3, this.ZgU);
      }
      if (this.Oln != null) {
        paramVarArgs.g(4, this.Oln);
      }
      paramVarArgs.bS(5, this.amount);
      if (this.ZgT != null) {
        paramVarArgs.g(6, this.ZgT);
      }
      if (this.ZgS != null) {
        paramVarArgs.g(7, this.ZgS);
      }
      AppMethodBeat.o(72435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label632;
      }
    }
    label632:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hMy != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hMy);
      }
      i = paramInt;
      if (this.ZgU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZgU);
      }
      paramInt = i;
      if (this.Oln != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Oln);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.amount);
      paramInt = i;
      if (this.ZgT != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZgT);
      }
      i = paramInt;
      if (this.ZgS != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZgS);
      }
      AppMethodBeat.o(72435);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        yd localyd = (yd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72435);
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
            localyd.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72435);
          return 0;
        case 2: 
          localyd.hMy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 3: 
          localyd.ZgU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 4: 
          localyd.Oln = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 5: 
          localyd.amount = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72435);
          return 0;
        case 6: 
          localyd.ZgT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72435);
          return 0;
        }
        localyd.ZgS = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72435);
        return 0;
      }
      AppMethodBeat.o(72435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yd
 * JD-Core Version:    0.7.0.1
 */