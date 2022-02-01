package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class rg
  extends dyl
{
  public esi RZJ;
  public String RZK;
  public ds RZn;
  public int Sah;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91381);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RZJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: tock_mess");
        AppMethodBeat.o(91381);
        throw paramVarArgs;
      }
      if (this.RZn == null)
      {
        paramVarArgs = new b("Not all required fields were included: after_placeorder_comm_req");
        AppMethodBeat.o(91381);
        throw paramVarArgs;
      }
      if (this.token == null)
      {
        paramVarArgs = new b("Not all required fields were included: token");
        AppMethodBeat.o(91381);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RZJ != null)
      {
        paramVarArgs.oE(2, this.RZJ.computeSize());
        this.RZJ.writeFields(paramVarArgs);
      }
      if (this.RZn != null)
      {
        paramVarArgs.oE(3, this.RZn.computeSize());
        this.RZn.writeFields(paramVarArgs);
      }
      if (this.RZK != null) {
        paramVarArgs.f(4, this.RZK);
      }
      paramVarArgs.aY(5, this.Sah);
      if (this.token != null) {
        paramVarArgs.f(6, this.token);
      }
      AppMethodBeat.o(91381);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label864;
      }
    }
    label864:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RZJ != null) {
        paramInt = i + g.a.a.a.oD(2, this.RZJ.computeSize());
      }
      i = paramInt;
      if (this.RZn != null) {
        i = paramInt + g.a.a.a.oD(3, this.RZn.computeSize());
      }
      paramInt = i;
      if (this.RZK != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RZK);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Sah);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.token);
      }
      AppMethodBeat.o(91381);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RZJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: tock_mess");
          AppMethodBeat.o(91381);
          throw paramVarArgs;
        }
        if (this.RZn == null)
        {
          paramVarArgs = new b("Not all required fields were included: after_placeorder_comm_req");
          AppMethodBeat.o(91381);
          throw paramVarArgs;
        }
        if (this.token == null)
        {
          paramVarArgs = new b("Not all required fields were included: token");
          AppMethodBeat.o(91381);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91381);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        rg localrg = (rg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91381);
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
            localrg.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esi)localObject2).parseFrom((byte[])localObject1);
            }
            localrg.RZJ = ((esi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ds();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ds)localObject2).parseFrom((byte[])localObject1);
            }
            localrg.RZn = ((ds)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91381);
          return 0;
        case 4: 
          localrg.RZK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91381);
          return 0;
        case 5: 
          localrg.Sah = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91381);
          return 0;
        }
        localrg.token = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91381);
        return 0;
      }
      AppMethodBeat.o(91381);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rg
 * JD-Core Version:    0.7.0.1
 */