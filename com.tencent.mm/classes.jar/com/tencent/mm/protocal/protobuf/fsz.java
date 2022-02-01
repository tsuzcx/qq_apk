package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fsz
  extends erp
{
  public String MD5;
  public int NkN;
  public int NkO;
  public int NkP;
  public gol NkQ;
  public String UserName;
  public int YHj;
  public String abRk;
  public String oOI;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32484);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32484);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      paramVarArgs.bS(3, this.YHj);
      if (this.abRk != null) {
        paramVarArgs.g(4, this.abRk);
      }
      if (this.UserName != null) {
        paramVarArgs.g(5, this.UserName);
      }
      paramVarArgs.bS(6, this.NkN);
      paramVarArgs.bS(7, this.NkO);
      paramVarArgs.bS(8, this.NkP);
      if (this.NkQ != null)
      {
        paramVarArgs.qD(9, this.NkQ.computeSize());
        this.NkQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(10, this.vhJ);
      if (this.MD5 != null) {
        paramVarArgs.g(11, this.MD5);
      }
      AppMethodBeat.o(32484);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label951;
      }
    }
    label951:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.oOI);
      }
      i += i.a.a.b.b.a.cJ(3, this.YHj);
      paramInt = i;
      if (this.abRk != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abRk);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.UserName);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.NkN) + i.a.a.b.b.a.cJ(7, this.NkO) + i.a.a.b.b.a.cJ(8, this.NkP);
      paramInt = i;
      if (this.NkQ != null) {
        paramInt = i + i.a.a.a.qC(9, this.NkQ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.vhJ);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.MD5);
      }
      AppMethodBeat.o(32484);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.NkQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(32484);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32484);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fsz localfsz = (fsz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32484);
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
            localfsz.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32484);
          return 0;
        case 2: 
          localfsz.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 3: 
          localfsz.YHj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32484);
          return 0;
        case 4: 
          localfsz.abRk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 5: 
          localfsz.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 6: 
          localfsz.NkN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32484);
          return 0;
        case 7: 
          localfsz.NkO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32484);
          return 0;
        case 8: 
          localfsz.NkP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32484);
          return 0;
        case 9: 
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
            localfsz.NkQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32484);
          return 0;
        case 10: 
          localfsz.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32484);
          return 0;
        }
        localfsz.MD5 = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32484);
        return 0;
      }
      AppMethodBeat.o(32484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fsz
 * JD-Core Version:    0.7.0.1
 */