package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class erc
  extends dyl
{
  public eae TRP;
  public int TrD;
  public int TrE;
  public eae TrF;
  public String Uto;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91711);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TrF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqText");
        AppMethodBeat.o(91711);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TrD);
      paramVarArgs.aY(3, this.TrE);
      if (this.TrF != null)
      {
        paramVarArgs.oE(4, this.TrF.computeSize());
        this.TrF.writeFields(paramVarArgs);
      }
      if (this.TRP != null)
      {
        paramVarArgs.oE(5, this.TRP.computeSize());
        this.TRP.writeFields(paramVarArgs);
      }
      if (this.sign != null) {
        paramVarArgs.f(6, this.sign);
      }
      if (this.Uto != null) {
        paramVarArgs.f(7, this.Uto);
      }
      AppMethodBeat.o(91711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label812;
      }
    }
    label812:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TrD) + g.a.a.b.b.a.bM(3, this.TrE);
      paramInt = i;
      if (this.TrF != null) {
        paramInt = i + g.a.a.a.oD(4, this.TrF.computeSize());
      }
      i = paramInt;
      if (this.TRP != null) {
        i = paramInt + g.a.a.a.oD(5, this.TRP.computeSize());
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.sign);
      }
      i = paramInt;
      if (this.Uto != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Uto);
      }
      AppMethodBeat.o(91711);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TrF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqText");
          AppMethodBeat.o(91711);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91711);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        erc localerc = (erc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91711);
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
            localerc.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 2: 
          localerc.TrD = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91711);
          return 0;
        case 3: 
          localerc.TrE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91711);
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
            localerc.TrF = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 5: 
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
            localerc.TRP = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 6: 
          localerc.sign = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91711);
          return 0;
        }
        localerc.Uto = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91711);
        return 0;
      }
      AppMethodBeat.o(91711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erc
 * JD-Core Version:    0.7.0.1
 */