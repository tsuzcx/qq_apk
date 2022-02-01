package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fta
  extends esc
{
  public int CreateTime;
  public int NkN;
  public int NkO;
  public int NkP;
  public String UserName;
  public String abRk;
  public String oOI;
  public String oOL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32485);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32485);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      if (this.oOL != null) {
        paramVarArgs.g(3, this.oOL);
      }
      if (this.abRk != null) {
        paramVarArgs.g(4, this.abRk);
      }
      if (this.UserName != null) {
        paramVarArgs.g(5, this.UserName);
      }
      paramVarArgs.bS(6, this.NkN);
      paramVarArgs.bS(7, this.NkO);
      paramVarArgs.bS(8, this.NkP);
      paramVarArgs.bS(9, this.CreateTime);
      AppMethodBeat.o(32485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label779;
      }
    }
    label779:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt;
      if (this.oOL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.oOL);
      }
      paramInt = i;
      if (this.abRk != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abRk);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.UserName);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.NkN);
      int j = i.a.a.b.b.a.cJ(7, this.NkO);
      int k = i.a.a.b.b.a.cJ(8, this.NkP);
      int m = i.a.a.b.b.a.cJ(9, this.CreateTime);
      AppMethodBeat.o(32485);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fta localfta = (fta)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32485);
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
            localfta.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(32485);
          return 0;
        case 2: 
          localfta.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 3: 
          localfta.oOL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 4: 
          localfta.abRk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 5: 
          localfta.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 6: 
          localfta.NkN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32485);
          return 0;
        case 7: 
          localfta.NkO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32485);
          return 0;
        case 8: 
          localfta.NkP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32485);
          return 0;
        }
        localfta.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32485);
        return 0;
      }
      AppMethodBeat.o(32485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fta
 * JD-Core Version:    0.7.0.1
 */