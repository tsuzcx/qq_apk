package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cvc
  extends com.tencent.mm.cd.a
{
  public aiq RMV;
  public eae RQU;
  public String RRg;
  public String RRt;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133178);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RQU == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(133178);
        throw paramVarArgs;
      }
      if (this.RMV == null)
      {
        paramVarArgs = new b("Not all required fields were included: CliPubECDHKey");
        AppMethodBeat.o(133178);
        throw paramVarArgs;
      }
      if (this.RQU != null)
      {
        paramVarArgs.oE(1, this.RQU.computeSize());
        this.RQU.writeFields(paramVarArgs);
      }
      if (this.RMV != null)
      {
        paramVarArgs.oE(2, this.RMV.computeSize());
        this.RMV.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.f(3, this.UserName);
      }
      if (this.RRg != null) {
        paramVarArgs.f(4, this.RRg);
      }
      if (this.RRt != null) {
        paramVarArgs.f(5, this.RRt);
      }
      AppMethodBeat.o(133178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RQU == null) {
        break label698;
      }
    }
    label698:
    for (int i = g.a.a.a.oD(1, this.RQU.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RMV != null) {
        paramInt = i + g.a.a.a.oD(2, this.RMV.computeSize());
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UserName);
      }
      paramInt = i;
      if (this.RRg != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RRg);
      }
      i = paramInt;
      if (this.RRt != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RRt);
      }
      AppMethodBeat.o(133178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RQU == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(133178);
          throw paramVarArgs;
        }
        if (this.RMV == null)
        {
          paramVarArgs = new b("Not all required fields were included: CliPubECDHKey");
          AppMethodBeat.o(133178);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133178);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cvc localcvc = (cvc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133178);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localcvc.RQU = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133178);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aiq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aiq)localObject2).parseFrom((byte[])localObject1);
            }
            localcvc.RMV = ((aiq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133178);
          return 0;
        case 3: 
          localcvc.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133178);
          return 0;
        case 4: 
          localcvc.RRg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133178);
          return 0;
        }
        localcvc.RRt = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(133178);
        return 0;
      }
      AppMethodBeat.o(133178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvc
 * JD-Core Version:    0.7.0.1
 */