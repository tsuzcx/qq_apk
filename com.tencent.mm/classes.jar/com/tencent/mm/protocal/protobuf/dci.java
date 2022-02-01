package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dci
  extends dyl
{
  public eae TJJ;
  public eae TJK;
  public String UserName;
  public String vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133181);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TJJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
        AppMethodBeat.o(133181);
        throw paramVarArgs;
      }
      if (this.TJK == null)
      {
        paramVarArgs = new b("Not all required fields were included: MaxSynckey");
        AppMethodBeat.o(133181);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      if (this.TJJ != null)
      {
        paramVarArgs.oE(3, this.TJJ.computeSize());
        this.TJJ.writeFields(paramVarArgs);
      }
      if (this.TJK != null)
      {
        paramVarArgs.oE(4, this.TJK.computeSize());
        this.TJK.writeFields(paramVarArgs);
      }
      if (this.vhq != null) {
        paramVarArgs.f(5, this.vhq);
      }
      AppMethodBeat.o(133181);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label768;
      }
    }
    label768:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = paramInt;
      if (this.TJJ != null) {
        i = paramInt + g.a.a.a.oD(3, this.TJJ.computeSize());
      }
      paramInt = i;
      if (this.TJK != null) {
        paramInt = i + g.a.a.a.oD(4, this.TJK.computeSize());
      }
      i = paramInt;
      if (this.vhq != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.vhq);
      }
      AppMethodBeat.o(133181);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TJJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
          AppMethodBeat.o(133181);
          throw paramVarArgs;
        }
        if (this.TJK == null)
        {
          paramVarArgs = new b("Not all required fields were included: MaxSynckey");
          AppMethodBeat.o(133181);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133181);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dci localdci = (dci)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133181);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localdci.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133181);
          return 0;
        case 2: 
          localdci.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133181);
          return 0;
        case 3: 
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
            localdci.TJJ = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133181);
          return 0;
        case 4: 
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
            localdci.TJK = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133181);
          return 0;
        }
        localdci.vhq = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(133181);
        return 0;
      }
      AppMethodBeat.o(133181);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dci
 * JD-Core Version:    0.7.0.1
 */