package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ech
  extends esc
{
  public String abhO;
  public int abhP;
  public long abhQ;
  public int hNv;
  public String hNw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257788);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hNv);
      if (this.hNw != null) {
        paramVarArgs.g(3, this.hNw);
      }
      if (this.abhO != null) {
        paramVarArgs.g(4, this.abhO);
      }
      paramVarArgs.bS(5, this.abhP);
      paramVarArgs.bv(100, this.abhQ);
      AppMethodBeat.o(257788);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label560;
      }
    }
    label560:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hNv);
      paramInt = i;
      if (this.hNw != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hNw);
      }
      i = paramInt;
      if (this.abhO != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abhO);
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.abhP);
      int j = i.a.a.b.b.a.q(100, this.abhQ);
      AppMethodBeat.o(257788);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257788);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ech localech = (ech)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257788);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localech.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(257788);
          return 0;
        case 2: 
          localech.hNv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257788);
          return 0;
        case 3: 
          localech.hNw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257788);
          return 0;
        case 4: 
          localech.abhO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257788);
          return 0;
        case 5: 
          localech.abhP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257788);
          return 0;
        }
        localech.abhQ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(257788);
        return 0;
      }
      AppMethodBeat.o(257788);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ech
 * JD-Core Version:    0.7.0.1
 */