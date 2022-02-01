package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ftl
  extends erp
{
  public int NkN;
  public int NkO;
  public gol NkQ;
  public String UserName;
  public gol YKb;
  public int aasR;
  public String abRD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152717);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152717);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.NkN);
      paramVarArgs.bS(3, this.NkO);
      paramVarArgs.bS(4, this.aasR);
      if (this.NkQ != null)
      {
        paramVarArgs.qD(5, this.NkQ.computeSize());
        this.NkQ.writeFields(paramVarArgs);
      }
      if (this.abRD != null) {
        paramVarArgs.g(6, this.abRD);
      }
      if (this.UserName != null) {
        paramVarArgs.g(7, this.UserName);
      }
      if (this.YKb != null)
      {
        paramVarArgs.qD(8, this.YKb.computeSize());
        this.YKb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label852;
      }
    }
    label852:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.NkN) + i.a.a.b.b.a.cJ(3, this.NkO) + i.a.a.b.b.a.cJ(4, this.aasR);
      paramInt = i;
      if (this.NkQ != null) {
        paramInt = i + i.a.a.a.qC(5, this.NkQ.computeSize());
      }
      i = paramInt;
      if (this.abRD != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abRD);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.UserName);
      }
      i = paramInt;
      if (this.YKb != null) {
        i = paramInt + i.a.a.a.qC(8, this.YKb.computeSize());
      }
      AppMethodBeat.o(152717);
      return i;
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
          AppMethodBeat.o(152717);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152717);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ftl localftl = (ftl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152717);
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
            localftl.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152717);
          return 0;
        case 2: 
          localftl.NkN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152717);
          return 0;
        case 3: 
          localftl.NkO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152717);
          return 0;
        case 4: 
          localftl.aasR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152717);
          return 0;
        case 5: 
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
            localftl.NkQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152717);
          return 0;
        case 6: 
          localftl.abRD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152717);
          return 0;
        case 7: 
          localftl.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152717);
          return 0;
        }
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
          localftl.YKb = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152717);
        return 0;
      }
      AppMethodBeat.o(152717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ftl
 * JD-Core Version:    0.7.0.1
 */